package com.bst.ckt.helper;

import java.util.HashMap;

public class AnalyticsAssignmentModuleUtil {

	/**
	 * <p>
	 * List of search item id Constants. 
	 * 
	 * </p>
	 */

	public static final int ASSIGNMENT_NAME_ID = 1;
	public static final int ASSIGNMENT_BY_STATUS_ID = 2;
	public static final int ASSIGNED_TO_ID = 3;
	

	/**
	 * <p>
	 * List of Search Item value Constants.
	 * </p>
	 */

	public static final String ASSIGNMENT_NAME = "Assignment Name";
	public static final String ASSIGNMENT_BY_STATUS = "Assignment By Status";
	public static final String ASSIGNED_TO = "Assigned To";

	/**
	 * This method will return assignment search value based on advanceSearchId.
	 * 
	 * @param advanceSearchId
	 * @return ANALYTICSASSINMENT
	 */
	public static String getAnalyticsAssignmentModule(int analyticsAssignment) {
		String ANALYTICSASSIGNMENT = null;

		switch (analyticsAssignment) {
		case ASSIGNMENT_NAME_ID:
			ANALYTICSASSIGNMENT = ASSIGNMENT_NAME;
			break;
		case ASSIGNMENT_BY_STATUS_ID:
			ANALYTICSASSIGNMENT = ASSIGNMENT_BY_STATUS;
			break;
		case ASSIGNED_TO_ID:
			ANALYTICSASSIGNMENT = ASSIGNED_TO;
			break;

		}

		return ANALYTICSASSIGNMENT;
	}

	/**
	 * <p>
	 * <code>getAnalyticalAssignment()</code>This method returns list of
	 * analytical Assignment list
	 * </p>
	 * 
	 * @return list of analytical ASSIGNMENT search in HashTable object
	 */

	public static HashMap<Integer, String> getAnalyticalAssignment() {
		// TODO Auto-generated method stub
		HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
		hashMap.put(new Integer(ASSIGNMENT_NAME_ID), ASSIGNMENT_NAME);
		hashMap.put(new Integer(ASSIGNMENT_BY_STATUS_ID), ASSIGNMENT_BY_STATUS);
		hashMap.put(new Integer(ASSIGNED_TO_ID), ASSIGNED_TO);

		return hashMap;
	}

}
