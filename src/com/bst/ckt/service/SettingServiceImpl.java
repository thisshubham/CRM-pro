/**
 * 
 */
package com.bst.ckt.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.omg.PortableInterceptor.SUCCESSFUL;

import com.bst.ckt.common.OMIConstants;
import com.bst.ckt.dao.SettingDaoImpl;
import com.bst.ckt.dao.SettingDaoInf;
import com.bst.ckt.dto.Company;
import com.bst.ckt.exception.OMIApplicationException;
import com.bst.ckt.vo.CompanyVO;

/**
 * @author Abhilash
 * 
 */
public class SettingServiceImpl implements SettingServiceInf {

	SettingDaoInf settingDaoInf = null;
	Company company = null;

	/**
	 * Creating Logger object, logger object mapped with AccountServiceImpl
	 * class for writing Loggers.
	 */

	public static final Logger logger = Logger
			.getLogger(SettingServiceImpl.class);

	/**
	 * <p>
	 * <code>editSettingInfo()</code> This method is design to fetch company
	 * details for update process from database.
	 * <p>
	 * 
	 * @param companyId
	 * @throws OMIApplicationException
	 */

	@Override
	public Company editSettingInfo(int companyId)
			throws OMIApplicationException {
		settingDaoInf = new SettingDaoImpl();
		Company company = null;
		company = settingDaoInf.getCompanyInformation(companyId);
		return company;

	}

	/**
	 * <p>
	 * <code>updateCompanyDetails()</code> This method is design to update
	 * company details into database.
	 * <p>
	 * 
	 * @param companyId
	 *            ,CompanyVO companyVO
	 * @throws OMIApplicationException
	 */

	@Override
	public String updateCompanyDetails(CompanyVO companyVO, int companyId)
			throws OMIApplicationException {

		settingDaoInf = new SettingDaoImpl();

		int target = settingDaoInf.updateCompanyInformation(companyVO,
				companyId);

		if (target == 1) {
			logger.info("Successfully Update Company Information!");
			return OMIConstants.TARGET_SUCCESS;
		} else {

			logger.info("Error:while  Updating Company Information!");
			return OMIConstants.TARGET_FAILURE;
		}
	}

	/**
	 * <p>
	 * <code>addCompanyType()</code> This method is design to insert company
	 * Type into database.
	 * <p>
	 * 
	 * @param CompanyVO
	 *            companyVO
	 * 
	 * @throws OMIApplicationException
	 */

	@Override
	public String addCompanyType(CompanyVO companyVO)
			throws OMIApplicationException {
		settingDaoInf = new SettingDaoImpl();
		int target = settingDaoInf.addCompanyType(companyVO);
		if (target == 1) {
			logger.info("Successfully inserted Company Type Information!");
			return OMIConstants.TARGET_SUCCESS;
		} else {

			logger.info("Error:while inserted Company Type Information!");
			return OMIConstants.TARGET_FAILURE;
		}
	}

	/**
	 * <p>
	 * <code>showCompanyTypeGrid()</code> This method is design to show a
	 * company Type Grid into TAB_COMPANY_TYPE.
	 * <p>
	 * 
	 * @param
	 * 
	 * @throws OMIApplicationException
	 */
	@Override
	public List<CompanyVO> showCompanyTypeGrid() throws OMIApplicationException {
		settingDaoInf = new SettingDaoImpl();

		return settingDaoInf.getCompanyTypeGrid();
	}

	/**
	 * <p>
	 * <code>addFinanceTax()</code> This method is design to insert Finance
	 * Taxes into database.
	 * <p>
	 * 
	 * @param CompanyVO
	 *            companyVO
	 * 
	 * @throws OMIApplicationException
	 */

	@Override
	public String addFinanceTax(CompanyVO companyVO)
			throws OMIApplicationException {
		settingDaoInf = new SettingDaoImpl();
		int target = settingDaoInf.addFinanceTax(companyVO);
		if (target == 1) {
			logger.info("Successfully inserted Taxes Information!");
			return OMIConstants.TARGET_SUCCESS;
		} else {

			logger.info("Error:while inserted Taxes Information!");
			return OMIConstants.TARGET_FAILURE;
		}
	}

	/**
	 * <p>
	 * <code>showFinanceTaxGrid()</code> This method is design to show a Taxes
	 * Grid into TAB_TAX.
	 * <p>
	 * 
	 * @param
	 * 
	 * @throws OMIApplicationException
	 */

	@Override
	public List<CompanyVO> showFinanceTaxGrid() throws OMIApplicationException {

		settingDaoInf = new SettingDaoImpl();
		return settingDaoInf.showFinanceTaxGrid();
	}

	/**
	 * <p>
	 * <code>showProductCategoryGrid()</code> This method is design to show a
	 * Product Category Grid from TAB_.
	 * <p>
	 * 
	 * @param
	 * 
	 * @throws OMIApplicationException
	 */

	@Override
	public List<CompanyVO> showProductCategoryGrid()
			throws OMIApplicationException {
		settingDaoInf = new SettingDaoImpl();
		return settingDaoInf.showProductCategoryGrid();
	}

	/**
	 * <p>
	 * <code>addProductCategory()</code> This method is design to insert Product
	 * Category into database.
	 * <p>
	 * 
	 * @param CompanyVO
	 *            companyVO
	 * 
	 * @throws OMIApplicationException
	 */
	@Override
	public String addProductCategory(CompanyVO companyVO)
			throws OMIApplicationException {
		settingDaoInf = new SettingDaoImpl();
		int target = settingDaoInf.addProductCategory(companyVO);
		if (target == 1) {
			logger.info("Successfully inserted Product Category Information!");
			return OMIConstants.TARGET_SUCCESS;
		} else {

			logger.info("Error:while inserted Product Category Information!");
			return OMIConstants.TARGET_FAILURE;
		}
	}

	/**
	 * <p>
	 * <code>showCompanyCategoeyGrid()</code> This method is design to show a
	 * Company Category Grid into TAB_COMPANY_CATEGORY.
	 * <p>
	 * 
	 * @param
	 * 
	 * @throws OMIApplicationException
	 */

	@Override
	public List<CompanyVO> showCompanyCategoeyGrid()
			throws OMIApplicationException {
		settingDaoInf = new SettingDaoImpl();
		return settingDaoInf.showCompanyCategoeyGrid();
	}

