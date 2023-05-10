/**
 * 
 */
package com.bst.ckt.service;

import java.util.List;

import com.bst.ckt.dto.Company;
import com.bst.ckt.exception.OMIApplicationException;
import com.bst.ckt.vo.CompanyVO;

/**
 * @author sharif
 * 
 */
public interface SettingServiceInf {

	/**
	 * <p>
	 * <code>editSettingInfo()</code>this method is design to fetch company
	 * details for update process from database.
	 * </p>
	 * 
	 * @param companyId
	 * @throws OMIApplicationException
	 */

	public Company editSettingInfo(int companyId)
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>updateCompanyDetails()</code>this method is used to update company
	 * details into database
	 * </p>
	 * 
	 * @param companyId
	 *            ,CompanyVO companyVO
	 * 
	 * @throws OMIApplicationException
	 */
	public String updateCompanyDetails(CompanyVO companyVO, int companyId)
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>addCompanyType()</code>this method is used to add Company Type into
	 * database
	 * </p>
	 * 
	 * @param CompanyVO
	 *            companyVO
	 * 
	 * @throws OMIApplicationException
	 */
	public String addCompanyType(CompanyVO companyVO)
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>showCompanyTypeGrid()</code>this method is used to show company
	 * type grid from TAB_COMPANY_TYPE
	 * </p>
	 * 
	 * @param CompanyVO
	 *            companyVO
	 * 
	 * @throws OMIApplicationException
	 */
	public List<CompanyVO> showCompanyTypeGrid() throws OMIApplicationException;

	/**
	 * <p>
	 * <code>addFinanceTax()</code>this method is used to inserted a taxes into
	 * the database
	 * </p>
	 * 
	 * @param CompanyVO
	 *            companyVO
	 * 
	 * @throws OMIApplicationException
	 */

	public String addFinanceTax(CompanyVO companyVO)
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>showFinanceTaxGrid()</code>this method is used to show finance tax
	 * grid from TAB_TAX
	 * </p>
	 * 
	 * @param CompanyVO
	 *            companyVO
	 * 
	 * @throws OMIApplicationException
	 */
	public List<CompanyVO> showFinanceTaxGrid() throws OMIApplicationException;

	/**
	 * <p>
	 * <code>showProductCategoryGrid()</code>this method is used to show Product
	 * Category grid from TAB_
	 * </p>
	 * 
	 * @param CompanyVO
	 *            companyVO
	 * 
	 * @throws OMIApplicationException
	 */

	public List<CompanyVO> showProductCategoryGrid()
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>addProductCategory()</code>this method is used to inserted a
	 * Product Category into the database
	 * </p>
	 * 
	 * @param CompanyVO
	 *            companyVO
	 * 
	 * @throws OMIApplicationException
	 */

	public String addProductCategory(CompanyVO companyVO)
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>showCompanyCategoeyGrid()</code>this method is used to show Company
	 * Category grid from TAB_
	 * </p>
	 * 
	 * @param CompanyVO
	 *            companyVO
	 * 
	 * @throws OMIApplicationException
	 */

	public List<CompanyVO> showCompanyCategoeyGrid()
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>addCompanyCategory()</code>this method is used to inserted a
	 * Company Category into the database
	 * </p>
	 * 
	 * @param CompanyVO
	 *            companyVO
	 * 
	 * @throws OMIApplicationException
	 */
	public String addCompanyCategory(CompanyVO companyVO)
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>addSupportCaseImpact()</code>this method is used to inserted a Case
	 * Impact into the database
	 * </p>
	 * 
	 * @param CompanyVO
	 *            companyVO
	 * 
	 * @throws OMIApplicationException
	 */
	public String addSupportCaseImpact(CompanyVO companyVO)
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>showSupportCaseImpactList()</code>this method is used to show Case
	 * Impact grid from database.
	 * </p>
	 * 
	 * @param CompanyVO
	 *            companyVO
	 * 
	 * @throws OMIApplicationException
	 */

