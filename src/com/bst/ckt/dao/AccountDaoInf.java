/*
 **********************************************************************
 *
 * COPYRIGHT. $ID$ 2015. ALL RIGHTS RESERVED.
 *
 * This software is only to be used for the purpose for which it has been
 * provided. No part of it is to be reproduced, disassembled, transmitted,
 * stored in a retrieval system nor translated in any human or computer
 * language in any way or for any other purposes whatsoever without the
 * prior written consent of $ID$.
 * 
 * Interface Name     AccountDaoInf.java     
 *                                                            
 * Creation Date  SEP 18, 2015 
 * 
 * Abstract       This is AccountDaoInf interface design to declare the method.
 *  
 * Amendment History (in chronological sequence): SEP 18, 2015 
 * 
 **********************************************************************
 */

package com.bst.ckt.dao;

import java.util.List;

import com.bst.ckt.dto.AccountDTO;
import com.bst.ckt.vo.AccountVO;

/**
 * @author shaikh
 * 
 */
public interface AccountDaoInf {

	/**
	 * <p>
	 * <code>insertGroupDetails()</code>this method is used to insert group
	 * details int database
	 * </p>
	 * 
	 * @param accountVO
	 * @return int
	 * @throws Exception
	 */
	public int insertNewAccountDetails(AccountVO accountVO) throws Exception;

	/**
	 * <p>
	 * <code>retriveAccountDetails()</code>this method is used to fetch account
	 * details from database
	 * </p>
	 * 
	 * @param accountVO
	 *            AccountVO
	 * @throws Exception
	 */
	public List<AccountVO> retriveAccountDetails(int searchId,
			String searchValue) throws Exception;

	/**
	 * <p>
	 * <code>retriveAccountInformation()</code>this method is used to fetch
	 * account information from database
	 * </p>
	 * 
	 * @param accountVO
	 *            AccountVO
	 * @throws Exception
	 */
	public AccountDTO retriveAccountInformation(int accountId) throws Exception;

	/**
	 * <p>
	 * <code>retriveAccountDetails()</code>this method is used to fetch account
	 * details from database for update process into the edit account details
	 * page
	 * </p>
	 * 
	 * @param accountId
	 *            int
	 * @throws Exception
	 */
	public AccountDTO retriveAccountDetails(int accountId) throws Exception;

	/**
	 * <p>
	 * <code>updateAccountInfo()</code>this method is used to update account
	 * details into database.
	 * </p>
	 * 
	 * @param accountVO
	 *            AccountVO
	 * @throws Exception
	 */
	public int updateAccountInfo(AccountVO accountVO) throws Exception;

	/**
	 * <p>
	 * <code>insertLeadSocialInformation()</code>this method is used to insert
	 * and update account information into database.
	 * </p>
	 * 
	 * @param accountVO
	 *            AccountVO
	 * @throws Exception
	 */
	public int insertSocialInformation(AccountVO accountVO) throws Exception;

	/**
	 * <p>
	 * <code>getAccountSocialInformationList()</code>this method is used to
	 * fetch account information from database.
	 * </p>
	 * 
	 * @param accountId
	 *            int
	 * @throws Exception
	 */
	public List<AccountVO> getAccountSocialInformationList(int accountId)
			throws Exception;

	/**
	 * <p>
	 * <code>getAccountLastRecord()</code>this method is used to get last record
	 * accountId.
	 * </p>
	 * 
	 * @throws Exception
	 */
	public int getAccountLastRecord() throws Exception;

}
