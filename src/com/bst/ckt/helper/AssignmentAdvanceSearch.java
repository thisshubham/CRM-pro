/**
 * 
 */
package com.bst.ckt.helper;

import java.io.Serializable;
import java.util.HashMap;

/**
 * @author Admin
 *
 */
public class AssignmentAdvanceSearch implements Comparable<Object>,Serializable {
	
	/**
	 * serialVersionUID is unique id for class in project implementation.
	 */
	private static final long serialVersionUID = 9013713858970821153L;

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
	 * <p>
	 * List of search item id Constants.
	 * </p>
	 */
	
	public static final int ASSIGNMENT_ID_ID = 1;
	public static final int ASSIGN_TO_ID = 2;
	public static final int EXPECTED_CLOSING_DATE_ID = 3;
	public static final int STATUS_ID = 4;
	
	
	
	/**
	 * <p>
	 * List of Search Item value Constants.
	 * </p>
	 */

	public static final String ASSIGNMENT_ID = "Assignment Id";
	public static final String ASSIGN_TO = "Assigned To";
	public static final String EXPECTED_CLOSING_DATE = "Expected Closing date";
	public static final String STATUS = "Status";
	
	
	
	
	public int id;
	public String value;
	
	public AssignmentAdvanceSearch()
	{
		//do nothing.
		
	}
	
	public AssignmentAdvanceSearch(int id)
	{
		this.id=id;
		
	}
	
	public AssignmentAdvanceSearch(String value)
	{
		this.value=value;
		
	}
	
	public AssignmentAdvanceSearch(int id,String value)
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
	 * This method will return assignment search value based on advanceSearchId.
	 * 
	 * @param advanceSearchId
	 * @return ADVANCESERACHVALUE
	 */
	public static String getAssignmentAdvanceSearchValue(int advanceSearchId)
	{
		String ADVANCESEARCHVALUE=null;
		
		switch (advanceSearchId) {
		case ASSIGNMENT_ID_ID:
			ADVANCESEARCHVALUE=ASSIGNMENT_ID;
			break;
		case ASSIGN_TO_ID:
			ADVANCESEARCHVALUE=ASSIGN_TO;
			break;
		
		case EXPECTED_CLOSING_DATE_ID:
			ADVANCESEARCHVALUE=EXPECTED_CLOSING_DATE;
			break;
			
		case STATUS_ID:
			ADVANCESEARCHVALUE=STATUS;
			break;
		
		
			
		}
		
		return ADVANCESEARCHVALUE;
	}
	
	
	/**
	 * <p>
	 * <code>getAssignmentAdvanceSearchList</code>This method returns list of Assignment advance
	 * search list 
	 * </p>
	 * 
	 * @return list of Assignment advance search  in HashTable object
	 */
	public static HashMap<Integer, String> getAssignmentAdvanceSearchList()
	{
		HashMap<Integer, String> hashMap=new HashMap<Integer, String>();
		
		hashMap.put(new Integer(ASSIGNMENT_ID_ID), ASSIGNMENT_ID);
		hashMap.put(new Integer(ASSIGN_TO_ID),ASSIGN_TO);
		hashMap.put(new Integer(EXPECTED_CLOSING_DATE_ID), EXPECTED_CLOSING_DATE);
		hashMap.put(new Integer(STATUS_ID),STATUS);
		
		return hashMap;
	}


}
