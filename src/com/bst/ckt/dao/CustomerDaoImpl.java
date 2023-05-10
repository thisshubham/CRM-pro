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
import com.bst.ckt.dto.Customer;
import com.bst.ckt.exception.CreateFailedException;
import com.bst.ckt.exception.OMIApplicationException;
import com.bst.ckt.exception.RecordNotFoundException;
import com.bst.ckt.exception.UpdateFailedException;
import com.bst.ckt.framework.db.JdbcDAOSupport;
import com.bst.ckt.framework.db.JdbcHelper;
import com.bst.ckt.framework.user.UserRole;
import com.bst.ckt.framework.user.UserStatus;
import com.bst.ckt.framework.util.DateTimeUtil;
import com.bst.ckt.helper.NameHelper;
import com.bst.ckt.vo.CompanyVO;
import com.bst.ckt.vo.CustomerVO;
import com.bst.ckt.vo.LoginVO;
import com.bst.ckt.vo.UserLoggerVO;

public class CustomerDaoImpl extends JdbcDAOSupport implements CustomerDaoInf {

	/**
	 * Creating Logger object, logger object mapped with CustomerRegistration
	 * class for writing Loggers.
	 */
	private static final Logger logger = Logger
			.getLogger(CustomerDaoImpl.class);

	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	NameHelper nameHelper = new NameHelper();
	LoginVO loginVO = null;

	/**
	 * 
	 */
	public Customer findCustomerUserByEmailId(String emailId)
			throws RecordNotFoundException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Customer customer = null;

