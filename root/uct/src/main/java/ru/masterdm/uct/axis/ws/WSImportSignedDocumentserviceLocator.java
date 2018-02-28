/**
 * WSImportSignedDocumentserviceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package ru.masterdm.uct.axis.ws;

public class WSImportSignedDocumentserviceLocator extends org.apache.axis.client.Service implements ru.masterdm.uct.axis.ws.WSImportSignedDocumentservice {

    // Use to get a proxy class for WSImportSignedDocumentPort
    private final java.lang.String WSImportSignedDocumentPort_address = "http://localhost/soap/WSImportSignedDocument";

    public java.lang.String getWSImportSignedDocumentPortAddress() {
        return WSImportSignedDocumentPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String WSImportSignedDocumentPortWSDDServiceName = "WSImportSignedDocumentPort";

    public java.lang.String getWSImportSignedDocumentPortWSDDServiceName() {
        return WSImportSignedDocumentPortWSDDServiceName;
    }

    public void setWSImportSignedDocumentPortWSDDServiceName(java.lang.String name) {
        WSImportSignedDocumentPortWSDDServiceName = name;
    }

    public ru.masterdm.uct.axis.ws.WSImportSignedDocument getWSImportSignedDocumentPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(WSImportSignedDocumentPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getWSImportSignedDocumentPort(endpoint);
    }

    public ru.masterdm.uct.axis.ws.WSImportSignedDocument getWSImportSignedDocumentPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            ru.masterdm.uct.axis.ws.WSImportSignedDocumentbindingStub _stub = new ru.masterdm.uct.axis.ws.WSImportSignedDocumentbindingStub(portAddress, this);
            _stub.setPortName(getWSImportSignedDocumentPortWSDDServiceName());
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
            if (ru.masterdm.uct.axis.ws.WSImportSignedDocument.class.isAssignableFrom(serviceEndpointInterface)) {
                ru.masterdm.uct.axis.ws.WSImportSignedDocumentbindingStub _stub = new ru.masterdm.uct.axis.ws.WSImportSignedDocumentbindingStub(new java.net.URL(WSImportSignedDocumentPort_address), this);
                _stub.setPortName(getWSImportSignedDocumentPortWSDDServiceName());
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
        if ("WSImportSignedDocumentPort".equals(inputPortName)) {
            return getWSImportSignedDocumentPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://tempuri.org/", "WSImportSignedDocumentservice");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("WSImportSignedDocumentPort"));
        }
        return ports.iterator();
    }

}
