/*    1:     */ package com.bst.ckt.dao;
import com.bst.ckt.common.OMIConstants;
/*    2:     */ 
/*    3:     */ import com.bst.ckt.common.QueryBuilder;
/*    4:     */ import com.bst.ckt.dto.PurchaseSteelbar;
/*    5:     */ import com.bst.ckt.exception.CreateFailedException;
/*    6:     */ import com.bst.ckt.exception.DeleteFailedException;
/*    7:     */ import com.bst.ckt.exception.RecordNotFoundException;
/*    8:     */ import com.bst.ckt.exception.UpdateFailedException;
/*    9:     */ import com.bst.ckt.framework.db.JdbcDAOSupport;
/*   10:     */ import com.bst.ckt.framework.db.JdbcHelper;
/*   11:     */ import com.bst.ckt.framework.util.DateTimeUtil;
/*   12:     */ import com.bst.ckt.helper.NameHelper;
/*   13:     */ import com.bst.ckt.vo.PurchaseSteelBarVO;
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
/*   39:     */ public class PurchaseSteelBarDaoImpl
/*   40:     */   extends JdbcDAOSupport
/*   41:     */   implements PurchaseSteelBarDaoInf
/*   42:     */ {
/*   43:  45 */   private static final Logger logger = Logger.getLogger(PurchaseSteelBarDaoImpl.class);
/*   44:  47 */   PreparedStatement preparedStatement = null;
/*   45:  48 */   Connection connection = null;
/*   46:  49 */   ResultSet resultSet = null;
/*   47:  50 */   PurchaseSteelBarVO purchaseSteelBarVO = null;
/*   48:  51 */   NameHelper nameHelper = new NameHelper();
/*   49:  52 */   Image image = null;
/*   50:     */   
/*   51:     */   public int insertPurchaseSteelBarsDetails(PurchaseSteelBarVO purchaseSteelBarVO)
/*   52:     */     throws CreateFailedException
/*   53:     */   {
/*   54:  56 */     int output = 0;
/*   55:     */     try
/*   56:     */     {
/*   57:  58 */       this.connection = getConnection();
/*   58:     */       
/*   59:  60 */       String insert = "INSERT INTO TAB_PURCHASE_STEEBAR_DETAIL(PUR_STEEBAR_COMPANY_NAME, PUR_STEEBAR_PRICE, PUR_STEEBAR_AMOUNT,PUR_STEEBAR_GST, PUR_STEEBAR_CGST, PUR_STEEBAR_SGST, PUR_STEEBAR_DEALER_NAME, PUR_STEEBAR_DEALER_CONTACT, PUR_STEEBAR_DEALER_ADDRESS, PUR_STEEBAR_DEALER_REF, PUR_STEEBAR_BAGS_NO, PUR_STEEBAR_BAGS_TON, PUR_STEEBAR_GST_AMOUNT, PUR_STEEBAR_CGST_AMOUNT, PUR_STEEBAR_SGST_AMOUNT, PUR_STEEBAR_INVOICE_NO, PUR_STEEBAR_ORDER_NO, PUR_STEEBAR_CARRIER_NAME, PUR_STEEBAR_PAYMENT_MODE, PUR_STEEBAR_WEEK_NO, PUR_STEEBAR_INCOTERM, PUR_STEEBAR_PAYMENT,PUR_STEEBAR_INVOICE_DATE, PUR_STEEBAR_MATERIAL_CODE, PUR_STEEBAR_HSN_CODE, PUR_STEEBAR_DELIVERY_PLACE, PUR_STEEBAR_UNIT_PRICE, PUR_STEEBAR_DISCOUNT )VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
/*   60:     */       
float quantInTon = purchaseSteelBarVO.getQuantity();
/*   68:  69 */       float quantInKg = quantInTon * 1000.0F;
/*   61:     */ float total=purchaseSteelBarVO.getUnitPrice()*quantInKg;
float cal =(100+purchaseSteelBarVO.getGst())/100;
/*   64:     */ float gstAmount=total*cal;
float diff=gstAmount-total;
/*   62:     */ 
/*   63:     */ 
/*   64:     */ 
/*   65:  66 */       this.preparedStatement = this.connection
/*   66:  67 */         .prepareStatement(insert);
/*   67:  68 */     
/*   69:  70 */       this.preparedStatement.setString(1, purchaseSteelBarVO.getCompanyName());
/*   70:  71 */       this.preparedStatement.setFloat(2, purchaseSteelBarVO.getUnitPrice());
/*   71:  72 */       this.preparedStatement.setFloat(3, purchaseSteelBarVO.getNetAmount());
/*   72:  73 */       this.preparedStatement.setFloat(4, purchaseSteelBarVO.getGst());
/*   73:  74 */       this.preparedStatement.setFloat(5, purchaseSteelBarVO.getCgst());
/*   74:  75 */       this.preparedStatement.setFloat(6, purchaseSteelBarVO.getSgst());
/*   75:  76 */       this.preparedStatement.setString(7, this.nameHelper.getDealerNameById(Integer.parseInt(purchaseSteelBarVO.getDealerName())));
/*   76:  77 */       this.preparedStatement.setString(8, purchaseSteelBarVO.getDealerContact());
/*   77:  78 */       this.preparedStatement.setString(9, purchaseSteelBarVO.getDealerAddress());
/*   78:  79 */       this.preparedStatement.setString(10, purchaseSteelBarVO.getDealerName());
/*   79:  80 */       this.preparedStatement.setFloat(11, quantInKg);
/*   80:  81 */       this.preparedStatement.setFloat(12, purchaseSteelBarVO.getQuantity());
/*   81:  82 */       this.preparedStatement.setFloat(13, diff);
/*   82:  83 */       this.preparedStatement.setFloat(14, purchaseSteelBarVO.getCgstAmount());
/*   83:  84 */       this.preparedStatement.setFloat(15, purchaseSteelBarVO.getSgstAmount());
/*   84:  85 */       this.preparedStatement.setString(16, purchaseSteelBarVO.getInvoiceNo());
/*   85:  86 */       this.preparedStatement.setString(17, purchaseSteelBarVO.getOrderNo());
/*   86:  87 */       this.preparedStatement.setString(18, purchaseSteelBarVO.getTransporter());
/*   87:  88 */       this.preparedStatement.setString(19, purchaseSteelBarVO.getPaymentMode());
/*   88:  89 */       this.preparedStatement.setString(20, purchaseSteelBarVO.getWeekNo());
/*   89:  90 */       this.preparedStatement.setString(21, purchaseSteelBarVO.getInconterm());
/*   90:  91 */       this.preparedStatement.setFloat(22, purchaseSteelBarVO.getPayment());
/*   91:  92 */       this.preparedStatement.setString(23, DateTimeUtil.convertToDate(purchaseSteelBarVO.getInvoiceDate()));
/*   92:     */       
/*   93:  94 */       this.preparedStatement.setString(24, purchaseSteelBarVO.getMaterialCode());
/*   94:  95 */       this.preparedStatement.setString(25, purchaseSteelBarVO.getHsnCode());
/*   95:  96 */       this.preparedStatement.setString(26, purchaseSteelBarVO.getDeliveryPlace());
/*   96:  97 */       this.preparedStatement.setFloat(27, purchaseSteelBarVO.getUnitPrice());
/*   97:  98 */       this.preparedStatement.setFloat(28, purchaseSteelBarVO.getDiscount());
/*   98:     */       
/*   99:     */ 
/*  100:     */ 
/*  101:     */ 
/*  102:     */ 
/*  103: 104 */       output = this.preparedStatement.executeUpdate();
/*  104: 105 */       if (output == 1) {
/*  105: 106 */         insertIntoDealerTansaction(purchaseSteelBarVO);
/*  106:     */       }
/*  107:     */     }
/*  108:     */     catch (SQLException sqlException)
/*  109:     */     {
/*  110: 111 */       sqlException.printStackTrace();
/*  111: 112 */       logger.error(
/*  112: 113 */         PurchaseSteelBarDaoImpl.class + 
/*  113: 114 */         ": Error:- Error: Occur in Query While inserting the Purchased Steelbar details into Database", 
/*  114: 115 */         sqlException);
/*  115:     */     }
/*  116:     */     catch (Exception exception)
/*  117:     */     {
/*  118: 118 */       exception.printStackTrace();
/*  119: 119 */       logger.error(
/*  120: 120 */         PurchaseSteelBarDaoImpl.class + 
/*  121: 121 */         ": Error:- While closing the Connection after inserting the Purchased Steelbar into Database", 
/*  122: 122 */         exception);
/*  123:     */     }
/*  124:     */     finally
/*  125:     */     {
/*  126: 125 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/*  127: 126 */       JdbcHelper.closeConnection(this.connection);
/*  128:     */     }
/*  129: 128 */     return output;
/*  130:     */   }
/*  131:     */   
/*  132:     */   public List<PurchaseSteelBarVO> retrivePurchaseSteelBarDetailsGrid(PurchaseSteelBarVO purchaseSteelBarVO)
/*  133:     */     throws RecordNotFoundException
/*  134:     */   {
/*  135: 135 */     List<PurchaseSteelBarVO> purchaseSteelbarDetailList = new ArrayList();
/*  136:     */     try
/*  137:     */     {
/*  138: 139 */       this.connection = getConnection();
/*  139:     */       
/*  140: 141 */       this.preparedStatement = this.connection
/*  141: 142 */         .prepareStatement("SELECT * FROM TAB_PURCHASE_STEEBAR_DETAIL");
/*  142:     */       
/*  143: 144 */       this.resultSet = this.preparedStatement.executeQuery();
/*  144: 148 */       while (this.resultSet.next())
/*  145:     */       {
/*  146: 149 */         purchaseSteelBarVO = new PurchaseSteelBarVO();
/*  147: 150 */         purchaseSteelBarVO.setPurchaseId(this.resultSet.getInt("PUR_STEEBAR_ID"));
/*  148:     */         
/*  149: 152 */         purchaseSteelBarVO.setDealerName(this.nameHelper.getDealerNameById(this.resultSet.getInt("PUR_STEEBAR_DEALER_REF")));
/*  150: 153 */         purchaseSteelBarVO.setDealerContact(this.resultSet.getString("PUR_STEEBAR_DEALER_CONTACT"));
/*  151:     */         
/*  152: 155 */         purchaseSteelBarVO.setCompanyName(this.resultSet.getString("PUR_STEEBAR_COMPANY_NAME"));
/*  153:     */         
/*  154: 157 */         purchaseSteelBarVO.setQuantityInKg(this.resultSet
/*  155: 158 */           .getFloat("PUR_STEEBAR_BAGS_NO"));
/*  156:     */         
/*  157: 160 */         purchaseSteelBarVO.setInvoiceNo(this.resultSet
/*  158: 161 */           .getString("PUR_STEEBAR_INVOICE_NO"));
/*  159:     */         
/*  160:     */ 
/*  161: 164 */         purchaseSteelBarVO.setOrderNo(this.resultSet
/*  162: 165 */           .getString("PUR_STEEBAR_ORDER_NO"));
/*  163:     */         
/*  164: 167 */         purchaseSteelBarVO.setTransporter(this.resultSet
/*  165: 168 */           .getString("PUR_STEEBAR_CARRIER_NAME"));
/*  166:     */         
/*  167: 170 */         purchaseSteelBarVO.setInvoiceDate(this.resultSet
/*  168: 171 */           .getString("PUR_STEEBAR_INVOICE_DATE"));
/*  169:     */         
/*  170: 173 */         purchaseSteelBarVO.setMaterialCode(this.resultSet
/*  171: 174 */           .getString("PUR_STEEBAR_MATERIAL_CODE"));
/*  172:     */         
/*  173:     */ 
/*  174: 177 */         purchaseSteelBarVO.setUnitPrice(this.resultSet
/*  175: 178 */           .getFloat("PUR_STEEBAR_UNIT_PRICE"));
/*  176: 179 */         purchaseSteelBarVO.setNetAmount(this.resultSet
/*  177: 180 */           .getFloat("PUR_STEEBAR_AMOUNT"));
/*  178: 181 */         purchaseSteelBarVO.setGst(this.resultSet
/*  179: 182 */           .getFloat("PUR_STEEBAR_GST"));
/*  180: 183 */         purchaseSteelBarVO.setQuantity(this.resultSet
/*  181: 184 */           .getFloat("PUR_STEEBAR_BAGS_TON"));
/*  182:     */         
/*  183: 186 */         purchaseSteelbarDetailList.add(purchaseSteelBarVO);
/*  184:     */       }
/*  185:     */     }
/*  186:     */     catch (SQLException sqlExp)
/*  187:     */     {
/*  188: 190 */       sqlExp.printStackTrace();
/*  189: 191 */       logger.error(
/*  190: 192 */         PurchaseSteelBarDaoImpl.class + 
/*  191: 193 */         "Error: Occur in Query While Fetching the steelbar purchase Details into Grid from Database.", 
/*  192: 194 */         sqlExp);
/*  193:     */     }
/*  194:     */     catch (Exception exception)
/*  195:     */     {
/*  196: 196 */       exception.printStackTrace();
/*  197: 197 */       logger.error(
/*  198: 198 */         PurchaseSteelBarDaoImpl.class + 
/*  199: 199 */         "Error: Occur in Query While Closing Connection After Fetching the steelbar purchase into Grid from Database.", 
/*  200: 200 */         exception);
/*  201:     */     }
/*  202:     */     finally
/*  203:     */     {
/*  204: 202 */       JdbcHelper.closeResultSet(this.resultSet);
/*  205: 203 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/*  206: 204 */       JdbcHelper.closeConnection(this.connection);
/*  207:     */     }
/*  208: 206 */     return purchaseSteelbarDetailList;
/*  209:     */   }
/*  210:     */   
/*  211:     */   public PurchaseSteelbar retriveSpecificPurchaseSteelBarDetail(int purchaseId)
/*  212:     */     throws RecordNotFoundException
/*  213:     */   {
/*  214: 213 */     PurchaseSteelbar purchaseSteelbar = new PurchaseSteelbar();
/*  215:     */     try
/*  216:     */     {
/*  217: 216 */       this.connection = getConnection();
/*  218:     */       
/*  219: 218 */       this.preparedStatement = this.connection
/*  220: 219 */         .prepareStatement("SELECT * FROM TAB_PURCHASE_STEEBAR_DETAIL WHERE PUR_STEEBAR_ID=? ");
/*  221: 220 */       this.preparedStatement.setInt(1, purchaseId);
/*  222:     */       
/*  223:     */ 
/*  224: 223 */       this.resultSet = this.preparedStatement.executeQuery();
/*  225: 224 */       System.out.println("----------hye ----------------");
/*  226: 225 */       if (this.resultSet != null) {
/*  227: 226 */         while (this.resultSet.next())
/*  228:     */         {
/*  229: 228 */           System.out.println("----------hye ----------------");
/*  230:     */           
/*  231: 230 */           purchaseSteelbar.setPurchaseId(this.resultSet.getInt("PUR_STEEBAR_ID"));
/*  232: 231 */           System.out.println("________________" + this.resultSet.getInt("PUR_STEEBAR_ID"));
/*  233:     */           
/*  234: 233 */           purchaseSteelbar.setCompanyName(this.resultSet.getString("PUR_STEEBAR_COMPANY_NAME"));
/*  235: 234 */           System.out.println("---------" + this.resultSet.getString("PUR_STEEBAR_PRICE"));
/*  236:     */           
/*  237:     */ 
/*  238:     */ 
/*  239:     */ 
/*  240:     */ 
/*  241: 240 */           purchaseSteelbar.setNetAmount(this.resultSet
/*  242: 241 */             .getFloat("PUR_STEEBAR_AMOUNT"));
/*  243:     */           
/*  244: 243 */           purchaseSteelbar.setGst(this.resultSet
/*  245: 244 */             .getFloat("PUR_STEEBAR_GST"));
/*  246:     */           
/*  247: 246 */           purchaseSteelbar.setCgst(this.resultSet
/*  248: 247 */             .getFloat("PUR_STEEBAR_CGST"));
/*  249:     */           
/*  250: 249 */           purchaseSteelbar.setSgst(this.resultSet
/*  251: 250 */             .getFloat("PUR_STEEBAR_SGST"));
/*  252:     */           
/*  253: 252 */           purchaseSteelbar.setDealerName(this.resultSet.getString("PUR_STEEBAR_DEALER_NAME"));
/*  254:     */           
/*  255: 254 */           purchaseSteelbar.setDealerContact(this.resultSet.getString("PUR_STEEBAR_DEALER_CONTACT"));
/*  256:     */           
/*  257: 256 */           purchaseSteelbar.setDealerAddress(this.resultSet.getString("PUR_STEEBAR_DEALER_ADDRESS"));
/*  258:     */           
/*  259: 258 */           purchaseSteelbar.setDealerRef(this.resultSet.getInt("PUR_STEEBAR_DEALER_REF"));
/*  260:     */           
/*  261: 260 */           purchaseSteelbar.setQuantityInKg(this.resultSet
/*  262: 261 */             .getInt("PUR_STEEBAR_BAGS_NO"));
/*  263:     */           
/*  264: 263 */           purchaseSteelbar.setQuantity(this.resultSet
/*  265: 264 */             .getFloat("PUR_STEEBAR_BAGS_TON"));
/*  266:     */           
/*  267: 266 */           purchaseSteelbar.setGstAmount(this.resultSet
/*  268: 267 */             .getFloat("PUR_STEEBAR_GST_AMOUNT"));
/*  269: 268 */           purchaseSteelbar.setCgstAmount(this.resultSet
/*  270: 269 */             .getFloat("PUR_STEEBAR_CGST_AMOUNT"));
/*  271: 270 */           purchaseSteelbar.setSgstAmount(this.resultSet
/*  272: 271 */             .getFloat("PUR_STEEBAR_SGST_AMOUNT"));
/*  273: 272 */           purchaseSteelbar.setInvoiceNo(this.resultSet
/*  274: 273 */             .getString("PUR_STEEBAR_INVOICE_NO"));
/*  275:     */           
/*  276: 275 */           purchaseSteelbar.setOrderNo(this.resultSet
/*  277: 276 */             .getString("PUR_STEEBAR_ORDER_NO"));
/*  278:     */           
/*  279: 278 */           purchaseSteelbar.setTransporter(this.resultSet
/*  280: 279 */             .getString("PUR_STEEBAR_CARRIER_NAME"));
/*  281:     */           
/*  282:     */ 
/*  283:     */ 
/*  284:     */ 
/*  285: 284 */           purchaseSteelbar.setWeekNo(this.resultSet
/*  286: 285 */             .getString("PUR_STEEBAR_WEEK_NO"));
/*  287:     */           
/*  288: 287 */           purchaseSteelbar.setInconterm(this.nameHelper.getProductTypeNameByProductId(Integer.parseInt(this.nameHelper.getProductNameById(this.resultSet
/*  289: 288 */             .getInt("PUR_STEEBAR_INCOTERM")))));
/*  290:     */           
/*  291:     */ 
/*  292:     */ 
/*  293: 292 */           purchaseSteelbar.setInvoiceDate(this.resultSet
/*  294: 293 */             .getString("PUR_STEEBAR_INVOICE_DATE"));
/*  295:     */           
/*  296: 295 */           purchaseSteelbar.setMaterialCode(this.resultSet
/*  297: 296 */             .getString("PUR_STEEBAR_MATERIAL_CODE"));
/*  298:     */           
/*  299:     */ 
/*  300: 299 */           purchaseSteelbar.setHsnCode(this.resultSet
/*  301: 300 */             .getString("PUR_STEEBAR_HSN_CODE"));
/*  302:     */           
/*  303: 302 */           purchaseSteelbar.setDeliveryPlace(this.resultSet
/*  304: 303 */             .getString("PUR_STEEBAR_DELIVERY_PLACE"));
/*  305:     */           
/*  306: 305 */           purchaseSteelbar.setUnitPrice(this.resultSet
/*  307: 306 */             .getFloat("PUR_STEEBAR_UNIT_PRICE"));
purchaseSteelbar.setDiscount(this.resultSet
/*  307: 306 */             .getFloat("PUR_STEEBAR_DISCOUNT"));
/*  308:     */         }
/*  309:     */       }
/*  310:     */     }
/*  311:     */     catch (SQLException sqlExp)
/*  312:     */     {
/*  313: 316 */       sqlExp.printStackTrace();
/*  314: 317 */       logger.error(
/*  315: 318 */         PurchaseSteelBarDaoImpl.class + 
/*  316: 319 */         "Error: Occur in Query While Fetching the specific steelbar purchase Details from Database.", 
/*  317: 320 */         sqlExp);
/*  318:     */     }
/*  319:     */     catch (Exception exception)
/*  320:     */     {
/*  321: 322 */       exception.printStackTrace();
/*  322: 323 */       logger.error(
/*  323: 324 */         PurchaseSteelBarDaoImpl.class + 
/*  324: 325 */         "Error: Occur in Query While Closing Connection After Fetching the specific steelbar purchase Details from Database.", 
/*  325: 326 */         exception);
/*  326:     */     }
/*  327:     */     finally
/*  328:     */     {
/*  329: 328 */       JdbcHelper.closeResultSet(this.resultSet);
/*  330: 329 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/*  331: 330 */       JdbcHelper.closeConnection(this.connection);
/*  332:     */     }
/*  333: 334 */     return purchaseSteelbar;
/*  334:     */   }
/*  335:     */   
/*  336:     */   public int deleteSpecificSteelbarPurchaseDetails(int purchaseId)
/*  337:     */     throws DeleteFailedException
/*  338:     */   {
/*  339: 340 */     int effect = 0;
/*  340:     */     try
/*  341:     */     {
/*  342: 342 */       this.connection = getConnection();
/*  343:     */       
/*  344: 344 */       this.preparedStatement = this.connection.prepareStatement("DELETE FROM TAB_PURCHASE_STEEBAR_DETAIL WHERE PUR_STEEBAR_ID=?");
/*  345:     */       
/*  346: 346 */       this.preparedStatement.setInt(1, purchaseId);
/*  347:     */       
/*  348: 348 */       effect = this.preparedStatement.executeUpdate();
/*  349:     */     }
/*  350:     */     catch (SQLException sqlException)
/*  351:     */     {
/*  352: 351 */       sqlException.printStackTrace();
/*  353: 352 */       logger.error(
/*  354: 353 */         PurchaseSteelBarDaoImpl.class + 
/*  355: 354 */         ": Error:- Error: Occur in Query While deleting the steelbar purchase details record", 
/*  356: 355 */         sqlException);
/*  357:     */     }
/*  358:     */     catch (Exception exception)
/*  359:     */     {
/*  360: 357 */       exception.printStackTrace();
/*  361: 358 */       logger.error(
/*  362: 359 */         PurchaseSteelBarDaoImpl.class + 
/*  363: 360 */         ": Error:- While closing the Connection after deleting the steelbar purchase details reccord", 
/*  364: 361 */         exception);
/*  365:     */     }
/*  366:     */     finally
/*  367:     */     {
/*  368: 364 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/*  369: 365 */       JdbcHelper.closeConnection(this.connection);
/*  370:     */     }
/*  371: 367 */     return effect;
/*  372:     */   }
/*  373:     */   
/*  374:     */   public PurchaseSteelbar retriveSpecificPurchaseDetailForUpdate(int purchaseId)
/*  375:     */     throws RecordNotFoundException
/*  376:     */   {
/*  377: 373 */     PurchaseSteelbar purchaseSteelbar = new PurchaseSteelbar();
/*  378: 374 */     PreparedStatement preparedStatements = null;
/*  379:     */     try
/*  380:     */     {
/*  381: 376 */       this.connection = getConnection();
/*  382:     */       
/*  383: 378 */       preparedStatements = this.connection
/*  384: 379 */         .prepareStatement("SELECT * FROM TAB_PURCHASE_STEEBAR_DETAIL WHERE PUR_STEEBAR_ID=?");
/*  385: 380 */       preparedStatements.setInt(1, purchaseId);
/*  386:     */       
/*  387:     */ 
/*  388: 383 */       this.resultSet = preparedStatements.executeQuery();
/*  389: 384 */       System.out.println("----------hye ----------------");
/*  390: 385 */       if (this.resultSet != null) {
/*  391: 386 */         while (this.resultSet.next())
/*  392:     */         {
/*  393: 388 */           System.out.println("----------hye ----------------");
/*  394:     */           
/*  395: 390 */           purchaseSteelbar.setPurchaseId(this.resultSet.getInt("PUR_STEEBAR_ID"));
/*  396: 391 */           System.out.println("________________" + this.resultSet.getInt("PUR_STEEBAR_ID"));
/*  397:     */           
/*  398: 393 */           purchaseSteelbar.setUnitPrice(this.resultSet.getFloat("PUR_STEEBAR_PRICE"));
/*  399: 394 */           System.out.println("---------" + this.resultSet.getFloat("PUR_STEEBAR_AMOUNT"));
/*  400:     */           
/*  401:     */ 
/*  402: 397 */           purchaseSteelbar.setCompanyName(this.resultSet.getString("PUR_STEEBAR_COMPANY_NAME"));
/*  403:     */           
/*  404: 399 */           purchaseSteelbar.setDealerName(this.resultSet.getString("PUR_STEEBAR_DEALER_REF"));
/*  405:     */           
/*  406:     */ 
/*  407:     */ 
/*  408: 403 */           purchaseSteelbar.setGst(this.resultSet.getFloat("PUR_STEEBAR_GST"));
/*  409:     */           
/*  410:     */ 
/*  411: 406 */           purchaseSteelbar.setCgst(this.resultSet
/*  412: 407 */             .getFloat("PUR_STEEBAR_CGST"));
/*  413:     */           
/*  414: 409 */           purchaseSteelbar.setSgst(this.resultSet
/*  415: 410 */             .getFloat("PUR_STEEBAR_SGST"));
/*  416:     */           
/*  417:     */ 
/*  418:     */ 
/*  419:     */ 
/*  420: 415 */           purchaseSteelbar.setDealerContact(this.resultSet
/*  421: 416 */             .getString("PUR_STEEBAR_DEALER_CONTACT"));
/*  422:     */           
/*  423: 418 */           purchaseSteelbar.setDealerAddress(this.resultSet
/*  424: 419 */             .getString("PUR_STEEBAR_DEALER_ADDRESS"));
/*  425:     */           
/*  426: 421 */           purchaseSteelbar.setDealerRef(this.resultSet.getInt("PUR_STEEBAR_DEALER_REF"));
/*  427:     */           
/*  428: 423 */           purchaseSteelbar.setQuantityInKg(this.resultSet.getInt("PUR_STEEBAR_BAGS_NO"));
/*  429:     */           
/*  430: 425 */           purchaseSteelbar.setQuantity(this.resultSet.getInt("PUR_STEEBAR_BAGS_TON"));
/*  431:     */           
/*  432: 427 */           purchaseSteelbar.setGstAmount(this.resultSet.getFloat("PUR_STEEBAR_GST_AMOUNT"));
/*  433:     */           
/*  434: 429 */           purchaseSteelbar.setCgstAmount(this.resultSet
/*  435: 430 */             .getFloat("PUR_STEEBAR_CGST_AMOUNT"));
/*  436:     */           
/*  437: 432 */           purchaseSteelbar.setSgstAmount(this.resultSet
/*  438: 433 */             .getFloat("PUR_STEEBAR_SGST_AMOUNT"));
/*  439:     */           
/*  440:     */ 
/*  441:     */ 
/*  442: 437 */           purchaseSteelbar.setInvoiceNo(this.resultSet
/*  443: 438 */             .getString("PUR_STEEBAR_INVOICE_NO"));
/*  444: 439 */           purchaseSteelbar.setOrderNo(this.resultSet
/*  445: 440 */             .getString("PUR_STEEBAR_ORDER_NO"));
/*  446: 441 */           purchaseSteelbar.setTransporter(this.resultSet
/*  447: 442 */             .getString("PUR_STEEBAR_CARRIER_NAME"));
/*  448: 443 */           purchaseSteelbar.setPaymentMode(this.resultSet
/*  449: 444 */             .getString("PUR_STEEBAR_PAYMENT_MODE"));
/*  450: 445 */           purchaseSteelbar.setWeekNo(this.resultSet
/*  451: 446 */             .getString("PUR_STEEBAR_WEEK_NO"));
/*  452: 447 */           purchaseSteelbar.setInconterm(this.resultSet
/*  453: 448 */             .getString("PUR_STEEBAR_INCOTERM"));
/*  454: 449 */           purchaseSteelbar.setPayment(this.resultSet
/*  455: 450 */             .getFloat("PUR_STEEBAR_PAYMENT"));
/*  456: 451 */           purchaseSteelbar.setInvoiceDate(DateTimeUtil.convertDatetoFormDate(this.resultSet.getString("PUR_STEEBAR_INVOICE_DATE")));
/*  457: 452 */           System.out.println(this.resultSet.getFloat("PUR_STEEBAR_PAYMENT") + "&&&&&&&" + this.resultSet.getString("PUR_STEEBAR_DEALER_REF") + "&&&&&&&&&7" + this.resultSet.getString("PUR_STEEBAR_PAYMENT_MODE"));
/*  458: 453 */           purchaseSteelbar.setMaterialCode(this.resultSet
/*  459: 454 */             .getString("PUR_STEEBAR_MATERIAL_CODE"));
/*  460: 455 */           purchaseSteelbar.setHsnCode(this.resultSet
/*  461: 456 */             .getString("PUR_STEEBAR_HSN_CODE"));
/*  462: 457 */           purchaseSteelbar.setDeliveryPlace(this.resultSet
/*  463: 458 */             .getString("PUR_STEEBAR_DELIVERY_PLACE"));
/*  464: 459 */           purchaseSteelbar.setUnitPrice(this.resultSet
/*  465: 460 */             .getFloat("PUR_STEEBAR_UNIT_PRICE"));
/*  466:     */           
/*  467: 462 */           purchaseSteelbar.setDiscount(this.resultSet
/*  468: 463 */             .getFloat("PUR_STEEBAR_DISCOUNT"));
/*  469:     */           
/*  470: 465 */           purchaseSteelbar.setNetAmount(this.resultSet
/*  471: 466 */             .getFloat("PUR_STEEBAR_AMOUNT"));
/*  472:     */           
/*  473: 468 */           System.out.println("BHARTI" + this.resultSet.getFloat("PUR_STEEBAR_UNIT_PRICE") + this.resultSet.getInt("PUR_STEEBAR_AMOUNT") + this.resultSet.getString("PUR_STEEBAR_AMOUNT") + "%%%%%%%%%%%%%%%");
/*  474:     */         }
/*  475:     */       }
/*  476: 476 */       purchaseSteelbar = retriveSpecificDealerTransactionForUpdate(purchaseSteelbar);
/*  477:     */     }
/*  478:     */     catch (SQLException sqlExp)
/*  479:     */     {
/*  480: 479 */       sqlExp.printStackTrace();
/*  481: 480 */       logger.error(
/*  482: 481 */         PurchaseSteelBarDaoImpl.class + 
/*  483: 482 */         "Error: Occur in Query While Fetching the specific steelbar purchase Details from Database For Update.", 
/*  484: 483 */         sqlExp);
/*  485:     */     }
/*  486:     */     catch (Exception exception)
/*  487:     */     {
/*  488: 485 */       exception.printStackTrace();
/*  489: 486 */       logger.error(
/*  490: 487 */         PurchaseSteelBarDaoImpl.class + 
/*  491: 488 */         "Error: Occur in Query While Closing Connection After Fetching the specific steelbar purchase Details from Database For Update.", 
/*  492: 489 */         exception);
/*  493:     */     }
/*  494:     */     finally
/*  495:     */     {
/*  496: 491 */       JdbcHelper.closeResultSet(this.resultSet);
/*  497: 492 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/*  498: 493 */       JdbcHelper.closeConnection(this.connection);
/*  499:     */     }
/*  500: 497 */     return purchaseSteelbar;
/*  501:     */   }
/*  502:     */   
/*  503:     */   private PurchaseSteelbar retriveSpecificDealerTransactionForUpdate(PurchaseSteelbar purchaseSteelbar)
/*  504:     */   {
/*  505:     */     try
/*  506:     */     {
/*  507: 503 */       this.connection = getConnection();
/*  508: 504 */       PreparedStatement preparedStatements = this.connection
/*  509: 505 */         .prepareStatement("SELECT * FROM TAB_DEALER_OWNER_TRANSACTION WHERE DEALER_TRANS_BILL_NO=?");
/*  510: 506 */       preparedStatements.setString(1, purchaseSteelbar.getInvoiceNo());
/*  511: 507 */       this.resultSet = preparedStatements.executeQuery();
/*  512: 508 */       System.out.println("----------hye ----------------" + purchaseSteelbar.getInvoiceNo() + "invoice bill no");
/*  513: 509 */       if (this.resultSet != null) {
/*  514: 510 */         while (this.resultSet.next())
/*  515:     */         {
/*  516: 512 */           System.out.println("----------hye ----------------");
/*  517:     */           
/*  518: 514 */           purchaseSteelbar.setTransactionId(this.resultSet.getInt("DEALER_TRANS_ID"));
/*  519: 515 */           System.out.println("________________" + this.resultSet.getInt("DEALER_TRANS_ID") + "hhh");
/*  520: 516 */           purchaseSteelbar.setTotal(this.resultSet.getFloat("DEALER_TRANS_TOTAL"));
/*  521: 517 */           purchaseSteelbar.setPaid(this.resultSet.getFloat("DEALER_TRANS_PAID"));
/*  522: 518 */           purchaseSteelbar.setDue(this.resultSet.getFloat("DEALER_TRANS_DUE"));
/*  523: 519 */           purchaseSteelbar.setTotalPaid(this.resultSet.getFloat("DEALER_TRANS_TOTAL_PAID"));
/*  524: 520 */           purchaseSteelbar.setTotalDue(this.resultSet.getFloat("DEALER_TRANS_TOTAL_DUE"));
/*  525: 521 */           purchaseSteelbar.setTransactionBillNo(this.resultSet.getString("DEALER_TRANS_BILL_NO"));
/*  526: 522 */           purchaseSteelbar.setRetailerId(this.resultSet.getInt("DEALER_ID_REF"));
/*  527:     */         }
/*  528:     */       }
/*  529:     */     }
/*  530:     */     catch (SQLException sqlExp)
/*  531:     */     {
/*  532: 535 */       sqlExp.printStackTrace();
/*  533: 536 */       logger.error(
/*  534: 537 */         PurchaseSteelBarDaoImpl.class + 
/*  535: 538 */         "Error: Occur in Query While Fetching the specific steelbar purchase  transaction from Database For Update.", 
/*  536: 539 */         sqlExp);
/*  537:     */     }
/*  538:     */     catch (Exception exception)
/*  539:     */     {
/*  540: 541 */       exception.printStackTrace();
/*  541: 542 */       logger.error(
/*  542: 543 */         PurchaseSteelBarDaoImpl.class + 
/*  543: 544 */         "Error: Occur in Query While Closing Connection After Fetching the specific steelbar purchase transaction from Database For Update.", 
/*  544: 545 */         exception);
/*  545:     */     }
/*  546:     */     finally
/*  547:     */     {
/*  548: 547 */       JdbcHelper.closeResultSet(this.resultSet);
/*  549: 548 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/*  550: 549 */       JdbcHelper.closeConnection(this.connection);
/*  551:     */     }
/*  552: 553 */     return purchaseSteelbar;
/*  553:     */   }
/*  554:     */   
/*  555:     */   public void updateSpecificPurchaseRecord(PurchaseSteelBarVO purchaseSteelBarVO, int purchaseId)
/*  556:     */     throws UpdateFailedException
/*  557:     */   {
/*  558: 560 */     Connection connection = null;
/*  559: 561 */     PreparedStatement preparedStatement = null;
/*  560:     */     try
/*  561:     */     {
/*  562: 565 */       String up = "UPDATE TAB_PURCHASE_STEEBAR_DETAIL SET PUR_STEEBAR_COMPANY_NAME=?, PUR_STEEBAR_PRICE=?, PUR_STEEBAR_AMOUNT=?,PUR_STEEBAR_GST=?, PUR_STEEBAR_CGST=?, PUR_STEEBAR_SGST=?, PUR_STEEBAR_DEALER_NAME=?, PUR_STEEBAR_DEALER_CONTACT=?, PUR_STEEBAR_DEALER_ADDRESS=?,PUR_STEEBAR_BAGS_NO=?, PUR_STEEBAR_BAGS_TON=?, PUR_STEEBAR_GST_AMOUNT=?, PUR_STEEBAR_CGST_AMOUNT=?, PUR_STEEBAR_SGST_AMOUNT=?, PUR_STEEBAR_INVOICE_NO=?, PUR_STEEBAR_ORDER_NO=?, PUR_STEEBAR_CARRIER_NAME=?, PUR_STEEBAR_PAYMENT_MODE=?, PUR_STEEBAR_WEEK_NO=?, PUR_STEEBAR_INCOTERM=?, PUR_STEEBAR_PAYMENT=?,PUR_STEEBAR_INVOICE_DATE=?, PUR_STEEBAR_MATERIAL_CODE=?, PUR_STEEBAR_HSN_CODE=?, PUR_STEEBAR_DELIVERY_PLACE=?, PUR_STEEBAR_UNIT_PRICE=?, PUR_STEEBAR_DISCOUNT=?WHERE PUR_STEEBAR_ID=? ";
/*  563:     */       
/*  564:     */ 
/*  565:     */ 
/*  566:     */ 
/*  567:     */ 
/*  568: 571 */       float quantInTon = purchaseSteelBarVO.getQuantity();
/*  569: 572 */       float quantInKg = quantInTon * 10000.0F;
/*  570:     */       
/*  571: 574 */       connection = getConnection();
/*  572: 575 */       preparedStatement = connection.prepareStatement(up);
/*  573: 576 */       preparedStatement.setString(1, purchaseSteelBarVO.getCompanyName());
/*  574: 577 */       preparedStatement.setFloat(2, purchaseSteelBarVO.getUnitPrice());
/*  575: 578 */       preparedStatement.setFloat(3, purchaseSteelBarVO.getNetAmount());
/*  576: 579 */       preparedStatement.setFloat(4, purchaseSteelBarVO.getGst());
/*  577: 580 */       preparedStatement.setFloat(5, purchaseSteelBarVO.getCgst());
/*  578: 581 */       preparedStatement.setFloat(6, purchaseSteelBarVO.getSgst());
/*  579: 582 */       preparedStatement.setString(7, this.nameHelper.getDealerNameById(Integer.parseInt(purchaseSteelBarVO.getDealerName())));
/*  580: 583 */       preparedStatement.setString(8, purchaseSteelBarVO.getDealerContact());
/*  581: 584 */       preparedStatement.setString(9, purchaseSteelBarVO.getDealerAddress());
/*  582:     */       
/*  583: 586 */       preparedStatement.setFloat(10, quantInKg);
/*  584:     */       
/*  585: 588 */       preparedStatement.setFloat(11, purchaseSteelBarVO.getQuantity());
/*  586: 589 */       preparedStatement.setFloat(12, purchaseSteelBarVO.getGst());
/*  587:     */       
/*  588: 591 */       preparedStatement.setFloat(13, purchaseSteelBarVO.getCgstAmount());
/*  589: 592 */       preparedStatement.setFloat(14, purchaseSteelBarVO.getSgstAmount());
/*  590: 593 */       preparedStatement.setString(15, purchaseSteelBarVO.getInvoiceNo());
/*  591: 594 */       preparedStatement.setString(16, purchaseSteelBarVO.getOrderNo());
/*  592: 595 */       preparedStatement.setString(17, purchaseSteelBarVO.getTransporter());
/*  593: 596 */       preparedStatement.setString(18, purchaseSteelBarVO.getPaymentMode());
/*  594: 597 */       preparedStatement.setString(19, purchaseSteelBarVO.getWeekNo());
/*  595: 598 */       preparedStatement.setString(20, purchaseSteelBarVO.getInconterm());
/*  596: 599 */       preparedStatement.setFloat(21, purchaseSteelBarVO.getPayment());
/*  597: 600 */       preparedStatement.setString(22, DateTimeUtil.convertToDate(purchaseSteelBarVO.getInvoiceDate()));
/*  598: 601 */       preparedStatement.setString(23, purchaseSteelBarVO.getMaterialCode());
/*  599: 602 */       preparedStatement.setString(24, purchaseSteelBarVO.getHsnCode());
/*  600: 603 */       preparedStatement.setString(25, purchaseSteelBarVO.getDeliveryPlace());
/*  601: 604 */       preparedStatement.setFloat(26, purchaseSteelBarVO.getUnitPrice());
/*  602: 605 */       preparedStatement.setFloat(27, purchaseSteelBarVO.getDiscount());
/*  603:     */       
/*  604: 607 */       preparedStatement.setFloat(28, purchaseId);
/*  605:     */       
/*  606:     */ 
/*  607: 610 */       int effect = preparedStatement.executeUpdate();
/*  608: 611 */       if (effect == 1) {
/*  609: 612 */         updateSpecificDealerTransaction(purchaseSteelBarVO);
/*  610:     */       } else {
/*  611: 614 */         logger.info("INFO: Can Not Update purchase Details & Dealer Transaction.");
/*  612:     */       }
/*  613:     */     }
/*  614:     */     catch (SQLException sqlExp)
/*  615:     */     {
/*  616: 619 */       sqlExp.printStackTrace();
/*  617: 620 */       logger.error(
/*  618: 621 */         PurchaseSteelBarDaoImpl.class + 
/*  619: 622 */         "Error: Occur in Query While Fetching the specific steelbar purchase Details from Database For Update.", 
/*  620: 623 */         sqlExp);
/*  621:     */     }
/*  622:     */     catch (Exception exception)
/*  623:     */     {
/*  624: 625 */       exception.printStackTrace();
/*  625: 626 */       logger.error(
/*  626: 627 */         PurchaseSteelBarDaoImpl.class + 
/*  627: 628 */         "Error: Occur in Query While Closing Connection After Fetching the specific steelbar purchase Details from Database For Update.", 
/*  628: 629 */         exception);
/*  629:     */     }
/*  630:     */     finally
/*  631:     */     {
/*  632: 631 */       JdbcHelper.closeResultSet(this.resultSet);
/*  633: 632 */       JdbcHelper.closePreparedStatement(preparedStatement);
/*  634: 633 */       JdbcHelper.closeConnection(connection);
/*  635:     */     }
/*  636:     */   }
/*  637:     */   
/*  638:     */   private void updateSpecificDealerTransaction(PurchaseSteelBarVO purchaseSteelBarVO2)
/*  639:     */   {
/*  640: 639 */     Connection connection = null;
/*  641: 640 */     PreparedStatement preparedStatement = null;
/*  642:     */     
/*  643:     */ 
/*  644:     */ 
/*  645: 644 */     System.out.println(purchaseSteelBarVO2.getTransactionId() + "update is running transaction************************" + purchaseSteelBarVO2.getTransactionId());
/*  646: 645 */     String up = "UPDATE TAB_DEALER_OWNER_TRANSACTION SET DEALER_TRANS_TOTAL=?,DEALER_TRANS_PAID=?,DEALER_TRANS_DUE=?,DEALER_TRANS_TOTAL_PAID=?,DEALER_TRANS_TOTAL_DUE=?,DEALER_ID_REF=?,DEALER_TRANS_DATE=?,DEALER_TANS_PAYMENT_MODE=?WHERE DEALER_TRANS_ID=?";
/*  647:     */     
/*  648:     */ 
/*  649:     */ 
/*  650: 649 */     float dDueUpdate = purchaseSteelBarVO2.getNetAmount() - purchaseSteelBarVO2.getPayment();
/*  651: 650 */     System.out.println(purchaseSteelBarVO2.getNetAmount() + " " + purchaseSteelBarVO2.getPayment() + "hello we are in transaction update" + purchaseSteelBarVO2.getTransactionId() + " " + purchaseSteelBarVO2.getTotalPaid() + " " + purchaseSteelBarVO2.getTotalDue() + " " + purchaseSteelBarVO2.getTotal() + " " + purchaseSteelBarVO2.getPaid() + " " + purchaseSteelBarVO2.getDue());
/*  652:     */     float dTotalDueUpdate;
/*  653:     */     float dTotalPaidUpdate;
/*  654:     */     
/*  655: 651 */     if ((purchaseSteelBarVO2.getTotalPaid() == 0.0F) && (purchaseSteelBarVO2.getTotalDue() == 0.0F))
/*  656:     */     {
/*  657: 652 */       float tp = 0.0F;
/*  658: 653 */       float td = 0.0F;
/*  659: 654 */        dTotalPaidUpdate = 0.0F;
/*  660: 655 */       dTotalDueUpdate = 0.0F;
/*  661:     */     }
/*  662:     */     else
/*  663:     */     {
/*  664: 657 */       float tp = purchaseSteelBarVO2.getTotalPaid();
/*  665: 658 */       float td = purchaseSteelBarVO2.getTotalDue();
/*  666: 659 */       dTotalPaidUpdate = tp - purchaseSteelBarVO2.getPaid() + purchaseSteelBarVO2.getPayment();
/*  667: 660 */       dTotalDueUpdate = td - purchaseSteelBarVO2.getDue() + dDueUpdate;
/*  668:     */     }
/*  669: 663 */     float totalPresent = purchaseSteelBarVO2.getUnitPrice() * purchaseSteelBarVO2.getQuantity();
/*  670:     */     try
/*  671:     */     {
/*  672: 666 */       System.out.println();
/*  673: 667 */       connection = getConnection();
/*  674: 668 */       preparedStatement = connection.prepareStatement(up);
/*  675: 669 */       System.out.println("code is going to be run" + purchaseSteelBarVO2.getTransactionId() + "hhh" + purchaseSteelBarVO2.getTransactionId() + "totalPresent" + totalPresent + "dDueUpdate" + dDueUpdate + "dTotalPaidUpdate" + dTotalDueUpdate + "dTotalPaidUpdate" + dTotalPaidUpdate + purchaseSteelBarVO2.getTransactionDate());
/*  676: 670 */       preparedStatement.setFloat(1, purchaseSteelBarVO2.getNetAmount());
/*  677: 671 */       preparedStatement.setFloat(2, purchaseSteelBarVO2.getPayment());
/*  678: 672 */       preparedStatement.setFloat(3, dDueUpdate);
/*  679: 673 */       preparedStatement.setFloat(4, dTotalPaidUpdate);
/*  680: 674 */       preparedStatement.setFloat(5, dTotalDueUpdate);
/*  681: 675 */       preparedStatement.setString(6, purchaseSteelBarVO2.getDealerName());
/*  682: 676 */       preparedStatement.setString(7, DateTimeUtil.convertToDate(purchaseSteelBarVO2.getInvoiceDate()));
/*  683: 677 */       preparedStatement.setString(8, purchaseSteelBarVO2.getPaymentMode());
/*  684: 678 */       preparedStatement.setInt(9, purchaseSteelBarVO2.getTransactionId());
/*  685:     */       
/*  686: 680 */       System.out.println("ha ha my tran updated");
/*  687: 681 */       preparedStatement.executeUpdate();
/*  688:     */     }
/*  689:     */     catch (SQLException sqlExp)
/*  690:     */     {
/*  691: 684 */       sqlExp.printStackTrace();
/*  692: 685 */       logger.error(
/*  693: 686 */         PurchaseSteelBarDaoImpl.class + 
/*  694: 687 */         "Error: Occur in Query While Fetching the specific steelbar purchase Transaction from Database For Update.", 
/*  695: 688 */         sqlExp);
/*  696:     */     }
/*  697:     */     catch (Exception exception)
/*  698:     */     {
/*  699: 690 */       exception.printStackTrace();
/*  700: 691 */       logger.error(
/*  701: 692 */         PurchaseSteelBarDaoImpl.class + 
/*  702: 693 */         "Error: Occur in Query While Closing Connection After Fetching the specific steelbar purchase Details from Database For Update.", 
/*  703: 694 */         exception);
/*  704:     */     }
/*  705:     */     finally
/*  706:     */     {
/*  707: 697 */       JdbcHelper.closePreparedStatement(preparedStatement);
/*  708: 698 */       JdbcHelper.closeConnection(connection);
/*  709:     */     }
/*  710:     */   }
/*  711:     */   
/*  712:     */   public void insertIntoDealerTansaction(PurchaseSteelBarVO purchaseSteelBarVO)
/*  713:     */     throws RecordNotFoundException
/*  714:     */   {
/*  715: 708 */     if (purchaseSteelBarVO.getPayment() >= 0.0F)
/*  716:     */     {
/*  717: 711 */       Connection con = null;
/*  718:     */       
/*  719: 713 */       PreparedStatement ps = null;
/*  720:     */       
/*  721:     */ 
/*  722:     */ 
/*  723: 717 */       float totalDue = getDueOfCurrentDealer(purchaseSteelBarVO.getDealerName());
/*  724:     */       try
/*  725:     */       {
/*  726: 726 */         float paid = purchaseSteelBarVO.getPayment();
/*  727: 727 */         float due = purchaseSteelBarVO.getNetAmount() - purchaseSteelBarVO.getPayment();
/*  728:     */         
/*  729:     */ 
/*  730: 730 */         con = getConnection();
/*  731: 731 */         String danger_query = "INSERT INTO TAB_DEALER_OWNER_TRANSACTION (DEALER_TRANS_DISCRIPTION, DEALER_TRANS_BILL_NO,DEALER_TANS_PAYMENT_MODE,DEALER_TRANS_DATE,DEALER_TRANS_TOTAL,DEALER_TRANS_PAID ,DEALER_TRANS_DUE,DEALER_ID_REF, DEALER_TRANS_TOTAL_DUE,   DEALER_TRANS_TOTAL_PAID)SELECT ?,?,?,?,?,?,?,?,?,SUM(TAB_DEALER_OWNER_TRANSACTION.DEALER_TRANS_PAID)+" + 
/*  732: 732 */           paid + " FROM TAB_DEALER_OWNER_TRANSACTION WHERE DEALER_ID_REF=" + 
/*  733: 733 */           purchaseSteelBarVO.getDealerName();
/*  734: 734 */         ps = con.prepareStatement(danger_query);
/*  735:     */         
/*  736: 736 */         ps.setString(1, "ON PURCHASE");
/*  737: 737 */         ps.setString(2, purchaseSteelBarVO.getInvoiceNo());
/*  738: 738 */         ps.setString(3, purchaseSteelBarVO.getPaymentMode());
/*  739: 739 */         ps.setString(4, DateTimeUtil.convertToDate(purchaseSteelBarVO.getInvoiceDate()));
/*  740:     */         
/*  741: 741 */         ps.setFloat(5, purchaseSteelBarVO.getNetAmount());
/*  742: 742 */         ps.setFloat(6, purchaseSteelBarVO.getPayment());
/*  743: 743 */         ps.setFloat(7, due);
/*  744: 744 */         ps.setString(8, purchaseSteelBarVO.getDealerName());
/*  745: 745 */         ps.setFloat(9, totalDue + due);
/*  746:     */         
/*  747:     */ 
/*  748:     */ 
/*  749: 749 */         ps.executeUpdate();
/*  750:     */       }
/*  751:     */       catch (SQLException sqlException)
/*  752:     */       {
/*  753: 753 */         logger.error(PurchaseSteelBarDaoImpl.class + "ERROR: While inserting the transaction details into the database", sqlException);
/*  754:     */         
/*  755: 755 */         sqlException.printStackTrace();
/*  756:     */       }
/*  757:     */       catch (Exception exception)
/*  758:     */       {
/*  759: 759 */         logger.error(
/*  760: 760 */           PurchaseSteelBarDaoImpl.class + "ERROR: While inserting the transaction details into the database", 
/*  761: 761 */           exception);
/*  762:     */         
/*  763: 763 */         exception.printStackTrace();
/*  764:     */       }
/*  765:     */       finally
/*  766:     */       {
/*  767: 766 */         JdbcHelper.closePreparedStatement(ps);
/*  768: 767 */         JdbcHelper.closeConnection(con);
/*  769:     */       }
/*  770:     */     }
/*  771:     */   }
/*  772:     */   
/*  773:     */   public float getDueOfCurrentDealer(String dealerId)
/*  774:     */   {
/*  775: 775 */     float tot_due = 0.0F;
/*  776: 776 */     Connection con = null;
/*  777: 777 */     PreparedStatement prst = null;
/*  778: 778 */     ResultSet result = null;
/*  779:     */     try
/*  780:     */     {
/*  781: 784 */       con = getConnection();
/*  782: 785 */       String query = "SELECT DEALER_TRANS_TOTAL_DUE FROM TAB_DEALER_OWNER_TRANSACTION WHERE DEALER_ID_REF=? ORDER BY DEALER_TRANS_ID DESC LIMIT 1";
/*  783:     */       
/*  784:     */ 
/*  785:     */ 
/*  786: 789 */       prst = con.prepareStatement(query);
/*  787:     */       
/*  788: 791 */       prst.setString(1, dealerId);
/*  789: 792 */       result = prst.executeQuery();
/*  790: 793 */       while (result.next())
/*  791:     */       {
/*  792: 794 */         tot_due = result.getFloat("DEALER_TRANS_TOTAL_DUE");
/*  793:     */         
/*  794: 796 */         System.out.println(result.getFloat("DEALER_TRANS_TOTAL_DUE") + "FETCHED iDkkjjjjjjjjjjjjjjjjjjjjjjjjjj");
/*  795: 797 */         System.out.println(result.getFloat("DEALER_TRANS_TOTAL_DUE") + "FETCHED iDnnjjjjjjjjjjjjjjjjjjjjjjjjjjname name");
/*  796:     */       }
/*  797:     */     }
/*  798:     */     catch (Exception excep)
/*  799:     */     {
/*  800: 801 */       logger.error(
/*  801: 802 */         PurchaseSteelBarDaoImpl.class + "ERROR: while fetching the record from the Purchase table", 
/*  802: 803 */         excep);
/*  803:     */       
/*  804: 805 */       excep.printStackTrace();
/*  805:     */     }
/*  806:     */     finally
/*  807:     */     {
/*  808: 808 */       JdbcHelper.closeResultSet(result);
/*  809: 809 */       JdbcHelper.closePreparedStatement(prst);
/*  810: 810 */       JdbcHelper.closeConnection(con);
/*  811:     */     }
/*  812: 812 */     return tot_due;
/*  813:     */   }
/*  814:     */   
/*  815:     */   public void purchasePDF(HttpServletRequest request, HttpServletResponse response, int purchaseId)
/*  816:     */   {
/*  817: 818 */     String companyName = "Chouksay Traders";
/*  818: 819 */     String address1 = "BUS STAND SHAMSHABAD, DIST.- VIDISHA, MADHYA PRADESH, 464001";
/*  819: 820 */     String address2 = "GSTIN: 23AJQPC8200P1Z1";
/*  820: 821 */     String address3 = "PAN NO: AJQPC8200P";
/*  821:     */     
/*  822: 823 */     String city = "Vidisha-464001";
/*  823: 824 */     String state = "(M.P.)";
/*  824: 825 */     StringBuffer stringBuffer = null;
/*  825:     */     try
/*  826:     */     {
/*  827: 829 */       this.connection = getConnection();
/*  828:     */       
/*  829: 831 */       this.preparedStatement = this.connection
/*  830: 832 */         .prepareStatement("SELECT * FROM TAB_PURCHASE_STEEBAR_DETAIL WHERE PUR_STEEBAR_ID=?");
/*  831: 833 */       this.preparedStatement.setInt(1, purchaseId);
/*  832:     */       
/*  833:     */ 
/*  834: 836 */       this.resultSet = this.preparedStatement.executeQuery();
/*  835: 837 */       Document document = new Document(PageSize.A4);
/*  836:     */       
/*  837: 839 */       Font Font3 = new Font(Font.FontFamily.TIMES_ROMAN, 11.0F, 0);
/*  838: 840 */       Font Font2 = new Font(Font.FontFamily.TIMES_ROMAN, 6.0F, 
/*  839: 841 */         8);
/*  840: 842 */       Font Font4 = new Font(Font.FontFamily.TIMES_ROMAN, 11.0F, 1);
/*  841: 843 */       Font4.setColor(BaseColor.WHITE);
/*  842: 844 */       Font mainContent = new Font(Font.FontFamily.TIMES_ROMAN, 10.0F, 
/*  843: 845 */         0);
/*  844: 846 */       Font Font5 = new Font(Font.FontFamily.TIMES_ROMAN, 12.0F, 1);
/*  845: 847 */       Font5.setColor(BaseColor.GRAY);
/*  846: 848 */       Font Font6 = new Font(Font.FontFamily.TIMES_ROMAN, 10.0F, 1);
/*  847: 849 */       Font6.setColor(BaseColor.RED);
/*  848:     */       
/*  849:     */ 
/*  850: 852 */       response.setContentType("application/pdf");
/*  851:     */       
/*  852: 854 */       PdfWriter.getInstance(document, response.getOutputStream());
/*  853:     */       
/*  854: 856 */       document.open();
/*  855:     */       
/*  856: 858 */       String contextPath = ServletActionContext.getServletContext()
/*  857: 859 */         .getRealPath("/outer/img/bir3.png");
/*  858: 860 */       this.image = Image.getInstance(contextPath);
/*  859: 861 */       this.image.scaleToFit(130.0F, 70.0F);
/*  860:     */       
/*  861: 863 */       PdfPTable table1 = new PdfPTable(2);
/*  862: 864 */       table1.setWidthPercentage(100.0F);
/*  863: 865 */       Rectangle rect1 = new Rectangle(300.0F, 700.0F);
/*  864: 866 */       table1.setWidthPercentage(new float[] { 150.0F, 150.0F }, rect1);
/*  865:     */       
/*  866: 868 */       PdfPCell cell101 = new PdfPCell(this.image, false);
/*  867: 869 */       cell101.setPaddingTop(5.0F);
/*  868: 870 */       cell101.setBorder(0);
/*  869:     */       
/*  870: 872 */       Phrase phrase3 = new Phrase(companyName + "\n", Font5);
/*  871: 873 */       Phrase phrase = new Phrase(address1 + "\n", Font3);
/*  872: 874 */       Phrase phrase1 = new Phrase(address2 + "\n", Font3);
/*  873: 875 */       Phrase phrase4 = new Phrase(address3 + "\n", Font3);
/*  874: 876 */       Phrase phrase2 = new Phrase(city + "-" + state, Font3);
/*  875:     */       
/*  876: 878 */       Paragraph paragraph = new Paragraph();
/*  877: 879 */       paragraph.add(phrase3);
/*  878: 880 */       paragraph.add(phrase);
/*  879: 881 */       paragraph.add(phrase1);
/*  880: 882 */       paragraph.add(phrase4);
/*  881: 883 */       paragraph.add(phrase2);
/*  882:     */       
/*  883: 885 */       PdfPCell cell102 = new PdfPCell(paragraph);
/*  884: 886 */       cell102.setPaddingTop(5.0F);
/*  885: 887 */       cell102.setBorder(0);
/*  886: 888 */       cell102.setHorizontalAlignment(2);
/*  887:     */       
/*  888: 890 */       PdfPCell cell103 = new PdfPCell(
/*  889: 891 */         new Paragraph(
/*  890: 892 */         "   \n                                                                                                                                                                                                                                                                                                                                                  ", 
/*  891:     */         
/*  892:     */ 
/*  893: 895 */         Font2));
/*  894: 896 */       cell103.setColspan(2);
/*  895: 897 */       cell103.setBorderWidthRight(0.0F);
/*  896: 898 */       cell103.setBorderWidthLeft(0.0F);
/*  897: 899 */       cell103.setBorderWidthTop(0.5F);
/*  898: 900 */       cell103.setBorderWidthBottom(0.0F);
/*  899: 901 */       cell103.setBorderColorTop(BaseColor.WHITE);
/*  900:     */       
/*  901: 903 */       PdfPCell cell104 = new PdfPCell(new Paragraph("PURCHASE REPORT", Font4));
/*  902: 904 */       cell104.setUseBorderPadding(true);
/*  903: 905 */       cell104.setColspan(2);
/*  904: 906 */       cell104.setBorderWidthRight(0.1F);
/*  905: 907 */       cell104.setBorderWidthLeft(0.1F);
/*  906: 908 */       cell104.setBorderWidthTop(0.1F);
/*  907: 909 */       cell104.setBorderWidthBottom(0.1F);
/*  908: 910 */       cell104.setBorderColor(BaseColor.LIGHT_GRAY);
/*  909: 911 */       cell104.setBackgroundColor(new BaseColor(0, 59, 119));
/*  910:     */       
/*  911: 913 */       table1.addCell(cell101);
/*  912: 914 */       table1.addCell(cell102);
/*  913: 915 */       table1.addCell(cell103);
/*  914: 916 */       table1.addCell(cell104);
/*  915: 917 */       document.add(table1);
/*  916: 923 */       while (this.resultSet.next())
/*  917:     */       {
/*  918: 924 */         stringBuffer = new StringBuffer();
/*  919: 925 */         PdfPTable table = new PdfPTable(2);
/*  920: 926 */         table.setFooterRows(1);
/*  921: 927 */         table.setWidthPercentage(100.0F);
/*  922: 928 */         Rectangle rect = new Rectangle(300.0F, 700.0F);
/*  923: 929 */         table.setWidthPercentage(new float[] { 80.0F, 220.0F }, rect);
/*  924:     */         
/*  925: 931 */         PdfPCell cell = new PdfPCell(new Paragraph());
/*  926: 932 */         cell.setColspan(2);
/*  927: 933 */         cell.setBorderWidthRight(0.1F);
/*  928: 934 */         cell.setBorderWidthLeft(0.1F);
/*  929: 935 */         cell.setBorderWidthTop(0.1F);
/*  930: 936 */         cell.setBorderWidthBottom(0.2F);
/*  931: 937 */         cell.setBorderColor(BaseColor.LIGHT_GRAY);
/*  932: 938 */         cell.setBackgroundColor(new BaseColor(238, 238, 238));
/*  933:     */         
/*  934: 940 */         PdfPCell cell1 = new PdfPCell(new Paragraph());
/*  935: 941 */         cell1.setBackgroundColor(new BaseColor(238, 238, 238));
/*  936: 942 */         cell1.setBorderWidth(0.01F);
/*  937: 943 */         cell1.setBorderColor(BaseColor.WHITE);
/*  938:     */         
/*  939: 945 */         PdfPCell cell2 = new PdfPCell(new Paragraph());
/*  940: 946 */         cell2.setBackgroundColor(new BaseColor(238, 238, 238));
/*  941: 947 */         cell2.setBorderWidth(0.2F);
/*  942: 948 */         cell2.setBorderColor(BaseColor.WHITE);
/*  943:     */         
/*  944: 950 */         PdfPCell cell3 = new PdfPCell(new Paragraph("Purchase Id", 
/*  945: 951 */           mainContent));
/*  946: 952 */         cell3.setBackgroundColor(new BaseColor(238, 238, 238));
/*  947: 953 */         cell3.setBorderWidth(0.01F);
/*  948: 954 */         cell3.setBorderColor(BaseColor.WHITE);
/*  949:     */         
/*  950: 956 */         PdfPCell cell4 = new PdfPCell(new Paragraph(this.resultSet.getString("PUR_STEEBAR_ID"), mainContent));
/*  951: 957 */         cell4.setBorderWidth(0.2F);
/*  952: 958 */         cell4.setBorderColor(BaseColor.LIGHT_GRAY);
/*  953:     */         
/*  954: 960 */         PdfPCell cell5 = new PdfPCell(new Paragraph(
/*  955: 961 */           "Company Name", mainContent));
/*  956: 962 */         cell5.setBackgroundColor(new BaseColor(238, 238, 238));
/*  957: 963 */         cell5.setBorderWidth(0.01F);
/*  958: 964 */         cell5.setBorderColor(BaseColor.WHITE);
/*  959:     */         
/*  960: 966 */         PdfPCell cell6 = new PdfPCell(new Paragraph(this.resultSet.getString("PUR_STEEBAR_COMPANY_NAME"), mainContent));
/*  961: 967 */         cell6.setBorderWidth(0.2F);
/*  962: 968 */         cell6.setBorderColor(BaseColor.LIGHT_GRAY);
/*  963:     */         
/*  964: 970 */         PdfPCell cell7 = new PdfPCell(new Paragraph("Price", 
/*  965: 971 */           mainContent));
/*  966: 972 */         cell7.setBackgroundColor(new BaseColor(238, 238, 238));
/*  967: 973 */         cell7.setBorderWidth(0.01F);
/*  968: 974 */         cell7.setBorderColor(BaseColor.WHITE);
/*  969:     */         
/*  970: 976 */         PdfPCell cell8 = new PdfPCell(new Paragraph(
/*  971: 977 */           this.resultSet.getString("PUR_STEEBAR_PRICE"), mainContent));
/*  972: 978 */         cell8.setBorderWidth(0.2F);
/*  973: 979 */         cell8.setBorderColor(BaseColor.LIGHT_GRAY);
/*  974:     */         
/*  975:     */ 
/*  976:     */ 
/*  977: 983 */         PdfPCell cell9 = new PdfPCell(new Paragraph("Amount", 
/*  978: 984 */           mainContent));
/*  979: 985 */         cell9.setBorderWidth(0.2F);
/*  980: 986 */         cell9.setBorderColor(BaseColor.LIGHT_GRAY);
/*  981:     */         
/*  982: 988 */         PdfPCell cell10 = new PdfPCell(new Paragraph(
/*  983: 989 */           this.resultSet.getString("PUR_STEEBAR_AMOUNT"), mainContent));
/*  984: 990 */         cell10.setBorderWidth(0.2F);
/*  985: 991 */         cell10.setBorderColor(BaseColor.LIGHT_GRAY);
/*  986:     */         
/*  987: 993 */         PdfPCell cell11 = new PdfPCell(new Paragraph("GST", 
/*  988: 994 */           mainContent));
/*  989: 995 */         cell11.setBackgroundColor(new BaseColor(238, 238, 238));
/*  990: 996 */         cell11.setBorderWidth(0.01F);
/*  991: 997 */         cell11.setBorderColor(BaseColor.WHITE);
/*  992:     */         
/*  993: 999 */         PdfPCell cell12 = new PdfPCell(new Paragraph(this.resultSet.getString("PUR_STEEBAR_GST"), mainContent));
/*  994:1000 */         cell12.setBorderWidth(0.2F);
/*  995:1001 */         cell12.setBorderColor(BaseColor.LIGHT_GRAY);
/*  996:     */         
/*  997:1003 */         PdfPCell cell13 = new PdfPCell(new Paragraph("CGST", 
/*  998:1004 */           mainContent));
/*  999:1005 */         cell13.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1000:1006 */         cell13.setBorderWidth(0.01F);
/* 1001:1007 */         cell13.setBorderColor(BaseColor.WHITE);
/* 1002:     */         
/* 1003:1009 */         PdfPCell cell14 = new PdfPCell(new Paragraph(this.resultSet.getString("PUR_STEEBAR_CGST"), mainContent));
/* 1004:1010 */         cell14.setBorderWidth(0.2F);
/* 1005:1011 */         cell14.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1006:     */         
/* 1007:1013 */         PdfPCell cell15 = new PdfPCell(new Paragraph(
/* 1008:1014 */           "SGST", mainContent));
/* 1009:1015 */         cell15.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1010:1016 */         cell15.setBorderWidth(0.01F);
/* 1011:1017 */         cell15.setBorderColor(BaseColor.WHITE);
/* 1012:     */         
/* 1013:1019 */         PdfPCell cell16 = new PdfPCell(new Paragraph(this.resultSet.getString("PUR_STEEBAR_SGST"), mainContent));
/* 1014:1020 */         cell16.setBorderWidth(0.2F);
/* 1015:1021 */         cell16.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1016:     */         
/* 1017:1023 */         PdfPCell cell17 = new PdfPCell(new Paragraph("Dealer Name", 
/* 1018:1024 */           mainContent));
/* 1019:1025 */         cell17.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1020:1026 */         cell17.setBorderWidth(0.01F);
/* 1021:1027 */         cell17.setBorderColor(BaseColor.WHITE);
/* 1022:     */         
/* 1023:1029 */         PdfPCell cell18 = new PdfPCell(new Paragraph(this.resultSet.getString("PUR_STEEBAR_DEALER_NAME"), mainContent));
/* 1024:1030 */         cell18.setBorderWidth(0.2F);
/* 1025:1031 */         cell18.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1026:     */         
/* 1027:1033 */         PdfPCell cell19 = new PdfPCell(new Paragraph("Dealer Address", 
/* 1028:1034 */           mainContent));
/* 1029:1035 */         cell19.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1030:1036 */         cell19.setBorderWidth(0.01F);
/* 1031:1037 */         cell19.setBorderColor(BaseColor.WHITE);
/* 1032:     */         
/* 1033:1039 */         PdfPCell cell20 = new PdfPCell(new Paragraph(this.resultSet.getString("PUR_STEEBAR_DEALER_ADDRESS"), mainContent));
/* 1034:1040 */         cell20.setBorderWidth(0.2F);
/* 1035:1041 */         cell20.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1036:     */         
/* 1037:1043 */         PdfPCell cell21 = new PdfPCell(new Paragraph("Dealer Contact", 
/* 1038:1044 */           mainContent));
/* 1039:1045 */         cell21.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1040:1046 */         cell21.setBorderWidth(0.01F);
/* 1041:1047 */         cell21.setBorderColor(BaseColor.WHITE);
/* 1042:     */         
/* 1043:1049 */         PdfPCell cell22 = new PdfPCell(new Paragraph(this.resultSet.getString("PUR_STEEBAR_DEALER_CONTACT"), mainContent));
/* 1044:1050 */         cell22.setBorderWidth(0.2F);
/* 1045:1051 */         cell22.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1046:     */         
/* 1047:1053 */         PdfPCell cell23 = new PdfPCell(new Paragraph(
/* 1048:1054 */           "Dealer Reference", mainContent));
/* 1049:1055 */         cell23.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1050:1056 */         cell23.setBorderWidth(0.01F);
/* 1051:1057 */         cell23.setBorderColor(BaseColor.WHITE);
/* 1052:     */         
/* 1053:1059 */         PdfPCell cell24 = new PdfPCell(
/* 1054:1060 */           new Paragraph(this.resultSet.getString(
/* 1055:1061 */           "PUR_STEEBAR_DEALER_REF"), 
/* 1056:1062 */           mainContent));
/* 1057:1063 */         cell24.setBorderWidth(0.2F);
/* 1058:1064 */         cell24.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1059:     */         
/* 1060:1066 */         PdfPCell cell25 = new PdfPCell(new Paragraph("No. of Bags", 
/* 1061:1067 */           mainContent));
/* 1062:1068 */         cell25.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1063:1069 */         cell25.setBorderWidth(0.01F);
/* 1064:1070 */         cell25.setBorderColor(BaseColor.WHITE);
/* 1065:     */         
/* 1066:1072 */         PdfPCell cell26 = new PdfPCell(new Paragraph(
/* 1067:1073 */           this.resultSet.getString("PUR_STEEBAR_BAGS_NO"), mainContent));
/* 1068:1074 */         cell26.setBorderWidth(0.2F);
/* 1069:1075 */         cell26.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1070:     */         
/* 1071:1077 */         PdfPCell cell27 = new PdfPCell(new Paragraph("Bags In Ton", 
/* 1072:1078 */           mainContent));
/* 1073:1079 */         cell27.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1074:1080 */         cell27.setBorderWidth(0.01F);
/* 1075:1081 */         cell27.setBorderColor(BaseColor.WHITE);
/* 1076:     */         
/* 1077:1083 */         PdfPCell cell28 = new PdfPCell(new Paragraph(
/* 1078:1084 */           this.resultSet
/* 1079:1085 */           .getString("PUR_STEEBAR_BAGS_TON"), mainContent));
/* 1080:1086 */         cell28.setBorderWidth(0.2F);
/* 1081:1087 */         cell28.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1082:     */         
/* 1083:1089 */         PdfPCell cell29 = new PdfPCell(new Paragraph(
/* 1084:1090 */           "GST Amount", mainContent));
/* 1085:1091 */         cell29.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1086:1092 */         cell29.setBorderWidth(0.01F);
/* 1087:1093 */         cell29.setBorderColor(BaseColor.WHITE);
/* 1088:     */         
/* 1089:1095 */         PdfPCell cell30 = new PdfPCell(new Paragraph(
/* 1090:1096 */           this.resultSet
/* 1091:1097 */           .getString("PUR_STEEBAR_GST_AMOUNT"), 
/* 1092:1098 */           mainContent));
/* 1093:1099 */         cell30.setBorderWidth(0.2F);
/* 1094:1100 */         cell30.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1095:     */         
/* 1096:1102 */         PdfPCell cell31 = new PdfPCell(new Paragraph(
/* 1097:1103 */           "CGST Amount", Font6));
/* 1098:1104 */         cell31.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1099:1105 */         cell31.setBorderWidth(0.01F);
/* 1100:1106 */         cell31.setBorderColor(BaseColor.WHITE);
/* 1101:     */         
/* 1102:1108 */         PdfPCell cell32 = new PdfPCell(new Paragraph(
/* 1103:1109 */           this.resultSet
/* 1104:1110 */           .getString("PUR_STEEBAR_CGST_AMOUNT"), 
/* 1105:1111 */           mainContent));
/* 1106:1112 */         cell32.setBorderWidth(0.2F);
/* 1107:1113 */         cell32.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1108:     */         
/* 1109:1115 */         PdfPCell cell33 = new PdfPCell(new Paragraph(
/* 1110:1116 */           "SGST Amount", Font6));
/* 1111:1117 */         cell33.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1112:1118 */         cell33.setBorderWidth(0.01F);
/* 1113:1119 */         cell33.setBorderColor(BaseColor.WHITE);
/* 1114:     */         
/* 1115:1121 */         PdfPCell cell34 = new PdfPCell(new Paragraph(
/* 1116:1122 */           this.resultSet
/* 1117:1123 */           .getString("PUR_STEEBAR_SGST_AMOUNT"), 
/* 1118:1124 */           mainContent));
/* 1119:1125 */         cell34.setBorderWidth(0.2F);
/* 1120:1126 */         cell34.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1121:     */         
/* 1122:1128 */         PdfPCell cell35 = new PdfPCell(new Paragraph(
/* 1123:1129 */           "Invoice No", Font6));
/* 1124:1130 */         cell35.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1125:1131 */         cell35.setBorderWidth(0.01F);
/* 1126:1132 */         cell35.setBorderColor(BaseColor.WHITE);
/* 1127:     */         
/* 1128:1134 */         PdfPCell cell36 = new PdfPCell(new Paragraph(
/* 1129:1135 */           this.resultSet
/* 1130:1136 */           .getString("PUR_STEEBAR_INVOICE_NO"), 
/* 1131:1137 */           mainContent));
/* 1132:1138 */         cell36.setBorderWidth(0.2F);
/* 1133:1139 */         cell36.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1134:     */         
/* 1135:1141 */         PdfPCell cell37 = new PdfPCell(new Paragraph());
/* 1136:1142 */         cell37.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1137:1143 */         cell37.setBorderWidth(0.2F);
/* 1138:1144 */         cell37.setBorderColor(BaseColor.WHITE);
/* 1139:     */         
/* 1140:1146 */         PdfPCell cell38 = new PdfPCell(new Paragraph());
/* 1141:1147 */         cell38.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1142:1148 */         cell38.setBorderWidth(0.2F);
/* 1143:1149 */         cell38.setBorderColor(BaseColor.WHITE);
/* 1144:     */         
/* 1145:     */ 
/* 1146:1152 */         PdfPCell cell39 = new PdfPCell(new Paragraph("Order No", 
/* 1147:1153 */           mainContent));
/* 1148:1154 */         cell39.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1149:1155 */         cell39.setBorderWidth(0.01F);
/* 1150:1156 */         cell39.setBorderColor(BaseColor.WHITE);
/* 1151:     */         
/* 1152:1158 */         PdfPCell cell40 = new PdfPCell(new Paragraph(
/* 1153:1159 */           this.resultSet.getString("PUR_STEEBAR_ORDER_NO"), mainContent));
/* 1154:1160 */         cell40.setBorderWidth(0.2F);
/* 1155:1161 */         cell40.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1156:     */         
/* 1157:1163 */         PdfPCell cell41 = new PdfPCell(new Paragraph("Carrier Name", 
/* 1158:1164 */           mainContent));
/* 1159:1165 */         cell41.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1160:1166 */         cell41.setBorderWidth(0.01F);
/* 1161:1167 */         cell41.setBorderColor(BaseColor.WHITE);
/* 1162:     */         
/* 1163:1169 */         PdfPCell cell42 = new PdfPCell(new Paragraph(
/* 1164:1170 */           this.resultSet.getString("PUR_STEEBAR_CARRIER_NAME"), mainContent));
/* 1165:1171 */         cell42.setBorderWidth(0.2F);
/* 1166:1172 */         cell42.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1167:     */         
/* 1168:1174 */         PdfPCell cell43 = new PdfPCell(new Paragraph("Payment Mode", 
/* 1169:1175 */           mainContent));
/* 1170:1176 */         cell43.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1171:1177 */         cell43.setBorderWidth(0.01F);
/* 1172:1178 */         cell43.setBorderColor(BaseColor.WHITE);
/* 1173:     */         
/* 1174:1180 */         PdfPCell cell44 = new PdfPCell(new Paragraph(
/* 1175:1181 */           this.resultSet.getString("PUR_STEEBAR_PAYMENT_MODE"), mainContent));
/* 1176:1182 */         cell44.setBorderWidth(0.2F);
/* 1177:1183 */         cell44.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1178:     */         
/* 1179:1185 */         PdfPCell cell45 = new PdfPCell(new Paragraph("Payment", 
/* 1180:1186 */           mainContent));
/* 1181:1187 */         cell45.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1182:1188 */         cell45.setBorderWidth(0.01F);
/* 1183:1189 */         cell45.setBorderColor(BaseColor.WHITE);
/* 1184:     */         
/* 1185:1191 */         PdfPCell cell46 = new PdfPCell(new Paragraph(
/* 1186:1192 */           this.resultSet.getString("PUR_STEEBAR_PAYMENT"), mainContent));
/* 1187:1193 */         cell46.setBorderWidth(0.2F);
/* 1188:1194 */         cell46.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1189:     */         
/* 1190:1196 */         PdfPCell cell47 = new PdfPCell(new Paragraph("Invoice Date", 
/* 1191:1197 */           mainContent));
/* 1192:1198 */         cell47.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1193:1199 */         cell47.setBorderWidth(0.01F);
/* 1194:1200 */         cell47.setBorderColor(BaseColor.WHITE);
/* 1195:     */         
/* 1196:1202 */         PdfPCell cell48 = new PdfPCell(new Paragraph(this.resultSet.getString("PUR_STEEBAR_INVOICE_DATE"), mainContent));
/* 1197:1203 */         cell48.setBorderWidth(0.2F);
/* 1198:1204 */         cell48.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1199:     */         
/* 1200:1206 */         PdfPCell cell49 = new PdfPCell(new Paragraph("Material Code", 
/* 1201:1207 */           mainContent));
/* 1202:1208 */         cell49.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1203:1209 */         cell49.setBorderWidth(0.01F);
/* 1204:1210 */         cell49.setBorderColor(BaseColor.WHITE);
/* 1205:     */         
/* 1206:1212 */         PdfPCell cell50 = new PdfPCell(new Paragraph(
/* 1207:1213 */           this.resultSet.getString("PUR_STEEBAR_MATERIAL_CODE"), mainContent));
/* 1208:1214 */         cell50.setBorderWidth(0.2F);
/* 1209:1215 */         cell50.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1210:     */         
/* 1211:1217 */         PdfPCell cell51 = new PdfPCell(new Paragraph("HSN Code", 
/* 1212:1218 */           mainContent));
/* 1213:1219 */         cell51.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1214:1220 */         cell51.setBorderWidth(0.01F);
/* 1215:1221 */         cell51.setBorderColor(BaseColor.WHITE);
/* 1216:     */         
/* 1217:1223 */         PdfPCell cell52 = new PdfPCell(new Paragraph(
/* 1218:1224 */           this.resultSet.getString("PUR_STEEBAR_HSN_CODE"), mainContent));
/* 1219:1225 */         cell52.setBorderWidth(0.2F);
/* 1220:1226 */         cell52.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1221:     */         
/* 1222:1228 */         PdfPCell cell53 = new PdfPCell(new Paragraph("Unit Price", 
/* 1223:1229 */           mainContent));
/* 1224:1230 */         cell53.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1225:1231 */         cell53.setBorderWidth(0.01F);
/* 1226:1232 */         cell53.setBorderColor(BaseColor.WHITE);
/* 1227:     */         
/* 1228:1234 */         PdfPCell cell54 = new PdfPCell(new Paragraph(
/* 1229:1235 */           this.resultSet.getString("PUR_STEEBAR_UNIT_PRICE"), mainContent));
/* 1230:1236 */         cell54.setBorderWidth(0.2F);
/* 1231:1237 */         cell54.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1232:     */         
/* 1233:1239 */         PdfPCell cell55 = new PdfPCell(new Paragraph(
/* 1234:1240 */           "Discount", mainContent));
/* 1235:1241 */         cell55.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1236:1242 */         cell55.setBorderWidth(0.01F);
/* 1237:1243 */         cell55.setBorderColor(BaseColor.WHITE);
/* 1238:     */         
/* 1239:1245 */         PdfPCell cell56 = new PdfPCell(new Paragraph(
/* 1240:1246 */           this.resultSet.getString("PUR_STEEBAR_DISCOUNT"), mainContent));
/* 1241:1247 */         cell56.setBorderWidth(0.2F);
/* 1242:1248 */         cell56.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1243:     */         
/* 1244:1250 */         PdfPCell cell57 = new PdfPCell(new Paragraph(
/* 1245:1251 */           "Delivery Place", mainContent));
/* 1246:1252 */         cell57.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1247:1253 */         cell57.setBorderWidth(0.01F);
/* 1248:1254 */         cell57.setBorderColor(BaseColor.WHITE);
/* 1249:     */         
/* 1250:1256 */         PdfPCell cell58 = new PdfPCell(new Paragraph(
/* 1251:1257 */           this.resultSet.getString("PUR_STEEBAR_DELIVERY_PLACE"), 
/* 1252:1258 */           mainContent));
/* 1253:1259 */         cell58.setBorderWidth(0.2F);
/* 1254:1260 */         cell58.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1255:     */         
/* 1256:     */ 
/* 1257:     */ 
/* 1258:     */ 
/* 1259:     */ 
/* 1260:1266 */         table.addCell(cell);
/* 1261:1267 */         table.addCell(cell1);
/* 1262:1268 */         table.addCell(cell2);
/* 1263:1269 */         table.addCell(cell3);
/* 1264:1270 */         table.addCell(cell4);
/* 1265:1271 */         table.addCell(cell5);
/* 1266:1272 */         table.addCell(cell6);
/* 1267:1273 */         table.addCell(cell7);
/* 1268:1274 */         table.addCell(cell8);
/* 1269:1275 */         table.addCell(cell9);
/* 1270:1276 */         table.addCell(cell10);
/* 1271:1277 */         table.addCell(cell11);
/* 1272:1278 */         table.addCell(cell12);
/* 1273:1279 */         table.addCell(cell13);
/* 1274:1280 */         table.addCell(cell14);
/* 1275:1281 */         table.addCell(cell15);
/* 1276:1282 */         table.addCell(cell16);
/* 1277:1283 */         table.addCell(cell17);
/* 1278:1284 */         table.addCell(cell18);
/* 1279:1285 */         table.addCell(cell19);
/* 1280:1286 */         table.addCell(cell20);
/* 1281:1287 */         table.addCell(cell21);
/* 1282:1288 */         table.addCell(cell22);
/* 1283:1289 */         table.addCell(cell23);
/* 1284:1290 */         table.addCell(cell24);
/* 1285:1291 */         table.addCell(cell25);
/* 1286:1292 */         table.addCell(cell26);
/* 1287:1293 */         table.addCell(cell27);
/* 1288:1294 */         table.addCell(cell28);
/* 1289:1295 */         table.addCell(cell29);
/* 1290:1296 */         table.addCell(cell30);
/* 1291:1297 */         table.addCell(cell31);
/* 1292:1298 */         table.addCell(cell32);
/* 1293:1299 */         table.addCell(cell33);
/* 1294:1300 */         table.addCell(cell34);
/* 1295:1301 */         table.addCell(cell35);
/* 1296:1302 */         table.addCell(cell36);
/* 1297:1303 */         table.addCell(cell37);
/* 1298:1304 */         table.addCell(cell38);
/* 1299:1305 */         table.addCell(cell39);
/* 1300:1306 */         table.addCell(cell40);
/* 1301:1307 */         table.addCell(cell41);
/* 1302:1308 */         table.addCell(cell42);
/* 1303:1309 */         table.addCell(cell43);
/* 1304:1310 */         table.addCell(cell44);
/* 1305:1311 */         table.addCell(cell45);
/* 1306:1312 */         table.addCell(cell46);
/* 1307:1313 */         table.addCell(cell47);
/* 1308:1314 */         table.addCell(cell48);
/* 1309:1315 */         table.addCell(cell49);
/* 1310:1316 */         table.addCell(cell50);
/* 1311:1317 */         table.addCell(cell51);
/* 1312:1318 */         table.addCell(cell52);
/* 1313:1319 */         table.addCell(cell53);
/* 1314:1320 */         table.addCell(cell54);
/* 1315:1321 */         table.addCell(cell55);
/* 1316:1322 */         table.addCell(cell56);
/* 1317:1323 */         table.addCell(cell57);
/* 1318:1324 */         table.addCell(cell58);
/* 1319:     */         
/* 1320:     */ 
/* 1321:     */ 
/* 1322:     */ 
/* 1323:1329 */         document.add(table);
/* 1324:     */       }
/* 1325:1333 */       document.add(new Paragraph("\n"));
/* 1326:1334 */       document.add(new Paragraph(
/* 1327:1335 */         "Â© 2016 BirjaSoft Technologies. All Rights Reserved.", 
/* 1328:1336 */         mainContent));
/* 1329:1337 */       document.close();
/* 1330:     */     }
/* 1331:     */     catch (SQLException sqlExp)
/* 1332:     */     {
/* 1333:1340 */       sqlExp.printStackTrace();
/* 1334:1341 */       logger.error(
/* 1335:1342 */         PurchaseSteelBarDaoImpl.class + 
/* 1336:1343 */         "Error: Occur in Query While Fetching All Purchase Details for print PdF from Database.", 
/* 1337:1344 */         sqlExp);
/* 1338:     */     }
/* 1339:     */     catch (Exception exception)
/* 1340:     */     {
/* 1341:1346 */       exception.printStackTrace();
/* 1342:1347 */       logger.error(
/* 1343:1348 */         PurchaseSteelBarDaoImpl.class + 
/* 1344:1349 */         "Error: Occur in Query While Closing Connection After Fetching All Purchase Details for print PdF from Database.", 
/* 1345:1350 */         exception);
/* 1346:     */     }
/* 1347:     */     finally
/* 1348:     */     {
/* 1349:1352 */       JdbcHelper.closeResultSet(this.resultSet);
/* 1350:1353 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/* 1351:1354 */       JdbcHelper.closeConnection(this.connection);
/* 1352:     */     }
/* 1353:     */   }
/* 1354:     */   
/* 1355:     */   public List<PurchaseSteelBarVO> retrivePurchaseSteelBarDetailsForSearch(int searchId, String searchValue)
/* 1356:     */   {
/* 1357:1362 */     List<PurchaseSteelBarVO> purchaseSteelbarDetailList = new ArrayList();
/* 1358:     */     try
/* 1359:     */     {
/* 1360:1365 */       System.out.println("ggggggggggggggggg we r in stell dao**********" + searchId + " " + searchValue);
/* 1361:1366 */       this.connection = getConnection();
/* 1362:     */       
/* 1363:     */ 
/* 1364:     */ 
/* 1365:1370 */       this.preparedStatement = this.connection.prepareStatement(
/* 1366:1371 */         QueryBuilder.PurchaseSteelbarAdvanceSearchForAdmin(searchId, searchValue));
/* 1367:     */       
/* 1368:     */ 
/* 1369:1374 */       this.resultSet = this.preparedStatement.executeQuery();
/* 1370:1378 */       while (this.resultSet.next())
/* 1371:     */       {
/* 1372:1379 */         this.purchaseSteelBarVO = new PurchaseSteelBarVO();
/* 1373:1380 */         this.purchaseSteelBarVO.setPurchaseId(this.resultSet.getInt("PUR_STEEBAR_ID"));
/* 1374:     */         
/* 1375:1382 */         this.purchaseSteelBarVO.setDealerName(this.nameHelper.getDealerNameById(this.resultSet.getInt("PUR_STEEBAR_DEALER_REF")));
/* 1376:1383 */         this.purchaseSteelBarVO.setDealerContact(this.resultSet.getString("PUR_STEEBAR_DEALER_CONTACT"));
/* 1377:     */         
/* 1378:1385 */         this.purchaseSteelBarVO.setCompanyName(this.resultSet.getString("PUR_STEEBAR_COMPANY_NAME"));
/* 1379:     */         
/* 1380:1387 */         this.purchaseSteelBarVO.setQuantityInKg(this.resultSet
/* 1381:1388 */           .getInt("PUR_STEEBAR_BAGS_NO"));
/* 1382:     */         
/* 1383:1390 */         this.purchaseSteelBarVO.setQuantity(this.resultSet
/* 1384:1391 */           .getInt("PUR_STEEBAR_BAGS_TON"));
/* 1385:     */         
/* 1386:1393 */         this.purchaseSteelBarVO.setInvoiceNo(this.resultSet
/* 1387:1394 */           .getString("PUR_STEEBAR_INVOICE_NO"));
/* 1388:     */         
/* 1389:     */ 
/* 1390:1397 */         this.purchaseSteelBarVO.setOrderNo(this.resultSet
/* 1391:1398 */           .getString("PUR_STEEBAR_ORDER_NO"));
/* 1392:     */         
/* 1393:1400 */         this.purchaseSteelBarVO.setTransporter(this.resultSet
/* 1394:1401 */           .getString("PUR_STEEBAR_CARRIER_NAME"));
/* 1395:     */         
/* 1396:1403 */         this.purchaseSteelBarVO.setInvoiceDate(this.resultSet
/* 1397:1404 */           .getString("PUR_STEEBAR_INVOICE_DATE"));
/* 1398:     */         
/* 1399:1406 */         this.purchaseSteelBarVO.setMaterialCode(this.resultSet
/* 1400:1407 */           .getString("PUR_STEEBAR_MATERIAL_CODE"));
/* 1401:     */         
/* 1402:     */ 
/* 1403:1410 */         this.purchaseSteelBarVO.setUnitPrice(this.resultSet
/* 1404:1411 */           .getFloat("PUR_STEEBAR_UNIT_PRICE"));
/* 1405:1412 */         this.purchaseSteelBarVO.setNetAmount(this.resultSet
/* 1406:1413 */           .getFloat("PUR_STEEBAR_AMOUNT"));
/* 1407:1414 */         this.purchaseSteelBarVO.setGst(this.resultSet
/* 1408:1415 */           .getFloat("PUR_STEEBAR_GST"));
/* 1409:     */         
/* 1410:     */ 
/* 1411:1418 */         System.out.println(this.resultSet.getFloat("PUR_STEEBAR_UNIT_PRICE") + " " + this.resultSet.getFloat("PUR_STEEBAR_GST") + "vvvvvvvvvvvv");
/* 1412:1419 */         purchaseSteelbarDetailList.add(this.purchaseSteelBarVO);
/* 1413:     */       }
/* 1414:     */     }
/* 1415:     */     catch (SQLException sqlExp)
/* 1416:     */     {
/* 1417:1423 */       sqlExp.printStackTrace();
/* 1418:1424 */       logger.error(
/* 1419:1425 */         PurchaseSteelBarDaoImpl.class + 
/* 1420:1426 */         "Error: Occur in Query While Fetching the steelbar purchase Details For advance search from Database.", 
/* 1421:1427 */         sqlExp);
/* 1422:     */     }
/* 1423:     */     catch (Exception exception)
/* 1424:     */     {
/* 1425:1429 */       exception.printStackTrace();
/* 1426:1430 */       logger.error(
/* 1427:1431 */         PurchaseSteelBarDaoImpl.class + 
/* 1428:1432 */         "Error: Occur in Query While Closing Connection After Fetching the steelbar purchase For advance search from Database.", 
/* 1429:1433 */         exception);
/* 1430:     */     }
/* 1431:     */     finally
/* 1432:     */     {
/* 1433:1435 */       JdbcHelper.closeResultSet(this.resultSet);
/* 1434:1436 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/* 1435:1437 */       JdbcHelper.closeConnection(this.connection);
/* 1436:     */     }
/* 1437:1439 */     return purchaseSteelbarDetailList;
/* 1438:     */   }
/* 1439:     */   
/* 1440:     */   public int getPurchaseSteelbarLastRecord()
/* 1441:     */     throws RecordNotFoundException
/* 1442:     */   {
/* 1443:1444 */     int temp = 0;
/* 1444:     */     try
/* 1445:     */     {
/* 1446:1446 */       this.connection = getConnection();
/* 1447:     */       
/* 1448:1448 */       this.preparedStatement = this.connection
/* 1449:1449 */         .prepareStatement("SELECT  PUR_STEEBAR_ID FROM TAB_PURCHASE_STEEBAR_DETAIL  ORDER BY PUR_STEEBAR_ID DESC LIMIT 1");
/* 1450:     */       
/* 1451:     */ 
/* 1452:1452 */       this.resultSet = this.preparedStatement.executeQuery();
/* 1453:1453 */       if (this.resultSet != null) {
/* 1454:1454 */         while (this.resultSet.next()) {
/* 1455:1456 */           temp = this.resultSet.getInt("PUR_STEEBAR_ID");
/* 1456:     */         }
/* 1457:     */       }
/* 1458:     */     }
/* 1459:     */     catch (SQLException sqlException)
/* 1460:     */     {
/* 1461:1461 */       sqlException.printStackTrace();
/* 1462:1462 */       logger.error(
/* 1463:1463 */         PurchaseSteelBarDaoImpl.class + 
/* 1464:1464 */         ": Error:- Error: Occur in Query While counting the Purchase steelbar details recods from Database", 
/* 1465:1465 */         sqlException);
/* 1466:     */     }
/* 1467:     */     catch (Exception exception)
/* 1468:     */     {
/* 1469:1468 */       exception.printStackTrace();
/* 1470:1469 */       logger.error(
/* 1471:1470 */         PurchaseSteelBarDaoImpl.class + 
/* 1472:1471 */         ": Error:- While closing the Connection after counting the Purchase steelbar details recods from Database", 
/* 1473:1472 */         exception);
/* 1474:     */     }
/* 1475:     */     finally
/* 1476:     */     {
/* 1477:1474 */       JdbcHelper.closeResultSet(this.resultSet);
/* 1478:1475 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/* 1479:1476 */       JdbcHelper.closeConnection(this.connection);
/* 1480:     */     }
/* 1481:1478 */     return temp;
/* 1482:     */   }
/* 1483:     */   
/* 1484:     */   public PurchaseSteelbar getPurchaseSteelbarDetails(int purchaseId)
/* 1485:     */     throws RecordNotFoundException
/* 1486:     */   {
/* 1487:1484 */     PurchaseSteelbar purchaseSteelbar = new PurchaseSteelbar();
/* 1488:     */     try
/* 1489:     */     {
/* 1490:1487 */       this.connection = getConnection();
/* 1491:     */       
/* 1492:1489 */       this.preparedStatement = this.connection
/* 1493:1490 */         .prepareStatement("SELECT * FROM TAB_PURCHASE_STEEBAR_DETAIL WHERE PUR_STEEBAR_ID=?");
/* 1494:1491 */       this.preparedStatement.setInt(1, purchaseId);
/* 1495:     */       
/* 1496:     */ 
/* 1497:1494 */       this.resultSet = this.preparedStatement.executeQuery();
/* 1498:1495 */       System.out.println("----------hye ----------------");
/* 1499:1496 */       if (this.resultSet != null) {
/* 1500:1497 */         while (this.resultSet.next())
/* 1501:     */         {
/* 1502:1499 */           System.out.println("----------hye ----------------");
/* 1503:     */           
/* 1504:1501 */           purchaseSteelbar.setPurchaseId(this.resultSet.getInt("PUR_STEEBAR_ID"));
/* 1505:1502 */           System.out.println("________________" + this.resultSet.getInt("PUR_STEEBAR_ID"));
/* 1506:     */           
/* 1507:1504 */           purchaseSteelbar.setCompanyName(this.resultSet.getString("PUR_STEEBAR_COMPANY_NAME"));
/* 1508:1505 */           System.out.println("---------" + this.resultSet.getString("PUR_STEEBAR_PRICE"));
/* 1509:     */           
/* 1510:     */ 
/* 1511:     */ 
/* 1512:     */ 
/* 1513:     */ 
/* 1514:1511 */           purchaseSteelbar.setNetAmount(this.resultSet
/* 1515:1512 */             .getFloat("PUR_STEEBAR_AMOUNT"));
/* 1516:     */           
/* 1517:1514 */           purchaseSteelbar.setGst(this.resultSet
/* 1518:1515 */             .getFloat("PUR_STEEBAR_GST"));
/* 1519:     */           
/* 1520:1517 */           purchaseSteelbar.setCgst(this.resultSet
/* 1521:1518 */             .getFloat("PUR_STEEBAR_CGST"));
/* 1522:     */           
/* 1523:1520 */           purchaseSteelbar.setSgst(this.resultSet
/* 1524:1521 */             .getFloat("PUR_STEEBAR_SGST"));
/* 1525:     */           
/* 1526:1523 */           purchaseSteelbar.setDealerName(this.resultSet.getString("PUR_STEEBAR_DEALER_NAME"));
/* 1527:     */           
/* 1528:1525 */           purchaseSteelbar.setDealerContact(this.resultSet.getString("PUR_STEEBAR_DEALER_CONTACT"));
/* 1529:     */           
/* 1530:1527 */           purchaseSteelbar.setDealerAddress(this.resultSet.getString("PUR_STEEBAR_DEALER_ADDRESS"));
/* 1531:     */           
/* 1532:1529 */           purchaseSteelbar.setDealerRef(this.resultSet.getInt("PUR_STEEBAR_DEALER_REF"));
/* 1533:     */           
/* 1534:1531 */           purchaseSteelbar.setQuantityInKg(this.resultSet
/* 1535:1532 */             .getInt("PUR_STEEBAR_BAGS_NO"));
/* 1536:     */           
/* 1537:1534 */           purchaseSteelbar.setQuantity(this.resultSet
/* 1538:1535 */             .getFloat("PUR_CEMENT_BAGS_TON"));
/* 1539:     */           
/* 1540:1537 */           purchaseSteelbar.setGstAmount(this.resultSet
/* 1541:1538 */             .getFloat("PUR_STEEBAR_GST_AMOUNT"));
/* 1542:1539 */           purchaseSteelbar.setCgstAmount(this.resultSet
/* 1543:1540 */             .getFloat("PUR_STEEBAR_CGST_AMOUNT"));
/* 1544:1541 */           purchaseSteelbar.setSgstAmount(this.resultSet
/* 1545:1542 */             .getFloat("PUR_STEEBAR_SGST_AMOUNT"));
/* 1546:1543 */           purchaseSteelbar.setInvoiceNo(this.resultSet
/* 1547:1544 */             .getString("PUR_STEEBAR_INVOICE_NO"));
/* 1548:     */           
/* 1549:1546 */           purchaseSteelbar.setOrderNo(this.resultSet
/* 1550:1547 */             .getString("PUR_STEEBAR_ORDER_NO"));
/* 1551:     */           
/* 1552:1549 */           purchaseSteelbar.setTransporter(this.resultSet
/* 1553:1550 */             .getString("PUR_STEEBAR_CARRIER_NAME"));
/* 1554:     */           
/* 1555:     */ 
/* 1556:     */ 
/* 1557:     */ 
/* 1558:1555 */           purchaseSteelbar.setWeekNo(this.resultSet
/* 1559:1556 */             .getString("PUR_STEEBAR_WEEK_NO"));
/* 1560:     */           
/* 1561:1558 */           purchaseSteelbar.setInconterm(this.resultSet
/* 1562:1559 */             .getString("PUR_STEEBAR_INCOTERM"));
/* 1563:     */           
/* 1564:     */ 
/* 1565:     */ 
/* 1566:1563 */           purchaseSteelbar.setInvoiceDate(this.resultSet
/* 1567:1564 */             .getString("PUR_STEEBAR_INVOICE_DATE"));
/* 1568:     */           
/* 1569:1566 */           purchaseSteelbar.setMaterialCode(this.resultSet
/* 1570:1567 */             .getString("PUR_STEEBAR_MATERIAL_CODE"));
/* 1571:     */           
/* 1572:     */ 
/* 1573:1570 */           purchaseSteelbar.setHsnCode(this.resultSet
/* 1574:1571 */             .getString("PUR_STEEBAR_HSN_CODE"));
/* 1575:     */           
/* 1576:1573 */           purchaseSteelbar.setDeliveryPlace(this.resultSet
/* 1577:1574 */             .getString("PUR_STEEBAR_DELIVERY_PLACE"));
/* 1578:     */           
/* 1579:1576 */           purchaseSteelbar.setUnitPrice(this.resultSet
/* 1580:1577 */             .getFloat("PUR_STEEBAR_UNIT_PRICE"));
/* 1581:     */         }
/* 1582:     */       }
/* 1583:     */     }
/* 1584:     */     catch (SQLException sqlExp)
/* 1585:     */     {
/* 1586:1587 */       sqlExp.printStackTrace();
/* 1587:1588 */       logger.error(
/* 1588:1589 */         PurchaseSteelBarDaoImpl.class + 
/* 1589:1590 */         "Error: Occur in Query While Fetching the specific steelbar purchase Details from Database.", 
/* 1590:1591 */         sqlExp);
/* 1591:     */     }
/* 1592:     */     catch (Exception exception)
/* 1593:     */     {
/* 1594:1593 */       exception.printStackTrace();
/* 1595:1594 */       logger.error(
/* 1596:1595 */         PurchaseSteelBarDaoImpl.class + 
/* 1597:1596 */         "Error: Occur in Query While Closing Connection After Fetching the specific steelbar purchase Details from Database.", 
/* 1598:1597 */         exception);
/* 1599:     */     }
/* 1600:     */     finally
/* 1601:     */     {
/* 1602:1599 */       JdbcHelper.closeResultSet(this.resultSet);
/* 1603:1600 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/* 1604:1601 */       JdbcHelper.closeConnection(this.connection);
/* 1605:     */     }
/* 1606:1605 */     return purchaseSteelbar;
/* 1607:     */   }
/* 1608:     */   
/* 1609:     */   public List<PurchaseSteelBarVO> viewSteelbarStockGrid()
/* 1610:     */     throws RecordNotFoundException
/* 1611:     */   {
/* 1612:1611 */     List<PurchaseSteelBarVO> purchaseSteelbarDetailList = new ArrayList();
/* 1613:     */     try
/* 1614:     */     {
/* 1615:1615 */       this.connection = getConnection();
/* 1616:1616 */       this.preparedStatement = this.connection
/* 1617:1617 */         .prepareStatement("SELECT PUR_STEEBAR_ID,PUR_STEEBAR_INCOTERM,PUR_STEEBAR_MATERIAL_CODE,PUR_STEEBAR_COMPANY_NAME,PUR_STEEBAR_PRICE,PUR_STEEBAR_AMOUNT, PUR_STEEBAR_BAGS_NO,SUM(PUR_STEEBAR_BAGS_NO) FROM TAB_PURCHASE_STEEBAR_DETAIL GROUP BY PUR_STEEBAR_INCOTERM");
/* 1618:1618 */       this.resultSet = this.preparedStatement.executeQuery();
/* 1619:1622 */       while (this.resultSet.next())
/* 1620:     */       {
/* 1621:1623 */         this.purchaseSteelBarVO = new PurchaseSteelBarVO();
/* 1622:1624 */         this.purchaseSteelBarVO.setPurchaseId(this.resultSet.getInt("PUR_STEEBAR_ID"));
/* 1623:     */         
/* 1624:     */ 
/* 1625:     */ 
/* 1626:     */ 
/* 1627:1629 */         this.purchaseSteelBarVO.setCompanyName(this.resultSet.getString("PUR_STEEBAR_COMPANY_NAME"));
/* 1628:     */         
/* 1629:1631 */         this.purchaseSteelBarVO.setQuantity(this.resultSet
/* 1630:1632 */           .getInt("SUM(PUR_STEEBAR_BAGS_NO)"));
/* 1631:     */         
/* 1632:     */ 
/* 1633:     */ 
/* 1634:     */ 
/* 1635:     */ 
/* 1636:     */ 
/* 1637:     */ 
/* 1638:     */ 
/* 1639:     */ 
/* 1640:     */ 
/* 1641:     */ 
/* 1642:     */ 
/* 1643:     */ 
/* 1644:     */ 
/* 1645:     */ 
/* 1646:     */ 
/* 1647:     */ 
/* 1648:     */ 
/* 1649:1651 */         this.purchaseSteelBarVO.setUnitPrice(this.resultSet
/* 1650:1652 */           .getFloat("PUR_STEEBAR_PRICE"));
/* 1651:1653 */         this.purchaseSteelBarVO.setNetAmount(this.resultSet
/* 1652:1654 */           .getFloat("PUR_STEEBAR_AMOUNT"));
/* 1653:     */         
/* 1654:     */ 
/* 1655:1657 */         this.purchaseSteelBarVO.setInconterm(this.nameHelper.getProductTypeNameByProductId(this.resultSet
/* 1656:1658 */           .getInt("PUR_STEEBAR_INCOTERM")));
/* 1657:     */         
/* 1658:1660 */         purchaseSteelbarDetailList.add(this.purchaseSteelBarVO);
/* 1659:     */       }
/* 1660:     */     }
/* 1661:     */     catch (SQLException sqlExp)
/* 1662:     */     {
/* 1663:1664 */       sqlExp.printStackTrace();
/* 1664:1665 */       logger.error(
/* 1665:1666 */         PurchaseSteelBarDaoImpl.class + 
/* 1666:1667 */         "Error: Occur in Query While Fetching the steelbar purchase Details into Grid from Database.", 
/* 1667:1668 */         sqlExp);
/* 1668:     */     }
/* 1669:     */     catch (Exception exception)
/* 1670:     */     {
/* 1671:1670 */       exception.printStackTrace();
/* 1672:1671 */       logger.error(
/* 1673:1672 */         PurchaseSteelBarDaoImpl.class + 
/* 1674:1673 */         "Error: Occur in Query While Closing Connection After Fetching the steelbar purchase into Grid from Database.", 
/* 1675:1674 */         exception);
/* 1676:     */     }
/* 1677:     */     finally
/* 1678:     */     {
/* 1679:1676 */       JdbcHelper.closeResultSet(this.resultSet);
/* 1680:1677 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/* 1681:1678 */       JdbcHelper.closeConnection(this.connection);
/* 1682:     */     }
/* 1683:1680 */     return purchaseSteelbarDetailList;
/* 1684:     */   }
/* 1685:     */   
/* 1686:     */   public int isItemAlreadyExistInStock(String inconterm)
/* 1687:     */     throws RecordNotFoundException
/* 1688:     */   {
/* 1689:1686 */     int existence = 0;
/* 1690:     */     try
/* 1691:     */     {
/* 1692:1688 */       this.connection = getConnection();
/* 1693:     */       
/* 1694:1690 */       this.preparedStatement = this.connection
/* 1695:1691 */         .prepareStatement("SELECT  STOCK_BAGS_NO FROM TAB_STOCK_DETAILS WHERE STOCK_PRODUCT_TYPE=?");
/* 1696:1692 */       this.preparedStatement.setString(1, inconterm);
/* 1697:     */       
/* 1698:     */ 
/* 1699:1695 */       this.resultSet = this.preparedStatement.executeQuery();
/* 1700:1697 */       if (this.resultSet != null) {
/* 1701:1698 */         while (this.resultSet.next()) {
/* 1702:1700 */           existence = this.resultSet.getInt("STOCK_BAGS_NO");
/* 1703:     */         }
/* 1704:     */       }
/* 1705:     */     }
/* 1706:     */     catch (SQLException sqlExp)
/* 1707:     */     {
/* 1708:1707 */       sqlExp.printStackTrace();
/* 1709:1708 */       logger.error(
/* 1710:1709 */         PurchaseSteelBarDaoImpl.class + 
/* 1711:1710 */         "Error: Occur in Query While Fetching the stock Details from Database.", 
/* 1712:1711 */         sqlExp);
/* 1713:     */     }
/* 1714:     */     catch (Exception exception)
/* 1715:     */     {
/* 1716:1713 */       exception.printStackTrace();
/* 1717:1714 */       logger.error(
/* 1718:1715 */         PurchaseSteelBarDaoImpl.class + 
/* 1719:1716 */         "Error: Occur in Query While Closing Connection After Fetching the stock Details from Database.", 
/* 1720:1717 */         exception);
/* 1721:     */     }
/* 1722:     */     finally
/* 1723:     */     {
/* 1724:1719 */       JdbcHelper.closeResultSet(this.resultSet);
/* 1725:1720 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/* 1726:1721 */       JdbcHelper.closeConnection(this.connection);
/* 1727:     */     }
/* 1728:1723 */     return existence;
/* 1729:     */   }
/* 1730:     */   
/* 1731:     */   public void updateStockDetails(PurchaseSteelBarVO purchaseSteelBarVO, int checks)
/* 1732:     */     throws UpdateFailedException
/* 1733:     */   {
/* 1734:1729 */     Connection connection = null;
/* 1735:1730 */     PreparedStatement preparedStatement = null;
/* 1736:1731 */     System.out.println("update is running************************" + purchaseSteelBarVO.getUnitPrice());
/* 1737:     */     try
/* 1738:     */     {
/* 1739:1734 */       String up = "UPDATE TAB_STOCK_DETAILS SET  STOCK_PURCHASE_PRICE=?, STOCK_AMOUNT=?, STOCK_BAGS_NO=?, STOCK_BAGS_TON=?,STOCK_MATERIAL_CODE=?, STOCK_HSN_CODE=?, STOCK_UNIT_PRICE=?, STOCK_CATEGORY=? WHERE STOCK_PRODUCT_TYPE=?";
/* 1740:     */       
/* 1741:1736 */       System.out.println("fffffffffffffffffffffF" + checks);
/* 1742:1737 */       float quantInTon = purchaseSteelBarVO.getQuantity();
/* 1743:1738 */       float quantInKg = quantInTon * 1000.0F;
/* 1744:     */       
/* 1745:1740 */       connection = getConnection();
/* 1746:1741 */       preparedStatement = connection
/* 1747:1742 */         .prepareStatement(up);
/* 1748:1743 */       preparedStatement.setFloat(1, purchaseSteelBarVO.getUnitPrice());
/* 1749:1744 */       preparedStatement.setFloat(2, purchaseSteelBarVO.getNetAmount());
/* 1750:1745 */       preparedStatement.setFloat(3, quantInKg + checks);
/* 1751:1746 */       preparedStatement.setFloat(4, purchaseSteelBarVO.getQuantity() + checks);
/* 1752:1747 */       preparedStatement.setString(5, purchaseSteelBarVO.getMaterialCode());
/* 1753:1748 */       preparedStatement.setString(6, purchaseSteelBarVO.getHsnCode());
/* 1754:     */       
/* 1755:1750 */       preparedStatement.setFloat(7, purchaseSteelBarVO.getUnitPrice());
/* 1756:1751 */       preparedStatement.setInt(8, this.nameHelper.getProductCategoryIdByProductType(Integer.parseInt(purchaseSteelBarVO.getInconterm())));
/* 1757:1752 */       preparedStatement.setString(9, purchaseSteelBarVO.getInconterm());
/* 1758:     */       
/* 1759:1754 */       preparedStatement.executeUpdate();
/* 1760:     */     }
/* 1761:     */     catch (SQLException sqlExp)
/* 1762:     */     {
/* 1763:1757 */       sqlExp.printStackTrace();
/* 1764:1758 */       logger.error(
/* 1765:1759 */         PurchaseSteelBarDaoImpl.class + 
/* 1766:1760 */         "Error: Occur in Query While updating the specific cement purchase Details.", 
/* 1767:1761 */         sqlExp);
/* 1768:     */     }
/* 1769:     */     catch (Exception exception)
/* 1770:     */     {
/* 1771:1763 */       exception.printStackTrace();
/* 1772:1764 */       logger.error(
/* 1773:1765 */         PurchaseSteelBarDaoImpl.class + 
/* 1774:1766 */         "Error: Occur in Query While Closing Connection After updating the specific cement purchase Details.", 
/* 1775:1767 */         exception);
/* 1776:     */     }
/* 1777:     */     finally
/* 1778:     */     {
/* 1779:1769 */       JdbcHelper.closeResultSet(this.resultSet);
/* 1780:1770 */       JdbcHelper.closePreparedStatement(preparedStatement);
/* 1781:1771 */       JdbcHelper.closeConnection(connection);
/* 1782:     */     }
/* 1783:     */   }
/* 1784:     */   
/* 1785:     */   public void insertStockDetails(PurchaseSteelBarVO purchaseSteelBarVO)
/* 1786:     */     throws CreateFailedException
/* 1787:     */   {
/* 1788:1778 */     float quantInTon = purchaseSteelBarVO.getQuantity();
/* 1789:1779 */     float quantInKg = quantInTon * 1000.0F;
/* 1790:     */     try
/* 1791:     */     {
/* 1792:1783 */       System.out.println("we  r in dao stock " + purchaseSteelBarVO.getInconterm());
/* 1793:1784 */       this.connection = getConnection();
/* 1794:1785 */       String insert = "INSERT INTO TAB_STOCK_DETAILS(STOCK_PURCHASE_PRICE, STOCK_AMOUNT, STOCK_BAGS_NO, STOCK_BAGS_TON,STOCK_MATERIAL_CODE,STOCK_HSN_CODE,STOCK_UNIT_PRICE,STOCK_CATEGORY, STOCK_PRODUCT_TYPE,STOCK_BILLED_OWNER)VALUES(?,?,?,?,?,?,?,?,?,?)";
/* 1795:     */       
/* 1796:1787 */       this.preparedStatement = this.connection
/* 1797:1788 */         .prepareStatement(insert);
/* 1798:     */       
/* 1799:1790 */       this.preparedStatement.setFloat(1, purchaseSteelBarVO.getUnitPrice());
/* 1800:1791 */       this.preparedStatement.setFloat(2, purchaseSteelBarVO.getNetAmount());
/* 1801:1792 */       this.preparedStatement.setFloat(3, quantInKg);
/* 1802:1793 */       this.preparedStatement.setFloat(4, purchaseSteelBarVO.getQuantity());
/* 1803:1794 */       this.preparedStatement.setString(5, purchaseSteelBarVO.getMaterialCode());
/* 1804:1795 */       this.preparedStatement.setString(6, purchaseSteelBarVO.getHsnCode());
/* 1805:     */       
/* 1806:1797 */       this.preparedStatement.setFloat(7, purchaseSteelBarVO.getUnitPrice());
/* 1807:1798 */       this.preparedStatement.setInt(8, this.nameHelper.getProductCategoryIdByProductType(Integer.parseInt(purchaseSteelBarVO.getInconterm())));
/* 1808:1799 */       this.preparedStatement.setString(9, purchaseSteelBarVO.getInconterm());
/* 1809:     */       this.preparedStatement.setInt(10, OMIConstants.CHOUKSAY_TRADERS);
/* 1810:1801 */       this.preparedStatement.executeUpdate();
/* 1811:     */     }
/* 1812:     */     catch (SQLException sqlException)
/* 1813:     */     {
/* 1814:1804 */       sqlException.printStackTrace();
/* 1815:1805 */       logger.error(
/* 1816:1806 */         PurchaseSteelBarDaoImpl.class + 
/* 1817:1807 */         ": Error:- Error: Occur in Query While inserting the stock details into Database", 
/* 1818:1808 */         sqlException);
/* 1819:     */     }
/* 1820:     */     catch (Exception exception)
/* 1821:     */     {
/* 1822:1811 */       exception.printStackTrace();
/* 1823:1812 */       logger.error(
/* 1824:1813 */         PurchaseSteelBarDaoImpl.class + 
/* 1825:1814 */         ": Error:- While closing the Connection after inserting the  stock details into Database", 
/* 1826:1815 */         exception);
/* 1827:     */     }
/* 1828:     */     finally
/* 1829:     */     {
/* 1830:1818 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/* 1831:1819 */       JdbcHelper.closeConnection(this.connection);
/* 1832:     */     }
/* 1833:     */   }
/* 1834:     */   
/* 1835:     */   public void insertIntoLedger(PurchaseSteelBarVO purchaseSteelBarVO)
/* 1836:     */     throws CreateFailedException
/* 1837:     */   {
/* 1838:     */     try
/* 1839:     */     {
/* 1840:1829 */       System.out.println("we  r in dao " + purchaseSteelBarVO.getDeliveryPlace());
/* 1841:     */       
/* 1842:1831 */       this.connection = getConnection();
/* 1843:     */       
/* 1844:1833 */       String insert = "INSERT INTO TAB_DEALER_LEDGER_DETAILS(LEDGER_DATE, LEDGER_VOUNCHER_NO, LEDGER_TAX_TYPE, LEDGER_TAX_AMOUNT, LEDGER_QUANTITY,LEDGER_TRUCK_NO, LEDGER_DESTINATION, LEDGER_PAID, LEDGER_DUE, LEDGER_MATERIAL, LEDGER_DEALER_ID)VALUES(?,?,?,?,?,?,?,?,?,?,?)";
/* 1845:     */       
/* 1846:1835 */       this.preparedStatement = this.connection
/* 1847:1836 */         .prepareStatement(insert);
/* 1848:     */       
/* 1849:1838 */       this.preparedStatement.setString(1, purchaseSteelBarVO.getInvoiceDate());
/* 1850:1839 */       this.preparedStatement.setString(2, purchaseSteelBarVO.getInvoiceNo());
/* 1851:1840 */       this.preparedStatement.setString(3, "SGST");
/* 1852:1841 */       this.preparedStatement.setFloat(4, purchaseSteelBarVO.getSgst());
/* 1853:1842 */       this.preparedStatement.setFloat(5, purchaseSteelBarVO.getQuantity());
/* 1854:1843 */       this.preparedStatement.setString(6, purchaseSteelBarVO.getTruckNo());
/* 1855:     */       
/* 1856:1845 */       this.preparedStatement.setString(7, purchaseSteelBarVO.getDeliveryPlace());
/* 1857:     */       
/* 1858:1847 */       this.preparedStatement.setFloat(8, purchaseSteelBarVO.getPayment());
/* 1859:1848 */       this.preparedStatement.setFloat(9, purchaseSteelBarVO.getNetAmount());
/* 1860:1849 */       this.preparedStatement.setString(10, "STEELBAR");
/* 1861:1850 */       this.preparedStatement.setString(11, purchaseSteelBarVO.getDealerName());
/* 1862:     */       
/* 1863:     */ 
/* 1864:1853 */       this.preparedStatement.executeUpdate();
/* 1865:     */     }
/* 1866:     */     catch (SQLException sqlException)
/* 1867:     */     {
/* 1868:1857 */       sqlException.printStackTrace();
/* 1869:1858 */       logger.error(
/* 1870:1859 */         PurchaseSteelBarDaoImpl.class + 
/* 1871:1860 */         ": Error:- Error: Occur in Query While inserting the Ledger dealer details into Database", 
/* 1872:1861 */         sqlException);
/* 1873:     */     }
/* 1874:     */     catch (Exception exception)
/* 1875:     */     {
/* 1876:1864 */       exception.printStackTrace();
/* 1877:1865 */       logger.error(
/* 1878:1866 */         PurchaseSteelBarDaoImpl.class + 
/* 1879:1867 */         ": Error:- While closing the Connection after inserting the Ledger dealer into Database", 
/* 1880:1868 */         exception);
/* 1881:     */     }
/* 1882:     */     finally
/* 1883:     */     {
/* 1884:1871 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/* 1885:1872 */       JdbcHelper.closeConnection(this.connection);
/* 1886:     */     }
/* 1887:     */   }
/* 1888:     */ }


/* Location:           C:\Users\bharti\Desktop\Chouksay\lost\dao\
 * Qualified Name:     com.bst.ckt.dao.PurchaseSteelBarDaoImpl
 * JD-Core Version:    0.7.0.1
 */