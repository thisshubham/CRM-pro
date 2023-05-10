package com.bst.ckt.helper;

import java.io.Serializable;
import java.util.HashMap;

public class LeadAdvanceSerach implements Comparable<Object>, Serializable {

	/**
	 * Compare object with LeadStatus object for equality of hashCode.
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
	
	public static final int LEADID_ID = 1;
	public static final int COMPANY_NAME_ID = 2;
	public static final int LEAD_TITLE_ID = 3;
	public static final int CONTACT_PERSONE_ID = 4;
	public static final int LEAD_OWNER_ID = 5;
	public static final int LEAD_DATE_ID = 6;
	public static final int EXPECTED_CLOSING_DATE_ID = 7;
	public static final int STATUS_ID = 8;
	
	
	/**
	 * <p>
	 * List of Search Item value Constants.
	 * </p>
	 */

	public static final String LEADID = "Lead Id";
	public static final String COMPANY_NAME = "Company Name";
	public static final String CONTACT_ERSONE = "Contact Person";
	public static final String LEAD_OWNER = "Lead Owner";
	public static final String LEAD_DATE = "Lead Date";
	public static final String LEAD_TITLE = "Lead Title";
	public static final String EXPECTED_CLOSING_DATE = "Expected Closing Date";
	public static final String STATUS = "Status";
	
	
	public int id;
	public String value;
	
	public LeadAdvanceSerach()
	{
		//do nothing.
		
	}
	
	public LeadAdvanceSerach(int id)
	{
		this.id=id;
		
	}
	
	public LeadAdvanceSerach(String value)
	{
		this.value=value;
		
	}
	
	public LeadAdvanceSerach(int id,String value)
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
	 * This method will return lead search value based on advanceSearchId.
	 * 
	 * @param advanceSearchId
	 * @return ADVANCESERACHVALUE
	 */
	public static String getLeadAdvanceSearchValue(int advanceSearchId)
	{
		String ADVANCESERACHVALUE=null;
		
		switch (advanceSearchId) {
		case LEADID_ID:
			ADVANCESERACHVALUE=LEADID;
			break;
		case COMPANY_NAME_ID:
			ADVANCESERACHVALUE=COMPANY_NAME;
			break;
		case LEAD_TITLE_ID:
			ADVANCESERACHVALUE=LEAD_TITLE;
			break;
		case CONTACT_PERSONE_ID:
			ADVANCESERACHVALUE=CONTACT_ERSONE;
			break;
		case LEAD_OWNER_ID:
			ADVANCESERACHVALUE=LEAD_OWNER;
			break;
		case LEAD_DATE_ID:
			ADVANCESERACHVALUE=LEAD_DATE;
			break;
		case EXPECTED_CLOSING_DATE_ID:
			ADVANCESERACHVALUE=EXPECTED_CLOSING_DATE;
			break;
		case STATUS_ID:
			ADVANCESERACHVALUE=STATUS;
			break;
			
		}
		
		return ADVANCESERACHVALUE;
	}
	
	
	/**
	 * <p>
	 * <code>getLeadAdvanceSearchList</code>This method returns list of Lead advance
	 * search list 
	 * </p>
	 * 
	 * @return list of Lead advance search  in HashTable object
	 */
	public static HashMap<Integer, String> getLeadAdvanceSearchList()
	{
		HashMap<Integer, String> hashMap=new HashMap<Integer, String>();
		
		hashMap.put(new Integer(LEADID_ID), LEADID);
		hashMap.put(new Integer(COMPANY_NAME_ID),COMPANY_NAME);
		hashMap.put(new Integer(LEAD_TITLE_ID), LEAD_TITLE);
		hashMap.put(new Integer(CONTACT_PERSONE_ID), CONTACT_ERSONE);
		hashMap.put(new Integer(LEAD_OWNER_ID), LEAD_OWNER);
		hashMap.put(new Integer(LEAD_DATE_ID), LEAD_DATE);
		hashMap.put(new Integer(EXPECTED_CLOSING_DATE_ID), EXPECTED_CLOSING_DATE);
		hashMap.put(new Integer(STATUS_ID), STATUS);
		return hashMap;
	}

}
