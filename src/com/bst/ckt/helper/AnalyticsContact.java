package com.bst.ckt.helper;

import java.util.HashMap;

public class AnalyticsContact {
	/**
	 * <p>
	 * List of search item id Constants.
	 * </p>
	 */

	public static final int CONTACT_BY_STATUS_ID = 1;
	public static final int CONTACT_BY_OWNER_ID = 3;

	/**
	 * <p>
	 * List of Search Item value Constants.
	 * </p>
	 */

	public static final String CONTACT_BY_STATUS = "Contact By Status";
	public static final String CONTACT_BY_OWNER = "Contact BY Owner";

	/**
	 * This method will return Contact search value based on ContactSearchId.
	 * 
	 * @param advanceSearchId
	 * @return ADVANCESERACHVALUE
	 */
	public static String getAnalyticsContactModule(int analyticsContact) {
		String ANALYTICSCONTACT = null;

		switch (analyticsContact) {
		case CONTACT_BY_STATUS_ID:
			ANALYTICSCONTACT = CONTACT_BY_STATUS;
			break;

		case CONTACT_BY_OWNER_ID:
			ANALYTICSCONTACT = CONTACT_BY_OWNER;
			break;

		}

		return ANALYTICSCONTACT;
	}

	/**
	 * <p>
	 * <code>getAnalyticalAdvanceSearch()</code>This method is return a Contact
	 * Search Values
	 * </p>
	 * 
	 * @return list of analytics Contact in HashTable object
	 */

	public static HashMap<Integer, String> getAnalyticalContact() {
		// TODO Auto-generated method stub
		HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
		hashMap.put(new Integer(CONTACT_BY_STATUS_ID), CONTACT_BY_STATUS);
		hashMap.put(new Integer(CONTACT_BY_OWNER_ID), CONTACT_BY_OWNER);
		return hashMap;
	}

}
