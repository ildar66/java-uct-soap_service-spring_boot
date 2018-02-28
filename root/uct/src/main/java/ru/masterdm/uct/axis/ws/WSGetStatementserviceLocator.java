/**
 * WSGetStatementserviceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package ru.masterdm.uct.axis.ws;

public class WSGetStatementserviceLocator extends org.apache.axis.client.Service implements ru.masterdm.uct.axis.ws.WSGetStatementservice {

    // Use to get a proxy class for WSGetStatementPort
    private final java.lang.String WSGetStatementPort_address = "http://localhost/soap/WSGetStatement";

    public java.lang.String getWSGetStatementPortAddress() {
        return WSGetStatementPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String WSGetStatementPortWSDDServiceName = "WSGetStatementPort";

    public java.lang.String getWSGetStatementPortWSDDServiceName() {
        return WSGetStatementPortWSDDServiceName;
    }

    public void setWSGetStatementPortWSDDServiceName(java.lang.String name) {
        WSGetStatementPortWSDDServiceName = name;
    }

    public ru.masterdm.uct.axis.ws.WSGetStatement getWSGetStatementPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(WSGetStatementPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getWSGetStatementPort(endpoint);
    }

    public ru.masterdm.uct.axis.ws.WSGetStatement getWSGetStatementPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            ru.masterdm.uct.axis.ws.WSGetStatementbindingStub _stub = new ru.masterdm.uct.axis.ws.WSGetStatementbindingStub(portAddress, this);
            _stub.setPortName(getWSGetStatementPortWSDDServiceName());
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
            if (ru.masterdm.uct.axis.ws.WSGetStatement.class.isAssignableFrom(serviceEndpointInterface)) {
                ru.masterdm.uct.axis.ws.WSGetStatementbindingStub _stub = new ru.masterdm.uct.axis.ws.WSGetStatementbindingStub(new java.net.URL(WSGetStatementPort_address), this);
                _stub.setPortName(getWSGetStatementPortWSDDServiceName());
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
        if ("WSGetStatementPort".equals(inputPortName)) {
            return getWSGetStatementPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://tempuri.org/", "WSGetStatementservice");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("WSGetStatementPort"));
        }
        return ports.iterator();
    }

}
