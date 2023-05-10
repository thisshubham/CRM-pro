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

public class LeadStatus implements Comparable<Object>, Serializable {

	/**
	 * serialVersionUID is unique id for class in project implementation.
	 */
	private static final long serialVersionUID = 8398882971118001921L;
	private int id;
	private String statusName;

	/**
	 * <p>
	 * List of UserStatus id Constants.
	 * </p>
	 */

	public static final int NEW_ID = 1;
	public static final int ATTEMPTED_TO_CONTACT_ID = 2;
	public static final int COLD_ID = 3;
	public static final int CONTACTED_ID = 4;
	public static final int CONTACT_IN_FUTURE_ID = 5;
	public static final int HOT_ID = 6;
	public static final int JUNK_LEAD_ID = 7;
	public static final int LOST_LEAD_ID = 8;
	public static final int NOT_CONTACTED_ID = 9;
	public static final int PRE_QUALIFIED_ID = 10;
	public static final int WARM_ID = 11;
	public static final int NOT_LEADSTATUS_ID = 12;

	/**
	 * <p>
	 * List of UserStatus Constants.
	 * </p>
	 */

	public static final String NEW = "New";
	public static final String ATTEMPTED_TO_CONTACT = "Attempted to Contact";
	public static final String COLD = "Cold";
	public static final String CONTACTED = "Contacted";
	public static final String CONTACT_IN_FUTURE = "Contact in Future";
	public static final String HOT = "Hot";
	public static final String JUNK_LEAD = "Junk Lead";
	public static final String LOST_LEAD = "Lost Lead";
	public static final String NOT_CONTACTED = "Not Contacted";
	public static final String PRE_QUALIFIED = "Pre Qualified";
	public static final String WARM = "Warm";
	public static final String NOT_LEADSTATUS = "Not Lead Status";

	public LeadStatus() {
		// nothing will do
	}

	public LeadStatus(int id) {
		this.id = id;
	}

	public LeadStatus(int id, String name) {
		this.id = id;
		this.statusName = name;
	}

	/**
	 * Compare object with LeadStatus object for equality of hashCode.
	 * 
	 * @return 0 if not equals and return 1 if both are equals.
	 */
	public int compareTo(Object obj) {

		if (this.hashCode() == obj.hashCode()) {
			return 1;
		}

		return 0;
	}

	public void setLeadStatus(int id) {
		this.id = id;
	}

	public int getLeadStatusId() {
		return this.id;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	/**
	 * This method will return LeadStatus Name based on leadStatusId.
	 * 
	 * @param statusId
	 * @return
	 */
	public static String getLeadStatus(int statusId) {
		String LEAD_STATUS = null;

		switch (statusId) {
		case NEW_ID: {
			LEAD_STATUS = NEW;
			break;
		}
		case ATTEMPTED_TO_CONTACT_ID: {
			LEAD_STATUS = ATTEMPTED_TO_CONTACT;
			break;
		}
		case COLD_ID: {
			LEAD_STATUS = COLD;
			break;
		}
		case CONTACTED_ID: {
			LEAD_STATUS = CONTACTED;
			break;
		}
		case CONTACT_IN_FUTURE_ID: {
			LEAD_STATUS = CONTACT_IN_FUTURE;
			break;
		}
		case HOT_ID: {
			LEAD_STATUS = HOT;
			break;
		}
		case JUNK_LEAD_ID: {
			LEAD_STATUS = JUNK_LEAD;
			break;
		}
		case LOST_LEAD_ID: {
			LEAD_STATUS = LOST_LEAD;
			break;
		}
		case NOT_CONTACTED_ID: {
			LEAD_STATUS = NOT_CONTACTED;
			break;
		}
		case PRE_QUALIFIED_ID: {
			LEAD_STATUS = PRE_QUALIFIED;
			break;
		}
		case WARM_ID: {
			LEAD_STATUS = WARM;
			break;
		}

		default: {
			LEAD_STATUS = NOT_LEADSTATUS;
		}
		}

		return LEAD_STATUS;
	}

	/**
	 * <p>
	 * <code>getLeadStatusList</code>This method returns list of Lead Status
	 * </p>
	 * 
	 * @return list of Lead Status in HashTable object
	 */

	public static HashMap<Integer, String> getLeadStatusList() {

		HashMap<Integer, String> hashMap = new HashMap<Integer, String>();

		hashMap.put(new Integer(NEW_ID), NEW);
		hashMap.put(new Integer(ATTEMPTED_TO_CONTACT_ID), ATTEMPTED_TO_CONTACT);
		hashMap.put(new Integer(COLD_ID), COLD);
		hashMap.put(new Integer(CONTACTED_ID), CONTACTED);
		hashMap.put(new Integer(CONTACT_IN_FUTURE_ID), CONTACT_IN_FUTURE);
		hashMap.put(new Integer(HOT_ID), HOT);
		hashMap.put(new Integer(JUNK_LEAD_ID), JUNK_LEAD);
		hashMap.put(new Integer(LOST_LEAD_ID), LOST_LEAD);
		hashMap.put(new Integer(NOT_CONTACTED_ID), NOT_CONTACTED);
		hashMap.put(new Integer(PRE_QUALIFIED_ID), PRE_QUALIFIED);
		hashMap.put(new Integer(WARM_ID), WARM);
		hashMap.put(new Integer(NOT_LEADSTATUS_ID), NOT_LEADSTATUS);

		return hashMap;
	}

	/**
	 * <p>
	 * <code>getModifiedLeadStatusList</code>This method returns list of Lead
	 * Status for changing the Lead Status.
	 * </p>
	 * 
	 * @return list of User Role in HashTable object
	 */
	public static HashMap<Integer, String> getModifiedLeadStatusList() {
		HashMap<Integer, String> hashMap = new HashMap<Integer, String>();

		hashMap.put(new Integer(ATTEMPTED_TO_CONTACT_ID), ATTEMPTED_TO_CONTACT);
		hashMap.put(new Integer(COLD_ID), COLD);
		hashMap.put(new Integer(CONTACTED_ID), CONTACTED);
		hashMap.put(new Integer(CONTACT_IN_FUTURE_ID), CONTACT_IN_FUTURE);
		hashMap.put(new Integer(HOT_ID), HOT);
		hashMap.put(new Integer(JUNK_LEAD_ID), JUNK_LEAD);
		hashMap.put(new Integer(LOST_LEAD_ID), LOST_LEAD);
		hashMap.put(new Integer(NOT_CONTACTED_ID), NOT_CONTACTED);
		hashMap.put(new Integer(PRE_QUALIFIED), PRE_QUALIFIED);
		hashMap.put(new Integer(WARM_ID), WARM);
		hashMap.put(new Integer(NOT_LEADSTATUS_ID), NOT_LEADSTATUS);
		hashMap.put(new Integer(NOT_LEADSTATUS_ID), NOT_LEADSTATUS);

		return hashMap;
	}
}
