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
 * Class Name     AccountDaoImpl.java     
 *                                                            
 * Creation Date  SEP 18, 2015 
 * 
 * Abstract       This is AccountDaoImpl class design to implement  
 * 				  the methods of AccountDaoInf interface
 *  
 * Amendment History (in chronological sequence): SEP 18, 2015 
 * 
 **********************************************************************
 */

package com.bst.ckt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.bst.ckt.common.QueryBuilder;
import com.bst.ckt.common.QueryMaker;
import com.bst.ckt.dto.AccountDTO;
import com.bst.ckt.framework.db.JdbcDAOSupport;
import com.bst.ckt.framework.db.JdbcHelper;
import com.bst.ckt.framework.util.DateTimeUtil;
import com.bst.ckt.helper.AccountType;
import com.bst.ckt.helper.AppendHelper;
import com.bst.ckt.helper.Modules;
import com.bst.ckt.helper.NameHelper;
import com.bst.ckt.vo.AccountVO;

/**
 * 
 * @author Shaikh Hussain
 * 
 */
public class AccountDaoImpl extends JdbcDAOSupport implements AccountDaoInf {

	/**
	 * Creating Logger object, logger object mapped with AccountDaoImpl class
	 * for writing Loggers.
	 */
	private static final Logger logger = Logger.getLogger(AccountDaoImpl.class);

	PreparedStatement preparedStatement = null;
	Connection connection = null;
	ResultSet resultSet = null;
	AccountVO accountVO = new AccountVO();
	NameHelper nameHelper = new NameHelper();
	AccountDTO accountDTO = null;

	/**
	 * <p>
	 * <code>insertNewAccountDetails()</code>this method is design to insert
	 * group details into database
	 * </p>
	 * 
	 * @param accountVO
	 *            AccountVO
	 * @return target int
	 * @throws Exception
	 */
	@Override
	public int insertNewAccountDetails(AccountVO accountVO) throws Exception {

		int target = 0;
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.ADD_NEW_ACCOUNT_DETAILS);
			preparedStatement.setString(1, accountVO.getSalutation());
			preparedStatement.setString(2, accountVO.getAccountOwner());
			preparedStatement.setString(3, accountVO.getAccountName());
			preparedStatement.setString(4, accountVO.getAccountType());
			preparedStatement.setString(5, accountVO.getOwnershipType());
			preparedStatement.setString(6, accountVO.getOrgnisationCategory());
			preparedStatement.setString(7, accountVO.getOrgnisationSector());

			if (accountVO.getNoOfAssociates() != null
					|| accountVO.getNoOfAssociates() != "") {
				preparedStatement.setInt(8, 0);
			} else {
				preparedStatement.setString(8, accountVO.getNoOfAssociates());
			}

