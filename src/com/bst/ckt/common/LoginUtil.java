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
 * Class Name     LoginUtil.java     
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

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.bst.ckt.dto.Customer;
import com.bst.ckt.framework.user.CustomerSessionUser;
import com.bst.ckt.framework.user.ScopeConstants;
import com.bst.ckt.framework.user.SessionUser;
import com.bst.ckt.framework.user.Struts2ScopeQualifier;
import com.bst.ckt.framework.user.UserRole;
import com.bst.ckt.framework.user.UserStatus;
import com.bst.ckt.service.CustomerServiceImpl;
import com.bst.ckt.service.CustomerServiceInf;
import com.bst.ckt.vo.LoginVO;

/**
 * <p>
 * <code>LoginUtil</code> class help us to verify the user credentials for user
 * login and also supports below features as well.
 * <ul>
 * <li>User credentials verification if verified returns <code>True</code></li>
 * <li>User role verify using
 * <code>userHasRole(SessionUser user, String roleName)</code>.</li>
 * <li>Setting current User into Session.</li>
 * <li>Retrieve the current session user from session.</li>
 * <li>Verify is current user logged in or session has expired.</li>
 * <li>Logged out user with help of <code>logout()</code>.</li>
 * </ul>
 * </p>
 * 
 * @author Yogendra Singh Rajput
 * @version 1.0
 */
public class LoginUtil {

	/*
	 * Creating Logger object, logger object mapped with LoginUtil class for
	 * writing Loggers.
	 */
	private static final Logger logger = Logger.getLogger(LoginUtil.class);

	/**
	 * <p>
	 * <code>CURRENT_USER_SESSION_KEY</code> is use to set and get the session
	 * user into session who is employee of admin module.
	 */
	public static final String CURRENT_USER_SESSION_KEY = "sessionUser";

	/**
	 * <p>
	 * <code>CURRENT_USER_SESSION_KEY</code> is use to set and get the session
	 * user into session.
	 */
	public static final String CURRENT_CUSTOMER_USER_SESSION_KEY = "sessionCustomerUser";

	/**
	 * <p>
	 * <code>CURRENT_LANGUAGE_SESSION_KEY</code> is use to set and get the
	 * language for i18n.
	 */
	public static final String CURRENT_LANGUAGE_SESSION_KEY = "currentLanguage";

	/**
	 * <p>
	 * <code>PROCESS_USER_SESSION_KEY</code> is use to set process userId for
	 * view, Edit and Delete operation on User Management.
	 */
	public static final String PROCESS_USER_SESSION_KEY = "processUserId";

	/**
	 * <p>
	 * <code>PROCESS_USER_SESSION_KEY</code> is use to set process userGuidId
	 * for view, Edit and Delete operation on User Management.
	 */
	public static final String PROCESS_USER_SESSION_GUID_KEY = "processUserGuidId";

	/**
	 * login method call the verifyUserCredentials service for verifying the
	 * logged user email with their credentials. If it is verified then set this
	 * user details into session current User as SessionCustomerUser.
	 * 
	 * @param loginVO
	 * @return boolean login credentials verified return true else false
	 */
	public static String customerLogin(LoginVO loginVO) throws Exception {

		try {
			CustomerServiceInf customerServiceInf = new CustomerServiceImpl();
			// Calling verifyUserCredentials(String, String) for verify the
			// login credentials, It will return Customer.
			Customer customer = customerServiceInf
					.verifyCustomerUserCredentials(loginVO.getPrimaryEmailId());

			
			/*
			 * If UserDetailsDTO is not null, setting SessionUser object into
			 * current Session. and return true for login method.
			 */
			if (customer != null) {

				if (customer.getPrimaryEmailId().equals(
						loginVO.getPrimaryEmailId())
						&& customer.getPassword().equals(loginVO.getPassword()) ) {
					if (customer.getUserStatus() == UserStatus.ACTIVE_ID) {
System.out.println("hey hey bharti u r active ");
						setCurrentCustomerUser(UserHelper
								.getCustomerSessionUser(customer));
						System.out.println("hey hey bharti u r active yes yes");
						logger.info("User is verified from database and available into new session.");
						return OMIConstants.TARGET_USER_VERIFIED;

					} else if (customer.getUserStatus() == UserStatus.SUSPENDED_ID) {

						logger.info("User is verified from database but Status is suspended.");
						return OMIConstants.TARGET_USER_SUSPENDED;

					} else if (customer.getUserStatus() == UserStatus.INACTIVE_ID) {
						logger.info("User is verified from database but Status is inactive.Pleaes see above loggers.");
						return OMIConstants.TARGET_USER_INACTIVE;

					} else if (customer.getUserStatus() == UserStatus.DELETED_ID) {
						logger.info("User is verified from database but Status is deleted.Pleaes see above loggers.");
						return OMIConstants.TARGET_USER_DELETED;

					} else if (customer.getUserStatus() == UserStatus.REGISTERED_ID) {
						logger.info("User is verified from database but Status is regisered.Pleaes see above loggers.");
						return OMIConstants.TARGET_USER_REGISTERED;

					} else if (customer.getUserStatus() == UserStatus.SUBMITTED_ID) {
						logger.info("User is verified from database but Status is submitted.Pleaes see above loggers.");
						return OMIConstants.TARGET_USER_SUBMITTED;

					}
				} else if (customer.getPrimaryEmailId().equals(
						loginVO.getPrimaryEmailId())
						&& customer.getPassword() != loginVO.getPassword()) {
					logger.info("Customer User Password is not correct.");
					return OMIConstants.TARGET_USER_PASSWORD_NOT_CORRECT;
				} else if (customer.getPrimaryEmailId() != loginVO
						.getPrimaryEmailId()
						&& customer.getPassword().equals(loginVO.getPassword())) {
					
					logger.info("Customer User  Email ID is not correct.");
					return OMIConstants.TARGET_USER_PRIMARY_EMAIL_ID_NOT_CORRECT;

				}
				else{
					logger.info("Customer User Email ID & password is not correct.");
					return OMIConstants.TARGET_USER_PASSWORD_AND_EMAIL_NOT_CORRECT;
				}
			}
		} catch (Exception exception) {

			logger.error("Customer User credential not verified from database",
					exception);
			return OMIConstants.TARGET_USER_NOT_VERIFIED;
		}

		return OMIConstants.TARGET_USER_NOT_VERIFIED;
	}

