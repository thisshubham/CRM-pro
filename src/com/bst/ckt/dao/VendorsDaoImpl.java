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
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.bst.ckt.common.LoginUtil;
import com.bst.ckt.common.QueryBuilder;
import com.bst.ckt.common.QueryMaker;
import com.bst.ckt.dto.VendorDTO;
import com.bst.ckt.exception.OMIApplicationException;
import com.bst.ckt.framework.db.JdbcDAOSupport;
import com.bst.ckt.framework.db.JdbcHelper;
import com.bst.ckt.framework.util.DateTimeUtil;
import com.bst.ckt.helper.AppendHelper;
import com.bst.ckt.helper.NameHelper;
import com.bst.ckt.helper.Salutation;
import com.bst.ckt.helper.VendorStatus;
import com.bst.ckt.vo.VendorsVO;
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
public class VendorsDaoImpl extends JdbcDAOSupport implements VendorsDaoInf {

	/**
	 * Creating Logger object, logger object mapped with VendorsDaoImpl class
	 * for writing Loggers.
	 */
	public static final Logger logger = Logger.getLogger(VendorsDaoImpl.class);

	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	VendorsVO vendorsVO = null;
	Image image = null;
	NameHelper nameHelper = new NameHelper();

	/**
	 * <p>
	 * <code>insertVendorsDetail(VendorsVO vendorsVO)</code> method use to
	 * insert campaign details into TAB_CAMPAIGN table.
	 * </p>
	 * 
	 * @param VendorsVO
	 *            vendorsVO
	 * @return target
	 * @throws Exception
	 */
	public int insertVendorsDetail(VendorsVO vendorsVO) throws Exception {
		String AddCampaignDetailsQuery = QueryMaker.ADD_VENDORS_DETAIL;
		int target = 0;
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(AddCampaignDetailsQuery);
			preparedStatement.setString(1, vendorsVO.getVendorsName());
			preparedStatement.setString(2, vendorsVO.getSalutation());
			preparedStatement.setString(3, vendorsVO.getgLAccounts());
			preparedStatement.setString(4, vendorsVO.getVendorsCategory());
			preparedStatement.setString(5, vendorsVO.getAssignedTo());
			preparedStatement.setString(6, vendorsVO.getVendorsStatus());
			preparedStatement.setString(7, vendorsVO.getVendorsFlag());
			preparedStatement.setString(8, vendorsVO.getAddressLine1());
			preparedStatement.setString(9, vendorsVO.getAddressLine2());
			preparedStatement.setString(10, vendorsVO.getCity());
			preparedStatement.setString(11, vendorsVO.getState());
			preparedStatement.setString(12, vendorsVO.getCountry());
			preparedStatement.setString(13, vendorsVO.getZipCode());
			preparedStatement.setString(14, vendorsVO.getPhoneIsd());
			preparedStatement.setString(15, vendorsVO.getPhoneStd());
			preparedStatement.setString(16, vendorsVO.getPhoneNo());
			preparedStatement.setString(17, vendorsVO.getMobileIsd());
			preparedStatement.setString(18, vendorsVO.getMobileNo());
			preparedStatement.setString(19, vendorsVO.getPrimaryEmailId());
			preparedStatement.setString(20, vendorsVO.getAlternateEmailId());
			preparedStatement.setString(21, vendorsVO.getFaxIsd());
			preparedStatement.setString(22, vendorsVO.getFaxStd());
			preparedStatement.setString(23, vendorsVO.getFax());
			preparedStatement.setString(24, vendorsVO.getWebSite());
			preparedStatement.setString(25, vendorsVO.getDescription());
			preparedStatement.setInt(26, LoginUtil.getCurrentCustomerUser()
					.getCustomerId());
			preparedStatement.setString(27, DateTimeUtil.getDateAndTime());
			preparedStatement.executeUpdate();
			target = 1;
		} catch (SQLException sqlException) {

			logger.error(
					VendorsDaoImpl.class
							+ "Error: Occur in Query While Inserting the Vendors Details into Database.",
					sqlException);

		} catch (Exception exception) {

			logger.error(
					VendorsDaoImpl.class
							+ "Error: Occur While Closing Connection After Inserting the Vendors Details into Database.",
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
	public List<VendorsVO> getVendorsDetailsList() throws Exception {
		String query = QueryMaker.GET_VENDORS_DETAILS_LIST;
		ArrayList<VendorsVO> vendorsDetailsList = new ArrayList<VendorsVO>();
		nameHelper = new NameHelper();
		VendorsVO vendorsVO = null;
		StringBuffer stringBuffer = null;
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				vendorsVO = new VendorsVO();
				stringBuffer = new StringBuffer();
				vendorsVO.setVendorsId(resultSet.getInt("VENDOR_ID"));
				stringBuffer
						.append(Salutation.getSalutation(resultSet
								.getInt("SALUTATION"))).append(" ")
						.append(resultSet.getString("VENDOR_NAME"));
				vendorsVO.setFullName(stringBuffer.toString());
				vendorsVO.setPhoneNo(AppendHelper.appendNumber(
						resultSet.getString("PHONE_ISD"),
						resultSet.getString("PHONE_STD"),
						resultSet.getString("PHONE_NO")));
				vendorsVO.setPrimaryEmailId(resultSet
						.getString("PRIMARY_EMAIL_ID"));
				vendorsVO.setVendorsCategory(nameHelper
						.getVendorCategory(resultSet
								.getInt("REF_VENDOR_CATEGORY")));
				vendorsVO.setAssignedTo(nameHelper
						.getCampaignAssignedToName(resultSet
								.getInt("REF_ASSIGNED_TO")));
				vendorsVO.setVendorsStatus(VendorStatus.getUserStatus(resultSet
						.getInt("VENDOR_STATUS")));
				vendorsDetailsList.add(vendorsVO);
			}

		} catch (SQLException sqlException) {

			logger.error(
					UserManagementDaoImpl.class
							+ "Error: Occur in Query While fetching the Campaign Details into Database.",
					sqlException);

		} catch (Exception exception) {

			logger.error(
					UserManagementDaoImpl.class
							+ "Error: Occur While Closing Connection After etching the Campaign Details into Database.",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return vendorsDetailsList;
	}

	@Override
	public VendorsVO retriveVendorsInfo(VendorsVO vendorsVO, int vendorsId)
			throws Exception {

		return null;
	}

	@Override
	public void deleteVendorsDetails(int vendorsId) throws Exception {
		String query = QueryMaker.DELETE_VENDORS_DETAIL;
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, vendorsId);
			preparedStatement.executeUpdate();
		} catch (SQLException sqlException) {

			logger.error(
					VendorsDaoImpl.class
							+ "Error: Occur in Query While Updating the VendorsDaoImpl Details into Database.",
					sqlException);

		} catch (Exception exception) {

			logger.error(
					VendorsDaoImpl.class
							+ "Error: Occur While Closing Connection After Updating the VendorsDaoImpl Details into Database.",
					exception);
		} finally {
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}

	}

