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
 * Class Name     DaysName.java     
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

public class DaysName implements Comparable<Object>, Serializable{

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

    public static final int SUNDAY_ID=1;
    public static final int MONDAY_ID=2;
    public static final int TUESDAY_ID=3;
    public static final int WEDNESDAY_ID=4;
    public static final int THUSDAY_ID=5;
    public static final int FRIDAY_ID=6;
    public static final int SATURDAY_ID=7;
  
        
    public static final String SUNDAY="Sunday";
    public static final String MONDAY="Monday";
    public static final String TUESDAY="Tuesday";
    public static final String WEDNESDAY="Wednesday";
    public static final String THUSDAY="Thusday";
    public static final String FRIDAY="Friday";
    public static final String SATURDAY="Saturday";
    
    private int dayId;
    private String dayName;
    
    public int getDayId() {
		return dayId;
	}

	public void setDayId(int dayId) {
		this.dayId = dayId;
	}

	public String getDayName() {
		return dayName;
	}

	public void setDayName(String dayName) {
		this.dayName = dayName;
	}

	public DaysName()
	{
		//will do nothing
	}
	
	public DaysName(int dayId)
	{
		this.dayId=dayId;
	}
	
	public DaysName(int dayId,String dayName)
	{
		this.dayId=dayId;
		this.dayName=dayName;
	}
     
    /**
     * This method will return DayName based on dayId.
     * @param dayId
     * @return
     */
    public static String getDayName(int dayId){
    	
    	String DAY_NAME=null;
    	
    	switch(dayId)
    	{
    		case SUNDAY_ID:
    			DAY_NAME=SUNDAY;
    			break;
    		case MONDAY_ID:
    			DAY_NAME=MONDAY;
    			break;
    		case TUESDAY_ID:
    			DAY_NAME=TUESDAY;
    			break;
    		case WEDNESDAY_ID:
    			DAY_NAME=WEDNESDAY;
    			break;
    		case THUSDAY_ID:
    			DAY_NAME=THUSDAY;
    			break;
    		case FRIDAY_ID:
    			DAY_NAME=FRIDAY;
    			break;
    		case SATURDAY_ID:
    			DAY_NAME=SATURDAY;
    			break;
    	}
    	return DAY_NAME;
	
    }
    
    /**
     * <p>This method returns list of day name</p>
     * @return list of day name in HashTable object
     */
    public static Hashtable<Integer, String> getDayNameList()
    {
    	Hashtable< Integer, String> hashtable=new Hashtable<Integer, String>();
    	 hashtable.put(new Integer(SUNDAY_ID), SUNDAY);
    	 hashtable.put(new Integer(MONDAY_ID), MONDAY);
    	 hashtable.put(new Integer(TUESDAY_ID), TUESDAY);
    	 hashtable.put(new Integer(WEDNESDAY_ID), WEDNESDAY);
    	 hashtable.put(new Integer(THUSDAY_ID), THUSDAY);
    	 hashtable.put(new Integer(FRIDAY_ID), FRIDAY);
    	 hashtable.put(new Integer(SATURDAY_ID), SATURDAY);    	 
    	
    	return hashtable;
    }
    
}
