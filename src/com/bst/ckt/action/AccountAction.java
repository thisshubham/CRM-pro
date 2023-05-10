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
 * Class Name     AccountAction.java     
 *                                                            
 * Creation Date  SEP 18, 2015 
 * 
 * Abstract       This is Action class which is design to call particular 
 * 				  action with respective page.
 *  
 * Amendment History (in chronological sequence):SEP 18, 2015 
 * 
 * Author Shaikh Hussain
 **********************************************************************
 */
package com.bst.ckt.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.bst.ckt.common.LoginUtil;
import com.bst.ckt.common.OMIConstants;
import com.bst.ckt.dao.AccountDaoImpl;
import com.bst.ckt.dao.AccountDaoInf;
import com.bst.ckt.framework.user.CustomerSessionUser;
import com.bst.ckt.helper.AccountAdvanceSearch;
import com.bst.ckt.helper.AccountType;
import com.bst.ckt.helper.ListHelper;
import com.bst.ckt.helper.Ratings;
import com.bst.ckt.helper.Salutation;
import com.bst.ckt.helper.VOMapperHelper;
import com.bst.ckt.service.AccountServiceImpl;
import com.bst.ckt.service.AccountServiceInf;
import com.bst.ckt.vo.AccountVO;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AccountAction extends ActionSupport implements
		ServletResponseAware, ModelDriven<AccountVO>, SessionAware,
		ServletRequestAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Creating Logger object, logger object mapped with AccountAction class for
	 * writing Loggers.
	 */
	private static final Logger logger = Logger.getLogger(AccountAction.class);

	AccountVO accountVO = new AccountVO();
	ListHelper listHelper = new ListHelper();
	AccountDaoInf accountDaoInf = new AccountDaoImpl();
	AccountServiceInf accountServiceInf = new AccountServiceImpl();
	HttpServletRequest request = null;
	HttpServletResponse response =null;

	private Map<Integer, String> countryList;
	private HashMap<Integer, String> salutationList;
	private Map<Integer, String> designationList;
	private List<AccountVO> accountDetailsList;
	private HashMap<Integer, String> ratingList;
	private Map<Integer, String> customerNameList;
	private Map<Integer, String> companyCategoryList;
	private Map<Integer, String> companySectorList;
	private Map<Integer, String> socialSiteValueList;
	private List<AccountVO> accountSocialInformationGrid;
	private HashMap<Integer, String> advanceSearchList;
	private HashMap<Integer, String> parentAccountList;
	private HashMap<Integer, String> accountTypeList;
	private Map<Integer, String> companyTypeList;
	private HashMap<String, String> accountOwnerList;

	public AccountAction() throws Exception {
		salutationList = Salutation.getSalutationList();
		designationList = listHelper.designationList();
		countryList = listHelper.countryList();
		ratingList = Ratings.getRatingList();
		customerNameList = listHelper.customerNameList();
		companyCategoryList = listHelper.companyCategoryList();
		companySectorList = listHelper.companySectorList();
		socialSiteValueList = listHelper.socialSiteValueList();
		companyTypeList = listHelper.companyTypeList();
		CustomerSessionUser customerSessionUser = LoginUtil
				.getCurrentCustomerUser();
		accountVO.setAssignTo(String.valueOf(customerSessionUser
				.getCustomerId()));
		advanceSearchList = AccountAdvanceSearch.getAdvanceSearchList();
		parentAccountList = listHelper.getParentAccountList();
		accountTypeList = AccountType.getAccountTypeList();
		accountOwnerList = listHelper.getAccountOwnerList();
	}

	/**
	 * @return the companyTypeList
	 */
	public Map<Integer, String> getCompanyTypeList() {
		return companyTypeList;
	}

	/**
	 * @param companyTypeList
	 *            the companyTypeList to set
	 */
	public void setCompanyTypeList(Map<Integer, String> companyTypeList) {
		this.companyTypeList = companyTypeList;
	}

	/**
	 * @return the parentAccountList
	 */
	public HashMap<Integer, String> getParentAccountList() {
		return parentAccountList;
	}

	/**
	 * @param parentAccountList
	 *            the parentAccountList to set
	 */
	public void setParentAccountList(HashMap<Integer, String> parentAccountList) {
		this.parentAccountList = parentAccountList;
	}

	/**
	 * @return the advanceSearchList
	 */
	public HashMap<Integer, String> getAdvanceSearchList() {
		return advanceSearchList;
	}

	/**
	 * @param advanceSearchList
	 *            the advanceSearchList to set
	 */
	public void setAdvanceSearchList(HashMap<Integer, String> advanceSearchList) {
		this.advanceSearchList = advanceSearchList;
	}

	public String execute() throws Exception {

		return SUCCESS;

	}

	/**
	 * <p>
	 * <code>getAccountDetails()</code>method is design to get account details
	 * from the database for view into the grid.
	 * </p>
	 * 
	 * 
	 * @return SUCCESS
	 * @throws Exception
	 */
	public String getAccountDetails() throws Exception {

		accountServiceInf = new AccountServiceImpl();
		accountDetailsList = accountServiceInf.getAccountDetails(accountVO);
		if (accountDetailsList == null) {
			logger.error("Error:While getting lead details as per advance search.");
			addActionError("No records found.");
			return ERROR;
		} else {
			logger.info("Records found successfully.");
			return SUCCESS;
		}
	}

	/**
	 * <p>
	 * <code>editAccountInformation()</code>method is design to get account
	 * details from the database for update process.
	 * </p>
	 * 
	 * 
	 * @return SUCCESS
	 * @throws Exception
	 */
	public String editAccountInformation() throws Exception {

		int accountId = Integer.parseInt(request.getParameter("command"));
		if (accountId == 0)
			accountId = LoginUtil.getProcessUserId();
		LoginUtil.setProcessUserId(accountId);
		accountServiceInf = new AccountServiceImpl();
		this.accountVO = VOMapperHelper.getAccountVOFromAccountDTO(accountVO,
				accountServiceInf.populateAccountInformation(accountId));
		return SUCCESS;
	}

	/**
	 * <p>
	 * <code>editAccountInformationClone()</code>method is design to get account
	 * details from the database for update process.
	 * </p>
	 * 
	 * 
	 * @return SUCCESS
	 * @throws Exception
	 */
	public String editAccountInformationClone() throws Exception {

		int accountId = Integer.parseInt(request.getParameter("command"));
		if (accountId == 0)
			accountId = LoginUtil.getProcessUserId();
		LoginUtil.setProcessUserId(accountId);
		accountServiceInf = new AccountServiceImpl();
		accountVO = VOMapperHelper.getAccountVOFromAccountDTO(accountVO,
				accountServiceInf.populateAccountInformation(accountId));
		/*accountVO.setAccountName(null);
		accountVO.setMobileIsd(null);
		accountVO.setMobileNo(null);*/
		return SUCCESS;
	}

	/**
	 * <p>
	 * <code>accountDetails()</code>method is design to get account details from
	 * the database for view.
	 * </p>
	 * 
	 * 
	 * @return SUCCESS
	 * @throws Exception
	 */
	public String accountDetails() throws Exception {

		accountServiceInf = new AccountServiceImpl();
		int accountId = Integer.parseInt(request.getParameter("command"));
		LoginUtil.setProcessUserId(accountId);
		this.accountVO = VOMapperHelper.getAccountVOFromAccountDTO(accountVO,
				accountServiceInf.getAccountInformation(accountId));
		accountSocialInformationGrid = accountDaoInf
				.getAccountSocialInformationList(accountId);
		return SUCCESS;

	}

	/**
	 * <p>
	 * <code>addNewAccount()</code>method is design to add new account details
	 * into database
	 * </p>
	 * 
	 * 
	 * @return SUCCESS
	 * @throws Exception
	 */
	public String addNewAccount() throws Exception {
		accountServiceInf = new AccountServiceImpl();
		CustomerSessionUser customerSessionUser = LoginUtil
				.getCurrentCustomerUser();
		accountVO.setCreatedBy(customerSessionUser.getCustomerId());

		String message = accountServiceInf.addAccountDetails(accountVO);
		if (OMIConstants.TARGET_SUCCESS.equalsIgnoreCase(message)) {
			logger.info("Successfully Inserte Account Details!");
			addActionMessage("Successfully Inserte Account Details!");
			return SUCCESS;

		} else if (OMIConstants.TARGET_FAILURE.equalsIgnoreCase(message)) {

			logger.info("Error:while  Inserting Account Details!");
			addActionError("Error:while  Inserting Account Details!");
			return INPUT;
		}
		return NONE;
	}

	/**
	 * <p>
	 * <code>updateAccountInformation()</code>method is design to update account
	 * details into database
	 * </p>
	 * 
	 * 
	 * @return SUCCESS
	 * @throws Exception
	 */
	public String updateAccountInformation() throws Exception {
		accountServiceInf = new AccountServiceImpl();
		int accountId = LoginUtil.getProcessUserId();
		accountVO.setAccountId(accountId);
		CustomerSessionUser customerSessionUser = LoginUtil
				.getCurrentCustomerUser();
		accountVO.setUpdatedBy(customerSessionUser.getCustomerId());

		String message = accountServiceInf.updateAccountDetails(accountVO);
		if (OMIConstants.TARGET_SUCCESS.equalsIgnoreCase(message)) {
			logger.info(AccountAction.class
					+ "Successfully Update Account Details!");
			addActionMessage("Successfully Update Account Details!");
			return SUCCESS;
		} else if (OMIConstants.TARGET_FAILURE.equalsIgnoreCase(message)) {

			logger.info(AccountAction.class
					+ "Error:while  updating Account Details!");
			addActionError("Error:while  updating Account Details!");
			return ERROR;
		}
		return NONE;
	}

	/**
	 * <p>
	 * <code>accountSocialInformation()</code> this method design to add account
	 * social into the database.
	 * </p>
	 * 
	 * @return SUCCESS
	 * @throws Exception
	 */

	public String accountSocialInformation() throws Exception {

		accountServiceInf = new AccountServiceImpl();
		String message = null;
		int accountId = LoginUtil.getProcessUserId();
		accountVO.setAccountId(accountId);
		message = accountServiceInf.accountSocialInformation(accountVO);
		if (OMIConstants.TARGET_SUCCESS.equalsIgnoreCase(message)) {
			accountSocialInformationGrid = accountDaoInf
					.getAccountSocialInformationList(accountId);
			logger.info("Lead social details inserted successfully.");
			addActionMessage("Account social information inserte successfully.");
			return SUCCESS;
		} else if (OMIConstants.TARGET_SUCCESS1.equalsIgnoreCase(message)) {
			accountSocialInformationGrid = accountDaoInf
					.getAccountSocialInformationList(accountId);
			logger.info("Lead social details updated successfully.");
			addActionMessage("Account social information update successfully.");
			return SUCCESS;
		} else if (OMIConstants.TARGET_FAILURE.equalsIgnoreCase(message)) {
			logger.info(AccountAction.class
					+ "Error:While inserting and updating lead social details.");
			addActionError("Error:While inserting and updating lead social details.");
			return INPUT;
		}
		return NONE;
	}

	/**
	 * <p>
	 * <code>viewNextAccount()</code> method is use to view the Account details
	 * into view Account page
	 * </p>
	 * 
	 * @return
	 * @throws Exception
	 */
	public String nextViewAccount() throws Exception {
		int accountId = LoginUtil.getProcessUserId();
		this.accountVO = VOMapperHelper.getAccountVOFromAccountDTO(accountVO,
				accountServiceInf.getNextAccountDetails(accountId));

		accountSocialInformationGrid = accountDaoInf
				.getAccountSocialInformationList(accountId);

		if (accountVO.getAccountId() != 0) {
			logger.info("Account details found successfully for Account Id  "
					+ accountVO.getAccountId());
			addActionMessage("Account details found successfully for Account Id "
					+ accountVO.getAccountId());
			return SUCCESS;
		} else {
			accountVO.setAccountId(LoginUtil.getProcessUserId());
			logger.error("Account details not found for Account Id  "
					+ accountVO.getAccountId());
			addActionError("Account details not found for Account Id "
					+ accountVO.getAccountId());
			return ERROR;

		}
	}

	/**
	 * <p>
	 * <code>viewNextAccount()</code> method is use to view the Account details
	 * into view Account page
	 * </p>
	 * 
	 * @return
	 * @throws Exception
	 */
	public String previousViewAccount() throws Exception {
		int accountId = LoginUtil.getProcessUserId();
		this.accountVO = VOMapperHelper.getAccountVOFromAccountDTO(accountVO,
				accountServiceInf.getPriviousAccountDetails(accountId));

		if (accountVO.getAccountId() != 0) {
			logger.info("Account details found successfully for Account Id  "
					+ accountVO.getAccountId());
			addActionMessage("Account details found successfully for Account Id "
					+ accountVO.getAccountId());
			return SUCCESS;
		} else if (LoginUtil.getProcessUserId() == -1) {
			LoginUtil
					.setProcessUserId(accountDaoInf.getAccountLastRecord() + 1);
			logger.error("Account details not found");
			addActionError("Account details not found");
			return ERROR;
		} else {
			accountVO.setAccountId(LoginUtil.getProcessUserId());
			logger.error("Account details not found for Account Id  "
					+ accountVO.getAccountId());
			addActionError("Account details not found for Account Id "
					+ accountVO.getAccountId());
			return ERROR;

		}

	}

	/**
	 * <p>
	 * <code>editNextAccount()</code> method is use to populate next Account
	 * details into edit Account page
	 * </p>
	 * 
	 * @return
	 * @throws Exception
	 */
	public String editNextAccount() throws Exception {
		int accountId = LoginUtil.getProcessUserId();
		this.accountVO = VOMapperHelper.getAccountVOFromAccountDTO(accountVO,
				accountServiceInf.editNextAccountDetails(accountId));
		if (accountVO.getAccountId() != 0) {
			logger.info("Account details found successfully for Account Id  "
					+ accountVO.getAccountId());
			addActionMessage("Account details found successfully for Account Id "
					+ accountVO.getAccountId());
			return SUCCESS;
		} else {
			accountVO.setAccountId(LoginUtil.getProcessUserId());
			logger.error("Account details not found for Account Id  "
					+ accountVO.getAccountId());
			addActionError("Account details not found for Account Id "
					+ accountVO.getAccountId());
			return ERROR;

		}
	}

	/**
	 * <p>
	 * <code>previousEditAccount()</code> method is use to view the Account
	 * details into edit Account page
	 * </p>
	 * 
	 * @return
	 * @throws Exception
	 */
	public String previousEditAccount() throws Exception {
		int accountId = LoginUtil.getProcessUserId();
		this.accountVO = VOMapperHelper.getAccountVOFromAccountDTO(accountVO,
				accountServiceInf.editPreviousAccountDetails(accountId));

		if (accountVO.getAccountId() != 0) {
			logger.info("Account details found successfully for Account Id  "
					+ accountVO.getAccountId());
			addActionMessage("Account details found successfully for Account Id "
					+ accountVO.getAccountId());
			return SUCCESS;
		} else if (LoginUtil.getProcessUserId() == -1) {
			LoginUtil
					.setProcessUserId(accountDaoInf.getAccountLastRecord() + 1);
			logger.error("Account details not found");
			addActionError("Account details not found");
			return ERROR;
		} else {
			accountVO.setAccountId(LoginUtil.getProcessUserId());
			logger.error("Account details not found for Account Id  "
					+ accountVO.getAccountId());
			addActionError("Account details not found for Account Id "
					+ accountVO.getAccountId());
			return ERROR;

		}

	}
	
	

	/**
	 * <p>
	 * excelReport()
	 * </p>
	 * method to generate the Excel Sheet report of account Dashboard from database
	 * 
	 * @return
	 * @throws Exception
	 * @author Deepak Vishwakarma
	 * @param request
	 *            ,response
	 */
	public String excelReport() throws Exception {
		accountServiceInf.accountExcelReport(request,response);
		return NONE;
	}
	
