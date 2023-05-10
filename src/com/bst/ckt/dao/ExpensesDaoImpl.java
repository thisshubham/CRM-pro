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

import com.bst.ckt.common.QueryMaker;
import com.bst.ckt.exception.OMIApplicationException;
import com.bst.ckt.framework.db.JdbcDAOSupport;
import com.bst.ckt.framework.db.JdbcHelper;
import com.bst.ckt.framework.util.DateTimeUtil;
import com.bst.ckt.helper.ExpensesClaimStatus;
import com.bst.ckt.helper.NameHelper;
import com.bst.ckt.vo.ExpensesVO;

/**
 * @author Deepak Vishwakarma
 * 
 */
public class ExpensesDaoImpl extends JdbcDAOSupport implements ExpensesDaoInf {

	/**
	 * Creating Logger object, logger object mapped with LeadDaoImpl class for
	 * writing Loggers.
	 */
	public static final Logger logger = Logger.getLogger(ExpensesDaoImpl.class);

	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	NameHelper nameHelper = new NameHelper();
	ExpensesVO expensesVO = null;

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
	@Override
	public int addTourExpensesDetails(ExpensesVO expensesVO)
			throws OMIApplicationException {
		int target = 0;
		try {

			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.INSERT_EXPENSES_DETAILS);
			preparedStatement.setString(1, expensesVO.getName());
			preparedStatement.setString(2, expensesVO.getPlaceOfVisit());
			preparedStatement.setString(3, expensesVO.getPurposeOfVisit());
			preparedStatement.setString(4, expensesVO.getDepartureDate());
			preparedStatement.setString(5, expensesVO.getArrivalDate());
			preparedStatement.setString(6, expensesVO.getTotalAmountA());
			preparedStatement.setString(7, expensesVO.getTotalAmountB());
			preparedStatement.setString(8, expensesVO.getDailyAllowance());
			preparedStatement.setString(9, expensesVO.getConveynanceExD());
			preparedStatement.setString(10, expensesVO.getConveynanceEx());
			preparedStatement.setString(11, expensesVO.getLaundryExpences());
			preparedStatement.setString(12, expensesVO.getGTotal());
			preparedStatement.setString(13, expensesVO.getOneAdvanceReceived());
			preparedStatement.setString(14,
					expensesVO.getTwoTicketBookedByCompany());
			preparedStatement.setString(15,
					expensesVO.getThreeHotelBookedByCompany());
			preparedStatement.setString(16,
					expensesVO.getForthConveyanceExpenses());
			preparedStatement.setString(17,
					expensesVO.getFiveAdvanceReceivedFromOther());
			preparedStatement.setString(18, expensesVO.getHTotalAToF());
			preparedStatement.setString(19, expensesVO.getClaimedBalance());
			preparedStatement.setString(20, expensesVO.getTicketRefNo());
			preparedStatement.setString(21, expensesVO.getApprovedBy());
			preparedStatement.setInt(22, expensesVO.getCreatedBy());
			preparedStatement.setString(23, DateTimeUtil.getCurrentDate());
			preparedStatement.setString(24, expensesVO.getITotalAdvance());
			preparedStatement.setInt(25, expensesVO.getCreatedBy());
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
	 * Method<code>getExpensesId</code> Is Use to Get expenses id based on
	 * refrenceId from database.
	 * </p>
	 * 
	 * @param uniqueId
	 * @return
	 * @throws OMIApplicationException
	 */
	private int getExpensesId() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String sql = QueryMaker.GET_EXPENSES_ID;
		int expeID = 0;
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, expensesVO.getTicketRefNo());
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				if (resultSet.next()) {
					expeID = resultSet.getInt("EXPENSES_ID");
				}
			}
			return expeID;
		} catch (Exception exception) {
			return expeID;
		}

	}

	/**
	 * <p>
	 * Method<code>addTourTicketDetails</code> Is Use to insert tour ticket
	 * details into database.
	 * </p>
	 * 
	 * @param expensesVO
	 * @return
	 * @throws OMIApplicationException
	 */
	@Override
	public int addTourTicketDetails(ExpensesVO expensesVO)
			throws OMIApplicationException {
		int target = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = QueryMaker.ADD_TICKET_INFO;
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, expensesVO.getDeparturePlace());
			preparedStatement.setString(2, expensesVO.getDepartureDate());
			preparedStatement.setString(3, expensesVO.getArrivalPlace());
			preparedStatement.setString(4, expensesVO.getArrivalDate());
			preparedStatement.setString(5, expensesVO.getTravelMode());
			preparedStatement.setString(6, expensesVO.getAmountForA());
			preparedStatement.setInt(7, expensesVO.getCreatedBy());
			preparedStatement.setString(8, expensesVO.getTicketRefNo());
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
	 * <code>showTourTicketList()</code> method use to fetch tour ticket list
	 * from database.
	 * </p>
	 * 
	 * @param expensesVO
	 * 
	 * @return tourTicketList
	 */
	public List<ExpensesVO> showTourTicketList(ExpensesVO expensesVO) {
		ArrayList<ExpensesVO> tourTicketList = new ArrayList<ExpensesVO>();
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.SHOW_LIST_TICKET_DETAILS);
			preparedStatement.setString(1, expensesVO.getTicketRefNo());
			System.out.println("Ticket ref no :: "+expensesVO.getTicketRefNo());
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {
					expensesVO = new ExpensesVO();
					expensesVO.setTicketId(resultSet.getInt("TICKET_ID"));
					expensesVO.setDeparturePlace(resultSet
							.getString("DETARTURE_PLACE"));
					expensesVO.setDepartureDate(resultSet
							.getString("TICKE_DEPARTURE_DATE"));
					expensesVO.setArrivalPlace(resultSet
							.getString("ARRIVAL_PLACE"));
					expensesVO.setArrivalDate(resultSet
							.getString("TICKET_ARRIVAL_DATE"));
					expensesVO
							.setTravelMode(nameHelper.getTravelMode(resultSet
									.getInt("TRAVEL_MODE")));
					expensesVO.setAmountForA(resultSet
							.getString("TICKET_AMOUNT"));
					tourTicketList.add(expensesVO);
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
		return tourTicketList;
	}

	/**
	 * <p>
	 * <code>insertHotelDetail()</code> method use to insert boarding details
	 * into database.
	 * </p>
	 * 
	 * @param expensesVO
	 * 
	 * @return target
	 */
	@Override
	public int insertHotelDetail(ExpensesVO expensesVO)
			throws OMIApplicationException {
		int target = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = QueryMaker.ADD_HOTEL_INFO;
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, expensesVO.getHotel());
			preparedStatement.setString(2, expensesVO.getPlace());
			preparedStatement.setString(3, expensesVO.getFrom());
			preparedStatement.setString(4, expensesVO.getTo());
			preparedStatement.setString(5, expensesVO.getBillNo());
			preparedStatement.setString(6, expensesVO.getHotelAmount());
			preparedStatement.setInt(7, expensesVO.getCreatedBy());
			preparedStatement.setString(8, expensesVO.getBoardingRefNo());
			preparedStatement.executeUpdate();
			target = 1;
		} catch (SQLException sqlExp) {
			sqlExp.printStackTrace();
			logger.error(
					ExpensesDaoImpl.class
							+ "Error: Occur in Query While inserting  Expenses Boarding Details into Database.",
					sqlExp);
		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					ExpensesDaoImpl.class
							+ "Error: Occur in Query While Closing Connection After inserting Bording Details into Database.",
					exception);
		} finally {

			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return target;
	}

	/**
	 * <p>
	 * <code>showBoardingList()</code> method use to fetch boarding details list
	 * from database.
	 * </p>
	 * 
	 * @param expensesVO
	 * 
	 * @return boardingDetailList
	 */
	@Override
	public List<ExpensesVO> showBoardingList(ExpensesVO expensesVO) {
		ArrayList<ExpensesVO> boardingDetailList = new ArrayList<ExpensesVO>();

		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.SHOW_LIST_BOARDING_DETAILS);
			preparedStatement.setString(1, expensesVO.getBoardingRefNo());
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {
					expensesVO = new ExpensesVO();
					expensesVO.setBoardingId(resultSet.getInt("BOARDING_ID"));
					expensesVO.setHotel(resultSet.getString("HOTEL_NAME"));
					expensesVO.setPlace(resultSet.getString("PLACE"));
					expensesVO.setFrom(resultSet.getString("FROM_DATE"));
					expensesVO.setTo(resultSet.getString("TO_DATE"));
					expensesVO.setBillNo(resultSet.getString("BILL_NUMBER"));
					expensesVO.setHotelAmount(resultSet
							.getString("BOARDING_AMOUNT"));
					boardingDetailList.add(expensesVO);
				}
			}
		} catch (SQLException sqlExp) {
			sqlExp.printStackTrace();
			logger.error(
					ExpensesDaoImpl.class
							+ "Error: Occur in Query While Fetching  Expenses Boarding Details from Database.",
					sqlExp);
		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					ExpensesDaoImpl.class
							+ "Error: Occur in Query While Closing Connection After Fetching Bording Details from Database.",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return boardingDetailList;
	}

	/**
	 * <p>
	 * Method<code>calculateAmountA</code> Is Use to calculate Amount of A based
	 * on ref no into database and set into vo and return TotalOf A.
	 * </p>
	 * 
	 * @param expensesVO
	 * @return expensesVO
	 * @throws OMIApplicationException
	 */
	@Override
	public ExpensesVO calculateAmountA(ExpensesVO expensesVO)
			throws OMIApplicationException {

		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.CALCULATE_AMOUNT_A);
			preparedStatement.setString(1, expensesVO.getTicketRefNo());
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				expensesVO = new ExpensesVO();
				expensesVO.setTotalAmountA(resultSet
						.getString("CALCULATE_AMOUNT_A"));
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
		return expensesVO;
	}

	/**
	 * <p>
	 * Method<code>calculateAmountB</code> Is Use to calculate Amount of B based
	 * on ref no into database and set into vo and return TotalOf B.
	 * </p>
	 * 
	 * @param expensesVO
	 * @return expensesVO
	 * @throws OMIApplicationException
	 */
	@Override
	public ExpensesVO calculateAmountB(ExpensesVO expensesVO)
			throws OMIApplicationException {

		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.CALCULATE_AMOUNT_B);
			preparedStatement.setString(1, expensesVO.getBoardingRefNo());
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				expensesVO = new ExpensesVO();
				expensesVO.setTotalAmountB(resultSet
						.getString("CALCULATE_AMOUNT_B"));
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
							+ "Error: Occur in Query While Closing Connection After Fetching Calculating Amount Of B.",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return expensesVO;
	}

	/**
	 * <p>
	 * Method<code>getExpensesId</code> Is Use to fetch exppexnes from
	 * TAB_EXPENSES table based on ref no.
	 * </p>
	 * 
	 * @param expensesVO
	 * @return target
	 * @throws OMIApplicationException
	 */
	@Override
	public int getExpensesId(ExpensesVO expensesVO)
			throws OMIApplicationException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String sql = QueryMaker.GET_EXPENSES_ID;
		int target = 0;
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, expensesVO.getTicketRefNo());
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				if (resultSet.next()) {

					expensesVO.setExpensesId(resultSet.getString("CLAIM_ID"));
					target = 1;
				}
			}

		} catch (SQLException sqlExp) {
			sqlExp.printStackTrace();
			logger.error(
					ExpensesDaoImpl.class
							+ "Error: Occur in Query While Fetching  Expenses Boarding Details from Database.",
					sqlExp);
		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					ExpensesDaoImpl.class
							+ "Error: Occur in Query While Closing Connection After Fetching Bording Details from Database.",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}

		return target;
	}

	/**
	 * <p>
	 * Method<code>insertClaimId</code> Is Use to insert claim id into
	 * TAB_TICKET_EXPENSES.
	 * </p>
	 * 
	 * @param expensesVO
	 * @return target
	 * @throws OMIApplicationException
	 */
	@Override
	public int insertClaimId(ExpensesVO expensesVO)
			throws OMIApplicationException {
		int target = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = QueryMaker.ADD_CLAIM_ID;
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, expensesVO.getExpensesId());
			preparedStatement.setString(2, expensesVO.getTicketRefNo());
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
	 * <p>
	 * Method<code>insertBoardingClaimId</code> Is Use to insert Boarding claim
	 * id into TAB_BOARDING_EXPENSES.
	 * </p>
	 * 
	 * @param expensesVO
	 * @return target
	 * @throws OMIApplicationException
	 */
	@Override
	public int insertBoardingClaimId(ExpensesVO expensesVO)
			throws OMIApplicationException {
		int target = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = QueryMaker.ADD_BOARDING_CLAIM_ID;
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, expensesVO.getExpensesId());
			preparedStatement.setString(2, expensesVO.getTicketRefNo());
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
	 * <p>
	 * Method<code>showClaimedExpensesList</code> Is Use to fetch claim expenses
	 * details from TAB_EXPENSES table and set it into expenses dashboard.
	 * </p>
	 * 
	 * @param expensesVO
	 * @return claimedExpensesList
	 * @throws OMIApplicationException
	 */
	@Override
	public List<ExpensesVO> showClaimedExpensesList()
			throws OMIApplicationException {
		ArrayList<ExpensesVO> claimedExpensesList = new ArrayList<ExpensesVO>();

		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.SHOW_CLAIM_EXPENSES_LIST);

			resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {
					expensesVO = new ExpensesVO();
					expensesVO.setClaimId(resultSet.getInt("CLAIM_ID"));
					expensesVO.setName(resultSet.getString("NAME"));
					expensesVO.setPlaceOfVisit(resultSet
							.getString("PLACE_OF_VISIT"));
					expensesVO.setDepartureDate(resultSet
							.getString("DEPARTURE_DATE"));
					expensesVO.setArrivalDate(resultSet
							.getString("ARRIVAL_DATE"));
					expensesVO.setGrantTotalBalance(resultSet
							.getString("GRANT_TOTAL_BALANCE"));
					expensesVO.setClaimStatus(ExpensesClaimStatus.getExpensesClaimStatus(resultSet.getInt("STATUS")));
					claimedExpensesList.add(expensesVO);
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
		return claimedExpensesList;
	}

	/**
	 * <p>
	 * Method<code>getExpensesDetails</code> Is Use to fetch claim expenses
	 * details from TAB_EXPENSES table and set it into edit expenses page.
	 * </p>
	 * 
	 * @param claimId
	 * @return expensesVO
	 * @throws OMIApplicationException
	 */
	@Override
	public ExpensesVO getExpensesDetails(int claimId)
			throws OMIApplicationException {

		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.SHOW_CLAIM_EXPENSES_DETAILS);
			preparedStatement.setInt(1, claimId);
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {
					expensesVO = new ExpensesVO();
					expensesVO.setClaimId(resultSet.getInt("CLAIM_ID"));
					expensesVO.setName(resultSet.getString("NAME"));
					expensesVO.setPlaceOfVisit(resultSet
							.getString("PLACE_OF_VISIT"));
					expensesVO.setPurposeOfVisit(resultSet
							.getString("PURPOSE_OF_VISIT"));
					expensesVO.setComment(resultSet
							.getString("EXPENSES_COMMENT"));
					expensesVO.setApprovedBy(nameHelper.getAssignTo(resultSet
							.getInt("APPROVED_BY")));
					expensesVO.setClaimStatus(ExpensesClaimStatus.getExpensesClaimStatus(resultSet.getInt("STATUS")));
					expensesVO.setTotalAmountA(resultSet
							.getString("TOTAL_AMOUNT_A"));
					expensesVO.setTotalAmountB(resultSet
							.getString("TOTAL_AMOUNT_B"));
					expensesVO.setDailyAllowance(resultSet
							.getString("C_DAILY_ALLOWANCE"));
					expensesVO.setConveynanceExD(resultSet
							.getString("D_CONVEYANCE_EXPENCES"));
					expensesVO.setConveynanceEx(resultSet
							.getString("E_CONVEYANCE_EXPENCES"));
					expensesVO.setLaundryExpences(resultSet
							.getString("F_LAUNDRY_EXPENCES"));
					expensesVO.setGTotal(resultSet
							.getString("G_OTHER_EXPENSES"));
					expensesVO.setOneAdvanceReceived(resultSet
							.getString("1_ADVANCE_RECEIVED"));
					expensesVO.setTwoTicketBookedByCompany(resultSet
							.getString("2_TICKET_BOOKED_BY_COMPANY"));
					expensesVO.setThreeHotelBookedByCompany(resultSet
							.getString("3_HOTEL_BOOKED_BY_COMPANY"));
					expensesVO.setForthConveyanceExpenses(resultSet
							.getString("4_CONVEYANCE_EXPENCES"));
					expensesVO.setFiveAdvanceReceivedFromOther(resultSet
							.getString("5_ADVANCE_RECEIVED_FROM_OTHER_BRANCH"));
					expensesVO.setHTotalAToF(resultSet
							.getString("H_TOTAL_A_TO_G"));
					expensesVO.setITotalAdvance(resultSet
							.getString("I_TOTAL_ADVANCE"));
					System.out.println("*************"
							+ resultSet.getString("I_TOTAL_ADVANCE"));
					expensesVO.setDepartureDate(resultSet
							.getString("DEPARTURE_DATE"));
					expensesVO.setArrivalDate(resultSet
							.getString("ARRIVAL_DATE"));
					expensesVO.setGrantTotalBalance(resultSet
							.getString("GRANT_TOTAL_BALANCE"));
					expensesVO.setStatus(resultSet.getInt("STATUS"));

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

		return expensesVO;
	}

	/**
	 * <p>
	 * <code>showTourTicketListById</code>Method will get the tour ticket list.
	 * </p>
	 * 
	 * @param expensesVO
	 * @param claimId
	 * @throws OMIApplicationException
	 */
	@Override
	public List<ExpensesVO> showTourTicketListById(ExpensesVO expensesVO,
			int claimId) throws OMIApplicationException {

		ArrayList<ExpensesVO> tourTicketListById = new ArrayList<ExpensesVO>();
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.SHOW_LIST_TICKET_DETAILS_BY_ID);
			preparedStatement.setInt(1, claimId);
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {
					expensesVO = new ExpensesVO();
					expensesVO.setTicketId(resultSet.getInt("TICKET_ID"));

					expensesVO.setDeparturePlace(resultSet
							.getString("DETARTURE_PLACE"));

					expensesVO.setDepartureDate(resultSet
							.getString("TICKE_DEPARTURE_DATE"));
					expensesVO.setArrivalPlace(resultSet
							.getString("ARRIVAL_PLACE"));
					expensesVO.setArrivalDate(resultSet
							.getString("TICKET_ARRIVAL_DATE"));
					expensesVO
							.setTravelMode(resultSet.getString("TRAVEL_MODE"));
					expensesVO.setAmountForA(resultSet
							.getString("TICKET_AMOUNT"));
					tourTicketListById.add(expensesVO);
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
		return tourTicketListById;
	}

	/**
	 * <p>
	 * <code>updateExpensesTourDetails</code>Method is use to update tour
	 * expenses detail.
	 * </p>
	 * 
	 * @param expensesVO
	 * @param claimId
	 * @throws OMIApplicationException
	 * @return target
	 */
	@Override
	public int updateExpensesTourDetails(ExpensesVO expensesVO, int claimId)
			throws OMIApplicationException {
		int target = 0;
		expensesVO.setClaimId(claimId);
		try {

			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.UPDATE_EXPENSES_DETAILS);
			preparedStatement.setString(1, expensesVO.getName());
			preparedStatement.setString(2, expensesVO.getPlaceOfVisit());
			preparedStatement.setString(3, expensesVO.getPurposeOfVisit());
			preparedStatement.setString(4, expensesVO.getDepartureDate());
			preparedStatement.setString(5, expensesVO.getArrivalDate());
			preparedStatement.setString(6, expensesVO.getTotalAmountA());
			preparedStatement.setString(7, expensesVO.getTotalAmountB());
			preparedStatement.setString(8, expensesVO.getDailyAllowance());
			preparedStatement.setString(9, expensesVO.getConveynanceExD());
			preparedStatement.setString(10, expensesVO.getConveynanceEx());
			preparedStatement.setString(11, expensesVO.getLaundryExpences());
			preparedStatement.setString(12,expensesVO.getOtherExpenses());
			preparedStatement.setString(13, expensesVO.getHTotalAToF());			
			preparedStatement.setString(14, expensesVO.getOneAdvanceReceived());
			preparedStatement.setString(15,	expensesVO.getTwoTicketBookedByCompany());
			preparedStatement.setString(16,	expensesVO.getThreeHotelBookedByCompany());
			preparedStatement.setString(17,	expensesVO.getForthConveyanceExpenses());
			preparedStatement.setString(18,	expensesVO.getFiveAdvanceReceivedFromOther());
			preparedStatement.setString(19, expensesVO.getITotalAdvance());
			preparedStatement.setString(20, expensesVO.getGrantTotalBalance());
			preparedStatement.setString(21, expensesVO.getApprovedBy());
			preparedStatement.setString(22, expensesVO.getClaimStatus());
			preparedStatement.setString(23, expensesVO.getComment());
			preparedStatement.setString(24, expensesVO.getTicketRefNo());
			preparedStatement.setInt(25, expensesVO.getCreatedBy());
			preparedStatement.setString(26, DateTimeUtil.getCurrentDate());
			preparedStatement.setInt(27, expensesVO.getClaimId());
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

	@Override
	public List<ExpensesVO> showBoardingDetailListById(ExpensesVO expensesVO,
			int claimId) throws OMIApplicationException {
		ArrayList<ExpensesVO> boardingDetailList = new ArrayList<ExpensesVO>();

		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.SHOW_LIST_BOARDING_DETAILS_BY_ID);
			preparedStatement.setInt(1, claimId);
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {
					expensesVO = new ExpensesVO();
					expensesVO.setBoardingId(resultSet.getInt("BOARDING_ID"));
					expensesVO.setHotel(resultSet.getString("HOTEL_NAME"));
					expensesVO.setPlace(resultSet.getString("PLACE"));
					expensesVO.setFrom(resultSet.getString("FROM_DATE"));
					expensesVO.setTo(resultSet.getString("TO_DATE"));
					expensesVO.setBillNo(resultSet.getString("BILL_NUMBER"));
					expensesVO.setHotelAmount(resultSet
							.getString("BOARDING_AMOUNT"));
					boardingDetailList.add(expensesVO);
				}
			}
		} catch (SQLException sqlExp) {
			sqlExp.printStackTrace();
			logger.error(
					ExpensesDaoImpl.class
							+ "Error: Occur in Query While Fetching  Expenses Boarding Details from Database.",
					sqlExp);
		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					ExpensesDaoImpl.class
							+ "Error: Occur in Query While Closing Connection After Fetching Bording Details from Database.",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return boardingDetailList;
	}

	@Override
	public int updateExpensesTicketFare(ExpensesVO expensesVO, int ticketId)
			throws OMIApplicationException {
		int target = 0;
		try {

			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.UPDATE_EXPENSES_TICKET_DETAILS);
			preparedStatement.setString(1, expensesVO.getDeparturePlace());
			preparedStatement.setString(2, expensesVO.getDepartureDate());
			preparedStatement.setString(3, expensesVO.getArrivalPlace());
			preparedStatement.setString(4, expensesVO.getArrivalDate());
			preparedStatement.setString(5, expensesVO.getTravelMode());
			preparedStatement.setString(6, expensesVO.getAmountForA());
			preparedStatement.setInt(7, ticketId);
			preparedStatement.executeUpdate();

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

	@Override
	public int updateExpensesBoarding(ExpensesVO expensesVO, int boardingId)
			throws OMIApplicationException {
		int target = 0;
		try {

			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.UPDATE_EXPENSES_BOARDING_DETAILS);
			preparedStatement.setString(1, expensesVO.getHotel());
			preparedStatement.setString(2, expensesVO.getPlace());
			preparedStatement.setString(3, expensesVO.getFrom());
			preparedStatement.setString(4, expensesVO.getTo());
			preparedStatement.setString(5, expensesVO.getBillNo());
			preparedStatement.setString(6, expensesVO.getHotelAmount());
			preparedStatement.setInt(7, expensesVO.getCreatedBy());
			preparedStatement.executeUpdate();
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

	@Override
	public ExpensesVO getExpensesTicketFare(int ticketId)
			throws OMIApplicationException {
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.SHOW_EXPENSES_TICKET_FARE_DETAILS);
			preparedStatement.setInt(1, ticketId);
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {
					expensesVO = new ExpensesVO();
					expensesVO.setTicketId(resultSet.getInt("TICKET_ID"));
					System.out.println("Ticket Id:"
							+ resultSet.getInt("TICKET_ID"));
					expensesVO.setDeparturePlace(resultSet
							.getString("DETARTURE_PLACE"));
					System.out.println("Departure place:"
							+ resultSet.getString("DETARTURE_PLACE"));
					expensesVO.setDepartureDate(resultSet
							.getString("TICKE_DEPARTURE_DATE"));
					expensesVO.setArrivalPlace(resultSet
							.getString("ARRIVAL_PLACE"));
					expensesVO.setArrivalDate(resultSet
							.getString("TICKET_ARRIVAL_DATE"));
					expensesVO
							.setTravelMode(resultSet.getString("TRAVEL_MODE"));
					expensesVO.setAmountForA(resultSet
							.getString("TICKET_AMOUNT"));

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

		return expensesVO;

	}

	@Override
	public ExpensesVO getExpensesBoarding(int boardingId)
			throws OMIApplicationException {
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.SHOW_EXPENSES_BOARDING_DETAILS);
			preparedStatement.setInt(1, boardingId);
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {
					expensesVO = new ExpensesVO();
					expensesVO.setBoardingId(resultSet.getInt("BOARDING_ID"));
					expensesVO.setHotel(resultSet.getString("HOTEL_NAME"));
					expensesVO.setPlace(resultSet.getString("PLACE"));
					expensesVO.setFrom(resultSet.getString("FROM_DATE"));
					expensesVO.setTo(resultSet.getString("TO_DATE"));
					expensesVO.setBillNo(resultSet.getString("BILL_NUMBER"));
					expensesVO.setHotelAmount(resultSet
							.getString("BOARDING_AMOUNT"));
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

		return expensesVO;
	}

	@Override
	public int getExpensesLastRecord() throws OMIApplicationException {
		
		int target = 0;
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_LAST_CLAIM__ID);
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {

					target = resultSet.getInt("CLAIM_ID");

				}
			}
		} catch (SQLException sqlException) {

			logger.error(
					ProductDaoImpl.class
							+ ": Error:- Error: Occur in Query While counting the Expenses recodes from Database",
					sqlException);

		} catch (Exception exception) {

			logger.error(
					ProductDaoImpl.class
							+ ": Error:- While closing the Connection after counting the Expenses recodes from Database",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return target;		
	}

}
