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
 * Class Name     AccountServiceImpl.java     
 *                                                            
 * Creation Date  SEP 18, 2015 
 * 
 * Abstract       This is AccountServiceImpl class design to implement  
 * 					the methods of AccountServiceInf interface.
 *  
 * Amendment History (in chronological sequence): SEP 18, 2015 
 * 
 **********************************************************************
 */
package com.bst.ckt.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.bst.ckt.common.LoginUtil;
import com.bst.ckt.common.OMIConstants;
import com.bst.ckt.dao.AccountDaoImpl;
import com.bst.ckt.dao.AccountDaoInf;
import com.bst.ckt.dao.ExcelReportDaoImpl;
import com.bst.ckt.dao.ExcelReportDaoInf;
import com.bst.ckt.dto.AccountDTO;
import com.bst.ckt.vo.AccountVO;

/**
 * @author shaikh
 * 
 */
public class AccountServiceImpl implements AccountServiceInf {

	/**
	 * Creating Logger object, logger object mapped with AccountServiceImpl
	 * class for writing Loggers.
	 */
	private static final Logger logger = Logger
			.getLogger(AccountServiceImpl.class);

	AccountDaoInf accountDaoInf = new AccountDaoImpl();


ExcelReportDaoInf excelReportDaoInf = new ExcelReportDaoImpl();

	/**
	 * <p>
	 * <code>addAccountDetails()</code> This method is design to add new account
	 * details into database.
	 * <p>
	 * 
	 * @param accountVO
	 *            AccountVO
	 * @throws Exception
	 */
	@Override
	public String addAccountDetails(AccountVO accountVO) throws Exception {

		accountDaoInf = new AccountDaoImpl();
		int target = accountDaoInf.insertNewAccountDetails(accountVO);

		if (target == 1) {
			logger.info("Successfully Inserte Account Details!");
			return OMIConstants.TARGET_SUCCESS;

		} else {

			logger.info("Error:While  Inserting  Account Details into database!");
			return OMIConstants.TARGET_FAILURE;
		}
	}

	/**
	 * <p>
	 * <code>getAccountDetails()</code> This method is design to get account
	 * details from database for the view into the grid.
	 * <p>
	 * 
	 * @throws Exception
	 */
	@Override
	public List<AccountVO> getAccountDetails(AccountVO accountVO)
			throws Exception {
		accountDaoInf = new AccountDaoImpl();

		int searchId = accountVO.getSearchId();
		String searchValue = "";

		if (searchId == 1) {
			searchValue = String.valueOf(accountVO.getAccountId());
		} else if (searchId == 2) {
			searchValue = accountVO.getAccountName();
		} else if (searchId == 3) {
			searchValue = String.valueOf(accountVO.getAccountOwner());
		} else if (searchId == 4) {
			searchValue = String.valueOf(accountVO.getAccountType());
		} else if (searchId == 5) {
			searchValue = accountVO.getMobileNo();
			System.out.println(" MOBILE NUMBER 8888" + accountVO.getMobileNo());
		} else if (searchId == 6) {
			searchValue = String.valueOf(accountVO.getAccountStatus());
		}

		return accountDaoInf.retriveAccountDetails(searchId, searchValue);
	}

	/**
	 * <p>
	 * <code>getAccountInformation()</code> This method is design to get account
	 * details from database for display into the view page.
	 * <p>
	 * 
	 * @param accountId
	 *            int
	 * @throws Exception
	 */
	@Override
	public AccountDTO getAccountInformation(int accountId) throws Exception {

		AccountDTO accountDTO = null;
		try {
			accountDaoInf = new AccountDaoImpl();
			accountDTO = accountDaoInf.retriveAccountInformation(accountId);
		} catch (Exception e) {
			logger.error(AccountServiceImpl.class
					+ "while getting the account details from database" + e);
		}
		return accountDTO;
	}

	/**
	 * <p>
	 * <code>populateAccountInformation()</code> This method is design to get
	 * account details from database for update process into the edit account
	 * details page.
	 * <p>
	 * 
	 * @param accountId
	 *            int
	 * @throws Exception
	 */
	@Override
	public AccountDTO populateAccountInformation(int accountId)
			throws Exception {
		AccountDTO accountDTO = null;
		try {
			accountDaoInf = new AccountDaoImpl();
			accountDTO = accountDaoInf.retriveAccountDetails(accountId);
		} catch (Exception e) {
			logger.error(AccountServiceImpl.class
					+ "while getting the account details from database" + e);
		}
		return accountDTO;
	}

	/**
	 * <p>
	 * <code>updateAccountDetails()</code> This method is design to update
	 * account details into database
	 * <p>
	 * 
	 * @param accountVO
	 *            AccountVO
	 * @throws Exception
	 */
	@Override
	public String updateAccountDetails(AccountVO accountVO) throws Exception {

		int target = accountDaoInf.updateAccountInfo(accountVO);

		if (target == 1) {
			logger.info(AccountServiceImpl.class
					+ "Successfully Update Account Information!");
			return OMIConstants.TARGET_SUCCESS;
		} else {

			logger.info(AccountServiceImpl.class
					+ "Error:while  Updating Account Information!");
			return OMIConstants.TARGET_FAILURE;
		}
	}

