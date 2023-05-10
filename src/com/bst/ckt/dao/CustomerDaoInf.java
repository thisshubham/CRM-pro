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
 * Class Name     CustomerDaoInf.java     
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

package com.bst.ckt.dao;

import java.util.List;

import com.bst.ckt.dto.Customer;
import com.bst.ckt.exception.OMIApplicationException;
import com.bst.ckt.exception.RecordNotFoundException;
import com.bst.ckt.exception.UpdateFailedException;
import com.bst.ckt.vo.CompanyVO;
import com.bst.ckt.vo.CustomerVO;
import com.bst.ckt.vo.LoginVO;

public interface CustomerDaoInf<UserLoggerVO> {

	/**
	 * 
	 * @param emailId
	 * @param password
	 * @return
	 * @throws RecordNotFoundException
	 */
	public Customer findCustomerUserByEmailId(String emailId)
			throws RecordNotFoundException;

	/**
	 * <p>
	 * This method is used to get Company details based on companyRefNo.
	 * 
	 * @param custReferenceNo
	 * @return
	 * @throws Exception
	 */
	Customer getCompanyDetails(String compnayReferenceNo) throws Exception;

	/**
	 * <p>
	 * <code>insertQuickRegistraionDetails(CompanyVO companyVO)</code> Method
	 * designed to insert form data to database.
	 * </p>
	 * 
	 * @param companyVO
	 * @throws Exception
	 */
	void insertQuickRegistraionDetails(CompanyVO companyVO) throws Exception;

	/**
	 * 
	 * @param trim
	 * @return
	 */
	int isEmailAlreadyExist(String trim);

	/**
	 * 
	 * @param refNo
	 * @return
	 */
	int getCompanyIdByRef(String refNo);

	/**
	 * 
	 * @param companyId
	 * @param activeId
	 * @param createdBy
	 */
	void updateCustomerStatus(int companyId, int activeId, int createdBy);

	/**
	 * 
	 * @param companyRefNo
	 * @return
	 * @throws UpdateFailedException
	 */
	int updateEmailFlagCustomerRegistration(String companyRefNo)
			throws UpdateFailedException;

	/**
	 * 
	 * @param customer
	 * @throws Exception
	 */
	void createCompany(Customer customer) throws Exception;

	/**
	 * 
	 * @param customer
	 * @param companyId
	 * @param password
	 * @throws Exception
	 */
	void createCustomer(Customer customer, int companyId, String password)
			throws Exception;

	/**
	 * 
	 * @param primaryEmailId
	 * @param emailFlag
	 * @throws Exception
	 */
	public void updateCustomerEmailFlagByEmail(String primaryEmailId,
			String emailFlag) throws Exception;
	
	
	/**
	 * <p>
	 * <code>insertUserLoggerDetail(int customerId, String ipAddress,
			String loginTime)</code> Method designed to insert form data to database.
	 * </p>
	 * 
	 * @param LoginVO
	 * @throws Exception
	 */

	public void insertUserLoggerDetail(int customerId, String ipAddress,
			String loginTime) throws OMIApplicationException;

	/**
	 * <p>
	 * <code>updateUserLogger()</code>
	 *  Method designed to update user logger into database.
	 * </p>
	 * 
	 * @param loginTime String
	 * @throws OMIApplicationException;
	 */
	public void updateUserLogger(String loginTime) throws OMIApplicationException;

	/**
	 * <p>
	 * <code>getUserLoggerDetails()</code> 
	 * Method designed to get user logger details form database.
	 * </p>
	 * 
	 * @param LoginVO
	 * @throws OMIApplicationException
	 */
	public List<UserLoggerVO> getUserLoggerDetails(int coustomerId)throws OMIApplicationException ;

	
	/**
	 * <p>
	 * <code>getUserDetails()</code> 
	 * Method designed to get user details form database.
	 * </p>
	 * 
	 * @param customerVO CustomerVO
	 * @throws OMIApplicationException
	 */
	public CustomerVO getUserDetails(CustomerVO customerVO)throws OMIApplicationException ;

	/**
	 * 
	 * @param loginVO
	 * @throws OMIApplicationException
	 */
	public int getPassword(LoginVO loginVO)throws OMIApplicationException;

	/**
	 * 
	 * @param loginVO
	 * @return
	 * @throws OMIApplicationException
	 */
	public int updateCustomerLoginPassword(LoginVO loginVO,int customerId)throws OMIApplicationException;

	/**
	 * 
	 * @param loginVO
	 * @param customerId
	 * @return
	 * @throws OMIApplicationException
	 */
	public int updateLoginConfigurationSetting(LoginVO loginVO, int customerId)throws OMIApplicationException;
	

	/**c
	 * 
	 * @param loginVO
	 * @param customerId
	 * @return
	 * @throws OMIApplicationException
	 */
	public int getUpdatedPassword(LoginVO loginVO, int customerId)throws OMIApplicationException;

	public LoginVO getUserRole(int customerId)throws OMIApplicationException;

	public void insertForgetPasswordRegistraionDetails(CompanyVO companyVO)throws OMIApplicationException;

	public Customer getForgetPasswordDetails(String custReferenceNo) throws Exception;

	public int updateEmailFlagForgetPassword(String companyRefNo)throws UpdateFailedException;
	
	/** <p>
	 * <code>showSecurityQuestion()</code> 
	 * </p>
	 * @param primaryEmailID
	 * @return
	 * @throws OMIApplicationException
	 */

	public CustomerVO showSecurityQuestion(String primaryEmailID) throws OMIApplicationException;
	
	/** <p>
	 * <code>checkPrimaryEmailIdAndPassword()</code> 
	 * </p>
	 * @param primaryEmailID
	 * @param answer
	 * @return
	 * @throws OMIApplicationException
	 */

	public CustomerVO checkPrimaryEmailIdAndPassword(String primaryEmailID,
			String answer)throws OMIApplicationException;
	
	/** <p>
	 * <code>updateCustomerLoginPassword()</code> 
	 * </p>
	 * @param customerVO
	 * @param customerId
	 * @return
	 * @throws OMIApplicationException
	 */

	public int updateCustomerLoginPassword(CustomerVO customerVO,
			int customerId) throws OMIApplicationException;
	
	/** <p>
	 * <code>getUpdatedPassword()</code> 
	 * </p>
	 * @param customerVO
	 * @param customerId
	 * @return
	 * @throws OMIApplicationException
	 */

	public int getUpdatedPassword(CustomerVO customerVO, int customerId)throws OMIApplicationException;

	

}
