package com.bst.ckt.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.bst.ckt.common.LoginUtil;
import com.bst.ckt.common.OMIConstants;
import com.bst.ckt.helper.ListHelper;
import com.bst.ckt.helper.NameHelper;
import com.bst.ckt.helper.VOMapperHelper;
import com.bst.ckt.service.PaymentServiceImpl;
import com.bst.ckt.service.PaymentServiceInf;
import com.bst.ckt.service.TransportServiceImpl;
import com.bst.ckt.vo.PaymentVO;
import com.bst.ckt.vo.ProductVO;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class PaymentAction extends ActionSupport implements
ModelDriven<PaymentVO>,ServletRequestAware,ServletResponseAware {

	
	private static final long serialVersionUID = 1L;

	/**
	 * Creating Logger object, logger object mapped with ProductAction class for
	 * writing Loggers.
	 */
	private static final Logger logger = Logger.getLogger(PaymentAction.class);

	private static final String productId =null;
	
	ListHelper listHelper = new ListHelper();
	NameHelper nameHelper=new NameHelper();
	
	PaymentServiceInf  paymentServiceInf= new  PaymentServiceImpl();
	HttpServletResponse response = null;
	HttpServletRequest request = (HttpServletRequest) ActionContext
			.getContext().get(ServletActionContext.HTTP_REQUEST);
	
	
	PaymentVO paymentVO = new PaymentVO();

	private Map<Integer, String> paymentSelectList;
	
	
	
	private List<PaymentVO> paymentDetailsList  = null;	
	
	
	public PaymentAction() throws Exception {
		paymentSelectList = listHelper.paymentSelectList();
	}
	
	
public String  PaymentRequest() throws Exception{
		
	System.out.println("..............ActionClass........");
	PaymentServiceInf paymentServiceInf= new PaymentServiceImpl();
		
	paymentServiceInf.PaymentRequest(paymentVO);
		
		
		return SUCCESS;
	

}


public String PaymentDetailsGrid() throws Exception {

	PaymentServiceInf  paymentServiceInf= new  PaymentServiceImpl();
	paymentDetailsList =  paymentServiceInf.retrivePaymentDetailsGrid(paymentVO);
	
	
	if ( paymentDetailsList == null) {
		logger.error("Error:While getting payment details as per advance search.");
		addActionError("No records found.");
		return ERROR;
	} else {
		logger.info("Records found successfully.");
		return SUCCESS;
	}
}



public String editPaymentDetails() throws Exception {
	
	try {
		int pyamentID = Integer.parseInt(request.getParameter("command"));
		
		LoginUtil.setProcessUserId(pyamentID);
		
		paymentServiceInf = new PaymentServiceImpl();
		this.paymentVO = VOMapperHelper.getpaymentFromPayment(paymentVO,
				paymentServiceInf.editPaymentDetails(pyamentID));

		return SUCCESS;
	} catch (NullPointerException exception) {
		logger.error("Fail to get edit payment details ! ", exception);
		return ERROR;
	}
}


public String updatePaymentDetails() throws Exception {

	
	int pyamentID = LoginUtil.getProcessUserId();
	String message = paymentServiceInf.updatePaymentDetails(paymentVO, pyamentID);

	if (OMIConstants.TARGET_SUCCESS.equalsIgnoreCase(message)) {

		logger.info("Successfully Updated payment Information!");
		addActionMessage("Successfully Updated payment Information!");
		return SUCCESS;

	} else if (OMIConstants.TARGET_FAILURE.equalsIgnoreCase(message)) {

		logger.info("Error:while  Updating payment Information!");
		addActionError("Error:while  Updating payment Information!");
		return ERROR;
	}
	else  {
		logger.info("Error:while  Updation payment Details!");
		addActionError("Error:while  Updation payment Details!");
		return ERROR;
	}
}




public String deletePaymentDetails() throws Exception{
	
	try {
		
		int pyamentID = Integer.parseInt(request.getParameter("command"));
		paymentServiceInf.deletePaymentDetail(pyamentID);
		return SUCCESS;
		
		} catch (Exception exception ) {
			
			logger.error("ERROR:Erroe while delete payment details from database.");
			return ERROR;
		}
	
	
	
}




public List<PaymentVO> getPaymentDetailsList() {
	return  paymentDetailsList;
}

public void setPaymentDetailsList(List<PaymentVO>  paymentDetailsList) {
	this. paymentDetailsList =  paymentDetailsList;
}




public Map<Integer, String> getPaymentSelectList() {
	return paymentSelectList;
}

public void setPaymentSelectList(Map<Integer, String> paymentSelectList) {
	this.paymentSelectList = paymentSelectList;
}





public void setSession(Map<String, Object> arg0) {
	// TODO Auto-generated method stub
	
}



@Override
public void setServletResponse(HttpServletResponse arg0) {
	// TODO Auto-generated method stub
	
}


@Override
public void setServletRequest(HttpServletRequest arg0) {
	// TODO Auto-generated method stub
	
}


@Override
public PaymentVO getModel() {
	// TODO Auto-generated method stub
	return this.paymentVO;
}


	
	
	
	
	
}
