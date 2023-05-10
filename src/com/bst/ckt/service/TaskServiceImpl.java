package com.bst.ckt.service;

import org.apache.log4j.Logger;

import com.bst.ckt.common.EmailHelper;
import com.bst.ckt.common.OMIConstants;
import com.bst.ckt.dao.TaskDaoImpl;
import com.bst.ckt.dao.TaskDaoInf;
import com.bst.ckt.exception.OMIApplicationException;
import com.bst.ckt.helper.NameHelper;
import com.bst.ckt.helper.TaskPriority;
import com.bst.ckt.vo.TaskVO;

/**
 * 
 * @author Shaikh Hussain
 * 
 */
public class TaskServiceImpl implements TaskServiceInf {

	/**
	 * Creating Logger object, logger object mapped with TaskServiceImpl class
	 * for writing Loggers.
	 */
	private static final Logger logger = Logger
			.getLogger(TaskServiceImpl.class);

	TaskDaoInf taskDaoInf = null;
	TaskVO taskVO = null;
	NameHelper nameHelper = new NameHelper();

	/**
	 * <p>
	 * <code>addTaskDetails()</code> method is use to add task allocation
	 * details into database.
	 * </p>
	 * 
	 * @return
	 * @throws Exception
	 */

	@Override
	public String addTaskDetails(TaskVO taskVO) throws Exception {

		taskDaoInf = new TaskDaoImpl();

		/**
		 * Here we are appending Check boxes values(of week days name)into a
		 * string buffer id <code>nameOfDays</code> object and storing it into
		 * string object.
		 */

		StringBuffer nameOfDays = new StringBuffer();

		nameOfDays.append(taskVO.getSunday()).append("," + taskVO.getMonday())
				.append("," + taskVO.getTuesday())
				.append("," + taskVO.getWednesday())
				.append("," + taskVO.getThursday())
				.append("," + taskVO.getFriday())
				.append("," + taskVO.getSaturday());

		String temp = nameOfDays.toString();
		taskVO.setDaysName(temp);
		int target = taskDaoInf.insertTaskAllocationDetails(taskVO);
		if (target == 1) {

			if (taskVO.getSendEmailNotification().equals("true") == true) {
				String fullName = nameHelper.getCustomerName(taskVO
						.getTaskAllocatedTo());
				String taskAllocatedToEmail = nameHelper
						.getCustomerEmailId(taskVO.getTaskAllocatedTo());
				String taskAllocatedByEmail = nameHelper
						.getCustomerEmailId(taskVO.getTaskAllocatedBy());
				String message = getTaskAllocationDetailsEmailStuff(fullName,
						taskVO);
				try {
					EmailHelper.sendEmail(taskAllocatedToEmail.trim(),
							"Task Email Notification", message);
					EmailHelper.sendEmail(taskAllocatedByEmail.trim(),
							"Task Email Notification", message);
				} catch (Exception e) {
					e.printStackTrace();
					System.out
							.println("email notification sending has failed.....");
				}

			}
			logger.info("Successfully Inserted Task Allocation Details!");
			return OMIConstants.TARGET_SUCCESS;

		} else {

			logger.info("Error:while  Inserting  Task Allocation Details into database!");
			return OMIConstants.TARGET_FAILURE;

		}
	}

	private String getTaskAllocationDetailsEmailStuff(String fullName,
			TaskVO taskVO) throws NumberFormatException, Exception {

		StringBuffer messageBuffer = new StringBuffer();

		messageBuffer.append("Dear " + fullName + "\n\n");

		messageBuffer.append("Please find out following task details.\n\n");

		messageBuffer.append("\t Task Subject \t"
				+ nameHelper.getTaskSubjectName(Integer.parseInt(taskVO
						.getTaskSubject())) + "\n");
		messageBuffer
		.append("\t Task Due Date \t" + taskVO.getDueDate() + "\n");
		
		messageBuffer.append("\t Task Area \t" +nameHelper.getTaskAreaName(Integer.parseInt(taskVO.getTaskArea()))+ "\n");
		messageBuffer.append("\t Task Priority \t" +TaskPriority.getTaskPriority(Integer.parseInt(taskVO.getTaskPriority()))
				+ "\n");
		messageBuffer.append("\t Description \t" + taskVO.getDiscription()
				+ "\n");

		messageBuffer.append("\n\nIf any issue than contact.");

		messageBuffer.append("\n Thank You \n"
				+ nameHelper.getCustomerName(taskVO.getTaskAllocatedBy()));

		return messageBuffer.toString();
	}

	/**
	 * <p>
	 * <code>addTaskSubject()</code> this method is design to add task subject
	 * into database.
	 * <p>
	 * 
	 * @param leadVO
	 * @throws OMIApplicationException
	 */

	@Override
	public String addTaskSubject(TaskVO taskVO) throws Exception {
		taskDaoInf = new TaskDaoImpl();

		int target = taskDaoInf.isTaskSubjectExist(taskVO.getTaskSubject());

		if (target != 1) {
			taskDaoInf.insertTaskSubject(taskVO);
			logger.info("Task subject inserted successfully.");
			return OMIConstants.RESULT_SUCCESS;
		} else {
			logger.error(LeadServiceImpl.class + "Task subject already exists");
			return OMIConstants.TARGET_TASK_SUBJECT_ALREADY_EXIST;
		}

	}

	@Override
	public String updateTaskDetails(TaskVO taskVO) throws Exception {

		taskDaoInf = new TaskDaoImpl();

		/**
		 * Here we are appending Check boxes values(of week days name)into a
		 * string buffer id <code>nameOfDays</code> object and storing it into
		 * string object.
		 */

		StringBuffer nameOfDays = new StringBuffer();

		nameOfDays.append(taskVO.getSunday()).append("," + taskVO.getMonday())
				.append("," + taskVO.getTuesday())
				.append("," + taskVO.getWednesday())
				.append("," + taskVO.getThursday())
				.append("," + taskVO.getFriday())
				.append("," + taskVO.getSaturday());

		String temp = nameOfDays.toString();
		taskVO.setDaysName(temp);
		int target = taskDaoInf.updateTaskAllocationDetails(taskVO);
		if (target == 1) {

			if (taskVO.getSendEmailNotification().equals("true") == true) {
				String fullName = nameHelper.getCustomerName(taskVO
						.getTaskAllocatedTo());
				String taskAllocatedToEmail = nameHelper
						.getCustomerEmailId(taskVO.getTaskAllocatedTo());
				String taskAllocatedByEmail = nameHelper
						.getCustomerEmailId(taskVO.getTaskAllocatedBy());
				String message = getTaskAllocationDetailsEmailStuff(fullName,
						taskVO);
				try {
					EmailHelper.sendEmail(taskAllocatedToEmail.trim(),
							"Task Email Notification", message);
					EmailHelper.sendEmail(taskAllocatedByEmail.trim(),
							"Task Email Notification", message);
				} catch (Exception e) {
					e.printStackTrace();
					System.out
							.println("email notification sending has failed.....");
				}

			}
			logger.info("Successfully Updated Task Allocation Details!");
			return OMIConstants.TARGET_SUCCESS;

		} else {

			logger.info("Error:while  Updated  Task Allocation Details into database!");
			return OMIConstants.TARGET_FAILURE;

		}
		
	}

}
