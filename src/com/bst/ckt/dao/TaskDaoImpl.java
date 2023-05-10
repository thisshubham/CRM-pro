package com.bst.ckt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.bst.ckt.common.QueryMaker;
import com.bst.ckt.dto.Task;
import com.bst.ckt.framework.db.JdbcDAOSupport;
import com.bst.ckt.framework.db.JdbcHelper;
import com.bst.ckt.framework.util.DateTimeUtil;
import com.bst.ckt.helper.NameHelper;
import com.bst.ckt.helper.TaskPriority;
import com.bst.ckt.helper.TaskStatus;
import com.bst.ckt.vo.TaskSubjectVO;
import com.bst.ckt.vo.TaskVO;

public class TaskDaoImpl extends JdbcDAOSupport implements TaskDaoInf {

	/**
	 * Creating Logger object, logger object mapped with TaskDaoImpl class for
	 * writing Loggers.
	 */
	public static final Logger logger = Logger.getLogger(TaskDaoImpl.class);

	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	/**
	 * <p>
	 * <code>insertTaskAllocationDetails()</code> method is use to insert task
	 * allocation details into database table <code>TAB_TASK_DETAILS</code>.
	 * </p>
	 * 
	 * @return target int
	 * @param taskVO
	 *            TaskVO
	 * @throws Exception
	 */
	@Override
	public int insertTaskAllocationDetails(TaskVO taskVO) throws Exception {

		String AddLeadDetailsQuery = QueryMaker.ADD_TASK_ALLOCATION_DETAILS;
		int target = 0;
		String temp = "-1";
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(AddLeadDetailsQuery);

			// TASK INFORMATION......
			System.out.println("query executed");
			preparedStatement.setString(1, taskVO.getSalutation());
			preparedStatement.setInt(2, taskVO.getTaskAllocatedTo());
			preparedStatement.setString(3, taskVO.getTaskSubject());
			preparedStatement.setString(4,
					DateTimeUtil.convertToDate(taskVO.getDueDate()));
			preparedStatement.setString(5, taskVO.getTaskArea());
			preparedStatement.setInt(6, TaskStatus.NEW_ID);
			preparedStatement.setString(7, taskVO.getTaskPriority());
			preparedStatement.setString(8, taskVO.getSendEmailNotification());
			System.out.println("email notification"+taskVO.getSendEmailNotification());
			preparedStatement.setString(9,
					DateTimeUtil.convertToDate(taskVO.getStartDate()));
			preparedStatement.setString(10,
					DateTimeUtil.convertToDate(taskVO.getEndDate()));
			preparedStatement.setString(11, taskVO.getRepeatType());
			// DAILY.....
			preparedStatement.setString(12, taskVO.getEveryDay());
			preparedStatement.setInt(13, taskVO.getNumberOfDays());
			// WEEKLY....
			preparedStatement.setString(14, taskVO.getRepeatForEveryWeek());
			preparedStatement.setInt(15, taskVO.getNumberOfWeeks());
			preparedStatement.setString(16, taskVO.getDaysName());

			// MONTHLY.....
			preparedStatement.setString(17, taskVO.getOnDayOfMonths());
			if (taskVO.getMonthsDay() == -1) {
				taskVO.setMonthsDay(0);
				preparedStatement.setInt(18, taskVO.getMonthsDay());
			} else {
				preparedStatement.setInt(18, taskVO.getMonthsDay());
			}

			if (taskVO.getNumberOfMonths() == -1) {
				taskVO.setNumberOfMonths(0);
				preparedStatement.setInt(19, taskVO.getNumberOfMonths());
			} else {
				preparedStatement.setInt(19, taskVO.getNumberOfMonths());
			}

			if (taskVO.getOnWeek().equals(temp) == true) {
				taskVO.setOnWeek(null);
				preparedStatement.setString(20, taskVO.getOnWeek());
			} else {
				preparedStatement.setString(20, taskVO.getOnWeek());
			}

			if (taskVO.getOfWeekDay().equals(temp) == true) {
				taskVO.setOfWeekDay(null);
				preparedStatement.setString(21, taskVO.getOfWeekDay());
			} else {
				preparedStatement.setString(21, taskVO.getOfWeekDay());
			}
			preparedStatement.setInt(22, taskVO.getOnEveryNoOfMonths());

			// YEARLY......
			preparedStatement.setString(23, taskVO.getOnEveryOfYear());

			if (taskVO.getOnMonthOfYear().equals(temp) == true) {
				taskVO.setOnMonthOfYear(null);
				preparedStatement.setString(24, taskVO.getOnMonthOfYear());

			} else {
				preparedStatement.setString(24, taskVO.getOnMonthOfYear());
			}

			if (taskVO.getOnDayOfYear().equals(temp) == true) {
				taskVO.setOnDayOfYear("0");
				preparedStatement.setString(25, taskVO.getOnDayOfYear());
			} else {
				preparedStatement.setString(25, taskVO.getOnDayOfYear());
			}
			if (taskVO.getEveryWeekOfYear().equals(temp) == true) {
				taskVO.setEveryWeekOfYear(null);
				preparedStatement.setString(26, taskVO.getEveryWeekOfYear());
			} else {
				preparedStatement.setString(26, taskVO.getEveryWeekOfYear());
			}

			if (taskVO.getEveryWeekDayOfYear().equals(temp) == true) {
				taskVO.setEveryWeekDayOfYear(null);
				preparedStatement.setString(27, taskVO.getEveryWeekDayOfYear());
			} else {
				preparedStatement.setString(27, taskVO.getEveryWeekDayOfYear());
			}
			if (taskVO.getEveryMonthOfYear().equals(temp) == true) {
				taskVO.setEveryMonthOfYear(null);
				preparedStatement.setString(28, taskVO.getEveryMonthOfYear());
			} else {
				preparedStatement.setString(28, taskVO.getEveryMonthOfYear());
			}

			// DISCRIPTION.....
			preparedStatement.setString(29, taskVO.getDiscription());
			preparedStatement.setInt(30, taskVO.getTaskAllocatedBy());
			preparedStatement.setString(31, DateTimeUtil.getCurrentDate());
			preparedStatement.executeUpdate();
			target = 1;
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					TaskDaoImpl.class
							+ "Error: Occur in Query While Inserting the Task Allocation Details into Database.",
					sqlException);

		} catch (Exception exception) {

			exception.printStackTrace();
			logger.error(
					TaskDaoImpl.class
							+ "Error: Occur While Closing Connection After Inserting the Task Allocation Details into Database.",
					exception);
		} finally {
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return target;
	}

	/**
	 * <p>
	 * <code>getTaskAllocationDetailsIntoGrid()</code> method is use to get task
	 * allocation details from database into grid.
	 * </p>
	 * 
	 * @throws Exception
	 */
	@Override
	public List<TaskVO> getTaskAllocationDetailsIntoGrid() throws Exception {

		ArrayList<TaskVO> taskAllocationDetails = new ArrayList<TaskVO>();
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GE_TASK_DETAILS_LIST);
			resultSet = preparedStatement.executeQuery();
			NameHelper nameHelper = new NameHelper();

			while (resultSet.next()) {
				TaskVO taskVO = new TaskVO();
				taskVO.setTaskId(resultSet.getInt("TASK_ID"));
				taskVO.setSubjectName(nameHelper.getTaskSubjectName(resultSet
						.getInt("TASK_SUBJECT_REF")));
				taskVO.setTaskArea(nameHelper.getTaskAreaName(resultSet
						.getInt("TASK_AREA_REF")));
				taskVO.setTaskPriorityName(TaskPriority
						.getTaskPriority(resultSet.getInt("TASK_PRIORITY")));
				taskVO.setTaskAllocatedToName(nameHelper
						.getCustomerName(resultSet
								.getInt("TASK_ALLOCATED_TO_REF")));
				taskVO.setTaskAllocatedByName(nameHelper
						.getCustomerName(resultSet.getInt("TASK_ALLOCATED_BY")));
				taskVO.setDueDate(DateTimeUtil.convertDatetoFormDateForView(resultSet
						.getString("TASK_DUE_DATE")));
				taskVO.setTaskStatusName(TaskStatus.getTaskStatusName(resultSet
						.getInt("TASK_STATUS")));
				taskAllocationDetails.add(taskVO);
			}

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					TaskDaoImpl.class
							+ "Error: Occur in Query While Inserting the Task Allocation Details into Database.",
					sqlException);

		} catch (Exception exception) {

			exception.printStackTrace();
			logger.error(
					TaskDaoImpl.class
							+ "Error: Occur While Closing Connection After Inserting the Task Allocation Details into Database.",
					exception);
		} finally {
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
			JdbcHelper.closeResultSet(resultSet);
		}

		return taskAllocationDetails;
	}

	/**
	 * <p>
	 * <code>getTaskAllocationDetails()</code> method is use to get task
	 * allocation details from database into form for update process.
	 * </p>
	 * 
	 * @throws Exception
	 */
	@Override
	public Task getTaskAllocationDetails(int taskId) throws Exception {

		Task task = new Task();
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GE_TASK_ALLOCATION_DETAILS);
			preparedStatement.setInt(1, taskId);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				task.setSalutation(resultSet.getString("SALUTATION"));
				task.setTaskAllocatedTo(resultSet
						.getInt("TASK_ALLOCATED_TO_REF"));
			
				task.setTaskSubject(resultSet.getString("TASK_SUBJECT_REF"));
				System.out.println("task subject ="+resultSet.getString("TASK_SUBJECT_REF"));
			
				task.setDueDate(resultSet.getString("TASK_DUE_DATE"));
				task.setTaskArea(resultSet.getString("TASK_AREA_REF"));
			
				task.setTaskStatus(resultSet.getString("TASK_STATUS"));
			
				task.setTaskPriority(resultSet.getString("TASK_PRIORITY"));
				task.setSendEmailNotification(resultSet
						.getString("EMAIL_NOTIFICATION_FLAG"));
			
				task.setStartDate(resultSet.getString("START_DATE"));
				task.setEndDate(resultSet.getString("END_DATE"));
				task.setRepeatType(resultSet.getString("REPEAT_TYPE"));
				task.setEveryDay(resultSet.getString("EVER_DAY_FLAG"));
				task.setNumberOfDays(resultSet.getInt("NUMBER_OF_DAYS"));
				task.setRepeatForEveryWeek(resultSet
						.getString("REPEAT_FOR_EVERY_FLAG"));
				task.setNumberOfWeeks(resultSet.getInt("NUMBER_OF_WEEKS"));
				task.setWeeksDay(resultSet.getString("WEEK_DAY_NAME"));
				task.setOnDayOfMonths(resultSet.getString("ON_DAY_FLAG"));
				task.setMonthsDay(resultSet.getInt("DAY_OF_MONTH"));
				task.setNumberOfMonths(resultSet.getInt("NUMBER_OF_MONTHS"));
				task.setOnWeek(resultSet.getString("ON_WEEK_OF_MONTH"));
				task.setOfWeekDay(resultSet.getString("DAY_NAME_OF_MONTH"));
				task.setNumberOfMonths(resultSet
						.getInt("NUMBER_OF_DAY_OF_MONTHS"));
				task.setOnEveryOfYear(resultSet.getString("ON_EVERY_FLAG"));
				task.setOnDayOfYear(resultSet.getString("MONTHS_NAME"));
				task.setOnDayOfYear(resultSet.getString("ON_DAY"));
				task.setEveryWeekOfYear(resultSet.getString("ON_WITCH_WEEK"));
				task.setEveryWeekDayOfYear(resultSet
						.getString("WEEKS_DAY_NAME"));
				task.setEveryMonthOfYear(resultSet
						.getString("MONTHS_NAME_OF_YEAR"));
				task.setDiscription(resultSet.getString("DISCRIPTION"));
				task.setTaskAllocatedBy(resultSet.getInt("TASK_ALLOCATED_BY"));
				task.setTaskAllocationDate(resultSet
						.getString("TASK_ALLOCATION_DATE"));
				task.setSalutation(resultSet.getString("SALUTATION"));
				task.setDaysName(resultSet.getString("WEEK_DAY_NAME"));

			}

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					TaskDaoImpl.class
							+ "Error: Occur in Query While Fetching the Task Allocation Details from Database.",
					sqlException);

		} catch (Exception exception) {

			exception.printStackTrace();
			logger.error(
					TaskDaoImpl.class
							+ "Error: Occur While Closing Connection After Fetching the Task Allocation Details from Database.",
					exception);
		} finally {
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
			JdbcHelper.closeResultSet(resultSet);
		}

		return task;
	}

	/**
	 * <p>
	 * <code>isTaskSubjectExist(String)</code> method help to verify the existing
	 * task subject available in the database. if entered task subject already
	 * available into the database then this method will return 1 else 0;
	 * </p>
	 * 
	 * @param taskSubjectName
	 *            String
	 * @return
	 * @throws Exception
	 * 
	 */
	@Override
	public int isTaskSubjectExist(String taskSubjectName) throws Exception {
		String existTaskSubject = null;
		try {

			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_TASK_SUBJECT);
			preparedStatement.setString(1, taskSubjectName);

			resultSet = preparedStatement.executeQuery();

			if (resultSet != null) {
				while (resultSet.next()) {
					existTaskSubject = resultSet.getString("TASK_SUBJECT");

					if (existTaskSubject.equalsIgnoreCase(taskSubjectName)) {
						logger.info("Lead title Already exists into the database");
						return 1;
					}
				}
			} else {
				return 0;
			}

		} catch (SQLException sqlException) {
			logger.error(TaskDaoImpl.class+
					"Failed to verify task subject already exists  into the database",
					sqlException);

		} catch (Exception exception) {

			logger.error(TaskDaoImpl.class+
					"Exception occured while verifying  task subject already exists  in database",
					exception);

		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return 0;
	}

	/**
	 * <p>
	 * <code>insertTaskSubject(taskVO)</code> method use to insert task subject into
	 * TAB_TASK_SUBJECT table.
	 * </p>
	 * 
	 * @param taskVO
	 */
	@Override
	public void insertTaskSubject(TaskVO taskVO) throws Exception {
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.INSERT_TASK_SUBJECT);
			preparedStatement.setString(1, taskVO.getTaskSubject());
			System.out.println("task subject"+taskVO.getTaskSubject());
			preparedStatement.executeUpdate();
		} catch (SQLException sqlExp) {
			sqlExp.printStackTrace();
			logger.error(
					TaskDaoImpl.class
							+ "Error: Occur in Query While Inserting Task Subject into Database.",
					sqlExp);
		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					TaskDaoImpl.class
							+ "Error: Occur in Query While Closing Connection After Inserting Task Subject into Database.",
					exception);
		} finally {
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		
	}

	
	/**
	 * <p>
	 * <code>getTaskSubjectList()</code> method use to fetch task subject into
	 * TAB_TASK_SUBJECT table.
	 * </p>
	 * 
	 * @param leadVO
	 * 
	 * @return null
	 */
	@Override
	public List<TaskSubjectVO> getTaskSubjectList() throws Exception {
		ArrayList<TaskSubjectVO> taskSubjectList = new ArrayList<TaskSubjectVO>();
		TaskSubjectVO taskSubjectVO=null;
		try {

			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.SHOW_TASK_SUBJECT_LIST);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				taskSubjectVO = new TaskSubjectVO();
				taskSubjectVO.setTaskSubject(resultSet
						.getString("TASK_SUBJECT"));
				taskSubjectList.add(taskSubjectVO);
			}
		} catch (SQLException sqlExp) {
			sqlExp.printStackTrace();
			logger.error(
					TaskDaoImpl.class
							+ "Error: Occur in Query While Fetching  Lead Title from Database.",
					sqlExp);
		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					TaskDaoImpl.class
							+ "Error: Occur in Query While Closing Connection After Fetching Lead Title from Database.",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return taskSubjectList;
	}

	
	/**
	 * <p>
	 * <code>retriveTaskAllocationDetails()</code> method is use to get task
	 * allocation details from database.
	 * </p>
	 * 
	 * @throws Exception
	 */
	@Override
	public TaskVO retriveTaskAllocationDetails(TaskVO taskVO,int taskId) throws Exception {
		
		 taskVO = new TaskVO();
		 NameHelper nameHelper=new NameHelper();
		try {
			
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GE_TASK_DETAILS);
			preparedStatement.setInt(1, taskId);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				taskVO.setTaskAllocatedToName(nameHelper.getCustomerName(resultSet
						.getInt("TASK_ALLOCATED_TO_REF")));
				taskVO.setTaskSubject(nameHelper.getTaskSubjectName(resultSet.getInt("TASK_SUBJECT_REF")));
				taskVO.setDueDate(DateTimeUtil.convertDatetoFormDateForView(resultSet.getString("TASK_DUE_DATE")));
				taskVO.setTaskArea(nameHelper.getTaskAreaName(resultSet.getInt("TASK_AREA_REF")));
				taskVO.setTaskStatus(TaskStatus.getTaskStatusName(resultSet.getInt("TASK_STATUS")));
				taskVO.setTaskPriority(TaskPriority.getTaskPriority(resultSet.getInt("TASK_PRIORITY")));
				taskVO.setSendEmailNotification(resultSet
						.getString("EMAIL_NOTIFICATION_FLAG"));
				taskVO.setStartDate(DateTimeUtil.convertDatetoFormDateForView(resultSet.getString("START_DATE")));
				taskVO.setEndDate(DateTimeUtil.convertDatetoFormDateForView(resultSet.getString("END_DATE")));
				taskVO.setDiscription(resultSet.getString("DISCRIPTION"));
				taskVO.setTaskAllocatedByName(nameHelper.getCustomerName(resultSet.getInt("TASK_ALLOCATED_BY")));
				taskVO.setTaskAllocationDate(DateTimeUtil.convertDatetoFormDateForView(resultSet
						.getString("TASK_ALLOCATION_DATE")));


			}

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					TaskDaoImpl.class
							+ "Error: Occur in Query While Fetching the Task Allocation Details from Database.",
					sqlException);

		} catch (Exception exception) {

			exception.printStackTrace();
			logger.error(
					TaskDaoImpl.class
							+ "Error: Occur While Closing Connection After Fetching the Task Allocation Details from Database.",
					exception);
		} finally {
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
			JdbcHelper.closeResultSet(resultSet);
		}

		return taskVO;
	
	}

	/**
	 * <p>
	 * <code>updateTaskAllocationDetails()</code> method is use to update task
	 * allocation details into database.
	 * </p>
	 * 
	 * @throws Exception
	 */
	@Override
	public int updateTaskAllocationDetails(TaskVO taskVO) throws Exception {
		
		String AddLeadDetailsQuery = QueryMaker.UPDATE_TASK_ALLOCATION_DETAILS;
		int target = 0;
		String temp = "-1";
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(AddLeadDetailsQuery);

			// TASK INFORMATION......
			System.out.println("query executed");
			preparedStatement.setString(1, taskVO.getSalutation());
			preparedStatement.setInt(2, taskVO.getTaskAllocatedTo());
			preparedStatement.setString(3, taskVO.getTaskSubject());
			preparedStatement.setString(4,
					DateTimeUtil.convertToDate(taskVO.getDueDate()));
			preparedStatement.setString(5, taskVO.getTaskArea());
			preparedStatement.setString(6, taskVO.getTaskStatus());
			preparedStatement.setString(7, taskVO.getTaskPriority());
			preparedStatement.setString(8, taskVO.getSendEmailNotification());
			System.out.println("email notification"+taskVO.getSendEmailNotification());
			preparedStatement.setString(9,
					DateTimeUtil.convertToDate(taskVO.getStartDate()));
			preparedStatement.setString(10,
					DateTimeUtil.convertToDate(taskVO.getEndDate()));
			preparedStatement.setString(11, taskVO.getRepeatType());
			// DAILY.....
			preparedStatement.setString(12, taskVO.getEveryDay());
			preparedStatement.setInt(13, taskVO.getNumberOfDays());
			// WEEKLY....
			preparedStatement.setString(14, taskVO.getRepeatForEveryWeek());
			preparedStatement.setInt(15, taskVO.getNumberOfWeeks());
			preparedStatement.setString(16, taskVO.getDaysName());

			// MONTHLY.....
			preparedStatement.setString(17, taskVO.getOnDayOfMonths());
			if (taskVO.getMonthsDay() == -1) {
				taskVO.setMonthsDay(0);
				preparedStatement.setInt(18, taskVO.getMonthsDay());
			} else {
				preparedStatement.setInt(18, taskVO.getMonthsDay());
			}

			if (taskVO.getNumberOfMonths() == -1) {
				taskVO.setNumberOfMonths(0);
				preparedStatement.setInt(19, taskVO.getNumberOfMonths());
			} else {
				preparedStatement.setInt(19, taskVO.getNumberOfMonths());
			}

			if (taskVO.getOnWeek().equals(temp) == true) {
				taskVO.setOnWeek(null);
				preparedStatement.setString(20, taskVO.getOnWeek());
			} else {
				preparedStatement.setString(20, taskVO.getOnWeek());
			}

			if (taskVO.getOfWeekDay().equals(temp) == true) {
				taskVO.setOfWeekDay(null);
				preparedStatement.setString(21, taskVO.getOfWeekDay());
			} else {
				preparedStatement.setString(21, taskVO.getOfWeekDay());
			}
			preparedStatement.setInt(22, taskVO.getOnEveryNoOfMonths());

			// YEARLY......
			preparedStatement.setString(23, taskVO.getOnEveryOfYear());

			if (taskVO.getOnMonthOfYear().equals(temp) == true) {
				taskVO.setOnMonthOfYear(null);
				preparedStatement.setString(24, taskVO.getOnMonthOfYear());

			} else {
				preparedStatement.setString(24, taskVO.getOnMonthOfYear());
			}

			if (taskVO.getOnDayOfYear().equals(temp) == true) {
				taskVO.setOnDayOfYear("0");
				preparedStatement.setString(25, taskVO.getOnDayOfYear());
			} else {
				preparedStatement.setString(25, taskVO.getOnDayOfYear());
			}
			if (taskVO.getEveryWeekOfYear().equals(temp) == true) {
				taskVO.setEveryWeekOfYear(null);
				preparedStatement.setString(26, taskVO.getEveryWeekOfYear());
			} else {
				preparedStatement.setString(26, taskVO.getEveryWeekOfYear());
			}

			if (taskVO.getEveryWeekDayOfYear().equals(temp) == true) {
				taskVO.setEveryWeekDayOfYear(null);
				preparedStatement.setString(27, taskVO.getEveryWeekDayOfYear());
			} else {
				preparedStatement.setString(27, taskVO.getEveryWeekDayOfYear());
			}
			if (taskVO.getEveryMonthOfYear().equals(temp) == true) {
				taskVO.setEveryMonthOfYear(null);
				preparedStatement.setString(28, taskVO.getEveryMonthOfYear());
			} else {
				preparedStatement.setString(28, taskVO.getEveryMonthOfYear());
			}

			// DISCRIPTION.....
			preparedStatement.setString(29, taskVO.getDiscription());
			preparedStatement.setInt(30, taskVO.getTaskAllocatedBy());
			preparedStatement.setString(31, DateTimeUtil.getCurrentDate());
			preparedStatement.setInt(32, taskVO.getTaskId());

			preparedStatement.executeUpdate();
			target = 1;
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					TaskDaoImpl.class
							+ "Error: Occur in Query While Updating the Task Allocation Details into Database.",
					sqlException);

		} catch (Exception exception) {

			exception.printStackTrace();
			logger.error(
					TaskDaoImpl.class
							+ "Error: Occur While Closing Connection After Updating the Task Allocation Details into Database.",
					exception);
		} finally {
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return target;

	}

	
	
	
	
}
