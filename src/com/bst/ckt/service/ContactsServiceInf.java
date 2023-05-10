/**
 * 
 */
package com.bst.ckt.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bst.ckt.dto.Assignment;
import com.bst.ckt.dto.Contacts;
import com.bst.ckt.exception.OMIApplicationException;
import com.bst.ckt.vo.ContactsVO;

/**
 * @author sharif
 * 
 */
public interface ContactsServiceInf {

	
	/**
	 * <p>
	 * <code>addGroupsContactInformation()</code>this method is use to insert
	 * lead social information into database
	 * </p>
	 * 
	 * @param contacts
	 *            Contacts
	 * @throws Exception
	 */
	public String addGroupsContactInformation(ContactsVO contactsVO)
			throws Exception;

	/**
	 * <p>
	 * <code>viewContactInfo()</code>this method is design to view contacts
	 * details from database.
	 * </p>
	 * 
	 * @param contactsId
	 *            int
	 * @return
	 * @throws OMIApplicationException
	 */

	public Contacts viewContactInfo(int contactsId)
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>updateContactsDetails()</code>this method is design to update
	 * contacts details into database.
	 * </p>
	 * 
	 * @param contactsId
	 *            int,filePath String,userImageFileName String,
	 * @return
	 * @throws OMIApplicationException
	 */
	public String updateContactsDetails(ContactsVO contactsVO, String filePath,
			String userImageFileName) throws OMIApplicationException;

	/**
	 * <p>
	 * <code>viewContactInfo()</code>this method is design to get contacts
	 * details from database for updated process.
	 * </p>
	 * 
	 * @param contactsId
	 *            int
	 * @return
	 * @throws OMIApplicationException
	 */
	public Contacts getContactInfo(int contactsId)throws Exception;
	
	
	/**
	 * <p>
	 * <code>addContactsDetails</code>this method is use to insert contact
	 * detail into database
	 * </p>
	 * 
	 * @param contactsVO
	 *            ContactsVO filePath String userImageFileName String
	 * @throws Exception
	 */

	public String addContactsDetails(ContactsVO contactsVO)throws Exception;

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
	public List<ContactsVO> fetchContactsList() throws Exception;

	/**
	 * <p>
	 * <code>editContactsInfo()</code>method is design to edit contact details
	 *  
	 * 
	 * @return SUCCESS
	 * @throws Exception
	 */
	public Contacts editContactsInfo(int contactId) throws Exception;

	/**
	 * <p>
	 * <code>updateContactsInfo()</code>method is design to update contact details
	 *  
	 * 
	 * @return SUCCESS
	 * @throws Exception
	 */
	public String updateContactsInfo(ContactsVO contactsVO, int contactId) throws Exception;

	/**
	 * 
	 * <p>
	 * <code>contactsExcelReport()</code>this method is use to generate the Excel
	 * Sheet for lead Dashboard from database
	 * </p>
	 * 
	 * @throws Exception
	 * @param request
	 * @param response
	 */
	public void contactsExcelReport(HttpServletRequest request,
			HttpServletResponse response) throws Exception;

	
	/**
	 * 
	 * <p>
	 * <code>contactsPDF</code>this method is use to generate the pdf for contacts
	 * detail from database
	 * </p>
	 * 
	 * @param request
	 * @param response
	 */
	public void contactsPDF(HttpServletRequest request,
			HttpServletResponse response, int contactId);
	
	
	/**
	 * <p>
	 * <code>viewNextContactDetails()</code>
	 * </p>
	 * 
	 * 
	 * @throws Exception
	 */
	public Contacts viewNextContactDetails(int contactId) throws Exception;

	/**
	 * <p>
	 * <code>viewPreviousContactDetails()</code>
	 * </p>
	 * 
	 * 
	 * @throws Exception
	 */
	public Contacts viewPreviousContactDetails(int contactId)throws Exception;

	
}
