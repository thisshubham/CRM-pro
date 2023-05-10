package com.bst.ckt.helper;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Hashtable;

public class ServiceStatus implements Comparable<Object>, Serializable {

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
	public static final int NEW_ID = 1;
	public static final int OPEN_ID = 2;
	public static final int VERFIED_ID = 3;
	public static final int NOT_VERFIED_ID = 4;
	public static final int CLOSE_ID = 5;

	/**
	 * <p>
	 * List of UserStatus Constants.
	 * </p>
	 */
	public static final String NEW = "New";
	public static final String OPEN = "Open";
	public static final String VERFIED = "Verfied";
	public static final String NOT_VERFIED = "Not Verified";
	public static final String CLOSE = "Close";

	public ServiceStatus() {
	}

	public ServiceStatus(int id) {
		this.id = id;
	}

	public ServiceStatus(int id, String name) {
		this.id = id;
		this.statusName = name;
	}

	/**
	 * Compare object with ServiceStatus object for equality of hashCode.
	 * 
	 * @return 0 if not equals and return 1 if both are equals.
	 */
	public int compareTo(Object obj) {

		if (this.hashCode() == obj.hashCode()) {
			return 1;
		}

		return 0;
	}

	public void setServiceStatus(int id) {
		this.id = id;
	}

	public int getServiceStatusId() {
		return this.id;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	/**
	 * This method will return ServiceStatus Name based on ServiceStatusId.
	 * 
	 * @param statusId
	 * @return
	 */
	public static String getServiceStatus(int statusId) {
		String SERVICE_STATUS = null;

		switch (statusId) {
		case NEW_ID: {
			SERVICE_STATUS = NEW;
			break;
		}
		case OPEN_ID: {
			SERVICE_STATUS = OPEN;
			break;
		}
		case VERFIED_ID: {
			SERVICE_STATUS = VERFIED;
			break;
		}
		case NOT_VERFIED_ID: {
			SERVICE_STATUS = NOT_VERFIED;
			break;
		}
		case CLOSE_ID: {
			SERVICE_STATUS = CLOSE;
			break;
		}
		default: {
		}
		}

		return SERVICE_STATUS;
	}

	/**
	 * <p>
	 * <code>getServicestatusList</code>This method returns list of Service
	 * Status
	 * </p>
	 * 
	 * @return list of Service Status in HashTable object
	 */

	public static Hashtable<Integer, String> getServicestatusList() {
		Hashtable<Integer, String> hashtable = new Hashtable<Integer, String>();
		hashtable.put(new Integer(NEW_ID), NEW);
		hashtable.put(new Integer(OPEN_ID), OPEN);
		hashtable.put(new Integer(VERFIED_ID), VERFIED);
		hashtable.put(new Integer(NOT_VERFIED_ID), NOT_VERFIED);
		hashtable.put(new Integer(CLOSE_ID), CLOSE);
		return hashtable;
	}

	/**
	 * <p>
	 * <code>getModifiedServiceStatusList</code>This method returns list of
	 * SERVICE Status for changing the SERVICE Status.
	 * </p>
	 * 
	 * @return list of User Role in HashTable object
	 */
	public static HashMap<Integer, String> getModifiedServiceStatusList() {
		HashMap<Integer, String> hashtable = new HashMap<Integer, String>();
		hashtable.put(new Integer(OPEN_ID), OPEN);
		hashtable.put(new Integer(OPEN_ID), OPEN);
		hashtable.put(new Integer(VERFIED_ID), VERFIED);
		hashtable.put(new Integer(CLOSE_ID), CLOSE);
		return hashtable;
	}

}
