package com.bst.ckt.dao;

import com.bst.ckt.exception.EmailAlreadyExistsException;

public interface AjaxDaoInf {
	
	/**
	 * isMobileNoAlreadyExists method verify whether the mobile number already
	 * exists
	 * 
	 * @return
	 * @throws Exception
	 */
	int isMobileNoAlreadyExists(String mobileNo) throws Exception ;
	
	
	/**
	 * isEmailAlreadyExist method verify whether the email id already exists
	 * 
	 * @return
	 * @throws Exception
	 */
	int isEmailAlreadyExist(String primaryEmail)
			throws EmailAlreadyExistsException;
	
	/**
	 * isEmailAlreadySaved method verify whether the email id already exists
	 * 
	 * @return
	 * @throws Exception
	 */
	int isEmailAlreadySaved(String primaryEmail)
			throws EmailAlreadyExistsException;
	/**
	 * 
	 * @param primaryEmail
	 * @return
	 * @throws EmailAlreadyExistsException
	 */
	int emailAlreadyExist(String primaryEmail)
			throws EmailAlreadyExistsException ;
}
