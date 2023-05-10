/*   1:    */ package com.bst.ckt.service;
/*   2:    */ 
/*   3:    */ import com.bst.ckt.action.InvoiceSaleAction;
/*   4:    */ import com.bst.ckt.common.LoginUtil;
/*   5:    */ import com.bst.ckt.dao.ExcelReportDaoImpl;
/*   6:    */ import com.bst.ckt.dao.ExcelReportDaoInf;
/*   7:    */ import com.bst.ckt.dao.InvoiceSaleDaoImpl;
/*   8:    */ import com.bst.ckt.dao.InvoiceSaleDaoInf;
/*   9:    */ import com.bst.ckt.dto.InvoiceSale;
/*  10:    */ import com.bst.ckt.exception.CreateFailedException;
/*  11:    */ import com.bst.ckt.exception.DeleteFailedException;
/*  12:    */ import com.bst.ckt.exception.RecordNotFoundException;
/*  13:    */ import com.bst.ckt.exception.UpdateFailedException;
/*  14:    */ import com.bst.ckt.vo.InvoiceSaleVO;
/*  15:    */ import java.io.PrintStream;
/*  16:    */ import java.util.List;
/*  17:    */ import javax.servlet.http.HttpServletRequest;
/*  18:    */ import javax.servlet.http.HttpServletResponse;
/*  19:    */ import org.apache.log4j.Logger;
/*  20:    */ 
/*  21:    */ public class InvoiceSaleServiceImpl
/*  22:    */   implements InvoiceSaleServiceInf
/*  23:    */ {
/*  24: 28 */   Logger logger = Logger.getLogger(InvoiceSaleAction.class);
/*  25: 29 */   InvoiceSaleDaoInf invoiceSaleDaoInf = null;
/*  26: 30 */   ExcelReportDaoInf excelReportDaoInf = new ExcelReportDaoImpl();
/*  27:    */   
/*  28:    */   public int addSalesDetails(InvoiceSaleVO invoiceSaleVO)
/*  29:    */     throws CreateFailedException
/*  30:    */   {
/*  31: 36 */     System.out.println("&&&&&&&&&&we r in serviiiiiice&&&&&&&&&&&&&&&&");
/*  32: 37 */     this.invoiceSaleDaoInf = new InvoiceSaleDaoImpl();
/*  33: 38 */     int target = this.invoiceSaleDaoInf.addSalesDetails(invoiceSaleVO);
/*  34: 40 */     if (target != 0)
/*  35:    */     {
/*  36: 41 */       this.logger.info("Successfully Inserted Sales Details!");
/*  37: 42 */       return target;
/*  38:    */     }
/*  39: 44 */     this.logger.error(InvoiceSaleServiceImpl.class+"unable to insert sales Details!");
/*  40: 45 */     return target;
/*  41:    */   }
/*  42:    */   
/*  43:    */   public List<InvoiceSaleVO> retriveSalesDetailsGrid(InvoiceSaleVO invoiceSaleVO)
/*  44:    */     throws RecordNotFoundException
/*  45:    */   {
/*  46: 55 */     this.invoiceSaleDaoInf = new InvoiceSaleDaoImpl();
/*  47: 56 */     return this.invoiceSaleDaoInf.getSalesDetails(invoiceSaleVO);
/*  48:    */   }
/*  49:    */   
/*  50:    */   public InvoiceSale retriveSpecificSalesDetail(int salesId)
/*  51:    */     throws RecordNotFoundException
/*  52:    */   {
/*  53: 62 */     InvoiceSale invoiceSale = null;
/*  54: 63 */     this.invoiceSaleDaoInf = new InvoiceSaleDaoImpl();
/*  55: 64 */     invoiceSale = this.invoiceSaleDaoInf.retriveSpecificSalesDetail(salesId);
/*  56: 65 */     return invoiceSale;
/*  57:    */   }
/*  58:    */   
/*  59:    */   public String deleteSpecificSalesDetails(int salesId)
/*  60:    */     throws DeleteFailedException
/*  61:    */   {
/*  62: 71 */     this.invoiceSaleDaoInf = new InvoiceSaleDaoImpl();
/*  63: 72 */     int effect = this.invoiceSaleDaoInf.deleteSpecificSalesDetails(salesId);
/*  64: 73 */     if (effect == 1) {
/*  65: 74 */       return "SUCCESS";
/*  66:    */     }
/*  67: 76 */     return "ERROR";
/*  68:    */   }
/*  69:    */   
/*  70:    */   public InvoiceSale retriveSpecificSalesDetailForUpdate(int salesId)
/*  71:    */     throws RecordNotFoundException
/*  72:    */   {
/*  73: 84 */     InvoiceSale invoiceSale = null;
/*  74: 85 */     this.invoiceSaleDaoInf = new InvoiceSaleDaoImpl();
/*  75: 86 */     invoiceSale = this.invoiceSaleDaoInf.retriveSpecificSalesDetailForUpdate(salesId);
/*  76: 87 */     return invoiceSale;
/*  77:    */   }
/*  78:    */   
/*  79:    */   public List<InvoiceSaleVO> getSpecificItemsForEdit(int salesId)
/*  80:    */     throws RecordNotFoundException
/*  81:    */   {
/*  82: 93 */     this.invoiceSaleDaoInf = new InvoiceSaleDaoImpl();
/*  83: 94 */     return this.invoiceSaleDaoInf.getSpecificItemsForEdit(salesId);
/*  84:    */   }
/*  85:    */   
/*  86:    */   public void updateSpecificSalesRecord(InvoiceSaleVO invoiceSaleVO, int salesId)
/*  87:    */     throws UpdateFailedException
/*  88:    */   {
/*  89:100 */     this.invoiceSaleDaoInf = new InvoiceSaleDaoImpl();
/*  90:101 */     this.invoiceSaleDaoInf.updateSpecificSalesRecord(invoiceSaleVO, salesId);
/*  91:    */   }
/*  92:    */   
/*  93:    */   public void salesPDF(HttpServletRequest request, HttpServletResponse response, int salesId)
/*  94:    */   {
/*  95:108 */     this.invoiceSaleDaoInf = new InvoiceSaleDaoImpl();
/*  96:109 */     this.invoiceSaleDaoInf.salesPDF(request, response, salesId);
/*  97:    */   }
/*  98:    */   
/*  99:    */   public void salesExcelReport(HttpServletRequest request, HttpServletResponse response)
/* 100:    */     throws Exception
/* 101:    */   {
/* 102:118 */     this.excelReportDaoInf.salesExcelReport(request, response);
/* 103:    */   }
/* 104:    */   
/* 105:    */   public List<InvoiceSaleVO> retriveSalesDetailsForAdvanceSearch(InvoiceSaleVO invoiceSaleVO)
/* 106:    */     throws RecordNotFoundException
/* 107:    */   {
/* 108:124 */     this.invoiceSaleDaoInf = new InvoiceSaleDaoImpl();
/* 109:    */     
/* 110:126 */     int searchId = invoiceSaleVO.getSearchId();
/* 111:127 */     String searchValue = "";
/* 112:129 */     if (searchId == 1) {
/* 113:131 */       searchValue = String.valueOf(invoiceSaleVO.getSalesId());
/* 114:133 */     } else if (searchId == 2) {
/* 115:134 */       searchValue = invoiceSaleVO.getCustomerType();
/* 116:142 */     } else if (searchId == 3) {
/* 117:143 */       searchValue = String.valueOf(invoiceSaleVO.getSalesDate());
/* 118:145 */     } else if (searchId == 4) {
/* 119:146 */       searchValue = String.valueOf(invoiceSaleVO.getPaymentMode());
/* 120:149 */     } else if (searchId == 5) {
/* 121:150 */       searchValue = String.valueOf(invoiceSaleVO.getCustomerId());
/* 122:152 */     } else if (searchId == 6) {
/* 123:153 */       searchValue = String.valueOf(invoiceSaleVO.getPaymentAnswer());
/* 124:155 */     } else if (searchId == 7) {
/* 125:156 */       searchValue = invoiceSaleVO.getUniqueId();
/* 126:    */     }
/* 127:159 */     return this.invoiceSaleDaoInf.retriveSalesDetailsForAdvanceSearch(searchId, searchValue);
/* 128:    */   }
/* 129:    */   
/* 130:    */   public InvoiceSale viewNextSalesDetail(int salesId)
/* 131:    */     throws RecordNotFoundException
/* 132:    */   {
/* 133:165 */     this.invoiceSaleDaoInf = new InvoiceSaleDaoImpl();
/* 134:166 */     InvoiceSale invoiceSale = null;
/* 135:    */     try
/* 136:    */     {
/* 137:168 */       salesId++;
/* 138:169 */       if (this.invoiceSaleDaoInf.getSalesLastRecord() < salesId)
/* 139:    */       {
/* 140:170 */         salesId = 0;
/* 141:171 */         LoginUtil.setProcessUserId(salesId);
/* 142:172 */         invoiceSale = new InvoiceSale();
/* 143:173 */         invoiceSale.setSalesId(0);
/* 144:174 */         return invoiceSale;
/* 145:    */       }
/* 146:176 */       LoginUtil.setProcessUserId(salesId);
/* 147:177 */       invoiceSale = this.invoiceSaleDaoInf.getSalesDetails(salesId);
/* 148:178 */       if (invoiceSale.getSalesId() == 0)
/* 149:    */       {
/* 150:179 */         salesId = LoginUtil.getProcessUserId();
/* 151:180 */         LoginUtil.setProcessUserId(salesId);
/* 152:181 */         return invoiceSale;
/* 153:    */       }
/* 154:183 */       invoiceSale = this.invoiceSaleDaoInf.getSalesDetails(salesId);
/* 155:    */     }
/* 156:    */     catch (Exception exception)
/* 157:    */     {
/* 158:187 */       this.logger.error("no records found" + exception);
/* 159:    */     }
/* 160:189 */     return invoiceSale;
/* 161:    */   }
/* 162:    */   
/* 163:    */   public InvoiceSale viewPreviousSalesDetails(int salesId)
/* 164:    */     throws RecordNotFoundException
/* 165:    */   {
/* 166:195 */     this.invoiceSaleDaoInf = new InvoiceSaleDaoImpl();
/* 167:196 */     InvoiceSale invoiceSale = null;
/* 168:    */     try
/* 169:    */     {
/* 170:198 */       salesId--;
/* 171:199 */       LoginUtil.setProcessUserId(salesId);
/* 172:200 */       invoiceSale = this.invoiceSaleDaoInf.getSalesDetails(salesId);
/* 173:201 */       if (invoiceSale.getSalesId() == 0)
/* 174:    */       {
/* 175:202 */         salesId = LoginUtil.getProcessUserId();
/* 176:203 */         LoginUtil.setProcessUserId(salesId);
/* 177:204 */         return invoiceSale;
/* 178:    */       }
/* 179:206 */       invoiceSale = this.invoiceSaleDaoInf.getSalesDetails(salesId);
/* 180:    */     }
/* 181:    */     catch (Exception exception)
/* 182:    */     {
/* 183:209 */       this.logger.error("no records found" + exception);
/* 184:    */     }
/* 185:211 */     return invoiceSale;
/* 186:    */   }
/* 187:    */   
/* 188:    */   public void generateBillForSales(HttpServletRequest request, HttpServletResponse response, int lastRecord, int result)
/* 189:    */   {
	  this.invoiceSaleDaoInf = new InvoiceSaleDaoImpl();
/* 190:217 */     this.invoiceSaleDaoInf.generateBillForSales(request, response, lastRecord, result);
/* 191:    */   }
/* 192:    */   
/* 193:    */   public List<InvoiceSaleVO> getSpecificItemsBySalesId(int salesId)
/* 194:    */     throws RecordNotFoundException
/* 195:    */   {
/* 196:224 */     this.invoiceSaleDaoInf = new InvoiceSaleDaoImpl();
/* 197:225 */     return this.invoiceSaleDaoInf.getSpecificItemsForView(salesId);
/* 198:    */   }
/* 199:    */ }


/* Location:           C:\Users\bharti\Desktop\Chouksay\lost\service\
 * Qualified Name:     com.bst.ckt.service.InvoiceSaleServiceImpl
 * JD-Core Version:    0.7.0.1
 */