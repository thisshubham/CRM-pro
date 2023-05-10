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
 * Interface Name     IExceptionHandler.java     
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
 * Exception handler. All classes implementing this interface will handle the exception thrown.
 * @author Yogendra Singh Rajput
 * @version 1.0
 */
public interface IExceptionHandler 
{
 
    /**
     * This method handles the exception.
     * @param omiException		reference to the exception.
     */
    public void handleException(OMIApplicationException omiException);
}