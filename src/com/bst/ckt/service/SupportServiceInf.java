package com.bst.ckt.service;

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
public interface SupportServiceInf {

	/**
	 * <p>
	 * <code>registerFaq</code>Method will registerFaq data from TAB_SUPPORT_FAQ
	 * </p>
	 * 
	 * @return
	 * @throws OMIApplicationException
	 * @param SupportFaqVO
	 *            supportFaqVO
	 */
	public String registerFaq(SupportFaqVO supportFaqVO) throws Exception;

	/**
	 * <p>
	 * <code>showFaqInfoGrid</code>Method will fetch data from TAB_SUPPORT_FAQ
	 * </p>
	 * 
	 * @return List<SupportFaqVO>
	 * @throws OMIApplicationException
	 * 
	 */
	public List<SupportFaqVO> showFaqInfoGrid() throws Exception;

	/**
	 * <p>
	 * <code>viewFaqInfo</code>Method will show data from based faqId
	 * </p>
	 * 
	 * @return
	 * @throws OMIApplicationException
	 * @param int faqId
	 */
	public SupportFaq viewFaqInfo(int faqId) throws Exception;

	/**
	 * <p>
	 * <code>editFaqInfo</code>Method will edit data from from based faqId
	 * </p>
	 * 
	 * @return
	 * @throws OMIApplicationException
	 * @param int faqId
	 */
	public SupportFaq editFaqInfo(int faqId) throws Exception;

	/**
	 * <p>
	 * <code>updateFaqInfo</code>Method will update data from from based faqId
	 * </p>
	 * 
	 * @return
	 * @throws OMIApplicationException
	 * @param (SupportFaqVO supportFaqVO, int faqId)
	 */
	public String updateFaqInfo(SupportFaqVO supportFaqVO, int faqId)
			throws Exception;

	/**
	 * <p>
	 * <code>registerCases</code>Method will register data from from based
	 * casesId
	 * </p>
	 * 
	 * @return
	 * @throws OMIApplicationException
	 * @param (SupportCasesVO supportCasesVO, int casesId)
	 */
	public String registerCases(SupportCasesVO supportCasesVO) throws Exception;

	/**
	 * <p>
	 * <code>showCasesInfoGrid</code>Method will fetch data from
	 * TAB_SUPPORT_CASES
	 * </p>
	 * 
	 * @return List<SupportFaqVO>
	 * @throws OMIApplicationException
	 * 
	 */
	public List<SupportCasesVO> showCasesInfoGrid() throws OMIApplicationException;

	/**
	 * <p>
	 * <code>editCasesInfo</code>Method will edit data from based casesId
	 * </p>
	 * 
	 * @return
	 * @throws OMIApplicationException
	 * @param int casesId
	 */
	public SupportCases editCasesInfo(int casesId) throws Exception;

	/**
	 * <p>
	 * <code>updateCasesInfo</code>Method will update data from from based
	 * casesId
	 * </p>
	 * 
	 * @return
	 * @throws OMIApplicationException
	 * @param (SupportCasesVO supportCasesVO, int casesId)
	 */
	public String updateCasesInfo(SupportCasesVO supportCasesVO, int casesId)
			throws Exception;

	/**
	 * <p>
	 * <code>viewCasesInfo</code>Method will show data from based casesId
	 * </p>
	 * 
	 * @return
	 * @throws OMIApplicationException
	 * @param int casesId
	 */
	public SupportCases viewCasesInfo(int casesId) throws Exception;

	/**
	 * <p>
	 * <code>removeSupportFaqDetails</code>Method will delete data from based
	 * faqId
	 * </p>
	 * 
	 * @return
	 * @throws OMIApplicationException
	 * @param int faqId
	 */
	public int removeSupportFaqDetails(int faqId) throws Exception;

	/**
	 * <p>
	 * <code>removeSupportCasesDetails</code>Method will delete data from based
	 * casesId
	 * </p>
	 * 
	 * @return
	 * @throws OMIApplicationException
	 * @param int casesId
	 */
	public int removeSupportCasesDetails(int casesId) throws OMIApplicationException;