	/**
	 * <p>
	 * <code>addCompanyCategory()</code> This method is design to insert Company
	 * Category into database.
	 * <p>
	 * 
	 * @param CompanyVO
	 *            companyVO
	 * 
	 * @throws OMIApplicationException
	 */

	@Override
	public String addCompanyCategory(CompanyVO companyVO)
			throws OMIApplicationException {
		settingDaoInf = new SettingDaoImpl();
		int target = settingDaoInf.addCompanyCategory(companyVO);
		if (target == 1) {
			logger.info("Successfully inserted Company Category Information!");
			return OMIConstants.TARGET_SUCCESS;
		} else {

			logger.info("Error:while inserted Company Category Information!");
			return OMIConstants.TARGET_FAILURE;
		}
	}

	/**
	 * <p>
	 * <code>addCompanyLocal()</code> This method is design to insert Company
	 * Local into database.
	 * <p>
	 * 
	 * @param CompanyVO
	 *            companyVO
	 * 
	 * @throws OMIApplicationException
	 */
	@Override
	public String addSupportCaseImpact(CompanyVO companyVO)
			throws OMIApplicationException {
		settingDaoInf = new SettingDaoImpl();
		int target = settingDaoInf.addSupportCaseImpact(companyVO);
		if (target == 1) {
			logger.info("Successfully inserted Case Impact Information!");
			return OMIConstants.TARGET_SUCCESS;
		} else {

			logger.info("Error:while inserted Case Impact Information!");
			return OMIConstants.TARGET_FAILURE;
		}
	}

	/**
	 * <p>
	 * <code>showSupportCaseImpactList()</code> This method is design to show a
	 * Case Impact Grid from database.
	 * <p>
	 * 
	 * @param
	 * 
	 * @throws OMIApplicationException
	 */
	@Override
	public List<CompanyVO> showSupportCaseImpactList()
			throws OMIApplicationException {
		settingDaoInf = new SettingDaoImpl();
		return settingDaoInf.showSupportCaseImpactList();
	}

	/**
	 * <p>
	 * <code>addCompanySector()</code> This method is design to insert Company
	 * Sector into database.
	 * <p>
	 * 
	 * @param CompanyVO
	 *            companyVO
	 * 
	 * @throws OMIApplicationException
	 */

	@Override
	public String addCompanySector(CompanyVO companyVO)
			throws OMIApplicationException {
		settingDaoInf = new SettingDaoImpl();
		int target = settingDaoInf.addCompanySector(companyVO);
		if (target == 1) {
			logger.info("Successfully inserted Company Sector Information!");
			return OMIConstants.TARGET_SUCCESS;
		} else {

			logger.info("Error:while inserted Company Sector Information!");
			return OMIConstants.TARGET_FAILURE;
		}
	}

	/**
	 * <p>
	 * <code>showCompanySectorList()</code> This method is design to show a
	 * Company Category Grid into TAB_COMPANY_SECTOR.
	 * <p>
	 * 
	 * @param
	 * 
	 * @throws OMIApplicationException
	 */

	@Override
	public List<CompanyVO> showCompanySectorList()
			throws OMIApplicationException {
		settingDaoInf = new SettingDaoImpl();
		return settingDaoInf.showCompanySectorList();
	}

	@Override
	public String addFinanceGLAccount(CompanyVO companyVO)
			throws OMIApplicationException {
		settingDaoInf = new SettingDaoImpl();
		int target = settingDaoInf.addFinanceGLAccount(companyVO);
		if (target == 1) {
			logger.info("Successfully inserted GL Account Information!");
			return OMIConstants.TARGET_SUCCESS;
		} else {

			logger.info("Error:while inserted GL Account Information!");
			return OMIConstants.TARGET_FAILURE;
		}
	}

	/**
	 * <p>
	 * <code>showFinanaceGLAccountList()</code> This method is design to show a
	 * Company Category Grid into TAB_GL_ACCOUNT.
	 * <p>
	 * 
	 * @param
	 * 
	 * @throws OMIApplicationException
	 */

	@Override
	public List<CompanyVO> showFinanaceGLAccountList()
			throws OMIApplicationException {
		settingDaoInf = new SettingDaoImpl();
		return settingDaoInf.showFinanaceGLAccountList();
	}

	/**
	 * <p>
	 * <code>addMarketingLeadSource()</code> This method is design to insert
	 * Lead source into database.
	 * <p>
	 * 
	 * @param CompanyVO
	 *            companyVO
	 * 
	 * @throws OMIApplicationException
	 */
	@Override
	public String addMarketingLeadSource(CompanyVO companyVO)
			throws OMIApplicationException {
		settingDaoInf = new SettingDaoImpl();
		int target = settingDaoInf.addMarketingLeadSource(companyVO);
		if (target == 1) {
			logger.info("Successfully inserted Lead Source Information!");
			return OMIConstants.TARGET_SUCCESS;
		} else {

			logger.info("Error:while inserted Lead Source Information!");
			return OMIConstants.TARGET_FAILURE;
		}

	}

	/**
	 * <p>
	 * <code>showMarketingLeadSourceList()</code> This method is design to show
	 * a Lead Source Grid from TAB_LEAD_SOURCE.
	 * <p>
	 * 
	 * @param
	 * 
	 * @throws OMIApplicationException
	 */

	@Override
	public List<CompanyVO> showMarketingLeadSourceList()
			throws OMIApplicationException {
		settingDaoInf = new SettingDaoImpl();
		return settingDaoInf.showMarketingLeadSourceList();
	}

	/**
	 * <p>
	 * <code>addMarketingAccountType()</code> This method is design to insert
	 * Account Type into database.
	 * <p>
	 * 
	 * @param CompanyVO
	 *            companyVO
	 * 
	 * @throws OMIApplicationException
	 */

	@Override
	public String addMarketingAccountType(CompanyVO companyVO)
			throws OMIApplicationException {
		settingDaoInf = new SettingDaoImpl();
		int target = settingDaoInf.addMarketingAccountType(companyVO);
		if (target == 1) {
			logger.info("Successfully inserted Account Type Information!");
			return OMIConstants.TARGET_SUCCESS;
		} else {

			logger.info("Error:while inserted Account Type Information!");
			return OMIConstants.TARGET_FAILURE;
		}
	}

