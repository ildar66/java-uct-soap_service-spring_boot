package ru.masterdm.uct.axis;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.axis.AxisFault;
import org.apache.axis.Constants;
import org.apache.axis.Handler;
import org.apache.axis.Message;
import org.apache.axis.MessageContext;
import org.apache.axis.constants.Style;
import org.apache.axis.description.OperationDesc;
import org.apache.axis.description.ParameterDesc;
import org.apache.axis.description.ServiceDesc;
import org.apache.axis.handlers.soap.SOAPService;
import org.apache.axis.message.RPCElement;
import org.apache.axis.message.RPCHeaderParam;
import org.apache.axis.message.RPCParam;
import org.apache.axis.message.SOAPEnvelope;
import org.apache.axis.providers.BasicProvider;
import org.apache.axis.providers.java.JavaProvider;
import org.apache.axis.providers.java.RPCProvider;
import org.apache.axis.soap.SOAPConstants;
import org.apache.axis.utils.JavaUtils;
import org.apache.axis.utils.XMLUtils;
import org.springframework.context.ApplicationContext;

import javax.wsdl.OperationType;
import javax.xml.namespace.QName;
import javax.xml.rpc.holders.Holder;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

/**
 * Axis-Spring provider.
 */
public class SpringRPCProvider extends RPCProvider {

    private final ApplicationContext applicationContext;

    private static final String OPTION_BEAN = "bean";

    /**
     * Constructor with Spring's application context.
     * @param applicationContext ApplicationContext
     */
    public SpringRPCProvider(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public void initServiceDesc(SOAPService service, MessageContext msgContext) throws AxisFault {
        // OPTION_CLASSNAME is checked by JavaProvider. Must not be empty to prevent exceptions
        Object bean = applicationContext.getBean((String) service.getOption(OPTION_BEAN));
        service.setOption(JavaProvider.OPTION_CLASSNAME, bean.getClass().getCanonicalName());
        super.initServiceDesc(service, msgContext);
    }

    @Override
    public void invoke(MessageContext msgContext) throws AxisFault {
        try {
            Handler service = msgContext.getService();
            Object obj = applicationContext.getBean((String) service.getOption(OPTION_BEAN));

            SOAPEnvelope resEnv = null;
            OperationDesc operation = msgContext.getOperation();
            if (operation != null
                    && OperationType.ONE_WAY.equals(operation.getMep())) {
                msgContext.setResponseMessage(null);
            } else {
                Message resMsg  = msgContext.getResponseMessage();

                // If we didn't have a response message, make sure we set one up
                // with the appropriate versions of SOAP and Schema
                if (resMsg == null) {
                    resEnv  = new org.apache.axis.message.SOAPEnvelope(msgContext.getSOAPConstants(),
                            msgContext.getSchemaVersion());

                    resMsg = new Message(resEnv);
                    String encoding = XMLUtils.getEncoding(msgContext);
                    resMsg.setProperty(SOAPMessage.CHARACTER_SET_ENCODING, encoding);
                    msgContext.setResponseMessage(resMsg);
                } else {
                    resEnv  = resMsg.getSOAPEnvelope();
                }
            }
            Message reqMsg = msgContext.getRequestMessage();
            SOAPEnvelope reqEnv = reqMsg.getSOAPEnvelope();
            processMessage(msgContext, reqEnv, resEnv, obj);
        } catch (SOAPException e) {
            AxisFault fault = AxisFault.makeFault(e);
            throw fault;
        } catch (AxisFault e) {
            throw e;
        } catch (Exception e) {
            AxisFault fault = AxisFault.makeFault(e);
            if (e instanceof RuntimeException) {
                fault.addFaultDetail(Constants.QNAME_FAULTDETAIL_RUNTIMEEXCEPTION, "true");
            }
            throw fault;
        }
    }

    @Override
    protected RPCElement createResponseBody(RPCElement body, MessageContext msgContext, OperationDesc operation, ServiceDesc serviceDesc, Object objRes, SOAPEnvelope resEnv, ArrayList outs) throws Exception
    {
        String methodName = body.getMethodName();
        /* Now put the result in the result SOAPEnvelope */
        RPCElement resBody = new RPCElement(methodName);
        resBody.setPrefix(body.getPrefix());
        resBody.setNamespaceURI(body.getNamespaceURI());
        resBody.setEncodingStyle(msgContext.getEncodingStyle());
        try {
            // Return first
            if (operation.getMethod().getReturnType() != Void.TYPE) {
                QName returnQName = operation.getReturnQName();
                if (returnQName == null) {
                    String nsp = body.getNamespaceURI();
                    if(nsp == null || nsp.length()==0) {
                        nsp = serviceDesc.getDefaultNamespace();
                    }
                    returnQName = new QName(msgContext.isEncoded() ? "" :
                                            nsp,
                                            methodName + "Return");
                }

                RPCParam param = new RPCParam(returnQName, objRes);
                param.setParamDesc(operation.getReturnParamDesc());

                if (!operation.isReturnHeader()) {
                    // For SOAP 1.2 rpc style, add a result
                    if (msgContext.getSOAPConstants() == SOAPConstants.SOAP12_CONSTANTS &&
                        (serviceDesc.getStyle().equals(Style.RPC))) {
                        RPCParam resultParam = new RPCParam(Constants.QNAME_RPC_RESULT, returnQName);
                        resultParam.setXSITypeGeneration(Boolean.FALSE);
                        resBody.addParam(resultParam);
                    }
                    resBody.addParam(param);
                } else {
                    resEnv.addHeader(new RPCHeaderParam(param));
                }

            }

            // Then any other out params
            if (!outs.isEmpty()) {
                for (Iterator i = outs.iterator(); i.hasNext();) {
                    // We know this has a holder, so just unwrap the value
                    RPCParam param = (RPCParam) i.next();
                    Holder holder = (Holder) param.getObjectValue();
                    Object value = JavaUtils.getHolderValue(holder);
                    ParameterDesc paramDesc = param.getParamDesc();

                    param.setObjectValue(value);
                    if (paramDesc != null && paramDesc.isOutHeader()) {
                        resEnv.addHeader(new RPCHeaderParam(param));
                    } else {
                        resBody.addParam(param);
                    }
                }
            }
        } catch (Exception e) {
            throw e;
        }
        return resBody;
    }
}
