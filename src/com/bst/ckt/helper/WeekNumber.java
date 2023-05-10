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
 * Class Name     WeekNumber.java     
 *                                                            
 * Creation Date  OCT 10, 2015 
 * 
 * Abstract       This class is utility class for Task Status in project.
 * 
 * Amendment History (in chronological sequence): OCT 10, 2015
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

public class WeekNumber implements Comparable<Object>, Serializable{

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

    public static final int FIRST_ID=1;
    public static final int SECOND_ID=2;
    public static final int THIRD_ID=3;
    public static final int FOURTH_ID=4;
    public static final int FIFTH_ID=5;
    
        
    public static final String FIRST="First";
    public static final String SECOND="Second";
    public static final String THIRD="Third";
    public static final String FOURTH="Fourth";
    public static final String FIFTH="Fifth";
    
    
    private int weekNumberid;
    private String weekNumber;
    
 
     
    public int getWeekNumberid() {
		return weekNumberid;
	}

	public void setWeekNumberid(int weekNumberid) {
		this.weekNumberid = weekNumberid;
	}

	public String getWeekNumber() {
		return weekNumber;
	}

	public void setWeekNumber(String weekNumber) {
		this.weekNumber = weekNumber;
	}
	
	public WeekNumber()
	{
		//will do nothing.
	}

	public WeekNumber(int weekNumberid)
	{
		this.weekNumberid=weekNumberid;	
	}
	
	public WeekNumber(int weekNumberid,String weekNumber)
	{
		this.weekNumberid=weekNumberid;	
		this.weekNumber=weekNumber;
	}
	
	
	/**
	 * This method will return weekNumber based on weekNumberId. 
     * @param weekNumberId
     * @return
     *
     */
    public static String getWeekNumber(int weekNumberId){
    	
    	String WEEK_NUMBER=null;
    	
    	switch(weekNumberId)
    	{
    		case FIRST_ID:
    			WEEK_NUMBER=FIRST;
    			break;
    		case SECOND_ID:
    			WEEK_NUMBER=SECOND;
    			break;
    		case THIRD_ID:
    			WEEK_NUMBER=THIRD;
    			break;
    		case FOURTH_ID:
    			WEEK_NUMBER=FOURTH;
    			break;
    		case FIFTH_ID:
    			WEEK_NUMBER=FIFTH;
    			break;
    	}
    	return WEEK_NUMBER;
	
    }
    
    /**
     * <p>This method returns list of week number List</p>
     * @return list of week number list in HashTable object
     */
    public static Hashtable<Integer, String> getWeekNumberList()
    {
    	Hashtable< Integer, String> hashtable=new Hashtable<Integer, String>();
    	hashtable.put(new Integer(FIRST_ID), FIRST);
    	hashtable.put(new Integer(SECOND_ID), SECOND);
    	hashtable.put(new Integer(THIRD_ID), THIRD);
    	hashtable.put(new Integer(FOURTH_ID), FOURTH);
    	hashtable.put(new Integer(FIFTH_ID), FIFTH);
    	return hashtable;
    }
    
}