	/**
	 * <p>
	 * <code>showMarketingAccountTypeList()</code> This method is design to show
	 * a Account Type Grid from TAB_ACCOUNT_TYPE.
	 * <p>
	 * 
	 * @param
	 * 
	 * @throws OMIApplicationException
	 */
	@Override
	public List<CompanyVO> showMarketingAccountTypeList()
			throws OMIApplicationException {
		settingDaoInf = new SettingDaoImpl();
		return settingDaoInf.showMarketingAccountTypeList();
	}

	@Override
	public List<CompanyVO> showMarketingSlaNameList()
			throws OMIApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addMarketingSlaName(CompanyVO companyVO)
			throws OMIApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * <p>
	 * <code>addMarketingCampaignType()</code> This method is design to insert
	 * Campaign Type into database.
	 * <p>
	 * 
	 * @param CompanyVO
	 *            companyVO
	 * 
	 * @throws OMIApplicationException
	 */

	@Override
	public String addMarketingCampaignType(CompanyVO companyVO)
			throws OMIApplicationException {
		settingDaoInf = new SettingDaoImpl();
		int target = settingDaoInf.addMarketingCampaignType(companyVO);
		if (target == 1) {
			logger.info("Successfully inserted Campaign Type Information!");
			return OMIConstants.TARGET_SUCCESS;
		} else {

			logger.info("Error:while inserted Campaign Type Information!");
			return OMIConstants.TARGET_FAILURE;
		}
	}

	/**
	 * <p>
	 * <code>showMarketingCampaignTypeList()</code> This method is design to
	 * show a Campaign Type Grid from TAB_CAMPAIGN_TYPE.
	 * <p>
	 * 
	 * @param
	 * 
	 * @throws OMIApplicationException
	 */
	@Override
	public List<CompanyVO> showMarketingCampaignTypeList()
			throws OMIApplicationException {
		settingDaoInf = new SettingDaoImpl();
		return settingDaoInf.showMarketingCampaignTypeList();
	}

	/**
	 * <p>
	 * <code>addMarketingResponse()</code> This method is design to insert
	 * Response into database.
	 * <p>
	 * 
	 * @param CompanyVO
	 *            companyVO
	 * 
	 * @throws OMIApplicationException
	 */
	@Override
	public String addMarketingResponse(CompanyVO companyVO)
			throws OMIApplicationException {
		settingDaoInf = new SettingDaoImpl();
		int target = settingDaoInf.addMarketingResponse(companyVO);
		if (target == 1) {
			logger.info("Successfully inserted Response Information!");
			return OMIConstants.TARGET_SUCCESS;
		} else {

			logger.info("Error:while inserted Response Information!");
			return OMIConstants.TARGET_FAILURE;
		}
	}

	/**
	 * <p>
	 * <code>showMarketingResponseList()</code> This method is design to show a
	 * Response Grid from .
	 * <p>
	 * 
	 * @param
	 * 
	 * @throws OMIApplicationException
	 */
	@Override
	public List<CompanyVO> showMarketingResponseList()
			throws OMIApplicationException {
		settingDaoInf = new SettingDaoImpl();
		return settingDaoInf.showMarketingResponseList();
	}

	/**
	 * <p>
	 * <code>addMarketingVendorCategory()</code> This method is design to insert
	 * Vendor Category into database.
	 * <p>
	 * 
	 * @param CompanyVO
	 *            companyVO
	 * 
	 * @throws OMIApplicationException
	 */
	@Override
	public String addMarketingVendorCategory(CompanyVO companyVO)
			throws OMIApplicationException {
		settingDaoInf = new SettingDaoImpl();
		int target = settingDaoInf.addMarketingVendorCategory(companyVO);
		if (target == 1) {
			logger.info("Successfully inserted Vendor Category Information!");
			return OMIConstants.TARGET_SUCCESS;
		} else {

			logger.info("Error:while inserted Vendor Category Information!");
			return OMIConstants.TARGET_FAILURE;
		}
	}

	/**
	 * <p>
	 * <code>showMarketingVendorcategoryList()</code> This method is design to
	 * show a Vendor Category Grid from TAB_VENDOR_CATEGORY.
	 * <p>
	 * 
	 * @param
	 * 
	 * @throws OMIApplicationException
	 */
	@Override
	public List<CompanyVO> showMarketingVendorcategoryList()
			throws OMIApplicationException {
		settingDaoInf = new SettingDaoImpl();
		return settingDaoInf.showMarketingVendorcategoryList();
	}

	/**
	 * <p>
	 * <code>addMarketingTravelMode()</code> This method is design to insert
	 * Travel Mode into database.
	 * <p>
	 * 
	 * @param CompanyVO
	 *            companyVO
	 * 
	 * @throws OMIApplicationException
	 */
	@Override
	public String addMarketingTravelMode(CompanyVO companyVO)
			throws OMIApplicationException {
		settingDaoInf = new SettingDaoImpl();
		int target = settingDaoInf.addMarketingTravelMode(companyVO);
		if (target == 1) {
			logger.info("Successfully inserted Travel Mode Information!");
			return OMIConstants.TARGET_SUCCESS;
		} else {

			logger.info("Error:while inserted Travel Mode Information!");
			return OMIConstants.TARGET_FAILURE;
		}
	}

	/**
	 * <p>
	 * <code>showMarketingtravelModeList()</code> This method is design to show
	 * a Travel Mode Grid from TAB_TRAVEL_MODE.
	 * <p>
	 * 
	 * @param
	 * 
	 * @throws OMIApplicationException
	 */
	@Override
	public List<CompanyVO> showMarketingtravelModeList()
			throws OMIApplicationException {
		settingDaoInf = new SettingDaoImpl();
		return settingDaoInf.showMarketingtravelModeList();
	}

	/**
	 * <p>
	 * <code>addSupportFAQCategory()</code> This method is design to insert FAQ
	 * Category into database.
	 * <p>
	 * 
	 * @param CompanyVO
	 *            companyVO
	 * 
	 * @throws OMIApplicationException
	 */
	@Override
	public String addSupportFAQCategory(CompanyVO companyVO)
			throws OMIApplicationException {
		settingDaoInf = new SettingDaoImpl();
		int target = settingDaoInf.addSupportFAQCategory(companyVO);
		if (target == 1) {
			logger.info("Successfully inserted FAQ Category Information!");
			return OMIConstants.TARGET_SUCCESS;
		} else {

			logger.info("Error:while inserted FAQ Category Information!");
			return OMIConstants.TARGET_FAILURE;
		}
	}

