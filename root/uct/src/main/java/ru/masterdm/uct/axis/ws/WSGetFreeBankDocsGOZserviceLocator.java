/**
 * WSGetFreeBankDocsGOZserviceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package ru.masterdm.uct.axis.ws;

public class WSGetFreeBankDocsGOZserviceLocator extends org.apache.axis.client.Service implements ru.masterdm.uct.axis.ws.WSGetFreeBankDocsGOZservice {

    // Use to get a proxy class for WSGetFreeBankDocsGOZPort
    private final java.lang.String WSGetFreeBankDocsGOZPort_address = "http://localhost/soap/WSGetFreeBankDocsGOZ";

    public java.lang.String getWSGetFreeBankDocsGOZPortAddress() {
        return WSGetFreeBankDocsGOZPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String WSGetFreeBankDocsGOZPortWSDDServiceName = "WSGetFreeBankDocsGOZPort";

    public java.lang.String getWSGetFreeBankDocsGOZPortWSDDServiceName() {
        return WSGetFreeBankDocsGOZPortWSDDServiceName;
    }

    public void setWSGetFreeBankDocsGOZPortWSDDServiceName(java.lang.String name) {
        WSGetFreeBankDocsGOZPortWSDDServiceName = name;
    }

    public ru.masterdm.uct.axis.ws.WSGetFreeBankDocsGOZ getWSGetFreeBankDocsGOZPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(WSGetFreeBankDocsGOZPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getWSGetFreeBankDocsGOZPort(endpoint);
    }

    public ru.masterdm.uct.axis.ws.WSGetFreeBankDocsGOZ getWSGetFreeBankDocsGOZPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            ru.masterdm.uct.axis.ws.WSGetFreeBankDocsGOZbindingStub _stub = new ru.masterdm.uct.axis.ws.WSGetFreeBankDocsGOZbindingStub(portAddress, this);
            _stub.setPortName(getWSGetFreeBankDocsGOZPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (ru.masterdm.uct.axis.ws.WSGetFreeBankDocsGOZ.class.isAssignableFrom(serviceEndpointInterface)) {
                ru.masterdm.uct.axis.ws.WSGetFreeBankDocsGOZbindingStub _stub = new ru.masterdm.uct.axis.ws.WSGetFreeBankDocsGOZbindingStub(new java.net.URL(WSGetFreeBankDocsGOZPort_address), this);
                _stub.setPortName(getWSGetFreeBankDocsGOZPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        String inputPortName = portName.getLocalPart();
        if ("WSGetFreeBankDocsGOZPort".equals(inputPortName)) {
            return getWSGetFreeBankDocsGOZPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://tempuri.org/", "WSGetFreeBankDocsGOZservice");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("WSGetFreeBankDocsGOZPort"));
        }
        return ports.iterator();
    }

}
