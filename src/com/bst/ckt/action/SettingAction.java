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
 * Class Name     SettingAction.java     
 *                                                            
 * Creation Date  NOV 13, 2015 
 * 
 * Abstract       This is Action class which is design to call particular 
 * 				  action with respective page and perform some operations on particular action
 *  
 * Amendment History (in chronological sequence):SEP 18, 2015 
 * 
 * Author Abhilash
 **********************************************************************
 */
package com.bst.ckt.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.bst.ckt.common.LoginUtil;
import com.bst.ckt.common.OMIConstants;
import com.bst.ckt.exception.OMIApplicationException;
import com.bst.ckt.framework.user.CustomerSessionUser;
import com.bst.ckt.helper.GlAccountType;
import com.bst.ckt.helper.ListHelper;
import com.bst.ckt.helper.VOMapperHelper;
import com.bst.ckt.service.SettingServiceImpl;
import com.bst.ckt.service.SettingServiceInf;
import com.bst.ckt.vo.CompanyVO;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @author Abhilash
 * 
 */
public class SettingAction extends ActionSupport implements
		ModelDriven<CompanyVO>, SessionAware, ServletRequestAware,
		ServletResponseAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5306221859045264222L;
	HttpServletRequest request = (HttpServletRequest) ActionContext
			.getContext().get(ServletActionContext.HTTP_REQUEST);

	/**
	 * Creating Logger object, logger object mapped with AccountAction class for
	 * writing Loggers.
	 */
	private static final Logger logger = Logger.getLogger(SettingAction.class);

	private Map<Integer, String> companyTypeList;
	private Map<Integer, String> companyCategoryList;
	private Map<Integer, String> companySectorList;
	private Map<Integer, String> countryList;
	private Map<Integer, String> timeZoneList;
	private Map<Integer, String> languageList;
	private Map<Integer, String> currencyList;
	private Map<Integer, String> glAccounttypeList;
	private Map<Integer, String> categoryList;
	// private Map<Integer, String> isdList;

	private List<CompanyVO> showcompanyTypeList;
	private List<CompanyVO> financeTaxList;
	private List<CompanyVO> productCategoryList;
	private List<CompanyVO> showCompanyCategoryList;
	private List<CompanyVO> showCompanyLocalList;
	private List<CompanyVO> showCountryList;
	private List<CompanyVO> showCompanySectorList;
	private List<CompanyVO> showFinanaceGLAccountList;
	private List<CompanyVO> showMarketingLeadSourceList;
	private List<CompanyVO> showMarketingAccountTypeList;
	private List<CompanyVO> showMarketingSlaNameList;
	private List<CompanyVO> showMarketingCampaignTypeList;
	private List<CompanyVO> showMarketingResponseList;
	private List<CompanyVO> showMarketingVendorcategoryList;
	private List<CompanyVO> showMarketingtravelModeList;
	private List<CompanyVO> showProductUsesUnitList;
	private List<CompanyVO> showSupportfaqCategoryList;
	private List<CompanyVO> showSupportChannelList;
	private List<CompanyVO> showSupportCaseImpactList;
	private List<CompanyVO> showSupportTaskAreaList;
	private List<CompanyVO> productTypeList;
	CompanyVO companyVO = new CompanyVO();
	SettingServiceInf settingServiceInf = null;

	ListHelper listHelper = null;
	Map<String, Object> session = null;

	public SettingAction() throws Exception {

		listHelper = new ListHelper();
		companyTypeList = listHelper.companyTypeList();
		companyCategoryList = listHelper.companyCategoryList();
		companySectorList = listHelper.companySectorList();
		setCountryList(listHelper.countryList());
		timeZoneList = listHelper.timeZoneList();
		languageList = listHelper.languageList();
		currencyList = listHelper.currencyList();
		categoryList = listHelper.getProductItemName();
		glAccounttypeList = GlAccountType.getGlAccountTypeList();
		// isdList=listHelper.isdList();

		CustomerSessionUser customerSessionUser = LoginUtil
				.getCurrentCustomerUser();
		LoginUtil.setProcessUserId(customerSessionUser.getCompanyId());
		int companyId = customerSessionUser.getCompanyId();
		settingServiceInf = new SettingServiceImpl();
		this.companyVO = VOMapperHelper.getCompanyVOFromCompany(companyVO,
				settingServiceInf.editSettingInfo(companyId));
		// for showing Company Type Grid
		this.showcompanyTypeList = settingServiceInf.showCompanyTypeGrid();
		this.showCompanyCategoryList = settingServiceInf
				.showCompanyCategoeyGrid();
		this.showCompanyLocalList = settingServiceInf.showCompanyLocalList();
		this.showCompanySectorList = settingServiceInf.showCompanySectorList();
		this.showCountryList=settingServiceInf.showCountryList();
		this.financeTaxList = settingServiceInf.showFinanceTaxGrid();
		this.productCategoryList = settingServiceInf.showProductCategoryGrid();
		this.showFinanaceGLAccountList = settingServiceInf
				.showFinanaceGLAccountList();
		this.showMarketingLeadSourceList = settingServiceInf
				.showMarketingLeadSourceList();
		this.showMarketingAccountTypeList = settingServiceInf
				.showMarketingAccountTypeList();
		this.showMarketingSlaNameList = settingServiceInf
				.showMarketingSlaNameList();
		this.showMarketingCampaignTypeList = settingServiceInf
				.showMarketingCampaignTypeList();
		this.showMarketingResponseList = settingServiceInf
				.showMarketingResponseList();
		this.showMarketingVendorcategoryList = settingServiceInf
				.showMarketingVendorcategoryList();
		this.showMarketingtravelModeList = settingServiceInf
				.showMarketingtravelModeList();
		this.showSupportfaqCategoryList = settingServiceInf
				.showSupportfaqCategoryList();
		this.showSupportChannelList = settingServiceInf
				.showSupportChannelList();
		this.showSupportCaseImpactList = settingServiceInf
				.showSupportCaseImpactList();
		this.showSupportTaskAreaList = settingServiceInf
				.showSupportTaskAreaList();
		this.showProductUsesUnitList = settingServiceInf
				.showProductUsesUnitList();
	}

	/**
	 * <p>
	 * <code>updateCompany()</code>method is design to update company setting
	 * details into database
	 * </p>
	 * 
	 * 
	 * @return SUCCESS
	 * @throws Exception
	 */
	public String updateCompany() throws OMIApplicationException {

		settingServiceInf = new SettingServiceImpl();

		CustomerSessionUser customerSessionUser = LoginUtil
				.getCurrentCustomerUser();
		LoginUtil.setProcessUserId(customerSessionUser.getCompanyId());
		int companyId = customerSessionUser.getCompanyId();

		String message = settingServiceInf.updateCompanyDetails(companyVO,
				companyId);

		if (OMIConstants.TARGET_SUCCESS.equalsIgnoreCase(message)) {
			logger.info("Successfully Updated Company Details!");
			addActionMessage("Successfully Updated Company Details!");
			return SUCCESS;

		} else if (OMIConstants.TARGET_FAILURE.equalsIgnoreCase(message)) {

			logger.info("Error:while  Updating Company Details!");
			addActionError("Error:while  Updated Company Details!");
			return INPUT;
		}
		return NONE;
	}

	/**
	 * <p>
	 * <code>insertCompanyType()</code>method is Used for Inserting a Company
	 * type into database
	 * 
	 * </p>
	 * 
	 * 
	 * @return SUCCESS
	 * @throws Exception
	 */

	public String insertCompanyType() throws OMIApplicationException {

		settingServiceInf = new SettingServiceImpl();
		String message = settingServiceInf.addCompanyType(companyVO);
		/*
		 * CustomerSessionUser customerSessionUser = LoginUtil
		 * .getCurrentCustomerUser();
		 * companyVO.setCreatedBy(customerSessionUser.getCustomerId());
		 * LoginUtil.setProcessUserId(customerSessionUser.getCompanyId());
		 */

		if (OMIConstants.TARGET_SUCCESS.equalsIgnoreCase(message)) {

			this.showcompanyTypeList = settingServiceInf.showCompanyTypeGrid();

			logger.info("Successfully Inserted Company Type Details!");
			addActionMessage("Successfully Inserted Company Type Details!");
			return SUCCESS;

		} else if (OMIConstants.TARGET_FAILURE.equalsIgnoreCase(message)) {

			logger.info("Error:while  Inserted Company Type Details!");
			addActionError("Error:while  Inserted Company Type Details!");
			return INPUT;
		}
		return NONE;

	}

	/**
	 * <p>
	 * <code>editCompanyType()</code>this method is design to get Company Type
	 * details for the update process.
	 * </p>
	 * 
	 * @return SUCCESS
	 * @throws Exception
	 */

	public String editCompanyType() throws Exception {
		settingServiceInf = new SettingServiceImpl();
		int companyTypeId = Integer.parseInt(request.getParameter("command"));
		/*
		 * if (companyTypeId == 0) companyTypeId = LoginUtil.getProcessUserId();
		 */
		//System.out.println("companyTypeId @@@@@@@@@@@ " + companyTypeId);
		this.companyVO = VOMapperHelper.getCompanyVOFromCompany(companyVO,
				settingServiceInf.editCompanyTypeDetails(companyTypeId));
		LoginUtil.setProcessUserId(companyTypeId);
		//System.out.println("companyTypeId @@@@@@@@@@@ ######" + companyTypeId);
		session.put("CompanyType", companyTypeId);
		return SUCCESS;
	}

	/**
	 * <p>
	 * <code>updateCompanyType()</code> method is use to update Company Type
	 * information into database
	 * </p>
	 * 
	 * @return SUCCESS
	 * @throws Exception
	 */
	public String updateCompanyType() throws Exception {

		settingServiceInf = new SettingServiceImpl();
		int companyTypeId = (Integer) session.get("CompanyType");

		System.out.println("id is" + companyTypeId);
		String message = settingServiceInf.updateCompanyType(companyVO,
				companyTypeId);

		if (OMIConstants.TARGET_SUCCESS.equalsIgnoreCase(message)) {
			this.showcompanyTypeList = settingServiceInf.showCompanyTypeGrid();
			logger.info("Successfully Updated Company Type Information!");
			addActionMessage("Successfully Updated Company Type Information!");
			return SUCCESS;

		} else if (OMIConstants.TARGET_FAILURE.equalsIgnoreCase(message)) {

			logger.info("Error:while  Updating Company Type Information!");
			addActionError("Error:while  Updating Company Type Information!");
			return INPUT;
		}

		return NONE;
	}

	/**
	 * <p>
	 * <code>insertCompanyCategory()</code>method is Used for Inserting a
	 * Company Category into database
	 * 
	 * </p>
	 * 
	 * 
	 * @return SUCCESS
	 * @throws Exception
	 */

	public String insertCompanyCategory() throws OMIApplicationException {

		settingServiceInf = new SettingServiceImpl();
		String message = settingServiceInf.addCompanyCategory(companyVO);
		/*
		 * CustomerSessionUser customerSessionUser = LoginUtil
		 * .getCurrentCustomerUser();
		 * companyVO.setCreatedBy(customerSessionUser.getCustomerId());
		 * LoginUtil.setProcessUserId(customerSessionUser.getCompanyId());
		 */

		if (OMIConstants.TARGET_SUCCESS.equalsIgnoreCase(message)) {
			this.showCompanyCategoryList = settingServiceInf
					.showCompanyCategoeyGrid();
			logger.info("Successfully Inserted Company Category Details!");
			addActionMessage("Successfully Inserted Company Category Details!");
			return SUCCESS;

		} else if (OMIConstants.TARGET_FAILURE.equalsIgnoreCase(message)) {

			logger.info("Error:while  Inserted Company Category Details!");
			addActionError("Error:while  Inserted Company Category Details!");
			return INPUT;
		}
		return NONE;

	}

	/**
	 * <p>
	 * <code>editCompanyCategory()</code>this method is design to get Company
	 * Category details for the update process.
	 * </p>
	 * 
	 * @return SUCCESS
	 * @throws Exception
	 */

	public String editCompanyCategory() throws Exception {
		settingServiceInf = new SettingServiceImpl();
		int companyCategoryID = Integer.parseInt(request
				.getParameter("command"));
		this.companyVO = VOMapperHelper
				.getCompanyVOFromCompany(companyVO, settingServiceInf
						.editCompanyCategoryDetails(companyCategoryID));
		LoginUtil.setProcessUserId(companyCategoryID);
		session.put("companyCategoryID", companyCategoryID);
		return SUCCESS;
	}

	/**
	 * <p>
	 * <code>updateCompanyCategory()</code> method is use to update Company
	 * Category information into database
	 * </p>
	 * 
	 * @return SUCCESS
	 * @throws Exception
	 */
	public String updateCompanyCategory() throws Exception {

		settingServiceInf = new SettingServiceImpl();
		int companyCategoryID = (Integer) session.get("companyCategoryID");

		// System.out.println("id is" + companyTypeId);
		String message = settingServiceInf.updateCompanyCategory(companyVO,
				companyCategoryID);

		if (OMIConstants.TARGET_SUCCESS.equalsIgnoreCase(message)) {
			this.showCompanyCategoryList = settingServiceInf
					.showCompanyCategoeyGrid();
			logger.info("Successfully Updated Company Category Information!");
			addActionMessage("Successfully Updated Company Category Information!");
			return SUCCESS;

		} else if (OMIConstants.TARGET_FAILURE.equalsIgnoreCase(message)) {

			logger.info("Error:while  Updating Company Category Information!");
			addActionError("Error:while  Updating Company Category Information!");
			return INPUT;
		}

		return NONE;
	}

	/**
	 * <p>
	 * <code>insertSupportCaseImpact()</code>method is Used for Inserting a Case
	 * Impact into database
	 * 
	 * </p>
	 * 
	 * 
	 * @return SUCCESS
	 * @throws Exception
	 */

	public String insertSupportCaseImpact() throws OMIApplicationException {

		settingServiceInf = new SettingServiceImpl();
		String message = settingServiceInf.addSupportCaseImpact(companyVO);
		/*
		 * CustomerSessionUser customerSessionUser = LoginUtil
		 * .getCurrentCustomerUser();
		 * companyVO.setCreatedBy(customerSessionUser.getCustomerId());
		 * LoginUtil.setProcessUserId(customerSessionUser.getCompanyId());
		 */

		if (OMIConstants.TARGET_SUCCESS.equalsIgnoreCase(message)) {
			this.showSupportCaseImpactList = settingServiceInf
					.showSupportCaseImpactList();
			logger.info("Successfully Inserted Case Impact Details!");
			addActionMessage("Successfully Inserted Case Impact Details!");
			return SUCCESS;

		} else if (OMIConstants.TARGET_FAILURE.equalsIgnoreCase(message)) {

			logger.info("Error:while  Inserted Case Impact Details!");
			addActionError("Error:while  Inserted Case Impact Details!");
			return INPUT;
		}
		return NONE;

	}

	/**
	 * <p>
	 * <code>insertCompanySector()</code>method is Used for Inserting a Company
	 * Sector into database
	 * 
	 * </p>
	 * 
	 * 
	 * @return SUCCESS
	 * @throws Exception
	 */

	public String insertCompanySector() throws OMIApplicationException {
		settingServiceInf = new SettingServiceImpl();
		String message = settingServiceInf.addCompanySector(companyVO);
		/*
		 * CustomerSessionUser customerSessionUser = LoginUtil
		 * .getCurrentCustomerUser();
		 * companyVO.setCreatedBy(customerSessionUser.getCustomerId());
		 * LoginUtil.setProcessUserId(customerSessionUser.getCompanyId());
		 */

		if (OMIConstants.TARGET_SUCCESS.equalsIgnoreCase(message)) {
			this.showCompanySectorList = settingServiceInf
					.showCompanySectorList();
			logger.info("Successfully Inserted Company Sector Details!");
			addActionMessage("Successfully Inserted Company Sector Details!");
			return SUCCESS;

		} else if (OMIConstants.TARGET_FAILURE.equalsIgnoreCase(message)) {

			logger.info("Error:while  Inserted Company Sector Details!");
			addActionError("Error:while  Inserted Company Sector Details!");
			return INPUT;
		}
		return NONE;

	}

	/**
	 * <p>
	 * <code>editCompanySector()</code>this method is design to get Company
	 * Sectors details for the update process.
	 * </p>
	 * 
	 * @return SUCCESS
	 * @throws Exception
	 */

	public String editCompanySector() throws Exception {
		settingServiceInf = new SettingServiceImpl();
		int companysectorid = Integer.parseInt(request.getParameter("command"));
		this.companyVO = VOMapperHelper.getCompanyVOFromCompany(companyVO,
				settingServiceInf.editCompanySectorDetails(companysectorid));
		LoginUtil.setProcessUserId(companysectorid);
		session.put("companysectorid", companysectorid);
		return SUCCESS;
	}

	/**
	 * <p>
	 * <code>updateCompanySector()</code> method is use to update Company Sector
	 * information into database
	 * </p>
	 * 
	 * @return SUCCESS
	 * @throws Exception
	 */
	public String updateCompanySector() throws Exception {

		settingServiceInf = new SettingServiceImpl();
		int companysectorid = (Integer) session.get("companysectorid");

		// System.out.println("id is" + companyTypeId);
		String message = settingServiceInf.updateCompanySector(companyVO,
				companysectorid);

		if (OMIConstants.TARGET_SUCCESS.equalsIgnoreCase(message)) {
			this.showCompanySectorList = settingServiceInf
					.showCompanySectorList();
			logger.info("Successfully Updated Company Sector Information!");
			addActionMessage("Successfully Updated Company Sector Information!");
			return SUCCESS;

		} else if (OMIConstants.TARGET_FAILURE.equalsIgnoreCase(message)) {

			logger.info("Error:while  Updating Company Sector Information!");
			addActionError("Error:while  Updating Company Sector Information!");
			return INPUT;
		}

		return NONE;
	}
	/**
	 * <p>
	 * <code>insertCountryDetails()</code>method is Used for Inserting a Country Details
	 *  into database
	 * 
	 * </p>
	 * 
	 * 
	 * @return SUCCESS,
	 * @throws Exception
	 */

	public String insertCountryDetails() throws OMIApplicationException {
		settingServiceInf = new SettingServiceImpl();
		String message = settingServiceInf.addCountryDetail(companyVO);
		if (OMIConstants.TARGET_SUCCESS.equalsIgnoreCase(message)) {
			this.showCountryList=settingServiceInf.showCountryList();
			logger.info("Successfully Inserted Country  Details!");
			addActionMessage("Successfully Inserted Country Details!");
			return SUCCESS;

		} else if (OMIConstants.TARGET_FAILURE.equalsIgnoreCase(message)) {

			logger.info("Error:while  Inserted Country Details!");
			addActionError("Error:while  Inserted Country Details!");
			return INPUT;
		}
		return NONE;

	}
	/**
	 * <p>
	 * <code>editCountry()</code>this method is design to get Country
	 *  details for the update process.
	 * </p>
	 * 
	 * @return SUCCESS
	 * @throws Exception
	 */

	public String editCountry() throws Exception {
		settingServiceInf = new SettingServiceImpl();
		int countryId = Integer.parseInt(request.getParameter("command"));
		this.companyVO = VOMapperHelper.getCompanyVOFromCompany(companyVO,
				settingServiceInf.editCountry(countryId));
		LoginUtil.setProcessUserId(countryId);
		session.put("countryId", countryId);
		return SUCCESS;
	}

	/**
	 * <p>
	 * <code>updateCountry()</code> method is use to update Country
	 * information into tables TAB_COUNTRY.
	 * </p>
	 * 
	 * @return SUCCESS,INPUT,NONE
	 * @throws Exception
	 */
	public String updateCountry() throws Exception {

		settingServiceInf = new SettingServiceImpl();
		int countryId = (Integer) session.get("countryId");

		// System.out.println("id is" + companyTypeId);
		String message = settingServiceInf.updateCountry(companyVO,
				countryId);

		if (OMIConstants.TARGET_SUCCESS.equalsIgnoreCase(message)) {
			this.showCountryList = settingServiceInf
					.showCountryList();
			logger.info("Successfully Updated Country Details Information!");
			addActionMessage("Successfully Updated Country Details Information!");
			return SUCCESS;

		} else if (OMIConstants.TARGET_FAILURE.equalsIgnoreCase(message)) {

			logger.info("Error:while  Updating Country Details Information!");
			addActionError("Error:while  Updating Country Details Information!");
			return INPUT;
		}

		return NONE;
	}


	/**
	 * <p>
	 * <code>insertCompanyLocal()</code>method is Used for Inserting a Company
	 * Local into database
	 * 
	 * </p>
	 * 
	 * 
	 * @return SUCCESS
	 * @throws Exception
	 */

	public String updateCompanyLocal() throws Exception {
		settingServiceInf = new SettingServiceImpl();

		CustomerSessionUser customerSessionUser = LoginUtil
				.getCurrentCustomerUser();
		companyVO.setCreatedBy(customerSessionUser.getCustomerId());
		LoginUtil.setProcessUserId(customerSessionUser.getCompanyId());

		int customerId = customerSessionUser.getCustomerId();
		System.out.println("***********customer Id is**************"+customerId);
		String message = settingServiceInf.updateCompanyLocal(companyVO,
				customerId);

		if (OMIConstants.TARGET_SUCCESS.equalsIgnoreCase(message)) {
			this.showCompanyLocalList = settingServiceInf
					.showCompanyLocalList();
			logger.info("Successfully Updated Company Local Details!");
			addActionMessage("Successfully Updated Company Local Details!");
			return SUCCESS;

		} else if (OMIConstants.TARGET_FAILURE.equalsIgnoreCase(message)) {

			logger.info("Error:while  Updated Company Local Details!");
			addActionError("Error:while  Updated Company Local Details!");
			return INPUT;
		}
		return NONE;

	}

	/**
	 * <p>
	 * <code>insertFinanceTax()</code>method is Used for Inserting a taxes into
	 * database
	 * 
	 * </p>
	 * 
	 * 
	 * @return SUCCESS
	 * @throws Exception
	 */

	public String insertFinanceTax() throws OMIApplicationException {
		settingServiceInf = new SettingServiceImpl();
		String message = settingServiceInf.addFinanceTax(companyVO);
		CustomerSessionUser customerSessionUser = LoginUtil
				.getCurrentCustomerUser();
		companyVO.setCreatedBy(customerSessionUser.getCustomerId());
		LoginUtil.setProcessUserId(customerSessionUser.getCompanyId());

		if (OMIConstants.TARGET_SUCCESS.equalsIgnoreCase(message)) {
			this.financeTaxList = settingServiceInf.showFinanceTaxGrid();
			logger.info("Successfully Inserted Taxes Details!");
			addActionMessage("Successfully Inserted  Taxes Details!");
			return SUCCESS;

		} else if (OMIConstants.TARGET_FAILURE.equalsIgnoreCase(message)) {

			logger.info("Error:while  Inserted  Taxes Details!");
			addActionError("Error:while  Inserted  Taxes Details!");
			return INPUT;
		}
		return NONE;

	}

	/**
	 * <p>
	 * <code>editTax()</code>this method is design to get Tax details for the
	 * update process.
	 * </p>
	 * 
	 * @return SUCCESS
	 * @throws Exception
	 */

	public String editTax() throws Exception {
		settingServiceInf = new SettingServiceImpl();
		int financeId = Integer.parseInt(request.getParameter("command"));
		/*
		 * if (financeId == 0) financeId = LoginUtil.getProcessUserId();
		 * LoginUtil.setProcessUserId(financeId);
		 */
		this.companyVO = VOMapperHelper.getCompanyVOFromCompany(companyVO,
				settingServiceInf.editTax(financeId));
		session.put("financeId", financeId);

		return SUCCESS;
	}

	/**
	 * <p>
	 * <code>updateTax()</code> method is use to update Tax information into
	 * database
	 * </p>
	 * 
	 * @return SUCCESS
	 * @throws Exception
	 */
	public String updateTax() throws Exception {

		settingServiceInf = new SettingServiceImpl();
		int financeId = (Integer) session.get("financeId");
		// System.out.println("id is" + leadsourceID);
		String message = settingServiceInf.updateTax(companyVO, financeId);

		if (OMIConstants.TARGET_SUCCESS.equalsIgnoreCase(message)) {
			this.financeTaxList = settingServiceInf.showFinanceTaxGrid();
			logger.info("Successfully Updated Tax Information!");
			addActionMessage("Successfully Updated Tax Information!");
			return SUCCESS;

		} else if (OMIConstants.TARGET_FAILURE.equalsIgnoreCase(message)) {

			logger.info("Error:while  Updating Tax Information!");
			addActionError("Error:while  Updating Tax Information!");
			return INPUT;
		}

		return NONE;
	}

	/**
	 * <p>
	 * <code>insertFinanceGLAccount()</code>method is Used for Inserting a GL
	 * Account into database
	 * 
	 * </p>
	 * 
	 * 
	 * @return SUCCESS
	 * @throws Exception
	 */

	public String insertFinanceGLAccount() throws OMIApplicationException {
		settingServiceInf = new SettingServiceImpl();
		String message = settingServiceInf.addFinanceGLAccount(companyVO);
		/*
		 * CustomerSessionUser customerSessionUser = LoginUtil
		 * .getCurrentCustomerUser();
		 * companyVO.setCreatedBy(customerSessionUser.getCustomerId());
		 * LoginUtil.setProcessUserId(customerSessionUser.getCompanyId());
		 */

		if (OMIConstants.TARGET_SUCCESS.equalsIgnoreCase(message)) {
			this.showFinanaceGLAccountList = settingServiceInf
					.showFinanaceGLAccountList();
			logger.info("Successfully Inserted GLAccount Details!");
			addActionMessage("Successfully Inserted  GLAccount Details!");
			return SUCCESS;

		} else if (OMIConstants.TARGET_FAILURE.equalsIgnoreCase(message)) {

			logger.info("Error:while  Inserted  GLAccount Details!");
			addActionError("Error:while  Inserted  GLAccount Details!");
			return INPUT;
		}
		return NONE;

	}

	/**
	 * <p>
	 * <code>editGLAccount()</code>this method is design to get GL Account
	 * details for the update process.
	 * </p>
	 * 
	 * @return SUCCESS
	 * @throws Exception
	 */

	public String editGLAccount() throws Exception {
		settingServiceInf = new SettingServiceImpl();
		int financeId = Integer.parseInt(request.getParameter("command"));
		/*
		 * if (financeId == 0) financeId = LoginUtil.getProcessUserId();
		 * LoginUtil.setProcessUserId(financeId);
		 */this.companyVO = VOMapperHelper.getCompanyVOFromCompany(companyVO,
				settingServiceInf.editGLAccount(financeId));
		session.put("financeId", financeId);
		return SUCCESS;
	}

	/**
	 * <p>
	 * <code>updateGLAccount()</code> method is use to update GL Account
	 * information into database
	 * </p>
	 * 
	 * @return SUCCESS
	 * @throws Exception
	 */
	public String updateGLAccount() throws Exception {

		settingServiceInf = new SettingServiceImpl();
		/*
		 * int financeId = LoginUtil.getProcessUserId();
		 * LoginUtil.setProcessUserId(financeId);
		 */
		int financeId = (Integer) session.get("financeId");
		System.out.println("id is" + financeId);
		String message = settingServiceInf
				.updateGLAccount(companyVO, financeId);

		if (OMIConstants.TARGET_SUCCESS.equalsIgnoreCase(message)) {
			this.showFinanaceGLAccountList = settingServiceInf
					.showFinanaceGLAccountList();
			logger.info("Successfully Updated GL Account Information!");
			addActionMessage("Successfully Updated GL Account Information!");
			return SUCCESS;

		} else if (OMIConstants.TARGET_FAILURE.equalsIgnoreCase(message)) {

			logger.info("Error:while  Updating GL Account Information!");
			addActionError("Error:while  Updating GL Account Information!");
			return INPUT;
		}

		return NONE;
	}

	/**
	 * <p>
	 * <code>insertMarketingLeadSource()</code>method is Used for Inserting a
	 * Lead Source into database
	 * 
	 * </p>
	 * 
	 * 
	 * @return SUCCESS
	 * @throws Exception
	 */

	public String insertMarketingLeadSource() throws OMIApplicationException {
		settingServiceInf = new SettingServiceImpl();
		String message = settingServiceInf.addMarketingLeadSource(companyVO);
		CustomerSessionUser customerSessionUser = LoginUtil
				.getCurrentCustomerUser();
		companyVO.setCreatedBy(customerSessionUser.getCustomerId());
		LoginUtil.setProcessUserId(customerSessionUser.getCompanyId());

		if (OMIConstants.TARGET_SUCCESS.equalsIgnoreCase(message)) {
			this.showMarketingLeadSourceList = settingServiceInf
					.showMarketingLeadSourceList();
			logger.info("Successfully Inserted Lead source Details!");
			addActionMessage("Successfully Inserted  Lead source Details!");
			return SUCCESS;

		} else if (OMIConstants.TARGET_FAILURE.equalsIgnoreCase(message)) {

			logger.info("Error:while  Inserted  Lead source Details!");
			addActionError("Error:while  Inserted  Lead source Details!");
			return INPUT;
		}
		return NONE;

	}

	/**
	 * <p>
	 * <code>editLeadSource()</code>this method is design to get Lead Source
	 * details for the update process.
	 * </p>
	 * 
	 * @return SUCCESS
	 * @throws Exception
	 */

	public String editLeadSource() throws Exception {
		settingServiceInf = new SettingServiceImpl();
		int leadsourceID = Integer.parseInt(request.getParameter("command"));
		/*
		 * if (financeId == 0) financeId = LoginUtil.getProcessUserId();
		 * LoginUtil.setProcessUserId(financeId);
		 */
		this.companyVO = VOMapperHelper.getCompanyVOFromCompany(companyVO,
				settingServiceInf.editLeadSource(leadsourceID));
		session.put("leadsourceID", leadsourceID);

		return SUCCESS;
	}

	/**
	 * <p>
	 * <code>updateLeadSource()</code> method is use to update Lead Source
	 * information into database
	 * </p>
	 * 
	 * @return SUCCESS
	 * @throws Exception
	 */
	public String updateLeadSource() throws Exception {

		settingServiceInf = new SettingServiceImpl();
		/*
		 * int financeId = LoginUtil.getProcessUserId();
		 * LoginUtil.setProcessUserId(financeId);
		 */
		int leadsourceID = (Integer) session.get("leadsourceID");
		System.out.println("id is" + leadsourceID);
		String message = settingServiceInf.updateLeadSource(companyVO,
				leadsourceID);

		if (OMIConstants.TARGET_SUCCESS.equalsIgnoreCase(message)) {
			this.showMarketingLeadSourceList = settingServiceInf
					.showMarketingLeadSourceList();
			logger.info("Successfully Updated Lead Source Information!");
			addActionMessage("Successfully Updated Lead Source Information!");
			return SUCCESS;

		} else if (OMIConstants.TARGET_FAILURE.equalsIgnoreCase(message)) {

			logger.info("Error:while  Updating Lead Source Information!");
			addActionError("Error:while  Updating Lead Source Information!");
			return INPUT;
		}

		return NONE;
	}

	/**
	 * <p>
	 * <code>insertMarketingAccountType()</code>method is Used for Inserting a
	 * Account Type into database
	 * 
	 * </p>
	 * 
	 * 
	 * @return SUCCESS
	 * @throws Exception
	 */

	public String insertMarketingAccountType() throws OMIApplicationException {
		settingServiceInf = new SettingServiceImpl();
		String message = settingServiceInf.addMarketingAccountType(companyVO);
		CustomerSessionUser customerSessionUser = LoginUtil
				.getCurrentCustomerUser();
		companyVO.setCreatedBy(customerSessionUser.getCustomerId());
		LoginUtil.setProcessUserId(customerSessionUser.getCompanyId());

		if (OMIConstants.TARGET_SUCCESS.equalsIgnoreCase(message)) {
			this.showMarketingAccountTypeList = settingServiceInf
					.showMarketingAccountTypeList();
			logger.info("Successfully Inserted Account Type Details!");
			addActionMessage("Successfully Inserted  Account Type Details!");
			return SUCCESS;

		} else if (OMIConstants.TARGET_FAILURE.equalsIgnoreCase(message)) {

			logger.info("Error:while  Inserted  Account Type Details!");
			addActionError("Error:while  Inserted  Account Type Details!");
			return INPUT;
		}
		return NONE;

	}

	/**
	 * <p>
	 * <code>editAccountType()</code>this method is design to get Account Type
	 * details for the update process.
	 * </p>
	 * 
	 * @return SUCCESS
	 * @throws Exception
	 */

	public String editAccountType() throws Exception {
		settingServiceInf = new SettingServiceImpl();
		int accountTypeId = Integer.parseInt(request.getParameter("command"));
		/*
		 * if (financeId == 0) financeId = LoginUtil.getProcessUserId();
		 * LoginUtil.setProcessUserId(financeId);
		 */
		this.companyVO = VOMapperHelper.getCompanyVOFromCompany(companyVO,
				settingServiceInf.editAccountType(accountTypeId));
		session.put("accountTypeId", accountTypeId);

		return SUCCESS;
	}

	/**
	 * <p>
	 * <code>updateAccountType()</code> method is use to update Account type
	 * information into database
	 * </p>
	 * 
	 * @return SUCCESS
	 * @throws Exception
	 */
	public String updateAccountType() throws Exception {

		settingServiceInf = new SettingServiceImpl();
		/*
		 * int financeId = LoginUtil.getProcessUserId();
		 * LoginUtil.setProcessUserId(financeId);
		 */
		int accountTypeId = (Integer) session.get("accountTypeId");
		// System.out.println("id is" + leadsourceID);
		String message = settingServiceInf.updateAccountType(companyVO,
				accountTypeId);

		if (OMIConstants.TARGET_SUCCESS.equalsIgnoreCase(message)) {
			this.showMarketingAccountTypeList = settingServiceInf
					.showMarketingAccountTypeList();
			logger.info("Successfully Updated Account Type Information!");
			addActionMessage("Successfully Updated Account Type Information!");
			return SUCCESS;

		} else if (OMIConstants.TARGET_FAILURE.equalsIgnoreCase(message)) {

			logger.info("Error:while  Updating Account Type Information!");
			addActionError("Error:while  Updating Account Type Information!");
			return INPUT;
		}

		return NONE;
	}

	/**
	 * <p>
	 * <code>insertMarketingSlaName()</code>method is Used for Inserting a SLA
	 * Name into database
	 * 
	 * </p>
	 * 
	 * 
	 * @return SUCCESS
	 * @throws Exception
	 */

	public String insertMarketingSlaName() throws OMIApplicationException {
		settingServiceInf = new SettingServiceImpl();
		String message = settingServiceInf.addMarketingSlaName(companyVO);
		CustomerSessionUser customerSessionUser = LoginUtil
				.getCurrentCustomerUser();
		companyVO.setCreatedBy(customerSessionUser.getCustomerId());
		LoginUtil.setProcessUserId(customerSessionUser.getCompanyId());

		if (OMIConstants.TARGET_SUCCESS.equalsIgnoreCase(message)) {
			this.showMarketingSlaNameList = settingServiceInf
					.showMarketingSlaNameList();
			logger.info("Successfully Inserted SLA Name Details!");
			addActionMessage("Successfully Inserted   SLA Name Details!");
			return SUCCESS;

		} else if (OMIConstants.TARGET_FAILURE.equalsIgnoreCase(message)) {

			logger.info("Error:while  Inserted   SLA Name Details!");
			addActionError("Error:while  Inserted  SLA Name Details!");
			return INPUT;
		}
		return NONE;

	}

	/**
	 * <p>
	 * <code>insertMarketingCampaignType()</code>method is Used for Inserting a
	 * Campaign type into database
	 * 
	 * </p>
	 * 
	 * 
	 * @return SUCCESS
	 * @throws Exception
	 */

	public String insertMarketingCampaignType() throws OMIApplicationException {
		settingServiceInf = new SettingServiceImpl();
		String message = settingServiceInf.addMarketingCampaignType(companyVO);
		CustomerSessionUser customerSessionUser = LoginUtil
				.getCurrentCustomerUser();
		companyVO.setCreatedBy(customerSessionUser.getCustomerId());
		LoginUtil.setProcessUserId(customerSessionUser.getCompanyId());

		if (OMIConstants.TARGET_SUCCESS.equalsIgnoreCase(message)) {
			this.showMarketingCampaignTypeList = settingServiceInf
					.showMarketingCampaignTypeList();
			logger.info("Successfully Inserted Campaign Type Details!");
			addActionMessage("Successfully Inserted   Campaign Type Details!");
			return SUCCESS;

		} else if (OMIConstants.TARGET_FAILURE.equalsIgnoreCase(message)) {

			logger.info("Error:while  Inserted   Campaign Type Details!");
			addActionError("Error:while  Inserted  Campaign Type Details!");
			return INPUT;
		}
		return NONE;

	}

	/**
	 * <p>
	 * <code>editCampaignType()</code>this method is design to get Campaign Type
	 * details for the update process.
	 * </p>
	 * 
	 * @return SUCCESS
	 * @throws Exception
	 */

	public String editCampaignType() throws Exception {
		settingServiceInf = new SettingServiceImpl();
		int campaigntypeID = Integer.parseInt(request.getParameter("command"));
		/*
		 * if (financeId == 0) financeId = LoginUtil.getProcessUserId();
		 * LoginUtil.setProcessUserId(financeId);
		 */
		this.companyVO = VOMapperHelper.getCompanyVOFromCompany(companyVO,
				settingServiceInf.editCampaignType(campaigntypeID));
		session.put("campaigntypeID", campaigntypeID);

		return SUCCESS;
	}

	/**
	 * <p>
	 * <code>updateCampaignType()</code> method is use to update Campaign type
	 * information into database
	 * </p>
	 * 
	 * @return SUCCESS
	 * @throws Exception
	 */
	public String updateCampaignType() throws Exception {

		settingServiceInf = new SettingServiceImpl();
		/*
		 * int financeId = LoginUtil.getProcessUserId();
		 * LoginUtil.setProcessUserId(financeId);
		 */
		int campaigntypeID = (Integer) session.get("campaigntypeID");
		// System.out.println("id is" + leadsourceID);
		String message = settingServiceInf.updateCampaignType(companyVO,
				campaigntypeID);

		if (OMIConstants.TARGET_SUCCESS.equalsIgnoreCase(message)) {
			this.showMarketingCampaignTypeList = settingServiceInf
					.showMarketingCampaignTypeList();
			logger.info("Successfully Updated Campaign Type Information!");
			addActionMessage("Successfully Updated Campaign Type Information!");
			return SUCCESS;

		} else if (OMIConstants.TARGET_FAILURE.equalsIgnoreCase(message)) {

			logger.info("Error:while  Updating Campaign Type Information!");
			addActionError("Error:while  Updating Campaign Type Information!");
			return INPUT;
		}

		return NONE;
	}

	/**
	 * <p>
	 * <code>insertMarketingResponse()</code>method is Used for Inserting a
	 * Response into database
	 * 
	 * </p>
	 * 
	 * 
	 * @return SUCCESS
	 * @throws Exception
	 */

	public String insertMarketingResponse() throws OMIApplicationException {
		settingServiceInf = new SettingServiceImpl();
		String message = settingServiceInf.addMarketingResponse(companyVO);
		CustomerSessionUser customerSessionUser = LoginUtil
				.getCurrentCustomerUser();
		companyVO.setCreatedBy(customerSessionUser.getCustomerId());
		LoginUtil.setProcessUserId(customerSessionUser.getCompanyId());

		if (OMIConstants.TARGET_SUCCESS.equalsIgnoreCase(message)) {
			this.showMarketingResponseList = settingServiceInf
					.showMarketingResponseList();
			logger.info("Successfully Inserted Response Details!");
			addActionMessage("Successfully Inserted   Response Details!");
			return SUCCESS;

		} else if (OMIConstants.TARGET_FAILURE.equalsIgnoreCase(message)) {

			logger.info("Error:while  Inserted   Response Details!");
			addActionError("Error:while  Inserted  Response Details!");
			return INPUT;
		}
		return NONE;

	}

	/**
	 * <p>
	 * <code>insertMarketingVendorCategory()</code>method is Used for Inserting
	 * a Vendor Category into database
	 * 
	 * </p>
	 * 
	 * 
	 * @return SUCCESS
	 * @throws Exception
	 */

	public String insertMarketingVendorCategory()
			throws OMIApplicationException {
		settingServiceInf = new SettingServiceImpl();
		String message = settingServiceInf
				.addMarketingVendorCategory(companyVO);
		CustomerSessionUser customerSessionUser = LoginUtil
				.getCurrentCustomerUser();
		companyVO.setCreatedBy(customerSessionUser.getCustomerId());
		LoginUtil.setProcessUserId(customerSessionUser.getCompanyId());

		if (OMIConstants.TARGET_SUCCESS.equalsIgnoreCase(message)) {
			this.showMarketingVendorcategoryList = settingServiceInf
					.showMarketingVendorcategoryList();
			logger.info("Successfully Inserted Vendor Category Details!");
			addActionMessage("Successfully Inserted   Vendor Category Details!");
			return SUCCESS;

		} else if (OMIConstants.TARGET_FAILURE.equalsIgnoreCase(message)) {

			logger.info("Error:while  Inserted   Vendor Category Details!");
			addActionError("Error:while  Inserted  Vendor Category  Details!");
			return INPUT;
		}
		return NONE;

	}

	/**
	 * <p>
	 * <code>editVendorCategory()</code>this method is design to get Vendor
	 * Category details for the update process.
	 * </p>
	 * 
	 * @return SUCCESS
	 * @throws Exception
	 */

	public String editVendorCategory() throws Exception {
		settingServiceInf = new SettingServiceImpl();
		int vendorCategoryId = Integer
				.parseInt(request.getParameter("command"));
		/*
		 * if (companyTypeId == 0) companyTypeId = LoginUtil.getProcessUserId();
		 */
		// System.out.println("companyTypeId @@@@@@@@@@@ " + companyTypeId);
		this.companyVO = VOMapperHelper.getCompanyVOFromCompany(companyVO,
				settingServiceInf.editVendorCategoryDetails(vendorCategoryId));
		LoginUtil.setProcessUserId(vendorCategoryId);
		// System.out.println("companyTypeId @@@@@@@@@@@ ######" +
		// companyTypeId);
		session.put("vendorCategoryId", vendorCategoryId);
		return SUCCESS;
	}

	/**
	 * <p>
	 * <code>updateVendorCategory()</code> method is use to update Vendor
	 * category information into database
	 * </p>
	 * 
	 * @return SUCCESS
	 * @throws Exception
	 */
	public String updateVendorCategory() throws Exception {

		settingServiceInf = new SettingServiceImpl();
		int vendorCategoryId = (Integer) session.get("vendorCategoryId");

		// System.out.println("id is" + companyTypeId);
		String message = settingServiceInf.updateVendorCategory(companyVO,
				vendorCategoryId);

		if (OMIConstants.TARGET_SUCCESS.equalsIgnoreCase(message)) {
			this.showMarketingVendorcategoryList = settingServiceInf
					.showMarketingVendorcategoryList();
			logger.info("Successfully Updated Vendor Category Information!");
			addActionMessage("Successfully Updated Vendor Category Information!");
			return SUCCESS;

		} else if (OMIConstants.TARGET_FAILURE.equalsIgnoreCase(message)) {

			logger.info("Error:while  Updating Vendor Category Information!");
			addActionError("Error:while  Updating Vendor Category Information!");
			return INPUT;
		}

		return NONE;
	}

	/**
	 * <p>
	 * <code>insertMarketingTravelMode()</code>method is Used for Inserting a
	 * Travel Mode into database
	 * 
	 * </p>
	 * 
	 * 
	 * @return SUCCESS
	 * @throws Exception
	 */

	public String insertMarketingTravelMode() throws OMIApplicationException {
		settingServiceInf = new SettingServiceImpl();
		String message = settingServiceInf.addMarketingTravelMode(companyVO);
		CustomerSessionUser customerSessionUser = LoginUtil
				.getCurrentCustomerUser();
		companyVO.setCreatedBy(customerSessionUser.getCustomerId());
		LoginUtil.setProcessUserId(customerSessionUser.getCompanyId());

		if (OMIConstants.TARGET_SUCCESS.equalsIgnoreCase(message)) {
			this.showMarketingtravelModeList = settingServiceInf
					.showMarketingtravelModeList();
			logger.info("Successfully Inserted Travel Mode Details!");
			addActionMessage("Successfully Inserted   Travel Mode Details!");
			return SUCCESS;

		} else if (OMIConstants.TARGET_FAILURE.equalsIgnoreCase(message)) {

			logger.info("Error:while  Inserted   Travel Mode Details!");
			addActionError("Error:while  Inserted  Travel Mode  Details!");
			return INPUT;
		}
		return NONE;

	}

	/**
	 * <p>
	 * <code>editTravelMode()</code>this method is design to get Travel Mode
	 * details for the update process.
	 * </p>
	 * 
	 * @return SUCCESS
	 * @throws Exception
	 */

	public String editTravelMode() throws OMIApplicationException {
		settingServiceInf = new SettingServiceImpl();
		int travelmodeID = Integer.parseInt(request.getParameter("command"));
		this.companyVO = VOMapperHelper.getCompanyVOFromCompany(companyVO,
				settingServiceInf.editTravelModeDetails(travelmodeID));
		LoginUtil.setProcessUserId(travelmodeID);
		session.put("travelmodeID", travelmodeID);
		return SUCCESS;
	}

	/**
	 * <p>
	 * <code>updateTravelMode()</code> method is use to update Travel mode
	 * information into database
	 * </p>
	 * 
	 * @return SUCCESS
	 * @throws Exception
	 */
	public String updateTravelMode() throws OMIApplicationException {

		settingServiceInf = new SettingServiceImpl();
		int travelmodeID = (Integer) session.get("travelmodeID");
		String message = settingServiceInf.updateTravelMode(companyVO,
				travelmodeID);

		if (OMIConstants.TARGET_SUCCESS.equalsIgnoreCase(message)) {
			this.showMarketingtravelModeList = settingServiceInf.showMarketingtravelModeList();
			logger.info("Successfully Updated travel Mode Information!");
			addActionMessage("Successfully Updated Travel Mode Information!");
			return SUCCESS;

		} else if (OMIConstants.TARGET_FAILURE.equalsIgnoreCase(message)) {

			logger.info("Error:while  Updating Travel Mode Information!");
			addActionError("Error:while  Updating Travel Mode Information!");
			return INPUT;
		}

		return NONE;
	}
	/**
	 * <p>
	 * <code>insertSupportFAQCategory()</code>method is Used for Inserting a FAQ
	 * Category into database
	 * 
	 * </p>
	 * 
	 * 
	 * @return SUCCESS
	 * @throws Exception
	 */

	public String insertSupportFAQCategory() throws OMIApplicationException {
		settingServiceInf = new SettingServiceImpl();
		String message = settingServiceInf.addSupportFAQCategory(companyVO);
		CustomerSessionUser customerSessionUser = LoginUtil
				.getCurrentCustomerUser();
		companyVO.setCreatedBy(customerSessionUser.getCustomerId());
		LoginUtil.setProcessUserId(customerSessionUser.getCompanyId());

		if (OMIConstants.TARGET_SUCCESS.equalsIgnoreCase(message)) {
			this.showSupportfaqCategoryList = settingServiceInf
					.showSupportfaqCategoryList();
			logger.info("Successfully Inserted FAQ Category Details!");
			addActionMessage("Successfully Inserted FAQ Category Details!");
			return SUCCESS;

		} else if (OMIConstants.TARGET_FAILURE.equalsIgnoreCase(message)) {

			logger.info("Error:while  Inserted FAQ Category Details!");
			addActionError("Error:while  Inserted FAQ Category  Details!");
			return INPUT;
		}
		return NONE;

	}
	/**
	 * <p>
	 * <code>editFAQCategory()</code>this method is design to get FAQ Category
	 * details for the update process.
	 * </p>
	 * 
	 * @return SUCCESS
	 * @throws Exception
	 */

	public String editFAQCategory() throws OMIApplicationException {
		settingServiceInf = new SettingServiceImpl();
		int faqcategoryId = Integer.parseInt(request.getParameter("command"));
		this.companyVO = VOMapperHelper.getCompanyVOFromCompany(companyVO,
				settingServiceInf.editFAQCategoryDetail(faqcategoryId));
		LoginUtil.setProcessUserId(faqcategoryId);
		session.put("faqcategoryId", faqcategoryId);
		return SUCCESS;
	}

	/**
	 * <p>
	 * <code>updateFAQCategory()</code> method is use to update FAQ Category
	 * information into database
	 * </p>
	 * 
	 * @return SUCCESS
	 * @throws Exception
	 */
	public String updateFAQCategory() throws OMIApplicationException {

		settingServiceInf = new SettingServiceImpl();
		int faqcategoryId = (Integer) session.get("faqcategoryId");
		String message = settingServiceInf.updateFAQCategory(companyVO,
				faqcategoryId);

		if (OMIConstants.TARGET_SUCCESS.equalsIgnoreCase(message)) {
			this.showSupportfaqCategoryList = settingServiceInf
					.showSupportfaqCategoryList();
			logger.info("Successfully Updated FAQ Category Information!");
			addActionMessage("Successfully Updated FAQ Category Information!");
			return SUCCESS;

		} else if (OMIConstants.TARGET_FAILURE.equalsIgnoreCase(message)) {

			logger.info("Error:while  Updating FAQ Category Information!");
			addActionError("Error:while  Updating FAQ Category Information!");
			return INPUT;
		}

		return NONE;
	}


	


	/**
	 * <p>
	 * <code>insertProductCategory</code>Method is use to insert product
	 * CATEGORY into database.
	 * </p>
	 * r
	 * 
	 * @return
	 * @throws OMIApplicationException
	 */
	public String insertProductCategory() throws OMIApplicationException {
		settingServiceInf = new SettingServiceImpl();
		String message = settingServiceInf.addProductCategory(companyVO);
		CustomerSessionUser customerSessionUser = LoginUtil
				.getCurrentCustomerUser();
		companyVO.setCreatedBy(customerSessionUser.getCustomerId());
		LoginUtil.setProcessUserId(customerSessionUser.getCompanyId());

		if (OMIConstants.TARGET_SUCCESS.equalsIgnoreCase(message)) {
			this.productCategoryList = settingServiceInf
					.showProductCategoryGrid();
			logger.info("Successfully Inserted Product Category Details!");
			addActionMessage("Successfully Inserted   Product Category  Details!");
			return SUCCESS;

		} else if (OMIConstants.TARGET_FAILURE.equalsIgnoreCase(message)) {

			logger.info("Error:while  Inserted   Product Category  Details!");
			addActionError("Error:while  Inserted   Product Category  Details!");
			return INPUT;
		}
		return NONE;

	}
	
	
	public String insertProductType() throws OMIApplicationException {
		settingServiceInf = new SettingServiceImpl();
		String message = settingServiceInf.insertProductType(companyVO);
		CustomerSessionUser customerSessionUser = LoginUtil
				.getCurrentCustomerUser();
		companyVO.setCreatedBy(customerSessionUser.getCustomerId());
		LoginUtil.setProcessUserId(customerSessionUser.getCompanyId());

		if (OMIConstants.TARGET_SUCCESS.equalsIgnoreCase(message)) {
			this.productTypeList = settingServiceInf
					.showProductTypeGrid();
			logger.info("Successfully Inserted Product Type Details!");
			addActionMessage("Successfully Inserted   Product Type  Details!");
			return SUCCESS;

		} else if (OMIConstants.TARGET_FAILURE.equalsIgnoreCase(message)) {

			logger.info("Error:while  Inserted   Product Type  Details!");
			addActionError("Error:while  Inserted   Product Type  Details!");
			return INPUT;
		}
		return NONE;

	}
	/**
	 * <p>
	 * <code>editProductCategory()</code>this method is design to get Product Category
	 * details for the update process.
	 * </p>
	 * 
	 * @return SUCCESS
	 * @throws Exception
	 */

	public String editProductCategory() throws OMIApplicationException {
		settingServiceInf = new SettingServiceImpl();
		int productCategoryId = Integer.parseInt(request.getParameter("command"));
		this.companyVO = VOMapperHelper.getCompanyVOFromCompany(companyVO,
				settingServiceInf.editProductCategoryDetails(productCategoryId));
		LoginUtil.setProcessUserId(productCategoryId);
		session.put("productCategoryId", productCategoryId);
		return SUCCESS;
	}

	/**
	 * <p>
	 * <code>updateProductCategory()</code> method is use to update Product Category
	 * information into database
	 * </p>
	 * 
	 * @return SUCCESS
	 * @throws Exception
	 */
	public String updateProductCategory() throws OMIApplicationException {

		settingServiceInf = new SettingServiceImpl();
		int productCategoryId = (Integer) session.get("productCategoryId");
		String message = settingServiceInf.updateProductCategory(companyVO,
				productCategoryId);

		if (OMIConstants.TARGET_SUCCESS.equalsIgnoreCase(message)) {
			this.productCategoryList = settingServiceInf.showProductCategoryGrid();
			logger.info("Successfully Updated Product Category Information!");
			addActionMessage("Successfully Updated Product Category Information!");
			return SUCCESS;

		} else if (OMIConstants.TARGET_FAILURE.equalsIgnoreCase(message)) {

			logger.info("Error:while  Updating Product Category Information!");
			addActionError("Error:while  Updating Product Category Information!");
			return INPUT;
		}

		return NONE;
	}


	/**
	 * <p>
	 * <code>insertProductUsesUnit</code>Method is use to insert product Uses
	 * Unit into database.
	 * </p>
	 * r
	 * 
	 * @return
	 * @throws OMIApplicationException
	 */
	public String insertProductUsesUnit() throws OMIApplicationException {
		settingServiceInf = new SettingServiceImpl();
		String message = settingServiceInf.addProductUsesUnit(companyVO);
		CustomerSessionUser customerSessionUser = LoginUtil
				.getCurrentCustomerUser();
		companyVO.setCreatedBy(customerSessionUser.getCustomerId());
		LoginUtil.setProcessUserId(customerSessionUser.getCompanyId());

		if (OMIConstants.TARGET_SUCCESS.equalsIgnoreCase(message)) {
			this.showProductUsesUnitList = settingServiceInf
					.showProductUsesUnitList();
			logger.info("Successfully Inserted Product Uses Unit Details!");
			addActionMessage("Successfully Inserted   Product Uses Unit  Details!");
			return SUCCESS;

		} else if (OMIConstants.TARGET_FAILURE.equalsIgnoreCase(message)) {

			logger.info("Error:while  Inserted   Product Uses Unit  Details!");
			addActionError("Error:while  Inserted   Product Uses Unit  Details!");
			return INPUT;
		}
		return NONE;

	}

	/**
	 * <p>
	 * <code>editProductUsesUnit()</code>this method is design to get Product Uses Unit
	 * details for the update process.
	 * </p>
	 * 
	 * @return SUCCESS
	 * @throws Exception
	 */

	public String editProductUsesUnit() throws OMIApplicationException {
		settingServiceInf = new SettingServiceImpl();
		int productUsesUnitId = Integer.parseInt(request.getParameter("command"));
		this.companyVO = VOMapperHelper.getCompanyVOFromCompany(companyVO,
				settingServiceInf.editProductUsesUnitDetail(productUsesUnitId));
		LoginUtil.setProcessUserId(productUsesUnitId);
		session.put("productUsesUnitId", productUsesUnitId);
		return SUCCESS;
	}

	
	public String editProductType() throws OMIApplicationException {
		settingServiceInf = new SettingServiceImpl();
		int productTypeId= Integer.parseInt(request.getParameter("command"));
		this.companyVO = VOMapperHelper.getCompanyVOFromCompany(companyVO,
				settingServiceInf.editProductType(productTypeId));
		LoginUtil.setProcessUserId(productTypeId);
		session.put("productTypeId", productTypeId);
		return SUCCESS;
	}
	/**
	 * <p>
	 * <code>updateProductUsesUnit()</code> method is use to update Product Uses Unit
	 * information into database
	 * </p>
	 * 
	 * @return SUCCESS
	 * @throws Exception
	 */
	public String updateProductUsesUnit() throws OMIApplicationException {

		settingServiceInf = new SettingServiceImpl();
		int productUsesUnitId = (Integer) session.get("productUsesUnitId");
		String message = settingServiceInf.updateProductUsesUnit(companyVO,
				productUsesUnitId);

		if (OMIConstants.TARGET_SUCCESS.equalsIgnoreCase(message)) {
			this.showProductUsesUnitList = settingServiceInf
					.showProductUsesUnitList();
			logger.info("Successfully Updated Product Uses Unit Information!");
			addActionMessage("Successfully Updated Product Uses Unit Information!");
			return SUCCESS;

		} else if (OMIConstants.TARGET_FAILURE.equalsIgnoreCase(message)) {

			logger.info("Error:while  Updating Uses Unit Information!");
			addActionError("Error:while  Updating Uses Unit Information!");
			return INPUT;
		}

		return NONE;
	}


	
	/**
	 * <p>
	 * <code>insertSupportChannel</code>Method is use to insert channel into
	 * database.
	 * </p>
	 * 
	 * 
	 * @return
	 * @throws OMIApplicationException
	 */
	public String insertSupportChannel() throws OMIApplicationException {
		settingServiceInf = new SettingServiceImpl();
		String message = settingServiceInf.addSupportChannel(companyVO);
		CustomerSessionUser customerSessionUser = LoginUtil
				.getCurrentCustomerUser();
		companyVO.setCreatedBy(customerSessionUser.getCustomerId());
		LoginUtil.setProcessUserId(customerSessionUser.getCompanyId());

		if (OMIConstants.TARGET_SUCCESS.equalsIgnoreCase(message)) {
			this.showSupportChannelList = settingServiceInf
					.showSupportChannelList();
			logger.info("Successfully Inserted Support Channel Details!");
			addActionMessage("Successfully Inserted  Support Channel Details!");
			return SUCCESS;

		} else if (OMIConstants.TARGET_FAILURE.equalsIgnoreCase(message)) {

			logger.info("Error:while  Inserted   Support Channel Details!");
			addActionError("Error:while  Inserted  Support Channel Details!");
			return INPUT;
		}
		return NONE;

	}
     
	/**
	 * <p>
	 * <code>editChannel()</code>this method is design to get Channel
	 * details for the update process.
	 * </p>
	 * 
	 * @return SUCCESS
	 * @throws Exception
	 */

	public String editChannel() throws OMIApplicationException {
		settingServiceInf = new SettingServiceImpl();
		int channelId = Integer.parseInt(request.getParameter("command"));
		this.companyVO = VOMapperHelper.getCompanyVOFromCompany(companyVO,
				settingServiceInf.editChannelDetail(channelId));
		LoginUtil.setProcessUserId(channelId);
		session.put("channelId", channelId);
		return SUCCESS;
	}

	/**
	 * <p>
	 * <code>updateChannel()</code> method is use to update Channel
	 * information into database
	 * </p>
	 * 
	 * @return SUCCESS
	 * @throws Exception
	 */
	public String updateChannel() throws OMIApplicationException {

		settingServiceInf = new SettingServiceImpl();
		int channelId = (Integer) session.get("channelId");
		String message = settingServiceInf.updateChannel(companyVO,
				channelId);

		if (OMIConstants.TARGET_SUCCESS.equalsIgnoreCase(message)) {
			this.showSupportChannelList = settingServiceInf
					.showSupportChannelList();
			logger.info("Successfully Updated Channel Information!");
			addActionMessage("Successfully Updated Channel Information!");
			return SUCCESS;

		} else if (OMIConstants.TARGET_FAILURE.equalsIgnoreCase(message)) {

			logger.info("Error:while  Updating Channel Information!");
			addActionError("Error:while  Updating Channel Information!");
			return INPUT;
		}

		return NONE;
	}


	

	/**
	 * <p>
	 * <code>insertSupportTaskArea</code>Method is use to insert Task Area into
	 * database.
	 * </p>
	 * r
	 * 
	 * @return
	 * @throws OMIApplicationException
	 */
	public String insertSupportTaskArea() throws OMIApplicationException {
		settingServiceInf = new SettingServiceImpl();
		String message = settingServiceInf.addSupportTaskArea(companyVO);
		CustomerSessionUser customerSessionUser = LoginUtil
				.getCurrentCustomerUser();
		companyVO.setCreatedBy(customerSessionUser.getCustomerId());
		LoginUtil.setProcessUserId(customerSessionUser.getCompanyId());

		if (OMIConstants.TARGET_SUCCESS.equalsIgnoreCase(message)) {
			this.showSupportTaskAreaList = settingServiceInf
					.showSupportTaskAreaList();
			logger.info("Successfully Inserted Support Task Area Details!");
			addActionMessage("Successfully Inserted  Support Task Area Details!");
			return SUCCESS;

		} else if (OMIConstants.TARGET_FAILURE.equalsIgnoreCase(message)) {

			logger.info("Error:while  Inserted   Support Task Area Details!");
			addActionError("Error:while  Inserted  Support Task Area Details!");
			return INPUT;
		}
		return NONE;

	}
	/**
	 * <p>
	 * <code>editTaskArea()</code>this method is design to get Task Area
	 * details for the update process.
	 * </p>
	 * 
	 * @return SUCCESS
	 * @throws Exception
	 */

	public String editTaskArea() throws OMIApplicationException {
		settingServiceInf = new SettingServiceImpl();
		int taskareaId = Integer.parseInt(request.getParameter("command"));
		this.companyVO = VOMapperHelper.getCompanyVOFromCompany(companyVO,
				settingServiceInf.editTaskAreaDetail(taskareaId));
		LoginUtil.setProcessUserId(taskareaId);
		session.put("taskareaId", taskareaId);
		return SUCCESS;
	}

	/**
	 * <p>
	 * <code>updateTaskArea()</code> method is use to update Task Area
	 * information into database
	 * </p>
	 * 
	 * @return SUCCESS
	 * @throws Exception
	 */
	public String updateTaskArea() throws OMIApplicationException {

		settingServiceInf = new SettingServiceImpl();
		int taskareaId = (Integer) session.get("taskareaId");
		String message = settingServiceInf.updateTaskArea(companyVO,
				taskareaId);

		if (OMIConstants.TARGET_SUCCESS.equalsIgnoreCase(message)) {
			this.showSupportTaskAreaList = settingServiceInf
					.showSupportTaskAreaList();
			logger.info("Successfully Updated Task Area Information!");
			addActionMessage("Successfully Updated Task Area Information!");
			return SUCCESS;

		} else if (OMIConstants.TARGET_FAILURE.equalsIgnoreCase(message)) {

			logger.info("Error:while  Updating Task Area Information!");
			addActionError("Error:while  Updating Task Area Information!");
			return INPUT;
		}

		return NONE;
	}

	public String updateProductType() throws Exception {

		settingServiceInf = new SettingServiceImpl();
		int productTypeId = (Integer) session.get("productTypeId");

		System.out.println("id is" + productTypeId);
		String message = settingServiceInf.updateProductType(companyVO,
				productTypeId);

		if (OMIConstants.TARGET_SUCCESS.equalsIgnoreCase(message)) {
			this.productTypeList = settingServiceInf.showCompanyTypeGrid();
			logger.info("Successfully Updated product Type Information!");
			addActionMessage("Successfully Updated product Type Information!");
			return SUCCESS;

		} else if (OMIConstants.TARGET_FAILURE.equalsIgnoreCase(message)) {

			logger.info("Error:while  Updating product Type Information!");
			addActionError("Error:while  Updating product Type Information!");
			return INPUT;
		}

		return NONE;
	}
	
	public String deleteProductType() throws Exception {
/*
		settingServiceInf = new SettingServiceImpl();
		int productTypeId = (Integer) session.get("productTypeId");

		System.out.println("id is" + productTypeId);
		String message = settingServiceInf.updateProductType(companyVO,
				productTypeId);

		if (OMIConstants.TARGET_SUCCESS.equalsIgnoreCase(message)) {
			this.productTypeList = settingServiceInf.showCompanyTypeGrid();
			logger.info("Successfully Updated product Type Information!");
			addActionMessage("Successfully Updated product Type Information!");
			return SUCCESS;

		} else if (OMIConstants.TARGET_FAILURE.equalsIgnoreCase(message)) {

			logger.info("Error:while  Updating product Type Information!");
			addActionError("Error:while  Updating product Type Information!");
			return INPUT;
		}*/

		return NONE;
	}

	


	public List<CompanyVO> getShowCompanyCategoryList() {
		return showCompanyCategoryList;
	}

	public void setShowCompanyCategoryList(
			List<CompanyVO> showCompanyCategoryList) {
		this.showCompanyCategoryList = showCompanyCategoryList;
	}

	public List<CompanyVO> getShowCompanyLocalList() {
		return showCompanyLocalList;
	}

	public void setShowCompanyLocalList(List<CompanyVO> showCompanyLocalList) {
		this.showCompanyLocalList = showCompanyLocalList;
	}

	public List<CompanyVO> getFinanceTaxList() {
		return financeTaxList;
	}

	public void setFinanceTaxList(List<CompanyVO> financeTaxList) {
		this.financeTaxList = financeTaxList;
	}

	public Map<Integer, String> getCompanyTypeList() {
		return companyTypeList;
	}

	public void setCompanyTypeList(Map<Integer, String> companyTypeList) {
		this.companyTypeList = companyTypeList;
	}

	public Map<Integer, String> getCompanyCategoryList() {
		return companyCategoryList;
	}

	public void setCompanyCategoryList(Map<Integer, String> companyCategoryList) {
		this.companyCategoryList = companyCategoryList;
	}

	public Map<Integer, String> getCompanySectorList() {
		return companySectorList;
	}

	public void setCompanySectorList(Map<Integer, String> companySectorList) {
		this.companySectorList = companySectorList;
	}

	public Map<Integer, String> getCountryList() {
		return countryList;
	}

	public void setCountryList(Map<Integer, String> countryList) {
		this.countryList = countryList;
	}

	@Override
	public CompanyVO getModel() {
		// TODO Auto-generated method stub
		return companyVO;
	}

	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {

	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public Map<Integer, String> getTimeZoneList() {
		return timeZoneList;
	}

	public void setTimeZoneList(Map<Integer, String> timeZoneList) {
		this.timeZoneList = timeZoneList;
	}

	public Map<Integer, String> getLanguageList() {
		return languageList;
	}

	public void setLanguageList(Map<Integer, String> languageList) {
		this.languageList = languageList;
	}

	public Map<Integer, String> getCurrencyList() {
		return currencyList;
	}

	public void setCurrencyList(Map<Integer, String> currencyList) {
		this.currencyList = currencyList;
	}

	public List<CompanyVO> getShowcompanyTypeList() {
		return showcompanyTypeList;
	}

	public void setShowcompanyTypeList(List<CompanyVO> showcompanyTypeList) {
		this.showcompanyTypeList = showcompanyTypeList;
	}

	public List<CompanyVO> getShowCompanySectorList() {
		return showCompanySectorList;
	}

	public void setShowCompanySectorList(List<CompanyVO> showCompanySectorList) {
		this.showCompanySectorList = showCompanySectorList;
	}

	public List<CompanyVO> getShowFinanaceGLAccountList() {
		return showFinanaceGLAccountList;
	}

	public void setShowFinanaceGLAccountList(
			List<CompanyVO> showFinanaceGLAccountList) {
		this.showFinanaceGLAccountList = showFinanaceGLAccountList;
	}

	public CompanyVO getCompanyVO() {
		return companyVO;
	}

	public void setCompanyVO(CompanyVO companyVO) {
		this.companyVO = companyVO;
	}

	public List<CompanyVO> getProductCategoryList() {
		return productCategoryList;
	}

	public void setProductCategoryList(List<CompanyVO> productCategoryList) {
		this.productCategoryList = productCategoryList;
	}

	public List<CompanyVO> getShowMarketingLeadSourceList() {
		return showMarketingLeadSourceList;
	}

	public void setShowMarketingLeadSourceList(
			List<CompanyVO> showMarketingLeadSourceList) {
		this.showMarketingLeadSourceList = showMarketingLeadSourceList;
	}

	public List<CompanyVO> getShowMarketingAccountTypeList() {
		return showMarketingAccountTypeList;
	}

	public void setShowMarketingAccountTypeList(
			List<CompanyVO> showMarketingAccountTypeList) {
		this.showMarketingAccountTypeList = showMarketingAccountTypeList;
	}

	public List<CompanyVO> getShowMarketingSlaNameList() {
		return showMarketingSlaNameList;
	}

	public void setShowMarketingSlaNameList(
			List<CompanyVO> showMarketingSlaNameList) {
		this.showMarketingSlaNameList = showMarketingSlaNameList;
	}

	public List<CompanyVO> getShowMarketingCampaignTypeList() {
		return showMarketingCampaignTypeList;
	}

	public void setShowMarketingCampaignTypeList(
			List<CompanyVO> showMarketingCampaignTypeList) {
		this.showMarketingCampaignTypeList = showMarketingCampaignTypeList;
	}

	public List<CompanyVO> getShowMarketingResponseList() {
		return showMarketingResponseList;
	}

	public void setShowMarketingResponseList(
			List<CompanyVO> showMarketingResponseList) {
		this.showMarketingResponseList = showMarketingResponseList;
	}

	public List<CompanyVO> getShowMarketingVendorcategoryList() {
		return showMarketingVendorcategoryList;
	}

	public void setShowMarketingVendorcategoryList(
			List<CompanyVO> showMarketingVendorcategoryList) {
		this.showMarketingVendorcategoryList = showMarketingVendorcategoryList;
	}

	public List<CompanyVO> getShowMarketingtravelModeList() {
		return showMarketingtravelModeList;
	}

	public void setShowMarketingtravelModeList(
			List<CompanyVO> showMarketingtravelModeList) {
		this.showMarketingtravelModeList = showMarketingtravelModeList;
	}

	public List<CompanyVO> getShowSupportfaqCategoryList() {
		return showSupportfaqCategoryList;
	}

	public void setShowSupportfaqCategoryList(
			List<CompanyVO> showSupportfaqCategoryList) {
		this.showSupportfaqCategoryList = showSupportfaqCategoryList;
	}

	public List<CompanyVO> getShowSupportChannelList() {
		return showSupportChannelList;
	}

	public void setShowSupportChannelList(List<CompanyVO> showSupportChannelList) {
		this.showSupportChannelList = showSupportChannelList;
	}

	public List<CompanyVO> getShowSupportCaseImpactList() {
		return showSupportCaseImpactList;
	}

	public void setShowSupportCaseImpactList(
			List<CompanyVO> showSupportCaseImpactList) {
		this.showSupportCaseImpactList = showSupportCaseImpactList;
	}

	public List<CompanyVO> getShowSupportTaskAreaList() {
		return showSupportTaskAreaList;
	}

	public void setShowSupportTaskAreaList(
			List<CompanyVO> showSupportTaskAreaList) {
		this.showSupportTaskAreaList = showSupportTaskAreaList;
	}

	public List<CompanyVO> getShowProductUsesUnitList() {
		return showProductUsesUnitList;
	}

	public void setShowProductUsesUnitList(
			List<CompanyVO> showProductUsesUnitList) {
		this.showProductUsesUnitList = showProductUsesUnitList;
	}

	public Map<Integer, String> getGlAccounttypeList() {
		return glAccounttypeList;
	}

	public void setGlAccounttypeList(Map<Integer, String> glAccounttypeList) {
		this.glAccounttypeList = glAccounttypeList;
	}

	public List<CompanyVO> getShowCountryList() {
		return showCountryList;
	}

	public void setShowCountryList(List<CompanyVO> showCountryList) {
		this.showCountryList = showCountryList;
	}

	public Map<Integer, String> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(Map<Integer, String> categoryList) {
		this.categoryList = categoryList;
	}

	public List<CompanyVO> getProductTypeList() {
		return productTypeList;
	}

	public void setProductTypeList(List<CompanyVO> productTypeList) {
		this.productTypeList = productTypeList;
	}

}
