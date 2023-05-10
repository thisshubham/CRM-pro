/*   1:    */ package com.bst.ckt.service;
/*   2:    */ 
/*   3:    */ import com.bst.ckt.common.LoginUtil;
/*   4:    */ import com.bst.ckt.dao.PurchaseWallPaintDaoImpl;
/*   5:    */ import com.bst.ckt.dao.PurchaseWallPaintDaoInf;
/*   6:    */ import com.bst.ckt.dto.WallPaint;
/*   7:    */ import com.bst.ckt.exception.CreateFailedException;
/*   8:    */ import com.bst.ckt.exception.RecordNotFoundException;
/*   9:    */ import com.bst.ckt.exception.UpdateFailedException;
/*  10:    */ import com.bst.ckt.vo.PurchaseWallPaintVO;
/*  11:    */ import java.io.PrintStream;
/*  12:    */ import java.util.List;
/*  13:    */ import javax.servlet.http.HttpServletRequest;
/*  14:    */ import javax.servlet.http.HttpServletResponse;
/*  15:    */ import org.apache.log4j.Logger;
/*  16:    */ 
/*  17:    */ public class PurchaseWallPaintServiceImpl
/*  18:    */   implements PurchaseWallPaintServiceInf
/*  19:    */ {
/*  20: 25 */   private static final Logger logger = Logger.getLogger(PurchaseWallPaintServiceImpl.class);
/*  21:    */   PurchaseWallPaintDaoInf purchaseWallPaintDaoInf;
/*  22:    */   
/*  23:    */   public void addPurchaseWallPaint(PurchaseWallPaintVO purchaseWallPaintVO)
/*  24:    */     throws CreateFailedException
/*  25:    */   {
/*  26: 31 */     int checks = 0;
/*  27: 32 */     this.purchaseWallPaintDaoInf = new PurchaseWallPaintDaoImpl();
/*  28: 33 */     int output = this.purchaseWallPaintDaoInf.addPurchaseWallPaint(purchaseWallPaintVO);
/*  29: 34 */     if (output == 1)
/*  30:    */     {
/*  31:    */       try
/*  32:    */       {
/*  33: 37 */         checks = this.purchaseWallPaintDaoInf.isItemAlreadyExistInStock(purchaseWallPaintVO.getInconterm());
/*  34:    */       }
/*  35:    */       catch (RecordNotFoundException e)
/*  36:    */       {
/*  37: 39 */         logger.error(PurchaseWallPaintServiceImpl.class + "ERROR: while fetching stock details from database", e);
/*  38:    */       }
/*  39: 41 */       if (checks != 0) {
/*  40:    */         try
/*  41:    */         {
/*  42: 43 */           this.purchaseWallPaintDaoInf.updateStockDetails(purchaseWallPaintVO, checks);
/*  43:    */         }
/*  44:    */         catch (UpdateFailedException e)
/*  45:    */         {
/*  46: 45 */           logger.error(PurchaseWallPaintServiceImpl.class + "ERROR: while updating stock details.", e);
/*  47:    */         }
/*  48:    */       } else {
/*  49: 48 */         this.purchaseWallPaintDaoInf.insertStockDetails(purchaseWallPaintVO);
/*  50:    */       }
/*  51:    */     }
/*  52:    */   }
/*  53:    */   
/*  54:    */   public List<PurchaseWallPaintVO> fetchPurchaseWallPaintList()
/*  55:    */     throws RecordNotFoundException
/*  56:    */   {
/*  57: 56 */     this.purchaseWallPaintDaoInf = new PurchaseWallPaintDaoImpl();
/*  58: 57 */     return this.purchaseWallPaintDaoInf.fetchPurchaseWallPaintList();
/*  59:    */   }
/*  60:    */   
/*  61:    */   public WallPaint retriveSpecificPurchaseDetailForUpdate(int purchaseId)
/*  62:    */     throws RecordNotFoundException
/*  63:    */   {
/*  64: 63 */     WallPaint wallPaint = null;
/*  65: 64 */     this.purchaseWallPaintDaoInf = new PurchaseWallPaintDaoImpl();
/*  66: 65 */     wallPaint = this.purchaseWallPaintDaoInf.retriveSpecificPurchaseDetailForUpdate(purchaseId);
/*  67: 66 */     return wallPaint;
/*  68:    */   }
/*  69:    */   
/*  70:    */   public void updateSpecificPurchaseRecord(PurchaseWallPaintVO purchaseWallPaintVO, int purchaseId, int transactionId)
/*  71:    */     throws UpdateFailedException
/*  72:    */   {
/*  73: 74 */     this.purchaseWallPaintDaoInf = new PurchaseWallPaintDaoImpl();
/*  74: 75 */     this.purchaseWallPaintDaoInf.updateSpecificPurchaseRecord(purchaseWallPaintVO, purchaseId, transactionId);
/*  75:    */   }
/*  76:    */   
/*  77:    */   public List<PurchaseWallPaintVO> fetchPurchaseWallPaintListForAdvanceSearch(PurchaseWallPaintVO purchaseWallPaintVO)
/*  78:    */     throws RecordNotFoundException
/*  79:    */   {
/*  80: 82 */     this.purchaseWallPaintDaoInf = new PurchaseWallPaintDaoImpl();
/*  81:    */     
/*  82: 84 */     int searchId = purchaseWallPaintVO.getSearchId();
/*  83: 85 */     String searchValue = "";
/*  84: 87 */     if (searchId == 1) {
/*  85: 89 */       searchValue = String.valueOf(purchaseWallPaintVO.getPurchaseId());
/*  86: 91 */     } else if (searchId == 2) {
/*  87: 92 */       searchValue = purchaseWallPaintVO.getCompanyName();
/*  88: 93 */     } else if (searchId == 3) {
/*  89: 94 */       searchValue = String.valueOf(purchaseWallPaintVO.getInvoiceNo());
/*  90: 96 */     } else if (searchId == 4) {
/*  91: 97 */       searchValue = String.valueOf(purchaseWallPaintVO.getMaterialCode());
/*  92: 99 */     } else if (searchId == 5) {
/*  93:100 */       searchValue = String.valueOf(purchaseWallPaintVO.getDealerName());
/*  94:102 */     } else if (searchId == 6) {
/*  95:103 */       searchValue = String.valueOf(purchaseWallPaintVO.getInvoiceDate());
/*  96:    */     }
/*  97:106 */     return this.purchaseWallPaintDaoInf.fetchPurchaseWallPaintListForAdvanceSearch(searchId, searchValue);
/*  98:    */   }
/*  99:    */   
/* 100:    */   public WallPaint retrivePurchaseWallPaintFullDetailGrid(int purchaseId)
/* 101:    */   {
/* 102:113 */     WallPaint purchaseWallPaint = null;
/* 103:114 */     PurchaseWallPaintDaoInf purchaseWallPaintDaoInf = new PurchaseWallPaintDaoImpl();
/* 104:115 */     purchaseWallPaint = purchaseWallPaintDaoInf.retrivePurchaseWallPaintDaoInfFullDetailGrid(purchaseId);
/* 105:116 */     return purchaseWallPaint;
/* 106:    */   }
/* 107:    */   
/* 108:    */   public int deleteWallPaint(int purchaseId)
/* 109:    */     throws Exception
/* 110:    */   {
/* 111:121 */     System.out.println("OOOOOOOUUUULLLLLLUUU" + purchaseId);
/* 112:122 */     this.purchaseWallPaintDaoInf = new PurchaseWallPaintDaoImpl();
/* 113:123 */     int target = this.purchaseWallPaintDaoInf.deleteWallPaint(purchaseId);
/* 114:124 */     return target;
/* 115:    */   }
/* 116:    */   
/* 117:    */   public void purchaseWallPaintPrintPDF(HttpServletRequest request, HttpServletResponse response, int purchaseId)
/* 118:    */     throws Exception
/* 119:    */   {
/* 120:130 */     PurchaseWallPaintDaoInf purchaseWallPaintDaoInf = new PurchaseWallPaintDaoImpl();
/* 121:131 */     purchaseWallPaintDaoInf.generatePurchaseWallPaintPdf(request, response, purchaseId);
/* 122:    */   }
/* 123:    */   
/* 124:    */   public WallPaint viewNextPurchaseWallPaintDetail(int purchaseId)
/* 125:    */     throws RecordNotFoundException
/* 126:    */   {
/* 127:141 */     this.purchaseWallPaintDaoInf = new PurchaseWallPaintDaoImpl();
/* 128:142 */     WallPaint wallPaint = null;
/* 129:    */     try
/* 130:    */     {
/* 131:144 */       purchaseId++;
/* 132:145 */       if (this.purchaseWallPaintDaoInf.getPurchaseWallPaintLastRecord() < purchaseId)
/* 133:    */       {
/* 134:146 */         purchaseId = 0;
/* 135:147 */         LoginUtil.setProcessUserId(purchaseId);
/* 136:148 */         wallPaint = new WallPaint();
/* 137:149 */         wallPaint.setPurchaseId(0);
/* 138:150 */         return wallPaint;
/* 139:    */       }
/* 140:152 */       LoginUtil.setProcessUserId(purchaseId);
/* 141:153 */       wallPaint = this.purchaseWallPaintDaoInf.getPurchaseWallPaintDetails(purchaseId);
/* 142:154 */       if (wallPaint.getPurchaseId() == 0)
/* 143:    */       {
/* 144:155 */         purchaseId = LoginUtil.getProcessUserId();
/* 145:156 */         LoginUtil.setProcessUserId(purchaseId);
/* 146:157 */         return wallPaint;
/* 147:    */       }
/* 148:159 */       wallPaint = this.purchaseWallPaintDaoInf.getPurchaseWallPaintDetails(purchaseId);
/* 149:    */     }
/* 150:    */     catch (Exception exception)
/* 151:    */     {
/* 152:163 */       logger.error("no records found" + exception);
/* 153:    */     }
/* 154:165 */     return wallPaint;
/* 155:    */   }
/* 156:    */   
/* 157:    */   public WallPaint viewPreviousPurchaseWallpaint(int purchaseId)
/* 158:    */     throws RecordNotFoundException
/* 159:    */   {
/* 160:175 */     this.purchaseWallPaintDaoInf = new PurchaseWallPaintDaoImpl();
/* 161:176 */     WallPaint wallPaint = null;
/* 162:    */     try
/* 163:    */     {
/* 164:178 */       purchaseId--;
/* 165:179 */       LoginUtil.setProcessUserId(purchaseId);
/* 166:180 */       wallPaint = this.purchaseWallPaintDaoInf.getPurchaseWallPaintDetails(purchaseId);
/* 167:181 */       if (wallPaint.getPurchaseId() == 0)
/* 168:    */       {
/* 169:182 */         purchaseId = LoginUtil.getProcessUserId();
/* 170:183 */         LoginUtil.setProcessUserId(purchaseId);
/* 171:184 */         return wallPaint;
/* 172:    */       }
/* 173:186 */       wallPaint = this.purchaseWallPaintDaoInf.getPurchaseWallPaintDetails(purchaseId);
/* 174:    */     }
/* 175:    */     catch (Exception exception)
/* 176:    */     {
/* 177:189 */       logger.error("no records found" + exception);
/* 178:    */     }
/* 179:191 */     return wallPaint;
/* 180:    */   }
/* 181:    */ }


/* Location:           C:\Users\bharti\Desktop\Chouksay\lost\service\
 * Qualified Name:     com.bst.ckt.service.PurchaseWallPaintServiceImpl
 * JD-Core Version:    0.7.0.1
 */