	/**
	 * <p>
	 * <code>showSupportfaqCategoryList()</code> This method is design to show a
	 * FAQ Category Grid from TAB_FAQ_CATEGORY
	 * <p>
	 * 
	 * @param
	 * 
	 * @throws OMIApplicationException
	 */
	@Override
	public List<CompanyVO> showSupportfaqCategoryList()
			throws OMIApplicationException {
		settingDaoInf = new SettingDaoImpl();
		return settingDaoInf.showSupportfaqCategoryList();
	}

	/**
	 * <p>
	 * <code>addSupportChannel()</code> This method is design to insert Channel
	 * into database.
	 * <p>
	 * 
	 * @param CompanyVO
	 *            companyVO
	 * 
	 * @throws OMIApplicationException
	 */

	@Override
	public String addSupportChannel(CompanyVO companyVO)
			throws OMIApplicationException {
		settingDaoInf = new SettingDaoImpl();
		int target = settingDaoInf.addSupportChannel(companyVO);
		if (target == 1) {
			logger.info("Successfully inserted channel Information!");
			return OMIConstants.TARGET_SUCCESS;
		} else {

			logger.info("Error:while inserted Channel Information!");
			return OMIConstants.TARGET_FAILURE;
		}
	}

	/**
	 * <p>
	 * <code>showSupportChannelList()</code> This method is design to show a
	 * Channel Grid from TAB_CASES_CHANNEL
	 * <p>
	 * 
	 * @param
	 * 
	 * @throws OMIApplicationException
	 */
	@Override
	public List<CompanyVO> showSupportChannelList()
			throws OMIApplicationException {
		settingDaoInf = new SettingDaoImpl();
		return settingDaoInf.showSupportChannelList();
	}

	/**
	 * <p>
	 * <code>addSupportTaskArea()</code> This method is design to insert task
	 * Area into database.
	 * <p>
	 * 
	 * @param CompanyVO
	 *            companyVO
	 * 
	 * @throws OMIApplicationException
	 */

	@Override
	public String addSupportTaskArea(CompanyVO companyVO)
			throws OMIApplicationException {
		settingDaoInf = new SettingDaoImpl();
		int target = settingDaoInf.addSupportTaskArea(companyVO);
		if (target == 1) {
			logger.info("Successfully inserted Task Area Information!");
			return OMIConstants.TARGET_SUCCESS;
		} else {

			logger.info("Error:while inserted Task Area Information!");
			return OMIConstants.TARGET_FAILURE;
		}
	}

	/**
	 * <p>
	 * <code>showSupportTaskAreaList()</code> This method is design to show a
	 * Task Area Grid from TAB_TASK_AREA
	 * <p>
	 * 
	 * @param
	 * 
	 * @throws OMIApplicationException
	 */

	@Override
	public List<CompanyVO> showSupportTaskAreaList()
			throws OMIApplicationException {
		settingDaoInf = new SettingDaoImpl();
		return settingDaoInf.showSupportTaskAreaList();
	}

	/**
	 * <p>
	 * <code>addCompanyLocal()</code> This method is design to insert Company
	 * Local into database.
	 * <p>
	 * 
	 * @param CompanyVO
	 *            companyVO
	 * 
	 * @throws OMIApplicationException
	 */
	@Override
	public String updateCompanyLocal(CompanyVO companyVO, int customerId)
			throws OMIApplicationException {
		settingDaoInf = new SettingDaoImpl();
		int target = settingDaoInf.updateCompanyLocal(companyVO, customerId);
		if (target == 1) {
			logger.info("Successfully Updated Company Local Information!");
			return OMIConstants.TARGET_SUCCESS;
		} else {

			logger.info("Error:while Updated Company Local Information!");
			return OMIConstants.TARGET_FAILURE;
		}
	}

	/**
	 * <p>
	 * <code>showCompanyLocalList()</code> This method is design to show a
	 * Company Local Grid from database.
	 * <p>
	 * 
	 * @param
	 * 
	 * @throws OMIApplicationException
	 */
	@Override
	public List<CompanyVO> showCompanyLocalList()
			throws OMIApplicationException {
		settingDaoInf = new SettingDaoImpl();
		return settingDaoInf.showCompanyLocalList();
	}

	/**
	 * <p>
	 * <code>addProductUsesUnit()</code> This method is design to insert Product
	 * Uses Unit into database.
	 * <p>
	 * 
	 * @param CompanyVO
	 *            companyVO
	 * @return TARGET_SUCCESS, TARGET_FAILURE
	 * @throws OMIApplicationException
	 */
	@Override
	public String addProductUsesUnit(CompanyVO companyVO)
			throws OMIApplicationException {
		settingDaoInf = new SettingDaoImpl();
		int target = settingDaoInf.addProductUsesUnit(companyVO);
		if (target == 1) {
			logger.info("Successfully inserted Product Uses Unit Information!");
			return OMIConstants.TARGET_SUCCESS;
		} else {

			logger.info("Error:while inserted Product Uses Unit Information!");
			return OMIConstants.TARGET_FAILURE;
		}
	}

	/**
	 * <p>
	 * <code>showProductUsesUnitList()</code> This method is design to show a
	 * Product Uses Unit Grid from database.
	 * <p>
	 * 
	 * @param
	 * @return showProductUsesUnitList
	 * @throws OMIApplicationException
	 */
	@Override
	public List<CompanyVO> showProductUsesUnitList()
			throws OMIApplicationException {
		settingDaoInf = new SettingDaoImpl();
		return settingDaoInf.showProductUsesUnitList();
	}

	/**
	 * <p>
	 * <code>editCompanyTypeDetails()</code> This method is Used for getting
	 * company type from database.
	 * <p>
	 * 
	 * @param companyTypeId
	 * @return company
	 * @throws OMIApplicationException
	 */
	@Override
	public Company editCompanyTypeDetails(int companyTypeId) throws Exception {
		company = new Company();
		settingDaoInf = new SettingDaoImpl();
		try {
			company = settingDaoInf
					.showCompanyTypeDetailsForUpdate(companyTypeId);
		} catch (Exception exception) {
			logger.info("Error:while getting a company Type  Information!");
		}
		return company;

	}

