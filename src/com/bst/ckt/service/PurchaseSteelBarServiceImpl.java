/*   1:    */ package com.bst.ckt.service;
/*   2:    */ 
/*   3:    */ import com.bst.ckt.common.LoginUtil;
/*   4:    */ import com.bst.ckt.dao.ExcelReportDaoImpl;
/*   5:    */ import com.bst.ckt.dao.ExcelReportDaoInf;
/*   6:    */ import com.bst.ckt.dao.PurchaseSteelBarDaoImpl;
/*   7:    */ import com.bst.ckt.dao.PurchaseSteelBarDaoInf;
/*   8:    */ import com.bst.ckt.dto.PurchaseSteelbar;
/*   9:    */ import com.bst.ckt.exception.CreateFailedException;
/*  10:    */ import com.bst.ckt.exception.DeleteFailedException;
/*  11:    */ import com.bst.ckt.exception.RecordNotFoundException;
/*  12:    */ import com.bst.ckt.exception.UpdateFailedException;
/*  13:    */ import com.bst.ckt.vo.PurchaseSteelBarVO;
/*  14:    */ import java.util.List;
/*  15:    */ import javax.servlet.http.HttpServletRequest;
/*  16:    */ import javax.servlet.http.HttpServletResponse;
/*  17:    */ import org.apache.log4j.Logger;
/*  18:    */ 
/*  19:    */ public class PurchaseSteelBarServiceImpl
/*  20:    */   implements PurchaseSteelBarServiceInf
/*  21:    */ {
/*  22: 28 */   private static final Logger logger = Logger.getLogger(PurchaseSteelBarServiceImpl.class);
/*  23: 30 */   PurchaseSteelBarDaoInf purchaseSteelBarDaoInf = null;
/*  24: 31 */   ExcelReportDaoInf excelReportDaoInf = new ExcelReportDaoImpl();
/*  25:    */   
/*  26:    */   public void insertPurchaseSteelBarsDetails(PurchaseSteelBarVO purchaseSteelBarVO)
/*  27:    */     throws CreateFailedException
/*  28:    */   {
/*  29: 36 */     int checks = 0;
/*  30: 37 */     this.purchaseSteelBarDaoInf = new PurchaseSteelBarDaoImpl();
/*  31:    */     
/*  32: 39 */     int output = this.purchaseSteelBarDaoInf.insertPurchaseSteelBarsDetails(purchaseSteelBarVO);
/*  33: 40 */     if (output == 1)
/*  34:    */     {
/*  35:    */       try
/*  36:    */       {
/*  37: 43 */         checks = this.purchaseSteelBarDaoInf.isItemAlreadyExistInStock(purchaseSteelBarVO.getInconterm());
/*  38:    */       }
/*  39:    */       catch (RecordNotFoundException e)
/*  40:    */       {
/*  41: 45 */         logger.error(PurchaseSteelBarServiceImpl.class + "ERROR: while fetching stock details from database", e);
/*  42:    */       }
/*  43: 47 */       if (checks != 0) {
/*  44:    */         try
/*  45:    */         {
/*  46: 49 */           this.purchaseSteelBarDaoInf.updateStockDetails(purchaseSteelBarVO, checks);
/*  47:    */         }
/*  48:    */         catch (UpdateFailedException e)
/*  49:    */         {
/*  50: 51 */           logger.error(PurchaseSteelBarServiceImpl.class + "ERROR: while updating stock details", e);
/*  51:    */         }
/*  52:    */       } else {
/*  53: 54 */         this.purchaseSteelBarDaoInf.insertStockDetails(purchaseSteelBarVO);
/*  54:    */       }
/*  55:    */     }
/*  56:    */   }
/*  57:    */   
/*  58:    */   public List<PurchaseSteelBarVO> retrivePurchaseSteelBarDetailsGrid(PurchaseSteelBarVO purchaseSteelBarVO)
/*  59:    */     throws RecordNotFoundException
/*  60:    */   {
/*  61: 63 */     this.purchaseSteelBarDaoInf = new PurchaseSteelBarDaoImpl();
/*  62: 64 */     return this.purchaseSteelBarDaoInf.retrivePurchaseSteelBarDetailsGrid(purchaseSteelBarVO);
/*  63:    */   }
/*  64:    */   
/*  65:    */   public PurchaseSteelbar retriveSpecificPurchaseSteelBarDetail(int purchaseId)
/*  66:    */     throws RecordNotFoundException
/*  67:    */   {
/*  68: 70 */     PurchaseSteelbar purchaseSteelbar = null;
/*  69: 71 */     this.purchaseSteelBarDaoInf = new PurchaseSteelBarDaoImpl();
/*  70: 72 */     purchaseSteelbar = this.purchaseSteelBarDaoInf.retriveSpecificPurchaseSteelBarDetail(purchaseId);
/*  71: 73 */     return purchaseSteelbar;
/*  72:    */   }
/*  73:    */   
/*  74:    */   public String deleteSpecificSteelbarPurchaseDetails(int purchaseId)
/*  75:    */     throws DeleteFailedException
/*  76:    */   {
/*  77: 79 */     this.purchaseSteelBarDaoInf = new PurchaseSteelBarDaoImpl();
/*  78: 80 */     int effect = this.purchaseSteelBarDaoInf.deleteSpecificSteelbarPurchaseDetails(purchaseId);
/*  79: 81 */     if (effect == 1) {
/*  80: 82 */       return "SUCCESS";
/*  81:    */     }
/*  82: 84 */     return "ERROR";
/*  83:    */   }
/*  84:    */   
/*  85:    */   public void updateSpecificPurchaseRecord(PurchaseSteelBarVO purchaseSteelBarVO, int purchaseId)
/*  86:    */     throws UpdateFailedException
/*  87:    */   {
/*  88: 92 */     this.purchaseSteelBarDaoInf = new PurchaseSteelBarDaoImpl();
/*  89: 93 */     this.purchaseSteelBarDaoInf.updateSpecificPurchaseRecord(purchaseSteelBarVO, purchaseId);
/*  90:    */   }
/*  91:    */   
/*  92:    */   public PurchaseSteelbar retrivePurchaseSteelbarDetailsForEdit(int purchaseId)
/*  93:    */     throws RecordNotFoundException
/*  94:    */   {
/*  95: 99 */     PurchaseSteelbar purchaseSteelbar = null;
/*  96:100 */     this.purchaseSteelBarDaoInf = new PurchaseSteelBarDaoImpl();
/*  97:101 */     purchaseSteelbar = this.purchaseSteelBarDaoInf.retriveSpecificPurchaseDetailForUpdate(purchaseId);
/*  98:102 */     return purchaseSteelbar;
/*  99:    */   }
/* 100:    */   
/* 101:    */   public void purchasePDF(HttpServletRequest request, HttpServletResponse response, int purchaseId)
/* 102:    */   {
/* 103:108 */     this.purchaseSteelBarDaoInf = new PurchaseSteelBarDaoImpl();
/* 104:109 */     this.purchaseSteelBarDaoInf.purchasePDF(request, response, purchaseId);
/* 105:    */   }
/* 106:    */   
/* 107:    */   public void purchaseSteelBarExcelReport(HttpServletRequest request, HttpServletResponse response)
/* 108:    */   {
/* 109:115 */     this.excelReportDaoInf.purchaseSteelBarExcelReport(request, response);
/* 110:    */   }
/* 111:    */   
/* 112:    */   public List<PurchaseSteelBarVO> retrivePurchaseSteelBarDetailsForSearch(PurchaseSteelBarVO purchaseSteelBarVO)
/* 113:    */   {
/* 114:122 */     this.purchaseSteelBarDaoInf = new PurchaseSteelBarDaoImpl();
/* 115:123 */     int searchId = purchaseSteelBarVO.getSearchId();
/* 116:124 */     String searchValue = "";
/* 117:126 */     if (searchId == 1) {
/* 118:128 */       searchValue = String.valueOf(purchaseSteelBarVO.getPurchaseId());
/* 119:130 */     } else if (searchId == 2) {
/* 120:131 */       searchValue = purchaseSteelBarVO.getCompanyName();
/* 121:132 */     } else if (searchId == 3) {
/* 122:133 */       searchValue = String.valueOf(purchaseSteelBarVO.getInvoiceNo());
/* 123:135 */     } else if (searchId == 4) {
/* 124:136 */       searchValue = String.valueOf(purchaseSteelBarVO.getMaterialCode());
/* 125:139 */     } else if (searchId == 5) {
/* 126:140 */       searchValue = String.valueOf(purchaseSteelBarVO.getDealerName());
/* 127:143 */     } else if (searchId == 6) {
/* 128:144 */       searchValue = String.valueOf(purchaseSteelBarVO.getInvoiceDate());
/* 129:    */     }
/* 130:147 */     return this.purchaseSteelBarDaoInf.retrivePurchaseSteelBarDetailsForSearch(searchId, searchValue);
/* 131:    */   }
/* 132:    */   
/* 133:    */   public PurchaseSteelbar viewNextPurchaseSteelbarDetails(int purchaseId)
/* 134:    */     throws RecordNotFoundException
/* 135:    */   {
/* 136:153 */     this.purchaseSteelBarDaoInf = new PurchaseSteelBarDaoImpl();
/* 137:154 */     PurchaseSteelbar purchaseSteelbar = null;
/* 138:    */     try
/* 139:    */     {
/* 140:156 */       purchaseId++;
/* 141:157 */       if (this.purchaseSteelBarDaoInf.getPurchaseSteelbarLastRecord() < purchaseId)
/* 142:    */       {
/* 143:158 */         purchaseId = 0;
/* 144:159 */         LoginUtil.setProcessUserId(purchaseId);
/* 145:160 */         purchaseSteelbar = new PurchaseSteelbar();
/* 146:161 */         purchaseSteelbar.setPurchaseId(0);
/* 147:162 */         return purchaseSteelbar;
/* 148:    */       }
/* 149:164 */       LoginUtil.setProcessUserId(purchaseId);
/* 150:165 */       purchaseSteelbar = this.purchaseSteelBarDaoInf.getPurchaseSteelbarDetails(purchaseId);
/* 151:166 */       if (purchaseSteelbar.getPurchaseId() == 0)
/* 152:    */       {
/* 153:167 */         purchaseId = LoginUtil.getProcessUserId();
/* 154:168 */         LoginUtil.setProcessUserId(purchaseId);
/* 155:169 */         return purchaseSteelbar;
/* 156:    */       }
/* 157:171 */       purchaseSteelbar = this.purchaseSteelBarDaoInf.getPurchaseSteelbarDetails(purchaseId);
/* 158:    */     }
/* 159:    */     catch (Exception exception)
/* 160:    */     {
/* 161:175 */       logger.error("no records found" + exception);
/* 162:    */     }
/* 163:177 */     return purchaseSteelbar;
/* 164:    */   }
/* 165:    */   
/* 166:    */   public PurchaseSteelbar viewPreviousPurchaseCement(int purchaseId)
/* 167:    */     throws RecordNotFoundException
/* 168:    */   {
/* 169:183 */     this.purchaseSteelBarDaoInf = new PurchaseSteelBarDaoImpl();
/* 170:184 */     PurchaseSteelbar purchaseSteelbar = null;
/* 171:    */     try
/* 172:    */     {
/* 173:186 */       purchaseId--;
/* 174:187 */       LoginUtil.setProcessUserId(purchaseId);
/* 175:188 */       purchaseSteelbar = this.purchaseSteelBarDaoInf.getPurchaseSteelbarDetails(purchaseId);
/* 176:189 */       if (purchaseSteelbar.getPurchaseId() == 0)
/* 177:    */       {
/* 178:190 */         purchaseId = LoginUtil.getProcessUserId();
/* 179:191 */         LoginUtil.setProcessUserId(purchaseId);
/* 180:192 */         return purchaseSteelbar;
/* 181:    */       }
/* 182:194 */       purchaseSteelbar = this.purchaseSteelBarDaoInf.getPurchaseSteelbarDetails(purchaseId);
/* 183:    */     }
/* 184:    */     catch (Exception exception)
/* 185:    */     {
/* 186:197 */       logger.error("no records found" + exception);
/* 187:    */     }
/* 188:199 */     return purchaseSteelbar;
/* 189:    */   }
/* 190:    */   
/* 191:    */   public List<PurchaseSteelBarVO> viewSteelbarStockGrid()
/* 192:    */     throws RecordNotFoundException
/* 193:    */   {
/* 194:205 */     this.purchaseSteelBarDaoInf = new PurchaseSteelBarDaoImpl();
/* 195:206 */     return this.purchaseSteelBarDaoInf.viewSteelbarStockGrid();
/* 196:    */   }
/* 197:    */   
/* 198:    */   public void insertIntoLedger(PurchaseSteelBarVO purchaseSteelBarVO)
/* 199:    */     throws CreateFailedException
/* 200:    */   {
/* 201:212 */     this.purchaseSteelBarDaoInf = new PurchaseSteelBarDaoImpl();
/* 202:213 */     this.purchaseSteelBarDaoInf.insertIntoLedger(purchaseSteelBarVO);
/* 203:    */   }
/* 204:    */ }


/* Location:           C:\Users\bharti\Desktop\Chouksay\lost\service\
 * Qualified Name:     com.bst.ckt.service.PurchaseSteelBarServiceImpl
 * JD-Core Version:    0.7.0.1
 */