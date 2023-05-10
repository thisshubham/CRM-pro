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
 * Class Name     TaskPriority.java     
 *                                                            
 * Creation Date  OCT 5, 2015 
 * 
 * Abstract       This class is utility class for Task Priority in project.
 * 
 * Amendment History (in chronological sequence): OCT 5, 2015
 * 
 **********************************************************************
 */
package com.bst.ckt.helper;

import java.io.Serializable;
import java.util.Hashtable;

public class TaskPriority implements Comparable<Object>, Serializable{
	
	/**
	 * serialVersionUID is unique id for class in project implementation.
	 */
	private static final long serialVersionUID = 8398882971118001921L;

	   /**
     * Compare object with TaskPriority object for equality of hashCode.
     * @return 0 if not equals and return 1 if both are equals.
     */
    public int compareTo(Object obj) {

    	if(this.hashCode() == obj.hashCode())
    	{
    		return 1;
    	}

        return 0;
    }
    
    public static final int AURGENT_ID=1; 
    public static final int HIGH_ID=2;
    public static final int MEDIUM_ID=3;
    public static final int LOW_ID=4;
    
    public static final String AURGENT="Aurgent"; 
    public static final String HIGH="High";
    public static final String MEDIUM="Medium";
    public static final String LOW="Low";
    
    private int id;
    private String priority;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
    
	public TaskPriority()
	{
		//this will do nothing.
	}
	
	public TaskPriority(int id)
	{
		this.id = id;
	}
	
	public TaskPriority(int id,String priority)
	{
		this.id=id;
		this.priority=priority;
	}
	
	/**
     * This method will return TaskPriority Name based on id.
     * @param id
     * @return
     */
	public static String getTaskPriority(int id)
	{
		String TASK_PRIORITY=null;
		
		switch(id)
		{
			case AURGENT_ID:
				TASK_PRIORITY=AURGENT;
				break;
			case HIGH_ID:
				TASK_PRIORITY=HIGH;
				break;
			case MEDIUM_ID:
				TASK_PRIORITY=MEDIUM;
				break;
			case LOW_ID:
				TASK_PRIORITY=LOW;
				break;
		}
		return TASK_PRIORITY;
	}
	
	 /**
     * <p>This method returns list of Task Priority</p>
     * @return list of Task Priority in HashTable object
     */
	
	public static Hashtable<Integer, String> getTaskPriorityList()
	{
		Hashtable< Integer, String> hashtable=new Hashtable<Integer, String>();
		
		hashtable.put(new Integer(AURGENT_ID), AURGENT);
		hashtable.put(new Integer(HIGH_ID), HIGH);
		hashtable.put(new Integer(MEDIUM_ID), MEDIUM);
		hashtable.put(new Integer(LOW_ID), LOW);
		
		return hashtable;
		
	}
    
    

}
