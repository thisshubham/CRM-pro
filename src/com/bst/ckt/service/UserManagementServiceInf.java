package com.bst.ckt.service;

import java.util.List;

import com.bst.ckt.exception.OMIApplicationException;
import com.bst.ckt.vo.CustomerVO;



public interface UserManagementServiceInf {

	/**<p>
	 * <code>RegisterUserDetail()</code>this method is design to add new user
	 * </p>
	 * 
	 * @param customerVO CustomerVO
	 * @return String
	 * @throws OMIApplicationException
	 */
	public String registerUserDetail(CustomerVO customerVO)throws OMIApplicationException;

	/**
	*<p>
	 * <code>verifyCustomerStaffUser()</code>this method is use to verify email
	 * </p> 
	 * @param createUserGuid
	 * @return
	 */
	public String verifyCustomerStaffUser(String referenceId)throws OMIApplicationException;

	
	/**
	 * <p>
	 * <code>updateUserLoginPassword(CustomerVO customerVO)</code>Method is
	 * design to update the password of customer .
	 * </p>
	 * 
	 * @param customerVO
	 *            CustomerVO
	 * @throws Exception
	 *//*
	public String updateUserLoginPassword(CustomerVO customerVO, int customerId)throws OMIApplicationException;*/

	

	/**
	 * <p>
	 * <code>editUserInfo( customerId)</code>Method is
	 * design to update the user info .
	 * </p> 
	 * @param customerVO 
	 * @param customerId
	 * @return
	 * @throws OMIApplicationException
	 */
	public CustomerVO editUserInfo(CustomerVO customerVO, int customerId)throws OMIApplicationException;

	
	

	/**
	 * <p>
	 * <code>updateUserInfo(CustomerVO customerVO, int customerId,
			String filePath, String userImageFileName)</code>Method is
	 * design to update the user info .
	 * </p> 
	 * @param customerVO
	 * @param customerId
	 * @param filePath
	 * @param userImageFileName
	 * @return
	 * @throws OMIApplicationException
	 */
	public String updateUserInfo(CustomerVO customerVO, int customerId,
			String filePath, String userImageFileName)throws OMIApplicationException;

	
	/**
	 * <p>
	 * <code>updateUserLoginPassword(CustomerVO customerVO)</code>Method is
	 * design to update the password of customer .
	 * </p>
	 * 
	 * @param customerVO
	 *            CustomerVO
	 * @throws Exception
	 */
	public String updateUserLoginPassword(CustomerVO customerVO, int customerId)
			throws OMIApplicationException;


/**
	 * <p>
	 * <code>updateUserEmail(CustomerVO customerVO, int customerId)</code>Method
	 * is design to update the user Email Id .
	 * </p>
	 * 
	 * @param customerVO
	 * @param customerId
	 * @return
	 * @throws OMIApplicationException
	 */
	public String updateUserEmail(CustomerVO customerVO, int customerId)
			throws OMIApplicationException;
	
	
	/**
	 * <p>
	 * <code>verifyChangeUserEmail()</code>this method is use to verify changer user email
	 * </p>
	 * 
	 * @param referenceId
	 * @return
	 * @throws OMIApplicationException
	 */
	public String verifyChangeUserEmail(String referenceId)
			throws OMIApplicationException;
	
	/**
	 * <p>
	 * <code>getuserSocialDetailsList()</code>this method is use to get the user social information
	 * </p>

	 * @return List
	 * @throws OMIApplicationException
	 */
	public List<CustomerVO> getuserSocialDetailsList(int customerId) throws Exception;

	/**
	 * <p>
	 * <code>addUserSocialInformation()</code>this method is use to add user social information
	 * </p>

	 * @return List
	 * @throws OMIApplicationException
	 */
	public String addUserSocialInformation(CustomerVO customerVO)throws Exception;
}
