/**
 * WSGetCustomer.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package ru.masterdm.uct.axis.ws;

public interface WSGetCustomer extends java.rmi.Remote {
    public void getAccountsList(java.lang.String account, javax.xml.rpc.holders.StringHolder accounts, java.lang.String BIC, javax.xml.rpc.holders.StringHolder BSError, javax.xml.rpc.holders.StringHolder BSErrorCode, int custID, java.lang.String remoteUser) throws java.rmi.RemoteException;
    public void getCustsAndBranches(javax.xml.rpc.holders.StringHolder custsAndBranches, javax.xml.rpc.holders.StringHolder BSErrorCode, javax.xml.rpc.holders.StringHolder BSError, java.lang.String remoteUser) throws java.rmi.RemoteException;
}
