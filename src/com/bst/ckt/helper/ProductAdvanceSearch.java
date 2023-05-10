package com.bst.ckt.helper;
import java.util.HashMap;

public class ProductAdvanceSearch  {

	
	/**
	 * <p>
	 * List of search item id Constants.
	 * </p>
	 */
	
	public static final int PRODUCTID_ID = 1;
	public static final int PRODUCT_NAME_ID = 2;
	public static final int STATUS_ID=3;
	public static final int PRODUCT_CATEGORY_ID = 4;
	public static final int SALES_START_DATE_ID = 5;
	public static final int SALES_END_DATE_ID = 6;
	
	
	/**
	 * <p>
	 * List of Search Item value Constants.
	 * </p>
	 */

	public static final String PRODUCT_ID = "Product Id";
	public static final String PRODUCT_NAME = "Product Name";
	public static final String STATUS = "Status";
	public static final String PRODUCT_CATEGORY = "Product Category";
	public static final String SALES_START_DATE= "Sales Start Date";
	public static final String SALES_END_DATE = "Sales End Date";
	
		/**
	 * This method will return lead search value based on advanceSearchId.
	 * 
	 * @param advanceSearchId
	 * @return ADVANCESERACHVALUE
	 */
	public static String getProductAdvanceSearchValue(int advanceSearchId)
	{
		String ADVANCESERACHVALUE=null;
		
		switch (advanceSearchId) {
		case PRODUCTID_ID:
			ADVANCESERACHVALUE=PRODUCT_ID;
			break;
		case PRODUCT_NAME_ID:
			ADVANCESERACHVALUE=PRODUCT_NAME;
			break;
		case STATUS_ID:
			ADVANCESERACHVALUE=STATUS;
			break;
		case PRODUCT_CATEGORY_ID:
			ADVANCESERACHVALUE=PRODUCT_CATEGORY;
			break;
		case SALES_START_DATE_ID:
			ADVANCESERACHVALUE=SALES_START_DATE;
			break;
		case SALES_END_DATE_ID:
			ADVANCESERACHVALUE=SALES_END_DATE;
			break;
	
			
			
		}
		
		return ADVANCESERACHVALUE;
	}
	public int id;
	public String value;
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getValue() {
		return value;
	}


	public void setValue(String value) {
		this.value = value;
	}


	/**
	 * <p>
	 * <code>getLeadAdvanceSearchList</code>This method returns list of Lead advance
	 * search list 
	 * </p>
	 * 
	 * @return list of Lead advance search  in HashTable object
	 */
	public static HashMap<Integer, String> getProductAdvanceSearchList()
	{
		HashMap<Integer, String> hashMap=new HashMap<Integer, String>();
		
		hashMap.put(new Integer(PRODUCTID_ID), PRODUCT_ID);
		hashMap.put(new Integer(PRODUCT_NAME_ID),PRODUCT_NAME);
		hashMap.put(new Integer(STATUS_ID),STATUS);
		hashMap.put(new Integer(PRODUCT_CATEGORY_ID), PRODUCT_CATEGORY);
		hashMap.put(new Integer(SALES_START_DATE_ID), SALES_START_DATE);
		hashMap.put(new Integer(SALES_END_DATE_ID), SALES_END_DATE);
		
		return hashMap;
	}

}
