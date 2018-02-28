/**
 * WSGetDocStatusserviceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package ru.masterdm.uct.axis.ws;

public class WSGetDocStatusserviceLocator extends org.apache.axis.client.Service implements ru.masterdm.uct.axis.ws.WSGetDocStatusservice {

    // Use to get a proxy class for WSGetDocStatusPort
    private final java.lang.String WSGetDocStatusPort_address = "http://localhost/soap/WSGetDocStatus";

    public java.lang.String getWSGetDocStatusPortAddress() {
        return WSGetDocStatusPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String WSGetDocStatusPortWSDDServiceName = "WSGetDocStatusPort";

    public java.lang.String getWSGetDocStatusPortWSDDServiceName() {
        return WSGetDocStatusPortWSDDServiceName;
    }

    public void setWSGetDocStatusPortWSDDServiceName(java.lang.String name) {
        WSGetDocStatusPortWSDDServiceName = name;
    }

    public ru.masterdm.uct.axis.ws.WSGetDocStatus getWSGetDocStatusPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(WSGetDocStatusPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getWSGetDocStatusPort(endpoint);
    }

    public ru.masterdm.uct.axis.ws.WSGetDocStatus getWSGetDocStatusPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            ru.masterdm.uct.axis.ws.WSGetDocStatusbindingStub _stub = new ru.masterdm.uct.axis.ws.WSGetDocStatusbindingStub(portAddress, this);
            _stub.setPortName(getWSGetDocStatusPortWSDDServiceName());
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
            if (ru.masterdm.uct.axis.ws.WSGetDocStatus.class.isAssignableFrom(serviceEndpointInterface)) {
                ru.masterdm.uct.axis.ws.WSGetDocStatusbindingStub _stub = new ru.masterdm.uct.axis.ws.WSGetDocStatusbindingStub(new java.net.URL(WSGetDocStatusPort_address), this);
                _stub.setPortName(getWSGetDocStatusPortWSDDServiceName());
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
        if ("WSGetDocStatusPort".equals(inputPortName)) {
            return getWSGetDocStatusPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://tempuri.org/", "WSGetDocStatusservice");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("WSGetDocStatusPort"));
        }
        return ports.iterator();
    }

}
