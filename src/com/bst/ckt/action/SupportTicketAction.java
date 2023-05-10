package com.bst.ckt.action;

import java.io.PrintWriter;
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
import com.bst.ckt.dao.SupportDaoImpl;
import com.bst.ckt.dao.SupportDaoInf;
import com.bst.ckt.exception.OMIApplicationException;
import com.bst.ckt.helper.ListHelper;
import com.bst.ckt.helper.TicketAdvanceSearch;
import com.bst.ckt.helper.TicketPriority;
import com.bst.ckt.helper.TicketStatus;
import com.bst.ckt.helper.VOMapperHelper;
import com.bst.ckt.service.SupportServiceImpl;
import com.bst.ckt.service.SupportServiceInf;
import com.bst.ckt.vo.TicketVO;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class SupportTicketAction extends ActionSupport implements
		ModelDriven<TicketVO>, SessionAware,ServletResponseAware,ServletRequestAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Creating Logger object, logger object mapped with SupportTicketAction
	 * class for writing Loggers.
	 */
	private static final Logger logger = Logger
			.getLogger(SupportTicketAction.class);

	TicketVO ticketVO = new TicketVO();
	SupportServiceInf supportServiceInf = new SupportServiceImpl();
	HttpServletResponse response = null;
	ListHelper listHelper = new ListHelper();
	SupportDaoInf supportDaoInf=new SupportDaoImpl();
	Map<String, Object> session = null;
	private Map<Integer, String> ticketCategoryList = null;
	private Map<Integer, String> ticketOwnerList = null;
	private Map<Integer, String> ticketStatusList = null;
	private Map<Integer, String> ticketPriorityList = null;
	private Map<Integer, String> ticketChannelList = null;
	private Map<Integer, String> ticketProductNameList = null;
	private Map<Integer, String> ticketContactNameList = null;
	private Map<Integer, String> advanceSearchList = null;
	private List<TicketVO> ticketGridList;

	
	private List<TicketVO> ticketProductNameGrid;
	private List<TicketVO>  ticketContactNameGrid;
	
	HttpServletRequest request = (HttpServletRequest) ActionContext
			.getContext().get(ServletActionContext.HTTP_REQUEST);

	public SupportTicketAction() throws Exception {
		ticketStatusList = TicketStatus.getModifiedTicketStatusList();
		ticketCategoryList = listHelper.ticketCategoryList();
		ticketOwnerList = listHelper.ticketOwnerList();
		ticketPriorityList = TicketPriority.getModifiedTicketPriorityList();
		ticketChannelList = listHelper.ticketChannelList();
		ticketProductNameList = listHelper.ticketProductNameList();
		ticketContactNameList = listHelper.ticketContactNameList();
		advanceSearchList = TicketAdvanceSearch.getTicketAdvanceSearchList();
		
		this.ticketProductNameGrid=supportServiceInf.showTicketProductName();
		this.ticketGridList = supportServiceInf.showTicketInfoGrid();
		
		ticketContactNameGrid=supportServiceInf.showTicketContactName();
	}

	
	/**
	 * <p>
	 * <code>addProductName()</code> this method design to add product name into
	 * the database.
	 * </p>
	 * 
	 * @return SUCCESS
	 * @throws Exception
	 */
	public String addTicketContactName() throws OMIApplicationException {

		String message = null;

		message = supportServiceInf.addTicketContactName(ticketVO);

		/**
		 * RESULT_SUCCESS TARGET_LEAD_TITLE_ALREADY_INSERTED
		 * */
		if (OMIConstants.TARGET_SUCCESS.equalsIgnoreCase(message)) {
			setTicketContactNameGrid(supportServiceInf.showTicketContactName());
			ticketContactNameList = listHelper.ticketProductNameList();
			logger.info("Contact name inserted successfully.");
			addActionMessage("Contact name inserted successfully.");
			return SUCCESS;
		} else if (OMIConstants.TARGET_LEAD_TITLE_ALREADY_EXIST
				.equalsIgnoreCase(message)) {
			logger.info("Error:Contact Name already exists!");
			addActionError("Contact Name already exists.");
			return INPUT;
		}
		return SUCCESS;
	}

	
	/**
	 * <p>
	 * <code>addProductName()</code> this method design to add product name into
	 * the database.
	 * </p>
	 * 
	 * @return SUCCESS
	 * @throws Exception
	 */
	public String addTicketProductName() throws OMIApplicationException {

		String message = null;

		message = supportServiceInf.addTicketProductName(ticketVO);

		/**
		 * RESULT_SUCCESS TARGET_LEAD_TITLE_ALREADY_INSERTED
		 * */
		if (OMIConstants.TARGET_SUCCESS.equalsIgnoreCase(message)) {
			ticketProductNameGrid = supportServiceInf.showTicketProductName();
			ticketProductNameList = listHelper.ticketProductNameList();
			logger.info("Product Name inserted successfully.");
			addActionMessage("Product Name inserted successfully.");
			return SUCCESS;
		} else if (OMIConstants.TARGET_LEAD_TITLE_ALREADY_EXIST
				.equalsIgnoreCase(message)) {
			logger.info("Error:Product Name already exists!");
			addActionError("Product Name already exists.");
			return INPUT;
		}
		return SUCCESS;
	}

	/**
	 * <p>
	 * <code>isProductNameExist()</code> method verify whether the leproduct
	 * name existed title already exists
	 * </p>
	 * 
	 * @return NONE
	 * @throws Exception
	 */
	public String isProductNameExist() throws Exception {

		try {

			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
			PrintWriter printWriter = response.getWriter();

			if (supportDaoInf.isProductNameExist(request
					.getParameter("productName")) == 1) {
				printWriter.print("Product already exists.");
			}

		} catch (Exception exception) {
			logger.error(
					"Error While verifying whether  the Product already exists ",
					exception);
		}
		return NONE;
	}
	
	
	/**
	 * <p>
	 * <code>addNewTicket</code>Method will Register data from
	 * TAB_SUPPORT_TICKET
	 * </p>
	 * 
	 * @return ticketVO
	 * @throws OMIApplicationException
	 * @param ticketVO
	 */

	public String addNewTicket() throws Exception {
		supportServiceInf = new SupportServiceImpl();
		/*
		 * CustomerSessionUser customerSessionUser = LoginUtil
		 * .getCurrentCustomerUser();
		 * ticketVO.setCreatedBy(customerSessionUser.getCustomerId());
		 */
		String message = supportServiceInf.registerTicket(ticketVO);
		/**
		 * TARGET_SUCCESS; TARGET_FAILURE
		 */
		if (OMIConstants.TARGET_SUCCESS.equalsIgnoreCase(message)) {
			logger.info("Successfully Insert Ticket!");
			addActionMessage("Successfully Insert Ticket!");
			return SUCCESS;

		} else if (OMIConstants.TARGET_FAILURE.equalsIgnoreCase(message)) {

			logger.info("Error:while  Insert Ticket!");
			addActionError("Error:while  Insert Ticket!");
			return ERROR;
		}

		return NONE;
	}

	/**
	 * <p>
	 * <code>ticketGridList</code>Method will fetch data from TAB_SUPPORT_TICKET
	 * </p>
	 * List<ticketVO> ticketGridList
	 * 
	 * @return ticketGridList
	 * @throws OMIApplicationException
	 * 
	 */

	public String execute() throws Exception {
		supportServiceInf = new SupportServiceImpl();
		// Creating the Value object for TicketVO
		
		this.ticketGridList = supportServiceInf.ticketDetailsGrid(ticketVO);
		if (ticketGridList == null) {
			logger.error("Error:While getting Faq details as per advance search.");
			addActionError("No records found.");
			return ERROR;
		} else {
			logger.info("Records found successfully.");
			return SUCCESS;
		}

	}

	/**
	 * <p>
	 * <code>TicketDetailsGrid</code>Method will fetch data from
	 * TAB_SUPPORT_TICKET
	 * </p>
	 * List<SupportFaqVO> ticketGridList
	 * 
	 * @return ticketGridList
	 * @throws OMIApplicationException
	 * @param
	 */

	/*public String TicketDetailsGrid() throws Exception {

		CustomerSessionUser customerSessionUser = LoginUtil
				.getCurrentCustomerUser();
		ticketVO.setCreatedBy(customerSessionUser.getCustomerId());

		// Creating the SupportServiceImpl object supportServiceInf = new
		supportServiceInf = new SupportServiceImpl();
		this.ticketGridList = supportServiceInf.ticketDetailsGrid(ticketVO);
		if (ticketGridList == null) {
			logger.error("Error:While getting Faq details as per advance search.");
			addActionError("No records found.");
			return ERROR;
		} else {
			logger.info("Records found successfully.");
			return SUCCESS;
		}

	}
*/
	/**
	 * <p>
	 * <code>viewTicketInfo()</code> method is use to view the ticket details
	 * into view ticket page
	 * </p>
	 * 
	 * @return
	 * @throws Exception
	 */
	public String viewTicketInfo() throws Exception {
		/*
		 * CustomerSessionUser customerSessionUser = LoginUtil
		 * .getCurrentCustomerUser();
		 * ticketVO.setCreatedBy(customerSessionUser.getCustomerId());
		 */
		// Creating the SupportServiceImpl object
		supportServiceInf = new SupportServiceImpl();
		int ticketId = Integer.parseInt(request.getParameter("command"));
		this.ticketVO = VOMapperHelper.getTicketVOFromTicket(ticketVO,
				supportServiceInf.viewTicketInfo(ticketId));
		return SUCCESS;
	}

	/**
	 * <p>
	 * <code>editTicketInfo()</code> method is use to edit the Ticket details
	 * based ticketId
	 * </p>
	 * 
	 * @return
	 * @throws Exception
	 */
	public String editTicketInfo() throws Exception {
		/*
		 * CustomerSessionUser customerSessionUser = LoginUtil
		 * .getCurrentCustomerUser();
		 * ticketVO.setCreatedBy(customerSessionUser.getCustomerId());
		 */
		int ticketId = Integer.parseInt(request.getParameter("command"));
		LoginUtil.setProcessUserId(ticketId);
		// Creating the SupportServiceImpl object
		supportServiceInf = new SupportServiceImpl();
		this.ticketVO = VOMapperHelper.getTicketVOFromTicket(ticketVO,
				supportServiceInf.editTicketInfo(ticketId));
		return SUCCESS;
	}

	/**
	 * <p>
	 * <code>updateTicketInfo()</code> method is use to update the Ticket
	 * details based ticketId
	 * </p>
	 * 
	 * @return
	 * @throws Exception
	 */
	public String updateTicketInfo() throws Exception {
		/*
		 * CustomerSessionUser customerSessionUser = LoginUtil
		 * .getCurrentCustomerUser();
		 * ticketVO.setCreatedBy(customerSessionUser.getCustomerId());
		 */
		// Creating the SupportServiceImpl object
		supportServiceInf = new SupportServiceImpl();
		int ticketId = LoginUtil.getProcessUserId();
		String message = supportServiceInf.updateTicketInfo(ticketVO, ticketId);
		if (OMIConstants.TARGET_SUCCESS.equalsIgnoreCase(message)) {
			logger.info("Successfully Updating Ticket Information!");
			addActionMessage("Successfully Updating Ticket Information!");
			return SUCCESS;

		} else if (OMIConstants.TARGET_FAILURE.equalsIgnoreCase(message)) {

			logger.info("Error:while  Updating Ticket Information!");
			addActionError("Error:while  Updating Ticket Information!");
			return ERROR;
		}

		return NONE;
	}

	/**
	 * <p>
	 * <code>deleteTicketDetails()</code> method is use to delete the Ticket
	 * details based ticketId
	 * </p>
	 * 
	 * @return
	 * @throws Exception
	 */
	public String deleteTicketDetails() throws Exception {
		// Creating the SupportServiceImpl object
		supportServiceInf = new SupportServiceImpl();
		int ticketId = Integer.parseInt(request.getParameter("command"));
		supportServiceInf.removeTicketDetails(ticketId);

		return SUCCESS;
	}

	/**
	 * <p>
	 * <code>nextViewTicket()</code> method is use to view the Ticket details
	 * into view Ticket page
	 * </p>
	 * 
	 * @return
	 * @throws Exception
	 */
	public String nextViewTicket() throws Exception {
		int ticketId = LoginUtil.getProcessUserId();
		supportServiceInf = new SupportServiceImpl();
		this.ticketVO = VOMapperHelper.getTicketVOFromTicket(ticketVO,
				supportServiceInf.viewNextTicketDetails(ticketId));

		if (ticketVO.getTicketId() != 0) {
			logger.info("Ticket details found successfully for Ticket Id  "
					+ ticketVO.getTicketId());
			addActionMessage("Ticket details found successfully for Ticket Id "
					+ ticketVO.getTicketId());
			return SUCCESS;
		} else {
			ticketVO.setTicketId(LoginUtil.getProcessUserId());
			logger.error("Ticket details not found for Ticket Id  "
					+ ticketVO.getTicketId());
			addActionError("Ticket details not found for Ticket Id "
					+ ticketVO.getTicketId());
			return ERROR;

		}
	}

	/**
	 * <p>
	 * <code>editNextTicket()</code> method is use to populate next Ticket
	 * details into edit Ticket page
	 * </p>
	 * 
	 * @return
	 * @throws Exception
	 */
	public String editNextTicket() throws Exception {
		int ticketId = LoginUtil.getProcessUserId();
		supportServiceInf = new SupportServiceImpl();
		this.ticketVO = VOMapperHelper.getTicketVOFromTicket(ticketVO,
				supportServiceInf.editNextTicketDetails(ticketId));
		if (ticketVO.getTicketId() != 0) {
			logger.info("Ticket details found successfully for Ticket Id  "
					+ ticketVO.getTicketId());
			addActionMessage("Ticket details found successfully for Ticket Id "
					+ ticketVO.getTicketId());
			return SUCCESS;
		} else {
			ticketVO.setTicketId(LoginUtil.getProcessUserId());
			logger.error("Ticket details not found for Ticket Id  "
					+ ticketVO.getTicketId());
			addActionError("Ticket details not found for Ticket Id "
					+ ticketVO.getTicketId());
			return ERROR;

		}
	}

	/**
	 * <p>
	 * <code>previousViewTicket()</code> method is use to view the Ticket
	 * details into view Ticket page
	 * </p>
	 * 
	 * @return
	 * @throws Exception
	 */
	public String previousViewTicket() throws Exception {
		int ticketId = LoginUtil.getProcessUserId();
		SupportDaoInf supportDaoInf = new SupportDaoImpl();
		supportServiceInf = new SupportServiceImpl();
		this.ticketVO = VOMapperHelper.getTicketVOFromTicket(ticketVO,
				supportServiceInf.viewPreviousTicketDetails(ticketId));

		if (ticketVO.getTicketId() != 0) {
			logger.info("Ticket details found successfully for Ticket Id  "
					+ ticketVO.getTicketId());
			addActionMessage("Ticket details found successfully for Ticket Id "
					+ ticketVO.getTicketId());
			return SUCCESS;
		} else if (LoginUtil.getProcessUserId() == -1) {
			LoginUtil.setProcessUserId(supportDaoInf.getTicketLastRecord() + 1);
			logger.error("Ticket details not found");
			addActionError("Ticket details not found");
			return ERROR;
		} else {
			ticketVO.setTicketId(LoginUtil.getProcessUserId());
			logger.error("Ticket details not found for Ticket Id  "
					+ ticketVO.getTicketId());
			addActionError("Ticket details not found for Ticket Id "
					+ ticketVO.getTicketId());
			return ERROR;

		}

	}

	/**
	 * <p>
	 * <code>previousEditTicket()</code> method is use to view the Ticket
	 * details into edit Ticket page
	 * </p>
	 * 
	 * @return
	 * @throws Exception
	 */
	public String previousEditTicket() throws Exception {
		int ticketId = LoginUtil.getProcessUserId();
		SupportDaoInf supportDaoInf = new SupportDaoImpl();
		supportServiceInf = new SupportServiceImpl();
		this.ticketVO = VOMapperHelper.getTicketVOFromTicket(ticketVO,
				supportServiceInf.editPreviousTicketDetails(ticketId));

		if (ticketVO.getTicketId() != 0) {
			logger.info("Ticket details found successfully for Ticket Id  "
					+ ticketVO.getTicketId());
			addActionMessage("Ticket details found successfully for Ticket Id "
					+ ticketVO.getTicketId());
			return SUCCESS;
		} else if (LoginUtil.getProcessUserId() == -1) {
			LoginUtil.setProcessUserId(supportDaoInf.getTicketLastRecord() + 1);
			logger.error("Ticket details not found");
			addActionError("Ticket details not found");
			return ERROR;
		} else {
			ticketVO.setTicketId(LoginUtil.getProcessUserId());
			logger.error("Ticket details not found for Ticket Id  "
					+ ticketVO.getTicketId());
			addActionError("Ticket details not found for Ticket Id "
					+ ticketVO.getTicketId());
			return ERROR;

		}

	}

	/**
	 * <p>
	 * excelReportTicket()
	 * </p>
	 * method to generate the Excel Sheet report of ticket Dashboard from database
	 * 
	 * @return
	 * @throws Exception
	 * @author Roshan Patel
	 * @param request
	 *            ,response
	 */
	public String excelReportTicket() throws Exception {
		supportServiceInf = new SupportServiceImpl();
		supportServiceInf.ticketExcelReport(request, response);
		return NONE;
	}
	
	
	/**
	 * <p>
	 * ticketPrintPDF()
	 * </p>
	 * method to generate the pdf report of ticket details from database
	 * 
	 * @return
	 * @throws Exception
	 */
	public String ticketsPrintPDF() throws Exception {
		supportServiceInf=new SupportServiceImpl();
		int ticketId =Integer.parseInt(request.getParameter("command"));
		
		supportServiceInf.ticketPDF(request, response, ticketId);
		return null;
	}
	
	@Override
	public TicketVO getModel() {
		return ticketVO;
	}

	/**
	 * @return the ticketVO
	 */
	public TicketVO getTicketVO() {
		return ticketVO;
	}

	/**
	 * @param ticketVO
	 *            the ticketVO to set
	 */
	public void setTicketVO(TicketVO ticketVO) {
		this.ticketVO = ticketVO;
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
	 * @return the ticketCategoryList
	 */
	public Map<Integer, String> getTicketCategoryList() {
		return ticketCategoryList;
	}

	/**
	 * @param ticketCategoryList
	 *            the ticketCategoryList to set
	 */
	public void setTicketCategoryList(Map<Integer, String> ticketCategoryList) {
		this.ticketCategoryList = ticketCategoryList;
	}

	/**
	 * @return the ticketOwnerList
	 */
	public Map<Integer, String> getTicketOwnerList() {
		return ticketOwnerList;
	}

	/**
	 * @param ticketOwnerList
	 *            the ticketOwnerList to set
	 */
	public void setTicketOwnerList(Map<Integer, String> ticketOwnerList) {
		this.ticketOwnerList = ticketOwnerList;
	}

	/**
	 * @return the ticketStatusList
	 */
	public Map<Integer, String> getTicketStatusList() {
		return ticketStatusList;
	}

	/**
	 * @param ticketStatusList
	 *            the ticketStatusList to set
	 */
	public void setTicketStatusList(Map<Integer, String> ticketStatusList) {
		this.ticketStatusList = ticketStatusList;
	}

	/**
	 * @return the ticketPriorityList
	 */
	public Map<Integer, String> getTicketPriorityList() {
		return ticketPriorityList;
	}

	/**
	 * @param ticketPriorityList
	 *            the ticketPriorityList to set
	 */
	public void setTicketPriorityList(Map<Integer, String> ticketPriorityList) {
		this.ticketPriorityList = ticketPriorityList;
	}

	/**
	 * @return the ticketChannelList
	 */
	public Map<Integer, String> getTicketChannelList() {
		return ticketChannelList;
	}

	/**
	 * @param ticketChannelList
	 *            the ticketChannelList to set
	 */
	public void setTicketChannelList(Map<Integer, String> ticketChannelList) {
		this.ticketChannelList = ticketChannelList;
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
	 * @return the ticketGridList
	 */
	public List<TicketVO> getTicketGridList() {
		return ticketGridList;
	}

	/**
	 * @param ticketGridList
	 *            the ticketGridList to set
	 */
	public void setTicketGridList(List<TicketVO> ticketGridList) {
		this.ticketGridList = ticketGridList;
	}

	/**
	 * @return the ticketProductNameList
	 */
	public Map<Integer, String> getTicketProductNameList() {
		return ticketProductNameList;
	}

	/**
	 * @param ticketProductNameList
	 *            the ticketProductNameList to set
	 */
	public void setTicketProductNameList(
			Map<Integer, String> ticketProductNameList) {
		this.ticketProductNameList = ticketProductNameList;
	}

	/**
	 * @return the ticketContactNameList
	 */
	public Map<Integer, String> getTicketContactNameList() {
		return ticketContactNameList;
	}

	/**
	 * @param ticketContactNameList
	 *            the ticketContactNameList to set
	 */
	public void setTicketContactNameList(
			Map<Integer, String> ticketContactNameList) {
		this.ticketContactNameList = ticketContactNameList;
	}

	/**
	 * @return the advanceSearchList
	 */
	public Map<Integer, String> getAdvanceSearchList() {
		return advanceSearchList;
	}

	/**
	 * @param advanceSearchList
	 *            the advanceSearchList to set
	 */
	public void setAdvanceSearchList(Map<Integer, String> advanceSearchList) {
		this.advanceSearchList = advanceSearchList;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request=request;
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		// TODO Auto-generated method stub
		this.response=response;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session=session;
	}

	/**
	 * @return the ticketProductNameGrid
	 */
	public List<TicketVO> getTicketProductNameGrid() {
		return ticketProductNameGrid;
	}

	/**
	 * @param ticketProductNameGrid the ticketProductNameGrid to set
	 */
	public void setTicketProductNameGrid(List<TicketVO> ticketProductNameGrid) {
		this.ticketProductNameGrid = ticketProductNameGrid;
	}


	/**
	 * @return the ticketContactNameGrid
	 */
	public List<TicketVO> getTicketContactNameGrid() {
		return ticketContactNameGrid;
	}


	/**
	 * @param ticketContactNameGrid the ticketContactNameGrid to set
	 */
	public void setTicketContactNameGrid(List<TicketVO> ticketContactNameGrid) {
		this.ticketContactNameGrid = ticketContactNameGrid;
	}

}
