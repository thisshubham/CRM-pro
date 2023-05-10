/*
 **********************************************************************
 *
 * COPYRIGHT. $ID$ 2015. ALL RIGHTS RESERVED.
 *
 * This software is only to be used for the purpose for which it has been
 * provided. No part of it is to be reproduced, disassembled, transmitted,
 * stored in a retrieval system nor translated in any human or computer
 * language in any way or for any other purposes whatsoever without the
 * prior written consent of $ID$.
 * 
 * Class Name     TaskAction.java     
 *                                                            
 * Creation Date  OCT 5, 2015 
 * 
 * Abstract       This is Action class which is design to call particular 
 * 				  action with respective page.
 *  
 * Amendment History (in chronological sequence):OCT 5, 2015 
 * 
 * Author Shaikh Hussain
 **********************************************************************
 */
package com.bst.ckt.action;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.bst.ckt.common.LoginUtil;
import com.bst.ckt.common.OMIConstants;
import com.bst.ckt.dao.TaskDaoImpl;
import com.bst.ckt.dao.TaskDaoInf;
import com.bst.ckt.framework.user.CustomerSessionUser;
import com.bst.ckt.helper.DaysName;
import com.bst.ckt.helper.ListHelper;
import com.bst.ckt.helper.MonthsName;
import com.bst.ckt.helper.NameHelper;
import com.bst.ckt.helper.RepeatType;
import com.bst.ckt.helper.Salutation;
import com.bst.ckt.helper.TaskPriority;
import com.bst.ckt.helper.TaskStatus;
import com.bst.ckt.helper.VOMapperHelper;
import com.bst.ckt.helper.WeekNumber;
import com.bst.ckt.service.TaskServiceImpl;
import com.bst.ckt.service.TaskServiceInf;
import com.bst.ckt.vo.TaskSubjectVO;
import com.bst.ckt.vo.TaskVO;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 
 * @author shaikh Hussain
 * 
 */

