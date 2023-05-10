package com.bst.ckt.helper;

import java.io.Serializable;
import java.util.HashMap;

public class campaignAdvanceSearch implements Comparable<Object>, Serializable {

	/**
	 * Compare object with CampaignId object for equality of hashCode.
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
	
	public static final int CAMPAIGNID_ID=1;
	public static final int CAMPAIGN_NAME_ID = 2;
	public static final int CAMPAIGN_TYPE_ID = 3;
	public static final int ASSIGNED_TO_ID = 4;
	public static final int EXPECTED_REVENUE_ID = 5;
	public static final int EXPECTED_CLOSING_DATE_ID = 6;
	public static final int STATUS_ID = 7;
	
	
	/**
	 * <p>
	 * List of Search Item value Constants.
	 * </p>
	 */

	public static final String CAMPAIGNID="Campaign Id";
	public static final String CAMPAIGN_NAME = "Campaign Name";
	public static final String CAMPAIGN_TYPE = "Campaign Type";
	public static final String ASSIGNED_TO = "Assigned To";
	public static final String EXPECTED_REVENUE = "Expected Revenue";
	public static final String EXPECTED_CLOSING_DATE = "Expected Closing Date";
	public static final String STATUS = "Status";
		
	
	public int id;
	public String value;
	
	public campaignAdvanceSearch()
	{
		
		
	}
	
	public campaignAdvanceSearch(int id)
	{
		this.id=id;
		
	}
	
	public campaignAdvanceSearch(String value)
	{
		this.value=value;
		
	}
	
	public campaignAdvanceSearch(int id,String value)
	{
		this.value=value;
		this.id=id;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
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
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}
	
	
	/**
	 * This method will return Campaign search value based on advanceSearchId.
	 * 
	 * @param advanceSearchId
	 * @return ADVANCESERACHVALUE
	 */
	public static String getCampaignAdvanceSearchValue(int advanceSearchId)
	{
		String ADVANCESERACHVALUE=null;
		
		switch (advanceSearchId) {
		
		case CAMPAIGNID_ID:
			ADVANCESERACHVALUE=CAMPAIGNID;
			break;
		case CAMPAIGN_NAME_ID:
			ADVANCESERACHVALUE=CAMPAIGN_NAME;
			break;
		case CAMPAIGN_TYPE_ID:
			ADVANCESERACHVALUE=CAMPAIGN_TYPE;
			break;
		case ASSIGNED_TO_ID:
			ADVANCESERACHVALUE=ASSIGNED_TO;
			break;
		
		case EXPECTED_REVENUE_ID:
			ADVANCESERACHVALUE=EXPECTED_REVENUE;
			break;
		case EXPECTED_CLOSING_DATE_ID:
			ADVANCESERACHVALUE=EXPECTED_CLOSING_DATE;
			break;
		case STATUS_ID:
			ADVANCESERACHVALUE=STATUS;
			break;	
		}
		
		return ADVANCESERACHVALUE;
	}
	
	
	/**
	 * <p>
	 * <code>getVendorAdvanceSearchList</code>This method returns list of Campaign advance
	 * search list 
	 * </p>
	 * 
	 * @return list of Campaign advance search  in HashTable object
	 */
	public static HashMap<Integer, String> getCampaignAdvanceSearchList()
	{
		HashMap<Integer, String> hashMap=new HashMap<Integer, String>();
		
		hashMap.put(new Integer(CAMPAIGNID_ID),CAMPAIGNID);
		hashMap.put(new Integer(CAMPAIGN_NAME_ID),CAMPAIGN_NAME);
		hashMap.put(new Integer(CAMPAIGN_TYPE_ID), CAMPAIGN_TYPE);
		hashMap.put(new Integer(ASSIGNED_TO_ID), ASSIGNED_TO);
		hashMap.put(new Integer(EXPECTED_REVENUE_ID),EXPECTED_REVENUE);
		hashMap.put(new Integer(EXPECTED_CLOSING_DATE_ID), EXPECTED_CLOSING_DATE);
		hashMap.put(new Integer(STATUS_ID), STATUS);
		
		
		return hashMap;
	}

}
