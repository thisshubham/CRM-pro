/*    1:     */ package com.bst.ckt.dao;
/*    2:     */ 
/*    3:     */ import com.bst.ckt.common.QueryBuilder;
/*    4:     */ import com.bst.ckt.dto.Dealer;
/*    5:     */ import com.bst.ckt.exception.CreateFailedException;
/*    6:     */ import com.bst.ckt.exception.DeleteFailedException;
/*    7:     */ import com.bst.ckt.exception.RecordNotFoundException;
/*    8:     */ import com.bst.ckt.exception.UpdateFailedException;
/*    9:     */ import com.bst.ckt.framework.db.JdbcDAOSupport;
/*   10:     */ import com.bst.ckt.framework.db.JdbcHelper;
/*   11:     */ import com.bst.ckt.framework.util.DateTimeUtil;
/*   12:     */ import com.bst.ckt.helper.NameHelper;
/*   13:     */ import com.bst.ckt.vo.DealerVO;
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
/*   31:     */ import java.sql.SQLIntegrityConstraintViolationException;
/*   32:     */ import java.util.ArrayList;
/*   33:     */ import java.util.List;
/*   34:     */ import javax.servlet.ServletContext;
/*   35:     */ import javax.servlet.http.HttpServletRequest;
/*   36:     */ import javax.servlet.http.HttpServletResponse;
/*   37:     */ import org.apache.log4j.Logger;
/*   38:     */ import org.apache.struts2.ServletActionContext;
/*   39:     */ 
/*   40:     */ public class DealerDaoImpl
/*   41:     */   extends JdbcDAOSupport
/*   42:     */   implements DealerDaoInf
/*   43:     */ {
/*   44:  50 */   private static final Logger logger = Logger.getLogger(DealerDaoImpl.class);
/*   45:  52 */   PreparedStatement preparedStatement = null;
/*   46:  53 */   Connection connection = null;
/*   47:  54 */   ResultSet resultSet = null;
/*   48:  55 */   Image image = null;
/*   49:  56 */   NameHelper nameHelper = new NameHelper();
/*   50:  57 */   DealerVO dealerVO = null;
/*   51:     */   
/*   52:     */   public List<DealerVO> viewDealerTransactionDetailsGrid(DealerVO dealerVO)
/*   53:     */     throws RecordNotFoundException
/*   54:     */   {
/*   55:  65 */     List<DealerVO> dealerTransactionDetailList = new ArrayList();
/*   56:     */     try
/*   57:     */     {
/*   58:  69 */       this.connection = getConnection();
/*   59:     */       
/*   60:  71 */       this.preparedStatement = this.connection
/*   61:  72 */         .prepareStatement("SELECT * FROM TAB_DEALER_OWNER_TRANSACTION ORDER BY DEALER_TRANS_ID DESC");
/*   62:     */       
/*   63:     */ 
/*   64:  75 */       this.resultSet = this.preparedStatement.executeQuery();
/*   65:  77 */       while (this.resultSet.next())
/*   66:     */       {
/*   67:  78 */         dealerVO = new DealerVO();
/*   68:  79 */         dealerVO.setTransactionId(this.resultSet.getInt("DEALER_TRANS_ID"));
/*   69:     */         
/*   70:     */ 
/*   71:     */ 
/*   72:     */ 
/*   73:     */ 
/*   74:  85 */         dealerVO.setDescription(this.resultSet
/*   75:  86 */           .getString("DEALER_TRANS_DISCRIPTION"));
/*   76:     */         
/*   77:  88 */         dealerVO.setTotal(this.resultSet
/*   78:  89 */           .getFloat("DEALER_TRANS_TOTAL"));
/*   79:     */         
/*   80:  91 */         dealerVO.setPaid(this.resultSet
/*   81:  92 */           .getFloat("DEALER_TRANS_PAID"));
/*   82:     */         
/*   83:     */ 
/*   84:  95 */         dealerVO.setDue(this.resultSet
/*   85:  96 */           .getFloat("DEALER_TRANS_DUE"));
/*   86:     */         
/*   87:  98 */         dealerVO.setTotalPaid(this.resultSet
/*   88:  99 */           .getFloat("DEALER_TRANS_TOTAL_PAID"));
/*   89:     */         
/*   90: 101 */         dealerVO.setTotalDue(this.resultSet
/*   91: 102 */           .getFloat("DEALER_TRANS_TOTAL_DUE"));
/*   92:     */         
/*   93: 104 */         dealerVO.setTransactionDate(this.resultSet
/*   94: 105 */           .getString("DEALER_TRANS_DATE"));
/*   95:     */         
/*   96: 107 */         dealerVO.setRetailerId(this.resultSet.getInt("DEALER_ID_REF"));
/*   97: 108 */         dealerVO.setFullName(this.nameHelper.getDealerNameById(this.resultSet.getInt("DEALER_ID_REF")));
/*   98: 109 */         dealerVO.setTransactionBillNo(this.resultSet
/*   99: 110 */           .getString("DEALER_TRANS_BILL_NO"));
/*  100:     */         
/*  101:     */ 
/*  102:     */ 
/*  103:     */ 
/*  104:     */ 
/*  105: 116 */         dealerVO.setPaymentMode(this.nameHelper.getPaymentModeById(this.resultSet.getInt("DEALER_TANS_PAYMENT_MODE")));
/*  106:     */         
/*  107: 118 */         dealerTransactionDetailList.add(dealerVO);
/*  108:     */       }
/*  109:     */     }
/*  110:     */     catch (SQLException sqlExp)
/*  111:     */     {
/*  112: 122 */       sqlExp.printStackTrace();
/*  113: 123 */       logger.error(
/*  114: 124 */         DealerDaoImpl.class + 
/*  115: 125 */         "Error: Occur in Query While Fetching the dealer transaction Details into Grid from Database.", 
/*  116: 126 */         sqlExp);
/*  117:     */     }
/*  118:     */     catch (Exception exception)
/*  119:     */     {
/*  120: 128 */       exception.printStackTrace();
/*  121: 129 */       logger.error(
/*  122: 130 */         DealerDaoImpl.class + 
/*  123: 131 */         "Error: Occur in Query While Closing Connection After Fetching the dealer transaction Details into Grid from Database.", 
/*  124: 132 */         exception);
/*  125:     */     }
/*  126:     */     finally
/*  127:     */     {
/*  128: 134 */       JdbcHelper.closeResultSet(this.resultSet);
/*  129: 135 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/*  130: 136 */       JdbcHelper.closeConnection(this.connection);
/*  131:     */     }
/*  132: 138 */     return dealerTransactionDetailList;
/*  133:     */   }
/*  134:     */   
/*  135:     */   public void addDealerDetails(DealerVO dealerVO)
/*  136:     */     throws CreateFailedException
/*  137:     */   {
/*  138:     */     try
/*  139:     */     {
/*  140: 150 */       System.out.println("we  r in dao " + dealerVO.getFullName());
/*  141: 151 */       this.connection = getConnection();
/*  142: 152 */       String insert = "INSERT INTO TAB_DEALER_DETAIL(DEALER_SALUTATION,DEALER_FULL_NAME,DEALER_DATE_OF_BIRTH,DEALER_ADDRESS_LINE_1,DEALER_ADDRESS_LINE_2,DEALER_CITY,DEALER_STATE,DEALER_PINCODE,DEALER_PRIMARY_MAIL_ID, DEALER_ALTERNATE_MAIL_ID,DEALER_PHONE_NO,DEALER_MOBILE_NO, DEALER_FAX_NO,DEALER_SOCIAL_IM_ID,DEALER_CREATION_DATE,DEALER_CREATED_BY,DEALER_WORK_LOCATION, DEALER_CONTACT_PERSON , DEALER_PHONE_NO2 , DEALER_MOBILE_NO2 , DEALER_FAX_ISD ,DEALER_FAX_STD , DEALER_COUNTRY , DEALER_PHONE_ISD , DEALER_PHONE_STD , DEALER_PHONE_ISD2 , DEALER_PHONE_STD2 , DEALER_MOBILE_ISD1 , DEALER_MOBILE_ISD2 , DEALER_HOME_WEBSITE , DEALER_REFFERED_BY , DEALER_PROFILE_DISC, DEALER_STATUS)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
/*  143:     */       
/*  144:     */ 
/*  145:     */ 
/*  146:     */ 
/*  147: 157 */       this.preparedStatement = this.connection.prepareStatement(insert);
/*  148: 158 */       this.preparedStatement.setString(1, dealerVO.getSalutation());
/*  149: 159 */       this.preparedStatement.setString(2, dealerVO.getFullName());
/*  150: 160 */       this.preparedStatement.setString(3, "2018-03-05");
/*  151: 161 */       this.preparedStatement.setString(4, dealerVO.getAddress1());
/*  152: 162 */       this.preparedStatement.setString(5, dealerVO.getAddress2());
/*  153: 163 */       this.preparedStatement.setString(6, dealerVO.getCity());
/*  154: 164 */       this.preparedStatement.setString(7, dealerVO.getState());
/*  155: 165 */       this.preparedStatement.setString(8, dealerVO.getPinCode());
/*  156: 166 */       this.preparedStatement.setString(9, dealerVO.getPeimaryMailId());
/*  157: 167 */       this.preparedStatement.setString(10, dealerVO.getAlternativeMail());
/*  158: 168 */       this.preparedStatement.setString(11, dealerVO.getPhoneNo());
/*  159: 169 */       this.preparedStatement.setString(12, dealerVO.getMobileNo());
/*  160: 170 */       this.preparedStatement.setString(13, dealerVO.getFaxNo());
/*  161: 171 */       this.preparedStatement.setString(14, dealerVO.getSocialMailId());
/*  162: 172 */       this.preparedStatement.setString(15, DateTimeUtil.getCurrentDate());
/*  163: 173 */       this.preparedStatement.setInt(16, 1);
/*  164:     */       
/*  165: 175 */       this.preparedStatement.setString(17, dealerVO.getWorkLocation());
/*  166: 176 */       this.preparedStatement.setString(18, dealerVO.getContactPerson());
/*  167: 177 */       this.preparedStatement.setString(19, dealerVO.getPhoneNo2());
/*  168: 178 */       this.preparedStatement.setString(20, dealerVO.getMobileNo2());
/*  169: 179 */       this.preparedStatement.setString(21, dealerVO.getHomeContFaxNumIsd());
/*  170: 180 */       this.preparedStatement.setString(22, dealerVO.getHomeContFaxnumStd());
/*  171: 181 */       this.preparedStatement.setString(23, dealerVO.getCountry());
/*  172: 182 */       this.preparedStatement.setString(24, dealerVO.getPhoneNumberIsd());
/*  173: 183 */       this.preparedStatement.setString(25, dealerVO.getPhoneNumberStd());
/*  174: 184 */       this.preparedStatement.setString(26, dealerVO.getPhoneNumberIsd2());
/*  175: 185 */       this.preparedStatement.setString(27, dealerVO.getPhoneNumberStd2());
/*  176: 186 */       this.preparedStatement.setString(28, dealerVO.getMobileNum1Isd());
/*  177: 187 */       this.preparedStatement.setString(29, dealerVO.getMobileNum1Isd2());
/*  178: 188 */       this.preparedStatement.setString(30, dealerVO.getHomewebsite());
/*  179: 189 */       this.preparedStatement.setString(31, dealerVO.getRefferedBy());
/*  180: 190 */       this.preparedStatement.setString(32, dealerVO.getProfileDescription());
/*  181: 191 */       this.preparedStatement.setString(33, "ACTIVE");
/*  182:     */       
/*  183:     */ 
/*  184: 194 */       this.preparedStatement.executeUpdate();
/*  185:     */     }
/*  186:     */     catch (SQLException sqlException)
/*  187:     */     {
/*  188: 197 */       sqlException.printStackTrace();
/*  189: 198 */       logger.error(
/*  190: 199 */         DealerDaoImpl.class + 
/*  191: 200 */         ": Error:- Error: Occur in Query While inserting the Dealer details into Database", 
/*  192: 201 */         sqlException);
/*  193:     */     }
/*  194:     */     catch (Exception exception)
/*  195:     */     {
/*  196: 204 */       exception.printStackTrace();
/*  197: 205 */       logger.error(
/*  198: 206 */         DealerDaoImpl.class + 
/*  199: 207 */         ": Error:- While closing the Connection after inserting the Dealer details into Database", 
/*  200: 208 */         exception);
/*  201:     */     }
/*  202:     */     finally
/*  203:     */     {
/*  204: 211 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/*  205: 212 */       JdbcHelper.closeConnection(this.connection);
/*  206:     */     }
/*  207:     */   }
/*  208:     */   
/*  209:     */   public List<DealerVO> retriveDealerDetailsGrid(DealerVO dealerVO)
/*  210:     */     throws RecordNotFoundException
/*  211:     */   {
/*  212: 223 */     List<DealerVO> dealerDetailList = new ArrayList();
/*  213:     */     try
/*  214:     */     {
/*  215: 227 */       this.connection = getConnection();
/*  216: 228 */       this.preparedStatement = this.connection
/*  217: 229 */         .prepareStatement("SELECT * FROM TAB_DEALER_DETAIL WHERE DEALER_STATUS='ACTIVE' ");
/*  218: 230 */       this.resultSet = this.preparedStatement.executeQuery();
/*  219: 234 */       while (this.resultSet.next())
/*  220:     */       {
/*  221: 235 */         dealerVO = new DealerVO();
/*  222: 236 */         dealerVO.setDealerId(this.resultSet.getInt("DEALER_ID"));
/*  223:     */         
/*  224:     */ 
/*  225:     */ 
/*  226: 240 */         dealerVO.setFullName(this.resultSet.getString("DEALER_FULL_NAME"));
/*  227:     */         
/*  228: 242 */         dealerVO.setDob(this.resultSet
/*  229: 243 */           .getString("DEALER_DATE_OF_BIRTH"));
/*  230:     */         
/*  231: 245 */         dealerVO.setAddress1(this.resultSet
/*  232: 246 */           .getString("DEALER_ADDRESS_LINE_1"));
/*  233:     */         
/*  234: 248 */         dealerVO.setAddress2(this.resultSet
/*  235: 249 */           .getString("DEALER_ADDRESS_LINE_2"));
/*  236:     */         
/*  237:     */ 
/*  238: 252 */         dealerVO.setCity(this.nameHelper.getCityNameByCityId(this.resultSet.getInt("DEALER_CITY")));
/*  239:     */         
/*  240: 254 */         dealerVO.setState(this.nameHelper.getStateNameByStateId(this.resultSet
/*  241: 255 */           .getInt("DEALER_STATE")));
/*  242:     */         
/*  243: 257 */         dealerVO.setPhoneNo(this.resultSet
/*  244: 258 */           .getString("DEALER_PHONE_NO"));
/*  245:     */         
/*  246: 260 */         dealerVO.setMobileNo(this.resultSet
/*  247: 261 */           .getString("DEALER_MOBILE_NO"));
/*  248:     */         
/*  249: 263 */         dealerVO.setPinCode(this.resultSet
/*  250: 264 */           .getString("DEALER_PINCODE"));
/*  251:     */         
/*  252: 266 */         dealerVO.setPeimaryMailId(this.resultSet
/*  253: 267 */           .getString("DEALER_PRIMARY_MAIL_ID"));
/*  254:     */         
/*  255:     */ 
/*  256: 270 */         dealerVO.setAlternativeMail(this.resultSet
/*  257: 271 */           .getString("DEALER_ALTERNATE_MAIL_ID"));
/*  258: 272 */         dealerVO.setCreationDate(this.resultSet
/*  259: 273 */           .getString("DEALER_CREATION_DATE"));
/*  260: 274 */         dealerVO.setWorkLocation(this.resultSet
/*  261: 275 */           .getString("DEALER_WORK_LOCATION"));
/*  262: 276 */         dealerVO.setCreatedBy(this.resultSet
/*  263: 277 */           .getString("DEALER_CREATED_BY"));
/*  264: 278 */         dealerDetailList.add(dealerVO);
/*  265:     */       }
/*  266:     */     }
/*  267:     */     catch (SQLException sqlExp)
/*  268:     */     {
/*  269: 282 */       sqlExp.printStackTrace();
/*  270: 283 */       logger.error(
/*  271: 284 */         DealerDaoImpl.class + 
/*  272: 285 */         "Error: Occur in Query While Fetching the dealer Details into Grid from Database.", 
/*  273: 286 */         sqlExp);
/*  274:     */     }
/*  275:     */     catch (Exception exception)
/*  276:     */     {
/*  277: 288 */       exception.printStackTrace();
/*  278: 289 */       logger.error(
/*  279: 290 */         DealerDaoImpl.class + 
/*  280: 291 */         "Error: Occur in Query While Closing Connection After Fetching the dealer Details into Grid from Database.", 
/*  281: 292 */         exception);
/*  282:     */     }
/*  283:     */     finally
/*  284:     */     {
/*  285: 294 */       JdbcHelper.closeResultSet(this.resultSet);
/*  286: 295 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/*  287: 296 */       JdbcHelper.closeConnection(this.connection);
/*  288:     */     }
/*  289: 298 */     return dealerDetailList;
/*  290:     */   }
/*  291:     */   
/*  292:     */   public Dealer retriveSpecificDealerDetail(int dealerId)
/*  293:     */     throws RecordNotFoundException
/*  294:     */   {
/*  295: 307 */     Dealer dealer = new Dealer();
/*  296:     */     try
/*  297:     */     {
/*  298: 310 */       System.out.println("hye bharti ur in view method");
/*  299: 311 */       this.connection = getConnection();
/*  300: 312 */       this.preparedStatement = this.connection
/*  301: 313 */         .prepareStatement("SELECT * FROM TAB_DEALER_DETAIL WHERE DEALER_STATUS='ACTIVE' AND DEALER_ID=?");
/*  302: 314 */       this.preparedStatement.setInt(1, dealerId);
/*  303: 315 */       this.resultSet = this.preparedStatement.executeQuery();
/*  304: 316 */       System.out.println("----------hye ----------------%%" + dealerId);
/*  305: 317 */       if (this.resultSet != null) {
/*  306: 318 */         while (this.resultSet.next())
/*  307:     */         {
/*  308: 320 */           System.out.println("----------hye ----------------" + this.resultSet.getInt("DEALER_ID") + "****");
/*  309:     */           
/*  310: 322 */           dealer.setDealerId(this.resultSet.getInt("DEALER_ID"));
/*  311:     */           
/*  312:     */ 
/*  313:     */ 
/*  314: 326 */           dealer.setFullName(this.resultSet.getString("DEALER_FULL_NAME"));
/*  315:     */           
/*  316: 328 */           dealer.setDob(this.resultSet
/*  317: 329 */             .getString("DEALER_DATE_OF_BIRTH"));
/*  318:     */           
/*  319: 331 */           dealer.setAddress1(this.resultSet
/*  320: 332 */             .getString("DEALER_ADDRESS_LINE_1"));
/*  321:     */           
/*  322: 334 */           dealer.setAddress2(this.resultSet
/*  323: 335 */             .getString("DEALER_ADDRESS_LINE_2"));
/*  324:     */           
/*  325:     */ 
/*  326: 338 */           dealer.setCity(this.nameHelper.getCityNameByCityId(this.resultSet.getInt("DEALER_CITY")));
/*  327:     */           
/*  328: 340 */           dealer.setState(this.nameHelper.getStateNameByStateId(this.resultSet.getInt("DEALER_STATE")));
/*  329:     */           
/*  330: 342 */           dealer.setPhoneNo(this.resultSet
/*  331: 343 */             .getString("DEALER_PHONE_NO"));
/*  332:     */           
/*  333: 345 */           dealer.setMobileNo(this.resultSet
/*  334: 346 */             .getString("DEALER_MOBILE_NO"));
/*  335:     */           
/*  336: 348 */           dealer.setPinCode(this.resultSet
/*  337: 349 */             .getString("DEALER_PINCODE"));
/*  338:     */           
/*  339: 351 */           dealer.setPeimaryMailId(this.resultSet
/*  340: 352 */             .getString("DEALER_PRIMARY_MAIL_ID"));
/*  341:     */           
/*  342:     */ 
/*  343: 355 */           dealer.setAlternativeMail(this.resultSet
/*  344: 356 */             .getString("DEALER_ALTERNATE_MAIL_ID"));
/*  345: 357 */           dealer.setCreationDate(this.resultSet
/*  346: 358 */             .getString("DEALER_CREATION_DATE"));
/*  347: 359 */           dealer.setWorkLocation(this.resultSet
/*  348: 360 */             .getString("DEALER_WORK_LOCATION"));
/*  349: 361 */           dealer.setCreatedBy(this.resultSet
/*  350: 362 */             .getString("DEALER_CREATED_BY"));
/*  351: 363 */           System.out.println("u got the data ***********************************");
/*  352:     */         }
/*  353:     */       }
/*  354:     */     }
/*  355:     */     catch (SQLException sqlExp)
/*  356:     */     {
/*  357: 372 */       sqlExp.printStackTrace();
/*  358: 373 */       logger.error(
/*  359: 374 */         DealerDaoImpl.class + 
/*  360: 375 */         "Error: Occur in Query While Fetching the specific dealer Details from Database.", 
/*  361: 376 */         sqlExp);
/*  362:     */     }
/*  363:     */     catch (Exception exception)
/*  364:     */     {
/*  365: 378 */       exception.printStackTrace();
/*  366: 379 */       logger.error(
/*  367: 380 */         DealerDaoImpl.class + 
/*  368: 381 */         "Error: Occur in Query While Closing Connection After Fetching the specific dealer Details from Database.", 
/*  369: 382 */         exception);
/*  370:     */     }
/*  371:     */     finally
/*  372:     */     {
/*  373: 384 */       JdbcHelper.closeResultSet(this.resultSet);
/*  374: 385 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/*  375: 386 */       JdbcHelper.closeConnection(this.connection);
/*  376:     */     }
/*  377: 390 */     return dealer;
/*  378:     */   }
/*  379:     */   
/*  380:     */   public int deleteSpecificDealerDetails(int dealerId)
/*  381:     */     throws DeleteFailedException
/*  382:     */   {
/*  383: 399 */     int effect = 0;
/*  384:     */     try
/*  385:     */     {
/*  386: 401 */       this.connection = getConnection();
/*  387:     */       
/*  388: 403 */       this.preparedStatement = this.connection.prepareStatement("UPDATE TAB_DEALER_DETAIL SET DEALER_STATUS='DELETED' WHERE DEALER_ID=?");
/*  389:     */       
/*  390: 405 */       this.preparedStatement.setInt(1, dealerId);
/*  391:     */       
/*  392: 407 */       effect = this.preparedStatement.executeUpdate();
/*  393:     */     }
/*  394:     */     catch (SQLException sqlException)
/*  395:     */     {
/*  396: 410 */       sqlException.printStackTrace();
/*  397: 411 */       logger.error(
/*  398: 412 */         DealerDaoImpl.class + 
/*  399: 413 */         ": Error:- Error: Occur in Query While deleting the dealer details record", 
/*  400: 414 */         sqlException);
/*  401:     */     }
/*  402:     */     catch (Exception exception)
/*  403:     */     {
/*  404: 416 */       exception.printStackTrace();
/*  405: 417 */       logger.error(
/*  406: 418 */         DealerDaoImpl.class + 
/*  407: 419 */         ": Error:- While closing the Connection after deleting the dealer details reccord", 
/*  408: 420 */         exception);
/*  409:     */     }
/*  410:     */     finally
/*  411:     */     {
/*  412: 423 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/*  413: 424 */       JdbcHelper.closeConnection(this.connection);
/*  414:     */     }
/*  415: 426 */     return effect;
/*  416:     */   }
/*  417:     */   
/*  418:     */   public Dealer retriveSpecificDealerDetailForEdit(int dealerId)
/*  419:     */     throws RecordNotFoundException
/*  420:     */   {
/*  421: 435 */     Dealer dealer = new Dealer();
/*  422:     */     try
/*  423:     */     {
/*  424: 438 */       this.connection = getConnection();
/*  425: 439 */       PreparedStatement preparedStatements = this.connection
/*  426: 440 */         .prepareStatement("SELECT * FROM TAB_DEALER_DETAIL WHERE DEALER_ID=?");
/*  427: 441 */       preparedStatements.setInt(1, dealerId);
/*  428: 442 */       this.resultSet = preparedStatements.executeQuery();
/*  429: 443 */       System.out.println("----------hye ----------------");
/*  430: 444 */       if (this.resultSet != null) {
/*  431: 445 */         while (this.resultSet.next())
/*  432:     */         {
/*  433: 447 */           System.out.println("----------hye ----------------");
/*  434:     */           
/*  435: 449 */           dealer.setDealerId(this.resultSet.getInt("DEALER_ID"));
/*  436: 450 */           System.out.println("________________" + this.resultSet.getInt("DEALER_ID"));
/*  437: 451 */           dealer.setSalutation(this.resultSet
/*  438: 452 */             .getString("DEALER_SALUTATION"));
/*  439:     */           
/*  440: 454 */           dealer.setFullName(this.resultSet
/*  441: 455 */             .getString("DEALER_FULL_NAME"));
/*  442:     */           
/*  443: 457 */           dealer.setDob(this.resultSet
/*  444: 458 */             .getString("DEALER_DATE_OF_BIRTH"));
/*  445:     */           
/*  446: 460 */           dealer.setAddress1(this.resultSet
/*  447: 461 */             .getString("DEALER_ADDRESS_LINE_1"));
/*  448:     */           
/*  449: 463 */           dealer.setAddress2(this.resultSet
/*  450: 464 */             .getString("DEALER_ADDRESS_LINE_2"));
/*  451:     */           
/*  452: 466 */           dealer.setCity(this.nameHelper.getCityNameByCityId(this.resultSet.getInt("DEALER_CITY")));
/*  453:     */           
/*  454: 468 */           dealer.setState(this.nameHelper.getStateNameByStateId(this.resultSet.getInt("DEALER_STATE")));
/*  455:     */           
/*  456: 470 */           dealer.setPinCode(this.resultSet.getString("DEALER_PINCODE"));
/*  457:     */           
/*  458: 472 */           dealer.setPeimaryMailId(this.resultSet.getString("DEALER_PRIMARY_MAIL_ID"));
/*  459:     */           
/*  460: 474 */           dealer.setAlternativeMail(this.resultSet
/*  461: 475 */             .getString("DEALER_ALTERNATE_MAIL_ID"));
/*  462:     */           
/*  463: 477 */           dealer.setPhoneNo(this.resultSet
/*  464: 478 */             .getString("DEALER_PHONE_NO"));
/*  465:     */           
/*  466:     */ 
/*  467:     */ 
/*  468: 482 */           dealer.setMobileNo(this.resultSet
/*  469: 483 */             .getString("DEALER_MOBILE_NO"));
/*  470: 484 */           dealer.setFaxNo(this.resultSet
/*  471: 485 */             .getString("DEALER_FAX_NO"));
/*  472:     */           
/*  473: 487 */           dealer.setSocialMailId(this.resultSet
/*  474: 488 */             .getString("DEALER_SOCIAL_IM_ID"));
/*  475:     */           
/*  476: 490 */           dealer.setCreationDate(this.resultSet
/*  477: 491 */             .getString("DEALER_CREATION_DATE"));
/*  478:     */           
/*  479: 493 */           dealer.setCreatedBy(this.resultSet.getString("DEALER_CREATED_BY"));
/*  480:     */           
/*  481: 495 */           dealer.setWorkLocation(this.resultSet
/*  482: 496 */             .getString("DEALER_WORK_LOCATION"));
/*  483:     */           
/*  484: 498 */           dealer.setContactPerson(this.resultSet
/*  485: 499 */             .getString("DEALER_CONTACT_PERSON"));
/*  486:     */           
/*  487: 501 */           dealer.setPhoneNo2(this.resultSet
/*  488: 502 */             .getString("DEALER_PHONE_NO2"));
/*  489:     */           
/*  490: 504 */           dealer.setMobileNo2(this.resultSet
/*  491: 505 */             .getString("DEALER_MOBILE_NO2"));
/*  492:     */           
/*  493: 507 */           dealer.setHomeContFaxNumIsd(this.resultSet
/*  494: 508 */             .getString("DEALER_FAX_ISD"));
/*  495:     */           
/*  496: 510 */           dealer.setHomeContFaxnumStd(this.resultSet
/*  497: 511 */             .getString("DEALER_FAX_STD"));
/*  498:     */           
/*  499: 513 */           dealer.setCountry(this.resultSet
/*  500: 514 */             .getString("DEALER_COUNTRY"));
/*  501:     */           
/*  502: 516 */           dealer.setPhoneNumberIsd(this.resultSet
/*  503: 517 */             .getString("DEALER_PHONE_ISD"));
/*  504:     */           
/*  505:     */ 
/*  506: 520 */           dealer.setPhoneNumberStd(this.resultSet
/*  507: 521 */             .getString("DEALER_PHONE_STD"));
/*  508:     */           
/*  509: 523 */           dealer.setPhoneNumberIsd2(this.resultSet
/*  510: 524 */             .getString("DEALER_PHONE_ISD2"));
/*  511:     */           
/*  512: 526 */           dealer.setPhoneNumberStd2(this.resultSet
/*  513: 527 */             .getString("DEALER_PHONE_STD2"));
/*  514:     */           
/*  515:     */ 
/*  516: 530 */           dealer.setMobileNum1Isd(this.resultSet
/*  517: 531 */             .getString("DEALER_MOBILE_ISD1"));
/*  518:     */           
/*  519: 533 */           dealer.setMobileNum1Isd2(this.resultSet
/*  520: 534 */             .getString("DEALER_MOBILE_ISD2"));
/*  521:     */           
/*  522: 536 */           dealer.setHomewebsite(this.resultSet
/*  523: 537 */             .getString("DEALER_HOME_WEBSITE"));
/*  524:     */         }
/*  525:     */       }
/*  526:     */     }
/*  527:     */     catch (SQLException sqlExp)
/*  528:     */     {
/*  529: 548 */       sqlExp.printStackTrace();
/*  530: 549 */       logger.error(
/*  531: 550 */         DealerDaoImpl.class + 
/*  532: 551 */         "Error: Occur in Query While Fetching the specific dealer Details from Database For Update.", 
/*  533: 552 */         sqlExp);
/*  534:     */     }
/*  535:     */     catch (Exception exception)
/*  536:     */     {
/*  537: 554 */       exception.printStackTrace();
/*  538: 555 */       logger.error(
/*  539: 556 */         DealerDaoImpl.class + 
/*  540: 557 */         "Error: Occur in Query While Closing Connection After Fetching the specific dealer Details from Database For Update.", 
/*  541: 558 */         exception);
/*  542:     */     }
/*  543:     */     finally
/*  544:     */     {
/*  545: 560 */       JdbcHelper.closeResultSet(this.resultSet);
/*  546: 561 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/*  547: 562 */       JdbcHelper.closeConnection(this.connection);
/*  548:     */     }
/*  549: 566 */     return dealer;
/*  550:     */   }
/*  551:     */   
/*  552:     */   public void updateSpecificDealerRecord(DealerVO dealerVO, int dealerId)
/*  553:     */     throws UpdateFailedException
/*  554:     */   {
/*  555:     */     try
/*  556:     */     {
/*  557: 577 */       this.connection = getConnection();
/*  558:     */       
/*  559:     */ 
/*  560: 580 */       String fukrey = "UPDATE TAB_DEALER_DETAIL SET DEALER_SALUTATION=?, DEALER_FULL_NAME=?, DEALER_DATE_OF_BIRTH=?,DEALER_ADDRESS_LINE_1=?, DEALER_ADDRESS_LINE_2=?, DEALER_CITY=?,DEALER_STATE=?,DEALER_PINCODE=?,DEALER_PRIMARY_MAIL_ID=?, DEALER_ALTERNATE_MAIL_ID=?,DEALER_PHONE_NO=?,DEALER_MOBILE_NO=?, DEALER_FAX_NO=?,DEALER_SOCIAL_IM_ID=?,DEALER_CREATION_DATE=?,DEALER_CREATED_BY=?,DEALER_WORK_LOCATION=?, DEALER_CONTACT_PERSON=?, DEALER_PHONE_NO2=?, DEALER_MOBILE_NO2=?, DEALER_FAX_ISD=?,DEALER_FAX_STD=?, DEALER_COUNTRY=?, DEALER_PHONE_ISD=?, DEALER_PHONE_STD=?, DEALER_PHONE_ISD2=?, DEALER_PHONE_STD2=?, DEALER_MOBILE_ISD1=?, DEALER_MOBILE_ISD2=?, DEALER_HOME_WEBSITE=?, DEALER_REFFERED_BY=?, DEALER_PROFILE_DISC=? WHERE DEALER_ID=?";
/*  561:     */       
/*  562: 582 */       this.preparedStatement = this.connection.prepareStatement(fukrey);
/*  563: 583 */       this.preparedStatement.setString(1, dealerVO.getSalutation());
/*  564: 584 */       this.preparedStatement.setString(2, dealerVO.getFullName());
/*  565:     */       
/*  566: 586 */       this.preparedStatement.setString(3, "2018-03-03");
/*  567: 587 */       this.preparedStatement.setString(4, dealerVO.getAddress1());
/*  568: 588 */       this.preparedStatement.setString(5, dealerVO.getAddress2());
/*  569: 589 */       this.preparedStatement.setString(6, dealerVO.getCity());
/*  570: 590 */       this.preparedStatement.setString(7, dealerVO.getState());
/*  571: 591 */       this.preparedStatement.setString(8, dealerVO.getPinCode());
/*  572: 592 */       this.preparedStatement.setString(9, dealerVO.getPeimaryMailId());
/*  573: 593 */       this.preparedStatement.setString(10, dealerVO.getAlternativeMail());
/*  574: 594 */       this.preparedStatement.setString(11, dealerVO.getPhoneNo());
/*  575: 595 */       this.preparedStatement.setString(12, dealerVO.getMobileNo());
/*  576: 596 */       this.preparedStatement.setString(13, dealerVO.getFaxNo());
/*  577: 597 */       this.preparedStatement.setString(14, dealerVO.getSocialMailId());
/*  578: 598 */       this.preparedStatement.setString(15, DateTimeUtil.getCurrentDate());
/*  579: 599 */       this.preparedStatement.setInt(16, 1);
/*  580:     */       
/*  581: 601 */       this.preparedStatement.setString(17, dealerVO.getWorkLocation());
/*  582: 602 */       this.preparedStatement.setString(18, dealerVO.getContactPerson());
/*  583: 603 */       this.preparedStatement.setString(19, dealerVO.getPhoneNo2());
/*  584: 604 */       this.preparedStatement.setString(20, dealerVO.getMobileNo2());
/*  585: 605 */       this.preparedStatement.setString(21, dealerVO.getHomeContFaxNumIsd());
/*  586: 606 */       this.preparedStatement.setString(22, dealerVO.getHomeContFaxnumStd());
/*  587: 607 */       this.preparedStatement.setString(23, dealerVO.getCountry());
/*  588: 608 */       this.preparedStatement.setString(24, dealerVO.getPhoneNumberIsd());
/*  589: 609 */       this.preparedStatement.setString(25, dealerVO.getPhoneNumberStd());
/*  590: 610 */       this.preparedStatement.setString(26, dealerVO.getPhoneNumberIsd2());
/*  591: 611 */       this.preparedStatement.setString(27, dealerVO.getPhoneNumberStd2());
/*  592: 612 */       this.preparedStatement.setString(28, dealerVO.getMobileNum1Isd());
/*  593: 613 */       this.preparedStatement.setString(29, dealerVO.getMobileNum1Isd2());
/*  594: 614 */       this.preparedStatement.setString(30, dealerVO.getHomewebsite());
/*  595: 615 */       this.preparedStatement.setString(31, dealerVO.getRefferedBy());
/*  596: 616 */       this.preparedStatement.setString(32, dealerVO.getProfileDescription());
/*  597: 617 */       this.preparedStatement.setInt(33, dealerId);
/*  598:     */       
/*  599: 619 */       this.preparedStatement.executeUpdate();
/*  600:     */     }
/*  601:     */     catch (SQLException sqlException)
/*  602:     */     {
/*  603: 624 */       sqlException.printStackTrace();
/*  604: 625 */       logger.error(
/*  605: 626 */         DealerDaoImpl.class + 
/*  606: 627 */         ": Error:- Error: Occur in Query While updating the dealer details record", 
/*  607: 628 */         sqlException);
/*  608:     */     }
/*  609:     */     catch (Exception exception)
/*  610:     */     {
/*  611: 630 */       exception.printStackTrace();
/*  612: 631 */       logger.error(
/*  613: 632 */         DealerDaoImpl.class + 
/*  614: 633 */         ": Error:- While closing the Connection after updating the dealer details reccord", 
/*  615: 634 */         exception);
/*  616:     */     }
/*  617:     */     finally
/*  618:     */     {
/*  619: 637 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/*  620: 638 */       JdbcHelper.closeConnection(this.connection);
/*  621:     */     }
/*  622:     */   }
/*  623:     */   
/*  624:     */   public Dealer retriveSpecificDealerTransaction(int dealerId)
/*  625:     */     throws RecordNotFoundException
/*  626:     */   {
/*  627: 649 */     Dealer dealer = new Dealer();
/*  628: 650 */     PreparedStatement preparedStatements = null;
/*  629:     */     try
/*  630:     */     {
/*  631: 653 */       this.connection = getConnection();
/*  632:     */       
/*  633: 655 */       preparedStatements = this.connection
/*  634: 656 */         .prepareStatement("SELECT * FROM TAB_DEALER_OWNER_TRANSACTION WHERE DEALER_TRANS_ID=?");
/*  635: 657 */       preparedStatements.setInt(1, dealerId);
/*  636:     */       
/*  637:     */ 
/*  638: 660 */       this.resultSet = preparedStatements.executeQuery();
/*  639: 661 */       System.out.println("----------hye ----------------");
/*  640: 662 */       if (this.resultSet != null) {
/*  641: 663 */         while (this.resultSet.next())
/*  642:     */         {
/*  643: 665 */           System.out.println("----------hye ----------------");
/*  644:     */           
/*  645: 667 */           dealer.setTransactionId(this.resultSet.getInt("DEALER_TRANS_ID"));
/*  646: 668 */           System.out.println("________________" + this.resultSet.getInt("DEALER_TRANS_ID"));
/*  647: 669 */           dealer.setDescription(this.resultSet
/*  648: 670 */             .getString("DEALER_TRANS_DISCRIPTION"));
/*  649:     */           
/*  650: 672 */           dealer.setTotal(this.resultSet
/*  651: 673 */             .getFloat("DEALER_TRANS_TOTAL"));
/*  652:     */           
/*  653: 675 */           dealer.setPaid(this.resultSet
/*  654: 676 */             .getFloat("DEALER_TRANS_PAID"));
/*  655:     */           
/*  656: 678 */           dealer.setDue(this.resultSet
/*  657: 679 */             .getFloat("DEALER_TRANS_DUE"));
/*  658:     */           
/*  659: 681 */           dealer.setTotalPaid(this.resultSet
/*  660: 682 */             .getFloat("DEALER_TRANS_TOTAL_PAID"));
/*  661:     */           
/*  662: 684 */           dealer.setTransactionDate(this.resultSet
/*  663: 685 */             .getString("DEALER_TRANS_DATE"));
/*  664:     */           
/*  665: 687 */           dealer.setTotalDue(this.resultSet.getFloat("DEALER_TRANS_TOTAL_DUE"));
/*  666:     */           
/*  667: 689 */           dealer.setRetailerId(this.resultSet.getInt("DEALER_ID_REF"));
/*  668:     */           
/*  669: 691 */           dealer.setPaymentMode(this.nameHelper.getPaymentModeById(this.resultSet.getInt("DEALER_TANS_PAYMENT_MODE")));
/*  670: 692 */           System.out.println(this.resultSet.getString("DEALER_TANS_PAYMENT_MODE") + this.resultSet.getString("DEALER_TANS_PAYMENT_MODE") + "hhhhhhhhh");
/*  671:     */         }
/*  672:     */       }
/*  673:     */     }
/*  674:     */     catch (SQLException sqlExp)
/*  675:     */     {
/*  676: 705 */       sqlExp.printStackTrace();
/*  677: 706 */       logger.error(
/*  678: 707 */         DealerDaoImpl.class + 
/*  679: 708 */         "Error: Occur in Query While Fetching the specific dealer transaction Details from Database For Update.", 
/*  680: 709 */         sqlExp);
/*  681:     */     }
/*  682:     */     catch (Exception exception)
/*  683:     */     {
/*  684: 711 */       exception.printStackTrace();
/*  685: 712 */       logger.error(
/*  686: 713 */         DealerDaoImpl.class + 
/*  687: 714 */         "Error: Occur in Query While Closing Connection After Fetching the specific dealer transaction Details from Database For Update.", 
/*  688: 715 */         exception);
/*  689:     */     }
/*  690:     */     finally
/*  691:     */     {
/*  692: 717 */       JdbcHelper.closeResultSet(this.resultSet);
/*  693: 718 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/*  694: 719 */       JdbcHelper.closeConnection(this.connection);
/*  695:     */     }
/*  696: 723 */     return dealer;
/*  697:     */   }
/*  698:     */   
/*  699:     */   public int deleteSpecificDealerTransaction(int dealerId)
/*  700:     */     throws DeleteFailedException
/*  701:     */   {
/*  702: 732 */     int effect = 0;
/*  703:     */     try
/*  704:     */     {
/*  705: 734 */       this.connection = getConnection();
/*  706:     */       
/*  707: 736 */       this.preparedStatement = this.connection.prepareStatement("DELETE FROM TAB_DEALER_OWNER_TRANSACTION WHERE DEALER_TRANS_ID=?");
/*  708:     */       
/*  709: 738 */       this.preparedStatement.setInt(1, dealerId);
/*  710:     */       
/*  711: 740 */       effect = this.preparedStatement.executeUpdate();
/*  712:     */     }
/*  713:     */     catch (SQLException sqlException)
/*  714:     */     {
/*  715: 743 */       sqlException.printStackTrace();
/*  716: 744 */       logger.error(
/*  717: 745 */         DealerDaoImpl.class + 
/*  718: 746 */         ": Error:- Error: Occur in Query While deleting the dealer transaction record", 
/*  719: 747 */         sqlException);
/*  720:     */     }
/*  721:     */     catch (Exception exception)
/*  722:     */     {
/*  723: 749 */       exception.printStackTrace();
/*  724: 750 */       logger.error(
/*  725: 751 */         DealerDaoImpl.class + 
/*  726: 752 */         ": Error:- While closing the Connection after deleting the dealer transaction reccord", 
/*  727: 753 */         exception);
/*  728:     */     }
/*  729:     */     finally
/*  730:     */     {
/*  731: 756 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/*  732: 757 */       JdbcHelper.closeConnection(this.connection);
/*  733:     */     }
/*  734: 759 */     return effect;
/*  735:     */   }
/*  736:     */   
/*  737:     */   public void dealerDetailPrintPDF(HttpServletRequest request, HttpServletResponse response, int dealerId)
/*  738:     */   {
/*  739: 768 */     String companyName = "Chouksay Traders";
/*  740: 769 */     String address1 = "BUS STAND SHAMSHABAD, DIST.- VIDISHA, MADHYA PRADESH, 464001";
/*  741: 770 */     String address2 = "GSTIN: 23AJQPC8200P1Z1";
/*  742: 771 */     String address3 = "PAN NO: AJQPC8200P";
/*  743:     */     
/*  744: 773 */     String city = "Vidisha-464001";
/*  745: 774 */     String state = "(M.P.)";
/*  746: 775 */     StringBuffer stringBuffer = null;
/*  747: 776 */     System.out.println("we r dealer dao for print" + dealerId);
/*  748:     */     try
/*  749:     */     {
/*  750: 779 */       this.connection = getConnection();
/*  751: 780 */       this.preparedStatement = this.connection
/*  752: 781 */         .prepareStatement("SELECT * FROM TAB_DEALER_DETAIL WHERE DEALER_STATUS='ACTIVE' AND DEALER_ID=?");
/*  753: 782 */       this.preparedStatement.setInt(1, dealerId);
/*  754: 783 */       this.resultSet = this.preparedStatement.executeQuery();
/*  755: 784 */       Document document = new Document(PageSize.A4);
/*  756:     */       
/*  757: 786 */       Font Font3 = new Font(Font.FontFamily.TIMES_ROMAN, 11.0F, 0);
/*  758: 787 */       Font Font2 = new Font(Font.FontFamily.TIMES_ROMAN, 6.0F, 
/*  759: 788 */         8);
/*  760: 789 */       Font Font4 = new Font(Font.FontFamily.TIMES_ROMAN, 11.0F, 1);
/*  761: 790 */       Font4.setColor(BaseColor.WHITE);
/*  762: 791 */       Font mainContent = new Font(Font.FontFamily.TIMES_ROMAN, 10.0F, 
/*  763: 792 */         0);
/*  764: 793 */       Font Font5 = new Font(Font.FontFamily.TIMES_ROMAN, 12.0F, 1);
/*  765: 794 */       Font5.setColor(BaseColor.GRAY);
/*  766: 795 */       Font Font6 = new Font(Font.FontFamily.TIMES_ROMAN, 10.0F, 1);
/*  767: 796 */       Font6.setColor(BaseColor.RED);
/*  768:     */       
/*  769:     */ 
/*  770: 799 */       response.setContentType("application/pdf");
/*  771:     */       
/*  772: 801 */       PdfWriter.getInstance(document, response.getOutputStream());
/*  773:     */       
/*  774: 803 */       document.open();
/*  775:     */       
/*  776: 805 */       String contextPath = ServletActionContext.getServletContext()
/*  777: 806 */         .getRealPath("/outer/img/rohittraders.png");
/*  778: 807 */       this.image = Image.getInstance(contextPath);
/*  779: 808 */       this.image.scaleToFit(130.0F, 70.0F);
/*  780:     */       
/*  781: 810 */       PdfPTable table1 = new PdfPTable(2);
/*  782: 811 */       table1.setWidthPercentage(100.0F);
/*  783: 812 */       Rectangle rect1 = new Rectangle(300.0F, 700.0F);
/*  784: 813 */       table1.setWidthPercentage(new float[] { 150.0F, 150.0F }, rect1);
/*  785:     */       
/*  786: 815 */       PdfPCell cell101 = new PdfPCell(this.image, false);
/*  787: 816 */       cell101.setPaddingTop(5.0F);
/*  788: 817 */       cell101.setBorder(0);
/*  789:     */       
/*  790: 819 */       Phrase phrase3 = new Phrase(companyName + "\n", Font5);
/*  791: 820 */       Phrase phrase = new Phrase(address1 + "\n", Font3);
/*  792: 821 */       Phrase phrase1 = new Phrase(address2 + "\n", Font3);
/*  793: 822 */       Phrase phrase4 = new Phrase(address3 + "\n", Font3);
/*  794: 823 */       Phrase phrase2 = new Phrase(city + "-" + state, Font3);
/*  795:     */       
/*  796: 825 */       Paragraph paragraph = new Paragraph();
/*  797: 826 */       paragraph.add(phrase3);
/*  798: 827 */       paragraph.add(phrase);
/*  799: 828 */       paragraph.add(phrase1);
/*  800: 829 */       paragraph.add(phrase4);
/*  801: 830 */       paragraph.add(phrase2);
/*  802:     */       
/*  803: 832 */       PdfPCell cell102 = new PdfPCell(paragraph);
/*  804: 833 */       cell102.setPaddingTop(5.0F);
/*  805: 834 */       cell102.setBorder(0);
/*  806: 835 */       cell102.setHorizontalAlignment(2);
/*  807:     */       
/*  808: 837 */       PdfPCell cell103 = new PdfPCell(
/*  809: 838 */         new Paragraph(
/*  810: 839 */         "   \n                                                                                                                                                                                                                                                                                                                                                  ", 
/*  811:     */         
/*  812:     */ 
/*  813: 842 */         Font2));
/*  814: 843 */       cell103.setColspan(2);
/*  815: 844 */       cell103.setBorderWidthRight(0.0F);
/*  816: 845 */       cell103.setBorderWidthLeft(0.0F);
/*  817: 846 */       cell103.setBorderWidthTop(0.5F);
/*  818: 847 */       cell103.setBorderWidthBottom(0.0F);
/*  819: 848 */       cell103.setBorderColorTop(BaseColor.WHITE);
/*  820:     */       
/*  821: 850 */       PdfPCell cell104 = new PdfPCell(new Paragraph("DEALER DETAIL", Font4));
/*  822: 851 */       cell104.setUseBorderPadding(true);
/*  823: 852 */       cell104.setColspan(2);
/*  824: 853 */       cell104.setBorderWidthRight(0.1F);
/*  825: 854 */       cell104.setBorderWidthLeft(0.1F);
/*  826: 855 */       cell104.setBorderWidthTop(0.1F);
/*  827: 856 */       cell104.setBorderWidthBottom(0.1F);
/*  828: 857 */       cell104.setBorderColor(BaseColor.LIGHT_GRAY);
/*  829: 858 */       cell104.setBackgroundColor(new BaseColor(0, 59, 119));
/*  830:     */       
/*  831: 860 */       table1.addCell(cell101);
/*  832: 861 */       table1.addCell(cell102);
/*  833: 862 */       table1.addCell(cell103);
/*  834: 863 */       table1.addCell(cell104);
/*  835: 864 */       document.add(table1);
/*  836: 870 */       while (this.resultSet.next())
/*  837:     */       {
/*  838: 871 */         stringBuffer = new StringBuffer();
/*  839: 872 */         PdfPTable table = new PdfPTable(2);
/*  840: 873 */         table.setFooterRows(1);
/*  841: 874 */         table.setWidthPercentage(100.0F);
/*  842: 875 */         Rectangle rect = new Rectangle(300.0F, 700.0F);
/*  843: 876 */         table.setWidthPercentage(new float[] { 80.0F, 220.0F }, rect);
/*  844:     */         
/*  845: 878 */         PdfPCell cell = new PdfPCell(new Paragraph());
/*  846: 879 */         cell.setColspan(2);
/*  847: 880 */         cell.setBorderWidthRight(0.1F);
/*  848: 881 */         cell.setBorderWidthLeft(0.1F);
/*  849: 882 */         cell.setBorderWidthTop(0.1F);
/*  850: 883 */         cell.setBorderWidthBottom(0.2F);
/*  851: 884 */         cell.setBorderColor(BaseColor.LIGHT_GRAY);
/*  852: 885 */         cell.setBackgroundColor(new BaseColor(238, 238, 238));
/*  853:     */         
/*  854: 887 */         PdfPCell cell1 = new PdfPCell(new Paragraph());
/*  855: 888 */         cell1.setBackgroundColor(new BaseColor(238, 238, 238));
/*  856: 889 */         cell1.setBorderWidth(0.01F);
/*  857: 890 */         cell1.setBorderColor(BaseColor.WHITE);
/*  858:     */         
/*  859: 892 */         PdfPCell cell2 = new PdfPCell(new Paragraph());
/*  860: 893 */         cell2.setBackgroundColor(new BaseColor(238, 238, 238));
/*  861: 894 */         cell2.setBorderWidth(0.2F);
/*  862: 895 */         cell2.setBorderColor(BaseColor.WHITE);
/*  863:     */         
/*  864: 897 */         PdfPCell cell3 = new PdfPCell(new Paragraph("Dealer Id", 
/*  865: 898 */           mainContent));
/*  866: 899 */         cell3.setBackgroundColor(new BaseColor(238, 238, 238));
/*  867: 900 */         cell3.setBorderWidth(0.01F);
/*  868: 901 */         cell3.setBorderColor(BaseColor.WHITE);
/*  869:     */         
/*  870: 903 */         PdfPCell cell4 = new PdfPCell(new Paragraph(this.resultSet.getString("DEALER_ID"), mainContent));
/*  871: 904 */         cell4.setBorderWidth(0.2F);
/*  872: 905 */         cell4.setBorderColor(BaseColor.LIGHT_GRAY);
/*  873:     */         
/*  874: 907 */         PdfPCell cell5 = new PdfPCell(new Paragraph(
/*  875: 908 */           "Salutation", mainContent));
/*  876: 909 */         cell5.setBackgroundColor(new BaseColor(238, 238, 238));
/*  877: 910 */         cell5.setBorderWidth(0.01F);
/*  878: 911 */         cell5.setBorderColor(BaseColor.WHITE);
/*  879: 912 */         System.out.println(this.resultSet.getString("DEALER_ID") + "bharti u got itOOOO");
/*  880:     */         
/*  881: 914 */         PdfPCell cell6 = new PdfPCell(new Paragraph(this.resultSet.getString("DEALER_SALUTATION"), mainContent));
/*  882: 915 */         cell6.setBorderWidth(0.2F);
/*  883: 916 */         cell6.setBorderColor(BaseColor.LIGHT_GRAY);
/*  884:     */         
/*  885: 918 */         PdfPCell cell7 = new PdfPCell(new Paragraph("Full name", 
/*  886: 919 */           mainContent));
/*  887: 920 */         cell7.setBackgroundColor(new BaseColor(238, 238, 238));
/*  888: 921 */         cell7.setBorderWidth(0.01F);
/*  889: 922 */         cell7.setBorderColor(BaseColor.WHITE);
/*  890:     */         
/*  891: 924 */         PdfPCell cell8 = new PdfPCell(new Paragraph(
/*  892: 925 */           this.resultSet.getString("DEALER_FULL_NAME"), mainContent));
/*  893: 926 */         cell8.setBorderWidth(0.2F);
/*  894: 927 */         cell8.setBorderColor(BaseColor.LIGHT_GRAY);
/*  895:     */         
/*  896:     */ 
/*  897:     */ 
/*  898: 931 */         PdfPCell cell9 = new PdfPCell(new Paragraph("DOB", 
/*  899: 932 */           mainContent));
/*  900: 933 */         cell9.setBorderWidth(0.2F);
/*  901: 934 */         cell9.setBorderColor(BaseColor.LIGHT_GRAY);
/*  902:     */         
/*  903: 936 */         PdfPCell cell10 = new PdfPCell(new Paragraph(
/*  904: 937 */           this.resultSet.getString("DEALER_DATE_OF_BIRTH"), mainContent));
/*  905: 938 */         cell10.setBorderWidth(0.2F);
/*  906: 939 */         cell10.setBorderColor(BaseColor.LIGHT_GRAY);
/*  907:     */         
/*  908: 941 */         PdfPCell cell11 = new PdfPCell(new Paragraph("Address", 
/*  909: 942 */           mainContent));
/*  910: 943 */         cell11.setBackgroundColor(new BaseColor(238, 238, 238));
/*  911: 944 */         cell11.setBorderWidth(0.01F);
/*  912: 945 */         cell11.setBorderColor(BaseColor.WHITE);
/*  913:     */         
/*  914: 947 */         PdfPCell cell12 = new PdfPCell(new Paragraph(this.resultSet.getString("DEALER_ADDRESS_LINE_1"), mainContent));
/*  915: 948 */         cell12.setBorderWidth(0.2F);
/*  916: 949 */         cell12.setBorderColor(BaseColor.LIGHT_GRAY);
/*  917:     */         
/*  918: 951 */         PdfPCell cell13 = new PdfPCell(new Paragraph("Alternative Address", 
/*  919: 952 */           mainContent));
/*  920: 953 */         cell13.setBackgroundColor(new BaseColor(238, 238, 238));
/*  921: 954 */         cell13.setBorderWidth(0.01F);
/*  922: 955 */         cell13.setBorderColor(BaseColor.WHITE);
/*  923:     */         
/*  924: 957 */         PdfPCell cell14 = new PdfPCell(new Paragraph(this.resultSet.getString("DEALER_ADDRESS_LINE_2"), mainContent));
/*  925: 958 */         cell14.setBorderWidth(0.2F);
/*  926: 959 */         cell14.setBorderColor(BaseColor.LIGHT_GRAY);
/*  927:     */         
/*  928: 961 */         PdfPCell cell15 = new PdfPCell(new Paragraph(
/*  929: 962 */           "City", mainContent));
/*  930: 963 */         cell15.setBackgroundColor(new BaseColor(238, 238, 238));
/*  931: 964 */         cell15.setBorderWidth(0.01F);
/*  932: 965 */         cell15.setBorderColor(BaseColor.WHITE);
/*  933:     */         
/*  934: 967 */         PdfPCell cell16 = new PdfPCell(new Paragraph(this.nameHelper.getCityNameByCityId(this.resultSet.getInt("DEALER_CITY")), mainContent));
/*  935: 968 */         cell16.setBorderWidth(0.2F);
/*  936: 969 */         cell16.setBorderColor(BaseColor.LIGHT_GRAY);
/*  937:     */         
/*  938: 971 */         PdfPCell cell17 = new PdfPCell(new Paragraph("State", 
/*  939: 972 */           mainContent));
/*  940: 973 */         cell17.setBackgroundColor(new BaseColor(238, 238, 238));
/*  941: 974 */         cell17.setBorderWidth(0.01F);
/*  942: 975 */         cell17.setBorderColor(BaseColor.WHITE);
/*  943:     */         
/*  944: 977 */         PdfPCell cell18 = new PdfPCell(new Paragraph(this.nameHelper.getStateNameByStateId(this.resultSet.getInt("DEALER_STATE")), mainContent));
/*  945: 978 */         cell18.setBorderWidth(0.2F);
/*  946: 979 */         cell18.setBorderColor(BaseColor.LIGHT_GRAY);
/*  947:     */         
/*  948: 981 */         PdfPCell cell19 = new PdfPCell(new Paragraph("Pincode", 
/*  949: 982 */           mainContent));
/*  950: 983 */         cell19.setBackgroundColor(new BaseColor(238, 238, 238));
/*  951: 984 */         cell19.setBorderWidth(0.01F);
/*  952: 985 */         cell19.setBorderColor(BaseColor.WHITE);
/*  953:     */         
/*  954: 987 */         PdfPCell cell20 = new PdfPCell(new Paragraph(this.resultSet.getString("DEALER_PINCODE"), mainContent));
/*  955: 988 */         cell20.setBorderWidth(0.2F);
/*  956: 989 */         cell20.setBorderColor(BaseColor.LIGHT_GRAY);
/*  957:     */         
/*  958: 991 */         PdfPCell cell21 = new PdfPCell(new Paragraph("Primary Mail", 
/*  959: 992 */           mainContent));
/*  960: 993 */         cell21.setBackgroundColor(new BaseColor(238, 238, 238));
/*  961: 994 */         cell21.setBorderWidth(0.01F);
/*  962: 995 */         cell21.setBorderColor(BaseColor.WHITE);
/*  963:     */         
/*  964: 997 */         PdfPCell cell22 = new PdfPCell(new Paragraph(this.resultSet.getString("DEALER_PRIMARY_MAIL_ID"), mainContent));
/*  965: 998 */         cell22.setBorderWidth(0.2F);
/*  966: 999 */         cell22.setBorderColor(BaseColor.LIGHT_GRAY);
/*  967:     */         
/*  968:1001 */         PdfPCell cell23 = new PdfPCell(new Paragraph(
/*  969:1002 */           "Alternative Mail Id", mainContent));
/*  970:1003 */         cell23.setBackgroundColor(new BaseColor(238, 238, 238));
/*  971:1004 */         cell23.setBorderWidth(0.01F);
/*  972:1005 */         cell23.setBorderColor(BaseColor.WHITE);
/*  973:     */         
/*  974:1007 */         PdfPCell cell24 = new PdfPCell(
/*  975:1008 */           new Paragraph(this.resultSet.getString(
/*  976:1009 */           "DEALER_ALTERNATE_MAIL_ID"), 
/*  977:1010 */           mainContent));
/*  978:1011 */         cell24.setBorderWidth(0.2F);
/*  979:1012 */         cell24.setBorderColor(BaseColor.LIGHT_GRAY);
/*  980:     */         
/*  981:1014 */         PdfPCell cell25 = new PdfPCell(new Paragraph("Phone No", 
/*  982:1015 */           mainContent));
/*  983:1016 */         cell25.setBackgroundColor(new BaseColor(238, 238, 238));
/*  984:1017 */         cell25.setBorderWidth(0.01F);
/*  985:1018 */         cell25.setBorderColor(BaseColor.WHITE);
/*  986:     */         
/*  987:1020 */         PdfPCell cell26 = new PdfPCell(new Paragraph(
/*  988:1021 */           this.resultSet.getString("DEALER_PHONE_NO"), mainContent));
/*  989:1022 */         cell26.setBorderWidth(0.2F);
/*  990:1023 */         cell26.setBorderColor(BaseColor.LIGHT_GRAY);
/*  991:     */         
/*  992:1025 */         PdfPCell cell27 = new PdfPCell(new Paragraph("Mobile No", 
/*  993:1026 */           mainContent));
/*  994:1027 */         cell27.setBackgroundColor(new BaseColor(238, 238, 238));
/*  995:1028 */         cell27.setBorderWidth(0.01F);
/*  996:1029 */         cell27.setBorderColor(BaseColor.WHITE);
/*  997:     */         
/*  998:1031 */         PdfPCell cell28 = new PdfPCell(new Paragraph(
/*  999:1032 */           this.resultSet
/* 1000:1033 */           .getString("DEALER_MOBILE_NO"), mainContent));
/* 1001:1034 */         cell28.setBorderWidth(0.2F);
/* 1002:1035 */         cell28.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1003:     */         
/* 1004:1037 */         PdfPCell cell29 = new PdfPCell(new Paragraph(
/* 1005:1038 */           "Fax No", mainContent));
/* 1006:1039 */         cell29.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1007:1040 */         cell29.setBorderWidth(0.01F);
/* 1008:1041 */         cell29.setBorderColor(BaseColor.WHITE);
/* 1009:     */         
/* 1010:1043 */         PdfPCell cell30 = new PdfPCell(new Paragraph(
/* 1011:1044 */           this.resultSet
/* 1012:1045 */           .getString("DEALER_FAX_NO"), 
/* 1013:1046 */           mainContent));
/* 1014:1047 */         cell30.setBorderWidth(0.2F);
/* 1015:1048 */         cell30.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1016:     */         
/* 1017:1050 */         PdfPCell cell31 = new PdfPCell(new Paragraph(
/* 1018:1051 */           "Social Mail Id", mainContent));
/* 1019:1052 */         cell31.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1020:1053 */         cell31.setBorderWidth(0.01F);
/* 1021:1054 */         cell31.setBorderColor(BaseColor.WHITE);
/* 1022:     */         
/* 1023:1056 */         PdfPCell cell32 = new PdfPCell(new Paragraph(
/* 1024:1057 */           this.resultSet
/* 1025:1058 */           .getString("DEALER_SOCIAL_IM_ID"), 
/* 1026:1059 */           mainContent));
/* 1027:1060 */         cell32.setBorderWidth(0.2F);
/* 1028:1061 */         cell32.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1029:     */         
/* 1030:1063 */         PdfPCell cell33 = new PdfPCell(new Paragraph(
/* 1031:1064 */           "Creation Date", mainContent));
/* 1032:1065 */         cell33.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1033:1066 */         cell33.setBorderWidth(0.01F);
/* 1034:1067 */         cell33.setBorderColor(BaseColor.WHITE);
/* 1035:     */         
/* 1036:1069 */         PdfPCell cell34 = new PdfPCell(new Paragraph(
/* 1037:1070 */           this.resultSet
/* 1038:1071 */           .getString("DEALER_CREATION_DATE"), 
/* 1039:1072 */           mainContent));
/* 1040:1073 */         cell34.setBorderWidth(0.2F);
/* 1041:1074 */         cell34.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1042:     */         
/* 1043:1076 */         PdfPCell cell35 = new PdfPCell(new Paragraph(
/* 1044:1077 */           "Updation Date", mainContent));
/* 1045:1078 */         cell35.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1046:1079 */         cell35.setBorderWidth(0.01F);
/* 1047:1080 */         cell35.setBorderColor(BaseColor.WHITE);
/* 1048:     */         
/* 1049:1082 */         PdfPCell cell36 = new PdfPCell(new Paragraph(
/* 1050:1083 */           this.resultSet
/* 1051:1084 */           .getString("DEALER_UPDATION_DATE"), 
/* 1052:1085 */           mainContent));
/* 1053:1086 */         cell36.setBorderWidth(0.2F);
/* 1054:1087 */         cell36.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1055:     */         
/* 1056:1089 */         PdfPCell cell37 = new PdfPCell(new Paragraph());
/* 1057:1090 */         cell37.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1058:1091 */         cell37.setBorderWidth(0.2F);
/* 1059:1092 */         cell37.setBorderColor(BaseColor.WHITE);
/* 1060:     */         
/* 1061:1094 */         PdfPCell cell38 = new PdfPCell(new Paragraph());
/* 1062:1095 */         cell38.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1063:1096 */         cell38.setBorderWidth(0.2F);
/* 1064:1097 */         cell38.setBorderColor(BaseColor.WHITE);
/* 1065:     */         
/* 1066:     */ 
/* 1067:1100 */         PdfPCell cell39 = new PdfPCell(new Paragraph("Created By", 
/* 1068:1101 */           mainContent));
/* 1069:1102 */         cell39.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1070:1103 */         cell39.setBorderWidth(0.01F);
/* 1071:1104 */         cell39.setBorderColor(BaseColor.WHITE);
/* 1072:     */         
/* 1073:1106 */         PdfPCell cell40 = new PdfPCell(new Paragraph(
/* 1074:1107 */           this.resultSet.getString("DEALER_CREATED_BY"), mainContent));
/* 1075:1108 */         cell40.setBorderWidth(0.2F);
/* 1076:1109 */         cell40.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1077:     */         
/* 1078:1111 */         PdfPCell cell41 = new PdfPCell(new Paragraph("Updated By", 
/* 1079:1112 */           mainContent));
/* 1080:1113 */         cell41.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1081:1114 */         cell41.setBorderWidth(0.01F);
/* 1082:1115 */         cell41.setBorderColor(BaseColor.WHITE);
/* 1083:     */         
/* 1084:1117 */         PdfPCell cell42 = new PdfPCell(new Paragraph(
/* 1085:1118 */           this.resultSet.getString("DEALER_UPDATED_BY"), mainContent));
/* 1086:1119 */         cell42.setBorderWidth(0.2F);
/* 1087:1120 */         cell42.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1088:     */         
/* 1089:1122 */         PdfPCell cell43 = new PdfPCell(new Paragraph("Work Location", 
/* 1090:1123 */           mainContent));
/* 1091:1124 */         cell43.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1092:1125 */         cell43.setBorderWidth(0.01F);
/* 1093:1126 */         cell43.setBorderColor(BaseColor.WHITE);
/* 1094:     */         
/* 1095:1128 */         PdfPCell cell44 = new PdfPCell(new Paragraph(
/* 1096:1129 */           this.resultSet.getString("DEALER_WORK_LOCATION"), mainContent));
/* 1097:1130 */         cell44.setBorderWidth(0.2F);
/* 1098:1131 */         cell44.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1099:     */         
/* 1100:1133 */         PdfPCell cell45 = new PdfPCell(new Paragraph("Currency", 
/* 1101:1134 */           mainContent));
/* 1102:1135 */         cell45.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1103:1136 */         cell45.setBorderWidth(0.01F);
/* 1104:1137 */         cell45.setBorderColor(BaseColor.WHITE);
/* 1105:     */         
/* 1106:1139 */         PdfPCell cell46 = new PdfPCell(new Paragraph(
/* 1107:1140 */           this.resultSet.getString("DEALER_REF_CURRENCY"), mainContent));
/* 1108:1141 */         cell46.setBorderWidth(0.2F);
/* 1109:1142 */         cell46.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1110:     */         
/* 1111:1144 */         PdfPCell cell47 = new PdfPCell(new Paragraph("Contact Person", 
/* 1112:1145 */           mainContent));
/* 1113:1146 */         cell47.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1114:1147 */         cell47.setBorderWidth(0.01F);
/* 1115:1148 */         cell47.setBorderColor(BaseColor.WHITE);
/* 1116:     */         
/* 1117:1150 */         PdfPCell cell48 = new PdfPCell(new Paragraph(this.resultSet.getString("DEALER_CONTACT_PERSON"), mainContent));
/* 1118:1151 */         cell48.setBorderWidth(0.2F);
/* 1119:1152 */         cell48.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1120:     */         
/* 1121:1154 */         PdfPCell cell49 = new PdfPCell(new Paragraph("Phone No", 
/* 1122:1155 */           mainContent));
/* 1123:1156 */         cell49.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1124:1157 */         cell49.setBorderWidth(0.01F);
/* 1125:1158 */         cell49.setBorderColor(BaseColor.WHITE);
/* 1126:     */         
/* 1127:1160 */         PdfPCell cell50 = new PdfPCell(new Paragraph(
/* 1128:1161 */           this.resultSet.getString("DEALER_PHONE_NO2"), mainContent));
/* 1129:1162 */         cell50.setBorderWidth(0.2F);
/* 1130:1163 */         cell50.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1131:     */         
/* 1132:1165 */         PdfPCell cell51 = new PdfPCell(new Paragraph("Mobile No", 
/* 1133:1166 */           mainContent));
/* 1134:1167 */         cell51.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1135:1168 */         cell51.setBorderWidth(0.01F);
/* 1136:1169 */         cell51.setBorderColor(BaseColor.WHITE);
/* 1137:     */         
/* 1138:1171 */         PdfPCell cell52 = new PdfPCell(new Paragraph(
/* 1139:1172 */           this.resultSet.getString("DEALER_MOBILE_NO2"), mainContent));
/* 1140:1173 */         cell52.setBorderWidth(0.2F);
/* 1141:1174 */         cell52.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1142:     */         
/* 1143:1176 */         PdfPCell cell53 = new PdfPCell(new Paragraph("FAX ISD", 
/* 1144:1177 */           mainContent));
/* 1145:1178 */         cell53.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1146:1179 */         cell53.setBorderWidth(0.01F);
/* 1147:1180 */         cell53.setBorderColor(BaseColor.WHITE);
/* 1148:     */         
/* 1149:1182 */         PdfPCell cell54 = new PdfPCell(new Paragraph(
/* 1150:1183 */           this.resultSet.getString("DEALER_FAX_ISD"), mainContent));
/* 1151:1184 */         cell54.setBorderWidth(0.2F);
/* 1152:1185 */         cell54.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1153:     */         
/* 1154:1187 */         PdfPCell cell55 = new PdfPCell(new Paragraph(
/* 1155:1188 */           "FAX STD", mainContent));
/* 1156:1189 */         cell55.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1157:1190 */         cell55.setBorderWidth(0.01F);
/* 1158:1191 */         cell55.setBorderColor(BaseColor.WHITE);
/* 1159:     */         
/* 1160:1193 */         PdfPCell cell56 = new PdfPCell(new Paragraph(
/* 1161:1194 */           this.resultSet.getString("DEALER_FAX_STD"), mainContent));
/* 1162:1195 */         cell56.setBorderWidth(0.2F);
/* 1163:1196 */         cell56.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1164:     */         
/* 1165:1198 */         PdfPCell cell57 = new PdfPCell(new Paragraph(
/* 1166:1199 */           "Country", mainContent));
/* 1167:1200 */         cell57.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1168:1201 */         cell57.setBorderWidth(0.01F);
/* 1169:1202 */         cell57.setBorderColor(BaseColor.WHITE);
/* 1170:     */         
/* 1171:1204 */         PdfPCell cell58 = new PdfPCell(new Paragraph(
/* 1172:1205 */           this.resultSet.getString("DEALER_COUNTRY"), 
/* 1173:1206 */           mainContent));
/* 1174:1207 */         cell58.setBorderWidth(0.2F);
/* 1175:1208 */         cell58.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1176:     */         
/* 1177:1210 */         PdfPCell cell59 = new PdfPCell(new Paragraph(
/* 1178:1211 */           "Phone ISD", mainContent));
/* 1179:1212 */         cell59.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1180:1213 */         cell59.setBorderWidth(0.01F);
/* 1181:1214 */         cell59.setBorderColor(BaseColor.WHITE);
/* 1182:     */         
/* 1183:1216 */         PdfPCell cell60 = new PdfPCell(new Paragraph(
/* 1184:1217 */           this.resultSet.getString("DEALER_PHONE_ISD"), 
/* 1185:1218 */           mainContent));
/* 1186:1219 */         cell60.setBorderWidth(0.2F);
/* 1187:1220 */         cell60.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1188:     */         
/* 1189:1222 */         PdfPCell cell61 = new PdfPCell(new Paragraph(
/* 1190:1223 */           "STD", mainContent));
/* 1191:1224 */         cell61.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1192:1225 */         cell61.setBorderWidth(0.01F);
/* 1193:1226 */         cell61.setBorderColor(BaseColor.WHITE);
/* 1194:     */         
/* 1195:1228 */         PdfPCell cell62 = new PdfPCell(new Paragraph(
/* 1196:1229 */           this.resultSet.getString("DEALER_PHONE_STD"), 
/* 1197:1230 */           mainContent));
/* 1198:1231 */         cell62.setBorderWidth(0.2F);
/* 1199:1232 */         cell62.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1200:     */         
/* 1201:1234 */         PdfPCell cell63 = new PdfPCell(new Paragraph(
/* 1202:1235 */           "Alternative ISD", mainContent));
/* 1203:1236 */         cell63.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1204:1237 */         cell63.setBorderWidth(0.01F);
/* 1205:1238 */         cell63.setBorderColor(BaseColor.WHITE);
/* 1206:     */         
/* 1207:1240 */         PdfPCell cell64 = new PdfPCell(new Paragraph(
/* 1208:1241 */           this.resultSet.getString("DEALER_PHONE_ISD2"), 
/* 1209:1242 */           mainContent));
/* 1210:1243 */         cell64.setBorderWidth(0.2F);
/* 1211:1244 */         cell64.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1212:     */         
/* 1213:1246 */         PdfPCell cell65 = new PdfPCell(new Paragraph(
/* 1214:1247 */           "Alternative STD", mainContent));
/* 1215:1248 */         cell65.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1216:1249 */         cell65.setBorderWidth(0.01F);
/* 1217:1250 */         cell65.setBorderColor(BaseColor.WHITE);
/* 1218:     */         
/* 1219:1252 */         PdfPCell cell66 = new PdfPCell(new Paragraph(
/* 1220:1253 */           this.resultSet.getString("DEALER_PHONE_STD2"), 
/* 1221:1254 */           mainContent));
/* 1222:1255 */         cell66.setBorderWidth(0.2F);
/* 1223:1256 */         cell66.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1224:     */         
/* 1225:1258 */         PdfPCell cell67 = new PdfPCell(new Paragraph(
/* 1226:1259 */           "Mobile ISD", mainContent));
/* 1227:1260 */         cell67.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1228:1261 */         cell67.setBorderWidth(0.01F);
/* 1229:1262 */         cell67.setBorderColor(BaseColor.WHITE);
/* 1230:     */         
/* 1231:1264 */         PdfPCell cell68 = new PdfPCell(new Paragraph(
/* 1232:1265 */           this.resultSet.getString("DEALER_MOBILE_ISD1"), 
/* 1233:1266 */           mainContent));
/* 1234:1267 */         cell68.setBorderWidth(0.2F);
/* 1235:1268 */         cell68.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1236:     */         
/* 1237:1270 */         PdfPCell cell69 = new PdfPCell(new Paragraph(
/* 1238:1271 */           "Alternative Mobile ISD", mainContent));
/* 1239:1272 */         cell69.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1240:1273 */         cell69.setBorderWidth(0.01F);
/* 1241:1274 */         cell69.setBorderColor(BaseColor.WHITE);
/* 1242:     */         
/* 1243:1276 */         PdfPCell cell70 = new PdfPCell(new Paragraph(
/* 1244:1277 */           this.resultSet.getString("DEALER_MOBILE_ISD2"), 
/* 1245:1278 */           mainContent));
/* 1246:1279 */         cell70.setBorderWidth(0.2F);
/* 1247:1280 */         cell70.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1248:     */         
/* 1249:1282 */         PdfPCell cell71 = new PdfPCell(new Paragraph(
/* 1250:1283 */           "Website", mainContent));
/* 1251:1284 */         cell71.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1252:1285 */         cell71.setBorderWidth(0.01F);
/* 1253:1286 */         cell71.setBorderColor(BaseColor.WHITE);
/* 1254:     */         
/* 1255:1288 */         PdfPCell cell72 = new PdfPCell(new Paragraph(
/* 1256:1289 */           this.resultSet.getString("DEALER_HOME_WEBSITE"), 
/* 1257:1290 */           mainContent));
/* 1258:1291 */         cell72.setBorderWidth(0.2F);
/* 1259:1292 */         cell72.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1260:     */         
/* 1261:1294 */         PdfPCell cell73 = new PdfPCell(new Paragraph(
/* 1262:1295 */           "Reffered by", mainContent));
/* 1263:1296 */         cell73.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1264:1297 */         cell73.setBorderWidth(0.01F);
/* 1265:1298 */         cell73.setBorderColor(BaseColor.WHITE);
/* 1266:     */         
/* 1267:1300 */         PdfPCell cell74 = new PdfPCell(new Paragraph(
/* 1268:1301 */           this.resultSet.getString("DEALER_REFFERED_BY"), 
/* 1269:1302 */           mainContent));
/* 1270:1303 */         cell74.setBorderWidth(0.2F);
/* 1271:1304 */         cell74.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1272:     */         
/* 1273:1306 */         PdfPCell cell75 = new PdfPCell(new Paragraph(
/* 1274:1307 */           "Discription", mainContent));
/* 1275:1308 */         cell75.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1276:1309 */         cell75.setBorderWidth(0.01F);
/* 1277:1310 */         cell75.setBorderColor(BaseColor.WHITE);
/* 1278:     */         
/* 1279:1312 */         PdfPCell cell76 = new PdfPCell(new Paragraph(
/* 1280:1313 */           this.resultSet.getString("DEALER_PROFILE_DISC"), 
/* 1281:1314 */           mainContent));
/* 1282:1315 */         cell76.setBorderWidth(0.2F);
/* 1283:1316 */         cell76.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1284:     */         
/* 1285:     */ 
/* 1286:     */ 
/* 1287:     */ 
/* 1288:1321 */         System.out.println(this.resultSet.getString("DEALER_COUNTRY") + " " + this.resultSet.getString("DEALER_MOBILE_NO") + "ccccccccc");
/* 1289:     */         
/* 1290:1323 */         table.addCell(cell);
/* 1291:1324 */         table.addCell(cell1);
/* 1292:1325 */         table.addCell(cell2);
/* 1293:1326 */         table.addCell(cell3);
/* 1294:1327 */         table.addCell(cell4);
/* 1295:1328 */         table.addCell(cell5);
/* 1296:1329 */         table.addCell(cell6);
/* 1297:1330 */         table.addCell(cell7);
/* 1298:1331 */         table.addCell(cell8);
/* 1299:1332 */         table.addCell(cell9);
/* 1300:1333 */         table.addCell(cell10);
/* 1301:1334 */         table.addCell(cell11);
/* 1302:1335 */         table.addCell(cell12);
/* 1303:1336 */         table.addCell(cell13);
/* 1304:1337 */         table.addCell(cell14);
/* 1305:1338 */         table.addCell(cell15);
/* 1306:1339 */         table.addCell(cell16);
/* 1307:1340 */         table.addCell(cell17);
/* 1308:1341 */         table.addCell(cell18);
/* 1309:1342 */         table.addCell(cell19);
/* 1310:1343 */         table.addCell(cell20);
/* 1311:1344 */         table.addCell(cell21);
/* 1312:1345 */         table.addCell(cell22);
/* 1313:1346 */         table.addCell(cell23);
/* 1314:1347 */         table.addCell(cell24);
/* 1315:1348 */         table.addCell(cell25);
/* 1316:1349 */         table.addCell(cell26);
/* 1317:1350 */         table.addCell(cell27);
/* 1318:1351 */         table.addCell(cell28);
/* 1319:1352 */         table.addCell(cell29);
/* 1320:1353 */         table.addCell(cell30);
/* 1321:1354 */         table.addCell(cell31);
/* 1322:1355 */         table.addCell(cell32);
/* 1323:1356 */         table.addCell(cell33);
/* 1324:1357 */         table.addCell(cell34);
/* 1325:1358 */         table.addCell(cell35);
/* 1326:1359 */         table.addCell(cell36);
/* 1327:1360 */         table.addCell(cell37);
/* 1328:1361 */         table.addCell(cell38);
/* 1329:1362 */         table.addCell(cell39);
/* 1330:1363 */         table.addCell(cell40);
/* 1331:1364 */         table.addCell(cell41);
/* 1332:1365 */         table.addCell(cell42);
/* 1333:1366 */         table.addCell(cell43);
/* 1334:1367 */         table.addCell(cell44);
/* 1335:1368 */         table.addCell(cell45);
/* 1336:1369 */         table.addCell(cell46);
/* 1337:1370 */         table.addCell(cell47);
/* 1338:1371 */         table.addCell(cell48);
/* 1339:1372 */         table.addCell(cell49);
/* 1340:1373 */         table.addCell(cell50);
/* 1341:1374 */         table.addCell(cell51);
/* 1342:1375 */         table.addCell(cell52);
/* 1343:1376 */         table.addCell(cell53);
/* 1344:1377 */         table.addCell(cell54);
/* 1345:1378 */         table.addCell(cell55);
/* 1346:1379 */         table.addCell(cell56);
/* 1347:1380 */         table.addCell(cell57);
/* 1348:1381 */         table.addCell(cell58);
/* 1349:1382 */         table.addCell(cell59);
/* 1350:1383 */         table.addCell(cell60);
/* 1351:1384 */         table.addCell(cell61);
/* 1352:1385 */         table.addCell(cell62);
/* 1353:1386 */         table.addCell(cell63);
/* 1354:1387 */         table.addCell(cell64);
/* 1355:1388 */         table.addCell(cell65);
/* 1356:1389 */         table.addCell(cell66);
/* 1357:1390 */         table.addCell(cell67);
/* 1358:1391 */         table.addCell(cell68);
/* 1359:1392 */         table.addCell(cell69);
/* 1360:1393 */         table.addCell(cell70);
/* 1361:1394 */         table.addCell(cell71);
/* 1362:1395 */         table.addCell(cell72);
/* 1363:1396 */         table.addCell(cell73);
/* 1364:1397 */         table.addCell(cell74);
/* 1365:1398 */         table.addCell(cell75);
/* 1366:1399 */         table.addCell(cell76);
/* 1367:     */         
/* 1368:     */ 
/* 1369:     */ 
/* 1370:     */ 
/* 1371:     */ 
/* 1372:1405 */         document.add(table);
/* 1373:     */       }
/* 1374:1409 */       document.add(new Paragraph("\n"));
/* 1375:     */       
/* 1376:     */ 
/* 1377:     */ 
/* 1378:1413 */       document.close();
/* 1379:     */     }
/* 1380:     */     catch (SQLException sqlExp)
/* 1381:     */     {
/* 1382:1416 */       sqlExp.printStackTrace();
/* 1383:1417 */       logger.error(
/* 1384:1418 */         DealerDaoImpl.class + 
/* 1385:1419 */         "Error: Occur in Query While Fetching All Dealer detail for print PdF from Database.", 
/* 1386:1420 */         sqlExp);
/* 1387:     */     }
/* 1388:     */     catch (Exception exception)
/* 1389:     */     {
/* 1390:1422 */       exception.printStackTrace();
/* 1391:1423 */       logger.error(
/* 1392:1424 */         DealerDaoImpl.class + 
/* 1393:1425 */         "Error: Occur in Query While Closing Connection After Fetching All Dealer details for print PdF from Database.", 
/* 1394:1426 */         exception);
/* 1395:     */     }
/* 1396:     */     finally
/* 1397:     */     {
/* 1398:1428 */       JdbcHelper.closeResultSet(this.resultSet);
/* 1399:1429 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/* 1400:1430 */       JdbcHelper.closeConnection(this.connection);
/* 1401:     */     }
/* 1402:     */   }
/* 1403:     */   
/* 1404:     */   public void dealerTransactionPrintPDF(HttpServletRequest request, HttpServletResponse response, int transId)
/* 1405:     */   {
/* 1406:1443 */     String companyName = "Chouksay Traders";
/* 1407:1444 */     String address1 = "BUS STAND SHAMSHABAD, DIST.- VIDISHA, MADHYA PRADESH, 464001";
/* 1408:1445 */     String address2 = "GSTIN: 23AJQPC8200P1Z1";
/* 1409:1446 */     String address3 = "PAN NO: AJQPC8200P";
/* 1410:     */     
/* 1411:1448 */     String city = "Vidisha-464001";
/* 1412:1449 */     String state = "(M.P.)";
/* 1413:1450 */     StringBuffer stringBuffer = null;
/* 1414:     */     try
/* 1415:     */     {
/* 1416:1454 */       this.connection = getConnection();
/* 1417:     */       
/* 1418:1456 */       this.preparedStatement = this.connection
/* 1419:1457 */         .prepareStatement("SELECT * FROM TAB_DEALER_OWNER_TRANSACTION WHERE DEALER_TRANS_ID=?");
/* 1420:1458 */       this.preparedStatement.setInt(1, transId);
/* 1421:     */       
/* 1422:     */ 
/* 1423:1461 */       this.resultSet = this.preparedStatement.executeQuery();
/* 1424:1462 */       Document document = new Document(PageSize.A4);
/* 1425:     */       
/* 1426:1464 */       Font Font3 = new Font(Font.FontFamily.TIMES_ROMAN, 11.0F, 0);
/* 1427:1465 */       Font Font2 = new Font(Font.FontFamily.TIMES_ROMAN, 6.0F, 
/* 1428:1466 */         8);
/* 1429:1467 */       Font Font4 = new Font(Font.FontFamily.TIMES_ROMAN, 11.0F, 1);
/* 1430:1468 */       Font4.setColor(BaseColor.WHITE);
/* 1431:1469 */       Font mainContent = new Font(Font.FontFamily.TIMES_ROMAN, 10.0F, 
/* 1432:1470 */         0);
/* 1433:1471 */       Font Font5 = new Font(Font.FontFamily.TIMES_ROMAN, 12.0F, 1);
/* 1434:1472 */       Font5.setColor(BaseColor.GRAY);
/* 1435:1473 */       Font Font6 = new Font(Font.FontFamily.TIMES_ROMAN, 10.0F, 1);
/* 1436:1474 */       Font6.setColor(BaseColor.RED);
/* 1437:     */       
/* 1438:     */ 
/* 1439:1477 */       response.setContentType("application/pdf");
/* 1440:     */       
/* 1441:1479 */       PdfWriter.getInstance(document, response.getOutputStream());
/* 1442:     */       
/* 1443:1481 */       document.open();
/* 1444:     */       
/* 1445:1483 */       String contextPath = ServletActionContext.getServletContext()
/* 1446:1484 */         .getRealPath("/outer/img/rohittraders.png");
/* 1447:1485 */       this.image = Image.getInstance(contextPath);
/* 1448:1486 */       this.image.scaleToFit(130.0F, 70.0F);
/* 1449:     */       
/* 1450:1488 */       PdfPTable table1 = new PdfPTable(2);
/* 1451:1489 */       table1.setWidthPercentage(100.0F);
/* 1452:1490 */       Rectangle rect1 = new Rectangle(300.0F, 700.0F);
/* 1453:1491 */       table1.setWidthPercentage(new float[] { 150.0F, 150.0F }, rect1);
/* 1454:     */       
/* 1455:1493 */       PdfPCell cell101 = new PdfPCell(this.image, false);
/* 1456:1494 */       cell101.setPaddingTop(5.0F);
/* 1457:1495 */       cell101.setBorder(0);
/* 1458:     */       
/* 1459:1497 */       Phrase phrase3 = new Phrase(companyName + "\n", Font5);
/* 1460:1498 */       Phrase phrase = new Phrase(address1 + "\n", Font3);
/* 1461:1499 */       Phrase phrase1 = new Phrase(address2 + "\n", Font3);
/* 1462:1500 */       Phrase phrase4 = new Phrase(address3 + "\n", Font3);
/* 1463:1501 */       Phrase phrase2 = new Phrase(city + "-" + state, Font3);
/* 1464:     */       
/* 1465:1503 */       Paragraph paragraph = new Paragraph();
/* 1466:1504 */       paragraph.add(phrase3);
/* 1467:1505 */       paragraph.add(phrase);
/* 1468:1506 */       paragraph.add(phrase1);
/* 1469:1507 */       paragraph.add(phrase4);
/* 1470:1508 */       paragraph.add(phrase2);
/* 1471:     */       
/* 1472:1510 */       PdfPCell cell102 = new PdfPCell(paragraph);
/* 1473:1511 */       cell102.setPaddingTop(5.0F);
/* 1474:1512 */       cell102.setBorder(0);
/* 1475:1513 */       cell102.setHorizontalAlignment(2);
/* 1476:     */       
/* 1477:1515 */       PdfPCell cell103 = new PdfPCell(
/* 1478:1516 */         new Paragraph(
/* 1479:1517 */         "   \n                                                                                                                                                                                                                                                                                                                                                  ", 
/* 1480:     */         
/* 1481:     */ 
/* 1482:1520 */         Font2));
/* 1483:1521 */       cell103.setColspan(2);
/* 1484:1522 */       cell103.setBorderWidthRight(0.0F);
/* 1485:1523 */       cell103.setBorderWidthLeft(0.0F);
/* 1486:1524 */       cell103.setBorderWidthTop(0.5F);
/* 1487:1525 */       cell103.setBorderWidthBottom(0.0F);
/* 1488:1526 */       cell103.setBorderColorTop(BaseColor.WHITE);
/* 1489:     */       
/* 1490:1528 */       PdfPCell cell104 = new PdfPCell(new Paragraph("DEALER TRANSACTION", Font4));
/* 1491:1529 */       cell104.setUseBorderPadding(true);
/* 1492:1530 */       cell104.setColspan(2);
/* 1493:1531 */       cell104.setBorderWidthRight(0.1F);
/* 1494:1532 */       cell104.setBorderWidthLeft(0.1F);
/* 1495:1533 */       cell104.setBorderWidthTop(0.1F);
/* 1496:1534 */       cell104.setBorderWidthBottom(0.1F);
/* 1497:1535 */       cell104.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1498:1536 */       cell104.setBackgroundColor(new BaseColor(0, 59, 119));
/* 1499:     */       
/* 1500:1538 */       table1.addCell(cell101);
/* 1501:1539 */       table1.addCell(cell102);
/* 1502:1540 */       table1.addCell(cell103);
/* 1503:1541 */       table1.addCell(cell104);
/* 1504:1542 */       document.add(table1);
/* 1505:1548 */       while (this.resultSet.next())
/* 1506:     */       {
/* 1507:1549 */         stringBuffer = new StringBuffer();
/* 1508:1550 */         PdfPTable table = new PdfPTable(2);
/* 1509:1551 */         table.setFooterRows(1);
/* 1510:1552 */         table.setWidthPercentage(100.0F);
/* 1511:1553 */         Rectangle rect = new Rectangle(300.0F, 700.0F);
/* 1512:1554 */         table.setWidthPercentage(new float[] { 80.0F, 220.0F }, rect);
/* 1513:     */         
/* 1514:1556 */         PdfPCell cell = new PdfPCell(new Paragraph());
/* 1515:1557 */         cell.setColspan(2);
/* 1516:1558 */         cell.setBorderWidthRight(0.1F);
/* 1517:1559 */         cell.setBorderWidthLeft(0.1F);
/* 1518:1560 */         cell.setBorderWidthTop(0.1F);
/* 1519:1561 */         cell.setBorderWidthBottom(0.2F);
/* 1520:1562 */         cell.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1521:1563 */         cell.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1522:     */         
/* 1523:1565 */         PdfPCell cell1 = new PdfPCell(new Paragraph());
/* 1524:1566 */         cell1.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1525:1567 */         cell1.setBorderWidth(0.01F);
/* 1526:1568 */         cell1.setBorderColor(BaseColor.WHITE);
/* 1527:     */         
/* 1528:1570 */         PdfPCell cell2 = new PdfPCell(new Paragraph());
/* 1529:1571 */         cell2.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1530:1572 */         cell2.setBorderWidth(0.2F);
/* 1531:1573 */         cell2.setBorderColor(BaseColor.WHITE);
/* 1532:     */         
/* 1533:1575 */         PdfPCell cell3 = new PdfPCell(new Paragraph("Transaction Id", 
/* 1534:1576 */           mainContent));
/* 1535:1577 */         cell3.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1536:1578 */         cell3.setBorderWidth(0.01F);
/* 1537:1579 */         cell3.setBorderColor(BaseColor.WHITE);
/* 1538:     */         
/* 1539:1581 */         PdfPCell cell4 = new PdfPCell(new Paragraph(this.resultSet.getString("DEALER_TRANS_ID"), mainContent));
/* 1540:1582 */         cell4.setBorderWidth(0.2F);
/* 1541:1583 */         cell4.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1542:     */         
/* 1543:1585 */         PdfPCell cell5 = new PdfPCell(new Paragraph(
/* 1544:1586 */           "Description", mainContent));
/* 1545:1587 */         cell5.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1546:1588 */         cell5.setBorderWidth(0.01F);
/* 1547:1589 */         cell5.setBorderColor(BaseColor.WHITE);
/* 1548:     */         
/* 1549:1591 */         PdfPCell cell6 = new PdfPCell(new Paragraph(this.resultSet.getString("DEALER_TRANS_DISCRIPTION"), mainContent));
/* 1550:1592 */         cell6.setBorderWidth(0.2F);
/* 1551:1593 */         cell6.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1552:     */         
/* 1553:1595 */         PdfPCell cell7 = new PdfPCell(new Paragraph("Total", 
/* 1554:1596 */           mainContent));
/* 1555:1597 */         cell7.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1556:1598 */         cell7.setBorderWidth(0.01F);
/* 1557:1599 */         cell7.setBorderColor(BaseColor.WHITE);
/* 1558:     */         
/* 1559:1601 */         PdfPCell cell8 = new PdfPCell(new Paragraph(
/* 1560:1602 */           this.resultSet.getString("DEALER_TRANS_TOTAL"), mainContent));
/* 1561:1603 */         cell8.setBorderWidth(0.2F);
/* 1562:1604 */         cell8.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1563:     */         
/* 1564:     */ 
/* 1565:     */ 
/* 1566:1608 */         PdfPCell cell9 = new PdfPCell(new Paragraph("Paid", 
/* 1567:1609 */           mainContent));
/* 1568:1610 */         cell9.setBorderWidth(0.2F);
/* 1569:1611 */         cell9.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1570:     */         
/* 1571:1613 */         PdfPCell cell10 = new PdfPCell(new Paragraph(
/* 1572:1614 */           this.resultSet.getString("DEALER_TRANS_PAID"), mainContent));
/* 1573:1615 */         cell10.setBorderWidth(0.2F);
/* 1574:1616 */         cell10.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1575:     */         
/* 1576:1618 */         PdfPCell cell11 = new PdfPCell(new Paragraph("Due", 
/* 1577:1619 */           mainContent));
/* 1578:1620 */         cell11.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1579:1621 */         cell11.setBorderWidth(0.01F);
/* 1580:1622 */         cell11.setBorderColor(BaseColor.WHITE);
/* 1581:     */         
/* 1582:1624 */         PdfPCell cell12 = new PdfPCell(new Paragraph(this.resultSet.getString("DEALER_TRANS_DUE"), mainContent));
/* 1583:1625 */         cell12.setBorderWidth(0.2F);
/* 1584:1626 */         cell12.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1585:     */         
/* 1586:1628 */         PdfPCell cell13 = new PdfPCell(new Paragraph("Total Paid", 
/* 1587:1629 */           mainContent));
/* 1588:1630 */         cell13.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1589:1631 */         cell13.setBorderWidth(0.01F);
/* 1590:1632 */         cell13.setBorderColor(BaseColor.WHITE);
/* 1591:     */         
/* 1592:1634 */         PdfPCell cell14 = new PdfPCell(new Paragraph(this.resultSet.getString("DEALER_TRANS_TOTAL_PAID"), mainContent));
/* 1593:1635 */         cell14.setBorderWidth(0.2F);
/* 1594:1636 */         cell14.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1595:     */         
/* 1596:1638 */         PdfPCell cell15 = new PdfPCell(new Paragraph(
/* 1597:1639 */           "SGST", mainContent));
/* 1598:1640 */         cell15.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1599:1641 */         cell15.setBorderWidth(0.01F);
/* 1600:1642 */         cell15.setBorderColor(BaseColor.WHITE);
/* 1601:     */         
/* 1602:1644 */         PdfPCell cell16 = new PdfPCell(new Paragraph(this.resultSet.getString("DEALER_TRANS_TOTAL_DUE"), mainContent));
/* 1603:1645 */         cell16.setBorderWidth(0.2F);
/* 1604:1646 */         cell16.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1605:     */         
/* 1606:1648 */         PdfPCell cell17 = new PdfPCell(new Paragraph("Bill No", 
/* 1607:1649 */           mainContent));
/* 1608:1650 */         cell17.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1609:1651 */         cell17.setBorderWidth(0.01F);
/* 1610:1652 */         cell17.setBorderColor(BaseColor.WHITE);
/* 1611:     */         
/* 1612:1654 */         PdfPCell cell18 = new PdfPCell(new Paragraph(this.resultSet.getString("DEALER_TRANS_BILL_NO"), mainContent));
/* 1613:1655 */         cell18.setBorderWidth(0.2F);
/* 1614:1656 */         cell18.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1615:     */         
/* 1616:1658 */         PdfPCell cell19 = new PdfPCell(new Paragraph("Payment Mode", 
/* 1617:1659 */           mainContent));
/* 1618:1660 */         cell19.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1619:1661 */         cell19.setBorderWidth(0.01F);
/* 1620:1662 */         cell19.setBorderColor(BaseColor.WHITE);
/* 1621:     */         
/* 1622:1664 */         PdfPCell cell20 = new PdfPCell(new Paragraph(this.resultSet.getString("DEALER_TANS_PAYMENT_MODE"), mainContent));
/* 1623:1665 */         cell20.setBorderWidth(0.2F);
/* 1624:1666 */         cell20.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1625:     */         
/* 1626:1668 */         PdfPCell cell21 = new PdfPCell(new Paragraph("Transaction Date", 
/* 1627:1669 */           mainContent));
/* 1628:1670 */         cell21.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1629:1671 */         cell21.setBorderWidth(0.01F);
/* 1630:1672 */         cell21.setBorderColor(BaseColor.WHITE);
/* 1631:     */         
/* 1632:1674 */         PdfPCell cell22 = new PdfPCell(new Paragraph(this.resultSet.getString("DEALER_TRANS_DATE"), mainContent));
/* 1633:1675 */         cell22.setBorderWidth(0.2F);
/* 1634:1676 */         cell22.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1635:     */         
/* 1636:1678 */         PdfPCell cell23 = new PdfPCell(new Paragraph(
/* 1637:1679 */           "Dealer Reference", mainContent));
/* 1638:1680 */         cell23.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1639:1681 */         cell23.setBorderWidth(0.01F);
/* 1640:1682 */         cell23.setBorderColor(BaseColor.WHITE);
/* 1641:     */         
/* 1642:1684 */         PdfPCell cell24 = new PdfPCell(
/* 1643:1685 */           new Paragraph(this.resultSet.getString(
/* 1644:1686 */           "DEALER_ID_REF"), 
/* 1645:1687 */           mainContent));
/* 1646:1688 */         cell24.setBorderWidth(0.2F);
/* 1647:1689 */         cell24.setBorderColor(BaseColor.LIGHT_GRAY);
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
/* 1757:     */ 
/* 1758:     */ 
/* 1759:     */ 
/* 1760:     */ 
/* 1761:     */ 
/* 1762:     */ 
/* 1763:     */ 
/* 1764:     */ 
/* 1765:     */ 
/* 1766:     */ 
/* 1767:     */ 
/* 1768:     */ 
/* 1769:     */ 
/* 1770:     */ 
/* 1771:     */ 
/* 1772:     */ 
/* 1773:     */ 
/* 1774:     */ 
/* 1775:     */ 
/* 1776:     */ 
/* 1777:     */ 
/* 1778:     */ 
/* 1779:     */ 
/* 1780:     */ 
/* 1781:     */ 
/* 1782:     */ 
/* 1783:     */ 
/* 1784:     */ 
/* 1785:     */ 
/* 1786:     */ 
/* 1787:     */ 
/* 1788:     */ 
/* 1789:     */ 
/* 1790:     */ 
/* 1791:     */ 
/* 1792:     */ 
/* 1793:     */ 
/* 1794:     */ 
/* 1795:     */ 
/* 1796:     */ 
/* 1797:     */ 
/* 1798:     */ 
/* 1799:     */ 
/* 1800:     */ 
/* 1801:     */ 
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
/* 1839:     */ 
/* 1840:     */ 
/* 1841:     */ 
/* 1842:     */ 
/* 1843:     */ 
/* 1844:     */ 
/* 1845:     */ 
/* 1846:     */ 
/* 1847:     */ 
/* 1848:     */ 
/* 1849:1891 */         table.addCell(cell);
/* 1850:1892 */         table.addCell(cell1);
/* 1851:1893 */         table.addCell(cell2);
/* 1852:1894 */         table.addCell(cell3);
/* 1853:1895 */         table.addCell(cell4);
/* 1854:1896 */         table.addCell(cell5);
/* 1855:1897 */         table.addCell(cell6);
/* 1856:1898 */         table.addCell(cell7);
/* 1857:1899 */         table.addCell(cell8);
/* 1858:1900 */         table.addCell(cell9);
/* 1859:1901 */         table.addCell(cell10);
/* 1860:1902 */         table.addCell(cell11);
/* 1861:1903 */         table.addCell(cell12);
/* 1862:1904 */         table.addCell(cell13);
/* 1863:1905 */         table.addCell(cell14);
/* 1864:1906 */         table.addCell(cell15);
/* 1865:1907 */         table.addCell(cell16);
/* 1866:1908 */         table.addCell(cell17);
/* 1867:1909 */         table.addCell(cell18);
/* 1868:1910 */         table.addCell(cell19);
/* 1869:1911 */         table.addCell(cell20);
/* 1870:1912 */         table.addCell(cell21);
/* 1871:1913 */         table.addCell(cell22);
/* 1872:1914 */         table.addCell(cell23);
/* 1873:1915 */         table.addCell(cell24);
/* 1874:     */         
/* 1875:     */ 
/* 1876:     */ 
/* 1877:     */ 
/* 1878:     */ 
/* 1879:     */ 
/* 1880:     */ 
/* 1881:     */ 
/* 1882:     */ 
/* 1883:     */ 
/* 1884:     */ 
/* 1885:     */ 
/* 1886:     */ 
/* 1887:     */ 
/* 1888:     */ 
/* 1889:     */ 
/* 1890:     */ 
/* 1891:     */ 
/* 1892:     */ 
/* 1893:     */ 
/* 1894:     */ 
/* 1895:     */ 
/* 1896:     */ 
/* 1897:     */ 
/* 1898:     */ 
/* 1899:     */ 
/* 1900:     */ 
/* 1901:     */ 
/* 1902:     */ 
/* 1903:     */ 
/* 1904:     */ 
/* 1905:     */ 
/* 1906:     */ 
/* 1907:     */ 
/* 1908:     */ 
/* 1909:     */ 
/* 1910:     */ 
/* 1911:     */ 
/* 1912:1954 */         document.add(table);
/* 1913:     */       }
/* 1914:1958 */       document.add(new Paragraph("\n"));
/* 1915:     */       
/* 1916:     */ 
/* 1917:     */ 
/* 1918:     */ 
/* 1919:1963 */       document.close();
/* 1920:     */     }
/* 1921:     */     catch (SQLException sqlExp)
/* 1922:     */     {
/* 1923:1966 */       sqlExp.printStackTrace();
/* 1924:1967 */       logger.error(
/* 1925:1968 */         DealerDaoImpl.class + 
/* 1926:1969 */         "Error: Occur in Query While Fetching All Dealer detail for print PdF from Database.", 
/* 1927:1970 */         sqlExp);
/* 1928:     */     }
/* 1929:     */     catch (Exception exception)
/* 1930:     */     {
/* 1931:1972 */       exception.printStackTrace();
/* 1932:1973 */       logger.error(
/* 1933:1974 */         DealerDaoImpl.class + 
/* 1934:1975 */         "Error: Occur in Query While Closing Connection After Fetching All Dealer detail for print PdF from Database.", 
/* 1935:1976 */         exception);
/* 1936:     */     }
/* 1937:     */     finally
/* 1938:     */     {
/* 1939:1978 */       JdbcHelper.closeResultSet(this.resultSet);
/* 1940:1979 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/* 1941:1980 */       JdbcHelper.closeConnection(this.connection);
/* 1942:     */     }
/* 1943:     */   }
/* 1944:     */   
/* 1945:     */   public List<DealerVO> retriveDealerDetailsForAdvanceSearch(int searchId, String searchValue)
/* 1946:     */     throws RecordNotFoundException
/* 1947:     */   {
/* 1948:1991 */     List<DealerVO> dealerDetailList = new ArrayList();
/* 1949:     */     try
/* 1950:     */     {
/* 1951:1995 */       this.connection = getConnection();
/* 1952:1996 */       this.preparedStatement = this.connection
/* 1953:1997 */         .prepareStatement(
/* 1954:1998 */         QueryBuilder.DealerDetailAdvanaceSearch(searchId, searchValue));
/* 1955:1999 */       this.resultSet = this.preparedStatement.executeQuery();
/* 1956:2003 */       while (this.resultSet.next())
/* 1957:     */       {
/* 1958:2004 */         this.dealerVO = new DealerVO();
/* 1959:2005 */         this.dealerVO.setDealerId(this.resultSet.getInt("DEALER_ID"));
/* 1960:     */         
/* 1961:     */ 
/* 1962:     */ 
/* 1963:2009 */         this.dealerVO.setFullName(this.resultSet.getString("DEALER_FULL_NAME"));
/* 1964:     */         
/* 1965:2011 */         this.dealerVO.setDob(this.resultSet
/* 1966:2012 */           .getString("DEALER_DATE_OF_BIRTH"));
/* 1967:     */         
/* 1968:2014 */         this.dealerVO.setAddress1(this.resultSet
/* 1969:2015 */           .getString("DEALER_ADDRESS_LINE_1"));
/* 1970:     */         
/* 1971:2017 */         this.dealerVO.setAddress2(this.resultSet
/* 1972:2018 */           .getString("DEALER_ADDRESS_LINE_2"));
/* 1973:     */         
/* 1974:     */ 
/* 1975:2021 */         this.dealerVO.setCity(this.nameHelper.getCityNameByCityId(this.resultSet.getInt("DEALER_CITY")));
/* 1976:     */         
/* 1977:2023 */         this.dealerVO.setState(this.nameHelper.getStateNameByStateId(this.resultSet
/* 1978:2024 */           .getInt("DEALER_STATE")));
/* 1979:     */         
/* 1980:2026 */         this.dealerVO.setPhoneNo(this.resultSet
/* 1981:2027 */           .getString("DEALER_PHONE_NO"));
/* 1982:     */         
/* 1983:2029 */         this.dealerVO.setMobileNo(this.resultSet
/* 1984:2030 */           .getString("DEALER_MOBILE_NO"));
/* 1985:     */         
/* 1986:2032 */         this.dealerVO.setPinCode(this.resultSet
/* 1987:2033 */           .getString("DEALER_PINCODE"));
/* 1988:     */         
/* 1989:2035 */         this.dealerVO.setPeimaryMailId(this.resultSet
/* 1990:2036 */           .getString("DEALER_PRIMARY_MAIL_ID"));
/* 1991:     */         
/* 1992:     */ 
/* 1993:2039 */         this.dealerVO.setAlternativeMail(this.resultSet
/* 1994:2040 */           .getString("DEALER_ALTERNATE_MAIL_ID"));
/* 1995:2041 */         this.dealerVO.setCreationDate(this.resultSet
/* 1996:2042 */           .getString("DEALER_CREATION_DATE"));
/* 1997:2043 */         this.dealerVO.setWorkLocation(this.resultSet
/* 1998:2044 */           .getString("DEALER_WORK_LOCATION"));
/* 1999:2045 */         this.dealerVO.setCreatedBy(this.resultSet
/* 2000:2046 */           .getString("DEALER_CREATED_BY"));
/* 2001:2047 */         dealerDetailList.add(this.dealerVO);
/* 2002:     */       }
/* 2003:     */     }
/* 2004:     */     catch (SQLException sqlExp)
/* 2005:     */     {
/* 2006:2051 */       sqlExp.printStackTrace();
/* 2007:2052 */       logger.error(
/* 2008:2053 */         DealerDaoImpl.class + 
/* 2009:2054 */         "Error: Occur in Query While Fetching the dealer Details for advance search from Database.", 
/* 2010:2055 */         sqlExp);
/* 2011:     */     }
/* 2012:     */     catch (Exception exception)
/* 2013:     */     {
/* 2014:2057 */       exception.printStackTrace();
/* 2015:2058 */       logger.error(
/* 2016:2059 */         DealerDaoImpl.class + 
/* 2017:2060 */         "Error: Occur in Query While Closing Connection After Fetching the dealer Details for advance search from Database.", 
/* 2018:2061 */         exception);
/* 2019:     */     }
/* 2020:     */     finally
/* 2021:     */     {
/* 2022:2063 */       JdbcHelper.closeResultSet(this.resultSet);
/* 2023:2064 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/* 2024:2065 */       JdbcHelper.closeConnection(this.connection);
/* 2025:     */     }
/* 2026:2067 */     return dealerDetailList;
/* 2027:     */   }
/* 2028:     */   
/* 2029:     */   public List<DealerVO> retriveDealerTransactionForAdvanceSearch(int searchId, String searchValue)
/* 2030:     */     throws RecordNotFoundException
/* 2031:     */   {
/* 2032:2076 */     List<DealerVO> dealerTransactionDetailList = new ArrayList();
/* 2033:     */     try
/* 2034:     */     {
/* 2035:2080 */       this.connection = getConnection();
/* 2036:     */       
/* 2037:2082 */       this.preparedStatement = this.connection
/* 2038:2083 */         .prepareStatement(
/* 2039:2084 */         QueryBuilder.DealerTransactionAdvanaceSearchForAdmin(searchId, searchValue));
/* 2040:     */       
/* 2041:     */ 
/* 2042:2087 */       this.resultSet = this.preparedStatement.executeQuery();
/* 2043:2089 */       while (this.resultSet.next())
/* 2044:     */       {
/* 2045:2090 */         this.dealerVO = new DealerVO();
/* 2046:2091 */         this.dealerVO.setTransactionId(this.resultSet.getInt("DEALER_TRANS_ID"));
/* 2047:     */         
/* 2048:     */ 
/* 2049:     */ 
/* 2050:     */ 
/* 2051:     */ 
/* 2052:2097 */         this.dealerVO.setDescription(this.resultSet
/* 2053:2098 */           .getString("DEALER_TRANS_DISCRIPTION"));
/* 2054:     */         
/* 2055:2100 */         this.dealerVO.setTotal(this.resultSet
/* 2056:2101 */           .getFloat("DEALER_TRANS_TOTAL"));
/* 2057:     */         
/* 2058:2103 */         this.dealerVO.setPaid(this.resultSet
/* 2059:2104 */           .getFloat("DEALER_TRANS_PAID"));
/* 2060:     */         
/* 2061:     */ 
/* 2062:2107 */         this.dealerVO.setDue(this.resultSet
/* 2063:2108 */           .getFloat("DEALER_TRANS_DUE"));
/* 2064:     */         
/* 2065:2110 */         this.dealerVO.setTotalPaid(this.resultSet
/* 2066:2111 */           .getFloat("DEALER_TRANS_TOTAL_PAID"));
/* 2067:     */         
/* 2068:2113 */         this.dealerVO.setTotalDue(this.resultSet
/* 2069:2114 */           .getFloat("DEALER_TRANS_TOTAL_DUE"));
/* 2070:     */         
/* 2071:2116 */         this.dealerVO.setTransactionDate(this.resultSet
/* 2072:2117 */           .getString("DEALER_TRANS_DATE"));
/* 2073:     */         
/* 2074:2119 */         this.dealerVO.setRetailerId(this.resultSet
/* 2075:2120 */           .getInt("DEALER_ID_REF"));
/* 2076:     */         
/* 2077:2122 */         this.dealerVO.setFullName(this.nameHelper.getDealerNameById(this.resultSet.getInt("DEALER_ID_REF")));
/* 2078:     */         
/* 2079:2124 */         this.dealerVO.setTransactionBillNo(this.resultSet
/* 2080:2125 */           .getString("DEALER_TRANS_BILL_NO"));
/* 2081:     */         
/* 2082:     */ 
/* 2083:2128 */         this.dealerVO.setPaymentMode(this.nameHelper.getPaymentModeById(this.resultSet.getInt("DEALER_TANS_PAYMENT_MODE")));
/* 2084:     */         
/* 2085:2130 */         dealerTransactionDetailList.add(this.dealerVO);
/* 2086:     */       }
/* 2087:     */     }
/* 2088:     */     catch (SQLException sqlExp)
/* 2089:     */     {
/* 2090:2134 */       sqlExp.printStackTrace();
/* 2091:2135 */       logger.error(
/* 2092:2136 */         DealerDaoImpl.class + 
/* 2093:2137 */         "Error: Occur in Query While Fetching the dealer transaction Details for advance search from Database.", 
/* 2094:2138 */         sqlExp);
/* 2095:     */     }
/* 2096:     */     catch (Exception exception)
/* 2097:     */     {
/* 2098:2140 */       exception.printStackTrace();
/* 2099:2141 */       logger.error(
/* 2100:2142 */         DealerDaoImpl.class + 
/* 2101:2143 */         "Error: Occur in Query While Closing Connection After Fetching the dealer transaction Details for advance search from Database.", 
/* 2102:2144 */         exception);
/* 2103:     */     }
/* 2104:     */     finally
/* 2105:     */     {
/* 2106:2146 */       JdbcHelper.closeResultSet(this.resultSet);
/* 2107:2147 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/* 2108:2148 */       JdbcHelper.closeConnection(this.connection);
/* 2109:     */     }
/* 2110:2150 */     return dealerTransactionDetailList;
/* 2111:     */   }
/* 2112:     */   
/* 2113:     */   public int getDealerLastRecord()
/* 2114:     */     throws RecordNotFoundException
/* 2115:     */   {
/* 2116:2158 */     int temp = 0;
/* 2117:     */     try
/* 2118:     */     {
/* 2119:2160 */       this.connection = getConnection();
/* 2120:2161 */       this.preparedStatement = this.connection
/* 2121:2162 */         .prepareStatement("SELECT  DEALER_ID FROM TAB_DEALER_DETAIL WHERE DEALER_STATUS='ACTIVE'  GROUP BY DEALER_ID DESC LIMIT 1");
/* 2122:2163 */       this.resultSet = this.preparedStatement.executeQuery();
/* 2123:2164 */       if (this.resultSet != null) {
/* 2124:2165 */         while (this.resultSet.next()) {
/* 2125:2167 */           temp = this.resultSet.getInt("DEALER_ID");
/* 2126:     */         }
/* 2127:     */       }
/* 2128:     */     }
/* 2129:     */     catch (SQLException sqlException)
/* 2130:     */     {
/* 2131:2172 */       sqlException.printStackTrace();
/* 2132:2173 */       logger.error(
/* 2133:2174 */         DealerDaoImpl.class + 
/* 2134:2175 */         ": Error:- Error: Occur in Query While counting the Dealer details recods from Database", 
/* 2135:2176 */         sqlException);
/* 2136:     */     }
/* 2137:     */     catch (Exception exception)
/* 2138:     */     {
/* 2139:2179 */       exception.printStackTrace();
/* 2140:2180 */       logger.error(
/* 2141:2181 */         DealerDaoImpl.class + 
/* 2142:2182 */         ": Error:- While closing the Connection after counting the Dealer details recods from Database", 
/* 2143:2183 */         exception);
/* 2144:     */     }
/* 2145:     */     finally
/* 2146:     */     {
/* 2147:2185 */       JdbcHelper.closeResultSet(this.resultSet);
/* 2148:2186 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/* 2149:2187 */       JdbcHelper.closeConnection(this.connection);
/* 2150:     */     }
/* 2151:2189 */     return temp;
/* 2152:     */   }
/* 2153:     */   
/* 2154:     */   public Dealer getDealerDetails(int dealerId)
/* 2155:     */     throws RecordNotFoundException
/* 2156:     */   {
/* 2157:2197 */     Dealer dealer = new Dealer();
/* 2158:     */     try
/* 2159:     */     {
/* 2160:2201 */       this.connection = getConnection();
/* 2161:2202 */       this.preparedStatement = this.connection
/* 2162:2203 */         .prepareStatement("SELECT * FROM TAB_DEALER_DETAIL WHERE DEALER_STATUS='ACTIVE' AND DEALER_ID=?");
/* 2163:2204 */       this.preparedStatement.setInt(1, dealerId);
/* 2164:2205 */       this.resultSet = this.preparedStatement.executeQuery();
/* 2165:2206 */       System.out.println("----------hye ----------------%%" + dealerId);
/* 2166:2207 */       if (this.resultSet != null) {
/* 2167:2208 */         while (this.resultSet.next())
/* 2168:     */         {
/* 2169:2210 */           System.out.println("----------hye ----------------" + this.resultSet.getInt("DEALER_ID") + "****");
/* 2170:     */           
/* 2171:2212 */           dealer.setDealerId(this.resultSet.getInt("DEALER_ID"));
/* 2172:     */           
/* 2173:     */ 
/* 2174:     */ 
/* 2175:2216 */           dealer.setFullName(this.resultSet.getString("DEALER_FULL_NAME"));
/* 2176:     */           
/* 2177:2218 */           dealer.setDob(this.resultSet
/* 2178:2219 */             .getString("DEALER_DATE_OF_BIRTH"));
/* 2179:     */           
/* 2180:2221 */           dealer.setAddress1(this.resultSet
/* 2181:2222 */             .getString("DEALER_ADDRESS_LINE_1"));
/* 2182:     */           
/* 2183:2224 */           dealer.setAddress2(this.resultSet
/* 2184:2225 */             .getString("DEALER_ADDRESS_LINE_2"));
/* 2185:     */           
/* 2186:     */ 
/* 2187:2228 */           dealer.setCity(this.nameHelper.getCityNameByCityId(this.resultSet.getInt("DEALER_CITY")));
/* 2188:     */           
/* 2189:2230 */           dealer.setState(this.nameHelper.getStateNameByStateId(this.resultSet.getInt("DEALER_STATE")));
/* 2190:     */           
/* 2191:2232 */           dealer.setPhoneNo(this.resultSet
/* 2192:2233 */             .getString("DEALER_PHONE_NO"));
/* 2193:     */           
/* 2194:2235 */           dealer.setMobileNo(this.resultSet
/* 2195:2236 */             .getString("DEALER_MOBILE_NO"));
/* 2196:     */           
/* 2197:2238 */           dealer.setPinCode(this.resultSet
/* 2198:2239 */             .getString("DEALER_PINCODE"));
/* 2199:     */           
/* 2200:2241 */           dealer.setPeimaryMailId(this.resultSet
/* 2201:2242 */             .getString("DEALER_PRIMARY_MAIL_ID"));
/* 2202:     */           
/* 2203:     */ 
/* 2204:2245 */           dealer.setAlternativeMail(this.resultSet
/* 2205:2246 */             .getString("DEALER_ALTERNATE_MAIL_ID"));
/* 2206:2247 */           dealer.setCreationDate(this.resultSet
/* 2207:2248 */             .getString("DEALER_CREATION_DATE"));
/* 2208:2249 */           dealer.setWorkLocation(this.resultSet
/* 2209:2250 */             .getString("DEALER_WORK_LOCATION"));
/* 2210:2251 */           dealer.setCreatedBy(this.resultSet
/* 2211:2252 */             .getString("DEALER_CREATED_BY"));
/* 2212:2253 */           System.out.println("u got the data ***********************************");
/* 2213:     */         }
/* 2214:     */       }
/* 2215:     */     }
/* 2216:     */     catch (SQLException sqlExp)
/* 2217:     */     {
/* 2218:2262 */       sqlExp.printStackTrace();
/* 2219:2263 */       logger.error(
/* 2220:2264 */         DealerDaoImpl.class + 
/* 2221:2265 */         "Error: Occur in Query While Fetching the specific dealer Details from Database.", 
/* 2222:2266 */         sqlExp);
/* 2223:     */     }
/* 2224:     */     catch (Exception exception)
/* 2225:     */     {
/* 2226:2268 */       exception.printStackTrace();
/* 2227:2269 */       logger.error(
/* 2228:2270 */         DealerDaoImpl.class + 
/* 2229:2271 */         "Error: Occur in Query While Closing Connection After Fetching the specific dealer Details from Database.", 
/* 2230:2272 */         exception);
/* 2231:     */     }
/* 2232:     */     finally
/* 2233:     */     {
/* 2234:2274 */       JdbcHelper.closeResultSet(this.resultSet);
/* 2235:2275 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/* 2236:2276 */       JdbcHelper.closeConnection(this.connection);
/* 2237:     */     }
/* 2238:2280 */     return dealer;
/* 2239:     */   }
/* 2240:     */   
/* 2241:     */   public int getDealerTransactionLastRecord()
/* 2242:     */     throws RecordNotFoundException
/* 2243:     */   {
/* 2244:2288 */     int temp = 0;
/* 2245:     */     try
/* 2246:     */     {
/* 2247:2290 */       this.connection = getConnection();
/* 2248:     */       
/* 2249:2292 */       this.preparedStatement = this.connection
/* 2250:2293 */         .prepareStatement("SELECT DEALER_TRANS_ID FROM TAB_DEALER_OWNER_TRANSACTION ORDER BY DEALER_TRANS_ID DESC LIMIT 1");
/* 2251:     */       
/* 2252:     */ 
/* 2253:2296 */       this.resultSet = this.preparedStatement.executeQuery();
/* 2254:2297 */       if (this.resultSet != null) {
/* 2255:2298 */         while (this.resultSet.next()) {
/* 2256:2300 */           temp = this.resultSet.getInt("DEALER_TRANS_ID");
/* 2257:     */         }
/* 2258:     */       }
/* 2259:     */     }
/* 2260:     */     catch (SQLException sqlException)
/* 2261:     */     {
/* 2262:2305 */       sqlException.printStackTrace();
/* 2263:2306 */       logger.error(
/* 2264:2307 */         DealerDaoImpl.class + 
/* 2265:2308 */         ": Error:- Error: Occur in Query While counting the Dealer transaction recods from Database", 
/* 2266:2309 */         sqlException);
/* 2267:     */     }
/* 2268:     */     catch (Exception exception)
/* 2269:     */     {
/* 2270:2312 */       exception.printStackTrace();
/* 2271:2313 */       logger.error(
/* 2272:2314 */         DealerDaoImpl.class + 
/* 2273:2315 */         ": Error:- While closing the Connection after counting the Dealer transaction recods from Database", 
/* 2274:2316 */         exception);
/* 2275:     */     }
/* 2276:     */     finally
/* 2277:     */     {
/* 2278:2318 */       JdbcHelper.closeResultSet(this.resultSet);
/* 2279:2319 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/* 2280:2320 */       JdbcHelper.closeConnection(this.connection);
/* 2281:     */     }
/* 2282:2322 */     return temp;
/* 2283:     */   }
/* 2284:     */   
/* 2285:     */   public Dealer getDealerTransaction(int transId)
/* 2286:     */     throws RecordNotFoundException
/* 2287:     */   {
/* 2288:2331 */     Dealer dealer = new Dealer();
/* 2289:2332 */     PreparedStatement preparedStatements = null;
/* 2290:     */     try
/* 2291:     */     {
/* 2292:2334 */       this.connection = getConnection();
/* 2293:     */       
/* 2294:2336 */       preparedStatements = this.connection
/* 2295:2337 */         .prepareStatement("SELECT * FROM TAB_DEALER_OWNER_TRANSACTION WHERE DEALER_TRANS_ID=?");
/* 2296:2338 */       preparedStatements.setInt(1, transId);
/* 2297:     */       
/* 2298:     */ 
/* 2299:2341 */       this.resultSet = preparedStatements.executeQuery();
/* 2300:2342 */       System.out.println("----------hye ----------------");
/* 2301:2343 */       if (this.resultSet != null) {
/* 2302:2344 */         while (this.resultSet.next())
/* 2303:     */         {
/* 2304:2346 */           System.out.println("----------hye ----------------");
/* 2305:     */           
/* 2306:2348 */           dealer.setTransactionId(this.resultSet.getInt("DEALER_TRANS_ID"));
/* 2307:2349 */           System.out.println("________________" + this.resultSet.getInt("DEALER_TRANS_ID"));
/* 2308:2350 */           dealer.setDescription(this.resultSet
/* 2309:2351 */             .getString("DEALER_TRANS_DISCRIPTION"));
/* 2310:     */           
/* 2311:2353 */           dealer.setTotal(this.resultSet
/* 2312:2354 */             .getFloat("DEALER_TRANS_TOTAL"));
/* 2313:     */           
/* 2314:2356 */           dealer.setPaid(this.resultSet
/* 2315:2357 */             .getFloat("DEALER_TRANS_PAID"));
/* 2316:     */           
/* 2317:2359 */           dealer.setDue(this.resultSet
/* 2318:2360 */             .getFloat("DEALER_TRANS_DUE"));
/* 2319:     */           
/* 2320:2362 */           dealer.setTotalPaid(this.resultSet
/* 2321:2363 */             .getFloat("DEALER_TRANS_TOTAL_PAID"));
/* 2322:     */           
/* 2323:2365 */           dealer.setTotalDue(this.resultSet.getFloat("DEALER_TRANS_TOTAL_DUE"));
/* 2324:     */           
/* 2325:     */ 
/* 2326:2368 */           dealer.setRetailerId(this.resultSet.getInt("DEALER_ID_REF"));
/* 2327:2369 */           dealer.setPaymentMode(this.nameHelper.getPaymentModeById(this.resultSet.getInt("DEALER_TANS_PAYMENT_MODE")));
/* 2328:2370 */           System.out.println(this.resultSet.getString("DEALER_TANS_PAYMENT_MODE") + this.resultSet.getString("DEALER_TANS_PAYMENT_MODE") + "hhhhhhhhh");
/* 2329:     */         }
/* 2330:     */       }
/* 2331:     */     }
/* 2332:     */     catch (SQLException sqlExp)
/* 2333:     */     {
/* 2334:2383 */       sqlExp.printStackTrace();
/* 2335:2384 */       logger.error(
/* 2336:2385 */         DealerDaoImpl.class + 
/* 2337:2386 */         "Error: Occur in Query While Fetching the specific dealer transaction Details from Database For Update.", 
/* 2338:2387 */         sqlExp);
/* 2339:     */     }
/* 2340:     */     catch (Exception exception)
/* 2341:     */     {
/* 2342:2389 */       exception.printStackTrace();
/* 2343:2390 */       logger.error(
/* 2344:2391 */         DealerDaoImpl.class + 
/* 2345:2392 */         "Error: Occur in Query While Closing Connection After Fetching the specific dealer transaction Details from Database For Update.", 
/* 2346:2393 */         exception);
/* 2347:     */     }
/* 2348:     */     finally
/* 2349:     */     {
/* 2350:2395 */       JdbcHelper.closeResultSet(this.resultSet);
/* 2351:2396 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/* 2352:2397 */       JdbcHelper.closeConnection(this.connection);
/* 2353:     */     }
/* 2354:2401 */     return dealer;
/* 2355:     */   }
/* 2356:     */   
/* 2357:     */   public Dealer retrieveDealerTransactionByIdForPayDue(int transId)
/* 2358:     */     throws RecordNotFoundException
/* 2359:     */   {
/* 2360:2410 */     Dealer dealer = new Dealer();
/* 2361:2411 */     Connection connections = null;
/* 2362:2412 */     ResultSet resultSets = null;
/* 2363:2413 */     PreparedStatement preparedStatementss = null;
/* 2364:     */     try
/* 2365:     */     {
/* 2366:2415 */       connections = getConnection();
/* 2367:     */       
/* 2368:2417 */       preparedStatementss = connections
/* 2369:2418 */         .prepareStatement("SELECT * FROM TAB_DEALER_OWNER_TRANSACTION WHERE DEALER_TRANS_ID=?");
/* 2370:2419 */       preparedStatementss.setInt(1, transId);
/* 2371:     */       
/* 2372:     */ 
/* 2373:2422 */       System.out.println(transId + "vvvvvvvvvvvvvvvvvvvvv");
/* 2374:2423 */       resultSets = preparedStatementss.executeQuery();
/* 2375:2424 */       System.out.println("----------hye ----------------");
/* 2376:2425 */       if (resultSets != null) {
/* 2377:2426 */         while (resultSets.next())
/* 2378:     */         {
/* 2379:2428 */           System.out.println("----------hye gggggggggggggggggggg----------------");
/* 2380:2429 */           int dealerId = resultSets.getInt("DEALER_ID_REF");
/* 2381:2430 */           dealer.setTransactionId(resultSets.getInt("DEALER_TRANS_ID"));
/* 2382:2431 */           System.out.println("________________))((*hhhhh" + resultSets.getInt("DEALER_TRANS_ID"));
/* 2383:2432 */           dealer.setDescription(resultSets
/* 2384:2433 */             .getString("DEALER_TRANS_DISCRIPTION"));
/* 2385:     */           
/* 2386:2435 */           dealer.setTotal(resultSets
/* 2387:2436 */             .getFloat("DEALER_TRANS_TOTAL"));
/* 2388:     */           
/* 2389:2438 */           dealer.setPaid(resultSets
/* 2390:2439 */             .getFloat("DEALER_TRANS_PAID"));
/* 2391:     */           
/* 2392:2441 */           dealer.setDue(resultSets
/* 2393:2442 */             .getFloat("DEALER_TRANS_DUE"));
/* 2394:     */           
/* 2395:2444 */           dealer.setTotalPaid(resultSets
/* 2396:2445 */             .getFloat("DEALER_TRANS_TOTAL_PAID"));
/* 2397:     */           
/* 2398:2447 */           dealer.setTotalDue(resultSets.getFloat("DEALER_TRANS_TOTAL_DUE"));
/* 2399:     */           
/* 2400:2449 */           dealer.setTransactionBillNo(resultSets.getString("DEALER_TRANS_BILL_NO"));
/* 2401:     */           
/* 2402:2451 */           dealer.setPaymentMode(resultSets.getString("DEALER_TANS_PAYMENT_MODE"));
/* 2403:     */           
/* 2404:2453 */           System.out.println(resultSets.getString("DEALER_TANS_PAYMENT_MODE") + " " + resultSets.getString("DEALER_TRANS_DISCRIPTION"));
/* 2405:     */           
/* 2406:2455 */           dealer.setRetailerId(resultSets.getInt("DEALER_ID_REF"));
/* 2407:2456 */           dealer.setFullName(this.nameHelper.getDealerNameById(resultSets.getInt("DEALER_ID_REF")));
/* 2408:     */           
/* 2409:2458 */           dealer = getDealerDetailForPayDue(dealer, dealerId);
/* 2410:     */         }
/* 2411:     */       }
/* 2412:     */     }
/* 2413:     */     catch (SQLException sqlExp)
/* 2414:     */     {
/* 2415:2468 */       sqlExp.printStackTrace();
/* 2416:2469 */       logger.error(
/* 2417:2470 */         DealerDaoImpl.class + 
/* 2418:2471 */         "Error: Occur in Query While Fetching the specific dealer transaction Details from Database For Pay Due.", 
/* 2419:2472 */         sqlExp);
/* 2420:     */     }
/* 2421:     */     catch (Exception exception)
/* 2422:     */     {
/* 2423:2474 */       exception.printStackTrace();
/* 2424:2475 */       logger.error(
/* 2425:2476 */         DealerDaoImpl.class + 
/* 2426:2477 */         "Error: Occur in Query While Closing Connection After Fetching the specific dealer transaction Details from Database For Pay Due..", 
/* 2427:2478 */         exception);
/* 2428:     */     }
/* 2429:     */     finally
/* 2430:     */     {
/* 2431:2480 */       JdbcHelper.closeResultSet(resultSets);
/* 2432:2481 */       JdbcHelper.closePreparedStatement(preparedStatementss);
/* 2433:2482 */       JdbcHelper.closeConnection(connections);
/* 2434:     */     }
/* 2435:2486 */     return dealer;
/* 2436:     */   }
/* 2437:     */   
/* 2438:     */   public void addPayDue(DealerVO dealerVO, int transId)
/* 2439:     */     throws CreateFailedException
/* 2440:     */   {
/* 2441:     */     try
/* 2442:     */     {
/* 2443:2498 */       float t_paid = dealerVO.getTotalPaid() + dealerVO.getPayment();
/* 2444:2499 */       float t_due = dealerVO.getTotalDue() - dealerVO.getPayment();
/* 2445:     */       
/* 2446:     */ 
/* 2447:2502 */       String query = "INSERT INTO TAB_DEALER_OWNER_TRANSACTION (DEALER_TRANS_DISCRIPTION, DEALER_TRANS_DATE, DEALER_TRANS_PAID,DEALER_TRANS_TOTAL_PAID,DEALER_TRANS_TOTAL_DUE,DEALER_TANS_PAYMENT_MODE,DEALER_TRANS_BILL_NO, DEALER_ID_REF)VALUES(?,?,?,?,?,?,?,?)";
/* 2448:2503 */       this.connection = getConnection();
/* 2449:2504 */       System.out.println(t_paid + " " + t_due + "((dealerid" + dealerVO.getDealerId());
/* 2450:     */       
/* 2451:2506 */       this.preparedStatement = this.connection.prepareStatement(query);
/* 2452:     */       
/* 2453:2508 */       this.preparedStatement.setString(1, "ON_DUE_PAYMENT");
/* 2454:     */       
/* 2455:2510 */       this.preparedStatement.setString(2, DateTimeUtil.convertToDate(dealerVO.getTransactionDate()));
/* 2456:2511 */       this.preparedStatement.setFloat(3, dealerVO.getPayment());
/* 2457:2512 */       this.preparedStatement.setFloat(4, t_paid);
/* 2458:2513 */       this.preparedStatement.setFloat(5, t_due);
/* 2459:2514 */       this.preparedStatement.setString(6, dealerVO.getPaymentMode());
/* 2460:2515 */       this.preparedStatement.setString(7, dealerVO.getTransactionBillNo());
/* 2461:2516 */       this.preparedStatement.setInt(8, transId);
/* 2462:     */       
/* 2463:2518 */       System.out.println("data updated");
/* 2464:     */       
/* 2465:2520 */       this.preparedStatement.executeUpdate();
/* 2466:     */     }
/* 2467:     */     catch (SQLIntegrityConstraintViolationException expt)
/* 2468:     */     {
/* 2469:2524 */       expt.printStackTrace();
/* 2470:     */     }
/* 2471:     */     catch (SQLException exp)
/* 2472:     */     {
/* 2473:2526 */       exp.printStackTrace();
/* 2474:     */     }
/* 2475:     */     catch (Exception e)
/* 2476:     */     {
/* 2477:2529 */       e.printStackTrace();
/* 2478:     */     }
/* 2479:     */   }
/* 2480:     */   
/* 2481:     */   public Dealer getDealerDetailForPayDue(Dealer dealer, int dealerId)
/* 2482:     */   {
/* 2483:     */     try
/* 2484:     */     {
/* 2485:2535 */       System.out.println("hye bharti ur in view for pay method");
/* 2486:2536 */       this.connection = getConnection();
/* 2487:2537 */       this.preparedStatement = this.connection
/* 2488:2538 */         .prepareStatement("SELECT * FROM TAB_DEALER_DETAIL WHERE DEALER_STATUS='ACTIVE' AND DEALER_ID=?");
/* 2489:2539 */       this.preparedStatement.setInt(1, dealerId);
/* 2490:2540 */       this.resultSet = this.preparedStatement.executeQuery();
/* 2491:2541 */       System.out.println("----------hye ----------------%%" + dealerId);
/* 2492:2542 */       if (this.resultSet != null) {
/* 2493:2543 */         while (this.resultSet.next())
/* 2494:     */         {
/* 2495:2545 */           System.out.println("----------hye ----------------" + this.resultSet.getInt("DEALER_ID") + "****");
/* 2496:     */           
/* 2497:2547 */           dealer.setDealerId(this.resultSet.getInt("DEALER_ID"));
/* 2498:     */           
/* 2499:     */ 
/* 2500:     */ 
/* 2501:2551 */           dealer.setFullName(this.resultSet.getString("DEALER_FULL_NAME"));
/* 2502:     */           
/* 2503:2553 */           dealer.setDob(this.resultSet
/* 2504:2554 */             .getString("DEALER_DATE_OF_BIRTH"));
/* 2505:     */           
/* 2506:2556 */           dealer.setAddress1(this.resultSet
/* 2507:2557 */             .getString("DEALER_ADDRESS_LINE_1"));
/* 2508:     */           
/* 2509:2559 */           dealer.setAddress2(this.resultSet
/* 2510:2560 */             .getString("DEALER_ADDRESS_LINE_2"));
/* 2511:     */           
/* 2512:     */ 
/* 2513:2563 */           dealer.setCity(this.nameHelper.getCityNameByCityId(this.resultSet.getInt("DEALER_CITY")));
/* 2514:     */           
/* 2515:2565 */           dealer.setState(this.nameHelper.getStateNameByStateId(this.resultSet.getInt("DEALER_STATE")));
/* 2516:     */           
/* 2517:2567 */           dealer.setPhoneNo(this.resultSet
/* 2518:2568 */             .getString("DEALER_PHONE_NO"));
/* 2519:     */           
/* 2520:2570 */           dealer.setMobileNo(this.resultSet
/* 2521:2571 */             .getString("DEALER_MOBILE_NO"));
/* 2522:     */           
/* 2523:2573 */           dealer.setPinCode(this.resultSet
/* 2524:2574 */             .getString("DEALER_PINCODE"));
/* 2525:     */           
/* 2526:2576 */           dealer.setPeimaryMailId(this.resultSet
/* 2527:2577 */             .getString("DEALER_PRIMARY_MAIL_ID"));
/* 2528:     */           
/* 2529:     */ 
/* 2530:2580 */           dealer.setAlternativeMail(this.resultSet
/* 2531:2581 */             .getString("DEALER_ALTERNATE_MAIL_ID"));
/* 2532:2582 */           dealer.setCreationDate(this.resultSet
/* 2533:2583 */             .getString("DEALER_CREATION_DATE"));
/* 2534:2584 */           dealer.setWorkLocation(this.resultSet
/* 2535:2585 */             .getString("DEALER_WORK_LOCATION"));
/* 2536:2586 */           dealer.setCreatedBy(this.resultSet
/* 2537:2587 */             .getString("DEALER_CREATED_BY"));
/* 2538:2588 */           System.out.println("u got the data ***********************************");
/* 2539:     */         }
/* 2540:     */       }
/* 2541:     */     }
/* 2542:     */     catch (SQLException sqlExp)
/* 2543:     */     {
/* 2544:2597 */       sqlExp.printStackTrace();
/* 2545:2598 */       logger.error(
/* 2546:2599 */         DealerDaoImpl.class + 
/* 2547:2600 */         "Error: Occur in Query While Fetching the specific dealer Details from Database.", 
/* 2548:2601 */         sqlExp);
/* 2549:     */     }
/* 2550:     */     catch (Exception exception)
/* 2551:     */     {
/* 2552:2603 */       exception.printStackTrace();
/* 2553:2604 */       logger.error(
/* 2554:2605 */         DealerDaoImpl.class + 
/* 2555:2606 */         "Error: Occur in Query While Closing Connection After Fetching the specific dealer Details from Database.", 
/* 2556:2607 */         exception);
/* 2557:     */     }
/* 2558:     */     finally
/* 2559:     */     {
/* 2560:2609 */       JdbcHelper.closeResultSet(this.resultSet);
/* 2561:2610 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/* 2562:2611 */       JdbcHelper.closeConnection(this.connection);
/* 2563:     */     }
/* 2564:2615 */     return dealer;
/* 2565:     */   }
/* 2566:     */ }


/* Location:           C:\Users\bharti\Desktop\Chouksay\lost\dao\
 * Qualified Name:     com.bst.ckt.dao.DealerDaoImpl
 * JD-Core Version:    0.7.0.1
 */