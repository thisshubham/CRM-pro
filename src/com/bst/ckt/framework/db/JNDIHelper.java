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
 * Class Name     JNDIHelper.java     
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

package com.bst.ckt.framework.db;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.log4j.Logger;


/**
 * <p><code>JNDIHelper</code> class help to create 
 * and get the context object and its binding.</p>
 * @author Yogendra Singh Rajput
 * @version 1.0
 */
public class JNDIHelper {

	/*
	 * Creating Logger object,
	 * logger object mapped with JNDIHelper class for writing Loggers.
	 */
	private static final Logger logger = Logger.getLogger(JNDIHelper.class);
	
	/**
	 * <p>This token keep object binding prefix.</p>
	 */
	public static final String Resource_Ref_Prefix="java:comp/env";
	
	/**
	 * <p>This method lookup the binding Jndi object from context and return it.
	 * @param jndiName Actual name of bind object
	 * @return Object The bind object into contect for Datasource
	 * @throws NamingException 
	 */
	public static Object lookup(String jndiName) throws NamingException{
		Object object=null;
		Context context;
		try{
			context=new InitialContext();
			object=context.lookup(Resource_Ref_Prefix+"/"+jndiName);
		}
		catch(Exception exception){
			
			logger.error("Fail to lookup Datasource binding object from context.", exception);
		} 
		return object;
	}
}
