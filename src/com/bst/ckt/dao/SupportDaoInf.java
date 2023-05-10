package com.bst.ckt.dao;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bst.ckt.dto.SupportCases;
import com.bst.ckt.dto.SupportFaq;
import com.bst.ckt.dto.SupportServiceContact;
import com.bst.ckt.dto.SupportTicket;
import com.bst.ckt.exception.OMIApplicationException;
import com.bst.ckt.vo.ServiceContactVo;
import com.bst.ckt.vo.SupportCasesVO;
import com.bst.ckt.vo.SupportFaqVO;
import com.bst.ckt.vo.TicketVO;

/**
 * 
 * @author ROHIT GURJAR
 * 
 */
public interface SupportDaoInf {

	/**
	 * <p>
	 * <code>insertFaq</code>Method will insertFaq data from TAB_SUPPORT_FAQ
	 * </p>
	 * 
	 * @return
	 * @throws OMIApplicationException
	 * @param SupportFaqVO
	 *            supportFaqVO
	 */
	public int insertFaq(SupportFaqVO supportFaqVO) throws Exception;

	/**
	 * <p>
	 * <code>getFaqGrid</code>Method will fetch data from TAB_SUPPORT_FAQ
	 * </p>
	 * 
	 * @return List<SupportFaqVO>
	 * @throws OMIApplicationException
	 * @param SupportFaqVO
	 *            supportFaqVO
	 */
	public List<SupportFaqVO> getFaqGrid() throws Exception;

	/**
	 * <p>
	 * <code>viewFaqDetail</code>Method will view data from based faqId
	 * </p>
	 * 
	 * @return SupportFaq
	 * @throws OMIApplicationException
	 * @param int faqId
	 */
	public SupportFaq viewFaqDetail(int faqId) throws Exception;

	/**
	 * <p>
	 * <code>editFaqDetail</code>Method will edit data from based faqId
	 * </p>
	 * 
	 * @return SupportFaq
	 * @throws OMIApplicationException
	 * @param int faqId
	 */
	public SupportFaq editFaqDetail(int faqId) throws Exception;

	/**
	 * <p>
	 * <code>updateFaqDetail</code>Method will update data from based faqId
	 * </p>
	 * 
	 * @return
	 * 
	 * @return
	 * @throws OMIApplicationException
	 * @param (SupportFaqVO supportFaqVO, int faqId)
	 */
	public int updateFaqDetail(SupportFaqVO supportFaqVO, int faqId)
			throws Exception;

	/**
	 * <p>
	 * <code>insertCases</code>Method will insert Cases data from database
	 * </p>
	 * 
	 * @return
	 * 
	 * @return
	 * @throws OMIApplicationException
	 * @param (SupportCasesVO supportCasesVO)
	 */
	public int insertCases(SupportCasesVO supportCasesVO) throws Exception;

	/**
	 * <p>
	 * <code>getCasesGrid</code>Method will show data from TAB_SUPPORT_CASES
	 * </p>
	 * 
	 * @return List<SupportCasesVO>
	 * @throws OMIApplicationException
	 * @param
	 */
	public List<SupportCasesVO> getCasesGrid() throws OMIApplicationException;

	/**
	 * <p>
	 * <code>updateCasesDetail</code>Method will update data from based casesId
	 * </p>
	 * 
	 * @return
	 * 
	 * @return
	 * @throws OMIApplicationException
	 * @param (SupportCasesVO supportCasesVO, int casesId)
	 */
	public int updateCasesDetail(SupportCasesVO supportCasesVO, int casesId)
			throws Exception;

	/**
	 * <p>
	 * <code>editCasesDetail</code>Method will edit data from based casesId
	 * </p>
	 * 
	 * @return SupportCases
	 * @throws OMIApplicationException
	 * @param int casesId
	 */
	public SupportCases editCasesDetail(int casesId) throws Exception;

	/**
	 * <p>
	 * <code>viewCasesDetail</code>Method will view data from based casesId
	 * </p>
	 * 
	 * @return SupportCases
	 * @throws OMIApplicationException
	 * @param int casesId
	 */
	public SupportCases viewCasesDetail(int casesId) throws Exception;

	/**
	 * <p>
	 * <code>deleteSupportFaqDetail</code>Method will delete data from based
	 * faqId
	 * </p>
	 * 
	 * @throws OMIApplicationException
	 * @param int casesId
	 */
	public int deleteSupportFaqDetail(int faqId) throws OMIApplicationException;

