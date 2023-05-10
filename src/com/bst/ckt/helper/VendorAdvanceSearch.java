package com.bst.ckt.helper;

import java.io.Serializable;
import java.util.HashMap;

public class VendorAdvanceSearch implements Comparable<Object>, Serializable {

	/**
	 * Compare object with VendorId object for equality of hashCode.
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
	
	public static final int VENDORID_ID=1;
	public static final int FULL_NAME_ID = 2;
	public static final int PHONE_NO_ID = 3;
	public static final int PRIMARY_EMAIL_ID = 4;
	public static final int VENDOR_CATEGORY_ID = 5;
	public static final int ASSIGN_TO_ID = 6;
	public static final int VENDOR_STATUS_ID = 7;
	
	
	/**
	 * <p>
	 * List of Search Item value Constants.
	 * </p>
	 */

	public static final String VENDORID="Vendor Id";
	public static final String FULL_NAME = "Full Name";
	public static final String PHONE_NO = "Phone No";
	public static final String PRIMARY_EMAIL = "Primary Email";
	public static final String VENDOR_CATEGORY = "Vendor Category";
	public static final String ASSIGN_TO = "Assign TO";
	public static final String VENDOR_STATUS = "Vendor Status";
		
	
	public int id;
	public String value;
	
	public VendorAdvanceSearch()
	{
		
		
	}
	
	public VendorAdvanceSearch(int id)
	{
		this.id=id;
		
	}
	
	public VendorAdvanceSearch(String value)
	{
		this.value=value;
		
	}
	
	public VendorAdvanceSearch(int id,String value)
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
	
	
	/**
	 * This method will return Vendor search value based on advanceSearchId.
	 * 
	 * @param advanceSearchId
	 * @return ADVANCESERACHVALUE
	 */
	public static String getVendorAdvanceSearchValue(int advanceSearchId)
	{
		String ADVANCESERACHVALUE=null;
		
		switch (advanceSearchId) {
		
		case VENDORID_ID:
			ADVANCESERACHVALUE=VENDORID;
			break;
		case FULL_NAME_ID:
			ADVANCESERACHVALUE=FULL_NAME;
			break;
		case PHONE_NO_ID:
			ADVANCESERACHVALUE=PHONE_NO;
			break;
		case PRIMARY_EMAIL_ID:
			ADVANCESERACHVALUE=PRIMARY_EMAIL;
			break;
		
		case VENDOR_CATEGORY_ID:
			ADVANCESERACHVALUE=VENDOR_CATEGORY;
			break;
		case ASSIGN_TO_ID:
			ADVANCESERACHVALUE=ASSIGN_TO;
			break;
		case VENDOR_STATUS_ID:
			ADVANCESERACHVALUE=VENDOR_STATUS;
			break;	
		}
		
		return ADVANCESERACHVALUE;
	}
	
	
	/**
	 * <p>
	 * <code>getVendorAdvanceSearchList</code>This method returns list of Vendor advance
	 * search list 
	 * </p>
	 * 
	 * @return list of Vendor advance search  in HashTable object
	 */
	public static HashMap<Integer, String> getVendorAdvanceSearchList()
	{
		HashMap<Integer, String> hashMap=new HashMap<Integer, String>();
		
		hashMap.put(new Integer(VENDORID_ID),VENDORID);
		hashMap.put(new Integer(FULL_NAME_ID),FULL_NAME);
		hashMap.put(new Integer(PHONE_NO_ID), PHONE_NO);
		hashMap.put(new Integer(PRIMARY_EMAIL_ID), PRIMARY_EMAIL);
		hashMap.put(new Integer(VENDOR_CATEGORY_ID),VENDOR_CATEGORY);
		hashMap.put(new Integer(ASSIGN_TO_ID), ASSIGN_TO);
		hashMap.put(new Integer(VENDOR_STATUS_ID), VENDOR_STATUS);
		
		
		return hashMap;
	}

}
