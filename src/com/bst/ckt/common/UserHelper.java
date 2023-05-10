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
 * Class Name     UserHelper.java     
 *                                                            
 * Creation Date  OCT 4, 2014 
 * 
 * Abstract       This class is utility class for user login, logout and 
 * 				  session related activities.
 * 
 * Amendment History (in chronological sequence): OCT 4, 2014
 * 
 **********************************************************************
 */

package com.bst.ckt.common;

import com.bst.ckt.dto.Customer;
import com.bst.ckt.framework.user.CustomerSessionUser;
import com.bst.ckt.framework.util.DateTimeUtil;

/**
 * <p>This class is Session User Helper class which add the user 
 * properties into Session Object.</p>
 * @author Yogendra Singh Rajput
 * @version 1.0
 */
public class UserHelper {
	
	public static CustomerSessionUser getCustomerSessionUser(Customer customer)
	{
		
		CustomerSessionUser sessionUser = new CustomerSessionUser();
		// This code is not append into Demo 
		/*try {
			sessionUser.setPassword(new Digest("SHA-512").doEncypt(userDetailsDTO.getPassword()));
		} catch (NoSuchAlgorithmException e) {

			e.printStackTrace();
		}*/
		sessionUser.setEmail(customer.getPrimaryEmailId());
		sessionUser.setPassword(customer.getPassword());
		sessionUser.setFullName(customer.getFullName());
		sessionUser.setSalutation(customer.getSalutation());
		sessionUser.setCustomerId(customer.getCustomerId());
		sessionUser.setUserRole(customer.getUserRole());
		sessionUser.setUserStatus(customer.getUserStatus());
		sessionUser.setCompanyId(customer.getRefCompany());
		sessionUser.setLoginDateTime(DateTimeUtil.getDateAndTime());
		sessionUser.setLoginFlag(customer.getLoginFlag());
		sessionUser.setAclId(customer.getAclId());
		return sessionUser;
		
	}

}
