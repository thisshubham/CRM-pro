package com.bst.ckt.dao;

import java.util.List;

import com.bst.ckt.exception.OMIApplicationException;
import com.bst.ckt.exception.UpdateFailedException;
import com.bst.ckt.vo.CustomerVO;

public interface UserManagementDaoInf {

	public List<CustomerVO> getUserDetails(CustomerVO customerVO) throws Exception;

	/**
	 * <p>
	 * <code>insertUserDetail()</code>this method is use to insert new user
	 * details into the database
	 * </p>
	 * 
	 * @param customerVO
	 *            CustomerVO
	 * @return int
	 * @throws OMIApplicationException
	 */
	public int insertUserDetail(CustomerVO customerVO)
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>updateEmailFlagGuid()</code>this method is use to change the email
	 * flag
	 * </p>
	 * 
	 * @param createUserGuid
	 */
	public int updateEmailFlagGuid(String createUserGuid);

	/**
	 * <p>
	 * <code>getCustomerStaffUserDetails()</code>this method is use to get
	 * details of customer staff user
	 * 
	 * @param createUserGuid
	 * @return
	 * @throws OMIApplicationException
	 */
	public CustomerVO getCustomerStaffUserDetails(String referenceId)
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>getCustomerStaffUserIdByRef()</code>this method is use to get
	 * details of customer staff user
	 * </p>
	 * 
	 * @param createUserGuid
	 * @return
	 */
	public int getCustomerStaffUserIdByRef(int createdBy)
			throws OMIApplicationException;

	/**
	 * 
	 * @param primaryEmailId
	 * @param true1
	 */
	public void updateCustomerStaffUserEmailFlagByEmail(String primaryEmailId,
			String true1) throws OMIApplicationException;

	/**
	 * 
	 * @param customerVO
	 * @param customerId
	 * @param password
	 */
	public void createCustomerStaffUser(CustomerVO customerVO, int customerId,
			String password) throws OMIApplicationException;

	/**
	 * <P>
	 * <code>getCompanyId()</code> method will return companyId based on
	 * register customer.
	 * </p>
	 * 
	 * @param customerId
	 * @return
	 * @throws OMIApplicationException
	 */
	public int getCompanyId(int customerId) throws OMIApplicationException;

	/**
	 * <p>
	 * <code>createCustomerStaff</code>method will return email
	 * </p>
	 * 
	 * @throws OMIApplicationException
	 */
	public void createCustomerStaff(CustomerVO customerVO,
			String primaryEmailId, String password)
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>updateUserStatus()</code>This method is used to update customer
	 * Status.
	 * </p>
	 * 
	 * @param customerId
	 * @param userStatus
	 * @throws UpdateFailedException
	 */
	public void updateUserStatus(int customerId, int userStatus)
			throws UpdateFailedException;

	/**
	 * <p>
	 * <code>updateUserInfo()</code>This method is used to update user info.
	 * </p>
	 * 
	 * @param customerVO
	 * @param customerId
	 * @throws OMIApplicationException
	 */
	public CustomerVO updateUserInfo(CustomerVO customerVO, int customerId)
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>editUserDetails()</code>This method is used to update user info.
	 * </p>
	 * 
	 * @param customerVO
	 * @param customerId
	 * @param filePath
	 * @param userImageFileName
	 * @return
	 * @throws OMIApplicationException
	 */
	public int editUserDetails(CustomerVO customerVO, int customerId,
			String filePath, String userImageFileName)
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>updateCustomerLoginPassword()</code>This method is used to update
	 * customer login password.
	 * </p>
	 * 
	 * @param customerVO
	 * @throws Exception
	 */
	public int updateCustomerLoginPassword(CustomerVO customerVO, int customerId)
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>updateUserEmailId()</code>This method is used to update User Email
	 * id.
	 * </p>
	 * 
	 * @param customerVO
	 * @param customerId
	 * @throws OMIApplicationException
	 */
	public int updateUserEmailId(CustomerVO customerVO, int customerId)
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>getChangeUserEmailDetails()</code>This method is used to get change
	 * mail details from temp table by guid or refrence no.
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
	 * <code>updateUserEmail()</code>This method is used to update user email.
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
	 * <code>getuserSocialDetailsList()</code>This method is used to get Social
	 * Details List.
	 * </p>
	 * 
	 * @param cutomerId
	 * @return
	 * @throws Exception
	 */
	public List<CustomerVO> getuserSocialDetailsList(int cutomerId)
			throws Exception;

	/**
	 * <p>
	 * <code>insertOrUpdateUserSocialInformation()</code>This method is used to
	 * insert Social Details .
	 * </p>
	 * 
	 * @param cutomerId
	 * @return
	 * @throws Exception
	 */
	public int insertOrUpdateUserSocialInformation(CustomerVO customerVO)
			throws Exception;
}