	public List<CompanyVO> showSupportCaseImpactList()
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>addCompanySector()</code>this method is used to inserted a Company
	 * Sector into the database
	 * </p>
	 * 
	 * @param CompanyVO
	 *            companyVO
	 * 
	 * @throws OMIApplicationException
	 */

	public String addCompanySector(CompanyVO companyVO)
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>showCompanySectorList()</code>this method is used to show Company
	 * Local grid from TAB_COMPANY_SECTOR
	 * </p>
	 * 
	 * @param CompanyVO
	 *            companyVO
	 * 
	 * @throws OMIApplicationException
	 */
	public List<CompanyVO> showCompanySectorList()
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>addFinanceGLAccount()</code>this method is used to inserted a GL
	 * Account into the database
	 * </p>
	 * 
	 * @param CompanyVO
	 *            companyVO
	 * 
	 * @throws OMIApplicationException
	 */

	public String addFinanceGLAccount(CompanyVO companyVO)
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>showFinanaceGLAccountList()</code>this method is used to show GL
	 * Account grid from TAB_COMPANY_SECTOR
	 * </p>
	 * 
	 * @param CompanyVO
	 *            companyVO
	 * 
	 * @throws OMIApplicationException
	 */

	public List<CompanyVO> showFinanaceGLAccountList()
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>addMarketingLeadSource()</code>this method is used to inserted a
	 * Lead Source into the database
	 * </p>
	 * 
	 * @param CompanyVO
	 *            companyVO
	 * 
	 * @throws OMIApplicationException
	 */

	public String addMarketingLeadSource(CompanyVO companyVO)
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>showMarketingLeadSourceList()</code>this method is used to show
	 * Lead source grid from TAB_LEAD_SOURCE
	 * </p>
	 * 
	 * @param CompanyVO
	 *            companyVO
	 * 
	 * @throws OMIApplicationException
	 */
	public List<CompanyVO> showMarketingLeadSourceList()
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>addMarketingAccountType()</code>this method is used to inserted a
	 * Account Type into the database
	 * </p>
	 * 
	 * @param CompanyVO
	 *            companyVO
	 * 
	 * @throws OMIApplicationException
	 */
	public String addMarketingAccountType(CompanyVO companyVO)
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>showMarketingAccountTypeList()</code>this method is used to show
	 * Account Type grid from TAB_ACCOUNT_TYPE
	 * </p>
	 * 
	 * @param
	 * 
	 * @throws OMIApplicationException
	 */

	public List<CompanyVO> showMarketingAccountTypeList()
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>showMarketingSlaNameList()</code>this method is used to show
	 * Account Type grid from TAB_ACCOUNT_TYPE
	 * </p>
	 * 
	 * @param
	 * 
	 * @throws OMIApplicationException
	 */

	public List<CompanyVO> showMarketingSlaNameList()
			throws OMIApplicationException;

	public String addMarketingSlaName(CompanyVO companyVO)
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>addMarketingCampaignType()</code>this method is used to inserted a
	 * Campaign Type into the database
	 * </p>
	 * 
	 * @param CompanyVO
	 *            companyVO
	 * 
	 * @throws OMIApplicationException
	 */

	public String addMarketingCampaignType(CompanyVO companyVO)
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>showMarketingCampaignTypeList()</code>this method is used to show
	 * Campaign Type grid from TAB_CAMPAIGN_TYPE
	 * </p>
	 * 
	 * @param
	 * 
	 * @throws OMIApplicationException
	 */
	public List<CompanyVO> showMarketingCampaignTypeList()
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>addMarketingResponse()</code>this method is used to inserted a
	 * Response into the database
	 * </p>
	 * 
	 * @param CompanyVO
	 *            companyVO
	 * 
	 * @throws OMIApplicationException
	 */

