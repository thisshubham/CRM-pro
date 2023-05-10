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
 * Class Name     RecordNotFoundException.java     
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
 * This exception will be thrown when no record returned from DataBase.</p>
 * @author Yogendra Singh Rajput
 * @version 1.0
 */
public class RecordNotFoundException extends OMIApplicationException
{
    static final long serialVersionUID = -5829545098534135052L;

   /**
     * <p>Creates a new <code>RecordNotFoundException</code> object.
     */
    public RecordNotFoundException()
    {
    	super();
    }

   /**
     * <p>Creates a new <code>RecordNotFoundException</code> object.
     *
     * @param errorMessage Message to be set when exception is thrown
     */
    public RecordNotFoundException(String errorMessage)
    {
        this.errorMessage = errorMessage;
    }

    /**
     * <p>Creates a new <code>RecordNotFoundException</code> object.
     *
     * @param errorMessage 	Message to be set when exception is thrown
     * @param t 			Throwable object to be rethrown to set the cause of the exception
     */
    public RecordNotFoundException(String errorMessage, Throwable t)
    {
        this.errorMessage = errorMessage;
        this.initCause(t);
    }

    /**
     * <p>Creates a new <code>RecordNotFoundException</code> object.
     *
     * @param errorCode 	Error code to be set when exception is thrown
     * @param errorMessage 	Message to be set when exception is thrown
     */
    public RecordNotFoundException(int errorCode, String errorMessage)
    {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    /**
     * <p>Creates a new <code>RecordNotFoundException</code> object.
     *
     * @param errorCode 	Error code to be set when exception is thrown
     * @param errorMessage 	Message to be set when exception is thrown
     * @param t 			Throwable object to be rethrown to set the cause of the exception
     */
    public RecordNotFoundException(int errorCode, String errorMessage, Throwable t)
    {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.initCause(t);
    }
}
