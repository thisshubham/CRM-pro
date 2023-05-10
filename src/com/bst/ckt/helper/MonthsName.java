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
 * Class Name     MonthsName.java     
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

public class MonthsName implements Comparable<Object>, Serializable{

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

    public static final int JANUARY_ID=1;
    public static final int FEBUARY_ID=2;
    public static final int MARCH_ID=3;
    public static final int APRIL_ID=4;
    public static final int MAY_ID=5;
    public static final int JUNE_ID=6;
    public static final int JULY_ID=7;
    public static final int AUGUEST_ID=8;
    public static final int SEPTEMBER_ID=9;
    public static final int OCTOBER_ID=10;
    public static final int NOVEMBER_ID=11;
    public static final int DECEMBER_ID=12;
  
        
    public static final String JANURAY="January";
    public static final String FEBUARY="Febuary";
    public static final String MARCH="March";
    public static final String APRIL="April";
    public static final String MAY="May";
    public static final String JUNE="June";
    public static final String JULY="July";
    public static final String AUGUEST="Auguest";
    public static final String SEPTEMBER="September";
    public static final String OCTOBER="October";
    public static final String NOVEMBER="November";
    public static final String DECEMBER="December";    

    private int monthId;
    private String monthName;
    
 
     
    public int getMonthId() {
		return monthId;
	}

	public void setMonthId(int monthId) {
		this.monthId = monthId;
	}

	public String getMonthName() {
		return monthName;
	}

	public void setMonthName(String monthName) {
		this.monthName = monthName;
	}
	
	public MonthsName()
	{
		//will do nothing.
	}
	
	public MonthsName(int monthId)
	{
		this.monthId=monthId;
	}
	
	public MonthsName(int monthId,String monthName)
	{
		this.monthId=monthId;
		this.monthName=monthName;
	}

	/**
     * This method will return monthName based on monthId.
     * @param monthId
     * @return
     */
    public static String getMonthName(int monthId){
    	
    	String MONTH_NAME=null;
    	
    	switch(monthId)
    	{
    		case JANUARY_ID:
    			MONTH_NAME=JANURAY;
    			break;
    		case FEBUARY_ID:
    			MONTH_NAME=FEBUARY;
    			break;
    		case MARCH_ID:
    			MONTH_NAME=MARCH;
    			break;
    		case APRIL_ID:
    			MONTH_NAME=APRIL;
    			break;
    		case MAY_ID:
    			MONTH_NAME=MAY;
    			break;
    		case JUNE_ID:
    			MONTH_NAME=JUNE;
    			break;
    		case JULY_ID:
    			MONTH_NAME=JULY;
    			break;
    		case AUGUEST_ID:
    			MONTH_NAME=AUGUEST;
    			break;
    		case SEPTEMBER_ID:
    			MONTH_NAME=SEPTEMBER;
    			break;
    		case OCTOBER_ID:
    			MONTH_NAME=OCTOBER;
    			break;
    		case NOVEMBER_ID:
    			MONTH_NAME=NOVEMBER;
    			break;
    		case DECEMBER_ID:
    			MONTH_NAME=DECEMBER;
    			break;
    	}
    	return MONTH_NAME;
	
    }
    
    /**
     * <p>This method returns list of month name</p>
     * @return list of month name in HashTable object
     */
    public static Hashtable<Integer, String> getMonthsNameList()
    {
    	Hashtable< Integer, String> hashtable=new Hashtable<Integer, String>();
    	 hashtable.put(new Integer(JANUARY_ID), JANURAY);
    	 hashtable.put(new Integer(FEBUARY_ID), FEBUARY);
    	 hashtable.put(new Integer(MARCH_ID), MARCH);
    	 hashtable.put(new Integer(APRIL_ID), APRIL);
    	 hashtable.put(new Integer(MAY_ID),MAY );
    	 hashtable.put(new Integer(JUNE_ID), JUNE);
    	 hashtable.put(new Integer(JULY_ID), JULY);    	 
    	 hashtable.put(new Integer(AUGUEST_ID), AUGUEST);
    	 hashtable.put(new Integer(SEPTEMBER_ID), SEPTEMBER);
    	 hashtable.put(new Integer(OCTOBER_ID), OCTOBER);
    	 hashtable.put(new Integer(NOVEMBER_ID), NOVEMBER);
    	 hashtable.put(new Integer(DECEMBER_ID), DECEMBER);   	
    	return hashtable;
    }
    
}
