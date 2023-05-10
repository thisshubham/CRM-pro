/**
 * 
 */
package com.bst.ckt.action;

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
import com.bst.ckt.dao.CampaignDaoImpl;
import com.bst.ckt.dao.CampaignDaoInf;
import com.bst.ckt.framework.user.CustomerSessionUser;
import com.bst.ckt.helper.CampaignExpectedResponse;
import com.bst.ckt.helper.CampaignStatus;
import com.bst.ckt.helper.ListHelper;
import com.bst.ckt.helper.Salutation;
import com.bst.ckt.helper.campaignAdvanceSearch;
import com.bst.ckt.service.CampaignServiceImpl;
import com.bst.ckt.service.CampaignServiceInf;
import com.bst.ckt.service.NoteServiceImpl;
import com.bst.ckt.vo.CampaignVO;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @author gurjar
 * 
 */
public class CampaignAction extends ActionSupport implements
		ServletResponseAware, ModelDriven<CampaignVO>, SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Creating Logger object, logger object mapped with LeadAction class for
	 * writing Loggers.
	 */
	private static final Logger logger = Logger.getLogger(CampaignAction.class);

	CampaignServiceInf campaignServiceInf = new CampaignServiceImpl();
	CampaignDaoInf campaignDaoInf = new CampaignDaoImpl();
	ListHelper listHelper = new ListHelper();
	CampaignVO campaignVO = new CampaignVO();
	HttpServletResponse response = null;
	HttpServletRequest request = (HttpServletRequest) ActionContext
			.getContext().get(ServletActionContext.HTTP_REQUEST);
	Map<String, Object> session = null;
	String result = OMIConstants.TARGET_INPUT;
	AjaxDaoImpl ajaxDaoImpl = new AjaxDaoImpl();
	private Map<Integer, String> campaignTypeList;
	private Map<Integer, String> campaignOwnerList;
	private Map<Integer, String> campaignAssignedToList;
	private List<CampaignVO> campaignDetailsList = null;
	private Map<Integer, String> salutationList;

	HashMap<Integer, String> campaignStatusList = null;
	HashMap<Integer, String> campaignExpectedResponseList = null;
	HashMap<Integer, String> advanceSearchList = null;

	HashMap<String, String> campaignNameList = null;
	HashMap<String, String> expectedRevenueList = null;
	HashMap<String, String> expectedClosingDateList = null;
	
	
	
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
	 * @return the session
	 */
	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public CampaignAction() throws Exception {
		salutationList = Salutation.getSalutationList();
		campaignTypeList = listHelper.campaignTypeList();
		campaignOwnerList = listHelper.campaignOwnerList();
		campaignAssignedToList = listHelper.campaignAssignedToList();
		CustomerSessionUser customerSessionUser = LoginUtil
				.getCurrentCustomerUser();
		Integer id = customerSessionUser.getCustomerId();
		campaignVO.setCreatedBy(id.toString());
		campaignVO.setUpdatedBy(id.toString());
		campaignVO.setCampaignOwner(id.toString());
		campaignVO.setAssignedTo(id.toString());
		this.campaignStatusList = CampaignStatus.getCreateCampaignStatusList();
		this.campaignExpectedResponseList = CampaignExpectedResponse
				.getCreateCampaignExpectedResponseList();
		advanceSearchList=campaignAdvanceSearch.getCampaignAdvanceSearchList();
		campaignNameList =campaignDaoInf.getCampainNameList();
		expectedRevenueList=campaignDaoInf.getExpectedRevenueList();
		expectedClosingDateList=campaignDaoInf.getExpectedClosingDate();
		
	}
	
	
	/**
	 * <p>
	 * campaignExcelReport()
	 * </p>
	 * method to generate the Excel Sheet report of campaign Dashboard from database
	 * 
	 * @return
	 * @throws Exception
	 * @author Deepak Vishwakarma
	 * @param request
	 *            ,response
	 */
	public String campaignExcelReport() throws Exception {
		campaignServiceInf.campaignExcelReport(request,response);
		return NONE;
	}
	

	public String execute() throws Exception {
		try {
			campaignServiceInf = new CampaignServiceImpl();
			campaignDetailsList = campaignServiceInf.getCampaignDetailsList();
			return SUCCESS;
		} catch (Exception exception) {
			logger.error("Fail while get campaign details list");
			return ERROR;
		}
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

	public String addCampaignDetails() throws Exception {
		campaignServiceInf = new CampaignServiceImpl();
		CustomerSessionUser customerSessionUser = LoginUtil
				.getCurrentCustomerUser();
		String message = campaignServiceInf.registerCampaignDetail(campaignVO);
		/**
		 * TARGET_SUCCESS; TARGET_FAILURE
		 */
		if (OMIConstants.TARGET_SUCCESS.equalsIgnoreCase(message)) {
			logger.info("Successfully Insert Campaign Details!");
			addActionMessage("Successfully Insert Campaign Details!");
			return SUCCESS;

		} else if (OMIConstants.TARGET_FAILURE.equalsIgnoreCase(message)) {

			logger.info("Error:while  Insert Campaign Details!");
			addActionError("Error:while  Insert Campaign Details!");
			return INPUT;
		}

		return NONE;
	}

	/**
	 * <p>
	 * <code>viewCampaignDetails()</code> method is use to view the campaign
	 * details into view campaign page
	 * </p>
	 * 
	 * @return
	 * @throws Exception
	 */
	public String viewCampaignDetails() throws Exception {
		try {
			int campaignId = Integer.parseInt(request.getParameter("command"));
			LoginUtil.setProcessUserId(campaignId);
			this.campaignVO = campaignServiceInf.viewCampaignInfo(campaignVO,
					campaignId);
			return SUCCESS;
		} catch (Exception exception) {
			logger.error("Fail while get view campaign details.");
			return ERROR;
		}
	}

	/**
	 * <p>
	 * <code>viewCampaignDetails()</code> method is use to view the campaign
	 * details into view campaign page
	 * </p>
	 * 
	 * @return
	 * @throws Exception
	 */
	public String selectCampaignDetails() throws Exception {
		try {
			int campaignId = Integer.parseInt(request.getParameter("command"));
			LoginUtil.setProcessUserId(campaignId);
			this.campaignVO = campaignServiceInf.selectCampaignInfo(campaignVO,
					campaignId);
			return SUCCESS;
		} catch (Exception exception) {
			logger.error("Fail while get select campaign details.");
			return ERROR;
		}
	}

	/**
	 * <p>
	 * <code>updateCampaignDetails()</code> method is use to update Campaign
	 * information into database
	 * </p>
	 * 
	 * @return SUCCESS
	 * @throws Exception
	 */
	public String updateCampaignDetails() throws Exception {
		campaignServiceInf = new CampaignServiceImpl();
		int campaignId = LoginUtil.getProcessUserId();
		String message = campaignServiceInf.updateCampaignInfo(campaignVO,
				campaignId);

		if (OMIConstants.TARGET_SUCCESS.equalsIgnoreCase(message)) {

			logger.info("Successfully Updated Campaign Information!");
			addActionMessage("Successfully Updated Campaign Information!");
			return SUCCESS;

		} else if (OMIConstants.TARGET_FAILURE.equalsIgnoreCase(message)) {

			logger.info("Error:while  Updating Campaign Information!");
			addActionError("Error:while  Updating Campaign Information!");
			return INPUT;
		}

		return NONE;
	}

	/**
	 * <p>
	 * <code>deleteCampaignDetails()</code> method is use to remove the campaign
	 * details into databaes.
	 * </p>
	 * 
	 * @return
	 * @throws Exception
	 */
	public String deleteCampaignDetails() throws Exception {
		// Creating the EmployerServiceImpl object
		try {
			campaignServiceInf = new CampaignServiceImpl();
			int campaignId = Integer.parseInt(request.getParameter("command"));
			campaignServiceInf.removeCampaignDetail(campaignId);
			return SUCCESS;
		} catch (Exception exception) {
			logger.error("ERROR:Erroe while deleting campaign details from database.");
			return ERROR;
		}
	}
	
	
	/**
	 * <p>
	 * <code>noteDetailsGrid()</code> method is use to retrive the note details
	 * into note dashboard page
	 * </p>
	 * 
	 * @return
	 * @throws Exception
	 */
	
	public String campaignDetailsGrid() throws Exception {

		campaignServiceInf = new CampaignServiceImpl();
		this.campaignDetailsList = campaignServiceInf.retrivecampaignDetailsGrid(campaignVO);
		System.out.println(campaignDetailsList);
		if (campaignDetailsList == null) {
			logger.error("Error:While getting note details as per advance search.");
			addActionError("No records found.");
			return ERROR;
		} else {
			logger.info("Records found successfully.");
			return SUCCESS;
		}

	}
	

	/**
	 * <p>
	 * campaigndPrintPDF()
	 * </p>
	 * method to generate the pdf report of campaign details from database
	 * 
	 * @return
	 * @throws Exception
	 */
	public String campaigndPrintPDF() throws Exception {
		int campaignId = LoginUtil.getProcessUserId();
		campaignServiceInf.campaignPDF(request, response, campaignId);
		return null;
	}

	@Override
	public CampaignVO getModel() {

		return campaignVO;
	}

	public void setServletResponse(HttpServletResponse response) {
		this.response = response;

	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;

	}

	/**
	 * @return the logger
	 */
	public static Logger getLogger() {
		return logger;
	}

	/**
	 * @return the campaignVO
	 */
	public CampaignVO getCampaignVO() {
		return campaignVO;
	}

	/**
	 * @param campaignVO
	 *            the campaignVO to set
	 */
	public void setCampaignVO(CampaignVO campaignVO) {
		this.campaignVO = campaignVO;
	}

	/**
	 * @return the response
	 */
	public HttpServletResponse getResponse() {
		return response;
	}

	/**
	 * @param response
	 *            the response to set
	 */
	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	/**
	 * @return the request
	 */
	public HttpServletRequest getRequest() {
		return request;
	}

	/**
	 * @param request
	 *            the request to set
	 */
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	/**
	 * @return the result
	 */
	public String getResult() {
		return result;
	}

	/**
	 * @param result
	 *            the result to set
	 */
	public void setResult(String result) {
		this.result = result;
	}
	

	/**
	 * @return the expectedRevenueList
	 */
	public HashMap<String, String> getExpectedRevenueList() {
		return expectedRevenueList;
	}

	/**
	 * @param expectedRevenueList the expectedRevenueList to set
	 */
	public void setExpectedRevenueList(HashMap<String, String> expectedRevenueList) {
		this.expectedRevenueList = expectedRevenueList;
	}

	/**
	 * @return the expectedClosingDateList
	 */
	public HashMap<String, String> getExpectedClosingDateList() {
		return expectedClosingDateList;
	}

	/**
	 * @param expectedClosingDateList the expectedClosingDateList to set
	 */
	public void setExpectedClosingDateList(
			HashMap<String, String> expectedClosingDateList) {
		this.expectedClosingDateList = expectedClosingDateList;
	}

	/**
	 * @return the campaignTypeList
	 */
	public Map<Integer, String> getCampaignTypeList() {
		return campaignTypeList;
	}

	/**
	 * @param campaignTypeList
	 *            the campaignTypeList to set
	 */
	public void setCampaignTypeList(Map<Integer, String> campaignTypeList) {
		this.campaignTypeList = campaignTypeList;
	}

	/**
	 * @return the campaignStatusList
	 */
	public HashMap<Integer, String> getCampaignStatusList() {
		return campaignStatusList;
	}

	
	/**
	 * @return the advanceSearchList
	 */
	public HashMap<Integer, String> getAdvanceSearchList() {
		return advanceSearchList;
	}

	/**
	 * @param advanceSearchList the advanceSearchList to set
	 */
	public void setAdvanceSearchList(HashMap<Integer, String> advanceSearchList) {
		this.advanceSearchList = advanceSearchList;
	}

	/**
	 * @return the campaignNameList
	 */
	public HashMap<String, String> getCampaignNameList() {
		return campaignNameList;
	}

	/**
	 * @param campaignNameList the campaignNameList to set
	 */
	public void setCampaignNameList(HashMap<String, String> campaignNameList) {
		this.campaignNameList = campaignNameList;
	}

	/**
	 * @param campaignStatusList
	 *            the campaignStatusList to set
	 */
	public void setCampaignStatusList(
			HashMap<Integer, String> campaignStatusList) {
		this.campaignStatusList = campaignStatusList;
	}

	/**
	 * @return the campaignExpectedResponseList
	 */
	public HashMap<Integer, String> getCampaignExpectedResponseList() {
		return campaignExpectedResponseList;
	}

	/**
	 * @param campaignExpectedResponseList
	 *            the campaignExpectedResponseList to set
	 */
	public void setCampaignExpectedResponseList(
			HashMap<Integer, String> campaignExpectedResponseList) {
		this.campaignExpectedResponseList = campaignExpectedResponseList;
	}

	/**
	 * @return the campaignOwnerList
	 */
	public Map<Integer, String> getCampaignOwnerList() {
		return campaignOwnerList;
	}

	/**
	 * @param campaignOwnerList
	 *            the campaignOwnerList to set
	 */
	public void setCampaignOwnerList(Map<Integer, String> campaignOwnerList) {
		this.campaignOwnerList = campaignOwnerList;
	}

	/**
	 * @return the campaignAssignedToList
	 */
	public Map<Integer, String> getCampaignAssignedToList() {
		return campaignAssignedToList;
	}

	/**
	 * @param campaignAssignedToList
	 *            the campaignAssignedToList to set
	 */
	public void setCampaignAssignedToList(
			Map<Integer, String> campaignAssignedToList) {
		this.campaignAssignedToList = campaignAssignedToList;
	}

	/**
	 * @return the campaignDetailsList
	 */
	public List<CampaignVO> getCampaignDetailsList() {
		return campaignDetailsList;
	}

	/**
	 * @param campaignDetailsList
	 *            the campaignDetailsList to set
	 */
	public void setCampaignDetailsList(List<CampaignVO> campaignDetailsList) {
		this.campaignDetailsList = campaignDetailsList;
	}

	/**
	 * @return the salutationList
	 */
	public Map<Integer, String> getSalutationList() {
		return salutationList;
	}

	/**
	 * @param salutationList
	 *            the salutationList to set
	 */
	public void setSalutationList(Map<Integer, String> salutationList) {
		this.salutationList = salutationList;
	}

}