	/**
	 * <p>
	 * <code>updateCompanyType()</code> This method is Used for Update company
	 * type into database.
	 * <p>
	 * 
	 * @param companyTypeId
	 * @return success,failure
	 * @throws OMIApplicationException
	 */
	@Override
	public String updateCompanyType(CompanyVO companyVO, int companyTypeId)
			throws Exception {
		settingDaoInf = new SettingDaoImpl();
		int target = settingDaoInf.updateCompanyTypeInfo(companyVO,
				companyTypeId);

		if (target == 1) {
			logger.info("Successfully Update Company Type Information!");
			return OMIConstants.TARGET_SUCCESS;
		} else {

			logger.info("Error:while  Updating Company Type Information!");
			return OMIConstants.TARGET_FAILURE;
		}
	}

	/**
	 * <p>
	 * <code>editGLAccount()</code> This method is Used for getting GL Account
	 * from database.
	 * <p>
	 * 
	 * @param financeId
	 * @return company
	 * @throws OMIApplicationException
	 */
	@Override
	public Company editGLAccount(int financeId) throws Exception {
		company = new Company();
		settingDaoInf = new SettingDaoImpl();
		try {
			company = settingDaoInf.showGLAccountDetails(financeId);
		} catch (Exception exception) {
			logger.info("Error:while getting a GL Account  Information!");
		}
		return company;

	}

	/**
	 * <p>
	 * <code>updateGLAccount()</code> This method is Used for Update GL Account
	 * into database.
	 * <p>
	 * 
	 * @param financeId
	 * @return success,failure
	 * @throws OMIApplicationException
	 */
	@Override
	public String updateGLAccount(CompanyVO companyVO, int financeId)
			throws Exception {
		settingDaoInf = new SettingDaoImpl();
		int target = settingDaoInf.updateGLAccountDetail(companyVO, financeId);

		if (target == 1) {
			logger.info("Successfully Update GL Account Information!");
			return OMIConstants.TARGET_SUCCESS;
		} else {

			logger.info("Error:while  Updating GL Account Information!");
			return OMIConstants.TARGET_FAILURE;
		}
	}

	/**
	 * <p>
	 * <code>editLeadSource()</code> This method is Used for getting Lead Source
	 * from database.
	 * <p>
	 * 
	 * @param leadsourceID
	 * @return company
	 * @throws OMIApplicationException
	 */
	@Override
	public Company editLeadSource(int leadsourceID) throws Exception {
		company = new Company();
		settingDaoInf = new SettingDaoImpl();
		try {
			company = settingDaoInf.showLeadSourceDetails(leadsourceID);
		} catch (Exception exception) {
			logger.info("Error:while getting a Lead Source  Information!");
		}
		return company;
	}

	/**
	 * <p>
	 * <code>updateLeadSource()</code> This method is Used for Update Lead
	 * Source into database.
	 * <p>
	 * 
	 * @param leadsourceID
	 * @return success,failure
	 * @throws OMIApplicationException
	 */
	@Override
	public String updateLeadSource(CompanyVO companyVO, int leadsourceID)
			throws Exception {
		settingDaoInf = new SettingDaoImpl();
		int target = settingDaoInf.updateLeadSourceDetail(companyVO,
				leadsourceID);

		if (target == 1) {
			logger.info("Successfully Update Lead Source Information!");
			return OMIConstants.TARGET_SUCCESS;
		} else {

			logger.info("Error:while  Updating Lead Source Information!");
			return OMIConstants.TARGET_FAILURE;
		}
	}

	/**
	 * <p>
	 * <code>editTax()</code> This method is Used for getting Tax from database.
	 * <p>
	 * 
	 * @param financeId
	 * @return company
	 * @throws OMIApplicationException
	 */
	@Override
	public Company editTax(int financeId) throws Exception {
		company = new Company();
		settingDaoInf = new SettingDaoImpl();
		try {
			company = settingDaoInf.showTaxDetails(financeId);
		} catch (Exception exception) {
			logger.info("Error:while getting a Tax Information!");
		}
		return company;
	}

	/**
	 * <p>
	 * <code>updateTax()</code> This method is Used for Update Tax into
	 * database.
	 * <p>
	 * 
	 * @param financeId
	 * @return success,failure
	 * @throws OMIApplicationException
	 */
	@Override
	public String updateTax(CompanyVO companyVO, int financeId)
			throws OMIApplicationException {
		settingDaoInf = new SettingDaoImpl();
		int target = settingDaoInf.updateTaxDetail(companyVO, financeId);

		if (target == 1) {
			logger.info("Successfully Update Tax Information!");
			return OMIConstants.TARGET_SUCCESS;
		} else {

			logger.info("Error:while  Updating Tax Information!");
			return OMIConstants.TARGET_FAILURE;
		}
	}

	/**
	 * <p>
	 * <code>editCompanyCategoryDetails()</code> This method is Used for getting
	 * Company Category from database.
	 * <p>
	 * 
	 * @param companyCategoryID
	 * @return company
	 * @throws OMIApplicationException
	 */
	@Override
	public Company editCompanyCategoryDetails(int companyCategoryID)
			throws OMIApplicationException {
		company = new Company();
		settingDaoInf = new SettingDaoImpl();
		try {
			company = settingDaoInf
					.showCompanyCategoryDetails(companyCategoryID);
		} catch (Exception exception) {
			logger.info("Error:while getting a Company Category Information!");
		}
		return company;
	}

	/**
	 * <p>
	 * <code>updateCompanyCategory()</code> This method is Used for Update
	 * Company Category into database.
	 * <p>
	 * 
	 * @param financeId
	 * @return success,failure
	 * @throws OMIApplicationException
	 */
	@Override
	public String updateCompanyCategory(CompanyVO companyVO,
			int companyCategoryID) throws OMIApplicationException {
		settingDaoInf = new SettingDaoImpl();
		int target = settingDaoInf.updateCompanyCategoryDetail(companyVO,
				companyCategoryID);

		if (target == 1) {
			logger.info("Successfully Update Company Category Information!");
			return OMIConstants.TARGET_SUCCESS;
		} else {

			logger.info("Error:while  Updating Company Category Information!");
			return OMIConstants.TARGET_FAILURE;
		}
	}

