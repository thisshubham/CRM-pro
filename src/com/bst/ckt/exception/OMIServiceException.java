/*
 **********************************************************************
 *
 * COPYRIGHT. $0$ 2008. ALL RIGHTS RESERVED.
 *
 * This software is only to be used for the purpose for which it has been
 * provided. No part of it is to be reproduced, disassembled, transmitted,
 * stored in a retrieval system nor translated in any human or computer
 * language in any way or for any other purposes whatsoever without the
 * prior written consent of $0$.
 * 
 * Class Name     OMIServiceException.java     
 *                                                            
 * Creation Date  8 October 2014
 * 
 * Abstract       This is Custom Exception Class.
 * 
 * Amendment History (in chronological sequence):
 * 
 **********************************************************************
 */
package com.bst.ckt.exception;

/**
 * <p>User defined Business Exception class. This is base exception which will be extended by all User defined Exceptions. 
 * This type of exception will be thrown when business rules are violated while sending the SMS.</p>
 * @author Yogendra Singh Rajput
 * @version 1.0
 */
public class OMIServiceException extends OMIApplicationException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The class constructor.
	 */
	public OMIServiceException() {
		
	}

	/**
	 * The Class Constructor.
	 * @param errorMessage		 Message to be set when exception is thrown
	 */
	public OMIServiceException(String errorMessage) {
		super(errorMessage);
	}

	/**
	 * The class constructor.
	 * @param errorCode		 Error code to be set when exception is thrown
	 * @param errorMessage	 Message to be set when exception is thrown	
	 */
	public OMIServiceException(int errorCode, String errorMessage) {
		super(errorCode, errorMessage);
	}

	/**
	 * The class constructor.
	 * @param errorMessage		 Message to be set when exception is thrown
	 * @param e					 Throwable object to be rethrown to set the cause of the exception
	 */
	public OMIServiceException(String errorMessage, Throwable e) {
		super(errorMessage, e);
	}

	/**
	 * The class constructor.
	 * @param errorCode			Error code to be set when exception is thrown
	 * @param errorMessage		message to be displayed.
	 * @param e					Throwable object to be rethrown to set the cause of the exception
	 */
	public OMIServiceException(int errorCode, String errorMessage, Throwable e) {
		super(errorCode, errorMessage, e);
	}
	
	/**
	 * @return String
	 */
	public String toString() {
		return "[" + getClass().getName() + "] - [Error Code:" + getErrorCode() + 
				" | Error Message: " + getErrorMessage() + "]";
	}
	
}
