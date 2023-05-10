/*    1:     */ package com.bst.ckt.dao;
/*    2:     */ 
/*    3:     */ import com.bst.ckt.common.QueryBuilder;
/*    4:     */ import com.bst.ckt.dto.Consumer;
/*    5:     */ import com.bst.ckt.exception.CreateFailedException;
/*    6:     */ import com.bst.ckt.exception.DeleteFailedException;
/*    7:     */ import com.bst.ckt.exception.RecordNotFoundException;
/*    8:     */ import com.bst.ckt.exception.UpdateFailedException;
/*    9:     */ import com.bst.ckt.framework.db.JdbcDAOSupport;
/*   10:     */ import com.bst.ckt.framework.db.JdbcHelper;
/*   11:     */ import com.bst.ckt.framework.util.DateTimeUtil;
/*   12:     */ import com.bst.ckt.helper.NameHelper;
/*   13:     */ import com.bst.ckt.vo.ConsumerCustomerVO;
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
/*   39:     */ public class ConsumerCustomerDaoImpl
/*   40:     */   extends JdbcDAOSupport
/*   41:     */   implements ConsumerCustomerDaoInf
/*   42:     */ {
/*   43:  49 */   private static final Logger logger = Logger.getLogger(ConsumerCustomerDaoImpl.class);
/*   44:  51 */   PreparedStatement preparedStatement = null;
/*   45:  52 */   Connection connection = null;
/*   46:  53 */   ResultSet resultSet = null;
/*   47:  54 */   Image image = null;
/*   48:  55 */   NameHelper nameHelper = new NameHelper();
/*   49:  56 */   ConsumerCustomerVO consumerCustomerVO = null;
/*   50:     */   
/*   51:     */   public void addConsumerDetails(ConsumerCustomerVO consumerCustomerVO)
/*   52:     */     throws CreateFailedException
/*   53:     */   {
/*   54:     */     try
/*   55:     */     {
/*   56:  62 */       System.out.println("we  r in dao " + consumerCustomerVO.getFullName());
/*   57:  63 */       this.connection = getConnection();
/*   58:  64 */       String insert = "INSERT INTO TAB_CONSUMER_CUSTOMER(CON_SALUTATION,CON_FULL_NAME,CON_DATE_OF_BIRTH,CON_ADDRESS_LINE_1,CON_ADDRESS_LINE_2,CON_CITY,CON_STATE,CON_PINCODE,CON_PRIMARY_MAIL_ID, CON_ALTERNATE_MAIL_ID,CON_PHONE_NO,CON_MOBILE_NO, CON_FAX_NO,CON_CREATION_DATE,CON_WORK_LOCATION, CON_CUSTOMER_STATUS)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
/*   59:     */       
/*   60:     */ 
/*   61:  67 */       this.preparedStatement = this.connection
/*   62:  68 */         .prepareStatement(insert);
/*   63:  69 */       this.preparedStatement.setString(1, consumerCustomerVO.getSalutation());
/*   64:  70 */       this.preparedStatement.setString(2, consumerCustomerVO.getFullName());
/*   65:     */       
/*   66:  72 */       this.preparedStatement.setString(3, "2018-07-05");
/*   67:  73 */       this.preparedStatement.setString(4, consumerCustomerVO.getAddress1());
/*   68:  74 */       this.preparedStatement.setString(5, consumerCustomerVO.getAddress2());
/*   69:  75 */       this.preparedStatement.setString(6, consumerCustomerVO.getCity());
/*   70:  76 */       this.preparedStatement.setString(7, consumerCustomerVO.getState());
/*   71:  77 */       this.preparedStatement.setString(8, consumerCustomerVO.getPinCode());
/*   72:  78 */       this.preparedStatement.setString(9, consumerCustomerVO.getPeimaryMailId());
/*   73:  79 */       this.preparedStatement.setString(10, consumerCustomerVO.getAlternativeMail());
/*   74:  80 */       this.preparedStatement.setString(11, consumerCustomerVO.getPhoneNo());
/*   75:  81 */       this.preparedStatement.setString(12, consumerCustomerVO.getMobileNo());
/*   76:  82 */       this.preparedStatement.setString(13, consumerCustomerVO.getFaxNo());
/*   77:  83 */       this.preparedStatement.setString(14, DateTimeUtil.getCurrentDate());
/*   78:     */       
/*   79:  85 */       this.preparedStatement.setString(15, consumerCustomerVO.getWorkLocation());
/*   80:  86 */       this.preparedStatement.setString(16, "ACTIVE");
/*   81:     */       
/*   82:     */ 
/*   83:  89 */       this.preparedStatement.executeUpdate();
/*   84:     */     }
/*   85:     */     catch (SQLException sqlException)
/*   86:     */     {
/*   87:  92 */       sqlException.printStackTrace();
/*   88:  93 */       logger.error(
/*   89:  94 */         ConsumerCustomerDaoImpl.class + 
/*   90:  95 */         ": Error:- Error: Occur in Query While inserting the Consumer details into Database", 
/*   91:  96 */         sqlException);
/*   92:     */     }
/*   93:     */     catch (Exception exception)
/*   94:     */     {
/*   95:  99 */       exception.printStackTrace();
/*   96: 100 */       logger.error(
/*   97: 101 */         ConsumerCustomerDaoImpl.class + 
/*   98: 102 */         ": Error:- While closing the Connection after inserting the Consumer details into Database", 
/*   99: 103 */         exception);
/*  100:     */     }
/*  101:     */     finally
/*  102:     */     {
/*  103: 106 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/*  104: 107 */       JdbcHelper.closeConnection(this.connection);
/*  105:     */     }
/*  106:     */   }
/*  107:     */   
/*  108:     */   public List<ConsumerCustomerVO> retriveConsumerDetailsGrid(ConsumerCustomerVO consumerCustomerVO)
/*  109:     */     throws RecordNotFoundException
/*  110:     */   {
/*  111: 115 */     List<ConsumerCustomerVO> consumerDetailList = new ArrayList();
/*  112:     */     try
/*  113:     */     {
/*  114: 119 */       this.connection = getConnection();
/*  115: 120 */       this.preparedStatement = this.connection
/*  116: 121 */         .prepareStatement("SELECT * FROM TAB_CONSUMER_CUSTOMER WHERE CON_CUSTOMER_STATUS='ACTIVE'");
/*  117: 122 */       this.resultSet = this.preparedStatement.executeQuery();
/*  118: 126 */       while (this.resultSet.next())
/*  119:     */       {
/*  120: 127 */         consumerCustomerVO = new ConsumerCustomerVO();
/*  121: 128 */         consumerCustomerVO.setCustomerId(this.resultSet.getInt("CON_CUSTOMER_ID"));
/*  122:     */         
/*  123:     */ 
/*  124:     */ 
/*  125: 132 */         consumerCustomerVO.setFullName(this.resultSet.getString("CON_FULL_NAME"));
/*  126:     */         
/*  127: 134 */         consumerCustomerVO.setDob(this.resultSet
/*  128: 135 */           .getString("CON_DATE_OF_BIRTH"));
/*  129:     */         
/*  130: 137 */         consumerCustomerVO.setAddress1(this.resultSet
/*  131: 138 */           .getString("CON_ADDRESS_LINE_1"));
/*  132:     */         
/*  133: 140 */         consumerCustomerVO.setAddress2(this.resultSet
/*  134: 141 */           .getString("CON_ADDRESS_LINE_2"));
/*  135:     */         
/*  136:     */ 
/*  137: 144 */         consumerCustomerVO.setCity(this.nameHelper.getCityNameByCityId(this.resultSet.getInt("CON_CITY")));
/*  138:     */         
/*  139: 146 */         consumerCustomerVO.setState(this.nameHelper.getStateNameByStateId(this.resultSet.getInt("CON_STATE")));
/*  140:     */         
/*  141: 148 */         consumerCustomerVO.setPhoneNo(this.resultSet
/*  142: 149 */           .getString("CON_PHONE_NO"));
/*  143:     */         
/*  144: 151 */         consumerCustomerVO.setMobileNo(this.resultSet
/*  145: 152 */           .getString("CON_MOBILE_NO"));
/*  146:     */         
/*  147: 154 */         consumerCustomerVO.setPinCode(this.resultSet
/*  148: 155 */           .getString("CON_PINCODE"));
/*  149:     */         
/*  150: 157 */         consumerCustomerVO.setPeimaryMailId(this.resultSet
/*  151: 158 */           .getString("CON_PRIMARY_MAIL_ID"));
/*  152:     */         
/*  153:     */ 
/*  154: 161 */         consumerCustomerVO.setAlternativeMail(this.resultSet
/*  155: 162 */           .getString("CON_ALTERNATE_MAIL_ID"));
/*  156: 163 */         consumerCustomerVO.setCreationDate(this.resultSet
/*  157: 164 */           .getString("CON_CREATION_DATE"));
/*  158: 165 */         consumerCustomerVO.setWorkLocation(this.resultSet
/*  159: 166 */           .getString("CON_WORK_LOCATION"));
/*  160: 167 */         consumerCustomerVO.setCreatedBy(this.resultSet
/*  161: 168 */           .getString("CON_CREATED_BY"));
/*  162: 169 */         consumerDetailList.add(consumerCustomerVO);
/*  163:     */       }
/*  164:     */     }
/*  165:     */     catch (SQLException sqlExp)
/*  166:     */     {
/*  167: 173 */       sqlExp.printStackTrace();
/*  168: 174 */       logger.error(
/*  169: 175 */         ConsumerCustomerDaoImpl.class + 
/*  170: 176 */         "Error: Occur in Query While Fetching the consumer Details into Grid from Database.", 
/*  171: 177 */         sqlExp);
/*  172:     */     }
/*  173:     */     catch (Exception exception)
/*  174:     */     {
/*  175: 179 */       exception.printStackTrace();
/*  176: 180 */       logger.error(
/*  177: 181 */         ConsumerCustomerDaoImpl.class + 
/*  178: 182 */         "Error: Occur in Query While Closing Connection After Fetching the consumer Details into Grid from Database.", 
/*  179: 183 */         exception);
/*  180:     */     }
/*  181:     */     finally
/*  182:     */     {
/*  183: 185 */       JdbcHelper.closeResultSet(this.resultSet);
/*  184: 186 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/*  185: 187 */       JdbcHelper.closeConnection(this.connection);
/*  186:     */     }
/*  187: 189 */     return consumerDetailList;
/*  188:     */   }
/*  189:     */   
/*  190:     */   public Consumer retriveSpecificConsumerDetail(int consumerId)
/*  191:     */     throws RecordNotFoundException
/*  192:     */   {
/*  193: 195 */     Consumer consumer = new Consumer();
/*  194:     */     try
/*  195:     */     {
/*  196: 198 */       System.out.println("hye bharti ur in view method");
/*  197: 199 */       this.connection = getConnection();
/*  198: 200 */       this.preparedStatement = this.connection
/*  199: 201 */         .prepareStatement("SELECT * FROM TAB_CONSUMER_CUSTOMER WHERE CON_CUSTOMER_STATUS='ACTIVE' AND CON_CUSTOMER_ID=?");
/*  200: 202 */       this.preparedStatement.setInt(1, consumerId);
/*  201: 203 */       this.resultSet = this.preparedStatement.executeQuery();
/*  202: 204 */       System.out.println("----------hye ----------------%%" + consumerId);
/*  203: 205 */       if (this.resultSet != null) {
/*  204: 206 */         while (this.resultSet.next())
/*  205:     */         {
/*  206: 208 */           System.out.println("----------hye ----------------" + this.resultSet.getInt("CON_CUSTOMER_ID") + "****");
/*  207:     */           
/*  208: 210 */           consumer.setCustomerId(this.resultSet.getInt("CON_CUSTOMER_ID"));
/*  209:     */           
/*  210:     */ 
/*  211:     */ 
/*  212: 214 */           consumer.setFullName(this.resultSet.getString("CON_FULL_NAME"));
/*  213:     */           
/*  214: 216 */           consumer.setDob(this.resultSet
/*  215: 217 */             .getString("CON_DATE_OF_BIRTH"));
/*  216:     */           
/*  217: 219 */           consumer.setAddress1(this.resultSet
/*  218: 220 */             .getString("CON_ADDRESS_LINE_1"));
/*  219:     */           
/*  220: 222 */           consumer.setAddress2(this.resultSet
/*  221: 223 */             .getString("CON_ADDRESS_LINE_2"));
/*  222:     */           
/*  223:     */ 
/*  224: 226 */           consumer.setCity(this.nameHelper.getCityNameByCityId(this.resultSet.getInt("CON_CITY")));
/*  225:     */           
/*  226: 228 */           consumer.setState(this.nameHelper.getStateNameByStateId(this.resultSet.getInt("CON_STATE")));
/*  227:     */           
/*  228: 230 */           consumer.setPhoneNo(this.resultSet
/*  229: 231 */             .getString("CON_PHONE_NO"));
/*  230:     */           
/*  231: 233 */           consumer.setMobileNo(this.resultSet
/*  232: 234 */             .getString("CON_MOBILE_NO"));
/*  233:     */           
/*  234: 236 */           consumer.setPinCode(this.resultSet
/*  235: 237 */             .getString("CON_PINCODE"));
/*  236:     */           
/*  237: 239 */           consumer.setPeimaryMailId(this.resultSet
/*  238: 240 */             .getString("CON_PRIMARY_MAIL_ID"));
/*  239:     */           
/*  240:     */ 
/*  241: 243 */           consumer.setAlternativeMail(this.resultSet
/*  242: 244 */             .getString("CON_ALTERNATE_MAIL_ID"));
/*  243: 245 */           consumer.setCreationDate(this.resultSet
/*  244: 246 */             .getString("CON_CREATION_DATE"));
/*  245: 247 */           consumer.setWorkLocation(this.resultSet
/*  246: 248 */             .getString("CON_WORK_LOCATION"));
/*  247: 249 */           consumer.setCreatedBy(this.resultSet
/*  248: 250 */             .getString("CON_CREATED_BY"));
/*  249: 251 */           System.out.println("u got the data ***********************************" + this.resultSet.getString("CON_PRIMARY_MAIL_ID"));
/*  250:     */         }
/*  251:     */       }
/*  252:     */     }
/*  253:     */     catch (SQLException sqlExp)
/*  254:     */     {
/*  255: 260 */       sqlExp.printStackTrace();
/*  256: 261 */       logger.error(
/*  257: 262 */         ConsumerCustomerDaoImpl.class + 
/*  258: 263 */         "Error: Occur in Query While Fetching the specific consumer Details from Database.", 
/*  259: 264 */         sqlExp);
/*  260:     */     }
/*  261:     */     catch (Exception exception)
/*  262:     */     {
/*  263: 266 */       exception.printStackTrace();
/*  264: 267 */       logger.error(
/*  265: 268 */         ConsumerCustomerDaoImpl.class + 
/*  266: 269 */         "Error: Occur in Query While Closing Connection After Fetching the specific consumer Details from Database.", 
/*  267: 270 */         exception);
/*  268:     */     }
/*  269:     */     finally
/*  270:     */     {
/*  271: 272 */       JdbcHelper.closeResultSet(this.resultSet);
/*  272: 273 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/*  273: 274 */       JdbcHelper.closeConnection(this.connection);
/*  274:     */     }
/*  275: 278 */     return consumer;
/*  276:     */   }
/*  277:     */   
/*  278:     */   public List<ConsumerCustomerVO> retriveConsumerTransactionDetailsGrid(ConsumerCustomerVO consumerCustomerVO)
/*  279:     */     throws RecordNotFoundException
/*  280:     */   {
/*  281: 285 */     List<ConsumerCustomerVO> consumerTransactionDetailList = new ArrayList();
/*  282:     */     try
/*  283:     */     {
/*  284: 289 */       this.connection = getConnection();
/*  285:     */       
/*  286: 291 */       this.preparedStatement = this.connection
/*  287: 292 */         .prepareStatement("SELECT * FROM TAB_OWNER_CUSTOMER_TRANSACTION WHERE CUSTOMER_TYPE='Consumer' ORDER BY CUSTOMER_TRANS_ID DESC");
/*  288:     */       
/*  289:     */ 
/*  290: 295 */       this.resultSet = this.preparedStatement.executeQuery();
/*  291: 299 */       while (this.resultSet.next())
/*  292:     */       {
/*  293: 300 */         consumerCustomerVO = new ConsumerCustomerVO();
/*  294: 301 */         consumerCustomerVO.setTransactionId(this.resultSet.getInt("CUSTOMER_TRANS_ID"));
/*  295:     */         
/*  296:     */ 
/*  297:     */ 
/*  298:     */ 
/*  299:     */ 
/*  300: 307 */         consumerCustomerVO.setDescription(this.resultSet
/*  301: 308 */           .getString("CUSTOMER_TRANS_DISCRIPTION"));
/*  302:     */         
/*  303: 310 */         consumerCustomerVO.setTotal(this.resultSet
/*  304: 311 */           .getFloat("CUSTOMER_TRANS_TOTAL"));
/*  305:     */         
/*  306: 313 */         consumerCustomerVO.setPaid(this.resultSet
/*  307: 314 */           .getFloat("CUSTOMER_TRANS_PAID"));
/*  308:     */         
/*  309:     */ 
/*  310: 317 */         consumerCustomerVO.setDue(this.resultSet
/*  311: 318 */           .getFloat("CUSTOMER_TRANS_DUE"));
/*  312:     */         
/*  313: 320 */         consumerCustomerVO.setTotalPaid(this.resultSet
/*  314: 321 */           .getFloat("CUSTOMER_TRANS_TOTAL_PAID"));
/*  315:     */         
/*  316: 323 */         consumerCustomerVO.setTotalDue(this.resultSet
/*  317: 324 */           .getFloat("CUSTOMER_TRANS_TOTAL_DUE"));
/*  318:     */         
/*  319: 326 */         consumerCustomerVO.setPaymentMode(this.nameHelper.getPaymentModeById(this.resultSet.getInt("CUSTOMER_TRANS_PAY_MODE")));
/*  320:     */         
/*  321: 328 */         consumerCustomerVO.setTransactionDate(this.resultSet
/*  322: 329 */           .getString("CUSTOMER_TRANS_DATE"));
/*  323:     */         
/*  324: 331 */         consumerCustomerVO.setRetailerId(this.resultSet
/*  325: 332 */           .getInt("CUSTOMER_ID_CONSUMER"));
/*  326:     */         
/*  327: 334 */         consumerCustomerVO.setFullName(this.nameHelper.getConsumerCustomerNameById(this.resultSet
/*  328: 335 */           .getInt("CUSTOMER_ID_CONSUMER")));
/*  329:     */         
/*  330: 337 */         consumerCustomerVO.setPaymentMode(this.nameHelper.getPaymentModeById(Integer.parseInt(this.resultSet
/*  331: 338 */           .getString("CUSTOMER_TRANS_PAY_MODE"))));
/*  332:     */         
/*  333:     */ 
/*  334: 341 */         consumerTransactionDetailList.add(consumerCustomerVO);
/*  335:     */       }
/*  336:     */     }
/*  337:     */     catch (SQLException sqlExp)
/*  338:     */     {
/*  339: 345 */       sqlExp.printStackTrace();
/*  340: 346 */       logger.error(
/*  341: 347 */         ConsumerCustomerDaoImpl.class + 
/*  342: 348 */         "Error: Occur in Query While Fetching the consumer transaction Details into Grid from Database.", 
/*  343: 349 */         sqlExp);
/*  344:     */     }
/*  345:     */     catch (Exception exception)
/*  346:     */     {
/*  347: 351 */       exception.printStackTrace();
/*  348: 352 */       logger.error(
/*  349: 353 */         ConsumerCustomerDaoImpl.class + 
/*  350: 354 */         "Error: Occur in Query While Closing Connection After Fetching the consumer transaction Details into Grid from Database.", 
/*  351: 355 */         exception);
/*  352:     */     }
/*  353:     */     finally
/*  354:     */     {
/*  355: 357 */       JdbcHelper.closeResultSet(this.resultSet);
/*  356: 358 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/*  357: 359 */       JdbcHelper.closeConnection(this.connection);
/*  358:     */     }
/*  359: 361 */     return consumerTransactionDetailList;
/*  360:     */   }
/*  361:     */   
/*  362:     */   public int deleteSpecificConsumerDetails(int custId)
/*  363:     */     throws DeleteFailedException
/*  364:     */   {
/*  365: 367 */     int effect = 0;
/*  366:     */     try
/*  367:     */     {
/*  368: 369 */       this.connection = getConnection();
/*  369:     */       
/*  370: 371 */       this.preparedStatement = this.connection.prepareStatement("UPDATE TAB_CONSUMER_CUSTOMER SET CON_CUSTOMER_STATUS='DELETED' WHERE  CON_CUSTOMER_ID=?");
/*  371:     */       
/*  372: 373 */       this.preparedStatement.setInt(1, custId);
/*  373:     */       
/*  374: 375 */       effect = this.preparedStatement.executeUpdate();
/*  375:     */     }
/*  376:     */     catch (SQLException sqlException)
/*  377:     */     {
/*  378: 378 */       sqlException.printStackTrace();
/*  379: 379 */       logger.error(
/*  380: 380 */         ConsumerCustomerDaoImpl.class + 
/*  381: 381 */         ": Error:- Error: Occur in Query While deleting the consumer details record", 
/*  382: 382 */         sqlException);
/*  383:     */     }
/*  384:     */     catch (Exception exception)
/*  385:     */     {
/*  386: 384 */       exception.printStackTrace();
/*  387: 385 */       logger.error(
/*  388: 386 */         ConsumerCustomerDaoImpl.class + 
/*  389: 387 */         ": Error:- While closing the Connection after deleting the consumer details reccord", 
/*  390: 388 */         exception);
/*  391:     */     }
/*  392:     */     finally
/*  393:     */     {
/*  394: 391 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/*  395: 392 */       JdbcHelper.closeConnection(this.connection);
/*  396:     */     }
/*  397: 394 */     return effect;
/*  398:     */   }
/*  399:     */   
/*  400:     */   public Consumer retriveSpecificConsumerDetailForEdit(int consumerId)
/*  401:     */     throws RecordNotFoundException
/*  402:     */   {
/*  403: 402 */     Consumer consumer = new Consumer();
/*  404:     */     try
/*  405:     */     {
/*  406: 405 */       this.connection = getConnection();
/*  407: 406 */       PreparedStatement preparedStatements = this.connection
/*  408: 407 */         .prepareStatement("SELECT * FROM TAB_CONSUMER_CUSTOMER WHERE  CON_CUSTOMER_ID=?");
/*  409: 408 */       preparedStatements.setInt(1, consumerId);
/*  410: 409 */       this.resultSet = preparedStatements.executeQuery();
/*  411: 410 */       System.out.println("----------hye ----------------" + consumerId);
/*  412: 411 */       if (this.resultSet != null) {
/*  413: 412 */         while (this.resultSet.next())
/*  414:     */         {
/*  415: 414 */           System.out.println("----------hye ----------------");
/*  416:     */           
/*  417: 416 */           consumer.setCustomerId(this.resultSet.getInt("CON_CUSTOMER_ID"));
/*  418: 417 */           System.out.println("________________" + this.resultSet.getInt("CON_CUSTOMER_ID"));
/*  419:     */           
/*  420: 419 */           consumer.setCreatedBy(this.resultSet.getString("CON_CREATED_BY"));
/*  421:     */           
/*  422:     */ 
/*  423: 422 */           consumer.setSalutation(this.resultSet
/*  424: 423 */             .getString("CON_SALUTATION"));
/*  425:     */           
/*  426:     */ 
/*  427: 426 */           consumer.setFullName(this.resultSet
/*  428: 427 */             .getString("CON_FULL_NAME"));
/*  429:     */           
/*  430: 429 */           consumer.setDob(this.resultSet
/*  431: 430 */             .getString("CON_DATE_OF_BIRTH"));
/*  432:     */           
/*  433: 432 */           consumer.setAddress1(this.resultSet
/*  434: 433 */             .getString("CON_ADDRESS_LINE_1"));
/*  435:     */           
/*  436: 435 */           consumer.setAddress2(this.resultSet
/*  437: 436 */             .getString("CON_ADDRESS_LINE_2"));
/*  438:     */           
/*  439: 438 */           consumer.setCity(this.resultSet.getString("CON_CITY"));
/*  440:     */           
/*  441: 440 */           consumer.setState(this.resultSet.getString("CON_STATE"));
/*  442:     */           
/*  443: 442 */           consumer.setPinCode(this.resultSet.getString("CON_PINCODE"));
/*  444:     */           
/*  445: 444 */           consumer.setPeimaryMailId(this.resultSet.getString("CON_PRIMARY_MAIL_ID"));
/*  446:     */           
/*  447: 446 */           consumer.setAlternativeMail(this.resultSet
/*  448: 447 */             .getString("CON_ALTERNATE_MAIL_ID"));
/*  449:     */           
/*  450: 449 */           consumer.setPhoneNo(this.resultSet
/*  451: 450 */             .getString("CON_PHONE_NO"));
/*  452:     */           
/*  453:     */ 
/*  454:     */ 
/*  455: 454 */           consumer.setMobileNo(this.resultSet
/*  456: 455 */             .getString("CON_MOBILE_NO"));
/*  457: 456 */           consumer.setFaxNo(this.resultSet
/*  458: 457 */             .getString("CON_FAX_NO"));
/*  459: 458 */           consumer.setCreationDate(this.resultSet
/*  460: 459 */             .getString("CON_CREATION_DATE"));
/*  461:     */         }
/*  462:     */       }
/*  463:     */     }
/*  464:     */     catch (SQLException sqlExp)
/*  465:     */     {
/*  466: 470 */       sqlExp.printStackTrace();
/*  467: 471 */       logger.error(
/*  468: 472 */         ConsumerCustomerDaoImpl.class + 
/*  469: 473 */         "Error: Occur in Query While Fetching the specific consumer Details from Database For Update.", 
/*  470: 474 */         sqlExp);
/*  471:     */     }
/*  472:     */     catch (Exception exception)
/*  473:     */     {
/*  474: 476 */       exception.printStackTrace();
/*  475: 477 */       logger.error(
/*  476: 478 */         ConsumerCustomerDaoImpl.class + 
/*  477: 479 */         "Error: Occur in Query While Closing Connection After Fetching the specific consumer Details from Database For Update.", 
/*  478: 480 */         exception);
/*  479:     */     }
/*  480:     */     finally
/*  481:     */     {
/*  482: 482 */       JdbcHelper.closeResultSet(this.resultSet);
/*  483: 483 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/*  484: 484 */       JdbcHelper.closeConnection(this.connection);
/*  485:     */     }
/*  486: 488 */     return consumer;
/*  487:     */   }
/*  488:     */   
/*  489:     */   public void updateSpecificConsumerRecord(ConsumerCustomerVO consumerCustomerVO, int consumerId)
/*  490:     */     throws UpdateFailedException
/*  491:     */   {
/*  492:     */     try
/*  493:     */     {
/*  494: 496 */       this.connection = getConnection();
/*  495:     */       
/*  496:     */ 
/*  497: 499 */       String fukrey = "UPDATE TAB_CONSUMER_CUSTOMER SET CON_SALUTATION=?,CON_FULL_NAME=?,CON_DATE_OF_BIRTH=?,CON_ADDRESS_LINE_1=?,CON_ADDRESS_LINE_2=?,CON_CITY=?,CON_STATE=?,CON_PINCODE=?,CON_PRIMARY_MAIL_ID=?, CON_ALTERNATE_MAIL_ID=?,CON_PHONE_NO=?,CON_MOBILE_NO=?, CON_FAX_NO=?,CON_CREATION_DATE=?,CON_WORK_LOCATION=? WHERE CON_CUSTOMER_ID=?";
/*  498:     */       
/*  499:     */ 
/*  500: 502 */       this.preparedStatement = this.connection.prepareStatement(fukrey);
/*  501: 503 */       this.preparedStatement.setString(1, consumerCustomerVO.getSalutation());
/*  502: 504 */       this.preparedStatement.setString(2, consumerCustomerVO.getFullName());
/*  503: 505 */       this.preparedStatement.setString(3, DateTimeUtil.getCurrentDate());
/*  504: 506 */       this.preparedStatement.setString(4, consumerCustomerVO.getAddress1());
/*  505: 507 */       this.preparedStatement.setString(5, consumerCustomerVO.getAddress2());
/*  506: 508 */       this.preparedStatement.setString(6, consumerCustomerVO.getCity());
/*  507: 509 */       this.preparedStatement.setString(7, consumerCustomerVO.getState());
/*  508: 510 */       this.preparedStatement.setString(8, consumerCustomerVO.getPinCode());
/*  509: 511 */       this.preparedStatement.setString(9, consumerCustomerVO.getPeimaryMailId());
/*  510: 512 */       this.preparedStatement.setString(10, consumerCustomerVO.getAlternativeMail());
/*  511: 513 */       this.preparedStatement.setString(11, consumerCustomerVO.getPhoneNo());
/*  512: 514 */       this.preparedStatement.setString(12, consumerCustomerVO.getMobileNo());
/*  513: 515 */       this.preparedStatement.setString(13, consumerCustomerVO.getFaxNo());
/*  514: 516 */       this.preparedStatement.setString(14, consumerCustomerVO.getCreationDate());
/*  515: 517 */       this.preparedStatement.setString(15, consumerCustomerVO.getWorkLocation());
/*  516: 518 */       this.preparedStatement.setInt(16, consumerId);
/*  517:     */       
/*  518: 520 */       this.preparedStatement.executeUpdate();
/*  519:     */     }
/*  520:     */     catch (SQLException sqlException)
/*  521:     */     {
/*  522: 525 */       sqlException.printStackTrace();
/*  523: 526 */       logger.error(
/*  524: 527 */         ConsumerCustomerDaoImpl.class + 
/*  525: 528 */         ": Error:- Error: Occur in Query While updating the consumer details record", 
/*  526: 529 */         sqlException);
/*  527:     */     }
/*  528:     */     catch (Exception exception)
/*  529:     */     {
/*  530: 531 */       exception.printStackTrace();
/*  531: 532 */       logger.error(
/*  532: 533 */         ConsumerCustomerDaoImpl.class + 
/*  533: 534 */         ": Error:- While closing the Connection after updating the consumer details reccord", 
/*  534: 535 */         exception);
/*  535:     */     }
/*  536:     */     finally
/*  537:     */     {
/*  538: 538 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/*  539: 539 */       JdbcHelper.closeConnection(this.connection);
/*  540:     */     }
/*  541:     */   }
/*  542:     */   
/*  543:     */   public Consumer retriveSpecificConsumerTransaction(int transId)
/*  544:     */     throws RecordNotFoundException
/*  545:     */   {
/*  546: 547 */     Consumer consumer = new Consumer();
/*  547:     */     try
/*  548:     */     {
/*  549: 550 */       System.out.println("hye bharti ur in view method");
/*  550: 551 */       this.connection = getConnection();
/*  551:     */       
/*  552: 553 */       this.preparedStatement = this.connection
/*  553: 554 */         .prepareStatement("SELECT * FROM TAB_OWNER_CUSTOMER_TRANSACTION WHERE CUSTOMER_TRANS_ID=?");
/*  554: 555 */       this.preparedStatement.setInt(1, transId);
/*  555:     */       
/*  556:     */ 
/*  557: 558 */       this.resultSet = this.preparedStatement.executeQuery();
/*  558: 559 */       System.out.println("----------hye ----------------%%" + transId);
/*  559: 560 */       if (this.resultSet != null) {
/*  560: 561 */         while (this.resultSet.next())
/*  561:     */         {
/*  562: 563 */           System.out.println("----------hye ----------------" + this.resultSet.getInt("CUSTOMER_TRANS_ID") + "****");
/*  563:     */           
/*  564: 565 */           consumer.setTransactionId(this.resultSet.getInt("CUSTOMER_TRANS_ID"));
/*  565:     */           
/*  566:     */ 
/*  567:     */ 
/*  568: 569 */           consumer.setDescription(this.resultSet.getString("CUSTOMER_TRANS_DISCRIPTION"));
/*  569:     */           
/*  570: 571 */           consumer.setTotal(this.resultSet
/*  571: 572 */             .getFloat("CUSTOMER_TRANS_TOTAL"));
/*  572:     */           
/*  573: 574 */           consumer.setPaid(this.resultSet
/*  574: 575 */             .getFloat("CUSTOMER_TRANS_PAID"));
/*  575:     */           
/*  576: 577 */           consumer.setDue(this.resultSet
/*  577: 578 */             .getFloat("CUSTOMER_TRANS_DUE"));
/*  578:     */           
/*  579:     */ 
/*  580: 581 */           consumer.setTotalPaid(this.resultSet
/*  581: 582 */             .getFloat("CUSTOMER_TRANS_TOTAL_PAID"));
/*  582:     */           
/*  583: 584 */           consumer.setTotalDue(this.resultSet
/*  584: 585 */             .getFloat("CUSTOMER_TRANS_TOTAL_DUE"));
/*  585:     */           
/*  586: 587 */           consumer.setTransactionDate(this.resultSet
/*  587: 588 */             .getString("CUSTOMER_TRANS_DATE"));
/*  588:     */           
/*  589: 590 */           consumer.setRetailerId(this.resultSet
/*  590: 591 */             .getInt("CUSTOMER_ID_CONSUMER"));
/*  591:     */           
/*  592: 593 */           consumer.setFullName(this.nameHelper.getConsumerCustomerNameById(this.resultSet
/*  593: 594 */             .getInt("CUSTOMER_ID_CONSUMER")));
/*  594:     */           
/*  595: 596 */           consumer.setPaymentMode(this.nameHelper.getPaymentModeById(this.resultSet.getInt("CUSTOMER_TRANS_PAY_MODE")));
/*  596:     */         }
/*  597:     */       }
/*  598:     */     }
/*  599:     */     catch (SQLException sqlExp)
/*  600:     */     {
/*  601: 607 */       sqlExp.printStackTrace();
/*  602: 608 */       logger.error(
/*  603: 609 */         ConsumerCustomerDaoImpl.class + 
/*  604: 610 */         "Error: Occur in Query While Fetching the specific consumer Transaction from Database.", 
/*  605: 611 */         sqlExp);
/*  606:     */     }
/*  607:     */     catch (Exception exception)
/*  608:     */     {
/*  609: 613 */       exception.printStackTrace();
/*  610: 614 */       logger.error(
/*  611: 615 */         ConsumerCustomerDaoImpl.class + 
/*  612: 616 */         "Error: Occur in Query While Closing Connection After Fetching the specific consumer Transaction from Database.", 
/*  613: 617 */         exception);
/*  614:     */     }
/*  615:     */     finally
/*  616:     */     {
/*  617: 619 */       JdbcHelper.closeResultSet(this.resultSet);
/*  618: 620 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/*  619: 621 */       JdbcHelper.closeConnection(this.connection);
/*  620:     */     }
/*  621: 625 */     return consumer;
/*  622:     */   }
/*  623:     */   
/*  624:     */   public int deleteSpecificConsumerTransaction(int transId)
/*  625:     */     throws DeleteFailedException
/*  626:     */   {
/*  627: 631 */     int effect = 0;
/*  628:     */     try
/*  629:     */     {
/*  630: 633 */       this.connection = getConnection();
/*  631:     */       
/*  632: 635 */       this.preparedStatement = this.connection.prepareStatement("DELETE FROM TAB_OWNER_CUSTOMER_TRANSACTION WHERE CUSTOMER_TRANS_ID=?");
/*  633:     */       
/*  634: 637 */       this.preparedStatement.setInt(1, transId);
/*  635:     */       
/*  636: 639 */       effect = this.preparedStatement.executeUpdate();
/*  637:     */     }
/*  638:     */     catch (SQLException sqlException)
/*  639:     */     {
/*  640: 642 */       sqlException.printStackTrace();
/*  641: 643 */       logger.error(
/*  642: 644 */         ConsumerCustomerDaoImpl.class + 
/*  643: 645 */         ": Error:- Error: Occur in Query While deleting the consumer transaction record", 
/*  644: 646 */         sqlException);
/*  645:     */     }
/*  646:     */     catch (Exception exception)
/*  647:     */     {
/*  648: 648 */       exception.printStackTrace();
/*  649: 649 */       logger.error(
/*  650: 650 */         ConsumerCustomerDaoImpl.class + 
/*  651: 651 */         ": Error:- While closing the Connection after deleting the consumer transaction reccord", 
/*  652: 652 */         exception);
/*  653:     */     }
/*  654:     */     finally
/*  655:     */     {
/*  656: 655 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/*  657: 656 */       JdbcHelper.closeConnection(this.connection);
/*  658:     */     }
/*  659: 658 */     return effect;
/*  660:     */   }
/*  661:     */   
/*  662:     */   public void consumerTransactionPrintPDF(HttpServletRequest request, HttpServletResponse response, int transId)
/*  663:     */   {
/*  664: 666 */     String companyName = "Chouksay Traders";
/*  665: 667 */     String address1 = "BUS STAND SHAMSHABAD, DIST.- VIDISHA, MADHYA PRADESH, 464001";
/*  666: 668 */     String address2 = "GSTIN: 23AJQPC8200P1Z1";
/*  667: 669 */     String address3 = "PAN NO: AJQPC8200P";
/*  668:     */     
/*  669: 671 */     String city = "Vidisha-464001";
/*  670: 672 */     String state = "(M.P.)";
/*  671:     */     
/*  672: 674 */     StringBuffer stringBuffer = null;
/*  673:     */     try
/*  674:     */     {
/*  675: 678 */       this.connection = getConnection();
/*  676:     */       
/*  677: 680 */       this.preparedStatement = this.connection
/*  678: 681 */         .prepareStatement("SELECT * FROM TAB_OWNER_CUSTOMER_TRANSACTION WHERE CUSTOMER_TRANS_ID=?");
/*  679: 682 */       this.preparedStatement.setInt(1, transId);
/*  680:     */       
/*  681:     */ 
/*  682: 685 */       this.resultSet = this.preparedStatement.executeQuery();
/*  683: 686 */       Document document = new Document(PageSize.A4);
/*  684:     */       
/*  685: 688 */       Font Font3 = new Font(Font.FontFamily.TIMES_ROMAN, 11.0F, 0);
/*  686: 689 */       Font Font2 = new Font(Font.FontFamily.TIMES_ROMAN, 6.0F, 
/*  687: 690 */         8);
/*  688: 691 */       Font Font4 = new Font(Font.FontFamily.TIMES_ROMAN, 11.0F, 1);
/*  689: 692 */       Font4.setColor(BaseColor.WHITE);
/*  690: 693 */       Font mainContent = new Font(Font.FontFamily.TIMES_ROMAN, 10.0F, 
/*  691: 694 */         0);
/*  692: 695 */       Font Font5 = new Font(Font.FontFamily.TIMES_ROMAN, 12.0F, 1);
/*  693: 696 */       Font5.setColor(BaseColor.GRAY);
/*  694: 697 */       Font Font6 = new Font(Font.FontFamily.TIMES_ROMAN, 10.0F, 1);
/*  695: 698 */       Font6.setColor(BaseColor.RED);
/*  696:     */       
/*  697:     */ 
/*  698: 701 */       response.setContentType("application/pdf");
/*  699:     */       
/*  700: 703 */       PdfWriter.getInstance(document, response.getOutputStream());
/*  701:     */       
/*  702: 705 */       document.open();
/*  703:     */       
/*  704: 707 */       String contextPath = ServletActionContext.getServletContext()
/*  705: 708 */         .getRealPath("/outer/img/rohittraders.png");
/*  706: 709 */       this.image = Image.getInstance(contextPath);
/*  707: 710 */       this.image.scaleToFit(130.0F, 70.0F);
/*  708:     */       
/*  709: 712 */       PdfPTable table1 = new PdfPTable(2);
/*  710: 713 */       table1.setWidthPercentage(100.0F);
/*  711: 714 */       Rectangle rect1 = new Rectangle(300.0F, 700.0F);
/*  712: 715 */       table1.setWidthPercentage(new float[] { 150.0F, 150.0F }, rect1);
/*  713:     */       
/*  714: 717 */       PdfPCell cell101 = new PdfPCell(this.image, false);
/*  715: 718 */       cell101.setPaddingTop(5.0F);
/*  716: 719 */       cell101.setBorder(0);
/*  717:     */       
/*  718: 721 */       Phrase phrase3 = new Phrase(companyName + "\n", Font5);
/*  719: 722 */       Phrase phrase = new Phrase(address1 + "\n", Font3);
/*  720: 723 */       Phrase phrase1 = new Phrase(address2 + "\n", Font3);
/*  721: 724 */       Phrase phrase4 = new Phrase(address3 + "\n", Font3);
/*  722: 725 */       Phrase phrase2 = new Phrase(city + "-" + state, Font3);
/*  723:     */       
/*  724: 727 */       Paragraph paragraph = new Paragraph();
/*  725: 728 */       paragraph.add(phrase3);
/*  726: 729 */       paragraph.add(phrase);
/*  727: 730 */       paragraph.add(phrase1);
/*  728: 731 */       paragraph.add(phrase4);
/*  729: 732 */       paragraph.add(phrase2);
/*  730:     */       
/*  731: 734 */       PdfPCell cell102 = new PdfPCell(paragraph);
/*  732: 735 */       cell102.setPaddingTop(5.0F);
/*  733: 736 */       cell102.setBorder(0);
/*  734: 737 */       cell102.setHorizontalAlignment(2);
/*  735:     */       
/*  736: 739 */       PdfPCell cell103 = new PdfPCell(
/*  737: 740 */         new Paragraph(
/*  738: 741 */         "   \n                                                                                                                                                                                                                                                                                                                                                  ", 
/*  739:     */         
/*  740:     */ 
/*  741: 744 */         Font2));
/*  742: 745 */       cell103.setColspan(2);
/*  743: 746 */       cell103.setBorderWidthRight(0.0F);
/*  744: 747 */       cell103.setBorderWidthLeft(0.0F);
/*  745: 748 */       cell103.setBorderWidthTop(0.5F);
/*  746: 749 */       cell103.setBorderWidthBottom(0.0F);
/*  747: 750 */       cell103.setBorderColorTop(BaseColor.WHITE);
/*  748:     */       
/*  749: 752 */       PdfPCell cell104 = new PdfPCell(new Paragraph("CONSUMER TRANSACTION", Font4));
/*  750: 753 */       cell104.setUseBorderPadding(true);
/*  751: 754 */       cell104.setColspan(2);
/*  752: 755 */       cell104.setBorderWidthRight(0.1F);
/*  753: 756 */       cell104.setBorderWidthLeft(0.1F);
/*  754: 757 */       cell104.setBorderWidthTop(0.1F);
/*  755: 758 */       cell104.setBorderWidthBottom(0.1F);
/*  756: 759 */       cell104.setBorderColor(BaseColor.LIGHT_GRAY);
/*  757: 760 */       cell104.setBackgroundColor(new BaseColor(0, 59, 119));
/*  758:     */       
/*  759: 762 */       table1.addCell(cell101);
/*  760: 763 */       table1.addCell(cell102);
/*  761: 764 */       table1.addCell(cell103);
/*  762: 765 */       table1.addCell(cell104);
/*  763: 766 */       document.add(table1);
/*  764: 772 */       while (this.resultSet.next())
/*  765:     */       {
/*  766: 773 */         stringBuffer = new StringBuffer();
/*  767: 774 */         PdfPTable table = new PdfPTable(2);
/*  768: 775 */         table.setFooterRows(1);
/*  769: 776 */         table.setWidthPercentage(100.0F);
/*  770: 777 */         Rectangle rect = new Rectangle(300.0F, 700.0F);
/*  771: 778 */         table.setWidthPercentage(new float[] { 80.0F, 220.0F }, rect);
/*  772:     */         
/*  773: 780 */         PdfPCell cell = new PdfPCell(new Paragraph());
/*  774: 781 */         cell.setColspan(2);
/*  775: 782 */         cell.setBorderWidthRight(0.1F);
/*  776: 783 */         cell.setBorderWidthLeft(0.1F);
/*  777: 784 */         cell.setBorderWidthTop(0.1F);
/*  778: 785 */         cell.setBorderWidthBottom(0.2F);
/*  779: 786 */         cell.setBorderColor(BaseColor.LIGHT_GRAY);
/*  780: 787 */         cell.setBackgroundColor(new BaseColor(238, 238, 238));
/*  781:     */         
/*  782: 789 */         PdfPCell cell1 = new PdfPCell(new Paragraph());
/*  783: 790 */         cell1.setBackgroundColor(new BaseColor(238, 238, 238));
/*  784: 791 */         cell1.setBorderWidth(0.01F);
/*  785: 792 */         cell1.setBorderColor(BaseColor.WHITE);
/*  786:     */         
/*  787: 794 */         PdfPCell cell2 = new PdfPCell(new Paragraph());
/*  788: 795 */         cell2.setBackgroundColor(new BaseColor(238, 238, 238));
/*  789: 796 */         cell2.setBorderWidth(0.2F);
/*  790: 797 */         cell2.setBorderColor(BaseColor.WHITE);
/*  791:     */         
/*  792: 799 */         PdfPCell cell3 = new PdfPCell(new Paragraph("Transaction Id", 
/*  793: 800 */           mainContent));
/*  794: 801 */         cell3.setBackgroundColor(new BaseColor(238, 238, 238));
/*  795: 802 */         cell3.setBorderWidth(0.01F);
/*  796: 803 */         cell3.setBorderColor(BaseColor.WHITE);
/*  797:     */         
/*  798: 805 */         PdfPCell cell4 = new PdfPCell(new Paragraph(this.resultSet.getString("CUSTOMER_TRANS_ID"), mainContent));
/*  799: 806 */         cell4.setBorderWidth(0.2F);
/*  800: 807 */         cell4.setBorderColor(BaseColor.LIGHT_GRAY);
/*  801:     */         
/*  802: 809 */         PdfPCell cell5 = new PdfPCell(new Paragraph(
/*  803: 810 */           "Description", mainContent));
/*  804: 811 */         cell5.setBackgroundColor(new BaseColor(238, 238, 238));
/*  805: 812 */         cell5.setBorderWidth(0.01F);
/*  806: 813 */         cell5.setBorderColor(BaseColor.WHITE);
/*  807:     */         
/*  808: 815 */         PdfPCell cell6 = new PdfPCell(new Paragraph(this.resultSet.getString("CUSTOMER_TRANS_DISCRIPTION"), mainContent));
/*  809: 816 */         cell6.setBorderWidth(0.2F);
/*  810: 817 */         cell6.setBorderColor(BaseColor.LIGHT_GRAY);
/*  811:     */         
/*  812: 819 */         PdfPCell cell7 = new PdfPCell(new Paragraph("Total", 
/*  813: 820 */           mainContent));
/*  814: 821 */         cell7.setBackgroundColor(new BaseColor(238, 238, 238));
/*  815: 822 */         cell7.setBorderWidth(0.01F);
/*  816: 823 */         cell7.setBorderColor(BaseColor.WHITE);
/*  817:     */         
/*  818: 825 */         PdfPCell cell8 = new PdfPCell(new Paragraph(
/*  819: 826 */           this.resultSet.getString("CUSTOMER_TRANS_TOTAL"), mainContent));
/*  820: 827 */         cell8.setBorderWidth(0.2F);
/*  821: 828 */         cell8.setBorderColor(BaseColor.LIGHT_GRAY);
/*  822:     */         
/*  823:     */ 
/*  824:     */ 
/*  825: 832 */         PdfPCell cell9 = new PdfPCell(new Paragraph("Paid", 
/*  826: 833 */           mainContent));
/*  827: 834 */         cell9.setBorderWidth(0.2F);
/*  828: 835 */         cell9.setBorderColor(BaseColor.LIGHT_GRAY);
/*  829:     */         
/*  830: 837 */         PdfPCell cell10 = new PdfPCell(new Paragraph(
/*  831: 838 */           this.resultSet.getString("CUSTOMER_TRANS_PAID"), mainContent));
/*  832: 839 */         cell10.setBorderWidth(0.2F);
/*  833: 840 */         cell10.setBorderColor(BaseColor.LIGHT_GRAY);
/*  834:     */         
/*  835: 842 */         PdfPCell cell11 = new PdfPCell(new Paragraph("Due", 
/*  836: 843 */           mainContent));
/*  837: 844 */         cell11.setBackgroundColor(new BaseColor(238, 238, 238));
/*  838: 845 */         cell11.setBorderWidth(0.01F);
/*  839: 846 */         cell11.setBorderColor(BaseColor.WHITE);
/*  840:     */         
/*  841: 848 */         PdfPCell cell12 = new PdfPCell(new Paragraph(this.resultSet.getString("CUSTOMER_TRANS_DUE"), mainContent));
/*  842: 849 */         cell12.setBorderWidth(0.2F);
/*  843: 850 */         cell12.setBorderColor(BaseColor.LIGHT_GRAY);
/*  844:     */         
/*  845: 852 */         PdfPCell cell13 = new PdfPCell(new Paragraph("Total Paid", 
/*  846: 853 */           mainContent));
/*  847: 854 */         cell13.setBackgroundColor(new BaseColor(238, 238, 238));
/*  848: 855 */         cell13.setBorderWidth(0.01F);
/*  849: 856 */         cell13.setBorderColor(BaseColor.WHITE);
/*  850:     */         
/*  851: 858 */         PdfPCell cell14 = new PdfPCell(new Paragraph(this.resultSet.getString("CUSTOMER_TRANS_TOTAL_PAID"), mainContent));
/*  852: 859 */         cell14.setBorderWidth(0.2F);
/*  853: 860 */         cell14.setBorderColor(BaseColor.LIGHT_GRAY);
/*  854:     */         
/*  855: 862 */         PdfPCell cell15 = new PdfPCell(new Paragraph(
/*  856: 863 */           "SGST", mainContent));
/*  857: 864 */         cell15.setBackgroundColor(new BaseColor(238, 238, 238));
/*  858: 865 */         cell15.setBorderWidth(0.01F);
/*  859: 866 */         cell15.setBorderColor(BaseColor.WHITE);
/*  860:     */         
/*  861: 868 */         PdfPCell cell16 = new PdfPCell(new Paragraph(this.resultSet.getString("CUSTOMER_TRANS_TOTAL_DUE"), mainContent));
/*  862: 869 */         cell16.setBorderWidth(0.2F);
/*  863: 870 */         cell16.setBorderColor(BaseColor.LIGHT_GRAY);
/*  864:     */         
/*  865: 872 */         PdfPCell cell17 = new PdfPCell(new Paragraph("Bill No", 
/*  866: 873 */           mainContent));
/*  867: 874 */         cell17.setBackgroundColor(new BaseColor(238, 238, 238));
/*  868: 875 */         cell17.setBorderWidth(0.01F);
/*  869: 876 */         cell17.setBorderColor(BaseColor.WHITE);
/*  870:     */         
/*  871: 878 */         PdfPCell cell18 = new PdfPCell(new Paragraph(this.resultSet.getString("CUSTOMER_UNIQUE_ID"), mainContent));
/*  872: 879 */         cell18.setBorderWidth(0.2F);
/*  873: 880 */         cell18.setBorderColor(BaseColor.LIGHT_GRAY);
/*  874:     */         
/*  875: 882 */         PdfPCell cell19 = new PdfPCell(new Paragraph("Payment Mode", 
/*  876: 883 */           mainContent));
/*  877: 884 */         cell19.setBackgroundColor(new BaseColor(238, 238, 238));
/*  878: 885 */         cell19.setBorderWidth(0.01F);
/*  879: 886 */         cell19.setBorderColor(BaseColor.WHITE);
/*  880:     */         
/*  881: 888 */         PdfPCell cell20 = new PdfPCell(new Paragraph(this.resultSet.getString("CUSTOMER_TRANS_PAY_MODE"), mainContent));
/*  882: 889 */         cell20.setBorderWidth(0.2F);
/*  883: 890 */         cell20.setBorderColor(BaseColor.LIGHT_GRAY);
/*  884:     */         
/*  885: 892 */         PdfPCell cell21 = new PdfPCell(new Paragraph("Transaction Date", 
/*  886: 893 */           mainContent));
/*  887: 894 */         cell21.setBackgroundColor(new BaseColor(238, 238, 238));
/*  888: 895 */         cell21.setBorderWidth(0.01F);
/*  889: 896 */         cell21.setBorderColor(BaseColor.WHITE);
/*  890:     */         
/*  891: 898 */         PdfPCell cell22 = new PdfPCell(new Paragraph(this.resultSet.getString("CUSTOMER_TRANS_DATE"), mainContent));
/*  892: 899 */         cell22.setBorderWidth(0.2F);
/*  893: 900 */         cell22.setBorderColor(BaseColor.LIGHT_GRAY);
/*  894:     */         
/*  895: 902 */         PdfPCell cell23 = new PdfPCell(new Paragraph(
/*  896: 903 */           "Consumer Reference", mainContent));
/*  897: 904 */         cell23.setBackgroundColor(new BaseColor(238, 238, 238));
/*  898: 905 */         cell23.setBorderWidth(0.01F);
/*  899: 906 */         cell23.setBorderColor(BaseColor.WHITE);
/*  900:     */         
/*  901: 908 */         PdfPCell cell24 = new PdfPCell(
/*  902: 909 */           new Paragraph(this.resultSet.getString(
/*  903: 910 */           "CUSTOMER_ID_CONSUMER"), 
/*  904: 911 */           mainContent));
/*  905: 912 */         cell24.setBorderWidth(0.2F);
/*  906: 913 */         cell24.setBorderColor(BaseColor.LIGHT_GRAY);
/*  907:     */         
/*  908:     */ 
/*  909:     */ 
/*  910:     */ 
/*  911:     */ 
/*  912:     */ 
/*  913:     */ 
/*  914:     */ 
/*  915:     */ 
/*  916:     */ 
/*  917:     */ 
/*  918:     */ 
/*  919:     */ 
/*  920:     */ 
/*  921:     */ 
/*  922:     */ 
/*  923:     */ 
/*  924:     */ 
/*  925:     */ 
/*  926:     */ 
/*  927:     */ 
/*  928:     */ 
/*  929:     */ 
/*  930:     */ 
/*  931:     */ 
/*  932:     */ 
/*  933:     */ 
/*  934:     */ 
/*  935:     */ 
/*  936:     */ 
/*  937:     */ 
/*  938:     */ 
/*  939:     */ 
/*  940:     */ 
/*  941:     */ 
/*  942:     */ 
/*  943:     */ 
/*  944:     */ 
/*  945:     */ 
/*  946:     */ 
/*  947:     */ 
/*  948:     */ 
/*  949:     */ 
/*  950:     */ 
/*  951:     */ 
/*  952:     */ 
/*  953:     */ 
/*  954:     */ 
/*  955:     */ 
/*  956:     */ 
/*  957:     */ 
/*  958:     */ 
/*  959:     */ 
/*  960:     */ 
/*  961:     */ 
/*  962:     */ 
/*  963:     */ 
/*  964:     */ 
/*  965:     */ 
/*  966:     */ 
/*  967:     */ 
/*  968:     */ 
/*  969:     */ 
/*  970:     */ 
/*  971:     */ 
/*  972:     */ 
/*  973:     */ 
/*  974:     */ 
/*  975:     */ 
/*  976:     */ 
/*  977:     */ 
/*  978:     */ 
/*  979:     */ 
/*  980:     */ 
/*  981:     */ 
/*  982:     */ 
/*  983:     */ 
/*  984:     */ 
/*  985:     */ 
/*  986:     */ 
/*  987:     */ 
/*  988:     */ 
/*  989:     */ 
/*  990:     */ 
/*  991:     */ 
/*  992:     */ 
/*  993:     */ 
/*  994:     */ 
/*  995:     */ 
/*  996:     */ 
/*  997:     */ 
/*  998:     */ 
/*  999:     */ 
/* 1000:     */ 
/* 1001:     */ 
/* 1002:     */ 
/* 1003:     */ 
/* 1004:     */ 
/* 1005:     */ 
/* 1006:     */ 
/* 1007:     */ 
/* 1008:     */ 
/* 1009:     */ 
/* 1010:     */ 
/* 1011:     */ 
/* 1012:     */ 
/* 1013:     */ 
/* 1014:     */ 
/* 1015:     */ 
/* 1016:     */ 
/* 1017:     */ 
/* 1018:     */ 
/* 1019:     */ 
/* 1020:     */ 
/* 1021:     */ 
/* 1022:     */ 
/* 1023:     */ 
/* 1024:     */ 
/* 1025:     */ 
/* 1026:     */ 
/* 1027:     */ 
/* 1028:     */ 
/* 1029:     */ 
/* 1030:     */ 
/* 1031:     */ 
/* 1032:     */ 
/* 1033:     */ 
/* 1034:     */ 
/* 1035:     */ 
/* 1036:     */ 
/* 1037:     */ 
/* 1038:     */ 
/* 1039:     */ 
/* 1040:     */ 
/* 1041:     */ 
/* 1042:     */ 
/* 1043:     */ 
/* 1044:     */ 
/* 1045:     */ 
/* 1046:     */ 
/* 1047:     */ 
/* 1048:     */ 
/* 1049:     */ 
/* 1050:     */ 
/* 1051:     */ 
/* 1052:     */ 
/* 1053:     */ 
/* 1054:     */ 
/* 1055:     */ 
/* 1056:     */ 
/* 1057:     */ 
/* 1058:     */ 
/* 1059:     */ 
/* 1060:     */ 
/* 1061:     */ 
/* 1062:     */ 
/* 1063:     */ 
/* 1064:     */ 
/* 1065:     */ 
/* 1066:     */ 
/* 1067:     */ 
/* 1068:     */ 
/* 1069:     */ 
/* 1070:     */ 
/* 1071:     */ 
/* 1072:     */ 
/* 1073:     */ 
/* 1074:     */ 
/* 1075:     */ 
/* 1076:     */ 
/* 1077:     */ 
/* 1078:     */ 
/* 1079:     */ 
/* 1080:     */ 
/* 1081:     */ 
/* 1082:     */ 
/* 1083:     */ 
/* 1084:     */ 
/* 1085:     */ 
/* 1086:     */ 
/* 1087:     */ 
/* 1088:     */ 
/* 1089:     */ 
/* 1090:     */ 
/* 1091:     */ 
/* 1092:     */ 
/* 1093:     */ 
/* 1094:     */ 
/* 1095:     */ 
/* 1096:     */ 
/* 1097:     */ 
/* 1098:     */ 
/* 1099:     */ 
/* 1100:     */ 
/* 1101:     */ 
/* 1102:     */ 
/* 1103:     */ 
/* 1104:     */ 
/* 1105:     */ 
/* 1106:     */ 
/* 1107:     */ 
/* 1108:1115 */         table.addCell(cell);
/* 1109:1116 */         table.addCell(cell1);
/* 1110:1117 */         table.addCell(cell2);
/* 1111:1118 */         table.addCell(cell3);
/* 1112:1119 */         table.addCell(cell4);
/* 1113:1120 */         table.addCell(cell5);
/* 1114:1121 */         table.addCell(cell6);
/* 1115:1122 */         table.addCell(cell7);
/* 1116:1123 */         table.addCell(cell8);
/* 1117:1124 */         table.addCell(cell9);
/* 1118:1125 */         table.addCell(cell10);
/* 1119:1126 */         table.addCell(cell11);
/* 1120:1127 */         table.addCell(cell12);
/* 1121:1128 */         table.addCell(cell13);
/* 1122:1129 */         table.addCell(cell14);
/* 1123:1130 */         table.addCell(cell15);
/* 1124:1131 */         table.addCell(cell16);
/* 1125:1132 */         table.addCell(cell17);
/* 1126:1133 */         table.addCell(cell18);
/* 1127:1134 */         table.addCell(cell19);
/* 1128:1135 */         table.addCell(cell20);
/* 1129:1136 */         table.addCell(cell21);
/* 1130:1137 */         table.addCell(cell22);
/* 1131:1138 */         table.addCell(cell23);
/* 1132:1139 */         table.addCell(cell24);
/* 1133:     */         
/* 1134:     */ 
/* 1135:     */ 
/* 1136:     */ 
/* 1137:     */ 
/* 1138:     */ 
/* 1139:     */ 
/* 1140:     */ 
/* 1141:     */ 
/* 1142:     */ 
/* 1143:     */ 
/* 1144:     */ 
/* 1145:     */ 
/* 1146:     */ 
/* 1147:     */ 
/* 1148:     */ 
/* 1149:     */ 
/* 1150:     */ 
/* 1151:     */ 
/* 1152:     */ 
/* 1153:     */ 
/* 1154:     */ 
/* 1155:     */ 
/* 1156:     */ 
/* 1157:     */ 
/* 1158:     */ 
/* 1159:     */ 
/* 1160:     */ 
/* 1161:     */ 
/* 1162:     */ 
/* 1163:     */ 
/* 1164:     */ 
/* 1165:     */ 
/* 1166:     */ 
/* 1167:     */ 
/* 1168:     */ 
/* 1169:     */ 
/* 1170:     */ 
/* 1171:1178 */         document.add(table);
/* 1172:     */       }
/* 1173:1182 */       document.add(new Paragraph("\n"));
/* 1174:     */       
/* 1175:     */ 
/* 1176:     */ 
/* 1177:1186 */       document.close();
/* 1178:     */     }
/* 1179:     */     catch (SQLException sqlExp)
/* 1180:     */     {
/* 1181:1189 */       sqlExp.printStackTrace();
/* 1182:1190 */       logger.error(
/* 1183:1191 */         DealerDaoImpl.class + 
/* 1184:1192 */         "Error: Occur in Query While Fetching All customer Transaction for print PdF from Database.", 
/* 1185:1193 */         sqlExp);
/* 1186:     */     }
/* 1187:     */     catch (Exception exception)
/* 1188:     */     {
/* 1189:1195 */       exception.printStackTrace();
/* 1190:1196 */       logger.error(
/* 1191:1197 */         DealerDaoImpl.class + 
/* 1192:1198 */         "Error: Occur in Query While Closing Connection After Fetching All customer Transaction for print PdF from Database.", 
/* 1193:1199 */         exception);
/* 1194:     */     }
/* 1195:     */     finally
/* 1196:     */     {
/* 1197:1201 */       JdbcHelper.closeResultSet(this.resultSet);
/* 1198:1202 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/* 1199:1203 */       JdbcHelper.closeConnection(this.connection);
/* 1200:     */     }
/* 1201:     */   }
/* 1202:     */   
/* 1203:     */   public void consumerDetailsPrintPDF(HttpServletRequest request, HttpServletResponse response, int transId)
/* 1204:     */   {
/* 1205:1211 */     String companyName = "Chouksay Traders";
/* 1206:1212 */     String address1 = "BUS STAND SHAMSHABAD, DIST.- VIDISHA, MADHYA PRADESH, 464001";
/* 1207:1213 */     String address2 = "GSTIN: 23AJQPC8200P1Z1";
/* 1208:1214 */     String address3 = "PAN NO: AJQPC8200P";
/* 1209:     */     
/* 1210:1216 */     String city = "Vidisha-464001";
/* 1211:1217 */     String state = "(M.P.)";
/* 1212:     */     
/* 1213:1219 */     StringBuffer stringBuffer = null;
/* 1214:1220 */     System.out.println("we r dealer dao for print" + transId);
/* 1215:     */     try
/* 1216:     */     {
/* 1217:1223 */       this.connection = getConnection();
/* 1218:1224 */       this.preparedStatement = this.connection
/* 1219:1225 */         .prepareStatement("SELECT * FROM  TAB_CONSUMER_CUSTOMER WHERE CON_CUSTOMER_STATUS='ACTIVE' AND CON_CUSTOMER_ID=?");
/* 1220:1226 */       this.preparedStatement.setInt(1, transId);
/* 1221:1227 */       this.resultSet = this.preparedStatement.executeQuery();
/* 1222:1228 */       Document document = new Document(PageSize.A4);
/* 1223:     */       
/* 1224:1230 */       Font Font3 = new Font(Font.FontFamily.TIMES_ROMAN, 11.0F, 0);
/* 1225:1231 */       Font Font2 = new Font(Font.FontFamily.TIMES_ROMAN, 6.0F, 
/* 1226:1232 */         8);
/* 1227:1233 */       Font Font4 = new Font(Font.FontFamily.TIMES_ROMAN, 11.0F, 1);
/* 1228:1234 */       Font4.setColor(BaseColor.WHITE);
/* 1229:1235 */       Font mainContent = new Font(Font.FontFamily.TIMES_ROMAN, 10.0F, 
/* 1230:1236 */         0);
/* 1231:1237 */       Font Font5 = new Font(Font.FontFamily.TIMES_ROMAN, 12.0F, 1);
/* 1232:1238 */       Font5.setColor(BaseColor.GRAY);
/* 1233:1239 */       Font Font6 = new Font(Font.FontFamily.TIMES_ROMAN, 10.0F, 1);
/* 1234:1240 */       Font6.setColor(BaseColor.RED);
/* 1235:     */       
/* 1236:     */ 
/* 1237:1243 */       response.setContentType("application/pdf");
/* 1238:     */       
/* 1239:1245 */       PdfWriter.getInstance(document, response.getOutputStream());
/* 1240:     */       
/* 1241:1247 */       document.open();
/* 1242:     */       
/* 1243:1249 */       String contextPath = ServletActionContext.getServletContext()
/* 1244:1250 */         .getRealPath("/outer/img/rohittraders.png");
/* 1245:1251 */       this.image = Image.getInstance(contextPath);
/* 1246:1252 */       this.image.scaleToFit(130.0F, 70.0F);
/* 1247:     */       
/* 1248:1254 */       PdfPTable table1 = new PdfPTable(2);
/* 1249:1255 */       table1.setWidthPercentage(100.0F);
/* 1250:1256 */       Rectangle rect1 = new Rectangle(300.0F, 700.0F);
/* 1251:1257 */       table1.setWidthPercentage(new float[] { 150.0F, 150.0F }, rect1);
/* 1252:     */       
/* 1253:1259 */       PdfPCell cell101 = new PdfPCell(this.image, false);
/* 1254:1260 */       cell101.setPaddingTop(5.0F);
/* 1255:1261 */       cell101.setBorder(0);
/* 1256:     */       
/* 1257:1263 */       Phrase phrase3 = new Phrase(companyName + "\n", Font5);
/* 1258:1264 */       Phrase phrase = new Phrase(address1 + "\n", Font3);
/* 1259:1265 */       Phrase phrase1 = new Phrase(address2 + "\n", Font3);
/* 1260:1266 */       Phrase phrase4 = new Phrase(address3 + "\n", Font3);
/* 1261:1267 */       Phrase phrase2 = new Phrase(city + "-" + state, Font3);
/* 1262:     */       
/* 1263:1269 */       Paragraph paragraph = new Paragraph();
/* 1264:1270 */       paragraph.add(phrase3);
/* 1265:1271 */       paragraph.add(phrase);
/* 1266:1272 */       paragraph.add(phrase1);
/* 1267:1273 */       paragraph.add(phrase4);
/* 1268:1274 */       paragraph.add(phrase2);
/* 1269:     */       
/* 1270:1276 */       PdfPCell cell102 = new PdfPCell(paragraph);
/* 1271:1277 */       cell102.setPaddingTop(5.0F);
/* 1272:1278 */       cell102.setBorder(0);
/* 1273:1279 */       cell102.setHorizontalAlignment(2);
/* 1274:     */       
/* 1275:1281 */       PdfPCell cell103 = new PdfPCell(
/* 1276:1282 */         new Paragraph(
/* 1277:1283 */         "   \n                                                                                                                                                                                                                                                                                                                                                  ", 
/* 1278:     */         
/* 1279:     */ 
/* 1280:1286 */         Font2));
/* 1281:1287 */       cell103.setColspan(2);
/* 1282:1288 */       cell103.setBorderWidthRight(0.0F);
/* 1283:1289 */       cell103.setBorderWidthLeft(0.0F);
/* 1284:1290 */       cell103.setBorderWidthTop(0.5F);
/* 1285:1291 */       cell103.setBorderWidthBottom(0.0F);
/* 1286:1292 */       cell103.setBorderColorTop(BaseColor.WHITE);
/* 1287:     */       
/* 1288:1294 */       PdfPCell cell104 = new PdfPCell(new Paragraph("CONSUMER DETAIL", Font4));
/* 1289:1295 */       cell104.setUseBorderPadding(true);
/* 1290:1296 */       cell104.setColspan(2);
/* 1291:1297 */       cell104.setBorderWidthRight(0.1F);
/* 1292:1298 */       cell104.setBorderWidthLeft(0.1F);
/* 1293:1299 */       cell104.setBorderWidthTop(0.1F);
/* 1294:1300 */       cell104.setBorderWidthBottom(0.1F);
/* 1295:1301 */       cell104.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1296:1302 */       cell104.setBackgroundColor(new BaseColor(0, 59, 119));
/* 1297:     */       
/* 1298:1304 */       table1.addCell(cell101);
/* 1299:1305 */       table1.addCell(cell102);
/* 1300:1306 */       table1.addCell(cell103);
/* 1301:1307 */       table1.addCell(cell104);
/* 1302:1308 */       document.add(table1);
/* 1303:1314 */       while (this.resultSet.next())
/* 1304:     */       {
/* 1305:1315 */         stringBuffer = new StringBuffer();
/* 1306:1316 */         PdfPTable table = new PdfPTable(2);
/* 1307:1317 */         table.setFooterRows(1);
/* 1308:1318 */         table.setWidthPercentage(100.0F);
/* 1309:1319 */         Rectangle rect = new Rectangle(300.0F, 700.0F);
/* 1310:1320 */         table.setWidthPercentage(new float[] { 80.0F, 220.0F }, rect);
/* 1311:     */         
/* 1312:1322 */         PdfPCell cell = new PdfPCell(new Paragraph());
/* 1313:1323 */         cell.setColspan(2);
/* 1314:1324 */         cell.setBorderWidthRight(0.1F);
/* 1315:1325 */         cell.setBorderWidthLeft(0.1F);
/* 1316:1326 */         cell.setBorderWidthTop(0.1F);
/* 1317:1327 */         cell.setBorderWidthBottom(0.2F);
/* 1318:1328 */         cell.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1319:1329 */         cell.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1320:     */         
/* 1321:1331 */         PdfPCell cell1 = new PdfPCell(new Paragraph());
/* 1322:1332 */         cell1.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1323:1333 */         cell1.setBorderWidth(0.01F);
/* 1324:1334 */         cell1.setBorderColor(BaseColor.WHITE);
/* 1325:     */         
/* 1326:1336 */         PdfPCell cell2 = new PdfPCell(new Paragraph());
/* 1327:1337 */         cell2.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1328:1338 */         cell2.setBorderWidth(0.2F);
/* 1329:1339 */         cell2.setBorderColor(BaseColor.WHITE);
/* 1330:     */         
/* 1331:1341 */         PdfPCell cell3 = new PdfPCell(new Paragraph("Consumer Id", 
/* 1332:1342 */           mainContent));
/* 1333:1343 */         cell3.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1334:1344 */         cell3.setBorderWidth(0.01F);
/* 1335:1345 */         cell3.setBorderColor(BaseColor.WHITE);
/* 1336:     */         
/* 1337:1347 */         PdfPCell cell4 = new PdfPCell(new Paragraph(this.resultSet.getString("CON_CUSTOMER_ID"), mainContent));
/* 1338:1348 */         cell4.setBorderWidth(0.2F);
/* 1339:1349 */         cell4.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1340:     */         
/* 1341:1351 */         PdfPCell cell5 = new PdfPCell(new Paragraph(
/* 1342:1352 */           "Salutation", mainContent));
/* 1343:1353 */         cell5.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1344:1354 */         cell5.setBorderWidth(0.01F);
/* 1345:1355 */         cell5.setBorderColor(BaseColor.WHITE);
/* 1346:     */         
/* 1347:     */ 
/* 1348:1358 */         PdfPCell cell6 = new PdfPCell(new Paragraph(this.resultSet.getString("CON_SALUTATION"), mainContent));
/* 1349:1359 */         cell6.setBorderWidth(0.2F);
/* 1350:1360 */         cell6.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1351:     */         
/* 1352:1362 */         PdfPCell cell7 = new PdfPCell(new Paragraph("Full name", 
/* 1353:1363 */           mainContent));
/* 1354:1364 */         cell7.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1355:1365 */         cell7.setBorderWidth(0.01F);
/* 1356:1366 */         cell7.setBorderColor(BaseColor.WHITE);
/* 1357:     */         
/* 1358:1368 */         PdfPCell cell8 = new PdfPCell(new Paragraph(
/* 1359:1369 */           this.resultSet.getString("CON_FULL_NAME"), mainContent));
/* 1360:1370 */         cell8.setBorderWidth(0.2F);
/* 1361:1371 */         cell8.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1362:     */         
/* 1363:     */ 
/* 1364:     */ 
/* 1365:1375 */         PdfPCell cell9 = new PdfPCell(new Paragraph("DOB", 
/* 1366:1376 */           mainContent));
/* 1367:1377 */         cell9.setBorderWidth(0.2F);
/* 1368:1378 */         cell9.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1369:     */         
/* 1370:1380 */         PdfPCell cell10 = new PdfPCell(new Paragraph(
/* 1371:1381 */           this.resultSet.getString("CON_DATE_OF_BIRTH"), mainContent));
/* 1372:1382 */         cell10.setBorderWidth(0.2F);
/* 1373:1383 */         cell10.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1374:     */         
/* 1375:1385 */         PdfPCell cell11 = new PdfPCell(new Paragraph("Address", 
/* 1376:1386 */           mainContent));
/* 1377:1387 */         cell11.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1378:1388 */         cell11.setBorderWidth(0.01F);
/* 1379:1389 */         cell11.setBorderColor(BaseColor.WHITE);
/* 1380:     */         
/* 1381:1391 */         PdfPCell cell12 = new PdfPCell(new Paragraph(this.resultSet.getString("CON_ADDRESS_LINE_1"), mainContent));
/* 1382:1392 */         cell12.setBorderWidth(0.2F);
/* 1383:1393 */         cell12.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1384:     */         
/* 1385:1395 */         PdfPCell cell13 = new PdfPCell(new Paragraph("Alternative Address", 
/* 1386:1396 */           mainContent));
/* 1387:1397 */         cell13.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1388:1398 */         cell13.setBorderWidth(0.01F);
/* 1389:1399 */         cell13.setBorderColor(BaseColor.WHITE);
/* 1390:     */         
/* 1391:1401 */         PdfPCell cell14 = new PdfPCell(new Paragraph(this.resultSet.getString("CON_ADDRESS_LINE_2"), mainContent));
/* 1392:1402 */         cell14.setBorderWidth(0.2F);
/* 1393:1403 */         cell14.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1394:     */         
/* 1395:1405 */         PdfPCell cell15 = new PdfPCell(new Paragraph(
/* 1396:1406 */           "City", mainContent));
/* 1397:1407 */         cell15.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1398:1408 */         cell15.setBorderWidth(0.01F);
/* 1399:1409 */         cell15.setBorderColor(BaseColor.WHITE);
/* 1400:     */         
/* 1401:1411 */         PdfPCell cell16 = new PdfPCell(new Paragraph(this.nameHelper.getCityNameByCityId(this.resultSet.getInt("CON_CITY")), mainContent));
/* 1402:1412 */         cell16.setBorderWidth(0.2F);
/* 1403:1413 */         cell16.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1404:     */         
/* 1405:1415 */         PdfPCell cell17 = new PdfPCell(new Paragraph("State", 
/* 1406:1416 */           mainContent));
/* 1407:1417 */         cell17.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1408:1418 */         cell17.setBorderWidth(0.01F);
/* 1409:1419 */         cell17.setBorderColor(BaseColor.WHITE);
/* 1410:     */         
/* 1411:1421 */         PdfPCell cell18 = new PdfPCell(new Paragraph(String.valueOf(this.nameHelper.getStateNameByStateId(this.resultSet.getInt("CON_STATE"))), mainContent));
/* 1412:1422 */         cell18.setBorderWidth(0.2F);
/* 1413:1423 */         cell18.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1414:     */         
/* 1415:1425 */         PdfPCell cell19 = new PdfPCell(new Paragraph("Pincode", 
/* 1416:1426 */           mainContent));
/* 1417:1427 */         cell19.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1418:1428 */         cell19.setBorderWidth(0.01F);
/* 1419:1429 */         cell19.setBorderColor(BaseColor.WHITE);
/* 1420:     */         
/* 1421:1431 */         PdfPCell cell20 = new PdfPCell(new Paragraph(this.resultSet.getString("CON_PINCODE"), mainContent));
/* 1422:1432 */         cell20.setBorderWidth(0.2F);
/* 1423:1433 */         cell20.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1424:     */         
/* 1425:1435 */         PdfPCell cell21 = new PdfPCell(new Paragraph("Primary Mail", 
/* 1426:1436 */           mainContent));
/* 1427:1437 */         cell21.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1428:1438 */         cell21.setBorderWidth(0.01F);
/* 1429:1439 */         cell21.setBorderColor(BaseColor.WHITE);
/* 1430:     */         
/* 1431:1441 */         PdfPCell cell22 = new PdfPCell(new Paragraph(this.resultSet.getString("CON_PRIMARY_MAIL_ID"), mainContent));
/* 1432:1442 */         cell22.setBorderWidth(0.2F);
/* 1433:1443 */         cell22.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1434:     */         
/* 1435:1445 */         PdfPCell cell23 = new PdfPCell(new Paragraph(
/* 1436:1446 */           "Alternative Mail Id", mainContent));
/* 1437:1447 */         cell23.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1438:1448 */         cell23.setBorderWidth(0.01F);
/* 1439:1449 */         cell23.setBorderColor(BaseColor.WHITE);
/* 1440:     */         
/* 1441:1451 */         PdfPCell cell24 = new PdfPCell(
/* 1442:1452 */           new Paragraph(this.resultSet.getString(
/* 1443:1453 */           "CON_ALTERNATE_MAIL_ID"), 
/* 1444:1454 */           mainContent));
/* 1445:1455 */         cell24.setBorderWidth(0.2F);
/* 1446:1456 */         cell24.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1447:     */         
/* 1448:1458 */         PdfPCell cell25 = new PdfPCell(new Paragraph("Phone No", 
/* 1449:1459 */           mainContent));
/* 1450:1460 */         cell25.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1451:1461 */         cell25.setBorderWidth(0.01F);
/* 1452:1462 */         cell25.setBorderColor(BaseColor.WHITE);
/* 1453:     */         
/* 1454:1464 */         PdfPCell cell26 = new PdfPCell(new Paragraph(
/* 1455:1465 */           this.resultSet.getString("CON_PHONE_NO"), mainContent));
/* 1456:1466 */         cell26.setBorderWidth(0.2F);
/* 1457:1467 */         cell26.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1458:     */         
/* 1459:1469 */         PdfPCell cell27 = new PdfPCell(new Paragraph("Mobile No", 
/* 1460:1470 */           mainContent));
/* 1461:1471 */         cell27.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1462:1472 */         cell27.setBorderWidth(0.01F);
/* 1463:1473 */         cell27.setBorderColor(BaseColor.WHITE);
/* 1464:     */         
/* 1465:1475 */         PdfPCell cell28 = new PdfPCell(new Paragraph(
/* 1466:1476 */           this.resultSet
/* 1467:1477 */           .getString("CON_MOBILE_NO"), mainContent));
/* 1468:1478 */         cell28.setBorderWidth(0.2F);
/* 1469:1479 */         cell28.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1470:     */         
/* 1471:1481 */         PdfPCell cell29 = new PdfPCell(new Paragraph(
/* 1472:1482 */           "Fax No", mainContent));
/* 1473:1483 */         cell29.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1474:1484 */         cell29.setBorderWidth(0.01F);
/* 1475:1485 */         cell29.setBorderColor(BaseColor.WHITE);
/* 1476:     */         
/* 1477:1487 */         PdfPCell cell30 = new PdfPCell(new Paragraph(
/* 1478:1488 */           this.resultSet
/* 1479:1489 */           .getString("CON_FAX_NO"), 
/* 1480:1490 */           mainContent));
/* 1481:1491 */         cell30.setBorderWidth(0.2F);
/* 1482:1492 */         cell30.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1483:     */         
/* 1484:1494 */         PdfPCell cell31 = new PdfPCell(new Paragraph(
/* 1485:1495 */           "Social Mail Id", mainContent));
/* 1486:1496 */         cell31.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1487:1497 */         cell31.setBorderWidth(0.01F);
/* 1488:1498 */         cell31.setBorderColor(BaseColor.WHITE);
/* 1489:     */         
/* 1490:1500 */         PdfPCell cell32 = new PdfPCell(new Paragraph(
/* 1491:1501 */           this.resultSet
/* 1492:1502 */           .getString("CON_SOCIAL_IM_ID"), 
/* 1493:1503 */           mainContent));
/* 1494:1504 */         cell32.setBorderWidth(0.2F);
/* 1495:1505 */         cell32.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1496:     */         
/* 1497:1507 */         PdfPCell cell33 = new PdfPCell(new Paragraph(
/* 1498:1508 */           "Creation Date", mainContent));
/* 1499:1509 */         cell33.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1500:1510 */         cell33.setBorderWidth(0.01F);
/* 1501:1511 */         cell33.setBorderColor(BaseColor.WHITE);
/* 1502:     */         
/* 1503:1513 */         PdfPCell cell34 = new PdfPCell(new Paragraph(
/* 1504:1514 */           this.resultSet
/* 1505:1515 */           .getString("CON_CREATION_DATE"), 
/* 1506:1516 */           mainContent));
/* 1507:1517 */         cell34.setBorderWidth(0.2F);
/* 1508:1518 */         cell34.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1509:     */         
/* 1510:1520 */         PdfPCell cell35 = new PdfPCell(new Paragraph(
/* 1511:1521 */           "Created By", mainContent));
/* 1512:1522 */         cell35.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1513:1523 */         cell35.setBorderWidth(0.01F);
/* 1514:1524 */         cell35.setBorderColor(BaseColor.WHITE);
/* 1515:     */         
/* 1516:1526 */         PdfPCell cell36 = new PdfPCell(new Paragraph(
/* 1517:1527 */           this.resultSet
/* 1518:1528 */           .getString("CON_CREATED_BY"), 
/* 1519:1529 */           mainContent));
/* 1520:1530 */         cell36.setBorderWidth(0.2F);
/* 1521:1531 */         cell36.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1522:     */         
/* 1523:1533 */         PdfPCell cell37 = new PdfPCell(new Paragraph());
/* 1524:1534 */         cell37.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1525:1535 */         cell37.setBorderWidth(0.2F);
/* 1526:1536 */         cell37.setBorderColor(BaseColor.WHITE);
/* 1527:     */         
/* 1528:1538 */         PdfPCell cell38 = new PdfPCell(new Paragraph());
/* 1529:1539 */         cell38.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1530:1540 */         cell38.setBorderWidth(0.2F);
/* 1531:1541 */         cell38.setBorderColor(BaseColor.WHITE);
/* 1532:     */         
/* 1533:     */ 
/* 1534:1544 */         PdfPCell cell39 = new PdfPCell(new Paragraph("Created By", 
/* 1535:1545 */           mainContent));
/* 1536:1546 */         cell39.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1537:1547 */         cell39.setBorderWidth(0.01F);
/* 1538:1548 */         cell39.setBorderColor(BaseColor.WHITE);
/* 1539:     */         
/* 1540:1550 */         PdfPCell cell40 = new PdfPCell(new Paragraph(
/* 1541:1551 */           this.resultSet.getString("CON_CREATED_BY"), mainContent));
/* 1542:1552 */         cell40.setBorderWidth(0.2F);
/* 1543:1553 */         cell40.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1544:     */         
/* 1545:1555 */         PdfPCell cell41 = new PdfPCell(new Paragraph("Currency", 
/* 1546:1556 */           mainContent));
/* 1547:1557 */         cell41.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1548:1558 */         cell41.setBorderWidth(0.01F);
/* 1549:1559 */         cell41.setBorderColor(BaseColor.WHITE);
/* 1550:     */         
/* 1551:1561 */         PdfPCell cell42 = new PdfPCell(new Paragraph(
/* 1552:1562 */           this.resultSet.getString("CON_REF_CURRENCY"), mainContent));
/* 1553:1563 */         cell42.setBorderWidth(0.2F);
/* 1554:1564 */         cell42.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1555:     */         
/* 1556:1566 */         PdfPCell cell43 = new PdfPCell(new Paragraph("Work Location", 
/* 1557:1567 */           mainContent));
/* 1558:1568 */         cell43.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1559:1569 */         cell43.setBorderWidth(0.01F);
/* 1560:1570 */         cell43.setBorderColor(BaseColor.WHITE);
/* 1561:     */         
/* 1562:1572 */         PdfPCell cell44 = new PdfPCell(new Paragraph(
/* 1563:1573 */           this.resultSet.getString("CON_WORK_LOCATION"), mainContent));
/* 1564:1574 */         cell44.setBorderWidth(0.2F);
/* 1565:1575 */         cell44.setBorderColor(BaseColor.LIGHT_GRAY);
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
/* 1673:     */ 
/* 1674:     */ 
/* 1675:     */ 
/* 1676:     */ 
/* 1677:     */ 
/* 1678:     */ 
/* 1679:     */ 
/* 1680:     */ 
/* 1681:     */ 
/* 1682:     */ 
/* 1683:     */ 
/* 1684:     */ 
/* 1685:     */ 
/* 1686:     */ 
/* 1687:     */ 
/* 1688:     */ 
/* 1689:     */ 
/* 1690:     */ 
/* 1691:     */ 
/* 1692:     */ 
/* 1693:     */ 
/* 1694:     */ 
/* 1695:     */ 
/* 1696:     */ 
/* 1697:     */ 
/* 1698:     */ 
/* 1699:     */ 
/* 1700:     */ 
/* 1701:     */ 
/* 1702:     */ 
/* 1703:     */ 
/* 1704:     */ 
/* 1705:     */ 
/* 1706:     */ 
/* 1707:     */ 
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
/* 1736:     */ 
/* 1737:     */ 
/* 1738:     */ 
/* 1739:     */ 
/* 1740:     */ 
/* 1741:     */ 
/* 1742:     */ 
/* 1743:     */ 
/* 1744:     */ 
/* 1745:     */ 
/* 1746:     */ 
/* 1747:     */ 
/* 1748:     */ 
/* 1749:     */ 
/* 1750:     */ 
/* 1751:     */ 
/* 1752:     */ 
/* 1753:     */ 
/* 1754:     */ 
/* 1755:     */ 
/* 1756:     */ 
/* 1757:1767 */         table.addCell(cell);
/* 1758:1768 */         table.addCell(cell1);
/* 1759:1769 */         table.addCell(cell2);
/* 1760:1770 */         table.addCell(cell3);
/* 1761:1771 */         table.addCell(cell4);
/* 1762:1772 */         table.addCell(cell5);
/* 1763:1773 */         table.addCell(cell6);
/* 1764:1774 */         table.addCell(cell7);
/* 1765:1775 */         table.addCell(cell8);
/* 1766:1776 */         table.addCell(cell9);
/* 1767:1777 */         table.addCell(cell10);
/* 1768:1778 */         table.addCell(cell11);
/* 1769:1779 */         table.addCell(cell12);
/* 1770:1780 */         table.addCell(cell13);
/* 1771:1781 */         table.addCell(cell14);
/* 1772:1782 */         table.addCell(cell15);
/* 1773:1783 */         table.addCell(cell16);
/* 1774:1784 */         table.addCell(cell17);
/* 1775:1785 */         table.addCell(cell18);
/* 1776:1786 */         table.addCell(cell19);
/* 1777:1787 */         table.addCell(cell20);
/* 1778:1788 */         table.addCell(cell21);
/* 1779:1789 */         table.addCell(cell22);
/* 1780:1790 */         table.addCell(cell23);
/* 1781:1791 */         table.addCell(cell24);
/* 1782:1792 */         table.addCell(cell25);
/* 1783:1793 */         table.addCell(cell26);
/* 1784:1794 */         table.addCell(cell27);
/* 1785:1795 */         table.addCell(cell28);
/* 1786:1796 */         table.addCell(cell29);
/* 1787:1797 */         table.addCell(cell30);
/* 1788:1798 */         table.addCell(cell31);
/* 1789:1799 */         table.addCell(cell32);
/* 1790:1800 */         table.addCell(cell33);
/* 1791:1801 */         table.addCell(cell34);
/* 1792:1802 */         table.addCell(cell35);
/* 1793:1803 */         table.addCell(cell36);
/* 1794:1804 */         table.addCell(cell37);
/* 1795:1805 */         table.addCell(cell38);
/* 1796:1806 */         table.addCell(cell39);
/* 1797:1807 */         table.addCell(cell40);
/* 1798:1808 */         table.addCell(cell41);
/* 1799:1809 */         table.addCell(cell42);
/* 1800:1810 */         table.addCell(cell43);
/* 1801:1811 */         table.addCell(cell44);
/* 1802:     */         
/* 1803:     */ 
/* 1804:     */ 
/* 1805:     */ 
/* 1806:     */ 
/* 1807:     */ 
/* 1808:     */ 
/* 1809:     */ 
/* 1810:     */ 
/* 1811:     */ 
/* 1812:     */ 
/* 1813:     */ 
/* 1814:     */ 
/* 1815:     */ 
/* 1816:     */ 
/* 1817:     */ 
/* 1818:     */ 
/* 1819:     */ 
/* 1820:     */ 
/* 1821:     */ 
/* 1822:     */ 
/* 1823:     */ 
/* 1824:     */ 
/* 1825:     */ 
/* 1826:     */ 
/* 1827:     */ 
/* 1828:     */ 
/* 1829:     */ 
/* 1830:     */ 
/* 1831:     */ 
/* 1832:     */ 
/* 1833:     */ 
/* 1834:     */ 
/* 1835:     */ 
/* 1836:     */ 
/* 1837:     */ 
/* 1838:     */ 
/* 1839:1849 */         document.add(table);
/* 1840:     */       }
/* 1841:1853 */       document.add(new Paragraph("\n"));
/* 1842:     */       
/* 1843:     */ 
/* 1844:     */ 
/* 1845:1857 */       document.close();
/* 1846:     */     }
/* 1847:     */     catch (SQLException sqlExp)
/* 1848:     */     {
/* 1849:1860 */       sqlExp.printStackTrace();
/* 1850:1861 */       logger.error(
/* 1851:1862 */         ConsumerCustomerDaoImpl.class + 
/* 1852:1863 */         "Error: Occur in Query While Fetching All Consumer detail for print PdF from Database.", 
/* 1853:1864 */         sqlExp);
/* 1854:     */     }
/* 1855:     */     catch (Exception exception)
/* 1856:     */     {
/* 1857:1866 */       exception.printStackTrace();
/* 1858:1867 */       logger.error(
/* 1859:1868 */         ConsumerCustomerDaoImpl.class + 
/* 1860:1869 */         "Error: Occur in Query While Closing Connection After Fetching All Consumer details for print PdF from Database.", 
/* 1861:1870 */         exception);
/* 1862:     */     }
/* 1863:     */     finally
/* 1864:     */     {
/* 1865:1872 */       JdbcHelper.closeResultSet(this.resultSet);
/* 1866:1873 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/* 1867:1874 */       JdbcHelper.closeConnection(this.connection);
/* 1868:     */     }
/* 1869:     */   }
/* 1870:     */   
/* 1871:     */   public List<ConsumerCustomerVO> retriveConsumerDetailsForAdvanceSearch(int searchId, String searchValue)
/* 1872:     */     throws RecordNotFoundException
/* 1873:     */   {
/* 1874:1882 */     List<ConsumerCustomerVO> consumerDetailList = new ArrayList();
/* 1875:     */     try
/* 1876:     */     {
/* 1877:1886 */       this.connection = getConnection();
/* 1878:     */       
/* 1879:     */ 
/* 1880:1889 */       this.preparedStatement = this.connection.prepareStatement(
/* 1881:1890 */         QueryBuilder.ConsumerDetailAdvanceSearch(searchId, searchValue));
/* 1882:1891 */       this.resultSet = this.preparedStatement.executeQuery();
/* 1883:1895 */       while (this.resultSet.next())
/* 1884:     */       {
/* 1885:1896 */         this.consumerCustomerVO = new ConsumerCustomerVO();
/* 1886:1897 */         this.consumerCustomerVO.setCustomerId(this.resultSet.getInt("CON_CUSTOMER_ID"));
/* 1887:     */         
/* 1888:     */ 
/* 1889:     */ 
/* 1890:1901 */         this.consumerCustomerVO.setFullName(this.resultSet.getString("CON_FULL_NAME"));
/* 1891:     */         
/* 1892:1903 */         this.consumerCustomerVO.setDob(this.resultSet
/* 1893:1904 */           .getString("CON_DATE_OF_BIRTH"));
/* 1894:     */         
/* 1895:1906 */         this.consumerCustomerVO.setAddress1(this.resultSet
/* 1896:1907 */           .getString("CON_ADDRESS_LINE_1"));
/* 1897:     */         
/* 1898:1909 */         this.consumerCustomerVO.setAddress2(this.resultSet
/* 1899:1910 */           .getString("CON_ADDRESS_LINE_2"));
/* 1900:     */         
/* 1901:     */ 
/* 1902:1913 */         this.consumerCustomerVO.setCity(this.nameHelper.getCityNameByCityId(this.resultSet.getInt("CON_CITY")));
/* 1903:     */         
/* 1904:1915 */         this.consumerCustomerVO.setState(this.nameHelper.getStateNameByStateId(this.resultSet.getInt("CON_STATE")));
/* 1905:     */         
/* 1906:1917 */         this.consumerCustomerVO.setPhoneNo(this.resultSet.getString("CON_PHONE_NO"));
/* 1907:     */         
/* 1908:1919 */         this.consumerCustomerVO.setMobileNo(this.resultSet
/* 1909:1920 */           .getString("CON_MOBILE_NO"));
/* 1910:     */         
/* 1911:1922 */         this.consumerCustomerVO.setPinCode(this.resultSet
/* 1912:1923 */           .getString("CON_PINCODE"));
/* 1913:     */         
/* 1914:1925 */         this.consumerCustomerVO.setPeimaryMailId(this.resultSet
/* 1915:1926 */           .getString("CON_PRIMARY_MAIL_ID"));
/* 1916:     */         
/* 1917:     */ 
/* 1918:1929 */         this.consumerCustomerVO.setAlternativeMail(this.resultSet
/* 1919:1930 */           .getString("CON_ALTERNATE_MAIL_ID"));
/* 1920:1931 */         this.consumerCustomerVO.setCreationDate(this.resultSet
/* 1921:1932 */           .getString("CON_CREATION_DATE"));
/* 1922:1933 */         this.consumerCustomerVO.setWorkLocation(this.resultSet
/* 1923:1934 */           .getString("CON_WORK_LOCATION"));
/* 1924:1935 */         this.consumerCustomerVO.setCreatedBy(this.resultSet
/* 1925:1936 */           .getString("CON_CREATED_BY"));
/* 1926:1937 */         consumerDetailList.add(this.consumerCustomerVO);
/* 1927:     */       }
/* 1928:     */     }
/* 1929:     */     catch (SQLException sqlExp)
/* 1930:     */     {
/* 1931:1941 */       sqlExp.printStackTrace();
/* 1932:1942 */       logger.error(
/* 1933:1943 */         ConsumerCustomerDaoImpl.class + 
/* 1934:1944 */         "Error: Occur in Query While Fetching the consumer Details into Grid from Database.", 
/* 1935:1945 */         sqlExp);
/* 1936:     */     }
/* 1937:     */     catch (Exception exception)
/* 1938:     */     {
/* 1939:1947 */       exception.printStackTrace();
/* 1940:1948 */       logger.error(
/* 1941:1949 */         ConsumerCustomerDaoImpl.class + 
/* 1942:1950 */         "Error: Occur in Query While Closing Connection After Fetching the consumer Details into Grid from Database.", 
/* 1943:1951 */         exception);
/* 1944:     */     }
/* 1945:     */     finally
/* 1946:     */     {
/* 1947:1953 */       JdbcHelper.closeResultSet(this.resultSet);
/* 1948:1954 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/* 1949:1955 */       JdbcHelper.closeConnection(this.connection);
/* 1950:     */     }
/* 1951:1957 */     return consumerDetailList;
/* 1952:     */   }
/* 1953:     */   
/* 1954:     */   public List<ConsumerCustomerVO> retriveConsumerTransactionForAdvanceSearch(int searchId, String searchValue)
/* 1955:     */     throws RecordNotFoundException
/* 1956:     */   {
/* 1957:1963 */     List<ConsumerCustomerVO> consumerTransactionDetailList = new ArrayList();
/* 1958:     */     try
/* 1959:     */     {
/* 1960:1966 */       System.out.println(searchId + "    " + searchValue + "we r in dao impl consumeeeeeeeeerrrrrrrrrrrrrr");
/* 1961:1967 */       this.connection = getConnection();
/* 1962:     */       
/* 1963:1969 */       this.preparedStatement = this.connection
/* 1964:1970 */         .prepareStatement(
/* 1965:1971 */         QueryBuilder.ConsumerTransactionAdvanceSearchForAdmin(searchId, searchValue));
/* 1966:     */       
/* 1967:     */ 
/* 1968:1974 */       this.resultSet = this.preparedStatement.executeQuery();
/* 1969:1978 */       while (this.resultSet.next())
/* 1970:     */       {
/* 1971:1979 */         this.consumerCustomerVO = new ConsumerCustomerVO();
/* 1972:1980 */         this.consumerCustomerVO.setTransactionId(this.resultSet.getInt("CUSTOMER_TRANS_ID"));
/* 1973:     */         
/* 1974:     */ 
/* 1975:     */ 
/* 1976:     */ 
/* 1977:     */ 
/* 1978:1986 */         this.consumerCustomerVO.setDescription(this.resultSet
/* 1979:1987 */           .getString("CUSTOMER_TRANS_DISCRIPTION"));
/* 1980:     */         
/* 1981:1989 */         this.consumerCustomerVO.setTotal(this.resultSet
/* 1982:1990 */           .getFloat("CUSTOMER_TRANS_TOTAL"));
/* 1983:     */         
/* 1984:1992 */         this.consumerCustomerVO.setPaid(this.resultSet
/* 1985:1993 */           .getFloat("CUSTOMER_TRANS_PAID"));
/* 1986:     */         
/* 1987:     */ 
/* 1988:1996 */         this.consumerCustomerVO.setDue(this.resultSet
/* 1989:1997 */           .getFloat("CUSTOMER_TRANS_DUE"));
/* 1990:     */         
/* 1991:1999 */         this.consumerCustomerVO.setTotalPaid(this.resultSet
/* 1992:2000 */           .getFloat("CUSTOMER_TRANS_TOTAL_PAID"));
/* 1993:     */         
/* 1994:2002 */         this.consumerCustomerVO.setTotalDue(this.resultSet
/* 1995:2003 */           .getFloat("CUSTOMER_TRANS_TOTAL_DUE"));
/* 1996:     */         
/* 1997:2005 */         this.consumerCustomerVO.setTransactionDate(this.resultSet
/* 1998:2006 */           .getString("CUSTOMER_TRANS_DATE"));
/* 1999:     */         
/* 2000:2008 */         this.consumerCustomerVO.setRetailerId(this.resultSet
/* 2001:2009 */           .getInt("CUSTOMER_ID_RETAILER"));
/* 2002:     */         
/* 2003:     */ 
/* 2004:     */ 
/* 2005:     */ 
/* 2006:2014 */         this.consumerCustomerVO.setPaymentMode(this.resultSet
/* 2007:2015 */           .getString("CUSTOMER_TRANS_PAY_MODE"));
/* 2008:     */         
/* 2009:2017 */         consumerTransactionDetailList.add(this.consumerCustomerVO);
/* 2010:     */       }
/* 2011:     */     }
/* 2012:     */     catch (SQLException sqlExp)
/* 2013:     */     {
/* 2014:2021 */       sqlExp.printStackTrace();
/* 2015:2022 */       logger.error(
/* 2016:2023 */         ConsumerCustomerDaoImpl.class + 
/* 2017:2024 */         "Error: Occur in Query While Fetching the consumer transaction Details for advance seach from Database.", 
/* 2018:2025 */         sqlExp);
/* 2019:     */     }
/* 2020:     */     catch (Exception exception)
/* 2021:     */     {
/* 2022:2027 */       exception.printStackTrace();
/* 2023:2028 */       logger.error(
/* 2024:2029 */         ConsumerCustomerDaoImpl.class + 
/* 2025:2030 */         "Error: Occur in Query While Closing Connection After Fetching the consumer transaction Details for advance seach from Database.", 
/* 2026:2031 */         exception);
/* 2027:     */     }
/* 2028:     */     finally
/* 2029:     */     {
/* 2030:2033 */       JdbcHelper.closeResultSet(this.resultSet);
/* 2031:2034 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/* 2032:2035 */       JdbcHelper.closeConnection(this.connection);
/* 2033:     */     }
/* 2034:2037 */     return consumerTransactionDetailList;
/* 2035:     */   }
/* 2036:     */   
/* 2037:     */   public int getConsumerLastRecord()
/* 2038:     */     throws RecordNotFoundException
/* 2039:     */   {
/* 2040:2042 */     int temp = 0;
/* 2041:     */     try
/* 2042:     */     {
/* 2043:2044 */       this.connection = getConnection();
/* 2044:2045 */       this.preparedStatement = this.connection
/* 2045:2046 */         .prepareStatement("SELECT  CON_CUSTOMER_ID FROM TAB_CONSUMER_CUSTOMER WHERE CON_CUSTOMER_STATUS='ACTIVE'  GROUP BY CON_CUSTOMER_ID DESC LIMIT 1");
/* 2046:2047 */       this.resultSet = this.preparedStatement.executeQuery();
/* 2047:2048 */       if (this.resultSet != null) {
/* 2048:2049 */         while (this.resultSet.next()) {
/* 2049:2051 */           temp = this.resultSet.getInt("CON_CUSTOMER_ID");
/* 2050:     */         }
/* 2051:     */       }
/* 2052:     */     }
/* 2053:     */     catch (SQLException sqlException)
/* 2054:     */     {
/* 2055:2056 */       sqlException.printStackTrace();
/* 2056:2057 */       logger.error(
/* 2057:2058 */         ConsumerCustomerDaoImpl.class + 
/* 2058:2059 */         ": Error:- Error: Occur in Query While counting the Consumer details recods from Database", 
/* 2059:2060 */         sqlException);
/* 2060:     */     }
/* 2061:     */     catch (Exception exception)
/* 2062:     */     {
/* 2063:2063 */       exception.printStackTrace();
/* 2064:2064 */       logger.error(
/* 2065:2065 */         ConsumerCustomerDaoImpl.class + 
/* 2066:2066 */         ": Error:- While closing the Connection after counting the Consumer details recods from Database", 
/* 2067:2067 */         exception);
/* 2068:     */     }
/* 2069:     */     finally
/* 2070:     */     {
/* 2071:2069 */       JdbcHelper.closeResultSet(this.resultSet);
/* 2072:2070 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/* 2073:2071 */       JdbcHelper.closeConnection(this.connection);
/* 2074:     */     }
/* 2075:2073 */     return temp;
/* 2076:     */   }
/* 2077:     */   
/* 2078:     */   public Consumer getConsumerDetails(int consumerId)
/* 2079:     */     throws RecordNotFoundException
/* 2080:     */   {
/* 2081:2079 */     Consumer consumer = new Consumer();
/* 2082:2080 */     System.out.println("LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL we r in consumer detAIL*****");
/* 2083:     */     try
/* 2084:     */     {
/* 2085:2083 */       this.connection = getConnection();
/* 2086:2084 */       this.preparedStatement = this.connection
/* 2087:2085 */         .prepareStatement("SELECT * FROM TAB_CONSUMER_CUSTOMER WHERE CON_CUSTOMER_STATUS='ACTIVE' AND CON_CUSTOMER_ID=?");
/* 2088:2086 */       this.preparedStatement.setInt(1, consumerId);
/* 2089:2087 */       this.resultSet = this.preparedStatement.executeQuery();
/* 2090:2088 */       System.out.println("----------hye ----------------%%" + consumerId);
/* 2091:2089 */       if (this.resultSet != null) {
/* 2092:2090 */         while (this.resultSet.next())
/* 2093:     */         {
/* 2094:2092 */           System.out.println("----------hye ----------------" + this.resultSet.getInt("CON_CUSTOMER_ID") + "****");
/* 2095:     */           
/* 2096:2094 */           consumer.setCustomerId(this.resultSet.getInt("CON_CUSTOMER_ID"));
/* 2097:     */           
/* 2098:     */ 
/* 2099:     */ 
/* 2100:2098 */           consumer.setFullName(this.resultSet.getString("CON_FULL_NAME"));
/* 2101:     */           
/* 2102:2100 */           consumer.setDob(this.resultSet
/* 2103:2101 */             .getString("CON_DATE_OF_BIRTH"));
/* 2104:     */           
/* 2105:2103 */           consumer.setAddress1(this.resultSet
/* 2106:2104 */             .getString("CON_ADDRESS_LINE_1"));
/* 2107:     */           
/* 2108:2106 */           consumer.setAddress2(this.resultSet
/* 2109:2107 */             .getString("CON_ADDRESS_LINE_2"));
/* 2110:     */           
/* 2111:     */ 
/* 2112:2110 */           consumer.setCity(this.nameHelper.getCityNameByCityId(this.resultSet.getInt("CON_CITY")));
/* 2113:     */           
/* 2114:2112 */           consumer.setState(this.nameHelper.getStateNameByStateId(this.resultSet.getInt("CON_STATE")));
/* 2115:     */           
/* 2116:2114 */           consumer.setPhoneNo(this.resultSet
/* 2117:2115 */             .getString("CON_PHONE_NO"));
/* 2118:     */           
/* 2119:2117 */           consumer.setMobileNo(this.resultSet
/* 2120:2118 */             .getString("CON_MOBILE_NO"));
/* 2121:     */           
/* 2122:2120 */           consumer.setPinCode(this.resultSet
/* 2123:2121 */             .getString("CON_PINCODE"));
/* 2124:     */           
/* 2125:2123 */           consumer.setPeimaryMailId(this.resultSet
/* 2126:2124 */             .getString("CON_PRIMARY_MAIL_ID"));
/* 2127:     */           
/* 2128:     */ 
/* 2129:2127 */           consumer.setAlternativeMail(this.resultSet
/* 2130:2128 */             .getString("CON_ALTERNATE_MAIL_ID"));
/* 2131:2129 */           consumer.setCreationDate(this.resultSet
/* 2132:2130 */             .getString("CON_CREATION_DATE"));
/* 2133:2131 */           consumer.setWorkLocation(this.resultSet
/* 2134:2132 */             .getString("CON_WORK_LOCATION"));
/* 2135:2133 */           consumer.setCreatedBy(this.resultSet
/* 2136:2134 */             .getString("CON_CREATED_BY"));
/* 2137:2135 */           System.out.println("u got the data ***********************************" + this.resultSet.getString("CON_PRIMARY_MAIL_ID"));
/* 2138:     */         }
/* 2139:     */       }
/* 2140:     */     }
/* 2141:     */     catch (SQLException sqlExp)
/* 2142:     */     {
/* 2143:2144 */       sqlExp.printStackTrace();
/* 2144:2145 */       logger.error(
/* 2145:2146 */         ConsumerCustomerDaoImpl.class + 
/* 2146:2147 */         "Error: Occur in Query While Fetching the specific consumer Details from Database.", 
/* 2147:2148 */         sqlExp);
/* 2148:     */     }
/* 2149:     */     catch (Exception exception)
/* 2150:     */     {
/* 2151:2150 */       exception.printStackTrace();
/* 2152:2151 */       logger.error(
/* 2153:2152 */         ConsumerCustomerDaoImpl.class + 
/* 2154:2153 */         "Error: Occur in Query While Closing Connection After Fetching the specific consumer Details from Database.", 
/* 2155:2154 */         exception);
/* 2156:     */     }
/* 2157:     */     finally
/* 2158:     */     {
/* 2159:2156 */       JdbcHelper.closeResultSet(this.resultSet);
/* 2160:2157 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/* 2161:2158 */       JdbcHelper.closeConnection(this.connection);
/* 2162:     */     }
/* 2163:2162 */     return consumer;
/* 2164:     */   }
/* 2165:     */   
/* 2166:     */   public int getConsumerTransactionLastRecord()
/* 2167:     */     throws RecordNotFoundException
/* 2168:     */   {
/* 2169:2168 */     int temp = 0;
/* 2170:     */     try
/* 2171:     */     {
/* 2172:2170 */       this.connection = getConnection();
/* 2173:     */       
/* 2174:2172 */       this.preparedStatement = this.connection
/* 2175:2173 */         .prepareStatement("SELECT  CUSTOMER_TRANS_ID FROM TAB_OWNER_CUSTOMER_TRANSACTION WHERE CUSTOMER_TYPE='Consumer' ORDER BY CUSTOMER_TRANS_ID DESC LIMIT 1");
/* 2176:     */       
/* 2177:     */ 
/* 2178:     */ 
/* 2179:2177 */       this.resultSet = this.preparedStatement.executeQuery();
/* 2180:2178 */       if (this.resultSet != null) {
/* 2181:2179 */         while (this.resultSet.next()) {
/* 2182:2181 */           temp = this.resultSet.getInt("CUSTOMER_TRANS_ID");
/* 2183:     */         }
/* 2184:     */       }
/* 2185:     */     }
/* 2186:     */     catch (SQLException sqlException)
/* 2187:     */     {
/* 2188:2186 */       sqlException.printStackTrace();
/* 2189:2187 */       logger.error(
/* 2190:2188 */         ConsumerCustomerDaoImpl.class + 
/* 2191:2189 */         ": Error:- Error: Occur in Query While counting the Consumer transaction records from Database", 
/* 2192:2190 */         sqlException);
/* 2193:     */     }
/* 2194:     */     catch (Exception exception)
/* 2195:     */     {
/* 2196:2193 */       exception.printStackTrace();
/* 2197:2194 */       logger.error(
/* 2198:2195 */         ConsumerCustomerDaoImpl.class + 
/* 2199:2196 */         ": Error:- While closing the Connection after counting the Consumer transaction records from Database", 
/* 2200:2197 */         exception);
/* 2201:     */     }
/* 2202:     */     finally
/* 2203:     */     {
/* 2204:2199 */       JdbcHelper.closeResultSet(this.resultSet);
/* 2205:2200 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/* 2206:2201 */       JdbcHelper.closeConnection(this.connection);
/* 2207:     */     }
/* 2208:2203 */     return temp;
/* 2209:     */   }
/* 2210:     */   
/* 2211:     */   public Consumer getConsumerTransaction(int transId)
/* 2212:     */     throws RecordNotFoundException
/* 2213:     */   {
/* 2214:2209 */     Consumer consumer = new Consumer();
/* 2215:     */     try
/* 2216:     */     {
/* 2217:2212 */       System.out.println("hye bharti ur in view method");
/* 2218:2213 */       this.connection = getConnection();
/* 2219:     */       
/* 2220:2215 */       this.preparedStatement = this.connection
/* 2221:2216 */         .prepareStatement("SELECT * FROM TAB_OWNER_CUSTOMER_TRANSACTION WHERE CUSTOMER_TRANS_ID=? AND CUSTOMER_TYPE='Consumer'");
/* 2222:2217 */       this.preparedStatement.setInt(1, transId);
/* 2223:     */       
/* 2224:     */ 
/* 2225:2220 */       this.resultSet = this.preparedStatement.executeQuery();
/* 2226:2221 */       System.out.println("----------hye ----------------%%" + transId);
/* 2227:2222 */       if (this.resultSet != null) {
/* 2228:2223 */         while (this.resultSet.next())
/* 2229:     */         {
/* 2230:2225 */           System.out.println("----------hye ----------------" + this.resultSet.getInt("CUSTOMER_TRANS_ID") + "****");
/* 2231:     */           
/* 2232:2227 */           consumer.setTransactionId(this.resultSet.getInt("CUSTOMER_TRANS_ID"));
/* 2233:     */           
/* 2234:     */ 
/* 2235:     */ 
/* 2236:2231 */           consumer.setDescription(this.resultSet.getString("CUSTOMER_TRANS_DISCRIPTION"));
/* 2237:     */           
/* 2238:2233 */           consumer.setTotal(this.resultSet
/* 2239:2234 */             .getFloat("CUSTOMER_TRANS_TOTAL"));
/* 2240:     */           
/* 2241:2236 */           consumer.setPaid(this.resultSet
/* 2242:2237 */             .getFloat("CUSTOMER_TRANS_PAID"));
/* 2243:     */           
/* 2244:2239 */           consumer.setDue(this.resultSet
/* 2245:2240 */             .getFloat("CUSTOMER_TRANS_DUE"));
/* 2246:     */           
/* 2247:     */ 
/* 2248:2243 */           consumer.setTotalPaid(this.resultSet
/* 2249:2244 */             .getFloat("CUSTOMER_TRANS_TOTAL_PAID"));
/* 2250:     */           
/* 2251:2246 */           consumer.setTotalDue(this.resultSet
/* 2252:2247 */             .getFloat("CUSTOMER_TRANS_TOTAL_DUE"));
/* 2253:     */           
/* 2254:2249 */           consumer.setTransactionDate(this.resultSet
/* 2255:2250 */             .getString("CUSTOMER_TRANS_DATE"));
/* 2256:     */           
/* 2257:2252 */           consumer.setRetailerId(this.resultSet
/* 2258:2253 */             .getInt("CUSTOMER_ID_CONSUMER"));
/* 2259:     */           
/* 2260:2255 */           consumer.setPaymentMode(this.resultSet
/* 2261:2256 */             .getString("CUSTOMER_TRANS_PAY_MODE"));
/* 2262:     */         }
/* 2263:     */       }
/* 2264:     */     }
/* 2265:     */     catch (SQLException sqlExp)
/* 2266:     */     {
/* 2267:2264 */       sqlExp.printStackTrace();
/* 2268:2265 */       logger.error(
/* 2269:2266 */         ConsumerCustomerDaoImpl.class + 
/* 2270:2267 */         "Error: Occur in Query While Fetching the specific consumer Transaction from Database.", 
/* 2271:2268 */         sqlExp);
/* 2272:     */     }
/* 2273:     */     catch (Exception exception)
/* 2274:     */     {
/* 2275:2270 */       exception.printStackTrace();
/* 2276:2271 */       logger.error(
/* 2277:2272 */         ConsumerCustomerDaoImpl.class + 
/* 2278:2273 */         "Error: Occur in Query While Closing Connection After Fetching the specific consumer Transaction from Database.", 
/* 2279:2274 */         exception);
/* 2280:     */     }
/* 2281:     */     finally
/* 2282:     */     {
/* 2283:2276 */       JdbcHelper.closeResultSet(this.resultSet);
/* 2284:2277 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/* 2285:2278 */       JdbcHelper.closeConnection(this.connection);
/* 2286:     */     }
/* 2287:2282 */     return consumer;
/* 2288:     */   }
/* 2289:     */   
/* 2290:     */   public Consumer retrieveConsumerTransactionByIdForPayDue(int transId)
/* 2291:     */     throws RecordNotFoundException
/* 2292:     */   {
/* 2293:2288 */     Consumer consumer = new Consumer();
/* 2294:2289 */     Connection connections = null;
/* 2295:2290 */     ResultSet resultSets = null;
/* 2296:2291 */     PreparedStatement preparedStatementss = null;
/* 2297:     */     try
/* 2298:     */     {
/* 2299:2293 */       connections = getConnection();
/* 2300:     */       
/* 2301:2295 */       preparedStatementss = connections
/* 2302:2296 */         .prepareStatement("SELECT * FROM TAB_OWNER_CUSTOMER_TRANSACTION WHERE CUSTOMER_TRANS_ID=?");
/* 2303:2297 */       preparedStatementss.setInt(1, transId);
/* 2304:     */       
/* 2305:     */ 
/* 2306:2300 */       System.out.println(transId + "vvvvvvvvvvvvvvvvvvvvv");
/* 2307:2301 */       resultSets = preparedStatementss.executeQuery();
/* 2308:2302 */       System.out.println("----------hye ----------------");
/* 2309:2303 */       if (resultSets != null) {
/* 2310:2304 */         while (resultSets.next())
/* 2311:     */         {
/* 2312:2306 */           System.out.println("----------hye gggggggggggggggggggg----------------");
/* 2313:2307 */           int consumerId = resultSets.getInt("CUSTOMER_ID_CONSUMER");
/* 2314:2308 */           consumer.setTransactionId(resultSets.getInt("CUSTOMER_TRANS_ID"));
/* 2315:2309 */           System.out.println("________________))((*hhhhh" + resultSets.getInt("CUSTOMER_TRANS_ID"));
/* 2316:2310 */           consumer.setDescription(resultSets
/* 2317:2311 */             .getString("CUSTOMER_TRANS_DISCRIPTION"));
/* 2318:2312 */           if ((resultSets.getFloat("CUSTOMER_TRANS_TOTAL_DUE") == 0.0F) && (resultSets.getFloat("CUSTOMER_TRANS_TOTAL_PAID") == 0.0F))
/* 2319:     */           {
/* 2320:2313 */             consumer.setTotalPaid(resultSets.getFloat("CUSTOMER_TRANS_PAID"));
/* 2321:     */             
/* 2322:2315 */             consumer.setTotalDue(resultSets.getFloat("CUSTOMER_TRANS_DUE"));
/* 2323:     */           }
/* 2324:     */           else
/* 2325:     */           {
/* 2326:2317 */             consumer.setTotalPaid(resultSets.getFloat("CUSTOMER_TRANS_TOTAL_PAID"));
/* 2327:     */             
/* 2328:2319 */             consumer.setTotalDue(resultSets.getFloat("CUSTOMER_TRANS_TOTAL_DUE"));
/* 2329:     */           }
/* 2330:2321 */           consumer.setTotal(resultSets
/* 2331:2322 */             .getFloat("CUSTOMER_TRANS_TOTAL"));
/* 2332:     */           
/* 2333:2324 */           consumer.setPaid(resultSets
/* 2334:2325 */             .getFloat("CUSTOMER_TRANS_PAID"));
/* 2335:     */           
/* 2336:2327 */           consumer.setDue(resultSets
/* 2337:2328 */             .getFloat("CUSTOMER_TRANS_DUE"));
/* 2338:     */           
/* 2339:2330 */           consumer.setBillNo(resultSets.getString("CUSTOMER_UNIQUE_ID"));
/* 2340:     */           
/* 2341:     */ 
/* 2342:     */ 
/* 2343:2334 */           consumer.setPaymentMode(resultSets.getString("CUSTOMER_TRANS_PAY_MODE"));
/* 2344:     */           
/* 2345:2336 */           System.out.println(resultSets.getString("CUSTOMER_TRANS_PAY_MODE") + " " + resultSets.getString("CUSTOMER_TRANS_DISCRIPTION"));
/* 2346:     */           
/* 2347:2338 */           consumer.setRetailerId(resultSets.getInt("CUSTOMER_ID_RETAILER"));
/* 2348:     */           
/* 2349:2340 */           consumer = getConsumerDetailForPayDue(consumer, consumerId);
/* 2350:2341 */           System.out.println(consumer.getTotalDue() + consumer.getTotalPaid() + "PPPPPPPPP");
/* 2351:     */         }
/* 2352:     */       }
/* 2353:     */     }
/* 2354:     */     catch (SQLException sqlExp)
/* 2355:     */     {
/* 2356:2351 */       sqlExp.printStackTrace();
/* 2357:2352 */       logger.error(
/* 2358:2353 */         ConsumerCustomerDaoImpl.class + 
/* 2359:2354 */         "Error: Occur in Query While Fetching the specific consumer transaction Details from Database For Pay Due.", 
/* 2360:2355 */         sqlExp);
/* 2361:     */     }
/* 2362:     */     catch (Exception exception)
/* 2363:     */     {
/* 2364:2357 */       exception.printStackTrace();
/* 2365:2358 */       logger.error(
/* 2366:2359 */         ConsumerCustomerDaoImpl.class + 
/* 2367:2360 */         "Error: Occur in Query While Closing Connection After Fetching the specific consumer transaction Details from Database For Pay Due..", 
/* 2368:2361 */         exception);
/* 2369:     */     }
/* 2370:     */     finally
/* 2371:     */     {
/* 2372:2363 */       JdbcHelper.closeResultSet(resultSets);
/* 2373:2364 */       JdbcHelper.closePreparedStatement(preparedStatementss);
/* 2374:2365 */       JdbcHelper.closeConnection(connections);
/* 2375:     */     }
/* 2376:2369 */     return consumer;
/* 2377:     */   }
/* 2378:     */   
/* 2379:     */   private Consumer getConsumerDetailForPayDue(Consumer consumer, int consumerId)
/* 2380:     */   {
/* 2381:     */     try
/* 2382:     */     {
/* 2383:2375 */       System.out.println("hye bharti ur in view for pay method");
/* 2384:2376 */       this.connection = getConnection();
/* 2385:2377 */       this.preparedStatement = this.connection
/* 2386:2378 */         .prepareStatement("SELECT * FROM TAB_CONSUMER_CUSTOMER WHERE CON_CUSTOMER_STATUS='ACTIVE' AND  CON_CUSTOMER_ID=?");
/* 2387:2379 */       this.preparedStatement.setInt(1, consumerId);
/* 2388:2380 */       this.resultSet = this.preparedStatement.executeQuery();
/* 2389:2381 */       System.out.println("----------hye ----------------%%" + consumerId);
/* 2390:2382 */       if (this.resultSet != null) {
/* 2391:2383 */         while (this.resultSet.next())
/* 2392:     */         {
/* 2393:2385 */           System.out.println("----------hye ----------------" + this.resultSet.getInt("CON_CITY") + "****");
/* 2394:     */           
/* 2395:2387 */           String city = this.nameHelper.getCityNameByCityId(this.resultSet.getInt("CON_CITY"));
/* 2396:     */           
/* 2397:     */ 
/* 2398:2390 */           consumer.setRetailerId(this.resultSet.getInt("CON_CUSTOMER_ID"));
/* 2399:     */           
/* 2400:     */ 
/* 2401:     */ 
/* 2402:2394 */           consumer.setFullName(this.resultSet.getString("CON_FULL_NAME"));
/* 2403:     */           
/* 2404:2396 */           consumer.setDob(this.resultSet
/* 2405:2397 */             .getString("CON_DATE_OF_BIRTH"));
/* 2406:     */           
/* 2407:2399 */           consumer.setAddress1(this.resultSet
/* 2408:2400 */             .getString("CON_ADDRESS_LINE_1") + ", " + city);
/* 2409:     */           
/* 2410:2402 */           consumer.setAddress2(this.resultSet
/* 2411:2403 */             .getString("CON_ADDRESS_LINE_2"));
/* 2412:     */           
/* 2413:     */ 
/* 2414:2406 */           consumer.setCity(this.nameHelper.getCityNameByCityId(this.resultSet.getInt("CON_CITY")));
/* 2415:     */           
/* 2416:2408 */           consumer.setState(this.nameHelper.getStateNameByStateId(this.resultSet.getInt("CON_STATE")));
/* 2417:     */           
/* 2418:2410 */           consumer.setPhoneNo(this.resultSet
/* 2419:2411 */             .getString("CON_PHONE_NO"));
/* 2420:     */           
/* 2421:2413 */           consumer.setMobileNo(this.resultSet
/* 2422:2414 */             .getString("CON_MOBILE_NO"));
/* 2423:     */           
/* 2424:2416 */           consumer.setPinCode(this.resultSet
/* 2425:2417 */             .getString("CON_PINCODE"));
/* 2426:     */           
/* 2427:2419 */           consumer.setPeimaryMailId(this.resultSet
/* 2428:2420 */             .getString("CON_PRIMARY_MAIL_ID"));
/* 2429:     */           
/* 2430:     */ 
/* 2431:     */ 
/* 2432:     */ 
/* 2433:     */ 
/* 2434:     */ 
/* 2435:     */ 
/* 2436:     */ 
/* 2437:     */ 
/* 2438:     */ 
/* 2439:2431 */           System.out.println("u got the data ***********************************");
/* 2440:     */         }
/* 2441:     */       }
/* 2442:     */     }
/* 2443:     */     catch (SQLException sqlExp)
/* 2444:     */     {
/* 2445:2440 */       sqlExp.printStackTrace();
/* 2446:2441 */       logger.error(
/* 2447:2442 */         ConsumerCustomerDaoImpl.class + 
/* 2448:2443 */         "Error: Occur in Query While Fetching the specific consumer Details from Database.", 
/* 2449:2444 */         sqlExp);
/* 2450:     */     }
/* 2451:     */     catch (Exception exception)
/* 2452:     */     {
/* 2453:2446 */       exception.printStackTrace();
/* 2454:2447 */       logger.error(
/* 2455:2448 */         ConsumerCustomerDaoImpl.class + 
/* 2456:2449 */         "Error: Occur in Query While Closing Connection After Fetching the specific consumer Details from Database.", 
/* 2457:2450 */         exception);
/* 2458:     */     }
/* 2459:     */     finally
/* 2460:     */     {
/* 2461:2452 */       JdbcHelper.closeResultSet(this.resultSet);
/* 2462:2453 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/* 2463:2454 */       JdbcHelper.closeConnection(this.connection);
/* 2464:     */     }
/* 2465:2458 */     return consumer;
/* 2466:     */   }
/* 2467:     */   
/* 2468:     */   public void addPayDue(ConsumerCustomerVO consumerCustomerVO, int transId)
/* 2469:     */     throws RecordNotFoundException
/* 2470:     */   {
/* 2471:     */     try
/* 2472:     */     {
/* 2473:2466 */       String query = "INSERT INTO TAB_OWNER_CUSTOMER_TRANSACTION(CUSTOMER_TRANS_DISCRIPTION,CUSTOMER_TRANS_PAID,CUSTOMER_TRANS_TOTAL_PAID,CUSTOMER_TRANS_TOTAL_DUE,CUSTOMER_TRANS_DATE,CUSTOMER_ID_CONSUMER,CUSTOMER_UNIQUE_ID,CUSTOMER_TRANS_PAY_MODE, CUSTOMER_TYPE)VALUES(?,?,?,?,?,?,?,?,?)";
/* 2474:2467 */       this.connection = getConnection();
/* 2475:2468 */       float totalPaid = consumerCustomerVO.getTotalPaid() + consumerCustomerVO.getPayment();
/* 2476:2469 */       float totalDue = consumerCustomerVO.getTotalDue() - consumerCustomerVO.getPayment();
/* 2477:     */       
/* 2478:2471 */       this.preparedStatement = this.connection.prepareStatement(query);
/* 2479:2472 */       System.out.println(totalPaid + "helllo we r in dao impl for transaction" + totalDue);
/* 2480:2473 */       this.preparedStatement.setString(1, "ON_DUE_PAYMENT");
/* 2481:2474 */       this.preparedStatement.setFloat(2, consumerCustomerVO.getPayment());
/* 2482:     */       
/* 2483:2476 */       this.preparedStatement.setFloat(3, totalPaid);
/* 2484:2477 */       this.preparedStatement.setFloat(4, totalDue);
/* 2485:2478 */       this.preparedStatement.setString(5, DateTimeUtil.convertToDate(consumerCustomerVO.getTransactionDate()));
/* 2486:     */       
/* 2487:2480 */       System.out.println(consumerCustomerVO.getBillNo() + "hey here is my bill no");
/* 2488:     */       
/* 2489:     */ 
/* 2490:2483 */       this.preparedStatement.setInt(6, consumerCustomerVO.getRetailerId());
/* 2491:2484 */       this.preparedStatement.setString(7, consumerCustomerVO.getBillNo());
/* 2492:2485 */       this.preparedStatement.setString(8, consumerCustomerVO.getPaymentMode());
/* 2493:2486 */       this.preparedStatement.setString(9, "Consumer");
/* 2494:     */       
/* 2495:     */ 
/* 2496:2489 */       this.preparedStatement.executeUpdate();
/* 2497:     */     }
/* 2498:     */     catch (SQLException sqlException)
/* 2499:     */     {
/* 2500:2492 */       sqlException.printStackTrace();
/* 2501:2493 */       logger.error(
/* 2502:2494 */         ConsumerCustomerDaoImpl.class + 
/* 2503:2495 */         ": Error:- Error: Occur in Query While inserting the transaction details record", 
/* 2504:2496 */         sqlException);
/* 2505:     */     }
/* 2506:     */     catch (Exception exception)
/* 2507:     */     {
/* 2508:2498 */       exception.printStackTrace();
/* 2509:2499 */       logger.error(
/* 2510:2500 */         ConsumerCustomerDaoImpl.class + 
/* 2511:2501 */         ": Error:- While closing the Connection after inserting the transaction details reccord", 
/* 2512:2502 */         exception);
/* 2513:     */     }
/* 2514:     */     finally
/* 2515:     */     {
/* 2516:2505 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/* 2517:2506 */       JdbcHelper.closeConnection(this.connection);
/* 2518:     */     }
/* 2519:     */   }
/* 2520:     */ }


/* Location:           C:\Users\bharti\Desktop\Chouksay\lost\dao\
 * Qualified Name:     com.bst.ckt.dao.ConsumerCustomerDaoImpl
 * JD-Core Version:    0.7.0.1
 */