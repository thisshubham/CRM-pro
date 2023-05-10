package com.bst.ckt.service;

import com.bst.ckt.vo.TaskVO;

public interface TaskServiceInf {

	/**
	 * <p>
	 * <code>addTaskDetails()</code>
	 * method is use to add task allocation details into database.
	 *</p>
	 * 
	 * @return taskVO TaskVO
	 * @throws Exception
	 */
	
	public String addTaskDetails(TaskVO taskVO)throws Exception;

	/**
	 * <p>
	 * <code>addTaskSubject()</code>
	 * method is use to add task allocation details into database.
	 *</p>
	 * 
	 * @return taskVO TaskVO
	 * @throws Exception
	 */
	public String addTaskSubject(TaskVO taskVO)throws Exception;

	/**
	 * <p>
	 * <code>updateTaskDetails()</code>
	 * method is use to update task allocation details into database.
	 *</p>
	 * 
	 * @return taskVO TaskVO
	 * @throws Exception
	 */
	public String updateTaskDetails(TaskVO taskVO)throws Exception;

	



}
