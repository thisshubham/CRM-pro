/*   1:    */ package com.bst.ckt.service;
/*   2:    */ 
/*   3:    */ import com.bst.ckt.common.LoginUtil;
/*   4:    */ import com.bst.ckt.dao.PurchasePesticidesDaoImpl;
/*   5:    */ import com.bst.ckt.dao.PurchasePesticidesDaoInf;
/*   6:    */ import com.bst.ckt.dto.Pesticides;
/*   7:    */ import com.bst.ckt.exception.CreateFailedException;
/*   8:    */ import com.bst.ckt.exception.DeleteFailedException;
/*   9:    */ import com.bst.ckt.exception.RecordNotFoundException;
/*  10:    */ import com.bst.ckt.exception.UpdateFailedException;
/*  11:    */ import com.bst.ckt.vo.PurchasePesticidesVO;
/*  12:    */ import java.util.List;
/*  13:    */ import javax.servlet.http.HttpServletRequest;
/*  14:    */ import javax.servlet.http.HttpServletResponse;
/*  15:    */ import org.apache.log4j.Logger;
/*  16:    */ 
/*  17:    */ public class PurchasePesticidesServiceImpl
/*  18:    */   implements PurchasePesticidesServiceInf
/*  19:    */ {
/*  20: 27 */   private static final Logger logger = Logger.getLogger(PurchasePesticidesServiceImpl.class);
/*  21: 28 */   PurchasePesticidesDaoInf purchasePesticidesDaoInf = null;
/*  22:    */   
/*  23:    */   public void addPurchasePesticides(PurchasePesticidesVO purchasePesticidesVO)
/*  24:    */     throws CreateFailedException
/*  25:    */   {
/*  26: 33 */     int checks = 0;
/*  27: 34 */     this.purchasePesticidesDaoInf = new PurchasePesticidesDaoImpl();
/*  28: 35 */     int output = this.purchasePesticidesDaoInf.addPurchasePesticides(purchasePesticidesVO);
/*  29: 36 */     if (output == 1)
/*  30:    */     {
/*  31:    */       try
/*  32:    */       {
/*  33: 39 */         checks = this.purchasePesticidesDaoInf.isItemAlreadyExistInStock(purchasePesticidesVO.getInconterm());
/*  34:    */       }
/*  35:    */       catch (RecordNotFoundException e)
/*  36:    */       {
/*  37: 41 */         logger.error(PurchaseWallPaintServiceImpl.class + "ERROR: while fetching stock details from database", e);
/*  38:    */       }
/*  39: 43 */       if (checks != 0) {
/*  40:    */         try
/*  41:    */         {
/*  42: 45 */           this.purchasePesticidesDaoInf.updateStockDetails(purchasePesticidesVO, checks);
/*  43:    */         }
/*  44:    */         catch (UpdateFailedException e)
/*  45:    */         {
/*  46: 47 */           logger.error(PurchaseWallPaintServiceImpl.class + "ERROR: while updating stock details.", e);
/*  47:    */         }
/*  48:    */       } else {
/*  49: 50 */         this.purchasePesticidesDaoInf.insertStockDetails(purchasePesticidesVO);
/*  50:    */       }
/*  51:    */     }
/*  52:    */   }
/*  53:    */   
/*  54:    */   public List<PurchasePesticidesVO> getPurchasePesticidesDetails()
/*  55:    */     throws RecordNotFoundException
/*  56:    */   {
/*  57: 58 */     this.purchasePesticidesDaoInf = new PurchasePesticidesDaoImpl();
/*  58: 59 */     return this.purchasePesticidesDaoInf.getPurchasePesticidesDetails();
/*  59:    */   }
/*  60:    */   
/*  61:    */   public Pesticides retriveSpecificPurchaseDetailForUpdate(int purchaseId)
/*  62:    */     throws RecordNotFoundException
/*  63:    */   {
/*  64: 65 */     Pesticides pesticides = null;
/*  65: 66 */     this.purchasePesticidesDaoInf = new PurchasePesticidesDaoImpl();
/*  66: 67 */     pesticides = this.purchasePesticidesDaoInf.retriveSpecificPurchaseDetailForUpdate(purchaseId);
/*  67: 68 */     return pesticides;
/*  68:    */   }
/*  69:    */   
/*  70:    */   public void updateSpecificPurchaseRecord(PurchasePesticidesVO purchasePesticidesVO, int purchaseId, int transactionId)
/*  71:    */     throws UpdateFailedException
/*  72:    */   {
/*  73: 75 */     this.purchasePesticidesDaoInf = new PurchasePesticidesDaoImpl();
/*  74: 76 */     this.purchasePesticidesDaoInf.updateSpecificPurchaseRecord(purchasePesticidesVO, purchaseId, transactionId);
/*  75:    */   }
/*  76:    */   
/*  77:    */   public String deleteSpecificPesticidePurchaseDetails(int purchaseId)
/*  78:    */     throws DeleteFailedException
/*  79:    */   {
/*  80: 82 */     this.purchasePesticidesDaoInf = new PurchasePesticidesDaoImpl();
/*  81:    */     
/*  82:    */ 
/*  83: 85 */     int effect = this.purchasePesticidesDaoInf.deleteSpecificPesticidePurchaseDetails(purchaseId);
/*  84: 86 */     if (effect == 1) {
/*  85: 87 */       return "SUCCESS";
/*  86:    */     }
/*  87: 89 */     return "ERROR";
/*  88:    */   }
/*  89:    */   
/*  90:    */   public Pesticides retrivedPesticidesDetails(int purchaseId)
/*  91:    */     throws RecordNotFoundException
/*  92:    */   {
/*  93: 98 */     Pesticides pesticides = null;
/*  94: 99 */     this.purchasePesticidesDaoInf = new PurchasePesticidesDaoImpl();
/*  95:100 */     pesticides = this.purchasePesticidesDaoInf.retrivedPesticidesDetails(purchaseId);
/*  96:101 */     return pesticides;
/*  97:    */   }
/*  98:    */   
/*  99:    */   public List<PurchasePesticidesVO> getPurchasePesticidesDetailsForAdvanceSearch(PurchasePesticidesVO purchasePesticidesVO)
/* 100:    */     throws RecordNotFoundException
/* 101:    */   {
/* 102:107 */     this.purchasePesticidesDaoInf = new PurchasePesticidesDaoImpl();
/* 103:    */     
/* 104:109 */     int searchId = purchasePesticidesVO.getSearchId();
/* 105:110 */     String searchValue = "";
/* 106:112 */     if (searchId == 1) {
/* 107:114 */       searchValue = String.valueOf(purchasePesticidesVO.getPurchaseId());
/* 108:116 */     } else if (searchId == 2) {
/* 109:117 */       searchValue = purchasePesticidesVO.getCompanyName();
/* 110:118 */     } else if (searchId == 3) {
/* 111:119 */       searchValue = String.valueOf(purchasePesticidesVO.getInvoiceNo());
/* 112:121 */     } else if (searchId == 4) {
/* 113:122 */       searchValue = String.valueOf(purchasePesticidesVO.getMaterialCode());
/* 114:124 */     } else if (searchId == 5) {
/* 115:125 */       searchValue = String.valueOf(purchasePesticidesVO.getDealerName());
/* 116:127 */     } else if (searchId == 6) {
/* 117:128 */       searchValue = String.valueOf(purchasePesticidesVO.getInvoiceDate());
/* 118:    */     }
/* 119:131 */     return this.purchasePesticidesDaoInf.getPurchasePesticidesDetailsForAdvanceSearch(searchId, searchValue);
/* 120:    */   }
/* 121:    */   
/* 122:    */   public Pesticides viewNextPurchasePesticideDetail(int purchaseId)
/* 123:    */     throws RecordNotFoundException
/* 124:    */   {
/* 125:138 */     this.purchasePesticidesDaoInf = new PurchasePesticidesDaoImpl();
/* 126:139 */     Pesticides pesticides = null;
/* 127:    */     try
/* 128:    */     {
/* 129:141 */       purchaseId++;
/* 130:142 */       if (this.purchasePesticidesDaoInf.getPurchasePesticideLastRecord() < purchaseId)
/* 131:    */       {
/* 132:143 */         purchaseId = 0;
/* 133:144 */         LoginUtil.setProcessUserId(purchaseId);
/* 134:145 */         pesticides = new Pesticides();
/* 135:146 */         pesticides.setPurchaseId(0);
/* 136:147 */         return pesticides;
/* 137:    */       }
/* 138:149 */       LoginUtil.setProcessUserId(purchaseId);
/* 139:150 */       pesticides = this.purchasePesticidesDaoInf.getPurchasePesticideDetails(purchaseId);
/* 140:151 */       if (pesticides.getPurchaseId() == 0)
/* 141:    */       {
/* 142:152 */         purchaseId = LoginUtil.getProcessUserId();
/* 143:153 */         LoginUtil.setProcessUserId(purchaseId);
/* 144:154 */         return pesticides;
/* 145:    */       }
/* 146:156 */       pesticides = this.purchasePesticidesDaoInf.getPurchasePesticideDetails(purchaseId);
/* 147:    */     }
/* 148:    */     catch (Exception exception)
/* 149:    */     {
/* 150:160 */       logger.error("no records found" + exception);
/* 151:    */     }
/* 152:162 */     return pesticides;
/* 153:    */   }
/* 154:    */   
/* 155:    */   public Pesticides viewPreviousPurchasePesticide(int purchaseId)
/* 156:    */     throws RecordNotFoundException
/* 157:    */   {
/* 158:170 */     this.purchasePesticidesDaoInf = new PurchasePesticidesDaoImpl();
/* 159:171 */     Pesticides pesticides = null;
/* 160:    */     try
/* 161:    */     {
/* 162:173 */       purchaseId--;
/* 163:174 */       LoginUtil.setProcessUserId(purchaseId);
/* 164:175 */       pesticides = this.purchasePesticidesDaoInf.getPurchasePesticideDetails(purchaseId);
/* 165:176 */       if (pesticides.getPurchaseId() == 0)
/* 166:    */       {
/* 167:177 */         purchaseId = LoginUtil.getProcessUserId();
/* 168:178 */         LoginUtil.setProcessUserId(purchaseId);
/* 169:179 */         return pesticides;
/* 170:    */       }
/* 171:181 */       pesticides = this.purchasePesticidesDaoInf.getPurchasePesticideDetails(purchaseId);
/* 172:    */     }
/* 173:    */     catch (Exception exception)
/* 174:    */     {
/* 175:184 */       logger.error("no records found" + exception);
/* 176:    */     }
/* 177:186 */     return pesticides;
/* 178:    */   }
/* 179:    */   
/* 180:    */   public void purchasePrintPDF(HttpServletRequest request, HttpServletResponse response, int purchaseId)
/* 181:    */   {
/* 182:193 */     this.purchasePesticidesDaoInf = new PurchasePesticidesDaoImpl();
/* 183:194 */     this.purchasePesticidesDaoInf.purchasePrintPDF(request, response, purchaseId);
/* 184:    */   }
/* 185:    */ }


/* Location:           C:\Users\bharti\Desktop\Chouksay\lost\service\
 * Qualified Name:     com.bst.ckt.service.PurchasePesticidesServiceImpl
 * JD-Core Version:    0.7.0.1
 */