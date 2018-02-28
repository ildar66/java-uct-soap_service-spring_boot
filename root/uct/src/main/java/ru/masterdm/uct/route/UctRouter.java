package ru.masterdm.uct.route;

import java.nio.charset.Charset;
import java.sql.SQLException;

import org.apache.camel.Exchange;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import ru.masterdm.uct.entity.ErrorCode;
import ru.masterdm.uct.route.components.EntityProcessor;
import ru.masterdm.uct.route.components.EventProcessor;
import ru.masterdm.uct.route.components.SchemaProcessor;

/**
 * Routes descriptions.
 */
@Component
public class UctRouter extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        // @formatter:off
        from("direct:importDocument")
            .setHeader("document", body())
            .to("mybatis:selectDocScheme?statementType=SelectOne&outputHeader=xsd")
            .choice()
                .when(header("xsd").isNull())
                    .bean(EntityProcessor.class, "createEvent(${type:ru.masterdm.uct.entity.ErrorCode.IMPORT_DOCUMENT_WRONG_VALUE},"
                            + "'XSD not found: docVersion=${header.document.docVersion}, docScheme=${header.document.docScheme}')")
                    .log(LoggingLevel.INFO, LoggerFactory.getLogger("journal"),
                            "${body.bsErrorCode} custID=${header.document.custID}, remoteUser=${header.document.remoteUser},"
                             + " error=${body.bsError}, ").stop()
            .end()
            .bean(SchemaProcessor.class, "validate(${header.document.docData},${header.xsd})")
            .choice()
                .when(body().isNotEqualTo("true"))
                    .bean(EntityProcessor.class, "createEvent(${type:ru.masterdm.uct.entity.ErrorCode.IMPORT_DOCUMENT_INVALID_XML},${body})")
                    .log(LoggingLevel.INFO, LoggerFactory.getLogger("journal"),
                            "${body.bsErrorCode} custID=${header.document.custID}, remoteUser=${header.document.remoteUser},"
                             + " error=${body.bsError}").stop()
            .end()
            .setBody(simple("${header.document}"))
            .doTry()
                .to("mybatis:insertDocument?statementType=Insert")
            .doCatch(SQLException.class)
                .bean(EntityProcessor.class, "createEvent(${type:ru.masterdm.uct.entity.ErrorCode.IMPORT_DOCUMENT_DB_ERROR},${exception.message})")
                .log(LoggingLevel.INFO, LoggerFactory.getLogger("journal"), "${body.bsErrorCode} custID=${header.document.custID},"
                        + " remoteUser=${header.document.remoteUser}, docVersion=${header.document.docVersion},"
                        + " docScheme=${header.document.docScheme}, error=${body.bsError}")
                .stop()
            .end()
            .log(LoggingLevel.INFO, LoggerFactory.getLogger("journal"), ErrorCode.IMPORT_DOCUMENT_SUCCESS.getCode()
                    + " custID=${body.custID}, recordID=${body.recordID}, remoteUser=${body.remoteUser}");
        // @formatter:on

        // @formatter:off
        from("direct:getCustomerCustsAndBranches")
            // .setHeader("remoteUser", body())
            .setHeader("document", body())
            .to("mybatis:selectCertificate?statementType=SelectOne")
            .choice()
                .when(body().isNull())
                    .bean(EventProcessor.class, "createEvent(${type:ru.masterdm.uct.entity.ErrorCode.WRONG_CERTIFICATE},"
                            + "'Certificate not found: remoteUser=${header.document.remoteUser}')")
                    .log(LoggingLevel.INFO, LoggerFactory.getLogger("journal"),
                            "${body.bsErrorCode} remoteUser=${header.document.remoteUser},"
                             + " error=${body.bsError}, ").stop()
            .end()
            .to("mybatis:selectCustomers?statementType=SelectList")
            .bean(EntityProcessor.class, "createCustomers(${body})")
            .setProperty(Exchange.CHARSET_NAME, simple(Charset.forName("windows-1251").name()))
            .marshal().jaxb()
            .bean(SchemaProcessor.class, "removeNilAttribute")
            .convertBodyTo(String.class, "windows-1251")
            .log(LoggingLevel.INFO, LoggerFactory.getLogger("journal"), ErrorCode.GET_CUSTOMER_SUCCESS.getCode()
                    + " remoteUser=${header.remoteUser}");
        // @formatter:on

        // @formatter:off
        from("direct:getCustomerAccounts")
            .setHeader("request", body())
            .to("mybatis:selectCustomer?statementType=SelectOne&outputHeader=customer")
            .to("mybatis:selectBranch?statementType=SelectOne&outputHeader=branch")
            .to("mybatisSbc:selectAccounts?statementType=SelectList")
            .bean(EntityProcessor.class, "createAndFillAccounts(${body},${header.branch},${header.customer})")
            .setProperty(Exchange.CHARSET_NAME, simple(Charset.forName("windows-1251").name()))
            .marshal().jaxb()
            .convertBodyTo(String.class, "windows-1251")
            .log(LoggingLevel.INFO, LoggerFactory.getLogger("journal"), ErrorCode.GET_CUSTOMER_SUCCESS.getCode()
                    + " custID=${header.request['custId']}, account=${header.request['account']}, remoteUser=${header.request['remoteUser']}");
        // @formatter:on

        // @formatter:off
        from("direct:checkClient")
            .setHeader("document", body())
            .to("mybatis:selectClient?statementType=SelectOne&outputHeader=client")
            .choice()
                .when(header("client").isNull())
                    .bean(EventProcessor.class, "createEvent(${type:ru.masterdm.uct.entity.ErrorCode.WRONG_CLIENT},"
                            + "'Client not found: custID=${header.document.custID}, remoteUser=${header.document.remoteUser}')")
                    .log(LoggingLevel.INFO, LoggerFactory.getLogger("journal"),
                            "${body.bsErrorCode} custID=${header.document.custID}, remoteUser=${header.document.remoteUser},"
                             + " error=${body.bsError}, ").stop()
            .end();
        // @formatter:on

        // @formatter:off
        from("direct:getDocStatus").
             setHeader("document", body())
            .to("mybatis:selectDocument?statementType=SelectOne")
            .choice()
                .when(body().isNull())
                    .bean(EventProcessor.class, "createEvent(${type:ru.masterdm.uct.entity.ErrorCode.GET_DOC_STATUS_NO_DOCUMENT},"
                         + "'Document not found: RecordID=${header.document.recordID}, docScheme=${header.document.docScheme}')")
                    .log(LoggingLevel.INFO, LoggerFactory.getLogger("journal"),
                            "${body.bsErrorCode} custID=${header.document.custID}, remoteUser=${header.document.remoteUser},"
                             + " error=${body.bsError}").stop()
            .end()
            .bean(EventProcessor.class, "calcDocStatus(${body})")
            .end()
            .log(LoggingLevel.INFO, LoggerFactory.getLogger("journal"), ErrorCode.GET_DOC_STATUS_SUCCESS.getCode()
                + " custID=${header.document.custID}, recordID=${header.document.recordID}, remoteUser=${header.document.remoteUser}");
        // @formatter:on

        // @formatter:off
        from("direct:getFreeBankDoc")
            .setHeader("document", body())
            .to("mybatis:selectCertificate?statementType=SelectOne&outputHeader=certificate")
            .choice()
                .when(header("certificate").isNull())
                    .bean(EventProcessor.class, "createEvent(${type:ru.masterdm.uct.entity.ErrorCode.GET_FREE_BANK_DOC_WRONG_CERTIFICATE},"
                            + "'Certificate not found: custID=${header.document.custID}, remoteUser=${header.document.remoteUser}')")
                    .log(LoggingLevel.INFO, LoggerFactory.getLogger("journal"),
                            "${body.bsErrorCode} custID=${header.document.custID}, remoteUser=${header.document.remoteUser},"
                             + " error=${body.bsError}, ").stop()
            .end()
            .to("mybatis:selectClient?statementType=SelectOne&outputHeader=client")
            .choice()
                .when(header("client").isNull())
                    .bean(EventProcessor.class, "createEvent(${type:ru.masterdm.uct.entity.ErrorCode.GET_FREE_BANK_DOC_NO_CLIENT},"
                            + "'Client not found: custID=${header.document.custID}, docScheme=${header.document.docScheme}')")
                    .log(LoggingLevel.INFO, LoggerFactory.getLogger("journal"),
                            "${body.bsErrorCode} custID=${header.document.custID}, remoteUser=${header.document.remoteUser},"
                             + " error=${body.bsError}, ").stop()
            .end()
            .to("mybatis:selectFreeBankDoc?statementType=SelectOne&outputHeader=freeBankDoc")
            .setBody(simple("${header.freeBankDoc}"))
            .choice()
                .when(body().isNull())
                    .bean(EventProcessor.class, "createEvent(${type:ru.masterdm.uct.entity.ErrorCode.GET_FREE_BANK_DOC_NO_DOCUMENT},"
                         + "'Document not found: RecordID=${header.document.recordID}')")
                    .log(LoggingLevel.INFO, LoggerFactory.getLogger("journal"),
                            "${body.bsErrorCode} custID=${header.document.custID}, remoteUser=${header.document.remoteUser},"
                             + " error=${body.bsError}").stop()
            .end()
            .convertBodyTo(String.class, "windows-1251")
            .bean(EventProcessor.class, "processFreeBankDoc(${body}, ${header.document}, ${header.freeBankDoc})")
            .end()
            .log(LoggingLevel.INFO, LoggerFactory.getLogger("journal"), ErrorCode.GET_FREE_BANK_DOC_SUCCESS.getCode()
                + " custID=${header.document.custID}, recordID=${header.document.recordID}, remoteUser=${header.document.remoteUser}");
        // @formatter:on

        // @formatter:off
        from("direct:getFreeBankDocList")
            .setHeader("document", body())
            .to("mybatis:selectCertificate?statementType=SelectOne&outputHeader=certificate")
            .choice()
                .when(header("certificate").isNull())
                    .bean(EventProcessor.class, "createEvent(${type:ru.masterdm.uct.entity.ErrorCode.GET_FREE_BANK_DOC_LIST_WRONG_CERTIFICATE},"
                            + "'Certificate not found: custID=${header.document.custID}, remoteUser=${header.document.remoteUser}')")
                    .log(LoggingLevel.INFO, LoggerFactory.getLogger("journal"),
                            "${body.bsErrorCode} custID=${header.document.custID}, remoteUser=${header.document.remoteUser},"
                             + " error=${body.bsError}, ").stop()
            .end()
            .to("mybatis:selectClient?statementType=SelectOne&outputHeader=client")
            .choice()
                .when(header("client").isNull())
                    .bean(EventProcessor.class, "createEvent(${type:ru.masterdm.uct.entity.ErrorCode.GET_FREE_BANK_DOC_LIST_NO_CLIENT},"
                            + "'Client not found: custID=${header.document.custID}')")
                    .log(LoggingLevel.INFO, LoggerFactory.getLogger("journal"),
                            "${body.bsErrorCode} custID=${header.document.custID}, remoteUser=${header.document.remoteUser},"
                             + " error=${body.bsError}, ").stop()
            .end()
            .to("mybatis:selectFreeBankDocList?statementType=SelectList")
            .bean(EventProcessor.class, "createAndFillFreeBankDocs(${body},${header.document})")
            .convertBodyTo(String.class, "windows-1251")
            .end()
            .log(LoggingLevel.INFO, LoggerFactory.getLogger("journal"), ErrorCode.GET_FREE_BANK_DOC_LIST_SUCCESS.getCode()
                + " custID=${header.document.custID}, remoteUser=${header.document.remoteUser}");
        // @formatter:on

        // @formatter:off
        from("direct:checkCertificate")
            .setHeader("document", body())
            .to("mybatis:selectCertificate?statementType=SelectOne&outputHeader=certificate")
            .choice()
                .when(header("certificate").isNull())
                    .bean(EventProcessor.class, "createEvent(${type:ru.masterdm.uct.entity.ErrorCode.WRONG_CERTIFICATE},"
                            + "'Certificate not found: custID=${header.document.custID}, remoteUser=${header.document.remoteUser}')")
                    .log(LoggingLevel.INFO, LoggerFactory.getLogger("journal"),
                            "${body.bsErrorCode} custID=${header.document.custID}, remoteUser=${header.document.remoteUser},"
                             + " error=${body.bsError}, ").stop()
            .end();
        // @formatter:on

        // @formatter:off
        from("direct:getStatement")
            .setHeader("document", body())
            .to("mybatis:selectClient?statementType=SelectOne&outputHeader=client")
            .choice()
                .when(header("client").isNull())
                    .bean(EventProcessor.class, "createEvent(${type:ru.masterdm.uct.entity.ErrorCode.GET_STATEMENT_NO_CLIENT},"
                            + "'Client not found: custID=${header.document.custID}, remoteUser=${header.document.remoteUser}')")
                    .log(LoggingLevel.INFO, LoggerFactory.getLogger("journal"),
                            "${body.bsErrorCode} custID=${header.document.custID}, remoteUser=${header.document.remoteUser},"
                             + " error=${body.bsError}, ").stop()
            .end()
            .to("mybatis:selectStatementDoc?statementType=SelectOne&outputHeader=statementDoc")
            .setBody(simple("${header.statementDoc}"))
            .choice()
                .when(body().isNull())
                    /*.bean(EventProcessor.class, "createEvent(${type:ru.masterdm.uct.entity.ErrorCode.GET_STATEMENT_NO_DOCUMENT},"
                         + "'Statement not found: CustID=${header.document.custID}, Account=${header.document.account},"
                         + " StatementType=${header.document.type}, StatementDate=${header.document.documentDate}')")
                    .log(LoggingLevel.INFO, LoggerFactory.getLogger("journal"),
                            "${body.bsErrorCode} custID=${header.document.custID}, remoteUser=${header.document.remoteUser},"
                             + " error=${body.bsError}").stop()*/
                    .bean(EventProcessor.class, "processEmptyStatementDoc(${header.document})")
                .otherwise()
                    .convertBodyTo(String.class, "windows-1251")
                    .bean(EventProcessor.class, "processStatementDoc(${body}, ${header.document}, ${header.statementDoc})")
            .end()
            .log(LoggingLevel.INFO, LoggerFactory.getLogger("journal"), ErrorCode.GET_STATEMENT_SUCCESS.getCode()
                + " custID=${header.document.custID}, remoteUser=${header.document.remoteUser}");
        // @formatter:on

        // @formatter:off
        from("direct:prepareDocForCancel")
            .setHeader("document", body())
            .to("mybatis:selectDocument?statementType=SelectOne")
            .choice()
                .when(body().isNull())
                    .bean(EventProcessor.class, "createEvent(${type:ru.masterdm.uct.entity.ErrorCode.PREPARE_DOC_FOR_CANCEL_NO_DOCUMENT},"
                         + "'Document not found: RecordID=${header.document.recordID}, docScheme=${header.document.docScheme}')")
                    .log(LoggingLevel.INFO, LoggerFactory.getLogger("journal"),
                            "${body.bsErrorCode} custID=${header.document.custID}, remoteUser=${header.document.remoteUser},"
                             + " error=${body.bsError}").stop()
            .end()
            .bean(EventProcessor.class, "processDocForCancel(${body})")
            .end()
            .log(LoggingLevel.INFO, LoggerFactory.getLogger("journal"), ErrorCode.PREPARE_DOC_FOR_CANCEL_SUCCESS.getCode()
                + " custID=${header.document.custID}, remoteUser=${header.document.remoteUser}");
        // @formatter:on
    }
}
