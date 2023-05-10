/**
 * 
 */
package com.bst.ckt.dao;

import java.util.List;

import com.bst.ckt.exception.OMIApplicationException;
import com.bst.ckt.vo.ExpensesMonthlyVO;

/**
 * @author pratik
 *
 */
public interface ExpensesMonthlyDaoInf {


	/**
	 * <P>
	 * <CODE>addDeatails()</CODE> METHOD IS USE TO INSERT EXPENSES MONTHLY DETAILS INTO
	 * DATABASE
	 * </P>
	 * 
	 * @param EXPENSESMONTHLYVO
	 * @return
	 * @throws Exception
	 */
	public int addDeatails(ExpensesMonthlyVO expensesMonthlyVO)throws OMIApplicationException;


	/**
	 * <P>
	 * <CODE>addMonthlyOtherExpenses()</CODE> METHOD IS USE TO INSERT MonthlyOtherExpenses DETAILS INTO
	 * DATABASE
	 * </P>
	 * 
	 * @param EXPENSESMONTHLY VO
	 * @return
	 * @throws Exception
	 */

	 int addMonthlyOtherExpenses(ExpensesMonthlyVO expensesMonthlyVO)throws OMIApplicationException;

	
	/**
	 * <P>
	 * <CODE>monthlyTravelList()</CODE> METHOD IS USE TO INSERT MonthlyTravelExpenses DETAILS INTO
	 * DATABASE
	 * </P>
	 * 
	 * @param EXPENSESMONTHLY VO
	 * @return
	 * @throws Exception
	 */
	public List<ExpensesMonthlyVO> monthlyTravelList()throws OMIApplicationException;
	/**
	 * <P>
	 * <CODE>getExpensesMontlyList()</CODE> METHOD IS USE TO INSERT MonthlyTravelExpenses DETAILS INTO
	 * DATABASE
	 * </P>
	 * 
	 * @param EXPENSESMONTHLY VO
	 * @return
	 * @throws Exception
	 */
	public List<ExpensesMonthlyVO> getExpensesMontlyList()throws OMIApplicationException;
	/**
	 * <P>
	 * <CODE>getMontlyOtherList()</CODE> METHOD IS USE TO INSERT MonthlyOtherExpenses DETAILS INTO
	 * DATABASE
	 * </P>
	 * 
	 * @param EXPENSESMONTHLY VO
	 * @return
	 * @throws Exception
	 */
	public List<ExpensesMonthlyVO> getMontlyOtherList()throws OMIApplicationException;

	/**
	 * <P>
	 * <CODE>calculateOtherAmountB()</CODE> METHOD IS USE TO INSERT MonthlyOtherExpenses DETAILS INTO
	 * DATABASE
	 * </P>
	 * 
	 * @param EXPENSESMONTHLY VO
	 * @return
	 * @throws Exception
	 */
	public ExpensesMonthlyVO calculateOtherAmountB(ExpensesMonthlyVO expensesMonthlyVO)throws OMIApplicationException;
	/**
	 * <P>
	 * <CODE>getExpensesDetails()</CODE> METHOD IS USE TO INSERT getExpensesDetails DETAILS INTO
	 * DATABASE
	 * </P>
	 * 
	 * @param EXPENSESMONTHLY VO
	 * @return
	 * @throws Exception
	 */

	public ExpensesMonthlyVO getExpensesDetails(int monthlyClaimId)throws OMIApplicationException;
	/**
	 * <P>
	 * <CODE>viewMonthlyTravelListById()</CODE> METHOD IS USE TO INSERT viewMonthlyTravelListById DETAILS INTO
	 * DATABASE
	 * </P>
	 * 
	 * @param EXPENSESMONTHLY VO
	 * @return
	 * @throws Exception
	 */
	public List<ExpensesMonthlyVO> viewMonthlyTravelListById(
			ExpensesMonthlyVO expensesMonthlyVO, int monthlyClaimId)throws OMIApplicationException;
	/**
	 * <P>
	 * <CODE>viewMonthlyOtherlListById()</CODE> METHOD IS USE TO INSERT viewMonthlyOtherlListById DETAILS INTO
	 * DATABASE
	 * </P>
	 * 
	 * @param EXPENSESMONTHLY VO
	 * @return
	 * @throws Exception
	 */

	public List<ExpensesMonthlyVO> viewMonthlyOtherlListById(
			ExpensesMonthlyVO expensesMonthlyVO, int monthlyClaimId)throws OMIApplicationException;

	/**
	 * <P>
	 * <CODE>showTravelExpensesList()</CODE> METHOD IS USE TO INSERT showTravelExpensesList DETAILS INTO
	 * DATABASE
	 * </P>
	 * 
	 * @param EXPENSESMONTHLY VO
	 * @return
	 * @throws Exception
	 */
	public List<ExpensesMonthlyVO> showTravelExpensesList()throws OMIApplicationException;

	/**
	 * <P>
	 * <CODE>addMonthlyTravelExpenses()</CODE> METHOD IS USE TO INSERT addMonthlyTravelExpenses DETAILS INTO
	 * DATABASE
	 * </P>
	 * 
	 * @param EXPENSESMONTHLY VO
	 * @return
	 * @throws Exception
	 */
	public int addMonthlyTravelExpenses(ExpensesMonthlyVO expensesMonthlyVO)throws OMIApplicationException;

