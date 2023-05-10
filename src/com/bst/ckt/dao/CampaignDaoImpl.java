/**
 * 
 */
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

import com.bst.ckt.common.LoginUtil;
import com.bst.ckt.common.QueryBuilder;
import com.bst.ckt.common.QueryMaker;
import com.bst.ckt.exception.OMIApplicationException;
import com.bst.ckt.framework.db.JdbcDAOSupport;
import com.bst.ckt.framework.db.JdbcHelper;
import com.bst.ckt.framework.util.DateTimeUtil;
import com.bst.ckt.helper.CampaignExpectedResponse;
import com.bst.ckt.helper.CampaignStatus;
import com.bst.ckt.helper.NameHelper;
import com.bst.ckt.helper.Salutation;
import com.bst.ckt.vo.CampaignVO;
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
 * @author gurjar
 * 
 */
public class CampaignDaoImpl extends JdbcDAOSupport implements CampaignDaoInf {

	/**
	 * Creating Logger object, logger object mapped with CampaignDaoImpl class
	 * for writing Loggers.
	 */
	public static final Logger logger = Logger.getLogger(CampaignDaoImpl.class);

	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	CampaignVO campaignVO = null;
	Image image = null;
	NameHelper nameHelper = new NameHelper();

	/**
	 * <p>
	 * <code>insertCampaignDetail(campaignVO)</code> method use to insert
	 * campaign details into TAB_CAMPAIGN table.
	 * </p>
	 * 
	 * @param campaignVO
	 * @return target
	 * @throws Exception
	 */
	public int insertCampaignDetail(CampaignVO campaignVO) throws Exception {
		String AddCampaignDetailsQuery = QueryMaker.ADD_CAMPAIGN_DETAIL;
		int target = 0;
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(AddCampaignDetailsQuery);
			preparedStatement.setString(1, campaignVO.getCampaignName());
			preparedStatement.setString(2, campaignVO.getSalutation());
			preparedStatement.setString(3, campaignVO.getCampaignOwner());

			if (campaignVO.getExpectedCloseDate() == null
					|| campaignVO.getExpectedCloseDate() == "") {
				preparedStatement.setString(4,
						campaignVO.getExpectedCloseDate());
			} else {
				preparedStatement.setString(4, DateTimeUtil
						.convertToDate(campaignVO.getExpectedCloseDate()));
			}

			preparedStatement.setString(5, campaignVO.getAssignedTo());
			preparedStatement.setInt(6, campaignVO.getProduct());
			preparedStatement.setString(7, campaignVO.getCampaignType());
			preparedStatement.setString(8, campaignVO.getCampaignStatus());
			preparedStatement.setString(9, campaignVO.getTargetAudience());
			if (campaignVO.getTargetSize().length() == 0) {

				preparedStatement.setInt(10, 0);
			} else {
				preparedStatement.setString(10, campaignVO.getTargetSize());
			}

			preparedStatement.setString(11, campaignVO.getSponsor());
			if (campaignVO.getNumSent().length() == 0) {

				preparedStatement.setFloat(12, 0.0f);
			} else {
				preparedStatement.setString(12, campaignVO.getNumSent());
			}

			if (campaignVO.getBudgetCost().length() == 0) {

				preparedStatement.setDouble(13, 0.0);
			} else {
				preparedStatement.setString(13, campaignVO.getBudgetCost());
			}

			if (campaignVO.getActualCost().length() == 0) {

				preparedStatement.setDouble(14, 0.0);
			} else {
				preparedStatement.setString(14, campaignVO.getActualCost());
			}

			if (campaignVO.getExpectedRevenue().length() == 0) {

				preparedStatement.setDouble(15, 0.0);
			} else {
				preparedStatement
						.setString(15, campaignVO.getExpectedRevenue());
			}

			preparedStatement.setString(16, campaignVO.getExpectedResponse());
			if (campaignVO.getExpectedSalesCount().length() == 0) {

				preparedStatement.setInt(17, 0);
			} else {
				preparedStatement.setString(17,
						campaignVO.getExpectedSalesCount());
			}

			if (campaignVO.getActualSalesCount().length() == 0) {

				preparedStatement.setInt(18, 0);
			} else {
				preparedStatement.setString(18,
						campaignVO.getActualSalesCount());
			}

			if (campaignVO.getExpectedResponseCount().length() == 0) {

				preparedStatement.setInt(19, 0);
			} else {
				preparedStatement.setString(19,
						campaignVO.getExpectedResponseCount());
			}

			if (campaignVO.getActualResponseCount().length() == 0) {

				preparedStatement.setInt(20, 0);
			} else {
				preparedStatement.setString(20,
						campaignVO.getActualResponseCount());
			}

			if (campaignVO.getExpectedROI().length() == 0) {

				preparedStatement.setDouble(21, 0.0);
			} else {
				preparedStatement.setString(21, campaignVO.getExpectedROI());
			}

			if (campaignVO.getActualROI().length() == 0) {

				preparedStatement.setDouble(22, 0.0);
			} else {
				preparedStatement.setString(22, campaignVO.getActualROI());
			}

			preparedStatement.setString(23, campaignVO.getDescription());
			preparedStatement.setInt(24, LoginUtil.getCurrentCustomerUser()
					.getCustomerId());
			preparedStatement.setString(25, DateTimeUtil.getDateAndTime());
			preparedStatement.executeUpdate();
			target = 1;
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					CampaignDaoImpl.class
							+ "Error: Occur in Query While Inserting the Campaign Details into Database.",
					sqlException);

		} catch (Exception exception) {

			exception.printStackTrace();
			logger.error(
					CampaignDaoImpl.class
							+ "Error: Occur While Closing Connection After Inserting the Campaign Details into Database.",
					exception);
		} finally {
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return target;
	}

	/**
	 * <p>
	 * <code>List<CampaignVO> getCampaignDetailsList()</code> method use to
	 * fetching campaign details from TAB_CAMPAIGN table.
	 * </p>
	 * 
	 * @return campaignDetailsList
	 * @throws Exception
	 */
	@Override
	public List<CampaignVO> getCampaignDetailsList() throws Exception {
		String query = QueryMaker.GET_CAMPAIGN_DETAILS_LIST;
		ArrayList<CampaignVO> campaignDetailsList = new ArrayList<CampaignVO>();
		nameHelper = new NameHelper();
		CampaignVO campaignVO = null;
		StringBuffer stringBuffer = null;
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				campaignVO = new CampaignVO();
				stringBuffer = new StringBuffer();
				campaignVO.setCampaignId(resultSet.getInt("CAMPAIGN_ID"));
				stringBuffer
						.append(Salutation.getSalutation(resultSet
								.getInt("SALUTATION"))).append(" ")
						.append(resultSet.getString("CAMPAIGN_NAME"));
				campaignVO.setFullName(stringBuffer.toString());

				if (resultSet.getString("EXPECTED_CLOSE_DATE") == null) {
					campaignVO.setExpectedCloseDate(resultSet
							.getString("EXPECTED_CLOSE_DATE"));
				} else {
					campaignVO.setExpectedCloseDate(DateTimeUtil
							.convertDatetoFormDateForView(resultSet
									.getString("EXPECTED_CLOSE_DATE")));

				}
				campaignVO.setAssignedTo(nameHelper
						.getCampaignAssignedToName(resultSet
								.getInt("REF_ASSIGNED_TO")));
				campaignVO.setCampaignType(nameHelper
						.getCampaignTypeName(resultSet
								.getInt("REF_CAMPAIGN_TYPE")));
				campaignVO
						.setCampaignStatus(CampaignStatus
								.getCampaignStatus(resultSet
										.getInt("CAMPAIGN_STATUS")));
				campaignVO.setExpectedRevenue(resultSet
						.getString("EXPECTED_REVENUE"));
				campaignDetailsList.add(campaignVO);
			}

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					UserManagementDaoImpl.class
							+ "Error: Occur in Query While fetching the Campaign Details into Database.",
					sqlException);

		} catch (Exception exception) {

			exception.printStackTrace();
			logger.error(
					UserManagementDaoImpl.class
							+ "Error: Occur While Closing Connection After etching the Campaign Details into Database.",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return campaignDetailsList;
	}

	/**
	 * <p>
	 * <code> CampaignVO retriveCampaignInfo(CampaignVO campaignVO, int campaignId)</code>
	 * method will help to retrieve campaign Info.
	 * </p>
	 * * @param (CampaignVO campaignVO, int campaignId)
	 * 
	 * @throws Exception
	 * @return CampaignVO campaignVO
	 */
	public CampaignVO retriveCampaignInfo(CampaignVO campaignVO, int campaignId)
			throws Exception {
		campaignVO = new CampaignVO();
		StringBuffer stringBuffer = null;
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.VIEW_CAMPAIGN_DETAILS_NAME);
			preparedStatement.setInt(1, campaignId);
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {
					stringBuffer = new StringBuffer();
					campaignVO.setCampaignId(resultSet.getInt("CAMPAIGN_ID"));
					stringBuffer
							.append(Salutation.getSalutation(resultSet
									.getInt("SALUTATION"))).append(" ")
							.append(resultSet.getString("CAMPAIGN_NAME"));
					campaignVO.setFullName(stringBuffer.toString());

					campaignVO.setCampaignOwner(nameHelper
							.getCampaignOwnerName(Integer.parseInt(resultSet
									.getString("REF_CAMPAIGN_OWNER"))));
					campaignVO.setExpectedCloseDate(resultSet
							.getString("EXPECTED_CLOSE_DATE"));
					campaignVO.setAssignedTo(nameHelper
							.getCampaignAssignedToName(Integer
									.parseInt(resultSet
											.getString("REF_ASSIGNED_TO"))));
					campaignVO.setProduct(resultSet.getInt("REF_PRODUCT"));
					campaignVO.setCampaignType(nameHelper
							.getCampaignTypeName(resultSet
									.getInt("REF_CAMPAIGN_TYPE")));
					campaignVO.setCampaignStatus(CampaignStatus
							.getCampaignStatus(resultSet
									.getInt("CAMPAIGN_STATUS")));
					campaignVO.setTargetAudience(resultSet
							.getString("TARGET_AUDIENCE"));
					campaignVO
							.setTargetSize(resultSet.getString("TARGET_SIZE"));
					campaignVO.setSponsor(resultSet.getString("SPONSOR"));
					campaignVO.setNumSent(resultSet.getString("NUM_SENT"));
					campaignVO
							.setBudgetCost(resultSet.getString("BUDGET_COST"));
					campaignVO
							.setActualCost(resultSet.getString("ACTUAL_COST"));
					campaignVO.setExpectedRevenue(resultSet
							.getString("EXPECTED_REVENUE"));

					campaignVO.setExpectedResponse(CampaignExpectedResponse
							.getCampaignExpectedResponse(resultSet
									.getInt("EXPECTED_RESPONSE")));
					campaignVO.setExpectedSalesCount(resultSet
							.getString("EXPECTED_SALES_COUNT"));
					campaignVO.setActualSalesCount(resultSet
							.getString("ACTUAL_SALES_COUNT"));
					campaignVO.setExpectedResponseCount(resultSet
							.getString("EXPECTED_RESPONSE_COUNT"));
					campaignVO.setActualResponseCount(resultSet
							.getString("ACTUAL_RESPONSE_COUNT"));
					campaignVO.setExpectedROI(resultSet
							.getString("EXPECTED_ROI"));
					campaignVO.setActualROI(resultSet.getString("ACTUAL_ROI"));
					campaignVO.setDescription(resultSet
							.getString("DESCRIPTION"));
					campaignVO.setCreatedBy(nameHelper
							.getCustomerName(resultSet.getInt("CREATED_BY")));
					campaignVO.setCreatedDate(resultSet
							.getString("CREATED_DATE"));
					campaignVO.setUpdatedBy(nameHelper
							.getCustomerName(resultSet.getInt("UPDATED_BY")));
					campaignVO.setUpdateDate(resultSet
							.getString("UPDATED_DATE"));
				}
			}

		} catch (SQLException sqlExp) {
			sqlExp.printStackTrace();
			logger.error(
					CampaignDaoImpl.class
							+ "Error: Occur in Query While Fetching All Campaign Details from Database.",
					sqlExp);
		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					CampaignDaoImpl.class
							+ "Error: Occur in Query While Closing Connection After Fetching All Campaign Details from Database.",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return campaignVO;
	}

	/**
	 * @author Sachin Gurjar
	 *         <p>
	 *         <code>deleteCampaignDetails(int campaignId)</code> method help to
	 *         delete campaign details in database.
	 *         </p>
	 * 
	 * @param campaignId
	 *            int
	 * 
	 * 
	 * @throws Exception
	 */
	public void deleteCampaignDetails(int campaignId) throws Exception {
		String query = QueryMaker.DELETE_CAMPAIGN_DETAILS;
		try {

			connection = getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, campaignId);
			preparedStatement.executeUpdate();

		} catch (Exception exception) {
			logger.error(CampaignDaoImpl.class
					+ ": Error:- While deletng Campaign details from Database.");
		} finally {
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);

		}

	}

	/**
	 * <p>
	 * <code> CampaignVO retriveCampaignDetails(CampaignVO campaignVO, int campaignId)</code>
	 * method will help to retrieve campaign Info.
	 * </p>
	 * * @param (CampaignVO campaignVO, int campaignId)
	 * 
	 * @throws Exception
	 * @return CampaignVO campaignVO
	 */
	public CampaignVO retriveCampaignDetails(CampaignVO campaignVO,
			int campaignId) throws Exception {
		campaignVO = new CampaignVO();
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.SELECT_CAMPAIGN_DETAILS_NAME);
			preparedStatement.setInt(1, campaignId);
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {
					campaignVO.setCampaignId(resultSet.getInt("CAMPAIGN_ID"));
					campaignVO.setSalutation(resultSet.getString("SALUTATION"));
					campaignVO.setCampaignName(resultSet
							.getString("CAMPAIGN_NAME"));
					campaignVO.setCampaignOwner(resultSet
							.getString("REF_CAMPAIGN_OWNER"));
					campaignVO.setExpectedCloseDate(resultSet
							.getString("EXPECTED_CLOSE_DATE"));
					campaignVO.setAssignedTo(resultSet
							.getString("REF_ASSIGNED_TO"));
					campaignVO.setProduct(resultSet.getInt("REF_PRODUCT"));
					campaignVO.setCampaignType(resultSet
							.getString("REF_CAMPAIGN_TYPE"));
					campaignVO.setCampaignStatus(CampaignStatus
							.getCampaignStatus(resultSet
									.getInt("CAMPAIGN_STATUS")));
					campaignVO.setTargetAudience(resultSet
							.getString("TARGET_AUDIENCE"));
					campaignVO
							.setTargetSize(resultSet.getString("TARGET_SIZE"));
					campaignVO.setSponsor(resultSet.getString("SPONSOR"));
					campaignVO.setNumSent(resultSet.getString("NUM_SENT"));
					campaignVO
							.setBudgetCost(resultSet.getString("BUDGET_COST"));
					campaignVO
							.setActualCost(resultSet.getString("ACTUAL_COST"));
					campaignVO.setExpectedRevenue(resultSet
							.getString("EXPECTED_REVENUE"));
					campaignVO.setExpectedResponse(resultSet
							.getString("EXPECTED_RESPONSE"));
					campaignVO.setExpectedSalesCount(resultSet
							.getString("EXPECTED_SALES_COUNT"));
					campaignVO.setActualSalesCount(resultSet
							.getString("ACTUAL_SALES_COUNT"));
					campaignVO.setExpectedResponseCount(resultSet
							.getString("EXPECTED_RESPONSE_COUNT"));
					campaignVO.setActualResponseCount(resultSet
							.getString("ACTUAL_RESPONSE_COUNT"));
					campaignVO.setExpectedROI(resultSet
							.getString("EXPECTED_ROI"));
					campaignVO.setActualROI(resultSet.getString("ACTUAL_ROI"));
					campaignVO.setDescription(resultSet
							.getString("DESCRIPTION"));
					campaignVO.setCreatedBy(nameHelper
							.getCustomerName(resultSet.getInt("CREATED_BY")));
					campaignVO.setCreatedDate(resultSet
							.getString("CREATED_DATE"));
					campaignVO.setUpdatedBy(nameHelper
							.getCustomerName(resultSet.getInt("UPDATED_BY")));
					campaignVO.setUpdateDate(resultSet
							.getString("UPDATED_DATE"));
				}
			}

		} catch (SQLException sqlExp) {
			sqlExp.printStackTrace();
			logger.error(
					CampaignDaoImpl.class
							+ "Error: Occur in Query While selecting All Campaign Details from Database.",
					sqlExp);
		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					CampaignDaoImpl.class
							+ "Error: Occur in Query While Closing Connection After selecting All Campaign from Database.",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return campaignVO;
	}

	/**
	 * <p>
	 * <code>int updateCampaignDetails(CampaignVO campaignVO, int campaignId)</code>
	 * method use to update campaign information details into TAB_CAMPAIGN
	 * table.
	 * </p>
	 * 
	 * @param campaignId
	 * @throws Exception
	 * @return target
	 */
	@Override
	public int updateCampaignDetails(CampaignVO campaignVO, int campaignId)
			throws Exception {
		int target = 0;

		campaignVO.setCampaignId(campaignId);
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.UPDATE_CAMPAIGN_DETAILS);
			preparedStatement.setString(1, campaignVO.getCampaignName());
			preparedStatement.setString(2, campaignVO.getSalutation());
			preparedStatement.setString(3, campaignVO.getCampaignOwner());

			if (campaignVO.getExpectedCloseDate() == null
					|| campaignVO.getExpectedCloseDate() == "") {
				preparedStatement.setString(4,
						campaignVO.getExpectedCloseDate());
			} else {
				preparedStatement.setString(4, DateTimeUtil
						.convertToDate(campaignVO.getExpectedCloseDate()));
			}

			preparedStatement.setString(5, campaignVO.getAssignedTo());
			preparedStatement.setInt(6, campaignVO.getProduct());
			preparedStatement.setString(7, campaignVO.getCampaignType());
			preparedStatement.setString(8, campaignVO.getCampaignStatus());
			preparedStatement.setString(9, campaignVO.getTargetAudience());
			preparedStatement.setString(10, campaignVO.getTargetSize());
			preparedStatement.setString(11, campaignVO.getSponsor());
			preparedStatement.setString(12, campaignVO.getNumSent());
			preparedStatement.setString(13, campaignVO.getBudgetCost());
			preparedStatement.setString(14, campaignVO.getActualCost());
			preparedStatement.setString(15, campaignVO.getExpectedRevenue());
			preparedStatement.setString(16, campaignVO.getExpectedResponse());
			preparedStatement.setString(17, campaignVO.getExpectedSalesCount());
			preparedStatement.setString(18, campaignVO.getActualSalesCount());
			preparedStatement.setString(19,
					campaignVO.getExpectedResponseCount());
			preparedStatement
					.setString(20, campaignVO.getActualResponseCount());
			preparedStatement.setString(21, campaignVO.getExpectedROI());
			preparedStatement.setString(22, campaignVO.getActualROI());
			preparedStatement.setString(23, campaignVO.getDescription());
			preparedStatement.setInt(24, LoginUtil.getCurrentCustomerUser()
					.getCustomerId());
			preparedStatement.setString(25, DateTimeUtil.getDateAndTime());
			preparedStatement.setInt(26, campaignVO.getCampaignId());
			preparedStatement.executeUpdate();
			target = 1;

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					CampaignDaoImpl.class
							+ ": Error:- Error: Occur in Query While updating the campaign details into Database",
					sqlException);

		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					CampaignDaoImpl.class
							+ ": Error:- While closing the Connection after updating the campaign details into Database",
					exception);
		} finally {
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return target;
	}

	/**
	 * <p>
	 * void campaignPDF(HttpServletRequest request, HttpServletResponse
	 * response, int campaignId)
	 * </p>
	 * method to generate the pdf report of campaign details from database
	 * 
	 * @return
	 * @throws Exception
	 */
	public void campaignPDF(HttpServletRequest request,
			HttpServletResponse response, int campaignId) throws Exception {

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
					.prepareStatement(QueryMaker.SHOW_CAMPAIGN_PRINT_PDF);
			preparedStatement.setInt(1, campaignId);
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

			PdfPCell cell104 = new PdfPCell(new Paragraph("CAMPAIGN REPORT",
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

				PdfPCell cell1 = new PdfPCell(new Paragraph(
						"Campaign Information", Font6));
				cell1.setBackgroundColor(new BaseColor(238, 238, 238));
				cell1.setBorderWidth(0.01f);
				cell1.setBorderColor(BaseColor.WHITE);

				PdfPCell cell2 = new PdfPCell(new Paragraph());
				cell2.setBackgroundColor(new BaseColor(238, 238, 238));
				cell2.setBorderWidth(0.2f);
				cell2.setBorderColor(BaseColor.WHITE);

				stringBuffer
						.append(Salutation.getSalutation(resultSet
								.getInt("SALUTATION"))).append(" ")
						.append(resultSet.getString("CAMPAIGN_NAME"));

				PdfPCell cell3 = new PdfPCell(new Paragraph("Campaign Name",
						mainContent));
				cell3.setBackgroundColor(new BaseColor(238, 238, 238));
				cell3.setBorderWidth(0.01f);
				cell3.setBorderColor(BaseColor.WHITE);

				PdfPCell cell4 = new PdfPCell(new Paragraph(
						stringBuffer.toString(), mainContent));
				cell4.setBorderWidth(0.2f);
				cell4.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell5 = new PdfPCell(new Paragraph(
						"Campaign Owner Name", mainContent));
				cell5.setBackgroundColor(new BaseColor(238, 238, 238));
				cell5.setBorderWidth(0.01f);
				cell5.setBorderColor(BaseColor.WHITE);

				PdfPCell cell6 = new PdfPCell(new Paragraph(
						nameHelper.getCampaignOwnerName(resultSet
								.getInt("REF_CAMPAIGN_OWNER")), mainContent));
				cell6.setBorderWidth(0.2f);
				cell6.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell7 = new PdfPCell(new Paragraph(
						"Expected Closed Date", mainContent));
				cell7.setBackgroundColor(new BaseColor(238, 238, 238));
				cell7.setBorderWidth(0.01f);
				cell7.setBorderColor(BaseColor.WHITE);

				PdfPCell cell8 = new PdfPCell(
						new Paragraph(
								resultSet.getString("EXPECTED_CLOSE_DATE"),
								mainContent));
				System.out.println("EXPECTED_CLOSE_DATE ="
						+ resultSet.getString("EXPECTED_CLOSE_DATE"));
				cell8.setBorderWidth(0.2f);
				cell8.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell9 = new PdfPCell(new Paragraph("Assigned To ",
						mainContent));
				cell9.setBackgroundColor(new BaseColor(238, 238, 238));
				cell9.setBorderWidth(0.01f);
				cell9.setBorderColor(BaseColor.WHITE);

				PdfPCell cell10 = new PdfPCell(new Paragraph(
						nameHelper.getCampaignAssignedToName(resultSet
								.getInt("REF_ASSIGNED_TO")), mainContent));
				cell10.setBorderWidth(0.2f);
				cell10.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell11 = new PdfPCell(new Paragraph("Product",
						mainContent));
				cell11.setBackgroundColor(new BaseColor(238, 238, 238));
				cell11.setBorderWidth(0.01f);
				cell11.setBorderColor(BaseColor.WHITE);

				PdfPCell cell12 = new PdfPCell(new Paragraph(
						resultSet.getString("REF_PRODUCT"), mainContent));
				cell12.setBorderWidth(0.2f);
				cell12.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell13 = new PdfPCell(new Paragraph("Campaign Type",
						mainContent));
				cell13.setBackgroundColor(new BaseColor(238, 238, 238));
				cell13.setBorderWidth(0.01f);
				cell13.setBorderColor(BaseColor.WHITE);

				PdfPCell cell14 = new PdfPCell(new Paragraph(
						nameHelper.getCampaignTypeName(resultSet
								.getInt("REF_CAMPAIGN_TYPE")), mainContent));
				cell14.setBorderWidth(0.2f);
				cell14.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell15 = new PdfPCell(new Paragraph("Campaign Status",
						mainContent));
				cell15.setBackgroundColor(new BaseColor(238, 238, 238));
				cell15.setBorderWidth(0.01f);
				cell15.setBorderColor(BaseColor.WHITE);

				PdfPCell cell16 = new PdfPCell(new Paragraph(
						CampaignStatus.getCampaignStatus(resultSet
								.getInt("CAMPAIGN_STATUS")), mainContent));
				cell16.setBorderWidth(0.2f);
				cell16.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell17 = new PdfPCell(new Paragraph("Target Audience",
						mainContent));
				cell17.setBackgroundColor(new BaseColor(238, 238, 238));
				cell17.setBorderWidth(0.01f);
				cell17.setBorderColor(BaseColor.WHITE);

				PdfPCell cell18 = new PdfPCell(new Paragraph(
						resultSet.getString("TARGET_AUDIENCE"), mainContent));
				cell18.setBorderWidth(0.2f);
				cell18.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell19 = new PdfPCell(new Paragraph("Target Size ",
						mainContent));
				cell19.setBackgroundColor(new BaseColor(238, 238, 238));
				cell19.setBorderWidth(0.01f);
				cell19.setBorderColor(BaseColor.WHITE);

				PdfPCell cell20 = new PdfPCell(new Paragraph(
						resultSet.getString("TARGET_SIZE"), mainContent));
				cell20.setBorderWidth(0.2f);
				cell20.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell21 = new PdfPCell(new Paragraph("Sponsor ",
						mainContent));
				cell21.setBackgroundColor(new BaseColor(238, 238, 238));
				cell21.setBorderWidth(0.01f);
				cell21.setBorderColor(BaseColor.WHITE);

				PdfPCell cell22 = new PdfPCell(new Paragraph(
						resultSet.getString("SPONSOR"), mainContent));
				cell22.setBorderWidth(0.2f);
				cell22.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell23 = new PdfPCell(new Paragraph("Num Sent",
						mainContent));
				cell23.setBackgroundColor(new BaseColor(238, 238, 238));
				cell23.setBorderWidth(0.01f);
				cell23.setBorderColor(BaseColor.WHITE);

				PdfPCell cell24 = new PdfPCell(new Paragraph(
						resultSet.getString("NUM_SENT"), mainContent));
				cell24.setBorderWidth(0.2f);
				cell24.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell25 = new PdfPCell(new Paragraph(
						"Expectations & Actuals", Font6));
				cell25.setBackgroundColor(new BaseColor(238, 238, 238));
				cell25.setBorderWidth(0.01f);
				cell25.setBorderColor(BaseColor.WHITE);

				PdfPCell cell26 = new PdfPCell(new Paragraph());
				cell26.setBackgroundColor(new BaseColor(238, 238, 238));
				cell26.setBorderWidth(0.2f);
				cell26.setBorderColor(BaseColor.WHITE);

				PdfPCell cell27 = new PdfPCell(new Paragraph("Budget Cost",
						mainContent));
				cell27.setBackgroundColor(new BaseColor(238, 238, 238));
				cell27.setBorderWidth(0.01f);
				cell27.setBorderColor(BaseColor.WHITE);

				PdfPCell cell28 = new PdfPCell(new Paragraph(
						resultSet.getString("BUDGET_COST"), mainContent));
				cell28.setBorderWidth(0.2f);
				cell28.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell29 = new PdfPCell(new Paragraph("Actual Cost",
						mainContent));
				cell29.setBackgroundColor(new BaseColor(238, 238, 238));
				cell29.setBorderWidth(0.01f);
				cell29.setBorderColor(BaseColor.WHITE);

				PdfPCell cell30 = new PdfPCell(new Paragraph(
						resultSet.getString("ACTUAL_COST"), mainContent));
				cell30.setBorderWidth(0.2f);
				cell30.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell31 = new PdfPCell(new Paragraph(
						"Expected Revenue", mainContent));
				cell31.setBackgroundColor(new BaseColor(238, 238, 238));
				cell31.setBorderWidth(0.01f);
				cell31.setBorderColor(BaseColor.WHITE);

				PdfPCell cell32 = new PdfPCell(new Paragraph(
						resultSet.getString("EXPECTED_REVENUE"), mainContent));
				cell32.setBorderWidth(0.2f);
				cell32.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell33 = new PdfPCell(new Paragraph(
						"Expected Response", mainContent));
				cell33.setBackgroundColor(new BaseColor(238, 238, 238));
				cell33.setBorderWidth(0.01f);
				cell33.setBorderColor(BaseColor.WHITE);

				PdfPCell cell34 = new PdfPCell(
						new Paragraph(CampaignExpectedResponse
								.getCampaignExpectedResponse(resultSet
										.getInt("EXPECTED_RESPONSE")),
								mainContent));
				cell34.setBorderWidth(0.2f);
				cell34.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell35 = new PdfPCell(new Paragraph(
						" Expected Sales Count ", mainContent));
				cell35.setBackgroundColor(new BaseColor(238, 238, 238));
				cell35.setBorderWidth(0.01f);
				cell35.setBorderColor(BaseColor.WHITE);

				PdfPCell cell36 = new PdfPCell(new Paragraph(
						resultSet.getString("EXPECTED_SALES_COUNT"),
						mainContent));
				cell36.setBorderWidth(0.2f);
				cell36.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell37 = new PdfPCell(new Paragraph(
						"Actual Sales Count ", mainContent));
				cell37.setBackgroundColor(new BaseColor(238, 238, 238));
				cell37.setBorderWidth(0.01f);
				cell37.setBorderColor(BaseColor.WHITE);

				PdfPCell cell38 = new PdfPCell(new Paragraph(
						resultSet.getString("ACTUAL_SALES_COUNT"), mainContent));
				cell38.setBorderWidth(0.2f);
				cell38.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell39 = new PdfPCell(new Paragraph(
						"Expected Response Count ", mainContent));
				cell39.setBackgroundColor(new BaseColor(238, 238, 238));
				cell39.setBorderWidth(0.01f);
				cell39.setBorderColor(BaseColor.WHITE);

				PdfPCell cell40 = new PdfPCell(new Paragraph(
						resultSet.getString("EXPECTED_RESPONSE_COUNT"),
						mainContent));
				cell40.setBorderWidth(0.2f);
				cell40.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell41 = new PdfPCell(new Paragraph(
						"Actual Response Count ", mainContent));
				cell41.setBackgroundColor(new BaseColor(238, 238, 238));
				cell41.setBorderWidth(0.01f);
				cell41.setBorderColor(BaseColor.WHITE);

				PdfPCell cell42 = new PdfPCell(new Paragraph(
						resultSet.getString("ACTUAL_RESPONSE_COUNT"),
						mainContent));
				cell42.setBorderWidth(0.2f);
				cell42.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell43 = new PdfPCell(new Paragraph(" Expected ROI",
						mainContent));
				cell43.setBackgroundColor(new BaseColor(238, 238, 238));
				cell43.setBorderWidth(0.01f);
				cell43.setBorderColor(BaseColor.WHITE);

				PdfPCell cell44 = new PdfPCell(new Paragraph(
						resultSet.getString("EXPECTED_ROI"), mainContent));
				cell44.setBorderWidth(0.2f);
				cell44.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell45 = new PdfPCell(new Paragraph(" Actual ROI ",
						mainContent));
				cell45.setBackgroundColor(new BaseColor(238, 238, 238));
				cell45.setBorderWidth(0.01f);
				cell45.setBorderColor(BaseColor.WHITE);

				PdfPCell cell46 = new PdfPCell(new Paragraph(
						resultSet.getString("ACTUAL_ROI"), mainContent));
				cell46.setBorderWidth(0.2f);
				cell46.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell47 = new PdfPCell(new Paragraph(" Created By",
						mainContent));
				cell47.setBackgroundColor(new BaseColor(238, 238, 238));
				cell47.setBorderWidth(0.01f);
				cell47.setBorderColor(BaseColor.WHITE);

				PdfPCell cell48 = new PdfPCell(new Paragraph(
						nameHelper.getCustomerName(resultSet
								.getInt("CREATED_BY")), mainContent));
				cell48.setBorderWidth(0.2f);
				cell48.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell49 = new PdfPCell(new Paragraph(" Created Date",
						mainContent));
				cell49.setBackgroundColor(new BaseColor(238, 238, 238));
				cell49.setBorderWidth(0.01f);
				cell49.setBorderColor(BaseColor.WHITE);

				PdfPCell cell50 = new PdfPCell(new Paragraph(
						resultSet.getString("CREATED_DATE"), mainContent));
				cell50.setBorderWidth(0.2f);
				cell50.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell51 = new PdfPCell(new Paragraph(" Updated By",
						mainContent));
				cell51.setBackgroundColor(new BaseColor(238, 238, 238));
				cell51.setBorderWidth(0.01f);
				cell51.setBorderColor(BaseColor.WHITE);

				PdfPCell cell52 = new PdfPCell(new Paragraph(
						nameHelper.getCustomerName(resultSet
								.getInt("UPDATED_BY")), mainContent));
				cell52.setBorderWidth(0.2f);
				cell52.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell53 = new PdfPCell(new Paragraph(" Updated Date",
						mainContent));
				cell53.setBackgroundColor(new BaseColor(238, 238, 238));
				cell53.setBorderWidth(0.01f);
				cell53.setBorderColor(BaseColor.WHITE);

				PdfPCell cell54 = new PdfPCell(new Paragraph(
						resultSet.getString("UPDATED_DATE"), mainContent));
				cell54.setBorderWidth(0.2f);
				cell54.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell55 = new PdfPCell(new Paragraph("Description",
						Font6));
				cell55.setBackgroundColor(new BaseColor(238, 238, 238));
				cell55.setBorderWidth(0.01f);
				cell55.setBorderColor(BaseColor.WHITE);

				PdfPCell cell56 = new PdfPCell(new Paragraph());
				cell56.setBackgroundColor(new BaseColor(238, 238, 238));
				cell56.setBorderWidth(0.2f);
				cell56.setBorderColor(BaseColor.WHITE);

				PdfPCell cell57 = new PdfPCell(new Paragraph("Description",
						mainContent));
				cell57.setBackgroundColor(new BaseColor(238, 238, 238));
				cell57.setBorderWidth(0.01f);
				cell57.setBorderColor(BaseColor.WHITE);
				String temp = resultSet.getString("DESCRIPTION");

				PdfPCell cell58 = new PdfPCell(new Paragraph(temp.replaceAll(
						"\\<.*?\\>", " "), mainContent));
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
				/*
				 * table.addCell(cell27); table.addCell(cell28);
				 */
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
					CampaignDaoImpl.class
							+ "Error: Occur in Query While Fetching All Campaign Details for print PdF from Database.",
					sqlExp);
		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					CampaignDaoImpl.class
							+ "Error: Occur in Query While Closing Connection After Fetching All Campaign Details for print PdF from Database.",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}

	}

	@Override
	public HashMap<String, String> getCampainNameList()
			throws OMIApplicationException {
		HashMap<String, String> campaignNameList = new HashMap<String, String>();
		try {

			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_CAMPAING_NAME);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				campaignNameList.put(resultSet.getString("CAMPAIGN_NAME"),
						resultSet.getString("CAMPAIGN_NAME"));
			}

		} catch (SQLException sqlException) {

			logger.error(
					CampaignDaoImpl.class
							+ ": Error:- Error: Occur in Query While fetching campaign name list from Database",
					sqlException);

		} catch (Exception exception) {

			logger.error(
					CampaignDaoImpl.class
							+ ": Error:- While closing the Connection after fetching the campaign name list from Database",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return campaignNameList;

	}

	@Override
	public HashMap<String, String> getExpectedRevenueList()
			throws OMIApplicationException {
		HashMap<String, String> expectedRevenueList = new HashMap<String, String>();
		try {

			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_EXPECTED_REVENUE);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				expectedRevenueList.put(
						resultSet.getString("EXPECTED_REVENUE"),
						resultSet.getString("EXPECTED_REVENUE"));

			}

		} catch (SQLException sqlException) {

			logger.error(
					CampaignDaoImpl.class
							+ ": Error:- Error: Occur in Query While fetching expected Revenue list from Database",
					sqlException);

		} catch (Exception exception) {

			logger.error(
					CampaignDaoImpl.class
							+ ": Error:- While closing the Connection after fetching the expected Revenue list from Database",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return expectedRevenueList;
	}

	@Override
	public HashMap<String, String> getExpectedClosingDate()
			throws OMIApplicationException {
		HashMap<String, String> expectedClosingDateList = new HashMap<String, String>();
		try {

			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_EXPECTED_CLOSE_DATE);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				expectedClosingDateList.put(
						resultSet.getString("EXPECTED_CLOSE_DATE"),
						resultSet.getString("EXPECTED_CLOSE_DATE"));

			}

		} catch (SQLException sqlException) {

			logger.error(
					CampaignDaoImpl.class
							+ ": Error:- Error: Occur in Query While fetching expected closing Date list from Database",
					sqlException);

		} catch (Exception exception) {

			logger.error(
					CampaignDaoImpl.class
							+ ": Error:- While closing the Connection after fetching the expected closing date list from Database",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return expectedClosingDateList;
	}

	@Override
	public List<CampaignVO> getCampaignDetails(int searchId, String searchValue)
			throws OMIApplicationException {
		List<CampaignVO> campaignDetailsList = new ArrayList<CampaignVO>();

		try {

			connection = getConnection();
			preparedStatement = connection.prepareStatement(QueryBuilder
					.campaignAdvanceSerach(searchId, searchValue));
			resultSet = preparedStatement.executeQuery();
			/* if (resultSet.next()) { */

			// LEAD_ID,COMPANY_NAME,LEAD_TITLE_REF,CONTACT_PERSON,LEAD_OWNER_REF,LEAD_DATE,EXPECTED_CLOSING_DATE,LEAD_STATUS,CREATED_BY
			while (resultSet.next()) {
				campaignVO = new CampaignVO();

				campaignVO.setCampaignId(resultSet.getInt("CAMPAIGN_ID"));
				campaignVO
						.setCampaignName(resultSet.getString("CAMPAIGN_NAME"));
				campaignVO.setCampaignType(nameHelper
						.getCampaignTypeName(resultSet
								.getInt("REF_CAMPAIGN_TYPE")));
				campaignVO.setAssignedTo(nameHelper.getAssignTo(resultSet
						.getInt("REF_ASSIGNED_TO")));
				campaignVO.setExpectedRevenue(resultSet
						.getString("EXPECTED_REVENUE"));
				campaignVO.setExpectedCloseDate(resultSet
						.getString("EXPECTED_CLOSE_DATE"));
				campaignVO
						.setCampaignStatus(CampaignStatus
								.getCampaignStatus(resultSet
										.getInt("CAMPAIGN_STATUS")));
				campaignDetailsList.add(campaignVO);
			}

		} catch (SQLException sqlExp) {

			logger.error(
					CampaignDaoImpl.class
							+ "Error: Occur in Query While Fetching the Campaign Details into Grid from Database.",
					sqlExp);
		} catch (Exception exception) {

			logger.error(
					CampaignDaoImpl.class
							+ "Error: Occur in Query While Closing Connection After Fetching the Campaign Details into Grid from Database.",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return campaignDetailsList;

	}

}
