package com.bst.ckt.helper;

import java.io.Serializable;
import java.util.HashMap;

public class ServiceContactAdvanceSearch implements Comparable<Object>,
		Serializable {

	/**
	 * Compare object with ServiceContactAdvanceSearch object for equality of
	 * hashCode.
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
	 * serialVersionUID is unique id for class in project implementation.
	 */
	private static final long serialVersionUID = 8398882971118001921L;

	/**
	 * <p>
	 * List of search item id Constants.
	 * </p>
	 */

	public static final int SERVICE_CONTACT_ID = 1;
	public static final int SUBJECT_ID = 2;
	public static final int ASSIGNED_TO_ID = 3;
	public static final int START_DATE_ID = 4;
	public static final int DUE_DATE_ID = 5;
	public static final int PRIORITY_ID = 6;
	public static final int STATUS_ID = 7;

	/**
	 * <p>
	 * List of Search Item value Constants.
	 * </p>
	 */

	public static final String SERVICE_CONTACT = "Service Id";
	public static final String SUBJECT = "Subject";
	public static final String ASSIGNED_TO = "Assigned To";
	public static final String START_DATE = "Start Date";
	public static final String DUE_DATE = "Due Date";
	public static final String PRIORITY = "Priority";
	public static final String STATUS = "Status";

	public int id;
	public String value;

	public ServiceContactAdvanceSearch() {
		// do nothing.

	}

	public ServiceContactAdvanceSearch(int id) {
		this.id = id;

	}

	public ServiceContactAdvanceSearch(String value) {
		this.value = value;

	}

	public ServiceContactAdvanceSearch(int id, String value) {
		this.value = value;
		this.id = id;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * This method will return Service Contract search value based on
	 * advanceSearchId.
	 * 
	 * @param advanceSearchId
	 * @return ADVANCESERACHVALUE
	 */
	public static String getServiceContactAdvanceSearchValue(int advanceSearchId) {
		String ADVANCESERACHVALUE = null;

		switch (advanceSearchId) {
		case SERVICE_CONTACT_ID:
			ADVANCESERACHVALUE = SERVICE_CONTACT;
			break;
		case SUBJECT_ID:
			ADVANCESERACHVALUE = SUBJECT;
			break;
		case ASSIGNED_TO_ID:
			ADVANCESERACHVALUE = ASSIGNED_TO;
			break;
		case START_DATE_ID:
			ADVANCESERACHVALUE = DUE_DATE;
			break;
		case DUE_DATE_ID:
			ADVANCESERACHVALUE = DUE_DATE;
			break;
		case PRIORITY_ID:
			ADVANCESERACHVALUE = PRIORITY;
			break;
		case STATUS_ID:
			ADVANCESERACHVALUE = STATUS;
			break;

		}

		return ADVANCESERACHVALUE;
	}

	/**
	 * <p>
	 * <code>getServiceContractAdvanceSearchList</code>This method returns list
	 * of Service Contract advance search list
	 * </p>
	 * 
	 * @return list of Service Contract advance search in HashTable object
	 */
	public static HashMap<Integer, String> getServiceContractAdvanceSearchList() {
		HashMap<Integer, String> hashMap = new HashMap<Integer, String>();

		hashMap.put(new Integer(SERVICE_CONTACT_ID), SERVICE_CONTACT);
		hashMap.put(new Integer(SUBJECT_ID), SUBJECT);
		hashMap.put(new Integer(ASSIGNED_TO_ID), ASSIGNED_TO);
		hashMap.put(new Integer(START_DATE_ID), DUE_DATE);
		hashMap.put(new Integer(DUE_DATE_ID), DUE_DATE);
		hashMap.put(new Integer(PRIORITY_ID), PRIORITY);
		hashMap.put(new Integer(STATUS_ID), STATUS);
		return hashMap;
	}

}
