/**
 * 
 */
package com.bst.ckt.service;

import org.apache.log4j.Logger;

import com.bst.ckt.common.LoginUtil;
import com.bst.ckt.common.OMIConstants;
import com.bst.ckt.dao.ExpensesDaoImpl;
import com.bst.ckt.dao.ExpensesDaoInf;
import com.bst.ckt.dao.ExpensesMonthlyDaoImpl;
import com.bst.ckt.dao.ExpensesMonthlyDaoInf;
import com.bst.ckt.exception.OMIApplicationException;
import com.bst.ckt.vo.ExpensesMonthlyVO;
import com.bst.ckt.vo.ExpensesVO;

/**
 * @author Deepak Vishwakarma
 *
 */
public class ExpensesServiceImpl implements ExpensesServiceInf{
	
	ExpensesDaoInf expensesDaoInf=new ExpensesDaoImpl();
	
	/**
	 * Creating Logger object, logger object mapped with LeadDaoImpl class for
	 * writing Loggers.
	 */
	public static final Logger logger = Logger.getLogger(ExpensesServiceImpl.class);
	ExpensesVO expensesVO=new ExpensesVO();

	/**
	 * <p>
	 * Method<code>expensesDetails</code> Is Use to insert Tour Expenses Detail
	 * Into Database
	 * </p>
	 * 
	 * @param expensesVO
	 * @return
	 * @throws OMIApplicationException
	 */
	@Override
	public String expensesDetails(ExpensesVO expensesVO)
			throws OMIApplicationException {
	
			 expensesDaoInf=new ExpensesDaoImpl();
			
			int target=expensesDaoInf.addTourExpensesDetails(expensesVO);
			if(target!=0){
				expensesDaoInf.getExpensesId(expensesVO);
				if(target!=0){
					expensesDaoInf.insertClaimId(expensesVO);
					expensesDaoInf.insertBoardingClaimId(expensesVO);
					
				}else{
					logger.error(
							ExpensesServiceImpl.class
									+ "Error: Occur in Query While Claim Id And Boarding Claim Id  into Database.");
					return OMIConstants.RESULT_SUCCESS;
				}
			}else{
				logger.error(
						ExpensesServiceImpl.class
								+ "Error: Occur in Query While Claim Id And Boarding Claim Id into Database.");
				return OMIConstants.RESULT_FAILURE_ERROR;
			}
			 
			
		return null;
	}

	
	/**
	 * <p>
	 * Method<code>tourTicketDetails</code> Is Use to insert Tour Expenses Detail
	 * Into Database
	 * </p>
	 * 
	 * @param expensesVO
	 * @return
	 * @throws OMIApplicationException
	 */
	@Override
	public String tourTicketDetails(ExpensesVO expensesVO)
			throws OMIApplicationException {
		int target=expensesDaoInf.addTourTicketDetails(expensesVO);
		if(target!=0){
			logger.info("ticket detail inserted successfully.");
			return OMIConstants.RESULT_SUCCESS;
		} else {
			logger.error(LeadServiceImpl.class + "ticket details not exists");
			return OMIConstants.TARGET_TICKET_DETAILS_NOT_EXIST;
	
		}
		
	}

	/**
	 * <p>
	 * Method<code>insertHotelDetail</code> Is Use to insert Boarding Expenses Detail
	 * Into Database
	 * </p>
	 * 
	 * @param expensesVO
	 * @return
	 * @throws OMIApplicationException
	 */
	@Override
	public String insertHotelDetail(ExpensesVO expensesVO)
			throws OMIApplicationException {
		int target=expensesDaoInf.insertHotelDetail(expensesVO);
		if(target!=0){
			logger.info("boarding details inserted successfully.");
			return OMIConstants.RESULT_SUCCESS;
		} else {
			logger.error(LeadServiceImpl.class + "boarding detail not exists");
			return OMIConstants.TARGET_BOARDING_DETAILS_NOT_EXIST;
	
		}
	}


	/**
	 * <p>
	 * Method<code>getExpensesDetails</code> Is Use to fetch Expenses Detail
	 * from Database
	 * </p>
	 * 
	 * @param claimId
	 * @return expensesVO
	 * @throws OMIApplicationException
	 */
	@Override
	public ExpensesVO getExpensesDetails(int claimId)
			throws OMIApplicationException {
		expensesVO=expensesDaoInf.getExpensesDetails(claimId);
		return expensesVO;
	}


