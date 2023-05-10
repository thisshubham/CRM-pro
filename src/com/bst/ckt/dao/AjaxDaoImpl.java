package com.bst.ckt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.bst.ckt.common.QueryMaker;
import com.bst.ckt.exception.EmailAlreadyExistsException;
import com.bst.ckt.framework.db.JdbcDAOSupport;
import com.bst.ckt.framework.db.JdbcHelper;

public class AjaxDaoImpl extends JdbcDAOSupport implements AjaxDaoInf{

	/**
	 * Creating Logger object, logger object mapped with AjaxDaoImpl
	 * class for writing Loggers.
	 */
	private static final Logger logger = Logger
			.getLogger(AjaxDaoImpl.class);
	
	PreparedStatement preparedStatement = null;
	Connection connection = null;
	ResultSet resultSet = null;

	/**
	 * <p>
	 * <code>isMobileNoAlreadyExists(String)</code> method help to verify the
	 * existing mobile no available in the database. if entered email id already
	 * available into the database then this method will return 1 else 0;
	 * </p>
	 * 
	 * @param mobile
	 *            String
	 * @return
	 * @throws MobileNoAlreadyExistsException
	 *             customized exception throw when mobile number already exists
	 *             into the database.
	 */
	public int isMobileNoAlreadyExists(String mobile) throws Exception {

		String existMobile = null;
		try {

			connection = getConnection();
			preparedStatement = connection.prepareStatement(QueryMaker.GET_COMPANY_MOBILE_NUMBER);
			preparedStatement.setString(1, mobile);

			resultSet = preparedStatement.executeQuery();

			if (resultSet != null) {
				while (resultSet.next()) {
					existMobile = resultSet.getString("MOBILE_NO");
					if (existMobile.equalsIgnoreCase(existMobile)) {
						logger.info("Mobile No Id Already exists");
						return 1;
					}
				}
				} else {
				return 0;
			}

		} catch (SQLException sqlException) {
			logger.error("Failed to verify the mobile number ", sqlException);
		} catch (Exception exception) {
			logger.error("Exception occured while verify the mobile number",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return 0;
	}

	
	/**
	 * <p>
	 * <code>isEmailAlreadyExist(String)</code> method help to verify the
	 * existing email id available in the database. if entered email id already
	 * available into the database then this method will return 1 else 0;
	 * </p>
	 * 
	 * @param primaryEmail
	 *            String
	 * @return
	 * @throws EmailAlreadyExistsException
	 *             customized exception throw when primaryEmail already exists
	 *             into the database.
	 */
	public int isEmailAlreadyExist(String primaryEmail)
			throws EmailAlreadyExistsException {
		
		String existEmail = null;
		try {

			connection = getConnection();
			preparedStatement = connection.prepareStatement(QueryMaker.GET_COMPANY_PRIMARY_EMAIL);
			preparedStatement.setString(1, primaryEmail);

			resultSet = preparedStatement.executeQuery();

			if (resultSet != null) {
				while (resultSet.next()) {
					existEmail = resultSet.getString("COMPANY_EMAIL_ID");

					if (existEmail.equalsIgnoreCase(primaryEmail)) {
						logger.info("Email Id Already exists");
						return 1;
					}
				}
			} else {
				return 0;
			}

		} catch (SQLException sqlException) {
			logger.error(
					"Failed to verify if email id already exists  on basis of primary email id",
					sqlException);
			throw new EmailAlreadyExistsException();
		} catch (Exception exception) {

			logger.error(
					"Exception occured while verifying  if email id already exists  on basis of primary email id",
					exception);

		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return 0;
	}
	
	/**
	 * <p>
	 * <code>isEmailAlreadySaved(String)</code> method help to verify the
	 * existing email id available in the database. if entered email id already
	 * available into the database then this method will return 1 else 0;
	 * </p>
	 * 
	 * @param primaryEmail
	 *            String
	 * @return
	 * @throws EmailAlreadyExistsException
	 *             customized exception throw when primaryEmail already exists
	 *             into the database.
	 */
	public int isEmailAlreadySaved(String primaryEmail)
			throws EmailAlreadyExistsException {
		
		String existEmail = null;
		try {

			connection = getConnection();
			preparedStatement = connection.prepareStatement(QueryMaker.GET_CUSTOMER_PRIMARY_EMAIL);
			preparedStatement.setString(1, primaryEmail);

			resultSet = preparedStatement.executeQuery();

			if (resultSet != null) {
				while (resultSet.next()) {
					existEmail = resultSet.getString("PRIMARY_EMAIL_ID");
					System.out.println("exist email ="+existEmail);
					if (existEmail.equalsIgnoreCase(primaryEmail)) {
						logger.info("Email Id Already exists");
						return 1;
					}
				}
			} else {
				return 0;
			}

		} catch (SQLException sqlException) {
			logger.error(
					"Failed to verify if email id already exists  on basis of primary email id",
					sqlException);
			throw new EmailAlreadyExistsException();
		} catch (Exception exception) {

			logger.error(
					"Exception occured while verifying  if email id already exists  on basis of primary email id",
					exception);

		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return 0;
	}
	
	/**
	 * <p>
	 * <code>addSocialSite(String)</code> method help to insert social site 
	 *  into the database then this method will return 1 else 0;
	 * </p>
	 * 
	 * @param addSocialSite
	 *            String
	 * @return
	 * @throws EmailAlreadyExistsException
	 *             customized exception throw when primaryEmail already exists
	 *             into the database.
	 */
	public int addSocialSite(String socialSiteid)
			throws Exception {
		
		String socialSiteId = null;
		String socialSiteValue = null;
		try {

			connection = getConnection();
			preparedStatement = connection.prepareStatement(QueryMaker.INSERT_SOCIAL_SITE);
			preparedStatement.setString(1, socialSiteId);			
			preparedStatement.setString(1, socialSiteValue);

			resultSet = preparedStatement.executeQuery();

			if (resultSet != null) {
				while (resultSet.next()) {
					String socialSite = resultSet.getString("SOCIAL_SITE_ID");
					System.out.println("add site ="+socialSite);
					if (socialSite.equalsIgnoreCase(socialSiteid)) {
						logger.info("id is inserted");
						return 1;
					}
				}
			} else {
				return 0;
			}

		} catch (SQLException sqlException) {
			logger.error(
					"Failed to verify if email id already exists  on basis of primary email id",
					sqlException);
			throw new EmailAlreadyExistsException();
		} catch (Exception exception) {

			logger.error(
					"Exception occured while verifying  if email id already exists  on basis of primary email id",
					exception);

		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return 0;
	}


	/**
	 * <p>
	 * <code>isEmailAlreadyExist(String)</code> method help to verify the
	 * existing email id available in the database. if entered email id already
	 * available into the database then this method will return 1 else 0;
	 * </p>
	 * 
	 * @param primaryEmail
	 *            String
	 * @return
	 * @throws EmailAlreadyExistsException
	 *             customized exception throw when primaryEmail already exists
	 *             into the database.
	 */
	public int emailAlreadyExist(String primaryEmail)
			throws EmailAlreadyExistsException {
		
		String existEmail = null;
		try {

			connection = getConnection();
			preparedStatement = connection.prepareStatement(QueryMaker.GET_CUSTOMER_PRIMARY_EMAIL);
			preparedStatement.setString(1, primaryEmail);

			resultSet = preparedStatement.executeQuery();

			if (resultSet != null) {
				while (resultSet.next()) {
					existEmail = resultSet.getString("COMPANY_EMAIL_ID");

					if (existEmail.equalsIgnoreCase(primaryEmail)) {
						logger.info("Email Id Already exists");
						return 1;
					}
				}
			} else {
				return 0;
			}

		} catch (SQLException sqlException) {
			logger.error(
					"Failed to verify if email id already exists  on basis of primary email id",
					sqlException);
			throw new EmailAlreadyExistsException();
		} catch (Exception exception) {

			logger.error(
					"Exception occured while verifying  if email id already exists  on basis of primary email id",
					exception);

		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return 0;
	}
	

}
