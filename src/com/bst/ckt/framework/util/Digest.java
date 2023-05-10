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
 * Class Name     Digest.java     
 *                                                            
 * Creation Date  OCT 4, 2014 
 * 
 * Abstract       This class is utility class for encrypt the Stirng input.
 * 
 * Amendment History (in chronological sequence): OCT 4, 2014
 * 
 **********************************************************************
 */

package com.bst.ckt.framework.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * <p>This class is data encryption class.</p>
 * @author Yogendr Singh Rajput
 * @version 1.0
 */
public class Digest {
	private String algorithm;

	public Digest(String algorithm) {
		this.algorithm = algorithm;
	}

	/**
	 * <p>This class convert simple String message to encrypted form for data security.</p>
	 * @param message
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	public String doEncrypt(String message) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance(algorithm);
		byte[] dataBytes = message.getBytes();
		md.update(dataBytes, 0, dataBytes.length);
		byte[] mdbytes = md.digest();
		// convert the byte to hex format
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < mdbytes.length; i++) {
			sb.append(Integer.toString((mdbytes[i] & 0xff) + 0x100, 16)
					.substring(1));
		}
		return sb.toString();
	}
}