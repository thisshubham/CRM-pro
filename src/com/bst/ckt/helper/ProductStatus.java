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

package com.bst.ckt.helper;

import java.io.Serializable;
import java.util.HashMap;

public class ProductStatus implements Comparable<Object>, Serializable {

	/**
	 * serialVersionUID is unique id for class in project implementation.
	 */
	private static final long serialVersionUID = 8398882971118001921L;
	private int id;
	private String statusName;

	/**
	 * <p>
	 * List of ProductStatus id Constants.
	 * </p>
	 */

	public static final int ACTIVE_ID = 1;
	public static final int INACTIVE_ID = 2;
	public static final int EXPIRING_ID = 3;
	public static final int OUT_OF_STOCK_ID = 4;
	public static final int NOT_PRODUCTSTATUS_ID = 5;
	
	/**
	 * <p>
	 * List of ProductStatus Constants.
	 * </p>
	 */

	public static final String ACTIVE = "Active";
	public static final String INACTIVE = "Inactive";
	public static final String EXPIRING = "Expiring";
	public static final String OUT_OF_STOCK = "Out of Stock";
	public static final String NOT_PRODUCTSTATUS = "Not Product Status";

	public ProductStatus() {
		// nothing will do
	}

	public ProductStatus(int id) {
		this.id = id;
	}

	public ProductStatus(int id, String name) {
		this.id = id;
		this.statusName = name;
	}

	/**
	 * Compare object with ProductStatus object for equality of hashCode.
	 * 
	 * @return 0 if not equals and return 1 if both are equals.
	 */
	public int compareTo(Object obj) {

		if (this.hashCode() == obj.hashCode()) {
			return 1;
		}

		return 0;
	}

	public void setProductStatus(int id) {
		this.id = id;
	}

	public int getProductStatusId() {
		return this.id;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	/**
	 * This method will return ProductStatus Name based on productStatusId.
	 * 
	 * @param statusId
	 * @return
	 */
	public static String getAssignmentStatus(int statusId) {
		String PRODUCT_STATUS = null;

		switch (statusId) {
		case ACTIVE_ID: {
			PRODUCT_STATUS = ACTIVE;
			break;
		}
		case INACTIVE_ID: {
			PRODUCT_STATUS = INACTIVE;
			break;
		}
		case EXPIRING_ID: {
			PRODUCT_STATUS = EXPIRING  ;
			break;
		}
		case OUT_OF_STOCK_ID: {
			PRODUCT_STATUS = OUT_OF_STOCK;
			break;
		}
		
		default: {
			PRODUCT_STATUS = NOT_PRODUCTSTATUS;
		}
		}

		return PRODUCT_STATUS;
	}

	/**
	 * <p>
	 * <code>getProductStatusList</code>This method returns list of Product Status
	 * </p>
	 * 
	 * @return list of Product Status in HashMap object
	 */

	public static HashMap<Integer, String> getProductStatusList() {

		HashMap<Integer, String> hashMap = new HashMap<Integer, String>();

		hashMap.put(new Integer(ACTIVE_ID), ACTIVE);
		hashMap.put(new Integer(INACTIVE_ID), INACTIVE);
		hashMap.put(new Integer(EXPIRING_ID), EXPIRING);
		hashMap.put(new Integer(OUT_OF_STOCK_ID), OUT_OF_STOCK);
		hashMap.put(new Integer(NOT_PRODUCTSTATUS_ID), NOT_PRODUCTSTATUS);
		
		return hashMap;
	}

	/**
	 * <p>
	 * <code>getModifiedProductStatusList</code>This method returns list of Product
	 * Status for changing the Product Status.
	 * </p>
	 * 
	 * @return list of User Role in HashMap object
	 *//*
	public static HashMap<Integer, String> getModifiedProductStatusList() {
		HashMap<Integer, String> hashMap = new HashMap<Integer, String>();

		hashMap.put(new Integer(ACTIVE_ID), ACTIVE);
		hashMap.put(new Integer(INACTIVE_ID), INACTIVE);
		hashMap.put(new Integer(EXPIRING_ID), EXPIRING);
		hashMap.put(new Integer(OUT_OF_STOCK_ID), OUT_OF_STOCK);
		hashMap.put(new Integer(NOT_PRODUCTSTATUS_ID), NOT_PRODUCTSTATUS);

		return hashMap;
	}*/
}
