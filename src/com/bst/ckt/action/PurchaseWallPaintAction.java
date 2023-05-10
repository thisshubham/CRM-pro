/*   1:    */ package com.bst.ckt.action;
/*   2:    */ 
/*   3:    */ import com.bst.ckt.common.LoginUtil;
/*   4:    */ import com.bst.ckt.dao.PurchaseWallPaintDaoInf;
/*   5:    */ import com.bst.ckt.exception.CreateFailedException;
/*   6:    */ import com.bst.ckt.exception.RecordNotFoundException;
/*   7:    */ import com.bst.ckt.exception.UpdateFailedException;
/*   8:    */ import com.bst.ckt.helper.ListHelper;
/*   9:    */ import com.bst.ckt.helper.PurchaseCementAdvanceSearch;
/*  10:    */ import com.bst.ckt.helper.VOMapperHelper;
/*  11:    */ import com.bst.ckt.service.PurchaseWallPaintServiceImpl;
/*  12:    */ import com.bst.ckt.service.PurchaseWallPaintServiceInf;
/*  13:    */ import com.bst.ckt.vo.PurchaseWallPaintVO;
/*  14:    */ import com.opensymphony.xwork2.ActionContext;
/*  15:    */ import com.opensymphony.xwork2.ActionSupport;
/*  16:    */ import com.opensymphony.xwork2.ModelDriven;
/*  17:    */ import java.io.PrintStream;
/*  18:    */ import java.util.List;
/*  19:    */ import java.util.Map;
/*  20:    */ import javax.servlet.http.HttpServletRequest;
/*  21:    */ import javax.servlet.http.HttpServletResponse;
/*  22:    */ import org.apache.log4j.Logger;
/*  23:    */ import org.apache.struts2.interceptor.ServletRequestAware;
/*  24:    */ import org.apache.struts2.interceptor.ServletResponseAware;
/*  25:    */ import org.apache.struts2.interceptor.SessionAware;
/*  26:    */ 
/*  27:    */ public class PurchaseWallPaintAction
/*  28:    */   extends ActionSupport
/*  29:    */   implements ServletRequestAware, ModelDriven<PurchaseWallPaintVO>, ServletResponseAware, SessionAware
/*  30:    */ {
/*  31:    */   private static final long serialVersionUID = 1L;
/*  32: 45 */   private static final Logger logger = Logger.getLogger(PurchaseWallPaintAction.class);
/*  33: 48 */   HttpServletRequest request = (HttpServletRequest)ActionContext.getContext().get("com.opensymphony.xwork2.dispatcher.HttpServletRequest");
/*  34: 52 */   PurchaseWallPaintVO purchaseWallPaintVO = new PurchaseWallPaintVO();
/*  35: 53 */   PurchaseWallPaintServiceInf purchaseWallPaintServiceInf = null;
/*  36: 54 */   PurchaseWallPaintDaoInf purchaseWallPaintDaoInf = null;
/*  37: 55 */   List<PurchaseWallPaintVO> wallPaintPurchaseList = null;
/*  38: 57 */   HttpServletResponse response = null;
/*  39: 58 */   ListHelper listHelper = null;
/*  40: 59 */   Map<String, Object> session = null;
/*  41:    */   private Map<Integer, String> dealerList;
/*  42:    */   private Map<Integer, String> purchaseWallpaintSearchList;
/*  43:    */   private Map<Integer, String> payModeList;
/*  44:    */   private Map<Integer, String> transportList;
/*  45:    */   private Map<Integer, String> typeList;
/*  46:    */   
/*  47:    */   public PurchaseWallPaintAction()
/*  48:    */     throws Exception
/*  49:    */   {
/*  50: 71 */     this.listHelper = new ListHelper();
/*  51: 72 */     this.dealerList = this.listHelper.dealerList();
/*  52: 73 */     this.payModeList = this.listHelper.getPaymentModeList();
/*  53: 74 */     this.typeList = this.listHelper.getCementTypeList();
/*  54: 75 */     this.transportList = this.listHelper.getTransportList();
/*  55: 76 */     setPurchaseWallpaintSearchList(PurchaseCementAdvanceSearch.getPurchaseCementSearchList());
/*  56:    */   }
/*  57:    */   
/*  58:    */   public String execute()
/*  59:    */     throws Exception
/*  60:    */   {
/*  61: 82 */     this.purchaseWallPaintServiceInf = new PurchaseWallPaintServiceImpl();
/*  62: 83 */     this.wallPaintPurchaseList = this.purchaseWallPaintServiceInf.fetchPurchaseWallPaintList();
/*  63: 84 */     return "success";
/*  64:    */   }
/*  65:    */   
/*  66:    */   public String addPurchaseWallPaint()
/*  67:    */     throws CreateFailedException
/*  68:    */   {
/*  69: 91 */     this.purchaseWallPaintServiceInf = new PurchaseWallPaintServiceImpl();
/*  70: 92 */     this.purchaseWallPaintServiceInf.addPurchaseWallPaint(this.purchaseWallPaintVO);
/*  71:    */     
/*  72: 94 */     return "success";
/*  73:    */   }
/*  74:    */   
/*  75:    */   public String getPurchaseWallPaintDetails()
/*  76:    */     throws RecordNotFoundException
/*  77:    */   {
/*  78: 99 */     this.purchaseWallPaintServiceInf = new PurchaseWallPaintServiceImpl();
/*  79:100 */     this.wallPaintPurchaseList = this.purchaseWallPaintServiceInf.fetchPurchaseWallPaintListForAdvanceSearch(this.purchaseWallPaintVO);
/*  80:101 */     return "success";
/*  81:    */   }
/*  82:    */   
/*  83:    */   public String updateSpecificPurchaseRecord()
/*  84:    */     throws UpdateFailedException
/*  85:    */   {
/*  86:107 */     this.purchaseWallPaintServiceInf = new PurchaseWallPaintServiceImpl();
/*  87:108 */     int purchaseId = LoginUtil.getProcessUserId();
/*  88:    */     
/*  89:110 */     this.purchaseWallPaintServiceInf.updateSpecificPurchaseRecord(this.purchaseWallPaintVO, purchaseId, this.purchaseWallPaintVO.getTransactionId());
/*  90:111 */     return "success";
/*  91:    */   }
/*  92:    */   
/*  93:    */   public String retrivePurchaseCementDetailsForEdit()
/*  94:    */     throws RecordNotFoundException
/*  95:    */   {
/*  96:117 */     this.purchaseWallPaintServiceInf = new PurchaseWallPaintServiceImpl();
/*  97:118 */     String id = this.request.getParameter("command");
/*  98:119 */     System.out.println("IIIDDDDDDDDISSSSID" + id);
/*  99:120 */     int purchaseId = Integer.parseInt(id);
/* 100:121 */     LoginUtil.setProcessUserId(purchaseId);
/* 101:122 */     System.out.println(purchaseId);
/* 102:123 */     this.purchaseWallPaintVO = VOMapperHelper.getPurchaseWallPaintFromPurchaseWallPaintDetails(this.purchaseWallPaintVO, this.purchaseWallPaintServiceInf.retriveSpecificPurchaseDetailForUpdate(purchaseId));
/* 103:124 */     System.out.println("bharti u r absolutely correct!!!!!!!!!" + this.purchaseWallPaintVO.getTransactionId());
/* 104:    */     
/* 105:126 */     return "success";
/* 106:    */   }
/* 107:    */   
/* 108:    */   public String viewNextPurchaseWallPaintDetail()
/* 109:    */     throws Exception
/* 110:    */   {
/* 111:132 */     this.purchaseWallPaintServiceInf = new PurchaseWallPaintServiceImpl();
/* 112:133 */     int purchaseId = LoginUtil.getProcessUserId();
/* 113:134 */     this.purchaseWallPaintVO = VOMapperHelper.getPurchaseWallPaintFromPurchaseWallPaintDetails(this.purchaseWallPaintVO, 
/* 114:135 */       this.purchaseWallPaintServiceInf.viewNextPurchaseWallPaintDetail(purchaseId));
/* 115:138 */     if (this.purchaseWallPaintVO.getPurchaseId() != 0)
/* 116:    */     {
/* 117:139 */       logger.info("Purchase wallpaint details found successfully for purchase Id  " + 
/* 118:140 */         this.purchaseWallPaintVO.getPurchaseId());
/* 119:141 */       addActionMessage("Purchase wallpaint details found successfully for purchase Id " + 
/* 120:142 */         this.purchaseWallPaintVO.getPurchaseId());
/* 121:143 */       return "success";
/* 122:    */     }
/* 123:145 */     this.purchaseWallPaintVO.setPurchaseId(LoginUtil.getProcessUserId());
/* 124:146 */     logger.error("Purchase wallpaint details not found for purchase Id  " + 
/* 125:147 */       this.purchaseWallPaintVO.getPurchaseId());
/* 126:148 */     addActionError("Purchase wallpaint details not found for purchase Id " + 
/* 127:149 */       this.purchaseWallPaintVO.getPurchaseId());
/* 128:150 */     return "error";
/* 129:    */   }
/* 130:    */   
/* 131:    */   public String viewPreviousPurchaseWallpaint()
/* 132:    */     throws Exception
/* 133:    */   {
/* 134:157 */     this.purchaseWallPaintServiceInf = new PurchaseWallPaintServiceImpl();
/* 135:158 */     int purchaseId = LoginUtil.getProcessUserId();
/* 136:159 */     this.purchaseWallPaintVO = VOMapperHelper.getPurchaseWallPaintFromPurchaseWallPaintDetails(this.purchaseWallPaintVO, 
/* 137:160 */       this.purchaseWallPaintServiceInf.viewPreviousPurchaseWallpaint(purchaseId));
/* 138:163 */     if (this.purchaseWallPaintVO.getPurchaseId() != 0)
/* 139:    */     {
/* 140:164 */       logger.info("Purchase wallpaint details found successfully for Purchase Id  " + 
/* 141:165 */         this.purchaseWallPaintVO.getPurchaseId());
/* 142:166 */       addActionMessage("Purchase wallpaint details found successfully for Purchase Id " + 
/* 143:167 */         this.purchaseWallPaintVO.getPurchaseId());
/* 144:168 */       return "success";
/* 145:    */     }
/* 146:169 */     if (LoginUtil.getProcessUserId() == -1)
/* 147:    */     {
/* 148:170 */       LoginUtil.setProcessUserId(this.purchaseWallPaintDaoInf.getPurchaseWallPaintLastRecord() + 1);
/* 149:171 */       logger.error("Purchase wallpaint details not found");
/* 150:172 */       addActionError("Purchase wallpaint details not found");
/* 151:173 */       return "error";
/* 152:    */     }
/* 153:175 */     this.purchaseWallPaintVO.setPurchaseId(LoginUtil.getProcessUserId());
/* 154:176 */     logger.error("Purchase wallpaint details not found for Purchase Id  " + 
/* 155:177 */       this.purchaseWallPaintVO.getPurchaseId());
/* 156:178 */     addActionError("Purchase wallpaint details not found for Purchase Id " + 
/* 157:179 */       this.purchaseWallPaintVO.getPurchaseId());
/* 158:180 */     return "error";
/* 159:    */   }
/* 160:    */   
/* 161:    */   public String retrivedPurchaseWallPaint()
/* 162:    */     throws Exception
/* 163:    */   {
/* 164:188 */     System.out.println("___________ACTIONCLASS______");
/* 165:189 */     String id = this.request.getParameter("command");
/* 166:190 */     int purchaseId = Integer.parseInt(id);
/* 167:191 */     LoginUtil.setProcessUserId(purchaseId);
/* 168:192 */     System.out.println(purchaseId);
/* 169:193 */     PurchaseWallPaintServiceInf purchaseWallPaintServiceInf = new PurchaseWallPaintServiceImpl();
/* 170:194 */     this.purchaseWallPaintVO = VOMapperHelper.getPurchaseWallPaintFromPurchaseWallPaintDetails(this.purchaseWallPaintVO, purchaseWallPaintServiceInf.retrivePurchaseWallPaintFullDetailGrid(purchaseId));
/* 171:195 */     System.out.println("City ::  " + this.purchaseWallPaintVO.getCompanyName());
/* 172:196 */     return "success";
/* 173:    */   }
/* 174:    */   
/* 175:    */   public String deleteWallPaint()
/* 176:    */     throws Exception
/* 177:    */   {
/* 178:    */     try
/* 179:    */     {
/* 180:204 */       this.purchaseWallPaintServiceInf = new PurchaseWallPaintServiceImpl();
/* 181:205 */       int purchaseId = Integer.parseInt(this.request.getParameter("command"));
/* 182:206 */       System.out.println(purchaseId + "we r in delete shailendra");
/* 183:207 */       this.purchaseWallPaintServiceInf.deleteWallPaint(purchaseId);
/* 184:    */     }
/* 185:    */     catch (Exception exception)
/* 186:    */     {
/* 187:212 */       logger.error("ERROR:Erroe while delete purchase wallpaint details from database." + exception);
/* 188:213 */       return "error";
/* 189:    */     }
/* 190:216 */     return "success";
/* 191:    */   }
/* 192:    */   
/* 193:    */   public String purchaseWallPaintPrintPDF()
/* 194:    */     throws Exception
/* 195:    */   {
/* 196:224 */     System.out.println("ttttttttttttttttttttttttttttttttttttttttttttttttttttttttttt");
/* 197:225 */     int purchaseId = LoginUtil.getProcessUserId();
/* 198:226 */     System.out.println(purchaseId + "OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
/* 199:227 */     PurchaseWallPaintServiceInf purchaseWallPaintServiceInf = new PurchaseWallPaintServiceImpl();
/* 200:228 */     purchaseWallPaintServiceInf.purchaseWallPaintPrintPDF(this.request, this.response, purchaseId);
/* 201:229 */     return null;
/* 202:    */   }
/* 203:    */   
/* 204:    */   public void setSession(Map<String, Object> session)
/* 205:    */   {
/* 206:237 */     this.session = session;
/* 207:    */   }
/* 208:    */   
/* 209:    */   public void setServletResponse(HttpServletResponse response)
/* 210:    */   {
/* 211:246 */     this.response = response;
/* 212:    */   }
/* 213:    */   
/* 214:    */   public PurchaseWallPaintVO getModel()
/* 215:    */   {
/* 216:252 */     return this.purchaseWallPaintVO;
/* 217:    */   }
/* 218:    */   
/* 219:    */   public void setServletRequest(HttpServletRequest request)
/* 220:    */   {
/* 221:258 */     this.request = request;
/* 222:    */   }
/* 223:    */   
/* 224:    */   public HttpServletRequest getRequest()
/* 225:    */   {
/* 226:262 */     return this.request;
/* 227:    */   }
/* 228:    */   
/* 229:    */   public void setRequest(HttpServletRequest request)
/* 230:    */   {
/* 231:266 */     this.request = request;
/* 232:    */   }
/* 233:    */   
/* 234:    */   public HttpServletResponse getResponse()
/* 235:    */   {
/* 236:270 */     return this.response;
/* 237:    */   }
/* 238:    */   
/* 239:    */   public void setResponse(HttpServletResponse response)
/* 240:    */   {
/* 241:274 */     this.response = response;
/* 242:    */   }
/* 243:    */   
/* 244:    */   public Map<Integer, String> getDealerList()
/* 245:    */   {
/* 246:279 */     return this.dealerList;
/* 247:    */   }
/* 248:    */   
/* 249:    */   public void setDealerList(Map<Integer, String> dealerList)
/* 250:    */   {
/* 251:284 */     this.dealerList = dealerList;
/* 252:    */   }
/* 253:    */   
/* 254:    */   public Map<Integer, String> getPayModeList()
/* 255:    */   {
/* 256:296 */     return this.payModeList;
/* 257:    */   }
/* 258:    */   
/* 259:    */   public void setPayModeList(Map<Integer, String> payModeList)
/* 260:    */   {
/* 261:301 */     this.payModeList = payModeList;
/* 262:    */   }
/* 263:    */   
/* 264:    */   public Map<Integer, String> getTypeList()
/* 265:    */   {
/* 266:306 */     return this.typeList;
/* 267:    */   }
/* 268:    */   
/* 269:    */   public void setTypeList(Map<Integer, String> typeList)
/* 270:    */   {
/* 271:311 */     this.typeList = typeList;
/* 272:    */   }
/* 273:    */   
/* 274:    */   public Map<Integer, String> getTransportList()
/* 275:    */   {
/* 276:316 */     return this.transportList;
/* 277:    */   }
/* 278:    */   
/* 279:    */   public void setTransportList(Map<Integer, String> transportList)
/* 280:    */   {
/* 281:321 */     this.transportList = transportList;
/* 282:    */   }
/* 283:    */   
/* 284:    */   public Map<String, Object> getSession()
/* 285:    */   {
/* 286:327 */     return this.session;
/* 287:    */   }
/* 288:    */   
/* 289:    */   public PurchaseWallPaintVO getPurchaseWallPaintVO()
/* 290:    */   {
/* 291:335 */     return this.purchaseWallPaintVO;
/* 292:    */   }
/* 293:    */   
/* 294:    */   public void setPurchaseWallPaintVO(PurchaseWallPaintVO purchaseWallPaintVO)
/* 295:    */   {
/* 296:343 */     this.purchaseWallPaintVO = purchaseWallPaintVO;
/* 297:    */   }
/* 298:    */   
/* 299:    */   public List<PurchaseWallPaintVO> getWallPaintPurchaseList()
/* 300:    */   {
/* 301:351 */     return this.wallPaintPurchaseList;
/* 302:    */   }
/* 303:    */   
/* 304:    */   public void setWallPaintPurchaseList(List<PurchaseWallPaintVO> wallPaintPurchaseList)
/* 305:    */   {
/* 306:360 */     this.wallPaintPurchaseList = wallPaintPurchaseList;
/* 307:    */   }
/* 308:    */   
/* 309:    */   public Map<Integer, String> getPurchaseWallpaintSearchList()
/* 310:    */   {
/* 311:364 */     return this.purchaseWallpaintSearchList;
/* 312:    */   }
/* 313:    */   
/* 314:    */   public void setPurchaseWallpaintSearchList(Map<Integer, String> purchaseWallpaintSearchList)
/* 315:    */   {
/* 316:370 */     this.purchaseWallpaintSearchList = purchaseWallpaintSearchList;
/* 317:    */   }
/* 318:    */ }


/* Location:           C:\Users\bharti\Desktop\Chouksay\lost\action\
 * Qualified Name:     com.bst.ckt.action.PurchaseWallPaintAction
 * JD-Core Version:    0.7.0.1
 */