package com.bst.ckt.helper;

import java.io.Serializable;
import java.util.HashMap;

public class RetailerCustomerAdvanceSearch implements Comparable<Object>,Serializable{

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

	
	
	public static final int CUSTOMER_ID_ID = 1;
	public static final int CITY_ID = 2;
	public static final int MOBILE_ID = 3;
	public static final int STATE_ID = 4;
	
	
	
	public static final String CUSTOMER_ID = "Customer Id";
	public static final String CITY = "City";
	public static final String MOBILE = "Mobile";
	public static final String STATE = "State";
	
	
	
	public int id;
	public String value;
	
	public RetailerCustomerAdvanceSearch()
	{
		//do nothing.
		
	}
	
	public RetailerCustomerAdvanceSearch(int id)
	{
		this.id=id;
		
	}
	
	public RetailerCustomerAdvanceSearch(String value)
	{
		this.value=value;
		
	}
	
	public RetailerCustomerAdvanceSearch(int id,String value)
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


	public static String getRetailerCustomerSearchValue(int advanceSearchId)
	{
		String ADVANCESEARCHVALUE=null;
		
		switch (advanceSearchId) {
		case CUSTOMER_ID_ID:
			ADVANCESEARCHVALUE=CUSTOMER_ID;
			break;
		case CITY_ID:
			ADVANCESEARCHVALUE=CITY;
			break;
		
		case MOBILE_ID:
			ADVANCESEARCHVALUE=MOBILE;
			break;
			
		case STATE_ID:
			ADVANCESEARCHVALUE=STATE;
			break;
		
		
		
			
		}
		
		return ADVANCESEARCHVALUE;
	}
	
	public static HashMap<Integer, String> getRetailerCustomerSearchList()
	{
		HashMap<Integer, String> hashMap=new HashMap<Integer, String>();
		
		hashMap.put(new Integer(CUSTOMER_ID_ID), CUSTOMER_ID);
		hashMap.put(new Integer(CITY_ID), CITY);
		hashMap.put(new Integer(MOBILE_ID), MOBILE);
		hashMap.put(new Integer(STATE_ID), STATE);
		
		
		return hashMap;
	}
	
}
