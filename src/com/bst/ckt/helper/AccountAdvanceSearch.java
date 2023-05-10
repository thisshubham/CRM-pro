package com.bst.ckt.helper;

import java.util.HashMap;

public class AccountAdvanceSearch {

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

	/**
	 * serialVersionUID is unique id for class in project implementation.
	 */
	private static final long serialVersionUID = 8398882971118001921L;

	/**
	 * <p>
	 * List of search item id Constants.
	 * </p>
	 */

	public static final int ACCOUNTID_ID = 1;
	public static final int ACCOUNT_NAME_ID = 2;
	public static final int ACCOUNT_OWNER_ID = 3;
	public static final int ACCOUNT_TYPE_ID = 4;
	public static final int MOBILE_NO_ID = 5;
	public static final int STATUS_ID = 6;

	/**
	 * <p>
	 * List of Search Item value Constants.
	 * </p>
	 */

	public static final String ACCOUNT_ID = "Account Id";
	public static final String ACCOUNT_NAME = "Account Name";
	public static final String ACCOUNT_OWNER = "Account Owner";
	public static final String ACCOUNT_TYPE = "Account Type";
	public static final String MOBILE_NO = "Mobile Number";
	public static final String STATUS = "Status";

	public int id;
	public String value;

	public AccountAdvanceSearch() {
		// do nothing.

	}

	public AccountAdvanceSearch(int id) {
		this.id = id;

	}

	public AccountAdvanceSearch(String value) {
		this.value = value;

	}

	public AccountAdvanceSearch(int id, String value) {
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
	 * This method will return account search value on advanceSearchId.
	 * 
	 * @param advanceSearchId
	 * @return ADVANCESERACHVALUE
	 */
	public static String getAdvanceSearchValue(int advanceSearchId) {
		String ADVANCESERACHVALUE = null;

		switch (advanceSearchId) {
		case ACCOUNTID_ID:
			ADVANCESERACHVALUE = ACCOUNT_ID;
			break;
		case ACCOUNT_NAME_ID:
			ADVANCESERACHVALUE = ACCOUNT_NAME;
			break;
		case ACCOUNT_OWNER_ID:
			ADVANCESERACHVALUE = ACCOUNT_OWNER;
			break;
		case ACCOUNT_TYPE_ID:
			ADVANCESERACHVALUE = ACCOUNT_TYPE;
			break;
		case MOBILE_NO_ID:
			ADVANCESERACHVALUE = MOBILE_NO;
			break;
		case STATUS_ID:
			ADVANCESERACHVALUE = STATUS;
			break;

		}

		return ADVANCESERACHVALUE;
	}

	/**
	 * <p>
	 * <code>getLeadAdvanceSearchList</code>This method returns list of Lead
	 * advance search list
	 * </p>
	 * 
	 * @return list of Lead advance search in HashTable object
	 */
	public static HashMap<Integer, String> getAdvanceSearchList() {
		HashMap<Integer, String> hashMap = new HashMap<Integer, String>();

		hashMap.put(new Integer(ACCOUNTID_ID), ACCOUNT_ID);
		hashMap.put(new Integer(ACCOUNT_NAME_ID), ACCOUNT_NAME);
		hashMap.put(new Integer(ACCOUNT_OWNER_ID), ACCOUNT_OWNER);
		hashMap.put(new Integer(ACCOUNT_TYPE_ID), ACCOUNT_TYPE);
		hashMap.put(new Integer(MOBILE_NO_ID), MOBILE_NO);
		hashMap.put(new Integer(STATUS_ID), STATUS);
		return hashMap;
	}

}
