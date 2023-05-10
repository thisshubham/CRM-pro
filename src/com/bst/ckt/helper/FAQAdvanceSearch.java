package com.bst.ckt.helper;

import java.io.Serializable;
import java.util.HashMap;

public class FAQAdvanceSearch implements Comparable<Object>, Serializable {

	/**
	 * Compare object with Faq Search object for equality of hashCode.
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

	public static final int FAQ_ID = 1;
	public static final int QUESTION_ID = 2;
	public static final int CATEGORY_ID = 3;
	public static final int PRODUCT_NAME_ID = 4;
	public static final int OWNER_ID = 5;
	public static final int STATUS_ID = 6;

	/**
	 * <p>
	 * List of Search Item value Constants.
	 * </p>
	 */

	public static final String FAQID = "Faq Id";
	public static final String QUESTION = "Question";
	public static final String CATEGORY = "Category ";
	public static final String PRODUCT_NAME = "Product Name";
	public static final String OWNER = "Owner";
	public static final String STATUS = "Status";

	public int id;
	public String value;

	public FAQAdvanceSearch() {
	}

	public FAQAdvanceSearch(int id) {
		this.id = id;

	}

	public FAQAdvanceSearch(String value) {
		this.value = value;

	}

	public FAQAdvanceSearch(int id, String value) {
		this.value = value;
		this.id = id;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
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
	 * @param value
	 *            the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * This method will return faq search value based on advanceSearchId.
	 * 
	 * @param advanceSearchId
	 * @return ADVANCESERACHVALUE
	 */
	public static String getFaqAdvanceSearchValue(int advanceSearchId) {
		String ADVANCESERACHVALUE = null;
		switch (advanceSearchId) {
		case FAQ_ID:
			ADVANCESERACHVALUE = FAQID;
			break;
		case QUESTION_ID:
			ADVANCESERACHVALUE = QUESTION;
			break;
		case CATEGORY_ID:
			ADVANCESERACHVALUE = CATEGORY;
			break;
		case PRODUCT_NAME_ID:
			ADVANCESERACHVALUE = PRODUCT_NAME;
			break;
		case OWNER_ID:
			ADVANCESERACHVALUE = OWNER;
			break;
		case STATUS_ID:
			ADVANCESERACHVALUE = STATUS;
			break;
		}

		return ADVANCESERACHVALUE;
	}

	/**
	 * <p>
	 * <code>getFaqAdvanceSearchList</code>This method returns list of Faq
	 * advance search list
	 * </p>
	 * 
	 * @return list of Faq advance search in HashTable object
	 */
	public static HashMap<Integer, String> getFaqAdvanceSearchList() {
		HashMap<Integer, String> hashMap = new HashMap<Integer, String>();

		hashMap.put(new Integer(FAQ_ID), FAQID);
		hashMap.put(new Integer(QUESTION_ID), QUESTION);
		hashMap.put(new Integer(CATEGORY_ID), CATEGORY);
		hashMap.put(new Integer(PRODUCT_NAME_ID), PRODUCT_NAME);
		hashMap.put(new Integer(OWNER_ID), OWNER);
		hashMap.put(new Integer(STATUS_ID), STATUS);
		return hashMap;
	}

}
