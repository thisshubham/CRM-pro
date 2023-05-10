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
 * Class Name     RepeatType.java     
 *                                                            
 * Creation Date  OCT 8, 2015 
 * 
 * Abstract       This class is utility class for Task Repeat Type in project.
 * 
 * Amendment History (in chronological sequence): OCT 8, 2015
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

public class RepeatType implements Comparable<Object>, Serializable{

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

    public static final int NONE_ID=1;
    public static final int DAILY_ID=2;
    public static final int WEEKLY_ID=3;
    public static final int MONTHLY_ID=4;
    public static final int YEARLY_ID=5;
    
        
    public static final String NONE="None";
    public static final String DAILY="Daily";
    public static final String WEEKLY="Weekly";
    public static final String MONTHLY="Monthly";
    public static final String YEARLY="Yearly";
  
    
    private int repeatTypeId;
    private String repeatTypeName;

    public int getRepeatTypeId() {
		return repeatTypeId;
	}

	public void setRepeatTypeId(int repeatTypeId) {
		this.repeatTypeId = repeatTypeId;
	}

	public String getRepeatTypeName() {
		return repeatTypeName;
	}

	public void setRepeatTypeName(String repeatTypeName) {
		this.repeatTypeName = repeatTypeName;
	}

	public RepeatType()
	{
		//will do nothing.
	}
	
	public RepeatType(int repeatTypeId)
	{
		this.repeatTypeId=repeatTypeId;
		
	}
	
	public RepeatType(int repeatTypeId,String repeatTypeName)
	{
		this.repeatTypeId=repeatTypeId;
		this.repeatTypeName=repeatTypeName;
	}
	/**
     * This method will return Repeat Type Name based on Repeat Type Id.
     * @param repeatTypeId
     * @return
     */
    public static String getRepeatTypeName(int repeatTypeId){
    	
    	String REPEAT_TYPE=null;
    	
    	switch(repeatTypeId)
    	{
    		case NONE_ID:
    			REPEAT_TYPE=NONE;
    		break;
    		case DAILY_ID:
        		REPEAT_TYPE=DAILY;
        		break;
    		case WEEKLY_ID:
        		REPEAT_TYPE=WEEKLY;
        		break;
    		case MONTHLY_ID:
        		REPEAT_TYPE=MONTHLY;
        		break;
    		case YEARLY_ID:
        		REPEAT_TYPE=YEARLY;
        		break;
    	}
    	return REPEAT_TYPE;
    	
    }
    
    /**
     * <p>This method returns list of Repeat Type</p>
     * @return list of Task Status in HashTable object
     */
    public static Hashtable<Integer, String> getRepeatTypeList()
    {
    	Hashtable<Integer, String> hashtable=new Hashtable<Integer, String>();
    	hashtable.put(new Integer(NONE_ID), NONE);
    	hashtable.put(new Integer(DAILY_ID), DAILY);
    	hashtable.put(new Integer(WEEKLY_ID), WEEKLY);
    	hashtable.put(new Integer(MONTHLY_ID), MONTHLY);
    	hashtable.put(new Integer(YEARLY_ID), YEARLY);
    	return hashtable;
    }
    
}

