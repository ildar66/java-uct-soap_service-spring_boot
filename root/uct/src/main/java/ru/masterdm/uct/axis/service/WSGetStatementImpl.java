/**
 * WSGetStatementImpl.java
 * <p>
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package ru.masterdm.uct.axis.service;

import java.rmi.RemoteException;

import javax.xml.rpc.holders.StringHolder;

import org.apache.camel.BeanInject;
import org.apache.camel.ProducerTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import ru.masterdm.uct.axis.ws.WSGetStatement;
import ru.masterdm.uct.entity.Document;
import ru.masterdm.uct.entity.Event;
import ru.masterdm.uct.entity.Statement;

/**
 * WSGetStatement Spring service.
 */
@Service("wsGetStatement")
public class WSGetStatementImpl implements WSGetStatement {

    @BeanInject
    private ProducerTemplate producerTemplate;

    private static final Logger LOG = LoggerFactory.getLogger(WSGetStatementImpl.class);

    /**
     * Returns statement.
     * @param account account
     * @param bic bic
     * @param bsError bsError
     * @param bsErrorCode bsErrorCode
     * @param custID custID
     * @param remoteUser remoteUser
     * @param signData signData
     * @param statementDate statementDate
     * @param statementDoc statementDoc
     * @param statementType statementType
     * @throws RemoteException RemoteException
     */
    public void getStatement(String account, String bic, StringHolder bsError, StringHolder bsErrorCode, int custID, String remoteUser,
                             StringHolder signData, java.util.Date statementDate, StringHolder statementDoc, int statementType)
            throws RemoteException {
        try {
            Document doc = new Document(null, null, -1, custID, null, remoteUser);
            doc.setDocumentDate(statementDate);
            Object obj = producerTemplate.requestBody("direct:checkCertificate", doc);
            if (obj instanceof Event) {
                fillErrorResult(bsError, bsErrorCode, statementDoc, (Event) obj);
            } else {
                doc = new Statement(doc, account, statementType);
                obj = producerTemplate.requestBody("direct:getStatement", doc);
                if (obj instanceof Document) {
                    doc = (Document) obj;
                    statementDoc.value = doc.getDocData();
                    signData.value = doc.getSignData();
                    bsError.value = null;
                    bsErrorCode.value = null;
                } else if (obj instanceof Event) {
                    fillErrorResult(bsError, bsErrorCode, statementDoc, (Event) obj);
                }
            }
        } catch (Exception e) {
            LOG.error("Execution error", e);
            bsErrorCode.value = "false";
            bsError.value = e.getMessage();
        }

    }

    /**
     * Fill error result execution.
     * @param bsError error
     * @param bsErrorCode error code
     * @param statementDoc statement Document
     * @param result obj result.
     */
    private void fillErrorResult(StringHolder bsError, StringHolder bsErrorCode, StringHolder statementDoc, Event result) {
        statementDoc.value = "";
        bsError.value = result.getBsError();
        bsErrorCode.value = result.getBsErrorCode();
    }

}
