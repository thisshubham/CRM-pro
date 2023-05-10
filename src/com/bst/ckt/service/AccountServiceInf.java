/**
 * 
 */
package com.bst.ckt.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bst.ckt.dto.AccountDTO;
import com.bst.ckt.vo.AccountVO;

/**
 * @author shaikh
 * 
 */
public interface AccountServiceInf {

	/**
	 * <p>
	 * <code>addAccountDetails()</code>this method is design to add account
	 * details into database.
	 * </p>
	 * 
	 * @param accountVO
	 * @return
	 * @throws Exception
	 */
	public String addAccountDetails(AccountVO accountVO) throws Exception;

	/**
	 * <p>
	 * <code>getAccountDetails()</code> Method is design to get account
	 * information from database for display into the grid
	 * </p>
	 * 
	 * @param accountVO
	 *            AccountVO
	 * @throws Exception
	 */
	public List<AccountVO> getAccountDetails(AccountVO accountVO)
			throws Exception;

	/**
	 * <p>
	 * <code>getAccountInformation()</code> Method is design to get account
	 * information from database for display into the view page
	 * </p>
	 * 
	 * @param accountId
	 * 
	 * @throws Exception
	 */
	public AccountDTO getAccountInformation(int accountId) throws Exception;

	/**
	 * <p>
	 * <code>populateAccountInformation()</code> Method is design to get account
	 * information from database for update process into the edit account
	 * details page
	 * </p>
	 * 
	 * @param accountId
	 * 
	 * @throws Exception
	 */
	public AccountDTO populateAccountInformation(int accountId)
			throws Exception;

	/**
	 * <p>
	 * <code>updateAccountDetails()</code> Method is design to update account
	 * information into database
	 * </p>
	 * 
	 * 
	 * @param accountVO
	 *            AccountVO
	 * @throws Exception
	 */
	public String updateAccountDetails(AccountVO accountVO) throws Exception;

	/**
	 * <p>
	 * <code>accountSocialInformation()</code> Method is design to insert
	 * account social information into database
	 * </p>
	 * 
	 * 
	 * @param accountVO
	 *            AccountVO
	 * @throws Exception
	 */
	public String accountSocialInformation(AccountVO accountVO)
			throws Exception;

	/**
	 * <p>
	 * <code>getNextAccountDetails()</code> Method is design to get account
	 * information from database
	 * </p>
	 * 
	 * 
	 * @param accountId
	 *            accountId
	 * @throws Exception
	 */

	public AccountDTO getNextAccountDetails(int accountId) throws Exception;
	
	
	/**
	 * <p>
	 * <code>getPriviousAccountDetails()</code>
	 * </p>
	 * 
	 * 
	 * @throws Exception
	 */
	public AccountDTO getPriviousAccountDetails(int AccountId) throws Exception;
	
	
	public AccountDTO editNextAccountDetails(int AccountId)throws Exception;

	public AccountDTO editPreviousAccountDetails(int AccountId)throws Exception;
	
	
	/**
	 * 
	 * <p>
	 * <code>accountExcelReport()</code>this method is use to generate the Excel
	 * Sheet for account Dashboard from database
	 * </p>
	 * 
	 * @throws Exception
	 * @param request
	 * @param response
	 */
	public void accountExcelReport(HttpServletRequest request,
			HttpServletResponse response) throws Exception;

}
