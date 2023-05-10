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
 * Interface Name     SettingDaoInf.java     
 *                                                            
 * Creation Date  NOV 13 , 2015 
 * 
 * Abstract       This is SettingDaoInf interface design to declare the method.
 *  
 * Amendment History (in chronological sequence): NOV 13, 2015 
 * 
 **********************************************************************
 */

package com.bst.ckt.dao;

import java.util.List;

import com.bst.ckt.dto.Company;
import com.bst.ckt.exception.OMIApplicationException;
import com.bst.ckt.vo.CompanyVO;

/**
 * @author sharif
 * 
 */
public interface SettingDaoInf {

	/**
	 * <p>
	 * <code>getCompanyInformation()</code>this method is used to get company
	 * details from database
	 * </p>
	 * 
	 * @param
	 * 
	 * @throws OMIApplicationException
	 */
	public Company getCompanyInformation(int companyId)
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>updateCompanyInformation()</code>this method is used to update
	 * company details into database
	 * </p>
	 * 
	 * @param companyId
	 *            ,CompanyVO companyVO
	 * @return
	 * @throws OMIApplicationException
	 */
	public int updateCompanyInformation(CompanyVO companyVO, int companyId)
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>addCompanyType()</code>this method is used to insert company type
	 * into database
	 * </p>
	 * 
	 * @param CompanyVO
	 *            companyVO
	 * @return
	 * @throws OMIApplicationException
	 */
	public int addCompanyType(CompanyVO companyVO)
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>getCompantTypeGrid()</code>this method is used to get company type
	 * from TAB_COMPANY_TYPE
	 * </p>
	 * 
	 * @param
	 * @return target
	 * @throws OMIApplicationException
	 */
	public List<CompanyVO> getCompanyTypeGrid() throws OMIApplicationException;

	/**
	 * <p>
	 * <code>updateCompanyTypeInfo()</code>this method is used to Update company
	 * type into TAB_COMPANY_TYPE
	 * </p>
	 * 
	 * @param companyVO
	 *            ,companyTypeId
	 * @return target
	 * @throws OMIApplicationException
	 */

	public int updateCompanyTypeInfo(CompanyVO companyVO, int companyTypeId)
			throws Exception;

	/**
	 * <p>
	 * <code>addFinanceTax()</code>this method is used to inserted a Taxes into
	 * the database.
	 * </p>
	 * 
	 * @param CompanyVO
	 *            companyVO
	 * @return target
	 * @throws OMIApplicationException
	 */
	public int addFinanceTax(CompanyVO companyVO)
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>showFinanceTaxGrid()</code>this method is used to get finance taxes
	 * from TAB_TAX
	 * </p>
	 * 
	 * @param
	 * @return target
	 * @throws OMIApplicationException
	 */
	public List<CompanyVO> showFinanceTaxGrid() throws OMIApplicationException;

