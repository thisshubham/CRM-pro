/*  1:   */ package com.bst.ckt.service;
/*  2:   */ 
/*  3:   */ import com.bst.ckt.dao.PayDueAmountOfConsumerDaoImpl;
/*  4:   */ import com.bst.ckt.dao.PayDueAmountOfConsumerDaoInf;
/*  5:   */ import com.bst.ckt.exception.CreateFailedException;
/*  6:   */ import com.bst.ckt.vo.PayDueAmountOfConsumerVO;
/*  7:   */ import org.apache.log4j.Logger;
/*  8:   */ 
/*  9:   */ public class PayDueAmountOfConsumerServiceImpl
/* 10:   */   implements PayDueAmountOfConsumerServiceInf
/* 11:   */ {
/* 12:14 */   private static final Logger logger = Logger.getLogger(PayDueAmountOfConsumerServiceImpl.class);
/* 13:15 */   PayDueAmountOfConsumerDaoInf payDueAmountOfConsumerDaoInf = null;
/* 14:   */   
/* 15:   */   public void addConsumerTransaction(PayDueAmountOfConsumerVO payDueAmountOfConsumerVO)
/* 16:   */     throws CreateFailedException
/* 17:   */   {
/* 18:20 */     this.payDueAmountOfConsumerDaoInf = new PayDueAmountOfConsumerDaoImpl();
/* 19:21 */     this.payDueAmountOfConsumerDaoInf.addConsumerTransaction(payDueAmountOfConsumerVO);
/* 20:   */   }
/* 21:   */ }


/* Location:           C:\Users\bharti\Desktop\Chouksay\lost\service\
 * Qualified Name:     com.bst.ckt.service.PayDueAmountOfConsumerServiceImpl
 * JD-Core Version:    0.7.0.1
 */