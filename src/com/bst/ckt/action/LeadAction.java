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
 * Class Name     LeadAction.java     
 *                                                            
 * Creation Date  AUG 20, 2015 
 * 
 * Abstract       This is Name helper class to retrieve data from database 
 *                and returns name of value based on input.
 *  
 * Amendment History (in chronological sequence): AUG 10, 2015 
 * 
 **********************************************************************
 */

package com.bst.ckt.action;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.bst.ckt.common.LoginUtil;
import com.bst.ckt.common.OMIConstants;
import com.bst.ckt.dao.AjaxDaoImpl;
import com.bst.ckt.dao.LeadDaoImpl;
import com.bst.ckt.dao.LeadDaoInf;
import com.bst.ckt.framework.user.CustomerSessionUser;
import com.bst.ckt.helper.LeadAdvanceSerach;
import com.bst.ckt.helper.LeadStatus;
import com.bst.ckt.helper.ListHelper;
import com.bst.ckt.helper.Ratings;
import com.bst.ckt.helper.Salutation;
import com.bst.ckt.helper.VOMapperHelper;
import com.bst.ckt.service.LeadServiceImpl;
import com.bst.ckt.service.LeadServiceInf;
import com.bst.ckt.vo.LeadTitleVO;
import com.bst.ckt.vo.LeadVO;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LeadAction extends ActionSupport implements ServletResponseAware,
		ModelDriven<LeadVO>, SessionAware {

	/**
	 * Creating Logger object, logger object mapped with LeadAction class for
	 * writing Loggers.
	 */
	private static final Logger logger = Logger.getLogger(LeadAction.class);

	private static final long serialVersionUID = 1L;
	LeadServiceInf leadServiceInf = new LeadServiceImpl();
	ListHelper listHelper = new ListHelper();
	LeadVO leadVO = new LeadVO();
	HttpServletResponse response = null;
	HttpServletRequest request = (HttpServletRequest) ActionContext
			.getContext().get(ServletActionContext.HTTP_REQUEST);
	Map<String, Object> session = null;
	String result = OMIConstants.TARGET_INPUT;
	LeadTitleVO leadTitleVO = null;
	LeadDaoInf leadDaoInf = new LeadDaoImpl();
	private List<LeadTitleVO> leadTitleGrid = null;

	AjaxDaoImpl ajaxDaoImpl = new AjaxDaoImpl();
	private Map<Integer, String> leadTitleList;
	private Map<Integer, String> companyTypeList;
	private Map<Integer, String> companyCategoryList;
	private Map<Integer, String> companySectorList;
	private Map<Integer, String> countryList;
	private Map<Integer, String> leadSourceList;
	private Map<Integer, String> customerNameList;
	private List<LeadVO> leadFollowUpDetailsGrid;
	private HashMap<Integer, String> leadStatusList;
	private HashMap<Integer, String> salutationList;
	private Map<Integer, String> leadSocialSiteValueList;
	private List<LeadVO> leadSocialDetailsGrid;
	private HashMap<String, String> companyNameList;
	private HashMap<String, String> contactPersonNameList;
	private HashMap<Integer, String> ratingList;
	private HashMap<Integer, String> advanceSearchList;

	public LeadAction() throws Exception {

		companyTypeList = listHelper.companyTypeList();
		companyCategoryList = listHelper.companyCategoryList();
		companySectorList = listHelper.companySectorList();
		setCountryList(listHelper.countryList());
		leadSourceList = listHelper.leadSourceList();
		customerNameList = listHelper.customerNameList();
		setLeadTitleGrid(leadDaoInf.showTitles());
		leadStatusList = LeadStatus.getLeadStatusList();
		leadTitleList = listHelper.leadTitleList();
		leadSocialSiteValueList = listHelper.socialSiteValueList();
		salutationList = Salutation.getSalutationList();
		companyNameList = leadDaoInf.getCompanyNameListOfLead();
		contactPersonNameList = listHelper.getContactPersonNameListOfLead();
		ratingList = Ratings.getRatingList();
		advanceSearchList = LeadAdvanceSerach.getLeadAdvanceSearchList();
		CustomerSessionUser customerSessionUser = LoginUtil
				.getCurrentCustomerUser();
		leadVO.setLeadOwnerId(customerSessionUser.getCustomerId());
	}

	public String execute() throws Exception {

		return SUCCESS;

	}

	/**
	 * @return the listHelper
	 */
	public ListHelper getListHelper() {
		return listHelper;
	}

	/**
	 * @param listHelper
	 *            the listHelper to set
	 */
	public void setListHelper(ListHelper listHelper) {
		this.listHelper = listHelper;
	}

	/**
	 * <p>
	 * AddLeadDetails()
	 * </p>
	 * method is use to add lead details into database
	 * 
	 * @return SUCCESS
	 * @throws Exception
	 */

	public String AddLeadDetails() throws Exception {

		leadServiceInf = new LeadServiceImpl();

		CustomerSessionUser customerSessionUser = LoginUtil
				.getCurrentCustomerUser();
		leadVO.setCreatedBy(customerSessionUser.getCustomerId());
		
		String message = leadServiceInf.RegisterLeadDetail(leadVO);
		/**
		 * TARGET_SUCCESS; TARGET_FAILURE
		 */
		if (OMIConstants.TARGET_SUCCESS.equalsIgnoreCase(message)) {
			logger.info("Successfully Insert Lead Details!");
			addActionMessage("Successfully Insert Lead Details!");
			return SUCCESS;

		} else if (OMIConstants.TARGET_FAILURE.equalsIgnoreCase(message)) {

			logger.info("Error:while  Insert Lead Details!");
			addActionError("Error:while  Insert Lead Details!");
			return INPUT;
		}

		return NONE;
	}

	/**
	 * <p>
	 * <code>viewLead()</code> method is use to view the lead details into view
	 * lead page
	 * </p>
	 * 
	 * @return
	 * @throws Exception
	 */
	public String viewLead() throws Exception {
		int leadId = Integer.parseInt(request.getParameter("command"));
		LoginUtil.setProcessUserId(leadId);
		this.leadVO = VOMapperHelper.getLeadVOFromLead(leadVO,
				leadServiceInf.viewLead(leadId));
		leadSocialDetailsGrid = leadDaoInf.getLeadSocialDetailsList(leadId);
		leadFollowUpDetailsGrid = leadDaoInf.getLeadFollowUpDetails(leadId);
		session.put("LeadId", leadId);
		return SUCCESS;
	}

	/**
	 * <p>
	 * <code>viewNextLead()</code> method is use to view the lead details into
	 * view lead page
	 * </p>
	 * 
	 * @return
	 * @throws Exception
	 */
	public String nextAndPreviousViewLead() throws Exception {
		int leadId = LoginUtil.getProcessUserId();
		String actionType=request.getParameter("command");
		this.leadVO = VOMapperHelper.getLeadVOFromLead(leadVO,
				leadServiceInf.nextAndPreviousViewLead(leadId,actionType));
		leadSocialDetailsGrid = leadDaoInf.getLeadSocialDetailsList(leadVO
				.getLeadId());
		leadFollowUpDetailsGrid = leadDaoInf.getLeadFollowUpDetails(leadVO
				.getLeadId());

		if (leadVO.getLeadId() != 0) {
			logger.info("Lead details found successfully for Lead Id  "
					+ leadVO.getLeadId());
			addActionMessage("Lead details found successfully for Lead Id "
					+ leadVO.getLeadId());
			return SUCCESS;
		} else {
			leadVO.setLeadId(LoginUtil.getProcessUserId());
			logger.error("Lead details not found for Lead Id  "
					+ leadVO.getLeadId());
			addActionError("Lead details not found for Lead Id "
					+ leadVO.getLeadId());
			return ERROR;

		}
	}

	/**
	 * <p>
	 * <code>editNextLead()</code> method is use to populate next lead details
	 * into edit lead page
	 * </p>
	 * 
	 * @return
	 * @throws Exception
	 */
	public String editNextLead() throws Exception {
		int leadId = LoginUtil.getProcessUserId();
		this.leadVO = VOMapperHelper.getLeadVOFromLead(leadVO,
				leadServiceInf.editNextLeadDetails(leadId));
		if (leadVO.getLeadId() != 0) {
			logger.info("Lead details found successfully for Lead Id  "
					+ leadVO.getLeadId());
			addActionMessage("Lead details found successfully for Lead Id "
					+ leadVO.getLeadId());
			return SUCCESS;
		} else {
			leadVO.setLeadId(LoginUtil.getProcessUserId());
			logger.error("Lead details not found for Lead Id  "
					+ leadVO.getLeadId());
			addActionError("Lead details not found for Lead Id "
					+ leadVO.getLeadId());
			return ERROR;

		}
	}

	/**
	 * <p>
	 * <code>viewNextLead()</code> method is use to view the lead details into
	 * view lead page
	 * </p>
	 * 
	 * @return
	 * @throws Exception
	 */
	public String previousViewLead() throws Exception {
		int leadId = LoginUtil.getProcessUserId();
		this.leadVO = VOMapperHelper.getLeadVOFromLead(leadVO,
				leadServiceInf.viewPreviousLeadDetails(leadId));
		leadSocialDetailsGrid = leadDaoInf.getLeadSocialDetailsList(leadVO
				.getLeadId());
		leadFollowUpDetailsGrid = leadDaoInf.getLeadFollowUpDetails(leadVO
				.getLeadId());
		System.out.println("lead id =" + leadVO.getLeadId());
		if (leadVO.getLeadId() != 0) {
			logger.info("Lead details found successfully for Lead Id  "
					+ leadVO.getLeadId());
			addActionMessage("Lead details found successfully for Lead Id "
					+ leadVO.getLeadId());
			return SUCCESS;
		} else if (LoginUtil.getProcessUserId() == -1) {
			LoginUtil.setProcessUserId(leadDaoInf.getLeadLastRecord() + 1);
			logger.error("Lead details not found");
			addActionError("Lead details not found");
			return ERROR;
		} else {
			leadVO.setLeadId(LoginUtil.getProcessUserId());
			logger.error("Lead details not found for Lead Id  "
					+ leadVO.getLeadId());
			addActionError("Lead details not found for Lead Id "
					+ leadVO.getLeadId());
			return ERROR;

		}

	}

	/**
	 * <p>
	 * <code>previousEditLead()</code> method is use to view the lead details
	 * into edit lead page
	 * </p>
	 * 
	 * @return
	 * @throws Exception
	 */
	public String previousEditLead() throws Exception {
		int leadId = LoginUtil.getProcessUserId();
		this.leadVO = VOMapperHelper.getLeadVOFromLead(leadVO,
				leadServiceInf.editPreviousLeadDetails(leadId));

		if (leadVO.getLeadId() != 0) {
			logger.info("Lead details found successfully for Lead Id  "
					+ leadVO.getLeadId());
			addActionMessage("Lead details found successfully for Lead Id "
					+ leadVO.getLeadId());
			return SUCCESS;
		} else if (LoginUtil.getProcessUserId() == -1) {
			LoginUtil.setProcessUserId(leadDaoInf.getLeadLastRecord() + 1);
			logger.error("Lead details not found");
			addActionError("Lead details not found");
			return ERROR;
		} else {
			leadVO.setLeadId(LoginUtil.getProcessUserId());
			logger.error("Lead details not found for Lead Id  "
					+ leadVO.getLeadId());
			addActionError("Lead details not found for Lead Id "
					+ leadVO.getLeadId());
			return ERROR;

		}

	}

	/**
	 * <p>
	 * <code>editLead()</code>this method is design to get lead details for the
	 * update process.
	 * </p>
	 * 
	 * @return SUCCESS
	 * @throws Exception
	 */
	public String editLead() throws Exception {
		int leadId = Integer.parseInt(request.getParameter("command"));
		if (leadId == 0)
			leadId = LoginUtil.getProcessUserId();
		LoginUtil.setProcessUserId(leadId);
		leadServiceInf = new LeadServiceImpl();
		this.leadVO = VOMapperHelper.getLeadVOFromLead(leadVO,
				leadServiceInf.editLeadDetails(leadId));
		return SUCCESS;
	}

	/**
	 * <p>
	 * <code>populateLeadDetails()</code>this method is design to get lead
	 * details for create clone of the existing lead details
	 * </p>
	 * 
	 * @return SUCCESS
	 * @throws Exception
	 */
	public String populateLeadDetails() throws Exception {
		int leadId = Integer.parseInt(request.getParameter("command"));
		if (leadId == 0)
			leadId = LoginUtil.getProcessUserId();
		LoginUtil.setProcessUserId(leadId);
		leadServiceInf = new LeadServiceImpl();
		leadVO = VOMapperHelper.getLeadVOFromLead(leadVO,
				leadServiceInf.editLeadDetails(leadId));
		leadVO.setCompanyName(null);
		return SUCCESS;
	}

	/**
	 * <p>
	 * <code>viewLeadFollowUpDetails()</code>method is use to view the lead
	 * follow up details into grid.
	 * </p>
	 * 
	 * @return
	 * @throws Exception
	 */
	public String viewLeadFollowUpDetails() throws Exception {

		int leadId = LoginUtil.getProcessUserId();
		leadFollowUpDetailsGrid = leadDaoInf.getLeadFollowUpDetails(leadId);
		return SUCCESS;
	}

	/**
	 * <p>
	 * <code>addLeadFollowUp()</code> method is use to add lead follow up into
	 * database
	 * </p>
	 * 
	 * @return SUCCESS
	 * @throws Exception
	 */
	public String addLeadFollowUp() throws Exception {
		leadServiceInf = new LeadServiceImpl();
		
		CustomerSessionUser customerSessionUser = LoginUtil
				.getCurrentCustomerUser();
		leadVO.setCreatedBy(customerSessionUser.getCustomerId());
		int leadId = LoginUtil.getProcessUserId();
		System.out.println("lead id is =  " + leadId);
		leadVO.setLeadId(leadId);
		String message = leadServiceInf.addLeadFollowUp(leadVO);
		leadFollowUpDetailsGrid = leadDaoInf.getLeadFollowUpDetails(leadId);
		if (OMIConstants.TARGET_SUCCESS.equalsIgnoreCase(message)) {
			logger.info("Successfully Insert Lead Follow Up Details!");
			addActionMessage("Successfully Insert Lead Follow Up Details!");
			return SUCCESS;

		} else if (OMIConstants.TARGET_FAILURE.equalsIgnoreCase(message)) {

			logger.info("Error:while  Inserting Lead Follow Up Details!");
			addActionError("Error:while  Inserting Lead Follow Up Details!");
			return INPUT;
		}

		return NONE;
	}

	/**
	 * <p>
	 * <code>updateLead()</code> method is use to update lead information into
	 * database
	 * </p>
	 * 
	 * @return SUCCESS
	 * @throws Exception
	 */
	public String updateLead() throws Exception {

		leadServiceInf = new LeadServiceImpl();
		int leadId = LoginUtil.getProcessUserId();
		String message = leadServiceInf.updateLead(leadVO, leadId);

		if (OMIConstants.TARGET_SUCCESS.equalsIgnoreCase(message)) {

			logger.info("Successfully Updated Lead Information!");
			addActionMessage("Successfully Updated Lead Information!");
			return SUCCESS;

		} else if (OMIConstants.TARGET_FAILURE.equalsIgnoreCase(message)) {

			logger.info("Error:while  Updating Lead Information!");
			addActionError("Error:while  Updating Lead Information!");
			return INPUT;
		}

		return NONE;
	}

	/**
	 * <p>
	 * <code>updateLeadContactInfo()</code> method is use to update lead contact
	 * information into database
	 * </p>
	 * 
	 * @return SUCCESS
	 * @throws Exception
	 */
	public String updateLeadContactInfo() throws Exception {

		leadServiceInf = new LeadServiceImpl();
		int leadId = LoginUtil.getProcessUserId();

		String message = leadServiceInf.updateLeadContactInfo(leadVO, leadId);

		if (OMIConstants.TARGET_SUCCESS.equalsIgnoreCase(message)) {
			logger.info("Successfully Updated Lead Contact Information!");
			addActionMessage("Successfully Updated Lead Contact Information!");
			return SUCCESS;

		} else if (OMIConstants.TARGET_FAILURE.equalsIgnoreCase(message)) {

			logger.info("Error:while  Updating Lead Contact Information!");
			addActionError("Error:while  Updating Lead Contact Information!");
			return INPUT;
		}

		return NONE;
	}

	/**
	 * <p>
	 * leadPrintPDF()
	 * </p>
	 * method to generate the pdf report of lead details from database
	 * 
	 * @return
	 * @throws Exception
	 */
	public String leadPrintPDF() throws Exception {
		int leadId = (Integer) session.get("LeadId");
		System.out.println("lead id while processing pdf report" + leadId);
		leadServiceInf.leadPDF(request, response, leadId);
		return null;
	}

	/**
	 * <p>
	 * excelReport()
	 * </p>
	 * method to generate the Excel Sheet report of lead Dashboard from database
	 * 
	 * @return
	 * @throws Exception
	 * @author Deepak Vishwakarma
	 * @param request
	 *            ,response
	 */
	public String excelReport() throws Exception {
		leadServiceInf.leadExcelReport(request, response);
		return NONE;
	}

	/**
	 * <p>
	 * <code>addLeadTitle()</code> this method design to add lead title into the
	 * database.
	 * </p>
	 * 
	 * @return SUCCESS
	 * @throws Exception
	 */
	public String addLeadTitle() throws Exception {

		leadServiceInf = new LeadServiceImpl();
		String message = null;

		message = leadServiceInf.addLeadTitle(leadVO);

		/**
		 * RESULT_SUCCESS TARGET_LEAD_TITLE_ALREADY_INSERTED
		 * */
		if (OMIConstants.TARGET_SUCCESS.equalsIgnoreCase(message)) {
			leadTitleGrid = leadDaoInf.showTitles();
			leadTitleList = listHelper.leadTitleList();
			logger.info("Lead title inserted successfully.");
			addActionMessage("Lead title inserted successfully.");
			return SUCCESS;
		} else if (OMIConstants.TARGET_LEAD_TITLE_ALREADY_EXIST
				.equalsIgnoreCase(message)) {
			logger.info("Error:Lead title already exists!");
			addActionError("Lead title already exists.");
			return INPUT;
		}
		return NONE;
	}

	/**
	 * <p>
	 * <code>isLeadTitleExist()</code> method verify whether the lead title
	 * already exists
	 * </p>
	 * 
	 * @return NONE
	 * @throws Exception
	 */
	public String isLeadTitleExist() throws Exception {

		try {

			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
			PrintWriter printWriter = response.getWriter();

			if (leadDaoInf.isLeadTitleExist(request.getParameter("leadTitle")) == 1) {
				printWriter.print("Lead title already exists.");
			}

		} catch (Exception exception) {
			logger.error(
					"Error While verifying whether  the lead title already exists ",
					exception);
		}
		return NONE;
	}

	/**
	 * <p>
	 * <code>addLeadSocial()</code> this method design to add lead social into
	 * the database.
	 * </p>
	 * 
	 * @return SUCCESS
	 * @throws Exception
	 */

	public String addLeadSocial() throws Exception {

		leadServiceInf = new LeadServiceImpl();
		String message = null;
		int leadId = LoginUtil.getProcessUserId();
		leadVO.setLeadId(leadId);
		message = leadServiceInf.addLeadSocialInformation(leadVO);
		if (OMIConstants.TARGET_SUCCESS.equalsIgnoreCase(message)) {
			leadSocialDetailsGrid = leadDaoInf.getLeadSocialDetailsList(leadId);
			logger.info("Lead social details inserted successfully.");
			addActionMessage("Lead social details inserted successfully.");
			return SUCCESS;
		} else if (OMIConstants.TARGET_SUCCESS1.equalsIgnoreCase(message)) {
			leadSocialDetailsGrid = leadDaoInf.getLeadSocialDetailsList(leadId);
			logger.info("Lead social details updated successfully.");
			addActionMessage("Lead social details updated successfully.");
			return SUCCESS;
		} else if (OMIConstants.TARGET_FAILURE.equalsIgnoreCase(message)) {
			logger.info("Error:While inserting and updating lead social details.");
			addActionError("Error:While inserting and updating lead social details.");
			return INPUT;
		}
		return NONE;
	}

	/**
	 * <p>
	 * <code>showLeadSocialDetails()</code> this method design to display lead
	 * social details from the database.
	 * </p>
	 * 
	 * @return SUCCESS
	 * @throws Exception
	 */
	public String showLeadSocialDetails() throws Exception {
		int leadId = LoginUtil.getProcessUserId();
		leadSocialDetailsGrid = leadDaoInf.getLeadSocialDetailsList(leadId);
		return SUCCESS;
	}
	
	
		/*public String gridHeaderData()throws OMIApplicationException{
			
			leadServiceInf = new LeadServiceImpl();
			
			String message=leadServiceInf
			
			
			return SUCCESS;
			
		}
*/
	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public List<LeadTitleVO> getLeadTitleGrid() {
		return leadTitleGrid;
	}

	public void setLeadTitleGrid(List<LeadTitleVO> leadTitleGrid) {
		this.leadTitleGrid = leadTitleGrid;
	}

	private List<LeadVO> leadDetailList = null;

	public List<LeadVO> getLeadDetailList() {
		return leadDetailList;
	}

	public void setLeadDetailList(List<LeadVO> leadDetailList) {
		this.leadDetailList = leadDetailList;
	}

	public String leadDetailsGrid() throws Exception {

		leadServiceInf = new LeadServiceImpl();
		this.leadDetailList = leadServiceInf.retriveLeadDetailsGrid(leadVO);
		if (leadDetailList == null) {
			logger.error("Error:While getting lead details as per advance search.");
			addActionError("No records found.");
			return ERROR;
		} else {
			logger.info("Records found successfully.");
			return SUCCESS;
		}

	}

	@Override
	public LeadVO getModel() {

		return leadVO;
	}

	public LeadTitleVO getLeadTitleVO() {
		return leadTitleVO;
	}

	public void setLeadTitleVO(LeadTitleVO leadTitleVO) {
		this.leadTitleVO = leadTitleVO;
	}

	public Map<Integer, String> getLeadTitleList() {
		return leadTitleList;
	}

	public void setLeadTitleList(Map<Integer, String> leadTitleList) {
		this.leadTitleList = leadTitleList;
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

	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;

	}

	public LeadVO getLeadVO() {
		return leadVO;
	}

	public void setLeadVO(LeadVO leadVO) {
		this.leadVO = leadVO;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public Map<Integer, String> getLeadSourceList() {
		return leadSourceList;
	}

	public void setLeadSourceList(Map<Integer, String> leadSourceList) {
		this.leadSourceList = leadSourceList;
	}

	public List<LeadVO> getLeadFollowUpDetailsGrid() {
		return leadFollowUpDetailsGrid;
	}

	public void setLeadFollowUpDetailsGrid(List<LeadVO> leadFollowUpDetailsGrid) {
		this.leadFollowUpDetailsGrid = leadFollowUpDetailsGrid;
	}

	/**
	 * @return the leadSocialSiteValueList
	 */
	public Map<Integer, String> getLeadSocialSiteValueList() {
		return leadSocialSiteValueList;
	}

	/**
	 * @param leadSocialSiteValueList
	 *            the leadSocialSiteValueList to set
	 */
	public void setLeadSocialSiteValueList(
			Map<Integer, String> leadSocialSiteValueList) {
		this.leadSocialSiteValueList = leadSocialSiteValueList;
	}

	public HashMap<String, String> getCompanyNameList() {
		return companyNameList;
	}

	public void setCompanyNameList(HashMap<String, String> companyNameList) {
		this.companyNameList = companyNameList;
	}

	public HashMap<Integer, String> getLeadStatusList() {
		return leadStatusList;
	}

	public void setLeadStatusList(HashMap<Integer, String> leadStatusList) {
		this.leadStatusList = leadStatusList;
	}

	public HashMap<Integer, String> getRatingList() {
		return ratingList;
	}

	public void setRatingList(HashMap<Integer, String> ratingList) {
		this.ratingList = ratingList;
	}

	public HashMap<Integer, String> getSalutationList() {
		return salutationList;
	}

	public void setSalutationList(HashMap<Integer, String> salutationList) {
		this.salutationList = salutationList;
	}

	/**
	 * @return the leadSocialDetailsGrid
	 */
	public List<LeadVO> getLeadSocialDetailsGrid() {
		return leadSocialDetailsGrid;
	}

	/**
	 * @param leadSocialDetailsGrid
	 *            the leadSocialDetailsGrid to set
	 */
	public void setLeadSocialDetailsGrid(List<LeadVO> leadSocialDetailsGrid) {
		this.leadSocialDetailsGrid = leadSocialDetailsGrid;
	}

	public Map<Integer, String> getCustomerNameList() {
		return customerNameList;
	}

	public void setCustomerNameList(Map<Integer, String> customerNameList) {
		this.customerNameList = customerNameList;
	}

	/**
	 * @return the advanceSearchList
	 */
	public HashMap<Integer, String> getAdvanceSearchList() {
		return advanceSearchList;
	}

	/**
	 * @param advanceSearchList
	 *            the advanceSearchList to set
	 */
	public void setAdvanceSearchList(HashMap<Integer, String> advanceSearchList) {
		this.advanceSearchList = advanceSearchList;
	}

	public HashMap<String, String> getContactPersonNameList() {
		return contactPersonNameList;
	}

	public void setContactPersonNameList(
			HashMap<String, String> contactPersonNameList) {
		this.contactPersonNameList = contactPersonNameList;
	}

}
