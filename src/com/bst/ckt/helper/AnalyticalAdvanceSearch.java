package com.bst.ckt.helper;

import java.util.HashMap;

public class AnalyticalAdvanceSearch {

	/**
	 * <p>
	 * List of search item id Constants.
	 * </p>
	 */

	public static final int CONTACT_ID = 1;
	public static final int ACCOUNT_ID = 2;
	public static final int DOCUMENTS_ID = 3;
	public static final int CAMPAIGN_ID = 4;
	public static final int LEAD_ID = 5;
	public static final int ASSIGNMENT_ID = 6;
	public static final int PRODUCT_ID = 7;
	public static final int VENDOR_ID = 8;
	public static final int EXPENSES_ID = 9;
	public static final int CASES_ID = 10;
	public static final int TICKETS_ID = 11;

	/**
	 * <p>
	 * List of Search Item value Constants.
	 * </p>
	 */

	public static final String CONTACT = "Contact";
	public static final String ACCOUNT = "Account";
	public static final String DOCUMENTS = "Document";
	public static final String CAMPAIGN = "Campaign";
	public static final String LEAD = "Lead";
	public static final String ASSIGNMENT = "Assignment";
	public static final String PRODUCT = "Product";
	public static final String VENDOR = "Vendor";
	public static final String EXPENSES = "Expenses";
	public static final String CASES = "Cases";
	public static final String TICKETS = "Tickets";

	/**
	 * This method will return lead search value based on advanceSearchId.
	 * 
	 * @param advanceSearchId
	 * @return ADVANCESERACHVALUE
	 */
	public static String getLeadAdvanceSearchValue(int advanceSearchId) {
		String ADVANCESERACHVALUE = null;

		switch (advanceSearchId) {
		case CONTACT_ID:
			ADVANCESERACHVALUE = CONTACT;
			break;
		case ACCOUNT_ID:
			ADVANCESERACHVALUE = ACCOUNT;
			break;
		case DOCUMENTS_ID:
			ADVANCESERACHVALUE = DOCUMENTS;
			break;
		case CAMPAIGN_ID:
			ADVANCESERACHVALUE = CAMPAIGN;
			break;
		case LEAD_ID:
			ADVANCESERACHVALUE = LEAD;
			break;
		case ASSIGNMENT_ID:
			ADVANCESERACHVALUE = ASSIGNMENT;
			break;
		case PRODUCT_ID:
			ADVANCESERACHVALUE = PRODUCT;
			break;
		case VENDOR_ID:
			ADVANCESERACHVALUE = VENDOR;
			break;
		case EXPENSES_ID:
			ADVANCESERACHVALUE = EXPENSES;
			break;
		case CASES_ID:
			ADVANCESERACHVALUE = CASES;
			break;
		case TICKETS_ID:
			ADVANCESERACHVALUE = TICKETS;
			break;

		}

		return ADVANCESERACHVALUE;
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
		hashMap.put(new Integer(CONTACT_ID), CONTACT);
		hashMap.put(new Integer(ACCOUNT_ID), ACCOUNT);
		hashMap.put(new Integer(DOCUMENTS_ID), DOCUMENTS);
		hashMap.put(new Integer(CAMPAIGN_ID), CAMPAIGN);
		hashMap.put(new Integer(LEAD_ID), LEAD);
		hashMap.put(new Integer(ASSIGNMENT_ID), ASSIGNMENT);
		hashMap.put(new Integer(PRODUCT_ID), PRODUCT);
		hashMap.put(new Integer(VENDOR_ID), VENDOR);
		hashMap.put(new Integer(EXPENSES_ID), EXPENSES);
		hashMap.put(new Integer(CASES_ID), CASES);
		hashMap.put(new Integer(TICKETS_ID), TICKETS);
		return hashMap;
	}

}
