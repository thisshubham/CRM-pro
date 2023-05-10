package com.bst.ckt.action;

import java.io.PrintWriter;
import java.util.HashMap;
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
import com.bst.ckt.framework.user.CustomerSessionUser;
import com.bst.ckt.helper.CasesAdvanceSearch;
import com.bst.ckt.helper.CasesStatus;
import com.bst.ckt.helper.ListHelper;
import com.bst.ckt.helper.TicketPriority;
import com.bst.ckt.helper.VOMapperHelper;
import com.bst.ckt.service.ProductServiceImpl;
import com.bst.ckt.service.SupportServiceImpl;
import com.bst.ckt.service.SupportServiceInf;
import com.bst.ckt.vo.SupportCasesVO;
import com.bst.ckt.vo.SupportFaqVO;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class SupportCasesAction extends ActionSupport implements
		ModelDriven<SupportCasesVO>, ServletRequestAware, ServletResponseAware,SessionAware
		 {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Creating Logger object, logger object mapped with SupportCasesAction
	 * class for writing Loggers.
	 */
	private static final Logger logger = Logger
			.getLogger(SupportCasesAction.class);

	SupportCasesVO supportCasesVO = new SupportCasesVO();
	SupportServiceInf supportServiceInf = new SupportServiceImpl();
	
	HttpServletResponse response = null;
	HttpServletRequest request = (HttpServletRequest) ActionContext
			.getContext().get(ServletActionContext.HTTP_REQUEST);
	
	ListHelper listHelper = new ListHelper();
	Map<String, Object> session = null;
	private Map<Integer, String> casesStatusList = null;
	private Map<Integer, String> casesPriorityList = null;
	private Map<Integer, String> casesAssignedToList = null;
	private Map<Integer, String> casesTeamList = null;
	private Map<Integer, String> casesChannelList = null;
	private Map<Integer, String> casesImpactTypelList = null;
	private Map<Integer, String> casesImpactAreaList;
	private Map<Integer, String> casesResolutionTypeList;
	private Map<Integer, String> casesContactNameList = null;
	private Map<Integer, String> casesSlaNamelList = null;
	private HashMap<Integer, String> casesOrgnizationList = null;
	private Map<Integer, String> casesProductNameList = null;
	private Map<Integer, String> advanceSearchList;

	
	private List<SupportCasesVO> casesGridList=null;
	private List<SupportCasesVO> casesAdvanceGridList=null;
	private List<SupportFaqVO> productNameGrid = null;
	private List<SupportCasesVO> contactNameGrid;
	private List<SupportCasesVO> casesOrganizationNameGrid;
	
	SupportDaoInf supportDaoInf=new SupportDaoImpl();
	private HashMap<String, String> caseTitleList;
	public SupportCasesAction() throws Exception {
		//this.casesGridList = supportServiceInf.showCasesInfoGrid();
		casesStatusList = CasesStatus.getModifiedCASESStatusList();
		casesPriorityList = TicketPriority.getModifiedTicketPriorityList();
		casesAssignedToList = listHelper.ticketOwnerList();
		casesTeamList = listHelper.casesTeamList();
		casesChannelList = listHelper.casesChannelList();
		casesImpactTypelList = listHelper.casesImpactTypelList();
		casesImpactAreaList = listHelper.casesImpactAreaList();
		casesResolutionTypeList = listHelper.casesResolutionTypeList();
		casesContactNameList = listHelper.casesContactNameList();
		casesSlaNamelList = listHelper.casesSlaNamelList();
		casesOrgnizationList = listHelper.casesOrgnizationList();
		casesProductNameList = listHelper.casesProductNameList();
		advanceSearchList = CasesAdvanceSearch.getCasesAdvanceSearchList();
		
		
          productNameGrid = supportServiceInf.showProductName();
		 
          casesProductNameList = listHelper.casesProductNameList();
          
          contactNameGrid=supportServiceInf.showContactName();
		
          casesOrganizationNameGrid=supportServiceInf.showOrganizationName();
          caseTitleList=supportDaoInf.getCaseTitleList();
        
         
	}
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * <p>
	 * <code>addCasesContactName()</code> this method design to add contact name into the
	 * database.
	 * </p>
	 * 
	 * @return SUCCESS
	 * @throws Exception
	 */
	public String addCasesOrganizationName() throws OMIApplicationException {
		
		
		String message = null;

		message = supportServiceInf.addCasesOrganizationName(supportCasesVO);

		/**
		 * RESULT_SUCCESS TARGET_CONTACT_NAME_ALREADY_INSERTED
		 * */
		if (OMIConstants.TARGET_SUCCESS.equalsIgnoreCase(message)) {
			casesOrganizationNameGrid=supportServiceInf.showOrganizationName();
			casesOrgnizationList = listHelper.casesOrgnizationList();
			logger.info("Organization Name inserted successfully.");
			addActionMessage("Organization Name  inserted successfully.");
			return SUCCESS;
		} else if (OMIConstants.TARGET_LEAD_TITLE_ALREADY_EXIST
				.equalsIgnoreCase(message)) {
			logger.info("Error: Organization Name already exists!");
			addActionError("Organization Name already exists.");
			return INPUT;
		}
		return NONE;
	}
	

	/**
	 * <p>
	 * <code>addCasesContactName()</code> this method design to add ccontact name into the
	 * database.
	 * </p>
	 * 
	 * @return SUCCESS
	 * @throws Exception
	 */
	public String addCasesContactName() throws OMIApplicationException {
		
		
		String message = null;

		message = supportServiceInf.addCasesContactName(supportCasesVO);

		/**
		 * RESULT_SUCCESS TARGET_CONTACT_NAME_ALREADY_INSERTED
		 * */
		if (OMIConstants.TARGET_SUCCESS.equalsIgnoreCase(message)) {
			setContactNameGrid(supportServiceInf.showContactName());
			casesContactNameList = listHelper.casesContactNameList();
			logger.info("Contact Name inserted successfully.");
			addActionMessage("Contact Name Name inserted successfully.");
			return SUCCESS;
		} else if (OMIConstants.TARGET_LEAD_TITLE_ALREADY_EXIST
				.equalsIgnoreCase(message)) {
			logger.info("Error:Contact Name already exists!");
			addActionError("Contact Name already exists.");
			return INPUT;
		}
		return NONE;
	}
	
	
	
	/**
	 * <p>
	 * <code>addProductName()</code> this method design to add product name into the
	 * database.
	 * </p>
	 * 
	 * @return SUCCESS
	 * @throws Exception
	 */
	public String addCasesProductName() throws OMIApplicationException {
		//supportCasesVO=new SupportCasesVO();
		
		String message = null;

		message = supportServiceInf.addCasesProductName(supportCasesVO);

		/**
		 * RESULT_SUCCESS TARGET_LEAD_TITLE_ALREADY_INSERTED
		 * */
		if (OMIConstants.TARGET_SUCCESS.equalsIgnoreCase(message)) {
			productNameGrid = supportServiceInf.showProductName();
			casesProductNameList = listHelper.casesProductNameList();
			logger.info("Product Name inserted successfully.");
			addActionMessage("Product Name inserted successfully.");
			return SUCCESS;
		} else if (OMIConstants.TARGET_LEAD_TITLE_ALREADY_EXIST
				.equalsIgnoreCase(message)) {
			logger.info("Error:Product Name already exists!");
			addActionError("Product Name already exists.");
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
	public String isProductNameExist() throws Exception {

		try {

			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
			PrintWriter printWriter = response.getWriter();

			if (supportDaoInf.isProductNameExist(request.getParameter("productName")) == 1) {
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
	 * <code>addNewCases</code>Method will Register data from TAB_SUPPORT_CASES
	 * </p>
	 * 
	 * @return
	 * @throws OMIApplicationException
	 * @param supportCasesVO
	 */

	public String addNewCases() throws Exception {
		supportServiceInf = new SupportServiceImpl();
		
		String message = supportServiceInf.registerCases(supportCasesVO);
		/**
		 * TARGET_SUCCESS; TARGET_FAILURE
		 */
		if (OMIConstants.TARGET_SUCCESS.equalsIgnoreCase(message)) {
			logger.info("Successfully Insert Cases!");
			addActionMessage("Successfully Insert Cases!");
			return SUCCESS;

		} else if (OMIConstants.TARGET_FAILURE.equalsIgnoreCase(message)) {

			logger.info("Error:while  Insert Cases!");
			addActionError("Error:while  Insert Cases!");
			return ERROR;
		}

		return NONE;
	}

	/**
	 * <p>
	 * <code>showCasesInfoGrid</code>Method will fetch data from
	 * TAB_SUPPORT_CASES
	 * </p>
	 * List<SupportCasesVO> casesGridList
	 * 
	 * @return casesGridList
	 * @throws OMIApplicationException
	 * 
	 */

	public String execute() throws OMIApplicationException {

		CustomerSessionUser customerSessionUser = LoginUtil
				.getCurrentCustomerUser();
		supportCasesVO.setCreatedBy(customerSessionUser.getCustomerId());

		 
		supportServiceInf=new SupportServiceImpl();
		this.casesGridList= supportServiceInf.casesDetailsGrid(supportCasesVO);
		
		if (casesGridList == null) {
			logger.error("Error: While getting Cases details as per advance search.");
			addActionError("No records found.");
			return ERROR;					
		} else {
			logger.info("Records found successfully.");
			return SUCCESS;
		}

	}

	/**
	 * <p>
	 * <code>casesDetailsGrid</code>Method will fetch data from TAB_SUPPORT_FAQ
	 * </p>
	 * List<SupportCasesVO> casesGridList
	 * 
	 * @return casesGridList
	 * @throws OMIApplicationException
	 * 
	 */

	/*
	 * public String casesDetailsGrid() throws Exception {
	 * 
	 * 
	 * CustomerSessionUser customerSessionUser = LoginUtil
	 * supportCasesVO.getCurrentCustomerUser();
	 * .setCreatedBy(customerSessionUser.getCustomerId());
	 * 
	 * // Creating the SupportServiceImpl object supportServiceInf = new
	 * supportServiceInf = new SupportServiceImpl(); this.casesGridList =
	 * supportServiceInf.casesDetailsGrid(supportCasesVO); if (casesGridList ==
	 * null) {
	 * logger.error("Error:While getting Cases details as per advance search.");
	 * addActionError("No records found."); return ERROR; } else {
	 * logger.info("Records found successfully."); return SUCCESS; }
	 * 
	 * }
	 */
	/**
	 * <p>
	 * <code>viewCasesInfo()</code> method is use to view the cases details into
	 * view cases page
	 * </p>
	 * 
	 * @return
	 * @throws Exception
	 */
	public String viewCasesInfo() throws Exception {
		/*
		 * CustomerSessionUser customerSessionUser = LoginUtil
		 * .getCurrentCustomerUser();
		 * supportCasesVO.setCreatedBy(customerSessionUser.getCustomerId());
		 */
		// Creating the SupportServiceImpl object
		supportServiceInf = new SupportServiceImpl();
		int casesId = Integer.parseInt(request.getParameter("command"));
		this.supportCasesVO = VOMapperHelper.getSupportCasesVOFromCases(
				supportCasesVO, supportServiceInf.viewCasesInfo(casesId));
		return SUCCESS;
	}

	/**
	 * <p>
	 * <code>editCasesInfo()</code> method is use to edit the cases details
	 * based casesId
	 * </p>
	 * 
	 * @return
	 * @throws Exception
	 */
	public String editCasesInfo() throws Exception {
		/*
		 * CustomerSessionUser customerSessionUser = LoginUtil
		 * .getCurrentCustomerUser();
		 * supportCasesVO.setCreatedBy(customerSessionUser.getCustomerId());
		 */
		int casesId = Integer.parseInt(request.getParameter("command"));
		LoginUtil.setProcessUserId(casesId);
		// Creating the SupportServiceImpl object
		supportServiceInf = new SupportServiceImpl();
		this.supportCasesVO = VOMapperHelper.getSupportCasesVOFromCases(
				supportCasesVO, supportServiceInf.editCasesInfo(casesId));
		return SUCCESS;
	}

	/**
	 * <p>
	 * <code>updateCasesInfo()</code> method is use to update the cases details
	 * based casesId
	 * </p>
	 * 
	 * @return
	 * @throws Exception
	 */
	public String updateCasesInfo() throws Exception {
		/*
		 * CustomerSessionUser customerSessionUser = LoginUtil
		 * .getCurrentCustomerUser();
		 * supportCasesVO.setCreatedBy(customerSessionUser.getCustomerId());
		 */
		// Creating the SupportServiceImpl object
		supportServiceInf = new SupportServiceImpl();
		int casesId = LoginUtil.getProcessUserId();
		String message = supportServiceInf.updateCasesInfo(supportCasesVO,
				casesId);
		if (OMIConstants.TARGET_SUCCESS.equalsIgnoreCase(message)) {
			logger.info("Successfully Updating Cases Information!");
			addActionMessage("Successfully Updating Cases Information!");
			return SUCCESS;

		} else if (OMIConstants.TARGET_FAILURE.equalsIgnoreCase(message)) {

			logger.info("Error:while  Updating Cases Information!");
			addActionError("Error:while  Updating Cases Information!");
			return ERROR;
		}

		return NONE;
	}

	/**
	 * <p>
	 * <code>deleteSupportCasesDetails()</code> method is use to delete the
	 * Cases details based casesId
	 * </p>
	 * 
	 * @return
	 * @throws Exception
	 */
	public String deleteSupportCasesDetails() throws OMIApplicationException {
		// Creating the SupportServiceImpl object
		
		int casesId = Integer.parseInt(request.getParameter("command"));
		supportServiceInf.removeSupportCasesDetails(casesId);
		
		this.casesGridList = supportServiceInf.showCasesInfoGrid();
		return SUCCESS;
	}

	/**
	 * <p>
	 * <code>nextViewCases()</code> method is use to view the Cases details into
	 * view Cases page
	 * </p>
	 * 
	 * @return
	 * @throws Exception
	 */
	public String nextViewCases() throws Exception {
		supportServiceInf = new SupportServiceImpl();
		int casesId = Integer.parseInt(request.getParameter("command"));
		
		this.supportCasesVO = VOMapperHelper
				.getSupportCasesVOFromCases(supportCasesVO,
						supportServiceInf.viewNextCasesDetails(casesId));

		if (supportCasesVO.getCasesId() != 0) {
			logger.info("Cases details found successfully for Cases Id  "
					+ supportCasesVO.getCasesId());
			addActionMessage("Cases details found successfully for Cases Id "
					+ supportCasesVO.getCasesId());
			return SUCCESS;
		} else {
			supportCasesVO.setCasesId(LoginUtil.getProcessUserId());
			logger.error("Cases details not found for Cases Id  "
					+ supportCasesVO.getCasesId());
			addActionError("Cases details not found for Cases Id "
					+ supportCasesVO.getCasesId());
			return ERROR;

		}
	}

	/**
	 * <p>
	 * <code>editNextCases()</code> method is use to populate next Cases details
	 * into edit Cases page
	 * </p>
	 * 
	 * @return
	 * @throws Exception
	 */
	public String editNextCases() throws Exception {
		int casesId = LoginUtil.getProcessUserId();
		supportServiceInf = new SupportServiceImpl();
		this.supportCasesVO = VOMapperHelper
				.getSupportCasesVOFromCases(supportCasesVO,
						supportServiceInf.editNextCasesDetails(casesId));
		if (supportCasesVO.getCasesId() != 0) {
			logger.info("Cases details found successfully for Cases Id  "
					+ supportCasesVO.getCasesId());
			addActionMessage("Cases details found successfully for Cases Id "
					+ supportCasesVO.getCasesId());
			return SUCCESS;
		} else {
			supportCasesVO.setCasesId(LoginUtil.getProcessUserId());
			logger.error("Cases details not found for Cases Id  "
					+ supportCasesVO.getCasesId());
			addActionError("Cases details not found for Cases Id "
					+ supportCasesVO.getCasesId());
			return ERROR;

		}
	}

	/**
	 * <p>
	 * <code>previousViewCases()</code> method is use to view the Cases details
	 * into view Cases page
	 * </p>
	 * 
	 * @return
	 * @throws Exception
	 */
	public String previousViewCases() throws Exception {
		int casesId = LoginUtil.getProcessUserId();
		SupportDaoInf supportDaoInf = new SupportDaoImpl();
		supportServiceInf = new SupportServiceImpl();
		this.supportCasesVO = VOMapperHelper.getSupportCasesVOFromCases(
				supportCasesVO,
				supportServiceInf.viewPreviousCasesDetails(casesId));

		if (supportCasesVO.getCasesId() != 0) {
			logger.info("Cases details found successfully for Cases Id  "
					+ supportCasesVO.getCasesId());
			addActionMessage("Cases details found successfully for Cases Id "
					+ supportCasesVO.getCasesId());
			return SUCCESS;
		} else if (LoginUtil.getProcessUserId() == -1) {
			LoginUtil.setProcessUserId(supportDaoInf.getCasesLastRecord() + 1);
			logger.error("Cases details not found");
			addActionError("Cases details not found");
			return ERROR;
		} else {
			supportCasesVO.setCasesId(LoginUtil.getProcessUserId());
			logger.error("Cases details not found for Cases Id  "
					+ supportCasesVO.getCasesId());
			addActionError("Cases details not found for Cases Id "
					+ supportCasesVO.getCasesId());
			return ERROR;

		}

	}

	/**
	 * <p>
	 * <code>previousEditCases()</code> method is use to view the Cases details
	 * into edit Cases page
	 * </p>
	 * 
	 * @return
	 * @throws Exception
	 */
	public String previousEditCases() throws Exception {
		int casesId = LoginUtil.getProcessUserId();
		SupportDaoInf supportDaoInf = new SupportDaoImpl();
		supportServiceInf = new SupportServiceImpl();
		this.supportCasesVO = VOMapperHelper.getSupportCasesVOFromCases(
				supportCasesVO,
				supportServiceInf.editPreviousCasesDetails(casesId));

		if (supportCasesVO.getCasesId() != 0) {
			logger.info("Cases details found successfully for Cases Id  "
					+ supportCasesVO.getCasesId());
			addActionMessage("Cases details found successfully for Cases Id "
					+ supportCasesVO.getCasesId());
			return SUCCESS;
		} else if (LoginUtil.getProcessUserId() == -1) {
			LoginUtil.setProcessUserId(supportDaoInf.getCasesLastRecord() + 1);
			logger.error("Cases details not found");
			addActionError("Cases details not found");
			return ERROR;
		} else {
			supportCasesVO.setCasesId(LoginUtil.getProcessUserId());
			logger.error("Cases details not found for Cases Id  "
					+ supportCasesVO.getCasesId());
			addActionError("Cases details not found for Cases Id "
					+ supportCasesVO.getCasesId());
			return ERROR;

		}

	}
	
	
	/**
	 * <p>
	 * casesExcelReport()
	 * </p>
	 * method to generate the Excel Sheet report of Support Cases Dashboard from database
	 * 
	 * @return
	 * @throws Exception
	 * @author Roshan Patel
	 * @param request
	 *            ,response
	 */
	public String casesExcelReport() throws Exception {
		
		supportServiceInf.supportCasesExcelReport(request, response);
		
		return NONE;
	}
	
	/**
	 * <p>
	 * productPrintPDF()
	 * </p>
	 * method to generate the pdf report of lead details from database
	 * 
	 * @return
	 * @throws Exception
	 */
	public String casesPrintPDF() throws Exception {
		int casesId = Integer.parseInt(request.getParameter("command"));
		supportServiceInf.casesPDF(request, response, casesId);
		return null;
	}
	

	public Map<Integer, String> getCasesPriorityList() {
		return casesPriorityList;
	}

	public void setCasesPriorityList(Map<Integer, String> casesPriorityList) {
		this.casesPriorityList = casesPriorityList;
	}

	public Map<Integer, String> getCasesAssignedToList() {
		return casesAssignedToList;
	}

	public void setCasesAssignedToList(Map<Integer, String> casesAssignedToList) {
		this.casesAssignedToList = casesAssignedToList;
	}

	public Map<Integer, String> getCasesTeamList() {
		return casesTeamList;
	}

	public void setCasesTeamList(Map<Integer, String> casesTeamList) {
		this.casesTeamList = casesTeamList;
	}

	public Map<Integer, String> getCasesChannelList() {
		return casesChannelList;
	}

	public void setCasesChannelList(Map<Integer, String> casesChannelList) {
		this.casesChannelList = casesChannelList;
	}

	public Map<Integer, String> getCasesImpactTypelList() {
		return casesImpactTypelList;
	}

	public void setCasesImpactTypelList(
			Map<Integer, String> casesImpactTypelList) {
		this.casesImpactTypelList = casesImpactTypelList;
	}

	/**
	 * @return the casesImpactAreaList
	 */
	public Map<Integer, String> getCasesImpactAreaList() {
		return casesImpactAreaList;
	}

	/**
	 * @param casesImpactAreaList
	 *            the casesImpactAreaList to set
	 */
	public void setCasesImpactAreaList(
			HashMap<Integer, String> casesImpactAreaList) {
		this.casesImpactAreaList = casesImpactAreaList;
	}

	public Map<Integer, String> getCasesResolutionTypeList() {
		return casesResolutionTypeList;
	}

	public void setCasesResolutionTypeList(
			Map<Integer, String> casesResolutionTypeList) {
		this.casesResolutionTypeList = casesResolutionTypeList;
	}

	public Map<Integer, String> getCasesStatusList() {
		return casesStatusList;
	}

	public void setCasesStatusList(Map<Integer, String> casesStatusList) {
		this.casesStatusList = casesStatusList;
	}

	public SupportCasesVO getSupportCasesVO() {
		return supportCasesVO;
	}

	public void setSupportCasesVO(SupportCasesVO supportCasesVO) {
		this.supportCasesVO = supportCasesVO;
	}

	

	

	public ListHelper getListHelper() {
		return listHelper;
	}

	public void setListHelper(ListHelper listHelper) {
		this.listHelper = listHelper;
	}

	

	

	public Map<String, Object> getSession() {
		return session;
	}

	

	@Override
	public SupportCasesVO getModel() {
		return supportCasesVO;
	}

	

	

	/**
	 * @return the casesGridList
	 */
	public List<SupportCasesVO> getCasesGridList() {
		return casesGridList;
	}

	/**
	 * @param casesGridList
	 *            the casesGridList to set
	 */
	public void setCasesGridList(List<SupportCasesVO> casesGridList) {
		this.casesGridList = casesGridList;
	}

	/**
	 * @return the casesContactNameList
	 */
	public Map<Integer, String> getCasesContactNameList() {
		return casesContactNameList;
	}

	/**
	 * @param casesContactNameList
	 *            the casesContactNameList to set
	 */
	public void setCasesContactNameList(
			Map<Integer, String> casesContactNameList) {
		this.casesContactNameList = casesContactNameList;
	}

	/**
	 * @return the casesSlaNamelList
	 */
	public Map<Integer, String> getCasesSlaNamelList() {
		return casesSlaNamelList;
	}

	/**
	 * @param casesSlaNamelList
	 *            the casesSlaNamelList to set
	 */
	public void setCasesSlaNamelList(Map<Integer, String> casesSlaNamelList) {
		this.casesSlaNamelList = casesSlaNamelList;
	}

	/**
	 * @return the casesOrgnizationList
	 */
	public HashMap<Integer, String> getCasesOrgnizationList() {
		return casesOrgnizationList;
	}

	/**
	 * @param casesOrgnizationList
	 *            the casesOrgnizationList to set
	 */
	public void setCasesOrgnizationList(
			HashMap<Integer, String> casesOrgnizationList) {
		this.casesOrgnizationList = casesOrgnizationList;
	}

	/**
	 * @return the casesProductNameList
	 */
	public Map<Integer, String> getCasesProductNameList() {
		return casesProductNameList;
	}

	/**
	 * @param casesProductNameList
	 *            the casesProductNameList to set
	 */
	public void setCasesProductNameList(
			Map<Integer, String> casesProductNameList) {
		this.casesProductNameList = casesProductNameList;
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

	/**
	 * @param casesImpactAreaList
	 *            the casesImpactAreaList to set
	 */
	public void setCasesImpactAreaList(Map<Integer, String> casesImpactAreaList) {
		this.casesImpactAreaList = casesImpactAreaList;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		
		this.session=session;
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		// TODO Auto-generated method stub
		this.response=response;
		
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		
		this.request=request;
		
	}

	/**
	 * @return the productNameGrid
	 */
	public List<SupportFaqVO> getProductNameGrid() {
		return productNameGrid;
	}

	/**
	 * @param productNameGrid the productNameGrid to set
	 */
	public void setProductNameGrid(List<SupportFaqVO> productNameGrid) {
		this.productNameGrid = productNameGrid;
	}




	/**
	 * @return the contactNameGrid
	 */
	public List<SupportCasesVO> getContactNameGrid() {
		return contactNameGrid;
	}




	/**
	 * @param contactNameGrid the contactNameGrid to set
	 */
	public void setContactNameGrid(List<SupportCasesVO> contactNameGrid) {
		this.contactNameGrid = contactNameGrid;
	}




	/**
	 * @return the casesOrganizationNameGrid
	 */
	public List<SupportCasesVO> getCasesOrganizationNameGrid() {
		return casesOrganizationNameGrid;
	}




	/**
	 * @param casesOrganizationNameGrid the casesOrganizationNameGrid to set
	 */
	public void setCasesOrganizationNameGrid(
			List<SupportCasesVO> casesOrganizationNameGrid) {
		this.casesOrganizationNameGrid = casesOrganizationNameGrid;
	}




	/**
	 * @return the casesAdvanceGridList
	 */
	public List<SupportCasesVO> getCasesAdvanceGridList() {
		return casesAdvanceGridList;
	}




	/**
	 * @param casesAdvanceGridList the casesAdvanceGridList to set
	 */
	public void setCasesAdvanceGridList(List<SupportCasesVO> casesAdvanceGridList) {
		this.casesAdvanceGridList = casesAdvanceGridList;
	}




	/**
	 * @return the caseTitleList
	 */
	public HashMap<String, String> getCaseTitleList() {
		return caseTitleList;
	}




	/**
	 * @param caseTitleList the caseTitleList to set
	 */
	public void setCaseTitleList(HashMap<String, String> caseTitleList) {
		this.caseTitleList = caseTitleList;
	}




	





	
	

	

	

}
