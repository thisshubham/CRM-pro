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
 * Interface Name     SettingDaoImpl.java     
 *                                                            
 * Creation Date  NOV 13 , 2015 
 * 
 * Abstract       This is SettingDaoImpl class design to implements declared methods in interface and performs operations related to database.
 *  
 * Amendment History (in chronological sequence): NOV 13, 2015 
 * 
 **********************************************************************
 */
package com.bst.ckt.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.bst.ckt.common.LoginUtil;
import com.bst.ckt.common.QueryMaker;
import com.bst.ckt.dto.Company;
import com.bst.ckt.exception.OMIApplicationException;
import com.bst.ckt.framework.db.JdbcDAOSupport;
import com.bst.ckt.framework.db.JdbcHelper;
import com.bst.ckt.framework.util.DateTimeUtil;
import com.bst.ckt.helper.GlAccountType;
import com.bst.ckt.helper.NameHelper;
import com.bst.ckt.vo.CompanyVO;

/**
 * @author abhilash
 * 
 */
public class SettingDaoImpl extends JdbcDAOSupport implements SettingDaoInf {

	PreparedStatement preparedStatement = null;
	Connection connection = null;
	ResultSet resultSet = null;
	Company company = new Company();
	NameHelper nameHelper = new NameHelper();

	/**
	 * Creating Logger object, logger object mapped with AccountAction class for
	 * writing Loggers.
	 */
	public static final Logger logger = Logger.getLogger(SettingDaoImpl.class);

	/**
	 * <p>
	 * <code>getCompanyInformation()</code>this method is design to fetch
	 * company details for update process from database.
	 * </p>
	 * 
	 * @return company
	 * @param companyId
	 * @throws OMIApplicationException
	 */

