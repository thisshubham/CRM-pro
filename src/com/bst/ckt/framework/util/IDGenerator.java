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
 * Class Name     IDGenerator.java     
 *                                                            
 * Creation Date  OCT 4, 2014 
 * 
 * Abstract       This class is utility class to generate random number 
 *                and string.
 * 
 * Amendment History (in chronological sequence): OCT 4, 2014
 * 
 **********************************************************************
 */

package com.bst.ckt.framework.util;

import org.apache.commons.lang.RandomStringUtils;

/**
 * This class designed to generate the alphanumeric, numeric 
 * and alphabetic dynamic ID of size as required based on input.
 * @author Yogendra Singh Rajput
 *
 */
public class IDGenerator {
	
	/**
	 * This method generate Alpha Numeric Id for given size
	 * @param size int size of Id as required.
	 * @return Id value as String of given size
	 */
	public static String generateAlphaNumericID(int size){
		
		return (String)RandomStringUtils.randomAlphanumeric(size).trim();
	}
	

	/**
	 * This method generate Alphabetic Id for given size
	 * @param size int size of Id as required.
	 * @return Id value as String of given size
	 */
	public static String generateAlphabeticID(int size){
		
		return (String)RandomStringUtils.randomAlphabetic(size).trim();
	}
	
	
	/**
	 * This method generate Numeric Id for given size
	 * @param size int size of Id as required.
	 * @return Id value as String of given size
	 */
	public static String generateNumericID(int size){
		
		return (String)RandomStringUtils.randomNumeric(size).trim();
	}
}
