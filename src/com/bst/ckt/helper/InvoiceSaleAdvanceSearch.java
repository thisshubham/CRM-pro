package com.bst.ckt.helper;

import java.util.HashMap;

public class InvoiceSaleAdvanceSearch {

	
	/**
	 * <p>
	 * List of search item id Constants.
	 * </p>
	 */
	
	public static final int SALES_ID_ID = 1;
	public static final int CUSTOMER_TYPE_ID = 2;
	public static final int SALES_DATE_ID=3;
	public static final int PAY_MODE_ID = 4;
	public static final int CUSTOMER_REFERENCE_ID = 5;
	public static final int PAYMENT_ANSWER_ID = 6;
	public static final int UNIQUE_ID_ID = 7;
	
	
	/**
	 * <p>
	 * List of Search Item value Constants.
	 * </p>
	 */

	public static final String SALES_ID = "Sales Id";
	public static final String CUSTOMER_TYPE = "Customer Type";
	public static final String SALES_DATE = "Sales Date";
	public static final String PAY_MODE = "Payment Mode";
	public static final String CUSTOMER_REFERENCE= "Customer Reference";
	public static final String PAYMENT_ANSWER = "Payment Answer";
	public static final String UNIQUE_ID = "Sales Reference";
	
		/**
	 * This method will return lead search value based on advanceSearchId.
	 * 
	 * @param advanceSearchId
	 * @return ADVANCESERACHVALUE
	 */
	public static String getInvoiceSalesAdvanceSearchValue(int advanceSearchId)
	{
		String ADVANCESERACHVALUE=null;
		
		switch (advanceSearchId) {
		case SALES_ID_ID:
			ADVANCESERACHVALUE=SALES_ID;
			break;
		case CUSTOMER_TYPE_ID:
			ADVANCESERACHVALUE=CUSTOMER_TYPE;
			break;
		case SALES_DATE_ID:
			ADVANCESERACHVALUE=SALES_DATE;
			break;
		case PAY_MODE_ID:
			ADVANCESERACHVALUE=PAY_MODE;
			break;
		case CUSTOMER_REFERENCE_ID:
			ADVANCESERACHVALUE=CUSTOMER_REFERENCE;
			break;
		case PAYMENT_ANSWER_ID:
			ADVANCESERACHVALUE=PAYMENT_ANSWER;
			break;
		case UNIQUE_ID_ID:
			ADVANCESERACHVALUE=UNIQUE_ID;
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
	public static HashMap<Integer, String> getInvoiceSalesAdvanceSearchList()
	{
		HashMap<Integer, String> hashMap=new HashMap<Integer, String>();
		
		hashMap.put(new Integer(SALES_ID_ID), SALES_ID);
		hashMap.put(new Integer(CUSTOMER_TYPE_ID),CUSTOMER_TYPE);
		hashMap.put(new Integer(SALES_DATE_ID),SALES_DATE);
		hashMap.put(new Integer(PAY_MODE_ID), PAY_MODE);
		hashMap.put(new Integer(CUSTOMER_REFERENCE_ID), CUSTOMER_REFERENCE);
		hashMap.put(new Integer(PAYMENT_ANSWER_ID), PAYMENT_ANSWER);
		hashMap.put(new Integer(UNIQUE_ID_ID), UNIQUE_ID);
		
		return hashMap;
	}

}
