/**
 * 
 */
package com.bst.ckt.helper;

import java.io.Serializable;
import java.util.HashMap;

/**
 * @author gurjar
 * 
 */
public class CampaignStatus implements Comparable<Object>, Serializable {

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
	public static final int ACTIVE_ID = 1;
	public static final int CANCELLED_ID = 2;
	public static final int CAMPLETE_ID = 3;
	public static final int DRAFT_ID = 4;
	public static final int FAILED_ID = 5;
	public static final int INACTIVE_ID = 6;
	public static final int INPROGRESS_ID = 7;
	public static final int PLANNING_ID = 8;
	public static final int QUEUED_ID = 9;
	public static final int SEND_ID = 10;
	public static final int NOT_AN_USER_ID = 10;

	/**
	 * <p>
	 * List of UserStatus Constants.
	 * </p>
	 */
	public static final String ACTIVE = "Active";
	public static final String CANCELLED = "Cancelled";
	public static final String CAMPLETE = "Complete";
	public static final String DRAFT = "Draft";
	public static final String FAILED = "Failed";
	public static final String INACTIVE = "Inactive";
	public static final String INPROGRESS = "InProgress";
	public static final String PLANNING = "Planning";
	public static final String QUEUED = "Queued";
	public static final String SEND = "Send";
	public static final String NOT_AN_USER = "NotAnUser";

	public CampaignStatus() {
		// nothing will do
	}

	public CampaignStatus(int id) {
		this.id = id;
	}

	public CampaignStatus(int id, String name) {
		this.id = id;
		this.statusName = name;
	}

	/**
	 * Compare object with UserStatus object for equality of hashCode.
	 * 
	 * @return 0 if not equals and return 1 if both are equals.
	 */
	public int compareTo(Object obj) {

		if (this.hashCode() == obj.hashCode()) {
			return 1;
		}

		return 0;
	}

	public void setUserStatus(int id) {
		this.id = id;
	}

	public int getUserStatusId() {
		return this.id;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setCampaignStatus(String statusName) {
		this.statusName = statusName;
	}

	/**
	 * This method will return UserStatus Name based on statusId.
	 * 
	 * @param statusId
	 * @return
	 */
	public static String getCampaignStatus(int statusId) {
		String CAMPAIGN_STATUS = null;

		switch (statusId) {
		case ACTIVE_ID: {
			CAMPAIGN_STATUS = ACTIVE;
			break;
		}
		case CANCELLED_ID: {
			CAMPAIGN_STATUS = CANCELLED;
			break;
		}
		case CAMPLETE_ID: {
			CAMPAIGN_STATUS = CAMPLETE;
			break;
		}
		case DRAFT_ID: {
			CAMPAIGN_STATUS = DRAFT;
			break;
		}
		case FAILED_ID: {
			CAMPAIGN_STATUS = FAILED;
			break;
		}
		case INACTIVE_ID: {
			CAMPAIGN_STATUS = INACTIVE;
			break;
		}
		case PLANNING_ID: {
			CAMPAIGN_STATUS = PLANNING;
			break;
		}
		case QUEUED_ID: {
			CAMPAIGN_STATUS = QUEUED;
			break;
		}
		case SEND_ID: {
			CAMPAIGN_STATUS = SEND;
			break;
		}
		default: {
			CAMPAIGN_STATUS = NOT_AN_USER;
		}
		}

		return CAMPAIGN_STATUS;
	}

	/**
	 * <p>
	 * This method returns list of User Status
	 * </p>
	 * 
	 * @return list of User Status in hashMap object
	 */
	public static HashMap<Integer, String> getCampaignStatusList() {

		HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
		hashMap.put(new Integer(ACTIVE_ID), ACTIVE);
		hashMap.put(new Integer(CANCELLED_ID), CANCELLED);
		hashMap.put(new Integer(CAMPLETE_ID), CAMPLETE);
		hashMap.put(new Integer(DRAFT_ID), DRAFT);
		hashMap.put(new Integer(FAILED_ID), FAILED);
		hashMap.put(new Integer(INACTIVE_ID), INACTIVE);
		hashMap.put(new Integer(PLANNING_ID), PLANNING);
		hashMap.put(new Integer(QUEUED_ID), QUEUED);
		hashMap.put(new Integer(SEND_ID), SEND);
		hashMap.put(new Integer(NOT_AN_USER_ID), NOT_AN_USER);

		return hashMap;
	}

	/**
	 * <p>
	 * This method returns list of User Status when use is active and Admin
	 * wants to change the status.
	 * </p>
	 * 
	 * @return list of User Role in hashMap object
	 */
	public static HashMap<Integer, String> getCreateCampaignStatusList() {
		HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
		hashMap.put(new Integer(ACTIVE_ID), ACTIVE);
		hashMap.put(new Integer(CANCELLED_ID), CANCELLED);
		hashMap.put(new Integer(CAMPLETE_ID), CAMPLETE);
		hashMap.put(new Integer(DRAFT_ID), DRAFT);
		hashMap.put(new Integer(FAILED_ID), FAILED);
		hashMap.put(new Integer(INACTIVE_ID), INACTIVE);
		hashMap.put(new Integer(PLANNING_ID), PLANNING);
		hashMap.put(new Integer(QUEUED_ID), QUEUED);
		hashMap.put(new Integer(SEND_ID), SEND);
		hashMap.put(new Integer(NOT_AN_USER_ID), NOT_AN_USER);

		return hashMap;
	}
}
