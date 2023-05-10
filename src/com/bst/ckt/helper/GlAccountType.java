package com.bst.ckt.helper;

import java.io.Serializable;
import java.util.HashMap;

public class GlAccountType implements Comparable<Object>, Serializable{

	/**
	 * serialVersionUID is unique id for class in project implementation.
	 */
	private static final long serialVersionUID = 8398882971118001921L;
	private int id;
	
	
    	/**
	 * <p>List of GlAccountType id Constants.</p>
	 */
		
	public static final int ASSETS_ID=1;	
	public static final int LIABILITIES_ID=2;	
	public static final int EXPENSES_ID=3;	
	public static final int EQUITY_ID=4;	
	public static final int OTHER_ID=5;	
	
    	/**
	 * <p>List of GlAccountType Constants.</p>
	 */
		
	public static final String ASSETS="Assets.";
	public static final String LIABILITIES="Liabilities.";
	public static final String EXPENSES="Expenses.";
	public static final String EQUITY="Equity.";
	public static final String OTHER= "Other";

	public GlAccountType() {
        // nothing will do
    }

    public GlAccountType(int id) {
        this.id = id;
    }

    

	/**
	 * Compare object with GlAccountType object for equality of hashCode.
	 * 
	 * @return 0 if not equals and return 1 if both are equals.
	 */
	@Override
	public int compareTo(Object obj) {

		if (this.hashCode() == obj.hashCode()) {
			return 1;
		}

		return 0;
	}

	
	/**
	 * This method will return GlAccountType based on id.
	 * 
	 * @param id
	 * @return
	 */
	public static String getGlAccountType(int id) {
		
		String YOUR_GLACCOUNT=null;
		
		switch (id) {
		
		case ASSETS_ID:
			YOUR_GLACCOUNT=ASSETS;
			break;
		case LIABILITIES_ID:
			YOUR_GLACCOUNT=LIABILITIES;
			break;
		case EXPENSES_ID:
			YOUR_GLACCOUNT=EXPENSES;
			break;
		case EQUITY_ID:
			YOUR_GLACCOUNT=EQUITY;
			break;
		
		case OTHER_ID:
			YOUR_GLACCOUNT=OTHER;
			break;
		}		
		return YOUR_GLACCOUNT;
	}
	
	
	/**
	 * <p>
	 * <code>getGlAccountTypeList</code>This method returns list of GlAccountType
	 * </p>
	 * 
	 * @return list of GlAccountType in HashTable object
	 */

	public static HashMap<Integer, String> getGlAccountTypeList() {
		HashMap<Integer, String> HashMap = new HashMap<Integer, String>();
		
		HashMap.put(new Integer(ASSETS_ID), ASSETS);
		HashMap.put(new Integer(LIABILITIES_ID), LIABILITIES);
		HashMap.put(new Integer(EXPENSES_ID), EXPENSES);
		HashMap.put(new Integer(EQUITY_ID), EQUITY);
		HashMap.put(new Integer(OTHER_ID), OTHER);
		return HashMap;
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

	
}

