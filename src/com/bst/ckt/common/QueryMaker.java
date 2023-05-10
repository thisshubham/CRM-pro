/*
 ********************************************************************************
 *
 * COPYRIGHT. $ID$ 2014. ALL RIGHTS RESERVED.
 *
 * This software is only to be used for the purpose for which it has been
 * provided. No part of it is to be reproduced, disassembled, transmitted,
 * stored in a retrieval system nor translated in any human or computer
 * language in any way or for any other purposes whatsoever without the
 * prior written consent of $ID$.
 * 
 * Class Name     QueryMaker.java     
 *                                                            
 * Creation Date  OCT 4, 2014 
 * 
 * Abstract       QueryMaker class contains SQL queries for User Management
 * 
 * Amendment History (in chronological sequence): OCT 4, 2014
 * 
 *********************************************************************************
 */
package com.bst.ckt.common;

/**
 * 
 * @author Yogendra Singh Rajput
 * @version 1.0
 * 
 */
public class QueryMaker {

	/**
	 * <p>
	 * <code>GET_COUNTRY_LIST</code> token is representing the constants for SQL
	 * query, which is fetching
	 * 
	 * <pre>
	 * COUNTRY_ID,COUNTRY_DISPLAY_NAME
	 * </pre>
	 * 
	 * records from <code>TAB_COUNTRY</code> .
	 */
	public static final String GET_COUNTRY_LIST = "SELECT COUNTRY_ID,COUNTRY_DISPLAY_NAME FROM TAB_COUNTRY";

	/**
	 * <p>
	 * <code>GET_MOBILE_NUMBER_BY_MOBILE_NO</code> token is representing the
	 * constants for SQL query, which is fetching mobile no from
	 * <code>TAB_COMPANY_DETAILS</code> based on the mobile no.
	 */
	public static final String GET_COMPANY_MOBILE_NUMBER = "SELECT MOBILE_NO FROM TAB_COMPANY_DETAILS "
			+ "WHERE MOBILE_NO=?";

	/**
	 * <p>
	 * <code>GET_COMPANY_EMAIL</code> token is representing the constants for
	 * SQL query, which is fetching company email id from
	 * <code>TAB_COMPANY_DETAILS</code> based on the company email id
	 */
	public static final String GET_COMPANY_PRIMARY_EMAIL = "SELECT COMPANY_EMAIL_ID FROM TAB_COMPANY_DETAILS "
			+ "WHERE COMPANY_EMAIL_ID=?";

	/**
	 * <p>
	 * <code>GET_COMPANY_EMAIL</code> token is representing the constants for
	 * SQL query, which is fetching company email id from
	 * <code>TAB_COMPANY_DETAILS</code> based on the company email id
	 */
	public static final String INSERT_SOCIAL_SITE = "INSERT INTO TAB_LEAD_SOCIAL_CONTACT (SOCIAL_CONTACT_REF,LEAD_SOCIAL_VALUE) VALUES (?,?)";

	/**
	 * 
	 */
	public static final String GET_SOCIAL_SITE_LIST = "SELECT SOCIAL_SITE_ID,SOCIAL_SITE_VALUE FROM TAB_SOCIAL_SITE";

	/**
	 * 
	 */
	public static final String INSERT_CUSTOMER_DETAILS = "INSERT INTO TAB_CUSTOMER_TEMP(FULL_NAME, EMAIL_ID,MOBILE_NO,COMPANY_NAME,REG_REF_NO,USER_ROLE,IP_ADDRESS,EMAIL_FLAG,CREATED_DATE,CREATED_BY,COUNTRY )VALUES(?,?,?,?,?,?,?,?,?,?,?)";

	/**
	 * 
	 */
	public static final String UPDATE_EMAIL_FLAG_CUSTOMER_TEMP = "UPDATE TAB_CUSTOMER_TEMP SET EMAIL_FLAG=? WHERE REG_REF_NO=?";

	/**
	 * 
	 */
	public static final String GET_CUSTOMER_DETAILS_BY_REFNO = "SELECT REG_ID,FULL_NAME, EMAIL_ID,MOBILE_NO,"
			+ "COMPANY_NAME,REG_REF_NO,	USER_ROLE,COUNTRY,IP_ADDRESS,EMAIL_FLAG,CREATED_DATE,CREATED_BY FROM TAB_CUSTOMER_TEMP "
			+ "WHERE REG_REF_NO=?";

	/**
	 * <p>
	 * <code>GET_LEAD_TITLE_LIST</code> token is representing the constants for
	 * SQL query, which is fetching records from <code>TAB_LEAD_TITLE</code> .
	 */
	public static final String GET_LEAD_TITLE_LIST = "SELECT LEAD_TITLE_ID,LEAD_TITLE_SUBJECT FROM TAB_LEAD_TITLE";

	/**
	 * <p>
	 * <code>GET_COMPANY_TYPE_LIST</code> token is representing the constants
	 * for SQL query, which is fetching records from
	 * <code>TAB_COMPANY_TYPE</code> .
	 */
	public static final String GET_COMPANY_TYPE_LIST = "SELECT COMPANY_TYPE_ID,COMPANY_TYPE_NAME FROM TAB_COMPANY_TYPE";

	/**
	 * <p>
	 * <code>GET_COMPANY_CATEGORY_LIST</code> token is representing the
	 * constants for SQL query, which is fetching records from
	 * <code>TAB_COMPANY_CATEGORY</code> .
	 */
	public static final String GET_COMPANY_CATEGORY_LIST = "SELECT COMPANY_CATEGORY_ID,COMPANY_CATEGORY_NAME FROM TAB_COMPANY_CATEGORY";

	/**
	 * <p>
	 * <code>GET_COMPANY_SECTOR_LIST</code> token is representing the constants
	 * for SQL query, which is fetching records from
	 * <code>TAB_COMPANY_SECTOR</code> .
	 */
	public static final String GET_COMPANY_SECTOR_LIST = "SELECT COMPANY_SECTOR_ID,COMPANY_SECTOR_NAME FROM TAB_COMPANY_SECTOR";

	/**
	 * <p>
	 * <code>GET_LEAD_DETAILS_LIST</code> token is representing the constants
	 * for SQL query, which is fetching records from
	 * <code>TAB_LEAD_DETAILS</code> .
	 */
	public static final String GET_LEAD_DETAILS_LIST = "SELECT LEAD_ID,COMPANY_NAME,LEAD_TITLE_REF,SALUTATION,"
			+ "CONTACT_PERSON,LEAD_OWNER_REF,LEAD_DATE,EXPECTED_CLOSING_DATE,LEAD_STATUS,CREATED_BY FROM TAB_LEAD_DETAILS";

	/**
	 * <p>
	 * <code>SHOW_LEAD_PRINT_PDF</code> token is representing the constants for
	 * SQL query, which is fetching records from <code>TAB_LEAD_DETAILS</code> .
	 */
	public static final String SHOW_LEAD_PRINT_PDF = "SELECT * FROM TAB_LEAD_DETAILS WHERE LEAD_ID=?";

	/**
	 * <p>
	 * <code>SHOW_NOTE_PRINT_PDF</code> token is representing the constants for
	 * SQL query, which is fetching records from <code>TAB_NOTE</code> .
	 */
	public static final String SHOW_NOTE_PRINT_PDF = "SELECT * FROM TAB_NOTE WHERE NOTE_ID=?";

	/**
	 * <p>
	 * <code>SHOW_VENDOR_PRINT_PDF</code> token is representing the constants
	 * for SQL query, which is fetching records from <code>TAB_VENDORS</code> .
	 */
	public static final String SHOW_VENDOR_PRINT_PDF = "SELECT * FROM TAB_VENDORS WHERE VENDOR_ID=?";

	/**
	 * <p>
	 * <code>GET_CURRENCY_LIST</code> token is representing the constants for
	 * SQL query, which is fetching
	 * 
	 * <pre>
	 * CURRENCY_ID,CURRENCY_DISPLAY_NAME
	 * </pre>
	 * 
	 * records from <code>TAB_CURRENCY</code> .
	 */
	public static final String GET_CURRENCY_LIST = "SELECT CURRENCY_ID,CURRENCY_DISPLAY_NAME FROM TAB_CURRENCY";

	/**
	 * <p>
	 * <code>GET_COMPANY_NAME</code> token is representing the constants for SQL
	 * query, which is fetching
	 * 
	 * <pre>
	 * COMPANY_NAME
	 * </pre>
	 * 
	 * from <code>TAB_COMPANY_DETAILS</code> .
	 */
	public static final String GET_COMPANY_NAME = "SELECT COMPANY_NAME FROM TAB_COMPANY_DETAILS WHERE COMPANY_ID=?";

	/**
	 * <p>
	 * <code>GET_COMPANY_TYPE_NAME</code> token is representing the constants
	 * for SQL query, which is fetching
	 * 
	 * <pre>
	 * COMPANY_TYPE_NAME
	 * </pre>
	 * 
	 * from <code>TAB_COMPANY_TYPE</code> .
	 */
	public static final String GET_COMPANY_TYPE_NAME = "SELECT COMPANY_TYPE_NAME FROM TAB_COMPANY_TYPE WHERE COMPANY_TYPE_ID=?";

	/**
	 * <p>
	 * <code>GET_COMPANY_CATEGORY_NAME</code> token is representing the
	 * constants for SQL query, which is fetching
	 * 
	 * <pre>
	 * COMPANY_CATEGORY_NAME
	 * </pre>
	 * 
	 * from <code>TAB_COMPANY_CATEGORY</code> .
	 */
	public static final String GET_COMPANY_CATEGORY_NAME = "SELECT COMPANY_CATEGORY_NAME FROM TAB_COMPANY_CATEGORY WHERE COMPANY_CATEGORY_ID=?";

	/**
	 * <p>
	 * <code>GET_COMPANY_SECTOR_NAME</code> token is representing the constants
	 * for SQL query, which is fetching
	 * 
	 * <pre>
	 * COMPANY_SECTOR_NAME
	 * </pre>
	 * 
	 * from <code>TAB_COMPANY_SECTOR</code> .
	 */
	public static final String GET_COMPANY_SECTOR_NAME = "SELECT COMPANY_SECTOR_NAME FROM TAB_COMPANY_SECTOR WHERE COMPANY_SECTOR_ID=?";

	/**
	 * <p>
	 * <code>GET_LEAD_TITLE_SUBJECT</code> token is representing the constants
	 * for SQL query, which is fetching
	 * 
	 * <pre>
	 * LEAD_TITLE_SUBJECT
	 * </pre>
	 * 
	 * from <code>TAB_LEAD_TITLE</code> .
	 */
	public static final String GET_LEAD_TITLE_SUBJECT = "SELECT LEAD_TITLE_SUBJECT FROM TAB_LEAD_TITLE WHERE LEAD_TITLE_ID=?";

	/**
	 * <p>
	 * <code>GET_LEAD_STATUS_NAME</code> token is representing the constants for
	 * SQL query, which is fetching
	 * 
	 * <pre>
	 * LEAD_STATUS_NAME
	 * </pre>
	 * 
	 * from <code>TAB_LEAD_STATUS</code> .
	 */
	public static final String GET_LEAD_STATUS_NAME = "SELECT LEAD_STATUS_NAME FROM TAB_LEAD_STATUS WHERE LEAD_STATUS_ID=?";

	/**
	 * <p>
	 * <code>GET_SOCIAL_SITE_VALUE</code> token is representing the constants
	 * for SQL query, which is fetching
	 * 
	 * <pre>
	 * SOCIAL_SITE_VALUE
	 * </pre>
	 * 
	 * from <code>TAB_SOCIAL_SITE</code> .
	 */
	public static final String GET_SOCIAL_SITE_VALUE = "SELECT SOCIAL_SITE_VALUE FROM TAB_SOCIAL_SITE WHERE SOCIAL_SITE_ID=?";

	/**
	 * <p>
	 * <code>GET_COUNTRY_DISPLAY_NAME</code> token is representing the constants
	 * for SQL query, which is fetching
	 * 
	 * <pre>
	 * COUNTRY_DISPLAY_NAME
	 * </pre>
	 * 
	 * from <code>TAB_COUNTRY</code> .
	 */
	public static final String GET_COUNTRY_DISPLAY_NAME = "SELECT COUNTRY_DISPLAY_NAME FROM TAB_COUNTRY WHERE COUNTRY_ID=?";

	/**
	 * <p>
	 * <code>GET_CUSTOMER_USER_DETAILS_BY_EMAIL_ID</code> token is representing
	 * the constants for SQL query, which is fetching customer details based on
	 * logged in email id and password. if email id and password will match with
	 * database then we will get data else no result found from
	 * <code>TAB_CUSTOMER_USER</code> .
	 */
	public static final String GET_CUSTOMER_USER_DETAILS_BY_EMAIL_ID = "SELECT CUSTOMER_ID,PASSWORD,SALUTATION,FULL_NAME,GENDER,"
			+ "DATE_OF_BIRTH,REF_COMPANY,ADDRESS_LINE_1,ADDRESS_LINE_2,CITY,STATE,ZIPCODE,PRIMARY_EMAIL_ID,"
			+ "ALTERNATE_EMAIL_ID,PHONE_STD,PHONE_NO,MOBILE_NO,FAX_STD,FAX_NO,SOCIAL_IM_ID,PROFILE_IMAGE_PATH,REF_SOURCE,"
			+ "REF_COUNTRY,CREATION_DATE,CREATED_BY,REF_BUSSINESS_FUNCTION,REF_SECURITY_QUESTION_ID,ANSWER,"
			+ "USER_ROLE,USER_STATUS,LOGIN_FLAG, ACL_ID FROM TAB_CUSTOMER_USER WHERE PRIMARY_EMAIL_ID=?";

	/**
	 * <p>
	 * <code>GET_CUSTOMER_PRIMARY_EMAIL</code> token is representing the
	 * constants for SQL query, which is fetching customer details based on
	 * logged in email id and password. if email id and password will match with
	 * database then we will get data else no result found from
	 * <code>TAB_CUSTOMER_USER</code> .
	 */
	public static final String GET_CUSTOMER_PRIMARY_EMAIL = "SELECT PRIMARY_EMAIL_ID FROM TAB_CUSTOMER_USER "
			+ "WHERE PRIMARY_EMAIL_ID=?";

	/**
	 * <p>
	 * <code>VIEW_LEAD_XLS_REPORT</code> token is representing the constants for
	 * SQL query, which is fetching
	 * 
	 * <pre>
	 * ALL Records
	 * </pre>
	 * 
	 * from <code>TAB_LEAD_DETAILS</code> .
	 */
	public static final String VIEW_LEAD_XLS_REPORT = "SELECT * FROM TAB_LEAD_DETAILS";

	/**
	 * <p>
	 * <code>VIEW_NOTE_XLS_REPORT</code> token is representing the constants for
	 * SQL query, which is fetching
	 * 
	 * <pre>
	 * ALL Records
	 * </pre>
	 * 
	 * from <code>TAB_LEAD_DETAILS</code> .
	 */
	public static final String VIEW_NOTE_XLS_REPORT = "SELECT * FROM TAB_NOTE";

	/**
	 * <p>
	 * <code>VIEW_VENDOR_XLS_REPORT</code> token is representing the constants
	 * for SQL query, which is fetching
	 * 
	 * <pre>
	 * ALL Records
	 * </pre>
	 * 
	 * from <code>TAB_VENDORS</code> .
	 */
	public static final String VIEW_VENDOR_XLS_REPORT = "SELECT * FROM TAB_VENDORS";

	/**
	 * <p>
	 * <code>VIEW_LEAD_REPORT</code> token is representing the constants for SQL
	 * query, which is fetching
	 * 
	 * <pre>
	 * ALL Records
	 * </pre>
	 * 
	 * from <code>TAB_LEAD_DETAILS</code> .
	 */
	public static final String VIEW_LEAD_REPORT = "SELECT * FROM TAB_LEAD_DETAILS";

	/**
	 * <p>
	 * <code>GET_LEAD_SOURCE_LIST</code> token is representing the constants for
	 * SQL query, which is fetching
	 * 
	 * <pre>
	 * LEAD_SOURCE_ID,LEAD_SOURCE_NAME
	 * </pre>
	 * 
	 * records from <code>TAB_LEAD_SOURCE</code> .
	 */
	public static final String GET_LEAD_SOURCE_LIST = "SELECT LEAD_SOURCE_ID,LEAD_SOURCE_NAME FROM TAB_LEAD_SOURCE";
	/**
	 * <p>
	 * <code>INSERT_LEAD_TITLE</code> token is representing the constants for
	 * SQL query, which is insert lead Title in <code>TAB_LEAD_TITLE</code>
	 * table
	 */
	public static final String INSERT_LEAD_TITLE = "INSERT INTO TAB_LEAD_TITLE(LEAD_TITLE_SUBJECT) VALUES(?) ";

	/**
	 * <p>
	 * <code>SHOW_LIST_LEAD_TITLE</code> token is representing the constants for
	 * SQL query, which is fetching lead Title in <code>TAB_LEAD_TITLE</code>
	 * table
	 */
	public static final String SHOW_LIST_LEAD_TITLE = "SELECT LEAD_TITLE_SUBJECT FROM TAB_LEAD_TITLE";

	/**
	 * <p>
	 * <code>GET_CUSTOMER_NAME_LIST</code> token is representing the constants
	 * for SQL query, which is fetching
	 * 
	 * <pre>
	 * CUSTOMER_ID,FULL_NAME
	 * </pre>
	 * 
	 * from <code>TAB_CUSTOMER_USER</code> .
	 */
	public static final String GET_CUSTOMER_NAME_LIST = "SELECT CUSTOMER_ID,FULL_NAME FROM TAB_CUSTOMER_USER";

	/**
	 * 
	 */
	public static final String CREATE_CUSTOMER_COMPANY = "INSERT INTO TAB_COMPANY_DETAILS (COMPANY_REF_NO,COMPANY_NAME,"
			+ "MOBILE_NO,COMPANY_EMAIL_ID,REF_COUNTRY,CREATION_DATE,CREATED_BY,IP_REF_ADDRESS,COMPANY_STATUS) "
			+ "VALUES(?,?,?,?,?,?,?,?,?)";

	/**
	 * 
	 */
	public static final String GET_COMPNAY_ID_BY_REFNO = "SELECT COMPANY_ID FROM TAB_COMPANY_DETAILS "
			+ "WHERE COMPANY_REF_NO =?";

	/**
	 * 
	 */
	public static final String CREATE_CUSTOMER = "INSERT INTO TAB_CUSTOMER_USER (PASSWORD, FULL_NAME, REF_COMPANY, "
			+ "PRIMARY_EMAIL_ID, MOBILE_NO, REF_COUNTRY, CREATION_DATE, CREATED_BY, USER_ROLE, USER_STATUS, EMAIL_FLAG,LOGIN_FLAG) "
			+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";

	/**
	 * 
	 */
	public static final String UPDATE_EMAILFLAG_CUSTOMER_EMAILID = "UPDATE TAB_CUSTOMER_USER SET EMAIL_FLAG=? WHERE PRIMARY_EMAIL_ID=?";

	/**
	 * <p>
	 * <code>GET_CUSTOMER_ACCOUNT_INFORMATION</code> token is representing the
	 * constants for SQL query, which is fetching Customer information in
	 * <code>TAB_CUSTOMER_USER</code> table
	 */

	public static final String GET_CUSTOMER_ACCOUNT_INFORMATION = "SELECT CUSTOMER_ID,USER_STATUS,USER_ROLE,SALUTATION,FULL_NAME,"
			+ "DATE_OF_BIRTH,GENDER,PRIMARY_EMAIL_ID,ALTERNATE_EMAIL_ID,DESIGNATION,DEPARTMENT,WORK_LOCATION,"
			+ "ADDRESS_LINE_1,ADDRESS_LINE_2,CITY,STATE,REF_COUNTRY,ZIPCODE,PHONE_NO,MOBILE_NO,FAX_NO,WEBSITE,"
			+ "LANGUAGE,REF_CURRENCY,TIME_ZONE,PROFILE_IMAGE_PATH FROM TAB_CUSTOMER_USER WHERE CUSTOMER_ID=?";

	/**
	 * <p>
	 * <code>GET_LEAD_FOLLOWUP_DETAILS</code> token is representing the
	 * constants for SQL query, which is fetching
	 * 
	 * <pre>
	 * CUSTOMER_ID,FOLLOWUP_DATE,REF_FOLLOWUP_BY,FOLLOWUP_STATUS,COMMENT
	 * </pre>
	 * 
	 * from <code>TAB_LEAD_FOLLOWUP</code> .
	 */
	public static final String GET_LEAD_FOLLOWUP_DETAILS = "SELECT FOLLOWUP_ID,FOLLOWUP_DATE,FOLLOWUP_STATUS,"
			+ "REF_FOLLOWUP_BY,CREATED_BY,COMMENT FROM TAB_LEAD_FOLLOWUP WHERE REF_LEAD_ID=?";

	/**
	 * <p>
	 * <code>INSERT_LEAD_FOLLOWUP</code> token is representing the constants for
	 * SQL query, which is insert lead follow up in
	 * <code>TAB_LEAD_FOLLOWUP</code> table
	 */
	public static final String INSERT_LEAD_FOLLOWUP = "INSERT INTO TAB_LEAD_FOLLOWUP("
			+ "FOLLOWUP_DATE,REF_FOLLOWUP_BY,FOLLOWUP_STATUS,COMMENT,CREATED_BY,"
			+ "CREATION_DATE,REF_LEAD_ID) VALUES(?,?,?,?,?,?,?) ";

	/**
	 * <p>
	 * <code>GET_CUSTOMER_NAME</code> token is representing the constants for
	 * SQL query, which is fetching
	 * 
	 * <pre>
	 * FULL_NAME
	 * </pre>
	 * 
	 * from <code>TAB_CUSTOMER_USER</code> .
	 */
	public static final String GET_CUSTOMER_NAME = "SELECT SALUTATION,FULL_NAME FROM TAB_CUSTOMER_USER WHERE CUSTOMER_ID=?";

	/**
	 * <p>
	 * <code>INSERT_SOCIAL_INFORMATION</code> token is representing the
	 * constants for SQL query, which is inserting lead social information into
	 * <code>TAB_SOCIAL_CONTACT</code> table This query insert the four values
	 * into each records.
	 * <ul>
	 * <li><code>SOCIAL_SITE_REF</code> column contains the ref id from
	 * <code>SOCIAL_SITE_ID</code> from <code>TAB_SOCIAL_SITE</code></li>
	 * <li><code>SOCIAL_CONTACT_VALUE</code> value get from input page.</li>
	 * <li><code>MODULE_ID</code> is unique id for every module of application,
	 * which are mapped with <code>Modules.java</code></li>
	 * <li><code>MODULE_REF_ID</code> process id for specific record of modules.
	 * </li>
	 * </ul>
	 * 
	 * @see com.bst.ckt.helper.Modules#LEAD_ID
	 */
	public static final String INSERT_SOCIAL_INFORMATION = "INSERT INTO TAB_SOCIAL_CONTACT"
			+ "(SOCIAL_SITE_REF,SOCIAL_CONTACT_VALUE,MODULE_ID,MODULE_REF_ID)VALUES(?,?,?,?)";

	/**
	 * <p>
	 * <code>GET_CURRENCY_DISPLAY_NAME</code> token is representing the
	 * constants for SQL query, which is fetching
	 * </p>
	 * 
	 * <pre>
	 * CURRENCY_DISPLAY_NAME
	 * </pre>
	 * 
	 * from <code>TAB_CURRENCY</code> .
	 */
	public static final String GET_CURRENCY_DISPLAY_NAME = "SELECT CURRENCY_DISPLAY_NAME FROM TAB_CURRENCY WHERE CURRENCY_ID=?";

	/**
	 * <p>
	 * <code>GET_LANGURAGE_DISPLAY_NAME</code> token is representing the
	 * constants for SQL query, which is fetching
	 * </p>
	 * 
	 * <pre>
	 * LANGUAGE_DISPLAY_NAME
	 * </pre>
	 * 
	 * from <code>TAB_LANGUAGE</code> .
	 */
	public static final String GET_LANGURAGE_DISPLAY_NAME = "SELECT LANGUAGE_DISPLAY_NAME FROM TAB_LANGUAGE WHERE LANGUAGE_ID=?";

	/**
	 * <p>
	 * <code>GET_TIMEZONE_DISPLAY_NAME</code> token is representing the
	 * constants for SQL query, which is fetching
	 * </p>
	 * 
	 * <pre>
	 * TIMEZONE_DISPLAY_NAME
	 * </pre>
	 * 
	 * from <code>TAB_TIMEZONE</code> .
	 */
	public static final String GET_TIMEZONE_DISPLAY_NAME = "SELECT TIMEZONE_DISPLAY_NAME FROM TAB_TIMEZONE WHERE TIMEZONE_ID=?";

	/**
	 * <p>
	 * <code>ADD_LEAD_DETAIL</code> token is representing the constants for SQL
	 * query, which is fetching records from <code>TAB_LEAD_DETAILS</code> .
	 */
	public static final String ADD_LEAD_DETAIL = "INSERT INTO TAB_LEAD_DETAILS(COMPANY_NAME, SALUTATION, CONTACT_PERSON,"
			+ "LEAD_TITLE_REF, COMPANY_TYPE_REF, COMPANY_CATEGORY_REF, COMPANY_SECTOR_REF, LEAD_SOURCE_REF, LEAD_SOURCE_NAME,"
			+ " NUMBER_OF_ASSOCIATE, ANNUAL_REVENUE, LEAD_DATE, EXPECTED_CLOSING_DATE, LEAD_OWNER_REF, RATING, EMAIL_OPT_OUT, "
			+ "ADDRESS_LINE_1, ADDRESS_LINE_2, CITY, STATE, COUNTRY_REF, ZIPCODE, PHONE_NO, MOBILE_NO, PRIMARY_EMAIL_ID, "
			+ "ALTERNATIVE_EMAIL_ID, FAX_NO, WEBSITE, REQUIRMENT, LEAD_STATUS, CREATED_BY, CREATED_DATE, PHONE_ISD, PHONE_STD,"
			+ " MOBILE_ISD,FAX_ISD,FAX_STD)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

	/**
	 * <p>
	 * <code>SHOW_VIEW_LEAD</code> token is representing the constants for SQL
	 * query, which is fetching records from <code>TAB_LEAD_DETAILS</code> .
	 */
	public static final String SHOW_VIEW_LEAD = "SELECT LEAD_ID,LEAD_OWNER_REF,CREATED_DATE,COMPANY_NAME,SALUTATION,CONTACT_PERSON,"
			+ "LEAD_TITLE_REF,LEAD_SOURCE_REF,COMPANY_TYPE_REF,COMPANY_CATEGORY_REF,COMPANY_SECTOR_REF,LEAD_SOURCE_REF,"
			+ "LEAD_STATUS,LEAD_SOURCE_NAME,NUMBER_OF_ASSOCIATE,ANNUAL_REVENUE,LEAD_DATE,EXPECTED_CLOSING_DATE,RATING,EMAIL_OPT_OUT,"
			+ "ADDRESS_LINE_1,ADDRESS_LINE_2,CITY,STATE,COUNTRY_REF,ZIPCODE,PHONE_ISD,PHONE_STD,PHONE_NO,MOBILE_ISD,"
			+ "MOBILE_NO,PRIMARY_EMAIL_ID,ALTERNATIVE_EMAIL_ID,FAX_ISD,FAX_STD,FAX_NO,WEBSITE,"
			+ "REQUIRMENT,CREATED_BY FROM TAB_LEAD_DETAILS WHERE LEAD_ID=?";

	/**
	 * <p>
	 * <code>GET_LAST_RECORD</code> token is representing the constants for SQL
	 * query, which is getting last record <code>LEAD_ID</code> from
	 * <code>TAB_LEAD_DETAILS</code> .
	 */
	public static final String GET_LAST_RECORD_ID = "SELECT  LEAD_ID FROM TAB_LEAD_DETAILS GROUP BY LEAD_ID DESC LIMIT 1";

	/**
	 * <p>
	 * <code>GET_ACCOUNT_LAST_RECORD_ID</code> token is representing the
	 * constants for SQL query, which is getting account last record
	 * <code>ACCOUNT_ID</code> from <code>TAB_LEAD_DETAILS</code> .
	 */
	public static final String GET_ACCOUNT_LAST_RECORD_ID = "SELECT  ACCOUNT_ID FROM TAB_ACCOUNT GROUP BY ACCOUNT_ID DESC LIMIT 1";

	/**
	 * <p>
	 * <code>GET_FIRST_RECORD_ID</code> token is representing the constants for
	 * SQL query, which is getting first record <code>LEAD_ID</code> from
	 * <code>TAB_LEAD_DETAILS</code> .
	 */
	public static final String GET_FIRST_RECORD_ID = "SELECT  LEAD_ID FROM TAB_LEAD_DETAILS GROUP BY LEAD_ID ASC LIMIT 1";

	/**
	 * <p>
	 * <code>GET_LEAD_SOURCE_NAME</code> token is representing the constants for
	 * SQL query, which is fetching
	 * </p>
	 * 
	 * <pre>
	 * LEAD_SOURCE_NAME
	 * </pre>
	 * 
	 * from <code>TAB_LEAD_SOURCE</code> .
	 */
	public static final String GET_LEAD_SOURCE_NAME = "SELECT LEAD_SOURCE_NAME FROM TAB_LEAD_SOURCE WHERE LEAD_SOURCE_ID=?";

	/**
	 * <p>
	 * <code>SHOW_LEAD_DETAILS</code> token is representing the constants for
	 * SQL query, which is fetching
	 * 
	 * from <code>TAB_LEAD_DETAILS</code> .
	 */
	public static final String SHOW_LEAD_DETAILS = "SELECT LEAD_ID,COMPANY_NAME, SALUTATION, "
			+ "CONTACT_PERSON, LEAD_TITLE_REF,COMPANY_TYPE_REF,COMPANY_CATEGORY_REF, "
			+ "COMPANY_SECTOR_REF,NUMBER_OF_ASSOCIATE,ANNUAL_REVANUE,LEAD_DATE,EXPECTED_CLOSING_DATE,"
			+ "LEAD_SOURCE_REF,LEAD_SOURCE_NAME, LEAD_OWNER_REF,CREATED_DATE,REQUIRMENT, "
			+ "LEAD_STATUS,CREATED_BY FROM TAB_LEAD_DETAILS WHERE LEAD_ID=?";

	/**
	 * <p>
	 * <code>UPDATE_LEAD_INFORMATION</code> token is representing the constants
	 * for SQL query, which is updating lead information.
	 * </p>
	 * 
	 * 
	 * from <code>TAB_LEAD_DETAILS</code> .
	 */
	public static final String UPDATE_LEAD_INFORMATION = "UPDATE TAB_LEAD_DETAILS SET COMPANY_NAME=?,SALUTATION=?,CONTACT_PERSON=?,"
			+ "LEAD_TITLE_REF=?,COMPANY_TYPE_REF=?,COMPANY_CATEGORY_REF=?,COMPANY_SECTOR_REF=?,LEAD_SOURCE_REF=?,LEAD_SOURCE_NAME=?,"
			+ "NUMBER_OF_ASSOCIATE=?,ANNUAL_REVENUE=?,LEAD_DATE=?,EXPECTED_CLOSING_DATE=?,REQUIRMENT=?,RATING=?,EMAIL_OPT_OUT=?"
			+ ",LEAD_STATUS=? WHERE LEAD_ID=?";

	
	/**
	 * <p>
	 * <code>GET_LEAD_CONTACT_INFORMATION</code> token is representing the
	 * constants for SQL query, which is fetching lead contact information in
	 * <code>TAB_LEAD_DETAILS</code>table.
	 */
	public static final String GET_LEAD_CONTACT_INFORMATION = "SELECT LEAD_ID, ADDRESS_LINE_1, ADDRESS_LINE_2, CITY, "
			+ "STATE, COUNTRY_REF, ZIPCODE, FAX_NO, PHONE_NO, MOBILE_NO, PRIMARY_EMAIL_ID, ALTERNATIVE_EMAIL_ID, "
			+ "WEBSITE,FAX_ISD,FAX_STD,PHONE_ISD,PHONE_STD,MOBILE_ISD FROM TAB_LEAD_DETAILS WHERE LEAD_ID=?";

	/**
	 * <p>
	 * <code>UPDATE_LEAD_CONTACT_INFORMATION</code> token is representing the
	 * constants for SQL query, which is updating lead information.
	 * </p>
	 * from <code>TAB_LEAD_DETAILS</code>
	 * 
	 */
	public static final String UPDATE_LEAD_CONTACT_INFORMATION = "UPDATE TAB_LEAD_DETAILS SET ADDRESS_LINE_1=?, ADDRESS_LINE_2=?,"
			+ "CITY=?, STATE=?, COUNTRY_REF=?, ZIPCODE=?, PHONE_NO=?, MOBILE_NO=?, PRIMARY_EMAIL_ID=?, ALTERNATIVE_EMAIL_ID=?, "
			+ "FAX_NO=?,FAX_ISD=?,FAX_STD=?,PHONE_ISD=?,PHONE_STD=?,MOBILE_ISD=? WHERE LEAD_ID=?";

	/**
	 * <p>
	 * <code>TAB_CUSTOMER_USER</code> token is representing the constants for
	 * SQL query, which is updating the user login password
	 * </p>
	 * 
	 * <pre>
	 * PASSWORD
	 * </pre>
	 * 
	 * from <code>TAB_CUSTOMER_USER</code> .
	 */
	public static final String UPDATE_CUSTOMER_LOGIN_PASSWORD = "UPDATE TAB_CUSTOMER_USER SET PASSWORD=? WHERE CUSTOMER_ID=?";

	/**
	 * <p>
	 * <code>GET_PASSWORD</code> token is representing the constants for SQL
	 * query, which is updating the user login password
	 * </p>
	 * 
	 * <pre>
	 * PASSWORD
	 * </pre>
	 * 
	 * from <code>TAB_CUSTOMER_USER</code> .
	 */
	public static final String GET_PASSWORD = "SELECT * FROM TAB_CUSTOMER_USER WHERE PASSWORD=?";

	/**
	 * 
	 */
	public static final String GET_USER_DETAILS_LIST = "SELECT * FROM TAB_CUSTOMER_USER WHERE REF_COMPANY=?";

	/**
	 * <p>
	 * <code>ADD_USER_DETAILS</code> token is representing the constants for SQL
	 * query, which is inserting user details into the database
	 * </p>
	 * 
	 * 
	 * from <code>TAB_CUSTOMER_TEMP</code> .
	 */

	/*public static final String ADD_USER_DETAILS = "INSERT INTO TAB_CUSTOMER_TEMP "
			+ "(SALUTATION,FULL_NAME,EMAIL_ID,MOBILE_NO,USER_ROLE,COUNTRY,IP_ADDRESS,CREATED_DATE,EMAIL_FLAG,"
			+ "REG_REF_NO,CREATED_BY,COMPANY_NAME, SHOP_ID)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";*/
	
	public static final String ADD_USER_DETAILS = "INSERT INTO TAB_CUSTOMER_USER "
			+ "(SALUTATION,FULL_NAME,PRIMARY_EMAIL_ID,MOBILE_NO,USER_ROLE,REF_COUNTRY,CREATION_DATE,EMAIL_FLAG,"
			+ "CREATED_BY,REF_COMPANY, ACL_ID, PASSWORD, USER_STATUS)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";

	/**
	 * <p>
	 * <code>GET_LEAD_TITLE</code> token is representing the constants for SQL
	 * query, which is fetching lead title from <code>TAB_LEAD_TITLE</code>
	 * based on the company email id
	 */
	public static final String GET_LEAD_TITLE = "SELECT LEAD_TITLE_SUBJECT FROM TAB_LEAD_TITLE "
			+ "WHERE LEAD_TITLE_SUBJECT=?";

	/**
	 * <p>
	 * <code>GET_GROUP_CATEGORY_NAME_LIST</code> token is representing the
	 * constants for SQL query, which is fetching
	 * 
	 * <pre>
	 * GROUP_CATEGORY_ID,GROUP_CATEGORY_NAME
	 * </pre>
	 * 
	 * from <code>TAB_GROUP_CATEGORY</code> .
	 */
	public static final String GET_GROUP_CATEGORY_NAME_LIST = "SELECT GROUP_CATEGORY_ID,GROUP_CATEGORY_NAME FROM TAB_GROUP_CATEGORY";

	/**
	 * <p>
	 * <code>GET_DESIGNATION_DISPLAY_NAME_LIST</code> token is representing the
	 * constants for SQL query, which is fetching
	 * 
	 * <pre>
	 * DESIGNATION_ID,DESIGNATION_DISPLAY_NAME
	 * </pre>
	 * 
	 * from <code>TAB_DESIGNATION</code>.
	 */
	public static final String GET_DESIGNATION_DISPLAY_NAME_LIST = "SELECT DESIGNATION_ID,DESIGNATION_DISPLAY_NAME FROM TAB_DESIGNATION";

	/**
	 * <p>
	 * <code>ADD_NEW_ACCOUNT_DETAILS</code> token is representing the constants
	 * for SQL query, which is inserting records into <code>TAB_ACCOUNT</code> .
	 * 
	 */
	public static final String ADD_NEW_ACCOUNT_DETAILS = "INSERT INTO TAB_ACCOUNT("
			+ "SALUTATION, CONTACT_PERSON, ACCOUNT_NAME, ACCOUNT_TYPE_REF, OWNERSHIP_TYPE_REF,"
			+ "ORGANIZATION_CATEGORY_REF, ORGANIZATION_SECTOR_REF, NUMBER_OF_ASSOCIATE, ANNUAL_REVENUE, PHONE_NO, PHONE_ISD,"
			+ "PHONE_STD, MOBILE_NO, MOBILE_ISD, EMAIL_ID, PARENT_ACCOUNT, TICKER_SYMBOL, ASSIGNED_TO, RATING, NOTIFY_OWNER,"
			+ "EMAIL_OPT_OUT,SLA_NAME, BILLING_SALUTATION, BILLING_CONTACT_PERSON, BILLING_DESIGNATION_REF,"
			+ "BILLING_ADDRESS_LINE_1, BILLING_ADDRESS_LINE_2, BILLING_CITY, BILLING_STATE, BILLING_COUNTRY_REF,"
			+ "BILLING_ZIPCODE, BILLING_PHONE_NO, BILLING_PHONE_ISD, BILLING_PHONE_STD, BILLING_MOBILE_NO, BILLING_MOBILE_ISD,"
			+ "BILLING_PRIMARY_EMAIL, BILLING_ALTERNATE_EMAIL, BILLING_FAX_NO, BILLING_FAX_ISD, BILLING_FAX_STD, "
			+ "BILLING_WEBSITE, SHIPPING_SALUTATION, SHIPPING_CONTACT_PERSON, SHIPPING_DESIGNATION_REF,"
			+ "SHIPPING_ADDRESS_LINE_1, SHIPPING_ADDRESS_LINE_2, SHIPPING_CITY, SHIPPING_STATE, SHIPPING_COUNTRY_REF,"
			+ "SHIPPING_ZIPCODE, SHIPPING_PHONE_NO, SHIPPING_PHONE_ISD, SHIPPING_PHONE_STD, SHIPPING_MOBILE_NO, SHIPPING_MOBILE_ISD,"
			+ " SHIPPING_PRIMARY_EMAIL, SHIPPING_ALTERNATE_EMAIL, SHIPPING_FAX_NO, SHIPPING_FAX_ISD, SHIPPING_FAX_STD,"
			+ " SHIPPING_WEBSITE, PROFILE_DESCRIPTION, CREATED_DATE, CREATED_BY)VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,"
			+ "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?, ?"
			+ ", ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	/**
	 * <p>
	 * <code>GET_GROUP_CATEGORY_NAME</code>this token is representing the
	 * constants for SQL query, which is fetching
	 * </p>
	 * 
	 * <pre>
	 * GROUP_CATEGORY_NAME
	 * </pre>
	 * 
	 * from <code>TAB_GROUP_CATEGORY</code> .
	 */
	public static final String GET_GROUP_CATEGORY_NAME = "SELECT GROUP_CATEGORY_NAME FROM TAB_GROUP_CATEGORY "
			+ "WHERE GROUP_CATEGORY_ID=?";

	/**
	 * <p>
	 * <code>GET_ACCOUNT_DETAILS</code>this token is representing the constants
	 * for SQL query, which is fetching record respective
	 * <code>ACCOUNT_ID</code> from <code>TAB_ACCOUNT</code> .
	 */
	public static final String GET_ACCOUNT_DETAILS = "SELECT * FROM TAB_ACCOUNT  WHERE ACCOUNT_ID=?";

	/**
	 * <p>
	 * <code>UPDATE_ACCOUNT_DETAILS</code> token is representing the constants
	 * for SQL query, which is updating record into table
	 * <code>TAB_ACCOUNT</code> .
	 * 
	 */
	public static final String UPDATE_ACCOUNT_DETAILS = "UPDATE TAB_ACCOUNT SET SALUTATION=?, CONTACT_PERSON=?, "
			+ "ACCOUNT_NAME=?, ACCOUNT_TYPE_REF=?, OWNERSHIP_TYPE_REF=?, ORGANIZATION_CATEGORY_REF=?, "
			+ "ORGANIZATION_SECTOR_REF=?, NUMBER_OF_ASSOCIATE=?, ANNUAL_REVENUE=?, PHONE_NO=?, PHONE_ISD=?,"
			+ "PHONE_STD=?, MOBILE_NO=?, MOBILE_ISD=?, EMAIL_ID=?, PARENT_ACCOUNT=?, TICKER_SYMBOL=?, ASSIGNED_TO=?, "
			+ "RATING=?, NOTIFY_OWNER=?,EMAIL_OPT_OUT=?,SLA_NAME=?, BILLING_SALUTATION=?, BILLING_CONTACT_PERSON=?, "
			+ "BILLING_DESIGNATION_REF=?, BILLING_ADDRESS_LINE_1=?, BILLING_ADDRESS_LINE_2=?, BILLING_CITY=?, "
			+ "BILLING_STATE=?, BILLING_COUNTRY_REF=?,BILLING_ZIPCODE=?, BILLING_PHONE_NO=?, BILLING_PHONE_ISD=?, "
			+ "BILLING_PHONE_STD=?, BILLING_MOBILE_NO=?, BILLING_MOBILE_ISD=?, BILLING_PRIMARY_EMAIL=?, BILLING_ALTERNATE_EMAIL=?,"
			+ "BILLING_FAX_NO=?, BILLING_FAX_ISD=?, BILLING_FAX_STD=?,BILLING_WEBSITE=?, SHIPPING_SALUTATION=?, "
			+ "SHIPPING_CONTACT_PERSON=?, SHIPPING_DESIGNATION_REF=?,SHIPPING_ADDRESS_LINE_1=?, SHIPPING_ADDRESS_LINE_2=?,"
			+ "SHIPPING_CITY=?, SHIPPING_STATE=?, SHIPPING_COUNTRY_REF=?,SHIPPING_ZIPCODE=?, SHIPPING_PHONE_NO=?, "
			+ "SHIPPING_PHONE_ISD=?, SHIPPING_PHONE_STD=?, SHIPPING_MOBILE_NO=?, SHIPPING_MOBILE_ISD=?,"
			+ " SHIPPING_PRIMARY_EMAIL=?, SHIPPING_ALTERNATE_EMAIL=?, SHIPPING_FAX_NO=?, SHIPPING_FAX_ISD=?, SHIPPING_FAX_STD=?,"
			+ " SHIPPING_WEBSITE=?,PROFILE_DESCRIPTION=?,UPDATED_DATE=?,UPDATED_BY=? WHERE ACCOUNT_ID=?";

	/**
	 * <p>
	 * <code>GET_DESIGNATION_NAME</code>this token is representing the constants
	 * for SQL query, which is fetching
	 * </p>
	 * 
	 * <pre>
	 * DESIGNATION_DISPLAY_NAME
	 * </pre>
	 * 
	 * from <code>TAB_DESIGNATION</code>.
	 */
	public static final String GET_DESIGNATION_NAME = "SELECT DESIGNATION_DISPLAY_NAME FROM TAB_DESIGNATION "
			+ "WHERE DESIGNATION_ID=?";

	/**
	 * <p>
	 * <code>UPDATE_LEAD_STATUS</code> token is representing the constants for
	 * SQL query, which is updating lead information.
	 * </p>
	 * from <code>TAB_LEAD_DETAILS</code>
	 * 
	 */
	public static final String UPDATE_LEAD_STATUS = "UPDATE TAB_LEAD_DETAILS "
			+ "SET LEAD_STATUS=? WHERE LEAD_ID=?";

	/**
	 * <p>
	 * <code>GET_SOCIAL_SITE_VALUE_LIST</code> token is representing the
	 * constants for SQL query, which is fetching
	 * 
	 * <pre>
	 * SOCIAL_SITE_ID,SOCIAL_SITE_VALUE
	 * </pre>
	 * 
	 * from <code>TAB_SOCIAL_SITE</code>.
	 */
	public static final String GET_SOCIAL_SITE_VALUE_LIST = "SELECT SOCIAL_SITE_ID,"
			+ "SOCIAL_SITE_VALUE FROM TAB_SOCIAL_SITE";

	/**
	 * <p>
	 * <code>GET_LEAD_SOCIAL_DETAILS</code> token is representing the constants
	 * for SQL query, which is fetching
	 * 
	 * <pre>
	 * SOCIAL_SITE_REF,SOCIAL_CONTACT_VALUE
	 * </pre>
	 * 
	 * from <code>TAB_SOCIAL_CONTACT</code>.
	 */
	public static final String GET_LEAD_SOCIAL_DETAILS = "SELECT * "
			+ "FROM TAB_SOCIAL_CONTACT WHERE MODULE_ID=? AND MODULE_REF_ID=?";

	/**
	 * <p>
	 * <code>GET_SOCIAL_INFO</code> token is representing the constants for SQL
	 * query, which is fetching
	 * 
	 * from <code>TAB_SOCIAL_CONTACT</code> .
	 */
	public static final String GET_SOCIAL_INFO = "SELECT * "
			+ "FROM TAB_SOCIAL_CONTACT WHERE SOCIAL_SITE_REF=? AND MODULE_ID=? AND MODULE_REF_ID=?";

	/**
	 * <p>
	 * <code>UPDATE_SOCIAL_INFORMATION</code> token is representing the
	 * constants for SQL query, which is updating
	 * 
	 * into <code>TAB_SOCIAL_CONTACT</code> .
	 */
	public static final String UPDATE_SOCIAL_INFORMATION = "UPDATE TAB_SOCIAL_CONTACT SET"
			+ " SOCIAL_SITE_REF=?, SOCIAL_CONTACT_VALUE=?, MODULE_ID=?,"
			+ " MODULE_REF_ID=? WHERE SOCIAL_CONTACT_ID=?";

	/**
	 * <p>
	 * <code>GET_GROUP_SOCIAL_DETAILS</code> token is representing the constants
	 * for SQL query, which is fetching
	 * 
	 * <pre>
	 * SOCIAL_SITE_REF,SOCIAL_CONTACT_VALUE
	 * </pre>
	 * 
	 * from <code>TAB_SOCIAL_CONTACT</code> .
	 */
	public static final String GET_GROUP_SOCIAL_DETAILS = "SELECT * "
			+ "FROM TAB_SOCIAL_CONTACT WHERE MODULE_ID=? AND MODULE_REF_ID=?";

	/**
	 * <p>
	 * <code>UPDATE_CHANGE_EMAIL_FLAG</code> token is representing the constants
	 * for SQL query, which is updating the user login password
	 * </p>
	 * 
	 * <pre>
	 * EMAIL_FLAG
	 * </pre>
	 * 
	 * from <code>TAB_CUSTOMER_USER</code> .
	 */
	public static final String UPDATE_CREATE_USER_EMAIL_FLAG = "UPDATE TAB_CUSTOMER_TEMP SET EMAIL_FLAG=? WHERE REG_REF_NO=?";

	/**
	 * <p>
	 * <code>GET_CUSTOMER_STAFF_USER_DETAILS_BY_GUID</code> token is
	 * representing the constants for SQL query, that get the customer staff
	 * user details.
	 * </p>
	 * 
	 * from <code>TAB_CUSTOMER_USER</code> .
	 */
	public static final String GET_CUSTOMER_STAFF_USER_DETAILS_BY_GUID = "SELECT * FROM TAB_CUSTOMER_TEMP WHERE REG_REF_NO=?";

	/**
	 * <p>
	 * <code>GET_CUSTOMER_ID_BY_REFNO</code> token is representing the constants
	 * for SQL query, that get the customerId.
	 * </p>
	 * 
	 * from <code>TAB_CUSTOMER_USER</code> .
	 */
	public static final String GET_CUSTOMER_ID_BY_REFNO = "SELECT CUSTOMER_ID FROM TAB_CUSTOMER_USER WHERE CREATED_BY=?";

	/**
	 * <p>
	 * <code>UPDATE_EMAILFLAG_CUSTOMER_STAFF_USER</code> token is representing
	 * the constants for SQL query.
	 * </p>
	 * 
	 * from <code>TAB_CUSTOMER_USER</code> .
	 */
	public static final String UPDATE_EMAILFLAG_CUSTOMER_STAFF_USER = "UPDATE TAB_CUSTOMER_USER SET EMAIL_FLAG=? WHERE PRIMARY_EMAIL_ID=?";

	/**
	 * <p>
	 * <code>GET_COMPANYID_BY_CUSTOMERID</code> token is representing the
	 * constants for SQL query.
	 * </p>
	 * 
	 * from <code>TAB_CUSTOMER_USER</code> .
	 */
	public static final String GET_COMPANYID_BY_CUSTOMERID = "SELECT REF_COMPANY FROM TAB_CUSTOMER_USER WHERE CUSTOMER_ID=?";

	/**
	 * <p>
	 * <code>GET_CUSTOMER_DETAIL_BY_EMAIL</code> token is representing the
	 * constants for SQL query.
	 * </p>
	 * 
	 * from <code>TAB_CUSTOMER_USER</code> .
	 */
	public static final String GET_CUSTOMER_DETAIL_BY_EMAIL = "SELECT * FROM TAB_CUSTOMER_USER WHERE PRIMARY_EMAIL_ID=?";

	/**
	 * <p>
	 * <code>INSERT_CUSTOMER_DETAIL_BY_EMAIL</code> token is representing the
	 * constants for SQL query.
	 * </p>
	 * 
	 * from <code>TAB_CUSTOMER_USER</code> .
	 */
	public static final String INSERT_CUSTOMER_DETAIL_BY_EMAIL = "INSERT INTO TAB_CUSTOMER_USER(PRIMARY_EMAIL_ID,FULL_NAME,"
			+ "REF_COUNTRY,REF_COMPANY,USER_ROLE,CREATION_DATE,CREATED_BY,EMAIL_FLAG,USER_STATUS,PASSWORD,LOGIN_FLAG, ACL_ID)VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";

	/**
	 * <p>
	 * <code>UPDATE_CUSTOMER_STATUS</code> token is representing the constants
	 * for SQL query.
	 * </p>
	 * 
	 * from <code>TAB_CUSTOMER_USER</code> .
	 */
	public static final String UPDATE_CUSTOMER_STATUS = "UPDATE TAB_CUSTOMER_USER SET USER_STATUS=? WHERE CUSTOMER_ID=?";

	/**
	 * <p>
	 * <code>GET_DEPARTMENT_LIST</code> token is representing the constants for
	 * SQL query, which is fetching
	 * 
	 * <pre>
	 * DEPARTMENT_ID,DEPARTMENT_DISPLAY_NAME
	 * </pre>
	 * 
	 * records from <code>TAB_DEPARTMENT</code> .
	 */
	public static final String GET_DEPARTMENT_LIST = "SELECT DEPARTMENT_ID,DEPARTMENT_DISPLAY_NAME FROM TAB_DEPARTMENT";

	/**
	 * <p>
	 * <code>GET_LANGUAGE_LIST</code> token is representing the constants for
	 * SQL query, which is fetching
	 * 
	 * <pre>
	 * LANGUAGE_ID,LANGUAGE_DISPLAY_NAME
	 * </pre>
	 * 
	 * records from <code>TAB_LANGUAGE</code> .
	 */
	public static final String GET_LANGUAGE_LIST = "SELECT LANGUAGE_ID,LANGUAGE_DISPLAY_NAME FROM TAB_LANGUAGE";

	/**
	 * <p>
	 * <code>GET_DEPARTMENT_LIST</code> token is representing the constants for
	 * SQL query, which is fetching
	 * 
	 * <pre>
	 * TIMEZONE_ID,TIMEZONE_ABBREVATION
	 * </pre>
	 * 
	 * records from <code>TAB_TIMEZONE</code> .
	 */
	public static final String GET_TIMEZONE_LIST = "SELECT TIMEZONE_ID,TIMEZONE_ABBREVATION FROM TAB_TIMEZONE";

	/**
	 * <p>
	 * <code>UPDATE_USER_INFORMATION</code> token is representing the constants
	 * for SQL query, which is updating Customer account information in
	 * <code>TAB_CUSTOMER_USER</code>table.
	 */
	public static final String UPDATE_USER_INFORMATION = "UPDATE TAB_CUSTOMER_USER SET "
			+ "SALUTATION=?, FULL_NAME=?, DATE_OF_BIRTH=?, GENDER=?, PRIMARY_EMAIL_ID=?, ALTERNATE_EMAIL_ID=?,"
			+ "DEPARTMENT=?, WORK_LOCATION=?, ADDRESS_LINE_1=?, ADDRESS_LINE_2=?, CITY=?, STATE=?, REF_COUNTRY=?, ZIPCODE=?, "
			+ "PHONE_NO=?,MOBILE_NO=?,FAX_NO=?, WEBSITE=?,LANGUAGE=?,TIME_ZONE=?,REF_CURRENCY=?,PROFILE_IMAGE_PATH=? WHERE CUSTOMER_ID=?";

	/**
	 * <p>
	 * <code>GET_TASK_AREA_LIST</code> token is representing the constants for
	 * SQL query, which is fetching
	 * 
	 * <pre>
	 * TASK_AREA_ID,TASK_AREA
	 * </pre>
	 * 
	 * from <code>TAB_TASK_AREA</code>.
	 */
	public static final String GET_TASK_AREA_LIST = "SELECT TASK_AREA_ID,TASK_AREA "
			+ "FROM TAB_TASK_AREA";

	/**
	 * <p>
	 * <code>GET_TASK_SUBJECT_LIST</code> token is representing the constants
	 * for SQL query, which is fetching
	 * 
	 * <pre>
	 * TASK_ID,TASK_SUBJECT
	 * </pre>
	 * 
	 * from <code>TAB_TASK_SUBJECT</code>.
	 */
	public static final String GET_TASK_SUBJECT_LIST = "SELECT TASK_SUBJECT_ID,TASK_SUBJECT "
			+ "FROM TAB_TASK_SUBJECT";

	/**
	 * <p>
	 * <code>ADD_TASK_ALLOCATION_DETAILS</code> token is representing the
	 * constants for SQL query, which is inserting task allocation details into
	 * <code>TAB_TASK_DETAILS</code> table.
	 * </p>
	 */
	public static final String ADD_TASK_ALLOCATION_DETAILS = "INSERT INTO TAB_TASK_DETAILS "
			+ "(SALUTATION, TASK_ALLOCATED_TO_REF, TASK_SUBJECT_REF, TASK_DUE_DATE, TASK_AREA_REF, TASK_STATUS,"
			+ "TASK_PRIORITY, EMAIL_NOTIFICATION_FLAG, START_DATE, END_DATE, REPEAT_TYPE, EVER_DAY_FLAG,"
			+ "NUMBER_OF_DAYS, REPEAT_FOR_EVERY_FLAG, NUMBER_OF_WEEKS, WEEK_DAY_NAME, ON_DAY_FLAG, DAY_OF_MONTH, "
			+ "NUMBER_OF_MONTHS, ON_WEEK_OF_MONTH, DAY_NAME_OF_MONTH, NUMBER_OF_DAY_OF_MONTHS, "
			+ "ON_EVERY_FLAG, MONTHS_NAME, ON_DAY, ON_WITCH_WEEK, WEEKS_DAY_NAME, MONTHS_NAME_OF_YEAR, "
			+ "DISCRIPTION, TASK_ALLOCATED_BY, TASK_ALLOCATION_DATE)VALUES"
			+ "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";

	/**
	 * <p>
	 * <code>GE_TASK_DETAILS_LIST</code> token is representing the constants for
	 * SQL query, which is fetching records from <code>TAB_TASK_DETAILS</code> .
	 */
	public static final String GE_TASK_DETAILS_LIST = "SELECT TASK_ID,TASK_SUBJECT_REF,TASK_AREA_REF,"
			+ "TASK_PRIORITY,TASK_ALLOCATED_TO_REF,TASK_ALLOCATED_BY,TASK_DUE_DATE,TASK_STATUS FROM "
			+ "TAB_TASK_DETAILS";

	/**
	 * <p>
	 * <code>GET_TASK_SUBJECT_NAME</code>this token is representing the
	 * constants for SQL query, which is fetching
	 * </p>
	 * 
	 * <pre>
	 * TASK_SUBJECT
	 * </pre>
	 * 
	 * from <code>TAB_TASK_SUBJECT</code>.
	 */
	public static final String GET_TASK_SUBJECT_NAME = "SELECT TASK_SUBJECT FROM TAB_TASK_SUBJECT "
			+ "WHERE TASK_SUBJECT_ID=?";

	/**
	 * <p>
	 * <code>GET_TASK_AREA_NAME</code>this token is representing the constants
	 * for SQL query, which is fetching
	 * </p>
	 * 
	 * <pre>
	 * TASK_AREA
	 * </pre>
	 * 
	 * from <code>TAB_TASK_SUBJECT</code>.
	 */
	public static final String GET_TASK_AREA_NAME = "SELECT TASK_AREA FROM TAB_TASK_AREA "
			+ "WHERE TASK_AREA_ID=?";

	/**
	 * <p>
	 * <code>GE_TASK_ALLOCATION_DETAILS</code> token is representing the
	 * constants for SQL query, which is fetching records from
	 * <code>TAB_TASK_DETAILS</code> .
	 */
	public static final String GE_TASK_ALLOCATION_DETAILS = "SELECT  * FROM "
			+ "TAB_TASK_DETAILS WHERE TASK_ID=?";

	/**
	 * <p>
	 * <code>GET_TASK_SUBJECT</code> token is representing the constants for SQL
	 * query, which is fetching task subject from <code>TAB_TASK_SUBJECT</code>
	 * based on the company email id
	 */
	public static final String GET_TASK_SUBJECT = "SELECT TASK_SUBJECT FROM TAB_TASK_SUBJECT "
			+ "WHERE TASK_SUBJECT=?";

	/**
	 * <p>
	 * <code>INSERT_TASK_SUBJECT</code> token is representing the constants for
	 * SQL query, which is insert task subject in <code>TAB_TASK_SUBJECT</code>
	 * table
	 */
	public static final String INSERT_TASK_SUBJECT = "INSERT INTO TAB_TASK_SUBJECT(TASK_SUBJECT) VALUES(?) ";

	/**
	 * <p>
	 * <code>SHOW_TASK_SUBJECT_LIST</code> token is representing the constants
	 * for SQL query, which is fetching task subject from
	 * <code>TAB_TASK_SUBJECT</code> table
	 */
	public static final String SHOW_TASK_SUBJECT_LIST = "SELECT TASK_SUBJECT FROM TAB_TASK_SUBJECT";

	/**
	 * <p>
	 * <code>UPDATE_USER_DETAILS</code> token is representing the constants for
	 * SQL query, which is updating Customer account information in
	 * <code>TAB_CUSTOMER_USER</code>table.
	 */
	public static final String UPDATE_USER_DETAILS = "UPDATE TAB_CUSTOMER_USER SET "
			+ "SALUTATION=?, FULL_NAME=?, DATE_OF_BIRTH=?, GENDER=?, PRIMARY_EMAIL_ID=?, ALTERNATE_EMAIL_ID=?,"
			+ "DEPARTMENT=?, WORK_LOCATION=?, ADDRESS_LINE_1=?, ADDRESS_LINE_2=?, CITY=?, STATE=?, REF_COUNTRY=?, ZIPCODE=?, "
			+ "PHONE_NO=?,MOBILE_NO=?,FAX_NO=?, WEBSITE=?,LANGUAGE=?,TIME_ZONE=?,REF_CURRENCY=?,"
			+ "PROFILE_IMAGE_PATH=?,DESIGNATION=?,USER_ROLE=?,USER_STATUS=? WHERE CUSTOMER_ID=?";

	/**
	 * <p>
	 * <code>GET_CUSTOMER_USER_EMAILID</code>this token is representing the
	 * constants for SQL query, which is fetching
	 * </p>
	 * 
	 * <pre>
	 * PRIMARY_EMAIL_ID
	 * </pre>
	 * 
	 * from <code>TAB_CUSTOMER_USER</code>.
	 */
	public static final String GET_CUSTOMER_USER_EMAILID = "SELECT PRIMARY_EMAIL_ID FROM TAB_CUSTOMER_USER "
			+ "WHERE CUSTOMER_ID=?";

	/**
	 * <p>
	 * <code>GE_TASK_DETAILS</code> token is representing the constants for SQL
	 * query, which is fetching records from <code>TAB_TASK_DETAILS</code> .
	 */
	public static final String GE_TASK_DETAILS = "SELECT  * FROM "
			+ "TAB_TASK_DETAILS WHERE TASK_ID=?";

	/**
	 * <p>
	 * <code>UPDATE_CUSTOMER_SECURITY_QUESTION</code> token is representing the
	 * constants for SQL query, which is updating the user Security Question.
	 * </p>
	 * 
	 * <pre>
	 * REF_SECURITY_QUESTION_ID,ANSWER
	 * </pre>
	 * 
	 * from <code>TAB_CUSTOMER_USER</code> .
	 */
	public static final String UPDATE_CUSTOMER_SECURITY_QUESTION = "UPDATE TAB_CUSTOMER_USER SET "
			+ "REF_SECURITY_QUESTION_ID=?,ANSWER=?  WHERE CUSTOMER_ID=?";

	/**
	 * <p>
	 * <code>UPDATE_USER_PRIMARY_EMAIL_ID</code> token is representing
	 * theEMAIL_ID constants for SQL query, that get the change email details.
	 * </p>
	 * 
	 * from <code>TAB_CHANGE_EMAIL_TEMP</code> .
	 */
	public static final String UPDATE_USER_PRIMARY_EMAIL_ID = "INSERT INTO TAB_CHANGE_EMAIL_TEMP(CHANGE_EMAIL_ID,EMAIL_ID,EMAIL_REF_NO,IP_ADDRESS,CREATED_BY,CREATED_DATE)VALUES(?,?,?,?,?,?)";

	/**
	 * <p>
	 * <code>UPDATE_CUSTOMER_EMAIL_ID</code> token is representing the constants
	 * for SQL query, which is updating the user Primary Email Id
	 * </p>
	 * 
	 * <pre>
	 * PRIMARY_EMAIL_ID
	 * </pre>
	 * 
	 * from <code>TAB_CUSTOMER_USER</code> .
	 */
	public static final String UPDATE_CUSTOMER_EMAIL_ID = "UPDATE TAB_CUSTOMER_USER SET PRIMARY_EMAIL_ID=?,CREATED_BY=?,CREATION_DATE=? WHERE CUSTOMER_ID=?";

	/**
	 * <p>
	 * <code>GET_CHANGE_USER_EMAIL_BY_GUID</code> token is representing the
	 * constants for SQL query, that get the change email details.
	 * </p>
	 * 
	 * from <code>TAB_CHANGE_EMAIL_TEMP</code> .
	 */
	public static final String GET_CHANGE_USER_EMAIL_BY_GUID = "SELECT * FROM TAB_CHANGE_EMAIL_TEMP WHERE EMAIL_REF_NO=?";

	/**
	 * <p>
	 * <code>UPDATE_TASK_ALLOCATION_DETAILS</code> token is representing the
	 * constants for SQL query, which is updating task allocation details into
	 * <code>TAB_TASK_DETAILS</code> table.
	 * </p>
	 */
	public static final String UPDATE_TASK_ALLOCATION_DETAILS = "UPDATE TAB_TASK_DETAILS  SET "
			+ "SALUTATION=?, TASK_ALLOCATED_TO_REF=?, TASK_SUBJECT_REF=?, TASK_DUE_DATE=?, TASK_AREA_REF=?, TASK_STATUS=?,"
			+ "TASK_PRIORITY=?, EMAIL_NOTIFICATION_FLAG=?, START_DATE=?, END_DATE=?, REPEAT_TYPE=?, EVER_DAY_FLAG=?,"
			+ "NUMBER_OF_DAYS=?, REPEAT_FOR_EVERY_FLAG=?, NUMBER_OF_WEEKS=?, WEEK_DAY_NAME=?, ON_DAY_FLAG=?, DAY_OF_MONTH=?, "
			+ "NUMBER_OF_MONTHS=?, ON_WEEK_OF_MONTH=?, DAY_NAME_OF_MONTH=?, NUMBER_OF_DAY_OF_MONTHS=?, "
			+ "ON_EVERY_FLAG=?, MONTHS_NAME=?, ON_DAY=?, ON_WITCH_WEEK=?, WEEKS_DAY_NAME=?, MONTHS_NAME_OF_YEAR=?, "
			+ "DISCRIPTION=?, TASK_ALLOCATED_BY=?, TASK_ALLOCATION_DATE=? WHERE TASK_ID=? ";

	/**
	 * <p>
	 * <code>ADD_CONTACTS_DETAIL</code> token is representing the constants for
	 * SQL query, which is inserting records into <code>TAB_CONTACT</code> .
	 * 
	 */
	public static final String ADD_CONTACTS_DETAIL = "INSERT INTO TAB_CONTACT(SALUTATION, ACCOUNT_NAME, DESIGNATION_REF, "
			+ "NICK_NAME, PHONE_NUMBER, PHONE_NUMBER_ISD, PHONE_NUMBER_STD, REFERRED_BY, MOBILE_NUMBER1, MOBILE_NUMBER1_ISD,"
			+ "EMAIL_ID, TITTLE, DEPARTMENT, REPORTS_TO, REFERENCE,REFERANCE_ID, ASSIGN_TO, DO_NOT_CALL, NOTIFY_OWNER, EMAIL_OPT_OUT,"
			+ "SLA_NAME, HOME_CONTACT_ADDRESS_LINE1, HOME_CONTACT_ADDRESS_LINE2, HOME_CONTACT_CITY, HOME_CONTACT_STATE,"
			+ "HOME_CONTACT_COUNTRY_REF, HOME_CONTACT_ZIPCODE, HOME_CONTACT_PHONE_NUMBER, HOME_CONTACT_PHONE_NUMBER_ISD,"
			+ "HOME_CONTACT_PHONE_NUMBER_STD, HOME_CONTACT_MOBILE_NUMBER, HOME_CONTACT_MOBILE_NUMBER_ISD, HOME_CONTACT_EMAIL_ID, "
			+ "HOME_CONTACT_FAX_NUMBER, HOME_CONTACT_FAX_NUMBER_ISD, HOME_CONTACT_FAX_NUMBER_STD, WORK_CONTACT_ADDRESS_LINE1,"
			+ "WORK_CONTACT_ADDRESS_LINE2, WORK_CONTACT_CITY, WORK_CONTACT_STATE, WORK_CONTACT_COUNTRY_REF, WORK_CONTACT_ZIPCODE,"
			+ "WORK_CONTACT_PHONE_NUMBER, WORK_CONTACT_PHONE_NUMBER_ISD, WORK_CONTACT_PHONE_NUMBER_STD, WORK_CONTACT_MOBILE_NUMBER, "
			+ "WORK_CONTACT_MOBILE_NUMBER_ISD, WORK_CONTACT_EMAIL_ID, WORK_CONTACT_FAX_NUMBER, WORK_CONTACT_FAX_NUMBER_ISD,"
			+ "WORK_CONTACT_FAX_NUMBER_STD, PROFILE_DESCRIPTION, CREATED_DATE, CREATED_BY, CONTACT_PERSON,LEAD_SOURCE_REF,HOME_CONTACT_ALTERNATE_EMAIL_ID,"
			+ "HOME_WEBSITE,WORK_WEBSITE,STATUS,CUSTOMER_CENTER_USER,SUPPORT_START_DATE,SUPPORT_END_DATE,MOBILE_NUMBER2,MOBILE_NUMBER2_ISD,FAX,FAX_ISD,FAX_STD,WORK_CONTACT_ALTERNATE_EMAIL_ID,DATE_OF_BIRTH) VALUES "
			+ "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,"
			+ "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)";

	/**
	 * <p>
	 * <code>GET_CONTACTS_ID_BY_REFERENCE_ID</code>this token is representing
	 * the constants for SQL query, which is fetching
	 * </p>
	 * 
	 * <pre>
	 * CONTACT_ID
	 * </pre>
	 * 
	 * from <code>TAB_CONTACT</code>.
	 */
	public static final String GET_CONTACTS_ID_BY_REFERENCE_ID = "SELECT CONTACT_ID FROM TAB_CONTACT WHERE REFERENCE_ID=?";

	/**
	 * <p>
	 * <code>UPDATE_CONTACT_FILE_NAME</code>this token is representing the
	 * constants for SQL query, which is updating
	 * </p>
	 * 
	 * <pre>
	 * IMAGE_NAME
	 * </pre>
	 * 
	 * as per
	 * 
	 * <pre>
	 * CONTACT_ID
	 * </pre>
	 * 
	 * into <code>TAB_CONTACT</code>.
	 */
	public static final String UPDATE_CONTACTS_FILE_NAME = "UPDATE TAB_CONTACT SET IMAGE_NAME=? WHERE CONTACT_ID=?";

	/**
	 * <p>
	 * <code>GET_CONTACTS_DETAILS_LIST</code>this token is representing the
	 * constants for SQL query, which is fetching records from
	 * <code>TAB_CONTACT</code> .
	 */
	public static final String GET_CONTACTS_DETAILS_LIST = "SELECT CONTACT_ID,SALUTATION,CONTACT_PERSON,GROUP_NAME_REF,"
			+ "DESIGNATION_REF,EMAIL_ID,MOBILE_NUMBER1,WORK_CONTACT_MOBILE_NUMBER FROM TAB_CONTACT";

	

	/**
	 * <p>
	 * <code>INSERT_USER_LOGGER_DETAIL</code> token is representing the
	 * constants for SQL query, which is inserting user logger details into the
	 * database
	 * </p>
	 * 
	 * 
	 * from <code>TAB_CUSTOMER_USER_LOGGER</code> .
	 */
	public static final String INSERT_USER_LOGGER_DETAIL = "INSERT INTO "
			+ "TAB_CUSTOMER_USER_LOGGER(IP_ADDRESS,LOGIN_TIME,REF_CUSTOMER_USER_ID,LOGGER_STATUS)"
			+ "VALUES(?,?,?,?)";

	/**
	 * <p>
	 * <code>UPDATE_USER_LOGGER_DETAILS</code> token is representing the
	 * constants for SQL query, which is updating user logger details into the
	 * database
	 * </p>
	 * 
	 * 
	 * from <code>TAB_CUSTOMER_USER_LOGGER</code> .
	 */
	public static final String UPDATE_USER_LOGGER_DETAILS = "UPDATE TAB_CUSTOMER_USER_LOGGER "
			+ "SET LOGOUT_TIME=? AND LOGGER_STATUS=? WHERE  LOGIN_TIME=?";

	/**
	 * <p>
	 * <code>GET_USER_LOGGER_DETAILS</code> token is representing the constants
	 * for SQL query, which is fetching user logger details into the database
	 * </p>
	 * 
	 * 
	 * from <code>TAB_CUSTOMER_USER_LOGGER</code> .
	 */
	public static final String GET_USER_LOGGER_DETAILS = "SELECT * FROM TAB_CUSTOMER_USER_LOGGER "
			+ "WHERE REF_CUSTOMER_USER_ID=?";

	/**
	 * <p>
	 * <code>GET_SECURITY_QUESTION_LIST</code> token is representing the
	 * constants for SQL query, which is fetching
	 * 
	 * <pre>
	 * SEQ_QUE_ID,SEQ_QUESTION
	 * </pre>
	 * 
	 * from <code>TAB_SECURITY_QUESTION_LIST</code>.
	 */
	public static final String GET_SECURITY_QUESTION_LIST = "SELECT SEQ_QUE_ID,SEQ_QUESTION "
			+ "FROM TAB_SECURITY_QUESTION_LIST";

	/**
	 * <p>
	 * <code>UPDATE_USER_STATUS</code> token is representing the constants for
	 * SQL query, that get the change email details.
	 * </p>
	 * 
	 * from <code>TAB_CUSTOMER_USER</code> .
	 */
	public static final String UPDATE_USER_STATUS = "UPDATE TAB_CUSTOMER_USER SET USER_STATUS=?, "
			+ "CLOSE_ACCOUNT_UPDATION_DATE=? WHERE CUSTOMER_ID=?";

	/**
	 * <p>
	 * <code>UPDATE_CONTACT_DETAILS</code> token is representing the constants
	 * for SQL query, which is inserting records into <code>TAB_CONTACT</code> .
	 * 
	 */
	public static final String UPDATE_CONTACT_DETAILS = "UPDATE TAB_CONTACT SET SALUTATION=?, GROUP_NAME_REF=?, NICK_NAME=?,"
			+ "DESIGNATION_REF=?, PHONE_NUMBER=?, REFERRED_BY=?, MOBILE_NUMBER1=?, MOBILE_NUMBER2=?,"
			+ "EMAIL_ID=?, HOME_CONTACT_ADDRESS_LINE1=?, HOME_CONTACT_ADDRESS_LINE2=?, HOME_CONTACT_CITY=?, "
			+ "HOME_CONTACT_STATE=?, HOME_CONTACT_COUNTRY_REF=?, HOME_CONTACT_ZIPCODE=?,HOME_CONTACT_PHONE_NUMBER=?,"
			+ " HOME_CONTACT_MOBILE_NUMBER=?, HOME_CONTACT_EMAIL_ID=?, HOME_CONTACT_FAX_NUMBER=?, WORK_CONTACT_ADDRESS_LINE1=?,"
			+ "WORK_CONTACT_ADDRESS_LINE2=?, WORK_CONTACT_CITY=?, WORK_CONTACT_STATE=?, WORK_CONTACT_COUNTRY_REF=?,"
			+ " WORK_CONTACT_ZIPCODE=?, WORK_CONTACT_PHONE_NUMBER=?, WORK_CONTACT_MOBILE_NUMBER=?, WORK_CONTACT_EMAIL_ID=?,"
			+ " WORK_CONTACT_FAX_NUMBER=?, PROFILE_DESCRIPTION=?, CREATED_DATE=?, CREATED_BY=?,CONTACT_PERSON=?,"
			+ "FAX=?,IMAGE_UPLOAD_PATH=?, REFERENCE_ID=? WHERE CONTACT_ID=?";

	/**
	 * <p>
	 * <code>GET_CUSTOMER_DETAILS</code> token is representing the constants for
	 * SQL query, which is fetching records from <code>TAB_CUSTOMER_USER</code>
	 * .
	 * 
	 */
	public static final String GET_CUSTOMER_DETAILS = "SELECT * FROM TAB_CUSTOMER_USER WHERE CUSTOMER_ID=?";

	/**
	 * <p>
	 * <code>GET_LEAD_FOLLOWUP_DETAILS</code> token is representing the
	 * constants for SQL query, which is fetching
	 * 
	 * <pre>
	 * CUSTOMER_ID,FOLLOWUP_DATE,REF_FOLLOWUP_BY,FOLLOWUP_STATUS,COMMENT
	 * </pre>
	 * 
	 * from <code>TAB_LEAD_FOLLOWUP</code> .
	 */
	public static final String GET_LEAD_FOLLOWUP_DETAILS_REPORTS = "SELECT FOLLOWUP_ID,FOLLOWUP_DATE,FOLLOWUP_STATUS,"
			+ "REF_FOLLOWUP_BY,CREATED_BY,COMMENT FROM TAB_LEAD_FOLLOWUP ";

	/**
	 * <p>
	 * <code>GET_LEAD_SOCIAL_DETAILS</code> token is representing the constants
	 * for SQL query, which is fetching
	 * 
	 * <pre>
	 * SOCIAL_SITE_REF,SOCIAL_CONTACT_VALUE
	 * </pre>
	 * 
	 * from <code>TAB_SOCIAL_CONTACT</code>.
	 */
	public static final String GET_LEAD_ID = "SELECT LEAD_ID FROM TAB_LEAD_DETAILS";

	/**
	 * <p>
	 * <code>GET_LEAD_SOCIAL_DETAILS</code> token is representing the constants
	 * for SQL query, which is fetching
	 * 
	 * <pre>
	 * SOCIAL_SITE_REF,SOCIAL_CONTACT_VALUE
	 * </pre>
	 * 
	 * from <code>TAB_SOCIAL_CONTACT</code>.
	 */
	public static final String GET_LEAD_COMPANY_NAME = "SELECT COMPANY_NAME FROM TAB_LEAD_DETAILS";

	/**
	 * <p>
	 * <code>GET_COMPANY_DETAILS</code>this token is representing the constants
	 * for SQL query, which is fetching recordS from
	 * <code>TAB_COMPANY_DETAILS</code> .
	 */

	public static final String GET_COMPANY_DETAILS = "SELECT * FROM TAB_COMPANY_DETAILS WHERE COMPANY_ID=?";

	/**
	 * <p>
	 * <code>UPDATE_USER_STATUS_CLOSE</code> token is representing the constants
	 * for SQL query, that get the change email details.
	 * </p>
	 * 
	 * from <code>TAB_CUSTOMER_USER</code> .
	 */
	public static final String UPDATE_USER_STATUS_CLOSE = "UPDATE TAB_CUSTOMER_USER SET USER_STATUS=?, "
			+ "CLOSE_ACCOUNT_UPDATION_DATE=? WHERE CLOSE_ACCOUNT_REF_NO=?";

	/**
	 * <p>
	 * <code>TAB_CUSTOMER_USER</code> token is representing the constants for
	 * SQL query, which is updating the close account details
	 * </p>
	 * 
	 * <pre>
	 * PASSWORD
	 * </pre>
	 * 
	 * from <code>TAB_CUSTOMER_USER</code> .
	 */
	public static final String UPDATE_CLOSE_ACCOUNT_DETAILS = "UPDATE TAB_CUSTOMER_USER SET CLOSE_ACCOUNT_COMMENT=?,CLOSE_ACCOUNT_REASON=?,"
			+ "CLOSE_ACCOUNT_REF_NO=?,CLOSE_ACCOUNT_UPDATION_DATE=? WHERE CUSTOMER_ID=?";

	/**
	 * <p>
	 * <code>UPDATE_COMPANY_DETAILS</code> token is representing the constants
	 * for SQL query, which is updating record into table
	 * <code>TAB_COMPANY_DETAILS</code> .
	 * 
	 */
	public static final String UPDATE_COMPANY_DETAILS = "UPDATE TAB_COMPANY_DETAILS SET COMPANY_NAME=?,TRADE_NAME=?,REGISTRATION_NO=?"
			+ ",ADDRESS_LINE_1=?,ADDRESS_LINE_2=?,CITY=?,STATE=?,ZIPCODE=?,PHONE_NO=?,MOBILE_NO=?,FAX_NO=?,COMPANY_URL=?,FACEBOOK_DETAIL=?"
			+ ",GOOGLE_PLUS_DETAIL=?,LINKED_IN_DETAIL=?,TWITTER_DETAIL=?,BLOG_DETAIL=?,YOUTUBE_DETAIL=?,REF_COMPANY_TYPE=?"
			+ ",REF_COMPANY_CATEGORY=?,REF_COMPANY_SECTOR=?,REF_COUNTRY=?,REF_TIMEZONE=?,REF_CURRENCY=?,REF_LANGUAGE=? WHERE COMPANY_ID=?";

	/**
	 * <p>
	 * <code>GET_CAMPAIGN_TYPE_NAME_LIST</code>this token is representing the
	 * constants for SQL query, which is fetching
	 * </p>
	 * 
	 * <pre>
	 * CAMPAIGN_TYPE_ID ,CAMPAIGN_TYPE_NAME
	 * </pre>
	 * 
	 * from <code>TAB_PRODUCT</code>.
	 */
	public static final String GET_CAMPAIGN_TYPE_NAME_LIST = "SELECT CAMPAIGN_TYPE_ID,CAMPAIGN_TYPE_NAME FROM TAB_CAMPAIGN_TYPE";

	/**
	 * <p>
	 * <code>GET_CAMPAIGN_OWNER_NAME_LIST</code>this token is representing the
	 * constants for SQL query, which is fetching
	 * </p>
	 * 
	 * <pre>
	 * CUSTOMER_ID ,FULL_NAME
	 * </pre>
	 * 
	 * from <code>TAB_CUSTOMER_USER</code>.
	 */
	public static final String GET_CAMPAIGN_OWNER_NAME_LIST = "SELECT CUSTOMER_ID,FULL_NAME FROM TAB_CUSTOMER_USER";

	/**
	 * <p>
	 * <code>GET_CAMPAIGN_ASSIGNED_TO_NAME_LIST</code>this token is representing
	 * the constants for SQL query, which is fetching
	 * </p>
	 * 
	 * <pre>
	 * CUSTOMER_ID ,FULL_NAME
	 * </pre>
	 * 
	 * from <code>TAB_CUSTOMER_USER</code>.
	 */
	public static final String GET_CAMPAIGN_ASSIGNED_TO_NAME_LIST = "SELECT CUSTOMER_ID,FULL_NAME FROM TAB_CUSTOMER_USER";

	/**
	 * <p>
	 * <code>ADD_CAMPAIGN_DETAIL</code> token is representing the constants for
	 * SQL query, which is fetching records from <code>TAB_CAMPAIGN</code> .
	 */
	public static final String ADD_CAMPAIGN_DETAIL = "INSERT INTO TAB_CAMPAIGN(CAMPAIGN_NAME,SALUTATION,REF_CAMPAIGN_OWNER,"
			+ "EXPECTED_CLOSE_DATE,REF_ASSIGNED_TO,REF_PRODUCT,REF_CAMPAIGN_TYPE,CAMPAIGN_STATUS,TARGET_AUDIENCE,"
			+ "TARGET_SIZE,SPONSOR,NUM_SENT,BUDGET_COST,ACTUAL_COST,EXPECTED_REVENUE,EXPECTED_RESPONSE,"
			+ "EXPECTED_SALES_COUNT,ACTUAL_SALES_COUNT,EXPECTED_RESPONSE_COUNT,ACTUAL_RESPONSE_COUNT,EXPECTED_ROI,"
			+ "ACTUAL_ROI,DESCRIPTION,CREATED_BY,CREATED_DATE)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

	/**
	 * <p>
	 * <code>GET_CAMPAIGN_DETAILS_LIST</code> token is representing the
	 * constants for SQL query, which is fetching records from
	 * <code>TAB_CAMPAIGN</code> .
	 */
	public static final String GET_CAMPAIGN_DETAILS_LIST = "SELECT CAMPAIGN_ID,SALUTATION,CAMPAIGN_NAME,EXPECTED_CLOSE_DATE,"
			+ "REF_ASSIGNED_TO,REF_CAMPAIGN_TYPE,CAMPAIGN_STATUS,EXPECTED_REVENUE FROM TAB_CAMPAIGN";

	/**
	 * <p>
	 * <code>GET_CAMPAIGN_OWNER_NAME</code>this token is representing the
	 * constants for SQL query, which is fetching
	 * </p>
	 * 
	 * <pre>
	 * FULL_NAME
	 * </pre>
	 * 
	 * from <code>TAB_CUSTOMER_USER</code>.
	 */

	public static final String GET_CAMPAIGN_OWNER_NAME = "SELECT FULL_NAME FROM TAB_CUSTOMER_USER "
			+ "WHERE CUSTOMER_ID=?";

	/**
	 * <p>
	 * <code>GET_CAMPAIGN_ASSIGNED_TO_NAME</code>this token is representing the
	 * constants for SQL query, which is fetching
	 * </p>
	 * 
	 * <pre>
	 * FULL_NAME
	 * </pre>
	 * 
	 * from <code>TAB_CUSTOMER_USER</code>.
	 */

	public static final String GET_CAMPAIGN_ASSIGNED_TO_NAME = "SELECT FULL_NAME FROM TAB_CUSTOMER_USER "
			+ "WHERE CUSTOMER_ID=?";

	/**
	 * <p>
	 * <code>GET_CAMPAIGN_TYPE_NAME</code>this token is representing the
	 * constants for SQL query, which is fetching
	 * </p>
	 * 
	 * <pre>
	 * CAMPAIGN_TYPE_NAME
	 * </pre>
	 * 
	 * from <code>TAB_CAMPAIGN_TYPE</code>.
	 */

	public static final String GET_CAMPAIGN_TYPE_NAME = "SELECT CAMPAIGN_TYPE_NAME FROM TAB_CAMPAIGN_TYPE "
			+ "WHERE CAMPAIGN_TYPE_ID=?";

	/**
	 * <p>
	 * <code>GET_ACCOUNT_NAME</code>this token is representing the constants for
	 * SQL query, which is fetching
	 * </p>
	 * 
	 * <pre>
	 * ACCOUNT_NAME
	 * </pre>
	 * 
	 * from <code>TAB_ACCOUNT</code>.
	 */
	public static final String GET_ACCOUNT_NAME = "SELECT ACCOUNT_NAME FROM TAB_ACCOUNT "
			+ "WHERE ACCOUNT_ID=?";

	/**
	 * <p>
	 * <code>VIEW_CAMPAIGN_DETAILS_NAME</code> token is representing the
	 * constants for SQL query.
	 * </p>
	 * 
	 * from <code>TAB_CAMPAIGN</code> .
	 */
	public static final String VIEW_CAMPAIGN_DETAILS_NAME = "SELECT * FROM TAB_CAMPAIGN WHERE CAMPAIGN_ID=?";

	/**
	 * <p>
	 * <code>DELETE_CAMPAIGN_DETAILS</code> token is representing the constants
	 * for SQL query, which is deleting to <code>TAB_CAMPAIGN</code> based on
	 * the CAMPAIGN_ID .
	 */
	public static final String DELETE_CAMPAIGN_DETAILS = " DELETE FROM TAB_CAMPAIGN WHERE CAMPAIGN_ID=?";

	/**
	 * <p>
	 * <code>SELECT_CAMPAIGN_DETAILS_NAME</code> token is representing the
	 * constants for SQL query.
	 * </p>
	 * 
	 * from <code>TAB_CAMPAIGN</code> .
	 */
	public static final String SELECT_CAMPAIGN_DETAILS_NAME = "SELECT * FROM TAB_CAMPAIGN WHERE CAMPAIGN_ID=?";

	/**
	 * <p>
	 * <code>UPDATE_CAMPAIGN_DETAILS</code> token is representing the constants
	 * for SQL query, which is updating lead information.
	 * </p>
	 * 
	 * 
	 * from <code>TAB_CAMPAIGN</code> .
	 */
	public static final String UPDATE_CAMPAIGN_DETAILS = "UPDATE TAB_CAMPAIGN SET CAMPAIGN_NAME=?,SALUTATION=?,REF_CAMPAIGN_OWNER=?,"
			+ "EXPECTED_CLOSE_DATE=?,REF_ASSIGNED_TO=?,REF_PRODUCT=?,REF_CAMPAIGN_TYPE=?,CAMPAIGN_STATUS=?,TARGET_AUDIENCE=?,"
			+ "TARGET_SIZE=?,SPONSOR=?,NUM_SENT=?,BUDGET_COST=?,ACTUAL_COST=?,EXPECTED_REVENUE=?,EXPECTED_RESPONSE=?,"
			+ "EXPECTED_SALES_COUNT=?,ACTUAL_SALES_COUNT=?,EXPECTED_RESPONSE_COUNT=?,ACTUAL_RESPONSE_COUNT=?,EXPECTED_ROI=?,"
			+ "ACTUAL_ROI=?,DESCRIPTION=?,UPDATED_BY=?,UPDATED_DATE=? WHERE CAMPAIGN_ID=?";

	/**
	 * <p>
	 * <code>SHOW_CAMPAIGN_PRINT_PDF</code> token is representing the constants
	 * for SQL query, which is fetching records from <code>TAB_CAMPAIGN</code> .
	 */
	public static final String SHOW_CAMPAIGN_PRINT_PDF = "SELECT * FROM TAB_CAMPAIGN WHERE CAMPAIGN_ID=?";

	/**
	 * <p>
	 * <code>GET_PAREN_ACCOUNT_LIST</code> token is representing the constants
	 * for SQL query, which is fetching
	 * 
	 * <pre>
	 * ACCOUNT_ID,ACCOUNT_NAME
	 * </pre>
	 * 
	 * from <code>TAB_ACCOUNT</code>.
	 */

	public static final String GET_PAREN_ACCOUNT_LIST = "SELECT ACCOUNT_ID,ACCOUNT_NAME FROM TAB_ACCOUNT";

	/**
	 * <p>
	 * <code>GET_PAREN_ACCOUNT_LIST</code> token is representing the constants
	 * for SQL query, which is fetching
	 * 
	 * <pre>
	 * ACCOUNT_ID,CONTACT_PERSON
	 * </pre>
	 * 
	 * from <code>TAB_ACCOUNT</code>.
	 */

	public static final String GET_ACCOUNT_OWNER_LIST = "SELECT CONTACT_PERSON FROM TAB_ACCOUNT "
			+ "WHERE CONTACT_PERSON!=NULL OR CONTACT_PERSON!=''";

	/**
	 * <p>
	 * <code>INSERT_EXPENSES_DETAILS</code> token is representing the constants
	 * for SQL query, which is inserting records into <code>TAB_EXPENSES</code>
	 */
	public static final String INSERT_EXPENSES_DETAILS = "INSERT INTO TAB_EXPENSES"
			+ "(NAME,PLACE_OF_VISIT,PURPOSE_OF_VISIT,DEPARTURE_DATE,"
			+ "ARRIVAL_DATE,TOTAL_AMOUNT_A,TOTAL_AMOUNT_B,"
			+ "C_DAILY_ALLOWANCE,D_CONVEYANCE_EXPENCES,E_CONVEYANCE_EXPENCES,"
			+ "F_LAUNDRY_EXPENCES,G_OTHER_EXPENSES,1_ADVANCE_RECEIVED,2_TICKET_BOOKED_BY_COMPANY,3_HOTEL_BOOKED_BY_COMPANY,"
			+ "4_CONVEYANCE_EXPENCES,5_ADVANCE_RECEIVED_FROM_OTHER_BRANCH,H_TOTAL_A_TO_G,GRANT_TOTAL_BALANCE,"
			+ "EXPENSES_REF_NO,APPROVED_BY,CREATED_BY,CREATION_DATE,I_TOTAL_ADVANCE,CLAMING_BY)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

	/**
	 * <p>
	 * <code>GET_EXPENSES_ID</code> token is representing the constants for SQL
	 * query, which is fatching records from <code>TAB_EXPENSES</code> based on
	 * the EXPENSES_REF_NO.
	 */
	public static final String GET_EXPENSES_ID = "SELECT CLAIM_ID FROM TAB_EXPENSES WHERE EXPENSES_REF_NO=?";

	/**
	 * <p>
	 * <code>ADD_TICKET_INFO</code> token is representing the constants for SQL
	 * query, which is inserting records into <code>TAB_TICKET_FARE_TEMP</code>
	 */
	public static final String ADD_TICKET_INFO = "INSERT INTO TAB_EXPENSES_TICKET_FARE(DETARTURE_PLACE,TICKE_DEPARTURE_DATE,"
			+ "ARRIVAL_PLACE,TICKET_ARRIVAL_DATE,TRAVEL_MODE,TICKET_AMOUNT,CREATED_BY,TICKET_REF_NO) VALUES (?,?,?,?,?,?,?,?)";

	/**
	 * <p>
	 * <code>ADD_BOARDING_INFO</code> token is representing the constants for
	 * SQL query, which is inserting records into <code>TAB_BOARDING_TEMP</code>
	 */
	public static final String ADD_BOARDING_INFO = "INSERT INTO TAB_EXPENSES_BOARDING(HOTEL_NAME,PLACE,"
			+ "FROM_DATE,TO_DATE,BILL_NUMBER,BOARDING_AMOUNT,BOARDING_TOTAL_FARE) VALUES (?,?,?,?,?,?,?)";

	/**
	 * <p>
	 * <code>GET_TRAVEL_MODE_LIST</code> token is representing the constants for
	 * SQL query, which is fatching records from <code>TAB_TRAVEL_MODE</code>
	 */
	public static final String GET_TRAVEL_MODE_LIST = "SELECT TRAVEL_MODE_ID,TRAVEL_MODE FROM TAB_TRAVEL_MODE";

	public static final String ADD_HOTEL_INFO = "INSERT INTO TAB_EXPENSES_BOARDING(HOTEL_NAME,PLACE,"
			+ "FROM_DATE,TO_DATE,BILL_NUMBER,BOARDING_AMOUNT,CREATED_BY,BOARDING_REF_NO) VALUES (?,?,?,?,?,?,?,?)";

	/**
	 * <p>
	 * <code>SHOW_LIST_TICKET_DETAILS</code> token is representing the constants
	 * for SQL query, which is fetching Ticket List from
	 * <code>TAB_EXPENSES_TICKET_FARE</code> table
	 */
	public static final String SHOW_LIST_TICKET_DETAILS = "SELECT * FROM TAB_EXPENSES_TICKET_FARE WHERE TICKET_REF_NO=?";

	/**
	 * <p>
	 * <code>SHOW_LIST_TICKET_DETAILS</code> token is representing the constants
	 * for SQL query, which is fetching Ticket List from
	 * <code>TAB_EXPENSES_TICKET_FARE</code> table
	 */
	public static final String SHOW_LIST_TICKET_DETAILS_BY_ID = "SELECT * FROM TAB_EXPENSES_TICKET_FARE WHERE EXPENSES_TICKET_CLAIM_ID=?";

	/**
	 * <p>
	 * <code>SHOW_LIST_BOARDING_DETAILS</code> token is representing the
	 * constants for SQL query, which is fetching Boarding List from
	 * <code>TAB_EXPENSES_BOARDING</code> table
	 */
	public static final String SHOW_LIST_BOARDING_DETAILS = "SELECT * FROM TAB_EXPENSES_BOARDING WHERE BOARDING_REF_NO=?";

	/**
	 * <p>
	 * <code>INSERT_SUPPORT_FAQ</code> token is representing the constants for
	 * SQL query, which is Insert data from TAB_SUPPORT_FAQ
	 * <code>TAB_SUPPORT_FAQ</code> based on the support Id
	 */

	/**
	 * <p>
	 * <code>GET_CONTACT_PERSON_NAME_LIST</code> token is representing the
	 * constants for SQL query, which is fetching
	 * 
	 * <pre>
	 * CONTACT_PERSON
	 * </pre>
	 * 
	 * from <code>TAB_LEAD_DETAILS</code>.
	 */

	public static final String GET_CONTACT_PERSON_NAME_LIST = "SELECT CONTACT_PERSON FROM TAB_LEAD_DETAILS WHERE CONTACT_PERSON!=NULL OR CONTACT_PERSON!=' ' ";

	/**
	 * <p>
	 * <code>GET_FAQ_PRODUCT_NAME_LIST</code>this token is representing the
	 * constants for SQL query, which is fetching
	 * </p>
	 * 
	 * <pre>
	 * PRODUCT_ID ,PRODUCT_NAME
	 * </pre>
	 * 
	 * from <code>TAB_PRODUCT</code>.
	 */

	public static final String CALCULATE_AMOUNT_A = "SELECT SUM(TICKET_AMOUNT) AS CALCULATE_AMOUNT_A FROM TAB_EXPENSES_TICKET_FARE WHERE TICKET_REF_NO=?";

	/**
	 * <p>
	 * <code>CALCULATE_AMOUNT_B</code> token is representing the constants for
	 * SQL query, which is fetching
	 * 
	 * <pre>
	 * CALCULATE_AMOUNT_B
	 * </pre>
	 * 
	 * from <code>TAB_EXPENSES_BOARDING</code>.
	 */
	public static final String CALCULATE_AMOUNT_B = "SELECT SUM(BOARDING_AMOUNT) AS CALCULATE_AMOUNT_B FROM TAB_EXPENSES_BOARDING WHERE BOARDING_REF_NO=?";

	/**
	 * <p>
	 * <code>ADD_CLAIM_ID</code> token is representing the constants for SQL
	 * query, which is update
	 * 
	 * <pre>
	 * EXPENSES_TICKET_CLAIM_ID
	 * </pre>
	 * 
	 * into <code>TAB_EXPENSES_TICKET_FARE</code>.
	 */
	public static final String ADD_CLAIM_ID = "UPDATE TAB_EXPENSES_TICKET_FARE SET EXPENSES_TICKET_CLAIM_ID=? WHERE TICKET_REF_NO=?";

	/**
	 * <p>
	 * <code>ADD_BOARDING_CLAIM_ID</code> token is representing the constants
	 * for SQL query, which is update
	 * 
	 * <pre>
	 * EXPENSES_BOARDING_CLAIM_ID
	 * </pre>
	 * 
	 * into <code>TAB_EXPENSES_BOARDING</code>.
	 */
	public static final String ADD_BOARDING_CLAIM_ID = "UPDATE TAB_EXPENSES_BOARDING SET EXPENSES_BOARDING_CLAIM_ID=? WHERE BOARDING_REF_NO=?";

	/**
	 * <p>
	 * <code>SHOW_CLAIM_EXPENSES_LIST</code> token is representing the constants
	 * for SQL query, which is fetch
	 * 
	 * <pre>
	 * Expenses Details
	 * </pre>
	 * 
	 * from <code>TAB_EXPENSES</code>.
	 */
	public static final String SHOW_CLAIM_EXPENSES_LIST = "SELECT * FROM TAB_EXPENSES";

	/**
	 * <p>
	 * <code>GET_ACCOUNT_NAME_LIST</code> token is representing the constants
	 * for SQL query, which is fetching
	 * 
	 * <pre>
	 * ACCOUNT_ID,ACCOUNT_NAME
	 * </pre>
	 * 
	 * records from <code>TAB_ACCOUNT</code> .
	 */
	public static final String GET_ACCOUNT_NAME_LIST = "SELECT ACCOUNT_ID,ACCOUNT_NAME FROM TAB_ACCOUNT";

	/**
	 * <p>
	 * <code>GET_CUSTOMER_USER_LIST</code>this token is representing the
	 * constants for SQL query, which is fetching
	 * </p>
	 * 
	 * <pre>
	 * CUSTOMER_ID ,FULL_NAME
	 * </pre>
	 * 
	 * from <code>TAB_CUSTOMER_USER</code>.
	 */
	public static final String GET_CUSTOMER_USER_LIST = "SELECT CUSTOMER_ID,FULL_NAME FROM TAB_CUSTOMER_USER";

	/**
	 * <p>
	 * <code>GET_CONTACT_NAME_LIST</code>this token is representing the
	 * constants for SQL query, which is fetching
	 * </p>
	 * 
	 * <pre>
	 * CONTACT_ID ,CONTACT_NAME
	 * </pre>
	 * 
	 * from <code>TAB_CONTACT</code>.
	 */
	public static final String GET_CONTACT_NAME_LIST = "SELECT CONTACT_ID,CONTACT_PERSON FROM TAB_CONTACT";

	/**
	 * <p>
	 * <code>GET_LEAD_LIST</code>this token is representing the constants for
	 * SQL query, which is fetching
	 * </p>
	 * 
	 * <pre>
	 * LEAD_ID ,CONTACT_PERSON
	 * </pre>
	 * 
	 * from <code>TAB_LEAD</code>.
	 */
	public static final String GET_LEAD_LIST = "SELECT LEAD_ID,CONTACT_PERSON FROM TAB_LEAD_DETAILS";

	/**
	 * <p>
	 * <code>GET_CAMPAIGN_LIST</code>this token is representing the constants
	 * for SQL query, which is fetching
	 * </p>
	 * 
	 * <pre>
	 * CAMPAIGN_ID ,CAMPAIGN_NAME
	 * </pre>
	 * 
	 * from <code>TAB_CAMPAIGN</code>.
	 */
	public static final String GET_CAMPAIGN_LIST = "SELECT CAMPAIGN_ID,CAMPAIGN_NAME FROM TAB_CAMPAIGN";

	/**
	 * <p>
	 * <code>GET_LEAD_SOURCE_NAME_LIST</code> token is representing the
	 * constants for SQL query, which is fetching
	 * 
	 * <pre>
	 * LEAD_SOURCE_ID,LEAD_SOURCE_NAME
	 * </pre>
	 * 
	 * records from <code>TAB_LEAD_SOURCE</code> .
	 */
	public static final String GET_LEAD_SOURCE_NAME_LIST = "SELECT LEAD_SOURCE_ID,LEAD_SOURCE_NAME FROM TAB_LEAD_SOURCE";

	/**
	 * <p>
	 * <code>INSERT_NOTE_DECRIPTION</code>this token is representing the
	 * constants for SQL query, which is Inserting
	 * </p>
	 * 
	 * <pre>
	 * NOTE_TITLE,NOTE,TAG,NOTE_DESC,CREATION_DATE,CREATED_BY
	 * </pre>
	 * 
	 * into <code>TAB_NOTE</code>.
	 */
	public static final String INSERT_NOTE_DECRIPTION = "INSERT INTO TAB_NOTE(NOTE_TITLE,NOTE_TAG,NOTE_DESC,CREATION_DATE,CREATED_BY) VALUES(?,?,?,?,?)";
	/**
	 * <p>
	 * <code>GET_data into Grid from database </code>this token is representing
	 * the select data for SQL query, which is fetching
	 * </p>
	 * 
	 * <pre>
	 * NOTE_ID,NOTE_TITLE,NOTE_TAG,CREATION_DATE,CREATED_BY
	 * </pre>
	 * 
	 * from <code>TAB_NOTE</code>.
	 */

	public static final String SELECT_NOTE_DETAILS = "SELECT NOTE_ID,NOTE_TAG,NOTE_TITLE,CREATED_BY,"
			+ "CREATION_DATE FROM TAB_NOTE";

	/**
	 * <p>
	 * <code>SHOW_CLAIM_EXPENSES_DETAILS </code>this token is representing the
	 * select data for SQL query, which is fetching
	 * </p>
	 * 
	 * <pre>
	 * TAB_EXPENSES details
	 * </pre>
	 * 
	 * from <code>TAB_EXPENSES</code>.
	 */
	public static final String SHOW_CLAIM_EXPENSES_DETAILS = "SELECT * FROM TAB_EXPENSES WHERE CLAIM_ID=?";

	/**
	 * <p>
	 * <code>ADD_MONTHLY_OTHER_DETAILS</code> token is representing the
	 * constants for SQL query, which is use to Insert Data
	 * 
	 * <pre>
	 * 
	 * </pre>
	 * 
	 * from <code>TAB_EXPENSES_MONTHLY_OTHER</code>.
	 */

	public static final String ADD_MONTHLY_OTHER_DETAILS = "INSERT INTO TAB_EXPENSES_MONTHLY_OTHER(DATE_AND_TIME,PLACE, ITME,AMOUNT,CREATED_BY,Monthly_Other_Ref_No) VALUES(?,?,?,?,?,?)";

	/**
	 * <p>
	 * <code>GET_data into add new page from database </code>this token is
	 * representing the select data for SQL query, which is fetching
	 * </p>
	 * 
	 * <pre>
	 * NOTE_ID,NOTE_TITLE,NOT_DEC,NOTE_TAG,CREATEDBY,CREATIONDATE
	 * </pre>
	 * 
	 * from <code>TAB_NOTE</code>.
	 */

	public static final String SHOW_VIEW_NOTE = "SELECT * FROM TAB_NOTE WHERE NOTE_ID=?";
	/**
	 * <p>
	 * <code>UPDATE_data database </code>this token is representing the update
	 * data for SQL query, which is updating
	 * </p>
	 * 
	 * <pre>
	 * NOTE_TITLE,NOT_DEC,NOTE_TAG,CREATEDBY,CREATIONDATE
	 * </pre>
	 * 
	 * from <code>TAB_NOTE</code>.
	 */

	public static final String UPDATE_NOTE_DETAILS = "UPDATE TAB_NOTE SET NOTE_TITLE=?,NOTE_TAG=?,"
			+ "NOTE_DESC=?,UPDATION_DATE=?,UPDATED_BY=? WHERE NOTE_ID=?";

	/**
	 * <p>
	 * <code>GET_LAST_NOTERECORD</code> token is representing the constants for
	 * SQL query, which is getting last note record <code>LEAD_ID</code> from
	 * <code>TAB_NOTE</code> .
	 */
	public static final String GET_LAST_NOTERECORD_ID = "SELECT  NOTE_ID FROM TAB_NOTE GROUP BY NOTE_ID DESC LIMIT 1";

	/**
	 * <p>
	 * <code>UPDATE_CUSTOMER_CURRENT_LOGIN_PASSWORD</code> token is representing
	 * the constants for SQL query, which is getting last note record
	 * <code>LEAD_ID</code> from <code>TAB_CUSTOMER_USER</code> .
	 */
	public static final String UPDATE_CUSTOMER_CURRENT_LOGIN_PASSWORD = "UPDATE TAB_CUSTOMER_USER SET PASSWORD=?,LOGIN_FLAG=? WHERE CUSTOMER_ID=?";

	/**
	 * <p>
	 * <code>UPDATE_CUSTOMER_CURRENT_LOGIN_PASSWORD</code> token is representing
	 * the constants for SQL query, which is getting last note record
	 * <code>LEAD_ID</code> from <code>TAB_CUSTOMER_USER</code> .
	 */
	public static final String UPDATE_CUSTOMER_CONF_SETTING = "UPDATE TAB_CUSTOMER_USER SET REF_CURRENCY=?,LANGUAGE=?,TIME_ZONE=?,LOGIN_FLAG=? WHERE CUSTOMER_ID=?";

	/**
	 * <p>
	 * <code>GET_UPDATED_PASSWORD</code> token is representing the constants for
	 * SQL query, which is getting PASSWORD <code>PASSWORD</code> from
	 * <code>TAB_CUSTOMER_USER</code> .
	 */
	public static final String GET_UPDATED_PASSWORD = "SELECT CUSTOMER_ID,PRIMARY_EMAIL_ID,PASSWORD FROM TAB_CUSTOMER_USER WHERE CUSTOMER_ID=?";

	/**
	 * <p>
	 * <code>SHOW_PRODUCT_DETAILS_FOR_UPDATE</code> token is Show the product
	 * details for Grid.
	 * <code>PRODUCT_NAME,PRODUCT_CODE,PRODUCT_CATEGORY,VENDOR_NAME,MANUFACTURER,SALES_START_DATE,SALES_END_DATE," +
			"SUPPORT_TART_DATE,SUPPORT_EXPIRY_DATE,SERIAL_NO,MFR_PART_NO,VENDOR_PART_NO,PRODUCT_SHEET,WEBSITE,GL_ACCOUNT,UNIT_PRICE,COMMISION_RATE,TAX,PURCHASE_COST,USAGE_UNIT,QTY_PER_UNIT," +
			"QTY_IN_STOCK,REORDER_LAVEL,HANDLER,QTY_IN_DEMAND,PRODUCT_IMAGE_ATTACHMENT,PRODUCT_IMAGE,DESCRIPTION,CREATED_BY</code>
	 * from <code>TAB_PRODUCT_DETAILS</code> .
	 */
	public static final String SHOW_PRODUCT_DETAILS_FOR_UPDATE = "SELECT * FROM TAB_PRODUCT_DETAILS WHERE PRODUCT_ID=?";

	/**
	 * <p>
	 * <code>UPDATE_PRODUCT_DETAILS</code> token is Update the product details
	 * from database.
	 * <code>PRODUCT_NAME,PRODUCT_CODE,PRODUCT_CATEGORY,VENDOR_NAME,MANUFACTURER,SALES_START_DATE,SALES_END_DATE," +
			"SUPPORT_TART_DATE,SUPPORT_EXPIRY_DATE,SERIAL_NO,MFR_PART_NO,VENDOR_PART_NO,PRODUCT_SHEET,WEBSITE,GL_ACCOUNT,UNIT_PRICE,COMMISION_RATE,TAX,PURCHASE_COST,USAGE_UNIT,QTY_PER_UNIT," +
			"QTY_IN_STOCK,REORDER_LAVEL,HANDLER,QTY_IN_DEMAND,PRODUCT_IMAGE_ATTACHMENT,PRODUCT_IMAGE,DESCRIPTION,CREATED_BY</code>
	 * from <code>TAB_PRODUCT_DETAILS</code> .
	 */

	public static final String UPDATE_PRODUCT_DETAILS = "UPDATE TAB_PRODUCT_DETAILS SET PRODUCT_NAME=?,"
			+ "PRODUCT_CODE=?,PRODUCT_CATEGORY=?,VENDOR_NAME=?,MANUFACTURER=?,SALES_START_DATE=?,SALES_END_DATE=?,"
			+ "SUPPORT_TART_DATE=?,SUPPORT_EXPIRY_DATE=?,SERIAL_NO=?,MFR_PART_NO=?,VENDOR_PART_NO=?,PRODUCT_SHEET=?,"
			+ "WEBSITE=?,GL_ACCOUNT=?,UNIT_PRICE=?,COMMISION_RATE=?,TAX=?,PURCHASE_COST=?,USAGE_UNIT=?,QTY_PER_UNIT=?,"
			+ "QTY_IN_STOCK=?,REORDER_LAVEL=?,HANDLER=?,QTY_IN_DEMAND=?,PRODUCT_IMAGE_ATTACHMENT=?,PRODUCT_IMAGE=?,"
			+ "DESCRIPTION=?,CREATED_BY=? WHERE PRODUCT_ID=?";

	/**
	 * <p>
	 * <code>DELETE_VENDORS_DETAIL</code> token is Delete The vendor details
	 * from database <code>TAB_VENDORS</code> .
	 * <p>
	 * Based on VENDOR_ID
	 * </P>
	 */

	public static final String DELETE_VENDORS_DETAIL = "DELETE FROM TAB_VENDORS WHERE VENDOR_ID=?";

	/**
	 * <p>
	 * <code>SHOW_VIEW_PRODUCT</code> token is representing the constants for
	 * SQL query, which is Insert Data
	 * 
	 * <pre>
	 * 
	 * </pre>
	 * Author Roshan Patel from <code>SHOW_VIEW_PRODUCT</code>.
	 */
	public static final String SHOW_VIEW_PRODUCT = "SELECT * FROM TAB_PRODUCT_DETAILS WHERE PRODUCT_ID=?";

	/**
	 * <p>
	 * <code>GET_PRODUCT_NAME_LIST</code>this token is representing the
	 * constants for SQL query, which is fetching
	 * </p>
	 * 
	 * <pre>
	 * PRODUCT_ID ,PRODUCT_NAME
	 * </pre>
	 * 
	 * from <code>TAB_PRODUCT_DETAILS</code>.
	 */
	public static final String GET_PRODUCT_NAME_LIST = "SELECT PRODUCT_ID,PRODUCT_NAME FROM TAB_PRODUCT_DETAILS";

	/**
	 * <p>
	 * <code>INSERT_SUPPORT_FAQ</code> token is representing the constants for
	 * SQL query, which is Insert data from TAB_SUPPORT_FAQ
	 * <code>TAB_SUPPORT_FAQ</code> based on the support Id
	 */
	public static final String INSERT_SUPPORT_FAQ = "INSERT INTO TAB_SUPPORT_FAQ"
			+ "(QUESTION,ANSWER,REF_PRODUCT_NAME,REF_FAQ_CATEGORY,FAQ_STATUS,REF_FAQ_OWNER) VALUES(?,?,?,?,?,?)";

	/**
	 * <p>
	 * <code>GET_FAQ_CATEGORY_LIST</code> token is representing the constants
	 * for SQL query, which is fetching
	 * 
	 * <pre>
	 * CATEGORY_ID,CATEGORY_NAME
	 * </pre>
	 * 
	 * from <code>TAB_FAQ_CATEGORY</code>.
	 */

	public static final String GET_FAQ_CATEGORY_LIST = "SELECT CATEGORY_ID,CATEGORY_NAME "
			+ "FROM TAB_FAQ_CATEGORY";

	/**
	 * <p>
	 * <code>GET_FAQ_STATUS_LIST</code> token is representing the constants for
	 * SQL query, which is fetching
	 * 
	 * <pre>
	 * STATUS_ID,STATUS_NAME
	 * </pre>
	 * 
	 * from <code>TAB_FAQ_STATUS</code>.
	 */

	public static final String GET_FAQ_STATUS_LIST = "SELECT STATUS_ID,STATUS_NAME "
			+ "FROM TAB_FAQ_STATUS";

	/**
	 * <p>
	 * <code>GET_FAQ_GIRD_LIST</code> token is representing the constants for
	 * SQL query, which is fetching
	 * 
	 * <pre>
	 * FAQ_ID,QUESTION,ANSWER,PRODUCT_NAME,REF_FAQ_CATEGORY
	 * </pre>
	 * 
	 * from <code>TAB_SUPPORT_FAQ</code>.
	 */
	public static String GET_FAQ_GIRD_LIST = "SELECT FAQ_ID,QUESTION,ANSWER,REF_PRODUCT_NAME,REF_FAQ_CATEGORY,FAQ_STATUS,REF_FAQ_OWNER"
			+ " FROM TAB_SUPPORT_FAQ";

	/**
	 * <p>
	 * <code>GET_SUPPORT_FAQ_EDIT</code> token is representing the constants for
	 * SQL query, which is EDITING data from based FAQ_ID
	 * <code>TAB_SUPPORT_FAQ</code> based on the support Id
	 */

	public static final String GET_SUPPORT_FAQ_EDIT = "SELECT FAQ_ID,QUESTION,ANSWER,REF_PRODUCT_NAME,REF_FAQ_CATEGORY,"
			+ "FAQ_STATUS,REF_FAQ_OWNER FROM TAB_SUPPORT_FAQ WHERE FAQ_ID=?";
	/**
	 * <p>
	 * <code>GET_SUPPORT_FAQ_VIEW</code> token is representing the constants for
	 * SQL query, which is VIEW data from based FAQ_ID
	 * <code>TAB_SUPPORT_FAQ</code> based on the support Id
	 */

	public static final String GET_SUPPORT_FAQ_VIEW = "SELECT FAQ_ID,QUESTION,ANSWER,REF_PRODUCT_NAME,REF_FAQ_CATEGORY,"
			+ "FAQ_STATUS,REF_FAQ_OWNER FROM TAB_SUPPORT_FAQ WHERE FAQ_ID=?";
	/**
	 * <p>
	 * <code>UPDATE_SUPPORT_FAQ_INFORMATION</code> token is representing the
	 * constants for SQL query, which is updating
	 * 
	 * <pre>
	 * SET QUESTION=,ANSWER=?,PRODUCT_NAME=?,REF_FAQ_CATEGORY=?,REF_FAQ_STATUS=?,
	 * </pre>
	 * 
	 * WHERE <code>FAQ_ID</code>.
	 */
	public static final String UPDATE_SUPPORT_FAQ_INFORMATION = "UPDATE TAB_SUPPORT_FAQ SET QUESTION=?,"
			+ "ANSWER=?,REF_PRODUCT_NAME=?,REF_FAQ_CATEGORY=?,FAQ_STATUS=?,REF_FAQ_OWNER=? WHERE FAQ_ID=?";

	/**
	 * <p>
	 * <code>GET_CASES_STATUS_LIST</code> token is representing the constants
	 * for SQL query, which is fetching
	 * 
	 * <pre>
	 * STATUS_ID,STATUS_NAME
	 * </pre>
	 * 
	 * from <code>TAB_CASES_STATUS</code>.
	 */
	public static final String GET_CASES_STATUS_LIST = "SELECT STATUS_ID,STATUS_NAME "
			+ "FROM TAB_FAQ_STATUS";
	/**
	 * <p>
	 * <code>GET_CASES_PRIORITY_LIST</code> token is representing the constants
	 * for SQL query, which is fetching
	 * 
	 * <pre>
	 * PRIORITY_ID,PRIORITY_NAME
	 * </pre>
	 * 
	 * from <code>TAB_CASES_PRIORITY</code>.
	 */

	public static final String GET_CASES_PRIORITY_LIST = "SELECT PRIORITY_ID,PRIORITY_NAME "
			+ "FROM TAB_CASES_PRIORITY";

	/**
	 * <p>
	 * <code>GET_CASES_ASSIGNED_TO_LIST</code> token is representing the
	 * constants for SQL query, which is fetching
	 * 
	 * <pre>
	 * PRIORITY_ID,PRIORITY_NAME
	 * </pre>
	 * 
	 * from <code>TAB_CASES_ASSIGNED_TO</code>.
	 */
	public static final String GET_CASES_ASSIGNED_TO_LIST = "SELECT CUSTOMER_ID,FULL_NAME FROM "
			+ "TAB_CUSTOMER_USER";

	/**
	 * <p>
	 * <code>GET_CASES_TEAM_LIST</code> token is representing the constants for
	 * SQL query, which is fetching
	 * 
	 * <pre>
	 * TEAM_ID,TEAM_NAME
	 * </pre>
	 * 
	 * from <code>TAB_CASES_TEAM</code>.
	 */

	public static final String GET_CASES_TEAM_LIST = "SELECT TEAM_ID,TEAM_NAME "
			+ "FROM TAB_CASES_TEAM";

	/**
	 * <p>
	 * <code>GET_CASES_CHANNEL_LIST</code> token is representing the constants
	 * for SQL query, which is fetching
	 * 
	 * <pre>
	 * CHANNEL_ID,CHANNEL_NAME
	 * </pre>
	 * 
	 * from <code>TAB_CASES_CHANNEL</code>.
	 */
	public static final String GET_CASES_CHANNEL_LIST = "SELECT CHANNEL_ID,CHANNEL_NAME "
			+ "FROM TAB_CASES_CHANNEL";
	/**
	 * <p>
	 * <code>GET_CASES_CHANNEL_LIST</code> token is representing the constants
	 * for SQL query, which is fetching
	 * 
	 * <pre>
	 * IMPACT_TYPE_ID,IMPACT_TYPE_NAME
	 * </pre>
	 * 
	 * from <code>TAB_CASES_IMPACT_TYPE</code>.
	 */

	public static final String GET_CASES_IMPACT_TYPE_LIST = "SELECT IMPACT_TYPE_ID,IMPACT_TYPE_NAME "
			+ "FROM TAB_CASES_IMPACT_TYPE";
	/**
	 * <p>
	 * <code>GET_CASES_IMPACT_AREA_LIST</code> token is representing the
	 * constants for SQL query, which is fetching
	 * 
	 * <pre>
	 * IMPACT_AREA_ID,IMPACT_AREA_NAME
	 * </pre>
	 * 
	 * from <code>TAB_CASES_IMPACT_AREA</code>.
	 */

	public static final String GET_CASES_IMPACT_AREA_LIST = "SELECT IMPACT_AREA_ID,IMPACT_AREA_NAME "
			+ "FROM TAB_CASES_IMPACT_AREA";
	/**
	 * <p>
	 * <code>GET_CASES_RESOLUTION_TYPE_LIST</code> token is representing the
	 * constants for SQL query, which is fetching
	 * 
	 * <pre>
	 * RESOLUTION_TYPE_ID,RESOLUTION_TYPE_NAME
	 * </pre>
	 * 
	 * from <code>TAB_CASES_RESOLUTION_TYPE</code>.
	 */

	public static final String GET_CASES_RESOLUTION_TYPE_LIST = "SELECT RESOLUTION_TYPE_ID,RESOLUTION_TYPE_NAME "
			+ "FROM TAB_CASES_RESOLUTION_TYPE";

	/**
	 * <p>
	 * <code>INSERT_SUPPORT_CASES</code> token is representing the constants for
	 * SQL query, which is Insert Data
	 * 
	 * <pre>
	 * 
	 * </pre>
	 * 
	 * from <code>TAB_SUPPORT_CASES</code>.
	 */

	public static final String INSERT_SUPPORT_CASES = "INSERT INTO TAB_SUPPORT_CASES (CASES_TITLE,CONTACT_NAME,"
			+ "ORGANIZATION_NAME,PRIMARY_EMAIL,PRODUCT_NAME,RESOLUTION,SLA_NAME,REF_CASES_ASSIGNED_TO,REF_CASES_CHANNEL,"
			+ "REF_CASES_IMPACT_AREA,REF_CASES_IMPACT_TYPE,REF_CASES_PRIORITY,REF_CASES_TEAM,REF_CASES_RESOLUTION_TYPE,DEFERRD_DATE,CASES_STATUS)"
			+ " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

	/**
	 * <p>
	 * <code>GET_CASES_GIRD_LIST</code> token is representing the constants for
	 * SQL query, which is fetching
	 * 
	 * <pre>
	 * 
	 * </pre>
	 * 
	 * from <code>TAB_SUPPORT_CASES</code>.
	 */
	public static final String GET_CASES_GIRD_LIST = "SELECT * FROM TAB_SUPPORT_CASES";

	/**
	 * <p>
	 * <code>UPDATE_SUPPORT_CASES_INFORMATION</code> token is representing the
	 * constants for SQL query, which is updating
	 * 
	 * <pre>
	 * 
	 * </pre>
	 * 
	 * WHERE <code>CASES_ID</code>.
	 */
	public static final String UPDATE_SUPPORT_CASES_INFORMATION = "UPDATE TAB_SUPPORT_CASES SET CASES_TITLE=?,"
			+ "CONTACT_NAME=?,ORGANIZATION_NAME=?,PRIMARY_EMAIL=?,RESOLUTION=?,SLA_NAME=?,REF_CASES_ASSIGNED_TO=?,"
			+ "REF_CASES_CHANNEL=?,REF_CASES_IMPACT_AREA=?,REF_CASES_IMPACT_TYPE=?,REF_CASES_PRIORITY=?,"
			+ "REF_CASES_RESOLUTION_TYPE=?,CASES_STATUS=?,REF_CASES_TEAM=?,PRODUCT_NAME=?,DEFERRD_DATE=?"
			+ "WHERE CASES_ID=?";

	/*	*//**
	 * <p>
	 * <code>GET_SUPPORT_CASES_EDIT</code> token is representing the constants
	 * for SQL query, which is Editing
	 * 
	 * <pre>
	 * 
	 * </pre>
	 * 
	 * WHERE <code>CASES_ID</code>.
	 */

	public static final String GET_SUPPORT_CASES_EDIT = "SELECT CASES_ID,CASES_TITLE,CASES_STATUS,REF_CASES_PRIORITY,"
			+ "CONTACT_NAME,SLA_NAME,ORGANIZATION_NAME,REF_CASES_ASSIGNED_TO,REF_CASES_TEAM,PRODUCT_NAME,"
			+ "REF_CASES_CHANNEL,RESOLUTION,PRIMARY_EMAIL,REF_CASES_IMPACT_AREA,REF_CASES_IMPACT_TYPE,"
			+ "REF_CASES_RESOLUTION_TYPE,DEFERRD_DATE FROM TAB_SUPPORT_CASES WHERE CASES_ID=?";

	/**
	 * <p>
	 * <code>GET_SUPPORT_CASES_VIEW</code> token is representing the constants
	 * for SQL query, which is View
	 * 
	 * <pre>
	 * 
	 * </pre>
	 * 
	 * WHERE <code>CASES_ID</code>.
	 */

	public static final String GET_SUPPORT_CASES_VIEW = "SELECT CASES_ID,CASES_TITLE,CASES_STATUS,REF_CASES_PRIORITY,"
			+ "CONTACT_NAME,SLA_NAME,ORGANIZATION_NAME,REF_CASES_ASSIGNED_TO,REF_CASES_TEAM,PRODUCT_NAME,"
			+ "REF_CASES_CHANNEL,RESOLUTION,PRIMARY_EMAIL,REF_CASES_IMPACT_AREA,REF_CASES_IMPACT_TYPE,"
			+ "REF_CASES_RESOLUTION_TYPE FROM TAB_SUPPORT_CASES WHERE CASES_ID=?";
	/**
	 * <p>
	 * <code>DELETE_FAQ_DETAIL</code> token is representing the constants for
	 * SQL query, which is deleting records from <code>TAB_SUPPORT_FAQ</code>
	 * based on the supportId .
	 */
	public static final String DELETE_FAQ_DETAIL = "DELETE FROM TAB_SUPPORT_FAQ WHERE FAQ_ID=?";

	/**
	 * <p>
	 * <code>DELETE_CASES_DETAIL</code> token is representing the constants for
	 * SQL query, which is deleting records from <code>TAB_SUPPORT_CASES</code>
	 * based on the casesId.
	 */
	public static final String DELETE_CASES_DETAIL = "DELETE FROM TAB_SUPPORT_CASES WHERE CASES_ID=? ";

	/**
	 * <p>
	 * <code>GET_FAQ_PRODUCT_NAME_LIST</code>this token is representing the
	 * constants for SQL query, which is fetching
	 * </p>
	 * 
	 * <pre>
	 * PRODUCT_ID ,PRODUCT_NAME
	 * </pre>
	 * 
	 * from <code>TAB_PRODUCT_DETAILS</code>.
	 */
	public static final String GET_FAQ_PRODUCT_NAME_LIST = "SELECT PRODUCT_ID,PRODUCT_NAME FROM TAB_PRODUCT_DETAILS";

	/**
	 * <p>
	 * <code>GET_FAQ_OWNER_NAME_LIST</code>this token is representing the
	 * constants for SQL query, which is fetching
	 * </p>
	 * 
	 * <pre>
	 * CUSTOMER_ID ,FULL_NAME
	 * </pre>
	 * 
	 * from <code>TAB_CUSTOMER_USER</code>.
	 */
	public static final String GET_FAQ_OWNER_NAME_LIST = "SELECT CUSTOMER_ID,FULL_NAME FROM TAB_CUSTOMER_USER";

	/**
	 * <p>
	 * <code>GET_CASES_CONTACT_NAME_LIST</code>this token is representing the
	 * constants for SQL query, which is fetching
	 * </p>
	 * 
	 * <pre>
	 * CONTACT_ID ,CONTACT_NAME
	 * </pre>
	 * 
	 * from <code>TAB_CONTACT</code>.
	 */
	public static final String GET_CASES_CONTACT_NAME_LIST = "SELECT CONTACT_ID,CONTACT_PERSON FROM TAB_CONTACT";

	/**
	 * <p>
	 * <code>GET_CASES_SLA_LIST</code>this token is representing the constants
	 * for SQL query, which is fetching
	 * </p>
	 * 
	 * <pre>
	 * ACCOUNT_ID ,SLA_NAME
	 * </pre>
	 * 
	 * from <code>TAB_SALUTATAION</code>.
	 */
	public static final String GET_CASES_SLA_LIST = "SELECT ACCOUNT_ID,SLA_NAME FROM TAB_ACCOUNT";

	/**
	 * <p>
	 * <code>GET_CASES_ORGNIZATION_LIST</code>this token is representing the
	 * constants for SQL query, which is fetching
	 * </p>
	 * 
	 * <pre>
	 * ORGNIZATION_ID ,ORGNIZATION_NAME
	 * </pre>
	 * 
	 * from <code>TAB_SALUTATAION</code>.
	 */
	public static final String GET_CASES_ORGNIZATION_LIST = "SELECT COMPANY_ID,COMPANY_NAME FROM TAB_COMPANY_DETAILS";

	/**
	 * <p>
	 * <code>GET_CASES_PRODUCT_NAME_LIST</code>this token is representing the
	 * constants for SQL query, which is fetching
	 * </p>
	 * 
	 * <pre>
	 * ORGNIZATION_ID ,ORGNIZATION_NAME
	 * </pre>
	 * 
	 * from <code>TAB_PRODUCT</code>.
	 */
	public static final String GET_CASES_PRODUCT_NAME_LIST = "SELECT PRODUCT_ID,PRODUCT_NAME FROM TAB_PRODUCT_DETAILS";

	/**
	 * <p>
	 * <code>GET_TICKET_CATEGORY_LIST</code>this token is representing the
	 * constants for SQL query, which is fetching
	 * </p>
	 * 
	 * <pre>
	 * CATEGORY_ID ,CATEGORY_NAME
	 * </pre>
	 * 
	 * from <code>TAB_TICKET_CATEGORY</code>.
	 */
	public static final String GET_TICKET_CATEGORY_LIST = "SELECT CATEGORY_ID,CATEGORY_NAME FROM TAB_TICKET_CATEGORY";

	/**
	 * <p>
	 * <code>GET_TICKET_OWNER_LIST</code>this token is representing the
	 * constants for SQL query, which is fetching
	 * </p>
	 * 
	 * <pre>
	 * CUSTOMER_ID ,FULL_NAME
	 * </pre>
	 * 
	 * from <code>TAB_CUSTOMER_USER</code>.
	 */
	public static final String GET_TICKET_OWNER_LIST = "SELECT CUSTOMER_ID,FULL_NAME FROM TAB_CUSTOMER_USER";
	/**
	 * <p>
	 * <code>GET_TICKET_CHANNEL_LIST</code>this token is representing the
	 * constants for SQL query, which is fetching
	 * </p>
	 * 
	 * <pre>
	 * CHANNEL_ID ,CHANNEL_NAME
	 * </pre>
	 * 
	 * from <code>TAB_TICKET_CHANNEL</code>.
	 */
	public static final String GET_TICKET_CHANNEL_LIST = "SELECT CHANNEL_ID,CHANNEL_NAME FROM TAB_TICKET_CHANNEL";

	/**
	 * <p>
	 * <code>GET_TICKET_PRODUCT_NAME_LIST</code>this token is representing the
	 * constants for SQL query, which is fetching
	 * </p>
	 * 
	 * <pre>
	 * PRODUCT_ID ,PRODUCT_NAME
	 * </pre>
	 * 
	 * from <code>TAB_PRODUCT</code>.
	 */
	public static final String GET_TICKET_PRODUCT_NAME_LIST = "SELECT PRODUCT_ID,PRODUCT_NAME FROM TAB_PRODUCT_DETAILS";

	/**
	 * <p>
	 * <code>GET_TICKET_CONTACT_NAME_LIST</code>this token is representing the
	 * constants for SQL query, which is fetching
	 * </p>
	 * 
	 * <pre>
	 * CONTACT_ID ,CONTACT_PERSON
	 * </pre>
	 * 
	 * from <code>TAB_CONTACT</code>.
	 */
	public static final String GET_TICKET_CONTACT_NAME_LIST = "SELECT CONTACT_ID,CONTACT_PERSON FROM TAB_CONTACT";
	/**
	 * <p>
	 * <code>INSERT_SUPPORT_TICKET</code> token is representing the constants
	 * for SQL query, which is insert ticket id from
	 * <code>TAB_SUPPORT_TICKET</code>
	 */
	public static final String INSERT_SUPPORT_TICKET = "INSERT INTO TAB_SUPPORT_TICKET (REF_CATEGORY,REF_TICKET_OWNER,"
			+ "PHONE_NO,PHONE_ISD,PHONE_STD,EMAIL,SUBJECT,DUE_DATE_TIME,PRIORITY,REF_CHANNEL,DESCRIPTION,STATUS,"
			+ "REF_PRODUCT_NAME,REF_CONTACT_NAME)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	/**
	 * <p>
	 * <code>GET_TICKET_GIRD_LIST</code> token is representing the constants for
	 * SQL query, which is fetching ticket id from
	 * <code>TAB_SUPPORT_TICKET</code> based on the ticket id
	 */
	public static final String GET_TICKET_GIRD_LIST = "SELECT TICKET_ID,REF_CATEGORY,REF_TICKET_OWNER,PHONE_NO,"
			+ "PHONE_ISD,PHONE_STD,EMAIL,SUBJECT,DUE_DATE_TIME,PRIORITY,REF_CHANNEL,DESCRIPTION,STATUS,"
			+ "REF_PRODUCT_NAME,REF_CONTACT_NAME FROM TAB_SUPPORT_TICKET";

	/**
	 * <p>
	 * <code>GET_SUPPORT_TICKET_EDIT</code> token is representing the constants
	 * for SQL query, which is edit ticket id from
	 * <code>TAB_SUPPORT_TICKET</code> based on the ticket id
	 */

	public static final String GET_SUPPORT_TICKET_EDIT = "SELECT TICKET_ID,REF_CATEGORY,REF_TICKET_OWNER,PHONE_NO,"
			+ "PHONE_ISD,PHONE_STD,EMAIL,SUBJECT,DUE_DATE_TIME,PRIORITY,REF_CHANNEL,DESCRIPTION,STATUS,"
			+ "REF_CONTACT_NAME,REF_PRODUCT_NAME FROM TAB_SUPPORT_TICKET WHERE TICKET_ID=?";

	/**
	 * <p>
	 * <code>UPDATE_TICKET_INFORMATION</code> token is representing the
	 * constants for SQL query, which is update ticket id from
	 * <code>TAB_SUPPORT_TICKET</code> based on the ticket id
	 */

	public static final String UPDATE_TICKET_INFORMATION = "UPDATE TAB_SUPPORT_TICKET SET REF_CATEGORY=?,REF_TICKET_OWNER=?,"
			+ "PHONE_NO=?,PHONE_ISD=?,PHONE_STD=?,EMAIL=?,SUBJECT=?,DUE_DATE_TIME=?,PRIORITY=?,REF_CHANNEL=?,DESCRIPTION=?,"
			+ "STATUS=?,REF_PRODUCT_NAME=?,REF_CONTACT_NAME=? WHERE TICKET_ID=?";

	/**
	 * <p>
	 * <code>GET_SUPPORT_TICKET_VIEW</code> token is representing the constants
	 * for SQL query, which is view ticket id from
	 * <code>TAB_SUPPORT_TICKET</code> based on the ticket id
	 */

	public static final String GET_SUPPORT_TICKET_VIEW = "SELECT TICKET_ID,REF_CATEGORY,REF_TICKET_OWNER,PHONE_NO,"
			+ "PHONE_ISD,PHONE_STD,EMAIL,SUBJECT,DUE_DATE_TIME,PRIORITY,REF_CHANNEL,DESCRIPTION,STATUS,"
			+ "REF_PRODUCT_NAME,REF_CONTACT_NAME FROM TAB_SUPPORT_TICKET WHERE TICKET_ID=?";

	/**
	 * <p>
	 * <code>DELETE_TICKET_DETAIL</code> token is representing the constants for
	 * SQL query, which is delete ticket id from <code>TAB_SUPPORT_TICKET</code>
	 * based on the ticket id
	 */
	public static final String DELETE_TICKET_DETAIL = "DELETE FROM TAB_SUPPORT_TICKET WHERE TICKET_ID=?";
	/**
	 * <p>
	 * <code>GET_TICKET_CATEGORY_NAME</code>this token is representing the
	 * constants for SQL query, which is fetching
	 * </p>
	 * 
	 * <pre>
	 * CATEGORY_NAME  CATEGORY_ID
	 * </pre>
	 * 
	 * from <code>TAB_TICKET_CATEGORY</code>.
	 */

	public static final String GET_TICKET_CATEGORY_NAME = "SELECT CATEGORY_NAME FROM TAB_TICKET_CATEGORY WHERE "
			+ "CATEGORY_ID=?";

	/**
	 * <p>
	 * <code>GET_TICKET_CHANNEL</code>this token is representing the constants
	 * for SQL query, which is fetching
	 * </p>
	 * 
	 * <pre>
	 * CHANNEL_NAME  CHANNEL_ID
	 * </pre>
	 * 
	 * from <code>TAB_TICKET_CHANNEL</code>.
	 */

	public static final String GET_TICKET_CHANNEL = "SELECT CHANNEL_NAME FROM TAB_TICKET_CHANNEL WHERE "
			+ "CHANNEL_ID=?";

	/**
	 * <p>
	 * <code>GET_TICKET_OWNER_NAME</code>this token is representing the
	 * constants for SQL query, which is fetching
	 * </p>
	 * 
	 * <pre>
	 * FULL_NAME  CUSTOMER_ID
	 * </pre>
	 * 
	 * from <code>TAB_CUSTOMER_USER</code>.
	 */

	public static final String GET_TICKET_OWNER_NAME = "SELECT FULL_NAME FROM TAB_CUSTOMER_USER WHERE "
			+ "CUSTOMER_ID=?";

	/**
	 * <p>
	 * <code>GET_TICKET_PRIORITY</code>this token is representing the constants
	 * for SQL query, which is fetching
	 * </p>
	 * 
	 * <pre>
	 * PRIORITY  TICKET_ID
	 * </pre>
	 * 
	 * from <code>TAB_SUPPORT_TICKET</code>.
	 */

	public static final String GET_TICKET_PRIORITY = "SELECT PRIORITY FROM TAB_SUPPORT_TICKET WHERE "
			+ "TICKET_ID=?";
	/**
	 * <p>
	 * <code>GET_TICKET_STATUS</code>this token is representing the constants
	 * for SQL query, which is fetching
	 * </p>
	 * 
	 * <pre>
	 * STATUS  TICKET_ID
	 * </pre>
	 * 
	 * from <code>TAB_SUPPORT_TICKET</code>.
	 */

	public static final String GET_TICKET_STATUS = "SELECT STATUS FROM TAB_SUPPORT_TICKET WHERE "
			+ "TICKET_ID=?";

	/**
	 * <p>
	 * <code>GET_FAQ_OWNER_NAME</code>this token is representing the constants
	 * for SQL query, which is fetching
	 * </p>
	 * 
	 * <pre>
	 * FULL_NAME  CUSTOMER_ID
	 * </pre>
	 * 
	 * from <code>TAB_CUSTOMER_USER</code>.
	 */

	public static final String GET_FAQ_OWNER_NAME = "SELECT FULL_NAME FROM TAB_CUSTOMER_USER WHERE "
			+ "CUSTOMER_ID=?";
	/**
	 * <p>
	 * <code>GET_FAQ_CATEGORY_NAME</code>this token is representing the
	 * constants for SQL query, which is fetching
	 * </p>
	 * 
	 * <pre>
	 * CATEGORY_NAME  CATEGORY_ID
	 * </pre>
	 * 
	 * from <code>TAB_FAQ_CATEGORY</code>.
	 */

	public static final String GET_FAQ_CATEGORY_NAME = "SELECT CATEGORY_NAME FROM TAB_FAQ_CATEGORY WHERE "
			+ "CATEGORY_ID=?";
	/**
	 * <p>
	 * <code>GET_FAQ_PRODUCT_NAME</code>this token is representing the constants
	 * for SQL query, which is fetching
	 * </p>
	 * 
	 * <pre>
	 * PRODUCT_NAME  PRODUCT_ID
	 * </pre>
	 * 
	 * from <code>TAB_PRODUCT</code>.
	 */

	public static final String GET_FAQ_PRODUCT_NAME = "SELECT PRODUCT_NAME FROM TAB_PRODUCT_DETAILS WHERE PRODUCT_ID=?";
	/**
	 * <p>
	 * <code>GET_FAQ_STATUS</code>this token is representing the constants for
	 * SQL query, which is fetching
	 * </p>
	 * 
	 * <pre>
	 * STATUS  FAQ_ID
	 * </pre>
	 * 
	 * from <code>TAB_SUPPORT_FAQ</code>.
	 */

	public static final String GET_FAQ_STATUS = "SELECT STATUS FROM TAB_SUPPORT_FAQ WHERE "
			+ "FAQ_ID=?";

	/**
	 * /**
	 * <p>
	 * <code>GET_CASES_IMPACT_AREA</code>this token is representing the
	 * constants for SQL query, which is fetching
	 * </p>
	 * 
	 * <pre>
	 * IMPACT_AREA_NAME  IMPACT_AREA_ID
	 * </pre>
	 * 
	 * from <code>TAB_CASES_IMPACT_AREA</code>.
	 */

	public static final String GET_CASES_IMPACT_AREA = "SELECT IMPACT_AREA_NAME FROM TAB_CASES_IMPACT_AREA WHERE"
			+ " IMPACT_AREA_ID";

	/**
	 * <p>
	 * <code>SHOW_VIEW_FAQ</code> token is representing the constants for SQL
	 * query, which is fetching records from <code>TAB_SUPPORT_FAQ</code> .
	 */

	public static final String SHOW_VIEW_FAQ = "SELECT FAQ_ID,QUESTION,ANSWER,REF_PRODUCT_NAME,REF_FAQ_CATEGORY,"
			+ "FAQ_STATUS,REF_FAQ_OWNER FROM TAB_SUPPORT_FAQ WHERE FAQ_ID=?";

	/**
	 * <p>
	 * <code>GET_LAST_RECORD_FAQ_ID</code> token is representing the constants
	 * for SQL query, which is getting last record <code>FAQ_ID</code> from
	 * <code>TAB_SUPPORT_FAQ</code> .
	 */

	public static final String GET_LAST_RECORD_FAQ_ID = "SELECT  FAQ_ID FROM TAB_SUPPORT_FAQ GROUP BY FAQ_ID DESC LIMIT 1";

	/**
	 * <p>
	 * <code>GET_LAST_RECORD_CASES_ID</code> token is representing the constants
	 * for SQL query, which is getting last record <code>CASES_ID</code> from
	 * <code>TAB_SUPPORT_CASES</code> .
	 */
	public static final String GET_LAST_RECORD_CASES_ID = "SELECT  CASES_ID FROM TAB_SUPPORT_CASES GROUP BY CASES_ID DESC LIMIT 1";

	/**
	 * <p>
	 * <code>SHOW_VIEW_CASES</code> token is representing the constants for SQL
	 * query, which is getting last record <code>CASES_ID</code> from
	 * <code>TAB_SUPPORT_CASES</code> .
	 */
	public static final String SHOW_VIEW_CASES = "SELECT CASES_ID,CASES_TITLE,CASES_STATUS,REF_CASES_PRIORITY,"
			+ "CONTACT_NAME,SLA_NAME,ORGANIZATION_NAME,REF_CASES_ASSIGNED_TO,REF_CASES_TEAM,PRODUCT_NAME,REF_CASES_CHANNEL,RESOLUTION,"
			+ "PRIMARY_EMAIL,REF_CASES_IMPACT_AREA,REF_CASES_IMPACT_TYPE,REF_CASES_RESOLUTION_TYPE,"
			+ "DEFERRD_DATE FROM TAB_SUPPORT_CASES WHERE CASES_ID=?";

	/**
	 * <p>
	 * <code>GET_LAST_RECORD_TICKET_ID</code> token is representing the
	 * constants for SQL query, which is getting last record
	 * <code>TICKET_ID</code> from <code>TAB_SUPPORT_TICKET</code> .
	 */
	public static final String GET_LAST_RECORD_TICKET_ID = "SELECT  TICKET_ID FROM TAB_SUPPORT_TICKET GROUP BY TICKET_ID DESC LIMIT 1";

	/**
	 * <p>
	 * <code>SHOW_VIEW_TICKET</code> token is representing the constants for SQL
	 * query, which is getting last record <code>TICKET_ID</code> from
	 * <code>TAB_SUPPORT_TICKET</code> .
	 */
	public static final String SHOW_VIEW_TICKET = "SELECT TICKET_ID,REF_CATEGORY,REF_TICKET_OWNER,PHONE_NO,"
			+ "PHONE_ISD,PHONE_STD,EMAIL,SUBJECT,DUE_DATE_TIME,PRIORITY,REF_CHANNEL,DESCRIPTION,STATUS,"
			+ "REF_PRODUCT_NAME,REF_CONTACT_NAME FROM TAB_SUPPORT_TICKET WHERE TICKET_ID=?";
	/**
	 * <p>
	 * <code>INSERT_SERVICE_CONTACT</code> token is representing the constants
	 * for SQL query, which is fetching service Contract id from
	 * <code>TAB_SUPPORT_SERVICE_CONTRACT</code> based on the service Contract
	 * id
	 */
	public static final String INSERT_SERVICE_CONTACT = "INSERT INTO TAB_SUPPORT_SERVICE_CONTRACT "
			+ "(REF_ASSIGNED_TO,REF_CONTACT_NAME,PRIORITY,REF_RELATED_TO,REF_SERVICE_TYPE,STATUS,SUBJECT,"
			+ "TOTAL_UNITS,REF_TRACKING_UNIT,USED_UNITS,CREATED_DATE,DUE_DATE,START_DATE,CREATED_BY) VALUES"
			+ "(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	/**
	 * <p>
	 * <code>GET_SERVICE_CONTACT_GIRD_LIST</code>this token is representing the
	 * constants for SQL query, which is fetching
	 * </p>
	 * from <code>TAB_SUPPORT_SERVICE_CONTRACT</code>.
	 */

	public static final String GET_SERVICE_CONTACT_GIRD_LIST = "SELECT SERVICE_CONTRACT_ID,SUBJECT,REF_ASSIGNED_TO,"
			+ "STATUS,PRIORITY,DUE_DATE,START_DATE FROM TAB_SUPPORT_SERVICE_CONTRACT ";
	/**
	 * <p>
	 * <code>GET_SERVICE_CONTACT_VIEW</code>this token is representing the
	 * constants for SQL query, which is fetching
	 * </p>
	 * from <code>TAB_SUPPORT_SERVICE_CONTRACT</code>. WHERE based Service
	 * Contract Id
	 */

	public static final String GET_SERVICE_CONTACT_VIEW = "SELECT SERVICE_CONTRACT_ID,SUBJECT,TOTAL_UNITS"
			+ ",REF_TRACKING_UNIT,USED_UNITS,REF_ASSIGNED_TO,REF_SERVICE_TYPE,REF_CONTACT_NAME,STATUS,PRIORITY,"
			+ "DUE_DATE,START_DATE FROM TAB_SUPPORT_SERVICE_CONTRACT WHERE SERVICE_CONTRACT_ID=?";

	/**
	 * <p>
	 * <code>GET_SERVICE_CONTACT_EDIT</code>this token is representing the
	 * constants for SQL query, which is fetching
	 * </p>
	 * from <code>TAB_SUPPORT_SERVICE_CONTRACT</code>. WHERE based Service
	 * Contract Id
	 */

	public static final String GET_SERVICE_CONTACT_EDIT = "SELECT SERVICE_CONTRACT_ID,SUBJECT,TOTAL_UNITS,"
			+ "REF_TRACKING_UNIT,USED_UNITS,REF_ASSIGNED_TO,REF_SERVICE_TYPE,REF_CONTACT_NAME,REF_RELATED_TO,"
			+ "STATUS,PRIORITY,DUE_DATE,START_DATE FROM TAB_SUPPORT_SERVICE_CONTRACT WHERE SERVICE_CONTRACT_ID=?";

	/**
	 * <p>
	 * <code>UPDATE_SERVICE_CONTACT_INFORMATION</code>this token is representing
	 * the constants for SQL query, which is fetching
	 * </p>
	 * from <code>TAB_SUPPORT_SERVICE_CONTRACT</code>. WHERE based Service
	 * Contract Id
	 */

	public static final String UPDATE_SERVICE_CONTACT_INFORMATION = "UPDATE TAB_SUPPORT_SERVICE_CONTRACT SET REF_ASSIGNED_TO=?,REF_CONTACT_NAME=?,"
			+ "PRIORITY=?,REF_RELATED_TO=?,REF_SERVICE_TYPE=?,STATUS=?,SUBJECT=?,TOTAL_UNITS=?,REF_TRACKING_UNIT=?,USED_UNITS=?,"
			+ "DUE_DATE=?,START_DATE=? WHERE SERVICE_CONTRACT_ID=?";
	/**
	 * <p>
	 * <code>DELETE_SERVICE_CONTACT</code>this token is representing the
	 * constants for SQL query, which is fetching
	 * </p>
	 * from <code>TAB_SUPPORT_SERVICE_CONTRACT</code>. WHERE based Service
	 * Contract Id
	 */

	public static final String DELETE_SERVICE_CONTACT = " DELETE FROM TAB_SUPPORT_SERVICE_CONTRACT "
			+ "WHERE SERVICE_CONTRACT_ID=?";
	/**
	 * <p>
	 * <code>GET_LAST_RECORD_SERVICE_CONTRACT_ID</code> token is representing
	 * the constants for SQL query, which is getting last record
	 * <code>SERVICE_CONTRACT_ID</code> from
	 * <code>TAB_SUPPORT_SERVICE_CONTRACT</code> .
	 */

	public static String GET_LAST_RECORD_SERVICE_CONTRACT_ID = " SELECT SERVICE_CONTRACT_ID"
			+ " FROM TAB_SUPPORT_SERVICE_CONTRACT GROUP BY SERVICE_CONTRACT_ID DESC LIMIT 1";;
	/**
	 * <p>
	 * <code>SHOW_VIEW_SERVICE_CONTACT</code> token is representing the
	 * constants for SQL query, which is getting last record
	 * <code>SERVICE_CONTRACT_ID</code> from
	 * <code>TAB_SUPPORT_SERVICE_CONTRACT</code> .
	 */
	public static final String SHOW_VIEW_SERVICE_CONTACT = "SELECT SERVICE_CONTRACT_ID,SUBJECT,REF_ASSIGNED_TO,"
			+ "REF_CONTACT_NAME,REF_RELATED_TO,REF_TRACKING_UNIT,USED_UNITS,TOTAL_UNITS,REF_SERVICE_TYPE,"
			+ "STATUS,PRIORITY,DUE_DATE,START_DATE FROM TAB_SUPPORT_SERVICE_CONTRACT WHERE SERVICE_CONTRACT_ID=?";

	/**
	 * <p>
	 * <code>GET_SERVICE_TYPE_LIST</code>this token is representing the
	 * constants for SQL query, which is fetching
	 * </p>
	 * 
	 * <pre>
	 * 
	 * </pre>
	 * 
	 * from <code>TAB_SUPPORT_SERVICE_CONTRACT</code>.
	 */

	public static final String GET_SERVICE_TYPE_LIST = "SELECT SERVICE_CONTRACT_TYPE_ID,SERVICE_CONTRACT_TYPE_NAME "
			+ "FROM TAB_SERVICE_CONTRACT_TYPE";
	/**
	 * <p>
	 * <code>GET_SERVICE_TRACKING_UNITS_LIST</code>this token is representing
	 * the constants for SQL query, which is fetching
	 * </p>
	 * 
	 * <pre>
	 * 
	 * </pre>
	 * 
	 * from <code>TAB_SUPPORT_SERVICE_CONTRACT</code>.
	 */

	public static final String GET_SERVICE_TRACKING_UNITS_LIST = "SELECT TRACKING_UNIT_ID,"
			+ "TRACKING_UNIT_NAME FROM TAB_SERVICE_TRACKING_UNIT";
	/**
	 * <p>
	 * <code>GET_SERVICE_TYPE</code>this token is representing the constants for
	 * SQL query, which is fetching
	 * </p>
	 * 
	 * <pre>
	 * SERVICE_CONTRACT_TYPE_ID SERVICE_CONTRACT_TYPE_NAME
	 * </pre>
	 * 
	 * from <code>TAB_SERVICE_CONTRACT_TYPE</code>.
	 */

	public static final String GET_SERVICE_TYPE = "SELECT SERVICE_CONTRACT_TYPE_NAME FROM TAB_SERVICE_CONTRACT_TYPE"
			+ "WHERE SERVICE_CONTRACT_TYPE_ID=?";
	/**
	 * <p>
	 * <code>GET_TRACKING_UNIT</code>this token is representing the constants
	 * for SQL query, which is fetching
	 * </p>
	 * 
	 * <pre>
	 * TRACKING_UNIT_ID TRACKING_UNIT_NAME
	 * </pre>
	 * 
	 * from <code>TAB_SERVICE_TRACKING_UNIT</code>.
	 */

	public static final String GET_TRACKING_UNIT = "SELECT TRACKING_UNIT_NAME FROM TAB_SERVICE_TRACKING_UNIT"
			+ "WHERE TRACKING_UNIT_ID=?";

	/**
	 * <p>
	 * <code>SHOW_ASSIGNMENT_DETAILS</code> token is representing the constants
	 * for SQL query, which is fetching records from <code>TAB_ASSIGNMENT</code>
	 * .
	 */
	public static final String SHOW_ASSIGNMENT_DETAILS = "SELECT ASSIGNMENT_ID,ASSIGNMENT_OWNER,ASSIGNMENT_NAME,ACCOUNT,"
			+ "EXPECTED_AMMOUNT,CONTACT_PERSON,EXPECTED_CLOSING_DATE,LEAD_SOURCE,ASSIGN_TO,LEAD,PROBABILITY,WEIGHTED_REVEINUE,CAMPING,"
			+ "PRIMARY_EMAIL_ID,PHONE_ISD,PHONE_STD,PHONE_NUMBER,DESCRIPTION,CREATED_BY,CREATION_DATE FROM TAB_ASSIGNMENT WHERE ASSIGNMENT_ID=?";

	/**
	 * <p>
	 * <code>ADD_DETAILS</code> token is representing the constants for SQL
	 * query, which is used to insert records in <code>TAB_ASSIGNMENT</code> .
	 */

	public static String ADD_DETAILS = "INSERT INTO TAB_ASSIGNMENT (ASSIGNMENT_NAME,ASSIGNMENT_OWNER,EXPECTED_AMMOUNT,ACCOUNT,"
			+ "CONTACT_PERSON,EXPECTED_CLOSING_DATE,LEAD_SOURCE,ASSIGN_TO,LEAD,PROBABILITY,CAMPING,WEIGHTED_REVEINUE,"
			+ "PRIMARY_EMAIL_ID,PHONE_ISD,PHONE_STD,PHONE_NUMBER,DESCRIPTION,ASSIGNMENT_STATUS,EMAIL_FLAG,CREATED_BY,CREATION_DATE)"
			+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

	/**
	 * <p>
	 * <code>GET_ASSIGNMENT_DETAILS</code> token is representing the constants
	 * for SQL query, which is used to view records from
	 * <code>TAB_ASSIGNMENT</code> .
	 */

	public static final String GET_ASSIGNMENT_DETAILS = "SELECT ASSIGNMENT_ID,ASSIGN_TO,EXPECTED_CLOSING_DATE,ASSIGNMENT_STATUS "
			+ "FROM TAB_ASSIGNMENT";

	/*	*//**
	 * <p>
	 * <code>GET_ASSIGNMENT_EDIT</code> token is representing the constants for
	 * SQL query, which is Editing The assignment form
	 * 
	 * <pre>
	 * 
	 * </pre>
	 * 
	 * based on <code>ASSIGNMENT_ID</code>.
	 */

	public static final String GET_ASSIGNMENT_EDIT = "SELECT ASSIGNMENT_ID,ASSIGNMENT_OWNER,ASSIGNMENT_NAME,EXPECTED_AMMOUNT,"
			+ "CONTACT_PERSON,EXPECTED_CLOSING_DATE,LEAD_SOURCE,ASSIGN_TO,LEAD,PROBABILITY,"
			+ "WEIGHTED_REVEINUE,CAMPING,PRIMARY_EMAIL_ID,PHONE_ISD,PHONE_STD,"
			+ "PHONE_NUMBER,DESCRIPTION,CREATED_BY,CREATION_DATE FROM TAB_ASSIGNMENT WHERE ASSIGNMENT_ID=?";

	/**
	 * <p>
	 * <code>UPDATE_ASSIGNMENT_DETAILS</code> token is representing the
	 * constants for SQL query, which is used to update records in
	 * <code>TAB_ASSIGNMENT</code> .
	 */

	public static final String UPDATE_ASSIGNMENT_DETAILS = "UPDATE TAB_ASSIGNMENT SET ASSIGNMENT_NAME=?,"
			+ "ASSIGNMENT_OWNER=?,EXPECTED_AMMOUNT=?,ACCOUNT=?,CONTACT_PERSON=?,LEAD_SOURCE=?,ASSIGN_TO=?,LEAD=?,PROBABILITY=?,"
			+ "CAMPING=?,WEIGHTED_REVEINUE=?,PRIMARY_EMAIL_ID=?,PHONE_ISD=?,PHONE_STD=?,PHONE_NUMBER=?,DESCRIPTION=?,"
			+ "ASSIGNMENT_STATUS=?,EMAIL_FLAG=?,CREATED_BY=?,EXPECTED_CLOSING_DATE=?,CREATION_DATE=? WHERE ASSIGNMENT_ID=? ";

	public static final String GET_ASSIGN_TO_NAME = "SELECT FULL_NAME FROM TAB_CUSTOMER_USER WHERE CUSTOMER_ID=?";

	/**
	 * <p>
	 * <code>GET_VENDOR_NAME</code> token is representing the constants for SQL
	 * query, which is showing Data
	 * 
	 * <pre>
	 * 
	 * </pre>
	 * Author Roshan Patel from <code>TAB_VENDORS</code>.
	 */
	public static final String GET_VENDOR_NAME = "SELECT VENDOR_NAME FROM TAB_VENDORS WHERE VENDOR_ID=?";

	/*	*//**
	 * <p>
	 * <code>GET_VENDOR_CATEGORY_NAME</code> token is representing the constants
	 * for SQL query, which is Editing The assignment form
	 * 
	 * <pre>
	 * VENDOR_CATEGORY_NAME
	 * </pre>
	 * 
	 * based on <code>VENDOR_CATEGORY_ID</code>.
	 */
	public static final String GET_VENDOR_CATEGORY_NAME = "SELECT VENDOR_CATEGORY_NAME FROM TAB_VENDOR_CATEGORY WHERE VENDOR_CATEGORY_ID=?";

	/**
	 * <p>
	 * <code>GET_PRODUCT_CATEGORY_NAME</code> token is representing the
	 * constants for SQL query, which is showing Data
	 * 
	 * <pre>
	 * 
	 * </pre>
	 * Author Roshan Patel from <code>TAB_PRODUCT_CATEGORY</code>.
	 */
	public static final String GET_PRODUCT_CATEGORY_NAME = "SELECT PRODUCT_CATEGORY_NAME FROM TAB_PRODUCT_CATEGORY WHERE PRODUCT_CATEGORY_ID=?";

	/**
	 * <p>
	 * <code>UPDATE_EXPENSES_DETAILS</code> token is representing the constants
	 * for SQL query, which is update Data
	 * 
	 * <pre>
	 * 
	 * </pre>
	 * into <code>TAB_EXPENSES</code>.
	 */
	public static final String UPDATE_EXPENSES_DETAILS = "UPDATE TAB_EXPENSES SET NAME=?,PLACE_OF_VISIT=?,PURPOSE_OF_VISIT=?,DEPARTURE_DATE=?,ARRIVAL_DATE=?,"
			+ "TOTAL_AMOUNT_A=?,TOTAL_AMOUNT_B=?,C_DAILY_ALLOWANCE=?,D_CONVEYANCE_EXPENCES=?,E_CONVEYANCE_EXPENCES=?,F_LAUNDRY_EXPENCES=?,G_OTHER_EXPENSES=?,"
			+ "H_TOTAL_A_TO_G=?,1_ADVANCE_RECEIVED=?,2_TICKET_BOOKED_BY_COMPANY=?,3_HOTEL_BOOKED_BY_COMPANY=?,4_CONVEYANCE_EXPENCES=?,5_ADVANCE_RECEIVED_FROM_OTHER_BRANCH=?,"
			+ "I_TOTAL_ADVANCE=?,GRANT_TOTAL_BALANCE=?,APPROVED_BY=?,STATUS=?,EXPENSES_COMMENT=?,EXPENSES_REF_NO=?,UPDATED_BY=?,UPDATION_DATE=? WHERE CLAIM_ID=?";

	/**
	 * <p>
	 * <code>GET_VENDORS_CATEGORY_NAME_LIST</code>this token is representing the
	 * constants for SQL query, which is fetching
	 * </p>
	 * 
	 * <pre>
	 * VENDORS_CATEGORY_ID,VENDORS_CATEGORY_NAME
	 * </pre>
	 * 
	 * from <code>TAB_VENDORS_CATEGORY</code>.
	 */
	public static final String GET_VENDORS_CATEGORY_NAME_LIST = "SELECT VENDOR_CATEGORY_ID,VENDOR_CATEGORY_NAME FROM TAB_VENDOR_CATEGORY";
	/**
	 * <p>
	 * <code>GET_VENDORS_GLACCOUNT_LIST</code> token is representing the
	 * constants for SQL query, which is showing Data
	 * 
	 * <pre>
	 * 
	 * </pre>
	 * Author Vinod Patel from <code>TAB_GL_ACCOUNT</code>.
	 */
	public static final String GET_VENDORS_GLACCOUNT_LIST = "SELECT GL_ACCOUNT_ID,GL_ACCOUNT_NAME FROM TAB_GL_ACCOUNT";

	/**
	 * <p>
	 * <code>ADD_VENDORS_DETAIL</code> token is representing the constants for
	 * SQL query, which is fetching records from <code>TAB_VENDORS</code> .
	 */
	public static final String ADD_VENDORS_DETAIL = "INSERT INTO TAB_VENDORS(VENDOR_NAME,SALUTATION,REF_GL_ACCOUNT,REF_VENDOR_CATEGORY,"
			+ "REF_ASSIGNED_TO,VENDOR_STATUS,VENDORS_FLAG,ADDRESS_LINE_1,ADDRESS_LINE_2,CITY,STATE,REF_COUNTRY,ZIPCODE,"
			+ "PHONE_ISD,PHONE_STD,PHONE_NO,MOBILE_ISD,MOBILE_NO,PRIMARY_EMAIL_ID,ALTERNATIVE_EMAIL_ID,FAX_ISD,FAX_STD,FAX_NO,WEBSITE,"
			+ "DESCRIPTION,CREATED_BY,CREATED_DATE)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

	/**
	 * <p>
	 * <code>GET_VENDORS_DETAILS_LIST</code> token is representing the constants
	 * for SQL query, which is fetching records from <code>TAB_VENDORS</code> .
	 */
	public static final String GET_VENDORS_DETAILS_LIST = "SELECT VENDOR_ID,SALUTATION,VENDOR_NAME,PHONE_ISD,"
			+ ""
			+ "PHONE_STD,PHONE_NO,PRIMARY_EMAIL_ID,REF_VENDOR_CATEGORY,REF_ASSIGNED_TO,"
			+ "VENDOR_STATUS FROM TAB_VENDORS";

	/**
	 * <p>
	 * <code>UPDATE_VENDORS_DETAILS</code> token is representing the constants
	 * for SQL query, which is Updating records from <code>TAB_VENDORS</code> .
	 */
	public static final String UPDATE_VENDORS_DETAILS = "UPDATE TAB_VENDORS SET VENDOR_NAME=?,SALUTATION=?,"
			+ "REF_GL_ACCOUNT=?,REF_VENDOR_CATEGORY=?,"
			+ "REF_ASSIGNED_TO=?,VENDOR_STATUS=?,VENDORS_FLAG=?,ADDRESS_LINE_1=?,ADDRESS_LINE_2=?,"
			+ "CITY=?,STATE=?,REF_COUNTRY=?,ZIPCODE=?,"
			+ "PHONE_ISD=?,PHONE_STD=?,PHONE_NO=?,MOBILE_ISD=?,MOBILE_NO=?,PRIMARY_EMAIL_ID=?,"
			+ "ALTERNATIVE_EMAIL_ID=?,FAX_ISD=?,FAX_STD=?,FAX_NO=?,WEBSITE=?,"
			+ "DESCRIPTION=?,UPDATED_BY=?,UPDATED_DATE=? WHERE VENDOR_ID=? ";;

	/**
	 * <p>
	 * <code>VIEW_VENDORS_DETAIL</code> token is representing the constants for
	 * SQL query, which is fetching records from <code>TAB_VENDORS</code> .
	 */

	public static final String SHOW_VIEW_VENDORS = "SELECT * FROM TAB_VENDORS WHERE VENDOR_ID=?";
	/**
	 * <p>
	 * <code>GET_LAST_RECORD</code> token is representing the constants for SQL
	 * query, which is getting last record <code>LEAD_ID</code> from
	 * <code>TAB_LEAD_DETAILS</code> .
	 */
	public static final String GET_LAST_VENDORS_ID = "SELECT  VENDOR_ID FROM TAB_VENDORS GROUP BY VENDOR_ID DESC LIMIT 1";

	/**
	 * <p>
	 * <code>GET_MANUFACTURER_NAME</code> token is representing the constants
	 * for SQL query, which is showing Data
	 * 
	 * <pre>
	 * 
	 * </pre>
	 * Author Roshan Patel from <code>TAB_CUSTOMER_USER</code>.
	 */
	public static final String GET_MANUFACTURER_NAME = "SELECT FULL_NAME FROM TAB_CUSTOMER_USER WHERE CUSTOMER_ID=?";
	/**
	 * <p>
	 * <code>GET_GL_ACCOUNT_NAME</code> token is representing the constants for
	 * SQL query, which is showing Data
	 * 
	 * <pre>
	 * 
	 * </pre>
	 * Author Roshan Patel from <code>TAB_GL_ACCOUNT</code>.
	 */
	public static final String GET_GL_ACCOUNT_NAME = "SELECT GL_ACCOUNT_NAME FROM TAB_GL_ACCOUNT WHERE GL_ACCOUNT_ID=?";
	/**
	 * <p>
	 * <code>GET_TAX_NAME</code> token is representing the constants for SQL
	 * query, which is showing Data
	 * 
	 * <pre>
	 * 
	 * </pre>
	 * Author Roshan Patel from <code>TAB_TAX</code>.
	 */
	public static final String GET_TAX_NAME = "SELECT TAX_DISPLAY_NAME FROM TAB_TAX WHERE TAX_ID=?";
	/**
	 * <p>
	 * <code>GET_HANDLER_NAME</code> token is representing the constants for SQL
	 * query, which is showing Data
	 * 
	 * <pre>
	 * 
	 * </pre>
	 * Author Roshan Patel from <code>TAB_CUSTOMER_USER</code>.
	 */
	public static final String GET_HANDLER_NAME = "SELECT FULL_NAME FROM TAB_CUSTOMER_USER WHERE CUSTOMER_ID=?";

	/*	*//**
	 * <p>
	 * <code>GET_ASSIGNMENT_OWNER_NAME</code> token is representing the
	 * constants for SQL query, which is Editing The assignment form
	 * 
	 * <pre>
	 * 
	 * </pre>
	 * 
	 * based on <code>CUSTOMER_ID</code>.
	 */
	public static final String GET_ASSIGNMENT_OWNER_NAME = "SELECT FULL_NAME FROM TAB_CUSTOMER_USER WHERE CUSTOMER_ID=?";

	/*	*//**
	 * <p>
	 * <code>GET_ASSIGNMENT_ACCOUNT_NAME</code> token is representing the
	 * constants for SQL query, which is Editing The assignment form
	 * 
	 * <pre>
	 * 
	 * </pre>
	 * 
	 * based on <code>ACCOUNT_ID</code>.
	 */
	public static final String GET_ASSIGNMENT_ACCOUNT_NAME = "SELECT ACCOUNT_NAME FROM TAB_ACCOUNT WHERE ACCOUNT_ID=?";

	/*	*//**
	 * <p>
	 * <code>GET_ASSIGNMENT_CONTACT_PERSON_NAME</code> token is representing the
	 * constants for SQL query, which is Editing The assignment form
	 * 
	 * <pre>
	 * 
	 * </pre>
	 * 
	 * based on <code>CONTACT_ID</code>.
	 */
	public static final String GET_ASSIGNMENT_CONTACT_PERSON_NAME = "SELECT CONTACT_PERSON FROM TAB_CONTACT WHERE CONTACT_ID=?";

	/*	*//**
	 * <p>
	 * <code>GET_ASSIGNMENT_LEAD_SOURCE_NAME</code> token is representing the
	 * constants for SQL query, which is Editing The assignment form
	 * 
	 * <pre>
	 * 
	 * </pre>
	 * 
	 * based on <code>LEAD_SOURCE_ID</code>.
	 */
	public static final String GET_ASSIGNMENT_LEAD_SOURCE_NAME = "SELECT LEAD_SOURCE_NAME FROM TAB_LEAD_SOURCE WHERE LEAD_SOURCE_ID=?";

	/*	*//**
	 * <p>
	 * <code>GET_ASSIGNMENT_LEAD__NAME</code> token is representing the
	 * constants for SQL query, which is Editing The assignment form
	 * 
	 * <pre>
	 * 
	 * </pre>
	 * 
	 * based on <code>LEAD_ID</code>.
	 */
	public static final String GET_ASSIGNMENT_LEAD__NAME = "SELECT CONTACT_PERSON FROM TAB_LEAD_DETAILS WHERE LEAD_ID=?";

	/*	*//**
	 * <p>
	 * <code>GET_ASSIGNMENT_CAMPAIGN__NAME</code> token is representing the
	 * constants for SQL query, which is Editing The assignment form
	 * 
	 * <pre>
	 * 
	 * </pre>
	 * 
	 * based on <code>CAMPAIGN_ID</code>.
	 */
	public static final String GET_ASSIGNMENT_CAMPAIGN__NAME = "SELECT CAMPAIGN_NAME FROM TAB_CAMPAIGN WHERE CAMPAIGN_ID=?";

	/**
	 * <p>
	 * <code>SHOW_LIST_BOARDING_DETAILS_BY_ID</code> token is representing the
	 * constants for SQL query, which is fetching Boarding List from
	 * <code>TAB_EXPENSES_BOARDING</code> table
	 */
	public static final String SHOW_LIST_BOARDING_DETAILS_BY_ID = "SELECT * FROM TAB_EXPENSES_BOARDING WHERE EXPENSES_BOARDING_CLAIM_ID=?";

	/**
	 * <p>
	 * <code>GET_PRODUCT_NAME_LIST</code>this token is representing the
	 * constants for SQL query, which is fetching
	 * </p>
	 * 
	 * <pre>
	 * PRODUCT_ID ,PRODUCT_NAME
	 * </pre>
	 * 
	 * from <code>TAB_PRODUCT</code>.
	 */
	public static final String INSERT_PRODUCT_DETAIL = "INSERT INTO TAB_PRODUCT_DETAILS(PRODUCT_NAME,PRODUCT_CODE,PRODUCT_CATEGORY,"
			+ "VENDOR_NAME,MANUFACTURER,SALES_START_DATE,SALES_END_DATE,SUPPORT_START_DATE,SUPPORT_EXPIRY_DATE,SERIAL_NO,"
			+ "MFR_PART_NO,VENDOR_PART_NO,PRODUCT_SHEET,WEBSITE,GL_ACCOUNT,UNIT_PRICE,COMMISION_RATE,TAX,PURCHASE_COST,USAGE_UNIT,"
			+ "QTY_PER_UNIT,QTY_IN_STOCK,REORDER_LAVEL,HANDLER,QTY_IN_DEMAND,PRODUCT_IMAGE,DESCRIPTION,CREATED_BY,"
			+ "CREATION_DATE,PRODUCT_ACTIVE)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

	/**
	 * <p>
	 * <code>SHOW_PRODUCT_DETAIL</code> token is representing the constants for
	 * SQL query, which is Insert Data
	 * 
	 * <pre>
	 * 
	 * </pre>
	 * Author Roshan Patel from <code>SHOW_PRODUCT_DETAIL</code>.
	 */
	public static final String SHOW_PRODUCT_DETAIL = "SELECT * FROM TAB_PRODUCT_DETAILS";

	/**
	 * <p>
	 * <code>GET_PRODUCT_DETAIL_EDIT</code> token is representing the constants
	 * for SQL query, which is Insert Data
	 * 
	 * <pre>
	 * 
	 * </pre>
	 * Author Roshan Patel from <code>GET_PRODUCT_DETAIL_EDIT</code>.
	 */
	public static final String GET_PRODUCT_DETAIL_EDIT = "SELECT PRODUCT_ID,PRODUCT_NAME,PRODUCT_CODE,PRODUCT_CATEGORY,VENDOR_NAME,"
			+ "MANUFACTURER,SALES_START_DATE,SALES_END_DATE,SUPPORT_START_DATE,SUPPORT_EXPIRY_DATE,SERIAL_NO,MFR_PART_NO,VENDOR_PART_NO,PRODUCT_SHEET,"
			+ "WEBSITE,GL_ACCOUNT,UNIT_PRICE,COMMISION_RATE,TAX,PURCHASE_COST,USAGE_UNIT,QTY_PER_UNIT,QTY_IN_STOCK,REORDER_LAVEL,HANDLER,"
			+ "QTY_IN_DEMAND,PRODUCT_ACTIVE,PRODUCT_IMAGE,DESCRIPTION FROM TAB_PRODUCT_DETAILS WHERE PRODUCT_ID=?";

	/**
	 * <p>
	 * <code>UPDATE_PRODUCT_DETAIL</code> token is representing the constants
	 * for SQL query, which is Insert Data
	 * 
	 * <pre>
	 * 
	 * </pre>
	 * Author Roshan Patel from <code>UPDATE_PRODUCT_DETAIL</code>.
	 */
	public static final String UPDATE_PRODUCT_DETAIL = "UPDATE TAB_PRODUCT_DETAILS SET PRODUCT_NAME=?,PRODUCT_CODE=?,"
			+ "PRODUCT_CATEGORY=?,VENDOR_NAME=?,"
			+ "MANUFACTURER=?,SALES_START_DATE=?,SALES_END_DATE=?,SUPPORT_START_DATE=?,SUPPORT_EXPIRY_DATE=?,SERIAL_NO=?,MFR_PART_NO=?,"
			+ "VENDOR_PART_NO=?,PRODUCT_SHEET=?,WEBSITE=?,GL_ACCOUNT=?,UNIT_PRICE=?,COMMISION_RATE=?,TAX=?,PURCHASE_COST=?,"
			+ "USAGE_UNIT=?,QTY_PER_UNIT=?,QTY_IN_STOCK=?,REORDER_LAVEL=?,HANDLER=?,QTY_IN_DEMAND=?,PRODUCT_IMAGE=?,DESCRIPTION=?,"
			+ "UPDATED_BY=?,UPDATION_DATE=?,PRODUCT_ACTIVE=? WHERE PRODUCT_ID=?";

	/**
	 * <p>
	 * <code>SHOW_VIEW_PRODUCT_DETAIL</code> token is representing the constants
	 * for SQL query, which is showing Data
	 * 
	 * <pre>
	 * 
	 * </pre>
	 * Author Roshan Patel from <code>TAB_PRODUCT_DETAILS</code>.
	 */
	public static final String SHOW_VIEW_PRODUCT_DETAIL = "SELECT PRODUCT_ID,PRODUCT_NAME,PRODUCT_CODE,PRODUCT_CATEGORY,VENDOR_NAME,"
			+ "MANUFACTURER,SALES_START_DATE,SALES_END_DATE,SUPPORT_START_DATE,SUPPORT_EXPIRY_DATE,SERIAL_NO,MFR_PART_NO,VENDOR_PART_NO,PRODUCT_SHEET,"
			+ "WEBSITE,GL_ACCOUNT,UNIT_PRICE,COMMISION_RATE,TAX,PURCHASE_COST,USAGE_UNIT,QTY_PER_UNIT,QTY_IN_STOCK,REORDER_LAVEL,HANDLER,"
			+ "QTY_IN_DEMAND,PRODUCT_ACTIVE,PRODUCT_IMAGE,DESCRIPTION,CREATED_BY,CREATION_DATE,UPDATED_BY,UPDATION_DATE FROM TAB_PRODUCT_DETAILS WHERE PRODUCT_ID=?";

	/**
	 * <p>
	 * <code>DELETE_PRODUCT_DETAILS</code> token is representing the constants
	 * for SQL query, which is showing Data
	 * 
	 * <pre>
	 * 
	 * </pre>
	 * Author Roshan Patel from <code>TAB_PRODUCT_DETAILS</code>.
	 */
	public static final String DELETE_PRODUCT_DETAILS = "DELETE FROM TAB_PRODUCT_DETAILS WHERE PRODUCT_ID=?";

	/**
	 * <p>
	 * <code>GET_VENDORS_ASSIGNED_TO_NAME_LIST</code>this token is representing
	 * the constants for SQL query, which is fetching
	 * </p>
	 * 
	 * <pre>
	 * CUSTOMER_ID ,FULL_NAME
	 * </pre>
	 * 
	 * from <code>TAB_CUSTOMER_USER</code>.
	 */
	public static final String GET_VENDORS_ASSIGNED_TO_NAME_LIST = "SELECT CUSTOMER_ID,FULL_NAME FROM TAB_CUSTOMER_USER";

	/**
	 * <p>
	 * <code>GET_PRODUCT_TAX_LIST</code> token is representing the constants for
	 * SQL query, which is showing record into table <code>TAB_TAX</code> .
	 * 
	 */
	public static final String GET_PRODUCT_TAX_LIST = "SELECT * FROM TAB_TAX";

	/**
	 * <p>
	 * <code>GET_PRODUCT_CATEGORY_LIST</code> token is representing the
	 * constants for SQL query, which is fatching Data
	 * 
	 * <pre>
	 * 
	 * </pre>
	 * Author Roshan Patel from <code>TAB_PRODUCT_CATEGORY</code>.
	 */
	public static final String GET_PRODUCT_CATEGORY_LIST = "SELECT PRODUCT_CATEGORY_ID,PRODUCT_CATEGORY_NAME FROM TAB_PRODUCT_CATEGORY";

	/**
	 * <p>
	 * <code>GET_PRODUCT_USAGE_UNIT_LIST</code> token is representing the
	 * constants for SQL query, which is Insert Data
	 * 
	 * <pre>
	 * 
	 * </pre>
	 * Author Roshan Patel from <code>TAB_PRODUCT_USAGE_UNIT</code>.
	 */
	public static final String GET_PRODUCT_USAGE_UNIT_LIST = "SELECT PRODUCT_USAGE_UNIT_ID,PRODUCT_USAGE_UNIT_NAME FROM TAB_PRODUCT_USAGE_UNIT";

	/**
	 * <p>
	 * <code>GET_PRODUCT_MANUFACTURER_LIST</code> token is representing the
	 * constants for SQL query, which is fatching Data
	 * 
	 * <pre>
	 * 
	 * </pre>
	 * Author Roshan Patel from <code>TAB_CUSTOMER_USER</code>.
	 */
	public static final String GET_PRODUCT_MANUFACTURER_LIST = "SELECT CUSTOMER_ID,FULL_NAME FROM TAB_CUSTOMER_USER";

	/**
	 * <p>
	 * <code>GET_PRODUCT_HANDLER_LIST</code> token is representing the constants
	 * for SQL query, which is fatching Data
	 * 
	 * <pre>
	 * 
	 * </pre>
	 * Author Roshan Patel from <code>TAB_CUSTOMER_USER</code>.
	 */
	public static final String GET_PRODUCT_HANDLER_LIST = "SELECT CUSTOMER_ID,FULL_NAME FROM TAB_CUSTOMER_USER";

	/**
	 * <p>
	 * <code>GET_PRODUCT_GLACCOUNT_LIST</code> token is representing the
	 * constants for SQL query, which is showing Data
	 * 
	 * <pre>
	 * 
	 * </pre>
	 * Author Roshan Patel from <code>TAB_GL_ACCOUNT</code>.
	 */
	public static final String GET_PRODUCT_GLACCOUNT_LIST = "SELECT GL_ACCOUNT_ID,GL_ACCOUNT_NAME FROM TAB_GL_ACCOUNT";

	/**
	 * <p>
	 * <code>UPDATE_EXPENSES_TICKET_DETAILS</code> token is representing the
	 * constants for SQL query, which is UPDATE Data
	 * 
	 * <pre>
	 * 
	 * </pre>
	 * INTO <code>TAB_EXPENSES_TICKET_FARE</code>.
	 */
	public static final String UPDATE_EXPENSES_TICKET_DETAILS = "UPDATE TAB_EXPENSES_TICKET_FARE SET DETARTURE_PLACE=?,TICKE_DEPARTURE_DATE=?,"
			+ "ARRIVAL_PLACE=?,TICKET_ARRIVAL_DATE=?,TRAVEL_MODE=?,TICKET_AMOUNT=? WHERE TICKET_ID=?";

	/**
	 * <p>
	 * <code>UPDATE_EXPENSES_BOARDING_DETAILS</code> token is representing the
	 * constants for SQL query, which is UPDATE Data
	 * 
	 * <pre>
	 * 
	 * </pre>
	 * INTO <code>TAB_EXPENSES_BOARDING</code>.
	 */
	public static final String UPDATE_EXPENSES_BOARDING_DETAILS = "UPDATE TAB_EXPENSES_BOARDING SET HOTEL_NAME=?,PLACE=?,"
			+ "FROM_DATE=?,TO_DATE=?,BILL_NUMBER=?,BOARDING_AMOUNT=? WHERE BOARDING_ID=?";

	/**
	 * <p>
	 * <code>SHOW_EXPENSES_BOARDING_DETAILS</code> token is representing the
	 * constants for SQL query, which is GET Data
	 * 
	 * <pre>
	 * 
	 * </pre>
	 * INTO <code>TAB_EXPENSES_BOARDING</code>.
	 */
	public static final String SHOW_EXPENSES_BOARDING_DETAILS = "SELECT * FROM TAB_EXPENSES_BOARDING WHERE BOARDING_ID=?";

	/*	*//**
	 * <p>
	 * <code>INSERT_EVENT_DETAIL</code> token is representing the constants for
	 * SQL query, which is inserting the Event details form
	 * 
	 * <pre>
	 * 
	 * </pre>
	 * 
	 * <code>TAB_EVENT_DETAILS</code>.
	 */
	public static final String INSERT_EVENT_DETAIL = "INSERT INTO TAB_EVENT_DETAILS(EVENT_TITLE,EVENT_DATE_TIME,EVENT_CATEGORY,EVENT_ORGANIZE_NAME,MOBILE_ISD,"
			+ "MOBILE_NO,EVENT_EMAIL,EVENT_URL,EVENT_STATUS,EVENT_VENUE,EVENT_PUBLISH_DATE,FILE_NAME,DESCRIPTION,CREATED_DATE,MOBILE_NUMBER)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	/*	*//**
	 * <p>
	 * <code>SHOW_EVENT_DETAIL</code> token is representing the constants for
	 * SQL query, which is viewing Grid the Event details form
	 * 
	 * <pre>
	 * 
	 * </pre>
	 * 
	 * <code>TAB_EVENT_DETAILS</code>.
	 */
	public static final String SHOW_EVENT_DETAIL = "SELECT * FROM TAB_EVENT_DETAILS";
	/*	*//**
	 * <p>
	 * <code>GET_EVENT_CATEGORY_LIST</code> token is representing the constants
	 * for SQL query, which is viewing list the Event details form
	 * 
	 * <pre>
	 * 
	 * </pre>
	 * 
	 * <code>TAB_EVENT_CATEGORY</code>.
	 */
	public static final String GET_EVENT_CATEGORY_LIST = "SELECT EVENT_CATEGORY_ID,EVENT_CATEGORY_NAME FROM TAB_EVENT_CATEGORY";
	/*	*//**
	 * <p>
	 * <code>SHOW_VIEW_EVENT_DETAIL</code> token is representing the constants
	 * for SQL query, which is viewing the Event details form
	 * 
	 * <pre>
	 * 
	 * </pre>
	 * 
	 * <code>TAB_EVENT_DETAILS</code>.
	 */
	public static final String SHOW_VIEW_EVENT_DETAIL = "SELECT EVENT_ID,EVENT_TITLE,EVENT_DATE_TIME,EVENT_CATEGORY,"
			+ "EVENT_ORGANIZE_NAME,MOBILE_ISD,MOBILE_NO,EVENT_EMAIL,EVENT_URL,EVENT_STATUS,EVENT_VENUE,EVENT_PUBLISH_DATE,"
			+ "FILE_NAME,DESCRIPTION,CREATED_DATE FROM TAB_EVENT_DETAILS WHERE EVENT_ID=?";
	/*	*//**
	 * <p>
	 * <code>GET_EVENT_DETAIL_EDIT</code> token is representing the constants
	 * for SQL query, which is editing the Event details form
	 * 
	 * <pre>
	 * 
	 * </pre>
	 * 
	 * <code>TAB_EVENT_DETAILS</code>.
	 */
	public static final String GET_EVENT_DETAIL_EDIT = "SELECT EVENT_ID,EVENT_TITLE,EVENT_DATE_TIME,EVENT_CATEGORY,"
			+ "EVENT_ORGANIZE_NAME,MOBILE_ISD,MOBILE_NO,EVENT_EMAIL,EVENT_URL,EVENT_STATUS,EVENT_VENUE,EVENT_PUBLISH_DATE,"
			+ "FILE_NAME,DESCRIPTION FROM TAB_EVENT_DETAILS WHERE EVENT_ID=?";
	/*	*//**
	 * <p>
	 * <code>UPDATE_EVENT_DETAIL</code> token is representing the constants for
	 * SQL query, which is editing the Event details form
	 * 
	 * <pre>
	 * 
	 * </pre>
	 * 
	 * <code>TAB_EVENT_DETAILS</code>.
	 */
	public static final String UPDATE_EVENT_DETAIL = "UPDATE TAB_EVENT_DETAILS SET EVENT_TITLE=?,EVENT_DATE_TIME=?,EVENT_CATEGORY=?,EVENT_ORGANIZE_NAME=?,MOBILE_ISD=?,"
			+ "MOBILE_NO=?,EVENT_EMAIL=?,EVENT_URL=?,EVENT_STATUS=?,EVENT_VENUE=?,EVENT_PUBLISH_DATE=?,FILE_NAME=?,DESCRIPTION=? WHERE EVENT_ID=?";

	/**
	 * <p>
	 * <code>SHOW_EXPENSES_TICKET_FARE_DETAILS</code> token is representing the
	 * constants for SQL query, which is GET Data
	 * 
	 * <pre>
	 * 
	 * </pre>
	 * INTO <code>TAB_EXPENSES_TICKET_FARE</code>.
	 */
	public static final String SHOW_EXPENSES_TICKET_FARE_DETAILS = "SELECT * FROM TAB_EXPENSES_TICKET_FARE WHERE TICKET_ID=?";

	public static final String GET_LEAD_PIE_CHART = "SELECT LEAD_STATUS FROM TAB_LEAD_DETAILS";

	public static final String GET_USER_ROLE_BY_ID = "SELECT USER_ROLE,CUSTOMER_ID FROM TAB_CUSTOMER_USER WHERE CUSTOMER_ID=?";

	/**
	 * <p>
	 * <code>INSERT_COMPANY_TYPE</code> token is representing the constants for
	 * SQL query, which is inserting record into table
	 * <code>TAB_COMPANY_TYPE</code> .
	 * 
	 */
	public static final String INSERT_COMPANY_TYPE = "INSERT INTO TAB_COMPANY_TYPE(COMPANY_TYPE_NAME) VALUES(?)";
	/**
	 * <p>
	 * <code>GET_COMPANY_TYPE_GIRD_LIST</code> token is representing the
	 * constants for SQL query, which is fetching record from TAB_COMPANY_TYPE
	 * <code>TAB_COMPANY_TYPE</code> .
	 * 
	 */
	public static final String GET_COMPANY_TYPE_GIRD_LIST = "SELECT COMPANY_TYPE_ID,COMPANY_TYPE_NAME FROM TAB_COMPANY_TYPE ";
	/**
	 * <p>
	 * <code>GET_COMPANY_CATEGORY_GIRD_LIST</code> token is representing the
	 * constants for SQL query, which is fetching a data from
	 * TAB_COMPANY_CATEGORY <code>TAB_COMPANY_TYPE</code> .
	 * 
	 */
	public static final String GET_COMPANY_CATEGORY_GIRD_LIST = "SELECT COMPANY_CATEGORY_ID,COMPANY_CATEGORY_NAME FROM TAB_COMPANY_CATEGORY";
	/**
	 * <p>
	 * <code>INSERT_COMPANY_CATEGORY</code> token is representing the constants
	 * for SQL query, which is inserting record into table
	 * <code>TAB_COMPANY_TYPE</code> .
	 * 
	 */
	public static final String INSERT_COMPANY_CATEGORY = "INSERT INTO TAB_COMPANY_CATEGORY(COMPANY_CATEGORY_NAME) VALUES (?)";
	/**
	 * <p>
	 * <code>INSERT_FINANCE_TAX</code> token is representing the constants for
	 * SQL query, which is inserting record into table
	 * <code>TAB_COMPANY_TYPE</code> .
	 * 
	 */
	public static final String INSERT_FINANCE_TAX = "INSERT INTO TAB_TAX(TAX_DISPLAY_NAME, TAX_NAME_ONE,TAX_RATE_ONE, TAX_NAME_TWO ,TAX_RATE_TWO, TAX_NAME_THREE ,"
			+ "TAX_RATE_THREE, TAX_NAME_FOUR, TAX_RATE_FOUR,TAX_NAME_FIVE, TAX_RATE_FIVE, TAX_TOTAL ,TAX_CREATED_DATE,TAX_CREATED_BY,UPDATED_BY,UPDATED_DATE )"
			+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	/**
	 * <p>
	 * <code>GET_FINANCE_TAX_GIRD_LIST</code> token is representing the
	 * constants for SQL query, which is get record from table
	 * <code>TAB_COMPANY_TYPE</code> .
	 * 
	 */
	public static final String GET_FINANCE_TAX_GIRD_LIST = "SELECT  TAX_ID, TAX_DISPLAY_NAME, TAX_TOTAL FROM TAB_TAX";
	/**
	 * <p>
	 * <code>GET_PRODUCT_CATEGORY_GIRD_LIST</code>this token is representing the
	 * constants for SQL query, which is fetching
	 * </p>
	 * 
	 * <pre>
	 * PRODUCT_CATEGORY_ID,PRODUCT_CATEGORY_NAME
	 * </pre>
	 * 
	 * from <code>TAB_PRODUCT_CATEGORY</code>.
	 */

	public static final String GET_PRODUCT_CATEGORY_GIRD_LIST = "SELECT  PRODUCT_CATEGORY_ID,PRODUCT_CATEGORY_NAME FROM TAB_PRODUCT_CATEGORY";
	/**
	 * <p>
	 * <code>INSERT_PRODUCT_CATEGORY</code> token is representing the constants
	 * for SQL query, which is inserting record into table
	 * <code>TAB_PRODUCT_CATEGORY</code> .
	 * 
	 */
	public static final String INSERT_PRODUCT_CATEGORY = "INSERT INTO TAB_PRODUCT_CATEGORY(PRODUCT_CATEGORY_NAME) VALUES (?)";
	/**
	 * <p>
	 * <code>INSERT_COMPANY_SECTOR</code> token is representing the constants
	 * for SQL query, which is inserting record into table
	 * <code>TAB_COMPANY_SECTOR</code> .
	 * 
	 */
	public static final String INSERT_COMPANY_SECTOR = "INSERT INTO TAB_COMPANY_SECTOR(COMPANY_SECTOR_NAME) VALUES (?)";
	/**
	 * <p>
	 * <code>GET_COMPANY_SECTOR_GIRD_LIST</code>this token is representing the
	 * constants for SQL query, which is fetching
	 * </p>
	 * 
	 * <pre>
	 * COMPANY_SECTOR_ID,COMPANY_SECTOR_NAME
	 * </pre>
	 * 
	 * from <code>TAB_COMPANY_SECTOR</code>.
	 */

	public static final String GET_COMPANY_SECTOR_GIRD_LIST = "SELECT  COMPANY_SECTOR_ID,COMPANY_SECTOR_NAME FROM TAB_COMPANY_SECTOR";
	/**
	 * <p>
	 * <code>INSERT_FINANCE_GLACCOUNT</code> token is representing the constants
	 * for SQL query, which is inserting record into table
	 * <code>TAB_GL_ACCOUNT</code> .
	 * 
	 */
	public static final String INSERT_FINANCE_GLACCOUNT = "INSERT INTO TAB_GL_ACCOUNT(GL_ACCOUNT_TYPE,GL_ACCOUNT_NAME,DESCRIPTION) VALUES (?,?,?)";
	/**
	 * <p>
	 * <code>GET_FINANCE_TAX_GIRD_LIST</code>this token is representing the
	 * constants for SQL query, which is fetching
	 * </p>
	 * 
	 * <pre>
	 * TAX_ID ,TAX_DISPLAY_NAME,TAX_TOTAL
	 * </pre>
	 * 
	 * from <code>TAB_TAX</code>. /**
	 * <p>
	 * <code>GET_FINANCE_GLACCOUNT_GIRD_LIST</code>this token is representing
	 * the constants for SQL query, which is fetching
	 * </p>
	 * 
	 * <pre>
	 * GL_ACCOUNT_ID,GL_ACCOUNT_NAME
	 * </pre>
	 * 
	 * from <code>TAB_GL_ACCOUNT</code>.
	 */
	public static final String GET_FINANCE_GLACCOUNT_GIRD_LIST = "SELECT GL_ACCOUNT_ID,GL_ACCOUNT_TYPE,GL_ACCOUNT_NAME,DESCRIPTION FROM TAB_GL_ACCOUNT";
	/**
	 * <p>
	 * <code>INSERT_LEAD_SOURCE</code> token is representing the constants for
	 * SQL query, which is inserting record into table
	 * <code>TAB_LEAD_SOURCE</code> .
	 * 
	 */
	public static final String INSERT_LEAD_SOURCE = "INSERT INTO TAB_LEAD_SOURCE( LEAD_SOURCE_NAME) VALUES (?)";
	/**
	 * <p>
	 * <code>GET_LEAD_SOURCE_GIRD_LIST</code>this token is representing the
	 * constants for SQL query, which is fetching
	 * </p>
	 * 
	 * <pre>
	 * LEAD_SOURCE_ID,LEAD_SOURCE_NAME
	 * </pre>
	 * 
	 * from <code>TAB_LEAD_SOURCE</code>.
	 */
	public static final String GET_LEAD_SOURCE_GIRD_LIST = "SELECT LEAD_SOURCE_ID,LEAD_SOURCE_NAME FROM TAB_LEAD_SOURCE";
	/**
	 * <p>
	 * <code>INSERT_ACCOUNT_TYPE</code> token is representing the constants for
	 * SQL query, which is inserting record into table
	 * <code>TAB_ACCOUNT_TYPE</code> .
	 * 
	 */
	public static final String INSERT_ACCOUNT_TYPE = "INSERT INTO TAB_ACCOUNT_TYPE(ACCOUNT_TYPE_NAME) VALUES (?)";
	/**
	 * <p>
	 * <code>GET_ACCOUNT_TYPE_GIRD_LIST</code>this token is representing the
	 * constants for SQL query, which is fetching
	 * </p>
	 * 
	 * <pre>
	 * ACCOUNT_TYPE_ID,ACCOUNT_TYPE_NAME
	 * </pre>
	 * 
	 * from <code>TAB_ACCOUNT_TYPE</code>.
	 */
	public static final String GET_ACCOUNT_TYPE_GIRD_LIST = "SELECT ACCOUNT_TYPE_ID,ACCOUNT_TYPE_NAME FROM TAB_ACCOUNT_TYPE";
	/**
	 * <p>
	 * <code>INSERT_CAMPAIGN_TYPE</code> token is representing the constants for
	 * SQL query, which is inserting record into table
	 * <code>TAB_CAMPAIGN_TYPE</code> .
	 * 
	 */
	public static final String INSERT_CAMPAIGN_TYPE = "INSERT INTO TAB_CAMPAIGN_TYPE(CAMPAIGN_TYPE_NAME) VALUES (?)";
	/**
	 * <p>
	 * <code>GET_CAMPAIGN_TYPE_GIRD_LIST</code>this token is representing the
	 * constants for SQL query, which is fetching
	 * </p>
	 * 
	 * <pre>
	 * CAMPAIGN_TYPE_ID,CAMPAIGN_TYPE_NAME
	 * </pre>
	 * 
	 * from <code>TAB_CAMPAIGN_TYPE</code>.
	 */
	public static final String GET_CAMPAIGN_TYPE_GIRD_LIST = "SELECT CAMPAIGN_TYPE_ID,CAMPAIGN_TYPE_NAME FROM TAB_CAMPAIGN_TYPE";
	/**
	 * <p>
	 * <code>INSERT_VENDOR_CATEGORY</code> token is representing the constants
	 * for SQL query, which is inserting record into table
	 * <code>TAB_VENDOR_CATEGORY</code> .
	 * 
	 */
	public static final String INSERT_VENDOR_CATEGORY = "INSERT INTO TAB_VENDOR_CATEGORY(VENDOR_CATEGORY_NAME) VALUES (?)";
	/**
	 * <p>
	 * <code>GET_VENDOR_CATEGORY_GIRD_LIST</code>this token is representing the
	 * constants for SQL query, which is fetching
	 * </p>
	 * 
	 * <pre>
	 * VENDOR_CATEGORY_ID,VENDOR_CATEGORY_NAME
	 * </pre>
	 * 
	 * from <code>TAB_VENDOR_CATEGORY</code>.
	 */
	public static final String GET_VENDOR_CATEGORY_GIRD_LIST = "SELECT VENDOR_CATEGORY_ID,VENDOR_CATEGORY_NAME FROM TAB_VENDOR_CATEGORY";
	/**
	 * <p>
	 * <code>INSERT_TRAVEL_MODE</code> token is representing the constants for
	 * SQL query, which is inserting record into table
	 * <code>TAB_TRAVEL_MODE</code> .
	 * 
	 */
	public static final String INSERT_TRAVEL_MODE = "INSERT INTO TAB_TRAVEL_MODE(TRAVEL_MODE) VALUES (?)";
	/**
	 * <p>
	 * <code>GET_TRAVEL_MODE_GIRD_LIST</code>this token is representing the
	 * constants for SQL query, which is fetching
	 * </p>
	 * 
	 * <pre>
	 *  TRAVEL_MODE_ID,TRAVEL_MODE
	 * </pre>
	 * 
	 * from <code>TAB_TRAVEL_MODE</code>.
	 */
	public static final String GET_TRAVEL_MODE_GIRD_LIST = "SELECT TRAVEL_MODE_ID,TRAVEL_MODE FROM TAB_TRAVEL_MODE";
	/**
	 * <p>
	 * <code>INSERT_FAQ_CATEGORY</code> token is representing the constants for
	 * SQL query, which is inserting record into table
	 * <code>TAB_FAQ_CATEGORY</code> .
	 * 
	 */
	public static final String INSERT_FAQ_CATEGORY = "INSERT INTO TAB_FAQ_CATEGORY(CATEGORY_NAME) VALUES (?)";
	/**
	 * <p>
	 * <code>GET_TRAVEL_MODE_GIRD_LIST</code>this token is representing the
	 * constants for SQL query, which is fetching
	 * </p>
	 * 
	 * <pre>
	 *  TRAVEL_MODE_ID,TRAVEL_MODE
	 * </pre>
	 * 
	 * from <code>TAB_TRAVEL_MODE</code>.
	 */
	public static final String GET_FAQ_CATEGORY_GIRD_LIST = "SELECT CATEGORY_ID,CATEGORY_NAME FROM TAB_FAQ_CATEGORY";
	/**
	 * <p>
	 * <code>INSERT_CHANNEL</code> token is representing the constants for SQL
	 * query, which is inserting record into table
	 * <code>TAB_CASES_CHANNEL</code> .
	 * 
	 */
	public static final String INSERT_CHANNEL = "INSERT INTO TAB_CASES_CHANNEL(CHANNEL_NAME) VALUES (?)";
	/**
	 * <p>
	 * <code>GET_CHANNEL_GIRD_LIST</code>this token is representing the
	 * constants for SQL query, which is fetching
	 * </p>
	 * 
	 * <pre>
	 *  CHANNEL_ID,CHANNEL_NAME
	 * </pre>
	 * 
	 * from <code>TAB_CASES_CHANNEL</code>.
	 */
	public static final String GET_CHANNEL_GIRD_LIST = "SELECT CHANNEL_ID,CHANNEL_NAME FROM TAB_CASES_CHANNEL";
	/**
	 * <p>
	 * <code>INSERT_TASK_AREA</code> token is representing the constants for SQL
	 * query, which is inserting record into table <code>TAB_TASK_AREA</code> .
	 * 
	 */
	public static final String INSERT_TASK_AREA = "INSERT INTO TAB_TASK_AREA(TASK_AREA) VALUES (?)";
	/**
	 * <p>
	 * <code>GET_TASK_AREA_GIRD_LIST</code>this token is representing the
	 * constants for SQL query, which is fetching
	 * </p>
	 * 
	 * <pre>
	 *  TASK_AREA_ID,TASK_AREA
	 * </pre>
	 * 
	 * from <code>TAB_TASK_AREA</code>.
	 */
	public static final String GET_TASK_AREA_GIRD_LIST = "SELECT TASK_AREA_ID,TASK_AREA FROM TAB_TASK_AREA";
	/**
	 * <p>
	 * <code>UPDATE_COMPANY_LOCAL</code> token is representing the constants for
	 * SQL query, which is updating record into table
	 * <code>TAB_CUSTOMER_USER</code> .
	 * 
	 */
	public static final String UPDATE_COMPANY_LOCAL = "UPDATE TAB_CUSTOMER_USER SET REF_CURRENCY=?,REF_COUNTRY=?,TIME_ZONE=?,LANGUAGE=? WHERE CUSTOMER_ID=?";

	/**
	 * <p>
	 * <code>INSERT_PRODUCT_USES_UNIT</code> token is representing the constants
	 * for SQL query, which is inserting record into table
	 * <code>TAB_PRODUCT_USAGE_UNIT</code> .
	 * 
	 */
	public static final String INSERT_PRODUCT_USES_UNIT = "INSERT INTO TAB_PRODUCT_USAGE_UNIT(PRODUCT_USAGE_UNIT_NAME) VALUES (?)";

	/**
	 * <p>
	 * <code>GET_PRODUCT_USES_UNIT_LIST</code>this token is representing the
	 * constants for SQL query, which is fetching
	 * </p>
	 * 
	 * <pre>
	 *  PRODUCT_USAGE_UNIT_ID,PRODUCT_USAGE_UNIT_NAME
	 * </pre>
	 * 
	 * from <code>TAB_PRODUCT_USAGE_UNIT</code>.
	 */
	public static final String GET_PRODUCT_USES_UNIT_LIST = "SELECT PRODUCT_USAGE_UNIT_ID,PRODUCT_USAGE_UNIT_NAME FROM TAB_PRODUCT_USAGE_UNIT";

	/**
	 * <p>
	 * <code>EDIT_COMPANY_TYPE</code>this token is representing the constants
	 * for SQL query, which is fetching
	 * </p>
	 * 
	 * <pre>
	 *  COMPANY_TYPE_ID,COMPANY_TYPE_NAME
	 * </pre>
	 * 
	 * from <code>TAB_COMPANY_TYPE</code>.
	 */
	public static final String EDIT_COMPANY_TYPE = "SELECT COMPANY_TYPE_NAME FROM TAB_COMPANY_TYPE WHERE COMPANY_TYPE_ID=?";
	/**
	 * <p>
	 * <code>EDIT_COMPANY_TYPE</code>this token is representing the constants
	 * for SQL query, which is fetching
	 * </p>
	 * 
	 * <pre>
	 *  COMPANY_TYPE_ID,COMPANY_TYPE_NAME
	 * </pre>
	 * 
	 * from <code>TAB_COMPANY_TYPE</code>.
	 */
	public static final String UPADATING_COMPANY_TYPE = "UPDATE TAB_COMPANY_TYPE SET COMPANY_TYPE_NAME=? WHERE COMPANY_TYPE_ID=?";
	/**
	 * <p>
	 * <code>EDIT_GL_ACCOUNT</code>this token is representing the constants for
	 * SQL query, which is fetching GL Account from database
	 * </p>
	 * 
	 * <pre>
	 *  GL_ACCOUNT_ID,GL_ACCOUNT_TYPE,GL_ACCOUNT_NAME,DESCRIPTION
	 * </pre>
	 * 
	 * from <code>TAB_GL_ACCOUNT</code>.
	 */
	public static final String EDIT_GL_ACCOUNT = "SELECT GL_ACCOUNT_TYPE,GL_ACCOUNT_NAME,DESCRIPTION FROM TAB_GL_ACCOUNT WHERE GL_ACCOUNT_ID=?";
	/**
	 * <p>
	 * <code>UPADATING_GL_ACCOUNT</code>this token is representing the constants
	 * for SQL query, which is Updating GL Account from database.
	 * </p>
	 * 
	 * <pre>
	 *  GL_ACCOUNT_ID,GL_ACCOUNT_NAME
	 * </pre>
	 * 
	 * from <code>TAB_GL_ACCOUNT</code>.
	 */
	public static final String UPADATING_GL_ACCOUNT = "UPDATE TAB_GL_ACCOUNT SET GL_ACCOUNT_TYPE=?,GL_ACCOUNT_NAME=?,DESCRIPTION=? WHERE GL_ACCOUNT_ID=?";
	/**
	 * <p>
	 * <code>EDIT_LEAD_SOURCE</code>this token is representing the constants for
	 * SQL query, which is fetching Lead Source from database
	 * </p>
	 * 
	 * <pre>
	 *  LEAD_SOURCE_ID,LEAD_SOURCE_NAME
	 * </pre>
	 * 
	 * from <code>TAB_LEAD_SOURCE</code>.
	 */
	public static final String EDIT_LEAD_SOURCE = "SELECT LEAD_SOURCE_NAME FROM TAB_LEAD_SOURCE WHERE LEAD_SOURCE_ID=?";
	/**
	 * <p>
	 * <code>UPADATING_LEAD_SOURCE</code>this token is representing the
	 * constants for SQL query, which is Updating Lead Source from database.
	 * </p>
	 * 
	 * <pre>
	 *  LEAD_SOURCE_ID,LEAD_SOURCE_NAME
	 * </pre>
	 * 
	 * from <code>TAB_LEAD_SOURCE</code>.
	 */
	public static final String UPADATING_LEAD_SOURCE = "UPDATE TAB_LEAD_SOURCE SET LEAD_SOURCE_NAME=? WHERE LEAD_SOURCE_ID=?";
	/**
	 * <p>
	 * <code>EDIT_TAX</code>this token is representing the constants for SQL
	 * query, which is fetching Tax from database
	 * </p>
	 * 
	 * <pre>
	 *  TAX_DISPLAY_NAME, TAX_NAME_ONE,TAX_RATE_ONE, TAX_NAME_TWO ,TAX_RATE_TWO, TAX_NAME_THREE ,
	 * TAX_RATE_THREE, TAX_NAME_FOUR, TAX_RATE_FOUR,TAX_NAME_FIVE, TAX_RATE_FIVE, TAX_TOTAL ,TAX_CREATED_DATE,
	 * TAX_CREATED_BY,UPDATED_BY,UPDATED_DATE
	 * </pre>
	 * 
	 * from <code>TAB_TAX</code>.
	 */
	public static final String EDIT_TAX = "SELECT TAX_DISPLAY_NAME, TAX_NAME_ONE,TAX_RATE_ONE, TAX_NAME_TWO ,TAX_RATE_TWO, TAX_NAME_THREE ,"
			+ "TAX_RATE_THREE, TAX_NAME_FOUR, TAX_RATE_FOUR,TAX_NAME_FIVE, TAX_RATE_FIVE, TAX_TOTAL ,TAX_CREATED_DATE,TAX_CREATED_BY,"
			+ "UPDATED_BY,UPDATED_DATE FROM TAB_TAX WHERE TAX_ID=?";
	/**
	 * <p>
	 * <code>UPADATING_TAX</code>this token is representing the constants for
	 * SQL query, which is Updating Tax from database.
	 * </p>
	 * 
	 * <pre>
	 *  TAX_DISPLAY_NAME, TAX_NAME_ONE,TAX_RATE_ONE, TAX_NAME_TWO ,TAX_RATE_TWO, TAX_NAME_THREE ,
	 * TAX_RATE_THREE, TAX_NAME_FOUR, TAX_RATE_FOUR,TAX_NAME_FIVE, TAX_RATE_FIVE, TAX_TOTAL ,TAX_CREATED_DATE,
	 * TAX_CREATED_BY,UPDATED_BY,UPDATED_DATE
	 * </pre>
	 * 
	 * from <code>TAB_TAX</code>.
	 */
	public static final String UPADATING_TAX = "UPDATE TAB_TAX SET TAX_DISPLAY_NAME=?,TAX_NAME_ONE=?,TAX_RATE_ONE=?, TAX_NAME_TWO =?,"
			+ "TAX_RATE_TWO=?, TAX_NAME_THREE=? ,TAX_RATE_THREE=?, TAX_NAME_FOUR=?, TAX_RATE_FOUR=?,TAX_NAME_FIVE=?, TAX_RATE_FIVE=?, TAX_TOTAL=? ,"
			+ "TAX_CREATED_DATE=?,TAX_CREATED_BY=?,UPDATED_BY=?,UPDATED_DATE=? WHERE TAX_ID=?";

	/**
	 * <p>
	 * <code>EDIT_COMPANY_CATEGORY</code>this token is representing the
	 * constants for SQL query, which is fetching Company Category from database
	 * </p>
	 * 
	 * <pre>
	 *  COMPANY_CATEGORY_ID,COMPANY_CATEGORY_NAME
	 * </pre>
	 * 
	 * from <code>TAB_COMPANY_CATEGORY</code>.
	 */
	public static final String EDIT_COMPANY_CATEGORY = "SELECT COMPANY_CATEGORY_NAME FROM TAB_COMPANY_CATEGORY WHERE COMPANY_CATEGORY_ID=?";
	/**
	 * <p>
	 * <code>UPADATING_COMPANY_CATEGORY</code>this token is representing the
	 * constants for SQL query, which is Updating Company Category from
	 * database.
	 * </p>
	 * 
	 * <pre>
	 *  COMPANY_CATEGORY_ID,COMPANY_CATEGORY_NAME
	 * </pre>
	 * 
	 * from <code>TAB_COMPANY_CATEGORY</code>.
	 */
	public static final String UPADATING_COMPANY_CATEGORY = "UPDATE TAB_COMPANY_CATEGORY SET COMPANY_CATEGORY_NAME=? WHERE COMPANY_CATEGORY_ID=?";
	/**
	 * <p>
	 * <code>EDIT_COMPANY_CATEGORY</code>this token is representing the
	 * constants for SQL query, which is fetching Company Category from database
	 * </p>
	 * 
	 * <pre>
	 *  COMPANY_CATEGORY_ID,COMPANY_CATEGORY_NAME
	 * </pre>
	 * 
	 * from <code>TAB_COMPANY_CATEGORY</code>.
	 */
	public static final String EDIT_COMPANY_SECTOR = "SELECT COMPANY_SECTOR_NAME FROM TAB_COMPANY_SECTOR WHERE COMPANY_SECTOR_ID=?";
	/**
	 * <p>
	 * <code>UPADATING_COMPANY_SECTOR</code>this token is representing the
	 * constants for SQL query, which is Updating Company Sector from database.
	 * </p>
	 * 
	 * <pre>
	 *  COMPANY_SECTOR_ID,COMPANY_SECTOR_NAME
	 * </pre>
	 * 
	 * from <code>TAB_COMPANY_SECTOR</code>.
	 */
	public static final String UPADATING_COMPANY_SECTOR = "UPDATE TAB_COMPANY_SECTOR SET COMPANY_SECTOR_NAME=? WHERE COMPANY_SECTOR_ID=?";
	/**
	 * <p>
	 * <code>EDIT_ACCOUNT_TYPE</code>this token is representing the constants
	 * for SQL query, which is fetching Account type from database
	 * </p>
	 * 
	 * <pre>
	 *  ACCOUNT_TYPE_ID,ACCOUNT_TYPE_NAME
	 * </pre>
	 * 
	 * from <code>TAB_ACCOUNT_TYPE</code>.
	 */
	public static final String EDIT_ACCOUNT_TYPE = "SELECT ACCOUNT_TYPE_NAME FROM TAB_ACCOUNT_TYPE WHERE ACCOUNT_TYPE_ID=?";
	/**
	 * <p>
	 * <code>UPADATING_ACCOUNT_TYPE</code>this token is representing the
	 * constants for SQL query, which is Updating ACCOUNT TYPE from database.
	 * </p>
	 * 
	 * <pre>
	 *  ACCOUNT_TYPE_ID,ACCOUNT_TYPE_NAME
	 * </pre>
	 * 
	 * from <code>TAB_ACCOUNT_TYPE</code>.
	 */
	public static final String UPADATING_ACCOUNT_TYPE = "UPDATE TAB_ACCOUNT_TYPE SET ACCOUNT_TYPE_NAME=? WHERE ACCOUNT_TYPE_ID=?";
	/**
	 * <p>
	 * <code>EDIT_CAMPAIGN_TYPE</code>this token is representing the constants
	 * for SQL query, which is fetching CAMPAIGN type from database
	 * </p>
	 * 
	 * <pre>
	 *  CAMPAIGN_TYPE_ID,CAMPAIGN_TYPE_NAME
	 * </pre>
	 * 
	 * from <code>TAB_CAMPAIGN_TYPE</code>.
	 */
	public static final String EDIT_CAMPAIGN_TYPE = "SELECT CAMPAIGN_TYPE_NAME FROM TAB_CAMPAIGN_TYPE WHERE CAMPAIGN_TYPE_ID=?";
	/**
	 * <p>
	 * <code>UPADATING_CAMPAIGN_TYPE</code>this token is representing the
	 * constants for SQL query, which is Updating CAMPAIGN TYPE from database.
	 * </p>
	 * 
	 * <pre>
	 *  CAMPAIGN_TYPE_ID,CAMPAIGN_TYPE_NAME
	 * </pre>
	 * 
	 * from <code>TAB_CAMPAIGN_TYPE</code>.
	 */
	public static final String UPADATING_CAMPAIGN_TYPE = "UPDATE TAB_CAMPAIGN_TYPE SET CAMPAIGN_TYPE_NAME=? WHERE CAMPAIGN_TYPE_ID=?";
	/**
	 * <p>
	 * <code>EDIT_VENDOR_CATEGORY</code>this token is representing the constants
	 * for SQL query, which is fetching VENDOR CATEGORY from database
	 * </p>
	 * 
	 * <pre>
	 *  VENDOR_CATEGORY_ID,VENDOR_CATEGORY_NAME
	 * </pre>
	 * 
	 * from <code>TAB_VENDOR_CATEGORY</code>.
	 */
	public static final String EDIT_VENDOR_CATEGORY = "SELECT VENDOR_CATEGORY_NAME FROM TAB_VENDOR_CATEGORY WHERE VENDOR_CATEGORY_ID=?";
	/**
	 * <p>
	 * <code>UPADATING_VENDOR_CATEGORY</code>this token is representing the
	 * constants for SQL query, which is Updating VENDOR CATEGORY from database.
	 * </p>
	 * 
	 * <pre>
	 *  VENDOR_CATEGORY_ID,VENDOR_CATEGORY_NAME
	 * </pre>
	 * 
	 * from <code>TAB_VENDOR_CATEGORY</code>.
	 */
	public static final String UPADATING_VENDOR_CATEGORY = "UPDATE TAB_VENDOR_CATEGORY SET VENDOR_CATEGORY_NAME=? WHERE VENDOR_CATEGORY_ID=?";
	/**
	 * <p>
	 * <code>EDIT_TRAVEL_MODE</code>this token is representing the constants for
	 * SQL query, which is fetching TRAVEL MODE from database
	 * </p>
	 * 
	 * <pre>
	 *  TRAVEL_MODE_ID,TRAVEL_MODE
	 * </pre>
	 * 
	 * from <code>TAB_TRAVEL_MODE</code>.
	 */
	public static final String EDIT_TRAVEL_MODE = "SELECT TRAVEL_MODE FROM TAB_TRAVEL_MODE WHERE TRAVEL_MODE_ID=?";
	/**
	 * <p>
	 * <code>UPADATING_TRAVEL_MODE</code>this token is representing the
	 * constants for SQL query, which is Updating TRAVEL MODE from database.
	 * </p>
	 * 
	 * <pre>
	 *  TRAVEL_MODE_ID,TRAVEL_MODE
	 * </pre>
	 * 
	 * from <code>TAB_TRAVEL_MODE</code>.
	 */
	public static final String UPADATING_TRAVEL_MODE = "UPDATE TAB_TRAVEL_MODE SET TRAVEL_MODE=? WHERE TRAVEL_MODE_ID=?";
	/**
	 * <p>
	 * <code>EDIT_PRODUCT_CATEGORY</code>this token is representing the
	 * constants for SQL query, which is fetching PRODUCT CATEGORY from database
	 * </p>
	 * 
	 * <pre>
	 *  PRODUCT_CATEGORY_ID,PRODUCT_CATEGORY_NAME
	 * </pre>
	 * 
	 * from <code>TAB_PRODUCT_CATEGORY</code>.
	 */
	public static final String EDIT_PRODUCT_CATEGORY = "SELECT PRODUCT_CATEGORY_NAME FROM TAB_PRODUCT_CATEGORY WHERE PRODUCT_CATEGORY_ID=?";
	/**
	 * <p>
	 * <code>UPADATING_PRODUCT_CATEGORY</code>this token is representing the
	 * constants for SQL query, which is Updating PRODUCT CATEGORY from
	 * database.
	 * </p>
	 * 
	 * <pre>
	 *  PRODUCT_CATEGORY_ID,PRODUCT_CATEGORY_NAME
	 * </pre>
	 * 
	 * from <code>TAB_PRODUCT_CATEGORY</code>.
	 */
	public static final String UPADATING_PRODUCT_CATEGORY = "UPDATE TAB_PRODUCT_CATEGORY SET PRODUCT_CATEGORY_NAME=? WHERE PRODUCT_CATEGORY_ID=?";
	/**
	 * <p>
	 * <code>EDIT_PRODUCT_USES_UNIT</code>this token is representing the
	 * constants for SQL query, which is fetching PRODUCT USES UNIT from
	 * database
	 * </p>
	 * 
	 * <pre>
	 *  PRODUCT_USAGE_UNIT_ID,PRODUCT_USAGE_UNIT_NAME
	 * </pre>
	 * 
	 * from <code>TAB_PRODUCT_USAGE_UNIT</code>.
	 */
	public static final String EDIT_PRODUCT_USES_UNIT = "SELECT PRODUCT_USAGE_UNIT_NAME FROM TAB_PRODUCT_USAGE_UNIT WHERE PRODUCT_USAGE_UNIT_ID=?";
	/**
	 * <p>
	 * <code>UPADATING_PRODUCT_USES_UNIT</code>this token is representing the
	 * constants for SQL query, which is Updating PRODUCT USES UNIT from
	 * database.
	 * </p>
	 * 
	 * <pre>
	 *  PRODUCT_USAGE_UNIT_ID,PRODUCT_USAGE_UNIT_NAME
	 * </pre>
	 * 
	 * from <code>TAB_PRODUCT_USAGE_UNIT</code>.
	 */
	public static final String UPADATING_PRODUCT_USES_UNIT = "UPDATE TAB_PRODUCT_USAGE_UNIT SET PRODUCT_USAGE_UNIT_NAME=? WHERE PRODUCT_USAGE_UNIT_ID=?";
	/**
	 * <p>
	 * <code>EDIT_FAQ_CATEGORY</code>this token is representing the constants
	 * for SQL query, which is fetching FAQ CATEGORY from database
	 * </p>
	 * 
	 * <pre>
	 *  CATEGORY_ID,CATEGORY_NAME
	 * </pre>
	 * 
	 * from <code>TAB_FAQ_CATEGORY</code>.
	 */
	public static final String EDIT_FAQ_CATEGORY = "SELECT CATEGORY_NAME FROM TAB_FAQ_CATEGORY WHERE CATEGORY_ID=?";
	/**
	 * <p>
	 * <code>UPADATING_FAQ_CATEGORY</code>this token is representing the
	 * constants for SQL query, which is Updating FAQ CATEGORY from database.
	 * </p>
	 * 
	 * <pre>
	 *  CATEGORY_ID,CATEGORY_NAME
	 * </pre>
	 * 
	 * from <code>TAB_FAQ_CATEGORY</code>.
	 */
	public static final String UPADATING_FAQ_CATEGORY = "UPDATE TAB_FAQ_CATEGORY SET CATEGORY_NAME=? WHERE CATEGORY_ID=?";
	/**
	 * <p>
	 * <code>EDIT_CHANNEL</code>this token is representing the constants for SQL
	 * query, which is fetching channel from database
	 * </p>
	 * 
	 * <pre>
	 *  CHANNEL_ID,CHANNEL_NAME
	 * </pre>
	 * 
	 * from <code>TAB_CASES_CHANNEL</code>.
	 */
	public static final String EDIT_CHANNEL = "SELECT CHANNEL_NAME FROM TAB_CASES_CHANNEL WHERE CHANNEL_ID=?";
	/**
	 * <p>
	 * <code>UPADATING_CHANEEL</code>this token is representing the constants
	 * for SQL query, which is Updating CHANNEL from database.
	 * </p>
	 * 
	 * <pre>
	 *  CHANNEL_ID,CHANNEL_NAME
	 * </pre>
	 * 
	 * from <code>TAB_CASES_CHANNEL</code>.
	 */
	public static final String UPADATING_CHANNEL = "UPDATE TAB_CASES_CHANNEL SET CHANNEL_NAME=? WHERE CHANNEL_ID=?";

	/**
	 * <p>
	 * <code>EDIT_TASK_AREA</code>this token is representing the constants for
	 * SQL query, which is fetching TASK AREA from database
	 * </p>
	 * 
	 * <pre>
	 *  TASK_AREA_ID,TASK_AREA
	 * </pre>
	 * 
	 * from <code>TAB_TASK_AREA</code>.
	 */
	public static final String EDIT_TASK_AREA = "SELECT TASK_AREA FROM TAB_TASK_AREA WHERE TASK_AREA_ID=?";

	/**
	 * <p>
	 * <code>ADD_COMMENT</code> token is representing the constants for SQL
	 * query, which is Insert The comment into <code>TAB_VANRA_CONTACT</code>
	 * table.
	 */
	public static final String ADD_COMMENT = "INSERT INTO TAB_VANRA_CONTACT(FULL_NAME,EMAIL_ID,MOBILE_NO,COMMENT,"
			+ "IP_ADDRESS,CREATION_DATE)VALUES(?,?,?,?,?,?)";

	/**
	 * <p>
	 * <code>GET_SECURITY_QUESTION_NAME</code> token is representing the
	 * constants for SQL query, which is GET SEQ_QUESTION
	 * 
	 * <pre>
	 * 
	 * </pre>
	 * INTO <code>TAB_SECURITY_QUESTION_LIST</code>.
	 */

	public static final String GET_SECURITY_QUESTION_NAME = "SELECT SEQ_QUESTION FROM TAB_SECURITY_QUESTION_LIST WHERE SEQ_QUE_ID=?";

	/**
	 * <p>
	 * <code>SELECT_SECURITY_QUESTION</code> token is representing the constants
	 * for SQL query, which is GET PRIMARY_EMAIL_ID,REF_SECURITY_QUESTION_ID
	 * 
	 * <pre>
	 * 
	 * </pre>
	 * INTO <code>TAB_CUSTOMER_USER</code>.
	 */
	public static final String SELECT_SECURITY_QUESTION = "SELECT PRIMARY_EMAIL_ID,REF_SECURITY_QUESTION_ID "
			+ "FROM TAB_CUSTOMER_USER WHERE PRIMARY_EMAIL_ID=?";

	/**
	 * <p>
	 * <code>SELECT_PASSWORD</code> token is representing the constants for SQL
	 * query, which is GET CUSTOMER_ID,PASSWORD,FULL_NAME,PRIMARY_EMAIL_ID
	 * 
	 * <pre>
	 * 
	 * </pre>
	 * INTO <code>TAB_CUSTOMER_USER</code>.
	 */

	public static final String SELECT_PASSWORD = "SELECT CUSTOMER_ID,PASSWORD,FULL_NAME,PRIMARY_EMAIL_ID FROM TAB_CUSTOMER_USER WHERE PRIMARY_EMAIL_ID=? AND ANSWER=?";

	/**
	 * <code>CALCULATE_OTHER_AMOUNT_B </code> token is representing the
	 * constants for SQL query, which is editing the Other Travel Info details
	 * form
	 * 
	 * <pre>
	 * 
	 * </pre>
	 * 
	 * <code>CALCULATE_OTHER_AMOUNT_B </code>.
	 */
	public static final String CALCULATE_OTHER_AMOUNT_B = "SELECT SUM(AMOUNT) AS CALCULATE_OTHER_AMOUNT_B FROM TAB_EXPENSES_MONTHLY_OTHER WHERE MONTHLY_OTHER_REF_NO=?";

	/**
	 * 
	 * <code>SHOW_LIST_OTHER_DETAILS_BY_ID</code> token is representing the
	 * constants for SQL query, which is editing the Other Travel Info details
	 * form
	 * 
	 * <pre>
	 * 
	 * </pre>
	 * 
	 * <code>SHOW_LIST_OTHER_DETAILS_BY_ID</code>.
	 */
	public static final String SHOW_LIST_OTHER_DETAILS_BY_ID = "SELECT * FROM TAB_EXPENSES_MONTHLY_OTHER WHERE MONTHLY_CLAIM_ID=?";

	/**
	 * <p>
	 * <code>_FORGET_PASSWORD_DETAILS_BY_REFNO</code> token is representing the
	 * constants for SQL query, which is Get Details by REFNO.
	 * 
	 * <pre>
	 * 
	 * </pre>
	 * INTO <code>TEMP_FORGET_PASSWORD</code>.
	 */

	public static final String GET_FORGET_PASSWORD_DETAILS_BY_REFNO = "SELECT * FROM TEMP_FORGET_PASSWORD WHERE FORGET_PASSWORD_GUID=?";

	/**
	 * <p>
	 * <code>UPDATE_EMAIL_FLAG_FORGET_PASSWORD</code> token is representing the
	 * constants for SQL query, which is Set Flag
	 * 
	 * <pre>
	 * 
	 * </pre>
	 * INTO <code>TEMP_FORGET_PASSWORD</code>.
	 */

	public static final String UPDATE_EMAIL_FLAG_FORGET_PASSWORD = "UPDATE TEMP_FORGET_PASSWORD "
			+ "SET EMAIL_FLAG=? WHERE FORGET_PASSWORD_GUID=? ";
	/**
	 * <p>
	 * <code>INSERT_FORGET_PASSWORD_DETAILS</code> token is representing the
	 * constants for SQL query, which is Insert Forget Password Details.
	 * 
	 * <pre>
	 * 
	 * </pre>
	 * INTO <code>TAB_CUSTOMER_USER</code>.
	 */

	public static final String INSERT_FORGET_PASSWORD_DETAILS = "INSERT INTO TEMP_FORGET_PASSWORD"
			+ "(PRIMARY_EMAIL_ID,FORGET_PASSWORD_GUID,IP_ADDRESS,EMAIL_FLAG,CREATED_BY,CREATION_DATE) VALUES(?,?,?,?,?,?)";

	/**
	 * <p>
	 * <code>INSERT_COUNTRY</code> token is representing the constants for SQL
	 * query, which is inserting record into table <code>TAB_COUNTRY</code> .
	 * 
	 */
	public static final String INSERT_COUNTRY = "INSERT INTO TAB_COUNTRY(COUNTRY_NAME,COUNTRY_CODE,ISD_CODE,COUNTRY_DISPLAY_NAME) VALUES (?,?,?,?)";
	/**
	 * <p>
	 * <code>GET_COUNTRY_GIRD_LIST</code>this token is representing the
	 * constants for SQL query, which is fetching
	 * </p>
	 * 
	 * <pre>
	 * COUNTRY_ID,COUNTRY_NAME,COUNTRY_CODE,ISD_CODE,COUNTRY_DISPLAY_NAME
	 * </pre>
	 * 
	 * from <code>TAB_CAMPAIGN_TYPE</code>.
	 */
	public static final String GET_COUNTRY_GIRD_LIST = "SELECT COUNTRY_ID,COUNTRY_NAME,COUNTRY_CODE,ISD_CODE,COUNTRY_DISPLAY_NAME FROM TAB_COUNTRY";
	/**
	 * <p>
	 * <code>EDIT_COUNTRY</code>this token is representing the constants for SQL
	 * query, which is fetching COUNTRY Details from database
	 * </p>
	 * 
	 * <pre>
	 *  COUNTRY_NAME,COUNTRY_CODE,ISD_CODE,COUNTRY_DISPLAY_NAME
	 * </pre>
	 * 
	 * from <code>TAB_COUNTRY</code>.
	 */
	public static final String EDIT_COUNTRY = "SELECT COUNTRY_NAME,COUNTRY_CODE,ISD_CODE,COUNTRY_DISPLAY_NAME FROM TAB_COUNTRY WHERE COUNTRY_ID=?";
	/**
	 * <P>
	 * <code>UPDATE_COUNTRY</code>this token is representing the constants for
	 * SQl query,which is Updating COUNTRY Details from Database
	 * </P>
	 * 
	 * <pre>
	 * COUNTRY_NAME,COUNTRY_CODE,ISD_CODE,COUNTRY_DISPLAY_NAME
	 * </pre>
	 * 
	 * from<code>TAB_COUNTRY</code>
	 */
	public static final String UPDATE_COUNTRY = "UPDATE TAB_COUNTRY SET COUNTRY_NAME=?,COUNTRY_CODE=?,ISD_CODE=?,COUNTRY_DISPLAY_NAME=? WHERE COUNTRY_ID=?";

	public static final String UPADATING_TASK_AREA = null;

	/**
	 * <p>
	 * <code>ADD_EXPENSES_MONTHLY_DETAILS</code> token is representing the
	 * constants for SQL query, which is use to Insert Data
	 * 
	 * <pre>
	 * 
	 * </pre>
	 * 
	 * from <code>TAB_EXPENSES_MONTHLY</code>.
	 */

	public static String ADD_EXPENSES_MONTHLY_DETAILS = "INSERT INTO TAB_EXPENSES_MONTHLY (NAME,PLACE_OF_VISIT,PURPOSE_OF_VISIT,"
			+ "DEPARTURE_DATE,ARRIVAL_DATE,APPROVED_BY,TOTAL_AMOUNT_A,TOTAL_AMOUNT_B,ADVANCE_AMOUNT_C,CLAIMED_BALANCE,MONTHLY_EXPENSES_REF_NO) VALUE(?,?,?,?,?,?,?,?,?,?,?)";

	/**
	 * <p>
	 * <code>ADD_MONTHLY_TRAVEL_DETAILS</code> token is representing the
	 * constants for SQL query, which is use to Insert Data
	 * 
	 * <pre>
	 * 
	 * </pre>
	 * 
	 * from <code>TAB_EXPENSES_MONTHLY_TRAVEL</code>.
	 */
	public static final String ADD_MONTHLY_TRAVEL_DETAILS = "INSERT INTO TAB_EXPENSES_MONTHLY_TRAVEL(DEPARTURE_PLACE,"
			+ "DEPARTURE_DATE,FROM_PLACE,TO_PLACE,TRAVEL_MODE,AMOUNT,CREATED_BY,CREATION_DATE,MONTHLY_TRAVEL_REF_NO)VALUES(?,?,?,?,?,?,?,?,?)";

	/**
	 * <p>
	 * <code>GET_MONTHLY_OTHER_GIRD_LIST</code>this token is representing the
	 * constants for SQL query, which is fetching
	 * </p>
	 * 
	 * <pre>
	 * OTHER_CLAIM_ID,
	 * </pre>
	 * 
	 * from <code>GET_MONTHLY_OTHER_GIRD_LIST</code>.
	 */
	public static final String GET_MONTHLY_OTHER_GIRD_LIST = "SELECT * FROM TAB_EXPENSES_MONTHLY_OTHER";

	/**
	 * <p>
	 * <code>GET_MONTHLY_OTHER_GIRD_LIST</code>this token is representing the
	 * constants for SQL query, which is fetching
	 * </p>
	 * 
	 * <pre>
	 * OTHER_CLAIM_ID,
	 * </pre>
	 * 
	 * from <code>GET_MONTHLY_OTHER_GIRD_LIST</code>.
	 */
	public static final String VIEW_EXPENSES_MONTHLY_TRAVEL = "select * from TAB_EXPENSES_MONTHLY_TRAVEl where TRAVEL_CLAIM_ID=?";

	/**
	 * <p>
	 * <code>GET_MONTHLY_OTHER_GIRD_LIST</code>this token is representing the
	 * constants for SQL query, which is fetching
	 * </p>
	 * 
	 * <pre>
	 * OTHER_CLAIM_ID,
	 * </pre>
	 * 
	 * from <code>GET_MONTHLY_OTHER_GIRD_LIST</code>.
	 */
	public static final String VIEW_OTHER_EXPENSES_DETAILS = "SELECT * FROM TAB_EXPENSES_MONTHLY_OTHER WHERE OTHER_CLAIM_ID=?";

	/**
	 * <p>
	 * <code>GET_EXPENSES_M0NTHLY_GIRD_LIST</code>this token is representing the
	 * constants for SQL query, which is fetching
	 * </p>
	 * 
	 * <pre>
	 * OTHER_CLAIM_ID,
	 * </pre>
	 * 
	 * from <code>TAB_EXPENSES_MONTHLY</code>.
	 */
	public static final String GET_EXPENSES_M0NTHLY_GIRD_LIST = "SELECT MONTHLI_CLAIM_ID,NAME,CLAIMED_BALANCE,CLAIM_STATUS,DEPARTURE_DATE,ARRIVAL_DATE,APPROVED_BY "
			+ "FROM TAB_EXPENSES_MONTHLY ";

	/**
	 * <p>
	 * <code>SHOW_LIST_OTHER_MONTHLY_DETAILS</code> token is representing the
	 * constants for SQL query, which is editing the Other Travel Info details
	 * form
	 * 
	 * <pre>
	 * 
	 * </pre>
	 * 
	 * <code>TAB_EVENT_DETAILS</code>.
	 */
	public static final String SHOW_LIST_OTHER_MONTHLY_DETAILS = "SELECT * FROM TAB_EXPENSES_MONTHLY_OTHER WHERE MONTHLY_OTHER_REF_NO=?";

	/**
	 * <p>
	 * <code>VIEW_CLAIM_EXPENSES_MONTHLY_DETAILS</code> token is representing
	 * the constants for SQL query, which is editing the Other Travel Info
	 * details form
	 * 
	 * <pre>
	 * 
	 * </pre>
	 * 
	 * <code>VIEW_CLAIM_EXPENSES_MONTHLY_DETAILS</code>.
	 */
	public static final String VIEW_CLAIM_EXPENSES_MONTHLY_DETAILS = "SELECT * FROM TAB_EXPENSES_MONTHLY WHERE MONTHLI_CLAIM_ID=?";

	/**
	 * <p>
	 * <code>VIEW_LIST_TRAVEL_DETAILS_BY_ID</code> token is representing the
	 * constants for SQL query, which is editing the Other Travel Info details
	 * form
	 * 
	 * <pre>
	 * 
	 * </pre>
	 * 
	 * <code>VIEW_LIST_TRAVEL_DETAILS_BY_ID</code>.
	 */
	public static final String VIEW_LIST_TRAVEL_DETAILS_BY_ID = "SELECT TRAVEL_CLAIM_ID,DEPARTURE_PLACE,DEPARTURE_DATE,FROM_PLACE,TO_PLACE,TRAVEL_MODE,AMOUNT FROM TAB_EXPENSES_MONTHLY_TRAVEL WHERE TRAVEL_CLAIM_ID=?";
	/**
	 * /**
	 * <p>
	 * <code>VIEW_LIST_OTHER_DETAILS_BY_ID</code> token is representing the
	 * constants for SQL query, which is editing the Other Travel Info details
	 * form
	 * 
	 * <pre>
	 * 
	 * </pre>
	 * 
	 * <code>VIEW_LIST_OTHER_DETAILS_BY_ID</code>.
	 */
	public static final String VIEW_LIST_OTHER_DETAILS_BY_ID = "SELECT * FROM TAB_EXPENSES_MONTHLY_OTHER WHERE OTHER_CLAIM_ID=?";

	/**
	 * <p>
	 * <code>SHOW_LIST_TRAVEL_MONTHLY_DETAILS</code> token is representing the
	 * constants for SQL query, which is editing the TravelMonthly details form
	 * 
	 * <pre>
	 * 
	 * </pre>
	 * 
	 * <code>TAB_EVENT_DETAILS</code>.
	 */
	public static final String SHOW_LIST_TRAVEL_MONTHLY_DETAILS = "SELECT * FROM TAB_EXPENSES_MONTHLY_TRAVEL WHERE MONTHLY_TRAVEL_REF_NO=?";

	public static final String CALCULATE_TRAVEL_AMOUNT_A = "SELECT SUM(AMOUNT) AS CALCULATE_AMOUNT_A FROM TAB_EXPENSES_MONTHLY_TRAVEL WHERE MONTHLY_TRAVEL_REF_NO=?";

	/**
	 * <p>
	 * <code>ADD_TRAVEL_INFO</code> token is representing the constants for SQL
	 * query, which is editing the ADD Travel Info details form
	 * 
	 * <pre>
	 * 
	 * </pre>
	 * 
	 * <code>TAB_EVENT_DETAILS</code>.
	 */
	public static final String ADD_TRAVEL_INFO = "INSERT INTO TAB_EXPENSES_MONTHLY_TRAVEL(DEPARTURE_PLACE,DEPARTURE_DATE,"
			+ "FROM_PLACE,TO_PLACE,TRAVEL_MODE,AMOUNT,CREATED_BY,MONTHLY_TRAVEL_REF_NO) VALUES (?,?,?,?,?,?,?,?)";

	/**
	 * <p>
	 * <code>GET_MONTHLY_TRAVEL_GIRD_LIST</code>this token is representing the
	 * constants for SQL query, which is fetching
	 * </p>
	 * 
	 * <pre>
	 * TRAVEL_CLAIM_ID ,
	 * </pre>
	 * 
	 * from <code>GET_MONTHLY_TRAVEL_GIRD_LIST</code>.
	 */
	public static String GET_MONTHLY_TRAVEL_GIRD_LIST = "SELECT * FROM TAB_EXPENSES_MONTHLY_TRAVEL WHERE MONTHLY_TRAVEL_REF_NO=?";

	/**
	 * <p>
	 * <code>UPDATE_EXPENSES_MONTHLY_DETAILS</code> token is representing the
	 * constants for SQL query, which is editing the Other Travel Info details
	 * form
	 * 
	 * <pre>
	 * 
	 * </pre>
	 * 
	 * <code>UPDATE_EXPENSES_MONTHLY_DETAILS</code>.
	 */
	public static final String UPDATE_EXPENSES_MONTHLY_DETAILS = "UPDATE TAB_EXPENSES_MONTHLY SET NAME=?,PLACE_OF_VISIT=?,PURPOSE_OF_VISIT=?,DEPARTURE_DATE=?,"
			+ "ARRIVAL_DATE=?,APPROVED_BY=?,TOTAL_AMOUNT_A=?,TOTAL_AMOUNT_B=?,CLAIM_STATUS=?,CLAIM_COMMENT=? WHERE MONTHLI_CLAIM_ID=?";

	/**
	 * <p>
	 * <code>SHOW_LIST_TRAVEL_DETAILS_BY_ID</code> token is representing the
	 * constants for SQL query, which is editing the Other Travel Info details
	 * form
	 * 
	 * <pre>
	 * 
	 * </pre>
	 * 
	 * <code>SHOW_LIST_TRAVEL_DETAILS_BY_ID</code>.
	 */
	public static final String SHOW_LIST_TRAVEL_DETAILS_BY_ID = "SELECT * FROM TAB_EXPENSES_MONTHLY_TRAVEL WHERE MONTHLY_CLAIM_ID=?";
	/**
	 * /**
	 * <p>
	 * <code>EDIT_CLAIM_EXPENSES_MONTHLY_DETAILS</code> token is representing
	 * the constants for SQL query, which is editing the Other Travel Info
	 * details form
	 * 
	 * <pre>
	 * 
	 * </pre>
	 * 
	 * <code>EDIT_CLAIM_EXPENSES_MONTHLY_DETAILS</code>.
	 */
	public static final String EDIT_CLAIM_EXPENSES_MONTHLY_DETAILS = "SELECT * FROM TAB_EXPENSES_MONTHLY WHERE MONTHLI_CLAIM_ID=?";

	public static final String VIEW_LIST_Other_DETAILS_BY_ID = "SELECT * FROM TAB_EXPENSES_MONTHLY_OTHER WHERE OTHER_CLAIM_ID=?";

	/**
	 * <p>
	 * <code>GET_LAST_PRODUCT_ID</code>this token is representing the constants
	 * for SQL query, which is fetching PRODUCT DETAILS from database
	 * </p>
	 * 
	 * <pre>
	 *  TAB_PRODUCT_DETAILS,PRODUCT_ID
	 * </pre>
	 * 
	 * from <code>TAB_PRODUCT_DETAILS</code>.
	 */
	public static final String GET_LAST_PRODUCT_ID = "SELECT  PRODUCT_ID FROM TAB_PRODUCT_DETAILS GROUP BY PRODUCT_ID DESC LIMIT 1";
	/**
	 * <p>
	 * <code>SHOW_NEXT_VIEW_PRODUCT</code>this token is representing the
	 * constants for SQL query, which is fetching VIEW PRODUCT from database
	 * </p>
	 * 
	 * <pre>
	 *  TAB_PRODUCT_DETAILS,PRODUCT_ID
	 * </pre>
	 * 
	 * from <code>TAB_PRODUCT_DETAILS</code>.
	 */
	public static final String SHOW_NEXT_VIEW_PRODUCT = "SELECT * FROM TAB_PRODUCT_DETAILS WHERE PRODUCT_ID=?";
	/**
	 * <p>
	 * <code>SHOW_EDIT_PRODUCT_NEXT</code>this token is representing the
	 * constants for SQL query, which is fetching VIEW PRODUCT from database
	 * </p>
	 * 
	 * <pre>
	 *  TAB_PRODUCT_DETAILS,PRODUCT_ID
	 * </pre>
	 * 
	 * from <code>TAB_PRODUCT_DETAILS</code>.
	 */
	public static final String SHOW_EDIT_PRODUCT_NEXT = "SELECT PRODUCT_ID,PRODUCT_NAME,PRODUCT_CODE,PRODUCT_CATEGORY,VENDOR_NAME,"
			+ "MANUFACTURER,SALES_START_DATE,SALES_END_DATE,SUPPORT_START_DATE,SUPPORT_EXPIRY_DATE,SERIAL_NO,MFR_PART_NO,VENDOR_PART_NO,PRODUCT_SHEET,"
			+ "WEBSITE,GL_ACCOUNT,UNIT_PRICE,COMMISION_RATE,TAX,PURCHASE_COST,USAGE_UNIT,QTY_PER_UNIT,QTY_IN_STOCK,REORDER_LAVEL,HANDLER,"
			+ "QTY_IN_DEMAND,PRODUCT_ACTIVE,PRODUCT_IMAGE,DESCRIPTION FROM TAB_PRODUCT_DETAILS WHERE PRODUCT_ID=?";
	/**
	 * <p>
	 * <code>GET_LAST_RECORD_PRODUCT_ID</code>this token is representing the
	 * constants for SQL query, which is fetching VIEW PRODUCT from database
	 * </p>
	 * 
	 * <pre>
	 *  TAB_PRODUCT_DETAILS,PRODUCT_ID
	 * </pre>
	 * 
	 * from <code>TAB_PRODUCT_DETAILS</code>.
	 */
	public static final String GET_LAST_RECORD_PRODUCT_ID = "SELECT  PRODUCT_ID FROM TAB_PRODUCT_DETAILS GROUP BY PRODUCT_ID DESC LIMIT 1";

	/**
	 * <p>
	 * <code>GET_LEAD_STATUS</code>token is representing the constant for SQL
	 * query, which is fetching a lead status
	 * 
	 * 
	 * FROM<code>TAB_LEAD_STATUS</code>
	 * </p>
	 * 
	 */
	public static final String GET_LEAD_STATUS = "SELECT LEAD_STATUS FROM TAB_LEAD_DETAILS";

	/**
	 * <p>
	 * <code>GET_ACCOUNT_STATUS</code> token is representing the constant for
	 * SQL query,which is fetching a account status FROM<code>TAB_ACCOUNT</code>
	 * </p>
	 * 
	 */
	public static final String GET_ACCOUNT_STATUS = "SELECT ACCOUNT_STATUS FROM TAB_ACCOUNT";

	/**
	 * <p>
	 * <code>GET_ACCOUNT_STATUS</code> token is representing the constant for
	 * SQL query,which is fetching a account status FROM<code>TAB_ACCOUNT</code>
	 * </p>
	 * 
	 */
	public static final String GET_CONTACT_STATUS = "SELECT ACCOUNT_STATUS FROM TAB_ACCOUNT";
	/**
	 * <p>
	 * <code>GET_TICKET_STATUS_DETAILS</code> token is representing the constant
	 * for SQL query,which is fetching a TICKET status FROM
	 * <code>TAB_SUPPORT_TICKET</code>
	 * </p>
	 * 
	 */
	public static final String GET_TICKET_STATUS_DETAILS = "SELECT STATUS FROM TAB_SUPPORT_TICKET";
	/**
	 * <p>
	 * <code>GET_CASES_STATUS_DETAILS</code>token is representing the constants
	 * for SQL Qurey ,which is fetching a CASES status FROM
	 * <code>TAB_SUPPORT_CASES</code>
	 * </p>
	 */

	public static final String GET_CASES_STATUS_DETAILS = "SELECT CASES_STATUS FROM TAB_SUPPORT_CASES";

	/**
	 * <p>
	 * <code>GET_ASSIGNMENT_STATUS_DETAILS</code>token is representing the
	 * constants for SQL Query,which is fetching a ASSIGNMENT status FROM
	 * <code>TAB_ASSIGNMENT</code>
	 * </p>
	 */

	public static final String GET_ASSIGNMENT_STATUS_DETAILS = "SELECT ASSIGNMENT_STATUS FROM TAB_ASSIGNMENT ";

	/**
	 * <p>
	 * <code>GET_TRAVEL_MODE</code> token is representing the constants for SQL
	 * query, which is GET TRAVEL_MODE
	 * 
	 * <pre>
	 * 
	 * </pre>
	 * From <code>TAB_TRAVEL_MODE</code>.
	 */
	public static final String GET_TRAVEL_MODE = "SELECT TRAVEL_MODE FROM TAB_TRAVEL_MODE WHERE TRAVEL_MODE_ID=?";

	/**
	 * <p>
	 * <code>GET_MONTHLY_EXPENSES_ID</code> token is representing the constants
	 * for SQL query, which is GET MONTHLI_CLAIM_ID
	 * 
	 * <pre>
	 * 
	 * </pre>
	 * From <code>TAB_EXPENSES_MONTHLY</code>.
	 */
	public static final String GET_MONTHLY_EXPENSES_ID = "SELECT MONTHLI_CLAIM_ID FROM TAB_EXPENSES_MONTHLY WHERE MONTHLY_EXPENSES_REF_NO=?";

	/**
	 * <p>
	 * <code>ADD_MONTHYL_OTHER_CLAIM_ID</code> token is representing the
	 * constants for SQL query, which is SET MONTHLY_CLAIM_ID
	 * 
	 * <pre>
	 * 
	 * </pre>
	 * INTO <code>TAB_EXPENSES_MONTHLY_TRAVEL</code>.
	 */
	public static final String ADD_MONTHYL_OTHER_CLAIM_ID = "UPDATE TAB_EXPENSES_MONTHLY_TRAVEL SET MONTHLY_CLAIM_ID=? WHERE MONTHLY_TRAVEL_REF_NO=?";

	/**
	 * <p>
	 * <code>GET_PRODUCT_NAME</code>token is representing the constant for SQL
	 * query, which is fetching a product status
	 * 
	 * 
	 * FROM<code>TAB_PRODUCT_DETAILS</code>
	 * </p>
	 * 
	 */
	public static final String GET_PRODUCT_NAME = "SELECT PRODUCT_NAME FROM TAB_PRODUCT_DETAILS";

	/**
	 * <p>
	 * <code>ADD_MONTHLY_CLAIM_ID</code> token is representing the constants for
	 * SQL query, which is SET MONTHLY_CLAIM_ID
	 * 
	 * <pre>
	 * 
	 * </pre>
	 * INTO <code>TAB_EXPENSES_MONTHLY_OTHER</code>.
	 * 
	 * 
	 */

	/**
	 * <p>
	 * <code>GET_NOTE_TITLE</code> token is representing the constants for SQL
	 * query, which is Get the Note Title.
	 * 
	 * <pre>
	 * 
	 * </pre>
	 * INTO <code>TAB_NOTE</code>.
	 */
	public static final String GET_NOTE_TITLE = "SELECT NOTE_TITLE FROM TAB_NOTE";

	/**
	 * <p>
	 * <code>GET_CREATED_BY</code> token is representing the constants for SQL
	 * query, which is Get the Created By.
	 * 
	 * <pre>
	 * 
	 * </pre>
	 * INTO <code>TAB_NOTE</code>.
	 * */

	public static final String GET_CREATED_BY = "SELECT CREATED_BY FROM TAB_NOTE";

	/**
	 * <p>
	 * <code>GET_VENDORS_NAME</code> token is representing the constants for SQL
	 * query, which is Get the Vendor Name.
	 * 
	 * <pre>
	 * 
	 * </pre>
	 * INTO <code>TAB_VENDORS</code>.
	 * */

	public static final String GET_VENDORS_NAME = "SELECT VENDOR_NAME FROM TAB_VENDORS";
	/**
	 * <p>
	 * <code>GET_VENDORS_PRIMARY_EMAIL</code> token is representing the
	 * constants for SQL query, which is Get the Vendor Primary Email Id.
	 * 
	 * <pre>
	 * 
	 * </pre>
	 * INTO <code>TAB_VENDORS</code>.
	 * */

	public static final String GET_VENDORS_PRIMARY_EMAIL = "SELECT PRIMARY_EMAIL_ID FROM TAB_VENDORS";

	/**
	 * <p>
	 * <code>GET_VENDORS_PHONE</code> token is representing the constants for
	 * SQL query, which is Get the Vendor Phone No.
	 * 
	 * <pre>
	 * 
	 * </pre>
	 * INTO <code>TAB_VENDORS</code>.
	 * */
	public static final String GET_VENDORS_PHONE = "SELECT PHONE_NO FROM TAB_VENDORS";

	/**
	 * 
	 * <p>
	 * <code>GET_LEAD__SOURCE_DETAILS</code>token is representing the constants
	 * for SQL Query,which is fetching a LEAD_SOURCE from
	 * <code>TAB_LEAD_DETAILS</code>
	 * </p>
	 */
	public static final String GET_LEAD_SOURCE_DETAILS = "SELECT LEAD_SOURCE_REF FROM TAB_LEAD_DETAILS";

	/**
	 * <p>
	 * <code>GET_CAMPAING_NAME</code> token is representing the constants for
	 * SQL query, which is Get the Campaign Name.
	 * 
	 * <pre>
	 * 
	 * </pre>
	 * INTO <code>TAB_CAMPAIGN</code>.
	 * */

	public static final String GET_CAMPAING_NAME = "SELECT CAMPAIGN_NAME FROM TAB_CAMPAIGN";

	/**
	 * <p>
	 * <code>GET_EXPECTED_CLOSE_DATE</code> token is representing the constants
	 * for SQL query, which is Get the Expected Closing Date.
	 * 
	 * <pre>
	 * 
	 * </pre>
	 * INTO <code>TAB_CAMPAIGN</code>.
	 * */

	public static final String GET_EXPECTED_CLOSE_DATE = "SELECT EXPECTED_CLOSE_DATE FROM TAB_CAMPAIGN";

	/**
	 * <p>
	 * <code>GET_EXPECTED_CLOSE_DATE</code> token is representing the constants
	 * for SQL query, which is Get the Expected revenue.
	 * 
	 * <pre>
	 * 
	 * </pre>
	 * INTO <code>TAB_CAMPAIGN</code>.
	 * */

	public static final String GET_EXPECTED_REVENUE = "SELECT EXPECTED_REVENUE FROM TAB_CAMPAIGN";

	/**
	 * <p>
	 * <code>GET_CONTACT_NAME</code>this token is representing the constants for
	 * SQL query, which is fetching
	 * </p>
	 * 
	 * <pre>
	 * CONTACT_PERSON  CONTACT_ID
	 * </pre>
	 * 
	 * from <code>TAB_CONTACT</code>.
	 */

	public static final String GET_CONTACT_NAME = "SELECT CONTACT_PERSON FROM TAB_CONTACT WHERE CONTACT_ID=?";

	/**
	 * <p>
	 * <code>GET_CASES_SLA_NAME</code>this token is representing the constants
	 * for SQL query, which is fetching
	 * </p>
	 * 
	 * <pre>
	 * SLA_NAME  ACCOUNT_ID
	 * </pre>
	 * 
	 * from <code>TAB_ACCOUNT</code>.
	 */

	public static final String GET_CASES_SLA_NAME = "SELECT * FROM TAB_ACCOUNT WHERE ACCOUNT_ID=?";

	/**
	 * <p>
	 * <code>GET_CASES_ORGNIZATION</code>this token is representing the
	 * constants for SQL query, which is fetching
	 * </p>
	 * 
	 * <pre>
	 * COMPANY_NAME  COMPANY_ID
	 * </pre>
	 * 
	 * from <code>TAB_COMPANY_DETAILS</code>.
	 */

	public static final String GET_CASES_ORGNIZATION = "SELECT * FROM TAB_COMPANY_DETAILS WHERE COMPANY_ID=?";

	/**
	 * <p>
	 * <code>GET_CASES_ASSIGNED_TO</code>this token is representing the
	 * constants for SQL query, which is fetching
	 * </p>
	 * 
	 * <pre>
	 * ASSIGNED_TO_NAME  ASSIGNED_TO_ID
	 * </pre>
	 * 
	 * from <code>TAB_CASES_ASSIGNED_TO</code>.
	 */

	public static final String GET_CASES_ASSIGNED_TO = "SELECT ASSIGNED_TO_NAME FROM TAB_CASES_ASSIGNED_TO WHERE ASSIGNED_TO_ID=?";

	/**
	 * <p>
	 * <code>GET_CASES_TEAM</code>this token is representing the constants for
	 * SQL query, which is fetching
	 * </p>
	 * 
	 * <pre>
	 * TEAM_NAME  TEAM_ID
	 * </pre>
	 * 
	 * from <code>TAB_CASES_TEAM</code>.
	 */

	public static final String GET_CASES_TEAM = "SELECT TEAM_NAME FROM TAB_CASES_TEAM WHERE "
			+ "TEAM_ID=?";

	/**
	 * <p>
	 * <code>GET_TICKET_PRODUCT_NAME</code>this token is representing the
	 * constants for SQL query, which is fetching
	 * </p>
	 * 
	 * <pre>
	 * PRODUCT_NAME  PRODUCT_ID
	 * </pre>
	 * 
	 * from <code>TAB_PRODUCT</code>.
	 */

	public static final String GET_TICKET_PRODUCT_NAME = "SELECT PRODUCT_NAME FROM TAB_PRODUCT_DETAILS WHERE PRODUCT_ID=?";

	/**
	 * <p>
	 * <code>GET_CHANNEL</code>this token is representing the constants for SQL
	 * query, which is fetching
	 * </p>
	 * 
	 * <pre>
	 * CHANNEL_NAME  CHANNEL_ID
	 * </pre>
	 * 
	 * from <code>TAB_CASES_CHANNEL</code>.
	 */

	public static final String GET_CHANNEL = "SELECT CHANNEL_NAME FROM TAB_CASES_CHANNEL WHERE "
			+ "CHANNEL_ID=?";

	/**
	 * <p>
	 * <code>GET_CASES_IMPACT_TYPE</code>this token is representing the
	 * constants for SQL query, which is fetching
	 * </p>
	 * 
	 * <pre>
	 * IMPACT_TYPE_NAME  IMPACT_TYPE_ID
	 * </pre>
	 * 
	 * from <code>TAB_CASES_IMPACT_TYPE</code>.
	 */

	public static final String GET_CASES_IMPACT_TYPE = "SELECT IMPACT_TYPE_NAME FROM TAB_CASES_IMPACT_TYPE WHERE "
			+ "IMPACT_TYPE_ID=?";

	/**
	 * <p>
	 * <code>GET_CASES_RESOLUTION_TYPE</code>this token is representing the
	 * constants for SQL query, which is fetching
	 * </p>
	 * 
	 * <pre>
	 * RESOLUTION_TYPE_NAME  RESOLUTION_TYPE_ID
	 * </pre>
	 * 
	 * from <code>TAB_CASES_RESOLUTION_TYPE</code>.
	 */

	public static final String GET_CASES_RESOLUTION_TYPE = "SELECT RESOLUTION_TYPE_NAME FROM TAB_CASES_RESOLUTION_TYPE"
			+ " WHERE RESOLUTION_TYPE_ID=?";

	/**
	 * <p>
	 * <code>VIEW_PRODUCT_XLS_REPORT</code> token is representing the constants
	 * for SQL query, which is Get the Expected revenue.
	 * 
	 * <pre>
	 * 
	 * </pre>
	 * INTO <code>TAB_PRODUCT_DETAILS</code>.
	 * */

	public static final String VIEW_PRODUCT_XLS_REPORT = "SELECT * FROM TAB_PRODUCT_DETAILS";

	/**
	 * <p>
	 * <code>VIEW_ACTION_XLS_REPORT</code> token is representing the constants
	 * for SQL query, which is fetching
	 * 
	 * <pre>
	 * ALL Records
	 * </pre>
	 * 
	 * from <code>TAB_ACCOUNT</code> .
	 */
	public static final String VIEW_ACCOUNT_XLS_REPORT = "SELECT * FROM TAB_ACCOUNT";
	
	
	
	/**
	 * <p>
	 * <code>VIEW_CAMPAIGN_XLS_REPORT </code> token is representing the constants for
	 * SQL query, which is fetching
	 * 
	 * <pre>
	 * ALL Records
	 * </pre>
	 * 
	 * from <code>TAB_CAMPAIGN</code> .
	 */
	public static final String VIEW_CAMPAIGN_XLS_REPORT = "SELECT * FROM TAB_CAMPAIGN";
	
	
	
	/**
	 * <p>
	 * <code>SHOW_PRODUCT_PRINT_PDF</code> token is representing the
	 * constants for SQL query, which is Get the Expected revenue.
	 * 
	 * <pre>
	 * 
	 * </pre>
	 * INTO <code>TAB_PRODUCT_DETAILS</code>.
	 * */
	public static final String SHOW_PRODUCT_PRINT_PDF = "SELECT * FROM TAB_PRODUCT_DETAILS WHERE PRODUCT_ID=?";
	

	/**
	 * <p>
	 * <code>GET_NOTE_CREATED_BY_NAME</code> token is representing the constants
	 * for SQL query, which is Get the Created By Name.
	 * 
	 * <pre>
	 * 
	 * </pre>
	 * INTO <code>TAB_CUSTOMER_USER</code>.
	 * */
	public static final String GET_NOTE_CREATED_BY_NAME = "SELECT FULL_NAME FROM TAB_CUSTOMER_USER WHERE CREATED_BY=?";

	public static final String ADD_MONTHLY_CLAIM_ID = "UPDATE TAB_EXPENSES_MONTHLY_OTHER SET MONTHLY_CLAIM_ID=? WHERE MONTHLY_OTHER_REF_NO=?";

	public static final String GET_LAST_MONTHLY_CLAIM__ID = "SELECT  MONTHLI_CLAIM_ID FROM TAB_EXPENSES_MONTHLY GROUP BY MONTHLI_CLAIM_ID DESC LIMIT 1";

	public static final String GET_LAST_CLAIM__ID = "SELECT  CLAIM_ID FROM TAB_EXPENSES GROUP BY CLAIM_ID DESC LIMIT 1";
	
	/**
	 * <p>
	 * <code>GET_LEAD_CREATED_BY</code>token is representing the constants for
	 * SQL Query,which is fetching a CREATED_BY from
	 * <code>TAB_LEAD_DETAILS</code>
	 * </p>
	 */

	public static final String GET_LEAD_CREATED_BY = "SELECT DISTINCT a.FULL_NAME,a.DESIGNATION, b.CREATED_BY FROM TAB_LEAD_DETAILS b,TAB_CUSTOMER_USER a WHERE a.CUSTOMER_ID = b.CREATED_BY";
	
/**
	 * <p>
	 * <code>GET_LEAD_BY_INDUSTRY</code>token is representing the constants for
	 * SQL Query,which is fetching a
	 * COMPANY_CATEGORY_NAME,COMPANY_CATEGORY_ID,COMPANY_CATEGORY_REF from\
	 * <code>TAB_LEAD_DETAILS, TAB_COMPANY_CATEGORY</code>
	 * </p>
	 */

	public static final String GET_LEAD_BY_INDUSTRY = "SELECT DISTINCT A.COMPANY_CATEGORY_NAME,B.COMPANY_CATEGORY_REF FROM TAB_COMPANY_CATEGORY A,TAB_LEAD_DETAILS B WHERE A.COMPANY_CATEGORY_ID=B.COMPANY_CATEGORY_REF";


	/**
	 * <p>
	 * <code>GET_CONTACTS_EDIT</code> token is representing the constants for
	 * SQL query, which is used to fetch records from <code>TAB_CONTACT</code> .
	 */
	public static final String GET_CONTACTS_EDIT = "SELECT CONTACT_ID,SALUTATION,CONTACT_PERSON,NICK_NAME,DESIGNATION_REF," +
			"PHONE_NUMBER,PHONE_NUMBER_ISD,PHONE_NUMBER_STD,REFERRED_BY,DEPARTMENT,REPORTS_TO,REFERENCE,LEAD_SOURCE_REF,ASSIGN_TO," +
			"DO_NOT_CALL,NOTIFY_OWNER,EMAIL_OPT_OUT,SLA_NAME,CUSTOMER_CENTER_USER,SUPPORT_START_DATE,SUPPORT_END_DATE,MOBILE_NUMBER1," +
			"MOBILE_NUMBER1_ISD,MOBILE_NUMBER2,MOBILE_NUMBER2_ISD,EMAIL_ID,FAX,FAX_ISD,FAX_STD,HOME_CONTACT_ADDRESS_LINE1," +
			"HOME_CONTACT_ADDRESS_LINE2,HOME_CONTACT_CITY,HOME_CONTACT_STATE,HOME_CONTACT_COUNTRY_REF,HOME_CONTACT_ZIPCODE," +
			"HOME_CONTACT_PHONE_NUMBER,HOME_CONTACT_PHONE_NUMBER_ISD,HOME_CONTACT_PHONE_NUMBER_STD,HOME_CONTACT_MOBILE_NUMBER," +
			"HOME_CONTACT_MOBILE_NUMBER_ISD,HOME_CONTACT_EMAIL_ID,HOME_CONTACT_ALTERNATE_EMAIL_ID,HOME_CONTACT_FAX_NUMBER," +
			"HOME_CONTACT_FAX_NUMBER_ISD,HOME_CONTACT_FAX_NUMBER_STD,HOME_WEBSITE,WORK_CONTACT_ADDRESS_LINE1,WORK_CONTACT_ADDRESS_LINE2," +
			"WORK_CONTACT_CITY,WORK_CONTACT_STATE,WORK_CONTACT_COUNTRY_REF,WORK_CONTACT_ZIPCODE,WORK_CONTACT_PHONE_NUMBER," +
			"WORK_CONTACT_PHONE_NUMBER_ISD,WORK_CONTACT_PHONE_NUMBER_STD,WORK_CONTACT_MOBILE_NUMBER,WORK_CONTACT_MOBILE_NUMBER_ISD," +
			"WORK_CONTACT_EMAIL_ID,WORK_CONTACT_ALTERNATE_EMAIL_ID,WORK_CONTACT_FAX_NUMBER,WORK_CONTACT_FAX_NUMBER_ISD," +
			"WORK_CONTACT_FAX_NUMBER_STD,WORK_WEBSITE,PROFILE_DESCRIPTION,REFERANCE_ID,CREATED_DATE,CREATED_BY,TITTLE,DATE_OF_BIRTH," +
			"STATUS FROM TAB_CONTACT WHERE CONTACT_ID=?";

	/**
	 * <p>
	 * <code>GET_CONTACTS_DETAILS</code>this token is representing the constants
	 * for SQL query, which is fetching
	 * </p>
	 * 
	 * <pre>
	 * GET_CONTACTS_DETAILS
	 * </pre>
	 * 
	 * from <code>TAB_CONTACT</code>.
	 */
	public static final String GET_CONTACTS_DETAILS = "SELECT CONTACT_ID,SALUTATION,CONTACT_PERSON,NICK_NAME,DESIGNATION_REF," +
			"PHONE_NUMBER,REFERRED_BY,DEPARTMENT,REPORTS_TO,REFERENCE,LEAD_SOURCE_REF,ASSIGN_TO," +
			"DO_NOT_CALL,NOTIFY_OWNER,EMAIL_OPT_OUT,SLA_NAME,CUSTOMER_CENTER_USER,MOBILE_NUMBER1," +
			"MOBILE_NUMBER1_ISD,MOBILE_NUMBER2,MOBILE_NUMBER2_ISD,EMAIL_ID,FAX,FAX_ISD,FAX_STD,HOME_CONTACT_ADDRESS_LINE1," +
			"HOME_CONTACT_ADDRESS_LINE2,HOME_CONTACT_CITY,HOME_CONTACT_STATE,HOME_CONTACT_COUNTRY_REF,HOME_CONTACT_ZIPCODE," +
			"HOME_CONTACT_PHONE_NUMBER,HOME_CONTACT_PHONE_NUMBER_ISD,HOME_CONTACT_PHONE_NUMBER_STD,HOME_CONTACT_MOBILE_NUMBER," +
			"HOME_CONTACT_MOBILE_NUMBER_ISD,HOME_CONTACT_EMAIL_ID,HOME_CONTACT_ALTERNATE_EMAIL_ID,HOME_CONTACT_FAX_NUMBER," +
			"HOME_CONTACT_FAX_NUMBER_ISD,HOME_CONTACT_FAX_NUMBER_STD,HOME_WEBSITE,WORK_CONTACT_ADDRESS_LINE1,WORK_CONTACT_ADDRESS_LINE2," +
			"WORK_CONTACT_CITY,WORK_CONTACT_STATE,WORK_CONTACT_COUNTRY_REF,WORK_CONTACT_ZIPCODE,WORK_CONTACT_PHONE_NUMBER," +
			"WORK_CONTACT_PHONE_NUMBER_ISD,WORK_CONTACT_PHONE_NUMBER_STD,WORK_CONTACT_MOBILE_NUMBER,WORK_CONTACT_MOBILE_NUMBER_ISD," +
			"WORK_CONTACT_EMAIL_ID,WORK_CONTACT_ALTERNATE_EMAIL_ID,WORK_CONTACT_FAX_NUMBER,WORK_CONTACT_FAX_NUMBER_ISD," +
			"WORK_CONTACT_FAX_NUMBER_STD,WORK_WEBSITE,PROFILE_DESCRIPTION,REFERANCE_ID,CREATED_DATE,CREATED_BY,TITTLE,DATE_OF_BIRTH," +
			"STATUS FROM TAB_CONTACT  WHERE CONTACT_ID=?";
	
	/**
	 * <p>
	 * <code>UPDATE_CONTACTS_DETAILS</code> token is representing the constants for
	 * SQL query, which is used to fetch records from <code>TAB_CONTACT</code> .
	 */
	public static final String UPDATE_CONTACTS_DETAILS = "UPDATE TAB_CONTACT SET SALUTATION=?,ACCOUNT_NAME=?,DESIGNATION_REF=?,NICK_NAME=?," +
			"PHONE_NUMBER=?,PHONE_NUMBER_ISD=?,PHONE_NUMBER_STD=?,REFERRED_BY=?,MOBILE_NUMBER1=?,MOBILE_NUMBER1_ISD=?,EMAIL_ID=?,TITTLE=?,DEPARTMENT=?," +
			"REPORTS_TO=?,REFERENCE=?,REFERANCE_ID=?,ASSIGN_TO=?," +
			"DO_NOT_CALL=?,NOTIFY_OWNER=?,EMAIL_OPT_OUT=?,SLA_NAME=?,HOME_CONTACT_ADDRESS_LINE1=?,HOME_CONTACT_ADDRESS_LINE2=?,HOME_CONTACT_CITY=?," +
			"HOME_CONTACT_STATE=?,HOME_CONTACT_COUNTRY_REF=?,HOME_CONTACT_ZIPCODE=?,HOME_CONTACT_PHONE_NUMBER=?,HOME_CONTACT_PHONE_NUMBER_ISD=?," +
			"HOME_CONTACT_PHONE_NUMBER_STD=?,HOME_CONTACT_MOBILE_NUMBER=?," +
			"HOME_CONTACT_MOBILE_NUMBER_ISD=?,HOME_CONTACT_EMAIL_ID=?,HOME_CONTACT_FAX_NUMBER=?," +
			"HOME_CONTACT_FAX_NUMBER_ISD=?,HOME_CONTACT_FAX_NUMBER_STD=?,WORK_CONTACT_ADDRESS_LINE1=?,WORK_CONTACT_ADDRESS_LINE2=?," +
			"WORK_CONTACT_CITY=?,WORK_CONTACT_STATE=?,WORK_CONTACT_COUNTRY_REF=?,WORK_CONTACT_ZIPCODE=?,WORK_CONTACT_PHONE_NUMBER=?," +
			"WORK_CONTACT_PHONE_NUMBER_ISD=?,WORK_CONTACT_PHONE_NUMBER_STD=?,WORK_CONTACT_MOBILE_NUMBER=?,WORK_CONTACT_MOBILE_NUMBER_ISD=?," +
			"WORK_CONTACT_EMAIL_ID=?,WORK_CONTACT_FAX_NUMBER=?,WORK_CONTACT_FAX_NUMBER_ISD=?," +
			"WORK_CONTACT_FAX_NUMBER_STD=?,PROFILE_DESCRIPTION=?,CREATED_DATE=?,CREATED_BY=?,CONTACT_PERSON=?,LEAD_SOURCE_REF=?,HOME_CONTACT_ALTERNATE_EMAIL_ID=?," +
			"HOME_WEBSITE=?,WORK_WEBSITE=?,STATUS=?,CUSTOMER_CENTER_USER=?,SUPPORT_START_DATE=?,SUPPORT_END_DATE=?,MOBILE_NUMBER2=?,MOBILE_NUMBER2_ISD=?," +
			"FAX=?,FAX_ISD=?,FAX_STD=?,WORK_CONTACT_ALTERNATE_EMAIL_ID=?,DATE_OF_BIRTH=? WHERE CONTACT_ID=?";
	
	
	/**
	 * <p>
	 * <code>SHOW_SUPPORT_CASES_PRINT_PDF</code> token is representing the
	 * constants for SQL query, which is Get the Expected revenue.
	 * 
	 * <pre>
	 * 
	 * </pre>
	 * INTO <code>TAB_PRODUCT_DETAILS</code>.
	 * */
	public static final String SHOW_SUPPORT_CASES_PRINT_PDF = "SELECT * FROM TAB_SUPPORT_CASES WHERE CASES_ID=?";




/**
	 * <p>
	 * <code>VIEW_CASES_XLS_REPORT</code> token is representing the
	 * constants for SQL query, which is Get the Expected revenue.
	 * 
	 * <pre>
	 * 
	 * </pre>
	 * INTO <code>TAB_SUPPORT_CASES</code>.
	 * */
	public static final String VIEW_CASES_XLS_REPORT = "SELECT * FROM TAB_SUPPORT_CASES";
	
	
	
	/**
	 * <p>
	 * <code>VIEW_ASSIGNMENT_XLS_REPORT</code> token is representing the
	 * constants for SQL query, which is Get the Assig.
	 * 
	 * <pre>
	 * 
	 * </pre>
	 * INTO <code>TAB_VENDORS</code>.
	 * */

	public static final String VIEW_ASSIGNMENT_XLS_REPORT ="SELECT * FROM TAB_ASSIGNMENT";
	
	
	/**
	 * <p>
	 * <code>SHOW_ASSIGNMENT_PRINT_PDF</code> token is representing the
	 * constants for SQL query, which is Get the Assig.
	 * 
	 * <pre>
	 * 
	 * </pre>
	 * INTO <code>TAB_ASSIGNMENT</code>.
	 * */
	public static final String SHOW_ASSIGNMENT_PRINT_PDF ="SELECT * FROM TAB_ASSIGNMENT WHERE ASSIGNMENT_ID=?";
	
	

	public static final String GET_REPORTS_TO_LIST = "SELECT CUSTOMER_ID,FULL_NAME FROM TAB_CUSTOMER_USER";

	public static final String GET_CONTACT_DETAILS = "SELECT * FROM TAB_CONTACT";
	
	/**
	 * <p>
	 * <code>VIEW_FAQ_XLS_REPORT</code> token is representing the
	 * constants for SQL query, which is Get the Expected revenue.
	 * 
	 * <pre>
	 * 
	 * </pre>
	 * INTO <code>TAB_SUPPORT_FAQ</code>.
	 * */
	public static final String VIEW_FAQ_XLS_REPORT = "SELECT * FROM TAB_SUPPORT_FAQ";
	/**
	 * <p>
	 * <code>SHOW_FAQ_PRINT_PDF</code> token is representing the
	 * constants for SQL query, which is Get the Expected revenue.
	 * 
	 * <pre>
	 * 
	 * </pre>
	 * INTO <code>TAB_SUPPORT_FAQ</code>.
	 * */
	public static final String SHOW_FAQ_PRINT_PDF = "SELECT * FROM TAB_SUPPORT_FAQ WHERE FAQ_ID=?";
	
	
	/**
	 * <p>
	 * <code>VIEW_CONTACTS_XLS_REPORT</code> token is representing the constants for
	 * SQL query, which is used to generate XLS report from <code>TAB_CONTACT</code> .
	 */
	public static final String VIEW_CONTACTS_XLS_REPORT = "SELECT * FROM TAB_CONTACT";






/**
	 * <p>
	 * <code>SHOW_CONTACTS_PRINT_PDF</code> token is representing the constants for
	 * SQL query, which is used to generate XLS report from <code>TAB_CONTACT</code> .
	 */
	public static final String SHOW_CONTACTS_PRINT_PDF = "SELECT * FROM TAB_CONTACT WHERE CONTACT_ID=?";







public static final String GET_CONTACTS_LAST_RECORD_ID = "SELECT  CONTACT_ID FROM TAB_CONTACT GROUP BY CONTACT_ID DESC LIMIT 1";






public static final String SHOW_VIEW_CONTACTS = "SELECT CONTACT_ID,SALUTATION,CONTACT_PERSON,NICK_NAME,DESIGNATION_REF," +
			"PHONE_NUMBER,REFERRED_BY,DEPARTMENT,REPORTS_TO,REFERENCE,LEAD_SOURCE_REF,ASSIGN_TO," +
			"DO_NOT_CALL,NOTIFY_OWNER,EMAIL_OPT_OUT,SLA_NAME,CUSTOMER_CENTER_USER,MOBILE_NUMBER1," +
			"MOBILE_NUMBER1_ISD,MOBILE_NUMBER2,MOBILE_NUMBER2_ISD,EMAIL_ID,FAX,FAX_ISD,FAX_STD,HOME_CONTACT_ADDRESS_LINE1," +
			"HOME_CONTACT_ADDRESS_LINE2,HOME_CONTACT_CITY,HOME_CONTACT_STATE,HOME_CONTACT_COUNTRY_REF,HOME_CONTACT_ZIPCODE," +
			"HOME_CONTACT_PHONE_NUMBER,HOME_CONTACT_PHONE_NUMBER_ISD,HOME_CONTACT_PHONE_NUMBER_STD,HOME_CONTACT_MOBILE_NUMBER," +
			"HOME_CONTACT_MOBILE_NUMBER_ISD,HOME_CONTACT_EMAIL_ID,HOME_CONTACT_ALTERNATE_EMAIL_ID,HOME_CONTACT_FAX_NUMBER," +
			"HOME_CONTACT_FAX_NUMBER_ISD,HOME_CONTACT_FAX_NUMBER_STD,HOME_WEBSITE,WORK_CONTACT_ADDRESS_LINE1,WORK_CONTACT_ADDRESS_LINE2," +
			"WORK_CONTACT_CITY,WORK_CONTACT_STATE,WORK_CONTACT_COUNTRY_REF,WORK_CONTACT_ZIPCODE,WORK_CONTACT_PHONE_NUMBER," +
			"WORK_CONTACT_PHONE_NUMBER_ISD,WORK_CONTACT_PHONE_NUMBER_STD,WORK_CONTACT_MOBILE_NUMBER,WORK_CONTACT_MOBILE_NUMBER_ISD," +
			"WORK_CONTACT_EMAIL_ID,WORK_CONTACT_ALTERNATE_EMAIL_ID,WORK_CONTACT_FAX_NUMBER,WORK_CONTACT_FAX_NUMBER_ISD," +
			"WORK_CONTACT_FAX_NUMBER_STD,WORK_WEBSITE,PROFILE_DESCRIPTION,REFERANCE_ID,CREATED_DATE,CREATED_BY,TITTLE,DATE_OF_BIRTH," +
			"STATUS FROM TAB_CONTACT  WHERE CONTACT_ID=?";
	







/**
 * <p>
 * <code>VIEW_TICKET_XLS_REPORT</code> token is representing the
 * constants for SQL query, which is Get the Expected revenue.
 * 
 * <pre>
 * 
 * </pre>
 * INTO <code>TAB_SUPPORT_TICKET</code>.
 * */
public static final String VIEW_TICKET_XLS_REPORT = "SELECT * FROM TAB_SUPPORT_TICKET";
/**
 * <p>
 * <code>SHOW_TICKET_PRINT_PDF</code> token is representing the
 * constants for SQL query, which is Get the Expected revenue.
 * 
 * <pre>
 * 
 * </pre>
 * INTO <code>TAB_SUPPORT_TICKET</code>.
 * */
public static final String SHOW_TICKET_PRINT_PDF = "SELECT * FROM TAB_SUPPORT_TICKET WHERE TICKET_ID=?";
/**
 * <p>
 * <code>INSERT_PRODUCT_NAME</code> token is representing the
 * constants for SQL query, which is Get the Expected revenue.
 * 
 * <pre>
 * 
 * </pre>
 * INTO <code>TAB_PRODUCT_DETAILS</code>.
 * */
public static final String INSERT_PRODUCT_NAME = "INSERT INTO TAB_PRODUCT_DETAILS(PRODUCT_NAME)VALUES(?)";
/**
 * <p>
 * <code>SHOW_LIST_PRODUCT_NAME</code> token is representing the
 * constants for SQL query, which is Get the Expected revenue.
 * 
 * <pre>
 * 
 * </pre>
 * INTO <code>TAB_PRODUCT_DETAILS</code>.
 * */
public static final String SHOW_LIST_PRODUCT_NAME = "SELECT PRODUCT_NAME FROM TAB_PRODUCT_DETAILS";
/**
 * <p>
 * <code>GET_PRODUCT_NAME_DATA</code> token is representing the
 * constants for SQL query, which is Get the Expected revenue.
 * 
 * <pre>
 * 
 * </pre>
 * INTO <code>TAB_PRODUCT_DETAILS</code>.
 * */
public static final String GET_PRODUCT_NAME_DATA = "SELECT PRODUCT_NAME FROM TAB_PRODUCT_DETAILS "
		+ "WHERE PRODUCT_NAME=?";
/**
 * <p>
 * <code>SHOW_LIST_CONTACT_NAME</code> token is representing the
 * constants for SQL query, which is Get the Expected revenue.
 * 
 * <pre>
 * 
 * </pre>
 * INTO <code>TAB_CONTACT</code>.
 * */
public static final String SHOW_LIST_CONTACT_NAME = "SELECT CONTACT_PERSON FROM TAB_CONTACT";
/**
 * <p>
 * <code>INSERT_CONTACT_NAME</code> token is representing the
 * constants for SQL query, which is Get the Expected revenue.
 * 
 * <pre>
 * 
 * </pre>
 * INTO <code>TAB_CONTACT</code>.
 * */
public static final String INSERT_CONTACT_NAME = "INSERT INTO TAB_CONTACT(CONTACT_PERSON)VALUES(?)";
/**
 * <p>
 * <code>SHOW_LIST_ORGANIZATION_NAME</code> token is representing the
 * constants for SQL query, which is Get the Expected revenue.
 * 
 * <pre>
 * 
 * </pre>
 * INTO <code>TAB_COMPANY_DETAILS</code>.
 * */
public static final String SHOW_LIST_ORGANIZATION_NAME = "SELECT COMPANY_NAME FROM TAB_COMPANY_DETAILS";
/**
 * <p>
 * <code>INSERT_ORGANIZATION_NAME</code> token is representing the
 * constants for SQL query, which is Get the Expected revenue.
 * 
 * <pre>
 * 
 * </pre>
 * INTO <code>TAB_COMPANY_DETAILS</code>.
 * */
public static final String INSERT_ORGANIZATION_NAME = "INSERT INTO TAB_COMPANY_DETAILS(COMPANY_NAME)VALUES(?)";


/**
 * <p>
 * <code>UPDATE_CUSTOMER_ACCOUNT_INFORMATION</code> token is representing
 * the constants for SQL query, which is updating Customer account
 * information in <code>TAB_CUSTOMER_USER</code>table.
 */
public static final String UPDATE_CUSTOMER_ACCOUNT_INFORMATION = "UPDATE TAB_CUSTOMER_USER SET "
		+ "SALUTATION=?, FULL_NAME=?, DATE_OF_BIRTH=?, GENDER=?, ALTERNATE_EMAIL_ID=?,"
		+ "WORK_LOCATION=?, ADDRESS_LINE_1=?, ADDRESS_LINE_2=?, CITY=?, STATE=?, REF_COUNTRY=?, ZIPCODE=?, "
		+ "PHONE_NO=?,MOBILE_NO=?,FAX_NO=?, WEBSITE=?,PROFILE_IMAGE_PATH=? WHERE CUSTOMER_ID=?";


/**
* <p>
* <code>SELECT_FULL_NAME</code> token is representing the constants
* for SQL query, which is Get customer fullName.
* 
* <pre>
* 
* </pre>
* INTO <code>TAB_CUSTOMER_USER</code>.
* */
public static final String SELECT_FULL_NAME = "SELECT FULL_NAME FROM TAB_CUSTOMER_USER   WHERE CUSTOMER_ID=?";


/**
 * <p>
 * <code>GET_CASES_TITLE_NAME</code> token is representing the
 * constants for SQL query, which is Get the Expected revenue.
 * 
 * <pre>
 * 
 * </pre>
 * INTO <code>TAB_SUPPORT_CASES</code>.
 * */
public static final String GET_CASES_TITLE_NAME = "SELECT CASES_TITLE FROM TAB_SUPPORT_CASES";



public static final String VIEW_EXPENSES_MONTHLY_XLS_REPORT = "SELECT * FROM TAB_EXPENSES_MONTHLY";


public static final String DELETE_CUSTOMER_DETAILS = "DELETE  FROM TAB_SOCIAL_CONTACT WHERE SOCIAL_CONTACT_ID = ?";

public static final String INSERT_LEAD_GRID_HEADER = "INSERT INTO TAB_COLUMN_MAPER(MODULE_ID,MODULE_NAME,FIELD_LIST)VALUES(?,?,(?))";

public static final String GET_MODULE_LIST = "SELECT MODULE_ID,FIELD_LIST FROM TAB_COLUMN_MAPER";

public static final String GET_ALL_LEAD_DETAILS = "SELECT LEAD_ID,LEAD_OWNER_REF,CREATED_DATE,COMPANY_NAME,SALUTATION,CONTACT_PERSON,"
			+ "LEAD_TITLE_REF,LEAD_SOURCE_REF,COMPANY_TYPE_REF,COMPANY_CATEGORY_REF,COMPANY_SECTOR_REF,LEAD_SOURCE_REF,"
			+ "LEAD_STATUS,LEAD_SOURCE_NAME,NUMBER_OF_ASSOCIATE,ANNUAL_REVENUE,LEAD_DATE,EXPECTED_CLOSING_DATE,RATING,EMAIL_OPT_OUT,"
			+ "ADDRESS_LINE_1,ADDRESS_LINE_2,CITY,STATE,COUNTRY_REF,ZIPCODE,PHONE_ISD,PHONE_STD,PHONE_NO,MOBILE_ISD,"
			+ "MOBILE_NO,PRIMARY_EMAIL_ID,ALTERNATIVE_EMAIL_ID,FAX_ISD,FAX_STD,FAX_NO,WEBSITE,"
			+ "REQUIRMENT,CREATED_BY FROM TAB_LEAD_DETAILS";


/**
 * <p>
 * <code>ADD_ESTIMATE_DETAILS</code> token is representing the constants for
 * SQL query, which is fetching records from
 * <code>TAB_ESTIMATE_DETAILS</code> .
 */

public static final String ADD_ESTIMATE_DETAILS = "INSERT INTO TAB_ESTIMATE_DETAILS(ESTIMATE_NUMBER,ESTIMATE_DATE,REF_CURRENCY_ID,REF_CLIENT_ID,"
		+ "ESTIMATE_REFNO,ESTIMATE_SCANCOPY,SUBTOTAL,TOTALTAX,TOTAL,DISCOUNT,"
		+ "NETTOTAL,CREATED_BY,CREATED_DATE,UNIQUE_ID"
		+ ") "
		+ "VALUE(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";


public static final String ADD_ESTIMATE_ITEMS = "INSERT INTO TAB_ESTIMATE_ITEMS(ITEM_ID,DESCRIPTION,QUANTITY,PRICE,TAX,AMOUNT,REF_ESTIMATE_ID) VALUES (?,?,?,?,?,?,?)";
	

public static final String GET_ESTIMATE_ID = "SELECT ESTIMATE_ID FROM TAB_ESTIMATE_DETAILS WHERE UNIQUE_ID=? ";

/**
 * <p>
 * <code>GET_LANGUAGE_LIST</code> token is representing the constants for
 * SQL query, which is fetching records from <code>TAB_LANGUAGE</code> .
 */
public static final String GET_COUNTRY_CODE = "SELECT COUNTRY_CODE FROM TAB_COUNTRY WHERE COUNTRY_ID=?";


/**
 * <p>
 * <code>GET_COUNTRY_ID</code> token is representing the constants for SQL
 * query, which is fetching records from <code>TAB_USER_DETAILS</code> .
 */
public static final String GET_COUNTRY_ID = "SELECT REF_COUNTRY FROM TAB_CUSTOMER_USER WHERE CUSTOMER_ID=?";

/**
 * <p>
 * <code>GET_CLIENT_LIST</code> token is representing the constants for
 * SQL query, which is fetching records from <code>CLIENT_DETAILS</code> .
 */
public static final String GET_CLIENT_LIST = "SELECT CLIENT_ID,FIRST_NAME,LAST_NAME FROM TAB_CLIENT_DETAILS";

/**
 * <p>
 * <code>GET_TAX_LIST</code> token is representing the constants for
 * SQL query, which is fetching records from <code>TAB_TAX</code> .
 */
public static final String GET_TAX_LIST = "SELECT TAX_ID,TAX_TOTAL,TAX_DISPLAY_NAME FROM TAB_TAX";


public static final String GET_ITEM_DESC_AND_PRICE_LIST = "SELECT DESCRIPTION,UNIT_PRICE FROM TAB_PRODUCT_DETAILS WHERE PRODUCT_ID=?";

public static final String GET_ITEM_DROP_DOWN = "SELECT  PRODUCT_ID,PRODUCT_NAME FROM TAB_PRODUCT_DETAILS";

/**
 * <p>
 * <code>GET_CLIENT_NAME</code> token is representing the constants for SQL
 * query, which is fetching records from <code>CLIENT_DETAILS</code> .
 */
public static final String GET_CLIENT_NAME = "SELECT FIRST_NAME,LAST_NAME FROM TAB_CLIENT_DETAILS WHERE CLIENT_ID=?";


/**
 * <p>
 * <code>GET_ESTIMATE_DETAILS_GRID</code> token is representing the
 * constants for SQL query, which is fetching records from
 * <code>TAB_ESTIMATE_DETAILS</code> .
 */
public static final String GET_ESTIMATE_DETAILS_GRID = "SELECT * FROM TAB_ESTIMATE_DETAILS";

public static final String GET_ESTIMATE_DETAILS = "SELECT * FROM TAB_ESTIMATE_DETAILS WHERE ESTIMATE_ID = ?";



public static final String GET_ESTIMATE_ITEMS_DETAILS = "SELECT * FROM TAB_ESTIMATE_ITEMS WHERE REF_ESTIMATE_ID = ? ";


public static final String DELETE_ESTIMATE_DETAILS= "DELETE FROM TAB_ESTIMATE_DETAILS WHERE ESTIMATE_ID=? ";



public static final String GET_REG_CUSTOMER_LIST = "SELECT REG_CUSTOMER_ID,REG_FULL_NAME FROM TAB_REGULAR_CUSTOMER WHERE REG_CUSTOMER_STATUS='ACTIVE'";


public static final String GET_CONSUMER_CUSTOMER_LIST = "SELECT CON_CUSTOMER_ID,CON_FULL_NAME FROM TAB_CONSUMER_CUSTOMER WHERE CON_CUSTOMER_STATUS='ACTIVE'";

public static final String GET_CUSTOMER_ADDRESS_PHONE_LIST = "SELECT  REG_CITY, REG_PHONE_NO, REG_STATE FROM TAB_REGULAR_CUSTOMER WHERE REG_CUSTOMER_ID=?";



public static final String GET_CONSUMER_ADDRESS_PHONE_LIST = "SELECT  * FROM TAB_CONSUMER_CUSTOMER WHERE CON_CUSTOMER_ID=?";
/*public static final String ADD_SALES_DETAIL="INSERT INTO TAB_SALES_DETAILS(SALES_CUSTOMER_FULLNAME,SALES_CUSTOMER_ADREESS, SALES_CUSTOMER_PHONE, SALES_ITEM_DISCRIPTION, SALES_ITEM_ID, SALES_ITEM_PRICE, " +
		"SALES_ITEM_QUANTITY,SALES_ITEM_TAX,SALES_ITEM_DISCOUNT, SALES_DATE, SALES_ITEM_AMOUNT, SALES_ITEM_TOTAL, SALES_ITEM_NET_TOTAL,SALES_CUSTOMER_ID_REF)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";*/

public static final String GET_REGULAR_CUSTOMER_NAME_BY_ID = "SELECT REG_FULL_NAME FROM TAB_REGULAR_CUSTOMER WHERE REG_CUSTOMER_ID=?";


public static final String SHOW_SALES_DETAILS="SELECT * FROM TAB_SALES_DETAILS WHERE SHOP_ID=?";

public static final String SHOW_SALES_DETAILS_FOR_ADMIN="SELECT * FROM TAB_SALES_DETAILS";


public static final String SHOW_VIEW_SALES_SPECIFIC="SELECT * FROM TAB_SALES_DETAILS WHERE SALES_ID=? AND SHOP_ID=?";





public static final String SHOW_VIEW_SALES_SPECIFIC_FOR_ADMIN="SELECT * FROM TAB_SALES_DETAILS WHERE SALES_ID=?";

public static final String GET_PRODUCT_NAME_BY_ID = "SELECT PRODUCT_NAME FROM TAB_PRODUCT_DETAILS WHERE PRODUCT_ID=?";


public static final String DELETE_SPECIFIC_SALES_DETAIL = "DELETE FROM TAB_SALES_DETAILS WHERE SALES_ID=?";


public static final String ADD_SALES_ITEMS = "INSERT INTO TAB_SALES_ITEMS(SALES_ITEM_REF, SALES_ITEM_DESCRIPTION, SALES_ITEM_QUANTITY, SALES_ITEM_PRICE, SALES_ITEM_TAX, SALES_ITEM_AMOUNT, REF_SALES_ID, SHOP_ID)VALUES(?,?,?,?,?,?,?,?)";

public static final String ADD_SALES_ITEMS_FOR_ADMIN = "INSERT INTO TAB_SALES_ITEMS(SALES_ITEM_REF, SALES_ITEM_DESCRIPTION, SALES_ITEM_QUANTITY, SALES_ITEM_PRICE, SALES_ITEM_TAX, SALES_ITEM_AMOUNT, REF_SALES_ID, SHOP_ID)VALUES(?,?,?,?,?,?,?,?)";


public static final String ADD_SALES_DETAIL="INSERT INTO TAB_SALES_DETAILS(SALES_DATE, SALES_CUSTOMER_ID_REF,SALES_CUSTOMER_PHONE,SALES_CUSTOMER_ADREESS, SALES_ITEM_SUBTOTAL, SALES_ITEM_TOTAL, SALES_ITEM_DISCOUNT, SALES_ITEM_NET_TOTAL,UNIQUE_ID,SALES_CUSTOMER_TYPE,SALES_PAYMENT,SALES_PAYMENT_MODE, SALES_PAYMENT_ANSWER,SALES_TAX_AMOUNT, SHOP_ID, TRANSPORT_CHARGES,SALES_ITEM_AMOUNT)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";


public static final String ADD_SALES_DETAIL_FOR_ADMIN="INSERT INTO TAB_SALES_DETAILS(SALES_DATE, SALES_CUSTOMER_ID_REF,SALES_CUSTOMER_PHONE,SALES_CUSTOMER_ADREESS, SALES_ITEM_SUBTOTAL, SALES_ITEM_TOTAL, SALES_ITEM_DISCOUNT, SALES_ITEM_NET_TOTAL,UNIQUE_ID,SALES_CUSTOMER_TYPE,SALES_PAYMENT,SALES_PAYMENT_MODE, SALES_PAYMENT_ANSWER,SALES_TAX_AMOUNT, TRANSPORT_CHARGES, SALES_ITEM_AMOUNT)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

public static final String GET_SALES_ID = "SELECT SALES_ID FROM TAB_SALES_DETAILS WHERE UNIQUE_ID=? ";


public static final String SHOW_REGULAR_CUSTOMER_DETAILS="SELECT * FROM TAB_REGULAR_CUSTOMER WHERE REG_CUSTOMER_STATUS='ACTIVE' ";


public static final String SHOW_CONSUMER_DETAILS="SELECT * FROM TAB_CONSUMER_CUSTOMER WHERE CON_CUSTOMER_STATUS='ACTIVE'";

public static final String SHOW_VIEW_CONSUMER_SPECIFIC="SELECT * FROM TAB_CONSUMER_CUSTOMER WHERE CON_CUSTOMER_STATUS='ACTIVE' AND CON_CUSTOMER_ID=?";





public static final String SHOW_VIEW_RETAILER_TRANSACTION="SELECT * FROM TAB_OWNER_CUSTOMER_TRANSACTION WHERE CUSTOMER_TYPE='Retailer' AND SHOP_ID=? ORDER BY CUSTOMER_TRANS_ID DESC";

public static final String SHOW_VIEW_RETAILER_TRANSACTION_FOR_ADMIN="SELECT * FROM TAB_OWNER_CUSTOMER_TRANSACTION WHERE CUSTOMER_TYPE='Retailer' ORDER BY CUSTOMER_TRANS_ID DESC";

public static final String SHOW_CUSTOMER_TRANSACTION_FOR_DASH="SELECT * FROM TAB_REGULAR_CUSTOMER s, TAB_OWNER_CUSTOMER_TRANSACTION t WHERE s.REG_CUSTOMER_ID=t.CUSTOMER_ID_RETAILER ORDER BY CUSTOMER_TRANS_ID DESC LIMIT 1;";


public static final String SHOW_VIEW_CONSUMER_TRANSACTION="SELECT * FROM TAB_OWNER_CUSTOMER_TRANSACTION WHERE CUSTOMER_TYPE='Consumer' AND SHOP_ID=? ORDER BY CUSTOMER_TRANS_ID DESC";

public static final String SHOW_VIEW_CONSUMER_TRANSACTION_FOR_ADMIN="SELECT * FROM TAB_OWNER_CUSTOMER_TRANSACTION WHERE CUSTOMER_TYPE='Consumer' ORDER BY CUSTOMER_TRANS_ID DESC";

public static final String SHOW_SALES_ITEMS_DETAILS = "SELECT * FROM TAB_SALES_ITEMS  WHERE REF_SALES_ID=? AND SHOP_ID=?";

public static final String SHOW_SALES_ITEMS_DETAILS_FOR_ADMIN = "SELECT * FROM TAB_SALES_ITEMS  WHERE REF_SALES_ID=?";

public static final String UPDATE_SPECIFIC_SALES_DETAIL = "UPDATE TAB_SALES_DETAILS SET WHERE SALES_ID=?";

public static final String DELETE_SPECIFIC_RETAILER_DETAIL = "UPDATE TAB_REGULAR_CUSTOMER SET REG_CUSTOMER_STATUS='DELETED' WHERE REG_CUSTOMER_ID=?";

public static final String DELETE_SPECIFIC_CONSUMER_DETAIL = "UPDATE TAB_CONSUMER_CUSTOMER SET CON_CUSTOMER_STATUS='DELETED' WHERE  CON_CUSTOMER_ID=?";

public static final String SHOW_RETAILER_SPECIFIC_FOR_UPDATE="SELECT * FROM TAB_REGULAR_CUSTOMER WHERE  REG_CUSTOMER_ID=?";

public static final String SHOW_CONSUMER_SPECIFIC_FOR_UPDATE="SELECT * FROM TAB_CONSUMER_CUSTOMER WHERE  CON_CUSTOMER_ID=?";

public static final String GET_SHOP_LIST = "SELECT SHOP_ID, SHOP_NAME FROM TAB_SHOP_DETAILS";

public static final String SHOW_VIEW_RETAILER_SPECIFIC="SELECT * FROM TAB_REGULAR_CUSTOMER WHERE REG_CUSTOMER_ID=?";


public static final String GET_DEALER_LIST = "SELECT DEALER_ID, DEALER_FULL_NAME FROM TAB_DEALER_DETAIL WHERE DEALER_STATUS='ACTIVE'";

public static final String GET_TRANSACTION_DETAILS_BY_BILL = "SELECT  * FROM TAB_OWNER_CUSTOMER_TRANSACTION WHERE CUSTOMER_UNIQUE_ID=? AND CUSTOMER_TYPE=?";


public static final String GET_CONSUMER_TRANSACTION_DETAILS_BY_BILL="SELECT  * FROM TAB_OWNER_CUSTOMER_TRANSACTION WHERE CUSTOMER_UNIQUE_ID=? AND CUSTOMER_TYPE=?";


public static final String GET_DEALER_ADDRESS_PHONE_LIST = "SELECT  * FROM TAB_DEALER_DETAIL WHERE DEALER_ID=?";


public static final String SHOW_CEMENT_PUCHASE_DETAILS= "SELECT * FROM TAB_PURCHASE_CEMENT_DETAIL WHERE SHOP_ID=?";

public static final String SHOW_LEDGER_DEALER_DETAILS= "SELECT * FROM TAB_DEALER_LEDGER_DETAILS";

public static final String SHOW_CEMENT_PUCHASE_DETAILS_FOR_SUPER_ADMIN= "SELECT * FROM TAB_PURCHASE_CEMENT_DETAIL";


public static final String GET_DEALER_NAME_BY_ID = "SELECT DEALER_FULL_NAME FROM TAB_DEALER_DETAIL WHERE DEALER_ID=?";

public static final String VIEW_CEMENT_PURCHASE_SPECIFIC="SELECT * FROM TAB_PURCHASE_CEMENT_DETAIL WHERE PUR_CEMENT_ID=? AND SHOP_ID=?";

public static final String VIEW_CEMENT_PURCHASE_SPECIFIC_FOR_ADMIN="SELECT * FROM TAB_PURCHASE_CEMENT_DETAIL WHERE PUR_CEMENT_ID=? ";

public static final String DELETE_SPECIFIC_CEMENT_PURCHASE_DETAIL = "DELETE FROM TAB_PURCHASE_CEMENT_DETAIL WHERE PUR_CEMENT_ID=?";


public static final String SHOW_STEELBAR_PUCHASE_DETAILS= "SELECT * FROM TAB_PURCHASE_STEEBAR_DETAIL WHERE SHOP_ID=?";

public static final String SHOW_STEELBAR_PUCHASE_DETAILS_FOR_ADMIN= "SELECT * FROM TAB_PURCHASE_STEEBAR_DETAIL";

public static final String VIEW_STEELBAR_PURCHASE_SPECIFIC="SELECT * FROM TAB_PURCHASE_STEEBAR_DETAIL WHERE PUR_STEEBAR_ID=? AND SHOP_ID=?";


public static final String VIEW_STEELBAR_PURCHASE_SPECIFIC_FOR_ADMIN="SELECT * FROM TAB_PURCHASE_STEEBAR_DETAIL WHERE PUR_STEEBAR_ID=? ";

public static final String DELETE_SPECIFIC_STEELBAR_PURCHASE_DETAIL = "DELETE FROM TAB_PURCHASE_STEEBAR_DETAIL WHERE PUR_STEEBAR_ID=?";

public static final String GET_TAX_VALUE_BY_ID = "SELECT  TAX_TOTAL FROM TAB_TAX WHERE TAX_ID=?";


public static final String GET_PAY_MODE_LIST = "SELECT PAY_MODE_ID, PAY_MODE_NAME FROM TAB_PAYMENT_MODE";

public static final String SHOW_VIEW_PURCHASE_SPECIFIC="SELECT * FROM TAB_PURCHASE_CEMENT_DETAIL WHERE PUR_CEMENT_ID=? AND SHOP_ID=?";

public static final String SHOW_VIEW_PURCHASE_SPECIFIC_FOR_ADMIN="SELECT * FROM TAB_PURCHASE_CEMENT_DETAIL WHERE PUR_CEMENT_ID=?";

public static final String SHOW_VIEW_DEALER_TRANSACTION_SPECIFIC="SELECT * FROM TAB_DEALER_OWNER_TRANSACTION WHERE DEALER_TRANS_BILL_NO=?";

public static final String SHOW_VIEW_PURCHASE_STEELBAR_SPECIFIC="SELECT * FROM TAB_PURCHASE_STEEBAR_DETAIL WHERE PUR_STEEBAR_ID=? AND SHOP_ID=?";

public static final String SHOW_VIEW_PURCHASE_STEELBAR_SPECIFIC_FOR_ADMIN="SELECT * FROM TAB_PURCHASE_STEEBAR_DETAIL WHERE PUR_STEEBAR_ID=?";

public static final String SHOW_DEALER_TRANSACTION="SELECT * FROM TAB_DEALER_OWNER_TRANSACTION WHERE SHOP_ID=? ORDER BY DEALER_TRANS_ID DESC";

public static final String SHOW_DEALER_TRANSACTION_FOR_ADMIN="SELECT * FROM TAB_DEALER_OWNER_TRANSACTION ORDER BY DEALER_TRANS_ID DESC";

public static final String SHOW_DEALER_DETAILS="SELECT * FROM TAB_DEALER_DETAIL WHERE DEALER_STATUS='ACTIVE' ";

public static final String SHOW_VIEW_DEALER_SPECIFIC="SELECT * FROM TAB_DEALER_DETAIL WHERE DEALER_STATUS='ACTIVE' AND DEALER_ID=?";


public static final String DELETE_SPECIFIC_DEALER_DETAIL = "UPDATE TAB_DEALER_DETAIL SET DEALER_STATUS='DELETED' WHERE DEALER_ID=?";


public static final String SHOW_DEALER_SPECIFIC_FOR_UPDATE="SELECT * FROM TAB_DEALER_DETAIL WHERE DEALER_ID=?";

public static final String SHOW_SPECIFIC_DEALER_TRANSACTION="SELECT * FROM TAB_DEALER_OWNER_TRANSACTION WHERE DEALER_TRANS_ID=? AND SHOP_ID=?";

public static final String SHOW_SPECIFIC_DEALER_TRANSACTION_FOR_ADMIN="SELECT * FROM TAB_DEALER_OWNER_TRANSACTION WHERE DEALER_TRANS_ID=? AND SHOP_ID=?";

public static final String DELETE_SPECIFIC_DEALER_TRANSACTION = "DELETE FROM TAB_DEALER_OWNER_TRANSACTION WHERE DEALER_TRANS_ID=?";

public static final String SHOW_PURCHASE_PRINT_PDF = "SELECT * FROM TAB_PURCHASE_CEMENT_DETAIL WHERE PUR_CEMENT_ID=? AND  SHOP_ID=?";

public static final String SHOW_PURCHASE_PRINT_PDF_FOR_ADMIN = "SELECT * FROM TAB_PURCHASE_CEMENT_DETAIL WHERE PUR_CEMENT_ID=? ";

public static final String SHOW_PURCHASE_STEEL_PRINT_PDF = "SELECT * FROM TAB_PURCHASE_STEEBAR_DETAIL WHERE PUR_STEEBAR_ID=? AND  SHOP_ID=?";


public static final String SHOW_PURCHASE_STEEL_PRINT_PDF_FOR_ADMIN = "SELECT * FROM TAB_PURCHASE_STEEBAR_DETAIL WHERE PUR_STEEBAR_ID=?";

public static final String SHOW_RETAILER_SPECIFIC_TRANSACTION="SELECT * FROM  TAB_OWNER_CUSTOMER_TRANSACTION WHERE CUSTOMER_TRANS_ID=? AND SHOP_ID=?";

public static final String SHOW_RETAILER_SPECIFIC_TRANSACTION_FOR_ADMIN="SELECT * FROM  TAB_OWNER_CUSTOMER_TRANSACTION WHERE CUSTOMER_TRANS_ID=? ";


public static final String DELETE_SPECIFIC_RETAILER_TRANSACTION = "DELETE FROM TAB_OWNER_CUSTOMER_TRANSACTION WHERE CUSTOMER_TRANS_ID=?";


public static final String VIEW_SPECIFIC_CONSUMER_TRANSACTION="SELECT * FROM TAB_OWNER_CUSTOMER_TRANSACTION WHERE CUSTOMER_TRANS_ID=? AND SHOP_ID=?";

public static final String VIEW_SPECIFIC_CONSUMER_TRANSACTION_FOR_ADMIN="SELECT * FROM TAB_OWNER_CUSTOMER_TRANSACTION WHERE CUSTOMER_TRANS_ID=?";

public static final String DELETE_SPECIFIC_CONSUMER_TRANSACTION = "DELETE FROM TAB_OWNER_CUSTOMER_TRANSACTION WHERE CUSTOMER_TRANS_ID=?";


public static final String SHOW_DEALER_TRANSACTION_PRINT_PDF = "SELECT * FROM TAB_DEALER_OWNER_TRANSACTION WHERE DEALER_TRANS_ID=? AND SHOP_ID=?";


public static final String SHOW_DEALER_TRANSACTION_PRINT_PDF_FOR_ADMIN = "SELECT * FROM TAB_DEALER_OWNER_TRANSACTION WHERE DEALER_TRANS_ID=?";

public static final String SHOW_CONSUMER_TRANSACTION_PRINT_PDF = "SELECT * FROM TAB_OWNER_CUSTOMER_TRANSACTION WHERE CUSTOMER_TRANS_ID=? AND SHOP_ID=?";

public static final String SHOW_CONSUMER_TRANSACTION_PRINT_PDF_FOR_ADMIN = "SELECT * FROM TAB_OWNER_CUSTOMER_TRANSACTION WHERE CUSTOMER_TRANS_ID=?";

public static final String SHOW_RETAILER_TRANSACTION_PRINT_PDF = "SELECT * FROM TAB_OWNER_CUSTOMER_TRANSACTION WHERE CUSTOMER_TRANS_ID=? AND SHOP_ID=?";

public static final String SHOW_RETAILER_TRANSACTION_PRINT_PDF_FOR_ADMIN= "SELECT * FROM TAB_OWNER_CUSTOMER_TRANSACTION WHERE CUSTOMER_TRANS_ID=? ";

public static final String SHOW_DEALER_DETAILS_PRINT_PDF = "SELECT * FROM TAB_DEALER_DETAIL WHERE DEALER_STATUS='ACTIVE' AND DEALER_ID=?";

public static final String SHOW_RETAILER_DETAILS_PRINT_PDF = "SELECT * FROM TAB_REGULAR_CUSTOMER WHERE REG_CUSTOMER_STATUS='ACTIVE' AND REG_CUSTOMER_ID=? ";


public static final String SHOW_CONSUMER_DETAILS_PRINT_PDF ="SELECT * FROM  TAB_CONSUMER_CUSTOMER WHERE CON_CUSTOMER_STATUS='ACTIVE' AND CON_CUSTOMER_ID=?";

public static final String VIEW_PURCHASE_CEMENT_XLS_REPORT = "SELECT * FROM TAB_PURCHASE_CEMENT_DETAIL WHERE  SHOP_ID=?";

public static final String VIEW_PURCHASE_CEMENT_XLS_REPORT_FOR_ADMIN = "SELECT * FROM TAB_PURCHASE_CEMENT_DETAIL";

public static final String VIEW_PURCHASE_STEELBAR_XLS_REPORT = "SELECT * FROM TAB_PURCHASE_STEEBAR_DETAIL  WHERE  SHOP_ID=?";

public static final String VIEW_PURCHASE_STEELBAR_XLS_REPORT_FOR_ADMIN = "SELECT * FROM TAB_PURCHASE_STEEBAR_DETAIL";

public static final String VIEW_RETAILER_DEATAIL_XLS_REPORT = "SELECT * FROM TAB_REGULAR_CUSTOMER WHERE REG_CUSTOMER_STATUS='ACTIVE'";

public static final String VIEW_CONSUMER_DEATAIL_XLS_REPORT = "SELECT * FROM TAB_CONSUMER_CUSTOMER WHERE CON_CUSTOMER_STATUS='ACTIVE'";

public static final String VIEW_DEALER_DETAIL_XLS_REPORT = "SELECT * FROM TAB_DEALER_DETAIL WHERE DEALER_STATUS='ACTIVE'";

public static final String VIEW_RETAILER_TRANSACTION_XLS_REPORT = "SELECT * FROM TAB_OWNER_CUSTOMER_TRANSACTION WHERE CUSTOMER_TYPE=? AND SHOP_ID=?";

public static final String VIEW_RETAILER_TRANSACTION_XLS_REPORT_FOR_ADMIN = "SELECT * FROM TAB_OWNER_CUSTOMER_TRANSACTION WHERE CUSTOMER_TYPE=?";

public static final String VIEW_CONSUMER_TRANSACTION_XLS_REPORT = "SELECT * FROM TAB_OWNER_CUSTOMER_TRANSACTION WHERE CUSTOMER_TYPE=? AND SHOP_ID=?";

public static final String VIEW_DEALER_TRANSACTION_XLS_REPORT = "SELECT * FROM TAB_DEALER_OWNER_TRANSACTION WHERE SHOP_ID=?";

public static final String VIEW_DEALER_TRANSACTION_XLS_REPORT_FOR_ADMIN = "SELECT * FROM TAB_DEALER_OWNER_TRANSACTION";


public static final String GET_PURCHASE_CEMENT_LAST_RECORD_ID = "SELECT  PUR_CEMENT_ID FROM TAB_PURCHASE_CEMENT_DETAIL WHERE SHOP_ID=? ORDER BY PUR_CEMENT_ID DESC LIMIT 1 ";


public static final String GET_PURCHASE_CEMENT_LAST_RECORD_ID_FOR_ADMIN = "SELECT  PUR_CEMENT_ID FROM TAB_PURCHASE_CEMENT_DETAIL  ORDER BY PUR_CEMENT_ID DESC LIMIT 1 ";
//SELECT  PUR_CEMENT_ID FROM TAB_PURCHASE_CEMENT_DETAIL WHERE SHOP_ID=4 ORDER BY PUR_CEMENT_ID DESC LIMIT 1

public static final String VIEW_NEXT_CEMENT_PURCHASE_SPECIFIC="SELECT * FROM TAB_PURCHASE_CEMENT_DETAIL WHERE PUR_CEMENT_ID=? AND SHOP_ID=?";

public static final String VIEW_NEXT_CEMENT_PURCHASE_SPECIFIC_FOR_ADMIN="SELECT * FROM TAB_PURCHASE_CEMENT_DETAIL WHERE PUR_CEMENT_ID=?";


public static final String GET_PURCHASE_STEELBAR_LAST_RECORD_ID = "SELECT  PUR_STEEBAR_ID FROM TAB_PURCHASE_STEEBAR_DETAIL WHERE SHOP_ID=? ORDER BY PUR_STEEBAR_ID DESC LIMIT 1";

public static final String GET_PURCHASE_STEELBAR_LAST_RECORD_ID_FOR_ADMIN = "SELECT  PUR_STEEBAR_ID FROM TAB_PURCHASE_STEEBAR_DETAIL  ORDER BY PUR_STEEBAR_ID DESC LIMIT 1";

public static final String VIEW_NEXT_STEELBAR_PURCHASE_SPECIFIC="SELECT * FROM TAB_PURCHASE_STEEBAR_DETAIL WHERE PUR_STEEBAR_ID=? AND SHOP_ID=?";

public static final String VIEW_NEXT_STEELBAR_PURCHASE_SPECIFIC_FOR_ADMIN="SELECT * FROM TAB_PURCHASE_STEEBAR_DETAIL WHERE PUR_STEEBAR_ID=?";


public static final String GET_DEALER_DETAIL_LAST_RECORD_ID = "SELECT  DEALER_ID FROM TAB_DEALER_DETAIL WHERE DEALER_STATUS='ACTIVE'  GROUP BY DEALER_ID DESC LIMIT 1";

public static final String SHOW_NEXT_DEALER_SPECIFIC="SELECT * FROM TAB_DEALER_DETAIL WHERE DEALER_STATUS='ACTIVE' AND DEALER_ID=?";

public static final String GET_RETAILER_DETAIL_LAST_RECORD_ID = "SELECT  REG_CUSTOMER_ID FROM TAB_REGULAR_CUSTOMER WHERE REG_CUSTOMER_STATUS='ACTIVE' GROUP BY REG_CUSTOMER_ID DESC LIMIT 1";


public static final String SHOW_NEXT_RETAILER_SPECIFIC="SELECT * FROM TAB_REGULAR_CUSTOMER WHERE REG_CUSTOMER_STATUS='ACTIVE' AND REG_CUSTOMER_ID=?";

public static final String GET_CONSUMER_DETAIL_LAST_RECORD_ID = "SELECT  CON_CUSTOMER_ID FROM TAB_CONSUMER_CUSTOMER WHERE CON_CUSTOMER_STATUS='ACTIVE'  GROUP BY CON_CUSTOMER_ID DESC LIMIT 1";

public static final String SHOW_NEXT_CONSUMER_SPECIFIC="SELECT * FROM TAB_CONSUMER_CUSTOMER WHERE CON_CUSTOMER_STATUS='ACTIVE' AND CON_CUSTOMER_ID=?";

public static final String GET_RETAILER_TRANSACTION_LAST_RECORD_ID = "SELECT  CUSTOMER_TRANS_ID FROM TAB_OWNER_CUSTOMER_TRANSACTION WHERE CUSTOMER_TYPE='Retailer' AND SHOP_ID=? ORDER BY CUSTOMER_TRANS_ID DESC LIMIT 1";

public static final String GET_RETAILER_TRANSACTION_LAST_RECORD_ID_FOR_ADMIN = "SELECT  CUSTOMER_TRANS_ID FROM TAB_OWNER_CUSTOMER_TRANSACTION WHERE CUSTOMER_TYPE='Retailer' ORDER BY CUSTOMER_TRANS_ID DESC LIMIT 1";

public static final String SHOW_RETAILER_NEXT_TRANSACTION="SELECT * FROM  TAB_OWNER_CUSTOMER_TRANSACTION WHERE CUSTOMER_TYPE='Retailer' AND CUSTOMER_TRANS_ID=?  AND SHOP_ID=?";

public static final String SHOW_RETAILER_NEXT_TRANSACTION_FOR_ADMIN="SELECT * FROM  TAB_OWNER_CUSTOMER_TRANSACTION WHERE CUSTOMER_TYPE='Retailer' AND CUSTOMER_TRANS_ID=?";

public static final String GET_CONSUMER_TRANSACTION_LAST_RECORD_ID = "SELECT  CUSTOMER_TRANS_ID FROM TAB_OWNER_CUSTOMER_TRANSACTION WHERE CUSTOMER_TYPE='Consumer' AND SHOP_ID=? ORDER BY CUSTOMER_TRANS_ID DESC LIMIT 1";

public static final String GET_CONSUMER_TRANSACTION_LAST_RECORD_ID_FOR_ADMIN = "SELECT  CUSTOMER_TRANS_ID FROM TAB_OWNER_CUSTOMER_TRANSACTION WHERE CUSTOMER_TYPE='Consumer' ORDER BY CUSTOMER_TRANS_ID DESC LIMIT 1";

public static final String VIEW_NEXT_CONSUMER_TRANSACTION="SELECT * FROM TAB_OWNER_CUSTOMER_TRANSACTION WHERE CUSTOMER_TRANS_ID=? AND CUSTOMER_TYPE='Consumer' AND SHOP_ID=?";

public static final String VIEW_NEXT_CONSUMER_TRANSACTION_FOR_ADMIN="SELECT * FROM TAB_OWNER_CUSTOMER_TRANSACTION WHERE CUSTOMER_TRANS_ID=? AND CUSTOMER_TYPE='Consumer'";

public static final String GET_DEALER_TRANSACTION_LAST_RECORD_ID = "SELECT DEALER_TRANS_ID FROM TAB_DEALER_OWNER_TRANSACTION WHERE SHOP_ID=? ORDER BY DEALER_TRANS_ID DESC LIMIT 1";

public static final String GET_DEALER_TRANSACTION_LAST_RECORD_ID_FOR_ADMIN = "SELECT DEALER_TRANS_ID FROM TAB_DEALER_OWNER_TRANSACTION ORDER BY DEALER_TRANS_ID DESC LIMIT 1";

public static final String VIEW_NEXT_DEALER_TRANSACTION="SELECT * FROM TAB_DEALER_OWNER_TRANSACTION WHERE DEALER_TRANS_ID=? AND SHOP_ID=?";


public static final String VIEW_NEXT_DEALER_TRANSACTION_FOR_ADMIN="SELECT * FROM TAB_DEALER_OWNER_TRANSACTION WHERE DEALER_TRANS_ID=?";

public static final String SHOW_SALES_PRINT_PDF = "SELECT * FROM TAB_SALES_DETAILS WHERE SALES_ID=? AND SHOP_ID=?";

public static final String SHOW_SALES_PRINT_PDF_FOR_ADMIN = "SELECT * FROM TAB_SALES_DETAILS WHERE SALES_ID=?";

public static final String VIEW_SALES_DETAILS_XLS_REPORT = "SELECT * FROM  TAB_SALES_DETAILS WHERE SHOP_ID=?";

public static final String VIEW_SALES_DETAILS_XLS_REPORT_FOR_ADMIN = "SELECT * FROM  TAB_SALES_DETAILS ";

public static final String GET_SALES_LAST_RECORD_ID = "SELECT  SALES_ID FROM TAB_SALES_DETAILS WHERE SHOP_ID=? ORDER BY SALES_ID DESC LIMIT 1";

public static final String GET_SALES_LAST_RECORD_ID_FOR_ADMIN = "SELECT  SALES_ID FROM TAB_SALES_DETAILS ORDER BY SALES_ID DESC LIMIT 1";

public static final String SHOW_NEXT_SALES_SPECIFIC="SELECT * FROM TAB_SALES_DETAILS WHERE SALES_ID=? AND SHOP_ID=?";

public static final String SHOW_NEXT_SALES_SPECIFIC_FOR_ADMIN="SELECT * FROM TAB_SALES_DETAILS WHERE SALES_ID=?";

public static final String SHOW_SPECIFIC_DEALER_TRANSACTION_FOR_PAY_DUE="SELECT * FROM TAB_DEALER_OWNER_TRANSACTION WHERE DEALER_TRANS_ID=? AND SHOP_ID=?";

public static final String SHOW_SPECIFIC_DEALER_TRANSACTION_FOR_PAY_DUE_FOR_ADMIN="SELECT * FROM TAB_DEALER_OWNER_TRANSACTION WHERE DEALER_TRANS_ID=?";

public static final String GET_PAY_MODE_BY_ID = "SELECT PAY_MODE_NAME FROM TAB_PAYMENT_MODE WHERE PAY_MODE_ID=?";

public static final String GET_CONSUMER_NAME_BY_ID = "SELECT CON_FULL_NAME FROM TAB_CONSUMER_CUSTOMER WHERE  CON_CUSTOMER_ID=?";

public static final String GET_CITY_LIST = "SELECT CITY_ID,  CITY_NAME FROM CITIES";

public static final String GET_STATE_LIST = "SELECT CITY_STATE, CITY_ID FROM CITIES GROUP BY CITY_STATE";

public static final String GET_STATE_BY_ID = "SELECT CITY_STATE FROM CITIES WHERE CITY_ID=?";

public static final String GET_CITY_BY_ID = "SELECT CITY_NAME FROM CITIES WHERE CITY_ID=?";

public static final String GET_CITY_LIST_BY_STATE_NAME="SELECT CITY_ID,  CITY_NAME FROM CITIES WHERE CITY_STATE=?";

public static final String GET_PRODUCT_NAME_LIST_FROM_CATEGORY="SELECT * FROM TAB_PRODUCT_CATEGORY";

public static final String GET_PRODUCT_TYPE_BASED_ON_PRODUCT="SELECT * FROM TAB_CEMENT_TYPE";

public static final String GET_TYPE_LIST_BY_CATEGORY="SELECT * FROM TAB_CEMENT_TYPE WHERE CEMENT_TYPE_CATEGORY=?";

public static final String GET_CEMENT_TYPE_LIST="SELECT  PRODUCT_ID, PRODUCT_NAME FROM TAB_PRODUCT_DETAILS ";//WHERE PRODUCT_NAME=1

public static final String GET_TYPE_NAME_BY_ID = "SELECT CEMENT_TYPE_NAME FROM TAB_CEMENT_TYPE WHERE CEMENT_TYPE_ID=?";


public static final String GET_STEELBAR_TYPE_LIST="SELECT  PRODUCT_ID, PRODUCT_NAME FROM TAB_PRODUCT_DETAILS";

public static final String INSERT_PRODUCT_TYPE="INSERT INTO TAB_CEMENT_TYPE(CEMENT_TYPE_CATEGORY ,CEMENT_TYPE_NAME)VALUES(?,?)";

public static final String GET_PRODUCT_TYPE_GIRD_LIST = "SELECT  CEMENT_TYPE_ID, CEMENT_TYPE_NAME,CEMENT_TYPE_CATEGORY FROM  TAB_CEMENT_TYPE";

public static final String EDIT_PRODUCT_TYPE = "SELECT  CEMENT_TYPE_NAME, CEMENT_TYPE_CATEGORY FROM TAB_CEMENT_TYPE WHERE CEMENT_TYPE_ID=?";


public static final String UPDATE_PRODUCT_TYPE = "UPDATE TAB_CEMENT_TYPE SET CEMENT_TYPE_NAME=?, CEMENT_TYPE_CATEGORY=? WHERE CEMENT_TYPE_ID=?";


public static final String FETCH_STOCK_BASED_ON_ITEM_ID_AND_TYPE="SELECT STOCK_BAGS_NO FROM TAB_STOCK_DETAILS WHERE STOCK_PRODUCT_TYPE=? AND SHOP_ID=?";

public static final String FETCH_STOCK_BASED_ON_ITEM_ID_AND_TYPE_FOR_ADMIN="SELECT STOCK_BAGS_NO FROM TAB_STOCK_DETAILS WHERE STOCK_PRODUCT_TYPE=?";


public static final String CHECK_PRODUCT_NAME="SELECT PRODUCT_NAME FROM TAB_PRODUCT_DETAILS WHERE PRODUCT_ID=?";

public static final String VIEW_STOCK_XLS_REPORT = "SELECT * FROM TAB_STOCK_DETAILS WHERE SHOP_ID=?";

public static final String VIEW_STOCK_XLS_REPORT_FOR_ADMIN = "SELECT * FROM TAB_STOCK_DETAILS ";

public static final String GET_STOCK_GRID = "SELECT * FROM TAB_STOCK_DETAILS WHERE SHOP_ID=?";

public static final String GET_STOCK_GRID_FOR_ADMIN = "SELECT * FROM TAB_STOCK_DETAILS";

public static final String SHOW_SPECIFIC_RETAILER_TRANSACTION_FOR_PAY_DUE="SELECT * FROM TAB_OWNER_CUSTOMER_TRANSACTION WHERE CUSTOMER_TRANS_ID=? AND SHOP_ID=?";

public static final String SHOW_SPECIFIC_RETAILER_TRANSACTION_FOR_PAY_DUE_FOR_ADMIN="SELECT * FROM TAB_OWNER_CUSTOMER_TRANSACTION WHERE CUSTOMER_TRANS_ID=?";


public static final String SHOW_RETAILER_SPECIFIC_FOR_PAY="SELECT * FROM TAB_REGULAR_CUSTOMER WHERE REG_CUSTOMER_STATUS='ACTIVE' AND REG_CUSTOMER_ID=?";


public static final String SHOW_SPECIFIC_CONSUMER_TRANSACTION_FOR_PAY_DUE="SELECT * FROM TAB_OWNER_CUSTOMER_TRANSACTION WHERE CUSTOMER_TRANS_ID=? AND SHOP_ID=?";

public static final String SHOW_SPECIFIC_CONSUMER_TRANSACTION_FOR_PAY_DUE_FOR_ADMIN="SELECT * FROM TAB_OWNER_CUSTOMER_TRANSACTION WHERE CUSTOMER_TRANS_ID=?";

public static final String SHOW_CONSUMER_SPECIFIC_FOR_PAY="SELECT * FROM TAB_CONSUMER_CUSTOMER WHERE CON_CUSTOMER_STATUS='ACTIVE' AND  CON_CUSTOMER_ID=?";

public static final String DELETE_SPECIFIC_STOCK_DETAIL = "DELETE FROM TAB_STOCK_DETAILS WHERE STOCK_PRODUCT_TYPE=?";



public static final String INSERT_TRANSPORT_DETAILS = "INSERT INTO TAB_TRANSPORT_DETAILS(TRANSPORT_ID,TRANSPORT_NAME,TRANSPORT_ADDRESS_LINE1,TRUCK_NUMBER,CONTACT_PERSON,ALTERNATIVE_CONTACT,TRANSPORT_ADDRESS_LINE2,TRANSPORTER,CREATION_DATE,CONTACT_NUMBER,CITY )VALUES(?,?,?,?,?,?,?,?,?,?,?)";

public static final String GET_TRANSPORT_DETAIL = "SELECT TRANSPORT_ID,TRANSPORT_NAME,TRUCK_NUMBER,CREATION_DATE,CONTACT_NUMBER,CITY FROM TAB_TRANSPORT_DETAILS";

public static final String DELETE_TRANSPORT_DETAILS ="DELETE  FROM TAB_TRANSPORT_DETAILS WHERE TRANSPORT_ID = ?";

public static final String SHOW_VIEW_TRANSPORT ="SELECT * FROM TAB_TRANSPORT_DETAILS WHERE TRANSPORT_ID = ?";

public static final String VIEW_TRANSPORT_PDF=" SELECT * FROM TAB_TRANSPORT_DETAILS WHERE TRANSPORT_ID=?";

public static final String GET_TRANSPORT_DETAIL_EDIT = "SELECT  TRANSPORT_ID,TRANSPORT_NAME,TRANSPORT_ADDRESS_LINE1,TRUCK_NUMBER,CONTACT_PERSON,ALTERNATIVE_CONTACT,TRANSPORT_ADDRESS_LINE2,TRANSPORTER,CREATION_DATE,CONTACT_NUMBER,CITY  FROM TAB_TRANSPORT_DETAILS WHERE TRANSPORT_ID = ?";

public static final String UPDATE_TRANSPORT_DETAIL = "UPDATE TAB_TRANSPORT_DETAILS SET TRANSPORT_NAME=?, TRANSPORT_ADDRESS_LINE1=?,TRUCK_NUMBER=?,CONTACT_PERSON=?,ALTERNATIVE_CONTACT=?,TRANSPORT_ADDRESS_LINE2=?,TRANSPORTER=?,CREATION_DATE=?,"
		+ "CONTACT_NUMBER=?,CITY=? WHERE TRANSPORT_ID=?";

public static final String VIEW_TRANSPORT_XLS_REPORT = "SELECT * FROM TAB_TRANSPORT_DETAILS";

public static final String GET_LAST_TRANSPORT_ID = "SELECT  TRANSPORT_ID FROM TAB_TRANSPORT_DETAILS GROUP BY TRANSPORT_ID DESC LIMIT 1";

public static final String SHOW_NEXT_VIEW_TRANSPORT = "SELECT * FROM TAB_TRANSPORT_DETAILS WHERE TRANSPORT_ID=?";


public static final String GET_PAYMENTSELECT_LIST = "SELECT PAYMENTSELECT_ID,PAYMENTSELECT_NAME FROM TAB_PAYMENTSELECT_LIST";

public static final String GET_PAYMENT_DETAIL = "SELECT PAYMENT_ID,PAYMENT_NAME FROM TAB_PAYMENT_DETAILS";

public static final String INSERT_PAYMENT_DETAILS = "INSERT INTO TAB_PAYMENT_DETAILS(PAYMENT_ID,PAYMENT_NAME)VALUES(?,?)";

public static final String GET_PAYMENT_DETAIL_EDIT = "SELECT  PAYMENT_ID,PAYMENT_NAME FROM TAB_PAYMENT_DETAILS WHERE PAYMENT_ID = ?";

public static final String UPDATE_PAYMENT_DETAIL = "UPDATE TAB_PAYMENT_DETAILS SET PAYMENT_NAME=? WHERE PAYMENT_ID=?";

public static final String DELETE_PAYMENT_DETAILS ="DELETE  FROM TAB_PAYMENT_DETAILS WHERE PAYMENT_ID = ?";

public static final String GET_TRANSPORT_LIST = "SELECT TRANSPORT_ID, TRANSPORT_NAME FROM TAB_TRANSPORT_DETAILS";

public static final String GET_ALL_WALL_PAINT_DETAILS="SELECT * FROM TAB_PURCHASE_WALLPAINT";

public static final String FETCH_SPECIFIC_PAINT_PURCHASE="SELECT * FROM TAB_PURCHASE_WALLPAINT WHERE PUR_WALLPAINT_ID=?";

public static final String GET_PESTICIDES_DETAILS="SELECT * FROM TAB_PURCHASE_PESTICIDES_DETAIL";


public static final String VIEW_PESTICIDES_SPECIFIC_FOR_ADMIN="SELECT * FROM TAB_PURCHASE_PESTICIDES_DETAIL WHERE PUR_PESTICIDE_ID=? ";


public static final String DELETE_PESTICIDES_DETAIL = "DELETE FROM TAB_PURCHASE_PESTICIDES_DETAIL WHERE PUR_PESTICIDE_ID=?";


public static final String GET_PURCHASE_PESTICIDE_LAST_RECORD_ID = "SELECT  PUR_PESTICIDE_ID FROM TAB_PURCHASE_PESTICIDES_DETAIL  ORDER BY PUR_PESTICIDE_ID DESC LIMIT 1 ";


public static final String VIEW_NEXT_PESTICIDE_PURCHASE_SPECIFIC="SELECT * FROM TAB_PURCHASE_PESTICIDES_DETAIL WHERE PUR_PESTICIDE_ID=?";


public static final String GET_PURCHASE_WALLPAINT_LAST_RECORD_ID = "SELECT  PUR_WALLPAINT_ID FROM TAB_PURCHASE_WALLPAINT  ORDER BY PUR_WALLPAINT_ID DESC LIMIT 1 ";

public static final String VIEW_NEXT_WALLPAINT_PURCHASE_SPECIFIC="SELECT * FROM TAB_PURCHASE_WALLPAINT WHERE PUR_WALLPAINT_ID=?";



public static final String VIEW_WALL_PAINT_PURCHASE_SPECIFIC_FOR_ADMIN="SELECT * FROM TAB_PURCHASE_WALLPAINT WHERE PUR_WALLPAINT_ID=? ";

public static final String DELETE_PURCHASE_WALL_PAINT_DETAILS ="DELETE  FROM TAB_PURCHASE_WALLPAINT WHERE PUR_WALLPAINT_ID = ?";

public static final String VIEW_WALL_PAINT_PDF=" SELECT * FROM TAB_PURCHASE_WALLPAINT WHERE PUR_WALLPAINT_ID=?";

public static final String VIEW_PESTICIDE_PDF=" SELECT * FROM TAB_PURCHASE_PESTICIDES_DETAIL WHERE PUR_PESTICIDE_ID=?";

public static final String GET_CATEGORY_BY_ID = "SELECT PRODUCT_CATEGORY FROM TAB_PRODUCT_DETAILS WHERE PRODUCT_ID=?";

public static final String GET_CATEGORY_NAME_BY_ID = "SELECT PRODUCT_CATEGORY_NAME FROM TAB_PRODUCT_CATEGORY WHERE PRODUCT_CATEGORY_ID=?";

public static final String GET_PRODUCT_CATEGORY_IN_TYPE = "SELECT CEMENT_TYPE_CATEGORY FROM TAB_CEMENT_TYPE";

}




