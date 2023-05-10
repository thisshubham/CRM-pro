package com.bst.ckt.helper;

import java.util.HashMap;

public class AnalyticalCampaignModuleUtil {
	/**
	 * <p>
	 * List of search item id Constants. 
	 * 
	 * </p>
	 */

	public static final int CAMPIGN_BY_STATUS_ID = 1;
	public static final int CAMPAIGN_BY_TYPE_ID = 2;
	public static final int CAMPAIGN_OWNER_ID = 3;
	public static final int ASSIGNED_TO_ID = 4;

	/**
	 * <p>
	 * List of Search Item value Constants.
	 * </p>
	 */

	public static final String CAMPAIGN_BY_STATUS = "Campaign By Status";
	public static final String CAMPAIGN_BY_TYPE= "Campaign By Type";
	public static final String CAMPAIGN_OWNER= "Campaign Owner";
	public static final String ASSIGNED_TO = "Assigned To";
	
	/**
	 * This method will return lead search value based on advanceSearchId.
	 * 
	 * @param advanceSearchId
	 * @return ANALYTICSCAMPAIGN
	 */
	public static String getAnalyticsCampaignModule(int analyticsCampaign) {
		String ANALYTICSCAMPAIGN = null;

		switch (analyticsCampaign) {
		case CAMPIGN_BY_STATUS_ID:
			ANALYTICSCAMPAIGN = CAMPAIGN_BY_STATUS;
			break;
		case CAMPAIGN_BY_TYPE_ID:
			ANALYTICSCAMPAIGN = CAMPAIGN_BY_TYPE;
			break;
		case CAMPAIGN_OWNER_ID:
			ANALYTICSCAMPAIGN = CAMPAIGN_OWNER;
			break;
		case ASSIGNED_TO_ID:
			ANALYTICSCAMPAIGN = ASSIGNED_TO;
			break;
		

		}

		return ANALYTICSCAMPAIGN;
	}

	/**
	 * <p>
	 * <code>getAnalyticalCampaign()</code>This method returns list of
	 * analytical Campaign  list
	 * </p>
	 * 
	 * @return list of analytical Campaign search in HashTable object
	 */

	public static HashMap<Integer, String> getAnalyticalCampaign() {
		// TODO Auto-generated method stub
		HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
		hashMap.put(new Integer(CAMPIGN_BY_STATUS_ID), CAMPAIGN_BY_STATUS);
		hashMap.put(new Integer(CAMPAIGN_BY_TYPE_ID), CAMPAIGN_BY_TYPE);
		hashMap.put(new Integer(CAMPAIGN_OWNER_ID), CAMPAIGN_OWNER);
		hashMap.put(new Integer(ASSIGNED_TO_ID), ASSIGNED_TO);
		

		return hashMap;
	}

}
