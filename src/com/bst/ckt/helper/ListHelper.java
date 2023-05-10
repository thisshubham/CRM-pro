/*
 **********************************************************************
 *

 * COPYRIGHT. $ID$ 2014. ALL RIGHTS RESERVED.
 *
 * This software is only to be used for the purpose for which it has been
 * provided. No part of it is to be reproduced, disassembled, transmitted,
 * stored in a retrieval system nor translated in any human or computer
 * language in any way or for any other purposes whatsoever without the
 * prior written consent of $ID$.
 * 
 * Class Name     ListHelper.java     
 *                                                            
 * Creation Date  OCT 4, 2014 
 * 
 * Abstract       This is List helper class to retrieve data from database 
 *                and returns lists.
 *  
 * Amendment History (in chronological sequence): OCT 4, 2014
 * 
 **********************************************************************
 */

package com.bst.ckt.helper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.bst.ckt.common.QueryMaker;
import com.bst.ckt.exception.OMIApplicationException;
import com.bst.ckt.exception.RecordNotFoundException;
import com.bst.ckt.framework.db.JdbcDAOSupport;
import com.bst.ckt.framework.db.JdbcHelper;

/**
 * <p>
 * <code>ListHelper</code> Class is designed to get the list of below.
 * <ul>
 * <li>Country List, Which holds the countryId along with its country Display
 * Name.</li>
 * <li>Social Site List, Which holds the Social Site Id along with its Social
 * Site Name.</li>
 * <li>Lead Title List, Which holds the Lead Title Id along with its Lead Title
 * Name.</li>
 * <li>Company Type List, Which holds the Company Type Id along with its Company
 * Type Name.</li>
 * <li>Company Category List, Which holds the Company Category Id along with its
 * Company Category Name.</li>
 * <li>Company Sector List, Which holds the Company Sector Id along with its
 * Company Sector Name.</li>
 * <li>Currency List, Which holds the Currency Id along with its Currency Name.</li>
 * </ul>
 * </p>
 * 
 * @author Yogendra Singh Rajput
 * @version V1.0, 20 August 2015
 * @since 1.0
 */
public class ListHelper extends JdbcDAOSupport {
	/**
	 * Creating Logger object, logger object mapped with ListHelper class for
	 * writing Loggers.
	 */
	private static final Logger log = Logger.getLogger(ListHelper.class);
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	NameHelper nameHelper= new NameHelper();

