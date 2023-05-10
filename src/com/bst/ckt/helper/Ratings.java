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
 * Class Name     Ratings.java     
 *                                                            
 * Creation Date  NOV 26, 2015 
 * 
 * Abstract       This class is utility class for Ratings in project.
 * 
 * Amendment History (in chronological sequence): NOV 26, 2015
 * 
 **********************************************************************
 */

package com.bst.ckt.helper;

import java.io.Serializable;
import java.util.HashMap;

/**
 * 
 * @author shaikh hussain
 * 
 */

public class Ratings implements Comparable<Object>, Serializable {

	/**
	 * serialVersionUID is unique id for class in project implementation.
	 */
	private static final long serialVersionUID = 8398882971118001921L;
	private int id;
	private String ratingName;

	/**
	 * <p>
	 * List of Ratings id Constants.
	 * </p>
	 */
	/*
	 * Acquired Active Market Failed Project Cancelled Shut Down
	 */

	public static final int ACQUIRED_ID = 1;
	public static final int ACTIVE_ID = 2;
	public static final int MARKET_FAILED_ID = 3;
	public static final int PROJECT_CANCELLED_ID = 4;
	public static final int SHUT_DOWN_ID = 5;

	/**
	 * <p>
	 * List of RatingsName Constants.
	 * </p>
	 */
	public static final String ACQUIRED = "Acquired";
	public static final String ACTIVE = "Active";
	public static final String MARKET_FAILED = "Market Failed";
	public static final String PROJECT_CANCELLED = "Project Cancelled";
	public static final String SHUT_DOWN = "Shut Down";

	public Ratings() {
		// nothing will do
	}

	public Ratings(int id) {
		this.id = id;
	}

	public Ratings(int id, String name) {
		this.id = id;
		this.ratingName = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRatingName() {
		return ratingName;
	}

	public void setRatingName(String ratingName) {
		this.ratingName = ratingName;
	}

	/**
	 * Compare object with RatingNames object for equality of hashCode.
	 * 
	 * @return 0 if not equals and return 1 if both are equals.
	 */
	public int compareTo(Object obj) {

		if (this.hashCode() == obj.hashCode()) {
			return 1;
		}

		return 0;
	}

	/**
	 *<code>getRatingName()</code> This method will return Ratings Name based on id.
	 * 
	 * @param id
	 *            ;
	 * @return
	 */
	public static String getRatingName(int id) {
		String RATING_NAME = null;

		switch (id) {
		case ACQUIRED_ID: {
			RATING_NAME = ACQUIRED;
			break;
		}
		case ACTIVE_ID: {
			RATING_NAME = ACTIVE;
			break;
		}
		case MARKET_FAILED_ID: {
			RATING_NAME = MARKET_FAILED;
			break;
		}
		case PROJECT_CANCELLED_ID: {
			RATING_NAME = PROJECT_CANCELLED;
			break;
		}
		case SHUT_DOWN_ID: {
			RATING_NAME = SHUT_DOWN;
			break;
		}
		}

		return RATING_NAME;
	}

	/**
	 * <p>
	 * <code>getRatingList</code>This method returns list of ratings
	 * </p>
	 * 
	 * @return list of ratings in HashTable object
	 */

	public static HashMap<Integer, String> getRatingList() {
		HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
		hashMap.put(new Integer(ACQUIRED_ID), ACQUIRED);
		hashMap.put(new Integer(ACTIVE_ID), ACTIVE);
		hashMap.put(new Integer(MARKET_FAILED_ID), MARKET_FAILED);
		hashMap.put(new Integer(PROJECT_CANCELLED_ID), PROJECT_CANCELLED);
		hashMap.put(new Integer(SHUT_DOWN_ID), SHUT_DOWN);
		
		return hashMap;
	}

}
