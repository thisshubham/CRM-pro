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
 * Class Name     Salutation.java     
 *                                                            
 * Creation Date  NOV 9, 2015 
 * 
 * Abstract       This class is utility class for Salutation in project.
 * 
 * Amendment History (in chronological sequence): NOV 9, 2015
 * 
 **********************************************************************
 */

/**
 * @author shaikh hussain
 */


package com.bst.ckt.helper;

import java.io.Serializable;
import java.util.HashMap;

public class Salutation implements Comparable<Object>, Serializable{

	/**
	 * serialVersionUID is unique id for class in project implementation.
	 */
	private static final long serialVersionUID = 8398882971118001921L;
	private int id;
	
	
    	/**
	 * <p>List of Salutation id Constants.</p>
	 */
		
	public static final int MR_ID=1;	
	public static final int MS_ID=2;	
	public static final int MISS_ID=3;	
	public static final int MOHD_ID=4;	
	public static final int DR_ID=5;	
	public static final int PROF_ID=6;	
	public static final int OTHER_ID=7;	
	
    	/**
	 * <p>List of Salutation Constants.</p>
	 */
		
	public static final String MR="Mr.";
	public static final String MS="Ms.";
	public static final String MISS="Miss.";
	public static final String MOHD="Mohd.";
	public static final String DR="Dr.";
	public static final String PROF= "Prof.";
	public static final String OTHER= "Other";

	public Salutation() {
        // nothing will do
    }

    public Salutation(int id) {
        this.id = id;
    }

    

	/**
	 * Compare object with Salutation object for equality of hashCode.
	 * 
	 * @return 0 if not equals and return 1 if both are equals.
	 */
	@Override
	public int compareTo(Object obj) {

		if (this.hashCode() == obj.hashCode()) {
			return 1;
		}

		return 0;
	}

	
	/**
	 * This method will return Salutation based on id.
	 * 
	 * @param id
	 * @return
	 */
	public static String getSalutation(int id) {
		
		String YOUR_SALUTATION=null;
		
		switch (id) {
		
		case MR_ID:
			YOUR_SALUTATION=MR;
			break;
		case MS_ID:
			YOUR_SALUTATION=MS;
			break;
		case MISS_ID:
			YOUR_SALUTATION=MISS;
			break;
		case MOHD_ID:
			YOUR_SALUTATION=MOHD;
			break;
		case DR_ID:
			YOUR_SALUTATION=DR;
			break;
		case PROF_ID:
			YOUR_SALUTATION=PROF;
			break;
		case OTHER_ID:
			YOUR_SALUTATION=OTHER;
			break;
		}		
		return YOUR_SALUTATION;
	}
	
	
	/**
	 * <p>
	 * <code>getSalutationList</code>This method returns list of Salutation
	 * </p>
	 * 
	 * @return list of Salutation in HashTable object
	 */

	public static HashMap<Integer, String> getSalutationList() {
		HashMap<Integer, String> HashMap = new HashMap<Integer, String>();
		
		HashMap.put(new Integer(MR_ID), MR);
		HashMap.put(new Integer(MS_ID), MS);
		HashMap.put(new Integer(MISS_ID), MISS);
		HashMap.put(new Integer(MOHD_ID), MOHD);
		HashMap.put(new Integer(DR_ID), DR);
		HashMap.put(new Integer(PROF_ID), PROF);
		HashMap.put(new Integer(OTHER_ID), OTHER);
		return HashMap;
	}
	
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	
}
