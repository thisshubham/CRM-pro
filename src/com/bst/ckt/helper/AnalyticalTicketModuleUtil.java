package com.bst.ckt.helper;

import java.util.HashMap;

public class AnalyticalTicketModuleUtil {


	/**
	 * <p>
	 * List of search item id Constants.
	 * </p>
	 */

	public static final int TICKET_BY_STATUS_ID = 1;
	public static final int TICKET_BY_CATEGORY_ID = 2;
	public static final int CREATED_BY_ID = 3;
	public static final int ASSIGNED_TO_ID = 4;

	/**
	 * <p>
	 * List of Search Item value Constants.
	 * </p>
	 */

	public static final String TICKET_BY_STATUS = "Ticket By Status";
	public static final String TICKET_BY_CATEGORY = "Ticket By Category";
	public static final String CREATED_BY = "Created By";
	public static final String ASSINED_TO = "Assined To";

	/**
	 * This method will return EXPENSES search value based on
	 * ANALYTICSEXPENSESID.
	 * 
	 * @param analyticsExpensesId
	 * @return ANALYTICSEXPENSES
	 */
	public static String getAnalyticsticketModule(int analyticsTicketId) {
		String ANALYTICSTTICKET = null;

		switch (analyticsTicketId) {
		case TICKET_BY_STATUS_ID:
			ANALYTICSTTICKET = TICKET_BY_STATUS;
			break;
		case TICKET_BY_CATEGORY_ID:
			ANALYTICSTTICKET = TICKET_BY_CATEGORY;
			break;
		case CREATED_BY_ID:
			ANALYTICSTTICKET = CREATED_BY;
			break;
		case ASSIGNED_TO_ID:
			ANALYTICSTTICKET = ASSINED_TO;
			break;

		}

		return ANALYTICSTTICKET;
	}

	/**
	 * <p>
	 * <code>getAnalyticalTicket()</code>This method returns list of
	 * analytical Ticket list
	 * </p>
	 * 
	 * @return list of analytical Cases search in HashTable object
	 */

	public static HashMap<Integer, String> getAnalyticalTicket() {
		// TODO Auto-generated method stub
		HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
		hashMap.put(new Integer(TICKET_BY_STATUS_ID), TICKET_BY_STATUS);
	    hashMap.put(new Integer(TICKET_BY_CATEGORY_ID), TICKET_BY_CATEGORY);
	    hashMap.put(new Integer(CREATED_BY_ID), CREATED_BY);
	    hashMap.put(new Integer(ASSIGNED_TO_ID), ASSINED_TO);
		
		return hashMap;
	}



}
