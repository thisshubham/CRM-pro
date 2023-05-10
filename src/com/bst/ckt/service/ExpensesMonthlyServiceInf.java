package com.bst.ckt.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bst.ckt.exception.OMIApplicationException;
import com.bst.ckt.vo.ExpensesMonthlyVO;

public interface ExpensesMonthlyServiceInf {

	/**
	 * <p>
	 * Method<code>insertDetails</code> Is Use to insert Expenses Detail Into
	 * Database
	 * </p>
	 * 
	 * @param expensesMonthlyVO
	 * @return
	 * @throws OMIApplicationException
	 */
	public String insertDetails(ExpensesMonthlyVO expensesMonthlyVO)
			throws OMIApplicationException;

	/**
	 * <p>
	 * Method<code>addMonthlyTravelExpenses</code> Is Use to insert Expenses Detail Into
	 * Database
	 * </p>
	 * 
	 * @param expensesMonthlyVO
	 * @return
	 * @throws OMIApplicationException
	 */
	

	public String addMonthlyOtherExpenses(ExpensesMonthlyVO expensesMonthlyVO)
			throws OMIApplicationException;

	

	/**
	 * <p>
	 * Method<code>expensesMonthlyList</code> Is Use to insert Expenses Detail Into
	 * Database
	 * </p>
	 * 
	 * @param expensesMonthlyVO
	 * @return
	 * @throws OMIApplicationException
	 */
	public List<ExpensesMonthlyVO> expensesMonthlyList()
			throws OMIApplicationException;

	/**
	 * <p>
	 * Method<code>setMonthlyOtherRefNo</code> Is Use to insert ExpensesMonthlyOther Detail Into
	 * Database
	 * </p>
	 * 
	 * @param expensesMonthlyVO
	 * @return
	 * @throws OMIApplicationException
	 */
	public String setMonthlyOtherRefNo(ExpensesMonthlyVO expensesMonthlyVO)
			throws OMIApplicationException;
	
	/**
	 * <p>
	 * Method<code>monthlyOtherList</code> Is Use to insert ExpensesMonthlyOther Detail Into
	 * Database
	 * </p>
	 * 
	 * @param expensesMonthlyVO
	 * @return
	 * @throws OMIApplicationException
	 */

	public List<ExpensesMonthlyVO> monthlyOtherList()
			throws OMIApplicationException;
	
	/**
	 * 
	 * @param expensesMonthlyVO
	 * @param other_claim_id
	 * @return
	 */
	public List<ExpensesMonthlyVO> vewMonthlyOtherList(
			ExpensesMonthlyVO expensesMonthlyVO, int other_claim_id);
	
	
	/**
	 * <p>
	 * Method<code>getExpensesMonthlyDetails</code> Is Use to view Expenses Monthly Detail Into
	 * Database
	 * </p>
	 * 
	 * @param expensesMonthlyVO
	 * @return
	 * @throws OMIApplicationException
	 */

	public ExpensesMonthlyVO getExpensesMonthlyDetails(int monthlyClaimId)throws OMIApplicationException;

	/**
	 * <p>
	 * Method<code>addMonthlyTravelExpenses</code> Is Use to view Expenses Monthly Travel Into
	 * Database
	 * </p>
	 * 
	 * @param expensesMonthlyVO
	 * @return
	 * @throws OMIApplicationException
	 */
	public String addMonthlyTravelExpenses(ExpensesMonthlyVO expensesMonthlyVO)throws OMIApplicationException;
	
	
	/**
	 * 
	 * @param expensesMonthlyVO
	 * @param travel_claim_id
	 * @return
	 */
	public List<ExpensesMonthlyVO> viewMonthlyTravelList(
			ExpensesMonthlyVO expensesMonthlyVO, int travel_claim_id);
	
	/**
	 * <p>
	 * Method<code>setMonthlyTravelRefNo</code> Is Use to insert Expenses Monthly Travel Into
	 * Database
	 * </p>
	 * 
	 * @param expensesMonthlyVO
	 * @return
	 * @throws OMIApplicationException
	 */

	public String setMonthlyTravelRefNo(ExpensesMonthlyVO expensesMonthlyVO)throws OMIApplicationException ;
	
	/**
	 * <p>
	 * Method<code>monthlyTravelList</code> Is Use to Monthly Travel List Into
	 * Database
	 * </p>
	 * 
	 * @param expensesMonthlyVO
	 * @return
	 * @throws OMIApplicationException
	 */

	public List<ExpensesMonthlyVO> monthlyTravelList(ExpensesMonthlyVO expensesMonthlyVO)throws OMIApplicationException;

	/**
	 * <p>
	 * Method<code>updateExpensesMonthly</code> Is Use to UpdateMonthly Expenses Into
	 * Database
	 * </p>
	 * 
	 * @param expensesMonthlyVO
	 * @return
	 * @throws OMIApplicationException
	 */
	public String updateExpensesMonthly(ExpensesMonthlyVO expensesMonthlyVO,
			int monthlyClaimId)throws OMIApplicationException;

	/**
	 * <p>
	 * Method<code>showExpensesMonthlyDetails</code> Is Use to ShowMonthly Expenses Into
	 * Database
	 * </p>
	 * 
	 * @param expensesMonthlyVO
	 * @return
	 * @throws OMIApplicationException
	 */
	public ExpensesMonthlyVO showExpensesMonthlyDetails(int monthlyClaimId)throws OMIApplicationException;

	/**
	 * 
	 * @return
	 * @throws OMIApplicationException
	 */
	List<ExpensesMonthlyVO> monthlyTravelList() throws OMIApplicationException;

	/**
	 * <p>
	 * Method<code>TravelDataList</code> Is Use to Monthly Travel List Into
	 * Database
	 * </p>
	 * 
	 * @return
	 * @throws OMIApplicationException
	 */
	public List<ExpensesMonthlyVO> TravelDataList(ExpensesMonthlyVO expensesMonthlyVO)throws OMIApplicationException;
	

	/**
	 * 
	 * @param expensesMonthlyVO
	 * @return
	 * @throws OMIApplicationException
	 */
	public List<ExpensesMonthlyVO> OtherDataList(ExpensesMonthlyVO expensesMonthlyVO)throws OMIApplicationException;

	/**
	 * 
	 * @param monthlyClaimId
	 * @return
	 * @throws OMIApplicationException
	 */
	public ExpensesMonthlyVO viewNextMonthlyExpenses(int monthlyClaimId)throws OMIApplicationException;

	
	/**
	 * 
	 * @param monthlyClaimId
	 * @return
	 * @throws OMIApplicationException
	 */
	public ExpensesMonthlyVO viewPreviousMonthlyExpenses(int monthlyClaimId)throws OMIApplicationException;
	
	
	/**
	 * <p>
	 * Method<code>expensesMonthlyExcelReport</code> Is Use to Monthly Travel List Into
	 * Database
	 * </p>
	 * 
	 * @return
	 * @throws OMIApplicationException
	 */
	public void expensesMonthlyExcelReport(HttpServletRequest request,
			HttpServletResponse response)throws Exception;

	

}
