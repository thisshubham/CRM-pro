/*    1:     */ package com.bst.ckt.dao;
import com.bst.ckt.common.OMIConstants;
/*    2:     */ 
/*    3:     */ import com.bst.ckt.common.QueryBuilder;
/*    4:     */ import com.bst.ckt.dto.PurchaseCement;
/*    5:     */ import com.bst.ckt.exception.CreateFailedException;
/*    6:     */ import com.bst.ckt.exception.DeleteFailedException;
/*    7:     */ import com.bst.ckt.exception.RecordNotFoundException;
/*    8:     */ import com.bst.ckt.exception.UpdateFailedException;
/*    9:     */ import com.bst.ckt.framework.db.JdbcDAOSupport;
/*   10:     */ import com.bst.ckt.framework.db.JdbcHelper;
/*   11:     */ import com.bst.ckt.framework.util.DateTimeUtil;
/*   12:     */ import com.bst.ckt.helper.NameHelper;
/*   13:     */ import com.bst.ckt.vo.PurchaseCementVO;
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
/*   39:     */ public class PurchaseCementDaoImpl
/*   40:     */   extends JdbcDAOSupport
/*   41:     */   implements PurchaseCementDaoInf
/*   42:     */ {
/*   43:  48 */   private static final Logger logger = Logger.getLogger(PurchaseCementDaoImpl.class);
/*   44:  50 */   PreparedStatement preparedStatement = null;
/*   45:  51 */   Connection connection = null;
/*   46:  52 */   ResultSet resultSet = null;
/*   47:  53 */   PurchaseCementVO purchaseCementVO = null;
/*   48:  55 */   NameHelper nameHelper = new NameHelper();
/*   49:  56 */   Image image = null;
/*   50:     */   int dealerTransactionId;
/*   51:     */   
/*   52:     */   public int insertPurchaseCementDetails(PurchaseCementVO purchaseCementVO)
/*   53:     */     throws CreateFailedException
/*   54:     */   {
/*   55:  62 */     int output = 0;
/*   56:     */     try
/*   57:     */     {
/*   58:  65 */       System.out.println("we  r in dao " + purchaseCementVO.getDeliveryPlace());
/*   59:  66 */       this.connection = getConnection();
/*   60:     */       
/*   61:  68 */       String insert = "INSERT INTO TAB_PURCHASE_CEMENT_DETAIL(PUR_CEMENT_COMPANY_NAME, PUR_CEMENT_PRICE, PUR_CEMENT_AMOUNT,PUR_CEMENT_GST, PUR_CEMENT_CGST, PUR_CEMENT_SGST, PUR_CEMENT_DEALER_NAME, PUR_CEMENT_DEALER_CONTACT, PUR_CEMENT_DEALER_ADDRESS, PUR_CEMENT_DEALER_REF, PUR_CEMENT_BAGS_NO, PUR_CEMENT_BAGS_TON, PUR_CEMENT_GST_AMOUNT, PUR_CEMENT_CGST_AMOUNT, PUR_CEMENT_SGST_AMOUNT, PUR_CEMENT_INVOICE_NO, PUR_CEMENT_ORDER_NO, PUR_CEMENT_CARRIER_NAME, PUR_CEMENT_PAYMENT_MODE, PUR_CEMENT_WEEK_NO, PUR_CEMENT_INCOTERM, PUR_CEMENT_PAYMENT,PUR_CEMENT_INVOICE_DATE, PUR_CEMENT_MATERIAL_CODE, PUR_CEMENT_HSN_CODE, PUR_CEMENT_DELIVERY_PLACE, PUR_CEMENT_UNIT_PRICE, PUR_CEMENT_DISCOUNT)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
/*   62:     */       
/*   63:     */ float total=purchaseCementVO.getUnitPrice()*purchaseCementVO.getQuantity();
float cal =(100+purchaseCementVO.getGst())/100;
/*   64:     */ float gstAmount=total*cal;
float diff=gstAmount-total;
/*   65:     */ 
/*   66:     */ 
/*   67:  74 */       this.preparedStatement = this.connection
/*   68:  75 */         .prepareStatement(insert);
/*   69:     */       
/*   70:  77 */       this.preparedStatement.setString(1, purchaseCementVO.getCompanyName());
/*   71:  78 */       this.preparedStatement.setFloat(2, purchaseCementVO.getUnitPrice());
/*   72:  79 */       this.preparedStatement.setFloat(3, purchaseCementVO.getNetAmount());
/*   73:  80 */       this.preparedStatement.setFloat(4, purchaseCementVO.getGst());
/*   74:  81 */       this.preparedStatement.setFloat(5, purchaseCementVO.getCgst());
/*   75:  82 */       this.preparedStatement.setFloat(6, purchaseCementVO.getSgst());
/*   76:  83 */       System.out.println(purchaseCementVO.getDealerName() + "LLLLLLLLLLLddddddddd");
/*   77:  84 */       this.preparedStatement.setString(7, this.nameHelper.getDealerNameById(Integer.parseInt(purchaseCementVO.getDealerName())));
/*   78:  85 */       this.preparedStatement.setString(8, purchaseCementVO.getDealerContact());
/*   79:  86 */       this.preparedStatement.setString(9, purchaseCementVO.getDealerAddress());
/*   80:  87 */       this.preparedStatement.setString(10, purchaseCementVO.getDealerName());
/*   81:  88 */       this.preparedStatement.setInt(11, purchaseCementVO.getQuantity());
/*   82:  89 */       this.preparedStatement.setFloat(12, purchaseCementVO.getQuantity());
/*   83:  90 */       this.preparedStatement.setFloat(13, diff);
/*   84:  91 */       this.preparedStatement.setFloat(14, purchaseCementVO.getCgstAmount());
/*   85:  92 */       this.preparedStatement.setFloat(15, purchaseCementVO.getSgstAmount());
/*   86:  93 */       this.preparedStatement.setString(16, purchaseCementVO.getInvoiceNo());
/*   87:  94 */       this.preparedStatement.setString(17, purchaseCementVO.getOrderNo());
/*   88:  95 */       this.preparedStatement.setString(18, purchaseCementVO.getTransporter());
/*   89:  96 */       this.preparedStatement.setString(19, purchaseCementVO.getPaymentMode());
/*   90:  97 */       this.preparedStatement.setString(20, purchaseCementVO.getWeekNo());
/*   91:  98 */       this.preparedStatement.setString(21, purchaseCementVO.getInconterm());
/*   92:  99 */       this.preparedStatement.setFloat(22, purchaseCementVO.getPayment());
/*   93: 100 */       this.preparedStatement.setString(23, DateTimeUtil.convertToDate(purchaseCementVO.getInvoiceDate()));
/*   94:     */       
/*   95: 102 */       this.preparedStatement.setString(24, purchaseCementVO.getMaterialCode());
/*   96: 103 */       this.preparedStatement.setString(25, purchaseCementVO.getHsnCode());
/*   97: 104 */       this.preparedStatement.setString(26, purchaseCementVO.getDeliveryPlace());
/*   98: 105 */       this.preparedStatement.setFloat(27, purchaseCementVO.getUnitPrice());
/*   99: 106 */       this.preparedStatement.setFloat(28, purchaseCementVO.getDiscount());
/*  100:     */       
/*  101:     */ 
/*  102: 109 */       output = this.preparedStatement.executeUpdate();
/*  103: 111 */       if (output == 1) {
/*  104: 112 */         insertIntoDealerTansaction(purchaseCementVO);
/*  105:     */       }
/*  106:     */     }
/*  107:     */     catch (SQLException sqlException)
/*  108:     */     {
/*  109: 115 */       sqlException.printStackTrace();
/*  110: 116 */       logger.error(
/*  111: 117 */         PurchaseCementDaoImpl.class + 
/*  112: 118 */         ": Error:- Error: Occur in Query While inserting the Purchased Cement details into Database", 
/*  113: 119 */         sqlException);
/*  114:     */     }
/*  115:     */     catch (Exception exception)
/*  116:     */     {
/*  117: 122 */       exception.printStackTrace();
/*  118: 123 */       logger.error(
/*  119: 124 */         PurchaseCementDaoImpl.class + 
/*  120: 125 */         ": Error:- While closing the Connection after inserting the Purchased Cement into Database", 
/*  121: 126 */         exception);
/*  122:     */     }
/*  123:     */     finally
/*  124:     */     {
/*  125: 129 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/*  126: 130 */       JdbcHelper.closeConnection(this.connection);
/*  127:     */     }
/*  128: 132 */     return output;
/*  129:     */   }
/*  130:     */   
/*  131:     */   public List<PurchaseCementVO> retrivePurchaseCementDetailsGrid(int searchId, String searchValue)
/*  132:     */     throws RecordNotFoundException
/*  133:     */   {
/*  134: 140 */     List<PurchaseCementVO> purchaseCementDetailList = new ArrayList();
/*  135:     */     try
/*  136:     */     {
/*  137: 144 */       this.connection = getConnection();
/*  138:     */       
/*  139:     */ 
/*  140:     */ 
/*  141: 148 */       this.preparedStatement = this.connection.prepareStatement(
/*  142: 149 */         QueryBuilder.PurchaseCementAdvanceSearchForAdmin(searchId, searchValue));
/*  143:     */       
/*  144: 151 */       this.resultSet = this.preparedStatement.executeQuery();
/*  145: 155 */       while (this.resultSet.next())
/*  146:     */       {
/*  147: 156 */         this.purchaseCementVO = new PurchaseCementVO();
/*  148: 157 */         this.purchaseCementVO.setPurchaseId(this.resultSet.getInt("PUR_CEMENT_ID"));
/*  149:     */         
/*  150: 159 */         this.purchaseCementVO.setDealerName(this.nameHelper.getDealerNameById(this.resultSet.getInt("PUR_CEMENT_DEALER_REF")));
/*  151: 160 */         this.purchaseCementVO.setDealerContact(this.resultSet.getString("PUR_CEMENT_DEALER_CONTACT"));
/*  152:     */         
/*  153: 162 */         this.purchaseCementVO.setCompanyName(this.resultSet.getString("PUR_CEMENT_COMPANY_NAME"));
/*  154:     */         
/*  155: 164 */         this.purchaseCementVO.setQuantity(this.resultSet
/*  156: 165 */           .getInt("PUR_CEMENT_BAGS_NO"));
/*  157:     */         
/*  158: 167 */         this.purchaseCementVO.setInvoiceNo(this.resultSet
/*  159: 168 */           .getString("PUR_CEMENT_INVOICE_NO"));
/*  160:     */         
/*  161:     */ 
/*  162: 171 */         this.purchaseCementVO.setOrderNo(this.resultSet
/*  163: 172 */           .getString("PUR_CEMENT_ORDER_NO"));
/*  164:     */         
/*  165: 174 */         this.purchaseCementVO.setTransporter(this.resultSet
/*  166: 175 */           .getString("PUR_CEMENT_CARRIER_NAME"));
/*  167:     */         
/*  168: 177 */         this.purchaseCementVO.setInvoiceDate(this.resultSet
/*  169: 178 */           .getString("PUR_CEMENT_INVOICE_DATE"));
/*  170:     */         
/*  171: 180 */         this.purchaseCementVO.setMaterialCode(this.resultSet
/*  172: 181 */           .getString("PUR_CEMENT_MATERIAL_CODE"));
/*  173:     */         
/*  174:     */ 
/*  175: 184 */         this.purchaseCementVO.setUnitPrice(this.resultSet
/*  176: 185 */           .getFloat("PUR_CEMENT_UNIT_PRICE"));
/*  177: 186 */         this.purchaseCementVO.setNetAmount(this.resultSet
/*  178: 187 */           .getFloat("PUR_CEMENT_AMOUNT"));
/*  179: 188 */         this.purchaseCementVO.setGst(this.resultSet
/*  180: 189 */           .getFloat("PUR_CEMENT_GST"));
/*  181:     */         
/*  182:     */ 
/*  183:     */ 
/*  184: 193 */         purchaseCementDetailList.add(this.purchaseCementVO);
/*  185:     */       }
/*  186:     */     }
/*  187:     */     catch (SQLException sqlExp)
/*  188:     */     {
/*  189: 197 */       sqlExp.printStackTrace();
/*  190: 198 */       logger.error(
/*  191: 199 */         PurchaseCementDaoImpl.class + 
/*  192: 200 */         "Error: Occur in Query While Fetching the cement purchase Details into Grid from Database.", 
/*  193: 201 */         sqlExp);
/*  194:     */     }
/*  195:     */     catch (Exception exception)
/*  196:     */     {
/*  197: 203 */       exception.printStackTrace();
/*  198: 204 */       logger.error(
/*  199: 205 */         PurchaseCementDaoImpl.class + 
/*  200: 206 */         "Error: Occur in Query While Closing Connection After Fetching the cement purchase into Grid from Database.", 
/*  201: 207 */         exception);
/*  202:     */     }
/*  203:     */     finally
/*  204:     */     {
/*  205: 209 */       JdbcHelper.closeResultSet(this.resultSet);
/*  206: 210 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/*  207: 211 */       JdbcHelper.closeConnection(this.connection);
/*  208:     */     }
/*  209: 213 */     return purchaseCementDetailList;
/*  210:     */   }
/*  211:     */   
/*  212:     */   public PurchaseCement retriveSpecificPurchaseCementDetail(int purchaseId)
/*  213:     */     throws RecordNotFoundException
/*  214:     */   {
/*  215: 221 */     PurchaseCement purchaseCement = new PurchaseCement();
/*  216:     */     try
/*  217:     */     {
/*  218: 224 */       this.connection = getConnection();
/*  219:     */       
/*  220: 226 */       this.preparedStatement = this.connection
/*  221: 227 */         .prepareStatement("SELECT * FROM TAB_PURCHASE_CEMENT_DETAIL WHERE PUR_CEMENT_ID=? ");
/*  222: 228 */       this.preparedStatement.setInt(1, purchaseId);
/*  223:     */       
/*  224: 230 */       this.resultSet = this.preparedStatement.executeQuery();
/*  225: 231 */       System.out.println("----------hye ----------------");
/*  226: 232 */       if (this.resultSet != null) {
/*  227: 233 */         while (this.resultSet.next())
/*  228:     */         {
/*  229: 235 */           System.out.println("----------hye ----------------");
/*  230:     */           
/*  231: 237 */           purchaseCement.setPurchaseId(this.resultSet.getInt("PUR_CEMENT_ID"));
/*  232: 238 */           System.out.println("________________" + this.resultSet.getInt("PUR_CEMENT_ID"));
/*  233:     */           
/*  234: 240 */           purchaseCement.setCompanyName(this.resultSet.getString("PUR_CEMENT_COMPANY_NAME"));
/*  235: 241 */           System.out.println("---------" + this.resultSet.getString("PUR_CEMENT_PRICE"));
/*  236:     */           
/*  237:     */ 
/*  238:     */ 
/*  239:     */ 
/*  240:     */ 
/*  241: 247 */           purchaseCement.setNetAmount(this.resultSet
/*  242: 248 */             .getFloat("PUR_CEMENT_AMOUNT"));
/*  243:     */           
/*  244: 250 */           purchaseCement.setGst(this.resultSet
/*  245: 251 */             .getFloat("PUR_CEMENT_GST"));
/*  246:     */           
/*  247: 253 */           purchaseCement.setCgst(this.resultSet
/*  248: 254 */             .getFloat("PUR_CEMENT_CGST"));
/*  249:     */           
/*  250: 256 */           purchaseCement.setSgst(this.resultSet
/*  251: 257 */             .getFloat("PUR_CEMENT_SGST"));
/*  252:     */           
/*  253: 259 */           purchaseCement.setdFullName(this.resultSet.getString("PUR_CEMENT_DEALER_NAME"));
/*  254:     */           
/*  255: 261 */           purchaseCement.setDealerContact(this.resultSet.getString("PUR_CEMENT_DEALER_CONTACT"));
/*  256:     */           
/*  257: 263 */           purchaseCement.setDealerAddress(this.resultSet.getString("PUR_CEMENT_DEALER_ADDRESS"));
/*  258:     */           
/*  259: 265 */           purchaseCement.setDealerRef(this.resultSet.getInt("PUR_CEMENT_DEALER_REF"));
/*  260:     */           
/*  261: 267 */           purchaseCement.setQuantity(this.resultSet
/*  262: 268 */             .getInt("PUR_CEMENT_BAGS_NO"));
/*  263:     */           
/*  264:     */ 
/*  265:     */ 
/*  266:     */ 
/*  267: 273 */           purchaseCement.setGstAmount(this.resultSet
/*  268: 274 */             .getFloat("PUR_CEMENT_GST_AMOUNT"));
/*  269: 275 */           purchaseCement.setCgstAmount(this.resultSet
/*  270: 276 */             .getFloat("PUR_CEMENT_CGST_AMOUNT"));
/*  271: 277 */           purchaseCement.setSgstAmount(this.resultSet
/*  272: 278 */             .getFloat("PUR_CEMENT_SGST_AMOUNT"));
/*  273: 279 */           purchaseCement.setInvoiceNo(this.resultSet
/*  274: 280 */             .getString("PUR_CEMENT_INVOICE_NO"));
/*  275:     */           
/*  276: 282 */           purchaseCement.setOrderNo(this.resultSet
/*  277: 283 */             .getString("PUR_CEMENT_ORDER_NO"));
/*  278:     */           
/*  279: 285 */           purchaseCement.setTransporter(this.resultSet
/*  280: 286 */             .getString("PUR_CEMENT_CARRIER_NAME"));
/*  281:     */           
/*  282:     */ 
/*  283:     */ 
/*  284:     */ 
/*  285: 291 */           purchaseCement.setWeekNo(this.resultSet
/*  286: 292 */             .getString("PUR_CEMENT_WEEK_NO"));
/*  287:     */           
/*  288: 294 */           purchaseCement.setInconterm(this.nameHelper.getProductTypeNameByProductId(Integer.parseInt(this.nameHelper.getProductNameById(this.resultSet
/*  289: 295 */             .getInt("PUR_CEMENT_INCOTERM")))));
/*  290:     */           
/*  291:     */ 
/*  292:     */ 
/*  293: 299 */           purchaseCement.setInvoiceDate(this.resultSet
/*  294: 300 */             .getString("PUR_CEMENT_INVOICE_DATE"));
/*  295:     */           
/*  296: 302 */           purchaseCement.setMaterialCode(this.resultSet
/*  297: 303 */             .getString("PUR_CEMENT_MATERIAL_CODE"));
/*  298:     */           
/*  299:     */ 
/*  300: 306 */           purchaseCement.setHsnCode(this.resultSet
/*  301: 307 */             .getString("PUR_CEMENT_HSN_CODE"));
/*  302:     */           
/*  303: 309 */           purchaseCement.setDeliveryPlace(this.resultSet
/*  304: 310 */             .getString("PUR_CEMENT_DELIVERY_PLACE"));
/*  305:     */           
/*  306: 312 */           purchaseCement.setUnitPrice(this.resultSet
/*  307: 313 */             .getFloat("PUR_CEMENT_UNIT_PRICE"));

purchaseCement.setDiscount(this.resultSet
/*  307: 313 */             .getFloat("PUR_CEMENT_DISCOUNT"));
/*  308:     */         }
/*  309:     */       }
/*  310:     */     }
/*  311:     */     catch (SQLException sqlExp)
/*  312:     */     {
/*  313: 323 */       sqlExp.printStackTrace();
/*  314: 324 */       logger.error(
/*  315: 325 */         PurchaseCementDaoImpl.class + 
/*  316: 326 */         "Error: Occur in Query While Fetching the specific cement purchase Details from Database.", 
/*  317: 327 */         sqlExp);
/*  318:     */     }
/*  319:     */     catch (Exception exception)
/*  320:     */     {
/*  321: 329 */       exception.printStackTrace();
/*  322: 330 */       logger.error(
/*  323: 331 */         PurchaseCementDaoImpl.class + 
/*  324: 332 */         "Error: Occur in Query While Closing Connection After Fetching the specific cement purchase Details from Database.", 
/*  325: 333 */         exception);
/*  326:     */     }
/*  327:     */     finally
/*  328:     */     {
/*  329: 335 */       JdbcHelper.closeResultSet(this.resultSet);
/*  330: 336 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/*  331: 337 */       JdbcHelper.closeConnection(this.connection);
/*  332:     */     }
/*  333: 341 */     return purchaseCement;
/*  334:     */   }
/*  335:     */   
/*  336:     */   public int deleteSpecificCementPurchaseDetails(int purchaseId)
/*  337:     */     throws DeleteFailedException
/*  338:     */   {
/*  339: 349 */     int effect = 0;
/*  340:     */     try
/*  341:     */     {
/*  342: 351 */       this.connection = getConnection();
/*  343:     */       
/*  344: 353 */       this.preparedStatement = this.connection.prepareStatement("DELETE FROM TAB_PURCHASE_CEMENT_DETAIL WHERE PUR_CEMENT_ID=?");
/*  345:     */       
/*  346: 355 */       this.preparedStatement.setInt(1, purchaseId);
/*  347:     */       
/*  348: 357 */       effect = this.preparedStatement.executeUpdate();
/*  349:     */     }
/*  350:     */     catch (SQLException sqlException)
/*  351:     */     {
/*  352: 360 */       sqlException.printStackTrace();
/*  353: 361 */       logger.error(
/*  354: 362 */         PurchaseCementDaoImpl.class + 
/*  355: 363 */         ": Error:- Error: Occur in Query While deleting the cement purchase details record", 
/*  356: 364 */         sqlException);
/*  357:     */     }
/*  358:     */     catch (Exception exception)
/*  359:     */     {
/*  360: 366 */       exception.printStackTrace();
/*  361: 367 */       logger.error(
/*  362: 368 */         PurchaseCementDaoImpl.class + 
/*  363: 369 */         ": Error:- While closing the Connection after deleting the cement purchase details reccord", 
/*  364: 370 */         exception);
/*  365:     */     }
/*  366:     */     finally
/*  367:     */     {
/*  368: 373 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/*  369: 374 */       JdbcHelper.closeConnection(this.connection);
/*  370:     */     }
/*  371: 376 */     return effect;
/*  372:     */   }
/*  373:     */   
/*  374:     */   public PurchaseCement retriveSpecificPurchaseDetailForUpdate(int purchaseId)
/*  375:     */     throws RecordNotFoundException
/*  376:     */   {
/*  377: 384 */     PurchaseCement purchaseCement = new PurchaseCement();
/*  378: 385 */     PreparedStatement preparedStatements = null;
/*  379:     */     try
/*  380:     */     {
/*  381: 387 */       this.connection = getConnection();
/*  382:     */       
/*  383: 389 */       preparedStatements = this.connection
/*  384: 390 */         .prepareStatement("SELECT * FROM TAB_PURCHASE_CEMENT_DETAIL WHERE PUR_CEMENT_ID=?");
/*  385: 391 */       preparedStatements.setInt(1, purchaseId);
/*  386:     */       
/*  387:     */ 
/*  388:     */ 
/*  389: 395 */       this.resultSet = preparedStatements.executeQuery();
/*  390: 396 */       System.out.println("----------hye ----------------");
/*  391: 397 */       if (this.resultSet != null) {
/*  392: 398 */         while (this.resultSet.next())
/*  393:     */         {
/*  394: 400 */           System.out.println("----------hye ----------------");
/*  395:     */           
/*  396: 402 */           purchaseCement.setPurchaseId(this.resultSet.getInt("PUR_CEMENT_ID"));
/*  397: 403 */           System.out.println("________________" + this.resultSet.getInt("PUR_CEMENT_ID"));
/*  398:     */           
/*  399: 405 */           purchaseCement.setUnitPrice(this.resultSet.getFloat("PUR_CEMENT_PRICE"));
/*  400: 406 */           System.out.println("---------" + this.resultSet.getFloat("PUR_CEMENT_AMOUNT"));
/*  401:     */           
/*  402:     */ 
/*  403: 409 */           purchaseCement.setCompanyName(this.resultSet.getString("PUR_CEMENT_COMPANY_NAME"));
/*  404:     */           
/*  405: 411 */           purchaseCement.setDealerName(this.resultSet.getString("PUR_CEMENT_DEALER_REF"));
/*  406:     */           
/*  407:     */ 
/*  408:     */ 
/*  409: 415 */           purchaseCement.setGst(this.resultSet.getFloat("PUR_CEMENT_GST"));
/*  410:     */           
/*  411:     */ 
/*  412: 418 */           purchaseCement.setCgst(this.resultSet
/*  413: 419 */             .getFloat("PUR_CEMENT_CGST"));
/*  414:     */           
/*  415: 421 */           purchaseCement.setSgst(this.resultSet
/*  416: 422 */             .getFloat("PUR_CEMENT_SGST"));
/*  417:     */           
/*  418: 424 */           purchaseCement.setdFullName(this.resultSet
/*  419: 425 */             .getString("PUR_CEMENT_DEALER_NAME"));
/*  420:     */           
/*  421: 427 */           purchaseCement.setDealerContact(this.resultSet
/*  422: 428 */             .getString("PUR_CEMENT_DEALER_CONTACT"));
/*  423:     */           
/*  424: 430 */           purchaseCement.setDealerAddress(this.resultSet
/*  425: 431 */             .getString("PUR_CEMENT_DEALER_ADDRESS"));
/*  426:     */           
/*  427: 433 */           purchaseCement.setDealerRef(this.resultSet.getInt("PUR_CEMENT_DEALER_REF"));
/*  428:     */           
/*  429: 435 */           purchaseCement.setQuantity(this.resultSet.getInt("PUR_CEMENT_BAGS_NO"));
/*  430:     */           
/*  431: 437 */           purchaseCement.setQuantity(this.resultSet.getInt("PUR_CEMENT_BAGS_TON"));
/*  432:     */           
/*  433: 439 */           purchaseCement.setGstAmount(this.resultSet.getFloat("PUR_CEMENT_GST_AMOUNT"));
/*  434:     */           
/*  435: 441 */           purchaseCement.setCgstAmount(this.resultSet
/*  436: 442 */             .getFloat("PUR_CEMENT_CGST_AMOUNT"));
/*  437:     */           
/*  438: 444 */           purchaseCement.setSgstAmount(this.resultSet
/*  439: 445 */             .getFloat("PUR_CEMENT_SGST_AMOUNT"));
/*  440:     */           
/*  441:     */ 
/*  442:     */ 
/*  443: 449 */           purchaseCement.setInvoiceNo(this.resultSet
/*  444: 450 */             .getString("PUR_CEMENT_INVOICE_NO"));
/*  445: 451 */           purchaseCement.setOrderNo(this.resultSet
/*  446: 452 */             .getString("PUR_CEMENT_ORDER_NO"));
/*  447: 453 */           purchaseCement.setTransporter(this.resultSet
/*  448: 454 */             .getString("PUR_CEMENT_CARRIER_NAME"));
/*  449: 455 */           purchaseCement.setPaymentMode(this.resultSet
/*  450: 456 */             .getString("PUR_CEMENT_PAYMENT_MODE"));
/*  451: 457 */           purchaseCement.setWeekNo(this.resultSet
/*  452: 458 */             .getString("PUR_CEMENT_WEEK_NO"));
/*  453: 459 */           purchaseCement.setInconterm(this.resultSet
/*  454: 460 */             .getString("PUR_CEMENT_INCOTERM"));
/*  455: 461 */           purchaseCement.setPayment(this.resultSet
/*  456: 462 */             .getFloat("PUR_CEMENT_PAYMENT"));
/*  457: 463 */           System.out.println(this.resultSet.getDate("PUR_CEMENT_INVOICE_DATE") + "KKKKKKKKKKKKKKKKKKKKKK" + this.resultSet
/*  458: 464 */             .getFloat("PUR_CEMENT_PAYMENT"));
/*  459: 465 */           purchaseCement.setInvoiceDate(DateTimeUtil.convertDatetoFormDate(this.resultSet.getString("PUR_CEMENT_INVOICE_DATE")));
/*  460:     */           
/*  461: 467 */           purchaseCement.setMaterialCode(this.resultSet
/*  462: 468 */             .getString("PUR_CEMENT_MATERIAL_CODE"));
/*  463: 469 */           purchaseCement.setHsnCode(this.resultSet
/*  464: 470 */             .getString("PUR_CEMENT_HSN_CODE"));
/*  465: 471 */           purchaseCement.setDeliveryPlace(this.resultSet
/*  466: 472 */             .getString("PUR_CEMENT_DELIVERY_PLACE"));
/*  467: 473 */           purchaseCement.setUnitPrice(this.resultSet
/*  468: 474 */             .getFloat("PUR_CEMENT_UNIT_PRICE"));
/*  469:     */           
/*  470: 476 */           purchaseCement.setDiscount(this.resultSet
/*  471: 477 */             .getFloat("PUR_CEMENT_DISCOUNT"));
/*  472:     */           
/*  473: 479 */           purchaseCement.setNetAmount(this.resultSet
/*  474: 480 */             .getFloat("PUR_CEMENT_AMOUNT"));
/*  475:     */           
/*  476: 482 */           System.out.println("BHARTI" + this.resultSet.getFloat("PUR_CEMENT_GST") + this.resultSet.getInt("PUR_CEMENT_AMOUNT") + this.resultSet.getString("PUR_CEMENT_AMOUNT") + "%%%%%%%%%%%%%%%");
/*  477:     */         }
/*  478:     */       }
/*  479: 490 */       purchaseCement = retriveSpecificDealerTransactionForUpdate(purchaseCement);
/*  480: 491 */       System.out.println(purchaseCement.getTotal() + "total" + purchaseCement.getTransactionId() + "bill NoGGGGGggggg");
/*  481:     */     }
/*  482:     */     catch (SQLException sqlExp)
/*  483:     */     {
/*  484: 493 */       sqlExp.printStackTrace();
/*  485: 494 */       logger.error(
/*  486: 495 */         PurchaseCementDaoImpl.class + 
/*  487: 496 */         "Error: Occur in Query While Fetching the specific cement purchase Details from Database For Update.", 
/*  488: 497 */         sqlExp);
/*  489:     */     }
/*  490:     */     catch (Exception exception)
/*  491:     */     {
/*  492: 499 */       exception.printStackTrace();
/*  493: 500 */       logger.error(
/*  494: 501 */         PurchaseCementDaoImpl.class + 
/*  495: 502 */         "Error: Occur in Query While Closing Connection After Fetching the specific cement purchase Details from Database For Update.", 
/*  496: 503 */         exception);
/*  497:     */     }
/*  498:     */     finally
/*  499:     */     {
/*  500: 505 */       JdbcHelper.closeResultSet(this.resultSet);
/*  501: 506 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/*  502: 507 */       JdbcHelper.closeConnection(this.connection);
/*  503:     */     }
/*  504: 511 */     return purchaseCement;
/*  505:     */   }
/*  506:     */   
/*  507:     */   public PurchaseCement retriveSpecificDealerTransactionForUpdate(PurchaseCement purchaseCement2)
/*  508:     */     throws RecordNotFoundException
/*  509:     */   {
/*  510:     */     try
/*  511:     */     {
/*  512: 519 */       this.connection = getConnection();
/*  513: 520 */       PreparedStatement preparedStatements = this.connection
/*  514: 521 */         .prepareStatement("SELECT * FROM TAB_DEALER_OWNER_TRANSACTION WHERE DEALER_TRANS_BILL_NO=?");
/*  515: 522 */       preparedStatements.setString(1, purchaseCement2.getInvoiceNo());
/*  516: 523 */       this.resultSet = preparedStatements.executeQuery();
/*  517: 524 */       System.out.println("----------hye ----------------" + purchaseCement2.getInvoiceNo() + "invoice bill no");
/*  518: 525 */       if (this.resultSet != null) {
/*  519: 526 */         while (this.resultSet.next())
/*  520:     */         {
/*  521: 528 */           System.out.println("----------hye ----------------");
/*  522: 529 */           setDealerTransactionId(this.resultSet.getInt("DEALER_TRANS_ID"));
/*  523: 530 */           purchaseCement2.setTransactionId(this.resultSet.getInt("DEALER_TRANS_ID"));
/*  524: 531 */           System.out.println("________________" + this.resultSet.getInt("DEALER_TRANS_ID") + "hhh" + this.dealerTransactionId);
/*  525: 532 */           purchaseCement2.setTotal(this.resultSet.getFloat("DEALER_TRANS_TOTAL"));
/*  526: 533 */           purchaseCement2.setPaid(this.resultSet.getFloat("DEALER_TRANS_PAID"));
/*  527: 534 */           purchaseCement2.setDue(this.resultSet.getFloat("DEALER_TRANS_DUE"));
/*  528: 535 */           purchaseCement2.setTotalPaid(this.resultSet.getFloat("DEALER_TRANS_TOTAL_PAID"));
/*  529: 536 */           purchaseCement2.setTotalDue(this.resultSet.getFloat("DEALER_TRANS_TOTAL_DUE"));
/*  530: 537 */           purchaseCement2.setTransactionBillNo(this.resultSet.getString("DEALER_TRANS_BILL_NO"));
/*  531: 538 */           purchaseCement2.setRetailerId(this.resultSet.getInt("DEALER_ID_REF"));
/*  532:     */         }
/*  533:     */       }
/*  534:     */     }
/*  535:     */     catch (SQLException sqlExp)
/*  536:     */     {
/*  537: 551 */       sqlExp.printStackTrace();
/*  538: 552 */       logger.error(
/*  539: 553 */         PurchaseCementDaoImpl.class + 
/*  540: 554 */         "Error: Occur in Query While Fetching the specific cement purchase cement transaction from Database For Update.", 
/*  541: 555 */         sqlExp);
/*  542:     */     }
/*  543:     */     catch (Exception exception)
/*  544:     */     {
/*  545: 557 */       exception.printStackTrace();
/*  546: 558 */       logger.error(
/*  547: 559 */         PurchaseCementDaoImpl.class + 
/*  548: 560 */         "Error: Occur in Query While Closing Connection After Fetching the specific cement purchase transaction from Database For Update.", 
/*  549: 561 */         exception);
/*  550:     */     }
/*  551:     */     finally
/*  552:     */     {
/*  553: 563 */       JdbcHelper.closeResultSet(this.resultSet);
/*  554: 564 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/*  555: 565 */       JdbcHelper.closeConnection(this.connection);
/*  556:     */     }
/*  557: 569 */     return purchaseCement2;
/*  558:     */   }
/*  559:     */   
/*  560:     */   public void updateSpecificPurchaseRecord(PurchaseCementVO purchaseCementVO, int purchaseId, int transactionId)
/*  561:     */     throws UpdateFailedException
/*  562:     */   {
/*  563: 576 */     Connection connection = null;
/*  564: 577 */     PreparedStatement preparedStatement = null;
/*  565: 578 */     System.out.println("update is running************************");
/*  566:     */     try
/*  567:     */     {
/*  568: 581 */       String up = "UPDATE TAB_PURCHASE_CEMENT_DETAIL SET PUR_CEMENT_COMPANY_NAME=?, PUR_CEMENT_PRICE=?, PUR_CEMENT_AMOUNT=?,PUR_CEMENT_GST=?, PUR_CEMENT_CGST=?, PUR_CEMENT_SGST=?, PUR_CEMENT_DEALER_NAME=?, PUR_CEMENT_DEALER_CONTACT=?, PUR_CEMENT_DEALER_ADDRESS=?, PUR_CEMENT_DEALER_REF=?, PUR_CEMENT_BAGS_NO=?, PUR_CEMENT_BAGS_TON=?, PUR_CEMENT_GST_AMOUNT=?, PUR_CEMENT_CGST_AMOUNT=?, PUR_CEMENT_SGST_AMOUNT=?, PUR_CEMENT_INVOICE_NO=?, PUR_CEMENT_ORDER_NO=?, PUR_CEMENT_CARRIER_NAME=?, PUR_CEMENT_PAYMENT_MODE=?, PUR_CEMENT_WEEK_NO=?, PUR_CEMENT_INCOTERM=?, PUR_CEMENT_PAYMENT=?,PUR_CEMENT_INVOICE_DATE=?, PUR_CEMENT_MATERIAL_CODE=?, PUR_CEMENT_HSN_CODE=?, PUR_CEMENT_DELIVERY_PLACE=?, PUR_CEMENT_UNIT_PRICE=?, PUR_CEMENT_DISCOUNT=?WHERE PUR_CEMENT_ID=?";
/*  569:     */       
/*  570:     */ 
/*  571:     */ 
/*  572:     */ 
/*  573:     */ 
/*  574: 587 */       System.out.println("fffffffffffffffffffffF" + purchaseId);
/*  575:     */       
/*  576: 589 */       connection = getConnection();
/*  577: 590 */       preparedStatement = connection.prepareStatement(up);
/*  578: 591 */       preparedStatement.setString(1, purchaseCementVO.getCompanyName());
/*  579: 592 */       preparedStatement.setFloat(2, purchaseCementVO.getUnitPrice());
/*  580: 593 */       preparedStatement.setFloat(3, purchaseCementVO.getNetAmount());
/*  581: 594 */       preparedStatement.setFloat(4, purchaseCementVO.getGst());
/*  582: 595 */       preparedStatement.setFloat(5, purchaseCementVO.getCgst());
/*  583: 596 */       preparedStatement.setFloat(6, purchaseCementVO.getSgst());
/*  584: 597 */       preparedStatement.setString(7, this.nameHelper.getDealerNameById(Integer.parseInt(purchaseCementVO.getDealerName())));
/*  585: 598 */       preparedStatement.setString(8, purchaseCementVO.getDealerContact());
/*  586: 599 */       preparedStatement.setString(9, purchaseCementVO.getDealerAddress());
/*  587: 600 */       preparedStatement.setString(10, purchaseCementVO.getDealerName());
/*  588: 601 */       preparedStatement.setFloat(11, purchaseCementVO.getQuantity());
/*  589:     */       
/*  590: 603 */       preparedStatement.setFloat(12, purchaseCementVO.getQuantity());
/*  591: 604 */       preparedStatement.setFloat(13, purchaseCementVO.getGst());
/*  592:     */       
/*  593: 606 */       preparedStatement.setFloat(14, purchaseCementVO.getCgstAmount());
/*  594: 607 */       preparedStatement.setFloat(15, purchaseCementVO.getSgstAmount());
/*  595: 608 */       preparedStatement.setString(16, purchaseCementVO.getInvoiceNo());
/*  596: 609 */       preparedStatement.setString(17, purchaseCementVO.getOrderNo());
/*  597: 610 */       preparedStatement.setString(18, purchaseCementVO.getTransporter());
/*  598: 611 */       preparedStatement.setString(19, purchaseCementVO.getPaymentMode());
/*  599: 612 */       preparedStatement.setString(20, purchaseCementVO.getWeekNo());
/*  600: 613 */       preparedStatement.setString(21, purchaseCementVO.getInconterm());
/*  601: 614 */       preparedStatement.setFloat(22, purchaseCementVO.getPayment());
/*  602:     */       
/*  603:     */ 
/*  604:     */ 
/*  605: 618 */       preparedStatement.setString(23, DateTimeUtil.convertToDate(purchaseCementVO.getInvoiceDate()));
/*  606: 619 */       preparedStatement.setString(24, purchaseCementVO.getMaterialCode());
/*  607: 620 */       preparedStatement.setString(25, purchaseCementVO.getHsnCode());
/*  608: 621 */       preparedStatement.setString(26, purchaseCementVO.getDeliveryPlace());
/*  609: 622 */       preparedStatement.setFloat(27, purchaseCementVO.getUnitPrice());
/*  610: 623 */       preparedStatement.setFloat(28, purchaseCementVO.getDiscount());
/*  611:     */       
/*  612: 625 */       preparedStatement.setFloat(29, purchaseId);
/*  613:     */       
/*  614: 627 */       System.out.println("trans id is******" + purchaseCementVO.getTransactionId() + " purchaseCementVO.getPayment()" + purchaseCementVO.getPayment());
/*  615: 628 */       int effect = preparedStatement.executeUpdate();
/*  616: 629 */       if (effect == 1) {
/*  617: 630 */         updateSpecificDealerTransaction(purchaseCementVO, transactionId);
/*  618:     */       } else {
/*  619: 632 */         logger.info("INFO: Can Not Update purchase Details & Dealer Transaction.");
/*  620:     */       }
/*  621:     */     }
/*  622:     */     catch (SQLException sqlExp)
/*  623:     */     {
/*  624: 637 */       sqlExp.printStackTrace();
/*  625: 638 */       logger.error(
/*  626: 639 */         PurchaseCementDaoImpl.class + 
/*  627: 640 */         "Error: Occur in Query While updating the specific cement purchase Details.", 
/*  628: 641 */         sqlExp);
/*  629:     */     }
/*  630:     */     catch (Exception exception)
/*  631:     */     {
/*  632: 643 */       exception.printStackTrace();
/*  633: 644 */       logger.error(
/*  634: 645 */         PurchaseCementDaoImpl.class + 
/*  635: 646 */         "Error: Occur in Query While Closing Connection After updating the specific cement purchase Details.", 
/*  636: 647 */         exception);
/*  637:     */     }
/*  638:     */     finally
/*  639:     */     {
/*  640: 649 */       JdbcHelper.closeResultSet(this.resultSet);
/*  641: 650 */       JdbcHelper.closePreparedStatement(preparedStatement);
/*  642: 651 */       JdbcHelper.closeConnection(connection);
/*  643:     */     }
/*  644:     */   }
/*  645:     */   
/*  646:     */   public void updateSpecificDealerTransaction(PurchaseCementVO purchaseCementVO2, int transactionId)
/*  647:     */   {
/*  648: 663 */     Connection connection = null;
/*  649: 664 */     PreparedStatement preparedStatement = null;
/*  650:     */     
/*  651:     */ 
/*  652:     */ 
/*  653: 668 */     System.out.println(purchaseCementVO2.getTransactionId() + "update is running transaction************************" + transactionId);
/*  654: 669 */     String up = "UPDATE TAB_DEALER_OWNER_TRANSACTION SET DEALER_TRANS_TOTAL=?,DEALER_TRANS_PAID=?,DEALER_TRANS_DUE=?,DEALER_TRANS_TOTAL_PAID=?,DEALER_TRANS_TOTAL_DUE=?,DEALER_ID_REF=?,DEALER_TRANS_DATE=?,DEALER_TANS_PAYMENT_MODE=?WHERE DEALER_TRANS_ID=?";
/*  655:     */     
/*  656:     */ 
/*  657:     */ 
/*  658: 673 */     float dDueUpdate = purchaseCementVO2.getNetAmount() - purchaseCementVO2.getPayment();
/*  659: 674 */     System.out.println(purchaseCementVO2.getNetAmount() + " " + purchaseCementVO2.getPayment() + "hello we are in transaction update" + transactionId + " " + purchaseCementVO2.getTotalPaid() + " " + purchaseCementVO2.getTotalDue() + " " + purchaseCementVO2.getTotal() + " " + purchaseCementVO2.getPaid() + " " + purchaseCementVO2.getDue());
/*  660:     */     float dTotalDueUpdate;
/*  661:     */     float dTotalPaidUpdate;
/*  662:     */    
/*  663: 675 */     if ((purchaseCementVO2.getTotalPaid() == 0.0F) && (purchaseCementVO2.getTotalDue() == 0.0F))
/*  664:     */     {
/*  665: 676 */       float tp = 0.0F;
/*  666: 677 */       float td = 0.0F;
/*  667: 678 */        dTotalPaidUpdate = 0.0F;
/*  668: 679 */       dTotalDueUpdate = 0.0F;
/*  669:     */     }
/*  670:     */     else
/*  671:     */     {
/*  672: 681 */       float tp = purchaseCementVO2.getTotalPaid();
/*  673: 682 */       float td = purchaseCementVO2.getTotalDue();
/*  674: 683 */       dTotalPaidUpdate = tp - purchaseCementVO2.getPaid() + purchaseCementVO2.getPayment();
/*  675: 684 */       dTotalDueUpdate = td - purchaseCementVO2.getDue() + dDueUpdate;
/*  676:     */     }
/*  677: 687 */     float totalPresent = purchaseCementVO2.getUnitPrice() * purchaseCementVO2.getQuantity();
/*  678:     */     try
/*  679:     */     {
/*  680: 690 */       System.out.println();
/*  681: 691 */       connection = getConnection();
/*  682: 692 */       preparedStatement = connection.prepareStatement(up);
/*  683: 693 */       System.out.println("code is going to be run" + transactionId + "hhh" + purchaseCementVO2.getTransactionId() + "totalPresent" + totalPresent + "dDueUpdate" + dDueUpdate + "dTotalPaidUpdate" + dTotalDueUpdate + "dTotalPaidUpdate" + dTotalPaidUpdate + purchaseCementVO2.getTransactionDate());
/*  684: 694 */       preparedStatement.setFloat(1, purchaseCementVO2.getNetAmount());
/*  685: 695 */       preparedStatement.setFloat(2, purchaseCementVO2.getPayment());
/*  686: 696 */       preparedStatement.setFloat(3, dDueUpdate);
/*  687: 697 */       preparedStatement.setFloat(4, dTotalPaidUpdate);
/*  688: 698 */       preparedStatement.setFloat(5, dTotalDueUpdate);
/*  689: 699 */       preparedStatement.setString(6, purchaseCementVO2.getDealerName());
/*  690: 700 */       preparedStatement.setString(7, DateTimeUtil.convertToDate(purchaseCementVO2.getInvoiceDate()));
/*  691: 701 */       preparedStatement.setString(8, purchaseCementVO2.getPaymentMode());
/*  692: 702 */       preparedStatement.setInt(9, transactionId);
/*  693:     */       
/*  694: 704 */       System.out.println("ha ha my tran updated");
/*  695: 705 */       preparedStatement.executeUpdate();
/*  696:     */     }
/*  697:     */     catch (SQLException sqlExp)
/*  698:     */     {
/*  699: 708 */       sqlExp.printStackTrace();
/*  700: 709 */       logger.error(
/*  701: 710 */         PurchaseCementDaoImpl.class + 
/*  702: 711 */         "Error: Occur in Query While Fetching the specific cement purchase Transaction from Database For Update.", 
/*  703: 712 */         sqlExp);
/*  704:     */     }
/*  705:     */     catch (Exception exception)
/*  706:     */     {
/*  707: 714 */       exception.printStackTrace();
/*  708: 715 */       logger.error(
/*  709: 716 */         PurchaseCementDaoImpl.class + 
/*  710: 717 */         "Error: Occur in Query While Closing Connection After Fetching the specific cement purchase Details from Database For Update.", 
/*  711: 718 */         exception);
/*  712:     */     }
/*  713:     */     finally
/*  714:     */     {
/*  715: 721 */       JdbcHelper.closePreparedStatement(preparedStatement);
/*  716: 722 */       JdbcHelper.closeConnection(connection);
/*  717:     */     }
/*  718:     */   }
/*  719:     */   
/*  720:     */   public void purchasePDF(HttpServletRequest request, HttpServletResponse response, int purchaseId)
/*  721:     */   {
/*  722: 731 */     String companyName = "Chouksay Traders";
/*  723: 732 */     String address1 = "BUS STAND SHAMSHABAD, DIST.- VIDISHA, MADHYA PRADESH, 464001";
/*  724: 733 */     String address2 = "GSTIN: 23AJQPC8200P1Z1";
/*  725: 734 */     String address3 = "PAN NO: AJQPC8200P";
/*  726:     */     
/*  727: 736 */     String city = "Vidisha-464001";
/*  728: 737 */     String state = "(M.P.)";
/*  729: 738 */     StringBuffer stringBuffer = null;
/*  730:     */     try
/*  731:     */     {
/*  732: 742 */       this.connection = getConnection();
/*  733:     */       
/*  734: 744 */       this.preparedStatement = this.connection
/*  735: 745 */         .prepareStatement("SELECT * FROM TAB_PURCHASE_CEMENT_DETAIL WHERE PUR_CEMENT_ID=? ");
/*  736: 746 */       this.preparedStatement.setInt(1, purchaseId);
/*  737: 747 */       this.resultSet = this.preparedStatement.executeQuery();
/*  738:     */       
/*  739: 749 */       System.out.println("VVVVVVVVVVVVVVVVVVVVV" + purchaseId);
/*  740:     */       
/*  741: 751 */       Document document = new Document(PageSize.A4);
/*  742:     */       
/*  743: 753 */       Font Font3 = new Font(Font.FontFamily.TIMES_ROMAN, 11.0F, 0);
/*  744: 754 */       Font Font2 = new Font(Font.FontFamily.TIMES_ROMAN, 6.0F, 
/*  745: 755 */         8);
/*  746: 756 */       Font Font4 = new Font(Font.FontFamily.TIMES_ROMAN, 11.0F, 1);
/*  747: 757 */       Font4.setColor(BaseColor.WHITE);
/*  748: 758 */       Font mainContent = new Font(Font.FontFamily.TIMES_ROMAN, 10.0F, 
/*  749: 759 */         0);
/*  750: 760 */       Font Font5 = new Font(Font.FontFamily.TIMES_ROMAN, 12.0F, 1);
/*  751: 761 */       Font5.setColor(BaseColor.GRAY);
/*  752: 762 */       Font Font6 = new Font(Font.FontFamily.TIMES_ROMAN, 10.0F, 1);
/*  753: 763 */       Font6.setColor(BaseColor.RED);
/*  754:     */       
/*  755:     */ 
/*  756: 766 */       response.setContentType("application/pdf");
/*  757:     */       
/*  758: 768 */       PdfWriter.getInstance(document, response.getOutputStream());
/*  759:     */       System.out.println("document"+document+"response.getOutputStream()"+response.getOutputStream());
/*  760: 770 */       document.open();
/*  761:     */       
/*  762: 772 */       String contextPath = ServletActionContext.getServletContext()
/*  763: 773 */         .getRealPath("/outer/img/rohittraders.png");
/*  764: 774 */       this.image = Image.getInstance(contextPath);
/*  765: 775 */       this.image.scaleToFit(130.0F, 70.0F);
/*  766:     */       
/*  767: 777 */       PdfPTable table1 = new PdfPTable(2);
/*  768: 778 */       table1.setWidthPercentage(100.0F);
/*  769: 779 */       Rectangle rect1 = new Rectangle(300.0F, 700.0F);
/*  770: 780 */       table1.setWidthPercentage(new float[] { 150.0F, 150.0F }, rect1);
/*  771:     */       
/*  772: 782 */       PdfPCell cell101 = new PdfPCell(this.image, false);
/*  773: 783 */       cell101.setPaddingTop(5.0F);
/*  774: 784 */       cell101.setBorder(0);
/*  775:     */       
/*  776: 786 */       Phrase phrase3 = new Phrase(companyName + "\n", Font5);
/*  777: 787 */       Phrase phrase = new Phrase(address1 + "\n", Font3);
/*  778: 788 */       Phrase phrase1 = new Phrase(address2 + "\n", Font3);
/*  779: 789 */       Phrase phrase4 = new Phrase(address3 + "\n", Font3);
/*  780: 790 */       Phrase phrase2 = new Phrase(city + "-" + state, Font3);
/*  781:     */       
/*  782: 792 */       Paragraph paragraph = new Paragraph();
/*  783: 793 */       paragraph.add(phrase3);
/*  784: 794 */       paragraph.add(phrase);
/*  785: 795 */       paragraph.add(phrase1);
/*  786: 796 */       paragraph.add(phrase4);
/*  787: 797 */       paragraph.add(phrase2);
/*  788:     */       
/*  789: 799 */       PdfPCell cell102 = new PdfPCell(paragraph);
/*  790: 800 */       cell102.setPaddingTop(5.0F);
/*  791: 801 */       cell102.setBorder(0);
/*  792: 802 */       cell102.setHorizontalAlignment(2);
/*  793:     */       
/*  794: 804 */       PdfPCell cell103 = new PdfPCell(
/*  795: 805 */         new Paragraph(
/*  796: 806 */         "   \n                                                                                                                                                                                                                                                                                                                                                  ", 
/*  797:     */         
/*  798:     */ 
/*  799: 809 */         Font2));
/*  800: 810 */       cell103.setColspan(2);
/*  801: 811 */       cell103.setBorderWidthRight(0.0F);
/*  802: 812 */       cell103.setBorderWidthLeft(0.0F);
/*  803: 813 */       cell103.setBorderWidthTop(0.5F);
/*  804: 814 */       cell103.setBorderWidthBottom(0.0F);
/*  805: 815 */       cell103.setBorderColorTop(BaseColor.WHITE);
/*  806:     */       
/*  807: 817 */       PdfPCell cell104 = new PdfPCell(new Paragraph("PURCHASE REPORT", Font4));
/*  808: 818 */       cell104.setUseBorderPadding(true);
/*  809: 819 */       cell104.setColspan(2);
/*  810: 820 */       cell104.setBorderWidthRight(0.1F);
/*  811: 821 */       cell104.setBorderWidthLeft(0.1F);
/*  812: 822 */       cell104.setBorderWidthTop(0.1F);
/*  813: 823 */       cell104.setBorderWidthBottom(0.1F);
/*  814: 824 */       cell104.setBorderColor(BaseColor.LIGHT_GRAY);
/*  815: 825 */       cell104.setBackgroundColor(new BaseColor(0, 59, 119));
/*  816:     */       
/*  817: 827 */       table1.addCell(cell101);
/*  818: 828 */       table1.addCell(cell102);
/*  819: 829 */       table1.addCell(cell103);
/*  820: 830 */       table1.addCell(cell104);
/*  821: 831 */       document.add(table1);
/*  822: 837 */       while (this.resultSet.next())
/*  823:     */       {
/*  824: 838 */         stringBuffer = new StringBuffer();
/*  825: 839 */         PdfPTable table = new PdfPTable(2);
/*  826: 840 */         table.setFooterRows(1);
/*  827: 841 */         table.setWidthPercentage(100.0F);
/*  828: 842 */         Rectangle rect = new Rectangle(300.0F, 700.0F);
/*  829: 843 */         table.setWidthPercentage(new float[] { 80.0F, 220.0F }, rect);
/*  830:     */         
/*  831: 845 */         PdfPCell cell = new PdfPCell(new Paragraph());
/*  832: 846 */         cell.setColspan(2);
/*  833: 847 */         cell.setBorderWidthRight(0.1F);
/*  834: 848 */         cell.setBorderWidthLeft(0.1F);
/*  835: 849 */         cell.setBorderWidthTop(0.1F);
/*  836: 850 */         cell.setBorderWidthBottom(0.2F);
/*  837: 851 */         cell.setBorderColor(BaseColor.LIGHT_GRAY);
/*  838: 852 */         cell.setBackgroundColor(new BaseColor(238, 238, 238));
/*  839:     */         
/*  840: 854 */         PdfPCell cell1 = new PdfPCell(new Paragraph());
/*  841: 855 */         cell1.setBackgroundColor(new BaseColor(238, 238, 238));
/*  842: 856 */         cell1.setBorderWidth(0.01F);
/*  843: 857 */         cell1.setBorderColor(BaseColor.WHITE);
/*  844:     */         
/*  845: 859 */         PdfPCell cell2 = new PdfPCell(new Paragraph());
/*  846: 860 */         cell2.setBackgroundColor(new BaseColor(238, 238, 238));
/*  847: 861 */         cell2.setBorderWidth(0.2F);
/*  848: 862 */         cell2.setBorderColor(BaseColor.WHITE);
/*  849:     */         
/*  850: 864 */         PdfPCell cell3 = new PdfPCell(new Paragraph("Purchase Id", 
/*  851: 865 */           mainContent));
/*  852: 866 */         cell3.setBackgroundColor(new BaseColor(238, 238, 238));
/*  853: 867 */         cell3.setBorderWidth(0.01F);
/*  854: 868 */         cell3.setBorderColor(BaseColor.WHITE);
/*  855:     */         
/*  856: 870 */         PdfPCell cell4 = new PdfPCell(new Paragraph(this.resultSet.getString("PUR_CEMENT_ID"), mainContent));
/*  857: 871 */         cell4.setBorderWidth(0.2F);
/*  858: 872 */         cell4.setBorderColor(BaseColor.LIGHT_GRAY);
/*  859:     */         
/*  860: 874 */         PdfPCell cell5 = new PdfPCell(new Paragraph(
/*  861: 875 */           "Company Name", mainContent));
/*  862: 876 */         cell5.setBackgroundColor(new BaseColor(238, 238, 238));
/*  863: 877 */         cell5.setBorderWidth(0.01F);
/*  864: 878 */         cell5.setBorderColor(BaseColor.WHITE);
/*  865:     */         
/*  866: 880 */         PdfPCell cell6 = new PdfPCell(new Paragraph(this.resultSet.getString("PUR_CEMENT_COMPANY_NAME"), mainContent));
/*  867: 881 */         cell6.setBorderWidth(0.2F);
/*  868: 882 */         cell6.setBorderColor(BaseColor.LIGHT_GRAY);
/*  869:     */         
/*  870: 884 */         PdfPCell cell7 = new PdfPCell(new Paragraph("Price", 
/*  871: 885 */           mainContent));
/*  872: 886 */         cell7.setBackgroundColor(new BaseColor(238, 238, 238));
/*  873: 887 */         cell7.setBorderWidth(0.01F);
/*  874: 888 */         cell7.setBorderColor(BaseColor.WHITE);
/*  875:     */         
/*  876: 890 */         PdfPCell cell8 = new PdfPCell(new Paragraph(
/*  877: 891 */           this.resultSet.getString("PUR_CEMENT_PRICE"), mainContent));
/*  878: 892 */         cell8.setBorderWidth(0.2F);
/*  879: 893 */         cell8.setBorderColor(BaseColor.LIGHT_GRAY);
/*  880:     */         
/*  881:     */ 
/*  882:     */ 
/*  883: 897 */         PdfPCell cell9 = new PdfPCell(new Paragraph("Amount", 
/*  884: 898 */           mainContent));
/*  885: 899 */         cell9.setBorderWidth(0.2F);
/*  886: 900 */         cell9.setBorderColor(BaseColor.LIGHT_GRAY);
/*  887:     */         
/*  888: 902 */         PdfPCell cell10 = new PdfPCell(new Paragraph(
/*  889: 903 */           this.resultSet.getString("PUR_CEMENT_AMOUNT"), mainContent));
/*  890: 904 */         cell10.setBorderWidth(0.2F);
/*  891: 905 */         cell10.setBorderColor(BaseColor.LIGHT_GRAY);
/*  892:     */         
/*  893: 907 */         PdfPCell cell11 = new PdfPCell(new Paragraph("GST", 
/*  894: 908 */           mainContent));
/*  895: 909 */         cell11.setBackgroundColor(new BaseColor(238, 238, 238));
/*  896: 910 */         cell11.setBorderWidth(0.01F);
/*  897: 911 */         cell11.setBorderColor(BaseColor.WHITE);
/*  898:     */         
/*  899: 913 */         PdfPCell cell12 = new PdfPCell(new Paragraph(this.resultSet.getString("PUR_CEMENT_GST"), mainContent));
/*  900: 914 */         cell12.setBorderWidth(0.2F);
/*  901: 915 */         cell12.setBorderColor(BaseColor.LIGHT_GRAY);
/*  902:     */         
/*  903: 917 */         PdfPCell cell13 = new PdfPCell(new Paragraph("CGST", 
/*  904: 918 */           mainContent));
/*  905: 919 */         cell13.setBackgroundColor(new BaseColor(238, 238, 238));
/*  906: 920 */         cell13.setBorderWidth(0.01F);
/*  907: 921 */         cell13.setBorderColor(BaseColor.WHITE);
/*  908:     */         
/*  909: 923 */         PdfPCell cell14 = new PdfPCell(new Paragraph(this.resultSet.getString("PUR_CEMENT_CGST"), mainContent));
/*  910: 924 */         cell14.setBorderWidth(0.2F);
/*  911: 925 */         cell14.setBorderColor(BaseColor.LIGHT_GRAY);
/*  912:     */         
/*  913: 927 */         PdfPCell cell15 = new PdfPCell(new Paragraph(
/*  914: 928 */           "SGST", mainContent));
/*  915: 929 */         cell15.setBackgroundColor(new BaseColor(238, 238, 238));
/*  916: 930 */         cell15.setBorderWidth(0.01F);
/*  917: 931 */         cell15.setBorderColor(BaseColor.WHITE);
/*  918:     */         
/*  919: 933 */         PdfPCell cell16 = new PdfPCell(new Paragraph(this.resultSet.getString("PUR_CEMENT_SGST"), mainContent));
/*  920: 934 */         cell16.setBorderWidth(0.2F);
/*  921: 935 */         cell16.setBorderColor(BaseColor.LIGHT_GRAY);
/*  922:     */         
/*  923: 937 */         PdfPCell cell17 = new PdfPCell(new Paragraph("Dealer Name", 
/*  924: 938 */           mainContent));
/*  925: 939 */         cell17.setBackgroundColor(new BaseColor(238, 238, 238));
/*  926: 940 */         cell17.setBorderWidth(0.01F);
/*  927: 941 */         cell17.setBorderColor(BaseColor.WHITE);
/*  928:     */         
/*  929: 943 */         PdfPCell cell18 = new PdfPCell(new Paragraph(this.resultSet.getString("PUR_CEMENT_DEALER_NAME"), mainContent));
/*  930: 944 */         cell18.setBorderWidth(0.2F);
/*  931: 945 */         cell18.setBorderColor(BaseColor.LIGHT_GRAY);
/*  932:     */         
/*  933: 947 */         PdfPCell cell19 = new PdfPCell(new Paragraph("Dealer Address", 
/*  934: 948 */           mainContent));
/*  935: 949 */         cell19.setBackgroundColor(new BaseColor(238, 238, 238));
/*  936: 950 */         cell19.setBorderWidth(0.01F);
/*  937: 951 */         cell19.setBorderColor(BaseColor.WHITE);
/*  938:     */         
/*  939: 953 */         PdfPCell cell20 = new PdfPCell(new Paragraph(this.resultSet.getString("PUR_CEMENT_DEALER_ADDRESS"), mainContent));
/*  940: 954 */         cell20.setBorderWidth(0.2F);
/*  941: 955 */         cell20.setBorderColor(BaseColor.LIGHT_GRAY);
/*  942:     */         
/*  943: 957 */         PdfPCell cell21 = new PdfPCell(new Paragraph("Dealer Contact", 
/*  944: 958 */           mainContent));
/*  945: 959 */         cell21.setBackgroundColor(new BaseColor(238, 238, 238));
/*  946: 960 */         cell21.setBorderWidth(0.01F);
/*  947: 961 */         cell21.setBorderColor(BaseColor.WHITE);
/*  948:     */         
/*  949: 963 */         PdfPCell cell22 = new PdfPCell(new Paragraph(this.resultSet.getString("PUR_CEMENT_DEALER_CONTACT"), mainContent));
/*  950: 964 */         cell22.setBorderWidth(0.2F);
/*  951: 965 */         cell22.setBorderColor(BaseColor.LIGHT_GRAY);
/*  952:     */         
/*  953: 967 */         PdfPCell cell23 = new PdfPCell(new Paragraph(
/*  954: 968 */           "Dealer Reference", mainContent));
/*  955: 969 */         cell23.setBackgroundColor(new BaseColor(238, 238, 238));
/*  956: 970 */         cell23.setBorderWidth(0.01F);
/*  957: 971 */         cell23.setBorderColor(BaseColor.WHITE);
/*  958:     */         
/*  959: 973 */         PdfPCell cell24 = new PdfPCell(
/*  960: 974 */           new Paragraph(this.resultSet.getString(
/*  961: 975 */           "PUR_CEMENT_DEALER_REF"), 
/*  962: 976 */           mainContent));
/*  963: 977 */         cell24.setBorderWidth(0.2F);
/*  964: 978 */         cell24.setBorderColor(BaseColor.LIGHT_GRAY);
/*  965:     */         
/*  966: 980 */         PdfPCell cell25 = new PdfPCell(new Paragraph("No. of Bags", 
/*  967: 981 */           mainContent));
/*  968: 982 */         cell25.setBackgroundColor(new BaseColor(238, 238, 238));
/*  969: 983 */         cell25.setBorderWidth(0.01F);
/*  970: 984 */         cell25.setBorderColor(BaseColor.WHITE);
/*  971:     */         
/*  972: 986 */         PdfPCell cell26 = new PdfPCell(new Paragraph(
/*  973: 987 */           this.resultSet.getString("PUR_CEMENT_BAGS_NO"), mainContent));
/*  974: 988 */         cell26.setBorderWidth(0.2F);
/*  975: 989 */         cell26.setBorderColor(BaseColor.LIGHT_GRAY);
/*  976:     */         
/*  977: 991 */         PdfPCell cell27 = new PdfPCell(new Paragraph("Bags In Ton", 
/*  978: 992 */           mainContent));
/*  979: 993 */         cell27.setBackgroundColor(new BaseColor(238, 238, 238));
/*  980: 994 */         cell27.setBorderWidth(0.01F);
/*  981: 995 */         cell27.setBorderColor(BaseColor.WHITE);
/*  982:     */         
/*  983: 997 */         PdfPCell cell28 = new PdfPCell(new Paragraph(
/*  984: 998 */           this.resultSet
/*  985: 999 */           .getString("PUR_CEMENT_BAGS_TON"), mainContent));
/*  986:1000 */         cell28.setBorderWidth(0.2F);
/*  987:1001 */         cell28.setBorderColor(BaseColor.LIGHT_GRAY);
/*  988:     */         
/*  989:1003 */         PdfPCell cell29 = new PdfPCell(new Paragraph(
/*  990:1004 */           "GST Amount", mainContent));
/*  991:1005 */         cell29.setBackgroundColor(new BaseColor(238, 238, 238));
/*  992:1006 */         cell29.setBorderWidth(0.01F);
/*  993:1007 */         cell29.setBorderColor(BaseColor.WHITE);
/*  994:     */         
/*  995:1009 */         PdfPCell cell30 = new PdfPCell(new Paragraph(
/*  996:1010 */           this.resultSet
/*  997:1011 */           .getString("PUR_CEMENT_GST_AMOUNT"), 
/*  998:1012 */           mainContent));
/*  999:1013 */         cell30.setBorderWidth(0.2F);
/* 1000:1014 */         cell30.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1001:     */         
/* 1002:1016 */         PdfPCell cell31 = new PdfPCell(new Paragraph(
/* 1003:1017 */           "CGST Amount", mainContent));
/* 1004:1018 */         cell31.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1005:1019 */         cell31.setBorderWidth(0.01F);
/* 1006:1020 */         cell31.setBorderColor(BaseColor.WHITE);
/* 1007:     */         
/* 1008:1022 */         PdfPCell cell32 = new PdfPCell(new Paragraph(
/* 1009:1023 */           this.resultSet
/* 1010:1024 */           .getString("PUR_CEMENT_CGST_AMOUNT"), 
/* 1011:1025 */           mainContent));
/* 1012:1026 */         cell32.setBorderWidth(0.2F);
/* 1013:1027 */         cell32.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1014:     */         
/* 1015:1029 */         PdfPCell cell33 = new PdfPCell(new Paragraph(
/* 1016:1030 */           "SGST Amount", mainContent));
/* 1017:1031 */         cell33.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1018:1032 */         cell33.setBorderWidth(0.01F);
/* 1019:1033 */         cell33.setBorderColor(BaseColor.WHITE);
/* 1020:     */         
/* 1021:1035 */         PdfPCell cell34 = new PdfPCell(new Paragraph(
/* 1022:1036 */           this.resultSet
/* 1023:1037 */           .getString("PUR_CEMENT_SGST_AMOUNT"), 
/* 1024:1038 */           mainContent));
/* 1025:1039 */         cell34.setBorderWidth(0.2F);
/* 1026:1040 */         cell34.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1027:     */         
/* 1028:1042 */         PdfPCell cell35 = new PdfPCell(new Paragraph(
/* 1029:1043 */           "Invoice No", mainContent));
/* 1030:1044 */         cell35.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1031:1045 */         cell35.setBorderWidth(0.01F);
/* 1032:1046 */         cell35.setBorderColor(BaseColor.WHITE);
/* 1033:     */         
/* 1034:1048 */         PdfPCell cell36 = new PdfPCell(new Paragraph(
/* 1035:1049 */           this.resultSet
/* 1036:1050 */           .getString("PUR_CEMENT_INVOICE_NO"), 
/* 1037:1051 */           mainContent));
/* 1038:1052 */         cell36.setBorderWidth(0.2F);
/* 1039:1053 */         cell36.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1040:     */         
/* 1041:1055 */         PdfPCell cell37 = new PdfPCell(new Paragraph());
/* 1042:1056 */         cell37.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1043:1057 */         cell37.setBorderWidth(0.2F);
/* 1044:1058 */         cell37.setBorderColor(BaseColor.WHITE);
/* 1045:     */         
/* 1046:1060 */         PdfPCell cell38 = new PdfPCell(new Paragraph());
/* 1047:1061 */         cell38.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1048:1062 */         cell38.setBorderWidth(0.2F);
/* 1049:1063 */         cell38.setBorderColor(BaseColor.WHITE);
/* 1050:     */         
/* 1051:     */ 
/* 1052:1066 */         PdfPCell cell39 = new PdfPCell(new Paragraph("Order No", 
/* 1053:1067 */           mainContent));
/* 1054:1068 */         cell39.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1055:1069 */         cell39.setBorderWidth(0.01F);
/* 1056:1070 */         cell39.setBorderColor(BaseColor.WHITE);
/* 1057:     */         
/* 1058:1072 */         PdfPCell cell40 = new PdfPCell(new Paragraph(
/* 1059:1073 */           this.resultSet.getString("PUR_CEMENT_ORDER_NO"), mainContent));
/* 1060:1074 */         cell40.setBorderWidth(0.2F);
/* 1061:1075 */         cell40.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1062:     */         
/* 1063:1077 */         PdfPCell cell41 = new PdfPCell(new Paragraph("Carrier Name", 
/* 1064:1078 */           mainContent));
/* 1065:1079 */         cell41.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1066:1080 */         cell41.setBorderWidth(0.01F);
/* 1067:1081 */         cell41.setBorderColor(BaseColor.WHITE);
/* 1068:     */         
/* 1069:1083 */         PdfPCell cell42 = new PdfPCell(new Paragraph(
/* 1070:1084 */           this.resultSet.getString("PUR_CEMENT_CARRIER_NAME"), mainContent));
/* 1071:1085 */         cell42.setBorderWidth(0.2F);
/* 1072:1086 */         cell42.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1073:     */         
/* 1074:1088 */         PdfPCell cell43 = new PdfPCell(new Paragraph("Payment Mode", 
/* 1075:1089 */           mainContent));
/* 1076:1090 */         cell43.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1077:1091 */         cell43.setBorderWidth(0.01F);
/* 1078:1092 */         cell43.setBorderColor(BaseColor.WHITE);
/* 1079:     */         
/* 1080:1094 */         PdfPCell cell44 = new PdfPCell(new Paragraph(
/* 1081:1095 */           this.resultSet.getString("PUR_CEMENT_PAYMENT_MODE"), mainContent));
/* 1082:1096 */         cell44.setBorderWidth(0.2F);
/* 1083:1097 */         cell44.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1084:     */         
/* 1085:1099 */         PdfPCell cell45 = new PdfPCell(new Paragraph("Payment", 
/* 1086:1100 */           mainContent));
/* 1087:1101 */         cell45.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1088:1102 */         cell45.setBorderWidth(0.01F);
/* 1089:1103 */         cell45.setBorderColor(BaseColor.WHITE);
/* 1090:     */         
/* 1091:1105 */         PdfPCell cell46 = new PdfPCell(new Paragraph(
/* 1092:1106 */           this.resultSet.getString("PUR_CEMENT_PAYMENT"), mainContent));
/* 1093:1107 */         cell46.setBorderWidth(0.2F);
/* 1094:1108 */         cell46.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1095:     */         
/* 1096:1110 */         PdfPCell cell47 = new PdfPCell(new Paragraph("Invoice Date", 
/* 1097:1111 */           mainContent));
/* 1098:1112 */         cell47.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1099:1113 */         cell47.setBorderWidth(0.01F);
/* 1100:1114 */         cell47.setBorderColor(BaseColor.WHITE);
/* 1101:     */         
/* 1102:1116 */         PdfPCell cell48 = new PdfPCell(new Paragraph(this.resultSet.getString("PUR_CEMENT_INVOICE_DATE"), mainContent));
/* 1103:1117 */         cell48.setBorderWidth(0.2F);
/* 1104:1118 */         cell48.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1105:     */         
/* 1106:1120 */         PdfPCell cell49 = new PdfPCell(new Paragraph("Material Code", 
/* 1107:1121 */           mainContent));
/* 1108:1122 */         cell49.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1109:1123 */         cell49.setBorderWidth(0.01F);
/* 1110:1124 */         cell49.setBorderColor(BaseColor.WHITE);
/* 1111:     */         
/* 1112:1126 */         PdfPCell cell50 = new PdfPCell(new Paragraph(
/* 1113:1127 */           this.resultSet.getString("PUR_CEMENT_MATERIAL_CODE"), mainContent));
/* 1114:1128 */         cell50.setBorderWidth(0.2F);
/* 1115:1129 */         cell50.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1116:     */         
/* 1117:1131 */         PdfPCell cell51 = new PdfPCell(new Paragraph("HSN Code", 
/* 1118:1132 */           mainContent));
/* 1119:1133 */         cell51.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1120:1134 */         cell51.setBorderWidth(0.01F);
/* 1121:1135 */         cell51.setBorderColor(BaseColor.WHITE);
/* 1122:     */         
/* 1123:1137 */         PdfPCell cell52 = new PdfPCell(new Paragraph(
/* 1124:1138 */           this.resultSet.getString("PUR_CEMENT_HSN_CODE"), mainContent));
/* 1125:1139 */         cell52.setBorderWidth(0.2F);
/* 1126:1140 */         cell52.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1127:     */         
/* 1128:1142 */         PdfPCell cell53 = new PdfPCell(new Paragraph("Unit Price", 
/* 1129:1143 */           mainContent));
/* 1130:1144 */         cell53.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1131:1145 */         cell53.setBorderWidth(0.01F);
/* 1132:1146 */         cell53.setBorderColor(BaseColor.WHITE);
/* 1133:     */         
/* 1134:1148 */         PdfPCell cell54 = new PdfPCell(new Paragraph(
/* 1135:1149 */           this.resultSet.getString("PUR_CEMENT_UNIT_PRICE"), mainContent));
/* 1136:1150 */         cell54.setBorderWidth(0.2F);
/* 1137:1151 */         cell54.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1138:     */         
/* 1139:1153 */         PdfPCell cell55 = new PdfPCell(new Paragraph(
/* 1140:1154 */           "Discount", mainContent));
/* 1141:1155 */         cell55.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1142:1156 */         cell55.setBorderWidth(0.01F);
/* 1143:1157 */         cell55.setBorderColor(BaseColor.WHITE);
/* 1144:     */         
/* 1145:1159 */         PdfPCell cell56 = new PdfPCell(new Paragraph(
/* 1146:1160 */           this.resultSet.getString("PUR_CEMENT_DISCOUNT"), mainContent));
/* 1147:1161 */         cell56.setBorderWidth(0.2F);
/* 1148:1162 */         cell56.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1149:     */         
/* 1150:1164 */         PdfPCell cell57 = new PdfPCell(new Paragraph(
/* 1151:1165 */           "Delivery Place", mainContent));
/* 1152:1166 */         cell57.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1153:1167 */         cell57.setBorderWidth(0.01F);
/* 1154:1168 */         cell57.setBorderColor(BaseColor.WHITE);
/* 1155:     */         
/* 1156:1170 */         PdfPCell cell58 = new PdfPCell(new Paragraph(
/* 1157:1171 */           this.resultSet.getString("PUR_CEMENT_DELIVERY_PLACE"), 
/* 1158:1172 */           mainContent));
/* 1159:1173 */         cell58.setBorderWidth(0.2F);
/* 1160:1174 */         cell58.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1161:     */         
/* 1162:     */ 
/* 1163:     */ 
/* 1164:     */ 
/* 1165:     */ 
/* 1166:1180 */         table.addCell(cell);
/* 1167:1181 */         table.addCell(cell1);
/* 1168:1182 */         table.addCell(cell2);
/* 1169:1183 */         table.addCell(cell3);
/* 1170:1184 */         table.addCell(cell4);
/* 1171:1185 */         table.addCell(cell5);
/* 1172:1186 */         table.addCell(cell6);
/* 1173:1187 */         table.addCell(cell7);
/* 1174:1188 */         table.addCell(cell8);
/* 1175:1189 */         table.addCell(cell9);
/* 1176:1190 */         table.addCell(cell10);
/* 1177:1191 */         table.addCell(cell11);
/* 1178:1192 */         table.addCell(cell12);
/* 1179:1193 */         table.addCell(cell13);
/* 1180:1194 */         table.addCell(cell14);
/* 1181:1195 */         table.addCell(cell15);
/* 1182:1196 */         table.addCell(cell16);
/* 1183:1197 */         table.addCell(cell17);
/* 1184:1198 */         table.addCell(cell18);
/* 1185:1199 */         table.addCell(cell19);
/* 1186:1200 */         table.addCell(cell20);
/* 1187:1201 */         table.addCell(cell21);
/* 1188:1202 */         table.addCell(cell22);
/* 1189:1203 */         table.addCell(cell23);
/* 1190:1204 */         table.addCell(cell24);
/* 1191:1205 */         table.addCell(cell25);
/* 1192:1206 */         table.addCell(cell26);
/* 1193:1207 */         table.addCell(cell27);
/* 1194:1208 */         table.addCell(cell28);
/* 1195:1209 */         table.addCell(cell29);
/* 1196:1210 */         table.addCell(cell30);
/* 1197:1211 */         table.addCell(cell31);
/* 1198:1212 */         table.addCell(cell32);
/* 1199:1213 */         table.addCell(cell33);
/* 1200:1214 */         table.addCell(cell34);
/* 1201:1215 */         table.addCell(cell35);
/* 1202:1216 */         table.addCell(cell36);
/* 1203:1217 */         table.addCell(cell37);
/* 1204:1218 */         table.addCell(cell38);
/* 1205:1219 */         table.addCell(cell39);
/* 1206:1220 */         table.addCell(cell40);
/* 1207:1221 */         table.addCell(cell41);
/* 1208:1222 */         table.addCell(cell42);
/* 1209:1223 */         table.addCell(cell43);
/* 1210:1224 */         table.addCell(cell44);
/* 1211:1225 */         table.addCell(cell45);
/* 1212:1226 */         table.addCell(cell46);
/* 1213:1227 */         table.addCell(cell47);
/* 1214:1228 */         table.addCell(cell48);
/* 1215:1229 */         table.addCell(cell49);
/* 1216:1230 */         table.addCell(cell50);
/* 1217:1231 */         table.addCell(cell51);
/* 1218:1232 */         table.addCell(cell52);
/* 1219:1233 */         table.addCell(cell53);
/* 1220:1234 */         table.addCell(cell54);
/* 1221:1235 */         table.addCell(cell55);
/* 1222:1236 */         table.addCell(cell56);
/* 1223:1237 */         table.addCell(cell57);
/* 1224:1238 */         table.addCell(cell58);
/* 1225:     */         
/* 1226:     */ 
/* 1227:     */ 
/* 1228:     */ 
/* 1229:1243 */         document.add(table);
/* 1230:     */       }
/* 1231:1247 */       document.add(new Paragraph("\n"));
/* 1232:     */       
/* 1233:     */ 
/* 1234:     */ 
/* 1235:1251 */       document.close();
/* 1236:     */     }
/* 1237:     */     catch (SQLException sqlExp)
/* 1238:     */     {
/* 1239:1254 */       sqlExp.printStackTrace();
/* 1240:1255 */       logger.error(
/* 1241:1256 */         PurchaseCementDaoImpl.class + 
/* 1242:1257 */         "Error: Occur in Query While Fetching All Purchase Details for print PdF from Database.", 
/* 1243:1258 */         sqlExp);
/* 1244:     */     }
/* 1245:     */     catch (Exception exception)
/* 1246:     */     {
/* 1247:1260 */       exception.printStackTrace();
/* 1248:1261 */       logger.error(
/* 1249:1262 */         PurchaseCementDaoImpl.class + 
/* 1250:1263 */         "Error: Occur in Query While Closing Connection After Fetching All Purchase Details for print PdF from Database.", 
/* 1251:1264 */         exception);
/* 1252:     */     }
/* 1253:     */     finally
/* 1254:     */     {
/* 1255:1266 */       JdbcHelper.closeResultSet(this.resultSet);
/* 1256:1267 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/* 1257:1268 */       JdbcHelper.closeConnection(this.connection);
/* 1258:     */     }
/* 1259:     */   }
/* 1260:     */   
/* 1261:     */   public void insertIntoDealerTansaction(PurchaseCementVO purchaseCementVO)
/* 1262:     */     throws RecordNotFoundException
/* 1263:     */   {
/* 1264:1275 */     if (purchaseCementVO.getPayment() >= 0.0F)
/* 1265:     */     {
/* 1266:1277 */       Connection con = null;
/* 1267:     */       
/* 1268:1279 */       PreparedStatement ps = null;
/* 1269:     */       
/* 1270:1281 */       float totalDue = getDueOfCurrentDealer(purchaseCementVO.getDealerName());
/* 1271:     */       try
/* 1272:     */       {
/* 1273:1285 */         float paid = purchaseCementVO.getPayment();
/* 1274:1286 */         float due = purchaseCementVO.getNetAmount() - purchaseCementVO.getPayment();
/* 1275:     */         
/* 1276:1288 */         con = getConnection();
/* 1277:1289 */         String danger_query = "INSERT INTO TAB_DEALER_OWNER_TRANSACTION (DEALER_TRANS_DISCRIPTION, DEALER_TRANS_BILL_NO,DEALER_TANS_PAYMENT_MODE,DEALER_TRANS_DATE,DEALER_TRANS_TOTAL,DEALER_TRANS_PAID ,DEALER_TRANS_DUE,DEALER_ID_REF, DEALER_TRANS_TOTAL_DUE,  DEALER_TRANS_TOTAL_PAID)SELECT ?,?,?,?,?,?,?,?,?,SUM(TAB_DEALER_OWNER_TRANSACTION.DEALER_TRANS_PAID)+" + 
/* 1278:1290 */           paid + " FROM TAB_DEALER_OWNER_TRANSACTION WHERE DEALER_ID_REF=" + 
/* 1279:1291 */           purchaseCementVO.getDealerName();
/* 1280:1292 */         ps = con.prepareStatement(danger_query);
/* 1281:     */         
/* 1282:1294 */         ps.setString(1, "ON PURCHASE");
/* 1283:1295 */         ps.setString(2, purchaseCementVO.getInvoiceNo());
/* 1284:1296 */         ps.setString(3, purchaseCementVO.getPaymentMode());
/* 1285:     */         
/* 1286:1298 */         ps.setString(4, DateTimeUtil.convertToDate(purchaseCementVO.getInvoiceDate()));
/* 1287:1299 */         ps.setFloat(5, purchaseCementVO.getNetAmount());
/* 1288:1300 */         ps.setFloat(6, purchaseCementVO.getPayment());
/* 1289:1301 */         ps.setFloat(7, due);
/* 1290:1302 */         ps.setString(8, purchaseCementVO.getDealerName());
/* 1291:1303 */         ps.setFloat(9, totalDue + due);
/* 1292:     */         
/* 1293:     */ 
/* 1294:1306 */         ps.executeUpdate();
/* 1295:     */       }
/* 1296:     */       catch (SQLException sqlException)
/* 1297:     */       {
/* 1298:1310 */         logger.error(PurchaseCementDaoImpl.class + "ERROR: While inserting the cement transaction details into the database", sqlException);
/* 1299:     */         
/* 1300:1312 */         sqlException.printStackTrace();
/* 1301:     */       }
/* 1302:     */       catch (Exception exception)
/* 1303:     */       {
/* 1304:1316 */         logger.error(
/* 1305:1317 */           PurchaseCementDaoImpl.class + "ERROR: While inserting the cement transaction details into the database", 
/* 1306:1318 */           exception);
/* 1307:     */         
/* 1308:1320 */         exception.printStackTrace();
/* 1309:     */       }
/* 1310:     */       finally
/* 1311:     */       {
/* 1312:1323 */         JdbcHelper.closePreparedStatement(ps);
/* 1313:1324 */         JdbcHelper.closeConnection(con);
/* 1314:     */       }
/* 1315:     */     }
/* 1316:     */   }
/* 1317:     */   
/* 1318:     */   public float getDueOfCurrentDealer(String dealerId)
/* 1319:     */   {
/* 1320:1332 */     float tot_due = 0.0F;
/* 1321:1333 */     Connection con = null;
/* 1322:1334 */     PreparedStatement prst = null;
/* 1323:1335 */     ResultSet result = null;
/* 1324:     */     try
/* 1325:     */     {
/* 1326:1341 */       con = getConnection();
/* 1327:1342 */       String query = "SELECT DEALER_TRANS_TOTAL_DUE FROM TAB_DEALER_OWNER_TRANSACTION WHERE DEALER_ID_REF=? ORDER BY DEALER_TRANS_ID DESC LIMIT 1";
/* 1328:     */       
/* 1329:     */ 
/* 1330:     */ 
/* 1331:1346 */       prst = con.prepareStatement(query);
/* 1332:     */       
/* 1333:1348 */       prst.setString(1, dealerId);
/* 1334:1349 */       result = prst.executeQuery();
/* 1335:1350 */       while (result.next())
/* 1336:     */       {
/* 1337:1351 */         tot_due = result.getFloat("DEALER_TRANS_TOTAL_DUE");
/* 1338:     */         
/* 1339:1353 */         System.out.println(result.getFloat("DEALER_TRANS_TOTAL_DUE") + "FETCHED iDkkjjjjjjjjjjjjjjjjjjjjjjjjjj");
/* 1340:1354 */         System.out.println(result.getFloat("DEALER_TRANS_TOTAL_DUE") + "FETCHED iDnnjjjjjjjjjjjjjjjjjjjjjjjjjjname name");
/* 1341:     */       }
/* 1342:     */     }
/* 1343:     */     catch (Exception excep)
/* 1344:     */     {
/* 1345:1358 */       logger.error(
/* 1346:1359 */         PurchaseCementDaoImpl.class + "ERROR: while fetching the record from the Purchase  table", 
/* 1347:1360 */         excep);
/* 1348:     */       
/* 1349:1362 */       excep.printStackTrace();
/* 1350:     */     }
/* 1351:     */     finally
/* 1352:     */     {
/* 1353:1365 */       JdbcHelper.closeResultSet(result);
/* 1354:1366 */       JdbcHelper.closePreparedStatement(prst);
/* 1355:1367 */       JdbcHelper.closeConnection(con);
/* 1356:     */     }
/* 1357:1369 */     return tot_due;
/* 1358:     */   }
/* 1359:     */   
/* 1360:     */   public List<PurchaseCementVO> fetchPurchaseCementList()
/* 1361:     */     throws RecordNotFoundException
/* 1362:     */   {
/* 1363:1377 */     List<PurchaseCementVO> purchaseCementDetailList = new ArrayList();
/* 1364:     */     try
/* 1365:     */     {
/* 1366:1380 */       System.out.println("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFhdhsd");
/* 1367:1381 */       this.connection = getConnection();
/* 1368:     */       
/* 1369:1383 */       this.preparedStatement = this.connection.prepareStatement("SELECT * FROM TAB_PURCHASE_CEMENT_DETAIL");
/* 1370:     */       
/* 1371:1385 */       this.resultSet = this.preparedStatement.executeQuery();
/* 1372:1389 */       while (this.resultSet.next())
/* 1373:     */       {
/* 1374:1390 */         PurchaseCementVO purchaseCementVO = new PurchaseCementVO();
/* 1375:1391 */         purchaseCementVO.setPurchaseId(this.resultSet.getInt("PUR_CEMENT_ID"));
/* 1376:     */         
/* 1377:1393 */         purchaseCementVO.setDealerName(this.nameHelper.getDealerNameById(this.resultSet.getInt("PUR_CEMENT_DEALER_REF")));
/* 1378:     */         
/* 1379:     */ 
/* 1380:1396 */         System.out.println(purchaseCementVO.getdFullName() + "^^^^^1111111111111jhsgdfjgfgagyuas%%%%%%%%%%%%%%%%%%%%5");
/* 1381:1397 */         purchaseCementVO.setDealerContact(this.resultSet.getString("PUR_CEMENT_DEALER_CONTACT"));
/* 1382:     */         
/* 1383:1399 */         purchaseCementVO.setCompanyName(this.resultSet.getString("PUR_CEMENT_COMPANY_NAME"));
/* 1384:     */         
/* 1385:1401 */         purchaseCementVO.setQuantity(this.resultSet
/* 1386:1402 */           .getInt("PUR_CEMENT_BAGS_NO"));
/* 1387:     */         
/* 1388:1404 */         purchaseCementVO.setInvoiceNo(this.resultSet
/* 1389:1405 */           .getString("PUR_CEMENT_INVOICE_NO"));
/* 1390:     */         
/* 1391:     */ 
/* 1392:1408 */         purchaseCementVO.setOrderNo(this.resultSet
/* 1393:1409 */           .getString("PUR_CEMENT_ORDER_NO"));
/* 1394:     */         
/* 1395:1411 */         purchaseCementVO.setTransporter(this.resultSet
/* 1396:1412 */           .getString("PUR_CEMENT_CARRIER_NAME"));
/* 1397:     */         
/* 1398:1414 */         purchaseCementVO.setInvoiceDate(this.resultSet
/* 1399:1415 */           .getString("PUR_CEMENT_INVOICE_DATE"));
/* 1400:     */         
/* 1401:1417 */         purchaseCementVO.setMaterialCode(this.resultSet
/* 1402:1418 */           .getString("PUR_CEMENT_MATERIAL_CODE"));
/* 1403:     */         
/* 1404:     */ 
/* 1405:1421 */         purchaseCementVO.setUnitPrice(this.resultSet
/* 1406:1422 */           .getFloat("PUR_CEMENT_UNIT_PRICE"));
/* 1407:1423 */         purchaseCementVO.setNetAmount(this.resultSet
/* 1408:1424 */           .getFloat("PUR_CEMENT_AMOUNT"));
/* 1409:1425 */         purchaseCementVO.setGst(this.resultSet
/* 1410:1426 */           .getFloat("PUR_CEMENT_GST"));
/* 1411:     */         
/* 1412:     */ 
/* 1413:     */ 
/* 1414:     */ 
/* 1415:1431 */         purchaseCementDetailList.add(purchaseCementVO);
/* 1416:     */       }
/* 1417:     */     }
/* 1418:     */     catch (SQLException sqlExp)
/* 1419:     */     {
/* 1420:1435 */       sqlExp.printStackTrace();
/* 1421:1436 */       logger.error(
/* 1422:1437 */         PurchaseCementDaoImpl.class + 
/* 1423:1438 */         "Error: Occur in Query While Fetching the cement purchase Details into Grid from Database.", 
/* 1424:1439 */         sqlExp);
/* 1425:     */     }
/* 1426:     */     catch (Exception exception)
/* 1427:     */     {
/* 1428:1441 */       exception.printStackTrace();
/* 1429:1442 */       logger.error(
/* 1430:1443 */         PurchaseCementDaoImpl.class + 
/* 1431:1444 */         "Error: Occur in Query While Closing Connection After Fetching the cement purchase into Grid from Database.", 
/* 1432:1445 */         exception);
/* 1433:     */     }
/* 1434:     */     finally
/* 1435:     */     {
/* 1436:1447 */       JdbcHelper.closeResultSet(this.resultSet);
/* 1437:1448 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/* 1438:1449 */       JdbcHelper.closeConnection(this.connection);
/* 1439:     */     }
/* 1440:1451 */     return purchaseCementDetailList;
/* 1441:     */   }
/* 1442:     */   
/* 1443:     */   public int getPurchaseCementLastRecord()
/* 1444:     */     throws RecordNotFoundException
/* 1445:     */   {
/* 1446:1458 */     int temp = 0;
/* 1447:     */     try
/* 1448:     */     {
/* 1449:1460 */       this.connection = getConnection();
/* 1450:     */       
/* 1451:1462 */       this.preparedStatement = this.connection
/* 1452:1463 */         .prepareStatement("SELECT  PUR_CEMENT_ID FROM TAB_PURCHASE_CEMENT_DETAIL  ORDER BY PUR_CEMENT_ID DESC LIMIT 1 ");
/* 1453:     */       
/* 1454:     */ 
/* 1455:1466 */       this.resultSet = this.preparedStatement.executeQuery();
/* 1456:1467 */       if (this.resultSet != null) {
/* 1457:1468 */         while (this.resultSet.next()) {
/* 1458:1470 */           temp = this.resultSet.getInt("PUR_CEMENT_ID");
/* 1459:     */         }
/* 1460:     */       }
/* 1461:     */     }
/* 1462:     */     catch (SQLException sqlException)
/* 1463:     */     {
/* 1464:1475 */       sqlException.printStackTrace();
/* 1465:1476 */       logger.error(
/* 1466:1477 */         PurchaseCementDaoImpl.class + 
/* 1467:1478 */         ": Error:- Error: Occur in Query While counting the Purchase cement details recods from Database", 
/* 1468:1479 */         sqlException);
/* 1469:     */     }
/* 1470:     */     catch (Exception exception)
/* 1471:     */     {
/* 1472:1482 */       exception.printStackTrace();
/* 1473:1483 */       logger.error(
/* 1474:1484 */         PurchaseCementDaoImpl.class + 
/* 1475:1485 */         ": Error:- While closing the Connection after counting the Purchase cement details recods from Database", 
/* 1476:1486 */         exception);
/* 1477:     */     }
/* 1478:     */     finally
/* 1479:     */     {
/* 1480:1488 */       JdbcHelper.closeResultSet(this.resultSet);
/* 1481:1489 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/* 1482:1490 */       JdbcHelper.closeConnection(this.connection);
/* 1483:     */     }
/* 1484:1492 */     return temp;
/* 1485:     */   }
/* 1486:     */   
/* 1487:     */   public PurchaseCement getPurchaseCementDetails(int purchaseId)
/* 1488:     */     throws RecordNotFoundException
/* 1489:     */   {
/* 1490:1500 */     PurchaseCement purchaseCement = new PurchaseCement();
/* 1491:     */     try
/* 1492:     */     {
/* 1493:1503 */       this.connection = getConnection();
/* 1494:     */       
/* 1495:1505 */       this.preparedStatement = this.connection
/* 1496:1506 */         .prepareStatement("SELECT * FROM TAB_PURCHASE_CEMENT_DETAIL WHERE PUR_CEMENT_ID=?");
/* 1497:1507 */       this.preparedStatement.setInt(1, purchaseId);
/* 1498:     */       
/* 1499:     */ 
/* 1500:1510 */       this.resultSet = this.preparedStatement.executeQuery();
/* 1501:1511 */       System.out.println("----------hye ----------------");
/* 1502:1512 */       if (this.resultSet != null) {
/* 1503:1513 */         while (this.resultSet.next())
/* 1504:     */         {
/* 1505:1515 */           System.out.println("----------hye ----------------");
/* 1506:     */           
/* 1507:1517 */           purchaseCement.setPurchaseId(this.resultSet.getInt("PUR_CEMENT_ID"));
/* 1508:1518 */           System.out.println("________________" + this.resultSet.getInt("PUR_CEMENT_ID"));
/* 1509:     */           
/* 1510:1520 */           purchaseCement.setCompanyName(this.resultSet.getString("PUR_CEMENT_COMPANY_NAME"));
/* 1511:1521 */           System.out.println("---------" + this.resultSet.getString("PUR_CEMENT_PRICE"));
/* 1512:     */           
/* 1513:     */ 
/* 1514:     */ 
/* 1515:     */ 
/* 1516:     */ 
/* 1517:1527 */           purchaseCement.setNetAmount(this.resultSet
/* 1518:1528 */             .getFloat("PUR_CEMENT_AMOUNT"));
/* 1519:     */           
/* 1520:1530 */           purchaseCement.setGst(this.resultSet
/* 1521:1531 */             .getFloat("PUR_CEMENT_GST"));
/* 1522:     */           
/* 1523:1533 */           purchaseCement.setCgst(this.resultSet
/* 1524:1534 */             .getFloat("PUR_CEMENT_CGST"));
/* 1525:     */           
/* 1526:1536 */           purchaseCement.setSgst(this.resultSet
/* 1527:1537 */             .getFloat("PUR_CEMENT_SGST"));
/* 1528:     */           
/* 1529:1539 */           purchaseCement.setdFullName(this.resultSet.getString("PUR_CEMENT_DEALER_NAME"));
/* 1530:     */           
/* 1531:1541 */           purchaseCement.setDealerContact(this.resultSet.getString("PUR_CEMENT_DEALER_CONTACT"));
/* 1532:     */           
/* 1533:1543 */           purchaseCement.setDealerAddress(this.resultSet.getString("PUR_CEMENT_DEALER_ADDRESS"));
/* 1534:     */           
/* 1535:1545 */           purchaseCement.setDealerRef(this.resultSet.getInt("PUR_CEMENT_DEALER_REF"));
/* 1536:     */           
/* 1537:1547 */           purchaseCement.setQuantity(this.resultSet
/* 1538:1548 */             .getInt("PUR_CEMENT_BAGS_NO"));
/* 1539:     */           
/* 1540:     */ 
/* 1541:     */ 
/* 1542:     */ 
/* 1543:1553 */           purchaseCement.setGstAmount(this.resultSet
/* 1544:1554 */             .getFloat("PUR_CEMENT_GST_AMOUNT"));
/* 1545:1555 */           purchaseCement.setCgstAmount(this.resultSet
/* 1546:1556 */             .getFloat("PUR_CEMENT_CGST_AMOUNT"));
/* 1547:1557 */           purchaseCement.setSgstAmount(this.resultSet
/* 1548:1558 */             .getFloat("PUR_CEMENT_SGST_AMOUNT"));
/* 1549:1559 */           purchaseCement.setInvoiceNo(this.resultSet
/* 1550:1560 */             .getString("PUR_CEMENT_INVOICE_NO"));
/* 1551:     */           
/* 1552:1562 */           purchaseCement.setOrderNo(this.resultSet
/* 1553:1563 */             .getString("PUR_CEMENT_ORDER_NO"));
/* 1554:     */           
/* 1555:1565 */           purchaseCement.setTransporter(this.resultSet
/* 1556:1566 */             .getString("PUR_CEMENT_CARRIER_NAME"));
/* 1557:     */           
/* 1558:     */ 
/* 1559:     */ 
/* 1560:     */ 
/* 1561:1571 */           purchaseCement.setWeekNo(this.resultSet
/* 1562:1572 */             .getString("PUR_CEMENT_WEEK_NO"));
/* 1563:     */           
/* 1564:1574 */           purchaseCement.setInconterm(this.resultSet
/* 1565:1575 */             .getString("PUR_CEMENT_INCOTERM"));
/* 1566:     */           
/* 1567:     */ 
/* 1568:     */ 
/* 1569:1579 */           purchaseCement.setInvoiceDate(this.resultSet
/* 1570:1580 */             .getString("PUR_CEMENT_INVOICE_DATE"));
/* 1571:     */           
/* 1572:1582 */           purchaseCement.setMaterialCode(this.resultSet
/* 1573:1583 */             .getString("PUR_CEMENT_MATERIAL_CODE"));
/* 1574:     */           
/* 1575:     */ 
/* 1576:1586 */           purchaseCement.setHsnCode(this.resultSet
/* 1577:1587 */             .getString("PUR_CEMENT_HSN_CODE"));
/* 1578:     */           
/* 1579:1589 */           purchaseCement.setDeliveryPlace(this.resultSet
/* 1580:1590 */             .getString("PUR_CEMENT_DELIVERY_PLACE"));
/* 1581:     */           
/* 1582:1592 */           purchaseCement.setUnitPrice(this.resultSet
/* 1583:1593 */             .getFloat("PUR_CEMENT_UNIT_PRICE"));
/* 1584:     */         }
/* 1585:     */       }
/* 1586:     */     }
/* 1587:     */     catch (SQLException sqlExp)
/* 1588:     */     {
/* 1589:1603 */       sqlExp.printStackTrace();
/* 1590:1604 */       logger.error(
/* 1591:1605 */         PurchaseCementDaoImpl.class + 
/* 1592:1606 */         "Error: Occur in Query While Fetching the specific next cement purchase Details from Database.", 
/* 1593:1607 */         sqlExp);
/* 1594:     */     }
/* 1595:     */     catch (Exception exception)
/* 1596:     */     {
/* 1597:1609 */       exception.printStackTrace();
/* 1598:1610 */       logger.error(
/* 1599:1611 */         PurchaseCementDaoImpl.class + 
/* 1600:1612 */         "Error: Occur in Query While Closing Connection After Fetching the specific next cement purchase Details from Database.", 
/* 1601:1613 */         exception);
/* 1602:     */     }
/* 1603:     */     finally
/* 1604:     */     {
/* 1605:1615 */       JdbcHelper.closeResultSet(this.resultSet);
/* 1606:1616 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/* 1607:1617 */       JdbcHelper.closeConnection(this.connection);
/* 1608:     */     }
/* 1609:1621 */     return purchaseCement;
/* 1610:     */   }
/* 1611:     */   
/* 1612:     */   public int getDealerTransactionId()
/* 1613:     */   {
/* 1614:1627 */     return this.dealerTransactionId;
/* 1615:     */   }
/* 1616:     */   
/* 1617:     */   public void setDealerTransactionId(int dealerTransactionId)
/* 1618:     */   {
/* 1619:1633 */     this.dealerTransactionId = dealerTransactionId;
/* 1620:     */   }
/* 1621:     */   
/* 1622:     */   public List<PurchaseCementVO> viewCementStockGrid()
/* 1623:     */     throws RecordNotFoundException
/* 1624:     */   {
/* 1625:1641 */     List<PurchaseCementVO> purchaseCementDetailList = new ArrayList();
/* 1626:1642 */     String query = "SELECT PUR_CEMENT_ID,PUR_CEMENT_MATERIAL_CODE,PUR_CEMENT_INCOTERM, PUR_CEMENT_COMPANY_NAME,PUR_CEMENT_PRICE,PUR_CEMENT_AMOUNT,PUR_CEMENT_TYPE, PUR_CEMENT_BAGS_NO,SUM(PUR_CEMENT_BAGS_NO) FROM TAB_PURCHASE_CEMENT_DETAIL GROUP BY PUR_CEMENT_INCOTERM";
/* 1627:     */     try
/* 1628:     */     {
/* 1629:1645 */       this.connection = getConnection();
/* 1630:     */       
/* 1631:     */ 
/* 1632:1648 */       this.preparedStatement = this.connection.prepareStatement(query);
/* 1633:1649 */       this.resultSet = this.preparedStatement.executeQuery();
/* 1634:1653 */       while (this.resultSet.next())
/* 1635:     */       {
/* 1636:1654 */         this.purchaseCementVO = new PurchaseCementVO();
/* 1637:1655 */         this.purchaseCementVO.setPurchaseId(this.resultSet.getInt("PUR_CEMENT_ID"));
/* 1638:     */         
/* 1639:     */ 
/* 1640:     */ 
/* 1641:     */ 
/* 1642:1660 */         this.purchaseCementVO.setCompanyName(this.resultSet.getString("PUR_CEMENT_COMPANY_NAME"));
/* 1643:     */         
/* 1644:1662 */         this.purchaseCementVO.setQuantity(this.resultSet
/* 1645:1663 */           .getInt("SUM(PUR_CEMENT_BAGS_NO)"));
/* 1646:     */         
/* 1647:     */ 
/* 1648:     */ 
/* 1649:     */ 
/* 1650:     */ 
/* 1651:     */ 
/* 1652:     */ 
/* 1653:     */ 
/* 1654:     */ 
/* 1655:     */ 
/* 1656:     */ 
/* 1657:     */ 
/* 1658:     */ 
/* 1659:     */ 
/* 1660:1678 */         this.purchaseCementVO.setMaterialCode(this.resultSet
/* 1661:1679 */           .getString("PUR_CEMENT_MATERIAL_CODE"));
/* 1662:     */         
/* 1663:     */ 
/* 1664:1682 */         this.purchaseCementVO.setUnitPrice(this.resultSet
/* 1665:1683 */           .getFloat("PUR_CEMENT_PRICE"));
/* 1666:1684 */         this.purchaseCementVO.setNetAmount(this.resultSet
/* 1667:1685 */           .getFloat("PUR_CEMENT_AMOUNT"));
/* 1668:     */         
/* 1669:     */ 
/* 1670:1688 */         this.purchaseCementVO.setInconterm(this.nameHelper.getProductTypeNameByProductId(this.resultSet
/* 1671:1689 */           .getInt("PUR_CEMENT_INCOTERM")));
/* 1672:     */         
/* 1673:1691 */         purchaseCementDetailList.add(this.purchaseCementVO);
/* 1674:     */       }
/* 1675:     */     }
/* 1676:     */     catch (SQLException sqlExp)
/* 1677:     */     {
/* 1678:1695 */       sqlExp.printStackTrace();
/* 1679:1696 */       logger.error(
/* 1680:1697 */         PurchaseCementDaoImpl.class + 
/* 1681:1698 */         "Error: Occur in Query While Fetching the cement purchase Details into Grid from Database.", 
/* 1682:1699 */         sqlExp);
/* 1683:     */     }
/* 1684:     */     catch (Exception exception)
/* 1685:     */     {
/* 1686:1701 */       exception.printStackTrace();
/* 1687:1702 */       logger.error(
/* 1688:1703 */         PurchaseCementDaoImpl.class + 
/* 1689:1704 */         "Error: Occur in Query While Closing Connection After Fetching the cement purchase into Grid from Database.", 
/* 1690:1705 */         exception);
/* 1691:     */     }
/* 1692:     */     finally
/* 1693:     */     {
/* 1694:1707 */       JdbcHelper.closeResultSet(this.resultSet);
/* 1695:1708 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/* 1696:1709 */       JdbcHelper.closeConnection(this.connection);
/* 1697:     */     }
/* 1698:1711 */     return purchaseCementDetailList;
/* 1699:     */   }
/* 1700:     */   
/* 1701:     */   public void insertStockDetails(PurchaseCementVO purchaseCementVO)
/* 1702:     */     throws CreateFailedException
/* 1703:     */   {
/* 1704:     */     try
/* 1705:     */     {
/* 1706:1721 */       this.connection = getConnection();
/* 1707:1722 */       String insert = "INSERT INTO TAB_STOCK_DETAILS(STOCK_PURCHASE_PRICE, STOCK_AMOUNT, STOCK_BAGS_NO, STOCK_BAGS_TON,STOCK_MATERIAL_CODE,STOCK_HSN_CODE,STOCK_UNIT_PRICE,STOCK_CATEGORY, STOCK_PRODUCT_TYPE, STOCK_BILLED_OWNER)VALUES(?,?,?,?,?,?,?,?,?,?)";
/* 1708:     */       
/* 1709:1724 */       this.preparedStatement = this.connection
/* 1710:1725 */         .prepareStatement(insert);
/* 1711:     */       
/* 1712:1727 */       this.preparedStatement.setFloat(1, purchaseCementVO.getUnitPrice());
/* 1713:1728 */       this.preparedStatement.setFloat(2, purchaseCementVO.getNetAmount());
/* 1714:1729 */       this.preparedStatement.setFloat(3, purchaseCementVO.getQuantity());
/* 1715:1730 */       this.preparedStatement.setFloat(4, purchaseCementVO.getQuantity());
/* 1716:1731 */       this.preparedStatement.setString(5, purchaseCementVO.getMaterialCode());
/* 1717:1732 */       this.preparedStatement.setString(6, purchaseCementVO.getHsnCode());
/* 1718:     */       
/* 1719:1734 */       this.preparedStatement.setFloat(7, purchaseCementVO.getUnitPrice());
/* 1720:1735 */       this.preparedStatement.setInt(8, this.nameHelper.getProductCategoryIdByProductType(Integer.parseInt(purchaseCementVO.getInconterm())));
/* 1721:1736 */       this.preparedStatement.setString(9, purchaseCementVO.getInconterm());
/* 1722:     */       this.preparedStatement.setInt(10, OMIConstants.CHOUKSAY_TRADERS);
/* 1723:     */ 
/* 1724:1739 */       this.preparedStatement.executeUpdate();
/* 1725:     */     }
/* 1726:     */     catch (SQLException sqlException)
/* 1727:     */     {
/* 1728:1742 */       sqlException.printStackTrace();
/* 1729:1743 */       logger.error(
/* 1730:1744 */         PurchaseCementDaoImpl.class + 
/* 1731:1745 */         ": Error:- Error: Occur in Query While inserting the stock details into Database", 
/* 1732:1746 */         sqlException);
/* 1733:     */     }
/* 1734:     */     catch (Exception exception)
/* 1735:     */     {
/* 1736:1749 */       exception.printStackTrace();
/* 1737:1750 */       logger.error(
/* 1738:1751 */         PurchaseCementDaoImpl.class + 
/* 1739:1752 */         ": Error:- While closing the Connection after inserting the  stock details into Database", 
/* 1740:1753 */         exception);
/* 1741:     */     }
/* 1742:     */     finally
/* 1743:     */     {
/* 1744:1756 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/* 1745:1757 */       JdbcHelper.closeConnection(this.connection);
/* 1746:     */     }
/* 1747:     */   }
/* 1748:     */   
/* 1749:     */   public int isItemAlreadyExistInStock(String inconterm)
/* 1750:     */     throws RecordNotFoundException
/* 1751:     */   {
/* 1752:1767 */     int existence = 0;
/* 1753:     */     try
/* 1754:     */     {
/* 1755:1769 */       this.connection = getConnection();
/* 1756:     */       
/* 1757:1771 */       this.preparedStatement = this.connection
/* 1758:1772 */         .prepareStatement("SELECT  STOCK_BAGS_NO FROM TAB_STOCK_DETAILS WHERE STOCK_PRODUCT_TYPE=?");
/* 1759:1773 */       this.preparedStatement.setString(1, inconterm);
/* 1760:     */       
/* 1761:     */ 
/* 1762:1776 */       this.resultSet = this.preparedStatement.executeQuery();
/* 1763:1778 */       if (this.resultSet != null) {
/* 1764:1779 */         while (this.resultSet.next()) {
/* 1765:1781 */           existence = this.resultSet.getInt("STOCK_BAGS_NO");
/* 1766:     */         }
/* 1767:     */       }
/* 1768:     */     }
/* 1769:     */     catch (SQLException sqlExp)
/* 1770:     */     {
/* 1771:1788 */       sqlExp.printStackTrace();
/* 1772:1789 */       logger.error(
/* 1773:1790 */         PurchaseCementDaoImpl.class + 
/* 1774:1791 */         "Error: Occur in Query While Fetching the stock Details from Database.", 
/* 1775:1792 */         sqlExp);
/* 1776:     */     }
/* 1777:     */     catch (Exception exception)
/* 1778:     */     {
/* 1779:1794 */       exception.printStackTrace();
/* 1780:1795 */       logger.error(
/* 1781:1796 */         PurchaseCementDaoImpl.class + 
/* 1782:1797 */         "Error: Occur in Query While Closing Connection After Fetching the stock Details from Database.", 
/* 1783:1798 */         exception);
/* 1784:     */     }
/* 1785:     */     finally
/* 1786:     */     {
/* 1787:1800 */       JdbcHelper.closeResultSet(this.resultSet);
/* 1788:1801 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/* 1789:1802 */       JdbcHelper.closeConnection(this.connection);
/* 1790:     */     }
/* 1791:1804 */     return existence;
/* 1792:     */   }
/* 1793:     */   
/* 1794:     */   public void updateStockDetails(PurchaseCementVO purchaseCementVO, int quantity)
/* 1795:     */     throws UpdateFailedException
/* 1796:     */   {
/* 1797:1814 */     Connection connection = null;
/* 1798:1815 */     PreparedStatement preparedStatement = null;
/* 1799:1816 */     System.out.println("update is running************************" + purchaseCementVO.getUnitPrice());
/* 1800:     */     try
/* 1801:     */     {
/* 1802:1820 */       String up = "UPDATE TAB_STOCK_DETAILS SET  STOCK_PURCHASE_PRICE=?, STOCK_AMOUNT=?, STOCK_BAGS_NO=?, STOCK_BAGS_TON=?,STOCK_MATERIAL_CODE=?, STOCK_HSN_CODE=?, STOCK_UNIT_PRICE=?, STOCK_CATEGORY=? WHERE STOCK_PRODUCT_TYPE=?";
/* 1803:     */       
/* 1804:1822 */       System.out.println("fffffffffffffffffffffF" + quantity);
/* 1805:     */       
/* 1806:1824 */       connection = getConnection();
/* 1807:1825 */       preparedStatement = connection
/* 1808:1826 */         .prepareStatement(up);
/* 1809:1827 */       preparedStatement.setFloat(1, purchaseCementVO.getUnitPrice());
/* 1810:1828 */       preparedStatement.setFloat(2, purchaseCementVO.getNetAmount());
/* 1811:1829 */       preparedStatement.setFloat(3, purchaseCementVO.getQuantity() + quantity);
/* 1812:1830 */       preparedStatement.setFloat(4, purchaseCementVO.getQuantity());
/* 1813:1831 */       preparedStatement.setString(5, purchaseCementVO.getMaterialCode());
/* 1814:1832 */       preparedStatement.setString(6, purchaseCementVO.getHsnCode());
/* 1815:     */       
/* 1816:1834 */       preparedStatement.setFloat(7, purchaseCementVO.getUnitPrice());
/* 1817:1835 */       preparedStatement.setInt(8, this.nameHelper.getProductCategoryIdByProductType(Integer.parseInt(purchaseCementVO.getInconterm())));
/* 1818:1836 */       preparedStatement.setString(9, purchaseCementVO.getInconterm());
/* 1819:     */       
/* 1820:1838 */       preparedStatement.executeUpdate();
/* 1821:     */     }
/* 1822:     */     catch (SQLException sqlExp)
/* 1823:     */     {
/* 1824:1841 */       sqlExp.printStackTrace();
/* 1825:1842 */       logger.error(
/* 1826:1843 */         PurchaseCementDaoImpl.class + 
/* 1827:1844 */         "Error: Occur in Query While updating the specific cement purchase Details.", 
/* 1828:1845 */         sqlExp);
/* 1829:     */     }
/* 1830:     */     catch (Exception exception)
/* 1831:     */     {
/* 1832:1847 */       exception.printStackTrace();
/* 1833:1848 */       logger.error(
/* 1834:1849 */         PurchaseCementDaoImpl.class + 
/* 1835:1850 */         "Error: Occur in Query While Closing Connection After updating the specific cement purchase Details.", 
/* 1836:1851 */         exception);
/* 1837:     */     }
/* 1838:     */     finally
/* 1839:     */     {
/* 1840:1853 */       JdbcHelper.closeResultSet(this.resultSet);
/* 1841:1854 */       JdbcHelper.closePreparedStatement(preparedStatement);
/* 1842:1855 */       JdbcHelper.closeConnection(connection);
/* 1843:     */     }
/* 1844:     */   }
/* 1845:     */   
/* 1846:     */   public void insertIntoLedger(PurchaseCementVO purchaseCementVO)
/* 1847:     */     throws CreateFailedException
/* 1848:     */   {
/* 1849:     */     try
/* 1850:     */     {
/* 1851:1867 */       System.out.println("we  r in dao " + purchaseCementVO.getDeliveryPlace());
/* 1852:     */       
/* 1853:1869 */       this.connection = getConnection();
/* 1854:     */       
/* 1855:1871 */       String insert = "INSERT INTO TAB_DEALER_LEDGER_DETAILS(LEDGER_DATE, LEDGER_VOUNCHER_NO, LEDGER_TAX_TYPE, LEDGER_TAX_AMOUNT, LEDGER_QUANTITY,LEDGER_TRUCK_NO, LEDGER_DESTINATION, LEDGER_PAID, LEDGER_DUE, LEDGER_MATERIAL, LEDGER_DEALER_ID)VALUES(?,?,?,?,?,?,?,?,?,?,?)";
/* 1856:     */       
/* 1857:1873 */       this.preparedStatement = this.connection
/* 1858:1874 */         .prepareStatement(insert);
/* 1859:     */       
/* 1860:1876 */       this.preparedStatement.setString(1, DateTimeUtil.convertToDate(purchaseCementVO.getInvoiceDate()));
/* 1861:1877 */       this.preparedStatement.setString(2, purchaseCementVO.getInvoiceNo());
/* 1862:1878 */       this.preparedStatement.setString(3, "SGST");
/* 1863:1879 */       this.preparedStatement.setFloat(4, purchaseCementVO.getSgst());
/* 1864:1880 */       this.preparedStatement.setFloat(5, purchaseCementVO.getQuantity());
/* 1865:1881 */       this.preparedStatement.setString(6, purchaseCementVO.getTruckNo());
/* 1866:     */       
/* 1867:1883 */       this.preparedStatement.setString(7, purchaseCementVO.getDeliveryPlace());
/* 1868:     */       
/* 1869:1885 */       this.preparedStatement.setFloat(8, purchaseCementVO.getPayment());
/* 1870:1886 */       this.preparedStatement.setFloat(9, purchaseCementVO.getNetAmount());
/* 1871:1887 */       this.preparedStatement.setString(10, "CEMENT");
/* 1872:1888 */       this.preparedStatement.setString(11, purchaseCementVO.getDealerName());
/* 1873:     */       
/* 1874:     */ 
/* 1875:1891 */       this.preparedStatement.executeUpdate();
/* 1876:     */     }
/* 1877:     */     catch (SQLException sqlException)
/* 1878:     */     {
/* 1879:1895 */       sqlException.printStackTrace();
/* 1880:1896 */       logger.error(
/* 1881:1897 */         PurchaseCementDaoImpl.class + 
/* 1882:1898 */         ": Error:- Error: Occur in Query While inserting the Ledger dealer details into Database", 
/* 1883:1899 */         sqlException);
/* 1884:     */     }
/* 1885:     */     catch (Exception exception)
/* 1886:     */     {
/* 1887:1902 */       exception.printStackTrace();
/* 1888:1903 */       logger.error(
/* 1889:1904 */         PurchaseCementDaoImpl.class + 
/* 1890:1905 */         ": Error:- While closing the Connection after inserting the Ledger dealer into Database", 
/* 1891:1906 */         exception);
/* 1892:     */     }
/* 1893:     */     finally
/* 1894:     */     {
/* 1895:1909 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/* 1896:1910 */       JdbcHelper.closeConnection(this.connection);
/* 1897:     */     }
/* 1898:     */   }
/* 1899:     */ }


/* Location:           C:\Users\bharti\Desktop\Chouksay\lost\dao\
 * Qualified Name:     com.bst.ckt.dao.PurchaseCementDaoImpl
 * JD-Core Version:    0.7.0.1
 */