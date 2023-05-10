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
 * Class Name     UserRole.java     
 *                                                            
 * Creation Date  OCT 4, 2014 
 * 
 * Abstract       This class is utility class for User Role in project.
 * 
 * Amendment History (in chronological sequence): OCT 4, 2014
 * 
 **********************************************************************
 */

package com.bst.ckt.framework.user;

import java.util.Hashtable;


/**
 * <p><code>User Role</code> is utility class for User Role into the project.</p>
 * @author Yogendra Singh Rajput
 * @version 1.0
 */
public class UserRole {

	private int id;
	private String userRole;
	
    /**
	 * <p>List of UserRole id Constants.</p>
	 */
	public static final int SUPER_ADMIN_ROLE_ID=1;	
	public static final int IT_MANAGER_ROLE_ID=2;	
	public static final int SUPPORT_ADMIN_ROLE_ID=3;
	public static final int CUSTOMER_ADMIN_ROLE_ID=4;
	public static final int CUSTOMER_MANAGER_ROLE_ID=5;
	public static final int CUSTOMER_SUPERVISOR_ROLE_ID=6;
	public static final int CUSTOMER_ACCOUNTANT_ROLE_ID=7;
	public static final int CUSTOMER_AUDITOR_ROLE_ID=8;
	public static final int CUSTOMER_SALES_ROLE_ID=9;
	public static final int CUSTOMER_MARKETING_ROLE_ID=10;
	public static final int CUSTOMER_END_USER_ROLE_ID =11;
	public static final int CUSTOMER_RESEARCH_ROLE_ID =12;
	
    /**
	 * <p>List of UserRole Constants.</p>
	 */
	public static final String SUPER_ADMIN="Super Admin";	
	public static final String IT_MANAGER="IT Manager";	
	public static final String SUPPORT_ADMIN="Support Admin";
	public static final String CUSTOMER_ADMIN="Customer Admin";
	public static final String CUSTOMER_MANAGER="Customer Manager";
	public static final String SUPERVISOR_MANAGER="Customer Supervisor";
	public static final String ACCOUNTANT_USER="Accountant";
	public static final String AUDITOR_USER="Auditor User";
	public static final String SALES_USER="Sales User";
	public static final String MARKETING_USER="Marketing User";
	public static final String END_USER = "End User";
	public static final String RESEARCH_USER = "Research User";
	public static final String NOT_AN_USER_ROLE = "NotAnUserRole";
	
	public UserRole() {
        // nothing will do
    }

    public UserRole(int id) {
        this.id = id;
    }