	/**
	 * <p>
	 * <code>editCompanySectorDetails()</code> This method is Used for getting
	 * Company Sector from database.
	 * <p>
	 * 
	 * @param companysectorid
	 * @return company
	 * @throws OMIApplicationException
	 */
	@Override
	public Company editCompanySectorDetails(int companysectorid)
			throws OMIApplicationException {
		company = new Company();
		settingDaoInf = new SettingDaoImpl();
		try {
			company = settingDaoInf.showCompanySectorDetails(companysectorid);
		} catch (Exception exception) {
			logger.info("Error:while getting a Company Sector Information!");
		}
		return company;
	}

	/**
	 * <p>
	 * <code>updateCompanySector()</code> This method is Used for Update Company
	 * Sector into database.
	 * <p>
	 * 
	 * @param companysectorid
	 * @return success,failure
	 * @throws OMIApplicationException
	 */
	@Override
	public String updateCompanySector(CompanyVO companyVO, int companysectorid)
			throws OMIApplicationException {
		settingDaoInf = new SettingDaoImpl();
		int target = settingDaoInf.updateCompanySectorDetail(companyVO,
				companysectorid);

		if (target == 1) {
			logger.info("Successfully Update Company Sector Information!");
			return OMIConstants.TARGET_SUCCESS;
		} else {

			logger.info("Error:while  Updating Company Sector Information!");
			return OMIConstants.TARGET_FAILURE;
		}
	}

	/**
	 * <p>
	 * <code>editAccountType()</code> This method is Used for getting Account
	 * type from database.
	 * <p>
	 * 
	 * @param accountTypeId
	 * @return company
	 * @throws OMIApplicationException
	 */
	@Override
	public Company editAccountType(int accountTypeId)
			throws OMIApplicationException {
		company = new Company();
		settingDaoInf = new SettingDaoImpl();
		try {
			company = settingDaoInf.showAccounTypeDetails(accountTypeId);
		} catch (Exception exception) {
			logger.info("Error:while getting a Account type Information!");
		}
		return company;
	}

	/**
	 * <p>
	 * <code>updateAccountType()</code> This method is Used for Update Account
	 * type into database.
	 * <p>
	 * 
	 * @param accountTypeId
	 * @return success,failure
	 * @throws OMIApplicationException
	 */
	@Override
	public String updateAccountType(CompanyVO companyVO, int accountTypeId)
			throws OMIApplicationException {
		settingDaoInf = new SettingDaoImpl();
		int target = settingDaoInf.updateAccountTypeDetail(companyVO,
				accountTypeId);

		if (target == 1) {
			logger.info("Successfully Update Account Type Information!");
			return OMIConstants.TARGET_SUCCESS;
		} else {

			logger.info("Error:while  Updating Account Type Information!");
			return OMIConstants.TARGET_FAILURE;
		}
	}

	/**
	 * <p>
	 * <code>editCampaignType()</code> This method is Used for getting Campaign
	 * type from database.
	 * <p>
	 * 
	 * @param campaigntypeID
	 * @return company
	 * @throws OMIApplicationException
	 */
	@Override
	public Company editCampaignType(int campaigntypeID)
			throws OMIApplicationException {
		company = new Company();
		settingDaoInf = new SettingDaoImpl();
		try {
			company = settingDaoInf.showCampaignTypeDetails(campaigntypeID);
		} catch (Exception exception) {
			logger.info("Error:while getting a Campaign type Information!");
		}
		return company;
	}

	/**
	 * <p>
	 * <code>updateCampaignType()</code> This method is Used for Update Campaign
	 * type into database.
	 * <p>
	 * 
	 * @param campaigntypeID
	 * @return success,failure
	 * @throws OMIApplicationException
	 */
	@Override
	public String updateCampaignType(CompanyVO companyVO, int campaigntypeID)
			throws OMIApplicationException {
		settingDaoInf = new SettingDaoImpl();
		int target = settingDaoInf.updateCampaignTypeDetail(companyVO,
				campaigntypeID);

		if (target == 1) {
			logger.info("Successfully Update Campaign Type Information!");
			return OMIConstants.TARGET_SUCCESS;
		} else {

			logger.info("Error:while  Updating Campaign Type Information!");
			return OMIConstants.TARGET_FAILURE;
		}
	}

	/**
	 * <p>
	 * <code>editVendorCategoryDetails()</code> This method is Used for getting
	 * Vendor Category from database.
	 * <p>
	 * 
	 * @param vendorCategoryId
	 * @return company
	 * @throws OMIApplicationException
	 */
	@Override
	public Company editVendorCategoryDetails(int vendorCategoryId)
			throws OMIApplicationException {
		company = new Company();
		settingDaoInf = new SettingDaoImpl();
		try {
			company = settingDaoInf.showVendorCategoryDetails(vendorCategoryId);
		} catch (Exception exception) {
			logger.info("Error:while getting a Vendor Category Information!");
		}
		return company;
	}

	/**
	 * <p>
	 * <code>updateVendorCategory()</code> This method is Used for Update vendor
	 * Category into database.
	 * <p>
	 * 
	 * @param vendorCategoryId
	 * @return success,failure
	 * @throws OMIApplicationException
	 */
	@Override
	public String updateVendorCategory(CompanyVO companyVO, int vendorCategoryId)
			throws OMIApplicationException {
		settingDaoInf = new SettingDaoImpl();
		int target = settingDaoInf.updateVendorCategoryDetail(companyVO,
				vendorCategoryId);

		if (target == 1) {
			logger.info("Successfully Update Vendor Category Information!");
			return OMIConstants.TARGET_SUCCESS;
		} else {

			logger.info("Error:while  Updating Vendor Category Information!");
			return OMIConstants.TARGET_FAILURE;
		}
	}

