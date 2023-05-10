package com.bst.ckt.helper;

import java.io.Serializable;
import java.util.HashMap;

public class DealerDetailsAdvanceSearch implements Comparable<Object>,Serializable{

	

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

	
	
	public static final int DEALER_ID_ID = 1;
	public static final int CITY_ID = 2;
	public static final int MOBILE_ID = 3;
	public static final int STATE_ID = 4;
	
	
	
	public static final String DEALER_ID = "Dealer Id";
	public static final String CITY = "City";
	public static final String MOBILE = "Mobile";
	public static final String STATE = "State";
	
	
	
	public int id;
	public String value;
	
	public DealerDetailsAdvanceSearch()
	{
		//do nothing.
		
	}
	
	public DealerDetailsAdvanceSearch(int id)
	{
		this.id=id;
		
	}
	
	public DealerDetailsAdvanceSearch(String value)
	{
		this.value=value;
		
	}
	
	public DealerDetailsAdvanceSearch(int id,String value)
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


	public static String getDealerSearchValue(int advanceSearchId)
	{
		String ADVANCESEARCHVALUE=null;
		
		switch (advanceSearchId) {
		case DEALER_ID_ID:
			ADVANCESEARCHVALUE=DEALER_ID;
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
	
	public static HashMap<Integer, String> getDealerSearchList()
	{
		HashMap<Integer, String> hashMap=new HashMap<Integer, String>();
		
		hashMap.put(new Integer(DEALER_ID_ID), DEALER_ID);
		hashMap.put(new Integer(CITY_ID), CITY);
		hashMap.put(new Integer(MOBILE_ID), MOBILE);
		hashMap.put(new Integer(STATE_ID), STATE);
		
		
		return hashMap;
	}
	
}
