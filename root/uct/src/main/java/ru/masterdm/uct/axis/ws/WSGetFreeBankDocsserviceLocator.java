/**
 * WSGetFreeBankDocsserviceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package ru.masterdm.uct.axis.ws;

public class WSGetFreeBankDocsserviceLocator extends org.apache.axis.client.Service implements ru.masterdm.uct.axis.ws.WSGetFreeBankDocsservice {

    // Use to get a proxy class for WSGetFreeBankDocsPort
    private final java.lang.String WSGetFreeBankDocsPort_address = "http://localhost/soap/WSGetFreeBankDocs";

    public java.lang.String getWSGetFreeBankDocsPortAddress() {
        return WSGetFreeBankDocsPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String WSGetFreeBankDocsPortWSDDServiceName = "WSGetFreeBankDocsPort";

    public java.lang.String getWSGetFreeBankDocsPortWSDDServiceName() {
        return WSGetFreeBankDocsPortWSDDServiceName;
    }

    public void setWSGetFreeBankDocsPortWSDDServiceName(java.lang.String name) {
        WSGetFreeBankDocsPortWSDDServiceName = name;
    }

    public ru.masterdm.uct.axis.ws.WSGetFreeBankDocs getWSGetFreeBankDocsPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(WSGetFreeBankDocsPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getWSGetFreeBankDocsPort(endpoint);
    }

    public ru.masterdm.uct.axis.ws.WSGetFreeBankDocs getWSGetFreeBankDocsPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            ru.masterdm.uct.axis.ws.WSGetFreeBankDocsbindingStub _stub = new ru.masterdm.uct.axis.ws.WSGetFreeBankDocsbindingStub(portAddress, this);
            _stub.setPortName(getWSGetFreeBankDocsPortWSDDServiceName());
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
            if (ru.masterdm.uct.axis.ws.WSGetFreeBankDocs.class.isAssignableFrom(serviceEndpointInterface)) {
                ru.masterdm.uct.axis.ws.WSGetFreeBankDocsbindingStub _stub = new ru.masterdm.uct.axis.ws.WSGetFreeBankDocsbindingStub(new java.net.URL(WSGetFreeBankDocsPort_address), this);
                _stub.setPortName(getWSGetFreeBankDocsPortWSDDServiceName());
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
        if ("WSGetFreeBankDocsPort".equals(inputPortName)) {
            return getWSGetFreeBankDocsPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://tempuri.org/", "WSGetFreeBankDocsservice");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("WSGetFreeBankDocsPort"));
        }
        return ports.iterator();
    }

}
