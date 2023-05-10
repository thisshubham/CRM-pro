/*    1:     */ package com.bst.ckt.dao;
import com.bst.ckt.common.OMIConstants;
/*    2:     */ 
/*    3:     */ import com.bst.ckt.common.QueryBuilder;
/*    4:     */ import com.bst.ckt.dto.WallPaint;
/*    5:     */ import com.bst.ckt.exception.CreateFailedException;
/*    6:     */ import com.bst.ckt.exception.RecordNotFoundException;
/*    7:     */ import com.bst.ckt.exception.UpdateFailedException;
/*    8:     */ import com.bst.ckt.framework.db.JdbcDAOSupport;
/*    9:     */ import com.bst.ckt.framework.db.JdbcHelper;
/*   10:     */ import com.bst.ckt.framework.util.DateTimeUtil;
/*   11:     */ import com.bst.ckt.helper.NameHelper;
/*   12:     */ import com.bst.ckt.vo.PurchaseWallPaintVO;
/*   13:     */ import com.itextpdf.text.BaseColor;
/*   14:     */ import com.itextpdf.text.Document;
/*   15:     */ import com.itextpdf.text.Font;
/*   16:     */ import com.itextpdf.text.Font.FontFamily;
/*   17:     */ import com.itextpdf.text.Image;
/*   18:     */ import com.itextpdf.text.PageSize;
/*   19:     */ import com.itextpdf.text.Paragraph;
/*   20:     */ import com.itextpdf.text.Phrase;
/*   21:     */ import com.itextpdf.text.Rectangle;
/*   22:     */ import com.itextpdf.text.pdf.PdfPCell;
/*   23:     */ import com.itextpdf.text.pdf.PdfPTable;
/*   24:     */ import com.itextpdf.text.pdf.PdfWriter;
/*   25:     */ import java.io.PrintStream;
/*   26:     */ import java.sql.Connection;
/*   27:     */ import java.sql.PreparedStatement;
/*   28:     */ import java.sql.ResultSet;
/*   29:     */ import java.sql.SQLException;
/*   30:     */ import java.util.ArrayList;
/*   31:     */ import java.util.List;
/*   32:     */ import javax.servlet.ServletContext;
/*   33:     */ import javax.servlet.http.HttpServletRequest;
/*   34:     */ import javax.servlet.http.HttpServletResponse;
/*   35:     */ import org.apache.log4j.Logger;
/*   36:     */ import org.apache.struts2.ServletActionContext;
/*   37:     */ 
/*   38:     */ public class PurchaseWallPaintDaoImpl
/*   39:     */   extends JdbcDAOSupport
/*   40:     */   implements PurchaseWallPaintDaoInf
/*   41:     */ {
/*   42:  47 */   Logger logger = Logger.getLogger(PurchaseWallPaintDaoImpl.class);
/*   43:  48 */   Connection connection = null;
/*   44:  49 */   PreparedStatement preparedStatement = null;
/*   45:  50 */   ResultSet resultSet = null;
/*   46:  51 */   NameHelper nameHelper = new NameHelper();
/*   47:  52 */   PurchaseWallPaintVO purchaseWallPaintVO = null;
/*   48:  53 */   Image image = null;
/*   49:     */   
/*   50:     */   public int addPurchaseWallPaint(PurchaseWallPaintVO purchaseWallPaintVO)
/*   51:     */     throws CreateFailedException
/*   52:     */   {
/*   53:  60 */     int output = 0;
/*   54:     */     try
/*   55:     */     {
/*   56:  64 */       this.connection = getConnection();
/*   57:     */       
/*   58:  66 */       String insert = "INSERT INTO TAB_PURCHASE_WALLPAINT(PUR_WALLPAINT_COMPANY, PUR_WALLPAINT_PRICE, PUR_WALLPAINT_AMOUNT,PUR_WALLPAINT_GST, PUR_WALLPAINT_CGST, PUR_WALLPAINT_SGST, PUR_WALLPAINT_DEALER_NAME, PUR_WALLPAINT_DEALER_CONTACT, PUR_WALLPAINT_DEALER_ADDRESS, PUR_WALLPAINT_DEALER_REF, PUR_WALLPAINT_QUANTITY, PUR_WALLPAINT_LITER, PUR_WALLPAINT_GST_AMOUNT, PUR_WALLPAINT_CGST_AMOUNT, PUR_WALLPAINT_SGST_AMOUNT, PUR_WALLPAINT_INVOICE_NO, PUR_WALLPAINT_ORDER_NO, PUR_WALLPAINT_CARRIER_NAME, PUR_WALLPAINT_PAYMENT_MODE, PUR_WALLPAINT_WEEK_NO, PUR_WALLPAINT_INCOTERM, PUR_WALLPAINT_PAYMENT,PUR_WALLPAINT_INVOICE_DATE, PUR_WALLPAINT_MATERIAL_CODE, PUR_WALLPAINT_HSN_CODE, PUR_WALLPAINT_DELIVERY_PLACE, PUR_WALLPAINT_UNIT_PRICE, PUR_WALLPAINT_DISCOUNT)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
/*   59:     */       
/*   60:     */ float total=purchaseWallPaintVO.getUnitPrice()*purchaseWallPaintVO.getQuantity();
float cal =(100+purchaseWallPaintVO.getGst())/100;
/*   64:     */ float gstAmount=total*cal;
float diff=gstAmount-total;
/*   61:     */ 
/*   62:     */ 
/*   63:     */ 
/*   64:  72 */       this.preparedStatement = this.connection
/*   65:  73 */         .prepareStatement(insert);
/*   66:     */       
/*   67:  75 */       this.preparedStatement.setString(1, purchaseWallPaintVO.getCompanyName());
/*   68:  76 */       this.preparedStatement.setFloat(2, purchaseWallPaintVO.getUnitPrice());
/*   69:  77 */       this.preparedStatement.setFloat(3, purchaseWallPaintVO.getNetAmount());
/*   70:  78 */       this.preparedStatement.setFloat(4, purchaseWallPaintVO.getGst());
/*   71:  79 */       this.preparedStatement.setFloat(5, purchaseWallPaintVO.getCgst());
/*   72:  80 */       this.preparedStatement.setFloat(6, purchaseWallPaintVO.getSgst());
/*   73:  81 */       System.out.println(purchaseWallPaintVO.getDealerName() + "LLLLLLLLLLLddddddddd");
/*   74:  82 */       this.preparedStatement.setString(7, this.nameHelper.getDealerNameById(Integer.parseInt(purchaseWallPaintVO.getDealerName())));
/*   75:  83 */       this.preparedStatement.setString(8, purchaseWallPaintVO.getDealerContact());
/*   76:  84 */       this.preparedStatement.setString(9, purchaseWallPaintVO.getDealerAddress());
/*   77:  85 */       this.preparedStatement.setString(10, purchaseWallPaintVO.getDealerName());
/*   78:  86 */       this.preparedStatement.setInt(11, purchaseWallPaintVO.getQuantity());
/*   79:  87 */       this.preparedStatement.setFloat(12, purchaseWallPaintVO.getQuantity());
/*   80:  88 */       this.preparedStatement.setFloat(13, diff);
/*   81:  89 */       this.preparedStatement.setFloat(14, purchaseWallPaintVO.getCgstAmount());
/*   82:  90 */       this.preparedStatement.setFloat(15, purchaseWallPaintVO.getSgstAmount());
/*   83:  91 */       this.preparedStatement.setString(16, purchaseWallPaintVO.getInvoiceNo());
/*   84:  92 */       this.preparedStatement.setString(17, purchaseWallPaintVO.getOrderNo());
/*   85:  93 */       this.preparedStatement.setString(18, purchaseWallPaintVO.getTransporter());
/*   86:  94 */       this.preparedStatement.setString(19, purchaseWallPaintVO.getPaymentMode());
/*   87:  95 */       this.preparedStatement.setString(20, purchaseWallPaintVO.getWeekNo());
/*   88:  96 */       this.preparedStatement.setString(21, purchaseWallPaintVO.getInconterm());
/*   89:  97 */       this.preparedStatement.setFloat(22, purchaseWallPaintVO.getPayment());
/*   90:  98 */       this.preparedStatement.setString(23, DateTimeUtil.convertToDate(purchaseWallPaintVO.getInvoiceDate()));
/*   91:     */       
/*   92: 100 */       this.preparedStatement.setString(24, purchaseWallPaintVO.getMaterialCode());
/*   93: 101 */       this.preparedStatement.setString(25, purchaseWallPaintVO.getHsnCode());
/*   94: 102 */       this.preparedStatement.setString(26, purchaseWallPaintVO.getDeliveryPlace());
/*   95: 103 */       this.preparedStatement.setFloat(27, purchaseWallPaintVO.getUnitPrice());
/*   96: 104 */       this.preparedStatement.setFloat(28, purchaseWallPaintVO.getDiscount());
/*   97:     */       
/*   98:     */ 
/*   99: 107 */       output = this.preparedStatement.executeUpdate();
/*  100: 109 */       if (output == 1) {
/*  101: 110 */         insertIntoDealerTansaction(purchaseWallPaintVO);
/*  102:     */       }
/*  103:     */     }
/*  104:     */     catch (SQLException sqlException)
/*  105:     */     {
/*  106: 113 */       sqlException.printStackTrace();
/*  107: 114 */       this.logger.error(
/*  108: 115 */         PurchaseWallPaintDaoImpl.class + 
/*  109: 116 */         ": Error:- Error: Occur in Query While inserting the Purchased wall paints details into Database", 
/*  110: 117 */         sqlException);
/*  111:     */     }
/*  112:     */     catch (Exception exception)
/*  113:     */     {
/*  114: 120 */       exception.printStackTrace();
/*  115: 121 */       this.logger.error(
/*  116: 122 */         PurchaseWallPaintDaoImpl.class + 
/*  117: 123 */         ": Error:- While closing the Connection after inserting the Purchased wall paints into Database", 
/*  118: 124 */         exception);
/*  119:     */     }
/*  120:     */     finally
/*  121:     */     {
/*  122: 127 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/*  123: 128 */       JdbcHelper.closeConnection(this.connection);
/*  124:     */     }
/*  125: 131 */     return output;
/*  126:     */   }
/*  127:     */   
/*  128:     */   public void insertIntoDealerTansaction(PurchaseWallPaintVO purchaseWallPaintVO)
/*  129:     */     throws RecordNotFoundException
/*  130:     */   {
/*  131: 138 */     if (purchaseWallPaintVO.getPayment() >= 0.0F)
/*  132:     */     {
/*  133: 140 */       Connection con = null;
/*  134:     */       
/*  135: 142 */       PreparedStatement ps = null;
/*  136:     */       
/*  137: 144 */       float totalDue = getDueOfCurrentDealer(purchaseWallPaintVO.getDealerName());
/*  138:     */       try
/*  139:     */       {
/*  140: 148 */         float paid = purchaseWallPaintVO.getPayment();
/*  141: 149 */         float due = purchaseWallPaintVO.getNetAmount() - purchaseWallPaintVO.getPayment();
/*  142:     */         
/*  143: 151 */         con = getConnection();
/*  144: 152 */         String danger_query = "INSERT INTO TAB_DEALER_OWNER_TRANSACTION (DEALER_TRANS_DISCRIPTION, DEALER_TRANS_BILL_NO,DEALER_TANS_PAYMENT_MODE,DEALER_TRANS_DATE,DEALER_TRANS_TOTAL,DEALER_TRANS_PAID ,DEALER_TRANS_DUE,DEALER_ID_REF, DEALER_TRANS_TOTAL_DUE,SHOP_ID,  DEALER_TRANS_TOTAL_PAID)SELECT ?,?,?,?,?,?,?,?,?,?,SUM(TAB_DEALER_OWNER_TRANSACTION.DEALER_TRANS_PAID)+" + 
/*  145: 153 */           paid + " FROM TAB_DEALER_OWNER_TRANSACTION WHERE DEALER_ID_REF=" + 
/*  146: 154 */           purchaseWallPaintVO.getDealerName();
/*  147: 155 */         ps = con.prepareStatement(danger_query);
/*  148:     */         
/*  149: 157 */         ps.setString(1, "ON PURCHASE");
/*  150: 158 */         ps.setString(2, purchaseWallPaintVO.getInvoiceNo());
/*  151: 159 */         ps.setString(3, purchaseWallPaintVO.getPaymentMode());
/*  152:     */         
/*  153: 161 */         ps.setString(4, DateTimeUtil.convertToDate(purchaseWallPaintVO.getInvoiceDate()));
/*  154: 162 */         ps.setFloat(5, purchaseWallPaintVO.getNetAmount());
/*  155: 163 */         ps.setFloat(6, purchaseWallPaintVO.getPayment());
/*  156: 164 */         ps.setFloat(7, due);
/*  157: 165 */         ps.setString(8, purchaseWallPaintVO.getDealerName());
/*  158: 166 */         ps.setFloat(9, totalDue + due);
/*  159: 167 */         ps.setInt(10, purchaseWallPaintVO.getAclId());
/*  160:     */         
/*  161: 169 */         ps.executeUpdate();
/*  162:     */       }
/*  163:     */       catch (SQLException sqlException)
/*  164:     */       {
/*  165: 173 */         this.logger.error(PurchaseWallPaintDaoImpl.class + "ERROR: While inserting the cement transaction details into the database", sqlException);
/*  166:     */         
/*  167: 175 */         sqlException.printStackTrace();
/*  168:     */       }
/*  169:     */       catch (Exception exception)
/*  170:     */       {
/*  171: 179 */         this.logger.error(
/*  172: 180 */           PurchaseWallPaintDaoImpl.class + "ERROR: While inserting the cement transaction details into the database", 
/*  173: 181 */           exception);
/*  174:     */         
/*  175: 183 */         exception.printStackTrace();
/*  176:     */       }
/*  177:     */       finally
/*  178:     */       {
/*  179: 186 */         JdbcHelper.closePreparedStatement(ps);
/*  180: 187 */         JdbcHelper.closeConnection(con);
/*  181:     */       }
/*  182:     */     }
/*  183:     */   }
/*  184:     */   
/*  185:     */   public List<PurchaseWallPaintVO> fetchPurchaseWallPaintList()
/*  186:     */     throws RecordNotFoundException
/*  187:     */   {
/*  188: 195 */     List<PurchaseWallPaintVO> purchaseWallPaintDetailList = new ArrayList();
/*  189:     */     try
/*  190:     */     {
/*  191: 199 */       this.connection = getConnection();
/*  192:     */       
/*  193:     */ 
/*  194:     */ 
/*  195: 203 */       this.preparedStatement = this.connection.prepareStatement("SELECT * FROM TAB_PURCHASE_WALLPAINT");
/*  196:     */       
/*  197:     */ 
/*  198: 206 */       this.resultSet = this.preparedStatement.executeQuery();
/*  199: 210 */       while (this.resultSet.next())
/*  200:     */       {
/*  201: 211 */         this.purchaseWallPaintVO = new PurchaseWallPaintVO();
/*  202: 212 */         this.purchaseWallPaintVO.setPurchaseId(this.resultSet.getInt("PUR_WALLPAINT_ID"));
/*  203:     */         
/*  204: 214 */         this.purchaseWallPaintVO.setDealerName(this.nameHelper.getDealerNameById(this.resultSet.getInt("PUR_WALLPAINT_DEALER_REF")));
/*  205: 215 */         this.purchaseWallPaintVO.setDealerContact(this.resultSet.getString("PUR_WALLPAINT_DEALER_CONTACT"));
/*  206:     */         
/*  207: 217 */         this.purchaseWallPaintVO.setCompanyName(this.resultSet.getString("PUR_WALLPAINT_COMPANY"));
/*  208:     */         
/*  209: 219 */         this.purchaseWallPaintVO.setQuantity(this.resultSet
/*  210: 220 */           .getInt("PUR_WALLPAINT_QUANTITY"));
/*  211:     */         
/*  212: 222 */         this.purchaseWallPaintVO.setInvoiceNo(this.resultSet
/*  213: 223 */           .getString("PUR_WALLPAINT_INVOICE_NO"));
/*  214:     */         
/*  215:     */ 
/*  216: 226 */         this.purchaseWallPaintVO.setOrderNo(this.resultSet
/*  217: 227 */           .getString("PUR_WALLPAINT_ORDER_NO"));
/*  218:     */         
/*  219: 229 */         this.purchaseWallPaintVO.setTransporter(this.resultSet
/*  220: 230 */           .getString("PUR_WALLPAINT_CARRIER_NAME"));
/*  221:     */         
/*  222: 232 */         this.purchaseWallPaintVO.setInvoiceDate(this.resultSet
/*  223: 233 */           .getString("PUR_WALLPAINT_INVOICE_DATE"));
/*  224:     */         
/*  225: 235 */         this.purchaseWallPaintVO.setMaterialCode(this.resultSet
/*  226: 236 */           .getString("PUR_WALLPAINT_MATERIAL_CODE"));
/*  227:     */         
/*  228:     */ 
/*  229: 239 */         this.purchaseWallPaintVO.setUnitPrice(this.resultSet
/*  230: 240 */           .getFloat("PUR_WALLPAINT_UNIT_PRICE"));
/*  231: 241 */         this.purchaseWallPaintVO.setNetAmount(this.resultSet
/*  232: 242 */           .getFloat("PUR_WALLPAINT_AMOUNT"));
/*  233: 243 */         this.purchaseWallPaintVO.setGst(this.resultSet
/*  234: 244 */           .getFloat("PUR_WALLPAINT_GST"));
/*  235:     */         
/*  236:     */ 
/*  237:     */ 
/*  238: 248 */         purchaseWallPaintDetailList.add(this.purchaseWallPaintVO);
/*  239:     */       }
/*  240:     */     }
/*  241:     */     catch (SQLException sqlExp)
/*  242:     */     {
/*  243: 252 */       sqlExp.printStackTrace();
/*  244: 253 */       this.logger.error(
/*  245: 254 */         PurchaseWallPaintDaoImpl.class + 
/*  246: 255 */         "Error: Occur in Query While Fetching the wall paint purchase Details into Grid from Database.", 
/*  247: 256 */         sqlExp);
/*  248:     */     }
/*  249:     */     catch (Exception exception)
/*  250:     */     {
/*  251: 258 */       exception.printStackTrace();
/*  252: 259 */       this.logger.error(
/*  253: 260 */         PurchaseWallPaintDaoImpl.class + 
/*  254: 261 */         "Error: Occur in Query While Closing Connection After Fetching the wall paint purchase into Grid from Database.", 
/*  255: 262 */         exception);
/*  256:     */     }
/*  257:     */     finally
/*  258:     */     {
/*  259: 264 */       JdbcHelper.closeResultSet(this.resultSet);
/*  260: 265 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/*  261: 266 */       JdbcHelper.closeConnection(this.connection);
/*  262:     */     }
/*  263: 268 */     return purchaseWallPaintDetailList;
/*  264:     */   }
/*  265:     */   
/*  266:     */   public float getDueOfCurrentDealer(String dealerId)
/*  267:     */   {
/*  268: 273 */     float tot_due = 0.0F;
/*  269: 274 */     Connection con = null;
/*  270: 275 */     PreparedStatement prst = null;
/*  271: 276 */     ResultSet result = null;
/*  272:     */     try
/*  273:     */     {
/*  274: 282 */       con = getConnection();
/*  275: 283 */       String query = "SELECT DEALER_TRANS_TOTAL_DUE FROM TAB_DEALER_OWNER_TRANSACTION WHERE DEALER_ID_REF=? ORDER BY DEALER_TRANS_ID DESC LIMIT 1";
/*  276:     */       
/*  277:     */ 
/*  278:     */ 
/*  279: 287 */       prst = con.prepareStatement(query);
/*  280:     */       
/*  281: 289 */       prst.setString(1, dealerId);
/*  282: 290 */       result = prst.executeQuery();
/*  283: 291 */       while (result.next())
/*  284:     */       {
/*  285: 292 */         tot_due = result.getFloat("DEALER_TRANS_TOTAL_DUE");
/*  286:     */         
/*  287: 294 */         System.out.println(result.getFloat("DEALER_TRANS_TOTAL_DUE") + "FETCHED iDkkjjjjjjjjjjjjjjjjjjjjjjjjjj");
/*  288: 295 */         System.out.println(result.getFloat("DEALER_TRANS_TOTAL_DUE") + "FETCHED iDnnjjjjjjjjjjjjjjjjjjjjjjjjjjname name");
/*  289:     */       }
/*  290:     */     }
/*  291:     */     catch (Exception excep)
/*  292:     */     {
/*  293: 299 */       this.logger.error(
/*  294: 300 */         PurchaseWallPaintDaoImpl.class + "ERROR: while fetching the record from the Purchase  table", 
/*  295: 301 */         excep);
/*  296:     */       
/*  297: 303 */       excep.printStackTrace();
/*  298:     */     }
/*  299:     */     finally
/*  300:     */     {
/*  301: 306 */       JdbcHelper.closeResultSet(result);
/*  302: 307 */       JdbcHelper.closePreparedStatement(prst);
/*  303: 308 */       JdbcHelper.closeConnection(con);
/*  304:     */     }
/*  305: 310 */     return tot_due;
/*  306:     */   }
/*  307:     */   
/*  308:     */   public int isItemAlreadyExistInStock(String inconterm)
/*  309:     */     throws RecordNotFoundException
/*  310:     */   {
/*  311: 317 */     int existence = 0;
/*  312:     */     try
/*  313:     */     {
/*  314: 319 */       this.connection = getConnection();
/*  315:     */       
/*  316: 321 */       this.preparedStatement = this.connection
/*  317: 322 */         .prepareStatement("SELECT  STOCK_BAGS_NO FROM TAB_STOCK_DETAILS WHERE STOCK_PRODUCT_TYPE=?");
/*  318: 323 */       this.preparedStatement.setString(1, inconterm);
/*  319:     */       
/*  320:     */ 
/*  321: 326 */       this.resultSet = this.preparedStatement.executeQuery();
/*  322: 328 */       if (this.resultSet != null) {
/*  323: 329 */         while (this.resultSet.next()) {
/*  324: 331 */           existence = this.resultSet.getInt("STOCK_BAGS_NO");
/*  325:     */         }
/*  326:     */       }
/*  327:     */     }
/*  328:     */     catch (SQLException sqlExp)
/*  329:     */     {
/*  330: 338 */       sqlExp.printStackTrace();
/*  331: 339 */       this.logger.error(
/*  332: 340 */         PurchaseWallPaintDaoImpl.class + 
/*  333: 341 */         "Error: Occur in Query While Fetching the stock Details from Database.", 
/*  334: 342 */         sqlExp);
/*  335:     */     }
/*  336:     */     catch (Exception exception)
/*  337:     */     {
/*  338: 344 */       exception.printStackTrace();
/*  339: 345 */       this.logger.error(
/*  340: 346 */         PurchaseWallPaintDaoImpl.class + 
/*  341: 347 */         "Error: Occur in Query While Closing Connection After Fetching the stock Details from Database.", 
/*  342: 348 */         exception);
/*  343:     */     }
/*  344:     */     finally
/*  345:     */     {
/*  346: 350 */       JdbcHelper.closeResultSet(this.resultSet);
/*  347: 351 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/*  348: 352 */       JdbcHelper.closeConnection(this.connection);
/*  349:     */     }
/*  350: 354 */     return existence;
/*  351:     */   }
/*  352:     */   
/*  353:     */   public void updateStockDetails(PurchaseWallPaintVO purchaseWallPaintVO, int quantity)
/*  354:     */     throws UpdateFailedException
/*  355:     */   {
/*  356: 364 */     Connection connection = null;
/*  357: 365 */     PreparedStatement preparedStatement = null;
/*  358: 366 */     System.out.println("update is running************************" + purchaseWallPaintVO.getUnitPrice());
/*  359:     */     try
/*  360:     */     {
/*  361: 370 */       String up = "UPDATE TAB_STOCK_DETAILS SET  STOCK_PURCHASE_PRICE=?, STOCK_AMOUNT=?, STOCK_BAGS_NO=?, STOCK_BAGS_TON=?,STOCK_MATERIAL_CODE=?, STOCK_HSN_CODE=?, STOCK_UNIT_PRICE=?, STOCK_CATEGORY=? WHERE STOCK_PRODUCT_TYPE=?";
/*  362:     */       
/*  363: 372 */       System.out.println("fffffffffffffffffffffF" + quantity);
/*  364:     */       
/*  365: 374 */       connection = getConnection();
/*  366: 375 */       preparedStatement = connection
/*  367: 376 */         .prepareStatement(up);
/*  368: 377 */       preparedStatement.setFloat(1, purchaseWallPaintVO.getUnitPrice());
/*  369: 378 */       preparedStatement.setFloat(2, purchaseWallPaintVO.getNetAmount());
/*  370: 379 */       preparedStatement.setFloat(3, purchaseWallPaintVO.getQuantity() + quantity);
/*  371: 380 */       preparedStatement.setFloat(4, purchaseWallPaintVO.getQuantity());
/*  372: 381 */       preparedStatement.setString(5, purchaseWallPaintVO.getMaterialCode());
/*  373: 382 */       preparedStatement.setString(6, purchaseWallPaintVO.getHsnCode());
/*  374:     */       
/*  375: 384 */       preparedStatement.setFloat(7, purchaseWallPaintVO.getUnitPrice());
/*  376: 385 */       preparedStatement.setInt(8, this.nameHelper.getProductCategoryIdByProductType(Integer.parseInt(purchaseWallPaintVO.getInconterm())));
/*  377: 386 */       preparedStatement.setString(9, purchaseWallPaintVO.getInconterm());
/*  378:     */       
/*  379: 388 */       preparedStatement.executeUpdate();
/*  380:     */     }
/*  381:     */     catch (SQLException sqlExp)
/*  382:     */     {
/*  383: 391 */       sqlExp.printStackTrace();
/*  384: 392 */       this.logger.error(
/*  385: 393 */         PurchaseWallPaintDaoImpl.class + 
/*  386: 394 */         "Error: Occur in Query While updating the specific cement purchase Details.", 
/*  387: 395 */         sqlExp);
/*  388:     */     }
/*  389:     */     catch (Exception exception)
/*  390:     */     {
/*  391: 397 */       exception.printStackTrace();
/*  392: 398 */       this.logger.error(
/*  393: 399 */         PurchaseWallPaintDaoImpl.class + 
/*  394: 400 */         "Error: Occur in Query While Closing Connection After updating the specific cement purchase Details.", 
/*  395: 401 */         exception);
/*  396:     */     }
/*  397:     */     finally
/*  398:     */     {
/*  399: 403 */       JdbcHelper.closeResultSet(this.resultSet);
/*  400: 404 */       JdbcHelper.closePreparedStatement(preparedStatement);
/*  401: 405 */       JdbcHelper.closeConnection(connection);
/*  402:     */     }
/*  403:     */   }
/*  404:     */   
/*  405:     */   public void insertStockDetails(PurchaseWallPaintVO purchaseWallPaintVO)
/*  406:     */     throws CreateFailedException
/*  407:     */   {
/*  408:     */     try
/*  409:     */     {
/*  410: 415 */       this.connection = getConnection();
/*  411: 416 */       String insert = "INSERT INTO TAB_STOCK_DETAILS(STOCK_PURCHASE_PRICE, STOCK_AMOUNT, STOCK_BAGS_NO, STOCK_BAGS_TON,STOCK_MATERIAL_CODE,STOCK_HSN_CODE,STOCK_UNIT_PRICE,STOCK_CATEGORY, STOCK_PRODUCT_TYPE,STOCK_BILLED_OWNER)VALUES(?,?,?,?,?,?,?,?,?,?)";
/*  412:     */       
/*  413: 418 */       this.preparedStatement = this.connection
/*  414: 419 */         .prepareStatement(insert);
/*  415:     */       
/*  416: 421 */       this.preparedStatement.setFloat(1, purchaseWallPaintVO.getUnitPrice());
/*  417: 422 */       this.preparedStatement.setFloat(2, purchaseWallPaintVO.getNetAmount());
/*  418: 423 */       this.preparedStatement.setFloat(3, purchaseWallPaintVO.getQuantity());
/*  419: 424 */       this.preparedStatement.setFloat(4, purchaseWallPaintVO.getQuantity());
/*  420: 425 */       this.preparedStatement.setString(5, purchaseWallPaintVO.getMaterialCode());
/*  421: 426 */       this.preparedStatement.setString(6, purchaseWallPaintVO.getHsnCode());
/*  422:     */       
/*  423: 428 */       this.preparedStatement.setFloat(7, purchaseWallPaintVO.getUnitPrice());
/*  424: 429 */       this.preparedStatement.setInt(8, this.nameHelper.getProductCategoryIdByProductType(Integer.parseInt(purchaseWallPaintVO.getInconterm())));
/*  425: 430 */       this.preparedStatement.setString(9, purchaseWallPaintVO.getInconterm());
/*  426:     */       this.preparedStatement.setInt(10, OMIConstants.CHOUKSAY_TRADERS);
/*  427:     */ 
/*  428: 433 */       this.preparedStatement.executeUpdate();
/*  429:     */     }
/*  430:     */     catch (SQLException sqlException)
/*  431:     */     {
/*  432: 436 */       sqlException.printStackTrace();
/*  433: 437 */       this.logger.error(
/*  434: 438 */         PurchaseWallPaintDaoImpl.class + 
/*  435: 439 */         ": Error:- Error: Occur in Query While inserting the stock details into Database", 
/*  436: 440 */         sqlException);
/*  437:     */     }
/*  438:     */     catch (Exception exception)
/*  439:     */     {
/*  440: 443 */       exception.printStackTrace();
/*  441: 444 */       this.logger.error(
/*  442: 445 */         PurchaseWallPaintDaoImpl.class + 
/*  443: 446 */         ": Error:- While closing the Connection after inserting the  stock details into Database", 
/*  444: 447 */         exception);
/*  445:     */     }
/*  446:     */     finally
/*  447:     */     {
/*  448: 450 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/*  449: 451 */       JdbcHelper.closeConnection(this.connection);
/*  450:     */     }
/*  451:     */   }
/*  452:     */   
/*  453:     */   public WallPaint retriveSpecificPurchaseDetailForUpdate(int purchaseId)
/*  454:     */     throws RecordNotFoundException
/*  455:     */   {
/*  456: 459 */     WallPaint wallPaint = new WallPaint();
/*  457: 460 */     PreparedStatement preparedStatements = null;
/*  458:     */     try
/*  459:     */     {
/*  460: 462 */       this.connection = getConnection();
/*  461:     */       
/*  462: 464 */       preparedStatements = this.connection
/*  463: 465 */         .prepareStatement("SELECT * FROM TAB_PURCHASE_WALLPAINT WHERE PUR_WALLPAINT_ID=?");
/*  464: 466 */       preparedStatements.setInt(1, purchaseId);
/*  465:     */       
/*  466:     */ 
/*  467:     */ 
/*  468: 470 */       this.resultSet = preparedStatements.executeQuery();
/*  469: 471 */       System.out.println("----------hye ----------------");
/*  470: 472 */       if (this.resultSet != null) {
/*  471: 473 */         while (this.resultSet.next())
/*  472:     */         {
/*  473: 475 */           System.out.println("----------hye ----------------");
/*  474:     */           
/*  475: 477 */           wallPaint.setPurchaseId(this.resultSet.getInt("PUR_WALLPAINT_ID"));
/*  476: 478 */           System.out.println("________________" + this.resultSet.getInt("PUR_WALLPAINT_ID"));
/*  477:     */           
/*  478: 480 */           wallPaint.setUnitPrice(this.resultSet.getFloat("PUR_WALLPAINT_PRICE"));
/*  479: 481 */           System.out.println("---------" + this.resultSet.getFloat("PUR_WALLPAINT_AMOUNT"));
/*  480:     */           
/*  481:     */ 
/*  482: 484 */           wallPaint.setCompanyName(this.resultSet.getString("PUR_WALLPAINT_COMPANY"));
/*  483:     */           
/*  484: 486 */           wallPaint.setDealerName(this.resultSet.getString("PUR_WALLPAINT_DEALER_REF"));
/*  485:     */           
/*  486:     */ 
/*  487:     */ 
/*  488: 490 */           wallPaint.setGst(this.resultSet.getFloat("PUR_WALLPAINT_GST"));
/*  489:     */           
/*  490:     */ 
/*  491: 493 */           wallPaint.setCgst(this.resultSet
/*  492: 494 */             .getFloat("PUR_WALLPAINT_CGST"));
/*  493:     */           
/*  494: 496 */           wallPaint.setSgst(this.resultSet
/*  495: 497 */             .getFloat("PUR_WALLPAINT_SGST"));
/*  496:     */           
/*  497: 499 */           wallPaint.setdFullName(this.resultSet
/*  498: 500 */             .getString("PUR_WALLPAINT_DEALER_NAME"));
/*  499:     */           
/*  500: 502 */           wallPaint.setDealerContact(this.resultSet
/*  501: 503 */             .getString("PUR_WALLPAINT_DEALER_CONTACT"));
/*  502:     */           
/*  503: 505 */           wallPaint.setDealerAddress(this.resultSet
/*  504: 506 */             .getString("PUR_WALLPAINT_DEALER_ADDRESS"));
/*  505:     */           
/*  506: 508 */           wallPaint.setDealerRef(this.resultSet.getInt("PUR_WALLPAINT_DEALER_REF"));
/*  507:     */           
/*  508: 510 */           wallPaint.setQuantity(this.resultSet.getInt("PUR_WALLPAINT_QUANTITY"));
/*  509:     */           
/*  510: 512 */           wallPaint.setQuantity(this.resultSet.getInt("PUR_WALLPAINT_LITER"));
/*  511:     */           
/*  512: 514 */           wallPaint.setGstAmount(this.resultSet.getFloat("PUR_WALLPAINT_GST_AMOUNT"));
/*  513:     */           
/*  514: 516 */           wallPaint.setCgstAmount(this.resultSet
/*  515: 517 */             .getFloat("PUR_WALLPAINT_CGST_AMOUNT"));
/*  516:     */           
/*  517: 519 */           wallPaint.setSgstAmount(this.resultSet
/*  518: 520 */             .getFloat("PUR_WALLPAINT_SGST_AMOUNT"));
/*  519:     */           
/*  520:     */ 
/*  521:     */ 
/*  522: 524 */           wallPaint.setInvoiceNo(this.resultSet
/*  523: 525 */             .getString("PUR_WALLPAINT_INVOICE_NO"));
/*  524: 526 */           wallPaint.setOrderNo(this.resultSet
/*  525: 527 */             .getString("PUR_WALLPAINT_ORDER_NO"));
/*  526: 528 */           wallPaint.setTransporter(this.resultSet
/*  527: 529 */             .getString("PUR_WALLPAINT_CARRIER_NAME"));
/*  528: 530 */           wallPaint.setPaymentMode(this.resultSet
/*  529: 531 */             .getString("PUR_WALLPAINT_PAYMENT_MODE"));
/*  530: 532 */           wallPaint.setWeekNo(this.resultSet
/*  531: 533 */             .getString("PUR_WALLPAINT_WEEK_NO"));
/*  532: 534 */           wallPaint.setInconterm(this.resultSet
/*  533: 535 */             .getString("PUR_WALLPAINT_INCOTERM"));
/*  534: 536 */           wallPaint.setPayment(this.resultSet
/*  535: 537 */             .getFloat("PUR_WALLPAINT_PAYMENT"));
/*  536: 538 */           System.out.println(this.resultSet.getDate("PUR_WALLPAINT_INVOICE_DATE") + "KKKKKKKKKKKKKKKKKKKKKK" + this.resultSet
/*  537: 539 */             .getFloat("PUR_WALLPAINT_PAYMENT"));
/*  538: 540 */           wallPaint.setInvoiceDate(DateTimeUtil.convertDatetoFormDate(this.resultSet.getString("PUR_WALLPAINT_INVOICE_DATE")));
/*  539:     */           
/*  540: 542 */           wallPaint.setMaterialCode(this.resultSet
/*  541: 543 */             .getString("PUR_WALLPAINT_MATERIAL_CODE"));
/*  542: 544 */           wallPaint.setHsnCode(this.resultSet
/*  543: 545 */             .getString("PUR_WALLPAINT_HSN_CODE"));
/*  544: 546 */           wallPaint.setDeliveryPlace(this.resultSet
/*  545: 547 */             .getString("PUR_WALLPAINT_DELIVERY_PLACE"));
/*  546: 548 */           wallPaint.setUnitPrice(this.resultSet
/*  547: 549 */             .getFloat("PUR_WALLPAINT_UNIT_PRICE"));
/*  548:     */           
/*  549: 551 */           wallPaint.setDiscount(this.resultSet
/*  550: 552 */             .getFloat("PUR_WALLPAINT_DISCOUNT"));
/*  551:     */           
/*  552: 554 */           wallPaint.setNetAmount(this.resultSet
/*  553: 555 */             .getFloat("PUR_WALLPAINT_AMOUNT"));
/*  554:     */           
/*  555: 557 */           System.out.println("BHARTI" + this.resultSet.getFloat("PUR_WALLPAINT_GST") + this.resultSet.getInt("PUR_WALLPAINT_AMOUNT") + this.resultSet.getString("PUR_WALLPAINT_AMOUNT") + "%%%%%%%%%%%%%%%");
/*  556:     */         }
/*  557:     */       }
/*  558: 566 */       System.out.println(wallPaint.getTotal() + "total" + wallPaint.getTransactionId() + "bill NoGGGGGggggg");
/*  559:     */     }
/*  560:     */     catch (SQLException sqlExp)
/*  561:     */     {
/*  562: 568 */       sqlExp.printStackTrace();
/*  563: 569 */       this.logger.error(
/*  564: 570 */         PurchaseWallPaintDaoImpl.class + 
/*  565: 571 */         "Error: Occur in Query While Fetching the specific wall Paint purchase Details from Database For Update.", 
/*  566: 572 */         sqlExp);
/*  567:     */     }
/*  568:     */     catch (Exception exception)
/*  569:     */     {
/*  570: 574 */       exception.printStackTrace();
/*  571: 575 */       this.logger.error(
/*  572: 576 */         PurchaseWallPaintDaoImpl.class + 
/*  573: 577 */         "Error: Occur in Query While Closing Connection After Fetching the specific wall paint purchase Details from Database For Update.", 
/*  574: 578 */         exception);
/*  575:     */     }
/*  576:     */     finally
/*  577:     */     {
/*  578: 580 */       JdbcHelper.closeResultSet(this.resultSet);
/*  579: 581 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/*  580: 582 */       JdbcHelper.closeConnection(this.connection);
/*  581:     */     }
/*  582: 586 */     return wallPaint;
/*  583:     */   }
/*  584:     */   
/*  585:     */   public void updateSpecificPurchaseRecord(PurchaseWallPaintVO purchaseWallPaintVO, int purchaseId, int transactionId)
/*  586:     */     throws UpdateFailedException
/*  587:     */   {
/*  588: 592 */     Connection connection = null;
/*  589: 593 */     PreparedStatement preparedStatement = null;
/*  590: 594 */     System.out.println("update is running************************");
/*  591:     */     try
/*  592:     */     {
/*  593: 597 */       String up = "UPDATE TAB_PURCHASE_WALLPAINT SET PUR_WALLPAINT_COMPANY=?, PUR_WALLPAINT_PRICE=?, PUR_WALLPAINT_AMOUNT=?,PUR_WALLPAINT_GST=?, PUR_WALLPAINT_CGST=?, PUR_WALLPAINT_SGST=?, PUR_WALLPAINT_DEALER_NAME=?, PUR_WALLPAINT_DEALER_CONTACT=?, PUR_WALLPAINT_DEALER_ADDRESS=?, PUR_WALLPAINT_DEALER_REF=?, PUR_WALLPAINT_QUANTITY=?, PUR_WALLPAINT_LITER=?, PUR_WALLPAINT_GST_AMOUNT=?, PUR_WALLPAINT_CGST_AMOUNT=?, PUR_WALLPAINT_SGST_AMOUNT=?, PUR_WALLPAINT_INVOICE_NO=?, PUR_WALLPAINT_ORDER_NO=?, PUR_WALLPAINT_CARRIER_NAME=?, PUR_WALLPAINT_PAYMENT_MODE=?, PUR_WALLPAINT_WEEK_NO=?, PUR_WALLPAINT_INCOTERM=?, PUR_WALLPAINT_PAYMENT=?,PUR_WALLPAINT_INVOICE_DATE=?, PUR_WALLPAINT_MATERIAL_CODE=?, PUR_WALLPAINT_HSN_CODE=?, PUR_WALLPAINT_DELIVERY_PLACE=?, PUR_WALLPAINT_UNIT_PRICE=?, PUR_WALLPAINT_DISCOUNT=?WHERE PUR_WALLPAINT_ID=?";
/*  594:     */       
/*  595:     */ 
/*  596:     */ 
/*  597:     */ 
/*  598:     */ 
/*  599: 603 */       System.out.println("fffffffffffffffffffffF" + purchaseId);
/*  600:     */       
/*  601: 605 */       connection = getConnection();
/*  602: 606 */       preparedStatement = connection.prepareStatement(up);
/*  603: 607 */       preparedStatement.setString(1, purchaseWallPaintVO.getCompanyName());
/*  604: 608 */       preparedStatement.setFloat(2, purchaseWallPaintVO.getUnitPrice());
/*  605: 609 */       preparedStatement.setFloat(3, purchaseWallPaintVO.getNetAmount());
/*  606: 610 */       preparedStatement.setFloat(4, purchaseWallPaintVO.getGst());
/*  607: 611 */       preparedStatement.setFloat(5, purchaseWallPaintVO.getCgst());
/*  608: 612 */       preparedStatement.setFloat(6, purchaseWallPaintVO.getSgst());
/*  609: 613 */       System.out.println(purchaseWallPaintVO.getDealerName() + "LLLLLLLLLLLddddddddd");
/*  610: 614 */       preparedStatement.setString(7, this.nameHelper.getDealerNameById(Integer.parseInt(purchaseWallPaintVO.getDealerName())));
/*  611: 615 */       preparedStatement.setString(8, purchaseWallPaintVO.getDealerContact());
/*  612: 616 */       preparedStatement.setString(9, purchaseWallPaintVO.getDealerAddress());
/*  613: 617 */       preparedStatement.setString(10, purchaseWallPaintVO.getDealerName());
/*  614: 618 */       preparedStatement.setInt(11, purchaseWallPaintVO.getQuantity());
/*  615: 619 */       preparedStatement.setFloat(12, purchaseWallPaintVO.getQuantity());
/*  616: 620 */       preparedStatement.setFloat(13, purchaseWallPaintVO.getGst());
/*  617: 621 */       preparedStatement.setFloat(14, purchaseWallPaintVO.getCgstAmount());
/*  618: 622 */       preparedStatement.setFloat(15, purchaseWallPaintVO.getSgstAmount());
/*  619: 623 */       preparedStatement.setString(16, purchaseWallPaintVO.getInvoiceNo());
/*  620: 624 */       preparedStatement.setString(17, purchaseWallPaintVO.getOrderNo());
/*  621: 625 */       preparedStatement.setString(18, purchaseWallPaintVO.getTransporter());
/*  622: 626 */       preparedStatement.setString(19, purchaseWallPaintVO.getPaymentMode());
/*  623: 627 */       preparedStatement.setString(20, purchaseWallPaintVO.getWeekNo());
/*  624: 628 */       preparedStatement.setString(21, purchaseWallPaintVO.getInconterm());
/*  625: 629 */       preparedStatement.setFloat(22, purchaseWallPaintVO.getPayment());
/*  626: 630 */       preparedStatement.setString(23, DateTimeUtil.convertToDate(purchaseWallPaintVO.getInvoiceDate()));
/*  627:     */       
/*  628: 632 */       preparedStatement.setString(24, purchaseWallPaintVO.getMaterialCode());
/*  629: 633 */       preparedStatement.setString(25, purchaseWallPaintVO.getHsnCode());
/*  630: 634 */       preparedStatement.setString(26, purchaseWallPaintVO.getDeliveryPlace());
/*  631: 635 */       preparedStatement.setFloat(27, purchaseWallPaintVO.getUnitPrice());
/*  632: 636 */       preparedStatement.setFloat(28, purchaseWallPaintVO.getDiscount());
/*  633: 637 */       preparedStatement.setFloat(29, purchaseId);
/*  634: 638 */       System.out.println("trans id is******" + purchaseWallPaintVO.getTransactionId() + " purchaseCementVO.getPayment()" + purchaseWallPaintVO.getPayment());
/*  635: 639 */       int effect = preparedStatement.executeUpdate();
/*  636: 640 */       if (effect != 1) {
/*  637: 643 */         this.logger.info("INFO: Can Not Update purchase Details & Dealer Transaction.");
/*  638:     */       }
/*  639:     */     }
/*  640:     */     catch (SQLException sqlExp)
/*  641:     */     {
/*  642: 648 */       sqlExp.printStackTrace();
/*  643: 649 */       this.logger.error(
/*  644: 650 */         PurchaseWallPaintDaoImpl.class + 
/*  645: 651 */         "Error: Occur in Query While updating the specific cement purchase Details.", 
/*  646: 652 */         sqlExp);
/*  647:     */     }
/*  648:     */     catch (Exception exception)
/*  649:     */     {
/*  650: 654 */       exception.printStackTrace();
/*  651: 655 */       this.logger.error(
/*  652: 656 */         PurchaseWallPaintDaoImpl.class + 
/*  653: 657 */         "Error: Occur in Query While Closing Connection After updating the specific wall paint purchase Details.", 
/*  654: 658 */         exception);
/*  655:     */     }
/*  656:     */     finally
/*  657:     */     {
/*  658: 660 */       JdbcHelper.closeResultSet(this.resultSet);
/*  659: 661 */       JdbcHelper.closePreparedStatement(preparedStatement);
/*  660: 662 */       JdbcHelper.closeConnection(connection);
/*  661:     */     }
/*  662:     */   }
/*  663:     */   
/*  664:     */   public List<PurchaseWallPaintVO> fetchPurchaseWallPaintListForAdvanceSearch(int searchId, String searchValue)
/*  665:     */     throws RecordNotFoundException
/*  666:     */   {
/*  667: 670 */     List<PurchaseWallPaintVO> purchaseWallPaintDetailList = new ArrayList();
/*  668:     */     try
/*  669:     */     {
/*  670: 674 */       this.connection = getConnection();
/*  671:     */       
/*  672: 676 */       this.preparedStatement = this.connection.prepareStatement(QueryBuilder.getPurchaseWallPaintForAdvanceSearch(searchId, searchValue));
/*  673:     */       
/*  674: 678 */       this.resultSet = this.preparedStatement.executeQuery();
/*  675: 682 */       while (this.resultSet.next())
/*  676:     */       {
/*  677: 683 */         this.purchaseWallPaintVO = new PurchaseWallPaintVO();
/*  678: 684 */         this.purchaseWallPaintVO.setPurchaseId(this.resultSet.getInt("PUR_WALLPAINT_ID"));
/*  679:     */         
/*  680: 686 */         this.purchaseWallPaintVO.setDealerName(this.nameHelper.getDealerNameById(this.resultSet.getInt("PUR_WALLPAINT_DEALER_REF")));
/*  681: 687 */         this.purchaseWallPaintVO.setDealerContact(this.resultSet.getString("PUR_WALLPAINT_DEALER_CONTACT"));
/*  682:     */         
/*  683: 689 */         this.purchaseWallPaintVO.setCompanyName(this.resultSet.getString("PUR_WALLPAINT_COMPANY"));
/*  684:     */         
/*  685: 691 */         this.purchaseWallPaintVO.setQuantity(this.resultSet
/*  686: 692 */           .getInt("PUR_WALLPAINT_QUANTITY"));
/*  687:     */         
/*  688: 694 */         this.purchaseWallPaintVO.setInvoiceNo(this.resultSet
/*  689: 695 */           .getString("PUR_WALLPAINT_INVOICE_NO"));
/*  690:     */         
/*  691:     */ 
/*  692: 698 */         this.purchaseWallPaintVO.setOrderNo(this.resultSet
/*  693: 699 */           .getString("PUR_WALLPAINT_ORDER_NO"));
/*  694:     */         
/*  695: 701 */         this.purchaseWallPaintVO.setTransporter(this.resultSet
/*  696: 702 */           .getString("PUR_WALLPAINT_CARRIER_NAME"));
/*  697:     */         
/*  698: 704 */         this.purchaseWallPaintVO.setInvoiceDate(this.resultSet
/*  699: 705 */           .getString("PUR_WALLPAINT_INVOICE_DATE"));
/*  700:     */         
/*  701: 707 */         this.purchaseWallPaintVO.setMaterialCode(this.resultSet
/*  702: 708 */           .getString("PUR_WALLPAINT_MATERIAL_CODE"));
/*  703:     */         
/*  704:     */ 
/*  705: 711 */         this.purchaseWallPaintVO.setUnitPrice(this.resultSet
/*  706: 712 */           .getFloat("PUR_WALLPAINT_UNIT_PRICE"));
/*  707: 713 */         this.purchaseWallPaintVO.setNetAmount(this.resultSet
/*  708: 714 */           .getFloat("PUR_WALLPAINT_AMOUNT"));
/*  709: 715 */         this.purchaseWallPaintVO.setGst(this.resultSet
/*  710: 716 */           .getFloat("PUR_WALLPAINT_GST"));
/*  711:     */         
/*  712:     */ 
/*  713:     */ 
/*  714: 720 */         purchaseWallPaintDetailList.add(this.purchaseWallPaintVO);
/*  715:     */       }
/*  716:     */     }
/*  717:     */     catch (SQLException sqlExp)
/*  718:     */     {
/*  719: 724 */       sqlExp.printStackTrace();
/*  720: 725 */       this.logger.error(
/*  721: 726 */         PurchaseWallPaintDaoImpl.class + 
/*  722: 727 */         "Error: Occur in Query While Fetching the wall paint purchase Details into Grid from Database.", 
/*  723: 728 */         sqlExp);
/*  724:     */     }
/*  725:     */     catch (Exception exception)
/*  726:     */     {
/*  727: 730 */       exception.printStackTrace();
/*  728: 731 */       this.logger.error(
/*  729: 732 */         PurchaseWallPaintDaoImpl.class + 
/*  730: 733 */         "Error: Occur in Query While Closing Connection After Fetching the wall paint purchase into Grid from Database.", 
/*  731: 734 */         exception);
/*  732:     */     }
/*  733:     */     finally
/*  734:     */     {
/*  735: 736 */       JdbcHelper.closeResultSet(this.resultSet);
/*  736: 737 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/*  737: 738 */       JdbcHelper.closeConnection(this.connection);
/*  738:     */     }
/*  739: 740 */     return purchaseWallPaintDetailList;
/*  740:     */   }
/*  741:     */   
/*  742:     */   public int getPurchaseWallPaintLastRecord()
/*  743:     */     throws RecordNotFoundException
/*  744:     */   {
/*  745: 745 */     int temp = 0;
/*  746:     */     try
/*  747:     */     {
/*  748: 747 */       this.connection = getConnection();
/*  749:     */       
/*  750: 749 */       this.preparedStatement = this.connection
/*  751: 750 */         .prepareStatement("SELECT  PUR_WALLPAINT_ID FROM TAB_PURCHASE_WALLPAINT  ORDER BY PUR_WALLPAINT_ID DESC LIMIT 1 ");
/*  752:     */       
/*  753:     */ 
/*  754: 753 */       this.resultSet = this.preparedStatement.executeQuery();
/*  755: 754 */       if (this.resultSet != null) {
/*  756: 755 */         while (this.resultSet.next()) {
/*  757: 757 */           temp = this.resultSet.getInt("PUR_WALLPAINT_ID");
/*  758:     */         }
/*  759:     */       }
/*  760:     */     }
/*  761:     */     catch (SQLException sqlException)
/*  762:     */     {
/*  763: 762 */       sqlException.printStackTrace();
/*  764: 763 */       this.logger.error(
/*  765: 764 */         PurchaseWallPaintDaoImpl.class + 
/*  766: 765 */         ": Error:- Error: Occur in Query While counting the Purchase wallpaint details recods from Database", 
/*  767: 766 */         sqlException);
/*  768:     */     }
/*  769:     */     catch (Exception exception)
/*  770:     */     {
/*  771: 769 */       exception.printStackTrace();
/*  772: 770 */       this.logger.error(
/*  773: 771 */         PurchaseWallPaintDaoImpl.class + 
/*  774: 772 */         ": Error:- While closing the Connection after counting the Purchase wallpaint details recods from Database", 
/*  775: 773 */         exception);
/*  776:     */     }
/*  777:     */     finally
/*  778:     */     {
/*  779: 775 */       JdbcHelper.closeResultSet(this.resultSet);
/*  780: 776 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/*  781: 777 */       JdbcHelper.closeConnection(this.connection);
/*  782:     */     }
/*  783: 779 */     return temp;
/*  784:     */   }
/*  785:     */   
/*  786:     */   public WallPaint getPurchaseWallPaintDetails(int purchaseId)
/*  787:     */     throws RecordNotFoundException
/*  788:     */   {
/*  789: 788 */     WallPaint wallPaint = new WallPaint();
/*  790:     */     try
/*  791:     */     {
/*  792: 791 */       this.connection = getConnection();
/*  793:     */       
/*  794: 793 */       this.preparedStatement = this.connection
/*  795: 794 */         .prepareStatement("SELECT * FROM TAB_PURCHASE_WALLPAINT WHERE PUR_WALLPAINT_ID=?");
/*  796: 795 */       this.preparedStatement.setInt(1, purchaseId);
/*  797:     */       
/*  798:     */ 
/*  799: 798 */       this.resultSet = this.preparedStatement.executeQuery();
/*  800: 799 */       System.out.println("----------hye ----------------");
/*  801: 800 */       if (this.resultSet != null) {
/*  802: 801 */         while (this.resultSet.next())
/*  803:     */         {
/*  804: 803 */           System.out.println("----------hye ----------------");
/*  805:     */           
/*  806: 805 */           wallPaint.setPurchaseId(this.resultSet.getInt("PUR_WALLPAINT_ID"));
/*  807: 806 */           System.out.println("________________" + this.resultSet.getInt("PUR_WALLPAINT_ID"));
/*  808:     */           
/*  809: 808 */           wallPaint.setCompanyName(this.resultSet.getString("PUR_WALLPAINT_COMPANY"));
/*  810: 809 */           System.out.println("---------" + this.resultSet.getString("PUR_WALLPAINT_PRICE"));
/*  811:     */           
/*  812:     */ 
/*  813:     */ 
/*  814:     */ 
/*  815:     */ 
/*  816: 815 */           wallPaint.setNetAmount(this.resultSet
/*  817: 816 */             .getFloat("PUR_WALLPAINT_AMOUNT"));
/*  818:     */           
/*  819: 818 */           wallPaint.setGst(this.resultSet
/*  820: 819 */             .getFloat("PUR_WALLPAINT_GST"));
/*  821:     */           
/*  822: 821 */           wallPaint.setCgst(this.resultSet
/*  823: 822 */             .getFloat("PUR_WALLPAINT_CGST"));
/*  824:     */           
/*  825: 824 */           wallPaint.setSgst(this.resultSet
/*  826: 825 */             .getFloat("PUR_WALLPAINT_SGST"));
/*  827:     */           
/*  828: 827 */           wallPaint.setdFullName(this.resultSet.getString("PUR_WALLPAINT_DEALER_NAME"));
/*  829:     */           
/*  830: 829 */           wallPaint.setDealerContact(this.resultSet.getString("PUR_WALLPAINT_DEALER_CONTACT"));
/*  831:     */           
/*  832: 831 */           wallPaint.setDealerAddress(this.resultSet.getString("PUR_WALLPAINT_DEALER_ADDRESS"));
/*  833:     */           
/*  834: 833 */           wallPaint.setDealerRef(this.resultSet.getInt("PUR_WALLPAINT_DEALER_REF"));
/*  835:     */           
/*  836: 835 */           wallPaint.setQuantity(this.resultSet
/*  837: 836 */             .getInt("PUR_WALLPAINT_QUANTITY"));
/*  838:     */           
/*  839:     */ 
/*  840:     */ 
/*  841:     */ 
/*  842: 841 */           wallPaint.setGstAmount(this.resultSet
/*  843: 842 */             .getFloat("PUR_WALLPAINT_GST_AMOUNT"));
/*  844: 843 */           wallPaint.setCgstAmount(this.resultSet
/*  845: 844 */             .getFloat("PUR_WALLPAINT_CGST_AMOUNT"));
/*  846: 845 */           wallPaint.setSgstAmount(this.resultSet
/*  847: 846 */             .getFloat("PUR_WALLPAINT_SGST_AMOUNT"));
/*  848: 847 */           wallPaint.setInvoiceNo(this.resultSet
/*  849: 848 */             .getString("PUR_WALLPAINT_INVOICE_NO"));
/*  850:     */           
/*  851: 850 */           wallPaint.setOrderNo(this.resultSet
/*  852: 851 */             .getString("PUR_WALLPAINT_ORDER_NO"));
/*  853:     */           
/*  854: 853 */           wallPaint.setTransporter(this.resultSet
/*  855: 854 */             .getString("PUR_WALLPAINT_CARRIER_NAME"));
/*  856:     */           
/*  857:     */ 
/*  858:     */ 
/*  859:     */ 
/*  860: 859 */           wallPaint.setWeekNo(this.resultSet
/*  861: 860 */             .getString("PUR_WALLPAINT_WEEK_NO"));
/*  862:     */           
/*  863: 862 */           wallPaint.setInconterm(this.resultSet
/*  864: 863 */             .getString("PUR_WALLPAINT_INCOTERM"));
/*  865:     */           
/*  866:     */ 
/*  867:     */ 
/*  868: 867 */           wallPaint.setInvoiceDate(this.resultSet
/*  869: 868 */             .getString("PUR_WALLPAINT_INVOICE_DATE"));
/*  870:     */           
/*  871: 870 */           wallPaint.setMaterialCode(this.resultSet
/*  872: 871 */             .getString("PUR_WALLPAINT_MATERIAL_CODE"));
/*  873:     */           
/*  874:     */ 
/*  875: 874 */           wallPaint.setHsnCode(this.resultSet
/*  876: 875 */             .getString("PUR_WALLPAINT_HSN_CODE"));
/*  877:     */           
/*  878: 877 */           wallPaint.setDeliveryPlace(this.resultSet
/*  879: 878 */             .getString("PUR_WALLPAINT_DELIVERY_PLACE"));
/*  880:     */           
/*  881: 880 */           wallPaint.setUnitPrice(this.resultSet
/*  882: 881 */             .getFloat("PUR_WALLPAINT_UNIT_PRICE"));

wallPaint.setDiscount(this.resultSet
/*  882: 881 */             .getFloat("PUR_WALLPAINT_DISCOUNT"));
/*  883:     */         }
/*  884:     */       }
/*  885:     */     }
/*  886:     */     catch (SQLException sqlExp)
/*  887:     */     {
/*  888: 891 */       sqlExp.printStackTrace();
/*  889: 892 */       this.logger.error(
/*  890: 893 */         PurchaseWallPaintDaoImpl.class + 
/*  891: 894 */         "Error: Occur in Query While Fetching the specific next wallpaint purchase Details from Database.", 
/*  892: 895 */         sqlExp);
/*  893:     */     }
/*  894:     */     catch (Exception exception)
/*  895:     */     {
/*  896: 897 */       exception.printStackTrace();
/*  897: 898 */       this.logger.error(
/*  898: 899 */         PurchaseWallPaintDaoImpl.class + 
/*  899: 900 */         "Error: Occur in Query While Closing Connection After Fetching the specific next wallpaint purchase Details from Database.", 
/*  900: 901 */         exception);
/*  901:     */     }
/*  902:     */     finally
/*  903:     */     {
/*  904: 903 */       JdbcHelper.closeResultSet(this.resultSet);
/*  905: 904 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/*  906: 905 */       JdbcHelper.closeConnection(this.connection);
/*  907:     */     }
/*  908: 909 */     return wallPaint;
/*  909:     */   }
/*  910:     */   
/*  911:     */   public WallPaint retrivePurchaseWallPaintDaoInfFullDetailGrid(int purchaseId)
/*  912:     */   {
/*  913: 916 */     WallPaint wallPaint = new WallPaint();
/*  914:     */     try
/*  915:     */     {
/*  916: 919 */       this.connection = getConnection();
/*  917:     */       
/*  918: 921 */       this.preparedStatement = this.connection
/*  919: 922 */         .prepareStatement("SELECT * FROM TAB_PURCHASE_WALLPAINT WHERE PUR_WALLPAINT_ID=? ");
/*  920: 923 */       this.preparedStatement.setInt(1, purchaseId);
/*  921:     */       
/*  922: 925 */       this.resultSet = this.preparedStatement.executeQuery();
/*  923: 926 */       System.out.println("----------hye ----------------");
/*  924: 927 */       if (this.resultSet != null) {
/*  925: 928 */         while (this.resultSet.next())
/*  926:     */         {
/*  927: 930 */           System.out.println("----------hye ----------------");
/*  928:     */           
/*  929: 932 */           wallPaint.setPurchaseId(this.resultSet.getInt("PUR_WALLPAINT_ID"));
/*  930: 933 */           System.out.println("________________" + this.resultSet.getInt("PUR_WALLPAINT_ID"));
/*  931:     */           
/*  932: 935 */           wallPaint.setCompanyName(this.resultSet.getString("PUR_WALLPAINT_COMPANY"));
/*  933: 936 */           System.out.println("---------" + this.resultSet.getString("PUR_WALLPAINT_COMPANY"));
/*  934:     */           
/*  935:     */ 
/*  936:     */ 
/*  937:     */ 
/*  938:     */ 
/*  939: 942 */           wallPaint.setNetAmount(this.resultSet
/*  940: 943 */             .getFloat("PUR_WALLPAINT_AMOUNT"));
/*  941:     */           
/*  942: 945 */           wallPaint.setGst(this.resultSet
/*  943: 946 */             .getFloat("PUR_WALLPAINT_GST"));
/*  944:     */           
/*  945: 948 */           wallPaint.setCgst(this.resultSet
/*  946: 949 */             .getFloat("PUR_WALLPAINT_CGST"));
/*  947:     */           
/*  948: 951 */           wallPaint.setSgst(this.resultSet
/*  949: 952 */             .getFloat("PUR_WALLPAINT_SGST"));
/*  950:     */           
/*  951: 954 */           wallPaint.setdFullName(this.resultSet.getString("PUR_WALLPAINT_DEALER_NAME"));
/*  952:     */           
/*  953: 956 */           wallPaint.setDealerContact(this.resultSet.getString("PUR_WALLPAINT_DEALER_CONTACT"));
/*  954:     */           
/*  955: 958 */           wallPaint.setDealerAddress(this.resultSet.getString("PUR_WALLPAINT_DEALER_ADDRESS"));
/*  956:     */           
/*  957: 960 */           wallPaint.setDealerRef(this.resultSet.getInt("PUR_WALLPAINT_DEALER_REF"));
/*  958:     */           
/*  959: 962 */           wallPaint.setQuantity(this.resultSet
/*  960: 963 */             .getInt("PUR_WALLPAINT_QUANTITY"));
/*  961:     */           
/*  962:     */ 
/*  963:     */ 
/*  964:     */ 
/*  965: 968 */           wallPaint.setGstAmount(this.resultSet
/*  966: 969 */             .getFloat("PUR_WALLPAINT_GST_AMOUNT"));
/*  967: 970 */           wallPaint.setCgstAmount(this.resultSet
/*  968: 971 */             .getFloat("PUR_WALLPAINT_CGST_AMOUNT"));
/*  969: 972 */           wallPaint.setSgstAmount(this.resultSet
/*  970: 973 */             .getFloat("PUR_WALLPAINT_SGST_AMOUNT"));
/*  971: 974 */           wallPaint.setInvoiceNo(this.resultSet
/*  972: 975 */             .getString("PUR_WALLPAINT_INVOICE_NO"));
/*  973:     */           
/*  974: 977 */           wallPaint.setOrderNo(this.resultSet
/*  975: 978 */             .getString("PUR_WALLPAINT_ORDER_NO"));
/*  976:     */           
/*  977: 980 */           wallPaint.setTransporter(this.resultSet
/*  978: 981 */             .getString("PUR_WALLPAINT_CARRIER_NAME"));
/*  979:     */           
/*  980:     */ 
/*  981:     */ 
/*  982:     */ 
/*  983: 986 */           wallPaint.setWeekNo(this.resultSet
/*  984: 987 */             .getString("PUR_WALLPAINT_WEEK_NO"));
/*  985:     */           
/*  986: 989 */           wallPaint.setInconterm(this.nameHelper.getProductTypeNameByProductId(Integer.parseInt(this.nameHelper.getProductNameById(this.resultSet
/*  987: 990 */             .getInt("PUR_WALLPAINT_INCOTERM")))));
/*  988:     */           
/*  989:     */ 
/*  990:     */ 
/*  991: 994 */           wallPaint.setInvoiceDate(this.resultSet
/*  992: 995 */             .getString("PUR_WALLPAINT_INVOICE_DATE"));
/*  993:     */           
/*  994: 997 */           wallPaint.setMaterialCode(this.resultSet
/*  995: 998 */             .getString("PUR_WALLPAINT_MATERIAL_CODE"));
/*  996:     */           
/*  997:     */ 
/*  998:1001 */           wallPaint.setHsnCode(this.resultSet
/*  999:1002 */             .getString("PUR_WALLPAINT_HSN_CODE"));
/* 1000:     */           
/* 1001:1004 */           wallPaint.setDeliveryPlace(this.resultSet
/* 1002:1005 */             .getString("PUR_WALLPAINT_DELIVERY_PLACE"));
/* 1003:     */           
/* 1004:1007 */           wallPaint.setUnitPrice(this.resultSet
/* 1005:1008 */             .getFloat("PUR_WALLPAINT_UNIT_PRICE"));
wallPaint.setDiscount(this.resultSet
/* 1005:1008 */             .getFloat("PUR_WALLPAINT_DISCOUNT"));
/* 1006:     */         }
/* 1007:     */       }
/* 1008:     */     }
/* 1009:     */     catch (SQLException sqlExp)
/* 1010:     */     {
/* 1011:1018 */       sqlExp.printStackTrace();
/* 1012:1019 */       this.logger.error(
/* 1013:1020 */         PurchaseWallPaintDaoImpl.class + 
/* 1014:1021 */         "Error: Occur in Query While Fetching the specific purchase wall paint Details from Database.", 
/* 1015:1022 */         sqlExp);
/* 1016:     */     }
/* 1017:     */     catch (Exception exception)
/* 1018:     */     {
/* 1019:1024 */       exception.printStackTrace();
/* 1020:1025 */       this.logger.error(
/* 1021:1026 */         PurchaseWallPaintDaoImpl.class + 
/* 1022:1027 */         "Error: Occur in Query While Closing Connection After Fetching the specific purchase wall paint Details from Database.", 
/* 1023:1028 */         exception);
/* 1024:     */     }
/* 1025:     */     finally
/* 1026:     */     {
/* 1027:1030 */       JdbcHelper.closeResultSet(this.resultSet);
/* 1028:1031 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/* 1029:1032 */       JdbcHelper.closeConnection(this.connection);
/* 1030:     */     }
/* 1031:1036 */     return wallPaint;
/* 1032:     */   }
/* 1033:     */   
/* 1034:     */   public int deleteWallPaint(int purchaseId)
/* 1035:     */     throws Exception
/* 1036:     */   {
/* 1037:1045 */     int target = 0;
/* 1038:     */     try
/* 1039:     */     {
/* 1040:1048 */       System.out.println(purchaseId + "jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj");
/* 1041:1049 */       this.connection = getConnection();
/* 1042:1050 */       this.preparedStatement = this.connection
/* 1043:1051 */         .prepareStatement("DELETE  FROM TAB_PURCHASE_WALLPAINT WHERE PUR_WALLPAINT_ID = ?");
/* 1044:     */       
/* 1045:1053 */       this.preparedStatement.setInt(1, purchaseId);
/* 1046:1054 */       this.preparedStatement.executeUpdate();
/* 1047:1055 */       target = 1;
/* 1048:     */     }
/* 1049:     */     catch (Exception exception)
/* 1050:     */     {
/* 1051:1058 */       this.logger.error(PurchaseWallPaintDaoImpl.class + 
/* 1052:1059 */         ": Error:- While deleting purchase wallpaint details from Database.");
/* 1053:     */     }
/* 1054:     */     finally
/* 1055:     */     {
/* 1056:1061 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/* 1057:1062 */       JdbcHelper.closeConnection(this.connection);
/* 1058:     */     }
/* 1059:1065 */     return target;
/* 1060:     */   }
/* 1061:     */   
/* 1062:     */   public void generatePurchaseWallPaintPdf(HttpServletRequest request, HttpServletResponse response, int purchaseId)
/* 1063:     */     throws Exception
/* 1064:     */   {
/* 1065:1073 */     String companyName = "Chouksay Traders";
/* 1066:1074 */     String address1 = "BUS STAND SHAMSHABAD, DIST.- VIDISHA, MADHYA PRADESH, 464001";
/* 1067:1075 */     String address2 = "GSTIN: 23AJQPC8200P1Z1";
/* 1068:1076 */     String address3 = "PAN NO: AJQPC8200P";
/* 1069:     */     
/* 1070:1078 */     String city = "Vidisha-464001";
/* 1071:1079 */     String state = "(M.P.)";
/* 1072:1080 */     StringBuffer stringBuffer = null;
/* 1073:1081 */     response = ServletActionContext.getResponse();
/* 1074:     */     try
/* 1075:     */     {
/* 1076:1084 */       this.connection = getConnection();
/* 1077:1085 */       this.preparedStatement = this.connection
/* 1078:1086 */         .prepareStatement(" SELECT * FROM TAB_PURCHASE_WALLPAINT WHERE PUR_WALLPAINT_ID=?");
/* 1079:1087 */       this.preparedStatement.setInt(1, purchaseId);
/* 1080:1088 */       this.resultSet = this.preparedStatement.executeQuery();
/* 1081:1089 */       Document document = new Document(PageSize.A4);
/* 1082:     */       
/* 1083:1091 */       Font Font3 = new Font(Font.FontFamily.TIMES_ROMAN, 11.0F, 0);
/* 1084:1092 */       Font Font2 = new Font(Font.FontFamily.TIMES_ROMAN, 6.0F, 
/* 1085:1093 */         8);
/* 1086:1094 */       Font Font4 = new Font(Font.FontFamily.TIMES_ROMAN, 11.0F, 1);
/* 1087:1095 */       Font4.setColor(BaseColor.WHITE);
/* 1088:1096 */       Font mainContent = new Font(Font.FontFamily.TIMES_ROMAN, 10.0F, 
/* 1089:1097 */         0);
/* 1090:1098 */       Font Font5 = new Font(Font.FontFamily.TIMES_ROMAN, 12.0F, 1);
/* 1091:1099 */       Font5.setColor(BaseColor.GRAY);
/* 1092:1100 */       Font Font6 = new Font(Font.FontFamily.TIMES_ROMAN, 10.0F, 1);
/* 1093:1101 */       Font6.setColor(BaseColor.RED);
/* 1094:     */       
/* 1095:     */ 
/* 1096:1104 */       response.setContentType("application/pdf");
/* 1097:     */       
/* 1098:1106 */       PdfWriter.getInstance(document, response.getOutputStream());
/* 1099:     */       
/* 1100:1108 */       document.open();
/* 1101:     */       
/* 1102:1110 */       String contextPath = ServletActionContext.getServletContext()
/* 1103:1111 */         .getRealPath("/outer/img/rohittraders.png");
/* 1104:1112 */       this.image = Image.getInstance(contextPath);
/* 1105:1113 */       this.image.scaleToFit(130.0F, 70.0F);
/* 1106:     */       
/* 1107:1115 */       PdfPTable table1 = new PdfPTable(2);
/* 1108:1116 */       table1.setWidthPercentage(100.0F);
/* 1109:1117 */       Rectangle rect1 = new Rectangle(300.0F, 700.0F);
/* 1110:1118 */       table1.setWidthPercentage(new float[] { 150.0F, 150.0F }, rect1);
/* 1111:     */       
/* 1112:1120 */       PdfPCell cell101 = new PdfPCell(this.image, false);
/* 1113:1121 */       cell101.setPaddingTop(5.0F);
/* 1114:1122 */       cell101.setBorder(0);
/* 1115:     */       
/* 1116:1124 */       Phrase phrase3 = new Phrase(companyName + "\n", Font5);
/* 1117:1125 */       Phrase phrase = new Phrase(address1 + "\n", Font3);
/* 1118:1126 */       Phrase phrase1 = new Phrase(address2 + "\n", Font3);
/* 1119:1127 */       Phrase phrase2 = new Phrase(city + "-" + state, Font3);
/* 1120:     */       
/* 1121:1129 */       Paragraph paragraph = new Paragraph();
/* 1122:1130 */       paragraph.add(phrase3);
/* 1123:1131 */       paragraph.add(phrase);
/* 1124:1132 */       paragraph.add(phrase1);
/* 1125:1133 */       paragraph.add(phrase2);
/* 1126:     */       
/* 1127:1135 */       PdfPCell cell102 = new PdfPCell(paragraph);
/* 1128:1136 */       cell102.setPaddingTop(5.0F);
/* 1129:1137 */       cell102.setBorder(0);
/* 1130:1138 */       cell102.setHorizontalAlignment(2);
/* 1131:     */       
/* 1132:1140 */       PdfPCell cell103 = new PdfPCell(
/* 1133:1141 */         new Paragraph(
/* 1134:1142 */         "   \n                                                                                                                                                                                                                                                                                                                                                  ", 
/* 1135:     */         
/* 1136:     */ 
/* 1137:1145 */         Font2));
/* 1138:1146 */       cell103.setColspan(2);
/* 1139:1147 */       cell103.setBorderWidthRight(0.0F);
/* 1140:1148 */       cell103.setBorderWidthLeft(0.0F);
/* 1141:1149 */       cell103.setBorderWidthTop(0.5F);
/* 1142:1150 */       cell103.setBorderWidthBottom(0.0F);
/* 1143:1151 */       cell103.setBorderColorTop(BaseColor.WHITE);
/* 1144:     */       
/* 1145:1153 */       PdfPCell cell104 = new PdfPCell(new Paragraph("PurchaseWallPaint REPORT", Font4));
/* 1146:1154 */       cell104.setUseBorderPadding(true);
/* 1147:1155 */       cell104.setColspan(2);
/* 1148:1156 */       cell104.setBorderWidthRight(0.1F);
/* 1149:1157 */       cell104.setBorderWidthLeft(0.1F);
/* 1150:1158 */       cell104.setBorderWidthTop(0.1F);
/* 1151:1159 */       cell104.setBorderWidthBottom(0.1F);
/* 1152:1160 */       cell104.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1153:1161 */       cell104.setBackgroundColor(new BaseColor(128, 0, 0));
/* 1154:     */       
/* 1155:1163 */       table1.addCell(cell101);
/* 1156:1164 */       table1.addCell(cell102);
/* 1157:1165 */       table1.addCell(cell103);
/* 1158:1166 */       table1.addCell(cell104);
/* 1159:1167 */       document.add(table1);
/* 1160:1173 */       while (this.resultSet.next())
/* 1161:     */       {
/* 1162:1174 */         stringBuffer = new StringBuffer();
/* 1163:1175 */         PdfPTable table = new PdfPTable(2);
/* 1164:1176 */         table.setFooterRows(1);
/* 1165:1177 */         table.setWidthPercentage(100.0F);
/* 1166:1178 */         Rectangle rect = new Rectangle(300.0F, 700.0F);
/* 1167:1179 */         table.setWidthPercentage(new float[] { 80.0F, 220.0F }, rect);
/* 1168:     */         
/* 1169:1181 */         PdfPCell cell = new PdfPCell(new Paragraph());
/* 1170:1182 */         cell.setColspan(2);
/* 1171:1183 */         cell.setBorderWidthRight(0.1F);
/* 1172:1184 */         cell.setBorderWidthLeft(0.1F);
/* 1173:1185 */         cell.setBorderWidthTop(0.1F);
/* 1174:1186 */         cell.setBorderWidthBottom(0.2F);
/* 1175:1187 */         cell.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1176:1188 */         cell.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1177:     */         
/* 1178:1190 */         PdfPCell cell1 = new PdfPCell(new Paragraph("WallPaint Information", 
/* 1179:1191 */           Font6));
/* 1180:1192 */         cell1.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1181:1193 */         cell1.setBorderWidth(0.01F);
/* 1182:1194 */         cell1.setBorderColor(BaseColor.WHITE);
/* 1183:     */         
/* 1184:1196 */         PdfPCell cell2 = new PdfPCell(new Paragraph());
/* 1185:1197 */         cell2.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1186:1198 */         cell2.setBorderWidth(0.2F);
/* 1187:1199 */         cell2.setBorderColor(BaseColor.WHITE);
/* 1188:     */         
/* 1189:     */ 
/* 1190:     */ 
/* 1191:1203 */         PdfPCell cell3 = new PdfPCell(new Paragraph("wallpaint Id", 
/* 1192:1204 */           mainContent));
/* 1193:1205 */         cell3.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1194:1206 */         cell3.setBorderWidth(0.01F);
/* 1195:1207 */         cell3.setBorderColor(BaseColor.WHITE);
/* 1196:     */         
/* 1197:1209 */         PdfPCell cell4 = new PdfPCell(new Paragraph(this.resultSet.getString("PUR_WALLPAINT_ID"), mainContent));
/* 1198:1210 */         cell4.setBorderWidth(0.2F);
/* 1199:1211 */         cell4.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1200:     */         
/* 1201:1213 */         PdfPCell cell5 = new PdfPCell(new Paragraph(
/* 1202:1214 */           "wallpaint company", mainContent));
/* 1203:1215 */         cell5.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1204:1216 */         cell5.setBorderWidth(0.01F);
/* 1205:1217 */         cell5.setBorderColor(BaseColor.WHITE);
/* 1206:     */         
/* 1207:1219 */         PdfPCell cell6 = new PdfPCell(new Paragraph(this.resultSet.getString("PUR_WALLPAINT_COMPANY"), mainContent));
/* 1208:1220 */         cell6.setBorderWidth(0.2F);
/* 1209:1221 */         cell6.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1210:     */         
/* 1211:1223 */         PdfPCell cell7 = new PdfPCell(new Paragraph("Amount", 
/* 1212:1224 */           mainContent));
/* 1213:1225 */         cell7.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1214:1226 */         cell7.setBorderWidth(0.01F);
/* 1215:1227 */         cell7.setBorderColor(BaseColor.WHITE);
/* 1216:     */         
/* 1217:1229 */         PdfPCell cell8 = new PdfPCell(new Paragraph(
/* 1218:1230 */           this.resultSet.getString("PUR_WALLPAINT_AMOUNT"), mainContent));
/* 1219:1231 */         cell8.setBorderWidth(0.2F);
/* 1220:1232 */         cell8.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1221:     */         
/* 1222:1234 */         PdfPCell cell9 = new PdfPCell(new Paragraph("GST", 
/* 1223:1235 */           mainContent));
/* 1224:1236 */         cell9.setBorderWidth(0.1F);
/* 1225:1237 */         cell9.setBorderColor(BaseColor.WHITE);
/* 1226:     */         
/* 1227:1239 */         PdfPCell cell10 = new PdfPCell(new Paragraph(
/* 1228:1240 */           this.resultSet.getString("PUR_WALLPAINT_GST"), mainContent));
/* 1229:1241 */         cell10.setBorderWidth(0.2F);
/* 1230:1242 */         cell10.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1231:     */         
/* 1232:1244 */         PdfPCell cell11 = new PdfPCell(new Paragraph("CGST", 
/* 1233:1245 */           mainContent));
/* 1234:1246 */         cell11.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1235:1247 */         cell11.setBorderWidth(0.01F);
/* 1236:1248 */         cell11.setBorderColor(BaseColor.WHITE);
/* 1237:     */         
/* 1238:1250 */         PdfPCell cell12 = new PdfPCell(new Paragraph(this.resultSet.getString("PUR_WALLPAINT_CGST"), mainContent));
/* 1239:1251 */         cell12.setBorderWidth(0.2F);
/* 1240:1252 */         cell12.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1241:     */         
/* 1242:1254 */         PdfPCell cell13 = new PdfPCell(new Paragraph("SGST", 
/* 1243:1255 */           mainContent));
/* 1244:1256 */         cell13.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1245:1257 */         cell13.setBorderWidth(0.01F);
/* 1246:1258 */         cell13.setBorderColor(BaseColor.WHITE);
/* 1247:     */         
/* 1248:1260 */         PdfPCell cell14 = new PdfPCell(new Paragraph(this.resultSet.getString("PUR_WALLPAINT_SGST"), mainContent));
/* 1249:1261 */         cell14.setBorderWidth(0.2F);
/* 1250:1262 */         cell14.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1251:     */         
/* 1252:1264 */         PdfPCell cell15 = new PdfPCell(new Paragraph(
/* 1253:1265 */           "Dealer Name", mainContent));
/* 1254:1266 */         cell15.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1255:1267 */         cell15.setBorderWidth(0.01F);
/* 1256:1268 */         cell15.setBorderColor(BaseColor.WHITE);
/* 1257:     */         
/* 1258:1270 */         PdfPCell cell16 = new PdfPCell(new Paragraph(this.resultSet.getString("PUR_WALLPAINT_DEALER_NAME"), mainContent));
/* 1259:1271 */         cell16.setBorderWidth(0.2F);
/* 1260:1272 */         cell16.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1261:     */         
/* 1262:1274 */         PdfPCell cell17 = new PdfPCell(new Paragraph(
/* 1263:1275 */           "Dealer Contact", mainContent));
/* 1264:1276 */         cell17.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1265:1277 */         cell17.setBorderWidth(0.01F);
/* 1266:1278 */         cell17.setBorderColor(BaseColor.WHITE);
/* 1267:     */         
/* 1268:1280 */         PdfPCell cell18 = new PdfPCell(new Paragraph(this.resultSet.getString("PUR_WALLPAINT_DEALER_CONTACT"), mainContent));
/* 1269:1281 */         cell18.setBorderWidth(0.2F);
/* 1270:1282 */         cell18.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1271:     */         
/* 1272:1284 */         PdfPCell cell19 = new PdfPCell(new Paragraph(
/* 1273:1285 */           "Dealer Address", mainContent));
/* 1274:1286 */         cell19.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1275:1287 */         cell19.setBorderWidth(0.01F);
/* 1276:1288 */         cell19.setBorderColor(BaseColor.WHITE);
/* 1277:     */         
/* 1278:1290 */         PdfPCell cell20 = new PdfPCell(new Paragraph(this.resultSet.getString("PUR_WALLPAINT_DEALER_ADDRESS"), mainContent));
/* 1279:1291 */         cell20.setBorderWidth(0.2F);
/* 1280:1292 */         cell20.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1281:     */         
/* 1282:1294 */         PdfPCell cell21 = new PdfPCell(new Paragraph(
/* 1283:1295 */           "Dealer REF", mainContent));
/* 1284:1296 */         cell21.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1285:1297 */         cell21.setBorderWidth(0.01F);
/* 1286:1298 */         cell21.setBorderColor(BaseColor.WHITE);
/* 1287:     */         
/* 1288:1300 */         PdfPCell cell22 = new PdfPCell(new Paragraph(this.resultSet.getString("PUR_WALLPAINT_DEALER_REF"), mainContent));
/* 1289:1301 */         cell22.setBorderWidth(0.2F);
/* 1290:1302 */         cell22.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1291:     */         
/* 1292:     */ 
/* 1293:1305 */         PdfPCell cell23 = new PdfPCell(new Paragraph(
/* 1294:1306 */           "Quantity", mainContent));
/* 1295:1307 */         cell23.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1296:1308 */         cell23.setBorderWidth(0.01F);
/* 1297:1309 */         cell23.setBorderColor(BaseColor.WHITE);
/* 1298:     */         
/* 1299:1311 */         PdfPCell cell24 = new PdfPCell(new Paragraph(this.resultSet.getString("PUR_WALLPAINT_QUANTITY"), mainContent));
/* 1300:1312 */         cell24.setBorderWidth(0.2F);
/* 1301:1313 */         cell24.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1302:     */         
/* 1303:1315 */         PdfPCell cell25 = new PdfPCell(new Paragraph(
/* 1304:1316 */           "GST Amount", mainContent));
/* 1305:1317 */         cell25.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1306:1318 */         cell25.setBorderWidth(0.01F);
/* 1307:1319 */         cell25.setBorderColor(BaseColor.WHITE);
/* 1308:     */         
/* 1309:1321 */         PdfPCell cell26 = new PdfPCell(new Paragraph(this.resultSet.getString("PUR_WALLPAINT_GST_AMOUNT"), mainContent));
/* 1310:1322 */         cell26.setBorderWidth(0.2F);
/* 1311:1323 */         cell26.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1312:     */         
/* 1313:1325 */         PdfPCell cell27 = new PdfPCell(new Paragraph(
/* 1314:1326 */           "CGST Amount", mainContent));
/* 1315:1327 */         cell27.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1316:1328 */         cell27.setBorderWidth(0.01F);
/* 1317:1329 */         cell27.setBorderColor(BaseColor.WHITE);
/* 1318:     */         
/* 1319:1331 */         PdfPCell cell28 = new PdfPCell(new Paragraph(this.resultSet.getString("PUR_WALLPAINT_CGST_AMOUNT"), mainContent));
/* 1320:1332 */         cell28.setBorderWidth(0.2F);
/* 1321:1333 */         cell28.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1322:     */         
/* 1323:1335 */         PdfPCell cell29 = new PdfPCell(new Paragraph(
/* 1324:1336 */           "SGST Amount", mainContent));
/* 1325:1337 */         cell29.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1326:1338 */         cell29.setBorderWidth(0.01F);
/* 1327:1339 */         cell29.setBorderColor(BaseColor.WHITE);
/* 1328:     */         
/* 1329:1341 */         PdfPCell cell30 = new PdfPCell(new Paragraph(this.resultSet.getString("PUR_WALLPAINT_SGST_AMOUNT"), mainContent));
/* 1330:1342 */         cell30.setBorderWidth(0.2F);
/* 1331:1343 */         cell30.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1332:     */         
/* 1333:1345 */         PdfPCell cell31 = new PdfPCell(new Paragraph(
/* 1334:1346 */           "Invoice No", mainContent));
/* 1335:1347 */         cell31.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1336:1348 */         cell31.setBorderWidth(0.01F);
/* 1337:1349 */         cell31.setBorderColor(BaseColor.WHITE);
/* 1338:     */         
/* 1339:1351 */         PdfPCell cell32 = new PdfPCell(new Paragraph(this.resultSet.getString("PUR_WALLPAINT_INVOICE_NO"), mainContent));
/* 1340:1352 */         cell32.setBorderWidth(0.2F);
/* 1341:1353 */         cell32.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1342:     */         
/* 1343:1355 */         PdfPCell cell33 = new PdfPCell(new Paragraph(
/* 1344:1356 */           "Order No", mainContent));
/* 1345:1357 */         cell33.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1346:1358 */         cell33.setBorderWidth(0.01F);
/* 1347:1359 */         cell33.setBorderColor(BaseColor.WHITE);
/* 1348:     */         
/* 1349:1361 */         PdfPCell cell34 = new PdfPCell(new Paragraph(this.resultSet.getString("PUR_WALLPAINT_ORDER_NO"), mainContent));
/* 1350:1362 */         cell34.setBorderWidth(0.2F);
/* 1351:1363 */         cell34.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1352:     */         
/* 1353:1365 */         PdfPCell cell35 = new PdfPCell(new Paragraph(
/* 1354:1366 */           "Carrier Name", mainContent));
/* 1355:1367 */         cell35.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1356:1368 */         cell35.setBorderWidth(0.01F);
/* 1357:1369 */         cell35.setBorderColor(BaseColor.WHITE);
/* 1358:     */         
/* 1359:1371 */         PdfPCell cell36 = new PdfPCell(new Paragraph(this.resultSet.getString("PUR_WALLPAINT_CARRIER_NAME"), mainContent));
/* 1360:1372 */         cell36.setBorderWidth(0.2F);
/* 1361:1373 */         cell36.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1362:     */         
/* 1363:1375 */         PdfPCell cell37 = new PdfPCell(new Paragraph(
/* 1364:1376 */           "Invoice Date", mainContent));
/* 1365:1377 */         cell37.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1366:1378 */         cell37.setBorderWidth(0.01F);
/* 1367:1379 */         cell37.setBorderColor(BaseColor.WHITE);
/* 1368:     */         
/* 1369:1381 */         PdfPCell cell38 = new PdfPCell(new Paragraph(this.resultSet.getString("PUR_WALLPAINT_INVOICE_DATE"), mainContent));
/* 1370:1382 */         cell38.setBorderWidth(0.2F);
/* 1371:1383 */         cell38.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1372:     */         
/* 1373:1385 */         PdfPCell cell39 = new PdfPCell(new Paragraph(
/* 1374:1386 */           "Material Code", mainContent));
/* 1375:1387 */         cell39.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1376:1388 */         cell39.setBorderWidth(0.01F);
/* 1377:1389 */         cell39.setBorderColor(BaseColor.WHITE);
/* 1378:     */         
/* 1379:1391 */         PdfPCell cell40 = new PdfPCell(new Paragraph(this.resultSet.getString("PUR_WALLPAINT_MATERIAL_CODE"), mainContent));
/* 1380:1392 */         cell40.setBorderWidth(0.2F);
/* 1381:1393 */         cell40.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1382:     */         
/* 1383:     */ 
/* 1384:     */ 
/* 1385:     */ 
/* 1386:1398 */         PdfPCell cell41 = new PdfPCell(new Paragraph(
/* 1387:1399 */           "HSN Code", mainContent));
/* 1388:1400 */         cell41.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1389:1401 */         cell41.setBorderWidth(0.01F);
/* 1390:1402 */         cell41.setBorderColor(BaseColor.WHITE);
/* 1391:     */         
/* 1392:1404 */         PdfPCell cell42 = new PdfPCell(new Paragraph(this.resultSet.getString("PUR_WALLPAINT_HSN_CODE"), mainContent));
/* 1393:1405 */         cell42.setBorderWidth(0.2F);
/* 1394:1406 */         cell42.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1395:     */         
/* 1396:1408 */         PdfPCell cell43 = new PdfPCell(new Paragraph(
/* 1397:1409 */           "Delivery Place", mainContent));
/* 1398:1410 */         cell43.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1399:1411 */         cell43.setBorderWidth(0.01F);
/* 1400:1412 */         cell43.setBorderColor(BaseColor.WHITE);
/* 1401:     */         
/* 1402:1414 */         PdfPCell cell44 = new PdfPCell(new Paragraph(this.resultSet.getString("PUR_WALLPAINT_DELIVERY_PLACE"), mainContent));
/* 1403:1415 */         cell44.setBorderWidth(0.2F);
/* 1404:1416 */         cell44.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1405:     */         
/* 1406:1418 */         PdfPCell cell45 = new PdfPCell(new Paragraph(
/* 1407:1419 */           "Unit Price", mainContent));
/* 1408:1420 */         cell45.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1409:1421 */         cell45.setBorderWidth(0.01F);
/* 1410:1422 */         cell45.setBorderColor(BaseColor.WHITE);
/* 1411:     */         
/* 1412:1424 */         PdfPCell cell46 = new PdfPCell(new Paragraph(this.resultSet.getString("PUR_WALLPAINT_UNIT_PRICE"), mainContent));
/* 1413:1425 */         cell46.setBorderWidth(0.2F);
/* 1414:1426 */         cell46.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1415:     */         
/* 1416:     */ 
/* 1417:     */ 
/* 1418:     */ 
/* 1419:     */ 
/* 1420:1432 */         table.addCell(cell);
/* 1421:1433 */         table.addCell(cell1);
/* 1422:1434 */         table.addCell(cell2);
/* 1423:1435 */         table.addCell(cell3);
/* 1424:1436 */         table.addCell(cell4);
/* 1425:1437 */         table.addCell(cell5);
/* 1426:1438 */         table.addCell(cell6);
/* 1427:1439 */         table.addCell(cell7);
/* 1428:1440 */         table.addCell(cell8);
/* 1429:1441 */         table.addCell(cell9);
/* 1430:1442 */         table.addCell(cell10);
/* 1431:1443 */         table.addCell(cell11);
/* 1432:1444 */         table.addCell(cell12);
/* 1433:1445 */         table.addCell(cell13);
/* 1434:1446 */         table.addCell(cell14);
/* 1435:1447 */         table.addCell(cell15);
/* 1436:1448 */         table.addCell(cell16);
/* 1437:1449 */         table.addCell(cell17);
/* 1438:1450 */         table.addCell(cell18);
/* 1439:1451 */         table.addCell(cell19);
/* 1440:1452 */         table.addCell(cell20);
/* 1441:1453 */         table.addCell(cell21);
/* 1442:1454 */         table.addCell(cell22);
/* 1443:1455 */         table.addCell(cell23);
/* 1444:1456 */         table.addCell(cell24);
/* 1445:1457 */         table.addCell(cell25);
/* 1446:1458 */         table.addCell(cell26);
/* 1447:1459 */         table.addCell(cell27);
/* 1448:1460 */         table.addCell(cell28);
/* 1449:1461 */         table.addCell(cell29);
/* 1450:1462 */         table.addCell(cell30);
/* 1451:1463 */         table.addCell(cell31);
/* 1452:1464 */         table.addCell(cell32);
/* 1453:1465 */         table.addCell(cell33);
/* 1454:1466 */         table.addCell(cell34);
/* 1455:1467 */         table.addCell(cell35);
/* 1456:1468 */         table.addCell(cell36);
/* 1457:1469 */         table.addCell(cell37);
/* 1458:1470 */         table.addCell(cell38);
/* 1459:1471 */         table.addCell(cell39);
/* 1460:1472 */         table.addCell(cell40);
/* 1461:1473 */         table.addCell(cell41);
/* 1462:1474 */         table.addCell(cell42);
/* 1463:1475 */         table.addCell(cell43);
/* 1464:1476 */         table.addCell(cell44);
/* 1465:1477 */         table.addCell(cell45);
/* 1466:1478 */         table.addCell(cell46);
/* 1467:     */         
/* 1468:     */ 
/* 1469:     */ 
/* 1470:1482 */         document.add(table);
/* 1471:     */       }
/* 1472:1486 */       document.add(new Paragraph("\n"));
/* 1473:     */       
/* 1474:     */ 
/* 1475:     */ 
/* 1476:1490 */       document.close();
/* 1477:     */     }
/* 1478:     */     catch (SQLException sqlExp)
/* 1479:     */     {
/* 1480:1493 */       sqlExp.printStackTrace();
/* 1481:1494 */       this.logger.error(
/* 1482:1495 */         PurchaseWallPaintDaoImpl.class + 
/* 1483:1496 */         "Error: Occur in Query While Fetching All Purchase Wall Paint Details for print PdF from Database.", 
/* 1484:1497 */         sqlExp);
/* 1485:     */     }
/* 1486:     */     catch (Exception exception)
/* 1487:     */     {
/* 1488:1499 */       exception.printStackTrace();
/* 1489:1500 */       this.logger.error(
/* 1490:1501 */         PurchaseWallPaintDaoImpl.class + 
/* 1491:1502 */         "Error: Occur in Query While Closing Connection After Fetching All Purchase Wall Paint Details for print PdF from Database.", 
/* 1492:1503 */         exception);
/* 1493:     */     }
/* 1494:     */     finally
/* 1495:     */     {
/* 1496:1505 */       JdbcHelper.closeResultSet(this.resultSet);
/* 1497:1506 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/* 1498:1507 */       JdbcHelper.closeConnection(this.connection);
/* 1499:     */     }
/* 1500:     */   }
/* 1501:     */ }


/* Location:           C:\Users\bharti\Desktop\Chouksay\lost\dao\
 * Qualified Name:     com.bst.ckt.dao.PurchaseWallPaintDaoImpl
 * JD-Core Version:    0.7.0.1
 */