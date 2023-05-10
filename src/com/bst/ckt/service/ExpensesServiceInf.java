/**
 * 
 */
package com.bst.ckt.service;

import com.bst.ckt.exception.OMIApplicationException;
import com.bst.ckt.vo.ExpensesVO;

/**
 * @author Deepak Vishwakarma
 * 
 */
public interface ExpensesServiceInf {

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
	String expensesDetails(ExpensesVO expensesVO)
			throws OMIApplicationException;

	/**
	 * <p>
	 * Method<code>tourTicketDetails</code> Is Use to insert Tour Ticket Detail
	 * Into Database
	 * </p>
	 * 
	 * @param expensesVO
	 * @return
	 * @throws OMIApplicationException
	 */
	String tourTicketDetails(ExpensesVO expensesVO)
			throws OMIApplicationException;

	/**
	 * <p>
	 * Method<code>insertHotelDetail</code> Is Use to insert Boarding Expenses
	 * Detail Into Database
	 * </p>
	 * 
	 * @param expensesVO
	 * @return
	 * @throws OMIApplicationException
	 */
	String insertHotelDetail(ExpensesVO expensesVO)
			throws OMIApplicationException;

	/**
	 * <p>
	 * Method<code>getExpensesDetails</code> Is Use to fetch Expenses
	 * Detail from Database
	 * </p>
	 * 
	 * @param claimIds
	 * @return
	 * @throws OMIApplicationException
	 */
	ExpensesVO getExpensesDetails(int claimId)throws OMIApplicationException;

	
	/**
	 * <p>
	 * Method<code>updateExpensesTour</code> Is Use to Update Expenses
	 * Detail INTO Database
	 * </p>
	 * 
	 * @param claimIds
	 * @return
	 * @throws OMIApplicationException
	 */
	String updateExpensesTour(ExpensesVO expensesVO, int claimId)throws OMIApplicationException;

	/**
	 * <p>
	 * Method<code>updateExpensesTicketFare</code> Is Use to Update Expenses Ticket Fare
	 * Detail INTO Database
	 * </p>
	 * 
	 * @param ticketId
	 * @return
	 * @throws OMIApplicationException
	 */
	String updateExpensesTicketFare(ExpensesVO expensesVO, int ticketId)throws OMIApplicationException;

	/**
	 * <p>
	 * Method<code>updateExpensesBoarding</code> Is Use to Update Expenses Boarding
	 * Detail INTO Database
	 * </p>
	 * 
	 * @param boardingId
	 * @return
	 * @throws OMIApplicationException
	 */
	String updateExpensesBoarding(ExpensesVO expensesVO, int boardingId)throws OMIApplicationException;

	/**
	 * <p>
	 * Method<code>getExpensesTicketFare</code> Is Use to get Expenses Boarding
	 * Detail INTO Database
	 * </p>
	 * 
	 * @param boardingId
	 * @return ExpensesVO
	 * @throws OMIApplicationException
	 */
	ExpensesVO getExpensesTicketFare(int ticketId)throws OMIApplicationException;

	/**
	 * <p>
	 * Method<code>getExpensesBoarding</code> Is Use to get Expenses Boarding
	 * Detail INTO Database
	 * </p>
	 * 
	 * @param boardingId
	 * @return ExpensesVO
	 * @throws OMIApplicationException
	 */
	ExpensesVO getExpensesBoarding(int boardingId)throws OMIApplicationException;

	ExpensesVO viewNextExpenses(int claimId)throws OMIApplicationException;

	ExpensesVO viewPreviousExpenses(int claimId)throws OMIApplicationException;

}
