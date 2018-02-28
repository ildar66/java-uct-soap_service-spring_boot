/**
 * WSImportDocumentserviceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package ru.masterdm.uct.axis.ws;

public class WSImportDocumentserviceLocator extends org.apache.axis.client.Service implements ru.masterdm.uct.axis.ws.WSImportDocumentservice {

    // Use to get a proxy class for WSImportDocumentPort
    private final java.lang.String WSImportDocumentPort_address = "http://localhost/soap/WSImportDocument";

    public java.lang.String getWSImportDocumentPortAddress() {
        return WSImportDocumentPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String WSImportDocumentPortWSDDServiceName = "WSImportDocumentPort";

    public java.lang.String getWSImportDocumentPortWSDDServiceName() {
        return WSImportDocumentPortWSDDServiceName;
    }

    public void setWSImportDocumentPortWSDDServiceName(java.lang.String name) {
        WSImportDocumentPortWSDDServiceName = name;
    }

    public ru.masterdm.uct.axis.ws.WSImportDocument getWSImportDocumentPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(WSImportDocumentPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getWSImportDocumentPort(endpoint);
    }

    public ru.masterdm.uct.axis.ws.WSImportDocument getWSImportDocumentPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            ru.masterdm.uct.axis.ws.WSImportDocumentbindingStub _stub = new ru.masterdm.uct.axis.ws.WSImportDocumentbindingStub(portAddress, this);
            _stub.setPortName(getWSImportDocumentPortWSDDServiceName());
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
            if (ru.masterdm.uct.axis.ws.WSImportDocument.class.isAssignableFrom(serviceEndpointInterface)) {
                ru.masterdm.uct.axis.ws.WSImportDocumentbindingStub _stub = new ru.masterdm.uct.axis.ws.WSImportDocumentbindingStub(new java.net.URL(WSImportDocumentPort_address), this);
                _stub.setPortName(getWSImportDocumentPortWSDDServiceName());
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
        if ("WSImportDocumentPort".equals(inputPortName)) {
            return getWSImportDocumentPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://tempuri.org/", "WSImportDocumentservice");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("WSImportDocumentPort"));
        }
        return ports.iterator();
    }

}
