package com.bst.ckt.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.bst.ckt.action.LedgerAction;
import com.bst.ckt.common.QueryBuilder;
import com.bst.ckt.common.QueryMaker;
import com.bst.ckt.exception.RecordNotFoundException;
import com.bst.ckt.framework.db.JdbcDAOSupport;
import com.bst.ckt.framework.db.JdbcHelper;
import com.bst.ckt.helper.NameHelper;
import com.bst.ckt.vo.LedgerVO;
import com.bst.ckt.vo.PurchaseCementVO;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class LedgerDaoImpl extends JdbcDAOSupport implements LedgerDaoInf{
	
	
	PreparedStatement preparedStatement = null;
	Connection connection = null;
	ResultSet resultSet = null;
	LedgerVO ledgerVO=null;
	
	NameHelper nameHelper= new NameHelper();
	private static final Logger logger = Logger.getLogger(LedgerDaoImpl.class);
	
	@Override
	public List<LedgerVO> viewLedgerGrid() throws RecordNotFoundException {
		List<LedgerVO> ledgerDetailList = new ArrayList<LedgerVO>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/DB201803", "root", "root");
			/*connection = getConnection();*/
			preparedStatement = connection
					.prepareStatement(QueryMaker.SHOW_LEDGER_DEALER_DETAILS);
			/*preparedStatement = connection
					.prepareStatement(QueryMaker.SHOW_CEMENT_PUCHASE_DETAILS);*/
			/*if(userRole==4){
				preparedStatement = connection.prepareStatement(QueryBuilder
						.PurchaseCementAdvanceSearchForAdmin(searchId, searchValue));
			}else{
			
			preparedStatement = connection.prepareStatement(QueryBuilder
					.PurchaseCementAdvanceSearch(searchId, searchValue));
	preparedStatement.setInt(1, shopId);
			}*/
			resultSet = preparedStatement.executeQuery();
			/* if (resultSet.next()) { */

			// LEAD_ID,COMPANY_NAME,LEAD_TITLE_REF,CONTACT_PERSON,LEAD_OWNER_REF,LEAD_DATE,EXPECTED_CLOSING_DATE,LEAD_STATUS,CREATED_BY
			while (resultSet.next()) {
				ledgerVO = new LedgerVO();
				ledgerVO.setLedgerId(resultSet.getInt("LEDGER_ID"));
				ledgerVO.setLedgerBillDate(resultSet.getString("LEDGER_DATE"));
				ledgerVO.setLedgerBillNo(resultSet.getString("LEDGER_VOUNCHER_NO"));
				ledgerVO.setLedgerTaxType(resultSet.getString("LEDGER_TAX_TYPE"));
				ledgerVO.setLedgerAmount(resultSet.getFloat("LEDGER_TAX_AMOUNT"));
				ledgerVO.setQuantity(resultSet.getFloat("LEDGER_QUANTITY"));
				ledgerVO.setTruckNo(resultSet.getString("LEDGER_TRUCK_NO"));
				ledgerVO.setDestination(resultSet.getString("LEDGER_DESTINATION"));
				ledgerVO.setPaid(resultSet.getFloat("LEDGER_PAID"));
				ledgerVO.setDue(resultSet.getFloat("LEDGER_DUE"));
				ledgerVO.setMaterial(resultSet.getString("LEDGER_MATERIAL"));
				ledgerVO.setStartDate(resultSet.getString("LEDGER_START_DATE"));
				ledgerVO.setDealerId(resultSet.getInt("LEDGER_DEALER_ID"));
				
				ledgerVO.setEndDate(resultSet.getString("LEDGER_END_DATE"));
				
				ledgerDetailList.add(ledgerVO);
			}

		} catch (SQLException sqlExp) {
			sqlExp.printStackTrace();
			logger.error(
					LedgerDaoImpl.class
							+ "Error: Occur in Query While Fetching the Ledger dealer Details into Grid from Database.",
					sqlExp);
		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					LedgerDaoImpl.class
							+ "Error: Occur in Query While Closing Connection After Fetching the Ledger dealer  into Grid from Database.",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return ledgerDetailList;
	}

	@Override
	public void generateLedgerPDF(HttpServletRequest request,
			HttpServletResponse response, int dealerId) {
		
		try {
		Document document = new Document(PageSize.A4);
		Font Font3 = new Font(Font.FontFamily.TIMES_ROMAN, 11, Font.NORMAL);
		Font Font2 = new Font(Font.FontFamily.TIMES_ROMAN, 6,
				Font.STRIKETHRU);
		Font Font4 = new Font(Font.FontFamily.TIMES_ROMAN, 11, Font.BOLD);
		Font4.setColor(BaseColor.WHITE);
		Font mainContent = new Font(Font.FontFamily.TIMES_ROMAN, 7,
				Font.NORMAL);
		Font mainContent2 = new Font(Font.FontFamily.TIMES_ROMAN, 8,
				Font.BOLD);
		Font Font5 = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
		Font5.setColor(BaseColor.GRAY);
		Font Font6 = new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.BOLD);
		Font6.setColor(BaseColor.RED);

		// Output
		ServletOutputStream outStream = response.getOutputStream();
		response.setContentType("application/pdf");
		  // PdfWriter writer = PdfWriter.getInstance(document, response.getOutputStream());
		 PdfWriter writer = PdfWriter.getInstance(document, outStream);
		//PdfWriter.getInstance(document, response.getOutputStream());

		document.open();
		// header
		System.out.println("PPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP");
		 PdfContentByte canvas = writer.getDirectContent();
		 Rectangle rect = new Rectangle(20, 20, 575, 820);
	        rect.setBorder(Rectangle.BOX);
	        rect.setBorderWidth(1);
	        canvas.rectangle(rect);
	       ////////////////////////////////////////////////////////////////////////////////////////
	        PdfPTable table4 = new PdfPTable(9);
			 
	        table4.setHorizontalAlignment(Element.ALIGN_LEFT);
	        table4.setWidthPercentage(100);
	        
	        PdfPCell cell29 = new PdfPCell(new Phrase(" Voucher Date:" , mainContent2));
	        cell29.setBackgroundColor(BaseColor.WHITE);
	       // cell.setBorder(Rectangle.NO_BORDER);
	        cell29.setBorderWidth(1f);
	        
	        PdfPCell cell31 = new PdfPCell(new Phrase("Voucher No:", mainContent2));
	       // cellTwo.setBorder(Rectangle.NO_BORDER);
	        cell31.setBorderWidth(1f); 
	        
	        
	    
	        PdfPCell cell32 = new PdfPCell(new Phrase(" Tax Type:" , mainContent2));
	        cell32.setBackgroundColor(BaseColor.WHITE);
	       // cell.setBorder(Rectangle.NO_BORDER);SALES_D
	        cell32.setBorderWidth(1f);
	        
	        PdfPCell cell33 = new PdfPCell(new Phrase("Quantity", mainContent2));
	       // cellTwo.setBorder(Rectangle.NO_BORDER);
	        cell33.setBorderWidth(1f); 
	        
	        PdfPCell cell34 = new PdfPCell(new Phrase(" Truck No:" , mainContent2));
	        cell34.setBackgroundColor(BaseColor.WHITE);
	       // cell.setBorder(Rectangle.NO_BORDER);
	        cell34.setBorderWidth(1f);
	        
	        PdfPCell cell35 = new PdfPCell(new Phrase(" Destination", mainContent2));
	       // cellTwo.setBorder(Rectangle.NO_BORDER);
	        cell35.setBorderWidth(1f); 
	        
	        PdfPCell cell36 = new PdfPCell(new Phrase(" Net Total" , mainContent2));
	        cell36.setBackgroundColor(BaseColor.WHITE);
	       // cell.setBorder(Rectangle.NO_BORDER);
	        cell36.setBorderWidth(1f);
	        
	        PdfPCell cell37 = new PdfPCell(new Phrase("Payment", mainContent2));
	       // cellTwo.setBorder(Rectangle.NO_BORDER);
	        cell37.setBorderWidth(1f); 
	        
	        PdfPCell cell38 = new PdfPCell(new Phrase(" Material:" , mainContent2));
	        cell38.setBackgroundColor(BaseColor.WHITE);
	       // cell.setBorder(Rectangle.NO_BORDER);
	        cell38.setBorderWidth(1f);
	        
	       /* PdfPCell cell39 = new PdfPCell(new Phrase(" ", mainContent2));
	       // cellTwo.setBorder(Rectangle.NO_BORDER);
	        cell39.setBorderWidth(1f); 
	        
	        PdfPCell cell40 = new PdfPCell(new Phrase(" HSN Code:" , mainContent2));
	        cell40.setBackgroundColor(BaseColor.WHITE);
	       // cell.setBorder(Rectangle.NO_BORDER);
	        cell40.setBorderWidth(1f);
	        
	        PdfPCell cell41 = new PdfPCell(new Phrase(" ", mainContent2));
	       // cellTwo.setBorder(Rectangle.NO_BORDER);
	        cell41.setBorderWidth(1f); */
	        
	        
	        table4.addCell(cell29);
		       table4.addCell(cell31);
		       table4.addCell(cell32);
		       table4.addCell(cell33);
		       table4.addCell(cell34);
		       table4.addCell(cell35);
		       table4.addCell(cell36);
		       table4.addCell(cell37);
		       table4.addCell(cell38);
		      /* table4.addCell(cell39);
		       table4.addCell(cell40);*/
		       /*table4.addCell(cell41);*/
		       
		       table4.setTotalWidth(540);
		        //table4.setWidths(new float[] { 2, 3 });
		        PdfContentByte canvas4 = writer.getDirectContent();
		        table4.writeSelectedRows(0, -1, 25, 730, canvas4);
	        
	        
	        
	        
		    	PdfPTable table5 = new PdfPTable(9);
	        /////////////////////////////////////////////////////////////////////////////////////////
		    	table5.setHorizontalAlignment(Element.ALIGN_LEFT);
				table5.setWidthPercentage(100);
		        
	        connection = getConnection();
	   	 String query="SELECT * FROM TAB_DEALER_LEDGER_DETAILS WHERE LEDGER_DEALER_ID=?";//SELECT  SALES_ID FROM TAB_SALES_DETAILS GROUP BY SALES_ID DESC LIMIT 1
	         
			  preparedStatement= connection.prepareStatement(query);
			  preparedStatement.setInt(1, 1);
			  resultSet = preparedStatement.executeQuery();
				while(resultSet.next()){
					System.out.println("PPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP"+resultSet.getString("LEDGER_VOUNCHER_NO"));
		
			 
			
	        PdfPCell cell42 = new PdfPCell(new Phrase(resultSet.getString("LEDGER_DATE"), mainContent));
	        cell42.setBackgroundColor(BaseColor.WHITE);
	       // cell.setBorder(Rectangle.NO_BORDER);
	        cell42.setBorderWidth(1f);
	        
	        
	        PdfPCell cell43 = new PdfPCell(new Phrase(resultSet.getString("LEDGER_VOUNCHER_NO"), mainContent));
	       // cellTwo.setBorder(Rectangle.NO_BORDER);
	        cell43.setBorderWidth(1f); 
	        
	        
	    
	        PdfPCell cell44 = new PdfPCell(new Phrase(resultSet.getString("LEDGER_TAX_TYPE"), mainContent));
	        cell44.setBackgroundColor(BaseColor.WHITE);
	       // cell.setBorder(Rectangle.NO_BORDER);SALES_D
	        cell44.setBorderWidth(1f);
	        
	        PdfPCell cell45 = new PdfPCell(new Phrase(resultSet.getString("LEDGER_QUANTITY"), mainContent));
	       // cellTwo.setBorder(Rectangle.NO_BORDER);
	        cell45.setBorderWidth(1f); 
	        
	        PdfPCell cell46 = new PdfPCell(new Phrase(resultSet.getString("LEDGER_TRUCK_NO"), mainContent));
	        cell46.setBackgroundColor(BaseColor.WHITE);
	       // cell.setBorder(Rectangle.NO_BORDER);
	        cell46.setBorderWidth(1f);
	        
	        PdfPCell cell47 = new PdfPCell(new Phrase(resultSet.getString("LEDGER_DESTINATION"), mainContent));
	       // cellTwo.setBorder(Rectangle.NO_BORDER);
	        cell47.setBorderWidth(1f); 
	        
	        PdfPCell cell48 = new PdfPCell(new Phrase(resultSet.getString("LEDGER_DUE"), mainContent));
	        cell48.setBackgroundColor(BaseColor.WHITE);
	       // cell.setBorder(Rectangle.NO_BORDER);
	        cell48.setBorderWidth(1f);
	        
	        PdfPCell cell49 = new PdfPCell(new Phrase(resultSet.getString("LEDGER_PAID"), mainContent));
	       // cellTwo.setBorder(Rectangle.NO_BORDER);
	        cell49.setBorderWidth(1f); 
	        
	        PdfPCell cell50 = new PdfPCell(new Phrase(resultSet.getString("LEDGER_MATERIAL"), mainContent));
	        cell50.setBackgroundColor(BaseColor.WHITE);
	       // cell.setBorder(Rectangle.NO_BORDER);
	        cell50.setBorderWidth(1f);
	        
	       /* PdfPCell cell51 = new PdfPCell(new Phrase(resultSet.getString("LEDGER_VOUNCHER_NO"), mainContent));
	       // cellTwo.setBorder(Rectangle.NO_BORDER);
	        cell51.setBorderWidth(1f); 
	        
	        PdfPCell cell52 = new PdfPCell(new Phrase(resultSet.getString("LEDGER_VOUNCHER_NO") , mainContent));
	        cell52.setBackgroundColor(BaseColor.WHITE);
	       // cell.setBorder(Rectangle.NO_BORDER);
	        cell52.setBorderWidth(1f);
	        
	        PdfPCell cell53 = new PdfPCell(new Phrase(resultSet.getString("LEDGER_VOUNCHER_NO"), mainContent));
	       // cellTwo.setBorder(Rectangle.NO_BORDER);
	        cell53.setBorderWidth(1f); */
	        
	        
	        table5.addCell(cell42);
	        table5.addCell(cell43);
	        table5.addCell(cell44);
	        table5.addCell(cell45);
	        table5.addCell(cell46);
	        table5.addCell(cell47);
	        table5.addCell(cell48);
	        table5.addCell(cell49);
	        table5.addCell(cell50);
	       /* table5.addCell(cell51);
	        table5.addCell(cell52);*/
		       /*table4.addCell(cell41);*/
		       
	       
	        ///////////////////////////////////////////////////////////////
			
				     
			}
			
			
				 table5.setTotalWidth(540);
			        //table4.setWidths(new float[] { 2, 3 });
			        PdfContentByte canvas5 = writer.getDirectContent();
			        table5.writeSelectedRows(0, -1, 25, 715, canvas5);
			
			
			
			
			
			
			
			
			
			////////////////////////////////////////////////////////////////////////////////////
	        
	        
	        document.close();
			writer.close();
			// End Footer
			 if(outStream != null){
				 outStream.close();
                 outStream.flush();
			
			 }
		} catch (SQLException exception) {
			exception.printStackTrace();
			logger.error(
					LeadDaoImpl.class
							+ "Error: Occur in Query While Closing Connection After Fetching All Sales Details for print PdF from Database.",
					exception);
		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					LeadDaoImpl.class
							+ "Error: Occur in Query While Closing Connection After Fetching All Sales Details for print PdF from Database.",
					exception);
		} finally {
			
			/*JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);*/
		}
	}

}
