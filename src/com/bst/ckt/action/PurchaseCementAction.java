/*   1:    */ package com.bst.ckt.action;
/*   2:    */ 
/*   3:    */ import com.bst.ckt.common.LoginUtil;
/*   4:    */ import com.bst.ckt.dao.PurchaseCementDaoImpl;
/*   5:    */ import com.bst.ckt.dao.PurchaseCementDaoInf;
/*   6:    */ import com.bst.ckt.exception.CreateFailedException;
/*   7:    */ import com.bst.ckt.exception.DeleteFailedException;
/*   8:    */ import com.bst.ckt.exception.RecordNotFoundException;
/*   9:    */ import com.bst.ckt.exception.UpdateFailedException;
/*  10:    */ import com.bst.ckt.helper.ListHelper;
/*  11:    */ import com.bst.ckt.helper.PurchaseCementAdvanceSearch;
/*  12:    */ import com.bst.ckt.helper.VOMapperHelper;
/*  13:    */ import com.bst.ckt.service.PurchaseCementServiceImpl;
/*  14:    */ import com.bst.ckt.service.PurchaseCementServiceInf;
/*  15:    */ import com.bst.ckt.vo.PurchaseCementVO;
/*  16:    */ import com.opensymphony.xwork2.ActionContext;
/*  17:    */ import com.opensymphony.xwork2.ActionSupport;
/*  18:    */ import com.opensymphony.xwork2.ModelDriven;

import java.io.File;
import java.io.FileOutputStream;
/*  19:    */ import java.io.IOException;
/*  20:    */ import java.io.PrintStream;
/*  21:    */ import java.io.PrintWriter;
/*  22:    */ import java.util.List;
/*  23:    */ import java.util.Map;