	/**
	 * <p>
	 * <code>deleteSupportCasesDetail</code>Method will delete data from based
	 * casesId
	 * </p>
	 * 
	 * @throws OMIApplicationException
	 * @param int casesId
	 */
	public int deleteSupportCasesDetail(int casesId) throws OMIApplicationException;

	/**
	 * <p>
	 * <code>deleteTicketDetail</code>Method will delete data from based
	 * ticketId
	 * </p>
	 * 
	 * @throws OMIApplicationException
	 * @param int ticketId
	 */
	public void deleteTicketDetail(int ticketId) throws Exception;

	/**
	 * <p>
	 * <code>viewTicketDetail</code>Method will view data from based ticketId
	 * </p>
	 * 
	 * @return SupportTicket
	 * @throws OMIApplicationException
	 * @param int ticketId
	 */
	public SupportTicket viewTicketDetail(int ticketId) throws Exception;

	/**
	 * <p>
	 * <code>updateTicketDetail</code>Method will update data from based
	 * ticketId
	 * </p>
	 * 
	 * @return ticketVO
	 * @throws OMIApplicationException
	 * @param (TicketVO ticketVO, int ticketId)
	 */
	public int updateTicketDetail(TicketVO ticketVO, int ticketId)
			throws Exception;

	/**
	 * <p>
	 * <code>editTicketDetail</code>Method will edit data from based ticketId
	 * </p>
	 * 
	 * @return supportTicket
	 * @throws OMIApplicationException
	 * @param int ticketId
	 */
	public SupportTicket editTicketDetail(int ticketId) throws Exception;

	/**
	 * <p>
	 * <code>getTicketGrid</code>Method will show data from TAB_SUPPORT_TICKET
	 * </p>
	 * 
	 * @return List<SupportCasesVO>
	 * @throws OMIApplicationException
	 * @param
	 */
	public List<TicketVO> getTicketGrid() throws Exception;

	/*
	 * public List<TicketVO> getTicketGrid(int searchId, String searchValue)
	 * throws Exception;
	 */
	/**
	 * <p>
	 * <code>insertTicket</code>Method will insert ticket data from
	 * TAB_SUPPORT_TICKET
	 * </p>
	 * 
	 * @return
	 * @throws OMIApplicationException
	 * @param TicketVO
	 *            ticketVO
	 */

	public int insertTicket(TicketVO ticketVO) throws Exception;

	/**
	 * <p>
	 * <code>getFaqLastRecord</code>Method will faq Last Record data from
	 * TAB_SUPPORT_FAQ
	 * </p>
	 * 
	 * @return
	 * @throws OMIApplicationException
	 * @param
	 */

	public int getFaqLastRecord() throws Exception;

	/**
	 * <p>
	 * <code>getFaqDetails</code>Method will fetch faq detail data from
	 * TAB_SUPPORT_FAQ
	 * </p>
	 * 
	 * @return SupportFaq
	 * @throws OMIApplicationException
	 * @param int faqId
	 */

	public SupportFaq getFaqDetails(int faqId) throws Exception;

	/**
	 * <p>
	 * <code>getFaqDetailsForUpdate</code>Method will fetch get Faq Details For
	 * Update data from TAB_SUPPORT_FAQ
	 * </p>
	 * 
	 * @return SupportFaq
	 * @throws OMIApplicationException
	 * @param int faqId
	 */

	public SupportFaq getFaqDetailsForUpdate(int faqId) throws Exception;

	/**
	 * <p>
	 * <code>getCasesLastRecord</code>Method will Cases Last Record data from
	 * TAB_SUPPORT_CASES
	 * </p>
	 * 
	 * @return
	 * @throws OMIApplicationException
	 * @param
	 */

	public int getCasesLastRecord() throws Exception;

	/**
	 * <p>
	 * <code>getCasesDetails</code>Method will fetch Cases detail data from
	 * TAB_SUPPORT_CASES
	 * </p>
	 * 
	 * @return SupportCases
	 * @throws OMIApplicationException
	 * @param int casesId
	 */

	public SupportCases getCasesDetails(int casesId) throws Exception;

	/**
	 * <p>
	 * <code>getCasesDetailsForUpdate</code>Method will fetch get Cases Details
	 * For Update data from TAB_SUPPORT_CASES
	 * </p>
	 * 
	 * @return SupportCases
	 * @throws OMIApplicationException
	 * @param int casesId
	 */

	public SupportCases getCasesDetailsForUpdate(int casesId) throws Exception;

