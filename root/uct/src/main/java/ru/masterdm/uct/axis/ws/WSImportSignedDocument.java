/**
 * WSImportSignedDocument.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package ru.masterdm.uct.axis.ws;

public interface WSImportSignedDocument extends java.rmi.Remote {
    public void importSignedDocument(javax.xml.rpc.holders.StringHolder BSError, javax.xml.rpc.holders.StringHolder BSErrorCode, int custID, java.lang.String docData, java.lang.String docScheme, int docVersion, javax.xml.rpc.holders.StringHolder recordID, java.lang.String remoteUser, java.lang.String signData) throws java.rmi.RemoteException;
}
