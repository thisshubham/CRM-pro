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

public class ExpensesClaimStatus implements Comparable<Object>, Serializable {

	/**
	 * serialVersionUID is unique id for class in project implementation.
	 */
	private static final long serialVersionUID = 8398882971118001921L;
	private int id;
	private String statusName;

	/**
	 * <p>
	 * List of ExpensesClaimStatus id Constants.
	 * </p>
	 */

	public static final int NEW_ID = 1;
	public static final int SUBMITED_ID = 2;
	public static final int APPROVED_ID = 3;
	public static final int REJECTED_ID = 4;
	public static final int CANCELED_ID = 5;
	public static final int DELETED_ID = 6;
	public static final int NOT_CLAIMSTATUS_ID = 7;
	

	/**
	 * <p>
	 * List of ExpensesClaimStatus Constants.
	 * </p>
	 */

	public static final String NEW = "New";
	public static final String SUBMITED = "submited";
	public static final String APPROVED = "approved";
	public static final String REJECTED = "rejected";
	public static final String CANCELED = "canceled";
	public static final String DELETED = "deleted";	
	public static final String NOT_CLAIMSTATUS = "Not Claim Status";

	public ExpensesClaimStatus() {
		// nothing will do
	}

	public ExpensesClaimStatus(int id) {
		this.id = id;
	}

	public ExpensesClaimStatus(int id, String name) {
		this.id = id;
		this.statusName = name;
	}

	/**
	 * Compare object with ExpensesClaimStatus object for equality of hashCode.
	 * 
	 * @return 0 if not equals and return 1 if both are equals.
	 */
	public int compareTo(Object obj) {

		if (this.hashCode() == obj.hashCode()) {
			return 1;
		}

		return 0;
	}

	public void setClaimStatus(int id) {
		this.id = id;
	}

	public int getClaimStatusId() {
		return this.id;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	/**
	 * This method will return ExpensesClaimStatus Name based on ExpensesClaimId.
	 * 
	 * @param statusId
	 * @return
	 */
	public static String getExpensesClaimStatus(int statusId) {
		String CLAIM_STATUS = null;

		switch (statusId) {
		case NEW_ID: {
			CLAIM_STATUS = NEW;
			break;
		}
		case SUBMITED_ID: {
			CLAIM_STATUS = SUBMITED;
			break;
		}
		case APPROVED_ID: {
			CLAIM_STATUS = APPROVED;
			break;
		}
		case REJECTED_ID: {
			CLAIM_STATUS = REJECTED;
			break;
		}
		case CANCELED_ID: {
			CLAIM_STATUS = CANCELED;
			break;
		}
		case DELETED_ID: {
			CLAIM_STATUS = DELETED;
			break;
		}	

		default: {
			CLAIM_STATUS = NOT_CLAIMSTATUS;
		}
		}

		return CLAIM_STATUS;
	}

	/**
	 * <p>
	 * <code>getExpensesClaimStatusList</code>This method returns list of Expenses Claim Status
	 * </p>
	 * 
	 * @return list of Expenses Claim Status in HashTable object
	 */

	public static HashMap<Integer, String> getExpensesClaimStatusList() {

		HashMap<Integer, String> hashMap = new HashMap<Integer, String>();

		hashMap.put(new Integer(NEW_ID), NEW);
		hashMap.put(new Integer(SUBMITED_ID), SUBMITED);
		hashMap.put(new Integer(APPROVED_ID), APPROVED);
		hashMap.put(new Integer(REJECTED_ID), REJECTED);
		hashMap.put(new Integer(CANCELED_ID), CANCELED);
		hashMap.put(new Integer(DELETED_ID), DELETED);
		hashMap.put(new Integer(NOT_CLAIMSTATUS_ID), NOT_CLAIMSTATUS);

		return hashMap;
	}

	/**
	 * <p>
	 * <code>getModifiedExpensesClaimStatusList</code>This method returns list of Expenses Claim
	 * Status for changing the Expenses Claim Status.
	 * </p>
	 * 
	 */
	public static HashMap<Integer, String> getModifiedExpensesClaimStatusList() {
		HashMap<Integer, String> hashMap = new HashMap<Integer, String>();

		hashMap.put(new Integer(NEW_ID), NEW);
		hashMap.put(new Integer(SUBMITED_ID), SUBMITED);
		hashMap.put(new Integer(APPROVED_ID), APPROVED);
		hashMap.put(new Integer(REJECTED_ID), REJECTED);
		hashMap.put(new Integer(CANCELED_ID), CANCELED);
		hashMap.put(new Integer(DELETED_ID), DELETED);
		hashMap.put(new Integer(NOT_CLAIMSTATUS_ID), NOT_CLAIMSTATUS);


		return hashMap;
	}
}
