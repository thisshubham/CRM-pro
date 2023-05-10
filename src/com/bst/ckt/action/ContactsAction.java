/*
 **********************************************************************
 *
. * COPYRIGHT. $ID$ 2015. ALL RIGHTS RESERVED.
 *
 * This software is only to be used for the purpose for which it has been
 * provided. No part of it is to be reproduced, disassembled, transmitted,
 * stored in a retrieval system nor translated in any human or computer
 * language in any way or for any other purposes whatsoever without the
 * prior written consent of $ID$.
 * 
 * Class Name     ContactsAction.java     
 *                                                            
 * Creation Date  OCT 22, 2015 
 * 
 * Abstract       This is Action class which is design to call particular 
 * 				  action with respective page.
 *  
 * Amendment History (in chronological sequence):OCT 22, 2015 
 * 
 * Author Ahmar Akhtar Sharif
 **********************************************************************
 */
package com.bst.ckt.action;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.bst.ckt.common.LoginUtil;
import com.bst.ckt.common.OMIConstants;
import com.bst.ckt.dao.ContactsDaoImpl;
import com.bst.ckt.dao.ContactsDaoInf;
import com.bst.ckt.framework.user.CustomerSessionUser;
import com.bst.ckt.helper.ListHelper;
import com.bst.ckt.helper.Salutation;
import com.bst.ckt.helper.VOMapperHelper;
import com.bst.ckt.service.AssignmentServiceImpl;
import com.bst.ckt.service.AssignmentServiceInf;
import com.bst.ckt.service.ContactsServiceImpl;
import com.bst.ckt.service.ContactsServiceInf;
import com.bst.ckt.vo.AssignmentVO;
import com.bst.ckt.vo.ContactsVO;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @author sharif
 * 
 */