import javax.servlet.ServletOutputStream;
/*  24:    */ import javax.servlet.http.HttpServletRequest;
/*  25:    */ import javax.servlet.http.HttpServletResponse;
/*  26:    */ import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
/*  27:    */ import org.apache.struts2.interceptor.ServletRequestAware;
/*  28:    */ import org.apache.struts2.interceptor.ServletResponseAware;
/*  29:    */ import org.apache.struts2.interceptor.SessionAware;
/*  30:    */ import org.json.simple.JSONObject;
/*  31:    */ 
/*  32:    */ public class PurchaseCementAction
/*  33:    */   extends ActionSupport
/*  34:    */   implements ServletRequestAware, ModelDriven<PurchaseCementVO>, ServletResponseAware, SessionAware
/*  35:    */ {
/*  36:    */   private static final long serialVersionUID = 1L;
/*  37: 52 */   private static final Logger logger = Logger.getLogger(PurchaseCementAction.class);
/*  38: 55 */   HttpServletRequest request = (HttpServletRequest)ActionContext.getContext().get("com.opensymphony.xwork2.dispatcher.HttpServletRequest");
/*  39: 58 */   PurchaseCementVO purchaseCementVO = new PurchaseCementVO();
/*  40: 59 */   PurchaseCementServiceInf purchaseCementServiceInf = null;
/*  41: 60 */   PurchaseCementDaoInf purchaseCementDaoInf = new PurchaseCementDaoImpl();
/*  42: 63 */   HttpServletResponse response = null;
/*  43: 64 */   ListHelper listHelper = null;
/*  44: 65 */   Map<String, Object> session = null;
/*  45:    */   private Map<Integer, String> dealerList;
/*  46: 69 */   List<PurchaseCementVO> cementPurchaseList = null;
/*  47:    */   private Map<Integer, String> purchaseCementSearchList;
/*  48:    */   private Map<Integer, String> payModeList;
/*  49:    */   private Map<Integer, String> transportList;
/*  50:    */   private Map<Integer, String> typeList;
/*  51:    */   
/*  52:    */   public PurchaseCementAction()
/*  53:    */     throws Exception
/*  54:    */   {
/*  55: 77 */     this.listHelper = new ListHelper();
/*  56: 78 */     this.dealerList = this.listHelper.dealerList();
/*  57: 79 */     this.payModeList = this.listHelper.getPaymentModeList();
/*  58: 80 */     this.typeList = this.listHelper.getCementTypeList();
/*  59: 81 */     this.transportList = this.listHelper.getTransportList();
/*  60: 82 */     setPurchaseCementSearchList(PurchaseCementAdvanceSearch.getPurchaseCementSearchList());
/*  61:    */   }
/*  62:    */   
/*  63:    */   public String execute()
/*  64:    */     throws Exception
/*  65:    */   {
/*  66: 89 */     this.purchaseCementServiceInf = new PurchaseCementServiceImpl();
/*  67: 90 */     this.cementPurchaseList = this.purchaseCementServiceInf.fetchPurchaseCementList();
/*  68: 91 */     return "success";
/*  69:    */   }
/*  70:    */   
/*  71:    */   public String addPurchaseCement()
/*  72:    */     throws CreateFailedException
/*  73:    */   {
/*  74: 97 */     this.purchaseCementServiceInf = new PurchaseCementServiceImpl();
/*  75:    */     
/*  76: 99 */     this.purchaseCementServiceInf.insertPurchaseCementDetails(this.purchaseCementVO);
/*  77:100 */     this.purchaseCementServiceInf.insertIntoLedger(this.purchaseCementVO);
/*  78:101 */     return "success";
/*  79:    */   }
/*  80:    */   
/*  81:    */   public void getDealerDetails()
/*  82:    */     throws IOException
/*  83:    */   {
/*  84:    */     try
/*  85:    */     {
/*  86:107 */       System.out.println("hello bharti ur in jsoncode_(((((((((");
/*  87:108 */       JSONObject dealerDetails = new JSONObject();
/*  88:    */       
/*  89:110 */       int dealerId = Integer.parseInt(this.request.getParameter("dealerId"));
/*  90:    */       
/*  91:    */ 
/*  92:113 */       System.out.println("hello bharti ur in jsoncode_(((((((((" + dealerId);
/*  93:114 */       this.listHelper = new ListHelper();
/*  94:115 */       dealerDetails = this.listHelper.getDealerDetail(dealerId);
/*  95:    */       
/*  96:117 */       PrintWriter out = this.response.getWriter();
/*  97:    */       
/*  98:119 */       out.print(dealerDetails);
/*  99:    */     }
/* 100:    */     catch (Exception exception)
/* 101:    */     {
/* 102:122 */       System.out.println(exception);
/* 103:    */     }
/* 104:    */   }
/* 105:    */   
/* 106:    */   public String viewCementPurchsaseDetailsGrid()
/* 107:    */     throws RecordNotFoundException
/* 108:    */   {
/* 109:130 */     this.purchaseCementServiceInf = new PurchaseCementServiceImpl();
/* 110:    */     
/* 111:    */ 
/* 112:133 */     this.cementPurchaseList = this.purchaseCementServiceInf
/* 113:134 */       .retrivePurchaseCementDetailsGrid(this.purchaseCementVO);
/* 114:136 */     if (this.cementPurchaseList == null)
/* 115:    */     {
/* 116:137 */       logger.error(" Error: While getting Cement Purchase details for search");
/* 117:138 */       addActionError("No Records found");
/* 118:139 */       return "error";
/* 119:    */     }
/* 120:141 */     logger.info("Records found Successfully");
/* 121:142 */     return "success";
/* 122:    */   }
/* 123:    */   
/* 124:    */   public String viewSpecificSDetail()
/* 125:    */     throws RecordNotFoundException
/* 126:    */   {
/* 127:148 */     this.purchaseCementServiceInf = new PurchaseCementServiceImpl();
/* 128:    */     
/* 129:150 */     String id = this.request.getParameter("command");
/* 130:    */     
/* 131:152 */     int purchaseId = Integer.parseInt(id);
/* 132:153 */     LoginUtil.setProcessUserId(purchaseId);
/* 133:154 */     System.out.println(purchaseId);
/* 134:    */     
/* 135:156 */     this.purchaseCementVO = VOMapperHelper.getPurchaseCementFromPurchaseCementDetails(this.purchaseCementVO, this.purchaseCementServiceInf.retriveSpecificPurchaseCementDetail(purchaseId));
/* 136:    */     
/* 137:158 */     return "success";
/* 138:    */   }
/* 139:    */   
/* 140:    */   public String deleteSpecificCementPurchaseDetails()
/* 141:    */     throws DeleteFailedException
/* 142:    */   {
/* 143:170 */     String delId = this.request.getParameter("command");
/* 144:171 */     int purchaseId = Integer.parseInt(delId);
/* 145:172 */     this.purchaseCementServiceInf = new PurchaseCementServiceImpl();
/* 146:173 */     String message = this.purchaseCementServiceInf.deleteSpecificCementPurchaseDetails(purchaseId);
/* 147:174 */     if (message.equals("SUCCESS"))
/* 148:    */     {
/* 149:175 */       logger.info("Records found Successfully");
/* 150:176 */       addActionMessage("Cement Purchase Details inserted successfully!!");
/* 151:177 */       return "success";
/* 152:    */     }
/* 153:179 */     logger.error(" Error: While getting Cement Purchase details");
/* 154:180 */     addActionError("No Records found");
/* 155:181 */     return "error";
/* 156:    */   }
/* 157:    */   
/* 158:    */   public String retrivePurchaseCementDetailsForEdit()
/* 159:    */     throws RecordNotFoundException
/* 160:    */   {
/* 161:188 */     this.purchaseCementServiceInf = new PurchaseCementServiceImpl();
/* 162:189 */     String id = this.request.getParameter("command");
/* 163:    */     
/* 164:191 */     System.out.println("IIIDDDDDDDDISSSSID" + id);
/* 165:192 */     int purchaseId = Integer.parseInt(id);
/* 166:    */     
/* 167:194 */     LoginUtil.setProcessUserId(purchaseId);
/* 168:    */     
/* 169:    */ 
/* 170:197 */     System.out.println(purchaseId);
/* 171:    */     
/* 172:199 */     this.purchaseCementVO = VOMapperHelper.getPurchaseCementFromPurchaseCementDetails(this.purchaseCementVO, this.purchaseCementServiceInf.retriveSpecificPurchaseDetailForUpdate(purchaseId));
/* 173:    */     
/* 174:201 */     System.out.println("bharti u r absolutely correct!!!!!!!!!" + this.purchaseCementVO.getTransactionId());
/* 175:    */     
/* 176:203 */     return "success";
/* 177:    */   }
/* 178:    */   
/* 179:    */   public String updateSpecificPurchaseRecord()
/* 180:    */     throws UpdateFailedException
/* 181:    */   {
/* 182:212 */     this.purchaseCementServiceInf = new PurchaseCementServiceImpl();
/* 183:    */     
/* 184:    */ 
/* 185:215 */     int purchaseId = LoginUtil.getProcessUserId();
/* 186:    */     
/* 187:    */ 
/* 188:218 */     System.out.println(this.purchaseCementVO.getTransactionId() + "hhhuuuuuurrrrrrrrrrrraaaaaaayyyyyyyyyy" + this.purchaseCementVO.getTransactionId() + purchaseId);
/* 189:219 */     System.out.println(purchaseId);
/* 190:    */     
/* 191:    */ 
/* 192:222 */     this.purchaseCementServiceInf.updateSpecificPurchaseRecord(this.purchaseCementVO, purchaseId, this.purchaseCementVO.getTransactionId());
/* 193:223 */     return "success";
/* 194:    */   }
/* 195:    */   
/* 196:    */   public String purchasePrintPDF()
/* 197:    */     throws Exception
/* 198:    */   {
/* 199:229 */     int purchaseId = LoginUtil.getProcessUserId();
/* 200:230 */     LoginUtil.setProcessUserId(purchaseId);
/* 201:231 */     this.purchaseCementServiceInf = new PurchaseCementServiceImpl();
/* 202:232 */     this.purchaseCementServiceInf.purchasePDF(this.request, this.response, purchaseId);
/* 203:233 */     return null;
/* 204:    */   }
/* 205:    */   
/* 206:    */   public String purchaseCementExcelReport()
/* 207:    */     throws Exception
/* 208:    */   {
	try {
/* 209:237 */     this.purchaseCementServiceInf = new PurchaseCementServiceImpl();
/* 210:238 */     this.purchaseCementServiceInf.purchaseCementExcelReport(this.request, this.response);
logger.info(PurchaseCementServiceImpl.class+"we r in purchase service................1111");
	}catch(Exception ex){
		logger.error(PurchaseCementAction.class+"ERROR while creating Excel.......", ex);
	}
/* 211:239 */     return null;
/* 212:    */   }
/* 213:    */   
/* 214:    */   public String viewNextPurchaseCementDetail()
/* 215:    */     throws Exception
/* 216:    */   {
/* 217:245 */     this.purchaseCementServiceInf = new PurchaseCementServiceImpl();
/* 218:246 */     int purchaseId = LoginUtil.getProcessUserId();
/* 219:247 */     this.purchaseCementVO = VOMapperHelper.getPurchaseCementFromPurchaseCementDetails(this.purchaseCementVO, 
/* 220:248 */       this.purchaseCementServiceInf.viewNextPurchaseCementDetails(purchaseId));
/* 221:251 */     if (this.purchaseCementVO.getPurchaseId() != 0)
/* 222:    */     {
/* 223:252 */       logger.info("Purchase cement details found successfully for purchase Id  " + 
/* 224:253 */         this.purchaseCementVO.getPurchaseId());
/* 225:254 */       addActionMessage("Purchase cement details found successfully for purchase Id " + 
/* 226:255 */         this.purchaseCementVO.getPurchaseId());
/* 227:256 */       return "success";
/* 228:    */     }
/* 229:258 */     this.purchaseCementVO.setPurchaseId(LoginUtil.getProcessUserId());
/* 230:259 */     logger.error("Purchase cement details not found for purchase Id  " + 
/* 231:260 */       this.purchaseCementVO.getPurchaseId());
/* 232:261 */     addActionError("Purchase cement details not found for purchase Id " + 
/* 233:262 */       this.purchaseCementVO.getPurchaseId());
/* 234:263 */     return "error";
/* 235:    */   }
/* 236:    */   
/* 237:    */   public String viewPreviousPurchaseCement()
/* 238:    */     throws Exception
/* 239:    */   {
/* 240:270 */     this.purchaseCementServiceInf = new PurchaseCementServiceImpl();
/* 241:271 */     int purchaseId = LoginUtil.getProcessUserId();
/* 242:272 */     this.purchaseCementVO = VOMapperHelper.getPurchaseCementFromPurchaseCementDetails(this.purchaseCementVO, 
/* 243:273 */       this.purchaseCementServiceInf.viewPreviousPurchaseCement(purchaseId));
/* 244:276 */     if (this.purchaseCementVO.getPurchaseId() != 0)
/* 245:    */     {
/* 246:277 */       logger.info("Purchase cement details found successfully for Purchase Id  " + 
/* 247:278 */         this.purchaseCementVO.getPurchaseId());
/* 248:279 */       addActionMessage("Purchase cement details found successfully for Purchase Id " + 
/* 249:280 */         this.purchaseCementVO.getPurchaseId());
/* 250:281 */       return "success";
/* 251:    */     }
/* 252:282 */     if (LoginUtil.getProcessUserId() == -1)
/* 253:    */     {
/* 254:283 */       LoginUtil.setProcessUserId(this.purchaseCementDaoInf.getPurchaseCementLastRecord() + 1);
/* 255:284 */       logger.error("Purchase cement details not found");
/* 256:285 */       addActionError("Purchase cement details not found");
/* 257:286 */       return "error";
/* 258:    */     }
/* 259:288 */     this.purchaseCementVO.setPurchaseId(LoginUtil.getProcessUserId());
/* 260:289 */     logger.error("Purchase cement details not found for Purchase Id  " + 
/* 261:290 */       this.purchaseCementVO.getPurchaseId());
/* 262:291 */     addActionError("Purchase cement details not found for Purchase Id " + 
/* 263:292 */       this.purchaseCementVO.getPurchaseId());
/* 264:293 */     return "error";
/* 265:    */   }
/* 266:    */   
/* 267:    */   public String viewCementStockGrid()
/* 268:    */     throws RecordNotFoundException
/* 269:    */   {
/* 270:301 */     this.purchaseCementServiceInf = new PurchaseCementServiceImpl();
/* 271:302 */     this.cementPurchaseList = this.purchaseCementServiceInf.viewCementStockGrid();
/* 272:303 */     return "success";
/* 273:    */   }

public String createWorkbook() throws Exception {
try{
    HSSFWorkbook wb = new HSSFWorkbook();
    HSSFSheet sheet = wb.createSheet("User Data");
    String path=request.getSession().getServletContext().getRealPath("/").concat("excels")+File.separator+"UserDetails.xls";
    /**
     * Setting the width of the first three columns.
     */
    sheet.setColumnWidth(0, 3500);
    sheet.setColumnWidth(1, 7500);
    sheet.setColumnWidth(2, 5000);

    /**
     * Style for the header cells.
     */
    HSSFCellStyle headerCellStyle = wb.createCellStyle();
    HSSFFont boldFont = wb.createFont();
    boldFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
    headerCellStyle.setFont(boldFont);

    HSSFRow row = sheet.createRow(0);
    HSSFCell cell = row.createCell(0);
    cell.setCellStyle(headerCellStyle);
    cell.setCellValue(new HSSFRichTextString("User Name"));
    cell = row.createCell(1);
    cell.setCellStyle(headerCellStyle);
    cell.setCellValue(new HSSFRichTextString("Email Id"));
    cell = row.createCell(2);
    cell.setCellStyle(headerCellStyle);
    cell.setCellValue(new HSSFRichTextString("Location"));

    /*for (int index = 1; index < userList.size(); index++) {*/
        row = sheet.createRow(1);
        cell = row.createCell(0);
        
        HSSFRichTextString userName = new HSSFRichTextString("bharti");
        cell.setCellValue(userName);
        cell = row.createCell(1);
        HSSFRichTextString emailId = new HSSFRichTextString("kjkvkf@kjf");
        cell.setCellValue(emailId);
        cell = row.createCell(2);
        HSSFRichTextString location = new HSSFRichTextString("kfghfk");
        cell.setCellValue(location);
    /*}*/
    
    /*HSSFWorkbook workbook = excelCreator.createWorkbook(userForm.getUserList());*/
        response.setContentType("application/vnd.ms-excel");
        
        /*response.setContentLength(outArray.length);*/
        /* 3297:3362 */      
        
    response.setHeader("Content-Disposition", "attachment; filename=UserDetails.xls");
    //FileOutputStream outputStream = new FileOutputStream(path);
    ServletOutputStream out = response.getOutputStream();
    wb.write(out);
    out.flush();
    out.close();
}catch(Exception e){
	e.printStackTrace();
}
    return null;
}

/* 274:    */   
/* 275:    */   public void setSession(Map<String, Object> session)
/* 276:    */   {
/* 277:310 */     this.session = session;
/* 278:    */   }
/* 279:    */   
/* 280:    */   public void setServletResponse(HttpServletResponse response)
/* 281:    */   {
/* 282:319 */     this.response = response;
/* 283:    */   }
/* 284:    */   
/* 285:    */   public PurchaseCementVO getModel()
/* 286:    */   {
/* 287:325 */     return this.purchaseCementVO;
/* 288:    */   }
/* 289:    */   
/* 290:    */   public void setServletRequest(HttpServletRequest request)
/* 291:    */   {
/* 292:331 */     this.request = request;
/* 293:    */   }
/* 294:    */   
/* 295:    */   public HttpServletRequest getRequest()
/* 296:    */   {
/* 297:335 */     return this.request;
/* 298:    */   }
/* 299:    */   
/* 300:    */   public void setRequest(HttpServletRequest request)
/* 301:    */   {
/* 302:339 */     this.request = request;
/* 303:    */   }
/* 304:    */   
/* 305:    */   public HttpServletResponse getResponse()
/* 306:    */   {
/* 307:343 */     return this.response;
/* 308:    */   }
/* 309:    */   
/* 310:    */   public void setResponse(HttpServletResponse response)
/* 311:    */   {
/* 312:347 */     this.response = response;
/* 313:    */   }
/* 314:    */   
/* 315:    */   public Map<Integer, String> getDealerList()
/* 316:    */   {
/* 317:352 */     return this.dealerList;
/* 318:    */   }
/* 319:    */   
/* 320:    */   public void setDealerList(Map<Integer, String> dealerList)
/* 321:    */   {
/* 322:357 */     this.dealerList = dealerList;
/* 323:    */   }
/* 324:    */   
/* 325:    */   public PurchaseCementVO getPurchaseCementVO()
/* 326:    */   {
/* 327:362 */     return this.purchaseCementVO;
/* 328:    */   }
/* 329:    */   
/* 330:    */   public void setPurchaseCementVO(PurchaseCementVO purchaseCementVO)
/* 331:    */   {
/* 332:367 */     this.purchaseCementVO = purchaseCementVO;
/* 333:    */   }
/* 334:    */   
/* 335:    */   public List<PurchaseCementVO> getCementPurchaseList()
/* 336:    */   {
/* 337:372 */     return this.cementPurchaseList;
/* 338:    */   }
/* 339:    */   
/* 340:    */   public void setCementPurchaseList(List<PurchaseCementVO> cementPurchaseList)
/* 341:    */   {
/* 342:377 */     this.cementPurchaseList = cementPurchaseList;
/* 343:    */   }
/* 344:    */   
/* 345:    */   public Map<Integer, String> getPurchaseCementSearchList()
/* 346:    */   {
/* 347:382 */     return this.purchaseCementSearchList;
/* 348:    */   }
/* 349:    */   
/* 350:    */   public void setPurchaseCementSearchList(Map<Integer, String> purchaseCementSearchList)
/* 351:    */   {
/* 352:388 */     this.purchaseCementSearchList = purchaseCementSearchList;
/* 353:    */   }
/* 354:    */   
/* 355:    */   public Map<Integer, String> getPayModeList()
/* 356:    */   {
/* 357:393 */     return this.payModeList;
/* 358:    */   }
/* 359:    */   
/* 360:    */   public void setPayModeList(Map<Integer, String> payModeList)
/* 361:    */   {
/* 362:398 */     this.payModeList = payModeList;
/* 363:    */   }
/* 364:    */   
/* 365:    */   public Map<Integer, String> getTypeList()
/* 366:    */   {
/* 367:403 */     return this.typeList;
/* 368:    */   }
/* 369:    */   
/* 370:    */   public void setTypeList(Map<Integer, String> typeList)
/* 371:    */   {
/* 372:408 */     this.typeList = typeList;
/* 373:    */   }
/* 374:    */   
/* 375:    */   public Map<Integer, String> getTransportList()
/* 376:    */   {
/* 377:413 */     return this.transportList;
/* 378:    */   }
/* 379:    */   
/* 380:    */   public void setTransportList(Map<Integer, String> transportList)
/* 381:    */   {
/* 382:418 */     this.transportList = transportList;
/* 383:    */   }
/* 384:    */   
/* 385:    */   public Map<String, Object> getSession()
/* 386:    */   {
/* 387:425 */     return this.session;
/* 388:    */   }
/* 389:    */ }


/* Location:           C:\Users\bharti\Desktop\Chouksay\lost\action\
 * Qualified Name:     com.bst.ckt.action.PurchaseCementAction
 * JD-Core Version:    0.7.0.1
 */