/**
 * WSImportDocumentImpl.java
 * <p>
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package ru.masterdm.uct.axis.service;

import org.apache.camel.BeanInject;
import org.apache.camel.ProducerTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.masterdm.uct.axis.ws.WSImportSignedDocument;
import ru.masterdm.uct.entity.Document;
import ru.masterdm.uct.entity.Event;

import javax.xml.rpc.holders.StringHolder;
import java.rmi.RemoteException;
import java.util.concurrent.CompletableFuture;

/**
 * WSImportDocument Spring service.
 */
@Service("wsImportSignedDocument")
public class WSImportSignedDocumentImpl implements WSImportSignedDocument {

    @BeanInject
    private ProducerTemplate producerTemplate;

    private static final Logger LOG = LoggerFactory.getLogger(WSImportSignedDocumentImpl.class);

    /**
     * Imports signed documents.
     * @param bsError bsError
     * @param bsErrorCode bsErrorCode
     * @param custID custID
     * @param docData docData
     * @param docScheme docScheme
     * @param docVersion docVersion
     * @param recordID recordID
     * @param remoteUser remoteUser
     * @param signData signData
     * @throws RemoteException RemoteException
     */
    public void importSignedDocument(StringHolder bsError, StringHolder bsErrorCode, int custID, String docData, String docScheme,
                                     int docVersion, StringHolder recordID, String remoteUser, String signData) throws RemoteException {
        try {
            Document docBody = new Document(docData, docScheme, docVersion, custID, signData, remoteUser);
            // здесь синхронный вызов через sendBody не отрабатывает
            // в ответе null, хотя все этапы маршрута успешно пройдены
            CompletableFuture<Object> futureResult = producerTemplate.asyncSendBody("direct:importDocument", docBody);
            Object obj = futureResult.get();
            if (obj instanceof Document) {
                Document doc = (Document) obj;
                recordID.value = doc.getRecordID();
                bsError.value = "";
                bsErrorCode.value = "";
                return;
            } else if (obj instanceof Event) {
                Event result = (Event) obj;
                recordID.value = "";
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
