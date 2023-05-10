package com.bst.ckt.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.bst.ckt.common.LoginUtil;
import com.bst.ckt.common.OMIConstants;
import com.bst.ckt.dao.ExcelReportDaoImpl;
import com.bst.ckt.dao.ExcelReportDaoInf;
import com.bst.ckt.dao.SupportDaoImpl;
import com.bst.ckt.dao.SupportDaoInf;
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
public class SupportServiceImpl implements SupportServiceInf {

	/**
	 * Creating Logger object, logger object mapped with SupportFaqAction class
	 * for writing Loggers.
	 */
	private static final Logger logger = Logger
			.getLogger(SupportServiceImpl.class);
	ExcelReportDaoInf excelReportDaoInf = new ExcelReportDaoImpl();
	SupportDaoInf supportDaoInf = new SupportDaoImpl();

	/**
	 * <p>
	 * <code>insertFaq</code>Method will insertFaq data from TAB_SUPPORT_FAQ
	 * </p>
	 * 
	 * @return
	 * @throws OMIApplicationException
	 * @param supportFaqVO
	 */
	public String registerFaq(SupportFaqVO supportFaqVO) throws Exception {
		// Creating the SupportServiceImpl object
		SupportDaoInf supportDaoInf = new SupportDaoImpl();
		int target = supportDaoInf.insertFaq(supportFaqVO);
		if (target == 1) {
			logger.info("Successfully Insert FAQ!");
			return OMIConstants.TARGET_SUCCESS;

		} else {
			logger.info("Error:while  Inserting  FAQ into database!");
			return OMIConstants.TARGET_FAILURE;

		}

	}

	/**
	 * <p>
	 * <code>getFaqGrid</code>Method will fetch data from TAB_SUPPORT_FAQ
	 * </p>
	 * 
	 * @return List<SupportFaqVO>
	 * @throws OMIApplicationException
	 * 
	 */

	public List<SupportFaqVO> showFaqInfoGrid() throws Exception {
		// Creating the SupportServiceImpl object
		SupportDaoInf supportDaoInf = new SupportDaoImpl();
		return supportDaoInf.getFaqGrid();
	}

	/**
	 * <p>
	 * <code>viewFaqInfo</code>Method will view Faq Information data from
	 * TAB_SUPPORT_FAQ
	 * </p>
	 * 
	 * @return
	 * @throws OMIApplicationException
	 * @param faqId
	 */

