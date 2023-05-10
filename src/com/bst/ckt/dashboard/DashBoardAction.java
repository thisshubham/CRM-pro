package com.bst.ckt.dashboard;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.bst.ckt.exception.OMIApplicationException;
import com.bst.ckt.helper.AnalyticProductModuleUtil;
import com.bst.ckt.helper.AnalyticVendorModuleUtil;
import com.bst.ckt.helper.AnalyticalAdvanceSearch;
import com.bst.ckt.helper.AnalyticalCampaignModuleUtil;
import com.bst.ckt.helper.AnalyticalCasesModuleUtil;
import com.bst.ckt.helper.AnalyticalExpensesModuleUtil;
import com.bst.ckt.helper.AnalyticalTicketModuleUtil;
import com.bst.ckt.helper.AnalyticsAccountModuleUtil;
import com.bst.ckt.helper.AnalyticsAssignmentModuleUtil;
import com.bst.ckt.helper.AnalyticsContact;
import com.bst.ckt.helper.AnalyticsDocumentModuleUtil;
import com.bst.ckt.helper.AnalyticsLeadModule;
import com.bst.ckt.helper.AnalyticsLeadModuleUtil;
import com.bst.ckt.helper.CountStatusUtil;
import com.bst.ckt.vo.LeadVO;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class DashBoardAction extends ActionSupport implements
		ModelDriven<Integer>, SessionAware, ServletRequestAware,
		ServletResponseAware {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	AnalyticsLeadModule analyticsLeadModule = new AnalyticsLeadModule();;
	CountStatusUtil countStatusUtil = null;
	DashBoardVo dashBoardVo = new DashBoardVo();

	private List<DashBoardVo> countStatusListdetails;
	private List<DashBoardVo> countStatusAccountdetails;
	private List<DashBoardVo> countStatusTicketDetails;
	private List<DashBoardVo> countStatusCasesDetails;
	private List<DashBoardVo> countStatusAssignment;
	private HashMap<Integer, String> analyticsadvancesearch;
	private HashMap<Integer, String> analyticsLeadBoard;
	private HashMap<Integer, String> analyticalContactBoard;
	private HashMap<Integer, String> analyticalAccountBoard;
	private HashMap<Integer, String> analyticalDocumentBoard;
	private HashMap<Integer, String> analyticalCampaignBoard;
	private HashMap<Integer, String> analyticalAssignmentBorad;
	private HashMap<Integer, String> analyticalProductBoard;
	private HashMap<Integer, String> analyticalVendorBoard;
	private HashMap<Integer, String> analyticalExpensesBoard;
	private HashMap<Integer, String> analyticalCasesBoard;
	private HashMap<Integer, String> analyticalTicketBoard;
	
	private List<LeadVO> countLeadCreatedBy;
	private List<LeadVO> countLeadByIndustry;

	private List<DashBoardVo> countLeadSourceGrid;

	public DashBoardAction() throws OMIApplicationException {
		countStatusUtil = new CountStatusUtil();
		this.countStatusListdetails = countStatusUtil.leadStatusDetails();

		this.countStatusAccountdetails = countStatusUtil.accountStatusDetails();
		this.countStatusTicketDetails = countStatusUtil.ticketSatusDetails();
		this.countStatusCasesDetails = countStatusUtil.casesStatusDetails();
		this.countStatusAssignment = countStatusUtil.assignmentStatusDetails();
		this.analyticsadvancesearch = AnalyticalAdvanceSearch
				.getAnalyticalAdvanceSearch();
		this.analyticsLeadBoard = AnalyticsLeadModuleUtil
				.getAnalyticalAdvanceSearch();
		this.analyticalContactBoard = AnalyticsContact.getAnalyticalContact();
		this.analyticalAccountBoard = AnalyticsAccountModuleUtil
				.getAnalyticalAccount();
		this.analyticalDocumentBoard = AnalyticsDocumentModuleUtil
				.getAnalyticalDocument();
		this.analyticalCampaignBoard = AnalyticalCampaignModuleUtil
				.getAnalyticalCampaign();
		this.analyticalAssignmentBorad = AnalyticsAssignmentModuleUtil
				.getAnalyticalAssignment();
		this.analyticalProductBoard = AnalyticProductModuleUtil
				.getAnalyticalProduct();
		this.analyticalVendorBoard = AnalyticVendorModuleUtil
				.getAnalyticalVendor();
		this.analyticalExpensesBoard = AnalyticalExpensesModuleUtil
				.getAnalyticalExpenses();
		this.analyticalCasesBoard = AnalyticalCasesModuleUtil
				.getAnalyticalCases();
		this.analyticalTicketBoard = AnalyticalTicketModuleUtil
				.getAnalyticalTicket();
		this.countLeadSourceGrid = analyticsLeadModule.getleadSourceDetail();
		this.countLeadCreatedBy=analyticsLeadModule.getLeadCreatedBy();
	    this.countLeadByIndustry=analyticsLeadModule.getLeadByIndustry();
	    System.out.println("****************************"+countLeadByIndustry);
	}

	public HashMap<Integer, String> getAnalyticalTicketBoard() {
		return analyticalTicketBoard;
	}

	public void setAnalyticalTicketBoard(
			HashMap<Integer, String> analyticalTicketBoard) {
		this.analyticalTicketBoard = analyticalTicketBoard;
	}

	public HashMap<Integer, String> getAnalyticalCasesBoard() {
		return analyticalCasesBoard;
	}

	public void setAnalyticalCasesBoard(
			HashMap<Integer, String> analyticalCasesBoard) {
		this.analyticalCasesBoard = analyticalCasesBoard;
	}

	public HashMap<Integer, String> getAnalyticalExpensesBoard() {
		return analyticalExpensesBoard;
	}

	public void setAnalyticalExpensesBoard(
			HashMap<Integer, String> analyticalExpensesBoard) {
		this.analyticalExpensesBoard = analyticalExpensesBoard;
	}

	public HashMap<Integer, String> getAnalyticalVendorBoard() {
		return analyticalVendorBoard;
	}

	public void setAnalyticalVendorBoard(
			HashMap<Integer, String> analyticalVendorBoard) {
		this.analyticalVendorBoard = analyticalVendorBoard;
	}

	public HashMap<Integer, String> getAnalyticalProductBoard() {
		return analyticalProductBoard;
	}

	public void setAnalyticalProductBoard(
			HashMap<Integer, String> analyticalProductBoard) {
		this.analyticalProductBoard = analyticalProductBoard;
	}

	public HashMap<Integer, String> getAnalyticalAssignmentBorad() {
		return analyticalAssignmentBorad;
	}

	public void setAnalyticalAssignmentBorad(
			HashMap<Integer, String> analyticalAssignmentBorad) {
		this.analyticalAssignmentBorad = analyticalAssignmentBorad;
	}

	public HashMap<Integer, String> getAnalyticalCampaignBoard() {
		return analyticalCampaignBoard;
	}

	public void setAnalyticalCampaignBoard(
			HashMap<Integer, String> analyticalCampaignBoard) {
		this.analyticalCampaignBoard = analyticalCampaignBoard;
	}

	public HashMap<Integer, String> getAnalyticsadvancesearch() {
		return analyticsadvancesearch;
	}

	public void setAnalyticsadvancesearch(
			HashMap<Integer, String> analyticsadvancesearch) {
		this.analyticsadvancesearch = analyticsadvancesearch;
	}

	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public Integer getModel() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<DashBoardVo> getCountStatusListdetails() {
		return countStatusListdetails;
	}

	public void setCountStatusListdetails(
			List<DashBoardVo> countStatusListdetails) {
		this.countStatusListdetails = countStatusListdetails;
	}

	public List<DashBoardVo> getCountStatusAccountdetails() {
		return countStatusAccountdetails;
	}

	public void setCountStatusAccountdetails(
			List<DashBoardVo> countStatusAccountdetails) {
		this.countStatusAccountdetails = countStatusAccountdetails;
	}

	public List<DashBoardVo> getCountStatusTicketDetails() {
		return countStatusTicketDetails;
	}

	public void setCountStatusTicketDetails(
			List<DashBoardVo> countStatusTicketDetails) {
		this.countStatusTicketDetails = countStatusTicketDetails;
	}

	public List<DashBoardVo> getCountStatusCasesDetails() {
		return countStatusCasesDetails;
	}

	public void setCountStatusCasesDetails(
			List<DashBoardVo> countStatusCasesDetails) {
		this.countStatusCasesDetails = countStatusCasesDetails;
	}

	public List<DashBoardVo> getCountStatusAssignment() {
		return countStatusAssignment;
	}

	public void setCountStatusAssignment(List<DashBoardVo> countStatusAssignment) {
		this.countStatusAssignment = countStatusAssignment;
	}

	public HashMap<Integer, String> getAnalyticsLeadBoard() {
		return analyticsLeadBoard;
	}

	public void setAnalyticsLeadBoard(
			HashMap<Integer, String> analyticsLeadBoard) {
		this.analyticsLeadBoard = analyticsLeadBoard;
	}

	public HashMap<Integer, String> getAnalyticalContactBoard() {
		return analyticalContactBoard;
	}

	public void setAnalyticalContactBoard(
			HashMap<Integer, String> analyticalContactBoard) {
		this.analyticalContactBoard = analyticalContactBoard;
	}

	public HashMap<Integer, String> getAnalyticalAccountBoard() {
		return analyticalAccountBoard;
	}

	public void setAnalyticalAccountBoard(
			HashMap<Integer, String> analyticalAccountBoard) {
		this.analyticalAccountBoard = analyticalAccountBoard;
	}

	public HashMap<Integer, String> getAnalyticalDocumentBoard() {
		return analyticalDocumentBoard;
	}

	public void setAnalyticalDocumentBoard(
			HashMap<Integer, String> analyticalDocumentBoard) {
		this.analyticalDocumentBoard = analyticalDocumentBoard;
	}

	/**
	 * @return the countLeadSourceGrid
	 */
	public List<DashBoardVo> getCountLeadSourceGrid() {
		return countLeadSourceGrid;
	}

	/**
	 * @param countLeadSourceGrid
	 *            the countLeadSourceGrid to set
	 */
	public void setCountLeadSourceGrid(List<DashBoardVo> countLeadSourceGrid) {
		this.countLeadSourceGrid = countLeadSourceGrid;
	}

	/**
	 * @return the countLeadCreatedBy
	 */
	public List<LeadVO> getCountLeadCreatedBy() {
		return countLeadCreatedBy;
	}

	/**
	 * @param countLeadCreatedBy the countLeadCreatedBy to set
	 */
	public void setCountLeadCreatedBy(List<LeadVO> countLeadCreatedBy) {
		this.countLeadCreatedBy = countLeadCreatedBy;
	}

	/**
	 * @return the countLeadByIndustry
	 */
	public List<LeadVO> getCountLeadByIndustry() {
		return countLeadByIndustry;
	}

	/**
	 * @param countLeadByIndustry the countLeadByIndustry to set
	 */
	public void setCountLeadByIndustry(List<LeadVO> countLeadByIndustry) {
		this.countLeadByIndustry = countLeadByIndustry;
	}

	
}
