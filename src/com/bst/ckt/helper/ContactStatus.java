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

public class ContactStatus implements Comparable<Object>, Serializable {

	/**
	 * serialVersionUID is unique id for class in project implementation.
	 */
	private static final long serialVersionUID = 8398882971118001921L;
	private int id;
	private String statusName;

	/**
	 * <p>
	 * List of ContactStatus id Constants.
	 * </p>
	 */

	public static final int SUSPECT_ID = 1;
	public static final int PROSPECTING_ID = 2;
	public static final int CONFORMED_LEAD_ID = 3;
	public static final int CUSTOMER_ID = 4;
	public static final int FAILED_ID = 5;
	public static final int NOT_CONTACTSTATUS_ID = 6;

	/**
	 * <p>
	 * List of ContactStatus Constants.
	 * </p>
	 */

	public static final String SUSPECT = "Suspect";
	public static final String PROSPECTING = "Prospecting";
	public static final String CONFORMED_LEAD = "Conformed Lead";
	public static final String CUSTOMER = "Customer";
	public static final String FAILED = "Failed";
	public static final String NOT_CONTACTSTATUS = "Not Contact Status";

	public ContactStatus() {
		// nothing will do
	}

	public ContactStatus(int id) {
		this.id = id;
	}

	public ContactStatus(int id, String name) {
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

	public void setContactStatus(int id) {
		this.id = id;
	}

	public int getContactStatus() {
		return this.id;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	/**
	 * This method will return ContactStatus Name based on contactStatusId.
	 * 
	 * @param statusId
	 * @return
	 */
	public static String getAssignmentStatus(int statusId) {
		String CONTACT_STATUS = null;

		switch (statusId) {
		case SUSPECT_ID: {
			CONTACT_STATUS = SUSPECT;
			break;
		}
		case PROSPECTING_ID: {
			CONTACT_STATUS = PROSPECTING;
			break;
		}
		case CONFORMED_LEAD_ID: {
			CONTACT_STATUS = CONFORMED_LEAD;
			break;
		}
		case CUSTOMER_ID: {
			CONTACT_STATUS = CUSTOMER;
			break;
		}
		case FAILED_ID: {
			CONTACT_STATUS = FAILED;
			break;
		}

		default: {
			CONTACT_STATUS = NOT_CONTACTSTATUS;
		}
		}

		return CONTACT_STATUS;
	}

	/**
	 * <p>
	 * <code>getContactStatusList</code>This method returns list of Contact
	 * Status
	 * </p>
	 * 
	 * @return list of Contact Status in hashMap object
	 */

	public static HashMap<Integer, String> getContactStatusList() {

		HashMap<Integer, String> hashMap = new HashMap<Integer, String>();

		hashMap.put(new Integer(SUSPECT_ID), SUSPECT);
		hashMap.put(new Integer(PROSPECTING_ID), PROSPECTING);
		hashMap.put(new Integer(CONFORMED_LEAD_ID), CONFORMED_LEAD);
		hashMap.put(new Integer(CUSTOMER_ID), CUSTOMER);
		hashMap.put(new Integer(FAILED_ID), FAILED);
		hashMap.put(new Integer(NOT_CONTACTSTATUS_ID), NOT_CONTACTSTATUS);

		return hashMap;
	}

	/**
	 * <p>
	 * <code>getModifiedContactStatusList</code>This method returns list of
	 * Contact Status for changing the Contact Status.
	 * </p>
	 * 
	 * @return list of User Role in hashMap object
	 */
	/*
	 * public static HashMap<Integer, String> getModifiedContactStatusList() {
	 * HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
	 * 
	 * hashMap.put(new Integer(SUSPECT_ID), SUSPECT); hashMap.put(new
	 * Integer(PROSPECTING_ID), PROSPECTING); hashMap.put(new
	 * Integer(CONFORMED_LEAD_ID), CONFORMED_LEAD); hashMap.put(new
	 * Integer(CUSTOMER_ID), CUSTOMER); hashMap.put(new Integer(FAILED_ID),
	 * FAILED); hashMap.put(new Integer(NOT_CONTACTSTATUS_ID),
	 * NOT_CONTACTSTATUS);
	 * 
	 * return hashMap; }
	 */
}
