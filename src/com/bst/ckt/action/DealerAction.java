/*   1:    */ package com.bst.ckt.action;
/*   2:    */ 
/*   3:    */ import com.bst.ckt.common.LoginUtil;
/*   4:    */ import com.bst.ckt.dao.DealerDaoImpl;
/*   5:    */ import com.bst.ckt.dao.DealerDaoInf;
/*   6:    */ import com.bst.ckt.exception.CreateFailedException;
/*   7:    */ import com.bst.ckt.exception.DeleteFailedException;
/*   8:    */ import com.bst.ckt.exception.RecordNotFoundException;
/*   9:    */ import com.bst.ckt.exception.UpdateFailedException;
/*  10:    */ import com.bst.ckt.helper.DealerDetailsAdvanceSearch;
/*  11:    */ import com.bst.ckt.helper.DealerTransactionAdvanceSearch;
/*  12:    */ import com.bst.ckt.helper.ListHelper;
/*  13:    */ import com.bst.ckt.helper.NameHelper;
/*  14:    */ import com.bst.ckt.helper.Salutation;
/*  15:    */ import com.bst.ckt.helper.VOMapperHelper;
/*  16:    */ import com.bst.ckt.service.DealerServiceImpl;
/*  17:    */ import com.bst.ckt.service.DealerServiceInf;
/*  18:    */ import com.bst.ckt.vo.DealerVO;
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
/*  36:    */ public class DealerAction
/*  37:    */   extends ActionSupport
/*  38:    */   implements ModelDriven<DealerVO>, SessionAware, ServletRequestAware, ServletResponseAware
/*  39:    */ {
/*  40:    */   private static final long serialVersionUID = 1L;
/*  41: 56 */   private static final Logger logger = Logger.getLogger(DealerAction.class);
/*  42: 58 */   HttpServletRequest request = (HttpServletRequest)ActionContext.getContext().get("com.opensymphony.xwork2.dispatcher.HttpServletRequest");
/*  43: 59 */   DealerVO dealerVO = new DealerVO();
/*  44: 61 */   ListHelper listHelper = new ListHelper();
/*  45: 62 */   DealerServiceInf dealerServiceInf = null;
/*  46: 63 */   DealerDaoInf dealerDaoInf = new DealerDaoImpl();
/*  47: 65 */   HttpServletResponse response = null;
/*  48:    */   private Map<Integer, String> countryList;
/*  49:    */   private Map<Integer, String> dealerList;
/*  50:    */   private Map<Integer, String> payModeList;
/*  51:    */   private HashMap<Integer, String> parentAccountList;
/*  52:    */   private Map<Integer, String> salutationList;
/*  53: 71 */   List<DealerVO> dealerDetailList = null;
/*  54: 72 */   List<DealerVO> dealerTransactionDetailList = null;
/*  55: 73 */   private Map<Integer, String> stateList = null;
/*  56: 74 */   private Map<Integer, String> cityList = null;
/*  57:    */   private Map<Integer, String> dealerDetailSearchList;
/*  58:    */   private Map<Integer, String> dealerTransactionSearchList;
/*  59: 77 */   Map<String, Object> session = null;
/*  60:    */   
/*  61:    */   public DealerAction()
/*  62:    */     throws Exception
/*  63:    */   {
/*  64: 83 */     this.countryList = this.listHelper.countryList();
/*  65: 84 */     this.parentAccountList = this.listHelper.getParentAccountList();
/*  66: 85 */     this.salutationList = Salutation.getSalutationList();
/*  67: 86 */     this.countryList = this.listHelper.countryList();
/*  68: 87 */     this.dealerList = this.listHelper.dealerList();
/*  69: 88 */     this.payModeList = this.listHelper.getPaymentModeList();
/*  70: 89 */     this.stateList = this.listHelper.getStateList();
/*  71: 90 */     this.cityList = this.listHelper.getCityList();
/*  72: 91 */     setDealerDetailSearchList(DealerDetailsAdvanceSearch.getDealerSearchList());
/*  73: 92 */     setDealerTransactionSearchList(DealerTransactionAdvanceSearch.getDealerTransactionSearchList());
/*  74:    */   }
/*  75:    */   
/*  76:    */   public String execute()
/*  77:    */     throws Exception
/*  78:    */   {
/*  79:109 */     this.dealerServiceInf = new DealerServiceImpl();
/*  80:    */     
/*  81:    */ 
/*  82:112 */     this.dealerDetailList = this.dealerServiceInf
/*  83:113 */       .retriveDealerDetailsGrid(this.dealerVO);
/*  84:114 */     this.dealerTransactionDetailList = this.dealerServiceInf.viewDealerTransactionDetailsGrid(this.dealerVO);
/*  85:    */     
/*  86:116 */     return "success";
/*  87:    */   }
/*  88:    */   
/*  89:    */   public String addDealer()
/*  90:    */     throws CreateFailedException
/*  91:    */   {
/*  92:133 */     this.dealerServiceInf = new DealerServiceImpl();
/*  93:134 */     String message = this.dealerServiceInf.addDealerDetails(this.dealerVO);
/*  94:135 */     if ("SUCCESS".equalsIgnoreCase(message))
/*  95:    */     {
/*  96:136 */       logger.info("Dealer Details Successfully Inserted!");
/*  97:137 */       addActionMessage("Dealer Details Successfully Inserted!");
/*  98:138 */       return "success";
/*  99:    */     }
/* 100:140 */     if ("FAILURE".equalsIgnoreCase(message))
/* 101:    */     {
/* 102:142 */       logger.info("Error:while  Inserting Dealer Details!");
/* 103:143 */       addActionError("Error:while  Inserting Dealer Details!");
/* 104:144 */       return "input";
/* 105:    */     }
/* 106:147 */     return "none";
/* 107:    */   }
/* 108:    */   
/* 109:    */   public String viewDealerDetailsGrid()
/* 110:    */     throws RecordNotFoundException
/* 111:    */   {
/* 112:153 */     System.out.println("hello dealer@@@@@@@");
/* 113:154 */     this.dealerServiceInf = new DealerServiceImpl();
/* 114:    */     
/* 115:    */ 
/* 116:157 */     this.dealerDetailList = this.dealerServiceInf
/* 117:158 */       .retriveDealerDetailsForAdvanceSearch(this.dealerVO);
/* 118:160 */     if (this.dealerDetailList == null)
/* 119:    */     {
/* 120:161 */       logger.error(" Error: While getting dealer details For Search");
/* 121:162 */       addActionError("No Records found");
/* 122:163 */       return "error";
/* 123:    */     }
/* 124:165 */     logger.info("Records found Successfully");
/* 125:166 */     return "success";
/* 126:    */   }
/* 127:    */   
/* 128:    */   public String viewDealerTransactionDetailsGrid()
/* 129:    */     throws RecordNotFoundException
/* 130:    */   {
/* 131:174 */     this.dealerServiceInf = new DealerServiceImpl();
/* 132:    */     
/* 133:    */ 
/* 134:177 */     this.dealerTransactionDetailList = this.dealerServiceInf.viewDealerTransactionForSearch(this.dealerVO);
/* 135:179 */     if (this.dealerTransactionDetailList == null)
/* 136:    */     {
/* 137:180 */       logger.error(" Error: While getting dealer transaction for search");
/* 138:181 */       addActionError("No Records found");
/* 139:182 */       return "error";
/* 140:    */     }
/* 141:184 */     logger.info("Records found Successfully");
/* 142:185 */     return "success";
/* 143:    */   }
/* 144:    */   
/* 145:    */   public String viewSpecificDealerTransaction()
/* 146:    */     throws RecordNotFoundException
/* 147:    */   {
/* 148:193 */     this.dealerServiceInf = new DealerServiceImpl();
/* 149:    */     
/* 150:195 */     String id = this.request.getParameter("command");
/* 151:    */     
/* 152:197 */     int dealerId = Integer.parseInt(id);
/* 153:198 */     LoginUtil.setProcessUserId(dealerId);
/* 154:199 */     System.out.println(dealerId);
/* 155:    */     
/* 156:201 */     this.dealerVO = VOMapperHelper.getDealerFromDealerDetails(this.dealerVO, this.dealerServiceInf.retriveSpecificDealerTransaction(dealerId));
/* 157:202 */     System.out.println(this.dealerVO.getTotalDue() + "**********we r in action");
/* 158:203 */     return "success";
/* 159:    */   }
/* 160:    */   
/* 161:    */   public String viewSpecificDealerDetail()
/* 162:    */     throws RecordNotFoundException
/* 163:    */   {
/* 164:208 */     this.dealerServiceInf = new DealerServiceImpl();
/* 165:    */     
/* 166:210 */     String id = this.request.getParameter("command");
/* 167:    */     
/* 168:212 */     int dealerId = Integer.parseInt(id);
/* 169:213 */     LoginUtil.setProcessUserId(dealerId);
/* 170:214 */     System.out.println(dealerId);
/* 171:    */     
/* 172:216 */     this.dealerVO = VOMapperHelper.getDealerFromDealerDetails(this.dealerVO, this.dealerServiceInf.retriveSpecificDealerDetail(dealerId));
/* 173:    */     
/* 174:218 */     return "success";
/* 175:    */   }
/* 176:    */   
/* 177:    */   public String deleteSpecificDealerDetails()
/* 178:    */     throws DeleteFailedException
/* 179:    */   {
/* 180:222 */     String delId = this.request.getParameter("command");
/* 181:223 */     int dealerId = Integer.parseInt(delId);
/* 182:224 */     this.dealerServiceInf = new DealerServiceImpl();
/* 183:225 */     String message = this.dealerServiceInf.deleteSpecificDealerDetails(dealerId);
/* 184:226 */     if (message.equals("SUCCESS"))
/* 185:    */     {
/* 186:227 */       logger.info("Records found Successfully");
/* 187:228 */       addActionMessage("Dealer Details Deleted successfully!!");
/* 188:229 */       return "success";
/* 189:    */     }
/* 190:231 */     logger.error(" Error: While getting Dealer details");
/* 191:232 */     addActionError("No Records found");
/* 192:233 */     return "error";
/* 193:    */   }
/* 194:    */   
/* 195:    */   public String deleteSpecificDealerTransaction()
/* 196:    */     throws DeleteFailedException
/* 197:    */   {
/* 198:241 */     String delId = this.request.getParameter("command");
/* 199:242 */     int dealerId = Integer.parseInt(delId);
/* 200:243 */     this.dealerServiceInf = new DealerServiceImpl();
/* 201:244 */     String message = this.dealerServiceInf.deleteSpecificDealerTransaction(dealerId);
/* 202:245 */     if (message.equals("SUCCESS"))
/* 203:    */     {
/* 204:246 */       logger.info("Records found Successfully");
/* 205:247 */       addActionMessage("Dealer Transaction Deleted successfully!!");
/* 206:248 */       return "success";
/* 207:    */     }
/* 208:250 */     logger.error(" Error: While getting Dealer Transaction");
/* 209:251 */     addActionError("No Records found");
/* 210:252 */     return "error";
/* 211:    */   }
/* 212:    */   
/* 213:    */   public String viewSpecificRecordForEdit()
/* 214:    */     throws RecordNotFoundException
/* 215:    */   {
/* 216:259 */     this.dealerServiceInf = new DealerServiceImpl();
/* 217:260 */     String id = this.request.getParameter("command");
/* 218:    */     
/* 219:262 */     int dealerId = Integer.parseInt(id);
/* 220:263 */     LoginUtil.setProcessUserId(dealerId);
/* 221:    */     
/* 222:265 */     System.out.println(dealerId);
/* 223:    */     
/* 224:267 */     this.dealerVO = VOMapperHelper.getDealerFromDealerDetails(this.dealerVO, this.dealerServiceInf.retriveSpecificDealerDetailForEdit(dealerId));
/* 225:    */     
/* 226:269 */     return "success";
/* 227:    */   }
/* 228:    */   
/* 229:    */   public String updateSpecificDealerRecord()
/* 230:    */     throws UpdateFailedException
/* 231:    */   {
/* 232:274 */     this.dealerServiceInf = new DealerServiceImpl();
/* 233:    */     
/* 234:    */ 
/* 235:277 */     int dealerId = LoginUtil.getProcessUserId();
/* 236:    */     
/* 237:279 */     System.out.println(dealerId);
/* 238:    */     
/* 239:    */ 
/* 240:282 */     this.dealerServiceInf.updateSpecificDealerRecord(this.dealerVO, dealerId);
/* 241:283 */     return "success";
/* 242:    */   }
/* 243:    */   
/* 244:    */   public String retrieveDealerTransactionByIdForPayDue()
/* 245:    */     throws RecordNotFoundException
/* 246:    */   {
/* 247:290 */     this.dealerServiceInf = new DealerServiceImpl();
/* 248:291 */     String id = this.request.getParameter("command");
/* 249:292 */     String did = this.request.getParameter("did");
/* 250:293 */     System.out.println(id + "vvvvvvvvvvvvvvvvvvvvv" + did);
/* 251:294 */     int transId = Integer.parseInt(id);
/* 252:295 */     int dId = Integer.parseInt(did);
/* 253:296 */     LoginUtil.setProcessUserId(dId);
/* 254:297 */     this.dealerVO = VOMapperHelper.getDealerFromDealerDetails(this.dealerVO, this.dealerServiceInf.retrieveDealerTransactionByIdForPayDue(transId));
/* 255:298 */     return "success";
/* 256:    */   }
/* 257:    */   
/* 258:    */   public String addPayDue()
/* 259:    */     throws CreateFailedException
/* 260:    */   {
/* 261:304 */     this.dealerServiceInf = new DealerServiceImpl();
/* 262:305 */     int transId = LoginUtil.getProcessUserId();
/* 263:306 */     if (this.dealerVO.getPayment() != 0.0F)
/* 264:    */     {
/* 265:307 */       if (this.dealerVO.getPayment() <= this.dealerVO.getTotalDue())
/* 266:    */       {
/* 267:308 */         this.dealerServiceInf.addPayDue(this.dealerVO, transId);
/* 268:309 */         return "success";
/* 269:    */       }
/* 270:311 */       logger.error(" Error: While inserting Dealer Transaction for pay due");
/* 271:312 */       addActionError("Sorry, Amount OverPay!!!");
/* 272:313 */       return "error";
/* 273:    */     }
/* 274:316 */     logger.error(" Error: While inserting Dealer Transaction for pay due amount due to Zero Payment!!");
/* 275:317 */     addActionError("Sorry, Can not Proceed without Payment, User has to Pay Something !!!");
/* 276:318 */     return "error";
/* 277:    */   }
/* 278:    */   
/* 279:    */   public String dealerTransactionPrintPDF()
/* 280:    */     throws Exception
/* 281:    */   {
/* 282:324 */     int transId = LoginUtil.getProcessUserId();
/* 283:325 */     LoginUtil.setProcessUserId(transId);
/* 284:326 */     this.dealerServiceInf = new DealerServiceImpl();
/* 285:327 */     this.dealerServiceInf.dealerTransactionPrintPDF(this.request, this.response, transId);
/* 286:328 */     return null;
/* 287:    */   }
/* 288:    */   
/* 289:    */   public String dealerDetailPrintPDF()
/* 290:    */     throws Exception
/* 291:    */   {
/* 292:332 */     int dealerId = LoginUtil.getProcessUserId();
/* 293:333 */     LoginUtil.setProcessUserId(dealerId);
/* 294:334 */     System.out.println("fffffffffff" + dealerId);
/* 295:335 */     this.dealerServiceInf = new DealerServiceImpl();
/* 296:336 */     this.dealerServiceInf.dealerDetailPrintPDF(this.request, this.response, dealerId);
/* 297:337 */     return null;
/* 298:    */   }
/* 299:    */   
/* 300:    */   public String dealerDetailExcelReport()
/* 301:    */     throws Exception
/* 302:    */   {
/* 303:342 */     this.dealerServiceInf = new DealerServiceImpl();
/* 304:343 */     this.dealerServiceInf.dealerDetailExcelReport(this.request, this.response);
/* 305:344 */     return "none";
/* 306:    */   }
/* 307:    */   
/* 308:    */   public String dealerTransactionExcelReport()
/* 309:    */     throws Exception
/* 310:    */   {
/* 311:350 */     this.dealerServiceInf = new DealerServiceImpl();
/* 312:351 */     this.dealerServiceInf.dealerTransactionExcelReport(this.request, this.response);
/* 313:352 */     return "none";
/* 314:    */   }
/* 315:    */   
/* 316:    */   public String viewNextDealerDetail()
/* 317:    */     throws Exception
/* 318:    */   {
/* 319:356 */     this.dealerServiceInf = new DealerServiceImpl();
/* 320:357 */     int dealerId = LoginUtil.getProcessUserId();
/* 321:358 */     this.dealerVO = VOMapperHelper.getDealerFromDealerDetails(this.dealerVO, 
/* 322:359 */       this.dealerServiceInf.viewNextDealerDetails(dealerId));
/* 323:362 */     if (this.dealerVO.getDealerId() != 0)
/* 324:    */     {
/* 325:363 */       logger.info("Dealer details found successfully for Dealer Id  " + 
/* 326:364 */         this.dealerVO.getDealerId());
/* 327:365 */       addActionMessage("Dealer details found successfully for Dealer Id " + 
/* 328:366 */         this.dealerVO.getDealerId());
/* 329:367 */       return "success";
/* 330:    */     }
/* 331:369 */     this.dealerVO.setDealerId(LoginUtil.getProcessUserId());
/* 332:370 */     logger.error("Dealer details not found for Dealer Id  " + 
/* 333:371 */       this.dealerVO.getDealerId());
/* 334:372 */     addActionError("Dealer details not found for Dealer Id " + 
/* 335:373 */       this.dealerVO.getDealerId());
/* 336:374 */     return "error";
/* 337:    */   }
/* 338:    */   
/* 339:    */   public String viewPreviousDealerDetail()
/* 340:    */     throws Exception
/* 341:    */   {
/* 342:380 */     this.dealerServiceInf = new DealerServiceImpl();
/* 343:381 */     int dealerId = LoginUtil.getProcessUserId();
/* 344:382 */     this.dealerVO = VOMapperHelper.getDealerFromDealerDetails(this.dealerVO, 
/* 345:383 */       this.dealerServiceInf.viewPreviousDealerDetail(dealerId));
/* 346:386 */     if (this.dealerVO.getDealerId() != 0)
/* 347:    */     {
/* 348:387 */       logger.info("Dealer details found successfully for Dealer Id  " + 
/* 349:388 */         this.dealerVO.getDealerId());
/* 350:389 */       addActionMessage("Dealer details found successfully for Dealer Id " + 
/* 351:390 */         this.dealerVO.getDealerId());
/* 352:391 */       return "success";
/* 353:    */     }
/* 354:392 */     if (LoginUtil.getProcessUserId() == -1)
/* 355:    */     {
/* 356:393 */       LoginUtil.setProcessUserId(this.dealerDaoInf.getDealerLastRecord() + 1);
/* 357:394 */       logger.error("Dealer details not found");
/* 358:395 */       addActionError("Dealer details not found");
/* 359:396 */       return "error";
/* 360:    */     }
/* 361:398 */     this.dealerVO.setDealerId(LoginUtil.getProcessUserId());
/* 362:399 */     logger.error("Dealer details not found for Dealer Id  " + 
/* 363:400 */       this.dealerVO.getDealerId());
/* 364:401 */     addActionError("Dealer details not found for Dealer Id " + 
/* 365:402 */       this.dealerVO.getDealerId());
/* 366:403 */     return "error";
/* 367:    */   }
/* 368:    */   
/* 369:    */   public String viewNextDealerTransaction()
/* 370:    */     throws Exception
/* 371:    */   {
/* 372:412 */     this.dealerServiceInf = new DealerServiceImpl();
/* 373:413 */     int transId = LoginUtil.getProcessUserId();
/* 374:414 */     this.dealerVO = VOMapperHelper.getDealerFromDealerDetails(this.dealerVO, 
/* 375:415 */       this.dealerServiceInf.viewNextDealerTransaction(transId));
/* 376:418 */     if (this.dealerVO.getTransactionId() != 0)
/* 377:    */     {
/* 378:419 */       logger.info("Dealer Transaction found successfully for Transaction Id  " + 
/* 379:420 */         this.dealerVO.getTransactionId());
/* 380:421 */       addActionMessage("Dealer details found successfully for Transaction Id " + 
/* 381:422 */         this.dealerVO.getTransactionId());
/* 382:423 */       return "success";
/* 383:    */     }
/* 384:425 */     this.dealerVO.setTransactionId(LoginUtil.getProcessUserId());
/* 385:426 */     logger.error("Dealer Transaction not found for Transaction Id  " + 
/* 386:427 */       this.dealerVO.getTransactionId());
/* 387:428 */     addActionError("Dealer Transaction not found for Transaction Id " + 
/* 388:429 */       this.dealerVO.getTransactionId());
/* 389:430 */     return "error";
/* 390:    */   }
/* 391:    */   
/* 392:    */   public String viewPreviousDealerTransaction()
/* 393:    */     throws Exception
/* 394:    */   {
/* 395:438 */     this.dealerServiceInf = new DealerServiceImpl();
/* 396:439 */     int transId = LoginUtil.getProcessUserId();
/* 397:440 */     this.dealerVO = VOMapperHelper.getDealerFromDealerDetails(this.dealerVO, 
/* 398:441 */       this.dealerServiceInf.viewPreviousDealerTransaction(transId));
/* 399:444 */     if (this.dealerVO.getTransactionId() != 0)
/* 400:    */     {
/* 401:445 */       logger.info("Dealer Transaction found successfully for Transaction Id  " + 
/* 402:446 */         this.dealerVO.getTransactionId());
/* 403:447 */       addActionMessage("Dealer Transaction found successfully for Transaction Id " + 
/* 404:448 */         this.dealerVO.getTransactionId());
/* 405:449 */       return "success";
/* 406:    */     }
/* 407:450 */     if (LoginUtil.getProcessUserId() == -1)
/* 408:    */     {
/* 409:451 */       LoginUtil.setProcessUserId(this.dealerDaoInf.getDealerTransactionLastRecord() + 1);
/* 410:452 */       logger.error("Dealer Transaction not found");
/* 411:453 */       addActionError("Dealer Transaction not found");
/* 412:454 */       return "error";
/* 413:    */     }
/* 414:456 */     this.dealerVO.setTransactionId(LoginUtil.getProcessUserId());
/* 415:457 */     logger.error("Dealer Transaction not found for Transaction Id  " + 
/* 416:458 */       this.dealerVO.getTransactionId());
/* 417:459 */     addActionError("Dealer Transaction not found for Transaction Id " + 
/* 418:460 */       this.dealerVO.getTransactionId());
/* 419:461 */     return "error";
/* 420:    */   }
/* 421:    */   
/* 422:    */   public void getCityJASONList()
/* 423:    */     throws IOException
/* 424:    */   {
/* 425:    */     try
/* 426:    */     {
/* 427:469 */       NameHelper nameHelper = new NameHelper();
/* 428:470 */       int stateId = Integer.parseInt(this.request.getParameter("stateId"));
/* 429:471 */       JSONObject cityList = new JSONObject();
/* 430:472 */       JSONObject cityList1 = new JSONObject();
/* 431:473 */       String stateName = nameHelper.getStateNameByStateId(stateId);
/* 432:    */       
/* 433:475 */       cityList = this.listHelper.cityListJSON(stateName);
/* 434:    */       
/* 435:    */ 
/* 436:    */ 
/* 437:479 */       PrintWriter out = this.response.getWriter();
/* 438:480 */       System.out.println("%%%%%%%%%%" + cityList);
/* 439:481 */       cityList1.put("cityList", cityList);
/* 440:482 */       out.print(cityList1);
/* 441:    */     }
/* 442:    */     catch (Exception exception)
/* 443:    */     {
/* 444:486 */       System.out.println(exception);
/* 445:    */     }
/* 446:    */   }
/* 447:    */   
/* 448:    */   public void setServletResponse(HttpServletResponse response)
/* 449:    */   {
/* 450:492 */     this.response = response;
/* 451:    */   }
/* 452:    */   
/* 453:    */   public void setServletRequest(HttpServletRequest request)
/* 454:    */   {
/* 455:497 */     this.request = request;
/* 456:    */   }
/* 457:    */   
/* 458:    */   public void setSession(Map<String, Object> session)
/* 459:    */   {
/* 460:502 */     this.session = session;
/* 461:    */   }
/* 462:    */   
/* 463:    */   public DealerVO getDealerVO()
/* 464:    */   {
/* 465:506 */     return this.dealerVO;
/* 466:    */   }
/* 467:    */   
/* 468:    */   public void setDealerVO(DealerVO dealerVO)
/* 469:    */   {
/* 470:510 */     this.dealerVO = dealerVO;
/* 471:    */   }
/* 472:    */   
/* 473:    */   public List<DealerVO> getDealerTransactionDetailList()
/* 474:    */   {
/* 475:514 */     return this.dealerTransactionDetailList;
/* 476:    */   }
/* 477:    */   
/* 478:    */   public void setDealerTransactionDetailList(List<DealerVO> dealerTransactionDetailList)
/* 479:    */   {
/* 480:519 */     this.dealerTransactionDetailList = dealerTransactionDetailList;
/* 481:    */   }
/* 482:    */   
/* 483:    */   public DealerVO getModel()
/* 484:    */   {
/* 485:524 */     return this.dealerVO;
/* 486:    */   }
/* 487:    */   
/* 488:    */   public Map<Integer, String> getCountryList()
/* 489:    */   {
/* 490:528 */     return this.countryList;
/* 491:    */   }
/* 492:    */   
/* 493:    */   public void setCountryList(Map<Integer, String> countryList)
/* 494:    */   {
/* 495:532 */     this.countryList = countryList;
/* 496:    */   }
/* 497:    */   
/* 498:    */   public HashMap<Integer, String> getParentAccountList()
/* 499:    */   {
/* 500:536 */     return this.parentAccountList;
/* 501:    */   }
/* 502:    */   
/* 503:    */   public void setParentAccountList(HashMap<Integer, String> parentAccountList)
/* 504:    */   {
/* 505:540 */     this.parentAccountList = parentAccountList;
/* 506:    */   }
/* 507:    */   
/* 508:    */   public Map<Integer, String> getSalutationList()
/* 509:    */   {
/* 510:544 */     return this.salutationList;
/* 511:    */   }
/* 512:    */   
/* 513:    */   public void setSalutationList(Map<Integer, String> salutationList)
/* 514:    */   {
/* 515:548 */     this.salutationList = salutationList;
/* 516:    */   }
/* 517:    */   
/* 518:    */   public List<DealerVO> getDealerDetailList()
/* 519:    */   {
/* 520:552 */     return this.dealerDetailList;
/* 521:    */   }
/* 522:    */   
/* 523:    */   public void setDealerDetailList(List<DealerVO> dealerDetailList)
/* 524:    */   {
/* 525:556 */     this.dealerDetailList = dealerDetailList;
/* 526:    */   }
/* 527:    */   
/* 528:    */   public Map<Integer, String> getDealerDetailSearchList()
/* 529:    */   {
/* 530:560 */     return this.dealerDetailSearchList;
/* 531:    */   }
/* 532:    */   
/* 533:    */   public void setDealerDetailSearchList(Map<Integer, String> dealerDetailSearchList)
/* 534:    */   {
/* 535:565 */     this.dealerDetailSearchList = dealerDetailSearchList;
/* 536:    */   }
/* 537:    */   
/* 538:    */   public Map<Integer, String> getDealerTransactionSearchList()
/* 539:    */   {
/* 540:569 */     return this.dealerTransactionSearchList;
/* 541:    */   }
/* 542:    */   
/* 543:    */   public void setDealerTransactionSearchList(Map<Integer, String> dealerTransactionSearchList)
/* 544:    */   {
/* 545:574 */     this.dealerTransactionSearchList = dealerTransactionSearchList;
/* 546:    */   }
/* 547:    */   
/* 548:    */   public Map<Integer, String> getDealerList()
/* 549:    */   {
/* 550:578 */     return this.dealerList;
/* 551:    */   }
/* 552:    */   
/* 553:    */   public void setDealerList(Map<Integer, String> dealerList)
/* 554:    */   {
/* 555:582 */     this.dealerList = dealerList;
/* 556:    */   }
/* 557:    */   
/* 558:    */   public Map<Integer, String> getPayModeList()
/* 559:    */   {
/* 560:586 */     return this.payModeList;
/* 561:    */   }
/* 562:    */   
/* 563:    */   public void setPayModeList(Map<Integer, String> payModeList)
/* 564:    */   {
/* 565:590 */     this.payModeList = payModeList;
/* 566:    */   }
/* 567:    */   
/* 568:    */   public Map<Integer, String> getStateList()
/* 569:    */   {
/* 570:594 */     return this.stateList;
/* 571:    */   }
/* 572:    */   
/* 573:    */   public void setStateList(Map<Integer, String> stateList)
/* 574:    */   {
/* 575:598 */     this.stateList = stateList;
/* 576:    */   }
/* 577:    */   
/* 578:    */   public Map<Integer, String> getCityList()
/* 579:    */   {
/* 580:602 */     return this.cityList;
/* 581:    */   }
/* 582:    */   
/* 583:    */   public void setCityList(Map<Integer, String> cityList)
/* 584:    */   {
/* 585:606 */     this.cityList = cityList;
/* 586:    */   }
/* 587:    */   
/* 588:    */   public Map<String, Object> getSession()
/* 589:    */   {
/* 590:610 */     return this.session;
/* 591:    */   }
/* 592:    */ }


/* Location:           C:\Users\bharti\Desktop\Chouksay\lost\action\
 * Qualified Name:     com.bst.ckt.action.DealerAction
 * JD-Core Version:    0.7.0.1
 */