	@Override
	public int updateVendorsDetails(VendorsVO vendorsVO, int vendorsId)
			throws OMIApplicationException {
		int target = 0;
		String query = QueryMaker.UPDATE_VENDORS_DETAILS;
		try {
			connection = getConnection();

			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setString(1, vendorsVO.getVendorsName());
			preparedStatement.setString(2, vendorsVO.getSalutation());
			preparedStatement.setString(3, vendorsVO.getgLAccounts());
			preparedStatement.setString(4, vendorsVO.getVendorsCategory());
			preparedStatement.setString(5, vendorsVO.getAssignedTo());
			preparedStatement.setString(6, vendorsVO.getVendorsStatus());
			preparedStatement.setString(7, vendorsVO.getVendorsFlag());
			preparedStatement.setString(8, vendorsVO.getAddressLine1());
			preparedStatement.setString(9, vendorsVO.getAddressLine2());
			preparedStatement.setString(10, vendorsVO.getCity());
			preparedStatement.setString(11, vendorsVO.getState());
			preparedStatement.setString(12, vendorsVO.getCountry());
			preparedStatement.setString(13, vendorsVO.getZipCode());
			preparedStatement.setString(14, vendorsVO.getPhoneIsd());
			preparedStatement.setString(15, vendorsVO.getPhoneStd());
			preparedStatement.setString(16, vendorsVO.getPhoneNo());
			preparedStatement.setString(17, vendorsVO.getMobileIsd());
			preparedStatement.setString(18, vendorsVO.getMobileNo());
			preparedStatement.setString(19, vendorsVO.getPrimaryEmailId());
			preparedStatement.setString(20, vendorsVO.getAlternateEmailId());
			preparedStatement.setString(21, vendorsVO.getFaxIsd());
			preparedStatement.setString(22, vendorsVO.getFaxStd());
			preparedStatement.setString(23, vendorsVO.getFax());
			preparedStatement.setString(24, vendorsVO.getWebSite());
			preparedStatement.setString(25, vendorsVO.getDescription());
			preparedStatement.setInt(26, LoginUtil.getCurrentCustomerUser()
					.getCustomerId());
			preparedStatement.setString(27, DateTimeUtil.getDateAndTime());
			preparedStatement.setInt(28, vendorsId);
			System.out.println(vendorsId);

			preparedStatement.executeUpdate();
			target = 1;
		} catch (SQLException sqlException) {

			logger.error(
					VendorsDaoImpl.class
							+ "Error: Occur in Query While Updating the VendorsDaoImpl Details into Database.",
					sqlException);

		} catch (Exception exception) {

			logger.error(
					VendorsDaoImpl.class
							+ "Error: Occur While Closing Connection After Updating the VendorsDaoImpl Details into Database.",
					exception);
		} finally {
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return target;
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
	public void VendorsPDF(HttpServletRequest request,
			HttpServletResponse response, int vendorsId)
			throws OMIApplicationException {
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
					.prepareStatement(QueryMaker.SHOW_VENDOR_PRINT_PDF);
			preparedStatement.setInt(1, vendorsId);
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
					.getRealPath("/outer/img/vanra_logo.png");
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

			PdfPCell cell104 = new PdfPCell(new Paragraph("VENDOR REPORT",
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
						"Vendor Information", Font6));
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
						.append(resultSet.getString("VENDOR_NAME"));

				PdfPCell cell3 = new PdfPCell(new Paragraph("Vendor Name",
						mainContent));
				cell3.setBackgroundColor(new BaseColor(238, 238, 238));
				cell3.setBorderWidth(0.01f);
				cell3.setBorderColor(BaseColor.WHITE);

				PdfPCell cell4 = new PdfPCell(new Paragraph(
						stringBuffer.toString(), mainContent));
				cell4.setBorderWidth(0.2f);
				cell4.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell5 = new PdfPCell(new Paragraph("Vendor category",
						mainContent));
				cell5.setBackgroundColor(new BaseColor(238, 238, 238));
				cell5.setBorderWidth(0.01f);
				cell5.setBorderColor(BaseColor.WHITE);

				PdfPCell cell6 = new PdfPCell(new Paragraph(
						nameHelper.getVendorCategory(resultSet
								.getInt("REF_VENDOR_CATEGORY")), mainContent));
				cell6.setBorderWidth(0.2f);
				cell6.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell7 = new PdfPCell(new Paragraph("GL Account",
						mainContent));
				cell7.setBackgroundColor(new BaseColor(238, 238, 238));
				cell7.setBorderWidth(0.01f);
				cell7.setBorderColor(BaseColor.WHITE);

				PdfPCell cell8 = new PdfPCell(new Paragraph(
						nameHelper.getGlAccount(resultSet
								.getInt("REF_GL_ACCOUNT")), mainContent));
				cell8.setBorderWidth(0.2f);
				cell8.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell9 = new PdfPCell(new Paragraph("Assigned To",
						mainContent));
				cell9.setBackgroundColor(new BaseColor(238, 238, 238));
				cell9.setBorderWidth(0.01f);
				cell9.setBorderColor(BaseColor.WHITE);

				PdfPCell cell10 = new PdfPCell(new Paragraph(
						nameHelper.getAssignTo(resultSet
								.getInt("REF_ASSIGNED_TO")), mainContent));
				cell10.setBorderWidth(0.2f);
				cell10.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell11 = new PdfPCell(new Paragraph("Vendor Status",
						mainContent));
				cell11.setBackgroundColor(new BaseColor(238, 238, 238));
				cell11.setBorderWidth(0.01f);
				cell11.setBorderColor(BaseColor.WHITE);

				PdfPCell cell12 = new PdfPCell(new Paragraph(
						VendorStatus.getUserStatus(resultSet
								.getInt("VENDOR_STATUS")), mainContent));
				cell12.setBorderWidth(0.2f);
				cell12.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell13 = new PdfPCell(new Paragraph("Vendor Address",
						mainContent));
				cell13.setBackgroundColor(new BaseColor(238, 238, 238));
				cell13.setBorderWidth(0.01f);
				cell13.setBorderColor(BaseColor.WHITE);

				PdfPCell cell14 = new PdfPCell(new Paragraph(
						resultSet.getString("ADDRESS_LINE_1"), mainContent));
				cell14.setBorderWidth(0.2f);
				cell14.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell15 = new PdfPCell(new Paragraph("City",
						mainContent));
				cell15.setBackgroundColor(new BaseColor(238, 238, 238));
				cell15.setBorderWidth(0.01f);
				cell15.setBorderColor(BaseColor.WHITE);

				PdfPCell cell16 = new PdfPCell(new Paragraph(
						resultSet.getString("CITY"), mainContent));
				cell16.setBorderWidth(0.2f);
				cell16.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell17 = new PdfPCell(new Paragraph("State",
						mainContent));
				cell17.setBackgroundColor(new BaseColor(238, 238, 238));
				cell17.setBorderWidth(0.01f);
				cell17.setBorderColor(BaseColor.WHITE);

				PdfPCell cell18 = new PdfPCell(new Paragraph(
						resultSet.getString("STATE"), mainContent));
				cell18.setBorderWidth(0.2f);
				cell18.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell19 = new PdfPCell(new Paragraph("Country ",
						mainContent));
				cell19.setBackgroundColor(new BaseColor(238, 238, 238));
				cell19.setBorderWidth(0.01f);
				cell19.setBorderColor(BaseColor.WHITE);

				PdfPCell cell20 = new PdfPCell(new Paragraph(
						nameHelper.getCountryName(resultSet
								.getInt("REF_COUNTRY")), mainContent));
				cell20.setBorderWidth(0.2f);
				cell20.setBorderColor(BaseColor.LIGHT_GRAY);


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
							+ "Error: Occur in Query While Fetching All Vendor Details for print PdF from Database.",
					sqlExp);
		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					LeadDaoImpl.class
							+ "Error: Occur in Query While Closing Connection After Fetching All Vendor Details for print PdF from Database.",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}

	}

