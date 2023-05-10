/*
 **********************************************************************
 *
 * COPYRIGHT. $ID$ 2015. ALL RIGHTS RESERVED.
 *
 * This software is only to be used for the purpose for which it has been
 * provided. No part of it is to be reproduced, disassembled, transmitted,
 * stored in a retrieval system nor translated in any human or computer
 * language in any way or for any other purposes whatsoever without the
 * prior written consent of $ID$.
 * 
 * Class Name     CustomerRegistration.java     
 *                                                            
 * Creation Date  AUG 20, 2015 
 * 
 * Abstract       This is Name helper class to retrieve data from database 
 *                and returns name of value based on input.
 *  
 * Amendment History (in chronological sequence): AUG 10, 2015 
 * 
 **********************************************************************
 */

package com.bst.ckt.action;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.bst.ckt.common.LoginUtil;
import com.bst.ckt.common.OMIConstants;
import com.bst.ckt.dao.AjaxDaoImpl;
import com.bst.ckt.dao.CustomerDaoImpl;
import com.bst.ckt.dao.CustomerDaoInf;
import com.bst.ckt.exception.OMIApplicationException;
import com.bst.ckt.helper.ListHelper;
import com.bst.ckt.service.CustomerServiceImpl;
import com.bst.ckt.service.CustomerServiceInf;
import com.bst.ckt.vo.LoginVO;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 
 * @author Yogendra singh Rajput
 * @version V1.0 21 August 2015
 */