	/**
	 * <p>
	 * <code>showProductCategoryGrid()</code>this method is used to get Product
	 * category from TAB_
	 * </p>
	 * 
	 * @param
	 * @return target
	 * @throws OMIApplicationException
	 */
	public List<CompanyVO> showProductCategoryGrid()
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>addProductCategory()</code>this method is used to inserted a
	 * Product Category into the database.
	 * </p>
	 * 
	 * @param CompanyVO
	 *            companyVO
	 * @return target
	 * @throws OMIApplicationException
	 */
	public int addProductCategory(CompanyVO companyVO)
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>showCompanyCategoeyGrid()</code>this method is used to get Company
	 * Category from TAB_COMPANY_CATEGORY
	 * </p>
	 * 
	 * @param
	 * @return target
	 * @throws OMIApplicationException
	 */
	public List<CompanyVO> showCompanyCategoeyGrid()
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>addCompanyCategory()</code>this method is used to inserted a
	 * Company Category into the database.
	 * </p>
	 * 
	 * @param CompanyVO
	 *            companyVO
	 * @return target
	 * @throws OMIApplicationException
	 */
	public int addCompanyCategory(CompanyVO companyVO)
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>addCompanySector()</code>this method is used to inserted a Company
	 * Sector into the database.
	 * </p>
	 * 
	 * @param CompanyVO
	 *            companyVO
	 * @return target
	 * @throws OMIApplicationException
	 */
	public int addCompanySector(CompanyVO companyVO)
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>showCompanySectorList()</code>this method is used to get Company
	 * Sector from TAB_COMPANY_SECTOR
	 * </p>
	 * 
	 * @param
	 * @return target
	 * @throws OMIApplicationException
	 */
	public List<CompanyVO> showCompanySectorList()
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>addFinanceGLAccount()</code>this method is used to inserted a GL
	 * Account into the database.
	 * </p>
	 * 
	 * @param CompanyVO
	 *            companyVO
	 * @return target
	 * @throws OMIApplicationException
	 */
	public int addFinanceGLAccount(CompanyVO companyVO)
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>showFinanaceGLAccountList()</code>this method is used to get GL
	 * Account from TAB_GL_ACCOUNT
	 * </p>
	 * 
	 * @param
	 * @return target
	 * @throws OMIApplicationException
	 */

	public List<CompanyVO> showFinanaceGLAccountList()
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>addMarketingLeadSource()</code>this method is used to inserted a
	 * Lead source into the database.
	 * </p>
	 * 
	 * @param CompanyVO
	 *            companyVO
	 * @return target
	 * @throws OMIApplicationException
	 */

	public int addMarketingLeadSource(CompanyVO companyVO)
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>showMarketingLeadSourceList()</code>this method is used to get LEAD
	 * SOURCE from TAB_LEAD_SOURCE
	 * </p>
	 * 
	 * @param
	 * @return target
	 * @throws OMIApplicationException
	 */

	public List<CompanyVO> showMarketingLeadSourceList()
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>addMarketingAccountType()</code>this method is used to inserted a
	 * Account Type into the database.
	 * </p>
	 * 
	 * @param CompanyVO
	 *            companyVO
	 * @return target
	 * @throws OMIApplicationException
	 */

	public int addMarketingAccountType(CompanyVO companyVO)
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>showMarketingAccountTypeList()</code>this method is used to get
	 * Account Type from TAB_ACCOUNT_TYPE
	 * </p>
	 * 
	 * @param
	 * @return target
	 * @throws OMIApplicationException
	 */
	public List<CompanyVO> showMarketingAccountTypeList()
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>addMarketingCampaignType()</code>this method is used to inserted a
	 * Campaign Type into the database.
	 * </p>
	 * 
	 * @param CompanyVO
	 *            companyVO
	 * @return target
	 * @throws OMIApplicationException
	 */
	public int addMarketingCampaignType(CompanyVO companyVO)
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>showMarketingCampaignTypeList()</code>this method is used to get
	 * Campaign Type from TAB_CAMPAIGN_TYPE
	 * </p>
	 * 
	 * @param
	 * @return target
	 * @throws OMIApplicationException
	 */

	public List<CompanyVO> showMarketingCampaignTypeList()
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>addMarketingResponse()</code>this method is used to inserted a
	 * Response into the database.
	 * </p>
	 * 
	 * @param CompanyVO
	 *            companyVO
	 * @return target
	 * @throws OMIApplicationException
	 */

	public int addMarketingResponse(CompanyVO companyVO)
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>showMarketingResponseList()</code>this method is used to get
	 * Response from TAB_RESPONSE
	 * </p>
	 * 
	 * @param
	 * @return target
	 * @throws OMIApplicationException
	 */

	public List<CompanyVO> showMarketingResponseList()
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>addMarketingVendorCategory()</code>this method is used to inserted
	 * a Vendor category into the database.
	 * </p>
	 * 
	 * @param CompanyVO
	 *            companyVO
	 * @return target
	 * @throws OMIApplicationException
	 */
	public int addMarketingVendorCategory(CompanyVO companyVO)
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>showMarketingVendorcategoryList()</code>this method is used to get
	 * Vendor category from TAB_VENDOR_CATEGORY
	 * </p>
	 * 
	 * @param
	 * @return target
	 * @throws OMIApplicationException
	 */

