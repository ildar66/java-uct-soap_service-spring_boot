/**
 * WSPrepareDocForCancel.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package ru.masterdm.uct.axis.ws;

public interface WSPrepareDocForCancel extends java.rmi.Remote {
    public void prepareDocForCancel(javax.xml.rpc.holders.StringHolder BSError, javax.xml.rpc.holders.StringHolder BSErrorCode, javax.xml.rpc.holders.StringHolder cancelFields, int custID, java.lang.String docScheme, java.lang.String recordID, java.lang.String remoteUser) throws java.rmi.RemoteException;
}
