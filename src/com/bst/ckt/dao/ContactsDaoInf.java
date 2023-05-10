/**
 * 
 */
package com.bst.ckt.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bst.ckt.dto.Contacts;
import com.bst.ckt.exception.OMIApplicationException;
import com.bst.ckt.exception.UpdateFailedException;
import com.bst.ckt.vo.ContactsVO;

/**
 * @author sharif
 * 
 */
public interface ContactsDaoInf {

	
	/**
	 * <p>
	 * <code>getContactsIDByReference(String)</code> method help to get
	 * ContactId based on referenceID
	 * </p>
	 * 
	 * @return int
	 * @throws OMIApplicationException
	 * 
	 */
	public int getContactsIDByReference(String referenceId)
			throws OMIApplicationException;

	/**
	 * 
	 * <p>
	 * <code>updateContactsFileName(int contactsId) </code> method help to
	 * update contacts filename based on the contactsId
	 * </p>
	 * 
	 * @param contactsId
	 *            int
	 * 
	 * 
	 * @throws UpdateFailedException
	 */
	public void updateContactsFileName(int contactsId)
			throws UpdateFailedException;
	
	
	/**
	 * <p>
	 * <code>getLeadSocialDetailsList()</code> method design to fetch lead social details 
	 * </p>
	 * @param 
	 * @throws Exception
	 */
	public List<ContactsVO> getLeadSocialDetailsList(int contactsVO)throws Exception;
	
	
	/**
	 * <P>
	 * <CODE>insertGroupsContactInformation()</CODE> METHOD IS USE TO INSERT LEAD SOCIAL INFORMATION DETAILS FROM
	 * DATABASE
	 * </P>
	 * 
	 * @param contacts contacts
	 * @throws Exception
	 */
	public int insertGroupsContactInformation(ContactsVO contactsVO)throws Exception;
	
	/**
	 * <p>
	 * <code>showContactsDetails()</code>this method is used to fetch contacts details from database
	 * </p>
	 * 
	 * @return ContactsVO List
	 * @throws OMIApplicationException
	 */
	
	public List<ContactsVO> showContactsDetails() throws OMIApplicationException;

	/**
	 * <p>
	 * <code>retrieveContactsInformatin()</code>this method is design to retrieve
	 * contacts from database.
	 * </p>
	 * 
	 * @return contactsId int
	 * @throws OMIApplicationException
	 */
	public Contacts retrieveContactsInformatin(int contactsId) throws OMIApplicationException;

	/**
	 * <p>
	 * <code>updateContactsinfo()</code>this method is design to update
	 * contacts information into database.
	 * </p>
	 * 
	 * @param contactsId
	 *            int,filePath String,userImageFileName String,
	 *               
	 *@throws OMIApplicationException 
	 */
	public int updateContactsinfo(ContactsVO contactsVO, String filePath,
			String referenceId)throws OMIApplicationException;

	/**
	 * <p>
	 * <code>showContactsInformatin()</code>this method is design to display
	 * contacts details from database into page for update process.
	 * </p>
	 * 
	 * @return contactsId int
	 * @throws Exception
	 */
	public Contacts showContactsInformatin(int contactsId)throws Exception;
	
	
	/**
	 * <p>
	 * <code>insertContactsDetails()</code>this method is used to insert group
	 * details in database
	 * </p>
	 * 
	 * @param ContactsVO
	 *           
	 * @return in
	 * @throws Exception
	 */


	public int insertContactsDetails(ContactsVO contactsVO) throws Exception;

	
	/**
	 * <p>
	 * <code>getContactsList()</code>method is design to fetch contact details
	 * from database
	 * </p>
	 * 
	 * 
	 * 
	 * @return SUCCESS
	 * @throws Exception
	 */
	public List<ContactsVO> getContactsList() throws Exception;

	/**
	 * <p>
	 * <code>editContactsDetail()</code>method is design to edit contact details
	 *  
	 * 
	 * @return SUCCESS
	 * @throws Exception
	 */
	public Contacts editContactsDetail(int contactId) throws Exception;

	/**
	 * <p>
	 * <code>getContactsDetailsForUpdate()</code>method is design to update contact details
	 *  
	 * 
	 * @return SUCCESS
	 * @throws Exception
	 */
	public int getContactsDetailsForUpdate(ContactsVO contactsVO, int contactId) throws Exception;

	/**
	 * <p>
	 * <code>contactsPDF()</code>method is design to get contact details as pdf
	 *  
	 * 
	 * @return SUCCESS
	 * @throws Exception
	 */
	public void contactsPDF(HttpServletRequest request,
			HttpServletResponse response, int contactId);

	public int getContactLastRecord() throws Exception;
	
	
	/**
	 * 
	 * @param contactId
	 * @return
	 * @throws Exception
	 */
	public Contacts getContactDetails(int contactId)throws Exception;

	
	
	
}