	public List<CompanyVO> showMarketingVendorcategoryList()
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>addMarketingTravelMode()</code>this method is used to inserted a
	 * Travel Mode into the database.
	 * </p>
	 * 
	 * @param CompanyVO
	 *            companyVO
	 * @return target
	 * @throws OMIApplicationException
	 */
	public int addMarketingTravelMode(CompanyVO companyVO)
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>showMarketingtravelModeList()</code>this method is used to get
	 * Travel Mode from TAB_TRAVEL_MODE
	 * </p>
	 * 
	 * @param
	 * @return target
	 * @throws OMIApplicationException
	 */

	public List<CompanyVO> showMarketingtravelModeList()
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>addSupportFAQCategory()</code>this method is used to inserted a FAQ
	 * Category into the database.
	 * </p>
	 * 
	 * @param CompanyVO
	 *            companyVO
	 * @return target
	 * @throws OMIApplicationException
	 */

	public int addSupportFAQCategory(CompanyVO companyVO)
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>showSupportfaqCategoryList()</code>this method is used to get FAQ
	 * Category from TAB_FAQ_CATEGORY
	 * </p>
	 * 
	 * @param
	 * @return target
	 * @throws OMIApplicationException
	 */

	public List<CompanyVO> showSupportfaqCategoryList()
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>addSupportChannel()</code>this method is used to inserted a Channel
	 * into the database.
	 * </p>
	 * 
	 * @param CompanyVO
	 *            companyVO
	 * @return target
	 * @throws OMIApplicationException
	 */

	public int addSupportChannel(CompanyVO companyVO)
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>showSupportChannelList()</code>this method is used to get Channel
	 * from TAB_CASES_CHANNEL
	 * </p>
	 * 
	 * @param
	 * @return target
	 * @throws OMIApplicationException
	 */
	public List<CompanyVO> showSupportChannelList()
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>addSupportTaskArea()</code>this method is used to inserted a Task
	 * Area into the database.
	 * </p>
	 * 
	 * @param CompanyVO
	 *            companyVO
	 * @return target
	 * @throws OMIApplicationException
	 */
	public int addSupportTaskArea(CompanyVO companyVO)
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>showSupportTaskAreaList()</code>this method is used to get Task
	 * Area from TAB_TASK_AREA.
	 * </p>
	 * 
	 * @param
	 * @return target
	 * @throws OMIApplicationException
	 */
	public List<CompanyVO> showSupportTaskAreaList()
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>addSupportCaseImpact()</code>this method is used to inserted a
	 * Cases Impact into the database.
	 * </p>
	 * 
	 * @param CompanyVO
	 *            companyVO
	 * @return target
	 * @throws OMIApplicationException
	 */
	public int addSupportCaseImpact(CompanyVO companyVO)
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>showSupportCaseImpactList()</code>this method is used to get Case
	 * Impact from database.
	 * </p>
	 * 
	 * @param
	 * @return target
	 * @throws OMIApplicationException
	 */
	public List<CompanyVO> showSupportCaseImpactList()
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>addCompanyLocal()</code>this method is used to inserted a Company
	 * Local into the database.
	 * </p>
	 * 
	 * @param CompanyVO
	 *            companyVO
	 * @return target
	 * @throws OMIApplicationException
	 */
	public int updateCompanyLocal(CompanyVO companyVO, int customerId)
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>showCompanyLocalList()</code>this method is used to get Company
	 * Local from database.
	 * </p>
	 * 
	 * @param
	 * @return target
	 * @throws OMIApplicationException
	 */