	/**
	 * 
	 * @param expensesMonthlyVO
	 * @param travel_claim_id
	 * @return
	 */
	public List<ExpensesMonthlyVO> showExpensesMonthlyTravelList(
			ExpensesMonthlyVO expensesMonthlyVO, int travel_claim_id);
	
	
	/**
	 * 
	 * @param expensesMonthlyVO
	 * @param other_claim_id
	 * @return
	 */
	public List<ExpensesMonthlyVO> showOtherExpensesDetails(
			ExpensesMonthlyVO expensesMonthlyVO, int other_claim_id);
	
	/**
	 * <P>
	 * <CODE>calculateTravelAmountA()</CODE> METHOD IS USE TO INSERT calculateTravelAmountA DETAILS INTO
	 * DATABASE
	 * </P>
	 * 
	 * @param EXPENSESMONTHLY VO
	 * @return
	 * @throws Exception
	 */
	public ExpensesMonthlyVO calculateTravelAmountA(
			ExpensesMonthlyVO expensesMonthlyVO)throws OMIApplicationException;

	/**
	 * <P>
	 * <CODE>addTravelDetails()</CODE> METHOD IS USE TO INSERT addTravelDetails DETAILS INTO
	 * DATABASE
	 * </P>
	 * 
	 * @param EXPENSESMONTHLY VO
	 * @return
	 * @throws Exception
	 */
	public int addTravelDetails(ExpensesMonthlyVO expensesMonthlyVO)throws OMIApplicationException;

	/**
	 * <P>
	 * <CODE>getMontlyTravelList()</CODE> METHOD IS USE TO INSERT getMontlyTravelList DETAILS INTO
	 * DATABASE
	 * </P>
	 * 
	 * @param EXPENSESMONTHLY VO
	 * @return
	 * @throws Exception
	 */
	public List<ExpensesMonthlyVO> getMontlyTravelList(ExpensesMonthlyVO expensesMonthlyVO)throws OMIApplicationException;

	/**
	 * <P>
	 * <CODE>updateExpensesTravelDetails()</CODE> METHOD IS USE TO INSERT updateExpensesTravelDetails DETAILS INTO
	 * DATABASE
	 * </P>
	 * 
	 * @param EXPENSESMONTHLY VO
	 * @return
	 * @throws Exception
	 */
	public int updateExpensesTravelDetails(
			ExpensesMonthlyVO expensesMonthlyVO, int monthlyClaimId)throws OMIApplicationException;

	/**
	 * <P>
	 * <CODE>showTravelExpensestListById()</CODE> METHOD IS USE TO INSERT showTravelExpensestListById DETAILS INTO
	 * DATABASE
	 * </P>
	 * 
	 * @param EXPENSESMONTHLY VO
	 * @return
	 * @throws Exception
	 */
	public List<ExpensesMonthlyVO> showTravelExpensestListById(
			ExpensesMonthlyVO expensesMonthlyVO, int monthlyClaimId)throws OMIApplicationException;

	/**
	 * <P>
	 * <CODE>showOtherExpensesListById()</CODE> METHOD IS USE TO INSERT showOtherExpensesListById DETAILS INTO
	 * DATABASE
	 * </P>
	 * 
	 * @param EXPENSESMONTHLY VO
	 * @return
	 * @throws Exception
	 */
	public List<ExpensesMonthlyVO> showOtherExpensesListById(
			ExpensesMonthlyVO expensesMonthlyVO, int monthlyClaimId)throws OMIApplicationException;

	/**
	 * <P>
	 * <CODE>getExpensesMonthlyDetails()</CODE> METHOD IS USE TO INSERT getExpensesMonthlyDetails DETAILS INTO
	 * DATABASE
	 * </P>
	 * 
	 * @param EXPENSESMONTHLY VO
	 * @return
	 * @throws Exception
	 */
	public ExpensesMonthlyVO getExpensesMonthlyDetails(int monthlyClaimId)throws OMIApplicationException;
	/**
	 * <P>
	 * <CODE>viewMonthlyOtherListById()</CODE> METHOD IS USE TO INSERT viewMonthlyOtherListById DETAILS INTO
	 * DATABASE
	 * </P>
	 * 
	 * @param EXPENSESMONTHLY VO
	 * @return
	 * @throws Exception
	 */

	public List<ExpensesMonthlyVO> viewMonthlyOtherListById(
			ExpensesMonthlyVO expensesMonthlyVO, int monthlyClaimId);


	public List<ExpensesMonthlyVO> getOtherTravelList(ExpensesMonthlyVO expensesMonthlyVO)throws OMIApplicationException;


	public int getMonthlyExpensesId(ExpensesMonthlyVO expensesMonthlyVO)throws OMIApplicationException;


	public int insertMonthlyClaimId(ExpensesMonthlyVO expensesMonthlyVO)throws OMIApplicationException;


	public int insertMonthlyBoardingClaimId(ExpensesMonthlyVO expensesMonthlyVO)throws OMIApplicationException;


	public int getMonthlyExpensesLastRecord()throws OMIApplicationException;


	
	


	
	
	

}