	/**
	 * <p>
	 * <code>registerTicket</code>Method will register data from Ticket based
	 * ticketId
	 * </p>
	 * 
	 * @return
	 * @throws OMIApplicationException
	 * @param (TicketVO ticketVO)
	 */
	public String registerTicket(TicketVO ticketVO) throws Exception;

	/**
	 * <p>
	 * <code>showTicketInfoGrid</code>Method will fetch data from
	 * TAB_SUPPORT_TICKET
	 * </p>
	 * 
	 * @return List<TicketVO>
	 * @throws OMIApplicationException
	 * 
	 */
	public List<TicketVO> showTicketInfoGrid() throws Exception;

	/*
	 * public List<TicketVO> showTicketInfoGrid(TicketVO ticketVO) throws
	 * Exception;
	 */

	/**
	 * <p>
	 * <code>editTicketInfo</code>Method will edit data from based ticketId
	 * </p>
	 * 
	 * @return
	 * @throws OMIApplicationException
	 * @param int ticketId
	 */
	public SupportTicket editTicketInfo(int ticketId) throws Exception;

	/**
	 * <p>
	 * <code>viewTicketInfo</code>Method will show data from based ticketId
	 * </p>
	 * 
	 * @return
	 * @throws OMIApplicationException
	 * @param int ticketId
	 */
	public SupportTicket viewTicketInfo(int ticketId) throws Exception;

	/**
	 * <p>
	 * <code>updateTicketInfo</code>Method will update data from from based
	 * ticketId
	 * </p>
	 * 
	 * @return
	 * @throws OMIApplicationException
	 * @param (TicketVO ticketVO, int ticketId)
	 */
	public String updateTicketInfo(TicketVO ticketVO, int ticketId)
			throws Exception;

	/**
	 * <p>
	 * <code>removeTicketDetails</code>Method will delete data from based
	 * ticketId
	 * </p>
	 * 
	 * @return
	 * @throws OMIApplicationException
	 * @param int ticketId
	 */
	public void removeTicketDetails(int ticketId) throws Exception;

	/**
	 * <p>
	 * <code>viewNextFaqDetails</code>Method will Faq View data from based faqId
	 * </p>
	 * 
	 * @return
	 * @throws OMIApplicationException
	 * @param int faqId
	 */

	public SupportFaq viewNextFaqDetails(int faqId) throws Exception;

	/**
	 * <p>
	 * <code>viewPreviousFaqDetails</code>Method will view Previous Faq Details
	 * data from based faqId
	 * </p>
	 * 
	 * @return SupportFaq
	 * @throws OMIApplicationException
	 * @param int faqId
	 */

	public SupportFaq viewPreviousFaqDetails(int faqId) throws Exception;

	/**
	 * <p>
	 * <code>editNextFaqDetails</code>Method will edit Next Faq Details data
	 * from based faqId
	 * </p>
	 * 
	 * @return SupportFaq
	 * @throws OMIApplicationException
	 * @param int faqId
	 */

	public SupportFaq editNextFaqDetails(int faqId) throws Exception;

	/**
	 * <p>
	 * <code>editPreviousFaqDetails</code>Method will edit Previous Faq Details
	 * data from based faqId
	 * </p>
	 * 
	 * @return SupportFaq
	 * @throws OMIApplicationException
	 * @param int faqId
	 */

	public SupportFaq editPreviousFaqDetails(int faqId) throws Exception;

	/**
	 * <p>
	 * <code>viewNextCasesDetails</code>Method will Cases View data from based
	 * casesId
	 * </p>
	 * 
	 * @return SupportCases
	 * @throws OMIApplicationException
	 * @param int casesId
	 */

	public SupportCases viewNextCasesDetails(int casesId) throws Exception;

	/**
	 * <p>
	 * <code>viewPreviousCasesDetails</code>Method will view Previous Cases
	 * Details data from based casesId
	 * </p>
	 * 
	 * @return SupportCases
	 * @throws OMIApplicationException
	 * @param int casesId
	 */

	public SupportCases viewPreviousCasesDetails(int casesId) throws Exception;

	/**
	 * <p>
	 * <code>editNextCasesDetails</code>Method will edit Next Cases Details data
	 * from based casesId
	 * </p>
	 * 
	 * @return SupportCases
	 * @throws OMIApplicationException
	 * @param int casesId
	 */

