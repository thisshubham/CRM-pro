/*
 **********************************************************************
 *
 * COPYRIGHT. $ID$ 2014. ALL RIGHTS RESERVED.
 *
 * This software is only to be used for the purpose for which it has been
 * provided. No part of it is to be reproduced, disassembled, transmitted,
 * stored in a retrieval system nor translated in any human or computer
 * language in any way or for any other purposes whatsoever without the
 * prior written consent of $ID$.
 * 
 * Class Name     TaskStatus.java     
 *                                                            
 * Creation Date  OCT 5, 2015 
 * 
 * Abstract       This class is utility class for Task Status in project.
 * 
 * Amendment History (in chronological sequence): OCT 5, 2015
 * 
 **********************************************************************
 */
package com.bst.ckt.helper;

import java.io.Serializable;
import java.util.Hashtable;

/**
 * 
 * @author Shaikh Hussain 
 *
 */

public class TaskStatus implements Comparable<Object>, Serializable{

	/**
	 * serialVersionUID is unique id for class in project implementation.
	 */
	private static final long serialVersionUID = 8398882971118001921L;

	   /**
     * Compare object with UserStatus object for equality of hashCode.
     * @return 0 if not equals and return 1 if both are equals.
     */
    public int compareTo(Object obj) {

    	if(this.hashCode() == obj.hashCode())
    	{
    		return 1;
    	}

        return 0;
    }

    public static final int NEW_ID=1;
    public static final int OPEN_ID=2;
    public static final int ASSIGNED_ID=3;
    public static final int IN_PROGRESS_ID=4;
    public static final int DUPLICATE_ID=5;
    public static final int REJECTED_ID=6;
    public static final int COMPLETED_ID=7;
    public static final int DELETED_ID=8;
        
    public static final String NEW="New";
    public static final String OPEN="Open";
    public static final String ASSIGNED="Assigned";
    public static final String IN_PROGRESS="Inprogress";
    public static final String DUPLICATE="Duplicate";
    public static final String REJECTED="Rejected";
    public static final String COMPLETED="Completed";
    public static final String DELETED="Deleted";
    
    private int taskId;
    private String taskStatusName;

	public int getTaskId() {
		return taskId;
	}
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	
	public String getTaskStatusName() {
		return taskStatusName;
	}
	public void setTaskStatusName(String taskStatusName) {
		this.taskStatusName = taskStatusName;
	}
    
    public TaskStatus()
    {
    	//this will do nothing.
    }
    
    public TaskStatus(int taskId)
    {
    	this.taskId = taskId;
    }
    
    public TaskStatus(int taskId,String taskStatusName)
    {
    	this.taskId = taskId;
    	this.taskStatusName=taskStatusName;
    }
    
    /**
     * This method will return TaskStatus Name based on taskId.
     * @param taskId
     * @return
     */
    public static String getTaskStatusName(int taskId){
    	
    	String TASK_STATUS=null;
    	
    	switch(taskId)
    	{
    		case NEW_ID:
    		TASK_STATUS=NEW;
    		break;
    		case OPEN_ID:
        		TASK_STATUS=OPEN;
        		break;
    		case ASSIGNED_ID:
        		TASK_STATUS=ASSIGNED;
        		break;
    		case IN_PROGRESS_ID:
        		TASK_STATUS=IN_PROGRESS;
        		break;
    		case DUPLICATE_ID:
        		TASK_STATUS=DUPLICATE;
        		break;
    		case REJECTED_ID:
        		TASK_STATUS=REJECTED;
        		break;
    		case COMPLETED_ID:
        		TASK_STATUS=COMPLETED;
        		break;
    		case DELETED_ID:
        		TASK_STATUS=DELETED;
        		break;
    	}
    	return TASK_STATUS;
    	
    }
    
    /**
     * <p>This method returns list of Task Status</p>
     * @return list of Task Status in HashTable object
     */
    public static Hashtable<Integer, String> getTaskStatusList()
    {
    	Hashtable< Integer, String> hashtable=new Hashtable<Integer, String>();
    	hashtable.put(new Integer(NEW_ID), NEW);
    	hashtable.put(new Integer(OPEN_ID),OPEN);
    	hashtable.put(new Integer(ASSIGNED_ID), ASSIGNED);
    	hashtable.put(new Integer(IN_PROGRESS_ID), IN_PROGRESS);
    	hashtable.put(new Integer(DUPLICATE_ID), DUPLICATE);
    	hashtable.put(new Integer(REJECTED_ID), REJECTED);
    	hashtable.put(new Integer(COMPLETED_ID), COMPLETED);
    	hashtable.put(new Integer(DELETED_ID), DELETED);
    	
    	return hashtable;
    }
    
    /**
     * <p>This method returns list of Task Status when task is new and Admin wants to change the task status.</p>
     * @return list of User Role in HashTable object
     */
    public static Hashtable<Integer, String> getModifiedTaskStatusList()
    {
    	Hashtable< Integer, String> hashtable=new Hashtable<Integer, String>();
    	hashtable.put(new Integer(OPEN_ID),OPEN);
    	hashtable.put(new Integer(ASSIGNED_ID), ASSIGNED);
    	hashtable.put(new Integer(IN_PROGRESS_ID), IN_PROGRESS);
    	hashtable.put(new Integer(DUPLICATE_ID), DUPLICATE);
    	hashtable.put(new Integer(REJECTED_ID), REJECTED);
    	hashtable.put(new Integer(COMPLETED_ID), COMPLETED);
    	hashtable.put(new Integer(DELETED_ID), DELETED);
    	
    	return hashtable;
    }
    
}