	/**
	 * <p>
	 * <code>getTicketDetails</code>Method will fetch get Ticket Details data
	 * from TAB_SUPPORT_TICKET
	 * </p>
	 * 
	 * @return SupportTicket
	 * @throws OMIApplicationException
	 * @param int ticketId
	 */

	public SupportTicket getTicketDetails(int ticketId) throws Exception;

	/**
	 * <p>
	 * <code>getTicketDetailsForUpdate</code>Method will fetch get Ticket
	 * Details For Update data from TAB_SUPPORT_TICKET
	 * </p>
	 * 
	 * @return SupportTicket
	 * @throws OMIApplicationException
	 * @param int ticketId
	 */

	public SupportTicket getTicketDetailsForUpdate(int ticketId)
			throws Exception;

	/**
	 * <p>
	 * <code>getTicketLastRecord</code>Method will fetch get Ticket Details For
	 * Update data from TAB_SUPPORT_TICKET
	 * </p>
	 * 
	 * @return
	 * @throws OMIApplicationException
	 * @param
	 */

	public int getTicketLastRecord() throws Exception;

	/**
	 * <P>
	 * <CODE>getFaqDetailsGrid()</CODE> METHOD IS USE TO FATCH faq Detail FROM
	 * DATABASE
	 * </P>
	 * 
	 * @return List<SupportFaqVO>
	 * @throws Exception
	 * @param int searchId, String searchValue
	 */

	public List<SupportFaqVO> getFaqDetailsGrid(int searchId, String searchValue)
			throws Exception;

	/**
	 * <P>
	 * <CODE>getCasesDetailsGrid()</CODE> METHOD IS USE TO FATCH Cases Detail
	 * FROM DATABASE
	 * </P>
	 * 
	 * @return List<SupportCasesVO>
	 * @throws Exception
	 * @param int searchId, String searchValue
	 */

	public List<SupportCasesVO> getCasesDetailsGrid(int searchId,
			String searchValue) throws OMIApplicationException;

	/**
	 * <P>
	 * <CODE>getTicketDetailsGrid()</CODE> METHOD IS USE TO FATCH Cases Detail
	 * FROM DATABASE
	 * </P>
	 * 
	 * @return List<TicketVO>
	 * @throws Exception
	 * @param int searchId, String searchValue
	 */

	public List<TicketVO> getTicketDetailsGrid(int searchId, String searchValue)
			throws Exception;

	/**
	 * <p>
	 * <code>getServiceContactLastRecord</code>Method will fetch get Service
	 * Details For Update data from TAB_SUPPORT_SERVICE_CONTACT
	 * </p>
	 * 
	 * @return
	 * @throws OMIApplicationException
	 * @param
	 */

	public int getServiceContactLastRecord() throws Exception;

	/**
	 * <p>
	 * <code>insertServiceContact</code>Method will insert Service Contact
	 * detail For data from TAB_SUPPORT_SERVICE_CONTACT 
	 * </p>
	 * 
	 * @return
	 * @throws OMIApplicationException
	 * @param ServiceContactVo
	 *            serviceContactVo
	 */

	public int insertServiceContact(ServiceContactVo serviceContactVo)
			throws Exception;

	/**
	 * <p>
	 * <code>getServiceContactGrid</code>Method will show data from
	 * TAB_SUPPORT_SERVICE_CONTACT
	 * </p>
	 * 
	 * @return List<ServiceContactVo>
	 * @throws OMIApplicationException
	 * @param
	 */
	public List<ServiceContactVo> getServiceContactGrid() throws Exception;

	/**
	 * <p>
	 * <code>updateServiceContact</code>Method will update Service Contact For
	 * data based serviceContactId
	 * </p>
	 * 
	 * @return
	 * @throws OMIApplicationException
	 * @param ServiceContactVo
	 *            serviceContactVo
	 */

	public int updateServiceContact(ServiceContactVo serviceContactVo,
			int serviceContactId);

	/**
	 * <p>
	 * <code>deleteServiceContactDetail</code>Method will delete Service Contact
	 * For data based serviceContactId
	 * </p>
	 * 
	 * @return
	 * @throws OMIApplicationException
	 * @param int serviceContactId
	 */

	public void deleteServiceContactDetail(int serviceContactId)
			throws Exception;

	/**
	 * <p>
	 * <code>getServiceContactDetail</code>Method will fetch Service Contact For
	 * data based TAB_SUPPORT_SERVICE_CONTACT
	 * </p>
	 * 
	 * @return SupportServiceContact
	 * @throws OMIApplicationException
	 * @param int serviceContactId
	 */

