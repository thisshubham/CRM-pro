package com.bst.ckt.helper;

import java.io.Serializable;
import java.util.HashMap;

public class TicketAdvanceSearch implements Comparable<Object>, Serializable {

	/**
	 * Compare object with Ticket Search object for equality of hashCode.
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

	public static final int TICKETID_ID = 1;
	public static final int CATEGORY_ID = 2;
	public static final int TICKET_OWNER_ID = 3;
	public static final int PRIORITY_ID = 4;
	public static final int CHANNEL_ID = 5;
	public static final int DUE_DATE_ID = 6;
	public static final int CONTACT_NAME_ID = 7;
	public static final int PRODUCT_NAME_ID = 8;
	public static final int STATUS_ID = 9;

	/**
	 * <p>
	 * List of Search Item value Constants.
	 * </p>
	 */

	public static final String TICKETID = "Ticket Id";
	public static final String CATEGORY = "Category";
	public static final String TICKET_OWNER = "Ticket ";
	public static final String PRIORITY = "Priority";
	public static final String CHANNEL = "Channel";
	public static final String DUE_DATE = "Due Date";
	public static final String CONTACT_NAME = " Contact Name";
	public static final String PRODUCT_NAME = "Product Name";
	public static final String STATUS = "Status";
	public int id;
	public String value;

	public TicketAdvanceSearch() {
		// do nothing.

	}

	public TicketAdvanceSearch(int id) {
		this.id = id;

	}

	public TicketAdvanceSearch(String value) {
		this.value = value;

	}

	public TicketAdvanceSearch(int id, String value) {
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
	 * This method will return lead search value based on advanceSearchId.
	 * 
	 * @param advanceSearchId
	 * @return ADVANCESERACHVALUE
	 */
	public static String getTicketAdvanceSearchValue(int advanceSearchId) {
		String ADVANCESERACHVALUE = null;
		switch (advanceSearchId) {
		case TICKETID_ID:
			ADVANCESERACHVALUE = TICKETID;
			break;
		case CATEGORY_ID:
			ADVANCESERACHVALUE = CATEGORY;
			break;
		case TICKET_OWNER_ID:
			ADVANCESERACHVALUE = TICKET_OWNER;
			break;
		case PRIORITY_ID:
			ADVANCESERACHVALUE = PRIORITY;
			break;
		case CHANNEL_ID:
			ADVANCESERACHVALUE = CHANNEL;
			break;
		case DUE_DATE_ID:
			ADVANCESERACHVALUE = DUE_DATE;
			break;
		case CONTACT_NAME_ID:
			ADVANCESERACHVALUE = CONTACT_NAME;
			break;
		case PRODUCT_NAME_ID:
			ADVANCESERACHVALUE = PRODUCT_NAME;
			break;
		case STATUS_ID:
			ADVANCESERACHVALUE = STATUS;
			break;

		}

		return ADVANCESERACHVALUE;
	}

	/**
	 * <p>
	 * <code>getTicketAdvanceSearchList</code>This method returns list of Lead
	 * advance search list
	 * </p>
	 * 
	 * @return list of Lead advance search in HashTable object
	 */
	public static HashMap<Integer, String> getTicketAdvanceSearchList() {
		HashMap<Integer, String> hashMap = new HashMap<Integer, String>();

		hashMap.put(new Integer(TICKETID_ID), TICKETID);
		hashMap.put(new Integer(CATEGORY_ID), CATEGORY);
		hashMap.put(new Integer(TICKET_OWNER_ID), TICKET_OWNER);
		hashMap.put(new Integer(PRIORITY_ID), PRIORITY);
		hashMap.put(new Integer(CHANNEL_ID), CHANNEL);
		hashMap.put(new Integer(DUE_DATE_ID), DUE_DATE);
		hashMap.put(new Integer(CONTACT_NAME_ID),CONTACT_NAME);
		hashMap.put(new Integer(PRODUCT_NAME_ID), PRODUCT_NAME);
		hashMap.put(new Integer(STATUS_ID), STATUS);
		return hashMap;
	}

}
