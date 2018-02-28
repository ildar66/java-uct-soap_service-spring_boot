/**
 * WSGetStatement.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package ru.masterdm.uct.axis.ws;

public interface WSGetStatement extends java.rmi.Remote {
    public void getStatement(java.lang.String account, java.lang.String BIC, javax.xml.rpc.holders.StringHolder BSError, javax.xml.rpc.holders.StringHolder BSErrorCode, int custID, java.lang.String remoteUser, javax.xml.rpc.holders.StringHolder signData, java.util.Date statementDate, javax.xml.rpc.holders.StringHolder statementDoc, int statementType) throws java.rmi.RemoteException;
}