	/**
	 * <p>
	 * <code>accountSocialInformation()</code> This method is design to insert
	 * account social information into database
	 * <p>
	 * 
	 * @param accountVO
	 *            AccountVO
	 * @throws Exception
	 */
	@Override
	public String accountSocialInformation(AccountVO accountVO)
			throws Exception {
		accountDaoInf = new AccountDaoImpl();
		int target = accountDaoInf.insertSocialInformation(accountVO);

		if (target == 1) {
			logger.info("Successfully Inserte Account Social Information!");
			return OMIConstants.TARGET_SUCCESS;
		} else if (target == 2) {
			logger.info("Successfully Update Account Social Information!!");
			return OMIConstants.TARGET_SUCCESS1;
		}
		logger.info("Error:while  Inserting  and Updating Account Social Information into database!");
		return OMIConstants.TARGET_FAILURE;

	}

	/**
	 * <p>
	 * <code>getNextAccountDetails</code>
	 * <p>
	 * 
	 * @param AccountId
	 *            int
	 * @throws Exception
	 */
	@Override
	public AccountDTO getNextAccountDetails(int accountId) throws Exception {

		AccountDTO account = null;
		try {
			accountId++;
			if (accountDaoInf.getAccountLastRecord() < accountId) {
				accountId = 0;
				LoginUtil.setProcessUserId(accountId);
				account = new AccountDTO();
				account.setAccountId(0);
				return account;
			} else {
				LoginUtil.setProcessUserId(accountId);
				account = accountDaoInf.retriveAccountInformation(accountId);
				if (account.getAccountId() == 0) {
					accountId = LoginUtil.getProcessUserId();
					LoginUtil.setProcessUserId(accountId);
					return account;
				}
				account = accountDaoInf.retriveAccountInformation(accountId);
			}

		} catch (Exception exception) {
			logger.error("no records found" + exception);
		}
		return account;
	}

	/**
	 * <p>
	 * <code>getPriviousAccountDetails</code>
	 * <p>
	 * 
	 * @param AccountId
	 *            int
	 * @throws Exception
	 */
	@Override
	public AccountDTO getPriviousAccountDetails(int accountId) throws Exception {

		AccountDTO account = null;
		try {
			accountId--;
			LoginUtil.setProcessUserId(accountId);
			account = accountDaoInf.retriveAccountInformation(accountId);
			if (account.getAccountId() == 0) {
				accountId = LoginUtil.getProcessUserId();
				LoginUtil.setProcessUserId(accountId);
				return account;
			}
			account = accountDaoInf.retriveAccountInformation(accountId);

		} catch (Exception exception) {
			logger.error("no records found" + exception);
		}
		return account;
	}

	/**
	 * <p>
	 * <code>editNextAccountDetails</code>
	 * <p>
	 * 
	 * @param AccountId
	 *            int
	 * @throws Exception
	 */
	@Override
	public AccountDTO editNextAccountDetails(int accountId) throws Exception {

		AccountDTO account = null;
		try {
			accountId++;
			if (accountDaoInf.getAccountLastRecord() < accountId) {
				accountId = 0;
				LoginUtil.setProcessUserId(accountId);
				account = new AccountDTO();
				account.setAccountId(0);
				return account;
			} else {
				LoginUtil.setProcessUserId(accountId);
				account = accountDaoInf.retriveAccountDetails(accountId);
				if (account.getAccountId() == 0) {
					accountId = LoginUtil.getProcessUserId();
					LoginUtil.setProcessUserId(accountId);
					return account;
				}
				account = accountDaoInf.retriveAccountDetails(accountId);
			}

		} catch (Exception exception) {
			logger.error("no records found" + exception);
		}
		return account;
	}

	/**
	 * <p>
	 * <code>editPreviousAccountDetails</code>
	 * <p>
	 * 
	 * @param AccountId
	 *            int
	 * @throws Exception
	 */
	@Override
	public AccountDTO editPreviousAccountDetails(int accountId)
			throws Exception {

		AccountDTO account = null;
		try {
			accountId--;
			LoginUtil.setProcessUserId(accountId);
			account = accountDaoInf.retriveAccountDetails(accountId);
			if (account.getAccountId() == 0) {
				accountId = LoginUtil.getProcessUserId();
				LoginUtil.setProcessUserId(accountId);
				return account;
			}
			account = accountDaoInf.retriveAccountDetails(accountId);

		} catch (Exception exception) {
			logger.error("no records found" + exception);
		}
		return account;
	}
	
	
	
	/**
	 * <p>
	 * <code>accountExcelReport()</code>
	 * <p>
	 * 
	 * @param request
	 * @param response
	 * 
	 * @throws Exception
	 */
	@Override
	public void accountExcelReport(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		excelReportDaoInf.retriveAccountExcelReport(request, response);
		
	}





}