    public UserRole(int id, String name) {
        this.id = id;
        this.userRole = name;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
    /**
     * Compare object with UserRole object for equality of hashCode.
     * @return 0 if not equals and return 1 if both are equals.
     */
    public int compareTo(Object obj) {

    	if(this.hashCode() == obj.hashCode())
    	{
    		return 1;
    	}

        return 0;
    }

    /**
     * This method will return UserRole Name based on userRoleId.
     * @param userRoleId
     * @return
     */
    public static String getUserRole(int userRoleId) {
        String USER_ROLE = null;

        switch (userRoleId) {
        case SUPER_ADMIN_ROLE_ID: {
        	USER_ROLE = SUPER_ADMIN;
            break;
        }
        case IT_MANAGER_ROLE_ID: {
        	USER_ROLE = IT_MANAGER;
            break;
        }
        case SUPPORT_ADMIN_ROLE_ID: {
        	USER_ROLE = SUPPORT_ADMIN;
            break;
        }
        case CUSTOMER_ADMIN_ROLE_ID: {
        	USER_ROLE = CUSTOMER_ADMIN;
            break;
        }
        case CUSTOMER_MANAGER_ROLE_ID: {
        	USER_ROLE = CUSTOMER_MANAGER;
            break;
        }
        case CUSTOMER_SUPERVISOR_ROLE_ID: {
        	USER_ROLE = SUPERVISOR_MANAGER;
            break;
        }
        case CUSTOMER_ACCOUNTANT_ROLE_ID: {
        	USER_ROLE = ACCOUNTANT_USER;
            break;
        }
        case CUSTOMER_AUDITOR_ROLE_ID: {
        	USER_ROLE = AUDITOR_USER;
            break;
        }
        case CUSTOMER_SALES_ROLE_ID: {
        	USER_ROLE = SALES_USER;
            break;
        }
        case CUSTOMER_MARKETING_ROLE_ID: {
        	USER_ROLE = MARKETING_USER;
            break;
        }
        case CUSTOMER_END_USER_ROLE_ID: {
        	USER_ROLE = END_USER;
            break;
        }
        case CUSTOMER_RESEARCH_ROLE_ID: {
        	USER_ROLE = RESEARCH_USER;
            break;
        }
        default: {
        	USER_ROLE = NOT_AN_USER_ROLE;
        }
        }
        
        return USER_ROLE;
    }
    
    /**
     * <p>This method returns list of User Roles</p>
     * @return list of User Role in HashTable object
     */
    public static Hashtable<Integer, String> getUserRoleList()
    {

    	Hashtable<Integer, String> hashtable = new Hashtable<Integer, String>();
    	hashtable.put(new Integer(SUPER_ADMIN_ROLE_ID), SUPER_ADMIN);
    	hashtable.put(new Integer(IT_MANAGER_ROLE_ID), IT_MANAGER);
    	hashtable.put(new Integer(SUPPORT_ADMIN_ROLE_ID), SUPPORT_ADMIN);
    	hashtable.put(new Integer(CUSTOMER_ADMIN_ROLE_ID), CUSTOMER_ADMIN);
    	hashtable.put(new Integer(CUSTOMER_MANAGER_ROLE_ID), CUSTOMER_MANAGER);
    	hashtable.put(new Integer(CUSTOMER_SUPERVISOR_ROLE_ID), SUPERVISOR_MANAGER);
    	hashtable.put(new Integer(CUSTOMER_ACCOUNTANT_ROLE_ID), ACCOUNTANT_USER);
    	hashtable.put(new Integer(CUSTOMER_AUDITOR_ROLE_ID), AUDITOR_USER);
    	hashtable.put(new Integer(CUSTOMER_SALES_ROLE_ID), SALES_USER);
    	hashtable.put(new Integer(CUSTOMER_MARKETING_ROLE_ID), MARKETING_USER);
    	hashtable.put(new Integer(CUSTOMER_END_USER_ROLE_ID), END_USER);
    	hashtable.put(new Integer(CUSTOMER_RESEARCH_ROLE_ID), RESEARCH_USER);
    	
    	return hashtable;
    }

    /**
     * <p>This method returns list of User Roles who does not have admin access into the project.</p>
     * @return list of User Role in HashTable object
     */
    public static Hashtable<Integer, String> getCreateUserRoleList()
    {
    	Hashtable<Integer, String> hashtable = new Hashtable<Integer, String>();
    	hashtable.put(new Integer(CUSTOMER_MANAGER_ROLE_ID), CUSTOMER_MANAGER);
    	hashtable.put(new Integer(CUSTOMER_SUPERVISOR_ROLE_ID), SUPERVISOR_MANAGER);
    	hashtable.put(new Integer(CUSTOMER_ACCOUNTANT_ROLE_ID), ACCOUNTANT_USER);
    	hashtable.put(new Integer(CUSTOMER_AUDITOR_ROLE_ID), AUDITOR_USER);
    	hashtable.put(new Integer(CUSTOMER_SALES_ROLE_ID), SALES_USER);
    	hashtable.put(new Integer(CUSTOMER_MARKETING_ROLE_ID), MARKETING_USER);
    	hashtable.put(new Integer(CUSTOMER_END_USER_ROLE_ID), END_USER);
    	hashtable.put(new Integer(CUSTOMER_RESEARCH_ROLE_ID), RESEARCH_USER);
    	
    	return hashtable;
    }
}
