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
 * Class Name     ScopeConstants.java     
 *                                                            
 * Creation Date  OCT 4, 2014 
 * 
 * Abstract       This constant class is declare the different session scope.
 * 
 * Amendment History (in chronological sequence): OCT 4, 2014
 * 
 **********************************************************************
 */
package com.bst.ckt.framework.user;

/**
 * <p><code>ScopeConstants</code> enum has declare with possible session scope list.
 * <ul>
 * <li><code>REQUEST_SCOPE</code> HttpServletRequest request scope</li>
 * <li><code>FLASH_SCOPE</code> Flash Scope</li>
 * <li><code>SESSION_SCOPE</code>HTTPSession session</li>
 * <li><code>APPLICATION_SCOPE</code>ServletContext application</li>
 * </ul></p>
 * @author Yogendra Singh Rajput
 * @version 1.0
 */
public enum ScopeConstants {
	REQUEST_SCOPE, FLASH_SCOPE, SESSION_SCOPE, APPLICATION_SCOPE
}