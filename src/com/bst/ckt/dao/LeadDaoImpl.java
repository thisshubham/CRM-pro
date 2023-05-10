/*
 **********************************************************************
 *
 * COPYRIGHT. $ID$ 2015. ALL RIGHTS RESERVED.
 *
 * This software is only to be used for the purpose for which it has been
 * provided. No part of it is to be reproduced, disassembled, transmitted,
 * stored in a retrieval system nor translated in any human or computer
 * language in any way or for any other purposes whatsoever without the
 * prior written consent of $ID$.
 * 
 * Class Name     LeadDaoImpl.java     
 *                                                            
 * Creation Date  AUG 20, 2015 
 * 
 * Abstract       This is Name helper class to retrieve data from database 
 *                and returns name of value based on input.
 *  
 * Amendment History (in chronological sequence): AUG 10, 2015 
 * 
 **********************************************************************
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

import com.bst.ckt.common.QueryBuilder;
import com.bst.ckt.common.QueryMaker;
import com.bst.ckt.dto.Lead;
import com.bst.ckt.exception.OMIApplicationException;
import com.bst.ckt.framework.db.JdbcDAOSupport;
import com.bst.ckt.framework.db.JdbcHelper;
import com.bst.ckt.framework.util.DateTimeUtil;
import com.bst.ckt.helper.AppendHelper;
import com.bst.ckt.helper.LeadStatus;
import com.bst.ckt.helper.Modules;
import com.bst.ckt.helper.NameHelper;
import com.bst.ckt.helper.Ratings;
import com.bst.ckt.helper.Salutation;
import com.bst.ckt.vo.LeadTitleVO;
import com.bst.ckt.vo.LeadVO;
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

public class LeadDaoImpl extends JdbcDAOSupport implements LeadDaoInf {

	/**
	 * Creating Logger object, logger object mapped with LeadDaoImpl class for
	 * writing Loggers.
	 */
	public static final Logger logger = Logger.getLogger(LeadDaoImpl.class);

	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	LeadVO leadVO = null;
	Lead lead = null;
	Image image = null;
	NameHelper nameHelper = new NameHelper();
	LeadTitleVO leadTitleVO = null;

	/**
	 * <p>
	 * <code>insertLeadDetail(leadVO)</code> method use to insert lead details
	 * into TAB_LEAD_DETAILS table.
	 * </p>
	 * 
	 * @param leadVO
	 * @return target
	 * @throws Exception
	 */
	@Override
	public int insertLeadDetail(LeadVO leadVO) throws Exception {

		String AddLeadDetailsQuery = QueryMaker.ADD_LEAD_DETAIL;

		int target = 0;
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(AddLeadDetailsQuery);
			preparedStatement.setString(1, leadVO.getCompanyName());
			preparedStatement.setString(2, leadVO.getSalutation());
			preparedStatement.setString(3, leadVO.getContactPerson());
			preparedStatement.setString(4, leadVO.getLeadTitle());
			preparedStatement.setString(5, leadVO.getCompanyType());
			preparedStatement.setString(6, leadVO.getCompanyCategory());
			preparedStatement.setString(7, leadVO.getCompanySector());
			preparedStatement.setInt(8, leadVO.getLeadSource());
			preparedStatement.setString(9, leadVO.getLeadSourceName());
			preparedStatement.setString(10, leadVO.getNoOfAssociate());

			if (leadVO.getNoOfAssociate() != null
					|| leadVO.getNoOfAssociate() != "") {
				preparedStatement.setInt(10, 0);
			} else {
				preparedStatement.setString(10, leadVO.getNoOfAssociate());
			}
			if (leadVO.getAnnualRevenue() != null
					|| leadVO.getAnnualRevenue() != "") {
				preparedStatement.setString(11, "0.00");
			} else {
				preparedStatement.setString(11, leadVO.getAnnualRevenue());
			}

			if (leadVO.getLeadDate() == null || leadVO.getLeadDate() == "") {
				preparedStatement.setString(12, leadVO.getLeadDate());
			} else {
				preparedStatement.setString(12,
						DateTimeUtil.convertToDate(leadVO.getLeadDate()));
			}
			if (leadVO.getExpectedClosingDate() == null
					|| leadVO.getExpectedClosingDate() == "") {
				preparedStatement
						.setString(13, leadVO.getExpectedClosingDate());
			} else {
				preparedStatement.setString(13, DateTimeUtil
						.convertToDate(leadVO.getExpectedClosingDate()));
			}

			preparedStatement.setInt(14, leadVO.getLeadOwnerId());
			preparedStatement.setString(15, leadVO.getRatings());
			preparedStatement.setString(16, leadVO.getEmailOptOut());
			preparedStatement.setString(17, leadVO.getAddressLine1());
			preparedStatement.setString(18, leadVO.getAddressLine2());
			preparedStatement.setString(19, leadVO.getCity());
			preparedStatement.setString(20, leadVO.getState());
			preparedStatement.setString(21, leadVO.getCountry());
			preparedStatement.setString(22, leadVO.getZipcode());
			preparedStatement.setString(23, leadVO.getPhoneNo());
			preparedStatement.setString(24, leadVO.getMobileNo());
			preparedStatement.setString(25, leadVO.getPrimaryEmailId());
			preparedStatement.setString(26, leadVO.getAlternateEmailId());
			preparedStatement.setString(27, leadVO.getFax());
			preparedStatement.setString(28, leadVO.getWebsite());
			preparedStatement.setString(29, leadVO.getRequirment().trim());
			preparedStatement.setInt(30, LeadStatus.NEW_ID);
			preparedStatement.setInt(31, leadVO.getCreatedBy());
			preparedStatement.setString(32, DateTimeUtil.getDateAndTime());
			preparedStatement.setString(33, leadVO.getPhoneIsd());
			preparedStatement.setString(34, leadVO.getPhoneStd());
			preparedStatement.setString(35, leadVO.getMobileIsd());
			preparedStatement.setString(36, leadVO.getFaxIsd());
			preparedStatement.setString(37, leadVO.getFaxStd());
			preparedStatement.executeUpdate();
			target = 1;
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					LeadDaoImpl.class
							+ "Error: Occur in Query While Inserting the Lead Details into Database.",
					sqlException);

		} catch (Exception exception) {

			exception.printStackTrace();
			logger.error(
					LeadDaoImpl.class
							+ "Error: Occur While Closing Connection After Inserting the Lead Details into Database.",
					exception);
		} finally {
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return target;
	}

	/**
	 * <p>
	 * <code>getLeadDetails()</code> method use to fetching lead details from
	 * TAB_LEAD_DETAILS table.
	 * </p>
	 * 
	 * @param searchValue
	 * @param searchId
	 * 
	 * @return leadDetailsList
	 * @throws Exception
	 */

	public List<LeadVO> getLeadDetails(int searchId, String searchValue)
			throws Exception {

		List<LeadVO> leadDetailsList = new ArrayList<LeadVO>();

		try {

			connection = getConnection();
			preparedStatement = connection.prepareStatement(QueryBuilder
					.advanceSerach(searchId, searchValue));
			resultSet = preparedStatement.executeQuery();
			/* if (resultSet.next()) { */

			// LEAD_ID,COMPANY_NAME,LEAD_TITLE_REF,CONTACT_PERSON,LEAD_OWNER_REF,LEAD_DATE,EXPECTED_CLOSING_DATE,LEAD_STATUS,CREATED_BY
			while (resultSet.next()) {
				leadVO = new LeadVO();
				leadVO.setLeadId(resultSet.getInt("LEAD_ID"));
				System.out
						.println("dao lead id " + resultSet.getInt("LEAD_ID"));
				leadVO.setCompanyName(resultSet.getString("COMPANY_NAME"));
				System.out.println("company name dao"
						+ resultSet.getString("COMPANY_NAME"));
				leadVO.setLeadTitle(nameHelper.getLeadTitle(resultSet
						.getInt("LEAD_TITLE_REF")));
				leadVO.setFullName(AppendHelper.appendSalutaion(
						resultSet.getInt("SALUTATION"),
						resultSet.getString("CONTACT_PERSON")));

				leadVO.setLeadOwner(nameHelper.getCustomerName(resultSet
						.getInt("LEAD_OWNER_REF")));

				if (resultSet.getString("LEAD_DATE") == null) {
					leadVO.setLeadDate(resultSet.getString("LEAD_DATE"));
				} else {
					leadVO.setLeadDate(DateTimeUtil
							.convertDatetoFormDateForView(resultSet
									.getString("LEAD_DATE")));
				}

				if (resultSet.getString("EXPECTED_CLOSING_DATE") == null) {
					leadVO.setExpectedClosingDate(resultSet
							.getString("EXPECTED_CLOSING_DATE"));
				} else {
					leadVO.setExpectedClosingDate(DateTimeUtil
							.convertDatetoFormDateForView(resultSet
									.getString("EXPECTED_CLOSING_DATE")));

				}

				leadVO.setLeadSourceStatus(LeadStatus.getLeadStatus(resultSet
						.getInt("LEAD_STATUS")));
				leadVO.setCreatedByName(nameHelper.getCustomerName(resultSet
						.getInt("CREATED_BY")));
				leadDetailsList.add(leadVO);
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
		return leadDetailsList;
	}

	/**
	 * <p>
	 * <code>leadPDF()</code> method use to generate pdf report for lead details
	 * from TAB_LEAD_DETAILS table.
	 * 
	 * </p>
	 * 
	 * @return leadVO
	 * @throws Exception
	 */
	@Override
	public void leadPDF(HttpServletRequest request,
			HttpServletResponse response, int leadId) {

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
					.prepareStatement(QueryMaker.SHOW_LEAD_PRINT_PDF);
			preparedStatement.setInt(1, leadId);
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

			PdfPCell cell104 = new PdfPCell(new Paragraph("LEAD REPORT", Font4));
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

				PdfPCell cell1 = new PdfPCell(new Paragraph("Lead Information",
						Font6));
				cell1.setBackgroundColor(new BaseColor(238, 238, 238));
				cell1.setBorderWidth(0.01f);
				cell1.setBorderColor(BaseColor.WHITE);

				PdfPCell cell2 = new PdfPCell(new Paragraph());
				cell2.setBackgroundColor(new BaseColor(238, 238, 238));
				cell2.setBorderWidth(0.2f);
				cell2.setBorderColor(BaseColor.WHITE);

				PdfPCell cell3 = new PdfPCell(new Paragraph("Owner Name",
						mainContent));
				cell3.setBackgroundColor(new BaseColor(238, 238, 238));
				cell3.setBorderWidth(0.01f);
				cell3.setBorderColor(BaseColor.WHITE);

				PdfPCell cell4 = new PdfPCell(new Paragraph(
						nameHelper.getCustomerName(resultSet
								.getInt("LEAD_OWNER_REF")), mainContent));
				cell4.setBorderWidth(0.2f);
				cell4.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell5 = new PdfPCell(new Paragraph(
						"Lead Creation Date", mainContent));
				cell5.setBackgroundColor(new BaseColor(238, 238, 238));
				cell5.setBorderWidth(0.01f);
				cell5.setBorderColor(BaseColor.WHITE);

				PdfPCell cell6 = new PdfPCell(new Paragraph(
						resultSet.getString("LEAD_DATE"), mainContent));
				cell6.setBorderWidth(0.2f);
				cell6.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell7 = new PdfPCell(new Paragraph("Company Name",
						mainContent));
				cell7.setBackgroundColor(new BaseColor(238, 238, 238));
				cell7.setBorderWidth(0.01f);
				cell7.setBorderColor(BaseColor.WHITE);

				PdfPCell cell8 = new PdfPCell(new Paragraph(
						resultSet.getString("COMPANY_NAME"), mainContent));
				cell8.setBorderWidth(0.2f);
				cell8.setBorderColor(BaseColor.LIGHT_GRAY);

				stringBuffer
						.append(Salutation.getSalutation(resultSet
								.getInt("SALUTATION"))).append(" ")
						.append(resultSet.getString("CONTACT_PERSON"));

				PdfPCell cell9 = new PdfPCell(new Paragraph("Contact Person",
						mainContent));
				cell9.setBackgroundColor(new BaseColor(238, 238, 238));
				cell9.setBorderWidth(0.01f);
				cell9.setBorderColor(BaseColor.WHITE);

				PdfPCell cell10 = new PdfPCell(new Paragraph(
						stringBuffer.toString(), mainContent));
				cell10.setBorderWidth(0.2f);
				cell10.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell11 = new PdfPCell(new Paragraph("Lead Title",
						mainContent));
				cell11.setBackgroundColor(new BaseColor(238, 238, 238));
				cell11.setBorderWidth(0.01f);
				cell11.setBorderColor(BaseColor.WHITE);

				PdfPCell cell12 = new PdfPCell(new Paragraph(
						nameHelper.getLeadTitle(resultSet
								.getInt("LEAD_TITLE_REF")), mainContent));
				cell12.setBorderWidth(0.2f);
				cell12.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell13 = new PdfPCell(new Paragraph("Company Type",
						mainContent));
				cell13.setBackgroundColor(new BaseColor(238, 238, 238));
				cell13.setBorderWidth(0.01f);
				cell13.setBorderColor(BaseColor.WHITE);

				PdfPCell cell14 = new PdfPCell(new Paragraph(
						nameHelper.getCompanyTypeName(resultSet
								.getInt("COMPANY_TYPE_REF")), mainContent));
				cell14.setBorderWidth(0.2f);
				cell14.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell15 = new PdfPCell(new Paragraph(
						"Company Category ", mainContent));
				cell15.setBackgroundColor(new BaseColor(238, 238, 238));
				cell15.setBorderWidth(0.01f);
				cell15.setBorderColor(BaseColor.WHITE);

				PdfPCell cell16 = new PdfPCell(new Paragraph(
						nameHelper.getCompanyCategoryName(resultSet
								.getInt("COMPANY_CATEGORY_REF")), mainContent));
				cell16.setBorderWidth(0.2f);
				cell16.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell17 = new PdfPCell(new Paragraph("Company Sector",
						mainContent));
				cell17.setBackgroundColor(new BaseColor(238, 238, 238));
				cell17.setBorderWidth(0.01f);
				cell17.setBorderColor(BaseColor.WHITE);

				PdfPCell cell18 = new PdfPCell(new Paragraph(
						nameHelper.getCompanySectorName(resultSet
								.getInt("COMPANY_SECTOR_REF")), mainContent));
				cell18.setBorderWidth(0.2f);
				cell18.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell19 = new PdfPCell(new Paragraph("Lead Source ",
						mainContent));
				cell19.setBackgroundColor(new BaseColor(238, 238, 238));
				cell19.setBorderWidth(0.01f);
				cell19.setBorderColor(BaseColor.WHITE);

				PdfPCell cell20 = new PdfPCell(new Paragraph(
						nameHelper.getLeadTitle(resultSet
								.getInt("LEAD_SOURCE_REF")), mainContent));
				cell20.setBorderWidth(0.2f);
				cell20.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell21 = new PdfPCell(new Paragraph("Lead Name",
						mainContent));
				cell21.setBackgroundColor(new BaseColor(238, 238, 238));
				cell21.setBorderWidth(0.01f);
				cell21.setBorderColor(BaseColor.WHITE);

				PdfPCell cell22 = new PdfPCell(new Paragraph(
						resultSet.getString("LEAD_SOURCE_NAME"), mainContent));
				cell22.setBorderWidth(0.2f);
				cell22.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell23 = new PdfPCell(new Paragraph(
						"No. Of Associate", mainContent));
				cell23.setBackgroundColor(new BaseColor(238, 238, 238));
				cell23.setBorderWidth(0.01f);
				cell23.setBorderColor(BaseColor.WHITE);

				PdfPCell cell24 = new PdfPCell(
						new Paragraph(
								resultSet.getString("NUMBER_OF_ASSOCIATE"),
								mainContent));
				cell24.setBorderWidth(0.2f);
				cell24.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell25 = new PdfPCell(new Paragraph("Annual Reneue ",
						mainContent));
				cell25.setBackgroundColor(new BaseColor(238, 238, 238));
				cell25.setBorderWidth(0.01f);
				cell25.setBorderColor(BaseColor.WHITE);

				PdfPCell cell26 = new PdfPCell(new Paragraph(
						resultSet.getString("ANNUAL_REVENUE"), mainContent));
				cell26.setBorderWidth(0.2f);
				cell26.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell29 = new PdfPCell(new Paragraph("Lead Date ",
						mainContent));
				cell29.setBackgroundColor(new BaseColor(238, 238, 238));
				cell29.setBorderWidth(0.01f);
				cell29.setBorderColor(BaseColor.WHITE);

				PdfPCell cell30 = new PdfPCell(new Paragraph(
						resultSet.getString("LEAD_DATE"), mainContent));
				cell30.setBorderWidth(0.2f);
				cell30.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell31 = new PdfPCell(new Paragraph(
						"Expected Closing Date", mainContent));
				cell31.setBackgroundColor(new BaseColor(238, 238, 238));
				cell31.setBorderWidth(0.01f);
				cell31.setBorderColor(BaseColor.WHITE);

				PdfPCell cell32 = new PdfPCell(new Paragraph(
						resultSet.getString("EXPECTED_CLOSING_DATE"),
						mainContent));
				cell32.setBorderWidth(0.2f);
				cell32.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell33 = new PdfPCell(new Paragraph(
						"Contact Information", Font6));
				cell33.setBackgroundColor(new BaseColor(238, 238, 238));
				cell33.setBorderWidth(0.01f);
				cell33.setBorderColor(BaseColor.WHITE);

				PdfPCell cell34 = new PdfPCell(new Paragraph());
				cell34.setBackgroundColor(new BaseColor(238, 238, 238));
				cell34.setBorderWidth(0.2f);
				cell34.setBorderColor(BaseColor.WHITE);

				PdfPCell cell35 = new PdfPCell(new Paragraph("Adress Line 1",
						mainContent));
				cell35.setBackgroundColor(new BaseColor(238, 238, 238));
				cell35.setBorderWidth(0.01f);
				cell35.setBorderColor(BaseColor.WHITE);

				PdfPCell cell36 = new PdfPCell(new Paragraph(
						resultSet.getString("ADDRESS_LINE_1"), mainContent));
				cell36.setBorderWidth(0.2f);
				cell36.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell37 = new PdfPCell(new Paragraph("Adress Line 2",
						mainContent));
				cell37.setBackgroundColor(new BaseColor(238, 238, 238));
				cell37.setBorderWidth(0.01f);
				cell37.setBorderColor(BaseColor.WHITE);

				PdfPCell cell38 = new PdfPCell(new Paragraph(
						resultSet.getString("ADDRESS_LINE_2"), mainContent));
				cell38.setBorderWidth(0.2f);
				cell38.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell39 = new PdfPCell(new Paragraph("City ",
						mainContent));
				cell39.setBackgroundColor(new BaseColor(238, 238, 238));
				cell39.setBorderWidth(0.01f);
				cell39.setBorderColor(BaseColor.WHITE);

				PdfPCell cell40 = new PdfPCell(new Paragraph(
						resultSet.getString("CITY"), mainContent));
				cell40.setBorderWidth(0.2f);
				cell40.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell41 = new PdfPCell(new Paragraph("State",
						mainContent));
				cell41.setBackgroundColor(new BaseColor(238, 238, 238));
				cell41.setBorderWidth(0.01f);
				cell41.setBorderColor(BaseColor.WHITE);

				PdfPCell cell42 = new PdfPCell(new Paragraph(
						resultSet.getString("STATE"), mainContent));
				cell42.setBorderWidth(0.2f);
				cell42.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell43 = new PdfPCell(new Paragraph("Country",
						mainContent));
				cell43.setBackgroundColor(new BaseColor(238, 238, 238));
				cell43.setBorderWidth(0.01f);
				cell43.setBorderColor(BaseColor.WHITE);

				PdfPCell cell44 = new PdfPCell(new Paragraph(
						nameHelper.getCountryName(resultSet
								.getInt("COUNTRY_REF")), mainContent));
				cell44.setBorderWidth(0.2f);
				cell44.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell45 = new PdfPCell(new Paragraph("ZipCode ",
						mainContent));
				cell45.setBackgroundColor(new BaseColor(238, 238, 238));
				cell45.setBorderWidth(0.01f);
				cell45.setBorderColor(BaseColor.WHITE);

				PdfPCell cell46 = new PdfPCell(new Paragraph(
						resultSet.getString("ZIPCODE"), mainContent));
				cell46.setBorderWidth(0.2f);
				cell46.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell47 = new PdfPCell(new Paragraph("Phone No",
						mainContent));
				cell47.setBackgroundColor(new BaseColor(238, 238, 238));
				cell47.setBorderWidth(0.01f);
				cell47.setBorderColor(BaseColor.WHITE);

				PdfPCell cell48 = new PdfPCell(new Paragraph(
						resultSet.getString("PHONE_NO"), mainContent));
				cell48.setBorderWidth(0.2f);
				cell48.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell49 = new PdfPCell(new Paragraph("Mobile No",
						mainContent));
				cell49.setBackgroundColor(new BaseColor(238, 238, 238));
				cell49.setBorderWidth(0.01f);
				cell49.setBorderColor(BaseColor.WHITE);

				PdfPCell cell50 = new PdfPCell(new Paragraph(
						resultSet.getString("MOBILE_NO"), mainContent));
				cell50.setBorderWidth(0.2f);
				cell50.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell51 = new PdfPCell(new Paragraph(
						"Primary Email ID", mainContent));
				cell51.setBackgroundColor(new BaseColor(238, 238, 238));
				cell51.setBorderWidth(0.01f);
				cell51.setBorderColor(BaseColor.WHITE);

				PdfPCell cell52 = new PdfPCell(new Paragraph(
						resultSet.getString("PRIMARY_EMAIL_ID"), mainContent));
				cell52.setBorderWidth(0.2f);
				cell52.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell53 = new PdfPCell(new Paragraph(
						"Altrernate Email ID", mainContent));
				cell53.setBackgroundColor(new BaseColor(238, 238, 238));
				cell53.setBorderWidth(0.01f);
				cell53.setBorderColor(BaseColor.WHITE);

				PdfPCell cell54 = new PdfPCell(new Paragraph(
						resultSet.getString("ALTERNATIVE_EMAIL_ID"),
						mainContent));
				cell54.setBorderWidth(0.2f);
				cell54.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell55 = new PdfPCell(
						new Paragraph("Fax", mainContent));
				cell55.setBackgroundColor(new BaseColor(238, 238, 238));
				cell55.setBorderWidth(0.01f);
				cell55.setBorderColor(BaseColor.WHITE);

				PdfPCell cell56 = new PdfPCell(new Paragraph(
						resultSet.getString("FAX_NO"), mainContent));
				cell56.setBorderWidth(0.2f);
				cell56.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell57 = new PdfPCell(new Paragraph("WebSite",
						mainContent));
				cell57.setBackgroundColor(new BaseColor(238, 238, 238));
				cell57.setBorderWidth(0.01f);
				cell57.setBorderColor(BaseColor.WHITE);

				PdfPCell cell58 = new PdfPCell(new Paragraph(
						resultSet.getString("WEBSITE"), mainContent));
				cell58.setBorderWidth(0.2f);
				cell58.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell59 = new PdfPCell(new Paragraph("Requirment",
						Font6));
				cell59.setBackgroundColor(new BaseColor(238, 238, 238));
				cell59.setBorderWidth(0.01f);
				cell59.setBorderColor(BaseColor.WHITE);

				PdfPCell cell60 = new PdfPCell(new Paragraph());
				cell60.setBackgroundColor(new BaseColor(238, 238, 238));
				cell60.setBorderWidth(0.2f);
				cell60.setBorderColor(BaseColor.WHITE);

				PdfPCell cell61 = new PdfPCell(new Paragraph(
						"Requirment Details", mainContent));
				cell61.setBackgroundColor(new BaseColor(238, 238, 238));
				cell61.setBorderWidth(0.01f);
				cell61.setBorderColor(BaseColor.WHITE);
				String temp = resultSet.getString("REQUIRMENT");

				PdfPCell cell62 = new PdfPCell(new Paragraph(temp.replaceAll(
						"\\<.*?\\>", " "), mainContent));
				cell62.setBorderWidth(0.2f);
				cell62.setBorderColor(BaseColor.LIGHT_GRAY);

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
				table.addCell(cell58);
				table.addCell(cell59);
				table.addCell(cell60);
				table.addCell(cell61);
				table.addCell(cell62);

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

	/**
	 * <p>
	 * <code>insertLeadTitle(leadVO)</code> method use to insert lead title into
	 * TAB_LEAD_TITLE table.
	 * </p>
	 * 
	 * @param leadVO
	 * 
	 * @return null
	 */
	public void insertLeadTitle(LeadVO leadVO) {

		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.INSERT_LEAD_TITLE);
			preparedStatement.setString(1, leadVO.getLeadTitle());
			preparedStatement.executeUpdate();
		} catch (SQLException sqlExp) {
			sqlExp.printStackTrace();
			logger.error(
					LeadDaoImpl.class
							+ "Error: Occur in Query While Inserting Lead Title into Database.",
					sqlExp);
		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					LeadDaoImpl.class
							+ "Error: Occur in Query While Closing Connection After Inserting Lead Title into Database.",
					exception);
		} finally {
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
	}

	/**
	 * <p>
	 * <code>showTitles()</code> method use to fetch lead title into
	 * TAB_LEAD_TITLE table.
	 * </p>
	 * 
	 * @param leadVO
	 * 
	 * @return null
	 */
	public List<LeadTitleVO> showTitles() {
		ArrayList<LeadTitleVO> leadTitlesList = new ArrayList<LeadTitleVO>();

		try {

			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.SHOW_LIST_LEAD_TITLE);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				leadTitleVO = new LeadTitleVO();
				leadTitleVO.setLeadTitle(resultSet
						.getString("LEAD_TITLE_SUBJECT"));
				leadTitlesList.add(leadTitleVO);
			}
		} catch (SQLException sqlExp) {
			sqlExp.printStackTrace();
			logger.error(
					LeadDaoImpl.class
							+ "Error: Occur in Query While Fetching  Lead Title from Database.",
					sqlExp);
		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					LeadDaoImpl.class
							+ "Error: Occur in Query While Closing Connection After Fetching Lead Title from Database.",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return leadTitlesList;
	}

	/**
	 * <p>
	 * <code>getLeadDetails()</code> method use to fetch lead details from
	 * TAB_LEAD_TITLE table.
	 * </p>
	 * 
	 * @param leadId
	 *            int
	 * @return lead Lead
	 */
	@Override
	public Lead getLeadDetails(int leadId) throws Exception {
		lead = new Lead();
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.SHOW_VIEW_LEAD);
			preparedStatement.setInt(1, leadId);
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {
					lead.setLeadId(resultSet.getInt("LEAD_ID"));
					lead.setLeadOwner(nameHelper.getCustomerName(resultSet
							.getInt("LEAD_OWNER_REF")));
					lead.setCreatedDate(DateTimeUtil
							.convertDatetoFormDateForView(resultSet
									.getString("CREATED_DATE")));
					lead.setCompanyName(resultSet.getString("COMPANY_NAME"));

					lead.setFullName(AppendHelper.appendSalutaion(
							resultSet.getInt("SALUTATION"),
							resultSet.getString("CONTACT_PERSON")));

					lead.setLeadTitle(nameHelper.getLeadTitle(resultSet
							.getInt("LEAD_TITLE_REF")));
					lead.setCompanyType(nameHelper.getCompanyTypeName(resultSet
							.getInt("COMPANY_TYPE_REF")));

					lead.setCompanyCategory(nameHelper
							.getCompanyCategoryName(resultSet
									.getInt("COMPANY_CATEGORY_REF")));

					lead.setCompanySector(nameHelper
							.getCompanySectorName(resultSet
									.getInt("COMPANY_SECTOR_REF")));
					lead.setLeadSource(nameHelper.getLeadSourceName(resultSet
							.getInt("LEAD_SOURCE_REF")));
					lead.setLeadSourceStatus(LeadStatus.getLeadStatus(resultSet
							.getInt("LEAD_STATUS")));
					lead.setLeadSourceName(resultSet
							.getString("LEAD_SOURCE_NAME"));
					lead.setNoOfAssociate(resultSet
							.getString("NUMBER_OF_ASSOCIATE"));
					lead.setAnnualRevenue(resultSet.getString("ANNUAL_REVENUE"));
					lead.setLeadDate(resultSet.getString("LEAD_DATE"));
					lead.setExpectedClosingDate(resultSet
							.getString("EXPECTED_CLOSING_DATE"));
					lead.setRatings(Ratings.getRatingName(resultSet
							.getInt("RATING")));

					lead.setEmailOptOut(resultSet.getString("EMAIL_OPT_OUT")
							.toUpperCase());
					lead.setAddressLine1(resultSet.getString("ADDRESS_LINE_1"));
					lead.setAddressLine2(resultSet.getString("ADDRESS_LINE_2"));
					lead.setCity(resultSet.getString("CITY"));
					lead.setState(resultSet.getString("STATE"));
					lead.setCountry(nameHelper.getCountryName(resultSet
							.getInt("COUNTRY_REF")));
					lead.setZipcode(resultSet.getString("ZIPCODE"));

					lead.setPhoneNo(AppendHelper.appendNumber(
							resultSet.getString("PHONE_ISD"),
							resultSet.getString("PHONE_STD"),
							resultSet.getString("PHONE_NO")));

					lead.setMobileNo(AppendHelper.appendNumber(
							resultSet.getString("MOBILE_ISD"),
							resultSet.getString("MOBILE_NO")));

					lead.setPrimaryEmailId(resultSet
							.getString("PRIMARY_EMAIL_ID"));

					lead.setAlternateEmailId(resultSet
							.getString("ALTERNATIVE_EMAIL_ID"));

					lead.setFax(AppendHelper.appendNumber(
							resultSet.getString("FAX_ISD"),
							resultSet.getString("FAX_STD"),
							resultSet.getString("FAX_NO")));

					lead.setWebsite(resultSet.getString("WEBSITE"));
					lead.setRequirment(resultSet.getString("REQUIRMENT").trim());

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
		return lead;
	}

	/**
	 * <p>
	 * <code>getLeadFollowUpDetails()</code> method use to fetch lead follow up
	 * details from TAB_LEAD_FOLLOWUP table.
	 * </p>
	 * 
	 * @return leadFollowUpDetails
	 */
	@Override
	public List<LeadVO> getLeadFollowUpDetails(int leadId) throws Exception {
		ArrayList<LeadVO> leadFollowUpDetails = new ArrayList<LeadVO>();

		try {

			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_LEAD_FOLLOWUP_DETAILS);
			preparedStatement.setInt(1, leadId);
			resultSet = preparedStatement.executeQuery();

			// FOLLOWUP_ID,FOLLOWUP_DATE,FOLLOWUP_STATUS,REF_FOLLOWUP_BY,CREATED_BY,COMMENT
			while (resultSet.next()) {
				leadVO = new LeadVO();
				leadVO.setFollowUpId(resultSet.getInt("FOLLOWUP_ID"));
				leadVO.setFollowUpDate(DateTimeUtil
						.convertDatetoFormDateForView(resultSet
								.getString("FOLLOWUP_DATE")));
				leadVO.setFollowUpStatus(LeadStatus.getLeadStatus(resultSet
						.getInt("FOLLOWUP_STATUS")));
				NameHelper nameHelper = new NameHelper();
				leadVO.setFollowUpBy(nameHelper.getCustomerName(resultSet
						.getInt("REF_FOLLOWUP_BY")));
				leadVO.setCreatedByName(nameHelper.getCustomerName(resultSet
						.getInt("CREATED_BY")));
				leadVO.setFollowUpComment(resultSet.getString("COMMENT").trim());
				leadFollowUpDetails.add(leadVO);
			}

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					LeadDaoImpl.class
							+ ": Error:- Error: Occur in Query While fetching the lead followup details from Database",
					sqlException);

		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					LeadDaoImpl.class
							+ ": Error:- While closing the Connection after fetching the lead followup details for view from Database",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return leadFollowUpDetails;
	}

	/**
	 * <p>
	 * <code>insertLeadFollowUp()</code> method use to insert lead follow up
	 * details from TAB_LEAD_FOLLOWUP table.
	 * </p>
	 * 
	 * @param leadVO
	 * @throws Exception
	 * 
	 */
	@Override
	public int insertLeadFollowUp(LeadVO leadVO) throws Exception {

		int target = 0;
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.INSERT_LEAD_FOLLOWUP);
			preparedStatement.setString(1,
					DateTimeUtil.convertToDate(leadVO.getFollowUpDate()));
			preparedStatement.setString(2, leadVO.getFollowUpBy());
			preparedStatement.setString(3, leadVO.getFollowUpStatus());
			preparedStatement.setString(4, leadVO.getFollowUpComment().trim());
			preparedStatement.setInt(5, leadVO.getCreatedBy());
			preparedStatement.setString(6, DateTimeUtil.getCurrentDate());
			preparedStatement.setInt(7, leadVO.getLeadId());
			preparedStatement.executeUpdate();
			target = 1;

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					LeadDaoImpl.class
							+ ": Error:- Error: Occur in Query While inserting the Lead details into Database",
					sqlException);

		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					LeadDaoImpl.class
							+ ": Error:- While closing the Connection after getting the Lead details into Database",
					exception);
		} finally {
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return target;
	}

	/**
	 * <p>
	 * <code>insertLeadSocialInformation()</code> method use to insert lead
	 * social information details into TAB_SOCIAL_CONTACT table.
	 * </p>
	 * 
	 * @param leadVO
	 * @throws Exception
	 * @return target
	 */
	@Override
	public int insertLeadSocialInformation(LeadVO leadVO) throws Exception {

		int target = 0;
		connection = getConnection();
		try {
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_SOCIAL_INFO);
			preparedStatement.setInt(1, leadVO.getSocialSiteRef());
			preparedStatement.setInt(2, Modules.LEAD_ID);
			preparedStatement.setInt(3, leadVO.getLeadId());
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				leadVO.setSocialContactId(resultSet.getInt("SOCIAL_CONTACT_ID"));
				preparedStatement = connection
						.prepareStatement(QueryMaker.UPDATE_SOCIAL_INFORMATION);
				preparedStatement.setInt(1, leadVO.getSocialSiteRef());
				preparedStatement.setString(2, leadVO.getSocialContactValue());
				preparedStatement.setInt(3, Modules.LEAD_ID);
				preparedStatement.setInt(4, leadVO.getLeadId());
				preparedStatement.setInt(5, leadVO.getSocialContactId());
				preparedStatement.executeUpdate();
				target = 2;

			} else {
				preparedStatement = connection
						.prepareStatement(QueryMaker.INSERT_SOCIAL_INFORMATION);
				preparedStatement.setInt(1, leadVO.getSocialSiteRef());
				preparedStatement.setString(2, leadVO.getSocialContactValue());
				preparedStatement.setInt(3, Modules.LEAD_ID);
				preparedStatement.setInt(4, leadVO.getLeadId());
				preparedStatement.executeUpdate();
				target = 1;

			}

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					LeadDaoImpl.class
							+ ": Error:- Error: Occur in Query While inserting the lead social details into Database",
					sqlException);

		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					LeadDaoImpl.class
							+ ": Error:- While closing the Connection after inserting the lead social details into Database",
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
	 * <code>updateLeadInfo()</code> method use to update lead information
	 * details into TAB_LEAD_DETAILS table.
	 * </p>
	 * 
	 * @param leadId
	 * @throws Exception
	 * @return target
	 */
	/*
	 * @Override public int updateLeadInfo(LeadVO leadVO, int leadId) throws
	 * Exception {
	 * 
	 * int target = 0;
	 * 
	 * leadVO.setLeadId(leadId); try { connection = getConnection();
	 * preparedStatement = connection
	 * .prepareStatement(QueryMaker.UPDATE_LEAD_INFORMATION);
	 * preparedStatement.setString(1, leadVO.getCompanyName());
	 * preparedStatement.setString(2, leadVO.getSalutation());
	 * preparedStatement.setString(3, leadVO.getContactPerson());
	 * preparedStatement.setString(4, leadVO.getLeadTitle());
	 * preparedStatement.setString(5, leadVO.getCompanyType());
	 * preparedStatement.setString(6, leadVO.getCompanyCategory());
	 * preparedStatement.setString(7, leadVO.getCompanySector());
	 * preparedStatement.setString(8, leadVO.getLeadSource());
	 * preparedStatement.setString(9, leadVO.getLeadSourceName());
	 * preparedStatement.setString(10, leadVO.getNoOfAssociate());
	 * preparedStatement.setString(11, leadVO.getAnnualRevenue());
	 * preparedStatement.setString(12,
	 * DateTimeUtil.convertToDate(leadVO.getLeadDate())); preparedStatement
	 * .setString(13, DateTimeUtil.convertToDate(leadVO
	 * .getExpectedClosingDate())); preparedStatement.setString(14,
	 * leadVO.getRequirment().trim()); preparedStatement.setString(15,
	 * leadVO.getRatings()); preparedStatement.setString(16,
	 * leadVO.getEmailOptOut()); preparedStatement.setInt(17,
	 * leadVO.getLeadStatus()); preparedStatement.setInt(18,
	 * leadVO.getLeadId()); preparedStatement.executeUpdate(); target = 1;
	 * 
	 * } catch (SQLException sqlException) { sqlException.printStackTrace();
	 * logger.error( LeadDaoImpl.class +
	 * ": Error:- Error: Occur in Query While updating the lead details into Database"
	 * , sqlException);
	 * 
	 * } catch (Exception exception) { exception.printStackTrace();
	 * logger.error( LeadDaoImpl.class +
	 * ": Error:- While closing the Connection after updating the lead social details into Database"
	 * , exception); } finally {
	 * JdbcHelper.closePreparedStatement(preparedStatement);
	 * JdbcHelper.closeConnection(connection); } return target; }
	 *//**
	 * <p>
	 * <code>updateLeadContactInformation()</code> method use to update lead
	 * contact information into TAB_LEAD_DETAILS table.
	 * </p>
	 * 
	 * @param leadId
	 *            int
	 * @param leadVO
	 *            LeadVO
	 * @throws Exception
	 */
	/*
	 * @Override public int updateLeadContactInformation(LeadVO leadVO, int
	 * leadId) throws Exception { int target = 0;
	 * 
	 * leadVO.setLeadId(leadId); try { connection = getConnection();
	 * preparedStatement = connection
	 * .prepareStatement(QueryMaker.UPDATE_LEAD_CONTACT_INFORMATION);
	 * preparedStatement.setString(1, leadVO.getAddressLine1());
	 * preparedStatement.setString(2, leadVO.getAddressLine2());
	 * preparedStatement.setString(3, leadVO.getCity());
	 * preparedStatement.setString(4, leadVO.getState());
	 * preparedStatement.setString(5, leadVO.getCountry());
	 * preparedStatement.setString(6, leadVO.getZipcode());
	 * preparedStatement.setString(7, leadVO.getPhoneNo());
	 * preparedStatement.setString(8, leadVO.getMobileNo());
	 * preparedStatement.setString(9, leadVO.getPrimaryEmailId());
	 * preparedStatement.setString(10, leadVO.getAlternateEmailId());
	 * preparedStatement.setString(11, leadVO.getFax());
	 * preparedStatement.setString(12, leadVO.getFaxIsd());
	 * preparedStatement.setString(13, leadVO.getFaxStd());
	 * preparedStatement.setString(14, leadVO.getPhoneIsd());
	 * preparedStatement.setString(15, leadVO.getPhoneStd());
	 * preparedStatement.setString(16, leadVO.getMobileIsd());
	 * preparedStatement.setInt(17, leadVO.getLeadId());
	 * preparedStatement.executeUpdate(); target = 1;
	 * 
	 * } catch (SQLException sqlException) { sqlException.printStackTrace();
	 * logger.error( LeadDaoImpl.class +
	 * ": Error:- Error: Occur in Query While updating the lead contact details from Database"
	 * , sqlException);
	 * 
	 * } catch (Exception exception) { exception.printStackTrace();
	 * logger.error( LeadDaoImpl.class +
	 * ": Error:- While closing the Connection after updating the lead contact details from Database"
	 * , exception); } finally { JdbcHelper.closeResultSet(resultSet);
	 * JdbcHelper.closePreparedStatement(preparedStatement);
	 * JdbcHelper.closeConnection(connection); } return target; }
	 */

	/**
	 * <p>
	 * <code>isLeadTitleExist(String)</code> method help to verify the existing
	 * lead title available in the database. if entered lead title already
	 * available into the database then this method will return 1 else 0;
	 * </p>
	 * 
	 * @param leadTitle
	 *            String
	 * @return
	 * @throws Exception
	 * 
	 */
	@Override
	public int isLeadTitleExist(String leadTitle) throws Exception {

		String existLeadTitle = null;
		try {

			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_LEAD_TITLE);
			preparedStatement.setString(1, leadTitle);

			resultSet = preparedStatement.executeQuery();

			if (resultSet != null) {
				while (resultSet.next()) {
					existLeadTitle = resultSet.getString("LEAD_TITLE_SUBJECT");

					if (existLeadTitle.equalsIgnoreCase(leadTitle)) {
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
	 * <code>updateLeadStatus(String)</code> method is design to update lead
	 * status
	 * </p>
	 * 
	 * @param leadTitle
	 *            String
	 * @return
	 * @throws Exception
	 * 
	 */
	@Override
	public int updateLeadStatus(LeadVO leadVO, int leadId) throws Exception {

		int target = 0;

		leadVO.setLeadId(leadId);
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.UPDATE_LEAD_STATUS);
			preparedStatement.setString(1, leadVO.getFollowUpStatus());
			preparedStatement.setInt(2, leadVO.getLeadId());
			preparedStatement.executeUpdate();
			target = 1;

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					LeadDaoImpl.class
							+ ": Error:- Error: Occur in Query While updating the lead status into Database",
					sqlException);

		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					LeadDaoImpl.class
							+ ": Error:- While closing the Connection after updating the lead status into Database",
					exception);
		} finally {
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return target;
	}

	/**
	 * <p>
	 * <code>getLeadSocialDetailsList()</code> method use to fetch lead social
	 * details from TAB_SOCIAL_CONTACT table.
	 * </p>
	 * 
	 * @return leadIdList
	 */
	@Override
	public List<LeadVO> getLeadSocialDetailsList(int leadId) throws Exception {
		ArrayList<LeadVO> leadSocialDetails = new ArrayList<LeadVO>();
		try {

			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_LEAD_SOCIAL_DETAILS);
			preparedStatement.setInt(1, Modules.LEAD_ID);
			System.out.println("lead id" + leadId);
			preparedStatement.setInt(2, leadId);
			// SOCIAL_SITE_REF,SOCIAL_CONTACT_VALUE
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				leadVO = new LeadVO();
				leadVO.setSocialSiteRefName(nameHelper.getSocialSite(resultSet
						.getInt("SOCIAL_SITE_REF")));
				leadVO.setSocialContactValue(resultSet
						.getString("SOCIAL_CONTACT_VALUE"));
				leadSocialDetails.add(leadVO);
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
		return leadSocialDetails;
	}

	/**
	 * <p>
	 * <code>getCompanyNameListOfLead()</code> method use to fetch company name
	 * from TAB_LEAD_DETAILS table.
	 * </p>
	 * 
	 * @return leadFollowUpDetails
	 */
	@Override
	public HashMap<String, String> getCompanyNameListOfLead() throws Exception {
		HashMap<String, String> companyList = new HashMap<String, String>();
		try {

			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_LEAD_COMPANY_NAME);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				companyList.put(resultSet.getString("COMPANY_NAME"),
						resultSet.getString("COMPANY_NAME"));
			}

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					LeadDaoImpl.class
							+ ": Error:- Error: Occur in Query While fetching lead compnay name list from Database",
					sqlException);

		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					LeadDaoImpl.class
							+ ": Error:- While closing the Connection after fetching the lead company name list from Database",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return companyList;

	}

	/**
	 * <p>
	 * <code>getLeadDetails()</code> method use to fetch lead details from
	 * TAB_LEAD_TITLE table.
	 * </p>
	 * 
	 * @param leadId
	 *            int
	 * @return lead Lead
	 */
	@Override
	public Lead getLeadDetailsForUpdate(int leadId) throws Exception {
		lead = new Lead();
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.SHOW_VIEW_LEAD);
			preparedStatement.setInt(1, leadId);
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {
					lead.setLeadId(resultSet.getInt("LEAD_ID"));
					lead.setLeadOwner(nameHelper.getCustomerName(resultSet
							.getInt("LEAD_OWNER_REF")));
					lead.setCreatedDate(DateTimeUtil
							.convertDatetoFormDate(resultSet
									.getString("CREATED_DATE")));
					lead.setCompanyName(resultSet.getString("COMPANY_NAME"));
					lead.setSalutation(resultSet.getString("SALUTATION"));
					lead.setContactPerson(resultSet.getString("CONTACT_PERSON"));
					lead.setLeadTitle(nameHelper.getLeadTitle(resultSet
							.getInt("LEAD_TITLE_REF")));
					lead.setCompanyType(resultSet.getString("COMPANY_TYPE_REF"));
					lead.setCompanyCategory(resultSet
							.getString("COMPANY_CATEGORY_REF"));
					lead.setCompanySector(resultSet
							.getString("COMPANY_SECTOR_REF"));
					lead.setLeadSource(resultSet.getString("LEAD_SOURCE_REF"));
					lead.setLeadStatus(resultSet.getInt("LEAD_STATUS"));
					lead.setLeadSourceName(resultSet
							.getString("LEAD_SOURCE_NAME"));
					lead.setNoOfAssociate(resultSet
							.getString("NUMBER_OF_ASSOCIATE"));
					System.out.println("number of associates "
							+ resultSet.getString("NUMBER_OF_ASSOCIATE"));
					lead.setAnnualRevenue(resultSet.getString("ANNUAL_REVENUE"));
					lead.setLeadDate(DateTimeUtil
							.convertDatetoFormDate(resultSet
									.getString("LEAD_DATE")));
					lead.setExpectedClosingDate(DateTimeUtil
							.convertDatetoFormDate(resultSet
									.getString("EXPECTED_CLOSING_DATE")));
					lead.setRatings(Ratings.getRatingName(resultSet
							.getInt("RATING")));
					lead.setEmailOptOut(resultSet.getString("EMAIL_OPT_OUT"));
					lead.setAddressLine1(resultSet.getString("ADDRESS_LINE_1"));
					lead.setAddressLine2(resultSet.getString("ADDRESS_LINE_2"));
					lead.setCity(resultSet.getString("CITY"));
					lead.setState(resultSet.getString("STATE"));
					lead.setCountry(resultSet.getString("COUNTRY_REF"));
					lead.setZipcode(resultSet.getString("ZIPCODE"));
					lead.setPhoneNo(resultSet.getString("PHONE_NO"));
					lead.setPhoneIsd(resultSet.getString("PHONE_ISD"));
					lead.setPhoneStd(resultSet.getString("PHONE_STD"));
					lead.setMobileNo(resultSet.getString("MOBILE_NO"));
					lead.setMobileIsd(resultSet.getString("MOBILE_ISD"));
					lead.setPrimaryEmailId(resultSet
							.getString("PRIMARY_EMAIL_ID"));
					lead.setAlternateEmailId(resultSet
							.getString("ALTERNATIVE_EMAIL_ID"));
					lead.setFax(resultSet.getString("FAX_NO"));
					lead.setFaxIsd(resultSet.getString("FAX_ISD"));
					lead.setFaxStd(resultSet.getString("FAX_STD"));
					lead.setWebsite(resultSet.getString("WEBSITE"));
					lead.setRequirment(resultSet.getString("REQUIRMENT").trim());
					lead.setCreatedByName(nameHelper.getCustomerName(resultSet
							.getInt("CREATED_BY")));
					System.out.println("created by      "
							+ resultSet.getInt("CREATED_BY"));

					System.out.println("customer name  "
							+ nameHelper.getCustomerName(resultSet
									.getInt("CREATED_BY")));

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
		return lead;
	}

	@Override
	public int getLeadLastRecord() throws Exception {

		int temp = 0;
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_LAST_RECORD_ID);
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {

					temp = resultSet.getInt("LEAD_ID");

				}
			}
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					LeadDaoImpl.class
							+ ": Error:- Error: Occur in Query While counting the Lead recodes from Database",
					sqlException);

		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					LeadDaoImpl.class
							+ ": Error:- While closing the Connection after counting the Lead recodes from Database",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return temp;
	}

	@Override
	public int getLeadFirstRecord() throws Exception {

		int temp = 0;
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_FIRST_RECORD_ID);
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {

					temp = resultSet.getInt("LEAD_ID");

				}
			}
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					LeadDaoImpl.class
							+ ": Error:- Error: Occur in Query While counting the Lead recodes from Database",
					sqlException);

		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					LeadDaoImpl.class
							+ ": Error:- While closing the Connection after counting the Lead recodes from Database",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return temp;
	}

	@Override
	public int updateLeadInfo(LeadVO leadVO, int leadId) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateLeadContactInformation(LeadVO leadVO, int leadId)
			throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Lead> fetchDefectRaiseDetails() throws OMIApplicationException {

		List<Lead> leadDetailsList = new ArrayList<Lead>();

		try {

			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_ALL_LEAD_DETAILS);
			resultSet = preparedStatement.executeQuery();
			/* if (resultSet.next()) { */

			// LEAD_ID,COMPANY_NAME,LEAD_TITLE_REF,CONTACT_PERSON,LEAD_OWNER_REF,LEAD_DATE,EXPECTED_CLOSING_DATE,LEAD_STATUS,CREATED_BY

			if (resultSet != null) {

				while (resultSet.next()) {
					lead=new Lead();
					lead.setLeadId(resultSet.getInt("LEAD_ID"));
					
					lead.setLeadOwner(nameHelper.getCustomerName(resultSet
							.getInt("LEAD_OWNER_REF")));
					lead.setCreatedDate(DateTimeUtil
							.convertDatetoFormDateForView(resultSet
									.getString("CREATED_DATE")));
					lead.setCompanyName(resultSet.getString("COMPANY_NAME"));

					lead.setFullName(AppendHelper.appendSalutaion(
							resultSet.getInt("SALUTATION"),
							resultSet.getString("CONTACT_PERSON")));

					lead.setLeadTitle(nameHelper.getLeadTitle(resultSet
							.getInt("LEAD_TITLE_REF")));
					lead.setCompanyType(nameHelper.getCompanyTypeName(resultSet
							.getInt("COMPANY_TYPE_REF")));

					lead.setCompanyCategory(nameHelper
							.getCompanyCategoryName(resultSet
									.getInt("COMPANY_CATEGORY_REF")));

					lead.setCompanySector(nameHelper
							.getCompanySectorName(resultSet
									.getInt("COMPANY_SECTOR_REF")));
					lead.setLeadSource(nameHelper.getLeadSourceName(resultSet
							.getInt("LEAD_SOURCE_REF")));
					lead.setLeadSourceStatus(LeadStatus.getLeadStatus(resultSet
							.getInt("LEAD_STATUS")));
					lead.setLeadSourceName(resultSet
							.getString("LEAD_SOURCE_NAME"));
					lead.setNoOfAssociate(resultSet
							.getString("NUMBER_OF_ASSOCIATE"));
					lead.setAnnualRevenue(resultSet.getString("ANNUAL_REVENUE"));
					lead.setLeadDate(resultSet.getString("LEAD_DATE"));
					lead.setExpectedClosingDate(resultSet
							.getString("EXPECTED_CLOSING_DATE"));
					lead.setRatings(Ratings.getRatingName(resultSet
							.getInt("RATING")));

					lead.setEmailOptOut(resultSet.getString("EMAIL_OPT_OUT")
							.toUpperCase());
					lead.setAddressLine1(resultSet.getString("ADDRESS_LINE_1"));
					lead.setAddressLine2(resultSet.getString("ADDRESS_LINE_2"));
					lead.setCity(resultSet.getString("CITY"));
					lead.setState(resultSet.getString("STATE"));
					lead.setCountry(nameHelper.getCountryName(resultSet
							.getInt("COUNTRY_REF")));
					lead.setZipcode(resultSet.getString("ZIPCODE"));

					lead.setPhoneNo(AppendHelper.appendNumber(
							resultSet.getString("PHONE_ISD"),
							resultSet.getString("PHONE_STD"),
							resultSet.getString("PHONE_NO")));

					lead.setMobileNo(AppendHelper.appendNumber(
							resultSet.getString("MOBILE_ISD"),
							resultSet.getString("MOBILE_NO")));

					lead.setPrimaryEmailId(resultSet
							.getString("PRIMARY_EMAIL_ID"));

					lead.setAlternateEmailId(resultSet
							.getString("ALTERNATIVE_EMAIL_ID"));

					lead.setFax(AppendHelper.appendNumber(
							resultSet.getString("FAX_ISD"),
							resultSet.getString("FAX_STD"),
							resultSet.getString("FAX_NO")));

					lead.setWebsite(resultSet.getString("WEBSITE"));
					lead.setRequirment(resultSet.getString("REQUIRMENT").trim());
					leadDetailsList.add(lead);
				}

				
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
		return leadDetailsList;
	}
}
