package com.bst.ckt.helper;

import java.util.HashMap;

public class AnalyticalExpensesModuleUtil {
	/**
	 * <p>
	 * List of search item id Constants.Expenses by Status (Graph)
Created by (Grid)

	 * 
	 * </p>
	 */

	public static final int EXPENSES_BY_STATUS_ID = 1;
	public static final int CREATED_BY_ID = 2;

	/**
	 * <p>
	 * List of Search Item value Constants.
	 * </p>
	 */

	public static final String EXPENSES_BY_STATUS = "Expenses By Status";
	public static final String CREATED_BY = "Created By";

	/**
	 * This method will return EXPENSES search value based on ANALYTICSEXPENSESID.
	 * 
	 * @param analyticsExpensesId
	 * @return ANALYTICSEXPENSES
	 */
	public static String getAnalyticsExpensesModule(int analyticsExpensesId) {
		String ANALYTICSEXPENSES = null;

		switch (analyticsExpensesId) {
		case EXPENSES_BY_STATUS_ID:
			ANALYTICSEXPENSES = EXPENSES_BY_STATUS;
			break;
		case CREATED_BY_ID:
			ANALYTICSEXPENSES = CREATED_BY;
			break;

		}

		return ANALYTICSEXPENSES;
	}

	/**
	 * <p>
	 * <code>getAnalyticalExpenses()</code>This method returns list of analytical
	 * Expenses list
	 * </p>
	 * 
	 * @return list of analytical Expenses search in HashTable object
	 */

	public static HashMap<Integer, String> getAnalyticalExpenses() {
		// TODO Auto-generated method stub
		HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
		hashMap.put(new Integer(EXPENSES_BY_STATUS_ID), EXPENSES_BY_STATUS);
		hashMap.put(new Integer(CREATED_BY_ID), CREATED_BY);
		return hashMap;
	}

}
