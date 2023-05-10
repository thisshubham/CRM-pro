/*   1:    */ package com.bst.ckt.service;
/*   2:    */ 
/*   3:    */ import com.bst.ckt.common.LoginUtil;
/*   4:    */ import com.bst.ckt.dao.ConsumerCustomerDaoImpl;
/*   5:    */ import com.bst.ckt.dao.ConsumerCustomerDaoInf;
/*   6:    */ import com.bst.ckt.dao.ExcelReportDaoImpl;
/*   7:    */ import com.bst.ckt.dao.ExcelReportDaoInf;
/*   8:    */ import com.bst.ckt.dto.Consumer;
/*   9:    */ import com.bst.ckt.exception.CreateFailedException;
/*  10:    */ import com.bst.ckt.exception.DeleteFailedException;
/*  11:    */ import com.bst.ckt.exception.RecordNotFoundException;
/*  12:    */ import com.bst.ckt.exception.UpdateFailedException;
/*  13:    */ import com.bst.ckt.vo.ConsumerCustomerVO;
/*  14:    */ import java.io.PrintStream;
/*  15:    */ import java.util.List;
/*  16:    */ import javax.servlet.http.HttpServletRequest;
/*  17:    */ import javax.servlet.http.HttpServletResponse;
/*  18:    */ import org.apache.log4j.Logger;
/*  19:    */ 
/*  20:    */ public class ConsumerCustomerServiceImpl
/*  21:    */   implements ConsumerCustomerServiceInf
/*  22:    */ {
/*  23: 31 */   private static final Logger logger = Logger.getLogger(ConsumerCustomerServiceImpl.class);
/*  24: 33 */   ConsumerCustomerDaoInf consumerCustomerDaoInf = null;
/*  25: 34 */   ExcelReportDaoInf excelReportDaoInf = new ExcelReportDaoImpl();
/*  26:    */   
/*  27:    */   public String addConsumerDetails(ConsumerCustomerVO consumerCustomerVO)
/*  28:    */     throws CreateFailedException
/*  29:    */   {
/*  30: 39 */     this.consumerCustomerDaoInf = new ConsumerCustomerDaoImpl();
/*  31: 40 */     this.consumerCustomerDaoInf.addConsumerDetails(consumerCustomerVO);
/*  32: 41 */     return "SUCCESS";
/*  33:    */   }
/*  34:    */   
/*  35:    */   public List<ConsumerCustomerVO> retriveConsumerDetailsGrid(ConsumerCustomerVO consumerCustomerVO)
/*  36:    */     throws RecordNotFoundException
/*  37:    */   {
/*  38: 47 */     this.consumerCustomerDaoInf = new ConsumerCustomerDaoImpl();
/*  39: 48 */     return this.consumerCustomerDaoInf.retriveConsumerDetailsGrid(consumerCustomerVO);
/*  40:    */   }
/*  41:    */   
/*  42:    */   public Consumer retriveSpecificConsumerDetail(int consumerId)
/*  43:    */     throws RecordNotFoundException
/*  44:    */   {
/*  45: 53 */     this.consumerCustomerDaoInf = new ConsumerCustomerDaoImpl();
/*  46: 54 */     Consumer consumer = null;
/*  47:    */     
/*  48: 56 */     consumer = this.consumerCustomerDaoInf.retriveSpecificConsumerDetail(consumerId);
/*  49: 57 */     return consumer;
/*  50:    */   }
/*  51:    */   
/*  52:    */   public List<ConsumerCustomerVO> retriveConsumerTransactionDetailsGrid(ConsumerCustomerVO consumerCustomerVO)
/*  53:    */     throws RecordNotFoundException
/*  54:    */   {
/*  55: 63 */     this.consumerCustomerDaoInf = new ConsumerCustomerDaoImpl();
/*  56: 64 */     return this.consumerCustomerDaoInf.retriveConsumerTransactionDetailsGrid(consumerCustomerVO);
/*  57:    */   }
/*  58:    */   
/*  59:    */   public String deleteSpecificConsumerDetails(int custId)
/*  60:    */     throws DeleteFailedException
/*  61:    */   {
/*  62: 69 */     this.consumerCustomerDaoInf = new ConsumerCustomerDaoImpl();
/*  63: 70 */     int effect = this.consumerCustomerDaoInf.deleteSpecificConsumerDetails(custId);
/*  64: 71 */     if (effect == 1) {
/*  65: 72 */       return "SUCCESS";
/*  66:    */     }
/*  67: 74 */     return "ERROR";
/*  68:    */   }
/*  69:    */   
/*  70:    */   public Consumer retriveSpecificConsumerDetailForEdit(int consumerId)
/*  71:    */     throws RecordNotFoundException
/*  72:    */   {
/*  73: 80 */     Consumer consumer = null;
/*  74: 81 */     this.consumerCustomerDaoInf = new ConsumerCustomerDaoImpl();
/*  75: 82 */     consumer = this.consumerCustomerDaoInf.retriveSpecificConsumerDetailForEdit(consumerId);
/*  76: 83 */     return consumer;
/*  77:    */   }
/*  78:    */   
/*  79:    */   public void updateSpecificConsumerRecord(ConsumerCustomerVO consumerCustomerVO, int consumerId)
/*  80:    */     throws UpdateFailedException
/*  81:    */   {
/*  82: 89 */     this.consumerCustomerDaoInf = new ConsumerCustomerDaoImpl();
/*  83: 90 */     this.consumerCustomerDaoInf.updateSpecificConsumerRecord(consumerCustomerVO, consumerId);
/*  84:    */   }
/*  85:    */   
/*  86:    */   public Consumer retriveSpecificConsumerTransaction(int transId)
/*  87:    */     throws RecordNotFoundException
/*  88:    */   {
/*  89: 95 */     this.consumerCustomerDaoInf = new ConsumerCustomerDaoImpl();
/*  90: 96 */     Consumer consumer = null;
/*  91:    */     
/*  92: 98 */     consumer = this.consumerCustomerDaoInf.retriveSpecificConsumerTransaction(transId);
/*  93: 99 */     return consumer;
/*  94:    */   }
/*  95:    */   
/*  96:    */   public String deleteSpecificConsumerTransaction(int transId)
/*  97:    */     throws DeleteFailedException
/*  98:    */   {
/*  99:104 */     this.consumerCustomerDaoInf = new ConsumerCustomerDaoImpl();
/* 100:105 */     int effect = this.consumerCustomerDaoInf.deleteSpecificConsumerTransaction(transId);
/* 101:106 */     if (effect == 1) {
/* 102:107 */       return "SUCCESS";
/* 103:    */     }
/* 104:109 */     return "ERROR";
/* 105:    */   }
/* 106:    */   
/* 107:    */   public void consumerTransactionPrintPDF(HttpServletRequest request, HttpServletResponse response, int transId)
/* 108:    */   {
/* 109:115 */     this.consumerCustomerDaoInf = new ConsumerCustomerDaoImpl();
/* 110:116 */     this.consumerCustomerDaoInf.consumerTransactionPrintPDF(request, response, transId);
/* 111:    */   }
/* 112:    */   
/* 113:    */   public void consumerDetailsPrintPDF(HttpServletRequest request, HttpServletResponse response, int transId)
/* 114:    */   {
/* 115:121 */     this.consumerCustomerDaoInf = new ConsumerCustomerDaoImpl();
/* 116:122 */     this.consumerCustomerDaoInf.consumerDetailsPrintPDF(request, response, transId);
/* 117:    */   }
/* 118:    */   
/* 119:    */   public void consumerDetailExcelReport(HttpServletRequest request, HttpServletResponse response)
/* 120:    */   {
/* 121:128 */     this.excelReportDaoInf.consumerDetailExcelReport(request, response);
/* 122:    */   }
/* 123:    */   
/* 124:    */   public void consumerTransactionExcelReport(HttpServletRequest request, HttpServletResponse response)
/* 125:    */   {
/* 126:134 */     this.excelReportDaoInf.consumerTransactionExcelReport(request, response);
/* 127:    */   }
/* 128:    */   
/* 129:    */   public List<ConsumerCustomerVO> retriveConsumerDetailsForAdvanceSearch(ConsumerCustomerVO consumerCustomerVO)
/* 130:    */     throws RecordNotFoundException
/* 131:    */   {
/* 132:141 */     this.consumerCustomerDaoInf = new ConsumerCustomerDaoImpl();
/* 133:142 */     int searchId = consumerCustomerVO.getSearchId();
/* 134:143 */     String searchValue = "";
/* 135:145 */     if (searchId == 1)
/* 136:    */     {
/* 137:147 */       searchValue = String.valueOf(consumerCustomerVO.getCustomerId());
/* 138:    */     }
/* 139:149 */     else if (searchId == 2)
/* 140:    */     {
/* 141:150 */       searchValue = consumerCustomerVO.getCity();
/* 142:151 */       System.out.println(searchValue + "KKKKKKKKKKKK");
/* 143:    */     }
/* 144:152 */     else if (searchId == 3)
/* 145:    */     {
/* 146:153 */       searchValue = String.valueOf(consumerCustomerVO.getMobileNo());
/* 147:    */     }
/* 148:155 */     else if (searchId == 4)
/* 149:    */     {
/* 150:156 */       searchValue = String.valueOf(consumerCustomerVO.getState());
/* 151:    */     }
/* 152:158 */     return this.consumerCustomerDaoInf.retriveConsumerDetailsForAdvanceSearch(searchId, searchValue);
/* 153:    */   }
/* 154:    */   
/* 155:    */   public List<ConsumerCustomerVO> retriveConsumerTransactionForAdvanceSearch(ConsumerCustomerVO consumerCustomerVO)
/* 156:    */     throws RecordNotFoundException
/* 157:    */   {
/* 158:164 */     this.consumerCustomerDaoInf = new ConsumerCustomerDaoImpl();
/* 159:165 */     int searchId = consumerCustomerVO.getSearchId();
/* 160:166 */     String searchValue = "";
/* 161:168 */     if (searchId == 1) {
/* 162:170 */       searchValue = String.valueOf(consumerCustomerVO.getTransactionId());
/* 163:172 */     } else if (searchId == 2) {
/* 164:173 */       searchValue = consumerCustomerVO.getDescription();
/* 165:175 */     } else if (searchId == 3) {
/* 166:176 */       searchValue = String.valueOf(consumerCustomerVO.getRetailerId());
/* 167:178 */     } else if (searchId == 4) {
/* 168:179 */       searchValue = String.valueOf(consumerCustomerVO.getPaymentMode());
/* 169:180 */     } else if (searchId == 5) {
/* 170:181 */       searchValue = String.valueOf(consumerCustomerVO.getTransactionDate());
/* 171:    */     }
/* 172:183 */     System.out.println(searchId + "searchId" + searchValue + "searchValue");
/* 173:184 */     return this.consumerCustomerDaoInf.retriveConsumerTransactionForAdvanceSearch(searchId, searchValue);
/* 174:    */   }
/* 175:    */   
/* 176:    */   public Consumer viewNextConsumerDetail(int consumerId)
/* 177:    */     throws RecordNotFoundException
/* 178:    */   {
/* 179:189 */     this.consumerCustomerDaoInf = new ConsumerCustomerDaoImpl();
/* 180:    */     
/* 181:191 */     Consumer consumer = null;
/* 182:    */     try
/* 183:    */     {
/* 184:193 */       consumerId++;
/* 185:194 */       if (this.consumerCustomerDaoInf.getConsumerLastRecord() < consumerId)
/* 186:    */       {
/* 187:195 */         consumerId = 0;
/* 188:196 */         LoginUtil.setProcessUserId(consumerId);
/* 189:197 */         consumer = new Consumer();
/* 190:198 */         consumer.setCustomerId(0);
/* 191:199 */         return consumer;
/* 192:    */       }
/* 193:201 */       LoginUtil.setProcessUserId(consumerId);
/* 194:202 */       consumer = this.consumerCustomerDaoInf.getConsumerDetails(consumerId);
/* 195:203 */       if (consumer.getCustomerId() == 0)
/* 196:    */       {
/* 197:204 */         consumerId = LoginUtil.getProcessUserId();
/* 198:205 */         LoginUtil.setProcessUserId(consumerId);
/* 199:206 */         return consumer;
/* 200:    */       }
/* 201:208 */       consumer = this.consumerCustomerDaoInf.getConsumerDetails(consumerId);
/* 202:    */     }
/* 203:    */     catch (Exception exception)
/* 204:    */     {
/* 205:212 */       logger.error("no records found" + exception);
/* 206:    */     }
/* 207:214 */     return consumer;
/* 208:    */   }
/* 209:    */   
/* 210:    */   public Consumer viewPreviousConsumerDetail(int consumerId)
/* 211:    */     throws RecordNotFoundException
/* 212:    */   {
/* 213:219 */     this.consumerCustomerDaoInf = new ConsumerCustomerDaoImpl();
/* 214:220 */     Consumer consumer = null;
/* 215:    */     try
/* 216:    */     {
/* 217:222 */       consumerId--;
/* 218:223 */       LoginUtil.setProcessUserId(consumerId);
/* 219:224 */       consumer = this.consumerCustomerDaoInf.getConsumerDetails(consumerId);
/* 220:225 */       if (consumer.getCustomerId() == 0)
/* 221:    */       {
/* 222:226 */         consumerId = LoginUtil.getProcessUserId();
/* 223:227 */         LoginUtil.setProcessUserId(consumerId);
/* 224:228 */         return consumer;
/* 225:    */       }
/* 226:230 */       consumer = this.consumerCustomerDaoInf.getConsumerDetails(consumerId);
/* 227:    */     }
/* 228:    */     catch (Exception exception)
/* 229:    */     {
/* 230:233 */       logger.error("no records found" + exception);
/* 231:    */     }
/* 232:235 */     return consumer;
/* 233:    */   }
/* 234:    */   
/* 235:    */   public Consumer viewNextConsumerTransaction(int transId)
/* 236:    */     throws RecordNotFoundException
/* 237:    */   {
/* 238:240 */     this.consumerCustomerDaoInf = new ConsumerCustomerDaoImpl();
/* 239:    */     
/* 240:242 */     Consumer consumer = null;
/* 241:    */     try
/* 242:    */     {
/* 243:244 */       transId++;
/* 244:245 */       if (this.consumerCustomerDaoInf.getConsumerTransactionLastRecord() < transId)
/* 245:    */       {
/* 246:246 */         transId = 0;
/* 247:247 */         LoginUtil.setProcessUserId(transId);
/* 248:248 */         consumer = new Consumer();
/* 249:249 */         consumer.setTransactionId(0);
/* 250:250 */         return consumer;
/* 251:    */       }
/* 252:252 */       LoginUtil.setProcessUserId(transId);
/* 253:253 */       consumer = this.consumerCustomerDaoInf.getConsumerTransaction(transId);
/* 254:254 */       if (consumer.getTransactionId() == 0)
/* 255:    */       {
/* 256:255 */         transId = LoginUtil.getProcessUserId();
/* 257:256 */         LoginUtil.setProcessUserId(transId);
/* 258:257 */         return consumer;
/* 259:    */       }
/* 260:259 */       consumer = this.consumerCustomerDaoInf.getConsumerTransaction(transId);
/* 261:    */     }
/* 262:    */     catch (Exception exception)
/* 263:    */     {
/* 264:263 */       logger.error("no records found" + exception);
/* 265:    */     }
/* 266:265 */     return consumer;
/* 267:    */   }
/* 268:    */   
/* 269:    */   public Consumer viewPreviousConsumerTransaction(int transId)
/* 270:    */     throws RecordNotFoundException
/* 271:    */   {
/* 272:270 */     this.consumerCustomerDaoInf = new ConsumerCustomerDaoImpl();
/* 273:271 */     Consumer consumer = null;
/* 274:    */     try
/* 275:    */     {
/* 276:273 */       transId--;
/* 277:274 */       LoginUtil.setProcessUserId(transId);
/* 278:275 */       consumer = this.consumerCustomerDaoInf.getConsumerTransaction(transId);
/* 279:276 */       if (consumer.getTransactionId() == 0)
/* 280:    */       {
/* 281:277 */         transId = LoginUtil.getProcessUserId();
/* 282:278 */         LoginUtil.setProcessUserId(transId);
/* 283:279 */         return consumer;
/* 284:    */       }
/* 285:281 */       consumer = this.consumerCustomerDaoInf.getConsumerTransaction(transId);
/* 286:    */     }
/* 287:    */     catch (Exception exception)
/* 288:    */     {
/* 289:284 */       logger.error("no records found" + exception);
/* 290:    */     }
/* 291:286 */     return consumer;
/* 292:    */   }
/* 293:    */   
/* 294:    */   public Consumer retrieveConsumerTransactionByIdForPayDue(int transId)
/* 295:    */     throws RecordNotFoundException
/* 296:    */   {
/* 297:291 */     Consumer consumer = null;
/* 298:292 */     this.consumerCustomerDaoInf = new ConsumerCustomerDaoImpl();
/* 299:293 */     consumer = this.consumerCustomerDaoInf.retrieveConsumerTransactionByIdForPayDue(transId);
/* 300:    */     
/* 301:295 */     return consumer;
/* 302:    */   }
/* 303:    */   
/* 304:    */   public void addPayDue(ConsumerCustomerVO consumerCustomerVO, int transId)
/* 305:    */     throws RecordNotFoundException
/* 306:    */   {
/* 307:300 */     this.consumerCustomerDaoInf = new ConsumerCustomerDaoImpl();
/* 308:301 */     this.consumerCustomerDaoInf.addPayDue(consumerCustomerVO, transId);
/* 309:    */   }
/* 310:    */ }


/* Location:           C:\Users\bharti\Desktop\Chouksay\lost\service\
 * Qualified Name:     com.bst.ckt.service.ConsumerCustomerServiceImpl
 * JD-Core Version:    0.7.0.1
 */