	public SupportFaq viewFaqInfo(int faqId) throws Exception {
		// Creating the SupportServiceImpl object
		SupportDaoInf supportDaoInf = new SupportDaoImpl();
		SupportFaq supportFaq = null;
		try {
			supportFaq = supportDaoInf.viewFaqDetail(faqId);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return supportFaq;

	}

	/**
	 * <p>
	 * <code>editFaqInfo</code>Method will edit Faq Information data from
	 * TAB_SUPPORT_FAQ
	 * </p>
	 * 
	 * @return
	 * @throws OMIApplicationException
	 * @param faqId
	 */

	public SupportFaq editFaqInfo(int faqId) throws Exception {
		// Creating the SupportServiceImpl object
		SupportDaoInf supportDaoInf = new SupportDaoImpl();
		SupportFaq supportFaq = null;
		try {
			supportFaq = supportDaoInf.editFaqDetail(faqId);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return supportFaq;

	}

	/**
	 * <p>
	 * <code>updateFaqInfo</code>Method will Update Faq Information data from
	 * TAB_SUPPORT_FAQ
	 * </p>
	 * 
	 * @return
	 * @throws OMIApplicationException
	 * @param SupportFaqVO
	 *            supportFaqVO, int faqId
	 */

	public String updateFaqInfo(SupportFaqVO supportFaqVO, int faqId)
			throws Exception {
		// Creating the SupportServiceImpl object
		SupportDaoInf supportDaoInf = new SupportDaoImpl();
		int target = supportDaoInf.updateFaqDetail(supportFaqVO, faqId);
		if (target == 1) {
			logger.info("Successfully Updating FAQ!");
			return OMIConstants.TARGET_SUCCESS;

		} else {
			logger.info("Error:while  Updating  FAQ into database!");
			return OMIConstants.TARGET_FAILURE;

		}

	}

	/**
	 * <p>
	 * <code>insertCases</code>Method will insert Cases data from
	 * TAB_SUPPORT_CASES
	 * </p>
	 * 
	 * @return
	 * @throws OMIApplicationException
	 * @param supportFaqVO
	 */
	public String registerCases(SupportCasesVO supportCasesVO) throws Exception {
		// Creating the SupportServiceImpl object
		SupportDaoInf supportDaoInf = new SupportDaoImpl();
		int target = supportDaoInf.insertCases(supportCasesVO);
		if (target == 1) {
			logger.info("Successfully Insert Cases!");
			return OMIConstants.TARGET_SUCCESS;

		} else {
			logger.info("Error:while  Inserting  Cases into database!");
			return OMIConstants.TARGET_FAILURE;

		}

	}

	/**
	 * <p>
	 * <code>getFaqGrid</code>Method will fetch data from TAB_SUPPORT_CASES
	 * </p>
	 * 
	 * @return List<SupportCasesVO>
	 * @throws OMIApplicationException
	 * 
	 */

	public List<SupportCasesVO> showCasesInfoGrid() throws OMIApplicationException {
		// Creating the SupportServiceImpl object
		
		return supportDaoInf.getCasesGrid();
	}

	/**
	 * <p>
	 * <code>editCasesInfo</code>Method will edit Cases Information data from
	 * TAB_SUPPORT_CASES
	 * </p>
	 * 
	 * @return
	 * @throws OMIApplicationException
	 * @param casesId
	 */

	public SupportCases editCasesInfo(int casesId) throws Exception {
		// Creating the SupportServiceImpl object
		SupportDaoInf supportDaoInf = new SupportDaoImpl();
		SupportCases supportCases = null;
		try {
			supportCases = supportDaoInf.editCasesDetail(casesId);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return supportCases;

	}

	/**
	 * <p>
	 * <code>updateCasesInfo</code>Method will Update Cases Information data
	 * from TAB_SUPPORT_CASES
	 * </p>
	 * 
	 * @return
	 * @throws OMIApplicationException
	 * @param SupportCasesVO
	 *            supportCasesVO, int casesId
	 */

	public String updateCasesInfo(SupportCasesVO supportCasesVO, int casesId)
			throws Exception {
		// Creating the SupportServiceImpl object
		SupportDaoInf supportDaoInf = new SupportDaoImpl();
		int target = supportDaoInf.updateCasesDetail(supportCasesVO, casesId);
		if (target == 1) {
			logger.info("Successfully Updating CASES!");
			return OMIConstants.TARGET_SUCCESS;

		} else {
			logger.info("Error:while  Updating  CASES into database!");
			return OMIConstants.TARGET_FAILURE;

		}

	}

	/**
	 * <p>
	 * <code>viewCasesInfo</code>Method will view Cases Information data from
	 * TAB_SUPPORT_CASES
	 * </p>
	 * 
	 * @return
	 * @throws OMIApplicationException
	 * @param casesId
	 */

	public SupportCases viewCasesInfo(int casesId) throws Exception {
		// Creating the SupportServiceImpl object
		SupportDaoInf supportDaoInf = new SupportDaoImpl();
		SupportCases supportCases = null;
		try {
			supportCases = supportDaoInf.viewCasesDetail(casesId);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return supportCases;

	}

	/**
	 * <p>
	 * <code>deleteSupportFaqDetail</code>Method will delete faq Information
	 * data from TAB_SUPPORT_FAQ
	 * </p>
	 * 
	 * @return
	 * @throws OMIApplicationException
	 * @param faqId
	 */

	public int removeSupportFaqDetails(int faqId) throws OMIApplicationException {
		// Creating the SupportServiceImpl object
		
		int target=supportDaoInf.deleteSupportFaqDetail(faqId);
		return target;
	}

	/**
	 * <p>
	 * <code>deleteSupportCasesDetail</code>Method will delete Cases Information
	 * data from TAB_SUPPORT_CASES
	 * </p>
	 * 
	 * @return
	 * @throws OMIApplicationException
	 * @param casesId
	 */

	public int removeSupportCasesDetails(int casesId) throws OMIApplicationException {
		// Creating the SupportServiceImpl object
		
		int target=supportDaoInf.deleteSupportCasesDetail(casesId);
		return target;
	}

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

	public String registerTicket(TicketVO ticketVO) throws Exception {
		// Creating the SupportServiceImpl object
		SupportDaoInf supportDaoInf = new SupportDaoImpl();
		int target = supportDaoInf.insertTicket(ticketVO);
		if (target == 1) {
			logger.info("Successfully Insert Ticket!");
			return OMIConstants.TARGET_SUCCESS;

		} else {
			logger.info("Error:while  Inserting Ticket into database!");
			return OMIConstants.TARGET_FAILURE;

		}
	}

	/**
	 * <p>
	 * <code>getTicketGrid</code>Method will show data from TAB_SUPPORT_TICKET
	 * </p>
	 * 
	 * @return List<SupportCasesVO>
	 * @throws OMIApplicationException
	 * @param
	 */
	public List<TicketVO> showTicketInfoGrid() throws Exception {
		// Creating the SupportDoImpl object
		SupportDaoInf supportDaoInf = new SupportDaoImpl();
		return supportDaoInf.getTicketGrid();
	}

	/**
	 * <p>
	 * <code>editTicketDetail</code>Method will edit data from based ticketId
	 * </p>
	 * 
	 * @return supportTicket
	 * @throws OMIApplicationException
	 * @param int ticketId
	 */
	public SupportTicket editTicketInfo(int ticketId) throws Exception {
		// Creating the SupportDaoImpl object
		SupportDaoInf supportDaoInf = new SupportDaoImpl();
		SupportTicket supportTicket = null;
		try {
			supportTicket = supportDaoInf.editTicketDetail(ticketId);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return supportTicket;

	}

	/**
	 * <p>
	 * <code>viewTicketDetail</code>Method will view Ticket Information data
	 * from TAB_SUPPORT_TICKET
	 * </p>
	 * 
	 * @return
	 * @throws OMIApplicationException
	 * @param ticketId
	 */
	public SupportTicket viewTicketInfo(int ticketId) throws Exception {
		// Creating the SupportServiceImpl object
		SupportDaoInf supportDaoInf = new SupportDaoImpl();
		SupportTicket supportTicket = null;
		try {
			supportTicket = supportDaoInf.viewTicketDetail(ticketId);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return supportTicket;

	}

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
	public String updateTicketInfo(TicketVO ticketVO, int ticketId)
			throws Exception {
		// Creating the SupportServiceImpl object
		SupportDaoInf supportDaoInf = new SupportDaoImpl();
		int target = supportDaoInf.updateTicketDetail(ticketVO, ticketId);
		if (target == 1) {
			logger.info("Successfully Updating Ticket!");
			return OMIConstants.TARGET_SUCCESS;

		} else {
			logger.info("Error:while  Updating  Ticket into database!");
			return OMIConstants.TARGET_FAILURE;

		}

	}

	/**
	 * <p>
	 * <code>deleteSupportCasesDetail</code>Method will delete Cases Information
	 * data from TAB_SUPPORT_CASES
	 * </p>
	 * 
	 * @return
	 * @throws OMIApplicationException
	 * @param casesId
	 */
	public void removeTicketDetails(int ticketId) throws Exception {
		// Creating the SupportServiceImpl object
		SupportDaoInf supportDaoInf = new SupportDaoImpl();
		supportDaoInf.deleteTicketDetail(ticketId);
	}

	/**
	 * <p>
	 * <code>viewNextFaqDetails</code>Method will view Next Faq Details data
	 * from view faq page
	 * </p>
	 * 
	 * @return
	 * @throws OMIApplicationException
	 * @param faqId
	 */
	public SupportFaq viewNextFaqDetails(int faqId) throws Exception {
		SupportFaq supportFaq = null;
		SupportDaoInf supportDaoInf = new SupportDaoImpl();
		try {
			faqId++;
			if (supportDaoInf.getFaqLastRecord() < faqId) {
				faqId = 0;
				LoginUtil.setProcessUserId(faqId);
				supportFaq = new SupportFaq();
				supportFaq.setFaqId(0);
				return supportFaq;
			} else {
				LoginUtil.setProcessUserId(faqId);
				supportFaq = supportDaoInf.getFaqDetails(faqId);
				if (supportFaq.getFaqId() == 0) {
					faqId = LoginUtil.getProcessUserId();
					LoginUtil.setProcessUserId(faqId);
					return supportFaq;
				}
				supportFaq = supportDaoInf.getFaqDetails(faqId);
			}

		} catch (Exception exception) {
			logger.error("no records found" + exception);
		}
		return supportFaq;
	}

	/**
	 * <p>
	 * <code>viewPreviousFaqDetails</code>Method will view Previous Faq Details
	 * data from view faq page
	 * </p>
	 * 
	 * @return SupportFaq
	 * @throws OMIApplicationException
	 * @param faqId
	 */
	public SupportFaq viewPreviousFaqDetails(int faqId) throws Exception {
		SupportDaoInf supportDaoInf = new SupportDaoImpl();

		SupportFaq supportFaq = null;
		try {
			faqId--;
			LoginUtil.setProcessUserId(faqId);
			supportFaq = supportDaoInf.getFaqDetails(faqId);
			if (supportFaq.getFaqId() == 0) {
				faqId = LoginUtil.getProcessUserId();
				LoginUtil.setProcessUserId(faqId);
				return supportFaq;
			}
			supportFaq = supportDaoInf.getFaqDetails(faqId);

		} catch (Exception exception) {
			logger.error("no records found" + exception);
		}
		return supportFaq;
	}

	/**
	 * <p>
	 * <code>editPreviousFaqDetails</code>Method will edit Previous Faq Details
	 * data from edit faq page
	 * </p>
	 * 
	 * @return SupportFaq
	 * @throws OMIApplicationException
	 * @param faqId
	 */

	public SupportFaq editPreviousFaqDetails(int faqId) throws Exception {
		SupportDaoInf supportDaoInf = new SupportDaoImpl();
		SupportFaq supportFaq = null;
		try {
			faqId--;
			LoginUtil.setProcessUserId(faqId);
			supportFaq = supportDaoInf.getFaqDetailsForUpdate(faqId);
			if (supportFaq.getFaqId() == 0) {
				faqId = LoginUtil.getProcessUserId();
				LoginUtil.setProcessUserId(faqId);
				return supportFaq;
			}
			supportFaq = supportDaoInf.getFaqDetailsForUpdate(faqId);

		} catch (Exception exception) {
			logger.error("no records found" + exception);
		}
		return supportFaq;
	}

	/**
	 * <p>
	 * <code>editNextFaqDetails</code>Method will edit Next Faq Details data
	 * from edit Faq Page
	 * </p>
	 * 
	 * @return SupportFaq
	 * @throws OMIApplicationException
	 * @param faqId
	 */
	public SupportFaq editNextFaqDetails(int faqId) throws Exception {
		SupportDaoInf supportDaoInf = new SupportDaoImpl();
		SupportFaq supportFaq = null;
		try {
			faqId++;
			if (supportDaoInf.getFaqLastRecord() < faqId) {
				faqId = 0;
				LoginUtil.setProcessUserId(faqId);
				supportFaq = new SupportFaq();
				supportFaq.setFaqId(0);
				return supportFaq;
			} else {
				LoginUtil.setProcessUserId(faqId);
				supportFaq = supportDaoInf.getFaqDetailsForUpdate(faqId);
				if (supportFaq.getFaqId() == 0) {
					faqId = LoginUtil.getProcessUserId();
					LoginUtil.setProcessUserId(faqId);
					return supportFaq;
				}
				supportFaq = supportDaoInf.getFaqDetailsForUpdate(faqId);
			}

		} catch (Exception exception) {
			logger.error("no records found" + exception);
		}
		return supportFaq;
	}

	/**
	 * <p>
	 * <code>viewNextCasesDetails</code>Method will view Next Cases Details data
	 * from view Cases page
	 * </p>
	 * 
	 * @return SupportCases
	 * @throws OMIApplicationException
	 * @param casesId
	 */
	public SupportCases viewNextCasesDetails(int casesId) throws Exception {
		SupportCases supportCases = null;
		SupportDaoInf supportDaoInf = new SupportDaoImpl();
		try {
			casesId++;
			if (supportDaoInf.getCasesLastRecord() < casesId) {
				casesId = 0;
				LoginUtil.setProcessUserId(casesId);
				supportCases = new SupportCases();
				supportCases.setCasesId(0);
				return supportCases;
			} else {
				LoginUtil.setProcessUserId(casesId);
				supportCases = supportDaoInf.getCasesDetails(casesId);
				if (supportCases.getCasesId() == 0) {
					casesId = LoginUtil.getProcessUserId();
					LoginUtil.setProcessUserId(casesId);
					return supportCases;
				}
				supportCases = supportDaoInf.getCasesDetails(casesId);
			}

		} catch (Exception exception) {
			logger.error("no records found" + exception);
		}
		return supportCases;
	}

	/**
	 * <p>
	 * <code>viewPreviousCasesDetails</code>Method will view Previous Cases
	 * Details data from view Cases page
	 * </p>
	 * 
	 * @return supportCases
	 * @throws OMIApplicationException
	 * @param casesId
	 */
	public SupportCases viewPreviousCasesDetails(int casesId) throws Exception {
		SupportDaoInf supportDaoInf = new SupportDaoImpl();

		SupportCases supportCases = null;
		try {
			casesId--;
			LoginUtil.setProcessUserId(casesId);
			supportCases = supportDaoInf.getCasesDetails(casesId);
			if (supportCases.getCasesId() == 0) {
				casesId = LoginUtil.getProcessUserId();
				LoginUtil.setProcessUserId(casesId);
				return supportCases;
			}
			supportCases = supportDaoInf.getCasesDetails(casesId);

		} catch (Exception exception) {
			logger.error("no records found" + exception);
		}
		return supportCases;
	}

	/**
	 * <p>
	 * <code>editPreviousFaqDetails</code>Method will edit Previous Cases
	 * Details data from edit Cases page
	 * </p>
	 * 
	 * @return supportCases
	 * @throws OMIApplicationException
	 * @param casesId
	 */

	public SupportCases editPreviousCasesDetails(int casesId) throws Exception {
		SupportDaoInf supportDaoInf = new SupportDaoImpl();
		SupportCases supportCases = null;
		try {
			casesId--;
			LoginUtil.setProcessUserId(casesId);
			supportCases = supportDaoInf.getCasesDetailsForUpdate(casesId);
			if (supportCases.getCasesId() == 0) {
				casesId = LoginUtil.getProcessUserId();
				LoginUtil.setProcessUserId(casesId);
				return supportCases;
			}
			supportCases = supportDaoInf.getCasesDetailsForUpdate(casesId);

		} catch (Exception exception) {
			logger.error("no records found" + exception);
		}
		return supportCases;
	}

	/**
	 * <p>
	 * <code>editNextCasesDetails</code>Method will edit Next Cases Details data
	 * from edit Cases Page
	 * </p>
	 * 
	 * @return SupportCases
	 * @throws OMIApplicationException
	 * @param casesId
	 */
	public SupportCases editNextCasesDetails(int casesId) throws Exception {
		SupportDaoInf supportDaoInf = new SupportDaoImpl();
		SupportCases supportCases = null;
		try {
			casesId++;
			if (supportDaoInf.getCasesLastRecord() < casesId) {
				casesId = 0;
				LoginUtil.setProcessUserId(casesId);
				supportCases = new SupportCases();
				supportCases.setCasesId(0);
				return supportCases;
			} else {
				LoginUtil.setProcessUserId(casesId);
				supportCases = supportDaoInf.getCasesDetailsForUpdate(casesId);
				if (supportCases.getCasesId() == 0) {
					casesId = LoginUtil.getProcessUserId();
					LoginUtil.setProcessUserId(casesId);
					return supportCases;
				}
				supportCases = supportDaoInf.getCasesDetailsForUpdate(casesId);
			}

		} catch (Exception exception) {
			logger.error("no records found" + exception);
		}
		return supportCases;
	}

	/**
	 * <p>
	 * <code>viewNextTicketDetails</code>Method will view Next Ticket Details
	 * data from edit Cases page
	 * </p>
	 * 
	 * @return SupportTicket
	 * @throws OMIApplicationException
	 * @param ticketId
	 */

	public SupportTicket viewNextTicketDetails(int ticketId) throws Exception {
		SupportTicket supportTicket = null;
		SupportDaoInf supportDaoInf = new SupportDaoImpl();
		try {
			ticketId++;
			if (supportDaoInf.getFaqLastRecord() < ticketId) {
				ticketId = 0;
				LoginUtil.setProcessUserId(ticketId);
				supportTicket = new SupportTicket();
				supportTicket.setTicketId(0);
				return supportTicket;
			} else {
				LoginUtil.setProcessUserId(ticketId);
				supportTicket = supportDaoInf.getTicketDetails(ticketId);
				if (supportTicket.getTicketId() == 0) {
					ticketId = LoginUtil.getProcessUserId();
					LoginUtil.setProcessUserId(ticketId);
					return supportTicket;
				}
				supportTicket = supportDaoInf.getTicketDetails(ticketId);
			}

		} catch (Exception exception) {
			logger.error("no records found" + exception);
		}
		return supportTicket;
	}

	/**
	 * <p>
	 * <code>editNextTicketDetails</code>Method will edit Next Ticket Details
	 * data from edit Cases page
	 * </p>
	 * 
	 * @return SupportTicket
	 * @throws OMIApplicationException
	 * @param ticketId
	 */

	public SupportTicket editNextTicketDetails(int ticketId) throws Exception {
		SupportDaoInf supportDaoInf = new SupportDaoImpl();
		SupportTicket supportTicket = null;
		try {
			ticketId++;
			if (supportDaoInf.getFaqLastRecord() < ticketId) {
				ticketId = 0;
				LoginUtil.setProcessUserId(ticketId);
				supportTicket = new SupportTicket();
				supportTicket.setTicketId(0);
				return supportTicket;
			} else {
				LoginUtil.setProcessUserId(ticketId);
				supportTicket = supportDaoInf
						.getTicketDetailsForUpdate(ticketId);
				if (supportTicket.getTicketId() == 0) {
					ticketId = LoginUtil.getProcessUserId();
					LoginUtil.setProcessUserId(ticketId);
					return supportTicket;
				}
				supportTicket = supportDaoInf
						.getTicketDetailsForUpdate(ticketId);
			}

		} catch (Exception exception) {
			logger.error("no records found" + exception);
		}
		return supportTicket;
	}

	/**
	 * <p>
	 * <code>viewPreviousTicketDetails</code>Method will edit view Previous
	 * Ticket Details data from edit Cases page
	 * </p>
	 * 
	 * @return SupportTicket
	 * @throws OMIApplicationException
	 * @param ticketId
	 */

	public SupportTicket viewPreviousTicketDetails(int ticketId)
			throws Exception {
		SupportDaoInf supportDaoInf = new SupportDaoImpl();
		SupportTicket supportTicket = null;
		try {
			ticketId--;
			LoginUtil.setProcessUserId(ticketId);
			supportTicket = supportDaoInf.getTicketDetails(ticketId);
			if (supportTicket.getTicketId() == 0) {
				ticketId = LoginUtil.getProcessUserId();
				LoginUtil.setProcessUserId(ticketId);
				return supportTicket;
			}
			supportTicket = supportDaoInf.getTicketDetails(ticketId);

		} catch (Exception exception) {
			logger.error("no records found" + exception);
		}
		return supportTicket;
	}

	/**
	 * <p>
	 * <code>editPreviousTicketDetails</code>Method will edit Previous Ticket
	 * Details data from edit Cases page
	 * </p>
	 * 
	 * @return SupportTicket
	 * @throws OMIApplicationException
	 * @param ticketId
	 */

	public SupportTicket editPreviousTicketDetails(int ticketId)
			throws Exception {
		SupportDaoInf supportDaoInf = new SupportDaoImpl();
		SupportTicket supportTicket = null;
		try {
			ticketId--;
			LoginUtil.setProcessUserId(ticketId);
			supportTicket = supportDaoInf.getTicketDetailsForUpdate(ticketId);
			if (supportTicket.getTicketId() == 0) {
				ticketId = LoginUtil.getProcessUserId();
				LoginUtil.setProcessUserId(ticketId);
				return supportTicket;
			}
			supportTicket = supportDaoInf.getTicketDetailsForUpdate(ticketId);

		} catch (Exception exception) {
			logger.error("no records found" + exception);
		}
		return supportTicket;
	}

	/**
	 * <p>
	 * <code>faqDetailsGrid</code>Method will fetch data from TAB_SUPPORT_FAQ
	 * </p>
	 * 
	 * @return List<SupportFaqVO>
	 * @throws OMIApplicationException
	 * @param searchId
	 *            searchValue
	 */
	public List<SupportFaqVO> faqDetailsGrid(SupportFaqVO supportFaqVO)
			throws Exception {
		SupportDaoInf supportDaoInf = new SupportDaoImpl();
		int searchId = supportFaqVO.getSearchId();
		String searchValue = "";

		if (searchId == 1) {
			searchValue = String.valueOf(supportFaqVO.getFaqId());
		} else if (searchId == 2) {
			searchValue = String.valueOf(supportFaqVO.getQuestion());
		} else if (searchId == 3) {
			searchValue = String.valueOf(supportFaqVO.getCategory());
		} else if (searchId == 4) {
			searchValue = String.valueOf(supportFaqVO.getProductName());
		} else if (searchId == 5) {
			searchValue = String.valueOf(supportFaqVO.getOwner());
		} else if (searchId == 6) {
			searchValue = String.valueOf(supportFaqVO.getStatus());
		}
		return supportDaoInf.getFaqDetailsGrid(searchId, searchValue);

	}

	/**
	 * <p>
	 * <code>casesDetailsGrid</code>Method will fetch data from
	 * TAB_SUPPORT_CASES
	 * </p>
	 * 
	 * @return List<SupportCasesVO>
	 * @throws OMIApplicationException
	 * @param searchId
	 *            searchValue
	 */
	public List<SupportCasesVO> casesDetailsGrid(SupportCasesVO supportCasesVO)
			throws OMIApplicationException {
		SupportDaoInf supportDaoInf = new SupportDaoImpl();
		int searchId = supportCasesVO.getSearchId();
		String searchValue = "";

		if (searchId == 1) {
			searchValue = String.valueOf(supportCasesVO.getCasesId());
		} else if (searchId == 2) {
			searchValue = String.valueOf(supportCasesVO.getCaseTitle());
		} else if (searchId == 3) {
			searchValue = String.valueOf(supportCasesVO.getContactName());
		} else if (searchId == 4) {
			searchValue = String.valueOf(supportCasesVO.getPriority());
		} else if (searchId == 5) {
			searchValue = String.valueOf(supportCasesVO.getStatus());
		} else if (searchId == 6) {
			searchValue = String.valueOf(supportCasesVO.getStatus());
		}
		return supportDaoInf.getCasesDetailsGrid(searchId, searchValue);
	}

	/**
	 * <p>
	 * <code>ticketDetailsGrid</code>Method will fetch data from
	 * TAB_SUPPORT_TICKET
	 * </p>
	 * 
	 * @return List<TicketVO>
	 * @throws OMIApplicationException
	 * @param searchId
	 *            searchValue
	 */
	public List<TicketVO> ticketDetailsGrid(TicketVO ticketVO) throws Exception {
		SupportDaoInf supportDaoInf = new SupportDaoImpl();
		int searchId = ticketVO.getSearchId();
		String searchValue = "";

		if (searchId == 1) {
			searchValue = String.valueOf(ticketVO.getTicketId());
		} else if (searchId == 2) {
			searchValue = String.valueOf(ticketVO.getCategory());
		} else if (searchId == 3) {
			searchValue = String.valueOf(ticketVO.getTicketOwner());
		} else if (searchId == 4) {
			searchValue = String.valueOf(ticketVO.getPriority());
		} else if (searchId == 5) {
			searchValue = String.valueOf(ticketVO.getChannel());
		} else if (searchId == 6) {
			searchValue = String.valueOf(ticketVO.getDueDate());
		} else if (searchId == 7) {
			searchValue = String.valueOf(ticketVO.getContactName());
		} else if (searchId == 8) {
			searchValue = String.valueOf(ticketVO.getProductName());
		} else if (searchId == 9) {
			searchValue = String.valueOf(ticketVO.getStatus());
		}
		return supportDaoInf.getTicketDetailsGrid(searchId, searchValue);
	}

	/**
	 * <p>
	 * <code>registerServiceContact</code>Method will insert Service Contact
	 * data from TAB_SUPPORT_SERVICE_CONTACT
	 * </p>
	 * 
	 * @return SupportCases
	 * @throws OMIApplicationException
	 * @param ServiceContactVo
	 *            ServiceContactVo
	 */
	public String registerServiceContact(ServiceContactVo ServiceContactVo)
			throws Exception {
		// Creating the SupportServiceImpl object
		SupportDaoInf supportDaoInf = new SupportDaoImpl();
		int target = supportDaoInf.insertServiceContact(ServiceContactVo);
		if (target == 1) {
			logger.info("Successfully Insert Service Contact!");
			return OMIConstants.TARGET_SUCCESS;

		} else {
			logger.info("Error:while  Inserting  Service Contact into database!");
			return OMIConstants.TARGET_FAILURE;

		}

	}

	/**
	 * <p>
	 * <code>showServiceContactInfoGrid</code>Method will fetch data from
	 * TAB_SUPPORT_SERVICE_CONTACT
	 * 
	 * </p>
	 * 
	 * @return List<ServiceContactVo>
	 * @throws OMIApplicationException
	 * @param
	 */
	public List<ServiceContactVo> showServiceContactInfoGrid() throws Exception {
		// Creating the SupportServiceImpl object
		SupportDaoInf supportDaoInf = new SupportDaoImpl();
		return supportDaoInf.getServiceContactGrid();
	}

	/**
	 * <p>
	 * <code>serviceContactSearchList</code>Method will Service contact search
	 * list from based id
	 * </p>
	 * 
	 * @return List<ServiceContactVo>
	 * @throws OMIApplicationException
	 * @param ServiceContactVo
	 *            serviceContactVo
	 */
	public List<ServiceContactVo> serviceContactSearchList(
			ServiceContactVo serviceContactVo) throws Exception {
		SupportDaoInf supportDaoInf = new SupportDaoImpl();
		int searchId = serviceContactVo.getSearchId();
		String searchValue = "";

		if (searchId == 1) {
			searchValue = String
					.valueOf(serviceContactVo.getServiceContactId());
		} else if (searchId == 2) {
			searchValue = String.valueOf(serviceContactVo.getSubject());
		} else if (searchId == 3) {
			searchValue = String.valueOf(serviceContactVo.getAssignedTo());
		} else if (searchId == 4) {
			searchValue = String.valueOf(serviceContactVo.getStartDate());
		} else if (searchId == 5) {
			searchValue = String.valueOf(serviceContactVo.getDueDate());
		} else if (searchId == 6) {
			searchValue = String.valueOf(serviceContactVo.getPriority());
		} else if (searchId == 7) {
			searchValue = String.valueOf(serviceContactVo.getStatus());
		}
		return supportDaoInf.getServiceContactSearchGird(searchId, searchValue);
	}

	/**
	 * <p>
	 * <code>viewServiceContactInfo</code>Method will view Service Contact
	 * Information data from View Service Page
	 * </p>
	 * 
	 * @return SupportServiceContact
	 * @throws OMIApplicationException
	 * @param int serviceContactId
	 */
	public SupportServiceContact viewServiceContactInfo(int serviceContactId)
			throws Exception {
		// Creating the SupportServiceImpl object
		SupportDaoInf supportDaoInf = new SupportDaoImpl();
		SupportServiceContact supportServiceContact = null;
		try {
			supportServiceContact = supportDaoInf
					.viewServiceContact(serviceContactId);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return supportServiceContact;

	}

	/**
	 * <p>
	 * <code>editServiceContactInfo</code>Method will edit Service Contact
	 * rmationInfo data from edit Service Page
	 * </p>
	 * 
	 * @return SupportServiceContact
	 * @throws OMIApplicationException
	 * @param int serviceContactId
	 */
	public SupportServiceContact editServiceContactInfo(int serviceContactId)
			throws Exception {
		// Creating the SupportServiceImpl object
		SupportDaoInf supportDaoInf = new SupportDaoImpl();
		SupportServiceContact supportServiceContact = null;
		try {
			supportServiceContact = supportDaoInf
					.editServiceContact(serviceContactId);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return supportServiceContact;

	}

	/**
	 * <p>
	 * <code>updateServiceContactInfo</code>Method will update Service Contact
	 * Information based serviceContactId
	 * </p>
	 * 
	 * @return
	 * @throws OMIApplicationException
	 * @param ServiceContactVo
	 *            serviceContactVo
	 */
	public String updateServiceContactInfo(ServiceContactVo serviceContactVo,
			int serviceContactId) throws Exception {
		// Creating the SupportServiceImpl object
		SupportDaoInf supportDaoInf = new SupportDaoImpl();
		int target = supportDaoInf.updateServiceContact(serviceContactVo,
				serviceContactId);
		if (target == 1) {
			logger.info("Successfully Updating Service Contact!");
			return OMIConstants.TARGET_SUCCESS;

		} else {
			logger.info("Error:while  Updating  Service Contact into database!");
			return OMIConstants.TARGET_FAILURE;

		}
	}

	/**
	 * <p>
	 * <code>removeSupportServiceContact</code>Method will remove Support
	 * Service Contact data based serviceContactId
	 * </p>
	 * 
	 * @return removeSupportServiceContact
	 * @throws OMIApplicationException
	 * @param int serviceContactId
	 */
	public void removeSupportServiceContact(int serviceContactId)
			throws Exception {
		// Creating the SupportServiceImpl object
		SupportDaoInf supportDaoInf = new SupportDaoImpl();
		supportDaoInf.deleteServiceContactDetail(serviceContactId);
	}

	/**
	 * <p>
	 * <code>viewNextServiceContact</code>Method will view Next Service Contact
	 * data from View Service Page
	 * </p>
	 * 
	 * @return SupportServiceContact
	 * @throws OMIApplicationException
	 * @param int serviceContactId
	 */
	public SupportServiceContact viewNextServiceContact(int serviceContactId)
			throws Exception {
		SupportServiceContact supportServiceContact = null;
		SupportDaoInf supportDaoInf = new SupportDaoImpl();
		try {
			serviceContactId++;
			if (supportDaoInf.getServiceContactLastRecord() < serviceContactId) {
				serviceContactId = 0;
				LoginUtil.setProcessUserId(serviceContactId);
				supportServiceContact = new SupportServiceContact();
				supportServiceContact.setServiceContctId(0);
				return supportServiceContact;
			} else {
				LoginUtil.setProcessUserId(serviceContactId);
				supportServiceContact = supportDaoInf
						.getServiceContactDetail(serviceContactId);
				if (supportServiceContact.getServiceContctId() == 0) {
					serviceContactId = LoginUtil.getProcessUserId();
					LoginUtil.setProcessUserId(serviceContactId);
					return supportServiceContact;
				}
				supportServiceContact = supportDaoInf
						.getServiceContactDetail(serviceContactId);
			}

		} catch (Exception exception) {
			logger.error("no records found" + exception);
		}
		return supportServiceContact;
	}

	/**
	 * <p>
	 * <code>editNextServiceContact</code>Method will edit Next Service Contact
	 * data from edit Service Page
	 * </p>
	 * 
	 * @return SupportServiceContact
	 * @throws OMIApplicationException
	 * @param int serviceContactId
	 */
	public SupportServiceContact editNextServiceContact(int serviceContactId)
			throws Exception {
		SupportDaoInf supportDaoInf = new SupportDaoImpl();
		SupportServiceContact supportServiceContact = null;
		try {
			serviceContactId++;
			if (supportDaoInf.getServiceContactLastRecord() < serviceContactId) {
				serviceContactId = 0;
				LoginUtil.setProcessUserId(serviceContactId);
				supportServiceContact = new SupportServiceContact();
				supportServiceContact.setServiceContctId(0);
				return supportServiceContact;
			} else {
				LoginUtil.setProcessUserId(serviceContactId);
				supportServiceContact = supportDaoInf
						.getServiceContactForUpdate(serviceContactId);
				if (supportServiceContact.getServiceContctId() == 0) {
					serviceContactId = LoginUtil.getProcessUserId();
					LoginUtil.setProcessUserId(serviceContactId);
					return supportServiceContact;
				}
				supportServiceContact = supportDaoInf
						.getServiceContactForUpdate(serviceContactId);
			}

		} catch (Exception exception) {
			logger.error("no records found" + exception);
		}
		return supportServiceContact;
	}

	/**
	 * <p>
	 * <code>viewPreviousServiceContact</code>Method will view Previous Service
	 * Contact data from View Service Page
	 * </p>
	 * 
	 * @return SupportServiceContact
	 * @throws OMIApplicationException
	 * @param int serviceContactId
	 */
	public SupportServiceContact viewPreviousServiceContact(int serviceContactId)
			throws Exception {
		SupportDaoInf supportDaoInf = new SupportDaoImpl();

		SupportServiceContact supportServiceContact = null;
		try {
			serviceContactId--;
			LoginUtil.setProcessUserId(serviceContactId);
			supportServiceContact = supportDaoInf
					.getServiceContact(serviceContactId);
			if (supportServiceContact.getServiceContctId() == 0) {
				serviceContactId = LoginUtil.getProcessUserId();
				LoginUtil.setProcessUserId(serviceContactId);
				return supportServiceContact;
			}
			supportServiceContact = supportDaoInf
					.getServiceContact(serviceContactId);

		} catch (Exception exception) {
			logger.error("no records found" + exception);
		}
		return supportServiceContact;
	}

	/**
	 * <p>
	 * <code>editPreviousServiceContact</code>Method will edit Previous Service
	 * Contact data from edit Service Page
	 * </p>
	 * 
	 * @return SupportServiceContact
	 * @throws OMIApplicationException
	 * @param int serviceContactId
	 */
	public SupportServiceContact editPreviousServiceContact(int serviceContactId)
			throws Exception {
		SupportDaoInf supportDaoInf = new SupportDaoImpl();
		SupportServiceContact supportServiceContact = null;
		try {
			serviceContactId--;
			LoginUtil.setProcessUserId(serviceContactId);
			supportServiceContact = supportDaoInf
					.getServiceContactForUpdate(serviceContactId);
			if (supportServiceContact.getServiceContctId() == 0) {
				serviceContactId = LoginUtil.getProcessUserId();
				LoginUtil.setProcessUserId(serviceContactId);
				return supportServiceContact;
			}
			supportServiceContact = supportDaoInf
					.getServiceContactForUpdate(serviceContactId);

		} catch (Exception exception) {
			logger.error("no records found" + exception);
		}
		return supportServiceContact;
	}
	/**
	 * <p>
	 * <code>supportCasesExcelReport</code>Method will view support cases in excel report
	 * </p>
	 * 
	 * @return 
	 * @throws Exception
	 * @param request,response
	 * @author Rosu patel
	 */
	
	@Override
	public void supportCasesExcelReport(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		excelReportDaoInf.retriveCasesExcelReport(request, response);
		
	}
	/**
	 * <p>
	 * <code>casesPDF</code>Method will view support cases in pdf report
	 * </p>
	 * 
	 * @return 
	 * @throws Exception
	 * @param request,response
	 * @param productId
	 * @author Rosu patel
	 */

	@Override
	public void casesPDF(HttpServletRequest request,
			HttpServletResponse response, int casesId) throws Exception {
		
		SupportDaoInf supportDaoInf = new SupportDaoImpl();
		supportDaoInf.CasesReportPDF(request, response, casesId);
		
	}
	/**
	 * <p>
	 * <code>supportFaqExcelReport</code>Method will view support FAQ in XLS report
	 * </p>
	 * 
	 * @return 
	 * @throws Exception
	 * @param request,response
	 * @param productId
	 * @author Rosu patel
	 */
	@Override
	public void supportFaqExcelReport(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		excelReportDaoInf.retriveSupportFAQExcelReport(request, response);
		
	}
	/**
	 * <p>
	 * <code>faqPDFReport</code>Method will view support FAQ in PDF report
	 * </p>
	 * 
	 * @return 
	 * @throws Exception
	 * @param request,response
	 * @param productId
	 * @author Rosu patel
	 */
	@Override
	public void faqPDFReport(HttpServletRequest request,
			HttpServletResponse response, int faqId) throws Exception {
		SupportDaoInf supportDaoInf = new SupportDaoImpl();

		supportDaoInf.faqPDFReport(request, response, faqId);
		
	}
	/**
	 * <p>
	 * <code>ticketExcelReport</code>Method will view support ticket in XLS report
	 * </p>
	 * 
	 * @return 
	 * @throws Exception
	 * @param request,response
	 * @param 
	 * @author Rosu patel
	 */
	@Override
	public void ticketExcelReport(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		excelReportDaoInf.retriveTicketExcelReport(request,response);
		
	}
	/**
	 * <p>
	 * <code>ticketPDF((HttpServletRequest request,
			HttpServletResponse response)</code> method will help to
	 * view PDF report product details base on productId.
	 * </p>
	 * * @param (HttpServletRequest request,
			HttpServletResponse response)
	 * 
	 * @throws Exception
	 */
	@Override
	public void ticketPDF(HttpServletRequest request,
			HttpServletResponse response, int ticketId) throws Exception {
		
		supportDaoInf=new SupportDaoImpl();
		supportDaoInf.ticketPrintPDF(request,response,ticketId);
		
	}
	/**
	 * <p>
	 * <code>addProductName(()</code> method will help to
	 * view  product name 
	 * </p>
	 * * @param productName
	 * @author Rosu Patel
	 * 
	 * @throws Exception
	 */
	@Override
	public String addProductName(SupportFaqVO supportFaqVO) throws OMIApplicationException {
		supportDaoInf = new SupportDaoImpl();

		int target = supportDaoInf.isProductNameExist(supportFaqVO.getProductName());

		if (target != 1) {
			supportDaoInf.insertProductName(supportFaqVO);
			logger.info("Product Name inserted successfully.");
			return OMIConstants.RESULT_SUCCESS;
		} else {
			logger.error(SupportServiceImpl.class + "Product Name already exists");
			return OMIConstants.TARGET_LEAD_TITLE_ALREADY_EXIST;
		}
	}
	/**
	 * <p>
	 * <code>showProductName(()</code> method will help to
	 * view  product name 
	 * </p>
	 * * @param productName
	 * @author Rosu Patel
	 * 
	 * @throws Exception
	 */
	@Override
	public List<SupportFaqVO> showProductName() throws OMIApplicationException {
		// TODO Auto-generated method stub
		supportDaoInf=new SupportDaoImpl();
		return supportDaoInf.showProductName();
	}
	/**
	 * <p>
	 * <code>addCasesProductName(()</code> method will help to
	 * view  product name 
	 * </p>
	 * * @param productName
	 * @author Rosu Patel
	 * 
	 * @throws Exception
	 */
	@Override
	public String addCasesProductName(SupportCasesVO supportCasesVO)
			throws OMIApplicationException {
		//supportDaoInf = new SupportDaoImpl();
		
		int target = supportDaoInf.isProductNameExist(supportCasesVO.getProductName());

		if (target != 1) {
			supportDaoInf.insertCasesProductName(supportCasesVO);
			logger.info("Product Name inserted successfully.");
			return OMIConstants.RESULT_SUCCESS;
		} else {
			logger.error(SupportServiceImpl.class + "Product Name already exists");
			return OMIConstants.TARGET_LEAD_TITLE_ALREADY_EXIST;
		}
	}
	/**
	 * <p>
	 * <code>showContactName(()</code> method will help to
	 * view  product name 
	 * </p>
	 * * @param productName
	 * @author Rosu Patel
	 * 
	 * @throws Exception
	 */
	@Override
	public List<SupportCasesVO> showContactName()
			throws OMIApplicationException {
	supportDaoInf=new SupportDaoImpl();
	return supportDaoInf.showContactName();
	}
	/**
	 * <p>
	 * <code>addCasesContactName(()</code> method will help to
	 * view  contact name 
	 * </p>
	 * * @param productName
	 * @author Rosu Patel
	 * 
	 * @throws Exception
	 */
	@Override
	public String addCasesContactName(SupportCasesVO supportCasesVO)
			throws OMIApplicationException {
		supportDaoInf = new SupportDaoImpl();

		int target = supportDaoInf.isContectNameExist(supportCasesVO.getContactName());

		if (target != 1) {
			supportDaoInf.insertContactName(supportCasesVO);
			logger.info("Contact Name inserted successfully.");
			return OMIConstants.RESULT_SUCCESS;
		} else {
			logger.error(SupportServiceImpl.class + "Contact Name already exists");
			return OMIConstants.TARGET_LEAD_TITLE_ALREADY_EXIST;
		}
	}
	/**
	 * <p>
	 * <code>addCasesOrganizationName(()</code> method will help to
	 * view  organization name 
	 * </p>
	 * * @param productName
	 * @author Rosu Patel
	 * 
	 * @throws Exception
	 */
	@Override
	public String addCasesOrganizationName(SupportCasesVO supportCasesVO)
			throws OMIApplicationException {
		
		//supportDaoInf = new SupportDaoImpl();

		int target = supportDaoInf.isOrganizationNameExist(supportCasesVO.getContactName());

		if (target != 1) {
			supportDaoInf.insertOrganizationName(supportCasesVO);
			logger.info("Organization Name inserted successfully.");
			return OMIConstants.RESULT_SUCCESS;
		} else {
			logger.error(SupportServiceImpl.class + "Organization Name already exists");
			return OMIConstants.TARGET_LEAD_TITLE_ALREADY_EXIST;
		}
	}
	/**
	 * <p>
	 * <code>showOrganizationName(()</code> method will help to
	 * view  organization name 
	 * </p>
	 * * @param organizationName
	 * @author Rosu Patel
	 * 
	 * @throws Exception
	 */
	@Override
	public List<SupportCasesVO> showOrganizationName()
			throws OMIApplicationException {
	
		supportDaoInf=new SupportDaoImpl();
		return supportDaoInf.showOrganizationName();
	}
	/**
	 * <p>
	 * <code>addTicketProductName(()</code> method will help to
	 * view  product name 
	 * </p>
	 * * @param productName
	 * @author Rosu Patel
	 * 
	 * @throws Exception
	 */
	@Override
	public String addTicketProductName(TicketVO ticketVO)
			throws OMIApplicationException {
		//supportDaoInf = new SupportDaoImpl();

		int target = supportDaoInf.isProductNameExist(ticketVO.getProductName());

		if (target != 1) {
			supportDaoInf.insertTicketProductName(ticketVO);
			logger.info("Product Name inserted successfully.");
			return OMIConstants.RESULT_SUCCESS;
		} else {
			logger.error(SupportServiceImpl.class + "Product Name already exists");
			return OMIConstants.TARGET_LEAD_TITLE_ALREADY_EXIST;
		}
	}
	/**
	 * <p>
	 * <code>showTicketProductName(()</code> method will help to
	 * view  product name 
	 * </p>
	 * * @param productName
	 * @author Rosu Patel
	 * 
	 * @throws Exception
	 */
	@Override
	public List<TicketVO> showTicketProductName()
			throws OMIApplicationException {
		
		supportDaoInf=new SupportDaoImpl();
		return supportDaoInf.showTicketProductName();
	}
	/**
	 * <p>
	 * <code>addTicketContactName(()</code> method will help to
	 * view  contact name 
	 * </p>
	 * * @param contactNAme
	 * @author Rosu Patel
	 * 
	 * @throws Exception
	 */
	@Override
	public String addTicketContactName(TicketVO ticketVO)
			throws OMIApplicationException {

		int target = supportDaoInf.isContactNameExist(ticketVO.getContactName());

		if (target != 1) {
			supportDaoInf.insertTicketContactName(ticketVO);
			logger.info("Contact Name inserted successfully.");
			return OMIConstants.RESULT_SUCCESS;
		} else {
			logger.error(SupportServiceImpl.class + "Contact Name already exists");
			return OMIConstants.TARGET_LEAD_TITLE_ALREADY_EXIST;
		}
	}
	/**
	 * <p>
	 * <code>showTicketContactName(()</code> method will help to
	 * view  contact name 
	 * </p>
	 * * @param contactNAme
	 * @author Rosu Patel
	 * 
	 * @throws Exception
	 */
	@Override
	public List<TicketVO> showTicketContactName()
			throws OMIApplicationException {
		supportDaoInf=new SupportDaoImpl();
		return supportDaoInf.showTicketContactName();
	}


	
	

}
