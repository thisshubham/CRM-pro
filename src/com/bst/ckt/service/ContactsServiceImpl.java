/**
 * 
 */
package com.bst.ckt.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.bst.ckt.common.LoginUtil;
import com.bst.ckt.common.OMIConstants;
import com.bst.ckt.dao.AssignmentDaoImpl;
import com.bst.ckt.dao.AssignmentDaoInf;
import com.bst.ckt.dao.ContactsDaoImpl;
import com.bst.ckt.dao.ContactsDaoInf;
import com.bst.ckt.dao.ExcelReportDaoImpl;
import com.bst.ckt.dao.ExcelReportDaoInf;
import com.bst.ckt.dto.Assignment;
import com.bst.ckt.dto.Contacts;
import com.bst.ckt.dto.Lead;
import com.bst.ckt.exception.OMIApplicationException;
import com.bst.ckt.framework.util.IDGenerator;
import com.bst.ckt.vo.AssignmentVO;
import com.bst.ckt.vo.ContactsVO;

/**
 * @author sharif
 * 
 */
public class ContactsServiceImpl implements ContactsServiceInf {

	/**
	 * Creating Logger object, logger object mapped with ContactsServiceImpl
	 * class for writing Loggers.
	 */
	private static final Logger logger = Logger
			.getLogger(ContactsServiceImpl.class);

	ContactsDaoInf contactsDaoInf = new ContactsDaoImpl();
	ExcelReportDaoInf excelReportDaoInf = new ExcelReportDaoImpl();

	/**
	 * <p>
	 * <code>addContactsDetails</code> This method is design to add contacts
	 * details into database.
	 * <p>
	 * 
	 * @param contactsVO
	 *            ContactsVO ,String filePath, String userImageFileName
	 * @throws Exception
	 */

	/**
	 * <p>
	 * <code>addGroupsContactInformation()</code>
	 * <p>
	 * 
	 * @param contacts
	 *            Contacts
	 * @throws Exception
	 */
	public String addGroupsContactInformation(ContactsVO contactsVO)
			throws Exception {

		contactsDaoInf = new ContactsDaoImpl();
		int target = contactsDaoInf.insertGroupsContactInformation(contactsVO);

		if (target == 1) {
			logger.info("Successfully Inserted Social Details!");
			return OMIConstants.TARGET_SUCCESS;
		} else if (target == 2) {
			logger.info("Successfully Updated Social Details!");
			return OMIConstants.TARGET_SUCCESS1;
		}
		logger.info("Error:while  Inserting  and Updating Social Details into database!");
		return OMIConstants.TARGET_FAILURE;

	}

	/**
	 * <p>
	 * <code>viewContactInfo()</code> This method is design to view contacts
	 * details into database.
	 * <p>
	 * 
	 * @param contactsId
	 *            int
	 */

	public Contacts viewContactInfo(int contactsId)
			throws OMIApplicationException {

		Contacts contacts = null;
		contacts = contactsDaoInf.retrieveContactsInformatin(contactsId);
		return contacts;
	}

	/**
	 * <p>
	 * <code>updateContactsDetails()</code> This method is design to update
	 * contacts details into database.
	 * <p>
	 * 
	 * @param contactsId
	 *            int,filePath String,userImageFileName String,
	 * 
	 * @throws OMIApplicationException
	 */
	@Override
	public String updateContactsDetails(ContactsVO contactsVO, String filePath,
			String userImageFileName) throws OMIApplicationException {
		contactsDaoInf = new ContactsDaoImpl();
		String referenceId = IDGenerator.generateAlphaNumericID(27);
		int target = contactsDaoInf.updateContactsinfo(contactsVO, filePath,
				referenceId);

		if (target == 1) {
			logger.info("Successfu1lly Updated Contacts Details!");
			try {
				// getContactsIDByReference based on referenceID
				int contactsID = contactsDaoInf
						.getContactsIDByReference(referenceId);
				if (contactsID != OMIConstants.SELF_REG_USER_ID) {
					contactsVO.setContactId(contactsID);
					contactsDaoInf.updateContactsFileName(contactsID);

					logger.error("Contacts  Registered Successfully ");
					return OMIConstants.TARGET_SUCCESS;

				} else {
					logger.error("Failed while retrieving contact id  from TAB_CONTACT");
					return OMIConstants.TARGET_USER_CREATE_FAILED;
				}
			} catch (Exception exception) {
				exception.printStackTrace();
				logger.error("Failed while updating Contacts details");
				return OMIConstants.TARGET_USER_CREATE_FAILED;
			}
		} else {

			logger.info("Error:While  Updating  Contacts Details into database!");
			return OMIConstants.TARGET_FAILURE;
		}

	}

