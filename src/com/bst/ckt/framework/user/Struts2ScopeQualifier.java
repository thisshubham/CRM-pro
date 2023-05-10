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
 * Class Name     Struts2ScopeQualifier.java     
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
package com.bst.ckt.framework.user;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

/**
 * <p><code>Struts2ScopeQualifier</code> class help us to manage the user session
 * with below features.
 * <ul>
 * <li>Get the different session Scopes and its values using 
 * <code>getValue(String,ScopeConstants)</code></li>
 * <li>Set the objects into different session scope using 
 * <code>setValue(String, U , ScopeConstants )</code>.</li>
 * <li>Remove the object from different Session scope.</li>
 * <li>Get the Session.</li>
 * </ul></p>
 * @author Yogendra Singh Rajput
 * @version 1.0
 */
public class Struts2ScopeQualifier implements ScopeQualifier {
	@SuppressWarnings("unchecked")
	public <U> U getValue(String name, ScopeConstants scope) {
		U u = null;
		switch (scope) {
		case REQUEST_SCOPE:
			u = (U) ServletActionContext.getRequest().getAttribute(name);
			break;
		/*
		 * case FLASH_SCOPE: u = (U)externalContext.getFlash().get(name); break;
		 */
		case SESSION_SCOPE:
			u = (U) ServletActionContext.getRequest().getSession()
					.getAttribute(name);
			break;
		case APPLICATION_SCOPE:
			u = (U) ServletActionContext.getServletContext().getAttribute(name);
			break;
		default:
			break;
		}
		return u;
	}

	/**
	 * Setting the objects into different session objects with relative session constants.
	 * @param name 
	 * @param u constant value for session setting
	 * @param scope
	 */
	public <U> void setValue(String name, U u, ScopeConstants scope) {
		switch (scope) {
		case REQUEST_SCOPE:
			ServletActionContext.getRequest().setAttribute(name, u);
			break;
		/*
		 * case FLASH_SCOPE: externalContext.getFlash().put(name, u); break;
		 */
		case SESSION_SCOPE:
			ServletActionContext.getRequest().getSession()
					.setAttribute(name, u);
			break;
		case APPLICATION_SCOPE:
			ServletActionContext.getServletContext().setAttribute(name, u);
			break;
		default:
			break;
		}
	}

	/**
	 * <p>Remove the session object from given scope.</p>
	 * @param name Session key name
	 * @param scope sessin scope
	 */
	public void remove(String name, ScopeConstants scope) {
		switch (scope) {
		case REQUEST_SCOPE:
			ServletActionContext.getRequest().removeAttribute(name);
			break;
		/*
		 * case FLASH_SCOPE: externalContext.getFlash().remove(name); break;
		 */
		case SESSION_SCOPE:
			ServletActionContext.getRequest().getSession()
					.removeAttribute(name);
			break;
		case APPLICATION_SCOPE:
			ServletActionContext.getServletContext().removeAttribute(name);
			break;
		default:
			break;
		}
	}

	/**
	 * <p>Return current session </p>
	 * @return session HttpSession
	 */
	public HttpSession getSession() {
		return ServletActionContext.getRequest().getSession(false);
	}
}