	public List<CompanyVO> showCompanyLocalList()
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>addProductUsesUnit()</code>this method is used to inserted a
	 * Product Uses Unit into the database.
	 * </p>
	 * 
	 * @param CompanyVO
	 *            companyVO
	 * @return target
	 * @throws OMIApplicationException
	 */
	public int addProductUsesUnit(CompanyVO companyVO)
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>showProductUsesUnitList()</code>this method is used to get Product
	 * Uses Unit from database.
	 * </p>
	 * 
	 * @param
	 * @return target
	 * @throws OMIApplicationException
	 */
	public List<CompanyVO> showProductUsesUnitList()
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>getCompanyTypeDetailsForUpdate()</code> This method is Used for
	 * Update company type into database.
	 * <p>
	 * 
	 * @param companyTypeId
	 * @return company
	 * @throws OMIApplicationException
	 */
	public Company showCompanyTypeDetailsForUpdate(int companyTypeId)
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>showGLAccountDetails()</code> This method is Used for Update GL
	 * Account into database.
	 * <p>
	 * 
	 * @param financeId
	 * @return company
	 * @throws OMIApplicationException
	 */
	public Company showGLAccountDetails(int financeId)
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>updateGLAccountDetail()</code> This method is Used for Update GL
	 * Account into database.
	 * <p>
	 * 
	 * @param financeId
	 *            ,companyVO
	 * @return company
	 * @throws OMIApplicationException
	 */
	public int updateGLAccountDetail(CompanyVO companyVO, int financeId)
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>showLeadSourceDetails()</code> This method is Used for Update Lead
	 * Source into database.
	 * <p>
	 * 
	 * @param leadsourceID
	 * @return company
	 * @throws OMIApplicationException
	 */
	public Company showLeadSourceDetails(int leadsourceID)
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>updateLeadSourceDetail()</code> This method is Used for Update Lead
	 * Source into database.
	 * <p>
	 * 
	 * @param leadsourceID
	 *            ,companyVO
	 * @return company
	 * @throws OMIApplicationException
	 */

	public int updateLeadSourceDetail(CompanyVO companyVO, int leadsourceID)
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>showTaxDetails()</code> This method is Used for Update Tax into
	 * database.
	 * <p>
	 * 
	 * @param leadsourceID
	 * @return company
	 * @throws OMIApplicationException
	 */
	public Company showTaxDetails(int financeId) throws OMIApplicationException;

	/**
	 * <p>
	 * <code>updateTaxDetail()</code> This method is Used for Update Tax into
	 * database.
	 * <p>
	 * 
	 * @param financeId
	 *            ,companyVO
	 * @return company
	 * @throws OMIApplicationException
	 */
	public int updateTaxDetail(CompanyVO companyVO, int financeId)
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>showCompanyCategoryDetails()</code> This method is Used for getting
	 * Company Category from database.
	 * <p>
	 * 
	 * @param companyCategoryID
	 *            ,companyVO
	 * @return company
	 * @throws OMIApplicationException
	 */
	public Company showCompanyCategoryDetails(int companyCategoryID)
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>updateCompanyCategoryDetail()</code> This method is Used for Update
	 * Company Category into database.
	 * <p>
	 * 
	 * @param companyCategoryID
	 *            ,companyVO
	 * @return company
	 * @throws OMIApplicationException
	 */
	public int updateCompanyCategoryDetail(CompanyVO companyVO,
			int companyCategoryID) throws OMIApplicationException;

	/**
	 * <p>
	 * <code>showCompanySectorDetails()</code> This method is Used for getting
	 * Company Sector from database.
	 * <p>
	 * 
	 * @param companysectorid
	 *            ,companyVO
	 * @return company
	 * @throws OMIApplicationException
	 */

	public Company showCompanySectorDetails(int companysectorid)
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>updateCompanySectorDetail()</code> This method is Used for Update
	 * Company Sector into database.
	 * <p>
	 * 
	 * @param companysectorid
	 *            ,companyVO
	 * @return company
	 * @throws OMIApplicationException
	 */

	public int updateCompanySectorDetail(CompanyVO companyVO,
			int companysectorid) throws OMIApplicationException;

