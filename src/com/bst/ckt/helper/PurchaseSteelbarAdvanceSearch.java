package com.bst.ckt.helper;

import java.io.Serializable;
import java.util.HashMap;

public class PurchaseSteelbarAdvanceSearch implements Comparable<Object>,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	public int compareTo(Object obj) {
		if (this.hashCode() == obj.hashCode()) {
			return 1;
		}

		return 0;
	}

	
	
	public static final int PURCHASE_ID_ID = 1;
	public static final int COMPANY_ID = 2;
	public static final int INVOICE_NO_ID = 3;
	public static final int MATERIAL_CODE_ID = 4;
	public static final int DEALER_NAME_ID = 5;
	public static final int INVOICE_DATE_ID = 6;
	
	
	public static final String PURCHASE_ID = "Purchase Id";
	public static final String COMPANY = "Company";
	public static final String INVOICE_NO = "Invoice no";
	public static final String MATERIAL_CODE = "Material Code";
	public static final String DEALER_NAME = "Dealer Name";
	public static final String INVOICE_DATE = "Invoice Date";
	
	
	public int id;
	public String value;
	
	public PurchaseSteelbarAdvanceSearch()
	{
		//do nothing.
		
	}
	
	public PurchaseSteelbarAdvanceSearch(int id)
	{
		this.id=id;
		
	}
	
	public PurchaseSteelbarAdvanceSearch(String value)
	{
		this.value=value;
		
	}
	
	public PurchaseSteelbarAdvanceSearch(int id,String value)
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


	public static String getPurchaseSteelbarSearchValue(int advanceSearchId)
	{
		String ADVANCESEARCHVALUE=null;
		
		switch (advanceSearchId) {
		case PURCHASE_ID_ID:
			ADVANCESEARCHVALUE=PURCHASE_ID;
			break;
		case COMPANY_ID:
			ADVANCESEARCHVALUE=COMPANY;
			break;
		
		case INVOICE_NO_ID:
			ADVANCESEARCHVALUE=INVOICE_NO;
			break;
			
		case MATERIAL_CODE_ID:
			ADVANCESEARCHVALUE=MATERIAL_CODE;
			break;
			
		case DEALER_NAME_ID:
			ADVANCESEARCHVALUE=DEALER_NAME;
			break;
			
		case INVOICE_DATE_ID:
			ADVANCESEARCHVALUE=INVOICE_DATE;
			break;
		
		
			
		}
		
		return ADVANCESEARCHVALUE;
	}
	
	public static HashMap<Integer, String> getPurchaseSteelbarSearchList()
	{
		HashMap<Integer, String> hashMap=new HashMap<Integer, String>();
		
		hashMap.put(new Integer(PURCHASE_ID_ID), PURCHASE_ID);
		hashMap.put(new Integer(COMPANY_ID), COMPANY);
		hashMap.put(new Integer(INVOICE_NO_ID), INVOICE_NO);
		hashMap.put(new Integer(MATERIAL_CODE_ID), MATERIAL_CODE);
		hashMap.put(new Integer(DEALER_NAME_ID), DEALER_NAME);
		hashMap.put(new Integer(INVOICE_DATE_ID), INVOICE_DATE);
		
		return hashMap;
	}

}
