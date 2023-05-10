/*   1:    */ package com.bst.ckt.action;
/*   2:    */ 
/*   3:    */ import com.bst.ckt.common.LoginUtil;
/*   4:    */ import com.bst.ckt.dao.PurchasePesticidesDaoImpl;
/*   5:    */ import com.bst.ckt.dao.PurchasePesticidesDaoInf;
/*   6:    */ import com.bst.ckt.exception.CreateFailedException;
/*   7:    */ import com.bst.ckt.exception.DeleteFailedException;
/*   8:    */ import com.bst.ckt.exception.RecordNotFoundException;
/*   9:    */ import com.bst.ckt.exception.UpdateFailedException;
/*  10:    */ import com.bst.ckt.framework.user.CustomerSessionUser;
/*  11:    */ import com.bst.ckt.helper.ListHelper;
/*  12:    */ import com.bst.ckt.helper.PurchaseCementAdvanceSearch;
/*  13:    */ import com.bst.ckt.helper.VOMapperHelper;
/*  14:    */ import com.bst.ckt.service.PurchasePesticidesServiceImpl;
/*  15:    */ import com.bst.ckt.service.PurchasePesticidesServiceInf;
/*  16:    */ import com.bst.ckt.vo.PurchasePesticidesVO;
/*  17:    */ import com.opensymphony.xwork2.ActionContext;
/*  18:    */ import com.opensymphony.xwork2.ActionSupport;
/*  19:    */ import com.opensymphony.xwork2.ModelDriven;
/*  20:    */ import java.io.PrintStream;
/*  21:    */ import java.util.List;
/*  22:    */ import java.util.Map;
/*  23:    */ import javax.servlet.http.HttpServletRequest;
/*  24:    */ import javax.servlet.http.HttpServletResponse;
/*  25:    */ import org.apache.log4j.Logger;
/*  26:    */ import org.apache.struts2.interceptor.ServletRequestAware;
/*  27:    */ import org.apache.struts2.interceptor.ServletResponseAware;
/*  28:    */ import org.apache.struts2.interceptor.SessionAware;
/*  29:    */ 
/*  30:    */ public class PurchasePesticidesAction
/*  31:    */   extends ActionSupport
/*  32:    */   implements ServletRequestAware, ModelDriven<PurchasePesticidesVO>, ServletResponseAware, SessionAware
/*  33:    */ {
/*  34:    */   private static final long serialVersionUID = 1L;
/*  35: 48 */   private static final Logger logger = Logger.getLogger(PurchasePesticidesAction.class);
/*  36: 51 */   HttpServletRequest request = (HttpServletRequest)ActionContext.getContext().get("com.opensymphony.xwork2.dispatcher.HttpServletRequest");
/*  37: 53 */   CustomerSessionUser customerSessionUser = null;
/*  38: 54 */   int shopId = 0;
/*  39:    */   private Map<Integer, String> purchasePesticidesSearchList;
/*  40: 56 */   PurchasePesticidesVO purchasePesticidesVO = new PurchasePesticidesVO();
/*  41: 57 */   PurchasePesticidesServiceInf purchasePesticidesServiceInf = null;
/*  42: 58 */   PurchasePesticidesDaoInf purchasePesticidesDaoInf = new PurchasePesticidesDaoImpl();
/*  43: 61 */   HttpServletResponse response = null;
/*  44: 62 */   ListHelper listHelper = null;
/*  45: 63 */   Map<String, Object> session = null;
/*  46:    */   private Map<Integer, String> dealerList;
/*  47: 67 */   List<PurchasePesticidesVO> pesticidesPurchaseList = null;
/*  48:    */   private Map<Integer, String> payModeList;
/*  49:    */   private Map<Integer, String> transportList;
/*  50:    */   private Map<Integer, String> typeList;
/*  51:    */   
/*  52:    */   public PurchasePesticidesAction()
/*  53:    */     throws Exception
/*  54:    */   {
/*  55: 78 */     this.listHelper = new ListHelper();
/*  56: 79 */     this.dealerList = this.listHelper.dealerList();
/*  57: 80 */     this.payModeList = this.listHelper.getPaymentModeList();
/*  58: 81 */     this.typeList = this.listHelper.getCementTypeList();
/*  59: 82 */     this.transportList = this.listHelper.getTransportList();
/*  60: 83 */     setPurchasePesticidesSearchList(PurchaseCementAdvanceSearch.getPurchaseCementSearchList());
/*  61:    */   }
/*  62:    */   
/*  63:    */   public String execute()
/*  64:    */     throws Exception
/*  65:    */   {
/*  66: 92 */     this.purchasePesticidesServiceInf = new PurchasePesticidesServiceImpl();
/*  67: 93 */     this.pesticidesPurchaseList = this.purchasePesticidesServiceInf.getPurchasePesticidesDetails();
/*  68: 94 */     return "success";
/*  69:    */   }
/*  70:    */   
/*  71:    */   public String addPurchasePesticides()
/*  72:    */     throws CreateFailedException
/*  73:    */   {
/*  74:100 */     this.purchasePesticidesServiceInf = new PurchasePesticidesServiceImpl();
/*  75:    */     
/*  76:102 */     this.purchasePesticidesServiceInf.addPurchasePesticides(this.purchasePesticidesVO);
/*  77:    */     
/*  78:104 */     return "success";
/*  79:    */   }
/*  80:    */   
/*  81:    */   public String getPurchasePesticidesDetails()
/*  82:    */     throws RecordNotFoundException
/*  83:    */   {
/*  84:110 */     System.out.println("PPPPPPPPPPPPPPPPPP");
/*  85:111 */     this.purchasePesticidesServiceInf = new PurchasePesticidesServiceImpl();
/*  86:112 */     this.pesticidesPurchaseList = this.purchasePesticidesServiceInf.getPurchasePesticidesDetailsForAdvanceSearch(this.purchasePesticidesVO);
/*  87:113 */     return "success";
/*  88:    */   }
/*  89:    */   
/*  90:    */   public String updateSpecificPurchaseRecord()
/*  91:    */     throws UpdateFailedException
/*  92:    */   {
/*  93:119 */     this.purchasePesticidesServiceInf = new PurchasePesticidesServiceImpl();
/*  94:    */     
/*  95:121 */     int purchaseId = LoginUtil.getProcessUserId();
/*  96:    */     
/*  97:123 */     this.purchasePesticidesServiceInf.updateSpecificPurchaseRecord(this.purchasePesticidesVO, purchaseId, this.purchasePesticidesVO.getTransactionId());
/*  98:124 */     return "success";
/*  99:    */   }
/* 100:    */   
/* 101:    */   public String retriveSpecificPurchaseDetailForUpdate()
/* 102:    */     throws RecordNotFoundException
/* 103:    */   {
/* 104:130 */     this.purchasePesticidesServiceInf = new PurchasePesticidesServiceImpl();
/* 105:131 */     String id = this.request.getParameter("command");
/* 106:    */     
/* 107:133 */     System.out.println("IIIDDDDDDDDISSSSID" + id);
/* 108:134 */     int purchaseId = Integer.parseInt(id);
/* 109:    */     
/* 110:136 */     LoginUtil.setProcessUserId(purchaseId);
/* 111:    */     
/* 112:    */ 
/* 113:139 */     System.out.println(purchaseId);
/* 114:    */     
/* 115:141 */     this.purchasePesticidesVO = VOMapperHelper.getPurchasePesticidesVOFromPurchasePesticidesDetails(this.purchasePesticidesVO, this.purchasePesticidesServiceInf.retriveSpecificPurchaseDetailForUpdate(purchaseId));
/* 116:    */     
/* 117:143 */     System.out.println("bharti u r absolutely correct!!!!!!!!!" + this.purchasePesticidesVO.getTransactionId());
/* 118:    */     
/* 119:145 */     return "success";
/* 120:    */   }
/* 121:    */   
/* 122:    */   public String deleteSpecificPesticidePurchaseDetails()
/* 123:    */     throws DeleteFailedException
/* 124:    */   {
/* 125:153 */     String delId = this.request.getParameter("command");
/* 126:154 */     int purchaseId = Integer.parseInt(delId);
/* 127:155 */     this.purchasePesticidesServiceInf = new PurchasePesticidesServiceImpl();
/* 128:156 */     String message = this.purchasePesticidesServiceInf.deleteSpecificPesticidePurchaseDetails(purchaseId);
/* 129:157 */     if (message.equals("SUCCESS"))
/* 130:    */     {
/* 131:158 */       logger.info("Records found Successfully");
/* 132:159 */       addActionMessage("Pesticide Purchase Details inserted successfully!!");
/* 133:160 */       return "success";
/* 134:    */     }
/* 135:162 */     logger.error(" Error: While getting Pesticide Purchase details");
/* 136:163 */     addActionError("No Records found");
/* 137:164 */     return "error";
/* 138:    */   }
/* 139:    */   
/* 140:    */   public String retrivedPesticidesDetails()
/* 141:    */     throws Exception
/* 142:    */   {
/* 143:172 */     System.out.println("___________ACTIONCLASS______");
/* 144:173 */     String id = this.request.getParameter("command");
/* 145:174 */     System.out.println("___________ACTIONCLASS______" + id);
/* 146:175 */     int purchaseId = Integer.parseInt(id);
/* 147:176 */     LoginUtil.setProcessUserId(purchaseId);
/* 148:177 */     System.out.println(purchaseId + "XXXXXXXXxx");
/* 149:178 */     this.purchasePesticidesServiceInf = new PurchasePesticidesServiceImpl();
/* 150:179 */     this.purchasePesticidesVO = VOMapperHelper.getPurchasePesticidesVOFromPurchasePesticidesDetails(this.purchasePesticidesVO, this.purchasePesticidesServiceInf.retrivedPesticidesDetails(purchaseId));
/* 151:180 */     System.out.println("Title ::  " + this.purchasePesticidesVO.getAclId());
/* 152:181 */     return "success";
/* 153:    */   }
/* 154:    */   
/* 155:    */   public String viewNextPurchasePesticideDetail()
/* 156:    */     throws Exception
/* 157:    */   {
/* 158:188 */     this.purchasePesticidesServiceInf = new PurchasePesticidesServiceImpl();
/* 159:189 */     int purchaseId = LoginUtil.getProcessUserId();
/* 160:190 */     this.purchasePesticidesVO = VOMapperHelper.getPurchasePesticidesVOFromPurchasePesticidesDetails(this.purchasePesticidesVO, 
/* 161:191 */       this.purchasePesticidesServiceInf.viewNextPurchasePesticideDetail(purchaseId));
/* 162:194 */     if (this.purchasePesticidesVO.getPurchaseId() != 0)
/* 163:    */     {
/* 164:195 */       logger.info("Purchase pesticide details found successfully for purchase Id  " + 
/* 165:196 */         this.purchasePesticidesVO.getPurchaseId());
/* 166:197 */       addActionMessage("Purchase pesticide details found successfully for purchase Id " + 
/* 167:198 */         this.purchasePesticidesVO.getPurchaseId());
/* 168:199 */       return "success";
/* 169:    */     }
/* 170:201 */     this.purchasePesticidesVO.setPurchaseId(LoginUtil.getProcessUserId());
/* 171:202 */     logger.error("Purchase pesticide details not found for purchase Id  " + 
/* 172:203 */       this.purchasePesticidesVO.getPurchaseId());
/* 173:204 */     addActionError("Purchase pesticide details not found for purchase Id " + 
/* 174:205 */       this.purchasePesticidesVO.getPurchaseId());
/* 175:206 */     return "error";
/* 176:    */   }
/* 177:    */   
/* 178:    */   public String viewPreviousPurchasePesticide()
/* 179:    */     throws Exception
/* 180:    */   {
/* 181:213 */     this.purchasePesticidesServiceInf = new PurchasePesticidesServiceImpl();
/* 182:214 */     int purchaseId = LoginUtil.getProcessUserId();
/* 183:215 */     this.purchasePesticidesVO = VOMapperHelper.getPurchasePesticidesVOFromPurchasePesticidesDetails(this.purchasePesticidesVO, 
/* 184:216 */       this.purchasePesticidesServiceInf.viewPreviousPurchasePesticide(purchaseId));
/* 185:219 */     if (this.purchasePesticidesVO.getPurchaseId() != 0)
/* 186:    */     {
/* 187:220 */       logger.info("Purchase pesticide details found successfully for Purchase Id  " + 
/* 188:221 */         this.purchasePesticidesVO.getPurchaseId());
/* 189:222 */       addActionMessage("Purchase pesticide details found successfully for Purchase Id " + 
/* 190:223 */         this.purchasePesticidesVO.getPurchaseId());
/* 191:224 */       return "success";
/* 192:    */     }
/* 193:225 */     if (LoginUtil.getProcessUserId() == -1)
/* 194:    */     {
/* 195:226 */       LoginUtil.setProcessUserId(this.purchasePesticidesDaoInf.getPurchasePesticideLastRecord() + 1);
/* 196:227 */       logger.error("Purchase pesticide details not found");
/* 197:228 */       addActionError("Purchase pesticide details not found");
/* 198:229 */       return "error";
/* 199:    */     }
/* 200:231 */     this.purchasePesticidesVO.setPurchaseId(LoginUtil.getProcessUserId());
/* 201:232 */     logger.error("Purchase pesticide details not found for Purchase Id  " + 
/* 202:233 */       this.purchasePesticidesVO.getPurchaseId());
/* 203:234 */     addActionError("Purchase pesticide details not found for Purchase Id " + 
/* 204:235 */       this.purchasePesticidesVO.getPurchaseId());
/* 205:236 */     return "error";
/* 206:    */   }
/* 207:    */   
/* 208:    */   public String purchasePrintPDF()
/* 209:    */     throws Exception
/* 210:    */   {
/* 211:245 */     int purchaseId = LoginUtil.getProcessUserId();
/* 212:    */     
/* 213:247 */     this.purchasePesticidesServiceInf = new PurchasePesticidesServiceImpl();
/* 214:248 */     this.purchasePesticidesServiceInf.purchasePrintPDF(this.request, this.response, purchaseId);
/* 215:249 */     return null;
/* 216:    */   }
/* 217:    */   
/* 218:    */   public void setSession(Map<String, Object> session)
/* 219:    */   {
/* 220:253 */     this.session = session;
/* 221:    */   }
/* 222:    */   
/* 223:    */   public void setServletResponse(HttpServletResponse response)
/* 224:    */   {
/* 225:262 */     this.response = response;
/* 226:    */   }
/* 227:    */   
/* 228:    */   public PurchasePesticidesVO getModel()
/* 229:    */   {
/* 230:268 */     return this.purchasePesticidesVO;
/* 231:    */   }
/* 232:    */   
/* 233:    */   public void setServletRequest(HttpServletRequest request)
/* 234:    */   {
/* 235:274 */     this.request = request;
/* 236:    */   }
/* 237:    */   
/* 238:    */   public HttpServletRequest getRequest()
/* 239:    */   {
/* 240:278 */     return this.request;
/* 241:    */   }
/* 242:    */   
/* 243:    */   public void setRequest(HttpServletRequest request)
/* 244:    */   {
/* 245:282 */     this.request = request;
/* 246:    */   }
/* 247:    */   
/* 248:    */   public HttpServletResponse getResponse()
/* 249:    */   {
/* 250:286 */     return this.response;
/* 251:    */   }
/* 252:    */   
/* 253:    */   public void setResponse(HttpServletResponse response)
/* 254:    */   {
/* 255:290 */     this.response = response;
/* 256:    */   }
/* 257:    */   
/* 258:    */   public Map<Integer, String> getDealerList()
/* 259:    */   {
/* 260:295 */     return this.dealerList;
/* 261:    */   }
/* 262:    */   
/* 263:    */   public void setDealerList(Map<Integer, String> dealerList)
/* 264:    */   {
/* 265:300 */     this.dealerList = dealerList;
/* 266:    */   }
/* 267:    */   
/* 268:    */   public Map<Integer, String> getPayModeList()
/* 269:    */   {
/* 270:306 */     return this.payModeList;
/* 271:    */   }
/* 272:    */   
/* 273:    */   public void setPayModeList(Map<Integer, String> payModeList)
/* 274:    */   {
/* 275:311 */     this.payModeList = payModeList;
/* 276:    */   }
/* 277:    */   
/* 278:    */   public Map<Integer, String> getTypeList()
/* 279:    */   {
/* 280:316 */     return this.typeList;
/* 281:    */   }
/* 282:    */   
/* 283:    */   public void setTypeList(Map<Integer, String> typeList)
/* 284:    */   {
/* 285:321 */     this.typeList = typeList;
/* 286:    */   }
/* 287:    */   
/* 288:    */   public Map<Integer, String> getTransportList()
/* 289:    */   {
/* 290:326 */     return this.transportList;
/* 291:    */   }
/* 292:    */   
/* 293:    */   public void setTransportList(Map<Integer, String> transportList)
/* 294:    */   {
/* 295:331 */     this.transportList = transportList;
/* 296:    */   }
/* 297:    */   
/* 298:    */   public Map<String, Object> getSession()
/* 299:    */   {
/* 300:337 */     return this.session;
/* 301:    */   }
/* 302:    */   
/* 303:    */   public Map<Integer, String> getPurchasePesticidesSearchList()
/* 304:    */   {
/* 305:343 */     return this.purchasePesticidesSearchList;
/* 306:    */   }
/* 307:    */   
/* 308:    */   public void setPurchasePesticidesSearchList(Map<Integer, String> purchasePesticidesSearchList)
/* 309:    */   {
/* 310:350 */     this.purchasePesticidesSearchList = purchasePesticidesSearchList;
/* 311:    */   }
/* 312:    */   
/* 313:    */   public List<PurchasePesticidesVO> getPesticidesPurchaseList()
/* 314:    */   {
/* 315:355 */     return this.pesticidesPurchaseList;
/* 316:    */   }
/* 317:    */   
/* 318:    */   public void setPesticidesPurchaseList(List<PurchasePesticidesVO> pesticidesPurchaseList)
/* 319:    */   {
/* 320:362 */     this.pesticidesPurchaseList = pesticidesPurchaseList;
/* 321:    */   }
/* 322:    */ }


/* Location:           C:\Users\bharti\Desktop\Chouksay\lost\action\
 * Qualified Name:     com.bst.ckt.action.PurchasePesticidesAction
 * JD-Core Version:    0.7.0.1
 */