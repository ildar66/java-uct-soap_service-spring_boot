/**
 * WSGetDocStatusImpl.java
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

import ru.masterdm.uct.axis.ws.WSGetDocStatus;
import ru.masterdm.uct.entity.Document;
import ru.masterdm.uct.entity.Event;

/**
 * WSGetDocStatus Spring service.
 */
@Service("wsGetDocStatus")
public class WSGetDocStatusImpl implements WSGetDocStatus {

    @BeanInject
    private ProducerTemplate producerTemplate;

    private static final Logger LOG = LoggerFactory.getLogger(WSGetDocStatusImpl.class);

    /**
     * Returns doc status.
     * @param bsError bsError
     * @param bsErrorCode bsErrorCode
     * @param custID custID
     * @param docInfo docInfo
     * @param docScheme docScheme
     * @param docStatus docStatus
     * @param recordID recordID
     * @param remoteUser remoteUser
     * @throws RemoteException RemoteException
     */
    public void getDocStatus(StringHolder bsError, StringHolder bsErrorCode, int custID, StringHolder docInfo, String docScheme,
                             StringHolder docStatus, String recordID, String remoteUser) throws RemoteException {
        try {
            Document docBody = new Document(null, docScheme, -1, custID, null, remoteUser);
            docBody.setRecordID(recordID);
            Object obj = producerTemplate.requestBody("direct:checkCertificate", docBody);
            if (obj instanceof Event) {
                fillErrorResult(bsError, bsErrorCode, docInfo, docStatus, (Event) obj);
                return;
            }
            // check client:
            obj = producerTemplate.requestBody("direct:checkClient", docBody);
            if (obj instanceof Event) {
                fillErrorResult(bsError, bsErrorCode, docInfo, docStatus, (Event) obj);
                return;
            }
            obj = producerTemplate.requestBody("direct:getDocStatus", docBody);
            if (obj instanceof Document) {
                Document doc = (Document) obj;
                docStatus.value = doc.getDocStatus();
                docInfo.value = doc.getDocInfo();
                bsError.value = doc.getBsError();
                bsErrorCode.value = doc.getBsErrorCode();
                return;
            } else if (obj instanceof Event) {
                fillErrorResult(bsError, bsErrorCode, docInfo, docStatus, (Event) obj);
            }
        } catch (Exception e) {
            LOG.error("Execution error", e);
            bsErrorCode.value = "false";
            bsError.value = e.getMessage();
        }
    }

    /**
     * Fill error result.
     * @param bsError bs error
     * @param bsErrorCode bs error code
     * @param docInfo document info
     * @param docStatus document status
     * @param result result event
     */
    private void fillErrorResult(StringHolder bsError, StringHolder bsErrorCode, StringHolder docInfo, StringHolder docStatus, Event result) {
        docStatus.value = null;
        docInfo.value = null;
        bsError.value = result.getBsError();
        bsErrorCode.value = result.getBsErrorCode();
    }

}