	/**
	 * <p>
	 * <code>showAccounTypeDetails()</code> This method is Used for getting
	 * Account type from database.
	 * <p>
	 * 
	 * @param accountTypeId
	 *            ,companyVO
	 * @return company
	 * @throws OMIApplicationException
	 */

	public Company showAccounTypeDetails(int accountTypeId)
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>updateAccountTypeDetail()</code> This method is Used for Update
	 * Account type into database.
	 * <p>
	 * 
	 * @param accountTypeId
	 *            ,companyVO
	 * @return company
	 * @throws OMIApplicationException
	 */
	public int updateAccountTypeDetail(CompanyVO companyVO, int accountTypeId)
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>showCampaignTypeDetails()</code> This method is Used for getting
	 * Campaign type from database.
	 * <p>
	 * 
	 * @param campaigntypeID
	 *            ,companyVO
	 * @return company
	 * @throws OMIApplicationException
	 */

	public Company showCampaignTypeDetails(int campaigntypeID)
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>updateCampaignTypeDetail()</code> This method is Used for Update
	 * Campaign type into database.
	 * <p>
	 * 
	 * @param campaigntypeID
	 *            ,companyVO
	 * @return company
	 * @throws OMIApplicationException
	 */

	public int updateCampaignTypeDetail(CompanyVO companyVO, int campaigntypeID)
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>showVendorCategoryDetails()</code> This method is Used for getting
	 * Vendor Category from database.
	 * <p>
	 * 
	 * @param vendorCategoryId
	 *            ,companyVO
	 * @return company
	 * @throws OMIApplicationException
	 */
	public Company showVendorCategoryDetails(int vendorCategoryId)
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>updateVendorCategoryDetail()</code> This method is Used for Update
	 * Vendor Category into database.
	 * <p>
	 * 
	 * @param vendorCategoryId
	 *            ,companyVO
	 * @return company
	 * @throws OMIApplicationException
	 */
	public int updateVendorCategoryDetail(CompanyVO companyVO,
			int vendorCategoryId) throws OMIApplicationException;

	/**
	 * <p>
	 * <code>showTravelModeDetails()</code> This method is Used for getting
	 * travel Mode from database.
	 * <p>
	 * 
	 * @param travelmodeID
	 *            ,companyVO
	 * @return company
	 * @throws OMIApplicationException
	 */
	public Company showTravelModeDetails(int travelmodeID)
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>updateTravelModeDetail()</code> This method is Used for Update
	 * travel Mode into database.
	 * <p>
	 * 
	 * @param travelmodeID
	 *            ,companyVO
	 * @return company
	 * @throws OMIApplicationException
	 */

	public int updateTravelModeDetail(CompanyVO companyVO, int travelmodeID)
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>showProductCategoryDetails()</code> This method is Used for getting
	 * Product Category from database.
	 * <p>
	 * 
	 * @param productCategoryId
	 *            ,companyVO
	 * @return company
	 * @throws OMIApplicationException
	 */

	public Company showProductCategoryDetails(int productCategoryId)
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>updateProductCategoryDetail()</code> This method is Used for Update
	 * Product Category into database.
	 * <p>
	 * 
	 * @param productCategoryId
	 *            ,companyVO
	 * @return company
	 * @throws OMIApplicationException
	 */
	public int updateProductCategoryDetail(CompanyVO companyVO,
			int productCategoryId) throws OMIApplicationException;

	/**
	 * <p>
	 * <code>showProductUsesUnitDetails()</code> This method is Used for getting
	 * Product Uses Unit from database.
	 * <p>
	 * 
	 * @param productUsesUnitId
	 *            ,companyVO
	 * @return company
	 * @throws OMIApplicationException
	 */

	public Company showProductUsesUnitDetails(int productUsesUnitId)
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>updateProductUsesUnitDetail()</code> This method is Used for Update
	 * Product Uses Unit into database.
	 * <p>
	 * 
	 * @param productUsesUnitId
	 *            ,companyVO
	 * @return company
	 * @throws OMIApplicationException
	 */

