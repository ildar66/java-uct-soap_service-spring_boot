/**
 * WSGetCustomerImpl.java
 * <p>
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package ru.masterdm.uct.axis.service;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.xml.rpc.holders.StringHolder;

import org.apache.camel.BeanInject;
import org.apache.camel.ExchangePattern;
import org.apache.camel.ProducerTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.masterdm.uct.axis.ws.WSGetCustomer;
import ru.masterdm.uct.entity.Document;
import ru.masterdm.uct.entity.Event;

/**
 * WSGetCustomer Spring service.
 */
@Service("wsGetCustomer")
public class WSGetCustomerImpl implements WSGetCustomer {

    @BeanInject
    private ProducerTemplate producerTemplate;

    @Autowired
    private HttpServletRequest request;

    private static final Logger LOG = LoggerFactory.getLogger(WSGetCustomerImpl.class);

    /**
     * Returns accounts list.
     * @param account account
     * @param accounts accounts
     * @param bic bic
     * @param bsError bsError
     * @param bsErrorCode bsErrorCode
     * @param custID custID
     * @param remoteUser remoteUser
     * @throws RemoteException RemoteException
     */
    public void getAccountsList(String account, StringHolder accounts, String bic, StringHolder bsError, StringHolder bsErrorCode,
                                int custID, String remoteUser) throws RemoteException {
        try {
            Document doc = new Document();
            if (request.getRemoteUser() != null) {
                remoteUser = request.getRemoteUser();
            }
            doc.setRemoteUser(remoteUser);
            Object obj = producerTemplate.requestBody("direct:checkCertificate", doc);
            if (obj instanceof Event) {
                fillErrorResult(accounts, bsError, bsErrorCode, (Event) obj);
                return;
            }
            Map<String, Object> sendBody = new HashMap<>();
            sendBody.put("remoteUser", remoteUser);
            sendBody.put("BIC", bic);
            sendBody.put("account", account);
            sendBody.put("custId", custID);
            obj = producerTemplate.sendBody("direct:getCustomerAccounts", ExchangePattern.InOut, sendBody);
            if (obj instanceof Event) {
                fillErrorResult(accounts, bsError, bsErrorCode, (Event) obj);
            } else {
                fillSuccessResult(accounts, bsError, bsErrorCode, (String) obj);
            }
        } catch (Exception e) {
            logError(bsErrorCode, bsError, e);
        }
    }

    /**
     * Returns custs and branches.
     * @param custsAndBranches custsAndBranches
     * @param bsError bsError
     * @param bsErrorCode bsErrorCode
     * @param remoteUser remoteUser
     */
    public void getCustsAndBranches(StringHolder custsAndBranches, StringHolder bsErrorCode, StringHolder bsError, String remoteUser) {
        try {
            Document doc = new Document();
            if (request.getRemoteUser() != null) {
                remoteUser = request.getRemoteUser();
            }
            doc.setRemoteUser(remoteUser);
            Object obj = producerTemplate.sendBody("direct:getCustomerCustsAndBranches", ExchangePattern.InOut, doc);
            if (obj instanceof Event) {
                fillErrorResult(custsAndBranches, bsError, bsErrorCode, (Event) obj);
            } else {
                fillSuccessResult(custsAndBranches, bsError, bsErrorCode, (String) obj);
            }
        } catch (Exception e) {
            logError(bsErrorCode, bsError, e);
        }
    }

    /**
     * Fill success result.
     * @param holder string holder
     * @param bsError bs error
     * @param bsErrorCode bs error code
     * @param result result
     */
    private void fillSuccessResult(StringHolder holder, StringHolder bsError, StringHolder bsErrorCode, String result) {
        holder.value = result;
        bsError.value = "";
        bsErrorCode.value = "";
    }

    /**
     * Log error.
     * @param bsErrorCode bs error code
     * @param bsError bs error
     * @param exc exception
     */
    private void logError(StringHolder bsErrorCode, StringHolder bsError, Exception exc) {
        LOG.error("Execution error", exc);
        bsErrorCode.value = "false";
        bsError.value = exc.getMessage();
    }

    /**
     * Fill error result.
     * @param stringHolder string holder
     * @param bsError bs error
     * @param bsErrorCode bs error code
     * @param result error result
     */
    private void fillErrorResult(StringHolder stringHolder, StringHolder bsError, StringHolder bsErrorCode, Event result) {
        stringHolder.value = "";
        bsError.value = result.getBsError();
        bsErrorCode.value = result.getBsErrorCode();
    }
}