public class CustomerLoginAction extends ActionSupport implements
		ServletRequestAware, ModelDriven<LoginVO>, ServletResponseAware,
		SessionAware {

	/**
	 * Creating Logger object, logger object mapped with CustomerLoginAction
	 * class for writing Loggers.
	 */
	private static final Logger logger = Logger
			.getLogger(CustomerLoginAction.class);

	private static final long serialVersionUID = -8739214642372421951L;

	LoginVO loginVO = new LoginVO();
	AjaxDaoImpl ajaxDaoImpl = new AjaxDaoImpl();

	SessionMap<String, Object> session;
	private HttpServletRequest request;
	private HttpServletResponse response;
	ListHelper listHelper=new ListHelper();
	CustomerServiceInf customerServiceInf = new CustomerServiceImpl();
	private Map<Integer, String> countryList;
	private Map<Integer, String> currencyList;
	private Map<Integer, String> timeZoneList;
	private Map<Integer, String> languageList;
	private Map<Integer, String> shopList;

	
	public String configurationList()throws Exception{
		setCountryList(listHelper.countryList());
		setCurrencyList(listHelper.currencyList());
		setTimeZoneList(listHelper.timeZoneList());
		setLanguageList(listHelper.languageList());
		setShopList(listHelper.shopList());
		return SUCCESS;
	}
	
	
	@Override
	public String execute() throws Exception {

		try {
			String loggedInStatus = LoginUtil.customerLogin(loginVO);

			if (loggedInStatus.equals(OMIConstants.TARGET_USER_VERIFIED)) {
				logger.info("Customer User login Successfull:");
				
				try {
					
					customerServiceInf.addLoginInformation();
				} catch (OMIApplicationException omiApplicationException) {
					logger.error(
							"Fail to log customer login details into database:",
							omiApplicationException);
				}
				String loginFlag = LoginUtil.getCurrentCustomerUser().getLoginFlag();
				System.out.println("loginFlag "+loginFlag);
				String loggedInUserFlagTarget = LoginUtil.getLoginFlag(loginFlag);
				
				
				System.out.println("loggedInUserFlagTarget "+loggedInUserFlagTarget);
				if(loggedInUserFlagTarget.equals(OMIConstants.TARGET_CONFIGURATION_SETTING_SAVE)){
					
					LoginUtil.setProcessUserId(loginVO.getShopId());
					System.out.println(loginVO.getShopId()+"lllllllllloggggin bharti shop id in first");
					//When user saved the configuration
					return SUCCESS;//Move to dashboard
				}if(loggedInUserFlagTarget.equals(OMIConstants.TARGET_USER_LOGIN_FIRST)){
					//When user saved the configuration
					return INPUT;//Move to dashboard
				}if(loggedInUserFlagTarget.equals(OMIConstants.TARGET_FIRST_LOGIN_PASSWORD_CHANGED)){
					//When user saved the configuration
					return LOGIN;//Move to dashboard
				}else{
					return INPUT;//First Time Change password
				}

			} else if (loggedInStatus
					.equals(OMIConstants.TARGET_USER_NOT_VERIFIED)) {
				logger.error("Customer User login failure, Please see the exception above:");
				addActionError("User Login Failed, Please enter correct password.");
				return ERROR;
			} else if (loggedInStatus
					.equals(OMIConstants.TARGET_USER_NOT_ACTIVE)) {
				logger.error("Customer User login failure due to User Status not Active, Please see the exception above:");
				addActionError("User Login Failed due to User Status not Active, Please contact to System Admin.");
				return ERROR;
			}else if (loggedInStatus
					.equals(OMIConstants.TARGET_USER_SUSPENDED)) {
				logger.error("Customer User login failure due to User Status is Suspend, Please see the exception above:");
				addActionError("User Login Failed due to User Status is Suspend, Please contact to System Admin.");
				return ERROR;
			}else if (loggedInStatus
					.equals(OMIConstants.TARGET_USER_INACTIVE)) {
				logger.error("Customer User login failure due to User Status is Inactive, Please see the exception above:");
				addActionError("User Login Failed due to User Status is Inactive, Please contact to System Admin.");
				return ERROR;
			}else if (loggedInStatus
					.equals(OMIConstants.TARGET_USER_DELETED)) {
				logger.error("Customer User login failure due to User Status is Deleted, Please see the exception above:");
				addActionError("User Login Failed due to User Status is Deleted, Please contact to System Admin.");
				return ERROR;
			}else if (loggedInStatus
					.equals(OMIConstants.TARGET_USER_REGISTERED)) {
				logger.error("Customer User login failure due to User Status is Regitered, Please see the exception above:");
				addActionError("User Login Failed due to User Status is Regitered, Please contact to System Admin.");
				return ERROR;
			}else if (loggedInStatus
					.equals(OMIConstants.TARGET_USER_SUBMITTED)) {
				logger.error("Customer User login failure due to User Status is Submited, Please see the exception above:");
				addActionError("User Login Failed due to User Status is Submited, Please contact to System Admin.");
				return ERROR;
			}else if(loggedInStatus.equals(OMIConstants.TARGET_USER_PRIMARY_EMAIL_ID_NOT_CORRECT)){
				logger.error("Customer User login failure due to  Email-id is not correct, Please enter correct Email-id.:");
				addActionError("User Login Failed due to User Email-id is not correct, Please enter correct Email-id.");
				return ERROR;
			}else if(loggedInStatus.equals(OMIConstants.TARGET_USER_PASSWORD_NOT_CORRECT)){
				logger.error("Customer User login failure due to User Password in not correct, Please enter correct password");
				addActionError("User Login Failed due to User Password in not correct, Please enter correct password.");
				return ERROR;
			}else if(loggedInStatus.equals(OMIConstants.TARGET_USER_PASSWORD_AND_EMAIL_NOT_CORRECT)){
				logger.error("Customer User login failure due to User Email-id & password, please enter correct Email-id & password"); 
				addActionError("User Login Failed due to User Email-id & password, please enter correct Email-id & password");
				return ERROR;
			}
			else {
				logger.error("Customer User login failure, Please see the exception above:");
				addActionError("System Error -User Login Failed, Please contact to System Admin.");
				return ERROR;
			}
		} catch (Exception exception) {
			addActionError("User Login Failed, Please enter correct email id and password.");
			return INPUT;
		}

	}

	/**
	 * 
	 * @return
	 */
	public String firstLoginChangePassword()throws Exception{
		customerServiceInf=new CustomerServiceImpl();
		try {
			String loginFlag = LoginUtil.getCurrentCustomerUser().getLoginFlag();
			String loggedInUserFlagTarget = LoginUtil.getLoginFlag(loginFlag);
			if(loggedInUserFlagTarget.equals(OMIConstants.TARGET_USER_LOGIN_FIRST)){
				int customerId=LoginUtil.getCurrentCustomerUser().getCustomerId();
				String target=customerServiceInf.updateLoginPassword(loginVO,customerId);
				if(target.equals(OMIConstants.TARGET_SUCCESS)){
					loginVO=customerServiceInf.getUserRole(customerId);
					if(loginVO!=null){
						if(loginVO.getUserRole()==4){
							return SUCCESS;
						}
					}else if(loginVO.getUserRole()>=5){
						return LOGIN;
					}
					
					return SUCCESS;
				}else if(target.equals(OMIConstants.TARGET_FAILURE)){
				//getLoginFlagTarget
					return INPUT;
				}else{
					return INPUT;
				}
			
			}else{
			return NONE;//move to save configuration page
			}
		} catch (Exception exception) {
			addActionError("User Login Failed, While Update password.");
			return INPUT;
		}
		
		
	}
	
	/**
	 * 
	 * @return
	 */
	public String firstLoginConfigurationSetting()throws Exception{
		try {
			String loginFlag = LoginUtil.getCurrentCustomerUser().getLoginFlag();
			String loggedInUserFlagTarget = LoginUtil.getLoginFlag(loginFlag);
			int customerId=LoginUtil.getCurrentCustomerUser().getCustomerId();
			if(loggedInUserFlagTarget.equals(OMIConstants.TARGET_FIRST_LOGIN_PASSWORD_CHANGED)){
				String target=customerServiceInf.updateLoginConfigurationSetting(loginVO,customerId);			
				
				if(target.equals(OMIConstants.TARGET_FAILURE)){
					return ERROR;
				}else{
				return SUCCESS; //Move to dashboard
				}
			}else{
				return INPUT;//first time loing chage password
			}
		} catch (Exception e) {
			addActionError("User Login Failed, While Update Company Setting.");
			return INPUT;
		}
		
	}
	
	/**
	 * <p>
	 * <code>isEmailAlreadySaved()</code> method verify whether the email id
	 * already exists
	 * </p>
	 * 
	 * @return
	 * @throws Exception
	 */
	public String isEmailAlreadySaved() throws Exception {

		try {

			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
			PrintWriter printWriter = response.getWriter();

			if (ajaxDaoImpl.isEmailAlreadySaved(request.getParameter(
					"primaryEmailId").trim()) == 1) {

				printWriter
						.print("<img alt='Email Id Available' title='Email Id Available' src='outer/img/availavle.png'></img>");

			} else if (request.getParameter("primaryEmailId").trim().equals("")) {
				printWriter
						.print("<img alt='Email id is Blank' height='30px' width='30px'  title=' Email id is Blank' src='outer/img/blank.jpeg'></img>");

			}

			else {
				printWriter
						.print("<img alt='Email Id Not Registered' title='Email Id Not Registered.' src='outer/img/availavle.png'></img>");
			}

		} catch (Exception exception) {
			logger.error(
					"Error While verifying whether  the email id already exists ",
					exception);
		}
		return NONE;
	}

	/**
	 * <p>
	 * <code>customerUserLogout()</code> method is used to maintain the user Logger
	 * </p>
	 * 
	 * @return SUCCESS
	 * @throws Exception
	 */
	public String customerUserLogout() throws Exception {

		String loginTime = LoginUtil.getCurrentCustomerUser()
				.getLoginDateTime();
		CustomerDaoInf customerDaoInf = new CustomerDaoImpl();

		customerDaoInf.updateUserLogger(loginTime);
		try {
			boolean loggedInStatus = LoginUtil.isCustomerUserLogged();

			if (loggedInStatus == true) {
				logger.info("Customer User session is live:");
				try {
					LoginUtil.logoutCustomerUser();
					session.invalidate();
					
					System.out.println("session.invalidate();");
				} catch (Exception exception) {
					logger.error("Fail to logout customer :", exception);
				}
				addActionMessage("User logout successful,  Please enter correct email id and password for login.");
				return SUCCESS;
			} else {
				logger.error("Customer User logout failure, Please see the exception above:");
				addActionError("User Logout Failed, User is not logged into system.");
				return ERROR;
			}
		} catch (Exception exception) {
			addActionError("User session expire, Please enter correct email id and password for login.");
			return INPUT;
		}
	}

	
	public void userLogger() throws OMIApplicationException {
		int customerId = LoginUtil.getCurrentCustomerUser().getCustomerId();
		String loginTime = LoginUtil.getCurrentCustomerUser()
				.getLoginDateTime();
		String ipAddress = LoginUtil.getIPAddress();
		customerServiceInf = new CustomerServiceImpl();
		/*customerServiceInf.regitertUserLoggerDetail(customerId, ipAddress,
				loginTime);*/

	}

	public void setSession(Map<String, Object> map) {
		this.session = (SessionMap<String, Object>) map;

	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	/**
	 * set response object
	 */
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public LoginVO getModel() {

		return this.loginVO;
	}

	/**
	 * @return the loginVO
	 */
	public LoginVO getLoginVO() {
		return loginVO;
	}

	/**
	 * @param loginVO
	 *            the loginVO to set
	 */
	public void setLoginVO(LoginVO loginVO) {
		this.loginVO = loginVO;
	}


	/**
	 * @return the countryList
	 */
	public Map<Integer, String> getCountryList() {
		return countryList;
	}


	/**
	 * @param countryList the countryList to set
	 */
	public void setCountryList(Map<Integer, String> countryList) {
		this.countryList = countryList;
	}


	/**
	 * @return the currencyList
	 */
	public Map<Integer, String> getCurrencyList() {
		return currencyList;
	}


	/**
	 * @param currencyList the currencyList to set
	 */
	public void setCurrencyList(Map<Integer, String> currencyList) {
		this.currencyList = currencyList;
	}


	public Map<Integer, String> getTimeZoneList() {
		return timeZoneList;
	}


	public void setTimeZoneList(Map<Integer, String> timeZoneList) {
		this.timeZoneList = timeZoneList;
	}


	/**
	 * @return the languageList
	 */
	public Map<Integer, String> getLanguageList() {
		return languageList;
	}


	/**
	 * @param languageList the languageList to set
	 */
	public void setLanguageList(Map<Integer, String> languageList) {
		this.languageList = languageList;
	}


	public Map<Integer, String> getShopList() {
		return shopList;
	}


	public void setShopList(Map<Integer, String> shopList) {
		this.shopList = shopList;
	}

	
}
