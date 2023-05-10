/*
 **********************************************************************
 *
 * COPYRIGHT. $ID$ 2015. ALL RIGHTS RESERVED.
 *
 * This software is only to be used for the purpose for which it has been
 * provided. No part of it is to be reproduced, disassembled, transmitted,
 * stored in a retrieval system nor translated in any human or computer
 * language in any way or for any other purposes whatsoever without the
 * prior written consent of $ID$.
 * 
 * Class Name     AccountType.java     
 *                                                            
 * Creation Date  DECM 23, 2015 
 * 
 * Abstract       This class is utility class for Account Type in project.
 * 
 * Amendment History (in chronological sequence): DECM 23, 2015
 * 
 **********************************************************************
 */

package com.bst.ckt.helper;

import java.io.Serializable;
import java.util.HashMap;

import com.itextpdf.text.pdf.XfaForm.InverseStore;

/**
 * @author shaikh
 *
 */

public class AccountType implements Comparable<Object>, Serializable {

	/**
	 * Compare object with AccountType object for equality of hashCode.
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

	private int id;
	private String type;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	public AccountType() {
		// will do nothing
	}

	public AccountType(int id) {
		this.id = id;
	}

	public AccountType(String type) {
		this.type = type;
	}

	public AccountType(int id, String type) {
		this.type = type;
		this.id = id;
	}

	/**
	 * <p>
	 * List of account type id constraints
	 * </p>
	 */
	public static final int ANALYST_ID = 1;
	public static final int COMPETITOR_ID = 2;
	public static final int CUSTOMRE_ID = 3;
	public static final int DISTRIBUTOR_ID = 4;
	public static final int INTEGRATOR_ID = 5;
	public static final int INVESTOR_ID = 6;
	public static final int OTHER_ID = 7;
	public static final int PARTNER_ID = 8;
	public static final int PRESS_ID = 9;
	public static final int PROSPECT_ID = 10;
	public static final int RESELLER_ID = 11;
	public static final int SUPPLIER_ID = 12;
	public static final int VENDOR_ID = 13;

	/**
	 * <p>
	 * List of account type constraints
	 * </p>
	 */
	public static final String ANALYST = "Analyst";
	public static final String COMPETITOR = "Competitor";
	public static final String CUSTOMRE = "Customer";
	public static final String DISTRIBUTOR = "Distributor";
	public static final String INTEGRATOR = "Integrator";
	public static final String INVESTOR = "Investor";
	public static final String OTHER = "Other";
	public static final String PARTNER = "Partner";
	public static final String PRESS = "Press";
	public static final String PROSPECT = "Prospect";
	public static final String RESELLER = "Reseller";
	public static final String SUPPLIER = "Supplier";
	public static final String VENDOR = "Vendor";

	/**
	 * <p>
	 * <code>getAccountType()</code>this method is design to get account type
	 * based on the id.
	 * </p>
	 * 
	 */

	public static String getAccountType(int id) throws Exception {
		String ACCOUNTYPEVALUE = null;

		switch (id) {

		case ANALYST_ID:
			ACCOUNTYPEVALUE = ANALYST;
			break;

		case COMPETITOR_ID:
			ACCOUNTYPEVALUE = COMPETITOR;
			break;
		case CUSTOMRE_ID:
			ACCOUNTYPEVALUE = CUSTOMRE;
			break;
		case DISTRIBUTOR_ID:
			ACCOUNTYPEVALUE = DISTRIBUTOR;
			break;
		case INTEGRATOR_ID:
			ACCOUNTYPEVALUE = INTEGRATOR;
			break;
		case INVESTOR_ID:
			ACCOUNTYPEVALUE = INVESTOR;
			break;
		case PARTNER_ID:
			ACCOUNTYPEVALUE = PARTNER;
			break;
		case PRESS_ID:
			ACCOUNTYPEVALUE = PRESS;
			break;
		case RESELLER_ID:
			ACCOUNTYPEVALUE = RESELLER;
			break;
		case PROSPECT_ID:
			ACCOUNTYPEVALUE = PROSPECT;
			break;
		case SUPPLIER_ID:
			ACCOUNTYPEVALUE = SUPPLIER;
			break;
		case VENDOR_ID:
			ACCOUNTYPEVALUE = VENDOR;
			break;
		case OTHER_ID:
			ACCOUNTYPEVALUE = OTHER;
			break;
		}

		return ACCOUNTYPEVALUE;
	}
	
	
	

	/*
	 * Analyst Competitor Customer Distributor Integrator Investor Partner Press
	 * Prospect Reseller Supplier Vendor Other
	 */
	
	/**
	 * <p>
	 * <code>getAccountType()</code>this method is design to get account type
	 * based on the id.
	 * </p>
	 * 
	 */
	
	public static HashMap<Integer, String> getAccountTypeList()throws Exception
	{
		HashMap<Integer, String> accountTypeList=new HashMap<Integer, String>();
		
		accountTypeList.put(new Integer(ANALYST_ID), ANALYST);
		accountTypeList.put(new Integer(COMPETITOR_ID), COMPETITOR);
		accountTypeList.put(new Integer(CUSTOMRE_ID), CUSTOMRE);
		accountTypeList.put(new Integer(DISTRIBUTOR_ID), DISTRIBUTOR);
		accountTypeList.put(new Integer(INTEGRATOR_ID), INTEGRATOR);
		accountTypeList.put(new Integer(INVESTOR_ID), INVESTOR);
		accountTypeList.put(new Integer(OTHER_ID), OTHER);
		accountTypeList.put(new Integer(PARTNER_ID), PARTNER);
		accountTypeList.put(new Integer(PRESS_ID), PRESS);
		accountTypeList.put(new Integer(PROSPECT_ID), PROSPECT);
		accountTypeList.put(new Integer(RESELLER_ID), RESELLER);
		accountTypeList.put(new Integer(SUPPLIER_ID), SUPPLIER);
		accountTypeList.put(new Integer(VENDOR_ID), VENDOR);
		
	
		return accountTypeList;
	}

}
