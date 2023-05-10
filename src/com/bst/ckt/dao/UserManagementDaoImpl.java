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
import com.bst.ckt.dto.Lead;
import com.bst.ckt.exception.CreateFailedException;
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
import com.bst.ckt.vo.LeadVO;
import com.itextpdf.text.Image;

public class UserManagementDaoImpl extends JdbcDAOSupport implements
		UserManagementDaoInf {

	public static final Logger logger = Logger.getLogger(LeadDaoImpl.class);
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	LeadVO leadVO = null;
	Lead lead = null;
	Image image = null;
	NameHelper nameHelper = new NameHelper();
	CustomerVO customerVO = new CustomerVO();
	UserRole userRole = null;
	UserStatus userStatus = null;

	/**
	 * <p>
	 * <code>getUserDetails()</code> method use to Fetch User details from
	 * TAB_CUSTOMER_USER table.
	 * </p>
	 * 
	 * @return userDetailsList
	 * @throws Exception
	 */
	@Override
	public List<CustomerVO> getUserDetails(CustomerVO customerVO) throws Exception {
		String query = QueryMaker.GET_USER_DETAILS_LIST;
		ArrayList<CustomerVO> userDetailsList = new ArrayList<CustomerVO>();

		
		try {

			connection = getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1,customerVO.getCompanyId());
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				customerVO = new CustomerVO();
				customerVO.setCustomerId(resultSet.getInt("CUSTOMER_ID"));
				customerVO.setFullName(resultSet.getString("FULL_NAME"));
				customerVO.setUserRole(UserRole.getUserRole(resultSet
						.getInt("USER_ROLE")));
				customerVO
						.setCreationDate(resultSet.getString("CREATION_DATE"));
				customerVO.setUserStatus(UserStatus.getUserStatus(resultSet
						.getInt("USER_STATUS")));
				customerVO.setUploadedFilePath(resultSet
								.getString("PROFILE_IMAGE_PATH"));
				customerVO.setPassword(resultSet
						.getString("PASSWORD"));
				
				userDetailsList.add(customerVO);
			}

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					UserManagementDaoImpl.class
							+ "Error: Occur in Query While fetching the Customers User Details into Database.",
					sqlException);

		} catch (Exception exception) {

			exception.printStackTrace();
			logger.error(
					UserManagementDaoImpl.class
							+ "Error: Occur While Closing Connection After etching the Customers User Details into Database.",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return userDetailsList;
	}

	/**
	 * <p>
	 * <code>insertUserDetail()</code> method use to Insert User details into
	 * TAB_CUSTOMER_TEMP table.
	 * 
	 * </p>
	 * 
	 * @return target
	 * @throws Exception
	 */
	@Override
	public int insertUserDetail(CustomerVO customerVO)
			throws OMIApplicationException {
		int target = 0;
		/*INSERT INTO TAB_CUSTOMER_USER "
		+ "(SALUTATION,FULL_NAME,PRIMARY_EMAIL_ID,MOBILE_NO,USER_ROLE,REF_COUNTRY,CREATION_DATE,EMAIL_FLAG,"
		+ "CREATED_BY,REF_COMPANY, ACL_ID)VALUES(?,?,?,?,?,?,?,?,?,?,?)
*/		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.ADD_USER_DETAILS);
			preparedStatement.setString(1, customerVO.getSalutation());
			preparedStatement.setString(2, customerVO.getFullName());
			preparedStatement.setString(3, customerVO.getPrimaryEmailId());
			preparedStatement.setString(4, customerVO.getMobileNo());
			preparedStatement.setString(5, customerVO.getUserRole());
			preparedStatement.setString(6, customerVO.getCountry());
			
			preparedStatement.setString(7, DateTimeUtil.getCurrentDate());
			preparedStatement.setString(8, OMIConstants.TRUE);
			
			preparedStatement.setInt(9, customerVO.getCustomerId());
			preparedStatement.setInt(10, customerVO.getCompanyId());
			preparedStatement.setString(11, customerVO.getShopName());
			preparedStatement.setString(12, customerVO.getPassword());
			preparedStatement.setInt(13, UserStatus.ACTIVE_ID);			

			preparedStatement.executeUpdate();

			target = 1;
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					UserManagementDaoImpl.class
							+ "Error: Occur in Query While Inserting the User Details into Database.",
					sqlException);

		} catch (Exception exception) {

			exception.printStackTrace();
			logger.error(
					UserManagementDaoImpl.class
							+ "Error: Occur While Closing Connection After Inserting the User Details into Database.",
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
	public int updateEmailFlagGuid(String createUserGuid) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = getConnection();
			String updateEmailFlagGuid = QueryMaker.UPDATE_CREATE_USER_EMAIL_FLAG;
			preparedStatement = connection
					.prepareStatement(updateEmailFlagGuid);

			preparedStatement.setString(1, OMIConstants.TRUE);
			preparedStatement.setString(2, createUserGuid);
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
	 * <code>getCustomerStaffUserDetails()</code> method use to get the customer
	 * staff user details from TAB_CUSTOMER_TEMP table.
	 * 
	 * </p>
	 * 
	 * @throws OMIApplicationException
	 */
	public CustomerVO getCustomerStaffUserDetails(String referenceId)
			throws OMIApplicationException {

		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_CUSTOMER_STAFF_USER_DETAILS_BY_GUID);
			preparedStatement.setString(1, referenceId);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				customerVO = new CustomerVO();
				customerVO.setCustomerId(resultSet.getInt("REG_ID"));
				customerVO.setFullName(resultSet.getString("FULL_NAME"));
				customerVO.setPrimaryEmailId(resultSet.getString("EMAIL_ID"));
				customerVO.setMobileNo(resultSet.getString("MOBILE_NO"));
				customerVO.setComapnyName(resultSet.getString("COMPANY_NAME"));
				customerVO.setRegistrationRefNo(resultSet
						.getString("REG_REF_NO"));
				customerVO.setUserRole(resultSet.getString("USER_ROLE"));
				customerVO.setRefCountry(resultSet.getInt("COUNTRY"));
				customerVO.setLoginIPAddress(resultSet.getString("IP_ADDRESS"));
				customerVO.setRegistrationEmailFlag(resultSet
						.getString("EMAIL_FLAG"));
				customerVO.setCreationDate(resultSet.getString("CREATED_DATE"));
				customerVO.setCreatedBy(resultSet.getInt("CREATED_BY"));
				customerVO.setShopName(resultSet.getString("SHOP_ID"));

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
	 * <code>getCustomerStaffUserIdByRef()</code> method use to get the customer
	 * staff user details from TAB_CUSTOMER_TEMP table. by refNo.
	 * 
	 * </p>
	 * 
	 * @throws OMIApplicationException
	 */
	public int getCustomerStaffUserIdByRef(int createdBy)
			throws OMIApplicationException {
		int customerId = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_CUSTOMER_ID_BY_REFNO);
			preparedStatement.setInt(1, customerVO.getCreatedBy());
			resultSet = preparedStatement.executeQuery();

			if (resultSet != null) {
				while (resultSet.next()) {
					customerId = resultSet.getInt("CUSTOMER_ID");
				}
			} else {
				logger.error("create staff user  email Reference number is not valid, there is no record found.");
			}
		} catch (SQLException sqlException) {
			logger.error(
					"Failed To fetch the create staff user  email reference basis of registration referece no.",
					sqlException);
		} catch (Exception exception) {
			logger.error(
					"Exception occured while retrieving the register customer recore from the database ",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return customerId;
	}

	/**
	 * <p>
	 * <code>updateCustomerStaffUserEmailFlagByEmail()</code> method use to
	 * update the email flag by email id.
	 * 
	 * </p>
	 * 
	 * @throws OMIApplicationException
	 */
	public void updateCustomerStaffUserEmailFlagByEmail(String primaryEmailId,
			String emailFlag) throws OMIApplicationException {

		PreparedStatement preparedStatement = null;
		Connection connection = null;

		try {

			connection = getConnection();
			String updateCustomerEmailFlagByEmailQuery = QueryMaker.UPDATE_EMAILFLAG_CUSTOMER_STAFF_USER;
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
	 * <code>createCustomerStaffUser()</code> method use to insert the customer
	 * details.
	 * 
	 * </p>
	 * 
	 * @throws OMIApplicationException
	 */
	@Override
	public void createCustomerStaffUser(CustomerVO customerVO, int customerId,
			String password) throws OMIApplicationException {
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		try {

			connection = getConnection();
			String createCustomerUserQuery = QueryMaker.CREATE_CUSTOMER;
			preparedStatement = connection
					.prepareStatement(createCustomerUserQuery);

			preparedStatement.setString(1, password);
			preparedStatement.setString(2, customerVO.getFullName());
			preparedStatement.setInt(3, customerId);
			preparedStatement.setString(4, customerVO.getPrimaryEmailId());
			preparedStatement.setString(5, customerVO.getMobileNo());
			preparedStatement.setInt(6, customerVO.getRefCountry());
			preparedStatement.setString(7, DateTimeUtil.getCurrentDate());
			preparedStatement.setInt(8, customerVO.getCustomerId());
			preparedStatement.setString(9, customerVO.getUserRole());
			preparedStatement.setInt(10, UserStatus.REGISTERED_ID);
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

	/**
	 * 
	 * <P>
	 * <CODE>getCompanyId<CODE> method is use to get the companyId
	 * </p>
	 * 
	 * @throws OMIApplicationException
	 * 
	 */
	@Override
	public int getCompanyId(int customerId) throws OMIApplicationException {
		int companyId = 0;
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_COMPANYID_BY_CUSTOMERID);
			preparedStatement.setInt(1, customerId);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				customerVO = new CustomerVO();
				companyId = resultSet.getInt("REF_COMPANY");

			}
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					"ERROR while getting companyId from  database, Please refer below log:",
					sqlException);
		} catch (Exception exception) {

			exception.printStackTrace();
			logger.error(
					"ERROR while getting companyId from  database, Please refer below log:",
					exception);

		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return companyId;
	}

	/**
	 * 
	 * <P>
	 * <CODE>createCustomerStaff<CODE> method is use to Create customer user insert details into database
	 * </p>
	 * 
	 * @throws OMIApplicationException
	 * 
	 */
	@Override
	public void createCustomerStaff(CustomerVO customerVO,
			String primaryEmailId, String password)
			throws OMIApplicationException {
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_CUSTOMER_DETAIL_BY_EMAIL);
			preparedStatement.setString(1, customerVO.getPrimaryEmailId());
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				throw new OMIApplicationException();
			} else {
				try {
System.out.println("bharti u r creating row in user cust table solved");
					preparedStatement = connection
							.prepareStatement(QueryMaker.INSERT_CUSTOMER_DETAIL_BY_EMAIL);
					preparedStatement.setString(1,
							customerVO.getPrimaryEmailId());
					preparedStatement.setString(2, customerVO.getFullName());
					preparedStatement.setInt(3, customerVO.getRefCountry());
					preparedStatement.setString(4, customerVO.getComapnyName());
					preparedStatement.setString(5, customerVO.getUserRole());
					preparedStatement
							.setString(6, customerVO.getCreationDate());
					preparedStatement.setInt(7, customerVO.getCreatedBy());
					preparedStatement.setString(8, OMIConstants.TRUE);
					preparedStatement.setInt(9, UserStatus.ACTIVE_ID);
					preparedStatement.setString(10, password);
					preparedStatement.setString(11, OMIConstants.LOGIN_FLAG_FTL);
					preparedStatement.setString(12, customerVO.getShopName());
					preparedStatement.executeUpdate();

				} catch (SQLException sqlexception) {
					sqlexception.printStackTrace();
					logger.error(
							"Problem during Customer Staf User creation in database, Please refer below log:",
							sqlexception);
				}

			}

		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					"Problem during Customer Staf User creation in database, Please refer below log:",
					exception);
		}

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
	/*
	 * @Override public int updateCustomerLoginPassword(CustomerVO customerVO,
	 * int customerId) throws OMIApplicationException { int target = 0; try {
	 * connection = getConnection(); preparedStatement = connection
	 * .prepareStatement(QueryMaker.UPDATE_CUSTOMER_LOGIN_PASSWORD);
	 * preparedStatement.setString(1, customerVO.getPassword());
	 * 
	 * preparedStatement.setInt(2, customerVO.getCustomerId());
	 * preparedStatement.executeUpdate(); target = 1; } catch (SQLException
	 * sqlException) { sqlException.printStackTrace();
	 * logger.error("error while update user login password");
	 * 
	 * } catch (Exception exception) { exception.printStackTrace();
	 * logger.error( MyAccountDaoImpl.class +
	 * "Error: Occur in Query While Updating user login password.", exception);
	 * } finally { JdbcHelper.closePreparedStatement(preparedStatement);
	 * JdbcHelper.closeConnection(connection); }
	 * 
	 * return target; }
	 */

	/**
	 * 
	 * @param customerId
	 * @param userStatus
	 * @throws UpdateFailedException
	 */
	public void updateUserStatus(int customerId, int userStatus)
			throws UpdateFailedException {
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.UPDATE_CUSTOMER_STATUS);
			preparedStatement.setInt(1, userStatus);
			preparedStatement.setInt(2, customerId);
			preparedStatement.executeUpdate();

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		} catch (Exception exception) {
			exception.printStackTrace();
		} finally {
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
	}

	/**
	 * 
	 * @param customerId
	 */
	@Override
	public CustomerVO updateUserInfo(CustomerVO customerVO, int customerId)
			throws OMIApplicationException {

		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_CUSTOMER_ACCOUNT_INFORMATION);
			preparedStatement.setInt(1, customerId);
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
					customerVO.setCountry(nameHelper.getCountryName(resultSet
							.getInt("REF_COUNTRY")));
					customerVO.setZipcode(resultSet.getString("ZIPCODE"));
					customerVO.setPhoneNo(resultSet.getString("PHONE_NO"));
					customerVO.setMobileNo(resultSet.getString("MOBILE_NO"));
					customerVO.setFaxNo(resultSet.getString("FAX_NO"));
					customerVO.setWebSite(resultSet.getString("WEBSITE"));

					customerVO.setLanguageId(resultSet.getInt("LANGUAGE"));

					customerVO.setCurrencyId(resultSet.getInt("REF_CURRENCY"));

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
	 * <code>editUserDetails</code> Method implements to update customer account
	 * information into <code>TAB_CUSTOMER_USER</code>
	 * 
	 * @param customerVO
	 * @return target int
	 * @throws SQLException
	 *             </p>
	 */
	@Override
	public int editUserDetails(CustomerVO customerVO, int customerId,
			String filePath, String userImageFileName)
			throws OMIApplicationException {
		int target = 0;
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.UPDATE_USER_DETAILS);
			preparedStatement.setString(1, customerVO.getSalutation());
			preparedStatement.setString(2, customerVO.getFullName());
			preparedStatement.setString(3, customerVO.getDateOfBirth());
			preparedStatement.setString(4, customerVO.getGender());
			preparedStatement.setString(5, customerVO.getPrimaryEmailId());
			preparedStatement.setString(6, customerVO.getAlternateEmailId());
			preparedStatement.setString(7, customerVO.getDepartment());
			preparedStatement.setString(8, customerVO.getLocation());
			preparedStatement.setString(9, customerVO.getAddressLine1());
			preparedStatement.setString(10, customerVO.getAddressLine2());
			preparedStatement.setString(11, customerVO.getCity());
			preparedStatement.setString(12, customerVO.getState());
			preparedStatement.setString(13, customerVO.getCountry());
			preparedStatement.setString(14, customerVO.getZipcode());
			preparedStatement.setString(15, customerVO.getPhoneNo());
			preparedStatement.setString(16, customerVO.getMobileNo());
			preparedStatement.setString(17, customerVO.getFaxNo());
			preparedStatement.setString(18, customerVO.getWebSite());
			preparedStatement.setString(19, customerVO.getLanguage());
			preparedStatement.setString(20, customerVO.getTimeZone());
			preparedStatement.setString(21, customerVO.getCurrency());
			preparedStatement.setString(22, filePath);
			preparedStatement.setString(23, customerVO.getDesignation());
			preparedStatement.setString(24, customerVO.getUserRole());
			preparedStatement.setString(25, customerVO.getUserStatus());
			preparedStatement.setInt(26, customerId);
			preparedStatement.executeUpdate();
			target = 1;
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error("error while update record from database");

		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					MyAccountDaoImpl.class
							+ "Error: Occur in Query While Updating Account Information into Database.",
					exception);
		} finally {

			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);

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
	public int updateCustomerLoginPassword(CustomerVO customerVO, int customerId)
			throws OMIApplicationException {
		int target = 0;
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.UPDATE_CUSTOMER_LOGIN_PASSWORD);
			preparedStatement.setString(1, customerVO.getPassword());
			preparedStatement.setInt(2, customerId);
			preparedStatement.executeUpdate();
			target = 1;
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error("error while update user login password");

		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					MyAccountDaoImpl.class
							+ "Error: Occur in Query While Updating user login password.",
					exception);
		} finally {
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
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
	public int updateUserEmailId(CustomerVO customerVO, int customerId)
			throws OMIApplicationException {
		int target = 0;
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.UPDATE_CUSTOMER_EMAIL_ID);
			preparedStatement.setString(1, customerVO.getPrimaryEmailId());
			preparedStatement.setInt(2, customerId);
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
				customerVO.setFullName(resultSet.getString("EMAIL_ID"));
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
					.prepareStatement(QueryMaker.UPDATE_USER_PRIMARY_EMAIL_ID);
			int customerId = LoginUtil.getProcessUserId();

			preparedStatement.setString(1, customerVO.getPrimaryEmailId());
			preparedStatement.setInt(2, customerVO.getCreatedBy());
			preparedStatement.setString(3, customerVO.getCreationDate());
			preparedStatement.setInt(4, customerId);
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
	 * <p>
	 * <code>getuserSocialDetailsList()</code> method use to get social
	 * details..
	 * 
	 * </p>
	 * 
	 * @throws OMIApplicationException
	 */
	@Override
	public List<CustomerVO> getuserSocialDetailsList(int cutomerId) {
		ArrayList<CustomerVO> userSocialDetails = new ArrayList<CustomerVO>();
		try {

			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_LEAD_SOCIAL_DETAILS);
			preparedStatement.setInt(1, Modules.USER_MANAGEMENT_ID);

			preparedStatement.setInt(2, cutomerId);
			// SOCIAL_SITE_REF,SOCIAL_CONTACT_VALUE
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				CustomerVO customerVO = new CustomerVO();
				customerVO.setSocialSiteRefName(nameHelper
						.getSocialSite(resultSet.getInt("SOCIAL_SITE_REF")));
				customerVO.setSocialContactValue(resultSet
						.getString("SOCIAL_CONTACT_VALUE"));
				userSocialDetails.add(customerVO);
			}

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					LeadDaoImpl.class
							+ ": Error:- Error: Occur in Query While fetching user social details from Database",
					sqlException);

		} catch (Exception exception) {
			logger.error(
					LeadDaoImpl.class
							+ ": Error:- While closing the Connection after fetching the user social details from Database",
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
	 * <code>insertOrUpdateUserSocialInformation()</code> method use to get
	 * social details and update..
	 * 
	 * </p>
	 * 
	 * @throws Exception
	 */
	@Override
	public int insertOrUpdateUserSocialInformation(CustomerVO customerVO)
			throws Exception {
		int target = 0;

		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_SOCIAL_INFO);
			preparedStatement.setInt(1, customerVO.getSocialSiteRef());
			preparedStatement.setInt(2, Modules.USER_MANAGEMENT_ID);
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
				preparedStatement.setInt(3, Modules.USER_MANAGEMENT_ID);
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
				preparedStatement.setInt(3, Modules.USER_MANAGEMENT_ID);
				preparedStatement.setInt(4, customerVO.getCustomerId());
				preparedStatement.executeUpdate();
				target = 1;

			}

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					LeadDaoImpl.class
							+ ": Error:- Error: Occur in Query While inserting the user social details into Database",
					sqlException);

		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					LeadDaoImpl.class
							+ ": Error:- While closing the Connection after inserting the user social details into Database",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return target;
	}
}
