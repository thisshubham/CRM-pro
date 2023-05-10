package com.bst.ckt.helper;

import java.io.Serializable;
import java.util.HashMap;

public class NoteAdvanceSearch implements Comparable<Object>, Serializable {

	/**
	 * Compare object with NoteId object for equality of hashCode.
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
	
	public static final int NOTEID_ID=1;
	public static final int NOTE_TITLE_ID = 2;
	public static final int CREATEDBY_ID = 3;
	public static final int CREATED_DATE_ID = 4;
	
	
	/**
	 * <p>
	 * List of Search Item value Constants.
	 * </p>
	 */

	public static final String NOTE_ID="note Id";
	public static final String NOTE_TITLE = "Note Title";
	public static final String CREATEDBY = "Created By";
	public static final String CREATED_DATE = "Created Date";
		
	
	public int id;
	public String value;
	
	public NoteAdvanceSearch()
	{
		//do nothing.
		
	}
	
	public NoteAdvanceSearch(int id)
	{
		this.id=id;
		
	}
	
	public NoteAdvanceSearch(String value)
	{
		this.value=value;
		
	}
	
	public NoteAdvanceSearch(int id,String value)
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
	 * This method will return note search value based on advanceSearchId.
	 * 
	 * @param advanceSearchId
	 * @return ADVANCESERACHVALUE
	 */
	public static String getNoteAdvanceSearchValue(int advanceSearchId)
	{
		String ADVANCESERACHVALUE=null;
		
		switch (advanceSearchId) {
		
		case NOTEID_ID:
			ADVANCESERACHVALUE=NOTE_ID;
			break;
		case NOTE_TITLE_ID:
			ADVANCESERACHVALUE=NOTE_TITLE;
			break;
		case CREATEDBY_ID:
			ADVANCESERACHVALUE=CREATEDBY;
			break;
		case CREATED_DATE_ID:
			ADVANCESERACHVALUE=CREATED_DATE;
			break;
		
			
		}
		
		return ADVANCESERACHVALUE;
	}
	
	
	/**
	 * <p>
	 * <code>getNoteAdvanceSearchList</code>This method returns list of Note advance
	 * search list 
	 * </p>
	 * 
	 * @return list of Note advance search  in HashTable object
	 */
	public static HashMap<Integer, String> getNoteAdvanceSearchList()
	{
		HashMap<Integer, String> hashMap=new HashMap<Integer, String>();
		
		hashMap.put(new Integer(NOTEID_ID),NOTE_ID);
		hashMap.put(new Integer(NOTE_TITLE_ID),NOTE_TITLE);
		hashMap.put(new Integer(CREATEDBY_ID), CREATEDBY);
		hashMap.put(new Integer(CREATED_DATE_ID), CREATED_DATE);
		
		return hashMap;
	}

}