	@Override
	public Company getCompanyInformation(int companyId)
			throws OMIApplicationException {
		Company company = new Company();

		try {
			connection = getConnection();
			String query = QueryMaker.GET_COMPANY_DETAILS;
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, companyId);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				company.setCompanyId(resultSet.getInt("COMPANY_ID"));
				company.setCompanyName(resultSet.getString("COMPANY_NAME"));
				company.setTradeNname(resultSet.getString("TRADE_NAME"));
				company.setRegistrationNo(resultSet
						.getString("REGISTRATION_NO"));
				company.setAddressLine1(resultSet.getString("ADDRESS_LINE_1"));
				company.setAddressLine2(resultSet.getString("ADDRESS_LINE_2"));
				company.setCity(resultSet.getString("CITY"));
				company.setState(resultSet.getString("STATE"));
				company.setZipCode(resultSet.getString("ZIPCODE"));
				company.setPhoneNo(resultSet.getString("PHONE_NO"));
				company.setMobileNo(resultSet.getString("MOBILE_NO"));
				company.setFaxNo(resultSet.getString("FAX_NO"));
				company.setCompanyEmailId(resultSet
						.getString("COMPANY_EMAIL_ID"));
				company.setCompanyUrl(resultSet.getString("COMPANY_URL"));
				company.setFacebookDetail(resultSet
						.getString("FACEBOOK_DETAIL"));
				company.setGooglePlusDetail(resultSet
						.getString("GOOGLE_PLUS_DETAIL"));
				company.setLinkedInDetail(resultSet
						.getString("LINKED_IN_DETAIL"));
				company.setTwitterDetail(resultSet.getString("TWITTER_DETAIL"));
				company.setBlogDetail(resultSet.getString("BLOG_DETAIL"));
				company.setYoutubeDetail(resultSet.getString("YOUTUBE_DETAIL"));
				company.setRefCompanyTypeName(resultSet
						.getString("REF_COMPANY_TYPE"));
				company.setRefCompanyCategoryName(resultSet
						.getString("REF_COMPANY_CATEGORY"));
				company.setRefCompanySectorName(resultSet
						.getString("REF_COMPANY_SECTOR"));
				company.setRefCountryName(resultSet.getString("REF_COUNTRY"));
				company.setRefTimezoneName(resultSet.getString("REF_TIMEZONE"));
				company.setRefCurrency(resultSet.getString("REF_CURRENCY"));
				company.setRefLanguage(resultSet.getString("REF_LANGUAGE"));
				company.setCreationDate(DateTimeUtil
						.convertDatetoFormDateForView(resultSet
								.getString("CREATION_DATE")));
				company.setCreatedBy(resultSet.getInt("CREATED_BY"));
				company.setUserStatus(resultSet.getInt("COMPANY_STATUS"));

			}
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					SettingDaoImpl.class
							+ ": Error:- Error: Occur in Query While fetching the company details from Database",
					sqlException);

		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					SettingDaoImpl.class
							+ ": Error:- While closing the Connection after fetching the company details from Database",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}

		return company;
	}

	/**
	 * <p>
	 * <code>updateCompanyInformation()</code>this method is design to update
	 * Company Details into database.
	 * </p>
	 * 
	 * @return companyId
	 * @throws OMIApplicationException
	 */
	@Override
	public int updateCompanyInformation(CompanyVO companyVO, int companyId)
			throws OMIApplicationException {

		int target = 0;
		companyVO.setCompanyId(companyId);

		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.UPDATE_COMPANY_DETAILS);
			preparedStatement.setString(1, companyVO.getCompanyName());
			preparedStatement.setString(2, companyVO.getTradeNname());
			preparedStatement.setString(3, companyVO.getRegistrationNo());
			preparedStatement.setString(4, companyVO.getAddressLine1());
			preparedStatement.setString(5, companyVO.getAddressLine2());
			preparedStatement.setString(6, companyVO.getCity());
			preparedStatement.setString(7, companyVO.getState());
			preparedStatement.setString(8, companyVO.getZipCode());
			preparedStatement.setString(9, companyVO.getPhoneNo());
			preparedStatement.setString(10, companyVO.getMobileNo());
			preparedStatement.setString(11, companyVO.getFaxNo());
			preparedStatement.setString(12, companyVO.getCompanyUrl());
			preparedStatement.setString(13, companyVO.getFacebookDetail());
			preparedStatement.setString(14, companyVO.getGooglePlusDetail());
			preparedStatement.setString(15, companyVO.getLinkedInDetail());
			preparedStatement.setString(16, companyVO.getTwitterDetail());
			preparedStatement.setString(17, companyVO.getBlogDetail());
			preparedStatement.setString(18, companyVO.getYoutubeDetail());
			preparedStatement.setString(19, companyVO.getCompanyTypeName());
			preparedStatement.setString(20, companyVO.getCompanyCategoryName());
			preparedStatement.setString(21, companyVO.getCompanySectorName());
			preparedStatement.setString(22, companyVO.getCountryName());
			preparedStatement.setString(23, companyVO.getTimezoneName());
			preparedStatement.setString(24, companyVO.getCurrency());
			preparedStatement.setString(25, companyVO.getLanguage());
			preparedStatement.setInt(26, companyVO.getCompanyId());

			preparedStatement.executeUpdate();

			target = 1;
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					SettingDaoImpl.class
							+ "Error: Occur in Query While updating the Company Details into Database.",
					sqlException);

		} catch (Exception exception) {

			exception.printStackTrace();
			logger.error(
					SettingDaoImpl.class
							+ "Error: Occur in Query While closing connection after updating the Company Details into Database.",
					exception);
		} finally {
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return target;
	}

	/**
	 * <p>
	 * <code>addCompanyType()</code>this method is design to inserting Company
	 * Type Details into database.
	 * </p>
	 * 
	 * @param companyVO
	 * @return Target
	 * @throws OMIApplicationException
	 */

	@Override
	public int addCompanyType(CompanyVO companyVO)
			throws OMIApplicationException {
		int target = 0;
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.INSERT_COMPANY_TYPE);
			preparedStatement.setString(1, companyVO.getCompanyType());
			preparedStatement.executeUpdate();
			target = 1;

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					SettingDaoImpl.class
							+ "Error: Occur in Query While inserting the Company Type into Database.",
					sqlException);

		} catch (Exception exception) {

			exception.printStackTrace();
			logger.error(
					SettingDaoImpl.class
							+ "Error: Occur in Query While closing connection after inserting the Company Type into Database.",
					exception);
		} finally {
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return target;
	}

	/**
	 * <p>
	 * <code>getCompanyTypeGrid()</code>this method is design to fetching
	 * Company Type Details from TAB_COMPANY_TYPE.
	 * </p>
	 * 
	 * @return companyTypeNameList
	 * @throws OMIApplicationException
	 */

	@Override
	public List<CompanyVO> getCompanyTypeGrid() throws OMIApplicationException {
		List<CompanyVO> companyTypeNameList = new ArrayList<CompanyVO>();
		CompanyVO companyVO = null;
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_COMPANY_TYPE_GIRD_LIST);
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {
					companyVO = new CompanyVO();
					companyVO.setCompanyId(resultSet.getInt("COMPANY_TYPE_ID"));
					companyVO.setCompanyType(resultSet
							.getString("COMPANY_TYPE_NAME"));
					companyTypeNameList.add(companyVO);

				}
			}
		} catch (SQLException sqlExp) {
			logger.error(
					SettingDaoImpl.class
							+ "Error: Occur in Query While Fetching the CAMPANY_TYPE Details into Grid from Database.",
					sqlExp);
		} catch (Exception exception) {
			logger.error(
					SettingDaoImpl.class
							+ "Error: Occur in Query While Closing Connection After Fetching the CAMPANY_TYPE Details into Grid from Database.",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return companyTypeNameList;
	}

	/**
	 * <p>
	 * <code>showCompanyCategoeyGrid()</code>this method is design to fetching
	 * Company Category Details from TAB_COMPANY_CATEGORY.
	 * </p>
	 * 
	 * @return companyCategoryNameList
	 * @throws OMIApplicationException
	 */

	@Override
	public List<CompanyVO> showCompanyCategoeyGrid()
			throws OMIApplicationException {

		List<CompanyVO> companyCategoryNameList = new ArrayList<CompanyVO>();
		CompanyVO companyVO = null;
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_COMPANY_CATEGORY_GIRD_LIST);
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {
					companyVO = new CompanyVO();
					companyVO.setCompanyCategoryID(resultSet
							.getInt("COMPANY_CATEGORY_ID"));
					companyVO.setCategory(resultSet
							.getString("COMPANY_CATEGORY_NAME"));
					companyCategoryNameList.add(companyVO);

				}
			}
		} catch (SQLException sqlExp) {
			logger.error(
					SettingDaoImpl.class
							+ "Error: Occur in Query While Fetching the COMPANY_CATEGORY Details into Grid from Database.",
					sqlExp);
		} catch (Exception exception) {
			logger.error(
					SettingDaoImpl.class
							+ "Error: Occur in Query While Closing Connection After Fetching the COMPANY_CATEGORY Details into Grid from Database.",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return companyCategoryNameList;
	}

	/**
	 * <p>
	 * <code>addCompanyCategory()</code>this method is design to inserting
	 * Company Category Details into database.
	 * </p>
	 * 
	 * @param companyVO
	 * @return Target
	 * @throws OMIApplicationException
	 */

	@Override
	public int addCompanyCategory(CompanyVO companyVO)
			throws OMIApplicationException {
		int target = 0;
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.INSERT_COMPANY_CATEGORY);
			preparedStatement.setString(1, companyVO.getCategory());
			preparedStatement.executeUpdate();
			target = 1;

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					SettingDaoImpl.class
							+ "Error: Occur in Query While inserting the Company Category into Database.",
					sqlException);

		} catch (Exception exception) {

			exception.printStackTrace();
			logger.error(
					SettingDaoImpl.class
							+ "Error: Occur in Query While closing connection after inserting the Company Category into Database.",
					exception);
		} finally {
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return target;

	}

	/**
	 * <p>
	 * <code>addFinanceTax()</code>this method is design to inserting Finance
	 * Tax Details into database.
	 * </p>
	 * 
	 * @param companyVO
	 * @return Target
	 * @throws OMIApplicationException
	 */
	@Override
	public int addFinanceTax(CompanyVO companyVO)
			throws OMIApplicationException {

		int target = 0;
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.INSERT_FINANCE_TAX);
			preparedStatement.setString(1, companyVO.getTaxDisplayName());
			preparedStatement.setString(2, companyVO.getTaxNameOne());
			preparedStatement.setString(3, companyVO.getTaxRateOne());
			preparedStatement.setString(4, companyVO.getTaxNameTwo());
			preparedStatement.setString(5, companyVO.getTaxRateTwo());
			preparedStatement.setString(6, companyVO.getTaxNameThree());
			preparedStatement.setString(7, companyVO.getTaxRateThree());
			preparedStatement.setString(8, companyVO.getTaxNameFour());
			preparedStatement.setString(9, companyVO.getTaxRateFour());
			preparedStatement.setString(10, companyVO.getTaxNameFive());
			preparedStatement.setString(11, companyVO.getTaxRateFive());
			preparedStatement.setString(12, companyVO.getTaxTotal());
			preparedStatement.setString(13, DateTimeUtil.getCurrentDate());
			preparedStatement.setInt(14, LoginUtil.getProcessUserId());
			preparedStatement.setString(16, DateTimeUtil.getCurrentDate());
			preparedStatement.setInt(15, LoginUtil.getProcessUserId());
			preparedStatement.executeUpdate();
			target = 1;

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					SettingDaoImpl.class
							+ "Error: Occur in Query While inserting the taxes into Database.",
					sqlException);

		} catch (Exception exception) {

			exception.printStackTrace();
			logger.error(
					SettingDaoImpl.class
							+ "Error: Occur in Query While closing connection after inserting the taxes into Database.",
					exception);
		} finally {
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return target;
	}

	/**
	 * <p>
	 * <code>showFinanceTaxGrid()</code>this method is design for getting
	 * Finance Taxes Details from database.
	 * </p>
	 * 
	 * 
	 * @return finanaceTaxList
	 * @throws OMIApplicationException
	 */
	@Override
	public List<CompanyVO> showFinanceTaxGrid() throws OMIApplicationException {

		List<CompanyVO> finanaceTaxList = new ArrayList<CompanyVO>();
		CompanyVO companyVO = null;
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_FINANCE_TAX_GIRD_LIST);
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {
					companyVO = new CompanyVO();
					companyVO.setFinanceId(resultSet.getInt("TAX_ID"));
					companyVO.setTaxDisplayName(resultSet
							.getString("TAX_DISPLAY_NAME"));
					companyVO.setTaxTotal(resultSet.getString("TAX_TOTAL"));
					finanaceTaxList.add(companyVO);

				}
			}
		} catch (SQLException sqlExp) {
			logger.error(
					SettingDaoImpl.class
							+ "Error: Occur in Query While Fetching the FINANCE_TAX Details into Grid from Database.",
					sqlExp);
		} catch (Exception exception) {
			logger.error(
					SettingDaoImpl.class
							+ "Error: Occur in Query While Closing Connection After Fetching the FINANCE_TAX Details into Grid from Database.",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return finanaceTaxList;
	}

	/**
	 * <p>
	 * <code>showProductCategoryGrid()</code>this method is design for getting
	 * Product category Details from database.
	 * </p>
	 * 
	 * 
	 * @return productCategoryList
	 * @throws OMIApplicationException
	 */

	@Override
	public List<CompanyVO> showProductCategoryGrid()
			throws OMIApplicationException {
		List<CompanyVO> productCategoryList = new ArrayList<CompanyVO>();
		CompanyVO companyVO = null;
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_PRODUCT_CATEGORY_GIRD_LIST);
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {
					companyVO = new CompanyVO();
					companyVO.setProductCategoryId(resultSet
							.getInt("PRODUCT_CATEGORY_ID"));
					companyVO.setProductCategory(resultSet
							.getString("PRODUCT_CATEGORY_NAME"));

					productCategoryList.add(companyVO);

				}
			}
		} catch (SQLException sqlExp) {
			logger.error(
					SettingDaoImpl.class
							+ "Error: Occur in Query While Fetching the PRODUCT CATEGORY Details into Grid from Database.",
					sqlExp);
		} catch (Exception exception) {
			logger.error(
					SettingDaoImpl.class
							+ "Error: Occur in Query While Closing Connection After Fetching the PRODUCT CATEGORY  Details into Grid from Database.",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return productCategoryList;
	}

	/**
	 * <p>
	 * <code>addProductCategory()</code>this method is design to inserting
	 * Product Category Details into database.
	 * </p>
	 * 
	 * @param companyVO
	 * @return Target
	 * @throws OMIApplicationException
	 */
	@Override
	public int addProductCategory(CompanyVO companyVO)
			throws OMIApplicationException {
		int target = 0;
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.INSERT_PRODUCT_CATEGORY);
			preparedStatement.setString(1, companyVO.getProductCategory());
			preparedStatement.executeUpdate();
			target = 1;

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					SettingDaoImpl.class
							+ "Error: Occur in Query While inserting the Product Category into Database.",
					sqlException);

		} catch (Exception exception) {

			exception.printStackTrace();
			logger.error(
					SettingDaoImpl.class
							+ "Error: Occur in Query While closing connection after inserting the Product Category into Database.",
					exception);
		} finally {
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return target;

	}

	/**
	 * <p>
	 * <code>addCompanySector()</code>this method is design to inserting Company
	 * Sector Details into database.
	 * </p>
	 * 
	 * @param companyVO
	 * @return Target
	 * @throws OMIApplicationException
	 */
	@Override
	public int addCompanySector(CompanyVO companyVO)
			throws OMIApplicationException {
		int target = 0;
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.INSERT_COMPANY_SECTOR);
			preparedStatement.setString(1, companyVO.getSector());
			preparedStatement.executeUpdate();
			target = 1;

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					SettingDaoImpl.class
							+ "Error: Occur in Query While inserting the Company Sector into Database.",
					sqlException);

		} catch (Exception exception) {

			exception.printStackTrace();
			logger.error(
					SettingDaoImpl.class
							+ "Error: Occur in Query While closing connection after inserting the Company Sector into Database.",
					exception);
		} finally {
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return target;

	}

	/**
	 * <p>
	 * <code>showCompanySectorList()</code>this method is design for getting
	 * Company Sector Details from database.
	 * </p>
	 * 
	 * 
	 * @return companySectorList
	 * @throws OMIApplicationException
	 */
	@Override
	public List<CompanyVO> showCompanySectorList()
			throws OMIApplicationException {

		List<CompanyVO> companySectorList = new ArrayList<CompanyVO>();
		CompanyVO companyVO = null;
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_COMPANY_SECTOR_GIRD_LIST);
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {
					companyVO = new CompanyVO();
					companyVO.setCompanysectorid(resultSet
							.getInt("COMPANY_SECTOR_ID"));
					companyVO.setSector(resultSet
							.getString("COMPANY_SECTOR_NAME"));
					companySectorList.add(companyVO);

				}
			}
		} catch (SQLException sqlExp) {
			logger.error(
					SettingDaoImpl.class
							+ "Error: Occur in Query While Fetching the Company Sector Details into Grid from Database.",
					sqlExp);
		} catch (Exception exception) {
			logger.error(
					SettingDaoImpl.class
							+ "Error: Occur in Query While Closing Connection After Fetching the Company Sector Details into Grid from Database.",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return companySectorList;
	}

	/**
	 * <p>
	 * <code>addFinanceGLAccount()</code>this method is design to inserting GL
	 * Account Details into database.
	 * </p>
	 * 
	 * @param companyVO
	 * @return Target
	 * @throws OMIApplicationException
	 */
	@Override
	public int addFinanceGLAccount(CompanyVO companyVO)
			throws OMIApplicationException {
		int target = 0;
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.INSERT_FINANCE_GLACCOUNT);
			preparedStatement.setString(1, companyVO.getGlAccounttype());
			preparedStatement.setString(2, companyVO.getGlAccount());
			preparedStatement.setString(3, companyVO.getDescription());
			preparedStatement.executeUpdate();
			target = 1;

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					SettingDaoImpl.class
							+ "Error: Occur in Query While inserting the GL Account into Database.",
					sqlException);

		} catch (Exception exception) {

			exception.printStackTrace();
			logger.error(
					SettingDaoImpl.class
							+ "Error: Occur in Query While closing connection after inserting the GL Account into Database.",
					exception);
		} finally {
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return target;
	}

	/**
	 * <p>
	 * <code>showFinanaceGLAccountList()</code>this method is design for getting
	 * GL Account Details from database.
	 * </p>
	 * 
	 * 
	 * @return financeGLAccountList
	 * @throws OMIApplicationException
	 */
	@Override
	public List<CompanyVO> showFinanaceGLAccountList()
			throws OMIApplicationException {

		List<CompanyVO> financeGLAccountList = new ArrayList<CompanyVO>();
		CompanyVO companyVO = null;
		try {

			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_FINANCE_GLACCOUNT_GIRD_LIST);
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {
					companyVO = new CompanyVO();
					companyVO.setFinanceId(resultSet.getInt("GL_ACCOUNT_ID"));
					companyVO.setGlAccounttype(GlAccountType
							.getGlAccountType(resultSet
									.getInt("GL_ACCOUNT_TYPE")));
					companyVO.setGlAccount(resultSet
							.getString("GL_ACCOUNT_NAME"));
					// companyVO.setDescription(resultSet.getString("DESCRIPTION"));

					financeGLAccountList.add(companyVO);

				}
			}
		} catch (SQLException sqlExp) {
			logger.error(
					SettingDaoImpl.class
							+ "Error: Occur in Query While Fetching the GL_ACCOUNT Details into Grid from Database.",
					sqlExp);
		} catch (Exception exception) {
			logger.error(
					SettingDaoImpl.class
							+ "Error: Occur in Query While Closing Connection After Fetching the GL_ACCOUNT Details into Grid from Database.",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return financeGLAccountList;
	}

	/**
	 * <p>
	 * <code>addMarketingLeadSource()</code>this method is design to inserting
	 * Lead Source Details into database.
	 * </p>
	 * 
	 * @param companyVO
	 * @return Target
	 * @throws OMIApplicationException
	 */
	@Override
	public int addMarketingLeadSource(CompanyVO companyVO)
			throws OMIApplicationException {
		int target = 0;
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.INSERT_LEAD_SOURCE);
			preparedStatement.setString(1, companyVO.getLeadsource());
			preparedStatement.executeUpdate();
			target = 1;

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					SettingDaoImpl.class
							+ "Error: Occur in Query While inserting the lead source into Database.",
					sqlException);

		} catch (Exception exception) {

			exception.printStackTrace();
			logger.error(
					SettingDaoImpl.class
							+ "Error: Occur in Query While closing connection after inserting the Lead Source into Database.",
					exception);
		} finally {
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return target;
	}

	/**
	 * <p>
	 * <code>showMarketingLeadSourceList()</code>this method is design for
	 * getting Lead source Details from database.
	 * </p>
	 * 
	 * 
	 * @return MarketingLeadSourceList
	 * @throws OMIApplicationException
	 */
	@Override
	public List<CompanyVO> showMarketingLeadSourceList()
			throws OMIApplicationException {

		List<CompanyVO> MarketingLeadSourceList = new ArrayList<CompanyVO>();
		CompanyVO companyVO = null;
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_LEAD_SOURCE_GIRD_LIST);
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {
					companyVO = new CompanyVO();
					companyVO.setLeadsourceID(resultSet
							.getInt("LEAD_SOURCE_ID"));
					companyVO.setLeadsource(resultSet
							.getString("LEAD_SOURCE_NAME"));
					MarketingLeadSourceList.add(companyVO);

				}
			}
		} catch (SQLException sqlExp) {
			logger.error(
					SettingDaoImpl.class
							+ "Error: Occur in Query While Fetching the Lead Source  Details into Grid from Database.",
					sqlExp);
		} catch (Exception exception) {
			logger.error(
					SettingDaoImpl.class
							+ "Error: Occur in Query While Closing Connection After Fetching the lead source Details into Grid from Database.",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return MarketingLeadSourceList;
	}

	/**
	 * <p>
	 * <code>addMarketingAccountType()</code>this method is design to inserting
	 * Account Type Details into database.
	 * </p>
	 * 
	 * @param companyVO
	 * @return Target
	 * @throws OMIApplicationException
	 */
	@Override
	public int addMarketingAccountType(CompanyVO companyVO)
			throws OMIApplicationException {
		int target = 0;
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.INSERT_ACCOUNT_TYPE);
			preparedStatement.setString(1, companyVO.getAccountType());
			preparedStatement.executeUpdate();
			target = 1;

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					SettingDaoImpl.class
							+ "Error: Occur in Query While inserting the Account Type into Database.",
					sqlException);

		} catch (Exception exception) {

			exception.printStackTrace();
			logger.error(
					SettingDaoImpl.class
							+ "Error: Occur in Query While closing connection after inserting the Account Type into Database.",
					exception);
		} finally {
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return target;
	}

	/**
	 * <p>
	 * <code>showMarketingAccountTypeList()</code>this method is design for
	 * getting Account type Details from database.
	 * </p>
	 * 
	 * 
	 * @return MarketingAccountTypeList
	 * @throws OMIApplicationException
	 */
	@Override
	public List<CompanyVO> showMarketingAccountTypeList()
			throws OMIApplicationException {
		List<CompanyVO> MarketingAccountTypeList = new ArrayList<CompanyVO>();
		CompanyVO companyVO = null;
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_ACCOUNT_TYPE_GIRD_LIST);
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {
					companyVO = new CompanyVO();
					companyVO.setAccountTypeId(resultSet
							.getInt("ACCOUNT_TYPE_ID"));
					companyVO.setAccountType(resultSet
							.getString("ACCOUNT_TYPE_NAME"));
					MarketingAccountTypeList.add(companyVO);

				}
			}
		} catch (SQLException sqlExp) {
			logger.error(
					SettingDaoImpl.class
							+ "Error: Occur in Query While Fetching the Account Type  Details into Grid from Database.",
					sqlExp);
		} catch (Exception exception) {
			logger.error(
					SettingDaoImpl.class
							+ "Error: Occur in Query While Closing Connection After Fetching the Account Type Details into Grid from Database.",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return MarketingAccountTypeList;
	}

	/**
	 * <p>
	 * <code>addMarketingCampaignType()</code>this method is design to inserting
	 * Campaign Type Details into database.
	 * </p>
	 * 
	 * @param companyVO
	 * @return Target
	 * @throws OMIApplicationException
	 */
	@Override
	public int addMarketingCampaignType(CompanyVO companyVO)
			throws OMIApplicationException {
		int target = 0;
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.INSERT_CAMPAIGN_TYPE);
			preparedStatement.setString(1, companyVO.getCampaigntype());
			preparedStatement.executeUpdate();
			target = 1;

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					SettingDaoImpl.class
							+ "Error: Occur in Query While inserting the Campaign Type into Database.",
					sqlException);

		} catch (Exception exception) {

			exception.printStackTrace();
			logger.error(
					SettingDaoImpl.class
							+ "Error: Occur in Query While closing connection after inserting the Campaign  Type into Database.",
					exception);
		} finally {
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return target;
	}

	/**
	 * <p>
	 * <code>showMarketingCampaignTypeList()</code>this method is design for
	 * getting Campaign Type Details from database.
	 * </p>
	 * 
	 * 
	 * @return MarketingCampaignTypeList
	 * @throws OMIApplicationException
	 */
	public List<CompanyVO> showMarketingCampaignTypeList()
			throws OMIApplicationException {
		List<CompanyVO> MarketingCampaignTypeList = new ArrayList<CompanyVO>();
		CompanyVO companyVO = null;
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_CAMPAIGN_TYPE_GIRD_LIST);
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {
					companyVO = new CompanyVO();
					companyVO.setCampaigntypeID(resultSet
							.getInt("CAMPAIGN_TYPE_ID"));
					companyVO.setCampaigntype(resultSet
							.getString("CAMPAIGN_TYPE_NAME"));
					MarketingCampaignTypeList.add(companyVO);

				}
			}
		} catch (SQLException sqlExp) {
			logger.error(
					SettingDaoImpl.class
							+ "Error: Occur in Query While Fetching the Campaign Type  Details into Grid from Database.",
					sqlExp);
		} catch (Exception exception) {
			logger.error(
					SettingDaoImpl.class
							+ "Error: Occur in Query While Closing Connection After Fetching the Campaign Type Details into Grid from Database.",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return MarketingCampaignTypeList;
	}

	/**
	 * <p>
	 * <code>addMarketingResponse()</code>this method is design to inserting
	 * Response Details into database.
	 * </p>
	 * 
	 * @param companyVO
	 * @return Target
	 * @throws OMIApplicationException
	 */
	@Override
	public int addMarketingResponse(CompanyVO companyVO)
			throws OMIApplicationException {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * <p>
	 * <code>showMarketingResponseList()</code>this method is design for getting
	 * Response Details from database.
	 * </p>
	 * 
	 * 
	 * @return
	 * @throws OMIApplicationException
	 */
	@Override
	public List<CompanyVO> showMarketingResponseList()
			throws OMIApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * <p>
	 * <code>addMarketingVendorCategory()</code>this method is design to
	 * inserting Vendor Category Details into database.
	 * </p>
	 * 
	 * @param companyVO
	 * @return Target
	 * @throws OMIApplicationException
	 */
	@Override
	public int addMarketingVendorCategory(CompanyVO companyVO)
			throws OMIApplicationException {
		int target = 0;
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.INSERT_VENDOR_CATEGORY);
			preparedStatement.setString(1, companyVO.getVendorcategory());
			preparedStatement.executeUpdate();
			target = 1;

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					SettingDaoImpl.class
							+ "Error: Occur in Query While inserting the Vendor Category into Database.",
					sqlException);

		} catch (Exception exception) {

			exception.printStackTrace();
			logger.error(
					SettingDaoImpl.class
							+ "Error: Occur in Query While closing connection after inserting the Vendor Category  into Database.",
					exception);
		} finally {
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return target;
	}

	/**
	 * <p>
	 * <code>showMarketingVendorcategoryList()</code>this method is design for
	 * getting Vendor Category Details from database.
	 * </p>
	 * 
	 * 
	 * @return MarketingVendorcategoryList
	 * @throws OMIApplicationException
	 */
	@Override
	public List<CompanyVO> showMarketingVendorcategoryList()
			throws OMIApplicationException {
		List<CompanyVO> MarketingVendorcategoryList = new ArrayList<CompanyVO>();
		CompanyVO companyVO = null;
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_VENDOR_CATEGORY_GIRD_LIST);
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {
					companyVO = new CompanyVO();
					companyVO.setVendorCategoryId(resultSet
							.getInt("VENDOR_CATEGORY_ID"));
					companyVO.setVendorcategory(resultSet
							.getString("VENDOR_CATEGORY_NAME"));
					MarketingVendorcategoryList.add(companyVO);

				}
			}
		} catch (SQLException sqlExp) {
			logger.error(
					SettingDaoImpl.class
							+ "Error: Occur in Query While Fetching the Vendor Category  Details into Grid from Database.",
					sqlExp);
		} catch (Exception exception) {
			logger.error(
					SettingDaoImpl.class
							+ "Error: Occur in Query While Closing Connection After Fetching the Vendor category Details into Grid from Database.",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return MarketingVendorcategoryList;
	}

	/**
	 * <p>
	 * <code>addMarketingTravelMode()</code>this method is design to inserting
	 * Travel Mode Details into database.
	 * </p>
	 * 
	 * @param companyVO
	 * @return Target
	 * @throws OMIApplicationException
	 */
	@Override
	public int addMarketingTravelMode(CompanyVO companyVO)
			throws OMIApplicationException {
		int target = 0;
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.INSERT_TRAVEL_MODE);
			preparedStatement.setString(1, companyVO.getTravelmode());
			preparedStatement.executeUpdate();
			target = 1;

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					SettingDaoImpl.class
							+ "Error: Occur in Query While inserting the Travel Mode into Database.",
					sqlException);

		} catch (Exception exception) {

			exception.printStackTrace();
			logger.error(
					SettingDaoImpl.class
							+ "Error: Occur in Query While closing connection after inserting the Travel Mode  into Database.",
					exception);
		} finally {
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return target;
	}

	/**
	 * <p>
	 * <code>showMarketingtravelModeList()</code>this method is design for
	 * getting Travel Mode Details from database.
	 * </p>
	 * 
	 * 
	 * @return MarketingtravelModeList
	 * @throws OMIApplicationException
	 */
	@Override
	public List<CompanyVO> showMarketingtravelModeList()
			throws OMIApplicationException {
		List<CompanyVO> MarketingtravelModeList = new ArrayList<CompanyVO>();
		CompanyVO companyVO = null;
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_TRAVEL_MODE_GIRD_LIST);
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {
					companyVO = new CompanyVO();
					companyVO.setTravelmodeID(resultSet
							.getInt("TRAVEL_MODE_ID"));
					companyVO.setTravelmode(resultSet.getString("TRAVEL_MODE"));
					MarketingtravelModeList.add(companyVO);

				}
			}
		} catch (SQLException sqlExp) {
			logger.error(
					SettingDaoImpl.class
							+ "Error: Occur in Query While Fetching the Travel Mode  Details into Grid from Database.",
					sqlExp);
		} catch (Exception exception) {
			logger.error(
					SettingDaoImpl.class
							+ "Error: Occur in Query While Closing Connection After Fetching the Travel Mode   Details into Grid from Database.",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return MarketingtravelModeList;
	}

	/**
	 * <p>
	 * <code>addSupportFAQCategory()</code>this method is design to inserting
	 * FAQ Category Details into database.
	 * </p>
	 * 
	 * @param companyVO
	 * @return Target
	 * @throws OMIApplicationException
	 */
	@Override
	public int addSupportFAQCategory(CompanyVO companyVO)
			throws OMIApplicationException {
		int target = 0;
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.INSERT_FAQ_CATEGORY);
			preparedStatement.setString(1, companyVO.getFaqcategory());
			preparedStatement.executeUpdate();
			target = 1;

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					SettingDaoImpl.class
							+ "Error: Occur in Query While inserting the FAQ Category into Database.",
					sqlException);

		} catch (Exception exception) {

			exception.printStackTrace();
			logger.error(
					SettingDaoImpl.class
							+ "Error: Occur in Query While closing connection after inserting the FAQ Category  into Database.",
					exception);
		} finally {
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return target;
	}

	/**
	 * <p>
	 * <code>showSupportfaqCategoryList()</code>this method is design for
	 * getting FAQ Category Details from database.
	 * </p>
	 * 
	 * 
	 * @return supportFAQCategory
	 * @throws OMIApplicationException
	 */
	@Override
	public List<CompanyVO> showSupportfaqCategoryList()
			throws OMIApplicationException {
		List<CompanyVO> supportFAQCategory = new ArrayList<CompanyVO>();
		CompanyVO companyVO = null;
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_FAQ_CATEGORY_GIRD_LIST);
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {
					companyVO = new CompanyVO();
					companyVO.setFaqcategoryId(resultSet.getInt("CATEGORY_ID"));
					companyVO.setFaqcategory(resultSet
							.getString("CATEGORY_NAME"));
					supportFAQCategory.add(companyVO);

				}
			}
		} catch (SQLException sqlExp) {
			logger.error(
					SettingDaoImpl.class
							+ "Error: Occur in Query While Fetching the FAQ Category Details into Grid from Database.",
					sqlExp);
		} catch (Exception exception) {
			logger.error(
					SettingDaoImpl.class
							+ "Error: Occur in Query While Closing Connection After Fetching the FAQ Category Details into Grid from Database.",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return supportFAQCategory;
	}

	/**
	 * <p>
	 * <code>addSupportChannel()</code>this method is design to inserting
	 * Channel Details into database.
	 * </p>
	 * 
	 * @param companyVO
	 * @return Target
	 * @throws OMIApplicationException
	 */
	@Override
	public int addSupportChannel(CompanyVO companyVO)
			throws OMIApplicationException {
		int target = 0;
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.INSERT_CHANNEL);
			preparedStatement.setString(1, companyVO.getChannel());
			preparedStatement.executeUpdate();
			target = 1;

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					SettingDaoImpl.class
							+ "Error: Occur in Query While inserting the Channel into Database.",
					sqlException);

		} catch (Exception exception) {

			exception.printStackTrace();
			logger.error(
					SettingDaoImpl.class
							+ "Error: Occur in Query While closing connection after inserting the Channel  into Database.",
					exception);
		} finally {
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return target;
	}

	/**
	 * <p>
	 * <code>showSupportChannelList()</code>this method is design for getting
	 * Channel Details from database.
	 * </p>
	 * 
	 * 
	 * @return supportChannel
	 * @throws OMIApplicationException
	 */
	@Override
	public List<CompanyVO> showSupportChannelList()
			throws OMIApplicationException {
		List<CompanyVO> supportChannel = new ArrayList<CompanyVO>();
		CompanyVO companyVO = null;
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_CHANNEL_GIRD_LIST);
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {
					companyVO = new CompanyVO();
					companyVO.setChannelId(resultSet.getInt("CHANNEL_ID"));
					companyVO.setChannel(resultSet.getString("CHANNEL_NAME"));
					supportChannel.add(companyVO);

				}
			}
		} catch (SQLException sqlExp) {
			logger.error(
					SettingDaoImpl.class
							+ "Error: Occur in Query While Fetching the Channel Details into Grid from Database.",
					sqlExp);
		} catch (Exception exception) {
			logger.error(
					SettingDaoImpl.class
							+ "Error: Occur in Query While Closing Connection After Fetching the Channel Details into Grid from Database.",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return supportChannel;
	}

	/**
	 * <p>
	 * <code>addSupportTaskArea()</code>this method is design to inserting Task
	 * Area Details into database.
	 * </p>
	 * 
	 * @param companyVO
	 * @return Target
	 * @throws OMIApplicationException
	 */
	@Override
	public int addSupportTaskArea(CompanyVO companyVO)
			throws OMIApplicationException {
		int target = 0;
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.INSERT_TASK_AREA);
			preparedStatement.setString(1, companyVO.getTaskarea());
			preparedStatement.executeUpdate();
			target = 1;

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					SettingDaoImpl.class
							+ "Error: Occur in Query While inserting the Task Area into Database.",
					sqlException);

		} catch (Exception exception) {

			exception.printStackTrace();
			logger.error(
					SettingDaoImpl.class
							+ "Error: Occur in Query While closing connection after inserting the Task Area  into Database.",
					exception);
		} finally {
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return target;
	}

	/**
	 * <p>
	 * <code>showSupportTaskAreaList()</code>this method is design for getting
	 * task Area Details from database.
	 * </p>
	 * 
	 * 
	 * @return supportTaskArea
	 * @throws OMIApplicationException
	 */
	@Override
	public List<CompanyVO> showSupportTaskAreaList()
			throws OMIApplicationException {
		List<CompanyVO> supportTaskArea = new ArrayList<CompanyVO>();
		CompanyVO companyVO = null;
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_TASK_AREA_GIRD_LIST);
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {
					companyVO = new CompanyVO();
					companyVO.setTaskareaId(resultSet.getInt("TASK_AREA_ID"));
					companyVO.setTaskarea(resultSet.getString("TASK_AREA"));
					supportTaskArea.add(companyVO);

				}
			}
		} catch (SQLException sqlExp) {
			logger.error(
					SettingDaoImpl.class
							+ "Error: Occur in Query While Fetching the Task Area Details into Grid from Database.",
					sqlExp);
		} catch (Exception exception) {
			logger.error(
					SettingDaoImpl.class
							+ "Error: Occur in Query While Closing Connection After Fetching the Task Area Details into Grid from Database.",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return supportTaskArea;
	}

	/**
	 * <p>
	 * <code>addSupportCaseImpact()</code>this method is design to inserting
	 * Cases Impact Details into database.
	 * </p>
	 * 
	 * @param companyVO
	 * @return Target
	 * @throws OMIApplicationException
	 */
	@Override
	public int addSupportCaseImpact(CompanyVO companyVO)
			throws OMIApplicationException {
		int target = 0;
		try {

			connection = getConnection();

			CallableStatement call = connection
					.prepareCall("{call procCaseImpact(?,?,?)}");
			call.setString(1, companyVO.getCaseimpactarea());
			call.setString(2, companyVO.getCaseimpacttype());
			call.setString(3, companyVO.getResolutiontype());
			call.executeUpdate();
			target = 1;

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					SettingDaoImpl.class
							+ "Error: Occur in Query While inserting the cases Impact into Database.",
					sqlException);

		} catch (Exception exception) {

			exception.printStackTrace();
			logger.error(
					SettingDaoImpl.class
							+ "Error: Occur in Query While closing connection after inserting the case Impact into Database.",
					exception);
		} finally {
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return target;
	}

	/**
	 * <p>
	 * <code>showSupportCaseImpactList()</code>this method is design for getting
	 * Cases Impact Details from database.
	 * </p>
	 * 
	 * 
	 * @return null
	 * @throws OMIApplicationException
	 */
	@Override
	public List<CompanyVO> showSupportCaseImpactList()
			throws OMIApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * <p>
	 * <code>updateCompanyLocal()</code>this method is design to Updating
	 * Company Local Details into database.
	 * </p>
	 * 
	 * @param companyVO
	 * @return Target
	 * @throws OMIApplicationException
	 */
	@Override
	public int updateCompanyLocal(CompanyVO companyVO, int customerId)
			throws OMIApplicationException {
		int target = 0;
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.UPDATE_COMPANY_LOCAL);

			preparedStatement.setString(1, companyVO.getCurrency());
			preparedStatement.setString(2, companyVO.getCountryName());
			preparedStatement.setInt(3, companyVO.getTimezone());
			preparedStatement.setString(4, companyVO.getLanguage());
			preparedStatement.setInt(5, customerId);

			preparedStatement.executeUpdate();
			target = 1;

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					SettingDaoImpl.class
							+ "Error: Occur in Query While Updating the Company Local into Database.",
					sqlException);

		} catch (Exception exception) {

			exception.printStackTrace();
			logger.error(
					SettingDaoImpl.class
							+ "Error: Occur in Query While closing connection after Updating the Company local  into Database.",
					exception);
		} finally {
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return target;
	}

	/**
	 * <p>
	 * <code>showCompanyLocalList()</code>this method is design for getting
	 * Company Local Details from database.
	 * </p>
	 * 
	 * 
	 * @return null
	 * @throws OMIApplicationException
	 */
	@Override
	public List<CompanyVO> showCompanyLocalList()
			throws OMIApplicationException {/*
											 * List<CompanyVO> companyLocalList
											 * = new ArrayList<CompanyVO>();
											 * CompanyVO companyVO = null; try {
											 * connection = getConnection();
											 * preparedStatement = connection
											 * .prepareStatement(QueryMaker.);
											 * resultSet =
											 * preparedStatement.executeQuery();
											 * if (resultSet != null) { while
											 * (resultSet.next()) { companyVO =
											 * new CompanyVO();
											 * 
											 * companyVO.setCurrency(resultSet.
											 * getString("REF_CURRENCY"));
											 * companyVO
											 * .setCountry(resultSet.getInt
											 * ("REF_COUNTRY"));
											 * companyVO.setLanguage
											 * (resultSet.getString
											 * ("LANGUAGE"));
											 * companyVO.setTimezone
											 * (resultSet.getInt("TIME_ZONE"));
											 * companyLocalList.add(companyVO);
											 * 
											 * } } } catch (SQLException sqlExp)
											 * { logger.error(
											 * SettingDaoImpl.class +
											 * "Error: Occur in Query While Fetching the Company Local Details into Grid from Database."
											 * , sqlExp); } catch (Exception
											 * exception) { logger.error(
											 * SettingDaoImpl.class +
											 * "Error: Occur in Query While Closing Connection After Fetching the Company Local Details into Grid from Database."
											 * , exception); } finally {
											 * JdbcHelper
											 * .closeResultSet(resultSet);
											 * JdbcHelper
											 * .closePreparedStatement(
											 * preparedStatement);
											 * JdbcHelper.closeConnection
											 * (connection); } return
											 * companyLocalList;
											 */
		return null;
	}

	/**
	 * <p>
	 * <code>addProductUsesUnit()</code>this method is design to inserting
	 * Product Uses Unit Details into database.
	 * </p>
	 * 
	 * @param companyVO
	 * @return Target
	 * @throws OMIApplicationException
	 */
	@Override
	public int addProductUsesUnit(CompanyVO companyVO)
			throws OMIApplicationException {
		int target = 0;
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.INSERT_PRODUCT_USES_UNIT);

			preparedStatement.setString(1, companyVO.getProductUsesUnit());
			preparedStatement.executeUpdate();
			target = 1;

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					SettingDaoImpl.class
							+ "Error: Occur in Query While Updating the Product Uses Unit into Database.",
					sqlException);

		} catch (Exception exception) {

			exception.printStackTrace();
			logger.error(
					SettingDaoImpl.class
							+ "Error: Occur in Query While closing connection after Updating the Product Uses Unit into Database.",
					exception);
		} finally {
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return target;
	}

	/**
	 * <p>
	 * <code>showProductUsesUnitList()</code>this method is design to get
	 * Product Uses Unit Details from database.
	 * </p>
	 * 
	 * 
	 * @return usesUnitList
	 * @throws OMIApplicationException
	 */
	@Override
	public List<CompanyVO> showProductUsesUnitList()
			throws OMIApplicationException {
		List<CompanyVO> usesUnitList = new ArrayList<CompanyVO>();
		CompanyVO companyVO = null;
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_PRODUCT_USES_UNIT_LIST);
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {
					companyVO = new CompanyVO();
					companyVO.setProductUsesUnitId(resultSet
							.getInt("PRODUCT_USAGE_UNIT_ID"));
					companyVO.setProductUsesUnit(resultSet
							.getString("PRODUCT_USAGE_UNIT_NAME"));

					usesUnitList.add(companyVO);

				}
			}
		} catch (SQLException sqlExp) {
			logger.error(
					SettingDaoImpl.class
							+ "Error: Occur in Query While Fetching the Product Uses Unit Details into Grid from Database.",
					sqlExp);
		} catch (Exception exception) {
			logger.error(
					SettingDaoImpl.class
							+ "Error: Occur in Query While Closing Connection After Fetching the Product Uses Unit Details into Grid from Database.",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return usesUnitList;
	}

	/**
	 * <p>
	 * <code>getCompanyTypeDetailsForUpdate()</code>this method is design to get
	 * Company Type Details from database.
	 * </p>
	 * 
	 * @param companyTypeId
	 * @return company
	 * @throws OMIApplicationException
	 */
	@Override
	public Company showCompanyTypeDetailsForUpdate(int companyTypeId)
			throws OMIApplicationException {
		company = new Company();
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.EDIT_COMPANY_TYPE);
			preparedStatement.setInt(1, companyTypeId);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				company.setCompanyType(resultSet.getString("COMPANY_TYPE_NAME"));
			}

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					SettingDaoImpl.class
							+ ": Error:- Error: Occur in Query While fetching the Company Type details for view from Database",
					sqlException);

		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					SettingDaoImpl.class
							+ ": Error:- While closing the Connection after fetching the Company Type details for view from Database",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return company;
	}

	/**
	 * <p>
	 * <code>updateCompanyTypeInfo()</code>this method Updating Company Type
	 * Details into database.
	 * </p>
	 * 
	 * @param companyTypeId
	 *            ,companyVO
	 * @return target
	 * @throws OMIApplicationException
	 */
	@Override
	public int updateCompanyTypeInfo(CompanyVO companyVO, int companyTypeId)
			throws Exception {
		int target = 0;
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.UPADATING_COMPANY_TYPE);
			System.out.println("in settingDaoImpl");

			preparedStatement.setString(1, companyVO.getCompanyType());
			preparedStatement.setInt(2, companyTypeId);
			preparedStatement.executeUpdate();
			/*
			 * System.out.println("company type id"+companyTypeId);
			 * System.out.println("company type"+companyVO.getCompanyType());
			 */
			target = 1;

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					SettingDaoImpl.class
							+ "Error: Occur in Query While Updating the Company Type into Database.",
					sqlException);

		} catch (Exception exception) {

			exception.printStackTrace();
			logger.error(
					SettingDaoImpl.class
							+ "Error: Occur in Query While closing connection after Updating the Company Type into Database.",
					exception);
		} finally {
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return target;
	}

	/**
	 * <p>
	 * <code>showGLAccountDetails()</code>this method is design to get GL
	 * Account Details from database.
	 * </p>
	 * 
	 * @param financeId
	 * @return company
	 * @throws OMIApplicationException
	 */
	@Override
	public Company showGLAccountDetails(int financeId)
			throws OMIApplicationException {
		company = new Company();
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.EDIT_GL_ACCOUNT);
			preparedStatement.setInt(1, financeId);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				// company.setGlAccount(resultSet.getString(""));
				company.setGlAccounttype(resultSet.getString("GL_ACCOUNT_TYPE"));
				company.setGlAccountName(resultSet.getString("GL_ACCOUNT_NAME"));
				company.setDescription(resultSet.getString("DESCRIPTION"));
			}

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					SettingDaoImpl.class
							+ ": Error:- Error: Occur in Query While fetching the GL Account details for view from Database",
					sqlException);

		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					SettingDaoImpl.class
							+ ": Error:- While closing the Connection after fetching the GL Account details for view from Database",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return company;
	}

	/**
	 * <p>
	 * <code>updateGLAccountDetail()</code>this method Updating GL Account
	 * Details into database.
	 * </p>
	 * 
	 * @param financeId
	 *            ,companyVO
	 * @return target
	 * @throws OMIApplicationException
	 */
	@Override
	public int updateGLAccountDetail(CompanyVO companyVO, int financeId) {
		int target = 0;
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.UPADATING_GL_ACCOUNT);
			// System.out.println("in settingDaoImpl");

			preparedStatement.setString(1, companyVO.getGlAccounttype());
			preparedStatement.setString(2, companyVO.getGlAccountName());
			preparedStatement.setString(3, companyVO.getDescription());
			preparedStatement.setInt(4, financeId);
			preparedStatement.executeUpdate();
			// System.out.println("company type id"+financeId);
			// System.out.println("company type"+companyVO.getCompanyType());
			target = 1;

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					SettingDaoImpl.class
							+ "Error: Occur in Query While Updating the GL Account into Database.",
					sqlException);

		} catch (Exception exception) {

			exception.printStackTrace();
			logger.error(
					SettingDaoImpl.class
							+ "Error: Occur in Query While closing connection after Updating the GL Account into Database.",
					exception);
		} finally {
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return target;
	}

	/**
	 * <p>
	 * <code>showLeadSourceDetails()</code>this method is design to get Lead
	 * Source Details from database.
	 * </p>
	 * 
	 * @param leadsourceID
	 * @return company
	 * @throws OMIApplicationException
	 */
	@Override
	public Company showLeadSourceDetails(int leadsourceID)
			throws OMIApplicationException {
		company = new Company();
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.EDIT_LEAD_SOURCE);
			preparedStatement.setInt(1, leadsourceID);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				company.setLeadsource(resultSet.getString("LEAD_SOURCE_NAME"));
			}

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					SettingDaoImpl.class
							+ ": Error:- Error: Occur in Query While fetching the Lead Source details for view from Database",
					sqlException);

		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					SettingDaoImpl.class
							+ ": Error:- While closing the Connection after fetching the Lead Source details for view from Database",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return company;

	}

	/**
	 * <p>
	 * <code>updateLeadSourceDetail()</code>this method Updating Lead Source
	 * Details into database.
	 * </p>
	 * 
	 * @param leadsourceID
	 *            ,companyVO
	 * @return target
	 * @throws OMIApplicationException
	 */
	@Override
	public int updateLeadSourceDetail(CompanyVO companyVO, int leadsourceID)
			throws OMIApplicationException {
		int target = 0;
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.UPADATING_LEAD_SOURCE);
			// System.out.println("in settingDaoImpl");

			preparedStatement.setString(1, companyVO.getLeadsource());
			preparedStatement.setInt(2, leadsourceID);
			preparedStatement.executeUpdate();
			// System.out.println("company type id"+financeId);
			// System.out.println("company type"+companyVO.getCompanyType());
			target = 1;

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					SettingDaoImpl.class
							+ "Error: Occur in Query While Updating the Lead Source into Database.",
					sqlException);

		} catch (Exception exception) {

			exception.printStackTrace();
			logger.error(
					SettingDaoImpl.class
							+ "Error: Occur in Query While closing connection after Updating the Lead Source into Database.",
					exception);
		} finally {
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return target;

	}

	/**
	 * <p>
	 * <code>showTaxDetails()</code>this method is design to get tax Details
	 * from database.
	 * </p>
	 * 
	 * @param financeId
	 * @return company
	 * @throws OMIApplicationException
	 */
	@Override
	public Company showTaxDetails(int financeId) throws OMIApplicationException {
		company = new Company();
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.EDIT_TAX);
			preparedStatement.setInt(1, financeId);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				company.setTaxDisplayName(resultSet
						.getString("TAX_DISPLAY_NAME"));
				company.setTaxNameOne(resultSet.getString("TAX_NAME_ONE"));
				company.setTaxRateOne(resultSet.getString("TAX_RATE_ONE"));
				company.setTaxNameTwo(resultSet.getString("TAX_NAME_TWO"));
				company.setTaxRateTwo(resultSet.getString("TAX_RATE_TWO"));
				company.setTaxNameThree(resultSet.getString("TAX_NAME_THREE"));
				company.setTaxRateThree(resultSet.getString("TAX_RATE_THREE"));
				company.setTaxNameFour(resultSet.getString("TAX_NAME_FOUR"));
				company.setTaxRateFour(resultSet.getString("TAX_RATE_FOUR"));
				company.setTaxNameFive(resultSet.getString("TAX_NAME_FIVE"));
				company.setTaxRateFive(resultSet.getString("TAX_RATE_FIVE"));
				company.setTaxTotal(resultSet.getString("TAX_TOTAL"));
				company.setTaxCreatedDate(resultSet
						.getString("TAX_CREATED_DATE"));
				company.setTaxCreatedBy(resultSet.getInt("TAX_CREATED_BY"));
				company.setTaxUpdatedBy(resultSet.getInt("UPDATED_BY"));
				company.setTaxUpdatedDate(resultSet.getString("UPDATED_DATE"));
			}

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					SettingDaoImpl.class
							+ ": Error:- Error: Occur in Query While fetching the Tax details for view from Database",
					sqlException);

		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					SettingDaoImpl.class
							+ ": Error:- While closing the Connection after fetching the Tax details for view from Database",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return company;

	}

	/**
	 * <p>
	 * <code>updateLeadSourceDetail()</code>this method Updating Lead Source
	 * Details into database.
	 * </p>
	 * 
	 * @param leadsourceID
	 *            ,companyVO
	 * @return target
	 * @throws OMIApplicationException
	 */
	@Override
	public int updateTaxDetail(CompanyVO companyVO, int financeId)
			throws OMIApplicationException {
		int target = 0;
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.UPADATING_TAX);
			// System.out.println("in settingDaoImpl");

			preparedStatement.setString(1, companyVO.getTaxDisplayName());
			preparedStatement.setString(2, companyVO.getTaxNameOne());
			preparedStatement.setString(3, companyVO.getTaxRateOne());
			preparedStatement.setString(4, companyVO.getTaxNameTwo());
			preparedStatement.setString(5, companyVO.getTaxRateTwo());
			preparedStatement.setString(6, companyVO.getTaxNameThree());
			preparedStatement.setString(7, companyVO.getTaxRateThree());
			preparedStatement.setString(8, companyVO.getTaxNameFour());
			preparedStatement.setString(9, companyVO.getTaxRateFour());
			preparedStatement.setString(10, companyVO.getTaxNameFive());
			preparedStatement.setString(11, companyVO.getTaxRateFive());
			preparedStatement.setString(12, companyVO.getTaxTotal());
			preparedStatement.setString(13, companyVO.getTaxCreatedDate());
			preparedStatement.setInt(14, companyVO.getTaxCreatedBy());
			preparedStatement.setInt(15, companyVO.getTaxUpdatedBy());
			preparedStatement.setString(16, companyVO.getTaxUpdatedDate());
			preparedStatement.setInt(17, financeId);
			preparedStatement.executeUpdate();
			// System.out.println("company type id"+financeId);
			// System.out.println("company type"+companyVO.getCompanyType());
			target = 1;

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					SettingDaoImpl.class
							+ "Error: Occur in Query While Updating the TAX into Database.",
					sqlException);

		} catch (Exception exception) {

			exception.printStackTrace();
			logger.error(
					SettingDaoImpl.class
							+ "Error: Occur in Query While closing connection after Updating the Tax into Database.",
					exception);
		} finally {
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return target;

	}

	/**
	 * <p>
	 * <code>showCompanyCategoryDetails()</code>this method is design to get
	 * Company Category Details from database.
	 * </p>
	 * 
	 * @param companyCategoryID
	 * @return company
	 * @throws OMIApplicationException
	 */
	@Override
	public Company showCompanyCategoryDetails(int companyCategoryID)
			throws OMIApplicationException {
		company = new Company();
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.EDIT_COMPANY_CATEGORY);
			preparedStatement.setInt(1, companyCategoryID);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				company.setCategory(resultSet
						.getString("COMPANY_CATEGORY_NAME"));
			}

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					SettingDaoImpl.class
							+ ": Error:- Error: Occur in Query While fetching the Company Category details for view from Database",
					sqlException);

		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					SettingDaoImpl.class
							+ ": Error:- While closing the Connection after fetching the Company Category details for view from Database",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return company;

	}

	/**
	 * <p>
	 * <code>updateCompanyCategoryDetail()</code>this method Updating Company
	 * Category Details into database.
	 * </p>
	 * 
	 * @param companyCategoryID
	 *            ,companyVO
	 * @return target
	 * @throws OMIApplicationException
	 */
	@Override
	public int updateCompanyCategoryDetail(CompanyVO companyVO,
			int companyCategoryID) throws OMIApplicationException {
		int target = 0;
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.UPADATING_COMPANY_CATEGORY);
			// System.out.println("in settingDaoImpl");

			preparedStatement.setString(1, companyVO.getCategory());
			preparedStatement.setInt(2, companyCategoryID);
			preparedStatement.executeUpdate();
			// System.out.println("company type id"+financeId);
			// System.out.println("company type"+companyVO.getCompanyType());
			target = 1;

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					SettingDaoImpl.class
							+ "Error: Occur in Query While Updating the Company Category into Database.",
					sqlException);

		} catch (Exception exception) {

			exception.printStackTrace();
			logger.error(
					SettingDaoImpl.class
							+ "Error: Occur in Query While closing connection after Updating the Company Category into Database.",
					exception);
		} finally {
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return target;
	}

	/**
	 * <p>
	 * <code>showCompanySectorDetails()</code>this method is design to get
	 * Company Sector Details from database.
	 * </p>
	 * 
	 * @param companysectorid
	 * @return company
	 * @throws OMIApplicationException
	 */
	@Override
	public Company showCompanySectorDetails(int companysectorid)
			throws OMIApplicationException {
		company = new Company();
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.EDIT_COMPANY_SECTOR);
			preparedStatement.setInt(1, companysectorid);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				company.setSector(resultSet.getString("COMPANY_SECTOR_NAME"));
			}

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					SettingDaoImpl.class
							+ ": Error:- Error: Occur in Query While fetching the Company Sector details for view from Database",
					sqlException);

		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					SettingDaoImpl.class
							+ ": Error:- While closing the Connection after fetching the Company Sector details for view from Database",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return company;

	}

	/**
	 * <p>
	 * <code>updateCompanySectorDetail()</code>this method Updating Company
	 * Sector Details into database.
	 * </p>
	 * 
	 * @param companysectorid
	 *            ,companyVO
	 * @return target
	 * @throws OMIApplicationException
	 */
	@Override
	public int updateCompanySectorDetail(CompanyVO companyVO,
			int companysectorid) throws OMIApplicationException {
		int target = 0;
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.UPADATING_COMPANY_SECTOR);
			// System.out.println("in settingDaoImpl");

			preparedStatement.setString(1, companyVO.getSector());
			preparedStatement.setInt(2, companysectorid);
			preparedStatement.executeUpdate();
			// System.out.println("company type id"+financeId);
			// System.out.println("company type"+companyVO.getCompanyType());
			target = 1;

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					SettingDaoImpl.class
							+ "Error: Occur in Query While Updating the Company Sector into Database.",
					sqlException);

		} catch (Exception exception) {

			exception.printStackTrace();
			logger.error(
					SettingDaoImpl.class
							+ "Error: Occur in Query While closing connection after Updating the Company Sector into Database.",
					exception);
		} finally {
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return target;

	}

	/**
	 * <p>
	 * <code>showAccounTypeDetails()</code>this method is design to get Account
	 * type Details from database.
	 * </p>
	 * 
	 * @param accountTypeId
	 * @return company
	 * @throws OMIApplicationException
	 */
	@Override
	public Company showAccounTypeDetails(int accountTypeId)
			throws OMIApplicationException {
		company = new Company();
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.EDIT_ACCOUNT_TYPE);
			preparedStatement.setInt(1, accountTypeId);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				company.setAccountType(resultSet.getString("ACCOUNT_TYPE_NAME"));
			}

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					SettingDaoImpl.class
							+ ": Error:- Error: Occur in Query While fetching the Account type details for view from Database",
					sqlException);

		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					SettingDaoImpl.class
							+ ": Error:- While closing the Connection after fetching the Account type details for view from Database",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return company;

	}

	/**
	 * <p>
	 * <code>updateAccountTypeDetail()</code>this method Updating Account type
	 * Details into database.
	 * </p>
	 * 
	 * @param accountTypeId
	 *            ,companyVO
	 * @return target
	 * @throws OMIApplicationException
	 */
	@Override
	public int updateAccountTypeDetail(CompanyVO companyVO, int accountTypeId)
			throws OMIApplicationException {
		int target = 0;
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.UPADATING_ACCOUNT_TYPE);
			// System.out.println("in settingDaoImpl");

			preparedStatement.setString(1, companyVO.getAccountType());
			preparedStatement.setInt(2, accountTypeId);
			preparedStatement.executeUpdate();
			// System.out.println("company type id"+financeId);
			// System.out.println("company type"+companyVO.getCompanyType());
			target = 1;

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					SettingDaoImpl.class
							+ "Error: Occur in Query While Updating the Account type into Database.",
					sqlException);

		} catch (Exception exception) {

			exception.printStackTrace();
			logger.error(
					SettingDaoImpl.class
							+ "Error: Occur in Query While closing connection after Updating the Account type into Database.",
					exception);
		} finally {
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return target;

	}

	/**
	 * <p>
	 * <code>showCampaignTypeDetails()</code>this method is design to get
	 * Campaign type Details from database.
	 * </p>
	 * 
	 * @param campaigntypeID
	 * @return company
	 * @throws OMIApplicationException
	 */
	@Override
	public Company showCampaignTypeDetails(int campaigntypeID)
			throws OMIApplicationException {
		company = new Company();
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.EDIT_CAMPAIGN_TYPE);
			preparedStatement.setInt(1, campaigntypeID);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				company.setCampaigntype(resultSet
						.getString("CAMPAIGN_TYPE_NAME"));
			}

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					SettingDaoImpl.class
							+ ": Error:- Error: Occur in Query While fetching the Campaign type details for view from Database",
					sqlException);

		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					SettingDaoImpl.class
							+ ": Error:- While closing the Connection after fetching the Campaign type details for view from Database",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return company;

	}

	/**
	 * <p>
	 * <code>updateCampaignTypeDetail()</code>this method Updating Campaign type
	 * Details into database.
	 * </p>
	 * 
	 * @param campaigntypeID
	 *            ,companyVO
	 * @return target
	 * @throws OMIApplicationException
	 */
	@Override
	public int updateCampaignTypeDetail(CompanyVO companyVO, int campaigntypeID)
			throws OMIApplicationException {
		int target = 0;
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.UPADATING_CAMPAIGN_TYPE);
			// System.out.println("in settingDaoImpl");

			preparedStatement.setString(1, companyVO.getCampaigntype());
			preparedStatement.setInt(2, campaigntypeID);
			preparedStatement.executeUpdate();
			// System.out.println("company type id"+financeId);
			// System.out.println("company type"+companyVO.getCompanyType());
			target = 1;

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					SettingDaoImpl.class
							+ "Error: Occur in Query While Updating the Campaign type into Database.",
					sqlException);

		} catch (Exception exception) {

			exception.printStackTrace();
			logger.error(
					SettingDaoImpl.class
							+ "Error: Occur in Query While closing connection after Updating the Campaign type into Database.",
					exception);
		} finally {
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return target;

	}

	/**
	 * <p>
	 * <code>showVendorCategoryDetails()</code>this method is design to get
	 * Vendor Category Details from database.
	 * </p>
	 * 
	 * @param vendorCategoryId
	 * @return company
	 * @throws OMIApplicationException
	 */
	@Override
	public Company showVendorCategoryDetails(int vendorCategoryId)
			throws OMIApplicationException {
		company = new Company();
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.EDIT_VENDOR_CATEGORY);
			preparedStatement.setInt(1, vendorCategoryId);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				company.setVendorcategory(resultSet
						.getString("VENDOR_CATEGORY_NAME"));
			}

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					SettingDaoImpl.class
							+ ": Error:- Error: Occur in Query While fetching the vendor Category details for view from Database",
					sqlException);

		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					SettingDaoImpl.class
							+ ": Error:- While closing the Connection after fetching the Vendor Category details for view from Database",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return company;

	}

	/**
	 * <p>
	 * <code>updateVendorCategoryDetail()</code>this method Updating Vendor
	 * Category Details into database.
	 * </p>
	 * 
	 * @param vendorCategoryId
	 *            ,companyVO
	 * @return target
	 * @throws OMIApplicationException
	 */
	@Override
	public int updateVendorCategoryDetail(CompanyVO companyVO,
			int vendorCategoryId) throws OMIApplicationException {
		int target = 0;
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.UPADATING_VENDOR_CATEGORY);
			// System.out.println("in settingDaoImpl");

			preparedStatement.setString(1, companyVO.getVendorcategory());
			preparedStatement.setInt(2, vendorCategoryId);
			preparedStatement.executeUpdate();
			// System.out.println("company type id"+financeId);
			// System.out.println("company type"+companyVO.getCompanyType());
			target = 1;

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					SettingDaoImpl.class
							+ "Error: Occur in Query While Updating the Vendor Category into Database.",
					sqlException);

		} catch (Exception exception) {

			exception.printStackTrace();
			logger.error(
					SettingDaoImpl.class
							+ "Error: Occur in Query While closing connection after Updating the Vendor Category into Database.",
					exception);
		} finally {
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return target;
	}

	/**
	 * <p>
	 * <code>showTravelModeDetails()</code>this method is design to get Travel
	 * Mode Details from database.
	 * </p>
	 * 
	 * @param travelmodeID
	 * @return company
	 * @throws OMIApplicationException
	 */
	@Override
	public Company showTravelModeDetails(int travelmodeID)
			throws OMIApplicationException {
		company = new Company();
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.EDIT_TRAVEL_MODE);
			preparedStatement.setInt(1, travelmodeID);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				company.setTravelmode(resultSet.getString("TRAVEL_MODE"));
			}

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					SettingDaoImpl.class
							+ ": Error:- Error: Occur in Query While fetching the Travel Mode details for view from Database",
					sqlException);

		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					SettingDaoImpl.class
							+ ": Error:- While closing the Connection after fetching the Travel Mode details for view from Database",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return company;

	}

	/**
	 * <p>
	 * <code>updateTravelModeDetail()</code>this method Updating Travel mode
	 * Details into database.
	 * </p>
	 * 
	 * @param travelmodeID
	 *            ,companyVO
	 * @return target
	 * @throws OMIApplicationException
	 */
	@Override
	public int updateTravelModeDetail(CompanyVO companyVO, int travelmodeID)
			throws OMIApplicationException {
		int target = 0;
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.UPADATING_TRAVEL_MODE);
			// System.out.println("in settingDaoImpl");

			preparedStatement.setString(1, companyVO.getTravelmode());
			preparedStatement.setInt(2, travelmodeID);
			preparedStatement.executeUpdate();
			// System.out.println("company type id"+financeId);
			// System.out.println("company type"+companyVO.getCompanyType());
			target = 1;

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					SettingDaoImpl.class
							+ "Error: Occur in Query While Updating the travel Mode into Database.",
					sqlException);

		} catch (Exception exception) {

			exception.printStackTrace();
			logger.error(
					SettingDaoImpl.class
							+ "Error: Occur in Query While closing connection after Updating the Travel Mode into Database.",
					exception);
		} finally {
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return target;

	}

	/**
	 * <p>
	 * <code>showProductCategoryDetails()</code>this method is design to get
	 * Product Category Details from database.
	 * </p>
	 * 
	 * @param productCategoryId
	 * @return company
	 * @throws OMIApplicationException
	 */
	@Override
	public Company showProductCategoryDetails(int productCategoryId)
			throws OMIApplicationException {
		company = new Company();
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.EDIT_PRODUCT_CATEGORY);
			preparedStatement.setInt(1, productCategoryId);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				company.setProductCategory(resultSet
						.getString("PRODUCT_CATEGORY_NAME"));
			}

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					SettingDaoImpl.class
							+ ": Error:- Error: Occur in Query While fetching the Product Category details for view from Database",
					sqlException);

		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					SettingDaoImpl.class
							+ ": Error:- While closing the Connection after fetching the Product Category details for view from Database",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return company;

	}

	/**
	 * <p>
	 * <code>updateProductCategoryDetail()</code>this method Updating Product
	 * Category Details into database.
	 * </p>
	 * 
	 * @param productCategoryId
	 *            ,companyVO
	 * @return target
	 * @throws OMIApplicationException
	 */
	@Override
	public int updateProductCategoryDetail(CompanyVO companyVO,
			int productCategoryId) throws OMIApplicationException {
		int target = 0;
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.UPADATING_PRODUCT_CATEGORY);
			// System.out.println("in settingDaoImpl");

			preparedStatement.setString(1, companyVO.getProductCategory());
			preparedStatement.setInt(2, productCategoryId);
			preparedStatement.executeUpdate();
			// System.out.println("company type id"+financeId);
			// System.out.println("company type"+companyVO.getCompanyType());
			target = 1;

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					SettingDaoImpl.class
							+ "Error: Occur in Query While Updating the Product Category into Database.",
					sqlException);

		} catch (Exception exception) {

			exception.printStackTrace();
			logger.error(
					SettingDaoImpl.class
							+ "Error: Occur in Query While closing connection after Updating the Product Category into Database.",
					exception);
		} finally {
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return target;

	}

	/**
	 * <p>
	 * <code>showProductUsesUnitDetails()</code>this method is design to get
	 * Product Category Details from database.
	 * </p>
	 * 
	 * @param productUsesUnitId
	 * @return company
	 * @throws OMIApplicationException
	 */
	@Override
	public Company showProductUsesUnitDetails(int productUsesUnitId)
			throws OMIApplicationException {
		company = new Company();
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.EDIT_PRODUCT_USES_UNIT);
			preparedStatement.setInt(1, productUsesUnitId);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				company.setProductUsesUnit(resultSet
						.getString("PRODUCT_USAGE_UNIT_NAME"));
			}

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					SettingDaoImpl.class
							+ ": Error:- Error: Occur in Query While fetching the Product Uses Unit details for view from Database",
					sqlException);

		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					SettingDaoImpl.class
							+ ": Error:- While closing the Connection after fetching the Product Uses Unit details for view from Database",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return company;

	}

	/**
	 * <p>
	 * <code>updateProductUsesUnitDetail()</code>this method Updating Product
	 * Uses Unit Details into database.
	 * </p>
	 * 
	 * @param productUsesUnitId
	 *            ,companyVO
	 * @return target
	 * @throws OMIApplicationException
	 */
	@Override
	public int updateProductUsesUnitDetail(CompanyVO companyVO,
			int productUsesUnitId) throws OMIApplicationException {
		int target = 0;
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.UPADATING_PRODUCT_USES_UNIT);
			// System.out.println("in settingDaoImpl");

			preparedStatement.setString(1, companyVO.getProductUsesUnit());
			preparedStatement.setInt(2, productUsesUnitId);
			preparedStatement.executeUpdate();
			// System.out.println("company type id"+financeId);
			// System.out.println("company type"+companyVO.getCompanyType());
			target = 1;

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					SettingDaoImpl.class
							+ "Error: Occur in Query While Updating the Product Uses Unit into Database.",
					sqlException);

		} catch (Exception exception) {

			exception.printStackTrace();
			logger.error(
					SettingDaoImpl.class
							+ "Error: Occur in Query While closing connection after Updating the Product Uses Unit into Database.",
					exception);
		} finally {
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return target;

	}

	/**
	 * <p>
	 * <code>showFAQCategoryDetails()</code>this method is design to get FAQ
	 * Category Details from database.
	 * </p>
	 * 
	 * @param faqcategoryId
	 * @return company
	 * @throws OMIApplicationException
	 */
	@Override
	public Company showFAQCategoryDetails(int faqcategoryId)
			throws OMIApplicationException {
		company = new Company();
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.EDIT_FAQ_CATEGORY);
			preparedStatement.setInt(1, faqcategoryId);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				company.setFaqcategory(resultSet.getString("CATEGORY_NAME"));
			}

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					SettingDaoImpl.class
							+ ": Error:- Error: Occur in Query While fetching the FAQ Category details for view from Database",
					sqlException);

		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					SettingDaoImpl.class
							+ ": Error:- While closing the Connection after fetching the Faq Category details for view from Database",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return company;

	}

	/**
	 * <p>
	 * <code>updateFAQCategoryDetail()</code>this method Updating FAQ Category
	 * Details into database.
	 * </p>
	 * 
	 * @param faqcategoryId
	 *            ,companyVO
	 * @return target
	 * @throws OMIApplicationException
	 */
	@Override
	public int updateFAQCategoryDetail(CompanyVO companyVO, int faqcategoryId)
			throws OMIApplicationException {
		int target = 0;
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.UPADATING_FAQ_CATEGORY);
			// System.out.println("in settingDaoImpl");

			preparedStatement.setString(1, companyVO.getFaqcategory());
			preparedStatement.setInt(2, faqcategoryId);
			preparedStatement.executeUpdate();
			// System.out.println("company type id"+financeId);
			// System.out.println("company type"+companyVO.getCompanyType());
			target = 1;

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					SettingDaoImpl.class
							+ "Error: Occur in Query While Updating the FAQ Category into Database.",
					sqlException);

		} catch (Exception exception) {

			exception.printStackTrace();
			logger.error(
					SettingDaoImpl.class
							+ "Error: Occur in Query While closing connection after Updating the Faq Category into Database.",
					exception);
		} finally {
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return target;

	}

	/**
	 * <p>
	 * <code>showChannelDetails()</code>this method is design to get Channel
	 * Details from database.
	 * </p>
	 * 
	 * @param channelId
	 * @return company
	 * @throws OMIApplicationException
	 */
	@Override
	public Company showChannelDetails(int channelId)
			throws OMIApplicationException {
		company = new Company();
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.EDIT_CHANNEL);
			preparedStatement.setInt(1, channelId);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				company.setChannel(resultSet.getString("CHANNEL_NAME"));
			}

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					SettingDaoImpl.class
							+ ": Error:- Error: Occur in Query While fetching the Channel details for view from Database",
					sqlException);

		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					SettingDaoImpl.class
							+ ": Error:- While closing the Connection after fetching the Channel details for view from Database",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return company;

	}

	/**
	 * <p>
	 * <code>updateChannelDetail()</code>this method Updating Channel Details
	 * into database.
	 * </p>
	 * 
	 * @param channelId
	 *            ,companyVO
	 * @return target
	 * @throws OMIApplicationException
	 */
	@Override
	public int updateChannelDetail(CompanyVO companyVO, int channelId)
			throws OMIApplicationException {
		int target = 0;
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.UPADATING_CHANNEL);
			// System.out.println("in settingDaoImpl");

			preparedStatement.setString(1, companyVO.getChannel());
			preparedStatement.setInt(2, channelId);
			preparedStatement.executeUpdate();
			// System.out.println("company type id"+financeId);
			// System.out.println("company type"+companyVO.getCompanyType());
			target = 1;

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					SettingDaoImpl.class
							+ "Error: Occur in Query While Updating the Channel into Database.",
					sqlException);

		} catch (Exception exception) {

			exception.printStackTrace();
			logger.error(
					SettingDaoImpl.class
							+ "Error: Occur in Query While closing connection after Updating the Channel into Database.",
					exception);
		} finally {
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return target;

	}

	/**
	 * <p>
	 * <code>showTaskAreaDetails()</code>this method is design to get Task Area
	 * Details from database.
	 * </p>
	 * 
	 * @param taskareaId
	 * @return company
	 * @throws OMIApplicationException
	 */
	@Override
	public Company showTaskAreaDetails(int taskareaId)
			throws OMIApplicationException {
		company = new Company();
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.EDIT_TASK_AREA);
			preparedStatement.setInt(1, taskareaId);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				company.setTaskarea(resultSet.getString("TASK_AREA"));
			}

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					SettingDaoImpl.class
							+ ": Error:- Error: Occur in Query While fetching the Task Area details for view from Database",
					sqlException);

		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					SettingDaoImpl.class
							+ ": Error:- While closing the Connection after fetching the Task Area details for view from Database",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return company;

	}

	/**
	 * <p>
	 * <code>updateTaskAreaDetail()</code>this method Updating task Area Details
	 * into database.
	 * </p>
	 * 
	 * @param taskareaId
	 *            ,companyVO
	 * @return target
	 * @throws OMIApplicationException
	 */
	@Override
	public int updateTaskAreaDetail(CompanyVO companyVO, int taskareaId)
			throws OMIApplicationException {
		int target = 0;
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.UPADATING_TASK_AREA);
			// System.out.println("in settingDaoImpl");

			preparedStatement.setString(1, companyVO.getTaskarea());
			preparedStatement.setInt(2, taskareaId);
			preparedStatement.executeUpdate();
			// System.out.println("company type id"+financeId);
			// System.out.println("company type"+companyVO.getCompanyType());
			target = 1;

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					SettingDaoImpl.class
							+ "Error: Occur in Query While Updating the Task Area into Database.",
					sqlException);

		} catch (Exception exception) {

			exception.printStackTrace();
			logger.error(
					SettingDaoImpl.class
							+ "Error: Occur in Query While closing connection after Updating the Task Area into Database.",
					exception);
		} finally {
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return target;

	}

	/**
	 * <p>
	 * <code>addCountryDetails()</code>this method is design to inserting
	 * Country Details into table TAB_COUNTRY.
	 * </p>
	 * 
	 * @param companyVO
	 * @return Target
	 * @throws OMIApplicationException
	 */
	@Override
	public int addCountryDetails(CompanyVO companyVO)
			throws OMIApplicationException {
		int target = 0;
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.INSERT_COUNTRY);
			preparedStatement.setString(1, companyVO.getCountryname());
			preparedStatement.setString(2, companyVO.getCountryCode());
			preparedStatement.setString(3, companyVO.getIsdCode());
			preparedStatement.setString(4, companyVO.getCountrydisplayName());
			preparedStatement.executeUpdate();
			target = 1;

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					SettingDaoImpl.class
							+ "Error: Occur in Query While inserting a Country Details into a Databse.",
					sqlException);

		} catch (Exception exception) {

			exception.printStackTrace();
			logger.error(
					SettingDaoImpl.class
							+ "Error: Occur in Query While closing connection after inserting a Country Detail into Database.",
					exception);
		} finally {
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return target;
	}

	/**
	 * <p>
	 * <code>showCountryList()</code>this method is design for getting Country
	 * Details from TAB_COUNTRY.
	 * </p>
	 * 
	 * 
	 * @return target
	 * @throws OMIApplicationException
	 */
	@Override
	public List<CompanyVO> showCountryList() throws OMIApplicationException {
		List<CompanyVO> countryList = new ArrayList<CompanyVO>();
		CompanyVO companyVO = null;
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_COUNTRY_GIRD_LIST);
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {
					companyVO = new CompanyVO();
					companyVO.setCountryID(resultSet.getInt("COUNTRY_ID"));
					companyVO.setCountryname(resultSet
							.getString("COUNTRY_NAME"));
					companyVO.setCountryCode(resultSet
							.getString("COUNTRY_CODE"));
					companyVO.setIsdCode(resultSet.getString("ISD_CODE"));
					companyVO.setCountrydisplayName(resultSet
							.getString("COUNTRY_DISPLAY_NAME"));
					countryList.add(companyVO);

				}
			}
		} catch (SQLException sqlExp) {
			logger.error(
					SettingDaoImpl.class
							+ "Error: Occur in Query While Fetching the Country details from Database.",
					sqlExp);
		} catch (Exception exception) {
			logger.error(
					SettingDaoImpl.class
							+ "Error: Occur in Query While Closing Connection After Fetching the country details from Database.",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);

		}

		return countryList;
	}

	/**
	 * <p>
	 * <code>showcountryDetails()</code>this method is used for fetching a
	 * country details for updating into a table TAB_COUNTRY.
	 * </p>
	 * 
	 * @return comnpany
	 * @param countryId
	 * @throws OMIApplicationException
	 */
	@Override
	public Company showcountryDetails(int countryId)
			throws OMIApplicationException {
		company = new Company();
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.EDIT_COUNTRY);
			preparedStatement.setInt(1, countryId);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				company.setCountryname(resultSet.getString("COUNTRY_NAME"));
				System.out.println(resultSet.getString("COUNTRY_NAME"));
				company.setCountryCode(resultSet.getString("COUNTRY_CODE"));
				System.out.println(resultSet.getString("COUNTRY_CODE"));
				company.setIsdCode(resultSet.getString("ISD_CODE"));
				System.out.println(resultSet.getString("ISD_CODE"));
				company.setCountryDisplayName(resultSet
						.getString("COUNTRY_DISPLAY_NAME"));
				System.out.println(resultSet
						.getString("COUNTRY_DISPLAY_NAME"));
			}

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					SettingDaoImpl.class
							+ ": Error:- Error: Occur in Query While fetching the Country Details from Database",
					sqlException);

		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					SettingDaoImpl.class
							+ ": Error:- While closing the Connection after fetching the country Details from Database",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return company;

	}

	/**
	 * <p>
	 * <code>UpdateCountryDetails()</code>this method is used for updating
	 * Country details into a Database.
	 * </p>
	 * 
	 * @return target
	 * @param companyVO
	 *            ,countryId
	 * @throws OMIApplicationException
	 * 
	 */
	@Override
	public int updateCountryDetails(CompanyVO companyVO, int countryId)
			throws OMIApplicationException {
		int target = 0;
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.UPDATE_COUNTRY);

			preparedStatement.setString(1, companyVO.getCountryname());
			preparedStatement.setString(2, companyVO.getCountryCode());
			preparedStatement.setString(3, companyVO.getIsdCode());
			preparedStatement.setString(4, companyVO.getCountrydisplayName());
			preparedStatement.setInt(5, countryId);
			preparedStatement.executeUpdate();

			target = 1;

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					SettingDaoImpl.class
							+ "Error: Occur in Query While Updating the Country Details into Database.",
					sqlException);

		} catch (Exception exception) {

			exception.printStackTrace();
			logger.error(
					SettingDaoImpl.class
							+ "Error: Occur in Query While closing connection after Updating the Cojuntry Details into Database.",
					exception);
		} finally {
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return target;

	}

	@Override
	public int insertProductType(CompanyVO companyVO)
			throws OMIApplicationException {
		int target = 0;
		try {
			
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.INSERT_PRODUCT_TYPE);

			preparedStatement.setString(1, companyVO.getProductCategory());
			preparedStatement.setString(2, companyVO.getProductType());
			target=preparedStatement.executeUpdate();
			

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					SettingDaoImpl.class
							+ "Error: Occur in Query While inserting the Product Type into Database.",
					sqlException);

		} catch (Exception exception) {

			exception.printStackTrace();
			logger.error(
					SettingDaoImpl.class
							+ "Error: Occur in Query While closing connection after inserting the Product Type into Database.",
					exception);
		} finally {
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return target;
	}

	@Override
	public List<CompanyVO> showProductTypeGrid() throws OMIApplicationException {
		List<CompanyVO> productTypeList = new ArrayList<CompanyVO>();
		CompanyVO companyVO = null;
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_PRODUCT_TYPE_GIRD_LIST);
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {
					companyVO = new CompanyVO();
					companyVO.setProductTypeId(resultSet
							.getInt("CEMENT_TYPE_ID"));
					companyVO.setProductType(resultSet
							.getString("CEMENT_TYPE_NAME"));
					companyVO.setProductCategory(nameHelper.getProductCategory(resultSet
							.getInt("CEMENT_TYPE_CATEGORY")));
					productTypeList.add(companyVO);

				}
			}
		} catch (SQLException sqlExp) {
			logger.error(
					SettingDaoImpl.class
							+ "Error: Occur in Query While Fetching the product Type  Details into Grid from Database.",
					sqlExp);
		} catch (Exception exception) {
			logger.error(
					SettingDaoImpl.class
							+ "Error: Occur in Query While Closing Connection After product the Campaign Type Details into Grid from Database.",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return productTypeList;
	}

	@Override
	public Company showProductTypeDetailsForUpdate(int productTypeId)
			throws OMIApplicationException {
		company = new Company();
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.EDIT_PRODUCT_TYPE);
			preparedStatement.setInt(1, productTypeId);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				company.setProductType(resultSet.getString("CEMENT_TYPE_NAME"));
				company.setProductCategory(resultSet.getString("CEMENT_TYPE_CATEGORY"));
			}

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					SettingDaoImpl.class
							+ ": Error:- Error: Occur in Query While fetching product type details for view from Database",
					sqlException);

		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					SettingDaoImpl.class
							+ ": Error:- While closing the Connection after fetching the  product type details for view from Database",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return company;
	}

	@Override
	public int updateProductType(CompanyVO companyVO, int productTypeId)
			throws OMIApplicationException {
		int target = 0;
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.UPDATE_PRODUCT_TYPE);

			
			preparedStatement.setString(1, companyVO.getProductType());
			preparedStatement.setString(2, companyVO.getProductCategory());
			preparedStatement.setInt(3, productTypeId);
			preparedStatement.executeUpdate();

			target = 1;

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					SettingDaoImpl.class
							+ "Error: Occur in Query While Updating the poduct type Details into Database.",
					sqlException);

		} catch (Exception exception) {

			exception.printStackTrace();
			logger.error(
					SettingDaoImpl.class
							+ "Error: Occur in Query While closing connection after Updating the poduct type into Database.",
					exception);
		} finally {
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return target;
	}
}