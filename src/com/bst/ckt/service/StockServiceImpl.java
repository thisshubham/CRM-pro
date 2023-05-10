/*  1:   */ package com.bst.ckt.service;
/*  2:   */ 
/*  3:   */ import com.bst.ckt.dao.ExcelReportDaoImpl;
/*  4:   */ import com.bst.ckt.dao.ExcelReportDaoInf;
/*  5:   */ import com.bst.ckt.dao.StockDaoImpl;
/*  6:   */ import com.bst.ckt.dao.StockDaoInf;
/*  7:   */ import com.bst.ckt.exception.RecordNotFoundException;
/*  8:   */ import com.bst.ckt.vo.StockVO;
/*  9:   */ import java.util.List;
/* 10:   */ import javax.servlet.http.HttpServletRequest;
/* 11:   */ import javax.servlet.http.HttpServletResponse;
/* 12:   */ 
/* 13:   */ public class StockServiceImpl
/* 14:   */   implements StockServiceInf
/* 15:   */ {
/* 16:18 */   StockDaoInf stockDaoInf = new StockDaoImpl();
/* 17:19 */   ExcelReportDaoInf excelReportDaoInf = new ExcelReportDaoImpl();
/* 18:   */   
/* 19:   */   public void stockDetailExcelReport(HttpServletRequest request, HttpServletResponse response)
/* 20:   */   {
/* 21:23 */     this.excelReportDaoInf.stockDetailExcelReport(request, response);
/* 22:   */   }
/* 23:   */   
/* 24:   */   public List<StockVO> viewStockDetailsGrid(StockVO stockVO)
/* 25:   */     throws RecordNotFoundException
/* 26:   */   {
/* 27:29 */     return this.stockDaoInf.viewStockDetailsGrid(stockVO);
/* 28:   */   }
/* 29:   */   
/* 30:   */   public List<StockVO> viewStockSearchGrid(StockVO stockVO)
/* 31:   */     throws RecordNotFoundException
/* 32:   */   {
/* 33:34 */     int searchId = stockVO.getSearchId();
/* 34:35 */     String searchValue = "";
/* 35:37 */     if (searchId == 1) {
/* 36:39 */       searchValue = String.valueOf(stockVO.getStockId());
/* 37:41 */     } else if (searchId == 2) {
/* 38:42 */       searchValue = stockVO.getProductType();
/* 39:43 */     } else if (searchId == 3) {
/* 40:44 */       searchValue = String.valueOf(stockVO.getProducatCtegory());
/* 41:   */     }
/* 42:47 */     return this.stockDaoInf.viewStockSearchGrid(searchId, searchValue);
/* 43:   */   }
/* 44:   */ }


/* Location:           C:\Users\bharti\Desktop\Chouksay\lost\service\
 * Qualified Name:     com.bst.ckt.service.StockServiceImpl
 * JD-Core Version:    0.7.0.1
 */