package com.bst.ckt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.bst.ckt.common.QueryBuilder;
import com.bst.ckt.common.QueryMaker;
import com.bst.ckt.dto.SupportCases;
import com.bst.ckt.dto.SupportFaq;
import com.bst.ckt.dto.SupportServiceContact;
import com.bst.ckt.dto.SupportTicket;
import com.bst.ckt.exception.OMIApplicationException;
import com.bst.ckt.framework.db.JdbcDAOSupport;
import com.bst.ckt.framework.db.JdbcHelper;
import com.bst.ckt.framework.util.DateTimeUtil;
import com.bst.ckt.helper.CasesStatus;
import com.bst.ckt.helper.FAQStatus;
import com.bst.ckt.helper.NameHelper;
import com.bst.ckt.helper.ServiceStatus;
import com.bst.ckt.helper.TicketPriority;
import com.bst.ckt.helper.TicketStatus;
import com.bst.ckt.vo.ServiceContactVo;
import com.bst.ckt.vo.SupportCasesVO;
import com.bst.ckt.vo.SupportFaqVO;
import com.bst.ckt.vo.TicketVO;
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

/**
 * 
 * @author ROHIT GURJAR
 * 
 */
public class SupportDaoImpl extends JdbcDAOSupport implements SupportDaoInf {
	/**
	 * Creating Logger object, logger object mapped with SupportFaqAction class
	 * for writing Loggers.
	 */
	private static final Logger logger = Logger.getLogger(SupportDaoImpl.class);

	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	SupportFaqVO supportFaqVO = null;
	SupportFaq supportFaq = null;
	SupportCases supportCases = null;
	SupportCasesVO supportCasesVO = new SupportCasesVO();
	TicketVO ticketVO = null;
	SupportTicket supportTicket = null;
	ServiceContactVo serviceContactVo = null;
	SupportServiceContact supportServiceContact = null;
	NameHelper nameHelper = new NameHelper();

	Image image = null;

