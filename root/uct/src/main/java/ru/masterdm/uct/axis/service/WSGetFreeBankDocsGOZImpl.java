/**
 * WSGetFreeBankDocsGOZImpl.java
 * <p>
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package ru.masterdm.uct.axis.service;

import java.rmi.RemoteException;
import java.util.Date;

import javax.xml.rpc.holders.StringHolder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.masterdm.uct.axis.ws.WSGetFreeBankDocs;
import ru.masterdm.uct.axis.ws.WSGetFreeBankDocsGOZ;

/**
 * WSGetFreeBankDocsGOZ Spring service.
 */
@Service("wsGetFreeBankDocsGOZ")
public class WSGetFreeBankDocsGOZImpl implements WSGetFreeBankDocsGOZ {

    @Autowired
    private WSGetFreeBankDocs freeBankDocsService;

    /**
     * Returns free bank doc GOZ.
     * @param bsError bsError
     * @param bsErrorCode bsErrorCode
     * @param custID custID
     * @param document document
     * @param recordID recordID
     * @param remoteUser remoteUser
     * @param signData signData
     * @throws RemoteException RemoteException
     */
    public void getFreeBankDocGOZ(StringHolder bsError, StringHolder bsErrorCode, int custID, StringHolder document, String recordID,
                                  String remoteUser, StringHolder signData) throws RemoteException {
        freeBankDocsService.getFreeBankDoc(bsError, bsErrorCode, custID, document, recordID, remoteUser, signData);
    }

    /**
     * Returns free bank docs GOZ list.
     * @param bsError bsError
     * @param bsErrorCode bsErrorCode
     * @param custID custID
     * @param docList docList
     * @param documentDate documentDate
     * @param remoteUser remoteUser
     * @throws RemoteException RemoteException
     */
    public void getFreeBankDocGOZList(StringHolder bsError, StringHolder bsErrorCode, int custID, StringHolder docList, Date documentDate,
                                      String remoteUser) throws RemoteException {
        freeBankDocsService.getFreeBankDocList(bsError, bsErrorCode, custID, docList, documentDate, remoteUser);
    }

}