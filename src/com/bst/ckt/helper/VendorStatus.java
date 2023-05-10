/**
 * 
 */
package com.bst.ckt.helper;

import java.io.Serializable;
import java.util.Hashtable;

/**
 * @author Deepak Vishwakarma
 *
 */
public class VendorStatus implements Comparable<Object>, Serializable {

	/**
	 * serialVersionUID is unique id for class in project implementation.
	 */
	private static final long serialVersionUID = 8398882971118001921L;
	private int id;
	private String statusName;
	
    /**
	 * <p>List of VendorStatus id Constants.</p>
	 */
	public static final int NEW_ID=1;	
	public static final int SUBMITTED_ID=2;
	public static final int REGISTERED_ID=3;
	public static final int ACTIVE_ID=4;
	public static final int SUSPENDED_ID=5;
	public static final int INACTIVE_ID=6;
	public static final int DELETED_ID =7;
	public static final int NOT_AN_VENDOR_STSTUS_ID =8;
	
    /**
	 * <p>List of VendorStatus Constants.</p>
	 */
	public static final String NEW="New";	
	public static final String SUBMITTED="Submitted";
	public static final String REGISTERED="Registered";
	public static final String ACTIVE="Active";
	public static final String SUSPENDED="Suspended";
	public static final String INACTIVE="Inactive";
	public static final String DELETED = "Deleted";
	public static final String NOT_AN_VENDOR_STSTUS = "NotAnVendorStatus";

	public VendorStatus() {
        // nothing will do
    }

    public VendorStatus(int id) {
        this.id = id;
    }

    public VendorStatus(int id, String name) {
        this.id = id;
        this.statusName = name;
    }

    /**
     * Compare object with VendorStatus object for equality of hashCode.
     * @return 0 if not equals and return 1 if both are equals.
     */
    public int compareTo(Object obj) {

    	if(this.hashCode() == obj.hashCode())
    	{
    		return 1;
    	}

        return 0;
    }

    public void setVendorStatus(int id) {
        this.id = id;
    }

    public int getVendorStatusId() {
        return this.id;
    }

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
    /**
     * This method will return VendorStatus Name based on statusId.
     * @param statusId
     * @return
     */
    public static String getUserStatus(int statusId) {
        String VENDOR_STATUS = null;

        switch (statusId) {
        case NEW_ID: {
        	VENDOR_STATUS = NEW;
            break;
        }
        case SUBMITTED_ID: {
        	VENDOR_STATUS = SUBMITTED;
            break;
        }
        case REGISTERED_ID: {
        	VENDOR_STATUS = REGISTERED;
            break;
        }
        case ACTIVE_ID: {
        	VENDOR_STATUS = ACTIVE;
            break;
        }
        case SUSPENDED_ID: {
        	VENDOR_STATUS = SUSPENDED;
            break;
        }
        case INACTIVE_ID: {
        	VENDOR_STATUS = INACTIVE;
            break;
        }
        case DELETED_ID: {
        	VENDOR_STATUS = DELETED;
            break;
        }
        default: {
        	VENDOR_STATUS = NOT_AN_VENDOR_STSTUS;
        }
        }
        
        return VENDOR_STATUS;
    }
    
    /**
     * <p>This method returns list of VendorStatus</p>
     * @return list of VendorStatus in HashTable object
     */
    public static Hashtable<Integer, String> getVendorStatusList()
    {
    	Hashtable<Integer, String> hashtable = new Hashtable<Integer, String>();
    	hashtable.put(new Integer(NEW_ID), NEW);
    	hashtable.put(new Integer(SUBMITTED_ID), SUBMITTED);
    	hashtable.put(new Integer(REGISTERED_ID), REGISTERED);
    	hashtable.put(new Integer(ACTIVE_ID), ACTIVE);
    	hashtable.put(new Integer(SUSPENDED_ID), SUSPENDED);
    	hashtable.put(new Integer(INACTIVE_ID), INACTIVE);
    	hashtable.put(new Integer(DELETED_ID), DELETED);
    	
    	return hashtable;
    }

    /**
     * <p>This method returns list of VendorStatus when use is active and Admin wants to change the status.</p>
     * @return list of VendorStatus in HashTable object
     */
    public static Hashtable<Integer, String> getCreateVendorStatusList()
    {
    	Hashtable<Integer, String> hashtable = new Hashtable<Integer, String>();
    	hashtable.put(new Integer(ACTIVE_ID), ACTIVE);
    	hashtable.put(new Integer(SUSPENDED_ID), SUSPENDED);
    	hashtable.put(new Integer(INACTIVE_ID), INACTIVE);
    	hashtable.put(new Integer(DELETED_ID), DELETED);
    	
    	return hashtable;
    }
}
