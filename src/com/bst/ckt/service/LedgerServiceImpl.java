/*  1:   */ package com.bst.ckt.service;
/*  2:   */ 
/*  3:   */ import com.bst.ckt.dao.LedgerDaoImpl;
/*  4:   */ import com.bst.ckt.dao.LedgerDaoInf;
/*  5:   */ import com.bst.ckt.exception.RecordNotFoundException;
/*  6:   */ import com.bst.ckt.vo.LedgerVO;
/*  7:   */ import java.util.List;
/*  8:   */ import javax.servlet.http.HttpServletRequest;
/*  9:   */ import javax.servlet.http.HttpServletResponse;
/* 10:   */ 
/* 11:   */ public class LedgerServiceImpl
/* 12:   */   implements LedgerServiceInf
/* 13:   */ {
/* 14:17 */   LedgerDaoInf ledgerDaoInf = null;
/* 15:   */   
/* 16:   */   public List<LedgerVO> viewLedgerGrid()
/* 17:   */     throws RecordNotFoundException
/* 18:   */   {
/* 19:21 */     this.ledgerDaoInf = new LedgerDaoImpl();
/* 20:22 */     return this.ledgerDaoInf.viewLedgerGrid();
/* 21:   */   }
/* 22:   */   
/* 23:   */   public void generateLedgerPDF(HttpServletRequest request, HttpServletResponse response, int dealerId)
/* 24:   */   {
/* 25:28 */     this.ledgerDaoInf = new LedgerDaoImpl();
/* 26:29 */     this.ledgerDaoInf.generateLedgerPDF(request, response, dealerId);
/* 27:   */   }
/* 28:   */ }


/* Location:           C:\Users\bharti\Desktop\Chouksay\lost\service\
 * Qualified Name:     com.bst.ckt.service.LedgerServiceImpl
 * JD-Core Version:    0.7.0.1
 */