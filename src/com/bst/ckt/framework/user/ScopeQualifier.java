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
 * Class Name     ScopeQualifier.java     
 *                                                            
 * Creation Date  OCT 4, 2014 
 * 
 * Abstract       This interface has declare the session related method to 
 *                manage the session scope and session objects.
 * 
 * Amendment History (in chronological sequence): OCT 4, 2014
 * 
 **********************************************************************
 */
package com.bst.ckt.framework.user;

import javax.servlet.http.HttpSession;

/**
 * <p><code>ScopeQualifier</code> interface has declare the session related method to 
 *  manage the session scope and session objects.
 * <ul></p>
 * @author Yogendra Singh Rajput
 * @version 1.0
 */
public interface ScopeQualifier {
	
	/**
	 * Get the session scope based on Constant
	 * @param name session key name
	 * @param scope session scope
	 * @return U constant
	 */
	public <U> U getValue(String name, ScopeConstants scope);
	
	/**
	 * Setting the objects into different session objects with relative session constants.
	 * @param name 
	 * @param u constant value for session setting
	 * @param scope
	 */
	public <U> void setValue(String name, U u, ScopeConstants scope);

	/**
	 * <p>Remove the session object from given scope.</p>
	 * @param name Session key name
	 * @param scope sessin scope
	 */
	public void remove(String name, ScopeConstants scope);

	/**
	 * <p>Return current session </p>
	 * @return session HttpSession
	 */
	public HttpSession getSession();
}