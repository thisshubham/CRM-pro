package com.bst.ckt.helper;

import java.io.Serializable;
import java.util.HashMap;

public class DealerTransactionAdvanceSearch  implements Comparable<Object>,Serializable{


	
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

	
	
	public static final int TRANSACTION_ID_ID = 1;
	public static final int DESCRIPTION_ID = 2;
	public static final int DEALER_ID_ID = 3;
	public static final int PAYMENT_MODE_ID = 4;
	public static final int DATE_ID = 5;
	
	
	
	public static final String TRANSACTION_ID = "Transaction Id";
	public static final String DESCRIPTION = "Description";
	public static final String DEALER_ID = "Dealer Id";
	public static final String PAYMENT_MODE = "Payment Mode";
	public static final String DATE = "Transaction Date";
	
	
	
	public int id;
	public String value;
	
	public DealerTransactionAdvanceSearch()
	{
		//do nothing.
		
	}
	
	public DealerTransactionAdvanceSearch(int id)
	{
		this.id=id;
		
	}
	
	public DealerTransactionAdvanceSearch(String value)
	{
		this.value=value;
		
	}
	
	public DealerTransactionAdvanceSearch(int id,String value)
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


	public static String getDealerTransactionSearchValue(int advanceSearchId)
	{
		String ADVANCESEARCHVALUE=null;
		
		switch (advanceSearchId) {
		case TRANSACTION_ID_ID:
			ADVANCESEARCHVALUE=TRANSACTION_ID;
			break;
		case DESCRIPTION_ID:
			ADVANCESEARCHVALUE=DESCRIPTION;
			break;
		
		case DEALER_ID_ID:
			ADVANCESEARCHVALUE=DEALER_ID;
			break;
			
		case PAYMENT_MODE_ID:
			ADVANCESEARCHVALUE=PAYMENT_MODE;
			break;
			
		case DATE_ID:
			ADVANCESEARCHVALUE=DATE;
			break;
		
		
		
			
		}
		
		return ADVANCESEARCHVALUE;
	}
	
	public static HashMap<Integer, String> getDealerTransactionSearchList()
	{
		HashMap<Integer, String> hashMap=new HashMap<Integer, String>();
		
		hashMap.put(new Integer(TRANSACTION_ID_ID), TRANSACTION_ID);
		hashMap.put(new Integer(DESCRIPTION_ID), DESCRIPTION);
		hashMap.put(new Integer(DEALER_ID_ID), DEALER_ID);
		hashMap.put(new Integer(PAYMENT_MODE_ID), PAYMENT_MODE);
		hashMap.put(new Integer(DATE_ID), DATE);
		
		
		return hashMap;
	}
}
