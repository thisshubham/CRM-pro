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
 * Class Name     RecordAlreadyExistsException.java     
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
 * <p>User defined Exception class. This is base exception which will be extended by all User defined Exceptions. 
 * This will be thrown when error occurs while inserting record and record is already in database.</p>
 * @author Yogendra Singh Rajput
 * @version 1.0
 */

public class RecordAlreadyExistsException extends OMIApplicationException {


	private static final long serialVersionUID = 3867361316393146477L;

	/**
     * <p>Creates a new <code>RecordAlreadyExistsException</code> object.
     */
    public RecordAlreadyExistsException()
    {
    	super();
    }

    /**
     * <p>Creates a new <code>RecordAlreadyExistsException</code> object.
     * @param errorMessage Error code to be set
     */
    public RecordAlreadyExistsException(String errorMessage)
    {
        this.errorMessage = errorMessage;
    }

    /**
     * <p>Creates a new <code>RecordAlreadyExistsException</code> object.
     * @param errorMessage Message to be set when exception is thrown
     * @param t exception object to be re thrown to set the cause of the exception
     */
    public RecordAlreadyExistsException(String errorMessage, Throwable t)
    {
        this.errorMessage = errorMessage;
        this.initCause(t);
    }

    /**
     * <p>Creates a new <code>RecordAlreadyExistsException</code> object.
     * @param errorCode 	error code to be set when exception is thrown
     * @param errorMessage 	Message to be set when exception is thrown
     */
    public RecordAlreadyExistsException(int errorCode, String errorMessage)
    {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    /**
     * <p>Creates a new <code>RecordAlreadyExistsException</code> object.
     * @param errorCode error code to be set when exception is thrown
     * @param errorMessage Message to be set when exception is thrown
     * @param t exception object to be re thrown to set the cause of the exception
     */
    public RecordAlreadyExistsException(int errorCode, String errorMessage, Throwable t)
    {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.initCause(t);
    }
}