	public int updateProductUsesUnitDetail(CompanyVO companyVO,
			int productUsesUnitId) throws OMIApplicationException;

	/**
	 * <p>
	 * <code>showFAQCategoryDetails()</code> This method is Used for getting FAQ
	 * Category from database.
	 * <p>
	 * 
	 * @param faqcategoryId
	 *            ,companyVO
	 * @return company
	 * @throws OMIApplicationException
	 */

	public Company showFAQCategoryDetails(int faqcategoryId)
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>updateFAQCategoryDetail()</code> This method is Used for Update FAQ
	 * Category into database.
	 * <p>
	 * 
	 * @param faqcategoryId
	 *            ,companyVO
	 * @return company
	 * @throws OMIApplicationException
	 */
	public int updateFAQCategoryDetail(CompanyVO companyVO, int faqcategoryId)
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>showChannelDetails()</code> This method is Used for getting Channel
	 * from database.
	 * <p>
	 * 
	 * @param channelId
	 *            ,companyVO
	 * @return company
	 * @throws OMIApplicationException
	 */

	public Company showChannelDetails(int channelId)
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>updateChannelDetail()</code> This method is Used for Update Channel
	 * into database.
	 * <p>
	 * 
	 * @param channelId
	 *            ,companyVO
	 * @return company
	 * @throws OMIApplicationException
	 */
	public int updateChannelDetail(CompanyVO companyVO, int channelId)
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>showTaskAreaDetails()</code> This method is Used for getting Task
	 * Area from database.
	 * <p>
	 * 
	 * @param taskareaId
	 *            ,companyVO
	 * @return company
	 * @throws OMIApplicationException
	 */

	public Company showTaskAreaDetails(int taskareaId)
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>updateTaskAreaDetail()</code> This method is Used for Update Task
	 * Area into database.
	 * <p>
	 * 
	 * @param taskareaId
	 *            ,companyVO
	 * @return company
	 * @throws OMIApplicationException
	 */

	public int updateTaskAreaDetail(CompanyVO companyVO, int taskareaId)
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>addCountryDetails()</code> This method is Used for inserting
	 * Country Details into table TAB_COUNTRY.
	 * <p>
	 * 
	 * @param companyVO
	 * 
	 * @return target
	 * @throws OMIApplicationException
	 */
	public int addCountryDetails(CompanyVO companyVO)
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>showCountryList()</code> This method is Used for fetching Country
	 * Details from table TAB_COUNTRY.
	 * <p>
	 * 
	 * 
	 * 
	 * @return CompanyVo
	 * @throws OMIApplicationException
	 */
	public List<CompanyVO> showCountryList() throws OMIApplicationException;

	/**
	 * <p>
	 * <code>showcountryDetails()</code>this method is used for fetching a
	 * country details for updating from table TAB_COUNTRY
	 * </p>
	 * 
	 * @param countryId
	 * @return
	 * @throws OMIApplicationException
	 */
	public Company showcountryDetails(int countryId)
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>updatingCountryDetails()</code>this method used for updating
	 * Country details in table TAB_COUNTRY
	 * </p>
	 * 
	 * @return target
	 * @param companyVO,countryId
	 * @throws OMIApplicationException
	 */
	
	/**
	 * 
	 * @param companyVO
	 * @param countryId
	 * @return
	 * @throws OMIApplicationException
	 */
	
	
	public int updateCountryDetails(CompanyVO companyVO, int countryId)
			throws OMIApplicationException;

	public int insertProductType(CompanyVO companyVO) throws OMIApplicationException;

	public List<CompanyVO> showProductTypeGrid() throws OMIApplicationException;

	public Company showProductTypeDetailsForUpdate(int productTypeId) throws OMIApplicationException;

	public int updateProductType(CompanyVO companyVO, int productTypeId) throws OMIApplicationException;

}
