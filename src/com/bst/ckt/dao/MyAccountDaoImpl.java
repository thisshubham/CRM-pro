/**
 * 
 */
package com.bst.ckt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.bst.ckt.common.LoginUtil;
import com.bst.ckt.common.OMIConstants;
import com.bst.ckt.common.QueryMaker;
import com.bst.ckt.exception.OMIApplicationException;
import com.bst.ckt.exception.RecordNotFoundException;
import com.bst.ckt.exception.UpdateFailedException;
import com.bst.ckt.framework.db.JdbcDAOSupport;
import com.bst.ckt.framework.db.JdbcHelper;
import com.bst.ckt.framework.user.UserRole;
import com.bst.ckt.framework.user.UserStatus;
import com.bst.ckt.framework.util.DateTimeUtil;
import com.bst.ckt.helper.Modules;
import com.bst.ckt.helper.NameHelper;
import com.bst.ckt.vo.CustomerVO;

/**
 * @author Deepak Vishwakarma
 * 
 */

public class MyAccountDaoImpl extends JdbcDAOSupport implements MyAccountDaoInf {

	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	UserRole userRole = null;
	NameHelper nameHelper = new NameHelper();
	CustomerVO customerVO = new CustomerVO();

	/**
	 * Creating Logger object, logger object mapped with MyAccountDaoImpl class
	 * for writing Loggers.
	 */
	public static final Logger logger = Logger
			.getLogger(MyAccountDaoImpl.class);

	/**
	 * <p>
	 * <code>editCustomerAccount(CustomerVO customerVO)</code> Method implements
	 * to fetch customer account information from <code>TAB_CUSTOMER_USER</code>
	 * for edit processing.
	 * 
	 * @param customerVO
	 * @return customerVO
	 * @throws SQLException
	 *             </p>
	 */

