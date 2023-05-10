/**
 * 
 */
package com.bst.ckt.dao;

import java.util.List;

import com.bst.ckt.exception.OMIApplicationException;
import com.bst.ckt.vo.ExpensesVO;

/**
 * @author Deepak Vishwakarma
 * 
 */
public interface ExpensesDaoInf {

	/**
	 * <p>
	 * Method<code>addTourExpensesDetails</code> Is Use to insert expenses
	 * details into database.
	 * </p>
	 * 
	 * @param expensesVO
	 * @return
	 * @throws OMIApplicationException
	 */
	int addTourExpensesDetails(ExpensesVO expensesVO)
			throws OMIApplicationException;

	/**
	 * <p>
	 * Method<code>addTourTicketDetails</code> Is Use to insert tour ticket
	 * expenses details into database.
	 * </p>
	 * 
	 * @param expensesVO
	 * @return
	 * @throws OMIApplicationException
	 */
	int addTourTicketDetails(ExpensesVO expensesVO)
			throws OMIApplicationException;

	/**
	 * <p>
	 * Method<code>showTourTicketList</code> Is Use to fatch tour ticket
	 * expenses details from database and set it into array list and populate on
	 * expenses ticket grig into collaps.
	 * </p>
	 * 
	 * @return
	 */
	public List<ExpensesVO> showTourTicketList(ExpensesVO expensesVO);

	/**
	 * <p>
	 * <code>insertHotelDetail</code>Method is use to insert boarding details
	 * into database.
	 * <p/>
	 * 
	 * @param expensesVO
	 * @return
	 * @throws OMIApplicationException
	 */
	int insertHotelDetail(ExpensesVO expensesVO) throws OMIApplicationException;

	/**
	 * <p>
	 * <code>showBoardingList</code> Method will return the list of boarding
	 * details by arraylist that get the details from database and set on
	 * boarding grid
	 * </p>
	 * 
	 * @return
	 * @throws OMIApplicationException
	 */
	public List<ExpensesVO> showBoardingList(ExpensesVO expensesVO)
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>calculateAmountA</code>Method is use to calculate the amount of
	 * tour ticket and store it into A and set on expenses page into collaps.
	 * </p>
	 * 
	 * @param expensesVO
	 * @return
	 * @throws OMIApplicationException
	 */
	ExpensesVO calculateAmountA(ExpensesVO expensesVO)
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>calculateAmountB</code>Method is use to calculate the amount of
	 * tour ticket and store it into B and set on expenses page into collaps.
	 * </p>
	 * 
	 * @param expensesVO
	 * @return
	 * @throws OMIApplicationException
	 */
	ExpensesVO calculateAmountB(ExpensesVO expensesVO)
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>getExpensesId</code>Method is use to get expenses id from database.
	 * </p>
	 * 
	 * @param expensesVO
	 * @return
	 * @throws OMIApplicationException
	 */
	int getExpensesId(ExpensesVO expensesVO) throws OMIApplicationException;

	/**
	 * <p>
	 * <code>insertClaimId</code>Method will insert the claim id into database.
	 * </p>
	 * 
	 * @param expensesVO
	 * @return
	 * @throws OMIApplicationException
	 */
	int insertClaimId(ExpensesVO expensesVO) throws OMIApplicationException;

	/**
	 * <p>
	 * <code>showClaimedExpensesList</code>Method is use to retrive the claim
	 * expenses Details from database.
	 * </p>
	 * 
	 * @return
	 * @throws OMIApplicationException
	 */
	List<ExpensesVO> showClaimedExpensesList() throws OMIApplicationException;

	/**
	 * <p>
	 * <code>insertBoardingClaimId</code>Method is use to insert clain id into
	 * boarding table.
	 * </p>
	 * 
	 * @param expensesVO
	 * @return
	 * @throws OMIApplicationException
	 */
	int insertBoardingClaimId(ExpensesVO expensesVO)
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>getExpensesDetails</code>Method is use to fetch expenses details
	 * from database.
	 * </p>
	 * 
	 * @param claimId
	 * @return
	 * @throws OMIApplicationException
	 */
	ExpensesVO getExpensesDetails(int claimId) throws OMIApplicationException;

	/**
	 * 
	 * @param expensesVO
	 * @param claimId
	 * @return
	 * @throws OMIApplicationException
	 */
	List<ExpensesVO> showTourTicketListById(ExpensesVO expensesVO, int claimId)
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>updateExpensesTourDetails</code>Method is use to Update expenses
	 * details into database.
	 * </p>
	 * 
	 * @param claimId
	 * @return
	 * @throws OMIApplicationException
	 */
	int updateExpensesTourDetails(ExpensesVO expensesVO, int claimId)
			throws OMIApplicationException;

	/**
	 * 
	 * @param expensesVO
	 * @param claimId
	 * @return
	 * @throws OMIApplicationException
	 */
	List<ExpensesVO> showBoardingDetailListById(ExpensesVO expensesVO,
			int claimId)throws OMIApplicationException;

	/**
	 * 
	 * @param expensesVO
	 * @param ticketId
	 * @return
	 * @throws OMIApplicationException
	 */
	int updateExpensesTicketFare(ExpensesVO expensesVO, int ticketId)throws OMIApplicationException;
	

	/**
	 * 
	 * @param expensesVO
	 * @param boardingId
	 * @return
	 * @throws OMIApplicationException
	 */
	int updateExpensesBoarding(ExpensesVO expensesVO, int boardingId)throws OMIApplicationException;

	/**
	 * 
	 * @param ticketId
	 * @return
	 * @throws OMIApplicationException
	 */
	ExpensesVO getExpensesTicketFare(int ticketId)throws OMIApplicationException;

	/**
	 * 
	 * @param boardingId
	 * @return
	 * @throws OMIApplicationException
	 */
	ExpensesVO getExpensesBoarding(int boardingId)throws OMIApplicationException;
	

	/**
	 * 
	 * @return
	 * @throws OMIApplicationException
	 */
	int getExpensesLastRecord()throws OMIApplicationException;

}
