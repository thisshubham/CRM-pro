/*   1:    */ package com.bst.ckt.action;
/*   2:    */ 
/*   3:    */ import com.bst.ckt.common.LoginUtil;
/*   4:    */ import com.bst.ckt.dao.PurchaseSteelBarDaoImpl;
/*   5:    */ import com.bst.ckt.dao.PurchaseSteelBarDaoInf;
/*   6:    */ import com.bst.ckt.exception.CreateFailedException;
/*   7:    */ import com.bst.ckt.exception.DeleteFailedException;
/*   8:    */ import com.bst.ckt.exception.RecordNotFoundException;
/*   9:    */ import com.bst.ckt.exception.UpdateFailedException;
/*  10:    */ import com.bst.ckt.helper.ListHelper;
/*  11:    */ import com.bst.ckt.helper.PurchaseCementAdvanceSearch;
/*  12:    */ import com.bst.ckt.helper.VOMapperHelper;
/*  13:    */ import com.bst.ckt.service.PurchaseSteelBarServiceImpl;
/*  14:    */ import com.bst.ckt.service.PurchaseSteelBarServiceInf;
/*  15:    */ import com.bst.ckt.vo.PurchaseSteelBarVO;
/*  16:    */ import com.opensymphony.xwork2.ActionContext;
/*  17:    */ import com.opensymphony.xwork2.ActionSupport;
/*  18:    */ import com.opensymphony.xwork2.ModelDriven;
/*  19:    */ import java.io.IOException;
/*  20:    */ import java.io.PrintStream;
/*  21:    */ import java.io.PrintWriter;
/*  22:    */ import java.util.List;
/*  23:    */ import java.util.Map;
/*  24:    */ import javax.servlet.http.HttpServletRequest;
/*  25:    */ import javax.servlet.http.HttpServletResponse;
/*  26:    */ import org.apache.log4j.Logger;
/*  27:    */ import org.apache.struts2.interceptor.ServletRequestAware;
/*  28:    */ import org.apache.struts2.interceptor.ServletResponseAware;
/*  29:    */ import org.apache.struts2.interceptor.SessionAware;
/*  30:    */ import org.json.simple.JSONObject;
/*  31:    */ 
/*  32:    */ public class PurchaseSteelBarsAction
/*  33:    */   extends ActionSupport
/*  34:    */   implements ServletRequestAware, ModelDriven<PurchaseSteelBarVO>, ServletResponseAware, SessionAware
/*  35:    */ {
/*  36:    */   private static final long serialVersionUID = 1L;
/*  37: 50 */   private static final Logger logger = Logger.getLogger(PurchaseSteelBarsAction.class);
/*  38: 53 */   PurchaseSteelBarVO purchaseSteelBarVO = new PurchaseSteelBarVO();
/*  39: 54 */   PurchaseSteelBarServiceInf purchaseSteelBarServiceInf = null;
/*  40: 55 */   PurchaseSteelBarDaoInf purchaseSteelBarDaoInf = new PurchaseSteelBarDaoImpl();
/*  41: 57 */   HttpServletRequest request = (HttpServletRequest)ActionContext.getContext().get("com.opensymphony.xwork2.dispatcher.HttpServletRequest");
/*  42: 59 */   HttpServletResponse response = null;
/*  43: 60 */   ListHelper listHelper = null;
/*  44: 61 */   Map<String, Object> session = null;
/*  45:    */   private Map<Integer, String> dealerList;
/*  46:    */   private Map<Integer, String> payModeList;
/*  47:    */   private Map<Integer, String> typeList;
/*  48: 69 */   List<PurchaseSteelBarVO> steelBarPurchaseList = null;
/*  49:    */   private Map<Integer, String> purchaseSteelbarSearchList;
/*  50:    */   
/*  51:    */   public PurchaseSteelBarsAction()
/*  52:    */     throws Exception
/*  53:    */   {
/*  54: 73 */     this.listHelper = new ListHelper();
/*  55: 74 */     this.dealerList = this.listHelper.dealerList();
/*  56: 75 */     this.payModeList = this.listHelper.getPaymentModeList();
/*  57: 76 */     this.typeList = this.listHelper.getSteelbarTypeList();
/*  58: 77 */     setPurchaseSteelbarSearchList(PurchaseCementAdvanceSearch.getPurchaseCementSearchList());
/*  59:    */   }
/*  60:    */   
/*  61:    */   public String execute()
/*  62:    */     throws Exception
/*  63:    */   {
/*  64: 84 */     this.purchaseSteelBarServiceInf = new PurchaseSteelBarServiceImpl();
/*  65: 85 */     this.steelBarPurchaseList = this.purchaseSteelBarServiceInf.retrivePurchaseSteelBarDetailsGrid(this.purchaseSteelBarVO);
/*  66: 86 */     return "success";
/*  67:    */   }
/*  68:    */   
/*  69:    */   public String addPurchaseSteelbar()
/*  70:    */     throws CreateFailedException
/*  71:    */   {
/*  72: 92 */     this.purchaseSteelBarServiceInf = new PurchaseSteelBarServiceImpl();
/*  73:    */     
/*  74: 94 */     this.purchaseSteelBarServiceInf.insertPurchaseSteelBarsDetails(this.purchaseSteelBarVO);
/*  75: 95 */     this.purchaseSteelBarServiceInf.insertIntoLedger(this.purchaseSteelBarVO);
/*  76: 96 */     return "success";
/*  77:    */   }
/*  78:    */   
/*  79:    */   public void getDealerDetails()
/*  80:    */     throws IOException
/*  81:    */   {
/*  82:    */     try
/*  83:    */     {
/*  84:102 */       System.out.println("hello bharti ur in jsoncode_(((((((((");
/*  85:103 */       JSONObject dealerDetails = new JSONObject();
/*  86:    */       
/*  87:105 */       int dealerId = Integer.parseInt(this.request.getParameter("dealerId"));
/*  88:    */       
/*  89:    */ 
/*  90:108 */       System.out.println("hello bharti ur in jsoncode_(((((((((" + dealerId);
/*  91:109 */       this.listHelper = new ListHelper();
/*  92:110 */       dealerDetails = this.listHelper.getDealerDetail(dealerId);
/*  93:    */       
/*  94:112 */       PrintWriter out = this.response.getWriter();
/*  95:    */       
/*  96:114 */       out.print(dealerDetails);
/*  97:    */     }
/*  98:    */     catch (Exception exception)
/*  99:    */     {
/* 100:117 */       System.out.println(exception);
/* 101:    */     }
/* 102:    */   }
/* 103:    */   
/* 104:    */   public String viewSteelBarPurchsaseDetailsGrid()
/* 105:    */     throws RecordNotFoundException
/* 106:    */   {
/* 107:125 */     this.purchaseSteelBarServiceInf = new PurchaseSteelBarServiceImpl();
/* 108:    */     
/* 109:    */ 
/* 110:128 */     this.steelBarPurchaseList = this.purchaseSteelBarServiceInf
/* 111:129 */       .retrivePurchaseSteelBarDetailsForSearch(this.purchaseSteelBarVO);
/* 112:130 */     System.out.println("sussssssssss");
/* 113:131 */     if (this.steelBarPurchaseList == null)
/* 114:    */     {
/* 115:132 */       logger.error(" Error: While getting SteelBar Purchase details");
/* 116:133 */       addActionError("No Records found");
/* 117:134 */       return "error";
/* 118:    */     }
/* 119:136 */     logger.info("Records found Successfully");
/* 120:137 */     return "success";
/* 121:    */   }
/* 122:    */   
/* 123:    */   public String viewSpecificSteelBarPurchaseDetail()
/* 124:    */     throws RecordNotFoundException
/* 125:    */   {
/* 126:144 */     this.purchaseSteelBarServiceInf = new PurchaseSteelBarServiceImpl();
/* 127:145 */     String id = this.request.getParameter("command");
/* 128:    */     
/* 129:147 */     int purchaseId = Integer.parseInt(id);
/* 130:148 */     LoginUtil.setProcessUserId(purchaseId);
/* 131:149 */     System.out.println(purchaseId);
/* 132:    */     
/* 133:151 */     this.purchaseSteelBarVO = VOMapperHelper.getPurchaseSteelbarFromPurchaseSteebarDeltails(this.purchaseSteelBarVO, this.purchaseSteelBarServiceInf.retriveSpecificPurchaseSteelBarDetail(purchaseId));
/* 134:    */     
/* 135:153 */     return "success";
/* 136:    */   }
/* 137:    */   
/* 138:    */   public String deleteSpecificSteelbarPurchaseDetails()
/* 139:    */     throws DeleteFailedException
/* 140:    */   {
/* 141:160 */     String delId = this.request.getParameter("command");
/* 142:161 */     int purchaseId = Integer.parseInt(delId);
/* 143:162 */     this.purchaseSteelBarServiceInf = new PurchaseSteelBarServiceImpl();
/* 144:163 */     String message = this.purchaseSteelBarServiceInf.deleteSpecificSteelbarPurchaseDetails(purchaseId);
/* 145:164 */     if (message.equals("SUCCESS"))
/* 146:    */     {
/* 147:165 */       logger.info("Records found Successfully");
/* 148:166 */       addActionMessage("Steelbar Purchase Details inserted successfully!!");
/* 149:167 */       return "success";
/* 150:    */     }
/* 151:169 */     logger.error(" Error: While getting Steelbar Purchase details");
/* 152:170 */     addActionError("No Records found");
/* 153:171 */     return "error";
/* 154:    */   }
/* 155:    */   
/* 156:    */   public String retrivePurchaseSteelbarDetailsForEdit()
/* 157:    */     throws RecordNotFoundException
/* 158:    */   {
/* 159:182 */     this.purchaseSteelBarServiceInf = new PurchaseSteelBarServiceImpl();
/* 160:183 */     String id = this.request.getParameter("command");
/* 161:    */     
/* 162:185 */     int purchaseId = Integer.parseInt(id);
/* 163:186 */     LoginUtil.setProcessUserId(purchaseId);
/* 164:    */     
/* 165:188 */     System.out.println(purchaseId);
/* 166:    */     
/* 167:190 */     this.purchaseSteelBarVO = VOMapperHelper.getPurchaseSteelbarFromPurchaseSteebarDeltails(this.purchaseSteelBarVO, this.purchaseSteelBarServiceInf.retrivePurchaseSteelbarDetailsForEdit(purchaseId));
/* 168:    */     
/* 169:    */ 
/* 170:    */ 
/* 171:194 */     return "success";
/* 172:    */   }
/* 173:    */   
/* 174:    */   public String updateSpecificPurchaseRecord()
/* 175:    */     throws UpdateFailedException
/* 176:    */   {
/* 177:202 */     this.purchaseSteelBarServiceInf = new PurchaseSteelBarServiceImpl();
/* 178:    */     
/* 179:    */ 
/* 180:205 */     int purchaseId = LoginUtil.getProcessUserId();
/* 181:    */     
/* 182:207 */     System.out.println(purchaseId);
/* 183:    */     
/* 184:    */ 
/* 185:210 */     this.purchaseSteelBarServiceInf.updateSpecificPurchaseRecord(this.purchaseSteelBarVO, purchaseId);
/* 186:211 */     return "success";
/* 187:    */   }
/* 188:    */   
/* 189:    */   public String purchasePrintPDF()
/* 190:    */     throws Exception
/* 191:    */   {
/* 192:218 */     int purchaseId = LoginUtil.getProcessUserId();
/* 193:219 */     LoginUtil.setProcessUserId(purchaseId);
/* 194:220 */     this.purchaseSteelBarServiceInf = new PurchaseSteelBarServiceImpl();
/* 195:221 */     this.purchaseSteelBarServiceInf.purchasePDF(this.request, this.response, purchaseId);
/* 196:222 */     return null;
/* 197:    */   }
/* 198:    */   
/* 199:    */   public String purchaseSteelBarExcelReport()
/* 200:    */     throws Exception
/* 201:    */   {
/* 202:227 */     this.purchaseSteelBarServiceInf = new PurchaseSteelBarServiceImpl();
/* 203:228 */     this.purchaseSteelBarServiceInf.purchaseSteelBarExcelReport(this.request, this.response);
/* 204:229 */     return "none";
/* 205:    */   }
/* 206:    */   
/* 207:    */   public String viewNextPurchaseSteelbarDetail()
/* 208:    */     throws Exception
/* 209:    */   {
/* 210:236 */     this.purchaseSteelBarServiceInf = new PurchaseSteelBarServiceImpl();
/* 211:237 */     int purchaseId = LoginUtil.getProcessUserId();
/* 212:238 */     this.purchaseSteelBarVO = VOMapperHelper.getPurchaseSteelbarFromPurchaseSteebarDeltails(this.purchaseSteelBarVO, 
/* 213:239 */       this.purchaseSteelBarServiceInf.viewNextPurchaseSteelbarDetails(purchaseId));
/* 214:242 */     if (this.purchaseSteelBarVO.getPurchaseId() != 0)
/* 215:    */     {
/* 216:243 */       logger.info("Purchase steelbar details found successfully for purchase Id  " + 
/* 217:244 */         this.purchaseSteelBarVO.getPurchaseId());
/* 218:245 */       addActionMessage("Purchase cement details found successfully for purchase Id " + 
/* 219:246 */         this.purchaseSteelBarVO.getPurchaseId());
/* 220:247 */       return "success";
/* 221:    */     }
/* 222:249 */     this.purchaseSteelBarVO.setPurchaseId(LoginUtil.getProcessUserId());
/* 223:250 */     logger.error("Purchase steelbar details not found for purchase Id  " + 
/* 224:251 */       this.purchaseSteelBarVO.getPurchaseId());
/* 225:252 */     addActionError("Purchase steelbar details not found for purchase Id " + 
/* 226:253 */       this.purchaseSteelBarVO.getPurchaseId());
/* 227:254 */     return "error";
/* 228:    */   }
/* 229:    */   
/* 230:    */   public String viewPreviousPurchaseSteelbar()
/* 231:    */     throws Exception
/* 232:    */   {
/* 233:262 */     this.purchaseSteelBarServiceInf = new PurchaseSteelBarServiceImpl();
/* 234:263 */     int purchaseId = LoginUtil.getProcessUserId();
/* 235:264 */     this.purchaseSteelBarVO = VOMapperHelper.getPurchaseSteelbarFromPurchaseSteebarDeltails(this.purchaseSteelBarVO, 
/* 236:265 */       this.purchaseSteelBarServiceInf.viewPreviousPurchaseCement(purchaseId));
/* 237:268 */     if (this.purchaseSteelBarVO.getPurchaseId() != 0)
/* 238:    */     {
/* 239:269 */       logger.info("Purchase steelbar details found successfully for Purchase Id  " + 
/* 240:270 */         this.purchaseSteelBarVO.getPurchaseId());
/* 241:271 */       addActionMessage("Purchase cement details found successfully for Purchase Id " + 
/* 242:272 */         this.purchaseSteelBarVO.getPurchaseId());
/* 243:273 */       return "success";
/* 244:    */     }
/* 245:274 */     if (LoginUtil.getProcessUserId() == -1)
/* 246:    */     {
/* 247:275 */       LoginUtil.setProcessUserId(this.purchaseSteelBarDaoInf.getPurchaseSteelbarLastRecord() + 1);
/* 248:276 */       logger.error("Purchase steelbar details not found");
/* 249:277 */       addActionError("Purchase steelbar details not found");
/* 250:278 */       return "error";
/* 251:    */     }
/* 252:280 */     this.purchaseSteelBarVO.setPurchaseId(LoginUtil.getProcessUserId());
/* 253:281 */     logger.error("Purchase steelbar details not found for Purchase Id  " + 
/* 254:282 */       this.purchaseSteelBarVO.getPurchaseId());
/* 255:283 */     addActionError("Purchase steelbar details not found for Purchase Id " + 
/* 256:284 */       this.purchaseSteelBarVO.getPurchaseId());
/* 257:285 */     return "error";
/* 258:    */   }
/* 259:    */   
/* 260:    */   public String viewSteelbarStockGrid()
/* 261:    */     throws RecordNotFoundException
/* 262:    */   {
/* 263:293 */     this.purchaseSteelBarServiceInf = new PurchaseSteelBarServiceImpl();
/* 264:294 */     this.steelBarPurchaseList = this.purchaseSteelBarServiceInf.viewSteelbarStockGrid();
/* 265:295 */     return "success";
/* 266:    */   }
/* 267:    */   
/* 268:    */   public void setServletResponse(HttpServletResponse response)
/* 269:    */   {
/* 270:306 */     this.response = response;
/* 271:    */   }
/* 272:    */   
/* 273:    */   public PurchaseSteelBarVO getModel()
/* 274:    */   {
/* 275:312 */     return this.purchaseSteelBarVO;
/* 276:    */   }
/* 277:    */   
/* 278:    */   public void setServletRequest(HttpServletRequest request)
/* 279:    */   {
/* 280:318 */     this.request = request;
/* 281:    */   }
/* 282:    */   
/* 283:    */   public HttpServletRequest getRequest()
/* 284:    */   {
/* 285:322 */     return this.request;
/* 286:    */   }
/* 287:    */   
/* 288:    */   public void setRequest(HttpServletRequest request)
/* 289:    */   {
/* 290:326 */     this.request = request;
/* 291:    */   }
/* 292:    */   
/* 293:    */   public HttpServletResponse getResponse()
/* 294:    */   {
/* 295:330 */     return this.response;
/* 296:    */   }
/* 297:    */   
/* 298:    */   public void setResponse(HttpServletResponse response)
/* 299:    */   {
/* 300:334 */     this.response = response;
/* 301:    */   }
/* 302:    */   
/* 303:    */   public Map<Integer, String> getDealerList()
/* 304:    */   {
/* 305:339 */     return this.dealerList;
/* 306:    */   }
/* 307:    */   
/* 308:    */   public void setDealerList(Map<Integer, String> dealerList)
/* 309:    */   {
/* 310:344 */     this.dealerList = dealerList;
/* 311:    */   }
/* 312:    */   
/* 313:    */   public PurchaseSteelBarVO getPurchaseSteelBarVO()
/* 314:    */   {
/* 315:349 */     return this.purchaseSteelBarVO;
/* 316:    */   }
/* 317:    */   
/* 318:    */   public void setPurchaseSteelBarVO(PurchaseSteelBarVO purchaseSteelBarVO)
/* 319:    */   {
/* 320:354 */     this.purchaseSteelBarVO = purchaseSteelBarVO;
/* 321:    */   }
/* 322:    */   
/* 323:    */   public List<PurchaseSteelBarVO> getSteelBarPurchaseList()
/* 324:    */   {
/* 325:359 */     return this.steelBarPurchaseList;
/* 326:    */   }
/* 327:    */   
/* 328:    */   public void setSteelBarPurchaseList(List<PurchaseSteelBarVO> steelBarPurchaseList)
/* 329:    */   {
/* 330:365 */     this.steelBarPurchaseList = steelBarPurchaseList;
/* 331:    */   }
/* 332:    */   
/* 333:    */   public Map<Integer, String> getPurchaseSteelbarSearchList()
/* 334:    */   {
/* 335:370 */     return this.purchaseSteelbarSearchList;
/* 336:    */   }
/* 337:    */   
/* 338:    */   public void setPurchaseSteelbarSearchList(Map<Integer, String> purchaseSteelbarSearchList)
/* 339:    */   {
/* 340:376 */     this.purchaseSteelbarSearchList = purchaseSteelbarSearchList;
/* 341:    */   }
/* 342:    */   
/* 343:    */   public Map<Integer, String> getPayModeList()
/* 344:    */   {
/* 345:381 */     return this.payModeList;
/* 346:    */   }
/* 347:    */   
/* 348:    */   public void setPayModeList(Map<Integer, String> payModeList)
/* 349:    */   {
/* 350:386 */     this.payModeList = payModeList;
/* 351:    */   }
/* 352:    */   
/* 353:    */   public Map<Integer, String> getTypeList()
/* 354:    */   {
/* 355:391 */     return this.typeList;
/* 356:    */   }
/* 357:    */   
/* 358:    */   public void setTypeList(Map<Integer, String> typeList)
/* 359:    */   {
/* 360:396 */     this.typeList = typeList;
/* 361:    */   }
/* 362:    */   
/* 363:    */   public Map<String, Object> getSession()
/* 364:    */   {
/* 365:401 */     return this.session;
/* 366:    */   }
/* 367:    */   
/* 368:    */   public void setSession(Map<String, Object> session)
/* 369:    */   {
/* 370:407 */     this.session = session;
/* 371:    */   }
/* 372:    */ }


/* Location:           C:\Users\bharti\Desktop\Chouksay\lost\action\
 * Qualified Name:     com.bst.ckt.action.PurchaseSteelBarsAction
 * JD-Core Version:    0.7.0.1
 */