	/**
	 * <p>
	 * <code>countryList()</code> method use to fetch country display name and
	 * country ID from TAB_COUNTRY table and return the
	 * 
	 * <pre>
	 * HashMap<Integer, String>
	 * </pre>
	 * 
	 * of country id and display name.
	 * </p>
	 * 
	 * @return HashMap<Integer, String> map of county list with id and display
	 *         name.
	 * @throws Exception
	 */
	public HashMap<Integer, String> countryList() throws Exception {

		HashMap<Integer, String> countryListMap = new HashMap<Integer, String>();

		try {

			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_COUNTRY_LIST);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				countryListMap.put(resultSet.getInt("COUNTRY_ID"),
						resultSet.getString("COUNTRY_DISPLAY_NAME"));
			}
		} catch (SQLException sqlException) {

			log.error(
					ListHelper.class
							+ ": Error:- While preparing statement to get country data from database.",
					sqlException);
		} catch (Exception exception) {

			log.error(ListHelper.class
					+ ": Error:- While getting connection for database.",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return countryListMap;
	}

	/**
	 * LeadTitleList method use to fetch Lead Subject and Lead Title ID from
	 * TAB_LEAD_TITLE table.
	 * 
	 * @return HashMap<Integer, String>
	 * @throws Exception
	 */
	public HashMap<Integer, String> leadTitleList() throws Exception {

		HashMap<Integer, String> leadTitleListMap = new HashMap<Integer, String>();
		try {

			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_LEAD_TITLE_LIST);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				leadTitleListMap.put(resultSet.getInt("LEAD_TITLE_ID"),
						resultSet.getString("LEAD_TITLE_SUBJECT"));

			}
		} catch (SQLException sqlException) {

			log.error(
					ListHelper.class
							+ ": Error:- While preparing statement to get lead title data from database.",
					sqlException);
		} catch (Exception exception) {

			log.error(ListHelper.class
					+ ": Error:- While getting list of Lead id and Lead Subject name From Database.");
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return leadTitleListMap;
	}

	/**
	 * companyTypeList method use to fetch Company Type and Company Type ID from
	 * TAB_COMPANY_TYPE table.
	 * 
	 * @return HashMap<Integer, String>
	 * @throws Exception
	 */
	public HashMap<Integer, String> companyTypeList() throws Exception {

		HashMap<Integer, String> companyTypeListMap = new HashMap<Integer, String>();
		try {

			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_COMPANY_TYPE_LIST);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				companyTypeListMap.put(resultSet.getInt("COMPANY_TYPE_ID"),
						resultSet.getString("COMPANY_TYPE_NAME"));
			}
		} catch (SQLException sqlException) {

			log.error(
					ListHelper.class
							+ ": Error:- While preparing statement to get comapny type data from database.",
					sqlException);
		} catch (Exception exception) {

			log.error(ListHelper.class
					+ ": Error:- While getting list of Company Type id and Company Type From Database.");
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return companyTypeListMap;
	}

	/**
	 * companyCategoryList method use to fetch Company Category and Company
	 * Category ID from TAB_COMPANY_CATEGORY table.
	 * 
	 * @return HashMap<Integer, String>
	 * @throws Exception
	 */
	public HashMap<Integer, String> companyCategoryList() throws Exception {

		HashMap<Integer, String> companyCategoryListMap = new HashMap<Integer, String>();
		try {

			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_COMPANY_CATEGORY_LIST);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				companyCategoryListMap.put(
						resultSet.getInt("COMPANY_CATEGORY_ID"),
						resultSet.getString("COMPANY_CATEGORY_NAME"));
			}
		} catch (SQLException sqlException) {

			log.error(
					ListHelper.class
							+ ": Error:- While preparing statement to get company category data from database.",
					sqlException);
		} catch (Exception exception) {

			log.error(ListHelper.class
					+ ": Error:- While getting list of Company Category id and Company Category From Database.");
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return companyCategoryListMap;
	}

	/**
	 * companySectorList method use to fetch Company Sector and Company Sector
	 * ID from TAB_COMPANY_SECTOR table.
	 * 
	 * @return HashMap<Integer, String>
	 * @throws Exception
	 */
	public HashMap<Integer, String> companySectorList() throws Exception {

		HashMap<Integer, String> companySectorListMap = new HashMap<Integer, String>();
		try {

			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_COMPANY_SECTOR_LIST);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				companySectorListMap.put(resultSet.getInt("COMPANY_SECTOR_ID"),
						resultSet.getString("COMPANY_SECTOR_NAME"));
			}
		} catch (SQLException sqlException) {

			log.error(
					ListHelper.class
							+ ": Error:- While preparing statement to get company sector data from database.",
					sqlException);
		} catch (Exception exception) {

			log.error(ListHelper.class
					+ ": Error:- While getting list of Company Sector id and Company Sector From Database.");
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return companySectorListMap;
	}

	/**
	 * <p>
	 * <code>currencyList()</code> method use to fetch currency display name and
	 * currency ID from TAB_CURRENCY table and return the
	 * 
	 * <pre>
	 * HashMap<Integer, String>
	 * </pre>
	 * 
	 * of currency id and display name.
	 * </p>
	 * 
	 * @return HashMap<Integer, String> map of currency list with id and display
	 *         name.
	 * @throws Exception
	 */
	public HashMap<Integer, String> currencyList() throws Exception {

		HashMap<Integer, String> currencyListMap = new HashMap<Integer, String>();

		try {

			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_CURRENCY_LIST);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				currencyListMap.put(resultSet.getInt("CURRENCY_ID"),
						resultSet.getString("CURRENCY_DISPLAY_NAME"));
			}
		} catch (SQLException sqlException) {

			log.error(
					ListHelper.class
							+ ": Error:- While preparing statement to get currency data from database.",
					sqlException);
		} catch (Exception exception) {

			log.error(ListHelper.class
					+ ": Error:- While getting connection for database.",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return currencyListMap;
	}

	/**
	 * <p>
	 * <code>leadSourceList()</code> method use to fetch Lead source name and
	 * Lead source ID from TAB_LEAD_SOURCE table and return the
	 * 
	 * <pre>
	 * HashMap<Integer, String>
	 * </pre>
	 * 
	 * of Lead source ID and name.
	 * </p>
	 * 
	 * @return HashMap<Integer, String> map of lead Source List with id and
	 *         name.
	 * @throws Exception
	 */
	public HashMap<Integer, String> leadSourceList() throws Exception {

		HashMap<Integer, String> leadSourceListMap = new HashMap<Integer, String>();

		try {

			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_LEAD_SOURCE_LIST);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				leadSourceListMap.put(resultSet.getInt("LEAD_SOURCE_ID"),
						resultSet.getString("LEAD_SOURCE_NAME"));
			}
		} catch (SQLException sqlException) {

			log.error(
					ListHelper.class
							+ ": Error:- While preparing statement to get Lead source data from database.",
					sqlException);
		} catch (Exception exception) {

			log.error(ListHelper.class
					+ ": Error:- While getting connection for database.",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return leadSourceListMap;
	}

	/**
	 * <p>
	 * <code>customerNameList()</code> method use to fetch full name and
	 * customer id from TAB_CUSTOMER_USER table and return the
	 * 
	 * <pre>
	 * HashMap<Integer, String>
	 * </pre>
	 * 
	 * of customer id and full name.
	 * </p>
	 * 
	 * @return HashMap<Integer, String> map of customer name list with customer
	 *         id and full name.
	 * @throws Exception
	 */

	public HashMap<Integer, String> customerNameList() throws Exception {

		HashMap<Integer, String> customerNameListMap = new HashMap<Integer, String>();

		try {

			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_CUSTOMER_NAME_LIST);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				customerNameListMap.put(resultSet.getInt("CUSTOMER_ID"),
						resultSet.getString("FULL_NAME"));
			}
		} catch (SQLException sqlException) {

			log.error(
					ListHelper.class
							+ ": Error:- While preparing statement to get customer Name data from database.",
					sqlException);
		} catch (Exception exception) {

			log.error(ListHelper.class
					+ ": Error:- While getting connection for database.",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return customerNameListMap;
	}

	/**
	 * <p>
	 * <code>groupCategoryList()</code> method use to fetch group category name
	 * and group category id from TAB_GROUP_CATEGORY table and return the
	 * 
	 * <pre>
	 * HashMap<Integer, String>
	 * </pre>
	 * 
	 * of group id and group category name.
	 * </p>
	 * 
	 * @return HashMap<Integer, String> map of customer name list with customer
	 *         id and full name.
	 * @throws Exception
	 */

	public HashMap<Integer, String> groupCategoryList() throws Exception {

		HashMap<Integer, String> groupCategoryListMap = new HashMap<Integer, String>();

		try {

			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_GROUP_CATEGORY_NAME_LIST);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				groupCategoryListMap.put(resultSet.getInt("GROUP_CATEGORY_ID"),
						resultSet.getString("GROUP_CATEGORY_NAME"));
			}
		} catch (SQLException sqlException) {

			log.error(
					ListHelper.class
							+ ": Error:- While preparing statement to get Group Category Name data from database.",
					sqlException);
		} catch (Exception exception) {

			log.error(ListHelper.class
					+ ": Error:- While getting connection for database.",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return groupCategoryListMap;
	}

	/**
	 * <p>
	 * <code>designationList()</code> method use to fetch designation display
	 * name and designation id from TAB_DESIGNATION table and return the
	 * 
	 * <pre>
	 * HashMap<Integer, String>
	 * </pre>
	 * 
	 * of designation id and designation display name.
	 * </p>
	 * 
	 * @return HashMap<Integer, String> map of designation display name list
	 *         with designation id and designation display name.
	 * @throws Exception
	 */

	public HashMap<Integer, String> designationList() throws Exception {

		HashMap<Integer, String> designationListMap = new HashMap<Integer, String>();

		try {

			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_DESIGNATION_DISPLAY_NAME_LIST);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				designationListMap.put(resultSet.getInt("DESIGNATION_ID"),
						resultSet.getString("DESIGNATION_DISPLAY_NAME"));
			}
		} catch (SQLException sqlException) {

			log.error(
					ListHelper.class
							+ ": Error:- While preparing statement to get Designation Display Name data from database.",
					sqlException);
		} catch (Exception exception) {

			log.error(ListHelper.class
					+ ": Error:- While getting connection for database.",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return designationListMap;
	}

	/**
	 * <p>
	 * <code>socialSiteValueList()</code> method use to fetch social site value
	 * and social sit id from TAB_SOCIAL_SITE table and return the
	 * 
	 * <pre>
	 * HashMap<Integer, String>
	 * </pre>
	 * 
	 * of social sit id and social site value.
	 * </p>
	 * 
	 * @return HashMap<Integer, String> map of social site value list with
	 *         social sit id and social site value.
	 * @throws Exception
	 */

	public HashMap<Integer, String> socialSiteValueList() throws Exception {

		HashMap<Integer, String> socialSiteValueListMap = new HashMap<Integer, String>();

		try {

			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_SOCIAL_SITE_VALUE_LIST);
			resultSet = preparedStatement.executeQuery();

			// SOCIAL_SITE_ID,SOCIAL_SITE_VALUE

			while (resultSet.next()) {
				socialSiteValueListMap.put(resultSet.getInt("SOCIAL_SITE_ID"),
						resultSet.getString("SOCIAL_SITE_VALUE"));
			}
		} catch (SQLException sqlException) {

			log.error(
					ListHelper.class
							+ ": Error:- While preparing statement to get Social Site Value data from database.",
					sqlException);
		} catch (Exception exception) {

			log.error(ListHelper.class
					+ ": Error:- While getting connection for database.",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return socialSiteValueListMap;
	}

	/**
	 * <p>
	 * <code>timeZoneList()</code> method use to fetch country display name and
	 * timeZone ID from TAB_TIMEZONE table and return the
	 * 
	 * <pre>
	 * HashMap<Integer, String>
	 * </pre>
	 * 
	 * of country id and display name.
	 * </p>
	 * 
	 * @return HashMap<Integer, String> map of county list with id and display
	 *         name.
	 * @throws Exception
	 */
	public HashMap<Integer, String> timeZoneList() throws Exception {

		HashMap<Integer, String> timeZoneListMap = new HashMap<Integer, String>();

		try {

			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_TIMEZONE_LIST);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				timeZoneListMap.put(resultSet.getInt("TIMEZONE_ID"),
						resultSet.getString("TIMEZONE_ABBREVATION"));
			}
		} catch (SQLException sqlException) {

			log.error(
					ListHelper.class
							+ ": Error:- While preparing statement to get timeZone data from database.",
					sqlException);
		} catch (Exception exception) {

			log.error(ListHelper.class
					+ ": Error:- While getting connection for database.",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return timeZoneListMap;
	}

	/**
	 * <p>
	 * <code>languageList()</code> method use to fetch language display name and
	 * language ID from TAB_LANGUAGE table and return the
	 * 
	 * <pre>
	 * HashMap<Integer, String>
	 * </pre>
	 * 
	 * of language id and display name.
	 * </p>
	 * 
	 * @return HashMap<Integer, String> map of language list with id and display
	 *         name.
	 * @throws Exception
	 */
	public HashMap<Integer, String> languageList() throws Exception {

		HashMap<Integer, String> languageListMap = new HashMap<Integer, String>();

		try {

			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_LANGUAGE_LIST);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				languageListMap.put(resultSet.getInt("LANGUAGE_ID"),
						resultSet.getString("LANGUAGE_DISPLAY_NAME"));
			}
		} catch (SQLException sqlException) {

			log.error(
					ListHelper.class
							+ ": Error:- While preparing statement to get language data from database.",
					sqlException);
		} catch (Exception exception) {

			log.error(ListHelper.class
					+ ": Error:- While getting connection for database.",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return languageListMap;
	}

	/**
	 * <p>
	 * <code>departmentList()</code> method use to fetch Department display name
	 * and department ID from TAB_DEPARTMENT table and return the
	 * 
	 * <pre>
	 * HashMap<Integer, String>
	 * </pre>
	 * 
	 * of Department id and display name.
	 * </p>
	 * 
	 * @return HashMap<Integer, String> map of Department list with id and
	 *         display name.
	 * @throws Exception
	 */
	public HashMap<Integer, String> departmentList() throws Exception {

		HashMap<Integer, String> departmentListMap = new HashMap<Integer, String>();

		try {

			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_DEPARTMENT_LIST);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				departmentListMap.put(resultSet.getInt("DEPARTMENT_ID"),
						resultSet.getString("DEPARTMENT_DISPLAY_NAME"));
			}
		} catch (SQLException sqlException) {

			log.error(
					ListHelper.class
							+ ": Error:- While preparing statement to get department data from database.",
					sqlException);
		} catch (Exception exception) {

			log.error(ListHelper.class
					+ ": Error:- While getting connection for database.",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return departmentListMap;
	}

	/**
	 * <p>
	 * <code>taskAreaList()</code> method use to fetch task area and task area
	 * id from TAB_TASK_AREA table and return the
	 * 
	 * <pre>
	 * HashMap<Integer, String>
	 * </pre>
	 * 
	 * of task area id and task area.
	 * </p>
	 * 
	 * @return HashMap<Integer, String> map of task area list with task area id
	 *         and task area.
	 * @throws Exception
	 */
	public HashMap<Integer, String> taskAreaList() throws Exception {

		HashMap<Integer, String> taskAreaListMap = new HashMap<Integer, String>();

		try {

			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_TASK_AREA_LIST);
			resultSet = preparedStatement.executeQuery();

			// TASK_AREA_ID,TASK_AREA

			while (resultSet.next()) {
				taskAreaListMap.put(resultSet.getInt("TASK_AREA_ID"),
						resultSet.getString("TASK_AREA"));
			}
		} catch (SQLException sqlException) {

			log.error(
					ListHelper.class
							+ ": Error:- While preparing statement to get Task Area data from database.",
					sqlException);
		} catch (Exception exception) {

			log.error(ListHelper.class
					+ ": Error:- While getting connection for database.",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return taskAreaListMap;
	}

	/**
	 * <p>
	 * <code>taskSubjectList()</code> method use to fetch task area and task
	 * area id from TAB_TASK_AREA table and return the
	 * 
	 * <pre>
	 * HashMap<Integer, String>
	 * </pre>
	 * 
	 * of task area id and task area.
	 * </p>
	 * 
	 * @return HashMap<Integer, String> map of task area list with task area id
	 *         and task area.
	 * @throws Exception
	 */
	public HashMap<Integer, String> taskSubjectList() throws Exception {

		HashMap<Integer, String> taskSubjectListMap = new HashMap<Integer, String>();

		try {

			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_TASK_SUBJECT_LIST);
			resultSet = preparedStatement.executeQuery();

			// TASK_ID,TASK_SUBJECT

			while (resultSet.next()) {
				taskSubjectListMap.put(resultSet.getInt("TASK_SUBJECT_ID"),
						resultSet.getString("TASK_SUBJECT"));
			}
		} catch (SQLException sqlException) {

			log.error(
					ListHelper.class
							+ ": Error:- While preparing statement to get Task Subject data from database.",
					sqlException);
		} catch (Exception exception) {

			log.error(ListHelper.class
					+ ": Error:- While getting connection for database.",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return taskSubjectListMap;
	}

	/**
	 * groupNameList method use to fetch Group Name and Group ID from
	 * TAB_GROUP_ACCOUNT table.
	 * 
	 * @return HashMap<Integer, String>
	 * @throws Exception
	 */
	/*
	 * public HashMap<Integer, String> groupNameList() throws Exception {
	 * 
	 * HashMap<Integer, String> groupNameListmap = new HashMap<Integer,
	 * String>(); try {
	 * 
	 * connection = getConnection(); preparedStatement = connection
	 * .prepareStatement(QueryMaker.GET_GROUP_NAME_LIST); resultSet =
	 * preparedStatement.executeQuery();
	 * 
	 * while (resultSet.next()) {
	 * groupNameListmap.put(resultSet.getInt("GROUP_ID"),
	 * resultSet.getString("GROUP_NAME")); } } catch (SQLException sqlException)
	 * {
	 * 
	 * log.error( ListHelper.class +
	 * ": Error:- While preparing statement to get company category data from database."
	 * , sqlException); } catch (Exception exception) {
	 * 
	 * log.error(ListHelper.class +
	 * ": Error:- While getting list of  Group  ID and Group Name From Database."
	 * ); } finally { JdbcHelper.closeResultSet(resultSet);
	 * JdbcHelper.closePreparedStatement(preparedStatement);
	 * JdbcHelper.closeConnection(connection); } return groupNameListmap; }
	 */

	/**
	 * <p>
	 * <code>securityQuestionList()</code> method use to fetch Security Question
	 * and id from TAB_SECURITY_QUESTION_LIST table and return the
	 * 
	 * <pre>
	 * HashMap<Integer, String>
	 * </pre>
	 * 
	 * of question id and security question.
	 * </p>
	 * 
	 * @return HashMap<Integer, String> map of security question.
	 * @throws Exception
	 */
	public HashMap<Integer, String> securityQuestionList() throws Exception {
		HashMap<Integer, String> securityQuestionListMap = new HashMap<Integer, String>();
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_SECURITY_QUESTION_LIST);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				securityQuestionListMap.put(resultSet.getInt("SEQ_QUE_ID"),
						resultSet.getString("SEQ_QUESTION"));
			}

		} catch (SQLException sqlException) {

		} catch (Exception exception) {

		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return securityQuestionListMap;
	}

	/**
	 * productList() method use to fetch PRODUCT ID and PRODUCT NAME from
	 * TAB_PRODUCT table.
	 * 
	 * @return HashMap<Integer, String>
	 * @throws Exception
	 */
	public HashMap<Integer, String> productList() throws Exception {

		HashMap<Integer, String> productListMap = new HashMap<Integer, String>();
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_PRODUCT_NAME_LIST);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				productListMap.put(resultSet.getInt("PRODUCT_ID"),
						nameHelper.getProductTypeNameByProductId(resultSet.getInt("PRODUCT_NAME")));
			}
		} catch (SQLException sqlException) {

			log.error(
					ListHelper.class
							+ ": Error:- While preparing statement to get CAMPAIGN from database.",
					sqlException);
		} catch (Exception exception) {

			log.error(ListHelper.class
					+ ": Error:- While getting list of  PRODUCT ID and PRODUCT NAME From Database.");
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return productListMap;
	}

	/**
	 * campaignTypeList() method use to fetch CAMPAIGN_TYPE_ID and
	 * CAMPAIGN_TYPE_NAME from TAB_CAMPAIGN_TYPE table.
	 * 
	 * @return HashMap<Integer, String>
	 * @throws Exception
	 */
	public HashMap<Integer, String> campaignTypeList() throws Exception {

		HashMap<Integer, String> campaignTypeListMap = new HashMap<Integer, String>();
		try {

			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_CAMPAIGN_TYPE_NAME_LIST);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				campaignTypeListMap.put(resultSet.getInt("CAMPAIGN_TYPE_ID"),
						resultSet.getString("CAMPAIGN_TYPE_NAME"));
			}
		} catch (SQLException sqlException) {

			log.error(
					ListHelper.class
							+ ": Error:- While preparing statement to get CAMPAIGN TYPE from database.",
					sqlException);
		} catch (Exception exception) {

			log.error(ListHelper.class
					+ ": Error:- While getting list of  CAMPAIGN_TYPE_ID and CAMPAIGN_TYPE_NAME From Database.");
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return campaignTypeListMap;
	}

	/**
	 * campaignOwnerList() method use to fetch CUSTOMER_ID and FULL_NAME from
	 * TAB_CUSTOMER_USER table.
	 * 
	 * @return HashMap<Integer, String>
	 * @throws Exception
	 */
	public HashMap<Integer, String> campaignOwnerList() throws Exception {

		HashMap<Integer, String> campaignOwnerListMap = new HashMap<Integer, String>();
		try {

			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_CAMPAIGN_OWNER_NAME_LIST);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				campaignOwnerListMap.put(resultSet.getInt("CUSTOMER_ID"),
						resultSet.getString("FULL_NAME"));
			}
		} catch (SQLException sqlException) {

			log.error(
					ListHelper.class
							+ ": Error:- While preparing statement to get CAMPAIGN Owner from database.",
					sqlException);
		} catch (Exception exception) {

			log.error(ListHelper.class
					+ ": Error:- While getting list of  CUSTOMER_ID and FULL_NAME From Database.");
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return campaignOwnerListMap;
	}

	/**
	 * campaignAssignedToListMap() method use to fetch CUSTOMER_ID and FULL_NAME
	 * from TAB_CUSTOMER_USER table.
	 * 
	 * @return HashMap<Integer, String>
	 * @throws Exception
	 */
	public HashMap<Integer, String> campaignAssignedToList() throws Exception {

		HashMap<Integer, String> campaignAssignedToListMap = new HashMap<Integer, String>();
		try {

			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_CAMPAIGN_ASSIGNED_TO_NAME_LIST);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				campaignAssignedToListMap.put(resultSet.getInt("CUSTOMER_ID"),
						resultSet.getString("FULL_NAME"));
			}
		} catch (SQLException sqlException) {

			log.error(
					ListHelper.class
							+ ": Error:- While preparing statement to get CAMPAIGN Owner from database.",
					sqlException);
		} catch (Exception exception) {

			log.error(ListHelper.class
					+ ": Error:- While getting list of  CUSTOMER_ID and FULL_NAME From Database.");
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return campaignAssignedToListMap;
	}

	/**
	 * vendorsCategoryList() method use to fetch VENDOR_CATEGORY_ID and
	 * VENDOR_CATEGORY_NAME from TAB_VENDOR_CATEGORY table.
	 * 
	 * @return HashMap<Integer, String>
	 * @throws Exception
	 */
	public HashMap<Integer, String> vendorsCategoryList() throws Exception {

		HashMap<Integer, String> vendorsCategoryListMap = new HashMap<Integer, String>();
		try {

			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_VENDORS_CATEGORY_NAME_LIST);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				vendorsCategoryListMap.put(
						resultSet.getInt("VENDOR_CATEGORY_ID"),
						resultSet.getString("VENDOR_CATEGORY_NAME"));
			}
		} catch (SQLException sqlException) {

			log.error(
					ListHelper.class
							+ ": Error:- While preparing statement to get VENDOR CATEGORY from database.",
					sqlException);
		} catch (Exception exception) {

			log.error(ListHelper.class
					+ ": Error:- While getting list of  VENDOR_CATEGORY_ID and VENDOR_CATEGORY_NAME From Database.");
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return vendorsCategoryListMap;
	}

	/**
	 * vendorsAssignedToList() method use to fetch CUSTOMER_ID and FULL_NAME
	 * from TAB_CUSTOMER_USER table.
	 * 
	 * @return HashMap<Integer, String>
	 * @throws Exception
	 */
	public HashMap<Integer, String> vendorsAssignedToList() throws Exception {

		HashMap<Integer, String> vendorsAssignedToListMap = new HashMap<Integer, String>();
		try {

			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_VENDORS_ASSIGNED_TO_NAME_LIST);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				vendorsAssignedToListMap.put(resultSet.getInt("CUSTOMER_ID"),
						resultSet.getString("FULL_NAME"));
			}
		} catch (SQLException sqlException) {

			log.error(
					ListHelper.class
							+ ": Error:- While preparing statement to get CAMPAIGN Owner from database.",
					sqlException);
		} catch (Exception exception) {

			log.error(ListHelper.class
					+ ": Error:- While getting list of  CUSTOMER_ID and FULL_NAME From Database.");
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return vendorsAssignedToListMap;
	}

	

	/**
	 * <p>
	 * <code>getContactPersonNameListOfLead</code> method use to fetch contact
	 * person name from <code>TAB_LEAD_DETAILS</code>
	 * </p>
	 * 
	 * @return HashMap<Integer, String>
	 * @throws Exception
	 */
	public HashMap<String, String> getContactPersonNameListOfLead()
			throws Exception {
		HashMap<String, String> contactPersonNameList = new HashMap<String, String>();
		try {

			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_CONTACT_PERSON_NAME_LIST);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				contactPersonNameList.put(
						resultSet.getString("CONTACT_PERSON"),
						resultSet.getString("CONTACT_PERSON"));
			}
		} catch (SQLException sqlException) {

			log.error(
					ListHelper.class
							+ ": Error:- While preparing statement to get Cases Resolution Type data from database.",
					sqlException);
		} catch (Exception exception) {

			log.error(ListHelper.class
					+ ": Error:- While getting list of Cases Resolution id and Cases Resolution Type From Database.");
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return contactPersonNameList;
	}

	/**
	 * <p>
	 * <code>travelModeList()</code> method use to fetch Travel Mode display
	 * name and Travel Mode ID from TAB_TRAVEL_MODE table and return the
	 * 
	 * <pre>
	 * HashMap<Integer, String>
	 * </pre>
	 * 
	 * of Travel Mode id and display name.
	 * </p>
	 * 
	 * @return HashMap<Integer, String> map of Travel Mode list with id and
	 *         display name.
	 * @throws Exception
	 */
	public HashMap<Integer, String> travelModeList() throws Exception {

		HashMap<Integer, String> travelModeListMap = new HashMap<Integer, String>();

		try {

			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_TRAVEL_MODE_LIST);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				travelModeListMap.put(resultSet.getInt("TRAVEL_MODE_ID"),
						resultSet.getString("TRAVEL_MODE"));
			}
		} catch (SQLException sqlException) {

			log.error(
					ListHelper.class
							+ ": Error:- While preparing statement to get Travel Mode data from database.",
					sqlException);
		} catch (Exception exception) {

			log.error(ListHelper.class
					+ ": Error:- While getting connection for database.",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return travelModeListMap;
	}

	/**
	 * <p>
	 * <code>getParentAccountList</code> method use to fetch parenT account from
	 * <code>TAB_ACCOUNT</code>
	 * </p>
	 * 
	 * @return HashMap<Integer, String>
	 * @throws Exception
	 */
	public HashMap<Integer, String> getParentAccountList() throws Exception {

		HashMap<Integer, String> parentAccountList = new HashMap<Integer, String>();

		try {

			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_PAREN_ACCOUNT_LIST);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				parentAccountList.put(resultSet.getInt("ACCOUNT_ID"),
						resultSet.getString("ACCOUNT_NAME"));
			}
		} catch (SQLException sqlException) {

			log.error(
					ListHelper.class
							+ ": Error:- While preparing statement to get parent account name data from database.",
					sqlException);
		} catch (Exception exception) {

			log.error(ListHelper.class
					+ ": Error:- While getting list of account id and parent account name From Database.");
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return parentAccountList;

	}

	/**
	 * <p>
	 * <code>getAccountOwnerList</code> method use to fetch parenT account from
	 * <code>TAB_ACCOUNT</code>
	 * </p>
	 * 
	 * @return HashMap<Integer, String>
	 * @throws Exception
	 */
	public HashMap<String, String> getAccountOwnerList() throws Exception {
		HashMap<String, String> accountOwnerList = new HashMap<String, String>();

		try {

			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_ACCOUNT_OWNER_LIST);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				accountOwnerList.put(resultSet.getString("CONTACT_PERSON"),
						resultSet.getString("CONTACT_PERSON"));
			}
		} catch (SQLException sqlException) {

			log.error(
					ListHelper.class
							+ ": Error:- While preparing statement to get account owner data from database.",
					sqlException);
		} catch (Exception exception) {

			log.error(ListHelper.class
					+ ": Error:- While getting list of account id and account owner From Database.");
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return accountOwnerList;
	}

	

	

	/**
	 * customerUserList() method use to fetch CUSTOMER_ID and FULL_NAME from
	 * TAB_CUSTOMER_USER table.
	 * 
	 * @return HashMap<Integer, String>
	 * @throws Exception
	 */
	public HashMap<Integer, String> customerUserList() throws Exception {

		HashMap<Integer, String> customerUserListMap = new HashMap<Integer, String>();
		try {

			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_CUSTOMER_USER_LIST);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				customerUserListMap.put(resultSet.getInt("CUSTOMER_ID"),
						resultSet.getString("FULL_NAME"));
			}
		} catch (SQLException sqlException) {

			log.error(
					ListHelper.class
							+ ": Error:- While preparing statement to get faq Owner from database.",
					sqlException);
		} catch (Exception exception) {

			log.error(ListHelper.class
					+ ": Error:- While getting list of  CUSTOMER_ID and FULL_NAME From Database.");
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return customerUserListMap;
	}

	/**
	 * <p>
	 * <code>accountNameList()</code> method use to fetch country display
	 * ACCOUNT_NAME and ACCOUNT_ID from TAB_COUNTRY table and return the
	 * 
	 * <pre>
	 * HashMap<Integer, String>
	 * </pre>
	 * 
	 * of country id and display name.
	 * </p>
	 * 
	 * @return HashMap<Integer, String> map of county list with id and display
	 *         name.
	 * @throws Exception
	 */
	public HashMap<Integer, String> accountNameList() throws Exception {

		HashMap<Integer, String> accountNameListMap = new HashMap<Integer, String>();

		try {

			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_ACCOUNT_NAME_LIST);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				accountNameListMap.put(resultSet.getInt("ACCOUNT_ID"),
						resultSet.getString("ACCOUNT_NAME"));
			}
		} catch (SQLException sqlException) {

			log.error(
					ListHelper.class
							+ ": Error:- While preparing statement to get country data from database.",
					sqlException);
		} catch (Exception exception) {

			log.error(ListHelper.class
					+ ": Error:- While getting connection for database.",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return accountNameListMap;
	}
	
	
	/**
	 * faqCategoryList method use to fetch faq Category and Category ID from
	 * TAB_FAQ_CATEGORY table.
	 * 
	 * @return HashMap<Integer, String>
	 * @throws Exception
	 */
	public HashMap<Integer, String> faqCategoryList() throws Exception {

		HashMap<Integer, String> faqCategoryListMap = new HashMap<Integer, String>();
		try {

			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_FAQ_CATEGORY_LIST);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				faqCategoryListMap.put(resultSet.getInt("CATEGORY_ID"),
						resultSet.getString("CATEGORY_NAME"));
			}
		} catch (SQLException sqlException) {

			log.error(
					ListHelper.class
							+ ": Error:- While preparing statement to get faq category data from database.",
					sqlException);
		} catch (Exception exception) {

			log.error(ListHelper.class
					+ ": Error:- While getting list of faq Category id and Faq Category From Database.");
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return faqCategoryListMap;
	}

	/**
	 * faqStatusList method use to fetch faq status and Status ID from
	 * TAB_FAQ_STATUS table.
	 * 
	 * @return HashMap<Integer, String>
	 * @throws Exception
	 */
	public HashMap<Integer, String> faqStatusList() throws Exception {

		HashMap<Integer, String> faqStatusListMap = new HashMap<Integer, String>();
		try {

			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_FAQ_STATUS_LIST);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				faqStatusListMap.put(resultSet.getInt("STATUS_ID"),
						resultSet.getString("STATUS_NAME"));
			}
		} catch (SQLException sqlException) {

			log.error(
					ListHelper.class
							+ ": Error:- While preparing statement to get faq status data from database.",
					sqlException);
		} catch (Exception exception) {

			log.error(ListHelper.class
					+ ": Error:- While getting list of faq status id and Faq Status From Database.");
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return faqStatusListMap;
	}

	/**
	 * casesStatusList method use to fetch Cases status and Status ID
	 * TAB_SUPPORT_CASES
	 * 
	 * @return HashMap<Integer, String>
	 * @throws Exception
	 */
	public HashMap<Integer, String> casesStatusList() throws Exception {
		HashMap<Integer, String> casesStatusListMap = new HashMap<Integer, String>();
		try {

			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_CASES_STATUS_LIST);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				casesStatusListMap.put(resultSet.getInt("STATUS_ID"),
						resultSet.getString("STATUS_NAME"));
			}
		} catch (SQLException sqlException) {

			log.error(
					ListHelper.class
							+ ": Error:- While preparing statement to get Cases status data from database.",
					sqlException);
		} catch (Exception exception) {

			log.error(ListHelper.class
					+ ": Error:- While getting list of Cases status id and Cases Status From Database.");
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return casesStatusListMap;
	}

	/**
	 * casesPriorityList method use to fetch Cases Priority and Priority ID from
	 * TAB_CASES_PRIORITY
	 * 
	 * @return HashMap<Integer, String>
	 * @throws Exception
	 */
	public HashMap<Integer, String> casesPriorityList() throws Exception {
		HashMap<Integer, String> casesPriorityListMap = new HashMap<Integer, String>();
		try {

			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_CASES_PRIORITY_LIST);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				casesPriorityListMap.put(resultSet.getInt("PRIORITY_ID"),
						resultSet.getString("PRIORITY_NAME"));
			}
		} catch (SQLException sqlException) {

			log.error(
					ListHelper.class
							+ ": Error:- While preparing statement to get Cases priority data from database.",
					sqlException);
		} catch (Exception exception) {

			log.error(ListHelper.class
					+ ": Error:- While getting list of Cases id and Cases priority From Database.");
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return casesPriorityListMap;
	}

	/**
	 * casesAssignedToList method use to fetch Cases Assigned To and cases
	 * Assigned To ID from TAB_CASES_ASSIGNED_TO
	 * 
	 * @return HashMap<Integer, String>
	 * @throws Exception
	 */
	public HashMap<Integer, String> casesAssignedToList() throws Exception {
		HashMap<Integer, String> casesAssignedToListMap = new HashMap<Integer, String>();
		try {

			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_CASES_ASSIGNED_TO_LIST);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				casesAssignedToListMap.put(resultSet.getInt("ASSIGNED_TO_ID"),
						resultSet.getString("ASSIGNED_TO_NAME"));
			}
		} catch (SQLException sqlException) {

			log.error(
					ListHelper.class
							+ ": Error:- While preparing statement to get Cases Assigned To data from database.",
					sqlException);
		} catch (Exception exception) {

			log.error(ListHelper.class
					+ ": Error:- While getting list of Cases Assigned To id and Cases Assigned To From Database.");
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return casesAssignedToListMap;
	}

	/**
	 * casesTeamList method use to fetch Cases Team and cases Team ID from
	 * TAB_CASES_TEAM
	 * 
	 * @return HashMap<Integer, String>
	 * @throws Exception
	 */
	public HashMap<Integer, String> casesTeamList() throws Exception {
		HashMap<Integer, String> casesTeamListListMap = new HashMap<Integer, String>();
		try {

			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_CASES_TEAM_LIST);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				casesTeamListListMap.put(resultSet.getInt("TEAM_ID"),
						resultSet.getString("TEAM_NAME"));
			}
		} catch (SQLException sqlException) {

			log.error(
					ListHelper.class
							+ ": Error:- While preparing statement to get Cases team data from database.",
					sqlException);
		} catch (Exception exception) {

			log.error(ListHelper.class
					+ ": Error:- While getting list of Cases team id and Cases team  From Database.");
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return casesTeamListListMap;
	}

	/**
	 * casesChannelList method use to fetch Cases Channel and cases Channel ID
	 * from TAB_CASES_CHANNEL
	 * 
	 * @return HashMap<Integer, String>
	 * @throws Exception
	 */
	public HashMap<Integer, String> casesChannelList() throws Exception {
		HashMap<Integer, String> casesChannelListMap = new HashMap<Integer, String>();
		try {

			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_CASES_CHANNEL_LIST);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				casesChannelListMap.put(resultSet.getInt("CHANNEL_ID"),
						resultSet.getString("CHANNEL_NAME"));
			}
		} catch (SQLException sqlException) {

			log.error(
					ListHelper.class
							+ ": Error:- While preparing statement to get Cases channel data from database.",
					sqlException);
		} catch (Exception exception) {

			log.error(ListHelper.class
					+ ": Error:- While getting list of Cases team To id and Cases channel From Database.");
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return casesChannelListMap;
	}

	/**
	 * casesImpactTypelList method use to fetch Cases Impact Type and Cases
	 * Channel ID from TAB_CASES_IMPACT_TYPE
	 * 
	 * @return HashMap<Integer, String>
	 * @throws Exception
	 */
	public HashMap<Integer, String> casesImpactTypelList() throws Exception {
		HashMap<Integer, String> casesImpactTypelListMap = new HashMap<Integer, String>();
		try {

			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_CASES_IMPACT_TYPE_LIST);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				casesImpactTypelListMap.put(resultSet.getInt("IMPACT_TYPE_ID"),
						resultSet.getString("IMPACT_TYPE_NAME"));
			}
		} catch (SQLException sqlException) {

			log.error(
					ListHelper.class
							+ ": Error:- While preparing statement to get CASES IMPACT TYPE  data from database.",
					sqlException);
		} catch (Exception exception) {

			log.error(ListHelper.class
					+ ": Error:- While getting list of Cases IMPACT TYPE  ID and Cases IMPACT TYPE From Database.");
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return casesImpactTypelListMap;
	}

	/**
	 * casesImpactAreaList method use to fetch Cases Impact Area and cases
	 * Impact area ID from TAB_CASES_IMPACT_AREA
	 * 
	 * @return HashMap<Integer, String>
	 * @throws Exception
	 */
	public HashMap<Integer, String> casesImpactAreaList() throws Exception {
		HashMap<Integer, String> casesImpactAreaListMap = new HashMap<Integer, String>();
		try {

			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_CASES_IMPACT_AREA_LIST);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				casesImpactAreaListMap.put(resultSet.getInt("IMPACT_AREA_ID"),
						resultSet.getString("IMPACT_AREA_NAME"));
			}
		} catch (SQLException sqlException) {

			log.error(
					ListHelper.class
							+ ": Error:- While preparing statement to get Cases Impact Type data from database.",
					sqlException);
		} catch (Exception exception) {

			log.error(ListHelper.class
					+ ": Error:- While getting list of Cases Impact Type id and Cases Impact Type From Database.");
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return casesImpactAreaListMap;
	}

	/**
	 * casesResolutionList method use to fetch Cases Resolution Type and cases
	 * Resolution Type ID from casesResolutionTypeList
	 * 
	 * @return HashMap<Integer, String>
	 * @throws Exception
	 */
	public HashMap<Integer, String> casesResolutionTypeList() throws Exception {
		HashMap<Integer, String> casesResolutionTypeListMap = new HashMap<Integer, String>();
		try {

			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_CASES_RESOLUTION_TYPE_LIST);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				casesResolutionTypeListMap.put(
						resultSet.getInt("RESOLUTION_TYPE_ID"),
						resultSet.getString("RESOLUTION_TYPE_NAME"));
			}
		} catch (SQLException sqlException) {

			log.error(
					ListHelper.class
							+ ": Error:- While preparing statement to get Cases Resolution Type data from database.",
					sqlException);
		} catch (Exception exception) {

			log.error(ListHelper.class
					+ ": Error:- While getting list of Cases Resolution id and Cases Resolution Type From Database.");
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return casesResolutionTypeListMap;
	}

