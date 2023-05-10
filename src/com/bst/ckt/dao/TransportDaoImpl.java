package com.bst.ckt.dao;

import java.io.ByteArrayOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.struts2.ServletActionContext;

import com.bst.ckt.common.QueryMaker;
import com.bst.ckt.dto.Product;
import com.bst.ckt.dto.Transport;
import com.bst.ckt.exception.OMIApplicationException;
import com.bst.ckt.framework.db.JdbcDAOSupport;
import com.bst.ckt.framework.db.JdbcHelper;
import com.bst.ckt.framework.util.DateTimeUtil;
import com.bst.ckt.helper.NameHelper;
import com.bst.ckt.vo.LeadVO;
import com.bst.ckt.vo.ProductVO;
import com.bst.ckt.vo.TransportVO;
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



public class TransportDaoImpl extends JdbcDAOSupport implements TransportDaoInf {

	
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	Image image = null;
	ExcelReportDaoImpl daoImpl = null;
	
	
	private static final Logger logger = Logger
			.getLogger(TransportDaoImpl.class);
	
	public void TransportRequest(TransportVO transportVO)
			throws Exception {
	
		
		try {
            System.out.println("...........DAO IMPL Class............."); 
			
			connection = getConnection();
			preparedStatement = connection.prepareStatement(QueryMaker.INSERT_TRANSPORT_DETAILS);
			
			preparedStatement.setInt(1, transportVO.getTransportId());
			
			preparedStatement.setString(2, transportVO.getTransportName());
	
	        preparedStatement.setString(3, transportVO.getTransportAddressline1());
			preparedStatement.setString(4, transportVO.getTruckNumber());
	        
			
			preparedStatement.setString(5, transportVO.getContactPerson());
			
			preparedStatement.setString(6, transportVO.getAlternativeContact());
				
			preparedStatement.setString(7, transportVO.getTransportAddressline2());
			preparedStatement.setString(8, transportVO.getTransporter());
			preparedStatement.setString(9, transportVO.getCreationDate());
			preparedStatement.setString(10, transportVO.getContactNumber());
			preparedStatement.setString(11, transportVO.getCity());			
			

			
			

			preparedStatement.executeUpdate();
			
		System.out.println("......execute");
		}
		catch(SQLException sqlExcepttion){
		  	System.out.println("SQL Exception"+sqlExcepttion);
		  	sqlExcepttion.printStackTrace();
			
			
		}
		
			
		 catch(Exception exception) {
			  exception.printStackTrace();
			  System.out.println("Exception is :: "+exception);
	
		
		
		
	}
}
	
	
	public List<TransportVO> getTransportDetails(TransportVO transportVO) throws Exception {
		System.out.println("Transport Details DAOIMPL ****************");
		
		List<TransportVO> transportDetailsList = new ArrayList<TransportVO>();
		
		try {
			

			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_TRANSPORT_DETAIL);
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				transportVO = new TransportVO();
				
				transportVO.setTransportId(resultSet.getInt("TRANSPORT_ID"));
				
				transportVO.setTransportName(resultSet.getString("TRANSPORT_NAME"));
				
				transportVO.setTruckNumber(resultSet.getString("TRUCK_NUMBER"));
				
				transportVO.setContactNumber(resultSet.getString("CREATION_DATE"));
				
				transportVO.setCreationDate(resultSet.getString("CONTACT_NUMBER"));
	     
				transportVO.setCity(resultSet.getString("CITY"));
				
				System.out.println("**********************   ::  "+resultSet.getString("CITY"));
			


	     	
				
				transportDetailsList.add(transportVO);
			}

				
				
		} catch (SQLException sqlExp) {
			sqlExp.printStackTrace();
			logger.error(
					TransportDaoImpl.class
							+ "Error: Occur in Query While Fetching the Camping Details into Grid from Database.",
					sqlExp);
		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					TransportDaoImpl.class
							+ "Error: Occur in Query While Closing Connection After Fetching the Camping Details into Grid from Database.",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return transportDetailsList;	
	

	
		// TODO Auto-generated method stub
		
	}

	
	
	public int deleteTransportDetails(int transportId)
			throws Exception {
		int target = 0;
		
		try {
			System.out.println(transportId+"jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj");
			connection = getConnection();
			preparedStatement = connection.
					prepareStatement(QueryMaker.DELETE_TRANSPORT_DETAILS);

			preparedStatement.setInt(1, transportId);
			preparedStatement.executeUpdate();
			target = 1;

		} catch (Exception exception) {
			logger.error(TransportDaoImpl.class
					+ ": Error:- While deleting Transport details from Database.");
		} finally {
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);

		}
		return target;
	}

	
	
	    public Transport retriveTransportFullDetailGrid(int transportId)
	    	{
	    	System.out.println("_____________Contact DAO CLASS_____________");
	    	Transport transport=new Transport();

	    	try {
	connection = getConnection();
	preparedStatement = connection
			.prepareStatement(QueryMaker.SHOW_VIEW_TRANSPORT);
	preparedStatement.setInt(1, transportId);
	resultSet = preparedStatement.executeQuery();
	System.out.println("----------hye ----------------");
	if(resultSet != null){
	while (resultSet.next()) {
		
		System.out.println("----------hye ----------------");

		transport.setTransportId(resultSet.getInt("TRANSPORT_ID"));
		System.out.println("________________"+resultSet.getInt("TRANSPORT_ID"));

		transport.setTransportName(resultSet.getString("TRANSPORT_NAME"));
		
		transport.setTransportAddressline1(resultSet.getString("TRANSPORT_ADDRESS_LINE1"));
		
		transport.setTruckNumber(resultSet.getString("TRUCK_NUMBER"));
		
		transport.setContactPerson(resultSet.getString("CONTACT_PERSON"));
		
		transport.setAlternativeContact(resultSet.getString("ALTERNATIVE_CONTACT"));
		
		transport.setTransportAddressline2(resultSet.getString("TRANSPORT_ADDRESS_LINE2"));
		
		transport.setTransporter(resultSet.getString("TRANSPORTER"));
		
		transport.setCreationDate(resultSet.getString("CREATION_DATE"));
		
		transport.setContactNumber(resultSet.getString("CONTACT_NUMBER"));
		
		transport.setCity(resultSet.getString("CITY"));
		
		
		
			}
	}
		
		}catch(Exception exception){
			
		}
		
		
		return transport;
	    	
}


	
	
	    public void generateTransportPdf(HttpServletRequest request,
				HttpServletResponse response, int transportId)
				throws Exception {
	    	String companyName = "Chouksay Traders";
			String address1= "BUS STAND SHAMSHABAD, DIST.- VIDISHA, MADHYA PRADESH, 464001";
			String address2="GSTIN: 23AJQPC8200P1Z1";
			String address3="PAN NO: AJQPC8200P";

			String city = "Vidisha-464001";
			String state = "(M.P.)";
			StringBuffer stringBuffer = null;
	response=ServletActionContext.getResponse();
			try {

				connection = getConnection();
				preparedStatement = connection
						.prepareStatement(QueryMaker.VIEW_TRANSPORT_PDF);
				preparedStatement.setInt(1, transportId);
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
						.getRealPath("/outer/img/rohittraders.png");
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

				PdfPCell cell104 = new PdfPCell(new Paragraph("Transport REPORT", Font4));
				cell104.setUseBorderPadding(true);
				cell104.setColspan(2);
				cell104.setBorderWidthRight(0.1f);
				cell104.setBorderWidthLeft(0.1f);
				cell104.setBorderWidthTop(0.1f);
				cell104.setBorderWidthBottom(0.1f);
				cell104.setBorderColor(BaseColor.LIGHT_GRAY);
				cell104.setBackgroundColor(new BaseColor(128, 0, 0));

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

					PdfPCell cell1 = new PdfPCell(new Paragraph("Transport Information",
							Font6));
					cell1.setBackgroundColor(new BaseColor(238, 238, 238));
					cell1.setBorderWidth(0.01f);
					cell1.setBorderColor(BaseColor.WHITE);

					PdfPCell cell2 = new PdfPCell(new Paragraph());
					cell2.setBackgroundColor(new BaseColor(238, 238, 238));
					cell2.setBorderWidth(0.2f);
					cell2.setBorderColor(BaseColor.WHITE);

					
	
					PdfPCell cell3 = new PdfPCell(new Paragraph("Transport Id",
							mainContent));
					cell3.setBackgroundColor(new BaseColor(238, 238, 238));
					cell3.setBorderWidth(0.01f);
					cell3.setBorderColor(BaseColor.WHITE);

					PdfPCell cell4 = new PdfPCell(new Paragraph(resultSet.getString("TRANSPORT_ID"), mainContent));
					cell4.setBorderWidth(0.2f);
					cell4.setBorderColor(BaseColor.LIGHT_GRAY);

					PdfPCell cell5 = new PdfPCell(new Paragraph(
							"Transport Name", mainContent));
					cell5.setBackgroundColor(new BaseColor(238, 238, 238));
					cell5.setBorderWidth(0.01f);
					cell5.setBorderColor(BaseColor.WHITE);

					PdfPCell cell6 = new PdfPCell(new Paragraph(resultSet.getString("TRANSPORT_NAME"), mainContent));
					cell6.setBorderWidth(0.2f);
					cell6.setBorderColor(BaseColor.LIGHT_GRAY);

					PdfPCell cell7 = new PdfPCell(new Paragraph("Transprt Address line1",
							mainContent));
					cell7.setBackgroundColor(new BaseColor(238, 238, 238));
					cell7.setBorderWidth(0.01f);
					cell7.setBorderColor(BaseColor.WHITE);

					PdfPCell cell8 = new PdfPCell(new Paragraph(
							resultSet.getString("TRANSPORT_ADDRESS_LINE1"), mainContent));
					cell8.setBorderWidth(0.2f);
					cell8.setBorderColor(BaseColor.LIGHT_GRAY);

					PdfPCell cell9 = new PdfPCell(new Paragraph("Truck Number",
							 mainContent));
					cell9.setBorderWidth(0.2f);
					cell9.setBorderColor(BaseColor.LIGHT_GRAY);
					
					PdfPCell cell10 = new PdfPCell(new Paragraph(
							resultSet.getString("TRUCK_NUMBER"), mainContent));
					cell10.setBorderWidth(0.2f);
					cell10.setBorderColor(BaseColor.LIGHT_GRAY);

					PdfPCell cell11 = new PdfPCell(new Paragraph("Contact Person",
							mainContent));
					cell11.setBackgroundColor(new BaseColor(238, 238, 238));
					cell11.setBorderWidth(0.01f);
					cell11.setBorderColor(BaseColor.WHITE);

					PdfPCell cell12 = new PdfPCell(new Paragraph(resultSet.getString("CONTACT_PERSON"), mainContent));
					cell12.setBorderWidth(0.2f);
					cell12.setBorderColor(BaseColor.LIGHT_GRAY);

					PdfPCell cell13 = new PdfPCell(new Paragraph("Alternative Contact",
							mainContent));
					cell13.setBackgroundColor(new BaseColor(238, 238, 238));
					cell13.setBorderWidth(0.01f);
					cell13.setBorderColor(BaseColor.WHITE);

					PdfPCell cell14 = new PdfPCell(new Paragraph(resultSet.getString("ALTERNATIVE_CONTACT"), mainContent));
					cell14.setBorderWidth(0.2f);
					cell14.setBorderColor(BaseColor.LIGHT_GRAY);

					PdfPCell cell15 = new PdfPCell(new Paragraph(
							"Transprt Address line2", mainContent));
					cell15.setBackgroundColor(new BaseColor(238, 238, 238));
					cell15.setBorderWidth(0.01f);
					cell15.setBorderColor(BaseColor.WHITE);

					PdfPCell cell16= new PdfPCell(new Paragraph(resultSet.getString("TRANSPORT_ADDRESS_LINE2"), mainContent));
					cell16.setBorderWidth(0.2f);
					cell16.setBorderColor(BaseColor.LIGHT_GRAY);

					PdfPCell cell17 = new PdfPCell(new Paragraph(
							"Transpoter", mainContent));
					cell17.setBackgroundColor(new BaseColor(238, 238, 238));
					cell17.setBorderWidth(0.01f);
					cell17.setBorderColor(BaseColor.WHITE);

					PdfPCell cell18= new PdfPCell(new Paragraph(resultSet.getString("TRANSPORTER"), mainContent));
					cell18.setBorderWidth(0.2f);
					cell18.setBorderColor(BaseColor.LIGHT_GRAY);
					
					PdfPCell cell19 = new PdfPCell(new Paragraph(
							"Creation Date", mainContent));
					cell19.setBackgroundColor(new BaseColor(238, 238, 238));
					cell19.setBorderWidth(0.01f);
					cell19.setBorderColor(BaseColor.WHITE);

					PdfPCell cell20= new PdfPCell(new Paragraph(resultSet.getString("CREATION_DATE"), mainContent));
					cell20.setBorderWidth(0.2f);
					cell20.setBorderColor(BaseColor.LIGHT_GRAY);
					
					PdfPCell cell21 = new PdfPCell(new Paragraph(
							"Contact Number", mainContent));
					cell21.setBackgroundColor(new BaseColor(238, 238, 238));
					cell21.setBorderWidth(0.01f);
					cell21.setBorderColor(BaseColor.WHITE);

					PdfPCell cell22= new PdfPCell(new Paragraph(resultSet.getString("CONTACT_NUMBER"), mainContent));
					cell22.setBorderWidth(0.2f);
					cell22.setBorderColor(BaseColor.LIGHT_GRAY);
					
					
					PdfPCell cell23 = new PdfPCell(new Paragraph(
							"City", mainContent));
					cell23.setBackgroundColor(new BaseColor(238, 238, 238));
					cell23.setBorderWidth(0.01f);
					cell23.setBorderColor(BaseColor.WHITE);

					PdfPCell cell24= new PdfPCell(new Paragraph(resultSet.getString("CITY"), mainContent));
					cell24.setBorderWidth(0.2f);
					cell24.setBorderColor(BaseColor.LIGHT_GRAY);

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
					
	

					document.add(table);
				}
				// Footer

				document.add(new Paragraph("\n"));
				/*document.add(new Paragraph(
						"© 2018 Birjasoft Technologies. All Rights Reserved.",
						mainContent));*/
				document.close();
				// End Footer
			} catch (SQLException sqlExp) {
				sqlExp.printStackTrace();
				logger.error(
						TransportDaoImpl.class
								+ "Error: Occur in Query While Fetching All Transport Details for print PdF from Database.",
						sqlExp);
			} catch (Exception exception) {
				exception.printStackTrace();
				logger.error(
						TransportDaoImpl.class
								+ "Error: Occur in Query While Closing Connection After Fetching All Transport Details for print PdF from Database.",
						exception);
			} finally {
				JdbcHelper.closeResultSet(resultSet);
				JdbcHelper.closePreparedStatement(preparedStatement);
				JdbcHelper.closeConnection(connection);
			}		
		}

	    
		public Transport editTransportDetail(Transport transport, int transportId) throws Exception {
			

			try {
				connection = getConnection();
				preparedStatement = connection
						.prepareStatement(QueryMaker.GET_TRANSPORT_DETAIL_EDIT);
				preparedStatement.setInt(1, transportId);
				resultSet = preparedStatement.executeQuery();
				if (resultSet != null) {
					while (resultSet.next()) {

						transport.setTransportId(resultSet.getInt("TRANSPORT_ID"));
						System.out.println("________________"+resultSet.getInt("TRANSPORT_ID"));

						transport.setTransportName(resultSet.getString("TRANSPORT_NAME"));

	    
						transport.setTransportAddressline1(resultSet.getString("TRANSPORT_ADDRESS_LINE1"));
						
						transport.setTruckNumber(resultSet.getString("TRUCK_NUMBER"));
						
						transport.setContactPerson(resultSet.getString("CONTACT_PERSON"));
						
						transport.setAlternativeContact(resultSet.getString("ALTERNATIVE_CONTACT"));
						
						transport.setTransportAddressline2(resultSet.getString("TRANSPORT_ADDRESS_LINE2"));
						
						transport.setTransporter(resultSet.getString("TRANSPORTER"));
						
						transport.setCreationDate(resultSet.getString("CREATION_DATE"));
						
						transport.setContactNumber(resultSet.getString("CONTACT_NUMBER"));
						
						transport.setCity(resultSet.getString("CITY"));
						

					}

				}
			} catch (SQLException sqlException) {
				sqlException.printStackTrace();
				logger.error(
						TransportDaoImpl.class
								+ ": Error:- Error: Occur in Query While fetching the Transport details from Database",
						sqlException);

			} catch (Exception exception) {
				exception.printStackTrace();
				logger.error(
						TransportDaoImpl.class
								+ ": Error:- While closing the Connection after fetching the Transport details from Database",
						exception);
			} finally {
				JdbcHelper.closeResultSet(resultSet);
				JdbcHelper.closePreparedStatement(preparedStatement);
				JdbcHelper.closeConnection(connection);
			}

			return transport;
		}


		

	    
		public int updateTransportDetail(TransportVO transportVO, int transportId)
				throws Exception {
			int target = 0;

			try {
				connection = getConnection();
				preparedStatement = connection
						.prepareStatement(QueryMaker.UPDATE_TRANSPORT_DETAIL);

System.out.println(transportVO.getTransportId()+"UUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUU");

				preparedStatement.setString(1, transportVO.getTransportName());
				preparedStatement.setString(2, transportVO.getTransportAddressline1());
				preparedStatement.setString(3, transportVO.getTruckNumber());
		        preparedStatement.setString(4, transportVO.getContactPerson());
				preparedStatement.setString(5, transportVO.getAlternativeContact());
				preparedStatement.setString(6, transportVO.getTransportAddressline2());
				preparedStatement.setString(7, transportVO.getTransporter());
				preparedStatement.setString(8, transportVO.getCreationDate());
				preparedStatement.setString(9, transportVO.getContactNumber());
				preparedStatement.setString(10, transportVO.getCity());			
				preparedStatement.setInt(11, transportId);
				
				preparedStatement.executeUpdate();
				target = 1;

			} catch (SQLException sqlException) {
				sqlException.printStackTrace();
				logger.error(
						TransportDaoImpl.class
								+ ": Error:- Error: Occur in Query While updating the Transport details into Database",
						sqlException);

			} catch (Exception exception) {
				exception.printStackTrace();
				logger.error(
						TransportDaoImpl.class
								+ ": Error:- While closing the Connection after updating the Transport social details into Database",
						exception);
			} finally {
				JdbcHelper.closePreparedStatement(preparedStatement);
				JdbcHelper.closeConnection(connection);
			}
			return target;
		}
		
		
		
		public int gettransportLastRecord() throws OMIApplicationException {
			int target = 0;
			try {
				connection = getConnection();
				preparedStatement = connection
						.prepareStatement(QueryMaker.GET_LAST_TRANSPORT_ID);
				resultSet = preparedStatement.executeQuery();
				if (resultSet != null) {
					while (resultSet.next()) {

						target = resultSet.getInt("TRANSPORT_ID");
System.out.println("LAST RORDJNDDDDDDDDDHFHEC"+target);
					}
				}
			} catch (SQLException sqlException) {

				logger.error(
						TransportDaoImpl.class
								+ ": Error:- Error: Occur in Query While counting the transport recodes from Database",
						sqlException);

			} catch (Exception exception) {

				logger.error(
						TransportDaoImpl.class
								+ ": Error:- While closing the Connection after counting the transport recodes from Database",
						exception);
			} finally {
				JdbcHelper.closeResultSet(resultSet);
				JdbcHelper.closePreparedStatement(preparedStatement);
				JdbcHelper.closeConnection(connection);
			}
			return target;
		}
		

			
			
			public Transport getTransportDetails(int transportId)
					throws OMIApplicationException {
				
				Transport transport = new Transport();
				try {
					connection = getConnection();
					preparedStatement = connection
							.prepareStatement(QueryMaker.SHOW_NEXT_VIEW_TRANSPORT);
					preparedStatement.setInt(1, transportId);
					resultSet = preparedStatement.executeQuery();
					if (resultSet != null) {
						while (resultSet.next()) {
							
							
							transport.setTransportId(resultSet.getInt("TRANSPORT_ID"));
							System.out.println("________________"+resultSet.getInt("TRANSPORT_ID"));

							transport.setTransportName(resultSet.getString("TRANSPORT_NAME"));

		    
							transport.setTransportAddressline1(resultSet.getString("TRANSPORT_ADDRESS_LINE1"));
							
							transport.setTruckNumber(resultSet.getString("TRUCK_NUMBER"));
							
							transport.setContactPerson(resultSet.getString("CONTACT_PERSON"));
							
							transport.setAlternativeContact(resultSet.getString("ALTERNATIVE_CONTACT"));
							
							transport.setTransportAddressline2(resultSet.getString("TRANSPORT_ADDRESS_LINE2"));
							
							transport.setTransporter(resultSet.getString("TRANSPORTER"));
							
							transport.setCreationDate(resultSet.getString("CREATION_DATE"));
							
							transport.setContactNumber(resultSet.getString("CONTACT_NUMBER"));
							
							transport.setCity(resultSet.getString("CITY"));

						}
					}
				} catch (SQLException sqlException) {

					logger.error(
							TransportDaoImpl.class
									+ ": Error:- Error: Occur in Query While fetching the Product details for view from Database",
							sqlException);

				} catch (Exception exception) {

					logger.error(
							TransportDaoImpl.class
									+ ": Error:- While closing the Connection after fetching the Product details for view from Database",
							exception);
				} finally {
					JdbcHelper.closeResultSet(resultSet);
					JdbcHelper.closePreparedStatement(preparedStatement);
					JdbcHelper.closeConnection(connection);
				}
				return transport;
			}

			
			
			
			
			
			
			
			
			
			
			
			
			
			
		}

		
		
		
		
					
