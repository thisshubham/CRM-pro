/*
 **********************************************************************
 *
 * COPYRIGHT. $ID$ 2014. ALL RIGHTS RESERVED.
 *
 * This software is only to be used for the purpose for which it has been
 * provided. No part of it is to be reproduced, disassembled, transmitted,
 * stored in a retrieval system nor translated in any human or computer
 * language in any way or for any other purposes whatsoever without the
 * prior written consent of $ID$.
 * 
 * Class Name     UserStatus.java     
 *                                                            
 * Creation Date  OCT 4, 2014 
 * 
 * Abstract       This class is utility class for User Status in project.
 * 
 * Amendment History (in chronological sequence): OCT 4, 2014
 * 
 **********************************************************************
 */

package com.bst.ckt.framework.user;

import java.io.Serializable;
import java.util.Hashtable;


public class UserStatus implements Comparable<Object>, Serializable {

	/**
	 * serialVersionUID is unique id for class in project implementation.
	 */
	private static final long serialVersionUID = 8398882971118001921L;
	private int id;
	private String statusName;
	
    /**
	 * <p>List of UserStatus id Constants.</p>
	 */
	public static final int NEW_ID=1;	
	public static final int SUBMITTED_ID=2;
	public static final int REGISTERED_ID=3;
	public static final int ACTIVE_ID=4;
	public static final int SUSPENDED_ID=5;
	public static final int INACTIVE_ID=6;
	public static final int DELETED_ID =7;
	public static final int NOT_AN_USER_ID =8;
	
    /**
	 * <p>List of UserStatus Constants.</p>
	 */
	public static final String NEW="New";	
	public static final String SUBMITTED="Submitted";
	public static final String REGISTERED="Registered";
	public static final String ACTIVE="Active";
	public static final String SUSPENDED="Suspended";
	public static final String INACTIVE="Inactive";
	public static final String DELETED = "Deleted";
	public static final String NOT_AN_USER = "NotAnUser";

	public UserStatus() {
        // nothing will do
    }

    public UserStatus(int id) {
        this.id = id;
    }

    public UserStatus(int id, String name) {
        this.id = id;
        this.statusName = name;
    }

    /**
     * Compare object with UserStatus object for equality of hashCode.
     * @return 0 if not equals and return 1 if both are equals.
     */
    public int compareTo(Object obj) {

    	if(this.hashCode() == obj.hashCode())
    	{
    		return 1;
    	}

        return 0;
    }

    public void setUserStatus(int id) {
        this.id = id;
    }

    public int getUserStatusId() {
        return this.id;
    }

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
    /**
     * This method will return UserStatus Name based on statusId.
     * @param statusId
     * @return
     */
    public static String getUserStatus(int statusId) {
        String USER_STATUS = null;

        switch (statusId) {
        case NEW_ID: {
            USER_STATUS = NEW;
            break;
        }
        case SUBMITTED_ID: {
            USER_STATUS = SUBMITTED;
            break;
        }
        case REGISTERED_ID: {
            USER_STATUS = REGISTERED;
            break;
        }
        case ACTIVE_ID: {
            USER_STATUS = ACTIVE;
            break;
        }
        case SUSPENDED_ID: {
            USER_STATUS = SUSPENDED;
            break;
        }
        case INACTIVE_ID: {
            USER_STATUS = INACTIVE;
            break;
        }
        case DELETED_ID: {
            USER_STATUS = DELETED;
            break;
        }
        default: {
            USER_STATUS = NOT_AN_USER;
        }
        }
        
        return USER_STATUS;
    }
    
    /**
     * <p>This method returns list of User Status</p>
     * @return list of User Status in HashTable object
     */
    public static Hashtable<Integer, String> getUserStatusList()
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
     * <p>This method returns list of User Status when use is active and Admin wants to change the status.</p>
     * @return list of User Role in HashTable object
     */
    public static Hashtable<Integer, String> getCreateUserStatusList()
    {
    	Hashtable<Integer, String> hashtable = new Hashtable<Integer, String>();
    	hashtable.put(new Integer(ACTIVE_ID), ACTIVE);
    	hashtable.put(new Integer(SUSPENDED_ID), SUSPENDED);
    	hashtable.put(new Integer(INACTIVE_ID), INACTIVE);
    	hashtable.put(new Integer(DELETED_ID), DELETED);
    	
    	return hashtable;
    }
}