/**
	 * faqProductNameList() method use to fetch PRODUCT ID and PRODUCT NAME from
	 * TAB_FAQ_PRODUCT table.
	 * 
	 * @return HashMap<Integer, String>
	 * @throws Exception
	 */
	public HashMap<Integer, String> faqProductNameList() throws OMIApplicationException {

		HashMap<Integer, String> faqProductNameListMap = new HashMap<Integer, String>();
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_FAQ_PRODUCT_NAME_LIST);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				faqProductNameListMap.put(resultSet.getInt("PRODUCT_ID"),
						resultSet.getString("PRODUCT_NAME"));
			}
		} catch (SQLException sqlException) {

			log.error(
					ListHelper.class
							+ ": Error:- While preparing statement to get Faq from database.",
					sqlException);
		} catch (Exception exception) {

			log.error(ListHelper.class
					+ ": Error:- While getting list of PRODUCT ID and PRODUCT NAME From Database.");
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return faqProductNameListMap;
	}

	/**
	 * casesContactNameList() method use to fetch CONTACT ID and CONTACT NAME
	 * from TAB_CONTACT table.
	 * 
	 * @return HashMap<Integer, String>
	 * @throws Exception
	 */
	public HashMap<Integer, String> casesContactNameList() throws OMIApplicationException {
		HashMap<Integer, String> casesContactNameListMap = new HashMap<Integer, String>();
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_CASES_CONTACT_NAME_LIST);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				casesContactNameListMap.put(resultSet.getInt("CONTACT_ID"),
						resultSet.getString("CONTACT_PERSON"));
			}
		} catch (SQLException sqlException) {

			log.error(
					ListHelper.class
							+ ": Error:- While preparing statement to get Cases from database.",
					sqlException);
		} catch (Exception exception) {

			log.error(ListHelper.class
					+ ": Error:- While getting list of PRODUCT ID and PRODUCT NAME From Database.");
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return casesContactNameListMap;
	}

	/**
	 * faqOwnerList() method use to fetch CUSTOMER_ID and FULL_NAME from
	 * TAB_CUSTOMER_USER table.
	 * 
	 * @return HashMap<Integer, String>
	 * @throws Exception
	 */
	public HashMap<Integer, String> faqOwnerList() throws Exception {

		HashMap<Integer, String> faqOwnerListMap = new HashMap<Integer, String>();
		try {

			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_FAQ_OWNER_NAME_LIST);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				faqOwnerListMap.put(resultSet.getInt("CUSTOMER_ID"),
						resultSet.getString("FULL_NAME"));
			}
		} catch (SQLException sqlException) {

			log.error(
					ListHelper.class
							+ ": Error:- While preparing statement to get faq Owner from database.",
					sqlException);
		} catch (Exception exception) {

			log.error(ListHelper.class
					+ ": Error:- While getting list of  CUSTOMER_ID and FULL_NAME From Database.");
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return faqOwnerListMap;
	}

	/**
	 * casesSlaNamelList() method use to fetch ACCOUNT ID and SLA NAME from
	 * TAB_SALUTATION table.
	 * 
	 * @return HashMap<Integer, String>
	 * @throws Exception
	 */

	public HashMap<Integer, String> casesSlaNamelList() throws Exception {
		HashMap<Integer, String> casesSlaNamelListMap = new HashMap<Integer, String>();
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_CASES_SLA_LIST);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				casesSlaNamelListMap.put(resultSet.getInt("ACCOUNT_ID"),
						resultSet.getString("SLA_NAME"));
			}
		} catch (SQLException sqlException) {

			log.error(
					ListHelper.class
							+ ": Error:- While preparing statement to get Cases from database.",
					sqlException);
		} catch (Exception exception) {

			log.error(ListHelper.class
					+ ": Error:- While getting list of SLA ID and SLA NAME From Database.");
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return casesSlaNamelListMap;
	}

	/**
	 * casesOrgnizationList() method use to fetch ORGNIZATION ID and ORGNIZATION
	 * NAME from TAB_SALUTATION table.
	 * 
	 * @return HashMap<Integer, String>
	 * @throws Exception
	 */

	public HashMap<Integer, String> casesOrgnizationList() throws OMIApplicationException {
		HashMap<Integer, String> casesOrgnizationListMap = new HashMap<Integer, String>();
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_CASES_ORGNIZATION_LIST);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				casesOrgnizationListMap.put(resultSet.getInt("COMPANY_ID"),
						resultSet.getString("COMPANY_NAME"));
			}
		} catch (SQLException sqlException) {

			log.error(
					ListHelper.class
							+ ": Error:- While preparing statement to get Cases from database.",
					sqlException);
		} catch (Exception exception) {

			log.error(ListHelper.class
					+ ": Error:- While getting list of Orgnization ID and Orgnization NAME From Database.");
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return casesOrgnizationListMap;
	}

	/**
	 * casesProductNameList() method use to fetch PRODUCT ID and PRODUCT NAME
	 * from TAB_PRODUCT table.
	 * 
	 * @return HashMap<Integer, String>
	 * @throws Exception
	 */

	public HashMap<Integer, String> casesProductNameList() throws OMIApplicationException {
		HashMap<Integer, String> casesProductNameListMap = new HashMap<Integer, String>();
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_CASES_PRODUCT_NAME_LIST);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				casesProductNameListMap.put(resultSet.getInt("PRODUCT_ID"),
						resultSet.getString("PRODUCT_NAME"));
			}
		} catch (SQLException sqlException) {

			log.error(
					ListHelper.class
							+ ": Error:- While preparing statement to get CAMPAIGN from database.",
					sqlException);
		} catch (Exception exception) {

			log.error(ListHelper.class
					+ ": Error:- While getting list of  PRODUCT ID and PRODUCT NAME From Database.");
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return casesProductNameListMap;
	}

	/**
	 * ticketCategoryList() method use to fetch CATEGORY ID and CATEGORY NAME
	 * from TAB_CATEGORY table.
	 * 
	 * @return HashMap<Integer, String>
	 * @throws Exception
	 */
	public HashMap<Integer, String> ticketCategoryList() throws Exception {
		HashMap<Integer, String> ticketCategoryListMap = new HashMap<Integer, String>();
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_TICKET_CATEGORY_LIST);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				ticketCategoryListMap.put(resultSet.getInt("CATEGORY_ID"),
						resultSet.getString("CATEGORY_NAME"));
			}
		} catch (SQLException sqlException) {

			log.error(
					ListHelper.class
							+ ": Error:- While preparing statement to get Ticket from database.",
					sqlException);
		} catch (Exception exception) {

			log.error(ListHelper.class
					+ ": Error:- While getting list of CATEGORY ID and CATEGORY NAME From Database.");
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return ticketCategoryListMap;
	}

	/**
	 * ticketOwnerList() method use to fetch CUSTOMER ID and FULL NAME from
	 * TAB_CUSTOMER_USER table.
	 * 
	 * @return HashMap<Integer, String>
	 * @throws Exception
	 */
	public HashMap<Integer, String> ticketOwnerList() throws Exception {
		HashMap<Integer, String> ticketOwnerListMap = new HashMap<Integer, String>();
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_TICKET_OWNER_LIST);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				ticketOwnerListMap.put(resultSet.getInt("CUSTOMER_ID"),
						resultSet.getString("FULL_NAME"));
			}
		} catch (SQLException sqlException) {

			log.error(
					ListHelper.class
							+ ": Error:- While preparing statement to get Ticket from database.",
					sqlException);
		} catch (Exception exception) {

			log.error(ListHelper.class
					+ ": Error:- While getting list of CUSTOMER ID and FULL NAME From Database.");
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return ticketOwnerListMap;
	}

	/**
	 * ticketChannelList() method use to fetch CHANNEL ID and CHANNEL NAME from
	 * TAB_CHANNEL table.
	 * 
	 * @return HashMap<Integer, String>
	 * @throws Exception
	 */
	public HashMap<Integer, String> ticketChannelList() throws Exception {
		HashMap<Integer, String> ticketChannelListMap = new HashMap<Integer, String>();
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_TICKET_CHANNEL_LIST);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				ticketChannelListMap.put(resultSet.getInt("CHANNEL_ID"),
						resultSet.getString("CHANNEL_NAME"));
			}
		} catch (SQLException sqlException) {

			log.error(
					ListHelper.class
							+ ": Error:- While preparing statement to get Ticket from database.",
					sqlException);
		} catch (Exception exception) {

			log.error(ListHelper.class
					+ ": Error:- While getting list of CHANNEL ID and CHANNEL NAME From Database.");
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return ticketChannelListMap;
	}

	/**
	 * ticketProductNameList() method use to fetch PRODUCT ID and PRODUCT NAME
	 * from TAB_PRODUCT table.
	 * 
	 * @return HashMap<Integer, String>
	 * @throws Exception
	 */
	public HashMap<Integer, String> ticketProductNameList() throws OMIApplicationException {
		HashMap<Integer, String> ticketProductNameListMap = new HashMap<Integer, String>();
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_TICKET_PRODUCT_NAME_LIST);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				ticketProductNameListMap.put(resultSet.getInt("PRODUCT_ID"),
						resultSet.getString("PRODUCT_NAME"));
			}
		} catch (SQLException sqlException) {

			log.error(
					ListHelper.class
							+ ": Error:- While preparing statement to get Ticket from database.",
					sqlException);
		} catch (Exception exception) {

			log.error(ListHelper.class
					+ ": Error:- While getting list of PRODUCT ID and PRODUCT NAME From Database.");
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return ticketProductNameListMap;
	}

	/**
	 * ticketContactNameList() method use to fetch CONTACT ID and CONTACT PERSON 
	 * from TAB_CONTACT table.
	 * 
	 * @return HashMap<Integer, String>
	 * @throws Exception
	 */
	public HashMap<Integer, String> ticketContactNameList()throws Exception {
		HashMap<Integer, String> ticketContactNameListMap = new HashMap<Integer, String>();
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_TICKET_CONTACT_NAME_LIST);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				ticketContactNameListMap.put(resultSet.getInt("CONTACT_ID"),
						resultSet.getString("CONTACT_PERSON"));
			}
		} catch (SQLException sqlException) {

			log.error(
					ListHelper.class
							+ ": Error:- While preparing statement to get Ticket from database.",
					sqlException);
		} catch (Exception exception) {

			log.error(ListHelper.class
					+ ": Error:- While getting list of CONTACT ID and CONTACT PERSON From Database.");
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return ticketContactNameListMap;
	}

	

	/**
	 * productTaxList() method use to fetch TAX_ID and TAX NAME
	 * from TAB_TAX table.
	 * 
	 * @return HashMap<Integer, String>
	 * @throws Exception
	 */
	public HashMap<Integer, String> productTaxList() throws Exception {

		HashMap<Integer, String> productTaxListMap = new HashMap<Integer, String>();
		try {

			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_PRODUCT_TAX_LIST);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				productTaxListMap.put(resultSet.getInt("TAX_ID"),
						resultSet.getString("TAX_DISPLAY_NAME"));
			}
		} catch (SQLException sqlException) {

			log.error(
					ListHelper.class
							+ ": Error:- While preparing statement to get Product Tax from database.",
					sqlException);
		} catch (Exception exception) {

			log.error(ListHelper.class
					+ ": Error:- While getting list of  TAX_ID and TAX_DISPLAY_NAME From Database.");
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return productTaxListMap;
	}
	/**
	 * productCategoryList() method use to fetch CATEGORY ID and CATEGORY NAME 
	 * from TAB_PRODUCT_CATEGORY table.
	 * 
	 * @return HashMap<Integer, String>
	 * @throws Exception
	 */
	public Map<Integer, String> productCategoryList()throws Exception{
		HashMap<Integer, String> productCategoryListMap = new HashMap<Integer, String>();
		try {

			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_PRODUCT_CATEGORY_LIST);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				productCategoryListMap.put(resultSet.getInt("PRODUCT_CATEGORY_ID"),
						resultSet.getString("PRODUCT_CATEGORY_NAME"));
			}
		} catch (SQLException sqlException) {

			log.error(
					ListHelper.class
							+ ": Error:- While preparing statement to get Product Category from database.",
					sqlException);
		} catch (Exception exception) {

			log.error(ListHelper.class
					+ ": Error:- While getting list of  PRODUCT_CATEGORY_ID and PRODUCT_CATEGORY_NAME From Database.");
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return productCategoryListMap;
	}
	/**
	 * productUsageUnitList() method use to fetch USAGE_UNIT ID and USAGE_UNIT NAME
	 * from TAB_PRODUCT_USAGE_UNIT table.
	 * 
	 * @return HashMap<Integer, String>
	 * @throws Exception
	 */
	public Map<Integer, String> productUsageUnitList()throws Exception{
		

		HashMap<Integer, String> productUsageUnitListMap = new HashMap<Integer, String>();
		try {

			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_PRODUCT_USAGE_UNIT_LIST);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				productUsageUnitListMap.put(resultSet.getInt("PRODUCT_USAGE_UNIT_ID"),
						resultSet.getString("PRODUCT_USAGE_UNIT_NAME"));
			}
		} catch (SQLException sqlException) {

			log.error(
					ListHelper.class
							+ ": Error:- While preparing statement to get Product Category from database.",
					sqlException);
		} catch (Exception exception) {

			log.error(ListHelper.class
					+ ": Error:- While getting list of  PRODUCT_CATEGORY_ID and PRODUCT_CATEGORY_NAME From Database.");
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return productUsageUnitListMap;
	}
	/**
	 * productManufacturerList() method use to fetch MANUFACTURER ID and MANUFACTURE NAME
	 * from TAB_CUSTOMER_USER table.
	 * 
	 * @return HashMap<Integer, String>
	 * @throws Exception
	 */
	public Map<Integer, String> productManufacturerList()throws Exception  {
		HashMap<Integer, String> productManufacturerListMap = new HashMap<Integer, String>();
		try {

			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_PRODUCT_MANUFACTURER_LIST);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				productManufacturerListMap.put(resultSet.getInt("CUSTOMER_ID"),
						resultSet.getString("FULL_NAME"));
			}
		} catch (SQLException sqlException) {

			log.error(
					ListHelper.class
							+ ": Error:- While preparing statement to get Product Category from database.",
					sqlException);
		} catch (Exception exception) {

			log.error(ListHelper.class
					+ ": Error:- While getting list of  PRODUCT_CATEGORY_ID and PRODUCT_CATEGORY_NAME From Database.");
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return productManufacturerListMap;
		
	}
	/**
	 * productHandlerList() method use to fetch Handler ID and Handler NAME
	 * from TAB_CUSTOMER_USER table.
	 * 
	 * @return HashMap<Integer, String>
	 * @throws Exception
	 */
	public Map<Integer, String> productHandlerList()throws Exception  {
		HashMap<Integer, String> productHandlerListMap = new HashMap<Integer, String>();
		try {

			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_PRODUCT_HANDLER_LIST);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				productHandlerListMap.put(resultSet.getInt("CUSTOMER_ID"),
						resultSet.getString("FULL_NAME"));
			}
		} catch (SQLException sqlException) {

			log.error(
					ListHelper.class
							+ ": Error:- While preparing statement to get Product Category from database.",
					sqlException);
		} catch (Exception exception) {

			log.error(ListHelper.class
					+ ": Error:- While getting list of  PRODUCT_CATEGORY_ID and PRODUCT_CATEGORY_NAME From Database.");
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return productHandlerListMap;
		
	}
	
	
	/**
	 * contactList() method use to fetch CONTACT ID  and CONTACT NAME from
	 * TAB_CONTACT table.
	 * 
	 * @return HashMap<Integer, String>
	 * @throws Exception
	 */
	public HashMap<Integer, String> contactList() throws Exception {
			HashMap<Integer, String> contactListMap = new HashMap<Integer, String>();
			try {
				connection = getConnection();
				preparedStatement = connection
						.prepareStatement(QueryMaker.GET_CONTACT_NAME_LIST);
				resultSet = preparedStatement.executeQuery();

				while (resultSet.next()) {
					contactListMap.put(resultSet.getInt("CONTACT_ID"),
							resultSet.getString("CONTACT_PERSON"));
				}
			} catch (SQLException sqlException) {

				log.error(
						ListHelper.class
								+ ": Error:- While preparing statement to get Cases from database.",
						sqlException);
			} catch (Exception exception) {

				log.error(ListHelper.class
						+ ": Error:- While getting list of PRODUCT ID and PRODUCT NAME From Database.");
			} finally {
				JdbcHelper.closeResultSet(resultSet);
				JdbcHelper.closePreparedStatement(preparedStatement);
				JdbcHelper.closeConnection(connection);
			}
			return contactListMap;
		}






	/**
	 * leadList() method use to fetch LEAD_ID  and CONTACT_PERSON from
	 * tab_lead_details table.
	 * 
	 * @return HashMap<Integer, String>
	 * @throws Exception
	 */
	public HashMap<Integer, String> leadList() throws Exception {
			HashMap<Integer, String> leadListMap = new HashMap<Integer, String>();
			try {
				connection = getConnection();
				preparedStatement = connection
						.prepareStatement(QueryMaker.GET_LEAD_LIST);
				resultSet = preparedStatement.executeQuery();

				while (resultSet.next()) {
					leadListMap.put(resultSet.getInt("LEAD_ID"),
							resultSet.getString("CONTACT_PERSON"));
				}
			} catch (SQLException sqlException) {

				log.error(
						ListHelper.class
								+ ": Error:- While preparing statement to get Cases from database.",
						sqlException);
			} catch (Exception exception) {

				log.error(ListHelper.class
						+ ": Error:- While getting list of PRODUCT ID and PRODUCT NAME From Database.");
			} finally {
				JdbcHelper.closeResultSet(resultSet);
				JdbcHelper.closePreparedStatement(preparedStatement);
				JdbcHelper.closeConnection(connection);
			}
			return leadListMap;
		}






	/**
		 * campaignList() method use to fetch CAMPAIGN_ID and
		 * CAMPAIGN_NAME from TAB_CAMPAIGN table.
		 * 
		 * @return HashMap<Integer, String>
		 * @throws Exception
		 */
		public HashMap<Integer, String> campaignList() throws Exception {

			HashMap<Integer, String> campaignListMap = new HashMap<Integer, String>();
			try {

				connection = getConnection();
				preparedStatement = connection
						.prepareStatement(QueryMaker.GET_CAMPAIGN_LIST);
				resultSet = preparedStatement.executeQuery();

				while (resultSet.next()) {
					campaignListMap.put(resultSet.getInt("CAMPAIGN_ID"),
							resultSet.getString("CAMPAIGN_NAME"));
				}
			} catch (SQLException sqlException) {

				log.error(
						ListHelper.class
								+ ": Error:- While preparing statement to get CAMPAIGN TYPE from database.",
						sqlException);
			} catch (Exception exception) {

				log.error(ListHelper.class
						+ ": Error:- While getting list of  CAMPAIGN_TYPE_ID and CAMPAIGN_TYPE_NAME From Database.");
			} finally {
				JdbcHelper.closeResultSet(resultSet);
				JdbcHelper.closePreparedStatement(preparedStatement);
				JdbcHelper.closeConnection(connection);
			}
			return campaignListMap;
		}






	/**
		 * <p>
		 * <code>leadSourceNameList()</code> method use to fetch Lead source name and
		 * Lead source ID from TAB_LEAD_SOURCE table and return the
		 * 
		 * <pre>
		 * HashMap<Integer, String>
		 * </pre>
		 * 
		 * of Lead source ID and name.
		 * </p>
		 * 
		 * @return HashMap<Integer, String> map of lead Source List with id and
		 *         name.
		 * @throws Exception
		 */
		public HashMap<Integer, String> leadSourceNameList() throws Exception {

			HashMap<Integer, String> leadSourceNameListMap = new HashMap<Integer, String>();

			try {

				connection = getConnection();
				preparedStatement = connection
						.prepareStatement(QueryMaker.GET_LEAD_SOURCE_NAME_LIST);
				resultSet = preparedStatement.executeQuery();

				while (resultSet.next()) {
					leadSourceNameListMap.put(resultSet.getInt("LEAD_SOURCE_ID"),
							resultSet.getString("LEAD_SOURCE_NAME"));
				}
			} catch (SQLException sqlException) {

				log.error(
						ListHelper.class
								+ ": Error:- While preparing statement to get Lead source data from database.",
						sqlException);
			} catch (Exception exception) {

				log.error(ListHelper.class
						+ ": Error:- While getting connection for database.",
						exception);
			} finally {
				JdbcHelper.closeResultSet(resultSet);
				JdbcHelper.closePreparedStatement(preparedStatement);
				JdbcHelper.closeConnection(connection);
			}
			return leadSourceNameListMap;
		}
	
		
		/**
		 * productGlAccountList() method use to fetch Gl Account ID and Gl Account NAME
		 * from TAB_GL_ACCOUNT table.
		 * 
		 * @return HashMap<Integer, String>
		 * @throws Exception
		 */
		public Map<Integer, String> productGlAccountList() throws Exception  {
			HashMap<Integer, String> productGlAccountListMap = new HashMap<Integer, String>();
			try {

				connection = getConnection();
				preparedStatement = connection
						.prepareStatement(QueryMaker.GET_PRODUCT_GLACCOUNT_LIST);
				resultSet = preparedStatement.executeQuery();

				while (resultSet.next()) {
					productGlAccountListMap.put(resultSet.getInt("GL_ACCOUNT_ID"),
							resultSet.getString("GL_ACCOUNT_NAME"));
				}
			} catch (SQLException sqlException) {

				log.error(
						ListHelper.class
								+ ": Error:- While preparing statement to get Product GL Account from database.",
						sqlException);
			} catch (Exception exception) {

				log.error(ListHelper.class
						+ ": Error:- While getting list of  PRODUCT_GLACCOUNT_ID and PRODUCT_GLACCOUNT_NAME From Database.");
			} finally {
				JdbcHelper.closeResultSet(resultSet);
				JdbcHelper.closePreparedStatement(preparedStatement);
				JdbcHelper.closeConnection(connection);
			}
			return productGlAccountListMap;
			
			
		}
		
		
		/**
		 * serviceTrackingUnitList() method use to fetch Tracking Units Id and
		 * Tracking Units Id from TAB_TRACKING_UNITS table.
		 * 
		 * @return HashMap<Integer, String>
		 * @throws Exception
		 */
		public Map<Integer, String> serviceTrackingUnitList() throws Exception {
			HashMap<Integer, String> serviceTrackingUnitListMap = new HashMap<Integer, String>();
			try {
				connection = getConnection();
				preparedStatement = connection
						.prepareStatement(QueryMaker.GET_SERVICE_TRACKING_UNITS_LIST);
				resultSet = preparedStatement.executeQuery();

				while (resultSet.next()) {
					serviceTrackingUnitListMap.put(
							resultSet.getInt("TRACKING_UNIT_ID"),
							resultSet.getString("TRACKING_UNIT_NAME"));
				}
			} catch (SQLException sqlException) {

				log.error(
						ListHelper.class
								+ ": Error:- While preparing statement to get Service Contract from database.",
						sqlException);
			} catch (Exception exception) {

				log.error(ListHelper.class
						+ ": Error:- While getting list Service Tracking Units Id of Service Tracking Units Name and From Database.");
			} finally {
				JdbcHelper.closeResultSet(resultSet);
				JdbcHelper.closePreparedStatement(preparedStatement);
				JdbcHelper.closeConnection(connection);
			}
			return serviceTrackingUnitListMap;
		}

		/**
		 * serviceTypeList() method use to fetch SERVICE TYPE ID and SERVICE TYPE
		 * NAME from TAB_SERVICE_TYPE table.
		 * 
		 * @return HashMap<Integer, String>
		 * @throws Exception
		 */

		public Map<Integer, String> serviceTypeList() throws Exception {
			HashMap<Integer, String> serviceTypeListMap = new HashMap<Integer, String>();
			try {
				connection = getConnection();
				preparedStatement = connection
						.prepareStatement(QueryMaker.GET_SERVICE_TYPE_LIST);
				resultSet = preparedStatement.executeQuery();

				while (resultSet.next()) {
					serviceTypeListMap.put(
							resultSet.getInt("SERVICE_CONTRACT_TYPE_ID"),
							resultSet.getString("SERVICE_CONTRACT_TYPE_NAME"));
				}
			} catch (SQLException sqlException) {

				log.error(
						ListHelper.class
								+ ": Error:- While preparing statement to get Service Contract from database.",
						sqlException);
			} catch (Exception exception) {

				log.error(ListHelper.class
						+ ": Error:- While getting list Service Type Id of Service Type Name and From Database.");
			} finally {
				JdbcHelper.closeResultSet(resultSet);
				JdbcHelper.closePreparedStatement(preparedStatement);
				JdbcHelper.closeConnection(connection);
			}
			return serviceTypeListMap;
		}

		/**
		 * vendorsGlAccountList() method use to fetch Gl Account ID and Gl Account
		 * NAME from TAB_GL_ACCOUNT table.
		 * 
		 * @return HashMap<Integer, String>
		 * @throws Exception
		 */
		

		public Map<Integer, String> vendorsGlAccountList() {
			HashMap<Integer, String> glAccountListMap = new HashMap<Integer, String>();
			try {
				connection = getConnection();
				preparedStatement = connection
						.prepareStatement(QueryMaker.GET_VENDORS_GLACCOUNT_LIST);
				resultSet = preparedStatement.executeQuery();

				while (resultSet.next()) {
					glAccountListMap.put(resultSet.getInt("GL_ACCOUNT_ID"),
							resultSet.getString("GL_ACCOUNT_NAME"));
				}
			} catch (SQLException sqlException) {

				log.error(
						ListHelper.class
								+ ": Error:- While preparing statement to get Vendors GL Account from database.",
						sqlException);
			} catch (Exception exception) {

				log.error(ListHelper.class
						+ ": Error:- While getting list of  VENDORS_GLACCOUNT_ID and VENDORS_GLACCOUNT_NAME From Database.");
			} finally {
				JdbcHelper.closeResultSet(resultSet);
				JdbcHelper.closePreparedStatement(preparedStatement);
				JdbcHelper.closeConnection(connection);
			}
			return glAccountListMap;
		}

		
		/**
		 * eventCategoryList() method use to fetch Event ID and Event Name
		 *  from TAB_EVENT_CATEGORY table.
		 * 
		 * @return HashMap<Integer, String>
		 * @throws Exception
		 */
		public Map<Integer, String> eventCategoryList() {
			
			HashMap<Integer, String> eventCategoryListMap = new HashMap<Integer, String>();
			try {
				connection = getConnection();
				preparedStatement = connection
						.prepareStatement(QueryMaker.GET_EVENT_CATEGORY_LIST);
				resultSet = preparedStatement.executeQuery();

				while (resultSet.next()) {
					eventCategoryListMap.put(resultSet.getInt("EVENT_CATEGORY_ID"),
							resultSet.getString("EVENT_CATEGORY_NAME"));
				}
			} catch (SQLException sqlException) {

				log.error(
						ListHelper.class
								+ ": Error:- While preparing statement to get event category from database.",
						sqlException);
			} catch (Exception exception) {

				log.error(ListHelper.class
						+ ": Error:- While getting list of EVENT_CATEGORY_ID  and EVENT_CATEGORY_NAME From Database.");
			} finally {
				JdbcHelper.closeResultSet(resultSet);
				JdbcHelper.closePreparedStatement(preparedStatement);
				JdbcHelper.closeConnection(connection);
			}
			return eventCategoryListMap;
		}
		
		/**
		 * customerUserList() method use to fetch CUSTOMER_ID and FULL_NAME from
		 * TAB_CUSTOMER_USER table.
		 * 
		 * @return HashMap<Integer, String>
		 * @throws Exception
		 */
		public HashMap<Integer, String> reportsToList() throws Exception {

			HashMap<Integer, String> reportsToListMap = new HashMap<Integer, String>();
			try {

				connection = getConnection();
				preparedStatement = connection
						.prepareStatement(QueryMaker.GET_REPORTS_TO_LIST);
				resultSet = preparedStatement.executeQuery();

				while (resultSet.next()) {
					reportsToListMap.put(resultSet.getInt("CUSTOMER_ID"),
							resultSet.getString("FULL_NAME"));
				}
			} catch (SQLException sqlException) {

				log.error(
						ListHelper.class
								+ ": Error:- While preparing statement to get REPORTS TO from database.",
						sqlException);
			} catch (Exception exception) {

				log.error(ListHelper.class
						+ ": Error:- While getting list of  CUSTOMER_ID and FULL_NAME From Database.");
			} finally {
				JdbcHelper.closeResultSet(resultSet);
				JdbcHelper.closePreparedStatement(preparedStatement);
				JdbcHelper.closeConnection(connection);
			}
			return reportsToListMap;
		}
	

		public final Map<Integer, Float> taxList() throws Exception {
			HashMap<Integer, Float> taxList = null;
			//HashMap<Float, Integer> totalTaxList = null;
			String query = QueryMaker.GET_TAX_LIST;
			try {
				taxList = new HashMap<Integer, Float>();
				//totalTaxList = new HashMap<Float, Integer>();
				connection = getConnection();
				preparedStatement = connection.prepareStatement(query);
				resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
					
					float totalTax = resultSet.getFloat("TAX_TOTAL");
					float totalTaxId = resultSet.getFloat("TAX_TOTAL");
					String taxdisplayName = resultSet.getString("TAX_DISPLAY_NAME");
					int taxId = resultSet.getInt("TAX_ID");
					taxList.put(taxId, totalTax);
					//taxList.put(taxId, taxdisplayName);
					//totalTaxList.put(totalTax, taxId);
				}
				return taxList;
			} catch (Exception exception) {

				log.error(ListHelper.class
						+ ": Error:- While getting Tax List From Database.");
			} finally {
				try {
					if (null != connection) {
						resultSet.close();
						preparedStatement.close();
						connection.close();
					}
				} catch (SQLException sqlExp) {
					log.error(ListHelper.class
							+ ": Error:- While closing the Connection after getting Tax List From Database.");
				}
			}

			return taxList;
		}
		
		
		public JSONObject prodDescPrice(int productId) {

			JSONObject productList = null;
			JSONObject object =null;
			try {
				/*String query = QueryMaker.GET_PRODUCTION_DESC_AND_PRICE_LIST;*/
				String query = QueryMaker.GET_ITEM_DESC_AND_PRICE_LIST;
				connection = getConnection();
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setInt(1, productId);
				resultSet = preparedStatement.executeQuery();
				//JSONArray array = new JSONArray();
				productList = new JSONObject();

				while (resultSet.next()) {
					object= new JSONObject();

					String description = resultSet.getString("DESCRIPTION");
					String productPrice = resultSet
							.getString("UNIT_PRICE");
					
					object.put("description", description);
					object.put("productPrice", productPrice);
					//array.add(object);
					
				}
				productList.put("product", object);
			} catch (Exception exception) {

				log.error(ListHelper.class
						+ ": Error:- While getting product Description and Product Price From Database."+exception);
			} finally {
				try {
					if (null != connection) {
						resultSet.close();
						preparedStatement.close();
						connection.close();
					}
				} catch (SQLException sqlExp) {
					log.error(ListHelper.class
							+ ": Error:- While closing the Connection after getting product Description and Product Price From Database.");
				}
			}
			return productList;
		}
		
		
		public HashMap<Integer, String> regularCustomerList() throws RecordNotFoundException {

			HashMap<Integer, String> regCustomerListMap = new HashMap<Integer, String>();

			try {

				connection = getConnection();
				preparedStatement = connection
						.prepareStatement(QueryMaker.GET_REG_CUSTOMER_LIST);
				resultSet = preparedStatement.executeQuery();

				while (resultSet.next()) {
					regCustomerListMap.put(resultSet.getInt("REG_CUSTOMER_ID"),
							resultSet.getString("REG_FULL_NAME"));
				}
			} catch (SQLException sqlException) {

				log.error(
						ListHelper.class
								+ ": Error:- While preparing statement to get regular customer data from database.",
						sqlException);
			} catch (Exception exception) {

				log.error(ListHelper.class
						+ ": Error:- While getting connection for database.",
						exception);
			} finally {
				JdbcHelper.closeResultSet(resultSet);
				JdbcHelper.closePreparedStatement(preparedStatement);
				JdbcHelper.closeConnection(connection);
			}
			return regCustomerListMap;
		}
		
		
		public HashMap<Integer, String> consumerCustomerList() throws RecordNotFoundException {

			HashMap<Integer, String> consumerCustomerListMap = new HashMap<Integer, String>();

			try {

				connection = getConnection();
				preparedStatement = connection
						.prepareStatement(QueryMaker.GET_CONSUMER_CUSTOMER_LIST);
				resultSet = preparedStatement.executeQuery();

				while (resultSet.next()) {
					consumerCustomerListMap.put(resultSet.getInt("CON_CUSTOMER_ID"),
							resultSet.getString("CON_FULL_NAME"));
				}
			} catch (SQLException sqlException) {

				log.error(
						ListHelper.class
								+ ": Error:- While preparing statement to get consumer customer data from database.",
						sqlException);
			} catch (Exception exception) {

				log.error(ListHelper.class
						+ ": Error:- While getting connection for consumer from database.",
						exception);
			} finally {
				JdbcHelper.closeResultSet(resultSet);
				JdbcHelper.closePreparedStatement(preparedStatement);
				JdbcHelper.closeConnection(connection);
			}
			return consumerCustomerListMap;
		}
		
		
		public JSONObject getRegularCustomerDetail(int customerId) {

			JSONObject customerDetailList = null;
			JSONObject object =null;
			try {
				
				String query = QueryMaker.GET_CUSTOMER_ADDRESS_PHONE_LIST;
				connection = getConnection();
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setInt(1, customerId);
				resultSet = preparedStatement.executeQuery();
				//JSONArray array = new JSONArray();
				customerDetailList = new JSONObject();

				while (resultSet.next()) {
					object= new JSONObject();

					String address = nameHelper.getCityNameByCityId(resultSet.getInt("REG_CITY"));
					String contact = resultSet
							.getString("REG_PHONE_NO");
					String state = nameHelper.getStateNameByStateId(resultSet.getInt("REG_STATE"));
					
					object.put("custAddress", address);
					object.put("custContact", contact);
					object.put("custState", state);
					//array.add(object);
					
				}
				customerDetailList.put("regularCustomer", object);
			} catch (Exception exception) {

				log.error(ListHelper.class
						+ ": Error:- While getting customer contact and customer address From Database."+exception);
			} finally {
				try {
					if (null != connection) {
						resultSet.close();
						preparedStatement.close();
						connection.close();
					}
				} catch (SQLException sqlExp) {
					log.error(ListHelper.class
							+ ": Error:- While closing the Connection after getting customer contact and customer addressFrom Database.");
				}
			}
			return customerDetailList;
		}
		
		
		
		public JSONObject getConsumerCustomerDetail(int customerId) {
			PreparedStatement	preparedStatements=null;
			JSONObject consumerDetailList = null;
			JSONObject objects =null;
			try {
				System.out.println("listhelper");
				String query = QueryMaker.GET_CONSUMER_ADDRESS_PHONE_LIST;
				connection = getConnection();
					preparedStatements = connection.prepareStatement(query);
				preparedStatements.setInt(1, customerId);
				resultSet = preparedStatements.executeQuery();
				//JSONArray array = new JSONArray();
				consumerDetailList = new JSONObject();
				
				while (resultSet.next()) {
					objects= new JSONObject();

					String address = resultSet.getString("CON_ADDRESS_LINE_1");
					String contact = resultSet
							.getString("CON_PHONE_NO");
					String state = resultSet
							.getString("CON_STATE");
					
					objects.put("consuAddress", address);
					objects.put("consuContact", contact);
					objects.put("consuState", state);
					//array.add(object);
					
					
				}
				consumerDetailList.put("consumerCustomer", objects);
			} catch (NullPointerException npe) {

				log.error(ListHelper.class
						+ ": Error:- While getting consumer contact and consumer address From Database."+npe);	
			} catch (SQLException sqlExp) {
				log.error(ListHelper.class
						+ ": Error:- While closing the Connection after getting consumer contact and consumer address From Database.");
				
			} catch (Exception exception) {

				log.error(ListHelper.class
						+ ": Error:- While getting consumer contact and consumer address From Database."+exception);
			} finally {
				JdbcHelper.closeResultSet(resultSet);
				JdbcHelper.closePreparedStatement(preparedStatements);
				JdbcHelper.closeConnection(connection);
				
			}
			return consumerDetailList;
		}


		public HashMap<Integer, String> shopList() throws RecordNotFoundException {

			HashMap<Integer, String> shopListMap = new HashMap<Integer, String>();

			try {

				connection = getConnection();
				preparedStatement = connection
						.prepareStatement(QueryMaker.GET_SHOP_LIST);
				resultSet = preparedStatement.executeQuery();

				while (resultSet.next()) {
					shopListMap.put(resultSet.getInt("SHOP_ID"),
							resultSet.getString("SHOP_NAME"));
				}
			} catch (SQLException sqlException) {

				log.error(
						ListHelper.class
								+ ": Error:- While preparing statement to get shop data from database.",
						sqlException);
			} catch (Exception exception) {

				log.error(ListHelper.class
						+ ": Error:- While getting connection for shop from database.",
						exception);
			} finally {
				JdbcHelper.closeResultSet(resultSet);
				JdbcHelper.closePreparedStatement(preparedStatement);
				JdbcHelper.closeConnection(connection);
			}
			return shopListMap;
		}
		
		public HashMap<Integer, String> dealerList() throws RecordNotFoundException {

			HashMap<Integer, String> dealerListMap = new HashMap<Integer, String>();

			try {

				connection = getConnection();
				preparedStatement = connection
						.prepareStatement(QueryMaker.GET_DEALER_LIST);
				resultSet = preparedStatement.executeQuery();

				while (resultSet.next()) {
					dealerListMap.put(resultSet.getInt("DEALER_ID"),
							resultSet.getString("DEALER_FULL_NAME"));
				}
			} catch (SQLException sqlException) {

				log.error(
						ListHelper.class
								+ ": Error:- While preparing statement to get dealer data from database.",
						sqlException);
			} catch (Exception exception) {

				log.error(ListHelper.class
						+ ": Error:- While getting connection for dealer data from database.",
						exception);
			} finally {
				JdbcHelper.closeResultSet(resultSet);
				JdbcHelper.closePreparedStatement(preparedStatement);
				JdbcHelper.closeConnection(connection);
			}
			return dealerListMap;
		}	
		
		
		public JSONObject getDealerDetail(int dealerId) {

			JSONObject dealerDetailList = null;
			JSONObject object =null;
			try {
				
				String query = QueryMaker.GET_DEALER_ADDRESS_PHONE_LIST;
				connection = getConnection();
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setInt(1, dealerId);
				resultSet = preparedStatement.executeQuery();
				//JSONArray array = new JSONArray();
				dealerDetailList = new JSONObject();
				System.out.println("hhhhhheeeeeeeeeeeeeeeeee");
				while (resultSet.next()) {
					object= new JSONObject();

					String address = resultSet.getString("DEALER_ADDRESS_LINE_1");
					String contact = resultSet
							.getString("DEALER_MOBILE_NO");
					System.out.println("hhhhhhhhhhhhhhhhhh"+resultSet.getString("DEALER_ADDRESS_LINE_1"));
					
					object.put("dealerAddress", address);
					object.put("dealerContact", contact);
					
					//array.add(object);
					
				}
				dealerDetailList.put("dealer", object);
			} catch (Exception exception) {

				log.error(ListHelper.class
						+ ": Error:- While getting dealer contact and dealer details From Database."+exception);
			} finally {
				try {
					if (null != connection) {
						resultSet.close();
						preparedStatement.close();
						connection.close();
					}
				} catch (SQLException sqlExp) {
					log.error(ListHelper.class
							+ ": Error:- While closing the Connection after getting dealer contact and dealer address From Database.");
				}
			}
			return dealerDetailList;
		}

		public Map<Integer, String> getPaymentModeList() {
			HashMap<Integer, String> payModeListMap = new HashMap<Integer, String>();

			try {

				connection = getConnection();
				preparedStatement = connection
						.prepareStatement(QueryMaker.GET_PAY_MODE_LIST);
				resultSet = preparedStatement.executeQuery();

				while (resultSet.next()) {
					payModeListMap.put(resultSet.getInt("PAY_MODE_ID"),
							resultSet.getString("PAY_MODE_NAME"));
				}
			} catch (SQLException sqlException) {

				log.error(
						ListHelper.class
								+ ": Error:- While preparing statement to get payment Mode from database.",
						sqlException);
			} catch (Exception exception) {

				log.error(ListHelper.class
						+ ": Error:- While getting connection for payment Mode from database.",
						exception);
			} finally {
				JdbcHelper.closeResultSet(resultSet);
				JdbcHelper.closePreparedStatement(preparedStatement);
				JdbcHelper.closeConnection(connection);
			}
			return payModeListMap;
		}
		
		public Map<Integer, String> getStateList() {
			HashMap<Integer, String> stateListMap = new HashMap<Integer, String>();

			try {

				connection = getConnection();
				preparedStatement = connection
						.prepareStatement(QueryMaker.GET_STATE_LIST);
				resultSet = preparedStatement.executeQuery();

				while (resultSet.next()) {
					stateListMap.put(resultSet.getInt("CITY_ID"),
							resultSet.getString("CITY_STATE"));
				}
			} catch (SQLException sqlException) {

				log.error(
						ListHelper.class
								+ ": Error:- While preparing statement to get state name from database.",
						sqlException);
			} catch (Exception exception) {

				log.error(ListHelper.class
						+ ": Error:- While getting connection for state Name from database.",
						exception);
			} finally {
				JdbcHelper.closeResultSet(resultSet);
				JdbcHelper.closePreparedStatement(preparedStatement);
				JdbcHelper.closeConnection(connection);
			}
			return stateListMap;
		}

		public JSONObject cityListJSON(String stateName) {
			PreparedStatement	preparedStatements=null;
			JSONObject cityList = null;
			JSONArray array = new JSONArray();
			try {
				System.out.println("listhelper");
				String query = QueryMaker.GET_CITY_LIST_BY_STATE_NAME;
				connection = getConnection();
					preparedStatements = connection.prepareStatement(query);
				preparedStatements.setString(1, stateName);
				resultSet = preparedStatements.executeQuery();
				//JSONArray array = new JSONArray();
				cityList = new JSONObject();
				
				while (resultSet.next()) {
					JSONObject objects = new JSONObject();

					String id = resultSet.getString("CITY_ID");
					String name = resultSet
							.getString("CITY_NAME");
					
					
					objects.put("cityId", id);
					objects.put("cityName", name);
					
					array.add(objects);
					
					
				}
				
				cityList.put("city", array);
			} catch (NullPointerException npe) {

				log.error(ListHelper.class
						+ ": Error:- While getting city list From Database."+npe);	
			} catch (SQLException sqlExp) {
				log.error(ListHelper.class
						+ ": Error:- While closing the Connection after getting city list From Database.");
				
			} catch (Exception exception) {

				log.error(ListHelper.class
						+ ": Error:- While getting city list From Database."+exception);
			} finally {
				JdbcHelper.closeResultSet(resultSet);
				JdbcHelper.closePreparedStatement(preparedStatements);
				JdbcHelper.closeConnection(connection);
				
			}
			return cityList;
		}

		public Map<Integer, String> getCityList() {
			HashMap<Integer, String> stateListMap = new HashMap<Integer, String>();

			try {

				connection = getConnection();
				preparedStatement = connection
						.prepareStatement(QueryMaker.GET_CITY_LIST);
				resultSet = preparedStatement.executeQuery();

				while (resultSet.next()) {
					stateListMap.put(resultSet.getInt("CITY_ID"),
							resultSet.getString("CITY_NAME"));
				}
			} catch (SQLException sqlException) {

				log.error(
						ListHelper.class
								+ ": Error:- While preparing statement to get city List from database.",
						sqlException);
			} catch (Exception exception) {

				log.error(ListHelper.class
						+ ": Error:- While getting connection for city List from database.",
						exception);
			} finally {
				JdbcHelper.closeResultSet(resultSet);
				JdbcHelper.closePreparedStatement(preparedStatement);
				JdbcHelper.closeConnection(connection);
			}
			return stateListMap;
		}

		public HashMap<Integer, String> getProductItemName() {
			HashMap<Integer, String> nameListMap = new HashMap<Integer, String>();

			try {

				connection = getConnection();
				preparedStatement = connection
						.prepareStatement(QueryMaker.GET_PRODUCT_NAME_LIST_FROM_CATEGORY);
				resultSet = preparedStatement.executeQuery();

				while (resultSet.next()) {
					nameListMap.put(resultSet.getInt("PRODUCT_CATEGORY_ID"),
							resultSet.getString("PRODUCT_CATEGORY_NAME"));
					
					System.out.println(resultSet.getInt("PRODUCT_CATEGORY_ID")+"OOOOOOOOOO");
				}
			} catch (SQLException sqlException) {

				log.error(
						ListHelper.class
								+ ": Error:- While preparing statement to get product name List from database.",
						sqlException);
			} catch (Exception exception) {

				log.error(ListHelper.class
						+ ": Error:- While getting connection for product name List from database.",
						exception);
			} finally {
				JdbcHelper.closeResultSet(resultSet);
				JdbcHelper.closePreparedStatement(preparedStatement);
				JdbcHelper.closeConnection(connection);
			}
			return nameListMap;
		}

		public HashMap<Integer, String> getProductCategoryList() {
			HashMap<Integer, String> nameListMap = new HashMap<Integer, String>();

			try {

				connection = getConnection();
				preparedStatement = connection
						.prepareStatement(QueryMaker.GET_PRODUCT_TYPE_BASED_ON_PRODUCT);
				resultSet = preparedStatement.executeQuery();

				while (resultSet.next()) {
					nameListMap.put(resultSet.getInt("CEMENT_TYPE_ID"),
							resultSet.getString("CEMENT_TYPE_NAME"));
				}
			} catch (SQLException sqlException) {

				log.error(
						ListHelper.class
								+ ": Error:- While preparing statement to get product type List from database.",
						sqlException);
			} catch (Exception exception) {

				log.error(ListHelper.class
						+ ": Error:- While getting connection for product type List from database.",
						exception);
			} finally {
				JdbcHelper.closeResultSet(resultSet);
				JdbcHelper.closePreparedStatement(preparedStatement);
				JdbcHelper.closeConnection(connection);
			}
			return nameListMap;
		}

		public JSONObject getProductTypJSONeList(int categoryId) {
			PreparedStatement	preparedStatements=null;
			JSONObject typeList = null;
			JSONArray array = new JSONArray();
			try {
				System.out.println("listhelper");
				String query = QueryMaker.GET_TYPE_LIST_BY_CATEGORY;
				connection = getConnection();
					preparedStatements = connection.prepareStatement(query);
				preparedStatements.setInt(1, categoryId);
				resultSet = preparedStatements.executeQuery();
				//JSONArray array = new JSONArray();
				typeList = new JSONObject();
				
				while (resultSet.next()) {
					JSONObject objects = new JSONObject();

					String id = resultSet.getString("CEMENT_TYPE_ID");
					String name = resultSet
							.getString("CEMENT_TYPE_NAME");
					
					
					objects.put("typeId", id);
					objects.put("typeName", name);
					
					array.add(objects);
					
					
				}
				
			typeList.put("type", array);
			} catch (NullPointerException npe) {

				log.error(ListHelper.class
						+ ": Error:- While getting type list From Database."+npe);	
			} catch (SQLException sqlExp) {
				log.error(ListHelper.class
						+ ": Error:- While closing the Connection after getting type list From Database."+sqlExp);
				
			} catch (Exception exception) {

				log.error(ListHelper.class
						+ ": Error:- While getting type list From Database."+exception);
			} finally {
				JdbcHelper.closeResultSet(resultSet);
				JdbcHelper.closePreparedStatement(preparedStatements);
				JdbcHelper.closeConnection(connection);
				
			}
			return typeList;
		}

		public Map<Integer, String> getCementTypeList() {
			HashMap<Integer, String> typeListMap = new HashMap<Integer, String>();

			try {

				connection = getConnection();
				preparedStatement = connection
						.prepareStatement(QueryMaker.GET_CEMENT_TYPE_LIST);
				
				resultSet = preparedStatement.executeQuery();

				while (resultSet.next()) {
					typeListMap.put(resultSet.getInt("PRODUCT_ID"),
							nameHelper.getProductTypeNameByProductId(resultSet.getInt("PRODUCT_NAME")));
					
					System.out.println(resultSet.getString("PRODUCT_NAME")+"gggggggggggggggggggggggg");
				}
			} catch (SQLException sqlException) {

				log.error(
						ListHelper.class
								+ ": Error:- While preparing statement to get cement type List from database.",
						sqlException);
			} catch (Exception exception) {

				log.error(ListHelper.class
						+ ": Error:- While getting connection for cement type List from database.",
						exception);
			} finally {
				JdbcHelper.closeResultSet(resultSet);
				JdbcHelper.closePreparedStatement(preparedStatement);
				JdbcHelper.closeConnection(connection);
			}
			return typeListMap;
		}

		public Map<Integer, String> getSteelbarTypeList() {
			HashMap<Integer, String> typeListMap = new HashMap<Integer, String>();

			try {

				connection = getConnection();
				preparedStatement = connection
						.prepareStatement(QueryMaker.GET_STEELBAR_TYPE_LIST);
				
				resultSet = preparedStatement.executeQuery();

				while (resultSet.next()) {
					typeListMap.put(resultSet.getInt("PRODUCT_ID"),
							nameHelper.getProductTypeNameByProductId(resultSet.getInt("PRODUCT_NAME")));
					
					System.out.println(resultSet.getString("PRODUCT_NAME")+"gggggggggggggggggggggggg");
				}
			} catch (SQLException sqlException) {

				log.error(
						ListHelper.class
								+ ": Error:- While preparing statement to get cement type List from database.",
						sqlException);
			} catch (Exception exception) {

				log.error(ListHelper.class
						+ ": Error:- While getting connection for cement type List from database.",
						exception);
			} finally {
				JdbcHelper.closeResultSet(resultSet);
				JdbcHelper.closePreparedStatement(preparedStatement);
				JdbcHelper.closeConnection(connection);
			}
			return typeListMap;
		}
		
		
		public HashMap<Integer, String> paymentSelectList() throws Exception {

			HashMap<Integer, String> paymentSelectListMap = new HashMap<Integer, String>();

			try {

				connection = getConnection();
				preparedStatement = connection
						.prepareStatement(QueryMaker.GET_PAYMENTSELECT_LIST);
				resultSet = preparedStatement.executeQuery();

				while (resultSet.next()) {
					paymentSelectListMap.put(resultSet.getInt("PAYMENTSELECT_ID"),
							resultSet.getString("PAYMENTSELECT_NAME"));
				}
			} catch (SQLException sqlException) {

				log.error(
						ListHelper.class
								+ ": Error:- While preparing statement to get country data from database.",
						sqlException);
			} catch (Exception exception) {

				log.error(ListHelper.class
						+ ": Error:- While getting connection for database.",
						exception);
			} finally {
				JdbcHelper.closeResultSet(resultSet);
				JdbcHelper.closePreparedStatement(preparedStatement);
				JdbcHelper.closeConnection(connection);
			}
			return paymentSelectListMap;
		}
		
		
		public HashMap<Integer, String> getTransportList() throws Exception {

			HashMap<Integer, String> paymentSelectListMap = new HashMap<Integer, String>();

			try {

				connection = getConnection();
				preparedStatement = connection
						.prepareStatement(QueryMaker.GET_TRANSPORT_LIST);
				resultSet = preparedStatement.executeQuery();

				while (resultSet.next()) {
					paymentSelectListMap.put(resultSet.getInt("TRANSPORT_ID"),
							resultSet.getString("TRANSPORT_NAME"));
				}
			} catch (SQLException sqlException) {

				log.error(
						ListHelper.class
								+ ": Error:- While preparing statement to get transport data from database.",
						sqlException);
			} catch (Exception exception) {

				log.error(ListHelper.class
						+ ": Error:- While getting connection for database.",
						exception);
			} finally {
				JdbcHelper.closeResultSet(resultSet);
				JdbcHelper.closePreparedStatement(preparedStatement);
				JdbcHelper.closeConnection(connection);
			}
			return paymentSelectListMap;
		}


}