	@Override
	public VendorDTO retriveVendorsDetails(int vendorsId)
			throws OMIApplicationException {
		VendorDTO vendorDTO = new VendorDTO();
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.SHOW_VIEW_VENDORS);
			preparedStatement.setInt(1, vendorsId);
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {
					vendorDTO.setVendorsId(resultSet.getInt("VENDOR_ID"));
					vendorDTO
							.setVendorsName(resultSet.getString("VENDOR_NAME"));
					vendorDTO.setAssignedTo(nameHelper.getAssignTo(resultSet
							.getInt("REF_ASSIGNED_TO")));
					vendorDTO.setVendorsCategory(nameHelper
							.getVendorCategory(resultSet
									.getInt("REF_VENDOR_CATEGORY")));
					vendorDTO.setgLAccounts(nameHelper.getGlAccount(resultSet
							.getInt("REF_GL_ACCOUNT")));
					vendorDTO.setVendorsStatus(VendorStatus
							.getUserStatus(resultSet.getInt("VENDOR_STATUS")));
					vendorDTO.setVendorsFlag(resultSet
							.getString("VENDORS_FLAG"));
					vendorDTO.setAddressLine1(resultSet
							.getString("ADDRESS_LINE_1"));
					vendorDTO.setAddressLine2(resultSet
							.getString("ADDRESS_LINE_2"));
					vendorDTO.setCity(resultSet.getString("CITY"));
					vendorDTO.setState(resultSet.getString("STATE"));
					vendorDTO.setCountry(resultSet.getString("REF_COUNTRY"));
					vendorDTO.setFax(resultSet.getString("FAX_NO"));
					vendorDTO.setCreatedBy(resultSet.getString("CREATED_BY"));
					vendorDTO.setCreatedDate(resultSet
							.getString("CREATED_DATE"));
					vendorDTO.setPhoneNo(resultSet.getString("PHONE_NO"));
					vendorDTO.setMobileNo(resultSet.getString("MOBILE_NO"));
					vendorDTO.setAlternateEmailId(resultSet
							.getString("ALTERNATIVE_EMAIL_ID"));
					vendorDTO.setPrimaryEmailId(resultSet
							.getString("PRIMARY_EMAIL_ID"));
					vendorDTO
							.setDescription(resultSet.getString("DESCRIPTION"));

				}
			}
		} catch (SQLException sqlException) {

			logger.error(
					VendorsDaoImpl.class
							+ ": Error:- Error: Occur in Query While fetching the Vendors details for view from Database",
					sqlException);

		} catch (Exception exception) {

			logger.error(
					VendorsDaoImpl.class
							+ ": Error:- While closing the Connection after fetching the Vendors details for view from Database",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return vendorDTO;

	}

	@Override
	public int getVendorsLastRecord() throws OMIApplicationException {
		int temp = 0;
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_LAST_VENDORS_ID);
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {

					temp = resultSet.getInt("VENDOR_ID");

				}
			}
		} catch (SQLException sqlException) {

			logger.error(
					VendorsDaoImpl.class
							+ ": Error:- Error: Occur in Query While counting the Vendors recodes from Database",
					sqlException);

		} catch (Exception exception) {

			logger.error(
					VendorsDaoImpl.class
							+ ": Error:- While closing the Connection after counting the Vendors recodes from Database",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return temp;

	}

	@Override
	public VendorDTO getVendorsDetails(int vendorsId)
			throws OMIApplicationException {
		VendorDTO vendorDTO = new VendorDTO();
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.SHOW_VIEW_VENDORS);
			preparedStatement.setInt(1, vendorsId);
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {
					vendorDTO.setVendorsId(resultSet.getInt("VENDOR_ID"));
					vendorDTO
							.setVendorsName(resultSet.getString("VENDOR_NAME"));
					vendorDTO.setAssignedTo(resultSet
							.getString("REF_ASSIGNED_TO"));
					vendorDTO.setVendorsCategory(resultSet
							.getString("REF_VENDOR_CATEGORY"));
					vendorDTO.setgLAccounts(resultSet
							.getString("REF_GL_ACCOUNT"));
					vendorDTO.setVendorsStatus(resultSet
							.getString("VENDOR_STATUS"));
					vendorDTO.setVendorsFlag(resultSet
							.getString("VENDORS_FLAG"));
					vendorDTO.setAddressLine1(resultSet
							.getString("ADDRESS_LINE_1"));
					vendorDTO.setAddressLine2(resultSet
							.getString("ADDRESS_LINE_2"));
					vendorDTO.setCity(resultSet.getString("CITY"));
					vendorDTO.setState(resultSet.getString("STATE"));
					vendorDTO.setCountry(resultSet.getString("REF_COUNTRY"));
					vendorDTO.setFax(resultSet.getString("FAX_NO"));
					vendorDTO.setCreatedBy(resultSet.getString("CREATED_BY"));
					vendorDTO.setCreatedDate(resultSet
							.getString("CREATED_DATE"));
					vendorDTO.setPhoneNo(resultSet.getString("PHONE_NO"));
					vendorDTO.setMobileNo(resultSet.getString("MOBILE_NO"));
					vendorDTO.setAlternateEmailId(resultSet
							.getString("ALTERNATIVE_EMAIL_ID"));
					vendorDTO.setPrimaryEmailId(resultSet
							.getString("PRIMARY_EMAIL_ID"));
					vendorDTO
							.setDescription(resultSet.getString("DESCRIPTION"));

				}
			}
		} catch (SQLException sqlException) {

			logger.error(
					VendorsDaoImpl.class
							+ ": Error:- Error: Occur in Query While fetching the Vendors details for view from Database",
					sqlException);

		} catch (Exception exception) {

			logger.error(
					VendorsDaoImpl.class
							+ ": Error:- While closing the Connection after fetching the Vendors details for view from Database",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return vendorDTO;
	}

	@Override
	public VendorDTO getVendorsDetailsForUpdate(int vendorsId)
			throws OMIApplicationException {
		VendorDTO vendorDTO = new VendorDTO();
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.SHOW_VIEW_VENDORS);
			preparedStatement.setInt(1, vendorsId);
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {
					vendorDTO.setVendorsId(resultSet.getInt("VENDOR_ID"));
					vendorDTO
							.setVendorsName(resultSet.getString("VENDOR_NAME"));
					vendorDTO.setAssignedTo(resultSet
							.getString("REF_ASSIGNED_TO"));
					vendorDTO.setVendorsCategory(resultSet
							.getString("REF_VENDOR_CATEGORY"));
					vendorDTO.setgLAccounts(resultSet
							.getString("REF_GL_ACCOUNT"));
					vendorDTO.setVendorsStatus(resultSet
							.getString("VENDOR_STATUS"));
					vendorDTO.setVendorsFlag(resultSet
							.getString("VENDORS_FLAG"));
					vendorDTO.setAddressLine1(resultSet
							.getString("ADDRESS_LINE_1"));
					vendorDTO.setAddressLine2(resultSet
							.getString("ADDRESS_LINE_2"));
					vendorDTO.setCity(resultSet.getString("CITY"));
					vendorDTO.setState(resultSet.getString("STATE"));
					vendorDTO.setCountry(resultSet.getString("REF_COUNTRY"));
					vendorDTO.setFax(resultSet.getString("FAX_NO"));
					vendorDTO.setCreatedBy(resultSet.getString("CREATED_BY"));
					vendorDTO.setCreatedDate(resultSet
							.getString("CREATED_DATE"));
					vendorDTO.setPhoneNo(resultSet.getString("PHONE_NO"));
					vendorDTO.setMobileNo(resultSet.getString("MOBILE_NO"));
					vendorDTO.setAlternateEmailId(resultSet
							.getString("ALTERNATIVE_EMAIL_ID"));
					vendorDTO.setPrimaryEmailId(resultSet
							.getString("PRIMARY_EMAIL_ID"));
					vendorDTO
							.setDescription(resultSet.getString("DESCRIPTION"));
				}
			}
		} catch (SQLException sqlException) {

			logger.error(
					VendorsDaoImpl.class
							+ ": Error:- Error: Occur in Query While fetching the Vendors details for view from Database",
					sqlException);

		} catch (Exception exception) {

			logger.error(
					VendorsDaoImpl.class
							+ ": Error:- While closing the Connection after fetching the Vendors details for view from Database",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return vendorDTO;
	}

	/**
	 * <p>
	 * <code>getVendorDetails()</code> method use to fetching vendor details
	 * from TAB_VENDORS_DETAILS table.
	 * </p>
	 * 
	 * @param searchValue
	 * @param searchId
	 * 
	 * @return vendorDetailsList
	 * @throws Exception
	 */

	@Override
	public List<VendorsVO> getVendorDetails(int searchId, String searchValue)
			throws OMIApplicationException {
		List<VendorsVO> vendorDetailsList = new ArrayList<VendorsVO>();

		try {

			connection = getConnection();
			preparedStatement = connection.prepareStatement(QueryBuilder
					.vendorAdvanceSerach(searchId, searchValue));
			resultSet = preparedStatement.executeQuery();
			/* if (resultSet.next()) { */

			while (resultSet.next()) {

				vendorsVO = new VendorsVO();
				vendorsVO.setVendorsId(resultSet.getInt("VENDOR_ID"));
				vendorsVO.setVendorsName(resultSet.getString("VENDOR_NAME"));
				vendorsVO.setPhoneNo(resultSet.getString("PHONE_NO"));
				vendorsVO.setPrimaryEmailId(resultSet
						.getString("PRIMARY_EMAIL_ID"));
				vendorsVO.setVendorsCategory(nameHelper
						.getVendorCategory(resultSet
								.getInt("REF_VENDOR_CATEGORY")));
				vendorsVO.setAssignedTo(nameHelper.getAssignTo(resultSet
						.getInt("REF_ASSIGNED_TO")));
				vendorsVO.setVendorsStatus(VendorStatus.getUserStatus(resultSet
						.getInt("VENDOR_STATUS")));

				vendorDetailsList.add(vendorsVO);
			}

		} catch (SQLException sqlExp) {
			sqlExp.printStackTrace();
			logger.error(
					VendorsDaoImpl.class
							+ "Error: Occur in Query While Fetching the Vendor Details into Grid from Database.",
					sqlExp);
		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					VendorsDaoImpl.class
							+ "Error: Occur in Query While Closing Connection After Fetching the Vendor Details into Grid from Database.",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return vendorDetailsList;

	}

	@Override
	public Map<String, String> getVendorsNameList()
			throws OMIApplicationException {
		Map<String, String> vendorNameList = new HashMap<String, String>();
		try {

			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_VENDORS_NAME);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				vendorNameList.put(resultSet.getString("VENDOR_NAME"),
						resultSet.getString("VENDOR_NAME"));
			}

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					VendorsDaoImpl.class
							+ ": Error:- Error: Occur in Query While fetching Vendor Name list from Database",
					sqlException);

		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					VendorsDaoImpl.class
							+ ": Error:- While closing the Connection after fetching the Vendor Name list from Database",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return vendorNameList;

	}

	@Override
	public Map<String, String> getVendorPhoneList()
			throws OMIApplicationException {
		Map<String, String> vendorPhoneList = new HashMap<String, String>();
		try {

			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_VENDORS_PHONE);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				vendorPhoneList.put(resultSet.getString("PHONE_NO"),
						resultSet.getString("PHONE_NO"));
			}

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					VendorsDaoImpl.class
							+ ": Error:- Error: Occur in Query While fetching Vendor Name list from Database",
					sqlException);

		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					VendorsDaoImpl.class
							+ ": Error:- While closing the Connection after fetching the Vendor Name list from Database",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return vendorPhoneList;

	}

	@Override
	public Map<String, String> getPrimaryEmailList()
			throws OMIApplicationException {
		Map<String, String> vendorPrimaryEmailList = new HashMap<String, String>();
		try {

			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_VENDORS_PRIMARY_EMAIL);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				vendorPrimaryEmailList.put(
						resultSet.getString("PRIMARY_EMAIL_ID"),
						resultSet.getString("PRIMARY_EMAIL_ID"));
			}

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					VendorsDaoImpl.class
							+ ": Error:- Error: Occur in Query While fetching Vendor Name list from Database",
					sqlException);

		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					VendorsDaoImpl.class
							+ ": Error:- While closing the Connection after fetching the Vendor Name list from Database",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return vendorPrimaryEmailList;

	}

}
