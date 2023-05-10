/*   1:    */ package com.bst.ckt.service;
/*   2:    */ 
/*   3:    */ import com.bst.ckt.common.LoginUtil;
/*   4:    */ import com.bst.ckt.dao.ExcelReportDaoImpl;
/*   5:    */ import com.bst.ckt.dao.ExcelReportDaoInf;
/*   6:    */ import com.bst.ckt.dao.RetailerCustomerDaoImpl;
/*   7:    */ import com.bst.ckt.dao.RetailerCustomerDaoInf;
/*   8:    */ import com.bst.ckt.dto.Retailer;
/*   9:    */ import com.bst.ckt.exception.CreateFailedException;
/*  10:    */ import com.bst.ckt.exception.DeleteFailedException;
/*  11:    */ import com.bst.ckt.exception.RecordNotFoundException;
/*  12:    */ import com.bst.ckt.exception.UpdateFailedException;
/*  13:    */ import com.bst.ckt.vo.RetailerCustomerVO;
/*  14:    */ import java.io.PrintStream;
/*  15:    */ import java.util.List;
/*  16:    */ import javax.servlet.http.HttpServletRequest;
/*  17:    */ import javax.servlet.http.HttpServletResponse;
/*  18:    */ import org.apache.log4j.Logger;
/*  19:    */ 
/*  20:    */ public class RetailerCustomerServiceImpl
/*  21:    */   implements RetailerCustomerServiceInf
/*  22:    */ {
/*  23: 33 */   private static final Logger logger = Logger.getLogger(RetailerCustomerServiceImpl.class);
/*  24: 34 */   RetailerCustomerDaoInf retailerCustomerDaoInf = null;
/*  25: 35 */   ExcelReportDaoInf excelReportDaoInf = new ExcelReportDaoImpl();
/*  26:    */   
/*  27:    */   public String addRetailerDetails(RetailerCustomerVO retailerCustomerVO)
/*  28:    */     throws CreateFailedException
/*  29:    */   {
/*  30: 41 */     this.retailerCustomerDaoInf = new RetailerCustomerDaoImpl();
/*  31: 42 */     this.retailerCustomerDaoInf.addRetailerDetails(retailerCustomerVO);
/*  32: 43 */     return "SUCCESS";
/*  33:    */   }
/*  34:    */   
/*  35:    */   public List<RetailerCustomerVO> retriveRetailerDetailsGrid(RetailerCustomerVO retailerCustomerVO)
/*  36:    */     throws RecordNotFoundException
/*  37:    */   {
/*  38: 52 */     this.retailerCustomerDaoInf = new RetailerCustomerDaoImpl();
/*  39:    */     
/*  40: 54 */     return this.retailerCustomerDaoInf.retriveRetailerDetailsGrid(retailerCustomerVO);
/*  41:    */   }
/*  42:    */   
/*  43:    */   public Retailer retriveSpecificRetailerDetail(int retailerId)
/*  44:    */     throws RecordNotFoundException
/*  45:    */   {
/*  46: 61 */     this.retailerCustomerDaoInf = new RetailerCustomerDaoImpl();
/*  47: 62 */     Retailer retailer = null;
/*  48:    */     
/*  49: 64 */     retailer = this.retailerCustomerDaoInf.retriveSpecificRetailerDetail(retailerId);
/*  50: 65 */     return retailer;
/*  51:    */   }
/*  52:    */   
/*  53:    */   public List<RetailerCustomerVO> retriveRetailerTransactionDetailsGrid(RetailerCustomerVO retailerCustomerVO)
/*  54:    */     throws RecordNotFoundException
/*  55:    */   {
/*  56: 73 */     this.retailerCustomerDaoInf = new RetailerCustomerDaoImpl();
/*  57:    */     
/*  58: 75 */     return this.retailerCustomerDaoInf.retriveRetailerTransactionDetailsGrid(retailerCustomerVO);
/*  59:    */   }
/*  60:    */   
/*  61:    */   public String deleteSpecificRetailerDetails(int custId)
/*  62:    */     throws DeleteFailedException
/*  63:    */   {
/*  64: 82 */     this.retailerCustomerDaoInf = new RetailerCustomerDaoImpl();
/*  65: 83 */     int effect = this.retailerCustomerDaoInf.deleteSpecificRetailerDetails(custId);
/*  66: 84 */     if (effect == 1) {
/*  67: 85 */       return "SUCCESS";
/*  68:    */     }
/*  69: 87 */     return "ERROR";
/*  70:    */   }
/*  71:    */   
/*  72:    */   public Retailer retriveSpecificRetailerDetailForEdit(int retailerId)
/*  73:    */     throws RecordNotFoundException
/*  74:    */   {
/*  75: 95 */     Retailer retailer = null;
/*  76: 96 */     this.retailerCustomerDaoInf = new RetailerCustomerDaoImpl();
/*  77: 97 */     retailer = this.retailerCustomerDaoInf.retriveSpecificRetailerDetailForEdit(retailerId);
/*  78: 98 */     return retailer;
/*  79:    */   }
/*  80:    */   
/*  81:    */   public void updateSpecificRetailerRecord(RetailerCustomerVO retailerCustomerVO, int retailerId)
/*  82:    */     throws UpdateFailedException
/*  83:    */   {
/*  84:105 */     this.retailerCustomerDaoInf = new RetailerCustomerDaoImpl();
/*  85:106 */     this.retailerCustomerDaoInf.updateSpecificRetailerRecord(retailerCustomerVO, retailerId);
/*  86:    */   }
/*  87:    */   
/*  88:    */   public Retailer retriveSpecificRetailerTransaction(int transId)
/*  89:    */     throws RecordNotFoundException
/*  90:    */   {
/*  91:114 */     Retailer retailer = null;
/*  92:115 */     this.retailerCustomerDaoInf = new RetailerCustomerDaoImpl();
/*  93:116 */     retailer = this.retailerCustomerDaoInf.retriveSpecificRetailerTransaction(transId);
/*  94:117 */     return retailer;
/*  95:    */   }
/*  96:    */   
/*  97:    */   public String deleteSpecificRetailerTransaction(int transId)
/*  98:    */     throws DeleteFailedException
/*  99:    */   {
/* 100:124 */     this.retailerCustomerDaoInf = new RetailerCustomerDaoImpl();
/* 101:125 */     int effect = this.retailerCustomerDaoInf.deleteSpecificRetailerTransaction(transId);
/* 102:126 */     if (effect == 1) {
/* 103:127 */       return "SUCCESS";
/* 104:    */     }
/* 105:129 */     return "ERROR";
/* 106:    */   }
/* 107:    */   
/* 108:    */   public void retailerTransactionPrintPDF(HttpServletRequest request, HttpServletResponse response, int transId)
/* 109:    */   {
/* 110:137 */     this.retailerCustomerDaoInf = new RetailerCustomerDaoImpl();
/* 111:138 */     this.retailerCustomerDaoInf.retailerTransactionPrintPDF(request, response, transId);
/* 112:    */   }
/* 113:    */   
/* 114:    */   public void retailerDetailPrintPDF(HttpServletRequest request, HttpServletResponse response, int dealerId)
/* 115:    */   {
/* 116:145 */     this.retailerCustomerDaoInf = new RetailerCustomerDaoImpl();
/* 117:146 */     this.retailerCustomerDaoInf.retailerDetailPrintPDF(request, response, dealerId);
/* 118:    */   }
/* 119:    */   
/* 120:    */   public void retailerDetailExcelReport(HttpServletRequest request, HttpServletResponse response)
/* 121:    */   {
/* 122:153 */     this.excelReportDaoInf.retailerDetailExcelReport(request, response);
/* 123:    */   }
/* 124:    */   
/* 125:    */   public void retailerTransactionExcelReport(HttpServletRequest request, HttpServletResponse response)
/* 126:    */   {
/* 127:161 */     this.excelReportDaoInf.retailerTransactionExcelReport(request, response);
/* 128:    */   }
/* 129:    */   
/* 130:    */   public List<RetailerCustomerVO> retriveRetailerDetailsForAdvanceSearch(RetailerCustomerVO retailerCustomerVO)
/* 131:    */     throws RecordNotFoundException
/* 132:    */   {
/* 133:170 */     this.retailerCustomerDaoInf = new RetailerCustomerDaoImpl();
/* 134:    */     
/* 135:172 */     int searchId = retailerCustomerVO.getSearchId();
/* 136:173 */     String searchValue = "";
/* 137:175 */     if (searchId == 1)
/* 138:    */     {
/* 139:177 */       searchValue = String.valueOf(retailerCustomerVO.getCustomerId());
/* 140:    */     }
/* 141:179 */     else if (searchId == 2)
/* 142:    */     {
/* 143:180 */       searchValue = retailerCustomerVO.getCity();
/* 144:181 */       System.out.println(searchValue + "KKKKKKKKKKKK");
/* 145:    */     }
/* 146:182 */     else if (searchId == 3)
/* 147:    */     {
/* 148:183 */       searchValue = String.valueOf(retailerCustomerVO.getMobileNo());
/* 149:    */     }
/* 150:185 */     else if (searchId == 4)
/* 151:    */     {
/* 152:186 */       searchValue = String.valueOf(retailerCustomerVO.getState());
/* 153:    */     }
/* 154:189 */     return this.retailerCustomerDaoInf.retriveRetailerDetailsForAdvanceSearch(searchId, searchValue);
/* 155:    */   }
/* 156:    */   
/* 157:    */   public List<RetailerCustomerVO> retriveRetailerTransactionForAdvanceSearch(RetailerCustomerVO retailerCustomerVO)
/* 158:    */     throws RecordNotFoundException
/* 159:    */   {
/* 160:197 */     this.retailerCustomerDaoInf = new RetailerCustomerDaoImpl();
/* 161:    */     
/* 162:199 */     int searchId = retailerCustomerVO.getSearchId();
/* 163:200 */     String searchValue = "";
/* 164:202 */     if (searchId == 1) {
/* 165:204 */       searchValue = String.valueOf(retailerCustomerVO.getTransactionId());
/* 166:206 */     } else if (searchId == 2) {
/* 167:207 */       searchValue = retailerCustomerVO.getDescription();
/* 168:209 */     } else if (searchId == 3) {
/* 169:210 */       searchValue = String.valueOf(retailerCustomerVO.getRetailerId());
/* 170:212 */     } else if (searchId == 4) {
/* 171:213 */       searchValue = String.valueOf(retailerCustomerVO.getPaymentMode());
/* 172:214 */     } else if (searchId == 5) {
/* 173:215 */       searchValue = String.valueOf(retailerCustomerVO.getTransactionDate());
/* 174:    */     }
/* 175:218 */     return this.retailerCustomerDaoInf.retriveRetailerTransactionForAdvanceSearch(searchId, searchValue);
/* 176:    */   }
/* 177:    */   
/* 178:    */   public Retailer viewNextRetailerDetail(int retailerId)
/* 179:    */     throws RecordNotFoundException
/* 180:    */   {
/* 181:225 */     this.retailerCustomerDaoInf = new RetailerCustomerDaoImpl();
/* 182:    */     
/* 183:227 */     Retailer retailer = null;
/* 184:    */     try
/* 185:    */     {
/* 186:229 */       retailerId++;
/* 187:230 */       if (this.retailerCustomerDaoInf.getRetailerLastRecord() < retailerId)
/* 188:    */       {
/* 189:231 */         retailerId = 0;
/* 190:232 */         LoginUtil.setProcessUserId(retailerId);
/* 191:233 */         retailer = new Retailer();
/* 192:234 */         retailer.setRetailerId(0);
/* 193:235 */         return retailer;
/* 194:    */       }
/* 195:237 */       LoginUtil.setProcessUserId(retailerId);
/* 196:238 */       retailer = this.retailerCustomerDaoInf.getRetailerDetails(retailerId);
/* 197:239 */       if (retailer.getRetailerId() == 0)
/* 198:    */       {
/* 199:240 */         retailerId = LoginUtil.getProcessUserId();
/* 200:241 */         LoginUtil.setProcessUserId(retailerId);
/* 201:242 */         return retailer;
/* 202:    */       }
/* 203:244 */       retailer = this.retailerCustomerDaoInf.getRetailerDetails(retailerId);
/* 204:    */     }
/* 205:    */     catch (Exception exception)
/* 206:    */     {
/* 207:248 */       logger.error("no records found" + exception);
/* 208:    */     }
/* 209:250 */     return retailer;
/* 210:    */   }
/* 211:    */   
/* 212:    */   public Retailer viewPreviousRetailerDetail(int retailerId)
/* 213:    */     throws RecordNotFoundException
/* 214:    */   {
/* 215:257 */     this.retailerCustomerDaoInf = new RetailerCustomerDaoImpl();
/* 216:258 */     Retailer retailer = null;
/* 217:    */     try
/* 218:    */     {
/* 219:260 */       retailerId--;
/* 220:261 */       LoginUtil.setProcessUserId(retailerId);
/* 221:262 */       retailer = this.retailerCustomerDaoInf.getRetailerDetails(retailerId);
/* 222:263 */       if (retailer.getCustomerId() == 0)
/* 223:    */       {
/* 224:264 */         retailerId = LoginUtil.getProcessUserId();
/* 225:265 */         LoginUtil.setProcessUserId(retailerId);
/* 226:266 */         return retailer;
/* 227:    */       }
/* 228:268 */       retailer = this.retailerCustomerDaoInf.getRetailerDetails(retailerId);
/* 229:    */     }
/* 230:    */     catch (Exception exception)
/* 231:    */     {
/* 232:271 */       logger.error("no records found" + exception);
/* 233:    */     }
/* 234:273 */     return retailer;
/* 235:    */   }
/* 236:    */   
/* 237:    */   public Retailer viewNextRetailerTransaction(int transId)
/* 238:    */     throws RecordNotFoundException
/* 239:    */   {
/* 240:281 */     this.retailerCustomerDaoInf = new RetailerCustomerDaoImpl();
/* 241:    */     
/* 242:283 */     Retailer retailer = null;
/* 243:    */     try
/* 244:    */     {
/* 245:285 */       transId++;
/* 246:286 */       if (this.retailerCustomerDaoInf.getRetailerTransactionLastRecord() < transId)
/* 247:    */       {
/* 248:287 */         transId = 0;
/* 249:288 */         LoginUtil.setProcessUserId(transId);
/* 250:289 */         retailer = new Retailer();
/* 251:290 */         retailer.setTransactionId(0);
/* 252:291 */         return retailer;
/* 253:    */       }
/* 254:293 */       LoginUtil.setProcessUserId(transId);
/* 255:294 */       retailer = this.retailerCustomerDaoInf.getRetailerTransaction(transId);
/* 256:295 */       if (retailer.getTransactionId() == 0)
/* 257:    */       {
/* 258:296 */         transId = LoginUtil.getProcessUserId();
/* 259:297 */         LoginUtil.setProcessUserId(transId);
/* 260:298 */         return retailer;
/* 261:    */       }
/* 262:300 */       retailer = this.retailerCustomerDaoInf.getRetailerTransaction(transId);
/* 263:    */     }
/* 264:    */     catch (Exception exception)
/* 265:    */     {
/* 266:304 */       logger.error("no records found" + exception);
/* 267:    */     }
/* 268:306 */     return retailer;
/* 269:    */   }
/* 270:    */   
/* 271:    */   public Retailer viewPreviousRetailerTransaction(int transId)
/* 272:    */     throws RecordNotFoundException
/* 273:    */   {
/* 274:313 */     this.retailerCustomerDaoInf = new RetailerCustomerDaoImpl();
/* 275:314 */     Retailer retailer = null;
/* 276:    */     try
/* 277:    */     {
/* 278:316 */       transId--;
/* 279:317 */       LoginUtil.setProcessUserId(transId);
/* 280:318 */       retailer = this.retailerCustomerDaoInf.getRetailerTransaction(transId);
/* 281:319 */       if (retailer.getTransactionId() == 0)
/* 282:    */       {
/* 283:320 */         transId = LoginUtil.getProcessUserId();
/* 284:321 */         LoginUtil.setProcessUserId(transId);
/* 285:322 */         return retailer;
/* 286:    */       }
/* 287:324 */       retailer = this.retailerCustomerDaoInf.getRetailerTransaction(transId);
/* 288:    */     }
/* 289:    */     catch (Exception exception)
/* 290:    */     {
/* 291:327 */       logger.error("no records found" + exception);
/* 292:    */     }
/* 293:329 */     return retailer;
/* 294:    */   }
/* 295:    */   
/* 296:    */   public Retailer retrieveRetailerTransactionByIdForPayDue(int transId)
/* 297:    */     throws RecordNotFoundException
/* 298:    */   {
/* 299:336 */     Retailer retailer = null;
/* 300:337 */     this.retailerCustomerDaoInf = new RetailerCustomerDaoImpl();
/* 301:338 */     retailer = this.retailerCustomerDaoInf.retrieveReailerTransactionByIdForPayDue(transId);
/* 302:    */     
/* 303:340 */     return retailer;
/* 304:    */   }
/* 305:    */   
/* 306:    */   public void addPayDue(RetailerCustomerVO retailerCustomerVO, int transId)
/* 307:    */     throws RecordNotFoundException
/* 308:    */   {
/* 309:347 */     this.retailerCustomerDaoInf = new RetailerCustomerDaoImpl();
/* 310:348 */     this.retailerCustomerDaoInf.addPayDue(retailerCustomerVO, transId);
/* 311:    */   }
/* 312:    */ }


/* Location:           C:\Users\bharti\Desktop\Chouksay\lost\service\
 * Qualified Name:     com.bst.ckt.service.RetailerCustomerServiceImpl
 * JD-Core Version:    0.7.0.1
 */