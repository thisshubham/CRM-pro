/*   1:    */ package com.bst.ckt.dao;
/*   2:    */ 
/*   3:    */ import com.bst.ckt.exception.CreateFailedException;
/*   4:    */ import com.bst.ckt.framework.db.JdbcDAOSupport;
/*   5:    */ import com.bst.ckt.framework.db.JdbcHelper;
/*   6:    */ import com.bst.ckt.vo.PayDueAmountOfCustomerVO;
/*   7:    */ import java.io.PrintStream;
/*   8:    */ import java.sql.Connection;
/*   9:    */ import java.sql.PreparedStatement;
/*  10:    */ import java.sql.ResultSet;
/*  11:    */ import java.sql.SQLException;
/*  12:    */ import org.apache.log4j.Logger;
/*  13:    */ import org.json.simple.JSONObject;
/*  14:    */ 
/*  15:    */ public class PayDueAmountOfCustomerDaoImpl
/*  16:    */   extends JdbcDAOSupport
/*  17:    */   implements PayDueAmountOfCustomerDaoInf
/*  18:    */ {
/*  19: 22 */   private static final Logger logger = Logger.getLogger(PayDueAmountOfCustomerDaoImpl.class);
/*  20: 23 */   Connection connection = null;
/*  21: 24 */   PreparedStatement preparedStatement = null;
/*  22: 25 */   ResultSet resultSet = null;
/*  23:    */   float paid;
/*  24:    */   float due;
/*  25:    */   float tpaid;
/*  26:    */   float tdue;
/*  27:    */   static String type;
/*  28:    */   static String finalBillNo;
/*  29:    */   
/*  30:    */   public JSONObject getTransactionDetailsByBillNo(String billNum)
/*  31:    */   {
/*  32: 33 */     JSONObject transactionDetailList = null;
/*  33: 34 */     JSONObject object = null;
/*  34:    */     try
/*  35:    */     {
/*  36: 36 */       finalBillNo = billNum;
/*  37: 37 */       String query = "SELECT  * FROM TAB_OWNER_CUSTOMER_TRANSACTION WHERE CUSTOMER_UNIQUE_ID=? AND CUSTOMER_TYPE=?";
/*  38: 38 */       this.connection = getConnection();
/*  39: 39 */       this.preparedStatement = this.connection.prepareStatement(query);
/*  40: 40 */       this.preparedStatement.setString(1, billNum);
/*  41: 41 */       this.preparedStatement.setString(2, "Retailer");
/*  42: 42 */       this.resultSet = this.preparedStatement.executeQuery();
/*  43:    */       
/*  44: 44 */       transactionDetailList = new JSONObject();
/*  45: 46 */       while (this.resultSet.next())
/*  46:    */       {
/*  47: 47 */         object = new JSONObject();
/*  48:    */         
/*  49: 49 */         this.paid = this.resultSet.getFloat("CUSTOMER_TRANS_PAID");
/*  50: 50 */         this.due = this.resultSet.getFloat("CUSTOMER_TRANS_DUE");
/*  51: 51 */         this.tpaid = this.resultSet.getFloat("CUSTOMER_TRANS_TOTAL_PAID");
/*  52: 52 */         this.tdue = this.resultSet.getFloat("CUSTOMER_TRANS_TOTAL_DUE");
/*  53: 53 */         String disc = this.resultSet.getString("CUSTOMER_TRANS_DISCRIPTION");
/*  54: 54 */         type = this.resultSet.getString("CUSTOMER_TYPE");
/*  55:    */         
/*  56: 56 */         System.out.println(type + "TTTTTTT");
/*  57: 57 */         if (((String.valueOf(this.tpaid).equals(null)) && (String.valueOf(this.tdue).equals(null))) || ((this.tpaid == 0.0F) && (this.tdue == 0.0F)))
/*  58:    */         {
/*  59: 60 */           object.put("trToPaid", Float.valueOf(this.paid));
/*  60: 61 */           object.put("trToDue", Float.valueOf(this.due));
/*  61: 62 */           object.put("trDisc", disc);
/*  62:    */         }
/*  63:    */         else
/*  64:    */         {
/*  65: 70 */           object.put("trToPaid", Float.valueOf(this.tpaid));
/*  66: 71 */           object.put("trToDue", Float.valueOf(this.tdue));
/*  67: 72 */           object.put("trDisc", disc);
/*  68:    */         }
/*  69:    */       }
/*  70: 76 */       transactionDetailList.put("transaction", object);
/*  71:    */     }
/*  72:    */     catch (Exception exception)
/*  73:    */     {
/*  74: 79 */       logger.error(PayDueAmountOfCustomerDaoImpl.class + 
/*  75: 80 */         ": Error:- While getting transaction From Database." + exception);
/*  76:    */       try
/*  77:    */       {
/*  78: 83 */         if (this.connection != null)
/*  79:    */         {
/*  80: 84 */           this.resultSet.close();
/*  81: 85 */           this.preparedStatement.close();
/*  82: 86 */           this.connection.close();
/*  83:    */         }
/*  84:    */       }
/*  85:    */       catch (SQLException sqlExp)
/*  86:    */       {
/*  87: 89 */         logger.error(PayDueAmountOfCustomerDaoImpl.class + 
/*  88: 90 */           ": Error:- While closing the Connection after getting transaction details From Database.");
/*  89:    */       }
/*  90:    */     }
/*  91:    */     finally
/*  92:    */     {
/*  93:    */       try
/*  94:    */       {
/*  95: 83 */         if (this.connection != null)
/*  96:    */         {
/*  97: 84 */           this.resultSet.close();
/*  98: 85 */           this.preparedStatement.close();
/*  99: 86 */           this.connection.close();
/* 100:    */         }
/* 101:    */       }
/* 102:    */       catch (SQLException sqlExp)
/* 103:    */       {
/* 104: 89 */         logger.error(PayDueAmountOfCustomerDaoImpl.class + 
/* 105: 90 */           ": Error:- While closing the Connection after getting transaction details From Database.");
/* 106:    */       }
/* 107:    */     }
/* 108: 93 */     return transactionDetailList;
/* 109:    */   }
/* 110:    */   
/* 111:    */   public void addRetailerTransaction(PayDueAmountOfCustomerVO payDueAmountOfCustomerVO)
/* 112:    */     throws CreateFailedException
/* 113:    */   {
/* 114:    */     try
/* 115:    */     {
/* 116:105 */       String query = "INSERT INTO TAB_OWNER_CUSTOMER_TRANSACTION(CUSTOMER_TRANS_DISCRIPTION,CUSTOMER_TRANS_PAID,CUSTOMER_TRANS_TOTAL_PAID,CUSTOMER_TRANS_TOTAL_DUE,CUSTOMER_TRANS_DATE,CUSTOMER_ID_RETAILER,CUSTOMER_UNIQUE_ID,CUSTOMER_TRANS_PAY_MODE, CUSTOMER_TYPE)VALUES(?,?,?,?,?,?,?,?,?)";
/* 117:106 */       this.connection = getConnection();
/* 118:107 */       float totalPaid = payDueAmountOfCustomerVO.getTotalPaid() + payDueAmountOfCustomerVO.getPayment();
/* 119:108 */       float totalDue = payDueAmountOfCustomerVO.getTotalDue() - payDueAmountOfCustomerVO.getPayment();
/* 120:    */       
/* 121:110 */       this.preparedStatement = this.connection.prepareStatement(query);
/* 122:111 */       System.out.println(totalPaid + "helllo we r in dao impl for transaction" + totalDue);
/* 123:112 */       this.preparedStatement.setString(1, "ON_DUE_PAYMENT");
/* 124:113 */       this.preparedStatement.setFloat(2, payDueAmountOfCustomerVO.getPayment());
/* 125:    */       
/* 126:115 */       this.preparedStatement.setFloat(3, totalPaid);
/* 127:116 */       this.preparedStatement.setFloat(4, totalDue);
/* 128:117 */       this.preparedStatement.setString(5, "2018-05-02");
/* 129:118 */       System.out.println(payDueAmountOfCustomerVO.getBillNo() + "hey here is my bill no");
/* 130:    */       
/* 131:    */ 
/* 132:121 */       this.preparedStatement.setString(6, payDueAmountOfCustomerVO.getCustomerName());
/* 133:122 */       this.preparedStatement.setString(7, finalBillNo);
/* 134:123 */       this.preparedStatement.setString(8, payDueAmountOfCustomerVO.getPaymentMode());
/* 135:124 */       this.preparedStatement.setString(9, type);
/* 136:    */       
/* 137:126 */       this.preparedStatement.executeUpdate();
/* 138:    */     }
/* 139:    */     catch (SQLException sqlException)
/* 140:    */     {
/* 141:129 */       sqlException.printStackTrace();
/* 142:130 */       logger.error(
/* 143:131 */         PayDueAmountOfCustomerDaoImpl.class + 
/* 144:132 */         ": Error:- Error: Occur in Query While inserting the transaction details record", 
/* 145:133 */         sqlException);
/* 146:    */     }
/* 147:    */     catch (Exception exception)
/* 148:    */     {
/* 149:135 */       exception.printStackTrace();
/* 150:136 */       logger.error(
/* 151:137 */         PayDueAmountOfCustomerDaoImpl.class + 
/* 152:138 */         ": Error:- While closing the Connection after inserting the transaction details reccord", 
/* 153:139 */         exception);
/* 154:    */     }
/* 155:    */     finally
/* 156:    */     {
/* 157:142 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/* 158:143 */       JdbcHelper.closeConnection(this.connection);
/* 159:    */     }
/* 160:    */   }
/* 161:    */ }


/* Location:           C:\Users\bharti\Desktop\Chouksay\lost\dao\
 * Qualified Name:     com.bst.ckt.dao.PayDueAmountOfCustomerDaoImpl
 * JD-Core Version:    0.7.0.1
 */