	public String addMarketingResponse(CompanyVO companyVO)
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>showMarketingResponseList()</code>this method is used to show
	 * Response grid from TAB_RESPONSE.
	 * </p>
	 * 
	 * @param
	 * 
	 * @throws OMIApplicationException
	 */

	public List<CompanyVO> showMarketingResponseList()
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>addMarketingVendorCategory()</code>this method is used to inserted
	 * a Vendor Category into the database
	 * </p>
	 * 
	 * @param CompanyVO
	 *            companyVO
	 * 
	 * @throws OMIApplicationException
	 */

	public String addMarketingVendorCategory(CompanyVO companyVO)
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>showMarketingVendorcategoryList()</code>this method is used to show
	 * Vendor Category grid from TAB_VENDOR_CATEGORY
	 * </p>
	 * 
	 * @param
	 * 
	 * @throws OMIApplicationException
	 */

	public List<CompanyVO> showMarketingVendorcategoryList()
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>addMarketingTravelMode()</code>this method is used to inserted a
	 * Travel Mode into the database
	 * </p>
	 * 
	 * @param CompanyVO
	 *            companyVO
	 * 
	 * @throws OMIApplicationException
	 */

	public String addMarketingTravelMode(CompanyVO companyVO)
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>showMarketingtravelModeList()</code>this method is used to show
	 * Travel Mode grid from TAB_TRAVEL_MODE
	 * </p>
	 * 
	 * @param
	 * 
	 * @throws OMIApplicationException
	 */

	public List<CompanyVO> showMarketingtravelModeList()
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>addSupportFAQCategory()</code>this method is used to inserted a FAQ
	 * Category into the database
	 * </p>
	 * 
	 * @param CompanyVO
	 *            companyVO
	 * 
	 * @throws OMIApplicationException
	 */

	public String addSupportFAQCategory(CompanyVO companyVO)
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>showSupportfaqCategoryList()</code>this method is used to show FAQ
	 * Category grid from TAB_FAQ_CATEGORY.
	 * </p>
	 * 
	 * @param
	 * 
	 * @throws OMIApplicationException
	 */

	public List<CompanyVO> showSupportfaqCategoryList()
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>addSupportChannel()</code>this method is used to inserted a Channel
	 * into the database
	 * </p>
	 * 
	 * @param CompanyVO
	 *            companyVO
	 * 
	 * @throws OMIApplicationException
	 */

	public String addSupportChannel(CompanyVO companyVO)
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>showSupportChannelList()</code>this method is used to show Channel
	 * grid from TAB_CASES_CHANNEL.
	 * </p>
	 * 
	 * @param
	 * 
	 * @throws OMIApplicationException
	 */

	public List<CompanyVO> showSupportChannelList()
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>addSupportTaskArea()</code>this method is used to inserted a Task
	 * Area into the database
	 * </p>
	 * 
	 * @param CompanyVO
	 *            companyVO
	 * 
	 * @throws OMIApplicationException
	 */

	public String addSupportTaskArea(CompanyVO companyVO)
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>showSupportTaskAreaList()</code>this method is used to show Task
	 * Area grid from TAB_TASK_AREA.
	 * </p>
	 * 
	 * @param
	 * 
	 * @throws OMIApplicationException
	 */

	public List<CompanyVO> showSupportTaskAreaList()
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>addCompanyLocal()</code>this method is used to inserted a Company
	 * Local into the database
	 * </p>
	 * 
	 * @param CompanyVO
	 *            companyVO
	 * 
	 * @throws OMIApplicationException
	 */

	public String updateCompanyLocal(CompanyVO companyVO, int customerId)
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>showCompanyLocalList()</code>this method is used to show Company
	 * Local grid from database.
	 * </p>
	 * 
	 * @param
	 * 
	 * @throws OMIApplicationException
	 */

