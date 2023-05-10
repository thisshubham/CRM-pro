package com.bst.ckt.helper;

import java.io.Serializable;
import java.util.Hashtable;

public class Modules implements Comparable<Object>, Serializable{

	/**
	 * serialVersionUID is unique id for class in project implementation.
	 */
	private static final long serialVersionUID = 8046802762129602937L;

	private int id;
	private String moduleName;
	
	
	/**
	 * <p>
	 * List of modules id Constants.
	 * </p>
	 */
	public static final int LEAD_ID = 1;
	public static final int ACCOUNT_ID = 2;
	public static final int CONTACTS_ID = 3;
	public static final int MY_ACCOUNT_ID = 4;
	public static final int USER_MANAGEMENT_ID = 5;
	/**
	 * <p>
	 * List of Modules Names Constants.
	 * </p>
	 */

	public static final String LEAD = "Lead";
	public static final String ACCOUNT = "Account";
	public static final String CONTACTS = "Contacts";
	public static final String MY_ACCOUNT = "MyAccount";
	public static final String USER_MANAGEMENT="UserManagement";
	public static final String NO_MODULES = "NoModules";
	
	public Modules() { 
		this.id=0;
		this.moduleName="";
	}
	
	public Modules(int id, String moduleName) {
		this.id = id;
		this.moduleName = moduleName;
	}

	/**
	 * Compare object with Modules object for equality of hashCode.
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
	 * This method will return Module Name based on id.
	 * 
	 * @param statusId
	 * @return
	 */
	public static String getModuleName(int id) {
		String MODULE_NAME = null;
		
		switch(id) {
		case LEAD_ID: {
			MODULE_NAME = LEAD;
			break;
		}
		case ACCOUNT_ID: {
			MODULE_NAME = ACCOUNT;
			break;
		}
		case CONTACTS_ID: {
			MODULE_NAME = CONTACTS;
			break;
		}
		case MY_ACCOUNT_ID: {
			MODULE_NAME = MY_ACCOUNT;
			break;
			}
		case USER_MANAGEMENT_ID: {
			MODULE_NAME = USER_MANAGEMENT;
			break;
			}
		default: {
			MODULE_NAME = NO_MODULES;
		}
		}

		return MODULE_NAME;
		
	}
	
	
	/**
	 * <p>
	 * <code>getModulesList</code>This method returns list of Modules
	 * </p>
	 * 
	 * @return list of Modules Name in HashTable object
	 */

	public static Hashtable<Integer, String> getModulesList() {
		Hashtable<Integer, String> hashtable = new Hashtable<Integer, String>();
		hashtable.put(new Integer(LEAD_ID), LEAD);
		hashtable.put(new Integer(ACCOUNT_ID), ACCOUNT);
		hashtable.put(new Integer(CONTACTS_ID), CONTACTS);
		hashtable.put(new Integer(MY_ACCOUNT_ID), MY_ACCOUNT);
		hashtable.put(new Integer(USER_MANAGEMENT_ID), USER_MANAGEMENT);
		return hashtable;
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
	 * @return the moduleName
	 */
	public String getModuleName() {
		return moduleName;
	}

	/**
	 * @param moduleName the moduleName to set
	 */
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	
}