	public SupportCases editNextCasesDetails(int casesId) throws Exception;

	/**
	 * <p>
	 * <code>editPreviousCasesDetails</code>Method will edit Previous Cases
	 * Details data from based casesId
	 * </p>
	 * 
	 * @return SupportCases
	 * @throws OMIApplicationException
	 * @param int casesId
	 */

	public SupportCases editPreviousCasesDetails(int casesId) throws Exception;

	/**
	 * <p>
	 * <code>viewNextTicketDetails</code>Method will view Next Ticket Details
	 * data from based ticketId
	 * </p>
	 * 
	 * @return SupportTicket
	 * @throws OMIApplicationException
	 * @param int ticketId
	 */

	public SupportTicket viewNextTicketDetails(int ticketId) throws Exception;

	/**
	 * <p>
	 * <code>editNextTicketDetails</code>Method will edit Next Ticket Details
	 * data from based ticketId
	 * </p>
	 * 
	 * @return SupportTicket
	 * @throws OMIApplicationException
	 * @param int ticketId
	 */

	public SupportTicket editNextTicketDetails(int ticketId) throws Exception;

	/**
	 * <p>
	 * <code>viewPreviousTicketDetails</code>Method will view Previous Ticket
	 * Details data from based ticketId
	 * </p>
	 * 
	 * @return SupportTicket
	 * @throws OMIApplicationException
	 * @param int ticketId
	 */

	public SupportTicket viewPreviousTicketDetails(int ticketId)
			throws Exception;

	/**
	 * <p>
	 * <code>editPreviousTicketDetails</code>Method will edit Previous Ticket
	 * Details data from based ticketId
	 * </p>
	 * 
	 * @return SupportTicket
	 * @throws OMIApplicationException
	 * @param int ticketId
	 */

	public SupportTicket editPreviousTicketDetails(int ticketId)
			throws Exception;

	/**
	 * <p>
	 * <code>faqDetailsGrid</code>Method will show faq Details Grid data from
	 * based faqId
	 * </p>
	 * 
	 * @return List<SupportFaqVO>
	 * @throws OMIApplicationException
	 * @param SupportFaqVO
	 *            supportFaqVO
	 */
	public List<SupportFaqVO> faqDetailsGrid(SupportFaqVO supportFaqVO)
			throws Exception;

	/**
	 * <p>
	 * <code>casesDetailsGrid</code>Method will show cases Details Grid data
	 * from based casesId
	 * </p>
	 * 
	 * @return List<SupportCasesVO>
	 * @throws OMIApplicationException
	 * @param SupportCasesVO
	 *            supportCasesVO
	 */
	public List<SupportCasesVO> casesDetailsGrid(SupportCasesVO supportCasesVO)
			throws OMIApplicationException;

	/**
	 * <p>
	 * <code>ticketDetailsGrid</code>Method will show ticket Details Grid data
	 * from based ticketId
	 * </p>
	 * 
	 * @return List<TicketVO>
	 * @throws OMIApplicationException
	 * @param TicketVO
	 *            ticketVO
	 */

	public List<TicketVO> ticketDetailsGrid(TicketVO ticketVO) throws Exception;

	/**
	 * <p>
	 * <code>registerServiceContact</code>Method will register Service Contact
	 * data from based SUPPORT_SERVICE_CONTACT
	 * </p>
	 * 
	 * @return
	 * @throws OMIApplicationException
	 * @param ServiceContactVo
	 *            ServiceContactVo
	 */

	public String registerServiceContact(ServiceContactVo ServiceContactVo)
			throws Exception;

	/**
	 * <p>
	 * <code>showServiceContactInfoGrid</code>Method will show Service Contact
	 * Info Grid data from based ticketId
	 * </p>
	 * 
	 * @return List<ServiceContactVo>
	 * @throws OMIApplicationException
	 * @param
	 */

	public List<ServiceContactVo> showServiceContactInfoGrid() throws Exception;

	/**
	 * <p>
	 * <code>serviceContactSearchList</code>Method will service Contact Search
	 * List data from based id
	 * </p>
	 * 
	 * @return List<ServiceContactVo>
	 * @throws OMIApplicationException
	 * @param ServiceContactVo
	 *            serviceContactVo
	 */

