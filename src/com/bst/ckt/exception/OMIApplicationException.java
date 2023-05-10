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
 * Class Name     OMIApplicationException.java     
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
 * This will be thrown when error occurs while doing crucial operation.</p>
 * @author Yogendra Singh Rajput
 * @version 1.0
 */
public class OMIApplicationException extends Exception
{

	private static final long serialVersionUID = 1L;

	/**
     * Error message to be set
     */
    public String errorMessage;

    /**
     * Error code to be set
     */
    public int errorCode = 0;

    /**
     * <p>Creates a new <code>GSApplicationException</code> object.
     */
    public OMIApplicationException()
    {
    	super();
    }

    /**
     * <p>Creates a new <code>GSApplicationException</code> object.</p>
     *
     * @param errorMessage Error code to be set
     */
    public OMIApplicationException(String errorMessage)
    {
        this.errorMessage = errorMessage;
    }

    /**
     * <p>Creates a new <code>GSApplicationException</code> object.</p>
     *
     * @param errorCode 	error code to be set when exception is thrown
     * @param errorMessage 	Message to be set when exception is thrown
     */
    public OMIApplicationException(int errorCode, String errorMessage)
    {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    /**
     * <p>Creates a new <code>GSApplicationException</code> object.
     *
     * @param errorMessage Message to be set when exception is thrown
     * @param e exception object to be re thrown to set the cause of the exception
     */
    public OMIApplicationException(String errorMessage, Throwable e)
    {
        this.errorMessage = errorMessage;
        this.initCause(e);
    }

    /**
     * <p>Creates a new <code>GSApplicationException<code> object.</p>
     *
     * @param errorCode error code to be set when exception is thrown
     * @param errorMessage Message to be set when exception is thrown
     * @param e exception object to be rethrown to set the cause of the exception
     */
    public OMIApplicationException(int errorCode, String errorMessage, Throwable e)
    {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.initCause(e);
    }

    /**
     * <p>It is calling super class <code>initCause(Throwable)</code></p>
     *
     * @param e sets cause of the exception generated
     */
    public void setCause(Throwable e)
    {
        this.initCause(e);
    }

    /**
     * <p>This method will return the custom error message pattern.</p>
     *
     * @return toString() presentation
     */
    public String toString()
    {
        String s = getClass().getName();

        return s + ": " + errorMessage;
    }

    /**
     * <p>Method returns the Error Message</p>
     * @return the errorMessage
     */
    public String getErrorMessage()
    {
        return errorMessage;
    }

    /**
     * <p>Method help to set exception error message to our customer Exception Error Message</p>
     * 
     * @param errorMessage the errorMessage to set
     */
    public void setErrorMessage(String errorMessage)
    {
        this.errorMessage = errorMessage;
    }

    /**
     * <p>Returns the error code</p>
     * @return the errorCode
     */
    public int getErrorCode()
    {
        return errorCode;
    }

    /**
     * <p>Set Error code into our custom Exception </p>
     * @param errorCode the errorCode to set
     */
    public void setErrorCode(int errorCode)
    {
        this.errorCode = errorCode;
    }
}
