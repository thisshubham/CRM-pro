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
 * Class Name     ClearCacheInterceptor.java     
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

package com.bst.ckt.interceptor;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.StrutsStatics;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * <p>This is Clear Cache Intercepter is designed to clear 
 * pragma cache from browse before loading the page.</p>
 * @author gracious
 *
 */
public class ClearCacheInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = -8973641300553887161L;

	/**
	 * <p>This method set the pragma cache as default no-cache.</p>
	 */
	public String intercept(ActionInvocation invocation)throws Exception{
		
		/*
		 * ActionContext is the context in which the actions execute. 
		 * So it has encapsulated many behavior and properties that 
		 * represents the action execution context.
		 */
        ActionContext context=(ActionContext)invocation.getInvocationContext();
        HttpServletResponse response=(HttpServletResponse)context.get(StrutsStatics.HTTP_RESPONSE);
        
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);

        return invocation.invoke();
	}
}
