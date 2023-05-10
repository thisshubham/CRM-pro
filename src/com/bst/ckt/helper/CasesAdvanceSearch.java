package com.bst.ckt.helper;

import java.io.Serializable;
import java.util.HashMap;

public class CasesAdvanceSearch implements Comparable<Object>, Serializable {

	/**
	 * Compare object with Cases Search object for equality of hashCode.
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

	public static final int CASES_ID = 1;
	public static final int CASE_TITLE_ID = 2;
	public static final int CONTACT_NAME_ID = 3;
	public static final int PRIORITY_ID = 4;
	public static final int STATUS_ID = 5;

	/**
	 * <p>
	 * List of Search Item value Constants.
	 * </p>
	 */

	public static final String CASESID = "Cases Id";
	public static final String CASE_TITLE = "Case Title";
	public static final String CONTACT_NAME = "Contact Name";
	public static final String PRIORITY = "priority";
	public static final String STATUS = "Status";

	public int id;
	public String value;

	public CasesAdvanceSearch() {
	}

	public CasesAdvanceSearch(int id) {
		this.id = id;

	}

	public CasesAdvanceSearch(String value) {
		this.value = value;

	}

	public CasesAdvanceSearch(int id, String value) {
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
	 * This method will return faq search value based on advanceSearchId.
	 * 
	 * @param advanceSearchId
	 * @return ADVANCESERACHVALUE
	 */
	public static String getFaqAdvanceSearchValue(int advanceSearchId) {
		String ADVANCESERACHVALUE = null;
		switch (advanceSearchId) {
		case CASES_ID:
			ADVANCESERACHVALUE = CASESID;
			break;
		case CASE_TITLE_ID:
			ADVANCESERACHVALUE = CASE_TITLE;
			break;
		case CONTACT_NAME_ID:
			ADVANCESERACHVALUE = CONTACT_NAME;
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
	 * <code>getCasesAdvanceSearchList</code>This method returns list of Cases
	 * advance search list
	 * </p>
	 * 
	 * @return list of Cases advance search in HashTable object
	 */
	public static HashMap<Integer, String> getCasesAdvanceSearchList() {
		HashMap<Integer, String> hashMap = new HashMap<Integer, String>();

		hashMap.put(new Integer(CASES_ID), CASESID);
		hashMap.put(new Integer(CASE_TITLE_ID), CASE_TITLE);
		hashMap.put(new Integer(CONTACT_NAME_ID), CONTACT_NAME);
		hashMap.put(new Integer(PRIORITY_ID), PRIORITY);
		hashMap.put(new Integer(STATUS_ID), STATUS);
		return hashMap;
	}

}