	public List<CompanyVO> showCompanyLocalList()
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>addProductUsesUnit()</code>this method is used to inserted a
	 * Product Uses Unit into the database
	 * </p>
	 * 
	 * @param CompanyVO
	 *            companyVO
	 * 
	 * @throws OMIApplicationException
	 */

	public String addProductUsesUnit(CompanyVO companyVO)
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>showProductUsesUnitList()</code>this method is used to show Product
	 * Uses Unit grid from database.
	 * </p>
	 * 
	 * @param
	 * 
	 * @throws OMIApplicationException
	 */
	public List<CompanyVO> showProductUsesUnitList()
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>editCompanyTypeDetails()</code>this method is used to Update
	 * Company Type into database.
	 * </p>
	 * 
	 * @param companyTypeId
	 * @return Company
	 * @throws OMIApplicationException
	 */

	public Company editCompanyTypeDetails(int companyTypeId) throws Exception;

	/**
	 * <p>
	 * <code>updateCompanyType()</code>this method is used to Update Company
	 * Type into database.
	 * </p>
	 * 
	 * @param companyTypeId
	 *            ,companyVO
	 * @return message
	 * @throws OMIApplicationException
	 */

	public String updateCompanyType(CompanyVO companyVO, int companyTypeId)
			throws Exception;

	/**
	 * <p>
	 * <code>editGLAccount()</code>this method is used to Update GL Account into
	 * database.
	 * </p>
	 * 
	 * @param companyTypeId
	 * @return Company
	 * @throws OMIApplicationException
	 */
	public Company editGLAccount(int financeId) throws Exception;

	/**
	 * <p>
	 * <code>updateGLAccount()</code>this method is used to Update GL Account
	 * into database.
	 * </p>
	 * 
	 * @param financeId
	 *            ,companyVO
	 * @return message
	 * @throws OMIApplicationException
	 */
	public String updateGLAccount(CompanyVO companyVO, int financeId)
			throws Exception;

	/**
	 * <p>
	 * <code>editLeadSource()</code>this method is used to Update Lead Source
	 * into database.
	 * </p>
	 * 
	 * @param leadsourceID
	 * @return Company
	 * @throws OMIApplicationException
	 */
	public Company editLeadSource(int leadsourceID) throws Exception;

	/**
	 * <p>
	 * <code>updateLeadSource()</code>this method is used to Update Lead Source
	 * into database.
	 * </p>
	 * 
	 * @param leadsourceID
	 *            ,companyVO
	 * @return message
	 * @throws OMIApplicationException
	 */
	public String updateLeadSource(CompanyVO companyVO, int leadsourceID)
			throws Exception;

	/**
	 * <p>
	 * <code>editTax()</code>this method is used to Update Tax into database.
	 * </p>
	 * 
	 * @param financeId
	 * @return Company
	 * @throws OMIApplicationException
	 */

	public Company editTax(int financeId) throws Exception;

	/**
	 * <p>
	 * <code>updateTax()</code>this method is used to Update Tax into database.
	 * </p>
	 * 
	 * @param financeId
	 *            ,companyVO
	 * @return message
	 * 
	 * @throws OMIApplicationException
	 */

	public String updateTax(CompanyVO companyVO, int financeId)
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>editCompanyCategoryDetails()</code>this method is used to Update
	 * Company Category into database.
	 * </p>
	 * 
	 * @param companyCategoryID
	 * @return Company
	 * @throws OMIApplicationException
	 */

	public Company editCompanyCategoryDetails(int companyCategoryID)
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>updateCompanyCategory()</code>this method is used to Update Company
	 * Category into database.
	 * </p>
	 * 
	 * @param companyCategoryID
	 *            ,companyVO
	 * @return message
	 * 
	 * @throws OMIApplicationException
	 */

	public String updateCompanyCategory(CompanyVO companyVO,
			int companyCategoryID) throws OMIApplicationException;

