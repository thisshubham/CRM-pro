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
public class CampaignExpectedResponse implements Comparable<Object>,
		Serializable {

	/**
	 * serialVersionUID is unique id for class in project implementation.
	 */
	private static final long serialVersionUID = 8398882971118001921L;
	private int id;
	private String expectedResponse;

	/**
	 * <p>
	 * List of UserStatus id Constants.
	 * </p>
	 */
	public static final int EXCELLENT_ID = 1;
	public static final int GOOD_ID = 2;
	public static final int AVERAGE_ID = 3;
	public static final int POOR_ID = 4;
	public static final int OTHER_ID = 5;

	/**
	 * <p>
	 * List of UserStatus Constants.Excellent, Good, Average, Poor
	 * </p>
	 */
	public static final String EXCELLENT = "Excellent";
	public static final String GOOD = "Good";
	public static final String AVERAGE = "Average";
	public static final String POOR = "Poor";
	public static final String OTHER = "Other";

	public CampaignExpectedResponse() {
		// nothing will do
	}

	public CampaignExpectedResponse(int id) {
		this.id = id;
	}

	public CampaignExpectedResponse(int id, String name) {
		this.id = id;
		this.expectedResponse = name;
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

	public void setCampaignExpectedResponse(int id) {
		this.id = id;
	}

	public int getCampaignExpectedResponseId() {
		return this.id;
	}

	/**
	 * @return the expectedResponse
	 */
	public String getExpectedResponse() {
		return expectedResponse;
	}

	/**
	 * @param expectedResponse
	 *            the expectedResponse to set
	 */
	public void setExpectedResponse(String expectedResponse) {
		this.expectedResponse = expectedResponse;
	}

	/**
	 * This method will return UserStatus Name based on statusId.
	 * 
	 * @param statusId
	 * @return
	 */
	public static String getCampaignExpectedResponse(
			int CampaignExpectedResponseId) {
		String CAMPAIGN_EXPECTED_RESPONSE = null;

		switch (CampaignExpectedResponseId) {
		case EXCELLENT_ID: {
			CAMPAIGN_EXPECTED_RESPONSE = EXCELLENT;
			break;
		}
		case GOOD_ID: {
			CAMPAIGN_EXPECTED_RESPONSE = GOOD;
			break;
		}
		case AVERAGE_ID: {
			CAMPAIGN_EXPECTED_RESPONSE = AVERAGE;
			break;
		}
		case POOR_ID: {
			CAMPAIGN_EXPECTED_RESPONSE = POOR;
			break;
		}
		default: {
			CAMPAIGN_EXPECTED_RESPONSE = OTHER;
		}
		}

		return CAMPAIGN_EXPECTED_RESPONSE;
	}

	/**
	 * <p>
	 * This method returns list of User Status
	 * </p>
	 * 
	 * @return list of User Status in hashMap object
	 */
	public static HashMap<Integer, String> getCampaignExpectedResponseList() {

		HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
		hashMap.put(new Integer(EXCELLENT_ID), EXCELLENT);
		hashMap.put(new Integer(GOOD_ID), GOOD);
		hashMap.put(new Integer(AVERAGE_ID), AVERAGE);
		hashMap.put(new Integer(POOR_ID), POOR);
		hashMap.put(new Integer(OTHER_ID), OTHER);

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
	public static HashMap<Integer, String> getCreateCampaignExpectedResponseList() {
		HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
		hashMap.put(new Integer(EXCELLENT_ID), EXCELLENT);
		hashMap.put(new Integer(GOOD_ID), GOOD);
		hashMap.put(new Integer(AVERAGE_ID), AVERAGE);
		hashMap.put(new Integer(POOR_ID), POOR);
		hashMap.put(new Integer(OTHER_ID), OTHER);

		return hashMap;
	}
}