public class ContactsAction extends ActionSupport implements
		ModelDriven<ContactsVO>, SessionAware ,ServletRequestAware,ServletResponseAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3485177716629725295L;

	/**
	 * Creating Logger object, logger object mapped with ContactsAction class
	 * for writing Loggers.
	 */
	private static final Logger logger = Logger.getLogger(ContactsAction.class);
	ContactsServiceInf contactsServiceInf = new ContactsServiceImpl();
	ContactsVO contactsVO = new ContactsVO();
	ListHelper listHelper = new ListHelper();
	ContactsDaoInf contactsDaoInf = new ContactsDaoImpl();
	HttpServletRequest request = null;
	HttpServletResponse response = null;
	private Map<Integer, String> countryList;
	private Map<Integer, String> designationList;
	private Map<Integer, String> socialSiteList;
	private List<ContactsVO> contactsSocialDetailsGrid;
	private List<ContactsVO> contactsDetailList = null;
	private Map<Integer, String> salutationList;
	private HashMap<Integer, String> parentAccountList;
	private HashMap<Integer, String> leadSourceList;
	private Map<Integer, String> reportsToList;
	List<ContactsVO> contactsList;
	Map<String, Object> session = null;
	private String userImageFileName = null;
	private String userImageContentType = null;
	private File userImage = null;

	public ContactsAction() throws Exception {

		countryList = listHelper.countryList();
		designationList = listHelper.designationList();
		salutationList = Salutation.getSalutationList();
		parentAccountList = listHelper.getParentAccountList();
		leadSourceList = listHelper.leadSourceList();
		reportsToList = listHelper.reportsToList();
	

	}

	/**
	 * <p>
	 * <code>execute()</code>method is design to fetch contact details
	 * from database
	 * </p>
	 * 
	 * 
	 * 
	 * @return SUCCESS
	 * @throws Exception
	 */
	public String execute() throws Exception {
		ContactsServiceInf contactsServiceInf = new ContactsServiceImpl();
		this.contactsList = contactsServiceInf.fetchContactsList();
		return SUCCESS;
	}

	/**
	 * <p>
	 * <code>addContacts()</code>method is design to add new contact details
	 * into database
	 * </p>
	 * c
	 * 
	 * 
	 * @return SUCCESS
	 * @throws Exception
	 */
	public String addContacts() throws Exception {
		ContactsServiceInf contactsServiceInf = new ContactsServiceImpl();
		CustomerSessionUser customerSessionUser = LoginUtil
				.getCurrentCustomerUser();
		contactsVO.setCreatedBy(customerSessionUser.getCustomerId());
		String message=contactsServiceInf.addContactsDetails(contactsVO);
		if (OMIConstants.TARGET_SUCCESS.equalsIgnoreCase(message)) {
			logger.info("Contact Details Successfully Inserted!");
			addActionMessage("Contact Details Successfully Inserted!");
			return SUCCESS;

		} else if (OMIConstants.TARGET_FAILURE.equalsIgnoreCase(message)) {

			logger.info("Error:while  Inserting Contact Details!");
			addActionError("Error:while  Inserting Contact Details!");
			return INPUT;
		}

		return NONE;
	}

	/**
	 * <p>
	 * <code>addGroupsContactSocial()</code> this method design to add group's
	 * contact social into the database.
	 * </p>
	 * 
	 * @return SUCCESS
	 * @throws Exception
	 */

	public String addGroupsContactSocial() throws Exception {

		contactsServiceInf = new ContactsServiceImpl();
		String message = null;
		int contactsId = LoginUtil.getProcessUserId();
		contactsVO.setContactId(contactsId);
		message = contactsServiceInf.addGroupsContactInformation(contactsVO);
		if (OMIConstants.TARGET_SUCCESS.equalsIgnoreCase(message)) {
			contactsSocialDetailsGrid = contactsDaoInf
					.getLeadSocialDetailsList(contactsId);
			logger.info("Social details inserted successfully.");
			addActionMessage("Social details inserted successfully.");
			return SUCCESS;
		} else if (OMIConstants.TARGET_SUCCESS1.equalsIgnoreCase(message)) {
			contactsSocialDetailsGrid = contactsDaoInf
					.getLeadSocialDetailsList(contactsId);
			logger.info("Social details updated successfully.");
			addActionMessage("Social details updated successfully.");
			return SUCCESS;
		} else if (OMIConstants.TARGET_FAILURE.equalsIgnoreCase(message)) {
			logger.info(ContactsAction.class
					+ "Error:While inserting and updating social details.");
			addActionError("Error:While inserting and updating social details.");
			return INPUT;
		}
		return NONE;
	}

	/**
	 * <p>
	 * <code>getContactsDetails()</code>method is design to get contacts details
	 * from database
	 * </p>
	 * 
	 * 
	 * @return SUCCESS
	 * @throws Exception
	 */
	/*
	 * public String getContactsDetails() throws Exception { contactsDaoInf =
	 * new ContactsDaoImpl(); contactsDetailList =
	 * contactsDaoInf.showContactsDetails(); return SUCCESS; }
	 */

	/**
	 * <p>
	 * <code>viewContactInformation()</code>method is design to get contacts
	 * page details from database.
	 * </p>
	 * 
	 * 
	 * @return SUCCESS
	 * @throws Exception
	 */
	
	  public String viewContactInformation() throws Exception {
	  
	  int contactsId = Integer.parseInt(request.getParameter("command"));
	  LoginUtil.setProcessUserId(contactsId); 
	  contactsServiceInf = new ContactsServiceImpl();
	  this.contactsVO=VOMapperHelper.getContactsVOFromContacts(contactsVO, contactsServiceInf.viewContactInfo(contactsId));
	  return SUCCESS;
	  }
	 
	 

	/**
	 * <p>
	 * <code>getContactInformation()</code>method is design to get contacts page
	 * details from database.
	 * </p>
	 * 
	 * 
	 * @return SUCCESS
	 * @throws Exception
	 */
	/*
	 * public String getContactInformation() throws Exception {
	 * 
	 * int contactsId = Integer.parseInt(request.getParameter("command"));
	 * LoginUtil.setProcessUserId(contactsId); this.contactsVO =
	 * VOMapperHelper.getContactsVOFromContacts(contactsVO,
	 * contactsServiceInf.getContactInfo(contactsId)); return SUCCESS; }
	 */

	/**
	 * <p>
	 * <code>showContactsSocialDetails()</code> this method design to display
	 * contact social details from the database.
	 * </p>
	 * 
	 * @return SUCCESS
	 * @throws Exception
	 */
	/*
	 * public String showContactsSocialDetails() throws Exception { int
	 * contactsId = LoginUtil.getProcessUserId(); contactsSocialDetailsGrid =
	 * contactsDaoInf .getLeadSocialDetailsList(contactsId); return SUCCESS; }
	 */

	/**
	 * <p>
	 * <code>updateContacts()</code>method is design to update contact details
	 * into database
	 * </p>
	 * c
	 * 
	 * 
	 * @return SUCCESS
	 * @throws Exception
	 */
	/*public String updateContacts() throws Exception {

		contactsServiceInf = new ContactsServiceImpl();
		int customerId = LoginUtil.getCurrentCustomerUser().getCustomerId();
		contactsVO.setCreatedBy(customerId);

		String filePath = request.getSession().getServletContext()
				.getRealPath("/").concat("Directory")
				+ File.separator + customerId + File.separator + "ProfileImage";

		String message = contactsServiceInf.updateContactsDetails(contactsVO,
				filePath, userImageFileName);
		*//**
		 * TARGET_SUCCESS TARGET_FAILURE
		 *//*
		if (OMIConstants.TARGET_SUCCESS.equalsIgnoreCase(message)) {
			logger.info("Successfully Updated Contacts Details!");
			addActionMessage("Successfully Updated Contacts Details!");
			if (this.userImageFileName != null) {
				String profileImage = this.userImageFileName.replaceAll((".*")
						+ this.userImageFileName + "(.*)",
						"" + contactsVO.getContactId() + ".PNG");

				File fileToCreate = new File(filePath, profileImage);
				FileUtils.copyFile(this.userImage, fileToCreate);
			}

			return SUCCESS;

		} else if (OMIConstants.TARGET_FAILURE.equalsIgnoreCase(message)) {

			logger.info(ContactsAction.class
					+ "Error:while  Updated Contacts Details!");
			addActionError("Error:while  Updated Contacts Details!");
			return INPUT;
		}
		return NONE;
	}*/
	
	
	/**
	 * <p>
	 * <code>editContactsdetails()</code> method is use to edit the assignment
	 * details based on contactId
	 * </p>
	 * 
	 * @return
	 * @throws Exception
	 */
	public String editContactsdetails() throws Exception {

		CustomerSessionUser customerSessionUser = LoginUtil
				.getCurrentCustomerUser();
		contactsVO.setCreatedBy(customerSessionUser.getCustomerId());

		int contactId = Integer.parseInt(request.getParameter("command"));
		LoginUtil.setProcessUserId(contactId);
		// Creating the SupportServiceImpl object
		contactsServiceInf = new ContactsServiceImpl();
		this.contactsVO = VOMapperHelper.getContactsVOFromContacts(
				contactsVO,
				contactsServiceInf.editContactsInfo(contactId));
		return SUCCESS;
	}
	
	/**
	 * <p>
	 * <code>()updateContacts</code>this method is design to get contact
	 * details for the update process.
	 * </p>
	 * 
	 * @return SUCCESS
	 * @throws Exception
	 */
	public String updateContacts() throws Exception {
		contactsServiceInf=new ContactsServiceImpl(); 
		int contactId = LoginUtil.getProcessUserId();
		String message = contactsServiceInf.updateContactsInfo(
				contactsVO, contactId);
		if (OMIConstants.TARGET_SUCCESS.equalsIgnoreCase(message)) {
			logger.info("Successfully Updating Contact Information!");
			addActionMessage("Successfully Updating Contact Information!");
			return SUCCESS;

		} else if (OMIConstants.TARGET_FAILURE.equalsIgnoreCase(message)) {

			logger.info("Error:while  Updating Contact Information!");
			addActionError("Error:while  Updating Contact Information!");
			return ERROR;
		}

		return NONE;
	}
	
	
	/**
	 * <p>
	 * excelReport()
	 * </p>
	 * method to generate the Excel Sheet report of Contacts Dashboard from database
	 * 
	 * @return
	 * @throws Exception
	 * @author Deepak Vishwakarma
	 * @param request
	 *            ,response
	 */
	public String excelReport() throws Exception {
		System.out.println("action");
		contactsServiceInf.contactsExcelReport(request, response);
		return NONE;
	}
	
	/**
	 * <p>
	 * contactsPrintPDF()
	 * </p>
	 * method to generate the pdf report of contacts details from database
	 * 
	 * @return
	 * @throws Exception
	 */
	public String contactsPrintPDF() throws Exception {
		int contactId = LoginUtil.getProcessUserId();
		LoginUtil.setProcessUserId(contactId);
		contactsServiceInf.contactsPDF(request, response, contactId);
		return null;
	}

	/**
	 * <p>
	 * <code>viewNextContact()</code> method is use to view the lead details into
	 * view lead page
	 * </p>
	 * 
	 * @return
	 * @throws Exception
	 */
	public String viewNextContact() throws Exception {
		int contactId = LoginUtil.getProcessUserId();
		this.contactsVO = VOMapperHelper.getContactsVOFromContacts(contactsVO,
				contactsServiceInf.viewNextContactDetails(contactId));
		

		if (contactsVO.getContactId() != 0) {
			logger.info("Contact details found successfully for Contact Id  "
					+ contactsVO.getContactId());
			addActionMessage("Contact details found successfully for Contact Id "
					+ contactsVO.getContactId());
			return SUCCESS;
		} else {
			contactsVO.setContactId(LoginUtil.getProcessUserId());
			logger.error("Contact details not found for Contact Id  "
					+ contactsVO.getContactId());
			addActionError("Contact details not found for Contact Id "
					+ contactsVO.getContactId());
			return ERROR;

		}
	}
	
	
	/**
	 * <p>
	 * <code>viewPreviousContact()</code> method is use to view the contacts details into
	 * view contact page
	 * </p>
	 * 
	 * @return
	 * @throws Exception
	 */
	public String viewPreviousContact() throws Exception {
		int contactId = LoginUtil.getProcessUserId();
		this.contactsVO = VOMapperHelper.getContactsVOFromContacts(contactsVO,
				contactsServiceInf.viewPreviousContactDetails(contactId));
		
		
		if (contactsVO.getContactId() != 0) {
			logger.info("Contact details found successfully for Contact Id  "
					+ contactsVO.getContactId());
			addActionMessage("Contact details found successfully for Contact Id "
					+ contactsVO.getContactId());
			return SUCCESS;
		} else if (LoginUtil.getProcessUserId() == -1) {
			LoginUtil.setProcessUserId(contactsDaoInf.getContactLastRecord() + 1);
			logger.error("Contact details not found");
			addActionError("Contact details not found");
			return ERROR;
		} else {
			contactsVO.setContactId(LoginUtil.getProcessUserId());
			logger.error("Contact details not found for Contact Id  "
					+ contactsVO.getContactId());
			addActionError("Contact details not found for Contact Id "
					+ contactsVO.getContactId());
			return ERROR;

		}

	}
	
	
	/**
	 * @return the userImageFileName
	 */
	public String getUserImageFileName() {
		return userImageFileName;
	}

	/**
	 * @param userImageFileName
	 *            the userImageFileName to set
	 */
	public void setUserImageFileName(String userImageFileName) {
		this.userImageFileName = userImageFileName;
	}

	/**
	 * @return the userImageContentType
	 */
	public String getUserImageContentType() {
		return userImageContentType;
	}

	/**
	 * @param userImageContentType
	 *            the userImageContentType to set
	 */
	public void setUserImageContentType(String userImageContentType) {
		this.userImageContentType = userImageContentType;
	}

	/**
	 * @return the userImage
	 */
	public File getUserImage() {
		return userImage;
	}

	/**
	 * @param userImage
	 *            the userImage to set
	 */
	public void setUserImage(File userImage) {
		this.userImage = userImage;
	}
	
	/**
	 * @return the contactsList
	 */
	public List<ContactsVO> getContactsList() {
		return contactsList;
	}

	/**
	 * @param contactsList
	 *            the contactsList to set
	 */
	public void setContactsList(List<ContactsVO> contactsList) {
		this.contactsList = contactsList;
	}


	/**
	 * @return the contactsVO
	 */
	public ContactsVO getContactsVO() {
		return contactsVO;
	}

	/**
	 * @param contactsVO
	 *            the contactsVO to set
	 */
	public void setContactsVO(ContactsVO contactsVO) {
		this.contactsVO = contactsVO;
	}

	/**
	 * @return the listHelper
	 */
	public ListHelper getListHelper() {
		return listHelper;
	}

	/**
	 * @param listHelper
	 *            the listHelper to set
	 */
	public void setListHelper(ListHelper listHelper) {
		this.listHelper = listHelper;
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

	/**
	 * @return the logger
	 */
	public static Logger getLogger() {
		return logger;
	}

	/**
	 * @return the request
	 */
	public HttpServletRequest getRequest() {
		return request;
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		// TODO Auto-generated method stub
this.response=response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public ContactsVO getModel() {
		// TODO Auto-generated method stub
		return contactsVO;
	}

	public Map<Integer, String> getSocialSiteList() {
		return socialSiteList;
	}

	public void setSocialSiteList(Map<Integer, String> socialSiteList) {
		this.socialSiteList = socialSiteList;
	}

	public List<ContactsVO> getContactsSocialDetailsGrid() {
		return contactsSocialDetailsGrid;
	}

	public void setContactsSocialDetailsGrid(
			List<ContactsVO> contactsSocialDetailsGrid) {
		this.contactsSocialDetailsGrid = contactsSocialDetailsGrid;
	}

	public List<ContactsVO> getContactsDetailList() {
		return contactsDetailList;
	}

	public void setContactsDetailList(List<ContactsVO> contactsDetailList) {
		this.contactsDetailList = contactsDetailList;
	}

	public Map<Integer, String> getSalutationList() {
		return salutationList;
	}

	public void setSalutationList(Map<Integer, String> salutationList) {
		this.salutationList = salutationList;
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
	 * @return the leadSourceList
	 */
	public HashMap<Integer, String> getLeadSourceList() {
		return leadSourceList;
	}

	/**
	 * @param leadSourceList
	 *            the leadSourceList to set
	 */
	public void setLeadSourceList(HashMap<Integer, String> leadSourceList) {
		this.leadSourceList = leadSourceList;
	}

	/**
	 * @return the reportsToList
	 */
	public Map<Integer, String> getReportsToList() {
		return reportsToList;
	}

	/**
	 * @param reportsToList the reportsToList to set
	 */
	public void setReportsToList(Map<Integer, String> reportsToList) {
		this.reportsToList = reportsToList;
	}

}
