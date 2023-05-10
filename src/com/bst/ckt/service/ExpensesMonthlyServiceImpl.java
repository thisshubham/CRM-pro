/**
 * 
 */
package com.bst.ckt.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.bst.ckt.common.LoginUtil;
import com.bst.ckt.common.OMIConstants;
import com.bst.ckt.dao.ExcelReportDaoImpl;
import com.bst.ckt.dao.ExcelReportDaoInf;
import com.bst.ckt.dao.ExpensesMonthlyDaoImpl;
import com.bst.ckt.dao.ExpensesMonthlyDaoInf;
import com.bst.ckt.dto.Product;
import com.bst.ckt.exception.OMIApplicationException;
import com.bst.ckt.vo.ExpensesMonthlyVO;

/**
 * @author pratik
 *
 */
public class ExpensesMonthlyServiceImpl implements ExpensesMonthlyServiceInf {

	/**
	 * Creating Logger object, logger object mapped with LeadAction class for
	 * writing Loggers.
	 */
	private static final Logger logger = Logger
			.getLogger(ExpensesMonthlyServiceImpl.class);
	ExpensesMonthlyDaoInf expensesMonthlyDaoInf = new ExpensesMonthlyDaoImpl();
	

	@Override
	public String insertDetails(ExpensesMonthlyVO expensesMonthlyVO)
			throws OMIApplicationException {
		ExpensesMonthlyDaoInf expensesMonthlyDaoInf = new ExpensesMonthlyDaoImpl();		
		int target=expensesMonthlyDaoInf.addDeatails(expensesMonthlyVO);
		if (target != 0) {
			expensesMonthlyDaoInf.getMonthlyExpensesId(expensesMonthlyVO);
			if(target!=0){			
				expensesMonthlyDaoInf.insertMonthlyClaimId(expensesMonthlyVO);
				expensesMonthlyDaoInf.insertMonthlyBoardingClaimId(expensesMonthlyVO);				
			}else{
				logger.error(
						ExpensesServiceImpl.class
								+ "Error: Occur in Query While Claim Id And Boarding Claim Id  into Database.");
				return OMIConstants.RESULT_SUCCESS;
			}
			
			logger.info("Successfully Insert Expenses Monthly !");
			return OMIConstants.TARGET_SUCCESS;

		} else {
			logger.info("Error:while  Inserting  Expenses Monthly into database!");
			return OMIConstants.TARGET_FAILURE;

		}
	}

	
	/**
	 * <p>
	 * <code>addMonthlyOtherExpenses</code>this method is use to Insert
	 * ExpensesMonthlyOther details
	 * </p>
	 * @return OMIConstants
	 * @throws Exception
	 */
	public String addMonthlyOtherExpenses(ExpensesMonthlyVO expensesMonthlyVO)
			throws OMIApplicationException {

		int target = expensesMonthlyDaoInf
				.addMonthlyOtherExpenses(expensesMonthlyVO);

		if (target == 1) {
			logger.info("Successfully Insert Monthly Expenses  Details!");
			return OMIConstants.TARGET_SUCCESS;

		} else {

			logger.info("Error:while  Inserting  Monthly Expenses Details into database!");
			return OMIConstants.TARGET_FAILURE;

		}
	}


	

	/**
	 * <p>
	 * <code>expensesMonthlyList</code>this method is use to Insert
	 * expensesMonthlyList details
	 * </p>
	 * @return OMIConstants
	 * @throws Exception
	 */
	public List<ExpensesMonthlyVO> expensesMonthlyList()
			throws OMIApplicationException {
		ExpensesMonthlyDaoInf expensesMonthlyDaoInf = new ExpensesMonthlyDaoImpl();
		return expensesMonthlyDaoInf.getExpensesMontlyList();
	}

	

