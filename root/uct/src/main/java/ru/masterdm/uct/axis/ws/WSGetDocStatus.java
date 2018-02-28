/**
 * WSGetDocStatus.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package ru.masterdm.uct.axis.ws;

public interface WSGetDocStatus extends java.rmi.Remote {
    public void getDocStatus(javax.xml.rpc.holders.StringHolder BSError, javax.xml.rpc.holders.StringHolder BSErrorCode, int custID, javax.xml.rpc.holders.StringHolder docInfo, java.lang.String docScheme, javax.xml.rpc.holders.StringHolder docStatus, java.lang.String recordID, java.lang.String remoteUser) throws java.rmi.RemoteException;
}