	/**
	 * <p>
	 * <code>editCompanySectoryDetails()</code>this method is used to Update
	 * Company Sector into database.
	 * </p>
	 * 
	 * @param companysectorid
	 * @return Company
	 * @throws OMIApplicationException
	 */

	public Company editCompanySectorDetails(int companysectorid)
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>updateCompanySector()</code>this method is used to Update Company
	 * Sector into database.
	 * </p>
	 * 
	 * @param companysectorid
	 *            ,companyVO
	 * @return message
	 * 
	 * @throws OMIApplicationException
	 */

	public String updateCompanySector(CompanyVO companyVO, int companysectorid)
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>editAccountType()</code>this method is used to Update Account type
	 * into database.
	 * </p>
	 * 
	 * @param accountTypeId
	 * @return Company
	 * @throws OMIApplicationException
	 */

	public Company editAccountType(int accountTypeId)
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>updateAccountType()</code>this method is used to Update Account
	 * type into database.
	 * </p>
	 * 
	 * @param accountTypeId
	 *            ,companyVO
	 * @return message
	 * 
	 * @throws OMIApplicationException
	 */

	public String updateAccountType(CompanyVO companyVO, int accountTypeId)
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>editCampaignType()</code>this method is used to Update Campaign
	 * type into database.
	 * </p>
	 * 
	 * @param campaigntypeID
	 * @return Company
	 * @throws OMIApplicationException
	 */

	public Company editCampaignType(int campaigntypeID)
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>updateCampaignType()</code>this method is used to Update Campaign
	 * type into database.
	 * </p>
	 * 
	 * @param campaigntypeID
	 *            ,companyVO
	 * @return message
	 * 
	 * @throws OMIApplicationException
	 */

	public String updateCampaignType(CompanyVO companyVO, int campaigntypeID)
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>editVendorCategoryDetails()</code>this method is used to Update
	 * Vendor Category into database.
	 * </p>
	 * 
	 * @param vendorCategoryId
	 * @return Company
	 * @throws OMIApplicationException
	 */

	public Company editVendorCategoryDetails(int vendorCategoryId)
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>updateVendorCategory()</code>this method is used to Update Vendor
	 * Category into database.
	 * </p>
	 * 
	 * @param vendorCategoryId
	 *            ,companyVO
	 * @return message
	 * 
	 * @throws OMIApplicationException
	 */

	public String updateVendorCategory(CompanyVO companyVO, int vendorCategoryId)
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>editTravelModeDetails()</code>this method is used to Update Travel
	 * Mode into database.
	 * </p>
	 * 
	 * @param travelmodeID
	 * @return Company
	 * @throws OMIApplicationException
	 */
	public Company editTravelModeDetails(int travelmodeID)
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>updateTravelMode()</code>this method is used to Update travel Mode
	 * into database.
	 * </p>
	 * 
	 * @param travelmodeID
	 *            ,companyVO
	 * @return message
	 * 
	 * @throws OMIApplicationException
	 */
	public String updateTravelMode(CompanyVO companyVO, int travelmodeID)
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>editProductCategoryDetails()</code>this method is used to Update
	 * Product Category into database.
	 * </p>
	 * 
	 * @param productCategoryId
	 * @return Company
	 * @throws OMIApplicationException
	 */
	public Company editProductCategoryDetails(int productCategoryId)
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>updateProductCategory()</code>this method is used to Update Product
	 * Category into database.
	 * </p>
	 * 
	 * @param productCategoryId
	 *            ,companyVO
	 * @return message
	 * 
	 * @throws OMIApplicationException
	 */
	public String updateProductCategory(CompanyVO companyVO,
			int productCategoryId) throws OMIApplicationException;