	/**
	 * <p>
	 * <code>monthlyOtherList</code>this method is use to Insert
	 * monthlyOtherList details
	 * </p>
	 * @return OMIConstants
	 * @throws Exception
	 */
	public List<ExpensesMonthlyVO> monthlyOtherList()
			throws OMIApplicationException {
		ExpensesMonthlyDaoInf expensesMonthlyDaoInf = new ExpensesMonthlyDaoImpl();
		return expensesMonthlyDaoInf.getMontlyOtherList();
		
	}

	
	/**
	 * <p>
	 * <code>getExpensesMonthlyDetails</code>this method is use to Insert
	 * getExpensesMonthlyDetails details
	 * </p>
	 * @return OMIConstants
	 * @throws Exception
	 */
	@Override
	public ExpensesMonthlyVO getExpensesMonthlyDetails(int monthlyClaimId)
			throws OMIApplicationException {
		ExpensesMonthlyVO expensesMonthlyVO = new ExpensesMonthlyVO();
		try{
			
		expensesMonthlyVO=expensesMonthlyDaoInf.getExpensesDetails(monthlyClaimId);
		}catch(Exception exception){
			exception.printStackTrace();
		}
		return expensesMonthlyVO;
		
	}
	/**
	 * <p>
	 * <code>addMonthlyTravelExpenses</code>this method is use to Insert
	 * addMonthlyTravelExpenses details
	 * </p>
	 * @return OMIConstants
	 * @throws Exception
	 */

	@Override
	public String addMonthlyTravelExpenses(ExpensesMonthlyVO expensesMonthlyVO)
			throws OMIApplicationException {
		int target = expensesMonthlyDaoInf
				.addMonthlyTravelExpenses(expensesMonthlyVO);
		if (target == 1) {
			logger.info("Successfully Insert Monthly Expenses  Details!");
			return OMIConstants.TARGET_SUCCESS;

		} else {

			logger.info("Error:while  Inserting  Monthly Expenses Details into database!");
			return OMIConstants.TARGET_FAILURE;

		}
	}

	
	/**
	 * 
	 */
	public List<ExpensesMonthlyVO> vewMonthlyOtherList(
			ExpensesMonthlyVO expensesMonthlyVO, int other_claim_id) {
		ExpensesMonthlyDaoInf expensesMonthlyDaoInf = new ExpensesMonthlyDaoImpl();
		return expensesMonthlyDaoInf.showOtherExpensesDetails(
				expensesMonthlyVO, other_claim_id);
	}
	
	/**
	 * 
	 */
	public List<ExpensesMonthlyVO> viewMonthlyTravelList(
			ExpensesMonthlyVO expensesMonthlyVO, int travel_claim_id) {
		ExpensesMonthlyDaoInf expensesMonthlyDaoInf = new ExpensesMonthlyDaoImpl();

		return expensesMonthlyDaoInf.showExpensesMonthlyTravelList(
				expensesMonthlyVO, travel_claim_id);
	}

	
	

	/**
	 * <p>
	 * <code>updateExpensesMonthly</code>this method is use to Insert
	 * updateExpensesMonthly details
	 * </p>
	 * @return OMIConstants
	 * @throws Exception
	 */
	@Override
	public String updateExpensesMonthly(ExpensesMonthlyVO expensesMonthlyVO,
			int monthlyClaimId) throws OMIApplicationException {
		expensesMonthlyDaoInf.updateExpensesTravelDetails(expensesMonthlyVO,monthlyClaimId);
		return null;
		
	}
	/**
	 * <p>
	 * <code>showExpensesMonthlyDetails</code>this method is use to Insert
	 * showExpensesMonthlyDetails details
	 * </p>
	 * @return OMIConstants
	 * @throws Exception
	 */

	@Override
	public ExpensesMonthlyVO showExpensesMonthlyDetails(int monthlyClaimId)
			throws OMIApplicationException {
		ExpensesMonthlyVO expensesMonthlyVO = new ExpensesMonthlyVO();
		try{
			expensesMonthlyVO=expensesMonthlyDaoInf.getExpensesMonthlyDetails(monthlyClaimId);
			}catch(Exception exception){
				exception.printStackTrace();
			}
			return expensesMonthlyVO;

	}


	

	@Override
	public List<ExpensesMonthlyVO> TravelDataList(ExpensesMonthlyVO expensesMonthlyVO)
			throws OMIApplicationException {
		ExpensesMonthlyDaoInf expensesMonthlyDaoInf = new ExpensesMonthlyDaoImpl();
		
		return expensesMonthlyDaoInf.getMontlyTravelList(expensesMonthlyVO);
	}


	


