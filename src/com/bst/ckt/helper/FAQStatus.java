package com.bst.ckt.helper;

import java.io.Serializable;
import java.util.Hashtable;

public class FAQStatus implements Comparable<Object>, Serializable {

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
	public static final int NEW_ID = 4;
	public static final int NOT_VERIFIED_ID = 3;
	public static final int VERIFIED_ID = 2;
	public static final int DELETED_ID = 1;

	/**
	 * <p>
	 * List of UserStatus Constants.
	 * </p>
	 */

	public static final String NEW = "New";
	public static final String NOT_VERIFIED = "Not Verified";
	public static final String VERIFIED = "Verified";
	public static final String DELETED = "Deleted";

	public FAQStatus() {
		// nothing will do
	}

	public FAQStatus(int id) {
		this.id = id;
	}

	public FAQStatus(int id, String name) {
		this.id = id;
		this.statusName = name;
	}

	/**
	 * Compare object with FAQStatus object for equality of hashCode.
	 * 
	 * @return 0 if not equals and return 1 if both are equals.
	 */
	public int compareTo(Object obj) {

		if (this.hashCode() == obj.hashCode()) {
			return 1;
		}

		return 0;
	}

	public void setFAQStatus(int id) {
		this.id = id;
	}

	public int getFAQStatusId() {
		return this.id;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	/**
	 * This method will return FAQStatus Name based on FAQStatusId.
	 * 
	 * @param statusId
	 * @return
	 */
	public static String getFAQStatus(int statusId) {
		String FAQ_STATUS = null;

		switch (statusId) {
		case NEW_ID: {
			FAQ_STATUS = NEW;
			break;
		}
		case NOT_VERIFIED_ID: {
			FAQ_STATUS = NOT_VERIFIED;
			break;
		}

		case VERIFIED_ID: {
			FAQ_STATUS = VERIFIED;
			break;
		}
		case DELETED_ID: {
			FAQ_STATUS = DELETED;
			break;
		}

		default: {
		}
		}

		return FAQ_STATUS;
	}

	/**
	 * <p>
	 * <code>getFAQStatusList</code>This method returns list of FAQ Status
	 * </p>
	 * 
	 * @return list of FAQ Status in HashTable object
	 */

	public static Hashtable<Integer, String> getFAQStatusList() {
		Hashtable<Integer, String> hashtable = new Hashtable<Integer, String>();
		hashtable.put(new Integer(NOT_VERIFIED_ID), NOT_VERIFIED);
		hashtable.put(new Integer(VERIFIED_ID), VERIFIED);
		hashtable.put(new Integer(DELETED_ID), DELETED);
		hashtable.put(new Integer(NEW_ID), NEW);

		return hashtable;
	}

	/**
	 * <p>
	 * <code>getModifiedFAQStatusList</code>This method returns list of FAQ
	 * Status for changing the FAQ Status.
	 * </p>
	 * 
	 * @return list of User Role in HashTable object
	 */
	public static Hashtable<Integer, String> getModifiedFAQStatusList() {
		Hashtable<Integer, String> hashtable = new Hashtable<Integer, String>();

		hashtable.put(new Integer(NOT_VERIFIED_ID), NOT_VERIFIED);
		hashtable.put(new Integer(VERIFIED_ID), VERIFIED);
		hashtable.put(new Integer(DELETED_ID), DELETED);
		hashtable.put(new Integer(NEW_ID), NEW);
		return hashtable;
	}

}