		try {
			connection = getConnection();
			String findUserByEmailIdQuery = QueryMaker.GET_CUSTOMER_USER_DETAILS_BY_EMAIL_ID;
			preparedStatement = connection
					.prepareStatement(findUserByEmailIdQuery);
			preparedStatement.setString(1, emailId);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				customer = new Customer();
				customer.setCustomerId(resultSet.getInt("CUSTOMER_ID"));
				customer.setPassword(resultSet.getString("PASSWORD"));
				customer.setAddressLine1(resultSet.getString("ADDRESS_LINE_1"));
				customer.setAddressLine2(resultSet.getString("ADDRESS_LINE_2"));
				customer.setAlternateEmailId(resultSet
						.getString("ALTERNATE_EMAIL_ID"));
				customer.setPrimaryEmailId(resultSet
						.getString("PRIMARY_EMAIL_ID"));
				customer.setCity(resultSet.getString("CITY"));
				customer.setState(resultSet.getString("STATE"));
				customer.setCreatedBy(resultSet.getInt("CREATED_BY"));
				customer.setCreationDate(resultSet.getString("CREATION_DATE"));
				customer.setFaxNo(resultSet.getString("FAX_NO"));
				customer.setFaxStd(resultSet.getString("FAX_STD"));
				customer.setFullName(resultSet.getString("FULL_NAME"));
				customer.setRefBussinessFunction(resultSet
						.getInt("REF_BUSSINESS_FUNCTION"));
				customer.setRefCompany(resultSet.getInt("REF_COMPANY"));
				customer.setRefCountry(resultSet.getInt("REF_COUNTRY"));
				customer.setRefSecurityQuestionId(resultSet
						.getInt("REF_SECURITY_QUESTION_ID"));
				customer.setRefSource(resultSet.getInt("REF_SOURCE"));
				customer.setDateOfBirth(resultSet.getString("DATE_OF_BIRTH"));
				customer.setZipcode(resultSet.getString("ZIPCODE"));
				customer.setPhoneStd(resultSet.getString("PHONE_STD"));
				customer.setProfileImagePath(resultSet
						.getString("PROFILE_IMAGE_PATH"));
				customer.setMobileNo(resultSet.getString("MOBILE_NO"));
				customer.setSalutation(resultSet.getString("SALUTATION"));
				customer.setSocialImId(resultSet.getString("SOCIAL_IM_ID"));
				customer.setUserRole(resultSet.getInt("USER_ROLE"));
				customer.setUserStatus(resultSet.getInt("USER_STATUS"));
				customer.setAnswer(resultSet.getString("ANSWER"));
				customer.setPhoneNo(resultSet.getString("PHONE_NO"));
				customer.setLoginFlag(resultSet.getString("LOGIN_FLAG"));
				customer.setAclId(resultSet.getInt("ACL_ID"));
				

			}
		} catch (SQLException sqlException) {
			logger.error(
					"Failed To fetch the user details on basis of emailId",
					sqlException);

			throw new RecordNotFoundException();
		} catch (Exception exception) {
			logger.error(
					"Exception occured while retrieving the user details from the database ",
					exception);

		} finally {
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}

		return customer;
	}

	/**
	 * 
	 */
	public Customer getCompanyDetails(String compnayReferenceNo)
			throws Exception {
		Customer customer = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String getCompanyDetailsQuery = QueryMaker.GET_CUSTOMER_DETAILS_BY_REFNO;

		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(getCompanyDetailsQuery);
			preparedStatement.setString(1, compnayReferenceNo);
			resultSet = preparedStatement.executeQuery();

			if (resultSet != null) {
				while (resultSet.next()) {
					customer = new Customer();
					customer.setCustomerId(resultSet.getInt("REG_ID"));
					customer.setFullName(resultSet.getString("FULL_NAME"));
					customer.setPrimaryEmailId(resultSet.getString("EMAIL_ID"));
					customer.setMobileNo(resultSet.getString("MOBILE_NO"));
					customer.setComapnyName(resultSet.getString("COMPANY_NAME"));
					customer.setRegistrationRefNo(resultSet
							.getString("REG_REF_NO"));
					customer.setUserRole(resultSet.getInt("USER_ROLE"));
					customer.setRefCountry(resultSet.getInt("COUNTRY"));
					customer.setLoginIPAddress(resultSet
							.getString("IP_ADDRESS"));
					customer.setRegistrationEmailFlag(resultSet
							.getString("EMAIL_FLAG"));
					customer.setCreationDate(resultSet
							.getString("CREATED_DATE"));
					customer.setCreatedBy(resultSet.getInt("CREATED_BY"));
				}
			} else {
				logger.error("Registration Reference number is not valid, ther is no record found.");
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
		return customer;
	}

	/**
	 * <p>
	 * <code>insertQuickRegistraionDetails(CompanyVO companyVO)</code> Method
	 * implements to insert the CompanyVO properties value into
	 * <code>TAB_CUSTOMER_TEMP</code> along with below data settings.
	 * <ul>
	 * <li><code>UserRole.CUSTOMER_ADMIN_ROLE_ID</code> set into
	 * <code>USER_ROLE</code> column in <code>TAB_CUSTOMER_TEMP</code>.</li>
	 * <li><code>OMIConstants.FALSE</code> set into <code>EMAIL_FLAG</code>
	 * column in <code>TAB_CUSTOMER_TEMP</code>.</li>
	 * <li><code>OMIConstants.SELF_REG_USER_ID</code> set into
	 * <code>CREATED_BY</code> column in <code>TAB_CUSTOMER_TEMP</code>.</li>
	 * </ul>
	 * </p>
	 */
	@Override
	public void insertQuickRegistraionDetails(CompanyVO companyVO)
			throws OMIApplicationException {

		PreparedStatement preparedStatement = null;
		Connection connection = null;

		try {

			connection = getConnection();
			String insertCompanyDetailQuery = QueryMaker.INSERT_CUSTOMER_DETAILS;
			preparedStatement = connection
					.prepareStatement(insertCompanyDetailQuery);

			preparedStatement.setString(1, companyVO.getFullName());
			preparedStatement.setString(2, companyVO.getCompanyEmailId());
			preparedStatement.setString(3, companyVO.getMobileNo());
			preparedStatement.setString(4, companyVO.getCompanyName());
			preparedStatement.setString(5, companyVO.getCompanyRefNo());
			preparedStatement.setInt(6, UserRole.CUSTOMER_ADMIN_ROLE_ID);
			preparedStatement.setString(7, LoginUtil.getIPAddress());
			preparedStatement.setString(8, OMIConstants.FALSE);
			preparedStatement.setString(9, DateTimeUtil.getCurrentDate());
			preparedStatement.setInt(10, OMIConstants.SELF_REG_USER_ID);
			preparedStatement.setInt(11, companyVO.getCountry());
			preparedStatement.executeUpdate();

		} catch (SQLException sqlException) {
			logger.error(
					"Failed to inserting the quick registration customer details into TAB_CUSTOMER_TEMP",
					sqlException);
			throw new CreateFailedException();
		} catch (Exception exception) {
			logger.error(
					"Exception occured while inserting the quick registration customer details into TAB_CUSTOMER_TEMP ",
					exception);
		} finally {

			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}

	}

	/**
	 * 
	 * @param companyRefNo
	 * @return
	 * @throws UpdateFailedException
	 */
	public int updateEmailFlagCustomerRegistration(String companyRefNo)
			throws UpdateFailedException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = getConnection();
			String updateEmailFlagCustomerRegistration = QueryMaker.UPDATE_EMAIL_FLAG_CUSTOMER_TEMP;
			preparedStatement = connection
					.prepareStatement(updateEmailFlagCustomerRegistration);

			preparedStatement.setString(1, OMIConstants.TRUE);
			preparedStatement.setString(2, companyRefNo);
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

	@Override
	public int isEmailAlreadyExist(String trim) {

		return 0;
	}

	/**
	 * 
	 */
	@Override
	public int getCompanyIdByRef(String compnayReferenceNo) {
		int companyId = 0;

		String getCompanyIdByRefQuery = QueryMaker.GET_COMPNAY_ID_BY_REFNO;

		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(getCompanyIdByRefQuery);
			preparedStatement.setString(1, compnayReferenceNo);
			resultSet = preparedStatement.executeQuery();

			if (resultSet != null) {
				while (resultSet.next()) {
					companyId = resultSet.getInt("COMPANY_ID");
				}
			} else {
				logger.error("Registration Reference number is not valid, there is no record found.");
			}
		} catch (SQLException sqlException) {
			logger.error(
					"Failed To fetch the register comapny id basis of registration referece no.",
					sqlException);
		} catch (Exception exception) {
			logger.error(
					"Exception occured while retrieving the register customer details from the database ",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return companyId;
	}

	@Override
	public void updateCustomerStatus(int companyId, int activeId, int createdBy) {

	}

	@Override
	public void createCompany(Customer customer) throws Exception {

		PreparedStatement preparedStatement = null;
		Connection connection = null;
		try {

			connection = getConnection();
			String createCompanyQuery = QueryMaker.CREATE_CUSTOMER_COMPANY;
			preparedStatement = connection.prepareStatement(createCompanyQuery);

			preparedStatement.setString(1, customer.getRegistrationRefNo());
			preparedStatement.setString(2, customer.getComapnyName());
			preparedStatement.setString(3, customer.getMobileNo());
			preparedStatement.setString(4, customer.getPrimaryEmailId());
			preparedStatement.setInt(5, customer.getRefCountry());
			preparedStatement.setString(6, DateTimeUtil.getCurrentDate());
			preparedStatement.setInt(7, OMIConstants.SELF_REG_USER_ID);
			preparedStatement.setString(8, LoginUtil.getIPAddress());
			preparedStatement.setInt(9, UserStatus.REGISTERED_ID);

			preparedStatement.executeUpdate();

		} catch (SQLException sqlException) {
			logger.error(
					"Customer company creation failed in database, Please refer below log:",
					sqlException);
			throw new CreateFailedException();
		} catch (Exception exception) {
			logger.error(
					"Problem during Customer company creation in database, Please refer below log:",
					exception);
		} finally {
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}

	}

	@Override
	public void createCustomer(Customer customer, int companyId, String password)
			throws Exception {
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		try {

			connection = getConnection();
			String createCustomerUserQuery = QueryMaker.CREATE_CUSTOMER;
			preparedStatement = connection
					.prepareStatement(createCustomerUserQuery);

			preparedStatement.setString(1, password);
			preparedStatement.setString(2, customer.getFullName());
			preparedStatement.setInt(3, companyId);
			preparedStatement.setString(4, customer.getPrimaryEmailId());
			preparedStatement.setString(5, customer.getMobileNo());
			preparedStatement.setInt(6, customer.getRefCountry());
			preparedStatement.setString(7, DateTimeUtil.getCurrentDate());
			preparedStatement.setInt(8, OMIConstants.SELF_REG_USER_ID);
			preparedStatement.setInt(9, UserRole.CUSTOMER_ADMIN_ROLE_ID);
			preparedStatement.setInt(10, UserStatus.ACTIVE_ID);
			preparedStatement.setString(11, OMIConstants.FALSE);
			preparedStatement.setString(12, OMIConstants.LOGIN_FLAG_FTL);

			preparedStatement.executeUpdate();

		} catch (SQLException sqlException) {
			logger.error(
					"Customer company creation failed in database, Please refer below log:",
					sqlException);
			throw new CreateFailedException();
		} catch (Exception exception) {
			logger.error(
					"Problem during Customer company creation in database, Please refer below log:",
					exception);
		} finally {
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
	}

	@Override
	public void updateCustomerEmailFlagByEmail(String primaryEmailId,
			String emailFlag) throws Exception {

		PreparedStatement preparedStatement = null;
		Connection connection = null;

		try {

			connection = getConnection();
			String updateCustomerEmailFlagByEmailQuery = QueryMaker.UPDATE_EMAILFLAG_CUSTOMER_EMAILID;
			preparedStatement = connection
					.prepareStatement(updateCustomerEmailFlagByEmailQuery);

			preparedStatement.setString(1, emailFlag);
			preparedStatement.setString(2, primaryEmailId);

			preparedStatement.executeUpdate();

		} catch (SQLException sqlException) {
			logger.error(
					"Customer Email flag updation failed in database, Please refer below log:",
					sqlException);
			throw new UpdateFailedException();
		} catch (Exception exception) {
			logger.error(
					"Problem during Customer email flag updation during verifyEmail process as part of customer "
							+ "registration in database, Please refer below log:",
					exception);
		} finally {
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}

	}

	/**
	 * <p>
	 * <code>insertUserLoggerDetail(int customerId, String ipAddress, String loginTime)</code>
	 * Method implements to insert the LoginVO properties value into
	 * <code>TAB_CUSTOMER_USEER_LOGGER</code> along with below data settings.
	 * </p>
	 */
	@Override
	public void insertUserLoggerDetail(int customerId, String ipAddress,
			String loginTime) throws OMIApplicationException {

		PreparedStatement preparedStatement = null;
		Connection connection = null;
		String Query = QueryMaker.INSERT_USER_LOGGER_DETAIL;
		try {
			// create the database Connection from the connection pool
			connection = getConnection();
			preparedStatement = connection.prepareStatement(Query);
			preparedStatement.setString(1, ipAddress);
			preparedStatement.setString(2, loginTime);
			preparedStatement.setInt(3, customerId);
			preparedStatement.setString(4, "SessionUser");
			preparedStatement.execute();
		} catch (SQLException sqlException) {
			logger.error(
					"Error while creating the connection for insert user logger details.",
					sqlException);
		} catch (Exception exception) {
			logger.error(
					"Error while inserting the new User Logger information to TAB_CUSTOMER_USER_LOGGER.",
					exception);
		} finally {
			JdbcHelper.closeStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}

	}

	public void updateUserLogger(String loginTime)
			throws OMIApplicationException {

		PreparedStatement preparedStatement = null;
		Connection connection = null;
		String Query = QueryMaker.UPDATE_USER_LOGGER_DETAILS;
		try {

			connection = getConnection();
			preparedStatement = connection.prepareStatement(Query);
			preparedStatement.setString(1, DateTimeUtil.getDateAndTime());
			preparedStatement.setString(2, loginTime);
			preparedStatement.setString(3, "LogoutUser");
			preparedStatement.executeUpdate();
		} catch (SQLException sqlException) {
			logger.error(
					"Error while creating the connection for update User Logger details.",
					sqlException);
		} catch (Exception exception) {
			logger.error(
					"Error while updating the new User Logger informatio to TAB_USER_LOGGER",
					exception);
		} finally {
			JdbcHelper.closeStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}

	}

	/**
	 * <p>
	 * <code>getUserDetails()</code> method use to Fatch User details from
	 * TAB_LEAD_DETAILS table.
	 * 
	 * </p>
	 * 
	 * @return userDetailsList
	 * @throws Exception
	 */
	@Override
	public List<UserLoggerVO> getUserLoggerDetails(int coustomerId)
			throws OMIApplicationException {
		String query = QueryMaker.GET_USER_LOGGER_DETAILS;
		ArrayList<UserLoggerVO> userDetailsList = new ArrayList<UserLoggerVO>();

		UserLoggerVO userLoggerVO = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {

			connection = getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, coustomerId);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				userLoggerVO = new UserLoggerVO();
				userLoggerVO.setLoggerId(resultSet.getInt("CUSTOMER_USER_ID"));
				userLoggerVO.setIpAddress(resultSet.getString("IP_ADDRESS"));
				userLoggerVO.setLoginTime(resultSet.getString("LOGIN_TIME"));
				userLoggerVO.setLogOutTime(resultSet.getString("LOGOUT_TIME"));
				userLoggerVO.setStatus(resultSet.getString("LOGGER_STATUS"));
				userDetailsList.add(userLoggerVO);
			}

		} catch (Exception exception) {
			exception.printStackTrace();

		} finally {
			try {
				if (null != connection) {
					resultSet.close();
					preparedStatement.close();
					connection.close();
				}
			} catch (SQLException sqlExp) {

			}
		}
		return userDetailsList;
	}

	/**
	 * <p>
	 * <code>getUserDetails()</code> method use to fetch user details from
	 * database.
	 * 
	 * </p>
	 * 
	 * @return customerVO
	 * @throws OMIApplicationException
	 */
	@Override
	public CustomerVO getUserDetails(CustomerVO customer)
			throws OMIApplicationException {

		String getCompanyDetailsQuery = QueryMaker.GET_CUSTOMER_DETAILS;

		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(getCompanyDetailsQuery);
			preparedStatement.setInt(1, customer.getCustomerId());
			resultSet = preparedStatement.executeQuery();

			StringBuffer sb = null;
			if (resultSet != null) {
				while (resultSet.next()) {
					sb = new StringBuffer();
					customer.setCustomerId(resultSet.getInt("CUSTOMER_ID"));
					sb.append(resultSet.getString("SALUTATION")).append(" ")
							.append(resultSet.getString("FULL_NAME"));
					customer.setFullName(sb.toString());
					customer.setDateOfBirth(resultSet
							.getString("DATE_OF_BIRTH"));
					customer.setGender(resultSet.getString("GENDER"));
					customer.setPrimaryEmailId(resultSet
							.getString("PRIMARY_EMAIL_ID"));
					customer.setAlternateEmailId(resultSet
							.getString("ALTERNATE_EMAIL_ID"));
					customer.setDesignation(resultSet.getString("DESIGNATION"));
					customer.setDepartment(resultSet.getString("DEPARTMENT"));
					customer.setUserRole(resultSet.getString("USER_ROLE"));
					customer.setLocation(resultSet.getString("WORK_LOCATION"));
					customer.setAddressLine1(resultSet
							.getString("ADDRESS_LINE_1"));
					customer.setAddressLine2(resultSet
							.getString("ADDRESS_LINE_2"));
					customer.setCity(resultSet.getString("CITY"));
					customer.setState(resultSet.getString("STATE"));
					customer.setCountry(nameHelper.getCountryName(resultSet
							.getInt("REF_COUNTRY")));
					customer.setZipcode(resultSet.getString("ZIPCODE"));
					customer.setPhoneNo(resultSet.getString("PHONE_NO"));
					customer.setMobileNo(resultSet.getString("MOBILE_NO"));
					customer.setFaxNo(resultSet.getString("FAX_NO"));
					customer.setWebSite(resultSet.getString("WEBSITE"));
					customer.setLanguage(nameHelper.getLanguageName(resultSet
							.getInt("LANGUAGE")));
				}
			} else {
				logger.error("Registration Reference number is not valid, ther is no record found.");
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

		return customer;
	}

	/**
	 * <p>
	 * <code>getPassword</code>Method is use to get old password from database
	 * </p>
	 * 
	 * @param loginVO
	 * @throws OMIApplicationException
	 */
	public int getPassword(LoginVO loginVO) throws OMIApplicationException {
		int target = 0;
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_PASSWORD);
			preparedStatement.setString(1, loginVO.getPassword());
			;
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				loginVO.setPassword(resultSet.getString("PASSWORD"));
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
	 * <code>updateCustomerLoginPassword</code>Method Will Update the user
	 * password
	 * </p>
	 * 
	 * @param loginVO
	 * @throws OMIApplicationException
	 */
	@Override
	public int updateCustomerLoginPassword(LoginVO loginVO, int customerId)
			throws OMIApplicationException {
		int target = 0;
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.UPDATE_CUSTOMER_CURRENT_LOGIN_PASSWORD);
			preparedStatement.setString(1, loginVO.getNewPassword());
			preparedStatement.setString(2, OMIConstants.LOGIN_FLAG_PVC);
			preparedStatement.setInt(3, customerId);

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
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}

		return target;

	}

	/**
	 * <p>
	 * <code>updateLoginConfigurationSetting</code>Method is use for
	 * Configuration Setting.
	 * </p>
	 * 
	 * @param loginVO
	 * @param customerId
	 * @throws OMIApplicationException
	 */
	@Override
	public int updateLoginConfigurationSetting(LoginVO loginVO, int customerId)
			throws OMIApplicationException {
		int target = 0;
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.UPDATE_CUSTOMER_CONF_SETTING);
			preparedStatement.setString(1, loginVO.getCurrency());
			preparedStatement.setString(2, loginVO.getLanguage());
			preparedStatement.setString(3, loginVO.getTimeZone());
			preparedStatement.setString(4, OMIConstants.LOGIN_FLAG_CSS);
			preparedStatement.setInt(5, customerId);

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
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}

		return target;

	}

	/**
	 * <p>
	 * <code>getPassword</code>Method is use to get old password from database
	 * </p>
	 * 
	 * @param loginVO
	 * @param customerId
	 * @throws OMIApplicationException
	 */
	public int getUpdatedPassword(LoginVO loginVO, int customerId)
			throws OMIApplicationException {

		int target = 0;
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_UPDATED_PASSWORD);
			preparedStatement.setInt(1, customerId);
			System.out.println("Customer Id IS             :" + customerId);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				loginVO.setCustomerId(resultSet.getInt("CUSTOMER_ID"));
				loginVO.setPrimaryEmailId(resultSet
						.getString("PRIMARY_EMAIL_ID"));
				loginVO.setPassword(resultSet.getString("PASSWORD"));
				System.out.println("*************New Password"
						+ resultSet.getString("PASSWORD"));
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

	@Override
	public LoginVO getUserRole(int customerId) throws OMIApplicationException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String getCompanyDetailsQuery = QueryMaker.GET_USER_ROLE_BY_ID;

		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(getCompanyDetailsQuery);
			preparedStatement.setInt(1, customerId);
			resultSet = preparedStatement.executeQuery();

			if (resultSet != null) {
				while (resultSet.next()) {
					loginVO = new LoginVO();
					loginVO.setCustomerId(resultSet.getInt("REG_ID"));

					loginVO.setUserRole(resultSet.getInt("USER_ROLE"));

				}
			} else {
				logger.error("Registration Reference number is not valid, ther is no record found.");
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
		return loginVO;

	}

	@Override
	public void insertForgetPasswordRegistraionDetails(CompanyVO companyVO)
			throws OMIApplicationException {

		String query = QueryMaker.INSERT_FORGET_PASSWORD_DETAILS;
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, companyVO.getCompanyEmailId());
			preparedStatement.setString(2, companyVO.getCompanyRefNo());
			preparedStatement.setString(3, LoginUtil.getIPAddress());
			preparedStatement.setString(4, OMIConstants.FALSE);
			preparedStatement.setInt(5, companyVO.getCreatedBy());
			preparedStatement.setString(6, DateTimeUtil.getDateAndTime());
			preparedStatement.executeUpdate();

		} catch (SQLException sqlException) {
			logger.error(
					"Customer forget Password Process failed in database, Please refer below log:",
					sqlException);
			throw new CreateFailedException();
		} catch (Exception exception) {
			logger.error(
					"Problem during forget Password Process in database, Please refer below log:",
					exception);
		} finally {
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}

	}

	@Override
	public Customer getForgetPasswordDetails(String custReferenceNo)
			throws Exception {
		Customer customer = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String getCompanyDetailsQuery = QueryMaker.GET_FORGET_PASSWORD_DETAILS_BY_REFNO;

		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(getCompanyDetailsQuery);
			preparedStatement.setString(1, custReferenceNo);
			resultSet = preparedStatement.executeQuery();

			if (resultSet != null) {
				while (resultSet.next()) {
					customer = new Customer();
					customer.setCustomerId(resultSet
							.getInt("FORGET_PASSWORED_ID"));
					customer.setPrimaryEmailId(resultSet
							.getString("PRIMARY_EMAIL_ID"));
					customer.setRegistrationRefNo(resultSet
							.getString("FORGET_PASSWORD_GUID"));
					customer.setLoginIPAddress(resultSet
							.getString("IP_ADDRESS"));
					customer.setRegistrationEmailFlag(resultSet
							.getString("EMAIL_FLAG"));
					customer.setCreationDate(resultSet
							.getString("CREATION_DATE"));
					customer.setCreatedBy(resultSet.getInt("CREATED_BY"));
				}
			} else {
				logger.error("Registration Reference number is not valid, ther is no record found.");
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
		return customer;

	}

	@Override
	public int updateEmailFlagForgetPassword(String companyRefNo)
			throws UpdateFailedException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = getConnection();
			String updateEmailFlagCustomerRegistration = QueryMaker.UPDATE_EMAIL_FLAG_FORGET_PASSWORD;
			preparedStatement = connection
					.prepareStatement(updateEmailFlagCustomerRegistration);

			preparedStatement.setString(1, OMIConstants.TRUE);
			preparedStatement.setString(2, companyRefNo);
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
	 * <code>showSecurityQuestion()</code> method is used to fetch the security
	 * question of the user on the basis of
	 * </p>
	 * 
	 * @param primaryEmailID
	 * @return customerVO
	 * @throws OMIApplicationException
	 */

	@Override
	public CustomerVO showSecurityQuestion(String primaryEmailID)
			throws OMIApplicationException {
		String query = QueryMaker.SELECT_SECURITY_QUESTION;
		CustomerVO customerVO = null;
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, primaryEmailID);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				customerVO = new CustomerVO();
				customerVO.setPrimaryEmailId(resultSet
						.getString("PRIMARY_EMAIL_ID"));

				customerVO.setSecurityQuestion(nameHelper
						.getForgetPasswordSecurityQuestion(resultSet
								.getInt("REF_SECURITY_QUESTION_ID")));

			}
		} catch (SQLException sqlException) {
			logger.error(
					"Failed To fetch the Security Question on basis of Primary Email-Id during verify Forget Password.",
					sqlException);

			throw new RecordNotFoundException();
		} catch (Exception exception) {
			logger.error(
					"Exception occured while retrieving the Security Question from the database ",
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
	 * <code>checkPrimaryEmailIdAndPassword()</code> method is used to fetch the
	 * password on the basis of
	 * </p>
	 * 
	 * @param primaryEmailID
	 * @param answer
	 * @return customerVO
	 * @throws OMIApplicationException
	 */

	@Override
	public CustomerVO checkPrimaryEmailIdAndPassword(String primaryEmailID,
			String answer) throws OMIApplicationException {

		String query = QueryMaker.SELECT_PASSWORD;
		CustomerVO customerVO = null;
		try {
			connection = getConnection();

			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, primaryEmailID);
			preparedStatement.setString(2, answer);

			resultSet = preparedStatement.executeQuery();

			if (resultSet != null) {
				while (resultSet.next()) {
					customerVO = new CustomerVO();
					customerVO.setCustomerId(resultSet.getInt("CUSTOMER_ID"));

					customerVO.setPassword(resultSet.getString("PASSWORD"));
					customerVO.setFullName(resultSet.getString("FULL_NAME"));

					customerVO.setPrimaryEmailId(resultSet
							.getString("PRIMARY_EMAIL_ID"));
				}
			}
		} catch (SQLException sqlException) {
			logger.error(
					"Failed To fetch the Password on basis of Primary Email-Id & Security Answer during verify Forget Password.",
					sqlException);

			throw new RecordNotFoundException();
		} catch (Exception exception) {
			logger.error(
					"Exception occured while retrieving the Password from the database ",
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
	 * <code>updateCustomerLoginPassword()</code> method is used to update the
	 * current login password on the basis of
	 * </p>
	 * 
	 * @param customerVO
	 * @param customerId
	 * @return
	 * @throws OMIApplicationException
	 */

	@Override
	public int updateCustomerLoginPassword(CustomerVO customerVO, int customerId)
			throws OMIApplicationException {
		int target = 0;
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.UPDATE_CUSTOMER_CURRENT_LOGIN_PASSWORD);
			preparedStatement.setString(1, customerVO.getNewPassword());
			preparedStatement.setString(2, OMIConstants.LOGIN_FLAG_PVC);
			preparedStatement.setInt(3, customerId);

			preparedStatement.executeUpdate();
			target = 1;
		} catch (SQLException sqlException) {

			logger.error("error while update customer login password"
					+ sqlException);

		} catch (Exception exception) {

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
	 * <code>getUpdatedPassword()</code> method is used to update the password
	 * on the basis of
	 * </p>
	 * 
	 * @param customerVO
	 * @param customerId
	 * @return customerVO
	 * @throws OMIApplicationException
	 */

	@Override
	public int getUpdatedPassword(CustomerVO customerVO, int customerId)
			throws OMIApplicationException {
		int target = 0;
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_UPDATED_PASSWORD);
			preparedStatement.setInt(1, customerId);

			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				customerVO.setCustomerId(resultSet.getInt("CUSTOMER_ID"));
				customerVO.setPrimaryEmailId(resultSet
						.getString("PRIMARY_EMAIL_ID"));
				customerVO.setPassword(resultSet.getString("PASSWORD"));

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
}
