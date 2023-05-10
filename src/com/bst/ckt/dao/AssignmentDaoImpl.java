/**
 * 
 */
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
import com.bst.ckt.common.QueryBuilder;
import com.bst.ckt.common.QueryMaker;
import com.bst.ckt.dto.Assignment;
import com.bst.ckt.dto.Lead;
import com.bst.ckt.dto.SupportCases;
import com.bst.ckt.exception.OMIApplicationException;
import com.bst.ckt.framework.db.JdbcDAOSupport;
import com.bst.ckt.framework.db.JdbcHelper;
import com.bst.ckt.framework.util.DateTimeUtil;
import com.bst.ckt.helper.AssignmentStatus;
import com.bst.ckt.helper.NameHelper;
import com.bst.ckt.helper.Ratings;
import com.bst.ckt.vo.AssignmentVO;
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
 * @author Admin
 * 
 */
public class AssignmentDaoImpl extends JdbcDAOSupport implements
		AssignmentDaoInf {

	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	AssignmentVO assignmentVO = null;
	NameHelper nameHelper = new NameHelper();
	Assignment assignment = null;
	Image image=null;

	private static final Logger logger = Logger
			.getLogger(AssignmentDaoImpl.class);

	/**
	 * <p>
	 * <code>addDetails(leadVO)</code> method use to insert assignment details
	 * into TAB_ASSIGNMENT table.
	 * </p>
	 * 
	 * @param assignmentVO
	 * @return target
	 * @throws OMIApplicationException
	 */

	@Override
	public int addDetails(AssignmentVO assignmentVO)
			throws OMIApplicationException {
		int target = 0;
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.ADD_DETAILS);
			preparedStatement.setString(1, assignmentVO.getAssignmentName());

			preparedStatement.setString(2, assignmentVO.getAssignmentOwner());
			preparedStatement.setFloat(3, assignmentVO.getExpectedAmount());
			preparedStatement.setString(4, assignmentVO.getAccount());
			preparedStatement.setString(5, assignmentVO.getContactPerson());
			preparedStatement.setString(6, DateTimeUtil
					.convertToDate(assignmentVO.getExpectedClosingDate()));
			

			preparedStatement.setString(7, assignmentVO.getLeadSource());
			preparedStatement.setString(8, assignmentVO.getAssignedTo());
			
			preparedStatement.setString(9, assignmentVO.getLead());
			preparedStatement.setFloat(10, assignmentVO.getProbability());
			preparedStatement.setString(11, assignmentVO.getCampaign());
			preparedStatement.setString(12, assignmentVO.getWeightedRevenue());
			preparedStatement.setString(13, assignmentVO.getPrimaryEmailId());
			preparedStatement.setString(14, assignmentVO.getPhoneIsd());
			preparedStatement.setString(15, assignmentVO.getPhoneStd());
			preparedStatement.setString(16, assignmentVO.getPhoneNumber());
			preparedStatement.setString(17, assignmentVO.getDescription());
			preparedStatement.setString(18, assignmentVO.getAssignmentStatus());
			preparedStatement.setString(19, OMIConstants.FALSE);
			preparedStatement.setInt(20, assignmentVO.getCreatedBy());
			preparedStatement.setString(21, DateTimeUtil.getCurrentDate());
			

			preparedStatement.executeUpdate();
			target = 1;

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					AssignmentDaoImpl.class
							+ ": Error:- Error: Occur in Query While fetching the Assignment details for view from Database",
					sqlException);

		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					AssignmentDaoImpl.class
							+ ": Error:- While closing the Connection after fetching the Assignment details for view from Database",
					exception);
		} finally {

			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}

		return target;
	}

	@Override
	public List<AssignmentVO> getAssignmentList()
			throws OMIApplicationException {
		ArrayList<AssignmentVO> assignmentList = new ArrayList<AssignmentVO>();
		try {

			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_ASSIGNMENT_DETAILS);
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {
					AssignmentVO assignmentVO = new AssignmentVO();
					assignmentVO.setAssignmentId(resultSet
							.getInt("ASSIGNMENT_ID"));
					assignmentVO.setAssignedTo(nameHelper.getAssignTo(resultSet
							.getInt("ASSIGN_TO")));
					
					assignmentVO.setExpectedClosingDate(DateTimeUtil.convertDatetoFormDateForView(resultSet
							.getString("EXPECTED_CLOSING_DATE")));
					assignmentVO.setAssignmentStatus(AssignmentStatus.getAssignmentStatus(resultSet
							.getInt("ASSIGNMENT_STATUS")));
					assignmentList.add(assignmentVO);
				}
			}

		} catch (SQLException sqlExp) {
			sqlExp.printStackTrace();
			logger.error(
					AssignmentDaoImpl.class
							+ "Error: Occur in Query While Fetching  Assignment  from Database.",
					sqlExp);
		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					AssignmentDaoImpl.class
							+ "Error: Occur in Query While Closing Connection After Assignment   from Database.",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return assignmentList;
	}

	/**
	 * <p>
	 * <code>getAssignmentDetails()</code> method use to fetch assignment
	 * details from TAB_ASSIGNMENT table.
	 * </p>
	 * 
	 * @param leadId
	 *            int
	 * @return lead Lead
	 */
	@Override
	public Assignment getAssignmentDetails(int assignmentId) throws Exception {
		Assignment assignment = new Assignment();
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.SHOW_ASSIGNMENT_DETAILS);
			preparedStatement.setInt(1, assignmentId);
			resultSet = preparedStatement.executeQuery();

			if (resultSet != null) {
				while (resultSet.next()) {

					assignment.setAssignmentId(resultSet
							.getInt("ASSIGNMENT_ID"));
					assignment.setAssignmentOwner(nameHelper.getAssignmentOwner(resultSet
							.getInt("ASSIGNMENT_OWNER")));
					assignment.setAssignmentName(resultSet
							.getString("ASSIGNMENT_NAME"));
					assignment.setAccount(nameHelper.getAssignmentAccount(resultSet.getInt("ACCOUNT")));
					assignment.setExpectedAmount(resultSet
							.getFloat("EXPECTED_AMMOUNT"));
					assignment.setContactPerson(nameHelper.getAssignmentContactPerson(resultSet
							.getInt("CONTACT_PERSON")));
					assignment.setExpectedClosingDate(DateTimeUtil
							.convertDatetoFormDateForView(resultSet
									.getString("EXPECTED_CLOSING_DATE")));
					
					assignment.setLeadSource(nameHelper.getAssignmentLeadSource(resultSet.getInt("LEAD_SOURCE")));
				
					assignment.setAssignedTo(nameHelper.getAssignTo(resultSet
							.getInt("ASSIGN_TO")));
					
					assignment.setLead(nameHelper.getAssignmentLead(resultSet.getInt("LEAD")));
					assignment
							.setProbability(resultSet.getFloat("PROBABILITY"));
					assignment.setWeightedRevenue(resultSet
							.getString("WEIGHTED_REVEINUE"));
					assignment.setCampaign(nameHelper.getAssignmentCampaign(resultSet.getInt("CAMPING")));

					assignment.setPrimaryEmailId(resultSet
							.getString("PRIMARY_EMAIL_ID"));
					assignment.setPhoneIsd(resultSet.getString("PHONE_ISD"));
					assignment.setPhoneStd(resultSet.getString("PHONE_STD"));
					assignment.setPhoneNumber(resultSet
							.getString("PHONE_NUMBER"));
					assignment.setDescription(resultSet
							.getString("DESCRIPTION"));
					assignment.setCreatedBy(resultSet.getInt("CREATED_BY"));
					assignment.setCreationDate(resultSet
							.getString("CREATION_DATE"));
					assignment.setAssignmentStatus(AssignmentStatus.getAssignmentStatus(resultSet.getInt("ASSIGNMENT_STATUS")));

				}
			}
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					AssignmentDaoImpl.class
							+ ": Error:- Error: Occur in Query While fetching the aSSIGNMENT details for view from Database",
					sqlException);

		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					AssignmentDaoImpl.class
							+ ": Error:- While closing the Connection after fetching the ASSIGNMENT details for view from Database",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return assignment;
	}

	/**
	 * <p>
	 * <code>editAssignmentDetail</code>Method will edit Assignment Detail data
	 * from based assignmentId
	 * </p>
	 * 
	 * @return Assignment
	 * @throws OMIApplicationException
	 * @param (int assignmentId)
	 */

	@Override
	public Assignment editAssignmentDetail(int assignmentId) throws Exception {
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_ASSIGNMENT_EDIT);
			preparedStatement.setInt(1, assignmentId);
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {
					assignment = new Assignment();
					assignment.setAssignmentId(resultSet
							.getInt("ASSIGNMENT_ID"));
					assignment.setAssignmentOwner(resultSet
							.getString("ASSIGNMENT_OWNER"));
					assignment.setAssignmentName(resultSet
							.getString("ASSIGNMENT_NAME"));
					assignment.setExpectedAmount(resultSet
							.getFloat("EXPECTED_AMMOUNT"));
					assignment.setContactPerson(resultSet
							.getString("CONTACT_PERSON"));
					assignment.setExpectedClosingDate(DateTimeUtil
							.convertDatetoFormDateForView(resultSet
									.getString("EXPECTED_CLOSING_DATE")));
					assignment.setLeadSource(resultSet.getString("LEAD_SOURCE"));
					assignment.setAssignedTo(resultSet.getString("ASSIGN_TO"));
					assignment.setLead(resultSet.getString("LEAD"));
					assignment
							.setProbability(resultSet.getFloat("PROBABILITY"));
					assignment.setWeightedRevenue(resultSet
							.getString("WEIGHTED_REVEINUE"));
					assignment.setCampaign(resultSet.getString("CAMPING"));

					assignment.setPrimaryEmailId(resultSet
							.getString("PRIMARY_EMAIL_ID"));
					assignment.setPhoneIsd(resultSet.getString("PHONE_ISD"));
					assignment.setPhoneStd(resultSet.getString("PHONE_STD"));
					assignment.setPhoneNumber(resultSet
							.getString("PHONE_NUMBER"));
					assignment.setDescription(resultSet
							.getString("DESCRIPTION"));
					assignment.setCreatedBy(resultSet.getInt("CREATED_BY"));
					assignment.setCreationDate(resultSet
							.getString("CREATION_DATE"));
					assignment.setAccount(resultSet.getString("ACCOUNT"));
					assignment.setAssignmentStatus(AssignmentStatus.getAssignmentStatus(resultSet.getInt("ASSIGNMENT_STATUS")));

				}
			}
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					AssignmentDaoImpl.class
							+ ": Error:- Error: Occur in Query While fetching the Cases details from Database",
					sqlException);

		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					AssignmentDaoImpl.class
							+ ": Error:- While closing the Connection after fetching the Cases details from Database",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return assignment;
	}

	@Override
	public int getAssignmentDetailsForUpdate(AssignmentVO assignmentVO,
			int assignmentId) throws OMIApplicationException {
		int target = 0;

		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.UPDATE_ASSIGNMENT_DETAILS);

			preparedStatement.setString(1, assignmentVO.getAssignmentName());

			preparedStatement.setString(2, assignmentVO.getAssignmentOwner());
			preparedStatement.setFloat(3, assignmentVO.getExpectedAmount());
			preparedStatement.setString(4, assignmentVO.getAccount());
			preparedStatement.setString(5, assignmentVO.getContactPerson());

			preparedStatement.setString(6, assignmentVO.getLeadSource());
			preparedStatement.setString(7, assignmentVO.getAssignedTo());

			preparedStatement.setString(8, assignmentVO.getLead());
			preparedStatement.setFloat(9, assignmentVO.getProbability());
			preparedStatement.setString(10, assignmentVO.getCampaign());
			preparedStatement.setString(11, assignmentVO.getWeightedRevenue());
			preparedStatement.setString(12, assignmentVO.getPrimaryEmailId());
			preparedStatement.setString(13, assignmentVO.getPhoneIsd());
			preparedStatement.setString(14, assignmentVO.getPhoneStd());
			preparedStatement.setString(15, assignmentVO.getPhoneNumber());
			preparedStatement.setString(16, assignmentVO.getDescription());
			preparedStatement.setString(17, assignmentVO.getAssignmentStatus());
			preparedStatement.setString(18, OMIConstants.FALSE);
			preparedStatement.setInt(19, assignmentVO.getCreatedBy());
			preparedStatement.setString(20, DateTimeUtil.getCurrentDate());
			preparedStatement.setString(21, DateTimeUtil.getCurrentDate());
			preparedStatement.setInt(22, assignmentId);

			preparedStatement.executeUpdate();
			target = 1;

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					AssignmentDaoImpl.class
							+ ": Error:- Error: Occur in Query While fetching the Assignment details from Database",
					sqlException);

		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					AssignmentDaoImpl.class
							+ ": Error:- While closing the Connection after fetching the Assignment details from Database",
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
	 * <code>getSearchAssignmentDetails()</code> method use to fetching assignment details from
	 * TAB_ASSIGNMENT table.
	 * </p>
	 * 
	 * @param searchValue
	 * @param searchId
	 * 
	 * @return assignmentDetailsList
	 * @throws Exception
	 */

	@Override
	public List<AssignmentVO> getSearchAssignmentDetails(int searchId,
			String searchValue) throws Exception {
		List<AssignmentVO> assignmentDetailsList = new ArrayList<AssignmentVO>();

		try {

			connection = getConnection();
			preparedStatement = connection.prepareStatement(QueryBuilder
					.AssignmentAdvanceSearch(searchId, searchValue));
			resultSet = preparedStatement.executeQuery();
			
				while (resultSet.next()) {
					assignmentVO = new AssignmentVO();
					assignmentVO.setAssignmentId(resultSet.getInt("ASSIGNMENT_ID"));
					
					assignmentVO.setAssignedTo(nameHelper.getAssignTo(resultSet.getInt("ASSIGN_TO")));
					
					assignmentVO.setExpectedClosingDate(resultSet
							.getString("EXPECTED_CLOSING_DATE"));
					
					assignmentVO.setAssignmentStatus(AssignmentStatus.getAssignmentStatus(resultSet.getInt("ASSIGNMENT_STATUS")));
				
					assignmentDetailsList.add(assignmentVO);
				}
			

		} catch (SQLException sqlExp) {
			sqlExp.printStackTrace();
			logger.error(
					LeadDaoImpl.class
							+ "Error: Occur in Query While Fetching the Lead Details into Grid from Database.",
					sqlExp);
		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					LeadDaoImpl.class
							+ "Error: Occur in Query While Closing Connection After Fetching the Lead Details into Grid from Database.",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return assignmentDetailsList;
	}
	
	
	@Override
	public void assignmentPDF(HttpServletRequest request,
			HttpServletResponse response, int assignmentId) throws Exception {
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
					.prepareStatement(QueryMaker.SHOW_ASSIGNMENT_PRINT_PDF);
			preparedStatement.setInt(1, assignmentId);
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

			PdfPCell cell104 = new PdfPCell(new Paragraph("ASSIGNMENT REPORT",
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
						"Assignment Information", Font6));
				cell1.setBackgroundColor(new BaseColor(238, 238, 238));
				cell1.setBorderWidth(0.01f);
				cell1.setBorderColor(BaseColor.WHITE);

				PdfPCell cell2 = new PdfPCell(new Paragraph());
				cell2.setBackgroundColor(new BaseColor(238, 238, 238));
				cell2.setBorderWidth(0.2f);
				cell2.setBorderColor(BaseColor.WHITE);

				PdfPCell cell3 = new PdfPCell(new Paragraph("ASSIGNMENT NAME",
						mainContent));
				cell3.setBackgroundColor(new BaseColor(238, 238, 238));
				cell3.setBorderWidth(0.01f);
				cell3.setBorderColor(BaseColor.WHITE);

				PdfPCell cell4 = new PdfPCell(new Paragraph(
						resultSet.getString("ASSIGNMENT_NAME"), mainContent));
				cell4.setBorderWidth(0.2f);
				cell4.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell5 = new PdfPCell(new Paragraph("ASSIGNMENT OWNER",
						mainContent));
				cell5.setBackgroundColor(new BaseColor(238, 238, 238));
				cell5.setBorderWidth(0.01f);
				cell5.setBorderColor(BaseColor.WHITE);

				PdfPCell cell6 = new PdfPCell(new Paragraph(
						nameHelper.getAssignmentOwner(resultSet
								.getInt("ASSIGNMENT_OWNER"))));
				cell6.setBorderWidth(0.2f);
				cell6.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell7 = new PdfPCell(new Paragraph("EXPECTED AMMOUNT",
						mainContent));
				cell7.setBackgroundColor(new BaseColor(238, 238, 238));
				cell7.setBorderWidth(0.01f);
				cell7.setBorderColor(BaseColor.WHITE);

				PdfPCell cell8 = new PdfPCell(new Paragraph(
						resultSet.getString("EXPECTED_AMMOUNT"), mainContent));
				cell8.setBorderWidth(0.2f);
				cell8.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell9 = new PdfPCell(new Paragraph("ACCOUNT",
						mainContent));
				cell9.setBackgroundColor(new BaseColor(238, 238, 238));
				cell9.setBorderWidth(0.01f);
				cell9.setBorderColor(BaseColor.WHITE);

				PdfPCell cell10 = new PdfPCell(new Paragraph(
						resultSet.getString("ACCOUNT"), mainContent));
				cell10.setBorderWidth(0.2f);
				cell10.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell11 = new PdfPCell(new Paragraph("CONTACT PERSON",
						mainContent));
				cell11.setBackgroundColor(new BaseColor(238, 238, 238));
				cell11.setBorderWidth(0.01f);
				cell11.setBorderColor(BaseColor.WHITE);

				PdfPCell cell12 = new PdfPCell(new Paragraph(
						nameHelper.getAssignmentContactPerson(resultSet
								.getInt("CONTACT_PERSON"))));
				cell12.setBorderWidth(0.2f);
				cell12.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell13 = new PdfPCell(new Paragraph(
						"EXPECTED CLOSING DATE", mainContent));
				cell13.setBackgroundColor(new BaseColor(238, 238, 238));
				cell13.setBorderWidth(0.01f);
				cell13.setBorderColor(BaseColor.WHITE);

				PdfPCell cell14 = new PdfPCell(new Paragraph(
						resultSet.getString("EXPECTED_CLOSING_DATE"),
						mainContent));
				cell14.setBorderWidth(0.2f);
				cell14.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell15 = new PdfPCell(new Paragraph("LEAD SOURCE",
						mainContent));
				cell15.setBackgroundColor(new BaseColor(238, 238, 238));
				cell15.setBorderWidth(0.01f);
				cell15.setBorderColor(BaseColor.WHITE);

				PdfPCell cell16 = new PdfPCell(new Paragraph(
						nameHelper.getAssignmentLeadSource(
								resultSet.getInt("LEAD_SOURCE"))));
				cell16.setBorderWidth(0.2f);
				cell16.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell17 = new PdfPCell(new Paragraph("ASSIGN TO",
						mainContent));
				cell17.setBackgroundColor(new BaseColor(238, 238, 238));
				cell17.setBorderWidth(0.01f);
				cell17.setBorderColor(BaseColor.WHITE);

				PdfPCell cell18 = new PdfPCell(new Paragraph(nameHelper.getAssignTo(
						resultSet.getInt("ASSIGN_TO"))));
				cell18.setBorderWidth(0.2f);
				cell18.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell19 = new PdfPCell(new Paragraph("LEAD",
						mainContent));
				cell19.setBackgroundColor(new BaseColor(238, 238, 238));
				cell19.setBorderWidth(0.01f);
				cell19.setBorderColor(BaseColor.WHITE);

				PdfPCell cell20 = new PdfPCell(new Paragraph(nameHelper.getAssignmentLead(
						resultSet.getInt("LEAD"))));
				cell20.setBorderWidth(0.2f);
				cell20.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell21 = new PdfPCell(new Paragraph("PROBABILITY",
						mainContent));
				cell21.setBackgroundColor(new BaseColor(238, 238, 238));
				cell21.setBorderWidth(0.01f);
				cell21.setBorderColor(BaseColor.WHITE);

				PdfPCell cell22 = new PdfPCell(new Paragraph(
						resultSet.getString("PROBABILITY"), mainContent));
				cell22.setBorderWidth(0.2f);
				cell22.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell23 = new PdfPCell(new Paragraph("CAMPING",
						mainContent));
				cell23.setBackgroundColor(new BaseColor(238, 238, 238));
				cell23.setBorderWidth(0.01f);
				cell23.setBorderColor(BaseColor.WHITE);

				PdfPCell cell24 = new PdfPCell(new Paragraph(nameHelper.getAssignmentCampaign(
						resultSet.getInt("CAMPING"))));
				cell24.setBorderWidth(0.2f);
				cell24.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell25 = new PdfPCell(new Paragraph(
						"WEIGHTED REVEINUE", mainContent));
				cell25.setBackgroundColor(new BaseColor(238, 238, 238));
				cell25.setBorderWidth(0.01f);
				cell25.setBorderColor(BaseColor.WHITE);

				PdfPCell cell26 = new PdfPCell(new Paragraph(
						resultSet.getString("WEIGHTED_REVEINUE"), mainContent));
				cell26.setBorderWidth(0.2f);
				cell26.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell27 = new PdfPCell(new Paragraph(
						"PRIMARY EMAIL ID", mainContent));
				cell27.setBackgroundColor(new BaseColor(238, 238, 238));
				cell27.setBorderWidth(0.01f);
				cell27.setBorderColor(BaseColor.WHITE);

				PdfPCell cell28 = new PdfPCell(new Paragraph(
						resultSet.getString("PRIMARY_EMAIL_ID"), mainContent));
				cell28.setBorderWidth(0.2f);
				cell28.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell29 = new PdfPCell(new Paragraph("PHONE ISD",
						mainContent));
				cell29.setBackgroundColor(new BaseColor(238, 238, 238));
				cell29.setBorderWidth(0.01f);
				cell29.setBorderColor(BaseColor.WHITE);

				PdfPCell cell30 = new PdfPCell(new Paragraph(
						resultSet.getString("PHONE_ISD"), mainContent));
				cell30.setBorderWidth(0.2f);
				cell30.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell31 = new PdfPCell(new Paragraph("PHONE STD",
						mainContent));
				cell31.setBackgroundColor(new BaseColor(238, 238, 238));
				cell31.setBorderWidth(0.01f);
				cell3.setBorderColor(BaseColor.WHITE);

				PdfPCell cell32 = new PdfPCell(new Paragraph(
						resultSet.getString("PHONE_STD"), mainContent));
				cell32.setBorderWidth(0.2f);
				cell32.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell33 = new PdfPCell(new Paragraph("PHONE NUMBER",
						mainContent));
				cell33.setBackgroundColor(new BaseColor(238, 238, 238));
				cell33.setBorderWidth(0.01f);
				cell33.setBorderColor(BaseColor.WHITE);

				PdfPCell cell34 = new PdfPCell(new Paragraph(
						resultSet.getString("PHONE_NUMBER"), mainContent));
				cell34.setBorderWidth(0.2f);
				cell34.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell35 = new PdfPCell(new Paragraph("DESCRIPTION",
						mainContent));
				cell35.setBackgroundColor(new BaseColor(238, 238, 238));
				cell35.setBorderWidth(0.01f);
				cell35.setBorderColor(BaseColor.WHITE);

				PdfPCell cell36 = new PdfPCell(new Paragraph(
						resultSet.getString("DESCRIPTION"), mainContent));
				cell36.setBorderWidth(0.2f);
				cell36.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell37 = new PdfPCell(new Paragraph(
						"ASSIGNMENT STATUS", mainContent));
				cell37.setBackgroundColor(new BaseColor(238, 238, 238));
				cell37.setBorderWidth(0.01f);
				cell3.setBorderColor(BaseColor.WHITE);

				PdfPCell cell38 = new PdfPCell(new Paragraph(
						resultSet.getString("ASSIGNMENT_STATUS"), mainContent));
				cell38.setBorderWidth(0.2f);
				cell38.setBorderColor(BaseColor.LIGHT_GRAY);

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
					LeadDaoImpl.class
							+ "Error: Occur in Query While Fetching All Lead Details for print PdF from Database.",
					sqlExp);
		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					LeadDaoImpl.class
							+ "Error: Occur in Query While Closing Connection After Fetching All Lead Details for print PdF from Database.",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}

	}

}