public class TaskAction extends ActionSupport implements ServletResponseAware,
		ModelDriven<TaskVO>, SessionAware, ServletRequestAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Creating Logger object, logger object mapped with TaskAction class for
	 * writing Loggers.
	 */
	private static final Logger logger = Logger.getLogger(TaskAction.class);

	TaskVO taskVO = new TaskVO();
	ListHelper listHelper = new ListHelper();
	NameHelper nameHelper = new NameHelper();
	TaskDaoInf taskDaoInf = new TaskDaoImpl();
	TaskServiceInf taskServiceInf = new TaskServiceImpl();
	HttpServletRequest request = (HttpServletRequest) ActionContext
			.getContext().get(ServletActionContext.HTTP_REQUEST);
	HttpServletResponse response = null;
	TaskSubjectVO taskSubjectVO = new TaskSubjectVO();

	private Map<Integer, String> taskSubjectList;
	private Map<Integer, String> taskAreaList;
	private Map<Integer, String> taskStatusList;
	private Map<Integer, String> taskPriorityList;
	private Map<Integer, String> repeatTypeList;
	private Map<Integer, String> taskAllocatedToList;
	private Map<Integer, String> dayNameList;
	private Map<Integer, String> weekNumberList;
	private Map<Integer, String> monthsNameList;
	private List<TaskVO> taskAllocationDetailsGrid;
	private List<TaskSubjectVO> taskSubjectListIntoGrid = null;
	private Map<Integer, String> salutationList;

	public TaskAction() throws Exception {
		taskSubjectList = listHelper.taskSubjectList();
		taskAreaList = listHelper.taskAreaList();
		taskStatusList = TaskStatus.getModifiedTaskStatusList();
		taskPriorityList = TaskPriority.getTaskPriorityList();
		repeatTypeList = RepeatType.getRepeatTypeList();
		taskAllocatedToList = listHelper.customerNameList();
		dayNameList = DaysName.getDayNameList();
		weekNumberList = WeekNumber.getWeekNumberList();
		monthsNameList = MonthsName.getMonthsNameList();
		taskAllocationDetailsGrid = taskDaoInf
				.getTaskAllocationDetailsIntoGrid();
		taskSubjectListIntoGrid = taskDaoInf.getTaskSubjectList();
		salutationList=Salutation.getSalutationList();
	}

	/**
	 * <p>
	 * <code>addTaskAllocatedToDetails()</code> method is use to add task
	 * allocated details into database.Task will be allocated by Customer to
	 * user on the basis of their access to the system.
	 * </p>
	 * 
	 * @return SUCCESS
	 * @throws Exception
	 */

	public String addTaskAllocatedToDetails() throws Exception {

		taskServiceInf = new TaskServiceImpl();
		CustomerSessionUser customerSessionUser = LoginUtil
				.getCurrentCustomerUser();
		taskVO.setTaskAllocatedBy(customerSessionUser.getCustomerId());
		String message = taskServiceInf.addTaskDetails(taskVO);

		/**
		 * TARGET_SUCCESS; TARGET_FAILURE
		 */
		if (OMIConstants.TARGET_SUCCESS.equalsIgnoreCase(message)) {
			logger.info("Successfully Inserted Task Allocation Details!");
			addActionMessage("Successfully Inserted Task Allocation Details!");
			return SUCCESS;

		} else if (OMIConstants.TARGET_FAILURE.equalsIgnoreCase(message)) {

			logger.info("Error: While Inserting Task Allocation Details!");
			addActionError("Error: While Inserting Task Allocation Details!");
			return INPUT;
		}

		return NONE;
	}

	/**
	 * <p>
	 * <code>populateTaskAllocationDetails()</code> method is use to show task
	 * allocated details from database into form for update process.
	 * </p>
	 * 
	 * @return SUCCESS
	 * @throws Exception
	 */

	public String populateTaskAllocationDetails() throws Exception {

		int taskId = Integer.parseInt(request.getParameter("command"));
		LoginUtil.setProcessUserId(taskId);
		taskDaoInf = new TaskDaoImpl();
		this.taskVO = VOMapperHelper.getTaskVOFromTask(taskVO,
				taskDaoInf.getTaskAllocationDetails(taskId));

		return SUCCESS;
	}

	/**
	 * <p>
	 * <code>addTaskSubjectDetails()</code> this method design to add task
	 * subject into the database.
	 * </p>
	 * 
	 * @return SUCCESS
	 * @throws Exception
	 */
	public String addTaskSubjectDetails() throws Exception {

		taskServiceInf = new TaskServiceImpl();
		String message = null;

		System.out.println("task vo in action class" + taskVO.getTaskSubject());
		message = taskServiceInf.addTaskSubject(taskVO);

		/**
		 * RESULT_SUCCESS TARGET_LEAD_TITLE_ALREADY_INSERTED
		 * */
		if (OMIConstants.TARGET_SUCCESS.equalsIgnoreCase(message)) {
			taskSubjectListIntoGrid = taskDaoInf.getTaskSubjectList();
			taskSubjectList = listHelper.taskSubjectList();
			logger.info("Task Subject inserted successfully.");
			addActionMessage("Task Subject inserted successfully.");
			return SUCCESS;
		} else if (OMIConstants.TARGET_TASK_SUBJECT_ALREADY_EXIST
				.equalsIgnoreCase(message)) {
			logger.info("Error:Task Subject already exists!");
			addActionError("Task Subject already exists.");
			return INPUT;
		}
		return NONE;
	}

	/**
	 * <p>
	 * <code>isTaskSubjectExist()</code> method verify whether the lead title
	 * already exists
	 * </p>
	 * 
	 * @return NONE
	 * @throws Exception
	 */
	public String isTaskSubjectExist() throws Exception {

		try {

			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
			PrintWriter printWriter = response.getWriter();

			if (taskDaoInf.isTaskSubjectExist(request
					.getParameter("taskSubject")) == 1) {
				printWriter.print("Task subject already exists.");
			}

		} catch (Exception exception) {
			logger.error(
					"Error While verifying whether  the task subject already exists ",
					exception);
		}
		return NONE;
	}

	/**
	 * <p>
	 * <code>viewLead()</code> method is use to view the lead details into lead
	 * dashboard grid
	 * </p>
	 * 
	 * @return
	 * @throws Exception
	 */
	public String getTaskDetails() throws Exception {
		int taskId = Integer.parseInt(request.getParameter("command"));
		LoginUtil.setProcessUserId(taskId);
		taskDaoInf = new TaskDaoImpl();
		this.taskVO=taskDaoInf.retriveTaskAllocationDetails(taskVO,taskId);

		return SUCCESS;
	}

	/**
	 * <p>
	 * <code>addTaskSubjectDetails()</code> this method design to add task
	 * subject into the database.
	 * </p>
	 * 
	 * @return SUCCESS
	 * @throws Exception
	 */
	public String updateTaskAllocationDetails() throws Exception {

		taskServiceInf = new TaskServiceImpl();
		String message = null;

		int taskId=LoginUtil.getProcessUserId();
		taskVO.setTaskId(taskId);
		message = taskServiceInf.updateTaskDetails(taskVO);

		/**
		 * RESULT_SUCCESS TARGET_LEAD_TITLE_ALREADY_INSERTED
		 * */
		if (OMIConstants.TARGET_SUCCESS.equalsIgnoreCase(message)) {
			taskSubjectListIntoGrid = taskDaoInf.getTaskSubjectList();
			taskSubjectList = listHelper.taskSubjectList();
			logger.info("Task Allocation Details updated successfully.");
			addActionMessage("Task Allocation Details updated successfully.");
			return SUCCESS;
		} else if (OMIConstants.TARGET_FAILURE.equalsIgnoreCase(message)) {

			logger.info("Error: While Updating Task Allocation Details!");
			addActionError("Error: While Updating Task Allocation Details!");
			return INPUT;
		}

		return NONE;
	}
	
	
	
	
	
	
	
	public List<TaskSubjectVO> getTaskSubjectListIntoGrid() {
		return taskSubjectListIntoGrid;
	}

	public void setTaskSubjectListIntoGrid(
			List<TaskSubjectVO> taskSubjectListIntoGrid) {
		this.taskSubjectListIntoGrid = taskSubjectListIntoGrid;
	}

	public List<TaskVO> getTaskAllocationDetailsGrid() {
		return taskAllocationDetailsGrid;
	}

	public void setTaskAllocationDetailsGrid(
			List<TaskVO> taskAllocationDetailsGrid) {
		this.taskAllocationDetailsGrid = taskAllocationDetailsGrid;
	}

	public String execute() throws Exception {
		return SUCCESS;
	}

	public Map<Integer, String> getMonthsNameList() {
		return monthsNameList;
	}

	public void setMonthsNameList(Map<Integer, String> monthsNameList) {
		this.monthsNameList = monthsNameList;
	}

	public Map<Integer, String> getDayNameList() {
		return dayNameList;
	}

	public void setDayNameList(Map<Integer, String> dayNameList) {
		this.dayNameList = dayNameList;
	}

	public Map<Integer, String> getWeekNumberList() {
		return weekNumberList;
	}

	public void setWeekNumberList(Map<Integer, String> weekNumberList) {
		this.weekNumberList = weekNumberList;
	}

	public Map<Integer, String> getTaskAllocatedToList() {
		return taskAllocatedToList;
	}

	public void setTaskAllocatedToList(Map<Integer, String> taskAllocatedToList) {
		this.taskAllocatedToList = taskAllocatedToList;
	}

	public Map<Integer, String> getRepeatTypeList() {
		return repeatTypeList;
	}

	public void setRepeatTypeList(Map<Integer, String> repeatTypeList) {
		this.repeatTypeList = repeatTypeList;
	}

	public Map<Integer, String> getTaskSubjectList() {
		return taskSubjectList;
	}

	public void setTaskSubjectList(Map<Integer, String> taskSubjectList) {
		this.taskSubjectList = taskSubjectList;
	}

	public Map<Integer, String> getTaskAreaList() {
		return taskAreaList;
	}

	public void setTaskAreaList(Map<Integer, String> taskAreaList) {
		this.taskAreaList = taskAreaList;
	}

	public Map<Integer, String> getTaskStatusList() {
		return taskStatusList;
	}

	public void setTaskStatusList(Map<Integer, String> taskStatusList) {
		this.taskStatusList = taskStatusList;
	}

	public Map<Integer, String> getTaskPriorityList() {
		return taskPriorityList;
	}

	public void setTaskPriorityList(Map<Integer, String> taskPriorityList) {
		this.taskPriorityList = taskPriorityList;
	}

	public TaskVO getTaskVO() {
		return taskVO;
	}

	public void setTaskVO(TaskVO taskVO) {
		this.taskVO = taskVO;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public TaskVO getModel() {
		// TODO Auto-generated method stub
		return taskVO;
	}

	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub

	}
	
	public Map<Integer, String> getSalutationList() {
		return salutationList;
	}

	public void setSalutationList(Map<Integer, String> salutationList) {
		this.salutationList = salutationList;
	}






}
