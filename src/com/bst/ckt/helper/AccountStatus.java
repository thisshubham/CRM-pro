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
 * Class Name     UserStatus.java     
 *                                                            
 * Creation Date  OCT 4, 2014 
 * 
 * Abstract       This class is utility class for User Status in project.
 * 
 * Amendment History (in chronological sequence): OCT 4, 2014
 * 
 **********************************************************************
 */

package com.bst.ckt.helper;

import java.io.Serializable;
import java.util.HashMap;

public class AccountStatus implements Comparable<Object>, Serializable {

	/**
	 * serialVersionUID is unique id for class in project implementation.
	 */
	private static final long serialVersionUID = 8398882971118001921L;
	private int id;
	private String statusName;

	/**
	 * <p>
	 * List of AccountStatus id Constants.
	 * </p>
	 */

	public static final int ACQUIRED_ID = 1;
	public static final int ACTIVE_ID = 2;
	public static final int MARKET_FAILED_ID = 3;
	public static final int PROJECT_CANCELLED_ID = 4;
	public static final int SHUT_DOWN_ID = 5;
	public static final int NOT_ACCOUNTSTATUS_ID = 6;

	/**
	 * <p>
	 * List of AccountStatus Constants.
	 * </p>
	 */

	public static final String ACQUIRED = "Acquired";
	public static final String ACTIVE = "Active";
	public static final String MARKET_FAILED = "Market Failed";
	public static final String PROJECT_CANCELLED = "Shut Down";
	public static final String SHUT_DOWN = "Project Cancelled";
	public static final String NOT_ACCOUNTSTATUS = "Not Account Status";

	public AccountStatus() {
		// nothing will do
	}

	public AccountStatus(int id) {
		this.id = id;
	}

	public AccountStatus(int id, String name) {
		this.id = id;
		this.statusName = name;
	}

	/**
	 * Compare object with AccountStatus object for equality of hashCode.
	 * 
	 * @return 0 if not equals and return 1 if both are equals.
	 */
	public int compareTo(Object obj) {

		if (this.hashCode() == obj.hashCode()) {
			return 1;
		}

		return 0;
	}

	public void setAccountStatus(int id) {
		this.id = id;
	}

	public int getAccountStatusId() {
		return this.id;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	/**
	 * This method will return AccountStatus Name based on accountStatusId.
	 * 
	 * @param statusId
	 * @return
	 */
	public static String getAssignmentStatus(int statusId) {
		String ACCOUNT_STATUS = null;

		switch (statusId) {
		case ACQUIRED_ID: {
			ACCOUNT_STATUS = ACQUIRED;
			break;
		}
		case ACTIVE_ID: {
			ACCOUNT_STATUS = ACTIVE;
			break;
		}
		case MARKET_FAILED_ID: {
			ACCOUNT_STATUS = MARKET_FAILED;
			break;
		}
		case PROJECT_CANCELLED_ID: {
			ACCOUNT_STATUS = PROJECT_CANCELLED;
			break;
		}
		case SHUT_DOWN_ID: {
			ACCOUNT_STATUS = SHUT_DOWN;
			break;
		}

		default: {
			ACCOUNT_STATUS = NOT_ACCOUNTSTATUS;
		}
		}

		return ACCOUNT_STATUS;
	}

	/**
	 * <p>
	 * <code>getProductStatusList</code>This method returns list of Account
	 * Status
	 * </p>
	 * 
	 * @return list of Account Status in hashMap object
	 */

	public static HashMap<Integer, String> getProductStatusList() {

		HashMap<Integer, String> hashMap = new HashMap<Integer, String>();

		hashMap.put(new Integer(ACQUIRED_ID), ACQUIRED);
		hashMap.put(new Integer(ACTIVE_ID), ACTIVE);
		hashMap.put(new Integer(MARKET_FAILED_ID), MARKET_FAILED);
		hashMap.put(new Integer(PROJECT_CANCELLED_ID), PROJECT_CANCELLED);
		hashMap.put(new Integer(SHUT_DOWN_ID), SHUT_DOWN);
		hashMap.put(new Integer(NOT_ACCOUNTSTATUS_ID), NOT_ACCOUNTSTATUS);

		return hashMap;
	}

	/**
	 * <p>
	 * <code>getModifiedProductStatusList</code>This method returns list of
	 * Account Status for changing the Account Status.
	 * </p>
	 * 
	 * @return list of User Role in hashMap object
	 */
	/*
	 * public static HashMap<Integer, String> getModifiedProductStatusList() {
	 * HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
	 * 
	 * hashMap.put(new Integer(ACQUIRED_ID), ACQUIRED); hashMap.put(new
	 * Integer(ACTIVE_ID), ACTIVE); hashMap.put(new Integer(MARKET_FAILED_ID),
	 * MARKET_FAILED); hashMap.put(new Integer(PROJECT_CANCELLED_ID),
	 * PROJECT_CANCELLED); hashMap.put(new Integer(SHUT_DOWN_ID), SHUT_DOWN);
	 * hashMap.put(new Integer(NOT_ACCOUNTTSTATUS_ID), NOT_ACCOUNTTSTATUS);
	 * 
	 * return hashMap; }
	 */
}
