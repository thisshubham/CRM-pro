/**
 * 
 */
package com.bst.ckt.support;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.bst.ckt.common.OMIConstants;
import com.bst.ckt.exception.OMIApplicationException;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @author Rosu
 * 
 */
public class ContactSupportAction extends ActionSupport implements
		ServletRequestAware, ModelDriven<ContactSupportVO>, ServletResponseAware,
		SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Creating Logger object, logger object mapped with ContactSupportAction class for
	 * writing Loggers.
	 */
	private static final Logger logger = Logger.getLogger(ContactSupportAction.class);
	
	HttpServletResponse response = null;
	HttpServletRequest request = (HttpServletRequest) ActionContext
			.getContext().get(ServletActionContext.HTTP_REQUEST);
	
	ContactSupportVO contactSupportVO=new ContactSupportVO();
	ContactSupportServiceInf contactSupportServiceInf=new ContactSupportServiceImpl();
	
	public String execute()
	{
		return SUCCESS;
		}
	
	/**
	 * <p><code>addContactSupport</code>Method will get data of outer user from contactUs form</p>
	 * 
	 * @param contactSupportVO
	 * @author Rosu
	 * @return SUCCESS
	 * @throws OMIApplicationException
	 */
	public String addContactSupport()throws OMIApplicationException {
		
		String message=contactSupportServiceInf.addContactSupportDetails(contactSupportVO);
		
		
		if (OMIConstants.TARGET_SUCCESS.equalsIgnoreCase(message)) {
			logger.info("Successfully Insert Contact Support Details!");
			addActionMessage("Successfully Insert Contact Support Details!");
			return SUCCESS;

		} else if (OMIConstants.TARGET_FAILURE.equalsIgnoreCase(message)) {

			logger.info("Error:while  Insert Contact Support Details!");
			addActionError("Error:while  Insert Contact Support Details!");
			return ERROR;
		}
		 else  {
				logger.info("Error:while  Insert Contact Support Details!");
				addActionError("Error:while  Insert Contact Support Details!");
				return ERROR;
			}

	
	}
	
	
	
	
	
	
	
	
	
	@Override
	public ContactSupportVO getModel() {
		// TODO Auto-generated method stub
		return contactSupportVO;
	}
	@Override
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

	/**
	 * @return the response
	 */
	public HttpServletResponse getResponse() {
		return response;
	}

	/**
	 * @param response the response to set
	 */
	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	/**
	 * @return the request
	 */
	public HttpServletRequest getRequest() {
		return request;
	}

	/**
	 * @param request the request to set
	 */
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	/**
	 * @return the contactSupportVO
	 */
	public ContactSupportVO getContactSupportVO() {
		return contactSupportVO;
	}

	/**
	 * @param contactSupportVO the contactSupportVO to set
	 */
	public void setContactSupportVO(ContactSupportVO contactSupportVO) {
		this.contactSupportVO = contactSupportVO;
	}

	

}