	/**
	 * <p>
	 * <code>editTravelModeDetails()</code> This method is Used for getting
	 * Travel Mode from database.
	 * <p>
	 * 
	 * @param travelmodeID
	 * @return company
	 * @throws OMIApplicationException
	 */
	@Override
	public Company editTravelModeDetails(int travelmodeID)
			throws OMIApplicationException {
		company = new Company();
		settingDaoInf = new SettingDaoImpl();
		try {
			company = settingDaoInf.showTravelModeDetails(travelmodeID);
		} catch (Exception exception) {
			logger.info("Error:while getting a travel Mode Information!");
		}
		return company;
	}

	/**
	 * <p>
	 * <code>updateTravelMode()</code> This method is Used for Update travel
	 * Mode into database.
	 * <p>
	 * 
	 * @param travelmodeID
	 * @return success,failure
	 * @throws OMIApplicationException
	 */
	@Override
	public String updateTravelMode(CompanyVO companyVO, int travelmodeID)
			throws OMIApplicationException {
		settingDaoInf = new SettingDaoImpl();
		int target = settingDaoInf.updateTravelModeDetail(companyVO,
				travelmodeID);

		if (target == 1) {
			logger.info("Successfully Update Travel Mode Information!");
			return OMIConstants.TARGET_SUCCESS;
		} else {

			logger.info("Error:while  Updating travel Mode Information!");
			return OMIConstants.TARGET_FAILURE;
		}
	}

	/**
	 * <p>
	 * <code>editProductCategoryDetails()</code> This method is Used for getting
	 * Product Category from database.
	 * <p>
	 * 
	 * @param productCategoryId
	 * @return company
	 * @throws OMIApplicationException
	 */
	@Override
	public Company editProductCategoryDetails(int productCategoryId)
			throws OMIApplicationException {
		company = new Company();
		settingDaoInf = new SettingDaoImpl();
		try {
			company = settingDaoInf
					.showProductCategoryDetails(productCategoryId);
		} catch (Exception exception) {
			logger.info("Error:while getting a Product Category Information!");
		}
		return company;
	}

	/**
	 * <p>
	 * <code>updateProductCategory()</code> This method is Used for Update
	 * Product Category into database.
	 * <p>
	 * 
	 * @param productCategoryId
	 * @return success,failure
	 * @throws OMIApplicationException
	 */
	@Override
	public String updateProductCategory(CompanyVO companyVO,
			int productCategoryId) throws OMIApplicationException {
		settingDaoInf = new SettingDaoImpl();
		int target = settingDaoInf.updateProductCategoryDetail(companyVO,
				productCategoryId);

		if (target == 1) {
			logger.info("Successfully Update Product Category Information!");
			return OMIConstants.TARGET_SUCCESS;
		} else {

			logger.info("Error:while  Updating Product Category Information!");
			return OMIConstants.TARGET_FAILURE;
		}
	}

	/**
	 * <p>
	 * <code>editProductUsesUnitDetail()</code> This method is Used for getting
	 * Product Uses Unit from database.
	 * <p>
	 * 
	 * @param productUsesUnitId
	 * @return company
	 * @throws OMIApplicationException
	 */
	@Override
	public Company editProductUsesUnitDetail(int productUsesUnitId)
			throws OMIApplicationException {
		company = new Company();
		settingDaoInf = new SettingDaoImpl();
		try {
			company = settingDaoInf
					.showProductUsesUnitDetails(productUsesUnitId);
		} catch (Exception exception) {
			logger.info("Error:while getting a Product Uses Unit Information!");
		}
		return company;
	}

	/**
	 * <p>
	 * <code>updateProductUsesUnit()</code> This method is Used for Update
	 * Product Uses Unit into database.
	 * <p>
	 * 
	 * @param productUsesUnitId
	 * @return success,failure
	 * @throws OMIApplicationException
	 */
	@Override
	public String updateProductUsesUnit(CompanyVO companyVO,
			int productUsesUnitId) throws OMIApplicationException {
		settingDaoInf = new SettingDaoImpl();
		int target = settingDaoInf.updateProductUsesUnitDetail(companyVO,
				productUsesUnitId);

		if (target == 1) {
			logger.info("Successfully Update Product Uses Unit Information!");
			return OMIConstants.TARGET_SUCCESS;
		} else {

			logger.info("Error:while  Updating Product Uses Unit Information!");
			return OMIConstants.TARGET_FAILURE;
		}
	}

	/**
	 * <p>
	 * <code>editFAQCategoryDetail()</code> This method is Used for getting FAQ
	 * Category from database.
	 * <p>
	 * 
	 * @param faqcategoryId
	 * @return company
	 * @throws OMIApplicationException
	 */
	@Override
	public Company editFAQCategoryDetail(int faqcategoryId)
			throws OMIApplicationException {
		company = new Company();
		settingDaoInf = new SettingDaoImpl();
		try {
			company = settingDaoInf.showFAQCategoryDetails(faqcategoryId);
		} catch (Exception exception) {
			logger.info("Error:while getting a FAQ Category Information!");
		}
		return company;
	}

	/**
	 * <p>
	 * <code>updateFAQCategory()</code> This method is Used for Update FAQ
	 * Category into database.
	 * <p>
	 * 
	 * @param faqcategoryId
	 * @return success,failure
	 * @throws OMIApplicationException
	 */
	@Override
	public String updateFAQCategory(CompanyVO companyVO, int faqcategoryId)
			throws OMIApplicationException {
		settingDaoInf = new SettingDaoImpl();
		int target = settingDaoInf.updateFAQCategoryDetail(companyVO,
				faqcategoryId);

		if (target == 1) {
			logger.info("Successfully Update FAQ Category Information!");
			return OMIConstants.TARGET_SUCCESS;
		} else {

			logger.info("Error:while  Updating FAQ Category Information!");
			return OMIConstants.TARGET_FAILURE;
		}
	}

	/**
	 * <p>
	 * <code>editChannelDetail()</code> This method is Used for getting Channel
	 * from database.
	 * <p>
	 * 
	 * @param channelId
	 * @return company
	 * @throws OMIApplicationException
	 */
	@Override
	public Company editChannelDetail(int channelId)
			throws OMIApplicationException {
		company = new Company();
		settingDaoInf = new SettingDaoImpl();
		try {
			company = settingDaoInf.showChannelDetails(channelId);
		} catch (Exception exception) {
			logger.info("Error:while getting a Channel Information!");
		}
		return company;
	}

