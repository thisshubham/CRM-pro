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

import nl.captcha.Captcha;

import org.apache.log4j.Logger;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.bst.ckt.common.OMIConstants;
import com.bst.ckt.dao.AjaxDaoImpl;
import com.bst.ckt.exception.OMIApplicationException;
import com.bst.ckt.helper.ListHelper;
import com.bst.ckt.service.CustomerServiceImpl;
import com.bst.ckt.service.CustomerServiceInf;
import com.bst.ckt.vo.CompanyVO;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CustomerRegistration extends ActionSupport implements
		ServletRequestAware, ModelDriven<CompanyVO>, ServletResponseAware,
		SessionAware {

	/**
	 * Creating Logger object, logger object mapped with CustomerRegistration
	 * class for writing Loggers.
	 */
	private static final Logger logger = Logger
			.getLogger(CustomerRegistration.class);

	private static final long serialVersionUID = -8739214642372421951L;
	ListHelper listHelper = null;

	CompanyVO companyVO = new CompanyVO();
	AjaxDaoImpl ajaxDaoImpl = new AjaxDaoImpl();
	public Map<Integer, String> countryList;

	SessionMap<String, Object> session;
	private HttpServletRequest request;
	private HttpServletResponse response;	
	CustomerServiceInf customerServiceInf = null;

	public CustomerRegistration() throws Exception{
		listHelper = new ListHelper();
		countryList = listHelper.countryList();
		
	}
public String execute()
{
	return SUCCESS;
	}

	/**
	 * <p><code>customerQuickRegistration()</code> Method designed to register the customer Admin user.</p>
	 * @return result String 
	 * @throws Exception
	 */
	public String customerQuickRegistration() throws Exception {
		//Get Captch answer from registration page
		Captcha captcha = (Captcha) session.get(Captcha.NAME);
		String answer = companyVO.getAnswer();
		
		// if captcha is correct the do registration else redirect to registration page with error message.
		if (captcha.isCorrect(answer)) {

			//if we get Company Id from registration page then only we can mover for registration page.
			if (companyVO.getCompanyEmailId()!= null) {

				/*
				 * quickRegistration method calls to register customer, it
				 * returns target.
				 */

				try{
					customerServiceInf = new CustomerServiceImpl();

				String target = customerServiceInf.quickRegisterCustomer(companyVO);
				
				if(target.equals(OMIConstants.TARGET_SUCCESS)){
					addActionMessage("Cutomer Registion Successfully Completed. Please check your registerd email for verification");
					return SUCCESS;
				}else if(target.equals(OMIConstants.TARGET_FAILURE)){
					addActionError("Your registration process get failed, Please try again.");
				}else if(target.equals(OMIConstants.TARGET_EMAIL_FLAG_UPDATION_FAILED)){
					addActionError("Your verification email sent to your email id, Please verify to click the verification link.");
					return ERROR;
				}else if(target.equals(OMIConstants.TARGET_VERIFICATION_EMAIL_SEND_FAILED)){
					addActionError("Your verification email send failed, Please contact to support team or try to register again.");
				
				}
				}catch(OMIApplicationException omiApplicationException){
					logger.error("Error while register customer, Please contact support team for any assistance.");
					addActionError("Error while register customer, Please contact support team for any assistance.");
					return ERROR;
				}
			}else{
				logger.info("Please enter valid details to register your account.");
				addActionError("Please enter correct details to register.");
			}
		} else {
			logger.info("Captcha Code Does not Match.");
			addActionError("Please enter correct captcha code or refresh to generate the New Captcha.");

		}
		return INPUT;
	}


	/**
	 * isMobileNoAlreadyExists method verify whether the mobile number already
	 * exists
	 * 
	 * @return
	 * @throws Exception
	 */
	public String isMobileNoAlreadyExists() throws Exception {

		try {
			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
			PrintWriter printWriter = response.getWriter();

			if (ajaxDaoImpl.isMobileNoAlreadyExists(request.getParameter("mobileNo").trim()) == 1) {
				printWriter
						.print("<img alt='Mobile Number Alreay Exist' title='Mobile Number Alreay Exist' src='outer/img/exist.png'></img>");

			} else if (companyVO.getMobileNo().equals("")) {
				printWriter
						.print("<img alt='Mobile no is Blank' height='30px' width='30px'  title=' Mobile no is Blank' src='outer/img/blank.jpeg'></img>");

			} else {
				printWriter
						.print("<img alt='Mobile Number Available' title='Mobile Number Available' src='outer/img/availavle.png'></img>");
			}
		} catch (Exception exception) {
			logger.error("Error While verifying the  company name ", exception);

		}
		return null;
	}

	/**
	 * isEmailAlreadyExist method verify whether the email id already exists
	 * 
	 * @return
	 * @throws Exception
	 */
	public String isEmailAlreadyExist() throws Exception {

		try {

			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
			PrintWriter printWriter = response.getWriter();

			if (ajaxDaoImpl.isEmailAlreadyExist(request.getParameter("companyEmailId").trim()) == 1) {
				printWriter
						.print("<img alt='Email Id is blank' title='Email Id is blank' src='outer/img/exist.png'></img>");

			} else if (companyVO.getCompanyEmailId().equals("")) {
				printWriter
						.print("<img alt='Mobile no is Blank' height='30px' width='30px'  title=' Mobile no is Blank' src='outer/img/blank.jpeg'></img>");

			}

			else {
				printWriter
						.print("<img alt='Email Available' title='Email Id Available' src='outer/img/availavle.png'></img>");
			}

		} catch (Exception exception) {
			logger.error(
					"Error While verifying whether  the email id already exists ",
					exception);
		}
		return NONE;
	}

	/**
	 * isEmailRegistered method verify whether the email id already 
	 * Registered for forgot password or not.
	 * 
	 * @return
	 * @throws Exception
	 */
	public String isEmailRegistered() throws Exception {

		try {

			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
			PrintWriter printWriter = response.getWriter();

			if (ajaxDaoImpl.isEmailAlreadyExist(companyVO
					.getCompanyEmailId().trim()) == 1) {
				printWriter
						.print("<img alt='Email Id is blank' title='Email Id is blank' src='outer/img/exist.png'></img>");

			} else if (companyVO.getCompanyEmailId().equals("")) {
				printWriter
						.print("<img alt='Mobile no is Blank' height='30px' width='30px' style='margin-top:10px;' title=' Mobile no is Blank' src='outer/img/blank.jpeg'></img>");

			}

			else {
				printWriter
						.print("<img alt='Email Available' title='Email Id Available' src='outer/img/availavle.png'></img>");
			}

		} catch (Exception exception) {
			logger.error(
					"Error While verifying whether  the email id already exists ",
					exception);
		}
		return NONE;
	}


	/**
	 * <p><code>verifyCustomer()</code> Method designed to verify customer email id and register company along with customer creation. </p>
	 * @return result String
	 */
	public String verifyCustomer() {
		String custReferenceNo = request.getParameter("validateId");
		customerServiceInf = new CustomerServiceImpl();
		String target = customerServiceInf.verifyCustomerReferenceNo(custReferenceNo);		
		if(target.equals(OMIConstants.TARGET_SUCCESS)){
			addActionMessage("Your Email Verification complted, Please check you email for login details.");
			return SUCCESS;
		}else if(target.equals(OMIConstants.TARGET_CUSTOMER_USER_ALREADY_REGISTERED)){
			addActionError("Your Email Verification already completed, Please check your email id for login credentials.");
			return ERROR;
		}
		else if(target.equals(OMIConstants.TARGET_COMPANY_FAILED)){
			addActionError("Your Email Verification complted, But company registration failed. Please contact our support team.");
			return ERROR;
		}else{
			addActionError("Your Email Verification failed, Please try agin or contact our support team.");
			return ERROR;
		}
	}

	/**
	 * 
	 */
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

	public Map<Integer, String> getCountryList() {
		return countryList;
	}

	public void setCountryList(Map<Integer, String> countryList) {
		this.countryList = countryList;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public CompanyVO getModel() {

		return this.companyVO;
	}

	public CompanyVO getCompanyVO() {
		return companyVO;
	}

	public void setCompanyVO(CompanyVO companyVO) {
		this.companyVO = companyVO;
	}

}
