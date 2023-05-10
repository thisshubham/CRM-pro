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
 * Class Name     DBException.java     
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

import com.bst.ckt.exception.OMIApplicationException;

/**
 * <p>User defined Exception class. This is base exception which will be extended by all User defined Exceptions. 
 * This will be thrown when error occurs while doing crucial operation with database.</p>
 * @author Yogendra Singh Rajput
 * @version 1.0
 */
public class DBException extends OMIApplicationException
{
	
	private static final long serialVersionUID = -5829545098534135052L;
    
	/**
	 * <p>Constructor for class</p>
	 *
	 */
	public DBException() 
	{
		
	}
	/**
	 * <p>Parameterized constructor</p>
	 * @param exceptionMessage msg to be passed
	 */
	public DBException(String exceptionMessage) 
	{
		this.errorMessage = exceptionMessage;
	}
	
	/**
	 * <p>Parameterized constructor</p>
	 * @param exceptionMessage msg to be passed
	 * @param t throwable exception class
	 */
	public DBException(String exceptionMessage,Throwable t)
	{
		this.errorMessage = exceptionMessage;
		this.initCause(t);
	}
	
	/**
	 * <p>Parameterized constructor</p>
	 * @param errorCode code for exception
	 * @param exceptionMessage msg for exception
	 */
	public DBException(int errorCode, String exceptionMessage)
	{
		this.errorCode = errorCode;
		this.errorMessage = exceptionMessage;
	}
	
	/**
	 * <p>Parameterized constructor</p>
	 * @param errorCode
	 * @param exceptionMessage
	 * @param t throwable exception class
	 */
	public DBException(int errorCode, String exceptionMessage,Throwable t)
	{
		this.errorCode = errorCode;
		this.errorMessage = exceptionMessage;
		this.initCause(t);
	}
	
}
