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
import com.bst.ckt.dao.ExpensesMonthlyDaoImpl;
import com.bst.ckt.dao.ExpensesMonthlyDaoInf;
import com.bst.ckt.exception.OMIApplicationException;
import com.bst.ckt.framework.user.CustomerSessionUser;
import com.bst.ckt.framework.util.IDGenerator;
import com.bst.ckt.helper.ExpensesClaimStatus;
import com.bst.ckt.helper.ListHelper;
import com.bst.ckt.helper.VOMapperHelper;
import com.bst.ckt.service.ExpensesMonthlyServiceImpl;
import com.bst.ckt.service.ExpensesMonthlyServiceInf;
import com.bst.ckt.vo.ExpensesMonthlyVO;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @author pratik
 * 
 */

public class ExpensesMonthlyAction extends ActionSupport implements
		ModelDriven<ExpensesMonthlyVO>,ServletResponseAware,SessionAware{

	/**
	 * Creating Logger object, logger object mapped with ExpensesMonthlyAction1
	 * class for writing Loggers.
	 */
	private static final Logger logger = Logger
			.getLogger(ExpensesMonthlyAction.class);
	HttpServletResponse httpServletResponse=null;
	HttpServletResponse response = null;
	
	HttpServletRequest request =(HttpServletRequest)ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST );
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ExpensesMonthlyVO expensesMonthlyVO = new ExpensesMonthlyVO();
	ExpensesMonthlyServiceInf expensesMonthlyServiceInf = new ExpensesMonthlyServiceImpl();
	ExpensesMonthlyDaoInf expensesMonthlyDaoInf = new ExpensesMonthlyDaoImpl();
	ListHelper listHelper = new ListHelper();
	private List<ExpensesMonthlyVO> expensesMonthlyList = null;
	private List<ExpensesMonthlyVO> monthlyTravelListGrid = null;
	private List<ExpensesMonthlyVO> monthlyTravelList= null;
	private List<ExpensesMonthlyVO> monthlyOtherListGrid = null;
	private List<ExpensesMonthlyVO> monthlyOtherList= null;
	private Map<Integer, String> customerNameList;
	private Map<Integer, String> travelModeList;
	private List<ExpensesMonthlyVO> travelMonthlyDataList = null;
	private List<ExpensesMonthlyVO> travelOtherDataList = null;
	private List<ExpensesMonthlyVO> travelOtherDataListByMonthlyClaimId = null;
	private List<ExpensesMonthlyVO> travelMonthlyDataListByMonthlyClaimId = null;
	private HashMap<Integer, String> expensesClaimStatus;
	

	

	

	public ExpensesMonthlyAction() throws Exception {

		customerNameList = listHelper.customerNameList();
		travelModeList = listHelper.travelModeList();
		expensesMonthlyList = expensesMonthlyServiceInf.expensesMonthlyList();
		expensesClaimStatus = ExpensesClaimStatus.getExpensesClaimStatusList();
		//monthlyTravelListGrid = expensesMonthlyServiceInf.monthlyTravelList();
		//monthlyOtherListGrid = expensesMonthlyServiceInf.monthlyOtherList();

	}

	

	@Override
	public String execute() throws Exception {
		ExpensesMonthlyServiceInf expensesMonthlyServiceInf = new ExpensesMonthlyServiceImpl();
		this.expensesMonthlyList = expensesMonthlyServiceInf
				.expensesMonthlyList();
		//this.monthlyTravelListGrid = expensesMonthlyServiceInf
				//.monthlyTravelList();
		//this.monthlyOtherListGrid = expensesMonthlyServiceInf.monthlyOtherList();
		return SUCCESS;
	}

	
	/**
	 * <p>
	 * <code>insertDetail</code> method is use to insert monthly details into
	 * database.
	 * </p>
	 * 
	 * @return SUCCESS
	 * @throws Exception
	 */
	public String insertDetail() throws Exception {

		CustomerSessionUser customerSessionUser=LoginUtil.getCurrentCustomerUser();
		expensesMonthlyVO.setCreatedBy(customerSessionUser.getCustomerId());
		String message=expensesMonthlyServiceInf.insertDetails(expensesMonthlyVO);
		
		if (OMIConstants.TARGET_SUCCESS.equalsIgnoreCase(message)) {
			logger.info("Successfully Insert Expenses Monthly  Details!");
			addActionMessage("Successfully Insert Expenses Monthly Details!");
			return SUCCESS;

		} else if (OMIConstants.TARGET_FAILURE.equalsIgnoreCase(message)) {

			logger.info("Error:while  Insert Expenses Monthly Details!");
			addActionError("Error:while  Insert Expenses Monthly Details!");
			return ERROR;
		}
		 else  {
				logger.info("Error:while  Insert Expenses Monthly Details!");
				addActionError("Error:while  Insert Expenses Monthly Details!");
				return ERROR;
			}

	}


	/**
	 * <p>
	 * <code>addMonthlyTravelExpenses</code> method is use to insert monthly
	 * details into database.
	 * </p>
	 * 
	 * @return SUCCESS
	 * @throws Exception
	 */

	public String addMonthlyTravelExpense() throws Exception {
		String message = null;
		try {
			CustomerSessionUser customerSessionUser = LoginUtil.getCurrentCustomerUser();
			expensesMonthlyVO.setCreatedBy(customerSessionUser.getCustomerId());
			expensesMonthlyVO.setMonthlyTravelRefNo(LoginUtil.getProcessUserGuidId());
			
			message = expensesMonthlyServiceInf.addMonthlyTravelExpenses(expensesMonthlyVO);
			if (OMIConstants.TARGET_SUCCESS.equalsIgnoreCase(message)) {
				expensesMonthlyVO.setMonthlyTravelRefNo(LoginUtil.getProcessUserGuidId());
				travelMonthlyDataList=expensesMonthlyServiceInf.TravelDataList(expensesMonthlyVO);
				
				if (travelMonthlyDataList!=null) {
					expensesMonthlyVO = expensesMonthlyDaoInf.calculateTravelAmountA(expensesMonthlyVO);
					
				}else if (OMIConstants.TARGET_TRAVEL_DETAILS_NOT_EXIST
						.equalsIgnoreCase(message)){
				
				logger.info("Travel Details Insert Successfully.");
				addActionMessage("Travel Details Insert Successfully.");
				return SUCCESS;
				}

			} else if (OMIConstants.TARGET_TRAVEL_DETAILS_NOT_EXIST
					.equalsIgnoreCase(message)) {
				logger.info("Travel Details  not exists!");
				addActionError("Travel Details  not exists.");
				return INPUT;
			}
			return SUCCESS;
		} catch (NullPointerException nullPointerException) {
			logger.error(
					"Null pointer exception, failed to get customerSessionUser.",
					nullPointerException);
			return ERROR;
		}
		}
	
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public String viewMonthlyTravelExpenses() throws Exception {
		try {
			int travel_claim_id = Integer.parseInt(request
					.getParameter("command"));
			monthlyTravelListGrid = expensesMonthlyServiceInf
					.viewMonthlyTravelList(expensesMonthlyVO, travel_claim_id);
			if (monthlyTravelListGrid != null) {
				return SUCCESS;
			} else {
				return ERROR;
			}

		} catch (NullPointerException nullPointerException) {
			logger.error(
					"Null pointer exception, fail to get customerSessionUser.",
					nullPointerException);
			return ERROR;
			}
	}
	
	
	/**
	 * <p>
	 * excelReport()
	 * </p>
	 * method to generate the Excel Sheet report of monthlyExcelReport Dashboard from database
	 * 
	 * @return
	 * @throws Exception
	 * @author Deepak Vishwakarma
	 * @param request
	 *            ,response
	 */
	public String monthlyExcelReport() throws Exception {
		expensesMonthlyServiceInf.expensesMonthlyExcelReport(request, httpServletResponse);
		return NONE;
	}
	
	
	
	/**
	 * <p>
	 * <code>addMonthlyOtherExpenses0</code> method is use to insert monthly
	 * details into database.
	 * </p>
	 * 
	 * @return SUCCESS
	 * @throws Exception
	 */

	public String addMonthlyOtherExpenses() throws Exception {
		String message = null;
		CustomerSessionUser customerSessionUser = LoginUtil.getCurrentCustomerUser();
		expensesMonthlyVO.setCreatedBy(customerSessionUser.getCustomerId());
		expensesMonthlyVO.setMonthlyOtherRefNo(LoginUtil.getProcessUserGuidId());
		try {
			message = expensesMonthlyServiceInf
					.addMonthlyOtherExpenses(expensesMonthlyVO);
			if (OMIConstants.TARGET_SUCCESS.equalsIgnoreCase(message)) {
				travelOtherDataList=expensesMonthlyServiceInf.OtherDataList(expensesMonthlyVO);
				if (travelOtherDataList!=null) {
				travelMonthlyDataList=expensesMonthlyServiceInf.TravelDataList(expensesMonthlyVO);
				
				expensesMonthlyVO = expensesMonthlyDaoInf.calculateTravelAmountA(expensesMonthlyVO);
				if(expensesMonthlyVO!=null){
				expensesMonthlyVO = expensesMonthlyDaoInf.calculateOtherAmountB(expensesMonthlyVO);

				}
				}else if(OMIConstants.TARGET_SUCCESS.equalsIgnoreCase(message)){

				logger.info("Other Monthly Expenses inserted successfully");
				addActionMessage("Other Monthly Expenses inserted successfully");
				}else if (OMIConstants.TARGET_SUCCESS.equalsIgnoreCase(message)) {
					/*
					 * expensesMonthlyVO=expensesMonthlyDaoInf.calculateAmountA(
					 * expensesMonthlyVO);
					 */
					logger.info("Other Monthly Calculation  Successfully.");
					addActionMessage("Other Monthly Calculation Successfully.");
					return SUCCESS;
				} else if (OMIConstants.TARGET_OTHER_DETAILS_NOT_EXIST

				.equalsIgnoreCase(message)) {
					logger.info("Other Monthly Details  not exists!");
					addActionError("Other Monthly Details  not exists.");
					return INPUT;
				}

			}
			return SUCCESS;
		} catch (NullPointerException nullPointerException) {
			logger.error(
					"Null pointer exception, failed to get customerSessionUser.",
					nullPointerException);
			return ERROR;
		}
	}
	
	
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public String viewOtherExpenses() throws Exception {
		try {
			int other_claim_id = Integer.parseInt(request
					.getParameter("command"));
			monthlyOtherListGrid = expensesMonthlyServiceInf
					.vewMonthlyOtherList(expensesMonthlyVO, other_claim_id);
			if (monthlyOtherListGrid != null) {
				return SUCCESS;
			} else {
				return ERROR;
			}

		} catch (NullPointerException nullPointerException) {
			logger.error(
					"Null pointer exception, failed to get customerSessionUser.",
					nullPointerException);
			return ERROR;
		}
	}
	/**
	 * <p>
	 * <code>viewMonthlyExpensesDetail</code> method is use to View monthly Expenses
	 * details into database.
	 * </p>
	 * 
	 * @return SUCCESS
	 * @throws Exception
	 */
	
	public String viewMonthlyExpensesDetail() throws Exception {
		
		try {
			int monthlyClaimId = Integer.parseInt(request.getParameter("command"));
			LoginUtil.setProcessUserId(monthlyClaimId);
			travelMonthlyDataListByMonthlyClaimId=expensesMonthlyDaoInf.showTravelExpensestListById(expensesMonthlyVO, monthlyClaimId);
			travelOtherDataListByMonthlyClaimId=expensesMonthlyDaoInf.showOtherExpensesListById(expensesMonthlyVO, monthlyClaimId);
			expensesMonthlyVO = expensesMonthlyServiceInf.getExpensesMonthlyDetails(monthlyClaimId);

			if (expensesMonthlyVO != null) {

				monthlyTravelList = expensesMonthlyDaoInf.viewMonthlyTravelListById(
						expensesMonthlyVO, monthlyClaimId);
			if (monthlyTravelList != null) {
					monthlyOtherList = expensesMonthlyDaoInf
							.viewMonthlyOtherListById(expensesMonthlyVO, monthlyClaimId);
				}
			}
			return SUCCESS;

		} catch (NullPointerException nullPointerException) {
			logger.error(
					"Null pointer exception, fail to get customerSessionUser.",
					nullPointerException);
			return ERROR;
		}

	}
	/**
	 * <p>
	 * <code>editExpensesMonthlyDetail</code>Method is use to get expenses details
	 * from database based on claim id and that id set in to processID.
	 * </p>
	 * 
	 * @return
	 * @throws Exception
	 */
	public String editExpensesMonthlyDetail() throws Exception {
		int monthlyClaimId = Integer.parseInt(request.getParameter("command"));
		try {
			LoginUtil.setProcessUserId(monthlyClaimId);			
			expensesMonthlyVO = expensesMonthlyServiceInf.showExpensesMonthlyDetails(monthlyClaimId);
			if (expensesMonthlyVO != null) {
				/*monthlyTravelList = */
				travelMonthlyDataListByMonthlyClaimId=expensesMonthlyDaoInf.showTravelExpensestListById(expensesMonthlyVO, monthlyClaimId);
				if (travelMonthlyDataListByMonthlyClaimId != null) {
					travelOtherDataListByMonthlyClaimId=expensesMonthlyDaoInf.showOtherExpensesListById(expensesMonthlyVO, monthlyClaimId);
					/*monthlyOtherList = */
				}
			}
			return SUCCESS;

		} catch (NullPointerException nullPointerException) {
			logger.error(
					"Null pointer exception, fail to get customerSessionUser.",
					nullPointerException);
			return ERROR;
		}

	}

	
	/**
	 * <p>
	 * <code>updateExpensesMonthly</code>Method is use to update expenses details
	 * into database based on claim id and that id set in to processID.
	 * </p>
	 * 
	 * @return
	 * @throws Exception
	 */
	public String updateExpensesMonthly() throws OMIApplicationException {
		int monthlyClaimId = LoginUtil.getProcessUserId();

		System.out.println("Action Class " + monthlyClaimId);
		try {
			expensesMonthlyServiceInf.updateExpensesMonthly(expensesMonthlyVO, monthlyClaimId);
			if (expensesMonthlyVO != null) {
				/*monthlyTravelList = */
				travelMonthlyDataListByMonthlyClaimId=expensesMonthlyDaoInf.showTravelExpensestListById(expensesMonthlyVO, monthlyClaimId);
				if (travelMonthlyDataListByMonthlyClaimId != null) {
					travelOtherDataListByMonthlyClaimId=expensesMonthlyDaoInf.showOtherExpensesListById(expensesMonthlyVO, monthlyClaimId);
					/*monthlyOtherList = */
				}
			}
			
			return SUCCESS;
		} catch (NullPointerException nullPointerException) {
			logger.error("Null pointer exception, fail to get claimId.",
					nullPointerException);
			return ERROR;
		}

	}
	
	
	


	/**
	 * <p>
	 * <code>populateExpenses</code>This Method generate the ref no for expenses
	 * table and other two tables after populating the add new expenses page
	 * </p>
	 * 
	 * @return SUCCESS
	 * @throws Exception
	 */
	public String populateMonthlyExpenses() throws Exception {
		String monthlytExpensesGuide = IDGenerator.generateAlphaNumericID(27);
		System.out.println("Guid is :: "+monthlytExpensesGuide);
		LoginUtil.setProcessUserGuidId(monthlytExpensesGuide);
		

		return SUCCESS;
	}
	
	
	
	
	
	/**
	 * <p>
	 * <code>nextViewMonthlyExpenses()</code> method is use to view the Monthly Expenses details into
	 * view  page
	 * </p>
	 * 
	 * @return
	 * @throws Exception
	 */
	public String nextViewMonthlyExpenses() throws Exception {
		int monthlyClaimId = LoginUtil.getProcessUserId();
		this.expensesMonthlyVO = expensesMonthlyServiceInf.viewNextMonthlyExpenses(monthlyClaimId);
		if (expensesMonthlyVO != null) {
			travelMonthlyDataListByMonthlyClaimId=expensesMonthlyDaoInf.showTravelExpensestListById(expensesMonthlyVO, monthlyClaimId);
			if (travelMonthlyDataListByMonthlyClaimId != null) {
				travelOtherDataListByMonthlyClaimId=expensesMonthlyDaoInf.showOtherExpensesListById(expensesMonthlyVO, monthlyClaimId);
		if (expensesMonthlyVO.getMonthlyClaimId() != 0) {
			logger.info("Expenses details found successfully for Claim Id  "
					+ expensesMonthlyVO.getMonthlyClaimId());
			addActionMessage("Expenses details found successfully for Claim Id "
					+ expensesMonthlyVO.getMonthlyClaimId());
			return SUCCESS;
		} else {
			expensesMonthlyVO.setMonthlyClaimId(LoginUtil.getProcessUserId());
			logger.error("Expenses details not found for Claim Id  "
					+ expensesMonthlyVO.getMonthlyClaimId());
			addActionError("Expenses details not found for Claim Id "
					+ expensesMonthlyVO.getMonthlyClaimId());
			return ERROR;
		}

		}
		}
		return ERROR;
	}
	
	
	
	/**
	 * <p>
	 * <code>previousViewMonthlyExpenses()</code> method is use to view the Expenses details into
	 * view  page
	 * </p>
	 * 
	 * @return
	 * @throws Exception
	 */
	public String previousViewMonthlyExpenses() throws OMIApplicationException {
		int monthlyClaimId = LoginUtil.getProcessUserId();
		this.expensesMonthlyVO = expensesMonthlyServiceInf.viewPreviousMonthlyExpenses(monthlyClaimId);
		if (expensesMonthlyVO != null) {
			travelMonthlyDataListByMonthlyClaimId=expensesMonthlyDaoInf.showTravelExpensestListById(expensesMonthlyVO, monthlyClaimId);
			if (travelMonthlyDataListByMonthlyClaimId != null) {
				travelOtherDataListByMonthlyClaimId=expensesMonthlyDaoInf.showOtherExpensesListById(expensesMonthlyVO, monthlyClaimId);
		if (expensesMonthlyVO.getMonthlyClaimId() != 0) {
			logger.info("Expenses details found successfully for Claim Id  "
					+ expensesMonthlyVO.getMonthlyClaimId());
			addActionMessage("Expenses details found successfully for Claim Id "
					+ expensesMonthlyVO.getMonthlyClaimId());
			return SUCCESS;
		} else if (LoginUtil.getProcessUserId() == -1) {
			LoginUtil.setProcessUserId(expensesMonthlyDaoInf.getMonthlyExpensesLastRecord() + 1);
			logger.error("Expenses details not found");
			addActionError("Expenses details not found");
			return ERROR;
		} else {
			expensesMonthlyVO.setMonthlyClaimId(LoginUtil.getProcessUserId());
			logger.error("Expenses details not found for Claim Id  "
					+ expensesMonthlyVO.getMonthlyClaimId());
			addActionError("Expenses details not found for Claim Id "
					+ expensesMonthlyVO.getMonthlyClaimId());
			return ERROR;

		}
			}
		}
		return ERROR;

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public String getApprovedByDetails() throws Exception {

		return SUCCESS;
	}

	@Override
	public ExpensesMonthlyVO getModel() {

		return expensesMonthlyVO;
	}

	public ExpensesMonthlyVO getExpensesMonthlyVO() {
		return expensesMonthlyVO;
	}

	public void setExpensesMonthlyVO(ExpensesMonthlyVO expensesMonthlyVO) {
		this.expensesMonthlyVO = expensesMonthlyVO;
	}

	public ListHelper getListHelper() {
		return listHelper;
	}

	public void setListHelper(ListHelper listHelper) {
		this.listHelper = listHelper;
	}

	public Map<Integer, String> getCustomerNameList() {
		return customerNameList;
	}

	public void setCustomerNameList(Map<Integer, String> customerNameList) {
		this.customerNameList = customerNameList;
	}

	public List<ExpensesMonthlyVO> getMonthlyTravelList() {
		return monthlyTravelListGrid;
	}

	public void setMonthlyTravelList(List<ExpensesMonthlyVO> monthlyTravelList) {
		this.monthlyTravelListGrid = monthlyTravelList;
	}

	/**
	 * @return the monthlyOtherList
	 */
	public List<ExpensesMonthlyVO> getMonthlyOtherList() {
		return monthlyOtherListGrid;
	}

	/**
	 * @param monthlyOtherList
	 *            the monthlyOtherList to set
	 */
	public void setMonthlyOtherList(List<ExpensesMonthlyVO> monthlyOtherList) {
		this.monthlyOtherListGrid = monthlyOtherList;
	}

	/**
	 * @return the expensesMonthlyList
	 */
	public List<ExpensesMonthlyVO> getExpensesMonthlyList() {
		return expensesMonthlyList;
	}

	/**
	 * @param expensesMonthlyList
	 *            the expensesMonthlyList to set
	 */
	public void setExpensesMonthlyList(
			List<ExpensesMonthlyVO> expensesMonthlyList) {
		this.expensesMonthlyList = expensesMonthlyList;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @return the httpServletResponse
	 */
	public HttpServletResponse getHttpServletResponse() {
		return httpServletResponse;
	}

	/**
	 * @param httpServletResponse the httpServletResponse to set
	 */
	public void setHttpServletResponse(HttpServletResponse httpServletResponse) {
		this.httpServletResponse = httpServletResponse;
	}

	/**
	 * @return the request
	 */
	public HttpServletRequest getRequest() {
		return request;
	}

	/**
	 * @param request the request to set
	 */
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	/**
	 * @return the expensesClaimStatus
	 */
	public HashMap<Integer, String> getExpensesClaimStatus() {
		return expensesClaimStatus;
	}

	/**
	 * @param expensesClaimStatus the expensesClaimStatus to set
	 */
	public void setExpensesClaimStatus(HashMap<Integer, String> expensesClaimStatus) {
		this.expensesClaimStatus = expensesClaimStatus;
	}

	/**
	 * @return the travelOtherDataListByMonthlyClaimId
	 */
	public List<ExpensesMonthlyVO> getTravelOtherDataListByMonthlyClaimId() {
		return travelOtherDataListByMonthlyClaimId;
	}

	/**
	 * @param travelOtherDataListByMonthlyClaimId the travelOtherDataListByMonthlyClaimId to set
	 */
	public void setTravelOtherDataListByMonthlyClaimId(
			List<ExpensesMonthlyVO> travelOtherDataListByMonthlyClaimId) {
		this.travelOtherDataListByMonthlyClaimId = travelOtherDataListByMonthlyClaimId;
	}

	/**
	 * @return the travelMonthlyDataListByMonthlyClaimId
	 */
	public List<ExpensesMonthlyVO> getTravelMonthlyDataListByMonthlyClaimId() {
		return travelMonthlyDataListByMonthlyClaimId;
	}

	/**
	 * @param travelMonthlyDataListByMonthlyClaimId the travelMonthlyDataListByMonthlyClaimId to set
	 */
	public void setTravelMonthlyDataListByMonthlyClaimId(
			List<ExpensesMonthlyVO> travelMonthlyDataListByMonthlyClaimId) {
		this.travelMonthlyDataListByMonthlyClaimId = travelMonthlyDataListByMonthlyClaimId;
	}

	/**
	 * @return the travelOtherDataList
	 */
	public List<ExpensesMonthlyVO> getTravelOtherDataList() {
		return travelOtherDataList;
	}

	/**
	 * @param travelOtherDataList the travelOtherDataList to set
	 */
	public void setTravelOtherDataList(List<ExpensesMonthlyVO> travelOtherDataList) {
		this.travelOtherDataList = travelOtherDataList;
	}

	/**
	 * @return the travelMonthlyDataList
	 */
	public List<ExpensesMonthlyVO> getTravelMonthlyDataList() {
		return travelMonthlyDataList;
	}

	/**
	 * @param travelMonthlyDataList the travelMonthlyDataList to set
	 */
	public void setTravelMonthlyDataList(
			List<ExpensesMonthlyVO> travelMonthlyDataList) {
		this.travelMonthlyDataList = travelMonthlyDataList;
	}

	public Map<Integer, String> getTravelModeList() {
		return travelModeList;
	}

	public void setTravelModeList(Map<Integer, String> travelModeList) {
		this.travelModeList = travelModeList;
	}
	
	public List<ExpensesMonthlyVO> getMonthlyTravelListGrid() {
		return monthlyTravelListGrid;
	}

	public void setMonthlyTravelListGrid(
			List<ExpensesMonthlyVO> monthlyTravelListGrid) {
		this.monthlyTravelListGrid = monthlyTravelListGrid;
	}

	public List<ExpensesMonthlyVO> getMonthlyOtherListGrid() {
		return monthlyOtherListGrid;
	}

	public void setMonthlyOtherListGrid(
			List<ExpensesMonthlyVO> monthlyOtherListGrid) {
		this.monthlyOtherListGrid = monthlyOtherListGrid;
	}
	
	
	
}
