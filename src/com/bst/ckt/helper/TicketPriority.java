package com.bst.ckt.helper;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Hashtable;

public class TicketPriority implements Comparable<Object>, Serializable {
	/**
	 * serialVersionUID is unique id for class in project implementation.
	 */
	private static final long serialVersionUID = 8398882971118001921L;
	private int id;
	private String priorityName;

	/**
	 * <p>
	 * List of TicketPriority id Constants.
	 * </p>
	 */
	public static final int LOW_ID = 1;
	public static final int MEDIUM_ID = 2;
	public static final int HIGH_ID = 3;

	/**
	 * <p>
	 * List of TicketPriority Constants.
	 * </p>
	 */

	public static final String LOW = "Low";
	public static final String MEDIUM = "Medium";
	public static final String HIGH = "High";

	public TicketPriority() {
	}

	public TicketPriority(int id) {
		this.id = id;
	}

	public TicketPriority(int id, String name) {
		this.id = id;
		this.priorityName = name;
	}

	/**
	 * Compare object with TicketPriority object for equality of hashCode.
	 * 
	 * @return 0 if not equals and return 1 if both are equals.
	 */
	public int compareTo(Object obj) {

		if (this.hashCode() == obj.hashCode()) {
			return 1;
		}

		return 0;
	}

	public void setTicketPriority(int id) {
		this.id = id;
	}

	public int getTicketPriorityId() {
		return this.id;
	}

	public String getPriorityName() {
		return priorityName;
	}

	public void setPriorityName(String priorityName) {
		this.priorityName = priorityName;
	}

	/**
	 * This method will return TicketPriority based on TicketPriorityId.
	 * 
	 * @param priorityId
	 * @return
	 */
	public static String getTicketPriority(int priorityId) {
		String TICKET_PRIORITY = null;

		switch (priorityId) {
		case LOW_ID: {
			TICKET_PRIORITY = LOW;
			break;
		}
		case MEDIUM_ID: {
			TICKET_PRIORITY = MEDIUM;
			break;
		}
		case HIGH_ID: {
			TICKET_PRIORITY = HIGH;
			break;
		}
		
		default: {
		}
		}
		return TICKET_PRIORITY;
		}

	/**
	 * <p>
	 * <code>getTicketPriorityList</code>This method returns list of Ticket
	 * Priority
	 * </p>
	 * 
	 * @return list of Ticket Priority in HashTable object
	 */

	public static Hashtable<Integer, String> getTicketPriorityList() {
		Hashtable<Integer, String> hashtable = new Hashtable<Integer, String>();
		hashtable.put(new Integer(LOW), LOW);
		hashtable.put(new Integer(MEDIUM_ID), MEDIUM);
		hashtable.put(new Integer(HIGH_ID), HIGH);
		return hashtable;
	}

	/**
	 * <p>
	 * <code>getModifiedTicketStatusList</code>This method returns list of
	 * Ticket Priority for changing the Ticket Priority.
	 * </p>
	 * 
	 * @return list of User Role in HashTable object
	 */
	public static HashMap<Integer, String> getModifiedTicketPriorityList() {
		HashMap<Integer, String> hashtable = new HashMap<Integer, String>();
		hashtable.put(new Integer(LOW_ID), LOW);
		hashtable.put(new Integer(MEDIUM_ID), MEDIUM);
		hashtable.put(new Integer(HIGH_ID), HIGH);
		return hashtable;
	}

}
