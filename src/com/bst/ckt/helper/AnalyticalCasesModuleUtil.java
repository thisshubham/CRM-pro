package com.bst.ckt.helper;

import java.util.HashMap;

public class AnalyticalCasesModuleUtil {

	/**
	 * <p>
	 * List of search item id Constants.
	 * </p>
	 */

	public static final int CASES_BY_STATUS_ID = 1;
	public static final int CASES_BY_IMPACT_AREA_ID = 2;
	public static final int CASES_BY_IMPACT_TYPE_ID = 3;
	public static final int CREATED_BY_ID = 4;
	public static final int ASSIGNED_TO_ID = 5;

	/**
	 * <p>
	 * List of Search Item value Constants.
	 * </p>
	 */

	public static final String CASES_BY_STATUS = "Cases By Status";
	public static final String CASES_BY_IMPACT_AREA = "Cases By Impact Area";
	public static final String CASES_BY_IMPACT_TYPE = "Cases By Impact Type";
	public static final String CREATED_BY = "Created By";
	public static final String ASSINED_TO = "Assined To";

	/**
	 * This method will return EXPENSES search value based on
	 * ANALYTICSEXPENSESID.
	 * 
	 * @param analyticsExpensesId
	 * @return ANALYTICSEXPENSES
	 */
	public static String getAnalyticsCasesModule(int analyticsCasesId) {
		String ANALYTICSCASES = null;

		switch (analyticsCasesId) {
		case CASES_BY_STATUS_ID:
			ANALYTICSCASES = CASES_BY_STATUS;
			break;
		case CASES_BY_IMPACT_AREA_ID:
			ANALYTICSCASES = CASES_BY_IMPACT_AREA;
			break;
		case CASES_BY_IMPACT_TYPE_ID:
			ANALYTICSCASES = CASES_BY_IMPACT_TYPE;
			break;
		case CREATED_BY_ID:
			ANALYTICSCASES = CREATED_BY;
			break;
		case ASSIGNED_TO_ID:
			ANALYTICSCASES = ASSINED_TO;
			break;

		}

		return ANALYTICSCASES;
	}

	/**
	 * <p>
	 * <code>getAnalyticalCases()</code>This method returns list of
	 * analytical Cases list
	 * </p>
	 * 
	 * @return list of analytical Cases search in HashTable object
	 */

	public static HashMap<Integer, String> getAnalyticalCases() {
		// TODO Auto-generated method stub
		HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
		hashMap.put(new Integer(CASES_BY_STATUS_ID), CASES_BY_STATUS);
	    hashMap.put(new Integer(CASES_BY_IMPACT_AREA_ID), CASES_BY_IMPACT_AREA);
	    hashMap.put(new Integer(CASES_BY_IMPACT_TYPE_ID), CASES_BY_IMPACT_TYPE);
	    hashMap.put(new Integer(CREATED_BY_ID), CREATED_BY);
	    hashMap.put(new Integer(ASSIGNED_TO_ID), ASSINED_TO);
		
		return hashMap;
	}

}
