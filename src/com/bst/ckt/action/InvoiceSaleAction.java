/*   1:    */ package com.bst.ckt.action;
/*   2:    */ 
/*   3:    */ import com.bst.ckt.common.LoginUtil;
/*   4:    */ import com.bst.ckt.dao.InvoiceSaleDaoImpl;
/*   5:    */ import com.bst.ckt.dao.InvoiceSaleDaoInf;
/*   6:    */ import com.bst.ckt.exception.CreateFailedException;
/*   7:    */ import com.bst.ckt.exception.DeleteFailedException;
/*   8:    */ import com.bst.ckt.exception.RecordNotFoundException;
/*   9:    */ import com.bst.ckt.exception.UpdateFailedException;
/*  10:    */ import com.bst.ckt.helper.InvoiceSaleAdvanceSearch;
/*  11:    */ import com.bst.ckt.helper.ListHelper;
/*  12:    */ import com.bst.ckt.helper.VOMapperHelper;
/*  13:    */ import com.bst.ckt.service.InvoiceSaleServiceImpl;
/*  14:    */ import com.bst.ckt.service.InvoiceSaleServiceInf;
/*  15:    */ import com.bst.ckt.vo.InvoiceSaleVO;
/*  16:    */ import com.opensymphony.xwork2.ActionContext;
/*  17:    */ import com.opensymphony.xwork2.ActionSupport;
/*  18:    */ import com.opensymphony.xwork2.ModelDriven;
/*  19:    */ import java.io.IOException;
/*  20:    */ import java.io.PrintStream;
/*  21:    */ import java.io.PrintWriter;
/*  22:    */ import java.util.ArrayList;
/*  23:    */ import java.util.List;
/*  24:    */ import java.util.Map;
/*  25:    */ import javax.servlet.http.HttpServletRequest;
/*  26:    */ import javax.servlet.http.HttpServletResponse;
/*  27:    */ import org.apache.log4j.Logger;
/*  28:    */ import org.apache.struts2.interceptor.ServletRequestAware;
/*  29:    */ import org.apache.struts2.interceptor.ServletResponseAware;
/*  30:    */ import org.json.simple.JSONObject;
/*  31:    */ 
/*  32:    */ public class InvoiceSaleAction
/*  33:    */   extends ActionSupport
/*  34:    */   implements ModelDriven<InvoiceSaleVO>, ServletRequestAware, ServletResponseAware
/*  35:    */ {
/*  36:    */   private static final long serialVersionUID = 1L;
/*  37: 51 */   InvoiceSaleVO addNewInvoiceVO = null;
/*  38: 52 */   Logger logger = Logger.getLogger(InvoiceSaleAction.class);
/*  39: 54 */   HttpServletRequest request = (HttpServletRequest)ActionContext.getContext().get("com.opensymphony.xwork2.dispatcher.HttpServletRequest");
/*  40:    */   private Map<Integer, String> regCustomersList;
/*  41:    */   private Map<Integer, String> consumerCustomersList;
/*  42:    */   private Map<Integer, String> salesSearchList;
/*  43:    */   private Map<Integer, String> productList;
/*  44: 65 */   InvoiceSaleVO invoiceSaleVO = null;
/*  45: 66 */   InvoiceSaleServiceInf invoiceSaleServiceInf = null;
/*  46: 67 */   InvoiceSaleDaoInf invoiceSaleDaoInf = new InvoiceSaleDaoImpl();
/*  47: 70 */   ListHelper listHelper = null;
/*  48: 71 */   private Map<Integer, Float> taxList = null;
/*  49: 72 */   private Map<Integer, String> payModeList = null;
/*  50: 74 */   Map<String, Object> session = null;
/*  51: 76 */   HttpServletResponse response = null;
/*  52: 77 */   List<InvoiceSaleVO> invoiceSaleList = null;
/*  53: 78 */   List<InvoiceSaleVO> invoiceSaleItemsList = null;
/*  54:    */   
/*  55:    */   public InvoiceSaleAction()
/*  56:    */     throws Exception
/*  57:    */   {
/*  58: 82 */     this.invoiceSaleVO = new InvoiceSaleVO();
/*  59: 83 */     this.addNewInvoiceVO = new InvoiceSaleVO();
/*  60: 84 */     this.listHelper = new ListHelper();
/*  61: 85 */     this.taxList = this.listHelper.taxList();
/*  62: 86 */     this.regCustomersList = this.listHelper.regularCustomerList();
/*  63: 87 */     this.productList = this.listHelper.productList();
/*  64: 88 */     this.consumerCustomersList = this.listHelper.consumerCustomerList();
/*  65: 89 */     this.invoiceSaleItemsList = new ArrayList();
/*  66: 90 */     this.payModeList = this.listHelper.getPaymentModeList();
/*  67: 91 */     setSalesSearchList(InvoiceSaleAdvanceSearch.getInvoiceSalesAdvanceSearchList());
/*  68:    */   }
/*  69:    */   
/*  70:    */   public String execute()
/*  71:    */     throws Exception
/*  72:    */   {
/*  73: 98 */     this.invoiceSaleServiceInf = new InvoiceSaleServiceImpl();
/*  74: 99 */     this.invoiceSaleList = this.invoiceSaleServiceInf
/*  75:100 */       .retriveSalesDetailsGrid(this.invoiceSaleVO);
/*  76:    */     
/*  77:102 */     return "success";
/*  78:    */   }
/*  79:    */   
/*  80:    */   public void getProdDscAndPrice()
/*  81:    */     throws IOException
/*  82:    */   {
/*  83:    */     try
/*  84:    */     {
/*  85:108 */       JSONObject descAndPrice = new JSONObject();
/*  86:    */       
/*  87:110 */       int productId = Integer.parseInt(this.request.getParameter("productId"));
/*  88:    */       
/*  89:112 */       this.listHelper = new ListHelper();
/*  90:113 */       descAndPrice = this.listHelper.prodDescPrice(productId);
/*  91:    */       
/*  92:115 */       PrintWriter out = this.response.getWriter();
/*  93:    */       
/*  94:117 */       out.print(descAndPrice);
/*  95:    */     }
/*  96:    */     catch (Exception exception)
/*  97:    */     {
/*  98:120 */       System.out.println(exception);
/*  99:    */     }
/* 100:    */   }
/* 101:    */   
/* 102:    */   public void getRegularCustomerDetails()
/* 103:    */     throws IOException
/* 104:    */   {
/* 105:    */     try
/* 106:    */     {
/* 107:127 */       System.out.println("hello bharti ur in jsoncode_(((((((((");
/* 108:128 */       JSONObject custDetails = new JSONObject();
/* 109:    */       
/* 110:130 */       int customerId = Integer.parseInt(this.request.getParameter("custId"));
/* 111:    */       
/* 112:132 */       this.listHelper = new ListHelper();
/* 113:133 */       custDetails = this.listHelper.getRegularCustomerDetail(customerId);
/* 114:    */       
/* 115:135 */       PrintWriter out = this.response.getWriter();
/* 116:    */       
/* 117:137 */       out.print(custDetails);
/* 118:    */     }
/* 119:    */     catch (Exception exception)
/* 120:    */     {
/* 121:140 */       System.out.println(exception);
/* 122:    */     }
/* 123:    */   }
/* 124:    */   
/* 125:    */   public void getConsumerCustomerDetails()
/* 126:    */     throws IOException
/* 127:    */   {
/* 128:    */     try
/* 129:    */     {
/* 130:148 */       System.out.println("hello bharti ur in jsoncode_(((((((((rrrr");
/* 131:149 */       JSONObject consmerDetails = new JSONObject();
/* 132:    */       
/* 133:151 */       int customerId = Integer.parseInt(this.request.getParameter("custId2"));
/* 134:    */       
/* 135:153 */       this.listHelper = new ListHelper();
/* 136:154 */       consmerDetails = this.listHelper.getConsumerCustomerDetail(customerId);
/* 137:    */       
/* 138:156 */       PrintWriter out = this.response.getWriter();
/* 139:    */       
/* 140:158 */       out.print(consmerDetails);
/* 141:    */     }
/* 142:    */     catch (Exception exception)
/* 143:    */     {
/* 144:161 */       System.out.println(exception);
/* 145:    */     }
/* 146:    */   }
/* 147:    */   
/* 148:    */   public void getProductJASONList()
/* 149:    */     throws IOException
/* 150:    */   {
/* 151:    */     try
/* 152:    */     {
/* 153:168 */       InvoiceSaleDaoInf invoiceSaleDaoInf = new InvoiceSaleDaoImpl();
/* 154:169 */       JSONObject productList = new JSONObject();
/* 155:170 */       JSONObject taxList = new JSONObject();
/* 156:    */       
/* 157:172 */       productList = invoiceSaleDaoInf.productListJSON();
/* 158:173 */       taxList = invoiceSaleDaoInf.taxListJSON();
/* 159:    */       
/* 160:175 */       productList.put("taxList", taxList);
/* 161:    */       
/* 162:177 */       PrintWriter out = this.response.getWriter();
/* 163:178 */       System.out.println("%%%%%%%%%%" + productList);
/* 164:179 */       out.print(productList);
/* 165:    */     }
/* 166:    */     catch (Exception exception)
/* 167:    */     {
/* 168:183 */       System.out.println(exception);
/* 169:    */     }
/* 170:    */   }
/* 171:    */   
/* 172:    */   public String addSalesDetails()
/* 173:    */     throws CreateFailedException, RecordNotFoundException
/* 174:    */   {
	
/* 175:191 */     System.out.println("$$$$$$$$$$$$$action");
/* 176:192 */     this.invoiceSaleServiceInf = new InvoiceSaleServiceImpl();
/* 177:    */     
/* 178:    */ 
/* 179:    */ 
/* 180:196 */     int result = this.invoiceSaleServiceInf.addSalesDetails(this.invoiceSaleVO);
String message;
if(result!=0) {
	message="SUCCESS";
}else {
	System.out.println(result+"addSalesDetails");
	message="FAILURE";
}
/* 181:198 */     if ("SUCCESS".equalsIgnoreCase(message))
/* 182:    */     {
/* 183:199 */       this.logger.info("Sales Details Inserted Successfully!!");
/* 184:200 */       addActionMessage("Sales Details Successfully Inserted!");
/* 185:201 */       int lastRecord = this.invoiceSaleDaoInf.getSalesLastRecord();
/* 186:202 */       System.out.println(lastRecord + "hdddddddddddddddddddddddddddddddddddddddddddd"+result);
/* 187:203 */       this.invoiceSaleServiceInf.generateBillForSales(this.request, this.response, lastRecord, result);
/* 188:204 */       return "success";
/* 189:    */     }

/* 190:207 */     if ("FAILURE".equalsIgnoreCase(message))
/* 191:    */     {
/* 192:209 */       this.logger.info("Error:while  Inserting Sales Details!");
/* 193:210 */       addActionError("Error:while  Inserting Sales Details!");
/* 194:211 */       return "input";
/* 195:    */     }
/* 196:214 */     return "success";
/* 197:    */   }
/* 198:    */   
/* 199:    */   public String generateSpecificBillOfSale()
/* 200:    */   {
/* 201:    */     try
/* 202:    */     {
/* 203:221 */       int salesId = LoginUtil.getProcessUserId();
/* 204:222 */       LoginUtil.setProcessUserId(salesId);
/* 205:223 */       System.out.println(salesId + "yyyyyyyyyyyyyaaaaaahhhhhhhoooooooooo");
/* 206:224 */       this.invoiceSaleServiceInf = new InvoiceSaleServiceImpl();
int nameId=invoiceSaleDaoInf.getNameForBillOnTheBasisOfId(salesId);
/* 205:223 */       System.out.println(salesId + "yyyyyyyyyyyyyaaaaannnnahhhhhhhoooooooooo"+nameId);
/* 207:225 */       this.invoiceSaleServiceInf.generateBillForSales(this.request, this.response, salesId,nameId);
/* 208:    */     }
/* 209:    */     catch (Exception e)
/* 210:    */     {
/* 211:227 */       e.printStackTrace();
/* 212:    */     }
/* 213:229 */     return null;
/* 214:    */   }
/* 215:    */   
/* 216:    */   public String viewSalesDetailsGrid()
/* 217:    */     throws RecordNotFoundException
/* 218:    */   {
/* 219:236 */     this.invoiceSaleServiceInf = new InvoiceSaleServiceImpl();
/* 220:    */     
/* 221:    */ 
/* 222:239 */     this.invoiceSaleList = this.invoiceSaleServiceInf
/* 223:240 */       .retriveSalesDetailsForAdvanceSearch(this.invoiceSaleVO);
/* 224:242 */     if (this.invoiceSaleList == null)
/* 225:    */     {
/* 226:243 */       this.logger.error(" Error: While getting sales details");
/* 227:244 */       addActionError("No Records found");
/* 228:245 */       return "error";
/* 229:    */     }
/* 230:247 */     this.logger.info("Records found Successfully");
/* 231:248 */     return "success";
/* 232:    */   }
/* 233:    */   
/* 234:    */   public String viewSpecificSalesDetail()
/* 235:    */     throws RecordNotFoundException
/* 236:    */   {
/* 237:259 */     this.invoiceSaleServiceInf = new InvoiceSaleServiceImpl();
/* 238:260 */     String id = this.request.getParameter("command");
/* 239:    */     
/* 240:262 */     int salesId = Integer.parseInt(id);
/* 241:263 */     LoginUtil.setProcessUserId(salesId);
/* 242:264 */     System.out.println(salesId);
/* 243:    */     
/* 244:266 */     this.invoiceSaleVO = VOMapperHelper.getSalesFromSalesDetails(this.invoiceSaleVO, this.invoiceSaleServiceInf.retriveSpecificSalesDetail(salesId));
/* 245:267 */     this.invoiceSaleItemsList = this.invoiceSaleServiceInf.getSpecificItemsBySalesId(salesId);
/* 246:268 */     return "success";
/* 247:    */   }
/* 248:    */   
/* 249:    */   public String viewSpecificRecordForEdit()
/* 250:    */     throws RecordNotFoundException
/* 251:    */   {
/* 252:275 */     this.invoiceSaleServiceInf = new InvoiceSaleServiceImpl();
/* 253:276 */     String id = this.request.getParameter("command");
/* 254:    */     
/* 255:278 */     int salesId = Integer.parseInt(id);
/* 256:279 */     LoginUtil.setProcessUserId(salesId);
/* 257:    */     
/* 258:281 */     System.out.println(salesId);
/* 259:282 */     this.invoiceSaleServiceInf = new InvoiceSaleServiceImpl();
/* 260:283 */     this.invoiceSaleVO = VOMapperHelper.getSalesFromSalesDetails(this.invoiceSaleVO, this.invoiceSaleServiceInf.retriveSpecificSalesDetailForUpdate(salesId));
/* 261:284 */     this.invoiceSaleItemsList = this.invoiceSaleServiceInf.getSpecificItemsForEdit(salesId);
/* 262:285 */     return "success";
/* 263:    */   }
/* 264:    */   
/* 265:    */   public String updateSpecificSalesRecord()
/* 266:    */     throws UpdateFailedException
/* 267:    */   {
/* 268:293 */     this.invoiceSaleServiceInf = new InvoiceSaleServiceImpl();
/* 269:    */     
/* 270:    */ 
/* 271:296 */     int salesId = LoginUtil.getProcessUserId();
/* 272:    */     
/* 273:298 */     System.out.println(salesId);
/* 274:299 */     this.invoiceSaleServiceInf = new InvoiceSaleServiceImpl();
/* 275:    */     
/* 276:301 */     this.invoiceSaleServiceInf.updateSpecificSalesRecord(this.invoiceSaleVO, salesId);
/* 277:302 */     return "success";
/* 278:    */   }
/* 279:    */   
/* 280:    */   public String deleteSpecificSalesDetails()
/* 281:    */     throws DeleteFailedException
/* 282:    */   {
/* 283:309 */     String delId = this.request.getParameter("command");
/* 284:310 */     int salesId = Integer.parseInt(delId);
/* 285:311 */     this.invoiceSaleServiceInf = new InvoiceSaleServiceImpl();
/* 286:312 */     String message = this.invoiceSaleServiceInf.deleteSpecificSalesDetails(salesId);
/* 287:313 */     if (message.equals("SUCCESS"))
/* 288:    */     {
/* 289:314 */       this.logger.info("Records found Successfully");
/* 290:315 */       addActionMessage("Sales Details inserted successfully!!");
/* 291:316 */       return "success";
/* 292:    */     }
/* 293:318 */     this.logger.error(" Error: While getting sales details");
/* 294:319 */     addActionError("No Records found");
/* 295:320 */     return "error";
/* 296:    */   }
/* 297:    */   
/* 298:    */   public String salesPrintPDF()
/* 299:    */     throws Exception
/* 300:    */   {
/* 301:329 */     int salesId = LoginUtil.getProcessUserId();
/* 302:330 */     LoginUtil.setProcessUserId(salesId);
/* 303:331 */     this.invoiceSaleServiceInf = new InvoiceSaleServiceImpl();
/* 304:332 */     this.invoiceSaleServiceInf.salesPDF(this.request, this.response, salesId);
/* 305:333 */     return null;
/* 306:    */   }
/* 307:    */   
/* 308:    */   public String salesExcelReport()
/* 309:    */     throws Exception
/* 310:    */   {
/* 311:339 */     this.invoiceSaleServiceInf = new InvoiceSaleServiceImpl();
/* 312:340 */     this.invoiceSaleServiceInf.salesExcelReport(this.request, this.response);
/* 313:341 */     return "none";
/* 314:    */   }
/* 315:    */   
/* 316:    */   public String viewNextSalesDetail()
/* 317:    */     throws Exception
/* 318:    */   {
/* 319:347 */     this.invoiceSaleServiceInf = new InvoiceSaleServiceImpl();
/* 320:348 */     int salesId = LoginUtil.getProcessUserId();
/* 321:349 */     this.invoiceSaleVO = VOMapperHelper.getSalesFromSalesDetails(this.invoiceSaleVO, 
/* 322:350 */       this.invoiceSaleServiceInf.viewNextSalesDetail(salesId));
/* 323:353 */     if (this.invoiceSaleVO.getSalesId() != 0)
/* 324:    */     {
/* 325:354 */       this.logger.info("Sales details found successfully for Sales Id  " + 
/* 326:355 */         this.invoiceSaleVO.getSalesId());
/* 327:356 */       addActionMessage("Sales details found successfully for Sales Id " + 
/* 328:357 */         this.invoiceSaleVO.getSalesId());
/* 329:358 */       return "success";
/* 330:    */     }
/* 331:360 */     this.invoiceSaleVO.setSalesId(LoginUtil.getProcessUserId());
/* 332:361 */     this.logger.error("Sales details not found for Sales Id  " + 
/* 333:362 */       this.invoiceSaleVO.getSalesId());
/* 334:363 */     addActionError("Sales details not found for Sales Id " + 
/* 335:364 */       this.invoiceSaleVO.getSalesId());
/* 336:365 */     return "error";
/* 337:    */   }
/* 338:    */   
/* 339:    */   public String viewPreviousSalesDetails()
/* 340:    */     throws Exception
/* 341:    */   {
/* 342:373 */     this.invoiceSaleServiceInf = new InvoiceSaleServiceImpl();
/* 343:374 */     int salesId = LoginUtil.getProcessUserId();
/* 344:375 */     this.invoiceSaleVO = VOMapperHelper.getSalesFromSalesDetails(this.invoiceSaleVO, 
/* 345:376 */       this.invoiceSaleServiceInf.viewPreviousSalesDetails(salesId));
/* 346:379 */     if (this.invoiceSaleVO.getSalesId() != 0)
/* 347:    */     {
/* 348:380 */       this.logger.info("Sales details found successfully for Sales Id  " + 
/* 349:381 */         this.invoiceSaleVO.getSalesId());
/* 350:382 */       addActionMessage("Sales details found successfully for Sales Id " + 
/* 351:383 */         this.invoiceSaleVO.getSalesId());
/* 352:384 */       return "success";
/* 353:    */     }
/* 354:385 */     if (LoginUtil.getProcessUserId() == -1)
/* 355:    */     {
/* 356:386 */       LoginUtil.setProcessUserId(this.invoiceSaleDaoInf.getSalesLastRecord() + 1);
/* 357:387 */       this.logger.error("Sales details not found");
/* 358:388 */       addActionError("Sales details not found");
/* 359:389 */       return "error";
/* 360:    */     }
/* 361:391 */     this.invoiceSaleVO.setSalesId(LoginUtil.getProcessUserId());
/* 362:392 */     this.logger.error("Sales details not found for Sales Id  " + 
/* 363:393 */       this.invoiceSaleVO.getSalesId());
/* 364:394 */     addActionError("Sales details not found for Sales Id " + 
/* 365:395 */       this.invoiceSaleVO.getSalesId());
/* 366:396 */     return "error";
/* 367:    */   }
/* 368:    */   
/* 369:    */   public InvoiceSaleVO getModel()
/* 370:    */   {
/* 371:403 */     return this.invoiceSaleVO;
/* 372:    */   }
/* 373:    */   
/* 374:    */   public void setServletRequest(HttpServletRequest request)
/* 375:    */   {
/* 376:412 */     this.request = request;
/* 377:    */   }
/* 378:    */   
/* 379:    */   public InvoiceSaleVO getInvoiceSaleVO()
/* 380:    */   {
/* 381:419 */     return this.invoiceSaleVO;
/* 382:    */   }
/* 383:    */   
/* 384:    */   public void setInvoiceSaleVO(InvoiceSaleVO invoiceSaleVO)
/* 385:    */   {
/* 386:426 */     this.invoiceSaleVO = invoiceSaleVO;
/* 387:    */   }
/* 388:    */   
/* 389:    */   public void setServletResponse(HttpServletResponse response)
/* 390:    */   {
/* 391:432 */     this.response = response;
/* 392:    */   }
/* 393:    */   
/* 394:    */   public Map<Integer, String> getProductList()
/* 395:    */   {
/* 396:437 */     return this.productList;
/* 397:    */   }
/* 398:    */   
/* 399:    */   public void setProductList(Map<Integer, String> productList)
/* 400:    */   {
/* 401:441 */     this.productList = productList;
/* 402:    */   }
/* 403:    */   
/* 404:    */   public Map<Integer, String> getRegCustomersList()
/* 405:    */   {
/* 406:445 */     return this.regCustomersList;
/* 407:    */   }
/* 408:    */   
/* 409:    */   public void setRegCustomersList(Map<Integer, String> regCustomersList)
/* 410:    */   {
/* 411:449 */     this.regCustomersList = regCustomersList;
/* 412:    */   }
/* 413:    */   
/* 414:    */   public Map<Integer, Float> getTaxList()
/* 415:    */   {
/* 416:453 */     return this.taxList;
/* 417:    */   }
/* 418:    */   
/* 419:    */   public void setTaxList(Map<Integer, Float> taxList)
/* 420:    */   {
/* 421:457 */     this.taxList = taxList;
/* 422:    */   }
/* 423:    */   
/* 424:    */   public List<InvoiceSaleVO> getInvoiceSaleList()
/* 425:    */   {
/* 426:461 */     return this.invoiceSaleList;
/* 427:    */   }
/* 428:    */   
/* 429:    */   public void setInvoiceSaleList(List<InvoiceSaleVO> invoiceSaleList)
/* 430:    */   {
/* 431:465 */     this.invoiceSaleList = invoiceSaleList;
/* 432:    */   }
/* 433:    */   
/* 434:    */   public List<InvoiceSaleVO> getInvoiceSaleItemsList()
/* 435:    */   {
/* 436:485 */     return this.invoiceSaleItemsList;
/* 437:    */   }
/* 438:    */   
/* 439:    */   public void setInvoiceSaleItemsList(List<InvoiceSaleVO> invoiceSaleItemsList)
/* 440:    */   {
/* 441:489 */     this.invoiceSaleItemsList = invoiceSaleItemsList;
/* 442:    */   }
/* 443:    */   
/* 444:    */   public Map<Integer, String> getConsumerCustomersList()
/* 445:    */   {
/* 446:494 */     return this.consumerCustomersList;
/* 447:    */   }
/* 448:    */   
/* 449:    */   public void setConsumerCustomersList(Map<Integer, String> consumerCustomersList)
/* 450:    */   {
/* 451:498 */     this.consumerCustomersList = consumerCustomersList;
/* 452:    */   }
/* 453:    */   
/* 454:    */   public InvoiceSaleVO getAddNewInvoiceVO()
/* 455:    */   {
/* 456:502 */     return this.addNewInvoiceVO;
/* 457:    */   }
/* 458:    */   
/* 459:    */   public void setAddNewInvoiceVO(InvoiceSaleVO addNewInvoiceVO)
/* 460:    */   {
/* 461:506 */     this.addNewInvoiceVO = addNewInvoiceVO;
/* 462:    */   }
/* 463:    */   
/* 464:    */   public Map<Integer, String> getPayModeList()
/* 465:    */   {
/* 466:509 */     return this.payModeList;
/* 467:    */   }
/* 468:    */   
/* 469:    */   public void setPayModeList(Map<Integer, String> payModeList)
/* 470:    */   {
/* 471:513 */     this.payModeList = payModeList;
/* 472:    */   }
/* 473:    */   
/* 474:    */   public Map<Integer, String> getSalesSearchList()
/* 475:    */   {
/* 476:517 */     return this.salesSearchList;
/* 477:    */   }
/* 478:    */   
/* 479:    */   public void setSalesSearchList(Map<Integer, String> salesSearchList)
/* 480:    */   {
/* 481:521 */     this.salesSearchList = salesSearchList;
/* 482:    */   }
/* 483:    */   
/* 484:    */   public Map<String, Object> getSession()
/* 485:    */   {
/* 486:525 */     return this.session;
/* 487:    */   }
/* 488:    */   
/* 489:    */   public void setSession(Map<String, Object> session)
/* 490:    */   {
/* 491:529 */     this.session = session;
/* 492:    */   }
/* 493:    */ }


/* Location:           C:\Users\bharti\Desktop\Chouksay\lost\action\
 * Qualified Name:     com.bst.ckt.action.InvoiceSaleAction
 * JD-Core Version:    0.7.0.1
 */