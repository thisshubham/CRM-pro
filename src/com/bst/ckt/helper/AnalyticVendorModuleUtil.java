package com.bst.ckt.helper;

import java.util.HashMap;

public class AnalyticVendorModuleUtil {

	/**
	 * <p>
	 * List of search item id Constants. Vendor by Status (Graph) Vendor by
	 * Category (Grid)
	 * 
	 * 
	 * </p>
	 */

	public static final int VENDOR_BY_CATEGORY_ID = 1;
	public static final int VENDOR_BY_STATUS_ID = 2;

	/**
	 * <p>
	 * List of Search Item value Constants.
	 * </p>
	 */

	public static final String VENDOR_BY_CATEGORY = "Product Name";
	public static final String VENDOR_BY_STATUS = "Product By Status";

	/**
	 * This method will return assignment search value based on advanceSearchId.
	 * 
	 * @param advanceSearchId
	 * @return ANALYTICSVENDOR
	 */
	public static String getAnalyticsVendorModule(int analyticsVendor) {
		String ANALYTICSVENDOR = null;

		switch (analyticsVendor) {
		case VENDOR_BY_CATEGORY_ID:
			ANALYTICSVENDOR = VENDOR_BY_CATEGORY;
			break;
		case VENDOR_BY_STATUS_ID:
			ANALYTICSVENDOR = VENDOR_BY_STATUS;
			break;

		}

		return ANALYTICSVENDOR;
	}

	/**
	 * <p>
	 * <code>getAnalyticalVendor()</code>This method returns list of analytical
	 * Vendor list
	 * </p>
	 * 
	 * @return list of analytical VENDOR search in HashTable object
	 */

	public static HashMap<Integer, String> getAnalyticalVendor() {
		// TODO Auto-generated method stub
		HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
		hashMap.put(new Integer(VENDOR_BY_CATEGORY_ID), VENDOR_BY_CATEGORY);
		hashMap.put(new Integer(VENDOR_BY_STATUS_ID), VENDOR_BY_STATUS);
		return hashMap;
	}

}
