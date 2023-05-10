/*    1:     */ package com.bst.ckt.dao;
import com.bst.ckt.common.OMIConstants;
/*    2:     */ 
/*    3:     */ import com.bst.ckt.common.QueryBuilder;
/*    4:     */ import com.bst.ckt.dto.Pesticides;
/*    5:     */ import com.bst.ckt.exception.CreateFailedException;
/*    6:     */ import com.bst.ckt.exception.DeleteFailedException;
/*    7:     */ import com.bst.ckt.exception.RecordNotFoundException;
/*    8:     */ import com.bst.ckt.exception.UpdateFailedException;
/*    9:     */ import com.bst.ckt.framework.db.JdbcDAOSupport;
/*   10:     */ import com.bst.ckt.framework.db.JdbcHelper;
/*   11:     */ import com.bst.ckt.framework.util.DateTimeUtil;
/*   12:     */ import com.bst.ckt.helper.NameHelper;
/*   13:     */ import com.bst.ckt.vo.PurchasePesticidesVO;
/*   14:     */ import com.itextpdf.text.BaseColor;
/*   15:     */ import com.itextpdf.text.Document;
/*   16:     */ import com.itextpdf.text.Font;
/*   17:     */ import com.itextpdf.text.Font.FontFamily;
/*   18:     */ import com.itextpdf.text.Image;
/*   19:     */ import com.itextpdf.text.PageSize;
/*   20:     */ import com.itextpdf.text.Paragraph;
/*   21:     */ import com.itextpdf.text.Phrase;
/*   22:     */ import com.itextpdf.text.Rectangle;
/*   23:     */ import com.itextpdf.text.pdf.PdfPCell;
/*   24:     */ import com.itextpdf.text.pdf.PdfPTable;
/*   25:     */ import com.itextpdf.text.pdf.PdfWriter;
/*   26:     */ import java.io.PrintStream;
/*   27:     */ import java.sql.Connection;
/*   28:     */ import java.sql.PreparedStatement;
/*   29:     */ import java.sql.ResultSet;
/*   30:     */ import java.sql.SQLException;
/*   31:     */ import java.util.ArrayList;
/*   32:     */ import java.util.List;
/*   33:     */ import javax.servlet.ServletContext;
/*   34:     */ import javax.servlet.http.HttpServletRequest;
/*   35:     */ import javax.servlet.http.HttpServletResponse;
/*   36:     */ import org.apache.log4j.Logger;
/*   37:     */ import org.apache.struts2.ServletActionContext;
/*   38:     */ 
/*   39:     */ public class PurchasePesticidesDaoImpl
/*   40:     */   extends JdbcDAOSupport
/*   41:     */   implements PurchasePesticidesDaoInf
/*   42:     */ {
/*   43:  46 */   private static final Logger logger = Logger.getLogger(PurchasePesticidesDaoImpl.class);
/*   44:  48 */   PreparedStatement preparedStatement = null;
/*   45:  49 */   Connection connection = null;
/*   46:  50 */   ResultSet resultSet = null;
/*   47:  51 */   PurchasePesticidesVO purchasePesticidesVO = null;
/*   48:  52 */   NameHelper nameHelper = new NameHelper();
/*   49:  53 */   Image image = null;
/*   50:     */   
/*   51:     */   public int addPurchasePesticides(PurchasePesticidesVO purchasePesticidesVO)
/*   52:     */     throws CreateFailedException
/*   53:     */   {
/*   54:  62 */     int output = 0;
/*   55:     */     try
/*   56:     */     {
/*   57:  66 */       this.connection = getConnection();
/*   58:     */       
/*   59:  68 */       String insert = "INSERT INTO TAB_PURCHASE_PESTICIDES_DETAIL(PUR_PESTICIDE_COMPANY_NAME, PUR_PESTICIDE_PRICE, PUR_PESTICIDE_AMOUNT,PUR_PESTICIDE_GST, PUR_PESTICIDE_CGST, PUR_PESTICIDE_SGST, PUR_PESTICIDE_DEALER_NAME, PUR_PESTICIDE_DEALER_CONTACT, PUR_PESTICIDE_DEALER_ADDRESS, PUR_PESTICIDE_DEALER_REF, PUR_PESTICIDE_QUANTITY, PUR_PESTICIDE_BAGS_TON, PUR_PESTICIDE_GST_AMOUNT, PUR_PESTICIDE_CGST_AMOUNT, PUR_PESTICIDE_SGST_AMOUNT, PUR_PESTICIDE_INVOICE_NO, PUR_PESTICIDE_ORDER_NO, PUR_PESTICIDE_CARRIER_NAME, PUR_PESTICIDE_PAYMENT_MODE, PUR_PESTICIDE_WEEK_NO, PUR_PESTICIDE_INCOTERM, PUR_PESTICIDE_PAYMENT,PUR_PESTICIDE_INVOICE_DATE, PUR_PESTICIDE_MATERIAL_CODE, PUR_PESTICIDE_HSN_CODE, PUR_PESTICIDE_DELIVERY_PLACE, PUR_PESTICIDE_UNIT_PRICE, PUR_PESTICIDE_DISCOUNT)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
/*   60:     */       
/*   61:     */ float total=purchasePesticidesVO.getUnitPrice()*purchasePesticidesVO.getQuantity();
float cal =(100+purchasePesticidesVO.getGst())/100;
/*   64:     */ float gstAmount=total*cal;
float diff=gstAmount-total;
/*   62:     */ 
/*   63:     */ 
/*   64:     */ 
/*   65:  74 */       this.preparedStatement = this.connection
/*   66:  75 */         .prepareStatement(insert);
/*   67:     */       
/*   68:  77 */       this.preparedStatement.setString(1, purchasePesticidesVO.getCompanyName());
/*   69:  78 */       this.preparedStatement.setFloat(2, purchasePesticidesVO.getUnitPrice());
/*   70:  79 */       this.preparedStatement.setFloat(3, purchasePesticidesVO.getNetAmount());
/*   71:  80 */       this.preparedStatement.setFloat(4, purchasePesticidesVO.getGst());
/*   72:  81 */       this.preparedStatement.setFloat(5, purchasePesticidesVO.getCgst());
/*   73:  82 */       this.preparedStatement.setFloat(6, purchasePesticidesVO.getSgst());
/*   74:  83 */       System.out.println(purchasePesticidesVO.getDealerName() + "LLLLLLLLLLLddddddddd");
/*   75:  84 */       this.preparedStatement.setString(7, this.nameHelper.getDealerNameById(Integer.parseInt(purchasePesticidesVO.getDealerName())));
/*   76:  85 */       this.preparedStatement.setString(8, purchasePesticidesVO.getDealerContact());
/*   77:  86 */       this.preparedStatement.setString(9, purchasePesticidesVO.getDealerAddress());
/*   78:  87 */       this.preparedStatement.setString(10, purchasePesticidesVO.getDealerName());
/*   79:  88 */       this.preparedStatement.setInt(11, purchasePesticidesVO.getQuantity());
/*   80:  89 */       this.preparedStatement.setFloat(12, purchasePesticidesVO.getQuantity());
/*   81:  90 */       this.preparedStatement.setFloat(13, diff);
/*   82:  91 */       this.preparedStatement.setFloat(14, purchasePesticidesVO.getCgstAmount());
/*   83:  92 */       this.preparedStatement.setFloat(15, purchasePesticidesVO.getSgstAmount());
/*   84:  93 */       this.preparedStatement.setString(16, purchasePesticidesVO.getInvoiceNo());
/*   85:  94 */       this.preparedStatement.setString(17, purchasePesticidesVO.getOrderNo());
/*   86:  95 */       this.preparedStatement.setString(18, purchasePesticidesVO.getTransporter());
/*   87:  96 */       this.preparedStatement.setString(19, purchasePesticidesVO.getPaymentMode());
/*   88:  97 */       this.preparedStatement.setString(20, purchasePesticidesVO.getWeekNo());
/*   89:  98 */       this.preparedStatement.setString(21, purchasePesticidesVO.getInconterm());
/*   90:  99 */       this.preparedStatement.setFloat(22, purchasePesticidesVO.getPayment());
/*   91: 100 */       this.preparedStatement.setString(23, DateTimeUtil.convertToDate(purchasePesticidesVO.getInvoiceDate()));
/*   92:     */       
/*   93: 102 */       this.preparedStatement.setString(24, purchasePesticidesVO.getMaterialCode());
/*   94: 103 */       this.preparedStatement.setString(25, purchasePesticidesVO.getHsnCode());
/*   95: 104 */       this.preparedStatement.setString(26, purchasePesticidesVO.getDeliveryPlace());
/*   96: 105 */       this.preparedStatement.setFloat(27, purchasePesticidesVO.getUnitPrice());
/*   97: 106 */       this.preparedStatement.setFloat(28, purchasePesticidesVO.getDiscount());
/*   98:     */       
/*   99:     */ 
/*  100: 109 */       output = this.preparedStatement.executeUpdate();
/*  101: 111 */       if (output == 1) {
/*  102: 112 */         insertIntoDealerTansaction(purchasePesticidesVO);
/*  103:     */       }
/*  104:     */     }
/*  105:     */     catch (SQLException sqlException)
/*  106:     */     {
/*  107: 115 */       sqlException.printStackTrace();
/*  108: 116 */       logger.error(
/*  109: 117 */         PurchasePesticidesDaoImpl.class + 
/*  110: 118 */         ": Error:- Error: Occur in Query While inserting the Purchased pesticides details into Database", 
/*  111: 119 */         sqlException);
/*  112:     */     }
/*  113:     */     catch (Exception exception)
/*  114:     */     {
/*  115: 122 */       exception.printStackTrace();
/*  116: 123 */       logger.error(
/*  117: 124 */         PurchasePesticidesDaoImpl.class + 
/*  118: 125 */         ": Error:- While closing the Connection after inserting the Purchased pesticides into Database", 
/*  119: 126 */         exception);
/*  120:     */     }
/*  121:     */     finally
/*  122:     */     {
/*  123: 129 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/*  124: 130 */       JdbcHelper.closeConnection(this.connection);
/*  125:     */     }
/*  126: 133 */     return output;
/*  127:     */   }
/*  128:     */   
/*  129:     */   public List<PurchasePesticidesVO> getPurchasePesticidesDetails()
/*  130:     */     throws RecordNotFoundException
/*  131:     */   {
/*  132: 150 */     List<PurchasePesticidesVO> purchasePesticidesDetailList = new ArrayList();
/*  133:     */     try
/*  134:     */     {
/*  135: 154 */       this.connection = getConnection();
/*  136:     */       
/*  137:     */ 
/*  138:     */ 
/*  139:     */ 
/*  140: 159 */       this.preparedStatement = this.connection.prepareStatement("SELECT * FROM TAB_PURCHASE_PESTICIDES_DETAIL");
/*  141:     */       
/*  142:     */ 
/*  143: 162 */       this.resultSet = this.preparedStatement.executeQuery();
/*  144: 166 */       while (this.resultSet.next())
/*  145:     */       {
/*  146: 167 */         this.purchasePesticidesVO = new PurchasePesticidesVO();
/*  147: 168 */         this.purchasePesticidesVO.setPurchaseId(this.resultSet.getInt("PUR_PESTICIDE_ID"));
/*  148:     */         
/*  149: 170 */         this.purchasePesticidesVO.setDealerName(this.nameHelper.getDealerNameById(this.resultSet.getInt("PUR_PESTICIDE_DEALER_REF")));
/*  150: 171 */         this.purchasePesticidesVO.setDealerContact(this.resultSet.getString("PUR_PESTICIDE_DEALER_CONTACT"));
/*  151:     */         
/*  152: 173 */         this.purchasePesticidesVO.setCompanyName(this.resultSet.getString("PUR_PESTICIDE_COMPANY_NAME"));
/*  153:     */         
/*  154: 175 */         this.purchasePesticidesVO.setQuantity(this.resultSet
/*  155: 176 */           .getInt("PUR_PESTICIDE_QUANTITY"));
/*  156:     */         
/*  157: 178 */         this.purchasePesticidesVO.setInvoiceNo(this.resultSet
/*  158: 179 */           .getString("PUR_PESTICIDE_INVOICE_NO"));
/*  159:     */         
/*  160:     */ 
/*  161: 182 */         this.purchasePesticidesVO.setOrderNo(this.resultSet
/*  162: 183 */           .getString("PUR_PESTICIDE_ORDER_NO"));
/*  163:     */         
/*  164: 185 */         this.purchasePesticidesVO.setTransporter(this.resultSet
/*  165: 186 */           .getString("PUR_PESTICIDE_CARRIER_NAME"));
/*  166:     */         
/*  167: 188 */         this.purchasePesticidesVO.setInvoiceDate(this.resultSet
/*  168: 189 */           .getString("PUR_PESTICIDE_INVOICE_DATE"));
/*  169:     */         
/*  170: 191 */         this.purchasePesticidesVO.setMaterialCode(this.resultSet
/*  171: 192 */           .getString("PUR_PESTICIDE_MATERIAL_CODE"));
/*  172:     */         
/*  173:     */ 
/*  174: 195 */         this.purchasePesticidesVO.setUnitPrice(this.resultSet
/*  175: 196 */           .getFloat("PUR_PESTICIDE_UNIT_PRICE"));
/*  176: 197 */         this.purchasePesticidesVO.setNetAmount(this.resultSet
/*  177: 198 */           .getFloat("PUR_PESTICIDE_AMOUNT"));
/*  178: 199 */         this.purchasePesticidesVO.setGst(this.resultSet
/*  179: 200 */           .getFloat("PUR_PESTICIDE_GST"));
/*  180:     */         
/*  181: 202 */         System.out.println(this.purchasePesticidesVO.getCompanyName() + "yyyyyyyyyyyyyyyyy" + this.purchasePesticidesVO.getPurchaseId());
/*  182:     */         
/*  183:     */ 
/*  184:     */ 
/*  185:     */ 
/*  186: 207 */         purchasePesticidesDetailList.add(this.purchasePesticidesVO);
/*  187:     */       }
/*  188:     */     }
/*  189:     */     catch (SQLException sqlExp)
/*  190:     */     {
/*  191: 211 */       sqlExp.printStackTrace();
/*  192: 212 */       logger.error(
/*  193: 213 */         PurchasePesticidesDaoImpl.class + 
/*  194: 214 */         "Error: Occur in Query While Fetching the pesticides purchase Details into Grid from Database.", 
/*  195: 215 */         sqlExp);
/*  196:     */     }
/*  197:     */     catch (Exception exception)
/*  198:     */     {
/*  199: 217 */       exception.printStackTrace();
/*  200: 218 */       logger.error(
/*  201: 219 */         PurchasePesticidesDaoImpl.class + 
/*  202: 220 */         "Error: Occur in Query While Closing Connection After Fetching the pesticides purchase into Grid from Database.", 
/*  203: 221 */         exception);
/*  204:     */     }
/*  205:     */     finally
/*  206:     */     {
/*  207: 223 */       JdbcHelper.closeResultSet(this.resultSet);
/*  208: 224 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/*  209: 225 */       JdbcHelper.closeConnection(this.connection);
/*  210:     */     }
/*  211: 227 */     return purchasePesticidesDetailList;
/*  212:     */   }
/*  213:     */   
/*  214:     */   public void insertStockDetails(PurchasePesticidesVO purchasePesticidesVO)
/*  215:     */   {
/*  216:     */     try
/*  217:     */     {
/*  218: 262 */       this.connection = getConnection();
/*  219: 263 */       String insert = "INSERT INTO TAB_STOCK_DETAILS(STOCK_PURCHASE_PRICE, STOCK_AMOUNT, STOCK_BAGS_NO, STOCK_BAGS_TON,STOCK_MATERIAL_CODE,STOCK_HSN_CODE,STOCK_UNIT_PRICE,STOCK_CATEGORY, STOCK_PRODUCT_TYPE, STOCK_BILLED_OWNER)VALUES(?,?,?,?,?,?,?,?,?,?)";
/*  220:     */       
/*  221: 265 */       this.preparedStatement = this.connection
/*  222: 266 */         .prepareStatement(insert);
/*  223:     */       
/*  224: 268 */       this.preparedStatement.setFloat(1, purchasePesticidesVO.getUnitPrice());
/*  225: 269 */       this.preparedStatement.setFloat(2, purchasePesticidesVO.getNetAmount());
/*  226: 270 */       this.preparedStatement.setFloat(3, purchasePesticidesVO.getQuantity());
/*  227: 271 */       this.preparedStatement.setFloat(4, purchasePesticidesVO.getQuantity());
/*  228: 272 */       this.preparedStatement.setString(5, purchasePesticidesVO.getMaterialCode());
/*  229: 273 */       this.preparedStatement.setString(6, purchasePesticidesVO.getHsnCode());
/*  230:     */       
/*  231: 275 */       this.preparedStatement.setFloat(7, purchasePesticidesVO.getUnitPrice());
/*  232: 276 */       this.preparedStatement.setInt(8, this.nameHelper.getProductCategoryIdByProductType(Integer.parseInt(purchasePesticidesVO.getInconterm())));
/*  233: 277 */       this.preparedStatement.setString(9, purchasePesticidesVO.getInconterm());
/*  234:     */       this.preparedStatement.setInt(10, OMIConstants.CHOUKSAY_BROTHERS);
/*  235:     */ 
/*  236: 280 */       this.preparedStatement.executeUpdate();
/*  237:     */     }
/*  238:     */     catch (SQLException sqlException)
/*  239:     */     {
/*  240: 283 */       sqlException.printStackTrace();
/*  241: 284 */       logger.error(
/*  242: 285 */         PurchasePesticidesDaoImpl.class + 
/*  243: 286 */         ": Error:- Error: Occur in Query While inserting the stock details into Database", 
/*  244: 287 */         sqlException);
/*  245:     */     }
/*  246:     */     catch (Exception exception)
/*  247:     */     {
/*  248: 290 */       exception.printStackTrace();
/*  249: 291 */       logger.error(
/*  250: 292 */         PurchasePesticidesDaoImpl.class + 
/*  251: 293 */         ": Error:- While closing the Connection after inserting the  stock details into Database", 
/*  252: 294 */         exception);
/*  253:     */     }
/*  254:     */     finally
/*  255:     */     {
/*  256: 297 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/*  257: 298 */       JdbcHelper.closeConnection(this.connection);
/*  258:     */     }
/*  259:     */   }
/*  260:     */   
/*  261:     */   public void insertIntoDealerTansaction(PurchasePesticidesVO purchasePesticidesVO)
/*  262:     */   {
/*  263: 310 */     if (purchasePesticidesVO.getPayment() >= 0.0F)
/*  264:     */     {
/*  265: 312 */       Connection con = null;
/*  266:     */       
/*  267: 314 */       PreparedStatement ps = null;
/*  268:     */       
/*  269: 316 */       float totalDue = getDueOfCurrentDealer(purchasePesticidesVO.getDealerName());
/*  270:     */       try
/*  271:     */       {
/*  272: 320 */         float paid = purchasePesticidesVO.getPayment();
/*  273: 321 */         float due = purchasePesticidesVO.getNetAmount() - purchasePesticidesVO.getPayment();
/*  274:     */         
/*  275: 323 */         con = getConnection();
/*  276: 324 */         String danger_query = "INSERT INTO TAB_DEALER_OWNER_TRANSACTION (DEALER_TRANS_DISCRIPTION, DEALER_TRANS_BILL_NO,DEALER_TANS_PAYMENT_MODE,DEALER_TRANS_DATE,DEALER_TRANS_TOTAL,DEALER_TRANS_PAID ,DEALER_TRANS_DUE,DEALER_ID_REF, DEALER_TRANS_TOTAL_DUE,SHOP_ID,  DEALER_TRANS_TOTAL_PAID)SELECT ?,?,?,?,?,?,?,?,?,?,SUM(TAB_DEALER_OWNER_TRANSACTION.DEALER_TRANS_PAID)+" + 
/*  277: 325 */           paid + " FROM TAB_DEALER_OWNER_TRANSACTION WHERE DEALER_ID_REF=" + 
/*  278: 326 */           purchasePesticidesVO.getDealerName();
/*  279: 327 */         ps = con.prepareStatement(danger_query);
/*  280:     */         
/*  281: 329 */         ps.setString(1, "ON PURCHASE");
/*  282: 330 */         ps.setString(2, purchasePesticidesVO.getInvoiceNo());
/*  283: 331 */         ps.setString(3, purchasePesticidesVO.getPaymentMode());
/*  284:     */         
/*  285: 333 */         ps.setString(4, DateTimeUtil.convertToDate(purchasePesticidesVO.getInvoiceDate()));
/*  286: 334 */         ps.setFloat(5, purchasePesticidesVO.getNetAmount());
/*  287: 335 */         ps.setFloat(6, purchasePesticidesVO.getPayment());
/*  288: 336 */         ps.setFloat(7, due);
/*  289: 337 */         ps.setString(8, purchasePesticidesVO.getDealerName());
/*  290: 338 */         ps.setFloat(9, totalDue + due);
/*  291: 339 */         ps.setInt(10, purchasePesticidesVO.getAclId());
/*  292:     */         
/*  293: 341 */         ps.executeUpdate();
/*  294:     */       }
/*  295:     */       catch (SQLException sqlException)
/*  296:     */       {
/*  297: 345 */         logger.error(PurchasePesticidesDaoImpl.class + "ERROR: While inserting the pesticide transaction details into the database", sqlException);
/*  298:     */         
/*  299: 347 */         sqlException.printStackTrace();
/*  300:     */       }
/*  301:     */       catch (Exception exception)
/*  302:     */       {
/*  303: 351 */         logger.error(
/*  304: 352 */           PurchasePesticidesDaoImpl.class + "ERROR: While inserting the pesticide transaction details into the database", 
/*  305: 353 */           exception);
/*  306:     */         
/*  307: 355 */         exception.printStackTrace();
/*  308:     */       }
/*  309:     */       finally
/*  310:     */       {
/*  311: 358 */         JdbcHelper.closePreparedStatement(ps);
/*  312: 359 */         JdbcHelper.closeConnection(con);
/*  313:     */       }
/*  314:     */     }
/*  315:     */   }
/*  316:     */   
/*  317:     */   public float getDueOfCurrentDealer(String dealerId)
/*  318:     */   {
/*  319: 367 */     float tot_due = 0.0F;
/*  320: 368 */     Connection con = null;
/*  321: 369 */     PreparedStatement prst = null;
/*  322: 370 */     ResultSet result = null;
/*  323:     */     try
/*  324:     */     {
/*  325: 376 */       con = getConnection();
/*  326: 377 */       String query = "SELECT DEALER_TRANS_TOTAL_DUE FROM TAB_DEALER_OWNER_TRANSACTION WHERE DEALER_ID_REF=? ORDER BY DEALER_TRANS_ID DESC LIMIT 1";
/*  327:     */       
/*  328:     */ 
/*  329:     */ 
/*  330: 381 */       prst = con.prepareStatement(query);
/*  331:     */       
/*  332: 383 */       prst.setString(1, dealerId);
/*  333: 384 */       result = prst.executeQuery();
/*  334: 385 */       while (result.next())
/*  335:     */       {
/*  336: 386 */         tot_due = result.getFloat("DEALER_TRANS_TOTAL_DUE");
/*  337:     */         
/*  338: 388 */         System.out.println(result.getFloat("DEALER_TRANS_TOTAL_DUE") + "FETCHED iDkkjjjjjjjjjjjjjjjjjjjjjjjjjj");
/*  339: 389 */         System.out.println(result.getFloat("DEALER_TRANS_TOTAL_DUE") + "FETCHED iDnnjjjjjjjjjjjjjjjjjjjjjjjjjjname name");
/*  340:     */       }
/*  341:     */     }
/*  342:     */     catch (Exception excep)
/*  343:     */     {
/*  344: 393 */       logger.error(
/*  345: 394 */         PurchaseCementDaoImpl.class + "ERROR: while fetching the record from the Purchase  table", 
/*  346: 395 */         excep);
/*  347:     */       
/*  348: 397 */       excep.printStackTrace();
/*  349:     */     }
/*  350:     */     finally
/*  351:     */     {
/*  352: 400 */       JdbcHelper.closeResultSet(result);
/*  353: 401 */       JdbcHelper.closePreparedStatement(prst);
/*  354: 402 */       JdbcHelper.closeConnection(con);
/*  355:     */     }
/*  356: 404 */     return tot_due;
/*  357:     */   }
/*  358:     */   
/*  359:     */   public int isItemAlreadyExistInStock(String inconterm)
/*  360:     */     throws RecordNotFoundException
/*  361:     */   {
/*  362: 427 */     int existence = 0;
/*  363:     */     try
/*  364:     */     {
/*  365: 429 */       this.connection = getConnection();
/*  366:     */       
/*  367: 431 */       this.preparedStatement = this.connection
/*  368: 432 */         .prepareStatement("SELECT  STOCK_BAGS_NO FROM TAB_STOCK_DETAILS WHERE STOCK_PRODUCT_TYPE=?");
/*  369: 433 */       this.preparedStatement.setString(1, inconterm);
/*  370:     */       
/*  371:     */ 
/*  372: 436 */       this.resultSet = this.preparedStatement.executeQuery();
/*  373: 438 */       if (this.resultSet != null) {
/*  374: 439 */         while (this.resultSet.next()) {
/*  375: 441 */           existence = this.resultSet.getInt("STOCK_BAGS_NO");
/*  376:     */         }
/*  377:     */       }
/*  378:     */     }
/*  379:     */     catch (SQLException sqlExp)
/*  380:     */     {
/*  381: 448 */       sqlExp.printStackTrace();
/*  382: 449 */       logger.error(
/*  383: 450 */         PurchasePesticidesDaoImpl.class + 
/*  384: 451 */         "Error: Occur in Query While Fetching the stock Details from Database.", 
/*  385: 452 */         sqlExp);
/*  386:     */     }
/*  387:     */     catch (Exception exception)
/*  388:     */     {
/*  389: 454 */       exception.printStackTrace();
/*  390: 455 */       logger.error(
/*  391: 456 */         PurchasePesticidesDaoImpl.class + 
/*  392: 457 */         "Error: Occur in Query While Closing Connection After Fetching the stock Details from Database.", 
/*  393: 458 */         exception);
/*  394:     */     }
/*  395:     */     finally
/*  396:     */     {
/*  397: 460 */       JdbcHelper.closeResultSet(this.resultSet);
/*  398: 461 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/*  399: 462 */       JdbcHelper.closeConnection(this.connection);
/*  400:     */     }
/*  401: 464 */     return existence;
/*  402:     */   }
/*  403:     */   
/*  404:     */   public void updateStockDetails(PurchasePesticidesVO purchasePesticidesVO, int quantity)
/*  405:     */     throws UpdateFailedException
/*  406:     */   {
/*  407: 472 */     Connection connection = null;
/*  408: 473 */     PreparedStatement preparedStatement = null;
/*  409: 474 */     System.out.println("update is running************************" + purchasePesticidesVO.getUnitPrice());
/*  410:     */     try
/*  411:     */     {
/*  412: 478 */       String up = "UPDATE TAB_STOCK_DETAILS SET  STOCK_PURCHASE_PRICE=?, STOCK_AMOUNT=?, STOCK_BAGS_NO=?, STOCK_BAGS_TON=?,STOCK_MATERIAL_CODE=?, STOCK_HSN_CODE=?, STOCK_UNIT_PRICE=?, STOCK_CATEGORY=? WHERE STOCK_PRODUCT_TYPE=?";
/*  413:     */       
/*  414: 480 */       System.out.println("fffffffffffffffffffffF" + quantity);
/*  415:     */       
/*  416: 482 */       connection = getConnection();
/*  417: 483 */       preparedStatement = connection
/*  418: 484 */         .prepareStatement(up);
/*  419: 485 */       preparedStatement.setFloat(1, purchasePesticidesVO.getUnitPrice());
/*  420: 486 */       preparedStatement.setFloat(2, purchasePesticidesVO.getNetAmount());
/*  421: 487 */       preparedStatement.setFloat(3, purchasePesticidesVO.getQuantity() + quantity);
/*  422: 488 */       preparedStatement.setFloat(4, purchasePesticidesVO.getQuantity());
/*  423: 489 */       preparedStatement.setString(5, purchasePesticidesVO.getMaterialCode());
/*  424: 490 */       preparedStatement.setString(6, purchasePesticidesVO.getHsnCode());
/*  425: 491 */       System.out.println(this.nameHelper.getProductCategoryIdByProductType(Integer.parseInt(purchasePesticidesVO.getInconterm())) + ")))))))))))))");
/*  426: 492 */       preparedStatement.setFloat(7, purchasePesticidesVO.getUnitPrice());
/*  427: 493 */       preparedStatement.setInt(8, this.nameHelper.getProductCategoryIdByProductType(Integer.parseInt(purchasePesticidesVO.getInconterm())));
/*  428: 494 */       preparedStatement.setString(9, purchasePesticidesVO.getInconterm());
/*  429:     */       
/*  430: 496 */       preparedStatement.executeUpdate();
/*  431:     */     }
/*  432:     */     catch (SQLException sqlExp)
/*  433:     */     {
/*  434: 499 */       sqlExp.printStackTrace();
/*  435: 500 */       logger.error(
/*  436: 501 */         PurchasePesticidesDaoImpl.class + 
/*  437: 502 */         "Error: Occur in Query While updating the specific pesticides purchase stock Details.", 
/*  438: 503 */         sqlExp);
/*  439:     */     }
/*  440:     */     catch (Exception exception)
/*  441:     */     {
/*  442: 505 */       exception.printStackTrace();
/*  443: 506 */       logger.error(
/*  444: 507 */         PurchasePesticidesDaoImpl.class + 
/*  445: 508 */         "Error: Occur in Query While Closing Connection After updating the specific pesticides stock purchase Details.", 
/*  446: 509 */         exception);
/*  447:     */     }
/*  448:     */     finally
/*  449:     */     {
/*  450: 511 */       JdbcHelper.closeResultSet(this.resultSet);
/*  451: 512 */       JdbcHelper.closePreparedStatement(preparedStatement);
/*  452: 513 */       JdbcHelper.closeConnection(connection);
/*  453:     */     }
/*  454:     */   }
/*  455:     */   
/*  456:     */   public Pesticides retriveSpecificPurchaseDetailForUpdate(int purchaseId)
/*  457:     */     throws RecordNotFoundException
/*  458:     */   {
/*  459: 538 */     Pesticides pesticides = new Pesticides();
/*  460: 539 */     PreparedStatement preparedStatements = null;
/*  461:     */     try
/*  462:     */     {
/*  463: 541 */       this.connection = getConnection();
/*  464:     */       
/*  465: 543 */       preparedStatements = this.connection
/*  466: 544 */         .prepareStatement("SELECT * FROM TAB_PURCHASE_PESTICIDES_DETAIL WHERE PUR_PESTICIDE_ID=?");
/*  467: 545 */       preparedStatements.setInt(1, purchaseId);
/*  468:     */       
/*  469:     */ 
/*  470:     */ 
/*  471: 549 */       this.resultSet = preparedStatements.executeQuery();
/*  472: 550 */       System.out.println("----------hye ----------------");
/*  473: 551 */       if (this.resultSet != null) {
/*  474: 552 */         while (this.resultSet.next())
/*  475:     */         {
/*  476: 554 */           System.out.println("----------hye ----------------");
/*  477:     */           
/*  478: 556 */           pesticides.setPurchaseId(this.resultSet.getInt("PUR_PESTICIDE_ID"));
/*  479: 557 */           System.out.println("________________" + this.resultSet.getInt("PUR_PESTICIDE_ID"));
/*  480:     */           
/*  481: 559 */           pesticides.setUnitPrice(this.resultSet.getFloat("PUR_PESTICIDE_PRICE"));
/*  482: 560 */           System.out.println("---------" + this.resultSet.getFloat("PUR_PESTICIDE_AMOUNT"));
/*  483:     */           
/*  484:     */ 
/*  485: 563 */           pesticides.setCompanyName(this.resultSet.getString("PUR_PESTICIDE_COMPANY_NAME"));
/*  486:     */           
/*  487: 565 */           pesticides.setDealerName(this.resultSet.getString("PUR_PESTICIDE_DEALER_REF"));
/*  488:     */           
/*  489:     */ 
/*  490:     */ 
/*  491: 569 */           pesticides.setGst(this.resultSet.getFloat("PUR_PESTICIDE_GST"));
/*  492:     */           
/*  493:     */ 
/*  494: 572 */           pesticides.setCgst(this.resultSet
/*  495: 573 */             .getFloat("PUR_PESTICIDE_CGST"));
/*  496:     */           
/*  497: 575 */           pesticides.setSgst(this.resultSet
/*  498: 576 */             .getFloat("PUR_PESTICIDE_SGST"));
/*  499:     */           
/*  500: 578 */           pesticides.setdFullName(this.resultSet
/*  501: 579 */             .getString("PUR_PESTICIDE_DEALER_NAME"));
/*  502:     */           
/*  503: 581 */           pesticides.setDealerContact(this.resultSet
/*  504: 582 */             .getString("PUR_PESTICIDE_DEALER_CONTACT"));
/*  505:     */           
/*  506: 584 */           pesticides.setDealerAddress(this.resultSet
/*  507: 585 */             .getString("PUR_PESTICIDE_DEALER_ADDRESS"));
/*  508:     */           
/*  509: 587 */           pesticides.setDealerRef(this.resultSet.getInt("PUR_PESTICIDE_DEALER_REF"));
/*  510:     */           
/*  511: 589 */           pesticides.setQuantity(this.resultSet.getInt("PUR_PESTICIDE_QUANTITY"));
/*  512:     */           
/*  513: 591 */           pesticides.setQuantity(this.resultSet.getInt("PUR_PESTICIDE_BAGS_TON"));
/*  514:     */           
/*  515: 593 */           pesticides.setGstAmount(this.resultSet.getFloat("PUR_PESTICIDE_GST_AMOUNT"));
/*  516:     */           
/*  517: 595 */           pesticides.setCgstAmount(this.resultSet
/*  518: 596 */             .getFloat("PUR_PESTICIDE_CGST_AMOUNT"));
/*  519:     */           
/*  520: 598 */           pesticides.setSgstAmount(this.resultSet
/*  521: 599 */             .getFloat("PUR_PESTICIDE_SGST_AMOUNT"));
/*  522:     */           
/*  523:     */ 
/*  524:     */ 
/*  525: 603 */           pesticides.setInvoiceNo(this.resultSet
/*  526: 604 */             .getString("PUR_PESTICIDE_INVOICE_NO"));
/*  527: 605 */           pesticides.setOrderNo(this.resultSet
/*  528: 606 */             .getString("PUR_PESTICIDE_ORDER_NO"));
/*  529: 607 */           pesticides.setTransporter(this.resultSet
/*  530: 608 */             .getString("PUR_PESTICIDE_CARRIER_NAME"));
/*  531: 609 */           pesticides.setPaymentMode(this.resultSet
/*  532: 610 */             .getString("PUR_PESTICIDE_PAYMENT_MODE"));
/*  533: 611 */           pesticides.setWeekNo(this.resultSet
/*  534: 612 */             .getString("PUR_PESTICIDE_WEEK_NO"));
/*  535: 613 */           pesticides.setInconterm(this.resultSet
/*  536: 614 */             .getString("PUR_PESTICIDE_INCOTERM"));
/*  537: 615 */           pesticides.setPayment(this.resultSet
/*  538: 616 */             .getFloat("PUR_PESTICIDE_PAYMENT"));
/*  539: 617 */           System.out.println(this.resultSet.getDate("PUR_PESTICIDE_INVOICE_DATE") + "KKKKKKKKKKKKKKKKKKKKKK" + this.resultSet
/*  540: 618 */             .getFloat("PUR_PESTICIDE_PAYMENT"));
/*  541: 619 */           pesticides.setInvoiceDate(DateTimeUtil.convertDatetoFormDate(this.resultSet.getString("PUR_PESTICIDE_INVOICE_DATE")));
/*  542:     */           
/*  543: 621 */           pesticides.setMaterialCode(this.resultSet
/*  544: 622 */             .getString("PUR_PESTICIDE_MATERIAL_CODE"));
/*  545: 623 */           pesticides.setHsnCode(this.resultSet
/*  546: 624 */             .getString("PUR_PESTICIDE_HSN_CODE"));
/*  547: 625 */           pesticides.setDeliveryPlace(this.resultSet
/*  548: 626 */             .getString("PUR_PESTICIDE_DELIVERY_PLACE"));
/*  549: 627 */           pesticides.setUnitPrice(this.resultSet
/*  550: 628 */             .getFloat("PUR_PESTICIDE_UNIT_PRICE"));
/*  551:     */           
/*  552: 630 */           pesticides.setDiscount(this.resultSet
/*  553: 631 */             .getFloat("PUR_PESTICIDE_DISCOUNT"));
/*  554:     */           
/*  555: 633 */           pesticides.setNetAmount(this.resultSet
/*  556: 634 */             .getFloat("PUR_PESTICIDE_AMOUNT"));
/*  557:     */           
/*  558: 636 */           System.out.println("BHARTI" + this.resultSet.getFloat("PUR_PESTICIDE_GST") + this.resultSet.getInt("PUR_PESTICIDE_AMOUNT") + this.resultSet.getString("PUR_PESTICIDE_AMOUNT") + "%%%%%%%%%%%%%%%");
/*  559:     */         }
/*  560:     */       }
/*  561: 644 */       pesticides = retriveSpecificDealerTransactionForUpdate(pesticides);
/*  562: 645 */       System.out.println(pesticides.getTotal() + "total" + pesticides.getTransactionId() + "bill NoGGGGGggggg");
/*  563:     */     }
/*  564:     */     catch (SQLException sqlExp)
/*  565:     */     {
/*  566: 647 */       sqlExp.printStackTrace();
/*  567: 648 */       logger.error(
/*  568: 649 */         PurchasePesticidesDaoImpl.class + 
/*  569: 650 */         "Error: Occur in Query While Fetching the specific pesticides purchase Details from Database For Update.", 
/*  570: 651 */         sqlExp);
/*  571:     */     }
/*  572:     */     catch (Exception exception)
/*  573:     */     {
/*  574: 653 */       exception.printStackTrace();
/*  575: 654 */       logger.error(
/*  576: 655 */         PurchasePesticidesDaoImpl.class + 
/*  577: 656 */         "Error: Occur in Query While Closing Connection After Fetching the specific pesticides purchase Details from Database For Update.", 
/*  578: 657 */         exception);
/*  579:     */     }
/*  580:     */     finally
/*  581:     */     {
/*  582: 659 */       JdbcHelper.closeResultSet(this.resultSet);
/*  583: 660 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/*  584: 661 */       JdbcHelper.closeConnection(this.connection);
/*  585:     */     }
/*  586: 665 */     return pesticides;
/*  587:     */   }
/*  588:     */   
/*  589:     */   public Pesticides retriveSpecificDealerTransactionForUpdate(Pesticides pesticides)
/*  590:     */     throws RecordNotFoundException
/*  591:     */   {
/*  592:     */     try
/*  593:     */     {
/*  594: 673 */       this.connection = getConnection();
/*  595: 674 */       PreparedStatement preparedStatements = this.connection
/*  596: 675 */         .prepareStatement("SELECT * FROM TAB_DEALER_OWNER_TRANSACTION WHERE DEALER_TRANS_BILL_NO=?");
/*  597: 676 */       preparedStatements.setString(1, pesticides.getInvoiceNo());
/*  598: 677 */       this.resultSet = preparedStatements.executeQuery();
/*  599: 678 */       System.out.println("----------hye ----------------" + pesticides.getInvoiceNo() + "invoice bill no");
/*  600: 679 */       if (this.resultSet != null) {
/*  601: 680 */         while (this.resultSet.next())
/*  602:     */         {
/*  603: 682 */           System.out.println("----------hye ----------------");
/*  604:     */           
/*  605: 684 */           pesticides.setTransactionId(this.resultSet.getInt("DEALER_TRANS_ID"));
/*  606:     */           
/*  607: 686 */           pesticides.setTotal(this.resultSet.getFloat("DEALER_TRANS_TOTAL"));
/*  608: 687 */           pesticides.setPaid(this.resultSet.getFloat("DEALER_TRANS_PAID"));
/*  609: 688 */           pesticides.setDue(this.resultSet.getFloat("DEALER_TRANS_DUE"));
/*  610: 689 */           pesticides.setTotalPaid(this.resultSet.getFloat("DEALER_TRANS_TOTAL_PAID"));
/*  611: 690 */           pesticides.setTotalDue(this.resultSet.getFloat("DEALER_TRANS_TOTAL_DUE"));
/*  612: 691 */           pesticides.setTransactionBillNo(this.resultSet.getString("DEALER_TRANS_BILL_NO"));
/*  613: 692 */           pesticides.setRetailerId(this.resultSet.getInt("DEALER_ID_REF"));
/*  614:     */         }
/*  615:     */       }
/*  616:     */     }
/*  617:     */     catch (SQLException sqlExp)
/*  618:     */     {
/*  619: 705 */       sqlExp.printStackTrace();
/*  620: 706 */       logger.error(
/*  621: 707 */         PurchasePesticidesDaoImpl.class + 
/*  622: 708 */         "Error: Occur in Query While Fetching the specific cement purchase pesticides transaction from Database For Update.", 
/*  623: 709 */         sqlExp);
/*  624:     */     }
/*  625:     */     catch (Exception exception)
/*  626:     */     {
/*  627: 711 */       exception.printStackTrace();
/*  628: 712 */       logger.error(
/*  629: 713 */         PurchasePesticidesDaoImpl.class + 
/*  630: 714 */         "Error: Occur in Query While Closing Connection After Fetching the specific pesticides purchase transaction from Database For Update.", 
/*  631: 715 */         exception);
/*  632:     */     }
/*  633:     */     finally
/*  634:     */     {
/*  635: 717 */       JdbcHelper.closeResultSet(this.resultSet);
/*  636: 718 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/*  637: 719 */       JdbcHelper.closeConnection(this.connection);
/*  638:     */     }
/*  639: 723 */     return pesticides;
/*  640:     */   }
/*  641:     */   
/*  642:     */   public void updateSpecificPurchaseRecord(PurchasePesticidesVO purchasePesticidesVO, int purchaseId, int transactionId)
/*  643:     */     throws UpdateFailedException
/*  644:     */   {
/*  645: 733 */     Connection connection = null;
/*  646: 734 */     PreparedStatement preparedStatement = null;
/*  647: 735 */     System.out.println("update is running************************");
/*  648:     */     try
/*  649:     */     {
/*  650: 738 */       String up = "UPDATE TAB_PURCHASE_PESTICIDES_DETAIL SET PUR_PESTICIDE_COMPANY_NAME=?, PUR_PESTICIDE_PRICE=?, PUR_PESTICIDE_AMOUNT=?,PUR_PESTICIDE_GST=?, PUR_PESTICIDE_CGST=?, PUR_PESTICIDE_SGST=?, PUR_PESTICIDE_DEALER_NAME=?, PUR_PESTICIDE_DEALER_CONTACT=?, PUR_PESTICIDE_DEALER_ADDRESS=?, PUR_PESTICIDE_DEALER_REF=?, PUR_PESTICIDE_BAGS_NO=?, PUR_PESTICIDE_BAGS_TON=?, PUR_PESTICIDE_GST_AMOUNT=?, PUR_PESTICIDE_CGST_AMOUNT=?, PUR_PESTICIDE_SGST_AMOUNT=?, PUR_PESTICIDE_INVOICE_NO=?, PUR_PESTICIDE_ORDER_NO=?, PUR_PESTICIDE_CARRIER_NAME=?, PUR_PESTICIDE_PAYMENT_MODE=?, PUR_PESTICIDE_WEEK_NO=?, PUR_PESTICIDE_INCOTERM=?, PUR_PESTICIDE_PAYMENT=?,PUR_PESTICIDE_INVOICE_DATE=?, PUR_PESTICIDE_MATERIAL_CODE=?, PUR_PESTICIDE_HSN_CODE=?, PUR_PESTICIDE_DELIVERY_PLACE=?, PUR_PESTICIDE_UNIT_PRICE=?, PUR_PESTICIDE_DISCOUNT=?WHERE PUR_PESTICIDE_ID=?";
/*  651:     */       
/*  652:     */ 
/*  653:     */ 
/*  654:     */ 
/*  655:     */ 
/*  656: 744 */       System.out.println("fffffffffffffffffffffF" + purchaseId);
/*  657:     */       
/*  658: 746 */       connection = getConnection();
/*  659: 747 */       preparedStatement = connection.prepareStatement(up);
/*  660: 748 */       preparedStatement.setString(1, purchasePesticidesVO.getCompanyName());
/*  661: 749 */       preparedStatement.setFloat(2, purchasePesticidesVO.getUnitPrice());
/*  662: 750 */       preparedStatement.setFloat(3, purchasePesticidesVO.getNetAmount());
/*  663: 751 */       preparedStatement.setFloat(4, purchasePesticidesVO.getGst());
/*  664: 752 */       preparedStatement.setFloat(5, purchasePesticidesVO.getCgst());
/*  665: 753 */       preparedStatement.setFloat(6, purchasePesticidesVO.getSgst());
/*  666: 754 */       preparedStatement.setString(7, this.nameHelper.getDealerNameById(Integer.parseInt(purchasePesticidesVO.getDealerName())));
/*  667: 755 */       preparedStatement.setString(8, purchasePesticidesVO.getDealerContact());
/*  668: 756 */       preparedStatement.setString(9, purchasePesticidesVO.getDealerAddress());
/*  669: 757 */       preparedStatement.setString(10, purchasePesticidesVO.getDealerName());
/*  670: 758 */       preparedStatement.setFloat(11, purchasePesticidesVO.getQuantity());
/*  671:     */       
/*  672: 760 */       preparedStatement.setFloat(12, purchasePesticidesVO.getQuantity());
/*  673: 761 */       preparedStatement.setFloat(13, purchasePesticidesVO.getGst());
/*  674:     */       
/*  675: 763 */       preparedStatement.setFloat(14, purchasePesticidesVO.getCgstAmount());
/*  676: 764 */       preparedStatement.setFloat(15, purchasePesticidesVO.getSgstAmount());
/*  677: 765 */       preparedStatement.setString(16, purchasePesticidesVO.getInvoiceNo());
/*  678: 766 */       preparedStatement.setString(17, purchasePesticidesVO.getOrderNo());
/*  679: 767 */       preparedStatement.setString(18, purchasePesticidesVO.getTransporter());
/*  680: 768 */       preparedStatement.setString(19, purchasePesticidesVO.getPaymentMode());
/*  681: 769 */       preparedStatement.setString(20, purchasePesticidesVO.getWeekNo());
/*  682: 770 */       preparedStatement.setString(21, purchasePesticidesVO.getInconterm());
/*  683: 771 */       preparedStatement.setFloat(22, purchasePesticidesVO.getPayment());
/*  684:     */       
/*  685:     */ 
/*  686:     */ 
/*  687: 775 */       preparedStatement.setString(23, DateTimeUtil.convertToDate(purchasePesticidesVO.getInvoiceDate()));
/*  688: 776 */       preparedStatement.setString(24, purchasePesticidesVO.getMaterialCode());
/*  689: 777 */       preparedStatement.setString(25, purchasePesticidesVO.getHsnCode());
/*  690: 778 */       preparedStatement.setString(26, purchasePesticidesVO.getDeliveryPlace());
/*  691: 779 */       preparedStatement.setFloat(27, purchasePesticidesVO.getUnitPrice());
/*  692: 780 */       preparedStatement.setFloat(28, purchasePesticidesVO.getDiscount());
/*  693:     */       
/*  694: 782 */       preparedStatement.setFloat(29, purchaseId);
/*  695:     */       
/*  696: 784 */       System.out.println("trans id is******" + purchasePesticidesVO.getTransactionId() + " purchaseCementVO.getPayment()" + purchasePesticidesVO.getPayment());
/*  697: 785 */       int effect = preparedStatement.executeUpdate();
/*  698: 786 */       if (effect == 1) {
/*  699: 787 */         updateSpecificDealerTransaction(purchasePesticidesVO, transactionId);
/*  700:     */       } else {
/*  701: 789 */         logger.info("INFO: Can Not Update purchase Details & Dealer Transaction.");
/*  702:     */       }
/*  703:     */     }
/*  704:     */     catch (SQLException sqlExp)
/*  705:     */     {
/*  706: 794 */       sqlExp.printStackTrace();
/*  707: 795 */       logger.error(
/*  708: 796 */         PurchasePesticidesDaoImpl.class + 
/*  709: 797 */         "Error: Occur in Query While updating the specific cement purchase Details.", 
/*  710: 798 */         sqlExp);
/*  711:     */     }
/*  712:     */     catch (Exception exception)
/*  713:     */     {
/*  714: 800 */       exception.printStackTrace();
/*  715: 801 */       logger.error(
/*  716: 802 */         PurchasePesticidesDaoImpl.class + 
/*  717: 803 */         "Error: Occur in Query While Closing Connection After updating the specific cement purchase Details.", 
/*  718: 804 */         exception);
/*  719:     */     }
/*  720:     */     finally
/*  721:     */     {
/*  722: 806 */       JdbcHelper.closeResultSet(this.resultSet);
/*  723: 807 */       JdbcHelper.closePreparedStatement(preparedStatement);
/*  724: 808 */       JdbcHelper.closeConnection(connection);
/*  725:     */     }
/*  726:     */   }
/*  727:     */   
/*  728:     */   public void updateSpecificDealerTransaction(PurchasePesticidesVO purchasePesticidesVO2, int transactionId)
/*  729:     */   {
/*  730: 817 */     Connection connection = null;
/*  731: 818 */     PreparedStatement preparedStatement = null;
/*  732:     */     
/*  733:     */ 
/*  734:     */ 
/*  735: 822 */     System.out.println(purchasePesticidesVO2.getTransactionId() + "update is running transaction************************" + transactionId);
/*  736: 823 */     String up = "UPDATE TAB_DEALER_OWNER_TRANSACTION SET DEALER_TRANS_TOTAL=?,DEALER_TRANS_PAID=?,DEALER_TRANS_DUE=?,DEALER_TRANS_TOTAL_PAID=?,DEALER_TRANS_TOTAL_DUE=?,DEALER_ID_REF=?,DEALER_TRANS_DATE=?,DEALER_TANS_PAYMENT_MODE=?WHERE DEALER_TRANS_ID=?";
/*  737:     */     
/*  738:     */ 
/*  739:     */ 
/*  740: 827 */     float dDueUpdate = purchasePesticidesVO2.getNetAmount() - purchasePesticidesVO2.getPayment();
/*  741: 828 */     System.out.println(purchasePesticidesVO2.getNetAmount() + " " + purchasePesticidesVO2.getPayment() + "hello we are in transaction update" + transactionId + " " + purchasePesticidesVO2.getTotalPaid() + " " + purchasePesticidesVO2.getTotalDue() + " " + purchasePesticidesVO2.getTotal() + " " + purchasePesticidesVO2.getPaid() + " " + purchasePesticidesVO2.getDue());
/*  742:     */     float dTotalDueUpdate;
/*  743:     */     float dTotalPaidUpdate;
/*  744:     */    
/*  745: 829 */     if ((purchasePesticidesVO2.getTotalPaid() == 0.0F) && (purchasePesticidesVO2.getTotalDue() == 0.0F))
/*  746:     */     {
/*  747: 830 */       float tp = 0.0F;
/*  748: 831 */       float td = 0.0F;
/*  749: 832 */        dTotalPaidUpdate = 0.0F;
/*  750: 833 */       dTotalDueUpdate = 0.0F;
/*  751:     */     }
/*  752:     */     else
/*  753:     */     {
/*  754: 835 */       float tp = purchasePesticidesVO2.getTotalPaid();
/*  755: 836 */       float td = purchasePesticidesVO2.getTotalDue();
/*  756: 837 */       dTotalPaidUpdate = tp - purchasePesticidesVO2.getPaid() + purchasePesticidesVO2.getPayment();
/*  757: 838 */       dTotalDueUpdate = td - purchasePesticidesVO2.getDue() + dDueUpdate;
/*  758:     */     }
/*  759: 841 */     float totalPresent = purchasePesticidesVO2.getUnitPrice() * purchasePesticidesVO2.getQuantity();
/*  760:     */     try
/*  761:     */     {
/*  762: 844 */       System.out.println();
/*  763: 845 */       connection = getConnection();
/*  764: 846 */       preparedStatement = connection.prepareStatement(up);
/*  765: 847 */       System.out.println("code is going to be run" + transactionId + "hhh" + purchasePesticidesVO2.getTransactionId() + "totalPresent" + totalPresent + "dDueUpdate" + dDueUpdate + "dTotalPaidUpdate" + dTotalDueUpdate + "dTotalPaidUpdate" + dTotalPaidUpdate + purchasePesticidesVO2.getTransactionDate());
/*  766: 848 */       preparedStatement.setFloat(1, purchasePesticidesVO2.getNetAmount());
/*  767: 849 */       preparedStatement.setFloat(2, purchasePesticidesVO2.getPayment());
/*  768: 850 */       preparedStatement.setFloat(3, dDueUpdate);
/*  769: 851 */       preparedStatement.setFloat(4, dTotalPaidUpdate);
/*  770: 852 */       preparedStatement.setFloat(5, dTotalDueUpdate);
/*  771: 853 */       preparedStatement.setString(6, purchasePesticidesVO2.getDealerName());
/*  772: 854 */       preparedStatement.setString(7, DateTimeUtil.convertToDate(purchasePesticidesVO2.getInvoiceDate()));
/*  773: 855 */       preparedStatement.setString(8, purchasePesticidesVO2.getPaymentMode());
/*  774: 856 */       preparedStatement.setInt(9, transactionId);
/*  775:     */       
/*  776: 858 */       System.out.println("ha ha my tran updated");
/*  777: 859 */       preparedStatement.executeUpdate();
/*  778:     */     }
/*  779:     */     catch (SQLException sqlExp)
/*  780:     */     {
/*  781: 862 */       sqlExp.printStackTrace();
/*  782: 863 */       logger.error(
/*  783: 864 */         PurchasePesticidesDaoImpl.class + 
/*  784: 865 */         "Error: Occur in Query While Fetching the specific cement purchase Transaction from Database For Update.", 
/*  785: 866 */         sqlExp);
/*  786:     */     }
/*  787:     */     catch (Exception exception)
/*  788:     */     {
/*  789: 868 */       exception.printStackTrace();
/*  790: 869 */       logger.error(
/*  791: 870 */         PurchasePesticidesDaoImpl.class + 
/*  792: 871 */         "Error: Occur in Query While Closing Connection After Fetching the specific cement purchase Details from Database For Update.", 
/*  793: 872 */         exception);
/*  794:     */     }
/*  795:     */     finally
/*  796:     */     {
/*  797: 875 */       JdbcHelper.closePreparedStatement(preparedStatement);
/*  798: 876 */       JdbcHelper.closeConnection(connection);
/*  799:     */     }
/*  800:     */   }
/*  801:     */   
/*  802:     */   public int deleteSpecificPesticidePurchaseDetails(int purchaseId)
/*  803:     */     throws DeleteFailedException
/*  804:     */   {
/*  805: 887 */     int effect = 0;
/*  806:     */     try
/*  807:     */     {
/*  808: 889 */       this.connection = getConnection();
/*  809:     */       
/*  810: 891 */       this.preparedStatement = this.connection.prepareStatement("DELETE FROM TAB_PURCHASE_PESTICIDES_DETAIL WHERE PUR_PESTICIDE_ID=?");
/*  811:     */       
/*  812: 893 */       this.preparedStatement.setInt(1, purchaseId);
/*  813:     */       
/*  814: 895 */       effect = this.preparedStatement.executeUpdate();
/*  815:     */     }
/*  816:     */     catch (SQLException sqlException)
/*  817:     */     {
/*  818: 898 */       sqlException.printStackTrace();
/*  819: 899 */       logger.error(
/*  820: 900 */         PurchasePesticidesDaoImpl.class + 
/*  821: 901 */         ": Error:- Error: Occur in Query While deleting the pesticides purchase details record", 
/*  822: 902 */         sqlException);
/*  823:     */     }
/*  824:     */     catch (Exception exception)
/*  825:     */     {
/*  826: 904 */       exception.printStackTrace();
/*  827: 905 */       logger.error(
/*  828: 906 */         PurchasePesticidesDaoImpl.class + 
/*  829: 907 */         ": Error:- While closing the Connection after deleting the pesticides purchase details reccord", 
/*  830: 908 */         exception);
/*  831:     */     }
/*  832:     */     finally
/*  833:     */     {
/*  834: 911 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/*  835: 912 */       JdbcHelper.closeConnection(this.connection);
/*  836:     */     }
/*  837: 914 */     return effect;
/*  838:     */   }
/*  839:     */   
/*  840:     */   public Pesticides retrivedPesticidesDetails(int purchaseId)
/*  841:     */     throws RecordNotFoundException
/*  842:     */   {
/*  843: 921 */     Pesticides pesticides = new Pesticides();
/*  844:     */     try
/*  845:     */     {
/*  846: 924 */       this.connection = getConnection();
/*  847: 925 */       this.preparedStatement = this.connection
/*  848: 926 */         .prepareStatement("SELECT * FROM TAB_PURCHASE_PESTICIDES_DETAIL WHERE PUR_PESTICIDE_ID=? ");
/*  849:     */       
/*  850:     */ 
/*  851: 929 */       this.preparedStatement.setInt(1, purchaseId);
/*  852: 930 */       this.resultSet = this.preparedStatement.executeQuery();
/*  853: 931 */       System.out.println("----------hye ----------------");
/*  854: 932 */       if (this.resultSet != null) {
/*  855: 933 */         while (this.resultSet.next())
/*  856:     */         {
/*  857: 935 */           System.out.println("----------hye ----------------");
/*  858:     */           
/*  859: 937 */           pesticides.setPurchaseId(this.resultSet.getInt("PUR_PESTICIDE_ID"));
/*  860: 938 */           System.out.println("________________" + this.resultSet.getInt("PUR_PESTICIDE_ID"));
/*  861:     */           
/*  862: 940 */           pesticides.setCompanyName(this.resultSet.getString("PUR_PESTICIDE_COMPANY_NAME"));
/*  863: 941 */           System.out.println("---------" + this.resultSet.getString("PUR_PESTICIDE_PRICE"));
/*  864:     */           
/*  865:     */ 
/*  866:     */ 
/*  867:     */ 
/*  868:     */ 
/*  869: 947 */           pesticides.setNetAmount(this.resultSet
/*  870: 948 */             .getFloat("PUR_PESTICIDE_AMOUNT"));
/*  871:     */           
/*  872: 950 */           pesticides.setGst(this.resultSet
/*  873: 951 */             .getFloat("PUR_PESTICIDE_GST"));
/*  874:     */           
/*  875: 953 */           pesticides.setCgst(this.resultSet
/*  876: 954 */             .getFloat("PUR_PESTICIDE_CGST"));
/*  877:     */           
/*  878: 956 */           pesticides.setSgst(this.resultSet
/*  879: 957 */             .getFloat("PUR_PESTICIDE_SGST"));
/*  880:     */           
/*  881: 959 */           pesticides.setdFullName(this.resultSet.getString("PUR_PESTICIDE_DEALER_NAME"));
/*  882:     */           
/*  883: 961 */           pesticides.setDealerContact(this.resultSet.getString("PUR_PESTICIDE_DEALER_CONTACT"));
/*  884:     */           
/*  885: 963 */           pesticides.setDealerAddress(this.resultSet.getString("PUR_PESTICIDE_DEALER_ADDRESS"));
/*  886:     */           
/*  887: 965 */           pesticides.setQuantity(this.resultSet.getInt("PUR_PESTICIDE_QUANTITY"));
/*  888:     */           
/*  889:     */ 
/*  890:     */ 
/*  891:     */ 
/*  892:     */ 
/*  893:     */ 
/*  894:     */ 
/*  895: 973 */           pesticides.setGstAmount(this.resultSet
/*  896: 974 */             .getFloat("PUR_PESTICIDE_GST_AMOUNT"));
/*  897: 975 */           pesticides.setCgstAmount(this.resultSet
/*  898: 976 */             .getFloat("PUR_PESTICIDE_CGST_AMOUNT"));
/*  899: 977 */           pesticides.setSgstAmount(this.resultSet
/*  900: 978 */             .getFloat("PUR_PESTICIDE_SGST_AMOUNT"));
/*  901: 979 */           pesticides.setInvoiceNo(this.resultSet
/*  902: 980 */             .getString("PUR_PESTICIDE_INVOICE_NO"));
/*  903:     */           
/*  904: 982 */           pesticides.setOrderNo(this.resultSet
/*  905: 983 */             .getString("PUR_PESTICIDE_ORDER_NO"));
/*  906:     */           
/*  907: 985 */           pesticides.setTransporter(this.resultSet
/*  908: 986 */             .getString("PUR_PESTICIDE_CARRIER_NAME"));
/*  909:     */           
/*  910:     */ 
/*  911:     */ 
/*  912:     */ 
/*  913: 991 */           pesticides.setWeekNo(this.resultSet
/*  914: 992 */             .getString("PUR_PESTICIDE_WEEK_NO"));
/*  915:     */           
/*  916: 994 */           pesticides.setInconterm(this.nameHelper.getProductTypeNameByProductId(Integer.parseInt(this.nameHelper.getProductNameById(this.resultSet
/*  917: 995 */             .getInt("PUR_PESTICIDE_INCOTERM")))));
/*  918:     */           
/*  919:     */ 
/*  920:     */ 
/*  921: 999 */           pesticides.setInvoiceDate(this.resultSet
/*  922:1000 */             .getString("PUR_PESTICIDE_INVOICE_DATE"));
/*  923:     */           
/*  924:1002 */           pesticides.setMaterialCode(this.resultSet
/*  925:1003 */             .getString("PUR_PESTICIDE_MATERIAL_CODE"));
/*  926:     */           
/*  927:     */ 
/*  928:1006 */           pesticides.setHsnCode(this.resultSet
/*  929:1007 */             .getString("PUR_PESTICIDE_HSN_CODE"));
/*  930:     */           
/*  931:1009 */           pesticides.setDeliveryPlace(this.resultSet
/*  932:1010 */             .getString("PUR_PESTICIDE_DELIVERY_PLACE"));
/*  933:     */           
/*  934:1012 */           pesticides.setUnitPrice(this.resultSet
/*  935:1013 */             .getFloat("PUR_PESTICIDE_UNIT_PRICE"));
/*  936:     */         }
/*  937:     */       }
/*  938:     */     }
/*  939:     */     catch (SQLException sqlExp)
/*  940:     */     {
/*  941:1023 */       sqlExp.printStackTrace();
/*  942:1024 */       logger.error(
/*  943:1025 */         PurchasePesticidesDaoImpl.class + 
/*  944:1026 */         "Error: Occur in Query While Fetching the specific cement purchase Details from Database.", 
/*  945:1027 */         sqlExp);
/*  946:     */     }
/*  947:     */     catch (Exception exception)
/*  948:     */     {
/*  949:1029 */       exception.printStackTrace();
/*  950:1030 */       logger.error(
/*  951:1031 */         PurchasePesticidesDaoImpl.class + 
/*  952:1032 */         "Error: Occur in Query While Closing Connection After Fetching the specific cement purchase Details from Database.", 
/*  953:1033 */         exception);
/*  954:     */     }
/*  955:     */     finally
/*  956:     */     {
/*  957:1035 */       JdbcHelper.closeResultSet(this.resultSet);
/*  958:1036 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/*  959:1037 */       JdbcHelper.closeConnection(this.connection);
/*  960:     */     }
/*  961:1041 */     return pesticides;
/*  962:     */   }
/*  963:     */   
/*  964:     */   public List<PurchasePesticidesVO> getPurchasePesticidesDetailsForAdvanceSearch(int searchId, String searchValue)
/*  965:     */     throws RecordNotFoundException
/*  966:     */   {
/*  967:1048 */     List<PurchasePesticidesVO> purchasePesticidesDetailList = new ArrayList();
/*  968:     */     try
/*  969:     */     {
/*  970:1052 */       this.connection = getConnection();
/*  971:     */       
/*  972:     */ 
/*  973:     */ 
/*  974:     */ 
/*  975:1057 */       this.preparedStatement = this.connection.prepareStatement(QueryBuilder.getPurchasePesticideAdvanceSearchList(searchId, searchValue));
/*  976:     */       
/*  977:     */ 
/*  978:1060 */       this.resultSet = this.preparedStatement.executeQuery();
/*  979:1064 */       while (this.resultSet.next())
/*  980:     */       {
/*  981:1065 */         this.purchasePesticidesVO = new PurchasePesticidesVO();
/*  982:1066 */         this.purchasePesticidesVO.setPurchaseId(this.resultSet.getInt("PUR_PESTICIDE_ID"));
/*  983:     */         
/*  984:1068 */         this.purchasePesticidesVO.setDealerName(this.nameHelper.getDealerNameById(this.resultSet.getInt("PUR_PESTICIDE_DEALER_REF")));
/*  985:1069 */         this.purchasePesticidesVO.setDealerContact(this.resultSet.getString("PUR_PESTICIDE_DEALER_CONTACT"));
/*  986:     */         
/*  987:1071 */         this.purchasePesticidesVO.setCompanyName(this.resultSet.getString("PUR_PESTICIDE_COMPANY_NAME"));
/*  988:     */         
/*  989:1073 */         this.purchasePesticidesVO.setQuantity(this.resultSet
/*  990:1074 */           .getInt("PUR_PESTICIDE_QUANTITY"));
/*  991:     */         
/*  992:1076 */         this.purchasePesticidesVO.setInvoiceNo(this.resultSet
/*  993:1077 */           .getString("PUR_PESTICIDE_INVOICE_NO"));
/*  994:     */         
/*  995:     */ 
/*  996:1080 */         this.purchasePesticidesVO.setOrderNo(this.resultSet
/*  997:1081 */           .getString("PUR_PESTICIDE_ORDER_NO"));
/*  998:     */         
/*  999:1083 */         this.purchasePesticidesVO.setTransporter(this.resultSet
/* 1000:1084 */           .getString("PUR_PESTICIDE_CARRIER_NAME"));
/* 1001:     */         
/* 1002:1086 */         this.purchasePesticidesVO.setInvoiceDate(this.resultSet
/* 1003:1087 */           .getString("PUR_PESTICIDE_INVOICE_DATE"));
/* 1004:     */         
/* 1005:1089 */         this.purchasePesticidesVO.setMaterialCode(this.resultSet
/* 1006:1090 */           .getString("PUR_PESTICIDE_MATERIAL_CODE"));
/* 1007:     */         
/* 1008:     */ 
/* 1009:1093 */         this.purchasePesticidesVO.setUnitPrice(this.resultSet
/* 1010:1094 */           .getFloat("PUR_PESTICIDE_UNIT_PRICE"));
/* 1011:1095 */         this.purchasePesticidesVO.setNetAmount(this.resultSet
/* 1012:1096 */           .getFloat("PUR_PESTICIDE_AMOUNT"));
/* 1013:1097 */         this.purchasePesticidesVO.setGst(this.resultSet
/* 1014:1098 */           .getFloat("PUR_PESTICIDE_GST"));
/* 1015:     */         
/* 1016:1100 */         System.out.println(this.purchasePesticidesVO.getCompanyName() + "yyyyyyyyyyyyyyyyy" + this.purchasePesticidesVO.getPurchaseId());
/* 1017:     */         
/* 1018:     */ 
/* 1019:     */ 
/* 1020:     */ 
/* 1021:1105 */         purchasePesticidesDetailList.add(this.purchasePesticidesVO);
/* 1022:     */       }
/* 1023:     */     }
/* 1024:     */     catch (SQLException sqlExp)
/* 1025:     */     {
/* 1026:1109 */       sqlExp.printStackTrace();
/* 1027:1110 */       logger.error(
/* 1028:1111 */         PurchasePesticidesDaoImpl.class + 
/* 1029:1112 */         "Error: Occur in Query While Fetching the pesticides purchase Details into Grid from Database.", 
/* 1030:1113 */         sqlExp);
/* 1031:     */     }
/* 1032:     */     catch (Exception exception)
/* 1033:     */     {
/* 1034:1115 */       exception.printStackTrace();
/* 1035:1116 */       logger.error(
/* 1036:1117 */         PurchasePesticidesDaoImpl.class + 
/* 1037:1118 */         "Error: Occur in Query While Closing Connection After Fetching the pesticides purchase into Grid from Database.", 
/* 1038:1119 */         exception);
/* 1039:     */     }
/* 1040:     */     finally
/* 1041:     */     {
/* 1042:1121 */       JdbcHelper.closeResultSet(this.resultSet);
/* 1043:1122 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/* 1044:1123 */       JdbcHelper.closeConnection(this.connection);
/* 1045:     */     }
/* 1046:1125 */     return purchasePesticidesDetailList;
/* 1047:     */   }
/* 1048:     */   
/* 1049:     */   public int getPurchasePesticideLastRecord()
/* 1050:     */     throws RecordNotFoundException
/* 1051:     */   {
/* 1052:1132 */     int temp = 0;
/* 1053:     */     try
/* 1054:     */     {
/* 1055:1134 */       this.connection = getConnection();
/* 1056:     */       
/* 1057:1136 */       this.preparedStatement = this.connection
/* 1058:1137 */         .prepareStatement("SELECT  PUR_PESTICIDE_ID FROM TAB_PURCHASE_PESTICIDES_DETAIL  ORDER BY PUR_PESTICIDE_ID DESC LIMIT 1 ");
/* 1059:     */       
/* 1060:     */ 
/* 1061:1140 */       this.resultSet = this.preparedStatement.executeQuery();
/* 1062:1141 */       if (this.resultSet != null) {
/* 1063:1142 */         while (this.resultSet.next()) {
/* 1064:1144 */           temp = this.resultSet.getInt("PUR_PESTICIDE_ID");
/* 1065:     */         }
/* 1066:     */       }
/* 1067:     */     }
/* 1068:     */     catch (SQLException sqlException)
/* 1069:     */     {
/* 1070:1149 */       sqlException.printStackTrace();
/* 1071:1150 */       logger.error(
/* 1072:1151 */         PurchasePesticidesDaoImpl.class + 
/* 1073:1152 */         ": Error:- Error: Occur in Query While counting the Purchase Pesticide details recods from Database", 
/* 1074:1153 */         sqlException);
/* 1075:     */     }
/* 1076:     */     catch (Exception exception)
/* 1077:     */     {
/* 1078:1156 */       exception.printStackTrace();
/* 1079:1157 */       logger.error(
/* 1080:1158 */         PurchasePesticidesDaoImpl.class + 
/* 1081:1159 */         ": Error:- While closing the Connection after counting the Purchase Pesticide details recods from Database", 
/* 1082:1160 */         exception);
/* 1083:     */     }
/* 1084:     */     finally
/* 1085:     */     {
/* 1086:1162 */       JdbcHelper.closeResultSet(this.resultSet);
/* 1087:1163 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/* 1088:1164 */       JdbcHelper.closeConnection(this.connection);
/* 1089:     */     }
/* 1090:1166 */     return temp;
/* 1091:     */   }
/* 1092:     */   
/* 1093:     */   public Pesticides getPurchasePesticideDetails(int purchaseId)
/* 1094:     */     throws RecordNotFoundException
/* 1095:     */   {
/* 1096:1191 */     Pesticides pesticides = new Pesticides();
/* 1097:     */     try
/* 1098:     */     {
/* 1099:1194 */       this.connection = getConnection();
/* 1100:     */       
/* 1101:1196 */       this.preparedStatement = this.connection
/* 1102:1197 */         .prepareStatement("SELECT * FROM TAB_PURCHASE_PESTICIDES_DETAIL WHERE PUR_PESTICIDE_ID=?");
/* 1103:1198 */       this.preparedStatement.setInt(1, purchaseId);
/* 1104:     */       
/* 1105:     */ 
/* 1106:1201 */       this.resultSet = this.preparedStatement.executeQuery();
/* 1107:1202 */       System.out.println("----------hye ----------------");
/* 1108:1203 */       if (this.resultSet != null) {
/* 1109:1204 */         while (this.resultSet.next())
/* 1110:     */         {
/* 1111:1206 */           System.out.println("----------hye ----------------");
/* 1112:     */           
/* 1113:1208 */           pesticides.setPurchaseId(this.resultSet.getInt("PUR_PESTICIDE_ID"));
/* 1114:1209 */           System.out.println("________________" + this.resultSet.getInt("PUR_PESTICIDE_ID"));
/* 1115:     */           
/* 1116:1211 */           pesticides.setCompanyName(this.resultSet.getString("PUR_PESTICIDE_COMPANY_NAME"));
/* 1117:1212 */           System.out.println("---------" + this.resultSet.getString("PUR_PESTICIDE_PRICE"));
/* 1118:     */           
/* 1119:     */ 
/* 1120:     */ 
/* 1121:     */ 
/* 1122:     */ 
/* 1123:1218 */           pesticides.setNetAmount(this.resultSet
/* 1124:1219 */             .getFloat("PUR_PESTICIDE_AMOUNT"));
/* 1125:     */           
/* 1126:1221 */           pesticides.setGst(this.resultSet
/* 1127:1222 */             .getFloat("PUR_PESTICIDE_GST"));
/* 1128:     */           
/* 1129:1224 */           pesticides.setCgst(this.resultSet
/* 1130:1225 */             .getFloat("PUR_PESTICIDE_CGST"));
/* 1131:     */           
/* 1132:1227 */           pesticides.setSgst(this.resultSet
/* 1133:1228 */             .getFloat("PUR_PESTICIDE_SGST"));
/* 1134:     */           
/* 1135:1230 */           pesticides.setdFullName(this.resultSet.getString("PUR_PESTICIDE_DEALER_NAME"));
/* 1136:     */           
/* 1137:1232 */           pesticides.setDealerContact(this.resultSet.getString("PUR_PESTICIDE_DEALER_CONTACT"));
/* 1138:     */           
/* 1139:1234 */           pesticides.setDealerAddress(this.resultSet.getString("PUR_PESTICIDE_DEALER_ADDRESS"));
/* 1140:     */           
/* 1141:1236 */           pesticides.setDealerRef(this.resultSet.getInt("PUR_PESTICIDE_DEALER_REF"));
/* 1142:     */           
/* 1143:1238 */           pesticides.setQuantity(this.resultSet
/* 1144:1239 */             .getInt("PUR_PESTICIDE_QUANTITY"));
/* 1145:     */           
/* 1146:     */ 
/* 1147:     */ 
/* 1148:     */ 
/* 1149:1244 */           pesticides.setGstAmount(this.resultSet
/* 1150:1245 */             .getFloat("PUR_PESTICIDE_GST_AMOUNT"));
/* 1151:1246 */           pesticides.setCgstAmount(this.resultSet
/* 1152:1247 */             .getFloat("PUR_PESTICIDE_CGST_AMOUNT"));
/* 1153:1248 */           pesticides.setSgstAmount(this.resultSet
/* 1154:1249 */             .getFloat("PUR_PESTICIDE_SGST_AMOUNT"));
/* 1155:1250 */           pesticides.setInvoiceNo(this.resultSet
/* 1156:1251 */             .getString("PUR_PESTICIDE_INVOICE_NO"));
/* 1157:     */           
/* 1158:1253 */           pesticides.setOrderNo(this.resultSet
/* 1159:1254 */             .getString("PUR_PESTICIDE_ORDER_NO"));
/* 1160:     */           
/* 1161:1256 */           pesticides.setTransporter(this.resultSet
/* 1162:1257 */             .getString("PUR_PESTICIDE_CARRIER_NAME"));
/* 1163:     */           
/* 1164:     */ 
/* 1165:     */ 
/* 1166:     */ 
/* 1167:1262 */           pesticides.setWeekNo(this.resultSet
/* 1168:1263 */             .getString("PUR_PESTICIDE_WEEK_NO"));
/* 1169:     */           
/* 1170:1265 */           pesticides.setInconterm(this.resultSet
/* 1171:1266 */             .getString("PUR_PESTICIDE_INCOTERM"));
/* 1172:     */           
/* 1173:     */ 
/* 1174:     */ 
/* 1175:1270 */           pesticides.setInvoiceDate(this.resultSet
/* 1176:1271 */             .getString("PUR_PESTICIDE_INVOICE_DATE"));
/* 1177:     */           
/* 1178:1273 */           pesticides.setMaterialCode(this.resultSet
/* 1179:1274 */             .getString("PUR_PESTICIDE_MATERIAL_CODE"));
/* 1180:     */           
/* 1181:     */ 
/* 1182:1277 */           pesticides.setHsnCode(this.resultSet
/* 1183:1278 */             .getString("PUR_PESTICIDE_HSN_CODE"));
/* 1184:     */           
/* 1185:1280 */           pesticides.setDeliveryPlace(this.resultSet
/* 1186:1281 */             .getString("PUR_PESTICIDE_DELIVERY_PLACE"));
/* 1187:     */           
/* 1188:1283 */           pesticides.setUnitPrice(this.resultSet
/* 1189:1284 */             .getFloat("PUR_PESTICIDE_UNIT_PRICE"));
/* 1190:     */         }
/* 1191:     */       }
/* 1192:     */     }
/* 1193:     */     catch (SQLException sqlExp)
/* 1194:     */     {
/* 1195:1294 */       sqlExp.printStackTrace();
/* 1196:1295 */       logger.error(
/* 1197:1296 */         PurchasePesticidesDaoImpl.class + 
/* 1198:1297 */         "Error: Occur in Query While Fetching the specific next pesticides purchase Details from Database.", 
/* 1199:1298 */         sqlExp);
/* 1200:     */     }
/* 1201:     */     catch (Exception exception)
/* 1202:     */     {
/* 1203:1300 */       exception.printStackTrace();
/* 1204:1301 */       logger.error(
/* 1205:1302 */         PurchasePesticidesDaoImpl.class + 
/* 1206:1303 */         "Error: Occur in Query While Closing Connection After Fetching the specific next pesticides purchase Details from Database.", 
/* 1207:1304 */         exception);
/* 1208:     */     }
/* 1209:     */     finally
/* 1210:     */     {
/* 1211:1306 */       JdbcHelper.closeResultSet(this.resultSet);
/* 1212:1307 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/* 1213:1308 */       JdbcHelper.closeConnection(this.connection);
/* 1214:     */     }
/* 1215:1312 */     return pesticides;
/* 1216:     */   }
/* 1217:     */   
/* 1218:     */   public void purchasePrintPDF(HttpServletRequest request, HttpServletResponse response, int purchaseId)
/* 1219:     */   {
/* 1220:1321 */     String companyName = "Chouksay Traders";
/* 1221:1322 */     String address1 = "BUS STAND SHAMSHABAD, DIST.- VIDISHA, MADHYA PRADESH, 464001";
/* 1222:1323 */     String address2 = "GSTIN: 23AJQPC8200P1Z1";
/* 1223:1324 */     String address3 = "PAN NO: AJQPC8200P";
/* 1224:     */     
/* 1225:1326 */     String city = "Vidisha-464001";
/* 1226:1327 */     String state = "(M.P.)";
/* 1227:1328 */     StringBuffer stringBuffer = null;
/* 1228:1329 */     response = ServletActionContext.getResponse();
/* 1229:     */     try
/* 1230:     */     {
/* 1231:1332 */       this.connection = getConnection();
/* 1232:1333 */       this.preparedStatement = this.connection
/* 1233:1334 */         .prepareStatement(" SELECT * FROM TAB_PURCHASE_PESTICIDES_DETAIL WHERE PUR_PESTICIDE_ID=?");
/* 1234:1335 */       this.preparedStatement.setInt(1, purchaseId);
/* 1235:1336 */       this.resultSet = this.preparedStatement.executeQuery();
/* 1236:1337 */       Document document = new Document(PageSize.A4);
/* 1237:     */       
/* 1238:1339 */       Font Font3 = new Font(Font.FontFamily.TIMES_ROMAN, 11.0F, 0);
/* 1239:1340 */       Font Font2 = new Font(Font.FontFamily.TIMES_ROMAN, 6.0F, 
/* 1240:1341 */         8);
/* 1241:1342 */       Font Font4 = new Font(Font.FontFamily.TIMES_ROMAN, 11.0F, 1);
/* 1242:1343 */       Font4.setColor(BaseColor.WHITE);
/* 1243:1344 */       Font mainContent = new Font(Font.FontFamily.TIMES_ROMAN, 10.0F, 
/* 1244:1345 */         0);
/* 1245:1346 */       Font Font5 = new Font(Font.FontFamily.TIMES_ROMAN, 12.0F, 1);
/* 1246:1347 */       Font5.setColor(BaseColor.GRAY);
/* 1247:1348 */       Font Font6 = new Font(Font.FontFamily.TIMES_ROMAN, 10.0F, 1);
/* 1248:1349 */       Font6.setColor(BaseColor.RED);
/* 1249:     */       
/* 1250:     */ 
/* 1251:1352 */       response.setContentType("application/pdf");
/* 1252:     */       
/* 1253:1354 */       PdfWriter.getInstance(document, response.getOutputStream());
/* 1254:     */       
/* 1255:1356 */       document.open();
/* 1256:     */       
/* 1257:1358 */       String contextPath = ServletActionContext.getServletContext()
/* 1258:1359 */         .getRealPath("/outer/img/rohittraders.png");
/* 1259:1360 */       this.image = Image.getInstance(contextPath);
/* 1260:1361 */       this.image.scaleToFit(130.0F, 70.0F);
/* 1261:     */       
/* 1262:1363 */       PdfPTable table1 = new PdfPTable(2);
/* 1263:1364 */       table1.setWidthPercentage(100.0F);
/* 1264:1365 */       Rectangle rect1 = new Rectangle(300.0F, 700.0F);
/* 1265:1366 */       table1.setWidthPercentage(new float[] { 150.0F, 150.0F }, rect1);
/* 1266:     */       
/* 1267:1368 */       PdfPCell cell101 = new PdfPCell(this.image, false);
/* 1268:1369 */       cell101.setPaddingTop(5.0F);
/* 1269:1370 */       cell101.setBorder(0);
/* 1270:     */       
/* 1271:1372 */       Phrase phrase3 = new Phrase(companyName + "\n", Font5);
/* 1272:1373 */       Phrase phrase = new Phrase(address1 + "\n", Font3);
/* 1273:1374 */       Phrase phrase1 = new Phrase(address2 + "\n", Font3);
/* 1274:1375 */       Phrase phrase2 = new Phrase(city + "-" + state, Font3);
/* 1275:     */       
/* 1276:1377 */       Paragraph paragraph = new Paragraph();
/* 1277:1378 */       paragraph.add(phrase3);
/* 1278:1379 */       paragraph.add(phrase);
/* 1279:1380 */       paragraph.add(phrase1);
/* 1280:1381 */       paragraph.add(phrase2);
/* 1281:     */       
/* 1282:1383 */       PdfPCell cell102 = new PdfPCell(paragraph);
/* 1283:1384 */       cell102.setPaddingTop(5.0F);
/* 1284:1385 */       cell102.setBorder(0);
/* 1285:1386 */       cell102.setHorizontalAlignment(2);
/* 1286:     */       
/* 1287:1388 */       PdfPCell cell103 = new PdfPCell(
/* 1288:1389 */         new Paragraph(
/* 1289:1390 */         "   \n                                                                                                                                                                                                                                                                                                                                                  ", 
/* 1290:     */         
/* 1291:     */ 
/* 1292:1393 */         Font2));
/* 1293:1394 */       cell103.setColspan(2);
/* 1294:1395 */       cell103.setBorderWidthRight(0.0F);
/* 1295:1396 */       cell103.setBorderWidthLeft(0.0F);
/* 1296:1397 */       cell103.setBorderWidthTop(0.5F);
/* 1297:1398 */       cell103.setBorderWidthBottom(0.0F);
/* 1298:1399 */       cell103.setBorderColorTop(BaseColor.WHITE);
/* 1299:     */       
/* 1300:1401 */       PdfPCell cell104 = new PdfPCell(new Paragraph("PURCHASE PESTICIDES REPORT", Font4));
/* 1301:1402 */       cell104.setUseBorderPadding(true);
/* 1302:1403 */       cell104.setColspan(2);
/* 1303:1404 */       cell104.setBorderWidthRight(0.1F);
/* 1304:1405 */       cell104.setBorderWidthLeft(0.1F);
/* 1305:1406 */       cell104.setBorderWidthTop(0.1F);
/* 1306:1407 */       cell104.setBorderWidthBottom(0.1F);
/* 1307:1408 */       cell104.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1308:1409 */       cell104.setBackgroundColor(new BaseColor(128, 0, 0));
/* 1309:     */       
/* 1310:1411 */       table1.addCell(cell101);
/* 1311:1412 */       table1.addCell(cell102);
/* 1312:1413 */       table1.addCell(cell103);
/* 1313:1414 */       table1.addCell(cell104);
/* 1314:1415 */       document.add(table1);
/* 1315:1421 */       while (this.resultSet.next())
/* 1316:     */       {
/* 1317:1422 */         stringBuffer = new StringBuffer();
/* 1318:1423 */         PdfPTable table = new PdfPTable(2);
/* 1319:1424 */         table.setFooterRows(1);
/* 1320:1425 */         table.setWidthPercentage(100.0F);
/* 1321:1426 */         Rectangle rect = new Rectangle(300.0F, 700.0F);
/* 1322:1427 */         table.setWidthPercentage(new float[] { 80.0F, 220.0F }, rect);
/* 1323:     */         
/* 1324:1429 */         PdfPCell cell = new PdfPCell(new Paragraph());
/* 1325:1430 */         cell.setColspan(2);
/* 1326:1431 */         cell.setBorderWidthRight(0.1F);
/* 1327:1432 */         cell.setBorderWidthLeft(0.1F);
/* 1328:1433 */         cell.setBorderWidthTop(0.1F);
/* 1329:1434 */         cell.setBorderWidthBottom(0.2F);
/* 1330:1435 */         cell.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1331:1436 */         cell.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1332:     */         
/* 1333:1438 */         PdfPCell cell1 = new PdfPCell(new Paragraph("Pesticide Information", 
/* 1334:1439 */           Font6));
/* 1335:1440 */         cell1.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1336:1441 */         cell1.setBorderWidth(0.01F);
/* 1337:1442 */         cell1.setBorderColor(BaseColor.WHITE);
/* 1338:     */         
/* 1339:1444 */         PdfPCell cell2 = new PdfPCell(new Paragraph());
/* 1340:1445 */         cell2.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1341:1446 */         cell2.setBorderWidth(0.2F);
/* 1342:1447 */         cell2.setBorderColor(BaseColor.WHITE);
/* 1343:     */         
/* 1344:     */ 
/* 1345:     */ 
/* 1346:1451 */         PdfPCell cell3 = new PdfPCell(new Paragraph("Pesticide Id", 
/* 1347:1452 */           mainContent));
/* 1348:1453 */         cell3.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1349:1454 */         cell3.setBorderWidth(0.01F);
/* 1350:1455 */         cell3.setBorderColor(BaseColor.WHITE);
/* 1351:     */         
/* 1352:1457 */         PdfPCell cell4 = new PdfPCell(new Paragraph(this.resultSet.getString("PUR_PESTICIDE_ID"), mainContent));
/* 1353:1458 */         cell4.setBorderWidth(0.2F);
/* 1354:1459 */         cell4.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1355:     */         
/* 1356:1461 */         PdfPCell cell5 = new PdfPCell(new Paragraph(
/* 1357:1462 */           "Pesticide company", mainContent));
/* 1358:1463 */         cell5.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1359:1464 */         cell5.setBorderWidth(0.01F);
/* 1360:1465 */         cell5.setBorderColor(BaseColor.WHITE);
/* 1361:     */         
/* 1362:1467 */         PdfPCell cell6 = new PdfPCell(new Paragraph(this.resultSet.getString("PUR_PESTICIDE_COMPANY_NAME"), mainContent));
/* 1363:1468 */         cell6.setBorderWidth(0.2F);
/* 1364:1469 */         cell6.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1365:     */         
/* 1366:1471 */         PdfPCell cell7 = new PdfPCell(new Paragraph("Amount", 
/* 1367:1472 */           mainContent));
/* 1368:1473 */         cell7.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1369:1474 */         cell7.setBorderWidth(0.01F);
/* 1370:1475 */         cell7.setBorderColor(BaseColor.WHITE);
/* 1371:     */         
/* 1372:1477 */         PdfPCell cell8 = new PdfPCell(new Paragraph(
/* 1373:1478 */           this.resultSet.getString("PUR_PESTICIDE_AMOUNT"), mainContent));
/* 1374:1479 */         cell8.setBorderWidth(0.2F);
/* 1375:1480 */         cell8.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1376:     */         
/* 1377:1482 */         PdfPCell cell9 = new PdfPCell(new Paragraph("GST", 
/* 1378:1483 */           mainContent));
/* 1379:1484 */         cell9.setBorderWidth(0.1F);
/* 1380:1485 */         cell9.setBorderColor(BaseColor.WHITE);
/* 1381:     */         
/* 1382:1487 */         PdfPCell cell10 = new PdfPCell(new Paragraph(
/* 1383:1488 */           this.resultSet.getString("PUR_PESTICIDE_GST"), mainContent));
/* 1384:1489 */         cell10.setBorderWidth(0.2F);
/* 1385:1490 */         cell10.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1386:     */         
/* 1387:1492 */         PdfPCell cell11 = new PdfPCell(new Paragraph("CGST", 
/* 1388:1493 */           mainContent));
/* 1389:1494 */         cell11.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1390:1495 */         cell11.setBorderWidth(0.01F);
/* 1391:1496 */         cell11.setBorderColor(BaseColor.WHITE);
/* 1392:     */         
/* 1393:1498 */         PdfPCell cell12 = new PdfPCell(new Paragraph(this.resultSet.getString("PUR_PESTICIDE_CGST"), mainContent));
/* 1394:1499 */         cell12.setBorderWidth(0.2F);
/* 1395:1500 */         cell12.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1396:     */         
/* 1397:1502 */         PdfPCell cell13 = new PdfPCell(new Paragraph("SGST", 
/* 1398:1503 */           mainContent));
/* 1399:1504 */         cell13.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1400:1505 */         cell13.setBorderWidth(0.01F);
/* 1401:1506 */         cell13.setBorderColor(BaseColor.WHITE);
/* 1402:     */         
/* 1403:1508 */         PdfPCell cell14 = new PdfPCell(new Paragraph(this.resultSet.getString("PUR_PESTICIDE_SGST"), mainContent));
/* 1404:1509 */         cell14.setBorderWidth(0.2F);
/* 1405:1510 */         cell14.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1406:     */         
/* 1407:1512 */         PdfPCell cell15 = new PdfPCell(new Paragraph(
/* 1408:1513 */           "Dealer Name", mainContent));
/* 1409:1514 */         cell15.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1410:1515 */         cell15.setBorderWidth(0.01F);
/* 1411:1516 */         cell15.setBorderColor(BaseColor.WHITE);
/* 1412:     */         
/* 1413:1518 */         PdfPCell cell16 = new PdfPCell(new Paragraph(this.resultSet.getString("PUR_PESTICIDE_DEALER_NAME"), mainContent));
/* 1414:1519 */         cell16.setBorderWidth(0.2F);
/* 1415:1520 */         cell16.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1416:     */         
/* 1417:1522 */         PdfPCell cell17 = new PdfPCell(new Paragraph(
/* 1418:1523 */           "Dealer Contact", mainContent));
/* 1419:1524 */         cell17.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1420:1525 */         cell17.setBorderWidth(0.01F);
/* 1421:1526 */         cell17.setBorderColor(BaseColor.WHITE);
/* 1422:     */         
/* 1423:1528 */         PdfPCell cell18 = new PdfPCell(new Paragraph(this.resultSet.getString("PUR_PESTICIDE_DEALER_CONTACT"), mainContent));
/* 1424:1529 */         cell18.setBorderWidth(0.2F);
/* 1425:1530 */         cell18.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1426:     */         
/* 1427:1532 */         PdfPCell cell19 = new PdfPCell(new Paragraph(
/* 1428:1533 */           "Dealer Address", mainContent));
/* 1429:1534 */         cell19.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1430:1535 */         cell19.setBorderWidth(0.01F);
/* 1431:1536 */         cell19.setBorderColor(BaseColor.WHITE);
/* 1432:     */         
/* 1433:1538 */         PdfPCell cell20 = new PdfPCell(new Paragraph(this.resultSet.getString("PUR_PESTICIDE_DEALER_ADDRESS"), mainContent));
/* 1434:1539 */         cell20.setBorderWidth(0.2F);
/* 1435:1540 */         cell20.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1436:     */         
/* 1437:1542 */         PdfPCell cell21 = new PdfPCell(new Paragraph(
/* 1438:1543 */           "Dealer REF", mainContent));
/* 1439:1544 */         cell21.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1440:1545 */         cell21.setBorderWidth(0.01F);
/* 1441:1546 */         cell21.setBorderColor(BaseColor.WHITE);
/* 1442:     */         
/* 1443:1548 */         PdfPCell cell22 = new PdfPCell(new Paragraph(this.resultSet.getString("PUR_PESTICIDE_DEALER_REF"), mainContent));
/* 1444:1549 */         cell22.setBorderWidth(0.2F);
/* 1445:1550 */         cell22.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1446:     */         
/* 1447:     */ 
/* 1448:1553 */         PdfPCell cell23 = new PdfPCell(new Paragraph(
/* 1449:1554 */           "Quantity", mainContent));
/* 1450:1555 */         cell23.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1451:1556 */         cell23.setBorderWidth(0.01F);
/* 1452:1557 */         cell23.setBorderColor(BaseColor.WHITE);
/* 1453:     */         
/* 1454:1559 */         PdfPCell cell24 = new PdfPCell(new Paragraph(this.resultSet.getString("PUR_PESTICIDE_QUANTITY"), mainContent));
/* 1455:1560 */         cell24.setBorderWidth(0.2F);
/* 1456:1561 */         cell24.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1457:     */         
/* 1458:1563 */         PdfPCell cell25 = new PdfPCell(new Paragraph(
/* 1459:1564 */           "GST Amount", mainContent));
/* 1460:1565 */         cell25.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1461:1566 */         cell25.setBorderWidth(0.01F);
/* 1462:1567 */         cell25.setBorderColor(BaseColor.WHITE);
/* 1463:     */         
/* 1464:1569 */         PdfPCell cell26 = new PdfPCell(new Paragraph(this.resultSet.getString("PUR_PESTICIDE_GST_AMOUNT"), mainContent));
/* 1465:1570 */         cell26.setBorderWidth(0.2F);
/* 1466:1571 */         cell26.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1467:     */         
/* 1468:1573 */         PdfPCell cell27 = new PdfPCell(new Paragraph(
/* 1469:1574 */           "CGST Amount", mainContent));
/* 1470:1575 */         cell27.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1471:1576 */         cell27.setBorderWidth(0.01F);
/* 1472:1577 */         cell27.setBorderColor(BaseColor.WHITE);
/* 1473:     */         
/* 1474:1579 */         PdfPCell cell28 = new PdfPCell(new Paragraph(this.resultSet.getString("PUR_PESTICIDE_CGST_AMOUNT"), mainContent));
/* 1475:1580 */         cell28.setBorderWidth(0.2F);
/* 1476:1581 */         cell28.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1477:     */         
/* 1478:1583 */         PdfPCell cell29 = new PdfPCell(new Paragraph(
/* 1479:1584 */           "SGST Amount", mainContent));
/* 1480:1585 */         cell29.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1481:1586 */         cell29.setBorderWidth(0.01F);
/* 1482:1587 */         cell29.setBorderColor(BaseColor.WHITE);
/* 1483:     */         
/* 1484:1589 */         PdfPCell cell30 = new PdfPCell(new Paragraph(this.resultSet.getString("PUR_PESTICIDE_SGST_AMOUNT"), mainContent));
/* 1485:1590 */         cell30.setBorderWidth(0.2F);
/* 1486:1591 */         cell30.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1487:     */         
/* 1488:1593 */         PdfPCell cell31 = new PdfPCell(new Paragraph(
/* 1489:1594 */           "Invoice No", mainContent));
/* 1490:1595 */         cell31.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1491:1596 */         cell31.setBorderWidth(0.01F);
/* 1492:1597 */         cell31.setBorderColor(BaseColor.WHITE);
/* 1493:     */         
/* 1494:1599 */         PdfPCell cell32 = new PdfPCell(new Paragraph(this.resultSet.getString("PUR_PESTICIDE_INVOICE_NO"), mainContent));
/* 1495:1600 */         cell32.setBorderWidth(0.2F);
/* 1496:1601 */         cell32.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1497:     */         
/* 1498:1603 */         PdfPCell cell33 = new PdfPCell(new Paragraph(
/* 1499:1604 */           "Order No", mainContent));
/* 1500:1605 */         cell33.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1501:1606 */         cell33.setBorderWidth(0.01F);
/* 1502:1607 */         cell33.setBorderColor(BaseColor.WHITE);
/* 1503:     */         
/* 1504:1609 */         PdfPCell cell34 = new PdfPCell(new Paragraph(this.resultSet.getString("PUR_PESTICIDE_ORDER_NO"), mainContent));
/* 1505:1610 */         cell34.setBorderWidth(0.2F);
/* 1506:1611 */         cell34.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1507:     */         
/* 1508:1613 */         PdfPCell cell35 = new PdfPCell(new Paragraph(
/* 1509:1614 */           "Carrier Name", mainContent));
/* 1510:1615 */         cell35.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1511:1616 */         cell35.setBorderWidth(0.01F);
/* 1512:1617 */         cell35.setBorderColor(BaseColor.WHITE);
/* 1513:     */         
/* 1514:1619 */         PdfPCell cell36 = new PdfPCell(new Paragraph(this.resultSet.getString("PUR_PESTICIDE_CARRIER_NAME"), mainContent));
/* 1515:1620 */         cell36.setBorderWidth(0.2F);
/* 1516:1621 */         cell36.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1517:     */         
/* 1518:1623 */         PdfPCell cell37 = new PdfPCell(new Paragraph(
/* 1519:1624 */           "Invoice Date", mainContent));
/* 1520:1625 */         cell37.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1521:1626 */         cell37.setBorderWidth(0.01F);
/* 1522:1627 */         cell37.setBorderColor(BaseColor.WHITE);
/* 1523:     */         
/* 1524:1629 */         PdfPCell cell38 = new PdfPCell(new Paragraph(this.resultSet.getString("PUR_PESTICIDE_INVOICE_DATE"), mainContent));
/* 1525:1630 */         cell38.setBorderWidth(0.2F);
/* 1526:1631 */         cell38.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1527:     */         
/* 1528:1633 */         PdfPCell cell39 = new PdfPCell(new Paragraph(
/* 1529:1634 */           "Material Code", mainContent));
/* 1530:1635 */         cell39.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1531:1636 */         cell39.setBorderWidth(0.01F);
/* 1532:1637 */         cell39.setBorderColor(BaseColor.WHITE);
/* 1533:     */         
/* 1534:1639 */         PdfPCell cell40 = new PdfPCell(new Paragraph(this.resultSet.getString("PUR_PESTICIDE_MATERIAL_CODE"), mainContent));
/* 1535:1640 */         cell40.setBorderWidth(0.2F);
/* 1536:1641 */         cell40.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1537:     */         
/* 1538:     */ 
/* 1539:     */ 
/* 1540:     */ 
/* 1541:1646 */         PdfPCell cell41 = new PdfPCell(new Paragraph(
/* 1542:1647 */           "HSN Code", mainContent));
/* 1543:1648 */         cell41.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1544:1649 */         cell41.setBorderWidth(0.01F);
/* 1545:1650 */         cell41.setBorderColor(BaseColor.WHITE);
/* 1546:     */         
/* 1547:1652 */         PdfPCell cell42 = new PdfPCell(new Paragraph(this.resultSet.getString("PUR_PESTICIDE_HSN_CODE"), mainContent));
/* 1548:1653 */         cell42.setBorderWidth(0.2F);
/* 1549:1654 */         cell42.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1550:     */         
/* 1551:1656 */         PdfPCell cell43 = new PdfPCell(new Paragraph(
/* 1552:1657 */           "Delivery Place", mainContent));
/* 1553:1658 */         cell43.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1554:1659 */         cell43.setBorderWidth(0.01F);
/* 1555:1660 */         cell43.setBorderColor(BaseColor.WHITE);
/* 1556:     */         
/* 1557:1662 */         PdfPCell cell44 = new PdfPCell(new Paragraph(this.resultSet.getString("PUR_PESTICIDE_DELIVERY_PLACE"), mainContent));
/* 1558:1663 */         cell44.setBorderWidth(0.2F);
/* 1559:1664 */         cell44.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1560:     */         
/* 1561:1666 */         PdfPCell cell45 = new PdfPCell(new Paragraph(
/* 1562:1667 */           "Unit Price", mainContent));
/* 1563:1668 */         cell45.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1564:1669 */         cell45.setBorderWidth(0.01F);
/* 1565:1670 */         cell45.setBorderColor(BaseColor.WHITE);
/* 1566:     */         
/* 1567:1672 */         PdfPCell cell46 = new PdfPCell(new Paragraph(this.resultSet.getString("PUR_PESTICIDE_UNIT_PRICE"), mainContent));
/* 1568:1673 */         cell46.setBorderWidth(0.2F);
/* 1569:1674 */         cell46.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1570:     */         
/* 1571:     */ 
/* 1572:     */ 
/* 1573:     */ 
/* 1574:     */ 
/* 1575:1680 */         table.addCell(cell);
/* 1576:1681 */         table.addCell(cell1);
/* 1577:1682 */         table.addCell(cell2);
/* 1578:1683 */         table.addCell(cell3);
/* 1579:1684 */         table.addCell(cell4);
/* 1580:1685 */         table.addCell(cell5);
/* 1581:1686 */         table.addCell(cell6);
/* 1582:1687 */         table.addCell(cell7);
/* 1583:1688 */         table.addCell(cell8);
/* 1584:1689 */         table.addCell(cell9);
/* 1585:1690 */         table.addCell(cell10);
/* 1586:1691 */         table.addCell(cell11);
/* 1587:1692 */         table.addCell(cell12);
/* 1588:1693 */         table.addCell(cell13);
/* 1589:1694 */         table.addCell(cell14);
/* 1590:1695 */         table.addCell(cell15);
/* 1591:1696 */         table.addCell(cell16);
/* 1592:1697 */         table.addCell(cell17);
/* 1593:1698 */         table.addCell(cell18);
/* 1594:1699 */         table.addCell(cell19);
/* 1595:1700 */         table.addCell(cell20);
/* 1596:1701 */         table.addCell(cell21);
/* 1597:1702 */         table.addCell(cell22);
/* 1598:1703 */         table.addCell(cell23);
/* 1599:1704 */         table.addCell(cell24);
/* 1600:1705 */         table.addCell(cell25);
/* 1601:1706 */         table.addCell(cell26);
/* 1602:1707 */         table.addCell(cell27);
/* 1603:1708 */         table.addCell(cell28);
/* 1604:1709 */         table.addCell(cell29);
/* 1605:1710 */         table.addCell(cell30);
/* 1606:1711 */         table.addCell(cell31);
/* 1607:1712 */         table.addCell(cell32);
/* 1608:1713 */         table.addCell(cell33);
/* 1609:1714 */         table.addCell(cell34);
/* 1610:1715 */         table.addCell(cell35);
/* 1611:1716 */         table.addCell(cell36);
/* 1612:1717 */         table.addCell(cell37);
/* 1613:1718 */         table.addCell(cell38);
/* 1614:1719 */         table.addCell(cell39);
/* 1615:1720 */         table.addCell(cell40);
/* 1616:1721 */         table.addCell(cell41);
/* 1617:1722 */         table.addCell(cell42);
/* 1618:1723 */         table.addCell(cell43);
/* 1619:1724 */         table.addCell(cell44);
/* 1620:1725 */         table.addCell(cell45);
/* 1621:1726 */         table.addCell(cell46);
/* 1622:     */         
/* 1623:     */ 
/* 1624:     */ 
/* 1625:1730 */         document.add(table);
/* 1626:     */       }
/* 1627:1734 */       document.add(new Paragraph("\n"));
/* 1628:     */       
/* 1629:     */ 
/* 1630:     */ 
/* 1631:1738 */       document.close();
/* 1632:     */     }
/* 1633:     */     catch (SQLException sqlExp)
/* 1634:     */     {
/* 1635:1741 */       sqlExp.printStackTrace();
/* 1636:1742 */       logger.error(
/* 1637:1743 */         PurchasePesticidesDaoImpl.class + 
/* 1638:1744 */         "Error: Occur in Query While Fetching All Purchase pesticide Details for print PdF from Database.", 
/* 1639:1745 */         sqlExp);
/* 1640:     */     }
/* 1641:     */     catch (Exception exception)
/* 1642:     */     {
/* 1643:1747 */       exception.printStackTrace();
/* 1644:1748 */       logger.error(
/* 1645:1749 */         PurchasePesticidesDaoImpl.class + 
/* 1646:1750 */         "Error: Occur in Query While Closing Connection After Fetching All Purchase pesticide Details for print PdF from Database.", 
/* 1647:1751 */         exception);
/* 1648:     */     }
/* 1649:     */     finally
/* 1650:     */     {
/* 1651:1753 */       JdbcHelper.closeResultSet(this.resultSet);
/* 1652:1754 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/* 1653:1755 */       JdbcHelper.closeConnection(this.connection);
/* 1654:     */     }
/* 1655:     */   }
/* 1656:     */ }


/* Location:           C:\Users\bharti\Desktop\Chouksay\lost\dao\
 * Qualified Name:     com.bst.ckt.dao.PurchasePesticidesDaoImpl
 * JD-Core Version:    0.7.0.1
 */