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

import com.bst.ckt.common.LoginUtil;
import com.bst.ckt.common.OMIConstants;
import com.bst.ckt.dao.AssignmentDaoImpl;
import com.bst.ckt.framework.user.CustomerSessionUser;
import com.bst.ckt.helper.AssignmentAdvanceSearch;
import com.bst.ckt.helper.AssignmentStatus;
import com.bst.ckt.helper.LeadStatus;
import com.bst.ckt.helper.ListHelper;
import com.bst.ckt.helper.VOMapperHelper;
import com.bst.ckt.service.AssignmentServiceImpl;
import com.bst.ckt.service.AssignmentServiceInf;
import com.bst.ckt.service.LeadServiceImpl;
import com.bst.ckt.service.SupportServiceImpl;
import com.bst.ckt.vo.AssignmentVO;
import com.bst.ckt.vo.LeadVO;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @author Admin
 * 
 */
public class AssignmentAction extends ActionSupport implements
		ModelDriven<AssignmentVO> {

	private static final Logger logger = Logger
			.getLogger(AssignmentAction.class);

	private static final long serialVersionUID = -4778776910895994241L;
	AssignmentVO assignmentVO = new AssignmentVO();
	HttpServletResponse response = null;
	HttpServletRequest request = (HttpServletRequest) ActionContext
			.getContext().get(ServletActionContext.HTTP_REQUEST);
	ListHelper listHelper = new ListHelper();
	private Map<Integer, String> accountNameList;
	private Map<Integer, String> customerUserList;
	private Map<Integer, String> contactList;
	private Map<Integer, String> leadList;
	private Map<Integer, String> campaignList;
	private Map<Integer, String> leadSourceNameList;
	private Map<Integer, String> advanceSearchList;
	private HashMap<Integer, String> assignmentStatusList;
	AssignmentServiceInf assignmentServiceInf = new AssignmentServiceImpl();
	List<AssignmentVO> assignmentList;

	@Override
	public String execute() throws Exception {
		AssignmentServiceInf assignmentServiceInf = new AssignmentServiceImpl();
		this.assignmentList = assignmentServiceInf.fetchAssignmentList();
		return SUCCESS;
	}

	public AssignmentAction() throws Exception {

		setAccountNameList(listHelper.accountNameList());
		setCustomerUserList(listHelper.customerUserList());
		setContactList(listHelper.contactList());
		setLeadList(listHelper.leadList());
		setCampaignList(listHelper.campaignList());
		setLeadSourceNameList(listHelper.leadSourceNameList());
		setAdvanceSearchList(AssignmentAdvanceSearch.getAssignmentAdvanceSearchList());
		assignmentStatusList = AssignmentStatus.getAssignmentStatusList();
	}

	/**
	 * <p>
	 * insertDetail()
	 * </p>
	 * method is use to insert assignment details into database
	 * 
	 * @return SUCCESS
	 * @throws Exception
	 */
	public String insertDetail() throws Exception {
		AssignmentServiceInf assignmentServiceInf = new AssignmentServiceImpl();
		CustomerSessionUser customerSessionUser = LoginUtil
				.getCurrentCustomerUser();
		assignmentVO.setCreatedBy(customerSessionUser.getCustomerId());
		String message=assignmentServiceInf.insertDetails(assignmentVO);
		if (OMIConstants.TARGET_SUCCESS.equalsIgnoreCase(message)) {
			logger.info("Successfully Insert Assignment Details!");
			addActionMessage("Successfully Insert Assignment Details!");
			return SUCCESS;

		} else if (OMIConstants.TARGET_FAILURE.equalsIgnoreCase(message)) {

			logger.info("Error:while  Insert Assignment Details!");
			addActionError("Error:while  Insert Assignment Details!");
			return INPUT;
		}

		return NONE;
	}
	
	
	/**
	 * <p>
	 * excelReport()
	 * </p>
	 * method to generate the Excel Sheet report of Assignment Dashboard from database
	 * 
	 * @return
	 * @throws Exception
	 * @author Deepak Vishwakarma
	 * @param request
	 *            ,response
	 */
	public String assignmentexcelReportDetails() throws Exception {
		assignmentServiceInf.assignmentExcelReport(request, response);
		return NONE;
	}
	
	
	/**
	 * <p>
	 * assignmentPrintPDF()
	 * </p>
	 * method to generate the pdf report of assignment details from database
	 * 
	 * @return
	 * @throws Exception
	 */
	public String assignmentPrintPDF() throws Exception {
		int assignmentId =LoginUtil.getProcessUserId();
		LoginUtil.setProcessUserId(assignmentId);
		assignmentServiceInf.assignmentPDF(request, response, assignmentId);
		return null;
	}
	

	/**
	 * <p>
	 * <code>viewAssignment()</code> method is use to view the Assignment
	 * details into view Assignment page
	 * </p>
	 * 
	 * @return
	 * @throws Exception
	 */
	public String viewAssignment() throws Exception {
		AssignmentServiceInf assignmentServiceInf = new AssignmentServiceImpl();

		int assignmentId = Integer.parseInt(request.getParameter("command"));
		System.out.println("assignmentId $$$$$$$$$$$$$$$   " + assignmentId);
		LoginUtil.setProcessUserId(assignmentId);
		this.assignmentVO = VOMapperHelper
				.getAssignmentVOFromAssignment(assignmentVO,
						assignmentServiceInf.viewAssignment(assignmentId));

		return SUCCESS;
	}

	/**
	 * <p>
	 * <code>editAssignmentdetails()</code> method is use to edit the assignment
	 * details based on assignmentId
	 * </p>
	 * 
	 * @return
	 * @throws Exception
	 */
	public String editAssignmentdetails() throws Exception {

		CustomerSessionUser customerSessionUser = LoginUtil
				.getCurrentCustomerUser();
		assignmentVO.setCreatedBy(customerSessionUser.getCustomerId());

		int assignmentId = Integer.parseInt(request.getParameter("command"));
		LoginUtil.setProcessUserId(assignmentId);
		// Creating the SupportServiceImpl object
		assignmentServiceInf = new AssignmentServiceImpl();
		this.assignmentVO = VOMapperHelper.getAssignmentVOFromAssignment(
				assignmentVO,
				assignmentServiceInf.editAssignmentInfo(assignmentId));
		return SUCCESS;
	}

	/**
	 * <p>
	 * <code>()updateAssignment</code>this method is design to get assignment
	 * details for the update process.
	 * </p>
	 * 
	 * @return SUCCESS
	 * @throws Exception
	 */
	public String updateAssignment() throws Exception {
		assignmentServiceInf=new AssignmentServiceImpl(); 
		int assignmentId = LoginUtil.getProcessUserId();
		String message = assignmentServiceInf.updateAssignmentDetails(
				assignmentVO, assignmentId);
		if (OMIConstants.TARGET_SUCCESS.equalsIgnoreCase(message)) {
			logger.info("Successfully Updating Cases Information!");
			addActionMessage("Successfully Updating Assignment Information!");
			return SUCCESS;

		} else if (OMIConstants.TARGET_FAILURE.equalsIgnoreCase(message)) {

			logger.info("Error:while  Updating Assignment Information!");
			addActionError("Error:while  Updating Assignment Information!");
			return ERROR;
		}

		return NONE;
	}
	
	private List<AssignmentVO> assignmentDetailList = null;
	
	/**
	 * @return the assignmentDetailList
	 */
	public List<AssignmentVO> getAssignmentDetailList() {
		return assignmentDetailList;
	}

	/**
	 * @param assignmentDetailList the assignmentDetailList to set
	 */
	public void setAssignmentDetailList(List<AssignmentVO> assignmentDetailList) {
		this.assignmentDetailList = assignmentDetailList;
	}

	public String assignmentDetailsGrid() throws Exception {

		assignmentServiceInf = new AssignmentServiceImpl();
		this.assignmentList = assignmentServiceInf.retriveAssignmentDetailsGrid(assignmentVO);
		if (assignmentList == null) {
			logger.error("Error:While getting assignment details as per advance search.");
			addActionError("No records found.");
			return ERROR;
		} else {
			logger.info("Records found successfully.");
			return SUCCESS;
		}

	}

	@Override
	public AssignmentVO getModel() {
		// TODO Auto-generated method stub
		return assignmentVO;
	}

	/**
	 * @return the assignmentList
	 */
	public List<AssignmentVO> getAssignmentList() {
		return assignmentList;
	}

	/**
	 * @param assignmentList
	 *            the assignmentList to set
	 */
	public void setAssignmentList(List<AssignmentVO> assignmentList) {
		this.assignmentList = assignmentList;
	}

	public AssignmentVO getAssignmentVO() {
		return assignmentVO;
	}

	public void setAssignmentVO(AssignmentVO assignmentVO) {
		this.assignmentVO = assignmentVO;
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

	/**
	 * @return the accountNameList
	 */
	public Map<Integer, String> getAccountNameList() {
		return accountNameList;
	}

	/**
	 * @param accountNameList
	 *            the accountNameList to set
	 */
	public void setAccountNameList(Map<Integer, String> accountNameList) {
		this.accountNameList = accountNameList;
	}

	/**
	 * @return the customerUserList
	 */
	public Map<Integer, String> getCustomerUserList() {
		return customerUserList;
	}

	/**
	 * @param customerUserList
	 *            the customerUserList to set
	 */
	public void setCustomerUserList(Map<Integer, String> customerUserList) {
		this.customerUserList = customerUserList;
	}

	/**
	 * @return the contactList
	 */
	public Map<Integer, String> getContactList() {
		return contactList;
	}

	/**
	 * @param contactList
	 *            the contactList to set
	 */
	public void setContactList(Map<Integer, String> contactList) {
		this.contactList = contactList;
	}

	/**
	 * @return the leadList
	 */
	public Map<Integer, String> getLeadList() {
		return leadList;
	}

	/**
	 * @param leadList
	 *            the leadList to set
	 */
	public void setLeadList(Map<Integer, String> leadList) {
		this.leadList = leadList;
	}

	/**
	 * @return the campaignList
	 */
	public Map<Integer, String> getCampaignList() {
		return campaignList;
	}

	/**
	 * @param campaignList
	 *            the campaignList to set
	 */
	public void setCampaignList(Map<Integer, String> campaignList) {
		this.campaignList = campaignList;
	}

	/**
	 * @return the leadSourceNameList
	 */
	public Map<Integer, String> getLeadSourceNameList() {
		return leadSourceNameList;
	}

	/**
	 * @param leadSourceNameList
	 *            the leadSourceNameList to set
	 */
	public void setLeadSourceNameList(Map<Integer, String> leadSourceNameList) {
		this.leadSourceNameList = leadSourceNameList;
	}

	/**
	 * @return the advanceSearchList
	 */
	public Map<Integer, String> getAdvanceSearchList() {
		return advanceSearchList;
	}

	/**
	 * @param advanceSearchList the advanceSearchList to set
	 */
	public void setAdvanceSearchList(Map<Integer, String> advanceSearchList) {
		this.advanceSearchList = advanceSearchList;
	}

	/**
	 * @return the assignmentStatusList
	 */
	public HashMap<Integer, String> getAssignmentStatusList() {
		return assignmentStatusList;
	}

	/**
	 * @param assignmentStatusList the assignmentStatusList to set
	 */
	public void setAssignmentStatusList(HashMap<Integer, String> assignmentStatusList) {
		this.assignmentStatusList = assignmentStatusList;
	}

}
