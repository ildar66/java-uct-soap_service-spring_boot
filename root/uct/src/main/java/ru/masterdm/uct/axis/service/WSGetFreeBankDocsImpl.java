/**
 * WSGetFreeBankDocsImpl.java
 * <p>
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package ru.masterdm.uct.axis.service;

import java.rmi.RemoteException;
import java.util.Date;

import javax.xml.rpc.holders.StringHolder;

import org.apache.camel.BeanInject;
import org.apache.camel.ProducerTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import ru.masterdm.uct.axis.ws.WSGetFreeBankDocs;
import ru.masterdm.uct.entity.Document;
import ru.masterdm.uct.entity.Event;

/**
 * WSGetFreeBankDocs Spring service.
 */
@Service("wsGetFreeBankDocs")
public class WSGetFreeBankDocsImpl implements WSGetFreeBankDocs {

    @BeanInject
    private ProducerTemplate producerTemplate;

    private static final Logger LOG = LoggerFactory.getLogger(WSGetFreeBankDocsImpl.class);

    /**
     * Returns free bank doc.
     * @param bsError bsError
     * @param bsErrorCode bsErrorCode
     * @param custID custID
     * @param document document
     * @param recordID recordID
     * @param remoteUser remoteUser
     * @param signData signData
     * @throws RemoteException RemoteException
     */
    public void getFreeBankDoc(StringHolder bsError, StringHolder bsErrorCode, int custID, StringHolder document, String recordID,
                               String remoteUser, StringHolder signData) throws RemoteException {
        try {
            Document docBody = new Document(null, null, -1, custID, null, remoteUser);
            docBody.setRecordID(recordID);
            Object obj = producerTemplate.requestBody("direct:getFreeBankDoc", docBody);
            // Object obj = producerTemplate.sendBody("direct:getFreeBankDoc", ExchangePattern.InOut, docBody);
            if (obj instanceof Document) {
                Document doc = (Document) obj;
                document.value = doc.getDocData();
                signData.value = doc.getSignData();
                bsError.value = null;
                bsErrorCode.value = null;
            } else {
                Event result = (Event) obj;
                document.value = "";
                signData.value = null;
                bsError.value = result.getBsError();
                bsErrorCode.value = result.getBsErrorCode();
            }
        } catch (Exception e) {
            LOG.error("Execution error", e);
            bsErrorCode.value = "false";
            bsError.value = e.getMessage();
        }

    }

    /**
     * Returns free bank docs list.
     * @param bsError bsError
     * @param bsErrorCode bsErrorCode
     * @param custID custID
     * @param docList docList
     * @param documentDate documentDate
     * @param remoteUser remoteUser
     * @throws RemoteException RemoteException
     */
    public void getFreeBankDocList(StringHolder bsError, StringHolder bsErrorCode, int custID, StringHolder docList, Date documentDate,
                                   String remoteUser) throws RemoteException {
        try {
            Document doc = new Document(null, null, -1, custID, null, remoteUser);
            doc.setDocumentDate(documentDate);
            Object obj = producerTemplate.requestBody("direct:getFreeBankDocList", doc);
            if (obj instanceof String) {
                String docXML = (String) obj;
                docList.value = docXML;
                bsError.value = null;
                bsErrorCode.value = null;
            } else {
                Event result = (Event) obj;
                docList.value = "";
                bsError.value = result.getBsError();
                bsErrorCode.value = result.getBsErrorCode();
            }
        } catch (Exception e) {
            LOG.error("Execution error", e);
            bsErrorCode.value = "false";
            bsError.value = e.getMessage();
        }
    }

}
