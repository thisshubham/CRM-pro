/**
 * 
 */
package com.bst.ckt.service;

import java.sql.SQLException;

import com.bst.ckt.exception.OMIApplicationException;
import com.bst.ckt.vo.CustomerVO;

/**
 * @author Deepak Vishwakarma
 *
 */
public interface MyAccountServiceInf {

    /**
     * <p><code>editCustomerInfo(CustomerVO customerVO)</code>Method is design to fetch customer information  
     * from database to update user account.</p>
     *
     * @param customerVO CustomerVO
     * @throws SQLException
     */
	public CustomerVO editCustomerInfo(CustomerVO customerVO) throws SQLException;



	/**
	 * <p>
	 * <code>upDateCustomerInfo(CustomerVO customerVO,String filePath,String userImageFileName)</code>
	 * Method is design to update customer information into database to maintain
	 * user account.
	 * </p>
	 * 
	 * @throws SQLException
	 */
	public String upDateCustomerInfo(CustomerVO customerVO, String filePath,
			String userImageFileName) throws Exception;
	
	/**
	 * <p>
	 * <code>updateCustomerLoginPassword(CustomerVO customerVO)</code>Method is
	 * design to update the password of customer .
	 * </p>
	 * 
	 * @param customerVO
	 *            CustomerVO
	 * @throws Exception
	 */
	public String updateCustomerLoginPassword(CustomerVO customerVO)
			throws Exception;
	
	
	/**
	 * <p>
	 * <code>updateCustomerSecqurityQuestion(CustomerVO customerVO)</code>Method
	 * is design to update the customer security question. .
	 * </p>
	 * 
	 * @param customerVO
	 * @return
	 * @throws OMIApplicationException
	 */
	public String updateCustomerSecqurityQuestion(CustomerVO customerVO)
			throws OMIApplicationException;



	/**
	 * <p>
	 * <code>addUserSocialInformation(CustomerVO customerVO)</code>Method
	 * is design to update the customer social information.
	 * </p>
	 * 
	 * @param customerVO
	 * @return
	 * @throws OMIApplicationException
	 */
	public String addUserSocialInformation(CustomerVO customerVO)throws OMIApplicationException;

	/**
	 * <p>
	 * <code>updateUserEmail(CustomerVO customerVO)</code>Method
	 * is design to update the Login User primary  email .
	 * </p> 
	 * @param customerVO
	 * @return
	 * @throws OMIApplicationException
	 */
	public String updateUserEmail(CustomerVO customerVO)throws OMIApplicationException;


	/**
	 * <p>
	 * <code>verifyChangeUserEmail(String referenceId)</code>Method
	 * is design to update the Login User primary  email .
	 * </p> 
	 * @param referenceId
	 * @return
	 * @throws OMIApplicationException
	 */
	public String verifyChangeUserEmail(String referenceId)throws OMIApplicationException;

	/**
	 * <p>
	 * <code>closeUserAcount(CustomerVO customerVO)</code>Method
	 * have the close user account process  .
	 * </p>  
	 * @param customerVO
	 * @return
	 * @throws OMIApplicationException
	 */
	public String closeUserAcount(CustomerVO customerVO)throws OMIApplicationException;



	/**
	 * <p>
	 * <code>verifyCloseAccount(CustomerVO customerVO)</code>Method
	 * have the close user account process  .
	 * </p> 
	 * @param referenceId
	 * @return
	 * @throws OMIApplicationException
	 */
	public String verifyCloseAccount(String referenceId)throws OMIApplicationException;



	/**
	 * <p>
	 * <code>verifyContinueAccount(CustomerVO customerVO)</code>Method
	 * have the continue user account process  .
	 * </p>  
	 * @param customerVO
	 * @return
	 * @throws OMIApplicationException
	 */
	public String verifyContinueAccount(String referenceId)throws OMIApplicationException;
	
	
	public String deleteCustomerSocialDetails(int id)throws OMIApplicationException;
	
	
	
}
