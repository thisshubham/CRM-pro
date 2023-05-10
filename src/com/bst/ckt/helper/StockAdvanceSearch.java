package com.bst.ckt.helper;

import java.io.Serializable;
import java.util.HashMap;

public class StockAdvanceSearch  implements Comparable<Object>,Serializable{

	
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

	
	
	public static final int STOCK_ID_ID = 1;
	public static final int TYPE_ID = 2;
	public static final int CATEGORY_ID = 3;
	
	
	
	
	public static final String STOCK_ID = "Stock Id";
	public static final String TYPE = "Type";
	public static final String CATEGORY = "Category";
	
	
	
	
	public int id;
	public String value;
	
	public StockAdvanceSearch()
	{
		//do nothing.
		
	}
	
	public StockAdvanceSearch(int id)
	{
		this.id=id;
		
	}
	
	public StockAdvanceSearch(String value)
	{
		this.value=value;
		
	}
	
	public StockAdvanceSearch(int id,String value)
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


	public static String getStockSearchValue(int advanceSearchId)
	{
		String ADVANCESEARCHVALUE=null;
		
		switch (advanceSearchId) {
		case STOCK_ID_ID:
			ADVANCESEARCHVALUE=STOCK_ID;
			break;
		case TYPE_ID:
			ADVANCESEARCHVALUE=TYPE;
			break;
		
		case CATEGORY_ID:
			ADVANCESEARCHVALUE=CATEGORY;
			break;
		}
		
		return ADVANCESEARCHVALUE;
	}
	
	public static HashMap<Integer, String> getStockSearchList()
	{
		HashMap<Integer, String> hashMap=new HashMap<Integer, String>();
		
		hashMap.put(new Integer(STOCK_ID_ID), STOCK_ID);
		hashMap.put(new Integer(TYPE_ID), TYPE);
		hashMap.put(new Integer(CATEGORY_ID), CATEGORY);
		
		
		
		return hashMap;
	}
	
}
