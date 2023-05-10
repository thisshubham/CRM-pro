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
 * Class Name     LoginVO.java     
 *                                                            
 * Creation Date  OCT 4, 2014 
 * 
 * Abstract       This class is a model class.
 *  
 * Amendment History (in chronological sequence): OCT 4, 2014
 * 
 **********************************************************************
 */

package com.bst.ckt.vo;

/**
 * <p>
 * <code>LoginVO</code> is a Model class which holds the login details bean
 * values for retrieving the login credentials entered by user.
 * </p>
 * 
 * @author Yogendra Singh Rajput
 * @version V1.0
 */

public class LoginVO {
	
	private int customerId;
	private String fullName;
	private String primaryEmailId;
	private String password;
	private String newPassword;
	private String reEnterPassword;
	private String language;
	private String currency;
	private String timeZone;
	private int userRole;
	private int shopId;
	
	
	

	
	
	
	/**
	 * @return the userRole
	 */
	public int getUserRole() {
		return userRole;
	}

	/**
	 * @param userRole the userRole to set
	 */
	public void setUserRole(int userRole) {
		this.userRole = userRole;
	}

	/**
	 * @return the language
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * @param language the language to set
	 */
	public void setLanguage(String language) {
		this.language = language;
	}

	/**
	 * @return the currency
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * @param currency the currency to set
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	/**
	 * @return the timeZone
	 */
	public String getTimeZone() {
		return timeZone;
	}

	/**
	 * @param timeZone the timeZone to set
	 */
	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}

	/**
	 * @return the customerId
	 */
	public int getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	/**
	 * @return the fullName
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * @param fullName the fullName to set
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	/**
	 * @return the primaryEmailId
	 */
	public String getPrimaryEmailId() {
		return primaryEmailId;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param primaryEmailId
	 *            the primaryEmailId to set
	 */
	public void setPrimaryEmailId(String primaryEmailId) {
		this.primaryEmailId = primaryEmailId;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the newPassword
	 */
	public String getNewPassword() {
		return newPassword;
	}

	/**
	 * @param newPassword the newPassword to set
	 */
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	/**
	 * @return the reEnterPassword
	 */
	public String getReEnterPassword() {
		return reEnterPassword;
	}

	/**
	 * @param reEnterPassword the reEnterPassword to set
	 */
	public void setReEnterPassword(String reEnterPassword) {
		this.reEnterPassword = reEnterPassword;
	}

	public int getShopId() {
		return shopId;
	}

	public void setShopId(int shopId) {
		this.shopId = shopId;
	}

	

}