	@Override
	public List<ExpensesMonthlyVO> OtherDataList(
			ExpensesMonthlyVO expensesMonthlyVO) throws OMIApplicationException {
		ExpensesMonthlyDaoInf expensesMonthlyDaoInf = new ExpensesMonthlyDaoImpl();
		return expensesMonthlyDaoInf.getOtherTravelList(expensesMonthlyVO);
	}


	@Override
	public String setMonthlyOtherRefNo(ExpensesMonthlyVO expensesMonthlyVO)
			throws OMIApplicationException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String setMonthlyTravelRefNo(ExpensesMonthlyVO expensesMonthlyVO)
			throws OMIApplicationException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<ExpensesMonthlyVO> monthlyTravelList(
			ExpensesMonthlyVO expensesMonthlyVO) throws OMIApplicationException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<ExpensesMonthlyVO> monthlyTravelList()
			throws OMIApplicationException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ExpensesMonthlyVO viewNextMonthlyExpenses(int monthlyClaimId)
			throws OMIApplicationException {
		ExpensesMonthlyVO expensesMonthlyVO = new ExpensesMonthlyVO();
		ExpensesMonthlyDaoInf expensesMonthlyDaoInf = new ExpensesMonthlyDaoImpl();
		try {
			monthlyClaimId++;
			if (expensesMonthlyDaoInf.getMonthlyExpensesLastRecord() < monthlyClaimId) {
				monthlyClaimId = 0;
				LoginUtil.setProcessUserId(monthlyClaimId);
				
				expensesMonthlyVO.setMonthlyClaimId(0);
				return expensesMonthlyVO;
			} else {
				LoginUtil.setProcessUserId(monthlyClaimId);
				expensesMonthlyVO = expensesMonthlyDaoInf.getExpensesMonthlyDetails(monthlyClaimId);
				if (expensesMonthlyVO.getMonthlyClaimId() == 0) {
					monthlyClaimId = LoginUtil.getProcessUserId();
					LoginUtil.setProcessUserId(monthlyClaimId);
					return expensesMonthlyVO;
				}
				expensesMonthlyVO = expensesMonthlyDaoInf.getExpensesMonthlyDetails(monthlyClaimId);
			}

		} catch (Exception exception) {
			logger.error("no records found" + exception);
		}
		return expensesMonthlyVO;
	}


	@Override
	public ExpensesMonthlyVO viewPreviousMonthlyExpenses(int monthlyClaimId)
			throws OMIApplicationException {
		ExpensesMonthlyVO expensesMonthlyVO = new ExpensesMonthlyVO();
		ExpensesMonthlyDaoInf expensesMonthlyDaoInf = new ExpensesMonthlyDaoImpl();
		try {
			monthlyClaimId--;
			LoginUtil.setProcessUserId(monthlyClaimId);
			expensesMonthlyVO = expensesMonthlyDaoInf.getExpensesMonthlyDetails(monthlyClaimId);
			if (expensesMonthlyVO.getMonthlyClaimId() == 0) {
				monthlyClaimId = LoginUtil.getProcessUserId();
				LoginUtil.setProcessUserId(monthlyClaimId);
				return expensesMonthlyVO;
			}
			expensesMonthlyVO = expensesMonthlyDaoInf.getExpensesMonthlyDetails(monthlyClaimId);

		} catch (Exception exception) {
			logger.error("no records found" + exception);
		}
		return expensesMonthlyVO;
	}
	
	
	
	/**
	 * <p>
	 * excelReport()
	 * </p>
	 * method to generate the Excel Sheet report of ExpensesMonthly Dashboard from database
	 * 
	 * @return
	 * @throws Exception
	 * @author Deepak Vishwakarma
	 * @param request
	 *            ,response
	 */
	public void expensesMonthlyExcelReport(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ExcelReportDaoInf excelReportDaoInf = new ExcelReportDaoImpl();
		excelReportDaoInf.retriveExpensesMonthlyExcelReport(request, response);
	}
		
	


	


}



	


