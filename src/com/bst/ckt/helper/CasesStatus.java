package com.bst.ckt.helper;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Hashtable;

public class CasesStatus implements Comparable<Object>, Serializable {

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
	public static final int ASSIGNED_ID = 2;
	public static final int INPROGRESS_ID = 3;
	public static final int NOTVERIFIED_ID = 4;
	public static final int JUNKCASES_ID = 5;
	public static final int FUTURECASES_ID = 6;
	public static final int DUPLICATE_ID = 7;
	public static final int PREVERIFIED_ID = 8;
	public static final int VERIFIED_ID = 9;
	public static final int EXPIRED_ID = 10;
	public static final int CLOSED_ID = 11;
	public static final int DELETED_ID = 12;
	public static final int NOT_CASESSTATUS_ID = 13;

	/**
	 * <p>
	 * List of UserStatus Constants.
	 * </p>
	 */

	public static final String NEW = "New";
	public static final String ASSIGNED = "Assigned";
	public static final String INPROGRESS = "In-Progress";
	public static final String NOTVERIFIED = "Not Verified";
	public static final String JUNKCASES = "Junk CASES";
	public static final String FUTURECASES = "Future CASES";
	public static final String DUPLICATE = "Duplicate";
	public static final String PREVERIFIED = "Pre Verified";
	public static final String VERIFIED = "Verified";
	public static final String EXPIRED = "Expired";
	public static final String CLOSED = "Closed";
	public static final String DELETED = "Deleted";
	public static final String NOT_CASESSTATUS = "Not CASES Status";

	public CasesStatus() {
		// nothing will do
	}

	public CasesStatus(int id) {
		this.id = id;
	}

	public CasesStatus(int id, String name) {
		this.id = id;
		this.statusName = name;
	}

	/**
	 * Compare object with CASESStatus object for equality of hashCode.
	 * 
	 * @return 0 if not equals and return 1 if both are equals.
	 */
	public int compareTo(Object obj) {

		if (this.hashCode() == obj.hashCode()) {
			return 1;
		}

		return 0;
	}

	public void setCASESStatus(int id) {
		this.id = id;
	}

	public int getCASESStatusId() {
		return this.id;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	/**
	 * This method will return CASESStatus Name based on CASESStatusId.
	 * 
	 * @param statusId
	 * @return
	 */
	public static String getCASESStatus(int statusId) {
		String CASES_STATUS = null;

		switch (statusId) {
		case NEW_ID: {
			CASES_STATUS = NEW;
			break;
		}
		case ASSIGNED_ID: {
			CASES_STATUS = ASSIGNED;
			break;
		}
		case INPROGRESS_ID: {
			CASES_STATUS = INPROGRESS;
			break;
		}
		case NOTVERIFIED_ID: {
			CASES_STATUS = NOTVERIFIED;
			break;
		}
		case JUNKCASES_ID: {
			CASES_STATUS = JUNKCASES;
			break;
		}
		case FUTURECASES_ID: {
			CASES_STATUS = FUTURECASES;
			break;
		}
		case DUPLICATE_ID: {
			CASES_STATUS = DUPLICATE;
			break;
		}
		case PREVERIFIED_ID: {
			CASES_STATUS = PREVERIFIED;
			break;
		}
		case VERIFIED_ID: {
			CASES_STATUS = VERIFIED;
			break;
		}
		case EXPIRED_ID: {
			CASES_STATUS = EXPIRED;
			break;
		}
		case CLOSED_ID: {
			CASES_STATUS = CLOSED;
			break;
		}
		case DELETED_ID: {
			CASES_STATUS = DELETED;
			break;
		}

		default: {
			CASES_STATUS = NOT_CASESSTATUS;
			break;
		}
		}

		return CASES_STATUS;
	}

	/**
	 * <p>
	 * <code>getCASESStatusList</code>This method returns list of CASES Status
	 * </p>
	 * 
	 * @return list of CASES Status in HashTable object
	 */

	public static Hashtable<Integer, String> getCasestatusList() {
		Hashtable<Integer, String> hashtable = new Hashtable<Integer, String>();
		hashtable.put(new Integer(NEW_ID), NEW);
		hashtable.put(new Integer(ASSIGNED_ID), ASSIGNED);
		hashtable.put(new Integer(INPROGRESS_ID), INPROGRESS);
		hashtable.put(new Integer(NOTVERIFIED_ID), NOTVERIFIED);
		hashtable.put(new Integer(JUNKCASES_ID), JUNKCASES);
		hashtable.put(new Integer(FUTURECASES_ID), FUTURECASES);
		hashtable.put(new Integer(DUPLICATE_ID), DUPLICATE);
		hashtable.put(new Integer(PREVERIFIED_ID), PREVERIFIED);
		hashtable.put(new Integer(VERIFIED_ID), VERIFIED);
		hashtable.put(new Integer(EXPIRED_ID), EXPIRED);
		hashtable.put(new Integer(CLOSED_ID), CLOSED);
		hashtable.put(new Integer(DELETED_ID), DELETED);
		hashtable.put(new Integer(NOT_CASESSTATUS_ID), NOT_CASESSTATUS);

		return hashtable;
	}

	/**
	 * <p>
	 * <code>getModifiedCASESStatusList</code>This method returns list of CASES
	 * Status for changing the CASES Status.
	 * </p>
	 * 
	 * @return list of User Role in HashTable object
	 */
	public static HashMap<Integer, String> getModifiedCASESStatusList() {
		HashMap<Integer, String> hashtable = new HashMap<Integer, String>();
		hashtable.put(new Integer(ASSIGNED_ID), ASSIGNED);
		hashtable.put(new Integer(INPROGRESS_ID), INPROGRESS);
		hashtable.put(new Integer(NOTVERIFIED_ID), NOTVERIFIED);
		hashtable.put(new Integer(JUNKCASES_ID), JUNKCASES);
		hashtable.put(new Integer(FUTURECASES_ID), FUTURECASES);
		hashtable.put(new Integer(DUPLICATE_ID), DUPLICATE);
		hashtable.put(new Integer(PREVERIFIED_ID), PREVERIFIED);
		hashtable.put(new Integer(VERIFIED_ID), VERIFIED);
		hashtable.put(new Integer(EXPIRED_ID), EXPIRED);
		hashtable.put(new Integer(CLOSED_ID), CLOSED);
		hashtable.put(new Integer(DELETED_ID), DELETED);
		hashtable.put(new Integer(NOT_CASESSTATUS_ID), NOT_CASESSTATUS);

		return hashtable;
	}

}
