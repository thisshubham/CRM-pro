/*   1:    */ package com.bst.ckt.action;
/*   2:    */ 
/*   3:    */ import com.bst.ckt.common.LoginUtil;
/*   4:    */ import com.bst.ckt.dao.RetailerCustomerDaoImpl;
/*   5:    */ import com.bst.ckt.dao.RetailerCustomerDaoInf;
/*   6:    */ import com.bst.ckt.exception.CreateFailedException;
/*   7:    */ import com.bst.ckt.exception.DeleteFailedException;
/*   8:    */ import com.bst.ckt.exception.RecordNotFoundException;
/*   9:    */ import com.bst.ckt.exception.UpdateFailedException;
/*  10:    */ import com.bst.ckt.helper.CustomerTransactionAdvanceSearch;
/*  11:    */ import com.bst.ckt.helper.ListHelper;
/*  12:    */ import com.bst.ckt.helper.NameHelper;
/*  13:    */ import com.bst.ckt.helper.RetailerCustomerAdvanceSearch;
/*  14:    */ import com.bst.ckt.helper.Salutation;
/*  15:    */ import com.bst.ckt.helper.VOMapperHelper;
/*  16:    */ import com.bst.ckt.service.RetailerCustomerServiceImpl;
/*  17:    */ import com.bst.ckt.service.RetailerCustomerServiceInf;
/*  18:    */ import com.bst.ckt.vo.RetailerCustomerVO;
/*  19:    */ import com.opensymphony.xwork2.ActionContext;
/*  20:    */ import com.opensymphony.xwork2.ActionSupport;
/*  21:    */ import com.opensymphony.xwork2.ModelDriven;
/*  22:    */ import java.io.IOException;
/*  23:    */ import java.io.PrintStream;
/*  24:    */ import java.io.PrintWriter;
/*  25:    */ import java.util.HashMap;
/*  26:    */ import java.util.List;
/*  27:    */ import java.util.Map;
/*  28:    */ import javax.servlet.http.HttpServletRequest;
/*  29:    */ import javax.servlet.http.HttpServletResponse;
/*  30:    */ import org.apache.log4j.Logger;
/*  31:    */ import org.apache.struts2.interceptor.ServletRequestAware;
/*  32:    */ import org.apache.struts2.interceptor.ServletResponseAware;
/*  33:    */ import org.apache.struts2.interceptor.SessionAware;
/*  34:    */ import org.json.simple.JSONObject;
/*  35:    */ 
/*  36:    */ public class RetailerCustomerAction
/*  37:    */   extends ActionSupport
/*  38:    */   implements ModelDriven<RetailerCustomerVO>, SessionAware, ServletRequestAware, ServletResponseAware
/*  39:    */ {
/*  40:    */   private static final long serialVersionUID = 1L;
/*  41: 65 */   private static final Logger logger = Logger.getLogger(RetailerCustomerAction.class);
/*  42: 67 */   HttpServletRequest request = (HttpServletRequest)ActionContext.getContext().get("com.opensymphony.xwork2.dispatcher.HttpServletRequest");
/*  43: 68 */   RetailerCustomerVO retailerCustomerVO = new RetailerCustomerVO();
/*  44: 69 */   RetailerCustomerServiceInf retailerCustomerServiceInf = null;
/*  45: 70 */   RetailerCustomerDaoInf retailerCustomerDaoInf = new RetailerCustomerDaoImpl();
/*  46: 71 */   ListHelper listHelper = new ListHelper();
/*  47: 74 */   HttpServletResponse response = null;
/*  48:    */   private Map<Integer, String> countryList;
/*  49:    */   private HashMap<Integer, String> parentAccountList;
/*  50:    */   private Map<Integer, String> salutationList;
/*  51:    */   private Map<Integer, String> payModeList;
/*  52: 79 */   List<RetailerCustomerVO> retailerDetailList = null;
/*  53: 80 */   List<RetailerCustomerVO> retailerTransactionDetailList = null;
/*  54:    */   private Map<Integer, String> retailerCustomerSearchList;
/*  55:    */   private Map<Integer, String> retailerCustomerTransactionSearchList;
/*  56: 83 */   private Map<Integer, String> stateList = null;
/*  57: 84 */   private Map<Integer, String> cityList = null;
/*  58:    */   private Map<Integer, String> retailerList;
/*  59: 88 */   Map<String, Object> session = null;
/*  60:    */   
/*  61:    */   public RetailerCustomerAction()
/*  62:    */     throws Exception
/*  63:    */   {
/*  64: 92 */     this.countryList = this.listHelper.countryList();
/*  65: 93 */     this.parentAccountList = this.listHelper.getParentAccountList();
/*  66: 94 */     this.salutationList = Salutation.getSalutationList();
/*  67: 95 */     this.countryList = this.listHelper.countryList();
/*  68: 96 */     this.payModeList = this.listHelper.getPaymentModeList();
/*  69: 97 */     this.stateList = this.listHelper.getStateList();
/*  70: 98 */     this.cityList = this.listHelper.getCityList();
/*  71: 99 */     this.retailerList = this.listHelper.regularCustomerList();
/*  72:100 */     setRetailerCustomerSearchList(RetailerCustomerAdvanceSearch.getRetailerCustomerSearchList());
/*  73:101 */     setRetailerCustomerTransactionSearchList(CustomerTransactionAdvanceSearch.getCustomerTransactionSearchList());
/*  74:    */   }
/*  75:    */   
/*  76:    */   public String execute()
/*  77:    */     throws Exception
/*  78:    */   {
/*  79:117 */     this.retailerCustomerServiceInf = new RetailerCustomerServiceImpl();
/*  80:    */     
/*  81:    */ 
/*  82:120 */     this.retailerDetailList = this.retailerCustomerServiceInf
/*  83:121 */       .retriveRetailerDetailsGrid(this.retailerCustomerVO);
/*  84:    */     
/*  85:    */ 
/*  86:124 */     this.retailerTransactionDetailList = this.retailerCustomerServiceInf
/*  87:125 */       .retriveRetailerTransactionDetailsGrid(this.retailerCustomerVO);
/*  88:126 */     return "success";
/*  89:    */   }
/*  90:    */   
/*  91:    */   public String addRetailer()
/*  92:    */     throws CreateFailedException
/*  93:    */   {
/*  94:143 */     this.retailerCustomerServiceInf = new RetailerCustomerServiceImpl();
/*  95:144 */     String message = this.retailerCustomerServiceInf.addRetailerDetails(this.retailerCustomerVO);
/*  96:145 */     if ("SUCCESS".equalsIgnoreCase(message))
/*  97:    */     {
/*  98:146 */       logger.info("Retailer Details Successfully Inserted!");
/*  99:147 */       addActionMessage("Retailer Details Successfully Inserted!");
/* 100:148 */       return "success";
/* 101:    */     }
/* 102:150 */     if ("FAILURE".equalsIgnoreCase(message))
/* 103:    */     {
/* 104:152 */       logger.info("Error:while  Inserting Retailer Details!");
/* 105:153 */       addActionError("Error:while  Inserting Retailer Details!");
/* 106:154 */       return "input";
/* 107:    */     }
/* 108:157 */     return "none";
/* 109:    */   }
/* 110:    */   
/* 111:    */   public String viewRetailerDetailsGrid()
/* 112:    */     throws RecordNotFoundException
/* 113:    */   {
/* 114:164 */     this.retailerCustomerServiceInf = new RetailerCustomerServiceImpl();
/* 115:    */     
/* 116:    */ 
/* 117:167 */     this.retailerDetailList = this.retailerCustomerServiceInf
/* 118:168 */       .retriveRetailerDetailsForAdvanceSearch(this.retailerCustomerVO);
/* 119:170 */     if (this.retailerDetailList == null)
/* 120:    */     {
/* 121:171 */       logger.error(" Error: While getting retailer details for search");
/* 122:172 */       addActionError("No Records found");
/* 123:173 */       return "error";
/* 124:    */     }
/* 125:175 */     logger.info("Records found Successfully");
/* 126:176 */     return "success";
/* 127:    */   }
/* 128:    */   
/* 129:    */   public String viewLedgerForSpecficCustomer()
/* 130:    */   {
/* 131:184 */     this.retailerCustomerServiceInf = new RetailerCustomerServiceImpl();
/* 132:    */     
/* 133:    */ 
/* 134:187 */     return "success";
/* 135:    */   }
/* 136:    */   
/* 137:    */   public String viewRetailerTransactionDetailsGrid()
/* 138:    */     throws RecordNotFoundException
/* 139:    */   {
/* 140:194 */     this.retailerCustomerServiceInf = new RetailerCustomerServiceImpl();
/* 141:    */     
/* 142:    */ 
/* 143:197 */     this.retailerTransactionDetailList = this.retailerCustomerServiceInf
/* 144:198 */       .retriveRetailerTransactionForAdvanceSearch(this.retailerCustomerVO);
/* 145:200 */     if (this.retailerTransactionDetailList == null)
/* 146:    */     {
/* 147:201 */       logger.error(" Error: While getting retailer Transaction for advance search");
/* 148:202 */       addActionError("No Records found");
/* 149:203 */       return "error";
/* 150:    */     }
/* 151:205 */     logger.info("Records found Successfully");
/* 152:206 */     return "success";
/* 153:    */   }
/* 154:    */   
/* 155:    */   public String viewSpecificRetailerDetail()
/* 156:    */     throws RecordNotFoundException
/* 157:    */   {
/* 158:212 */     this.retailerCustomerServiceInf = new RetailerCustomerServiceImpl();
/* 159:213 */     System.out.println("hye bharti ur in view method");
/* 160:214 */     String id = this.request.getParameter("command");
/* 161:    */     
/* 162:216 */     int retailerId = Integer.parseInt(id);
/* 163:217 */     LoginUtil.setProcessUserId(retailerId);
/* 164:218 */     System.out.println(retailerId);
/* 165:    */     
/* 166:220 */     this.retailerCustomerVO = VOMapperHelper.getRetailerFromRetailerDetails(this.retailerCustomerVO, this.retailerCustomerServiceInf.retriveSpecificRetailerDetail(retailerId));
/* 167:    */     
/* 168:222 */     return "success";
/* 169:    */   }
/* 170:    */   
/* 171:    */   public String viewSpecificRetailerTransaction()
/* 172:    */     throws RecordNotFoundException
/* 173:    */   {
/* 174:228 */     this.retailerCustomerServiceInf = new RetailerCustomerServiceImpl();
/* 175:    */     
/* 176:230 */     String id = this.request.getParameter("command");
/* 177:231 */     System.out.println(id + "YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY");
/* 178:232 */     int transId = Integer.parseInt(id);
/* 179:233 */     System.out.println(transId + "YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY");
/* 180:234 */     LoginUtil.setProcessUserId(transId);
/* 181:235 */     System.out.println(transId);
/* 182:    */     
/* 183:237 */     this.retailerCustomerVO = VOMapperHelper.getRetailerFromRetailerDetails(this.retailerCustomerVO, this.retailerCustomerServiceInf.retriveSpecificRetailerTransaction(transId));
/* 184:    */     
/* 185:239 */     return "success";
/* 186:    */   }
/* 187:    */   
/* 188:    */   public String retrieveRetailerTransactionByIdForPayDue()
/* 189:    */     throws RecordNotFoundException
/* 190:    */   {
/* 191:246 */     this.retailerCustomerServiceInf = new RetailerCustomerServiceImpl();
/* 192:247 */     String id = this.request.getParameter("command");
/* 193:248 */     String did = this.request.getParameter("did");
/* 194:249 */     System.out.println(id + "vvvvvvvvvvvvvvvvvvvvv" + did);
/* 195:250 */     int transId = Integer.parseInt(id);
/* 196:251 */     int dId = Integer.parseInt(did);
/* 197:252 */     LoginUtil.setProcessUserId(dId);
/* 198:253 */     this.retailerCustomerVO = VOMapperHelper.getRetailerFromRetailerDetails(this.retailerCustomerVO, this.retailerCustomerServiceInf.retrieveRetailerTransactionByIdForPayDue(transId));
/* 199:254 */     return "success";
/* 200:    */   }
/* 201:    */   
/* 202:    */   public String deleteSpecificRetailerDetails()
/* 203:    */     throws DeleteFailedException
/* 204:    */   {
/* 205:259 */     String delId = this.request.getParameter("command");
/* 206:260 */     int custId = Integer.parseInt(delId);
/* 207:261 */     this.retailerCustomerServiceInf = new RetailerCustomerServiceImpl();
/* 208:262 */     String message = this.retailerCustomerServiceInf.deleteSpecificRetailerDetails(custId);
/* 209:263 */     if (message.equals("SUCCESS"))
/* 210:    */     {
/* 211:264 */       logger.info("Records found Successfully");
/* 212:265 */       addActionMessage("Customer Details Deleted successfully!!");
/* 213:266 */       return "success";
/* 214:    */     }
/* 215:268 */     logger.error(" Error: While getting Customer details");
/* 216:269 */     addActionError("No Records found");
/* 217:270 */     return "error";
/* 218:    */   }
/* 219:    */   
/* 220:    */   public String deleteSpecificRetailerTransaction()
/* 221:    */     throws DeleteFailedException
/* 222:    */   {
/* 223:278 */     String delId = this.request.getParameter("command");
/* 224:279 */     int transId = Integer.parseInt(delId);
/* 225:280 */     this.retailerCustomerServiceInf = new RetailerCustomerServiceImpl();
/* 226:281 */     String message = this.retailerCustomerServiceInf.deleteSpecificRetailerTransaction(transId);
/* 227:282 */     if (message.equals("SUCCESS"))
/* 228:    */     {
/* 229:283 */       logger.info("Records found Successfully");
/* 230:284 */       addActionMessage("Customer Transaction Deleted successfully!!");
/* 231:285 */       return "success";
/* 232:    */     }
/* 233:287 */     logger.error(" Error: While getting Customer Transaction");
/* 234:288 */     addActionError("No Records found");
/* 235:289 */     return "error";
/* 236:    */   }
/* 237:    */   
/* 238:    */   public String viewSpecificRecordForEdit()
/* 239:    */     throws RecordNotFoundException
/* 240:    */   {
/* 241:297 */     this.retailerCustomerServiceInf = new RetailerCustomerServiceImpl();
/* 242:298 */     String id = this.request.getParameter("command");
/* 243:    */     
/* 244:300 */     int retailerId = Integer.parseInt(id);
/* 245:301 */     LoginUtil.setProcessUserId(retailerId);
/* 246:    */     
/* 247:303 */     System.out.println(retailerId);
/* 248:    */     
/* 249:305 */     this.retailerCustomerVO = VOMapperHelper.getRetailerFromRetailerDetails(this.retailerCustomerVO, this.retailerCustomerServiceInf.retriveSpecificRetailerDetailForEdit(retailerId));
/* 250:    */     
/* 251:307 */     return "success";
/* 252:    */   }
/* 253:    */   
/* 254:    */   public String updateSpecificRetailerRecord()
/* 255:    */     throws UpdateFailedException
/* 256:    */   {
/* 257:315 */     this.retailerCustomerServiceInf = new RetailerCustomerServiceImpl();
/* 258:    */     
/* 259:    */ 
/* 260:318 */     int retailerId = LoginUtil.getProcessUserId();
/* 261:    */     
/* 262:320 */     System.out.println(retailerId);
/* 263:    */     
/* 264:    */ 
/* 265:323 */     this.retailerCustomerServiceInf.updateSpecificRetailerRecord(this.retailerCustomerVO, retailerId);
/* 266:324 */     return "success";
/* 267:    */   }
/* 268:    */   
/* 269:    */   public String retailerTransactionPrintPDF()
/* 270:    */     throws Exception
/* 271:    */   {
/* 272:332 */     int transId = LoginUtil.getProcessUserId();
/* 273:333 */     System.out.println(transId + "TTTTTTTTTTTTTTTTTTTTTTTTT");
/* 274:334 */     LoginUtil.setProcessUserId(transId);
/* 275:335 */     this.retailerCustomerServiceInf = new RetailerCustomerServiceImpl();
/* 276:336 */     this.retailerCustomerServiceInf.retailerTransactionPrintPDF(this.request, this.response, transId);
/* 277:337 */     return null;
/* 278:    */   }
/* 279:    */   
/* 280:    */   public String retailerDetailPrintPDF()
/* 281:    */     throws Exception
/* 282:    */   {
/* 283:341 */     int dealerId = LoginUtil.getProcessUserId();
/* 284:342 */     System.out.println(dealerId + "TTTTTTTTTTTTTTTTTTTTTTTTT");
/* 285:343 */     LoginUtil.setProcessUserId(dealerId);
/* 286:344 */     this.retailerCustomerServiceInf = new RetailerCustomerServiceImpl();
/* 287:345 */     this.retailerCustomerServiceInf.retailerDetailPrintPDF(this.request, this.response, dealerId);
/* 288:346 */     return null;
/* 289:    */   }
/* 290:    */   
/* 291:    */   public String retailerDetailExcelReport()
/* 292:    */     throws Exception
/* 293:    */   {
/* 294:352 */     this.retailerCustomerServiceInf = new RetailerCustomerServiceImpl();
/* 295:353 */     this.retailerCustomerServiceInf.retailerDetailExcelReport(this.request, this.response);
/* 296:354 */     return "none";
/* 297:    */   }
/* 298:    */   
/* 299:    */   public String retailerTransactionExcelReport()
/* 300:    */     throws Exception
/* 301:    */   {
/* 302:361 */     this.retailerCustomerServiceInf = new RetailerCustomerServiceImpl();
/* 303:362 */     this.retailerCustomerServiceInf.retailerTransactionExcelReport(this.request, this.response);
/* 304:363 */     return "none";
/* 305:    */   }
/* 306:    */   
/* 307:    */   public String viewNextRetailerDetail()
/* 308:    */     throws Exception
/* 309:    */   {
/* 310:367 */     this.retailerCustomerServiceInf = new RetailerCustomerServiceImpl();
/* 311:368 */     int retailerId = LoginUtil.getProcessUserId();
/* 312:369 */     this.retailerCustomerVO = VOMapperHelper.getRetailerFromRetailerDetails(this.retailerCustomerVO, 
/* 313:370 */       this.retailerCustomerServiceInf.viewNextRetailerDetail(retailerId));
/* 314:373 */     if (this.retailerCustomerVO.getCustomerId() != 0)
/* 315:    */     {
/* 316:374 */       logger.info("Retailer details found successfully for Retailer Id  " + 
/* 317:375 */         this.retailerCustomerVO.getCustomerId());
/* 318:376 */       addActionMessage("Retailer details found successfully for Retailer Id " + 
/* 319:377 */         this.retailerCustomerVO.getCustomerId());
/* 320:378 */       return "success";
/* 321:    */     }
/* 322:380 */     this.retailerCustomerVO.setCustomerId(LoginUtil.getProcessUserId());
/* 323:381 */     logger.error("Retailer details not found for Retailer Id  " + 
/* 324:382 */       this.retailerCustomerVO.getCustomerId());
/* 325:383 */     addActionError("Retailer details not found for Retailer Id " + 
/* 326:384 */       this.retailerCustomerVO.getCustomerId());
/* 327:385 */     return "error";
/* 328:    */   }
/* 329:    */   
/* 330:    */   public String viewNextRetailerTransaction()
/* 331:    */     throws Exception
/* 332:    */   {
/* 333:392 */     this.retailerCustomerServiceInf = new RetailerCustomerServiceImpl();
/* 334:393 */     int transId = LoginUtil.getProcessUserId();
/* 335:394 */     this.retailerCustomerVO = VOMapperHelper.getRetailerFromRetailerDetails(this.retailerCustomerVO, 
/* 336:395 */       this.retailerCustomerServiceInf.viewNextRetailerTransaction(transId));
/* 337:398 */     if (this.retailerCustomerVO.getTransactionId() != 0)
/* 338:    */     {
/* 339:399 */       logger.info("Retailer Transaction found successfully for Transaction Id  " + 
/* 340:400 */         this.retailerCustomerVO.getTransactionId());
/* 341:401 */       addActionMessage("Retailer Transaction found successfully for Transaction Id " + 
/* 342:402 */         this.retailerCustomerVO.getTransactionId());
/* 343:403 */       return "success";
/* 344:    */     }
/* 345:405 */     this.retailerCustomerVO.setTransactionId(LoginUtil.getProcessUserId());
/* 346:406 */     logger.error("Retailer Transaction not found for Transaction Id  " + 
/* 347:407 */       this.retailerCustomerVO.getTransactionId());
/* 348:408 */     addActionError("Retailer Transaction not found for Transaction Id " + 
/* 349:409 */       this.retailerCustomerVO.getTransactionId());
/* 350:410 */     return "error";
/* 351:    */   }
/* 352:    */   
/* 353:    */   public String viewPreviousRetailerDetail()
/* 354:    */     throws Exception
/* 355:    */   {
/* 356:416 */     this.retailerCustomerServiceInf = new RetailerCustomerServiceImpl();
/* 357:417 */     int retailerId = LoginUtil.getProcessUserId();
/* 358:418 */     this.retailerCustomerVO = VOMapperHelper.getRetailerFromRetailerDetails(this.retailerCustomerVO, 
/* 359:419 */       this.retailerCustomerServiceInf.viewPreviousRetailerDetail(retailerId));
/* 360:422 */     if (this.retailerCustomerVO.getCustomerId() != 0)
/* 361:    */     {
/* 362:423 */       logger.info("Retailer details found successfully for Retailer Id  " + 
/* 363:424 */         this.retailerCustomerVO.getCustomerId());
/* 364:425 */       addActionMessage("Retailer details found successfully for Retailer Id " + 
/* 365:426 */         this.retailerCustomerVO.getCustomerId());
/* 366:427 */       return "success";
/* 367:    */     }
/* 368:428 */     if (LoginUtil.getProcessUserId() == -1)
/* 369:    */     {
/* 370:429 */       LoginUtil.setProcessUserId(this.retailerCustomerDaoInf.getRetailerLastRecord() + 1);
/* 371:430 */       logger.error("Retailer details not found");
/* 372:431 */       addActionError("Retailer details not found");
/* 373:432 */       return "error";
/* 374:    */     }
/* 375:434 */     this.retailerCustomerVO.setCustomerId(LoginUtil.getProcessUserId());
/* 376:435 */     logger.error("Retailer details not found for Retailer Id  " + 
/* 377:436 */       this.retailerCustomerVO.getCustomerId());
/* 378:437 */     addActionError("Retailer details not found for Retailer Id " + 
/* 379:438 */       this.retailerCustomerVO.getCustomerId());
/* 380:439 */     return "error";
/* 381:    */   }
/* 382:    */   
/* 383:    */   public String viewPreviousRetailerTransaction()
/* 384:    */     throws Exception
/* 385:    */   {
/* 386:448 */     this.retailerCustomerServiceInf = new RetailerCustomerServiceImpl();
/* 387:449 */     int transId = LoginUtil.getProcessUserId();
/* 388:450 */     this.retailerCustomerVO = VOMapperHelper.getRetailerFromRetailerDetails(this.retailerCustomerVO, 
/* 389:451 */       this.retailerCustomerServiceInf.viewPreviousRetailerTransaction(transId));
/* 390:454 */     if (this.retailerCustomerVO.getTransactionId() != 0)
/* 391:    */     {
/* 392:455 */       logger.info("Retailer Transaction found successfully for Transaction Id  " + 
/* 393:456 */         this.retailerCustomerVO.getTransactionId());
/* 394:457 */       addActionMessage("Retailer Transaction found successfully for Transaction Id " + 
/* 395:458 */         this.retailerCustomerVO.getTransactionId());
/* 396:459 */       return "success";
/* 397:    */     }
/* 398:460 */     if (LoginUtil.getProcessUserId() == -1)
/* 399:    */     {
/* 400:461 */       LoginUtil.setProcessUserId(this.retailerCustomerDaoInf.getRetailerTransactionLastRecord() + 1);
/* 401:462 */       logger.error("Retailer Transaction not found");
/* 402:463 */       addActionError("Retailer Transaction not found");
/* 403:464 */       return "error";
/* 404:    */     }
/* 405:466 */     this.retailerCustomerVO.setTransactionId(LoginUtil.getProcessUserId());
/* 406:467 */     logger.error("Retailer Transaction not found for Transaction Id  " + 
/* 407:468 */       this.retailerCustomerVO.getTransactionId());
/* 408:469 */     addActionError("Retailer Transaction not found for Transaction Id " + 
/* 409:470 */       this.retailerCustomerVO.getTransactionId());
/* 410:471 */     return "error";
/* 411:    */   }
/* 412:    */   
/* 413:    */   public String addPayDue()
/* 414:    */     throws RecordNotFoundException
/* 415:    */   {
/* 416:480 */     this.retailerCustomerServiceInf = new RetailerCustomerServiceImpl();
/* 417:481 */     int transId = LoginUtil.getProcessUserId();
/* 418:482 */     if (this.retailerCustomerVO.getPayment() != 0.0F)
/* 419:    */     {
/* 420:483 */       if (this.retailerCustomerVO.getPayment() <= this.retailerCustomerVO.getTotalDue())
/* 421:    */       {
/* 422:484 */         this.retailerCustomerServiceInf.addPayDue(this.retailerCustomerVO, transId);
/* 423:485 */         return "success";
/* 424:    */       }
/* 425:487 */       logger.error(" Error: While inserting Retailer Transaction for pay due amount due to amount over pay");
/* 426:488 */       addActionError("Sorry, Amount OverPay!!!");
/* 427:489 */       return "error";
/* 428:    */     }
/* 429:493 */     logger.error(" Error: While inserting Retailer Transaction for pay due amount due to Zero Payment!!");
/* 430:494 */     addActionError("Sorry, Can not Proceed without Payment, User has to Pay Something !!!");
/* 431:495 */     return "error";
/* 432:    */   }
/* 433:    */   
/* 434:    */   public void getCityJASONList()
/* 435:    */     throws IOException
/* 436:    */   {
/* 437:    */     try
/* 438:    */     {
/* 439:502 */       NameHelper nameHelper = new NameHelper();
/* 440:503 */       int stateId = Integer.parseInt(this.request.getParameter("stateId"));
/* 441:504 */       JSONObject cityList = new JSONObject();
/* 442:505 */       JSONObject cityList1 = new JSONObject();
/* 443:506 */       String stateName = nameHelper.getStateNameByStateId(stateId);
/* 444:    */       
/* 445:508 */       cityList = this.listHelper.cityListJSON(stateName);
/* 446:    */       
/* 447:    */ 
/* 448:    */ 
/* 449:512 */       PrintWriter out = this.response.getWriter();
/* 450:513 */       System.out.println("%%%%%%%%%%" + cityList);
/* 451:514 */       cityList1.put("cityList", cityList);
/* 452:515 */       out.print(cityList1);
/* 453:    */     }
/* 454:    */     catch (Exception exception)
/* 455:    */     {
/* 456:519 */       System.out.println(exception);
/* 457:    */     }
/* 458:    */   }
/* 459:    */   
/* 460:    */   public void setServletResponse(HttpServletResponse response)
/* 461:    */   {
/* 462:526 */     this.response = response;
/* 463:    */   }
/* 464:    */   
/* 465:    */   public void setServletRequest(HttpServletRequest request)
/* 466:    */   {
/* 467:531 */     this.request = request;
/* 468:    */   }
/* 469:    */   
/* 470:    */   public void setSession(Map<String, Object> session)
/* 471:    */   {
/* 472:536 */     this.session = session;
/* 473:    */   }
/* 474:    */   
/* 475:    */   public RetailerCustomerVO getModel()
/* 476:    */   {
/* 477:541 */     return this.retailerCustomerVO;
/* 478:    */   }
/* 479:    */   
/* 480:    */   public Map<Integer, String> getCountryList()
/* 481:    */   {
/* 482:545 */     return this.countryList;
/* 483:    */   }
/* 484:    */   
/* 485:    */   public void setCountryList(Map<Integer, String> countryList)
/* 486:    */   {
/* 487:549 */     this.countryList = countryList;
/* 488:    */   }
/* 489:    */   
/* 490:    */   public Map<Integer, String> getSalutationList()
/* 491:    */   {
/* 492:553 */     return this.salutationList;
/* 493:    */   }
/* 494:    */   
/* 495:    */   public void setSalutationList(Map<Integer, String> salutationList)
/* 496:    */   {
/* 497:557 */     this.salutationList = salutationList;
/* 498:    */   }
/* 499:    */   
/* 500:    */   public HashMap<Integer, String> getParentAccountList()
/* 501:    */   {
/* 502:561 */     return this.parentAccountList;
/* 503:    */   }
/* 504:    */   
/* 505:    */   public void setParentAccountList(HashMap<Integer, String> parentAccountList)
/* 506:    */   {
/* 507:565 */     this.parentAccountList = parentAccountList;
/* 508:    */   }
/* 509:    */   
/* 510:    */   public List<RetailerCustomerVO> getRetailerDetailList()
/* 511:    */   {
/* 512:569 */     return this.retailerDetailList;
/* 513:    */   }
/* 514:    */   
/* 515:    */   public void setRetailerDetailList(List<RetailerCustomerVO> retailerDetailList)
/* 516:    */   {
/* 517:573 */     this.retailerDetailList = retailerDetailList;
/* 518:    */   }
/* 519:    */   
/* 520:    */   public RetailerCustomerVO getRetailerCustomerVO()
/* 521:    */   {
/* 522:577 */     return this.retailerCustomerVO;
/* 523:    */   }
/* 524:    */   
/* 525:    */   public void setRetailerCustomerVO(RetailerCustomerVO retailerCustomerVO)
/* 526:    */   {
/* 527:581 */     this.retailerCustomerVO = retailerCustomerVO;
/* 528:    */   }
/* 529:    */   
/* 530:    */   public List<RetailerCustomerVO> getRetailerTransactionDetailList()
/* 531:    */   {
/* 532:585 */     return this.retailerTransactionDetailList;
/* 533:    */   }
/* 534:    */   
/* 535:    */   public void setRetailerTransactionDetailList(List<RetailerCustomerVO> retailerTransactionDetailList)
/* 536:    */   {
/* 537:590 */     this.retailerTransactionDetailList = retailerTransactionDetailList;
/* 538:    */   }
/* 539:    */   
/* 540:    */   public Map<Integer, String> getRetailerCustomerSearchList()
/* 541:    */   {
/* 542:594 */     return this.retailerCustomerSearchList;
/* 543:    */   }
/* 544:    */   
/* 545:    */   public void setRetailerCustomerSearchList(Map<Integer, String> retailerCustomerSearchList)
/* 546:    */   {
/* 547:599 */     this.retailerCustomerSearchList = retailerCustomerSearchList;
/* 548:    */   }
/* 549:    */   
/* 550:    */   public Map<Integer, String> getRetailerCustomerTransactionSearchList()
/* 551:    */   {
/* 552:603 */     return this.retailerCustomerTransactionSearchList;
/* 553:    */   }
/* 554:    */   
/* 555:    */   public void setRetailerCustomerTransactionSearchList(Map<Integer, String> retailerCustomerTransactionSearchList)
/* 556:    */   {
/* 557:608 */     this.retailerCustomerTransactionSearchList = retailerCustomerTransactionSearchList;
/* 558:    */   }
/* 559:    */   
/* 560:    */   public Map<Integer, String> getPayModeList()
/* 561:    */   {
/* 562:612 */     return this.payModeList;
/* 563:    */   }
/* 564:    */   
/* 565:    */   public void setPayModeList(Map<Integer, String> payModeList)
/* 566:    */   {
/* 567:616 */     this.payModeList = payModeList;
/* 568:    */   }
/* 569:    */   
/* 570:    */   public Map<Integer, String> getStateList()
/* 571:    */   {
/* 572:620 */     return this.stateList;
/* 573:    */   }
/* 574:    */   
/* 575:    */   public void setStateList(Map<Integer, String> stateList)
/* 576:    */   {
/* 577:624 */     this.stateList = stateList;
/* 578:    */   }
/* 579:    */   
/* 580:    */   public Map<Integer, String> getCityList()
/* 581:    */   {
/* 582:628 */     return this.cityList;
/* 583:    */   }
/* 584:    */   
/* 585:    */   public void setCityList(Map<Integer, String> cityList)
/* 586:    */   {
/* 587:632 */     this.cityList = cityList;
/* 588:    */   }
/* 589:    */   
/* 590:    */   public Map<Integer, String> getRetailerList()
/* 591:    */   {
/* 592:636 */     return this.retailerList;
/* 593:    */   }
/* 594:    */   
/* 595:    */   public void setRetailerList(Map<Integer, String> retailerList)
/* 596:    */   {
/* 597:640 */     this.retailerList = retailerList;
/* 598:    */   }
/* 599:    */   
/* 600:    */   public Map<String, Object> getSession()
/* 601:    */   {
/* 602:644 */     return this.session;
/* 603:    */   }
/* 604:    */   
/* 605:    */   public HttpServletRequest getRequest()
/* 606:    */   {
/* 607:648 */     return this.request;
/* 608:    */   }
/* 609:    */   
/* 610:    */   public void setRequest(HttpServletRequest request)
/* 611:    */   {
/* 612:652 */     this.request = request;
/* 613:    */   }
/* 614:    */   
/* 615:    */   public HttpServletResponse getResponse()
/* 616:    */   {
/* 617:656 */     return this.response;
/* 618:    */   }
/* 619:    */   
/* 620:    */   public void setResponse(HttpServletResponse response)
/* 621:    */   {
/* 622:660 */     this.response = response;
/* 623:    */   }
/* 624:    */ }


/* Location:           C:\Users\bharti\Desktop\Chouksay\lost\action\
 * Qualified Name:     com.bst.ckt.action.RetailerCustomerAction
 * JD-Core Version:    0.7.0.1
 */