	/**
	 * <p>
	 * <code> getLoginFlag() </code> method will return the
	 * <code>LOGIN_FLAG_TARGET</code> based on logged in user
	 * <code>LOGIN_FLAG</code>
	 * </p>
	 * 
	 * @param loginFlag
	 *            String
	 * @return target String
	 */
	public static String getLoginFlag(String loginFlag) {

		if (OMIConstants.LOGIN_FLAG_FTL.equals(loginFlag)) {
			return OMIConstants.TARGET_USER_LOGIN_FIRST;
		} else if (OMIConstants.LOGIN_FLAG_PVC.equals(loginFlag)) {
			return OMIConstants.TARGET_FIRST_LOGIN_PASSWORD_CHANGED;
		} else {
			return OMIConstants.TARGET_CONFIGURATION_SETTING_SAVE;
		}

	}

	/**
	 * <p>
	 * It will verify with user role of logged in user.
	 * </p>
	 * 
	 * @param user
	 * @param roleName
	 * @return true if user role match with logged in user.
	 */
	public static boolean userHasRole(SessionUser user, String roleName) {
		if (roleName == null)
			return false;
		if (UserRole.getUserRole(user.getUserRole()).toString()
				.equals(roleName))
			return true;
		return false;
	}

	/**
	 * <p>
	 * Setting logged in user into session object with key
	 * <code>CURRENT_USER_SESSION_KEY</code>
	 * </p>
	 * 
	 * @param user
	 * @see Struts2ScopeQualifier#setValue(String, Object, ScopeConstants)
	 */
	public static void setCurrentUser(SessionUser user) {
		new Struts2ScopeQualifier().setValue(CURRENT_USER_SESSION_KEY, user,
				ScopeConstants.SESSION_SCOPE);
	}

	/**
	 * <p>
	 * Setting logged in customer user into session object with key
	 * <code>CURRENT_CUSTOMER_USER_SESSION_KEY</code>
	 * </p>
	 * 
	 * @param customerUser
	 * @see Struts2ScopeQualifier#setValue(String, Object, ScopeConstants)
	 */
	public static void setCurrentCustomerUser(CustomerSessionUser customerUser) {
		new Struts2ScopeQualifier().setValue(CURRENT_CUSTOMER_USER_SESSION_KEY,
				customerUser, ScopeConstants.SESSION_SCOPE);
	}

	/**
	 * <p>
	 * Setting process userId into session object with key
	 * <code>PROCESS_USER_SESSION_KEY</code>
	 * </p>
	 * 
	 * @param user
	 * @see Struts2ScopeQualifier#setValue(String, Object, ScopeConstants)
	 */
	public static void setProcessUserId(int porocessUserId) {
		new Struts2ScopeQualifier().setValue(PROCESS_USER_SESSION_KEY,
				porocessUserId, ScopeConstants.SESSION_SCOPE);
	}

	
	public static void setTransanctionId(int transactionId) {
		new Struts2ScopeQualifier().setValue(PROCESS_USER_SESSION_KEY,
				transactionId, ScopeConstants.SESSION_SCOPE);
	}
	/**
	 * <p>
	 * Setting process userGuidId into session object with key
	 * <code>PROCESS_USER_SESSION_KEY</code>
	 * </p>
	 * 
	 * @param user
	 * @see Struts2ScopeQualifier#setValue(String, Object, ScopeConstants)
	 */
	public static void setProcessUserGuidId(String porocessUserGuidId) {
		new Struts2ScopeQualifier().setValue(PROCESS_USER_SESSION_KEY,
				porocessUserGuidId, ScopeConstants.SESSION_SCOPE);
	}