			if (accountVO.getAnnualRevenue() != null
					|| accountVO.getAnnualRevenue() != "") {
				preparedStatement.setString(9, "0.00");
			} else {
				preparedStatement.setString(9, accountVO.getAnnualRevenue());
			}
			preparedStatement.setString(10, accountVO.getPhoneNo());
			preparedStatement.setString(11, accountVO.getPhoneIsd());
			preparedStatement.setString(12, accountVO.getPhoneStd());
			preparedStatement.setString(13, accountVO.getMobileNo());
			preparedStatement.setString(14, accountVO.getMobileIsd());
			preparedStatement.setString(15, accountVO.getEmailId());
			preparedStatement.setString(16, accountVO.getParentAccount());
			preparedStatement.setString(17, accountVO.getTrickerSymbol());
			preparedStatement.setString(18, accountVO.getAssignTo());
			preparedStatement.setString(19, accountVO.getRatings());
			preparedStatement.setString(20, accountVO.getNotifyOwner());
			preparedStatement.setString(21, accountVO.getEmailOptOut());
			preparedStatement.setString(22, accountVO.getSlaName());
			preparedStatement.setString(23, accountVO.getBillingSalutation());
			preparedStatement.setString(24,
					accountVO.getBillingContactPersone());
			preparedStatement.setString(25, accountVO.getBillingDesignation());
			preparedStatement.setString(26, accountVO.getBillingAddressLine1());
			preparedStatement.setString(27, accountVO.getBillingAddressLine2());
			preparedStatement.setString(28, accountVO.getBillingCity());
			preparedStatement.setString(29, accountVO.getBillingState());
			preparedStatement.setString(30, accountVO.getBillingCountry());
			preparedStatement.setString(31, accountVO.getBillingZipcode());
			preparedStatement.setString(32, accountVO.getBillingPhoneNo());
			preparedStatement.setString(33, accountVO.getBillingPhoneNoIsd());
			preparedStatement.setString(34, accountVO.getBillingPhoneNoStd());
			preparedStatement.setString(35, accountVO.getBillingMobileNo());
			preparedStatement.setString(36, accountVO.getBillingMobileNoIsd());
			preparedStatement.setString(37, accountVO.getBillingPrimaryEmail());
			preparedStatement.setString(38,
					accountVO.getBillingAlternateEmail());
			preparedStatement.setString(39, accountVO.getBillingFax());
			preparedStatement.setString(40, accountVO.getBillingFaxIsd());
			preparedStatement.setString(41, accountVO.getBillingFaxStd());
			preparedStatement.setString(42, accountVO.getBillingWebsite());
			preparedStatement.setString(43, accountVO.getShippingSalutation());
			preparedStatement.setString(44,
					accountVO.getShippingContactPersone());
			preparedStatement.setString(45, accountVO.getShippingDesignation());
			preparedStatement
					.setString(46, accountVO.getShippingAddressLine1());
			preparedStatement
					.setString(47, accountVO.getShippingAddressLine2());
			preparedStatement.setString(48, accountVO.getShippingCity());
			preparedStatement.setString(49, accountVO.getShippingState());
			preparedStatement.setString(50, accountVO.getShippingCountry());
			preparedStatement.setString(51, accountVO.getShippingZipcode());
			preparedStatement.setString(52, accountVO.getShippingPhoneNo());
			preparedStatement.setString(53, accountVO.getShippingPhoneIsd());
			preparedStatement.setString(54, accountVO.getShippingPhoneStd());
			preparedStatement.setString(55, accountVO.getShippingMobileNo());
			preparedStatement.setString(56, accountVO.getShippingMobileIsd());
			preparedStatement
					.setString(57, accountVO.getShippingPrimaryEmail());
			preparedStatement.setString(58,
					accountVO.getShippingAlternateEmail());
			preparedStatement.setString(59, accountVO.getShippingFax());
			preparedStatement.setString(60, accountVO.getShippingFaxIsd());
			preparedStatement.setString(61, accountVO.getShippingFaxStd());
			preparedStatement.setString(62, accountVO.getShippingWebsite());
			preparedStatement.setString(63, accountVO.getProfileDescription());
			preparedStatement.setString(64, DateTimeUtil.getDateAndTime());
			preparedStatement.setInt(65, accountVO.getCreatedBy());

			preparedStatement.executeUpdate();

