package com.bst.ckt.helper;

import java.util.HashMap;

public class AnalyticsLeadModuleUtil {
	
	

	/**
	 * <p>
	 * List of search item id Constants.
	 * </p>
	 */

	public static final int LEAD_BY_SOURCE_ID = 1;
	public static final int LEAD_BY_STATUS_ID = 2;
	public static final int CREATED_BY_ID = 3;
	public static final int LEAD_BY_INDUSTRY_ID = 4;
	public static final int LEAD_BY_OWNERSHIP_ID = 5;
	

	/**
	 * <p>
	 * List of Search Item value Constants.
	 * </p>
	 */

	public static final String LEAD_BY_SOURCE = "Lead by Source";
	public static final String LEAD_BY_STATUS = "Lead by Status";
	public static final String CREATED_BY = "Created by";
	public static final String LEAD_BY_INDUSTRY = "Lead by Industry";
	public static final String LEAD_BY_OWNERSHIP = "Lead by ownership";
	

	/**
	 * This method will return lead search value based on advanceSearchId.
	 * 
	 * @param advanceSearchId
	 * @return ADVANCESERACHVALUE
	 */
	public static String getAnalyticsLeadModule(int analyticsLead) {
		String ANALYTICSLEAD = null;

		switch (analyticsLead) {
		case LEAD_BY_SOURCE_ID:
			ANALYTICSLEAD = LEAD_BY_SOURCE;
			break;
		case LEAD_BY_STATUS_ID:
			ANALYTICSLEAD = LEAD_BY_STATUS;
			break;
		case CREATED_BY_ID:
			ANALYTICSLEAD = CREATED_BY;
			break;
		case LEAD_BY_INDUSTRY_ID:
			ANALYTICSLEAD = LEAD_BY_INDUSTRY;
			break;
		case LEAD_BY_OWNERSHIP_ID:
			ANALYTICSLEAD = LEAD_BY_OWNERSHIP;
			break;

		}

		return ANALYTICSLEAD;
	}

	/**
	 * <p>
	 * <code>getAnalyticalAdvanceSearch()</code>This method returns list of analytical
	 * advance search list
	 * </p>
	 * 
	 * @return list of analytical advance search in HashTable object
	 */

	public static HashMap<Integer, String> getAnalyticalAdvanceSearch() {
		// TODO Auto-generated method stub
		HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
		hashMap.put(new Integer(LEAD_BY_SOURCE_ID), LEAD_BY_SOURCE);
		hashMap.put(new Integer(LEAD_BY_STATUS_ID), LEAD_BY_STATUS);
		hashMap.put(new Integer(CREATED_BY_ID), CREATED_BY);
		hashMap.put(new Integer(LEAD_BY_INDUSTRY_ID), LEAD_BY_INDUSTRY);
		hashMap.put(new Integer(LEAD_BY_OWNERSHIP_ID), LEAD_BY_OWNERSHIP);
		
		return hashMap;
	}



}
