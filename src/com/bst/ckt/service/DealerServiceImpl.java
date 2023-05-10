/*   1:    */ package com.bst.ckt.service;
/*   2:    */ 
/*   3:    */ import com.bst.ckt.common.LoginUtil;
/*   4:    */ import com.bst.ckt.dao.DealerDaoImpl;
/*   5:    */ import com.bst.ckt.dao.DealerDaoInf;
/*   6:    */ import com.bst.ckt.dao.ExcelReportDaoImpl;
/*   7:    */ import com.bst.ckt.dao.ExcelReportDaoInf;
/*   8:    */ import com.bst.ckt.dto.Dealer;
/*   9:    */ import com.bst.ckt.exception.CreateFailedException;
/*  10:    */ import com.bst.ckt.exception.DeleteFailedException;
/*  11:    */ import com.bst.ckt.exception.RecordNotFoundException;
/*  12:    */ import com.bst.ckt.exception.UpdateFailedException;
/*  13:    */ import com.bst.ckt.vo.DealerVO;
/*  14:    */ import java.io.PrintStream;
/*  15:    */ import java.util.List;
/*  16:    */ import javax.servlet.http.HttpServletRequest;
/*  17:    */ import javax.servlet.http.HttpServletResponse;
/*  18:    */ import org.apache.log4j.Logger;
/*  19:    */ 
/*  20:    */ public class DealerServiceImpl
/*  21:    */   implements DealerServiceInf
/*  22:    */ {
/*  23: 31 */   private static final Logger logger = Logger.getLogger(DealerServiceImpl.class);
/*  24: 32 */   DealerDaoInf dealerDaoInf = null;
/*  25: 33 */   ExcelReportDaoInf excelReportDaoInf = new ExcelReportDaoImpl();
/*  26:    */   
/*  27:    */   public List<DealerVO> viewDealerTransactionDetailsGrid(DealerVO dealerVO)
/*  28:    */     throws RecordNotFoundException
/*  29:    */   {
/*  30: 39 */     this.dealerDaoInf = new DealerDaoImpl();
/*  31:    */     
/*  32: 41 */     return this.dealerDaoInf.viewDealerTransactionDetailsGrid(dealerVO);
/*  33:    */   }
/*  34:    */   
/*  35:    */   public String addDealerDetails(DealerVO dealerVO)
/*  36:    */     throws CreateFailedException
/*  37:    */   {
/*  38: 46 */     this.dealerDaoInf = new DealerDaoImpl();
/*  39: 47 */     this.dealerDaoInf.addDealerDetails(dealerVO);
/*  40: 48 */     return "SUCCESS";
/*  41:    */   }
/*  42:    */   
/*  43:    */   public List<DealerVO> retriveDealerDetailsGrid(DealerVO dealerVO)
/*  44:    */     throws RecordNotFoundException
/*  45:    */   {
/*  46: 54 */     this.dealerDaoInf = new DealerDaoImpl();
/*  47:    */     
/*  48: 56 */     return this.dealerDaoInf.retriveDealerDetailsGrid(dealerVO);
/*  49:    */   }
/*  50:    */   
/*  51:    */   public Dealer retriveSpecificDealerDetail(int dealerId)
/*  52:    */     throws RecordNotFoundException
/*  53:    */   {
/*  54: 61 */     Dealer dealer = null;
/*  55: 62 */     this.dealerDaoInf = new DealerDaoImpl();
/*  56: 63 */     dealer = this.dealerDaoInf.retriveSpecificDealerDetail(dealerId);
/*  57: 64 */     return dealer;
/*  58:    */   }
/*  59:    */   
/*  60:    */   public String deleteSpecificDealerDetails(int dealerId)
/*  61:    */     throws DeleteFailedException
/*  62:    */   {
/*  63: 69 */     this.dealerDaoInf = new DealerDaoImpl();
/*  64: 70 */     int effect = this.dealerDaoInf.deleteSpecificDealerDetails(dealerId);
/*  65: 71 */     if (effect == 1) {
/*  66: 72 */       return "SUCCESS";
/*  67:    */     }
/*  68: 74 */     return "ERROR";
/*  69:    */   }
/*  70:    */   
/*  71:    */   public Dealer retriveSpecificDealerDetailForEdit(int dealerId)
/*  72:    */     throws RecordNotFoundException
/*  73:    */   {
/*  74: 80 */     Dealer dealer = null;
/*  75: 81 */     this.dealerDaoInf = new DealerDaoImpl();
/*  76: 82 */     dealer = this.dealerDaoInf.retriveSpecificDealerDetailForEdit(dealerId);
/*  77: 83 */     return dealer;
/*  78:    */   }
/*  79:    */   
/*  80:    */   public void updateSpecificDealerRecord(DealerVO dealerVO, int dealerId)
/*  81:    */     throws UpdateFailedException
/*  82:    */   {
/*  83: 88 */     this.dealerDaoInf = new DealerDaoImpl();
/*  84: 89 */     this.dealerDaoInf.updateSpecificDealerRecord(dealerVO, dealerId);
/*  85:    */   }
/*  86:    */   
/*  87:    */   public Dealer retriveSpecificDealerTransaction(int dealerId)
/*  88:    */     throws RecordNotFoundException
/*  89:    */   {
/*  90: 94 */     Dealer dealer = null;
/*  91: 95 */     this.dealerDaoInf = new DealerDaoImpl();
/*  92: 96 */     dealer = this.dealerDaoInf.retriveSpecificDealerTransaction(dealerId);
/*  93: 97 */     System.out.println(dealer.getTotalDue() + "KKKKKKKKKKKKK");
/*  94: 98 */     return dealer;
/*  95:    */   }
/*  96:    */   
/*  97:    */   public String deleteSpecificDealerTransaction(int dealerId)
/*  98:    */     throws DeleteFailedException
/*  99:    */   {
/* 100:103 */     this.dealerDaoInf = new DealerDaoImpl();
/* 101:104 */     int effect = this.dealerDaoInf.deleteSpecificDealerTransaction(dealerId);
/* 102:105 */     if (effect == 1) {
/* 103:106 */       return "SUCCESS";
/* 104:    */     }
/* 105:108 */     return "ERROR";
/* 106:    */   }
/* 107:    */   
/* 108:    */   public void dealerTransactionPrintPDF(HttpServletRequest request, HttpServletResponse response, int transId)
/* 109:    */   {
/* 110:114 */     this.dealerDaoInf = new DealerDaoImpl();
/* 111:    */     
/* 112:116 */     this.dealerDaoInf.dealerTransactionPrintPDF(request, response, transId);
/* 113:    */   }
/* 114:    */   
/* 115:    */   public void dealerDetailPrintPDF(HttpServletRequest request, HttpServletResponse response, int dealerId)
/* 116:    */   {
/* 117:121 */     this.dealerDaoInf = new DealerDaoImpl();
/* 118:122 */     this.dealerDaoInf.dealerDetailPrintPDF(request, response, dealerId);
/* 119:123 */     System.out.println("XXXXXXXXXXXXXXX" + dealerId);
/* 120:    */   }
/* 121:    */   
/* 122:    */   public void dealerDetailExcelReport(HttpServletRequest request, HttpServletResponse response)
/* 123:    */   {
/* 124:128 */     this.excelReportDaoInf.dealerDetailExcelReport(request, response);
/* 125:    */   }
/* 126:    */   
/* 127:    */   public void dealerTransactionExcelReport(HttpServletRequest request, HttpServletResponse response)
/* 128:    */   {
/* 129:135 */     this.excelReportDaoInf.dealerTransactionExcelReport(request, response);
/* 130:    */   }
/* 131:    */   
/* 132:    */   public List<DealerVO> retriveDealerDetailsForAdvanceSearch(DealerVO dealerVO)
/* 133:    */     throws RecordNotFoundException
/* 134:    */   {
/* 135:140 */     this.dealerDaoInf = new DealerDaoImpl();
/* 136:141 */     int searchId = dealerVO.getSearchId();
/* 137:142 */     String searchValue = "";
/* 138:144 */     if (searchId == 1) {
/* 139:146 */       searchValue = String.valueOf(dealerVO.getDealerId());
/* 140:148 */     } else if (searchId == 2) {
/* 141:149 */       searchValue = dealerVO.getCity();
/* 142:150 */     } else if (searchId == 3) {
/* 143:151 */       searchValue = String.valueOf(dealerVO.getMobileNo());
/* 144:153 */     } else if (searchId == 4) {
/* 145:154 */       searchValue = String.valueOf(dealerVO.getState());
/* 146:    */     }
/* 147:156 */     return this.dealerDaoInf.retriveDealerDetailsForAdvanceSearch(searchId, searchValue);
/* 148:    */   }
/* 149:    */   
/* 150:    */   public List<DealerVO> viewDealerTransactionForSearch(DealerVO dealerVO)
/* 151:    */     throws RecordNotFoundException
/* 152:    */   {
/* 153:161 */     this.dealerDaoInf = new DealerDaoImpl();
/* 154:    */     
/* 155:163 */     int searchId = dealerVO.getSearchId();
/* 156:164 */     String searchValue = "";
/* 157:166 */     if (searchId == 1) {
/* 158:168 */       searchValue = String.valueOf(dealerVO.getTransactionId());
/* 159:170 */     } else if (searchId == 2) {
/* 160:171 */       searchValue = dealerVO.getDescription();
/* 161:173 */     } else if (searchId == 3) {
/* 162:174 */       searchValue = String.valueOf(dealerVO.getRetailerId());
/* 163:176 */     } else if (searchId == 4) {
/* 164:177 */       searchValue = String.valueOf(dealerVO.getPaymentMode());
/* 165:179 */     } else if (searchId == 5) {
/* 166:180 */       searchValue = String.valueOf(dealerVO.getTransactionDate());
/* 167:    */     }
/* 168:182 */     return this.dealerDaoInf.retriveDealerTransactionForAdvanceSearch(searchId, searchValue);
/* 169:    */   }
/* 170:    */   
/* 171:    */   public Dealer viewNextDealerDetails(int dealerId)
/* 172:    */     throws RecordNotFoundException
/* 173:    */   {
/* 174:187 */     this.dealerDaoInf = new DealerDaoImpl();
/* 175:188 */     Dealer dealer = null;
/* 176:    */     try
/* 177:    */     {
/* 178:190 */       dealerId++;
/* 179:191 */       if (this.dealerDaoInf.getDealerLastRecord() < dealerId)
/* 180:    */       {
/* 181:192 */         dealerId = 0;
/* 182:193 */         LoginUtil.setProcessUserId(dealerId);
/* 183:194 */         dealer = new Dealer();
/* 184:195 */         dealer.setDealerId(0);
/* 185:196 */         return dealer;
/* 186:    */       }
/* 187:198 */       LoginUtil.setProcessUserId(dealerId);
/* 188:199 */       dealer = this.dealerDaoInf.getDealerDetails(dealerId);
/* 189:200 */       if (dealer.getDealerId() == 0)
/* 190:    */       {
/* 191:201 */         dealerId = LoginUtil.getProcessUserId();
/* 192:202 */         LoginUtil.setProcessUserId(dealerId);
/* 193:203 */         return dealer;
/* 194:    */       }
/* 195:205 */       dealer = this.dealerDaoInf.getDealerDetails(dealerId);
/* 196:    */     }
/* 197:    */     catch (Exception exception)
/* 198:    */     {
/* 199:209 */       logger.error("no records found" + exception);
/* 200:    */     }
/* 201:211 */     return dealer;
/* 202:    */   }
/* 203:    */   
/* 204:    */   public Dealer viewPreviousDealerDetail(int dealerId)
/* 205:    */     throws RecordNotFoundException
/* 206:    */   {
/* 207:217 */     this.dealerDaoInf = new DealerDaoImpl();
/* 208:218 */     Dealer dealer = null;
/* 209:    */     try
/* 210:    */     {
/* 211:220 */       dealerId--;
/* 212:221 */       LoginUtil.setProcessUserId(dealerId);
/* 213:222 */       dealer = this.dealerDaoInf.getDealerDetails(dealerId);
/* 214:223 */       if (dealer.getDealerId() == 0)
/* 215:    */       {
/* 216:224 */         dealerId = LoginUtil.getProcessUserId();
/* 217:225 */         LoginUtil.setProcessUserId(dealerId);
/* 218:226 */         return dealer;
/* 219:    */       }
/* 220:228 */       dealer = this.dealerDaoInf.getDealerDetails(dealerId);
/* 221:    */     }
/* 222:    */     catch (Exception exception)
/* 223:    */     {
/* 224:231 */       logger.error("no records found" + exception);
/* 225:    */     }
/* 226:233 */     return dealer;
/* 227:    */   }
/* 228:    */   
/* 229:    */   public Dealer viewNextDealerTransaction(int transId)
/* 230:    */     throws RecordNotFoundException
/* 231:    */   {
/* 232:238 */     this.dealerDaoInf = new DealerDaoImpl();
/* 233:239 */     Dealer dealer = null;
/* 234:    */     try
/* 235:    */     {
/* 236:241 */       transId++;
/* 237:242 */       if (this.dealerDaoInf.getDealerTransactionLastRecord() < transId)
/* 238:    */       {
/* 239:243 */         transId = 0;
/* 240:244 */         LoginUtil.setProcessUserId(transId);
/* 241:245 */         dealer = new Dealer();
/* 242:246 */         dealer.setDealerId(0);
/* 243:247 */         return dealer;
/* 244:    */       }
/* 245:249 */       LoginUtil.setProcessUserId(transId);
/* 246:250 */       dealer = this.dealerDaoInf.getDealerTransaction(transId);
/* 247:251 */       if (dealer.getDealerId() == 0)
/* 248:    */       {
/* 249:252 */         transId = LoginUtil.getProcessUserId();
/* 250:253 */         LoginUtil.setProcessUserId(transId);
/* 251:254 */         return dealer;
/* 252:    */       }
/* 253:256 */       dealer = this.dealerDaoInf.getDealerTransaction(transId);
/* 254:    */     }
/* 255:    */     catch (Exception exception)
/* 256:    */     {
/* 257:260 */       logger.error("no records found" + exception);
/* 258:    */     }
/* 259:262 */     return dealer;
/* 260:    */   }
/* 261:    */   
/* 262:    */   public Dealer viewPreviousDealerTransaction(int transId)
/* 263:    */     throws RecordNotFoundException
/* 264:    */   {
/* 265:267 */     this.dealerDaoInf = new DealerDaoImpl();
/* 266:268 */     Dealer dealer = null;
/* 267:    */     try
/* 268:    */     {
/* 269:270 */       transId--;
/* 270:271 */       LoginUtil.setProcessUserId(transId);
/* 271:272 */       dealer = this.dealerDaoInf.getDealerTransaction(transId);
/* 272:273 */       if (dealer.getDealerId() == 0)
/* 273:    */       {
/* 274:274 */         transId = LoginUtil.getProcessUserId();
/* 275:275 */         LoginUtil.setProcessUserId(transId);
/* 276:276 */         return dealer;
/* 277:    */       }
/* 278:278 */       dealer = this.dealerDaoInf.getDealerTransaction(transId);
/* 279:    */     }
/* 280:    */     catch (Exception exception)
/* 281:    */     {
/* 282:281 */       logger.error("no records found" + exception);
/* 283:    */     }
/* 284:283 */     return dealer;
/* 285:    */   }
/* 286:    */   
/* 287:    */   public Dealer retrieveDealerTransactionByIdForPayDue(int transId)
/* 288:    */     throws RecordNotFoundException
/* 289:    */   {
/* 290:288 */     Dealer dealer = null;
/* 291:289 */     this.dealerDaoInf = new DealerDaoImpl();
/* 292:290 */     dealer = this.dealerDaoInf.retrieveDealerTransactionByIdForPayDue(transId);
/* 293:    */     
/* 294:292 */     return dealer;
/* 295:    */   }
/* 296:    */   
/* 297:    */   public void addPayDue(DealerVO dealerVO, int transId)
/* 298:    */     throws CreateFailedException
/* 299:    */   {
/* 300:297 */     this.dealerDaoInf = new DealerDaoImpl();
/* 301:298 */     this.dealerDaoInf.addPayDue(dealerVO, transId);
/* 302:    */   }
/* 303:    */ }


/* Location:           C:\Users\bharti\Desktop\Chouksay\lost\service\
 * Qualified Name:     com.bst.ckt.service.DealerServiceImpl
 * JD-Core Version:    0.7.0.1
 */