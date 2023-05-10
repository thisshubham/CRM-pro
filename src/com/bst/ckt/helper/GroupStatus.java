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
 * Class Name     GroupStatus.java     
 *                                                            
 * Creation Date  Sep 19, 2015 
 * 
 * Abstract       This class is utility class for Group Status in project.
 * 
 * Amendment History (in chronological sequence): Sep 19, 2015
 * 
 **********************************************************************
 */

package com.bst.ckt.helper;

import java.io.Serializable;
import java.util.Hashtable;

public class GroupStatus implements Comparable<Object>, Serializable {

	/**
	 * serialVersionUID is unique id for class in project implementation.
	 */
	private static final long serialVersionUID = 8398882971118001921L;
	private int id;
	private String statusName;

	/**
	 * <p>
	 * List of GroupStatus id Constants.
	 * </p>
	 */
	public static final int NEW_ID = 1;
	public static final int NOT_VERIFIED_ID = 2;
	public static final int DUPLICATE_ID = 3;
	public static final int PRE_VERIFIED_ID = 4;
	public static final int VERIFIED_ID = 5;
	public static final int DELETED_ID = 6;
	public static final int NOT_GROUP_STATUS_ID = 7;

	/**
	 * <p>
	 * List of GroupStatus Constants.
	 * </p>
	 */

	public static final String NEW = "New";
	public static final String NOT_VERIFIED = "Not Verified";
	public static final String DUPLICATE = "Duplicate";
	public static final String PRE_VERIFIED = "Pre Verified";
	public static final String VERIFIED = "Verified";
	public static final String DELETED = "Deleted";
	public static final String NOT_GROUP_STATUS = "Not Group Status";

	public GroupStatus() {
		// will do nothing.
	}

	public GroupStatus(int id) {
		this.id = id;
	}

	public GroupStatus(int id, String name) {
		this.id = id;
		this.statusName = name;
	}

	/**
	 * Compare object with GroupStatus object for equality of hashCode.
	 * 
	 * @return 0 if not equals and return 1 if both are equals.
	 */
	public int compareTo(Object obj) {

		if (this.hashCode() == obj.hashCode()) {
			return 1;
		}

		return 0;
	}

	public void setGroupStatusId(int id) {
		this.id = id;
	}

	public int getGroupStatusId() {
		return this.id;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	/**
	 * This method will return GroupStatus Name based on groupStatusId.
	 * 
	 * @param statusId
	 * @return
	 */
	public static String getGroupStatus(int statusId) {
		String GROUP_STATUS = null;

		switch (statusId) {
		case NEW_ID: {
			GROUP_STATUS = NEW;
			break;
		}
		case NOT_VERIFIED_ID:{
			GROUP_STATUS=NOT_VERIFIED;
			break;
		}
		case DUPLICATE_ID:{
			GROUP_STATUS=DUPLICATE;
			break;
		}
		case PRE_VERIFIED_ID:{
			GROUP_STATUS=PRE_VERIFIED;
			break;
		}
		case VERIFIED_ID:{
			GROUP_STATUS=VERIFIED;
			break;
		}
		case DELETED_ID:{
			GROUP_STATUS=DELETED;
			break;
		}
		default: {
			GROUP_STATUS = NOT_GROUP_STATUS;
		}
		}

		return GROUP_STATUS;
	}

	/**
	 * <p>
	 * <code>getLeadStatusList</code>This method returns list of Group Status
	 * </p>
	 * 
	 * @return list of Group Status in HashTable object
	 */

	public static Hashtable<Integer, String> getGroupStatusList() {
		Hashtable<Integer, String> hashtable = new Hashtable<Integer, String>();
		hashtable.put(new Integer(NEW_ID), NEW);
		hashtable.put(new Integer(DUPLICATE_ID), DUPLICATE);
		hashtable.put(new Integer(PRE_VERIFIED_ID), PRE_VERIFIED);
		hashtable.put(new Integer(VERIFIED_ID), VERIFIED);
		hashtable.put(new Integer(DELETED_ID), DELETED);
		hashtable.put(new Integer(NOT_GROUP_STATUS_ID), NOT_GROUP_STATUS);
		return hashtable;
	}

	/**
	 * <p>
	 * <code>getModifiedLeadStatusList</code>This method returns list of Group
	 * Status for changing the Group Status.
	 * </p>
	 * 
	 * @return list of User Role in HashTable object
	 */
	public static Hashtable<Integer, String> getModifiedGroupStatusList() {
		Hashtable<Integer, String> hashtable = new Hashtable<Integer, String>();
		hashtable.put(new Integer(DUPLICATE_ID), DUPLICATE);
		hashtable.put(new Integer(PRE_VERIFIED_ID), PRE_VERIFIED);
		hashtable.put(new Integer(VERIFIED_ID), VERIFIED);
		hashtable.put(new Integer(DELETED_ID), DELETED);
		hashtable.put(new Integer(NOT_GROUP_STATUS_ID), NOT_GROUP_STATUS);
		
		return hashtable;
	}
}
