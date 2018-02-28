/**
 * WSImportDocumentImpl.java
 * <p>
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package ru.masterdm.uct.axis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.masterdm.uct.axis.ws.WSImportDocument;
import ru.masterdm.uct.axis.ws.WSImportSignedDocument;

import javax.xml.rpc.holders.StringHolder;
import java.rmi.RemoteException;

/**
 * WSImportDocument Spring service.
 */
@Service("wsImportDocument")
public class WSImportDocumentImpl implements WSImportDocument {

    @Autowired
    private WSImportSignedDocument importService;

    /**
     * Imports document.
     * @param bsError bsError
     * @param bsErrorCode bsErrorCode
     * @param custID custID
     * @param docData docData
     * @param docScheme docScheme
     * @param docVersion docVersion
     * @param recordID recordID
     * @param remoteUser remoteUser
     * @throws RemoteException RemoteException
     */
    public void importDocument(StringHolder bsError, StringHolder bsErrorCode, int custID, String docData, String docScheme, int docVersion,
                               StringHolder recordID, String remoteUser) throws RemoteException {
        importService.importSignedDocument(bsError, bsErrorCode, custID, docData, docScheme, docVersion, recordID, remoteUser, null);
    }
}
