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

public class AssignmentStatus implements Comparable<Object>, Serializable {

	/**
	 * serialVersionUID is unique id for class in project implementation.
	 */
	private static final long serialVersionUID = 8398882971118001921L;
	private int id;
	private String statusName;

	/**
	 * <p>
	 * List of AssignmentStatus id Constants.
	 * </p>
	 */

	public static final int QUALIFICATION_ID = 1;
	public static final int NEED_ANALYSIS_ID = 2;
	public static final int VALUE_PROPOSITION_ID = 3;
	public static final int DECISION_MAKERS_ID = 4;
	public static final int PRAPOSAL_QUOTE_ID = 5;
	public static final int NEGOTIATION_ID = 6;
	public static final int CLOSED_WON_ID = 7;
	public static final int CLOSED_LOST_ID = 8;
	public static final int CLOSED_LOST_TOCOMPETITION__ID = 9;
	public static final int NOT_ASSIGNMENTSTATUS_ID = 10;
	
	/**
	 * <p>
	 * List of AssignmentStatus Constants.
	 * </p>
	 */

	public static final String QUALIFICATION = "Active";
	public static final String NEED_ANALYSIS = "Inactive";
	public static final String VALUE_PROPOSITION ="Value Proposal";
	public static final String DECISION_MAKERS = "Id. Decision Makers";
	public static final String PRAPOSAL_QUOTE = "Praposal/Price Quote";
	public static final String NEGOTIATION = "Negotiation/ Review";
	public static final String CLOSED_WON = "Closed Won";
	public static final String CLOSED_LOST = "Closed Lost";
	public static final String CLOSED_LOST_TOCOMPETITION = "Closed Lost to competition";
	public static final String NOT_ASSIGNMENTSTATUS = "Not Assignment Status";

	public AssignmentStatus() {
		// nothing will do
	}

	public AssignmentStatus(int id) {
		this.id = id;
	}

	public AssignmentStatus(int id, String name) {
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

	public void setAssignementStatus(int id) {
		this.id = id;
	}

	public int getAssignementStatusId() {
		return this.id;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	/**
	 * This method will return AssignmentStatus Name based on leadStatusId.
	 * 
	 * @param statusId
	 * @return
	 */
	public static String getAssignmentStatus(int statusId) {
		String ASSIGNMENT_STATUS = null;

		switch (statusId) {
		case QUALIFICATION_ID: {
			ASSIGNMENT_STATUS = QUALIFICATION;
			break;
		}
		case NEED_ANALYSIS_ID: {
			ASSIGNMENT_STATUS = NEED_ANALYSIS;
			break;
		}
		case VALUE_PROPOSITION_ID: {
			ASSIGNMENT_STATUS = VALUE_PROPOSITION;
			break;
		}
		case DECISION_MAKERS_ID: {
			ASSIGNMENT_STATUS = DECISION_MAKERS;
			break;
		}
		case PRAPOSAL_QUOTE_ID: {
			ASSIGNMENT_STATUS = PRAPOSAL_QUOTE;
			break;
		}
		case NEGOTIATION_ID: {
			ASSIGNMENT_STATUS = NEGOTIATION;
			break;
		}
		case CLOSED_WON_ID: {
			ASSIGNMENT_STATUS = CLOSED_WON;
			break;
		}
		case CLOSED_LOST_ID: {
			ASSIGNMENT_STATUS = CLOSED_LOST;
			break;
		}
		case CLOSED_LOST_TOCOMPETITION__ID: {
			ASSIGNMENT_STATUS = CLOSED_LOST_TOCOMPETITION;
			break;
		}
				
		default: {
		ASSIGNMENT_STATUS = NOT_ASSIGNMENTSTATUS;
		}
		}

		return ASSIGNMENT_STATUS;
	}

	/**
	 * <p>
	 * <code>getAssignmentStatusList</code>This method returns list of Assignment Status
	 * </p>
	 * 
	 * @return list of Assignment Status in HashTable object
	 */

	public static HashMap<Integer, String> getAssignmentStatusList() {

		HashMap<Integer, String> hashMap = new HashMap<Integer, String>();

		hashMap.put(new Integer(QUALIFICATION_ID), QUALIFICATION);
		hashMap.put(new Integer(NEED_ANALYSIS_ID), NEED_ANALYSIS);
		hashMap.put(new Integer(VALUE_PROPOSITION_ID), VALUE_PROPOSITION);
		hashMap.put(new Integer(DECISION_MAKERS_ID), DECISION_MAKERS);
		hashMap.put(new Integer(PRAPOSAL_QUOTE_ID), PRAPOSAL_QUOTE);
		hashMap.put(new Integer(NEGOTIATION_ID), NEGOTIATION);
		hashMap.put(new Integer(CLOSED_WON_ID), CLOSED_WON);
		hashMap.put(new Integer(CLOSED_LOST_ID), CLOSED_LOST);
		hashMap.put(new Integer(CLOSED_LOST_TOCOMPETITION__ID), CLOSED_LOST_TOCOMPETITION);
		hashMap.put(new Integer(NOT_ASSIGNMENTSTATUS_ID), NOT_ASSIGNMENTSTATUS);
		
		return hashMap;
	}

	/**
	 * <p>
	 * <code>getModifiedAssignemtnStatusList</code>This method returns list of Assignment
	 * Status for changing the Assignment Status.
	 * </p>
	 * 
	 * @return list of User Role in HashMap object
	 */
	public static HashMap<Integer, String> getModifiedAssignemtnStatusList() {
		HashMap<Integer, String> hashMap = new HashMap<Integer, String>();

		hashMap.put(new Integer(QUALIFICATION_ID), QUALIFICATION);
		hashMap.put(new Integer(NEED_ANALYSIS_ID), NEED_ANALYSIS);
		hashMap.put(new Integer(VALUE_PROPOSITION_ID), VALUE_PROPOSITION);
		hashMap.put(new Integer(DECISION_MAKERS_ID), DECISION_MAKERS);
		hashMap.put(new Integer(PRAPOSAL_QUOTE_ID), PRAPOSAL_QUOTE);
		hashMap.put(new Integer(NEGOTIATION_ID), NEGOTIATION);
		hashMap.put(new Integer(CLOSED_WON_ID), CLOSED_WON);
		hashMap.put(new Integer(CLOSED_LOST_ID), CLOSED_LOST);
		hashMap.put(new Integer(CLOSED_LOST_TOCOMPETITION__ID), CLOSED_LOST_TOCOMPETITION);
		hashMap.put(new Integer(NOT_ASSIGNMENTSTATUS_ID), NOT_ASSIGNMENTSTATUS);
		

		return hashMap;
	}
}