	/**
	 * <p>
	 * Method<code>updateExpensesTour</code> Is Use to update Expenses Detail
	 * into Database
	 * </p>
	 * 
	 * @param claimId
	 * @return expensesVO
	 * @throws OMIApplicationException
	 */
	@Override
	public String updateExpensesTour(ExpensesVO expensesVO, int claimId)
			throws OMIApplicationException {
		
		System.out.println("*****************Service Class");
		int target=expensesDaoInf.updateExpensesTourDetails(expensesVO,claimId);
		if(target!=0){
			logger.info("Tour Expenses Details Update successfully.");
			return OMIConstants.RESULT_SUCCESS;
		} else {
			logger.error(LeadServiceImpl.class + "boarding detail not exists");
			return OMIConstants.TARGET_BOARDING_DETAILS_NOT_EXIST;
	
		}
	}


	/**
	 * <p>
	 * Method<code>updateExpensesTicketFare</code> Is Use to update Expenses Ticket Fare Detail
	 * into Database
	 * </p>
	 * 
	 * @param ticketId
	 * @return expensesVO
	 * @throws OMIApplicationException
	 */
	@Override
	public String updateExpensesTicketFare(ExpensesVO expensesVO, int ticketId)
			throws OMIApplicationException {
		System.out.println("*****************Service Class");
		expensesDaoInf.updateExpensesTicketFare(expensesVO,ticketId);
		return null;
	}


	/**
	 * <p>
	 * Method<code>updateExpensesBoarding</code> Is Use to update Expenses Boarding  Detail
	 * into Database
	 * </p>
	 * 
	 * @param boardingId
	 * @return expensesVO
	 * @throws OMIApplicationException
	 */
	@Override
	public String updateExpensesBoarding(ExpensesVO expensesVO, int boardingId)
			throws OMIApplicationException {
		System.out.println("*****************Service Class");
		expensesDaoInf.updateExpensesBoarding(expensesVO,boardingId);
		return null;
	}


	/**
	 * <p>
	 * Method<code>getExpensesTicketFare</code> Is Use to get Expenses Boarding  Detail
	 * from Database
	 * </p>
	 * 
	 * @param ticketId
	 * @return expensesVO
	 * @throws OMIApplicationException
	 */
	@Override
	public ExpensesVO getExpensesTicketFare(int ticketId)
			throws OMIApplicationException {
		expensesVO=expensesDaoInf.getExpensesTicketFare(ticketId);
		return expensesVO;
	}


	/**
	 * <p>
	 * Method<code>getExpensesBoarding</code> Is Use to get Expenses Boarding  Detail
	 * from Database
	 * </p>
	 * 
	 * @param boardingId
	 * @return expensesVO
	 * @throws OMIApplicationException
	 */
	@Override
	public ExpensesVO getExpensesBoarding(int boardingId)
			throws OMIApplicationException {
		expensesVO=expensesDaoInf.getExpensesBoarding(boardingId);
		return expensesVO;
	}


	@Override
	public ExpensesVO viewNextExpenses(int claimId)
			throws OMIApplicationException {
		
		try {
			claimId++;
			if (expensesDaoInf.getExpensesLastRecord() < claimId) {
				claimId = 0;
				LoginUtil.setProcessUserId(claimId);
				
				expensesVO.setClaimId(0);
				return expensesVO;
			} else {
				LoginUtil.setProcessUserId(claimId);
				expensesVO = expensesDaoInf.getExpensesDetails(claimId);
				if (expensesVO.getClaimId() == 0) {
					claimId = LoginUtil.getProcessUserId();
					LoginUtil.setProcessUserId(claimId);
					return expensesVO;
				}
				expensesVO = expensesDaoInf.getExpensesDetails(claimId);
			}

		} catch (Exception exception) {
			logger.error("no records found" + exception);
		}
		return expensesVO;
	}


	@Override
	public ExpensesVO viewPreviousExpenses(int claimId)
			throws OMIApplicationException {
		try {
			claimId--;
			LoginUtil.setProcessUserId(claimId);
			expensesVO = expensesDaoInf.getExpensesDetails(claimId);
			if (expensesVO.getClaimId() == 0) {
				claimId = LoginUtil.getProcessUserId();
				LoginUtil.setProcessUserId(claimId);
				return expensesVO;
			}
			expensesVO = expensesDaoInf.getExpensesDetails(claimId);

		} catch (Exception exception) {
			logger.error("no records found" + exception);
		}
		return expensesVO;
	
	}
	

}