			target = 1;
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					AccountDaoImpl.class
							+ "Error: Occur in Query While Inserting the Account Details into Database.",
					sqlException);

		} catch (Exception exception) {

			exception.printStackTrace();
			logger.error(
					AccountDaoImpl.class
							+ "Error: Occur in Query While Closing Connection After Inserting the Account Details into Database.",
					exception);
		} finally {
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return target;
	}

	/**
	 * <p>
	 * <code>retriveAccountDetails()</code>this method is design to fetch
	 * account details from database and also fetch account details according to
	 * the filter.
	 * </p>
	 * 
	 * @param searchId
	 *            int
	 * @param searchValue
	 *            String
	 * 
	 * @throws Exception
	 */
	@Override
	public List<AccountVO> retriveAccountDetails(int searchId,
			String searchValue) throws Exception {

		ArrayList<AccountVO> accountDetailsList = new ArrayList<AccountVO>();
		// ACCOUNT_ID,SALUTATION,CONTACT_PERSON,ACCOUNT_NAME,ACCOUNT_TYPE_REF,MOBILE_NO,ACCOUNT_STATUS
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(QueryBuilder
					.accountAdvanceSearch(searchId, searchValue));
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				accountVO = new AccountVO();
				accountVO.setAccountId(resultSet.getInt("ACCOUNT_ID"));
				accountVO
						.setAccountOwner(resultSet.getString("CONTACT_PERSON"));
				accountVO.setAccountName(resultSet.getString("ACCOUNT_NAME"));
				accountVO.setAccountType(AccountType.getAccountType( resultSet
						.getInt("ACCOUNT_TYPE_REF")));
				accountVO.setMobileNo(resultSet.getString("MOBILE_NO"));
				accountVO.setAccountStatus(resultSet
						.getInt("ACCOUNT_STATUS"));
				accountDetailsList.add(accountVO);
			}
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					AccountDaoImpl.class
							+ ": Error:- Error: Occur in Query While fetching the group details for display in grid from Database",
					sqlException);

		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					AccountDaoImpl.class
							+ ": Error:- While closing the Connection after fetching the group details for display in grid from Database",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return accountDetailsList;
	}

	/**
	 * <p>
	 * <code>retriveAccountInformation()</code>this method is design get account
	 * details form database for display into the view page
	 * </p>
	 * 
	 * @param accountId
	 *            int
	 * @return accountDTO AccountDTO
	 * @throws Exception
	 */
	@Override
	public AccountDTO retriveAccountInformation(int accountId) throws Exception {
		accountDTO = new AccountDTO();
		try {
			connection = getConnection();
			String query = QueryMaker.GET_ACCOUNT_DETAILS;
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, accountId);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				accountDTO.setAccountId(resultSet.getInt("ACCOUNT_ID"));
				System.out.println(resultSet.getInt("ACCOUNT_ID"));
				accountDTO.setAccountName(resultSet.getString("ACCOUNT_NAME"));
				accountDTO.setAccountOwner(AppendHelper.appendSalutaion(
						resultSet.getInt("SALUTATION"),
						resultSet.getString("CONTACT_PERSON")));
				System.out.println(resultSet.getString("CONTACT_PERSON"));
				accountDTO.setAccountType(resultSet
						.getString("ACCOUNT_TYPE_REF"));
				accountDTO.setAccountStatus(resultSet
						.getString("ACCOUNT_STATUS"));
				accountDTO.setOrgnisationCategory(nameHelper
						.getCompanyCategoryName(resultSet
								.getInt("ORGANIZATION_CATEGORY_REF")));
				accountDTO.setOrgnisationSector(nameHelper
						.getCompanySectorName(resultSet
								.getInt("ORGANIZATION_SECTOR_REF")));
				accountDTO.setNoOfAssociates(resultSet
						.getString("NUMBER_OF_ASSOCIATE"));
				accountDTO.setAnnualRevenue(resultSet
						.getString("ANNUAL_REVENUE"));
				accountDTO.setPhoneNo(AppendHelper.appendNumber(
						resultSet.getString("PHONE_ISD"),
						resultSet.getString("PHONE_STD"),
						resultSet.getString("PHONE_NO")));
				accountDTO.setMobileNo(AppendHelper.appendNumber(
						resultSet.getString("MOBILE_ISD"),
						resultSet.getString("MOBILE_NO")));
				accountDTO.setEmailId(resultSet.getString("EMAIL_ID"));
				accountDTO.setEmailOptOut(resultSet.getString("EMAIL_OPT_OUT"));
				accountDTO.setSlaName(resultSet.getString("SLA_NAME"));
				accountDTO.setTrickerSymbol(resultSet
						.getString("TICKER_SYMBOL"));
				accountDTO.setAssignTo(resultSet.getString("ASSIGNED_TO"));
				accountDTO.setParentAccount(resultSet
						.getString("PARENT_ACCOUNT"));
				accountDTO.setNotifyOwner(resultSet.getString("NOTIFY_OWNER"));
				accountDTO.setCreatedDate(DateTimeUtil
						.convertDatetoFormDateForView(resultSet
								.getString("CREATED_DATE")));
				accountDTO.setBillingContactPersone(AppendHelper
						.appendSalutaion(
								resultSet.getInt("BILLING_SALUTATION"),
								resultSet.getString("BILLING_CONTACT_PERSON")));
				accountDTO.setBillingDesignation(nameHelper
						.getDesignationName(resultSet
								.getInt("BILLING_DESIGNATION_REF")));
				accountDTO.setBillingAddressLine1(resultSet
						.getString("BILLING_ADDRESS_LINE_1"));
				accountDTO.setBillingAddressLine2(resultSet
						.getString("BILLING_ADDRESS_LINE_2"));
				accountDTO.setBillingCity(resultSet.getString("BILLING_CITY"));
				accountDTO
						.setBillingState(resultSet.getString("BILLING_STATE"));
				accountDTO
						.setBillingCountry(nameHelper.getCountryName(resultSet
								.getInt("BILLING_COUNTRY_REF")));
				accountDTO.setBillingZipcode(resultSet
						.getString("BILLING_ZIPCODE"));
				accountDTO.setBillingPhoneNo(AppendHelper.appendNumber(
						resultSet.getString("BILLING_PHONE_ISD"),
						resultSet.getString("BILLING_PHONE_STD"),
						resultSet.getString("BILLING_PHONE_NO")));
				accountDTO.setBillingMobileNo(AppendHelper.appendNumber(
						resultSet.getString("BILLING_MOBILE_ISD"),
						resultSet.getString("BILLING_MOBILE_NO")));
				accountDTO.setBillingPrimaryEmail(resultSet
						.getString("BILLING_PRIMARY_EMAIL"));
				accountDTO.setBillingAlternateEmail(resultSet
						.getString("BILLING_ALTERNATE_EMAIL"));
				accountDTO.setBillingFax(AppendHelper.appendNumber(
						resultSet.getString("BILLING_FAX_ISD"),
						resultSet.getString("BILLING_FAX_STD"),
						resultSet.getString("BILLING_FAX_NO")));
				accountDTO.setBillingWebsite(resultSet
						.getString("BILLING_WEBSITE"));
				accountDTO
						.setShippingContactPersone(AppendHelper.appendSalutaion(
								resultSet.getInt("SHIPPING_SALUTATION"),
								resultSet.getString("SHIPPING_CONTACT_PERSON")));
				accountDTO.setShippingDesignation(nameHelper
						.getDesignationName(resultSet
								.getInt("SHIPPING_DESIGNATION_REF")));
				accountDTO.setShippingAddressLine1(resultSet
						.getString("SHIPPING_ADDRESS_LINE_1"));
				accountDTO.setShippingAddressLine2(resultSet
						.getString("SHIPPING_ADDRESS_LINE_2"));
				accountDTO
						.setShippingCity(resultSet.getString("SHIPPING_CITY"));
				accountDTO.setShippingState(resultSet
						.getString("SHIPPING_STATE"));
				accountDTO.setShippingCountry(nameHelper
						.getCountryName(resultSet
								.getInt("SHIPPING_COUNTRY_REF")));
				accountDTO.setShippingZipcode(resultSet
						.getString("SHIPPING_ZIPCODE"));
				accountDTO.setShippingPhoneNo(AppendHelper.appendNumber(
						resultSet.getString("SHIPPING_PHONE_ISD"),
						resultSet.getString("SHIPPING_PHONE_STD"),
						resultSet.getString("SHIPPING_PHONE_NO")));
				accountDTO.setShippingMobileNo(AppendHelper.appendNumber(
						resultSet.getString("SHIPPING_MOBILE_ISD"),
						resultSet.getString("SHIPPING_MOBILE_NO")));
				accountDTO.setShippingPrimaryEmail(resultSet
						.getString("SHIPPING_PRIMARY_EMAIL"));
				accountDTO.setShippingAlternateEmail(resultSet
						.getString("SHIPPING_ALTERNATE_EMAIL"));
				accountDTO.setShippingFax(AppendHelper.appendNumber(
						resultSet.getString("SHIPPING_FAX_ISD"),
						resultSet.getString("SHIPPING_FAX_STD"),
						resultSet.getString("SHIPPING_FAX_NO")));
				accountDTO.setShippingWebsite(resultSet
						.getString("SHIPPING_WEBSITE"));
				accountDTO.setCreatedByName(nameHelper
						.getCustomerName(resultSet.getInt("CREATED_BY")));
				accountDTO.setProfileDescription(resultSet
						.getString("PROFILE_DESCRIPTION"));
			}
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					LeadDaoImpl.class
							+ ": Error:- Error: Occur in Query While fetching the account details for view from Database",
					sqlException);

		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					LeadDaoImpl.class
							+ ": Error:- While closing the Connection after fetching the account details for view from Database",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return accountDTO;
	}

	/**
	 * <p>
	 * <code>retriveAccountDetails()</code>this method is design to get account
	 * details from database for update process into the edit accounts details
	 * page
	 * 
	 * </p>
	 * 
	 * @param accountId
	 *            int
	 * @return accountDTO AccountDTO
	 * @throws Exception
	 */
	@Override
	public AccountDTO retriveAccountDetails(int accountId) throws Exception {

		accountDTO = new AccountDTO();
		try {
			connection = getConnection();
			String query = QueryMaker.GET_ACCOUNT_DETAILS;
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, accountId);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				accountDTO.setAccountId(resultSet.getInt("ACCOUNT_ID"));
				accountDTO.setAccountName(resultSet.getString("ACCOUNT_NAME"));
				accountDTO.setAccountOwner(resultSet
						.getString("CONTACT_PERSON"));
				accountDTO.setSalutation(resultSet.getString("SALUTATION"));
				accountDTO.setAccountType(resultSet
						.getString("ACCOUNT_TYPE_REF"));
				accountDTO.setAccountStatus(resultSet
						.getString("ACCOUNT_STATUS"));
				accountDTO.setOrgnisationCategory(resultSet
						.getString("ORGANIZATION_CATEGORY_REF"));
				accountDTO.setOrgnisationSector(resultSet
						.getString("ORGANIZATION_SECTOR_REF"));
				accountDTO.setNoOfAssociates(resultSet
						.getString("NUMBER_OF_ASSOCIATE"));
				accountDTO.setAnnualRevenue(resultSet
						.getString("ANNUAL_REVENUE"));
				accountDTO.setPhoneNo(resultSet.getString("PHONE_NO"));
				accountDTO.setPhoneIsd(resultSet.getString("PHONE_ISD"));
				accountDTO.setPhoneStd(resultSet.getString("PHONE_STD"));
				accountDTO.setMobileNo(resultSet.getString("MOBILE_NO"));
				accountDTO.setMobileIsd(resultSet.getString("MOBILE_ISD"));
				accountDTO.setEmailId(resultSet.getString("EMAIL_ID"));
				accountDTO.setEmailOptOut(resultSet.getString("EMAIL_OPT_OUT"));
				accountDTO.setSlaName(resultSet.getString("SLA_NAME"));
				accountDTO.setTrickerSymbol(resultSet
						.getString("TICKER_SYMBOL"));
				accountDTO.setAssignTo(resultSet.getString("ASSIGNED_TO"));
				accountDTO.setParentAccount(resultSet
						.getString("PARENT_ACCOUNT"));
				accountDTO.setNotifyOwner(resultSet.getString("NOTIFY_OWNER"));
				accountDTO.setCreatedDate(DateTimeUtil
						.convertDatetoFormDate(resultSet
								.getString("CREATED_DATE")));
				accountDTO.setBillingContactPersone(resultSet
						.getString("BILLING_CONTACT_PERSON"));
				accountDTO.setBillingSalutation(resultSet
						.getString("BILLING_SALUTATION"));
				accountDTO.setBillingDesignation(nameHelper
						.getDesignationName(resultSet
								.getInt("BILLING_DESIGNATION_REF")));
				accountDTO.setBillingAddressLine1(resultSet
						.getString("BILLING_ADDRESS_LINE_1"));
				accountDTO.setBillingAddressLine2(resultSet
						.getString("BILLING_ADDRESS_LINE_2"));
				accountDTO.setBillingCity(resultSet.getString("BILLING_CITY"));
				accountDTO
						.setBillingState(resultSet.getString("BILLING_STATE"));
				accountDTO.setBillingCountry(resultSet
						.getString("BILLING_COUNTRY_REF"));
				accountDTO.setBillingZipcode(resultSet
						.getString("BILLING_ZIPCODE"));
				accountDTO.setBillingPhoneNo(resultSet
						.getString("BILLING_PHONE_NO"));
				accountDTO.setBillingPhoneNoIsd(resultSet
						.getString("BILLING_PHONE_ISD"));
				accountDTO.setBillingPhoneNoStd(resultSet
						.getString("BILLING_PHONE_STD"));
				accountDTO.setBillingMobileNo(resultSet
						.getString("BILLING_MOBILE_NO"));
				accountDTO.setBillingMobileNoIsd(resultSet
						.getString("BILLING_MOBILE_ISD"));
				accountDTO.setBillingPrimaryEmail(resultSet
						.getString("BILLING_PRIMARY_EMAIL"));
				accountDTO.setBillingAlternateEmail(resultSet
						.getString("BILLING_ALTERNATE_EMAIL"));
				accountDTO.setBillingFax(resultSet.getString("BILLING_FAX_NO"));
				accountDTO.setBillingFaxIsd(resultSet
						.getString("BILLING_FAX_ISD"));
				accountDTO.setBillingFaxStd(resultSet
						.getString("BILLING_FAX_STD"));
				accountDTO.setBillingWebsite(resultSet
						.getString("BILLING_WEBSITE"));
				accountDTO.setShippingContactPersone(resultSet
						.getString("SHIPPING_CONTACT_PERSON"));
				accountDTO.setShippingSalutation(resultSet
						.getString("SHIPPING_SALUTATION"));
				accountDTO.setShippingDesignation(resultSet
						.getString("SHIPPING_DESIGNATION_REF"));
				accountDTO.setShippingAddressLine1(resultSet
						.getString("SHIPPING_ADDRESS_LINE_1"));
				accountDTO.setShippingAddressLine2(resultSet
						.getString("SHIPPING_ADDRESS_LINE_2"));
				accountDTO
						.setShippingCity(resultSet.getString("SHIPPING_CITY"));
				accountDTO.setShippingState(resultSet
						.getString("SHIPPING_STATE"));
				accountDTO.setShippingCountry(nameHelper
						.getCountryName(resultSet
								.getInt("SHIPPING_COUNTRY_REF")));
				accountDTO.setShippingZipcode(resultSet
						.getString("SHIPPING_ZIPCODE"));
				accountDTO.setShippingPhoneNo(resultSet
						.getString("SHIPPING_PHONE_NO"));
				accountDTO.setShippingPhoneIsd(resultSet
						.getString("SHIPPING_PHONE_ISD"));
				accountDTO.setShippingPhoneIsd(resultSet
						.getString("SHIPPING_PHONE_STD"));
				accountDTO.setShippingMobileNo(resultSet
						.getString("SHIPPING_MOBILE_NO"));
				accountDTO.setShippingMobileIsd(resultSet
						.getString("SHIPPING_MOBILE_ISD"));
				accountDTO.setShippingPrimaryEmail(resultSet
						.getString("SHIPPING_PRIMARY_EMAIL"));
				accountDTO.setShippingAlternateEmail(resultSet
						.getString("SHIPPING_ALTERNATE_EMAIL"));
				accountDTO.setShippingFax(resultSet
						.getString("SHIPPING_FAX_NO"));
				accountDTO.setShippingFaxIsd(resultSet
						.getString("SHIPPING_FAX_ISD"));
				accountDTO.setShippingFaxIsd(resultSet
						.getString("SHIPPING_FAX_STD"));
				accountDTO.setShippingWebsite(resultSet
						.getString("SHIPPING_WEBSITE"));
				accountDTO.setCreatedByName(nameHelper
						.getCustomerName(resultSet.getInt("CREATED_BY")));
				accountDTO.setProfileDescription(resultSet
						.getString("PROFILE_DESCRIPTION"));
			}
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					LeadDaoImpl.class
							+ ": Error:- Error: Occur in Query While fetching the account details for edit process from Database",
					sqlException);

		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					LeadDaoImpl.class
							+ ": Error:- While closing the Connection after fetching the account details edit process from Database",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return accountDTO;
	}

	/**
	 * <p>
	 * <code>updateAccountInfo()</code>this method is design to update account
	 * details into database
	 * </p>
	 * 
	 * @param accountVO
	 *            AccountVO
	 * @return target int
	 * @throws Exception
	 */
	@Override
	public int updateAccountInfo(AccountVO accountVO) throws Exception {

		int target = 0;
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.UPDATE_ACCOUNT_DETAILS);
			preparedStatement.setString(1, accountVO.getSalutation());
			preparedStatement.setString(2, accountVO.getAccountOwner());
			preparedStatement.setString(3, accountVO.getAccountName());
			preparedStatement.setString(4, accountVO.getAccountType());
			preparedStatement.setString(5, accountVO.getOwnershipType());
			preparedStatement.setString(6, accountVO.getOrgnisationCategory());
			preparedStatement.setString(7, accountVO.getOrgnisationSector());

			if (accountVO.getNoOfAssociates() != null
					|| accountVO.getNoOfAssociates() != "") {
				preparedStatement.setInt(8, 0);
			} else {
				preparedStatement.setString(8, accountVO.getNoOfAssociates());
			}

			if (accountVO.getAnnualRevenue() != null
					|| accountVO.getAnnualRevenue() != "") {
				preparedStatement.setString(9, "0.00");
			} else {
				preparedStatement.setString(9, accountVO.getAnnualRevenue());
			}
			preparedStatement.setString(10, accountVO.getPhoneNo());
			preparedStatement.setString(11, accountVO.getPhoneIsd());
			preparedStatement.setString(12, accountVO.getPhoneStd());
			preparedStatement.setString(13, accountVO.getMobileNo());
			preparedStatement.setString(14, accountVO.getMobileIsd());
			preparedStatement.setString(15, accountVO.getEmailId());
			preparedStatement.setString(16, accountVO.getParentAccount());
			preparedStatement.setString(17, accountVO.getTrickerSymbol());
			preparedStatement.setString(18, accountVO.getAssignTo());
			preparedStatement.setString(19, accountVO.getRatings());
			preparedStatement.setString(20, accountVO.getNotifyOwner());
			preparedStatement.setString(21, accountVO.getEmailOptOut());
			preparedStatement.setString(22, accountVO.getSlaName());
			preparedStatement.setString(23, accountVO.getBillingSalutation());
			preparedStatement.setString(24,
					accountVO.getBillingContactPersone());
			preparedStatement.setString(25, accountVO.getBillingDesignation());
			preparedStatement.setString(26, accountVO.getBillingAddressLine1());
			preparedStatement.setString(27, accountVO.getBillingAddressLine2());
			preparedStatement.setString(28, accountVO.getBillingCity());
			preparedStatement.setString(29, accountVO.getBillingState());
			preparedStatement.setString(30, accountVO.getBillingCountry());
			preparedStatement.setString(31, accountVO.getBillingZipcode());
			preparedStatement.setString(32, accountVO.getBillingPhoneNo());
			preparedStatement.setString(33, accountVO.getBillingPhoneNoIsd());
			preparedStatement.setString(34, accountVO.getBillingPhoneNoStd());
			preparedStatement.setString(35, accountVO.getBillingMobileNo());
			preparedStatement.setString(36, accountVO.getBillingMobileNoIsd());
			preparedStatement.setString(37, accountVO.getBillingPrimaryEmail());
			preparedStatement.setString(38,
					accountVO.getBillingAlternateEmail());
			preparedStatement.setString(39, accountVO.getBillingFax());
			preparedStatement.setString(40, accountVO.getBillingFaxIsd());
			preparedStatement.setString(41, accountVO.getBillingFaxStd());
			preparedStatement.setString(42, accountVO.getBillingWebsite());
			preparedStatement.setString(43, accountVO.getShippingSalutation());
			preparedStatement.setString(44,
					accountVO.getShippingContactPersone());
			preparedStatement.setString(45, accountVO.getShippingDesignation());
			preparedStatement
					.setString(46, accountVO.getShippingAddressLine1());
			preparedStatement
					.setString(47, accountVO.getShippingAddressLine2());
			preparedStatement.setString(48, accountVO.getShippingCity());
			preparedStatement.setString(49, accountVO.getShippingState());
			preparedStatement.setString(50, accountVO.getShippingCountry());
			preparedStatement.setString(51, accountVO.getShippingZipcode());
			preparedStatement.setString(52, accountVO.getShippingPhoneNo());
			preparedStatement.setString(53, accountVO.getShippingPhoneIsd());
			preparedStatement.setString(54, accountVO.getShippingPhoneStd());
			preparedStatement.setString(55, accountVO.getShippingMobileNo());
			preparedStatement.setString(56, accountVO.getShippingMobileIsd());
			preparedStatement
					.setString(57, accountVO.getShippingPrimaryEmail());
			preparedStatement.setString(58,
					accountVO.getShippingAlternateEmail());
			preparedStatement.setString(59, accountVO.getShippingFax());
			preparedStatement.setString(60, accountVO.getShippingFaxIsd());
			preparedStatement.setString(61, accountVO.getShippingFaxStd());
			preparedStatement.setString(62, accountVO.getShippingWebsite());
			preparedStatement.setString(63, accountVO.getProfileDescription());
			preparedStatement.setString(64, DateTimeUtil.getDateAndTime());
			preparedStatement.setInt(65, accountVO.getUpdatedBy());
			preparedStatement.setInt(66, accountVO.getAccountId());

			preparedStatement.executeUpdate();

			target = 1;
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					AccountDaoImpl.class
							+ "Error: Occur in Query While Inserting the Account Details into Database.",
					sqlException);

		} catch (Exception exception) {

			exception.printStackTrace();
			logger.error(
					AccountDaoImpl.class
							+ "Error: Occur in Query While Closing Connection After Inserting the Account Details into Database.",
					exception);
		} finally {
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return target;
	}

	/**
	 * <p>
	 * <code>insertLeadSocialInformation()</code> method use to insert lead
	 * social information details into TAB_SOCIAL_CONTACT table.
	 * </p>
	 * 
	 * @param leadVO
	 * @throws Exception
	 * @return target
	 */
	@Override
	public int insertSocialInformation(AccountVO accountVO) throws Exception {

		int target = 0;
		connection = getConnection();
		try {
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_SOCIAL_INFO);
			preparedStatement.setInt(1, accountVO.getSocialSiteRef());
			preparedStatement.setInt(2, Modules.ACCOUNT_ID);
			preparedStatement.setInt(3, accountVO.getAccountId());
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				accountVO.setSocialContactId(resultSet
						.getInt("SOCIAL_CONTACT_ID"));
				preparedStatement = connection
						.prepareStatement(QueryMaker.UPDATE_SOCIAL_INFORMATION);
				preparedStatement.setInt(1, accountVO.getSocialSiteRef());
				preparedStatement.setString(2,
						accountVO.getSocialContactValue());
				preparedStatement.setInt(3, Modules.ACCOUNT_ID);
				preparedStatement.setInt(4, accountVO.getAccountId());
				preparedStatement.setInt(5, accountVO.getSocialContactId());
				preparedStatement.executeUpdate();
				target = 2;

			} else {
				preparedStatement = connection
						.prepareStatement(QueryMaker.INSERT_SOCIAL_INFORMATION);
				preparedStatement.setInt(1, accountVO.getSocialSiteRef());
				preparedStatement.setString(2,
						accountVO.getSocialContactValue());
				preparedStatement.setInt(3, Modules.ACCOUNT_ID);
				preparedStatement.setInt(4, accountVO.getAccountId());
				preparedStatement.executeUpdate();
				target = 1;

			}

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					LeadDaoImpl.class
							+ ": Error:- Error: Occur in Query While inserting the account social details into Database",
					sqlException);

		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					LeadDaoImpl.class
							+ ": Error:- While closing the Connection after inserting the account social details into Database",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return target;
	}

	/**
	 * <p>
	 * <code>getAccountSocialInformationList()</code> method use to fetch lead
	 * social details from TAB_SOCIAL_CONTACT table.
	 * </p>
	 * 
	 * @return leadIdList
	 */
	@Override
	public List<AccountVO> getAccountSocialInformationList(int acccountId)
			throws Exception {
		ArrayList<AccountVO> socialDetails = new ArrayList<AccountVO>();
		try {

			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_LEAD_SOCIAL_DETAILS);
			preparedStatement.setInt(1, Modules.ACCOUNT_ID);
			preparedStatement.setInt(2, acccountId);
			// SOCIAL_SITE_REF,SOCIAL_CONTACT_VALUE
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				accountVO = new AccountVO();
				accountVO.setSocialSiteRefName(nameHelper
						.getSocialSite(resultSet.getInt("SOCIAL_SITE_REF")));
				accountVO.setSocialContactValue(resultSet
						.getString("SOCIAL_CONTACT_VALUE"));
				socialDetails.add(accountVO);
			}

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					LeadDaoImpl.class
							+ ": Error:- Error: Occur in Query While fetching account social details from Database",
					sqlException);

		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					LeadDaoImpl.class
							+ ": Error:- While closing the Connection after fetching the account social details from Database",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return socialDetails;
	}

	@Override
	public int getAccountLastRecord() throws Exception {
		
		int temp = 0;
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_ACCOUNT_LAST_RECORD_ID);
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {

					temp = resultSet.getInt("ACCOUNT_ID");

				}
			}
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					LeadDaoImpl.class
							+ ": Error:- Error: Occur in Query While counting the Lead recodes from Database",
					sqlException);

		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					LeadDaoImpl.class
							+ ": Error:- While closing the Connection after counting the Lead recodes from Database",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return temp;
	
	}

}