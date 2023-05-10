package com.bst.ckt.service;

import com.bst.ckt.dto.Customer;
import com.bst.ckt.exception.OMIApplicationException;
import com.bst.ckt.vo.CompanyVO;
import com.bst.ckt.vo.CustomerVO;
import com.bst.ckt.vo.LoginVO;

public interface CustomerServiceInf {

	public Customer verifyCustomerUserCredentials(String emailId) throws OMIApplicationException;

	/**
	 * <p>
	 * This method will verify the new customer email id with their
	 * custReferenceNo. If<code> Verified </code>, then it will activate the
	 * user account and add customer information to Customer User database.
	 * </p>
	 * 
	 * @param custReferenceNo
	 * @return target String
	 */
	String verifyCustomerReferenceNo(String custReferenceNo);

	/**
	 * 
	 * @param companyVO
	 * @return
	 * @throws OMIApplicationException
	 */
	String quickRegisterCustomer(CompanyVO companyVO)
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>addLoginInformation()</code> Method is design to insert the
	 * customer login details into database to maintain user logger.
	 * </p>
	 * 
	 * @throws OMIApplicationException
	 */
	public void addLoginInformation() throws OMIApplicationException;

	/**
	 * <p>
	 * <code>viewUserInformation()</code> Method is design to get the customer
	 * details from database for view page.
	 * </p>
	 * 
	 * @throws OMIApplicationException
	 * @param customerVO
	 *            CustomerVO
	 */
	public CustomerVO viewUserInformation(CustomerVO customerVO)
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>updateLoginPassword</code>Method Is use to update user first Login
	 * Password
	 * </p>
	 * 
	 * @throws OMIApplicationException
	 * @param LoginVO
	 *            loginVO,int customerId
	 */
	public String updateLoginPassword(LoginVO loginVO, int customerId)
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>updateLoginConfigurationSetting</code>Method Is use to First Time
	 * Login Configuration Setting
	 * </p>
	 * 
	 * @param loginVO
	 * @return
	 * @throws OMIApplicationException
	 */
	public String updateLoginConfigurationSetting(LoginVO loginVO,
			int customerId) throws OMIApplicationException;

	/**
	 * 
	 * @param customerId
	 * @return
	 * @throws OMIApplicationException
	 */
	public LoginVO getUserRole(int customerId) throws OMIApplicationException;

	/**
	 * <p>
	 * <code>ForgetPasswordConfigurationSetting</code>Method Is use to Set
	 * Forget Password Configuration Setting
	 * </p>
	 * 
	 * @param loginVO
	 * @return
	 * @throws OMIApplicationException
	 */

	/*
	 * public String forgetPasswordRegisterCustomer(CompanyVO companyVO)throws
	 * OMIApplicationException;
	 * 
	 * public String verifyCustomerForgetReferenceNo(String custReferenceNo);
	 */

	/**
	 * <p>
	 * <code>ForgetPasswordSecurityQuestion</code>Method Is use to Set Forget
	 * Password Configuration Setting
	 * </p>
	 * 
	 * @param primaryEmailID
	 * @return
	 * @throws OMIApplicationException
	 */

	public CustomerVO ForgetPasswordSecurityQuestion(String primaryEmailID)
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>checkEmailIdAndPassword</code>Method Is use to check the Answer and
	 * send the password of perticular email-id 
	 * </p>
	 * 
	 * @param primaryEmailID answer
	 * @return
	 * @throws OMIApplicationException
	 */
	public String checkEmailIdAndPassword(String primaryEmailID, String answer)
			throws OMIApplicationException;

}