@Override
	public void setServletResponse(HttpServletResponse response) {
		// TODO Auto-generated method stub
		this.response=response ;

	}


	

	/**
	 * @return the countryList
	 */
	public Map<Integer, String> getCountryList() {
		return countryList;
	}

	/**
	 * @param countryList
	 *            the countryList to set
	 */
	public void setCountryList(Map<Integer, String> countryList) {
		this.countryList = countryList;
	}

	/**
	 * @return the salutationList
	 */
	public HashMap<Integer, String> getSalutationList() {
		return salutationList;
	}

	/**
	 * @param salutationList
	 *            the salutationList to set
	 */
	public void setSalutationList(HashMap<Integer, String> salutationList) {
		this.salutationList = salutationList;
	}

	/**
	 * @return the designationList
	 */
	public Map<Integer, String> getDesignationList() {
		return designationList;
	}

	/**
	 * @param designationList
	 *            the designationList to set
	 */
	public void setDesignationList(Map<Integer, String> designationList) {
		this.designationList = designationList;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public AccountVO getModel() {
		// TODO Auto-generated method stub
		return accountVO;
	}

	
	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;
	}

	/**
	 * @return the accountDetailsList
	 */
	public List<AccountVO> getAccountDetailsList() {
		return accountDetailsList;
	}

	/**
	 * @param accountDetailsList
	 *            the accountDetailsList to set
	 */
	public void setAccountDetailsList(List<AccountVO> accountDetailsList) {
		this.accountDetailsList = accountDetailsList;
	}

	/**
	 * @return the ratingList
	 */
	public HashMap<Integer, String> getRatingList() {
		return ratingList;
	}

	/**
	 * @param ratingList
	 *            the ratingList to set
	 */
	public void setRatingList(HashMap<Integer, String> ratingList) {
		this.ratingList = ratingList;
	}

	/**
	 * @return the customerNameList
	 */
	public Map<Integer, String> getCustomerNameList() {
		return customerNameList;
	}

	/**
	 * @param customerNameList
	 *            the customerNameList to set
	 */
	public void setCustomerNameList(Map<Integer, String> customerNameList) {
		this.customerNameList = customerNameList;
	}

	/**
	 * @return the companyCategoryList
	 */
	public Map<Integer, String> getCompanyCategoryList() {
		return companyCategoryList;
	}

	/**
	 * @param companyCategoryList
	 *            the companyCategoryList to set
	 */
	public void setCompanyCategoryList(Map<Integer, String> companyCategoryList) {
		this.companyCategoryList = companyCategoryList;
	}

	/**
	 * @return the companySectorList
	 */
	public Map<Integer, String> getCompanySectorList() {
		return companySectorList;
	}

	/**
	 * @param companySectorList
	 *            the companySectorList to set
	 */
	public void setCompanySectorList(Map<Integer, String> companySectorList) {
		this.companySectorList = companySectorList;
	}

	/**
	 * @return the socialSiteValueList
	 */
	public Map<Integer, String> getSocialSiteValueList() {
		return socialSiteValueList;
	}

	/**
	 * @param socialSiteValueList
	 *            the socialSiteValueList to set
	 */
	public void setSocialSiteValueList(Map<Integer, String> socialSiteValueList) {
		this.socialSiteValueList = socialSiteValueList;
	}

	/**
	 * @return the accountSocialInformationGrid
	 */
	public List<AccountVO> getAccountSocialInformationGrid() {
		return accountSocialInformationGrid;
	}

	/**
	 * @param accountSocialInformationGrid
	 *            the accountSocialInformationGrid to set
	 */
	public void setAccountSocialInformationGrid(
			List<AccountVO> accountSocialInformationGrid) {
		this.accountSocialInformationGrid = accountSocialInformationGrid;
	}

	/**
	 * @return the accountTypeList
	 */
	public HashMap<Integer, String> getAccountTypeList() {
		return accountTypeList;
	}

	/**
	 * @param accountTypeList
	 *            the accountTypeList to set
	 */
	public void setAccountTypeList(HashMap<Integer, String> accountTypeList) {
		this.accountTypeList = accountTypeList;
	}

	/**
	 * @return the accountOwnerList
	 */
	public HashMap<String, String> getAccountOwnerList() {
		return accountOwnerList;
	}

	/**
	 * @param accountOwnerList
	 *            the accountOwnerList to set
	 */
	public void setAccountOwnerList(HashMap<String, String> accountOwnerList) {
		this.accountOwnerList = accountOwnerList;
	}

}
