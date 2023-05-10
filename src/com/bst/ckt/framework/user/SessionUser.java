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
 * <p>This is Session User value object class which hold the basic details 
 * of user during the session management.</p>
 * @author Yogendra Singh Rajput
 *
 */
public class SessionUser {
	
	private int userId;
    private String salutation;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
	private int userRole;
    private int userStatus;
    private int companyId;
    private String  userRoleName;
    private String loginDateTime;
    
    
    public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
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
	 * @return the userRoleName
	 */
	public String getUserRoleName() {
		return userRoleName;
	}
	/**
	 * @param userRoleName the userRoleName to set
	 */
	public void setUserRoleName(String userRoleName) {
		this.userRoleName = userRoleName;
	}
	/**
	 * @return the loginDateTime
	 */
	public String getLoginDateTime() {
		return loginDateTime;
	}
	/**
	 * @param loginDateTime the loginDateTime to set
	 */
	public void setLoginDateTime(String loginDateTime) {
		this.loginDateTime = DateTimeUtil.getDateAndTime();
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	
}
