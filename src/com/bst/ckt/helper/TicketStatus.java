package com.bst.ckt.helper;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Hashtable;

public class TicketStatus implements Comparable<Object>, Serializable {

	/**
	 * serialVersionUID is unique id for class in project implementation.
	 */
	private static final long serialVersionUID = 8398882971118001921L;
	private int id;
	private String statusName;

	/**
	 * <p>
	 * List of UserStatus id Constants.
	 * </p>
	 */
	public static final int OPEN_ID = 1;
	public static final int ON_HOLD_ID = 2;
	public static final int ESCALATED_ID = 3;
	public static final int CLOSE_ID = 4;

	/**
	 * <p>
	 * List of UserStatus Constants.
	 * </p>
	 */

	public static final String OPEN = "Open";
	public static final String ONHOLD = "On-Hold";
	public static final String ESCALATED = "Escalated";
	public static final String CLOSE = "Close";

	public TicketStatus() {
	}

	public TicketStatus(int id) {
		this.id = id;
	}

	public TicketStatus(int id, String name) {
		this.id = id;
		this.statusName = name;
	}

	/**
	 * Compare object with TicketStatus object for equality of hashCode.
	 * 
	 * @return 0 if not equals and return 1 if both are equals.
	 */
	public int compareTo(Object obj) {

		if (this.hashCode() == obj.hashCode()) {
			return 1;
		}

		return 0;
	}

	public void setTicketStatus(int id) {
		this.id = id;
	}

	public int getTicketStatusId() {
		return this.id;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	/**
	 * This method will return TicketStatus Name based on TicketStatusId.
	 * 
	 * @param statusId
	 * @return
	 */
	public static String getTicketStatus(int statusId) {
		String TICKET_STATUS = null;

		switch (statusId) {
		case OPEN_ID: {
			TICKET_STATUS = OPEN;
			break;
		}
		case ON_HOLD_ID: {
			TICKET_STATUS = ONHOLD;
			break;
		}
		case ESCALATED_ID: {
			TICKET_STATUS = ESCALATED;
			break;
		}
		case CLOSE_ID: {
			TICKET_STATUS = CLOSE;
			break;
		}
		default: {
		}
		}

		return TICKET_STATUS;
	}



	/**
	 * <p>
	 * <code>getTicketstatusList</code>This method returns list of Ticket Status
	 * </p>
	 * 
	 * @return list of Ticket Status in HashTable object
	 */

	public static Hashtable<Integer, String> getTicketstatusList() {
		Hashtable<Integer, String> hashtable = new Hashtable<Integer, String>();
		hashtable.put(new Integer(OPEN), OPEN);
		hashtable.put(new Integer(ON_HOLD_ID), ONHOLD);
		hashtable.put(new Integer(ESCALATED_ID), ESCALATED);
		hashtable.put(new Integer(CLOSE_ID), CLOSE);
		return hashtable;
	}

	/**
	 * <p>
	 * <code>getModifiedTicketStatusList</code>This method returns list of Ticket
	 * Status for changing the Ticket Status.
	 * </p>
	 * 
	 * @return list of User Role in HashTable object
	 */
	public static HashMap<Integer, String> getModifiedTicketStatusList() {
		HashMap<Integer, String> hashtable = new HashMap<Integer, String>();
		hashtable.put(new Integer(OPEN_ID), OPEN);
		hashtable.put(new Integer(ON_HOLD_ID), ONHOLD);
		hashtable.put(new Integer(ESCALATED_ID), ESCALATED);
		hashtable.put(new Integer(CLOSE_ID), CLOSE);
		return hashtable;
	}

}
