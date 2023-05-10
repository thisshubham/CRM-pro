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
 * Class Name     ExceptionHandlerMapper.java     
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

import java.io.IOException;
import java.io.InputStream;

import java.util.Properties;

/**
 * Loads mapping for exception handler and throws exception.  
 */

public class ExceptionHandlerMapper
{
    /**
     * Instance of ExceptionHandlerMapper
     */
    private static final ExceptionHandlerMapper exceptionMapper = new ExceptionHandlerMapper();

    /**
     * Contains all <code>properties</code> in a Properties instance
     */
    private Properties properties;

    /**
     * Creates an ExceptionHandlerMapper instance.
     */
    private ExceptionHandlerMapper()
    {
        properties = new Properties();

        InputStream stream = ExceptionHandlerMapper.class.getResourceAsStream("/com/omerai/exception/exceptionhandler.properties");

        if (stream == null)
        {
            throw new IllegalArgumentException("Could not load exceptionhandler.properties. Please make sure that it is in CLASSPATH.");
        }

        try
        {
            properties.load(stream);
        }
        catch (IOException e)
        {
            IllegalStateException ex = new IllegalStateException("An error occurred when reading from the input stream");
            ex.initCause(e);
            throw ex;
        }
        finally
        {
            try
            {
                stream.close();
            }
            catch (IOException e)
            {
                IllegalStateException ex = new IllegalStateException("An I/O error occured while closing the stream");
                ex.initCause(e);
                throw ex;
            }
        }
    }

    /**
     * Gets the instance of <code>ExceptionHandlerMapper</code>.
     *
     * @return instance of ExceptionHandlerMapper
     */
    public static ExceptionHandlerMapper getInstance()
    {
        return exceptionMapper;
    }

    /**
     * Gets the value of a property based on key provided.
     *
     * @param key The key for which value needs to be retrieved from
     *
     * @return The value for the key in <code>exceptionhandler.properties</code>. Returns
     *         null if the value does not exist in the property file.
     */
    public String get(String key)
    {
        if ((properties == null) || (key == null))
        {
            return null;
        }

        return (String) properties.get(key);
    }
}
