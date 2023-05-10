/*    1:     */ package com.bst.ckt.dao;
/*    2:     */ 
/*    3:     */ import com.bst.ckt.common.QueryBuilder;
/*    4:     */ import com.bst.ckt.dto.InvoiceSale;
/*    5:     */ import com.bst.ckt.exception.CreateFailedException;
/*    6:     */ import com.bst.ckt.exception.DeleteFailedException;
/*    7:     */ import com.bst.ckt.exception.RecordNotFoundException;
/*    8:     */ import com.bst.ckt.exception.UpdateFailedException;
/*    9:     */ import com.bst.ckt.framework.db.JdbcDAOSupport;
/*   10:     */ import com.bst.ckt.framework.db.JdbcHelper;
/*   11:     */ import com.bst.ckt.framework.util.DateTimeUtil;
/*   12:     */ import com.bst.ckt.framework.util.IDGenerator;
/*   13:     */ import com.bst.ckt.helper.NameHelper;
/*   14:     */ import com.bst.ckt.vo.InvoiceSaleVO;
/*   15:     */ import com.itextpdf.text.BaseColor;
/*   16:     */ import com.itextpdf.text.Document;
/*   17:     */ import com.itextpdf.text.Font;
/*   18:     */ import com.itextpdf.text.Font.FontFamily;
/*   19:     */ import com.itextpdf.text.Image;
/*   20:     */ import com.itextpdf.text.PageSize;
/*   21:     */ import com.itextpdf.text.Paragraph;
/*   22:     */ import com.itextpdf.text.Phrase;
/*   23:     */ import com.itextpdf.text.Rectangle;
/*   24:     */ import com.itextpdf.text.pdf.ColumnText;
/*   25:     */ import com.itextpdf.text.pdf.PdfContentByte;
/*   26:     */ import com.itextpdf.text.pdf.PdfPCell;
/*   27:     */ import com.itextpdf.text.pdf.PdfPTable;
/*   28:     */ import com.itextpdf.text.pdf.PdfWriter;
/*   29:     */ import java.io.PrintStream;
/*   30:     */ import java.sql.Connection;
/*   31:     */ import java.sql.PreparedStatement;
/*   32:     */ import java.sql.ResultSet;
/*   33:     */ import java.sql.SQLException;
/*   34:     */ import java.text.DecimalFormat;
/*   35:     */ import java.util.ArrayList;
/*   36:     */ import java.util.List;
/*   37:     */ import javax.servlet.ServletContext;
/*   38:     */ import javax.servlet.ServletOutputStream;
/*   39:     */ import javax.servlet.http.HttpServletRequest;
/*   40:     */ import javax.servlet.http.HttpServletResponse;
/*   41:     */ import org.apache.log4j.Logger;
/*   42:     */ import org.apache.struts2.ServletActionContext;
/*   43:     */ import org.json.simple.JSONArray;
/*   44:     */ import org.json.simple.JSONObject;
/*   45:     */ 
/*   46:     */ public class InvoiceSaleDaoImpl
/*   47:     */   extends JdbcDAOSupport
/*   48:     */   implements InvoiceSaleDaoInf
/*   49:     */ {
/*   50:  57 */   Logger logger = Logger.getLogger(InvoiceSaleDaoImpl.class);
/*   51:  58 */   Connection connection = null;
/*   52:  59 */   PreparedStatement preparedStatement = null;
/*   53:  60 */   ResultSet resultSet = null;
/*   54:  61 */   NameHelper nameHelper = new NameHelper();
/*   55:  62 */   InvoiceSaleVO saleVO = null;
/*   56:  63 */   Image image = null;
/*   57:     */   
/*   58:     */   public int addSalesDetails(InvoiceSaleVO invoiceSaleVO)
/*   59:     */     throws CreateFailedException
/*   60:     */   {
/*   61: 138 */     int count = 0;
/*   62:     */     try
/*   63:     */     {
/*   64: 141 */       System.out.println("%%%%%%%%%%dao");
/*   65:     */       
/*   66:     */ 
/*   67:     */ 
/*   68:     */ 
/*   69:     */ 
/*   70:     */ 
/*   71:     */ 
/*   72:     */ 
/*   73:     */ 
/*   74:     */ 
/*   75:     */ 
/*   76:     */ 
/*   77:     */ 
/*   78:     */ 
/*   79:     */ 
/*   80:     */ 
/*   81:     */ 
/*   82:     */ 
/*   83:     */ 
/*   84:     */ 
/*   85:     */ 
/*   86:     */ 
/*   87:     */ 
/*   88:     */ 
/*   89:     */ 
/*   90:     */ 
/*   91:     */ 
/*   92:     */ 
/*   93:     */ 
/*   94:     */ 
/*   95:     */ 
/*   96:     */ 
/*   97:     */ 
/*   98:     */ 
/*   99:     */ 
/*  100: 177 */       String query = "INSERT INTO TAB_SALES_DETAILS(SALES_DATE, SALES_CUSTOMER_ID_REF,SALES_CUSTOMER_PHONE,SALES_CUSTOMER_ADREESS, SALES_ITEM_SUBTOTAL, SALES_ITEM_TOTAL, SALES_ITEM_DISCOUNT, SALES_ITEM_NET_TOTAL,UNIQUE_ID,SALES_CUSTOMER_TYPE,SALES_PAYMENT,SALES_PAYMENT_MODE, SALES_PAYMENT_ANSWER,SALES_TAX_AMOUNT, TRANSPORT_CHARGES, SALES_ITEM_AMOUNT)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
/*  101: 178 */       float netTotal_sale = invoiceSaleVO.getNetTotal();
/*  102: 179 */       float payment = invoiceSaleVO.getPayment();
/*  103: 180 */       float finalAmount = invoiceSaleVO.getNetTotal() + invoiceSaleVO.getTotalTax();
/*  104: 181 */       String paymentMode = invoiceSaleVO.getPaymentMode();
/*  105: 182 */       String customerType = invoiceSaleVO.getCustomerType();
/*  106:     */       
/*  107:     */ 
/*  108: 185 */       String uniqueId = IDGenerator.generateAlphaNumericID(27);
/*  109:     */       
/*  110:     */ 
/*  111:     */ 
/*  112:     */ 
/*  113:     */ 
/*  114: 191 */       System.out.println("uniqueId" + uniqueId);
/*  115: 192 */       this.connection = getConnection();
/*  116: 193 */       this.preparedStatement = this.connection.prepareStatement(query);
/*  117: 194 */       System.out.println(invoiceSaleVO.getItemTax() + "&&&&&&&&&&&&&"+customerType);
/*  118:     */       String dateOfTransaction;
/*  119:     */       int custId;
/*  120: 195 */       if (customerType.equals("Retailer"))
/*  121:     */       {
/*  122: 197 */          dateOfTransaction = invoiceSaleVO.getSalesDate();
/*  123: 198 */          custId = invoiceSaleVO.getCustomerId();
/*  124:     */         
/*  125: 200 */         this.preparedStatement.setString(1, invoiceSaleVO.getSalesDate());
/*  126: 201 */         this.preparedStatement.setInt(2, invoiceSaleVO.getCustomerId());
/*  127: 202 */         this.preparedStatement.setString(3, invoiceSaleVO.getPhoneNo());
/*  128: 203 */         this.preparedStatement.setString(4, invoiceSaleVO.getAddress());
/*  129:     */       }
/*  130:     */       else
/*  131:     */       {
/*  132: 205 */         dateOfTransaction = invoiceSaleVO.getSalesDateConsumer();
/*  133: 206 */         custId = invoiceSaleVO.getCustomerIdConsumer();
/*  134:     */         
/*  135: 208 */         this.preparedStatement.setString(1, invoiceSaleVO.getSalesDateConsumer());
/*  136: 209 */         this.preparedStatement.setInt(2, invoiceSaleVO.getCustomerIdConsumer());
/*  137: 210 */         this.preparedStatement.setString(3, invoiceSaleVO.getPhoneNoConsumer());
/*  138: 211 */         this.preparedStatement.setString(4, invoiceSaleVO.getAddressConsumer());
/*  139:     */       }
/*  140: 213 */       this.preparedStatement.setFloat(5, invoiceSaleVO.getSubTotal());
/*  141:     */       
/*  142: 215 */       this.preparedStatement.setFloat(6, invoiceSaleVO.getTotal());
/*  143: 216 */       this.preparedStatement.setFloat(7, invoiceSaleVO.getDiscount());
/*  144:     */       
/*  145:     */ 
/*  146: 219 */       this.preparedStatement.setFloat(8, invoiceSaleVO.getNetTotal());
/*  147: 220 */       this.preparedStatement.setString(9, uniqueId);
/*  148: 221 */       this.preparedStatement.setString(10, invoiceSaleVO.getCustomerType());
/*  149: 222 */       this.preparedStatement.setFloat(11, invoiceSaleVO.getPayment());
/*  150: 223 */       this.preparedStatement.setString(12, invoiceSaleVO.getPaymentMode());
/*  151: 224 */       this.preparedStatement.setString(13, invoiceSaleVO.getPaymentAnswer());
/*  152: 225 */       this.preparedStatement.setFloat(14, invoiceSaleVO.getTotalTax());
/*  153: 226 */       this.preparedStatement.setFloat(15, invoiceSaleVO.getTranspportCharges());
/*  154: 227 */       this.preparedStatement.setFloat(16, finalAmount);
/*  155:     */       
/*  156:     */ 
/*  157:     */ 
/*  158:     */ 
this.preparedStatement.executeUpdate();


/*  160: 233 */       int salesID = getSalesId(uniqueId);
/*  161: 234 */       System.out.println("estmID" + salesID);
/*  162: 235 */       String[] a = invoiceSaleVO.getItemId().split(",");
/*  163: 236 */       System.out.println(invoiceSaleVO.getItemId() + " " + invoiceSaleVO.getItemDescription() + " " + invoiceSaleVO.getItemQuantity());
/*  164: 237 */       String[] b = invoiceSaleVO.getItemDescription().split(",");
/*  165: 238 */       String[] c = invoiceSaleVO.getItemQuantity().split(",");
/*  166: 239 */       String[] d = invoiceSaleVO.getItemPrice().split(",");
/*  167:     */       
/*  168: 241 */       String[] e = invoiceSaleVO.getItemTax().split(",");
/*  169: 242 */       String[] f = invoiceSaleVO.getAmount().split(",");
/*  170: 243 */       System.out.println("a" + a + "b" + b + " (((())))");
/*  171: 244 */       System.out.println("netTotal_sale" + netTotal_sale + "payment" + payment + "customerType" + customerType + "paymentMode" + paymentMode + "dateOfTransaction" + dateOfTransaction);
/*  172: 245 */       addSalesItems(a, b, c, d, e, f, salesID, invoiceSaleVO.getAclId(), invoiceSaleVO.getUserRole());
/*  173: 246 */       insertIntoCustomerTansaction(netTotal_sale, uniqueId, payment, customerType, salesID, paymentMode, dateOfTransaction, custId, invoiceSaleVO.getAclId(), invoiceSaleVO.getUserRole());
/*  174: 247 */

count=getNameForBillGeneration(a[0]) ;     
System.out.println(a.length + "OOOOOOOO Length" + invoiceSaleVO.getAclId() + "hahaha" + payment+"count"+count);
/*  175: 250 */       for (int i = 0; i < a.length; i++)
/*  176:     */       {
/*  177: 252 */         System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&" + a[i]);
/*  178: 253 */         manageStockAfterSale(c[i], a[i].trim(), invoiceSaleVO.getAclId(), invoiceSaleVO.getUserRole());
/*  179:     */         
/*  180: 255 */         System.out.println(c[i] + "SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSsss" + a[i] + "oooooooooo" + i);
/*  181:     */       }
/*  182:     */     }
/*  183:     */     catch (NumberFormatException exception)
/*  184:     */     {
/*  185: 265 */       this.logger.error(InvoiceSaleDaoImpl.class + 
/*  186: 266 */         ": Error:- While inserting Sales details into Database." + exception);
/*  187:     */       try
/*  188:     */       {
/*  189: 274 */         if (this.connection != null)
/*  190:     */         {
/*  191: 275 */           this.preparedStatement.close();
/*  192: 276 */           this.connection.close();
/*  193:     */         }
/*  194:     */       }
/*  195:     */       catch (SQLException sqlExp)
/*  196:     */       {
/*  197: 279 */         this.logger.error(InvoiceSaleDaoImpl.class + 
/*  198: 280 */           ": Error:- While closing the Connection after inserting sales details into Database." + sqlExp);
/*  199:     */       }
/*  200:     */     }
/*  201:     */     catch (Exception exception)
/*  202:     */     {
/*  203: 270 */       this.logger.error(InvoiceSaleDaoImpl.class + 
/*  204: 271 */         ": Error:- While inserting Sales details into Database." + exception);
exception.printStackTrace();
/*  205:     */       try
/*  206:     */       {
/*  207: 274 */         if (this.connection != null)
/*  208:     */         {
/*  209: 275 */           this.preparedStatement.close();
/*  210: 276 */           this.connection.close();
/*  211:     */         }
/*  212:     */       }
/*  213:     */       catch (SQLException sqlExp)
/*  214:     */       {
/*  215: 279 */         this.logger.error(InvoiceSaleDaoImpl.class + 
/*  216: 280 */           ": Error:- While closing the Connection after inserting sales details into Database." + sqlExp);
/*  217:     */       }
/*  218:     */     }
/*  219:     */     finally
/*  220:     */     {
/*  221:     */       try
/*  222:     */       {
/*  223: 274 */         if (this.connection != null)
/*  224:     */         {
/*  225: 275 */           this.preparedStatement.close();
/*  226: 276 */           this.connection.close();
/*  227:     */         }
/*  228:     */       }
/*  229:     */       catch (SQLException sqlExp)
/*  230:     */       {
/*  231: 279 */         this.logger.error(InvoiceSaleDaoImpl.class + 
/*  232: 280 */           ": Error:- While closing the Connection after inserting sales details into Database." + sqlExp);
/*  233:     */       }
/*  234:     */     }
/*  235: 284 */     return count;
/*  236:     */   }

/*  237:     */   
/*  238:     */   private String checkProductCategory(String itemId)
/*  239:     */   {
/*  240: 294 */     String name = null;
/*  241: 295 */     System.out.println("item id" + itemId);
/*  242:     */     try
/*  243:     */     {
/*  244: 297 */       int id = Integer.parseInt(itemId);
/*  245: 298 */       System.out.println("IIIIIIIIIII " + id);
/*  246: 299 */       this.connection = getConnection();
/*  247: 300 */       this.preparedStatement = this.connection
/*  248: 301 */         .prepareStatement("SELECT PRODUCT_NAME FROM TAB_PRODUCT_DETAILS WHERE PRODUCT_ID=?");
/*  249: 302 */       this.preparedStatement.setInt(1, id);
/*  250: 303 */       this.resultSet = this.preparedStatement.executeQuery();
/*  251: 307 */       while (this.resultSet.next())
/*  252:     */       {
/*  253: 308 */         name = this.nameHelper.getProductCategory(this.resultSet.getInt("PRODUCT_NAME"));
/*  254: 309 */         System.out.println("category" + name + "id" + id);
/*  255:     */       }
/*  256:     */     }
/*  257:     */     catch (NumberFormatException exception)
/*  258:     */     {
/*  259: 313 */       this.logger.error(InvoiceSaleDaoImpl.class + 
/*  260: 314 */         ": Error:- While inserting Sales details into Database." + exception);
/*  261:     */     }
/*  262:     */     catch (SQLException sqlExp)
/*  263:     */     {
/*  264: 318 */       sqlExp.printStackTrace();
/*  265: 319 */       this.logger.error(
/*  266: 320 */         InvoiceSaleDaoImpl.class + 
/*  267: 321 */         "Error: Occur in Query While Fetching the item category details from Database.", 
/*  268: 322 */         sqlExp);
/*  269:     */     }
/*  270:     */     catch (Exception exception)
/*  271:     */     {
/*  272: 324 */       exception.printStackTrace();
/*  273: 325 */       this.logger.error(
/*  274: 326 */         InvoiceSaleDaoImpl.class + 
/*  275: 327 */         "Error: Occur in Query While Closing Connection After Fetching the item category details from Database.", 
/*  276: 328 */         exception);
/*  277:     */     }
/*  278:     */     finally
/*  279:     */     {
/*  280: 330 */       JdbcHelper.closeResultSet(this.resultSet);
/*  281: 331 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/*  282: 332 */       JdbcHelper.closeConnection(this.connection);
/*  283:     */     }
/*  284: 334 */     return name;
/*  285:     */   }
/*  286:     */   
/*  287:     */   private void manageStockAfterSale(String c, String a, int shopId, int i)
/*  288:     */   {
/*  289: 340 */     int itemId = Integer.parseInt(a);
/*  290: 341 */     float noOfBags = 0.0F;
/*  291: 342 */     System.out.println("GDDDDDDDDDDD itemId " + itemId + " C " + c);
/*  292:     */     try
/*  293:     */     {
/*  294: 344 */       this.connection = getConnection();
/*  295:     */       
/*  296: 346 */       this.preparedStatement = this.connection.prepareStatement("SELECT STOCK_BAGS_NO FROM TAB_STOCK_DETAILS WHERE STOCK_PRODUCT_TYPE=?");
/*  297: 347 */       this.preparedStatement.setInt(1, itemId);
/*  298:     */       
/*  299:     */ 
/*  300:     */ 
/*  301:     */ 
/*  302:     */ 
/*  303:     */ 
/*  304: 354 */       this.resultSet = this.preparedStatement.executeQuery();
/*  305: 356 */       while (this.resultSet.next())
/*  306:     */       {
/*  307: 357 */         noOfBags = this.resultSet.getInt("STOCK_BAGS_NO");
/*  308: 358 */         System.out.println(noOfBags + "noOfBags");
/*  309:     */       }
/*  310: 362 */       float leftBags = noOfBags - Float.parseFloat(c);
/*  311: 363 */       if (leftBags > 0.0F) {
/*  312: 364 */         deductQuantityToManageStock(leftBags, itemId, shopId, i);
/*  313: 365 */       } else if (leftBags == 0.0F) {
/*  314: 366 */         deleteStockAfterSale(itemId);
/*  315:     */       }
/*  316:     */     }
/*  317:     */     catch (NumberFormatException exception)
/*  318:     */     {
/*  319: 371 */       this.logger.error(InvoiceSaleDaoImpl.class + 
/*  320: 372 */         ": Error:- While inserting Sales details into Database." + exception);
/*  321:     */     }
/*  322:     */     catch (SQLException sqlException)
/*  323:     */     {
/*  324: 376 */       sqlException.printStackTrace();
/*  325: 377 */       this.logger.error(
/*  326: 378 */         InvoiceSaleDaoImpl.class + 
/*  327: 379 */         ": Error:- Error: Occur in Query While deleting the sales details record", 
/*  328: 380 */         sqlException);
/*  329:     */     }
/*  330:     */     catch (Exception exception)
/*  331:     */     {
/*  332: 382 */       exception.printStackTrace();
/*  333: 383 */       this.logger.error(
/*  334: 384 */         InvoiceSaleDaoImpl.class + 
/*  335: 385 */         ": Error:- While closing the Connection after deleting the sales details reccord", 
/*  336: 386 */         exception);
/*  337:     */     }
/*  338:     */     finally
/*  339:     */     {
/*  340: 389 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/*  341: 390 */       JdbcHelper.closeConnection(this.connection);
/*  342:     */     }
/*  343:     */   }
/*  344:     */   
/*  345:     */   private void deleteStockAfterSale(int itemId)
/*  346:     */   {
/*  347:     */     try
/*  348:     */     {
/*  349: 400 */       this.connection = getConnection();
/*  350:     */       
/*  351: 402 */       this.preparedStatement = this.connection.prepareStatement("DELETE FROM TAB_STOCK_DETAILS WHERE STOCK_PRODUCT_TYPE=?");
/*  352:     */       
/*  353: 404 */       this.preparedStatement.setInt(1, itemId);
/*  354:     */       
/*  355: 406 */       this.preparedStatement.executeUpdate();
/*  356:     */     }
/*  357:     */     catch (SQLException sqlException)
/*  358:     */     {
/*  359: 409 */       sqlException.printStackTrace();
/*  360: 410 */       this.logger.error(
/*  361: 411 */         InvoiceSaleDaoImpl.class + 
/*  362: 412 */         ": Error:- Error: Occur in Query While deleting the stock details record", 
/*  363: 413 */         sqlException);
/*  364:     */     }
/*  365:     */     catch (Exception exception)
/*  366:     */     {
/*  367: 415 */       exception.printStackTrace();
/*  368: 416 */       this.logger.error(
/*  369: 417 */         InvoiceSaleDaoImpl.class + 
/*  370: 418 */         ": Error:- While closing the Connection after deleting the stock details reccord", 
/*  371: 419 */         exception);
/*  372:     */     }
/*  373:     */     finally
/*  374:     */     {
/*  375: 422 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/*  376: 423 */       JdbcHelper.closeConnection(this.connection);
/*  377:     */     }
/*  378:     */   }
/*  379:     */   
/*  380:     */   private void deductQuantityToManageStock(float leftBags, int itemId, int shopId, int i)
/*  381:     */   {
/*  382: 477 */     System.out.println(itemId + "IIIIIIIIIIIIIIIIIIIIIIIIIIIOOOOOOOOOOOOOOOOOOOO");
/*  383: 478 */     String query = "UPDATE  TAB_STOCK_DETAILS SET STOCK_BAGS_NO=? WHERE STOCK_PRODUCT_TYPE=?";
/*  384: 479 */     PreparedStatement preparedStatements = null;
/*  385:     */     try
/*  386:     */     {
/*  387: 481 */       this.connection = getConnection();
/*  388: 482 */       preparedStatements = this.connection.prepareStatement(query);
/*  389: 483 */       preparedStatements.setFloat(1, leftBags);
/*  390: 484 */       preparedStatements.setInt(2, itemId);
/*  391:     */       
/*  392: 486 */       System.out.println("leftBags" + leftBags + "itemId" + itemId + "shopId" + shopId);
/*  393: 487 */       preparedStatements.executeUpdate();
/*  394:     */     }
/*  395:     */     catch (SQLException sqlExp)
/*  396:     */     {
/*  397: 489 */       sqlExp.printStackTrace();
/*  398: 490 */       this.logger.error(
/*  399: 491 */         InvoiceSaleDaoImpl.class + 
/*  400: 492 */         "Error: Occur in Query While updating stock Details .", 
/*  401: 493 */         sqlExp);
/*  402:     */     }
/*  403:     */     catch (Exception exception)
/*  404:     */     {
/*  405: 495 */       exception.printStackTrace();
/*  406: 496 */       this.logger.error(
/*  407: 497 */         InvoiceSaleDaoImpl.class + 
/*  408: 498 */         "Error:: Occur in Query While updating stock Details .", 
/*  409: 499 */         exception);
/*  410:     */     }
/*  411:     */     finally
/*  412:     */     {
/*  413: 502 */       JdbcHelper.closePreparedStatement(preparedStatements);
/*  414: 503 */       JdbcHelper.closeConnection(this.connection);
/*  415:     */     }
/*  416:     */   }
/*  417:     */   
/*  418:     */   public List<InvoiceSaleVO> getSalesDetails(InvoiceSaleVO invoiceSaleVO)
/*  419:     */     throws RecordNotFoundException
/*  420:     */   {
/*  421: 513 */     List<InvoiceSaleVO> salesDetailList = new ArrayList();
/*  422:     */     try
/*  423:     */     {
/*  424: 517 */       this.connection = getConnection();
/*  425:     */       
/*  426:     */ 
/*  427: 520 */       this.preparedStatement = this.connection
/*  428: 521 */         .prepareStatement("SELECT * FROM TAB_SALES_DETAILS");
/*  429:     */       
/*  430:     */ 
/*  431: 524 */       this.resultSet = this.preparedStatement.executeQuery();
/*  432: 528 */       while (this.resultSet.next())
/*  433:     */       {
/*  434: 529 */         invoiceSaleVO = new InvoiceSaleVO();
/*  435: 530 */         invoiceSaleVO.setSalesId(this.resultSet.getInt("SALES_ID"));
/*  436: 531 */         if (this.resultSet.getString("SALES_CUSTOMER_TYPE").equals("Retailer"))
/*  437:     */         {
/*  438: 532 */           invoiceSaleVO.setFullName(this.nameHelper.getRegularCustomerNameById(this.resultSet.getInt("SALES_CUSTOMER_ID_REF")));
/*  439: 533 */           invoiceSaleVO.setCustomerId(this.resultSet.getInt("SALES_CUSTOMER_ID_REF"));
/*  440: 534 */           invoiceSaleVO.setPhoneNo(this.resultSet.getString("SALES_CUSTOMER_PHONE"));
/*  441:     */           
/*  442: 536 */           invoiceSaleVO.setAddress(this.resultSet
/*  443: 537 */             .getString("SALES_CUSTOMER_ADREESS"));
/*  444:     */         }
/*  445: 538 */         else if (this.resultSet.getString("SALES_CUSTOMER_TYPE").equals("Consumer"))
/*  446:     */         {
/*  447: 539 */           invoiceSaleVO.setFullName(this.nameHelper.getConsumerCustomerNameById(this.resultSet.getInt("SALES_CUSTOMER_ID_REF")));
/*  448: 540 */           invoiceSaleVO.setCustomerId(this.resultSet.getInt("SALES_CUSTOMER_ID_REF"));
/*  449: 541 */           invoiceSaleVO.setPhoneNo(this.resultSet.getString("SALES_CUSTOMER_PHONE"));
/*  450:     */           
/*  451: 543 */           invoiceSaleVO.setAddress(this.resultSet
/*  452: 544 */             .getString("SALES_CUSTOMER_ADREESS"));
/*  453:     */         }
/*  454: 546 */         invoiceSaleVO.setItemPrice(this.resultSet
/*  455: 547 */           .getString("SALES_ITEM_PRICE"));
/*  456:     */         
/*  457: 549 */         invoiceSaleVO.setCustomerType(this.resultSet
/*  458: 550 */           .getString("SALES_CUSTOMER_TYPE"));
/*  459:     */         
/*  460: 552 */         invoiceSaleVO.setTotal(this.resultSet
/*  461: 553 */           .getFloat("SALES_ITEM_TOTAL"));
/*  462:     */         
/*  463:     */ 
/*  464: 556 */         invoiceSaleVO.setSubTotal(this.resultSet
/*  465: 557 */           .getFloat("SALES_ITEM_SUBTOTAL"));
/*  466:     */         
/*  467: 559 */         invoiceSaleVO.setPaymentMode(this.nameHelper.getPaymentModeById(this.resultSet
/*  468: 560 */           .getInt("SALES_PAYMENT_MODE")));
/*  469: 561 */         invoiceSaleVO.setPaymentAnswer(this.resultSet.getString("SALES_PAYMENT_ANSWER"));
/*  470:     */         
/*  471: 563 */         invoiceSaleVO.setDiscount(this.resultSet
/*  472: 564 */           .getFloat("SALES_ITEM_DISCOUNT"));
/*  473:     */         
/*  474: 566 */         invoiceSaleVO.setNetTotal(this.resultSet
/*  475: 567 */           .getFloat("SALES_ITEM_NET_TOTAL"));
/*  476:     */         
/*  477: 569 */         invoiceSaleVO.setItemName(this.nameHelper.getProductNameById(this.resultSet
/*  478: 570 */           .getInt("SALES_ITEM_ID")));
/*  479:     */         
/*  480:     */ 
/*  481: 573 */         invoiceSaleVO.setItemQuantity(this.resultSet
/*  482: 574 */           .getString("SALES_ITEM_QUANTITY"));
/*  483: 575 */         invoiceSaleVO.setItemTax(this.resultSet
/*  484: 576 */           .getString("SALES_ITEM_TAX"));
/*  485: 577 */         invoiceSaleVO.setAmount(this.resultSet
/*  486: 578 */           .getString("SALES_ITEM_AMOUNT"));
/*  487: 579 */         invoiceSaleVO.setSalesDate(this.resultSet
/*  488: 580 */           .getString("SALES_DATE"));
/*  489: 581 */         salesDetailList.add(invoiceSaleVO);
/*  490:     */       }
/*  491:     */     }
/*  492:     */     catch (SQLException sqlExp)
/*  493:     */     {
/*  494: 585 */       sqlExp.printStackTrace();
/*  495: 586 */       this.logger.error(
/*  496: 587 */         InvoiceSaleDaoImpl.class + 
/*  497: 588 */         "Error: Occur in Query While Fetching the sales Details into Grid from Database.", 
/*  498: 589 */         sqlExp);
/*  499:     */     }
/*  500:     */     catch (Exception exception)
/*  501:     */     {
/*  502: 591 */       exception.printStackTrace();
/*  503: 592 */       this.logger.error(
/*  504: 593 */         InvoiceSaleDaoImpl.class + 
/*  505: 594 */         "Error: Occur in Query While Closing Connection After Fetching the sales Details into Grid from Database.", 
/*  506: 595 */         exception);
/*  507:     */     }
/*  508:     */     finally
/*  509:     */     {
/*  510: 597 */       JdbcHelper.closeResultSet(this.resultSet);
/*  511: 598 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/*  512: 599 */       JdbcHelper.closeConnection(this.connection);
/*  513:     */     }
/*  514: 601 */     return salesDetailList;
/*  515:     */   }
/*  516:     */   
/*  517:     */   public JSONObject productListJSON()
/*  518:     */     throws RecordNotFoundException
/*  519:     */   {
/*  520: 608 */     JSONObject productList = null;
/*  521:     */     try
/*  522:     */     {
/*  523: 611 */       String query = "SELECT  PRODUCT_ID,PRODUCT_NAME FROM TAB_PRODUCT_DETAILS";
/*  524: 612 */       this.connection = getConnection();
/*  525: 613 */       this.preparedStatement = this.connection.prepareStatement(query);
/*  526: 614 */       this.resultSet = this.preparedStatement.executeQuery();
/*  527: 615 */       JSONArray array = new JSONArray();
/*  528: 616 */       productList = new JSONObject();
/*  529: 618 */       while (this.resultSet.next())
/*  530:     */       {
/*  531: 619 */         JSONObject object = new JSONObject();
/*  532:     */         
/*  533: 621 */         int productID = this.resultSet.getInt("PRODUCT_ID");
/*  534: 622 */         String productName = this.nameHelper.getProductTypeNameByProductId(this.resultSet
/*  535: 623 */           .getInt("PRODUCT_NAME"));
/*  536: 624 */         object.put("productID", Integer.valueOf(productID));
/*  537: 625 */         object.put("productName", productName);
/*  538: 626 */         array.add(object);
/*  539:     */       }
/*  540: 628 */       productList.put("Product", array);
/*  541:     */     }
/*  542:     */     catch (Exception exception)
/*  543:     */     {
/*  544: 631 */       this.logger.error(InvoiceSaleDaoImpl.class + 
/*  545: 632 */         ": Error:- While getting Product id and Product name From Database.");
/*  546:     */       try
/*  547:     */       {
/*  548: 635 */         if (this.connection != null)
/*  549:     */         {
/*  550: 636 */           this.resultSet.close();
/*  551: 637 */           this.preparedStatement.close();
/*  552: 638 */           this.connection.close();
/*  553:     */         }
/*  554:     */       }
/*  555:     */       catch (SQLException sqlExp)
/*  556:     */       {
/*  557: 641 */         this.logger.error(InvoiceSaleDaoImpl.class + 
/*  558: 642 */           ": Error:- While closing the Connection after getting Product id and Product name From Database.");
/*  559:     */       }
/*  560:     */     }
/*  561:     */     finally
/*  562:     */     {
/*  563:     */       try
/*  564:     */       {
/*  565: 635 */         if (this.connection != null)
/*  566:     */         {
/*  567: 636 */           this.resultSet.close();
/*  568: 637 */           this.preparedStatement.close();
/*  569: 638 */           this.connection.close();
/*  570:     */         }
/*  571:     */       }
/*  572:     */       catch (SQLException sqlExp)
/*  573:     */       {
/*  574: 641 */         this.logger.error(InvoiceSaleDaoImpl.class + 
/*  575: 642 */           ": Error:- While closing the Connection after getting Product id and Product name From Database.");
/*  576:     */       }
/*  577:     */     }
/*  578: 645 */     return productList;
/*  579:     */   }
/*  580:     */   
/*  581:     */   public JSONObject taxListJSON()
/*  582:     */     throws RecordNotFoundException
/*  583:     */   {
/*  584: 651 */     JSONObject taxList = null;
/*  585:     */     try
/*  586:     */     {
/*  587: 653 */       String query = "SELECT TAX_ID,TAX_TOTAL,TAX_DISPLAY_NAME FROM TAB_TAX";
/*  588: 654 */       this.connection = getConnection();
/*  589: 655 */       this.preparedStatement = this.connection.prepareStatement(query);
/*  590: 656 */       this.resultSet = this.preparedStatement.executeQuery();
/*  591: 657 */       JSONArray array = new JSONArray();
/*  592: 658 */       taxList = new JSONObject();
/*  593: 660 */       while (this.resultSet.next())
/*  594:     */       {
/*  595: 661 */         JSONObject object = new JSONObject();
/*  596:     */         
/*  597: 663 */         float totalTax = this.resultSet.getFloat("TAX_ID");
/*  598: 664 */         float totalTaxId = this.resultSet.getFloat("TAX_TOTAL");
/*  599: 665 */         String taxdisplayName = this.resultSet.getString("TAX_DISPLAY_NAME");
/*  600: 666 */         object.put("totalTax", Float.valueOf(totalTax));
/*  601: 667 */         object.put("taxdisplayName", Float.valueOf(totalTaxId));
/*  602: 668 */         array.add(object);
/*  603:     */       }
/*  604: 670 */       taxList.put("Tax", array);
/*  605:     */     }
/*  606:     */     catch (Exception exception)
/*  607:     */     {
/*  608: 673 */       this.logger.error(InvoiceSaleDaoImpl.class + 
/*  609: 674 */         ": Error:- While getting Tax display name and Total Tax name From Database.");
/*  610:     */       try
/*  611:     */       {
/*  612: 677 */         if (this.connection != null)
/*  613:     */         {
/*  614: 678 */           this.resultSet.close();
/*  615: 679 */           this.preparedStatement.close();
/*  616: 680 */           this.connection.close();
/*  617:     */         }
/*  618:     */       }
/*  619:     */       catch (SQLException sqlExp)
/*  620:     */       {
/*  621: 683 */         this.logger.error(InvoiceSaleDaoImpl.class + 
/*  622: 684 */           ": Error:- While closing the Connection after getting Tax display name and Total tax From Database.");
/*  623:     */       }
/*  624:     */     }
/*  625:     */     finally
/*  626:     */     {
/*  627:     */       try
/*  628:     */       {
/*  629: 677 */         if (this.connection != null)
/*  630:     */         {
/*  631: 678 */           this.resultSet.close();
/*  632: 679 */           this.preparedStatement.close();
/*  633: 680 */           this.connection.close();
/*  634:     */         }
/*  635:     */       }
/*  636:     */       catch (SQLException sqlExp)
/*  637:     */       {
/*  638: 683 */         this.logger.error(InvoiceSaleDaoImpl.class + 
/*  639: 684 */           ": Error:- While closing the Connection after getting Tax display name and Total tax From Database.");
/*  640:     */       }
/*  641:     */     }
/*  642: 687 */     return taxList;
/*  643:     */   }
/*  644:     */   
/*  645:     */   public InvoiceSale retriveSpecificSalesDetail(int salesId)
/*  646:     */     throws RecordNotFoundException
/*  647:     */   {
/*  648: 694 */     InvoiceSale invoiceSale = new InvoiceSale();
/*  649:     */     try
/*  650:     */     {
/*  651: 697 */       this.connection = getConnection();
/*  652:     */       
/*  653: 699 */       this.preparedStatement = this.connection
/*  654: 700 */         .prepareStatement("SELECT * FROM TAB_SALES_DETAILS WHERE SALES_ID=?");
/*  655: 701 */       this.preparedStatement.setInt(1, salesId);
/*  656:     */       
/*  657:     */ 
/*  658: 704 */       this.resultSet = this.preparedStatement.executeQuery();
/*  659: 705 */       System.out.println("----------hye ----------------");
/*  660: 706 */       if (this.resultSet != null) {
/*  661: 707 */         while (this.resultSet.next())
/*  662:     */         {
/*  663: 709 */           System.out.println("----------hye ----------------");
/*  664:     */           
/*  665: 711 */           invoiceSale.setSalesId(this.resultSet.getInt("SALES_ID"));
/*  666: 712 */           System.out.println("________________" + this.resultSet.getInt("SALES_ID"));
/*  667: 713 */           invoiceSale.setCustomerType(this.resultSet.getString("SALES_CUSTOMER_TYPE"));
/*  668: 714 */           if (this.resultSet.getString("SALES_CUSTOMER_TYPE").equals("Retailer")) {
/*  669: 715 */             invoiceSale.setFullName(this.nameHelper.getRegularCustomerNameById(this.resultSet.getInt("SALES_CUSTOMER_ID_REF")));
/*  670:     */           } else {
/*  671: 717 */             invoiceSale.setFullName(this.nameHelper.getConsumerCustomerNameById(this.resultSet.getInt("SALES_CUSTOMER_ID_REF")));
/*  672:     */           }
/*  673: 720 */           System.out.println("---------" + this.resultSet.getString("SALES_CUSTOMER_FULLNAME"));
/*  674:     */           
/*  675: 722 */           invoiceSale.setCustomerId(this.resultSet
/*  676: 723 */             .getInt("SALES_CUSTOMER_ID_REF"));
/*  677:     */           
/*  678:     */ 
/*  679: 726 */           invoiceSale.setPhoneNo(this.resultSet
/*  680: 727 */             .getString("SALES_CUSTOMER_PHONE"));
/*  681:     */           
/*  682: 729 */           invoiceSale.setAddress(this.resultSet
/*  683: 730 */             .getString("SALES_CUSTOMER_ADREESS"));
/*  684:     */           
/*  685: 732 */           invoiceSale.setSalesDate(this.resultSet
/*  686: 733 */             .getString("SALES_DATE"));
/*  687:     */           
/*  688: 735 */           invoiceSale.setTotalTax(this.resultSet
/*  689: 736 */             .getFloat("SALES_TAX_AMOUNT"));
/*  690:     */           
/*  691: 738 */           invoiceSale.setPayment(this.resultSet.getFloat("SALES_PAYMENT"));
/*  692:     */           
/*  693: 740 */           invoiceSale.setPaymentMode(this.nameHelper.getPaymentModeById(this.resultSet.getInt("SALES_PAYMENT_MODE")));
/*  694:     */           
/*  695: 742 */           invoiceSale.setPaymentAnswer(this.resultSet.getString("SALES_PAYMENT_ANSWER"));
/*  696:     */           
/*  697: 744 */           invoiceSale.setWorkLocation(this.resultSet.getString("UNIQUE_ID"));
/*  698:     */           
/*  699:     */ 
/*  700:     */ 
/*  701:     */ 
/*  702: 749 */           invoiceSale.setSubTotal(this.resultSet
/*  703: 750 */             .getFloat("SALES_ITEM_SUBTOTAL"));
/*  704:     */           
/*  705:     */ 
/*  706:     */ 
/*  707: 754 */           invoiceSale.setTotal(this.resultSet
/*  708: 755 */             .getFloat("SALES_ITEM_TOTAL"));
/*  709: 756 */           invoiceSale.setDiscount(this.resultSet
/*  710: 757 */             .getFloat("SALES_ITEM_DISCOUNT"));
/*  711: 758 */           invoiceSale.setNetTotal(this.resultSet
/*  712: 759 */             .getFloat("SALES_ITEM_NET_TOTAL"));
/*  713:     */         }
/*  714:     */       }
/*  715:     */     }
/*  716:     */     catch (SQLException sqlExp)
/*  717:     */     {
/*  718: 768 */       sqlExp.printStackTrace();
/*  719: 769 */       this.logger.error(
/*  720: 770 */         InvoiceSaleDaoImpl.class + 
/*  721: 771 */         "Error: Occur in Query While Fetching the specific sales Details from Database.", 
/*  722: 772 */         sqlExp);
/*  723:     */     }
/*  724:     */     catch (Exception exception)
/*  725:     */     {
/*  726: 774 */       exception.printStackTrace();
/*  727: 775 */       this.logger.error(
/*  728: 776 */         InvoiceSaleDaoImpl.class + 
/*  729: 777 */         "Error: Occur in Query While Closing Connection After Fetching the specific sales Details from Database.", 
/*  730: 778 */         exception);
/*  731:     */     }
/*  732:     */     finally
/*  733:     */     {
/*  734: 780 */       JdbcHelper.closeResultSet(this.resultSet);
/*  735: 781 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/*  736: 782 */       JdbcHelper.closeConnection(this.connection);
/*  737:     */     }
/*  738: 786 */     return invoiceSale;
/*  739:     */   }
/*  740:     */   
/*  741:     */   public int deleteSpecificSalesDetails(int salesId)
/*  742:     */     throws DeleteFailedException
/*  743:     */   {
/*  744: 793 */     int effect = 0;
/*  745:     */     try
/*  746:     */     {
/*  747: 795 */       this.connection = getConnection();
/*  748:     */       
/*  749: 797 */       this.preparedStatement = this.connection.prepareStatement("DELETE FROM TAB_SALES_DETAILS WHERE SALES_ID=?");
/*  750:     */       
/*  751: 799 */       this.preparedStatement.setInt(1, salesId);
/*  752:     */       
/*  753: 801 */       effect = this.preparedStatement.executeUpdate();
/*  754:     */     }
/*  755:     */     catch (SQLException sqlException)
/*  756:     */     {
/*  757: 804 */       sqlException.printStackTrace();
/*  758: 805 */       this.logger.error(
/*  759: 806 */         InvoiceSaleDaoImpl.class + 
/*  760: 807 */         ": Error:- Error: Occur in Query While deleting the sales details record", 
/*  761: 808 */         sqlException);
/*  762:     */     }
/*  763:     */     catch (Exception exception)
/*  764:     */     {
/*  765: 810 */       exception.printStackTrace();
/*  766: 811 */       this.logger.error(
/*  767: 812 */         InvoiceSaleDaoImpl.class + 
/*  768: 813 */         ": Error:- While closing the Connection after deleting the sales details reccord", 
/*  769: 814 */         exception);
/*  770:     */     }
/*  771:     */     finally
/*  772:     */     {
/*  773: 817 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/*  774: 818 */       JdbcHelper.closeConnection(this.connection);
/*  775:     */     }
/*  776: 820 */     return effect;
/*  777:     */   }
/*  778:     */   
/*  779:     */   private int getSalesId(String uniqueId)
/*  780:     */   {
/*  781: 826 */     Connection connection = null;
/*  782: 827 */     PreparedStatement preparedStatement = null;
/*  783: 828 */     ResultSet resultSet = null;
/*  784: 829 */     String sql = "SELECT SALES_ID FROM TAB_SALES_DETAILS WHERE UNIQUE_ID=? ";
/*  785: 830 */     int estId = 0;
/*  786:     */     try
/*  787:     */     {
/*  788: 832 */       connection = getConnection();
/*  789: 833 */       preparedStatement = connection.prepareStatement(sql);
/*  790: 834 */       preparedStatement.setString(1, uniqueId);
/*  791: 835 */       resultSet = preparedStatement.executeQuery();
/*  792: 836 */       if ((resultSet != null) && 
/*  793: 837 */         (resultSet.next())) {}
/*  794: 838 */       return resultSet.getInt("SALES_ID");
/*  795:     */     }
/*  796:     */     catch (Exception e) {}
/*  797: 843 */     return estId;
/*  798:     */   }
/*  799:     */   
/*  800:     */   private void addSalesItems(String[] a, String[] b, String[] c, String[] d, String[] e, String[] f, int estmID, int j, int k)
/*  801:     */   {
/*  802: 850 */     Connection connection = null;
/*  803: 851 */     PreparedStatement preparedStatement = null;
/*  804:     */     try
/*  805:     */     {
/*  806: 854 */       for (int i = 0; i < a.length; i++)
/*  807:     */       {
/*  808: 856 */         String sql = "INSERT INTO TAB_SALES_ITEMS(SALES_ITEM_REF, SALES_ITEM_DESCRIPTION, SALES_ITEM_QUANTITY, SALES_ITEM_PRICE, SALES_ITEM_TAX, SALES_ITEM_AMOUNT, REF_SALES_ID, SHOP_ID)VALUES(?,?,?,?,?,?,?,?)";
/*  809: 857 */         connection = getConnection();
/*  810: 858 */         preparedStatement = connection.prepareStatement(sql);
/*  811:     */         
/*  812: 860 */         preparedStatement.setString(1, a[i]);
/*  813: 861 */         preparedStatement.setString(2, b[i]);
/*  814: 862 */         preparedStatement.setString(3, c[i]);
/*  815: 863 */         preparedStatement.setString(4, d[i]);
/*  816: 864 */         preparedStatement.setString(5, e[i]);
/*  817: 865 */         System.out.println("e[i]llllllllllllle[i]" + e[i]);
/*  818: 866 */         preparedStatement.setString(6, f[i]);
/*  819: 867 */         preparedStatement.setInt(7, estmID);
/*  820: 868 */         preparedStatement.setInt(8, j);
/*  821: 869 */         preparedStatement.executeUpdate();
/*  822:     */       }
/*  823:     */     }
/*  824:     */     catch (SQLException exception)
/*  825:     */     {
/*  826: 872 */       this.logger.error(InvoiceSaleDaoImpl.class + "ERROR: Occured while inserting sales Item Details into the database. ", exception);
/*  827:     */     }
/*  828:     */     catch (Exception exception)
/*  829:     */     {
/*  830: 875 */       this.logger.error(InvoiceSaleDaoImpl.class + "ERROR: Occured while inserting sales Item Details into the database. ", exception);
/*  831:     */     }
/*  832:     */   }
/*  833:     */   
/*  834:     */   public void insertIntoCustomerTansaction(float netTotal_sale, String uniqueId, float payment, String customerType, int salesID, String paymentMode, String dateOfTransaction, int custId, int i, int j)
/*  835:     */     throws CreateFailedException
/*  836:     */   {
/*  837: 883 */     if (payment >= 0.0F)
/*  838:     */     {
/*  839: 886 */       System.out.println("HHHHHHHHHHHUUUUUUUULLLLLLLLL" + i);
/*  840:     */       
/*  841:     */ 
/*  842: 889 */       float paid = payment;
/*  843: 890 */       float due = netTotal_sale - paid;
/*  844:     */       try
/*  845:     */       {
/*  846: 895 */         System.out.println("@@@@@@@@@@@@@@@@@@@CUSTid" + custId + "uniqueId" + uniqueId + "dateOfTransaction" + dateOfTransaction + "payment" + payment + "customerType" + customerType);
/*  847: 896 */         this.connection = getConnection();
/*  848: 900 */         if (customerType.equals("Retailer"))
/*  849:     */         {
/*  850: 902 */           String danger_query = "INSERT INTO TAB_OWNER_CUSTOMER_TRANSACTION(CUSTOMER_UNIQUE_ID,CUSTOMER_TYPE,CUSTOMER_TRANS_DISCRIPTION, CUSTOMER_TRANS_PAY_MODE,CUSTOMER_TRANS_DATE,CUSTOMER_TRANS_TOTAL, CUSTOMER_TRANS_PAID ,CUSTOMER_TRANS_DUE, CUSTOMER_ID_RETAILER, CUSTOMER_TRANS_TOTAL_PAID,CUSTOMER_TRANS_TOTAL_DUE)SELECT ?,?,?,?,?,?,?,?,?,SUM(TAB_OWNER_CUSTOMER_TRANSACTION.CUSTOMER_TRANS_PAID)+" + 
/*  851: 903 */             paid + ",SUM(TAB_OWNER_CUSTOMER_TRANSACTION.CUSTOMER_TRANS_DUE)+" + due + " FROM TAB_OWNER_CUSTOMER_TRANSACTION WHERE CUSTOMER_ID_RETAILER=" + custId;
/*  852: 904 */           this.preparedStatement = this.connection.prepareStatement(danger_query);
/*  853: 905 */           this.preparedStatement.setString(1, uniqueId);
/*  854: 906 */           this.preparedStatement.setString(2, customerType);
/*  855: 907 */           this.preparedStatement.setString(3, "ON SALE");
/*  856: 908 */           this.preparedStatement.setString(4, paymentMode);
/*  857: 909 */           this.preparedStatement.setString(5, dateOfTransaction);
/*  858: 910 */           this.preparedStatement.setFloat(6, netTotal_sale);
/*  859: 911 */           this.preparedStatement.setFloat(7, payment);
/*  860: 912 */           this.preparedStatement.setFloat(8, due);
/*  861: 913 */           this.preparedStatement.setInt(9, custId);
/*  862:     */         }
/*  863:     */         else
/*  864:     */         {
/*  865: 918 */           String danger_query2 = "INSERT INTO TAB_OWNER_CUSTOMER_TRANSACTION(CUSTOMER_UNIQUE_ID,CUSTOMER_TYPE,CUSTOMER_TRANS_DISCRIPTION, CUSTOMER_TRANS_PAY_MODE,CUSTOMER_TRANS_DATE,CUSTOMER_TRANS_TOTAL, CUSTOMER_TRANS_PAID ,CUSTOMER_TRANS_DUE, CUSTOMER_ID_CONSUMER, CUSTOMER_TRANS_TOTAL_PAID,CUSTOMER_TRANS_TOTAL_DUE)SELECT ?,?,?,?,?,?,?,?,?,SUM(TAB_OWNER_CUSTOMER_TRANSACTION.CUSTOMER_TRANS_PAID)+" + 
/*  866: 919 */             paid + ",SUM(TAB_OWNER_CUSTOMER_TRANSACTION.CUSTOMER_TRANS_DUE)+" + due + " FROM TAB_OWNER_CUSTOMER_TRANSACTION WHERE CUSTOMER_ID_CONSUMER=" + custId;
/*  867: 920 */           this.preparedStatement = this.connection.prepareStatement(danger_query2);
/*  868: 921 */           this.preparedStatement.setString(1, uniqueId);
/*  869: 922 */           this.preparedStatement.setString(2, customerType);
/*  870: 923 */           this.preparedStatement.setString(3, "ON SALE");
/*  871: 924 */           this.preparedStatement.setString(4, paymentMode);
/*  872: 925 */           this.preparedStatement.setString(5, dateOfTransaction);
/*  873: 926 */           this.preparedStatement.setFloat(6, netTotal_sale);
/*  874: 927 */           this.preparedStatement.setFloat(7, payment);
/*  875: 928 */           this.preparedStatement.setFloat(8, due);
/*  876: 929 */           this.preparedStatement.setInt(9, custId);
/*  877:     */         }
/*  878: 933 */         this.preparedStatement.executeUpdate();
/*  879:     */       }
/*  880:     */       catch (SQLException sqlException)
/*  881:     */       {
/*  882: 937 */         this.logger.error("ERROR: While inserting the customer transaction details into the database", sqlException);
/*  883: 938 */         System.out.println(sqlException);
/*  884:     */       }
/*  885:     */       catch (Exception exception)
/*  886:     */       {
/*  887: 940 */         this.logger.error("ERROR: While inserting the customer transaction details into the database", exception);
/*  888: 941 */         System.out.println(exception);
/*  889:     */       }
/*  890:     */       finally
/*  891:     */       {
/*  892: 944 */         JdbcHelper.closePreparedStatement(this.preparedStatement);
/*  893: 945 */         JdbcHelper.closeConnection(this.connection);
/*  894:     */       }
/*  895:     */     }
/*  896:     */   }
/*  897:     */   
/*  898:     */   public InvoiceSale retriveSpecificSalesDetailForUpdate(int salesId)
/*  899:     */     throws RecordNotFoundException
/*  900:     */   {
/*  901: 954 */     InvoiceSale invoiceSale = new InvoiceSale();
/*  902: 955 */     PreparedStatement preparedStatements = null;
/*  903:     */     try
/*  904:     */     {
/*  905: 957 */       this.connection = getConnection();
/*  906:     */       
/*  907: 959 */       preparedStatements = this.connection
/*  908: 960 */         .prepareStatement("SELECT * FROM TAB_SALES_DETAILS WHERE SALES_ID=?");
/*  909: 961 */       preparedStatements.setInt(1, salesId);
/*  910:     */       
/*  911:     */ 
/*  912: 964 */       this.resultSet = preparedStatements.executeQuery();
/*  913: 965 */       System.out.println("----------hye ----------------");
/*  914: 966 */       if (this.resultSet != null) {
/*  915: 967 */         while (this.resultSet.next())
/*  916:     */         {
/*  917: 969 */           System.out.println("----------hye ----------------");
/*  918:     */           
/*  919: 971 */           invoiceSale.setSalesId(this.resultSet.getInt("SALES_ID"));
/*  920: 972 */           System.out.println("________________" + this.resultSet.getInt("SALES_ID"));
/*  921:     */           
/*  922: 974 */           invoiceSale.setFullName(this.nameHelper.getRegularCustomerNameById(this.resultSet.getInt("SALES_CUSTOMER_ID_REF")));
/*  923: 975 */           System.out.println("---------" + this.resultSet.getString("SALES_CUSTOMER_FULLNAME"));
/*  924:     */           
/*  925:     */ 
/*  926: 978 */           invoiceSale.setCustomerType(this.resultSet
/*  927: 979 */             .getString("SALES_CUSTOMER_TYPE"));
/*  928:     */           
/*  929:     */ 
/*  930: 982 */           String type = this.resultSet.getString("SALES_CUSTOMER_TYPE");
/*  931: 983 */           System.out.println(type + "GGGGGGGGGGGGGGGGGGGGGGhahaha");
/*  932: 984 */           if (type.equals("Retailer"))
/*  933:     */           {
/*  934: 985 */             invoiceSale.setCustomerId(this.resultSet
/*  935: 986 */               .getInt("SALES_CUSTOMER_ID_REF"));
/*  936:     */             
/*  937: 988 */             invoiceSale.setPhoneNo(this.resultSet
/*  938: 989 */               .getString("SALES_CUSTOMER_PHONE"));
/*  939:     */             
/*  940: 991 */             invoiceSale.setAddress(this.resultSet
/*  941: 992 */               .getString("SALES_CUSTOMER_ADREESS"));
/*  942:     */             
/*  943:     */ 
/*  944:     */ 
/*  945: 996 */             invoiceSale.setSalesDate(this.resultSet
/*  946: 997 */               .getString("SALES_DATE"));
/*  947:     */           }
/*  948:     */           else
/*  949:     */           {
/*  950: 999 */             invoiceSale.setCustomerIdConsumer(this.resultSet
/*  951:1000 */               .getInt("SALES_CUSTOMER_ID_REF"));
/*  952:1001 */             invoiceSale.setPhoneNoConsumer(this.resultSet
/*  953:1002 */               .getString("SALES_CUSTOMER_PHONE"));
/*  954:     */             
/*  955:1004 */             invoiceSale.setAddressConsumer(this.resultSet
/*  956:1005 */               .getString("SALES_CUSTOMER_ADREESS"));
/*  957:     */             
/*  958:     */ 
/*  959:1008 */             invoiceSale.setSalesDateConsumer(this.resultSet
/*  960:1009 */               .getString("SALES_DATE"));
/*  961:     */           }
/*  962:1013 */           invoiceSale.setItemId(this.resultSet
/*  963:1014 */             .getString("SALES_ITEM_ID"));
/*  964:     */           
/*  965:1016 */           invoiceSale.setItemDescription(this.resultSet.getString("SALES_ITEM_DISCRIPTION"));
/*  966:     */           
/*  967:1018 */           invoiceSale.setItemQuantity(DateTimeUtil.convertDatetoFormDate(this.resultSet.getString("SALES_DATE")));
/*  968:     */           
/*  969:     */ 
/*  970:     */ 
/*  971:1022 */           invoiceSale.setItemTax(this.resultSet.getString("SALES_ITEM_TAX"));
/*  972:     */           
/*  973:1024 */           invoiceSale.setAmount(this.resultSet
/*  974:1025 */             .getString("SALES_ITEM_AMOUNT"));
/*  975:     */           
/*  976:1027 */           invoiceSale.setSubTotal(this.resultSet
/*  977:1028 */             .getFloat("SALES_ITEM_SUBTOTAL"));
/*  978:     */           
/*  979:     */ 
/*  980:     */ 
/*  981:1032 */           invoiceSale.setTotal(this.resultSet
/*  982:1033 */             .getFloat("SALES_ITEM_TOTAL"));
/*  983:1034 */           invoiceSale.setDiscount(this.resultSet
/*  984:1035 */             .getFloat("SALES_ITEM_DISCOUNT"));
/*  985:1036 */           invoiceSale.setNetTotal(this.resultSet
/*  986:1037 */             .getFloat("SALES_ITEM_NET_TOTAL"));
/*  987:1038 */           invoiceSale.setTotalTax(this.resultSet
/*  988:1039 */             .getFloat("SALES_TAX_AMOUNT"));
/*  989:1040 */           invoiceSale.setPaymentAnswer(this.resultSet
/*  990:1041 */             .getString("SALES_PAYMENT_ANSWER"));
/*  991:1042 */           invoiceSale.setPayment(this.resultSet
/*  992:1043 */             .getFloat("SALES_PAYMENT"));
/*  993:1044 */           invoiceSale.setPaymentMode(this.resultSet
/*  994:1045 */             .getString("SALES_PAYMENT_MODE"));
/*  995:     */           
/*  996:     */ 
/*  997:1048 */           System.out.println(this.resultSet.getFloat("SALES_ITEM_NET_TOTAL") + this.resultSet.getInt("SALES_CUSTOMER_ID_REF") + this.resultSet.getString("SALES_DATE") + "%%%%%%%%%%%%%%%");
/*  998:     */         }
/*  999:     */       }
/* 1000:     */     }
/* 1001:     */     catch (SQLException sqlExp)
/* 1002:     */     {
/* 1003:1059 */       sqlExp.printStackTrace();
/* 1004:1060 */       this.logger.error(
/* 1005:1061 */         InvoiceSaleDaoImpl.class + 
/* 1006:1062 */         "Error: Occur in Query While Fetching the specific sales Details from Database For Update.", 
/* 1007:1063 */         sqlExp);
/* 1008:     */     }
/* 1009:     */     catch (Exception exception)
/* 1010:     */     {
/* 1011:1065 */       exception.printStackTrace();
/* 1012:1066 */       this.logger.error(
/* 1013:1067 */         InvoiceSaleDaoImpl.class + 
/* 1014:1068 */         "Error: Occur in Query While Closing Connection After Fetching the specific sales Details from Database For Update.", 
/* 1015:1069 */         exception);
/* 1016:     */     }
/* 1017:     */     finally
/* 1018:     */     {
/* 1019:1071 */       JdbcHelper.closeResultSet(this.resultSet);
/* 1020:1072 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/* 1021:1073 */       JdbcHelper.closeConnection(this.connection);
/* 1022:     */     }
/* 1023:1077 */     return invoiceSale;
/* 1024:     */   }
/* 1025:     */   
/* 1026:     */   public List<InvoiceSaleVO> getSpecificItemsForEdit(int salesId)
/* 1027:     */     throws RecordNotFoundException
/* 1028:     */   {
/* 1029:1084 */     List<InvoiceSaleVO> salesItemsDetailList = new ArrayList();
/* 1030:     */     try
/* 1031:     */     {
/* 1032:1088 */       this.connection = getConnection();
/* 1033:     */       
/* 1034:1090 */       this.preparedStatement = this.connection
/* 1035:1091 */         .prepareStatement("SELECT * FROM TAB_SALES_ITEMS  WHERE REF_SALES_ID=?");
/* 1036:1092 */       this.preparedStatement.setInt(1, salesId);
/* 1037:     */       
/* 1038:     */ 
/* 1039:1095 */       this.resultSet = this.preparedStatement.executeQuery();
/* 1040:1099 */       while (this.resultSet.next())
/* 1041:     */       {
/* 1042:1100 */         this.saleVO = new InvoiceSaleVO();
/* 1043:1101 */         this.saleVO.setItemId(this.resultSet.getString("SALES_ITEM_REF"));
/* 1044:     */         
/* 1045:     */ 
/* 1046:     */ 
/* 1047:     */ 
/* 1048:1106 */         this.saleVO.setItemDescription(this.resultSet
/* 1049:1107 */           .getString("SALES_ITEM_DESCRIPTION"));
/* 1050:     */         
/* 1051:1109 */         this.saleVO.setItemQuantity(this.resultSet
/* 1052:1110 */           .getString("SALES_ITEM_QUANTITY"));
/* 1053:     */         
/* 1054:1112 */         this.saleVO.setItemPrice(this.resultSet
/* 1055:1113 */           .getString("SALES_ITEM_PRICE"));
/* 1056:     */         
/* 1057:     */ 
/* 1058:1116 */         this.saleVO.setItemTax(String.valueOf(this.resultSet
/* 1059:1117 */           .getInt("SALES_ITEM_TAX")).trim());
/* 1060:     */         
/* 1061:     */ 
/* 1062:     */ 
/* 1063:1121 */         this.saleVO.setAmount(this.resultSet
/* 1064:1122 */           .getString("SALES_ITEM_AMOUNT"));
/* 1065:     */         
/* 1066:1124 */         System.out.println(this.resultSet.getFloat("SALES_ITEM_AMOUNT") + " " + this.resultSet.getFloat("SALES_ITEM_PRICE") + "****8888****" + this.resultSet
/* 1067:1125 */           .getString("SALES_ITEM_QUANTITY") + " " + String.valueOf(this.resultSet.getInt("SALES_ITEM_TAX")));
/* 1068:1126 */         salesItemsDetailList.add(this.saleVO);
/* 1069:     */       }
/* 1070:     */     }
/* 1071:     */     catch (SQLException sqlExp)
/* 1072:     */     {
/* 1073:1130 */       sqlExp.printStackTrace();
/* 1074:1131 */       this.logger.error(
/* 1075:1132 */         InvoiceSaleDaoImpl.class + 
/* 1076:1133 */         "Error: Occur in Query While Fetching the sales items Details  from Database.", 
/* 1077:1134 */         sqlExp);
/* 1078:     */     }
/* 1079:     */     catch (Exception exception)
/* 1080:     */     {
/* 1081:1136 */       exception.printStackTrace();
/* 1082:1137 */       this.logger.error(
/* 1083:1138 */         InvoiceSaleDaoImpl.class + 
/* 1084:1139 */         "Error: Occur in Query While Closing Connection After Fetching the sales items Details from Database.", 
/* 1085:1140 */         exception);
/* 1086:     */     }
/* 1087:     */     finally
/* 1088:     */     {
/* 1089:1142 */       JdbcHelper.closeResultSet(this.resultSet);
/* 1090:1143 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/* 1091:1144 */       JdbcHelper.closeConnection(this.connection);
/* 1092:     */     }
/* 1093:1146 */     return salesItemsDetailList;
/* 1094:     */   }
/* 1095:     */   
/* 1096:     */   public void updateSpecificSalesRecord(InvoiceSaleVO invoiceSaleVO, int salesId)
/* 1097:     */     throws UpdateFailedException
/* 1098:     */   {
/* 1099:1154 */     Connection con = null;
/* 1100:1155 */     PreparedStatement pre = null;
/* 1101:     */     try
/* 1102:     */     {
/* 1103:1157 */       con = getConnection();
/* 1104:     */       
/* 1105:1159 */       String D = "UPDATE TAB_SALES_DETAILS SET  SALES_CUSTOMER_ID_REF=?,SALES_CUSTOMER_PHONE=?,SALES_CUSTOMER_ADREESS=?,SALES_ITEM_SUBTOTAL=?, SALES_ITEM_TOTAL=?, SALES_ITEM_DISCOUNT=?, SALES_ITEM_NET_TOTAL=?,UNIQUE_ID=?,SALES_CUSTOMER_TYPE=?, TRANSPORT_CHARGES=? WHERE SALES_ID=? AND SHOP_ID=?";
/* 1106:     */       
/* 1107:     */ 
/* 1108:     */ 
/* 1109:     */ 
/* 1110:1164 */       pre = con.prepareStatement(D);
/* 1111:     */       
/* 1112:     */ 
/* 1113:1167 */       float netTotal_sale = invoiceSaleVO.getNetTotal();
/* 1114:1168 */       float payment = invoiceSaleVO.getPayment();
/* 1115:1169 */       String paymentMode = invoiceSaleVO.getPaymentMode();
/* 1116:1170 */       String customerType = invoiceSaleVO.getCustomerType();
/* 1117:     */       
/* 1118:     */ 
/* 1119:1173 */       String uniqueId = IDGenerator.generateAlphaNumericID(27);
/* 1120:     */       
/* 1121:1175 */       System.out.println(invoiceSaleVO.getNetTotal() + "&&&&&&&&&&&&&ID" + invoiceSaleVO.getCustomerId() + "phone" + invoiceSaleVO.getPhoneNo());
/* 1122:1176 */       if (customerType.equals("Retailer"))
/* 1123:     */       {
/* 1124:1178 */         String dateOfTransaction = invoiceSaleVO.getSalesDate();
/* 1125:1179 */         int custId = invoiceSaleVO.getCustomerId();
/* 1126:     */         
/* 1127:     */ 
/* 1128:     */ 
/* 1129:1183 */         pre.setInt(1, invoiceSaleVO.getCustomerId());
/* 1130:     */         
/* 1131:1185 */         pre.setString(2, invoiceSaleVO.getPhoneNo());
/* 1132:1186 */         pre.setString(3, invoiceSaleVO.getAddress());
/* 1133:     */       }
/* 1134:1187 */       else if (customerType.equals("Consumer"))
/* 1135:     */       {
/* 1136:1188 */         String dateOfTransaction = invoiceSaleVO.getSalesDateConsumer();
/* 1137:1189 */         int custId = invoiceSaleVO.getCustomerIdConsumer();
/* 1138:     */         
/* 1139:     */ 
/* 1140:1192 */         this.preparedStatement.setInt(1, invoiceSaleVO.getCustomerIdConsumer());
/* 1141:1193 */         this.preparedStatement.setString(2, invoiceSaleVO.getPhoneNoConsumer());
/* 1142:1194 */         this.preparedStatement.setString(3, invoiceSaleVO.getAddressConsumer());
/* 1143:     */       }
/* 1144:1200 */       pre.setFloat(4, invoiceSaleVO.getSubTotal());
/* 1145:     */       
/* 1146:1202 */       pre.setFloat(5, invoiceSaleVO.getTotal());
/* 1147:1203 */       pre.setFloat(6, invoiceSaleVO.getDiscount());
/* 1148:     */       
/* 1149:     */ 
/* 1150:1206 */       pre.setFloat(7, invoiceSaleVO.getNetTotal());
/* 1151:1207 */       pre.setString(8, uniqueId);
/* 1152:1208 */       pre.setString(9, invoiceSaleVO.getCustomerType());
/* 1153:1209 */       pre.setInt(10, salesId);
/* 1154:1210 */       pre.setInt(11, invoiceSaleVO.getAclId());
/* 1155:1211 */       pre.setFloat(12, invoiceSaleVO.getTranspportCharges());
/* 1156:     */       
/* 1157:1213 */       pre.executeUpdate();
/* 1158:     */       
/* 1159:1215 */       System.out.println("estmID" + salesId);
/* 1160:1216 */       String[] a = invoiceSaleVO.getItemId().split(",");
/* 1161:1217 */       System.out.println(invoiceSaleVO.getItemId() + " " + invoiceSaleVO.getItemDescription() + " " + invoiceSaleVO.getItemQuantity());
/* 1162:1218 */       String[] b = invoiceSaleVO.getItemDescription().split(",");
/* 1163:1219 */       String[] c = invoiceSaleVO.getItemQuantity().split(",");
/* 1164:1220 */       String[] d = invoiceSaleVO.getItemPrice().split(",");
/* 1165:     */       
/* 1166:1222 */       String[] e = invoiceSaleVO.getItemTax().split(",");
/* 1167:1223 */       String[] f = invoiceSaleVO.getAmount().split(",");
/* 1168:1224 */       System.out.println("a" + a + "b" + b + " (((())))");
/* 1169:1225 */       System.out.println("netTotal_sale" + netTotal_sale + "payment" + payment + "customerType" + customerType + "paymentMode" + paymentMode + "dateOfTransaction");
/* 1170:1226 */       updateSalesItems(a, b, c, d, e, f, salesId, invoiceSaleVO.getAclId());
/* 1171:     */     }
/* 1172:     */     catch (SQLException sqlException)
/* 1173:     */     {
/* 1174:1235 */       sqlException.printStackTrace();
/* 1175:1236 */       this.logger.error(
/* 1176:1237 */         InvoiceSaleDaoImpl.class + 
/* 1177:1238 */         ": Error:- Error: Occur in Query While updating the sales details record", 
/* 1178:1239 */         sqlException);
/* 1179:     */     }
/* 1180:     */     catch (Exception exception)
/* 1181:     */     {
/* 1182:1241 */       exception.printStackTrace();
/* 1183:1242 */       this.logger.error(
/* 1184:1243 */         InvoiceSaleDaoImpl.class + 
/* 1185:1244 */         ": Error:- While closing the Connection after updating the sales details reccord", 
/* 1186:1245 */         exception);
/* 1187:     */     }
/* 1188:     */     finally
/* 1189:     */     {
/* 1190:1248 */       JdbcHelper.closePreparedStatement(pre);
/* 1191:1249 */       JdbcHelper.closeConnection(con);
/* 1192:     */     }
/* 1193:     */   }
/* 1194:     */   
/* 1195:     */   private void updateSalesItems(String[] a, String[] b, String[] c, String[] d, String[] e, String[] f, int salesId, int j)
/* 1196:     */   {
/* 1197:1260 */     Connection connection = null;
/* 1198:1261 */     PreparedStatement preparedStatement = null;
/* 1199:1263 */     for (int i = 0; i < a.length; i++)
/* 1200:     */     {
/* 1201:1266 */       String up = "UPDATE TAB_SALES_ITEMS SET SALES_ITEM_REF=?, SALES_ITEM_DESCRIPTION=?, SALES_ITEM_QUANTITY=?, SALES_ITEM_PRICE=?, SALES_ITEM_TAX=?, SALES_ITEM_AMOUNT=? WHERE  REF_SALES_ID=? AND SHOP_ID=?";
/* 1202:1267 */       String sql = "INSERT INTO TAB_SALES_ITEMS(SALES_ITEM_REF, SALES_ITEM_DESCRIPTION, SALES_ITEM_QUANTITY, SALES_ITEM_PRICE, SALES_ITEM_TAX, SALES_ITEM_AMOUNT, REF_SALES_ID, SHOP_ID)VALUES(?,?,?,?,?,?,?,?)";
/* 1203:     */       try
/* 1204:     */       {
/* 1205:1269 */         connection = getConnection();
/* 1206:1270 */         preparedStatement = connection.prepareStatement(up);
/* 1207:1271 */         preparedStatement.setString(1, a[i]);
/* 1208:1272 */         preparedStatement.setString(2, b[i]);
/* 1209:1273 */         preparedStatement.setString(3, c[i]);
/* 1210:1274 */         preparedStatement.setString(4, d[i]);
/* 1211:1275 */         preparedStatement.setString(5, e[i]);
/* 1212:1276 */         System.out.println("e[i]llllllllllllle[i]" + e[i] + a[i] + b[i] + c[i] + d[i] + f[i] + salesId);
/* 1213:1277 */         preparedStatement.setString(6, f[i]);
/* 1214:1278 */         preparedStatement.setInt(7, salesId);
/* 1215:1279 */         preparedStatement.setInt(8, j);
/* 1216:1280 */         preparedStatement.executeUpdate();
/* 1217:     */       }
/* 1218:     */       catch (Exception exception)
/* 1219:     */       {
/* 1220:1282 */         exception.printStackTrace();
/* 1221:     */       }
/* 1222:     */     }
/* 1223:     */   }
/* 1224:     */   
/* 1225:     */   public void updateCustomerTansaction(float netTotal_sale, String uniqueId, float payment, String customerType, int salesId, String paymentMode, String dateOfTransaction, int custId) {}
/* 1226:     */   
/* 1227:     */   public void salesPDF(HttpServletRequest request, HttpServletResponse response, int salesId)
/* 1228:     */   {
/* 1229:1369 */     String companyName = "Chouksay Traders";
/* 1230:1370 */     String address1 = "BUS STAND SHAMSHABAD, DIST.- VIDISHA, MADHYA PRADESH, 464001";
/* 1231:1371 */     String address2 = "GSTIN: 23AJQPC8200P1Z1";
/* 1232:1372 */     String address3 = "PAN NO: AJQPC8200P";
/* 1233:     */     
/* 1234:1374 */     String city = "Vidisha-464001";
/* 1235:1375 */     String state = "(M.P.)";
/* 1236:1376 */     StringBuffer stringBuffer = null;
/* 1237:     */     try
/* 1238:     */     {
/* 1239:1380 */       this.connection = getConnection();
/* 1240:     */       
/* 1241:1382 */       this.preparedStatement = this.connection
/* 1242:1383 */         .prepareStatement("SELECT * FROM TAB_SALES_DETAILS WHERE SALES_ID=?");
/* 1243:1384 */       this.preparedStatement.setInt(1, salesId);
/* 1244:     */       
/* 1245:     */ 
/* 1246:1387 */       this.resultSet = this.preparedStatement.executeQuery();
/* 1247:1388 */       Document document = new Document(PageSize.A4);
/* 1248:     */       
/* 1249:1390 */       Font Font3 = new Font(Font.FontFamily.TIMES_ROMAN, 11.0F, 0);
/* 1250:1391 */       Font Font2 = new Font(Font.FontFamily.TIMES_ROMAN, 6.0F, 
/* 1251:1392 */         8);
/* 1252:1393 */       Font Font4 = new Font(Font.FontFamily.TIMES_ROMAN, 11.0F, 1);
/* 1253:1394 */       Font4.setColor(BaseColor.WHITE);
/* 1254:1395 */       Font mainContent = new Font(Font.FontFamily.TIMES_ROMAN, 10.0F, 
/* 1255:1396 */         0);
/* 1256:1397 */       Font Font5 = new Font(Font.FontFamily.TIMES_ROMAN, 12.0F, 1);
/* 1257:1398 */       Font5.setColor(BaseColor.GRAY);
/* 1258:1399 */       Font Font6 = new Font(Font.FontFamily.TIMES_ROMAN, 10.0F, 1);
/* 1259:1400 */       Font6.setColor(BaseColor.RED);
/* 1260:     */       
/* 1261:     */ 
/* 1262:1403 */       response.setContentType("application/pdf");
/* 1263:     */       
/* 1264:1405 */       PdfWriter.getInstance(document, response.getOutputStream());
/* 1265:     */       
/* 1266:1407 */       document.open();
/* 1267:     */       
/* 1268:1409 */       String contextPath = ServletActionContext.getServletContext()
/* 1269:1410 */         .getRealPath("/outer/img/rohittraders.png");
/* 1270:1411 */       this.image = Image.getInstance(contextPath);
/* 1271:1412 */       this.image.scaleToFit(130.0F, 70.0F);
/* 1272:     */       
/* 1273:1414 */       PdfPTable table1 = new PdfPTable(2);
/* 1274:1415 */       table1.setWidthPercentage(100.0F);
/* 1275:1416 */       Rectangle rect1 = new Rectangle(300.0F, 700.0F);
/* 1276:1417 */       table1.setWidthPercentage(new float[] { 150.0F, 150.0F }, rect1);
/* 1277:     */       
/* 1278:1419 */       PdfPCell cell101 = new PdfPCell(this.image, false);
/* 1279:1420 */       cell101.setPaddingTop(5.0F);
/* 1280:1421 */       cell101.setBorder(0);
/* 1281:     */       
/* 1282:1423 */       Phrase phrase3 = new Phrase(companyName + "\n", Font5);
/* 1283:1424 */       Phrase phrase = new Phrase(address1 + "\n", Font3);
/* 1284:1425 */       Phrase phrase1 = new Phrase(address2 + "\n", Font3);
/* 1285:1426 */       Phrase phrase4 = new Phrase(address3 + "\n", Font3);
/* 1286:1427 */       Phrase phrase2 = new Phrase(city + "-" + state, Font3);
/* 1287:     */       
/* 1288:1429 */       Paragraph paragraph = new Paragraph();
/* 1289:1430 */       paragraph.add(phrase3);
/* 1290:1431 */       paragraph.add(phrase);
/* 1291:1432 */       paragraph.add(phrase1);
/* 1292:1433 */       paragraph.add(phrase4);
/* 1293:1434 */       paragraph.add(phrase2);
/* 1294:     */       
/* 1295:1436 */       PdfPCell cell102 = new PdfPCell(paragraph);
/* 1296:1437 */       cell102.setPaddingTop(5.0F);
/* 1297:1438 */       cell102.setBorder(0);
/* 1298:1439 */       cell102.setHorizontalAlignment(2);
/* 1299:     */       
/* 1300:1441 */       PdfPCell cell103 = new PdfPCell(
/* 1301:1442 */         new Paragraph(
/* 1302:1443 */         "   \n                                                                                                                                                                                                                                                                                                                                                  ", 
/* 1303:     */         
/* 1304:     */ 
/* 1305:1446 */         Font2));
/* 1306:1447 */       cell103.setColspan(2);
/* 1307:1448 */       cell103.setBorderWidthRight(0.0F);
/* 1308:1449 */       cell103.setBorderWidthLeft(0.0F);
/* 1309:1450 */       cell103.setBorderWidthTop(0.5F);
/* 1310:1451 */       cell103.setBorderWidthBottom(0.0F);
/* 1311:1452 */       cell103.setBorderColorTop(BaseColor.WHITE);
/* 1312:     */       
/* 1313:1454 */       PdfPCell cell104 = new PdfPCell(new Paragraph("SALES REPORT", Font4));
/* 1314:1455 */       cell104.setUseBorderPadding(true);
/* 1315:1456 */       cell104.setColspan(2);
/* 1316:1457 */       cell104.setBorderWidthRight(0.1F);
/* 1317:1458 */       cell104.setBorderWidthLeft(0.1F);
/* 1318:1459 */       cell104.setBorderWidthTop(0.1F);
/* 1319:1460 */       cell104.setBorderWidthBottom(0.1F);
/* 1320:1461 */       cell104.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1321:1462 */       cell104.setBackgroundColor(new BaseColor(0, 59, 119));
/* 1322:     */       
/* 1323:1464 */       table1.addCell(cell101);
/* 1324:1465 */       table1.addCell(cell102);
/* 1325:1466 */       table1.addCell(cell103);
/* 1326:1467 */       table1.addCell(cell104);
/* 1327:1468 */       document.add(table1);
/* 1328:1474 */       while (this.resultSet.next())
/* 1329:     */       {
/* 1330:1475 */         stringBuffer = new StringBuffer();
/* 1331:1476 */         PdfPTable table = new PdfPTable(2);
/* 1332:1477 */         table.setFooterRows(1);
/* 1333:1478 */         table.setWidthPercentage(100.0F);
/* 1334:1479 */         Rectangle rect = new Rectangle(300.0F, 700.0F);
/* 1335:1480 */         table.setWidthPercentage(new float[] { 80.0F, 220.0F }, rect);
/* 1336:     */         
/* 1337:1482 */         PdfPCell cell = new PdfPCell(new Paragraph());
/* 1338:1483 */         cell.setColspan(2);
/* 1339:1484 */         cell.setBorderWidthRight(0.1F);
/* 1340:1485 */         cell.setBorderWidthLeft(0.1F);
/* 1341:1486 */         cell.setBorderWidthTop(0.1F);
/* 1342:1487 */         cell.setBorderWidthBottom(0.2F);
/* 1343:1488 */         cell.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1344:1489 */         cell.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1345:     */         
/* 1346:1491 */         PdfPCell cell1 = new PdfPCell(new Paragraph("Sales Information", 
/* 1347:1492 */           mainContent));
/* 1348:1493 */         cell1.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1349:1494 */         cell1.setBorderWidth(0.01F);
/* 1350:1495 */         cell1.setBorderColor(BaseColor.WHITE);
/* 1351:     */         
/* 1352:1497 */         PdfPCell cell2 = new PdfPCell(new Paragraph());
/* 1353:1498 */         cell2.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1354:1499 */         cell2.setBorderWidth(0.2F);
/* 1355:1500 */         cell2.setBorderColor(BaseColor.WHITE);
/* 1356:     */         
/* 1357:1502 */         PdfPCell cell3 = new PdfPCell(new Paragraph("Sales Id", 
/* 1358:1503 */           mainContent));
/* 1359:1504 */         cell3.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1360:1505 */         cell3.setBorderWidth(0.01F);
/* 1361:1506 */         cell3.setBorderColor(BaseColor.WHITE);
/* 1362:     */         
/* 1363:1508 */         PdfPCell cell4 = new PdfPCell(new Paragraph(this.resultSet.getString("SALES_ID"), mainContent));
/* 1364:1509 */         cell4.setBorderWidth(0.2F);
/* 1365:1510 */         cell4.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1366:     */         
/* 1367:1512 */         PdfPCell cell5 = new PdfPCell(new Paragraph(
/* 1368:1513 */           "Item Total", mainContent));
/* 1369:1514 */         cell5.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1370:1515 */         cell5.setBorderWidth(0.01F);
/* 1371:1516 */         cell5.setBorderColor(BaseColor.WHITE);
/* 1372:     */         
/* 1373:1518 */         PdfPCell cell6 = new PdfPCell(new Paragraph(this.resultSet.getString("SALES_ITEM_TOTAL"), mainContent));
/* 1374:1519 */         cell6.setBorderWidth(0.2F);
/* 1375:1520 */         cell6.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1376:     */         
/* 1377:1522 */         PdfPCell cell7 = new PdfPCell(new Paragraph("Subtotal", 
/* 1378:1523 */           mainContent));
/* 1379:1524 */         cell7.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1380:1525 */         cell7.setBorderWidth(0.01F);
/* 1381:1526 */         cell7.setBorderColor(BaseColor.WHITE);
/* 1382:     */         
/* 1383:1528 */         PdfPCell cell8 = new PdfPCell(new Paragraph(
/* 1384:1529 */           this.resultSet.getString("SALES_ITEM_SUBTOTAL"), mainContent));
/* 1385:1530 */         cell8.setBorderWidth(0.2F);
/* 1386:1531 */         cell8.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1387:     */         
/* 1388:     */ 
/* 1389:     */ 
/* 1390:1535 */         PdfPCell cell9 = new PdfPCell(new Paragraph("Discount", 
/* 1391:1536 */           mainContent));
/* 1392:1537 */         cell9.setBorderWidth(0.2F);
/* 1393:1538 */         cell9.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1394:     */         
/* 1395:1540 */         PdfPCell cell10 = new PdfPCell(new Paragraph(
/* 1396:1541 */           this.resultSet.getString("SALES_ITEM_DISCOUNT"), mainContent));
/* 1397:1542 */         cell10.setBorderWidth(0.2F);
/* 1398:1543 */         cell10.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1399:     */         
/* 1400:     */ 
/* 1401:     */ 
/* 1402:     */ 
/* 1403:     */ 
/* 1404:     */ 
/* 1405:     */ 
/* 1406:     */ 
/* 1407:     */ 
/* 1408:     */ 
/* 1409:     */ 
/* 1410:1555 */         PdfPCell cell13 = new PdfPCell(new Paragraph("Net Total", 
/* 1411:1556 */           mainContent));
/* 1412:1557 */         cell13.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1413:1558 */         cell13.setBorderWidth(0.01F);
/* 1414:1559 */         cell13.setBorderColor(BaseColor.WHITE);
/* 1415:     */         
/* 1416:1561 */         PdfPCell cell14 = new PdfPCell(new Paragraph(this.resultSet.getString("SALES_ITEM_NET_TOTAL"), mainContent));
/* 1417:1562 */         cell14.setBorderWidth(0.2F);
/* 1418:1563 */         cell14.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1419:     */         
/* 1420:1565 */         PdfPCell cell15 = new PdfPCell(new Paragraph(
/* 1421:1566 */           "Customer Type", mainContent));
/* 1422:1567 */         cell15.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1423:1568 */         cell15.setBorderWidth(0.01F);
/* 1424:1569 */         cell15.setBorderColor(BaseColor.WHITE);
/* 1425:     */         
/* 1426:1571 */         PdfPCell cell16 = new PdfPCell(new Paragraph(this.resultSet.getString("SALES_CUSTOMER_TYPE"), mainContent));
/* 1427:1572 */         cell16.setBorderWidth(0.2F);
/* 1428:1573 */         cell16.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1429:     */         
/* 1430:1575 */         PdfPCell cell17 = new PdfPCell(new Paragraph("Sales Date", 
/* 1431:1576 */           mainContent));
/* 1432:1577 */         cell17.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1433:1578 */         cell17.setBorderWidth(0.01F);
/* 1434:1579 */         cell17.setBorderColor(BaseColor.WHITE);
/* 1435:     */         
/* 1436:1581 */         PdfPCell cell18 = new PdfPCell(new Paragraph(this.resultSet.getString("SALES_DATE"), mainContent));
/* 1437:1582 */         cell18.setBorderWidth(0.2F);
/* 1438:1583 */         cell18.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1439:     */         
/* 1440:1585 */         PdfPCell cell19 = new PdfPCell(new Paragraph("Payment", 
/* 1441:1586 */           mainContent));
/* 1442:1587 */         cell19.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1443:1588 */         cell19.setBorderWidth(0.01F);
/* 1444:1589 */         cell19.setBorderColor(BaseColor.WHITE);
/* 1445:     */         
/* 1446:1591 */         PdfPCell cell20 = new PdfPCell(new Paragraph(this.resultSet.getString("SALES_PAYMENT"), mainContent));
/* 1447:1592 */         cell20.setBorderWidth(0.2F);
/* 1448:1593 */         cell20.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1449:     */         
/* 1450:1595 */         PdfPCell cell21 = new PdfPCell(new Paragraph("Payment Mode", 
/* 1451:1596 */           mainContent));
/* 1452:1597 */         cell21.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1453:1598 */         cell21.setBorderWidth(0.01F);
/* 1454:1599 */         cell21.setBorderColor(BaseColor.WHITE);
/* 1455:     */         
/* 1456:1601 */         PdfPCell cell22 = new PdfPCell(new Paragraph(this.resultSet.getString("SALES_PAYMENT_MODE"), mainContent));
/* 1457:1602 */         cell22.setBorderWidth(0.2F);
/* 1458:1603 */         cell22.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1459:     */         
/* 1460:1605 */         PdfPCell cell23 = new PdfPCell(new Paragraph(
/* 1461:1606 */           "Customer Refference", mainContent));
/* 1462:1607 */         cell23.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1463:1608 */         cell23.setBorderWidth(0.01F);
/* 1464:1609 */         cell23.setBorderColor(BaseColor.WHITE);
/* 1465:     */         
/* 1466:1611 */         PdfPCell cell24 = new PdfPCell(
/* 1467:1612 */           new Paragraph(this.resultSet.getString(
/* 1468:1613 */           "SALES_CUSTOMER_ID_REF"), 
/* 1469:1614 */           mainContent));
/* 1470:1615 */         cell24.setBorderWidth(0.2F);
/* 1471:1616 */         cell24.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1472:     */         
/* 1473:1618 */         PdfPCell cell25 = new PdfPCell(new Paragraph("Customer Phone No", 
/* 1474:1619 */           mainContent));
/* 1475:1620 */         cell25.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1476:1621 */         cell25.setBorderWidth(0.01F);
/* 1477:1622 */         cell25.setBorderColor(BaseColor.WHITE);
/* 1478:     */         
/* 1479:1624 */         PdfPCell cell26 = new PdfPCell(new Paragraph(
/* 1480:1625 */           this.resultSet.getString("SALES_CUSTOMER_PHONE"), mainContent));
/* 1481:1626 */         cell26.setBorderWidth(0.2F);
/* 1482:1627 */         cell26.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1483:     */         
/* 1484:1629 */         PdfPCell cell27 = new PdfPCell(new Paragraph("Customer Address", 
/* 1485:1630 */           mainContent));
/* 1486:1631 */         cell27.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1487:1632 */         cell27.setBorderWidth(0.01F);
/* 1488:1633 */         cell27.setBorderColor(BaseColor.WHITE);
/* 1489:     */         
/* 1490:1635 */         PdfPCell cell28 = new PdfPCell(new Paragraph(
/* 1491:1636 */           this.resultSet
/* 1492:1637 */           .getString("SALES_CUSTOMER_ADREESS"), mainContent));
/* 1493:1638 */         cell28.setBorderWidth(0.2F);
/* 1494:1639 */         cell28.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1495:     */         
/* 1496:1641 */         PdfPCell cell29 = new PdfPCell(new Paragraph(
/* 1497:1642 */           "Sales Refference", mainContent));
/* 1498:1643 */         cell29.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1499:1644 */         cell29.setBorderWidth(0.01F);
/* 1500:1645 */         cell29.setBorderColor(BaseColor.WHITE);
/* 1501:     */         
/* 1502:1647 */         PdfPCell cell30 = new PdfPCell(new Paragraph(
/* 1503:1648 */           this.resultSet
/* 1504:1649 */           .getString("UNIQUE_ID"), 
/* 1505:1650 */           mainContent));
/* 1506:1651 */         cell30.setBorderWidth(0.2F);
/* 1507:1652 */         cell30.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1508:     */         
/* 1509:1654 */         PdfPCell cell31 = new PdfPCell(new Paragraph(
/* 1510:1655 */           "Payment Answer", mainContent));
/* 1511:1656 */         cell31.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1512:1657 */         cell31.setBorderWidth(0.01F);
/* 1513:1658 */         cell31.setBorderColor(BaseColor.WHITE);
/* 1514:     */         
/* 1515:1660 */         PdfPCell cell32 = new PdfPCell(new Paragraph(
/* 1516:1661 */           this.resultSet
/* 1517:1662 */           .getString("SALES_PAYMENT_ANSWER"), 
/* 1518:1663 */           mainContent));
/* 1519:1664 */         cell32.setBorderWidth(0.2F);
/* 1520:1665 */         cell32.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1521:     */         
/* 1522:1667 */         PdfPCell cell33 = new PdfPCell(new Paragraph(
/* 1523:1668 */           "Tax Amount", mainContent));
/* 1524:1669 */         cell33.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1525:1670 */         cell33.setBorderWidth(0.01F);
/* 1526:1671 */         cell33.setBorderColor(BaseColor.WHITE);
/* 1527:     */         
/* 1528:1673 */         PdfPCell cell34 = new PdfPCell(new Paragraph(
/* 1529:1674 */           this.resultSet
/* 1530:1675 */           .getString("SALES_TAX_AMOUNT"), 
/* 1531:1676 */           mainContent));
/* 1532:1677 */         cell34.setBorderWidth(0.2F);
/* 1533:1678 */         cell34.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1534:     */         
/* 1535:     */ 
/* 1536:     */ 
/* 1537:     */ 
/* 1538:     */ 
/* 1539:     */ 
/* 1540:     */ 
/* 1541:     */ 
/* 1542:     */ 
/* 1543:     */ 
/* 1544:     */ 
/* 1545:     */ 
/* 1546:     */ 
/* 1547:     */ 
/* 1548:     */ 
/* 1549:     */ 
/* 1550:     */ 
/* 1551:     */ 
/* 1552:     */ 
/* 1553:     */ 
/* 1554:     */ 
/* 1555:     */ 
/* 1556:     */ 
/* 1557:     */ 
/* 1558:     */ 
/* 1559:     */ 
/* 1560:     */ 
/* 1561:     */ 
/* 1562:     */ 
/* 1563:     */ 
/* 1564:     */ 
/* 1565:     */ 
/* 1566:     */ 
/* 1567:     */ 
/* 1568:     */ 
/* 1569:     */ 
/* 1570:     */ 
/* 1571:     */ 
/* 1572:     */ 
/* 1573:     */ 
/* 1574:     */ 
/* 1575:     */ 
/* 1576:     */ 
/* 1577:     */ 
/* 1578:     */ 
/* 1579:     */ 
/* 1580:     */ 
/* 1581:     */ 
/* 1582:     */ 
/* 1583:     */ 
/* 1584:     */ 
/* 1585:     */ 
/* 1586:     */ 
/* 1587:     */ 
/* 1588:     */ 
/* 1589:     */ 
/* 1590:     */ 
/* 1591:     */ 
/* 1592:     */ 
/* 1593:     */ 
/* 1594:     */ 
/* 1595:     */ 
/* 1596:     */ 
/* 1597:     */ 
/* 1598:     */ 
/* 1599:     */ 
/* 1600:     */ 
/* 1601:     */ 
/* 1602:     */ 
/* 1603:     */ 
/* 1604:     */ 
/* 1605:     */ 
/* 1606:     */ 
/* 1607:     */ 
/* 1608:     */ 
/* 1609:     */ 
/* 1610:     */ 
/* 1611:     */ 
/* 1612:     */ 
/* 1613:     */ 
/* 1614:     */ 
/* 1615:     */ 
/* 1616:     */ 
/* 1617:     */ 
/* 1618:     */ 
/* 1619:     */ 
/* 1620:     */ 
/* 1621:     */ 
/* 1622:     */ 
/* 1623:     */ 
/* 1624:     */ 
/* 1625:     */ 
/* 1626:     */ 
/* 1627:     */ 
/* 1628:     */ 
/* 1629:     */ 
/* 1630:     */ 
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
/* 1660:     */ 
/* 1661:     */ 
/* 1662:     */ 
/* 1663:     */ 
/* 1664:     */ 
/* 1665:     */ 
/* 1666:     */ 
/* 1667:     */ 
/* 1668:     */ 
/* 1669:     */ 
/* 1670:     */ 
/* 1671:     */ 
/* 1672:     */ 
/* 1673:1818 */         table.addCell(cell);
/* 1674:1819 */         table.addCell(cell1);
/* 1675:1820 */         table.addCell(cell2);
/* 1676:1821 */         table.addCell(cell3);
/* 1677:1822 */         table.addCell(cell4);
/* 1678:1823 */         table.addCell(cell5);
/* 1679:1824 */         table.addCell(cell6);
/* 1680:1825 */         table.addCell(cell7);
/* 1681:1826 */         table.addCell(cell8);
/* 1682:1827 */         table.addCell(cell9);
/* 1683:1828 */         table.addCell(cell10);
/* 1684:     */         
/* 1685:     */ 
/* 1686:1831 */         table.addCell(cell13);
/* 1687:1832 */         table.addCell(cell14);
/* 1688:1833 */         table.addCell(cell15);
/* 1689:1834 */         table.addCell(cell16);
/* 1690:1835 */         table.addCell(cell17);
/* 1691:1836 */         table.addCell(cell18);
/* 1692:1837 */         table.addCell(cell19);
/* 1693:1838 */         table.addCell(cell20);
/* 1694:1839 */         table.addCell(cell21);
/* 1695:1840 */         table.addCell(cell22);
/* 1696:1841 */         table.addCell(cell23);
/* 1697:1842 */         table.addCell(cell24);
/* 1698:1843 */         table.addCell(cell25);
/* 1699:1844 */         table.addCell(cell26);
/* 1700:1845 */         table.addCell(cell27);
/* 1701:1846 */         table.addCell(cell28);
/* 1702:1847 */         table.addCell(cell29);
/* 1703:1848 */         table.addCell(cell30);
/* 1704:1849 */         table.addCell(cell31);
/* 1705:1850 */         table.addCell(cell32);
/* 1706:1851 */         table.addCell(cell33);
/* 1707:1852 */         table.addCell(cell34);
/* 1708:     */         
/* 1709:     */ 
/* 1710:     */ 
/* 1711:     */ 
/* 1712:     */ 
/* 1713:     */ 
/* 1714:     */ 
/* 1715:     */ 
/* 1716:     */ 
/* 1717:     */ 
/* 1718:     */ 
/* 1719:     */ 
/* 1720:     */ 
/* 1721:     */ 
/* 1722:     */ 
/* 1723:     */ 
/* 1724:     */ 
/* 1725:     */ 
/* 1726:     */ 
/* 1727:     */ 
/* 1728:     */ 
/* 1729:     */ 
/* 1730:     */ 
/* 1731:     */ 
/* 1732:     */ 
/* 1733:     */ 
/* 1734:     */ 
/* 1735:     */ 
/* 1736:1881 */         document.add(table);
/* 1737:     */       }
/* 1738:1885 */       document.add(new Paragraph("\n"));
/* 1739:     */       
/* 1740:     */ 
/* 1741:     */ 
/* 1742:1889 */       document.close();
/* 1743:     */     }
/* 1744:     */     catch (SQLException sqlExp)
/* 1745:     */     {
/* 1746:1892 */       sqlExp.printStackTrace();
/* 1747:1893 */       this.logger.error(
/* 1748:1894 */         InvoiceSaleDaoImpl.class + 
/* 1749:1895 */         "Error: Occur in Query While Fetching All Sales Details for print PdF from Database.", 
/* 1750:1896 */         sqlExp);
/* 1751:     */     }
/* 1752:     */     catch (Exception exception)
/* 1753:     */     {
/* 1754:1898 */       exception.printStackTrace();
/* 1755:1899 */       this.logger.error(
/* 1756:1900 */         InvoiceSaleDaoImpl.class + 
/* 1757:1901 */         "Error: Occur in Query While Closing Connection After Fetching All Sales Details for print PdF from Database.", 
/* 1758:1902 */         exception);
/* 1759:     */     }
/* 1760:     */     finally
/* 1761:     */     {
/* 1762:1904 */       JdbcHelper.closeResultSet(this.resultSet);
/* 1763:1905 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/* 1764:1906 */       JdbcHelper.closeConnection(this.connection);
/* 1765:     */     }
/* 1766:     */   }
/* 1767:     */   
/* 1768:     */   public void salesItemPrintPDF() {}
/* 1769:     */   
/* 1770:     */   public List<InvoiceSaleVO> retriveSalesDetailsForAdvanceSearch(int searchId, String searchValue)
/* 1771:     */     throws RecordNotFoundException
/* 1772:     */   {
/* 1773:1917 */     List<InvoiceSaleVO> salesDetailList = new ArrayList();
/* 1774:     */     try
/* 1775:     */     {
/* 1776:1921 */       this.connection = getConnection();
/* 1777:     */       
/* 1778:1923 */       this.preparedStatement = this.connection
/* 1779:1924 */         .prepareStatement(QueryBuilder.InvoiceSalesAdvanceSearchForAdmin(searchId, searchValue));
/* 1780:     */       
/* 1781:     */ 
/* 1782:1927 */       this.resultSet = this.preparedStatement.executeQuery();
/* 1783:1931 */       while (this.resultSet.next())
/* 1784:     */       {
/* 1785:1932 */         this.saleVO = new InvoiceSaleVO();
/* 1786:1933 */         this.saleVO.setSalesId(this.resultSet.getInt("SALES_ID"));
/* 1787:1935 */         if (this.resultSet.getString("SALES_CUSTOMER_TYPE").equals("Retailer"))
/* 1788:     */         {
/* 1789:1936 */           this.saleVO.setFullName(this.nameHelper.getRegularCustomerNameById(this.resultSet.getInt("SALES_CUSTOMER_ID_REF")));
/* 1790:1937 */           this.saleVO.setPhoneNo(this.resultSet.getString("SALES_CUSTOMER_PHONE"));
/* 1791:1938 */           this.saleVO.setCustomerId(this.resultSet.getInt("SALES_CUSTOMER_ID_REF"));
/* 1792:1939 */           this.saleVO.setAddress(this.resultSet
/* 1793:1940 */             .getString("SALES_CUSTOMER_ADREESS"));
/* 1794:     */         }
/* 1795:1941 */         else if (this.resultSet.getString("SALES_CUSTOMER_TYPE").equals("Consumer"))
/* 1796:     */         {
/* 1797:1942 */           this.saleVO.setFullName(this.nameHelper.getConsumerCustomerNameById(this.resultSet.getInt("SALES_CUSTOMER_ID_REF")));
/* 1798:1943 */           this.saleVO.setCustomerId(this.resultSet.getInt("SALES_CUSTOMER_ID_REF"));
/* 1799:1944 */           this.saleVO.setPhoneNo(this.resultSet.getString("SALES_CUSTOMER_PHONE"));
/* 1800:     */           
/* 1801:1946 */           this.saleVO.setAddress(this.resultSet
/* 1802:1947 */             .getString("SALES_CUSTOMER_ADREESS"));
/* 1803:     */         }
/* 1804:1951 */         this.saleVO.setItemPrice(this.resultSet
/* 1805:1952 */           .getString("SALES_ITEM_PRICE"));
/* 1806:     */         
/* 1807:1954 */         this.saleVO.setCustomerType(this.resultSet
/* 1808:1955 */           .getString("SALES_CUSTOMER_TYPE"));
/* 1809:     */         
/* 1810:1957 */         this.saleVO.setTotal(this.resultSet
/* 1811:1958 */           .getFloat("SALES_ITEM_TOTAL"));
/* 1812:     */         
/* 1813:     */ 
/* 1814:1961 */         this.saleVO.setSubTotal(this.resultSet
/* 1815:1962 */           .getFloat("SALES_ITEM_SUBTOTAL"));
/* 1816:     */         
/* 1817:1964 */         this.saleVO.setDiscount(this.resultSet
/* 1818:1965 */           .getFloat("SALES_ITEM_DISCOUNT"));
/* 1819:     */         
/* 1820:1967 */         this.saleVO.setPaymentMode(this.nameHelper.getPaymentModeById(this.resultSet
/* 1821:1968 */           .getInt("SALES_PAYMENT_MODE")));
/* 1822:1969 */         this.saleVO.setPaymentAnswer(this.resultSet.getString("SALES_PAYMENT_ANSWER"));
/* 1823:     */         
/* 1824:1971 */         this.saleVO.setNetTotal(this.resultSet
/* 1825:1972 */           .getFloat("SALES_ITEM_NET_TOTAL"));
/* 1826:     */         
/* 1827:1974 */         this.saleVO.setItemName(this.nameHelper.getProductNameById(this.resultSet
/* 1828:1975 */           .getInt("SALES_ITEM_ID")));
/* 1829:     */         
/* 1830:     */ 
/* 1831:1978 */         this.saleVO.setItemQuantity(this.resultSet
/* 1832:1979 */           .getString("SALES_ITEM_QUANTITY"));
/* 1833:1980 */         this.saleVO.setItemTax(this.resultSet
/* 1834:1981 */           .getString("SALES_ITEM_TAX"));
/* 1835:1982 */         this.saleVO.setAmount(this.resultSet
/* 1836:1983 */           .getString("SALES_ITEM_AMOUNT"));
/* 1837:1984 */         this.saleVO.setSalesDate(this.resultSet
/* 1838:1985 */           .getString("SALES_DATE"));
/* 1839:1986 */         salesDetailList.add(this.saleVO);
/* 1840:     */       }
/* 1841:     */     }
/* 1842:     */     catch (SQLException sqlExp)
/* 1843:     */     {
/* 1844:1990 */       sqlExp.printStackTrace();
/* 1845:1991 */       this.logger.error(
/* 1846:1992 */         InvoiceSaleDaoImpl.class + 
/* 1847:1993 */         "Error: Occur in Query While Fetching the sales Details For Search from Database.", 
/* 1848:1994 */         sqlExp);
/* 1849:     */     }
/* 1850:     */     catch (Exception exception)
/* 1851:     */     {
/* 1852:1996 */       exception.printStackTrace();
/* 1853:1997 */       this.logger.error(
/* 1854:1998 */         InvoiceSaleDaoImpl.class + 
/* 1855:1999 */         "Error: Occur in Query While Closing Connection After Fetching the sales Details For Search from Database.", 
/* 1856:2000 */         exception);
/* 1857:     */     }
/* 1858:     */     finally
/* 1859:     */     {
/* 1860:2002 */       JdbcHelper.closeResultSet(this.resultSet);
/* 1861:2003 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/* 1862:2004 */       JdbcHelper.closeConnection(this.connection);
/* 1863:     */     }
/* 1864:2006 */     return salesDetailList;
/* 1865:     */   }
/* 1866:     */   
/* 1867:     */   public int getSalesLastRecord()
/* 1868:     */     throws RecordNotFoundException
/* 1869:     */   {
/* 1870:2012 */     int temp = 0;
/* 1871:     */     try
/* 1872:     */     {
/* 1873:2014 */       this.connection = getConnection();
/* 1874:     */       
/* 1875:2016 */       this.preparedStatement = this.connection
/* 1876:2017 */         .prepareStatement("SELECT  SALES_ID FROM TAB_SALES_DETAILS ORDER BY SALES_ID DESC LIMIT 1");
/* 1877:     */       
/* 1878:     */ 
/* 1879:2020 */       this.resultSet = this.preparedStatement.executeQuery();
/* 1880:2021 */       if (this.resultSet != null) {
/* 1881:2022 */         while (this.resultSet.next()) {
/* 1882:2024 */           temp = this.resultSet.getInt("SALES_ID");
/* 1883:     */         }
/* 1884:     */       }
/* 1885:     */     }
/* 1886:     */     catch (SQLException sqlException)
/* 1887:     */     {
/* 1888:2029 */       sqlException.printStackTrace();
/* 1889:2030 */       this.logger.error(
/* 1890:2031 */         PurchaseCementDaoImpl.class + 
/* 1891:2032 */         ": Error:- Error: Occur in Query While counting the Sales details recods from Database", 
/* 1892:2033 */         sqlException);
/* 1893:     */     }
/* 1894:     */     catch (Exception exception)
/* 1895:     */     {
/* 1896:2036 */       exception.printStackTrace();
/* 1897:2037 */       this.logger.error(
/* 1898:2038 */         PurchaseCementDaoImpl.class + 
/* 1899:2039 */         ": Error:- While closing the Connection after counting the Sales details recods from Database", 
/* 1900:2040 */         exception);
/* 1901:     */     }
/* 1902:     */     finally
/* 1903:     */     {
/* 1904:2042 */       JdbcHelper.closeResultSet(this.resultSet);
/* 1905:2043 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/* 1906:2044 */       JdbcHelper.closeConnection(this.connection);
/* 1907:     */     }
/* 1908:2046 */     return temp;
/* 1909:     */   }
/* 1910:     */   
/* 1911:     */   public InvoiceSale getSalesDetails(int salesId)
/* 1912:     */     throws RecordNotFoundException
/* 1913:     */   {
/* 1914:2053 */     InvoiceSale invoiceSale = new InvoiceSale();
/* 1915:     */     try
/* 1916:     */     {
/* 1917:2056 */       this.connection = getConnection();
/* 1918:     */       
/* 1919:     */ 
/* 1920:2059 */       this.preparedStatement = this.connection
/* 1921:2060 */         .prepareStatement("SELECT * FROM TAB_SALES_DETAILS WHERE SALES_ID=?");
/* 1922:2061 */       this.preparedStatement.setInt(1, salesId);
/* 1923:     */       
/* 1924:2063 */       this.resultSet = this.preparedStatement.executeQuery();
/* 1925:2064 */       System.out.println("----------hye ----------------");
/* 1926:2065 */       if (this.resultSet != null) {
/* 1927:2066 */         while (this.resultSet.next())
/* 1928:     */         {
/* 1929:2068 */           System.out.println("----------hye ----------------");
/* 1930:     */           
/* 1931:2070 */           invoiceSale.setSalesId(this.resultSet.getInt("SALES_ID"));
/* 1932:2071 */           System.out.println("________________" + this.resultSet.getInt("SALES_ID"));
/* 1933:     */           
/* 1934:2073 */           invoiceSale.setFullName(this.nameHelper.getRegularCustomerNameById(this.resultSet.getInt("SALES_CUSTOMER_ID_REF")));
/* 1935:2074 */           System.out.println("---------" + this.resultSet.getString("SALES_CUSTOMER_FULLNAME"));
/* 1936:     */           
/* 1937:2076 */           invoiceSale.setCustomerId(this.resultSet
/* 1938:2077 */             .getInt("SALES_CUSTOMER_ID_REF"));
/* 1939:     */           
/* 1940:     */ 
/* 1941:2080 */           invoiceSale.setPhoneNo(this.resultSet
/* 1942:2081 */             .getString("SALES_CUSTOMER_PHONE"));
/* 1943:     */           
/* 1944:2083 */           invoiceSale.setAddress(this.resultSet
/* 1945:2084 */             .getString("SALES_CUSTOMER_ADREESS"));
/* 1946:     */           
/* 1947:2086 */           invoiceSale.setSalesDate(this.resultSet
/* 1948:2087 */             .getString("SALES_DATE"));
/* 1949:     */           
/* 1950:2089 */           invoiceSale.setItemId(this.resultSet
/* 1951:2090 */             .getString("SALES_ITEM_ID"));
/* 1952:     */           
/* 1953:2092 */           invoiceSale.setItemDescription(this.resultSet.getString("SALES_ITEM_DISCRIPTION"));
/* 1954:     */           
/* 1955:2094 */           invoiceSale.setItemQuantity(this.resultSet.getString("SALES_ITEM_QUANTITY"));
/* 1956:     */           
/* 1957:2096 */           invoiceSale.setItemPrice(this.resultSet.getString("SALES_ITEM_PRICE"));
/* 1958:     */           
/* 1959:2098 */           invoiceSale.setItemTax(this.resultSet.getString("SALES_ITEM_TAX"));
/* 1960:     */           
/* 1961:2100 */           invoiceSale.setAmount(this.resultSet
/* 1962:2101 */             .getString("SALES_ITEM_AMOUNT"));
/* 1963:     */           
/* 1964:2103 */           invoiceSale.setSubTotal(this.resultSet
/* 1965:2104 */             .getFloat("SALES_ITEM_SUBTOTAL"));
/* 1966:     */           
/* 1967:     */ 
/* 1968:     */ 
/* 1969:2108 */           invoiceSale.setTotal(this.resultSet
/* 1970:2109 */             .getFloat("SALES_ITEM_TOTAL"));
/* 1971:2110 */           invoiceSale.setDiscount(this.resultSet
/* 1972:2111 */             .getFloat("SALES_ITEM_DISCOUNT"));
/* 1973:2112 */           invoiceSale.setNetTotal(this.resultSet
/* 1974:2113 */             .getFloat("SALES_ITEM_NET_TOTAL"));
/* 1975:     */         }
/* 1976:     */       }
/* 1977:     */     }
/* 1978:     */     catch (SQLException sqlExp)
/* 1979:     */     {
/* 1980:2122 */       sqlExp.printStackTrace();
/* 1981:2123 */       this.logger.error(
/* 1982:2124 */         InvoiceSaleDaoImpl.class + 
/* 1983:2125 */         "Error: Occur in Query While Fetching the specific sales Details from Database.", 
/* 1984:2126 */         sqlExp);
/* 1985:     */     }
/* 1986:     */     catch (Exception exception)
/* 1987:     */     {
/* 1988:2128 */       exception.printStackTrace();
/* 1989:2129 */       this.logger.error(
/* 1990:2130 */         InvoiceSaleDaoImpl.class + 
/* 1991:2131 */         "Error: Occur in Query While Closing Connection After Fetching the specific sales Details from Database.", 
/* 1992:2132 */         exception);
/* 1993:     */     }
/* 1994:     */     finally
/* 1995:     */     {
/* 1996:2134 */       JdbcHelper.closeResultSet(this.resultSet);
/* 1997:2135 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/* 1998:2136 */       JdbcHelper.closeConnection(this.connection);
/* 1999:     */     }
/* 2000:2140 */     return invoiceSale;
/* 2001:     */   }
/* 2002:     */   
/* 2003:     */   public void generateBillForSales(HttpServletRequest request, HttpServletResponse response, int lastRecord, int result)
/* 2004:     */   {
/* 2005:2147 */     float transportCharges = 0.0F;
/* 2006:2148 */     float payment = 0.0F;
/* 2007:2149 */     float due = 0.0F;
String companyName =null;
String mobNo =null;
if(result==1) {
/* 2008:2150 */      companyName = "Chouksay Traders";
mobNo="Mob. 9893475766, 9425641542 ";
}else if(result==2) {
	companyName = "Chouksay Brothers";
	mobNo="Mob. 9993083413";
}
/* 2009:2151 */     String address1 = "BUS STAND SHAMSHABAD, DIST.- VIDISHA, MADHYA PRADESH, 464001";
/* 2010:2152 */     String address2 = "GSTIN: 23AJQPC8200P1Z1";
/* 2011:2153 */     String address3 = "PAN NO: AJQPC8200P";
/* 2012:     */     
/* 2013:2155 */     String city = "Vidisha-464001";
/* 2014:2156 */     String state = "(M.P.)";
/* 2015:2157 */     StringBuffer stringBuffer = null;
/* 2016:     */     try
/* 2017:     */     {
/* 2018:2166 */       Document document = new Document(PageSize.A4);
/* 2019:2167 */       Font Font3 = new Font(Font.FontFamily.TIMES_ROMAN, 11.0F, 0);
/* 2020:2168 */       Font Font2 = new Font(Font.FontFamily.TIMES_ROMAN, 6.0F, 
/* 2021:2169 */         8);
/* 2022:2170 */       Font Font4 = new Font(Font.FontFamily.TIMES_ROMAN, 11.0F, 1);
/* 2023:2171 */       Font4.setColor(BaseColor.WHITE);
/* 2024:2172 */       Font mainContent = new Font(Font.FontFamily.TIMES_ROMAN, 10.0F, 
/* 2025:2173 */         0);
/* 2026:2174 */       Font Font5 = new Font(Font.FontFamily.TIMES_ROMAN, 12.0F, 1);
/* 2027:2175 */       Font5.setColor(BaseColor.GRAY);
/* 2028:2176 */       Font Font6 = new Font(Font.FontFamily.TIMES_ROMAN, 10.0F, 1);
/* 2029:2177 */       Font6.setColor(BaseColor.RED);
/* 2030:     */       
/* 2031:     */ 
/* 2032:2180 */       ServletOutputStream outStream = response.getOutputStream();
/* 2033:2181 */       response.setContentType("application/pdf");
/* 2034:     */       
/* 2035:2183 */       PdfWriter writer = PdfWriter.getInstance(document, outStream);
/* 2036:     */       
/* 2037:     */ 
/* 2038:2186 */       document.open();
/* 2039:     */       
/* 2040:     */ 
/* 2041:2189 */       PdfContentByte canvas = writer.getDirectContent();
/* 2042:     */       
/* 2043:     */ 
/* 2044:2192 */       canvas.moveTo(20.0F, 720.0F);
/* 2045:2193 */       canvas.lineTo(575.0F, 720.0F);
/* 2046:2194 */       canvas.moveTo(20.0F, 560.0F);
/* 2047:2195 */       canvas.lineTo(575.0F, 560.0F);
/* 2048:     */       
/* 2049:2197 */       canvas.moveTo(20.0F, 540.0F);
/* 2050:2198 */       canvas.lineTo(575.0F, 540.0F);
/* 2051:     */       
/* 2052:2200 */       canvas.moveTo(20.0F, 280.0F);
/* 2053:2201 */       canvas.lineTo(575.0F, 280.0F);
/* 2054:     */       
/* 2055:     */ 
/* 2056:     */ 
/* 2057:     */ 
/* 2058:2206 */       canvas.moveTo(20.0F, 260.0F);
/* 2059:2207 */       canvas.lineTo(575.0F, 260.0F);
/* 2060:     */       
/* 2061:2209 */       canvas.moveTo(20.0F, 240.0F);
/* 2062:2210 */       canvas.lineTo(575.0F, 240.0F);
/* 2063:     */       
/* 2064:2212 */       canvas.moveTo(20.0F, 120.0F);
/* 2065:2213 */       canvas.lineTo(575.0F, 120.0F);
/* 2066:     */       
/* 2067:2215 */       canvas.moveTo(20.0F, 80.0F);
/* 2068:2216 */       canvas.lineTo(575.0F, 80.0F);
/* 2069:     */       
/* 2070:     */ 
/* 2071:2219 */       canvas.moveTo(20.0F, 40.0F);
/* 2072:2220 */       canvas.lineTo(575.0F, 40.0F);
/* 2073:     */       
/* 2074:2222 */       canvas.moveTo(20.0F, 220.0F);
/* 2075:2223 */       canvas.lineTo(575.0F, 220.0F);
/* 2076:     */       
/* 2077:2225 */       canvas.moveTo(300.5F, 720.0F);
/* 2078:2226 */       canvas.lineTo(300.5F, 560.0F);
/* 2079:     */       
/* 2080:2228 */       canvas.moveTo(433.0F, 560.0F);
/* 2081:2229 */       canvas.lineTo(433.0F, 260.0F);
/* 2082:     */       
/* 2083:2231 */       canvas.moveTo(380.0F, 560.0F);
/* 2084:2232 */       canvas.lineTo(380.0F, 260.0F);
/* 2085:     */       
/* 2086:2234 */       canvas.moveTo(305.0F, 560.0F);
/* 2087:2235 */       canvas.lineTo(305.0F, 260.0F);
/* 2088:     */       
/* 2089:2237 */       canvas.moveTo(250.0F, 560.0F);
/* 2090:2238 */       canvas.lineTo(250.0F, 260.0F);
/* 2091:     */       
/* 2092:2240 */       canvas.moveTo(200.0F, 560.0F);
/* 2093:2241 */       canvas.lineTo(200.0F, 260.0F);
/* 2094:     */       
/* 2095:2243 */       canvas.moveTo(485.0F, 560.0F);
/* 2096:2244 */       canvas.lineTo(485.0F, 260.0F);
/* 2097:2245 */       canvas.closePathStroke();
/* 2098:2246 */       Rectangle rect = new Rectangle(20.0F, 20.0F, 575.0F, 820.0F);
/* 2099:2247 */       rect.setBorder(15);
/* 2100:2248 */       rect.setBorderWidth(1.0F);
/* 2101:2249 */       canvas.rectangle(rect);
/* 2102:2250 */       String contextPath = ServletActionContext.getServletContext()
/* 2103:2251 */         .getRealPath("/outer/img/rohittraders.png");
/* 2104:2252 */       this.image = Image.getInstance(contextPath);
/* 2105:2253 */       this.image.scaleToFit(130.0F, 70.0F);
/* 2106:     */       
/* 2107:2255 */       PdfPTable table1 = new PdfPTable(2);
/* 2108:2256 */       table1.setWidthPercentage(100.0F);
/* 2109:2257 */       Rectangle rect1 = new Rectangle(300.0F, 700.0F);
/* 2110:2258 */       table1.setWidthPercentage(new float[] { 150.0F, 150.0F }, rect1);
/* 2111:     */       
/* 2112:2260 */       PdfPCell cell101 = new PdfPCell(this.image, false);
/* 2113:2261 */       cell101.setPaddingTop(5.0F);
/* 2114:2262 */       cell101.setBorder(0);
/* 2115:     */       
/* 2116:2264 */       Phrase phrase3 = new Phrase(companyName + "\n", Font5);
/* 2117:2265 */       Phrase phrase = new Phrase(address1 + "\n", Font3);
/* 2118:2266 */       Phrase phrase1 = new Phrase(address2 + "\n", Font3);
Phrase phraseMob = new Phrase(mobNo + "\n", Font3);
/* 2119:2267 */       Phrase phrase4 = new Phrase(address3 + "\n", Font3);
/* 2120:2268 */       Phrase phrase2 = new Phrase(city + "-" + state, Font3);
/* 2121:     */       
/* 2122:2270 */       Paragraph paragraph = new Paragraph();
/* 2123:2271 */       paragraph.add(phrase3);
/* 2124:2272 */       paragraph.add(phrase);
/* 2125:2273 */       paragraph.add(phrase1);
paragraph.add(phraseMob);
/* 2126:2274 */       paragraph.add(phrase4);
/* 2127:2275 */       paragraph.add(phrase2);
/* 2128:     */       
/* 2129:2277 */       PdfPCell cell102 = new PdfPCell(paragraph);
/* 2130:2278 */       cell102.setPaddingTop(5.0F);
/* 2131:2279 */       cell102.setBorder(0);
/* 2132:2280 */       cell102.setHorizontalAlignment(2);
/* 2133:     */       
/* 2134:2282 */       PdfPCell cell103 = new PdfPCell(
/* 2135:2283 */         new Paragraph(
/* 2136:2284 */         "   \n                                                                                                                                                                                                                                                                                                                                                  ", 
/* 2137:     */         
/* 2138:     */ 
/* 2139:2287 */         Font2));
/* 2140:2288 */       cell103.setColspan(2);
/* 2141:2289 */       cell103.setBorderWidthRight(0.0F);
/* 2142:2290 */       cell103.setBorderWidthLeft(0.0F);
/* 2143:2291 */       cell103.setBorderWidthTop(0.5F);
/* 2144:2292 */       cell103.setBorderWidthBottom(0.0F);
/* 2145:2293 */       cell103.setBorderColorTop(BaseColor.WHITE);
/* 2146:     */       
/* 2147:     */ 
/* 2148:     */ 
/* 2149:     */ 
/* 2150:     */ 
/* 2151:     */ 
/* 2152:     */ 
/* 2153:     */ 
/* 2154:     */ 
/* 2155:     */ 
/* 2156:     */ 
/* 2157:2305 */       table1.addCell(cell101);
/* 2158:2306 */       table1.addCell(cell102);
/* 2159:2307 */       table1.addCell(cell103);
/* 2160:     */       
/* 2161:     */ 
/* 2162:2310 */       String custType = null;
/* 2163:2311 */       int custRef = 0;
/* 2164:2312 */       float dis = 0.0F;
/* 2165:2313 */       Connection conSaleDetail = null;
/* 2166:2314 */       PreparedStatement preSaleDetail = null;
/* 2167:     */       
/* 2168:     */ 
/* 2169:2317 */       String queryFromSaleDetail = "SELECT * FROM TAB_SALES_DETAILS WHERE SALES_ID=?";
/* 2170:2318 */       conSaleDetail = getConnection();
/* 2171:2319 */       preSaleDetail = conSaleDetail
/* 2172:2320 */         .prepareStatement(queryFromSaleDetail);
/* 2173:2321 */       preSaleDetail.setInt(1, lastRecord);
/* 2174:     */       
/* 2175:     */ 
/* 2176:     */ 
/* 2177:     */ 
/* 2178:     */ 
/* 2179:     */ 
/* 2180:     */ 
/* 2181:     */ 
/* 2182:     */ 
/* 2183:2331 */       ResultSet rsSaleDetail = preSaleDetail.executeQuery();
/* 2184:2332 */       while (rsSaleDetail.next())
/* 2185:     */       {
/* 2186:2333 */         custType = rsSaleDetail.getString("SALES_CUSTOMER_TYPE");
/* 2187:2334 */         custRef = rsSaleDetail.getInt("SALES_CUSTOMER_ID_REF");
/* 2188:2335 */         System.out.println("custType" + custType + "custRef" + custRef);
/* 2189:2336 */         dis = rsSaleDetail.getFloat("SALES_ITEM_DISCOUNT");
/* 2190:2337 */         PdfPTable table4 = new PdfPTable(2);
/* 2191:     */         
/* 2192:2339 */         table4.setHorizontalAlignment(0);
/* 2193:2340 */         table4.setWidthPercentage(50.0F);
/* 2194:     */         
/* 2195:2342 */         PdfPCell cell29 = new PdfPCell(new Phrase(" Invoice No:", mainContent));
/* 2196:2343 */         cell29.setBackgroundColor(BaseColor.WHITE);
/* 2197:     */         
/* 2198:2345 */         cell29.setBorderWidth(1.0F);
/* 2199:     */         
/* 2200:2347 */         PdfPCell cell31 = new PdfPCell(new Phrase(rsSaleDetail.getString("SALES_ID"), mainContent));
/* 2201:     */         
/* 2202:2349 */         cell31.setBorderWidth(1.0F);
/* 2203:     */         
/* 2204:     */ 
/* 2205:2352 */         transportCharges = rsSaleDetail.getFloat("TRANSPORT_CHARGES");
/* 2206:2353 */         payment = rsSaleDetail.getFloat("SALES_PAYMENT");
/* 2207:2354 */         float net = rsSaleDetail.getFloat("SALES_ITEM_NET_TOTAL");
/* 2208:2355 */         due = net - payment;
/* 2209:2356 */         PdfPCell cell32 = new PdfPCell(new Phrase(" Date:", mainContent));
/* 2210:2357 */         cell32.setBackgroundColor(BaseColor.WHITE);
/* 2211:     */         
/* 2212:2359 */         cell32.setBorderWidth(1.0F);
/* 2213:     */         
/* 2214:2361 */         PdfPCell cell33 = new PdfPCell(new Phrase(rsSaleDetail.getString("SALES_DATE"), mainContent));
/* 2215:     */         
/* 2216:2363 */         cell33.setBorderWidth(1.0F);
/* 2217:     */         
/* 2218:2365 */         PdfPCell cell34 = new PdfPCell(new Phrase(" Order No.:", mainContent));
/* 2219:2366 */         cell34.setBackgroundColor(BaseColor.WHITE);
/* 2220:     */         
/* 2221:2368 */         cell34.setBorderWidth(1.0F);
/* 2222:     */         
/* 2223:2370 */         PdfPCell cell35 = new PdfPCell(new Phrase(" ", mainContent));
/* 2224:     */         
/* 2225:2372 */         cell35.setBorderWidth(1.0F);
/* 2226:     */         
/* 2227:2374 */         PdfPCell cell36 = new PdfPCell(new Phrase(" Place of Supply:", mainContent));
/* 2228:2375 */         cell36.setBackgroundColor(BaseColor.WHITE);
/* 2229:     */         
/* 2230:2377 */         cell36.setBorderWidth(1.0F);
/* 2231:     */         
/* 2232:2379 */         PdfPCell cell37 = new PdfPCell(new Phrase("Vidisha", mainContent));
/* 2233:     */         
/* 2234:2381 */         cell37.setBorderWidth(1.0F);
/* 2235:     */         
/* 2236:2383 */         PdfPCell cell38 = new PdfPCell(new Phrase(" Material Code/Name:", mainContent));
/* 2237:2384 */         cell38.setBackgroundColor(BaseColor.WHITE);
/* 2238:     */         
/* 2239:2386 */         cell38.setBorderWidth(1.0F);
/* 2240:     */         
/* 2241:2388 */         PdfPCell cell39 = new PdfPCell(new Phrase(" ", mainContent));
/* 2242:     */         
/* 2243:2390 */         cell39.setBorderWidth(1.0F);
/* 2244:     */         
/* 2245:2392 */         PdfPCell cell40 = new PdfPCell(new Phrase(" HSN Code:", mainContent));
/* 2246:2393 */         cell40.setBackgroundColor(BaseColor.WHITE);
/* 2247:     */         
/* 2248:2395 */         cell40.setBorderWidth(1.0F);
/* 2249:     */         
/* 2250:2397 */         PdfPCell cell41 = new PdfPCell(new Phrase(" ", mainContent));
/* 2251:     */         
/* 2252:2399 */         cell41.setBorderWidth(1.0F);
/* 2253:     */         
/* 2254:     */ 
/* 2255:2402 */         table4.addCell(cell29);
/* 2256:2403 */         table4.addCell(cell31);
/* 2257:2404 */         table4.addCell(cell32);
/* 2258:2405 */         table4.addCell(cell33);
/* 2259:2406 */         table4.addCell(cell34);
/* 2260:2407 */         table4.addCell(cell35);
/* 2261:2408 */         table4.addCell(cell36);
/* 2262:2409 */         table4.addCell(cell37);
/* 2263:2410 */         table4.addCell(cell38);
/* 2264:2411 */         table4.addCell(cell39);
/* 2265:2412 */         table4.addCell(cell40);
/* 2266:2413 */         table4.addCell(cell41);
/* 2267:     */         
/* 2268:     */ 
/* 2269:2416 */         table4.setTotalWidth(250.0F);
/* 2270:2417 */         table4.setWidths(new float[] { 2.0F, 3.0F });
/* 2271:2418 */         PdfContentByte canvas4 = writer.getDirectContent();
/* 2272:2419 */         table4.writeSelectedRows(0, -1, 306.0F, 715.0F, canvas4);
/* 2273:     */       }
/* 2274:2426 */       float netAmount = 0.0F;
/* 2275:2427 */       float gstAmount = 0.0F;
/* 2276:     */       
/* 2277:     */ 
/* 2278:2430 */       String queryFromSale = "SELECT * FROM TAB_SALES_ITEMS WHERE REF_SALES_ID=?";
/* 2279:2431 */       this.connection = getConnection();
/* 2280:2432 */       this.preparedStatement = this.connection
/* 2281:2433 */         .prepareStatement(queryFromSale);
/* 2282:2434 */       this.preparedStatement.setInt(1, lastRecord);
/* 2283:     */       
/* 2284:     */ 
/* 2285:     */ 
/* 2286:     */ 
/* 2287:     */ 
/* 2288:     */ 
/* 2289:     */ 
/* 2290:     */ 
/* 2291:     */ 
/* 2292:2444 */       this.resultSet = this.preparedStatement.executeQuery();
/* 2293:     */       
/* 2294:     */ 
/* 2295:2447 */       PdfPTable table6 = new PdfPTable(7);
/* 2296:     */       
/* 2297:2449 */       table6.setHorizontalAlignment(2);
/* 2298:2450 */       table6.setWidthPercentage(100.0F);
/* 2299:2451 */       while (this.resultSet.next())
/* 2300:     */       {
	
/* 2301:2452 */         PdfPCell cell75 = new PdfPCell(new Phrase(this.nameHelper.getProductTypeNameByProductId(Integer.parseInt(this.nameHelper.getProductNameById(this.resultSet.getInt("SALES_ITEM_REF")))), mainContent));
/* 2302:     */        
/* 2303:     */ 
/* 2304:2455 */         cell75.setBorderWidth(1.0F);
/* 2305:2456 */         cell75.setHorizontalAlignment(0);
/* 2306:     */         
/* 2307:2458 */         float quant = this.resultSet.getFloat("SALES_ITEM_QUANTITY");
/* 2308:2459 */         float price = this.resultSet.getFloat("SALES_ITEM_PRICE");
/* 2309:2460 */         float tax = Float.parseFloat(this.nameHelper.getTaxValueById(this.resultSet.getInt("SALES_ITEM_TAX")));
/* 2310:2461 */         float cal = 100.0F / (100.0F + tax);
/* 2311:2462 */         gstAmount = price * quant * cal;
/* 2312:2463 */         DecimalFormat df = new DecimalFormat("####.##");
/* 2313:2464 */         double gstUnitPrice = price * cal;
/* 2314:2465 */         float total = price * quant;
/* 2315:     */         
/* 2316:2467 */         float gstinRs = total - gstAmount;
/* 2317:2468 */         netAmount += total;
/* 2318:2469 */         System.out.println(cal + " biil info  " + gstAmount);
/* 2319:     */         
/* 2320:2471 */         PdfPCell cell70 = new PdfPCell(new Phrase(this.resultSet.getString("SALES_ITEM_QUANTITY"), mainContent));
/* 2321:     */         
/* 2322:2473 */         cell70.setBorderWidth(1.0F);
/* 2323:2474 */         cell70.setHorizontalAlignment(2);
/* 2324:     */         
/* 2325:     */ 
/* 2326:     */ 
/* 2327:2478 */         PdfPCell cell71 = new PdfPCell(new Phrase(String.valueOf(df.format(gstUnitPrice)), mainContent));
/* 2328:     */         
/* 2329:2480 */         cell71.setBorderWidth(1.0F);
/* 2330:2481 */         cell71.setHorizontalAlignment(2);
/* 2331:     */         
/* 2332:2483 */         PdfPCell cell72 = new PdfPCell(new Phrase(String.valueOf(df.format(gstAmount)), mainContent));
/* 2333:     */         
/* 2334:2485 */         cell72.setBorderWidth(1.0F);
/* 2335:2486 */         cell72.setHorizontalAlignment(2);
/* 2336:     */         
/* 2337:2488 */         PdfPCell cell73 = new PdfPCell(new Phrase(this.nameHelper.getTaxValueById(this.resultSet.getInt("SALES_ITEM_TAX")) + "   %", mainContent));
/* 2338:     */         
/* 2339:2490 */         cell73.setBorderWidth(1.0F);
/* 2340:2491 */         cell73.setHorizontalAlignment(0);
/* 2341:     */         
/* 2342:2493 */         PdfPCell cell74 = new PdfPCell(new Phrase(String.valueOf(df.format(gstinRs)), mainContent));
/* 2343:     */         
/* 2344:2495 */         cell74.setBorderWidth(1.0F);
/* 2345:2496 */         cell74.setHorizontalAlignment(0);
/* 2346:     */         
/* 2347:2498 */         PdfPCell cell76 = new PdfPCell(new Phrase(String.valueOf(total), mainContent));
/* 2348:     */         
/* 2349:2500 */         cell76.setBorderWidth(1.0F);
/* 2350:2501 */         cell76.setHorizontalAlignment(2);
/* 2351:     */         
/* 2352:     */ 
/* 2353:     */ 
/* 2354:     */ 
/* 2355:     */ 
/* 2356:     */ 
/* 2357:     */ 
/* 2358:     */ 
/* 2359:     */ 
/* 2360:     */ 
/* 2361:     */ 
/* 2362:     */ 
/* 2363:     */ 
/* 2364:     */ 
/* 2365:     */ 
/* 2366:     */ 
/* 2367:     */ 
/* 2368:2519 */         table6.addCell(cell75);
/* 2369:2520 */         table6.addCell(cell70);
/* 2370:2521 */         table6.addCell(cell71);
/* 2371:2522 */         table6.addCell(cell72);
/* 2372:2523 */         table6.addCell(cell73);
/* 2373:2524 */         table6.addCell(cell74);
/* 2374:     */         
/* 2375:2526 */         table6.addCell(cell76);
/* 2376:     */       }
/* 2377:2541 */       table6.setTotalWidth(545.0F);
/* 2378:2542 */       table6.setWidths(new float[] { 3.2F, 1.0F, 1.0F, 1.45F, 1.0F, 1.0F, 1.6F });
/* 2379:2543 */       PdfContentByte canvas6 = writer.getDirectContent();
/* 2380:2544 */       table6.writeSelectedRows(0, -1, 25.0F, 525.0F, canvas6);
/* 2381:     */       
/* 2382:     */ 
/* 2383:     */ 
/* 2384:     */ 
/* 2385:     */ 
/* 2386:     */ 
/* 2387:     */ 
/* 2388:     */ 
/* 2389:     */ 
/* 2390:2554 */       PdfPTable table = new PdfPTable(2);
/* 2391:     */       
/* 2392:2556 */       table.setHorizontalAlignment(0);
/* 2393:2557 */       table.setWidthPercentage(50.0F);
/* 2394:2558 */       Font white = new Font();
/* 2395:2559 */       white.setColor(BaseColor.BLACK);
/* 2396:2561 */       if (custType.equals("Retailer"))
/* 2397:     */       {
/* 2398:2562 */         String queryForCust = "SELECT * FROM TAB_REGULAR_CUSTOMER WHERE REG_CUSTOMER_ID=?";
/* 2399:2563 */         Connection conCust = getConnection();
/* 2400:2564 */         PreparedStatement preCust = conCust
/* 2401:2565 */           .prepareStatement(queryForCust);
/* 2402:2566 */         preCust.setInt(1, custRef);
/* 2403:2567 */         ResultSet resultCust = preCust.executeQuery();
/* 2404:2568 */         while (resultCust.next())
/* 2405:     */         {
/* 2406:2569 */           PdfPCell cell = new PdfPCell(new Phrase(" Sold To Party:", mainContent));
/* 2407:2570 */           cell.setBackgroundColor(BaseColor.WHITE);
/* 2408:     */           
/* 2409:2572 */           cell.setBorderWidth(1.0F);
/* 2410:     */           
/* 2411:     */ 
/* 2412:     */ 
/* 2413:     */ 
/* 2414:2577 */           PdfPCell cellTwo = new PdfPCell(new Phrase(resultCust.getString("REG_FULL_NAME"), mainContent));
/* 2415:     */           
/* 2416:2579 */           cellTwo.setBorderWidth(1.0F);
/* 2417:     */           
/* 2418:2581 */           PdfPCell cell3 = new PdfPCell(new Phrase(" GSTIN/Unique ID:", mainContent));
/* 2419:2582 */           cell3.setBackgroundColor(BaseColor.WHITE);
/* 2420:     */           
/* 2421:2584 */           cell3.setBorderWidth(1.0F);
/* 2422:     */           
/* 2423:2586 */           PdfPCell cell4 = new PdfPCell(new Phrase(" ", mainContent));
/* 2424:     */           
/* 2425:2588 */           cell4.setBorderWidth(1.0F);
/* 2426:     */           
/* 2427:     */ 
/* 2428:2591 */           PdfPCell cell5 = new PdfPCell(new Phrase(" PAN NO:", mainContent));
/* 2429:2592 */           cell5.setBackgroundColor(BaseColor.WHITE);
/* 2430:     */           
/* 2431:2594 */           cell5.setBorderWidth(1.0F);
/* 2432:     */           
/* 2433:2596 */           PdfPCell cell6 = new PdfPCell(new Phrase(" ", mainContent));
/* 2434:     */           
/* 2435:2598 */           cell6.setBorderWidth(1.0F);
/* 2436:     */           
/* 2437:2600 */           PdfPCell cell7 = new PdfPCell(new Phrase(" Name:", mainContent));
/* 2438:2601 */           cell7.setBackgroundColor(BaseColor.WHITE);
/* 2439:     */           
/* 2440:2603 */           cell7.setBorderWidth(1.0F);
/* 2441:     */           
/* 2442:2605 */           PdfPCell cell8 = new PdfPCell(new Phrase(resultCust.getString("REG_CONTACT_PERSON"), mainContent));
/* 2443:     */           
/* 2444:2607 */           cell8.setBorderWidth(1.0F);
/* 2445:     */           
/* 2446:2609 */           PdfPCell cell9 = new PdfPCell(new Phrase(" Address:", mainContent));
/* 2447:2610 */           cell9.setBackgroundColor(BaseColor.WHITE);
/* 2448:     */           
/* 2449:2612 */           cell9.setBorderWidth(1.0F);
/* 2450:     */           
/* 2451:2614 */           PdfPCell cell10 = new PdfPCell(new Phrase(resultCust.getString("REG_ADDRESS_LINE_1"), mainContent));
/* 2452:     */           
/* 2453:2616 */           cell10.setBorderWidth(1.0F);
/* 2454:     */           
/* 2455:2618 */           PdfPCell cell11 = new PdfPCell(new Phrase(" ", mainContent));
/* 2456:2619 */           cell11.setBackgroundColor(BaseColor.WHITE);
/* 2457:     */           
/* 2458:2621 */           cell11.setBorderWidth(1.0F);
/* 2459:     */           
/* 2460:2623 */           PdfPCell cell12 = new PdfPCell(new Phrase(resultCust.getString("REG_CITY"), mainContent));
/* 2461:     */           
/* 2462:2625 */           cell12.setBorderWidth(1.0F);
/* 2463:     */           
/* 2464:2627 */           PdfPCell cell13 = new PdfPCell(new Phrase(" E-mail Id:", mainContent));
/* 2465:2628 */           cell13.setBackgroundColor(BaseColor.WHITE);
/* 2466:     */           
/* 2467:2630 */           cell13.setBorderWidth(1.0F);
/* 2468:     */           
/* 2469:2632 */           PdfPCell cell14 = new PdfPCell(new Phrase(resultCust.getString("REG_PRIMARY_MAIL_ID"), mainContent));
/* 2470:     */           
/* 2471:2634 */           cell14.setBorderWidth(1.0F);
/* 2472:     */           
/* 2473:2636 */           PdfPCell cell15 = new PdfPCell(new Phrase(" Contact No.:", mainContent));
/* 2474:2637 */           cell15.setBackgroundColor(BaseColor.WHITE);
/* 2475:     */           
/* 2476:2639 */           cell15.setBorderWidth(1.0F);
/* 2477:     */           
/* 2478:2641 */           PdfPCell cell16 = new PdfPCell(new Phrase(resultCust.getString("REG_MOBILE_NO"), mainContent));
/* 2479:     */           
/* 2480:2643 */           cell16.setBorderWidth(1.0F);
/* 2481:     */           
/* 2482:2645 */           PdfPCell cell17 = new PdfPCell(new Phrase(" State:", mainContent));
/* 2483:2646 */           cell17.setBackgroundColor(BaseColor.WHITE);
/* 2484:     */           
/* 2485:2648 */           cell17.setBorderWidth(1.0F);
/* 2486:     */           
/* 2487:2650 */           PdfPCell cell18 = new PdfPCell(new Phrase(resultCust.getString("REG_STATE"), mainContent));
/* 2488:     */           
/* 2489:2652 */           cell18.setBorderWidth(1.0F);
/* 2490:     */           
/* 2491:     */ 
/* 2492:     */ 
/* 2493:2656 */           table.addCell(cell);
/* 2494:2657 */           table.addCell(cellTwo);
/* 2495:2658 */           table.addCell(cell3);
/* 2496:2659 */           table.addCell(cell4);
/* 2497:2660 */           table.addCell(cell5);
/* 2498:2661 */           table.addCell(cell6);
/* 2499:2662 */           table.addCell(cell7);
/* 2500:2663 */           table.addCell(cell8);
/* 2501:2664 */           table.addCell(cell9);
/* 2502:2665 */           table.addCell(cell10);
/* 2503:2666 */           table.addCell(cell11);
/* 2504:2667 */           table.addCell(cell12);
/* 2505:2668 */           table.addCell(cell13);
/* 2506:2669 */           table.addCell(cell14);
/* 2507:2670 */           table.addCell(cell15);
/* 2508:2671 */           table.addCell(cell16);
/* 2509:2672 */           table.addCell(cell17);
/* 2510:2673 */           table.addCell(cell18);
/* 2511:     */         }
/* 2512:     */       }
/* 2513:     */       else
/* 2514:     */       {
/* 2515:2676 */         String queryForCust = "SELECT * FROM TAB_CONSUMER_CUSTOMER WHERE CON_CUSTOMER_ID=?";
/* 2516:2677 */         Connection conCust = getConnection();
/* 2517:2678 */         PreparedStatement preCust = conCust
/* 2518:2679 */           .prepareStatement(queryForCust);
/* 2519:2680 */         preCust.setInt(1, custRef);
/* 2520:2681 */         ResultSet resultCust = preCust.executeQuery();
/* 2521:2682 */         while (resultCust.next())
/* 2522:     */         {
/* 2523:2683 */           PdfPCell cell = new PdfPCell(new Phrase(" Sold To Party:", mainContent));
/* 2524:2684 */           cell.setBackgroundColor(BaseColor.WHITE);
/* 2525:     */           
/* 2526:2686 */           cell.setBorderWidth(1.0F);
/* 2527:     */           
/* 2528:     */ 
/* 2529:     */ 
/* 2530:     */ 
/* 2531:2691 */           PdfPCell cellTwo = new PdfPCell(new Phrase(resultCust.getString("CON_FULL_NAME"), mainContent));
/* 2532:     */           
/* 2533:2693 */           cellTwo.setBorderWidth(1.0F);
/* 2534:     */           
/* 2535:2695 */           PdfPCell cell3 = new PdfPCell(new Phrase(" GSTIN/Unique ID:", mainContent));
/* 2536:2696 */           cell3.setBackgroundColor(BaseColor.WHITE);
/* 2537:     */           
/* 2538:2698 */           cell3.setBorderWidth(1.0F);
/* 2539:     */           
/* 2540:2700 */           PdfPCell cell4 = new PdfPCell(new Phrase(" ", mainContent));
/* 2541:     */           
/* 2542:2702 */           cell4.setBorderWidth(1.0F);
/* 2543:     */           
/* 2544:     */ 
/* 2545:2705 */           PdfPCell cell5 = new PdfPCell(new Phrase(" PAN NO:", mainContent));
/* 2546:2706 */           cell5.setBackgroundColor(BaseColor.WHITE);
/* 2547:     */           
/* 2548:2708 */           cell5.setBorderWidth(1.0F);
/* 2549:     */           
/* 2550:2710 */           PdfPCell cell6 = new PdfPCell(new Phrase(" ", mainContent));
/* 2551:     */           
/* 2552:2712 */           cell6.setBorderWidth(1.0F);
/* 2553:     */           
/* 2554:2714 */           PdfPCell cell7 = new PdfPCell(new Phrase(" Name:", mainContent));
/* 2555:2715 */           cell7.setBackgroundColor(BaseColor.WHITE);
/* 2556:     */           
/* 2557:2717 */           cell7.setBorderWidth(1.0F);
/* 2558:     */           
/* 2559:2719 */           PdfPCell cell8 = new PdfPCell(new Phrase(resultCust.getString("CON_FULL_NAME"), mainContent));
/* 2560:     */           
/* 2561:2721 */           cell8.setBorderWidth(1.0F);
/* 2562:     */           
/* 2563:2723 */           PdfPCell cell9 = new PdfPCell(new Phrase(" Address:", mainContent));
/* 2564:2724 */           cell9.setBackgroundColor(BaseColor.WHITE);
/* 2565:     */           
/* 2566:2726 */           cell9.setBorderWidth(1.0F);
/* 2567:     */           
/* 2568:2728 */           PdfPCell cell10 = new PdfPCell(new Phrase(resultCust.getString("CON_ADDRESS_LINE_1"), mainContent));
/* 2569:     */           
/* 2570:2730 */           cell10.setBorderWidth(1.0F);
/* 2571:     */           
/* 2572:2732 */           PdfPCell cell11 = new PdfPCell(new Phrase(" ", mainContent));
/* 2573:2733 */           cell11.setBackgroundColor(BaseColor.WHITE);
/* 2574:     */           
/* 2575:2735 */           cell11.setBorderWidth(1.0F);
/* 2576:     */           
/* 2577:2737 */           PdfPCell cell12 = new PdfPCell(new Phrase(resultCust.getString("CON_CITY"), mainContent));
/* 2578:     */           
/* 2579:2739 */           cell12.setBorderWidth(1.0F);
/* 2580:     */           
/* 2581:2741 */           PdfPCell cell13 = new PdfPCell(new Phrase(" E-mail Id:", mainContent));
/* 2582:2742 */           cell13.setBackgroundColor(BaseColor.WHITE);
/* 2583:     */           
/* 2584:2744 */           cell13.setBorderWidth(1.0F);
/* 2585:     */           
/* 2586:2746 */           PdfPCell cell14 = new PdfPCell(new Phrase(resultCust.getString("CON_PRIMARY_MAIL_ID"), mainContent));
/* 2587:     */           
/* 2588:2748 */           cell14.setBorderWidth(1.0F);
/* 2589:     */           
/* 2590:2750 */           PdfPCell cell15 = new PdfPCell(new Phrase(" Contact No.:", mainContent));
/* 2591:2751 */           cell15.setBackgroundColor(BaseColor.WHITE);
/* 2592:     */           
/* 2593:2753 */           cell15.setBorderWidth(1.0F);
/* 2594:     */           
/* 2595:2755 */           PdfPCell cell16 = new PdfPCell(new Phrase(resultCust.getString("CON_MOBILE_NO"), mainContent));
/* 2596:     */           
/* 2597:2757 */           cell16.setBorderWidth(1.0F);
/* 2598:     */           
/* 2599:2759 */           PdfPCell cell17 = new PdfPCell(new Phrase(" State:", mainContent));
/* 2600:2760 */           cell17.setBackgroundColor(BaseColor.WHITE);
/* 2601:     */           
/* 2602:2762 */           cell17.setBorderWidth(1.0F);
/* 2603:     */           
/* 2604:2764 */           PdfPCell cell18 = new PdfPCell(new Phrase(resultCust.getString("CON_STATE"), mainContent));
/* 2605:     */           
/* 2606:2766 */           cell18.setBorderWidth(1.0F);
/* 2607:     */           
/* 2608:     */ 
/* 2609:     */ 
/* 2610:2770 */           table.addCell(cell);
/* 2611:2771 */           table.addCell(cellTwo);
/* 2612:2772 */           table.addCell(cell3);
/* 2613:2773 */           table.addCell(cell4);
/* 2614:2774 */           table.addCell(cell5);
/* 2615:2775 */           table.addCell(cell6);
/* 2616:2776 */           table.addCell(cell7);
/* 2617:2777 */           table.addCell(cell8);
/* 2618:2778 */           table.addCell(cell9);
/* 2619:2779 */           table.addCell(cell10);
/* 2620:2780 */           table.addCell(cell11);
/* 2621:2781 */           table.addCell(cell12);
/* 2622:2782 */           table.addCell(cell13);
/* 2623:2783 */           table.addCell(cell14);
/* 2624:2784 */           table.addCell(cell15);
/* 2625:2785 */           table.addCell(cell16);
/* 2626:2786 */           table.addCell(cell17);
/* 2627:2787 */           table.addCell(cell18);
/* 2628:     */         }
/* 2629:     */       }
/* 2630:2792 */       table.setTotalWidth(270.0F);
/* 2631:2793 */       table.setWidths(new float[] { 1.5F, 3.0F });
/* 2632:2794 */       PdfContentByte canvas2 = writer.getDirectContent();
/* 2633:2795 */       table.writeSelectedRows(0, -1, 25.0F, 715.0F, canvas2);
/* 2634:     */       
/* 2635:     */ 
/* 2636:     */ 
/* 2637:     */ 
/* 2638:     */ 
/* 2639:     */ 
/* 2640:     */ 
/* 2641:     */ 
/* 2642:     */ 
/* 2643:     */ 
/* 2644:     */ 
/* 2645:     */ 
/* 2646:     */ 
/* 2647:     */ 
/* 2648:     */ 
/* 2649:     */ 
/* 2650:     */ 
/* 2651:     */ 
/* 2652:     */ 
/* 2653:     */ 
/* 2654:     */ 
/* 2655:     */ 
/* 2656:     */ 
/* 2657:     */ 
/* 2658:     */ 
/* 2659:     */ 
/* 2660:     */ 
/* 2661:     */ 
/* 2662:     */ 
/* 2663:     */ 
/* 2664:     */ 
/* 2665:     */ 
/* 2666:     */ 
/* 2667:     */ 
/* 2668:     */ 
/* 2669:     */ 
/* 2670:     */ 
/* 2671:     */ 
/* 2672:     */ 
/* 2673:     */ 
/* 2674:     */ 
/* 2675:     */ 
/* 2676:     */ 
/* 2677:     */ 
/* 2678:     */ 
/* 2679:     */ 
/* 2680:     */ 
/* 2681:     */ 
/* 2682:     */ 
/* 2683:     */ 
/* 2684:     */ 
/* 2685:     */ 
/* 2686:     */ 
/* 2687:     */ 
/* 2688:     */ 
/* 2689:     */ 
/* 2690:     */ 
/* 2691:     */ 
/* 2692:     */ 
/* 2693:     */ 
/* 2694:     */ 
/* 2695:     */ 
/* 2696:     */ 
/* 2697:     */ 
/* 2698:     */ 
/* 2699:     */ 
/* 2700:     */ 
/* 2701:     */ 
/* 2702:     */ 
/* 2703:     */ 
/* 2704:     */ 
/* 2705:     */ 
/* 2706:     */ 
/* 2707:     */ 
/* 2708:     */ 
/* 2709:     */ 
/* 2710:     */ 
/* 2711:     */ 
/* 2712:     */ 
/* 2713:     */ 
/* 2714:     */ 
/* 2715:     */ 
/* 2716:     */ 
/* 2717:     */ 
/* 2718:     */ 
/* 2719:     */ 
/* 2720:     */ 
/* 2721:     */ 
/* 2722:     */ 
/* 2723:     */ 
/* 2724:     */ 
/* 2725:     */ 
/* 2726:     */ 
/* 2727:     */ 
/* 2728:     */ 
/* 2729:     */ 
/* 2730:     */ 
/* 2731:     */ 
/* 2732:     */ 
/* 2733:     */ 
/* 2734:     */ 
/* 2735:     */ 
/* 2736:     */ 
/* 2737:     */ 
/* 2738:     */ 
/* 2739:     */ 
/* 2740:     */ 
/* 2741:     */ 
/* 2742:     */ 
/* 2743:     */ 
/* 2744:     */ 
/* 2745:     */ 
/* 2746:     */ 
/* 2747:     */ 
/* 2748:     */ 
/* 2749:     */ 
/* 2750:     */ 
/* 2751:     */ 
/* 2752:     */ 
/* 2753:     */ 
/* 2754:     */ 
/* 2755:     */ 
/* 2756:     */ 
/* 2757:     */ 
/* 2758:     */ 
/* 2759:     */ 
/* 2760:     */ 
/* 2761:     */ 
/* 2762:     */ 
/* 2763:     */ 
/* 2764:     */ 
/* 2765:     */ 
/* 2766:     */ 
/* 2767:     */ 
/* 2768:     */ 
/* 2769:     */ 
/* 2770:     */ 
/* 2771:     */ 
/* 2772:     */ 
/* 2773:     */ 
/* 2774:     */ 
/* 2775:     */ 
/* 2776:     */ 
/* 2777:     */ 
/* 2778:     */ 
/* 2779:     */ 
/* 2780:     */ 
/* 2781:     */ 
/* 2782:     */ 
/* 2783:     */ 
/* 2784:     */ 
/* 2785:     */ 
/* 2786:     */ 
/* 2787:     */ 
/* 2788:     */ 
/* 2789:     */ 
/* 2790:     */ 
/* 2791:     */ 
/* 2792:     */ 
/* 2793:     */ 
/* 2794:     */ 
/* 2795:     */ 
/* 2796:     */ 
/* 2797:     */ 
/* 2798:     */ 
/* 2799:     */ 
/* 2800:     */ 
/* 2801:     */ 
/* 2802:     */ 
/* 2803:     */ 
/* 2804:     */ 
/* 2805:     */ 
/* 2806:     */ 
/* 2807:     */ 
/* 2808:     */ 
/* 2809:     */ 
/* 2810:     */ 
/* 2811:     */ 
/* 2812:     */ 
/* 2813:     */ 
/* 2814:     */ 
/* 2815:     */ 
/* 2816:     */ 
/* 2817:     */ 
/* 2818:     */ 
/* 2819:     */ 
/* 2820:     */ 
/* 2821:     */ 
/* 2822:     */ 
/* 2823:     */ 
/* 2824:     */ 
/* 2825:     */ 
/* 2826:     */ 
/* 2827:     */ 
/* 2828:     */ 
/* 2829:     */ 
/* 2830:     */ 
/* 2831:     */ 
/* 2832:     */ 
/* 2833:     */ 
/* 2834:     */ 
/* 2835:     */ 
/* 2836:     */ 
/* 2837:     */ 
/* 2838:     */ 
/* 2839:     */ 
/* 2840:     */ 
/* 2841:     */ 
/* 2842:     */ 
/* 2843:     */ 
/* 2844:     */ 
/* 2845:     */ 
/* 2846:     */ 
/* 2847:     */ 
/* 2848:     */ 
/* 2849:     */ 
/* 2850:     */ 
/* 2851:     */ 
/* 2852:     */ 
/* 2853:     */ 
/* 2854:     */ 
/* 2855:     */ 
/* 2856:     */ 
/* 2857:     */ 
/* 2858:     */ 
/* 2859:     */ 
/* 2860:     */ 
/* 2861:     */ 
/* 2862:     */ 
/* 2863:     */ 
/* 2864:     */ 
/* 2865:     */ 
/* 2866:     */ 
/* 2867:     */ 
/* 2868:     */ 
/* 2869:     */ 
/* 2870:     */ 
/* 2871:     */ 
/* 2872:     */ 
/* 2873:     */ 
/* 2874:     */ 
/* 2875:     */ 
/* 2876:     */ 
/* 2877:     */ 
/* 2878:     */ 
/* 2879:     */ 
/* 2880:     */ 
/* 2881:     */ 
/* 2882:     */ 
/* 2883:     */ 
/* 2884:     */ 
/* 2885:     */ 
/* 2886:     */ 
/* 2887:     */ 
/* 2888:     */ 
/* 2889:     */ 
/* 2890:     */ 
/* 2891:     */ 
/* 2892:     */ 
/* 2893:     */ 
/* 2894:     */ 
/* 2895:     */ 
/* 2896:     */ 
/* 2897:     */ 
/* 2898:     */ 
/* 2899:     */ 
/* 2900:     */ 
/* 2901:     */ 
/* 2902:     */ 
/* 2903:     */ 
/* 2904:     */ 
/* 2905:     */ 
/* 2906:     */ 
/* 2907:     */ 
/* 2908:     */ 
/* 2909:     */ 
/* 2910:     */ 
/* 2911:     */ 
/* 2912:     */ 
/* 2913:     */ 
/* 2914:     */ 
/* 2915:     */ 
/* 2916:     */ 
/* 2917:     */ 
/* 2918:     */ 
/* 2919:     */ 
/* 2920:     */ 
/* 2921:     */ 
/* 2922:     */ 
/* 2923:     */ 
/* 2924:     */ 
/* 2925:     */ 
/* 2926:     */ 
/* 2927:     */ 
/* 2928:     */ 
/* 2929:     */ 
/* 2930:     */ 
/* 2931:     */ 
/* 2932:     */ 
/* 2933:     */ 
/* 2934:     */ 
/* 2935:     */ 
/* 2936:     */ 
/* 2937:     */ 
/* 2938:     */ 
/* 2939:     */ 
/* 2940:     */ 
/* 2941:     */ 
/* 2942:     */ 
/* 2943:     */ 
/* 2944:     */ 
/* 2945:     */ 
/* 2946:     */ 
/* 2947:     */ 
/* 2948:     */ 
/* 2949:     */ 
/* 2950:     */ 
/* 2951:     */ 
/* 2952:     */ 
/* 2953:     */ 
/* 2954:     */ 
/* 2955:     */ 
/* 2956:     */ 
/* 2957:     */ 
/* 2958:     */ 
/* 2959:     */ 
/* 2960:     */ 
/* 2961:     */ 
/* 2962:     */ 
/* 2963:     */ 
/* 2964:     */ 
/* 2965:     */ 
/* 2966:     */ 
/* 2967:     */ 
/* 2968:     */ 
/* 2969:     */ 
/* 2970:     */ 
/* 2971:     */ 
/* 2972:     */ 
/* 2973:     */ 
/* 2974:     */ 
/* 2975:     */ 
/* 2976:     */ 
/* 2977:     */ 
/* 2978:     */ 
/* 2979:     */ 
/* 2980:     */ 
/* 2981:     */ 
/* 2982:     */ 
/* 2983:     */ 
/* 2984:     */ 
/* 2985:     */ 
/* 2986:     */ 
/* 2987:     */ 
/* 2988:     */ 
/* 2989:     */ 
/* 2990:     */ 
/* 2991:     */ 
/* 2992:     */ 
/* 2993:     */ 
/* 2994:     */ 
/* 2995:     */ 
/* 2996:     */ 
/* 2997:     */ 
/* 2998:     */ 
/* 2999:     */ 
/* 3000:     */ 
/* 3001:     */ 
/* 3002:     */ 
/* 3003:     */ 
/* 3004:     */ 
/* 3005:     */ 
/* 3006:     */ 
/* 3007:     */ 
/* 3008:     */ 
/* 3009:     */ 
/* 3010:     */ 
/* 3011:     */ 
/* 3012:     */ 
/* 3013:     */ 
/* 3014:     */ 
/* 3015:     */ 
/* 3016:     */ 
/* 3017:     */ 
/* 3018:     */ 
/* 3019:     */ 
/* 3020:     */ 
/* 3021:     */ 
/* 3022:     */ 
/* 3023:     */ 
/* 3024:     */ 
/* 3025:     */ 
/* 3026:     */ 
/* 3027:     */ 
/* 3028:     */ 
/* 3029:     */ 
/* 3030:     */ 
/* 3031:     */ 
/* 3032:     */ 
/* 3033:     */ 
/* 3034:     */ 
/* 3035:     */ 
/* 3036:     */ 
/* 3037:     */ 
/* 3038:     */ 
/* 3039:     */ 
/* 3040:     */ 
/* 3041:     */ 
/* 3042:     */ 
/* 3043:     */ 
/* 3044:     */ 
/* 3045:     */ 
/* 3046:     */ 
/* 3047:     */ 
/* 3048:     */ 
/* 3049:     */ 
/* 3050:     */ 
/* 3051:3213 */       String line1 = "1.  Cement dispatched vide this invoice is subject to our standard terms condition of business.";
/* 3052:3214 */       String line2 = "2.  Our responsibility ceases once supply of material is made to you/your carrier.";
/* 3053:3215 */       String line3 = "3.  Payment should be made only by way DD/Cheque/RTGS/NEFT in favour of Chouksay Traders.";
/* 3054:3216 */       String line4 = "4.  Interest @18% per annum shall be charged, if payment is delayed beyond 10 days from date of supply or credit terms agreed upon in writing.";
/* 3055:3217 */       String line5 = "5.  In case of any quality related issues, the same should be informed in witing to the officer or over email to the company wthin 48 hours from the goods";
/* 3056:3218 */       String line6 = "6.  All disputes are subject to jurisdiction with the courts at vidisha.";
/* 3057:3219 */       String line7 = "7.  Goods once sold will not be taken back.";
/* 3058:3220 */       String extra = "     are supplied to you.";
/* 3059:3221 */       String line9 = "For Chouksay Traders";
/* 3060:3222 */       String line10 = "Authorised Signatory";
/* 3061:3223 */       String line11 = "Necessary Debit notes and Credit notes will be issued subject to fulfillment of required conditions/ criterias in terms of Discount policy approved ";
/* 3062:3224 */       String line12 = "This is Computer generated Invoice.";
/* 3063:3225 */       String line13 = "and communicated by the Company from time to time and accepted by Customers.";
/* 3064:3226 */       String line14 = "Registered Office Address: HEAD OFFICE CHOUKSAY TRADERS, BUS STAND SHAMSHABAD 464001, VIDISHA, MADHAYA PARADESH ";
/* 3065:3227 */       String line15 = "Description of Goods";
/* 3066:3228 */       String line16 = "Rate/unit";
/* 3067:3229 */       String line17 = "Amount (Rs.)";
/* 3068:3230 */       String line18 = "Qty.";
/* 3069:3231 */       String line19 = "Price(Rs.)";
/* 3070:3232 */       String line20 = "Igst (%)";
/* 3071:3233 */       String line21 = "Igst (Rs.)";
/* 3072:3234 */       String line22 = "Total Value of Goods / Services:";
/* 3073:3235 */       String line23 = "Net Rounded Amount:";
/* 3074:3236 */       String line24 = "In words:";
/* 3075:3237 */       String line30 = "Discount (Rs.):";
/* 3076:3238 */       String line31 = "Transport Charge:";
/* 3077:     */       
/* 3078:3240 */       String line33 = "Labour Charge:";
/* 3079:3241 */       String line32 = "Payment (Rs.):";
/* 3080:3242 */       String line34 = "Due:";
/* 3081:3243 */       String line35 = "Customer Signature";
/* 3082:     */       
/* 3083:     */ 
/* 3084:     */ 
/* 3085:3247 */       ColumnText ct = new ColumnText(canvas);
/* 3086:3248 */       ct.setSimpleColumn(25.0F, 230.0F, 200.0F, 10.0F);
/* 3087:3249 */       Font f = new Font(Font.FontFamily.HELVETICA, 8.0F, 1);
/* 3088:3250 */       Paragraph pz = new Paragraph(new Phrase(20.0F, "TERMS & CONDITION", f));
/* 3089:3251 */       ct.addElement(pz);
/* 3090:3252 */       ct.go();
/* 3091:     */       
/* 3092:     */ 
/* 3093:     */ 
/* 3094:     */ 
/* 3095:3257 */       ColumnText ct1 = new ColumnText(canvas);
/* 3096:3258 */       ct1.setSimpleColumn(25.0F, 220.0F, 500.0F, 10.0F);
/* 3097:3259 */       Font f1 = new Font(Font.FontFamily.HELVETICA, 8.0F, 0);
/* 3098:3260 */       Paragraph pz1 = new Paragraph(new Phrase(20.0F, line1, f1));
/* 3099:3261 */       ct1.addElement(pz1);
/* 3100:3262 */       ct1.go();
/* 3101:     */       
/* 3102:3264 */       ColumnText ct2 = new ColumnText(canvas);
/* 3103:3265 */       ct2.setSimpleColumn(25.0F, 210.0F, 500.0F, 10.0F);
/* 3104:3266 */       Paragraph pz2 = new Paragraph(new Phrase(20.0F, line2, f1));
/* 3105:3267 */       ct2.addElement(pz2);
/* 3106:3268 */       ct2.go();
/* 3107:     */       
/* 3108:3270 */       ColumnText ct3 = new ColumnText(canvas);
/* 3109:3271 */       ct3.setSimpleColumn(25.0F, 200.0F, 500.0F, 10.0F);
/* 3110:3272 */       Paragraph pz3 = new Paragraph(new Phrase(20.0F, line3, f1));
/* 3111:3273 */       ct3.addElement(pz3);
/* 3112:3274 */       ct3.go();
/* 3113:     */       
/* 3114:     */ 
/* 3115:3277 */       ColumnText ct4 = new ColumnText(canvas);
/* 3116:3278 */       ct4.setSimpleColumn(25.0F, 190.0F, 575.0F, 10.0F);
/* 3117:3279 */       Paragraph pz4 = new Paragraph(new Phrase(20.0F, line4, f1));
/* 3118:3280 */       ct4.addElement(pz4);
/* 3119:3281 */       ct4.go();
/* 3120:     */       
/* 3121:3283 */       ColumnText ct5 = new ColumnText(canvas);
/* 3122:3284 */       ct5.setSimpleColumn(25.0F, 180.0F, 570.0F, 10.0F);
/* 3123:3285 */       Paragraph pz5 = new Paragraph(new Phrase(20.0F, line5, f1));
/* 3124:3286 */       ct5.addElement(pz5);
/* 3125:3287 */       ct5.go();
/* 3126:     */       
/* 3127:3289 */       ColumnText ct8 = new ColumnText(canvas);
/* 3128:3290 */       ct8.setSimpleColumn(25.0F, 170.0F, 570.0F, 10.0F);
/* 3129:3291 */       Paragraph pz8 = new Paragraph(new Phrase(20.0F, extra, f1));
/* 3130:3292 */       ct8.addElement(pz8);
/* 3131:3293 */       ct8.go();
/* 3132:     */       
/* 3133:3295 */       ColumnText ct6 = new ColumnText(canvas);
/* 3134:3296 */       ct6.setSimpleColumn(25.0F, 160.0F, 500.0F, 10.0F);
/* 3135:3297 */       Paragraph pz6 = new Paragraph(new Phrase(20.0F, line6, f1));
/* 3136:3298 */       ct6.addElement(pz6);
/* 3137:3299 */       ct6.go();
/* 3138:     */       
/* 3139:3301 */       ColumnText ct7 = new ColumnText(canvas);
/* 3140:3302 */       ct7.setSimpleColumn(25.0F, 150.0F, 500.0F, 10.0F);
/* 3141:3303 */       Paragraph pz7 = new Paragraph(new Phrase(20.0F, line7, f1));
/* 3142:3304 */       ct7.addElement(pz7);
/* 3143:3305 */       ct7.go();
/* 3144:     */       
/* 3145:3307 */       ColumnText ct9 = new ColumnText(canvas);
/* 3146:3308 */       ct9.setSimpleColumn(560.0F, 130.0F, 430.0F, 10.0F);
/* 3147:3309 */       Paragraph pz9 = new Paragraph(new Phrase(20.0F, line9, f1));
/* 3148:3310 */       ct9.addElement(pz9);
/* 3149:3311 */       ct9.go();
/* 3150:     */       
/* 3151:3313 */       ColumnText ct10 = new ColumnText(canvas);
/* 3152:3314 */       ct10.setSimpleColumn(540.0F, 105.0F, 430.0F, 10.0F);
/* 3153:3315 */       Paragraph pz10 = new Paragraph(new Phrase(20.0F, line10, f1));
/* 3154:3316 */       ct10.addElement(pz10);
/* 3155:3317 */       ct10.go();
/* 3156:     */       
/* 3157:3319 */       ColumnText ct36 = new ColumnText(canvas);
/* 3158:3320 */       ct36.setSimpleColumn(70.0F, 105.0F, 430.0F, 10.0F);
/* 3159:3321 */       Paragraph pz36 = new Paragraph(new Phrase(20.0F, line35, f1));
/* 3160:3322 */       ct36.addElement(pz36);
/* 3161:3323 */       ct36.go();
/* 3162:     */       
/* 3163:     */ 
/* 3164:3326 */       ColumnText ct11 = new ColumnText(canvas);
/* 3165:3327 */       ct11.setSimpleColumn(25.0F, 88.0F, 570.0F, 10.0F);
/* 3166:3328 */       Paragraph pz11 = new Paragraph(new Phrase(20.0F, line11, f1));
/* 3167:3329 */       ct11.addElement(pz11);
/* 3168:3330 */       ct11.go();
/* 3169:     */       
/* 3170:3332 */       ColumnText ct12 = new ColumnText(canvas);
/* 3171:3333 */       ct12.setSimpleColumn(25.0F, 78.0F, 570.0F, 10.0F);
/* 3172:3334 */       Paragraph pz12 = new Paragraph(new Phrase(20.0F, line13, f1));
/* 3173:3335 */       ct12.addElement(pz12);
/* 3174:3336 */       ct12.go();
/* 3175:     */       
/* 3176:3338 */       ColumnText ct13 = new ColumnText(canvas);
/* 3177:3339 */       ct13.setSimpleColumn(240.0F, 66.0F, 400.0F, 10.0F);
/* 3178:3340 */       Paragraph pz13 = new Paragraph(new Phrase(20.0F, line12, f1));
/* 3179:3341 */       ct13.addElement(pz13);
/* 3180:3342 */       ct13.go();
/* 3181:     */       
/* 3182:3344 */       ColumnText ct14 = new ColumnText(canvas);
/* 3183:3345 */       ct14.setSimpleColumn(70.0F, 47.0F, 500.0F, 10.0F);
/* 3184:3346 */       Paragraph pz14 = new Paragraph(new Phrase(20.0F, line14, f1));
/* 3185:3347 */       ct14.addElement(pz14);
/* 3186:3348 */       ct14.go();
/* 3187:     */       
/* 3188:3350 */       ColumnText ct15 = new ColumnText(canvas);
/* 3189:3351 */       ct15.setSimpleColumn(50.0F, 565.0F, 200.0F, 10.0F);
/* 3190:3352 */       Font f2 = new Font(Font.FontFamily.HELVETICA, 11.0F, 1);
/* 3191:3353 */       Paragraph pz15 = new Paragraph(new Phrase(20.0F, line15, f2));
/* 3192:3354 */       ct15.addElement(pz15);
/* 3193:3355 */       ct15.go();
/* 3194:     */       
/* 3195:3357 */       ColumnText ct16 = new ColumnText(canvas);
/* 3196:3358 */       ct16.setSimpleColumn(255.0F, 565.0F, 500.0F, 10.0F);
/* 3197:3359 */       Paragraph pz16 = new Paragraph(new Phrase(20.0F, line16, f2));
/* 3198:3360 */       ct16.addElement(pz16);
/* 3199:     */       
/* 3200:3362 */       ct16.go();
/* 3201:     */       
/* 3202:3364 */       ColumnText ct17 = new ColumnText(canvas);
/* 3203:3365 */       ct17.setSimpleColumn(490.0F, 565.0F, 570.0F, 10.0F);
/* 3204:3366 */       Paragraph pz17 = new Paragraph(new Phrase(20.0F, line17, f2));
/* 3205:3367 */       ct17.addElement(pz17);
/* 3206:3368 */       ct17.go();
/* 3207:     */       
/* 3208:3370 */       ColumnText ct18 = new ColumnText(canvas);
/* 3209:3371 */       ct18.setSimpleColumn(210.0F, 565.0F, 300.0F, 10.0F);
/* 3210:3372 */       Paragraph pz18 = new Paragraph(new Phrase(20.0F, line18, f2));
/* 3211:3373 */       ct18.addElement(pz18);
/* 3212:3374 */       ct18.go();
/* 3213:     */       
/* 3214:3376 */       ColumnText ct19 = new ColumnText(canvas);
/* 3215:3377 */       ct19.setSimpleColumn(324.0F, 565.0F, 380.0F, 10.0F);
/* 3216:3378 */       Paragraph pz19 = new Paragraph(new Phrase(20.0F, line19, f2));
/* 3217:3379 */       ct19.addElement(pz19);
/* 3218:3380 */       ct19.go();
/* 3219:     */       
/* 3220:3382 */       ColumnText ct20 = new ColumnText(canvas);
/* 3221:3383 */       ct20.setSimpleColumn(384.0F, 565.0F, 430.0F, 10.0F);
/* 3222:3384 */       Paragraph pz20 = new Paragraph(new Phrase(20.0F, line20, f2));
/* 3223:3385 */       ct20.addElement(pz20);
/* 3224:3386 */       ct20.go();
/* 3225:     */       
/* 3226:3388 */       ColumnText ct21 = new ColumnText(canvas);
/* 3227:3389 */       ct21.setSimpleColumn(435.0F, 565.0F, 490.0F, 10.0F);
/* 3228:3390 */       Paragraph pz21 = new Paragraph(new Phrase(20.0F, line21, f2));
/* 3229:3391 */       ct21.addElement(pz21);
/* 3230:3392 */       ct21.go();
/* 3231:     */       
/* 3232:3394 */       ColumnText ct22 = new ColumnText(canvas);
/* 3233:3395 */       ct22.setSimpleColumn(25.0F, 285.0F, 250.0F, 10.0F);
/* 3234:3396 */       Paragraph pz22 = new Paragraph(new Phrase(20.0F, line22, f2));
/* 3235:3397 */       ct22.addElement(pz22);
/* 3236:3398 */       ct22.go();
/* 3237:     */       
/* 3238:3400 */       ColumnText ct23 = new ColumnText(canvas);
/* 3239:3401 */       ct23.setSimpleColumn(350.0F, 265.0F, 480.0F, 10.0F);
/* 3240:3402 */       Paragraph pz23 = new Paragraph(new Phrase(20.0F, line23, f2));
/* 3241:3403 */       ct23.addElement(pz23);
/* 3242:3404 */       ct23.go();
/* 3243:     */       
/* 3244:3406 */       ColumnText ct24 = new ColumnText(canvas);
/* 3245:3407 */       ct24.setSimpleColumn(25.0F, 245.0F, 200.0F, 10.0F);
/* 3246:3408 */       Paragraph pz24 = new Paragraph(new Phrase(20.0F, line24, f2));
/* 3247:3409 */       ct24.addElement(pz24);
/* 3248:3410 */       ct24.go();
/* 3249:     */       
/* 3250:     */ 
/* 3251:3413 */       ColumnText ct25 = new ColumnText(canvas);
/* 3252:3414 */       ct25.setSimpleColumn(488.0F, 285.0F, 570.0F, 10.0F);
/* 3253:3415 */       Paragraph pz25 = new Paragraph(new Phrase(20.0F, String.valueOf(netAmount), f2));
/* 3254:3416 */       ct25.addElement(pz25);
/* 3255:3417 */       ct25.setAlignment(0);
/* 3256:3418 */       ct25.go();
/* 3257:3419 */       float diff = 100.0F - dis;
/* 3258:     */       
/* 3259:     */ 
/* 3260:3422 */       float resultAmount = netAmount - dis;
/* 3261:3423 */       ColumnText ct26 = new ColumnText(canvas);
/* 3262:3424 */       ct26.setSimpleColumn(488.0F, 265.0F, 570.0F, 10.0F);
/* 3263:3425 */       Paragraph pz26 = new Paragraph(new Phrase(20.0F, String.valueOf(resultAmount + transportCharges), f2));
/* 3264:3426 */       ct26.addElement(pz26);
/* 3265:3427 */       ct26.setAlignment(2);
/* 3266:3428 */       ct26.go();
/* 3267:     */       
/* 3268:     */ 
/* 3269:     */ 
/* 3270:3432 */       ColumnText ct27 = new ColumnText(canvas);
/* 3271:3433 */       ct27.setSimpleColumn(150.0F, 245.0F, 570.0F, 10.0F);
/* 3272:3434 */       Font f3 = new Font(Font.FontFamily.HELVETICA, 11.0F, 0);
/* 3273:3435 */       Paragraph pz27 = new Paragraph(new Phrase(20.0F, String.valueOf(convert((int)(resultAmount+ transportCharges))) + " Rupees", f3));
/* 3274:3436 */       ct27.addElement(pz27);
/* 3275:3437 */       ct27.setAlignment(0);
/* 3276:3438 */       ct27.go();
/* 3277:     */       
/* 3278:3440 */       ColumnText ct30 = new ColumnText(canvas);
/* 3279:3441 */       ct30.setSimpleColumn(25.0F, 265.0F, 200.0F, 10.0F);
/* 3280:3442 */       Paragraph pz30 = new Paragraph(new Phrase(20.0F, line30, f2));
/* 3281:3443 */       ct30.addElement(pz30);
/* 3282:3444 */       ct30.go();
/* 3283:     */       
/* 3284:3446 */       ColumnText ct32 = new ColumnText(canvas);
/* 3285:3447 */       ct32.setSimpleColumn(25.0F, 350.0F, 200.0F, 10.0F);
/* 3286:3448 */       Paragraph pz32 = new Paragraph(new Phrase(20.0F, line31, f2));
/* 3287:3449 */       ct32.addElement(pz32);
/* 3288:3450 */       ct32.go();
/* 3289:     */       
/* 3290:3452 */       ColumnText ct33 = new ColumnText(canvas);
/* 3291:3453 */       ct33.setSimpleColumn(25.0F, 335.0F, 200.0F, 10.0F);
/* 3292:3454 */       Paragraph pz33 = new Paragraph(new Phrase(20.0F, line32, f2));
/* 3293:3455 */       ct33.addElement(pz33);
/* 3294:3456 */       ct33.go();
/* 3295:     */       
/* 3296:3458 */       ColumnText ctp = new ColumnText(canvas);
/* 3297:3459 */       ctp.setSimpleColumn(150.0F, 335.0F, 200.0F, 10.0F);
/* 3298:3460 */       Paragraph pzp = new Paragraph(new Phrase(20.0F, String.valueOf(payment), f2));
/* 3299:3461 */       ctp.addElement(pzp);
/* 3300:3462 */       ctp.go();
/* 3301:     */       
/* 3302:3464 */       ColumnText ct34 = new ColumnText(canvas);
/* 3303:3465 */       ct34.setSimpleColumn(25.0F, 320.0F, 200.0F, 10.0F);
/* 3304:3466 */       Paragraph pz34 = new Paragraph(new Phrase(20.0F, line33, f2));
/* 3305:3467 */       ct34.addElement(pz34);
/* 3306:3468 */       ct34.go();
/* 3307:     */       
/* 3308:3470 */       ColumnText ct35 = new ColumnText(canvas);
/* 3309:3471 */       ct35.setSimpleColumn(25.0F, 305.0F, 200.0F, 10.0F);
/* 3310:3472 */       Paragraph pz35 = new Paragraph(new Phrase(20.0F, line34, f2));
/* 3311:3473 */       ct35.addElement(pz35);
/* 3312:3474 */       ct35.go();
/* 3313:     */       
/* 3314:3476 */       ColumnText ctd = new ColumnText(canvas);
/* 3315:3477 */       ctd.setSimpleColumn(150.0F, 305.0F, 200.0F, 10.0F);
/* 3316:3478 */       Paragraph pzd = new Paragraph(new Phrase(20.0F, String.valueOf(due), f2));
/* 3317:3479 */       ctd.addElement(pzd);
/* 3318:3480 */       ctd.go();
/* 3319:     */       
/* 3320:3482 */       System.out.println("resultAmount" + resultAmount + "dis" + dis);
/* 3321:3483 */       ColumnText ct31 = new ColumnText(canvas);
/* 3322:3484 */       ct31.setSimpleColumn(150.0F, 265.0F, 300.0F, 10.0F);
/* 3323:3485 */       Paragraph pz31 = new Paragraph(new Phrase(20.0F, String.valueOf(dis) + " Rupees", f2));
/* 3324:3486 */       ct31.addElement(pz31);
/* 3325:3487 */       ct31.go();
/* 3326:     */       
/* 3327:3489 */       ColumnText cttc = new ColumnText(canvas);
/* 3328:3490 */       cttc.setSimpleColumn(150.0F, 350.0F, 200.0F, 10.0F);
/* 3329:3491 */       Paragraph pztc = new Paragraph(new Phrase(20.0F, String.valueOf(transportCharges), f2));
/* 3330:3492 */       cttc.addElement(pztc);
/* 3331:3493 */       cttc.go();
/* 3332:     */       
/* 3333:3495 */       PdfPTable table2 = new PdfPTable(2);
/* 3334:     */       
/* 3335:3497 */       table2.setTotalWidth(40.0F);
/* 3336:     */       
/* 3337:     */ 
/* 3338:3500 */       PdfPCell celloio = new PdfPCell(new Paragraph(
/* 3339:3501 */         "Item Total"));
/* 3340:     */       
/* 3341:     */ 
/* 3342:     */ 
/* 3343:3505 */       table2.addCell(celloio);
/* 3344:     */       
/* 3345:     */ 
/* 3346:     */ 
/* 3347:     */ 
/* 3348:     */ 
/* 3349:     */ 
/* 3350:3512 */       document.add(table1);
/* 3351:     */       
/* 3352:     */ 
/* 3353:     */ 
/* 3354:     */ 
/* 3355:     */ 
/* 3356:     */ 
/* 3357:     */ 
/* 3358:     */ 
/* 3359:     */ 
/* 3360:     */ 
/* 3361:     */ 
/* 3362:     */ 
/* 3363:     */ 
/* 3364:     */ 
/* 3365:     */ 
/* 3366:     */ 
/* 3367:     */ 
/* 3368:     */ 
/* 3369:     */ 
/* 3370:     */ 
/* 3371:     */ 
/* 3372:     */ 
/* 3373:     */ 
/* 3374:     */ 
/* 3375:     */ 
/* 3376:     */ 
/* 3377:     */ 
/* 3378:     */ 
/* 3379:     */ 
/* 3380:     */ 
/* 3381:     */ 
/* 3382:     */ 
/* 3383:     */ 
/* 3384:     */ 
/* 3385:     */ 
/* 3386:     */ 
/* 3387:     */ 
/* 3388:     */ 
/* 3389:     */ 
/* 3390:     */ 
/* 3391:     */ 
/* 3392:     */ 
/* 3393:     */ 
/* 3394:     */ 
/* 3395:     */ 
/* 3396:     */ 
/* 3397:     */ 
/* 3398:     */ 
/* 3399:     */ 
/* 3400:     */ 
/* 3401:     */ 
/* 3402:     */ 
/* 3403:     */ 
/* 3404:     */ 
/* 3405:     */ 
/* 3406:     */ 
/* 3407:     */ 
/* 3408:     */ 
/* 3409:     */ 
/* 3410:     */ 
/* 3411:     */ 
/* 3412:     */ 
/* 3413:     */ 
/* 3414:     */ 
/* 3415:     */ 
/* 3416:     */ 
/* 3417:     */ 
/* 3418:     */ 
/* 3419:     */ 
/* 3420:     */ 
/* 3421:     */ 
/* 3422:     */ 
/* 3423:     */ 
/* 3424:     */ 
/* 3425:     */ 
/* 3426:     */ 
/* 3427:     */ 
/* 3428:     */ 
/* 3429:     */ 
/* 3430:     */ 
/* 3431:     */ 
/* 3432:     */ 
/* 3433:     */ 
/* 3434:     */ 
/* 3435:     */ 
/* 3436:     */ 
/* 3437:     */ 
/* 3438:     */ 
/* 3439:     */ 
/* 3440:     */ 
/* 3441:     */ 
/* 3442:     */ 
/* 3443:     */ 
/* 3444:     */ 
/* 3445:     */ 
/* 3446:     */ 
/* 3447:     */ 
/* 3448:     */ 
/* 3449:     */ 
/* 3450:     */ 
/* 3451:     */ 
/* 3452:     */ 
/* 3453:     */ 
/* 3454:     */ 
/* 3455:     */ 
/* 3456:     */ 
/* 3457:     */ 
/* 3458:     */ 
/* 3459:     */ 
/* 3460:     */ 
/* 3461:     */ 
/* 3462:     */ 
/* 3463:     */ 
/* 3464:     */ 
/* 3465:     */ 
/* 3466:     */ 
/* 3467:     */ 
/* 3468:     */ 
/* 3469:     */ 
/* 3470:     */ 
/* 3471:     */ 
/* 3472:     */ 
/* 3473:     */ 
/* 3474:     */ 
/* 3475:     */ 
/* 3476:     */ 
/* 3477:     */ 
/* 3478:     */ 
/* 3479:     */ 
/* 3480:     */ 
/* 3481:     */ 
/* 3482:     */ 
/* 3483:     */ 
/* 3484:     */ 
/* 3485:     */ 
/* 3486:     */ 
/* 3487:     */ 
/* 3488:     */ 
/* 3489:     */ 
/* 3490:     */ 
/* 3491:     */ 
/* 3492:     */ 
/* 3493:     */ 
/* 3494:     */ 
/* 3495:     */ 
/* 3496:     */ 
/* 3497:     */ 
/* 3498:     */ 
/* 3499:     */ 
/* 3500:     */ 
/* 3501:     */ 
/* 3502:     */ 
/* 3503:     */ 
/* 3504:     */ 
/* 3505:     */ 
/* 3506:     */ 
/* 3507:     */ 
/* 3508:     */ 
/* 3509:     */ 
/* 3510:     */ 
/* 3511:     */ 
/* 3512:     */ 
/* 3513:     */ 
/* 3514:     */ 
/* 3515:     */ 
/* 3516:     */ 
/* 3517:     */ 
/* 3518:     */ 
/* 3519:     */ 
/* 3520:     */ 
/* 3521:     */ 
/* 3522:     */ 
/* 3523:     */ 
/* 3524:     */ 
/* 3525:     */ 
/* 3526:     */ 
/* 3527:     */ 
/* 3528:     */ 
/* 3529:     */ 
/* 3530:     */ 
/* 3531:     */ 
/* 3532:     */ 
/* 3533:     */ 
/* 3534:     */ 
/* 3535:     */ 
/* 3536:     */ 
/* 3537:     */ 
/* 3538:     */ 
/* 3539:     */ 
/* 3540:     */ 
/* 3541:     */ 
/* 3542:     */ 
/* 3543:     */ 
/* 3544:     */ 
/* 3545:     */ 
/* 3546:     */ 
/* 3547:     */ 
/* 3548:     */ 
/* 3549:     */ 
/* 3550:     */ 
/* 3551:     */ 
/* 3552:     */ 
/* 3553:     */ 
/* 3554:     */ 
/* 3555:     */ 
/* 3556:     */ 
/* 3557:     */ 
/* 3558:     */ 
/* 3559:     */ 
/* 3560:     */ 
/* 3561:     */ 
/* 3562:     */ 
/* 3563:     */ 
/* 3564:     */ 
/* 3565:     */ 
/* 3566:     */ 
/* 3567:     */ 
/* 3568:     */ 
/* 3569:     */ 
/* 3570:     */ 
/* 3571:     */ 
/* 3572:     */ 
/* 3573:     */ 
/* 3574:     */ 
/* 3575:     */ 
/* 3576:     */ 
/* 3577:     */ 
/* 3578:     */ 
/* 3579:     */ 
/* 3580:     */ 
/* 3581:     */ 
/* 3582:     */ 
/* 3583:     */ 
/* 3584:     */ 
/* 3585:     */ 
/* 3586:     */ 
/* 3587:     */ 
/* 3588:     */ 
/* 3589:     */ 
/* 3590:     */ 
/* 3591:     */ 
/* 3592:     */ 
/* 3593:     */ 
/* 3594:     */ 
/* 3595:     */ 
/* 3596:     */ 
/* 3597:     */ 
/* 3598:     */ 
/* 3599:     */ 
/* 3600:     */ 
/* 3601:     */ 
/* 3602:     */ 
/* 3603:     */ 
/* 3604:     */ 
/* 3605:     */ 
/* 3606:     */ 
/* 3607:     */ 
/* 3608:     */ 
/* 3609:     */ 
/* 3610:     */ 
/* 3611:     */ 
/* 3612:     */ 
/* 3613:     */ 
/* 3614:     */ 
/* 3615:     */ 
/* 3616:     */ 
/* 3617:     */ 
/* 3618:     */ 
/* 3619:     */ 
/* 3620:     */ 
/* 3621:     */ 
/* 3622:     */ 
/* 3623:     */ 
/* 3624:     */ 
/* 3625:     */ 
/* 3626:     */ 
/* 3627:     */ 
/* 3628:     */ 
/* 3629:     */ 
/* 3630:     */ 
/* 3631:     */ 
/* 3632:     */ 
/* 3633:     */ 
/* 3634:     */ 
/* 3635:     */ 
/* 3636:     */ 
/* 3637:     */ 
/* 3638:     */ 
/* 3639:     */ 
/* 3640:     */ 
/* 3641:     */ 
/* 3642:     */ 
/* 3643:     */ 
/* 3644:     */ 
/* 3645:     */ 
/* 3646:     */ 
/* 3647:     */ 
/* 3648:     */ 
/* 3649:     */ 
/* 3650:     */ 
/* 3651:     */ 
/* 3652:     */ 
/* 3653:     */ 
/* 3654:     */ 
/* 3655:     */ 
/* 3656:     */ 
/* 3657:     */ 
/* 3658:     */ 
/* 3659:     */ 
/* 3660:     */ 
/* 3661:     */ 
/* 3662:     */ 
/* 3663:     */ 
/* 3664:     */ 
/* 3665:     */ 
/* 3666:     */ 
/* 3667:     */ 
/* 3668:     */ 
/* 3669:     */ 
/* 3670:     */ 
/* 3671:     */ 
/* 3672:     */ 
/* 3673:     */ 
/* 3674:     */ 
/* 3675:     */ 
/* 3676:     */ 
/* 3677:     */ 
/* 3678:     */ 
/* 3679:     */ 
/* 3680:     */ 
/* 3681:     */ 
/* 3682:     */ 
/* 3683:     */ 
/* 3684:     */ 
/* 3685:     */ 
/* 3686:     */ 
/* 3687:     */ 
/* 3688:     */ 
/* 3689:     */ 
/* 3690:     */ 
/* 3691:     */ 
/* 3692:     */ 
/* 3693:     */ 
/* 3694:     */ 
/* 3695:     */ 
/* 3696:     */ 
/* 3697:     */ 
/* 3698:     */ 
/* 3699:     */ 
/* 3700:     */ 
/* 3701:     */ 
/* 3702:     */ 
/* 3703:     */ 
/* 3704:     */ 
/* 3705:     */ 
/* 3706:     */ 
/* 3707:     */ 
/* 3708:     */ 
/* 3709:     */ 
/* 3710:     */ 
/* 3711:     */ 
/* 3712:     */ 
/* 3713:     */ 
/* 3714:     */ 
/* 3715:     */ 
/* 3716:     */ 
/* 3717:     */ 
/* 3718:     */ 
/* 3719:     */ 
/* 3720:     */ 
/* 3721:     */ 
/* 3722:     */ 
/* 3723:     */ 
/* 3724:     */ 
/* 3725:     */ 
/* 3726:     */ 
/* 3727:     */ 
/* 3728:     */ 
/* 3729:     */ 
/* 3730:     */ 
/* 3731:     */ 
/* 3732:     */ 
/* 3733:     */ 
/* 3734:     */ 
/* 3735:     */ 
/* 3736:     */ 
/* 3737:     */ 
/* 3738:     */ 
/* 3739:     */ 
/* 3740:     */ 
/* 3741:     */ 
/* 3742:     */ 
/* 3743:     */ 
/* 3744:     */ 
/* 3745:     */ 
/* 3746:     */ 
/* 3747:     */ 
/* 3748:     */ 
/* 3749:     */ 
/* 3750:     */ 
/* 3751:     */ 
/* 3752:     */ 
/* 3753:     */ 
/* 3754:     */ 
/* 3755:     */ 
/* 3756:     */ 
/* 3757:     */ 
/* 3758:     */ 
/* 3759:     */ 
/* 3760:     */ 
/* 3761:     */ 
/* 3762:     */ 
/* 3763:     */ 
/* 3764:     */ 
/* 3765:     */ 
/* 3766:     */ 
/* 3767:     */ 
/* 3768:     */ 
/* 3769:     */ 
/* 3770:3932 */       document.close();
/* 3771:3933 */       writer.close();
/* 3772:3935 */       if (outStream != null)
/* 3773:     */       {
/* 3774:3936 */         outStream.close();
/* 3775:3937 */         outStream.flush();
/* 3776:     */       }
/* 3777:     */     }
/* 3778:     */     catch (Exception exception)
/* 3779:     */     {
/* 3780:3941 */       exception.printStackTrace();
/* 3781:3942 */       this.logger.error(
/* 3782:3943 */         InvoiceSaleDaoImpl.class + 
/* 3783:3944 */         "Error: Occur in Query While Closing Connection After Fetching All Sales Details for print PdF from Database.", 
/* 3784:3945 */         exception);
/* 3785:     */     }
/* 3786:     */   }
/* 3787:     */   
/* 3788:3955 */   private static final String[] specialNames = {
/* 3789:3956 */     "", 
/* 3790:3957 */     " THOUSAND", 
/* 3791:3958 */     " MILLION", 
/* 3792:3959 */     " BILLION", 
/* 3793:3960 */     " TRILLION", 
/* 3794:3961 */     " QUADRILLION", 
/* 3795:3962 */     " QUINTILLION" };
/* 3796:3965 */   private static final String[] tensNames = {
/* 3797:3966 */     "", 
/* 3798:3967 */     " TEN", 
/* 3799:3968 */     " TWENTY", 
/* 3800:3969 */     " THIRTY", 
/* 3801:3970 */     " FORTY", 
/* 3802:3971 */     " FIFTY", 
/* 3803:3972 */     " SIXTY", 
/* 3804:3973 */     " SEVENTY", 
/* 3805:3974 */     " EIGHTY", 
/* 3806:3975 */     " NINETY" };
/* 3807:3978 */   private static final String[] numNames = {
/* 3808:3979 */     "", 
/* 3809:3980 */     " ONE", 
/* 3810:3981 */     " TWO", 
/* 3811:3982 */     " THREE", 
/* 3812:3983 */     " FOUR", 
/* 3813:3984 */     " FIVE", 
/* 3814:3985 */     " SIX", 
/* 3815:3986 */     " SEVEN", 
/* 3816:3987 */     " EIGHT", 
/* 3817:3988 */     " NINE", 
/* 3818:3989 */     " TEN", 
/* 3819:3990 */     " ELEVEN", 
/* 3820:3991 */     " TWELVE", 
/* 3821:3992 */     " THIRTEEN", 
/* 3822:3993 */     " FOURTEEN", 
/* 3823:3994 */     " FIFTEEN", 
/* 3824:3995 */     " SIXTEEN", 
/* 3825:3996 */     " SEVENTEEN", 
/* 3826:3997 */     " EIGHTEEN", 
/* 3827:3998 */     " NINETEEN" };
/* 3828:     */   
/* 3829:     */   private String convertLessThanOneThousand(int number)
/* 3830:     */   {
/* 3831:     */     String current;
/* 3832:4004 */     if (number % 100 < 20)
/* 3833:     */     {
/* 3834:4005 */        current = numNames[(number % 100)];
/* 3835:4006 */       number /= 100;
/* 3836:     */     }
/* 3837:     */     else
/* 3838:     */     {
/* 3839:4009 */       current = numNames[(number % 10)];
/* 3840:4010 */       number /= 10;
/* 3841:     */       
/* 3842:4012 */       current = tensNames[(number % 10)] + current;
/* 3843:4013 */       number /= 10;
/* 3844:     */     }
/* 3845:4015 */     if (number == 0) {
/* 3846:4015 */       return current;
/* 3847:     */     }
/* 3848:4016 */     return numNames[number] + " HUNDRED" + current;
/* 3849:     */   }
/* 3850:     */   
/* 3851:     */   public String convert(int number)
/* 3852:     */   {
/* 3853:4020 */     if (number == 0) {
/* 3854:4020 */       return "zero";
/* 3855:     */     }
/* 3856:4022 */     String prefix = "";
/* 3857:4024 */     if (number < 0)
/* 3858:     */     {
/* 3859:4025 */       number = -number;
/* 3860:4026 */       prefix = "negative";
/* 3861:     */     }
/* 3862:4029 */     String current = "";
/* 3863:4030 */     int place = 0;
/* 3864:     */     do
/* 3865:     */     {
/* 3866:4033 */       int n = number % 1000;
/* 3867:4034 */       if (n != 0)
/* 3868:     */       {
/* 3869:4035 */         String s = convertLessThanOneThousand(n);
/* 3870:4036 */         current = s + specialNames[place] + current;
/* 3871:     */       }
/* 3872:4038 */       place++;
/* 3873:4039 */       number /= 1000;
/* 3874:4032 */     } while (
/* 3875:     */     
/* 3876:     */ 
/* 3877:     */ 
/* 3878:     */ 
/* 3879:     */ 
/* 3880:     */ 
/* 3881:     */ 
/* 3882:4040 */       number > 0);
/* 3883:4042 */     return (prefix + current).trim();
/* 3884:     */   }
/* 3885:     */   
/* 3886:     */   public List<InvoiceSaleVO> getSpecificItemsForView(int salesId)
/* 3887:     */     throws RecordNotFoundException
/* 3888:     */   {
/* 3889:4049 */     List<InvoiceSaleVO> salesItemsDetailList = new ArrayList();
/* 3890:     */     try
/* 3891:     */     {
/* 3892:4053 */       this.connection = getConnection();
/* 3893:     */       
/* 3894:4055 */       this.preparedStatement = this.connection
/* 3895:4056 */         .prepareStatement("SELECT * FROM TAB_SALES_ITEMS  WHERE REF_SALES_ID=?");
/* 3896:4057 */       this.preparedStatement.setInt(1, salesId);
/* 3897:     */       
/* 3898:     */ 
/* 3899:4060 */       this.resultSet = this.preparedStatement.executeQuery();
/* 3900:4064 */       while (this.resultSet.next())
/* 3901:     */       {
/* 3902:4065 */         this.saleVO = new InvoiceSaleVO();
/* 3903:4066 */         this.saleVO.setItemId(this.nameHelper.getProductTypeNameByProductId(Integer.parseInt(this.nameHelper.getProductNameById(this.resultSet.getInt("SALES_ITEM_REF")))));
/* 3904:     */         
/* 3905:     */ 
/* 3906:     */ 
/* 3907:     */ 
/* 3908:4071 */         this.saleVO.setItemDescription(this.resultSet
/* 3909:4072 */           .getString("SALES_ITEM_DESCRIPTION"));
/* 3910:     */         
/* 3911:4074 */         this.saleVO.setItemQuantity(this.resultSet
/* 3912:4075 */           .getString("SALES_ITEM_QUANTITY"));
/* 3913:     */         
/* 3914:4077 */         this.saleVO.setItemPrice(this.resultSet
/* 3915:4078 */           .getString("SALES_ITEM_PRICE"));
/* 3916:     */         
/* 3917:     */ 
/* 3918:4081 */         this.saleVO.setItemTax(this.nameHelper.getTaxValueById(this.resultSet.getInt("SALES_ITEM_TAX")).trim());
/* 3919:     */         
/* 3920:     */ 
/* 3921:     */ 
/* 3922:4085 */         this.saleVO.setAmount(this.resultSet
/* 3923:4086 */           .getString("SALES_ITEM_AMOUNT"));
/* 3924:     */         
/* 3925:4088 */         System.out.println(this.resultSet.getFloat("SALES_ITEM_AMOUNT") + " " + this.resultSet.getFloat("SALES_ITEM_PRICE") + "****8888****" + this.resultSet
/* 3926:4089 */           .getString("SALES_ITEM_QUANTITY") + " " + String.valueOf(this.resultSet.getInt("SALES_ITEM_TAX")));
/* 3927:4090 */         salesItemsDetailList.add(this.saleVO);
/* 3928:     */       }
/* 3929:     */     }
/* 3930:     */     catch (SQLException sqlExp)
/* 3931:     */     {
/* 3932:4094 */       sqlExp.printStackTrace();
/* 3933:4095 */       this.logger.error(
/* 3934:4096 */         InvoiceSaleDaoImpl.class + 
/* 3935:4097 */         "Error: Occur in Query While Fetching the sales items Details  from Database.", 
/* 3936:4098 */         sqlExp);
/* 3937:     */     }
/* 3938:     */     catch (Exception exception)
/* 3939:     */     {
/* 3940:4100 */       exception.printStackTrace();
/* 3941:4101 */       this.logger.error(
/* 3942:4102 */         InvoiceSaleDaoImpl.class + 
/* 3943:4103 */         "Error: Occur in Query While Closing Connection After Fetching the sales items Details from Database.", 
/* 3944:4104 */         exception);
/* 3945:     */     }
/* 3946:     */     finally
/* 3947:     */     {
/* 3948:4106 */       JdbcHelper.closeResultSet(this.resultSet);
/* 3949:4107 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/* 3950:4108 */       JdbcHelper.closeConnection(this.connection);
/* 3951:     */     }
/* 3952:4110 */     return salesItemsDetailList;
/* 3953:     */   }


public int getNameForBillGeneration(String a) {
	 Connection connection = null;
	     PreparedStatement preparedStatement = null;
	     ResultSet resultSet = null;
	      String sql = "SELECT STOCK_BILLED_OWNER FROM TAB_STOCK_DETAILS WHERE STOCK_PRODUCT_TYPE=?";
	     int estId = 0;
	     try
	     {
	       connection = getConnection();
	      preparedStatement = connection.prepareStatement(sql);
	      preparedStatement.setString(1, a);
	      resultSet = preparedStatement.executeQuery();
	      if ((resultSet != null) &&  (resultSet.next())) {
	    	  estId=  resultSet.getInt("STOCK_BILLED_OWNER");
	    	  System.out.println("KKKKKKKKKKKKKKKKBilled from"+estId);
	      }
	     
	   
} catch (SQLException sqlException) {
	logger.error(InvoiceSaleDaoImpl.class+"Failed to get Connection from Database", sqlException);

} catch (Exception exception) {
	logger.error(InvoiceSaleDaoImpl.class+"Failed to fetch name Id based on product type from Database",
			exception);
} finally {
	JdbcHelper.closeResultSet(resultSet);
	JdbcHelper.closeStatement(preparedStatement);
	JdbcHelper.closeConnection(connection);
}
	    return estId;
}

@Override
public int getNameForBillOnTheBasisOfId(int salesId) throws RecordNotFoundException {
	 String sql = "SELECT SALES_ITEM_REF FROM TAB_SALES_ITEMS WHERE REF_SALES_ID=?";
     int estId = 0;
     int nameId = 0;
     try
     {
       connection = getConnection();
      preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setInt(1, salesId);
      resultSet = preparedStatement.executeQuery();
      if ((resultSet != null) &&  (resultSet.next())) {
    	  estId=  resultSet.getInt("SALES_ITEM_REF");
    	  System.out.println("KKKKKKKKKKKKKKKKBilled from"+estId);
      }
      nameId=   getNameForBillGeneration(String.valueOf(estId));
   
} catch (SQLException sqlException) {
logger.error(InvoiceSaleDaoImpl.class+"Failed to get Connection from Database", sqlException);

} catch (Exception exception) {
logger.error(InvoiceSaleDaoImpl.class+"Failed to fetch name Id based on product type from Database",
		exception);
} finally {
JdbcHelper.closeResultSet(resultSet);
JdbcHelper.closeStatement(preparedStatement);
JdbcHelper.closeConnection(connection);
}
    return nameId;

}



/* 3954:     */ }


/* Location:           C:\Users\bharti\Desktop\Chouksay\lost\dao\
 * Qualified Name:     com.bst.ckt.dao.InvoiceSaleDaoImpl
 * JD-Core Version:    0.7.0.1
 */