	/**
	 * <p>
	 * <code>editProductUsesUnitDetail()</code>this method is used to Update
	 * Product uses unit into database.
	 * </p>
	 * 
	 * @param productUsesUnitId
	 * @return Company
	 * @throws OMIApplicationException
	 */
	public Company editProductUsesUnitDetail(int productUsesUnitId)
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>updateProductUsesUnit()</code>this method is used to Update Product
	 * Uses Unit into database.
	 * </p>
	 * 
	 * @param productUsesUnitId
	 *            ,companyVO
	 * @return message
	 * 
	 * @throws OMIApplicationException
	 */
	public String updateProductUsesUnit(CompanyVO companyVO,
			int productUsesUnitId) throws OMIApplicationException;

	/**
	 * <p>
	 * <code>editFAQCategoryDetail()</code>this method is used to Update FAQ
	 * Category Category into database.
	 * </p>
	 * 
	 * @param faqcategoryId
	 * @return Company
	 * @throws OMIApplicationException
	 */
	public Company editFAQCategoryDetail(int faqcategoryId)
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>updateFAQCategory()</code>this method is used to Update FAQ
	 * Category into database.
	 * </p>
	 * 
	 * @param faqcategoryId
	 *            ,companyVO
	 * @return message
	 * 
	 * @throws OMIApplicationException
	 */
	public String updateFAQCategory(CompanyVO companyVO, int faqcategoryId)
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>editChannelDetail()</code>this method is used to Update Channel
	 * into database.
	 * </p>
	 * 
	 * @param channelId
	 * @return Company
	 * @throws OMIApplicationException
	 */
	public Company editChannelDetail(int channelId)
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>updateChannel()</code>this method is used to Update Channel into
	 * database.
	 * </p>
	 * 
	 * @param channelId
	 *            ,companyVO
	 * @return message
	 * 
	 * @throws OMIApplicationException
	 */
	public String updateChannel(CompanyVO companyVO, int channelId)
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>editTaskAreaDetail()</code>this method is used to Update Task Area
	 * into database.
	 * </p>
	 * 
	 * @param taskareaId
	 * @return Company
	 * @throws OMIApplicationException
	 */
	public Company editTaskAreaDetail(int taskareaId)
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>updateTaskArea()</code>this method is used to Update Task Area into
	 * database.
	 * </p>
	 * 
	 * @param taskareaId
	 *            ,companyVO
	 * @return message
	 * 
	 * @throws OMIApplicationException
	 */
	public String updateTaskArea(CompanyVO companyVO, int taskareaId)
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>addCountryDetail()</code>this method is inserting Country Details
	 * into TAB_COUNTRY
	 * 
	 * </p>
	 * 
	 * @param companyVO
	 * 
	 * @return message
	 * 
	 * @throws OMIApplicationException
	 */
	public String addCountryDetail(CompanyVO companyVO)
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>showCountryList()</code>this method is fetching a country Details
	 * From Table TAB_COUNTRY
	 * 
	 * </p>
	 * 
	 * 
	 * 
	 * @return CompanyVo
	 * 
	 * @throws OMIApplicationException
	 */
	public List<CompanyVO> showCountryList() throws OMIApplicationException;

	/**
	 * <p>
	 * <code>editCountry()</code>this method is to fetching a country details
	 * for updating into a TAB_COUNTRY
	 * </p>
	 * 
	 * @param countryId
	 * @return company
	 * @throws OMIApplicationException
	 */
	public Company editCountry(int countryId) throws OMIApplicationException;
	/**
	 * <p>
	 * <code>updateCountry()</code>this method is to used for updating a country details
	 *  into a TAB_COUNTRY
	 * </p>
	 * 
	 * @param countryId
	 * @return company
	 * @throws OMIApplicationException
	 */
	public String updateCountry(CompanyVO companyVO, int countryId)throws OMIApplicationException;

	public String insertProductType(CompanyVO companyVO) throws OMIApplicationException;

	public List<CompanyVO> showProductTypeGrid() throws OMIApplicationException;

	public Company editProductType(int productTypeId) throws OMIApplicationException;

	public String updateProductType(CompanyVO companyVO, int productTypeId) throws OMIApplicationException;

}
