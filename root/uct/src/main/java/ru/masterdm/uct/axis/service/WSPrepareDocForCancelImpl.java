/**
 * WSPrepareDocForCancelImpl.java
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

import ru.masterdm.uct.axis.ws.WSPrepareDocForCancel;
import ru.masterdm.uct.entity.Document;
import ru.masterdm.uct.entity.Event;

/**
 * WSPrepareDocForCancel Spring service.
 */
@Service("wsPrepareDocForCancel")
public class WSPrepareDocForCancelImpl implements WSPrepareDocForCancel {

    @BeanInject
    private ProducerTemplate producerTemplate;

    private static final Logger LOG = LoggerFactory.getLogger(WSPrepareDocForCancelImpl.class);

    /**
     * Prepares doc for cancel.
     * @param bsError bsError
     * @param bsErrorCode bsErrorCode
     * @param cancelFields cancelFields
     * @param custID custID
     * @param docScheme docScheme
     * @param recordID recordID
     * @param remoteUser remoteUser
     * @throws RemoteException RemoteException
     */
    public void prepareDocForCancel(StringHolder bsError, StringHolder bsErrorCode, StringHolder cancelFields, int custID, String docScheme,
                                    String recordID, String remoteUser) throws RemoteException {
        try {
            Document doc = new Document(null, docScheme, -1, custID, null, remoteUser);
            doc.setRecordID(recordID);
            Object obj = producerTemplate.requestBody("direct:checkCertificate", doc);
            if (obj instanceof Event) {
                fillErrorResult(bsError, bsErrorCode, cancelFields, (Event) obj);
                return;
            }
            obj = producerTemplate.requestBody("direct:checkClient", doc);
            if (obj instanceof Event) {
                fillErrorResult(bsError, bsErrorCode, cancelFields, (Event) obj);
                return;
            }
            obj = producerTemplate.requestBody("direct:prepareDocForCancel", doc);
            if (obj instanceof Document) {
                fillSuccessResult(bsError, bsErrorCode, cancelFields, (Document) obj);
            } else if (obj instanceof Event) {
                fillErrorResult(bsError, bsErrorCode, cancelFields, (Event) obj);
            }
        } catch (Exception e) {
            LOG.error("Execution error", e);
            bsErrorCode.value = "false";
            bsError.value = e.getMessage();
        }

    }

    /**
     * Fill success result.
     * @param bsError error
     * @param bsErrorCode error code
     * @param cancelFields cancel Fields for document
     * @param document document result.
     */
    private void fillSuccessResult(StringHolder bsError, StringHolder bsErrorCode, StringHolder cancelFields, Document document) {
        cancelFields.value = document.getCancelFields();
        bsError.value = null;
        bsErrorCode.value = null;
    }

    /**
     * Fill error result execution.
     * @param bsError error
     * @param bsErrorCode error code
     * @param cancelFields cancel Fields for document
     * @param result obj result.
     */
    private void fillErrorResult(StringHolder bsError, StringHolder bsErrorCode, StringHolder cancelFields, Event result) {
        cancelFields.value = "";
        bsError.value = result.getBsError();
        bsErrorCode.value = result.getBsErrorCode();
    }

}