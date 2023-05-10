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
 * Class Name     SessionUser.java     
 *                                                            
 * Creation Date  OCT 4, 2014 
 * 
 * Abstract       This class is a Value Object class to hold the user 
 *                details during session scope.
 * 
 * Amendment History (in chronological sequence): OCT 4, 2014
 * 
 **********************************************************************
 */

package com.bst.ckt.framework.user;

import com.bst.ckt.framework.util.DateTimeUtil;

/**
 * <p>
 * This is Session User value object class which hold the basic details of user
 * during the session management.
 * </p>
 * 
 * @author Yogendra Singh Rajput
 * 
 */
public class CustomerSessionUser {

	private int customerId;
	private String salutation;
	private String fullName;
	private String email;
	private String password;
	private int userRole;
	private int userStatus;
	private int companyId;
	private String loginDateTime;
	private String loginFlag;
	private int aclId;

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getSalutation() {
		return salutation;
	}

	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getUserRole() {
		return userRole;
	}

	public void setUserRole(int userRole) {
		this.userRole = userRole;
	}

	public int getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(int userStatus) {
		this.userStatus = userStatus;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the loginDateTime
	 */
	public String getLoginDateTime() {
		return loginDateTime;
	}

	/**
	 * @param loginDateTime
	 *            the loginDateTime to set
	 */
	public void setLoginDateTime(String loginDateTime) {
		this.loginDateTime = DateTimeUtil.getDateAndTime();
	}

	/**
	 * @return the fullName
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * @param fullName
	 *            the fullName to set
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	/**
	 * @return the customerId
	 */
	public int getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId
	 *            the customerId to set
	 */
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	/**
	 * 
	 * @return customer user login flag for first time login and configuration
	 *         setting.
	 */
	public String getLoginFlag() {
		return loginFlag;
	}

	/**
	 * 
	 * @param loginFlag
	 *            flag to identified the status of logged in user for first time
	 *            loging and company configuration.
	 */
	public void setLoginFlag(String loginFlag) {
		this.loginFlag = loginFlag;
	}

	public int getAclId() {
		return aclId;
	}

	public void setAclId(int aclId) {
		this.aclId = aclId;
	}

}
