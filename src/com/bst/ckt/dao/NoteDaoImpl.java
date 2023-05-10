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

import com.bst.ckt.common.QueryBuilder;
import com.bst.ckt.common.QueryMaker;
import com.bst.ckt.dto.Note;
import com.bst.ckt.exception.OMIApplicationException;
import com.bst.ckt.framework.db.JdbcDAOSupport;
import com.bst.ckt.framework.db.JdbcHelper;
import com.bst.ckt.framework.util.DateTimeUtil;
import com.bst.ckt.helper.NameHelper;
import com.bst.ckt.vo.NoteVO;
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
 * @author vinod
 * 
 */
public class NoteDaoImpl extends JdbcDAOSupport implements NoteDaoInf {

	/**
	 * Creating Logger object, logger object mapped with LeadAction class for
	 * writing Loggers.
	 */
	private static final Logger logger = Logger.getLogger(NoteDaoImpl.class);

	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	NoteVO noteVO = new NoteVO();
	NameHelper nameHelper = new NameHelper();
	Note note = null;
	Image image = null;

	@Override
	public int addNoteDetails(NoteVO noteVO) throws OMIApplicationException {
		int target = 0;

		String query = QueryMaker.INSERT_NOTE_DECRIPTION;
		try {
			connection = getConnection();

			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, noteVO.getNoteTitle());
			preparedStatement.setString(2, noteVO.getNoteTag());
			preparedStatement.setString(3, noteVO.getNoteDescription());
			preparedStatement.setString(4, DateTimeUtil.getDateAndTime());
			preparedStatement.setString(5, noteVO.getCreatedBy());
			preparedStatement.executeUpdate();
			target = 1;

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					NoteDaoImpl.class
							+ "Error: Occur in Query While Inserting the Note Details into Database.",
					sqlException);

		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					NoteDaoImpl.class
							+ "Error: Occur in Query While Inserting the Note Details into Database.",
					exception);
		} finally {
			JdbcHelper.closeConnection(connection);
			JdbcHelper.closePreparedStatement(preparedStatement);

		}
		return target;
	}

	@Override
	public List<NoteVO> showNoteDetails() throws OMIApplicationException {
		List<NoteVO> gridNoteList = new ArrayList<NoteVO>();
		String query = QueryMaker.SELECT_NOTE_DETAILS;
		try {
			connection = getConnection();

			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				NoteVO noteVO = new NoteVO();
				noteVO.setNoteId(resultSet.getInt("NOTE_ID"));
				noteVO.setNoteTag(resultSet.getString("NOTE_TAG"));
				noteVO.setNoteTitle(resultSet.getString("NOTE_TITLE"));
				noteVO.setCreatedBy(nameHelper.getNoteCreatedByName(resultSet
						.getInt("CREATED_BY")));
				noteVO.setCreatedDate(resultSet.getString("CREATION_DATE"));
				gridNoteList.add(noteVO);
			}

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					NoteDaoImpl.class
							+ "Error: Occur in Query While Selecting the Note Details from Database.",
					sqlException);

		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					NoteDaoImpl.class
							+ "Error: Occur in Query While Selecting the Note Details from Database.",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closeConnection(connection);
			JdbcHelper.closePreparedStatement(preparedStatement);

		}

		return gridNoteList;
	}

	@Override
	public Note getNoteDetails(int noteId) throws OMIApplicationException {
		Note note = new Note();
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.SHOW_VIEW_NOTE);
			preparedStatement.setInt(1, noteId);
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {
					note.setNoteId(resultSet.getInt("NOTE_ID"));
					note.setCreatedBy(nameHelper.getNoteCreatedByName(resultSet
							.getInt("CREATED_BY")));
					note.setCreatedDate(resultSet.getString("CREATION_DATE"));
					note.setNoteTag(resultSet.getString("NOTE_TAG"));
					note.setNoteTitle(resultSet.getString("NOTE_TITLE"));
					note.setNoteDescription(resultSet.getString("NOTE_DESC"));

				}
			}
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					LeadDaoImpl.class
							+ ": Error:- Error: Occur in Query While fetching the Note details for view from Database",
					sqlException);

		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					LeadDaoImpl.class
							+ ": Error:- While closing the Connection after fetching the Note details for view from Database",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return note;

	}

	@Override
	public Note getNoteDetailsForUpdate(int noteId)
			throws OMIApplicationException {
		note = new Note();
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.SHOW_VIEW_NOTE);
			preparedStatement.setInt(1, noteId);
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {
					note.setNoteId(resultSet.getInt("NOTE_ID"));
					note.setCreatedBy(nameHelper.getNoteCreatedByName(resultSet
							.getInt("CREATED_BY")));
					note.setCreatedDate(resultSet.getString("CREATION_DATE"));
					note.setNoteTag(resultSet.getString("NOTE_TAG"));
					note.setNoteTitle(resultSet.getString("NOTE_TITLE"));
					note.setNoteDescription(resultSet.getString("NOTE_DESC"));
				}
			}
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					LeadDaoImpl.class
							+ ": Error:- Error: Occur in Query While fetching the Note details for view from Database",
					sqlException);

		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					LeadDaoImpl.class
							+ ": Error:- While closing the Connection after fetching the Note details for view from Database",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return note;
	}

	@Override
	public int getNoteLastRecord() throws OMIApplicationException {
		int temp = 0;
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_LAST_NOTERECORD_ID);
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {

					temp = resultSet.getInt("NOTE_ID");

				}
			}
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					LeadDaoImpl.class
							+ ": Error:- Error: Occur in Query While counting the Note recodes from Database",
					sqlException);

		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					LeadDaoImpl.class
							+ ": Error:- While closing the Connection after counting the Note recodes from Database",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return temp;

	}

	@Override
	public int updateNoteInfo(NoteVO noteVO, int noteId)
			throws OMIApplicationException {
		int target = 0;
		String query = QueryMaker.UPDATE_NOTE_DETAILS;
		try {
			connection = getConnection();

			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, noteVO.getNoteTitle());
			preparedStatement.setString(2, noteVO.getNoteTag());
			preparedStatement.setString(3, noteVO.getNoteDescription());
			preparedStatement.setString(4, DateTimeUtil.getDateAndTime());
			preparedStatement.setString(5, noteVO.getCreatedBy());
			System.out.println("created by" + noteVO.getCreatedBy());
			preparedStatement.setInt(6, noteId);
			preparedStatement.executeUpdate();
			target = 1;

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					NoteDaoImpl.class
							+ "Error: Occur in Query While Inserting the Note Details into Database.",
					sqlException);

		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					NoteDaoImpl.class
							+ "Error: Occur in Query While Inserting the Note Details into Database.",
					exception);
		} finally {
			JdbcHelper.closeConnection(connection);
			JdbcHelper.closePreparedStatement(preparedStatement);

		}
		return target;

	}

	@Override
	public HashMap<String, String> getNoteTitleListOfNote()
			throws OMIApplicationException {
		HashMap<String, String> noteTitleList = new HashMap<String, String>();
		try {

			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_NOTE_TITLE);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				noteTitleList.put(resultSet.getString("NOTE_TITLE"),
						resultSet.getString("NOTE_TITLE"));
			}

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					NoteDaoImpl.class
							+ ": Error:- Error: Occur in Query While fetching Note Title list from Database",
					sqlException);

		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					NoteDaoImpl.class
							+ ": Error:- While closing the Connection after fetching the note title list from Database",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return noteTitleList;

	}

	@Override
	public HashMap<Integer, String> getCreatedByListOfNote()
			throws OMIApplicationException {
		HashMap<Integer, String> createdByList = new HashMap<Integer, String>();
		try {

			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_CREATED_BY);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				createdByList.put(resultSet.getInt("CREATED_BY"), nameHelper
						.getNoteCreatedByName(resultSet.getInt("CREATED_BY")));
			}

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					NoteDaoImpl.class
							+ ": Error:- Error: Occur in Query While fetching Created By list from Database",
					sqlException);

		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					NoteDaoImpl.class
							+ ": Error:- While closing the Connection after fetching the Created By list from Database",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return createdByList;

	}

	@Override
	public List<NoteVO> getNoteDetails(int searchId, String searchValue)
			throws OMIApplicationException {

		List<NoteVO> noteDetailsList = new ArrayList<NoteVO>();

		try {

			connection = getConnection();
			preparedStatement = connection.prepareStatement(QueryBuilder
					.noteAdvanceSerach(searchId, searchValue));
			resultSet = preparedStatement.executeQuery();
			/* if (resultSet.next()) { */

			// LEAD_ID,COMPANY_NAME,LEAD_TITLE_REF,CONTACT_PERSON,LEAD_OWNER_REF,LEAD_DATE,EXPECTED_CLOSING_DATE,LEAD_STATUS,CREATED_BY
			while (resultSet.next()) {
				noteVO = new NoteVO();

				noteVO.setNoteId(resultSet.getInt("NOTE_ID"));
				noteVO.setNoteTitle(resultSet.getString("NOTE_TITLE"));

				noteVO.setCreatedBy(nameHelper.getNoteCreatedByName(resultSet
						.getInt("CREATED_BY")));
				noteVO.setCreatedDate(resultSet.getString("CREATION_DATE"));

				noteDetailsList.add(noteVO);
			}

		} catch (SQLException sqlExp) {

			logger.error(
					NoteDaoImpl.class
							+ "Error: Occur in Query While Fetching the Note Details into Grid from Database.",
					sqlExp);
		} catch (Exception exception) {

			logger.error(
					NoteDaoImpl.class
							+ "Error: Occur in Query While Closing Connection After Fetching the Note Details into Grid from Database.",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return noteDetailsList;

	}

	/**
	 * <p>
	 * <code>notePDF()</code> method use to generate pdf report for note details
	 * from TAB_NOTE table.
	 * 
	 * </p>
	 * 
	 * @return noteVO
	 * @throws Exception
	 */
	@Override
	public void notePDF(HttpServletRequest request,
			HttpServletResponse response, int noteId)
			throws OMIApplicationException {

		String companyName = "Vanrasoft Technologies";
		String address1 = "2nd Floor, Plot No-5, Nishal Bhavan Loksewa Nagar";
		String address2 = "Nageshwer Temple Road Near Pariwar City Moll";
		String city = "Nagpur-440022";
		String state = "(M.H.)";
		
		try {

			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.SHOW_NOTE_PRINT_PDF);
			preparedStatement.setInt(1, noteId);
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

			PdfPCell cell104 = new PdfPCell(new Paragraph("NOTE REPORT", Font4));
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

				PdfPCell cell1 = new PdfPCell(new Paragraph("Note Information",
						Font6));
				cell1.setBackgroundColor(new BaseColor(238, 238, 238));
				cell1.setBorderWidth(0.01f);
				cell1.setBorderColor(BaseColor.WHITE);

				PdfPCell cell2 = new PdfPCell(new Paragraph());
				cell2.setBackgroundColor(new BaseColor(238, 238, 238));
				cell2.setBorderWidth(0.2f);
				cell2.setBorderColor(BaseColor.WHITE);

				PdfPCell cell3 = new PdfPCell(new Paragraph("Note Title",
						mainContent));
				cell3.setBackgroundColor(new BaseColor(238, 238, 238));
				cell3.setBorderWidth(0.01f);
				cell3.setBorderColor(BaseColor.WHITE);

				PdfPCell cell4 = new PdfPCell(new Paragraph(
						resultSet.getString("NOTE_TITLE"), mainContent));
				cell4.setBorderWidth(0.2f);
				cell4.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell5 = new PdfPCell(new Paragraph("Note Tag",
						mainContent));
				cell5.setBackgroundColor(new BaseColor(238, 238, 238));
				cell5.setBorderWidth(0.01f);
				cell5.setBorderColor(BaseColor.WHITE);

				PdfPCell cell6 = new PdfPCell(new Paragraph(
						resultSet.getString("NOTE_TAG"), mainContent));
				cell6.setBorderWidth(0.2f);
				cell6.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell7 = new PdfPCell(new Paragraph("Note Description",
						mainContent));
				cell7.setBackgroundColor(new BaseColor(238, 238, 238));
				cell7.setBorderWidth(0.01f);
				cell7.setBorderColor(BaseColor.WHITE);

				PdfPCell cell8 = new PdfPCell(new Paragraph(
						resultSet.getString("NOTE_DESC"), mainContent));
				cell8.setBorderWidth(0.2f);
				cell8.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell9 = new PdfPCell(new Paragraph("Created By",
						mainContent));
				cell9.setBackgroundColor(new BaseColor(238, 238, 238));
				cell9.setBorderWidth(0.01f);
				cell9.setBorderColor(BaseColor.WHITE);

				PdfPCell cell10 = new PdfPCell(new Paragraph(
						nameHelper.getNoteCreatedByName(resultSet
								.getInt("CREATED_BY")), mainContent));
				cell10.setBorderWidth(0.2f);
				cell10.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell11 = new PdfPCell(new Paragraph("Creation Date",
						mainContent));
				cell11.setBackgroundColor(new BaseColor(238, 238, 238));
				cell11.setBorderWidth(0.01f);
				cell11.setBorderColor(BaseColor.WHITE);

				PdfPCell cell12 = new PdfPCell(new Paragraph(
						resultSet.getString("CREATION_DATE"), mainContent));
				cell12.setBorderWidth(0.2f);
				cell12.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell13 = new PdfPCell(new Paragraph("Note Updated By",
						mainContent));
				cell13.setBackgroundColor(new BaseColor(238, 238, 238));
				cell13.setBorderWidth(0.01f);
				cell13.setBorderColor(BaseColor.WHITE);

				PdfPCell cell14 = new PdfPCell(new Paragraph(
						resultSet.getString("UPDATED_BY"), mainContent));
				cell14.setBorderWidth(0.2f);
				cell14.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell15 = new PdfPCell(new Paragraph(
						"Note Updation Date ", mainContent));
				cell15.setBackgroundColor(new BaseColor(238, 238, 238));
				cell15.setBorderWidth(0.01f);
				cell15.setBorderColor(BaseColor.WHITE);

				PdfPCell cell16 = new PdfPCell(new Paragraph(resultSet
								.getString("UPDATION_DATE"), mainContent));
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
					"© 2015 Vanrasoft Technologies. All Rights Reserved.",
					mainContent));
			document.close();
			// End Footer
		} catch (SQLException sqlExp) {
			
			logger.error(
					NoteDaoImpl.class
							+ "Error: Occur in Query While Fetching All note Details for print PdF from Database.",
					sqlExp);
		} catch (Exception exception) {
			
			logger.error(
					NoteDaoImpl.class
							+ "Error: Occur in Query While Closing Connection After Fetching All note Details for print PdF from Database.",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}

	}
}
