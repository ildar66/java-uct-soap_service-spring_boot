/**
 * WSGetFreeBankDocsGOZ.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package ru.masterdm.uct.axis.ws;

public interface WSGetFreeBankDocsGOZ extends java.rmi.Remote {
    public void getFreeBankDocGOZ(javax.xml.rpc.holders.StringHolder BSError, javax.xml.rpc.holders.StringHolder BSErrorCode, int custID, javax.xml.rpc.holders.StringHolder document, java.lang.String recordID, java.lang.String remoteUser, javax.xml.rpc.holders.StringHolder signData) throws java.rmi.RemoteException;
    public void getFreeBankDocGOZList(javax.xml.rpc.holders.StringHolder BSError, javax.xml.rpc.holders.StringHolder BSErrorCode, int custID, javax.xml.rpc.holders.StringHolder docList, java.util.Date documentDate, java.lang.String remoteUser) throws java.rmi.RemoteException;
}