	/**
	 * <p>
	 * <code>insertFaq</code>Method will insertFaq data from TAB_SUPPORT_FAQ
	 * </p>
	 * 
	 * @return target
	 * @throws OMIApplicationException
	 * @param SupportFaqVO
	 *            supportFaqVO
	 */
	public int insertFaq(SupportFaqVO supportFaqVO) throws Exception {

		int target = 0;
		try {
			connection = getConnection();
			String insrtFaqQuery = QueryMaker.INSERT_SUPPORT_FAQ;
			preparedStatement = connection.prepareStatement(insrtFaqQuery);
			preparedStatement.setString(1, supportFaqVO.getQuestion());
			preparedStatement.setString(2, supportFaqVO.getAnswer());
			preparedStatement.setString(3, supportFaqVO.getProductName());
			preparedStatement.setString(4, supportFaqVO.getCategory());
			preparedStatement.setString(5, supportFaqVO.getStatus());
			preparedStatement.setString(6, supportFaqVO.getOwner());
			preparedStatement.executeUpdate();
			target = 1;
		} catch (SQLException sqlException) {
			logger.error(
					"Error while creating the connection from Database  .",
					sqlException);
		} catch (Exception exception) {
			logger.error(
					"Error while  inserting the FAQ Information to TAB_SUPPORT_FAQ.",
					exception);
		} finally {
			JdbcHelper.closeStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return target;
	}

	/**
	 * <p>
	 * <code>getFaqGrid</code>Method will fetch data from TAB_SUPPORT_FAQ
	 * </p>
	 * 
	 * @return faqGridList
	 * @throws OMIApplicationException
	 *             List<SupportFaqVO> ArrayList<SupportFaqVO> faqGridList = new
	 *             ArrayList<SupportFaqVO>()
	 */

	public List<SupportFaqVO> getFaqGrid() throws Exception {
		ArrayList<SupportFaqVO> faqGridList = new ArrayList<SupportFaqVO>();
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_FAQ_GIRD_LIST);
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {
					SupportFaqVO supportFaqVO = new SupportFaqVO();
					supportFaqVO.setFaqId(resultSet.getInt("FAQ_ID"));
					supportFaqVO.setQuestion(resultSet.getString("QUESTION"));
					supportFaqVO.setAnswer(resultSet.getString("ANSWER"));
					supportFaqVO.setProductName(nameHelper
							.getFaqProductName(resultSet
									.getInt("REF_PRODUCT_NAME")));
					supportFaqVO.setCategory(nameHelper
							.getFaqCategory(resultSet
									.getInt("REF_FAQ_CATEGORY")));
					supportFaqVO.setStatus(FAQStatus.getFAQStatus(resultSet
							.getInt("FAQ_STATUS")));
					supportFaqVO.setOwner(nameHelper.getFaqOwner(resultSet
							.getInt("REF_FAQ_OWNER")));
					faqGridList.add(supportFaqVO);

				}
			}
		} catch (SQLException sqlExp) {
			sqlExp.printStackTrace();
			logger.error(SupportDaoImpl.class
					+ "Error: Occur in Query While Fetching the FAQ Details "
					+ "into Grid from Database.", sqlExp);
		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(SupportDaoImpl.class
					+ "Error: Occur in Query While Closing Connection After"
					+ " Fetching the FAQ Details into Grid from Database.",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return faqGridList;
	}

	/**
	 * <p>
	 * <code>viewFaqDetail</code>Method will view Faq Detail data from based
	 * faqId
	 * </p>
	 * 
	 * @return SupportFaq
	 * @throws OMIApplicationException
	 * @param (int faqId)
	 */
	@Override
	public SupportFaq viewFaqDetail(int faqId) throws Exception {
		SupportFaq supportFaq = new SupportFaq();

		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_SUPPORT_FAQ_VIEW);
			preparedStatement.setInt(1, faqId);
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {
					supportFaq.setFaqId(resultSet.getInt("FAQ_ID"));
					supportFaq.setQuestion(resultSet.getString("QUESTION"));
					supportFaq.setAnswer(resultSet.getString("ANSWER"));
					supportFaq.setProductName(nameHelper
							.getFaqProductName(resultSet
									.getInt("REF_PRODUCT_NAME")));
					supportFaq.setCategory(nameHelper.getFaqCategory(resultSet
							.getInt("REF_FAQ_CATEGORY")));
					supportFaq.setStatus(FAQStatus.getFAQStatus(resultSet
							.getInt("FAQ_STATUS")));
					supportFaq.setOwner(nameHelper.getFaqOwner(resultSet
							.getInt("REF_FAQ_OWNER")));

				}

			}
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(SupportDaoImpl.class
					+ ": Error:- Error: Occur in Query While View the Faq "
					+ "details from Database", sqlException);

		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(SupportDaoImpl.class
					+ ": Error:- While closing the Connection after View the "
					+ "Faq details from Database", exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}

		return supportFaq;
	}

	/**
	 * <p>
	 * <code>editFaqDetail</code>Method will edit Faq Detail data from based
	 * faqId
	 * </p>
	 * 
	 * @return supportFaq
	 * @throws OMIApplicationException
	 * @param (int faqId)
	 */
	@Override
	public SupportFaq editFaqDetail(int faqId) throws Exception {
		supportFaq = new SupportFaq();
		connection = getConnection();
		preparedStatement = connection
				.prepareStatement(QueryMaker.GET_SUPPORT_FAQ_EDIT);
		try {

			preparedStatement.setInt(1, faqId);
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {
					supportFaq.setFaqId(resultSet.getInt("FAQ_ID"));
					supportFaq.setQuestion(resultSet.getString("QUESTION"));
					supportFaq.setAnswer(resultSet.getString("ANSWER"));
					supportFaq.setProductName(resultSet
							.getString("REF_PRODUCT_NAME"));
					supportFaq.setCategory(resultSet
							.getString("REF_FAQ_CATEGORY"));
					supportFaq.setStatus(resultSet.getString("FAQ_STATUS"));
					supportFaq.setOwner(resultSet.getString("REF_FAQ_OWNER"));
				}

			}
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(SupportDaoImpl.class
					+ ": Error:- Error: Occur in Query While fetching the Faq"
					+ " details from Database", sqlException);

		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(SupportDaoImpl.class
					+ ": Error:- While closing the Connection after fetching "
					+ "the Faq details from Database", exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}

		return supportFaq;
	}

	/**
	 * <p>
	 * <code>updateFaqDetail</code>Method will Update Faq Detail data from based
	 * faqId
	 * </p>
	 * 
	 * @return target
	 * @throws OMIApplicationException
	 * @param (SupportFaqVO supportFaqVO, int faqId)
	 */
	@Override
	public int updateFaqDetail(SupportFaqVO supportFaqVO, int faqId)
			throws Exception {
		int target = 0;
		supportFaqVO.setFaqId(faqId);
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.UPDATE_SUPPORT_FAQ_INFORMATION);
			preparedStatement.setString(1, supportFaqVO.getQuestion());
			preparedStatement.setString(2, supportFaqVO.getAnswer());
			preparedStatement.setString(3, supportFaqVO.getProductName());
			preparedStatement.setString(4, supportFaqVO.getCategory());
			preparedStatement.setString(5, supportFaqVO.getStatus());
			preparedStatement.setString(6, supportFaqVO.getOwner());
			preparedStatement.setInt(7, faqId);
			preparedStatement.executeUpdate();
			target = 1;

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(SupportDaoImpl.class
					+ ": Error:- Error: Occur in Query While updating the FAQ "
					+ "details into Database", sqlException);

		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					SupportDaoImpl.class
							+ ": Error:- While closing the Connection after updating the "
							+ "FAQ details into Database", exception);
		} finally {
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return target;
	}

	@Override
	/**
	 * <p><code>insertCases</code>Method will insert Cases data from TAB_SUPPORT_CASES</p>
	 * @return target
	 * @throws OMIApplicationException
	 * @param SupportCasesVO supportCasesVO
	 */
	public int insertCases(SupportCasesVO supportCasesVO) throws Exception {
		int target = 0;
		try {
			connection = getConnection();
			String insertCasesQuery = QueryMaker.INSERT_SUPPORT_CASES;
			preparedStatement = connection.prepareStatement(insertCasesQuery);
			preparedStatement.setString(1, supportCasesVO.getCaseTitle());
			preparedStatement.setString(2, supportCasesVO.getContactName());
			preparedStatement
					.setString(3, supportCasesVO.getOrganiztionaName());
			preparedStatement.setString(4, supportCasesVO.getPrimaryEmail());
			preparedStatement.setString(5, supportCasesVO.getProductName());
			preparedStatement.setString(6, supportCasesVO.getResolution());
			preparedStatement.setString(7, supportCasesVO.getSlaName());
			preparedStatement.setString(8, supportCasesVO.getAssignedTo());
			preparedStatement.setString(9, supportCasesVO.getChannel());
			preparedStatement.setString(10, supportCasesVO.getImpactArea());
			preparedStatement.setString(11, supportCasesVO.getImpactType());
			preparedStatement.setString(12, supportCasesVO.getPriority());
			preparedStatement.setString(13, supportCasesVO.getTeam());
			preparedStatement.setString(14, supportCasesVO.getResolutionType());
			preparedStatement.setString(15, DateTimeUtil.getDeferredDate());
			preparedStatement.setString(16, supportCasesVO.getStatus());
			preparedStatement.executeUpdate();
			target = 1;
		} catch (SQLException sqlException) {
			logger.error(
					"Error while creating the connection from Database  .",
					sqlException);
		} catch (Exception exception) {
			logger.error(
					"Error while  inserting the Cases Information to TAB_SUPPORT_CASES.",
					exception);
		} finally {
			JdbcHelper.closeStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return target;
	}

	/**
	 * <p>
	 * <code>getCasesGrid</code>Method will show data from TAB_SUPPORT_CASES
	 * </p>
	 * 
	 * @return casesGridList
	 * @throws OMIApplicationException
	 *             List<SupportCasesVO> ArrayList<SupportCasesVO> casesGridList
	 *             = new ArrayList<SupportCasesVO>()
	 */
	@Override
	public List<SupportCasesVO> getCasesGrid() throws OMIApplicationException {
		List<SupportCasesVO> casesGridList = new ArrayList<SupportCasesVO>();
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_CASES_GIRD_LIST);
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {
					
					supportCasesVO=new SupportCasesVO();
					supportCasesVO.setCasesId(resultSet.getInt("CASES_ID"));
					supportCasesVO.setCaseTitle(resultSet
							.getString("CASES_TITLE"));
					supportCasesVO.setStatus(CasesStatus
							.getCASESStatus(resultSet.getInt("CASES_STATUS")));

					supportCasesVO.setStatus(CasesStatus.getCASESStatus(resultSet
							.getInt("CASES_STATUS")));
					supportCasesVO.setPriority(TicketPriority
							.getTicketPriority(resultSet
									.getInt("REF_CASES_PRIORITY")));
					supportCasesVO.setContactName(nameHelper
							.getTicketContactName(resultSet
									.getInt("CONTACT_NAME")));

					supportCasesVO.setProductName(nameHelper.getTicketProductName(resultSet
							.getInt("PRODUCT_NAME")));

					casesGridList.add(supportCasesVO);
				}
			}
		} catch (SQLException sqlExp) {
			sqlExp.printStackTrace();
			logger.error(
					SupportDaoImpl.class
							+ "Error: Occur in Query While Fetching the CASES Details into"
							+ " Grid from Database.", sqlExp);
		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					SupportDaoImpl.class
							+ "Error: Occur in Query While Closing Connection After Fetching "
							+ "the CASES Details into Grid from Database.",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return casesGridList;
	}

	/**
	 * <p>
	 * <code>updateCasesDetail</code>Method will Update Cases Detail data from
	 * based casesId
	 * </p>
	 * 
	 * @return target
	 * @throws OMIApplicationException
	 * @param SupportCasesVO
	 *            supportCasesVO, int casesId
	 */
	@Override
	public int updateCasesDetail(SupportCasesVO supportCasesVO, int casesId)
			throws Exception {
		int target = 0;
		supportCasesVO.setCasesId(casesId);
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.UPDATE_SUPPORT_CASES_INFORMATION);
			preparedStatement.setString(1, supportCasesVO.getCaseTitle());
			preparedStatement.setString(2, supportCasesVO.getContactName());
			preparedStatement
					.setString(3, supportCasesVO.getOrganiztionaName());
			preparedStatement.setString(4, supportCasesVO.getPrimaryEmail());
			preparedStatement.setString(5, supportCasesVO.getResolution());
			preparedStatement.setString(6, supportCasesVO.getSlaName());
			preparedStatement.setString(7, supportCasesVO.getAssignedTo());
			preparedStatement.setString(8, supportCasesVO.getChannel());
			preparedStatement.setString(9, supportCasesVO.getImpactArea());
			preparedStatement.setString(10, supportCasesVO.getImpactType());
			preparedStatement.setString(11, supportCasesVO.getPriority());
			preparedStatement.setString(12, supportCasesVO.getResolutionType());
			preparedStatement.setString(13, supportCasesVO.getStatus());
			preparedStatement.setString(14, supportCasesVO.getTeam());
			preparedStatement.setString(15, supportCasesVO.getProductName());
			preparedStatement.setString(16, DateTimeUtil.getDeferredDate());
			preparedStatement.setInt(17, casesId);

			/* preparedStatement.setInt(18, supportCasesVO.getCreatedBy()); */
			preparedStatement.executeUpdate();
			target = 1;

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					SupportDaoImpl.class
							+ ": Error:- Error: Occur in Query While updating the Cases"
							+ " details into Database", sqlException);

		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					SupportDaoImpl.class
							+ ": Error:- While closing the Connection after updating the"
							+ " Cases details into Database", exception);
		} finally {
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return target;
	}

	/**
	 * <p>
	 * <code>editCasesDetail</code>Method will edit CASES Detail data from based
	 * casesId
	 * </p>
	 * 
	 * @return SupportCases
	 * @throws OMIApplicationException
	 * @param (int casesId)
	 */
	@Override
	public SupportCases editCasesDetail(int casesId) throws Exception {

		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_SUPPORT_CASES_EDIT);
			preparedStatement.setInt(1, casesId);
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {
					supportCases = new SupportCases();
					supportCases.setCasesId(resultSet.getInt("CASES_ID"));
					supportCases.setCaseTitle(resultSet
							.getString("CASES_TITLE"));
					supportCases.setStatus(CasesStatus.getCASESStatus(resultSet
							.getInt("CASES_STATUS")));
					supportCases.setPriority(resultSet
							.getString("REF_CASES_PRIORITY"));
					supportCases.setContactName(resultSet
							.getString("CONTACT_NAME"));
					supportCases.setSlaName(resultSet.getString("SLA_NAME"));
					supportCases.setOrganiztionaName(resultSet
							.getString("ORGANIZATION_NAME"));
					supportCases.setAssignedTo(nameHelper
							.getTicketOwner(resultSet
									.getInt("REF_CASES_ASSIGNED_TO")));
					supportCases.setTeam(resultSet.getString("REF_CASES_TEAM"));
					supportCases.setProductName(resultSet
							.getString("PRODUCT_NAME"));
					supportCases.setChannel(resultSet
							.getString("REF_CASES_CHANNEL"));
					supportCases.setResolution(resultSet
							.getString("RESOLUTION"));
					supportCases.setPrimaryEmail(resultSet
							.getString("PRIMARY_EMAIL"));
					supportCases.setImpactArea(resultSet
							.getString("REF_CASES_IMPACT_AREA"));
					supportCases.setImpactType(resultSet
							.getString("REF_CASES_IMPACT_TYPE"));
					supportCases.setResolutionType(resultSet
							.getString("REF_CASES_RESOLUTION_TYPE"));
					supportCases.setDeferredDate(resultSet
							.getString("DEFERRD_DATE"));
				}
			}
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					SupportDaoImpl.class
							+ ": Error:- Error: Occur in Query While fetching the Cases"
							+ " details from Database", sqlException);

		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					SupportDaoImpl.class
							+ ": Error:- While closing the Connection after fetching the"
							+ " Cases details from Database", exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return supportCases;
	}

	/**
	 * <p>
	 * <code>viewCasesDetail</code>Method will view Cases Detail data from based
	 * casesId
	 * </p>
	 * 
	 * @return supportCases
	 * @throws OMIApplicationException
	 * @param (int faqId)
	 */
	@Override
	public SupportCases viewCasesDetail(int casesId) throws Exception {
		
		try {

			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_SUPPORT_CASES_VIEW);

			preparedStatement.setInt(1, casesId);
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {
					supportCases=new SupportCases();
					supportCases.setCasesId(resultSet.getInt("CASES_ID"));
					supportCases.setCaseTitle(resultSet
							.getString("CASES_TITLE"));
					supportCases.setStatus(CasesStatus.getCASESStatus(resultSet
							.getInt("CASES_STATUS")));
					supportCases.setPriority(TicketPriority
							.getTicketPriority(resultSet
									.getInt("REF_CASES_PRIORITY")));
					supportCases.setContactName(nameHelper
							.getTicketContactName(resultSet
									.getInt("CONTACT_NAME")));
					supportCases.setSlaName(nameHelper
							.getCasesSlaName(resultSet.getInt("SLA_NAME")));
					supportCases.setOrganiztionaName(nameHelper
							.getCasesOrgnization(resultSet
									.getInt("ORGANIZATION_NAME")));
					supportCases.setAssignedTo(nameHelper
							.getCasesAssignedTo(resultSet
									.getInt("REF_CASES_ASSIGNED_TO")));

					supportCases.setTeam(nameHelper.getCasesTeam(resultSet
							.getInt("REF_CASES_TEAM")));
					supportCases.setProductName(nameHelper
							.getTicketProductName(resultSet
									.getInt("PRODUCT_NAME")));
					supportCases.setChannel(nameHelper
							.getCasesChannel(resultSet
									.getInt("REF_CASES_CHANNEL")));
					supportCases.setResolution(resultSet
							.getString("RESOLUTION"));
					supportCases.setPrimaryEmail(resultSet
							.getString("PRIMARY_EMAIL"));
					supportCases.setImpactArea(nameHelper
							.getCasesImpactArea(resultSet
									.getInt("REF_CASES_IMPACT_AREA")));
					supportCases.setImpactType(nameHelper
							.getCasesImpactType(resultSet
									.getInt("REF_CASES_IMPACT_TYPE")));
					supportCases.setResolutionType(nameHelper
							.getCasesResolutionType(resultSet
									.getInt("REF_CASES_RESOLUTION_TYPE")));

					supportCases.setDeferredDate(resultSet
							.getString("DEFERRD_DATE"));

				}

			}
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					SupportDaoImpl.class
							+ ": Error:- Error: Occur in Query While View the Cases details "
							+ "from Database", sqlException);

		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					SupportDaoImpl.class
							+ ": Error:- While closing the Connection after View the Cases details "
							+ "from Database", exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}

		return supportCases;
	}

	/**
	 * <p>
	 * <code>deleteSupportFaqDetail</code>Method will delete faq Detail data
	 * from based faqId
	 * </p>
	 * 
	 * @throws OMIApplicationException
	 * @param (int faqId)
	 */
	@Override
	public int deleteSupportFaqDetail(int faqId) throws OMIApplicationException {
		int target = 0;
		String query = QueryMaker.DELETE_FAQ_DETAIL;
		try {

			connection = getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, faqId);
			preparedStatement.executeUpdate();
			target = 1;

		} catch (Exception exception) {
			logger.error(SupportDaoImpl.class
					+ ": Error:- While deletng Faq details from Database.");
		} finally {
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);

		}
		return target;
	}

	/**
	 * <p>
	 * <code>deleteSupportCasesDetail</code>Method will delete Cases Detail data
	 * from based casesId
	 * </p>
	 * 
	 * @throws OMIApplicationException
	 * @param (int casesId)
	 */
	@Override
	public int deleteSupportCasesDetail(int casesId)
			throws OMIApplicationException {
		int target = 0;
		String query = QueryMaker.DELETE_CASES_DETAIL;
		try {

			connection = getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, casesId);
			preparedStatement.executeUpdate();
			target = 1;
		} catch (Exception exception) {
			logger.error(SupportDaoImpl.class
					+ ": Error:- While deletng Cases details from Database.");
		} finally {
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);

		}
		return target;
	}

	/**
	 * <p>
	 * <code>insertTicket</code>Method will insert Ticket data from
	 * TAB_SUPPORT_TICKET
	 * </p>
	 * 
	 * @return target
	 * @throws OMIApplicationException
	 * @param TicketVO
	 *            ticketVO
	 */

	public int insertTicket(TicketVO ticketVO) throws Exception {
		int target = 0;
		try {
			connection = getConnection();
			String insrtTicketQuery = QueryMaker.INSERT_SUPPORT_TICKET;
			preparedStatement = connection.prepareStatement(insrtTicketQuery);
			preparedStatement.setString(1, ticketVO.getCategory());
			preparedStatement.setString(2, ticketVO.getTicketOwner());
			preparedStatement.setString(3, ticketVO.getPhoneNo());
			preparedStatement.setString(4, ticketVO.getPhoneStd());
			preparedStatement.setString(5, ticketVO.getPhoneIsd());
			preparedStatement.setString(6, ticketVO.getEmail());
			preparedStatement.setString(7, ticketVO.getSubject());
			preparedStatement.setString(8, DateTimeUtil.getDueDate());
			preparedStatement.setString(9, ticketVO.getPriority());
			preparedStatement.setString(10, ticketVO.getChannel());
			/* preparedStatement.setString(11, ticketVO.getUploadFile()); */
			preparedStatement.setString(11, ticketVO.getDescription());
			preparedStatement.setString(12, ticketVO.getStatus());
			preparedStatement.setString(13, ticketVO.getProductName());
			preparedStatement.setString(14, ticketVO.getContactName());

			preparedStatement.executeUpdate();
			target = 1;
		} catch (SQLException sqlException) {
			logger.error(
					"Error while creating the connection from Database  .",
					sqlException);
		} catch (Exception exception) {
			logger.error(
					"Error while  inserting the Ticket Information to TAB_SUPPORT_TICKET.",
					exception);
		} finally {
			JdbcHelper.closeStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return target;
	}

	/**
	 * <p>
	 * <code>getTicketGrid</code>Method will fetch Ticket data from
	 * TAB_SUPPORT_TICKET
	 * </p>
	 * 
	 * @return List
	 * @throws OMIApplicationException
	 * @param List
	 *            TicketVO
	 */
	public List<TicketVO> getTicketGrid() throws Exception {
		ArrayList<TicketVO> ticketGridList = new ArrayList<TicketVO>();
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_TICKET_GIRD_LIST);
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {
					TicketVO ticketVO = new TicketVO();
					ticketVO.setTicketId(resultSet.getInt("TICKET_ID"));
					ticketVO.setCategory(nameHelper.getTicketCategory(resultSet
							.getInt("REF_CATEGORY")));
					ticketVO.setTicketOwner(nameHelper.getTicketOwner(resultSet
							.getInt("REF_TICKET_OWNER")));
					ticketVO.setPhoneNo(resultSet.getString("PHONE_NO"));
					ticketVO.setPhoneIsd(resultSet.getString("PHONE_ISD"));
					ticketVO.setPhoneStd(resultSet.getString("PHONE_STD"));
					ticketVO.setEmail(resultSet.getString("EMAIL"));
					ticketVO.setSubject(resultSet.getString("SUBJECT"));
					ticketVO.setDueDate(resultSet.getString("DUE_DATE_TIME"));
					ticketVO.setPriority(TicketPriority
							.getTicketPriority(resultSet.getInt("PRIORITY")));
					ticketVO.setChannel(nameHelper.getTicketChannel(resultSet
							.getInt("REF_CHANNEL")));
					/*
					 * ticketVO.setUploadFile(resultSet.getString("ATTACHMENT"));
					 */
					ticketVO.setDescription(resultSet.getString("DESCRIPTION"));
					ticketVO.setStatus(TicketStatus.getTicketStatus(resultSet
							.getInt("STATUS")));
					ticketVO.setContactName(nameHelper
							.getTicketContactName(resultSet
									.getInt("REF_CONTACT_NAME")));
					ticketVO.setProductName(nameHelper
							.getTicketProductName(resultSet
									.getInt("REF_PRODUCT_NAME")));
					ticketGridList.add(ticketVO);
				}
			}
		} catch (SQLException sqlExp) {
			sqlExp.printStackTrace();
			logger.error(SupportDaoImpl.class
					+ "Error: Occur in Query While Fetching the Ticket Details"
					+ " into Grid from Database.", sqlExp);
		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					SupportDaoImpl.class
							+ "Error: Occur in Query While Closing Connection After Fetching "
							+ "the Ticket Details into Grid from Database.",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return ticketGridList;
	}

	/**
	 * <p>
	 * <code>editTicketDetail</code>Method will edit ticket Detail data from
	 * based ticketId
	 * </p>
	 * 
	 * @return supportTicket
	 * @throws OMIApplicationException
	 * @param (int ticketId)
	 */
	public SupportTicket editTicketDetail(int ticketId) throws Exception {
		supportTicket = new SupportTicket();
		connection = getConnection();
		preparedStatement = connection
				.prepareStatement(QueryMaker.GET_SUPPORT_TICKET_EDIT);
		try {

			preparedStatement.setInt(1, ticketId);
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {
					supportTicket.setTicketId(resultSet.getInt("TICKET_ID"));
					supportTicket.setCategory(resultSet
							.getString("REF_CATEGORY"));
					supportTicket.setTicketOwner(resultSet
							.getString("REF_TICKET_OWNER"));
					supportTicket.setPhoneNo(resultSet.getString("PHONE_NO"));
					supportTicket.setPhoneIsd(resultSet.getString("PHONE_ISD"));
					supportTicket.setPhoneStd(resultSet.getString("PHONE_STD"));
					supportTicket.setEmail(resultSet.getString("EMAIL"));
					supportTicket.setSubject(resultSet.getString("SUBJECT"));
					supportTicket.setDueDate(resultSet
							.getString("DUE_DATE_TIME"));
					supportTicket.setPriority(resultSet.getString("PRIORITY"));
					supportTicket
							.setChannel(resultSet.getString("REF_CHANNEL"));
					/*
					 * supportTicket.setUploadFile(resultSet
					 * .getString("ATTACHMENT"));
					 */
					supportTicket.setDescription(resultSet
							.getString("DESCRIPTION"));
					supportTicket.setStatus(resultSet.getString("STATUS"));
					supportTicket.setContactName(resultSet
							.getString("REF_CONTACT_NAME"));
					supportTicket.setProductName(resultSet
							.getString("REF_PRODUCT_NAME"));
				}
			}
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					SupportDaoImpl.class
							+ ": Error:- Error: Occur in Query While fetching the Ticket"
							+ " details from Database", sqlException);

		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					SupportDaoImpl.class
							+ ": Error:- While closing the Connection after fetching the "
							+ "Ticket details from Database", exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}

		return supportTicket;
	}

	/**
	 * <p>
	 * <code>updateTicketDetail</code>Method will Update ticket Detail data from
	 * based ticketId
	 * </p>
	 * 
	 * @return target
	 * @throws OMIApplicationException
	 * @param (TicketVO ticketVO, int ticketId)
	 */
	public int updateTicketDetail(TicketVO ticketVO, int ticketId)
			throws Exception {
		int target = 0;
		ticketVO.setTicketId(ticketId);
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.UPDATE_TICKET_INFORMATION);
			preparedStatement.setString(1, ticketVO.getCategory());
			preparedStatement.setString(2, ticketVO.getTicketOwner());
			preparedStatement.setString(3, ticketVO.getPhoneNo());
			preparedStatement.setString(4, ticketVO.getPhoneStd());
			preparedStatement.setString(5, ticketVO.getPhoneIsd());
			preparedStatement.setString(6, ticketVO.getEmail());
			preparedStatement.setString(7, ticketVO.getSubject());
			preparedStatement.setString(8, DateTimeUtil.getDueDate());
			preparedStatement.setString(9, ticketVO.getPriority());
			preparedStatement.setString(10, ticketVO.getChannel());
			preparedStatement.setString(11, ticketVO.getDescription());
			preparedStatement.setString(12, ticketVO.getStatus());
			preparedStatement.setString(13, ticketVO.getProductName());
			preparedStatement.setString(14, ticketVO.getContactName());
			preparedStatement.setInt(15, ticketId);
			preparedStatement.executeUpdate();
			target = 1;

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					SupportDaoImpl.class
							+ ": Error:- Error: Occur in Query While updating the Ticket"
							+ " details into Database", sqlException);

		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					SupportDaoImpl.class
							+ ": Error:- While closing the Connection after updating the Ticket"
							+ " details into Database", exception);
		} finally {
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return target;
	}

	/**
	 * <p>
	 * <code>viewTicketDetail</code>Method will view Ticket Detail data from
	 * based ticketId
	 * </p>
	 * 
	 * @return supportTicket
	 * @throws OMIApplicationException
	 * @param (int ticketId)
	 */

	public SupportTicket viewTicketDetail(int ticketId) throws Exception {
		SupportTicket supportTicket = new SupportTicket();

		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_SUPPORT_TICKET_VIEW);
			preparedStatement.setInt(1, ticketId);
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {
					supportTicket.setTicketId(resultSet.getInt("TICKET_ID"));
					supportTicket
							.setCategory(nameHelper.getTicketCategory(resultSet
									.getInt("REF_CATEGORY")));
					supportTicket.setTicketOwner(nameHelper
							.getTicketOwner(resultSet
									.getInt("REF_TICKET_OWNER")));
					supportTicket.setPhoneNo(resultSet.getString("PHONE_NO"));
					supportTicket.setPhoneIsd(resultSet.getString("PHONE_ISD"));
					supportTicket.setPhoneStd(resultSet.getString("PHONE_STD"));
					supportTicket.setEmail(resultSet.getString("EMAIL"));
					supportTicket.setSubject(resultSet.getString("SUBJECT"));
					supportTicket.setDueDate(resultSet
							.getString("DUE_DATE_TIME"));
					supportTicket.setPriority(TicketPriority
							.getTicketPriority(resultSet.getInt("PRIORITY")));
					supportTicket.setChannel(nameHelper
							.getTicketChannel(resultSet.getInt("REF_CHANNEL")));
					/*
					 * ticketVO.setUploadFile(resultSet.getString("ATTACHMENT"));
					 */
					supportTicket.setDescription(resultSet
							.getString("DESCRIPTION"));
					supportTicket.setStatus(TicketStatus
							.getTicketStatus(resultSet.getInt("STATUS")));
					supportTicket.setContactName(nameHelper
							.getTicketContactName(resultSet
									.getInt("REF_CONTACT_NAME")));
					supportTicket.setProductName(nameHelper
							.getTicketProductName(resultSet
									.getInt("REF_PRODUCT_NAME")));
				}

			}
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(SupportDaoImpl.class
					+ ": Error:- Error: Occur in Query While View the Ticket"
					+ " details from Database", sqlException);

		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					SupportDaoImpl.class
							+ ": Error:- While closing the Connection after View the Faq "
							+ "details from Database", exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}

		return supportTicket;
	}

	/**
	 * <p>
	 * <code>deleteTicketDetail</code>Method will delete ticket Detail data from
	 * based ticketId
	 * </p>
	 * 
	 * @throws OMIApplicationException
	 * @param (int ticketId)
	 */
	public void deleteTicketDetail(int ticketId) throws Exception {
		String query = QueryMaker.DELETE_TICKET_DETAIL;
		try {

			connection = getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, ticketId);
			preparedStatement.executeUpdate();

		} catch (Exception exception) {
			logger.error(SupportDaoImpl.class
					+ ": Error:- While deletng ticket details from Database.");
		} finally {
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);

		}

	}

	/**
	 * <p>
	 * <code>getFaqLastRecord</code>Method will get Faq Last Record data from
	 * based faqId
	 * </p>
	 * 
	 * @return
	 * @throws OMIApplicationException
	 * @param
	 */
	public int getFaqLastRecord() throws Exception {
		int temp = 0;
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_LAST_RECORD_FAQ_ID);
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {

					temp = resultSet.getInt("FAQ_ID");

				}
			}
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(SupportDaoImpl.class
					+ ": Error:- Error: Occur in Query While counting "
					+ "the Faq recodes from Database", sqlException);

		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(SupportDaoImpl.class
					+ ": Error:- While closing the Connection after counting"
					+ " the Faq recodes from Database", exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return temp;
	}

	/**
	 * <p>
	 * <code>getFaqDetails</code>Method will get Faq Details Detail data from
	 * based faqId
	 * </p>
	 * 
	 * @return supportFaq
	 * @throws OMIApplicationException
	 * @param int faqId
	 */

	public SupportFaq getFaqDetails(int faqId) throws Exception {
		supportFaq = new SupportFaq();
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.SHOW_VIEW_FAQ);
			preparedStatement.setInt(1, faqId);
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {
					supportFaq.setFaqId(resultSet.getInt("FAQ_ID"));
					supportFaq.setQuestion(resultSet.getString("QUESTION"));
					supportFaq.setAnswer(resultSet.getString("ANSWER"));
					supportFaq.setProductName(nameHelper
							.getTicketProductName(resultSet
									.getInt("REF_PRODUCT_NAME")));
					supportFaq.setCategory(nameHelper
							.getTicketCategory(resultSet
									.getInt("REF_FAQ_CATEGORY")));
					supportFaq.setStatus(TicketStatus.getTicketStatus(resultSet
							.getInt("FAQ_STATUS")));
					supportFaq.setOwner(nameHelper.getTicketOwner(resultSet
							.getInt("REF_FAQ_OWNER")));
				}
			}
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(SupportDaoImpl.class
					+ ": Error:- Error: Occur in Query While fetching the"
					+ " Faq details for view from Database", sqlException);

		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(SupportDaoImpl.class
					+ ": Error:- While closing the Connection after fetching"
					+ " the Faq details for view from Database", exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return supportFaq;
	}

	/**
	 * <p>
	 * <code>getFaqDetailsForUpdate</code>Method will get Faq Details For Update
	 * data from based faqId
	 * </p>
	 * 
	 * @return
	 * @throws OMIApplicationException
	 * @param int faqId
	 */

	public SupportFaq getFaqDetailsForUpdate(int faqId) throws Exception {
		supportFaq = new SupportFaq();
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.SHOW_VIEW_FAQ);
			preparedStatement.setInt(1, faqId);
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {
					supportFaq.setFaqId(resultSet.getInt("FAQ_ID"));
					supportFaq.setQuestion(resultSet.getString("QUESTION"));
					supportFaq.setAnswer(resultSet.getString("ANSWER"));
					supportFaq.setProductName(nameHelper
							.getFaqProductName(resultSet
									.getInt("REF_PRODUCT_NAME")));
					supportFaq.setCategory(nameHelper.getFaqCategory(resultSet
							.getInt("REF_FAQ_CATEGORY")));
					supportFaq.setStatus(FAQStatus.getFAQStatus(resultSet
							.getInt("FAQ_STATUS")));
					supportFaq.setOwner(nameHelper.getFaqOwner(resultSet
							.getInt("REF_FAQ_OWNER")));

				}
			}
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(SupportDaoImpl.class
					+ ": Error:- Error: Occur in Query While fetching the Faq"
					+ " details for view from Database", sqlException);

		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					SupportDaoImpl.class
							+ ": Error:- While closing the Connection after fetching the "
							+ "Faq details for view from Database", exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return supportFaq;
	}

	/**
	 * <p>
	 * <code>getCasesLastRecord</code>Method will get Cases Last Record data
	 * from based casesId
	 * </p>
	 * 
	 * @return
	 * @throws OMIApplicationException
	 * @param
	 */
	public int getCasesLastRecord() throws Exception {
		int temp = 0;
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_LAST_RECORD_CASES_ID);
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {

					temp = resultSet.getInt("CASES_ID");

				}
			}
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(SupportDaoImpl.class
					+ ": Error:- Error: Occur in Query While counting the"
					+ " Cases recodes from Database", sqlException);

		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					SupportDaoImpl.class
							+ ": Error:- While closing the Connection after counting the "
							+ "Cases recodes from Database", exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return temp;
	}

	/**
	 * <p>
	 * <code>getCasesDetails</code>Method will get Cases Details data from based
	 * casesId
	 * </p>
	 * 
	 * @return SupportCases
	 * @throws OMIApplicationException
	 * @param int casesId
	 */
	public SupportCases getCasesDetails(int casesId) throws Exception {
		supportCases = new SupportCases();
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.SHOW_VIEW_CASES);
			preparedStatement.setInt(1, casesId);
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {
					supportCases.setCasesId(resultSet.getInt("CASES_ID"));
					supportCases.setCaseTitle(resultSet
							.getString("CASES_TITLE"));
					
					  supportCases.setStatus(CasesStatus.getCASESStatus(resultSet
					 .getInt("CASES_STATUS")));
					
					supportCases.setPriority(TicketPriority
							.getTicketPriority(resultSet
									.getInt("REF_CASES_PRIORITY")));
					supportCases.setContactName(nameHelper
							.getTicketContactName(resultSet
									.getInt("CONTACT_NAME")));
					supportCases.setSlaName(resultSet.getString("SLA_NAME"));
					supportCases.setOrganiztionaName(nameHelper
							.getCasesOrgnization(resultSet
									.getInt("ORGANIZATION_NAME")));
					supportCases.setAssignedTo(nameHelper
							.getTicketOwner(resultSet
									.getInt("REF_CASES_ASSIGNED_TO")));
					supportCases.setTeam(nameHelper.getCasesTeam(resultSet
							.getInt("REF_CASES_TEAM")));
					supportCases.setProductName(nameHelper
							.getTicketProductName(resultSet
							.getInt("PRODUCT_NAME")));
					supportCases.setChannel(nameHelper.getCasesChannel(resultSet
							.getInt("REF_CASES_CHANNEL")));
					supportCases.setResolution(resultSet
							.getString("RESOLUTION"));
					supportCases.setPrimaryEmail(resultSet
							.getString("PRIMARY_EMAIL"));
					supportCases.setImpactArea(nameHelper.getCasesImpactArea(resultSet
							.getInt("REF_CASES_IMPACT_AREA")));
					supportCases.setImpactType(nameHelper.getCasesImpactType(resultSet
							.getInt("REF_CASES_IMPACT_TYPE")));
					supportCases.setResolutionType(nameHelper.getCasesResolutionType(resultSet
							.getInt("REF_CASES_RESOLUTION_TYPE")));
					supportCases.setDeferredDate(resultSet
							.getString("DEFERRD_DATE"));
				}
			}
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					SupportDaoImpl.class
							+ ": Error:- Error: Occur in Query While fetching the Cases "
							+ "details for view from Database", sqlException);

		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					SupportDaoImpl.class
							+ ": Error:- While closing the Connection after fetching the "
							+ "Cases details for view from Database", exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return supportCases;
	}

	/**
	 * <p>
	 * <code>getCasesDetailsForUpdate</code>Method will get get Cases Details
	 * For Update data from based casesId
	 * </p>
	 * 
	 * @return SupportCases
	 * @throws OMIApplicationException
	 * @param int casesId
	 */
	public SupportCases getCasesDetailsForUpdate(int casesId) throws Exception {
		supportCases = new SupportCases();
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.SHOW_VIEW_CASES);
			preparedStatement.setInt(1, casesId);
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {
					supportCases.setCasesId(resultSet.getInt("CASES_ID"));
					supportCases.setCaseTitle(resultSet
							.getString("CASES_TITLE"));
					/*
					 * supportCases.setStatus(CasesStatus.getCASESStatus(resultSet
					 * .getInt("CASES_STATUS")));
					 */
					supportCases.setPriority(TicketPriority
							.getTicketPriority(resultSet
									.getInt("REF_CASES_PRIORITY")));
					supportCases.setContactName(nameHelper
							.getTicketContactName(resultSet
									.getInt("CONTACT_NAME")));
					supportCases.setSlaName(resultSet.getString("SLA_NAME"));
					supportCases.setOrganiztionaName(resultSet
							.getString("ORGANIZATION_NAME"));
					supportCases.setAssignedTo(nameHelper
							.getTicketOwner(resultSet
									.getInt("REF_CASES_ASSIGNED_TO")));
					supportCases.setTeam(resultSet.getString("REF_CASES_TEAM"));
					supportCases.setProductName(resultSet
							.getString("PRODUCT_NAME"));
					supportCases.setChannel(resultSet
							.getString("REF_CASES_CHANNEL"));
					supportCases.setResolution(resultSet
							.getString("RESOLUTION"));
					supportCases.setPrimaryEmail(resultSet
							.getString("PRIMARY_EMAIL"));
					supportCases.setImpactArea(resultSet
							.getString("REF_CASES_IMPACT_AREA"));
					supportCases.setImpactType(resultSet
							.getString("REF_CASES_IMPACT_TYPE"));
					supportCases.setResolutionType(resultSet
							.getString("REF_CASES_RESOLUTION_TYPE"));
					supportCases.setDeferredDate(resultSet
							.getString("DEFERRD_DATE"));

				}
			}
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					SupportDaoImpl.class
							+ ": Error:- Error: Occur in Query While fetching the Cases"
							+ " details for view from Database", sqlException);

		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					SupportDaoImpl.class
							+ ": Error:- While closing the Connection after fetching the"
							+ " Cases details for view from Database",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return supportCases;
	}

	/**
	 * <p>
	 * <code>getTicketDetails</code>Method will get Ticket Details data from
	 * based casesId
	 * </p>
	 * 
	 * @return SupportTicket
	 * @throws OMIApplicationException
	 * @param int ticketId
	 */
	public SupportTicket getTicketDetails(int ticketId) throws Exception {
		supportTicket = new SupportTicket();
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.SHOW_VIEW_TICKET);
			preparedStatement.setInt(1, ticketId);
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {
					supportTicket.setTicketId(resultSet.getInt("TICKET_ID"));
					supportTicket
							.setCategory(nameHelper.getTicketCategory(resultSet
									.getInt("REF_CATEGORY")));
					supportTicket.setTicketOwner(nameHelper
							.getTicketOwner(resultSet
									.getInt("REF_TICKET_OWNER")));
					supportTicket.setPhoneNo(resultSet.getString("PHONE_NO"));
					supportTicket.setPhoneIsd(resultSet.getString("PHONE_ISD"));
					supportTicket.setPhoneStd(resultSet.getString("PHONE_STD"));
					supportTicket.setEmail(resultSet.getString("EMAIL"));
					supportTicket.setSubject(resultSet.getString("SUBJECT"));
					supportTicket.setDueDate(resultSet
							.getString("DUE_DATE_TIME"));
					supportTicket.setPriority(TicketPriority
							.getTicketPriority(resultSet.getInt("PRIORITY")));
					supportTicket.setChannel(nameHelper
							.getTicketChannel(resultSet.getInt("REF_CHANNEL")));
					/*
					 * supportTicket.setUploadFile(resultSet
					 * .getString("ATTACHMENT"));
					 */
					supportTicket.setDescription(resultSet
							.getString("DESCRIPTION"));
					supportTicket.setStatus(TicketStatus
							.getTicketStatus(resultSet.getInt("STATUS")));
					supportTicket.setContactName(nameHelper
							.getTicketContactName(resultSet
									.getInt("REF_CONTACT_NAME")));
					supportTicket.setProductName(nameHelper
							.getTicketProductName(resultSet
									.getInt("REF_PRODUCT_NAME")));

				}
			}
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					SupportDaoImpl.class
							+ ": Error:- Error: Occur in Query While fetching the Ticket details"
							+ " for view from Database", sqlException);

		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					SupportDaoImpl.class
							+ ": Error:- While closing the Connection after fetching the Ticket"
							+ " details for view from Database", exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return supportTicket;
	}

	/**
	 * <p>
	 * <code>getTicketDetailsForUpdate</code>Method will get Ticket Details For
	 * Update data from based casesId
	 * </p>
	 * 
	 * @return SupportTicket
	 * @throws OMIApplicationException
	 * @param int ticketId
	 */
	public SupportTicket getTicketDetailsForUpdate(int ticketId)
			throws Exception {
		supportTicket = new SupportTicket();
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.SHOW_VIEW_TICKET);
			preparedStatement.setInt(1, ticketId);
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {
					supportTicket.setTicketId(resultSet.getInt("TICKET_ID"));
					supportTicket.setCategory(resultSet
							.getString("REF_CATEGORY"));
					supportTicket.setTicketOwner(resultSet
							.getString("REF_TICKET_OWNER"));
					supportTicket.setPhoneNo(resultSet.getString("PHONE_NO"));
					supportTicket.setPhoneIsd(resultSet.getString("PHONE_ISD"));
					supportTicket.setPhoneStd(resultSet.getString("PHONE_STD"));
					supportTicket.setEmail(resultSet.getString("EMAIL"));
					supportTicket.setSubject(resultSet.getString("SUBJECT"));
					supportTicket.setDueDate(resultSet
							.getString("DUE_DATE_TIME"));
					supportTicket.setPriority(resultSet.getString("PRIORITY"));
					supportTicket
							.setChannel(resultSet.getString("REF_CHANNEL"));
					/*
					 * supportTicket.setUploadFile(resultSet
					 * .getString("ATTACHMENT"));
					 */
					supportTicket.setDescription(resultSet
							.getString("DESCRIPTION"));
					supportTicket.setStatus(resultSet.getString("STATUS"));
					supportTicket.setContactName(resultSet
							.getString("REF_CONTACT_NAME"));
					supportTicket.setProductName(resultSet
							.getString("REF_PRODUCT_NAME"));

				}
			}
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					SupportDaoImpl.class
							+ ": Error:- Error: Occur in Query While fetching the Ticket"
							+ " details for view from Database", sqlException);

		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					SupportDaoImpl.class
							+ ": Error:- While closing the Connection after fetching the Ticket"
							+ " details for view from Database", exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return supportTicket;
	}

	/**
	 * <p>
	 * <code>getTicketLastRecord</code>Method will get Ticket Details For Update
	 * data from based ticketId
	 * </p>
	 * 
	 * @return temp
	 * @throws OMIApplicationException
	 * @param int ticketId
	 */
	public int getTicketLastRecord() throws Exception {
		int temp = 0;
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_LAST_RECORD_TICKET_ID);
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {

					temp = resultSet.getInt("TICKET_ID");

				}
			}
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(SupportDaoImpl.class
					+ ": Error:- Error: Occur in Query While counting the"
					+ " Ticket recodes from Database", sqlException);

		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(SupportDaoImpl.class
					+ ": Error:- While closing the Connection after counting"
					+ " the Ticket recodes from Database", exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return temp;
	}

	/**
	 * <p>
	 * <code>getFaqDetailsGrid</code>Method will get Faq Details For Update data
	 * from based faqId
	 * </p>
	 * 
	 * @return List<SupportFaqVO>
	 * @throws OMIApplicationException
	 * @param int searchId, String searchValue
	 */
	public List<SupportFaqVO> getFaqDetailsGrid(int searchId, String searchValue)
			throws Exception {

		List<SupportFaqVO> faqGridList = new ArrayList<SupportFaqVO>();

		try {

			connection = getConnection();
			preparedStatement = connection.prepareStatement(QueryBuilder
					.faqAdvanceSearch(searchId, searchValue));
			resultSet = preparedStatement.executeQuery();

			// FAQ_ID,QUESTION,REF_FAQ_CATEGORY,REF_PRODUCT_NAME,REF_FAQ_OWNER,FAQ_STATUS
			while (resultSet.next()) {
				supportFaqVO = new SupportFaqVO();
				supportFaqVO.setFaqId(resultSet.getInt("FAQ_ID"));
				supportFaqVO.setQuestion(resultSet.getString("QUESTION"));
				supportFaqVO.setCategory(nameHelper.getFaqCategory(resultSet
						.getInt("REF_FAQ_CATEGORY")));
				supportFaqVO
						.setProductName(nameHelper.getFaqProductName(resultSet
								.getInt("REF_PRODUCT_NAME")));
				supportFaqVO.setOwner(nameHelper.getFaqOwner(resultSet
						.getInt("REF_FAQ_OWNER")));
				supportFaqVO.setStatus(FAQStatus.getFAQStatus(resultSet
						.getInt("FAQ_STATUS")));
				faqGridList.add(supportFaqVO);
			}

		} catch (SQLException sqlExp) {
			sqlExp.printStackTrace();
			logger.error(SupportDaoImpl.class
					+ "Error: Occur in Query While Fetching the Faq"
					+ " Details into Grid from Database.", sqlExp);
		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(SupportDaoImpl.class
					+ "Error: Occur in Query While Closing Connection After"
					+ " Fetching the Faq Details into Grid from Database.",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return faqGridList;
	}

	/**
	 * <p>
	 * <code>getCasesDetailsGrid</code>Method will get Cases Details For Update
	 * data from based casesId
	 * </p>
	 * 
	 * @return List<SupportCasesVO>
	 * @throws OMIApplicationException
	 * @param int searchId, String searchValue
	 */
	public List<SupportCasesVO> getCasesDetailsGrid(int searchId,
			String searchValue) throws OMIApplicationException {

		List<SupportCasesVO> casesGridList = new ArrayList<SupportCasesVO>();

		try {

			connection = getConnection();
			preparedStatement = connection.prepareStatement(QueryBuilder
					.casesAdvanceSearch(searchId, searchValue));
			resultSet = preparedStatement.executeQuery();

			// CASES_ID,CASES_TITLE,CONTACT_NAME,REF_CASES_PRIORITY,CASES_STATUS
			while (resultSet.next()) {
				supportCasesVO=new SupportCasesVO();
				supportCasesVO.setCasesId(resultSet.getInt("CASES_ID"));
				supportCasesVO.setCaseTitle(resultSet.getString("CASES_TITLE"));
				supportCasesVO
						.setContactName(nameHelper
								.getTicketContactName(resultSet
										.getInt("CONTACT_NAME")));
				supportCasesVO.setPriority(TicketPriority
						.getTicketPriority(resultSet
								.getInt("REF_CASES_PRIORITY")));
				
				  supportCasesVO.setStatus(CasesStatus.getCASESStatus(resultSet
				 .getInt("CASES_STATUS")));
				 
				casesGridList.add(supportCasesVO);

			}

		} catch (SQLException sqlExp) {
			sqlExp.printStackTrace();
			logger.error(SupportDaoImpl.class
					+ "Error: Occur in Query While Fetching the "
					+ "Cases Details into Grid from Database.", sqlExp);
		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					SupportDaoImpl.class
							+ "Error: Occur in Query While Closing Connection "
							+ "After Fetching the Cases Details into Grid from Database.",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return casesGridList;
	}

	/**
	 * <p>
	 * <code>getTicketDetailsGrid</code>Method will get Cases Details For Update
	 * data from based casesId
	 * </p>
	 * 
	 * @return List<TicketVO>
	 * @throws OMIApplicationException
	 * @param int searchId, String searchValue
	 */
	public List<TicketVO> getTicketDetailsGrid(int searchId, String searchValue)
			throws Exception {
		List<TicketVO> ticketGridList = new ArrayList<TicketVO>();
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(QueryBuilder
					.ticketAdvanceSearch(searchId, searchValue));
			resultSet = preparedStatement.executeQuery();

			// CASES_ID,CASES_TITLE,CONTACT_NAME,REF_CASES_PRIORITY,CASES_STATUS
			while (resultSet.next()) {
				TicketVO ticketVO = new TicketVO();
				ticketVO.setTicketId(resultSet.getInt("TICKET_ID"));
				ticketVO.setCategory(nameHelper.getTicketCategory(resultSet
						.getInt("REF_CATEGORY")));
				ticketVO.setTicketOwner(nameHelper.getTicketOwner(resultSet
						.getInt("REF_TICKET_OWNER")));
				ticketVO.setPriority(TicketPriority.getTicketPriority(resultSet
						.getInt("PRIORITY")));
				ticketVO.setChannel(nameHelper.getTicketChannel(resultSet
						.getInt("REF_CHANNEL")));
				ticketVO.setDueDate(resultSet.getString("DUE_DATE_TIME"));
				ticketVO.setContactName(nameHelper
						.getTicketContactName(resultSet
								.getInt("REF_CONTACT_NAME")));
				ticketVO.setProductName(nameHelper
						.getTicketProductName(resultSet
								.getInt("REF_PRODUCT_NAME")));
				ticketVO.setStatus(TicketStatus.getTicketStatus(resultSet
						.getInt("STATUS")));
				ticketGridList.add(ticketVO);

			}

		} catch (SQLException sqlExp) {
			sqlExp.printStackTrace();
			logger.error(SupportDaoImpl.class
					+ "Error: Occur in Query While Fetching the Ticket"
					+ " Details into Grid from Database.", sqlExp);
		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					SupportDaoImpl.class
							+ "Error: Occur in Query While Closing Connection "
							+ "After Fetching the Ticket Details into Grid from Database.",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return ticketGridList;
	}

	/**
	 * <p>
	 * <code>insertServiceContact</code>Method will insert service contact
	 * detail data from TAB_SUPPORT_SERVICE_CONTACT
	 * </p>
	 * 
	 * @return
	 * @throws OMIApplicationException
	 * @param ServiceContactVo
	 *            serviceContactVo
	 */
	public int insertServiceContact(ServiceContactVo serviceContactVo)
			throws Exception {

		int target = 0;
		try {
			connection = getConnection();
			String insrtServiceContactQuery = QueryMaker.INSERT_SERVICE_CONTACT;
			preparedStatement = connection
					.prepareStatement(insrtServiceContactQuery);
			preparedStatement.setString(1, serviceContactVo.getAssignedTo());
			preparedStatement.setString(2, serviceContactVo.getContactName());
			preparedStatement.setString(3, serviceContactVo.getPriority());
			preparedStatement.setString(4, serviceContactVo.getRelatedTo());
			preparedStatement.setString(5,
					serviceContactVo.getServiceContactType());
			preparedStatement.setString(6, serviceContactVo.getStatus());
			preparedStatement.setString(7, serviceContactVo.getSubject());
			preparedStatement.setString(8, serviceContactVo.getTotalUnits());
			preparedStatement.setString(9, serviceContactVo.getTrackingUnit());
			preparedStatement.setString(10, serviceContactVo.getUsedUnits());
			preparedStatement.setString(11, DateTimeUtil.getCurrentDate());
			preparedStatement.setString(12, DateTimeUtil.getDueDate());
			preparedStatement.setString(13, DateTimeUtil.getStartDate());
			preparedStatement.setInt(14, serviceContactVo.getCreatedBy());
			preparedStatement.executeUpdate();
			target = 1;
		} catch (SQLException sqlException) {
			logger.error(
					"Error while creating the connection from Database  .",
					sqlException);
		} catch (Exception exception) {
			logger.error(
					"Error while  inserting the Service Contact Information "
							+ "to TAB_SUPPORT_SERVICE_CONTACT.", exception);
		} finally {
			JdbcHelper.closeStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return target;
	}

	/**
	 * <p>
	 * <code>getServiceContactGrid</code>Method will fetch data from
	 * TAB_SUPPORT_SERVICE_CONTACT
	 * </p>
	 * 
	 * @return
	 * @throws OMIApplicationException
	 *             List<ServiceContactVo>serviceContactGridList
	 *             ArrayList<ServiceContactVo> = new ArrayList<SupportFaqVO>()
	 */
	public List<ServiceContactVo> getServiceContactGrid() throws Exception {
		ArrayList<ServiceContactVo> serviceContactGridList = new ArrayList<ServiceContactVo>();
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_SERVICE_CONTACT_GIRD_LIST);
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {
					ServiceContactVo serviceContactVo = new ServiceContactVo();
					serviceContactVo.setServiceContactId(resultSet
							.getInt("SERVICE_CONTRACT_ID"));
					serviceContactVo.setSubject(resultSet.getString("SUBJECT"));
					serviceContactVo
							.setAssignedTo(nameHelper.getTicketOwner(resultSet
									.getInt("REF_ASSIGNED_TO")));
					serviceContactVo.setStatus(ServiceStatus
							.getServiceStatus(resultSet.getInt("STATUS")));
					serviceContactVo.setPriority(TicketPriority
							.getTicketPriority(resultSet.getInt("PRIORITY")));
					serviceContactVo
							.setDueDate(resultSet.getString("DUE_DATE"));
					serviceContactVo.setStartDate(resultSet
							.getString("START_DATE"));
					serviceContactGridList.add(serviceContactVo);
				}
			}
		} catch (SQLException sqlExp) {
			sqlExp.printStackTrace();
			logger.error(SupportDaoImpl.class
					+ "Error: Occur in Query While Fetching the Service"
					+ " Contact Details into Grid from Database.", sqlExp);
		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					SupportDaoImpl.class
							+ "Error: Occur in Query While Closing Connection"
							+ " After Fetching the Service Contact into Grid from Database.",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return serviceContactGridList;
	}

	/**
	 * <p>
	 * <code>editServiceContact</code>Method will Edit Service Contact data from
	 * based serviceContactId
	 * </p>
	 * 
	 * @return SupportServiceContact
	 * @throws OMIApplicationException
	 * @param int serviceContactId
	 */
	public SupportServiceContact editServiceContact(int serviceContactId)
			throws Exception {
		supportServiceContact = new SupportServiceContact();
		connection = getConnection();
		preparedStatement = connection
				.prepareStatement(QueryMaker.GET_SERVICE_CONTACT_EDIT);
		try {
			preparedStatement.setInt(1, serviceContactId);
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {
					supportServiceContact.setServiceContctId(resultSet
							.getInt("SERVICE_CONTRACT_ID"));
					supportServiceContact.setSubject(resultSet
							.getString("SUBJECT"));
					supportServiceContact.setTotalUnits(resultSet
							.getString("TOTAL_UNITS"));
					supportServiceContact.setTrackingUnit(resultSet
							.getString("REF_TRACKING_UNIT"));
					supportServiceContact.setUsedUnits(resultSet
							.getString("USED_UNITS"));
					supportServiceContact
							.setAssignedTo(nameHelper.getTicketOwner(resultSet
									.getInt("REF_ASSIGNED_TO")));
					supportServiceContact.setContactName(nameHelper
							.getTicketContactName(resultSet
									.getInt("REF_CONTACT_NAME")));
					supportServiceContact
							.setRelatedTo(nameHelper.getAccountName(resultSet
									.getInt("REF_RELETED_TO")));
					supportServiceContact.setServiceContactType(nameHelper
							.getServiceType(resultSet
									.getInt("REF_SERVICE_TYPE")));
					supportServiceContact.setStatus(ServiceStatus
							.getServiceStatus(resultSet.getInt("STATUS")));
					supportServiceContact.setPriority(TicketPriority
							.getTicketPriority(resultSet.getInt("PRIORITY")));
					supportServiceContact.setDueDate(resultSet
							.getString("DUE_DATE"));
					supportServiceContact.setStartDate(resultSet
							.getString("START_DATE"));
				}

			}
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					SupportDaoImpl.class
							+ ": Error:- Error: Occur in Query While fetching the Service "
							+ "Contact from Database", sqlException);

		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					SupportDaoImpl.class
							+ ": Error:- While closing the Connection after fetching the "
							+ "Service Contact from Database", exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}

		return supportServiceContact;
	}

	/**
	 * <p>
	 * <code>updateServiceContact</code>Method will Update Service Contact data
	 * from TAB_SUPPORT_SERVICE_CONTACT based serviceContactId
	 * </p>
	 * 
	 * @return SupportServiceContact
	 * @throws OMIApplicationException
	 * @param int serviceContactId ServiceContactVo serviceContactVo
	 */
	public int updateServiceContact(ServiceContactVo serviceContactVo,
			int serviceContactId) {
		int target = 0;
		serviceContactVo.setServiceContactId(serviceContactId);
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.UPDATE_SERVICE_CONTACT_INFORMATION);
			preparedStatement.setString(1, serviceContactVo.getAssignedTo());
			preparedStatement.setString(2, serviceContactVo.getContactName());
			preparedStatement.setString(3, serviceContactVo.getPriority());
			preparedStatement.setString(4, serviceContactVo.getRelatedTo());
			preparedStatement.setString(5,
					serviceContactVo.getServiceContactType());
			preparedStatement.setString(6, serviceContactVo.getStatus());
			preparedStatement.setString(7, serviceContactVo.getSubject());
			preparedStatement.setString(8, serviceContactVo.getTotalUnits());
			preparedStatement.setString(9, serviceContactVo.getTrackingUnit());
			preparedStatement.setString(10, serviceContactVo.getUsedUnits());
			preparedStatement.setString(11, DateTimeUtil.getDueDate());
			preparedStatement.setString(12, DateTimeUtil.getStartDate());
			preparedStatement.setInt(13, serviceContactId);
			preparedStatement.executeUpdate();
			target = 1;
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					SupportDaoImpl.class
							+ ": Error:- Error: Occur in Query While updating the Service"
							+ " Contact into Database", sqlException);

		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					SupportDaoImpl.class
							+ ": Error:- While closing the Connection after updating the"
							+ " Service Contact into Database", exception);
		} finally {
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return target;
	}

	/**
	 * <p>
	 * <code>viewServiceContact</code>Method will fetch Service Contact data
	 * from based serviceContactId
	 * </p>
	 * 
	 * @return SupportServiceContact
	 * @throws OMIApplicationException
	 * @param int serviceContactId
	 */
	public SupportServiceContact viewServiceContact(int serviceContactId)
			throws Exception {
		SupportServiceContact supportServiceContact = new SupportServiceContact();

		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_SERVICE_CONTACT_VIEW);
			preparedStatement.setInt(1, serviceContactId);
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {
					supportServiceContact.setServiceContctId(resultSet
							.getInt("SERVICE_CONTRACT_ID"));
					supportServiceContact.setSubject(resultSet
							.getString("SUBJECT"));
					supportServiceContact.setTotalUnits(resultSet
							.getString("TOTAL_UNITS"));
					supportServiceContact.setUsedUnits(resultSet
							.getString("USED_UNITS"));
					supportServiceContact.setStatus(ServiceStatus
							.getServiceStatus(resultSet.getInt("STATUS")));
					supportServiceContact.setPriority(TicketPriority
							.getTicketPriority(resultSet.getInt("PRIORITY")));
					supportServiceContact.setDueDate(resultSet
							.getString("DUE_DATE"));
					supportServiceContact.setStartDate(resultSet
							.getString("START_DATE"));
					supportServiceContact.setContactName(nameHelper
							.getTicketContactName(resultSet
									.getInt("REF_CONTACT_NAME")));
					supportServiceContact
							.setAssignedTo(nameHelper.getTicketOwner(resultSet
									.getInt("REF_ASSIGNED_TO")));
					supportServiceContact
							.setRelatedTo(nameHelper.getAccountName(resultSet
									.getInt("REF_RELETED_TO")));
					supportServiceContact.setTrackingUnit(nameHelper
							.getTrackingUnit(resultSet
									.getInt("REF_TRACKING_UNIT")));
					supportServiceContact.setServiceContactType(nameHelper
							.getServiceType(resultSet
									.getInt("REF_SERVICE_TYPE")));

				}

			}
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					SupportDaoImpl.class
							+ ": Error:- Error: Occur in Query While View the Service Contact"
							+ " from Database", sqlException);

		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					SupportDaoImpl.class
							+ ": Error:- While closing the Connection after View the Service"
							+ " Contact from Database", exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}

		return supportServiceContact;
	}

	/**
	 * <p>
	 * <code>deleteServiceContactDetail</code>Method will delete Service Contact
	 * data from based serviceContactId
	 * </p>
	 * 
	 * @throws OMIApplicationException
	 * @param int serviceContactId
	 */
	public void deleteServiceContactDetail(int serviceContactId)
			throws Exception {
		String query = QueryMaker.DELETE_SERVICE_CONTACT;
		try {

			connection = getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, serviceContactId);
			preparedStatement.executeUpdate();

		} catch (Exception exception) {
			logger.error(SupportDaoImpl.class
					+ ": Error:- While deletng Service Contact from Database.");
		} finally {
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);

		}

	}

	/**
	 * <p>
	 * <code>getServiceContactDetail</code>Method will Next View Service Contact
	 * data from based serviceContactId
	 * </p>
	 * 
	 * @return SupportServiceContact
	 * @throws OMIApplicationException
	 * @param int serviceContactId
	 */
	public SupportServiceContact getServiceContactDetail(int serviceContactId)
			throws Exception {
		supportServiceContact = new SupportServiceContact();
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.SHOW_VIEW_SERVICE_CONTACT);
			preparedStatement.setInt(1, serviceContactId);
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {
					supportServiceContact.setServiceContctId(resultSet
							.getInt("SERVICE_CONTRACT_ID"));
					supportServiceContact.setSubject(resultSet
							.getString("SUBJECT"));
					supportServiceContact.setTotalUnits(resultSet
							.getString("TOTAL_UNITS"));
					supportServiceContact.setTrackingUnit(resultSet
							.getString("REF_TRACKING_UNIT"));
					supportServiceContact.setUsedUnits(resultSet
							.getString("USED_UNIT"));
					supportServiceContact
							.setAssignedTo(nameHelper.getTicketOwner(resultSet
									.getInt("REF_ASSIGNED_TO")));
					supportServiceContact.setServiceContactType(nameHelper
							.getServiceType(resultSet
									.getInt("REF_SERVICE_TYPE")));
					supportServiceContact.setContactName(nameHelper
							.getTicketContactName(resultSet
									.getInt("REF_CONTACT_NAME")));
					supportServiceContact
							.setRelatedTo(nameHelper.getAccountName(resultSet
									.getInt("REF_RELETED_TO")));
					supportServiceContact.setStatus(ServiceStatus
							.getServiceStatus(resultSet.getInt("STATUS")));
					supportServiceContact.setPriority(TicketPriority
							.getTicketPriority(resultSet.getInt("PRIORITY")));
					/*
					 * supportServiceContact.setStartDate(DateTimeUtil
					 * .getCurrentDate("CREATED_DATE"));
					 * supportServiceContact.setDueDate(DateTimeUtil
					 * .getDueDate("DUE_DATE"));
					 * supportServiceContact.setStartDate(DateTimeUtil
					 * .getStartDate("START_DATE"));
					 */
				}
			}
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(SupportDaoImpl.class
					+ ": Error:- Error: Occur in Query While fetching the"
					+ " Service Contact details for view from Database",
					sqlException);

		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(SupportDaoImpl.class
					+ ": Error:- While closing the Connection after fetching"
					+ " the Service Contact for view from Database", exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return supportServiceContact;
	}

	/**
	 * <p>
	 * <code>getServiceContact</code>Method will preview Service Contact data
	 * from based serviceContactId
	 * </p>
	 * 
	 * @return SupportServiceContact
	 * @throws OMIApplicationException
	 * @param int serviceContactId
	 */
	public SupportServiceContact getServiceContact(int serviceContactId)
			throws Exception {
		supportServiceContact = new SupportServiceContact();
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.SHOW_VIEW_SERVICE_CONTACT);
			preparedStatement.setInt(1, serviceContactId);
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {
					supportServiceContact.setServiceContctId(resultSet
							.getInt("SERVICE_CONTRACT_ID"));
					supportServiceContact.setSubject(resultSet
							.getString("SUBJECT"));
					supportServiceContact
							.setAssignedTo(nameHelper.getTicketOwner(resultSet
									.getInt("REF_ASSIGNED_TO")));
					supportServiceContact.setContactName(nameHelper
							.getTicketContactName(resultSet
									.getInt("REF_CONTACT_NAME")));
					supportServiceContact
							.setRelatedTo(nameHelper.getAccountName(resultSet
									.getInt("REF_RELETED_TO")));
					supportServiceContact.setTrackingUnit(nameHelper
							.getTrackingUnit(resultSet
									.getInt("REF_TRACKING_UNIT")));
					supportServiceContact.setUsedUnits(resultSet
							.getString("USED_UNITS"));
					supportServiceContact.setTotalUnits(resultSet
							.getString("TOTAL_UNITS"));
					supportServiceContact.setServiceContactType(nameHelper
							.getServiceType(resultSet
									.getInt("REF_SERVICE_TYPE")));
					supportServiceContact.setStatus(ServiceStatus
							.getServiceStatus(resultSet.getInt("STATUS")));
					supportServiceContact.setPriority(TicketPriority
							.getTicketPriority(resultSet.getInt("PRIORITY")));
					supportServiceContact.setDueDate(DateTimeUtil.getDueDate());
					supportServiceContact.setStartDate(DateTimeUtil
							.getStartDate());

				}
			}
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					SupportDaoImpl.class
							+ ": Error:- Error: Occur in Query While fetching the Service Contact"
							+ " for view from Database", sqlException);

		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					SupportDaoImpl.class
							+ ": Error:- While closing the Connection after fetching the Service"
							+ " Contact for view from Database", exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return supportServiceContact;
	}

	/**
	 * <p>
	 * <code>getServiceContactForUpdate</code>Method will NeXt edit Service
	 * Contact data from based serviceContactId
	 * </p>
	 * 
	 * @return SupportServiceContact
	 * @throws OMIApplicationException
	 * @param int serviceContactId
	 */

	public SupportServiceContact getServiceContactForUpdate(int serviceContactId)
			throws Exception {
		supportServiceContact = new SupportServiceContact();
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.SHOW_VIEW_SERVICE_CONTACT);
			preparedStatement.setInt(1, serviceContactId);
			resultSet = preparedStatement.executeQuery();

			if (resultSet != null) {
				while (resultSet.next()) {
					supportServiceContact.setServiceContctId(resultSet
							.getInt("SERVICE_CONTRACT_ID"));
					supportServiceContact.setSubject(resultSet
							.getString("SUBJECT"));
					serviceContactVo
							.setAssignedTo(nameHelper.getTicketOwner(resultSet
									.getInt("REF_ASSIGNED_TO")));
					supportServiceContact.setContactName(nameHelper
							.getTicketContactName(resultSet
									.getInt("REF_CONTACT_NAME")));
					supportServiceContact
							.setRelatedTo(nameHelper.getAccountName(resultSet
									.getInt("REF_RELETED_TO")));
					supportServiceContact.setTrackingUnit(nameHelper
							.getTrackingUnit(resultSet
									.getInt("REF_TRACKING_UNIT")));
					supportServiceContact.setUsedUnits(resultSet
							.getString("USED_UNITS"));
					supportServiceContact.setTotalUnits(resultSet
							.getString("TOTAL_UNITS"));
					supportServiceContact.setServiceContactType(nameHelper
							.getServiceType(resultSet
									.getInt("REF_SERVICE_TYPE")));
					supportServiceContact.setStatus(ServiceStatus
							.getServiceStatus(resultSet.getInt("STATUS")));
					supportServiceContact.setPriority(TicketPriority
							.getTicketPriority(resultSet.getInt("PRIORITY")));
					supportServiceContact.setDueDate(DateTimeUtil.getDueDate());
					supportServiceContact.setStartDate(DateTimeUtil
							.getStartDate());

				}
			}
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					SupportDaoImpl.class
							+ ": Error:- Error: Occur in Query While fetching the Service Contact"
							+ " for view from Database", sqlException);

		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					SupportDaoImpl.class
							+ ": Error:- While closing the Connection after fetching the Service "
							+ "Contact for view from Database", exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return supportServiceContact;
	}

	/**
	 * <p>
	 * <code>getServiceContactSearchGird</code>Method will Search Service
	 * Contact data from based serviceContactId
	 * </p>
	 * 
	 * @return List<ServiceContactVo>
	 * @throws OMIApplicationException
	 * @param int searchId, String searchValue
	 */

	public List<ServiceContactVo> getServiceContactSearchGird(int searchId,
			String searchValue) throws Exception {
		List<ServiceContactVo> serviceContactGridList = new ArrayList<ServiceContactVo>();
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(QueryBuilder
					.serviceAdvanceSearch(searchId, searchValue));
			resultSet = preparedStatement.executeQuery();
			// SERVICE_CONTRACT_ID,SUBJECT,REF_ASSIGNED_TO,START_DATE,DUE_DATE,PRIORITY,STATUS
			while (resultSet.next()) {
				ServiceContactVo serviceContactVo = new ServiceContactVo();
				serviceContactVo.setServiceContactId(resultSet
						.getInt("SERVICE_CONTRACT_ID"));
				serviceContactVo.setSubject(resultSet.getString("SUBJECT"));
				serviceContactVo.setAssignedTo(nameHelper
						.getTicketOwner(resultSet.getInt("REF_ASSIGNED_TO")));
				serviceContactVo.setStatus(ServiceStatus
						.getServiceStatus(resultSet.getInt("STATUS")));
				serviceContactVo.setPriority(TicketPriority
						.getTicketPriority(resultSet.getInt("PRIORITY")));
				serviceContactVo.setDueDate(resultSet.getString("DUE_DATE"));
				serviceContactVo
						.setStartDate(resultSet.getString("START_DATE"));

				serviceContactGridList.add(serviceContactVo);
			}

		} catch (SQLException sqlExp) {
			sqlExp.printStackTrace();
			logger.error(SupportDaoImpl.class
					+ "Error: Occur in Query While Fetching the Faq"
					+ " Details into Grid from Database.", sqlExp);
		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(SupportDaoImpl.class
					+ "Error: Occur in Query While Closing Connection After"
					+ " Fetching the Faq Details into Grid from Database.",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return serviceContactGridList;
	}

	/**
	 * <p>
	 * <code>getServiceContactLastRecord</code>Method will get Service Contact
	 * Last Record data from based serviceContactId
	 * </p>
	 * 
	 * @return
	 * @throws OMIApplicationException
	 * @param
	 */

	public int getServiceContactLastRecord() throws Exception {
		int temp = 0;
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_LAST_RECORD_SERVICE_CONTRACT_ID);
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {

					temp = resultSet.getInt("SERVICE_CONTRACT_ID");
				}
			}
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					SupportDaoImpl.class
							+ ": Error:- Error: Occur in Query While counting the Service Contact "
							+ "recodes from Database", sqlException);

		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					SupportDaoImpl.class
							+ ": Error:- While closing the Connection after counting the Service"
							+ " Contact from Database", exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return temp;
	}

	/**
	 * <p>
	 * <code>CasesReportPDF</code>Method will get the pdf report in view page
	 * </p>
	 * 
	 * @return
	 * @throws OMIApplicationException
	 * @param request
	 *            ,response
	 * @param casesId
	 * @author Rosu Patel
	 */
	@Override
	public void CasesReportPDF(HttpServletRequest request,
			HttpServletResponse response, int casesId) throws Exception {
		String companyName = "Chouksay Traders";
		String address1= "BUS STAND SHAMSHABAD, DIST.- VIDISHA, MADHYA PRADESH, 464001";
		String address2="GSTIN: 23AJQPC8200P1Z1";
		String address3="PAN NO: AJQPC8200P";

		String city = "Vidisha-464001";
		String state = "(M.P.)";

		try {

			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.SHOW_SUPPORT_CASES_PRINT_PDF);
			preparedStatement.setInt(1, casesId);
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
			Phrase phrase2 = new Phrase(city + "-" + state, Font3);

			Paragraph paragraph = new Paragraph();
			paragraph.add(phrase3);
			paragraph.add(phrase);
			paragraph.add(phrase1);
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

			PdfPCell cell104 = new PdfPCell(
					new Paragraph("CASES REPORT", Font4));
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

				PdfPCell cell1 = new PdfPCell(new Paragraph(
						"Cases Information", Font6));
				cell1.setBackgroundColor(new BaseColor(238, 238, 238));
				cell1.setBorderWidth(0.01f);
				cell1.setBorderColor(BaseColor.WHITE);

				PdfPCell cell2 = new PdfPCell(new Paragraph());
				cell2.setBackgroundColor(new BaseColor(238, 238, 238));
				cell2.setBorderWidth(0.2f);
				cell2.setBorderColor(BaseColor.WHITE);

				PdfPCell cell3 = new PdfPCell(new Paragraph("Cases Title",
						mainContent));
				cell3.setBackgroundColor(new BaseColor(238, 238, 238));
				cell3.setBorderWidth(0.01f);
				cell3.setBorderColor(BaseColor.WHITE);

				PdfPCell cell4 = new PdfPCell(new Paragraph(
						resultSet.getString("CASES_TITLE"), mainContent));
				cell4.setBorderWidth(0.2f);
				cell4.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell5 = new PdfPCell(new Paragraph("Status",
						mainContent));
				cell5.setBackgroundColor(new BaseColor(238, 238, 238));
				cell5.setBorderWidth(0.01f);
				cell5.setBorderColor(BaseColor.WHITE);

				PdfPCell cell6 = new PdfPCell(new Paragraph(
						CasesStatus.getCASESStatus(resultSet
								.getInt("CASES_STATUS")), mainContent));
				cell6.setBorderWidth(0.2f);
				cell6.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell7 = new PdfPCell(new Paragraph("Priority",
						mainContent));
				cell7.setBackgroundColor(new BaseColor(238, 238, 238));
				cell7.setBorderWidth(0.01f);
				cell7.setBorderColor(BaseColor.WHITE);

				PdfPCell cell8 = new PdfPCell(new Paragraph(
						TicketPriority.getTicketPriority(resultSet
								.getInt("REF_CASES_PRIORITY")), mainContent));
				cell8.setBorderWidth(0.2f);
				cell8.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell9 = new PdfPCell(new Paragraph("Contact Name",
						mainContent));
				cell9.setBackgroundColor(new BaseColor(238, 238, 238));
				cell9.setBorderWidth(0.01f);
				cell9.setBorderColor(BaseColor.WHITE);

				PdfPCell cell10 = new PdfPCell(new Paragraph(
						nameHelper.getTicketContactName(resultSet
								.getInt("CONTACT_NAME")), mainContent));
				cell10.setBorderWidth(0.2f);
				cell10.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell11 = new PdfPCell(new Paragraph("SLA Name",
						mainContent));
				cell11.setBackgroundColor(new BaseColor(238, 238, 238));
				cell11.setBorderWidth(0.01f);
				cell11.setBorderColor(BaseColor.WHITE);

				PdfPCell cell12 = new PdfPCell(
						new Paragraph(nameHelper.getCasesSlaName(resultSet
								.getInt("SLA_NAME")), mainContent));
				cell12.setBorderWidth(0.2f);
				cell12.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell13 = new PdfPCell(new Paragraph("Organization",
						mainContent));
				cell13.setBackgroundColor(new BaseColor(238, 238, 238));
				cell13.setBorderWidth(0.01f);
				cell13.setBorderColor(BaseColor.WHITE);

				PdfPCell cell14 = new PdfPCell(new Paragraph(
						nameHelper.getCasesOrgnization(resultSet
								.getInt("ORGANIZATION_NAME")), mainContent));
				cell14.setBorderWidth(0.2f);
				cell14.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell15 = new PdfPCell(new Paragraph("Assign To",
						mainContent));
				cell15.setBackgroundColor(new BaseColor(238, 238, 238));
				cell15.setBorderWidth(0.01f);
				cell15.setBorderColor(BaseColor.WHITE);

				PdfPCell cell16 = new PdfPCell(new Paragraph(
						nameHelper.getAssignTo(resultSet
								.getInt("REF_CASES_ASSIGNED_TO")), mainContent));
				cell16.setBorderWidth(0.2f);
				cell16.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell17 = new PdfPCell(new Paragraph("Case Team",
						mainContent));
				cell17.setBackgroundColor(new BaseColor(238, 238, 238));
				cell17.setBorderWidth(0.01f);
				cell17.setBorderColor(BaseColor.WHITE);

				PdfPCell cell18 = new PdfPCell(new Paragraph(
						nameHelper.getCasesTeam(resultSet
								.getInt("REF_CASES_TEAM")), mainContent));
				cell18.setBorderWidth(0.2f);
				cell18.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell19 = new PdfPCell(new Paragraph("Product Name",
						mainContent));
				cell19.setBackgroundColor(new BaseColor(238, 238, 238));
				cell19.setBorderWidth(0.01f);
				cell19.setBorderColor(BaseColor.WHITE);

				PdfPCell cell20 = new PdfPCell(new Paragraph(
						nameHelper.getTicketProductName(resultSet
								.getInt("PRODUCT_NAME")), mainContent));
				cell20.setBorderWidth(0.2f);
				cell20.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell21 = new PdfPCell(new Paragraph("Channel Name",
						mainContent));
				cell21.setBackgroundColor(new BaseColor(238, 238, 238));
				cell21.setBorderWidth(0.01f);
				cell21.setBorderColor(BaseColor.WHITE);

				PdfPCell cell22 = new PdfPCell(new Paragraph(
						nameHelper.getCasesChannel(resultSet
								.getInt("REF_CASES_CHANNEL")), mainContent));
				cell22.setBorderWidth(0.2f);
				cell22.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell23 = new PdfPCell(new Paragraph("Deffered Date",
						mainContent));
				cell23.setBackgroundColor(new BaseColor(238, 238, 238));
				cell23.setBorderWidth(0.01f);
				cell23.setBorderColor(BaseColor.WHITE);

				PdfPCell cell24 = new PdfPCell(new Paragraph(
						resultSet.getString("DEFERRD_DATE"), mainContent));
				cell24.setBorderWidth(0.2f);
				cell24.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell25 = new PdfPCell(new Paragraph("Resolution Type",
						mainContent));
				cell25.setBackgroundColor(new BaseColor(238, 238, 238));
				cell25.setBorderWidth(0.01f);
				cell25.setBorderColor(BaseColor.WHITE);

				PdfPCell cell26 = new PdfPCell(new Paragraph(
						nameHelper.getCasesResolutionType(resultSet
								.getInt("REF_CASES_RESOLUTION_TYPE")),
						mainContent));
				cell26.setBorderWidth(0.2f);
				cell26.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell27 = new PdfPCell(new Paragraph("Impact Area",
						mainContent));
				cell27.setBackgroundColor(new BaseColor(238, 238, 238));
				cell27.setBorderWidth(0.01f);
				cell27.setBorderColor(BaseColor.WHITE);

				PdfPCell cell28 = new PdfPCell(new Paragraph(
						nameHelper.getCasesImpactArea(resultSet
								.getInt("REF_CASES_IMPACT_AREA")), mainContent));
				cell28.setBorderWidth(0.2f);
				cell28.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell29 = new PdfPCell(new Paragraph("Impact Type",
						mainContent));
				cell29.setBackgroundColor(new BaseColor(238, 238, 238));
				cell29.setBorderWidth(0.01f);
				cell29.setBorderColor(BaseColor.WHITE);

				PdfPCell cell30 = new PdfPCell(new Paragraph(
						nameHelper.getCasesImpactType(resultSet
								.getInt("REF_CASES_IMPACT_TYPE")), mainContent));
				cell30.setBorderWidth(0.2f);
				cell30.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell31 = new PdfPCell(new Paragraph("Primary Email",
						mainContent));
				cell31.setBackgroundColor(new BaseColor(238, 238, 238));
				cell31.setBorderWidth(0.01f);
				cell31.setBorderColor(BaseColor.WHITE);

				PdfPCell cell32 = new PdfPCell(new Paragraph(
						resultSet.getString("PRIMARY_EMAIL"), mainContent));
				cell32.setBorderWidth(0.2f);
				cell32.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell33 = new PdfPCell(new Paragraph("Resolution",
						Font6));
				cell33.setBackgroundColor(new BaseColor(238, 238, 238));
				cell33.setBorderWidth(0.01f);
				cell33.setBorderColor(BaseColor.WHITE);

				PdfPCell cell34 = new PdfPCell(new Paragraph());
				cell34.setBackgroundColor(new BaseColor(238, 238, 238));
				cell34.setBorderWidth(0.2f);
				cell34.setBorderColor(BaseColor.WHITE);

				PdfPCell cell35 = new PdfPCell(new Paragraph(
						"Resolution Details", mainContent));
				cell35.setBackgroundColor(new BaseColor(238, 238, 238));
				cell35.setBorderWidth(0.01f);
				cell35.setBorderColor(BaseColor.WHITE);
				String temp = resultSet.getString("RESOLUTION");

				PdfPCell cell36 = new PdfPCell(new Paragraph(temp.replaceAll(
						"\\<.*?\\>", " "), mainContent));
				cell36.setBorderWidth(0.2f);
				cell36.setBorderColor(BaseColor.LIGHT_GRAY);

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

				document.add(table);
			}
			// Footer

			document.add(new Paragraph("\n"));
			document.add(new Paragraph(
					"© 2015 Vanrasoft Technologies. All Rights Reserved.",
					mainContent));
			document.close();
			// End Footer
		} catch (SQLException sqlExp) {
			sqlExp.printStackTrace();
			logger.error(
					SupportDaoImpl.class
							+ "Error: Occur in Query While Fetching All Product Details for print PdF from Database.",
					sqlExp);
		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					SupportDaoImpl.class
							+ "Error: Occur in Query While Closing Connection After Fetching All Product Details for print PdF from Database.",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}

	}

	/**
	 * <p>
	 * <code>faqPDFReport</code>Method will get faq report data from based faqId
	 * </p>
	 * 
	 * @return
	 * @throws OMIApplicationException
	 * @paramrequest,response
	 * @author Rosu Patel
	 */

	@Override
	public void faqPDFReport(HttpServletRequest request,
			HttpServletResponse response, int faqId) throws Exception {
		String companyName = "Chouksay Traders";
		String address1= "BUS STAND SHAMSHABAD, DIST.- VIDISHA, MADHYA PRADESH, 464001";
		String address2="GSTIN: 23AJQPC8200P1Z1";
		String address3="PAN NO: AJQPC8200P";

		String city = "Vidisha-464001";
		String state = "(M.P.)";
		System.out
				.println("************************************TRY***************");
		try {

			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.SHOW_FAQ_PRINT_PDF);
			preparedStatement.setInt(1, faqId);
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
			Phrase phrase2 = new Phrase(city + "-" + state, Font3);

			Paragraph paragraph = new Paragraph();
			paragraph.add(phrase3);
			paragraph.add(phrase);
			paragraph.add(phrase1);
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

			PdfPCell cell104 = new PdfPCell(new Paragraph("FAQ REPORT", Font4));
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

				PdfPCell cell1 = new PdfPCell(new Paragraph("FAQ Information",
						Font6));
				cell1.setBackgroundColor(new BaseColor(238, 238, 238));
				cell1.setBorderWidth(0.01f);
				cell1.setBorderColor(BaseColor.WHITE);

				PdfPCell cell2 = new PdfPCell(new Paragraph());
				cell2.setBackgroundColor(new BaseColor(238, 238, 238));
				cell2.setBorderWidth(0.2f);
				cell2.setBorderColor(BaseColor.WHITE);

				PdfPCell cell3 = new PdfPCell(new Paragraph("FAQ Question",
						mainContent));
				cell3.setBackgroundColor(new BaseColor(238, 238, 238));
				cell3.setBorderWidth(0.01f);
				cell3.setBorderColor(BaseColor.WHITE);

				PdfPCell cell4 = new PdfPCell(new Paragraph(
						resultSet.getString("QUESTION"), mainContent));
				cell4.setBorderWidth(0.2f);
				cell4.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell5 = new PdfPCell(new Paragraph("FAQ Answer",
						mainContent));
				cell5.setBackgroundColor(new BaseColor(238, 238, 238));
				cell5.setBorderWidth(0.01f);
				cell5.setBorderColor(BaseColor.WHITE);

				PdfPCell cell6 = new PdfPCell(new Paragraph(
						resultSet.getString("ANSWER"), mainContent));
				cell6.setBorderWidth(0.2f);
				cell6.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell7 = new PdfPCell(new Paragraph("FAQ Status",
						mainContent));
				cell7.setBackgroundColor(new BaseColor(238, 238, 238));
				cell7.setBorderWidth(0.01f);
				cell7.setBorderColor(BaseColor.WHITE);

				PdfPCell cell8 = new PdfPCell(new Paragraph(
						FAQStatus.getFAQStatus(resultSet.getInt("FAQ_STATUS")),
						mainContent));
				cell8.setBorderWidth(0.2f);
				cell8.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell9 = new PdfPCell(new Paragraph("FAQ Category",
						mainContent));
				cell9.setBackgroundColor(new BaseColor(238, 238, 238));
				cell9.setBorderWidth(0.01f);
				cell9.setBorderColor(BaseColor.WHITE);

				PdfPCell cell10 = new PdfPCell(new Paragraph(
						nameHelper.getFaqCategory(resultSet
								.getInt("REF_FAQ_CATEGORY")), mainContent));
				cell10.setBorderWidth(0.2f);
				cell10.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell11 = new PdfPCell(new Paragraph("FAQ Owner",
						mainContent));
				cell11.setBackgroundColor(new BaseColor(238, 238, 238));
				cell11.setBorderWidth(0.01f);
				cell11.setBorderColor(BaseColor.WHITE);

				PdfPCell cell12 = new PdfPCell(new Paragraph(
						nameHelper.getFaqOwner(resultSet
								.getInt("REF_FAQ_OWNER")), mainContent));
				cell12.setBorderWidth(0.2f);
				cell12.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell13 = new PdfPCell(new Paragraph("Product Name",
						mainContent));
				cell13.setBackgroundColor(new BaseColor(238, 238, 238));
				cell13.setBorderWidth(0.01f);
				cell13.setBorderColor(BaseColor.WHITE);

				PdfPCell cell14 = new PdfPCell(new Paragraph(
						nameHelper.getFaqProductName(resultSet
								.getInt("REF_PRODUCT_NAME")), mainContent));
				cell14.setBorderWidth(0.2f);
				cell14.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell15 = new PdfPCell(new Paragraph("Date ",
						mainContent));
				cell15.setBackgroundColor(new BaseColor(238, 238, 238));
				cell15.setBorderWidth(0.01f);
				cell15.setBorderColor(BaseColor.WHITE);

				PdfPCell cell16 = new PdfPCell(new Paragraph(
						resultSet.getString("DATE"), mainContent));
				cell16.setBorderWidth(0.2f);
				cell16.setBorderColor(BaseColor.LIGHT_GRAY);

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
					SupportDaoImpl.class
							+ "Error: Occur in Query While Fetching All FAQ Details for print PdF from Database.",
					sqlExp);
		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					SupportDaoImpl.class
							+ "Error: Occur in Query While Closing Connection After Fetching All FAQ Details for print PdF from Database.",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}

	}

	/**
	 * <p>
	 * <code>ticketPrintPDF</code>Method will get ticket report data from based
	 * ticketId
	 * </p>
	 * 
	 * @return
	 * @throws OMIApplicationException
	 * @paramrequest,response
	 * @author Rosu Patel
	 */
	@Override
	public void ticketPrintPDF(HttpServletRequest request,
			HttpServletResponse response, int ticketId) throws Exception {
		String companyName = "Chouksay Traders";
		String address1= "BUS STAND SHAMSHABAD, DIST.- VIDISHA, MADHYA PRADESH, 464001";
		String address2="GSTIN: 23AJQPC8200P1Z1";
		String address3="PAN NO: AJQPC8200P";

		String city = "Vidisha-464001";
		String state = "(M.P.)";

		try {

			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.SHOW_TICKET_PRINT_PDF);
			preparedStatement.setInt(1, ticketId);
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

			PdfPCell cell104 = new PdfPCell(new Paragraph("TICKET REPORT",
					Font4));
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

				PdfPCell cell1 = new PdfPCell(new Paragraph(
						"Ticket Information", Font6));
				cell1.setBackgroundColor(new BaseColor(238, 238, 238));
				cell1.setBorderWidth(0.01f);
				cell1.setBorderColor(BaseColor.WHITE);

				PdfPCell cell2 = new PdfPCell(new Paragraph());
				cell2.setBackgroundColor(new BaseColor(238, 238, 238));
				cell2.setBorderWidth(0.2f);
				cell2.setBorderColor(BaseColor.WHITE);

				PdfPCell cell3 = new PdfPCell(new Paragraph("Contact Name",
						mainContent));
				cell3.setBackgroundColor(new BaseColor(238, 238, 238));
				cell3.setBorderWidth(0.01f);
				cell3.setBorderColor(BaseColor.WHITE);

				PdfPCell cell4 = new PdfPCell(new Paragraph(
						nameHelper.getTicketContactName(resultSet
								.getInt("REF_CONTACT_NAME")), mainContent));
				cell4.setBorderWidth(0.2f);
				cell4.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell5 = new PdfPCell(new Paragraph("Product Name",
						mainContent));
				cell5.setBackgroundColor(new BaseColor(238, 238, 238));
				cell5.setBorderWidth(0.01f);
				cell5.setBorderColor(BaseColor.WHITE);

				PdfPCell cell6 = new PdfPCell(new Paragraph(
						nameHelper.getTicketProductName(resultSet
								.getInt("REF_PRODUCT_NAME")), mainContent));
				cell6.setBorderWidth(0.2f);
				cell6.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell7 = new PdfPCell(new Paragraph("Category",
						mainContent));
				cell7.setBackgroundColor(new BaseColor(238, 238, 238));
				cell7.setBorderWidth(0.01f);
				cell7.setBorderColor(BaseColor.WHITE);

				PdfPCell cell8 = new PdfPCell(new Paragraph(
						nameHelper.getTicketCategory(resultSet
								.getInt("REF_CATEGORY")), mainContent));
				cell8.setBorderWidth(0.2f);
				cell8.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell9 = new PdfPCell(new Paragraph("Ticket Owner",
						mainContent));
				cell9.setBackgroundColor(new BaseColor(238, 238, 238));
				cell9.setBorderWidth(0.01f);
				cell9.setBorderColor(BaseColor.WHITE);

				PdfPCell cell10 = new PdfPCell(new Paragraph(
						nameHelper.getTicketOwner(resultSet
								.getInt("REF_TICKET_OWNER")), mainContent));
				cell10.setBorderWidth(0.2f);
				cell10.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell11 = new PdfPCell(new Paragraph("Email",
						mainContent));
				cell11.setBackgroundColor(new BaseColor(238, 238, 238));
				cell11.setBorderWidth(0.01f);
				cell11.setBorderColor(BaseColor.WHITE);

				PdfPCell cell12 = new PdfPCell(new Paragraph(
						resultSet.getString("EMAIL"), mainContent));
				cell12.setBorderWidth(0.2f);
				cell12.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell13 = new PdfPCell(new Paragraph("Subject",
						mainContent));
				cell13.setBackgroundColor(new BaseColor(238, 238, 238));
				cell13.setBorderWidth(0.01f);
				cell13.setBorderColor(BaseColor.WHITE);

				PdfPCell cell14 = new PdfPCell(new Paragraph(
						resultSet.getString("SUBJECT"), mainContent));
				cell14.setBorderWidth(0.2f);
				cell14.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell15 = new PdfPCell(new Paragraph("Phone Number",
						mainContent));
				cell15.setBackgroundColor(new BaseColor(238, 238, 238));
				cell15.setBorderWidth(0.01f);
				cell15.setBorderColor(BaseColor.WHITE);

				PdfPCell cell16 = new PdfPCell(new Paragraph(
						resultSet.getString("PHONE_NO"), mainContent));
				cell16.setBorderWidth(0.2f);
				cell16.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell17 = new PdfPCell(new Paragraph("Status",
						mainContent));
				cell17.setBackgroundColor(new BaseColor(238, 238, 238));
				cell17.setBorderWidth(0.01f);
				cell17.setBorderColor(BaseColor.WHITE);

				PdfPCell cell18 = new PdfPCell(
						new Paragraph(TicketStatus.getTicketStatus(resultSet
								.getInt("STATUS")), mainContent));
				cell18.setBorderWidth(0.2f);
				cell18.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell19 = new PdfPCell(new Paragraph("Status",
						mainContent));
				cell19.setBackgroundColor(new BaseColor(238, 238, 238));
				cell19.setBorderWidth(0.01f);
				cell19.setBorderColor(BaseColor.WHITE);

				PdfPCell cell20 = new PdfPCell(
						new Paragraph(TicketStatus.getTicketStatus(resultSet
								.getInt("STATUS")), mainContent));
				cell20.setBorderWidth(0.2f);
				cell20.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell21 = new PdfPCell(new Paragraph("Priority",
						mainContent));
				cell21.setBackgroundColor(new BaseColor(238, 238, 238));
				cell21.setBorderWidth(0.01f);
				cell21.setBorderColor(BaseColor.WHITE);

				PdfPCell cell22 = new PdfPCell(new Paragraph(
						TicketPriority.getTicketPriority(resultSet
								.getInt("PRIORITY")), mainContent));
				cell22.setBorderWidth(0.2f);
				cell22.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell23 = new PdfPCell(new Paragraph("Channel Name",
						mainContent));
				cell23.setBackgroundColor(new BaseColor(238, 238, 238));
				cell23.setBorderWidth(0.01f);
				cell23.setBorderColor(BaseColor.WHITE);

				PdfPCell cell24 = new PdfPCell(new Paragraph(
						nameHelper.getTicketChannel(resultSet
								.getInt("REF_CHANNEL")), mainContent));
				cell24.setBorderWidth(0.2f);
				cell24.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell25 = new PdfPCell(new Paragraph("Due Date Time",
						mainContent));
				cell25.setBackgroundColor(new BaseColor(238, 238, 238));
				cell25.setBorderWidth(0.01f);
				cell25.setBorderColor(BaseColor.WHITE);

				PdfPCell cell26 = new PdfPCell(new Paragraph(
						resultSet.getString("DUE_DATE_TIME"), mainContent));
				cell26.setBorderWidth(0.2f);
				cell26.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell27 = new PdfPCell(new Paragraph("Attachment",
						mainContent));
				cell27.setBackgroundColor(new BaseColor(238, 238, 238));
				cell27.setBorderWidth(0.01f);
				cell27.setBorderColor(BaseColor.WHITE);

				PdfPCell cell28 = new PdfPCell(new Paragraph(
						resultSet.getString("ATTACHMENT"), mainContent));
				cell28.setBorderWidth(0.2f);
				cell28.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell29 = new PdfPCell(new Paragraph("Description",
						mainContent));
				cell29.setBackgroundColor(new BaseColor(238, 238, 238));
				cell29.setBorderWidth(0.01f);
				cell29.setBorderColor(BaseColor.WHITE);

				PdfPCell cell30 = new PdfPCell(new Paragraph(
						resultSet.getString("DESCRIPTION"), mainContent));
				cell30.setBorderWidth(0.2f);
				cell30.setBorderColor(BaseColor.LIGHT_GRAY);

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
					SupportDaoImpl.class
							+ "Error: Occur in Query While Fetching All Ticket Details for print PdF from Database.",
					sqlExp);
		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					SupportDaoImpl.class
							+ "Error: Occur in Query While Closing Connection After Fetching All Ticket Details for print PdF from Database.",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}

	}

	/**
	 * <p>
	 * <code>showProductName</code>Method will get show product name report data
	 * from based productName
	 * </p>
	 * 
	 * @return
	 * @throws OMIApplicationException
	 * @param
	 * @author Rosu Patel
	 */
	@Override
	public List<SupportFaqVO> showProductName() throws OMIApplicationException {
		List<SupportFaqVO> productNameList = new ArrayList<SupportFaqVO>();

		try {

			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.SHOW_LIST_PRODUCT_NAME);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				supportFaqVO = new SupportFaqVO();
				supportFaqVO
						.setProductName(resultSet.getString("PRODUCT_NAME"));

				productNameList.add(supportFaqVO);
			}
		} catch (SQLException sqlExp) {
			sqlExp.printStackTrace();
			logger.error(
					SupportDaoImpl.class
							+ "Error: Occur in Query While Fetching  Product NAme from Database.",
					sqlExp);
		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					SupportDaoImpl.class
							+ "Error: Occur in Query While Closing Connection After Fetching Product name from Database.",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return productNameList;
	}

	/**
	 * <p>
	 * <code>isProductNameExist</code>Method will get is product name is existed
	 * report data from based productName
	 * </p>
	 * 
	 * @return
	 * @throws OMIApplicationException
	 * @param
	 * @author Rosu Patel
	 */
	public int isProductNameExist(String productName)
			throws OMIApplicationException {

		String existProductName = null;
		try {

			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_PRODUCT_NAME_DATA);
			preparedStatement.setString(1, productName);

			resultSet = preparedStatement.executeQuery();

			if (resultSet != null) {
				while (resultSet.next()) {
					existProductName = resultSet.getString("PRODUCT_NAME");

					if (existProductName.equalsIgnoreCase(productName)) {
						logger.info("Lead title Already exists into the database");
						return 1;
					}
				}
			} else {
				return 0;
			}

		} catch (SQLException sqlException) {
			logger.error(
					"Failed to verify lead title already exists  into the database",
					sqlException);

		} catch (Exception exception) {

			logger.error(
					"Exception occured while verifying  lead title already exists  in database",
					exception);

		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return 0;
	}

	/**
	 * <p>
	 * <code>insertProductName</code>Method will get is product name inserted
	 * report data from based productName
	 * </p>
	 * 
	 * @return
	 * @throws OMIApplicationException
	 * @param
	 * @author Rosu Patel
	 */
	@Override
	public void insertProductName(SupportFaqVO supportFaqVO)
			throws OMIApplicationException {

		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.INSERT_PRODUCT_NAME);
			preparedStatement.setString(1, supportFaqVO.getProductName());
			preparedStatement.executeUpdate();
		} catch (SQLException sqlExp) {
			sqlExp.printStackTrace();
			logger.error(
					SupportDaoImpl.class
							+ "Error: Occur in Query While Inserting Product Name into Database.",
					sqlExp);
		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					SupportDaoImpl.class
							+ "Error: Occur in Query While Closing Connection After Inserting Product Name into Database.",
					exception);
		} finally {
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}

	}

	/**
	 * <p>
	 * <code>insertCasesProductName</code>Method will get is product name
	 * inserted report data from based productName
	 * </p>
	 * 
	 * @return
	 * @throws OMIApplicationException
	 * @param
	 * @author Rosu Patel
	 */
	@Override
	public int insertCasesProductName(SupportCasesVO supportCasesVO)
			throws OMIApplicationException {

		int target = 0;
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.INSERT_PRODUCT_NAME);
			preparedStatement.setString(1, supportCasesVO.getProductName());
			System.out.println("*****************************"
					+ supportCasesVO.getProductName());
			preparedStatement.executeUpdate();
			target = 1;
		} catch (SQLException sqlExp) {
			sqlExp.printStackTrace();
			logger.error(
					SupportDaoImpl.class
							+ "Error: Occur in Query While Inserting Product Name into Database.",
					sqlExp);
		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					SupportDaoImpl.class
							+ "Error: Occur in Query While Closing Connection After Inserting Product Name into Database.",
					exception);
		} finally {
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return target;

	}

	/**
	 * <p>
	 * <code>showContactName</code>Method will get is contact name show report
	 * data from based contactName
	 * </p>
	 * 
	 * @return
	 * @throws OMIApplicationException
	 * @param
	 * @author Rosu Patel
	 */
	@Override
	public List<SupportCasesVO> showContactName()
			throws OMIApplicationException {

		List<SupportCasesVO> contactNameList = new ArrayList<SupportCasesVO>();

		try {

			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.SHOW_LIST_CONTACT_NAME);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				supportCasesVO = new SupportCasesVO();
				supportCasesVO.setContactName(resultSet
						.getString("CONTACT_PERSON"));

				contactNameList.add(supportCasesVO);
			}
		} catch (SQLException sqlExp) {
			sqlExp.printStackTrace();
			logger.error(
					SupportDaoImpl.class
							+ "Error: Occur in Query While Fetching  Contact NAme from Database.",
					sqlExp);
		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					SupportDaoImpl.class
							+ "Error: Occur in Query While Closing Connection After Fetching contect name from Database.",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return contactNameList;
	}

	@Override
	public int isContectNameExist(String contactName)
			throws OMIApplicationException {

		return 0;
	}

	/**
	 * <p>
	 * <code>insertContactName</code>Method will get is contact name inserted
	 * report data from based contactName
	 * </p>
	 * 
	 * @return
	 * @throws OMIApplicationException
	 * @param
	 * @author Rosu Patel
	 */
	@Override
	public void insertContactName(SupportCasesVO supportCasesVO)
			throws OMIApplicationException {
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.INSERT_CONTACT_NAME);
			preparedStatement.setString(1, supportCasesVO.getContactName());
			preparedStatement.executeUpdate();
		} catch (SQLException sqlExp) {
			sqlExp.printStackTrace();
			logger.error(
					SupportDaoImpl.class
							+ "Error: Occur in Query While Inserting Contact Name into Database.",
					sqlExp);
		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					SupportDaoImpl.class
							+ "Error: Occur in Query While Closing Connection After Inserting Contact Name into Database.",
					exception);
		} finally {
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}

	}

	/**
	 * <p>
	 * <code>showOrganizationName()</code>Method will get is organization name
	 * show report data from based organizationName
	 * </p>
	 * 
	 * @return
	 * @throws OMIApplicationException
	 * @param
	 * @author Rosu Patel
	 */
	@Override
	public List<SupportCasesVO> showOrganizationName()
			throws OMIApplicationException {

		List<SupportCasesVO> organizationNameList = new ArrayList<SupportCasesVO>();

		try {

			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.SHOW_LIST_ORGANIZATION_NAME);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				supportCasesVO = new SupportCasesVO();
				supportCasesVO.setOrganiztionaName(resultSet
						.getString("COMPANY_NAME"));

				organizationNameList.add(supportCasesVO);
			}
		} catch (SQLException sqlExp) {
			sqlExp.printStackTrace();
			logger.error(
					SupportDaoImpl.class
							+ "Error: Occur in Query While Fetching  organization from Database.",
					sqlExp);
		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					SupportDaoImpl.class
							+ "Error: Occur in Query While Closing Connection After Fetching organization name from Database.",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return organizationNameList;
	}

	/**
	 * <p>
	 * <code>insertOrganizationName()</code>Method will get is organization name
	 * inserted report data from based organizationName
	 * </p>
	 * 
	 * @return
	 * @throws OMIApplicationException
	 * @param
	 * @author Rosu Patel
	 */
	@Override
	public void insertOrganizationName(SupportCasesVO supportCasesVO)
			throws OMIApplicationException {
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.INSERT_ORGANIZATION_NAME);
			preparedStatement
					.setString(1, supportCasesVO.getOrganiztionaName());
			preparedStatement.executeUpdate();
		} catch (SQLException sqlExp) {
			sqlExp.printStackTrace();
			logger.error(
					SupportDaoImpl.class
							+ "Error: Occur in Query While Inserting organization Name into Database.",
					sqlExp);
		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					SupportDaoImpl.class
							+ "Error: Occur in Query While Closing Connection After Inserting Organization Name into Database.",
					exception);
		} finally {
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
	}

	@Override
	public int isOrganizationNameExist(String contactName)
			throws OMIApplicationException {

		return 0;
	}

	/**
	 * <p>
	 * <code>insertTicketProductName()</code>Method will get is product name
	 * inserted report data from based productName
	 * </p>
	 * 
	 * @return
	 * @throws OMIApplicationException
	 * @param
	 * @author Rosu Patel
	 */
	@Override
	public int insertTicketProductName(TicketVO ticketVO)
			throws OMIApplicationException {
		int target = 0;
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.INSERT_PRODUCT_NAME);
			preparedStatement.setString(1, ticketVO.getProductName());
			preparedStatement.executeUpdate();
			target = 1;

		} catch (SQLException sqlExp) {
			sqlExp.printStackTrace();
			logger.error(
					SupportDaoImpl.class
							+ "Error: Occur in Query While Inserting Product Name into Database.",
					sqlExp);
		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					SupportDaoImpl.class
							+ "Error: Occur in Query While Closing Connection After Inserting Product Name into Database.",
					exception);
		} finally {
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return target;
	}

	/**
	 * <p>
	 * <code>showTicketProductName()</code>Method will get is product name show
	 * report data from based productName
	 * </p>
	 * 
	 * @return
	 * @throws OMIApplicationException
	 * @param
	 * @author Rosu Patel
	 */
	@Override
	public List<TicketVO> showTicketProductName()
			throws OMIApplicationException {
		List<TicketVO> productNameList = new ArrayList<TicketVO>();
		try {

			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.SHOW_LIST_PRODUCT_NAME);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				ticketVO = new TicketVO();
				ticketVO.setProductName(resultSet.getString("PRODUCT_NAME"));

				productNameList.add(ticketVO);
			}
		} catch (SQLException sqlExp) {
			sqlExp.printStackTrace();
			logger.error(
					SupportDaoImpl.class
							+ "Error: Occur in Query While Fetching  Product NAme from Database.",
					sqlExp);
		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					SupportDaoImpl.class
							+ "Error: Occur in Query While Closing Connection After Fetching Product name from Database.",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return productNameList;
	}

	@Override
	public int isContactNameExist(String contactName)
			throws OMIApplicationException {

		return 0;
	}

	/**
	 * <p>
	 * <code>insertTicketContactName()</code>Method will get is contact name
	 * inserted report data from based contactNAme
	 * </p>
	 * 
	 * @return
	 * @throws OMIApplicationException
	 * @param
	 * @author Rosu Patel
	 */
	@Override
	public void insertTicketContactName(TicketVO ticketVO)
			throws OMIApplicationException {

		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.INSERT_CONTACT_NAME);
			preparedStatement.setString(1, ticketVO.getContactName());
			preparedStatement.executeUpdate();
		} catch (SQLException sqlExp) {
			sqlExp.printStackTrace();
			logger.error(
					SupportDaoImpl.class
							+ "Error: Occur in Query While Inserting Contact Name into Database.",
					sqlExp);
		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					SupportDaoImpl.class
							+ "Error: Occur in Query While Closing Connection After Inserting Contact Name into Database.",
					exception);
		} finally {
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}

	}

	/**
	 * <p>
	 * <code>showTicketContactName()</code>Method will get is contact name Show
	 * report data from based contactNAme
	 * </p>
	 * 
	 * @return
	 * @throws OMIApplicationException
	 * @param
	 * @author Rosu Patel
	 */
	@Override
	public List<TicketVO> showTicketContactName()
			throws OMIApplicationException {
		List<TicketVO> contactNameList = new ArrayList<TicketVO>();
		try {

			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.SHOW_LIST_CONTACT_NAME);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				ticketVO = new TicketVO();
				ticketVO.setContactName(resultSet.getString("CONTACT_PERSON"));

				contactNameList.add(ticketVO);
			}
		} catch (SQLException sqlExp) {
			sqlExp.printStackTrace();
			logger.error(
					SupportDaoImpl.class
							+ "Error: Occur in Query While Fetching  Contact NAme from Database.",
					sqlExp);
		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					SupportDaoImpl.class
							+ "Error: Occur in Query While Closing Connection After Fetching contect name from Database.",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return contactNameList;
	}
	/**
	 * <p>
	 * <code>getCaseTitleList()</code>Method will get is case title name Show
	 * report data from based casesTitle
	 * </p>
	 * 
	 * @return
	 * @throws OMIApplicationException
	 * @param
	 * @author Rosu Patel
	 */
	@Override
	public HashMap<String, String> getCaseTitleList()
			throws OMIApplicationException {
		HashMap<String, String> caseTitleList = new HashMap<String, String>();
		try {

			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_CASES_TITLE_NAME);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				caseTitleList.put(resultSet.getString("CASES_TITLE"),
						resultSet.getString("CASES_TITLE"));
			}

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					ProductDaoImpl.class
							+ ": Error:- Error: Occur in Query While fetching cases  title list from Database",
					sqlException);

		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					ProductDaoImpl.class
							+ ": Error:- While closing the Connection after fetching the cases  title list from Database",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return caseTitleList;
	}

}
