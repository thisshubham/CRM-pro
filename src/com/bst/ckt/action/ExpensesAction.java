package com.bst.ckt.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.objectweb.asm.tree.TryCatchBlockNode;

import com.bst.ckt.common.LoginUtil;
import com.bst.ckt.common.OMIConstants;
import com.bst.ckt.dao.ExpensesDaoImpl;
import com.bst.ckt.dao.ExpensesDaoInf;
import com.bst.ckt.exception.OMIApplicationException;
import com.bst.ckt.framework.user.CustomerSessionUser;
import com.bst.ckt.framework.util.IDGenerator;
import com.bst.ckt.helper.ExpensesClaimStatus;
import com.bst.ckt.helper.ListHelper;
import com.bst.ckt.service.ExpensesServiceImpl;
import com.bst.ckt.service.ExpensesServiceInf;
import com.bst.ckt.vo.ExpensesVO;
import com.itextpdf.text.pdf.hyphenation.TernaryTree;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @author Deepak Vishwakarma
 * 
 */
public class ExpensesAction extends ActionSupport implements
		ModelDriven<ExpensesVO>, ServletRequestAware, ServletResponseAware,
		SessionAware {

	/**
	 * Creating Logger object, logger object mapped with LeadAction class for
	 * writing Loggers.
	 */
	private static final Logger logger = Logger.getLogger(ExpensesAction.class);

	private static final long serialVersionUID = -7731062874039472974L;
	ExpensesVO expensesVO = new ExpensesVO();
	ExpensesServiceInf expensesServiceInf = new ExpensesServiceImpl();
	ListHelper listHelper = new ListHelper();
	HttpServletRequest request = null;
	HttpServletResponse response = null;
	Map<String, Object> session = null;
	private Map<Integer, String> travelModeList;
	ExpensesDaoInf expensesDaoInf = new ExpensesDaoImpl();
	private List<ExpensesVO> tourTicketGrid = null;
	private List<ExpensesVO> tourTicketList = null;
	private List<ExpensesVO> boardingDetailList = null;
	private List<ExpensesVO> boardingDetailGrid = null;
	private List<ExpensesVO> claimedExpensesGrid = null;
	private Map<Integer, String> customerNameList;
	private HashMap<Integer, String> expensesClaimStatus;

	public ExpensesAction() throws Exception {

		travelModeList = listHelper.travelModeList();
		claimedExpensesGrid = expensesDaoInf.showClaimedExpensesList();
		customerNameList = listHelper.customerNameList();
		expensesClaimStatus = ExpensesClaimStatus.getExpensesClaimStatusList();

	}

	/**
	 * <p>
	 * expensesDetail()
	 * </p>
	 * method is use to add Expenses details into database
	 * 
	 * @return
	 * @throws Exception
	 */
	public String expensesDetail() throws Exception {
		expensesServiceInf = new ExpensesServiceImpl();
		try {
			CustomerSessionUser customerSessionUser = LoginUtil
					.getCurrentCustomerUser();
			expensesVO.setCreatedBy(customerSessionUser.getCustomerId());
			expensesVO.setTicketRefNo(LoginUtil.getProcessUserGuidId());
			String message = expensesServiceInf.expensesDetails(expensesVO);
			if (OMIConstants.TARGET_SUCCESS.equalsIgnoreCase(message)) {
				tourTicketGrid = expensesDaoInf.showTourTicketList(expensesVO);
				expensesVO = expensesDaoInf.calculateAmountA(expensesVO);
				logger.info("Ticket Fare Details Get Successfully.");
				addActionMessage("Ticket Fare Details Get Successfully.");

			} else if (OMIConstants.TARGET_TICKET_DETAILS_NOT_EXIST

			.equalsIgnoreCase(message)) {
				logger.info("Ticket Fare Details  not exists!");
				addActionError("Ticket Fare Details  not exists.");
				return INPUT;

			}

			return SUCCESS;
		} catch (NullPointerException nullPointerException) {
			logger.error(
					"Null pointer exception, fail to get Ticket Fare Details",
					nullPointerException);
			return ERROR;
		}

	}

	/**
	 * <p>
	 * insertTourTicketDetail()
	 * </p>
	 * method is use to Insert Tour Ticket details into database
	 * 
	 * @return
	 * @throws Exception
	 */
	public String insertTourTicketDetail() throws Exception {

		expensesServiceInf = new ExpensesServiceImpl();
		String message = null;

		try {
			CustomerSessionUser customerSessionUser = LoginUtil
					.getCurrentCustomerUser();
			expensesVO.setCreatedBy(customerSessionUser.getCustomerId());
			expensesVO.setTicketRefNo(LoginUtil.getProcessUserGuidId());
			message = expensesServiceInf.tourTicketDetails(expensesVO);
			if (OMIConstants.TARGET_SUCCESS.equalsIgnoreCase(message)) {
				tourTicketGrid = expensesDaoInf.showTourTicketList(expensesVO);
				expensesVO = expensesDaoInf.calculateAmountA(expensesVO);
				logger.info("Ticket Fare Details Insert Successfully.");
				addActionMessage("Ticket Fare Details Insert Successfully.");
			} else if (OMIConstants.TARGET_TICKET_DETAILS_NOT_EXIST
					.equalsIgnoreCase(message)) {
				logger.info("Ticket Fare Details  not exists!");
				addActionError("Ticket Fare Details  not exists.");
				return INPUT;
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
	 * <code>insertHotelDetail</code>Method is use to insert boarding detail
	 * into database and ittrate value of boarding from database and set it into
	 * dashboard grid
	 * </p>
	 * 
	 * @return
	 * @throws Exception
	 */
	public String insertHotelDetail() throws Exception {
		System.out.println("Action Hotel Detail ");

		expensesServiceInf = new ExpensesServiceImpl();
		String message = null;
		try {
			CustomerSessionUser customerSessionUser = LoginUtil
					.getCurrentCustomerUser();
			expensesVO.setCreatedBy(customerSessionUser.getCustomerId());
			expensesVO.setBoardingRefNo(LoginUtil.getProcessUserGuidId());
			message = expensesServiceInf.insertHotelDetail(expensesVO);
			if (OMIConstants.TARGET_SUCCESS.equalsIgnoreCase(message)) {

				boardingDetailGrid = expensesDaoInf
						.showBoardingList(expensesVO);
				if (OMIConstants.TARGET_SUCCESS.equalsIgnoreCase(message)) {
					expensesVO.setTicketRefNo(LoginUtil.getProcessUserGuidId());
					tourTicketGrid = expensesDaoInf
							.showTourTicketList(expensesVO);
					expensesVO = expensesDaoInf.calculateAmountB(expensesVO);
					System.out.println("Expenses Tour Details"+expensesVO.getAmountForA());
					logger.info("Ticket Fare Details Insert Successfully.");
					addActionMessage("Ticket Fare Details Insert Successfully.");

					if (OMIConstants.TARGET_SUCCESS.equalsIgnoreCase(message)) {

						logger.info("Ticket Fare Calculation  Successfully.");

						return SUCCESS;
					} else if (OMIConstants.TARGET_TICKET_DETAILS_NOT_EXIST

					.equalsIgnoreCase(message)) {
						logger.info("Ticket Fare Details  not exists!");
						addActionError("Ticket Fare Details  not exists.");
						return INPUT;
					}

				} else if (OMIConstants.TARGET_TICKET_DETAILS_NOT_EXIST
						.equalsIgnoreCase(message)) {
					logger.info("Ticket Fare Details  not exists!");
					addActionError("Ticket Fare Details  not exists.");
					return INPUT;

				}
				logger.info("Boarding Details Insert Successfully.");
				addActionMessage("Boarding Details Insert Successfully.");
				return SUCCESS;
			} else if (OMIConstants.TARGET_BOARDING_DETAILS_NOT_EXIST
					.equalsIgnoreCase(message)) {
				logger.info("Boarding Details  not exists!");
				addActionError("Boarding Details  not exists.");
				return INPUT;
			}
			return NONE;
		} catch (NullPointerException nullPointerException) {
			logger.error(
					"Null pointer exception, fail to get customerSessionUser.",
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
	public String populateExpenses() throws Exception {

		String expensesGuide = IDGenerator.generateAlphaNumericID(27);
		LoginUtil.setProcessUserGuidId(expensesGuide);

		return SUCCESS;
	}

	/**
	 * <p>
	 * <code>showTourExpensesDetail</code>Method is use to get expenses details
	 * from database based on claim id and that id set in to processID.
	 * </p>
	 * 
	 * @return
	 * @throws Exception
	 */
	public String showTourExpensesDetail() throws Exception {
		int claimId = Integer.parseInt(request.getParameter("command"));
		try {
			LoginUtil.setProcessUserId(claimId);
			expensesVO = expensesServiceInf.getExpensesDetails(claimId);

			if (expensesVO != null) {

				tourTicketList = expensesDaoInf.showTourTicketListById(
						expensesVO, claimId);
				if (tourTicketList != null) {
					boardingDetailList = expensesDaoInf
							.showBoardingDetailListById(expensesVO, claimId);
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
	 * <code>updateExpensesTour</code>Method is use to update expenses details
	 * into database based on claim id and that id set in to processID.
	 * </p>
	 * 
	 * @return
	 * @throws Exception
	 */
	public String updateExpensesTour() throws OMIApplicationException {
		int claimId = LoginUtil.getProcessUserId();
		String message=null;
		System.out.println("Action Class " + claimId);
		try {
			message=expensesServiceInf.updateExpensesTour(expensesVO, claimId);
			if (OMIConstants.TARGET_SUCCESS.equalsIgnoreCase(message)) {
				logger.info("Tour Expenses Details Update Successfully.");
				addActionMessage("Tour Expenses Details Update Successfully.");
			} else if (OMIConstants.TARGET_TICKET_DETAILS_NOT_EXIST
					.equalsIgnoreCase(message)) {
				logger.info("Error While Updating Tour Details!");
				addActionError("Error While Updating Tour Details!");
				return INPUT;
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
	 * <code>getExpensesTicketFare</code>Method is use to get expenses
	 * Ticket fare details from database based on ticket id and that id set in
	 * to processID.
	 * </p>
	 * 
	 * @return
	 * @throws Exception
	 */
	public String getExpensesTicketFare() throws OMIApplicationException {
		int ticketId = LoginUtil.getProcessUserId();

		System.out.println("Action Class " + ticketId);
		try {
			expensesVO=expensesServiceInf.getExpensesTicketFare(ticketId);
			return SUCCESS;
		} catch (NullPointerException nullPointerException) {
			logger.error("Null pointer exception, fail to get ticketId.",
					nullPointerException);
			return ERROR;
		}

	}
	
	
	
	/**
	 * <p>
	 * <code>getExpensesBoarding</code>Method is use to get expenses
	 * Boarding details from database based on ticket id and that id set in
	 * to processID.
	 * </p>
	 * 
	 * @return
	 * @throws Exception
	 */
	public String getExpensesBoarding() throws OMIApplicationException {
		int boardingId = LoginUtil.getProcessUserId();

		System.out.println("Action Class " + boardingId);
		try {
			expensesVO=expensesServiceInf.getExpensesBoarding(boardingId);
			return SUCCESS;
		} catch (NullPointerException nullPointerException) {
			logger.error("Null pointer exception, fail to get boardingId.",
					nullPointerException);
			return ERROR;
		}

	}
	
	

	/**
	 * <p>
	 * <code>updateExpensesTicketFare</code>Method is use to update expenses
	 * Ticket fare details into database based on ticket id and that id set in
	 * to processID.
	 * </p>
	 * 
	 * @return
	 * @throws Exception
	 */
	public String updateExpensesTicketFare() throws OMIApplicationException {
		int ticketId = LoginUtil.getProcessUserId();

		System.out.println("Action Class " + ticketId);
		try {
			expensesServiceInf.updateExpensesTicketFare(expensesVO, ticketId);
			return SUCCESS;
		} catch (NullPointerException nullPointerException) {
			logger.error("Null pointer exception, fail to get ticketId.",
					nullPointerException);
			return ERROR;
		}

	}

	/**
	 * <p>
	 * <code>updateExpensesBoarding</code>Method is use to update expenses
	 * Boarding details into database based on boarding id and that id set in to
	 * processID.
	 * </p>
	 * 
	 * @return
	 * @throws Exception
	 */
	public String updateExpensesBoarding() throws OMIApplicationException {
		int boardingId = LoginUtil.getProcessUserId();
		try {
			expensesServiceInf.updateExpensesBoarding(expensesVO, boardingId);
			return SUCCESS;
		} catch (NullPointerException nullPointerException) {
			logger.error("Null pointer exception, fail to get boardingId.",
					nullPointerException);
			return ERROR;
		}

	}
	
	
	/**
	 * <p>
	 * <code>nextViewExpenses()</code> method is use to view the Expenses details into
	 * view  page
	 * </p>
	 * 
	 * @return
	 * @throws Exception
	 */
	public String nextViewExpenses() throws Exception {
		int claimId = Integer.parseInt(request.getParameter("command"));
		this.expensesVO = expensesServiceInf.viewNextExpenses(claimId);
		if (expensesVO != null) {
			tourTicketList = expensesDaoInf.showTourTicketListById(expensesVO, claimId);
			if (tourTicketList != null) {
				boardingDetailList = expensesDaoInf.showBoardingDetailListById(expensesVO, claimId);
		if (expensesVO.getClaimId() != 0) {
			logger.info("Expenses details found successfully for Claim Id  "+ expensesVO.getClaimId());
			addActionMessage("Expenses details found successfully for Claim Id "+ expensesVO.getClaimId());
			return SUCCESS;
		} else {
			expensesVO.setClaimId(LoginUtil.getProcessUserId());
			logger.error("Expenses details not found for Claim Id  "+ expensesVO.getClaimId());
			addActionError("Expenses details not found for Claim Id "+ expensesVO.getClaimId());
			return ERROR;
		}

		}
		}
		return ERROR;
	}
	
	
	/**
	 * <p>
	 * <code>previousViewExpenses()</code> method is use to view the Expenses details into
	 * view  page
	 * </p>
	 * 
	 * @return
	 * @throws Exception
	 */
	public String previousViewExpenses() throws OMIApplicationException {
		int claimId = Integer.parseInt(request.getParameter("command"));
		this.expensesVO = expensesServiceInf.viewPreviousExpenses(claimId);
		if (expensesVO != null) {
			tourTicketList = expensesDaoInf.showTourTicketListById(expensesVO, claimId);
			if (tourTicketList != null) {
				boardingDetailList = expensesDaoInf.showBoardingDetailListById(expensesVO, claimId);
		if (expensesVO.getClaimId() != 0) {
			logger.info("Expenses details found successfully for Claim Id  "
					+ expensesVO.getClaimId());
			addActionMessage("Expenses details found successfully for Claim Id "
					+ expensesVO.getClaimId());
			return SUCCESS;
		} else if (LoginUtil.getProcessUserId() == -1) {
			LoginUtil.setProcessUserId(expensesDaoInf.getExpensesLastRecord() + 1);
			logger.error("Expenses details not found");
			addActionError("Expenses details not found");
			return ERROR;
		} else {
			expensesVO.setClaimId(LoginUtil.getProcessUserId());
			logger.error("Expenses details not found for Claim Id  "
					+ expensesVO.getClaimId());
			addActionError("Expenses details not found for Claim Id "
					+ expensesVO.getClaimId());
			return ERROR;

		}
			}
		}
		return ERROR;

	}

	/**
	 * @return the boardingDetailGrid
	 */
	public List<ExpensesVO> getBoardingDetailGrid() {
		return boardingDetailGrid;
	}

	/**
	 * @param boardingDetailGrid
	 *            the boardingDetailGrid to set
	 */
	public void setBoardingDetailGrid(List<ExpensesVO> boardingDetailGrid) {
		this.boardingDetailGrid = boardingDetailGrid;
	}

	/**
	 * @return the tourTicketGrid
	 */
	public List<ExpensesVO> getTourTicketGrid() {
		return tourTicketGrid;
	}

	/**
	 * @param tourTicketGrid
	 *            the tourTicketGrid to set
	 */
	public void setTourTicketGrid(List<ExpensesVO> tourTicketGrid) {
		this.tourTicketGrid = tourTicketGrid;
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
	 * @return the session
	 */
	public Map<String, Object> getSession() {
		return session;
	}

	/**
	 * @return the travelModeList
	 */
	public Map<Integer, String> getTravelModeList() {
		return travelModeList;
	}

	/**
	 * @param travelModeList
	 *            the travelModeList to set
	 */
	public void setTravelModeList(Map<Integer, String> travelModeList) {
		this.travelModeList = travelModeList;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	@Override
	public ExpensesVO getModel() {
		// TODO Auto-generated method stub
		return expensesVO;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	/**
	 * @return the expensesVO
	 */
	public ExpensesVO getExpensesVO() {
		return expensesVO;
	}

	/**
	 * @param expensesVO
	 *            the expensesVO to set
	 */
	public void setExpensesVO(ExpensesVO expensesVO) {
		this.expensesVO = expensesVO;
	}

	/**
	 * @return the claimedExpensesGrid
	 */
	public List<ExpensesVO> getClaimedExpensesGrid() {
		return claimedExpensesGrid;
	}

	/**
	 * @param claimedExpensesGrid
	 *            the claimedExpensesGrid to set
	 */
	public void setClaimedExpensesGrid(List<ExpensesVO> claimedExpensesGrid) {
		this.claimedExpensesGrid = claimedExpensesGrid;
	}

	/**
	 * @return the customerNameList
	 */
	public Map<Integer, String> getCustomerNameList() {
		return customerNameList;
	}

	/**
	 * @param customerNameList
	 *            the customerNameList to set
	 */
	public void setCustomerNameList(Map<Integer, String> customerNameList) {
		this.customerNameList = customerNameList;
	}

	/**
	 * @return the expensesClaimStatus
	 */
	public HashMap<Integer, String> getExpensesClaimStatus() {
		return expensesClaimStatus;
	}

	/**
	 * @param expensesClaimStatus
	 *            the expensesClaimStatus to set
	 */
	public void setExpensesClaimStatus(
			HashMap<Integer, String> expensesClaimStatus) {
		this.expensesClaimStatus = expensesClaimStatus;
	}

	/**
	 * @return the tourTicketList
	 */
	public List<ExpensesVO> getTourTicketList() {
		return tourTicketList;
	}

	/**
	 * @param tourTicketList
	 *            the tourTicketList to set
	 */
	public void setTourTicketList(List<ExpensesVO> tourTicketList) {
		this.tourTicketList = tourTicketList;
	}

	/**
	 * @return the boardingDetailList
	 */
	public List<ExpensesVO> getBoardingDetailList() {
		return boardingDetailList;
	}

	/**
	 * @param boardingDetailList
	 *            the boardingDetailList to set
	 */
	public void setBoardingDetailList(List<ExpensesVO> boardingDetailList) {
		this.boardingDetailList = boardingDetailList;
	}

}