	public List<ServiceContactVo> serviceContactSearchList(
			ServiceContactVo serviceContactVo) throws Exception;

	/**
	 * <p>
	 * <code>viewServiceContactInfo</code>Method will view Service Contact Info
	 * data from based serviceContactId
	 * </p>
	 * 
	 * @return SupportServiceContact
	 * @throws OMIApplicationException
	 * @param int serviceContactId
	 */

	public SupportServiceContact viewServiceContactInfo(int serviceContactId)
			throws Exception;

	/**
	 * <p>
	 * <code>editServiceContactInfo</code>Method will edit Service Contact Info
	 * data from based serviceContactId
	 * </p>
	 * 
	 * @return SupportServiceContact
	 * @throws OMIApplicationException
	 * @param int serviceContactId
	 * 
	 */

	public SupportServiceContact editServiceContactInfo(int serviceContactId)
			throws Exception;

	/**
	 * <p>
	 * <code>updateServiceContactInfo</code>Method will update Service Contact
	 * Info data from based serviceContactId
	 * </p>
	 * 
	 * @return
	 * @throws OMIApplicationException
	 * @param ServiceContactVo
	 *            serviceContactVo
	 */

	public String updateServiceContactInfo(ServiceContactVo serviceContactVo,
			int serviceContactId) throws Exception;

	/**
	 * <p>
	 * <code>removeSupportServiceContact</code>Method will remove Support
	 * Service Contact data from based serviceContactId
	 * </p>
	 * 
	 * @return
	 * @throws OMIApplicationException
	 * @param int serviceContactId
	 */

	public void removeSupportServiceContact(int serviceContactId)
			throws Exception;

	/**
	 * <p>
	 * <code>viewNextServiceContact</code>Method will view Next Service Contact
	 * data from based serviceContactId
	 * </p>
	 * 
	 * @return SupportServiceContact
	 * @throws OMIApplicationException
	 * @param int serviceContactId
	 */

	public SupportServiceContact viewNextServiceContact(int serviceContactId)
			throws Exception;

	/**
	 * <p>
	 * <code>editNextServiceContact</code>Method will edit Next Service Contact
	 * data from based serviceContactId
	 * </p>
	 * 
	 * @return SupportServiceContact
	 * @throws OMIApplicationException
	 * @param int serviceContactId
	 */

	public SupportServiceContact editNextServiceContact(int serviceContactId)
			throws Exception;

	/**
	 * <p>
	 * <code>viewPreviousServiceContact</code>Method will view Previous Service
	 * Contact data from based serviceContactId
	 * </p>
	 * 
	 * @return SupportServiceContact
	 * @throws OMIApplicationException
	 * @param int serviceContactId
	 */

	public SupportServiceContact viewPreviousServiceContact(int serviceContactId)
			throws Exception;

	/**
	 * <p>
	 * <code>editPreviousServiceContact</code>Method will edit Previous Service
	 * Contact data from based serviceContactId
	 * </p>
	 * 
	 * @return SupportServiceContact
	 * @throws OMIApplicationException
	 * @param int serviceContactId
	 * 
	 */

	public SupportServiceContact editPreviousServiceContact(int serviceContactId)
			throws Exception;

	public void supportCasesExcelReport(HttpServletRequest request,
			HttpServletResponse response)throws Exception;
	/**
	 * <p>
	 * <code>casesPDF</code>Method will generated the pdf view the cases reports
	 * </p>
	 * 
	 * @param request,response
	 * @throws OMIApplicationException
	 * @param casesId
	 * 
	 */
	public void casesPDF(HttpServletRequest request,
			HttpServletResponse response, int casesId)throws Exception;

	public void supportFaqExcelReport(HttpServletRequest request,
			HttpServletResponse response)throws Exception;

