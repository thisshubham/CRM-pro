/*   1:    */ package com.bst.ckt.action;
/*   2:    */ 
/*   3:    */ import com.bst.ckt.common.LoginUtil;
/*   4:    */ import com.bst.ckt.dao.ConsumerCustomerDaoImpl;
/*   5:    */ import com.bst.ckt.dao.ConsumerCustomerDaoInf;
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
/*  16:    */ import com.bst.ckt.service.ConsumerCustomerServiceImpl;
/*  17:    */ import com.bst.ckt.service.ConsumerCustomerServiceInf;
/*  18:    */ import com.bst.ckt.vo.ConsumerCustomerVO;
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
/*  36:    */ public class ConsumerCustomerAction
/*  37:    */   extends ActionSupport
/*  38:    */   implements ModelDriven<ConsumerCustomerVO>, SessionAware, ServletRequestAware, ServletResponseAware
/*  39:    */ {
/*  40:    */   private static final long serialVersionUID = 1L;
/*  41: 55 */   private static final Logger logger = Logger.getLogger(ConsumerCustomerAction.class);
/*  42: 57 */   HttpServletRequest request = (HttpServletRequest)ActionContext.getContext().get("com.opensymphony.xwork2.dispatcher.HttpServletRequest");
/*  43: 58 */   ConsumerCustomerVO consumerCustomerVO = new ConsumerCustomerVO();
/*  44: 59 */   ConsumerCustomerServiceInf consumerCustomerServiceInf = null;
/*  45: 60 */   ConsumerCustomerDaoInf consumerCustomerDaoInf = new ConsumerCustomerDaoImpl();
/*  46: 61 */   ListHelper listHelper = new ListHelper();
/*  47: 64 */   HttpServletResponse response = null;
/*  48:    */   private Map<Integer, String> countryList;
/*  49:    */   private HashMap<Integer, String> parentAccountList;
/*  50:    */   private Map<Integer, String> salutationList;
/*  51:    */   private Map<Integer, String> payModeList;
/*  52: 69 */   List<ConsumerCustomerVO> consumerDetailList = null;
/*  53: 70 */   List<ConsumerCustomerVO> consumerTransactionDetailList = null;
/*  54:    */   private Map<Integer, String> consumerCustomerSearchList;
/*  55:    */   private Map<Integer, String> consumerTransactionSearchList;
/*  56: 73 */   private Map<Integer, String> stateList = null;
/*  57: 74 */   private Map<Integer, String> cityList = null;
/*  58: 76 */   Map<String, Object> session = null;
/*  59:    */   
/*  60:    */   public ConsumerCustomerAction()
/*  61:    */     throws Exception
/*  62:    */   {
/*  63: 80 */     this.countryList = this.listHelper.countryList();
/*  64: 81 */     this.parentAccountList = this.listHelper.getParentAccountList();
/*  65: 82 */     this.salutationList = Salutation.getSalutationList();
/*  66: 83 */     this.countryList = this.listHelper.countryList();
/*  67: 84 */     this.payModeList = this.listHelper.getPaymentModeList();
/*  68: 85 */     this.stateList = this.listHelper.getStateList();
/*  69: 86 */     this.cityList = this.listHelper.getCityList();
/*  70: 87 */     setConsumerCustomerSearchList(RetailerCustomerAdvanceSearch.getRetailerCustomerSearchList());
/*  71: 88 */     setConsumerTransactionSearchList(CustomerTransactionAdvanceSearch.getCustomerTransactionSearchList());
/*  72:    */   }
/*  73:    */   
/*  74:    */   public String execute()
/*  75:    */     throws Exception
/*  76:    */   {
/*  77:104 */     this.consumerCustomerServiceInf = new ConsumerCustomerServiceImpl();
/*  78:    */     
/*  79:    */ 
/*  80:107 */     this.consumerDetailList = this.consumerCustomerServiceInf.retriveConsumerDetailsGrid(this.consumerCustomerVO);
/*  81:108 */     this.consumerTransactionDetailList = this.consumerCustomerServiceInf.retriveConsumerTransactionDetailsGrid(this.consumerCustomerVO);
/*  82:    */     
/*  83:110 */     return "success";
/*  84:    */   }
/*  85:    */   
/*  86:    */   public String viewConsumerDetailsGrid()
/*  87:    */     throws RecordNotFoundException
/*  88:    */   {
/*  89:116 */     this.consumerCustomerServiceInf = new ConsumerCustomerServiceImpl();
/*  90:    */     
/*  91:    */ 
/*  92:119 */     this.consumerDetailList = this.consumerCustomerServiceInf.retriveConsumerDetailsForAdvanceSearch(this.consumerCustomerVO);
/*  93:121 */     if (this.consumerDetailList == null)
/*  94:    */     {
/*  95:122 */       logger.error(" Error: While getting consumer details for advance search");
/*  96:123 */       addActionError("No Records found");
/*  97:124 */       return "error";
/*  98:    */     }
/*  99:126 */     logger.info("Records found Successfully");
/* 100:127 */     return "success";
/* 101:    */   }
/* 102:    */   
/* 103:    */   public String viewConsumerTransactionDetailsGrid()
/* 104:    */     throws RecordNotFoundException
/* 105:    */   {
/* 106:136 */     this.consumerCustomerServiceInf = new ConsumerCustomerServiceImpl();
/* 107:    */     
/* 108:138 */     System.out.println("While getting consumer transaction details");
/* 109:139 */     this.consumerTransactionDetailList = this.consumerCustomerServiceInf.retriveConsumerTransactionForAdvanceSearch(this.consumerCustomerVO);
/* 110:141 */     if (this.consumerTransactionDetailList == null)
/* 111:    */     {
/* 112:142 */       logger.error(" Error: While getting consumer transaction details");
/* 113:143 */       addActionError("No Records found");
/* 114:144 */       return "error";
/* 115:    */     }
/* 116:146 */     logger.info("Records found Successfully");
/* 117:147 */     return "success";
/* 118:    */   }
/* 119:    */   
/* 120:    */   public String viewSpecificConsumerDetail()
/* 121:    */     throws RecordNotFoundException
/* 122:    */   {
/* 123:153 */     this.consumerCustomerServiceInf = new ConsumerCustomerServiceImpl();
/* 124:154 */     System.out.println("hye bharti ur in view method");
/* 125:155 */     String id = this.request.getParameter("command");
/* 126:    */     
/* 127:157 */     int consumerId = Integer.parseInt(id);
/* 128:158 */     LoginUtil.setProcessUserId(consumerId);
/* 129:159 */     System.out.println(consumerId);
/* 130:    */     
/* 131:161 */     this.consumerCustomerVO = VOMapperHelper.getConsumerFromConsumerDetails(this.consumerCustomerVO, this.consumerCustomerServiceInf.retriveSpecificConsumerDetail(consumerId));
/* 132:    */     
/* 133:163 */     return "success";
/* 134:    */   }
/* 135:    */   
/* 136:    */   public String viewSpecificConsumerTransaction()
/* 137:    */     throws RecordNotFoundException
/* 138:    */   {
/* 139:170 */     this.consumerCustomerServiceInf = new ConsumerCustomerServiceImpl();
/* 140:171 */     System.out.println("hye bharti ur in view method");
/* 141:172 */     String id = this.request.getParameter("command");
/* 142:    */     
/* 143:174 */     int transId = Integer.parseInt(id);
/* 144:175 */     LoginUtil.setProcessUserId(transId);
/* 145:176 */     System.out.println(transId);
/* 146:    */     
/* 147:178 */     this.consumerCustomerVO = VOMapperHelper.getConsumerFromConsumerDetails(this.consumerCustomerVO, this.consumerCustomerServiceInf.retriveSpecificConsumerTransaction(transId));
/* 148:    */     
/* 149:180 */     return "success";
/* 150:    */   }
/* 151:    */   
/* 152:    */   public String deleteSpecificConsumerDetails()
/* 153:    */     throws DeleteFailedException
/* 154:    */   {
/* 155:185 */     String delId = this.request.getParameter("command");
/* 156:186 */     int custId = Integer.parseInt(delId);
/* 157:187 */     this.consumerCustomerServiceInf = new ConsumerCustomerServiceImpl();
/* 158:188 */     String message = this.consumerCustomerServiceInf.deleteSpecificConsumerDetails(custId);
/* 159:189 */     if (message.equals("SUCCESS"))
/* 160:    */     {
/* 161:190 */       logger.info("Records found Successfully");
/* 162:191 */       addActionMessage("Consumer Details Deleted successfully!!");
/* 163:192 */       return "success";
/* 164:    */     }
/* 165:194 */     logger.error(" Error: While getting Consumer details");
/* 166:195 */     addActionError("No Records found");
/* 167:196 */     return "error";
/* 168:    */   }
/* 169:    */   
/* 170:    */   public String deleteSpecificConsumerTransaction()
/* 171:    */     throws DeleteFailedException
/* 172:    */   {
/* 173:204 */     String delId = this.request.getParameter("command");
/* 174:205 */     int transId = Integer.parseInt(delId);
/* 175:206 */     this.consumerCustomerServiceInf = new ConsumerCustomerServiceImpl();
/* 176:207 */     String message = this.consumerCustomerServiceInf.deleteSpecificConsumerTransaction(transId);
/* 177:208 */     if (message.equals("SUCCESS"))
/* 178:    */     {
/* 179:209 */       logger.info("Records found Successfully");
/* 180:210 */       addActionMessage("Consumer Transaction Deleted successfully!!");
/* 181:211 */       return "success";
/* 182:    */     }
/* 183:213 */     logger.error(" Error: While getting Consumer transaction");
/* 184:214 */     addActionError("No Records found");
/* 185:215 */     return "error";
/* 186:    */   }
/* 187:    */   
/* 188:    */   public String addConsumer()
/* 189:    */     throws CreateFailedException
/* 190:    */   {
/* 191:224 */     this.consumerCustomerServiceInf = new ConsumerCustomerServiceImpl();
/* 192:225 */     String message = this.consumerCustomerServiceInf.addConsumerDetails(this.consumerCustomerVO);
/* 193:226 */     if ("SUCCESS".equalsIgnoreCase(message))
/* 194:    */     {
/* 195:227 */       logger.info("Retailer Details Successfully Inserted!");
/* 196:228 */       addActionMessage("Retailer Details Successfully Inserted!");
/* 197:229 */       return "success";
/* 198:    */     }
/* 199:231 */     if ("FAILURE".equalsIgnoreCase(message))
/* 200:    */     {
/* 201:233 */       logger.info("Error:while  Inserting Retailer Details!");
/* 202:234 */       addActionError("Error:while  Inserting Retailer Details!");
/* 203:235 */       return "input";
/* 204:    */     }
/* 205:238 */     return "none";
/* 206:    */   }
/* 207:    */   
/* 208:    */   public String viewSpecificRecordForEdit()
/* 209:    */     throws RecordNotFoundException
/* 210:    */   {
/* 211:242 */     this.consumerCustomerServiceInf = new ConsumerCustomerServiceImpl();
/* 212:243 */     String id = this.request.getParameter("command");
/* 213:    */     
/* 214:245 */     int consumerId = Integer.parseInt(id);
/* 215:246 */     LoginUtil.setProcessUserId(consumerId);
/* 216:    */     
/* 217:248 */     System.out.println(consumerId + "we r in action cutttie**************" + consumerId);
/* 218:    */     
/* 219:250 */     this.consumerCustomerVO = VOMapperHelper.getConsumerFromConsumerDetails(this.consumerCustomerVO, this.consumerCustomerServiceInf.retriveSpecificConsumerDetailForEdit(consumerId));
/* 220:    */     
/* 221:252 */     return "success";
/* 222:    */   }
/* 223:    */   
/* 224:    */   public String updateSpecificConsumerRecord()
/* 225:    */     throws UpdateFailedException
/* 226:    */   {
/* 227:257 */     this.consumerCustomerServiceInf = new ConsumerCustomerServiceImpl();
/* 228:    */     
/* 229:    */ 
/* 230:260 */     int consumerId = LoginUtil.getProcessUserId();
/* 231:    */     
/* 232:262 */     System.out.println(consumerId);
/* 233:    */     
/* 234:    */ 
/* 235:265 */     this.consumerCustomerServiceInf.updateSpecificConsumerRecord(this.consumerCustomerVO, consumerId);
/* 236:266 */     return "success";
/* 237:    */   }
/* 238:    */   
/* 239:    */   public String consumerTransactionPrintPDF()
/* 240:    */     throws Exception
/* 241:    */   {
/* 242:274 */     int transId = LoginUtil.getProcessUserId();
/* 243:275 */     LoginUtil.setProcessUserId(transId);
/* 244:276 */     this.consumerCustomerServiceInf = new ConsumerCustomerServiceImpl();
/* 245:277 */     this.consumerCustomerServiceInf.consumerTransactionPrintPDF(this.request, this.response, transId);
/* 246:278 */     return null;
/* 247:    */   }
/* 248:    */   
/* 249:    */   public String consumerDetailsPrintPDF()
/* 250:    */     throws Exception
/* 251:    */   {
/* 252:282 */     int transId = LoginUtil.getProcessUserId();
/* 253:283 */     LoginUtil.setProcessUserId(transId);
/* 254:284 */     this.consumerCustomerServiceInf = new ConsumerCustomerServiceImpl();
/* 255:285 */     this.consumerCustomerServiceInf.consumerDetailsPrintPDF(this.request, this.response, transId);
/* 256:286 */     return null;
/* 257:    */   }
/* 258:    */   
/* 259:    */   public String consumerDetailExcelReport()
/* 260:    */     throws Exception
/* 261:    */   {
/* 262:295 */     this.consumerCustomerServiceInf = new ConsumerCustomerServiceImpl();
/* 263:296 */     this.consumerCustomerServiceInf.consumerDetailExcelReport(this.request, this.response);
/* 264:297 */     return "none";
/* 265:    */   }
/* 266:    */   
/* 267:    */   public String consumerTransactionExcelReport()
/* 268:    */     throws Exception
/* 269:    */   {
/* 270:303 */     this.consumerCustomerServiceInf = new ConsumerCustomerServiceImpl();
/* 271:304 */     this.consumerCustomerServiceInf.consumerTransactionExcelReport(this.request, this.response);
/* 272:305 */     return "none";
/* 273:    */   }
/* 274:    */   
/* 275:    */   public String viewNextConsumerDetail()
/* 276:    */     throws Exception
/* 277:    */   {
/* 278:309 */     this.consumerCustomerServiceInf = new ConsumerCustomerServiceImpl();
/* 279:310 */     int consumerId = LoginUtil.getProcessUserId();
/* 280:311 */     this.consumerCustomerVO = VOMapperHelper.getConsumerFromConsumerDetails(this.consumerCustomerVO, 
/* 281:312 */       this.consumerCustomerServiceInf.viewNextConsumerDetail(consumerId));
/* 282:315 */     if (this.consumerCustomerVO.getCustomerId() != 0)
/* 283:    */     {
/* 284:316 */       logger.info("Consumer details found successfully for Consumer Id  " + 
/* 285:317 */         this.consumerCustomerVO.getCustomerId());
/* 286:318 */       addActionMessage("Consumer details found successfully for Consumer Id " + 
/* 287:319 */         this.consumerCustomerVO.getCustomerId());
/* 288:320 */       return "success";
/* 289:    */     }
/* 290:322 */     this.consumerCustomerVO.setCustomerId(LoginUtil.getProcessUserId());
/* 291:323 */     logger.error("Consumer details not found for Consumer Id  " + 
/* 292:324 */       this.consumerCustomerVO.getCustomerId());
/* 293:325 */     addActionError("Consumer details not found for Consumer Id " + 
/* 294:326 */       this.consumerCustomerVO.getCustomerId());
/* 295:327 */     return "error";
/* 296:    */   }
/* 297:    */   
/* 298:    */   public String viewPreviousConsumerDetail()
/* 299:    */     throws Exception
/* 300:    */   {
/* 301:333 */     this.consumerCustomerServiceInf = new ConsumerCustomerServiceImpl();
/* 302:334 */     int consumerId = LoginUtil.getProcessUserId();
/* 303:335 */     this.consumerCustomerVO = VOMapperHelper.getConsumerFromConsumerDetails(this.consumerCustomerVO, 
/* 304:336 */       this.consumerCustomerServiceInf.viewPreviousConsumerDetail(consumerId));
/* 305:339 */     if (this.consumerCustomerVO.getCustomerId() != 0)
/* 306:    */     {
/* 307:340 */       logger.info("Consumer details found successfully for Consumer Id  " + 
/* 308:341 */         this.consumerCustomerVO.getCustomerId());
/* 309:342 */       addActionMessage("Consumer details found successfully for Consumer Id " + 
/* 310:343 */         this.consumerCustomerVO.getCustomerId());
/* 311:344 */       return "success";
/* 312:    */     }
/* 313:345 */     if (LoginUtil.getProcessUserId() == -1)
/* 314:    */     {
/* 315:346 */       LoginUtil.setProcessUserId(this.consumerCustomerDaoInf.getConsumerLastRecord() + 1);
/* 316:347 */       logger.error("Consumer details not found");
/* 317:348 */       addActionError("Consumer details not found");
/* 318:349 */       return "error";
/* 319:    */     }
/* 320:351 */     this.consumerCustomerVO.setCustomerId(LoginUtil.getProcessUserId());
/* 321:352 */     logger.error("Consumer details not found for Consumer Id  " + 
/* 322:353 */       this.consumerCustomerVO.getCustomerId());
/* 323:354 */     addActionError("Consumer details not found for Consumer Id " + 
/* 324:355 */       this.consumerCustomerVO.getCustomerId());
/* 325:356 */     return "error";
/* 326:    */   }
/* 327:    */   
/* 328:    */   public String viewNextConsumerTransaction()
/* 329:    */     throws Exception
/* 330:    */   {
/* 331:366 */     this.consumerCustomerServiceInf = new ConsumerCustomerServiceImpl();
/* 332:367 */     int transId = LoginUtil.getProcessUserId();
/* 333:368 */     this.consumerCustomerVO = VOMapperHelper.getConsumerFromConsumerDetails(this.consumerCustomerVO, 
/* 334:369 */       this.consumerCustomerServiceInf.viewNextConsumerTransaction(transId));
/* 335:372 */     if (this.consumerCustomerVO.getTransactionId() != 0)
/* 336:    */     {
/* 337:373 */       logger.info("Consumer Transaction found successfully for Transaction Id  " + 
/* 338:374 */         this.consumerCustomerVO.getTransactionId());
/* 339:375 */       addActionMessage("Consumer Transaction found successfully for Transaction Id " + 
/* 340:376 */         this.consumerCustomerVO.getTransactionId());
/* 341:377 */       return "success";
/* 342:    */     }
/* 343:379 */     this.consumerCustomerVO.setTransactionId(LoginUtil.getProcessUserId());
/* 344:380 */     logger.error("Consumer Transaction not found for Transaction Id  " + 
/* 345:381 */       this.consumerCustomerVO.getTransactionId());
/* 346:382 */     addActionError("Consumer Transaction not found for Transaction Id " + 
/* 347:383 */       this.consumerCustomerVO.getTransactionId());
/* 348:384 */     return "error";
/* 349:    */   }
/* 350:    */   
/* 351:    */   public HttpServletRequest getRequest()
/* 352:    */   {
/* 353:390 */     return this.request;
/* 354:    */   }
/* 355:    */   
/* 356:    */   public void setRequest(HttpServletRequest request)
/* 357:    */   {
/* 358:394 */     this.request = request;
/* 359:    */   }
/* 360:    */   
/* 361:    */   public HttpServletResponse getResponse()
/* 362:    */   {
/* 363:398 */     return this.response;
/* 364:    */   }
/* 365:    */   
/* 366:    */   public void setResponse(HttpServletResponse response)
/* 367:    */   {
/* 368:402 */     this.response = response;
/* 369:    */   }
/* 370:    */   
/* 371:    */   public String viewPreviousConsumerTransaction()
/* 372:    */     throws Exception
/* 373:    */   {
/* 374:408 */     this.consumerCustomerServiceInf = new ConsumerCustomerServiceImpl();
/* 375:409 */     int transId = LoginUtil.getProcessUserId();
/* 376:410 */     this.consumerCustomerVO = VOMapperHelper.getConsumerFromConsumerDetails(this.consumerCustomerVO, 
/* 377:411 */       this.consumerCustomerServiceInf.viewPreviousConsumerTransaction(transId));
/* 378:414 */     if (this.consumerCustomerVO.getTransactionId() != 0)
/* 379:    */     {
/* 380:415 */       logger.info("Consumer Transaction found successfully for Transaction Id  " + 
/* 381:416 */         this.consumerCustomerVO.getTransactionId());
/* 382:417 */       addActionMessage("Consumer Transaction found successfully for Transaction Id " + 
/* 383:418 */         this.consumerCustomerVO.getTransactionId());
/* 384:419 */       return "success";
/* 385:    */     }
/* 386:420 */     if (LoginUtil.getProcessUserId() == -1)
/* 387:    */     {
/* 388:421 */       LoginUtil.setProcessUserId(this.consumerCustomerDaoInf.getConsumerTransactionLastRecord() + 1);
/* 389:422 */       logger.error("Consumer Transaction not found");
/* 390:423 */       addActionError("Consumer Transaction not found");
/* 391:424 */       return "error";
/* 392:    */     }
/* 393:426 */     this.consumerCustomerVO.setTransactionId(LoginUtil.getProcessUserId());
/* 394:427 */     logger.error("Consumer Transaction not found for Transaction Id  " + 
/* 395:428 */       this.consumerCustomerVO.getTransactionId());
/* 396:429 */     addActionError("Consumer Transaction not found for Transaction Id " + 
/* 397:430 */       this.consumerCustomerVO.getTransactionId());
/* 398:431 */     return "error";
/* 399:    */   }
/* 400:    */   
/* 401:    */   public void getCityJASONList()
/* 402:    */     throws IOException
/* 403:    */   {
/* 404:    */     try
/* 405:    */     {
/* 406:438 */       NameHelper nameHelper = new NameHelper();
/* 407:439 */       int stateId = Integer.parseInt(this.request.getParameter("stateId"));
/* 408:440 */       JSONObject cityList = new JSONObject();
/* 409:441 */       JSONObject cityList1 = new JSONObject();
/* 410:442 */       String stateName = nameHelper.getStateNameByStateId(stateId);
/* 411:    */       
/* 412:444 */       cityList = this.listHelper.cityListJSON(stateName);
/* 413:    */       
/* 414:    */ 
/* 415:    */ 
/* 416:448 */       PrintWriter out = this.response.getWriter();
/* 417:449 */       System.out.println("%%%%%%%%%%" + cityList);
/* 418:450 */       cityList1.put("cityList", cityList);
/* 419:451 */       out.print(cityList1);
/* 420:    */     }
/* 421:    */     catch (Exception exception)
/* 422:    */     {
/* 423:455 */       System.out.println(exception);
/* 424:    */     }
/* 425:    */   }
/* 426:    */   
/* 427:    */   public String retrieveConsumerTransactionByIdForPayDue()
/* 428:    */     throws RecordNotFoundException
/* 429:    */   {
/* 430:464 */     this.consumerCustomerServiceInf = new ConsumerCustomerServiceImpl();
/* 431:465 */     String id = this.request.getParameter("command");
/* 432:466 */     String did = this.request.getParameter("did");
/* 433:467 */     System.out.println(id + "vvvvvvvvvvvvvvvvvvvvv" + did);
/* 434:468 */     int transId = Integer.parseInt(id);
/* 435:469 */     int dId = Integer.parseInt(did);
/* 436:470 */     LoginUtil.setProcessUserId(dId);
/* 437:471 */     System.out.println(did + "KKKKKKKKK" + id);
/* 438:472 */     this.consumerCustomerVO = VOMapperHelper.getConsumerFromConsumerDetails(this.consumerCustomerVO, this.consumerCustomerServiceInf.retrieveConsumerTransactionByIdForPayDue(transId));
/* 439:473 */     return "success";
/* 440:    */   }
/* 441:    */   
/* 442:    */   public String addPayDue()
/* 443:    */     throws RecordNotFoundException
/* 444:    */   {
/* 445:480 */     this.consumerCustomerServiceInf = new ConsumerCustomerServiceImpl();
/* 446:481 */     int transId = LoginUtil.getProcessUserId();
/* 447:482 */     System.out.println("LLLLLLLLLLLLLLLL" + transId);
/* 448:483 */     if (this.consumerCustomerVO.getPayment() != 0.0F)
/* 449:    */     {
/* 450:484 */       if (this.consumerCustomerVO.getPayment() <= this.consumerCustomerVO.getTotalDue())
/* 451:    */       {
/* 452:485 */         this.consumerCustomerServiceInf.addPayDue(this.consumerCustomerVO, transId);
/* 453:486 */         return "success";
/* 454:    */       }
/* 455:488 */       logger.error(" Error: While inserting Consumer Transaction for pay due amount due to amount over pay");
/* 456:489 */       addActionError("Sorry, Amount OverPay!!!");
/* 457:490 */       return "error";
/* 458:    */     }
/* 459:493 */     logger.error(" Error: While inserting Consumer Transaction for pay due amount due to Zero Payment!!");
/* 460:494 */     addActionError("Sorry, Can not Proceed without Payment, User has to Pay Something !!!");
/* 461:495 */     return "error";
/* 462:    */   }
/* 463:    */   
/* 464:    */   public void setServletResponse(HttpServletResponse response)
/* 465:    */   {
/* 466:501 */     this.response = response;
/* 467:    */   }
/* 468:    */   
/* 469:    */   public void setServletRequest(HttpServletRequest request)
/* 470:    */   {
/* 471:506 */     this.request = request;
/* 472:    */   }
/* 473:    */   
/* 474:    */   public void setSession(Map<String, Object> session)
/* 475:    */   {
/* 476:511 */     this.session = session;
/* 477:    */   }
/* 478:    */   
/* 479:    */   public Map<Integer, String> getCountryList()
/* 480:    */   {
/* 481:517 */     return this.countryList;
/* 482:    */   }
/* 483:    */   
/* 484:    */   public void setCountryList(Map<Integer, String> countryList)
/* 485:    */   {
/* 486:521 */     this.countryList = countryList;
/* 487:    */   }
/* 488:    */   
/* 489:    */   public Map<Integer, String> getSalutationList()
/* 490:    */   {
/* 491:525 */     return this.salutationList;
/* 492:    */   }
/* 493:    */   
/* 494:    */   public void setSalutationList(Map<Integer, String> salutationList)
/* 495:    */   {
/* 496:529 */     this.salutationList = salutationList;
/* 497:    */   }
/* 498:    */   
/* 499:    */   public HashMap<Integer, String> getParentAccountList()
/* 500:    */   {
/* 501:533 */     return this.parentAccountList;
/* 502:    */   }
/* 503:    */   
/* 504:    */   public void setParentAccountList(HashMap<Integer, String> parentAccountList)
/* 505:    */   {
/* 506:537 */     this.parentAccountList = parentAccountList;
/* 507:    */   }
/* 508:    */   
/* 509:    */   public ConsumerCustomerVO getModel()
/* 510:    */   {
/* 511:543 */     return this.consumerCustomerVO;
/* 512:    */   }
/* 513:    */   
/* 514:    */   public List<ConsumerCustomerVO> getConsumerDetailList()
/* 515:    */   {
/* 516:547 */     return this.consumerDetailList;
/* 517:    */   }
/* 518:    */   
/* 519:    */   public void setConsumerDetailList(List<ConsumerCustomerVO> consumerDetailList)
/* 520:    */   {
/* 521:551 */     this.consumerDetailList = consumerDetailList;
/* 522:    */   }
/* 523:    */   
/* 524:    */   public ConsumerCustomerVO getConsumerCustomerVO()
/* 525:    */   {
/* 526:555 */     return this.consumerCustomerVO;
/* 527:    */   }
/* 528:    */   
/* 529:    */   public void setConsumerCustomerVO(ConsumerCustomerVO consumerCustomerVO)
/* 530:    */   {
/* 531:559 */     this.consumerCustomerVO = consumerCustomerVO;
/* 532:    */   }
/* 533:    */   
/* 534:    */   public List<ConsumerCustomerVO> getConsumerTransactionDetailList()
/* 535:    */   {
/* 536:563 */     return this.consumerTransactionDetailList;
/* 537:    */   }
/* 538:    */   
/* 539:    */   public void setConsumerTransactionDetailList(List<ConsumerCustomerVO> consumerTransactionDetailList)
/* 540:    */   {
/* 541:568 */     this.consumerTransactionDetailList = consumerTransactionDetailList;
/* 542:    */   }
/* 543:    */   
/* 544:    */   public Map<Integer, String> getConsumerCustomerSearchList()
/* 545:    */   {
/* 546:572 */     return this.consumerCustomerSearchList;
/* 547:    */   }
/* 548:    */   
/* 549:    */   public void setConsumerCustomerSearchList(Map<Integer, String> consumerCustomerSearchList)
/* 550:    */   {
/* 551:577 */     this.consumerCustomerSearchList = consumerCustomerSearchList;
/* 552:    */   }
/* 553:    */   
/* 554:    */   public Map<Integer, String> getConsumerTransactionSearchList()
/* 555:    */   {
/* 556:581 */     return this.consumerTransactionSearchList;
/* 557:    */   }
/* 558:    */   
/* 559:    */   public void setConsumerTransactionSearchList(Map<Integer, String> consumerTransactionSearchList)
/* 560:    */   {
/* 561:586 */     this.consumerTransactionSearchList = consumerTransactionSearchList;
/* 562:    */   }
/* 563:    */   
/* 564:    */   public Map<Integer, String> getPayModeList()
/* 565:    */   {
/* 566:590 */     return this.payModeList;
/* 567:    */   }
/* 568:    */   
/* 569:    */   public void setPayModeList(Map<Integer, String> payModeList)
/* 570:    */   {
/* 571:594 */     this.payModeList = payModeList;
/* 572:    */   }
/* 573:    */   
/* 574:    */   public Map<Integer, String> getStateList()
/* 575:    */   {
/* 576:598 */     return this.stateList;
/* 577:    */   }
/* 578:    */   
/* 579:    */   public void setStateList(Map<Integer, String> stateList)
/* 580:    */   {
/* 581:602 */     this.stateList = stateList;
/* 582:    */   }
/* 583:    */   
/* 584:    */   public Map<Integer, String> getCityList()
/* 585:    */   {
/* 586:606 */     return this.cityList;
/* 587:    */   }
/* 588:    */   
/* 589:    */   public void setCityList(Map<Integer, String> cityList)
/* 590:    */   {
/* 591:610 */     this.cityList = cityList;
/* 592:    */   }
/* 593:    */   
/* 594:    */   public Map<String, Object> getSession()
/* 595:    */   {
/* 596:614 */     return this.session;
/* 597:    */   }
/* 598:    */ }


/* Location:           C:\Users\bharti\Desktop\Chouksay\lost\action\
 * Qualified Name:     com.bst.ckt.action.ConsumerCustomerAction
 * JD-Core Version:    0.7.0.1
 */