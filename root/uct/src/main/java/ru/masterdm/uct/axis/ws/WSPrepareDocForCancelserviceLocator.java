/**
 * WSPrepareDocForCancelserviceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package ru.masterdm.uct.axis.ws;

public class WSPrepareDocForCancelserviceLocator extends org.apache.axis.client.Service implements ru.masterdm.uct.axis.ws.WSPrepareDocForCancelservice {

    // Use to get a proxy class for WSPrepareDocForCancelPort
    private final java.lang.String WSPrepareDocForCancelPort_address = "http://localhost/soap/WSPrepareDocForCancel";

    public java.lang.String getWSPrepareDocForCancelPortAddress() {
        return WSPrepareDocForCancelPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String WSPrepareDocForCancelPortWSDDServiceName = "WSPrepareDocForCancelPort";

    public java.lang.String getWSPrepareDocForCancelPortWSDDServiceName() {
        return WSPrepareDocForCancelPortWSDDServiceName;
    }

    public void setWSPrepareDocForCancelPortWSDDServiceName(java.lang.String name) {
        WSPrepareDocForCancelPortWSDDServiceName = name;
    }

    public ru.masterdm.uct.axis.ws.WSPrepareDocForCancel getWSPrepareDocForCancelPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(WSPrepareDocForCancelPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getWSPrepareDocForCancelPort(endpoint);
    }

    public ru.masterdm.uct.axis.ws.WSPrepareDocForCancel getWSPrepareDocForCancelPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            ru.masterdm.uct.axis.ws.WSPrepareDocForCancelbindingStub _stub = new ru.masterdm.uct.axis.ws.WSPrepareDocForCancelbindingStub(portAddress, this);
            _stub.setPortName(getWSPrepareDocForCancelPortWSDDServiceName());
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
            if (ru.masterdm.uct.axis.ws.WSPrepareDocForCancel.class.isAssignableFrom(serviceEndpointInterface)) {
                ru.masterdm.uct.axis.ws.WSPrepareDocForCancelbindingStub _stub = new ru.masterdm.uct.axis.ws.WSPrepareDocForCancelbindingStub(new java.net.URL(WSPrepareDocForCancelPort_address), this);
                _stub.setPortName(getWSPrepareDocForCancelPortWSDDServiceName());
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
        if ("WSPrepareDocForCancelPort".equals(inputPortName)) {
            return getWSPrepareDocForCancelPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://tempuri.org/", "WSPrepareDocForCancelservice");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("WSPrepareDocForCancelPort"));
        }
        return ports.iterator();
    }

}
