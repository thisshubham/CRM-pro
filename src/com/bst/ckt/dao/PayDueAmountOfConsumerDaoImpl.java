/*   1:    */ package com.bst.ckt.dao;
/*   2:    */ 
/*   3:    */ import com.bst.ckt.exception.CreateFailedException;
/*   4:    */ import com.bst.ckt.exception.RecordNotFoundException;
/*   5:    */ import com.bst.ckt.framework.db.JdbcDAOSupport;
/*   6:    */ import com.bst.ckt.framework.db.JdbcHelper;
/*   7:    */ import com.bst.ckt.vo.PayDueAmountOfConsumerVO;
/*   8:    */ import java.io.PrintStream;
/*   9:    */ import java.sql.Connection;
/*  10:    */ import java.sql.PreparedStatement;
/*  11:    */ import java.sql.ResultSet;
/*  12:    */ import java.sql.SQLException;
/*  13:    */ import org.apache.log4j.Logger;
/*  14:    */ import org.json.simple.JSONObject;
/*  15:    */ 
/*  16:    */ public class PayDueAmountOfConsumerDaoImpl
/*  17:    */   extends JdbcDAOSupport
/*  18:    */   implements PayDueAmountOfConsumerDaoInf
/*  19:    */ {
/*  20: 20 */   private static final Logger logger = Logger.getLogger(PayDueAmountOfConsumerDaoImpl.class);
/*  21: 21 */   Connection connection = null;
/*  22: 22 */   PreparedStatement preparedStatement = null;
/*  23: 23 */   ResultSet resultSet = null;
/*  24:    */   float paid;
/*  25:    */   float due;
/*  26:    */   float tpaid;
/*  27:    */   float tdue;
/*  28:    */   static String type;
/*  29:    */   static String finalBillNo;
/*  30:    */   
/*  31:    */   public JSONObject getTransactionDetailsByBillNo(String billNum)
/*  32:    */     throws RecordNotFoundException
/*  33:    */   {
/*  34: 32 */     JSONObject transactionDetailList = null;
/*  35: 33 */     JSONObject object = null;
/*  36:    */     try
/*  37:    */     {
/*  38: 35 */       finalBillNo = billNum;
/*  39: 36 */       String query = "SELECT  * FROM TAB_OWNER_CUSTOMER_TRANSACTION WHERE CUSTOMER_UNIQUE_ID=? AND CUSTOMER_TYPE=?";
/*  40: 37 */       this.connection = getConnection();
/*  41: 38 */       this.preparedStatement = this.connection.prepareStatement(query);
/*  42: 39 */       this.preparedStatement.setString(1, billNum);
/*  43: 40 */       this.preparedStatement.setString(2, "Consumer");
/*  44: 41 */       this.resultSet = this.preparedStatement.executeQuery();
/*  45:    */       
/*  46: 43 */       transactionDetailList = new JSONObject();
/*  47: 45 */       while (this.resultSet.next())
/*  48:    */       {
/*  49: 46 */         object = new JSONObject();
/*  50:    */         
/*  51: 48 */         this.paid = this.resultSet.getFloat("CUSTOMER_TRANS_PAID");
/*  52: 49 */         this.due = this.resultSet.getFloat("CUSTOMER_TRANS_DUE");
/*  53: 50 */         this.tpaid = this.resultSet.getFloat("CUSTOMER_TRANS_TOTAL_PAID");
/*  54: 51 */         this.tdue = this.resultSet.getFloat("CUSTOMER_TRANS_TOTAL_DUE");
/*  55: 52 */         String disc = this.resultSet.getString("CUSTOMER_TRANS_DISCRIPTION");
/*  56: 53 */         type = this.resultSet.getString("CUSTOMER_TYPE");
/*  57:    */         
/*  58: 55 */         System.out.println(type + "TTTTTTT");
/*  59: 56 */         if (((String.valueOf(this.tpaid).equals(null)) && (String.valueOf(this.tdue).equals(null))) || ((this.tpaid == 0.0F) && (this.tdue == 0.0F)))
/*  60:    */         {
/*  61: 59 */           object.put("trToPaid", Float.valueOf(this.paid));
/*  62: 60 */           object.put("trToDue", Float.valueOf(this.due));
/*  63: 61 */           object.put("trDisc", disc);
/*  64:    */         }
/*  65:    */         else
/*  66:    */         {
/*  67: 69 */           object.put("trToPaid", Float.valueOf(this.tpaid));
/*  68: 70 */           object.put("trToDue", Float.valueOf(this.tdue));
/*  69: 71 */           object.put("trDisc", disc);
/*  70:    */         }
/*  71:    */       }
/*  72: 75 */       transactionDetailList.put("transaction", object);
/*  73:    */     }
/*  74:    */     catch (SQLException sqlExp)
/*  75:    */     {
/*  76: 77 */       logger.error(PayDueAmountOfConsumerDaoImpl.class + 
/*  77: 78 */         ": Error:- While closing the Connection after getting transaction details From Database.");
/*  78:    */     }
/*  79:    */     catch (Exception exception)
/*  80:    */     {
/*  81: 82 */       logger.error(PayDueAmountOfConsumerDaoImpl.class + 
/*  82: 83 */         ": Error:- While getting transaction From Database." + exception);
/*  83:    */     }
/*  84:    */     finally
/*  85:    */     {
/*  86: 85 */       JdbcHelper.closeResultSet(this.resultSet);
/*  87: 86 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/*  88: 87 */       JdbcHelper.closeConnection(this.connection);
/*  89:    */     }
/*  90: 90 */     return transactionDetailList;
/*  91:    */   }
/*  92:    */   
/*  93:    */   public void addConsumerTransaction(PayDueAmountOfConsumerVO payDueAmountOfConsumerVO)
/*  94:    */     throws CreateFailedException
/*  95:    */   {
/*  96:    */     try
/*  97:    */     {
/*  98: 99 */       String query = "INSERT INTO TAB_OWNER_CUSTOMER_TRANSACTION(CUSTOMER_TRANS_DISCRIPTION,CUSTOMER_TRANS_PAID,CUSTOMER_TRANS_TOTAL_PAID,CUSTOMER_TRANS_TOTAL_DUE,CUSTOMER_TRANS_DATE,CUSTOMER_ID_CONSUMER,CUSTOMER_UNIQUE_ID,CUSTOMER_TRANS_PAY_MODE, CUSTOMER_TYPE)VALUES(?,?,?,?,?,?,?,?,?)";
/*  99:100 */       this.connection = getConnection();
/* 100:101 */       float totalPaid = payDueAmountOfConsumerVO.getTotalPaid() + payDueAmountOfConsumerVO.getPayment();
/* 101:102 */       float totalDue = payDueAmountOfConsumerVO.getTotalDue() - payDueAmountOfConsumerVO.getPayment();
/* 102:    */       
/* 103:104 */       this.preparedStatement = this.connection.prepareStatement(query);
/* 104:105 */       System.out.println(totalPaid + "helllo we r in dao impl for transaction" + totalDue);
/* 105:106 */       this.preparedStatement.setString(1, "ON_DUE_PAYMENT");
/* 106:107 */       this.preparedStatement.setFloat(2, payDueAmountOfConsumerVO.getPayment());
/* 107:    */       
/* 108:109 */       this.preparedStatement.setFloat(3, totalPaid);
/* 109:110 */       this.preparedStatement.setFloat(4, totalDue);
/* 110:111 */       this.preparedStatement.setString(5, "2018-05-02");
/* 111:112 */       System.out.println(payDueAmountOfConsumerVO.getBillNo() + "hey here is my bill no");
/* 112:    */       
/* 113:    */ 
/* 114:115 */       this.preparedStatement.setString(6, payDueAmountOfConsumerVO.getCustomerName());
/* 115:116 */       this.preparedStatement.setString(7, finalBillNo);
/* 116:117 */       this.preparedStatement.setString(8, payDueAmountOfConsumerVO.getPaymentMode());
/* 117:118 */       this.preparedStatement.setString(9, type);
/* 118:    */       
/* 119:120 */       this.preparedStatement.executeUpdate();
/* 120:    */     }
/* 121:    */     catch (SQLException sqlException)
/* 122:    */     {
/* 123:123 */       sqlException.printStackTrace();
/* 124:124 */       logger.error(
/* 125:125 */         PayDueAmountOfCustomerDaoImpl.class + 
/* 126:126 */         ": Error:- Error: Occur in Query While inserting the transaction details record", 
/* 127:127 */         sqlException);
/* 128:    */     }
/* 129:    */     catch (Exception exception)
/* 130:    */     {
/* 131:129 */       exception.printStackTrace();
/* 132:130 */       logger.error(
/* 133:131 */         PayDueAmountOfCustomerDaoImpl.class + 
/* 134:132 */         ": Error:- While closing the Connection after inserting the transaction details reccord", 
/* 135:133 */         exception);
/* 136:    */     }
/* 137:    */     finally
/* 138:    */     {
/* 139:136 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/* 140:137 */       JdbcHelper.closeConnection(this.connection);
/* 141:    */     }
/* 142:    */   }
/* 143:    */ }


/* Location:           C:\Users\bharti\Desktop\Chouksay\lost\dao\
 * Qualified Name:     com.bst.ckt.dao.PayDueAmountOfConsumerDaoImpl
 * JD-Core Version:    0.7.0.1
 */