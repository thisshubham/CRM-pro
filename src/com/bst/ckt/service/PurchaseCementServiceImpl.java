/*   1:    */ package com.bst.ckt.service;
/*   2:    */ 
/*   3:    */ import com.bst.ckt.common.LoginUtil;
/*   4:    */ import com.bst.ckt.dao.ExcelReportDaoImpl;
/*   5:    */ import com.bst.ckt.dao.ExcelReportDaoInf;
/*   6:    */ import com.bst.ckt.dao.PurchaseCementDaoImpl;
/*   7:    */ import com.bst.ckt.dao.PurchaseCementDaoInf;
/*   8:    */ import com.bst.ckt.dto.PurchaseCement;
/*   9:    */ import com.bst.ckt.exception.CreateFailedException;
/*  10:    */ import com.bst.ckt.exception.DeleteFailedException;
/*  11:    */ import com.bst.ckt.exception.RecordNotFoundException;
/*  12:    */ import com.bst.ckt.exception.UpdateFailedException;
/*  13:    */ import com.bst.ckt.vo.PurchaseCementVO;
/*  14:    */ import java.util.List;
/*  15:    */ import javax.servlet.http.HttpServletRequest;
/*  16:    */ import javax.servlet.http.HttpServletResponse;
/*  17:    */ import org.apache.log4j.Logger;
/*  18:    */ 
/*  19:    */ public class PurchaseCementServiceImpl
/*  20:    */   implements PurchaseCementServiceInf
/*  21:    */ {
/*  22: 30 */   private static final Logger logger = Logger.getLogger(PurchaseCementServiceImpl.class);
/*  23: 32 */   PurchaseCementDaoInf purchaseCementDaoInf = null;
/*  24: 33 */   ExcelReportDaoInf excelReportDaoInf = new ExcelReportDaoImpl();
/*  25:    */   
/*  26:    */   public void insertPurchaseCementDetails(PurchaseCementVO purchaseCementVO)
/*  27:    */     throws CreateFailedException
/*  28:    */   {
/*  29: 38 */     int checks = 0;
/*  30: 39 */     this.purchaseCementDaoInf = new PurchaseCementDaoImpl();
/*  31: 40 */     int output = this.purchaseCementDaoInf.insertPurchaseCementDetails(purchaseCementVO);
/*  32: 41 */     if (output == 1)
/*  33:    */     {
/*  34:    */       try
/*  35:    */       {
/*  36: 44 */         checks = this.purchaseCementDaoInf.isItemAlreadyExistInStock(purchaseCementVO.getInconterm());
/*  37:    */       }
/*  38:    */       catch (RecordNotFoundException e)
/*  39:    */       {
/*  40: 46 */         logger.error(PurchaseCementServiceImpl.class + "ERROR: while fetching stock details from database", e);
/*  41:    */       }
/*  42: 48 */       if (checks != 0) {
/*  43:    */         try
/*  44:    */         {
/*  45: 50 */           this.purchaseCementDaoInf.updateStockDetails(purchaseCementVO, checks);
/*  46:    */         }
/*  47:    */         catch (UpdateFailedException e)
/*  48:    */         {
/*  49: 52 */           logger.error(PurchaseCementServiceImpl.class + "ERROR: while updating stock details", e);
/*  50:    */         }
/*  51:    */       } else {
/*  52: 55 */         this.purchaseCementDaoInf.insertStockDetails(purchaseCementVO);
/*  53:    */       }
/*  54:    */     }
/*  55:    */   }
/*  56:    */   
/*  57:    */   public List<PurchaseCementVO> retrivePurchaseCementDetailsGrid(PurchaseCementVO purchaseCementVO)
/*  58:    */     throws RecordNotFoundException
/*  59:    */   {
/*  60: 63 */     this.purchaseCementDaoInf = new PurchaseCementDaoImpl();
/*  61:    */     
/*  62: 65 */     int searchId = purchaseCementVO.getSearchId();
/*  63: 66 */     String searchValue = "";
/*  64: 68 */     if (searchId == 1) {
/*  65: 70 */       searchValue = String.valueOf(purchaseCementVO.getPurchaseId());
/*  66: 72 */     } else if (searchId == 2) {
/*  67: 73 */       searchValue = purchaseCementVO.getCompanyName();
/*  68: 74 */     } else if (searchId == 3) {
/*  69: 75 */       searchValue = String.valueOf(purchaseCementVO.getInvoiceNo());
/*  70: 77 */     } else if (searchId == 4) {
/*  71: 78 */       searchValue = String.valueOf(purchaseCementVO.getMaterialCode());
/*  72: 80 */     } else if (searchId == 5) {
/*  73: 81 */       searchValue = String.valueOf(purchaseCementVO.getDealerName());
/*  74: 83 */     } else if (searchId == 6) {
/*  75: 84 */       searchValue = String.valueOf(purchaseCementVO.getInvoiceDate());
/*  76:    */     }
/*  77: 87 */     return this.purchaseCementDaoInf.retrivePurchaseCementDetailsGrid(searchId, searchValue);
/*  78:    */   }
/*  79:    */   
/*  80:    */   public PurchaseCement retriveSpecificPurchaseCementDetail(int purchaseId)
/*  81:    */     throws RecordNotFoundException
/*  82:    */   {
/*  83: 92 */     PurchaseCement purchaseCement = null;
/*  84: 93 */     this.purchaseCementDaoInf = new PurchaseCementDaoImpl();
/*  85: 94 */     purchaseCement = this.purchaseCementDaoInf.retriveSpecificPurchaseCementDetail(purchaseId);
/*  86: 95 */     return purchaseCement;
/*  87:    */   }
/*  88:    */   
/*  89:    */   public String deleteSpecificCementPurchaseDetails(int purchaseId)
/*  90:    */     throws DeleteFailedException
/*  91:    */   {
/*  92:100 */     this.purchaseCementDaoInf = new PurchaseCementDaoImpl();
/*  93:101 */     int effect = this.purchaseCementDaoInf.deleteSpecificCementPurchaseDetails(purchaseId);
/*  94:102 */     if (effect == 1) {
/*  95:103 */       return "SUCCESS";
/*  96:    */     }
/*  97:105 */     return "ERROR";
/*  98:    */   }
/*  99:    */   
/* 100:    */   public PurchaseCement retriveSpecificPurchaseDetailForUpdate(int purchaseId)
/* 101:    */     throws RecordNotFoundException
/* 102:    */   {
/* 103:111 */     PurchaseCement purchaseCement = null;
/* 104:112 */     this.purchaseCementDaoInf = new PurchaseCementDaoImpl();
/* 105:113 */     purchaseCement = this.purchaseCementDaoInf.retriveSpecificPurchaseDetailForUpdate(purchaseId);
/* 106:114 */     return purchaseCement;
/* 107:    */   }
/* 108:    */   
/* 109:    */   public void updateSpecificPurchaseRecord(PurchaseCementVO purchaseCementVO, int purchaseId, int transactionId)
/* 110:    */     throws UpdateFailedException
/* 111:    */   {
/* 112:119 */     this.purchaseCementDaoInf = new PurchaseCementDaoImpl();
/* 113:120 */     this.purchaseCementDaoInf.updateSpecificPurchaseRecord(purchaseCementVO, purchaseId, transactionId);
/* 114:    */   }
/* 115:    */   
/* 116:    */   public void purchasePDF(HttpServletRequest request, HttpServletResponse response, int purchaseId)
/* 117:    */   {
/* 118:125 */     this.purchaseCementDaoInf = new PurchaseCementDaoImpl();
/* 119:126 */     this.purchaseCementDaoInf.purchasePDF(request, response, purchaseId);
/* 120:    */   }
/* 121:    */   
/* 122:    */   public void purchaseCementExcelReport(HttpServletRequest request, HttpServletResponse response)
/* 123:    */     throws Exception
/* 124:    */   {
	try {
/* 125:132 */     this.excelReportDaoInf.purchaseCementExcelReport(request, response);
logger.info(PurchaseCementServiceImpl.class+"we r in purchase service................1111");
	}catch(Exception ex) {
		logger.error(PurchaseCementServiceImpl.class+"ERROR while creating excel", ex);
	}
/* 126:    */   }
/* 127:    */   
/* 128:    */   public List<PurchaseCementVO> fetchPurchaseCementList()
/* 129:    */     throws RecordNotFoundException
/* 130:    */   {
/* 131:136 */     this.purchaseCementDaoInf = new PurchaseCementDaoImpl();
/* 132:137 */     return this.purchaseCementDaoInf.fetchPurchaseCementList();
/* 133:    */   }
/* 134:    */   
/* 135:    */   public PurchaseCement viewNextPurchaseCementDetails(int purchaseId)
/* 136:    */     throws RecordNotFoundException
/* 137:    */   {
/* 138:142 */     this.purchaseCementDaoInf = new PurchaseCementDaoImpl();
/* 139:143 */     PurchaseCement purchaseCement = null;
/* 140:    */     try
/* 141:    */     {
/* 142:145 */       purchaseId++;
/* 143:146 */       if (this.purchaseCementDaoInf.getPurchaseCementLastRecord() < purchaseId)
/* 144:    */       {
/* 145:147 */         purchaseId = 0;
/* 146:148 */         LoginUtil.setProcessUserId(purchaseId);
/* 147:149 */         purchaseCement = new PurchaseCement();
/* 148:150 */         purchaseCement.setPurchaseId(0);
/* 149:151 */         return purchaseCement;
/* 150:    */       }
/* 151:153 */       LoginUtil.setProcessUserId(purchaseId);
/* 152:154 */       purchaseCement = this.purchaseCementDaoInf.getPurchaseCementDetails(purchaseId);
/* 153:155 */       if (purchaseCement.getPurchaseId() == 0)
/* 154:    */       {
/* 155:156 */         purchaseId = LoginUtil.getProcessUserId();
/* 156:157 */         LoginUtil.setProcessUserId(purchaseId);
/* 157:158 */         return purchaseCement;
/* 158:    */       }
/* 159:160 */       purchaseCement = this.purchaseCementDaoInf.getPurchaseCementDetails(purchaseId);
/* 160:    */     }
/* 161:    */     catch (Exception exception)
/* 162:    */     {
/* 163:164 */       logger.error("no records found" + exception);
/* 164:    */     }
/* 165:166 */     return purchaseCement;
/* 166:    */   }
/* 167:    */   
/* 168:    */   public PurchaseCement viewPreviousPurchaseCement(int purchaseId)
/* 169:    */     throws RecordNotFoundException
/* 170:    */   {
/* 171:171 */     this.purchaseCementDaoInf = new PurchaseCementDaoImpl();
/* 172:172 */     PurchaseCement purchaseCement = null;
/* 173:    */     try
/* 174:    */     {
/* 175:174 */       purchaseId--;
/* 176:175 */       LoginUtil.setProcessUserId(purchaseId);
/* 177:176 */       purchaseCement = this.purchaseCementDaoInf.getPurchaseCementDetails(purchaseId);
/* 178:177 */       if (purchaseCement.getPurchaseId() == 0)
/* 179:    */       {
/* 180:178 */         purchaseId = LoginUtil.getProcessUserId();
/* 181:179 */         LoginUtil.setProcessUserId(purchaseId);
/* 182:180 */         return purchaseCement;
/* 183:    */       }
/* 184:182 */       purchaseCement = this.purchaseCementDaoInf.getPurchaseCementDetails(purchaseId);
/* 185:    */     }
/* 186:    */     catch (Exception exception)
/* 187:    */     {
/* 188:185 */       logger.error("no records found" + exception);
/* 189:    */     }
/* 190:187 */     return purchaseCement;
/* 191:    */   }
/* 192:    */   
/* 193:    */   public List<PurchaseCementVO> viewCementStockGrid()
/* 194:    */     throws RecordNotFoundException
/* 195:    */   {
/* 196:192 */     this.purchaseCementDaoInf = new PurchaseCementDaoImpl();
/* 197:193 */     return this.purchaseCementDaoInf.viewCementStockGrid();
/* 198:    */   }
/* 199:    */   
/* 200:    */   public void insertIntoLedger(PurchaseCementVO purchaseCementVO)
/* 201:    */     throws CreateFailedException
/* 202:    */   {
/* 203:198 */     this.purchaseCementDaoInf = new PurchaseCementDaoImpl();
/* 204:199 */     this.purchaseCementDaoInf.insertIntoLedger(purchaseCementVO);
/* 205:    */   }
/* 206:    */ }


/* Location:           C:\Users\bharti\Desktop\Chouksay\lost\service\
 * Qualified Name:     com.bst.ckt.service.PurchaseCementServiceImpl
 * JD-Core Version:    0.7.0.1
 */