	public void faqPDFReport(HttpServletRequest request,
			HttpServletResponse response, int faqId)throws Exception;
	/**
	 * <p>
	 * <code>ticketExcelReport</code>Method will generated the xls view the ticket reports
	 * </p>
	 * 
	 * @param request,response
	 * @throws OMIApplicationException
	 * @author Rosu Patel
	 * 
	 */
	public void ticketExcelReport(HttpServletRequest request,
			HttpServletResponse response)throws Exception;
	/**
	 * <p>
	 * <code>ticketPDF</code>Method will generated the pdf view the ticket reports
	 * </p>
	 * 
	 * @param request,response,ticketId
	 * @throws OMIApplicationException
	 * @author Rosu Patel
	 * 
	 */
	public void ticketPDF(HttpServletRequest request,
			HttpServletResponse response, int ticketId)throws Exception;
	/**
	 * <p>
	 * <code>addProductName</code>Method will generated the product name view the 
	 * </p>
	 * 
	 * @param productName
	 * @throws OMIApplicationException
	 * @author Rosu Patel
	 * 
	 */
	public String addProductName(SupportFaqVO supportFaqVO)throws OMIApplicationException;
	/**
	 * <p>
	 * <code>showProductName</code>Method will generated the product name view the 
	 * </p>
	 * 
	 * @param productName
	 * @throws OMIApplicationException
	 * @author Rosu Patel
	 * 
	 */
	public List<SupportFaqVO> showProductName() throws OMIApplicationException;
	/**
	 * <p>
	 * <code>addCasesProductName</code>Method will generated the product name view the 
	 * </p>
	 * 
	 * @param productName
	 * @throws OMIApplicationException
	 * @author Rosu Patel
	 * 
	 */
	public String addCasesProductName(SupportCasesVO supportCasesVO)throws OMIApplicationException;
	/**
	 * <p>
	 * <code>showContactName</code>Method will generated the contact name view the 
	 * </p>
	 * 
	 * @param contactName
	 * @throws OMIApplicationException
	 * @author Rosu Patel
	 * 
	 */
	public List<SupportCasesVO> showContactName()throws OMIApplicationException;
	/**
	 * <p>
	 * <code>addCasesContactName</code>Method will generated the contact name view the 
	 * </p>
	 * 
	 * @param contactName
	 * @throws OMIApplicationException
	 * @author Rosu Patel
	 * 
	 */
	public String addCasesContactName(SupportCasesVO supportCasesVO)throws OMIApplicationException;
	/**
	 * <p>
	 * <code>addCasesOrganizationName</code>Method will generated the organization name view the 
	 * </p>
	 * 
	 * @param organizationName
	 * @throws OMIApplicationException
	 * @author Rosu Patel
	 * 
	 */
	public String addCasesOrganizationName(SupportCasesVO supportCasesVO)throws OMIApplicationException;
	/**
	 * <p>
	 * <code>showOrganizationName</code>Method will generated the organization name view the 
	 * </p>
	 * 
	 * @param organizationName
	 * @throws OMIApplicationException
	 * @author Rosu Patel
	 * 
	 */
	public List<SupportCasesVO> showOrganizationName()throws OMIApplicationException;
	/**
	 * <p>
	 * <code>addTicketProductName</code>Method will generated the product name view the 
	 * </p>
	 * 
	 * @param productName
	 * @throws OMIApplicationException
	 * @author Rosu Patel
	 * 
	 */
	public String addTicketProductName(TicketVO ticketVO)throws OMIApplicationException;
	/**
	 * <p>
	 * <code>showTicketProductName</code>Method will generated the product name view the 
	 * </p>
	 * 
	 * @param productName
	 * @throws OMIApplicationException
	 * @author Rosu Patel
	 * 
	 */
	public List<TicketVO> showTicketProductName()throws OMIApplicationException;
	/**
	 * <p>
	 * <code>addTicketContactName</code>Method will generated the contact name view the 
	 * </p>
	 * 
	 * @param contactName
	 * @throws OMIApplicationException
	 * @author Rosu Patel
	 * 
	 */
	public String addTicketContactName(TicketVO ticketVO)throws OMIApplicationException;
	/**
	 * <p>
	 * <code>showTicketContactName</code>Method will generated the contact name view the 
	 * </p>
	 * 
	 * @param contactName
	 * @throws OMIApplicationException
	 * @author Rosu Patel
	 * 
	 */
	public List<TicketVO> showTicketContactName()throws OMIApplicationException;

	
	
}
