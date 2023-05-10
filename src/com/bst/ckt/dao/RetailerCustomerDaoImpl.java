/*    1:     */ package com.bst.ckt.dao;
/*    2:     */ 
/*    3:     */ import com.bst.ckt.common.QueryBuilder;
/*    4:     */ import com.bst.ckt.dto.Retailer;
/*    5:     */ import com.bst.ckt.exception.CreateFailedException;
/*    6:     */ import com.bst.ckt.exception.DeleteFailedException;
/*    7:     */ import com.bst.ckt.exception.RecordNotFoundException;
/*    8:     */ import com.bst.ckt.exception.UpdateFailedException;
/*    9:     */ import com.bst.ckt.framework.db.JdbcDAOSupport;
/*   10:     */ import com.bst.ckt.framework.db.JdbcHelper;
/*   11:     */ import com.bst.ckt.framework.util.DateTimeUtil;
/*   12:     */ import com.bst.ckt.helper.NameHelper;
/*   13:     */ import com.bst.ckt.vo.RetailerCustomerVO;
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
/*   39:     */ public class RetailerCustomerDaoImpl
/*   40:     */   extends JdbcDAOSupport
/*   41:     */   implements RetailerCustomerDaoInf
/*   42:     */ {
/*   43:  53 */   private static final Logger logger = Logger.getLogger(RetailerCustomerDaoImpl.class);
/*   44:  55 */   PreparedStatement preparedStatement = null;
/*   45:  56 */   Connection connection = null;
/*   46:  57 */   ResultSet resultSet = null;
/*   47:  58 */   Image image = null;
/*   48:  59 */   RetailerCustomerVO retailerCustomerVO = null;
/*   49:  60 */   NameHelper nameHelper = new NameHelper();
/*   50:     */   
/*   51:     */   public void addRetailerDetails(RetailerCustomerVO retailerCustomerVO)
/*   52:     */     throws CreateFailedException
/*   53:     */   {
/*   54:     */     try
/*   55:     */     {
/*   56:  66 */       System.out.println("we  r in dao " + retailerCustomerVO.getFullName());
/*   57:  67 */       this.connection = getConnection();
/*   58:  68 */       String insert = "INSERT INTO TAB_REGULAR_CUSTOMER(REG_SALUTATION,REG_FULL_NAME,REG_DATE_OF_BIRTH,REG_ADDRESS_LINE_1,REG_ADDRESS_LINE_2,REG_CITY,REG_STATE,REG_PINCODE,REG_PRIMARY_MAIL_ID, REG_ALTERNATE_MAIL_ID,REG_PHONE_NO,REG_MOBILE_NO, REG_FAX_NO,REG_SOCIAL_IM_ID,REG_CREATION_DATE,REG_CREATED_BY,REG_WORK_LOCATION, REG_CONTACT_PERSON, REG_PHONE_NO2, REG_MOBILE_NO2, REG_FAX_ISD,REG_FAX_STD, REG_COUNTRY, REG_PHONE_ISD, REG_PHONE_STD, REG_PHONE_ISD2, REG_PHONE_STD2, REG_MOBILE_ISD1, REG_MOBILE_ISD2, REG_HOME_WEBSITE, REG_REFFERED_BY, REG_PROFILE_DISC, REG_CUSTOMER_STATUS)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
/*   59:     */       
/*   60:     */ 
/*   61:  71 */       this.preparedStatement = this.connection
/*   62:  72 */         .prepareStatement(insert);
/*   63:  73 */       this.preparedStatement.setString(1, retailerCustomerVO.getSalutation());
/*   64:  74 */       this.preparedStatement.setString(2, retailerCustomerVO.getFullName());
/*   65:  75 */       this.preparedStatement.setString(3, "2018-02-02");
/*   66:     */       
/*   67:  77 */       this.preparedStatement.setString(4, retailerCustomerVO.getAddress1());
/*   68:  78 */       this.preparedStatement.setString(5, retailerCustomerVO.getAddress2());
/*   69:  79 */       this.preparedStatement.setString(6, retailerCustomerVO.getCity());
/*   70:  80 */       this.preparedStatement.setString(7, retailerCustomerVO.getState());
/*   71:  81 */       this.preparedStatement.setString(8, retailerCustomerVO.getPinCode());
/*   72:  82 */       this.preparedStatement.setString(9, retailerCustomerVO.getPeimaryMailId());
/*   73:  83 */       this.preparedStatement.setString(10, retailerCustomerVO.getAlternativeMail());
/*   74:  84 */       this.preparedStatement.setString(11, retailerCustomerVO.getPhoneNo());
/*   75:  85 */       this.preparedStatement.setString(12, retailerCustomerVO.getMobileNo());
/*   76:  86 */       this.preparedStatement.setString(13, retailerCustomerVO.getFaxNo());
/*   77:  87 */       this.preparedStatement.setString(14, retailerCustomerVO.getSocialMailId());
/*   78:  88 */       this.preparedStatement.setString(15, DateTimeUtil.getCurrentDate());
/*   79:  89 */       this.preparedStatement.setInt(16, 1);
/*   80:     */       
/*   81:  91 */       this.preparedStatement.setString(17, retailerCustomerVO.getWorkLocation());
/*   82:  92 */       this.preparedStatement.setString(18, retailerCustomerVO.getContactPerson());
/*   83:  93 */       this.preparedStatement.setString(19, retailerCustomerVO.getPhoneNo2());
/*   84:  94 */       this.preparedStatement.setString(20, retailerCustomerVO.getMobileNo2());
/*   85:  95 */       this.preparedStatement.setString(21, retailerCustomerVO.getHomeContFaxNumIsd());
/*   86:  96 */       this.preparedStatement.setString(22, retailerCustomerVO.getHomeContFaxnumStd());
/*   87:  97 */       this.preparedStatement.setString(23, retailerCustomerVO.getCountry());
/*   88:  98 */       this.preparedStatement.setString(24, retailerCustomerVO.getPhoneNumberIsd());
/*   89:  99 */       this.preparedStatement.setString(25, retailerCustomerVO.getPhoneNumberStd());
/*   90: 100 */       this.preparedStatement.setString(26, retailerCustomerVO.getPhoneNumberIsd2());
/*   91: 101 */       this.preparedStatement.setString(27, retailerCustomerVO.getPhoneNumberStd2());
/*   92: 102 */       this.preparedStatement.setString(28, retailerCustomerVO.getMobileNum1Isd());
/*   93: 103 */       this.preparedStatement.setString(29, retailerCustomerVO.getMobileNum1Isd2());
/*   94: 104 */       this.preparedStatement.setString(30, retailerCustomerVO.getHomewebsite());
/*   95: 105 */       this.preparedStatement.setString(31, retailerCustomerVO.getRefferedBy());
/*   96: 106 */       this.preparedStatement.setString(32, retailerCustomerVO.getProfileDescription());
/*   97: 107 */       this.preparedStatement.setString(33, "ACTIVE");
/*   98:     */       
/*   99:     */ 
/*  100: 110 */       this.preparedStatement.executeUpdate();
/*  101:     */     }
/*  102:     */     catch (SQLException sqlException)
/*  103:     */     {
/*  104: 113 */       sqlException.printStackTrace();
/*  105: 114 */       logger.error(
/*  106: 115 */         RetailerCustomerDaoImpl.class + 
/*  107: 116 */         ": Error:- Error: Occur in Query While inserting the Retailer details into Database", 
/*  108: 117 */         sqlException);
/*  109:     */     }
/*  110:     */     catch (Exception exception)
/*  111:     */     {
/*  112: 120 */       exception.printStackTrace();
/*  113: 121 */       logger.error(
/*  114: 122 */         RetailerCustomerDaoImpl.class + 
/*  115: 123 */         ": Error:- While closing the Connection after inserting the retailer details into Database", 
/*  116: 124 */         exception);
/*  117:     */     }
/*  118:     */     finally
/*  119:     */     {
/*  120: 127 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/*  121: 128 */       JdbcHelper.closeConnection(this.connection);
/*  122:     */     }
/*  123:     */   }
/*  124:     */   
/*  125:     */   public List<RetailerCustomerVO> retriveRetailerDetailsGrid(RetailerCustomerVO retailerCustomerVO)
/*  126:     */     throws RecordNotFoundException
/*  127:     */   {
/*  128: 135 */     List<RetailerCustomerVO> retailerDetailList = new ArrayList();
/*  129:     */     try
/*  130:     */     {
/*  131: 139 */       this.connection = getConnection();
/*  132: 140 */       this.preparedStatement = this.connection
/*  133: 141 */         .prepareStatement("SELECT * FROM TAB_REGULAR_CUSTOMER WHERE REG_CUSTOMER_STATUS='ACTIVE' ");
/*  134: 142 */       this.resultSet = this.preparedStatement.executeQuery();
/*  135: 146 */       while (this.resultSet.next())
/*  136:     */       {
/*  137: 147 */         retailerCustomerVO = new RetailerCustomerVO();
/*  138: 148 */         retailerCustomerVO.setCustomerId(this.resultSet.getInt("REG_CUSTOMER_ID"));
/*  139:     */         
/*  140:     */ 
/*  141:     */ 
/*  142: 152 */         retailerCustomerVO.setFullName(this.resultSet.getString("REG_FULL_NAME"));
/*  143:     */         
/*  144: 154 */         retailerCustomerVO.setDob(this.resultSet
/*  145: 155 */           .getString("REG_DATE_OF_BIRTH"));
/*  146:     */         
/*  147: 157 */         retailerCustomerVO.setAddress1(this.resultSet
/*  148: 158 */           .getString("REG_ADDRESS_LINE_1"));
/*  149:     */         
/*  150: 160 */         retailerCustomerVO.setAddress2(this.resultSet
/*  151: 161 */           .getString("REG_ADDRESS_LINE_2"));
/*  152:     */         
/*  153:     */ 
/*  154: 164 */         retailerCustomerVO.setCity(this.nameHelper.getCityNameByCityId(this.resultSet.getInt("REG_CITY")));
/*  155:     */         
/*  156: 166 */         retailerCustomerVO.setState(this.nameHelper.getStateNameByStateId(this.resultSet.getInt("REG_STATE")));
/*  157:     */         
/*  158: 168 */         retailerCustomerVO.setPhoneNo(this.resultSet
/*  159: 169 */           .getString("REG_PHONE_NO"));
/*  160:     */         
/*  161: 171 */         retailerCustomerVO.setMobileNo(this.resultSet
/*  162: 172 */           .getString("REG_MOBILE_NO"));
/*  163:     */         
/*  164: 174 */         retailerCustomerVO.setPinCode(this.resultSet
/*  165: 175 */           .getString("REG_PINCODE"));
/*  166:     */         
/*  167: 177 */         retailerCustomerVO.setPeimaryMailId(this.resultSet
/*  168: 178 */           .getString("REG_PRIMARY_MAIL_ID"));
/*  169:     */         
/*  170:     */ 
/*  171: 181 */         retailerCustomerVO.setAlternativeMail(this.resultSet
/*  172: 182 */           .getString("REG_ALTERNATE_MAIL_ID"));
/*  173: 183 */         retailerCustomerVO.setCreationDate(this.resultSet
/*  174: 184 */           .getString("REG_CREATION_DATE"));
/*  175: 185 */         retailerCustomerVO.setWorkLocation(this.resultSet
/*  176: 186 */           .getString("REG_WORK_LOCATION"));
/*  177: 187 */         retailerCustomerVO.setCreatedBy(this.resultSet
/*  178: 188 */           .getString("REG_CREATED_BY"));
/*  179: 189 */         retailerDetailList.add(retailerCustomerVO);
/*  180:     */       }
/*  181:     */     }
/*  182:     */     catch (SQLException sqlExp)
/*  183:     */     {
/*  184: 193 */       sqlExp.printStackTrace();
/*  185: 194 */       logger.error(
/*  186: 195 */         RetailerCustomerDaoImpl.class + 
/*  187: 196 */         "Error: Occur in Query While Fetching the retailer Details into Grid from Database.", 
/*  188: 197 */         sqlExp);
/*  189:     */     }
/*  190:     */     catch (Exception exception)
/*  191:     */     {
/*  192: 199 */       exception.printStackTrace();
/*  193: 200 */       logger.error(
/*  194: 201 */         RetailerCustomerDaoImpl.class + 
/*  195: 202 */         "Error: Occur in Query While Closing Connection After Fetching the retailer Details into Grid from Database.", 
/*  196: 203 */         exception);
/*  197:     */     }
/*  198:     */     finally
/*  199:     */     {
/*  200: 205 */       JdbcHelper.closeResultSet(this.resultSet);
/*  201: 206 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/*  202: 207 */       JdbcHelper.closeConnection(this.connection);
/*  203:     */     }
/*  204: 209 */     return retailerDetailList;
/*  205:     */   }
/*  206:     */   
/*  207:     */   public Retailer retriveSpecificRetailerDetail(int retailerId)
/*  208:     */     throws RecordNotFoundException
/*  209:     */   {
/*  210: 214 */     Retailer retailer = new Retailer();
/*  211:     */     try
/*  212:     */     {
/*  213: 217 */       System.out.println("hye bharti ur in view method");
/*  214: 218 */       this.connection = getConnection();
/*  215: 219 */       this.preparedStatement = this.connection
/*  216: 220 */         .prepareStatement("SELECT * FROM TAB_REGULAR_CUSTOMER WHERE REG_CUSTOMER_ID=?");
/*  217: 221 */       this.preparedStatement.setInt(1, retailerId);
/*  218: 222 */       this.resultSet = this.preparedStatement.executeQuery();
/*  219: 223 */       System.out.println("----------hye ----------------%%" + retailerId);
/*  220: 224 */       if (this.resultSet != null) {
/*  221: 225 */         while (this.resultSet.next())
/*  222:     */         {
/*  223: 227 */           System.out.println("----------hye ----------------" + this.resultSet.getInt("REG_CUSTOMER_ID") + "****");
/*  224:     */           
/*  225: 229 */           retailer.setCustomerId(this.resultSet.getInt("REG_CUSTOMER_ID"));
/*  226:     */           
/*  227:     */ 
/*  228:     */ 
/*  229: 233 */           retailer.setFullName(this.resultSet.getString("REG_FULL_NAME"));
/*  230:     */           
/*  231: 235 */           retailer.setDob(this.resultSet
/*  232: 236 */             .getString("REG_DATE_OF_BIRTH"));
/*  233:     */           
/*  234: 238 */           retailer.setAddress1(this.resultSet
/*  235: 239 */             .getString("REG_ADDRESS_LINE_1"));
/*  236:     */           
/*  237: 241 */           retailer.setAddress2(this.resultSet
/*  238: 242 */             .getString("REG_ADDRESS_LINE_2"));
/*  239:     */           
/*  240:     */ 
/*  241: 245 */           retailer.setCity(this.nameHelper.getCityNameByCityId(this.resultSet.getInt("REG_CITY")));
/*  242:     */           
/*  243: 247 */           retailer.setState(this.nameHelper.getStateNameByStateId(this.resultSet.getInt("REG_STATE")));
/*  244:     */           
/*  245: 249 */           retailer.setPhoneNo(this.resultSet
/*  246: 250 */             .getString("REG_PHONE_NO"));
/*  247:     */           
/*  248: 252 */           retailer.setMobileNo(this.resultSet
/*  249: 253 */             .getString("REG_MOBILE_NO"));
/*  250:     */           
/*  251: 255 */           retailer.setPinCode(this.resultSet
/*  252: 256 */             .getString("REG_PINCODE"));
/*  253:     */           
/*  254: 258 */           retailer.setPeimaryMailId(this.resultSet
/*  255: 259 */             .getString("REG_PRIMARY_MAIL_ID"));
/*  256:     */           
/*  257:     */ 
/*  258: 262 */           retailer.setAlternativeMail(this.resultSet
/*  259: 263 */             .getString("REG_ALTERNATE_MAIL_ID"));
/*  260: 264 */           retailer.setCreationDate(this.resultSet
/*  261: 265 */             .getString("REG_CREATION_DATE"));
/*  262: 266 */           retailer.setWorkLocation(this.resultSet
/*  263: 267 */             .getString("REG_WORK_LOCATION"));
/*  264: 268 */           retailer.setCreatedBy(this.resultSet
/*  265: 269 */             .getString("REG_CREATED_BY"));
/*  266: 270 */           System.out.println("u got the data ***********************************");
/*  267:     */         }
/*  268:     */       }
/*  269:     */     }
/*  270:     */     catch (SQLException sqlExp)
/*  271:     */     {
/*  272: 279 */       sqlExp.printStackTrace();
/*  273: 280 */       logger.error(
/*  274: 281 */         RetailerCustomerDaoImpl.class + 
/*  275: 282 */         "Error: Occur in Query While Fetching the specific consumer Details from Database.", 
/*  276: 283 */         sqlExp);
/*  277:     */     }
/*  278:     */     catch (Exception exception)
/*  279:     */     {
/*  280: 285 */       exception.printStackTrace();
/*  281: 286 */       logger.error(
/*  282: 287 */         RetailerCustomerDaoImpl.class + 
/*  283: 288 */         "Error: Occur in Query While Closing Connection After Fetching the specific consumer Details from Database.", 
/*  284: 289 */         exception);
/*  285:     */     }
/*  286:     */     finally
/*  287:     */     {
/*  288: 291 */       JdbcHelper.closeResultSet(this.resultSet);
/*  289: 292 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/*  290: 293 */       JdbcHelper.closeConnection(this.connection);
/*  291:     */     }
/*  292: 297 */     return retailer;
/*  293:     */   }
/*  294:     */   
/*  295:     */   public List<RetailerCustomerVO> retriveRetailerTransactionDetailsGrid(RetailerCustomerVO retailerCustomerVO)
/*  296:     */     throws RecordNotFoundException
/*  297:     */   {
/*  298: 303 */     List<RetailerCustomerVO> retailerTransactionDetailList = new ArrayList();
/*  299:     */     try
/*  300:     */     {
/*  301: 307 */       this.connection = getConnection();
/*  302:     */       
/*  303: 309 */       this.preparedStatement = this.connection
/*  304: 310 */         .prepareStatement("SELECT * FROM TAB_OWNER_CUSTOMER_TRANSACTION WHERE CUSTOMER_TYPE='Retailer' ORDER BY CUSTOMER_TRANS_ID DESC");
/*  305:     */       
/*  306:     */ 
/*  307: 313 */       this.resultSet = this.preparedStatement.executeQuery();
/*  308: 317 */       while (this.resultSet.next())
/*  309:     */       {
/*  310: 318 */         retailerCustomerVO = new RetailerCustomerVO();
/*  311: 319 */         retailerCustomerVO.setTransactionId(this.resultSet.getInt("CUSTOMER_TRANS_ID"));
/*  312:     */         
/*  313:     */ 
/*  314:     */ 
/*  315:     */ 
/*  316:     */ 
/*  317: 325 */         retailerCustomerVO.setDescription(this.resultSet
/*  318: 326 */           .getString("CUSTOMER_TRANS_DISCRIPTION"));
/*  319:     */         
/*  320: 328 */         retailerCustomerVO.setTotal(this.resultSet
/*  321: 329 */           .getFloat("CUSTOMER_TRANS_TOTAL"));
/*  322:     */         
/*  323: 331 */         retailerCustomerVO.setPaid(this.resultSet
/*  324: 332 */           .getFloat("CUSTOMER_TRANS_PAID"));
/*  325:     */         
/*  326:     */ 
/*  327: 335 */         retailerCustomerVO.setDue(this.resultSet
/*  328: 336 */           .getFloat("CUSTOMER_TRANS_DUE"));
/*  329:     */         
/*  330: 338 */         retailerCustomerVO.setTotalPaid(this.resultSet
/*  331: 339 */           .getFloat("CUSTOMER_TRANS_TOTAL_PAID"));
/*  332:     */         
/*  333: 341 */         retailerCustomerVO.setTotalDue(this.resultSet
/*  334: 342 */           .getFloat("CUSTOMER_TRANS_TOTAL_DUE"));
/*  335:     */         
/*  336: 344 */         retailerCustomerVO.setTransactionDate(this.resultSet
/*  337: 345 */           .getString("CUSTOMER_TRANS_DATE"));
/*  338:     */         
/*  339: 347 */         retailerCustomerVO.setRetailerId(this.resultSet
/*  340: 348 */           .getInt("CUSTOMER_ID_RETAILER"));
/*  341:     */         
/*  342: 350 */         retailerCustomerVO.setFullName(this.nameHelper.getRegularCustomerNameById(this.resultSet.getInt("CUSTOMER_ID_RETAILER")));
/*  343:     */         
/*  344:     */ 
/*  345:     */ 
/*  346:     */ 
/*  347:     */ 
/*  348: 356 */         retailerCustomerVO.setPaymentMode(this.nameHelper.getPaymentModeById(Integer.parseInt(this.resultSet
/*  349: 357 */           .getString("CUSTOMER_TRANS_PAY_MODE"))));
/*  350:     */         
/*  351: 359 */         retailerTransactionDetailList.add(retailerCustomerVO);
/*  352:     */       }
/*  353:     */     }
/*  354:     */     catch (SQLException sqlExp)
/*  355:     */     {
/*  356: 363 */       sqlExp.printStackTrace();
/*  357: 364 */       logger.error(
/*  358: 365 */         RetailerCustomerDaoImpl.class + 
/*  359: 366 */         "Error: Occur in Query While Fetching the retailer transaction Details into Grid from Database.", 
/*  360: 367 */         sqlExp);
/*  361:     */     }
/*  362:     */     catch (Exception exception)
/*  363:     */     {
/*  364: 369 */       exception.printStackTrace();
/*  365: 370 */       logger.error(
/*  366: 371 */         RetailerCustomerDaoImpl.class + 
/*  367: 372 */         "Error: Occur in Query While Closing Connection After Fetching the retailer transaction Details into Grid from Database.", 
/*  368: 373 */         exception);
/*  369:     */     }
/*  370:     */     finally
/*  371:     */     {
/*  372: 375 */       JdbcHelper.closeResultSet(this.resultSet);
/*  373: 376 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/*  374: 377 */       JdbcHelper.closeConnection(this.connection);
/*  375:     */     }
/*  376: 379 */     return retailerTransactionDetailList;
/*  377:     */   }
/*  378:     */   
/*  379:     */   public int deleteSpecificRetailerDetails(int custId)
/*  380:     */     throws DeleteFailedException
/*  381:     */   {
/*  382: 384 */     int effect = 0;
/*  383:     */     try
/*  384:     */     {
/*  385: 386 */       this.connection = getConnection();
/*  386:     */       
/*  387: 388 */       this.preparedStatement = this.connection.prepareStatement("UPDATE TAB_REGULAR_CUSTOMER SET REG_CUSTOMER_STATUS='DELETED' WHERE REG_CUSTOMER_ID=?");
/*  388:     */       
/*  389: 390 */       this.preparedStatement.setInt(1, custId);
/*  390:     */       
/*  391: 392 */       effect = this.preparedStatement.executeUpdate();
/*  392:     */     }
/*  393:     */     catch (SQLException sqlException)
/*  394:     */     {
/*  395: 395 */       sqlException.printStackTrace();
/*  396: 396 */       logger.error(
/*  397: 397 */         RetailerCustomerDaoImpl.class + 
/*  398: 398 */         ": Error:- Error: Occur in Query While deleting the retailer details record", 
/*  399: 399 */         sqlException);
/*  400:     */     }
/*  401:     */     catch (Exception exception)
/*  402:     */     {
/*  403: 401 */       exception.printStackTrace();
/*  404: 402 */       logger.error(
/*  405: 403 */         RetailerCustomerDaoImpl.class + 
/*  406: 404 */         ": Error:- While closing the Connection after deleting the retailer details reccord", 
/*  407: 405 */         exception);
/*  408:     */     }
/*  409:     */     finally
/*  410:     */     {
/*  411: 408 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/*  412: 409 */       JdbcHelper.closeConnection(this.connection);
/*  413:     */     }
/*  414: 411 */     return effect;
/*  415:     */   }
/*  416:     */   
/*  417:     */   public Retailer retriveSpecificRetailerDetailForEdit(int retailerId)
/*  418:     */     throws RecordNotFoundException
/*  419:     */   {
/*  420: 417 */     Retailer retailer = new Retailer();
/*  421:     */     try
/*  422:     */     {
/*  423: 420 */       this.connection = getConnection();
/*  424: 421 */       PreparedStatement preparedStatements = this.connection
/*  425: 422 */         .prepareStatement("SELECT * FROM TAB_REGULAR_CUSTOMER WHERE  REG_CUSTOMER_ID=?");
/*  426: 423 */       preparedStatements.setInt(1, retailerId);
/*  427:     */       
/*  428: 425 */       this.resultSet = preparedStatements.executeQuery();
/*  429: 426 */       System.out.println("----------hye ----------------");
/*  430: 427 */       if (this.resultSet != null) {
/*  431: 428 */         while (this.resultSet.next())
/*  432:     */         {
/*  433: 430 */           System.out.println("----------hye ----------------");
/*  434:     */           
/*  435: 432 */           retailer.setCustomerId(this.resultSet.getInt("REG_CUSTOMER_ID"));
/*  436: 433 */           System.out.println("________________" + this.resultSet.getInt("REG_CUSTOMER_ID"));
/*  437: 434 */           retailer.setSalutation(this.resultSet
/*  438: 435 */             .getString("REG_SALUTATION"));
/*  439:     */           
/*  440: 437 */           retailer.setFullName(this.resultSet
/*  441: 438 */             .getString("REG_FULL_NAME"));
/*  442:     */           
/*  443: 440 */           retailer.setDob(this.resultSet
/*  444: 441 */             .getString("REG_DATE_OF_BIRTH"));
/*  445:     */           
/*  446: 443 */           retailer.setAddress1(this.resultSet
/*  447: 444 */             .getString("REG_ADDRESS_LINE_1"));
/*  448:     */           
/*  449: 446 */           retailer.setAddress2(this.resultSet
/*  450: 447 */             .getString("REG_ADDRESS_LINE_2"));
/*  451:     */           
/*  452: 449 */           retailer.setCity(this.resultSet.getString("REG_CITY"));
/*  453:     */           
/*  454: 451 */           retailer.setState(this.resultSet.getString("REG_STATE"));
/*  455:     */           
/*  456: 453 */           retailer.setPinCode(this.resultSet.getString("REG_PINCODE"));
/*  457:     */           
/*  458: 455 */           retailer.setPeimaryMailId(this.resultSet.getString("REG_PRIMARY_MAIL_ID"));
/*  459:     */           
/*  460: 457 */           retailer.setAlternativeMail(this.resultSet
/*  461: 458 */             .getString("REG_ALTERNATE_MAIL_ID"));
/*  462:     */           
/*  463: 460 */           retailer.setPhoneNo(this.resultSet
/*  464: 461 */             .getString("REG_PHONE_NO"));
/*  465:     */           
/*  466:     */ 
/*  467:     */ 
/*  468: 465 */           retailer.setMobileNo(this.resultSet
/*  469: 466 */             .getString("REG_MOBILE_NO"));
/*  470: 467 */           retailer.setFaxNo(this.resultSet
/*  471: 468 */             .getString("REG_FAX_NO"));
/*  472:     */           
/*  473: 470 */           retailer.setSocialMailId(this.resultSet
/*  474: 471 */             .getString("REG_SOCIAL_IM_ID"));
/*  475:     */           
/*  476: 473 */           retailer.setCreationDate(this.resultSet
/*  477: 474 */             .getString("REG_CREATION_DATE"));
/*  478:     */           
/*  479: 476 */           retailer.setCreatedBy(this.resultSet.getString("REG_CREATED_BY"));
/*  480:     */           
/*  481: 478 */           retailer.setWorkLocation(this.resultSet
/*  482: 479 */             .getString("REG_WORK_LOCATION"));
/*  483:     */           
/*  484: 481 */           retailer.setContactPerson(this.resultSet
/*  485: 482 */             .getString("REG_CONTACT_PERSON"));
/*  486:     */           
/*  487: 484 */           retailer.setPhoneNo2(this.resultSet
/*  488: 485 */             .getString("REG_PHONE_NO2"));
/*  489:     */           
/*  490: 487 */           retailer.setMobileNo2(this.resultSet
/*  491: 488 */             .getString("REG_MOBILE_NO2"));
/*  492:     */           
/*  493: 490 */           retailer.setHomeContFaxNumIsd(this.resultSet
/*  494: 491 */             .getString("REG_FAX_ISD"));
/*  495:     */           
/*  496: 493 */           retailer.setHomeContFaxnumStd(this.resultSet
/*  497: 494 */             .getString("REG_FAX_STD"));
/*  498:     */           
/*  499: 496 */           retailer.setCountry(this.resultSet
/*  500: 497 */             .getString("REG_COUNTRY"));
/*  501:     */           
/*  502: 499 */           retailer.setPhoneNumberIsd(this.resultSet
/*  503: 500 */             .getString("REG_PHONE_ISD"));
/*  504:     */           
/*  505:     */ 
/*  506: 503 */           retailer.setPhoneNumberStd(this.resultSet
/*  507: 504 */             .getString("REG_PHONE_STD"));
/*  508:     */           
/*  509: 506 */           retailer.setPhoneNumberIsd2(this.resultSet
/*  510: 507 */             .getString("REG_PHONE_ISD2"));
/*  511:     */           
/*  512: 509 */           retailer.setPhoneNumberStd2(this.resultSet
/*  513: 510 */             .getString("REG_PHONE_STD2"));
/*  514:     */           
/*  515:     */ 
/*  516: 513 */           retailer.setMobileNum1Isd(this.resultSet
/*  517: 514 */             .getString("REG_MOBILE_ISD1"));
/*  518:     */           
/*  519: 516 */           retailer.setMobileNum1Isd2(this.resultSet
/*  520: 517 */             .getString("REG_MOBILE_ISD2"));
/*  521:     */           
/*  522: 519 */           retailer.setHomewebsite(this.resultSet
/*  523: 520 */             .getString("REG_HOME_WEBSITE"));
/*  524:     */         }
/*  525:     */       }
/*  526:     */     }
/*  527:     */     catch (SQLException sqlExp)
/*  528:     */     {
/*  529: 531 */       sqlExp.printStackTrace();
/*  530: 532 */       logger.error(
/*  531: 533 */         RetailerCustomerDaoImpl.class + 
/*  532: 534 */         "Error: Occur in Query While Fetching the specific retailer Details from Database For Update.", 
/*  533: 535 */         sqlExp);
/*  534:     */     }
/*  535:     */     catch (Exception exception)
/*  536:     */     {
/*  537: 537 */       exception.printStackTrace();
/*  538: 538 */       logger.error(
/*  539: 539 */         RetailerCustomerDaoImpl.class + 
/*  540: 540 */         "Error: Occur in Query While Closing Connection After Fetching the specific retailer Details from Database For Update.", 
/*  541: 541 */         exception);
/*  542:     */     }
/*  543:     */     finally
/*  544:     */     {
/*  545: 543 */       JdbcHelper.closeResultSet(this.resultSet);
/*  546: 544 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/*  547: 545 */       JdbcHelper.closeConnection(this.connection);
/*  548:     */     }
/*  549: 549 */     return retailer;
/*  550:     */   }
/*  551:     */   
/*  552:     */   public void updateSpecificRetailerRecord(RetailerCustomerVO retailerCustomerVO, int retailerId)
/*  553:     */     throws UpdateFailedException
/*  554:     */   {
/*  555:     */     try
/*  556:     */     {
/*  557: 555 */       this.connection = getConnection();
/*  558:     */       
/*  559:     */ 
/*  560: 558 */       String fukrey = "UPDATE TAB_REGULAR_CUSTOMER SET REG_SALUTATION=?, REG_FULL_NAME=?, REG_DATE_OF_BIRTH=?,REG_ADDRESS_LINE_1=?, REG_ADDRESS_LINE_2=?, REG_CITY=?,REG_STATE=?,REG_PINCODE=?,REG_PRIMARY_MAIL_ID=?, REG_ALTERNATE_MAIL_ID=?,REG_PHONE_NO=?,REG_MOBILE_NO=?, REG_FAX_NO=?,REG_SOCIAL_IM_ID=?,REG_CREATION_DATE=?,REG_CREATED_BY=?,REG_WORK_LOCATION=?, REG_CONTACT_PERSON=?, REG_PHONE_NO2=?, REG_MOBILE_NO2=?, REG_FAX_ISD=?,REG_FAX_STD=?, REG_COUNTRY=?, REG_PHONE_ISD=?, REG_PHONE_STD=?, REG_PHONE_ISD2=?, REG_PHONE_STD2=?, REG_MOBILE_ISD1=?, REG_MOBILE_ISD2=?, REG_HOME_WEBSITE=?, REG_REFFERED_BY=?, REG_PROFILE_DISC=? WHERE REG_CUSTOMER_ID=?";
/*  561:     */       
/*  562: 560 */       this.preparedStatement = this.connection.prepareStatement(fukrey);
/*  563: 561 */       this.preparedStatement.setString(1, retailerCustomerVO.getSalutation());
/*  564: 562 */       this.preparedStatement.setString(2, retailerCustomerVO.getFullName());
/*  565:     */       
/*  566: 564 */       this.preparedStatement.setString(3, "2018-04-03");
/*  567: 565 */       this.preparedStatement.setString(4, retailerCustomerVO.getAddress1());
/*  568: 566 */       this.preparedStatement.setString(5, retailerCustomerVO.getAddress2());
/*  569: 567 */       this.preparedStatement.setString(6, retailerCustomerVO.getCity());
/*  570: 568 */       this.preparedStatement.setString(7, retailerCustomerVO.getState());
/*  571: 569 */       this.preparedStatement.setString(8, retailerCustomerVO.getPinCode());
/*  572: 570 */       this.preparedStatement.setString(9, retailerCustomerVO.getPeimaryMailId());
/*  573: 571 */       this.preparedStatement.setString(10, retailerCustomerVO.getAlternativeMail());
/*  574: 572 */       this.preparedStatement.setString(11, retailerCustomerVO.getPhoneNo());
/*  575: 573 */       this.preparedStatement.setString(12, retailerCustomerVO.getMobileNo());
/*  576: 574 */       this.preparedStatement.setString(13, retailerCustomerVO.getFaxNo());
/*  577: 575 */       this.preparedStatement.setString(14, retailerCustomerVO.getSocialMailId());
/*  578: 576 */       this.preparedStatement.setString(15, DateTimeUtil.getCurrentDate());
/*  579: 577 */       this.preparedStatement.setInt(16, 1);
/*  580:     */       
/*  581: 579 */       this.preparedStatement.setString(17, retailerCustomerVO.getWorkLocation());
/*  582: 580 */       this.preparedStatement.setString(18, retailerCustomerVO.getContactPerson());
/*  583: 581 */       this.preparedStatement.setString(19, retailerCustomerVO.getPhoneNo2());
/*  584: 582 */       this.preparedStatement.setString(20, retailerCustomerVO.getMobileNo2());
/*  585: 583 */       this.preparedStatement.setString(21, retailerCustomerVO.getHomeContFaxNumIsd());
/*  586: 584 */       this.preparedStatement.setString(22, retailerCustomerVO.getHomeContFaxnumStd());
/*  587: 585 */       this.preparedStatement.setString(23, retailerCustomerVO.getCountry());
/*  588: 586 */       this.preparedStatement.setString(24, retailerCustomerVO.getPhoneNumberIsd());
/*  589: 587 */       this.preparedStatement.setString(25, retailerCustomerVO.getPhoneNumberStd());
/*  590: 588 */       this.preparedStatement.setString(26, retailerCustomerVO.getPhoneNumberIsd2());
/*  591: 589 */       this.preparedStatement.setString(27, retailerCustomerVO.getPhoneNumberStd2());
/*  592: 590 */       this.preparedStatement.setString(28, retailerCustomerVO.getMobileNum1Isd());
/*  593: 591 */       this.preparedStatement.setString(29, retailerCustomerVO.getMobileNum1Isd2());
/*  594: 592 */       this.preparedStatement.setString(30, retailerCustomerVO.getHomewebsite());
/*  595: 593 */       this.preparedStatement.setString(31, retailerCustomerVO.getRefferedBy());
/*  596: 594 */       this.preparedStatement.setString(32, retailerCustomerVO.getProfileDescription());
/*  597: 595 */       this.preparedStatement.setInt(33, retailerId);
/*  598:     */       
/*  599: 597 */       this.preparedStatement.executeUpdate();
/*  600:     */     }
/*  601:     */     catch (SQLException sqlException)
/*  602:     */     {
/*  603: 602 */       sqlException.printStackTrace();
/*  604: 603 */       logger.error(
/*  605: 604 */         RetailerCustomerDaoImpl.class + 
/*  606: 605 */         ": Error:- Error: Occur in Query While updating the retailer details record", 
/*  607: 606 */         sqlException);
/*  608:     */     }
/*  609:     */     catch (Exception exception)
/*  610:     */     {
/*  611: 608 */       exception.printStackTrace();
/*  612: 609 */       logger.error(
/*  613: 610 */         RetailerCustomerDaoImpl.class + 
/*  614: 611 */         ": Error:- While closing the Connection after updating the retailer details reccord", 
/*  615: 612 */         exception);
/*  616:     */     }
/*  617:     */     finally
/*  618:     */     {
/*  619: 615 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/*  620: 616 */       JdbcHelper.closeConnection(this.connection);
/*  621:     */     }
/*  622:     */   }
/*  623:     */   
/*  624:     */   public Retailer retriveSpecificRetailerTransaction(int transId)
/*  625:     */     throws RecordNotFoundException
/*  626:     */   {
/*  627: 623 */     Retailer retailer = new Retailer();
/*  628: 624 */     PreparedStatement preparedStatements = null;
/*  629:     */     try
/*  630:     */     {
/*  631: 627 */       this.connection = getConnection();
/*  632:     */       
/*  633: 629 */       preparedStatements = this.connection
/*  634: 630 */         .prepareStatement("SELECT * FROM  TAB_OWNER_CUSTOMER_TRANSACTION WHERE CUSTOMER_TRANS_ID=? ");
/*  635: 631 */       preparedStatements.setInt(1, transId);
/*  636:     */       
/*  637:     */ 
/*  638: 634 */       this.resultSet = preparedStatements.executeQuery();
/*  639: 635 */       System.out.println("----------hye ----------------");
/*  640: 636 */       if (this.resultSet != null) {
/*  641: 637 */         while (this.resultSet.next())
/*  642:     */         {
/*  643: 639 */           System.out.println("----------hye ----------------");
/*  644:     */           
/*  645: 641 */           retailer.setTransactionId(this.resultSet.getInt("CUSTOMER_TRANS_ID"));
/*  646: 642 */           System.out.println("________________" + this.resultSet.getInt("CUSTOMER_TRANS_ID"));
/*  647:     */           
/*  648:     */ 
/*  649:     */ 
/*  650: 646 */           retailer.setDescription(this.resultSet
/*  651: 647 */             .getString("CUSTOMER_TRANS_DISCRIPTION"));
/*  652:     */           
/*  653: 649 */           retailer.setTotal(this.resultSet
/*  654: 650 */             .getFloat("CUSTOMER_TRANS_TOTAL"));
/*  655:     */           
/*  656: 652 */           retailer.setPaid(this.resultSet
/*  657: 653 */             .getFloat("CUSTOMER_TRANS_PAID"));
/*  658:     */           
/*  659: 655 */           retailer.setDue(this.resultSet
/*  660: 656 */             .getFloat("CUSTOMER_TRANS_DUE"));
/*  661:     */           
/*  662: 658 */           retailer.setTotalPaid(this.resultSet.getFloat("CUSTOMER_TRANS_TOTAL_PAID"));
/*  663:     */           
/*  664: 660 */           retailer.setTotalDue(this.resultSet.getFloat("CUSTOMER_TRANS_TOTAL_DUE"));
/*  665:     */           
/*  666: 662 */           retailer.setTransactionDate(this.resultSet.getString("CUSTOMER_TRANS_DATE"));
/*  667:     */           
/*  668: 664 */           retailer.setRetailerId(this.resultSet.getInt("CUSTOMER_ID_RETAILER"));
/*  669: 665 */           retailer.setFullName(this.nameHelper.getRegularCustomerNameById(this.resultSet.getInt("CUSTOMER_ID_RETAILER")));
/*  670:     */           
/*  671:     */ 
/*  672:     */ 
/*  673:     */ 
/*  674:     */ 
/*  675:     */ 
/*  676:     */ 
/*  677:     */ 
/*  678:     */ 
/*  679: 675 */           retailer.setPaymentMode(this.nameHelper.getPaymentModeById(this.resultSet
/*  680: 676 */             .getInt("CUSTOMER_TRANS_PAY_MODE")));
/*  681:     */         }
/*  682:     */       }
/*  683:     */     }
/*  684:     */     catch (SQLException sqlExp)
/*  685:     */     {
/*  686: 687 */       sqlExp.printStackTrace();
/*  687: 688 */       logger.error(
/*  688: 689 */         RetailerCustomerDaoImpl.class + 
/*  689: 690 */         "Error: Occur in Query While Fetching the specific customer transaction from Database For Update.", 
/*  690: 691 */         sqlExp);
/*  691:     */     }
/*  692:     */     catch (Exception exception)
/*  693:     */     {
/*  694: 693 */       exception.printStackTrace();
/*  695: 694 */       logger.error(
/*  696: 695 */         RetailerCustomerDaoImpl.class + 
/*  697: 696 */         "Error: Occur in Query While Closing Connection After Fetching the specific customer transaction from Database For Update.", 
/*  698: 697 */         exception);
/*  699:     */     }
/*  700:     */     finally
/*  701:     */     {
/*  702: 699 */       JdbcHelper.closeResultSet(this.resultSet);
/*  703: 700 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/*  704: 701 */       JdbcHelper.closeConnection(this.connection);
/*  705:     */     }
/*  706: 703 */     return retailer;
/*  707:     */   }
/*  708:     */   
/*  709:     */   public int deleteSpecificRetailerTransaction(int transId)
/*  710:     */     throws DeleteFailedException
/*  711:     */   {
/*  712: 708 */     int effect = 0;
/*  713:     */     try
/*  714:     */     {
/*  715: 710 */       this.connection = getConnection();
/*  716:     */       
/*  717: 712 */       this.preparedStatement = this.connection.prepareStatement("DELETE FROM TAB_OWNER_CUSTOMER_TRANSACTION WHERE CUSTOMER_TRANS_ID=?");
/*  718:     */       
/*  719: 714 */       this.preparedStatement.setInt(1, transId);
/*  720:     */       
/*  721: 716 */       effect = this.preparedStatement.executeUpdate();
/*  722:     */     }
/*  723:     */     catch (SQLException sqlException)
/*  724:     */     {
/*  725: 719 */       sqlException.printStackTrace();
/*  726: 720 */       logger.error(
/*  727: 721 */         RetailerCustomerDaoImpl.class + 
/*  728: 722 */         ": Error:- Error: Occur in Query While deleting the retailer transaction record", 
/*  729: 723 */         sqlException);
/*  730:     */     }
/*  731:     */     catch (Exception exception)
/*  732:     */     {
/*  733: 725 */       exception.printStackTrace();
/*  734: 726 */       logger.error(
/*  735: 727 */         RetailerCustomerDaoImpl.class + 
/*  736: 728 */         ": Error:- While closing the Connection after deleting the retailer transaction reccord", 
/*  737: 729 */         exception);
/*  738:     */     }
/*  739:     */     finally
/*  740:     */     {
/*  741: 732 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/*  742: 733 */       JdbcHelper.closeConnection(this.connection);
/*  743:     */     }
/*  744: 735 */     return effect;
/*  745:     */   }
/*  746:     */   
/*  747:     */   public void retailerTransactionPrintPDF(HttpServletRequest request, HttpServletResponse response, int transId)
/*  748:     */   {
/*  749: 740 */     String companyName = "Chouksay Traders";
/*  750: 741 */     String address1 = "BUS STAND SHAMSHABAD, DIST.- VIDISHA, MADHYA PRADESH, 464001";
/*  751: 742 */     String address2 = "GSTIN: 23AJQPC8200P1Z1";
/*  752: 743 */     String address3 = "PAN NO: AJQPC8200P";
/*  753:     */     
/*  754: 745 */     String city = "Vidisha-464001";
/*  755: 746 */     String state = "(M.P.)";
/*  756: 747 */     StringBuffer stringBuffer = null;
/*  757:     */     try
/*  758:     */     {
/*  759: 751 */       this.connection = getConnection();
/*  760:     */       
/*  761: 753 */       this.preparedStatement = this.connection
/*  762: 754 */         .prepareStatement("SELECT * FROM TAB_OWNER_CUSTOMER_TRANSACTION WHERE CUSTOMER_TRANS_ID=? ");
/*  763: 755 */       this.preparedStatement.setInt(1, transId);
/*  764:     */       
/*  765:     */ 
/*  766: 758 */       this.resultSet = this.preparedStatement.executeQuery();
/*  767: 759 */       Document document = new Document(PageSize.A4);
/*  768:     */       
/*  769: 761 */       Font Font3 = new Font(Font.FontFamily.TIMES_ROMAN, 11.0F, 0);
/*  770: 762 */       Font Font2 = new Font(Font.FontFamily.TIMES_ROMAN, 6.0F, 
/*  771: 763 */         8);
/*  772: 764 */       Font Font4 = new Font(Font.FontFamily.TIMES_ROMAN, 11.0F, 1);
/*  773: 765 */       Font4.setColor(BaseColor.WHITE);
/*  774: 766 */       Font mainContent = new Font(Font.FontFamily.TIMES_ROMAN, 10.0F, 
/*  775: 767 */         0);
/*  776: 768 */       Font Font5 = new Font(Font.FontFamily.TIMES_ROMAN, 12.0F, 1);
/*  777: 769 */       Font5.setColor(BaseColor.GRAY);
/*  778: 770 */       Font Font6 = new Font(Font.FontFamily.TIMES_ROMAN, 10.0F, 1);
/*  779: 771 */       Font6.setColor(BaseColor.RED);
/*  780:     */       
/*  781:     */ 
/*  782: 774 */       response.setContentType("application/pdf");
/*  783:     */       
/*  784: 776 */       PdfWriter.getInstance(document, response.getOutputStream());
/*  785:     */       
/*  786: 778 */       document.open();
/*  787:     */       
/*  788: 780 */       String contextPath = ServletActionContext.getServletContext()
/*  789: 781 */         .getRealPath("/outer/img/rohittraders.png");
/*  790: 782 */       this.image = Image.getInstance(contextPath);
/*  791: 783 */       this.image.scaleToFit(130.0F, 70.0F);
/*  792:     */       
/*  793: 785 */       PdfPTable table1 = new PdfPTable(2);
/*  794: 786 */       table1.setWidthPercentage(100.0F);
/*  795: 787 */       Rectangle rect1 = new Rectangle(300.0F, 700.0F);
/*  796: 788 */       table1.setWidthPercentage(new float[] { 150.0F, 150.0F }, rect1);
/*  797:     */       
/*  798: 790 */       PdfPCell cell101 = new PdfPCell(this.image, false);
/*  799: 791 */       cell101.setPaddingTop(5.0F);
/*  800: 792 */       cell101.setBorder(0);
/*  801:     */       
/*  802: 794 */       Phrase phrase3 = new Phrase(companyName + "\n", Font5);
/*  803: 795 */       Phrase phrase = new Phrase(address1 + "\n", Font3);
/*  804: 796 */       Phrase phrase1 = new Phrase(address2 + "\n", Font3);
/*  805: 797 */       Phrase phrase4 = new Phrase(address3 + "\n", Font3);
/*  806: 798 */       Phrase phrase2 = new Phrase(city + "-" + state, Font3);
/*  807:     */       
/*  808: 800 */       Paragraph paragraph = new Paragraph();
/*  809: 801 */       paragraph.add(phrase3);
/*  810: 802 */       paragraph.add(phrase);
/*  811: 803 */       paragraph.add(phrase1);
/*  812: 804 */       paragraph.add(phrase4);
/*  813: 805 */       paragraph.add(phrase2);
/*  814:     */       
/*  815: 807 */       PdfPCell cell102 = new PdfPCell(paragraph);
/*  816: 808 */       cell102.setPaddingTop(5.0F);
/*  817: 809 */       cell102.setBorder(0);
/*  818: 810 */       cell102.setHorizontalAlignment(2);
/*  819:     */       
/*  820: 812 */       PdfPCell cell103 = new PdfPCell(
/*  821: 813 */         new Paragraph(
/*  822: 814 */         "   \n                                                                                                                                                                                                                                                                                                                                                  ", 
/*  823:     */         
/*  824:     */ 
/*  825: 817 */         Font2));
/*  826: 818 */       cell103.setColspan(2);
/*  827: 819 */       cell103.setBorderWidthRight(0.0F);
/*  828: 820 */       cell103.setBorderWidthLeft(0.0F);
/*  829: 821 */       cell103.setBorderWidthTop(0.5F);
/*  830: 822 */       cell103.setBorderWidthBottom(0.0F);
/*  831: 823 */       cell103.setBorderColorTop(BaseColor.WHITE);
/*  832:     */       
/*  833: 825 */       PdfPCell cell104 = new PdfPCell(new Paragraph("RETAILER TRANSACTION", Font4));
/*  834: 826 */       cell104.setUseBorderPadding(true);
/*  835: 827 */       cell104.setColspan(2);
/*  836: 828 */       cell104.setBorderWidthRight(0.1F);
/*  837: 829 */       cell104.setBorderWidthLeft(0.1F);
/*  838: 830 */       cell104.setBorderWidthTop(0.1F);
/*  839: 831 */       cell104.setBorderWidthBottom(0.1F);
/*  840: 832 */       cell104.setBorderColor(BaseColor.LIGHT_GRAY);
/*  841: 833 */       cell104.setBackgroundColor(new BaseColor(0, 59, 119));
/*  842:     */       
/*  843: 835 */       table1.addCell(cell101);
/*  844: 836 */       table1.addCell(cell102);
/*  845: 837 */       table1.addCell(cell103);
/*  846: 838 */       table1.addCell(cell104);
/*  847: 839 */       document.add(table1);
/*  848: 845 */       while (this.resultSet.next())
/*  849:     */       {
/*  850: 846 */         stringBuffer = new StringBuffer();
/*  851: 847 */         PdfPTable table = new PdfPTable(2);
/*  852: 848 */         table.setFooterRows(1);
/*  853: 849 */         table.setWidthPercentage(100.0F);
/*  854: 850 */         Rectangle rect = new Rectangle(300.0F, 700.0F);
/*  855: 851 */         table.setWidthPercentage(new float[] { 80.0F, 220.0F }, rect);
/*  856:     */         
/*  857: 853 */         PdfPCell cell = new PdfPCell(new Paragraph());
/*  858: 854 */         cell.setColspan(2);
/*  859: 855 */         cell.setBorderWidthRight(0.1F);
/*  860: 856 */         cell.setBorderWidthLeft(0.1F);
/*  861: 857 */         cell.setBorderWidthTop(0.1F);
/*  862: 858 */         cell.setBorderWidthBottom(0.2F);
/*  863: 859 */         cell.setBorderColor(BaseColor.LIGHT_GRAY);
/*  864: 860 */         cell.setBackgroundColor(new BaseColor(238, 238, 238));
/*  865:     */         
/*  866: 862 */         PdfPCell cell1 = new PdfPCell(new Paragraph());
/*  867: 863 */         cell1.setBackgroundColor(new BaseColor(238, 238, 238));
/*  868: 864 */         cell1.setBorderWidth(0.01F);
/*  869: 865 */         cell1.setBorderColor(BaseColor.WHITE);
/*  870:     */         
/*  871: 867 */         PdfPCell cell2 = new PdfPCell(new Paragraph());
/*  872: 868 */         cell2.setBackgroundColor(new BaseColor(238, 238, 238));
/*  873: 869 */         cell2.setBorderWidth(0.2F);
/*  874: 870 */         cell2.setBorderColor(BaseColor.WHITE);
/*  875:     */         
/*  876: 872 */         PdfPCell cell3 = new PdfPCell(new Paragraph("Transaction Id", 
/*  877: 873 */           mainContent));
/*  878: 874 */         cell3.setBackgroundColor(new BaseColor(238, 238, 238));
/*  879: 875 */         cell3.setBorderWidth(0.01F);
/*  880: 876 */         cell3.setBorderColor(BaseColor.WHITE);
/*  881:     */         
/*  882: 878 */         PdfPCell cell4 = new PdfPCell(new Paragraph(this.resultSet.getString("CUSTOMER_TRANS_ID"), mainContent));
/*  883: 879 */         cell4.setBorderWidth(0.2F);
/*  884: 880 */         cell4.setBorderColor(BaseColor.LIGHT_GRAY);
/*  885:     */         
/*  886: 882 */         PdfPCell cell5 = new PdfPCell(new Paragraph(
/*  887: 883 */           "Description", mainContent));
/*  888: 884 */         cell5.setBackgroundColor(new BaseColor(238, 238, 238));
/*  889: 885 */         cell5.setBorderWidth(0.01F);
/*  890: 886 */         cell5.setBorderColor(BaseColor.WHITE);
/*  891:     */         
/*  892: 888 */         PdfPCell cell6 = new PdfPCell(new Paragraph(this.resultSet.getString("CUSTOMER_TRANS_DISCRIPTION"), mainContent));
/*  893: 889 */         cell6.setBorderWidth(0.2F);
/*  894: 890 */         cell6.setBorderColor(BaseColor.LIGHT_GRAY);
/*  895:     */         
/*  896: 892 */         PdfPCell cell7 = new PdfPCell(new Paragraph("Total", 
/*  897: 893 */           mainContent));
/*  898: 894 */         cell7.setBackgroundColor(new BaseColor(238, 238, 238));
/*  899: 895 */         cell7.setBorderWidth(0.01F);
/*  900: 896 */         cell7.setBorderColor(BaseColor.WHITE);
/*  901:     */         
/*  902: 898 */         PdfPCell cell8 = new PdfPCell(new Paragraph(
/*  903: 899 */           this.resultSet.getString("CUSTOMER_TRANS_TOTAL"), mainContent));
/*  904: 900 */         cell8.setBorderWidth(0.2F);
/*  905: 901 */         cell8.setBorderColor(BaseColor.LIGHT_GRAY);
/*  906:     */         
/*  907:     */ 
/*  908:     */ 
/*  909: 905 */         PdfPCell cell9 = new PdfPCell(new Paragraph("Paid", 
/*  910: 906 */           mainContent));
/*  911: 907 */         cell9.setBorderWidth(0.2F);
/*  912: 908 */         cell9.setBorderColor(BaseColor.LIGHT_GRAY);
/*  913:     */         
/*  914: 910 */         PdfPCell cell10 = new PdfPCell(new Paragraph(
/*  915: 911 */           this.resultSet.getString("CUSTOMER_TRANS_PAID"), mainContent));
/*  916: 912 */         cell10.setBorderWidth(0.2F);
/*  917: 913 */         cell10.setBorderColor(BaseColor.LIGHT_GRAY);
/*  918:     */         
/*  919: 915 */         PdfPCell cell11 = new PdfPCell(new Paragraph("Due", 
/*  920: 916 */           mainContent));
/*  921: 917 */         cell11.setBackgroundColor(new BaseColor(238, 238, 238));
/*  922: 918 */         cell11.setBorderWidth(0.01F);
/*  923: 919 */         cell11.setBorderColor(BaseColor.WHITE);
/*  924:     */         
/*  925: 921 */         PdfPCell cell12 = new PdfPCell(new Paragraph(this.resultSet.getString("CUSTOMER_TRANS_DUE"), mainContent));
/*  926: 922 */         cell12.setBorderWidth(0.2F);
/*  927: 923 */         cell12.setBorderColor(BaseColor.LIGHT_GRAY);
/*  928:     */         
/*  929: 925 */         PdfPCell cell13 = new PdfPCell(new Paragraph("Total Paid", 
/*  930: 926 */           mainContent));
/*  931: 927 */         cell13.setBackgroundColor(new BaseColor(238, 238, 238));
/*  932: 928 */         cell13.setBorderWidth(0.01F);
/*  933: 929 */         cell13.setBorderColor(BaseColor.WHITE);
/*  934:     */         
/*  935: 931 */         PdfPCell cell14 = new PdfPCell(new Paragraph(this.resultSet.getString("CUSTOMER_TRANS_TOTAL_PAID"), mainContent));
/*  936: 932 */         cell14.setBorderWidth(0.2F);
/*  937: 933 */         cell14.setBorderColor(BaseColor.LIGHT_GRAY);
/*  938:     */         
/*  939: 935 */         PdfPCell cell15 = new PdfPCell(new Paragraph(
/*  940: 936 */           "SGST", mainContent));
/*  941: 937 */         cell15.setBackgroundColor(new BaseColor(238, 238, 238));
/*  942: 938 */         cell15.setBorderWidth(0.01F);
/*  943: 939 */         cell15.setBorderColor(BaseColor.WHITE);
/*  944:     */         
/*  945: 941 */         PdfPCell cell16 = new PdfPCell(new Paragraph(this.resultSet.getString("CUSTOMER_TRANS_TOTAL_DUE"), mainContent));
/*  946: 942 */         cell16.setBorderWidth(0.2F);
/*  947: 943 */         cell16.setBorderColor(BaseColor.LIGHT_GRAY);
/*  948:     */         
/*  949: 945 */         PdfPCell cell17 = new PdfPCell(new Paragraph("Bill No", 
/*  950: 946 */           mainContent));
/*  951: 947 */         cell17.setBackgroundColor(new BaseColor(238, 238, 238));
/*  952: 948 */         cell17.setBorderWidth(0.01F);
/*  953: 949 */         cell17.setBorderColor(BaseColor.WHITE);
/*  954:     */         
/*  955: 951 */         PdfPCell cell18 = new PdfPCell(new Paragraph(this.resultSet.getString("CUSTOMER_UNIQUE_ID"), mainContent));
/*  956: 952 */         cell18.setBorderWidth(0.2F);
/*  957: 953 */         cell18.setBorderColor(BaseColor.LIGHT_GRAY);
/*  958:     */         
/*  959: 955 */         PdfPCell cell19 = new PdfPCell(new Paragraph("Payment Mode", 
/*  960: 956 */           mainContent));
/*  961: 957 */         cell19.setBackgroundColor(new BaseColor(238, 238, 238));
/*  962: 958 */         cell19.setBorderWidth(0.01F);
/*  963: 959 */         cell19.setBorderColor(BaseColor.WHITE);
/*  964:     */         
/*  965: 961 */         PdfPCell cell20 = new PdfPCell(new Paragraph(this.resultSet.getString("CUSTOMER_TRANS_PAY_MODE"), mainContent));
/*  966: 962 */         cell20.setBorderWidth(0.2F);
/*  967: 963 */         cell20.setBorderColor(BaseColor.LIGHT_GRAY);
/*  968:     */         
/*  969: 965 */         PdfPCell cell21 = new PdfPCell(new Paragraph("Transaction Date", 
/*  970: 966 */           mainContent));
/*  971: 967 */         cell21.setBackgroundColor(new BaseColor(238, 238, 238));
/*  972: 968 */         cell21.setBorderWidth(0.01F);
/*  973: 969 */         cell21.setBorderColor(BaseColor.WHITE);
/*  974:     */         
/*  975: 971 */         PdfPCell cell22 = new PdfPCell(new Paragraph(this.resultSet.getString("CUSTOMER_TRANS_DATE"), mainContent));
/*  976: 972 */         cell22.setBorderWidth(0.2F);
/*  977: 973 */         cell22.setBorderColor(BaseColor.LIGHT_GRAY);
/*  978:     */         
/*  979: 975 */         PdfPCell cell23 = new PdfPCell(new Paragraph(
/*  980: 976 */           "Retailer Reference", mainContent));
/*  981: 977 */         cell23.setBackgroundColor(new BaseColor(238, 238, 238));
/*  982: 978 */         cell23.setBorderWidth(0.01F);
/*  983: 979 */         cell23.setBorderColor(BaseColor.WHITE);
/*  984:     */         
/*  985: 981 */         PdfPCell cell24 = new PdfPCell(
/*  986: 982 */           new Paragraph(this.resultSet.getString(
/*  987: 983 */           "CUSTOMER_ID_RETAILER"), 
/*  988: 984 */           mainContent));
/*  989: 985 */         cell24.setBorderWidth(0.2F);
/*  990: 986 */         cell24.setBorderColor(BaseColor.LIGHT_GRAY);
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
/* 1108:     */ 
/* 1109:     */ 
/* 1110:     */ 
/* 1111:     */ 
/* 1112:     */ 
/* 1113:     */ 
/* 1114:     */ 
/* 1115:     */ 
/* 1116:     */ 
/* 1117:     */ 
/* 1118:     */ 
/* 1119:     */ 
/* 1120:     */ 
/* 1121:     */ 
/* 1122:     */ 
/* 1123:     */ 
/* 1124:     */ 
/* 1125:     */ 
/* 1126:     */ 
/* 1127:     */ 
/* 1128:     */ 
/* 1129:     */ 
/* 1130:     */ 
/* 1131:     */ 
/* 1132:     */ 
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
/* 1171:     */ 
/* 1172:     */ 
/* 1173:     */ 
/* 1174:     */ 
/* 1175:     */ 
/* 1176:     */ 
/* 1177:     */ 
/* 1178:     */ 
/* 1179:     */ 
/* 1180:     */ 
/* 1181:     */ 
/* 1182:     */ 
/* 1183:     */ 
/* 1184:     */ 
/* 1185:     */ 
/* 1186:     */ 
/* 1187:     */ 
/* 1188:     */ 
/* 1189:     */ 
/* 1190:     */ 
/* 1191:     */ 
/* 1192:1188 */         table.addCell(cell);
/* 1193:1189 */         table.addCell(cell1);
/* 1194:1190 */         table.addCell(cell2);
/* 1195:1191 */         table.addCell(cell3);
/* 1196:1192 */         table.addCell(cell4);
/* 1197:1193 */         table.addCell(cell5);
/* 1198:1194 */         table.addCell(cell6);
/* 1199:1195 */         table.addCell(cell7);
/* 1200:1196 */         table.addCell(cell8);
/* 1201:1197 */         table.addCell(cell9);
/* 1202:1198 */         table.addCell(cell10);
/* 1203:1199 */         table.addCell(cell11);
/* 1204:1200 */         table.addCell(cell12);
/* 1205:1201 */         table.addCell(cell13);
/* 1206:1202 */         table.addCell(cell14);
/* 1207:1203 */         table.addCell(cell15);
/* 1208:1204 */         table.addCell(cell16);
/* 1209:1205 */         table.addCell(cell17);
/* 1210:1206 */         table.addCell(cell18);
/* 1211:1207 */         table.addCell(cell19);
/* 1212:1208 */         table.addCell(cell20);
/* 1213:1209 */         table.addCell(cell21);
/* 1214:1210 */         table.addCell(cell22);
/* 1215:1211 */         table.addCell(cell23);
/* 1216:1212 */         table.addCell(cell24);
/* 1217:     */         
/* 1218:     */ 
/* 1219:     */ 
/* 1220:     */ 
/* 1221:     */ 
/* 1222:     */ 
/* 1223:     */ 
/* 1224:     */ 
/* 1225:     */ 
/* 1226:     */ 
/* 1227:     */ 
/* 1228:     */ 
/* 1229:     */ 
/* 1230:     */ 
/* 1231:     */ 
/* 1232:     */ 
/* 1233:     */ 
/* 1234:     */ 
/* 1235:     */ 
/* 1236:     */ 
/* 1237:     */ 
/* 1238:     */ 
/* 1239:     */ 
/* 1240:     */ 
/* 1241:     */ 
/* 1242:     */ 
/* 1243:     */ 
/* 1244:     */ 
/* 1245:     */ 
/* 1246:     */ 
/* 1247:     */ 
/* 1248:     */ 
/* 1249:     */ 
/* 1250:     */ 
/* 1251:     */ 
/* 1252:     */ 
/* 1253:     */ 
/* 1254:     */ 
/* 1255:1251 */         document.add(table);
/* 1256:     */       }
/* 1257:1255 */       document.add(new Paragraph("\n"));
/* 1258:     */       
/* 1259:     */ 
/* 1260:     */ 
/* 1261:1259 */       document.close();
/* 1262:     */     }
/* 1263:     */     catch (SQLException sqlExp)
/* 1264:     */     {
/* 1265:1262 */       sqlExp.printStackTrace();
/* 1266:1263 */       logger.error(
/* 1267:1264 */         RetailerCustomerDaoImpl.class + 
/* 1268:1265 */         "Error: Occur in Query While Fetching All retailer Transaction for print PdF from Database.", 
/* 1269:1266 */         sqlExp);
/* 1270:     */     }
/* 1271:     */     catch (Exception exception)
/* 1272:     */     {
/* 1273:1268 */       exception.printStackTrace();
/* 1274:1269 */       logger.error(
/* 1275:1270 */         RetailerCustomerDaoImpl.class + 
/* 1276:1271 */         "Error: Occur in Query While Closing Connection After Fetching All retailer Transaction for print PdF from Database.", 
/* 1277:1272 */         exception);
/* 1278:     */     }
/* 1279:     */     finally
/* 1280:     */     {
/* 1281:1274 */       JdbcHelper.closeResultSet(this.resultSet);
/* 1282:1275 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/* 1283:1276 */       JdbcHelper.closeConnection(this.connection);
/* 1284:     */     }
/* 1285:     */   }
/* 1286:     */   
/* 1287:     */   public void retailerDetailPrintPDF(HttpServletRequest request, HttpServletResponse response, int dealerId)
/* 1288:     */   {
/* 1289:1286 */     String companyName = "Chouksay Traders";
/* 1290:1287 */     String address1 = "BUS STAND SHAMSHABAD, DIST.- VIDISHA, MADHYA PRADESH, 464001";
/* 1291:1288 */     String address2 = "GSTIN: 23AJQPC8200P1Z1";
/* 1292:1289 */     String address3 = "PAN NO: AJQPC8200P";
/* 1293:     */     
/* 1294:1291 */     String city = "Vidisha-464001";
/* 1295:1292 */     String state = "(M.P.)";
/* 1296:1293 */     StringBuffer stringBuffer = null;
/* 1297:1294 */     System.out.println("we r dealer dao for print" + dealerId);
/* 1298:     */     try
/* 1299:     */     {
/* 1300:1297 */       this.connection = getConnection();
/* 1301:1298 */       this.preparedStatement = this.connection
/* 1302:1299 */         .prepareStatement("SELECT * FROM TAB_REGULAR_CUSTOMER WHERE REG_CUSTOMER_STATUS='ACTIVE' AND REG_CUSTOMER_ID=? ");
/* 1303:1300 */       this.preparedStatement.setInt(1, dealerId);
/* 1304:1301 */       this.resultSet = this.preparedStatement.executeQuery();
/* 1305:1302 */       Document document = new Document(PageSize.A4);
/* 1306:     */       
/* 1307:1304 */       Font Font3 = new Font(Font.FontFamily.TIMES_ROMAN, 11.0F, 0);
/* 1308:1305 */       Font Font2 = new Font(Font.FontFamily.TIMES_ROMAN, 6.0F, 
/* 1309:1306 */         8);
/* 1310:1307 */       Font Font4 = new Font(Font.FontFamily.TIMES_ROMAN, 11.0F, 1);
/* 1311:1308 */       Font4.setColor(BaseColor.WHITE);
/* 1312:1309 */       Font mainContent = new Font(Font.FontFamily.TIMES_ROMAN, 10.0F, 
/* 1313:1310 */         0);
/* 1314:1311 */       Font Font5 = new Font(Font.FontFamily.TIMES_ROMAN, 12.0F, 1);
/* 1315:1312 */       Font5.setColor(BaseColor.GRAY);
/* 1316:1313 */       Font Font6 = new Font(Font.FontFamily.TIMES_ROMAN, 10.0F, 1);
/* 1317:1314 */       Font6.setColor(BaseColor.RED);
/* 1318:     */       
/* 1319:     */ 
/* 1320:1317 */       response.setContentType("application/pdf");
/* 1321:     */       
/* 1322:1319 */       PdfWriter.getInstance(document, response.getOutputStream());
/* 1323:     */       
/* 1324:1321 */       document.open();
/* 1325:     */       
/* 1326:1323 */       String contextPath = ServletActionContext.getServletContext()
/* 1327:1324 */         .getRealPath("/outer/img/rohittraders.png");
/* 1328:1325 */       this.image = Image.getInstance(contextPath);
/* 1329:1326 */       this.image.scaleToFit(130.0F, 70.0F);
/* 1330:     */       
/* 1331:1328 */       PdfPTable table1 = new PdfPTable(2);
/* 1332:1329 */       table1.setWidthPercentage(100.0F);
/* 1333:1330 */       Rectangle rect1 = new Rectangle(300.0F, 700.0F);
/* 1334:1331 */       table1.setWidthPercentage(new float[] { 150.0F, 150.0F }, rect1);
/* 1335:     */       
/* 1336:1333 */       PdfPCell cell101 = new PdfPCell(this.image, false);
/* 1337:1334 */       cell101.setPaddingTop(5.0F);
/* 1338:1335 */       cell101.setBorder(0);
/* 1339:     */       
/* 1340:1337 */       Phrase phrase3 = new Phrase(companyName + "\n", Font5);
/* 1341:1338 */       Phrase phrase = new Phrase(address1 + "\n", Font3);
/* 1342:1339 */       Phrase phrase1 = new Phrase(address2 + "\n", Font3);
/* 1343:1340 */       Phrase phrase4 = new Phrase(address3 + "\n", Font3);
/* 1344:1341 */       Phrase phrase2 = new Phrase(city + "-" + state, Font3);
/* 1345:     */       
/* 1346:1343 */       Paragraph paragraph = new Paragraph();
/* 1347:1344 */       paragraph.add(phrase3);
/* 1348:1345 */       paragraph.add(phrase);
/* 1349:1346 */       paragraph.add(phrase1);
/* 1350:1347 */       paragraph.add(phrase4);
/* 1351:1348 */       paragraph.add(phrase2);
/* 1352:     */       
/* 1353:1350 */       PdfPCell cell102 = new PdfPCell(paragraph);
/* 1354:1351 */       cell102.setPaddingTop(5.0F);
/* 1355:1352 */       cell102.setBorder(0);
/* 1356:1353 */       cell102.setHorizontalAlignment(2);
/* 1357:     */       
/* 1358:1355 */       PdfPCell cell103 = new PdfPCell(
/* 1359:1356 */         new Paragraph(
/* 1360:1357 */         "   \n                                                                                                                                                                                                                                                                                                                                                  ", 
/* 1361:     */         
/* 1362:     */ 
/* 1363:1360 */         Font2));
/* 1364:1361 */       cell103.setColspan(2);
/* 1365:1362 */       cell103.setBorderWidthRight(0.0F);
/* 1366:1363 */       cell103.setBorderWidthLeft(0.0F);
/* 1367:1364 */       cell103.setBorderWidthTop(0.5F);
/* 1368:1365 */       cell103.setBorderWidthBottom(0.0F);
/* 1369:1366 */       cell103.setBorderColorTop(BaseColor.WHITE);
/* 1370:     */       
/* 1371:1368 */       PdfPCell cell104 = new PdfPCell(new Paragraph("RETAILER DETAIL", Font4));
/* 1372:1369 */       cell104.setUseBorderPadding(true);
/* 1373:1370 */       cell104.setColspan(2);
/* 1374:1371 */       cell104.setBorderWidthRight(0.1F);
/* 1375:1372 */       cell104.setBorderWidthLeft(0.1F);
/* 1376:1373 */       cell104.setBorderWidthTop(0.1F);
/* 1377:1374 */       cell104.setBorderWidthBottom(0.1F);
/* 1378:1375 */       cell104.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1379:1376 */       cell104.setBackgroundColor(new BaseColor(0, 59, 119));
/* 1380:     */       
/* 1381:1378 */       table1.addCell(cell101);
/* 1382:1379 */       table1.addCell(cell102);
/* 1383:1380 */       table1.addCell(cell103);
/* 1384:1381 */       table1.addCell(cell104);
/* 1385:1382 */       document.add(table1);
/* 1386:1388 */       while (this.resultSet.next())
/* 1387:     */       {
/* 1388:1389 */         stringBuffer = new StringBuffer();
/* 1389:1390 */         PdfPTable table = new PdfPTable(2);
/* 1390:1391 */         table.setFooterRows(1);
/* 1391:1392 */         table.setWidthPercentage(100.0F);
/* 1392:1393 */         Rectangle rect = new Rectangle(300.0F, 700.0F);
/* 1393:1394 */         table.setWidthPercentage(new float[] { 80.0F, 220.0F }, rect);
/* 1394:     */         
/* 1395:1396 */         PdfPCell cell = new PdfPCell(new Paragraph());
/* 1396:1397 */         cell.setColspan(2);
/* 1397:1398 */         cell.setBorderWidthRight(0.1F);
/* 1398:1399 */         cell.setBorderWidthLeft(0.1F);
/* 1399:1400 */         cell.setBorderWidthTop(0.1F);
/* 1400:1401 */         cell.setBorderWidthBottom(0.2F);
/* 1401:1402 */         cell.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1402:1403 */         cell.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1403:     */         
/* 1404:1405 */         PdfPCell cell1 = new PdfPCell(new Paragraph());
/* 1405:1406 */         cell1.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1406:1407 */         cell1.setBorderWidth(0.01F);
/* 1407:1408 */         cell1.setBorderColor(BaseColor.WHITE);
/* 1408:     */         
/* 1409:1410 */         PdfPCell cell2 = new PdfPCell(new Paragraph());
/* 1410:1411 */         cell2.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1411:1412 */         cell2.setBorderWidth(0.2F);
/* 1412:1413 */         cell2.setBorderColor(BaseColor.WHITE);
/* 1413:     */         
/* 1414:1415 */         PdfPCell cell3 = new PdfPCell(new Paragraph("Retailer Id", 
/* 1415:1416 */           mainContent));
/* 1416:1417 */         cell3.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1417:1418 */         cell3.setBorderWidth(0.01F);
/* 1418:1419 */         cell3.setBorderColor(BaseColor.WHITE);
/* 1419:     */         
/* 1420:1421 */         PdfPCell cell4 = new PdfPCell(new Paragraph(this.resultSet.getString("REG_CUSTOMER_ID"), mainContent));
/* 1421:1422 */         cell4.setBorderWidth(0.2F);
/* 1422:1423 */         cell4.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1423:     */         
/* 1424:1425 */         PdfPCell cell5 = new PdfPCell(new Paragraph(
/* 1425:1426 */           "Salutation", mainContent));
/* 1426:1427 */         cell5.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1427:1428 */         cell5.setBorderWidth(0.01F);
/* 1428:1429 */         cell5.setBorderColor(BaseColor.WHITE);
/* 1429:     */         
/* 1430:     */ 
/* 1431:1432 */         PdfPCell cell6 = new PdfPCell(new Paragraph(this.resultSet.getString("REG_SALUTATION"), mainContent));
/* 1432:1433 */         cell6.setBorderWidth(0.2F);
/* 1433:1434 */         cell6.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1434:     */         
/* 1435:1436 */         PdfPCell cell7 = new PdfPCell(new Paragraph("Full name", 
/* 1436:1437 */           mainContent));
/* 1437:1438 */         cell7.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1438:1439 */         cell7.setBorderWidth(0.01F);
/* 1439:1440 */         cell7.setBorderColor(BaseColor.WHITE);
/* 1440:     */         
/* 1441:1442 */         PdfPCell cell8 = new PdfPCell(new Paragraph(
/* 1442:1443 */           this.resultSet.getString("REG_FULL_NAME"), mainContent));
/* 1443:1444 */         cell8.setBorderWidth(0.2F);
/* 1444:1445 */         cell8.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1445:     */         
/* 1446:     */ 
/* 1447:     */ 
/* 1448:1449 */         PdfPCell cell9 = new PdfPCell(new Paragraph("DOB", 
/* 1449:1450 */           mainContent));
/* 1450:1451 */         cell9.setBorderWidth(0.2F);
/* 1451:1452 */         cell9.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1452:     */         
/* 1453:1454 */         PdfPCell cell10 = new PdfPCell(new Paragraph(
/* 1454:1455 */           this.resultSet.getString("REG_DATE_OF_BIRTH"), mainContent));
/* 1455:1456 */         cell10.setBorderWidth(0.2F);
/* 1456:1457 */         cell10.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1457:     */         
/* 1458:1459 */         PdfPCell cell11 = new PdfPCell(new Paragraph("Address", 
/* 1459:1460 */           mainContent));
/* 1460:1461 */         cell11.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1461:1462 */         cell11.setBorderWidth(0.01F);
/* 1462:1463 */         cell11.setBorderColor(BaseColor.WHITE);
/* 1463:     */         
/* 1464:1465 */         PdfPCell cell12 = new PdfPCell(new Paragraph(this.resultSet.getString("REG_ADDRESS_LINE_1"), mainContent));
/* 1465:1466 */         cell12.setBorderWidth(0.2F);
/* 1466:1467 */         cell12.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1467:     */         
/* 1468:1469 */         PdfPCell cell13 = new PdfPCell(new Paragraph("Alternative Address", 
/* 1469:1470 */           mainContent));
/* 1470:1471 */         cell13.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1471:1472 */         cell13.setBorderWidth(0.01F);
/* 1472:1473 */         cell13.setBorderColor(BaseColor.WHITE);
/* 1473:     */         
/* 1474:1475 */         PdfPCell cell14 = new PdfPCell(new Paragraph(this.resultSet.getString("REG_ADDRESS_LINE_2"), mainContent));
/* 1475:1476 */         cell14.setBorderWidth(0.2F);
/* 1476:1477 */         cell14.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1477:     */         
/* 1478:1479 */         PdfPCell cell15 = new PdfPCell(new Paragraph(
/* 1479:1480 */           "City", mainContent));
/* 1480:1481 */         cell15.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1481:1482 */         cell15.setBorderWidth(0.01F);
/* 1482:1483 */         cell15.setBorderColor(BaseColor.WHITE);
/* 1483:     */         
/* 1484:1485 */         PdfPCell cell16 = new PdfPCell(new Paragraph(this.nameHelper.getCityNameByCityId(this.resultSet.getInt("REG_CITY")), mainContent));
/* 1485:1486 */         cell16.setBorderWidth(0.2F);
/* 1486:1487 */         cell16.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1487:     */         
/* 1488:1489 */         PdfPCell cell17 = new PdfPCell(new Paragraph("State", 
/* 1489:1490 */           mainContent));
/* 1490:1491 */         cell17.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1491:1492 */         cell17.setBorderWidth(0.01F);
/* 1492:1493 */         cell17.setBorderColor(BaseColor.WHITE);
/* 1493:     */         
/* 1494:1495 */         PdfPCell cell18 = new PdfPCell(new Paragraph(this.nameHelper.getStateNameByStateId(this.resultSet.getInt("REG_STATE")), mainContent));
/* 1495:1496 */         cell18.setBorderWidth(0.2F);
/* 1496:1497 */         cell18.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1497:     */         
/* 1498:1499 */         PdfPCell cell19 = new PdfPCell(new Paragraph("Pincode", 
/* 1499:1500 */           mainContent));
/* 1500:1501 */         cell19.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1501:1502 */         cell19.setBorderWidth(0.01F);
/* 1502:1503 */         cell19.setBorderColor(BaseColor.WHITE);
/* 1503:     */         
/* 1504:1505 */         PdfPCell cell20 = new PdfPCell(new Paragraph(this.resultSet.getString("REG_PINCODE"), mainContent));
/* 1505:1506 */         cell20.setBorderWidth(0.2F);
/* 1506:1507 */         cell20.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1507:     */         
/* 1508:1509 */         PdfPCell cell21 = new PdfPCell(new Paragraph("Primary Mail", 
/* 1509:1510 */           mainContent));
/* 1510:1511 */         cell21.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1511:1512 */         cell21.setBorderWidth(0.01F);
/* 1512:1513 */         cell21.setBorderColor(BaseColor.WHITE);
/* 1513:     */         
/* 1514:1515 */         PdfPCell cell22 = new PdfPCell(new Paragraph(this.resultSet.getString("REG_PRIMARY_MAIL_ID"), mainContent));
/* 1515:1516 */         cell22.setBorderWidth(0.2F);
/* 1516:1517 */         cell22.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1517:     */         
/* 1518:1519 */         PdfPCell cell23 = new PdfPCell(new Paragraph(
/* 1519:1520 */           "Alternative Mail Id", mainContent));
/* 1520:1521 */         cell23.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1521:1522 */         cell23.setBorderWidth(0.01F);
/* 1522:1523 */         cell23.setBorderColor(BaseColor.WHITE);
/* 1523:     */         
/* 1524:1525 */         PdfPCell cell24 = new PdfPCell(
/* 1525:1526 */           new Paragraph(this.resultSet.getString(
/* 1526:1527 */           "REG_ALTERNATE_MAIL_ID"), 
/* 1527:1528 */           mainContent));
/* 1528:1529 */         cell24.setBorderWidth(0.2F);
/* 1529:1530 */         cell24.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1530:     */         
/* 1531:1532 */         PdfPCell cell25 = new PdfPCell(new Paragraph("Phone No", 
/* 1532:1533 */           mainContent));
/* 1533:1534 */         cell25.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1534:1535 */         cell25.setBorderWidth(0.01F);
/* 1535:1536 */         cell25.setBorderColor(BaseColor.WHITE);
/* 1536:     */         
/* 1537:1538 */         PdfPCell cell26 = new PdfPCell(new Paragraph(
/* 1538:1539 */           this.resultSet.getString("REG_PHONE_NO"), mainContent));
/* 1539:1540 */         cell26.setBorderWidth(0.2F);
/* 1540:1541 */         cell26.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1541:     */         
/* 1542:1543 */         PdfPCell cell27 = new PdfPCell(new Paragraph("Mobile No", 
/* 1543:1544 */           mainContent));
/* 1544:1545 */         cell27.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1545:1546 */         cell27.setBorderWidth(0.01F);
/* 1546:1547 */         cell27.setBorderColor(BaseColor.WHITE);
/* 1547:     */         
/* 1548:1549 */         PdfPCell cell28 = new PdfPCell(new Paragraph(
/* 1549:1550 */           this.resultSet
/* 1550:1551 */           .getString("REG_MOBILE_NO"), mainContent));
/* 1551:1552 */         cell28.setBorderWidth(0.2F);
/* 1552:1553 */         cell28.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1553:     */         
/* 1554:1555 */         PdfPCell cell29 = new PdfPCell(new Paragraph(
/* 1555:1556 */           "Fax No", mainContent));
/* 1556:1557 */         cell29.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1557:1558 */         cell29.setBorderWidth(0.01F);
/* 1558:1559 */         cell29.setBorderColor(BaseColor.WHITE);
/* 1559:     */         
/* 1560:1561 */         PdfPCell cell30 = new PdfPCell(new Paragraph(
/* 1561:1562 */           this.resultSet
/* 1562:1563 */           .getString("REG_FAX_NO"), 
/* 1563:1564 */           mainContent));
/* 1564:1565 */         cell30.setBorderWidth(0.2F);
/* 1565:1566 */         cell30.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1566:     */         
/* 1567:1568 */         PdfPCell cell31 = new PdfPCell(new Paragraph(
/* 1568:1569 */           "Social Mail Id", mainContent));
/* 1569:1570 */         cell31.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1570:1571 */         cell31.setBorderWidth(0.01F);
/* 1571:1572 */         cell31.setBorderColor(BaseColor.WHITE);
/* 1572:     */         
/* 1573:1574 */         PdfPCell cell32 = new PdfPCell(new Paragraph(
/* 1574:1575 */           this.resultSet
/* 1575:1576 */           .getString("REG_SOCIAL_IM_ID"), 
/* 1576:1577 */           mainContent));
/* 1577:1578 */         cell32.setBorderWidth(0.2F);
/* 1578:1579 */         cell32.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1579:     */         
/* 1580:1581 */         PdfPCell cell33 = new PdfPCell(new Paragraph(
/* 1581:1582 */           "Creation Date", mainContent));
/* 1582:1583 */         cell33.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1583:1584 */         cell33.setBorderWidth(0.01F);
/* 1584:1585 */         cell33.setBorderColor(BaseColor.WHITE);
/* 1585:     */         
/* 1586:1587 */         PdfPCell cell34 = new PdfPCell(new Paragraph(
/* 1587:1588 */           this.resultSet
/* 1588:1589 */           .getString("REG_CREATION_DATE"), 
/* 1589:1590 */           mainContent));
/* 1590:1591 */         cell34.setBorderWidth(0.2F);
/* 1591:1592 */         cell34.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1592:     */         
/* 1593:1594 */         PdfPCell cell35 = new PdfPCell(new Paragraph(
/* 1594:1595 */           "Updation Date", mainContent));
/* 1595:1596 */         cell35.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1596:1597 */         cell35.setBorderWidth(0.01F);
/* 1597:1598 */         cell35.setBorderColor(BaseColor.WHITE);
/* 1598:     */         
/* 1599:1600 */         PdfPCell cell36 = new PdfPCell(new Paragraph(
/* 1600:1601 */           this.resultSet
/* 1601:1602 */           .getString("REG_CREATION_DATE"), 
/* 1602:1603 */           mainContent));
/* 1603:1604 */         cell36.setBorderWidth(0.2F);
/* 1604:1605 */         cell36.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1605:     */         
/* 1606:1607 */         PdfPCell cell37 = new PdfPCell(new Paragraph());
/* 1607:1608 */         cell37.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1608:1609 */         cell37.setBorderWidth(0.2F);
/* 1609:1610 */         cell37.setBorderColor(BaseColor.WHITE);
/* 1610:     */         
/* 1611:1612 */         PdfPCell cell38 = new PdfPCell(new Paragraph());
/* 1612:1613 */         cell38.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1613:1614 */         cell38.setBorderWidth(0.2F);
/* 1614:1615 */         cell38.setBorderColor(BaseColor.WHITE);
/* 1615:     */         
/* 1616:     */ 
/* 1617:1618 */         PdfPCell cell39 = new PdfPCell(new Paragraph("Created By", 
/* 1618:1619 */           mainContent));
/* 1619:1620 */         cell39.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1620:1621 */         cell39.setBorderWidth(0.01F);
/* 1621:1622 */         cell39.setBorderColor(BaseColor.WHITE);
/* 1622:     */         
/* 1623:1624 */         PdfPCell cell40 = new PdfPCell(new Paragraph(
/* 1624:1625 */           this.resultSet.getString("REG_CREATED_BY"), mainContent));
/* 1625:1626 */         cell40.setBorderWidth(0.2F);
/* 1626:1627 */         cell40.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1627:     */         
/* 1628:1629 */         PdfPCell cell41 = new PdfPCell(new Paragraph("Updated By", 
/* 1629:1630 */           mainContent));
/* 1630:1631 */         cell41.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1631:1632 */         cell41.setBorderWidth(0.01F);
/* 1632:1633 */         cell41.setBorderColor(BaseColor.WHITE);
/* 1633:     */         
/* 1634:1635 */         PdfPCell cell42 = new PdfPCell(new Paragraph(
/* 1635:1636 */           this.resultSet.getString("REG_CREATED_BY"), mainContent));
/* 1636:1637 */         cell42.setBorderWidth(0.2F);
/* 1637:1638 */         cell42.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1638:     */         
/* 1639:1640 */         PdfPCell cell43 = new PdfPCell(new Paragraph("Work Location", 
/* 1640:1641 */           mainContent));
/* 1641:1642 */         cell43.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1642:1643 */         cell43.setBorderWidth(0.01F);
/* 1643:1644 */         cell43.setBorderColor(BaseColor.WHITE);
/* 1644:     */         
/* 1645:1646 */         PdfPCell cell44 = new PdfPCell(new Paragraph(
/* 1646:1647 */           this.resultSet.getString("REG_WORK_LOCATION"), mainContent));
/* 1647:1648 */         cell44.setBorderWidth(0.2F);
/* 1648:1649 */         cell44.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1649:     */         
/* 1650:1651 */         PdfPCell cell45 = new PdfPCell(new Paragraph("Currency", 
/* 1651:1652 */           mainContent));
/* 1652:1653 */         cell45.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1653:1654 */         cell45.setBorderWidth(0.01F);
/* 1654:1655 */         cell45.setBorderColor(BaseColor.WHITE);
/* 1655:     */         
/* 1656:1657 */         PdfPCell cell46 = new PdfPCell(new Paragraph(
/* 1657:1658 */           this.resultSet.getString("REG_REF_CURRENCY"), mainContent));
/* 1658:1659 */         cell46.setBorderWidth(0.2F);
/* 1659:1660 */         cell46.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1660:     */         
/* 1661:1662 */         PdfPCell cell47 = new PdfPCell(new Paragraph("Contact Person", 
/* 1662:1663 */           mainContent));
/* 1663:1664 */         cell47.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1664:1665 */         cell47.setBorderWidth(0.01F);
/* 1665:1666 */         cell47.setBorderColor(BaseColor.WHITE);
/* 1666:     */         
/* 1667:1668 */         PdfPCell cell48 = new PdfPCell(new Paragraph(this.resultSet.getString("REG_CONTACT_PERSON"), mainContent));
/* 1668:1669 */         cell48.setBorderWidth(0.2F);
/* 1669:1670 */         cell48.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1670:     */         
/* 1671:1672 */         PdfPCell cell49 = new PdfPCell(new Paragraph("Phone No", 
/* 1672:1673 */           mainContent));
/* 1673:1674 */         cell49.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1674:1675 */         cell49.setBorderWidth(0.01F);
/* 1675:1676 */         cell49.setBorderColor(BaseColor.WHITE);
/* 1676:     */         
/* 1677:1678 */         PdfPCell cell50 = new PdfPCell(new Paragraph(
/* 1678:1679 */           this.resultSet.getString("REG_PHONE_NO2"), mainContent));
/* 1679:1680 */         cell50.setBorderWidth(0.2F);
/* 1680:1681 */         cell50.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1681:     */         
/* 1682:1683 */         PdfPCell cell51 = new PdfPCell(new Paragraph("Mobile No", 
/* 1683:1684 */           mainContent));
/* 1684:1685 */         cell51.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1685:1686 */         cell51.setBorderWidth(0.01F);
/* 1686:1687 */         cell51.setBorderColor(BaseColor.WHITE);
/* 1687:     */         
/* 1688:1689 */         PdfPCell cell52 = new PdfPCell(new Paragraph(
/* 1689:1690 */           this.resultSet.getString("REG_MOBILE_NO2"), mainContent));
/* 1690:1691 */         cell52.setBorderWidth(0.2F);
/* 1691:1692 */         cell52.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1692:     */         
/* 1693:1694 */         PdfPCell cell53 = new PdfPCell(new Paragraph("FAX ISD", 
/* 1694:1695 */           mainContent));
/* 1695:1696 */         cell53.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1696:1697 */         cell53.setBorderWidth(0.01F);
/* 1697:1698 */         cell53.setBorderColor(BaseColor.WHITE);
/* 1698:     */         
/* 1699:1700 */         PdfPCell cell54 = new PdfPCell(new Paragraph(
/* 1700:1701 */           this.resultSet.getString("REG_FAX_ISD"), mainContent));
/* 1701:1702 */         cell54.setBorderWidth(0.2F);
/* 1702:1703 */         cell54.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1703:     */         
/* 1704:1705 */         PdfPCell cell55 = new PdfPCell(new Paragraph(
/* 1705:1706 */           "FAX STD", mainContent));
/* 1706:1707 */         cell55.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1707:1708 */         cell55.setBorderWidth(0.01F);
/* 1708:1709 */         cell55.setBorderColor(BaseColor.WHITE);
/* 1709:     */         
/* 1710:1711 */         PdfPCell cell56 = new PdfPCell(new Paragraph(
/* 1711:1712 */           this.resultSet.getString("REG_FAX_STD"), mainContent));
/* 1712:1713 */         cell56.setBorderWidth(0.2F);
/* 1713:1714 */         cell56.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1714:     */         
/* 1715:1716 */         PdfPCell cell57 = new PdfPCell(new Paragraph(
/* 1716:1717 */           "Country", mainContent));
/* 1717:1718 */         cell57.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1718:1719 */         cell57.setBorderWidth(0.01F);
/* 1719:1720 */         cell57.setBorderColor(BaseColor.WHITE);
/* 1720:     */         
/* 1721:1722 */         PdfPCell cell58 = new PdfPCell(new Paragraph(
/* 1722:1723 */           this.resultSet.getString("REG_COUNTRY"), 
/* 1723:1724 */           mainContent));
/* 1724:1725 */         cell58.setBorderWidth(0.2F);
/* 1725:1726 */         cell58.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1726:     */         
/* 1727:1728 */         PdfPCell cell59 = new PdfPCell(new Paragraph(
/* 1728:1729 */           "Phone ISD", mainContent));
/* 1729:1730 */         cell59.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1730:1731 */         cell59.setBorderWidth(0.01F);
/* 1731:1732 */         cell59.setBorderColor(BaseColor.WHITE);
/* 1732:     */         
/* 1733:1734 */         PdfPCell cell60 = new PdfPCell(new Paragraph(
/* 1734:1735 */           this.resultSet.getString("REG_PHONE_ISD"), 
/* 1735:1736 */           mainContent));
/* 1736:1737 */         cell60.setBorderWidth(0.2F);
/* 1737:1738 */         cell60.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1738:     */         
/* 1739:1740 */         PdfPCell cell61 = new PdfPCell(new Paragraph(
/* 1740:1741 */           "STD", mainContent));
/* 1741:1742 */         cell61.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1742:1743 */         cell61.setBorderWidth(0.01F);
/* 1743:1744 */         cell61.setBorderColor(BaseColor.WHITE);
/* 1744:     */         
/* 1745:1746 */         PdfPCell cell62 = new PdfPCell(new Paragraph(
/* 1746:1747 */           this.resultSet.getString("REG_PHONE_STD"), 
/* 1747:1748 */           mainContent));
/* 1748:1749 */         cell62.setBorderWidth(0.2F);
/* 1749:1750 */         cell62.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1750:     */         
/* 1751:1752 */         PdfPCell cell63 = new PdfPCell(new Paragraph(
/* 1752:1753 */           "Alternative ISD", mainContent));
/* 1753:1754 */         cell63.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1754:1755 */         cell63.setBorderWidth(0.01F);
/* 1755:1756 */         cell63.setBorderColor(BaseColor.WHITE);
/* 1756:     */         
/* 1757:1758 */         PdfPCell cell64 = new PdfPCell(new Paragraph(
/* 1758:1759 */           this.resultSet.getString("REG_PHONE_ISD2"), 
/* 1759:1760 */           mainContent));
/* 1760:1761 */         cell64.setBorderWidth(0.2F);
/* 1761:1762 */         cell64.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1762:     */         
/* 1763:1764 */         PdfPCell cell65 = new PdfPCell(new Paragraph(
/* 1764:1765 */           "Alternative STD", mainContent));
/* 1765:1766 */         cell65.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1766:1767 */         cell65.setBorderWidth(0.01F);
/* 1767:1768 */         cell65.setBorderColor(BaseColor.WHITE);
/* 1768:     */         
/* 1769:1770 */         PdfPCell cell66 = new PdfPCell(new Paragraph(
/* 1770:1771 */           this.resultSet.getString("REG_PHONE_STD2"), 
/* 1771:1772 */           mainContent));
/* 1772:1773 */         cell66.setBorderWidth(0.2F);
/* 1773:1774 */         cell66.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1774:     */         
/* 1775:1776 */         PdfPCell cell67 = new PdfPCell(new Paragraph(
/* 1776:1777 */           "Mobile ISD", mainContent));
/* 1777:1778 */         cell67.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1778:1779 */         cell67.setBorderWidth(0.01F);
/* 1779:1780 */         cell67.setBorderColor(BaseColor.WHITE);
/* 1780:     */         
/* 1781:1782 */         PdfPCell cell68 = new PdfPCell(new Paragraph(
/* 1782:1783 */           this.resultSet.getString("REG_MOBILE_ISD1"), 
/* 1783:1784 */           mainContent));
/* 1784:1785 */         cell68.setBorderWidth(0.2F);
/* 1785:1786 */         cell68.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1786:     */         
/* 1787:1788 */         PdfPCell cell69 = new PdfPCell(new Paragraph(
/* 1788:1789 */           "Alternative Mobile ISD", mainContent));
/* 1789:1790 */         cell69.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1790:1791 */         cell69.setBorderWidth(0.01F);
/* 1791:1792 */         cell69.setBorderColor(BaseColor.WHITE);
/* 1792:     */         
/* 1793:1794 */         PdfPCell cell70 = new PdfPCell(new Paragraph(
/* 1794:1795 */           this.resultSet.getString("REG_MOBILE_ISD2"), 
/* 1795:1796 */           mainContent));
/* 1796:1797 */         cell70.setBorderWidth(0.2F);
/* 1797:1798 */         cell70.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1798:     */         
/* 1799:1800 */         PdfPCell cell71 = new PdfPCell(new Paragraph(
/* 1800:1801 */           "Website", mainContent));
/* 1801:1802 */         cell71.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1802:1803 */         cell71.setBorderWidth(0.01F);
/* 1803:1804 */         cell71.setBorderColor(BaseColor.WHITE);
/* 1804:     */         
/* 1805:1806 */         PdfPCell cell72 = new PdfPCell(new Paragraph(
/* 1806:1807 */           this.resultSet.getString("REG_HOME_WEBSITE"), 
/* 1807:1808 */           mainContent));
/* 1808:1809 */         cell72.setBorderWidth(0.2F);
/* 1809:1810 */         cell72.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1810:     */         
/* 1811:1812 */         PdfPCell cell73 = new PdfPCell(new Paragraph(
/* 1812:1813 */           "Reffered by", mainContent));
/* 1813:1814 */         cell73.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1814:1815 */         cell73.setBorderWidth(0.01F);
/* 1815:1816 */         cell73.setBorderColor(BaseColor.WHITE);
/* 1816:     */         
/* 1817:1818 */         PdfPCell cell74 = new PdfPCell(new Paragraph(
/* 1818:1819 */           this.resultSet.getString("REG_REFFERED_BY"), 
/* 1819:1820 */           mainContent));
/* 1820:1821 */         cell74.setBorderWidth(0.2F);
/* 1821:1822 */         cell74.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1822:     */         
/* 1823:1824 */         PdfPCell cell75 = new PdfPCell(new Paragraph(
/* 1824:1825 */           "Discription", mainContent));
/* 1825:1826 */         cell75.setBackgroundColor(new BaseColor(238, 238, 238));
/* 1826:1827 */         cell75.setBorderWidth(0.01F);
/* 1827:1828 */         cell75.setBorderColor(BaseColor.WHITE);
/* 1828:     */         
/* 1829:1830 */         PdfPCell cell76 = new PdfPCell(new Paragraph(
/* 1830:1831 */           this.resultSet.getString("REG_PROFILE_DISC"), 
/* 1831:1832 */           mainContent));
/* 1832:1833 */         cell76.setBorderWidth(0.2F);
/* 1833:1834 */         cell76.setBorderColor(BaseColor.LIGHT_GRAY);
/* 1834:     */         
/* 1835:     */ 
/* 1836:     */ 
/* 1837:     */ 
/* 1838:1839 */         System.out.println(this.resultSet.getString("REG_COUNTRY") + " " + this.resultSet.getString("REG_MOBILE_NO") + "ccccccccc");
/* 1839:     */         
/* 1840:1841 */         table.addCell(cell);
/* 1841:1842 */         table.addCell(cell1);
/* 1842:1843 */         table.addCell(cell2);
/* 1843:1844 */         table.addCell(cell3);
/* 1844:1845 */         table.addCell(cell4);
/* 1845:1846 */         table.addCell(cell5);
/* 1846:1847 */         table.addCell(cell6);
/* 1847:1848 */         table.addCell(cell7);
/* 1848:1849 */         table.addCell(cell8);
/* 1849:1850 */         table.addCell(cell9);
/* 1850:1851 */         table.addCell(cell10);
/* 1851:1852 */         table.addCell(cell11);
/* 1852:1853 */         table.addCell(cell12);
/* 1853:1854 */         table.addCell(cell13);
/* 1854:1855 */         table.addCell(cell14);
/* 1855:1856 */         table.addCell(cell15);
/* 1856:1857 */         table.addCell(cell16);
/* 1857:1858 */         table.addCell(cell17);
/* 1858:1859 */         table.addCell(cell18);
/* 1859:1860 */         table.addCell(cell19);
/* 1860:1861 */         table.addCell(cell20);
/* 1861:1862 */         table.addCell(cell21);
/* 1862:1863 */         table.addCell(cell22);
/* 1863:1864 */         table.addCell(cell23);
/* 1864:1865 */         table.addCell(cell24);
/* 1865:1866 */         table.addCell(cell25);
/* 1866:1867 */         table.addCell(cell26);
/* 1867:1868 */         table.addCell(cell27);
/* 1868:1869 */         table.addCell(cell28);
/* 1869:1870 */         table.addCell(cell29);
/* 1870:1871 */         table.addCell(cell30);
/* 1871:1872 */         table.addCell(cell31);
/* 1872:1873 */         table.addCell(cell32);
/* 1873:1874 */         table.addCell(cell33);
/* 1874:1875 */         table.addCell(cell34);
/* 1875:1876 */         table.addCell(cell35);
/* 1876:1877 */         table.addCell(cell36);
/* 1877:1878 */         table.addCell(cell37);
/* 1878:1879 */         table.addCell(cell38);
/* 1879:1880 */         table.addCell(cell39);
/* 1880:1881 */         table.addCell(cell40);
/* 1881:1882 */         table.addCell(cell41);
/* 1882:1883 */         table.addCell(cell42);
/* 1883:1884 */         table.addCell(cell43);
/* 1884:1885 */         table.addCell(cell44);
/* 1885:1886 */         table.addCell(cell45);
/* 1886:1887 */         table.addCell(cell46);
/* 1887:1888 */         table.addCell(cell47);
/* 1888:1889 */         table.addCell(cell48);
/* 1889:1890 */         table.addCell(cell49);
/* 1890:1891 */         table.addCell(cell50);
/* 1891:1892 */         table.addCell(cell51);
/* 1892:1893 */         table.addCell(cell52);
/* 1893:1894 */         table.addCell(cell53);
/* 1894:1895 */         table.addCell(cell54);
/* 1895:1896 */         table.addCell(cell55);
/* 1896:1897 */         table.addCell(cell56);
/* 1897:1898 */         table.addCell(cell57);
/* 1898:1899 */         table.addCell(cell58);
/* 1899:1900 */         table.addCell(cell59);
/* 1900:1901 */         table.addCell(cell60);
/* 1901:1902 */         table.addCell(cell61);
/* 1902:1903 */         table.addCell(cell62);
/* 1903:1904 */         table.addCell(cell63);
/* 1904:1905 */         table.addCell(cell64);
/* 1905:1906 */         table.addCell(cell65);
/* 1906:1907 */         table.addCell(cell66);
/* 1907:1908 */         table.addCell(cell67);
/* 1908:1909 */         table.addCell(cell68);
/* 1909:1910 */         table.addCell(cell69);
/* 1910:1911 */         table.addCell(cell70);
/* 1911:1912 */         table.addCell(cell71);
/* 1912:1913 */         table.addCell(cell72);
/* 1913:1914 */         table.addCell(cell73);
/* 1914:1915 */         table.addCell(cell74);
/* 1915:1916 */         table.addCell(cell75);
/* 1916:1917 */         table.addCell(cell76);
/* 1917:     */         
/* 1918:     */ 
/* 1919:     */ 
/* 1920:     */ 
/* 1921:     */ 
/* 1922:1923 */         document.add(table);
/* 1923:     */       }
/* 1924:1927 */       document.add(new Paragraph("\n"));
/* 1925:     */       
/* 1926:     */ 
/* 1927:     */ 
/* 1928:1931 */       document.close();
/* 1929:     */     }
/* 1930:     */     catch (SQLException sqlExp)
/* 1931:     */     {
/* 1932:1934 */       sqlExp.printStackTrace();
/* 1933:1935 */       logger.error(
/* 1934:1936 */         RetailerCustomerDaoImpl.class + 
/* 1935:1937 */         "Error: Occur in Query While Fetching All Retailer detail for print PdF from Database.", 
/* 1936:1938 */         sqlExp);
/* 1937:     */     }
/* 1938:     */     catch (Exception exception)
/* 1939:     */     {
/* 1940:1940 */       exception.printStackTrace();
/* 1941:1941 */       logger.error(
/* 1942:1942 */         RetailerCustomerDaoImpl.class + 
/* 1943:1943 */         "Error: Occur in Query While Closing Connection After Fetching All Retailer details for print PdF from Database.", 
/* 1944:1944 */         exception);
/* 1945:     */     }
/* 1946:     */     finally
/* 1947:     */     {
/* 1948:1946 */       JdbcHelper.closeResultSet(this.resultSet);
/* 1949:1947 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/* 1950:1948 */       JdbcHelper.closeConnection(this.connection);
/* 1951:     */     }
/* 1952:     */   }
/* 1953:     */   
/* 1954:     */   public List<RetailerCustomerVO> retriveRetailerDetailsForAdvanceSearch(int searchId, String searchValue)
/* 1955:     */   {
/* 1956:1955 */     List<RetailerCustomerVO> retailerDetailList = new ArrayList();
/* 1957:1956 */     Connection connections = null;
/* 1958:1957 */     PreparedStatement preparedStatements = null;
/* 1959:1958 */     ResultSet resultSets = null;
/* 1960:     */     try
/* 1961:     */     {
/* 1962:1960 */       System.out.println(searchValue + "ggggggggshsksskjj");
/* 1963:1961 */       connections = getConnection();
/* 1964:1962 */       preparedStatements = connections
/* 1965:1963 */         .prepareStatement(
/* 1966:1964 */         QueryBuilder.RetailerDetailAdvanceSearch(searchId, searchValue));
/* 1967:     */       
/* 1968:1966 */       resultSets = preparedStatements.executeQuery();
/* 1969:1970 */       while (resultSets.next())
/* 1970:     */       {
/* 1971:1971 */         this.retailerCustomerVO = new RetailerCustomerVO();
/* 1972:1972 */         this.retailerCustomerVO.setCustomerId(resultSets.getInt("REG_CUSTOMER_ID"));
/* 1973:     */         
/* 1974:     */ 
/* 1975:     */ 
/* 1976:1976 */         this.retailerCustomerVO.setFullName(resultSets.getString("REG_FULL_NAME"));
/* 1977:     */         
/* 1978:1978 */         this.retailerCustomerVO.setDob(resultSets
/* 1979:1979 */           .getString("REG_DATE_OF_BIRTH"));
/* 1980:     */         
/* 1981:1981 */         this.retailerCustomerVO.setAddress1(resultSets
/* 1982:1982 */           .getString("REG_ADDRESS_LINE_1"));
/* 1983:     */         
/* 1984:1984 */         this.retailerCustomerVO.setAddress2(resultSets
/* 1985:1985 */           .getString("REG_ADDRESS_LINE_2"));
/* 1986:     */         
/* 1987:     */ 
/* 1988:1988 */         this.retailerCustomerVO.setCity(this.nameHelper.getCityNameByCityId(resultSets.getInt("REG_CITY")));
/* 1989:     */         
/* 1990:1990 */         this.retailerCustomerVO.setState(this.nameHelper.getStateNameByStateId(resultSets.getInt("REG_STATE")));
/* 1991:     */         
/* 1992:1992 */         this.retailerCustomerVO.setPhoneNo(resultSets
/* 1993:1993 */           .getString("REG_PHONE_NO"));
/* 1994:     */         
/* 1995:1995 */         this.retailerCustomerVO.setMobileNo(resultSets
/* 1996:1996 */           .getString("REG_MOBILE_NO"));
/* 1997:     */         
/* 1998:1998 */         this.retailerCustomerVO.setPinCode(resultSets
/* 1999:1999 */           .getString("REG_PINCODE"));
/* 2000:     */         
/* 2001:2001 */         this.retailerCustomerVO.setPeimaryMailId(resultSets
/* 2002:2002 */           .getString("REG_PRIMARY_MAIL_ID"));
/* 2003:     */         
/* 2004:     */ 
/* 2005:2005 */         this.retailerCustomerVO.setAlternativeMail(resultSets
/* 2006:2006 */           .getString("REG_ALTERNATE_MAIL_ID"));
/* 2007:2007 */         this.retailerCustomerVO.setCreationDate(resultSets
/* 2008:2008 */           .getString("REG_CREATION_DATE"));
/* 2009:2009 */         this.retailerCustomerVO.setWorkLocation(resultSets
/* 2010:2010 */           .getString("REG_WORK_LOCATION"));
/* 2011:2011 */         this.retailerCustomerVO.setCreatedBy(resultSets
/* 2012:2012 */           .getString("REG_CREATED_BY"));
/* 2013:2013 */         System.out.println(resultSets.getString("REG_MOBILE_NO") + " " + resultSets.getString("REG_CITY") + "ggg" + this.retailerCustomerVO.getCity());
/* 2014:2014 */         retailerDetailList.add(this.retailerCustomerVO);
/* 2015:     */       }
/* 2016:     */     }
/* 2017:     */     catch (SQLException sqlExp)
/* 2018:     */     {
/* 2019:2018 */       sqlExp.printStackTrace();
/* 2020:2019 */       logger.error(
/* 2021:2020 */         RetailerCustomerDaoImpl.class + 
/* 2022:2021 */         "Error: Occur in Query While Fetching the retailer Details for search from Database.", 
/* 2023:2022 */         sqlExp);
/* 2024:     */     }
/* 2025:     */     catch (Exception exception)
/* 2026:     */     {
/* 2027:2024 */       exception.printStackTrace();
/* 2028:2025 */       logger.error(
/* 2029:2026 */         RetailerCustomerDaoImpl.class + 
/* 2030:2027 */         "Error: Occur in Query While Closing Connection After Fetching the retailer Details for search from Database.", 
/* 2031:2028 */         exception);
/* 2032:     */     }
/* 2033:     */     finally
/* 2034:     */     {
/* 2035:2030 */       JdbcHelper.closeResultSet(resultSets);
/* 2036:2031 */       JdbcHelper.closePreparedStatement(preparedStatements);
/* 2037:2032 */       JdbcHelper.closeConnection(connections);
/* 2038:     */     }
/* 2039:2034 */     return retailerDetailList;
/* 2040:     */   }
/* 2041:     */   
/* 2042:     */   public List<RetailerCustomerVO> retriveRetailerTransactionForAdvanceSearch(int searchId, String searchValue)
/* 2043:     */   {
/* 2044:2039 */     List<RetailerCustomerVO> retailerTransactionDetailList = new ArrayList();
/* 2045:     */     try
/* 2046:     */     {
/* 2047:2043 */       this.connection = getConnection();
/* 2048:     */       
/* 2049:2045 */       this.preparedStatement = this.connection
/* 2050:2046 */         .prepareStatement(
/* 2051:2047 */         QueryBuilder.RetailerTransactionAdvanceSearchForAdmin(searchId, searchValue));
/* 2052:     */       
/* 2053:     */ 
/* 2054:2050 */       this.resultSet = this.preparedStatement.executeQuery();
/* 2055:2054 */       while (this.resultSet.next())
/* 2056:     */       {
/* 2057:2055 */         this.retailerCustomerVO = new RetailerCustomerVO();
/* 2058:2056 */         this.retailerCustomerVO.setTransactionId(this.resultSet.getInt("CUSTOMER_TRANS_ID"));
/* 2059:     */         
/* 2060:     */ 
/* 2061:     */ 
/* 2062:     */ 
/* 2063:     */ 
/* 2064:2062 */         this.retailerCustomerVO.setDescription(this.resultSet
/* 2065:2063 */           .getString("CUSTOMER_TRANS_DISCRIPTION"));
/* 2066:     */         
/* 2067:2065 */         this.retailerCustomerVO.setTotal(this.resultSet
/* 2068:2066 */           .getFloat("CUSTOMER_TRANS_TOTAL"));
/* 2069:     */         
/* 2070:2068 */         this.retailerCustomerVO.setPaid(this.resultSet
/* 2071:2069 */           .getFloat("CUSTOMER_TRANS_PAID"));
/* 2072:     */         
/* 2073:     */ 
/* 2074:2072 */         this.retailerCustomerVO.setDue(this.resultSet
/* 2075:2073 */           .getFloat("CUSTOMER_TRANS_DUE"));
/* 2076:     */         
/* 2077:2075 */         this.retailerCustomerVO.setTotalPaid(this.resultSet
/* 2078:2076 */           .getFloat("CUSTOMER_TRANS_TOTAL_PAID"));
/* 2079:     */         
/* 2080:2078 */         this.retailerCustomerVO.setTotalDue(this.resultSet
/* 2081:2079 */           .getFloat("CUSTOMER_TRANS_TOTAL_DUE"));
/* 2082:     */         
/* 2083:2081 */         this.retailerCustomerVO.setTransactionDate(this.resultSet
/* 2084:2082 */           .getString("CUSTOMER_TRANS_DATE"));
/* 2085:     */         
/* 2086:2084 */         this.retailerCustomerVO.setRetailerId(this.resultSet
/* 2087:2085 */           .getInt("CUSTOMER_ID_RETAILER"));
/* 2088:     */         
/* 2089:     */ 
/* 2090:     */ 
/* 2091:     */ 
/* 2092:2090 */         this.retailerCustomerVO.setPaymentMode(this.resultSet
/* 2093:2091 */           .getString("CUSTOMER_TRANS_PAY_MODE"));
/* 2094:     */         
/* 2095:2093 */         retailerTransactionDetailList.add(this.retailerCustomerVO);
/* 2096:     */       }
/* 2097:     */     }
/* 2098:     */     catch (SQLException sqlExp)
/* 2099:     */     {
/* 2100:2097 */       sqlExp.printStackTrace();
/* 2101:2098 */       logger.error(
/* 2102:2099 */         RetailerCustomerDaoImpl.class + 
/* 2103:2100 */         "Error: Occur in Query While Fetching the retailer transaction Details for search from Database.", 
/* 2104:2101 */         sqlExp);
/* 2105:     */     }
/* 2106:     */     catch (Exception exception)
/* 2107:     */     {
/* 2108:2103 */       exception.printStackTrace();
/* 2109:2104 */       logger.error(
/* 2110:2105 */         RetailerCustomerDaoImpl.class + 
/* 2111:2106 */         "Error: Occur in Query While Closing Connection After Fetching the retailer transaction Details for search from Database.", 
/* 2112:2107 */         exception);
/* 2113:     */     }
/* 2114:     */     finally
/* 2115:     */     {
/* 2116:2109 */       JdbcHelper.closeResultSet(this.resultSet);
/* 2117:2110 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/* 2118:2111 */       JdbcHelper.closeConnection(this.connection);
/* 2119:     */     }
/* 2120:2113 */     return retailerTransactionDetailList;
/* 2121:     */   }
/* 2122:     */   
/* 2123:     */   public int getRetailerLastRecord()
/* 2124:     */     throws RecordNotFoundException
/* 2125:     */   {
/* 2126:2117 */     int temp = 0;
/* 2127:     */     try
/* 2128:     */     {
/* 2129:2119 */       this.connection = getConnection();
/* 2130:2120 */       this.preparedStatement = this.connection
/* 2131:2121 */         .prepareStatement("SELECT  REG_CUSTOMER_ID FROM TAB_REGULAR_CUSTOMER WHERE REG_CUSTOMER_STATUS='ACTIVE' GROUP BY REG_CUSTOMER_ID DESC LIMIT 1");
/* 2132:2122 */       this.resultSet = this.preparedStatement.executeQuery();
/* 2133:2123 */       if (this.resultSet != null) {
/* 2134:2124 */         while (this.resultSet.next()) {
/* 2135:2126 */           temp = this.resultSet.getInt("REG_CUSTOMER_ID");
/* 2136:     */         }
/* 2137:     */       }
/* 2138:     */     }
/* 2139:     */     catch (SQLException sqlException)
/* 2140:     */     {
/* 2141:2131 */       sqlException.printStackTrace();
/* 2142:2132 */       logger.error(
/* 2143:2133 */         RetailerCustomerDaoImpl.class + 
/* 2144:2134 */         ": Error:- Error: Occur in Query While counting the Retailer details recods from Database", 
/* 2145:2135 */         sqlException);
/* 2146:     */     }
/* 2147:     */     catch (Exception exception)
/* 2148:     */     {
/* 2149:2138 */       exception.printStackTrace();
/* 2150:2139 */       logger.error(
/* 2151:2140 */         RetailerCustomerDaoImpl.class + 
/* 2152:2141 */         ": Error:- While closing the Connection after counting the Retailer details recods from Database", 
/* 2153:2142 */         exception);
/* 2154:     */     }
/* 2155:     */     finally
/* 2156:     */     {
/* 2157:2144 */       JdbcHelper.closeResultSet(this.resultSet);
/* 2158:2145 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/* 2159:2146 */       JdbcHelper.closeConnection(this.connection);
/* 2160:     */     }
/* 2161:2148 */     return temp;
/* 2162:     */   }
/* 2163:     */   
/* 2164:     */   public Retailer getRetailerDetails(int retailerId)
/* 2165:     */     throws RecordNotFoundException
/* 2166:     */   {
/* 2167:2153 */     Retailer retailer = new Retailer();
/* 2168:     */     try
/* 2169:     */     {
/* 2170:2156 */       System.out.println("hye bharti ur in view method");
/* 2171:2157 */       this.connection = getConnection();
/* 2172:2158 */       this.preparedStatement = this.connection
/* 2173:2159 */         .prepareStatement("SELECT * FROM TAB_REGULAR_CUSTOMER WHERE REG_CUSTOMER_STATUS='ACTIVE' AND REG_CUSTOMER_ID=?");
/* 2174:2160 */       this.preparedStatement.setInt(1, retailerId);
/* 2175:2161 */       this.resultSet = this.preparedStatement.executeQuery();
/* 2176:2162 */       System.out.println("----------hye ----------------%%" + retailerId);
/* 2177:2163 */       if (this.resultSet != null) {
/* 2178:2164 */         while (this.resultSet.next())
/* 2179:     */         {
/* 2180:2166 */           System.out.println("----------hye ----------------" + this.resultSet.getInt("REG_CUSTOMER_ID") + "****");
/* 2181:     */           
/* 2182:2168 */           retailer.setCustomerId(this.resultSet.getInt("REG_CUSTOMER_ID"));
/* 2183:     */           
/* 2184:     */ 
/* 2185:     */ 
/* 2186:2172 */           retailer.setFullName(this.resultSet.getString("REG_FULL_NAME"));
/* 2187:     */           
/* 2188:2174 */           retailer.setDob(this.resultSet
/* 2189:2175 */             .getString("REG_DATE_OF_BIRTH"));
/* 2190:     */           
/* 2191:2177 */           retailer.setAddress1(this.resultSet
/* 2192:2178 */             .getString("REG_ADDRESS_LINE_1"));
/* 2193:     */           
/* 2194:2180 */           retailer.setAddress2(this.resultSet
/* 2195:2181 */             .getString("REG_ADDRESS_LINE_2"));
/* 2196:     */           
/* 2197:     */ 
/* 2198:2184 */           retailer.setCity(this.nameHelper.getCityNameByCityId(this.resultSet.getInt("REG_CITY")));
/* 2199:     */           
/* 2200:2186 */           retailer.setState(this.nameHelper.getStateNameByStateId(this.resultSet
/* 2201:2187 */             .getInt("REG_STATE")));
/* 2202:     */           
/* 2203:2189 */           retailer.setPhoneNo(this.resultSet
/* 2204:2190 */             .getString("REG_PHONE_NO"));
/* 2205:     */           
/* 2206:2192 */           retailer.setMobileNo(this.resultSet
/* 2207:2193 */             .getString("REG_MOBILE_NO"));
/* 2208:     */           
/* 2209:2195 */           retailer.setPinCode(this.resultSet
/* 2210:2196 */             .getString("REG_PINCODE"));
/* 2211:     */           
/* 2212:2198 */           retailer.setPeimaryMailId(this.resultSet
/* 2213:2199 */             .getString("REG_PRIMARY_MAIL_ID"));
/* 2214:     */           
/* 2215:     */ 
/* 2216:2202 */           retailer.setAlternativeMail(this.resultSet
/* 2217:2203 */             .getString("REG_ALTERNATE_MAIL_ID"));
/* 2218:2204 */           retailer.setCreationDate(this.resultSet
/* 2219:2205 */             .getString("REG_CREATION_DATE"));
/* 2220:2206 */           retailer.setWorkLocation(this.resultSet
/* 2221:2207 */             .getString("REG_WORK_LOCATION"));
/* 2222:2208 */           retailer.setCreatedBy(this.resultSet
/* 2223:2209 */             .getString("REG_CREATED_BY"));
/* 2224:2210 */           System.out.println("u got the data ***********************************");
/* 2225:     */         }
/* 2226:     */       }
/* 2227:     */     }
/* 2228:     */     catch (SQLException sqlExp)
/* 2229:     */     {
/* 2230:2219 */       sqlExp.printStackTrace();
/* 2231:2220 */       logger.error(
/* 2232:2221 */         RetailerCustomerDaoImpl.class + 
/* 2233:2222 */         "Error: Occur in Query While Fetching the specific consumer Details from Database.", 
/* 2234:2223 */         sqlExp);
/* 2235:     */     }
/* 2236:     */     catch (Exception exception)
/* 2237:     */     {
/* 2238:2225 */       exception.printStackTrace();
/* 2239:2226 */       logger.error(
/* 2240:2227 */         RetailerCustomerDaoImpl.class + 
/* 2241:2228 */         "Error: Occur in Query While Closing Connection After Fetching the specific consumer Details from Database.", 
/* 2242:2229 */         exception);
/* 2243:     */     }
/* 2244:     */     finally
/* 2245:     */     {
/* 2246:2231 */       JdbcHelper.closeResultSet(this.resultSet);
/* 2247:2232 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/* 2248:2233 */       JdbcHelper.closeConnection(this.connection);
/* 2249:     */     }
/* 2250:2237 */     return retailer;
/* 2251:     */   }
/* 2252:     */   
/* 2253:     */   public int getRetailerTransactionLastRecord()
/* 2254:     */     throws RecordNotFoundException
/* 2255:     */   {
/* 2256:2242 */     int temp = 0;
/* 2257:     */     try
/* 2258:     */     {
/* 2259:2244 */       this.connection = getConnection();
/* 2260:     */       
/* 2261:2246 */       this.preparedStatement = this.connection
/* 2262:2247 */         .prepareStatement("SELECT  CUSTOMER_TRANS_ID FROM TAB_OWNER_CUSTOMER_TRANSACTION WHERE CUSTOMER_TYPE='Retailer' ORDER BY CUSTOMER_TRANS_ID DESC LIMIT 1");
/* 2263:     */       
/* 2264:     */ 
/* 2265:2250 */       this.resultSet = this.preparedStatement.executeQuery();
/* 2266:2251 */       if (this.resultSet != null) {
/* 2267:2252 */         while (this.resultSet.next()) {
/* 2268:2254 */           temp = this.resultSet.getInt("CUSTOMER_TRANS_ID");
/* 2269:     */         }
/* 2270:     */       }
/* 2271:     */     }
/* 2272:     */     catch (SQLException sqlException)
/* 2273:     */     {
/* 2274:2259 */       sqlException.printStackTrace();
/* 2275:2260 */       logger.error(
/* 2276:2261 */         RetailerCustomerDaoImpl.class + 
/* 2277:2262 */         ": Error:- Error: Occur in Query While counting the Retailer Transaction recods from Database", 
/* 2278:2263 */         sqlException);
/* 2279:     */     }
/* 2280:     */     catch (Exception exception)
/* 2281:     */     {
/* 2282:2266 */       exception.printStackTrace();
/* 2283:2267 */       logger.error(
/* 2284:2268 */         RetailerCustomerDaoImpl.class + 
/* 2285:2269 */         ": Error:- While closing the Connection after counting the Retailer Transaction recods from Database", 
/* 2286:2270 */         exception);
/* 2287:     */     }
/* 2288:     */     finally
/* 2289:     */     {
/* 2290:2272 */       JdbcHelper.closeResultSet(this.resultSet);
/* 2291:2273 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/* 2292:2274 */       JdbcHelper.closeConnection(this.connection);
/* 2293:     */     }
/* 2294:2276 */     return temp;
/* 2295:     */   }
/* 2296:     */   
/* 2297:     */   public Retailer getRetailerTransaction(int transId)
/* 2298:     */     throws RecordNotFoundException
/* 2299:     */   {
/* 2300:2281 */     Retailer retailer = new Retailer();
/* 2301:2282 */     PreparedStatement preparedStatements = null;
/* 2302:     */     try
/* 2303:     */     {
/* 2304:2284 */       this.connection = getConnection();
/* 2305:     */       
/* 2306:2286 */       preparedStatements = this.connection
/* 2307:2287 */         .prepareStatement("SELECT * FROM  TAB_OWNER_CUSTOMER_TRANSACTION WHERE CUSTOMER_TYPE='Retailer' AND CUSTOMER_TRANS_ID=?");
/* 2308:2288 */       preparedStatements.setInt(1, transId);
/* 2309:     */       
/* 2310:     */ 
/* 2311:     */ 
/* 2312:     */ 
/* 2313:2293 */       this.resultSet = preparedStatements.executeQuery();
/* 2314:2294 */       System.out.println("----------hye ----------------");
/* 2315:2295 */       if (this.resultSet != null) {
/* 2316:2296 */         while (this.resultSet.next())
/* 2317:     */         {
/* 2318:2298 */           System.out.println("----------hye ----------------");
/* 2319:     */           
/* 2320:2300 */           retailer.setTransactionId(this.resultSet.getInt("CUSTOMER_TRANS_ID"));
/* 2321:2301 */           System.out.println("________________" + this.resultSet.getInt("CUSTOMER_TRANS_ID"));
/* 2322:     */           
/* 2323:     */ 
/* 2324:     */ 
/* 2325:2305 */           retailer.setDescription(this.resultSet
/* 2326:2306 */             .getString("CUSTOMER_TRANS_DISCRIPTION"));
/* 2327:     */           
/* 2328:2308 */           retailer.setTotal(this.resultSet
/* 2329:2309 */             .getFloat("CUSTOMER_TRANS_TOTAL"));
/* 2330:     */           
/* 2331:2311 */           retailer.setPaid(this.resultSet
/* 2332:2312 */             .getFloat("CUSTOMER_TRANS_PAID"));
/* 2333:     */           
/* 2334:2314 */           retailer.setDue(this.resultSet
/* 2335:2315 */             .getFloat("CUSTOMER_TRANS_DUE"));
/* 2336:     */           
/* 2337:2317 */           retailer.setTotalPaid(this.resultSet.getFloat("CUSTOMER_TRANS_TOTAL_PAID"));
/* 2338:     */           
/* 2339:2319 */           retailer.setTotalDue(this.resultSet.getFloat("CUSTOMER_TRANS_TOTAL_DUE"));
/* 2340:     */           
/* 2341:2321 */           retailer.setTransactionDate(this.resultSet.getString("CUSTOMER_TRANS_DATE"));
/* 2342:     */           
/* 2343:2323 */           retailer.setRetailerId(this.resultSet.getInt("CUSTOMER_ID_RETAILER"));
/* 2344:     */           
/* 2345:     */ 
/* 2346:     */ 
/* 2347:     */ 
/* 2348:     */ 
/* 2349:     */ 
/* 2350:     */ 
/* 2351:     */ 
/* 2352:     */ 
/* 2353:2333 */           retailer.setPaymentMode(this.resultSet
/* 2354:2334 */             .getString("CUSTOMER_TRANS_PAY_MODE"));
/* 2355:     */         }
/* 2356:     */       }
/* 2357:     */     }
/* 2358:     */     catch (SQLException sqlExp)
/* 2359:     */     {
/* 2360:2340 */       sqlExp.printStackTrace();
/* 2361:2341 */       logger.error(
/* 2362:2342 */         RetailerCustomerDaoImpl.class + 
/* 2363:2343 */         "Error: Occur in Query While Fetching the specific retailer transaction from Database For Update.", 
/* 2364:2344 */         sqlExp);
/* 2365:     */     }
/* 2366:     */     catch (Exception exception)
/* 2367:     */     {
/* 2368:2346 */       exception.printStackTrace();
/* 2369:2347 */       logger.error(
/* 2370:2348 */         RetailerCustomerDaoImpl.class + 
/* 2371:2349 */         "Error: Occur in Query While Closing Connection After Fetching the specific retailer transaction from Database For Update.", 
/* 2372:2350 */         exception);
/* 2373:     */     }
/* 2374:     */     finally
/* 2375:     */     {
/* 2376:2352 */       JdbcHelper.closeResultSet(this.resultSet);
/* 2377:2353 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/* 2378:2354 */       JdbcHelper.closeConnection(this.connection);
/* 2379:     */     }
/* 2380:2356 */     return retailer;
/* 2381:     */   }
/* 2382:     */   
/* 2383:     */   public Retailer retrieveReailerTransactionByIdForPayDue(int transId)
/* 2384:     */     throws RecordNotFoundException
/* 2385:     */   {
/* 2386:2361 */     Retailer retailer = new Retailer();
/* 2387:2362 */     Connection connections = null;
/* 2388:2363 */     ResultSet resultSets = null;
/* 2389:2364 */     PreparedStatement preparedStatementss = null;
/* 2390:     */     try
/* 2391:     */     {
/* 2392:2366 */       connections = getConnection();
/* 2393:     */       
/* 2394:2368 */       preparedStatementss = connections
/* 2395:2369 */         .prepareStatement("SELECT * FROM TAB_OWNER_CUSTOMER_TRANSACTION WHERE CUSTOMER_TRANS_ID=?");
/* 2396:2370 */       preparedStatementss.setInt(1, transId);
/* 2397:     */       
/* 2398:     */ 
/* 2399:2373 */       System.out.println(transId + "vvvvvvvvvvvvvvvvvvvvv");
/* 2400:2374 */       resultSets = preparedStatementss.executeQuery();
/* 2401:2375 */       System.out.println("----------hye ----------------");
/* 2402:2376 */       if (resultSets != null) {
/* 2403:2377 */         while (resultSets.next())
/* 2404:     */         {
/* 2405:2379 */           System.out.println("----------hye gggggggggggggggggggg----------------");
/* 2406:2380 */           int retailerId = resultSets.getInt("CUSTOMER_ID_RETAILER");
/* 2407:2381 */           retailer.setTransactionId(resultSets.getInt("CUSTOMER_TRANS_ID"));
/* 2408:2382 */           System.out.println("________________))((*hhhhh" + resultSets.getInt("CUSTOMER_TRANS_ID"));
/* 2409:2383 */           retailer.setDescription(resultSets
/* 2410:2384 */             .getString("CUSTOMER_TRANS_DISCRIPTION"));
/* 2411:2385 */           if ((resultSets.getFloat("CUSTOMER_TRANS_TOTAL_DUE") == 0.0F) && (resultSets.getFloat("CUSTOMER_TRANS_TOTAL_PAID") == 0.0F))
/* 2412:     */           {
/* 2413:2386 */             retailer.setTotalPaid(resultSets.getFloat("CUSTOMER_TRANS_PAID"));
/* 2414:     */             
/* 2415:2388 */             retailer.setTotalDue(resultSets.getFloat("CUSTOMER_TRANS_DUE"));
/* 2416:     */           }
/* 2417:     */           else
/* 2418:     */           {
/* 2419:2390 */             retailer.setTotalPaid(resultSets.getFloat("CUSTOMER_TRANS_TOTAL_PAID"));
/* 2420:     */             
/* 2421:2392 */             retailer.setTotalDue(resultSets.getFloat("CUSTOMER_TRANS_TOTAL_DUE"));
/* 2422:     */           }
/* 2423:2394 */           retailer.setTotal(resultSets
/* 2424:2395 */             .getFloat("CUSTOMER_TRANS_TOTAL"));
/* 2425:     */           
/* 2426:2397 */           retailer.setPaid(resultSets
/* 2427:2398 */             .getFloat("CUSTOMER_TRANS_PAID"));
/* 2428:     */           
/* 2429:2400 */           retailer.setDue(resultSets
/* 2430:2401 */             .getFloat("CUSTOMER_TRANS_DUE"));
/* 2431:     */           
/* 2432:2403 */           retailer.setBillNo(resultSets.getString("CUSTOMER_UNIQUE_ID"));
/* 2433:     */           
/* 2434:     */ 
/* 2435:     */ 
/* 2436:2407 */           retailer.setPaymentMode(resultSets.getString("CUSTOMER_TRANS_PAY_MODE"));
/* 2437:     */           
/* 2438:2409 */           System.out.println(resultSets.getString("CUSTOMER_TRANS_PAY_MODE") + " " + resultSets.getString("CUSTOMER_TRANS_DISCRIPTION"));
/* 2439:     */           
/* 2440:2411 */           retailer.setRetailerId(resultSets.getInt("CUSTOMER_ID_RETAILER"));
/* 2441:     */           
/* 2442:2413 */           retailer = getRetailerDetailForPayDue(retailer, retailerId);
/* 2443:2414 */           System.out.println(retailer.getTotalDue() + retailer.getTotalPaid() + "PPPPPPPPP");
/* 2444:     */         }
/* 2445:     */       }
/* 2446:     */     }
/* 2447:     */     catch (SQLException sqlExp)
/* 2448:     */     {
/* 2449:2424 */       sqlExp.printStackTrace();
/* 2450:2425 */       logger.error(
/* 2451:2426 */         RetailerCustomerDaoImpl.class + 
/* 2452:2427 */         "Error: Occur in Query While Fetching the specific retailer transaction Details from Database For Pay Due.", 
/* 2453:2428 */         sqlExp);
/* 2454:     */     }
/* 2455:     */     catch (Exception exception)
/* 2456:     */     {
/* 2457:2430 */       exception.printStackTrace();
/* 2458:2431 */       logger.error(
/* 2459:2432 */         RetailerCustomerDaoImpl.class + 
/* 2460:2433 */         "Error: Occur in Query While Closing Connection After Fetching the specific retailer transaction Details from Database For Pay Due..", 
/* 2461:2434 */         exception);
/* 2462:     */     }
/* 2463:     */     finally
/* 2464:     */     {
/* 2465:2436 */       JdbcHelper.closeResultSet(resultSets);
/* 2466:2437 */       JdbcHelper.closePreparedStatement(preparedStatementss);
/* 2467:2438 */       JdbcHelper.closeConnection(connections);
/* 2468:     */     }
/* 2469:2442 */     return retailer;
/* 2470:     */   }
/* 2471:     */   
/* 2472:     */   private Retailer getRetailerDetailForPayDue(Retailer retailer, int retailerId)
/* 2473:     */   {
/* 2474:     */     try
/* 2475:     */     {
/* 2476:2449 */       System.out.println("hye bharti ur in view for pay method");
/* 2477:2450 */       this.connection = getConnection();
/* 2478:2451 */       this.preparedStatement = this.connection
/* 2479:2452 */         .prepareStatement("SELECT * FROM TAB_REGULAR_CUSTOMER WHERE REG_CUSTOMER_STATUS='ACTIVE' AND REG_CUSTOMER_ID=?");
/* 2480:2453 */       this.preparedStatement.setInt(1, retailerId);
/* 2481:2454 */       this.resultSet = this.preparedStatement.executeQuery();
/* 2482:2455 */       System.out.println("----------hye ----------------%%" + retailerId);
/* 2483:2456 */       if (this.resultSet != null) {
/* 2484:2457 */         while (this.resultSet.next())
/* 2485:     */         {
/* 2486:2459 */           System.out.println("----------hye ----------------" + this.resultSet.getInt("REG_CITY") + "****");
/* 2487:     */           
/* 2488:2461 */           String city = this.nameHelper.getCityNameByCityId(this.resultSet.getInt("REG_CITY"));
/* 2489:     */           
/* 2490:     */ 
/* 2491:2464 */           retailer.setRetailerId(this.resultSet.getInt("REG_CUSTOMER_ID"));
/* 2492:     */           
/* 2493:     */ 
/* 2494:     */ 
/* 2495:2468 */           retailer.setFullName(this.resultSet.getString("REG_FULL_NAME"));
/* 2496:     */           
/* 2497:2470 */           retailer.setDob(this.resultSet
/* 2498:2471 */             .getString("REG_DATE_OF_BIRTH"));
/* 2499:     */           
/* 2500:2473 */           retailer.setAddress1(this.resultSet
/* 2501:2474 */             .getString("REG_ADDRESS_LINE_1") + ", " + city);
/* 2502:     */           
/* 2503:2476 */           retailer.setAddress2(this.resultSet
/* 2504:2477 */             .getString("REG_ADDRESS_LINE_2"));
/* 2505:     */           
/* 2506:     */ 
/* 2507:2480 */           retailer.setCity(this.nameHelper.getCityNameByCityId(this.resultSet.getInt("REG_CITY")));
/* 2508:     */           
/* 2509:2482 */           retailer.setState(this.nameHelper.getStateNameByStateId(this.resultSet.getInt("REG_STATE")));
/* 2510:     */           
/* 2511:2484 */           retailer.setPhoneNo(this.resultSet
/* 2512:2485 */             .getString("REG_PHONE_NO"));
/* 2513:     */           
/* 2514:2487 */           retailer.setMobileNo(this.resultSet
/* 2515:2488 */             .getString("REG_MOBILE_NO"));
/* 2516:     */           
/* 2517:2490 */           retailer.setPinCode(this.resultSet
/* 2518:2491 */             .getString("REG_PINCODE"));
/* 2519:     */           
/* 2520:2493 */           retailer.setPeimaryMailId(this.resultSet
/* 2521:2494 */             .getString("REG_PRIMARY_MAIL_ID"));
/* 2522:     */           
/* 2523:     */ 
/* 2524:     */ 
/* 2525:     */ 
/* 2526:     */ 
/* 2527:     */ 
/* 2528:     */ 
/* 2529:     */ 
/* 2530:     */ 
/* 2531:     */ 
/* 2532:2505 */           System.out.println("u got the data ***********************************");
/* 2533:     */         }
/* 2534:     */       }
/* 2535:     */     }
/* 2536:     */     catch (SQLException sqlExp)
/* 2537:     */     {
/* 2538:2514 */       sqlExp.printStackTrace();
/* 2539:2515 */       logger.error(
/* 2540:2516 */         RetailerCustomerDaoImpl.class + 
/* 2541:2517 */         "Error: Occur in Query While Fetching the specific retailer Details from Database.", 
/* 2542:2518 */         sqlExp);
/* 2543:     */     }
/* 2544:     */     catch (Exception exception)
/* 2545:     */     {
/* 2546:2520 */       exception.printStackTrace();
/* 2547:2521 */       logger.error(
/* 2548:2522 */         RetailerCustomerDaoImpl.class + 
/* 2549:2523 */         "Error: Occur in Query While Closing Connection After Fetching the specific retailer Details from Database.", 
/* 2550:2524 */         exception);
/* 2551:     */     }
/* 2552:     */     finally
/* 2553:     */     {
/* 2554:2526 */       JdbcHelper.closeResultSet(this.resultSet);
/* 2555:2527 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/* 2556:2528 */       JdbcHelper.closeConnection(this.connection);
/* 2557:     */     }
/* 2558:2532 */     return retailer;
/* 2559:     */   }
/* 2560:     */   
/* 2561:     */   public void addPayDue(RetailerCustomerVO retailerCustomerVO, int transId)
/* 2562:     */     throws RecordNotFoundException
/* 2563:     */   {
/* 2564:     */     try
/* 2565:     */     {
/* 2566:2539 */       String query = "INSERT INTO TAB_OWNER_CUSTOMER_TRANSACTION(CUSTOMER_TRANS_DISCRIPTION,CUSTOMER_TRANS_PAID,CUSTOMER_TRANS_TOTAL_PAID,CUSTOMER_TRANS_TOTAL_DUE,CUSTOMER_TRANS_DATE,CUSTOMER_ID_RETAILER,CUSTOMER_UNIQUE_ID,CUSTOMER_TRANS_PAY_MODE, CUSTOMER_TYPE)VALUES(?,?,?,?,?,?,?,?,?)";
/* 2567:2540 */       this.connection = getConnection();
/* 2568:2541 */       float totalPaid = retailerCustomerVO.getTotalPaid() + retailerCustomerVO.getPayment();
/* 2569:2542 */       float totalDue = retailerCustomerVO.getTotalDue() - retailerCustomerVO.getPayment();
/* 2570:     */       
/* 2571:2544 */       this.preparedStatement = this.connection.prepareStatement(query);
/* 2572:2545 */       System.out.println(totalPaid + "helllo we r in dao impl for transaction" + totalDue);
/* 2573:2546 */       this.preparedStatement.setString(1, "ON_DUE_PAYMENT");
/* 2574:2547 */       this.preparedStatement.setFloat(2, retailerCustomerVO.getPayment());
/* 2575:     */       
/* 2576:2549 */       this.preparedStatement.setFloat(3, totalPaid);
/* 2577:2550 */       this.preparedStatement.setFloat(4, totalDue);
/* 2578:2551 */       this.preparedStatement.setString(5, DateTimeUtil.convertToDate(retailerCustomerVO.getTransactionDate()));
/* 2579:2552 */       System.out.println(retailerCustomerVO.getBillNo() + "hey here is my bill no");
/* 2580:     */       
/* 2581:     */ 
/* 2582:2555 */       this.preparedStatement.setInt(6, retailerCustomerVO.getRetailerId());
/* 2583:2556 */       this.preparedStatement.setString(7, retailerCustomerVO.getBillNo());
/* 2584:2557 */       this.preparedStatement.setString(8, retailerCustomerVO.getPaymentMode());
/* 2585:2558 */       this.preparedStatement.setString(9, "Retailer");
/* 2586:     */       
/* 2587:     */ 
/* 2588:2561 */       this.preparedStatement.executeUpdate();
/* 2589:     */     }
/* 2590:     */     catch (SQLException sqlException)
/* 2591:     */     {
/* 2592:2564 */       sqlException.printStackTrace();
/* 2593:2565 */       logger.error(
/* 2594:2566 */         RetailerCustomerDaoImpl.class + 
/* 2595:2567 */         ": Error:- Error: Occur in Query While inserting the transaction details record", 
/* 2596:2568 */         sqlException);
/* 2597:     */     }
/* 2598:     */     catch (Exception exception)
/* 2599:     */     {
/* 2600:2570 */       exception.printStackTrace();
/* 2601:2571 */       logger.error(
/* 2602:2572 */         RetailerCustomerDaoImpl.class + 
/* 2603:2573 */         ": Error:- While closing the Connection after inserting the transaction details reccord", 
/* 2604:2574 */         exception);
/* 2605:     */     }
/* 2606:     */     finally
/* 2607:     */     {
/* 2608:2577 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/* 2609:2578 */       JdbcHelper.closeConnection(this.connection);
/* 2610:     */     }
/* 2611:     */   }
/* 2612:     */ }


/* Location:           C:\Users\bharti\Desktop\Chouksay\lost\dao\
 * Qualified Name:     com.bst.ckt.dao.RetailerCustomerDaoImpl
 * JD-Core Version:    0.7.0.1
 */