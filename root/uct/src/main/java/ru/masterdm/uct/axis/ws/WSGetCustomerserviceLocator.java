/**
 * WSGetCustomerserviceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package ru.masterdm.uct.axis.ws;

public class WSGetCustomerserviceLocator extends org.apache.axis.client.Service implements ru.masterdm.uct.axis.ws.WSGetCustomerservice {

    // Use to get a proxy class for WSGetCustomerPort
    private final java.lang.String WSGetCustomerPort_address = "http://localhost/soap/WSGetCustomer";

    public java.lang.String getWSGetCustomerPortAddress() {
        return WSGetCustomerPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String WSGetCustomerPortWSDDServiceName = "WSGetCustomerPort";

    public java.lang.String getWSGetCustomerPortWSDDServiceName() {
        return WSGetCustomerPortWSDDServiceName;
    }

    public void setWSGetCustomerPortWSDDServiceName(java.lang.String name) {
        WSGetCustomerPortWSDDServiceName = name;
    }

    public ru.masterdm.uct.axis.ws.WSGetCustomer getWSGetCustomerPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(WSGetCustomerPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getWSGetCustomerPort(endpoint);
    }

    public ru.masterdm.uct.axis.ws.WSGetCustomer getWSGetCustomerPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            ru.masterdm.uct.axis.ws.WSGetCustomerbindingStub _stub = new ru.masterdm.uct.axis.ws.WSGetCustomerbindingStub(portAddress, this);
            _stub.setPortName(getWSGetCustomerPortWSDDServiceName());
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
            if (ru.masterdm.uct.axis.ws.WSGetCustomer.class.isAssignableFrom(serviceEndpointInterface)) {
                ru.masterdm.uct.axis.ws.WSGetCustomerbindingStub _stub = new ru.masterdm.uct.axis.ws.WSGetCustomerbindingStub(new java.net.URL(WSGetCustomerPort_address), this);
                _stub.setPortName(getWSGetCustomerPortWSDDServiceName());
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
        if ("WSGetCustomerPort".equals(inputPortName)) {
            return getWSGetCustomerPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://tempuri.org/", "WSGetCustomerservice");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("WSGetCustomerPort"));
        }
        return ports.iterator();
    }

}
