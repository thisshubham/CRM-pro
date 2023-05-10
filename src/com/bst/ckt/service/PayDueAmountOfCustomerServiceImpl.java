/*  1:   */ package com.bst.ckt.service;
/*  2:   */ 
/*  3:   */ import com.bst.ckt.dao.PayDueAmountOfCustomerDaoImpl;
/*  4:   */ import com.bst.ckt.dao.PayDueAmountOfCustomerDaoInf;
/*  5:   */ import com.bst.ckt.exception.CreateFailedException;
/*  6:   */ import com.bst.ckt.vo.PayDueAmountOfCustomerVO;
/*  7:   */ import org.apache.log4j.Logger;
/*  8:   */ 
/*  9:   */ public class PayDueAmountOfCustomerServiceImpl
/* 10:   */   implements PayDueAmountOfCustomerServiceInf
/* 11:   */ {
/* 12:13 */   private static final Logger logger = Logger.getLogger(PayDueAmountOfCustomerServiceImpl.class);
/* 13:15 */   PayDueAmountOfCustomerDaoInf payDueAmountOfCustomerDaoInf = null;
/* 14:   */   
/* 15:   */   public void addRetailerTransaction(PayDueAmountOfCustomerVO payDueAmountOfCustomerVO)
/* 16:   */     throws CreateFailedException
/* 17:   */   {
/* 18:22 */     this.payDueAmountOfCustomerDaoInf = new PayDueAmountOfCustomerDaoImpl();
/* 19:23 */     this.payDueAmountOfCustomerDaoInf.addRetailerTransaction(payDueAmountOfCustomerVO);
/* 20:   */   }
/* 21:   */ }


/* Location:           C:\Users\bharti\Desktop\Chouksay\lost\service\
 * Qualified Name:     com.bst.ckt.service.PayDueAmountOfCustomerServiceImpl
 * JD-Core Version:    0.7.0.1
 */