	@Override
	public CustomerVO editCustomerAccount(CustomerVO customerVO)
			throws SQLException {

		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_CUSTOMER_ACCOUNT_INFORMATION);
			preparedStatement.setInt(1, customerVO.getCustomerId());
			System.out
					.println("Customer Id Is ::" + customerVO.getCustomerId());
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {

				while (resultSet.next()) {
					customerVO = new CustomerVO();
					customerVO.setCustomerId(resultSet.getInt("CUSTOMER_ID"));
					customerVO.setUserStatus(UserStatus.getUserStatus(resultSet
							.getInt("USER_STATUS")));
					customerVO.setUserRole(UserRole.getUserRole(resultSet
							.getInt("USER_ROLE")));
					customerVO.setSalutation(resultSet.getString("SALUTATION"));
					customerVO.setFullName(resultSet.getString("FULL_NAME"));
					customerVO.setDateOfBirth(resultSet
							.getString("DATE_OF_BIRTH"));
					customerVO.setGender(resultSet.getString("GENDER"));
					customerVO.setPrimaryEmailId(resultSet
							.getString("PRIMARY_EMAIL_ID"));
					System.out.println("Primary Email Id :: "
							+ resultSet.getString("PRIMARY_EMAIL_ID"));
					customerVO.setAlternateEmailId(resultSet
							.getString("ALTERNATE_EMAIL_ID"));
					customerVO.setDesignation(resultSet
							.getString("DESIGNATION"));
					customerVO.setDepartment(resultSet.getString("DEPARTMENT"));
					customerVO
							.setLocation(resultSet.getString("WORK_LOCATION"));
					customerVO.setAddressLine1(resultSet
							.getString("ADDRESS_LINE_1"));
					customerVO.setAddressLine2(resultSet
							.getString("ADDRESS_LINE_2"));
					customerVO.setCity(resultSet.getString("CITY"));
					customerVO.setState(resultSet.getString("STATE"));
					customerVO.setCountry(resultSet.getString("REF_COUNTRY"));
					customerVO.setZipcode(resultSet.getString("ZIPCODE"));
					customerVO.setPhoneNo(resultSet.getString("PHONE_NO"));
					customerVO.setMobileNo(resultSet.getString("MOBILE_NO"));
					customerVO.setFaxNo(resultSet.getString("FAX_NO"));
					customerVO.setWebSite(resultSet.getString("WEBSITE"));
					customerVO.setLanguage(nameHelper.getLanguageName(resultSet
							.getInt("LANGUAGE")));
					System.out.println(resultSet.getString("LANGUAGE"));
					customerVO.setLanguageId(resultSet.getInt("LANGUAGE"));
					customerVO.setCurrency(nameHelper.getCurrencyName(resultSet
							.getInt("REF_CURRENCY")));
					System.out.println(resultSet.getString("REF_CURRENCY"));
					customerVO.setCurrencyId(resultSet.getInt("REF_CURRENCY"));
					customerVO.setTimeZone(nameHelper.getTimeZoneName(resultSet
							.getInt("TIME_ZONE")));
					customerVO.setTimezoneId(resultSet.getInt("TIME_ZONE"));
					customerVO.setUploadedFilePath(resultSet
							.getString("PROFILE_IMAGE_PATH"));

				}
			}
		} catch (Exception exception) {
			logger.error(
					"Exception occured while feching the customer details into TAB_CUSTOMER_USER ",
					exception);
		} finally {

			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return customerVO;
	}

	/**
	 * <p>
	 * <code>upDateCustomerAccountInfo(CustomerVO customerVO)</code> Method
	 * implements to update customer account information into
	 * <code>TAB_CUSTOMER_USER</code>
	 * 
	 * @param customerVO
	 * @return target int
	 * @throws SQLException
	 *             </p>
	 */
	@Override
	public int upDateCustomerAccountInfo(CustomerVO customerVO,
			String filePath, String userImageFileName) throws Exception {
		String query = QueryMaker.UPDATE_CUSTOMER_ACCOUNT_INFORMATION;
		int target = 0;
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, customerVO.getSalutation());
			preparedStatement.setString(2, customerVO.getFullName());
			preparedStatement.setString(3, customerVO.getDateOfBirth());
			preparedStatement.setString(4, customerVO.getGender());
			preparedStatement.setString(5, customerVO.getAlternateEmailId());
			preparedStatement.setString(6, customerVO.getLocation());
			preparedStatement.setString(7, customerVO.getAddressLine1());
			preparedStatement.setString(8, customerVO.getAddressLine2());
			preparedStatement.setString(9, customerVO.getCity());
			preparedStatement.setString(10, customerVO.getState());
			preparedStatement.setString(11, customerVO.getCountry());
			preparedStatement.setString(12, customerVO.getZipcode());
			preparedStatement.setString(13, customerVO.getPhoneNo());
			preparedStatement.setString(14, customerVO.getMobileNo());
			preparedStatement.setString(15, customerVO.getFaxNo());
			preparedStatement.setString(16, customerVO.getWebSite());
			preparedStatement.setString(17, filePath);
			preparedStatement.setInt(18, customerVO.getCustomerId());
			preparedStatement.executeUpdate();
			target = 1;
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error("error while update record from database");

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(
					MyAccountDaoImpl.class
							+ "Error: Occur in Query While Updating Account Information into Database.",
					e);
		} finally {

			preparedStatement.close();
			connection.close();

		}
		return target;
	}

	/**
	 * <p>
	 * <code>updateCustomerLoginPassword(CustomerVO customerVO)</code> Method
	 * implements to update customer account information into
	 * <code>TAB_CUSTOMER_USER</code>
	 * 
	 * @param customerVO
	 * @return target int
	 * @throws SQLException
	 *             </p>
	 */
	@Override
	public int updateCustomerLoginPassword(CustomerVO customerVO)
			throws Exception {
		int target = 0;
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.UPDATE_CUSTOMER_LOGIN_PASSWORD);
			preparedStatement.setString(1, customerVO.getPassword());
			preparedStatement.setInt(2, customerVO.getCustomerId());
			System.out.println("*******************Update Password"
					+ customerVO.getCustomerId());
			preparedStatement.executeUpdate();
			target = 1;
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error("error while update customer login password");

		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					MyAccountDaoImpl.class
							+ "Error: Occur in Query While Updating customer login password.",
					exception);
		} finally {
			preparedStatement.close();
			connection.clearWarnings();
		}

		return target;
	}

	@Override
	public int getOldPassword(CustomerVO customerVO)
			throws OMIApplicationException {
		int target = 0;
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_PASSWORD);
			preparedStatement.setString(1, customerVO.getOldPassword());
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				target = 1;

			}
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error("error while update customer login password");

		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					MyAccountDaoImpl.class
							+ "Error: Occur in Query While Updating customer login password.",
					exception);
		} finally {
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}

		return target;
	}

	/**
	 * <p>
	 * <code>updateCustomerSecqurityQuestion(CustomerVO customerVO)</code>
	 * Method implements to update customer Security Question into.
	 * <code>TAB_CUSTOMER_USER</code>
	 * </p>
	 * 
	 * @param customerVO
	 * @return target int
	 * @throws SQLException
	 * 
	 */
	@Override
	public int updateCustomerSecqurityQuestion(CustomerVO customerVO)
			throws OMIApplicationException {

		System.out.println("------------------DAO-------------------------");
		int target = 0;
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.UPDATE_CUSTOMER_SECURITY_QUESTION);
			preparedStatement.setString(1, customerVO.getSecurityQuestion());
			System.out.println("DAO SECURITY QUESTION "
					+ customerVO.getSecurityQuestion());
			preparedStatement.setString(2, customerVO.getAnswer());
			System.out.println("DAO SECURITY QUESTION "
					+ customerVO.getAnswer());
			preparedStatement.setInt(3, customerVO.getCustomerId());
			System.out.println("DAO SECURITY QUESTION "
					+ customerVO.getCustomerId());
			preparedStatement.executeUpdate();
			target = 1;
		} catch (SQLException sqlException) {

			logger.error("error while update customer Secqurity Question.",
					sqlException);

		} catch (Exception exception) {

			logger.error(
					MyAccountDaoImpl.class
							+ "Error: Occur in Query While Updating customer Secqurity Question.",
					exception);
		} finally {
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return target;
	}

	/**
	 * <p>
	 * <code>getUserSocialDetailsList()</code> method use to fetch user social
	 * details from TAB_SOCIAL_CONTACT table.
	 * </p>
	 * 
	 * @return leadFollowUpDetails
	 */
	@Override
	public List<CustomerVO> getUserSocialDetailsList(int customerId)
			throws OMIApplicationException {
		System.out.println("Social information in Action MyAccount");
		ArrayList<CustomerVO> userSocialDetails = new ArrayList<CustomerVO>();
		try {

			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_LEAD_SOCIAL_DETAILS);
			preparedStatement.setInt(1, Modules.MY_ACCOUNT_ID);
			preparedStatement.setInt(2, customerId);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				CustomerVO customerVO = new CustomerVO();
				customerVO.setSocialSiteRefName(nameHelper
						.getSocialSite(resultSet.getInt("SOCIAL_SITE_REF")));

				customerVO.setSocialContactValue(resultSet
						.getString("SOCIAL_CONTACT_VALUE"));
				customerVO.setSocialContactId(resultSet.getInt("SOCIAL_CONTACT_ID"));

				userSocialDetails.add(customerVO);
			}

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					LeadDaoImpl.class
							+ ": Error:- Error: Occur in Query While fetching Customer social details from Database",
					sqlException);

		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					LeadDaoImpl.class
							+ ": Error:- While closing the Connection after fetching the Customer social details from Database",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return userSocialDetails;
	}


	/**
	 * <p>
	 * <code>insertUserSocialInformation()</code> method use to insert customer
	 * social information details into TAB_SOCIAL_CONTACT table.
	 * </p>
	 * 
	 * @param leadVO
	 * @throws Exception
	 * @return target
	 */
	@Override
	public int insertUserSocialInformation(CustomerVO customerVO)
			throws OMIApplicationException {

		int target = 0;

		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_SOCIAL_INFO);
			preparedStatement.setInt(1, customerVO.getSocialSiteRef());
			preparedStatement.setInt(2, Modules.MY_ACCOUNT_ID);
			preparedStatement.setInt(3, customerVO.getCustomerId());
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				customerVO.setSocialContactId(resultSet
						.getInt("SOCIAL_CONTACT_ID"));
				preparedStatement = connection
						.prepareStatement(QueryMaker.UPDATE_SOCIAL_INFORMATION);
				preparedStatement.setInt(1, customerVO.getSocialSiteRef());
				preparedStatement.setString(2,
						customerVO.getSocialContactValue());
				preparedStatement.setInt(3, Modules.MY_ACCOUNT_ID);
				preparedStatement.setInt(4, customerVO.getCustomerId());
				preparedStatement.setInt(5, customerVO.getSocialContactId());
				preparedStatement.executeUpdate();
				target = 2;

			} else {
				preparedStatement = connection
						.prepareStatement(QueryMaker.INSERT_SOCIAL_INFORMATION);
				preparedStatement.setInt(1, customerVO.getSocialSiteRef());
				preparedStatement.setString(2,
						customerVO.getSocialContactValue());
				preparedStatement.setInt(3, Modules.MY_ACCOUNT_ID);
				preparedStatement.setInt(4, customerVO.getCustomerId());
				preparedStatement.executeUpdate();
				target = 1;

			}

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					LeadDaoImpl.class
							+ ": Error:- Error: Occur in Query While inserting the Cusromer social details into Database",
					sqlException);

		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					LeadDaoImpl.class
							+ ": Error:- While closing the Connection after inserting the Cusromer social details into Database",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return target;
	}

	@Override
	public int deleteCustomerSocialDetails(int id)
			throws OMIApplicationException {
		int target = 0;
		try {
			connection = getConnection();

			preparedStatement = connection
					.prepareStatement(QueryMaker.DELETE_CUSTOMER_DETAILS);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			System.out.println("social record deleted");
			target = 1;

		} catch (SQLException sqlException) {
			logger.error(
					"Error while update customer user updation, Connection Error!!! ",
					sqlException);

		} catch (Exception e) {

			e.printStackTrace();
		}
		return target;
	}

	/**
	 * <p>
	 * <code>updateUserEmailId</code> Method implements to update customer email
	 * id.
	 * </p>
	 * 
	 * @param customerVO
	 * @param customerId
	 * @return target int
	 * @throws OMIApplicationException
	 * 
	 */
	@Override
	public int updateUserEmailId(CustomerVO customerVO)
			throws OMIApplicationException {
		int target = 0;
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.UPDATE_USER_PRIMARY_EMAIL_ID);
			preparedStatement.setInt(1, customerVO.getChangeEmailId());
			preparedStatement.setString(2, customerVO.getPrimaryEmailId());
			preparedStatement.setString(3, customerVO.getChangeEmailRefNo());
			preparedStatement.setString(4, LoginUtil.getIPAddress());
			preparedStatement.setInt(5, OMIConstants.SELF_REG_USER_ID);
			preparedStatement.setString(6, DateTimeUtil.getCurrentDate());

			preparedStatement.executeUpdate();
			target = 1;
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error("error while update user Primary Email Id");

		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					MyAccountDaoImpl.class
							+ "Error: Occur in Query While Updating user Primary Email Id.",
					exception);
		} finally {
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}

		return target;
	}

	/**
	 * <p>
	 * <code>updateEmailFlagGuid()</code> method use to update the email flag
	 * into TAB_CUSTOMER_TEMP table.
	 * 
	 * </p>
	 * 
	 * @throws Exception
	 */
	@Override
	public int updateEmailFlagGuid(String changeEmailRefNo)
			throws OMIApplicationException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = getConnection();
			String updateEmailFlagGuid = QueryMaker.UPDATE_CREATE_USER_EMAIL_FLAG;
			preparedStatement = connection
					.prepareStatement(updateEmailFlagGuid);

			preparedStatement.setString(1, OMIConstants.TRUE);
			preparedStatement.setString(2, changeEmailRefNo);
			preparedStatement.executeUpdate();

			return 1;
		} catch (SQLException sqlException) {

			sqlException.printStackTrace();
			return 0;

		} catch (Exception exception) {
			exception.printStackTrace();
			return 0;
		} finally {
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}

	}

	/**
	 * <p>
	 * <code>getChangeUserEmailDetails()</code> method use to get the change
	 * email details from database.
	 * 
	 * </p>
	 * 
	 * @throws OMIApplicationException
	 */
	@Override
	public CustomerVO getChangeUserEmailDetails(String referenceId)
			throws OMIApplicationException {

		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_CHANGE_USER_EMAIL_BY_GUID);
			preparedStatement.setString(1, referenceId);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				customerVO = new CustomerVO();
				customerVO.setCustomerId(resultSet.getInt("CHANGE_EMAIL_ID"));
				customerVO.setPrimaryEmailId(resultSet.getString("EMAIL_ID"));
				customerVO.setRegistrationRefNo(resultSet
						.getString("EMAIL_REF_NO"));
				customerVO.setLoginIPAddress(resultSet.getString("IP_ADDRESS"));
				customerVO.setRegistrationEmailFlag(resultSet
						.getString("EMAIL_FLAG"));
				customerVO.setCreationDate(resultSet.getString("CREATED_DATE"));
				customerVO.setCreatedBy(resultSet.getInt("CREATED_BY"));

			} else {
				logger.error("Wrong Verification Id, There is no record available on Database.");

				throw new RecordNotFoundException();
			}

		} catch (SQLException sqlException) {
			logger.error(
					"Failed To fetch the register customer details on basis of registration referece no during verify email id process.",
					sqlException);

			throw new RecordNotFoundException();
		} catch (Exception exception) {
			logger.error(
					"Exception occured while retrieving the register customer details from the database ",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return customerVO;

	}

	/**
	 * <p>
	 * <code>updateUserEmail()</code> method use to update the email details
	 * into database.
	 * 
	 * </p>
	 * 
	 * @throws OMIApplicationException
	 */
	@Override
	public int updateUserEmail(CustomerVO customerVO)
			throws OMIApplicationException {
		int target = 0;
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.UPDATE_CUSTOMER_EMAIL_ID);
			int customerId = LoginUtil.getProcessUserId();
			preparedStatement.setString(1, customerVO.getPrimaryEmailId());
			preparedStatement.setInt(2, OMIConstants.SELF_REG_USER_ID);
			preparedStatement.setString(3, DateTimeUtil.getCurrentDate());
			preparedStatement.setInt(4, customerId);
			preparedStatement.executeUpdate();
			target = 1;

		} catch (SQLException sqlException) {
			logger.error(
					"While create connection for update user emailId into database",
					sqlException);
		} catch (UpdateFailedException updateFailedException) {
			logger.error("Email Updation fail!!!!!!!!!!!",
					updateFailedException);
		} catch (Exception exception) {
			logger.error("fail to Update user emailId into database");
		}
		return target;

	}

	/**
	 * 
	 */
	@Override
	public int updateUserStatus(int customerId, int userStatus,
			String primaryEmailId) throws OMIApplicationException {
		int pwd = 0;

		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.UPDATE_USER_STATUS);
			preparedStatement.setInt(1, userStatus);
			preparedStatement.setString(2, DateTimeUtil.getCurrentDate());
			preparedStatement.setInt(3, customerId);
			preparedStatement.executeUpdate();
			pwd = 1;

		} catch (SQLException sqlException) {
			logger.error(
					"Error while update customer user updation, Connection Error!!! ",
					sqlException);
		} catch (UpdateFailedException updateFailedException) {
			logger.error("Fail to update customer User Status.",
					updateFailedException);
		} catch (Exception exception) {
			logger.error("fail to Update customer user status into database");
		}
		return pwd;

	}

	/**
	 * 
	 */
	@Override
	public int getPassword(CustomerVO customerVO)
			throws OMIApplicationException {
		int pwd = 0;
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_PASSWORD);
			preparedStatement.setString(1, customerVO.getPassword());
			System.out.println("Close account password ---------"
					+ customerVO.getPassword());
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				pwd = 1;

			}
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error("error while getting customer login password");

		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					MyAccountDaoImpl.class
							+ "Error: Occur in Query While getting customer login password.",
					exception);
		} finally {
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}

		return pwd;
	}

	@Override
	public int updateCloseAccountDetails(CustomerVO customerVO)
			throws OMIApplicationException {
		int pwd = 0;
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.UPDATE_CLOSE_ACCOUNT_DETAILS);
			preparedStatement.setString(1, customerVO.getComment());
			preparedStatement.setString(2, customerVO.getOptionsRadios());
			preparedStatement.setString(3, customerVO.getCloseAccountRefNo());
			preparedStatement.setString(4, DateTimeUtil.getCurrentDate());
			preparedStatement.setInt(5, customerVO.getCustomerId());
			preparedStatement.executeUpdate();
			pwd = 1;

		} catch (SQLException sqlException) {
			logger.error(
					"Error while update customer user updation, Connection Error!!! ",
					sqlException);
		} catch (UpdateFailedException updateFailedException) {
			logger.error("Fail to update customer User Status.",
					updateFailedException);
		} catch (Exception exception) {
			logger.error("fail to Update customer user status into database");
		}
		return pwd;
	}

	@Override
	public void updateUserStatusClose(int deletedId, String referenceId)
			throws OMIApplicationException {

		System.out.println("Dao IMPL VARIFICATION CLOSE ACCOUNT");

		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.UPDATE_USER_STATUS_CLOSE);
			preparedStatement.setInt(1, deletedId);
			preparedStatement.setString(2, DateTimeUtil.getCurrentDate());
			preparedStatement.setString(3, referenceId);
			preparedStatement.executeUpdate();
			System.out
					.println("-------------------------------------------------+++++++++++++++---");

		} catch (SQLException sqlException) {
			logger.error(
					"Error while update customer user updation, Connection Error!!! ",
					sqlException);
		} catch (UpdateFailedException updateFailedException) {
			logger.error("Fail to update customer User Status.",
					updateFailedException);
		} catch (Exception exception) {
			logger.error("fail to Update customer user status into database",
					exception);
		}

	}

	@Override
	public void updateUserStatusActive(int activeId, String referenceId)
			throws OMIApplicationException {

		System.out.println("Dao IMPL VARIFICATION CONTINUE ACCOUNT");

		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.UPDATE_USER_STATUS_CLOSE);
			preparedStatement.setInt(1, activeId);
			preparedStatement.setString(2, DateTimeUtil.getCurrentDate());
			preparedStatement.setString(3, referenceId);
			preparedStatement.executeUpdate();

		} catch (SQLException sqlException) {
			logger.error(
					"Error while update customer user updation, Connection Error!!! ",
					sqlException);
		} catch (UpdateFailedException updateFailedException) {
			logger.error("Fail to update customer User Status.",
					updateFailedException);
		} catch (Exception exception) {
			logger.error("fail to Update customer user status into database");
		}

	}

	@Override
	public CustomerVO fetchFullname(CustomerVO customerVO)
			throws OMIApplicationException {
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.SELECT_FULL_NAME);
			preparedStatement.setInt(1, customerVO.getCustomerId());

			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				customerVO.setFullName(resultSet.getString("FULL_NAME"));
				;

			}
		} catch (SQLException sqlException) {

			logger.error("error while update customer Secqurity Question.",
					sqlException);
		} catch (Exception exception) {

			logger.error("error while update customer Secqurity Question.",
					exception);
		}

		return customerVO;
	}

}
