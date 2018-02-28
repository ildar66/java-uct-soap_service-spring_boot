/**
 * WSImportDocumentbindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package ru.masterdm.uct.axis.ws;

public class WSImportDocumentbindingStub extends org.apache.axis.client.Stub implements ru.masterdm.uct.axis.ws.WSImportDocument {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[1];
        org.apache.axis.description.OperationDesc oper;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ImportDocument");
        oper.addParameter(new javax.xml.namespace.QName("", "BSError"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.INOUT, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "BSErrorCode"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.INOUT, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "CustID"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "DocData"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "DocScheme"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "DocVersion"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "RecordID"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.INOUT, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "RemoteUser"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[0] = oper;

    }

    public WSImportDocumentbindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public WSImportDocumentbindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public WSImportDocumentbindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
    }

    private org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call =
                    (org.apache.axis.client.Call) super.service.createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                java.lang.String key = (java.lang.String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            return _call;
        }
        catch (java.lang.Throwable t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", t);
        }
    }

    public void importDocument(javax.xml.rpc.holders.StringHolder BSError, javax.xml.rpc.holders.StringHolder BSErrorCode, int custID, java.lang.String docData, java.lang.String docScheme, int docVersion, javax.xml.rpc.holders.StringHolder recordID, java.lang.String remoteUser) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:WSImportDocumentIntf-WSImportDocument#ImportDocument");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:WSImportDocumentIntf-WSImportDocument", "ImportDocument"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {BSError.value, BSErrorCode.value, new java.lang.Integer(custID), docData, docScheme, new java.lang.Integer(docVersion), recordID.value, remoteUser});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                BSError.value = (java.lang.String) _output.get(new javax.xml.namespace.QName("", "BSError"));
            } catch (java.lang.Exception _exception) {
                BSError.value = (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "BSError")), java.lang.String.class);
            }
            try {
                BSErrorCode.value = (java.lang.String) _output.get(new javax.xml.namespace.QName("", "BSErrorCode"));
            } catch (java.lang.Exception _exception) {
                BSErrorCode.value = (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "BSErrorCode")), java.lang.String.class);
            }
            try {
                recordID.value = (java.lang.String) _output.get(new javax.xml.namespace.QName("", "RecordID"));
            } catch (java.lang.Exception _exception) {
                recordID.value = (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "RecordID")), java.lang.String.class);
            }
        }
    }

}