	/**
	 * <p>
	 * Getting logged in user from session object with key
	 * <code>CURRENT_USER_SESSION_KEY</code>
	 * </p>
	 * 
	 * @return sessionUser
	 * @see Struts2ScopeQualifier#getValue(String, ScopeConstants)
	 */
	public static SessionUser getCurrentUser() {
		return new Struts2ScopeQualifier().getValue(CURRENT_USER_SESSION_KEY,
				ScopeConstants.SESSION_SCOPE);
	}

	/**
	 * <p>
	 * Getting logged in user from session object with key
	 * <code>CURRENT_CUSTOMER_USER_SESSION_KEY</code>
	 * </p>
	 * 
	 * @return sessionUser
	 * @see Struts2ScopeQualifier#getValue(String, ScopeConstants)
	 */
	public static CustomerSessionUser getCurrentCustomerUser() {
		return new Struts2ScopeQualifier()
				.getValue(CURRENT_CUSTOMER_USER_SESSION_KEY,
						ScopeConstants.SESSION_SCOPE);
	}

	/**
	 * <p>
	 * Getting process userId from session object with key
	 * <code>PROCESS_USER_SESSION_KEY</code>
	 * </p>
	 * 
	 * @return porocessUserId int
	 * @see Struts2ScopeQualifier#getValue(String, ScopeConstants)
	 */
	public static int getProcessUserId() {
		return new Struts2ScopeQualifier().getValue(PROCESS_USER_SESSION_KEY,
				ScopeConstants.SESSION_SCOPE);
	}
	
	public static int getTransactionId() {
		return new Struts2ScopeQualifier().getValue(PROCESS_USER_SESSION_KEY,
				ScopeConstants.SESSION_SCOPE);
	}

	/**
	 * <p>
	 * Getting process userGuidId from session object with key
	 * <code>PROCESS_USER_SESSION_KEY</code>
	 * </p>
	 * 
	 * @return porocessUserGuidId int
	 * @see Struts2ScopeQualifier#getValue(String, ScopeConstants)
	 */
	public static String getProcessUserGuidId() {
		return new Struts2ScopeQualifier().getValue(PROCESS_USER_SESSION_KEY,
				ScopeConstants.SESSION_SCOPE);
	}

	/**
	 * <p>
	 * Verifying logged in user still available on current session with key
	 * <code>CURRENT_USER_SESSION_KEY</code>. If user is available into the
	 * session then returns <code>true</code>
	 * </p>
	 * 
	 * @return sessionUser
	 * @see Struts2ScopeQualifier#getValue(String, ScopeConstants)
	 */
	public static boolean isLogged() {
		SessionUser user = new Struts2ScopeQualifier().getValue(
				CURRENT_USER_SESSION_KEY, ScopeConstants.SESSION_SCOPE);

		return (user == null ? false : true);
	}

	/**
	 * <p>
	 * Verifying logged in customer user still available on current session with
	 * key <code>CURRENT_CUSTOMER_USER_SESSION_KEY</code>. If user is available
	 * into the session then returns <code>true</code>
	 * </p>
	 * 
	 * @return customerSessionUser
	 * @see Struts2ScopeQualifier#getValue(String, ScopeConstants)
	 */
	public static boolean isCustomerUserLogged() {
		CustomerSessionUser customerSessionUser = new Struts2ScopeQualifier()
				.getValue(CURRENT_CUSTOMER_USER_SESSION_KEY,
						ScopeConstants.SESSION_SCOPE);

		return (customerSessionUser == null ? false : true);
	}

	/**
	 * <p>
	 * Removing the logged in user from session
	 * </p>
	 */
	public static void logout() {
		new Struts2ScopeQualifier().remove(CURRENT_USER_SESSION_KEY,
				ScopeConstants.SESSION_SCOPE);
	}

	/**
	 * <p>
	 * Removing all session objects for logged in user from session
	 * </p>
	 */
	public static void logoutCustomerUser() throws Exception {
		new Struts2ScopeQualifier().remove(CURRENT_USER_SESSION_KEY,
				ScopeConstants.SESSION_SCOPE);

	}

	/**
	 * <p>
	 * Method <code>getIPAddress</code> is return the client user IP Address,
	 * where current user is logged in.
	 * 
	 * @return userIpAddress String
	 */
	public static String getIPAddress() {

		HttpServletRequest httpServletRequest = ServletActionContext
				.getRequest();

		// Getting the IP address of Proxy
		String userIpAddress = httpServletRequest.getHeader("X-Forwarded-For");

		if (userIpAddress == null) {
			/*
			 * fail to get IP address from Proxy the trying to get it from
			 * Remote Machine as client machine.
			 */

			userIpAddress = httpServletRequest.getRemoteAddr();
		}
		return userIpAddress;
	}

}