package com.bst.ckt.helper;

import java.util.HashMap;

public class AnalyticsDocumentModuleUtil {

	/**
	 * <p>
	 * List of search item id Constants.
	 * </p>
	 */

	public static final int DOCUMENT_BY_STATUS_ID = 1;
	public static final int CREATED_BY_ID = 2;

	/**
	 * <p>
	 * List of Search Item value Constants.
	 * </p>
	 */

	public static final String DOCUMENT_BY_STATUS = "Document By Status";
	public static final String CREATED_BY = "Created By";

	/**
	 * This method will return Document search value based on ANALYTICSDOCUMENT.
	 * 
	 * @param analyticsDocument
	 * @return ANALYTICSDOCUMENT
	 */
	public static String getAnalyticsDocumentModule(int analyticsDocument) {
		String ANALYTICSDOCUMENT = null;

		switch (analyticsDocument) {
		case DOCUMENT_BY_STATUS_ID:
			ANALYTICSDOCUMENT = DOCUMENT_BY_STATUS;
			break;
		case CREATED_BY_ID:
			ANALYTICSDOCUMENT = CREATED_BY;
			break;

		}

		return ANALYTICSDOCUMENT;
	}

	/**
	 * <p>
	 * <code>getAnalyticalDocument()</code>This method is return a Document
	 * Search Values
	 * </p>
	 * 
	 * @return list of analytics Document in HashTable object
	 */

	public static HashMap<Integer, String> getAnalyticalDocument() {
		// TODO Auto-generated method stub
		HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
		hashMap.put(new Integer(DOCUMENT_BY_STATUS_ID), DOCUMENT_BY_STATUS);
		hashMap.put(new Integer(CREATED_BY_ID), CREATED_BY);
		return hashMap;
	}

}
