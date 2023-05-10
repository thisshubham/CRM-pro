package com.bst.ckt.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.bst.ckt.common.OMIConstants;
import com.bst.ckt.service.CustomerServiceImpl;
import com.bst.ckt.service.CustomerServiceInf;
import com.bst.ckt.vo.CustomerVO;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ForgetPasswordAction extends ActionSupport implements
		ModelDriven<CustomerVO>, SessionAware, ServletRequestAware,
		ServletResponseAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	CustomerVO customerVO = new CustomerVO();
	private HttpServletRequest request;
	CustomerServiceInf customerServiceInf = new CustomerServiceImpl();
	private HttpServletResponse response;
	private SessionMap<String, Object> session;

	/**
	 * <p>
	 * <code>forgetPasswordSecurityQuestion()</code> Method designed fetch the
	 * Security question from customer user table.
	 * </p>
	 * 
	 * @return result String
	 * @throws Exception
	 */
	public String forgetPasswordSecurityQuestion() throws Exception {
		String primaryEmailID = request.getParameter("primaryEmailId");
		
		if (primaryEmailID != null) {

			customerVO = customerServiceInf
					.ForgetPasswordSecurityQuestion(primaryEmailID);

			return SUCCESS;
		} else {
			System.out.println("Security Question not found");
			return ERROR;
		}
	}

	/**
	 * <p>
	 * <code>checkEmailIdAndAnswer()</code> Method designed compare the answer
	 * of Question from perticuler user from customer user table and send the password into his email
	 * address .
	 * </p>
	 * 
	 * @return result String
	 * @throws Exception
	 */
	public String checkEmailIdAndAnswer() throws Exception {

		String answer = request.getParameter("answer");
		String primaryEmailID = customerVO.getPrimaryEmailId();

		String message = customerServiceInf.checkEmailIdAndPassword(
				primaryEmailID, answer);
		if (message.equals(OMIConstants.TARGET_SUCCESS)) {
			addActionMessage("Your Forget Password Verification Successfully complted, Please check you email for Update Password details.");
			return SUCCESS;
		}
		 else if (message.equals(OMIConstants.TARGET_FAILURE)) {
			addActionError(" Please enter currect answer");
			return ERROR;
		} else {
			addActionError("Your Email Verification failed, Please try agin or contact our support team.");
			return ERROR;
		}
	}

	@Override
	public CustomerVO getModel() {

		return customerVO;
	}

	public CustomerVO getCustomerVO() {
		return customerVO;
	}

	public void setCustomerVO(CustomerVO customerVO) {
		this.customerVO = customerVO;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public SessionMap<String, Object> getSession() {
		return session;
	}

	public void setSession(SessionMap<String, Object> session) {
		this.session = session;
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;

	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;

	}

	@Override
	public void setSession(Map<String, Object> map) {
		this.session = (SessionMap<String, Object>) map;

	}

}
