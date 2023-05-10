/**
 * 
 */
package com.bst.ckt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.bst.ckt.common.LoginUtil;
import com.bst.ckt.common.QueryMaker;
import com.bst.ckt.exception.OMIApplicationException;
import com.bst.ckt.framework.db.JdbcDAOSupport;
import com.bst.ckt.framework.db.JdbcHelper;
import com.bst.ckt.framework.util.DateTimeUtil;
import com.bst.ckt.helper.ExpensesClaimStatus;
import com.bst.ckt.helper.NameHelper;
import com.bst.ckt.vo.ExpensesMonthlyVO;

/**
 * @author pratik
 * 
 */
public class ExpensesMonthlyDaoImpl extends JdbcDAOSupport implements
		ExpensesMonthlyDaoInf {

	/**
	 * Creating Logger object, logger object mapped with ExpensesMonthlyDaoImpl
	 * class for writing Loggers.
	 */
	private static final Logger logger = Logger
			.getLogger(ExpensesMonthlyDaoImpl.class);

	PreparedStatement preparedStatement = null;
	Connection connection = null;
	ResultSet resultSet = null;
	ExpensesMonthlyVO expensesMonthlyVO = null;
	NameHelper nameHelper = new NameHelper();

	/**
	 * <p>
	 * <code>addDetails(leadVO)</code> method use to insert assignment details
	 * into TAB_ASSIGNMENT table.
	 * </p>
	 * 
	 * @param assignmentVO
	 * @return target
	 * @throws OMIApplicationException
	 */

	@Override
	public int addDeatails(ExpensesMonthlyVO expensesMonthlyVO)
			throws OMIApplicationException {
		int target = 0;
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.ADD_EXPENSES_MONTHLY_DETAILS);
			preparedStatement.setString(1, expensesMonthlyVO.getName());
			preparedStatement.setString(2, expensesMonthlyVO.getPlaceOfVisit());
			preparedStatement.setString(3, expensesMonthlyVO.getPurposeOfVisit());
			preparedStatement.setString(4, expensesMonthlyVO.getDepartureDate());
			preparedStatement.setString(5, expensesMonthlyVO.getArrivalDate());
			preparedStatement.setString(6, expensesMonthlyVO.getApprovedBy());
			preparedStatement.setFloat(7, expensesMonthlyVO.getTotalAmountA());
			preparedStatement.setFloat(8, expensesMonthlyVO.getTotalAmountB());
			preparedStatement.setFloat(9, expensesMonthlyVO.getAdvanceAmountC());
			preparedStatement.setString(10, expensesMonthlyVO.getClaimedBalance());
			preparedStatement.setString(11, LoginUtil.getProcessUserGuidId());

			preparedStatement.executeUpdate();
			target = 1;
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					ExpensesMonthlyDaoImpl.class
							+ "Error: Occur in Query While Inserting Monthly Expenses Details into Database.",
					sqlException);

		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					ExpensesMonthlyDaoImpl.class
							+ "Error: Occur in Query While Inserting Monthly Expenses Details into Database.",
					exception);

		} finally {
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return target;
	}

	/**
	 * <p>
	 * <code>addMonthlyTravelExpenses(ExpensesMonthlyVO)</code> method use to
	 * insert addMonthlyTravelExpensess into TAB_EXPENSES_MONTHLY_TRAVEL
	 * </p>
	 * 
	 * @param ExpensesMonthlyVO
	 * @return target
	 * @throws Exception
	 */

	@Override
	public int addMonthlyTravelExpenses(ExpensesMonthlyVO expensesMonthlyVO)
			throws OMIApplicationException {
		int target = 0;
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.ADD_MONTHLY_TRAVEL_DETAILS);
			preparedStatement.setString(1,
					expensesMonthlyVO.getDeparturePlace());
			preparedStatement
					.setString(2, expensesMonthlyVO.getDepartureDate());
			preparedStatement.setString(3, expensesMonthlyVO.getFromPlace());
			preparedStatement.setString(4, expensesMonthlyVO.getToPlace());
			preparedStatement.setString(5, expensesMonthlyVO.getTravelMode());
			preparedStatement.setString(6, expensesMonthlyVO.getAmount());
			preparedStatement.setInt(7, expensesMonthlyVO.getCreatedBy());
			preparedStatement.setString(8, DateTimeUtil.getCurrentDate());
			preparedStatement.setString(9,
					expensesMonthlyVO.getMonthlyTravelRefNo());
			preparedStatement.executeUpdate();
			target = 1;
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					ExpensesMonthlyDaoImpl.class
							+ "Error: Occured in Query While Inserting Monthly Travel Expenses Details into Database.",
					sqlException);

		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					ExpensesMonthlyDaoImpl.class
							+ "Error: Occur in Query While Inserting Monthly Travel Expenses Details into Database.",
					exception);

		} finally {
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return target;

	}

	/**
	 * 
	 */
	public List<ExpensesMonthlyVO> showExpensesMonthlyTravelList(
			ExpensesMonthlyVO expensesMonthlyVO, int travel_claim_id) {
		ArrayList<ExpensesMonthlyVO> list = new ArrayList<ExpensesMonthlyVO>();
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.VIEW_EXPENSES_MONTHLY_TRAVEL);
			preparedStatement.setInt(1, travel_claim_id);
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {
					expensesMonthlyVO = new ExpensesMonthlyVO();
					expensesMonthlyVO.setDeparturePlace(resultSet
							.getString("DEPARTURE_PLACE"));
					expensesMonthlyVO.setDepartureDate(resultSet
							.getString("DEPARTURE_DATE"));
					expensesMonthlyVO.setTravelMode(resultSet
							.getString("TRAVEL_MODE"));
					expensesMonthlyVO.setFromPlace(resultSet
							.getString("FROM_PLACE"));
					expensesMonthlyVO.setFromPlace(resultSet
							.getString("FROM_PLACE"));
					expensesMonthlyVO.setToPlace(resultSet
							.getString("TO_PLACE"));
					expensesMonthlyVO.setAmount(resultSet.getString("AMOUNT"));
					list.add(expensesMonthlyVO);

				}

			}

		} catch (SQLException sqlExp) {
			sqlExp.printStackTrace();
			logger.error(
					ExpensesDaoImpl.class
							+ "Error: Occur in Query While Fetching Tour Expenses Details from Database.",
					sqlExp);
		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					ExpensesDaoImpl.class
							+ "Error: Occur in Query While Closing Connection After Fetching Tour Expenses Details from Database.",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return list;
	}

	/**
	 * 
	 */
	public List<ExpensesMonthlyVO> showOtherExpensesDetails(
			ExpensesMonthlyVO expensesMonthlyVO, int other_claim_id) {
		ArrayList<ExpensesMonthlyVO> listOtherExpenses = new ArrayList<ExpensesMonthlyVO>();
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.VIEW_OTHER_EXPENSES_DETAILS);
			preparedStatement.setInt(1, other_claim_id);
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {
					expensesMonthlyVO = new ExpensesMonthlyVO();
					expensesMonthlyVO.setOtherClaimId(resultSet
							.getInt("OTHER_CLAIM_ID"));

					expensesMonthlyVO.setDateAndTime(resultSet
							.getString("DATE_AND_TIME"));

					expensesMonthlyVO.setPlace(resultSet.getString("PLACE"));

					expensesMonthlyVO.setFromPlace(resultSet.getString("ITME"));

					expensesMonthlyVO.setToPlace(resultSet.getString("AMOUNT"));

					listOtherExpenses.add(expensesMonthlyVO);
				}
			}
		} catch (SQLException sqlExp) {
			sqlExp.printStackTrace();
			logger.error(
					ExpensesDaoImpl.class
							+ "Error: Occur in Query While Fetching Tour Expenses Details from Database.",
					sqlExp);
		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					ExpensesDaoImpl.class
							+ "Error: Occur in Query While Closing Connection After Fetching Tour Expenses Details from Database.",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return listOtherExpenses;
	}

	/**
	 * <p>
	 * <code>addMonthlyOtherExpenses(ExpensesMonthlyVO)</code> method use to
	 * insert addMonthlyOtherExpenses into TAB_EXPENSES_MONTHLY_OTHER
	 * </p>
	 * 
	 * @param ExpensesMonthlyVO
	 * @return target
	 * @throws Exception
	 *             OMIApplicationException
	 */

	@Override
	public int addMonthlyOtherExpenses(ExpensesMonthlyVO expensesMonthlyVO)
			throws OMIApplicationException {
		int target = 0;
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.ADD_MONTHLY_OTHER_DETAILS);
			preparedStatement.setString(1, DateTimeUtil.getCurrentDate());

			preparedStatement.setString(2, expensesMonthlyVO.getPlace());
			preparedStatement.setString(3, expensesMonthlyVO.getItems());
			preparedStatement.setString(4, expensesMonthlyVO.getAmount());
			preparedStatement.setInt(5, expensesMonthlyVO.getCreatedBy());
			preparedStatement.setString(6,
					expensesMonthlyVO.getMonthlyOtherRefNo());
			preparedStatement.executeUpdate();
			target = 1;
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					ExpensesMonthlyDaoImpl.class
							+ "Error: Occur in Query While Inserting Monthly Other Expenses Details into Database.",
					sqlException);

		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					ExpensesMonthlyDaoImpl.class
							+ "Error: Occur in Query While Inserting Monthly Other Expenses Details into Database.",
					exception);

		} finally {
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return target;
	}

	/**
	 * <p>
	 * <code>getMontlyOtherList()</code> method use to fetching Expenses monthly
	 * Other details from TAB_EXPENSES_MONTHLY_OTHER table.
	 * </p>
	 * 
	 * 
	 * @return monthlyOtherList
	 * @throws Exception
	 *             OMIApplicationException
	 */
	public List<ExpensesMonthlyVO> getMontlyOtherList(
			ExpensesMonthlyVO expensesMonthlyVO) throws OMIApplicationException {
		ArrayList<ExpensesMonthlyVO> monthlyOtherList = new ArrayList<ExpensesMonthlyVO>();
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_MONTHLY_OTHER_GIRD_LIST);
			preparedStatement.setString(1,
					expensesMonthlyVO.getMonthlyOtherRefNo());
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {
					expensesMonthlyVO = new ExpensesMonthlyVO();
					expensesMonthlyVO.setOtherClaimId(resultSet
							.getInt("OTHER_CLAIM_ID"));
					expensesMonthlyVO.setDateAndTime(resultSet
							.getString("DATE_AND_TIME"));
					expensesMonthlyVO.setPlace(resultSet.getString("PLACE"));
					expensesMonthlyVO.setItems(resultSet.getString("ITME"));
					expensesMonthlyVO.setAmount(resultSet.getString("AMOUNT"));
					monthlyOtherList.add(expensesMonthlyVO);

				}
			}
		} catch (SQLException sqlExp) {
			sqlExp.printStackTrace();
			logger.error(
					ExpensesMonthlyDaoImpl.class
							+ "Error: Occur in Query While Fetching the FAQ Details into Grid from Database.",
					sqlExp);
		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					ExpensesMonthlyDaoImpl.class
							+ "Error: Occur in Query While Closing Connection After Fetching the FAQ Details into Grid from Database.",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return monthlyOtherList;
	}

	/**
	 * <p>
	 * <code>getExpensesMontlyList(ExpensesMonthlyVO)</code> method use to
	 * insert addMonthlyTravelExpensess into TAB_EXPENSES_MONTHLY_TRAVEL
	 * </p>
	 * 
	 * @param ExpensesMonthlyVO
	 * @return target
	 * @throws Exception
	 */
	@Override
	public List<ExpensesMonthlyVO> getExpensesMontlyList()
			throws OMIApplicationException {
		ArrayList<ExpensesMonthlyVO> expensesMonthlyList = new ArrayList<ExpensesMonthlyVO>();
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_EXPENSES_M0NTHLY_GIRD_LIST);
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {
					ExpensesMonthlyVO expensesMonthlyVO = new ExpensesMonthlyVO();
					expensesMonthlyVO.setMonthlyClaimId(resultSet
							.getInt("MONTHLI_CLAIM_ID"));
					expensesMonthlyVO.setName(resultSet.getString("NAME"));
					expensesMonthlyVO.setClaimedBalance(resultSet
							.getString("CLAIMED_BALANCE"));
					System.out.println("Claimed Balance :: "
							+ resultSet.getString("CLAIMED_BALANCE"));
					expensesMonthlyVO.setClaimStatus(ExpensesClaimStatus
							.getExpensesClaimStatus(resultSet
									.getInt("CLAIM_STATUS")));
					expensesMonthlyVO.setDepartureDate(resultSet
							.getString("DEPARTURE_DATE"));
					expensesMonthlyVO.setArrivalDate(resultSet
							.getString("ARRIVAL_DATE"));
					expensesMonthlyVO.setApprovedBy(nameHelper
							.getAssignTo(resultSet.getInt("APPROVED_BY")));
					expensesMonthlyList.add(expensesMonthlyVO);

				}
			}
		} catch (SQLException sqlExp) {
			sqlExp.printStackTrace();
			logger.error(
					ExpensesMonthlyDaoImpl.class
							+ "Error: Occur in Query While Fetching the FAQ Details into Grid from Database.",
					sqlExp);
		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					ExpensesMonthlyDaoImpl.class
							+ "Error: Occur in Query While Closing Connection After Fetching the FAQ Details into Grid from Database.",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return expensesMonthlyList;

	}

	/**
	 * <p>
	 * <code>calculateOtherAmountB(ExpensesMonthlyVO)</code> method use to
	 * insert addMonthlyOtherExpensess into TAB_EXPENSES_MONTHLY_TRAVEL
	 * </p>
	 * 
	 * @param ExpensesMonthlyVO
	 * @return target
	 * @throws Exception
	 */
	@Override
	public ExpensesMonthlyVO calculateOtherAmountB(
			ExpensesMonthlyVO expensesMonthlyVO) throws OMIApplicationException {
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.CALCULATE_OTHER_AMOUNT_B);
			preparedStatement.setString(1, LoginUtil.getProcessUserGuidId());
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				expensesMonthlyVO = new ExpensesMonthlyVO();
				expensesMonthlyVO.setTotalAmountB(resultSet
						.getFloat("CALCULATE_OTHER_AMOUNT_B"));
			}
		} catch (SQLException sqlExp) {
			sqlExp.printStackTrace();
			logger.error(ExpensesDaoImpl.class
					+ "Error: Occur in Query While Calculating Amount Of B.",
					sqlExp);
		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					ExpensesDaoImpl.class
							+ "Error: Occur in Query While Closing Connection After Fetching  Calculating Amount Of B.",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return expensesMonthlyVO;

	}

	/**
	 * <p>
	 * <code>monthlyOtherList(ExpensesMonthlyVO)</code> method use to insert
	 * addMonthlyOtherExpensess into TAB_EXPENSES_MONTHLY_TRAVEL
	 * </p>
	 * 
	 * @param ExpensesMonthlyVO
	 * @return target
	 * @throws Exception
	 */
	public List<ExpensesMonthlyVO> monthlyOtherList()
			throws OMIApplicationException {
		ArrayList<ExpensesMonthlyVO> monthlyOtherList = new ArrayList<ExpensesMonthlyVO>();
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.SHOW_LIST_OTHER_MONTHLY_DETAILS);
			preparedStatement.setString(1,
					expensesMonthlyVO.getMonthlyOtherRefNo());
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {
					expensesMonthlyVO = new ExpensesMonthlyVO();
					expensesMonthlyVO.setOtherClaimId(resultSet
							.getInt("OTHER_CLAIM_ID"));
					System.out.println("-------------------"
							+ resultSet.getInt("OTHER_CLAIM_ID"));
					expensesMonthlyVO.setDateAndTime(resultSet
							.getString("DATE_AND_TIME"));
					System.out.println("aaaaaaaaaaa "
							+ resultSet.getString("DATE_AND_TIME"));
					expensesMonthlyVO.setPlace(resultSet.getString("PLACE"));
					expensesMonthlyVO.setItems(resultSet.getString("ITME"));
					expensesMonthlyVO.setAmount(resultSet.getString("AMOUNT"));
					monthlyOtherList.add(expensesMonthlyVO);
				}
			}
		} catch (SQLException sqlExp) {
			sqlExp.printStackTrace();
			logger.error(
					ExpensesDaoImpl.class
							+ "Error: Occur in Query While Fetching Other Expenses Details from Database.",
					sqlExp);
		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					ExpensesDaoImpl.class
							+ "Error: Occur in Query While Closing Connection After Fetching Other Expenses Details from Database.",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return monthlyOtherList;

	}

	/**
	 * <p>
	 * <code>getExpensesDetails(ExpensesMonthlyVO)</code> method use to insert
	 * assignment details into TAB_ASSIGNMENT table.
	 * </p>
	 * 
	 * @param ExpensesMonthlyVO
	 * @return target
	 * @throws OMIApplicationException
	 */
	@Override
	public ExpensesMonthlyVO getExpensesDetails(int monthlyClaimId)
			throws OMIApplicationException {
		expensesMonthlyVO = new ExpensesMonthlyVO();
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.VIEW_CLAIM_EXPENSES_MONTHLY_DETAILS);
			preparedStatement.setInt(1, monthlyClaimId);
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {

					expensesMonthlyVO.setMonthlyClaimId(resultSet
							.getInt("MONTHLI_CLAIM_ID"));
					expensesMonthlyVO.setName(resultSet.getString("NAME"));

					System.out.println("********************************"
							+ resultSet.getString("NAME"));

					expensesMonthlyVO.setPlaceOfVisit(resultSet
							.getString("PLACE_OF_VISIT"));
					System.out.println("*************************"
							+ resultSet.getString("PLACE_OF_VISIT"));
					expensesMonthlyVO.setPurposeOfVisit(resultSet
							.getString("PURPOSE_OF_VISIT"));
					System.out.println("************************"
							+ resultSet.getString("PURPOSE_OF_VISIT"));

					expensesMonthlyVO.setDepartureDate(resultSet
							.getString("DEPARTURE_DATE"));
					expensesMonthlyVO.setArrivalDate(resultSet
							.getString("ARRIVAL_DATE"));
					expensesMonthlyVO.setApprovedBy(nameHelper
							.getAssignTo(resultSet.getInt("APPROVED_BY")));
					expensesMonthlyVO.setTotalAmountA(resultSet
							.getInt("TOTAL_AMOUNT_A"));
					expensesMonthlyVO.setTotalAmountB(resultSet
							.getInt("TOTAL_AMOUNT_B"));
					expensesMonthlyVO.setAdvanceAmountC(resultSet
							.getInt("ADVANCE_AMOUNT_C"));
					expensesMonthlyVO.setClaimedBalance(resultSet
							.getString("CLAIMED_BALANCE"));
					expensesMonthlyVO.setClaimBy(resultSet.getInt("CLAIM_BY"));
					expensesMonthlyVO.setClaimStatus(ExpensesClaimStatus
							.getExpensesClaimStatus(resultSet
									.getInt("CLAIM_STATUS")));

				}
			}
		} catch (SQLException sqlExp) {
			sqlExp.printStackTrace();
			logger.error(
					ExpensesDaoImpl.class
							+ "Error: Occur in Query While Fetching Claim Expenses  Details from Database.",
					sqlExp);
		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					ExpensesDaoImpl.class
							+ "Error: Occur in Query While Closing Connection After Fetching Claim Expenses Details from Database.",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}

		return expensesMonthlyVO;
	}

	/**
	 * <p>
	 * <code>viewMonthlyTravelListById(ExpensesMonthlyVO)</code> method use to
	 * insert TravelMonthliList details into TAB_ASSIGNMENT table.
	 * </p>
	 * 
	 * @param ExpensesMonthlyVO
	 * @return target
	 * @throws OMIApplicationException
	 */
	@Override
	public List<ExpensesMonthlyVO> viewMonthlyTravelListById(
			ExpensesMonthlyVO expensesMonthlyVO, int monthlyClaimId)
			throws OMIApplicationException {

		ArrayList<ExpensesMonthlyVO> monthlyTravelListById = new ArrayList<ExpensesMonthlyVO>();
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.VIEW_LIST_TRAVEL_DETAILS_BY_ID);
			preparedStatement.setInt(1, monthlyClaimId);
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {
					expensesMonthlyVO = new ExpensesMonthlyVO();
					expensesMonthlyVO.setTravelClaimId(resultSet
							.getInt("TRAVEL_CLAIM_ID"));

					expensesMonthlyVO.setDeparturePlace(resultSet
							.getString("DEPARTURE_PLACE"));
					System.out.println("*******"
							+ resultSet.getString("DEPARTURE_PLACE"));
					expensesMonthlyVO.setDepartureDate(resultSet
							.getString("DEPARTURE_DATE"));
					System.out.println("*******"
							+ resultSet.getString("DEPARTURE_DATE"));
					expensesMonthlyVO.setFromPlace(resultSet
							.getString("FROM_PLACE"));
					System.out.println("*******"
							+ resultSet.getString("FROM_PLACE"));
					expensesMonthlyVO.setToPlace(resultSet
							.getString("TO_PLACE"));
					System.out.println("*******"
							+ resultSet.getString("TO_PLACE"));
					expensesMonthlyVO.setTravelMode(resultSet
							.getString("TRAVEL_MODE"));
					System.out.println("*******"
							+ resultSet.getString("TRAVEL_MODE"));
					expensesMonthlyVO.setAmount(resultSet.getString("AMOUNT"));
					System.out.println("*******"
							+ resultSet.getString("AMOUNT"));
					monthlyTravelListById.add(expensesMonthlyVO);
				}
			}
		} catch (SQLException sqlExp) {
			sqlExp.printStackTrace();
			logger.error(
					ExpensesDaoImpl.class
							+ "Error: Occur in Query While Fetching Tour Expenses Details from Database.",
					sqlExp);
		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					ExpensesDaoImpl.class
							+ "Error: Occur in Query While Closing Connection After Fetching Tour Expenses Details from Database.",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return monthlyTravelListById;
	}

	/**
	 * <p>
	 * <code>viewMonthlyOtherlListById(ExpensesMonthlyVO)</code> method use to
	 * insert OtherMonthliList details into TAB_Expenses_monthly_treavel table.
	 * </p>
	 * 
	 * @param ExpensesMonthlyVO
	 * @return target
	 * @throws OMIApplicationException
	 */
	public List<ExpensesMonthlyVO> viewMonthlyOtherlListById(
			ExpensesMonthlyVO expensesMonthlyVO, int monthlyClaimId)
			throws OMIApplicationException {

		ArrayList<ExpensesMonthlyVO> monthlyOtherListById = new ArrayList<ExpensesMonthlyVO>();
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.VIEW_LIST_OTHER_DETAILS_BY_ID);
			preparedStatement.setInt(1, monthlyClaimId);
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {
					expensesMonthlyVO = new ExpensesMonthlyVO();
					expensesMonthlyVO.setOtherClaimId(resultSet
							.getInt("OTHER_CLAIM_ID"));

					expensesMonthlyVO.setDateAndTime(resultSet
							.getString("DATE_AND_TIME"));

					expensesMonthlyVO.setPlace(resultSet.getString("PLACE"));
					expensesMonthlyVO.setItems(resultSet.getString("ITME"));
					expensesMonthlyVO.setAmount(resultSet.getString("AMOUNT"));

					monthlyOtherListById.add(expensesMonthlyVO);
				}
			}
		} catch (SQLException sqlExp) {
			sqlExp.printStackTrace();
			logger.error(
					ExpensesDaoImpl.class
							+ "Error: Occur in Query While Fetching Tour Expenses Details from Database.",
					sqlExp);
		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					ExpensesDaoImpl.class
							+ "Error: Occur in Query While Closing Connection After Fetching Tour Expenses Details from Database.",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return monthlyOtherListById;
	}

	/**
	 * <p>
	 * <code>monthlyTravelList()</code> method use to fetch monthlyTravelList
	 * from database.
	 * </p>
	 * 
	 * @param expensesMonthlyVO
	 * 
	 * @return monthlyTravelList
	 */

	public List<ExpensesMonthlyVO> monthlyTravelList(
			ExpensesMonthlyVO expensesMonthlyVO) throws OMIApplicationException {
		ArrayList<ExpensesMonthlyVO> monthlyTravelList = new ArrayList<ExpensesMonthlyVO>();
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.SHOW_LIST_TRAVEL_MONTHLY_DETAILS);
			preparedStatement.setString(1,
					expensesMonthlyVO.getMonthlyTravelRefNo());
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {
					expensesMonthlyVO = new ExpensesMonthlyVO();
					expensesMonthlyVO.setTravelClaimId(resultSet
							.getInt("TRAVEL_CLAIM_ID"));

					expensesMonthlyVO.setDeparturePlace(resultSet
							.getString("DEPARTURE_PLACE"));
					System.out.println("aaaaaaaaaaa "
							+ resultSet.getString("DEPARTURE_PLACE"));
					expensesMonthlyVO.setDepartureDate(resultSet
							.getString("DEPARTURE_DATE"));
					expensesMonthlyVO.setFromPlace(resultSet
							.getString("FROM_PLACE"));
					expensesMonthlyVO.setToPlace(resultSet
							.getString("TO_PLACE"));
					expensesMonthlyVO.setTravelMode(resultSet
							.getString("TRAVEL_MODE"));
					expensesMonthlyVO.setAmount(resultSet.getString("AMOUNT"));
					monthlyTravelList.add(expensesMonthlyVO);
				}
			}
		} catch (SQLException sqlExp) {
			sqlExp.printStackTrace();
			logger.error(
					ExpensesDaoImpl.class
							+ "Error: Occur in Query While Fetching Tour Expenses Details from Database.",
					sqlExp);
		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					ExpensesDaoImpl.class
							+ "Error: Occur in Query While Closing Connection After Fetching Tour Expenses Details from Database.",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return monthlyTravelList;

	}

	/**
	 * <p>
	 * <code>showTravelExpensesList(ExpensesMonthlyVO)</code> method use to
	 * insert showTravelExpensesList details into TAB_Expenses_monthly_treavel
	 * table.
	 * </p>
	 * 
	 * @param ExpensesMonthlyVO
	 * @return target
	 * @throws OMIApplicationException
	 */
	public List<ExpensesMonthlyVO> showTravelExpensesList()
			throws OMIApplicationException {

		ArrayList<ExpensesMonthlyVO> monthlyTravelList = new ArrayList<ExpensesMonthlyVO>();
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_MONTHLY_TRAVEL_GIRD_LIST);
			preparedStatement.setString(1,
					expensesMonthlyVO.getMonthlyTravelRefNo());
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {
					expensesMonthlyVO = new ExpensesMonthlyVO();
					expensesMonthlyVO.setMonthlyClaimId(resultSet
							.getInt("TRAVEL_CLAIM_ID"));
					expensesMonthlyVO.setDeparturePlace(resultSet
							.getString("DEPARTURE_PLACE"));
					expensesMonthlyVO.setDepartureDate(resultSet
							.getString("DEPARTURE_DATE"));
					expensesMonthlyVO.setFromPlace(resultSet
							.getString("FROM_PLACE"));
					expensesMonthlyVO.setToPlace(resultSet
							.getString("TO_PLACE"));
					expensesMonthlyVO.setTravelMode(resultSet
							.getString("TRAVEL_MODE"));
					expensesMonthlyVO.setAmount(resultSet.getString("AMOUNT"));

					monthlyTravelList.add(expensesMonthlyVO);

				}
			}
		} catch (SQLException sqlExp) {
			sqlExp.printStackTrace();
			logger.error(
					ExpensesMonthlyDaoImpl.class
							+ "Error: Occur in Query While Fetching the FAQ Details into Grid from Database.",
					sqlExp);
		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					ExpensesMonthlyDaoImpl.class
							+ "Error: Occur in Query While Closing Connection After Fetching the FAQ Details into Grid from Database.",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return monthlyTravelList;
	}

	/**
	 * <p>
	 * <code>calculateTravelAmountA(ExpensesMonthlyVO)</code> method use to
	 * insert calculateTravelAmountA details into TAB_Expenses_monthly_treavel
	 * table.
	 * </p>
	 * 
	 * @param ExpensesMonthlyVO
	 * @return target
	 * @throws OMIApplicationException
	 */
	public ExpensesMonthlyVO calculateTravelAmountA(
			ExpensesMonthlyVO expensesMonthlyVO) throws OMIApplicationException {
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.CALCULATE_TRAVEL_AMOUNT_A);
			preparedStatement.setString(1, LoginUtil.getProcessUserGuidId());
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				expensesMonthlyVO = new ExpensesMonthlyVO();
				expensesMonthlyVO.setTotalAmountA(resultSet
						.getFloat("CALCULATE_AMOUNT_A"));
			}
		} catch (SQLException sqlExp) {
			sqlExp.printStackTrace();
			logger.error(ExpensesDaoImpl.class
					+ "Error: Occur in Query While Calculating Amount Of A.",
					sqlExp);
		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					ExpensesDaoImpl.class
							+ "Error: Occur in Query While Closing Connection After Fetching  Calculating Amount Of A.",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return expensesMonthlyVO;
	}

	@Override
	public int addTravelDetails(ExpensesMonthlyVO expensesMonthlyVO)
			throws OMIApplicationException {
		int target = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = QueryMaker.ADD_TRAVEL_INFO;
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1,
					expensesMonthlyVO.getDeparturePlace());
			preparedStatement
					.setString(2, expensesMonthlyVO.getDepartureDate());
			preparedStatement.setString(3, expensesMonthlyVO.getFromPlace());
			preparedStatement.setString(4, expensesMonthlyVO.getToPlace());
			preparedStatement.setString(5, expensesMonthlyVO.getTravelMode());
			preparedStatement.setString(6, expensesMonthlyVO.getAmount());
			preparedStatement.setInt(7, expensesMonthlyVO.getCreatedBy());
			preparedStatement.setString(8,
					expensesMonthlyVO.getMonthlyTravelRefNo());
			preparedStatement.executeUpdate();
			target = 1;
		} catch (SQLException sqlExp) {
			sqlExp.printStackTrace();
			logger.error(
					ExpensesDaoImpl.class
							+ "Error: Occur in Query While Inserting Tour Details into Database.",
					sqlExp);
		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					ExpensesDaoImpl.class
							+ "Error: Occur in Query While Closing Connection After Inserting Tour Details into Database.",
					exception);
		} finally {

			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return target;

	}

	/**
	 * <p>
	 * <code>getMontlyTravelList()</code> method use to fetching Expenses
	 * monthly travel details from TAB_EXPENSES_MONTHLY_TRAVEL table.
	 * </p>
	 * 
	 * 
	 * @return monthlyTravelList
	 * @throws Exception
	 *             OMIApplicationException
	 */
	public List<ExpensesMonthlyVO> getMontlyTravelList(
			ExpensesMonthlyVO expensesMonthlyVO) throws OMIApplicationException {
		ArrayList<ExpensesMonthlyVO> monthlyTravelList = new ArrayList<ExpensesMonthlyVO>();
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_MONTHLY_TRAVEL_GIRD_LIST);
			preparedStatement.setString(1, LoginUtil.getProcessUserGuidId());
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {
					expensesMonthlyVO = new ExpensesMonthlyVO();
					expensesMonthlyVO.setMonthlyClaimId(resultSet
							.getInt("TRAVEL_CLAIM_ID"));
					expensesMonthlyVO.setDeparturePlace(resultSet
							.getString("DEPARTURE_PLACE"));
					expensesMonthlyVO.setDepartureDate(resultSet
							.getString("DEPARTURE_DATE"));
					expensesMonthlyVO.setFromPlace(resultSet
							.getString("FROM_PLACE"));
					expensesMonthlyVO.setToPlace(resultSet
							.getString("TO_PLACE"));
					expensesMonthlyVO.setTravelMode(nameHelper
							.getTravelMode(resultSet.getInt("TRAVEL_MODE")));
					expensesMonthlyVO.setAmount(resultSet.getString("AMOUNT"));
					monthlyTravelList.add(expensesMonthlyVO);

				}
			}
		} catch (SQLException sqlExp) {
			sqlExp.printStackTrace();
			logger.error(
					ExpensesMonthlyDaoImpl.class
							+ "Error: Occur in Query While Fetching the FAQ Details into Grid from Database.",
					sqlExp);
		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					ExpensesMonthlyDaoImpl.class
							+ "Error: Occur in Query While Closing Connection After Fetching the FAQ Details into Grid from Database.",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return monthlyTravelList;
	}

	/**
	 * <p>
	 * <code>updateExpensesTravelDetails(ExpensesMonthlyVO)</code> method use to
	 * insert updateExpensesTravelDetails details into databases.
	 * </p>
	 * 
	 * @param ExpensesMonthlyVO
	 * @return target
	 * @throws OMIApplicationException
	 */
	public int updateExpensesTravelDetails(ExpensesMonthlyVO expensesMonthlyVO,
			int monthlyClaimId) throws OMIApplicationException {

		int target = 0;

		try {

			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.UPDATE_EXPENSES_MONTHLY_DETAILS);
			preparedStatement.setString(1, expensesMonthlyVO.getName());
			preparedStatement.setString(2, expensesMonthlyVO.getPlaceOfVisit());
			preparedStatement.setString(3,
					expensesMonthlyVO.getPurposeOfVisit());
			preparedStatement
					.setString(4, expensesMonthlyVO.getDepartureDate());
			preparedStatement.setString(5, expensesMonthlyVO.getArrivalDate());
			preparedStatement.setString(6, expensesMonthlyVO.getApprovedBy());
			preparedStatement.setFloat(7, expensesMonthlyVO.getTotalAmountA());
			preparedStatement.setFloat(8, expensesMonthlyVO.getTotalAmountB());
			preparedStatement.setString(9, expensesMonthlyVO.getClaimStatus());
			preparedStatement.setString(10, expensesMonthlyVO.getComment());
			preparedStatement.setInt(11, monthlyClaimId);
			System.out.println("Claim Id Is ::  " + monthlyClaimId);
			preparedStatement.executeUpdate();
			target = 1;
		} catch (SQLException sqlExp) {
			sqlExp.printStackTrace();
			logger.error(
					ExpensesDaoImpl.class
							+ "Error: Occur in Query While Inserting Expenses Details into Database.",
					sqlExp);
		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					ExpensesDaoImpl.class
							+ "Error: Occur in Query While Closing Connection After Inserting Expenses Details into Database.",
					exception);
		} finally {
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return target;

	}

	/**
	 * <p>
	 * <code>showTravelExpensestListById(ExpensesMonthlyVO)</code> method use to
	 * insert showTravelExpensestListById details into databases.
	 * </p>
	 * 
	 * @param ExpensesMonthlyVO
	 * @return target
	 * @throws OMIApplicationException
	 */
	public List<ExpensesMonthlyVO> showTravelExpensestListById(
			ExpensesMonthlyVO expensesMonthlyVO, int monthlyClaimId)
			throws OMIApplicationException {
		ArrayList<ExpensesMonthlyVO> TravelExpensestListById = new ArrayList<ExpensesMonthlyVO>();
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.SHOW_LIST_TRAVEL_DETAILS_BY_ID);
			preparedStatement.setInt(1, monthlyClaimId);
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {
					expensesMonthlyVO = new ExpensesMonthlyVO();
					expensesMonthlyVO.setTravelClaimId(resultSet
							.getInt("TRAVEL_CLAIM_ID"));

					expensesMonthlyVO.setDeparturePlace(resultSet
							.getString("DEPARTURE_PLACE"));
					expensesMonthlyVO.setDepartureDate(resultSet
							.getString("DEPARTURE_DATE"));
					;
					expensesMonthlyVO.setTravelMode(resultSet
							.getString("TRAVEL_MODE"));
					expensesMonthlyVO.setFromPlace(resultSet
							.getString("FROM_PLACE"));
					expensesMonthlyVO.setToPlace(resultSet
							.getString("TO_PLACE"));
					expensesMonthlyVO.setAmount(resultSet.getString("AMOUNT"));
					TravelExpensestListById.add(expensesMonthlyVO);
				}
			}
		} catch (SQLException sqlExp) {
			sqlExp.printStackTrace();
			logger.error(
					ExpensesDaoImpl.class
							+ "Error: Occur in Query While Fetching Tour Expenses Details from Database.",
					sqlExp);
		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					ExpensesDaoImpl.class
							+ "Error: Occur in Query While Closing Connection After Fetching Tour Expenses Details from Database.",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return TravelExpensestListById;
	}

	/**
	 * <p>
	 * <code>showOtherExpensesListById(ExpensesMonthlyVO)</code> method use to
	 * insert showOtherExpensesListById details into databases.
	 * </p>
	 * 
	 * @param ExpensesMonthlyVO
	 * @return target
	 * @throws OMIApplicationException
	 */
	public List<ExpensesMonthlyVO> showOtherExpensesListById(
			ExpensesMonthlyVO expensesMonthlyVO, int monthlyClaimId)
			throws OMIApplicationException {
		ArrayList<ExpensesMonthlyVO> OtherExpensestListById = new ArrayList<ExpensesMonthlyVO>();
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.SHOW_LIST_OTHER_DETAILS_BY_ID);
			preparedStatement.setInt(1, monthlyClaimId);
			System.out.println("Claim Id is ::::" + monthlyClaimId);
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {
					expensesMonthlyVO = new ExpensesMonthlyVO();
					expensesMonthlyVO.setOtherClaimId(resultSet
							.getInt("OTHER_CLAIM_ID"));

					expensesMonthlyVO.setDateAndTime(resultSet
							.getString("DATE_AND_TIME"));

					expensesMonthlyVO.setPlace(resultSet.getString("PLACE"));
					expensesMonthlyVO.setItems(resultSet.getString("ITME"));
					expensesMonthlyVO.setAmount(resultSet.getString("AMOUNT"));
					OtherExpensestListById.add(expensesMonthlyVO);
				}
			}
		} catch (SQLException sqlExp) {
			sqlExp.printStackTrace();
			logger.error(
					ExpensesDaoImpl.class
							+ "Error: Occur in Query While Fetching Tour Expenses Details from Database.",
					sqlExp);
		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					ExpensesDaoImpl.class
							+ "Error: Occur in Query While Closing Connection After Fetching Tour Expenses Details from Database.",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return OtherExpensestListById;
	}

	/**
	 * <p>
	 * <code>getExpensesMonthlyDetails(ExpensesMonthlyVO)</code> method use to
	 * insert getExpensesMonthlyDetails details into databases.
	 * </p>
	 * 
	 * @param ExpensesMonthlyVO
	 * @return target
	 * @throws OMIApplicationException
	 */
	public ExpensesMonthlyVO getExpensesMonthlyDetails(int monthlyClaimId)
			throws OMIApplicationException {

		expensesMonthlyVO = new ExpensesMonthlyVO();
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.EDIT_CLAIM_EXPENSES_MONTHLY_DETAILS);
			preparedStatement.setInt(1, monthlyClaimId);
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {

					expensesMonthlyVO.setMonthlyClaimId(resultSet
							.getInt("MONTHLI_CLAIM_ID"));
					expensesMonthlyVO.setName(resultSet.getString("NAME"));
					expensesMonthlyVO.setPlaceOfVisit(resultSet
							.getString("PLACE_OF_VISIT"));
					expensesMonthlyVO.setPurposeOfVisit(resultSet
							.getString("PURPOSE_OF_VISIT"));
					expensesMonthlyVO.setDepartureDate(resultSet
							.getString("DEPARTURE_DATE"));
					expensesMonthlyVO.setArrivalDate(resultSet
							.getString("ARRIVAL_DATE"));
					expensesMonthlyVO.setApprovedBy(resultSet
							.getString("APPROVED_BY"));
					expensesMonthlyVO.setTotalAmountA(resultSet
							.getInt("TOTAL_AMOUNT_A"));
					expensesMonthlyVO.setTotalAmountB(resultSet
							.getInt("TOTAL_AMOUNT_B"));
					expensesMonthlyVO.setAdvanceAmountC(resultSet
							.getInt("ADVANCE_AMOUNT_C"));
					expensesMonthlyVO.setClaimedBalance(resultSet
							.getString("CLAIMED_BALANCE"));
					expensesMonthlyVO.setClaimBy(resultSet.getInt("CLAIM_BY"));
					expensesMonthlyVO.setClaimStatus(resultSet
							.getString("CLAIM_STATUS"));
					expensesMonthlyVO.setComment(resultSet
							.getString("CLAIM_COMMENT"));

				}
			}
		} catch (SQLException sqlExp) {
			sqlExp.printStackTrace();
			logger.error(
					ExpensesDaoImpl.class
							+ "Error: Occur in Query While Fetching Claim Expenses  Details from Database.",
					sqlExp);
		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					ExpensesDaoImpl.class
							+ "Error: Occur in Query While Closing Connection After Fetching Claim Expenses Details from Database.",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}

		return expensesMonthlyVO;
	}

	/**
	 * <p>
	 * <code>viewMonthlyOtherListById(ExpensesMonthlyVO)</code> method use to
	 * insert viewMonthlyOtherListById details into databases.
	 * </p>
	 * 
	 * @param ExpensesMonthlyVO
	 * @return target
	 * @throws OMIApplicationException
	 */
	public List<ExpensesMonthlyVO> viewMonthlyOtherListById(
			ExpensesMonthlyVO expensesMonthlyVO, int monthlyClaimId) {

		ArrayList<ExpensesMonthlyVO> monthlyOtherListById = new ArrayList<ExpensesMonthlyVO>();
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.VIEW_LIST_Other_DETAILS_BY_ID);
			preparedStatement.setInt(1, monthlyClaimId);
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {
					expensesMonthlyVO = new ExpensesMonthlyVO();
					expensesMonthlyVO.setOtherClaimId(resultSet
							.getInt("OTHER_CLAIM_ID"));

					expensesMonthlyVO.setDateAndTime(resultSet
							.getString("DATE_AND_TIME"));
					System.out.println("*******"
							+ resultSet.getString("DATE_AND_TIME"));
					expensesMonthlyVO.setPlace(resultSet.getString("PLACE"));
					System.out
							.println("*******" + resultSet.getString("PLACE"));
					expensesMonthlyVO.setFromPlace(resultSet.getString("ITME"));
					System.out.println("*******" + resultSet.getString("ITME"));
					expensesMonthlyVO.setToPlace(resultSet.getString("AMOUNT"));
					System.out.println("*******"
							+ resultSet.getString("AMOUNT"));
					monthlyOtherListById.add(expensesMonthlyVO);
				}
			}
		} catch (SQLException sqlExp) {
			sqlExp.printStackTrace();
			logger.error(
					ExpensesDaoImpl.class
							+ "Error: Occur in Query While Fetching Tour Expenses Details from Database.",
					sqlExp);
		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					ExpensesDaoImpl.class
							+ "Error: Occur in Query While Closing Connection After Fetching Tour Expenses Details from Database.",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return monthlyOtherListById;
	}

	@Override
	public List<ExpensesMonthlyVO> getOtherTravelList(
			ExpensesMonthlyVO expensesMonthlyVO) throws OMIApplicationException {
		ArrayList<ExpensesMonthlyVO> otherTravelList = new ArrayList<ExpensesMonthlyVO>();
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.SHOW_LIST_OTHER_MONTHLY_DETAILS);
			preparedStatement.setString(1, LoginUtil.getProcessUserGuidId());
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {
					expensesMonthlyVO = new ExpensesMonthlyVO();
					expensesMonthlyVO.setOtherClaimId(resultSet
							.getInt("OTHER_CLAIM_ID"));
					expensesMonthlyVO.setDateAndTime(resultSet
							.getString("DATE_AND_TIME"));
					expensesMonthlyVO.setPlace(resultSet.getString("PLACE"));
					expensesMonthlyVO.setItems(resultSet.getString("ITME"));
					expensesMonthlyVO.setAmount(resultSet.getString("AMOUNT"));
					otherTravelList.add(expensesMonthlyVO);

				}
			}
		} catch (SQLException sqlExp) {
			sqlExp.printStackTrace();
			logger.error(
					ExpensesMonthlyDaoImpl.class
							+ "Error: Occur in Query While Fetching the FAQ Details into Grid from Database.",
					sqlExp);
		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					ExpensesMonthlyDaoImpl.class
							+ "Error: Occur in Query While Closing Connection After Fetching the FAQ Details into Grid from Database.",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return otherTravelList;
	}

	/*---------------------------------------------------------------------------------*/
	@Override
	public List<ExpensesMonthlyVO> monthlyTravelList()
			throws OMIApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ExpensesMonthlyVO> getMontlyOtherList()
			throws OMIApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getMonthlyExpensesId(ExpensesMonthlyVO expensesMonthlyVO)
			throws OMIApplicationException {
		int target = 0;
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_MONTHLY_EXPENSES_ID);
			preparedStatement.setString(1, LoginUtil.getProcessUserGuidId());
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				if (resultSet.next()) {
					expensesMonthlyVO.setMonthlyId(resultSet
							.getInt("MONTHLI_CLAIM_ID"));
					target = 1;
				}
			}

		} catch (SQLException sqlExp) {
			sqlExp.printStackTrace();
			logger.error(
					ExpensesDaoImpl.class
							+ "Error: Occur in Query While Fetching  Monthly Claim Id from Database.",
					sqlExp);
		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					ExpensesDaoImpl.class
							+ "Error: Occur in Query While Closing Connection After Fetching Monthly Claim Idfrom Database.",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}

		return target;

	}

	/**
	 * TAB_EXPENSES_MONTHLY_OTHER
	 */
	@Override
	public int insertMonthlyClaimId(ExpensesMonthlyVO expensesMonthlyVO)
			throws OMIApplicationException {

		int target = 0;
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.ADD_MONTHLY_CLAIM_ID);
			preparedStatement.setInt(1, expensesMonthlyVO.getMonthlyId());
			preparedStatement.setString(2, LoginUtil.getProcessUserGuidId());
			preparedStatement.executeUpdate();
			target = 1;
		} catch (SQLException sqlExp) {
			sqlExp.printStackTrace();
			logger.error(
					ExpensesDaoImpl.class
							+ "Error: Occur in Query While Insert Claim Id into Database.",
					sqlExp);
		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					ExpensesDaoImpl.class
							+ "Error: Occur in Query While Closing Connection After Insert Claim Id into Database.",
					exception);
		} finally {

			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return target;

	}

	/**
	 * TAB_EXPENSES_MONTHLY_TRAVEL
	 */
	@Override
	public int insertMonthlyBoardingClaimId(ExpensesMonthlyVO expensesMonthlyVO)
			throws OMIApplicationException {

		int target = 0;
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.ADD_MONTHYL_OTHER_CLAIM_ID);
			preparedStatement.setInt(1, expensesMonthlyVO.getMonthlyId());
			preparedStatement.setString(2, LoginUtil.getProcessUserGuidId());
			preparedStatement.executeUpdate();
			target = 1;
		} catch (SQLException sqlExp) {
			sqlExp.printStackTrace();
			logger.error(
					ExpensesDaoImpl.class
							+ "Error: Occur in Query While Insert Claim Id into Database.",
					sqlExp);
		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					ExpensesDaoImpl.class
							+ "Error: Occur in Query While Closing Connection After Insert Claim Id into Database.",
					exception);
		} finally {

			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return target;

	}

	@Override
	public int getMonthlyExpensesLastRecord() throws OMIApplicationException {

		int target = 0;
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_LAST_MONTHLY_CLAIM__ID);
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {

					target = resultSet.getInt("MONTHLI_CLAIM_ID");

				}
			}
		} catch (SQLException sqlException) {

			logger.error(
					ProductDaoImpl.class
							+ ": Error:- Error: Occur in Query While counting the Monthly Expenses recodes from Database",
					sqlException);

		} catch (Exception exception) {

			logger.error(
					ProductDaoImpl.class
							+ ": Error:- While closing the Connection after counting the Monthly Expenses recodes from Database",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return target;
	}

}
