/**
 * 
 */
package com.bst.ckt.dao;

import java.sql.SQLException;
import java.util.List;

import com.bst.ckt.exception.OMIApplicationException;
import com.bst.ckt.vo.CustomerVO;

/**
 * @author Deepak vishwakarma
 * 
 */
public interface MyAccountDaoInf {

	/**
	 * <p>
	 * <code>editCustomerAccount()</code>This method is used to fetch customer
	 * information.
	 * </p>
	 * 
	 * @param customerVO
	 * @throws SQLException
	 */
	public CustomerVO editCustomerAccount(CustomerVO customerVO)
			throws SQLException;

	/**
	 * <p>
	 * <code>upDateCustomerAccountInfo()</code>This method is used to update
	 * customer account information.
	 * </p>
	 * 
	 * @param customerVO
	 * @throws SQLException
	 */
	public int upDateCustomerAccountInfo(CustomerVO customerVO,
			String filePath, String userImageFileName) throws Exception;

	/**
	 * <p>
	 * <code>updateCustomerLoginPassword()</code>This method is used to update
	 * customer login password.
	 * </p>
	 * 
	 * @param customerVO
	 * @throws Exception
	 */
	public int updateCustomerLoginPassword(CustomerVO customerVO)
			throws Exception;

	/**
	 * <p>
	 * <code>getOldPassword()</code>This method is used to compare the old
	 * password with password.
	 * </p>
	 * 
	 * @param customerVO
	 * @throws Exception
	 */
	public int getOldPassword(CustomerVO customerVO)
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>updateCustomerSecqurityQuestion()</code>This method is used to
	 * update security question.
	 * </p>
	 * 
	 * @param customerVO
	 * @throws OMIApplicationException
	 */
	public int updateCustomerSecqurityQuestion(CustomerVO customerVO)
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>getUserSocialDetailsList()</code>This method is used to get user
	 * social information.
	 * </p>
	 * 
	 * @param customerId
	 * @return
	 * @throws OMIApplicationException
	 */
	public List<CustomerVO> getUserSocialDetailsList(int customerId)
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>insertUserSocialInformation()</code>This method is used to insert
	 * user social information.
	 * </p>
	 * 
	 * @param customerVO
	 * @return
	 * @throws OMIApplicationException
	 */
	public int insertUserSocialInformation(CustomerVO customerVO)
			throws OMIApplicationException;
	
	
	public int deleteCustomerSocialDetails(int id) throws OMIApplicationException;

	/**
	 * <p>
	 * <code>updateUserEmailId()</code>This method is used to update the login
	 * user primary email into database after reference no. verification and
	 * that will send the user new email id to the user email id.
	 * </p>
	 * 
	 * @param customerVO
	 * @throws OMIApplicationException
	 */
	public int updateUserEmailId(CustomerVO customerVO)
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>updateUserEmailId()</code>This method is used to update the login
	 * user primary email into database after reference no. verification and
	 * that will send the user new email id to the user email id.
	 * </p>
	 * 
	 * @param changeEmailRefNo
	 * @throws OMIApplicationException
	 */
	public int updateEmailFlagGuid(String changeEmailRefNo)
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>updateUserEmailId()</code>This method is used to update the login
	 * user primary email into database after reference no. verification and
	 * that will send the user new email id to the user email id.
	 * </p>
	 * 
	 * @param referenceId
	 * @return
	 * @throws OMIApplicationException
	 */
	public CustomerVO getChangeUserEmailDetails(String referenceId)
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>updateUserEmailId()</code>This method is used to update the login
	 * user primary email into database after reference no. verification and
	 * that will send the user new email id to the user email id.
	 * </p>
	 * 
	 * @param customerVO
	 * @return
	 * @throws OMIApplicationException
	 */
	public int updateUserEmail(CustomerVO customerVO)
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>updateUserStatus(int customerId, int userStatus)</code>Method Is
	 * Used To update Customer User Status.
	 * </p>
	 * 
	 * @param customerId
	 *            int
	 * @param userStatus
	 *            int
	 * @throws OMIApplicationException
	 */
	public int updateUserStatus(int customerId, int userStatus,String primaryEmailId)
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>getPassword()</code>This method is used to compare the password
	 * with password.
	 * </p>
	 * 
	 * @param customerVO
	 * @throws Exception
	 */
	public int getPassword(CustomerVO customerVO)
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>updateCloseAccountDetails(CustomerVO customerVO)</code>Method Is
	 * Used To update Customer User Status.
	 * </p>
	 * 
	 * @param  customerVO
	 * @throws OMIApplicationException
	 */
	public int updateCloseAccountDetails(CustomerVO customerVO)
			throws OMIApplicationException;

	
	public void updateUserStatusClose(int deletedId, String referenceId)throws OMIApplicationException;

	public void updateUserStatusActive(int activeId, String referenceId)throws OMIApplicationException;
	
	/**
	 * <p>
	 * <code>fetchFullname(CustomerVO customerVO)</code>Method Is
	 * Used To fetch Customer User fullName
	 * </p>
	 * 
	 * @param  customerVO
	 * @throws OMIApplicationException
	 */

	public CustomerVO fetchFullname(CustomerVO customerVO) throws OMIApplicationException;

	
	

}