	/**
	 * <p>
	 * <code>getContactInfo()</code> This method is design to get contacts
	 * details from database for update process.
	 * <p>
	 * 
	 * @param contactsId
	 *            int
	 */
	@Override
	public Contacts getContactInfo(int contactsId) throws Exception {
		Contacts contacts = null;
		contacts = contactsDaoInf.showContactsInformatin(contactsId);
		return contacts;
	}

	@Override
	public String addContactsDetails(ContactsVO contactsVO) throws Exception {

		ContactsDaoInf contactsDaoInf = new ContactsDaoImpl();
		int target = contactsDaoInf.insertContactsDetails(contactsVO);

		if (target == 1) {
			logger.info("Contact Details Successfully Inserted!");
			return OMIConstants.TARGET_SUCCESS;

		} else {

			logger.info("Error:while  Inserting  Contact Details into database!");
			return OMIConstants.TARGET_FAILURE;
		}
	}

	/**
	 * <p>
	 * <code>fetchContactsList()</code>method is design to fetch contact details
	 * from database
	 * </p>
	 * 
	 * 
	 * 
	 * @return SUCCESS
	 * @throws Exception
	 */
	@Override
	public List<ContactsVO> fetchContactsList() throws Exception {
		
			ContactsDaoInf contactsDaoInf = new ContactsDaoImpl();
			return contactsDaoInf.getContactsList();

		}

	
	/**
	 * <p>
	 * <code>editContactsInfo()</code>method is design to edit contact details
	 *  
	 * 
	 * @return SUCCESS
	 * @throws Exception
	 */
	public Contacts editContactsInfo(int contactId) throws Exception {
		ContactsDaoInf contactsDaoInf = new ContactsDaoImpl();
		Contacts contacts  = null;
		try {
			contacts = contactsDaoInf.editContactsDetail(contactId);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return contacts;
	}

	
	/**
	 * <p>
	 * <code>updateContactsInfo()</code>method is design to update contact details
	 *  
	 * 
	 * @return SUCCESS
	 * @throws Exception
	 */
	@Override
	public String updateContactsInfo(ContactsVO contactsVO, int contactId)
			throws Exception {
		int target = contactsDaoInf.getContactsDetailsForUpdate(
				contactsVO, contactId);

		if (target == 1) {
			logger.info("Successfully Updating Contacts!");
			return OMIConstants.TARGET_SUCCESS;

		} else {
			logger.info("Error:while  Updating  Contacts into database!");
			return OMIConstants.TARGET_FAILURE;

		}
	}

	/**
	 * <p>
	 * <code>contactsExcelReport()</code>
	 * <p>
	 * 
	 * @param request
	 * @param response
	 * 
	 * @throws Exception
	 */
	@Override
	public void contactsExcelReport(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
			excelReportDaoInf.retriveContactsExcelReport(request, response);
		}

	
	/**
	 * <p>
	 * <code>contactsPDF()</code>
	 * <p>
	 * 
	 * @param request
	 * @param response
	 * 
	 * @throws Exception
	 */
	@Override
	public void contactsPDF(HttpServletRequest request,
			HttpServletResponse response, int contactId) {
		contactsDaoInf.contactsPDF(request, response, contactId);
		
	}

	/**
	 * <p>
	 * <code>viewNextContactDetails</code>
	 * <p>
	 * 
	 * @param leadId
	 *            int
	 * @throws Exception
	 */
	@Override
	public Contacts viewNextContactDetails(int contactId) throws Exception {

		Contacts contacts = null;
		try {
			contactId++;
			if (contactsDaoInf.getContactLastRecord() < contactId) {
				contactId = 0;
				LoginUtil.setProcessUserId(contactId);
				contacts = new Contacts();
				contacts.setContactId(0);
				return contacts;
			} else {
				LoginUtil.setProcessUserId(contactId);
				contacts = contactsDaoInf.getContactDetails(contactId);
				if (contacts.getContactId() == 0) {
					contactId = LoginUtil.getProcessUserId();
					LoginUtil.setProcessUserId(contactId);
					return contacts;
				}
				contacts = contactsDaoInf.getContactDetails(contactId);
			}

		} catch (Exception exception) {
			logger.error("no records found" + exception);
		}
		return contacts;
	}

	/**
	 * <p>
	 * <code>viewPreviousContactDetails</code>
	 * <p>
	 * 
	 * @param contactId
	 *            int
	 * @throws Exception
	 */
	@Override
	public Contacts viewPreviousContactDetails(int contactId) throws Exception {

		Contacts contacts = null;
		try {
			contactId--;
			LoginUtil.setProcessUserId(contactId);
			contacts = contactsDaoInf.getContactDetails(contactId);
			if (contacts.getContactId() == 0) {
				contactId = LoginUtil.getProcessUserId();
				LoginUtil.setProcessUserId(contactId);
				return contacts;
			}
			contacts = contactsDaoInf.getContactDetails(contactId);

		} catch (Exception exception) {
			logger.error("no records found" + exception);
		}
		return contacts;
	}


		
	}
	