	public SupportServiceContact getServiceContactDetail(int serviceContactId)
			throws Exception;

	/**
	 * <p>
	 * <code>getServiceContactForUpdate</code>Method will update Service Contact
	 * For data based serviceContactId
	 * </p>
	 * 
	 * @return SupportServiceContact
	 * @throws OMIApplicationException
	 * @param int serviceContactId
	 */

	public SupportServiceContact getServiceContactForUpdate(int serviceContactId)
			throws Exception;

	/**
	 * <p>
	 * <code>getServiceContact</code>Method will fetch Service Contact For data
	 * based serviceContactId
	 * </p>
	 * 
	 * @return SupportServiceContact
	 * @throws OMIApplicationException
	 * @param int serviceContactId
	 */

	public SupportServiceContact getServiceContact(int serviceContactId)
			throws Exception;

	/**
	 * <p>
	 * <code>editServiceContact</code>Method will edit Service Contact For data
	 * based serviceContactId
	 * </p>
	 * 
	 * @return SupportServiceContact
	 * @throws OMIApplicationException
	 * @param int serviceContactId
	 */

	public SupportServiceContact editServiceContact(int serviceContactId)
			throws Exception;

	/**
	 * <p>
	 * <code>viewServiceContact</code>Method will View Service Contact For data
	 * based serviceContactId
	 * </p>
	 * 
	 * @return SupportServiceContact
	 * @throws OMIApplicationException
	 * @param int serviceContactId
	 */

	public SupportServiceContact viewServiceContact(int serviceContactId)
			throws Exception;

	/**
	 * <P>
	 * <CODE>getServiceContactSearchGird()</CODE> METHOD IS USE TO FATCH SERVICE
	 * CONTACT FROM DATABASE
	 * </P>
	 * 
	 * @return List<ServiceContactVo>
	 * @throws Exception
	 * @param int searchId, String searchValue
	 */

