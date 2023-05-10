/*    1:     */ package com.bst.ckt.dao;
import com.bst.ckt.action.PurchaseCementAction;
/*    2:     */ 
/*    3:     */ import com.bst.ckt.exception.OMIApplicationException;
/*    4:     */ import com.bst.ckt.framework.db.JdbcDAOSupport;
/*    5:     */ import com.bst.ckt.framework.util.DateTimeUtil;
/*    6:     */ import com.bst.ckt.helper.AppendHelper;
/*    7:     */ import com.bst.ckt.helper.AssignmentStatus;
/*    8:     */ import com.bst.ckt.helper.CasesStatus;
/*    9:     */ import com.bst.ckt.helper.FAQStatus;
/*   10:     */ import com.bst.ckt.helper.LeadStatus;
/*   11:     */ import com.bst.ckt.helper.NameHelper;
/*   12:     */ import com.bst.ckt.helper.Ratings;
/*   13:     */ import com.bst.ckt.helper.TicketPriority;
/*   14:     */ import com.bst.ckt.helper.TicketStatus;
/*   15:     */ import com.bst.ckt.helper.VendorStatus;
import com.bst.ckt.service.PurchaseCementServiceImpl;
/*   16:     */ import com.bst.ckt.vo.LeadVO;
/*   17:     */ import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
/*   18:     */ import java.io.PrintStream;
/*   19:     */ import java.sql.Connection;
/*   20:     */ import java.sql.PreparedStatement;
/*   21:     */ import java.sql.ResultSet;
/*   22:     */ import java.util.ArrayList;
/*   23:     */ import java.util.List;
/*   24:     */ import javax.servlet.ServletOutputStream;
/*   25:     */ import javax.servlet.http.HttpServletRequest;
/*   26:     */ import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
/*   27:     */ import org.apache.poi.hssf.usermodel.HSSFWorkbook;
/*   28:     */ import org.apache.poi.ss.usermodel.Cell;
/*   29:     */ import org.apache.poi.ss.usermodel.CellStyle;
/*   30:     */ import org.apache.poi.ss.usermodel.Font;
/*   31:     */ import org.apache.poi.ss.usermodel.Row;
/*   32:     */ import org.apache.poi.ss.usermodel.Sheet;
/*   33:     */ import org.apache.poi.ss.usermodel.Workbook;
import org.apache.struts2.ServletActionContext;
/*   34:     */ 
/*   35:     */ public class ExcelReportDaoImpl
/*   36:     */   extends JdbcDAOSupport
/*   37:     */   implements ExcelReportDaoInf
/*   38:     */ {
	 private static final Logger logger = Logger.getLogger(ExcelReportDaoImpl.class);
/*   39:  49 */   Connection connection = null;
/*   40:  50 */   PreparedStatement preparedStatement = null;
/*   41:  51 */   ResultSet resultSet = null;
/*   42:  52 */   LeadVO leadVO = null;
/*   43:  53 */   ExcelReportDaoImpl daoImpl = null;
/*   44:  54 */   NameHelper nameHelper = new NameHelper();
/*   45:     */   
/*   46:     */   public void retriveLeadExcelReport(HttpServletRequest request, HttpServletResponse response)
/*   47:     */   {
/*   48:     */     try
/*   49:     */     {
/*   50:  60 */       this.connection = getConnection();
/*   51:  61 */       String query = "SELECT * FROM TAB_LEAD_DETAILS";
/*   52:  62 */       this.preparedStatement = this.connection.prepareStatement(query);
/*   53:  63 */       this.resultSet = this.preparedStatement.executeQuery();
/*   54:  64 */       System.out.println("executeQuery");
/*   55:  65 */       int currentRow = 1;
/*   56:     */       
/*   57:  67 */       Workbook wb = new HSSFWorkbook();
/*   58:  68 */       Sheet spreadSheet = wb.createSheet("Lead List");
/*   59:     */       
/*   60:     */ 
/*   61:  71 */       Row row = spreadSheet.createRow(0);
/*   62:     */       
/*   63:     */ 
/*   64:  74 */       CellStyle headerCellStyle = wb.createCellStyle();
/*   65:  75 */       headerCellStyle.setFillForegroundColor((short)49);
/*   66:  76 */       headerCellStyle.setFillPattern((short)1);
/*   67:     */       
/*   68:  78 */       Font setFont = wb.createFont();
/*   69:  79 */       setFont.setFontHeightInPoints((short)11);
/*   70:  80 */       setFont.setColor((short)8);
/*   71:  81 */       setFont.setBoldweight((short)700);
/*   72:  82 */       headerCellStyle.setBorderBottom((short)1);
/*   73:  83 */       headerCellStyle.setFont(setFont);
/*   74:     */       
/*   75:     */ 
/*   76:  86 */       CellStyle dataCellStyle = wb.createCellStyle();
/*   77:  87 */       Font setDataFont = wb.createFont();
/*   78:  88 */       setDataFont.setColor((short)8);
/*   79:  89 */       dataCellStyle.setBorderBottom((short)0);
/*   80:  90 */       dataCellStyle.setFont(setDataFont);
/*   81:     */       
/*   82:  92 */       Cell cell = null;
/*   83:     */       
/*   84:  94 */       spreadSheet.setColumnWidth(0, 2560);
/*   85:  95 */       spreadSheet.setColumnWidth(1, 7680);
/*   86:  96 */       spreadSheet.setColumnWidth(2, 6400);
/*   87:  97 */       spreadSheet.setColumnWidth(3, 6400);
/*   88:  98 */       spreadSheet.setColumnWidth(4, 6400);
/*   89:  99 */       spreadSheet.setColumnWidth(5, 6400);
/*   90: 100 */       spreadSheet.setColumnWidth(6, 6400);
/*   91: 101 */       spreadSheet.setColumnWidth(7, 6400);
/*   92: 102 */       spreadSheet.setColumnWidth(8, 6400);
/*   93: 103 */       spreadSheet.setColumnWidth(9, 6400);
/*   94: 104 */       spreadSheet.setColumnWidth(10, 6400);
/*   95: 105 */       spreadSheet.setColumnWidth(11, 6400);
/*   96: 106 */       spreadSheet.setColumnWidth(12, 6400);
/*   97: 107 */       spreadSheet.setColumnWidth(13, 6400);
/*   98: 108 */       spreadSheet.setColumnWidth(14, 6400);
/*   99: 109 */       spreadSheet.setColumnWidth(15, 6400);
/*  100: 110 */       spreadSheet.setColumnWidth(16, 6400);
/*  101: 111 */       spreadSheet.setColumnWidth(17, 6400);
/*  102: 112 */       spreadSheet.setColumnWidth(18, 6400);
/*  103: 113 */       spreadSheet.setColumnWidth(19, 6400);
/*  104: 114 */       spreadSheet.setColumnWidth(20, 6400);
/*  105: 115 */       spreadSheet.setColumnWidth(21, 6400);
/*  106: 116 */       spreadSheet.setColumnWidth(22, 6400);
/*  107: 117 */       spreadSheet.setColumnWidth(23, 6400);
/*  108: 118 */       spreadSheet.setColumnWidth(24, 6400);
/*  109: 119 */       spreadSheet.setColumnWidth(25, 6400);
/*  110: 120 */       spreadSheet.setColumnWidth(26, 6400);
/*  111: 121 */       spreadSheet.setColumnWidth(27, 6400);
/*  112: 122 */       spreadSheet.setColumnWidth(28, 6400);
/*  113: 123 */       spreadSheet.setColumnWidth(29, 6400);
/*  114: 124 */       spreadSheet.setColumnWidth(30, 6400);
/*  115:     */       
/*  116: 126 */       cell = row.createCell(0);
/*  117: 127 */       cell.setCellValue("Lead Id");
/*  118: 128 */       cell.setCellStyle(headerCellStyle);
/*  119:     */       
/*  120: 130 */       cell = row.createCell(1);
/*  121: 131 */       cell.setCellValue("Company Name");
/*  122: 132 */       cell.setCellStyle(headerCellStyle);
/*  123:     */       
/*  124: 134 */       cell = row.createCell(2);
/*  125: 135 */       cell.setCellValue("Contact Person");
/*  126: 136 */       cell.setCellStyle(headerCellStyle);
/*  127:     */       
/*  128: 138 */       cell = row.createCell(3);
/*  129: 139 */       cell.setCellValue("Company Type");
/*  130: 140 */       cell.setCellStyle(headerCellStyle);
/*  131:     */       
/*  132: 142 */       cell = row.createCell(4);
/*  133: 143 */       cell.setCellValue("Company Category");
/*  134: 144 */       cell.setCellStyle(headerCellStyle);
/*  135:     */       
/*  136: 146 */       cell = row.createCell(5);
/*  137: 147 */       cell.setCellValue("Company Sector");
/*  138: 148 */       cell.setCellStyle(headerCellStyle);
/*  139:     */       
/*  140: 150 */       cell = row.createCell(6);
/*  141: 151 */       cell.setCellValue("Lead Source");
/*  142: 152 */       cell.setCellStyle(headerCellStyle);
/*  143:     */       
/*  144: 154 */       cell = row.createCell(7);
/*  145: 155 */       cell.setCellValue("Lead Source Name");
/*  146: 156 */       cell.setCellStyle(headerCellStyle);
/*  147:     */       
/*  148: 158 */       cell = row.createCell(8);
/*  149: 159 */       cell.setCellValue("Lead Status");
/*  150: 160 */       cell.setCellStyle(headerCellStyle);
/*  151:     */       
/*  152: 162 */       cell = row.createCell(9);
/*  153: 163 */       cell.setCellValue("No Of Associate");
/*  154: 164 */       cell.setCellStyle(headerCellStyle);
/*  155:     */       
/*  156: 166 */       cell = row.createCell(10);
/*  157: 167 */       cell.setCellValue("Annual Revanue");
/*  158: 168 */       cell.setCellStyle(headerCellStyle);
/*  159:     */       
/*  160: 170 */       cell = row.createCell(11);
/*  161: 171 */       cell.setCellValue("Lead Date");
/*  162: 172 */       cell.setCellStyle(headerCellStyle);
/*  163:     */       
/*  164: 174 */       cell = row.createCell(12);
/*  165: 175 */       cell.setCellValue("Expected Closing Date");
/*  166: 176 */       cell.setCellStyle(headerCellStyle);
/*  167:     */       
/*  168: 178 */       cell = row.createCell(13);
/*  169: 179 */       cell.setCellValue("Lead Owner");
/*  170: 180 */       cell.setCellStyle(headerCellStyle);
/*  171:     */       
/*  172: 182 */       cell = row.createCell(14);
/*  173: 183 */       cell.setCellValue("Ratings");
/*  174: 184 */       cell.setCellStyle(headerCellStyle);
/*  175:     */       
/*  176: 186 */       cell = row.createCell(15);
/*  177: 187 */       cell.setCellValue("Email Opt Out");
/*  178: 188 */       cell.setCellStyle(headerCellStyle);
/*  179:     */       
/*  180: 190 */       cell = row.createCell(16);
/*  181: 191 */       cell.setCellValue("Address Line 1");
/*  182: 192 */       cell.setCellStyle(headerCellStyle);
/*  183:     */       
/*  184: 194 */       cell = row.createCell(17);
/*  185: 195 */       cell.setCellValue("Address Line 2");
/*  186: 196 */       cell.setCellStyle(headerCellStyle);
/*  187:     */       
/*  188: 198 */       cell = row.createCell(18);
/*  189: 199 */       cell.setCellValue("City");
/*  190: 200 */       cell.setCellStyle(headerCellStyle);
/*  191:     */       
/*  192: 202 */       cell = row.createCell(19);
/*  193: 203 */       cell.setCellValue("State");
/*  194: 204 */       cell.setCellStyle(headerCellStyle);
/*  195:     */       
/*  196: 206 */       cell = row.createCell(20);
/*  197: 207 */       cell.setCellValue("Country");
/*  198: 208 */       cell.setCellStyle(headerCellStyle);
/*  199:     */       
/*  200: 210 */       cell = row.createCell(21);
/*  201: 211 */       cell.setCellValue("Zip Code");
/*  202: 212 */       cell.setCellStyle(headerCellStyle);
/*  203:     */       
/*  204: 214 */       cell = row.createCell(22);
/*  205: 215 */       cell.setCellValue("Phone No.");
/*  206: 216 */       cell.setCellStyle(headerCellStyle);
/*  207:     */       
/*  208: 218 */       cell = row.createCell(23);
/*  209: 219 */       cell.setCellValue("Mobile No.");
/*  210: 220 */       cell.setCellStyle(headerCellStyle);
/*  211:     */       
/*  212: 222 */       cell = row.createCell(24);
/*  213: 223 */       cell.setCellValue("Primary Email");
/*  214: 224 */       cell.setCellStyle(headerCellStyle);
/*  215:     */       
/*  216: 226 */       cell = row.createCell(25);
/*  217: 227 */       cell.setCellValue("Alternate Email");
/*  218: 228 */       cell.setCellStyle(headerCellStyle);
/*  219:     */       
/*  220: 230 */       cell = row.createCell(26);
/*  221: 231 */       cell.setCellValue("Fax");
/*  222: 232 */       cell.setCellStyle(headerCellStyle);
/*  223:     */       
/*  224: 234 */       cell = row.createCell(27);
/*  225: 235 */       cell.setCellValue("Website");
/*  226: 236 */       cell.setCellStyle(headerCellStyle);
/*  227:     */       
/*  228: 238 */       cell = row.createCell(28);
/*  229: 239 */       cell.setCellValue("Created Date");
/*  230: 240 */       cell.setCellStyle(headerCellStyle);
/*  231:     */       
/*  232: 242 */       cell = row.createCell(29);
/*  233: 243 */       cell.setCellValue("Created By");
/*  234: 244 */       cell.setCellStyle(headerCellStyle);
/*  235:     */       
/*  236: 246 */       cell = row.createCell(30);
/*  237: 247 */       cell.setCellValue("Requirment");
/*  238: 248 */       cell.setCellStyle(headerCellStyle);
/*  239:     */       
/*  240: 250 */       List<ExcelReportDaoImpl> li = new ArrayList();
/*  241: 251 */       while (this.resultSet.next())
/*  242:     */       {
/*  243: 253 */         this.daoImpl = new ExcelReportDaoImpl();
/*  244:     */         
/*  245:     */ 
/*  246: 256 */         row = spreadSheet.createRow(currentRow++);
/*  247:     */         
/*  248: 258 */         cell = row.createCell(0);
/*  249: 259 */         cell.setCellValue(this.resultSet.getString("LEAD_ID"));
/*  250: 260 */         cell.setCellStyle(dataCellStyle);
/*  251:     */         
/*  252: 262 */         cell = row.createCell(1);
/*  253: 263 */         cell.setCellValue(this.resultSet.getString("COMPANY_NAME"));
/*  254: 264 */         cell.setCellStyle(dataCellStyle);
/*  255:     */         
/*  256: 266 */         cell = row.createCell(2);
/*  257: 267 */         cell.setCellValue(AppendHelper.appendSalutaion(
/*  258: 268 */           this.resultSet.getInt("SALUTATION"), 
/*  259: 269 */           this.resultSet.getString("CONTACT_PERSON")));
/*  260: 270 */         cell.setCellStyle(dataCellStyle);
/*  261:     */         
/*  262: 272 */         cell = row.createCell(3);
/*  263: 273 */         cell.setCellValue(this.nameHelper.getCompanyTypeName(this.resultSet
/*  264: 274 */           .getInt("COMPANY_TYPE_REF")));
/*  265: 275 */         cell.setCellStyle(dataCellStyle);
/*  266:     */         
/*  267: 277 */         cell = row.createCell(4);
/*  268: 278 */         cell.setCellValue(this.nameHelper.getCompanyCategoryName(this.resultSet
/*  269: 279 */           .getInt("COMPANY_CATEGORY_REF")));
/*  270: 280 */         cell.setCellStyle(dataCellStyle);
/*  271:     */         
/*  272: 282 */         cell = row.createCell(5);
/*  273: 283 */         cell.setCellValue(this.nameHelper.getCompanySectorName(this.resultSet
/*  274: 284 */           .getInt("COMPANY_SECTOR_REF")));
/*  275: 285 */         cell.setCellStyle(dataCellStyle);
/*  276:     */         
/*  277: 287 */         cell = row.createCell(6);
/*  278: 288 */         cell.setCellValue(this.nameHelper.getLeadSourceName(this.resultSet
/*  279: 289 */           .getInt("LEAD_SOURCE_REF")));
/*  280: 290 */         cell.setCellStyle(dataCellStyle);
/*  281:     */         
/*  282: 292 */         cell = row.createCell(7);
/*  283: 293 */         cell.setCellValue(this.resultSet.getString("LEAD_SOURCE_NAME"));
/*  284: 294 */         cell.setCellStyle(dataCellStyle);
/*  285:     */         
/*  286: 296 */         cell = row.createCell(8);
/*  287: 297 */         cell.setCellValue(LeadStatus.getLeadStatus(this.resultSet
/*  288: 298 */           .getInt("LEAD_STATUS")));
/*  289: 299 */         cell.setCellStyle(dataCellStyle);
/*  290:     */         
/*  291: 301 */         cell = row.createCell(9);
/*  292: 302 */         cell.setCellValue(this.resultSet.getString("NUMBER_OF_ASSOCIATE"));
/*  293: 303 */         cell.setCellStyle(dataCellStyle);
/*  294:     */         
/*  295: 305 */         cell = row.createCell(10);
/*  296: 306 */         cell.setCellValue(this.resultSet.getString("ANNUAL_REVENUE"));
/*  297: 307 */         cell.setCellStyle(dataCellStyle);
/*  298:     */         
/*  299: 309 */         cell = row.createCell(11);
/*  300: 310 */         cell.setCellValue(this.resultSet.getString("LEAD_DATE"));
/*  301: 311 */         cell.setCellStyle(dataCellStyle);
/*  302:     */         
/*  303: 313 */         cell = row.createCell(12);
/*  304: 314 */         cell.setCellValue(this.resultSet.getString("EXPECTED_CLOSING_DATE"));
/*  305: 315 */         cell.setCellStyle(dataCellStyle);
/*  306:     */         
/*  307: 317 */         cell = row.createCell(13);
/*  308: 318 */         cell.setCellValue(this.nameHelper.getCustomerName(this.resultSet
/*  309: 319 */           .getInt("LEAD_OWNER_REF")));
/*  310: 320 */         cell.setCellStyle(dataCellStyle);
/*  311:     */         
/*  312: 322 */         cell = row.createCell(14);
/*  313: 323 */         cell.setCellValue(Ratings.getRatingName(this.resultSet
/*  314: 324 */           .getInt("RATING")));
/*  315: 325 */         cell.setCellStyle(dataCellStyle);
/*  316:     */         
/*  317: 327 */         cell = row.createCell(15);
/*  318: 328 */         cell.setCellValue(this.resultSet.getString("EMAIL_OPT_OUT"));
/*  319: 329 */         cell.setCellStyle(dataCellStyle);
/*  320:     */         
/*  321: 331 */         cell = row.createCell(16);
/*  322: 332 */         cell.setCellValue(this.resultSet.getString("ADDRESS_LINE_1"));
/*  323: 333 */         cell.setCellStyle(dataCellStyle);
/*  324:     */         
/*  325: 335 */         cell = row.createCell(17);
/*  326: 336 */         cell.setCellValue(this.resultSet.getString("ADDRESS_LINE_2"));
/*  327: 337 */         cell.setCellStyle(dataCellStyle);
/*  328:     */         
/*  329: 339 */         cell = row.createCell(18);
/*  330: 340 */         cell.setCellValue(this.resultSet.getString("CITY"));
/*  331: 341 */         cell.setCellStyle(dataCellStyle);
/*  332:     */         
/*  333: 343 */         cell = row.createCell(19);
/*  334: 344 */         cell.setCellValue(this.resultSet.getString("STATE"));
/*  335: 345 */         cell.setCellStyle(dataCellStyle);
/*  336:     */         
/*  337: 347 */         cell = row.createCell(20);
/*  338: 348 */         cell.setCellValue(this.nameHelper.getCountryName(this.resultSet
/*  339: 349 */           .getInt("COUNTRY_REF")));
/*  340: 350 */         cell.setCellStyle(dataCellStyle);
/*  341:     */         
/*  342: 352 */         cell = row.createCell(21);
/*  343: 353 */         cell.setCellValue(this.resultSet.getString("ZIPCODE"));
/*  344: 354 */         cell.setCellStyle(dataCellStyle);
/*  345:     */         
/*  346: 356 */         cell = row.createCell(22);
/*  347: 357 */         cell.setCellValue(AppendHelper.appendNumber(
/*  348: 358 */           this.resultSet.getString("PHONE_ISD"), 
/*  349: 359 */           this.resultSet.getString("PHONE_STD"), 
/*  350: 360 */           this.resultSet.getString("PHONE_NO")));
/*  351:     */         
/*  352: 362 */         cell.setCellStyle(dataCellStyle);
/*  353:     */         
/*  354: 364 */         cell = row.createCell(23);
/*  355: 365 */         cell.setCellValue(AppendHelper.appendNumber(
/*  356: 366 */           this.resultSet.getString("MOBILE_ISD"), 
/*  357: 367 */           this.resultSet.getString("MOBILE_NO")));
/*  358: 368 */         cell.setCellStyle(dataCellStyle);
/*  359:     */         
/*  360: 370 */         cell = row.createCell(24);
/*  361: 371 */         cell.setCellValue(this.resultSet.getString("PRIMARY_EMAIL_ID"));
/*  362: 372 */         cell.setCellStyle(dataCellStyle);
/*  363:     */         
/*  364: 374 */         cell = row.createCell(25);
/*  365: 375 */         cell.setCellValue(this.resultSet.getString("ALTERNATIVE_EMAIL_ID"));
/*  366: 376 */         cell.setCellStyle(dataCellStyle);
/*  367:     */         
/*  368: 378 */         cell = row.createCell(26);
/*  369: 379 */         cell.setCellValue(AppendHelper.appendNumber(
/*  370: 380 */           this.resultSet.getString("FAX_ISD"), 
/*  371: 381 */           this.resultSet.getString("FAX_STD"), 
/*  372: 382 */           this.resultSet.getString("FAX_NO")));
/*  373: 383 */         cell.setCellStyle(dataCellStyle);
/*  374:     */         
/*  375: 385 */         cell = row.createCell(27);
/*  376: 386 */         cell.setCellValue(this.resultSet.getString("WEBSITE"));
/*  377: 387 */         cell.setCellStyle(dataCellStyle);
/*  378:     */         
/*  379: 389 */         cell = row.createCell(28);
/*  380: 390 */         cell.setCellValue(
/*  381: 391 */           DateTimeUtil.convertDatetoFormDate(this.resultSet
/*  382: 392 */           .getString("CREATED_DATE")));
/*  383: 393 */         cell.setCellStyle(dataCellStyle);
/*  384:     */         
/*  385: 395 */         cell = row.createCell(29);
/*  386: 396 */         cell.setCellValue(this.nameHelper.getCustomerName(this.resultSet
/*  387: 397 */           .getInt("CREATED_BY")));
/*  388: 398 */         cell.setCellStyle(dataCellStyle);
/*  389:     */         
/*  390: 400 */         String temp = this.resultSet.getString("REQUIRMENT");
/*  391:     */         
/*  392: 402 */         cell = row.createCell(30);
/*  393: 403 */         cell.setCellValue(temp.replaceAll("\\<.*?\\>", " "));
/*  394: 404 */         cell.setCellStyle(dataCellStyle);
/*  395:     */         
/*  396: 406 */         li.add(this.daoImpl);
/*  397:     */       }
/*  398: 409 */       ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
/*  399: 410 */       wb.write(outByteStream);
/*  400: 411 */       byte[] outArray = outByteStream.toByteArray();
/*  401: 412 */       response.setContentType("application/ms-excel");
/*  402: 413 */       response.setContentLength(outArray.length);
/*  403: 414 */       response.setHeader("Expires:", "0");
/*  404: 415 */       response.setHeader("Content-Disposition", 
/*  405: 416 */         "attachment; filename=Lead_list.xls");
/*  406:     */       
/*  407:     */ 
/*  408: 419 */       ServletOutputStream fileOut = response.getOutputStream();
/*  409: 420 */       fileOut.write(outArray);
/*  410: 421 */       fileOut.flush();
/*  411: 422 */       fileOut.close();
/*  412:     */     }
/*  413:     */     catch (Exception e)
/*  414:     */     {
/*  415: 425 */       e.printStackTrace();
/*  416:     */     }
/*  417:     */   }
/*  418:     */   
/*  419:     */   public void retrivenoteExcelReport(HttpServletRequest request, HttpServletResponse response)
/*  420:     */   {
/*  421:     */     try
/*  422:     */     {
/*  423: 435 */       this.connection = getConnection();
/*  424: 436 */       String query = "SELECT * FROM TAB_NOTE";
/*  425: 437 */       this.preparedStatement = this.connection.prepareStatement(query);
/*  426: 438 */       this.resultSet = this.preparedStatement.executeQuery();
/*  427:     */       
/*  428: 440 */       int currentRow = 1;
/*  429:     */       
/*  430: 442 */       Workbook wb = new HSSFWorkbook();
/*  431: 443 */       Sheet spreadSheet = wb.createSheet("Note List");
/*  432:     */       
/*  433:     */ 
/*  434: 446 */       Row row = spreadSheet.createRow(0);
/*  435:     */       
/*  436:     */ 
/*  437: 449 */       CellStyle headerCellStyle = wb.createCellStyle();
/*  438: 450 */       headerCellStyle.setFillForegroundColor((short)49);
/*  439: 451 */       headerCellStyle.setFillPattern((short)1);
/*  440:     */       
/*  441: 453 */       Font setFont = wb.createFont();
/*  442: 454 */       setFont.setFontHeightInPoints((short)11);
/*  443: 455 */       setFont.setColor((short)8);
/*  444: 456 */       setFont.setBoldweight((short)700);
/*  445: 457 */       headerCellStyle.setBorderBottom((short)1);
/*  446: 458 */       headerCellStyle.setFont(setFont);
/*  447:     */       
/*  448:     */ 
/*  449: 461 */       CellStyle dataCellStyle = wb.createCellStyle();
/*  450: 462 */       Font setDataFont = wb.createFont();
/*  451: 463 */       setDataFont.setColor((short)8);
/*  452: 464 */       dataCellStyle.setBorderBottom((short)0);
/*  453: 465 */       dataCellStyle.setFont(setDataFont);
/*  454:     */       
/*  455: 467 */       Cell cell = null;
/*  456:     */       
/*  457: 469 */       spreadSheet.setColumnWidth(0, 2560);
/*  458: 470 */       spreadSheet.setColumnWidth(1, 7680);
/*  459: 471 */       spreadSheet.setColumnWidth(2, 6400);
/*  460: 472 */       spreadSheet.setColumnWidth(3, 6400);
/*  461: 473 */       spreadSheet.setColumnWidth(4, 6400);
/*  462: 474 */       spreadSheet.setColumnWidth(5, 6400);
/*  463: 475 */       spreadSheet.setColumnWidth(6, 6400);
/*  464: 476 */       spreadSheet.setColumnWidth(7, 6400);
/*  465:     */       
/*  466: 478 */       cell = row.createCell(0);
/*  467: 479 */       cell.setCellValue("Note Id");
/*  468: 480 */       cell.setCellStyle(headerCellStyle);
/*  469:     */       
/*  470: 482 */       cell = row.createCell(1);
/*  471: 483 */       cell.setCellValue("Note Title");
/*  472: 484 */       cell.setCellStyle(headerCellStyle);
/*  473:     */       
/*  474: 486 */       cell = row.createCell(2);
/*  475: 487 */       cell.setCellValue("Note Tag");
/*  476: 488 */       cell.setCellStyle(headerCellStyle);
/*  477:     */       
/*  478: 490 */       cell = row.createCell(3);
/*  479: 491 */       cell.setCellValue("Note Description");
/*  480: 492 */       cell.setCellStyle(headerCellStyle);
/*  481:     */       
/*  482: 494 */       cell = row.createCell(4);
/*  483: 495 */       cell.setCellValue("Created By");
/*  484: 496 */       cell.setCellStyle(headerCellStyle);
/*  485:     */       
/*  486: 498 */       cell = row.createCell(5);
/*  487: 499 */       cell.setCellValue("Created Date");
/*  488: 500 */       cell.setCellStyle(headerCellStyle);
/*  489:     */       
/*  490: 502 */       cell = row.createCell(6);
/*  491: 503 */       cell.setCellValue("Updated By");
/*  492: 504 */       cell.setCellStyle(headerCellStyle);
/*  493:     */       
/*  494: 506 */       cell = row.createCell(7);
/*  495: 507 */       cell.setCellValue("Updated Date");
/*  496: 508 */       cell.setCellStyle(headerCellStyle);
/*  497:     */       
/*  498: 510 */       List<ExcelReportDaoImpl> li = new ArrayList();
/*  499: 511 */       while (this.resultSet.next())
/*  500:     */       {
/*  501: 513 */         this.daoImpl = new ExcelReportDaoImpl();
/*  502:     */         
/*  503:     */ 
/*  504: 516 */         row = spreadSheet.createRow(currentRow++);
/*  505:     */         
/*  506: 518 */         cell = row.createCell(0);
/*  507: 519 */         cell.setCellValue(this.resultSet.getString("NOTE_ID"));
/*  508: 520 */         cell.setCellStyle(dataCellStyle);
/*  509:     */         
/*  510: 522 */         cell = row.createCell(1);
/*  511: 523 */         cell.setCellValue(this.resultSet.getString("NOTE_TITLE"));
/*  512: 524 */         cell.setCellStyle(dataCellStyle);
/*  513:     */         
/*  514: 526 */         cell = row.createCell(2);
/*  515: 527 */         cell.setCellValue(this.resultSet.getString("NOTE_TAG"));
/*  516: 528 */         cell.setCellStyle(dataCellStyle);
/*  517:     */         
/*  518: 530 */         cell = row.createCell(3);
/*  519: 531 */         cell.setCellValue(this.resultSet.getString("NOTE_DESC"));
/*  520: 532 */         cell.setCellStyle(dataCellStyle);
/*  521:     */         
/*  522: 534 */         cell = row.createCell(4);
/*  523: 535 */         cell.setCellValue(this.nameHelper.getNoteCreatedByName(this.resultSet
/*  524: 536 */           .getInt("CREATED_BY")));
/*  525: 537 */         cell.setCellStyle(dataCellStyle);
/*  526:     */         
/*  527: 539 */         cell = row.createCell(5);
/*  528: 540 */         cell.setCellValue(this.resultSet.getString("CREATION_DATE"));
/*  529: 541 */         cell.setCellStyle(dataCellStyle);
/*  530:     */         
/*  531: 543 */         cell = row.createCell(6);
/*  532: 544 */         cell.setCellValue(this.resultSet.getInt("UPDATED_BY"));
/*  533: 545 */         cell.setCellStyle(dataCellStyle);
/*  534:     */         
/*  535: 547 */         cell = row.createCell(7);
/*  536: 548 */         cell.setCellValue(this.nameHelper.getNoteCreatedByName(this.resultSet
/*  537: 549 */           .getInt("UPDATION_DATE")));
/*  538: 550 */         cell.setCellStyle(dataCellStyle);
/*  539:     */         
/*  540: 552 */         li.add(this.daoImpl);
/*  541:     */       }
/*  542: 555 */       ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
/*  543: 556 */       wb.write(outByteStream);
/*  544: 557 */       byte[] outArray = outByteStream.toByteArray();
/*  545: 558 */       response.setContentType("application/ms-excel");
/*  546: 559 */       response.setContentLength(outArray.length);
/*  547: 560 */       response.setHeader("Expires:", "0");
/*  548: 561 */       response.setHeader("Content-Disposition", 
/*  549: 562 */         "attachment; filename=Note_list.xls");
/*  550:     */       
/*  551:     */ 
/*  552: 565 */       ServletOutputStream fileOut = response.getOutputStream();
/*  553: 566 */       fileOut.write(outArray);
/*  554: 567 */       fileOut.flush();
/*  555: 568 */       fileOut.close();
/*  556:     */     }
/*  557:     */     catch (Exception e)
/*  558:     */     {
/*  559: 571 */       e.printStackTrace();
/*  560:     */     }
/*  561:     */   }
/*  562:     */   
/*  563:     */   public void retriveVendorExcelReport(HttpServletRequest request, HttpServletResponse response)
/*  564:     */     throws OMIApplicationException
/*  565:     */   {
/*  566:     */     try
/*  567:     */     {
/*  568: 582 */       this.connection = getConnection();
/*  569: 583 */       String query = "SELECT * FROM TAB_VENDORS";
/*  570: 584 */       this.preparedStatement = this.connection.prepareStatement(query);
/*  571: 585 */       this.resultSet = this.preparedStatement.executeQuery();
/*  572:     */       
/*  573: 587 */       int currentRow = 1;
/*  574:     */       
/*  575: 589 */       Workbook wb = new HSSFWorkbook();
/*  576: 590 */       Sheet spreadSheet = wb.createSheet("Note List");
/*  577:     */       
/*  578:     */ 
/*  579: 593 */       Row row = spreadSheet.createRow(0);
/*  580:     */       
/*  581:     */ 
/*  582: 596 */       CellStyle headerCellStyle = wb.createCellStyle();
/*  583: 597 */       headerCellStyle.setFillForegroundColor((short)49);
/*  584: 598 */       headerCellStyle.setFillPattern((short)1);
/*  585:     */       
/*  586: 600 */       Font setFont = wb.createFont();
/*  587: 601 */       setFont.setFontHeightInPoints((short)11);
/*  588: 602 */       setFont.setColor((short)8);
/*  589: 603 */       setFont.setBoldweight((short)700);
/*  590: 604 */       headerCellStyle.setBorderBottom((short)1);
/*  591: 605 */       headerCellStyle.setFont(setFont);
/*  592:     */       
/*  593:     */ 
/*  594: 608 */       CellStyle dataCellStyle = wb.createCellStyle();
/*  595: 609 */       Font setDataFont = wb.createFont();
/*  596: 610 */       setDataFont.setColor((short)8);
/*  597: 611 */       dataCellStyle.setBorderBottom((short)0);
/*  598: 612 */       dataCellStyle.setFont(setDataFont);
/*  599:     */       
/*  600: 614 */       Cell cell = null;
/*  601:     */       
/*  602: 616 */       spreadSheet.setColumnWidth(0, 2560);
/*  603: 617 */       spreadSheet.setColumnWidth(1, 7680);
/*  604: 618 */       spreadSheet.setColumnWidth(2, 6400);
/*  605: 619 */       spreadSheet.setColumnWidth(3, 6400);
/*  606: 620 */       spreadSheet.setColumnWidth(4, 6400);
/*  607: 621 */       spreadSheet.setColumnWidth(5, 6400);
/*  608: 622 */       spreadSheet.setColumnWidth(6, 6400);
/*  609: 623 */       spreadSheet.setColumnWidth(7, 6400);
/*  610:     */       
/*  611: 625 */       cell = row.createCell(0);
/*  612: 626 */       cell.setCellValue("Vendor Id");
/*  613: 627 */       cell.setCellStyle(headerCellStyle);
/*  614:     */       
/*  615: 629 */       cell = row.createCell(1);
/*  616: 630 */       cell.setCellValue("Vendor Name");
/*  617: 631 */       cell.setCellStyle(headerCellStyle);
/*  618:     */       
/*  619: 633 */       cell = row.createCell(2);
/*  620: 634 */       cell.setCellValue("GL Account");
/*  621: 635 */       cell.setCellStyle(headerCellStyle);
/*  622:     */       
/*  623: 637 */       cell = row.createCell(3);
/*  624: 638 */       cell.setCellValue("Vendor Category");
/*  625: 639 */       cell.setCellStyle(headerCellStyle);
/*  626:     */       
/*  627: 641 */       cell = row.createCell(4);
/*  628: 642 */       cell.setCellValue("Assigned To");
/*  629: 643 */       cell.setCellStyle(headerCellStyle);
/*  630:     */       
/*  631: 645 */       cell = row.createCell(5);
/*  632: 646 */       cell.setCellValue("Vendor Status");
/*  633: 647 */       cell.setCellStyle(headerCellStyle);
/*  634:     */       
/*  635: 649 */       cell = row.createCell(6);
/*  636: 650 */       cell.setCellValue("Vendor Flag");
/*  637: 651 */       cell.setCellStyle(headerCellStyle);
/*  638:     */       
/*  639: 653 */       cell = row.createCell(7);
/*  640: 654 */       cell.setCellValue("Address Line 1");
/*  641: 655 */       cell.setCellStyle(headerCellStyle);
/*  642:     */       
/*  643: 657 */       cell = row.createCell(8);
/*  644: 658 */       cell.setCellValue("Address Line 2");
/*  645: 659 */       cell.setCellStyle(headerCellStyle);
/*  646:     */       
/*  647: 661 */       cell = row.createCell(9);
/*  648: 662 */       cell.setCellValue("City");
/*  649: 663 */       cell.setCellStyle(headerCellStyle);
/*  650:     */       
/*  651: 665 */       cell = row.createCell(10);
/*  652: 666 */       cell.setCellValue("State");
/*  653: 667 */       cell.setCellStyle(headerCellStyle);
/*  654:     */       
/*  655: 669 */       cell = row.createCell(11);
/*  656: 670 */       cell.setCellValue("Country");
/*  657: 671 */       cell.setCellStyle(headerCellStyle);
/*  658:     */       
/*  659: 673 */       cell = row.createCell(12);
/*  660: 674 */       cell.setCellValue("Zip Code");
/*  661: 675 */       cell.setCellStyle(headerCellStyle);
/*  662:     */       
/*  663: 677 */       cell = row.createCell(13);
/*  664: 678 */       cell.setCellValue("Mobile No");
/*  665: 679 */       cell.setCellStyle(headerCellStyle);
/*  666:     */       
/*  667: 681 */       cell = row.createCell(14);
/*  668: 682 */       cell.setCellValue("Primary Email-Id");
/*  669: 683 */       cell.setCellStyle(headerCellStyle);
/*  670:     */       
/*  671: 685 */       cell = row.createCell(15);
/*  672: 686 */       cell.setCellValue("Alternate Email-Id");
/*  673: 687 */       cell.setCellStyle(headerCellStyle);
/*  674:     */       
/*  675: 689 */       cell = row.createCell(16);
/*  676: 690 */       cell.setCellValue("Website");
/*  677: 691 */       cell.setCellStyle(headerCellStyle);
/*  678:     */       
/*  679: 693 */       cell = row.createCell(17);
/*  680: 694 */       cell.setCellValue("Discription");
/*  681: 695 */       cell.setCellStyle(headerCellStyle);
/*  682:     */       
/*  683: 697 */       cell = row.createCell(18);
/*  684: 698 */       cell.setCellValue("Created By");
/*  685: 699 */       cell.setCellStyle(headerCellStyle);
/*  686:     */       
/*  687: 701 */       cell = row.createCell(19);
/*  688: 702 */       cell.setCellValue("Created Date");
/*  689: 703 */       cell.setCellStyle(headerCellStyle);
/*  690:     */       
/*  691: 705 */       cell = row.createCell(20);
/*  692: 706 */       cell.setCellValue("Updated By");
/*  693: 707 */       cell.setCellStyle(headerCellStyle);
/*  694:     */       
/*  695: 709 */       cell = row.createCell(21);
/*  696: 710 */       cell.setCellValue("Updated Date");
/*  697: 711 */       cell.setCellStyle(headerCellStyle);
/*  698:     */       
/*  699: 713 */       List<ExcelReportDaoImpl> li = new ArrayList();
/*  700: 714 */       while (this.resultSet.next())
/*  701:     */       {
/*  702: 716 */         this.daoImpl = new ExcelReportDaoImpl();
/*  703:     */         
/*  704:     */ 
/*  705: 719 */         row = spreadSheet.createRow(currentRow++);
/*  706:     */         
/*  707: 721 */         cell = row.createCell(0);
/*  708: 722 */         cell.setCellValue(this.resultSet.getInt("VENDOR_ID"));
/*  709: 723 */         cell.setCellStyle(dataCellStyle);
/*  710:     */         
/*  711: 725 */         cell = row.createCell(1);
/*  712: 726 */         cell.setCellValue(this.resultSet.getString("VENDOR_NAME"));
/*  713: 727 */         cell.setCellStyle(dataCellStyle);
/*  714:     */         
/*  715: 729 */         cell = row.createCell(2);
/*  716: 730 */         cell.setCellValue(this.nameHelper.getGlAccount(this.resultSet
/*  717: 731 */           .getInt("REF_GL_ACCOUNT")));
/*  718: 732 */         cell.setCellStyle(dataCellStyle);
/*  719:     */         
/*  720: 734 */         cell = row.createCell(3);
/*  721: 735 */         cell.setCellValue(this.nameHelper.getVendorCategory(this.resultSet
/*  722: 736 */           .getInt("REF_VENDOR_CATEGORY")));
/*  723: 737 */         cell.setCellStyle(dataCellStyle);
/*  724:     */         
/*  725: 739 */         cell = row.createCell(4);
/*  726: 740 */         cell.setCellValue(this.nameHelper.getAssignTo(this.resultSet
/*  727: 741 */           .getInt("REF_ASSIGNED_TO")));
/*  728: 742 */         cell.setCellStyle(dataCellStyle);
/*  729:     */         
/*  730: 744 */         cell = row.createCell(5);
/*  731: 745 */         cell.setCellValue(VendorStatus.getUserStatus(this.resultSet
/*  732: 746 */           .getInt("VENDOR_STATUS")));
/*  733: 747 */         cell.setCellStyle(dataCellStyle);
/*  734:     */         
/*  735: 749 */         cell = row.createCell(6);
/*  736: 750 */         cell.setCellValue(this.resultSet.getString("VENDORS_FLAG"));
/*  737: 751 */         cell.setCellStyle(dataCellStyle);
/*  738:     */         
/*  739: 753 */         cell = row.createCell(7);
/*  740: 754 */         cell.setCellValue(this.resultSet.getString("ADDRESS_LINE_1"));
/*  741: 755 */         cell.setCellStyle(dataCellStyle);
/*  742:     */         
/*  743: 757 */         cell = row.createCell(8);
/*  744: 758 */         cell.setCellValue(this.resultSet.getString("ADDRESS_LINE_2"));
/*  745: 759 */         cell.setCellStyle(dataCellStyle);
/*  746:     */         
/*  747: 761 */         cell = row.createCell(9);
/*  748: 762 */         cell.setCellValue(this.resultSet.getString("CITY"));
/*  749: 763 */         cell.setCellStyle(dataCellStyle);
/*  750:     */         
/*  751: 765 */         cell = row.createCell(10);
/*  752: 766 */         cell.setCellValue(this.resultSet.getString("STATE"));
/*  753: 767 */         cell.setCellStyle(dataCellStyle);
/*  754:     */         
/*  755: 769 */         cell = row.createCell(11);
/*  756: 770 */         cell.setCellValue(this.resultSet.getString("VENDORS_FLAG"));
/*  757: 771 */         cell.setCellStyle(dataCellStyle);
/*  758:     */         
/*  759: 773 */         cell = row.createCell(12);
/*  760: 774 */         cell.setCellValue(this.nameHelper.getCountryName(this.resultSet
/*  761: 775 */           .getInt("REF_COUNTRY")));
/*  762: 776 */         cell.setCellStyle(dataCellStyle);
/*  763:     */         
/*  764: 778 */         cell = row.createCell(13);
/*  765: 779 */         cell.setCellValue(this.resultSet.getString("MOBILE_NO"));
/*  766: 780 */         cell.setCellStyle(dataCellStyle);
/*  767:     */         
/*  768: 782 */         cell = row.createCell(14);
/*  769: 783 */         cell.setCellValue(this.resultSet.getString("PRIMARY_EMAIL_ID"));
/*  770: 784 */         cell.setCellStyle(dataCellStyle);
/*  771:     */         
/*  772: 786 */         cell = row.createCell(15);
/*  773: 787 */         cell.setCellValue(this.resultSet.getString("ALTERNATIVE_EMAIL_ID"));
/*  774: 788 */         cell.setCellStyle(dataCellStyle);
/*  775:     */         
/*  776: 790 */         cell = row.createCell(16);
/*  777: 791 */         cell.setCellValue(this.resultSet.getString("WEBSITE"));
/*  778: 792 */         cell.setCellStyle(dataCellStyle);
/*  779:     */         
/*  780: 794 */         cell = row.createCell(17);
/*  781: 795 */         cell.setCellValue(this.resultSet.getString("DESCRIPTION"));
/*  782: 796 */         cell.setCellStyle(dataCellStyle);
/*  783:     */         
/*  784: 798 */         cell = row.createCell(18);
/*  785: 799 */         cell.setCellValue(this.nameHelper.getNoteCreatedByName(this.resultSet
/*  786: 800 */           .getInt("CREATED_BY")));
/*  787: 801 */         cell.setCellStyle(dataCellStyle);
/*  788:     */         
/*  789: 803 */         cell = row.createCell(19);
/*  790: 804 */         cell.setCellValue(this.resultSet.getString("CREATED_DATE"));
/*  791: 805 */         cell.setCellStyle(dataCellStyle);
/*  792:     */         
/*  793: 807 */         cell = row.createCell(20);
/*  794: 808 */         cell.setCellValue(this.resultSet.getInt("UPDATED_BY"));
/*  795: 809 */         cell.setCellStyle(dataCellStyle);
/*  796:     */         
/*  797: 811 */         cell = row.createCell(21);
/*  798: 812 */         cell.setCellValue(this.resultSet.getString("UPDATED_DATE"));
/*  799: 813 */         cell.setCellStyle(dataCellStyle);
/*  800:     */         
/*  801: 815 */         li.add(this.daoImpl);
/*  802:     */       }
/*  803: 818 */       ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
/*  804: 819 */       wb.write(outByteStream);
/*  805: 820 */       byte[] outArray = outByteStream.toByteArray();
/*  806: 821 */       response.setContentType("application/ms-excel");
/*  807: 822 */       response.setContentLength(outArray.length);
/*  808: 823 */       response.setHeader("Expires:", "0");
/*  809: 824 */       response.setHeader("Content-Disposition", 
/*  810: 825 */         "attachment; filename=vendor_list.xls");
/*  811:     */       
/*  812:     */ 
/*  813: 828 */       ServletOutputStream fileOut = response.getOutputStream();
/*  814: 829 */       fileOut.write(outArray);
/*  815: 830 */       fileOut.flush();
/*  816: 831 */       fileOut.close();
/*  817:     */     }
/*  818:     */     catch (Exception e)
/*  819:     */     {
/*  820: 834 */       e.printStackTrace();
/*  821:     */     }
/*  822:     */   }
/*  823:     */   
/*  824:     */   public void retriveCampaignExcelReport(HttpServletRequest request, HttpServletResponse response)
/*  825:     */   {
/*  826:     */     try
/*  827:     */     {
/*  828: 844 */       System.out.println("try");
/*  829: 845 */       this.connection = getConnection();
/*  830: 846 */       String query = "SELECT * FROM TAB_CAMPAIGN";
/*  831: 847 */       this.preparedStatement = this.connection.prepareStatement(query);
/*  832: 848 */       this.resultSet = this.preparedStatement.executeQuery();
/*  833: 849 */       System.out.println("executeQuery");
/*  834: 850 */       int currentRow = 1;
/*  835:     */       
/*  836: 852 */       Workbook wb = new HSSFWorkbook();
/*  837: 853 */       Sheet spreadSheet = wb.createSheet("CAMPAIGN LIST");
/*  838:     */       
/*  839:     */ 
/*  840: 856 */       Row row = spreadSheet.createRow(0);
/*  841:     */       
/*  842:     */ 
/*  843: 859 */       CellStyle headerCellStyle = wb.createCellStyle();
/*  844: 860 */       headerCellStyle.setFillForegroundColor((short)49);
/*  845: 861 */       headerCellStyle.setFillPattern((short)1);
/*  846:     */       
/*  847: 863 */       Font setFont = wb.createFont();
/*  848: 864 */       setFont.setFontHeightInPoints((short)11);
/*  849: 865 */       setFont.setColor((short)8);
/*  850: 866 */       setFont.setBoldweight((short)700);
/*  851: 867 */       headerCellStyle.setBorderBottom((short)1);
/*  852: 868 */       headerCellStyle.setFont(setFont);
/*  853:     */       
/*  854:     */ 
/*  855: 871 */       CellStyle dataCellStyle = wb.createCellStyle();
/*  856: 872 */       Font setDataFont = wb.createFont();
/*  857: 873 */       setDataFont.setColor((short)8);
/*  858: 874 */       dataCellStyle.setBorderBottom((short)0);
/*  859: 875 */       dataCellStyle.setFont(setDataFont);
/*  860:     */       
/*  861: 877 */       Cell cell = null;
/*  862:     */       
/*  863: 879 */       spreadSheet.setColumnWidth(0, 2560);
/*  864: 880 */       spreadSheet.setColumnWidth(1, 7680);
/*  865: 881 */       spreadSheet.setColumnWidth(2, 6400);
/*  866: 882 */       spreadSheet.setColumnWidth(3, 6400);
/*  867: 883 */       spreadSheet.setColumnWidth(4, 6400);
/*  868: 884 */       spreadSheet.setColumnWidth(5, 6400);
/*  869:     */       
/*  870: 886 */       cell = row.createCell(0);
/*  871: 887 */       cell.setCellValue("CAMPAIGN ID");
/*  872: 888 */       cell.setCellStyle(headerCellStyle);
/*  873:     */       
/*  874: 890 */       cell = row.createCell(1);
/*  875: 891 */       cell.setCellValue("CAMPAIGN NAME");
/*  876: 892 */       cell.setCellStyle(headerCellStyle);
/*  877:     */       
/*  878: 894 */       cell = row.createCell(2);
/*  879: 895 */       cell.setCellValue("CAMPAIGN TYPE");
/*  880: 896 */       cell.setCellStyle(headerCellStyle);
/*  881:     */       
/*  882: 898 */       cell = row.createCell(3);
/*  883: 899 */       cell.setCellValue("ASSIGN TO");
/*  884: 900 */       cell.setCellStyle(headerCellStyle);
/*  885:     */       
/*  886: 902 */       cell = row.createCell(4);
/*  887: 903 */       cell.setCellValue("EXPECTED REVENUE");
/*  888: 904 */       cell.setCellStyle(headerCellStyle);
/*  889:     */       
/*  890: 906 */       cell = row.createCell(5);
/*  891: 907 */       cell.setCellValue("Status");
/*  892: 908 */       cell.setCellStyle(headerCellStyle);
/*  893:     */       
/*  894: 910 */       List<ExcelReportDaoImpl> ai = new ArrayList();
/*  895: 911 */       while (this.resultSet.next())
/*  896:     */       {
/*  897: 913 */         this.daoImpl = new ExcelReportDaoImpl();
/*  898:     */         
/*  899:     */ 
/*  900: 916 */         row = spreadSheet.createRow(currentRow++);
/*  901:     */         
/*  902: 918 */         cell = row.createCell(0);
/*  903: 919 */         cell.setCellValue(this.resultSet.getString("CAMPAIGN_ID"));
/*  904: 920 */         cell.setCellStyle(dataCellStyle);
/*  905:     */         
/*  906: 922 */         cell = row.createCell(1);
/*  907: 923 */         cell.setCellValue(this.resultSet.getString("CAMPAIGN_NAME"));
/*  908: 924 */         cell.setCellStyle(dataCellStyle);
/*  909:     */         
/*  910: 926 */         cell = row.createCell(2);
/*  911: 927 */         cell.setCellValue(AppendHelper.appendSalutaion(
/*  912: 928 */           this.resultSet.getInt("SALUTATION"), 
/*  913: 929 */           this.resultSet.getString("CAMPAIGN_NAME")));
/*  914:     */         
/*  915: 931 */         cell.setCellStyle(dataCellStyle);
/*  916: 932 */         cell = row.createCell(3);
/*  917: 933 */         cell.setCellValue(this.resultSet.getString("REF_CAMPAIGN_TYPE"));
/*  918: 934 */         cell.setCellStyle(dataCellStyle);
/*  919:     */         
/*  920: 936 */         cell.setCellStyle(dataCellStyle);
/*  921: 937 */         cell = row.createCell(4);
/*  922: 938 */         cell.setCellValue(this.resultSet.getString("REF_ASSIGNED_TO"));
/*  923: 939 */         cell.setCellStyle(dataCellStyle);
/*  924:     */         
/*  925: 941 */         cell.setCellStyle(dataCellStyle);
/*  926: 942 */         cell = row.createCell(5);
/*  927: 943 */         cell.setCellValue(this.resultSet.getString("EXPECTED_REVENUE"));
/*  928: 944 */         cell.setCellStyle(dataCellStyle);
/*  929:     */         
/*  930: 946 */         ai.add(this.daoImpl);
/*  931:     */       }
/*  932: 949 */       ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
/*  933: 950 */       wb.write(outByteStream);
/*  934: 951 */       byte[] outArray = outByteStream.toByteArray();
/*  935: 952 */       response.setContentType("campaign/ms-excel");
/*  936: 953 */       response.setContentLength(outArray.length);
/*  937: 954 */       response.setHeader("Expires:", "0");
/*  938: 955 */       response.setHeader("Content-Disposition", 
/*  939: 956 */         "attachment; filename=Campaign_list.xls");
/*  940:     */       
/*  941:     */ 
/*  942: 959 */       ServletOutputStream fileOut = response.getOutputStream();
/*  943: 960 */       fileOut.write(outArray);
/*  944: 961 */       fileOut.flush();
/*  945: 962 */       fileOut.close();
/*  946:     */     }
/*  947:     */     catch (Exception e)
/*  948:     */     {
/*  949: 965 */       e.printStackTrace();
/*  950:     */     }
/*  951:     */   }
/*  952:     */   
/*  953:     */   public void retriveCasesExcelReport(HttpServletRequest request, HttpServletResponse response)
/*  954:     */     throws Exception
/*  955:     */   {
/*  956:     */     try
/*  957:     */     {
/*  958: 985 */       this.connection = getConnection();
/*  959: 986 */       String query = "SELECT * FROM TAB_SUPPORT_CASES";
/*  960: 987 */       this.preparedStatement = this.connection.prepareStatement(query);
/*  961: 988 */       this.resultSet = this.preparedStatement.executeQuery();
/*  962:     */       
/*  963: 990 */       int currentRow = 1;
/*  964:     */       
/*  965: 992 */       Workbook wb = new HSSFWorkbook();
/*  966: 993 */       Sheet spreadSheet = wb.createSheet("Cases List");
/*  967:     */       
/*  968:     */ 
/*  969: 996 */       Row row = spreadSheet.createRow(0);
/*  970:     */       
/*  971:     */ 
/*  972: 999 */       CellStyle headerCellStyle = wb.createCellStyle();
/*  973:1000 */       headerCellStyle.setFillForegroundColor((short)49);
/*  974:1001 */       headerCellStyle.setFillPattern((short)1);
/*  975:     */       
/*  976:1003 */       Font setFont = wb.createFont();
/*  977:1004 */       setFont.setFontHeightInPoints((short)11);
/*  978:1005 */       setFont.setColor((short)8);
/*  979:1006 */       setFont.setBoldweight((short)700);
/*  980:1007 */       headerCellStyle.setBorderBottom((short)1);
/*  981:1008 */       headerCellStyle.setFont(setFont);
/*  982:     */       
/*  983:     */ 
/*  984:1011 */       CellStyle dataCellStyle = wb.createCellStyle();
/*  985:1012 */       Font setDataFont = wb.createFont();
/*  986:1013 */       setDataFont.setColor((short)8);
/*  987:1014 */       dataCellStyle.setBorderBottom((short)0);
/*  988:1015 */       dataCellStyle.setFont(setDataFont);
/*  989:     */       
/*  990:1017 */       Cell cell = null;
/*  991:     */       
/*  992:1019 */       spreadSheet.setColumnWidth(0, 2560);
/*  993:1020 */       spreadSheet.setColumnWidth(1, 7680);
/*  994:1021 */       spreadSheet.setColumnWidth(2, 6400);
/*  995:1022 */       spreadSheet.setColumnWidth(3, 6400);
/*  996:1023 */       spreadSheet.setColumnWidth(4, 6400);
/*  997:1024 */       spreadSheet.setColumnWidth(5, 6400);
/*  998:1025 */       spreadSheet.setColumnWidth(6, 6400);
/*  999:1026 */       spreadSheet.setColumnWidth(7, 6400);
/* 1000:1027 */       spreadSheet.setColumnWidth(8, 6400);
/* 1001:1028 */       spreadSheet.setColumnWidth(9, 6400);
/* 1002:1029 */       spreadSheet.setColumnWidth(10, 6400);
/* 1003:1030 */       spreadSheet.setColumnWidth(11, 6400);
/* 1004:1031 */       spreadSheet.setColumnWidth(12, 6400);
/* 1005:1032 */       spreadSheet.setColumnWidth(13, 6400);
/* 1006:1033 */       spreadSheet.setColumnWidth(14, 6400);
/* 1007:1034 */       spreadSheet.setColumnWidth(15, 6400);
/* 1008:1035 */       spreadSheet.setColumnWidth(16, 6400);
/* 1009:1036 */       spreadSheet.setColumnWidth(17, 6400);
/* 1010:     */       
/* 1011:1038 */       cell = row.createCell(0);
/* 1012:1039 */       cell.setCellValue("Case Id");
/* 1013:1040 */       cell.setCellStyle(headerCellStyle);
/* 1014:     */       
/* 1015:1042 */       cell = row.createCell(1);
/* 1016:1043 */       cell.setCellValue("Case Title");
/* 1017:1044 */       cell.setCellStyle(headerCellStyle);
/* 1018:     */       
/* 1019:1046 */       cell = row.createCell(2);
/* 1020:1047 */       cell.setCellValue("Case Status");
/* 1021:1048 */       cell.setCellStyle(headerCellStyle);
/* 1022:     */       
/* 1023:1050 */       cell = row.createCell(3);
/* 1024:1051 */       cell.setCellValue("Case Priority");
/* 1025:1052 */       cell.setCellStyle(headerCellStyle);
/* 1026:     */       
/* 1027:1054 */       cell = row.createCell(4);
/* 1028:1055 */       cell.setCellValue("Contact Name");
/* 1029:1056 */       cell.setCellStyle(headerCellStyle);
/* 1030:     */       
/* 1031:1058 */       cell = row.createCell(5);
/* 1032:1059 */       cell.setCellValue("SLA Name ");
/* 1033:1060 */       cell.setCellStyle(headerCellStyle);
/* 1034:     */       
/* 1035:1062 */       cell = row.createCell(6);
/* 1036:1063 */       cell.setCellValue("Organization");
/* 1037:1064 */       cell.setCellStyle(headerCellStyle);
/* 1038:     */       
/* 1039:1066 */       cell = row.createCell(7);
/* 1040:1067 */       cell.setCellValue("Assign To");
/* 1041:1068 */       cell.setCellStyle(headerCellStyle);
/* 1042:     */       
/* 1043:1070 */       cell = row.createCell(8);
/* 1044:1071 */       cell.setCellValue("Cases Team");
/* 1045:1072 */       cell.setCellStyle(headerCellStyle);
/* 1046:     */       
/* 1047:1074 */       cell = row.createCell(9);
/* 1048:1075 */       cell.setCellValue("Product Name");
/* 1049:1076 */       cell.setCellStyle(headerCellStyle);
/* 1050:     */       
/* 1051:1078 */       cell = row.createCell(10);
/* 1052:1079 */       cell.setCellValue("Channel Name");
/* 1053:1080 */       cell.setCellStyle(headerCellStyle);
/* 1054:     */       
/* 1055:1082 */       cell = row.createCell(11);
/* 1056:1083 */       cell.setCellValue("Resolution");
/* 1057:1084 */       cell.setCellStyle(headerCellStyle);
/* 1058:     */       
/* 1059:1086 */       cell = row.createCell(12);
/* 1060:1087 */       cell.setCellValue("Primary Email");
/* 1061:1088 */       cell.setCellStyle(headerCellStyle);
/* 1062:     */       
/* 1063:1090 */       cell = row.createCell(13);
/* 1064:1091 */       cell.setCellValue("Impact Type");
/* 1065:1092 */       cell.setCellStyle(headerCellStyle);
/* 1066:     */       
/* 1067:1094 */       cell = row.createCell(14);
/* 1068:1095 */       cell.setCellValue("Impact Area");
/* 1069:1096 */       cell.setCellStyle(headerCellStyle);
/* 1070:     */       
/* 1071:1098 */       cell = row.createCell(15);
/* 1072:1099 */       cell.setCellValue("Resolution Type");
/* 1073:1100 */       cell.setCellStyle(headerCellStyle);
/* 1074:     */       
/* 1075:1102 */       cell = row.createCell(16);
/* 1076:1103 */       cell.setCellValue("Deffered Date");
/* 1077:1104 */       cell.setCellStyle(headerCellStyle);
/* 1078:     */       
/* 1079:1106 */       List<ExcelReportDaoImpl> li = new ArrayList();
/* 1080:1107 */       while (this.resultSet.next())
/* 1081:     */       {
/* 1082:1109 */         this.daoImpl = new ExcelReportDaoImpl();
/* 1083:     */         
/* 1084:     */ 
/* 1085:1112 */         row = spreadSheet.createRow(currentRow++);
/* 1086:     */         
/* 1087:1114 */         cell = row.createCell(0);
/* 1088:1115 */         cell.setCellValue(this.resultSet.getString("CASES_ID"));
/* 1089:1116 */         cell.setCellStyle(dataCellStyle);
/* 1090:     */         
/* 1091:1118 */         cell = row.createCell(1);
/* 1092:1119 */         cell.setCellValue(this.resultSet.getString("CASES_TITLE"));
/* 1093:1120 */         cell.setCellStyle(dataCellStyle);
/* 1094:     */         
/* 1095:1122 */         cell = row.createCell(2);
/* 1096:1123 */         cell.setCellValue(CasesStatus.getCASESStatus(this.resultSet
/* 1097:1124 */           .getInt("CASES_STATUS")));
/* 1098:1125 */         cell.setCellStyle(dataCellStyle);
/* 1099:     */         
/* 1100:1127 */         cell = row.createCell(3);
/* 1101:1128 */         cell.setCellValue(TicketPriority.getTicketPriority(this.resultSet
/* 1102:1129 */           .getInt("REF_CASES_PRIORITY")));
/* 1103:1130 */         cell.setCellStyle(dataCellStyle);
/* 1104:     */         
/* 1105:1132 */         cell = row.createCell(4);
/* 1106:1133 */         cell.setCellValue(TicketPriority.getTicketPriority(this.resultSet
/* 1107:1134 */           .getInt("CONTACT_NAME")));
/* 1108:1135 */         cell.setCellStyle(dataCellStyle);
/* 1109:     */         
/* 1110:1137 */         cell = row.createCell(5);
/* 1111:1138 */         cell.setCellValue(this.nameHelper.getCasesSlaName(this.resultSet
/* 1112:1139 */           .getInt("SLA_NAME")));
/* 1113:1140 */         cell.setCellStyle(dataCellStyle);
/* 1114:     */         
/* 1115:1142 */         cell = row.createCell(6);
/* 1116:1143 */         cell.setCellValue(this.nameHelper.getCasesOrgnization(this.resultSet
/* 1117:1144 */           .getInt("ORGANIZATION_NAME")));
/* 1118:1145 */         cell.setCellStyle(dataCellStyle);
/* 1119:     */         
/* 1120:1147 */         cell = row.createCell(7);
/* 1121:1148 */         cell.setCellValue(this.nameHelper.getAssignTo(this.resultSet
/* 1122:1149 */           .getInt("REF_CASES_ASSIGNED_TO")));
/* 1123:1150 */         cell.setCellStyle(dataCellStyle);
/* 1124:     */         
/* 1125:1152 */         cell = row.createCell(8);
/* 1126:1153 */         cell.setCellValue(this.nameHelper.getCasesTeam(this.resultSet
/* 1127:1154 */           .getInt("REF_CASES_TEAM")));
/* 1128:1155 */         cell.setCellStyle(dataCellStyle);
/* 1129:     */         
/* 1130:1157 */         cell = row.createCell(9);
/* 1131:1158 */         cell.setCellValue(this.nameHelper.getTicketProductName(this.resultSet
/* 1132:1159 */           .getInt("PRODUCT_NAME")));
/* 1133:1160 */         cell.setCellStyle(dataCellStyle);
/* 1134:     */         
/* 1135:1162 */         cell = row.createCell(10);
/* 1136:1163 */         cell.setCellValue(this.nameHelper.getCasesChannel(this.resultSet
/* 1137:1164 */           .getInt("REF_CASES_CHANNEL")));
/* 1138:1165 */         cell.setCellStyle(dataCellStyle);
/* 1139:     */         
/* 1140:1167 */         String temp = this.resultSet.getString("RESOLUTION");
/* 1141:     */         
/* 1142:1169 */         cell = row.createCell(11);
/* 1143:1170 */         cell.setCellValue(temp.replaceAll("\\<.*?\\>", " "));
/* 1144:1171 */         cell.setCellStyle(dataCellStyle);
/* 1145:     */         
/* 1146:1173 */         cell = row.createCell(12);
/* 1147:1174 */         cell.setCellValue(this.resultSet.getString("PRIMARY_EMAIL"));
/* 1148:1175 */         cell.setCellStyle(dataCellStyle);
/* 1149:     */         
/* 1150:1177 */         cell = row.createCell(13);
/* 1151:1178 */         cell.setCellValue(this.nameHelper.getCasesImpactType(this.resultSet
/* 1152:1179 */           .getInt("REF_CASES_IMPACT_TYPE")));
/* 1153:1180 */         cell.setCellStyle(dataCellStyle);
/* 1154:     */         
/* 1155:1182 */         cell = row.createCell(14);
/* 1156:1183 */         cell.setCellValue(this.nameHelper.getCasesImpactArea(this.resultSet
/* 1157:1184 */           .getInt("REF_CASES_IMPACT_AREA")));
/* 1158:1185 */         cell.setCellStyle(dataCellStyle);
/* 1159:     */         
/* 1160:1187 */         cell = row.createCell(15);
/* 1161:1188 */         cell.setCellValue(this.nameHelper.getCasesResolutionType(this.resultSet
/* 1162:1189 */           .getInt("REF_CASES_RESOLUTION_TYPE")));
/* 1163:1190 */         cell.setCellStyle(dataCellStyle);
/* 1164:     */         
/* 1165:1192 */         cell = row.createCell(16);
/* 1166:1193 */         cell.setCellValue(this.resultSet.getString("DEFERRD_DATE"));
/* 1167:1194 */         cell.setCellStyle(dataCellStyle);
/* 1168:     */         
/* 1169:1196 */         li.add(this.daoImpl);
/* 1170:     */       }
/* 1171:1199 */       ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
/* 1172:1200 */       wb.write(outByteStream);
/* 1173:1201 */       byte[] outArray = outByteStream.toByteArray();
/* 1174:1202 */       response.setContentType("application/ms-excel");
/* 1175:1203 */       response.setContentLength(outArray.length);
/* 1176:1204 */       response.setHeader("Expires:", "0");
/* 1177:1205 */       response.setHeader("Content-Disposition", 
/* 1178:1206 */         "attachment; filename=Cases_list.xls");
/* 1179:     */       
/* 1180:     */ 
/* 1181:1209 */       ServletOutputStream fileOut = response.getOutputStream();
/* 1182:1210 */       fileOut.write(outArray);
/* 1183:1211 */       fileOut.flush();
/* 1184:1212 */       fileOut.close();
/* 1185:     */     }
/* 1186:     */     catch (Exception e)
/* 1187:     */     {
/* 1188:1215 */       e.printStackTrace();
/* 1189:     */     }
/* 1190:     */   }
/* 1191:     */   
/* 1192:     */   public void retriveProductExcelReport(HttpServletRequest request, HttpServletResponse response)
/* 1193:     */     throws Exception
/* 1194:     */   {
/* 1195:     */     try
/* 1196:     */     {
/* 1197:1225 */       System.out.println("try");
/* 1198:1226 */       this.connection = getConnection();
/* 1199:1227 */       String query = "SELECT * FROM TAB_PRODUCT_DETAILS";
/* 1200:1228 */       this.preparedStatement = this.connection.prepareStatement(query);
/* 1201:1229 */       this.resultSet = this.preparedStatement.executeQuery();
/* 1202:1230 */       System.out.println("executeQuery");
/* 1203:1231 */       int currentRow = 1;
/* 1204:     */       
/* 1205:1233 */       Workbook wb = new HSSFWorkbook();
/* 1206:1234 */       Sheet spreadSheet = wb.createSheet("Product List");
/* 1207:     */       
/* 1208:     */ 
/* 1209:1237 */       Row row = spreadSheet.createRow(0);
/* 1210:     */       
/* 1211:     */ 
/* 1212:1240 */       CellStyle headerCellStyle = wb.createCellStyle();
/* 1213:1241 */       headerCellStyle.setFillForegroundColor((short)49);
/* 1214:1242 */       headerCellStyle.setFillPattern((short)1);
/* 1215:     */       
/* 1216:1244 */       Font setFont = wb.createFont();
/* 1217:1245 */       setFont.setFontHeightInPoints((short)11);
/* 1218:1246 */       setFont.setColor((short)8);
/* 1219:1247 */       setFont.setBoldweight((short)700);
/* 1220:1248 */       headerCellStyle.setBorderBottom((short)1);
/* 1221:1249 */       headerCellStyle.setFont(setFont);
/* 1222:     */       
/* 1223:     */ 
/* 1224:1252 */       CellStyle dataCellStyle = wb.createCellStyle();
/* 1225:1253 */       Font setDataFont = wb.createFont();
/* 1226:1254 */       setDataFont.setColor((short)9);
/* 1227:1255 */       dataCellStyle.setBorderBottom((short)0);
/* 1228:1256 */       dataCellStyle.setFont(setDataFont);
/* 1229:     */       
/* 1230:1258 */       Cell cell = null;
/* 1231:     */       
/* 1232:1260 */       spreadSheet.setColumnWidth(0, 2560);
/* 1233:1261 */       spreadSheet.setColumnWidth(1, 7680);
/* 1234:1262 */       spreadSheet.setColumnWidth(2, 6400);
/* 1235:1263 */       spreadSheet.setColumnWidth(3, 6400);
/* 1236:1264 */       spreadSheet.setColumnWidth(4, 6400);
/* 1237:1265 */       spreadSheet.setColumnWidth(5, 6400);
/* 1238:1266 */       spreadSheet.setColumnWidth(6, 6400);
/* 1239:1267 */       spreadSheet.setColumnWidth(7, 6400);
/* 1240:1268 */       spreadSheet.setColumnWidth(8, 6400);
/* 1241:1269 */       spreadSheet.setColumnWidth(9, 6400);
/* 1242:1270 */       spreadSheet.setColumnWidth(10, 6400);
/* 1243:1271 */       spreadSheet.setColumnWidth(11, 6400);
/* 1244:1272 */       spreadSheet.setColumnWidth(12, 6400);
/* 1245:1273 */       spreadSheet.setColumnWidth(13, 6400);
/* 1246:1274 */       spreadSheet.setColumnWidth(14, 6400);
/* 1247:1275 */       spreadSheet.setColumnWidth(15, 6400);
/* 1248:1276 */       spreadSheet.setColumnWidth(16, 6400);
/* 1249:1277 */       spreadSheet.setColumnWidth(17, 6400);
/* 1250:1278 */       spreadSheet.setColumnWidth(18, 6400);
/* 1251:1279 */       spreadSheet.setColumnWidth(19, 6400);
/* 1252:1280 */       spreadSheet.setColumnWidth(20, 6400);
/* 1253:1281 */       spreadSheet.setColumnWidth(21, 6400);
/* 1254:1282 */       spreadSheet.setColumnWidth(22, 6400);
/* 1255:1283 */       spreadSheet.setColumnWidth(23, 6400);
/* 1256:1284 */       spreadSheet.setColumnWidth(24, 6400);
/* 1257:1285 */       spreadSheet.setColumnWidth(25, 6400);
/* 1258:1286 */       spreadSheet.setColumnWidth(26, 6400);
/* 1259:1287 */       spreadSheet.setColumnWidth(27, 6400);
/* 1260:1288 */       spreadSheet.setColumnWidth(28, 6400);
/* 1261:1289 */       spreadSheet.setColumnWidth(29, 6400);
/* 1262:1290 */       spreadSheet.setColumnWidth(30, 6400);
/* 1263:     */       
/* 1264:1292 */       cell = row.createCell(0);
/* 1265:1293 */       cell.setCellValue("Product Id");
/* 1266:1294 */       cell.setCellStyle(headerCellStyle);
/* 1267:     */       
/* 1268:1296 */       cell = row.createCell(1);
/* 1269:1297 */       cell.setCellValue("Product Name");
/* 1270:1298 */       cell.setCellStyle(headerCellStyle);
/* 1271:     */       
/* 1272:1300 */       cell = row.createCell(2);
/* 1273:1301 */       cell.setCellValue("Product Cade");
/* 1274:1302 */       cell.setCellStyle(headerCellStyle);
/* 1275:     */       
/* 1276:1304 */       cell = row.createCell(3);
/* 1277:1305 */       cell.setCellValue("Product Category");
/* 1278:1306 */       cell.setCellStyle(headerCellStyle);
/* 1279:     */       
/* 1280:1308 */       cell = row.createCell(4);
/* 1281:1309 */       cell.setCellValue("Product Active");
/* 1282:1310 */       cell.setCellStyle(headerCellStyle);
/* 1283:     */       
/* 1284:1312 */       cell = row.createCell(5);
/* 1285:1313 */       cell.setCellValue("Vendor Name ");
/* 1286:1314 */       cell.setCellStyle(headerCellStyle);
/* 1287:     */       
/* 1288:1316 */       cell = row.createCell(6);
/* 1289:1317 */       cell.setCellValue("Manufacturer");
/* 1290:1318 */       cell.setCellStyle(headerCellStyle);
/* 1291:     */       
/* 1292:1320 */       cell = row.createCell(7);
/* 1293:1321 */       cell.setCellValue("Sales Start Date");
/* 1294:1322 */       cell.setCellStyle(headerCellStyle);
/* 1295:     */       
/* 1296:1324 */       cell = row.createCell(8);
/* 1297:1325 */       cell.setCellValue("Sales End Date");
/* 1298:1326 */       cell.setCellStyle(headerCellStyle);
/* 1299:     */       
/* 1300:1328 */       cell = row.createCell(9);
/* 1301:1329 */       cell.setCellValue("Support Start Date");
/* 1302:1330 */       cell.setCellStyle(headerCellStyle);
/* 1303:     */       
/* 1304:1332 */       cell = row.createCell(10);
/* 1305:1333 */       cell.setCellValue("Support End Date");
/* 1306:1334 */       cell.setCellStyle(headerCellStyle);
/* 1307:     */       
/* 1308:1336 */       cell = row.createCell(11);
/* 1309:1337 */       cell.setCellValue("Serial Number");
/* 1310:1338 */       cell.setCellStyle(headerCellStyle);
/* 1311:     */       
/* 1312:1340 */       cell = row.createCell(12);
/* 1313:1341 */       cell.setCellValue("MRF_PART_NO");
/* 1314:1342 */       cell.setCellStyle(headerCellStyle);
/* 1315:     */       
/* 1316:1344 */       cell = row.createCell(13);
/* 1317:1345 */       cell.setCellValue("Vendor Part No.");
/* 1318:1346 */       cell.setCellStyle(headerCellStyle);
/* 1319:     */       
/* 1320:1348 */       cell = row.createCell(14);
/* 1321:1349 */       cell.setCellValue("Product Sheet");
/* 1322:1350 */       cell.setCellStyle(headerCellStyle);
/* 1323:     */       
/* 1324:1352 */       cell = row.createCell(15);
/* 1325:1353 */       cell.setCellValue("Website");
/* 1326:1354 */       cell.setCellStyle(headerCellStyle);
/* 1327:     */       
/* 1328:1356 */       cell = row.createCell(16);
/* 1329:1357 */       cell.setCellValue("GL Account");
/* 1330:1358 */       cell.setCellStyle(headerCellStyle);
/* 1331:     */       
/* 1332:1360 */       cell = row.createCell(17);
/* 1333:1361 */       cell.setCellValue("Unit Price");
/* 1334:1362 */       cell.setCellStyle(headerCellStyle);
/* 1335:     */       
/* 1336:1364 */       cell = row.createCell(18);
/* 1337:1365 */       cell.setCellValue("Commission Rate");
/* 1338:1366 */       cell.setCellStyle(headerCellStyle);
/* 1339:     */       
/* 1340:1368 */       cell = row.createCell(19);
/* 1341:1369 */       cell.setCellValue("Tax");
/* 1342:1370 */       cell.setCellStyle(headerCellStyle);
/* 1343:     */       
/* 1344:1372 */       cell = row.createCell(20);
/* 1345:1373 */       cell.setCellValue("Purches Cost");
/* 1346:1374 */       cell.setCellStyle(headerCellStyle);
/* 1347:     */       
/* 1348:1376 */       cell = row.createCell(21);
/* 1349:1377 */       cell.setCellValue("Usage Unit");
/* 1350:1378 */       cell.setCellStyle(headerCellStyle);
/* 1351:     */       
/* 1352:1380 */       cell = row.createCell(22);
/* 1353:1381 */       cell.setCellValue("Qty Per Unit");
/* 1354:1382 */       cell.setCellStyle(headerCellStyle);
/* 1355:     */       
/* 1356:1384 */       cell = row.createCell(23);
/* 1357:1385 */       cell.setCellValue("Qty In Stock");
/* 1358:1386 */       cell.setCellStyle(headerCellStyle);
/* 1359:     */       
/* 1360:1388 */       cell = row.createCell(24);
/* 1361:1389 */       cell.setCellValue("Reorder Level");
/* 1362:1390 */       cell.setCellStyle(headerCellStyle);
/* 1363:     */       
/* 1364:1392 */       cell = row.createCell(25);
/* 1365:1393 */       cell.setCellValue("Handler");
/* 1366:1394 */       cell.setCellStyle(headerCellStyle);
/* 1367:     */       
/* 1368:1396 */       cell = row.createCell(26);
/* 1369:1397 */       cell.setCellValue("Qty In Demand");
/* 1370:1398 */       cell.setCellStyle(headerCellStyle);
/* 1371:     */       
/* 1372:1400 */       cell = row.createCell(27);
/* 1373:1401 */       cell.setCellValue("Description");
/* 1374:1402 */       cell.setCellStyle(headerCellStyle);
/* 1375:     */       
/* 1376:1404 */       cell = row.createCell(28);
/* 1377:1405 */       cell.setCellValue("Created Date");
/* 1378:1406 */       cell.setCellStyle(headerCellStyle);
/* 1379:     */       
/* 1380:1408 */       cell = row.createCell(29);
/* 1381:1409 */       cell.setCellValue("Created By");
/* 1382:1410 */       cell.setCellStyle(headerCellStyle);
/* 1383:     */       
/* 1384:1412 */       cell = row.createCell(30);
/* 1385:1413 */       cell.setCellValue("Product Image");
/* 1386:1414 */       cell.setCellStyle(headerCellStyle);
/* 1387:     */       
/* 1388:1416 */       List<ExcelReportDaoImpl> li = new ArrayList();
/* 1389:1417 */       while (this.resultSet.next())
/* 1390:     */       {
/* 1391:1419 */         this.daoImpl = new ExcelReportDaoImpl();
/* 1392:     */         
/* 1393:     */ 
/* 1394:1422 */         row = spreadSheet.createRow(currentRow++);
/* 1395:     */         
/* 1396:1424 */         cell = row.createCell(0);
/* 1397:1425 */         cell.setCellValue(this.resultSet.getString("PRODUCT_ID"));
/* 1398:1426 */         cell.setCellStyle(dataCellStyle);
/* 1399:     */         
/* 1400:1428 */         cell = row.createCell(1);
/* 1401:1429 */         cell.setCellValue(this.resultSet.getString("PRODUCT_NAME"));
/* 1402:1430 */         cell.setCellStyle(dataCellStyle);
/* 1403:     */         
/* 1404:1432 */         cell = row.createCell(2);
/* 1405:1433 */         cell.setCellValue(this.resultSet.getString("PRODUCT_CODE"));
/* 1406:1434 */         cell.setCellStyle(dataCellStyle);
/* 1407:     */         
/* 1408:     */ 
/* 1409:     */ 
/* 1410:     */ 
/* 1411:     */ 
/* 1412:     */ 
/* 1413:     */ 
/* 1414:     */ 
/* 1415:     */ 
/* 1416:1444 */         cell = row.createCell(3);
/* 1417:1445 */         cell.setCellValue(this.nameHelper.getProductCategory(this.resultSet
/* 1418:1446 */           .getInt("PRODUCT_CATEGORY")));
/* 1419:1447 */         cell.setCellStyle(dataCellStyle);
/* 1420:     */         
/* 1421:1449 */         cell = row.createCell(4);
/* 1422:1450 */         cell.setCellValue(this.resultSet.getString("PRODUCT_ACTIVE"));
/* 1423:1451 */         cell.setCellStyle(dataCellStyle);
/* 1424:     */         
/* 1425:1453 */         cell = row.createCell(5);
/* 1426:1454 */         cell.setCellValue(this.nameHelper.getVendorName(this.resultSet
/* 1427:1455 */           .getInt("VENDOR_NAME")));
/* 1428:1456 */         cell.setCellStyle(dataCellStyle);
/* 1429:     */         
/* 1430:1458 */         cell = row.createCell(6);
/* 1431:1459 */         cell.setCellValue(this.nameHelper.getManufacturer(this.resultSet
/* 1432:1460 */           .getInt("MANUFACTURER")));
/* 1433:1461 */         cell.setCellStyle(dataCellStyle);
/* 1434:     */         
/* 1435:1463 */         cell = row.createCell(7);
/* 1436:1464 */         cell.setCellValue(this.resultSet.getString("SALES_START_DATE"));
/* 1437:1465 */         cell.setCellStyle(dataCellStyle);
/* 1438:     */         
/* 1439:1467 */         cell = row.createCell(8);
/* 1440:1468 */         cell.setCellValue(this.resultSet.getString("SALES_END_DATE"));
/* 1441:1469 */         cell.setCellStyle(dataCellStyle);
/* 1442:1470 */         cell = row.createCell(9);
/* 1443:1471 */         cell.setCellValue(this.resultSet.getString("SUPPORT_START_DATE"));
/* 1444:1472 */         cell.setCellStyle(dataCellStyle);
/* 1445:     */         
/* 1446:1474 */         cell = row.createCell(10);
/* 1447:1475 */         cell.setCellValue(this.resultSet.getString("SUPPORT_EXPIRY_DATE"));
/* 1448:1476 */         cell.setCellStyle(dataCellStyle);
/* 1449:     */         
/* 1450:1478 */         cell = row.createCell(11);
/* 1451:1479 */         cell.setCellValue(this.resultSet.getString("SERIAL_NO"));
/* 1452:1480 */         cell.setCellStyle(dataCellStyle);
/* 1453:1481 */         cell = row.createCell(12);
/* 1454:1482 */         cell.setCellValue(this.resultSet.getString("MFR_PART_NO"));
/* 1455:1483 */         cell.setCellStyle(dataCellStyle);
/* 1456:1484 */         cell = row.createCell(13);
/* 1457:1485 */         cell.setCellValue(this.resultSet.getString("VENDOR_PART_NO"));
/* 1458:1486 */         cell.setCellStyle(dataCellStyle);
/* 1459:     */         
/* 1460:1488 */         cell = row.createCell(14);
/* 1461:1489 */         cell.setCellValue(this.resultSet.getString("PRODUCT_SHEET"));
/* 1462:1490 */         cell.setCellStyle(dataCellStyle);
/* 1463:     */         
/* 1464:1492 */         cell = row.createCell(15);
/* 1465:1493 */         cell.setCellValue(this.resultSet.getString("WEBSITE"));
/* 1466:1494 */         cell.setCellStyle(dataCellStyle);
/* 1467:     */         
/* 1468:1496 */         cell = row.createCell(16);
/* 1469:1497 */         cell.setCellValue(this.nameHelper.getGlAccount(this.resultSet
/* 1470:1498 */           .getInt("GL_ACCOUNT")));
/* 1471:1499 */         cell.setCellStyle(dataCellStyle);
/* 1472:     */         
/* 1473:1501 */         cell = row.createCell(17);
/* 1474:1502 */         cell.setCellValue(this.resultSet.getInt("UNIT_PRICE"));
/* 1475:1503 */         cell.setCellStyle(dataCellStyle);
/* 1476:     */         
/* 1477:1505 */         cell = row.createCell(18);
/* 1478:1506 */         cell.setCellValue(this.resultSet.getInt("COMMISION_RATE"));
/* 1479:1507 */         cell.setCellStyle(dataCellStyle);
/* 1480:     */         
/* 1481:1509 */         cell = row.createCell(19);
/* 1482:1510 */         cell.setCellValue(this.nameHelper.getTax(this.resultSet.getInt("TAX")));
/* 1483:1511 */         cell.setCellStyle(dataCellStyle);
/* 1484:     */         
/* 1485:1513 */         cell = row.createCell(20);
/* 1486:1514 */         cell.setCellValue(this.resultSet.getInt("PURCHASE_COST"));
/* 1487:1515 */         cell.setCellStyle(dataCellStyle);
/* 1488:     */         
/* 1489:1517 */         cell = row.createCell(21);
/* 1490:1518 */         cell.setCellValue(this.resultSet.getInt("USAGE_UNIT"));
/* 1491:1519 */         cell.setCellStyle(dataCellStyle);
/* 1492:     */         
/* 1493:1521 */         cell = row.createCell(22);
/* 1494:1522 */         cell.setCellValue(this.resultSet.getInt("QTY_PER_UNIT"));
/* 1495:1523 */         cell.setCellStyle(dataCellStyle);
/* 1496:     */         
/* 1497:1525 */         cell = row.createCell(23);
/* 1498:1526 */         cell.setCellValue(this.resultSet.getInt("QTY_IN_STOCK"));
/* 1499:1527 */         cell.setCellStyle(dataCellStyle);
/* 1500:     */         
/* 1501:1529 */         cell = row.createCell(24);
/* 1502:1530 */         cell.setCellValue(this.resultSet.getString("REORDER_LAVEL"));
/* 1503:1531 */         cell.setCellStyle(dataCellStyle);
/* 1504:     */         
/* 1505:1533 */         cell = row.createCell(25);
/* 1506:1534 */         cell.setCellValue(this.nameHelper.getHandler(this.resultSet
/* 1507:1535 */           .getInt("HANDLER")));
/* 1508:1536 */         cell.setCellStyle(dataCellStyle);
/* 1509:     */         
/* 1510:1538 */         cell = row.createCell(26);
/* 1511:1539 */         cell.setCellValue(this.resultSet.getInt("QTY_IN_DEMAND"));
/* 1512:1540 */         cell.setCellStyle(dataCellStyle);
/* 1513:     */         
/* 1514:1542 */         cell = row.createCell(28);
/* 1515:1543 */         cell.setCellValue(
/* 1516:1544 */           DateTimeUtil.convertDatetoFormDateForView(this.resultSet
/* 1517:1545 */           .getString("CREATION_DATE")));
/* 1518:1546 */         cell.setCellStyle(dataCellStyle);
/* 1519:     */         
/* 1520:1548 */         cell = row.createCell(29);
/* 1521:1549 */         cell.setCellValue(this.nameHelper.getCustomerName(this.resultSet
/* 1522:1550 */           .getInt("CREATED_BY")));
/* 1523:1551 */         cell.setCellStyle(dataCellStyle);
/* 1524:     */         
/* 1525:1553 */         String temp = this.resultSet.getString("DESCRIPTION");
/* 1526:     */         
/* 1527:1555 */         cell = row.createCell(27);
/* 1528:1556 */         cell.setCellValue(temp.replaceAll("\\<.*?\\>", " "));
/* 1529:1557 */         cell.setCellStyle(dataCellStyle);
/* 1530:     */         
/* 1531:1559 */         li.add(this.daoImpl);
/* 1532:     */       }
/* 1533:1562 */       ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
/* 1534:1563 */       wb.write(outByteStream);
/* 1535:1564 */       byte[] outArray = outByteStream.toByteArray();
/* 1536:1565 */       response.setContentType("application/ms-excel");
/* 1537:1566 */       response.setContentLength(outArray.length);
/* 1538:1567 */       response.setHeader("Expires:", "0");
/* 1539:1568 */       response.setHeader("Content-Disposition", 
/* 1540:1569 */         "attachment; filename=Product_list.xls");
/* 1541:     */       
/* 1542:     */ 
/* 1543:1572 */       ServletOutputStream fileOut = response.getOutputStream();
/* 1544:1573 */       fileOut.write(outArray);
/* 1545:1574 */       fileOut.flush();
/* 1546:1575 */       fileOut.close();
/* 1547:     */     }
/* 1548:     */     catch (Exception e)
/* 1549:     */     {
/* 1550:1578 */       e.printStackTrace();
/* 1551:     */     }
/* 1552:     */   }
/* 1553:     */   
/* 1554:     */   public void retriveAssignmentExcelReport(HttpServletRequest request, HttpServletResponse response)
/* 1555:     */     throws Exception
/* 1556:     */   {
/* 1557:     */     try
/* 1558:     */     {
/* 1559:1588 */       System.out.println("try");
/* 1560:1589 */       this.connection = getConnection();
/* 1561:1590 */       String query = "SELECT * FROM TAB_ASSIGNMENT";
/* 1562:1591 */       this.preparedStatement = this.connection.prepareStatement(query);
/* 1563:1592 */       this.resultSet = this.preparedStatement.executeQuery();
/* 1564:1593 */       System.out.println("executeQuery");
/* 1565:1594 */       int currentRow = 1;
/* 1566:     */       
/* 1567:1596 */       Workbook wb = new HSSFWorkbook();
/* 1568:1597 */       Sheet spreadSheet = wb.createSheet("Assignment List");
/* 1569:     */       
/* 1570:     */ 
/* 1571:1600 */       Row row = spreadSheet.createRow(0);
/* 1572:     */       
/* 1573:     */ 
/* 1574:1603 */       CellStyle headerCellStyle = wb.createCellStyle();
/* 1575:1604 */       headerCellStyle.setFillForegroundColor((short)49);
/* 1576:1605 */       headerCellStyle.setFillPattern((short)1);
/* 1577:     */       
/* 1578:1607 */       Font setFont = wb.createFont();
/* 1579:1608 */       setFont.setFontHeightInPoints((short)11);
/* 1580:1609 */       setFont.setColor((short)8);
/* 1581:1610 */       setFont.setBoldweight((short)700);
/* 1582:1611 */       headerCellStyle.setBorderBottom((short)1);
/* 1583:1612 */       headerCellStyle.setFont(setFont);
/* 1584:     */       
/* 1585:     */ 
/* 1586:1615 */       CellStyle dataCellStyle = wb.createCellStyle();
/* 1587:1616 */       Font setDataFont = wb.createFont();
/* 1588:1617 */       setDataFont.setColor((short)8);
/* 1589:1618 */       dataCellStyle.setBorderBottom((short)0);
/* 1590:1619 */       dataCellStyle.setFont(setDataFont);
/* 1591:     */       
/* 1592:1621 */       Cell cell = null;
/* 1593:     */       
/* 1594:1623 */       spreadSheet.setColumnWidth(0, 2560);
/* 1595:1624 */       spreadSheet.setColumnWidth(1, 7680);
/* 1596:1625 */       spreadSheet.setColumnWidth(2, 6400);
/* 1597:1626 */       spreadSheet.setColumnWidth(3, 6400);
/* 1598:1627 */       spreadSheet.setColumnWidth(4, 6400);
/* 1599:1628 */       spreadSheet.setColumnWidth(5, 6400);
/* 1600:1629 */       spreadSheet.setColumnWidth(6, 6400);
/* 1601:1630 */       spreadSheet.setColumnWidth(7, 6400);
/* 1602:1631 */       spreadSheet.setColumnWidth(8, 6400);
/* 1603:1632 */       spreadSheet.setColumnWidth(9, 6400);
/* 1604:1633 */       spreadSheet.setColumnWidth(10, 6400);
/* 1605:1634 */       spreadSheet.setColumnWidth(11, 6400);
/* 1606:1635 */       spreadSheet.setColumnWidth(12, 6400);
/* 1607:1636 */       spreadSheet.setColumnWidth(13, 6400);
/* 1608:1637 */       spreadSheet.setColumnWidth(14, 6400);
/* 1609:1638 */       spreadSheet.setColumnWidth(15, 6400);
/* 1610:1639 */       spreadSheet.setColumnWidth(16, 6400);
/* 1611:1640 */       spreadSheet.setColumnWidth(17, 6400);
/* 1612:1641 */       spreadSheet.setColumnWidth(18, 6400);
/* 1613:1642 */       spreadSheet.setColumnWidth(19, 6400);
/* 1614:     */       
/* 1615:1644 */       cell = row.createCell(0);
/* 1616:1645 */       cell.setCellValue("ASSIGNMENT ID");
/* 1617:1646 */       cell.setCellStyle(headerCellStyle);
/* 1618:     */       
/* 1619:1648 */       cell = row.createCell(1);
/* 1620:1649 */       cell.setCellValue("ASSIGNMENT NAME");
/* 1621:1650 */       cell.setCellStyle(headerCellStyle);
/* 1622:     */       
/* 1623:1652 */       cell = row.createCell(2);
/* 1624:1653 */       cell.setCellValue("ASSIGNMENT OWNER");
/* 1625:1654 */       cell.setCellStyle(headerCellStyle);
/* 1626:     */       
/* 1627:1656 */       cell = row.createCell(3);
/* 1628:1657 */       cell.setCellValue("EXPECTED AMMOUNT");
/* 1629:1658 */       cell.setCellStyle(headerCellStyle);
/* 1630:     */       
/* 1631:1660 */       cell = row.createCell(4);
/* 1632:1661 */       cell.setCellValue("ACCOUNT");
/* 1633:1662 */       cell.setCellStyle(headerCellStyle);
/* 1634:     */       
/* 1635:1664 */       cell = row.createCell(5);
/* 1636:1665 */       cell.setCellValue("CONTACT PERSON");
/* 1637:1666 */       cell.setCellStyle(headerCellStyle);
/* 1638:     */       
/* 1639:1668 */       cell = row.createCell(6);
/* 1640:1669 */       cell.setCellValue("EXPECTED CLOSING DATE");
/* 1641:1670 */       cell.setCellStyle(headerCellStyle);
/* 1642:     */       
/* 1643:1672 */       cell = row.createCell(7);
/* 1644:1673 */       cell.setCellValue("LEAD SOURCE");
/* 1645:1674 */       cell.setCellStyle(headerCellStyle);
/* 1646:     */       
/* 1647:1676 */       cell = row.createCell(8);
/* 1648:1677 */       cell.setCellValue("ASSIGN TO");
/* 1649:1678 */       cell.setCellStyle(headerCellStyle);
/* 1650:     */       
/* 1651:1680 */       cell = row.createCell(9);
/* 1652:1681 */       cell.setCellValue("LEAD");
/* 1653:1682 */       cell.setCellStyle(headerCellStyle);
/* 1654:     */       
/* 1655:1684 */       cell = row.createCell(10);
/* 1656:1685 */       cell.setCellValue("PROBABILITY");
/* 1657:1686 */       cell.setCellStyle(headerCellStyle);
/* 1658:     */       
/* 1659:1688 */       cell = row.createCell(11);
/* 1660:1689 */       cell.setCellValue("CAMPING");
/* 1661:1690 */       cell.setCellStyle(headerCellStyle);
/* 1662:     */       
/* 1663:1692 */       cell = row.createCell(12);
/* 1664:1693 */       cell.setCellValue("WEIGHTED REVEINUE");
/* 1665:1694 */       cell.setCellStyle(headerCellStyle);
/* 1666:     */       
/* 1667:1696 */       cell = row.createCell(13);
/* 1668:1697 */       cell.setCellValue("PRIMARY EMAIL ID");
/* 1669:1698 */       cell.setCellStyle(headerCellStyle);
/* 1670:     */       
/* 1671:1700 */       cell = row.createCell(14);
/* 1672:1701 */       cell.setCellValue("PHONE ISD");
/* 1673:1702 */       cell.setCellStyle(headerCellStyle);
/* 1674:     */       
/* 1675:1704 */       cell = row.createCell(15);
/* 1676:1705 */       cell.setCellValue("PHONE STD");
/* 1677:1706 */       cell.setCellStyle(headerCellStyle);
/* 1678:     */       
/* 1679:1708 */       cell = row.createCell(16);
/* 1680:1709 */       cell.setCellValue("PHONE NUMBER");
/* 1681:1710 */       cell.setCellStyle(headerCellStyle);
/* 1682:     */       
/* 1683:1712 */       cell = row.createCell(17);
/* 1684:1713 */       cell.setCellValue("DESCRIPTION");
/* 1685:1714 */       cell.setCellStyle(headerCellStyle);
/* 1686:     */       
/* 1687:1716 */       cell = row.createCell(18);
/* 1688:1717 */       cell.setCellValue("ASSIGNMENT STATUS");
/* 1689:1718 */       cell.setCellStyle(headerCellStyle);
/* 1690:     */       
/* 1691:1720 */       cell = row.createCell(19);
/* 1692:1721 */       cell.setCellValue("EMAIL FLAG");
/* 1693:1722 */       cell.setCellStyle(headerCellStyle);
/* 1694:     */       
/* 1695:1724 */       List<ExcelReportDaoImpl> li = new ArrayList();
/* 1696:1725 */       while (this.resultSet.next())
/* 1697:     */       {
/* 1698:1727 */         this.daoImpl = new ExcelReportDaoImpl();
/* 1699:     */         
/* 1700:     */ 
/* 1701:1730 */         row = spreadSheet.createRow(currentRow++);
/* 1702:     */         
/* 1703:1732 */         cell = row.createCell(0);
/* 1704:1733 */         cell.setCellValue(this.resultSet.getString("ASSIGNMENT_ID"));
/* 1705:1734 */         cell.setCellStyle(dataCellStyle);
/* 1706:     */         
/* 1707:1736 */         cell = row.createCell(1);
/* 1708:1737 */         cell.setCellValue(this.resultSet.getString("ASSIGNMENT_NAME"));
/* 1709:1738 */         cell.setCellStyle(dataCellStyle);
/* 1710:     */         
/* 1711:1740 */         cell = row.createCell(2);
/* 1712:1741 */         cell.setCellValue(this.nameHelper.getAssignmentOwner(this.resultSet
/* 1713:1742 */           .getInt("ASSIGNMENT_OWNER")));
/* 1714:1743 */         cell.setCellStyle(dataCellStyle);
/* 1715:     */         
/* 1716:1745 */         cell = row.createCell(3);
/* 1717:1746 */         cell.setCellValue(this.resultSet.getString("EXPECTED_AMMOUNT"));
/* 1718:1747 */         cell.setCellStyle(dataCellStyle);
/* 1719:     */         
/* 1720:1749 */         cell = row.createCell(4);
/* 1721:1750 */         cell.setCellValue(this.resultSet.getString("ACCOUNT"));
/* 1722:1751 */         cell.setCellStyle(dataCellStyle);
/* 1723:     */         
/* 1724:1753 */         cell = row.createCell(5);
/* 1725:1754 */         cell.setCellValue(this.nameHelper
/* 1726:1755 */           .getAssignmentContactPerson(this.resultSet
/* 1727:1756 */           .getInt("CONTACT_PERSON")));
/* 1728:1757 */         cell.setCellStyle(dataCellStyle);
/* 1729:     */         
/* 1730:1759 */         cell = row.createCell(6);
/* 1731:1760 */         cell.setCellValue(this.resultSet.getString("EXPECTED_CLOSING_DATE"));
/* 1732:1761 */         cell.setCellStyle(dataCellStyle);
/* 1733:     */         
/* 1734:1763 */         cell = row.createCell(7);
/* 1735:1764 */         cell.setCellValue(this.nameHelper.getAssignmentLead(this.resultSet
/* 1736:1765 */           .getInt("LEAD_SOURCE")));
/* 1737:1766 */         cell.setCellStyle(dataCellStyle);
/* 1738:     */         
/* 1739:1768 */         cell = row.createCell(8);
/* 1740:1769 */         cell.setCellValue(this.nameHelper.getAssignTo(this.resultSet
/* 1741:1770 */           .getInt("ASSIGN_TO")));
/* 1742:1771 */         cell.setCellStyle(dataCellStyle);
/* 1743:     */         
/* 1744:1773 */         cell = row.createCell(9);
/* 1745:1774 */         cell.setCellValue(this.nameHelper.getAssignmentLead(this.resultSet
/* 1746:1775 */           .getInt("LEAD")));
/* 1747:1776 */         cell.setCellStyle(dataCellStyle);
/* 1748:     */         
/* 1749:1778 */         cell = row.createCell(10);
/* 1750:1779 */         cell.setCellValue(this.resultSet.getString("PROBABILITY"));
/* 1751:1780 */         cell.setCellStyle(dataCellStyle);
/* 1752:     */         
/* 1753:1782 */         cell = row.createCell(11);
/* 1754:1783 */         cell.setCellValue(this.resultSet.getString("CAMPING"));
/* 1755:1784 */         cell.setCellStyle(dataCellStyle);
/* 1756:     */         
/* 1757:1786 */         cell = row.createCell(12);
/* 1758:1787 */         cell.setCellValue(this.resultSet.getString("WEIGHTED_REVEINUE"));
/* 1759:1788 */         cell.setCellStyle(dataCellStyle);
/* 1760:     */         
/* 1761:1790 */         cell = row.createCell(13);
/* 1762:1791 */         cell.setCellValue(this.resultSet.getString("PRIMARY_EMAIL_ID"));
/* 1763:1792 */         cell.setCellStyle(dataCellStyle);
/* 1764:     */         
/* 1765:1794 */         cell = row.createCell(14);
/* 1766:1795 */         cell.setCellValue(this.resultSet.getString("PHONE_ISD"));
/* 1767:1796 */         cell.setCellStyle(dataCellStyle);
/* 1768:     */         
/* 1769:1798 */         cell = row.createCell(15);
/* 1770:1799 */         cell.setCellValue(this.resultSet.getString("PHONE_STD"));
/* 1771:1800 */         cell.setCellStyle(dataCellStyle);
/* 1772:     */         
/* 1773:1802 */         cell = row.createCell(16);
/* 1774:1803 */         cell.setCellValue(this.resultSet.getString("PHONE_NUMBER"));
/* 1775:1804 */         cell.setCellStyle(dataCellStyle);
/* 1776:     */         
/* 1777:1806 */         cell = row.createCell(17);
/* 1778:1807 */         cell.setCellValue(this.resultSet.getString("DESCRIPTION"));
/* 1779:1808 */         cell.setCellStyle(dataCellStyle);
/* 1780:     */         
/* 1781:1810 */         cell = row.createCell(18);
/* 1782:1811 */         cell.setCellValue(
/* 1783:1812 */           AssignmentStatus.getAssignmentStatus(this.resultSet
/* 1784:1813 */           .getInt("ASSIGNMENT_STATUS")));
/* 1785:1814 */         cell.setCellStyle(dataCellStyle);
/* 1786:     */         
/* 1787:1816 */         cell = row.createCell(19);
/* 1788:1817 */         cell.setCellValue(this.resultSet.getString("EMAIL_FLAG"));
/* 1789:1818 */         cell.setCellStyle(dataCellStyle);
/* 1790:     */         
/* 1791:1820 */         li.add(this.daoImpl);
/* 1792:     */       }
/* 1793:1823 */       ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
/* 1794:1824 */       wb.write(outByteStream);
/* 1795:1825 */       byte[] outArray = outByteStream.toByteArray();
/* 1796:1826 */       response.setContentType("application/ms-excel");
/* 1797:1827 */       response.setContentLength(outArray.length);
/* 1798:1828 */       response.setHeader("Expires:", "0");
/* 1799:1829 */       response.setHeader("Content-Disposition", 
/* 1800:1830 */         "attachment; filename=Assignment_list.xls");
/* 1801:     */       
/* 1802:     */ 
/* 1803:1833 */       ServletOutputStream fileOut = response.getOutputStream();
/* 1804:1834 */       fileOut.write(outArray);
/* 1805:1835 */       fileOut.flush();
/* 1806:1836 */       fileOut.close();
/* 1807:     */     }
/* 1808:     */     catch (Exception e)
/* 1809:     */     {
/* 1810:1839 */       e.printStackTrace();
/* 1811:     */     }
/* 1812:     */   }
/* 1813:     */   
/* 1814:     */   public void retriveAccountExcelReport(HttpServletRequest request, HttpServletResponse response)
/* 1815:     */   {
/* 1816:     */     try
/* 1817:     */     {
/* 1818:1848 */       System.out.println("try");
/* 1819:1849 */       this.connection = getConnection();
/* 1820:1850 */       String query = "SELECT * FROM TAB_ACCOUNT";
/* 1821:1851 */       this.preparedStatement = this.connection.prepareStatement(query);
/* 1822:1852 */       this.resultSet = this.preparedStatement.executeQuery();
/* 1823:1853 */       System.out.println("executeQuery");
/* 1824:1854 */       int currentRow = 1;
/* 1825:     */       
/* 1826:1856 */       Workbook wb = new HSSFWorkbook();
/* 1827:1857 */       Sheet spreadSheet = wb.createSheet("Account List");
/* 1828:     */       
/* 1829:     */ 
/* 1830:1860 */       Row row = spreadSheet.createRow(0);
/* 1831:     */       
/* 1832:     */ 
/* 1833:1863 */       CellStyle headerCellStyle = wb.createCellStyle();
/* 1834:1864 */       headerCellStyle.setFillForegroundColor((short)49);
/* 1835:1865 */       headerCellStyle.setFillPattern((short)1);
/* 1836:     */       
/* 1837:1867 */       Font setFont = wb.createFont();
/* 1838:1868 */       setFont.setFontHeightInPoints((short)11);
/* 1839:1869 */       setFont.setColor((short)8);
/* 1840:1870 */       setFont.setBoldweight((short)700);
/* 1841:1871 */       headerCellStyle.setBorderBottom((short)1);
/* 1842:1872 */       headerCellStyle.setFont(setFont);
/* 1843:     */       
/* 1844:     */ 
/* 1845:1875 */       CellStyle dataCellStyle = wb.createCellStyle();
/* 1846:1876 */       Font setDataFont = wb.createFont();
/* 1847:1877 */       setDataFont.setColor(
/* 1848:1878 */         (short)9);
/* 1849:1879 */       dataCellStyle.setBorderBottom((short)0);
/* 1850:1880 */       dataCellStyle.setFont(setDataFont);
/* 1851:     */       
/* 1852:1882 */       Cell cell = null;
/* 1853:     */       
/* 1854:1884 */       spreadSheet.setColumnWidth(0, 2560);
/* 1855:1885 */       spreadSheet.setColumnWidth(1, 7680);
/* 1856:1886 */       spreadSheet.setColumnWidth(2, 6400);
/* 1857:1887 */       spreadSheet.setColumnWidth(3, 6400);
/* 1858:1888 */       spreadSheet.setColumnWidth(4, 6400);
/* 1859:1889 */       spreadSheet.setColumnWidth(5, 6400);
/* 1860:1890 */       spreadSheet.setColumnWidth(6, 6400);
/* 1861:1891 */       spreadSheet.setColumnWidth(7, 6400);
/* 1862:     */       
/* 1863:1893 */       spreadSheet.setColumnWidth(8, 6400);
/* 1864:1894 */       spreadSheet.setColumnWidth(9, 6400);
/* 1865:     */       
/* 1866:1896 */       spreadSheet.setColumnWidth(10, 6400);
/* 1867:1897 */       spreadSheet.setColumnWidth(11, 6400);
/* 1868:1898 */       spreadSheet.setColumnWidth(12, 6400);
/* 1869:1899 */       spreadSheet.setColumnWidth(13, 6400);
/* 1870:1900 */       spreadSheet.setColumnWidth(14, 6400);
/* 1871:1901 */       spreadSheet.setColumnWidth(15, 6400);
/* 1872:     */       
/* 1873:1903 */       cell = row.createCell(0);
/* 1874:1904 */       cell.setCellValue("Account Id");
/* 1875:1905 */       cell.setCellStyle(headerCellStyle);
/* 1876:     */       
/* 1877:1907 */       cell = row.createCell(1);
/* 1878:1908 */       cell.setCellValue("Account Name");
/* 1879:1909 */       cell.setCellStyle(headerCellStyle);
/* 1880:     */       
/* 1881:1911 */       cell = row.createCell(2);
/* 1882:1912 */       cell.setCellValue("Account Owner");
/* 1883:1913 */       cell.setCellStyle(headerCellStyle);
/* 1884:     */       
/* 1885:1915 */       cell = row.createCell(3);
/* 1886:1916 */       cell.setCellValue("Account Type");
/* 1887:1917 */       cell.setCellStyle(headerCellStyle);
/* 1888:     */       
/* 1889:1919 */       cell = row.createCell(4);
/* 1890:1920 */       cell.setCellValue("Mobile No");
/* 1891:1921 */       cell.setCellStyle(headerCellStyle);
/* 1892:     */       
/* 1893:1923 */       cell = row.createCell(5);
/* 1894:1924 */       cell.setCellValue("Status");
/* 1895:1925 */       cell.setCellStyle(headerCellStyle);
/* 1896:     */       
/* 1897:1927 */       cell = row.createCell(6);
/* 1898:1928 */       cell.setCellValue("ANNUAL REVENUE");
/* 1899:1929 */       cell.setCellStyle(headerCellStyle);
/* 1900:     */       
/* 1901:1931 */       cell = row.createCell(7);
/* 1902:1932 */       cell.setCellValue("EMAIL ID");
/* 1903:1933 */       cell.setCellStyle(headerCellStyle);
/* 1904:     */       
/* 1905:1935 */       cell = row.createCell(8);
/* 1906:1936 */       cell.setCellValue("PARENT ACCOUNT");
/* 1907:1937 */       cell.setCellStyle(headerCellStyle);
/* 1908:     */       
/* 1909:1939 */       cell = row.createCell(9);
/* 1910:1940 */       cell.setCellValue("ASSIGNED TO");
/* 1911:1941 */       cell.setCellStyle(headerCellStyle);
/* 1912:     */       
/* 1913:1943 */       cell = row.createCell(10);
/* 1914:1944 */       cell.setCellValue("SHIPPING CONTACT PERSON");
/* 1915:1945 */       cell.setCellStyle(headerCellStyle);
/* 1916:     */       
/* 1917:1947 */       cell = row.createCell(11);
/* 1918:1948 */       cell.setCellValue("SHIPPING ADDRESS LINE1");
/* 1919:1949 */       cell.setCellStyle(headerCellStyle);
/* 1920:     */       
/* 1921:1951 */       cell = row.createCell(12);
/* 1922:1952 */       cell.setCellValue("SHIPPING CITY");
/* 1923:1953 */       cell.setCellStyle(headerCellStyle);
/* 1924:     */       
/* 1925:1955 */       cell = row.createCell(13);
/* 1926:1956 */       cell.setCellValue("CREATED DATE");
/* 1927:1957 */       cell.setCellStyle(headerCellStyle);
/* 1928:     */       
/* 1929:1959 */       cell = row.createCell(14);
/* 1930:1960 */       cell.setCellValue("ORGANIZATION SECTOR ");
/* 1931:1961 */       cell.setCellStyle(headerCellStyle);
/* 1932:     */       
/* 1933:1963 */       cell = row.createCell(15);
/* 1934:1964 */       cell.setCellValue("ZIPCODE");
/* 1935:1965 */       cell.setCellStyle(headerCellStyle);
/* 1936:     */       
/* 1937:     */ 
/* 1938:1968 */       List<ExcelReportDaoImpl> ai = new ArrayList();
/* 1939:1969 */       while (this.resultSet.next())
/* 1940:     */       {
/* 1941:1971 */         this.daoImpl = new ExcelReportDaoImpl();
/* 1942:     */         
/* 1943:     */ 
/* 1944:1974 */         row = spreadSheet.createRow(currentRow++);
/* 1945:     */         
/* 1946:1976 */         cell = row.createCell(0);
/* 1947:1977 */         cell.setCellValue(this.resultSet.getString("ACCOUNT_ID"));
/* 1948:1978 */         cell.setCellStyle(dataCellStyle);
/* 1949:     */         
/* 1950:1980 */         cell = row.createCell(1);
/* 1951:1981 */         cell.setCellValue(this.resultSet.getString("ACCOUNT_NAME"));
/* 1952:1982 */         cell.setCellStyle(dataCellStyle);
/* 1953:     */         
/* 1954:1984 */         cell = row.createCell(2);
/* 1955:1985 */         cell.setCellValue(AppendHelper.appendSalutaion(
/* 1956:1986 */           this.resultSet.getInt("SALUTATION"), 
/* 1957:1987 */           this.resultSet.getString("CONTACT_PERSON")));
/* 1958:     */         
/* 1959:1989 */         cell.setCellStyle(dataCellStyle);
/* 1960:1990 */         cell = row.createCell(3);
/* 1961:1991 */         cell.setCellValue(this.resultSet.getString("ACCOUNT_TYPE_REF"));
/* 1962:1992 */         cell.setCellStyle(dataCellStyle);
/* 1963:     */         
/* 1964:1994 */         cell.setCellStyle(dataCellStyle);
/* 1965:1995 */         cell = row.createCell(4);
/* 1966:1996 */         cell.setCellValue(this.resultSet.getString("MOBILE_NO"));
/* 1967:1997 */         cell.setCellStyle(dataCellStyle);
/* 1968:     */         
/* 1969:1999 */         cell.setCellStyle(dataCellStyle);
/* 1970:2000 */         cell = row.createCell(5);
/* 1971:2001 */         cell.setCellValue(this.resultSet.getString("ACCOUNT_STATUS"));
/* 1972:2002 */         cell.setCellStyle(dataCellStyle);
/* 1973:     */         
/* 1974:     */ 
/* 1975:2005 */         cell.setCellStyle(dataCellStyle);
/* 1976:2006 */         cell = row.createCell(6);
/* 1977:2007 */         cell.setCellValue(this.resultSet.getString("ANNUAL_REVENUE"));
/* 1978:2008 */         cell.setCellStyle(dataCellStyle);
/* 1979:     */         
/* 1980:2010 */         cell.setCellStyle(dataCellStyle);
/* 1981:2011 */         cell = row.createCell(7);
/* 1982:2012 */         cell.setCellValue(this.resultSet.getString("EMAIL_ID"));
/* 1983:2013 */         cell.setCellStyle(dataCellStyle);
/* 1984:     */         
/* 1985:2015 */         cell.setCellStyle(dataCellStyle);
/* 1986:2016 */         cell = row.createCell(8);
/* 1987:2017 */         cell.setCellValue(this.resultSet.getString("PARENT_ACCOUNT"));
/* 1988:2018 */         cell.setCellStyle(dataCellStyle);
/* 1989:     */         
/* 1990:2020 */         cell.setCellStyle(dataCellStyle);
/* 1991:2021 */         cell = row.createCell(9);
/* 1992:2022 */         cell.setCellValue(this.resultSet.getString("ASSIGNED_TO"));
/* 1993:2023 */         cell.setCellStyle(dataCellStyle);
/* 1994:     */         
/* 1995:2025 */         cell.setCellStyle(dataCellStyle);
/* 1996:2026 */         cell = row.createCell(10);
/* 1997:2027 */         cell.setCellValue(this.resultSet.getString("SHIPPING_CONTACT_PERSON"));
/* 1998:2028 */         cell.setCellStyle(dataCellStyle);
/* 1999:     */         
/* 2000:2030 */         cell.setCellStyle(dataCellStyle);
/* 2001:2031 */         cell = row.createCell(11);
/* 2002:2032 */         cell.setCellValue(this.resultSet.getString("SHIPPING_ADDRESS_LINE_1"));
/* 2003:2033 */         cell.setCellStyle(dataCellStyle);
/* 2004:     */         
/* 2005:2035 */         cell.setCellStyle(dataCellStyle);
/* 2006:2036 */         cell = row.createCell(12);
/* 2007:2037 */         cell.setCellValue(this.resultSet.getString("SHIPPING_CITY"));
/* 2008:2038 */         cell.setCellStyle(dataCellStyle);
/* 2009:     */         
/* 2010:2040 */         cell.setCellStyle(dataCellStyle);
/* 2011:2041 */         cell = row.createCell(13);
/* 2012:2042 */         cell.setCellValue(this.resultSet.getString("CREATED_DATE"));
/* 2013:2043 */         cell.setCellStyle(dataCellStyle);
/* 2014:     */         
/* 2015:2045 */         cell.setCellStyle(dataCellStyle);
/* 2016:2046 */         cell = row.createCell(14);
/* 2017:2047 */         cell.setCellValue(this.resultSet.getString("ORGANIZATION_SECTOR_REF"));
/* 2018:2048 */         cell.setCellStyle(dataCellStyle);
/* 2019:     */         
/* 2020:2050 */         cell.setCellStyle(dataCellStyle);
/* 2021:2051 */         cell = row.createCell(15);
/* 2022:2052 */         cell.setCellValue(this.resultSet.getString("SHIPPING_ZIPCODE"));
/* 2023:2053 */         cell.setCellStyle(dataCellStyle);
/* 2024:     */         
/* 2025:     */ 
/* 2026:2056 */         ai.add(this.daoImpl);
/* 2027:     */       }
/* 2028:2059 */       ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
/* 2029:2060 */       wb.write(outByteStream);
/* 2030:2061 */       byte[] outArray = outByteStream.toByteArray();
/* 2031:2062 */       response.setContentType("application/ms-excel");
/* 2032:2063 */       response.setContentLength(outArray.length);
/* 2033:2064 */       response.setHeader("Expires:", "0");
/* 2034:2065 */       response.setHeader("Content-Disposition", 
/* 2035:2066 */         "attachment; filename=Account_list.xls");
/* 2036:     */       
/* 2037:     */ 
/* 2038:2069 */       ServletOutputStream fileOut = response.getOutputStream();
/* 2039:2070 */       fileOut.write(outArray);
/* 2040:2071 */       fileOut.flush();
/* 2041:2072 */       fileOut.close();
/* 2042:     */     }
/* 2043:     */     catch (Exception e)
/* 2044:     */     {
/* 2045:2075 */       e.printStackTrace();
/* 2046:     */     }
/* 2047:     */   }
/* 2048:     */   
/* 2049:     */   public void retriveSupportFAQExcelReport(HttpServletRequest request, HttpServletResponse response)
/* 2050:     */     throws Exception
/* 2051:     */   {
/* 2052:     */     try
/* 2053:     */     {
/* 2054:2095 */       this.connection = getConnection();
/* 2055:2096 */       String query = "SELECT * FROM TAB_SUPPORT_FAQ";
/* 2056:2097 */       this.preparedStatement = this.connection.prepareStatement(query);
/* 2057:2098 */       this.resultSet = this.preparedStatement.executeQuery();
/* 2058:     */       
/* 2059:2100 */       int currentRow = 1;
/* 2060:     */       
/* 2061:2102 */       Workbook wb = new HSSFWorkbook();
/* 2062:2103 */       Sheet spreadSheet = wb.createSheet("FAQ List");
/* 2063:     */       
/* 2064:     */ 
/* 2065:2106 */       Row row = spreadSheet.createRow(0);
/* 2066:     */       
/* 2067:     */ 
/* 2068:2109 */       CellStyle headerCellStyle = wb.createCellStyle();
/* 2069:2110 */       headerCellStyle.setFillForegroundColor((short)49);
/* 2070:2111 */       headerCellStyle.setFillPattern((short)1);
/* 2071:     */       
/* 2072:2113 */       Font setFont = wb.createFont();
/* 2073:2114 */       setFont.setFontHeightInPoints((short)11);
/* 2074:2115 */       setFont.setColor((short)8);
/* 2075:2116 */       setFont.setBoldweight((short)700);
/* 2076:2117 */       headerCellStyle.setBorderBottom((short)1);
/* 2077:2118 */       headerCellStyle.setFont(setFont);
/* 2078:     */       
/* 2079:     */ 
/* 2080:2121 */       CellStyle dataCellStyle = wb.createCellStyle();
/* 2081:2122 */       Font setDataFont = wb.createFont();
/* 2082:2123 */       setDataFont.setColor((short)8);
/* 2083:2124 */       dataCellStyle.setBorderBottom((short)0);
/* 2084:2125 */       dataCellStyle.setFont(setDataFont);
/* 2085:     */       
/* 2086:2127 */       Cell cell = null;
/* 2087:     */       
/* 2088:2129 */       spreadSheet.setColumnWidth(0, 2560);
/* 2089:2130 */       spreadSheet.setColumnWidth(1, 7680);
/* 2090:2131 */       spreadSheet.setColumnWidth(2, 6400);
/* 2091:2132 */       spreadSheet.setColumnWidth(3, 6400);
/* 2092:2133 */       spreadSheet.setColumnWidth(4, 6400);
/* 2093:2134 */       spreadSheet.setColumnWidth(5, 6400);
/* 2094:2135 */       spreadSheet.setColumnWidth(6, 6400);
/* 2095:2136 */       spreadSheet.setColumnWidth(7, 6400);
/* 2096:     */       
/* 2097:2138 */       cell = row.createCell(0);
/* 2098:2139 */       cell.setCellValue("FAQ Id");
/* 2099:2140 */       cell.setCellStyle(headerCellStyle);
/* 2100:     */       
/* 2101:2142 */       cell = row.createCell(1);
/* 2102:2143 */       cell.setCellValue("Question");
/* 2103:2144 */       cell.setCellStyle(headerCellStyle);
/* 2104:     */       
/* 2105:2146 */       cell = row.createCell(2);
/* 2106:2147 */       cell.setCellValue("Answer");
/* 2107:2148 */       cell.setCellStyle(headerCellStyle);
/* 2108:     */       
/* 2109:2150 */       cell = row.createCell(3);
/* 2110:2151 */       cell.setCellValue("FAQ Status");
/* 2111:2152 */       cell.setCellStyle(headerCellStyle);
/* 2112:     */       
/* 2113:2154 */       cell = row.createCell(4);
/* 2114:2155 */       cell.setCellValue("FAQ Category");
/* 2115:2156 */       cell.setCellStyle(headerCellStyle);
/* 2116:     */       
/* 2117:2158 */       cell = row.createCell(5);
/* 2118:2159 */       cell.setCellValue("FAQ Owner");
/* 2119:2160 */       cell.setCellStyle(headerCellStyle);
/* 2120:     */       
/* 2121:2162 */       cell = row.createCell(6);
/* 2122:2163 */       cell.setCellValue("Product Name ");
/* 2123:2164 */       cell.setCellStyle(headerCellStyle);
/* 2124:     */       
/* 2125:2166 */       cell = row.createCell(7);
/* 2126:2167 */       cell.setCellValue("Date");
/* 2127:2168 */       cell.setCellStyle(headerCellStyle);
/* 2128:     */       
/* 2129:2170 */       List<ExcelReportDaoImpl> li = new ArrayList();
/* 2130:2171 */       while (this.resultSet.next())
/* 2131:     */       {
/* 2132:2173 */         this.daoImpl = new ExcelReportDaoImpl();
/* 2133:     */         
/* 2134:     */ 
/* 2135:2176 */         row = spreadSheet.createRow(currentRow++);
/* 2136:     */         
/* 2137:2178 */         cell = row.createCell(0);
/* 2138:2179 */         cell.setCellValue(this.resultSet.getString("FAQ_ID"));
/* 2139:2180 */         cell.setCellStyle(dataCellStyle);
/* 2140:     */         
/* 2141:2182 */         cell = row.createCell(1);
/* 2142:2183 */         cell.setCellValue(this.resultSet.getString("QUESTION"));
/* 2143:2184 */         cell.setCellStyle(dataCellStyle);
/* 2144:     */         
/* 2145:2186 */         cell = row.createCell(2);
/* 2146:2187 */         cell.setCellValue(this.resultSet.getString("ANSWER"));
/* 2147:2188 */         cell.setCellStyle(dataCellStyle);
/* 2148:     */         
/* 2149:2190 */         cell = row.createCell(3);
/* 2150:2191 */         cell.setCellValue(FAQStatus.getFAQStatus(this.resultSet
/* 2151:2192 */           .getInt("FAQ_STATUS")));
/* 2152:2193 */         cell.setCellStyle(dataCellStyle);
/* 2153:     */         
/* 2154:2195 */         cell = row.createCell(4);
/* 2155:2196 */         cell.setCellValue(this.nameHelper.getFaqCategory(this.resultSet
/* 2156:2197 */           .getInt("REF_FAQ_CATEGORY")));
/* 2157:2198 */         cell.setCellStyle(dataCellStyle);
/* 2158:     */         
/* 2159:2200 */         cell = row.createCell(5);
/* 2160:2201 */         cell.setCellValue(this.nameHelper.getFaqOwner(this.resultSet
/* 2161:2202 */           .getInt("REF_FAQ_OWNER")));
/* 2162:2203 */         cell.setCellStyle(dataCellStyle);
/* 2163:     */         
/* 2164:2205 */         cell = row.createCell(6);
/* 2165:2206 */         cell.setCellValue(this.nameHelper.getFaqProductName(this.resultSet
/* 2166:2207 */           .getInt("REF_PRODUCT_NAME")));
/* 2167:2208 */         cell.setCellStyle(dataCellStyle);
/* 2168:     */         
/* 2169:2210 */         cell = row.createCell(7);
/* 2170:2211 */         cell.setCellValue(this.resultSet
/* 2171:2212 */           .getString("DATE"));
/* 2172:2213 */         cell.setCellStyle(dataCellStyle);
/* 2173:     */         
/* 2174:     */ 
/* 2175:2216 */         li.add(this.daoImpl);
/* 2176:     */       }
/* 2177:2219 */       ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
/* 2178:2220 */       wb.write(outByteStream);
/* 2179:2221 */       byte[] outArray = outByteStream.toByteArray();
/* 2180:2222 */       response.setContentType("application/ms-excel");
/* 2181:2223 */       response.setContentLength(outArray.length);
/* 2182:2224 */       response.setHeader("Expires:", "0");
/* 2183:2225 */       response.setHeader("Content-Disposition", 
/* 2184:2226 */         "attachment; filename=Faq_list.xls");
/* 2185:     */       
/* 2186:     */ 
/* 2187:2229 */       ServletOutputStream fileOut = response.getOutputStream();
/* 2188:2230 */       fileOut.write(outArray);
/* 2189:2231 */       fileOut.flush();
/* 2190:2232 */       fileOut.close();
/* 2191:     */     }
/* 2192:     */     catch (Exception e)
/* 2193:     */     {
/* 2194:2235 */       e.printStackTrace();
/* 2195:     */     }
/* 2196:     */   }
/* 2197:     */   
/* 2198:     */   public void retriveContactsExcelReport(HttpServletRequest request, HttpServletResponse response)
/* 2199:     */   {
/* 2200:     */     try
/* 2201:     */     {
/* 2202:2247 */       System.out.println("try");
/* 2203:2248 */       this.connection = getConnection();
/* 2204:2249 */       String query = "SELECT * FROM TAB_CONTACT";
/* 2205:2250 */       this.preparedStatement = this.connection.prepareStatement(query);
/* 2206:2251 */       this.resultSet = this.preparedStatement.executeQuery();
/* 2207:2252 */       System.out.println("executeQuery");
/* 2208:2253 */       int currentRow = 1;
/* 2209:     */       
/* 2210:2255 */       Workbook wb = new HSSFWorkbook();
/* 2211:2256 */       Sheet spreadSheet = wb.createSheet("Contacts List");
/* 2212:     */       
/* 2213:     */ 
/* 2214:2259 */       Row row = spreadSheet.createRow(0);
/* 2215:     */       
/* 2216:     */ 
/* 2217:2262 */       CellStyle headerCellStyle = wb.createCellStyle();
/* 2218:2263 */       headerCellStyle.setFillForegroundColor((short)49);
/* 2219:2264 */       headerCellStyle.setFillPattern((short)1);
/* 2220:     */       
/* 2221:2266 */       Font setFont = wb.createFont();
/* 2222:2267 */       setFont.setFontHeightInPoints((short)11);
/* 2223:2268 */       setFont.setColor((short)8);
/* 2224:2269 */       setFont.setBoldweight((short)700);
/* 2225:2270 */       headerCellStyle.setBorderBottom((short)1);
/* 2226:2271 */       headerCellStyle.setFont(setFont);
/* 2227:     */       
/* 2228:     */ 
/* 2229:2274 */       CellStyle dataCellStyle = wb.createCellStyle();
/* 2230:2275 */       Font setDataFont = wb.createFont();
/* 2231:2276 */       setDataFont.setColor((short)8);
/* 2232:2277 */       dataCellStyle.setBorderBottom((short)0);
/* 2233:2278 */       dataCellStyle.setFont(setDataFont);
/* 2234:     */       
/* 2235:2280 */       Cell cell = null;
/* 2236:     */       
/* 2237:2282 */       spreadSheet.setColumnWidth(0, 2560);
/* 2238:2283 */       spreadSheet.setColumnWidth(1, 7680);
/* 2239:2284 */       spreadSheet.setColumnWidth(2, 6400);
/* 2240:2285 */       spreadSheet.setColumnWidth(3, 6400);
/* 2241:2286 */       spreadSheet.setColumnWidth(4, 6400);
/* 2242:2287 */       spreadSheet.setColumnWidth(5, 6400);
/* 2243:2288 */       spreadSheet.setColumnWidth(6, 6400);
/* 2244:2289 */       spreadSheet.setColumnWidth(7, 6400);
/* 2245:2290 */       spreadSheet.setColumnWidth(8, 6400);
/* 2246:2291 */       spreadSheet.setColumnWidth(9, 6400);
/* 2247:2292 */       spreadSheet.setColumnWidth(10, 6400);
/* 2248:2293 */       spreadSheet.setColumnWidth(11, 6400);
/* 2249:2294 */       spreadSheet.setColumnWidth(12, 6400);
/* 2250:2295 */       spreadSheet.setColumnWidth(13, 6400);
/* 2251:2296 */       spreadSheet.setColumnWidth(14, 6400);
/* 2252:2297 */       spreadSheet.setColumnWidth(15, 6400);
/* 2253:2298 */       spreadSheet.setColumnWidth(16, 6400);
/* 2254:2299 */       spreadSheet.setColumnWidth(17, 6400);
/* 2255:2300 */       spreadSheet.setColumnWidth(18, 6400);
/* 2256:2301 */       spreadSheet.setColumnWidth(19, 6400);
/* 2257:2302 */       spreadSheet.setColumnWidth(20, 6400);
/* 2258:2303 */       spreadSheet.setColumnWidth(21, 6400);
/* 2259:2304 */       spreadSheet.setColumnWidth(22, 6400);
/* 2260:2305 */       spreadSheet.setColumnWidth(23, 6400);
/* 2261:2306 */       spreadSheet.setColumnWidth(24, 6400);
/* 2262:2307 */       spreadSheet.setColumnWidth(25, 6400);
/* 2263:2308 */       spreadSheet.setColumnWidth(26, 6400);
/* 2264:2309 */       spreadSheet.setColumnWidth(27, 6400);
/* 2265:2310 */       spreadSheet.setColumnWidth(28, 6400);
/* 2266:2311 */       spreadSheet.setColumnWidth(29, 6400);
/* 2267:2312 */       spreadSheet.setColumnWidth(30, 6400);
/* 2268:     */       
/* 2269:2314 */       cell = row.createCell(0);
/* 2270:2315 */       cell.setCellValue("Contact Id");
/* 2271:2316 */       cell.setCellStyle(headerCellStyle);
/* 2272:     */       
/* 2273:2318 */       cell = row.createCell(1);
/* 2274:2319 */       cell.setCellValue("Contact Person");
/* 2275:2320 */       cell.setCellStyle(headerCellStyle);
/* 2276:     */       
/* 2277:2322 */       cell = row.createCell(2);
/* 2278:2323 */       cell.setCellValue("Nick Name");
/* 2279:2324 */       cell.setCellStyle(headerCellStyle);
/* 2280:     */       
/* 2281:2326 */       cell = row.createCell(3);
/* 2282:2327 */       cell.setCellValue("Designation");
/* 2283:2328 */       cell.setCellStyle(headerCellStyle);
/* 2284:     */       
/* 2285:2330 */       cell = row.createCell(4);
/* 2286:2331 */       cell.setCellValue("Phone Number");
/* 2287:2332 */       cell.setCellStyle(headerCellStyle);
/* 2288:     */       
/* 2289:2334 */       cell = row.createCell(5);
/* 2290:2335 */       cell.setCellValue("Referred By");
/* 2291:2336 */       cell.setCellStyle(headerCellStyle);
/* 2292:     */       
/* 2293:2338 */       cell = row.createCell(6);
/* 2294:2339 */       cell.setCellValue("Mobile Number");
/* 2295:2340 */       cell.setCellStyle(headerCellStyle);
/* 2296:     */       
/* 2297:2342 */       cell = row.createCell(7);
/* 2298:2343 */       cell.setCellValue("Email ID");
/* 2299:2344 */       cell.setCellStyle(headerCellStyle);
/* 2300:     */       
/* 2301:2346 */       cell = row.createCell(8);
/* 2302:2347 */       cell.setCellValue("Address Line 1");
/* 2303:2348 */       cell.setCellStyle(headerCellStyle);
/* 2304:     */       
/* 2305:2350 */       cell = row.createCell(9);
/* 2306:2351 */       cell.setCellValue("Address Line 2");
/* 2307:2352 */       cell.setCellStyle(headerCellStyle);
/* 2308:     */       
/* 2309:2354 */       cell = row.createCell(10);
/* 2310:2355 */       cell.setCellValue("City");
/* 2311:2356 */       cell.setCellStyle(headerCellStyle);
/* 2312:     */       
/* 2313:2358 */       cell = row.createCell(11);
/* 2314:2359 */       cell.setCellValue("State");
/* 2315:2360 */       cell.setCellStyle(headerCellStyle);
/* 2316:     */       
/* 2317:2362 */       cell = row.createCell(12);
/* 2318:2363 */       cell.setCellValue("Country");
/* 2319:2364 */       cell.setCellStyle(headerCellStyle);
/* 2320:     */       
/* 2321:2366 */       cell = row.createCell(13);
/* 2322:2367 */       cell.setCellValue("Zipcode");
/* 2323:2368 */       cell.setCellStyle(headerCellStyle);
/* 2324:     */       
/* 2325:2370 */       cell = row.createCell(14);
/* 2326:2371 */       cell.setCellValue("Phone Number");
/* 2327:2372 */       cell.setCellStyle(headerCellStyle);
/* 2328:     */       
/* 2329:2374 */       cell = row.createCell(15);
/* 2330:2375 */       cell.setCellValue("Mobile Number");
/* 2331:2376 */       cell.setCellStyle(headerCellStyle);
/* 2332:     */       
/* 2333:2378 */       cell = row.createCell(16);
/* 2334:2379 */       cell.setCellValue("Email ID");
/* 2335:2380 */       cell.setCellStyle(headerCellStyle);
/* 2336:     */       
/* 2337:2382 */       cell = row.createCell(17);
/* 2338:2383 */       cell.setCellValue("Fax");
/* 2339:2384 */       cell.setCellStyle(headerCellStyle);
/* 2340:     */       
/* 2341:2386 */       cell = row.createCell(18);
/* 2342:2387 */       cell.setCellValue("Address Line 1");
/* 2343:2388 */       cell.setCellStyle(headerCellStyle);
/* 2344:     */       
/* 2345:2390 */       cell = row.createCell(19);
/* 2346:2391 */       cell.setCellValue("Address Line 2");
/* 2347:2392 */       cell.setCellStyle(headerCellStyle);
/* 2348:     */       
/* 2349:2394 */       cell = row.createCell(20);
/* 2350:2395 */       cell.setCellValue("City");
/* 2351:2396 */       cell.setCellStyle(headerCellStyle);
/* 2352:     */       
/* 2353:2398 */       cell = row.createCell(21);
/* 2354:2399 */       cell.setCellValue("State");
/* 2355:2400 */       cell.setCellStyle(headerCellStyle);
/* 2356:     */       
/* 2357:2402 */       cell = row.createCell(22);
/* 2358:2403 */       cell.setCellValue("Country");
/* 2359:2404 */       cell.setCellStyle(headerCellStyle);
/* 2360:     */       
/* 2361:2406 */       cell = row.createCell(23);
/* 2362:2407 */       cell.setCellValue("Zip Code");
/* 2363:2408 */       cell.setCellStyle(headerCellStyle);
/* 2364:     */       
/* 2365:2410 */       cell = row.createCell(24);
/* 2366:2411 */       cell.setCellValue("Phone Number");
/* 2367:2412 */       cell.setCellStyle(headerCellStyle);
/* 2368:     */       
/* 2369:2414 */       cell = row.createCell(25);
/* 2370:2415 */       cell.setCellValue("Mobile Number");
/* 2371:2416 */       cell.setCellStyle(headerCellStyle);
/* 2372:     */       
/* 2373:2418 */       cell = row.createCell(26);
/* 2374:2419 */       cell.setCellValue("Email ID");
/* 2375:2420 */       cell.setCellStyle(headerCellStyle);
/* 2376:     */       
/* 2377:2422 */       cell = row.createCell(27);
/* 2378:2423 */       cell.setCellValue("Fax");
/* 2379:2424 */       cell.setCellStyle(headerCellStyle);
/* 2380:     */       
/* 2381:2426 */       cell = row.createCell(28);
/* 2382:2427 */       cell.setCellValue("Created By");
/* 2383:2428 */       cell.setCellStyle(headerCellStyle);
/* 2384:     */       
/* 2385:     */ 
/* 2386:     */ 
/* 2387:2432 */       List<ExcelReportDaoImpl> li = new ArrayList();
/* 2388:2433 */       while (this.resultSet.next())
/* 2389:     */       {
/* 2390:2435 */         this.daoImpl = new ExcelReportDaoImpl();
/* 2391:     */         
/* 2392:     */ 
/* 2393:2438 */         row = spreadSheet.createRow(currentRow++);
/* 2394:     */         
/* 2395:2440 */         cell = row.createCell(0);
/* 2396:2441 */         cell.setCellValue(this.resultSet.getString("CONTACT_ID"));
/* 2397:2442 */         cell.setCellStyle(dataCellStyle);
/* 2398:     */         
/* 2399:     */ 
/* 2400:2445 */         cell = row.createCell(1);
/* 2401:2446 */         cell.setCellValue(AppendHelper.appendSalutaion(
/* 2402:2447 */           this.resultSet.getInt("SALUTATION"), 
/* 2403:2448 */           this.resultSet.getString("CONTACT_PERSON")));
/* 2404:2449 */         cell.setCellStyle(dataCellStyle);
/* 2405:     */         
/* 2406:2451 */         cell = row.createCell(2);
/* 2407:2452 */         cell.setCellValue(this.resultSet
/* 2408:2453 */           .getString("NICK_NAME"));
/* 2409:2454 */         cell.setCellStyle(dataCellStyle);
/* 2410:     */         
/* 2411:2456 */         cell = row.createCell(3);
/* 2412:2457 */         cell.setCellValue(this.resultSet
/* 2413:2458 */           .getString("DESIGNATION_REF"));
/* 2414:2459 */         cell.setCellStyle(dataCellStyle);
/* 2415:     */         
/* 2416:2461 */         cell = row.createCell(4);
/* 2417:2462 */         cell.setCellValue(this.resultSet
/* 2418:2463 */           .getString("PHONE_NUMBER"));
/* 2419:2464 */         cell.setCellStyle(dataCellStyle);
/* 2420:     */         
/* 2421:2466 */         cell = row.createCell(5);
/* 2422:2467 */         cell.setCellValue(this.resultSet
/* 2423:2468 */           .getString("REFERRED_BY"));
/* 2424:2469 */         cell.setCellStyle(dataCellStyle);
/* 2425:     */         
/* 2426:2471 */         cell = row.createCell(6);
/* 2427:2472 */         cell.setCellValue(this.resultSet.getString("MOBILE_NUMBER1"));
/* 2428:2473 */         cell.setCellStyle(dataCellStyle);
/* 2429:     */         
/* 2430:2475 */         cell = row.createCell(7);
/* 2431:2476 */         cell.setCellValue(this.resultSet
/* 2432:2477 */           .getString("EMAIL_ID"));
/* 2433:2478 */         cell.setCellStyle(dataCellStyle);
/* 2434:     */         
/* 2435:2480 */         cell = row.createCell(8);
/* 2436:2481 */         cell.setCellValue(this.resultSet.getString("HOME_CONTACT_ADDRESS_LINE1"));
/* 2437:2482 */         cell.setCellStyle(dataCellStyle);
/* 2438:     */         
/* 2439:2484 */         cell = row.createCell(9);
/* 2440:2485 */         cell.setCellValue(this.resultSet.getString("HOME_CONTACT_ADDRESS_LINE2"));
/* 2441:2486 */         cell.setCellStyle(dataCellStyle);
/* 2442:     */         
/* 2443:2488 */         cell = row.createCell(10);
/* 2444:2489 */         cell.setCellValue(this.resultSet
/* 2445:2490 */           .getString("HOME_CONTACT_CITY"));
/* 2446:2491 */         cell.setCellStyle(dataCellStyle);
/* 2447:     */         
/* 2448:2493 */         cell = row.createCell(11);
/* 2449:2494 */         cell.setCellValue(this.resultSet
/* 2450:2495 */           .getString("HOME_CONTACT_STATE"));
/* 2451:2496 */         cell.setCellStyle(dataCellStyle);
/* 2452:     */         
/* 2453:2498 */         cell = row.createCell(12);
/* 2454:2499 */         cell.setCellValue(this.resultSet
/* 2455:2500 */           .getString("HOME_CONTACT_COUNTRY_REF"));
/* 2456:2501 */         cell.setCellStyle(dataCellStyle);
/* 2457:     */         
/* 2458:2503 */         cell = row.createCell(13);
/* 2459:2504 */         cell.setCellValue(this.resultSet
/* 2460:2505 */           .getString("HOME_CONTACT_ZIPCODE"));
/* 2461:2506 */         cell.setCellStyle(dataCellStyle);
/* 2462:     */         
/* 2463:2508 */         cell = row.createCell(14);
/* 2464:2509 */         cell.setCellValue(this.resultSet.getString("HOME_CONTACT_PHONE_NUMBER"));
/* 2465:2510 */         cell.setCellStyle(dataCellStyle);
/* 2466:     */         
/* 2467:2512 */         cell = row.createCell(15);
/* 2468:2513 */         cell.setCellValue(this.resultSet.getString("HOME_CONTACT_MOBILE_NUMBER"));
/* 2469:2514 */         cell.setCellStyle(dataCellStyle);
/* 2470:     */         
/* 2471:2516 */         cell = row.createCell(16);
/* 2472:2517 */         cell.setCellValue(this.resultSet.getString("HOME_CONTACT_EMAIL_ID"));
/* 2473:2518 */         cell.setCellStyle(dataCellStyle);
/* 2474:     */         
/* 2475:2520 */         cell = row.createCell(17);
/* 2476:2521 */         cell.setCellValue(this.resultSet.getString("HOME_CONTACT_FAX_NUMBER"));
/* 2477:2522 */         cell.setCellStyle(dataCellStyle);
/* 2478:     */         
/* 2479:2524 */         cell = row.createCell(18);
/* 2480:2525 */         cell.setCellValue(this.resultSet.getString("WORK_CONTACT_ADDRESS_LINE1"));
/* 2481:2526 */         cell.setCellStyle(dataCellStyle);
/* 2482:     */         
/* 2483:2528 */         cell = row.createCell(19);
/* 2484:2529 */         cell.setCellValue(this.resultSet
/* 2485:2530 */           .getString("WORK_CONTACT_ADDRESS_LINE2"));
/* 2486:2531 */         cell.setCellStyle(dataCellStyle);
/* 2487:     */         
/* 2488:2533 */         cell = row.createCell(20);
/* 2489:2534 */         cell.setCellValue(this.resultSet.getString("WORK_CONTACT_CITY"));
/* 2490:2535 */         cell.setCellStyle(dataCellStyle);
/* 2491:     */         
/* 2492:2537 */         cell = row.createCell(21);
/* 2493:2538 */         cell.setCellValue(this.resultSet.getString("WORK_CONTACT_STATE"));
/* 2494:2539 */         cell.setCellStyle(dataCellStyle);
/* 2495:     */         
/* 2496:2541 */         cell = row.createCell(22);
/* 2497:2542 */         cell.setCellValue(this.resultSet.getString("WORK_CONTACT_COUNTRY_REF"));
/* 2498:2543 */         cell.setCellStyle(dataCellStyle);
/* 2499:     */         
/* 2500:2545 */         cell = row.createCell(23);
/* 2501:2546 */         cell.setCellValue(this.resultSet.getString("WORK_CONTACT_ZIPCODE"));
/* 2502:2547 */         cell.setCellStyle(dataCellStyle);
/* 2503:     */         
/* 2504:2549 */         cell = row.createCell(24);
/* 2505:2550 */         cell.setCellValue(this.resultSet.getString("WORK_CONTACT_PHONE_NUMBER"));
/* 2506:2551 */         cell.setCellStyle(dataCellStyle);
/* 2507:     */         
/* 2508:     */ 
/* 2509:2554 */         cell = row.createCell(25);
/* 2510:2555 */         cell.setCellValue(this.resultSet.getString("WORK_CONTACT_MOBILE_NUMBER"));
/* 2511:2556 */         cell.setCellStyle(dataCellStyle);
/* 2512:     */         
/* 2513:2558 */         cell = row.createCell(26);
/* 2514:2559 */         cell.setCellValue(this.resultSet.getString("WORK_CONTACT_EMAIL_ID"));
/* 2515:2560 */         cell.setCellStyle(dataCellStyle);
/* 2516:     */         
/* 2517:2562 */         cell = row.createCell(27);
/* 2518:2563 */         cell.setCellValue(this.resultSet
/* 2519:2564 */           .getString("WORK_CONTACT_FAX_NUMBER"));
/* 2520:2565 */         cell.setCellStyle(dataCellStyle);
/* 2521:     */         
/* 2522:     */ 
/* 2523:2568 */         cell = row.createCell(28);
/* 2524:2569 */         cell.setCellValue(this.resultSet.getString("CREATED_BY"));
/* 2525:2570 */         cell.setCellStyle(dataCellStyle);
/* 2526:     */         
/* 2527:2572 */         li.add(this.daoImpl);
/* 2528:     */       }
/* 2529:2575 */       ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
/* 2530:2576 */       wb.write(outByteStream);
/* 2531:2577 */       byte[] outArray = outByteStream.toByteArray();
/* 2532:2578 */       response.setContentType("application/ms-excel");
/* 2533:2579 */       response.setContentLength(outArray.length);
/* 2534:2580 */       response.setHeader("Expires:", "0");
/* 2535:2581 */       response.setHeader("Content-Disposition", 
/* 2536:2582 */         "attachment; filename=Contacts_list.xls");
/* 2537:     */       
/* 2538:     */ 
/* 2539:2585 */       ServletOutputStream fileOut = response.getOutputStream();
/* 2540:2586 */       fileOut.write(outArray);
/* 2541:2587 */       fileOut.flush();
/* 2542:2588 */       fileOut.close();
/* 2543:     */     }
/* 2544:     */     catch (Exception e)
/* 2545:     */     {
/* 2546:2591 */       e.printStackTrace();
/* 2547:     */     }
/* 2548:     */   }
/* 2549:     */   
/* 2550:     */   public void retriveTicketExcelReport(HttpServletRequest request, HttpServletResponse response)
/* 2551:     */   {
/* 2552:     */     try
/* 2553:     */     {
/* 2554:2614 */       this.connection = getConnection();
/* 2555:2615 */       String query = "SELECT * FROM TAB_SUPPORT_TICKET";
/* 2556:2616 */       this.preparedStatement = this.connection.prepareStatement(query);
/* 2557:2617 */       this.resultSet = this.preparedStatement.executeQuery();
/* 2558:     */       
/* 2559:2619 */       int currentRow = 1;
/* 2560:     */       
/* 2561:2621 */       Workbook wb = new HSSFWorkbook();
/* 2562:2622 */       Sheet spreadSheet = wb.createSheet("Ticket List");
/* 2563:     */       
/* 2564:     */ 
/* 2565:2625 */       Row row = spreadSheet.createRow(0);
/* 2566:     */       
/* 2567:     */ 
/* 2568:2628 */       CellStyle headerCellStyle = wb.createCellStyle();
/* 2569:2629 */       headerCellStyle.setFillForegroundColor((short)49);
/* 2570:2630 */       headerCellStyle.setFillPattern((short)1);
/* 2571:     */       
/* 2572:2632 */       Font setFont = wb.createFont();
/* 2573:2633 */       setFont.setFontHeightInPoints((short)11);
/* 2574:2634 */       setFont.setColor((short)8);
/* 2575:2635 */       setFont.setBoldweight((short)700);
/* 2576:2636 */       headerCellStyle.setBorderBottom((short)1);
/* 2577:2637 */       headerCellStyle.setFont(setFont);
/* 2578:     */       
/* 2579:     */ 
/* 2580:2640 */       CellStyle dataCellStyle = wb.createCellStyle();
/* 2581:2641 */       Font setDataFont = wb.createFont();
/* 2582:2642 */       setDataFont.setColor((short)8);
/* 2583:2643 */       dataCellStyle.setBorderBottom((short)0);
/* 2584:2644 */       dataCellStyle.setFont(setDataFont);
/* 2585:     */       
/* 2586:2646 */       Cell cell = null;
/* 2587:     */       
/* 2588:2648 */       spreadSheet.setColumnWidth(0, 2560);
/* 2589:2649 */       spreadSheet.setColumnWidth(1, 7680);
/* 2590:2650 */       spreadSheet.setColumnWidth(2, 6400);
/* 2591:2651 */       spreadSheet.setColumnWidth(3, 6400);
/* 2592:2652 */       spreadSheet.setColumnWidth(4, 6400);
/* 2593:2653 */       spreadSheet.setColumnWidth(5, 6400);
/* 2594:2654 */       spreadSheet.setColumnWidth(6, 6400);
/* 2595:2655 */       spreadSheet.setColumnWidth(7, 6400);
/* 2596:2656 */       spreadSheet.setColumnWidth(8, 6400);
/* 2597:2657 */       spreadSheet.setColumnWidth(9, 6400);
/* 2598:2658 */       spreadSheet.setColumnWidth(10, 6400);
/* 2599:2659 */       spreadSheet.setColumnWidth(11, 6400);
/* 2600:2660 */       spreadSheet.setColumnWidth(12, 6400);
/* 2601:2661 */       spreadSheet.setColumnWidth(13, 6400);
/* 2602:2662 */       spreadSheet.setColumnWidth(14, 6400);
/* 2603:2663 */       spreadSheet.setColumnWidth(15, 6400);
/* 2604:2664 */       spreadSheet.setColumnWidth(16, 6400);
/* 2605:     */       
/* 2606:2666 */       cell = row.createCell(0);
/* 2607:2667 */       cell.setCellValue("Ticket Id");
/* 2608:2668 */       cell.setCellStyle(headerCellStyle);
/* 2609:     */       
/* 2610:2670 */       cell = row.createCell(1);
/* 2611:2671 */       cell.setCellValue("Contact Name");
/* 2612:2672 */       cell.setCellStyle(headerCellStyle);
/* 2613:     */       
/* 2614:2674 */       cell = row.createCell(2);
/* 2615:2675 */       cell.setCellValue("Product Name");
/* 2616:2676 */       cell.setCellStyle(headerCellStyle);
/* 2617:     */       
/* 2618:2678 */       cell = row.createCell(3);
/* 2619:2679 */       cell.setCellValue("Category");
/* 2620:2680 */       cell.setCellStyle(headerCellStyle);
/* 2621:     */       
/* 2622:2682 */       cell = row.createCell(4);
/* 2623:2683 */       cell.setCellValue("Ticket Owner");
/* 2624:2684 */       cell.setCellStyle(headerCellStyle);
/* 2625:     */       
/* 2626:2686 */       cell = row.createCell(5);
/* 2627:2687 */       cell.setCellValue("Email");
/* 2628:2688 */       cell.setCellStyle(headerCellStyle);
/* 2629:     */       
/* 2630:2690 */       cell = row.createCell(6);
/* 2631:2691 */       cell.setCellValue("Subject");
/* 2632:2692 */       cell.setCellStyle(headerCellStyle);
/* 2633:     */       
/* 2634:2694 */       cell = row.createCell(7);
/* 2635:2695 */       cell.setCellValue("Phone No.");
/* 2636:2696 */       cell.setCellStyle(headerCellStyle);
/* 2637:     */       
/* 2638:2698 */       cell = row.createCell(8);
/* 2639:2699 */       cell.setCellValue("Status");
/* 2640:2700 */       cell.setCellStyle(headerCellStyle);
/* 2641:     */       
/* 2642:2702 */       cell = row.createCell(9);
/* 2643:2703 */       cell.setCellValue("Priority");
/* 2644:2704 */       cell.setCellStyle(headerCellStyle);
/* 2645:     */       
/* 2646:2706 */       cell = row.createCell(10);
/* 2647:2707 */       cell.setCellValue("Channel Name");
/* 2648:2708 */       cell.setCellStyle(headerCellStyle);
/* 2649:     */       
/* 2650:2710 */       cell = row.createCell(11);
/* 2651:2711 */       cell.setCellValue("Due Date");
/* 2652:2712 */       cell.setCellStyle(headerCellStyle);
/* 2653:     */       
/* 2654:2714 */       cell = row.createCell(12);
/* 2655:2715 */       cell.setCellValue("Description");
/* 2656:2716 */       cell.setCellStyle(headerCellStyle);
/* 2657:     */       
/* 2658:2718 */       cell = row.createCell(13);
/* 2659:2719 */       cell.setCellValue("Attachment");
/* 2660:2720 */       cell.setCellStyle(headerCellStyle);
/* 2661:     */       
/* 2662:2722 */       List<ExcelReportDaoImpl> li = new ArrayList();
/* 2663:2723 */       while (this.resultSet.next())
/* 2664:     */       {
/* 2665:2725 */         this.daoImpl = new ExcelReportDaoImpl();
/* 2666:     */         
/* 2667:     */ 
/* 2668:2728 */         row = spreadSheet.createRow(currentRow++);
/* 2669:     */         
/* 2670:2730 */         cell = row.createCell(0);
/* 2671:2731 */         cell.setCellValue(this.resultSet.getString("TICKET_ID"));
/* 2672:2732 */         cell.setCellStyle(dataCellStyle);
/* 2673:     */         
/* 2674:2734 */         cell = row.createCell(1);
/* 2675:2735 */         cell.setCellValue(this.nameHelper.getTicketContactName(this.resultSet
/* 2676:2736 */           .getInt("REF_CONTACT_NAME")));
/* 2677:2737 */         cell.setCellStyle(dataCellStyle);
/* 2678:     */         
/* 2679:2739 */         cell = row.createCell(2);
/* 2680:2740 */         cell.setCellValue(this.nameHelper.getTicketProductName(this.resultSet
/* 2681:2741 */           .getInt("REF_PRODUCT_NAME")));
/* 2682:2742 */         cell.setCellStyle(dataCellStyle);
/* 2683:     */         
/* 2684:2744 */         cell = row.createCell(3);
/* 2685:2745 */         cell.setCellValue(this.nameHelper.getTicketCategory(this.resultSet
/* 2686:2746 */           .getInt("REF_CATEGORY")));
/* 2687:2747 */         cell.setCellStyle(dataCellStyle);
/* 2688:     */         
/* 2689:2749 */         cell = row.createCell(4);
/* 2690:2750 */         cell.setCellValue(this.nameHelper.getTicketOwner(this.resultSet
/* 2691:2751 */           .getInt("REF_TICKET_OWNER")));
/* 2692:2752 */         cell.setCellStyle(dataCellStyle);
/* 2693:     */         
/* 2694:2754 */         cell = row.createCell(5);
/* 2695:2755 */         cell.setCellValue(this.resultSet.getString("EMAIL"));
/* 2696:2756 */         cell.setCellStyle(dataCellStyle);
/* 2697:     */         
/* 2698:2758 */         cell = row.createCell(6);
/* 2699:2759 */         cell.setCellValue(this.resultSet.getString("SUBJECT"));
/* 2700:2760 */         cell.setCellStyle(dataCellStyle);
/* 2701:     */         
/* 2702:2762 */         cell = row.createCell(7);
/* 2703:2763 */         cell.setCellValue(AppendHelper.appendNumber(
/* 2704:2764 */           this.resultSet.getString("PHONE_ISD"), 
/* 2705:2765 */           this.resultSet.getString("PHONE_STD"), 
/* 2706:2766 */           this.resultSet.getString("PHONE_NO")));
/* 2707:     */         
/* 2708:2768 */         cell.setCellStyle(dataCellStyle);
/* 2709:     */         
/* 2710:2770 */         cell = row.createCell(8);
/* 2711:2771 */         cell.setCellValue(TicketStatus.getTicketStatus(this.resultSet
/* 2712:2772 */           .getInt("STATUS")));
/* 2713:2773 */         cell.setCellStyle(dataCellStyle);
/* 2714:     */         
/* 2715:2775 */         cell = row.createCell(9);
/* 2716:2776 */         cell.setCellValue(
/* 2717:2777 */           TicketPriority.getTicketPriority(this.resultSet
/* 2718:2778 */           .getInt("PRIORITY")));
/* 2719:2779 */         cell.setCellStyle(dataCellStyle);
/* 2720:     */         
/* 2721:2781 */         cell = row.createCell(10);
/* 2722:2782 */         cell.setCellValue(this.nameHelper.getTicketChannel(this.resultSet
/* 2723:2783 */           .getInt("REF_CHANNEL")));
/* 2724:2784 */         cell.setCellStyle(dataCellStyle);
/* 2725:     */         
/* 2726:2786 */         cell = row.createCell(11);
/* 2727:2787 */         cell.setCellValue(this.resultSet.getString("DUE_DATE_TIME"));
/* 2728:2788 */         cell.setCellStyle(dataCellStyle);
/* 2729:     */         
/* 2730:2790 */         cell = row.createCell(12);
/* 2731:2791 */         cell.setCellValue(this.resultSet.getString("DESCRIPTION"));
/* 2732:2792 */         cell.setCellStyle(dataCellStyle);
/* 2733:     */         
/* 2734:2794 */         cell = row.createCell(13);
/* 2735:2795 */         cell.setCellValue(this.resultSet.getString("ATTACHMENT"));
/* 2736:2796 */         cell.setCellStyle(dataCellStyle);
/* 2737:     */         
/* 2738:2798 */         li.add(this.daoImpl);
/* 2739:     */       }
/* 2740:2801 */       ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
/* 2741:2802 */       wb.write(outByteStream);
/* 2742:2803 */       byte[] outArray = outByteStream.toByteArray();
/* 2743:2804 */       response.setContentType("application/ms-excel");
/* 2744:2805 */       response.setContentLength(outArray.length);
/* 2745:2806 */       response.setHeader("Expires:", "0");
/* 2746:2807 */       response.setHeader("Content-Disposition", 
/* 2747:2808 */         "attachment; filename=Ticket_list.xls");
/* 2748:     */       
/* 2749:     */ 
/* 2750:2811 */       ServletOutputStream fileOut = response.getOutputStream();
/* 2751:2812 */       fileOut.write(outArray);
/* 2752:2813 */       fileOut.flush();
/* 2753:2814 */       fileOut.close();
/* 2754:     */     }
/* 2755:     */     catch (Exception e)
/* 2756:     */     {
/* 2757:2817 */       e.printStackTrace();
/* 2758:     */     }
/* 2759:     */   }
/* 2760:     */   
/* 2761:     */   public void retriveExpensesMonthlyExcelReport(HttpServletRequest request, HttpServletResponse response)
/* 2762:     */   {
/* 2763:     */     try
/* 2764:     */     {
/* 2765:2827 */       System.out.println("try");
/* 2766:2828 */       this.connection = getConnection();
/* 2767:2829 */       String query = "SELECT * FROM TAB_EXPENSES_MONTHLY";
/* 2768:2830 */       this.preparedStatement = this.connection.prepareStatement(query);
/* 2769:2831 */       this.resultSet = this.preparedStatement.executeQuery();
/* 2770:2832 */       System.out.println("executeQuery");
/* 2771:2833 */       int currentRow = 1;
/* 2772:     */       
/* 2773:2835 */       Workbook wb = new HSSFWorkbook();
/* 2774:2836 */       Sheet spreadSheet = wb.createSheet("Expenses Monthly List");
/* 2775:     */       
/* 2776:     */ 
/* 2777:2839 */       Row row = spreadSheet.createRow(0);
/* 2778:     */       
/* 2779:     */ 
/* 2780:2842 */       CellStyle headerCellStyle = wb.createCellStyle();
/* 2781:2843 */       headerCellStyle.setFillForegroundColor((short)49);
/* 2782:2844 */       headerCellStyle.setFillPattern((short)1);
/* 2783:     */       
/* 2784:2846 */       Font setFont = wb.createFont();
/* 2785:2847 */       setFont.setFontHeightInPoints((short)11);
/* 2786:2848 */       setFont.setColor((short)8);
/* 2787:2849 */       setFont.setBoldweight((short)700);
/* 2788:2850 */       headerCellStyle.setBorderBottom((short)1);
/* 2789:2851 */       headerCellStyle.setFont(setFont);
/* 2790:     */       
/* 2791:     */ 
/* 2792:2854 */       CellStyle dataCellStyle = wb.createCellStyle();
/* 2793:2855 */       Font setDataFont = wb.createFont();
/* 2794:2856 */       setDataFont.setColor((short)8);
/* 2795:2857 */       dataCellStyle.setBorderBottom((short)0);
/* 2796:2858 */       dataCellStyle.setFont(setDataFont);
/* 2797:     */       
/* 2798:2860 */       Cell cell = null;
/* 2799:     */       
/* 2800:2862 */       spreadSheet.setColumnWidth(0, 2560);
/* 2801:2863 */       spreadSheet.setColumnWidth(1, 7680);
/* 2802:2864 */       spreadSheet.setColumnWidth(2, 6400);
/* 2803:2865 */       spreadSheet.setColumnWidth(3, 6400);
/* 2804:2866 */       spreadSheet.setColumnWidth(4, 6400);
/* 2805:2867 */       spreadSheet.setColumnWidth(5, 6400);
/* 2806:2868 */       spreadSheet.setColumnWidth(6, 6400);
/* 2807:2869 */       spreadSheet.setColumnWidth(7, 6400);
/* 2808:2870 */       spreadSheet.setColumnWidth(8, 6400);
/* 2809:2871 */       spreadSheet.setColumnWidth(9, 6400);
/* 2810:2872 */       spreadSheet.setColumnWidth(10, 6400);
/* 2811:2873 */       spreadSheet.setColumnWidth(11, 6400);
/* 2812:2874 */       spreadSheet.setColumnWidth(12, 6400);
/* 2813:2875 */       spreadSheet.setColumnWidth(13, 6400);
/* 2814:     */       
/* 2815:     */ 
/* 2816:2878 */       cell = row.createCell(0);
/* 2817:2879 */       cell.setCellValue("Expenses Monthly Id");
/* 2818:2880 */       cell.setCellStyle(headerCellStyle);
/* 2819:     */       
/* 2820:2882 */       cell = row.createCell(1);
/* 2821:2883 */       cell.setCellValue("Name");
/* 2822:2884 */       cell.setCellStyle(headerCellStyle);
/* 2823:     */       
/* 2824:2886 */       cell = row.createCell(2);
/* 2825:2887 */       cell.setCellValue("Place Of Visit");
/* 2826:2888 */       cell.setCellStyle(headerCellStyle);
/* 2827:     */       
/* 2828:2890 */       cell = row.createCell(3);
/* 2829:2891 */       cell.setCellValue("Purpose Of Visit");
/* 2830:2892 */       cell.setCellStyle(headerCellStyle);
/* 2831:     */       
/* 2832:2894 */       cell = row.createCell(4);
/* 2833:2895 */       cell.setCellValue("Departure Date");
/* 2834:2896 */       cell.setCellStyle(headerCellStyle);
/* 2835:     */       
/* 2836:2898 */       cell = row.createCell(5);
/* 2837:2899 */       cell.setCellValue("Arrival Date");
/* 2838:2900 */       cell.setCellStyle(headerCellStyle);
/* 2839:     */       
/* 2840:2902 */       cell = row.createCell(6);
/* 2841:2903 */       cell.setCellValue("Approve By");
/* 2842:2904 */       cell.setCellStyle(headerCellStyle);
/* 2843:     */       
/* 2844:2906 */       cell = row.createCell(7);
/* 2845:2907 */       cell.setCellValue("Total Amount A");
/* 2846:2908 */       cell.setCellStyle(headerCellStyle);
/* 2847:     */       
/* 2848:2910 */       cell = row.createCell(8);
/* 2849:2911 */       cell.setCellValue("Total Amount B");
/* 2850:2912 */       cell.setCellStyle(headerCellStyle);
/* 2851:     */       
/* 2852:2914 */       cell = row.createCell(9);
/* 2853:2915 */       cell.setCellValue("Advance Amount C");
/* 2854:2916 */       cell.setCellStyle(headerCellStyle);
/* 2855:     */       
/* 2856:2918 */       cell = row.createCell(10);
/* 2857:2919 */       cell.setCellValue("Claimed Balance");
/* 2858:2920 */       cell.setCellStyle(headerCellStyle);
/* 2859:     */       
/* 2860:2922 */       cell = row.createCell(11);
/* 2861:2923 */       cell.setCellValue("Claime By");
/* 2862:2924 */       cell.setCellStyle(headerCellStyle);
/* 2863:     */       
/* 2864:2926 */       cell = row.createCell(12);
/* 2865:2927 */       cell.setCellValue("Claime Status");
/* 2866:2928 */       cell.setCellStyle(headerCellStyle);
/* 2867:     */       
/* 2868:2930 */       cell = row.createCell(13);
/* 2869:2931 */       cell.setCellValue("Claim Comment");
/* 2870:2932 */       cell.setCellStyle(headerCellStyle);
/* 2871:     */       
/* 2872:     */ 
/* 2873:     */ 
/* 2874:2936 */       List<ExcelReportDaoImpl> li = new ArrayList();
/* 2875:2937 */       while (this.resultSet.next())
/* 2876:     */       {
/* 2877:2939 */         this.daoImpl = new ExcelReportDaoImpl();
/* 2878:     */         
/* 2879:     */ 
/* 2880:2942 */         row = spreadSheet.createRow(currentRow++);
/* 2881:     */         
/* 2882:2944 */         cell = row.createCell(0);
/* 2883:2945 */         cell.setCellValue(this.resultSet.getString("MONTHLI_CLAIM_ID"));
/* 2884:2946 */         cell.setCellStyle(dataCellStyle);
/* 2885:     */         
/* 2886:2948 */         cell = row.createCell(1);
/* 2887:2949 */         cell.setCellValue(this.resultSet.getString("NAME"));
/* 2888:2950 */         cell.setCellStyle(dataCellStyle);
/* 2889:     */         
/* 2890:2952 */         cell = row.createCell(2);
/* 2891:2953 */         cell.setCellValue(this.resultSet.getString("PLACE_OF_VISIT"));
/* 2892:2954 */         cell.setCellStyle(dataCellStyle);
/* 2893:     */         
/* 2894:2956 */         cell = row.createCell(3);
/* 2895:2957 */         cell.setCellValue(this.resultSet.getString("PURPOSE_OF_VISIT"));
/* 2896:2958 */         cell.setCellStyle(dataCellStyle);
/* 2897:     */         
/* 2898:2960 */         cell = row.createCell(4);
/* 2899:2961 */         cell.setCellValue(this.resultSet.getString("DEPARTURE_DATE"));
/* 2900:2962 */         cell.setCellStyle(dataCellStyle);
/* 2901:     */         
/* 2902:2964 */         cell = row.createCell(5);
/* 2903:2965 */         cell.setCellValue(this.resultSet.getString("ARRIVAL_DATE"));
/* 2904:2966 */         cell.setCellStyle(dataCellStyle);
/* 2905:     */         
/* 2906:2968 */         cell = row.createCell(6);
/* 2907:2969 */         cell.setCellValue(this.nameHelper.getAssignTo(
/* 2908:2970 */           this.resultSet
/* 2909:2971 */           .getInt("APPROVED_BY")));
/* 2910:2972 */         cell.setCellStyle(dataCellStyle);
/* 2911:     */         
/* 2912:2974 */         cell = row.createCell(7);
/* 2913:2975 */         cell.setCellValue(this.resultSet.getInt("TOTAL_AMOUNT_A"));
/* 2914:2976 */         cell.setCellStyle(dataCellStyle);
/* 2915:     */         
/* 2916:2978 */         cell = row.createCell(8);
/* 2917:2979 */         cell.setCellValue(this.resultSet
/* 2918:2980 */           .getInt("TOTAL_AMOUNT_B"));
/* 2919:2981 */         cell.setCellStyle(dataCellStyle);
/* 2920:     */         
/* 2921:2983 */         cell = row.createCell(9);
/* 2922:2984 */         cell.setCellValue(this.resultSet.getInt("ADVANCE_AMOUNT_C"));
/* 2923:2985 */         cell.setCellStyle(dataCellStyle);
/* 2924:     */         
/* 2925:2987 */         cell = row.createCell(10);
/* 2926:2988 */         cell.setCellValue(this.resultSet.getInt("CLAIMED_BALANCE"));
/* 2927:2989 */         cell.setCellStyle(dataCellStyle);
/* 2928:     */         
/* 2929:2991 */         cell = row.createCell(11);
/* 2930:2992 */         cell.setCellValue(this.resultSet.getString("CLAIM_BY"));
/* 2931:2993 */         cell.setCellStyle(dataCellStyle);
/* 2932:     */         
/* 2933:2995 */         cell = row.createCell(12);
/* 2934:2996 */         cell.setCellValue(this.resultSet.getString("CLAIM_STATUS"));
/* 2935:2997 */         cell.setCellStyle(dataCellStyle);
/* 2936:     */         
/* 2937:2999 */         cell = row.createCell(13);
/* 2938:3000 */         cell.setCellValue(this.resultSet
/* 2939:3001 */           .getString("CLAIM_COMMENT"));
/* 2940:3002 */         cell.setCellStyle(dataCellStyle);
/* 2941:     */         
/* 2942:     */ 
/* 2943:3005 */         li.add(this.daoImpl);
/* 2944:     */       }
/* 2945:3008 */       ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
/* 2946:3009 */       wb.write(outByteStream);
/* 2947:3010 */       byte[] outArray = outByteStream.toByteArray();
/* 2948:3011 */       response.setContentType("application/ms-excel");
/* 2949:3012 */       response.setContentLength(outArray.length);
/* 2950:3013 */       response.setHeader("Expires:", "0");
/* 2951:3014 */       response.setHeader("Content-Disposition", 
/* 2952:3015 */         "attachment; filename=ExpensesMonthly_list.xls");
/* 2953:     */       
/* 2954:     */ 
/* 2955:3018 */       ServletOutputStream fileOut = response.getOutputStream();
/* 2956:3019 */       fileOut.write(outArray);
/* 2957:3020 */       fileOut.flush();
/* 2958:3021 */       fileOut.close();
/* 2959:     */     }
/* 2960:     */     catch (Exception e)
/* 2961:     */     {
/* 2962:3024 */       e.printStackTrace();
/* 2963:     */     }
/* 2964:     */   }
/* 2965:     */   
/* 2966:     */   public void purchaseCementExcelReport(HttpServletRequest request, HttpServletResponse response)
/* 2967:     */   {
/* 2968:     */     try
/* 2969:     */     {
/* 2970:3034 */       System.out.println("try");
/* 2971:3035 */       this.connection = getConnection();
/* 2972:     */       
/* 2973:3037 */       String query = "SELECT * FROM TAB_PURCHASE_CEMENT_DETAIL";
/* 2974:3038 */       this.preparedStatement = this.connection.prepareStatement(query);
/* 2975:     */       String path=request.getSession().getServletContext().getRealPath("/").concat("excels")+File.separator+"PurchasedCement_list.xls";

/* 2977:3041 */       this.resultSet = this.preparedStatement.executeQuery();
/* 2978:3042 */       System.out.println("executeQuery");
/* 2979:3043 */       int currentRow = 1;

/* 2981:3045 */       Workbook wb = new HSSFWorkbook();
/* 2982:3046 */       Sheet spreadSheet = wb.createSheet("Purchased List");
/* 2983:     */       System.out.println();
/* 2984:     */ 
/* 2985:3049 */       Row row = spreadSheet.createRow(0);
/* 2986:     */       
/* 2987:     */ 
/* 2988:3052 */       CellStyle headerCellStyle = wb.createCellStyle();
/* 2989:3053 */       headerCellStyle.setFillForegroundColor((short)49);
/* 2990:3054 */       headerCellStyle.setFillPattern((short)1);
/* 2991:     */       
/* 2992:3056 */       Font setFont = wb.createFont();
/* 2993:3057 */       setFont.setFontHeightInPoints((short)11);
/* 2994:3058 */       setFont.setColor((short)8);
/* 2995:3059 */       setFont.setBoldweight((short)700);
/* 2996:3060 */       headerCellStyle.setBorderBottom((short)1);
/* 2997:3061 */       headerCellStyle.setFont(setFont);
/* 2998:     */       
/* 2999:     */ 
/* 3000:3064 */       CellStyle dataCellStyle = wb.createCellStyle();
/* 3001:3065 */       Font setDataFont = wb.createFont();
/* 3002:3066 */       setDataFont.setColor((short)8);
/* 3003:3067 */       dataCellStyle.setBorderBottom((short)0);
/* 3004:3068 */       dataCellStyle.setFont(setDataFont);
/* 3005:     */       
/* 3006:3070 */       Cell cell = null;
/* 3007:     */       
/* 3008:3072 */       spreadSheet.setColumnWidth(0, 2560);
/* 3009:3073 */       spreadSheet.setColumnWidth(1, 7680);
/* 3010:3074 */       spreadSheet.setColumnWidth(2, 6400);
/* 3011:3075 */       spreadSheet.setColumnWidth(3, 6400);
/* 3012:3076 */       spreadSheet.setColumnWidth(4, 6400);
/* 3013:3077 */       spreadSheet.setColumnWidth(5, 6400);
/* 3014:3078 */       spreadSheet.setColumnWidth(6, 6400);
/* 3015:3079 */       spreadSheet.setColumnWidth(7, 6400);
/* 3016:3080 */       spreadSheet.setColumnWidth(8, 6400);
/* 3017:3081 */       spreadSheet.setColumnWidth(9, 6400);
/* 3018:3082 */       spreadSheet.setColumnWidth(10, 6400);
/* 3019:3083 */       spreadSheet.setColumnWidth(11, 6400);
/* 3020:3084 */       spreadSheet.setColumnWidth(12, 6400);
/* 3021:3085 */       spreadSheet.setColumnWidth(13, 6400);
/* 3022:3086 */       spreadSheet.setColumnWidth(14, 6400);
/* 3023:3087 */       spreadSheet.setColumnWidth(15, 6400);
/* 3024:3088 */       spreadSheet.setColumnWidth(16, 6400);
/* 3025:3089 */       spreadSheet.setColumnWidth(17, 6400);
/* 3026:3090 */       spreadSheet.setColumnWidth(18, 6400);
/* 3027:3091 */       spreadSheet.setColumnWidth(19, 6400);
/* 3028:3092 */       spreadSheet.setColumnWidth(20, 6400);
/* 3029:3093 */       spreadSheet.setColumnWidth(21, 6400);
/* 3030:3094 */       spreadSheet.setColumnWidth(22, 6400);
/* 3031:3095 */       spreadSheet.setColumnWidth(23, 6400);
/* 3032:3096 */       spreadSheet.setColumnWidth(24, 6400);
/* 3033:3097 */       spreadSheet.setColumnWidth(25, 6400);
/* 3034:3098 */       spreadSheet.setColumnWidth(26, 6400);
/* 3035:3099 */       spreadSheet.setColumnWidth(27, 6400);
/* 3036:3100 */       spreadSheet.setColumnWidth(28, 6400);
/* 3037:     */       
/* 3038:     */ 
/* 3039:3103 */       cell = row.createCell(0);
/* 3040:3104 */       cell.setCellValue("Purchased Id");
/* 3041:3105 */       cell.setCellStyle(headerCellStyle);
/* 3042:     */       
/* 3043:3107 */       cell = row.createCell(1);
/* 3044:3108 */       cell.setCellValue("Company Name");
/* 3045:3109 */       cell.setCellStyle(headerCellStyle);
/* 3046:     */       
/* 3047:3111 */       cell = row.createCell(2);
/* 3048:3112 */       cell.setCellValue("Price");
/* 3049:3113 */       cell.setCellStyle(headerCellStyle);
/* 3050:     */       
/* 3051:3115 */       cell = row.createCell(3);
/* 3052:3116 */       cell.setCellValue("Amount");
/* 3053:3117 */       cell.setCellStyle(headerCellStyle);
/* 3054:     */       
/* 3055:3119 */       cell = row.createCell(4);
/* 3056:3120 */       cell.setCellValue("GST (%)");
/* 3057:3121 */       cell.setCellStyle(headerCellStyle);
/* 3058:     */       
/* 3059:3123 */       cell = row.createCell(5);
/* 3060:3124 */       cell.setCellValue("CGST (%)");
/* 3061:3125 */       cell.setCellStyle(headerCellStyle);
/* 3062:     */       
/* 3063:3127 */       cell = row.createCell(6);
/* 3064:3128 */       cell.setCellValue("SGST (%)");
/* 3065:3129 */       cell.setCellStyle(headerCellStyle);
/* 3066:     */       
/* 3067:3131 */       cell = row.createCell(7);
/* 3068:3132 */       cell.setCellValue("Dealer Name");
/* 3069:3133 */       cell.setCellStyle(headerCellStyle);
/* 3070:     */       
/* 3071:3135 */       cell = row.createCell(8);
/* 3072:3136 */       cell.setCellValue("Dealer Contact");
/* 3073:3137 */       cell.setCellStyle(headerCellStyle);
/* 3074:     */       
/* 3075:3139 */       cell = row.createCell(9);
/* 3076:3140 */       cell.setCellValue("Dealer Address");
/* 3077:3141 */       cell.setCellStyle(headerCellStyle);
/* 3078:     */       
/* 3079:3143 */       cell = row.createCell(10);
/* 3080:3144 */       cell.setCellValue("Dealer Refference");
/* 3081:3145 */       cell.setCellStyle(headerCellStyle);
/* 3082:     */       
/* 3083:3147 */       cell = row.createCell(11);
/* 3084:3148 */       cell.setCellValue("Bags in No.");
/* 3085:3149 */       cell.setCellStyle(headerCellStyle);
/* 3086:     */       
/* 3087:3151 */       cell = row.createCell(12);
/* 3088:3152 */       cell.setCellValue("Bags in Ton");
/* 3089:3153 */       cell.setCellStyle(headerCellStyle);
/* 3090:     */       
/* 3091:3155 */       cell = row.createCell(13);
/* 3092:3156 */       cell.setCellValue("GST Amount");
/* 3093:3157 */       cell.setCellStyle(headerCellStyle);
/* 3094:     */       
/* 3095:3159 */       cell = row.createCell(14);
/* 3096:3160 */       cell.setCellValue("CGST Amount");
/* 3097:3161 */       cell.setCellStyle(headerCellStyle);
/* 3098:     */       
/* 3099:3163 */       cell = row.createCell(15);
/* 3100:3164 */       cell.setCellValue("SGST Amount");
/* 3101:3165 */       cell.setCellStyle(headerCellStyle);
/* 3102:     */       
/* 3103:3167 */       cell = row.createCell(16);
/* 3104:3168 */       cell.setCellValue("Invoice No");
/* 3105:3169 */       cell.setCellStyle(headerCellStyle);
/* 3106:     */       
/* 3107:3171 */       cell = row.createCell(17);
/* 3108:3172 */       cell.setCellValue("Order No");
/* 3109:3173 */       cell.setCellStyle(headerCellStyle);
/* 3110:     */       
/* 3111:3175 */       cell = row.createCell(18);
/* 3112:3176 */       cell.setCellValue("Carrier Name");
/* 3113:3177 */       cell.setCellStyle(headerCellStyle);
/* 3114:     */       
/* 3115:3179 */       cell = row.createCell(19);
/* 3116:3180 */       cell.setCellValue("Payment Mode");
/* 3117:3181 */       cell.setCellStyle(headerCellStyle);
/* 3118:     */       
/* 3119:3183 */       cell = row.createCell(20);
/* 3120:3184 */       cell.setCellValue("Week No");
/* 3121:3185 */       cell.setCellStyle(headerCellStyle);
/* 3122:     */       
/* 3123:3187 */       cell = row.createCell(21);
/* 3124:3188 */       cell.setCellValue("Incoterm");
/* 3125:3189 */       cell.setCellStyle(headerCellStyle);
/* 3126:     */       
/* 3127:3191 */       cell = row.createCell(22);
/* 3128:3192 */       cell.setCellValue("Payment");
/* 3129:3193 */       cell.setCellStyle(headerCellStyle);
/* 3130:     */       
/* 3131:3195 */       cell = row.createCell(23);
/* 3132:3196 */       cell.setCellValue("Invoice Date");
/* 3133:3197 */       cell.setCellStyle(headerCellStyle);
/* 3134:     */       
/* 3135:3199 */       cell = row.createCell(24);
/* 3136:3200 */       cell.setCellValue("Material Code");
/* 3137:3201 */       cell.setCellStyle(headerCellStyle);
/* 3138:     */       
/* 3139:3203 */       cell = row.createCell(25);
/* 3140:3204 */       cell.setCellValue("HSN Code");
/* 3141:3205 */       cell.setCellStyle(headerCellStyle);
/* 3142:     */       
/* 3143:3207 */       cell = row.createCell(26);
/* 3144:3208 */       cell.setCellValue("Delivery Place");
/* 3145:3209 */       cell.setCellStyle(headerCellStyle);
/* 3146:     */       
/* 3147:3211 */       cell = row.createCell(27);
/* 3148:3212 */       cell.setCellValue("Unit Price");
/* 3149:3213 */       cell.setCellStyle(headerCellStyle);
/* 3150:     */       
/* 3151:3215 */       cell = row.createCell(28);
/* 3152:3216 */       cell.setCellValue("Discount");
/* 3153:3217 */       cell.setCellStyle(headerCellStyle);
/* 3154:     */       
/* 3155:     */ 
/* 3156:     */ 
/* 3157:     */ 
/* 3158:     */ 
/* 3159:     */ 
/* 3160:     */ 
/* 3161:3225 */       List<ExcelReportDaoImpl> li = new ArrayList();
/* 3162:3226 */       while (this.resultSet.next())
/* 3163:     */       {
/* 3164:3228 */         this.daoImpl = new ExcelReportDaoImpl();
/* 3165:     */         
/* 3166:     */ 
/* 3167:3231 */         row = spreadSheet.createRow(currentRow++);
/* 3168:     */         
/* 3169:3233 */         cell = row.createCell(0);
/* 3170:3234 */         cell.setCellValue(this.resultSet.getInt("PUR_CEMENT_ID"));
/* 3171:3235 */         cell.setCellStyle(dataCellStyle);
/* 3172:     */         
/* 3173:3237 */         cell = row.createCell(1);
/* 3174:3238 */         cell.setCellValue(this.resultSet.getString("PUR_CEMENT_COMPANY_NAME"));
/* 3175:3239 */         cell.setCellStyle(dataCellStyle);
/* 3176:     */         
/* 3177:3241 */         cell = row.createCell(2);
/* 3178:3242 */         cell.setCellValue(this.resultSet.getFloat("PUR_CEMENT_PRICE"));
/* 3179:3243 */         cell.setCellStyle(dataCellStyle);
/* 3180:     */         
/* 3181:3245 */         cell = row.createCell(3);
/* 3182:3246 */         cell.setCellValue(this.resultSet.getFloat("PUR_CEMENT_AMOUNT"));
/* 3183:3247 */         cell.setCellStyle(dataCellStyle);
/* 3184:     */         
/* 3185:3249 */         cell = row.createCell(4);
/* 3186:3250 */         cell.setCellValue(this.resultSet.getFloat("PUR_CEMENT_GST"));
/* 3187:3251 */         cell.setCellStyle(dataCellStyle);
/* 3188:     */         
/* 3189:3253 */         cell = row.createCell(5);
/* 3190:3254 */         cell.setCellValue(this.resultSet.getFloat("PUR_CEMENT_CGST"));
/* 3191:3255 */         cell.setCellStyle(dataCellStyle);
/* 3192:     */         
/* 3193:3257 */         cell = row.createCell(6);
/* 3194:3258 */         cell.setCellValue(
/* 3195:3259 */           this.resultSet
/* 3196:3260 */           .getFloat("PUR_CEMENT_SGST"));
/* 3197:3261 */         cell.setCellStyle(dataCellStyle);
/* 3198:     */         
/* 3199:3263 */         cell = row.createCell(7);
/* 3200:3264 */         cell.setCellValue(this.resultSet.getString("PUR_CEMENT_DEALER_NAME"));
/* 3201:3265 */         cell.setCellStyle(dataCellStyle);
/* 3202:     */         
/* 3203:3267 */         cell = row.createCell(8);
/* 3204:3268 */         cell.setCellValue(this.resultSet
/* 3205:3269 */           .getString("PUR_CEMENT_DEALER_CONTACT"));
/* 3206:3270 */         cell.setCellStyle(dataCellStyle);
/* 3207:     */         
/* 3208:3272 */         cell = row.createCell(9);
/* 3209:3273 */         cell.setCellValue(this.resultSet.getString("PUR_CEMENT_DEALER_ADDRESS"));
/* 3210:3274 */         cell.setCellStyle(dataCellStyle);
/* 3211:     */         
/* 3212:3276 */         cell = row.createCell(10);
/* 3213:3277 */         cell.setCellValue(this.resultSet.getInt("PUR_CEMENT_DEALER_REF"));
/* 3214:3278 */         cell.setCellStyle(dataCellStyle);
/* 3215:     */         
/* 3216:3280 */         cell = row.createCell(11);
/* 3217:3281 */         cell.setCellValue(this.resultSet.getInt("PUR_CEMENT_BAGS_NO"));
/* 3218:3282 */         cell.setCellStyle(dataCellStyle);
/* 3219:     */         
/* 3220:3284 */         cell = row.createCell(12);
/* 3221:3285 */         cell.setCellValue(this.resultSet.getFloat("PUR_CEMENT_BAGS_TON"));
/* 3222:3286 */         cell.setCellStyle(dataCellStyle);
/* 3223:     */         
/* 3224:3288 */         cell = row.createCell(13);
/* 3225:3289 */         cell.setCellValue(this.resultSet
/* 3226:3290 */           .getFloat("PUR_CEMENT_GST_AMOUNT"));
/* 3227:3291 */         cell.setCellStyle(dataCellStyle);
/* 3228:     */         
/* 3229:3293 */         cell = row.createCell(14);
/* 3230:3294 */         cell.setCellValue(this.resultSet.getFloat("PUR_CEMENT_CGST_AMOUNT"));
/* 3231:3295 */         cell.setCellStyle(dataCellStyle);
/* 3232:     */         
/* 3233:3297 */         cell = row.createCell(15);
/* 3234:3298 */         cell.setCellValue(this.resultSet.getFloat("PUR_CEMENT_SGST_AMOUNT"));
/* 3235:3299 */         cell.setCellStyle(dataCellStyle);
/* 3236:     */         
/* 3237:3301 */         cell = row.createCell(16);
/* 3238:3302 */         cell.setCellValue(this.resultSet.getString("PUR_CEMENT_INVOICE_NO"));
/* 3239:3303 */         cell.setCellStyle(dataCellStyle);
/* 3240:     */         
/* 3241:3305 */         cell = row.createCell(17);
/* 3242:3306 */         cell.setCellValue(this.resultSet.getString("PUR_CEMENT_ORDER_NO"));
/* 3243:3307 */         cell.setCellStyle(dataCellStyle);
/* 3244:     */         
/* 3245:3309 */         cell = row.createCell(18);
/* 3246:3310 */         cell.setCellValue(this.resultSet.getString("PUR_CEMENT_CARRIER_NAME"));
/* 3247:3311 */         cell.setCellStyle(dataCellStyle);
/* 3248:     */         
/* 3249:3313 */         cell = row.createCell(19);
/* 3250:3314 */         cell.setCellValue(this.resultSet.getString("PUR_CEMENT_PAYMENT_MODE"));
/* 3251:3315 */         cell.setCellStyle(dataCellStyle);
/* 3252:     */         
/* 3253:3317 */         cell = row.createCell(20);
/* 3254:3318 */         cell.setCellValue(this.resultSet.getString("PUR_CEMENT_WEEK_NO"));
/* 3255:3319 */         cell.setCellStyle(dataCellStyle);
/* 3256:     */         
/* 3257:3321 */         cell = row.createCell(21);
/* 3258:3322 */         cell.setCellValue(this.resultSet.getString("PUR_CEMENT_INCOTERM"));
/* 3259:3323 */         cell.setCellStyle(dataCellStyle);
/* 3260:     */         
/* 3261:3325 */         cell = row.createCell(22);
/* 3262:3326 */         cell.setCellValue(this.resultSet.getFloat("PUR_CEMENT_PAYMENT"));
/* 3263:3327 */         cell.setCellStyle(dataCellStyle);
/* 3264:     */         
/* 3265:3329 */         cell = row.createCell(23);
/* 3266:3330 */         cell.setCellValue(this.resultSet.getString("PUR_CEMENT_INVOICE_DATE"));
/* 3267:3331 */         cell.setCellStyle(dataCellStyle);
/* 3268:     */         
/* 3269:3333 */         cell = row.createCell(24);
/* 3270:3334 */         cell.setCellValue(this.resultSet.getString("PUR_CEMENT_MATERIAL_CODE"));
/* 3271:3335 */         cell.setCellStyle(dataCellStyle);
/* 3272:     */         
/* 3273:3337 */         cell = row.createCell(25);
/* 3274:3338 */         cell.setCellValue(this.resultSet.getString("PUR_CEMENT_HSN_CODE"));
/* 3275:3339 */         cell.setCellStyle(dataCellStyle);
/* 3276:     */         
/* 3277:3341 */         cell = row.createCell(26);
/* 3278:3342 */         cell.setCellValue(this.resultSet.getString("PUR_CEMENT_DELIVERY_PLACE"));
/* 3279:3343 */         cell.setCellStyle(dataCellStyle);
/* 3280:     */         
/* 3281:3345 */         cell = row.createCell(27);
/* 3282:3346 */         cell.setCellValue(this.resultSet.getFloat("PUR_CEMENT_UNIT_PRICE"));
/* 3283:3347 */         cell.setCellStyle(dataCellStyle);
/* 3284:     */         
/* 3285:3349 */         cell = row.createCell(28);
/* 3286:3350 */         cell.setCellValue(this.resultSet.getFloat("PUR_CEMENT_DISCOUNT"));
/* 3287:3351 */         cell.setCellStyle(dataCellStyle);
/* 3288:     */         
/* 3289:     */ 
/* 3290:3354 */         li.add(this.daoImpl);
/* 3291:     */       }
/* 3292:3357 */       ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
/* 3293:3358 */       wb.write(outByteStream);
/* 3294:3359 */       byte[] outArray = outByteStream.toByteArray();
/* 3295:3360 */       response.setContentType("application/vnd.ms-excel");
/* 3296:3361 */       response.setContentLength(outArray.length);
/* 3297:3362 */     //  response.setHeader("Expires:", "0");
/* 3298:3363 */       response.setHeader("Content-Disposition", 
/* 3299:3364 */         "attachment; filename=PurchasedCement_list.xls");
/* 3300:     */       
/* 3301:     */ 
/* 3302:3367 */       ServletOutputStream fileOut = response.getOutputStream();
/* 3303:3368 */       fileOut.write(outArray);
/* 3304:3369 */       fileOut.flush();
/* 3305:3370 */       fileOut.close();

/* 3306:     */    
logger.info(ExcelReportDaoImpl.class+"we r in purchase excel dao................1111");
/* 3307:     */     } catch (Exception e)
/* 3308:     */     {
/* 3309:3373 */       e.printStackTrace();
logger.error(ExcelReportDaoImpl.class+"ERROR while creating excel for cement purchase", e);
/* 3310:     */     }
/* 3311:     */   }
/* 3312:     */   
/* 3313:     */   public void purchaseSteelBarExcelReport(HttpServletRequest request, HttpServletResponse response)
/* 3314:     */   {
/* 3315:     */     try
/* 3316:     */     {
/* 3317:3382 */       System.out.println("try");
/* 3318:3383 */       this.connection = getConnection();
/* 3319:     */       
/* 3320:3385 */       String query = "SELECT * FROM TAB_PURCHASE_STEEBAR_DETAIL";
/* 3321:3386 */       this.preparedStatement = this.connection.prepareStatement(query);
/* 3322:     */       
/* 3323:     */response= ServletActionContext.getResponse();
/* 3324:3389 */       this.resultSet = this.preparedStatement.executeQuery();
/* 3325:3390 */       System.out.println("executeQuery");
/* 3326:3391 */       int currentRow = 1;
/* 3327:     */       
/* 3328:3393 */       Workbook wb = new HSSFWorkbook();
/* 3329:3394 */       Sheet spreadSheet = wb.createSheet("Purchased Steelbar List");
/* 3330:     */       
/* 3331:     */ 
/* 3332:3397 */       Row row = spreadSheet.createRow(0);
/* 3333:     */       
/* 3334:     */ 
/* 3335:3400 */       CellStyle headerCellStyle = wb.createCellStyle();
/* 3336:3401 */       headerCellStyle.setFillForegroundColor((short)49);
/* 3337:3402 */       headerCellStyle.setFillPattern((short)1);
/* 3338:     */       
/* 3339:3404 */       Font setFont = wb.createFont();
/* 3340:3405 */       setFont.setFontHeightInPoints((short)11);
/* 3341:3406 */       setFont.setColor((short)8);
/* 3342:3407 */       setFont.setBoldweight((short)700);
/* 3343:3408 */       headerCellStyle.setBorderBottom((short)1);
/* 3344:3409 */       headerCellStyle.setFont(setFont);
/* 3345:     */       
/* 3346:     */ 
/* 3347:3412 */       CellStyle dataCellStyle = wb.createCellStyle();
/* 3348:3413 */       Font setDataFont = wb.createFont();
/* 3349:3414 */       setDataFont.setColor((short)8);
/* 3350:3415 */       dataCellStyle.setBorderBottom((short)0);
/* 3351:3416 */       dataCellStyle.setFont(setDataFont);
/* 3352:     */       
/* 3353:3418 */       Cell cell = null;
/* 3354:     */       
/* 3355:3420 */       spreadSheet.setColumnWidth(0, 2560);
/* 3356:3421 */       spreadSheet.setColumnWidth(1, 7680);
/* 3357:3422 */       spreadSheet.setColumnWidth(2, 6400);
/* 3358:3423 */       spreadSheet.setColumnWidth(3, 6400);
/* 3359:3424 */       spreadSheet.setColumnWidth(4, 6400);
/* 3360:3425 */       spreadSheet.setColumnWidth(5, 6400);
/* 3361:3426 */       spreadSheet.setColumnWidth(6, 6400);
/* 3362:3427 */       spreadSheet.setColumnWidth(7, 6400);
/* 3363:3428 */       spreadSheet.setColumnWidth(8, 6400);
/* 3364:3429 */       spreadSheet.setColumnWidth(9, 6400);
/* 3365:3430 */       spreadSheet.setColumnWidth(10, 6400);
/* 3366:3431 */       spreadSheet.setColumnWidth(11, 6400);
/* 3367:3432 */       spreadSheet.setColumnWidth(12, 6400);
/* 3368:3433 */       spreadSheet.setColumnWidth(13, 6400);
/* 3369:3434 */       spreadSheet.setColumnWidth(14, 6400);
/* 3370:3435 */       spreadSheet.setColumnWidth(15, 6400);
/* 3371:3436 */       spreadSheet.setColumnWidth(16, 6400);
/* 3372:3437 */       spreadSheet.setColumnWidth(17, 6400);
/* 3373:3438 */       spreadSheet.setColumnWidth(18, 6400);
/* 3374:3439 */       spreadSheet.setColumnWidth(19, 6400);
/* 3375:3440 */       spreadSheet.setColumnWidth(20, 6400);
/* 3376:3441 */       spreadSheet.setColumnWidth(21, 6400);
/* 3377:3442 */       spreadSheet.setColumnWidth(22, 6400);
/* 3378:3443 */       spreadSheet.setColumnWidth(23, 6400);
/* 3379:3444 */       spreadSheet.setColumnWidth(24, 6400);
/* 3380:3445 */       spreadSheet.setColumnWidth(25, 6400);
/* 3381:3446 */       spreadSheet.setColumnWidth(26, 6400);
/* 3382:3447 */       spreadSheet.setColumnWidth(27, 6400);
/* 3383:3448 */       spreadSheet.setColumnWidth(28, 6400);
/* 3384:     */       
/* 3385:     */ 
/* 3386:3451 */       cell = row.createCell(0);
/* 3387:3452 */       cell.setCellValue("Purchased Id");
/* 3388:3453 */       cell.setCellStyle(headerCellStyle);
/* 3389:     */       
/* 3390:3455 */       cell = row.createCell(1);
/* 3391:3456 */       cell.setCellValue("Company Name");
/* 3392:3457 */       cell.setCellStyle(headerCellStyle);
/* 3393:     */       
/* 3394:3459 */       cell = row.createCell(2);
/* 3395:3460 */       cell.setCellValue("Price");
/* 3396:3461 */       cell.setCellStyle(headerCellStyle);
/* 3397:     */       
/* 3398:3463 */       cell = row.createCell(3);
/* 3399:3464 */       cell.setCellValue("Amount");
/* 3400:3465 */       cell.setCellStyle(headerCellStyle);
/* 3401:     */       
/* 3402:3467 */       cell = row.createCell(4);
/* 3403:3468 */       cell.setCellValue("GST (%)");
/* 3404:3469 */       cell.setCellStyle(headerCellStyle);
/* 3405:     */       
/* 3406:3471 */       cell = row.createCell(5);
/* 3407:3472 */       cell.setCellValue("CGST (%)");
/* 3408:3473 */       cell.setCellStyle(headerCellStyle);
/* 3409:     */       
/* 3410:3475 */       cell = row.createCell(6);
/* 3411:3476 */       cell.setCellValue("SGST (%)");
/* 3412:3477 */       cell.setCellStyle(headerCellStyle);
/* 3413:     */       
/* 3414:3479 */       cell = row.createCell(7);
/* 3415:3480 */       cell.setCellValue("Dealer Name");
/* 3416:3481 */       cell.setCellStyle(headerCellStyle);
/* 3417:     */       
/* 3418:3483 */       cell = row.createCell(8);
/* 3419:3484 */       cell.setCellValue("Dealer Contact");
/* 3420:3485 */       cell.setCellStyle(headerCellStyle);
/* 3421:     */       
/* 3422:3487 */       cell = row.createCell(9);
/* 3423:3488 */       cell.setCellValue("Dealer Address");
/* 3424:3489 */       cell.setCellStyle(headerCellStyle);
/* 3425:     */       
/* 3426:3491 */       cell = row.createCell(10);
/* 3427:3492 */       cell.setCellValue("Dealer Refference");
/* 3428:3493 */       cell.setCellStyle(headerCellStyle);
/* 3429:     */       
/* 3430:3495 */       cell = row.createCell(11);
/* 3431:3496 */       cell.setCellValue("Bags in No.");
/* 3432:3497 */       cell.setCellStyle(headerCellStyle);
/* 3433:     */       
/* 3434:3499 */       cell = row.createCell(12);
/* 3435:3500 */       cell.setCellValue("Bags in Ton");
/* 3436:3501 */       cell.setCellStyle(headerCellStyle);
/* 3437:     */       
/* 3438:3503 */       cell = row.createCell(13);
/* 3439:3504 */       cell.setCellValue("GST Amount");
/* 3440:3505 */       cell.setCellStyle(headerCellStyle);
/* 3441:     */       
/* 3442:3507 */       cell = row.createCell(14);
/* 3443:3508 */       cell.setCellValue("CGST Amount");
/* 3444:3509 */       cell.setCellStyle(headerCellStyle);
/* 3445:     */       
/* 3446:3511 */       cell = row.createCell(15);
/* 3447:3512 */       cell.setCellValue("SGST Amount");
/* 3448:3513 */       cell.setCellStyle(headerCellStyle);
/* 3449:     */       
/* 3450:3515 */       cell = row.createCell(16);
/* 3451:3516 */       cell.setCellValue("Invoice No");
/* 3452:3517 */       cell.setCellStyle(headerCellStyle);
/* 3453:     */       
/* 3454:3519 */       cell = row.createCell(17);
/* 3455:3520 */       cell.setCellValue("Order No");
/* 3456:3521 */       cell.setCellStyle(headerCellStyle);
/* 3457:     */       
/* 3458:3523 */       cell = row.createCell(18);
/* 3459:3524 */       cell.setCellValue("Carrier Name");
/* 3460:3525 */       cell.setCellStyle(headerCellStyle);
/* 3461:     */       
/* 3462:3527 */       cell = row.createCell(19);
/* 3463:3528 */       cell.setCellValue("Payment Mode");
/* 3464:3529 */       cell.setCellStyle(headerCellStyle);
/* 3465:     */       
/* 3466:3531 */       cell = row.createCell(20);
/* 3467:3532 */       cell.setCellValue("Week No");
/* 3468:3533 */       cell.setCellStyle(headerCellStyle);
/* 3469:     */       
/* 3470:3535 */       cell = row.createCell(21);
/* 3471:3536 */       cell.setCellValue("Incoterm");
/* 3472:3537 */       cell.setCellStyle(headerCellStyle);
/* 3473:     */       
/* 3474:3539 */       cell = row.createCell(22);
/* 3475:3540 */       cell.setCellValue("Payment");
/* 3476:3541 */       cell.setCellStyle(headerCellStyle);
/* 3477:     */       
/* 3478:3543 */       cell = row.createCell(23);
/* 3479:3544 */       cell.setCellValue("Invoice Date");
/* 3480:3545 */       cell.setCellStyle(headerCellStyle);
/* 3481:     */       
/* 3482:3547 */       cell = row.createCell(24);
/* 3483:3548 */       cell.setCellValue("Material Code");
/* 3484:3549 */       cell.setCellStyle(headerCellStyle);
/* 3485:     */       
/* 3486:3551 */       cell = row.createCell(25);
/* 3487:3552 */       cell.setCellValue("HSN Code");
/* 3488:3553 */       cell.setCellStyle(headerCellStyle);
/* 3489:     */       
/* 3490:3555 */       cell = row.createCell(26);
/* 3491:3556 */       cell.setCellValue("Delivery Place");
/* 3492:3557 */       cell.setCellStyle(headerCellStyle);
/* 3493:     */       
/* 3494:3559 */       cell = row.createCell(27);
/* 3495:3560 */       cell.setCellValue("Unit Price");
/* 3496:3561 */       cell.setCellStyle(headerCellStyle);
/* 3497:     */       
/* 3498:3563 */       cell = row.createCell(28);
/* 3499:3564 */       cell.setCellValue("Discount");
/* 3500:3565 */       cell.setCellStyle(headerCellStyle);
/* 3501:     */       
/* 3502:     */ 
/* 3503:     */ 
/* 3504:     */ 
/* 3505:     */ 
/* 3506:     */ 
/* 3507:     */ 
/* 3508:3573 */       List<ExcelReportDaoImpl> li = new ArrayList();
/* 3509:3574 */       while (this.resultSet.next())
/* 3510:     */       {
/* 3511:3576 */         this.daoImpl = new ExcelReportDaoImpl();
/* 3512:     */         
/* 3513:     */ 
/* 3514:3579 */         row = spreadSheet.createRow(currentRow++);
/* 3515:     */         
/* 3516:3581 */         cell = row.createCell(0);
/* 3517:3582 */         cell.setCellValue(this.resultSet.getInt("PUR_STEEBAR_ID"));
/* 3518:3583 */         cell.setCellStyle(dataCellStyle);
/* 3519:     */         
/* 3520:3585 */         cell = row.createCell(1);
/* 3521:3586 */         cell.setCellValue(this.resultSet.getString("PUR_STEEBAR_COMPANY_NAME"));
/* 3522:3587 */         cell.setCellStyle(dataCellStyle);
/* 3523:     */         
/* 3524:3589 */         cell = row.createCell(2);
/* 3525:3590 */         cell.setCellValue(this.resultSet.getFloat("PUR_STEEBAR_PRICE"));
/* 3526:3591 */         cell.setCellStyle(dataCellStyle);
/* 3527:     */         
/* 3528:3593 */         cell = row.createCell(3);
/* 3529:3594 */         cell.setCellValue(this.resultSet.getFloat("PUR_STEEBAR_AMOUNT"));
/* 3530:3595 */         cell.setCellStyle(dataCellStyle);
/* 3531:     */         
/* 3532:3597 */         cell = row.createCell(4);
/* 3533:3598 */         cell.setCellValue(this.resultSet.getFloat("PUR_STEEBAR_GST"));
/* 3534:3599 */         cell.setCellStyle(dataCellStyle);
/* 3535:     */         
/* 3536:3601 */         cell = row.createCell(5);
/* 3537:3602 */         cell.setCellValue(this.resultSet.getFloat("PUR_STEEBAR_CGST"));
/* 3538:3603 */         cell.setCellStyle(dataCellStyle);
/* 3539:     */         
/* 3540:3605 */         cell = row.createCell(6);
/* 3541:3606 */         cell.setCellValue(
/* 3542:3607 */           this.resultSet
/* 3543:3608 */           .getFloat("PUR_STEEBAR_SGST"));
/* 3544:3609 */         cell.setCellStyle(dataCellStyle);
/* 3545:     */         
/* 3546:3611 */         cell = row.createCell(7);
/* 3547:3612 */         cell.setCellValue(this.resultSet.getString("PUR_STEEBAR_DEALER_NAME"));
/* 3548:3613 */         cell.setCellStyle(dataCellStyle);
/* 3549:     */         
/* 3550:3615 */         cell = row.createCell(8);
/* 3551:3616 */         cell.setCellValue(this.resultSet
/* 3552:3617 */           .getString("PUR_STEEBAR_DEALER_CONTACT"));
/* 3553:3618 */         cell.setCellStyle(dataCellStyle);
/* 3554:     */         
/* 3555:3620 */         cell = row.createCell(9);
/* 3556:3621 */         cell.setCellValue(this.resultSet.getString("PUR_STEEBAR_DEALER_ADDRESS"));
/* 3557:3622 */         cell.setCellStyle(dataCellStyle);
/* 3558:     */         
/* 3559:3624 */         cell = row.createCell(10);
/* 3560:3625 */         cell.setCellValue(this.resultSet.getInt("PUR_STEEBAR_DEALER_REF"));
/* 3561:3626 */         cell.setCellStyle(dataCellStyle);
/* 3562:     */         
/* 3563:3628 */         cell = row.createCell(11);
/* 3564:3629 */         cell.setCellValue(this.resultSet.getInt("PUR_STEEBAR_BAGS_NO"));
/* 3565:3630 */         cell.setCellStyle(dataCellStyle);
/* 3566:     */         
/* 3567:3632 */         cell = row.createCell(12);
/* 3568:3633 */         cell.setCellValue(this.resultSet.getFloat("PUR_STEEBAR_BAGS_TON"));
/* 3569:3634 */         cell.setCellStyle(dataCellStyle);
/* 3570:     */         
/* 3571:3636 */         cell = row.createCell(13);
/* 3572:3637 */         cell.setCellValue(this.resultSet
/* 3573:3638 */           .getFloat("PUR_STEEBAR_GST_AMOUNT"));
/* 3574:3639 */         cell.setCellStyle(dataCellStyle);
/* 3575:     */         
/* 3576:3641 */         cell = row.createCell(14);
/* 3577:3642 */         cell.setCellValue(this.resultSet.getFloat("PUR_STEEBAR_CGST_AMOUNT"));
/* 3578:3643 */         cell.setCellStyle(dataCellStyle);
/* 3579:     */         
/* 3580:3645 */         cell = row.createCell(15);
/* 3581:3646 */         cell.setCellValue(this.resultSet.getFloat("PUR_STEEBAR_SGST_AMOUNT"));
/* 3582:3647 */         cell.setCellStyle(dataCellStyle);
/* 3583:     */         
/* 3584:3649 */         cell = row.createCell(16);
/* 3585:3650 */         cell.setCellValue(this.resultSet.getString("PUR_STEEBAR_INVOICE_NO"));
/* 3586:3651 */         cell.setCellStyle(dataCellStyle);
/* 3587:     */         
/* 3588:3653 */         cell = row.createCell(17);
/* 3589:3654 */         cell.setCellValue(this.resultSet.getString("PUR_STEEBAR_ORDER_NO"));
/* 3590:3655 */         cell.setCellStyle(dataCellStyle);
/* 3591:     */         
/* 3592:3657 */         cell = row.createCell(18);
/* 3593:3658 */         cell.setCellValue(this.resultSet.getString("PUR_STEEBAR_CARRIER_NAME"));
/* 3594:3659 */         cell.setCellStyle(dataCellStyle);
/* 3595:     */         
/* 3596:3661 */         cell = row.createCell(19);
/* 3597:3662 */         cell.setCellValue(this.resultSet.getString("PUR_STEEBAR_PAYMENT_MODE"));
/* 3598:3663 */         cell.setCellStyle(dataCellStyle);
/* 3599:     */         
/* 3600:3665 */         cell = row.createCell(20);
/* 3601:3666 */         cell.setCellValue(this.resultSet.getString("PUR_STEEBAR_WEEK_NO"));
/* 3602:3667 */         cell.setCellStyle(dataCellStyle);
/* 3603:     */         
/* 3604:3669 */         cell = row.createCell(21);
/* 3605:3670 */         cell.setCellValue(this.resultSet.getString("PUR_STEEBAR_INCOTERM"));
/* 3606:3671 */         cell.setCellStyle(dataCellStyle);
/* 3607:     */         
/* 3608:3673 */         cell = row.createCell(22);
/* 3609:3674 */         cell.setCellValue(this.resultSet.getFloat("PUR_STEEBAR_PAYMENT"));
/* 3610:3675 */         cell.setCellStyle(dataCellStyle);
/* 3611:     */         
/* 3612:3677 */         cell = row.createCell(23);
/* 3613:3678 */         cell.setCellValue(this.resultSet.getString("PUR_STEEBAR_INVOICE_DATE"));
/* 3614:3679 */         cell.setCellStyle(dataCellStyle);
/* 3615:     */         
/* 3616:3681 */         cell = row.createCell(24);
/* 3617:3682 */         cell.setCellValue(this.resultSet.getString("PUR_STEEBAR_MATERIAL_CODE"));
/* 3618:3683 */         cell.setCellStyle(dataCellStyle);
/* 3619:     */         
/* 3620:3685 */         cell = row.createCell(25);
/* 3621:3686 */         cell.setCellValue(this.resultSet.getString("PUR_STEEBAR_HSN_CODE"));
/* 3622:3687 */         cell.setCellStyle(dataCellStyle);
/* 3623:     */         
/* 3624:3689 */         cell = row.createCell(26);
/* 3625:3690 */         cell.setCellValue(this.resultSet.getString("PUR_STEEBAR_DELIVERY_PLACE"));
/* 3626:3691 */         cell.setCellStyle(dataCellStyle);
/* 3627:     */         
/* 3628:3693 */         cell = row.createCell(27);
/* 3629:3694 */         cell.setCellValue(this.resultSet.getFloat("PUR_STEEBAR_UNIT_PRICE"));
/* 3630:3695 */         cell.setCellStyle(dataCellStyle);
/* 3631:     */         
/* 3632:3697 */         cell = row.createCell(28);
/* 3633:3698 */         cell.setCellValue(this.resultSet.getFloat("PUR_STEEBAR_DISCOUNT"));
/* 3634:3699 */         cell.setCellStyle(dataCellStyle);
/* 3635:     */         
/* 3636:     */ 
/* 3637:3702 */         li.add(this.daoImpl);
/* 3638:     */       }
/* 3639:3705 */       ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
/* 3640:3706 */       wb.write(outByteStream);
/* 3641:3707 */       byte[] outArray = outByteStream.toByteArray();
/* 3642:3708 */       response.setContentType("application/vnd.ms-excel");
/* 3643:3709 */       response.setContentLength(outArray.length);
/* 3644:3710 */       //response.setHeader("Expires:", "0");
/* 3645:3711 */       response.setHeader("Content-Disposition", 
/* 3646:3712 */         "attachment; filename=PurchasedSteelbar_list.xls");
/* 3647:     */       
/* 3648:     */ 
/* 3649:3715 */       ServletOutputStream fileOut = response.getOutputStream();
/* 3650:3716 */       wb.write(fileOut);
/* 3651:3717 */       fileOut.flush();
/* 3652:3718 */       fileOut.close();
/* 3653:     */     }
/* 3654:     */     catch (Exception e)
/* 3655:     */     {
/* 3656:3721 */       e.printStackTrace();
/* 3657:     */     }
/* 3658:     */   }
/* 3659:     */   
/* 3660:     */   public void retailerDetailExcelReport(HttpServletRequest request, HttpServletResponse response)
/* 3661:     */   {
/* 3662:     */     try
/* 3663:     */     {
/* 3664:3731 */       System.out.println("try");
/* 3665:3732 */       this.connection = getConnection();
/* 3666:3733 */       String query = "SELECT * FROM TAB_REGULAR_CUSTOMER WHERE REG_CUSTOMER_STATUS='ACTIVE'";
/* 3667:3734 */       this.preparedStatement = this.connection.prepareStatement(query);
/* 3668:3735 */       this.resultSet = this.preparedStatement.executeQuery();
/* 3669:3736 */       System.out.println("executeQuery");
/* 3670:3737 */       int currentRow = 1;
/* 3671:     */       
/* 3672:3739 */       Workbook wb = new HSSFWorkbook();
/* 3673:3740 */       Sheet spreadSheet = wb.createSheet("Retailer Detail List");
/* 3674:     */       
/* 3675:     */ 
/* 3676:3743 */       Row row = spreadSheet.createRow(0);
/* 3677:     */       
/* 3678:     */ 
/* 3679:3746 */       CellStyle headerCellStyle = wb.createCellStyle();
/* 3680:3747 */       headerCellStyle.setFillForegroundColor((short)49);
/* 3681:3748 */       headerCellStyle.setFillPattern((short)1);
/* 3682:     */       
/* 3683:3750 */       Font setFont = wb.createFont();
/* 3684:3751 */       setFont.setFontHeightInPoints((short)11);
/* 3685:3752 */       setFont.setColor((short)8);
/* 3686:3753 */       setFont.setBoldweight((short)700);
/* 3687:3754 */       headerCellStyle.setBorderBottom((short)1);
/* 3688:3755 */       headerCellStyle.setFont(setFont);
/* 3689:     */       
/* 3690:     */ 
/* 3691:3758 */       CellStyle dataCellStyle = wb.createCellStyle();
/* 3692:3759 */       Font setDataFont = wb.createFont();
/* 3693:3760 */       setDataFont.setColor((short)8);
/* 3694:3761 */       dataCellStyle.setBorderBottom((short)0);
/* 3695:3762 */       dataCellStyle.setFont(setDataFont);
/* 3696:     */       
/* 3697:3764 */       Cell cell = null;
/* 3698:     */       
/* 3699:3766 */       spreadSheet.setColumnWidth(0, 2560);
/* 3700:3767 */       spreadSheet.setColumnWidth(1, 7680);
/* 3701:3768 */       spreadSheet.setColumnWidth(2, 6400);
/* 3702:3769 */       spreadSheet.setColumnWidth(3, 6400);
/* 3703:3770 */       spreadSheet.setColumnWidth(4, 6400);
/* 3704:3771 */       spreadSheet.setColumnWidth(5, 6400);
/* 3705:3772 */       spreadSheet.setColumnWidth(6, 6400);
/* 3706:3773 */       spreadSheet.setColumnWidth(7, 6400);
/* 3707:3774 */       spreadSheet.setColumnWidth(8, 6400);
/* 3708:3775 */       spreadSheet.setColumnWidth(9, 6400);
/* 3709:3776 */       spreadSheet.setColumnWidth(10, 6400);
/* 3710:3777 */       spreadSheet.setColumnWidth(11, 6400);
/* 3711:3778 */       spreadSheet.setColumnWidth(12, 6400);
/* 3712:3779 */       spreadSheet.setColumnWidth(13, 6400);
/* 3713:3780 */       spreadSheet.setColumnWidth(14, 6400);
/* 3714:3781 */       spreadSheet.setColumnWidth(15, 6400);
/* 3715:3782 */       spreadSheet.setColumnWidth(16, 6400);
/* 3716:3783 */       spreadSheet.setColumnWidth(17, 6400);
/* 3717:3784 */       spreadSheet.setColumnWidth(18, 6400);
/* 3718:3785 */       spreadSheet.setColumnWidth(19, 6400);
/* 3719:3786 */       spreadSheet.setColumnWidth(20, 6400);
/* 3720:3787 */       spreadSheet.setColumnWidth(21, 6400);
/* 3721:3788 */       spreadSheet.setColumnWidth(22, 6400);
/* 3722:3789 */       spreadSheet.setColumnWidth(23, 6400);
/* 3723:3790 */       spreadSheet.setColumnWidth(24, 6400);
/* 3724:3791 */       spreadSheet.setColumnWidth(25, 6400);
/* 3725:3792 */       spreadSheet.setColumnWidth(26, 6400);
/* 3726:3793 */       spreadSheet.setColumnWidth(27, 6400);
/* 3727:3794 */       spreadSheet.setColumnWidth(28, 6400);
/* 3728:3795 */       spreadSheet.setColumnWidth(29, 6400);
/* 3729:3796 */       spreadSheet.setColumnWidth(30, 6400);
/* 3730:3797 */       spreadSheet.setColumnWidth(31, 6400);
/* 3731:3798 */       spreadSheet.setColumnWidth(32, 6400);
/* 3732:3799 */       spreadSheet.setColumnWidth(33, 6400);
/* 3733:     */       
/* 3734:     */ 
/* 3735:3802 */       cell = row.createCell(0);
/* 3736:3803 */       cell.setCellValue("Retailer Id");
/* 3737:3804 */       cell.setCellStyle(headerCellStyle);
/* 3738:     */       
/* 3739:3806 */       cell = row.createCell(1);
/* 3740:3807 */       cell.setCellValue("Salutation");
/* 3741:3808 */       cell.setCellStyle(headerCellStyle);
/* 3742:     */       
/* 3743:3810 */       cell = row.createCell(2);
/* 3744:3811 */       cell.setCellValue("Full Name");
/* 3745:3812 */       cell.setCellStyle(headerCellStyle);
/* 3746:     */       
/* 3747:3814 */       cell = row.createCell(3);
/* 3748:3815 */       cell.setCellValue("DOB");
/* 3749:3816 */       cell.setCellStyle(headerCellStyle);
/* 3750:     */       
/* 3751:3818 */       cell = row.createCell(4);
/* 3752:3819 */       cell.setCellValue("Address line 1");
/* 3753:3820 */       cell.setCellStyle(headerCellStyle);
/* 3754:     */       
/* 3755:3822 */       cell = row.createCell(5);
/* 3756:3823 */       cell.setCellValue("Address line 2");
/* 3757:3824 */       cell.setCellStyle(headerCellStyle);
/* 3758:     */       
/* 3759:3826 */       cell = row.createCell(6);
/* 3760:3827 */       cell.setCellValue("City");
/* 3761:3828 */       cell.setCellStyle(headerCellStyle);
/* 3762:     */       
/* 3763:3830 */       cell = row.createCell(7);
/* 3764:3831 */       cell.setCellValue("State");
/* 3765:3832 */       cell.setCellStyle(headerCellStyle);
/* 3766:     */       
/* 3767:3834 */       cell = row.createCell(8);
/* 3768:3835 */       cell.setCellValue("Pincode");
/* 3769:3836 */       cell.setCellStyle(headerCellStyle);
/* 3770:     */       
/* 3771:3838 */       cell = row.createCell(9);
/* 3772:3839 */       cell.setCellValue("Primary Mail");
/* 3773:3840 */       cell.setCellStyle(headerCellStyle);
/* 3774:     */       
/* 3775:3842 */       cell = row.createCell(10);
/* 3776:3843 */       cell.setCellValue("Alternate Mail");
/* 3777:3844 */       cell.setCellStyle(headerCellStyle);
/* 3778:     */       
/* 3779:3846 */       cell = row.createCell(11);
/* 3780:3847 */       cell.setCellValue("Phone No");
/* 3781:3848 */       cell.setCellStyle(headerCellStyle);
/* 3782:     */       
/* 3783:3850 */       cell = row.createCell(12);
/* 3784:3851 */       cell.setCellValue("Mobile No");
/* 3785:3852 */       cell.setCellStyle(headerCellStyle);
/* 3786:     */       
/* 3787:3854 */       cell = row.createCell(13);
/* 3788:3855 */       cell.setCellValue("FAX No");
/* 3789:3856 */       cell.setCellStyle(headerCellStyle);
/* 3790:     */       
/* 3791:3858 */       cell = row.createCell(14);
/* 3792:3859 */       cell.setCellValue("Social Id");
/* 3793:3860 */       cell.setCellStyle(headerCellStyle);
/* 3794:     */       
/* 3795:3862 */       cell = row.createCell(15);
/* 3796:3863 */       cell.setCellValue("Creation Date");
/* 3797:3864 */       cell.setCellStyle(headerCellStyle);
/* 3798:     */       
/* 3799:3866 */       cell = row.createCell(16);
/* 3800:3867 */       cell.setCellValue("Created By");
/* 3801:3868 */       cell.setCellStyle(headerCellStyle);
/* 3802:     */       
/* 3803:3870 */       cell = row.createCell(17);
/* 3804:3871 */       cell.setCellValue("Work Location");
/* 3805:3872 */       cell.setCellStyle(headerCellStyle);
/* 3806:     */       
/* 3807:3874 */       cell = row.createCell(18);
/* 3808:3875 */       cell.setCellValue("Currency");
/* 3809:3876 */       cell.setCellStyle(headerCellStyle);
/* 3810:     */       
/* 3811:3878 */       cell = row.createCell(19);
/* 3812:3879 */       cell.setCellValue("Contact Person");
/* 3813:3880 */       cell.setCellStyle(headerCellStyle);
/* 3814:     */       
/* 3815:3882 */       cell = row.createCell(20);
/* 3816:3883 */       cell.setCellValue("Alternate Phone No");
/* 3817:3884 */       cell.setCellStyle(headerCellStyle);
/* 3818:     */       
/* 3819:3886 */       cell = row.createCell(21);
/* 3820:3887 */       cell.setCellValue("Alternate Mobile No");
/* 3821:3888 */       cell.setCellStyle(headerCellStyle);
/* 3822:     */       
/* 3823:3890 */       cell = row.createCell(22);
/* 3824:3891 */       cell.setCellValue("FAX ISD");
/* 3825:3892 */       cell.setCellStyle(headerCellStyle);
/* 3826:     */       
/* 3827:3894 */       cell = row.createCell(23);
/* 3828:3895 */       cell.setCellValue("FAX STD");
/* 3829:3896 */       cell.setCellStyle(headerCellStyle);
/* 3830:     */       
/* 3831:3898 */       cell = row.createCell(24);
/* 3832:3899 */       cell.setCellValue("Country");
/* 3833:3900 */       cell.setCellStyle(headerCellStyle);
/* 3834:     */       
/* 3835:3902 */       cell = row.createCell(25);
/* 3836:3903 */       cell.setCellValue("Phone ISD");
/* 3837:3904 */       cell.setCellStyle(headerCellStyle);
/* 3838:     */       
/* 3839:3906 */       cell = row.createCell(26);
/* 3840:3907 */       cell.setCellValue("Phone STD");
/* 3841:3908 */       cell.setCellStyle(headerCellStyle);
/* 3842:     */       
/* 3843:3910 */       cell = row.createCell(27);
/* 3844:3911 */       cell.setCellValue("Phone ISD2");
/* 3845:3912 */       cell.setCellStyle(headerCellStyle);
/* 3846:     */       
/* 3847:3914 */       cell = row.createCell(28);
/* 3848:3915 */       cell.setCellValue("Phone STD2");
/* 3849:3916 */       cell.setCellStyle(headerCellStyle);
/* 3850:     */       
/* 3851:3918 */       cell = row.createCell(29);
/* 3852:3919 */       cell.setCellValue("Mobile ISD");
/* 3853:3920 */       cell.setCellStyle(headerCellStyle);
/* 3854:     */       
/* 3855:3922 */       cell = row.createCell(30);
/* 3856:3923 */       cell.setCellValue("Mobile ISD2");
/* 3857:3924 */       cell.setCellStyle(headerCellStyle);
/* 3858:     */       
/* 3859:3926 */       cell = row.createCell(31);
/* 3860:3927 */       cell.setCellValue("Website");
/* 3861:3928 */       cell.setCellStyle(headerCellStyle);
/* 3862:     */       
/* 3863:3930 */       cell = row.createCell(32);
/* 3864:3931 */       cell.setCellValue("Reffered By");
/* 3865:3932 */       cell.setCellStyle(headerCellStyle);
/* 3866:     */       
/* 3867:3934 */       cell = row.createCell(33);
/* 3868:3935 */       cell.setCellValue("Description");
/* 3869:3936 */       cell.setCellStyle(headerCellStyle);
/* 3870:     */       
/* 3871:     */ 
/* 3872:     */ 
/* 3873:     */ 
/* 3874:     */ 
/* 3875:     */ 
/* 3876:     */ 
/* 3877:3944 */       List<ExcelReportDaoImpl> li = new ArrayList();
/* 3878:3945 */       while (this.resultSet.next())
/* 3879:     */       {
/* 3880:3947 */         this.daoImpl = new ExcelReportDaoImpl();
/* 3881:     */         
/* 3882:     */ 
/* 3883:3950 */         row = spreadSheet.createRow(currentRow++);
/* 3884:     */         
/* 3885:3952 */         cell = row.createCell(0);
/* 3886:3953 */         cell.setCellValue(this.resultSet.getInt("REG_CUSTOMER_ID"));
/* 3887:3954 */         cell.setCellStyle(dataCellStyle);
/* 3888:     */         
/* 3889:3956 */         cell = row.createCell(1);
/* 3890:3957 */         cell.setCellValue(this.resultSet.getString("REG_SALUTATION"));
/* 3891:3958 */         cell.setCellStyle(dataCellStyle);
/* 3892:     */         
/* 3893:3960 */         cell = row.createCell(2);
/* 3894:3961 */         cell.setCellValue(this.resultSet.getString("REG_FULL_NAME"));
/* 3895:3962 */         cell.setCellStyle(dataCellStyle);
/* 3896:     */         
/* 3897:3964 */         cell = row.createCell(3);
/* 3898:3965 */         cell.setCellValue(this.resultSet.getString("REG_DATE_OF_BIRTH"));
/* 3899:3966 */         cell.setCellStyle(dataCellStyle);
/* 3900:     */         
/* 3901:3968 */         cell = row.createCell(4);
/* 3902:3969 */         cell.setCellValue(this.resultSet.getString("REG_ADDRESS_LINE_1"));
/* 3903:3970 */         cell.setCellStyle(dataCellStyle);
/* 3904:     */         
/* 3905:3972 */         cell = row.createCell(5);
/* 3906:3973 */         cell.setCellValue(this.resultSet.getString("REG_ADDRESS_LINE_2"));
/* 3907:3974 */         cell.setCellStyle(dataCellStyle);
/* 3908:     */         
/* 3909:3976 */         cell = row.createCell(6);
/* 3910:3977 */         cell.setCellValue(
/* 3911:3978 */           this.resultSet
/* 3912:3979 */           .getString("REG_CITY"));
/* 3913:3980 */         cell.setCellStyle(dataCellStyle);
/* 3914:     */         
/* 3915:3982 */         cell = row.createCell(7);
/* 3916:3983 */         cell.setCellValue(this.resultSet.getString("REG_STATE"));
/* 3917:3984 */         cell.setCellStyle(dataCellStyle);
/* 3918:     */         
/* 3919:3986 */         cell = row.createCell(8);
/* 3920:3987 */         cell.setCellValue(this.resultSet
/* 3921:3988 */           .getString("REG_PINCODE"));
/* 3922:3989 */         cell.setCellStyle(dataCellStyle);
/* 3923:     */         
/* 3924:3991 */         cell = row.createCell(9);
/* 3925:3992 */         cell.setCellValue(this.resultSet.getString("REG_PRIMARY_MAIL_ID"));
/* 3926:3993 */         cell.setCellStyle(dataCellStyle);
/* 3927:     */         
/* 3928:3995 */         cell = row.createCell(10);
/* 3929:3996 */         cell.setCellValue(this.resultSet.getString("REG_ALTERNATE_MAIL_ID"));
/* 3930:3997 */         cell.setCellStyle(dataCellStyle);
/* 3931:     */         
/* 3932:3999 */         cell = row.createCell(11);
/* 3933:4000 */         cell.setCellValue(this.resultSet.getString("REG_PHONE_NO"));
/* 3934:4001 */         cell.setCellStyle(dataCellStyle);
/* 3935:     */         
/* 3936:4003 */         cell = row.createCell(12);
/* 3937:4004 */         cell.setCellValue(this.resultSet.getString("REG_MOBILE_NO"));
/* 3938:4005 */         cell.setCellStyle(dataCellStyle);
/* 3939:     */         
/* 3940:4007 */         cell = row.createCell(13);
/* 3941:4008 */         cell.setCellValue(this.resultSet
/* 3942:4009 */           .getString("REG_FAX_NO"));
/* 3943:4010 */         cell.setCellStyle(dataCellStyle);
/* 3944:     */         
/* 3945:4012 */         cell = row.createCell(14);
/* 3946:4013 */         cell.setCellValue(this.resultSet.getString("REG_SOCIAL_IM_ID"));
/* 3947:4014 */         cell.setCellStyle(dataCellStyle);
/* 3948:     */         
/* 3949:     */ 
/* 3950:4017 */         cell = row.createCell(15);
/* 3951:4018 */         cell.setCellValue(this.resultSet.getString("REG_CREATION_DATE"));
/* 3952:4019 */         cell.setCellStyle(dataCellStyle);
/* 3953:     */         
/* 3954:4021 */         cell = row.createCell(16);
/* 3955:4022 */         cell.setCellValue(this.resultSet.getString("REG_CREATED_BY"));
/* 3956:4023 */         cell.setCellStyle(dataCellStyle);
/* 3957:     */         
/* 3958:4025 */         cell = row.createCell(17);
/* 3959:4026 */         cell.setCellValue(this.resultSet.getString("REG_WORK_LOCATION"));
/* 3960:4027 */         cell.setCellStyle(dataCellStyle);
/* 3961:     */         
/* 3962:4029 */         cell = row.createCell(18);
/* 3963:4030 */         cell.setCellValue(this.resultSet.getString("REG_REF_CURRENCY"));
/* 3964:4031 */         cell.setCellStyle(dataCellStyle);
/* 3965:     */         
/* 3966:4033 */         cell = row.createCell(19);
/* 3967:4034 */         cell.setCellValue(this.resultSet.getString("REG_CONTACT_PERSON"));
/* 3968:4035 */         cell.setCellStyle(dataCellStyle);
/* 3969:     */         
/* 3970:4037 */         cell = row.createCell(20);
/* 3971:4038 */         cell.setCellValue(this.resultSet.getString("REG_PHONE_NO2"));
/* 3972:4039 */         cell.setCellStyle(dataCellStyle);
/* 3973:     */         
/* 3974:4041 */         cell = row.createCell(21);
/* 3975:4042 */         cell.setCellValue(this.resultSet.getString("REG_MOBILE_NO2"));
/* 3976:4043 */         cell.setCellStyle(dataCellStyle);
/* 3977:     */         
/* 3978:4045 */         cell = row.createCell(22);
/* 3979:4046 */         cell.setCellValue(this.resultSet.getString("REG_FAX_ISD"));
/* 3980:4047 */         cell.setCellStyle(dataCellStyle);
/* 3981:     */         
/* 3982:4049 */         cell = row.createCell(23);
/* 3983:4050 */         cell.setCellValue(this.resultSet.getString("REG_FAX_STD"));
/* 3984:4051 */         cell.setCellStyle(dataCellStyle);
/* 3985:     */         
/* 3986:4053 */         cell = row.createCell(24);
/* 3987:4054 */         cell.setCellValue(this.resultSet.getString("REG_COUNTRY"));
/* 3988:4055 */         cell.setCellStyle(dataCellStyle);
/* 3989:     */         
/* 3990:4057 */         cell = row.createCell(25);
/* 3991:4058 */         cell.setCellValue(this.resultSet.getString("REG_PHONE_ISD"));
/* 3992:4059 */         cell.setCellStyle(dataCellStyle);
/* 3993:     */         
/* 3994:4061 */         cell = row.createCell(26);
/* 3995:4062 */         cell.setCellValue(this.resultSet.getString("REG_PHONE_STD"));
/* 3996:4063 */         cell.setCellStyle(dataCellStyle);
/* 3997:     */         
/* 3998:4065 */         cell = row.createCell(27);
/* 3999:4066 */         cell.setCellValue(this.resultSet.getString("REG_PHONE_ISD2"));
/* 4000:4067 */         cell.setCellStyle(dataCellStyle);
/* 4001:     */         
/* 4002:4069 */         cell = row.createCell(28);
/* 4003:4070 */         cell.setCellValue(this.resultSet.getString("REG_PHONE_STD2"));
/* 4004:4071 */         cell.setCellStyle(dataCellStyle);
/* 4005:     */         
/* 4006:4073 */         cell = row.createCell(29);
/* 4007:4074 */         cell.setCellValue(this.resultSet.getString("REG_MOBILE_ISD1"));
/* 4008:4075 */         cell.setCellStyle(dataCellStyle);
/* 4009:     */         
/* 4010:4077 */         cell = row.createCell(30);
/* 4011:4078 */         cell.setCellValue(this.resultSet.getString("REG_MOBILE_ISD2"));
/* 4012:4079 */         cell.setCellStyle(dataCellStyle);
/* 4013:     */         
/* 4014:4081 */         cell = row.createCell(31);
/* 4015:4082 */         cell.setCellValue(this.resultSet.getString("REG_HOME_WEBSITE"));
/* 4016:4083 */         cell.setCellStyle(dataCellStyle);
/* 4017:     */         
/* 4018:4085 */         cell = row.createCell(32);
/* 4019:4086 */         cell.setCellValue(this.resultSet.getString("REG_REFFERED_BY"));
/* 4020:4087 */         cell.setCellStyle(dataCellStyle);
/* 4021:     */         
/* 4022:4089 */         cell = row.createCell(33);
/* 4023:4090 */         cell.setCellValue(this.resultSet.getString("REG_PROFILE_DISC"));
/* 4024:4091 */         cell.setCellStyle(dataCellStyle);
/* 4025:     */         
/* 4026:     */ 
/* 4027:4094 */         li.add(this.daoImpl);
/* 4028:     */       }
/* 4029:4097 */       ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
/* 4030:4098 */       wb.write(outByteStream);
/* 4031:4099 */       byte[] outArray = outByteStream.toByteArray();
/* 4032:4100 */       response.setContentType("application/ms-excel");
/* 4033:4101 */       response.setContentLength(outArray.length);
/* 4034:4102 */       response.setHeader("Expires:", "0");
/* 4035:4103 */       response.setHeader("Content-Disposition", 
/* 4036:4104 */         "attachment; filename=RetailerDetail_list.xls");
/* 4037:     */       
/* 4038:     */ 
/* 4039:4107 */       ServletOutputStream fileOut = response.getOutputStream();
/* 4040:4108 */       fileOut.write(outArray);
/* 4041:4109 */       fileOut.flush();
/* 4042:4110 */       fileOut.close();
/* 4043:     */     }
/* 4044:     */     catch (Exception e)
/* 4045:     */     {
/* 4046:4113 */       e.printStackTrace();
/* 4047:     */     }
/* 4048:     */   }
/* 4049:     */   
/* 4050:     */   public void consumerDetailExcelReport(HttpServletRequest request, HttpServletResponse response)
/* 4051:     */   {
/* 4052:     */     try
/* 4053:     */     {
/* 4054:4123 */       System.out.println("try");
/* 4055:4124 */       this.connection = getConnection();
/* 4056:4125 */       String query = "SELECT * FROM TAB_CONSUMER_CUSTOMER WHERE CON_CUSTOMER_STATUS='ACTIVE'";
/* 4057:4126 */       this.preparedStatement = this.connection.prepareStatement(query);
/* 4058:4127 */       this.resultSet = this.preparedStatement.executeQuery();
/* 4059:4128 */       System.out.println("executeQuery");
/* 4060:4129 */       int currentRow = 1;
/* 4061:     */       
/* 4062:4131 */       Workbook wb = new HSSFWorkbook();
/* 4063:4132 */       Sheet spreadSheet = wb.createSheet("Consumer Detail List");
/* 4064:     */       
/* 4065:     */ 
/* 4066:4135 */       Row row = spreadSheet.createRow(0);
/* 4067:     */       
/* 4068:     */ 
/* 4069:4138 */       CellStyle headerCellStyle = wb.createCellStyle();
/* 4070:4139 */       headerCellStyle.setFillForegroundColor((short)49);
/* 4071:4140 */       headerCellStyle.setFillPattern((short)1);
/* 4072:     */       
/* 4073:4142 */       Font setFont = wb.createFont();
/* 4074:4143 */       setFont.setFontHeightInPoints((short)11);
/* 4075:4144 */       setFont.setColor((short)8);
/* 4076:4145 */       setFont.setBoldweight((short)700);
/* 4077:4146 */       headerCellStyle.setBorderBottom((short)1);
/* 4078:4147 */       headerCellStyle.setFont(setFont);
/* 4079:     */       
/* 4080:     */ 
/* 4081:4150 */       CellStyle dataCellStyle = wb.createCellStyle();
/* 4082:4151 */       Font setDataFont = wb.createFont();
/* 4083:4152 */       setDataFont.setColor((short)8);
/* 4084:4153 */       dataCellStyle.setBorderBottom((short)0);
/* 4085:4154 */       dataCellStyle.setFont(setDataFont);
/* 4086:     */       
/* 4087:4156 */       Cell cell = null;
/* 4088:     */       
/* 4089:4158 */       spreadSheet.setColumnWidth(0, 2560);
/* 4090:4159 */       spreadSheet.setColumnWidth(1, 7680);
/* 4091:4160 */       spreadSheet.setColumnWidth(2, 6400);
/* 4092:4161 */       spreadSheet.setColumnWidth(3, 6400);
/* 4093:4162 */       spreadSheet.setColumnWidth(4, 6400);
/* 4094:4163 */       spreadSheet.setColumnWidth(5, 6400);
/* 4095:4164 */       spreadSheet.setColumnWidth(6, 6400);
/* 4096:4165 */       spreadSheet.setColumnWidth(7, 6400);
/* 4097:4166 */       spreadSheet.setColumnWidth(8, 6400);
/* 4098:4167 */       spreadSheet.setColumnWidth(9, 6400);
/* 4099:4168 */       spreadSheet.setColumnWidth(10, 6400);
/* 4100:4169 */       spreadSheet.setColumnWidth(11, 6400);
/* 4101:4170 */       spreadSheet.setColumnWidth(12, 6400);
/* 4102:4171 */       spreadSheet.setColumnWidth(13, 6400);
/* 4103:4172 */       spreadSheet.setColumnWidth(14, 6400);
/* 4104:4173 */       spreadSheet.setColumnWidth(15, 6400);
/* 4105:4174 */       spreadSheet.setColumnWidth(16, 6400);
/* 4106:4175 */       spreadSheet.setColumnWidth(17, 6400);
/* 4107:4176 */       spreadSheet.setColumnWidth(18, 6400);
/* 4108:     */       
/* 4109:     */ 
/* 4110:     */ 
/* 4111:     */ 
/* 4112:     */ 
/* 4113:     */ 
/* 4114:     */ 
/* 4115:     */ 
/* 4116:     */ 
/* 4117:     */ 
/* 4118:     */ 
/* 4119:     */ 
/* 4120:     */ 
/* 4121:     */ 
/* 4122:     */ 
/* 4123:     */ 
/* 4124:     */ 
/* 4125:4194 */       cell = row.createCell(0);
/* 4126:4195 */       cell.setCellValue("Consumer Id");
/* 4127:4196 */       cell.setCellStyle(headerCellStyle);
/* 4128:     */       
/* 4129:4198 */       cell = row.createCell(1);
/* 4130:4199 */       cell.setCellValue("Salutation");
/* 4131:4200 */       cell.setCellStyle(headerCellStyle);
/* 4132:     */       
/* 4133:4202 */       cell = row.createCell(2);
/* 4134:4203 */       cell.setCellValue("Full Name");
/* 4135:4204 */       cell.setCellStyle(headerCellStyle);
/* 4136:     */       
/* 4137:4206 */       cell = row.createCell(3);
/* 4138:4207 */       cell.setCellValue("DOB");
/* 4139:4208 */       cell.setCellStyle(headerCellStyle);
/* 4140:     */       
/* 4141:4210 */       cell = row.createCell(4);
/* 4142:4211 */       cell.setCellValue("Address line 1");
/* 4143:4212 */       cell.setCellStyle(headerCellStyle);
/* 4144:     */       
/* 4145:4214 */       cell = row.createCell(5);
/* 4146:4215 */       cell.setCellValue("Address line 2");
/* 4147:4216 */       cell.setCellStyle(headerCellStyle);
/* 4148:     */       
/* 4149:4218 */       cell = row.createCell(6);
/* 4150:4219 */       cell.setCellValue("City");
/* 4151:4220 */       cell.setCellStyle(headerCellStyle);
/* 4152:     */       
/* 4153:4222 */       cell = row.createCell(7);
/* 4154:4223 */       cell.setCellValue("State");
/* 4155:4224 */       cell.setCellStyle(headerCellStyle);
/* 4156:     */       
/* 4157:4226 */       cell = row.createCell(8);
/* 4158:4227 */       cell.setCellValue("Pincode");
/* 4159:4228 */       cell.setCellStyle(headerCellStyle);
/* 4160:     */       
/* 4161:4230 */       cell = row.createCell(9);
/* 4162:4231 */       cell.setCellValue("Primary Mail");
/* 4163:4232 */       cell.setCellStyle(headerCellStyle);
/* 4164:     */       
/* 4165:4234 */       cell = row.createCell(10);
/* 4166:4235 */       cell.setCellValue("Alternate Mail");
/* 4167:4236 */       cell.setCellStyle(headerCellStyle);
/* 4168:     */       
/* 4169:4238 */       cell = row.createCell(11);
/* 4170:4239 */       cell.setCellValue("Phone No");
/* 4171:4240 */       cell.setCellStyle(headerCellStyle);
/* 4172:     */       
/* 4173:4242 */       cell = row.createCell(12);
/* 4174:4243 */       cell.setCellValue("Mobile No");
/* 4175:4244 */       cell.setCellStyle(headerCellStyle);
/* 4176:     */       
/* 4177:4246 */       cell = row.createCell(13);
/* 4178:4247 */       cell.setCellValue("FAX No");
/* 4179:4248 */       cell.setCellStyle(headerCellStyle);
/* 4180:     */       
/* 4181:4250 */       cell = row.createCell(14);
/* 4182:4251 */       cell.setCellValue("Social Id");
/* 4183:4252 */       cell.setCellStyle(headerCellStyle);
/* 4184:     */       
/* 4185:4254 */       cell = row.createCell(15);
/* 4186:4255 */       cell.setCellValue("Creation Date");
/* 4187:4256 */       cell.setCellStyle(headerCellStyle);
/* 4188:     */       
/* 4189:4258 */       cell = row.createCell(16);
/* 4190:4259 */       cell.setCellValue("Created By");
/* 4191:4260 */       cell.setCellStyle(headerCellStyle);
/* 4192:     */       
/* 4193:4262 */       cell = row.createCell(17);
/* 4194:4263 */       cell.setCellValue("Work Location");
/* 4195:4264 */       cell.setCellStyle(headerCellStyle);
/* 4196:     */       
/* 4197:4266 */       cell = row.createCell(18);
/* 4198:4267 */       cell.setCellValue("Currency");
/* 4199:4268 */       cell.setCellStyle(headerCellStyle);
/* 4200:     */       
/* 4201:     */ 
/* 4202:     */ 
/* 4203:     */ 
/* 4204:     */ 
/* 4205:     */ 
/* 4206:     */ 
/* 4207:     */ 
/* 4208:     */ 
/* 4209:     */ 
/* 4210:     */ 
/* 4211:     */ 
/* 4212:     */ 
/* 4213:     */ 
/* 4214:     */ 
/* 4215:     */ 
/* 4216:     */ 
/* 4217:     */ 
/* 4218:     */ 
/* 4219:     */ 
/* 4220:     */ 
/* 4221:     */ 
/* 4222:     */ 
/* 4223:     */ 
/* 4224:     */ 
/* 4225:     */ 
/* 4226:     */ 
/* 4227:     */ 
/* 4228:     */ 
/* 4229:     */ 
/* 4230:     */ 
/* 4231:     */ 
/* 4232:     */ 
/* 4233:     */ 
/* 4234:     */ 
/* 4235:     */ 
/* 4236:     */ 
/* 4237:     */ 
/* 4238:     */ 
/* 4239:     */ 
/* 4240:     */ 
/* 4241:     */ 
/* 4242:     */ 
/* 4243:     */ 
/* 4244:     */ 
/* 4245:     */ 
/* 4246:     */ 
/* 4247:     */ 
/* 4248:     */ 
/* 4249:     */ 
/* 4250:     */ 
/* 4251:     */ 
/* 4252:     */ 
/* 4253:     */ 
/* 4254:     */ 
/* 4255:     */ 
/* 4256:     */ 
/* 4257:     */ 
/* 4258:     */ 
/* 4259:     */ 
/* 4260:     */ 
/* 4261:     */ 
/* 4262:     */ 
/* 4263:     */ 
/* 4264:     */ 
/* 4265:     */ 
/* 4266:     */ 
/* 4267:4336 */       List<ExcelReportDaoImpl> li = new ArrayList();
/* 4268:4337 */       while (this.resultSet.next())
/* 4269:     */       {
/* 4270:4339 */         this.daoImpl = new ExcelReportDaoImpl();
/* 4271:     */         
/* 4272:     */ 
/* 4273:4342 */         row = spreadSheet.createRow(currentRow++);
/* 4274:     */         
/* 4275:4344 */         cell = row.createCell(0);
/* 4276:4345 */         cell.setCellValue(this.resultSet.getInt("CON_CUSTOMER_ID"));
/* 4277:4346 */         cell.setCellStyle(dataCellStyle);
/* 4278:     */         
/* 4279:4348 */         cell = row.createCell(1);
/* 4280:4349 */         cell.setCellValue(this.resultSet.getString("CON_SALUTATION"));
/* 4281:4350 */         cell.setCellStyle(dataCellStyle);
/* 4282:     */         
/* 4283:4352 */         cell = row.createCell(2);
/* 4284:4353 */         cell.setCellValue(this.resultSet.getString("CON_FULL_NAME"));
/* 4285:4354 */         cell.setCellStyle(dataCellStyle);
/* 4286:     */         
/* 4287:4356 */         cell = row.createCell(3);
/* 4288:4357 */         cell.setCellValue(this.resultSet.getString("CON_DATE_OF_BIRTH"));
/* 4289:4358 */         cell.setCellStyle(dataCellStyle);
/* 4290:     */         
/* 4291:4360 */         cell = row.createCell(4);
/* 4292:4361 */         cell.setCellValue(this.resultSet.getString("CON_ADDRESS_LINE_1"));
/* 4293:4362 */         cell.setCellStyle(dataCellStyle);
/* 4294:     */         
/* 4295:4364 */         cell = row.createCell(5);
/* 4296:4365 */         cell.setCellValue(this.resultSet.getString("CON_ADDRESS_LINE_2"));
/* 4297:4366 */         cell.setCellStyle(dataCellStyle);
/* 4298:     */         
/* 4299:4368 */         cell = row.createCell(6);
/* 4300:4369 */         cell.setCellValue(
/* 4301:4370 */           this.resultSet
/* 4302:4371 */           .getString("CON_CITY"));
/* 4303:4372 */         cell.setCellStyle(dataCellStyle);
/* 4304:     */         
/* 4305:4374 */         cell = row.createCell(7);
/* 4306:4375 */         cell.setCellValue(this.resultSet.getString("CON_STATE"));
/* 4307:4376 */         cell.setCellStyle(dataCellStyle);
/* 4308:     */         
/* 4309:4378 */         cell = row.createCell(8);
/* 4310:4379 */         cell.setCellValue(this.resultSet
/* 4311:4380 */           .getString("CON_PINCODE"));
/* 4312:4381 */         cell.setCellStyle(dataCellStyle);
/* 4313:     */         
/* 4314:4383 */         cell = row.createCell(9);
/* 4315:4384 */         cell.setCellValue(this.resultSet.getString("CON_PRIMARY_MAIL_ID"));
/* 4316:4385 */         cell.setCellStyle(dataCellStyle);
/* 4317:     */         
/* 4318:4387 */         cell = row.createCell(10);
/* 4319:4388 */         cell.setCellValue(this.resultSet.getString("CON_ALTERNATE_MAIL_ID"));
/* 4320:4389 */         cell.setCellStyle(dataCellStyle);
/* 4321:     */         
/* 4322:4391 */         cell = row.createCell(11);
/* 4323:4392 */         cell.setCellValue(this.resultSet.getString("CON_PHONE_NO"));
/* 4324:4393 */         cell.setCellStyle(dataCellStyle);
/* 4325:     */         
/* 4326:4395 */         cell = row.createCell(12);
/* 4327:4396 */         cell.setCellValue(this.resultSet.getString("CON_MOBILE_NO"));
/* 4328:4397 */         cell.setCellStyle(dataCellStyle);
/* 4329:     */         
/* 4330:4399 */         cell = row.createCell(13);
/* 4331:4400 */         cell.setCellValue(this.resultSet
/* 4332:4401 */           .getString("CON_FAX_NO"));
/* 4333:4402 */         cell.setCellStyle(dataCellStyle);
/* 4334:     */         
/* 4335:4404 */         cell = row.createCell(14);
/* 4336:4405 */         cell.setCellValue(this.resultSet.getString("CON_SOCIAL_IM_ID"));
/* 4337:4406 */         cell.setCellStyle(dataCellStyle);
/* 4338:     */         
/* 4339:     */ 
/* 4340:4409 */         cell = row.createCell(15);
/* 4341:4410 */         cell.setCellValue(this.resultSet.getString("CON_CREATION_DATE"));
/* 4342:4411 */         cell.setCellStyle(dataCellStyle);
/* 4343:     */         
/* 4344:4413 */         cell = row.createCell(16);
/* 4345:4414 */         cell.setCellValue(this.resultSet.getString("CON_CREATED_BY"));
/* 4346:4415 */         cell.setCellStyle(dataCellStyle);
/* 4347:     */         
/* 4348:4417 */         cell = row.createCell(17);
/* 4349:4418 */         cell.setCellValue(this.resultSet.getString("CON_WORK_LOCATION"));
/* 4350:4419 */         cell.setCellStyle(dataCellStyle);
/* 4351:     */         
/* 4352:4421 */         cell = row.createCell(18);
/* 4353:4422 */         cell.setCellValue(this.resultSet.getString("CON_REF_CURRENCY"));
/* 4354:4423 */         cell.setCellStyle(dataCellStyle);
/* 4355:     */         
/* 4356:     */ 
/* 4357:     */ 
/* 4358:     */ 
/* 4359:     */ 
/* 4360:     */ 
/* 4361:     */ 
/* 4362:     */ 
/* 4363:     */ 
/* 4364:     */ 
/* 4365:     */ 
/* 4366:     */ 
/* 4367:     */ 
/* 4368:     */ 
/* 4369:     */ 
/* 4370:     */ 
/* 4371:     */ 
/* 4372:     */ 
/* 4373:     */ 
/* 4374:     */ 
/* 4375:     */ 
/* 4376:     */ 
/* 4377:     */ 
/* 4378:     */ 
/* 4379:     */ 
/* 4380:     */ 
/* 4381:     */ 
/* 4382:     */ 
/* 4383:     */ 
/* 4384:     */ 
/* 4385:     */ 
/* 4386:     */ 
/* 4387:     */ 
/* 4388:     */ 
/* 4389:     */ 
/* 4390:     */ 
/* 4391:     */ 
/* 4392:     */ 
/* 4393:     */ 
/* 4394:     */ 
/* 4395:     */ 
/* 4396:     */ 
/* 4397:     */ 
/* 4398:     */ 
/* 4399:     */ 
/* 4400:     */ 
/* 4401:     */ 
/* 4402:     */ 
/* 4403:     */ 
/* 4404:     */ 
/* 4405:     */ 
/* 4406:     */ 
/* 4407:     */ 
/* 4408:     */ 
/* 4409:     */ 
/* 4410:     */ 
/* 4411:     */ 
/* 4412:     */ 
/* 4413:     */ 
/* 4414:     */ 
/* 4415:     */ 
/* 4416:     */ 
/* 4417:4486 */         li.add(this.daoImpl);
/* 4418:     */       }
/* 4419:4489 */       ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
/* 4420:4490 */       wb.write(outByteStream);
/* 4421:4491 */       byte[] outArray = outByteStream.toByteArray();
/* 4422:4492 */       response.setContentType("application/ms-excel");
/* 4423:4493 */       response.setContentLength(outArray.length);
/* 4424:4494 */       response.setHeader("Expires:", "0");
/* 4425:4495 */       response.setHeader("Content-Disposition", 
/* 4426:4496 */         "attachment; filename=ConsumerDetail_list.xls");
/* 4427:     */       
/* 4428:     */ 
/* 4429:4499 */       ServletOutputStream fileOut = response.getOutputStream();
/* 4430:4500 */       fileOut.write(outArray);
/* 4431:4501 */       fileOut.flush();
/* 4432:4502 */       fileOut.close();
/* 4433:     */     }
/* 4434:     */     catch (Exception e)
/* 4435:     */     {
/* 4436:4505 */       e.printStackTrace();
/* 4437:     */     }
/* 4438:     */   }
/* 4439:     */   
/* 4440:     */   public void dealerDetailExcelReport(HttpServletRequest request, HttpServletResponse response)
/* 4441:     */   {
/* 4442:     */     try
/* 4443:     */     {
/* 4444:4514 */       System.out.println("try");
/* 4445:4515 */       this.connection = getConnection();
/* 4446:4516 */       String query = "SELECT * FROM TAB_DEALER_DETAIL WHERE DEALER_STATUS='ACTIVE'";
/* 4447:4517 */       this.preparedStatement = this.connection.prepareStatement(query);
/* 4448:4518 */       this.resultSet = this.preparedStatement.executeQuery();
/* 4449:4519 */       System.out.println("executeQuery");
/* 4450:4520 */       int currentRow = 1;
/* 4451:     */       
/* 4452:4522 */       Workbook wb = new HSSFWorkbook();
/* 4453:4523 */       Sheet spreadSheet = wb.createSheet("Dealer Detail List");
/* 4454:     */       
/* 4455:     */ 
/* 4456:4526 */       Row row = spreadSheet.createRow(0);
/* 4457:     */       
/* 4458:     */ 
/* 4459:4529 */       CellStyle headerCellStyle = wb.createCellStyle();
/* 4460:4530 */       headerCellStyle.setFillForegroundColor((short)49);
/* 4461:4531 */       headerCellStyle.setFillPattern((short)1);
/* 4462:     */       
/* 4463:4533 */       Font setFont = wb.createFont();
/* 4464:4534 */       setFont.setFontHeightInPoints((short)11);
/* 4465:4535 */       setFont.setColor((short)8);
/* 4466:4536 */       setFont.setBoldweight((short)700);
/* 4467:4537 */       headerCellStyle.setBorderBottom((short)1);
/* 4468:4538 */       headerCellStyle.setFont(setFont);
/* 4469:     */       
/* 4470:     */ 
/* 4471:4541 */       CellStyle dataCellStyle = wb.createCellStyle();
/* 4472:4542 */       Font setDataFont = wb.createFont();
/* 4473:4543 */       setDataFont.setColor((short)8);
/* 4474:4544 */       dataCellStyle.setBorderBottom((short)0);
/* 4475:4545 */       dataCellStyle.setFont(setDataFont);
/* 4476:     */       
/* 4477:4547 */       Cell cell = null;
/* 4478:     */       
/* 4479:4549 */       spreadSheet.setColumnWidth(0, 2560);
/* 4480:4550 */       spreadSheet.setColumnWidth(1, 7680);
/* 4481:4551 */       spreadSheet.setColumnWidth(2, 6400);
/* 4482:4552 */       spreadSheet.setColumnWidth(3, 6400);
/* 4483:4553 */       spreadSheet.setColumnWidth(4, 6400);
/* 4484:4554 */       spreadSheet.setColumnWidth(5, 6400);
/* 4485:4555 */       spreadSheet.setColumnWidth(6, 6400);
/* 4486:4556 */       spreadSheet.setColumnWidth(7, 6400);
/* 4487:4557 */       spreadSheet.setColumnWidth(8, 6400);
/* 4488:4558 */       spreadSheet.setColumnWidth(9, 6400);
/* 4489:4559 */       spreadSheet.setColumnWidth(10, 6400);
/* 4490:4560 */       spreadSheet.setColumnWidth(11, 6400);
/* 4491:4561 */       spreadSheet.setColumnWidth(12, 6400);
/* 4492:4562 */       spreadSheet.setColumnWidth(13, 6400);
/* 4493:4563 */       spreadSheet.setColumnWidth(14, 6400);
/* 4494:4564 */       spreadSheet.setColumnWidth(15, 6400);
/* 4495:4565 */       spreadSheet.setColumnWidth(16, 6400);
/* 4496:4566 */       spreadSheet.setColumnWidth(17, 6400);
/* 4497:4567 */       spreadSheet.setColumnWidth(18, 6400);
/* 4498:4568 */       spreadSheet.setColumnWidth(19, 6400);
/* 4499:4569 */       spreadSheet.setColumnWidth(20, 6400);
/* 4500:4570 */       spreadSheet.setColumnWidth(21, 6400);
/* 4501:4571 */       spreadSheet.setColumnWidth(22, 6400);
/* 4502:4572 */       spreadSheet.setColumnWidth(23, 6400);
/* 4503:4573 */       spreadSheet.setColumnWidth(24, 6400);
/* 4504:4574 */       spreadSheet.setColumnWidth(25, 6400);
/* 4505:4575 */       spreadSheet.setColumnWidth(26, 6400);
/* 4506:4576 */       spreadSheet.setColumnWidth(27, 6400);
/* 4507:4577 */       spreadSheet.setColumnWidth(28, 6400);
/* 4508:4578 */       spreadSheet.setColumnWidth(29, 6400);
/* 4509:4579 */       spreadSheet.setColumnWidth(30, 6400);
/* 4510:4580 */       spreadSheet.setColumnWidth(31, 6400);
/* 4511:4581 */       spreadSheet.setColumnWidth(32, 6400);
/* 4512:4582 */       spreadSheet.setColumnWidth(33, 6400);
/* 4513:     */       
/* 4514:     */ 
/* 4515:4585 */       cell = row.createCell(0);
/* 4516:4586 */       cell.setCellValue("Dealer Id");
/* 4517:4587 */       cell.setCellStyle(headerCellStyle);
/* 4518:     */       
/* 4519:4589 */       cell = row.createCell(1);
/* 4520:4590 */       cell.setCellValue("Salutation");
/* 4521:4591 */       cell.setCellStyle(headerCellStyle);
/* 4522:     */       
/* 4523:4593 */       cell = row.createCell(2);
/* 4524:4594 */       cell.setCellValue("Full Name");
/* 4525:4595 */       cell.setCellStyle(headerCellStyle);
/* 4526:     */       
/* 4527:4597 */       cell = row.createCell(3);
/* 4528:4598 */       cell.setCellValue("DOB");
/* 4529:4599 */       cell.setCellStyle(headerCellStyle);
/* 4530:     */       
/* 4531:4601 */       cell = row.createCell(4);
/* 4532:4602 */       cell.setCellValue("Address line 1");
/* 4533:4603 */       cell.setCellStyle(headerCellStyle);
/* 4534:     */       
/* 4535:4605 */       cell = row.createCell(5);
/* 4536:4606 */       cell.setCellValue("Address line 2");
/* 4537:4607 */       cell.setCellStyle(headerCellStyle);
/* 4538:     */       
/* 4539:4609 */       cell = row.createCell(6);
/* 4540:4610 */       cell.setCellValue("City");
/* 4541:4611 */       cell.setCellStyle(headerCellStyle);
/* 4542:     */       
/* 4543:4613 */       cell = row.createCell(7);
/* 4544:4614 */       cell.setCellValue("State");
/* 4545:4615 */       cell.setCellStyle(headerCellStyle);
/* 4546:     */       
/* 4547:4617 */       cell = row.createCell(8);
/* 4548:4618 */       cell.setCellValue("Pincode");
/* 4549:4619 */       cell.setCellStyle(headerCellStyle);
/* 4550:     */       
/* 4551:4621 */       cell = row.createCell(9);
/* 4552:4622 */       cell.setCellValue("Primary Mail");
/* 4553:4623 */       cell.setCellStyle(headerCellStyle);
/* 4554:     */       
/* 4555:4625 */       cell = row.createCell(10);
/* 4556:4626 */       cell.setCellValue("Alternate Mail");
/* 4557:4627 */       cell.setCellStyle(headerCellStyle);
/* 4558:     */       
/* 4559:4629 */       cell = row.createCell(11);
/* 4560:4630 */       cell.setCellValue("Phone No");
/* 4561:4631 */       cell.setCellStyle(headerCellStyle);
/* 4562:     */       
/* 4563:4633 */       cell = row.createCell(12);
/* 4564:4634 */       cell.setCellValue("Mobile No");
/* 4565:4635 */       cell.setCellStyle(headerCellStyle);
/* 4566:     */       
/* 4567:4637 */       cell = row.createCell(13);
/* 4568:4638 */       cell.setCellValue("FAX No");
/* 4569:4639 */       cell.setCellStyle(headerCellStyle);
/* 4570:     */       
/* 4571:4641 */       cell = row.createCell(14);
/* 4572:4642 */       cell.setCellValue("Social Id");
/* 4573:4643 */       cell.setCellStyle(headerCellStyle);
/* 4574:     */       
/* 4575:4645 */       cell = row.createCell(15);
/* 4576:4646 */       cell.setCellValue("Creation Date");
/* 4577:4647 */       cell.setCellStyle(headerCellStyle);
/* 4578:     */       
/* 4579:4649 */       cell = row.createCell(16);
/* 4580:4650 */       cell.setCellValue("Created By");
/* 4581:4651 */       cell.setCellStyle(headerCellStyle);
/* 4582:     */       
/* 4583:4653 */       cell = row.createCell(17);
/* 4584:4654 */       cell.setCellValue("Work Location");
/* 4585:4655 */       cell.setCellStyle(headerCellStyle);
/* 4586:     */       
/* 4587:4657 */       cell = row.createCell(18);
/* 4588:4658 */       cell.setCellValue("Currency");
/* 4589:4659 */       cell.setCellStyle(headerCellStyle);
/* 4590:     */       
/* 4591:4661 */       cell = row.createCell(19);
/* 4592:4662 */       cell.setCellValue("Contact Person");
/* 4593:4663 */       cell.setCellStyle(headerCellStyle);
/* 4594:     */       
/* 4595:4665 */       cell = row.createCell(20);
/* 4596:4666 */       cell.setCellValue("Alternate Phone No");
/* 4597:4667 */       cell.setCellStyle(headerCellStyle);
/* 4598:     */       
/* 4599:4669 */       cell = row.createCell(21);
/* 4600:4670 */       cell.setCellValue("Alternate Mobile No");
/* 4601:4671 */       cell.setCellStyle(headerCellStyle);
/* 4602:     */       
/* 4603:4673 */       cell = row.createCell(22);
/* 4604:4674 */       cell.setCellValue("FAX ISD");
/* 4605:4675 */       cell.setCellStyle(headerCellStyle);
/* 4606:     */       
/* 4607:4677 */       cell = row.createCell(23);
/* 4608:4678 */       cell.setCellValue("FAX STD");
/* 4609:4679 */       cell.setCellStyle(headerCellStyle);
/* 4610:     */       
/* 4611:4681 */       cell = row.createCell(24);
/* 4612:4682 */       cell.setCellValue("Country");
/* 4613:4683 */       cell.setCellStyle(headerCellStyle);
/* 4614:     */       
/* 4615:4685 */       cell = row.createCell(25);
/* 4616:4686 */       cell.setCellValue("Phone ISD");
/* 4617:4687 */       cell.setCellStyle(headerCellStyle);
/* 4618:     */       
/* 4619:4689 */       cell = row.createCell(26);
/* 4620:4690 */       cell.setCellValue("Phone STD");
/* 4621:4691 */       cell.setCellStyle(headerCellStyle);
/* 4622:     */       
/* 4623:4693 */       cell = row.createCell(27);
/* 4624:4694 */       cell.setCellValue("Phone ISD2");
/* 4625:4695 */       cell.setCellStyle(headerCellStyle);
/* 4626:     */       
/* 4627:4697 */       cell = row.createCell(28);
/* 4628:4698 */       cell.setCellValue("Phone STD2");
/* 4629:4699 */       cell.setCellStyle(headerCellStyle);
/* 4630:     */       
/* 4631:4701 */       cell = row.createCell(29);
/* 4632:4702 */       cell.setCellValue("Mobile ISD");
/* 4633:4703 */       cell.setCellStyle(headerCellStyle);
/* 4634:     */       
/* 4635:4705 */       cell = row.createCell(30);
/* 4636:4706 */       cell.setCellValue("Mobile ISD2");
/* 4637:4707 */       cell.setCellStyle(headerCellStyle);
/* 4638:     */       
/* 4639:4709 */       cell = row.createCell(31);
/* 4640:4710 */       cell.setCellValue("Website");
/* 4641:4711 */       cell.setCellStyle(headerCellStyle);
/* 4642:     */       
/* 4643:4713 */       cell = row.createCell(32);
/* 4644:4714 */       cell.setCellValue("Reffered By");
/* 4645:4715 */       cell.setCellStyle(headerCellStyle);
/* 4646:     */       
/* 4647:4717 */       cell = row.createCell(33);
/* 4648:4718 */       cell.setCellValue("Description");
/* 4649:4719 */       cell.setCellStyle(headerCellStyle);
/* 4650:     */       
/* 4651:     */ 
/* 4652:     */ 
/* 4653:     */ 
/* 4654:     */ 
/* 4655:     */ 
/* 4656:     */ 
/* 4657:4727 */       List<ExcelReportDaoImpl> li = new ArrayList();
/* 4658:4728 */       while (this.resultSet.next())
/* 4659:     */       {
/* 4660:4730 */         this.daoImpl = new ExcelReportDaoImpl();
/* 4661:     */         
/* 4662:     */ 
/* 4663:4733 */         row = spreadSheet.createRow(currentRow++);
/* 4664:     */         
/* 4665:4735 */         cell = row.createCell(0);
/* 4666:4736 */         cell.setCellValue(this.resultSet.getInt("DEALER_ID"));
/* 4667:4737 */         cell.setCellStyle(dataCellStyle);
/* 4668:     */         
/* 4669:4739 */         cell = row.createCell(1);
/* 4670:4740 */         cell.setCellValue(this.resultSet.getString("DEALER_SALUTATION"));
/* 4671:4741 */         cell.setCellStyle(dataCellStyle);
/* 4672:     */         
/* 4673:4743 */         cell = row.createCell(2);
/* 4674:4744 */         cell.setCellValue(this.resultSet.getString("DEALER_FULL_NAME"));
/* 4675:4745 */         cell.setCellStyle(dataCellStyle);
/* 4676:     */         
/* 4677:4747 */         cell = row.createCell(3);
/* 4678:4748 */         cell.setCellValue(this.resultSet.getString("DEALER_DATE_OF_BIRTH"));
/* 4679:4749 */         cell.setCellStyle(dataCellStyle);
/* 4680:     */         
/* 4681:4751 */         cell = row.createCell(4);
/* 4682:4752 */         cell.setCellValue(this.resultSet.getString("DEALER_ADDRESS_LINE_1"));
/* 4683:4753 */         cell.setCellStyle(dataCellStyle);
/* 4684:     */         
/* 4685:4755 */         cell = row.createCell(5);
/* 4686:4756 */         cell.setCellValue(this.resultSet.getString("DEALER_ADDRESS_LINE_2"));
/* 4687:4757 */         cell.setCellStyle(dataCellStyle);
/* 4688:     */         
/* 4689:4759 */         cell = row.createCell(6);
/* 4690:4760 */         cell.setCellValue(
/* 4691:4761 */           this.resultSet
/* 4692:4762 */           .getString("DEALER_CITY"));
/* 4693:4763 */         cell.setCellStyle(dataCellStyle);
/* 4694:     */         
/* 4695:4765 */         cell = row.createCell(7);
/* 4696:4766 */         cell.setCellValue(this.resultSet.getString("DEALER_STATE"));
/* 4697:4767 */         cell.setCellStyle(dataCellStyle);
/* 4698:     */         
/* 4699:4769 */         cell = row.createCell(8);
/* 4700:4770 */         cell.setCellValue(this.resultSet
/* 4701:4771 */           .getString("DEALER_PINCODE"));
/* 4702:4772 */         cell.setCellStyle(dataCellStyle);
/* 4703:     */         
/* 4704:4774 */         cell = row.createCell(9);
/* 4705:4775 */         cell.setCellValue(this.resultSet.getString("DEALER_PRIMARY_MAIL_ID"));
/* 4706:4776 */         cell.setCellStyle(dataCellStyle);
/* 4707:     */         
/* 4708:4778 */         cell = row.createCell(10);
/* 4709:4779 */         cell.setCellValue(this.resultSet.getString("DEALER_ALTERNATE_MAIL_ID"));
/* 4710:4780 */         cell.setCellStyle(dataCellStyle);
/* 4711:     */         
/* 4712:4782 */         cell = row.createCell(11);
/* 4713:4783 */         cell.setCellValue(this.resultSet.getString("DEALER_PHONE_NO"));
/* 4714:4784 */         cell.setCellStyle(dataCellStyle);
/* 4715:     */         
/* 4716:4786 */         cell = row.createCell(12);
/* 4717:4787 */         cell.setCellValue(this.resultSet.getString("DEALER_MOBILE_NO"));
/* 4718:4788 */         cell.setCellStyle(dataCellStyle);
/* 4719:     */         
/* 4720:4790 */         cell = row.createCell(13);
/* 4721:4791 */         cell.setCellValue(this.resultSet
/* 4722:4792 */           .getString("DEALER_FAX_NO"));
/* 4723:4793 */         cell.setCellStyle(dataCellStyle);
/* 4724:     */         
/* 4725:4795 */         cell = row.createCell(14);
/* 4726:4796 */         cell.setCellValue(this.resultSet.getString("DEALER_SOCIAL_IM_ID"));
/* 4727:4797 */         cell.setCellStyle(dataCellStyle);
/* 4728:     */         
/* 4729:     */ 
/* 4730:4800 */         cell = row.createCell(15);
/* 4731:4801 */         cell.setCellValue(this.resultSet.getString("DEALER_CREATION_DATE"));
/* 4732:4802 */         cell.setCellStyle(dataCellStyle);
/* 4733:     */         
/* 4734:4804 */         cell = row.createCell(16);
/* 4735:4805 */         cell.setCellValue(this.resultSet.getString("DEALER_CREATED_BY"));
/* 4736:4806 */         cell.setCellStyle(dataCellStyle);
/* 4737:     */         
/* 4738:4808 */         cell = row.createCell(17);
/* 4739:4809 */         cell.setCellValue(this.resultSet.getString("DEALER_WORK_LOCATION"));
/* 4740:4810 */         cell.setCellStyle(dataCellStyle);
/* 4741:     */         
/* 4742:4812 */         cell = row.createCell(18);
/* 4743:4813 */         cell.setCellValue(this.resultSet.getString("DEALER_REF_CURRENCY"));
/* 4744:4814 */         cell.setCellStyle(dataCellStyle);
/* 4745:     */         
/* 4746:4816 */         cell = row.createCell(19);
/* 4747:4817 */         cell.setCellValue(this.resultSet.getString("DEALER_CONTACT_PERSON"));
/* 4748:4818 */         cell.setCellStyle(dataCellStyle);
/* 4749:     */         
/* 4750:4820 */         cell = row.createCell(20);
/* 4751:4821 */         cell.setCellValue(this.resultSet.getString("DEALER_PHONE_NO2"));
/* 4752:4822 */         cell.setCellStyle(dataCellStyle);
/* 4753:     */         
/* 4754:4824 */         cell = row.createCell(21);
/* 4755:4825 */         cell.setCellValue(this.resultSet.getString("DEALER_MOBILE_NO2"));
/* 4756:4826 */         cell.setCellStyle(dataCellStyle);
/* 4757:     */         
/* 4758:4828 */         cell = row.createCell(22);
/* 4759:4829 */         cell.setCellValue(this.resultSet.getString("DEALER_FAX_ISD"));
/* 4760:4830 */         cell.setCellStyle(dataCellStyle);
/* 4761:     */         
/* 4762:4832 */         cell = row.createCell(23);
/* 4763:4833 */         cell.setCellValue(this.resultSet.getString("DEALER_FAX_STD"));
/* 4764:4834 */         cell.setCellStyle(dataCellStyle);
/* 4765:     */         
/* 4766:4836 */         cell = row.createCell(24);
/* 4767:4837 */         cell.setCellValue(this.resultSet.getString("DEALER_COUNTRY"));
/* 4768:4838 */         cell.setCellStyle(dataCellStyle);
/* 4769:     */         
/* 4770:4840 */         cell = row.createCell(25);
/* 4771:4841 */         cell.setCellValue(this.resultSet.getString("DEALER_PHONE_ISD"));
/* 4772:4842 */         cell.setCellStyle(dataCellStyle);
/* 4773:     */         
/* 4774:4844 */         cell = row.createCell(26);
/* 4775:4845 */         cell.setCellValue(this.resultSet.getString("DEALER_PHONE_STD"));
/* 4776:4846 */         cell.setCellStyle(dataCellStyle);
/* 4777:     */         
/* 4778:4848 */         cell = row.createCell(27);
/* 4779:4849 */         cell.setCellValue(this.resultSet.getString("DEALER_PHONE_ISD2"));
/* 4780:4850 */         cell.setCellStyle(dataCellStyle);
/* 4781:     */         
/* 4782:4852 */         cell = row.createCell(28);
/* 4783:4853 */         cell.setCellValue(this.resultSet.getString("DEALER_PHONE_STD2"));
/* 4784:4854 */         cell.setCellStyle(dataCellStyle);
/* 4785:     */         
/* 4786:4856 */         cell = row.createCell(29);
/* 4787:4857 */         cell.setCellValue(this.resultSet.getString("DEALER_MOBILE_ISD1"));
/* 4788:4858 */         cell.setCellStyle(dataCellStyle);
/* 4789:     */         
/* 4790:4860 */         cell = row.createCell(30);
/* 4791:4861 */         cell.setCellValue(this.resultSet.getString("DEALER_MOBILE_ISD2"));
/* 4792:4862 */         cell.setCellStyle(dataCellStyle);
/* 4793:     */         
/* 4794:4864 */         cell = row.createCell(31);
/* 4795:4865 */         cell.setCellValue(this.resultSet.getString("DEALER_HOME_WEBSITE"));
/* 4796:4866 */         cell.setCellStyle(dataCellStyle);
/* 4797:     */         
/* 4798:4868 */         cell = row.createCell(32);
/* 4799:4869 */         cell.setCellValue(this.resultSet.getString("DEALER_REFFERED_BY"));
/* 4800:4870 */         cell.setCellStyle(dataCellStyle);
/* 4801:     */         
/* 4802:4872 */         cell = row.createCell(33);
/* 4803:4873 */         cell.setCellValue(this.resultSet.getString("DEALER_PROFILE_DISC"));
/* 4804:4874 */         cell.setCellStyle(dataCellStyle);
/* 4805:     */         
/* 4806:     */ 
/* 4807:4877 */         li.add(this.daoImpl);
/* 4808:     */       }
/* 4809:4880 */       ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
/* 4810:4881 */       wb.write(outByteStream);
/* 4811:4882 */       byte[] outArray = outByteStream.toByteArray();
/* 4812:4883 */       response.setContentType("application/ms-excel");
/* 4813:4884 */       response.setContentLength(outArray.length);
/* 4814:4885 */       response.setHeader("Expires:", "0");
/* 4815:4886 */       response.setHeader("Content-Disposition", 
/* 4816:4887 */         "attachment; filename=DealerDetail_list.xls");
/* 4817:     */       
/* 4818:     */ 
/* 4819:4890 */       ServletOutputStream fileOut = response.getOutputStream();
/* 4820:4891 */       fileOut.write(outArray);
/* 4821:4892 */       fileOut.flush();
/* 4822:4893 */       fileOut.close();
/* 4823:     */     }
/* 4824:     */     catch (Exception e)
/* 4825:     */     {
/* 4826:4896 */       e.printStackTrace();
/* 4827:     */     }
/* 4828:     */   }
/* 4829:     */   
/* 4830:     */   public void retailerTransactionExcelReport(HttpServletRequest request, HttpServletResponse response)
/* 4831:     */   {
/* 4832:     */     try
/* 4833:     */     {
/* 4834:4906 */       System.out.println("try");
/* 4835:4907 */       this.connection = getConnection();
/* 4836:     */       
/* 4837:4909 */       String query = "SELECT * FROM TAB_OWNER_CUSTOMER_TRANSACTION WHERE CUSTOMER_TYPE=?";
/* 4838:4910 */       this.preparedStatement = this.connection.prepareStatement(query);
/* 4839:4911 */       this.preparedStatement.setString(1, "Retailer");
/* 4840:     */       
/* 4841:     */ 
/* 4842:4914 */       this.resultSet = this.preparedStatement.executeQuery();
/* 4843:4915 */       System.out.println("executeQuery");
/* 4844:4916 */       int currentRow = 1;
/* 4845:     */       
/* 4846:4918 */       Workbook wb = new HSSFWorkbook();
/* 4847:4919 */       Sheet spreadSheet = wb.createSheet("Retailer Transaction List");
/* 4848:     */       
/* 4849:     */ 
/* 4850:4922 */       Row row = spreadSheet.createRow(0);
/* 4851:     */       
/* 4852:     */ 
/* 4853:4925 */       CellStyle headerCellStyle = wb.createCellStyle();
/* 4854:4926 */       headerCellStyle.setFillForegroundColor((short)49);
/* 4855:4927 */       headerCellStyle.setFillPattern((short)1);
/* 4856:     */       
/* 4857:4929 */       Font setFont = wb.createFont();
/* 4858:4930 */       setFont.setFontHeightInPoints((short)11);
/* 4859:4931 */       setFont.setColor((short)8);
/* 4860:4932 */       setFont.setBoldweight((short)700);
/* 4861:4933 */       headerCellStyle.setBorderBottom((short)1);
/* 4862:4934 */       headerCellStyle.setFont(setFont);
/* 4863:     */       
/* 4864:     */ 
/* 4865:4937 */       CellStyle dataCellStyle = wb.createCellStyle();
/* 4866:4938 */       Font setDataFont = wb.createFont();
/* 4867:4939 */       setDataFont.setColor((short)8);
/* 4868:4940 */       dataCellStyle.setBorderBottom((short)0);
/* 4869:4941 */       dataCellStyle.setFont(setDataFont);
/* 4870:     */       
/* 4871:4943 */       Cell cell = null;
/* 4872:     */       
/* 4873:4945 */       spreadSheet.setColumnWidth(0, 2560);
/* 4874:4946 */       spreadSheet.setColumnWidth(1, 7680);
/* 4875:4947 */       spreadSheet.setColumnWidth(2, 6400);
/* 4876:4948 */       spreadSheet.setColumnWidth(3, 6400);
/* 4877:4949 */       spreadSheet.setColumnWidth(4, 6400);
/* 4878:4950 */       spreadSheet.setColumnWidth(5, 6400);
/* 4879:4951 */       spreadSheet.setColumnWidth(6, 6400);
/* 4880:4952 */       spreadSheet.setColumnWidth(7, 6400);
/* 4881:4953 */       spreadSheet.setColumnWidth(8, 6400);
/* 4882:4954 */       spreadSheet.setColumnWidth(9, 6400);
/* 4883:4955 */       spreadSheet.setColumnWidth(10, 6400);
/* 4884:4956 */       spreadSheet.setColumnWidth(11, 6400);
/* 4885:4957 */       spreadSheet.setColumnWidth(12, 6400);
/* 4886:     */       
/* 4887:     */ 
/* 4888:     */ 
/* 4889:     */ 
/* 4890:     */ 
/* 4891:     */ 
/* 4892:     */ 
/* 4893:     */ 
/* 4894:     */ 
/* 4895:     */ 
/* 4896:     */ 
/* 4897:     */ 
/* 4898:     */ 
/* 4899:     */ 
/* 4900:     */ 
/* 4901:     */ 
/* 4902:     */ 
/* 4903:     */ 
/* 4904:     */ 
/* 4905:     */ 
/* 4906:     */ 
/* 4907:     */ 
/* 4908:     */ 
/* 4909:4981 */       cell = row.createCell(0);
/* 4910:4982 */       cell.setCellValue("Transaction Id");
/* 4911:4983 */       cell.setCellStyle(headerCellStyle);
/* 4912:     */       
/* 4913:4985 */       cell = row.createCell(1);
/* 4914:4986 */       cell.setCellValue("Customer Type");
/* 4915:4987 */       cell.setCellStyle(headerCellStyle);
/* 4916:     */       
/* 4917:4989 */       cell = row.createCell(2);
/* 4918:4990 */       cell.setCellValue("Description");
/* 4919:4991 */       cell.setCellStyle(headerCellStyle);
/* 4920:     */       
/* 4921:4993 */       cell = row.createCell(3);
/* 4922:4994 */       cell.setCellValue("Total");
/* 4923:4995 */       cell.setCellStyle(headerCellStyle);
/* 4924:     */       
/* 4925:4997 */       cell = row.createCell(4);
/* 4926:4998 */       cell.setCellValue("Paid");
/* 4927:4999 */       cell.setCellStyle(headerCellStyle);
/* 4928:     */       
/* 4929:5001 */       cell = row.createCell(5);
/* 4930:5002 */       cell.setCellValue("Due");
/* 4931:5003 */       cell.setCellStyle(headerCellStyle);
/* 4932:     */       
/* 4933:5005 */       cell = row.createCell(6);
/* 4934:5006 */       cell.setCellValue("Total Paid");
/* 4935:5007 */       cell.setCellStyle(headerCellStyle);
/* 4936:     */       
/* 4937:5009 */       cell = row.createCell(7);
/* 4938:5010 */       cell.setCellValue("Total Due");
/* 4939:5011 */       cell.setCellStyle(headerCellStyle);
/* 4940:     */       
/* 4941:5013 */       cell = row.createCell(8);
/* 4942:5014 */       cell.setCellValue("Refference");
/* 4943:5015 */       cell.setCellStyle(headerCellStyle);
/* 4944:     */       
/* 4945:5017 */       cell = row.createCell(9);
/* 4946:5018 */       cell.setCellValue("Unique ID");
/* 4947:5019 */       cell.setCellStyle(headerCellStyle);
/* 4948:     */       
/* 4949:5021 */       cell = row.createCell(10);
/* 4950:5022 */       cell.setCellValue("Payment Mode");
/* 4951:5023 */       cell.setCellStyle(headerCellStyle);
/* 4952:     */       
/* 4953:5025 */       cell = row.createCell(11);
/* 4954:5026 */       cell.setCellValue("Date");
/* 4955:5027 */       cell.setCellStyle(headerCellStyle);
/* 4956:     */       
/* 4957:     */ 
/* 4958:     */ 
/* 4959:     */ 
/* 4960:     */ 
/* 4961:     */ 
/* 4962:     */ 
/* 4963:     */ 
/* 4964:     */ 
/* 4965:     */ 
/* 4966:     */ 
/* 4967:     */ 
/* 4968:     */ 
/* 4969:     */ 
/* 4970:     */ 
/* 4971:     */ 
/* 4972:     */ 
/* 4973:     */ 
/* 4974:     */ 
/* 4975:     */ 
/* 4976:     */ 
/* 4977:     */ 
/* 4978:     */ 
/* 4979:     */ 
/* 4980:     */ 
/* 4981:     */ 
/* 4982:     */ 
/* 4983:     */ 
/* 4984:     */ 
/* 4985:     */ 
/* 4986:     */ 
/* 4987:     */ 
/* 4988:     */ 
/* 4989:     */ 
/* 4990:     */ 
/* 4991:     */ 
/* 4992:     */ 
/* 4993:     */ 
/* 4994:     */ 
/* 4995:     */ 
/* 4996:     */ 
/* 4997:     */ 
/* 4998:     */ 
/* 4999:     */ 
/* 5000:     */ 
/* 5001:     */ 
/* 5002:     */ 
/* 5003:     */ 
/* 5004:     */ 
/* 5005:     */ 
/* 5006:     */ 
/* 5007:     */ 
/* 5008:     */ 
/* 5009:     */ 
/* 5010:     */ 
/* 5011:     */ 
/* 5012:     */ 
/* 5013:     */ 
/* 5014:     */ 
/* 5015:     */ 
/* 5016:     */ 
/* 5017:     */ 
/* 5018:     */ 
/* 5019:     */ 
/* 5020:     */ 
/* 5021:     */ 
/* 5022:     */ 
/* 5023:     */ 
/* 5024:     */ 
/* 5025:     */ 
/* 5026:     */ 
/* 5027:     */ 
/* 5028:     */ 
/* 5029:     */ 
/* 5030:     */ 
/* 5031:     */ 
/* 5032:     */ 
/* 5033:     */ 
/* 5034:     */ 
/* 5035:     */ 
/* 5036:     */ 
/* 5037:     */ 
/* 5038:     */ 
/* 5039:     */ 
/* 5040:     */ 
/* 5041:     */ 
/* 5042:     */ 
/* 5043:     */ 
/* 5044:     */ 
/* 5045:     */ 
/* 5046:     */ 
/* 5047:     */ 
/* 5048:     */ 
/* 5049:     */ 
/* 5050:     */ 
/* 5051:5123 */       List<ExcelReportDaoImpl> li = new ArrayList();
/* 5052:5124 */       while (this.resultSet.next())
/* 5053:     */       {
/* 5054:5126 */         this.daoImpl = new ExcelReportDaoImpl();
/* 5055:     */         
/* 5056:     */ 
/* 5057:5129 */         row = spreadSheet.createRow(currentRow++);
/* 5058:     */         
/* 5059:5131 */         cell = row.createCell(0);
/* 5060:5132 */         cell.setCellValue(this.resultSet.getInt("CUSTOMER_TRANS_ID"));
/* 5061:5133 */         cell.setCellStyle(dataCellStyle);
/* 5062:     */         
/* 5063:5135 */         cell = row.createCell(1);
/* 5064:5136 */         cell.setCellValue(this.resultSet.getString("CUSTOMER_TYPE"));
/* 5065:5137 */         cell.setCellStyle(dataCellStyle);
/* 5066:     */         
/* 5067:5139 */         cell = row.createCell(2);
/* 5068:5140 */         cell.setCellValue(this.resultSet.getString("CUSTOMER_TRANS_DISCRIPTION"));
/* 5069:5141 */         cell.setCellStyle(dataCellStyle);
/* 5070:     */         
/* 5071:5143 */         cell = row.createCell(3);
/* 5072:5144 */         cell.setCellValue(this.resultSet.getString("CUSTOMER_TRANS_TOTAL"));
/* 5073:5145 */         cell.setCellStyle(dataCellStyle);
/* 5074:     */         
/* 5075:5147 */         cell = row.createCell(4);
/* 5076:5148 */         cell.setCellValue(this.resultSet.getString("CUSTOMER_TRANS_PAID"));
/* 5077:5149 */         cell.setCellStyle(dataCellStyle);
/* 5078:     */         
/* 5079:5151 */         cell = row.createCell(5);
/* 5080:5152 */         cell.setCellValue(this.resultSet.getString("CUSTOMER_TRANS_DUE"));
/* 5081:5153 */         cell.setCellStyle(dataCellStyle);
/* 5082:     */         
/* 5083:5155 */         cell = row.createCell(6);
/* 5084:5156 */         cell.setCellValue(
/* 5085:5157 */           this.resultSet
/* 5086:5158 */           .getString("CUSTOMER_TRANS_TOTAL_PAID"));
/* 5087:5159 */         cell.setCellStyle(dataCellStyle);
/* 5088:     */         
/* 5089:5161 */         cell = row.createCell(7);
/* 5090:5162 */         cell.setCellValue(this.resultSet.getString("CUSTOMER_TRANS_TOTAL_DUE"));
/* 5091:5163 */         cell.setCellStyle(dataCellStyle);
/* 5092:     */         
/* 5093:5165 */         cell = row.createCell(8);
/* 5094:5166 */         cell.setCellValue(this.resultSet
/* 5095:5167 */           .getString("CUSTOMER_ID_RETAILER"));
/* 5096:5168 */         cell.setCellStyle(dataCellStyle);
/* 5097:     */         
/* 5098:5170 */         cell = row.createCell(9);
/* 5099:5171 */         cell.setCellValue(this.resultSet.getString("CUSTOMER_UNIQUE_ID"));
/* 5100:5172 */         cell.setCellStyle(dataCellStyle);
/* 5101:     */         
/* 5102:5174 */         cell = row.createCell(10);
/* 5103:5175 */         cell.setCellValue(this.resultSet.getString("CUSTOMER_TRANS_PAY_MODE"));
/* 5104:5176 */         cell.setCellStyle(dataCellStyle);
/* 5105:     */         
/* 5106:5178 */         cell = row.createCell(11);
/* 5107:5179 */         cell.setCellValue(this.resultSet.getString("CUSTOMER_TRANS_DATE"));
/* 5108:5180 */         cell.setCellStyle(dataCellStyle);
/* 5109:     */         
/* 5110:     */ 
/* 5111:     */ 
/* 5112:     */ 
/* 5113:     */ 
/* 5114:     */ 
/* 5115:     */ 
/* 5116:     */ 
/* 5117:     */ 
/* 5118:     */ 
/* 5119:     */ 
/* 5120:     */ 
/* 5121:     */ 
/* 5122:     */ 
/* 5123:     */ 
/* 5124:     */ 
/* 5125:     */ 
/* 5126:     */ 
/* 5127:     */ 
/* 5128:     */ 
/* 5129:     */ 
/* 5130:     */ 
/* 5131:     */ 
/* 5132:     */ 
/* 5133:     */ 
/* 5134:     */ 
/* 5135:     */ 
/* 5136:     */ 
/* 5137:     */ 
/* 5138:     */ 
/* 5139:     */ 
/* 5140:     */ 
/* 5141:     */ 
/* 5142:     */ 
/* 5143:     */ 
/* 5144:     */ 
/* 5145:     */ 
/* 5146:     */ 
/* 5147:     */ 
/* 5148:     */ 
/* 5149:     */ 
/* 5150:     */ 
/* 5151:     */ 
/* 5152:     */ 
/* 5153:     */ 
/* 5154:     */ 
/* 5155:     */ 
/* 5156:     */ 
/* 5157:     */ 
/* 5158:     */ 
/* 5159:     */ 
/* 5160:     */ 
/* 5161:     */ 
/* 5162:     */ 
/* 5163:     */ 
/* 5164:     */ 
/* 5165:     */ 
/* 5166:     */ 
/* 5167:     */ 
/* 5168:     */ 
/* 5169:     */ 
/* 5170:     */ 
/* 5171:     */ 
/* 5172:     */ 
/* 5173:     */ 
/* 5174:     */ 
/* 5175:     */ 
/* 5176:     */ 
/* 5177:     */ 
/* 5178:     */ 
/* 5179:     */ 
/* 5180:     */ 
/* 5181:     */ 
/* 5182:     */ 
/* 5183:     */ 
/* 5184:     */ 
/* 5185:     */ 
/* 5186:     */ 
/* 5187:     */ 
/* 5188:     */ 
/* 5189:     */ 
/* 5190:     */ 
/* 5191:     */ 
/* 5192:     */ 
/* 5193:     */ 
/* 5194:     */ 
/* 5195:     */ 
/* 5196:     */ 
/* 5197:     */ 
/* 5198:     */ 
/* 5199:     */ 
/* 5200:     */ 
/* 5201:5273 */         li.add(this.daoImpl);
/* 5202:     */       }
/* 5203:5276 */       ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
/* 5204:5277 */       wb.write(outByteStream);
/* 5205:5278 */       byte[] outArray = outByteStream.toByteArray();
/* 5206:5279 */       response.setContentType("application/ms-excel");
/* 5207:5280 */       response.setContentLength(outArray.length);
/* 5208:5281 */       response.setHeader("Expires:", "0");
/* 5209:5282 */       response.setHeader("Content-Disposition", 
/* 5210:5283 */         "attachment; filename=RetailerTransaction_list.xls");
/* 5211:     */       
/* 5212:     */ 
/* 5213:5286 */       ServletOutputStream fileOut = response.getOutputStream();
/* 5214:5287 */       fileOut.write(outArray);
/* 5215:5288 */       fileOut.flush();
/* 5216:5289 */       fileOut.close();
/* 5217:     */     }
/* 5218:     */     catch (Exception e)
/* 5219:     */     {
/* 5220:5292 */       e.printStackTrace();
/* 5221:     */     }
/* 5222:     */   }
/* 5223:     */   
/* 5224:     */   public void consumerTransactionExcelReport(HttpServletRequest request, HttpServletResponse response)
/* 5225:     */   {
/* 5226:     */     try
/* 5227:     */     {
/* 5228:5302 */       System.out.println("try");
/* 5229:5303 */       this.connection = getConnection();
/* 5230:     */       
/* 5231:5305 */       String query = "SELECT * FROM TAB_OWNER_CUSTOMER_TRANSACTION WHERE CUSTOMER_TYPE=? AND SHOP_ID=?";
/* 5232:5306 */       this.preparedStatement = this.connection.prepareStatement(query);
/* 5233:5307 */       this.preparedStatement.setString(1, "Consumer");
/* 5234:     */       
/* 5235:5309 */       this.resultSet = this.preparedStatement.executeQuery();
/* 5236:5310 */       System.out.println("executeQuery");
/* 5237:5311 */       int currentRow = 1;
/* 5238:     */       
/* 5239:5313 */       Workbook wb = new HSSFWorkbook();
/* 5240:5314 */       Sheet spreadSheet = wb.createSheet("Consumer Transaction List");
/* 5241:     */       
/* 5242:     */ 
/* 5243:5317 */       Row row = spreadSheet.createRow(0);
/* 5244:     */       
/* 5245:     */ 
/* 5246:5320 */       CellStyle headerCellStyle = wb.createCellStyle();
/* 5247:5321 */       headerCellStyle.setFillForegroundColor((short)49);
/* 5248:5322 */       headerCellStyle.setFillPattern((short)1);
/* 5249:     */       
/* 5250:5324 */       Font setFont = wb.createFont();
/* 5251:5325 */       setFont.setFontHeightInPoints((short)11);
/* 5252:5326 */       setFont.setColor((short)8);
/* 5253:5327 */       setFont.setBoldweight((short)700);
/* 5254:5328 */       headerCellStyle.setBorderBottom((short)1);
/* 5255:5329 */       headerCellStyle.setFont(setFont);
/* 5256:     */       
/* 5257:     */ 
/* 5258:5332 */       CellStyle dataCellStyle = wb.createCellStyle();
/* 5259:5333 */       Font setDataFont = wb.createFont();
/* 5260:5334 */       setDataFont.setColor((short)8);
/* 5261:5335 */       dataCellStyle.setBorderBottom((short)0);
/* 5262:5336 */       dataCellStyle.setFont(setDataFont);
/* 5263:     */       
/* 5264:5338 */       Cell cell = null;
/* 5265:     */       
/* 5266:5340 */       spreadSheet.setColumnWidth(0, 2560);
/* 5267:5341 */       spreadSheet.setColumnWidth(1, 7680);
/* 5268:5342 */       spreadSheet.setColumnWidth(2, 6400);
/* 5269:5343 */       spreadSheet.setColumnWidth(3, 6400);
/* 5270:5344 */       spreadSheet.setColumnWidth(4, 6400);
/* 5271:5345 */       spreadSheet.setColumnWidth(5, 6400);
/* 5272:5346 */       spreadSheet.setColumnWidth(6, 6400);
/* 5273:5347 */       spreadSheet.setColumnWidth(7, 6400);
/* 5274:5348 */       spreadSheet.setColumnWidth(8, 6400);
/* 5275:5349 */       spreadSheet.setColumnWidth(9, 6400);
/* 5276:5350 */       spreadSheet.setColumnWidth(10, 6400);
/* 5277:5351 */       spreadSheet.setColumnWidth(11, 6400);
/* 5278:5352 */       spreadSheet.setColumnWidth(12, 6400);
/* 5279:     */       
/* 5280:     */ 
/* 5281:     */ 
/* 5282:     */ 
/* 5283:     */ 
/* 5284:     */ 
/* 5285:     */ 
/* 5286:     */ 
/* 5287:     */ 
/* 5288:     */ 
/* 5289:     */ 
/* 5290:     */ 
/* 5291:     */ 
/* 5292:     */ 
/* 5293:     */ 
/* 5294:     */ 
/* 5295:     */ 
/* 5296:     */ 
/* 5297:     */ 
/* 5298:     */ 
/* 5299:     */ 
/* 5300:     */ 
/* 5301:     */ 
/* 5302:5376 */       cell = row.createCell(0);
/* 5303:5377 */       cell.setCellValue("Transaction Id");
/* 5304:5378 */       cell.setCellStyle(headerCellStyle);
/* 5305:     */       
/* 5306:5380 */       cell = row.createCell(1);
/* 5307:5381 */       cell.setCellValue("Customer Type");
/* 5308:5382 */       cell.setCellStyle(headerCellStyle);
/* 5309:     */       
/* 5310:5384 */       cell = row.createCell(2);
/* 5311:5385 */       cell.setCellValue("Description");
/* 5312:5386 */       cell.setCellStyle(headerCellStyle);
/* 5313:     */       
/* 5314:5388 */       cell = row.createCell(3);
/* 5315:5389 */       cell.setCellValue("Total");
/* 5316:5390 */       cell.setCellStyle(headerCellStyle);
/* 5317:     */       
/* 5318:5392 */       cell = row.createCell(4);
/* 5319:5393 */       cell.setCellValue("Paid");
/* 5320:5394 */       cell.setCellStyle(headerCellStyle);
/* 5321:     */       
/* 5322:5396 */       cell = row.createCell(5);
/* 5323:5397 */       cell.setCellValue("Due");
/* 5324:5398 */       cell.setCellStyle(headerCellStyle);
/* 5325:     */       
/* 5326:5400 */       cell = row.createCell(6);
/* 5327:5401 */       cell.setCellValue("Total Paid");
/* 5328:5402 */       cell.setCellStyle(headerCellStyle);
/* 5329:     */       
/* 5330:5404 */       cell = row.createCell(7);
/* 5331:5405 */       cell.setCellValue("Total Due");
/* 5332:5406 */       cell.setCellStyle(headerCellStyle);
/* 5333:     */       
/* 5334:5408 */       cell = row.createCell(8);
/* 5335:5409 */       cell.setCellValue("Refference");
/* 5336:5410 */       cell.setCellStyle(headerCellStyle);
/* 5337:     */       
/* 5338:5412 */       cell = row.createCell(9);
/* 5339:5413 */       cell.setCellValue("Unique ID");
/* 5340:5414 */       cell.setCellStyle(headerCellStyle);
/* 5341:     */       
/* 5342:5416 */       cell = row.createCell(10);
/* 5343:5417 */       cell.setCellValue("Payment Mode");
/* 5344:5418 */       cell.setCellStyle(headerCellStyle);
/* 5345:     */       
/* 5346:5420 */       cell = row.createCell(11);
/* 5347:5421 */       cell.setCellValue("Date");
/* 5348:5422 */       cell.setCellStyle(headerCellStyle);
/* 5349:     */       
/* 5350:     */ 
/* 5351:     */ 
/* 5352:     */ 
/* 5353:     */ 
/* 5354:     */ 
/* 5355:     */ 
/* 5356:     */ 
/* 5357:     */ 
/* 5358:     */ 
/* 5359:     */ 
/* 5360:     */ 
/* 5361:     */ 
/* 5362:     */ 
/* 5363:     */ 
/* 5364:     */ 
/* 5365:     */ 
/* 5366:     */ 
/* 5367:     */ 
/* 5368:     */ 
/* 5369:     */ 
/* 5370:     */ 
/* 5371:     */ 
/* 5372:     */ 
/* 5373:     */ 
/* 5374:     */ 
/* 5375:     */ 
/* 5376:     */ 
/* 5377:     */ 
/* 5378:     */ 
/* 5379:     */ 
/* 5380:     */ 
/* 5381:     */ 
/* 5382:     */ 
/* 5383:     */ 
/* 5384:     */ 
/* 5385:     */ 
/* 5386:     */ 
/* 5387:     */ 
/* 5388:     */ 
/* 5389:     */ 
/* 5390:     */ 
/* 5391:     */ 
/* 5392:     */ 
/* 5393:     */ 
/* 5394:     */ 
/* 5395:     */ 
/* 5396:     */ 
/* 5397:     */ 
/* 5398:     */ 
/* 5399:     */ 
/* 5400:     */ 
/* 5401:     */ 
/* 5402:     */ 
/* 5403:     */ 
/* 5404:     */ 
/* 5405:     */ 
/* 5406:     */ 
/* 5407:     */ 
/* 5408:     */ 
/* 5409:     */ 
/* 5410:     */ 
/* 5411:     */ 
/* 5412:     */ 
/* 5413:     */ 
/* 5414:     */ 
/* 5415:     */ 
/* 5416:     */ 
/* 5417:     */ 
/* 5418:     */ 
/* 5419:     */ 
/* 5420:     */ 
/* 5421:     */ 
/* 5422:     */ 
/* 5423:     */ 
/* 5424:     */ 
/* 5425:     */ 
/* 5426:     */ 
/* 5427:     */ 
/* 5428:     */ 
/* 5429:     */ 
/* 5430:     */ 
/* 5431:     */ 
/* 5432:     */ 
/* 5433:     */ 
/* 5434:     */ 
/* 5435:     */ 
/* 5436:     */ 
/* 5437:     */ 
/* 5438:     */ 
/* 5439:     */ 
/* 5440:     */ 
/* 5441:     */ 
/* 5442:     */ 
/* 5443:     */ 
/* 5444:5518 */       List<ExcelReportDaoImpl> li = new ArrayList();
/* 5445:5519 */       while (this.resultSet.next())
/* 5446:     */       {
/* 5447:5521 */         this.daoImpl = new ExcelReportDaoImpl();
/* 5448:     */         
/* 5449:     */ 
/* 5450:5524 */         row = spreadSheet.createRow(currentRow++);
/* 5451:     */         
/* 5452:5526 */         cell = row.createCell(0);
/* 5453:5527 */         cell.setCellValue(this.resultSet.getInt("CUSTOMER_TRANS_ID"));
/* 5454:5528 */         cell.setCellStyle(dataCellStyle);
/* 5455:     */         
/* 5456:5530 */         cell = row.createCell(1);
/* 5457:5531 */         cell.setCellValue(this.resultSet.getString("CUSTOMER_TYPE"));
/* 5458:5532 */         cell.setCellStyle(dataCellStyle);
/* 5459:     */         
/* 5460:5534 */         cell = row.createCell(2);
/* 5461:5535 */         cell.setCellValue(this.resultSet.getString("CUSTOMER_TRANS_DISCRIPTION"));
/* 5462:5536 */         cell.setCellStyle(dataCellStyle);
/* 5463:     */         
/* 5464:5538 */         cell = row.createCell(3);
/* 5465:5539 */         cell.setCellValue(this.resultSet.getString("CUSTOMER_TRANS_TOTAL"));
/* 5466:5540 */         cell.setCellStyle(dataCellStyle);
/* 5467:     */         
/* 5468:5542 */         cell = row.createCell(4);
/* 5469:5543 */         cell.setCellValue(this.resultSet.getString("CUSTOMER_TRANS_PAID"));
/* 5470:5544 */         cell.setCellStyle(dataCellStyle);
/* 5471:     */         
/* 5472:5546 */         cell = row.createCell(5);
/* 5473:5547 */         cell.setCellValue(this.resultSet.getString("CUSTOMER_TRANS_DUE"));
/* 5474:5548 */         cell.setCellStyle(dataCellStyle);
/* 5475:     */         
/* 5476:5550 */         cell = row.createCell(6);
/* 5477:5551 */         cell.setCellValue(
/* 5478:5552 */           this.resultSet
/* 5479:5553 */           .getString("CUSTOMER_TRANS_TOTAL_PAID"));
/* 5480:5554 */         cell.setCellStyle(dataCellStyle);
/* 5481:     */         
/* 5482:5556 */         cell = row.createCell(7);
/* 5483:5557 */         cell.setCellValue(this.resultSet.getString("CUSTOMER_TRANS_TOTAL_DUE"));
/* 5484:5558 */         cell.setCellStyle(dataCellStyle);
/* 5485:     */         
/* 5486:5560 */         cell = row.createCell(8);
/* 5487:5561 */         cell.setCellValue(this.resultSet
/* 5488:5562 */           .getString("CUSTOMER_ID_RETAILER"));
/* 5489:5563 */         cell.setCellStyle(dataCellStyle);
/* 5490:     */         
/* 5491:5565 */         cell = row.createCell(9);
/* 5492:5566 */         cell.setCellValue(this.resultSet.getString("CUSTOMER_UNIQUE_ID"));
/* 5493:5567 */         cell.setCellStyle(dataCellStyle);
/* 5494:     */         
/* 5495:5569 */         cell = row.createCell(10);
/* 5496:5570 */         cell.setCellValue(this.resultSet.getString("CUSTOMER_TRANS_PAY_MODE"));
/* 5497:5571 */         cell.setCellStyle(dataCellStyle);
/* 5498:     */         
/* 5499:5573 */         cell = row.createCell(11);
/* 5500:5574 */         cell.setCellValue(this.resultSet.getString("CUSTOMER_TRANS_DATE"));
/* 5501:5575 */         cell.setCellStyle(dataCellStyle);
/* 5502:     */         
/* 5503:     */ 
/* 5504:     */ 
/* 5505:     */ 
/* 5506:     */ 
/* 5507:     */ 
/* 5508:     */ 
/* 5509:     */ 
/* 5510:     */ 
/* 5511:     */ 
/* 5512:     */ 
/* 5513:     */ 
/* 5514:     */ 
/* 5515:     */ 
/* 5516:     */ 
/* 5517:     */ 
/* 5518:     */ 
/* 5519:     */ 
/* 5520:     */ 
/* 5521:     */ 
/* 5522:     */ 
/* 5523:     */ 
/* 5524:     */ 
/* 5525:     */ 
/* 5526:     */ 
/* 5527:     */ 
/* 5528:     */ 
/* 5529:     */ 
/* 5530:     */ 
/* 5531:     */ 
/* 5532:     */ 
/* 5533:     */ 
/* 5534:     */ 
/* 5535:     */ 
/* 5536:     */ 
/* 5537:     */ 
/* 5538:     */ 
/* 5539:     */ 
/* 5540:     */ 
/* 5541:     */ 
/* 5542:     */ 
/* 5543:     */ 
/* 5544:     */ 
/* 5545:     */ 
/* 5546:     */ 
/* 5547:     */ 
/* 5548:     */ 
/* 5549:     */ 
/* 5550:     */ 
/* 5551:     */ 
/* 5552:     */ 
/* 5553:     */ 
/* 5554:     */ 
/* 5555:     */ 
/* 5556:     */ 
/* 5557:     */ 
/* 5558:     */ 
/* 5559:     */ 
/* 5560:     */ 
/* 5561:     */ 
/* 5562:     */ 
/* 5563:     */ 
/* 5564:     */ 
/* 5565:     */ 
/* 5566:     */ 
/* 5567:     */ 
/* 5568:     */ 
/* 5569:     */ 
/* 5570:     */ 
/* 5571:     */ 
/* 5572:     */ 
/* 5573:     */ 
/* 5574:     */ 
/* 5575:     */ 
/* 5576:     */ 
/* 5577:     */ 
/* 5578:     */ 
/* 5579:     */ 
/* 5580:     */ 
/* 5581:     */ 
/* 5582:     */ 
/* 5583:     */ 
/* 5584:     */ 
/* 5585:     */ 
/* 5586:     */ 
/* 5587:     */ 
/* 5588:     */ 
/* 5589:     */ 
/* 5590:     */ 
/* 5591:     */ 
/* 5592:     */ 
/* 5593:     */ 
/* 5594:5668 */         li.add(this.daoImpl);
/* 5595:     */       }
/* 5596:5671 */       ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
/* 5597:5672 */       wb.write(outByteStream);
/* 5598:5673 */       byte[] outArray = outByteStream.toByteArray();
/* 5599:5674 */       response.setContentType("application/ms-excel");
/* 5600:5675 */       response.setContentLength(outArray.length);
/* 5601:5676 */       response.setHeader("Expires:", "0");
/* 5602:5677 */       response.setHeader("Content-Disposition", 
/* 5603:5678 */         "attachment; filename=ConsumerTransaction_list.xls");
/* 5604:     */       
/* 5605:     */ 
/* 5606:5681 */       ServletOutputStream fileOut = response.getOutputStream();
/* 5607:5682 */       fileOut.write(outArray);
/* 5608:5683 */       fileOut.flush();
/* 5609:5684 */       fileOut.close();
/* 5610:     */     }
/* 5611:     */     catch (Exception e)
/* 5612:     */     {
/* 5613:5687 */       e.printStackTrace();
/* 5614:     */     }
/* 5615:     */   }
/* 5616:     */   
/* 5617:     */   public void dealerTransactionExcelReport(HttpServletRequest request, HttpServletResponse response)
/* 5618:     */   {
/* 5619:     */     try
/* 5620:     */     {
/* 5621:5696 */       System.out.println("try");
/* 5622:5697 */       this.connection = getConnection();
/* 5623:     */       
/* 5624:5699 */       String query = "SELECT * FROM TAB_DEALER_OWNER_TRANSACTION WHERE SHOP_ID=?";
/* 5625:5700 */       this.preparedStatement = this.connection.prepareStatement(query);
/* 5626:     */       
/* 5627:     */ 
/* 5628:5703 */       this.resultSet = this.preparedStatement.executeQuery();
/* 5629:5704 */       System.out.println("executeQuery");
/* 5630:5705 */       int currentRow = 1;
/* 5631:     */       
/* 5632:5707 */       Workbook wb = new HSSFWorkbook();
/* 5633:5708 */       Sheet spreadSheet = wb.createSheet("Dealer Transaction List");
/* 5634:     */       
/* 5635:     */ 
/* 5636:5711 */       Row row = spreadSheet.createRow(0);
/* 5637:     */       
/* 5638:     */ 
/* 5639:5714 */       CellStyle headerCellStyle = wb.createCellStyle();
/* 5640:5715 */       headerCellStyle.setFillForegroundColor((short)49);
/* 5641:5716 */       headerCellStyle.setFillPattern((short)1);
/* 5642:     */       
/* 5643:5718 */       Font setFont = wb.createFont();
/* 5644:5719 */       setFont.setFontHeightInPoints((short)11);
/* 5645:5720 */       setFont.setColor((short)8);
/* 5646:5721 */       setFont.setBoldweight((short)700);
/* 5647:5722 */       headerCellStyle.setBorderBottom((short)1);
/* 5648:5723 */       headerCellStyle.setFont(setFont);
/* 5649:     */       
/* 5650:     */ 
/* 5651:5726 */       CellStyle dataCellStyle = wb.createCellStyle();
/* 5652:5727 */       Font setDataFont = wb.createFont();
/* 5653:5728 */       setDataFont.setColor((short)8);
/* 5654:5729 */       dataCellStyle.setBorderBottom((short)0);
/* 5655:5730 */       dataCellStyle.setFont(setDataFont);
/* 5656:     */       
/* 5657:5732 */       Cell cell = null;
/* 5658:     */       
/* 5659:5734 */       spreadSheet.setColumnWidth(0, 2560);
/* 5660:5735 */       spreadSheet.setColumnWidth(1, 7680);
/* 5661:5736 */       spreadSheet.setColumnWidth(2, 6400);
/* 5662:5737 */       spreadSheet.setColumnWidth(3, 6400);
/* 5663:5738 */       spreadSheet.setColumnWidth(4, 6400);
/* 5664:5739 */       spreadSheet.setColumnWidth(5, 6400);
/* 5665:5740 */       spreadSheet.setColumnWidth(6, 6400);
/* 5666:5741 */       spreadSheet.setColumnWidth(7, 6400);
/* 5667:5742 */       spreadSheet.setColumnWidth(8, 6400);
/* 5668:5743 */       spreadSheet.setColumnWidth(9, 6400);
/* 5669:5744 */       spreadSheet.setColumnWidth(10, 6400);
/* 5670:5745 */       spreadSheet.setColumnWidth(11, 6400);
/* 5671:5746 */       spreadSheet.setColumnWidth(12, 6400);
/* 5672:     */       
/* 5673:     */ 
/* 5674:     */ 
/* 5675:     */ 
/* 5676:     */ 
/* 5677:     */ 
/* 5678:     */ 
/* 5679:     */ 
/* 5680:     */ 
/* 5681:     */ 
/* 5682:     */ 
/* 5683:     */ 
/* 5684:     */ 
/* 5685:     */ 
/* 5686:     */ 
/* 5687:     */ 
/* 5688:     */ 
/* 5689:     */ 
/* 5690:     */ 
/* 5691:     */ 
/* 5692:     */ 
/* 5693:     */ 
/* 5694:     */ 
/* 5695:5770 */       cell = row.createCell(0);
/* 5696:5771 */       cell.setCellValue("Transaction Id");
/* 5697:5772 */       cell.setCellStyle(headerCellStyle);
/* 5698:     */       
/* 5699:5774 */       cell = row.createCell(1);
/* 5700:5775 */       cell.setCellValue("Dealer Refference");
/* 5701:5776 */       cell.setCellStyle(headerCellStyle);
/* 5702:     */       
/* 5703:5778 */       cell = row.createCell(2);
/* 5704:5779 */       cell.setCellValue("Description");
/* 5705:5780 */       cell.setCellStyle(headerCellStyle);
/* 5706:     */       
/* 5707:5782 */       cell = row.createCell(3);
/* 5708:5783 */       cell.setCellValue("Total");
/* 5709:5784 */       cell.setCellStyle(headerCellStyle);
/* 5710:     */       
/* 5711:5786 */       cell = row.createCell(4);
/* 5712:5787 */       cell.setCellValue("Paid");
/* 5713:5788 */       cell.setCellStyle(headerCellStyle);
/* 5714:     */       
/* 5715:5790 */       cell = row.createCell(5);
/* 5716:5791 */       cell.setCellValue("Due");
/* 5717:5792 */       cell.setCellStyle(headerCellStyle);
/* 5718:     */       
/* 5719:5794 */       cell = row.createCell(6);
/* 5720:5795 */       cell.setCellValue("Total Paid");
/* 5721:5796 */       cell.setCellStyle(headerCellStyle);
/* 5722:     */       
/* 5723:5798 */       cell = row.createCell(7);
/* 5724:5799 */       cell.setCellValue("Total Due");
/* 5725:5800 */       cell.setCellStyle(headerCellStyle);
/* 5726:     */       
/* 5727:5802 */       cell = row.createCell(8);
/* 5728:5803 */       cell.setCellValue("Bill No");
/* 5729:5804 */       cell.setCellStyle(headerCellStyle);
/* 5730:     */       
/* 5731:5806 */       cell = row.createCell(9);
/* 5732:5807 */       cell.setCellValue("Payment Mode");
/* 5733:5808 */       cell.setCellStyle(headerCellStyle);
/* 5734:     */       
/* 5735:5810 */       cell = row.createCell(10);
/* 5736:5811 */       cell.setCellValue("Date");
/* 5737:5812 */       cell.setCellStyle(headerCellStyle);
/* 5738:     */       
/* 5739:     */ 
/* 5740:     */ 
/* 5741:     */ 
/* 5742:     */ 
/* 5743:     */ 
/* 5744:     */ 
/* 5745:     */ 
/* 5746:     */ 
/* 5747:     */ 
/* 5748:     */ 
/* 5749:     */ 
/* 5750:     */ 
/* 5751:     */ 
/* 5752:     */ 
/* 5753:     */ 
/* 5754:     */ 
/* 5755:     */ 
/* 5756:     */ 
/* 5757:     */ 
/* 5758:     */ 
/* 5759:     */ 
/* 5760:     */ 
/* 5761:     */ 
/* 5762:     */ 
/* 5763:     */ 
/* 5764:     */ 
/* 5765:     */ 
/* 5766:     */ 
/* 5767:     */ 
/* 5768:     */ 
/* 5769:     */ 
/* 5770:     */ 
/* 5771:     */ 
/* 5772:     */ 
/* 5773:     */ 
/* 5774:     */ 
/* 5775:     */ 
/* 5776:     */ 
/* 5777:     */ 
/* 5778:     */ 
/* 5779:     */ 
/* 5780:     */ 
/* 5781:     */ 
/* 5782:     */ 
/* 5783:     */ 
/* 5784:     */ 
/* 5785:     */ 
/* 5786:     */ 
/* 5787:     */ 
/* 5788:     */ 
/* 5789:     */ 
/* 5790:     */ 
/* 5791:     */ 
/* 5792:     */ 
/* 5793:     */ 
/* 5794:     */ 
/* 5795:     */ 
/* 5796:     */ 
/* 5797:     */ 
/* 5798:     */ 
/* 5799:     */ 
/* 5800:     */ 
/* 5801:     */ 
/* 5802:     */ 
/* 5803:     */ 
/* 5804:     */ 
/* 5805:     */ 
/* 5806:     */ 
/* 5807:     */ 
/* 5808:     */ 
/* 5809:     */ 
/* 5810:     */ 
/* 5811:     */ 
/* 5812:     */ 
/* 5813:     */ 
/* 5814:     */ 
/* 5815:     */ 
/* 5816:     */ 
/* 5817:     */ 
/* 5818:     */ 
/* 5819:     */ 
/* 5820:     */ 
/* 5821:     */ 
/* 5822:     */ 
/* 5823:     */ 
/* 5824:     */ 
/* 5825:     */ 
/* 5826:     */ 
/* 5827:     */ 
/* 5828:     */ 
/* 5829:     */ 
/* 5830:     */ 
/* 5831:     */ 
/* 5832:     */ 
/* 5833:     */ 
/* 5834:     */ 
/* 5835:     */ 
/* 5836:     */ 
/* 5837:5912 */       List<ExcelReportDaoImpl> li = new ArrayList();
/* 5838:5913 */       while (this.resultSet.next())
/* 5839:     */       {
/* 5840:5915 */         this.daoImpl = new ExcelReportDaoImpl();
/* 5841:     */         
/* 5842:     */ 
/* 5843:5918 */         row = spreadSheet.createRow(currentRow++);
/* 5844:     */         
/* 5845:5920 */         cell = row.createCell(0);
/* 5846:5921 */         cell.setCellValue(this.resultSet.getInt("DEALER_TRANS_ID"));
/* 5847:5922 */         cell.setCellStyle(dataCellStyle);
/* 5848:     */         
/* 5849:5924 */         cell = row.createCell(1);
/* 5850:5925 */         cell.setCellValue(this.resultSet.getInt("DEALER_ID_REF"));
/* 5851:5926 */         cell.setCellStyle(dataCellStyle);
/* 5852:     */         
/* 5853:5928 */         cell = row.createCell(2);
/* 5854:5929 */         cell.setCellValue(this.resultSet.getString("DEALER_TRANS_DISCRIPTION"));
/* 5855:5930 */         cell.setCellStyle(dataCellStyle);
/* 5856:     */         
/* 5857:5932 */         cell = row.createCell(3);
/* 5858:5933 */         cell.setCellValue(this.resultSet.getFloat("DEALER_TRANS_TOTAL"));
/* 5859:5934 */         cell.setCellStyle(dataCellStyle);
/* 5860:     */         
/* 5861:5936 */         cell = row.createCell(4);
/* 5862:5937 */         cell.setCellValue(this.resultSet.getFloat("DEALER_TRANS_PAID"));
/* 5863:5938 */         cell.setCellStyle(dataCellStyle);
/* 5864:     */         
/* 5865:5940 */         cell = row.createCell(5);
/* 5866:5941 */         cell.setCellValue(this.resultSet.getFloat("DEALER_TRANS_DUE"));
/* 5867:5942 */         cell.setCellStyle(dataCellStyle);
/* 5868:     */         
/* 5869:5944 */         cell = row.createCell(6);
/* 5870:5945 */         cell.setCellValue(
/* 5871:5946 */           this.resultSet
/* 5872:5947 */           .getFloat("DEALER_TRANS_TOTAL_PAID"));
/* 5873:5948 */         cell.setCellStyle(dataCellStyle);
/* 5874:     */         
/* 5875:5950 */         cell = row.createCell(7);
/* 5876:5951 */         cell.setCellValue(this.resultSet.getFloat("DEALER_TRANS_TOTAL_DUE"));
/* 5877:5952 */         cell.setCellStyle(dataCellStyle);
/* 5878:     */         
/* 5879:5954 */         cell = row.createCell(8);
/* 5880:5955 */         cell.setCellValue(this.resultSet
/* 5881:5956 */           .getString("DEALER_TRANS_BILL_NO"));
/* 5882:5957 */         cell.setCellStyle(dataCellStyle);
/* 5883:     */         
/* 5884:5959 */         cell = row.createCell(9);
/* 5885:5960 */         cell.setCellValue(this.resultSet.getString("DEALER_TANS_PAYMENT_MODE"));
/* 5886:5961 */         cell.setCellStyle(dataCellStyle);
/* 5887:     */         
/* 5888:5963 */         cell = row.createCell(10);
/* 5889:5964 */         cell.setCellValue(this.resultSet.getString("DEALER_TRANS_DATE"));
/* 5890:5965 */         cell.setCellStyle(dataCellStyle);
/* 5891:     */         
/* 5892:     */ 
/* 5893:     */ 
/* 5894:     */ 
/* 5895:     */ 
/* 5896:     */ 
/* 5897:     */ 
/* 5898:     */ 
/* 5899:     */ 
/* 5900:     */ 
/* 5901:     */ 
/* 5902:     */ 
/* 5903:     */ 
/* 5904:     */ 
/* 5905:     */ 
/* 5906:     */ 
/* 5907:     */ 
/* 5908:     */ 
/* 5909:     */ 
/* 5910:     */ 
/* 5911:     */ 
/* 5912:     */ 
/* 5913:     */ 
/* 5914:     */ 
/* 5915:     */ 
/* 5916:     */ 
/* 5917:     */ 
/* 5918:     */ 
/* 5919:     */ 
/* 5920:     */ 
/* 5921:     */ 
/* 5922:     */ 
/* 5923:     */ 
/* 5924:     */ 
/* 5925:     */ 
/* 5926:     */ 
/* 5927:     */ 
/* 5928:     */ 
/* 5929:     */ 
/* 5930:     */ 
/* 5931:     */ 
/* 5932:     */ 
/* 5933:     */ 
/* 5934:     */ 
/* 5935:     */ 
/* 5936:     */ 
/* 5937:     */ 
/* 5938:     */ 
/* 5939:     */ 
/* 5940:     */ 
/* 5941:     */ 
/* 5942:     */ 
/* 5943:     */ 
/* 5944:     */ 
/* 5945:     */ 
/* 5946:     */ 
/* 5947:     */ 
/* 5948:     */ 
/* 5949:     */ 
/* 5950:     */ 
/* 5951:     */ 
/* 5952:     */ 
/* 5953:     */ 
/* 5954:     */ 
/* 5955:     */ 
/* 5956:     */ 
/* 5957:     */ 
/* 5958:     */ 
/* 5959:     */ 
/* 5960:     */ 
/* 5961:     */ 
/* 5962:     */ 
/* 5963:     */ 
/* 5964:     */ 
/* 5965:     */ 
/* 5966:     */ 
/* 5967:     */ 
/* 5968:     */ 
/* 5969:     */ 
/* 5970:     */ 
/* 5971:     */ 
/* 5972:     */ 
/* 5973:     */ 
/* 5974:     */ 
/* 5975:     */ 
/* 5976:     */ 
/* 5977:     */ 
/* 5978:     */ 
/* 5979:     */ 
/* 5980:     */ 
/* 5981:     */ 
/* 5982:     */ 
/* 5983:     */ 
/* 5984:     */ 
/* 5985:     */ 
/* 5986:     */ 
/* 5987:6062 */         li.add(this.daoImpl);
/* 5988:     */       }
/* 5989:6065 */       ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
/* 5990:6066 */       wb.write(outByteStream);
/* 5991:6067 */       byte[] outArray = outByteStream.toByteArray();
/* 5992:6068 */       response.setContentType("application/ms-excel");
/* 5993:6069 */       response.setContentLength(outArray.length);
/* 5994:6070 */       response.setHeader("Expires:", "0");
/* 5995:6071 */       response.setHeader("Content-Disposition", 
/* 5996:6072 */         "attachment; filename=DealerTransaction_list.xls");
/* 5997:     */       
/* 5998:     */ 
/* 5999:6075 */       ServletOutputStream fileOut = response.getOutputStream();
/* 6000:6076 */       fileOut.write(outArray);
/* 6001:6077 */       fileOut.flush();
/* 6002:6078 */       fileOut.close();
/* 6003:     */     }
/* 6004:     */     catch (Exception e)
/* 6005:     */     {
/* 6006:6081 */       e.printStackTrace();
/* 6007:     */     }
/* 6008:     */   }
/* 6009:     */   
/* 6010:     */   public void salesExcelReport(HttpServletRequest request, HttpServletResponse response)
/* 6011:     */   {
/* 6012:     */     try
/* 6013:     */     {
/* 6014:6090 */       System.out.println("try");
/* 6015:6091 */       this.connection = getConnection();
/* 6016:     */       
/* 6017:6093 */       String query = "SELECT * FROM  TAB_SALES_DETAILS ";
/* 6018:6094 */       this.preparedStatement = this.connection.prepareStatement(query);
/* 6019:     */       
/* 6020:     */ 
/* 6021:     */ 
/* 6022:     */ 
/* 6023:     */ 
/* 6024:     */ 
/* 6025:6101 */       this.resultSet = this.preparedStatement.executeQuery();
/* 6026:6102 */       System.out.println("executeQuery");
/* 6027:6103 */       int currentRow = 1;
/* 6028:     */       
/* 6029:6105 */       Workbook wb = new HSSFWorkbook();
/* 6030:6106 */       Sheet spreadSheet = wb.createSheet("Sales List");
/* 6031:     */       
/* 6032:     */ 
/* 6033:6109 */       Row row = spreadSheet.createRow(0);
/* 6034:     */       
/* 6035:     */ 
/* 6036:6112 */       CellStyle headerCellStyle = wb.createCellStyle();
/* 6037:6113 */       headerCellStyle.setFillForegroundColor((short)49);
/* 6038:6114 */       headerCellStyle.setFillPattern((short)1);
/* 6039:     */       
/* 6040:6116 */       Font setFont = wb.createFont();
/* 6041:6117 */       setFont.setFontHeightInPoints((short)11);
/* 6042:6118 */       setFont.setColor((short)8);
/* 6043:6119 */       setFont.setBoldweight((short)700);
/* 6044:6120 */       headerCellStyle.setBorderBottom((short)1);
/* 6045:6121 */       headerCellStyle.setFont(setFont);
/* 6046:     */       
/* 6047:     */ 
/* 6048:6124 */       CellStyle dataCellStyle = wb.createCellStyle();
/* 6049:6125 */       Font setDataFont = wb.createFont();
/* 6050:6126 */       setDataFont.setColor((short)8);
/* 6051:6127 */       dataCellStyle.setBorderBottom((short)0);
/* 6052:6128 */       dataCellStyle.setFont(setDataFont);
/* 6053:     */       
/* 6054:6130 */       Cell cell = null;
/* 6055:     */       
/* 6056:6132 */       spreadSheet.setColumnWidth(0, 2560);
/* 6057:6133 */       spreadSheet.setColumnWidth(1, 7680);
/* 6058:6134 */       spreadSheet.setColumnWidth(2, 6400);
/* 6059:6135 */       spreadSheet.setColumnWidth(3, 6400);
/* 6060:6136 */       spreadSheet.setColumnWidth(4, 6400);
/* 6061:6137 */       spreadSheet.setColumnWidth(5, 6400);
/* 6062:6138 */       spreadSheet.setColumnWidth(6, 6400);
/* 6063:6139 */       spreadSheet.setColumnWidth(7, 6400);
/* 6064:6140 */       spreadSheet.setColumnWidth(8, 6400);
/* 6065:6141 */       spreadSheet.setColumnWidth(9, 6400);
/* 6066:6142 */       spreadSheet.setColumnWidth(10, 6400);
/* 6067:6143 */       spreadSheet.setColumnWidth(11, 6400);
/* 6068:6144 */       spreadSheet.setColumnWidth(12, 7680);
/* 6069:6145 */       spreadSheet.setColumnWidth(13, 6400);
/* 6070:6146 */       spreadSheet.setColumnWidth(14, 6400);
/* 6071:     */       
/* 6072:     */ 
/* 6073:     */ 
/* 6074:     */ 
/* 6075:     */ 
/* 6076:     */ 
/* 6077:     */ 
/* 6078:     */ 
/* 6079:     */ 
/* 6080:     */ 
/* 6081:     */ 
/* 6082:     */ 
/* 6083:     */ 
/* 6084:     */ 
/* 6085:     */ 
/* 6086:     */ 
/* 6087:     */ 
/* 6088:     */ 
/* 6089:     */ 
/* 6090:     */ 
/* 6091:     */ 
/* 6092:     */ 
/* 6093:     */ 
/* 6094:6170 */       cell = row.createCell(0);
/* 6095:6171 */       cell.setCellValue("Sales Id");
/* 6096:6172 */       cell.setCellStyle(headerCellStyle);
/* 6097:     */       
/* 6098:6174 */       cell = row.createCell(1);
/* 6099:6175 */       cell.setCellValue("Item Total");
/* 6100:6176 */       cell.setCellStyle(headerCellStyle);
/* 6101:     */       
/* 6102:6178 */       cell = row.createCell(2);
/* 6103:6179 */       cell.setCellValue("Subtotal");
/* 6104:6180 */       cell.setCellStyle(headerCellStyle);
/* 6105:     */       
/* 6106:6182 */       cell = row.createCell(3);
/* 6107:6183 */       cell.setCellValue("Discount");
/* 6108:6184 */       cell.setCellStyle(headerCellStyle);
/* 6109:     */       
/* 6110:6186 */       cell = row.createCell(4);
/* 6111:6187 */       cell.setCellValue("Net Total");
/* 6112:6188 */       cell.setCellStyle(headerCellStyle);
/* 6113:     */       
/* 6114:6190 */       cell = row.createCell(5);
/* 6115:6191 */       cell.setCellValue("Customer Type");
/* 6116:6192 */       cell.setCellStyle(headerCellStyle);
/* 6117:     */       
/* 6118:6194 */       cell = row.createCell(6);
/* 6119:6195 */       cell.setCellValue("Sales Date");
/* 6120:6196 */       cell.setCellStyle(headerCellStyle);
/* 6121:     */       
/* 6122:6198 */       cell = row.createCell(7);
/* 6123:6199 */       cell.setCellValue("Payment");
/* 6124:6200 */       cell.setCellStyle(headerCellStyle);
/* 6125:     */       
/* 6126:6202 */       cell = row.createCell(8);
/* 6127:6203 */       cell.setCellValue("Payment Mode");
/* 6128:6204 */       cell.setCellStyle(headerCellStyle);
/* 6129:     */       
/* 6130:6206 */       cell = row.createCell(9);
/* 6131:6207 */       cell.setCellValue("Customer Refference");
/* 6132:6208 */       cell.setCellStyle(headerCellStyle);
/* 6133:     */       
/* 6134:6210 */       cell = row.createCell(10);
/* 6135:6211 */       cell.setCellValue("Customer Phone No");
/* 6136:6212 */       cell.setCellStyle(headerCellStyle);
/* 6137:     */       
/* 6138:6214 */       cell = row.createCell(11);
/* 6139:6215 */       cell.setCellValue("Customer Address");
/* 6140:6216 */       cell.setCellStyle(headerCellStyle);
/* 6141:     */       
/* 6142:6218 */       cell = row.createCell(12);
/* 6143:6219 */       cell.setCellValue("Sales Refference");
/* 6144:6220 */       cell.setCellStyle(headerCellStyle);
/* 6145:     */       
/* 6146:6222 */       cell = row.createCell(13);
/* 6147:6223 */       cell.setCellValue("Payment Answer");
/* 6148:6224 */       cell.setCellStyle(headerCellStyle);
/* 6149:     */       
/* 6150:6226 */       cell = row.createCell(14);
/* 6151:6227 */       cell.setCellValue("Tax Amount");
/* 6152:6228 */       cell.setCellStyle(headerCellStyle);
/* 6153:     */       
/* 6154:     */ 
/* 6155:     */ 
/* 6156:     */ 
/* 6157:     */ 
/* 6158:     */ 
/* 6159:     */ 
/* 6160:     */ 
/* 6161:     */ 
/* 6162:     */ 
/* 6163:     */ 
/* 6164:     */ 
/* 6165:     */ 
/* 6166:     */ 
/* 6167:     */ 
/* 6168:     */ 
/* 6169:     */ 
/* 6170:     */ 
/* 6171:     */ 
/* 6172:     */ 
/* 6173:     */ 
/* 6174:     */ 
/* 6175:     */ 
/* 6176:     */ 
/* 6177:     */ 
/* 6178:     */ 
/* 6179:     */ 
/* 6180:     */ 
/* 6181:     */ 
/* 6182:     */ 
/* 6183:     */ 
/* 6184:     */ 
/* 6185:     */ 
/* 6186:     */ 
/* 6187:     */ 
/* 6188:     */ 
/* 6189:     */ 
/* 6190:     */ 
/* 6191:     */ 
/* 6192:     */ 
/* 6193:     */ 
/* 6194:     */ 
/* 6195:     */ 
/* 6196:     */ 
/* 6197:     */ 
/* 6198:     */ 
/* 6199:     */ 
/* 6200:     */ 
/* 6201:     */ 
/* 6202:     */ 
/* 6203:     */ 
/* 6204:     */ 
/* 6205:     */ 
/* 6206:     */ 
/* 6207:     */ 
/* 6208:     */ 
/* 6209:     */ 
/* 6210:     */ 
/* 6211:     */ 
/* 6212:     */ 
/* 6213:     */ 
/* 6214:     */ 
/* 6215:     */ 
/* 6216:     */ 
/* 6217:     */ 
/* 6218:     */ 
/* 6219:     */ 
/* 6220:     */ 
/* 6221:     */ 
/* 6222:     */ 
/* 6223:     */ 
/* 6224:     */ 
/* 6225:     */ 
/* 6226:     */ 
/* 6227:     */ 
/* 6228:     */ 
/* 6229:     */ 
/* 6230:     */ 
/* 6231:     */ 
/* 6232:     */ 
/* 6233:     */ 
/* 6234:     */ 
/* 6235:     */ 
/* 6236:6312 */       List<ExcelReportDaoImpl> li = new ArrayList();
/* 6237:6313 */       while (this.resultSet.next())
/* 6238:     */       {
/* 6239:6315 */         this.daoImpl = new ExcelReportDaoImpl();
/* 6240:     */         
/* 6241:     */ 
/* 6242:6318 */         row = spreadSheet.createRow(currentRow++);
/* 6243:     */         
/* 6244:6320 */         cell = row.createCell(0);
/* 6245:6321 */         cell.setCellValue(this.resultSet.getInt("SALES_ID"));
/* 6246:6322 */         cell.setCellStyle(dataCellStyle);
/* 6247:     */         
/* 6248:6324 */         cell = row.createCell(1);
/* 6249:6325 */         cell.setCellValue(this.resultSet.getFloat("SALES_ITEM_TOTAL"));
/* 6250:6326 */         cell.setCellStyle(dataCellStyle);
/* 6251:     */         
/* 6252:6328 */         cell = row.createCell(2);
/* 6253:6329 */         cell.setCellValue(this.resultSet.getFloat("SALES_ITEM_SUBTOTAL"));
/* 6254:6330 */         cell.setCellStyle(dataCellStyle);
/* 6255:     */         
/* 6256:6332 */         cell = row.createCell(3);
/* 6257:6333 */         cell.setCellValue(this.resultSet.getFloat("SALES_ITEM_DISCOUNT"));
/* 6258:6334 */         cell.setCellStyle(dataCellStyle);
/* 6259:     */         
/* 6260:6336 */         cell = row.createCell(4);
/* 6261:6337 */         cell.setCellValue(this.resultSet.getFloat("SALES_ITEM_NET_TOTAL"));
/* 6262:6338 */         cell.setCellStyle(dataCellStyle);
/* 6263:     */         
/* 6264:6340 */         cell = row.createCell(5);
/* 6265:6341 */         cell.setCellValue(this.resultSet.getString("SALES_CUSTOMER_TYPE"));
/* 6266:6342 */         cell.setCellStyle(dataCellStyle);
/* 6267:     */         
/* 6268:6344 */         cell = row.createCell(6);
/* 6269:6345 */         cell.setCellValue(
/* 6270:6346 */           this.resultSet
/* 6271:6347 */           .getString("SALES_DATE"));
/* 6272:6348 */         cell.setCellStyle(dataCellStyle);
/* 6273:     */         
/* 6274:6350 */         cell = row.createCell(7);
/* 6275:6351 */         cell.setCellValue(this.resultSet.getFloat("SALES_PAYMENT"));
/* 6276:6352 */         cell.setCellStyle(dataCellStyle);
/* 6277:     */         
/* 6278:6354 */         cell = row.createCell(8);
/* 6279:6355 */         cell.setCellValue(this.resultSet
/* 6280:6356 */           .getString("SALES_PAYMENT_MODE"));
/* 6281:6357 */         cell.setCellStyle(dataCellStyle);
/* 6282:     */         
/* 6283:6359 */         cell = row.createCell(9);
/* 6284:6360 */         cell.setCellValue(this.resultSet.getInt("SALES_CUSTOMER_ID_REF"));
/* 6285:6361 */         cell.setCellStyle(dataCellStyle);
/* 6286:     */         
/* 6287:6363 */         cell = row.createCell(10);
/* 6288:6364 */         cell.setCellValue(this.resultSet.getString("SALES_CUSTOMER_PHONE"));
/* 6289:6365 */         cell.setCellStyle(dataCellStyle);
/* 6290:     */         
/* 6291:6367 */         cell = row.createCell(11);
/* 6292:6368 */         cell.setCellValue(this.resultSet.getString("SALES_CUSTOMER_ADREESS"));
/* 6293:6369 */         cell.setCellStyle(dataCellStyle);
/* 6294:     */         
/* 6295:6371 */         cell = row.createCell(12);
/* 6296:6372 */         cell.setCellValue(this.resultSet.getString("UNIQUE_ID"));
/* 6297:6373 */         cell.setCellStyle(dataCellStyle);
/* 6298:     */         
/* 6299:6375 */         cell = row.createCell(13);
/* 6300:6376 */         cell.setCellValue(this.resultSet
/* 6301:6377 */           .getString("SALES_PAYMENT_ANSWER"));
/* 6302:6378 */         cell.setCellStyle(dataCellStyle);
/* 6303:     */         
/* 6304:6380 */         cell = row.createCell(14);
/* 6305:6381 */         cell.setCellValue(this.resultSet.getFloat("SALES_TAX_AMOUNT"));
/* 6306:6382 */         cell.setCellStyle(dataCellStyle);
/* 6307:     */         
/* 6308:     */ 
/* 6309:     */ 
/* 6310:     */ 
/* 6311:     */ 
/* 6312:     */ 
/* 6313:     */ 
/* 6314:     */ 
/* 6315:     */ 
/* 6316:     */ 
/* 6317:     */ 
/* 6318:     */ 
/* 6319:     */ 
/* 6320:     */ 
/* 6321:     */ 
/* 6322:     */ 
/* 6323:     */ 
/* 6324:     */ 
/* 6325:     */ 
/* 6326:     */ 
/* 6327:     */ 
/* 6328:     */ 
/* 6329:     */ 
/* 6330:     */ 
/* 6331:     */ 
/* 6332:     */ 
/* 6333:     */ 
/* 6334:     */ 
/* 6335:     */ 
/* 6336:     */ 
/* 6337:     */ 
/* 6338:     */ 
/* 6339:     */ 
/* 6340:     */ 
/* 6341:     */ 
/* 6342:     */ 
/* 6343:     */ 
/* 6344:     */ 
/* 6345:     */ 
/* 6346:     */ 
/* 6347:     */ 
/* 6348:     */ 
/* 6349:     */ 
/* 6350:     */ 
/* 6351:     */ 
/* 6352:     */ 
/* 6353:     */ 
/* 6354:     */ 
/* 6355:     */ 
/* 6356:     */ 
/* 6357:     */ 
/* 6358:     */ 
/* 6359:     */ 
/* 6360:     */ 
/* 6361:     */ 
/* 6362:     */ 
/* 6363:     */ 
/* 6364:     */ 
/* 6365:     */ 
/* 6366:     */ 
/* 6367:     */ 
/* 6368:     */ 
/* 6369:     */ 
/* 6370:     */ 
/* 6371:     */ 
/* 6372:     */ 
/* 6373:     */ 
/* 6374:     */ 
/* 6375:     */ 
/* 6376:     */ 
/* 6377:     */ 
/* 6378:     */ 
/* 6379:     */ 
/* 6380:     */ 
/* 6381:     */ 
/* 6382:     */ 
/* 6383:     */ 
/* 6384:     */ 
/* 6385:     */ 
/* 6386:6462 */         li.add(this.daoImpl);
/* 6387:     */       }
/* 6388:6465 */       ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
/* 6389:6466 */       wb.write(outByteStream);
/* 6390:6467 */       byte[] outArray = outByteStream.toByteArray();
/* 6391:6468 */       response.setContentType("application/ms-excel");
/* 6392:6469 */       response.setContentLength(outArray.length);
/* 6393:6470 */       response.setHeader("Expires:", "0");
/* 6394:6471 */       response.setHeader("Content-Disposition", 
/* 6395:6472 */         "attachment; filename=SalesDetails_list.xls");
/* 6396:     */       
/* 6397:     */ 
/* 6398:6475 */       ServletOutputStream fileOut = response.getOutputStream();
/* 6399:6476 */       fileOut.write(outArray);
/* 6400:6477 */       fileOut.flush();
/* 6401:6478 */       fileOut.close();
/* 6402:     */     }
/* 6403:     */     catch (Exception e)
/* 6404:     */     {
/* 6405:6481 */       e.printStackTrace();
/* 6406:     */     }
/* 6407:     */   }
/* 6408:     */   
/* 6409:     */   public void stockDetailExcelReport(HttpServletRequest request, HttpServletResponse response)
/* 6410:     */   {
/* 6411:     */     try
/* 6412:     */     {
/* 6413:6490 */       System.out.println("try");
/* 6414:6491 */       this.connection = getConnection();
/* 6415:     */       
/* 6416:6493 */       String query = "SELECT * FROM TAB_STOCK_DETAILS ";
/* 6417:6494 */       this.preparedStatement = this.connection.prepareStatement(query);
/* 6418:     */       
/* 6419:6496 */       this.resultSet = this.preparedStatement.executeQuery();
/* 6420:6497 */       System.out.println("executeQuery");
/* 6421:6498 */       int currentRow = 1;
/* 6422:     */       
/* 6423:6500 */       Workbook wb = new HSSFWorkbook();
/* 6424:6501 */       Sheet spreadSheet = wb.createSheet("Stock Detail List");
/* 6425:     */       
/* 6426:     */ 
/* 6427:6504 */       Row row = spreadSheet.createRow(0);
/* 6428:     */       
/* 6429:     */ 
/* 6430:6507 */       CellStyle headerCellStyle = wb.createCellStyle();
/* 6431:6508 */       headerCellStyle.setFillForegroundColor((short)49);
/* 6432:6509 */       headerCellStyle.setFillPattern((short)1);
/* 6433:     */       
/* 6434:6511 */       Font setFont = wb.createFont();
/* 6435:6512 */       setFont.setFontHeightInPoints((short)11);
/* 6436:6513 */       setFont.setColor((short)8);
/* 6437:6514 */       setFont.setBoldweight((short)700);
/* 6438:6515 */       headerCellStyle.setBorderBottom((short)1);
/* 6439:6516 */       headerCellStyle.setFont(setFont);
/* 6440:     */       
/* 6441:     */ 
/* 6442:6519 */       CellStyle dataCellStyle = wb.createCellStyle();
/* 6443:6520 */       Font setDataFont = wb.createFont();
/* 6444:6521 */       setDataFont.setColor((short)8);
/* 6445:6522 */       dataCellStyle.setBorderBottom((short)0);
/* 6446:6523 */       dataCellStyle.setFont(setDataFont);
/* 6447:     */       
/* 6448:6525 */       Cell cell = null;
/* 6449:     */       
/* 6450:6527 */       spreadSheet.setColumnWidth(0, 2560);
/* 6451:6528 */       spreadSheet.setColumnWidth(1, 7680);
/* 6452:6529 */       spreadSheet.setColumnWidth(2, 6400);
/* 6453:6530 */       spreadSheet.setColumnWidth(3, 6400);
/* 6454:6531 */       spreadSheet.setColumnWidth(4, 6400);
/* 6455:6532 */       spreadSheet.setColumnWidth(5, 6400);
/* 6456:6533 */       spreadSheet.setColumnWidth(6, 6400);
/* 6457:6534 */       spreadSheet.setColumnWidth(7, 6400);
/* 6458:6535 */       spreadSheet.setColumnWidth(8, 6400);
/* 6459:6536 */       spreadSheet.setColumnWidth(9, 6400);
/* 6460:     */       
/* 6461:     */ 
/* 6462:     */ 
/* 6463:6540 */       cell = row.createCell(0);
/* 6464:6541 */       cell.setCellValue("Stock Id");
/* 6465:6542 */       cell.setCellStyle(headerCellStyle);
/* 6466:     */       
/* 6467:6544 */       cell = row.createCell(1);
/* 6468:6545 */       cell.setCellValue("Purchasing Price");
/* 6469:6546 */       cell.setCellStyle(headerCellStyle);
/* 6470:     */       
/* 6471:6548 */       cell = row.createCell(2);
/* 6472:6549 */       cell.setCellValue("Amount");
/* 6473:6550 */       cell.setCellStyle(headerCellStyle);
/* 6474:     */       
/* 6475:6552 */       cell = row.createCell(3);
/* 6476:6553 */       cell.setCellValue("No Of Bags");
/* 6477:6554 */       cell.setCellStyle(headerCellStyle);
/* 6478:     */       
/* 6479:6556 */       cell = row.createCell(4);
/* 6480:6557 */       cell.setCellValue("Bags (Ton)");
/* 6481:6558 */       cell.setCellStyle(headerCellStyle);
/* 6482:     */       
/* 6483:6560 */       cell = row.createCell(5);
/* 6484:6561 */       cell.setCellValue("Material Code");
/* 6485:6562 */       cell.setCellStyle(headerCellStyle);
/* 6486:     */       
/* 6487:6564 */       cell = row.createCell(6);
/* 6488:6565 */       cell.setCellValue("HSN Code");
/* 6489:6566 */       cell.setCellStyle(headerCellStyle);
/* 6490:     */       
/* 6491:6568 */       cell = row.createCell(7);
/* 6492:6569 */       cell.setCellValue("Unit Price");
/* 6493:6570 */       cell.setCellStyle(headerCellStyle);
/* 6494:     */       
/* 6495:6572 */       cell = row.createCell(8);
/* 6496:6573 */       cell.setCellValue("Category");
/* 6497:6574 */       cell.setCellStyle(headerCellStyle);
/* 6498:     */       
/* 6499:6576 */       cell = row.createCell(9);
/* 6500:6577 */       cell.setCellValue("Product Type");
/* 6501:6578 */       cell.setCellStyle(headerCellStyle);
/* 6502:     */       
/* 6503:     */ 
/* 6504:     */ 
/* 6505:     */ 
/* 6506:     */ 
/* 6507:     */ 
/* 6508:     */ 
/* 6509:     */ 
/* 6510:     */ 
/* 6511:6588 */       List<ExcelReportDaoImpl> li = new ArrayList();
/* 6512:6589 */       while (this.resultSet.next())
/* 6513:     */       {
/* 6514:6591 */         this.daoImpl = new ExcelReportDaoImpl();
/* 6515:     */         
/* 6516:     */ 
/* 6517:6594 */         row = spreadSheet.createRow(currentRow++);
/* 6518:     */         
/* 6519:6596 */         cell = row.createCell(0);
/* 6520:6597 */         cell.setCellValue(this.resultSet.getInt("STOCK_ID"));
/* 6521:6598 */         cell.setCellStyle(dataCellStyle);
/* 6522:     */         
/* 6523:6600 */         cell = row.createCell(1);
/* 6524:6601 */         cell.setCellValue(this.resultSet.getString("STOCK_PURCHASE_PRICE"));
/* 6525:6602 */         cell.setCellStyle(dataCellStyle);
/* 6526:     */         
/* 6527:6604 */         cell = row.createCell(2);
/* 6528:6605 */         cell.setCellValue(this.resultSet.getFloat("STOCK_AMOUNT"));
/* 6529:6606 */         cell.setCellStyle(dataCellStyle);
/* 6530:     */         
/* 6531:6608 */         cell = row.createCell(3);
/* 6532:6609 */         cell.setCellValue(this.resultSet.getFloat("STOCK_BAGS_NO"));
/* 6533:6610 */         cell.setCellStyle(dataCellStyle);
/* 6534:     */         
/* 6535:6612 */         cell = row.createCell(4);
/* 6536:6613 */         cell.setCellValue(this.resultSet.getFloat("STOCK_BAGS_TON"));
/* 6537:6614 */         cell.setCellStyle(dataCellStyle);
/* 6538:     */         
/* 6539:6616 */         cell = row.createCell(5);
/* 6540:6617 */         cell.setCellValue(this.resultSet.getFloat("STOCK_MATERIAL_CODE"));
/* 6541:6618 */         cell.setCellStyle(dataCellStyle);
/* 6542:     */         
/* 6543:6620 */         cell = row.createCell(6);
/* 6544:6621 */         cell.setCellValue(
/* 6545:6622 */           this.resultSet
/* 6546:6623 */           .getFloat("STOCK_HSN_CODE"));
/* 6547:6624 */         cell.setCellStyle(dataCellStyle);
/* 6548:     */         
/* 6549:6626 */         cell = row.createCell(7);
/* 6550:6627 */         cell.setCellValue(this.resultSet.getString("STOCK_UNIT_PRICE"));
/* 6551:6628 */         cell.setCellStyle(dataCellStyle);
/* 6552:     */         
/* 6553:6630 */         cell = row.createCell(8);
/* 6554:6631 */         cell.setCellValue(this.nameHelper.getProductCategory(this.resultSet
/* 6555:6632 */           .getInt("STOCK_CATEGORY")));
/* 6556:6633 */         cell.setCellStyle(dataCellStyle);
/* 6557:     */         
/* 6558:6635 */         cell = row.createCell(9);
/* 6559:6636 */         cell.setCellValue(this.nameHelper.getProductTypeNameByProductId(this.resultSet.getInt("STOCK_PRODUCT_TYPE")));
/* 6560:6637 */         cell.setCellStyle(dataCellStyle);
/* 6561:     */         
/* 6562:     */ 
/* 6563:     */ 
/* 6564:     */ 
/* 6565:6642 */         li.add(this.daoImpl);
/* 6566:     */       }
/* 6567:6645 */       ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
/* 6568:6646 */       wb.write(outByteStream);
/* 6569:6647 */       byte[] outArray = outByteStream.toByteArray();
/* 6570:6648 */       response.setContentType("application/ms-excel");
/* 6571:6649 */       response.setContentLength(outArray.length);
/* 6572:6650 */       response.setHeader("Expires:", "0");
/* 6573:6651 */       response.setHeader("Content-Disposition", 
/* 6574:6652 */         "attachment; filename=StockDetail_list.xls");
/* 6575:     */       
/* 6576:     */ 
/* 6577:6655 */       ServletOutputStream fileOut = response.getOutputStream();
/* 6578:6656 */       fileOut.write(outArray);
/* 6579:6657 */       fileOut.flush();
/* 6580:6658 */       fileOut.close();
/* 6581:     */     }
/* 6582:     */     catch (Exception e)
/* 6583:     */     {
/* 6584:6661 */       e.printStackTrace();
/* 6585:     */     }
/* 6586:     */   }
/* 6587:     */   
/* 6588:     */   public void retriveTransportExcelReport(HttpServletRequest request, HttpServletResponse response)
/* 6589:     */     throws Exception
/* 6590:     */   {
/* 6591:     */     try
/* 6592:     */     {
/* 6593:6672 */       System.out.println("try");
/* 6594:6673 */       this.connection = getConnection();
/* 6595:6674 */       String query = "SELECT * FROM TAB_TRANSPORT_DETAILS";
/* 6596:6675 */       this.preparedStatement = this.connection.prepareStatement(query);
/* 6597:6676 */       this.resultSet = this.preparedStatement.executeQuery();
/* 6598:6677 */       System.out.println("executeQuery");
/* 6599:6678 */       int currentRow = 1;
/* 6600:     */       
/* 6601:6680 */       Workbook wb = new HSSFWorkbook();
/* 6602:6681 */       Sheet spreadSheet = wb.createSheet("Transport List");
/* 6603:     */       
/* 6604:     */ 
/* 6605:6684 */       Row row = spreadSheet.createRow(0);
/* 6606:     */       
/* 6607:     */ 
/* 6608:6687 */       CellStyle headerCellStyle = wb.createCellStyle();
/* 6609:6688 */       headerCellStyle.setFillForegroundColor((short)49);
/* 6610:6689 */       headerCellStyle.setFillPattern((short)1);
/* 6611:     */       
/* 6612:6691 */       Font setFont = wb.createFont();
/* 6613:6692 */       setFont.setFontHeightInPoints((short)11);
/* 6614:6693 */       setFont.setColor((short)8);
/* 6615:6694 */       setFont.setBoldweight((short)700);
/* 6616:6695 */       headerCellStyle.setBorderBottom((short)1);
/* 6617:6696 */       headerCellStyle.setFont(setFont);
/* 6618:     */       
/* 6619:     */ 
/* 6620:6699 */       CellStyle dataCellStyle = wb.createCellStyle();
/* 6621:6700 */       Font setDataFont = wb.createFont();
/* 6622:6701 */       setDataFont.setColor((short)9);
/* 6623:6702 */       dataCellStyle.setBorderBottom((short)0);
/* 6624:6703 */       dataCellStyle.setFont(setDataFont);
/* 6625:     */       
/* 6626:6705 */       Cell cell = null;
/* 6627:     */       
/* 6628:6707 */       spreadSheet.setColumnWidth(0, 2560);
/* 6629:6708 */       spreadSheet.setColumnWidth(1, 7680);
/* 6630:6709 */       spreadSheet.setColumnWidth(2, 6400);
/* 6631:6710 */       spreadSheet.setColumnWidth(3, 6400);
/* 6632:6711 */       spreadSheet.setColumnWidth(4, 6400);
/* 6633:6712 */       spreadSheet.setColumnWidth(5, 6400);
/* 6634:6713 */       spreadSheet.setColumnWidth(6, 6400);
/* 6635:6714 */       spreadSheet.setColumnWidth(7, 6400);
/* 6636:6715 */       spreadSheet.setColumnWidth(8, 6400);
/* 6637:6716 */       spreadSheet.setColumnWidth(9, 6400);
/* 6638:6717 */       spreadSheet.setColumnWidth(10, 6400);
/* 6639:     */       
/* 6640:     */ 
/* 6641:     */ 
/* 6642:     */ 
/* 6643:6722 */       cell = row.createCell(0);
/* 6644:6723 */       cell.setCellValue("Transport Id");
/* 6645:6724 */       cell.setCellStyle(headerCellStyle);
/* 6646:     */       
/* 6647:6726 */       cell = row.createCell(1);
/* 6648:6727 */       cell.setCellValue("Transport Name");
/* 6649:6728 */       cell.setCellStyle(headerCellStyle);
/* 6650:     */       
/* 6651:6730 */       cell = row.createCell(2);
/* 6652:6731 */       cell.setCellValue("Transprt Address line1");
/* 6653:6732 */       cell.setCellStyle(headerCellStyle);
/* 6654:     */       
/* 6655:     */ 
/* 6656:6735 */       cell = row.createCell(3);
/* 6657:6736 */       cell.setCellValue("Truck Number");
/* 6658:6737 */       cell.setCellStyle(headerCellStyle);
/* 6659:     */       
/* 6660:6739 */       cell = row.createCell(4);
/* 6661:6740 */       cell.setCellValue("Contact Person");
/* 6662:6741 */       cell.setCellStyle(headerCellStyle);
/* 6663:     */       
/* 6664:6743 */       cell = row.createCell(5);
/* 6665:6744 */       cell.setCellValue("Alternative Contact");
/* 6666:6745 */       cell.setCellStyle(headerCellStyle);
/* 6667:     */       
/* 6668:6747 */       cell = row.createCell(6);
/* 6669:6748 */       cell.setCellValue("Transprt Address line2");
/* 6670:6749 */       cell.setCellStyle(headerCellStyle);
/* 6671:     */       
/* 6672:6751 */       cell = row.createCell(7);
/* 6673:6752 */       cell.setCellValue("Transpoter");
/* 6674:6753 */       cell.setCellStyle(headerCellStyle);
/* 6675:     */       
/* 6676:6755 */       cell = row.createCell(8);
/* 6677:6756 */       cell.setCellValue("Creation Date");
/* 6678:6757 */       cell.setCellStyle(headerCellStyle);
/* 6679:     */       
/* 6680:6759 */       cell = row.createCell(9);
/* 6681:6760 */       cell.setCellValue("Contact Number");
/* 6682:6761 */       cell.setCellStyle(headerCellStyle);
/* 6683:     */       
/* 6684:6763 */       cell = row.createCell(10);
/* 6685:6764 */       cell.setCellValue("City");
/* 6686:6765 */       cell.setCellStyle(headerCellStyle);
/* 6687:     */       
/* 6688:     */ 
/* 6689:     */ 
/* 6690:6769 */       List<ExcelReportDaoImpl> li = new ArrayList();
/* 6691:6770 */       while (this.resultSet.next())
/* 6692:     */       {
/* 6693:6772 */         this.daoImpl = new ExcelReportDaoImpl();
/* 6694:     */         
/* 6695:     */ 
/* 6696:6775 */         row = spreadSheet.createRow(currentRow++);
/* 6697:     */         
/* 6698:6777 */         cell = row.createCell(0);
/* 6699:6778 */         cell.setCellValue(this.resultSet.getInt("TRANSPORT_ID"));
/* 6700:6779 */         cell.setCellStyle(dataCellStyle);
/* 6701:6780 */         System.out.println("resultSet.getString('TRUCK_NUMBER')" + this.resultSet.getString("TRUCK_NUMBER"));
/* 6702:6781 */         cell = row.createCell(1);
/* 6703:6782 */         cell.setCellValue(this.resultSet.getString("TRANSPORT_NAME"));
/* 6704:6783 */         cell.setCellStyle(dataCellStyle);
/* 6705:     */         
/* 6706:6785 */         cell = row.createCell(2);
/* 6707:6786 */         cell.setCellValue(this.resultSet.getString("TRANSPORT_ADDRESS_LINE1"));
/* 6708:6787 */         cell.setCellStyle(dataCellStyle);
/* 6709:     */         
/* 6710:     */ 
/* 6711:     */ 
/* 6712:     */ 
/* 6713:     */ 
/* 6714:     */ 
/* 6715:     */ 
/* 6716:     */ 
/* 6717:     */ 
/* 6718:6797 */         cell = row.createCell(3);
/* 6719:6798 */         cell.setCellValue(this.resultSet.getString("TRUCK_NUMBER"));
/* 6720:6799 */         cell.setCellStyle(dataCellStyle);
/* 6721:     */         
/* 6722:6801 */         cell = row.createCell(4);
/* 6723:6802 */         cell.setCellValue(this.resultSet.getString("CONTACT_PERSON"));
/* 6724:6803 */         cell.setCellStyle(dataCellStyle);
/* 6725:     */         
/* 6726:6805 */         cell = row.createCell(5);
/* 6727:6806 */         cell.setCellValue(this.resultSet
/* 6728:6807 */           .getString("ALTERNATIVE_CONTACT"));
/* 6729:6808 */         cell.setCellStyle(dataCellStyle);
/* 6730:     */         
/* 6731:6810 */         cell = row.createCell(6);
/* 6732:6811 */         cell.setCellValue(this.resultSet
/* 6733:6812 */           .getString("TRANSPORT_ADDRESS_LINE2"));
/* 6734:6813 */         cell.setCellStyle(dataCellStyle);
/* 6735:     */         
/* 6736:6815 */         cell = row.createCell(7);
/* 6737:6816 */         cell.setCellValue(this.resultSet.getString("TRANSPORTER"));
/* 6738:6817 */         cell.setCellStyle(dataCellStyle);
/* 6739:     */         
/* 6740:6819 */         cell = row.createCell(8);
/* 6741:6820 */         cell.setCellValue(this.resultSet.getString("CREATION_DATE"));
/* 6742:6821 */         cell.setCellStyle(dataCellStyle);
/* 6743:     */         
/* 6744:6823 */         cell = row.createCell(9);
/* 6745:6824 */         cell.setCellValue(this.resultSet.getString("CONTACT_NUMBER"));
/* 6746:6825 */         cell.setCellStyle(dataCellStyle);
/* 6747:     */         
/* 6748:6827 */         cell = row.createCell(10);
/* 6749:6828 */         cell.setCellValue(this.resultSet.getString("CITY"));
/* 6750:6829 */         cell.setCellStyle(dataCellStyle);
/* 6751:     */         
/* 6752:     */ 
/* 6753:     */ 
/* 6754:     */ 
/* 6755:6834 */         li.add(this.daoImpl);
/* 6756:     */       }
/* 6757:6837 */       ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
/* 6758:6838 */       wb.write(outByteStream);
/* 6759:6839 */       byte[] outArray = outByteStream.toByteArray();
/* 6760:6840 */       response.setContentType("application/ms-excel");
/* 6761:6841 */       response.setContentLength(outArray.length);
/* 6762:6842 */       response.setHeader("Expires:", "0");
/* 6763:6843 */       response.setHeader("Content-Disposition", 
/* 6764:6844 */         "attachment; filename=Transport_list.xls");
/* 6765:     */       
/* 6766:     */ 
/* 6767:6847 */       ServletOutputStream fileOut = response.getOutputStream();
/* 6768:6848 */       fileOut.write(outArray);
/* 6769:6849 */       fileOut.flush();
/* 6770:6850 */       fileOut.close();
/* 6771:     */     }
/* 6772:     */     catch (Exception e)
/* 6773:     */     {
/* 6774:6853 */       e.printStackTrace();
/* 6775:     */     }
/* 6776:     */   }
/* 6777:     */ }


/* Location:           C:\Users\bharti\Desktop\Chouksay\lost\dao\
 * Qualified Name:     com.bst.ckt.dao.ExcelReportDaoImpl
 * JD-Core Version:    0.7.0.1
 */