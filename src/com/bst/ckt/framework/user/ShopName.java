package com.bst.ckt.framework.user;

import java.util.Hashtable;

public class ShopName {

	
	private int id;
	private String userRole;
	
    /**
	 * <p>List of UserRole id Constants.</p>
	 */
	/*public static final int SUPER_ADMIN_ROLE_ID=1;	
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
	public static final int CUSTOMER_RESEARCH_ROLE_ID =12;*/
	
	
	public static final int ROHIT_TRADERS_ID=1;	
	public static final int KALAA_TRADERS_ID=2;	
	public static final int RAHUL_TRADERS_ID=3;
	public static final int VARSHA_TRADERS_ID=4;
	
    /**
	 * <p>List of UserRole Constants.</p>
	 */
	/*public static final String SUPER_ADMIN="Super Admin";	
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
	public static final String NOT_AN_USER_ROLE = "NotAnUserRole";*/
	
	
	public static final String ROHIT_TRADERS="Rohit Traders";	
	public static final String KALAA_TRADERS="Kalaa Traders";	
	public static final String RAHUL_TRADERS="Rahul Traders";
	public static final String VARSHA_TRADERS="Varsha Traders";
	public static final String NOT_AN_USER_ROLE = "NotAnUserRole";
	
	public ShopName() {
        // nothing will do
    }

    public ShopName(int id) {
        this.id = id;
    }

    public ShopName(int id, String name) {
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
    public static String getShopName(int shopId) {
        String SHOP_NAME = null;

        switch (shopId) {
        case ROHIT_TRADERS_ID: {
        	SHOP_NAME = ROHIT_TRADERS;
            break;
        }
        case KALAA_TRADERS_ID: {
        	SHOP_NAME = KALAA_TRADERS;
            break;
        }
        case RAHUL_TRADERS_ID: {
        	SHOP_NAME = RAHUL_TRADERS;
            break;
        }
        case VARSHA_TRADERS_ID: {
        	SHOP_NAME = VARSHA_TRADERS;
            break;
        }
        
        default: {
        	SHOP_NAME = NOT_AN_USER_ROLE;
        }
        }
        
        return SHOP_NAME;
    }
    
    /**
     * <p>This method returns list of User Roles</p>
     * @return list of User Role in HashTable object
     */
    public static Hashtable<Integer, String> getShopNameList()
    {

    	Hashtable<Integer, String> hashtable = new Hashtable<Integer, String>();
    	hashtable.put(new Integer(ROHIT_TRADERS_ID), ROHIT_TRADERS);
    	hashtable.put(new Integer(KALAA_TRADERS_ID), KALAA_TRADERS);
    	hashtable.put(new Integer(RAHUL_TRADERS_ID), RAHUL_TRADERS);
    	hashtable.put(new Integer(VARSHA_TRADERS_ID), VARSHA_TRADERS);
    	
    	
    	return hashtable;
    }

    /**
     * <p>This method returns list of User Roles who does not have admin access into the project.</p>
     * @return list of User Role in HashTable object
     */
    public static Hashtable<Integer, String> getCreateShopNameList()
    {
    	Hashtable<Integer, String> hashtable = new Hashtable<Integer, String>();
    	hashtable.put(new Integer(ROHIT_TRADERS_ID), ROHIT_TRADERS);
    	hashtable.put(new Integer(KALAA_TRADERS_ID), KALAA_TRADERS);
    	hashtable.put(new Integer(RAHUL_TRADERS_ID), RAHUL_TRADERS);
    	hashtable.put(new Integer(VARSHA_TRADERS_ID), VARSHA_TRADERS);
    	
    	
    	return hashtable;
    }
}