	public List<ServiceContactVo> getServiceContactSearchGird(int searchId,
			String searchValue) throws Exception;
	/**
	 * <P>
	 * <CODE>CasesReportPDF()</CODE> METHOD IS USE TO VIEW THE CASES REPORT
	 * </P>
	 * 
	 * @return 
	 * @throws Exception
	 * @param  request, response
	 * @param casesId
	 * @author Rosu patel
	 */
	public void CasesReportPDF(HttpServletRequest request,
			HttpServletResponse response, int casesId)throws Exception;
	/**
	 * <P>
	 * <CODE>faqPDFReport()</CODE> METHOD IS USE TO VIEW THE FAQ REPORT
	 * </P>
	 * 
	 * @return 
	 * @throws Exception
	 * @param  request, response
	 * @param casesId
	 * @author Rosu patel
	 */
	public void faqPDFReport(HttpServletRequest request,
			HttpServletResponse response, int faqId)throws Exception;
	/**
	 * <P>
	 * <CODE>ticketPrintPDF()</CODE> METHOD IS USE TO VIEW THE TICKET REPORT
	 * </P>
	 * 
	 * @return 
	 * @throws Exception
	 * @param  request, response
	 * @param ticketId
	 * @author Rosu patel
	 */
	public void ticketPrintPDF(HttpServletRequest request,
			HttpServletResponse response, int ticketId)throws Exception;
	/**
	 * <P>
	 * <CODE>showProductName()</CODE> METHOD IS USE TO VIEW THE PRODUCT NAME
	 * </P>
	 * 
	 * @return 
	 * @throws Exception
	 * @param productName
	 * @author Rosu patel
	 */
	public List<SupportFaqVO> showProductName()throws OMIApplicationException;
	/**
	 * <P>
	 * <CODE>isProductNameExist()</CODE> METHOD IS USE TO IS NAME IS Existed
	 * </P>
	 * 
	 * @return 
	 * @throws Exception
	 * @param  
	 * @param productName
	 * @author Rosu patel
	 */
	public int isProductNameExist(String productName)throws OMIApplicationException;
	/**
	 * <P>
	 * <CODE>insertProductName()</CODE> METHOD IS USE TO VIEW PRODUCT NAME
	 * </P>
	 * 
	 * @return 
	 * @throws Exception
	 * @param  
	 * @param productName
	 * @author Rosu patel
	 */
	public void insertProductName(SupportFaqVO supportFaqVO)throws OMIApplicationException;
	/**
	 * <P>
	 * <CODE>insertCasesProductName()</CODE> METHOD IS USE TO VIEW PRODUCT NAME
	 * </P>
	 * 
	 * @return 
	 * @throws Exception
	 * @param  
	 * @param productName
	 * @author Rosu patel
	 */
	public int insertCasesProductName(SupportCasesVO supportCasesVO)throws OMIApplicationException;
	/**
	 * <P>
	 * <CODE>showContactName()</CODE> METHOD IS USE TO VIEW CONNTACT NAME
	 * </P>
	 * 
	 * @return 
	 * @throws Exception
	 * @param  
	 * @param contactName
	 * @author Rosu patel
	 */
	public List<SupportCasesVO> showContactName()throws OMIApplicationException;
	/**
	 * <P>
	 * <CODE>isContectNameExist()</CODE> METHOD IS USE TO IS NAME EXISTED
	 * </P>
	 * 
	 * @return 
	 * @throws Exception
	 * @param  
	 * @param contactName
	 * @author Rosu patel
	 */
	public int isContectNameExist(String contactName)throws OMIApplicationException;
	/**
	 * <P>
	 * <CODE>insertContactName()</CODE> METHOD IS USE TO INSERTED CONTACT NAME
	 * </P>
	 * 
	 * @return 
	 * @throws Exception
	 * @param  
	 * @param contactName
	 * @author Rosu patel
	 */
	public void insertContactName(SupportCasesVO supportCasesVO)throws OMIApplicationException;
	/**
	 * <P>
	 * <CODE>showOrganizationName()</CODE> METHOD IS USE TO VIEW ORGANIZATION NAME
	 * </P>
	 * 
	 * @return 
	 * @throws Exception
	 * @param  
	 * @param organizationNAme
	 * @author Rosu patel
	 */
	public List<SupportCasesVO> showOrganizationName()throws OMIApplicationException;
	/**
	 * <P>
	 * <CODE>insertOrganizationName()</CODE> METHOD IS USE TO INSERTED ORGANIZATION NAME
	 * </P>
	 * 
	 * @return 
	 * @throws Exception
	 * @param  
	 * @param organizationNAme
	 * @author Rosu patel
	 */
	public void insertOrganizationName(SupportCasesVO supportCasesVO)throws OMIApplicationException;
	/**
	 * <P>
	 * <CODE>isOrganizationNameExist()</CODE> METHOD IS USE TO IS EXISTED ORGANIZATION NAME
	 * </P>
	 * 
	 * @return 
	 * @throws Exception
	 * @param  
	 * @param organizationNAme
	 * @author Rosu patel
	 */
	public int isOrganizationNameExist(String contactName)throws OMIApplicationException;
	/**
	 * <P>
	 * <CODE>insertTicketProductName()</CODE> METHOD IS USE TO INSERTED PRODUCT NAME
	 * </P>
	 * 
	 * @return 
	 * @throws Exception
	 * @param  
	 * @param productNAme
	 * @author Rosu patel
	 */
	public int insertTicketProductName(TicketVO ticketVO)throws OMIApplicationException;
	/**
	 * <P>
	 * <CODE>showTicketProductName()</CODE> METHOD IS USE TO VIEW PRODUCT NAME
	 * </P>
	 * 
	 * @return 
	 * @throws Exception
	 * @param  
	 * @param productNAme
	 * @author Rosu patel
	 */
	public List<TicketVO> showTicketProductName()throws OMIApplicationException;
	/**
	 * <P>
	 * <CODE>isContactNameExist()</CODE> METHOD IS USE TO IS EXISTED CONTACT  NAME
	 * </P>
	 * 
	 * @return 
	 * @throws Exception
	 * @param  
	 * @param contactNAme
	 * @author Rosu patel
	 */
	public int isContactNameExist(String contactName)throws OMIApplicationException;
	/**
	 * <P>
	 * <CODE>insertTicketContactName()</CODE> METHOD IS USE TO INSERTED CONTACT  NAME
	 * </P>
	 * 
	 * @return 
	 * @throws Exception
	 * @param  
	 * @param contactNAme
	 * @author Rosu patel
	 */
	public void insertTicketContactName(TicketVO ticketVO)throws OMIApplicationException;
	/**
	 * <P>
	 * <CODE>showTicketContactName()</CODE> METHOD IS USE TO VIEW CONTACT  NAME
	 * </P>
	 * 
	 * @return 
	 * @throws Exception
	 * @param  
	 * @param contactNAme
	 * @author Rosu patel
	 */
	public List<TicketVO> showTicketContactName()throws OMIApplicationException;

	public HashMap<String, String> getCaseTitleList()throws OMIApplicationException;

	
	
	
	
	

}
