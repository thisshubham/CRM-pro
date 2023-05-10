package com.bst.ckt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.bst.ckt.common.OMIConstants;
import com.bst.ckt.common.QueryMaker;
import com.bst.ckt.dto.Assignment;
import com.bst.ckt.dto.Contacts;
import com.bst.ckt.dto.Lead;
import com.bst.ckt.exception.OMIApplicationException;
import com.bst.ckt.exception.UpdateFailedException;
import com.bst.ckt.framework.db.JdbcDAOSupport;
import com.bst.ckt.framework.db.JdbcHelper;
import com.bst.ckt.framework.util.DateTimeUtil;
import com.bst.ckt.helper.AppendHelper;
import com.bst.ckt.helper.AssignmentStatus;
import com.bst.ckt.helper.LeadStatus;
import com.bst.ckt.helper.Modules;
import com.bst.ckt.helper.NameHelper;
import com.bst.ckt.helper.Ratings;
import com.bst.ckt.helper.Salutation;
import com.bst.ckt.vo.AssignmentVO;
import com.bst.ckt.vo.ContactsVO;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class ContactsDaoImpl extends JdbcDAOSupport implements ContactsDaoInf {

	/**
	 * Creating Logger object, logger object mapped with ContactsDaoImpl class
	 * for writing Loggers.
	 */
	private static final Logger logger = Logger
			.getLogger(ContactsDaoImpl.class);

	PreparedStatement preparedStatement = null;
	Connection connection = null;
	ResultSet resultSet = null;
	ContactsVO contactsVO = new ContactsVO();
	NameHelper nameHelper = null;
	Contacts contacts = new Contacts();
	Image image = null;

	
	

	/**
	 * <p>
	 * <code>getContactsIDByReference(String referenceId)</code> method help to
	 * get contactsId based on referenceID
	 * </p>
	 * 
	 * @return contactsId int
	 * @throws OMIApplicationException
	 * 
	 */
	public int getContactsIDByReference(String referenceId)
			throws OMIApplicationException {
		int contactsId = OMIConstants.SELF_REG_USER_ID;
		String query = QueryMaker.GET_CONTACTS_ID_BY_REFERENCE_ID;

		try {
			connection = getConnection();

			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, referenceId);
			resultSet = preparedStatement.executeQuery();

			if (resultSet != null) {
				if (resultSet.next()) {
					contactsId = resultSet.getInt("CONTACT_ID");

				}

			}

		} catch (SQLException sqlException) {
			logger.error("Failed to get Connection from Database", sqlException);

		} catch (Exception exception) {
			logger.error(
					"Failed to fetch Contacts Id based on referenceId from Database",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closeStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return contactsId;
	}

	/**
	 * <p>
	 * <code>updateContactsFileName(int contactsId)</code> method help to update
	 * Contacts File Name based on the contactId
	 * </p>
	 * 
	 * @param contactId
	 *            int
	 * 
	 * @throws UpdateFailedException
	 */
	public void updateContactsFileName(int contactId)
			throws UpdateFailedException {
		String query = QueryMaker.UPDATE_CONTACTS_FILE_NAME;
		String profileImage = "" + contactId + ".PNG";
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, profileImage);
			preparedStatement.setInt(2, contactId);
			preparedStatement.executeUpdate();
		} catch (SQLException sqlException) {
			logger.error("Failed to get Connection from Database", sqlException);
			throw new UpdateFailedException();
		} catch (Exception exception) {
			logger.error(
					"Failed to Update Contacts file name  Based on reference Id in Database",
					exception);
			throw new UpdateFailedException();
		} finally {

			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);

		}

	}

	/**
	 * <p>
	 * <code>getLeadSocialDetailsList()</code> method use to fetch lead social
	 * details from TAB_SOCIAL_CONTACT table.
	 * </p>
	 * 
	 * @return leadFollowUpDetails
	 */
	@Override
	public List<ContactsVO> getLeadSocialDetailsList(int contactId)
			throws Exception {
		ArrayList<ContactsVO> contactsSocialDetails = new ArrayList<ContactsVO>();
		nameHelper = new NameHelper();
		try {

			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_LEAD_SOCIAL_DETAILS);
			preparedStatement.setInt(1, Modules.CONTACTS_ID);
			System.out.println("lead id" + contactId);
			preparedStatement.setInt(2, contactId);
			// SOCIAL_SITE_REF,SOCIAL_CONTACT_VALUE
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				contactsVO = new ContactsVO();
				contactsVO.setSocialSiteRef(nameHelper.getSocialSite(resultSet
						.getInt("SOCIAL_SITE_REF")));
				contactsVO.setSocialContactValue(resultSet
						.getString("SOCIAL_CONTACT_VALUE"));
				contactsSocialDetails.add(contactsVO);
			}

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					LeadDaoImpl.class
							+ ": Error:- Error: Occur in Query While fetching lead social details from Database",
					sqlException);

		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					LeadDaoImpl.class
							+ ": Error:- While closing the Connection after fetching the lead social details from Database",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return contactsSocialDetails;
	}

	/**
	 * <p>
	 * <code>insertGroupsContactInformation()</code> method use to insert
	 * Group's Contact social information details into TAB_SOCIAL_CONTACT table.
	 * </p>
	 * 
	 * @param contacts
	 *            Contacts
	 * @throws Exception
	 * @return target int
	 */
	@Override
	public int insertGroupsContactInformation(ContactsVO contactsVO)
			throws Exception {

		int target = 0;
		connection = getConnection();
		try {
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_SOCIAL_INFO);
			preparedStatement.setString(1, contactsVO.getSocialSiteRef());
			preparedStatement.setInt(2, Modules.CONTACTS_ID);
			preparedStatement.setInt(3, contactsVO.getContactId());
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				contactsVO.setSocialContactId(resultSet
						.getString("SOCIAL_CONTACT_ID"));
				preparedStatement = connection
						.prepareStatement(QueryMaker.UPDATE_SOCIAL_INFORMATION);
				preparedStatement.setString(1, contactsVO.getSocialSiteRef());
				preparedStatement.setString(2,
						contactsVO.getSocialContactValue());
				preparedStatement.setInt(3, Modules.CONTACTS_ID);
				preparedStatement.setInt(4, contactsVO.getContactId());
				preparedStatement.setString(5, contactsVO.getSocialContactId());
				preparedStatement.executeUpdate();
				target = 2;

			} else {
				preparedStatement = connection
						.prepareStatement(QueryMaker.INSERT_SOCIAL_INFORMATION);
				preparedStatement.setString(1, contactsVO.getSocialSiteRef());
				preparedStatement.setString(2,
						contactsVO.getSocialContactValue());
				preparedStatement.setInt(3, Modules.CONTACTS_ID);
				preparedStatement.setInt(4, contactsVO.getContactId());
				preparedStatement.executeUpdate();
				target = 1;

			}

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					ContactsDaoImpl.class
							+ ": Error:- Error: Occur in Query While inserting the group's contact social details into Database",
					sqlException);

		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					ContactsDaoImpl.class
							+ ": Error:- While closing the Connection after inserting the group's contact social details into Database",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return target;
	}

	/**
	 * <p>
	 * <code>showContactsDetails()</code>this method is design to fetch contacts
	 * details from database into Contacts dashboard grid.
	 * </p>
	 * 
	 * @return contactsDetailsList
	 * @throws OMIApplicationException
	 */
	@Override
	public List<ContactsVO> showContactsDetails()
			throws OMIApplicationException {

		String query = QueryMaker.GET_CONTACTS_DETAILS_LIST;
		ArrayList<ContactsVO> contactsDetailsList = new ArrayList<ContactsVO>();

		StringBuffer sb = null;
		try {

			connection = getConnection();
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				contactsVO = new ContactsVO();
				sb = new StringBuffer();
				contactsVO.setContactId(resultSet.getInt("CONTACT_ID"));
				NameHelper nameHelper = new NameHelper();

				if (resultSet.getInt("GROUP_NAME_REF") == -1) {
					
				} else {

					
				}
				sb.append(
						Salutation.getSalutation(resultSet.getInt("SALUTATION")))
						.append(" ")
						.append(resultSet.getString("CONTACT_PERSON"));
				contactsVO.setContactperson(sb.toString());

				contactsVO
						.setDesignation(nameHelper.getDesignationName(resultSet
								.getInt("DESIGNATION_REF")));
				contactsVO.setEmailId(resultSet.getString("EMAIL_ID"));

				contactsVO.setMobileNum1(resultSet.getString("MOBILE_NUMBER1"));
				contactsVO.setWorkContPhoneNum(resultSet
						.getString("WORK_CONTACT_MOBILE_NUMBER"));

				contactsDetailsList.add(contactsVO);
			}
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					ContactsDaoImpl.class
							+ ": Error:- Error: Occur in Query While fetching the contacts details for display in grid from Database",
					sqlException);

		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					ContactsDaoImpl.class
							+ ": Error:- While closing the Connection after fetching the contacts details for display in grid from Database",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return contactsDetailsList;
	}

	/**
	 * <p>
	 * <code>retrieveContactsInformatin()</code>this method is design to
	 * retrieve contacts into database.
	 * </p>
	 * 
	 * @return contactsId int
	 * @throws OMIApplicationException
	 */

	public Contacts retrieveContactsInformatin(int contactsId)
			throws OMIApplicationException {

		contacts = new Contacts();
		StringBuffer sb = null;

		try {

			connection = getConnection();
			String query = QueryMaker.GET_CONTACTS_DETAILS;
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, contactsId);
			resultSet = preparedStatement.executeQuery();
			NameHelper nameHelper = new NameHelper();
			while (resultSet.next()) {
				sb = new StringBuffer();
				contacts.setContactId(resultSet.getInt("CONTACT_ID"));
				sb.append(
						Salutation.getSalutation(resultSet.getInt("SALUTATION")))
						.append(" ")
						.append(resultSet.getString("CONTACT_PERSON"));
				contacts.setContactperson(sb.toString());

				
				contacts.setNickName(resultSet.getString("NICK_NAME"));

				contacts.setDesignation(nameHelper.getDesignationName(resultSet
						.getInt("DESIGNATION_REF")));
				contacts.setPhoneNumber(resultSet.getString("PHONE_NUMBER"));
				
				contacts.setReferredBy(resultSet.getString("REFERRED_BY"));
				
				contacts.setDepartment(resultSet.getString("DEPARTMENT"));
				
				
				contacts.setReportsTo(resultSet.getString("REPORTS_TO"));
				contacts.setReference(resultSet
						.getString("REFERENCE"));
				contacts.setLeadSource(resultSet
						.getString("LEAD_SOURCE_REF"));

				contacts.setAssignedTo(resultSet.getString("ASSIGN_TO"));
				contacts.setDoNotCall(resultSet.getString("DO_NOT_CALL"));

				contacts.setNotifyOwner(resultSet
						.getString("NOTIFY_OWNER"));

				contacts.setEmailOptOut(resultSet.getString("EMAIL_OPT_OUT"));
				contacts.setSlaName(resultSet.getString("SLA_NAME"));
				contacts.setCustomerCenterUser(resultSet
						.getString("CUSTOMER_CENTER_USER"));

				
				contacts.setMobileNum1(resultSet
						.getString("MOBILE_NUMBER1"));
				contacts.setMobileNum1Isd(resultSet
						.getString("MOBILE_NUMBER1_ISD"));

				contacts.setMobileNum2(resultSet
						.getString("MOBILE_NUMBER2"));
				contacts.setMobileNum2Isd(resultSet
						.getString("MOBILE_NUMBER2_ISD"));
				contacts.setEmailId(resultSet
								.getString("EMAIL_ID"));
				
				contacts.setFax(resultSet
						.getString("FAX"));
				contacts.setFaxIsd(resultSet
						.getString("FAX_ISD"));
				contacts.setFaxStd(resultSet
						.getString("FAX_STD"));
				contacts.setHomeContAddLine1(resultSet
						.getString("HOME_CONTACT_ADDRESS_LINE1"));
				contacts.setHomeContAddLine2(resultSet
						.getString("HOME_CONTACT_ADDRESS_LINE2"));

				contacts.setHomeContCity(resultSet
						.getString("HOME_CONTACT_CITY"));

				contacts.setHomeContState(resultSet
						.getString("HOME_CONTACT_STATE"));
				contacts.setHomeContCountry(resultSet
						.getString("HOME_CONTACT_COUNTRY_REF"));
				contacts.setHomeContZipcode(resultSet
						.getString("HOME_CONTACT_ZIPCODE"));
				contacts.setHomeContPhoneNum(resultSet
						.getString("HOME_CONTACT_PHONE_NUMBER"));
				contacts.setHomeContPhoneNumIsd(resultSet
						.getString("HOME_CONTACT_PHONE_NUMBER_ISD"));
				contacts.setHomeContPhoneNumStd(resultSet
						.getString("HOME_CONTACT_PHONE_NUMBER_STD"));
				contacts.setHomeContMobileNum(resultSet
						.getString("HOME_CONTACT_MOBILE_NUMBER"));
				
				contacts.setHomeContMobileNumIsd(resultSet
						.getString("HOME_CONTACT_MOBILE_NUMBER_ISD"));
				contacts.setHomeContEmailId(resultSet
						.getString("HOME_CONTACT_EMAIL_ID"));
				contacts.setHomeContAlternateEmailId(resultSet
						.getString("HOME_CONTACT_ALTERNATE_EMAIL_ID"));
				contacts.setHomeContFaxNum(resultSet
						.getString("HOME_CONTACT_FAX_NUMBER"));
				contacts.setHomeContFaxNumIsd(resultSet
						.getString("HOME_CONTACT_FAX_NUMBER_ISD"));
				contacts.setHomeContFaxnumStd(resultSet
						.getString("HOME_CONTACT_FAX_NUMBER_STD"));
				contacts.setHomewebsite(resultSet
						.getString("HOME_WEBSITE"));
				contacts.setWorkContAddLine1(resultSet
						.getString("WORK_CONTACT_ADDRESS_LINE1"));
				contacts.setWorkContAddLine2(resultSet
						.getString("WORK_CONTACT_ADDRESS_LINE2"));
				contacts.setWorkContCity(resultSet
						.getString("WORK_CONTACT_CITY"));
				contacts.setWorkContState(resultSet
						.getString("WORK_CONTACT_STATE"));
				contacts.setWorkContCountry(resultSet
						.getString("WORK_CONTACT_COUNTRY_REF"));
				contacts.setWorkContZipcode(resultSet
						.getString("WORK_CONTACT_ZIPCODE"));
				contacts.setWorkContPhoneNum(resultSet
						.getString("WORK_CONTACT_PHONE_NUMBER"));
				contacts.setWorkContPhoneIsd(resultSet
						.getString("WORK_CONTACT_PHONE_NUMBER_ISD"));
				contacts.setWorkContPhoneStd(resultSet
						.getString("WORK_CONTACT_PHONE_NUMBER_STD"));
				contacts.setWorkContMobileNum(resultSet
						.getString("WORK_CONTACT_MOBILE_NUMBER"));
				contacts.setWorkContMobileNumIsd(resultSet
						.getString("WORK_CONTACT_MOBILE_NUMBER_ISD"));
				contacts.setWorkContEmailId(resultSet
						.getString("WORK_CONTACT_EMAIL_ID"));
				contacts.setWorkContAlternateEmailId(resultSet
						.getString("WORK_CONTACT_ALTERNATE_EMAIL_ID"));
				contacts.setWorkContFaxNum(resultSet
						.getString("WORK_CONTACT_FAX_NUMBER"));
				contacts.setWorkContFaxNumIsd(resultSet
						.getString("WORK_CONTACT_FAX_NUMBER_ISD"));
				contacts.setWorkContFaxNumStd(resultSet
						.getString("WORK_CONTACT_FAX_NUMBER_STD"));
				contacts.setWorkWebsite(resultSet
						.getString("WORK_WEBSITE"));
				contacts.setProfileDescription(resultSet
						.getString("PROFILE_DESCRIPTION"));
				
				contacts.setReferenceId(resultSet
						.getString("REFERANCE_ID"));
				contacts.setCreatedDate(resultSet
						.getString("CREATED_DATE"));
				contacts.setCreatedBy(resultSet
						.getInt("CREATED_BY"));
				contacts.setTitle(resultSet
						.getString("TITTLE"));
				contacts.setDob(resultSet
						.getString("DATE_OF_BIRTH"));
				contacts.setStatus(resultSet
						.getString("STATUS"));
				
			}

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					ContactsDaoImpl.class
							+ ": Error:- Error: Occur in Query While fetching the contacts details for view from Database",
					sqlException);

		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					ContactsDaoImpl.class
							+ ": Error:- While closing the Connection after fetching the contacts details for view from Database",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return contacts;
	}

	/**
	 * <p>
	 * <code>updateContactsinfo()</code>this method is design to update contact
	 * details into database
	 * </p>
	 * 6
	 * 
	 * @param ContactsVO
	 *            contactsVO, String filePath,String referenceId
	 * @return int
	 * @throws Exception
	 */
	@Override
	public int updateContactsinfo(ContactsVO contactsVO, String filePath,
			String referenceId) throws OMIApplicationException {

		int target = 0;

		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.UPDATE_CONTACT_DETAILS);
			preparedStatement.setString(1, contactsVO.getSalutation());

			preparedStatement.setString(2, contactsVO.getNickName());
			preparedStatement.setString(3, contactsVO.getDesignation());
			preparedStatement.setString(4, contactsVO.getPhoneNumber());
			preparedStatement.setString(5, contactsVO.getReferredBy());
			preparedStatement.setString(6, contactsVO.getMobileNum1());
			preparedStatement.setString(7, contactsVO.getMobileNum2());
			preparedStatement.setString(8, contactsVO.getEmailId());
			preparedStatement.setString(9, contactsVO.getHomeContAddLine1());
			preparedStatement.setString(10, contactsVO.getHomeContAddLine2());
			preparedStatement.setString(11, contactsVO.getHomeContCity());
			preparedStatement.setString(12, contactsVO.getHomeContState());
			preparedStatement.setString(13, contactsVO.getHomeContCountry());
			preparedStatement.setString(14, contactsVO.getHomeContZipcode());
			preparedStatement.setString(15, contactsVO.getHomeContMobileNum());
			preparedStatement.setString(16, contactsVO.getHomeContEmailId());
			preparedStatement.setString(17,
					contactsVO.getWorkContAddLine1());
			preparedStatement.setString(18,
					contactsVO.getWorkContAddLine2());
			preparedStatement.setString(19, contactsVO.getWorkContCity());
			preparedStatement.setString(20, contactsVO.getWorkContState());
			preparedStatement.setString(21, contactsVO.getWorkContZipcode());
			preparedStatement.setString(22, contactsVO.getWorkContMobileNum());
			preparedStatement.setString(23, contactsVO.getWorkContEmailId());
			preparedStatement.setString(24, contactsVO.getProfileDescription());
			preparedStatement.setString(25, DateTimeUtil.getCurrentDate());
			preparedStatement.setInt(26, contactsVO.getCreatedBy());
			preparedStatement.setString(27, contactsVO.getContactperson());

			
			preparedStatement.setString(28, referenceId);
			preparedStatement.setInt(29, contactsVO.getContactId());
			preparedStatement.executeUpdate();

			target = 1;
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					ContactsDaoImpl.class
							+ "Error: Occur in Query While Inserting the Contacts Details into Database.",
					sqlException);

		} catch (Exception exception) {

			exception.printStackTrace();
			logger.error(
					ContactsDaoImpl.class
							+ "Error: Occur in Query While Closing Connection After Inserting the Contacts Details into Database.",
					exception);
		} finally {
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return target;
	}

	/**
	 * <p>
	 * <code>showContactsInformatin()</code>this method is design to display
	 * contacts detail into page from database for update details.
	 * </p>
	 * 
	 * @return contactsId int
	 * @throws OMIApplicationException
	 */
	/*@Override
	public Contacts showContactsInformatin(int contactsId) throws Exception {

		contacts = new Contacts();

		try {

			connection = getConnection();
			String query = QueryMaker.GET_CONTACTS_DETAILS;
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, contactsId);
			resultSet = preparedStatement.executeQuery();
			NameHelper nameHelper = new NameHelper();
			while (resultSet.next()) {
				contacts.setContactId(resultSet.getInt("CONTACT_ID"));
				contacts.setSalutation(resultSet.getString("SALUTATION"));
				contacts.setContactperson(resultSet.getString("CONTACT_PERSON"));

				if (resultSet.getInt("GROUP_NAME_REF") == -1) {

					contacts.setGroupName(OMIConstants.COMPANY_INDIVIDUAL);

				} else {

					contacts.setGroupName(resultSet.getString("GROUP_NAME_REF"));
				}

				contacts.setNickName(resultSet.getString("NICK_NAME"));

				contacts.setDesignation(resultSet.getString("DESIGNATION_REF"));
				contacts.setPhoneNumber(resultSet.getInt("PHONE_NUMBER"));
				contacts.setReferredBy(resultSet.getString("REFERRED_BY"));
				contacts.setMobileNo(resultSet.getString("MOBILE_NUMBER1"));
				contacts.setMobileNumber(resultSet.getString("MOBILE_NUMBER2"));
				contacts.setEmailId(resultSet.getString("EMAIL_ID"));

				contacts.setFax(resultSet.getInt("FAX"));
				contacts.setAddressLine1(resultSet
						.getString("HOME_CONTACT_ADDRESS_LINE1"));
				contacts.setAddressLine2(resultSet
						.getString("HOME_CONTACT_ADDRESS_LINE2"));

				contacts.setCity(resultSet.getString("HOME_CONTACT_CITY"));
				contacts.setState(resultSet.getString("HOME_CONTACT_STATE"));

				contacts.setCountryName(resultSet
						.getString("HOME_CONTACT_COUNTRY_REF"));

				contacts.setZipcode(resultSet.getString("HOME_CONTACT_ZIPCODE"));
				contacts.setPhone(resultSet.getInt("HOME_CONTACT_PHONE_NUMBER"));
				contacts.setHomeContactMobile(resultSet
						.getString("HOME_CONTACT_MOBILE_NUMBER"));

				contacts.setHomeContactEmailID(resultSet
						.getString("HOME_CONTACT_EMAIL_ID"));
				contacts.setHomeContactFax(resultSet
						.getInt("HOME_CONTACT_FAX_NUMBER"));
				contacts.setWorkContactAddressOne(resultSet
						.getString("WORK_CONTACT_ADDRESS_LINE1"));
				contacts.setWorkContactAddressTwo(resultSet
						.getString("WORK_CONTACT_ADDRESS_LINE2"));

				contacts.setWorkContactCity(resultSet
						.getString("WORK_CONTACT_CITY"));
				contacts.setWorkContactState(resultSet
						.getString("WORK_CONTACT_STATE"));
				contacts.setWorkContactCountryName(resultSet
						.getString("WORK_CONTACT_COUNTRY_REF"));
				contacts.setWorkContactZipCode(resultSet
						.getString("WORK_CONTACT_ZIPCODE"));
				contacts.setWorkContactPhone(resultSet
						.getInt("WORK_CONTACT_PHONE_NUMBER"));
				contacts.setWorkContactMobile(resultSet
						.getString("WORK_CONTACT_MOBILE_NUMBER"));
				contacts.setWorkContactEmailId(resultSet
						.getString("WORK_CONTACT_EMAIL_ID"));
				contacts.setWorkContactFax(resultSet
						.getInt("WORK_CONTACT_FAX_NUMBER"));

				contacts.setProfileDescription(resultSet
						.getString("PROFILE_DESCRIPTION"));

				contacts.setCreatedByName(nameHelper.getCustomerName(resultSet
						.getInt("CREATED_BY")));
				contacts.setCreationDate(DateTimeUtil
						.convertDatetoFormDate(resultSet
								.getString("CREATED_DATE")));
			}

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					ContactsDaoImpl.class
							+ ": Error:- Error: Occur in Query While fetching the contacts details for view from Database",
					sqlException);

		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					ContactsDaoImpl.class
							+ ": Error:- While closing the Connection after fetching the contacts details for view from Database",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return contacts;
	}*/
	
	
	/**
	 * <p>
	 * <code>insertContactsDetails()</code>this method is design to insert contact
	 * details into database
	 * </p>
	 * 6
	 * 
	 * @param ContactsVO
	 *            contactsVO, String filePath,String referenceId
	 * @return in
	 * @throws Exception
	 */

	@Override
	public int insertContactsDetails(ContactsVO contactsVO) throws Exception {
		
		int target = 0;
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.ADD_CONTACTS_DETAIL);
			preparedStatement.setString(1, contactsVO.getSalutation());
			preparedStatement.setString(2, contactsVO.getAccountName());
			preparedStatement.setString(3, contactsVO.getDesignation());
			preparedStatement.setString(4, contactsVO.getNickName());
			preparedStatement.setString(5, contactsVO.getPhoneNumber());
			
			preparedStatement.setString(6, contactsVO.getPhoneNumberIsd());
			
			preparedStatement.setString(7, contactsVO.getPhoneNumberStd());
			System.out.println("******"+contactsVO.getPhoneNumberStd());
			preparedStatement.setString(8, contactsVO.getReferredBy());
			
			preparedStatement.setString(9, contactsVO.getMobileNum1());
			preparedStatement.setString(10, contactsVO.getMobileNum1Isd());
			preparedStatement.setString(11, contactsVO.getEmailId());
			preparedStatement.setString(12, contactsVO.getTitle());
			preparedStatement.setString(13, contactsVO.getDepartment());
			preparedStatement.setString(14, contactsVO.getReportsTo());
			preparedStatement.setString(15, contactsVO.getReference());
			preparedStatement.setString(16, contactsVO.getReferenceId());
			preparedStatement.setString(17, contactsVO.getAssignedTo());
			preparedStatement.setString(18, contactsVO.getDoNotCall());
			System.out.println("******"+contactsVO.getDoNotCall());
			preparedStatement.setString(19, contactsVO.getNotifyOwner());
			preparedStatement.setString(20, contactsVO.getEmailOptOut());
			preparedStatement.setString(21, contactsVO.getSlaName());
			preparedStatement.setString(22, contactsVO.getHomeContAddLine1());
			preparedStatement.setString(23, contactsVO.getHomeContAddLine2());
			preparedStatement.setString(24, contactsVO.getHomeContCity());
			preparedStatement.setString(25, contactsVO.getHomeContState());
			preparedStatement.setString(26, contactsVO.getHomeContCountry());
			preparedStatement.setString(27, contactsVO.getHomeContZipcode());
			preparedStatement.setString(28, contactsVO.getHomeContPhoneNum());
			preparedStatement.setString(29, contactsVO.getHomeContPhoneNumIsd());
			preparedStatement.setString(30, contactsVO.getHomeContPhoneNumStd());
			preparedStatement.setString(31, contactsVO.getHomeContMobileNum());
			preparedStatement.setString(32, contactsVO.getHomeContMobileNumIsd());
			preparedStatement.setString(33, contactsVO.getHomeContEmailId());
			preparedStatement.setString(34, contactsVO.getHomeContFaxNum());
			
			preparedStatement.setString(35, contactsVO.getHomeContFaxNumIsd());
			
			preparedStatement.setString(36, contactsVO.getHomeContFaxnumStd());
			
			preparedStatement.setString(37, contactsVO.getWorkContAddLine1());
			
			preparedStatement.setString(38, contactsVO.getWorkContAddLine2());
			
			preparedStatement.setString(39, contactsVO.getWorkContCity());
			
			preparedStatement.setString(40, contactsVO.getWorkContState());
			
			preparedStatement.setString(41, contactsVO.getWorkContCountry());
			
			preparedStatement.setString(42, contactsVO.getWorkContZipcode());
			
			preparedStatement.setString(43, contactsVO.getWorkContPhoneNum());
			
			preparedStatement.setString(44, contactsVO.getWorkContPhoneIsd());
			
			preparedStatement.setString(45, contactsVO.getWorkContPhoneStd());
			
			preparedStatement.setString(46, contactsVO.getWorkContMobileNum());
			
			preparedStatement.setString(47, contactsVO.getWorkContMobileNumIsd());
			
			preparedStatement.setString(48, contactsVO.getWorkContEmailId());
			
			preparedStatement.setString(49, contactsVO.getWorkContFaxNum());
			
			preparedStatement.setString(50, contactsVO.getWorkContFaxNumIsd());
			
			preparedStatement.setString(51, contactsVO.getWorkContFaxNumStd());
			
			preparedStatement.setString(52, contactsVO.getProfileDescription());
			
			preparedStatement.setString(53, DateTimeUtil.getCurrentDate());
			preparedStatement.setInt(54, contactsVO.getCreatedBy());
			
			preparedStatement.setString(55, contactsVO.getContactperson());
			preparedStatement.setString(56, contactsVO.getLeadSource());
			
			preparedStatement.setString(57, contactsVO.getHomeContAlternateEmailId());
			
			preparedStatement.setString(58, contactsVO.getHomewebsite());
			preparedStatement.setString(59, contactsVO.getWorkWebsite());
			preparedStatement.setString(60, contactsVO.getStatus());
			preparedStatement.setString(61, contactsVO.getCustomerCenterUser());
			preparedStatement.setString(62, DateTimeUtil.convertToDate(contactsVO.getSupportStartDate()));
			preparedStatement.setString(63, DateTimeUtil.convertToDate(contactsVO.getSupportEndDate()));
			preparedStatement.setString(64, contactsVO.getMobileNum2());
			preparedStatement.setString(65, contactsVO.getMobileNum2Isd());
			preparedStatement.setString(66, contactsVO.getFax());
			preparedStatement.setString(67, contactsVO.getFaxIsd());
			preparedStatement.setString(68, contactsVO.getFaxStd());
			preparedStatement.setString(69, contactsVO.getWorkContAlternateEmailId());
			preparedStatement.setString(70, DateTimeUtil.convertToDate(contactsVO.getDob()));
			
			
			

			preparedStatement.executeUpdate();
			target = 1;

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					ContactsDaoImpl.class
							+ ": Error:- Error: Occur in Query While Inserting the Contact details in Database",
					sqlException);

		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					ContactsDaoImpl.class
							+ ": Error:- While closing the Connection after Inserting the Contact details in Database",
					exception);
		} finally {

			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}

		return target;
		
}

	@Override
	public List<ContactsVO> getContactsList() throws Exception {
		ArrayList<ContactsVO> contactsList = new ArrayList<ContactsVO>();
		try {

			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_CONTACT_DETAILS);
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {
					ContactsVO contactsVO = new ContactsVO();
					contactsVO.setContactId(resultSet
							.getInt("CONTACT_ID"));
					
					contactsVO.setContactperson(resultSet
							.getString("CONTACT_PERSON"));
					
					
					contactsVO.setWorkContEmailId(resultSet
							.getString("WORK_CONTACT_EMAIL_ID"));
					contactsVO.setMobileNum1(resultSet
							.getString("MOBILE_NUMBER1"));
					contactsVO.setWorkContMobileNum(resultSet
							.getString("WORK_CONTACT_MOBILE_NUMBER"));
					contactsList.add(contactsVO);
				}
			}

		} catch (SQLException sqlExp) {
			sqlExp.printStackTrace();
			logger.error(
					ContactsDaoImpl.class
							+ "Error: Occur in Query While Fetching  Contact Details  from Database.",
					sqlExp);
		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					ContactsDaoImpl.class
							+ "Error: Occur in Query While Closing Connection After  Contact Details   from Database.",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return contactsList;
	}

	@Override
	public Contacts showContactsInformatin(int contactsId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	
	/**
	 * <p>
	 * <code>editContactsDetail()</code>method is design to edit contact details
	 *  
	 * 
	 * @return SUCCESS
	 * @throws Exception
	 */
	@Override
	public Contacts editContactsDetail(int contactId) throws Exception {
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_CONTACTS_EDIT);
			preparedStatement.setInt(1, contactId);
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {
					contacts = new Contacts();
					contacts.setContactId(resultSet.getInt("CONTACT_ID"));
					contacts.setSalutation(resultSet.getString("SALUTATION"));
							
					contacts.setContactperson(resultSet.getString("CONTACT_PERSON"));
					System.out.println("*****************"+resultSet.getString("CONTACT_PERSON"));

					
					contacts.setNickName(resultSet.getString("NICK_NAME"));

					contacts.setDesignation(resultSet
							.getString("DESIGNATION_REF"));
					contacts.setPhoneNumber(resultSet.getString("PHONE_NUMBER"));
					contacts.setPhoneNumberIsd(resultSet.getString("PHONE_NUMBER_ISD"));
					contacts.setPhoneNumberStd(resultSet.getString("PHONE_NUMBER_STD"));
					
					contacts.setReferredBy(resultSet.getString("REFERRED_BY"));
					
					contacts.setDepartment(resultSet.getString("DEPARTMENT"));
					
					
					contacts.setReportsTo(resultSet.getString("REPORTS_TO"));
					contacts.setReference(resultSet
							.getString("REFERENCE"));
					contacts.setLeadSource(resultSet
							.getString("LEAD_SOURCE_REF"));

					contacts.setAssignedTo(resultSet.getString("ASSIGN_TO"));
					contacts.setDoNotCall(resultSet.getString("DO_NOT_CALL"));

					contacts.setNotifyOwner(resultSet
							.getString("NOTIFY_OWNER"));

					contacts.setEmailOptOut(resultSet.getString("EMAIL_OPT_OUT"));
					contacts.setSlaName(resultSet.getString("SLA_NAME"));
					contacts.setCustomerCenterUser(resultSet
							.getString("CUSTOMER_CENTER_USER"));
					contacts.setSupportStartDate(resultSet
							.getString("SUPPORT_START_DATE"));
					contacts.setSupportEndDate(resultSet
							.getString("SUPPORT_END_DATE"));
					
					
					contacts.setMobileNum1(resultSet
							.getString("MOBILE_NUMBER1"));
					contacts.setMobileNum1Isd(resultSet
							.getString("MOBILE_NUMBER1_ISD"));

					contacts.setMobileNum2(resultSet
							.getString("MOBILE_NUMBER2"));
					contacts.setMobileNum2Isd(resultSet
							.getString("MOBILE_NUMBER2_ISD"));
					contacts.setEmailId(resultSet
									.getString("EMAIL_ID"));
					
					contacts.setFax(resultSet
							.getString("FAX"));
					contacts.setFaxIsd(resultSet
							.getString("FAX_ISD"));
					contacts.setFaxStd(resultSet
							.getString("FAX_STD"));
					contacts.setHomeContAddLine1(resultSet
							.getString("HOME_CONTACT_ADDRESS_LINE1"));
					contacts.setHomeContAddLine2(resultSet
							.getString("HOME_CONTACT_ADDRESS_LINE2"));

					contacts.setHomeContCity(resultSet
							.getString("HOME_CONTACT_CITY"));

					contacts.setHomeContState(resultSet
							.getString("HOME_CONTACT_STATE"));
					contacts.setHomeContCountry(resultSet
							.getString("HOME_CONTACT_COUNTRY_REF"));
					contacts.setHomeContZipcode(resultSet
							.getString("HOME_CONTACT_ZIPCODE"));
					contacts.setHomeContPhoneNum(resultSet
							.getString("HOME_CONTACT_PHONE_NUMBER"));
					contacts.setHomeContPhoneNumIsd(resultSet
							.getString("HOME_CONTACT_PHONE_NUMBER_ISD"));
					contacts.setHomeContPhoneNumStd(resultSet
							.getString("HOME_CONTACT_PHONE_NUMBER_STD"));
					contacts.setHomeContMobileNum(resultSet
							.getString("HOME_CONTACT_MOBILE_NUMBER"));
					
					contacts.setHomeContMobileNumIsd(resultSet
							.getString("HOME_CONTACT_MOBILE_NUMBER_ISD"));
					contacts.setHomeContEmailId(resultSet
							.getString("HOME_CONTACT_EMAIL_ID"));
					contacts.setHomeContAlternateEmailId(resultSet
							.getString("HOME_CONTACT_ALTERNATE_EMAIL_ID"));
					contacts.setHomeContFaxNum(resultSet
							.getString("HOME_CONTACT_FAX_NUMBER"));
					contacts.setHomeContFaxNumIsd(resultSet
							.getString("HOME_CONTACT_FAX_NUMBER_ISD"));
					contacts.setHomeContFaxnumStd(resultSet
							.getString("HOME_CONTACT_FAX_NUMBER_STD"));
					contacts.setHomewebsite(resultSet
							.getString("HOME_WEBSITE"));
					contacts.setWorkContAddLine1(resultSet
							.getString("WORK_CONTACT_ADDRESS_LINE1"));
					contacts.setWorkContAddLine2(resultSet
							.getString("WORK_CONTACT_ADDRESS_LINE2"));
					contacts.setWorkContCity(resultSet
							.getString("WORK_CONTACT_CITY"));
					contacts.setWorkContState(resultSet
							.getString("WORK_CONTACT_STATE"));
					contacts.setWorkContCountry(resultSet
							.getString("WORK_CONTACT_COUNTRY_REF"));
					contacts.setWorkContZipcode(resultSet
							.getString("WORK_CONTACT_ZIPCODE"));
					contacts.setWorkContPhoneNum(resultSet
							.getString("WORK_CONTACT_PHONE_NUMBER"));
					contacts.setWorkContPhoneIsd(resultSet
							.getString("WORK_CONTACT_PHONE_NUMBER_ISD"));
					contacts.setWorkContPhoneStd(resultSet
							.getString("WORK_CONTACT_PHONE_NUMBER_STD"));
					contacts.setWorkContMobileNum(resultSet
							.getString("WORK_CONTACT_MOBILE_NUMBER"));
					contacts.setWorkContMobileNumIsd(resultSet
							.getString("WORK_CONTACT_MOBILE_NUMBER_ISD"));
					contacts.setWorkContEmailId(resultSet
							.getString("WORK_CONTACT_EMAIL_ID"));
					contacts.setWorkContAlternateEmailId(resultSet
							.getString("WORK_CONTACT_ALTERNATE_EMAIL_ID"));
					contacts.setWorkContFaxNum(resultSet
							.getString("WORK_CONTACT_FAX_NUMBER"));
					contacts.setWorkContFaxNumIsd(resultSet
							.getString("WORK_CONTACT_FAX_NUMBER_ISD"));
					contacts.setWorkContFaxNumStd(resultSet
							.getString("WORK_CONTACT_FAX_NUMBER_STD"));
					contacts.setWorkWebsite(resultSet
							.getString("WORK_WEBSITE"));
					contacts.setProfileDescription(resultSet
							.getString("PROFILE_DESCRIPTION"));
					
					contacts.setReferenceId(resultSet
							.getString("REFERANCE_ID"));
					contacts.setCreatedDate(resultSet
							.getString("CREATED_DATE"));
					contacts.setCreatedBy(resultSet
							.getInt("CREATED_BY"));
					contacts.setTitle(resultSet
							.getString("TITTLE"));
					contacts.setDob(resultSet
							.getString("DATE_OF_BIRTH"));
					contacts.setStatus(resultSet
							.getString("STATUS"));

				}
			}
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					ContactsDaoImpl.class
							+ ": Error:- Error: Occur in Query While fetching the Contact details from Database",
					sqlException);

		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					ContactsDaoImpl.class
							+ ": Error:- While closing the Connection after fetching the Contact details from Database",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return contacts;
	}

	@Override
	public int getContactsDetailsForUpdate(ContactsVO contactsVO, int contactId)
			throws Exception {
		int target = 0;

		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.UPDATE_CONTACTS_DETAILS);

			preparedStatement.setString(1, contactsVO.getSalutation());
			preparedStatement.setString(2, contactsVO.getAccountName());
			preparedStatement.setString(3, contactsVO.getDesignation());
			preparedStatement.setString(4, contactsVO.getNickName());
			preparedStatement.setString(5, contactsVO.getPhoneNumber());
			
			preparedStatement.setString(6, contactsVO.getPhoneNumberIsd());
			
			preparedStatement.setString(7, contactsVO.getPhoneNumberStd());
			
			preparedStatement.setString(8, contactsVO.getReferredBy());
			
			preparedStatement.setString(9, contactsVO.getMobileNum1());
			preparedStatement.setString(10, contactsVO.getMobileNum1Isd());
			preparedStatement.setString(11, contactsVO.getEmailId());
			preparedStatement.setString(12, contactsVO.getTitle());
			preparedStatement.setString(13, contactsVO.getDepartment());
			preparedStatement.setString(14, contactsVO.getReportsTo());
			preparedStatement.setString(15, contactsVO.getReference());
			preparedStatement.setString(16, contactsVO.getReferenceId());
			preparedStatement.setString(17, contactsVO.getAssignedTo());
			preparedStatement.setString(18, contactsVO.getDoNotCall());
			
			preparedStatement.setString(19, contactsVO.getNotifyOwner());
			preparedStatement.setString(20, contactsVO.getEmailOptOut());
			preparedStatement.setString(21, contactsVO.getSlaName());
			preparedStatement.setString(22, contactsVO.getHomeContAddLine1());
			preparedStatement.setString(23, contactsVO.getHomeContAddLine2());
			preparedStatement.setString(24, contactsVO.getHomeContCity());
			preparedStatement.setString(25, contactsVO.getHomeContState());
			preparedStatement.setString(26, contactsVO.getHomeContCountry());
			preparedStatement.setString(27, contactsVO.getHomeContZipcode());
			preparedStatement.setString(28, contactsVO.getHomeContPhoneNum());
			preparedStatement.setString(29, contactsVO.getHomeContPhoneNumIsd());
			preparedStatement.setString(30, contactsVO.getHomeContPhoneNumStd());
			preparedStatement.setString(31, contactsVO.getHomeContMobileNum());
			preparedStatement.setString(32, contactsVO.getHomeContMobileNumIsd());
			preparedStatement.setString(33, contactsVO.getHomeContEmailId());
			preparedStatement.setString(34, contactsVO.getHomeContFaxNum());
			
			preparedStatement.setString(35, contactsVO.getHomeContFaxNumIsd());
			
			preparedStatement.setString(36, contactsVO.getHomeContFaxnumStd());
			
			preparedStatement.setString(37, contactsVO.getWorkContAddLine1());
			
			preparedStatement.setString(38, contactsVO.getWorkContAddLine2());
			
			preparedStatement.setString(39, contactsVO.getWorkContCity());
			
			preparedStatement.setString(40, contactsVO.getWorkContState());
			
			preparedStatement.setString(41, contactsVO.getWorkContCountry());
			
			preparedStatement.setString(42, contactsVO.getWorkContZipcode());
			
			preparedStatement.setString(43, contactsVO.getWorkContPhoneNum());
			
			preparedStatement.setString(44, contactsVO.getWorkContPhoneIsd());
			
			preparedStatement.setString(45, contactsVO.getWorkContPhoneStd());
			
			preparedStatement.setString(46, contactsVO.getWorkContMobileNum());
			
			preparedStatement.setString(47, contactsVO.getWorkContMobileNumIsd());
			
			preparedStatement.setString(48, contactsVO.getWorkContEmailId());
			
			preparedStatement.setString(49, contactsVO.getWorkContFaxNum());
			
			preparedStatement.setString(50, contactsVO.getWorkContFaxNumIsd());
			
			preparedStatement.setString(51, contactsVO.getWorkContFaxNumStd());
			
			preparedStatement.setString(52, contactsVO.getProfileDescription());
			
			preparedStatement.setString(53, DateTimeUtil.getCurrentDate());
			preparedStatement.setInt(54, contactsVO.getCreatedBy());
			
			preparedStatement.setString(55, contactsVO.getContactperson());
			preparedStatement.setString(56, contactsVO.getLeadSource());
			
			preparedStatement.setString(57, contactsVO.getHomeContAlternateEmailId());
			
			preparedStatement.setString(58, contactsVO.getHomewebsite());
			preparedStatement.setString(59, contactsVO.getWorkWebsite());
			preparedStatement.setString(60, contactsVO.getStatus());
			preparedStatement.setString(61, contactsVO.getCustomerCenterUser());
			preparedStatement.setString(62, DateTimeUtil.convertToDate(contactsVO.getSupportStartDate()));
			preparedStatement.setString(63, DateTimeUtil.convertToDate(contactsVO.getSupportEndDate()));
			preparedStatement.setString(64, contactsVO.getMobileNum2());
			preparedStatement.setString(65, contactsVO.getMobileNum2Isd());
			preparedStatement.setString(66, contactsVO.getFax());
			preparedStatement.setString(67, contactsVO.getFaxIsd());
			preparedStatement.setString(68, contactsVO.getFaxStd());
			preparedStatement.setString(69, contactsVO.getWorkContAlternateEmailId());
			preparedStatement.setString(70, DateTimeUtil.convertToDate(contactsVO.getDob()));
			preparedStatement.setInt(71, contactId);
			preparedStatement.executeUpdate();
			target = 1;

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					ContactsDaoImpl.class
							+ ": Error:- Error: Occur in Query While fetching the Contact details from Database",
					sqlException);

		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					ContactsDaoImpl.class
							+ ": Error:- While closing the Connection after fetching the Contact details from Database",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return target;
	}

	@Override
	public void contactsPDF(HttpServletRequest request,
			HttpServletResponse response, int contactId) {
		String companyName = "Chouksay Traders";
		String address1= "BUS STAND SHAMSHABAD, DIST.- VIDISHA, MADHYA PRADESH, 464001";
		String address2="GSTIN: 23AJQPC8200P1Z1";
		String address3="PAN NO: AJQPC8200P";

		String city = "Vidisha-464001";
		String state = "(M.P.)";
		StringBuffer stringBuffer = null;

		try {

			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.SHOW_CONTACTS_PRINT_PDF);
			preparedStatement.setInt(1, contactId);
			resultSet = preparedStatement.executeQuery();
			Document document = new Document(PageSize.A4);

			Font Font3 = new Font(Font.FontFamily.TIMES_ROMAN, 11, Font.NORMAL);
			Font Font2 = new Font(Font.FontFamily.TIMES_ROMAN, 6,
					Font.STRIKETHRU);
			Font Font4 = new Font(Font.FontFamily.TIMES_ROMAN, 11, Font.BOLD);
			Font4.setColor(BaseColor.WHITE);
			Font mainContent = new Font(Font.FontFamily.TIMES_ROMAN, 10,
					Font.NORMAL);
			Font Font5 = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
			Font5.setColor(BaseColor.GRAY);
			Font Font6 = new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.BOLD);
			Font6.setColor(BaseColor.RED);

			// Output
			response.setContentType("application/pdf");

			PdfWriter.getInstance(document, response.getOutputStream());

			document.open();
			// header
			String contextPath = ServletActionContext.getServletContext()
					.getRealPath("/outer/img/bir3.png");
			image = Image.getInstance(contextPath);
			image.scaleToFit(130, 70);

			PdfPTable table1 = new PdfPTable(2);
			table1.setWidthPercentage(100);
			Rectangle rect1 = new Rectangle(300, 700);
			table1.setWidthPercentage(new float[] { 150, 150 }, rect1);

			PdfPCell cell101 = new PdfPCell(image, false);
			cell101.setPaddingTop(5);
			cell101.setBorder(Rectangle.NO_BORDER);

			Phrase phrase3 = new Phrase(companyName + "\n", Font5);
			Phrase phrase = new Phrase(address1 + "\n", Font3);
			Phrase phrase1 = new Phrase(address2 + "\n", Font3);
			Phrase phrase4 = new Phrase(address3 + "\n", Font3);
			Phrase phrase2 = new Phrase(city + "-" + state, Font3);

			Paragraph paragraph = new Paragraph();
			paragraph.add(phrase3);
			paragraph.add(phrase);
			paragraph.add(phrase1);
			paragraph.add(phrase4);
			paragraph.add(phrase2);
			
			PdfPCell cell102 = new PdfPCell(paragraph);
			cell102.setPaddingTop(5);
			cell102.setBorder(Rectangle.NO_BORDER);
			cell102.setHorizontalAlignment(Element.ALIGN_RIGHT);

			PdfPCell cell103 = new PdfPCell(
					new Paragraph(
							"   \n                                                                                        "
									+ "                                                                                                                            "
									+ "                                                                                                                              ",
							Font2));
			cell103.setColspan(2);
			cell103.setBorderWidthRight(0f);
			cell103.setBorderWidthLeft(0f);
			cell103.setBorderWidthTop(0.5f);
			cell103.setBorderWidthBottom(0f);
			cell103.setBorderColorTop(BaseColor.WHITE);

			PdfPCell cell104 = new PdfPCell(new Paragraph("CONTACTS REPORT", Font4));
			cell104.setUseBorderPadding(true);
			cell104.setColspan(2);
			cell104.setBorderWidthRight(0.1f);
			cell104.setBorderWidthLeft(0.1f);
			cell104.setBorderWidthTop(0.1f);
			cell104.setBorderWidthBottom(0.1f);
			cell104.setBorderColor(BaseColor.LIGHT_GRAY);
			cell104.setBackgroundColor(new BaseColor(0, 59, 119));

			table1.addCell(cell101);
			table1.addCell(cell102);
			table1.addCell(cell103);
			table1.addCell(cell104);
			document.add(table1);

			// End Header

			// Fetching the Records for Design Details and setting it into right
			// column of table.
			while (resultSet.next()) {
				stringBuffer = new StringBuffer();
				PdfPTable table = new PdfPTable(2);
				table.setFooterRows(1);
				table.setWidthPercentage(100);
				Rectangle rect = new Rectangle(300, 700);
				table.setWidthPercentage(new float[] { 80, 220 }, rect);

				PdfPCell cell = new PdfPCell(new Paragraph());
				cell.setColspan(2);
				cell.setBorderWidthRight(0.1f);
				cell.setBorderWidthLeft(0.1f);
				cell.setBorderWidthTop(0.1f);
				cell.setBorderWidthBottom(0.2f);
				cell.setBorderColor(BaseColor.LIGHT_GRAY);
				cell.setBackgroundColor(new BaseColor(238, 238, 238));

				PdfPCell cell1 = new PdfPCell(new Paragraph("Contact Information",
						Font6));
				cell1.setBackgroundColor(new BaseColor(238, 238, 238));
				cell1.setBorderWidth(0.01f);
				cell1.setBorderColor(BaseColor.WHITE);

				PdfPCell cell2 = new PdfPCell(new Paragraph());
				cell2.setBackgroundColor(new BaseColor(238, 238, 238));
				cell2.setBorderWidth(0.2f);
				cell2.setBorderColor(BaseColor.WHITE);

				PdfPCell cell3 = new PdfPCell(new Paragraph("Contact Person",
						mainContent));
				cell3.setBackgroundColor(new BaseColor(238, 238, 238));
				cell3.setBorderWidth(0.01f);
				cell3.setBorderColor(BaseColor.WHITE);

				PdfPCell cell4 = new PdfPCell(new Paragraph(resultSet.getString("CONTACT_PERSON"), mainContent));
				cell4.setBorderWidth(0.2f);
				cell4.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell5 = new PdfPCell(new Paragraph(
						"Nick Name", mainContent));
				cell5.setBackgroundColor(new BaseColor(238, 238, 238));
				cell5.setBorderWidth(0.01f);
				cell5.setBorderColor(BaseColor.WHITE);

				PdfPCell cell6 = new PdfPCell(new Paragraph(resultSet.getString("NICK_NAME"), mainContent));
				cell6.setBorderWidth(0.2f);
				cell6.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell7 = new PdfPCell(new Paragraph("Designation",
						mainContent));
				cell7.setBackgroundColor(new BaseColor(238, 238, 238));
				cell7.setBorderWidth(0.01f);
				cell7.setBorderColor(BaseColor.WHITE);

				PdfPCell cell8 = new PdfPCell(new Paragraph(
						resultSet.getString("DESIGNATION_REF"), mainContent));
				cell8.setBorderWidth(0.2f);
				cell8.setBorderColor(BaseColor.LIGHT_GRAY);

				

				PdfPCell cell9 = new PdfPCell(new Paragraph("Phone Number",
						 mainContent));
				cell9.setBorderWidth(0.2f);
				cell9.setBorderColor(BaseColor.LIGHT_GRAY);
				
				PdfPCell cell10 = new PdfPCell(new Paragraph(
						resultSet.getString("PHONE_NUMBER"), mainContent));
				cell10.setBorderWidth(0.2f);
				cell10.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell11 = new PdfPCell(new Paragraph("Referred By",
						mainContent));
				cell11.setBackgroundColor(new BaseColor(238, 238, 238));
				cell11.setBorderWidth(0.01f);
				cell11.setBorderColor(BaseColor.WHITE);

				PdfPCell cell12 = new PdfPCell(new Paragraph(resultSet.getString("REFERRED_BY"), mainContent));
				cell12.setBorderWidth(0.2f);
				cell12.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell13 = new PdfPCell(new Paragraph("Mobile Number",
						mainContent));
				cell13.setBackgroundColor(new BaseColor(238, 238, 238));
				cell13.setBorderWidth(0.01f);
				cell13.setBorderColor(BaseColor.WHITE);

				PdfPCell cell14 = new PdfPCell(new Paragraph(resultSet.getString("MOBILE_NUMBER1"), mainContent));
				cell14.setBorderWidth(0.2f);
				cell14.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell15 = new PdfPCell(new Paragraph(
						"Email ID", mainContent));
				cell15.setBackgroundColor(new BaseColor(238, 238, 238));
				cell15.setBorderWidth(0.01f);
				cell15.setBorderColor(BaseColor.WHITE);

				PdfPCell cell16 = new PdfPCell(new Paragraph(resultSet.getString("EMAIL_ID"), mainContent));
				cell16.setBorderWidth(0.2f);
				cell16.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell17 = new PdfPCell(new Paragraph("Home Address Line 1",
						mainContent));
				cell17.setBackgroundColor(new BaseColor(238, 238, 238));
				cell17.setBorderWidth(0.01f);
				cell17.setBorderColor(BaseColor.WHITE);

				PdfPCell cell18 = new PdfPCell(new Paragraph(resultSet.getString("HOME_CONTACT_ADDRESS_LINE1"), mainContent));
				cell18.setBorderWidth(0.2f);
				cell18.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell19 = new PdfPCell(new Paragraph("Home Address Line 2",
						mainContent));
				cell19.setBackgroundColor(new BaseColor(238, 238, 238));
				cell19.setBorderWidth(0.01f);
				cell19.setBorderColor(BaseColor.WHITE);

				PdfPCell cell20 = new PdfPCell(new Paragraph(resultSet.getString("HOME_CONTACT_ADDRESS_LINE2"), mainContent));
				cell20.setBorderWidth(0.2f);
				cell20.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell21 = new PdfPCell(new Paragraph("City",
						mainContent));
				cell21.setBackgroundColor(new BaseColor(238, 238, 238));
				cell21.setBorderWidth(0.01f);
				cell21.setBorderColor(BaseColor.WHITE);

				PdfPCell cell22 = new PdfPCell(new Paragraph(resultSet.getString("HOME_CONTACT_CITY"), mainContent));
				cell22.setBorderWidth(0.2f);
				cell22.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell23 = new PdfPCell(new Paragraph(
						"State", mainContent));
				cell23.setBackgroundColor(new BaseColor(238, 238, 238));
				cell23.setBorderWidth(0.01f);
				cell23.setBorderColor(BaseColor.WHITE);

				PdfPCell cell24 = new PdfPCell(
						new Paragraph(resultSet.getString(
								"HOME_CONTACT_STATE"),
								mainContent));
				cell24.setBorderWidth(0.2f);
				cell24.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell25 = new PdfPCell(new Paragraph("Country",
						mainContent));
				cell25.setBackgroundColor(new BaseColor(238, 238, 238));
				cell25.setBorderWidth(0.01f);
				cell25.setBorderColor(BaseColor.WHITE);

				PdfPCell cell26 = new PdfPCell(new Paragraph(
						resultSet.getString("HOME_CONTACT_COUNTRY_REF"), mainContent));
				cell26.setBorderWidth(0.2f);
				cell26.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell27 = new PdfPCell(new Paragraph("Zipcode",
						mainContent));
				cell27.setBackgroundColor(new BaseColor(238, 238, 238));
				cell27.setBorderWidth(0.01f);
				cell27.setBorderColor(BaseColor.WHITE);

				PdfPCell cell28 = new PdfPCell(new Paragraph(
						(resultSet
								.getString("HOME_CONTACT_ZIPCODE")), mainContent));
				cell28.setBorderWidth(0.2f);
				cell28.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell29 = new PdfPCell(new Paragraph(
						"Phone Number", mainContent));
				cell29.setBackgroundColor(new BaseColor(238, 238, 238));
				cell29.setBorderWidth(0.01f);
				cell29.setBorderColor(BaseColor.WHITE);

				PdfPCell cell30 = new PdfPCell(new Paragraph(
						(resultSet
								.getString("HOME_CONTACT_PHONE_NUMBER")),
						mainContent));
				cell30.setBorderWidth(0.2f);
				cell30.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell31 = new PdfPCell(new Paragraph(
						"Mobile Number", Font6));
				cell31.setBackgroundColor(new BaseColor(238, 238, 238));
				cell31.setBorderWidth(0.01f);
				cell31.setBorderColor(BaseColor.WHITE);
				
				PdfPCell cell32 = new PdfPCell(new Paragraph(
						(resultSet
								.getString("HOME_CONTACT_MOBILE_NUMBER")),
						mainContent));
				cell32.setBorderWidth(0.2f);
				cell32.setBorderColor(BaseColor.LIGHT_GRAY);
				
				PdfPCell cell33 = new PdfPCell(new Paragraph(
						"Email ID", Font6));
				cell33.setBackgroundColor(new BaseColor(238, 238, 238));
				cell33.setBorderWidth(0.01f);
				cell33.setBorderColor(BaseColor.WHITE);
				
				PdfPCell cell34 = new PdfPCell(new Paragraph(
						(resultSet
								.getString("HOME_CONTACT_EMAIL_ID")),
						mainContent));
				cell34.setBorderWidth(0.2f);
				cell34.setBorderColor(BaseColor.LIGHT_GRAY);
				
				PdfPCell cell35 = new PdfPCell(new Paragraph(
						"Fax", Font6));
				cell35.setBackgroundColor(new BaseColor(238, 238, 238));
				cell35.setBorderWidth(0.01f);
				cell35.setBorderColor(BaseColor.WHITE);
				
				PdfPCell cell36 = new PdfPCell(new Paragraph(
						(resultSet
								.getString("HOME_CONTACT_FAX_NUMBER")),
						mainContent));
				cell36.setBorderWidth(0.2f);
				cell36.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell37 = new PdfPCell(new Paragraph());
				cell37.setBackgroundColor(new BaseColor(238, 238, 238));
				cell37.setBorderWidth(0.2f);
				cell37.setBorderColor(BaseColor.WHITE);

				PdfPCell cell38 = new PdfPCell(new Paragraph());
				cell38.setBackgroundColor(new BaseColor(238, 238, 238));
				cell38.setBorderWidth(0.2f);
				cell38.setBorderColor(BaseColor.WHITE);

				
				PdfPCell cell39 = new PdfPCell(new Paragraph("Work Adress Line 1",
						mainContent));
				cell39.setBackgroundColor(new BaseColor(238, 238, 238));
				cell39.setBorderWidth(0.01f);
				cell39.setBorderColor(BaseColor.WHITE);

				PdfPCell cell40 = new PdfPCell(new Paragraph(
						resultSet.getString("WORK_CONTACT_ADDRESS_LINE1"), mainContent));
				cell40.setBorderWidth(0.2f);
				cell40.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell41 = new PdfPCell(new Paragraph("Work Adress Line 2",
						mainContent));
				cell41.setBackgroundColor(new BaseColor(238, 238, 238));
				cell41.setBorderWidth(0.01f);
				cell41.setBorderColor(BaseColor.WHITE);

				PdfPCell cell42 = new PdfPCell(new Paragraph(
						resultSet.getString("WORK_CONTACT_ADDRESS_LINE2"), mainContent));
				cell42.setBorderWidth(0.2f);
				cell42.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell43 = new PdfPCell(new Paragraph("City",
						mainContent));
				cell43.setBackgroundColor(new BaseColor(238, 238, 238));
				cell43.setBorderWidth(0.01f);
				cell43.setBorderColor(BaseColor.WHITE);

				PdfPCell cell44 = new PdfPCell(new Paragraph(
						resultSet.getString("WORK_CONTACT_CITY"), mainContent));
				cell44.setBorderWidth(0.2f);
				cell44.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell45 = new PdfPCell(new Paragraph("State",
						mainContent));
				cell45.setBackgroundColor(new BaseColor(238, 238, 238));
				cell45.setBorderWidth(0.01f);
				cell45.setBorderColor(BaseColor.WHITE);

				PdfPCell cell46 = new PdfPCell(new Paragraph(
						resultSet.getString("WORK_CONTACT_STATE"), mainContent));
				cell46.setBorderWidth(0.2f);
				cell46.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell47 = new PdfPCell(new Paragraph("Country",
						mainContent));
				cell47.setBackgroundColor(new BaseColor(238, 238, 238));
				cell47.setBorderWidth(0.01f);
				cell47.setBorderColor(BaseColor.WHITE);

				PdfPCell cell48 = new PdfPCell(new Paragraph(resultSet.getString("WORK_CONTACT_COUNTRY_REF"), mainContent));
				cell48.setBorderWidth(0.2f);
				cell48.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell49 = new PdfPCell(new Paragraph("ZipCode",
						mainContent));
				cell49.setBackgroundColor(new BaseColor(238, 238, 238));
				cell49.setBorderWidth(0.01f);
				cell49.setBorderColor(BaseColor.WHITE);

				PdfPCell cell50 = new PdfPCell(new Paragraph(
						resultSet.getString("WORK_CONTACT_ZIPCODE"), mainContent));
				cell50.setBorderWidth(0.2f);
				cell50.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell51 = new PdfPCell(new Paragraph("Phone Number",
						mainContent));
				cell51.setBackgroundColor(new BaseColor(238, 238, 238));
				cell51.setBorderWidth(0.01f);
				cell51.setBorderColor(BaseColor.WHITE);

				PdfPCell cell52= new PdfPCell(new Paragraph(
						resultSet.getString("WORK_CONTACT_PHONE_NUMBER"), mainContent));
				cell52.setBorderWidth(0.2f);
				cell52.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell53 = new PdfPCell(new Paragraph("Mobile Number",
						mainContent));
				cell53.setBackgroundColor(new BaseColor(238, 238, 238));
				cell53.setBorderWidth(0.01f);
				cell53.setBorderColor(BaseColor.WHITE);

				PdfPCell cell54 = new PdfPCell(new Paragraph(
						resultSet.getString("WORK_CONTACT_MOBILE_NUMBER"), mainContent));
				cell54.setBorderWidth(0.2f);
				cell54.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell55 = new PdfPCell(new Paragraph(
						"Email ID", mainContent));
				cell55.setBackgroundColor(new BaseColor(238, 238, 238));
				cell55.setBorderWidth(0.01f);
				cell55.setBorderColor(BaseColor.WHITE);

				PdfPCell cell56 = new PdfPCell(new Paragraph(
						resultSet.getString("WORK_CONTACT_EMAIL_ID"), mainContent));
				cell56.setBorderWidth(0.2f);
				cell56.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell57 = new PdfPCell(new Paragraph(
						"Fax", mainContent));
				cell57.setBackgroundColor(new BaseColor(238, 238, 238));
				cell57.setBorderWidth(0.01f);
				cell57.setBorderColor(BaseColor.WHITE);

				PdfPCell cell58 = new PdfPCell(new Paragraph(
						resultSet.getString("WORK_CONTACT_FAX_NUMBER"),
						mainContent));
				cell58.setBorderWidth(0.2f);
				cell58.setBorderColor(BaseColor.LIGHT_GRAY);

				

				

				table.addCell(cell);
				table.addCell(cell1);
				table.addCell(cell2);
				table.addCell(cell3);
				table.addCell(cell4);
				table.addCell(cell5);
				table.addCell(cell6);
				table.addCell(cell7);
				table.addCell(cell8);
				table.addCell(cell9);
				table.addCell(cell10);
				table.addCell(cell11);
				table.addCell(cell12);
				table.addCell(cell13);
				table.addCell(cell14);
				table.addCell(cell15);
				table.addCell(cell16);
				table.addCell(cell17);
				table.addCell(cell18);
				table.addCell(cell19);
				table.addCell(cell20);
				table.addCell(cell21);
				table.addCell(cell22);
				table.addCell(cell23);
				table.addCell(cell24);
				table.addCell(cell25);
				table.addCell(cell26);
				table.addCell(cell27);
				table.addCell(cell28);
				table.addCell(cell29);
				table.addCell(cell30);
				table.addCell(cell31);
				table.addCell(cell32);
				table.addCell(cell33);
				table.addCell(cell34);
				table.addCell(cell35);
				table.addCell(cell36);
				table.addCell(cell37);
				table.addCell(cell38);
				table.addCell(cell39);
				table.addCell(cell40);
				table.addCell(cell41);
				table.addCell(cell42);
				table.addCell(cell43);
				table.addCell(cell44);
				table.addCell(cell45);
				table.addCell(cell46);
				table.addCell(cell47);
				table.addCell(cell48);
				table.addCell(cell49);
				table.addCell(cell50);
				table.addCell(cell51);
				table.addCell(cell52);
				table.addCell(cell53);
				table.addCell(cell54);
				table.addCell(cell55);
				table.addCell(cell56);
				table.addCell(cell57);
				table.addCell(cell58);
				
				
				

				document.add(table);
			}
			// Footer

			document.add(new Paragraph("\n"));
			document.add(new Paragraph(
					"© 2016 BirjaSoft Technologies. All Rights Reserved.",
					mainContent));
			document.close();
			// End Footer
		} catch (SQLException sqlExp) {
			sqlExp.printStackTrace();
			logger.error(
					ContactsDaoImpl.class
							+ "Error: Occur in Query While Fetching All Contact Details for print PdF from Database.",
					sqlExp);
		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					ContactsDaoImpl.class
							+ "Error: Occur in Query While Closing Connection After Fetching All Contact Details for print PdF from Database.",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}

	}

	@Override
	public int getContactLastRecord() throws Exception {
		int temp = 0;
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_CONTACTS_LAST_RECORD_ID);
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {

					temp = resultSet.getInt("CONTACT_ID");

				}
			}
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					ContactsDaoImpl.class
							+ ": Error:- Error: Occur in Query While counting the Contact recods from Database",
					sqlException);

		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					ContactsDaoImpl.class
							+ ": Error:- While closing the Connection after counting the Contact recods from Database",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return temp;
	}
	

	@Override
	public Contacts getContactDetails(int contactId) throws Exception {
		contacts = new Contacts();
		StringBuffer sb=null;
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.SHOW_VIEW_CONTACTS);
			preparedStatement.setInt(1, contactId);
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {
					sb = new StringBuffer();
					contacts.setContactId(resultSet.getInt("CONTACT_ID"));
					sb.append(
							Salutation.getSalutation(resultSet.getInt("SALUTATION")))
							.append(" ")
							.append(resultSet.getString("CONTACT_PERSON"));
					contacts.setContactperson(sb.toString());

					
					contacts.setNickName(resultSet.getString("NICK_NAME"));

					contacts.setDesignation(nameHelper.getDesignationName(resultSet
							.getInt("DESIGNATION_REF")));
					contacts.setPhoneNumber(resultSet.getString("PHONE_NUMBER"));
					
					contacts.setReferredBy(resultSet.getString("REFERRED_BY"));
					
					contacts.setDepartment(resultSet.getString("DEPARTMENT"));
					
					
					contacts.setReportsTo(resultSet.getString("REPORTS_TO"));
					contacts.setReference(resultSet
							.getString("REFERENCE"));
					contacts.setLeadSource(resultSet
							.getString("LEAD_SOURCE_REF"));

					contacts.setAssignedTo(resultSet.getString("ASSIGN_TO"));
					contacts.setDoNotCall(resultSet.getString("DO_NOT_CALL"));

					contacts.setNotifyOwner(resultSet
							.getString("NOTIFY_OWNER"));

					contacts.setEmailOptOut(resultSet.getString("EMAIL_OPT_OUT"));
					contacts.setSlaName(resultSet.getString("SLA_NAME"));
					contacts.setCustomerCenterUser(resultSet
							.getString("CUSTOMER_CENTER_USER"));

					
					contacts.setMobileNum1(resultSet
							.getString("MOBILE_NUMBER1"));
					contacts.setMobileNum1Isd(resultSet
							.getString("MOBILE_NUMBER1_ISD"));

					contacts.setMobileNum2(resultSet
							.getString("MOBILE_NUMBER2"));
					contacts.setMobileNum2Isd(resultSet
							.getString("MOBILE_NUMBER2_ISD"));
					contacts.setEmailId(resultSet
									.getString("EMAIL_ID"));
					
					contacts.setFax(resultSet
							.getString("FAX"));
					contacts.setFaxIsd(resultSet
							.getString("FAX_ISD"));
					contacts.setFaxStd(resultSet
							.getString("FAX_STD"));
					contacts.setHomeContAddLine1(resultSet
							.getString("HOME_CONTACT_ADDRESS_LINE1"));
					contacts.setHomeContAddLine2(resultSet
							.getString("HOME_CONTACT_ADDRESS_LINE2"));

					contacts.setHomeContCity(resultSet
							.getString("HOME_CONTACT_CITY"));

					contacts.setHomeContState(resultSet
							.getString("HOME_CONTACT_STATE"));
					contacts.setHomeContCountry(resultSet
							.getString("HOME_CONTACT_COUNTRY_REF"));
					contacts.setHomeContZipcode(resultSet
							.getString("HOME_CONTACT_ZIPCODE"));
					contacts.setHomeContPhoneNum(resultSet
							.getString("HOME_CONTACT_PHONE_NUMBER"));
					contacts.setHomeContPhoneNumIsd(resultSet
							.getString("HOME_CONTACT_PHONE_NUMBER_ISD"));
					contacts.setHomeContPhoneNumStd(resultSet
							.getString("HOME_CONTACT_PHONE_NUMBER_STD"));
					contacts.setHomeContMobileNum(resultSet
							.getString("HOME_CONTACT_MOBILE_NUMBER"));
					
					contacts.setHomeContMobileNumIsd(resultSet
							.getString("HOME_CONTACT_MOBILE_NUMBER_ISD"));
					contacts.setHomeContEmailId(resultSet
							.getString("HOME_CONTACT_EMAIL_ID"));
					contacts.setHomeContAlternateEmailId(resultSet
							.getString("HOME_CONTACT_ALTERNATE_EMAIL_ID"));
					contacts.setHomeContFaxNum(resultSet
							.getString("HOME_CONTACT_FAX_NUMBER"));
					contacts.setHomeContFaxNumIsd(resultSet
							.getString("HOME_CONTACT_FAX_NUMBER_ISD"));
					contacts.setHomeContFaxnumStd(resultSet
							.getString("HOME_CONTACT_FAX_NUMBER_STD"));
					contacts.setHomewebsite(resultSet
							.getString("HOME_WEBSITE"));
					contacts.setWorkContAddLine1(resultSet
							.getString("WORK_CONTACT_ADDRESS_LINE1"));
					contacts.setWorkContAddLine2(resultSet
							.getString("WORK_CONTACT_ADDRESS_LINE2"));
					contacts.setWorkContCity(resultSet
							.getString("WORK_CONTACT_CITY"));
					contacts.setWorkContState(resultSet
							.getString("WORK_CONTACT_STATE"));
					contacts.setWorkContCountry(resultSet
							.getString("WORK_CONTACT_COUNTRY_REF"));
					contacts.setWorkContZipcode(resultSet
							.getString("WORK_CONTACT_ZIPCODE"));
					contacts.setWorkContPhoneNum(resultSet
							.getString("WORK_CONTACT_PHONE_NUMBER"));
					contacts.setWorkContPhoneIsd(resultSet
							.getString("WORK_CONTACT_PHONE_NUMBER_ISD"));
					contacts.setWorkContPhoneStd(resultSet
							.getString("WORK_CONTACT_PHONE_NUMBER_STD"));
					contacts.setWorkContMobileNum(resultSet
							.getString("WORK_CONTACT_MOBILE_NUMBER"));
					contacts.setWorkContMobileNumIsd(resultSet
							.getString("WORK_CONTACT_MOBILE_NUMBER_ISD"));
					contacts.setWorkContEmailId(resultSet
							.getString("WORK_CONTACT_EMAIL_ID"));
					contacts.setWorkContAlternateEmailId(resultSet
							.getString("WORK_CONTACT_ALTERNATE_EMAIL_ID"));
					contacts.setWorkContFaxNum(resultSet
							.getString("WORK_CONTACT_FAX_NUMBER"));
					contacts.setWorkContFaxNumIsd(resultSet
							.getString("WORK_CONTACT_FAX_NUMBER_ISD"));
					contacts.setWorkContFaxNumStd(resultSet
							.getString("WORK_CONTACT_FAX_NUMBER_STD"));
					contacts.setWorkWebsite(resultSet
							.getString("WORK_WEBSITE"));
					contacts.setProfileDescription(resultSet
							.getString("PROFILE_DESCRIPTION"));
					
					contacts.setReferenceId(resultSet
							.getString("REFERANCE_ID"));
					contacts.setCreatedDate(resultSet
							.getString("CREATED_DATE"));
					contacts.setCreatedBy(resultSet
							.getInt("CREATED_BY"));
					contacts.setTitle(resultSet
							.getString("TITTLE"));
					contacts.setDob(resultSet
							.getString("DATE_OF_BIRTH"));
					contacts.setStatus(resultSet
							.getString("STATUS"));

				}
			}
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					LeadDaoImpl.class
							+ ": Error:- Error: Occur in Query While fetching the Lead details for view from Database",
					sqlException);

		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					LeadDaoImpl.class
							+ ": Error:- While closing the Connection after fetching the Lead details for view from Database",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return contacts;
	}
	
}
