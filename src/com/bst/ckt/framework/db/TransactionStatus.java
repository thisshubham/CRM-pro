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
 * Class Name     TransactionStatus.java     
 *                                                            
 * Creation Date  OCT 4, 2014 
 * 
 * Abstract       This class check the transaction status.
 * 
 * Amendment History (in chronological sequence): OCT 4, 2014
 * 
 **********************************************************************
 */

package com.bst.ckt.framework.db;

/**
 * <p><code>TransactionStatus</code> class use to set 
 * the transaction status and return the transaction status.</p>
 * @author Yogendra Singh Rajput
 * @version 1.0
 */
public class TransactionStatus {

	/**
	 * <p>This token is keep the transaction status.If it is 
	 * true - we are in same database transaction 
	 * else we are out of transaction.</p>
	 */
	private boolean withinTransaction=false;

	/**
	 * <p>This method returns the Transaction Status.</p>
	 * @return boolean true-if within the transaction
	 */
	public boolean isWithinTransaction() {
		return withinTransaction;
	}

	/**
	 * <p>This method set the Transaction Status.</p>
	 * @param withinTransaction boolean true-if we want to start the transaction state.
	 */
	public void setWithinTransaction(boolean withinTransaction) {
		this.withinTransaction = withinTransaction;
	}
	
}
