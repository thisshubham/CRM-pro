package com.bst.ckt.dao;

import java.util.List;

import com.bst.ckt.dto.Task;
import com.bst.ckt.vo.TaskSubjectVO;
import com.bst.ckt.vo.TaskVO;


public interface TaskDaoInf {

	/**
	 * <p>
	 * <code>insertTaskAllocationDetails()</code>
	 * method is use to insert task allocation details into database table
	 * <code>TAB_TASK_DETAILS</code>.
	 *</p>
	 * 
	 * @return taskVO TaskVO
	 * @throws Exception
	 */
	public int insertTaskAllocationDetails(TaskVO taskVO)throws Exception;

	/**
	 * <p>
	 * <code>getTaskAllocationDetailsIntoGrid()</code>
	 * method is use to get task allocation details from database into grid.
	 *</p>
	 * 
	 * @throws Exception
	 */
	public List<TaskVO> getTaskAllocationDetailsIntoGrid() throws Exception;

	/**
	 * <p>
	 * <code>getTaskAllocationDetails()</code>
	 * method is use to get task allocation details from database into form.
	 *</p>
	 * 
	 * @throws Exception
	 */
	public Task getTaskAllocationDetails(int taskId)throws Exception;

	/**
	 * <p>
	 * <code>isTaskSubjectExist()</code>
	 * method is use to get task allocation details from database into form.
	 *</p>
	 * 
	 * @throws Exception
	 */
	public int isTaskSubjectExist(String taskSubjectName)throws Exception;

	/**
	 * <p>
	 * <code>insertTaskSubject()</code>
	 * method is use to insert task subject into database.
	 *</p>
	 * 
	 * @throws Exception
	 */
	public void insertTaskSubject(TaskVO taskVO)throws Exception;

	/**
	 * <p>
	 * <code>insertTaskSubject()</code>
	 * method is use to insert task subject into database.
	 *</p>
	 * 
	 * @throws Exception
	 */
	public List<TaskSubjectVO> getTaskSubjectList()throws Exception;

	/**
	 * <p>
	 * <code>retriveTaskAllocationDetails()</code>
	 * method is use to fetch task allocation details into database.
	 *</p>
	 * 
	 * @throws Exception
	 */
	public TaskVO retriveTaskAllocationDetails(TaskVO taskVO,int taskId)throws Exception;

	
	/**
	 * <p>
	 * <code>updateTaskAllocationDetails()</code>
	 * method is use to update task allocation details into database.
	 *</p>
	 * 
	 * @throws Exception
	 */
	public int updateTaskAllocationDetails(TaskVO taskVO)throws Exception;

	

	
	 

	



}
