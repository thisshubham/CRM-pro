package com.bst.ckt.helper;

import java.util.HashMap;

public class AnalyticsAccountModuleUtil {
	/**
	 * <p>
	 * List of search item id Constants.
	 * </p>
	 */

	public static final int ACCOUNT_BY_STATUS_ID = 1;
	public static final int ACCOUNT_BY_TYPE_ID = 2;
	public static final int ACCOUNT_BY_INDUSTRY_ID = 3;

	/**
	 * <p>
	 * List of Search Item value Constants.
	 * </p>
	 */

	public static final String ACCOUNT_BY_STATUS = "Account By Status";
	public static final String ACCOUNT_BY_TYPE = "Account By Type";
	public static final String ACCOUNT_BY_INDUSTRY = "Account By Industry";
	

	/**
	 * This method will return Account search value based on ANALYTICSACCOUNT.
	 * 
	 * @param advanceSearchId
	 * @return ADVANCESERACHVALUE
	 */
	public static String getAnalyticsAccountModule(int analyticsLead) {
		String ANALYTICSACCOUNT = null;

		switch (analyticsLead) {
		case ACCOUNT_BY_STATUS_ID:
			ANALYTICSACCOUNT = ACCOUNT_BY_STATUS;
			break;
		case ACCOUNT_BY_TYPE_ID:
			ANALYTICSACCOUNT = ACCOUNT_BY_TYPE;
			break;
		case ACCOUNT_BY_INDUSTRY_ID:
			ANALYTICSACCOUNT = ACCOUNT_BY_INDUSTRY;
		

		}

		return ANALYTICSACCOUNT;
	}

	/**
	 * <p>
	 * <code>getAnalyticalAdvanceSearch()</code>This method is return a Account
	 * Search Values
	 * </p>
	 * 
	 * @return list of analytics Account in HashTable object
	 */

	public static HashMap<Integer, String> getAnalyticalAccount() {
		// TODO Auto-generated method stub
		HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
		hashMap.put(new Integer(ACCOUNT_BY_STATUS_ID), ACCOUNT_BY_STATUS);
		hashMap.put(new Integer(ACCOUNT_BY_TYPE_ID), ACCOUNT_BY_TYPE);
		hashMap.put(new Integer(ACCOUNT_BY_INDUSTRY_ID), ACCOUNT_BY_INDUSTRY);
		
		return hashMap;
	}

}
