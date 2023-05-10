package com.bst.ckt.helper;

import java.util.HashMap;

public class AnalyticProductModuleUtil {

	/**
	 * <p>
	 * List of search item id Constants. 
	 * 
	 * </p>
	 */

	public static final int PRODUCT_BY_CATEGORY_ID = 1;
	public static final int PRODUCT_BY_STATUS_ID = 2;
	

	/**
	 * <p>
	 * List of Search Item value Constants.
	 * </p>
	 */

	public static final String PRODUCT_BY_CATEGORY = "Product Name";
	public static final String PRODUCT_BY_STATUS = "Product By Status";
	
	/**
	 * This method will return assignment search value based on advanceSearchId.
	 * 
	 * @param advanceSearchId
	 * @return ANALYTICSASSINMENT
	 */
	public static String getAnalyticsProductModule(int analyticsProduct) {
		String ANALYTICSPRODUCT = null;

		switch (analyticsProduct) {
		case PRODUCT_BY_CATEGORY_ID:
			ANALYTICSPRODUCT = PRODUCT_BY_CATEGORY;
			break;
		case PRODUCT_BY_STATUS_ID:
			ANALYTICSPRODUCT = PRODUCT_BY_STATUS;
			break;
		

		}

		return ANALYTICSPRODUCT;
	}

	/**
	 * <p>
	 * <code>getAnalyticalProduct()</code>This method returns list of
	 * analytical Product list
	 * </p>
	 * 
	 * @return list of analytical Product search in HashTable object
	 */

	public static HashMap<Integer, String> getAnalyticalProduct() {
		// TODO Auto-generated method stub
		HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
		hashMap.put(new Integer(PRODUCT_BY_CATEGORY_ID), PRODUCT_BY_CATEGORY);
		hashMap.put(new Integer(PRODUCT_BY_STATUS_ID), PRODUCT_BY_STATUS);
		return hashMap;
	}

}