	/**
	 * <p>
	 * <code>updateChannel()</code> This method is Used for Update Channel into
	 * database.
	 * <p>
	 * 
	 * @param channelId
	 * @return success,failure
	 * @throws OMIApplicationException
	 */
	@Override
	public String updateChannel(CompanyVO companyVO, int channelId)
			throws OMIApplicationException {
		settingDaoInf = new SettingDaoImpl();
		int target = settingDaoInf.updateChannelDetail(companyVO, channelId);

		if (target == 1) {
			logger.info("Successfully Update Channel Information!");
			return OMIConstants.TARGET_SUCCESS;
		} else {

			logger.info("Error:while  Updating Channel Information!");
			return OMIConstants.TARGET_FAILURE;
		}
	}

	/**
	 * <p>
	 * <code>editTaskAreaDetail()</code> This method is Used for getting Task
	 * Area from database.
	 * <p>
	 * 
	 * @param taskareaId
	 * @return company
	 * @throws OMIApplicationException
	 */
	@Override
	public Company editTaskAreaDetail(int taskareaId)
			throws OMIApplicationException {
		company = new Company();
		settingDaoInf = new SettingDaoImpl();
		try {
			company = settingDaoInf.showTaskAreaDetails(taskareaId);
		} catch (Exception exception) {
			logger.info("Error:while getting a Task Area Information!");
		}
		return company;
	}

	/**
	 * <p>
	 * <code>updateTaskArea()</code> This method is Used for Update Task Area
	 * into database.
	 * <p>
	 * 
	 * @param taskareaId
	 * @return success,failure
	 * @throws OMIApplicationException
	 */
	@Override
	public String updateTaskArea(CompanyVO companyVO, int taskareaId)
			throws OMIApplicationException {
		settingDaoInf = new SettingDaoImpl();
		int target = settingDaoInf.updateTaskAreaDetail(companyVO, taskareaId);

		if (target == 1) {
			logger.info("Successfully Update Task Area Information!");
			return OMIConstants.TARGET_SUCCESS;
		} else {

			logger.info("Error:while  Updating Task Area Information!");
			return OMIConstants.TARGET_FAILURE;
		}
	}

	/**
	 * <p>
	 * <code>addcountryDetail()</code> This method is design to inserting
	 * Country details into a tables TAB_COUNTRY.
	 * <p>
	 * 
	 * @param CompanyVO
	 * 
	 * @return SUCCESS,FAILURE.
	 * @throws OMIApplicationException
	 */
	@Override
	public String addCountryDetail(CompanyVO companyVO)
			throws OMIApplicationException {

		settingDaoInf = new SettingDaoImpl();
		int target = settingDaoInf.addCountryDetails(companyVO);
		if (target == 1) {
			logger.info("Successfully inserted Country  Information into database!");
			return OMIConstants.TARGET_SUCCESS;
		} else {

			logger.info("Error:while inserted Country Information into database!");
			return OMIConstants.TARGET_FAILURE;
		}

	}

	/**
	 * <p>
	 * <code>showCountryList()</code> This method is design to show Country
	 * Details from databse.
	 * <p>
	 * 
	 * @param
	 * @return Companyvo
	 * @throws OMIApplicationException
	 */
	@Override
	public List<CompanyVO> showCountryList() throws OMIApplicationException {
		settingDaoInf = new SettingDaoImpl();
		return settingDaoInf.showCountryList();
	}

	/**
	 * <p>
	 * <code>editCountry()</code>this method is used to fetching a country
	 * details for updating into table TAB_COUNTRY
	 * <p>
	 * 
	 * @param countryId
	 * @return Company
	 * @throws OMIApplicationException
	 */
	@Override
	public Company editCountry(int countryId) throws OMIApplicationException {
		company = new Company();
		settingDaoInf = new SettingDaoImpl();
		try {
			company = settingDaoInf.showcountryDetails(countryId);
		} catch (Exception exception) {
			logger.info("Error:while getting a country Information!");
		}
		return company;
	}

	/**
	 * <p>
	 * <code>updateCountry()</code>this is method is used to update a country
	 * information from table TAB_COUNTRY.
	 * </p>
	 * @param companyVO,countryId
	 * @return SUCCES,FAILURE
	 * @throws OMIApplicationException
	 * 
	 */
	@Override
	public String updateCountry(CompanyVO companyVO, int countryId)
			throws OMIApplicationException {
		settingDaoInf = new SettingDaoImpl();
		int target = settingDaoInf.updateCountryDetails(companyVO, countryId);

		if (target == 1) {
			logger.info("Successfully Update Country Information!");
			return OMIConstants.TARGET_SUCCESS;
		} else {

			logger.info("Error:while  Updating Country  Information!");
			return OMIConstants.TARGET_FAILURE;
		}
	}

	@Override
	public String insertProductType(CompanyVO companyVO)
			throws OMIApplicationException {
		settingDaoInf = new SettingDaoImpl();
		int target = settingDaoInf.insertProductType(companyVO);
		if (target == 1) {
			logger.info("Successfully inserted Product Type Information!");
			return OMIConstants.TARGET_SUCCESS;
		} else {

			logger.info("Error:while inserted Product Type Information!");
			return OMIConstants.TARGET_FAILURE;
		}
	}

	@Override
	public List<CompanyVO> showProductTypeGrid() throws OMIApplicationException {
		settingDaoInf = new SettingDaoImpl();

		return settingDaoInf.showProductTypeGrid();
	}

	@Override
	public Company editProductType(int productTypeId)
			throws OMIApplicationException {
		company = new Company();
		settingDaoInf = new SettingDaoImpl();
		try {
			company = settingDaoInf
					.showProductTypeDetailsForUpdate(productTypeId);
		} catch (Exception exception) {
			logger.info("Error:while getting a product Type  Information!");
		}
		return company;
	}

	@Override
	public String updateProductType(CompanyVO companyVO, int productTypeId)
			throws OMIApplicationException {
		settingDaoInf = new SettingDaoImpl();
		int target = settingDaoInf.updateProductType(companyVO,
				productTypeId);

		if (target == 1) {
			logger.info("Successfully Update product Type Information!");
			return OMIConstants.TARGET_SUCCESS;
		} else {

			logger.info("Error:while  Updating product Type Information!");
			return OMIConstants.TARGET_FAILURE;
		}
	}

}
