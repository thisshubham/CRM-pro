/*   1:    */ package com.bst.ckt.dao;
/*   2:    */ 
/*   3:    */ import com.bst.ckt.common.QueryBuilder;
/*   4:    */ import com.bst.ckt.exception.RecordNotFoundException;
/*   5:    */ import com.bst.ckt.framework.db.JdbcDAOSupport;
/*   6:    */ import com.bst.ckt.framework.db.JdbcHelper;
/*   7:    */ import com.bst.ckt.helper.NameHelper;
/*   8:    */ import com.bst.ckt.vo.StockVO;
/*   9:    */ import java.io.PrintStream;
/*  10:    */ import java.sql.Connection;
/*  11:    */ import java.sql.PreparedStatement;
/*  12:    */ import java.sql.ResultSet;
/*  13:    */ import java.sql.SQLException;
/*  14:    */ import java.util.ArrayList;
/*  15:    */ import java.util.List;
/*  16:    */ import org.apache.log4j.Logger;
/*  17:    */ 
/*  18:    */ public class StockDaoImpl
/*  19:    */   extends JdbcDAOSupport
/*  20:    */   implements StockDaoInf
/*  21:    */ {
/*  22: 23 */   PreparedStatement preparedStatement = null;
/*  23: 24 */   Connection connection = null;
/*  24: 25 */   ResultSet resultSet = null;
/*  25: 26 */   NameHelper nameHelper = new NameHelper();
/*  26: 27 */   StockVO stockVO = null;
/*  27: 29 */   private static final Logger logger = Logger.getLogger(StockDaoImpl.class);
/*  28:    */   
/*  29:    */   public List<StockVO> viewStockDetailsGrid(StockVO stockVO)
/*  30:    */     throws RecordNotFoundException
/*  31:    */   {
/*  32: 34 */     List<StockVO> stockDetailList = new ArrayList();
/*  33:    */     try
/*  34:    */     {
/*  35: 38 */       this.connection = getConnection();
/*  36:    */       
/*  37:    */ 
/*  38:    */ 
/*  39: 42 */       this.preparedStatement = this.connection.prepareStatement("SELECT * FROM TAB_STOCK_DETAILS");
/*  40:    */       
/*  41: 44 */       this.resultSet = this.preparedStatement.executeQuery();
/*  42: 49 */       while (this.resultSet.next())
/*  43:    */       {
/*  44: 50 */         stockVO = new StockVO();
/*  45: 51 */         System.out.println(this.nameHelper.getProductCategoryNameById(this.resultSet.getInt("STOCK_CATEGORY")) + "nameHelper.getProductCategoryNameById(resultSet.getInt(STOCK_CATEGORY))");
/*  46: 52 */         stockVO.setStockId(this.resultSet.getInt("STOCK_ID"));
/*  47:    */         
/*  48: 54 */         stockVO.setPurchasePrice(this.resultSet.getFloat("STOCK_PURCHASE_PRICE"));
/*  49: 55 */         stockVO.setAmount(this.resultSet.getFloat("STOCK_AMOUNT"));
/*  50:    */         
/*  51: 57 */         stockVO.setNoOfBags(this.resultSet.getInt("STOCK_BAGS_NO"));
/*  52:    */         
/*  53: 59 */         stockVO.setBagsInTon(this.resultSet
/*  54: 60 */           .getFloat("STOCK_BAGS_TON"));
/*  55:    */         
/*  56: 62 */         stockVO.setMaterialCode(this.resultSet
/*  57: 63 */           .getString("STOCK_MATERIAL_CODE"));
/*  58:    */         
/*  59:    */ 
/*  60: 66 */         stockVO.setHsnCode(this.resultSet
/*  61: 67 */           .getString("STOCK_HSN_CODE"));
/*  62:    */         
/*  63: 69 */         stockVO.setUnitPrice(this.resultSet
/*  64: 70 */           .getFloat("STOCK_UNIT_PRICE"));
/*  65:    */         
/*  66: 72 */         stockVO.setProducatCtegory(this.nameHelper.getProductCategoryNameById(this.resultSet.getInt("STOCK_CATEGORY")));
/*  67:    */         
/*  68: 74 */         stockVO.setProductType(this.nameHelper.getProductTypeNameByProductId(Integer.parseInt(this.nameHelper.getProductNameById(this.resultSet
/*  69: 75 */           .getInt("STOCK_PRODUCT_TYPE")))));
/*  70:    */         
/*  71:    */ 
/*  72:    */ 
/*  73:    */ 
/*  74: 80 */         stockDetailList.add(stockVO);
/*  75:    */       }
/*  76:    */     }
/*  77:    */     catch (SQLException sqlExp)
/*  78:    */     {
/*  79: 84 */       sqlExp.printStackTrace();
/*  80: 85 */       logger.error(
/*  81: 86 */         StockDaoImpl.class + 
/*  82: 87 */         "Error: Occur in Query While Fetching the cement purchase Details into Grid from Database.", 
/*  83: 88 */         sqlExp);
/*  84:    */     }
/*  85:    */     catch (Exception exception)
/*  86:    */     {
/*  87: 90 */       exception.printStackTrace();
/*  88: 91 */       logger.error(
/*  89: 92 */         StockDaoImpl.class + 
/*  90: 93 */         "Error: Occur in Query While Closing Connection After Fetching the cement purchase into Grid from Database.", 
/*  91: 94 */         exception);
/*  92:    */     }
/*  93:    */     finally
/*  94:    */     {
/*  95: 96 */       JdbcHelper.closeResultSet(this.resultSet);
/*  96: 97 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/*  97: 98 */       JdbcHelper.closeConnection(this.connection);
/*  98:    */     }
/*  99:100 */     return stockDetailList;
/* 100:    */   }
/* 101:    */   
/* 102:    */   public List<StockVO> viewStockSearchGrid(int searchId, String searchValue)
/* 103:    */     throws RecordNotFoundException
/* 104:    */   {
/* 105:106 */     List<StockVO> stockDetailList = new ArrayList();
/* 106:    */     try
/* 107:    */     {
/* 108:110 */       this.connection = getConnection();
/* 109:    */       
/* 110:    */ 
/* 111:    */ 
/* 112:114 */       this.preparedStatement = this.connection.prepareStatement(QueryBuilder.StockAdvanceSearchForAdmin(searchId, searchValue));
/* 113:    */       
/* 114:116 */       this.resultSet = this.preparedStatement.executeQuery();
/* 115:117 */       System.out.println("GGGGGGGg");
/* 116:121 */       while (this.resultSet.next())
/* 117:    */       {
/* 118:122 */         this.stockVO = new StockVO();
/* 119:123 */         this.stockVO.setStockId(this.resultSet.getInt("STOCK_ID"));
/* 120:    */         
/* 121:125 */         this.stockVO.setPurchasePrice(this.resultSet.getFloat("STOCK_PURCHASE_PRICE"));
/* 122:126 */         this.stockVO.setAmount(this.resultSet.getFloat("STOCK_AMOUNT"));
/* 123:    */         
/* 124:128 */         this.stockVO.setNoOfBags(this.resultSet.getInt("STOCK_BAGS_NO"));
/* 125:    */         
/* 126:130 */         this.stockVO.setBagsInTon(this.resultSet
/* 127:131 */           .getFloat("STOCK_BAGS_TON"));
/* 128:    */         
/* 129:133 */         this.stockVO.setMaterialCode(this.resultSet
/* 130:134 */           .getString("STOCK_MATERIAL_CODE"));
/* 131:    */         
/* 132:    */ 
/* 133:137 */         this.stockVO.setHsnCode(this.resultSet
/* 134:138 */           .getString("STOCK_HSN_CODE"));
/* 135:    */         
/* 136:140 */         this.stockVO.setUnitPrice(this.resultSet
/* 137:141 */           .getFloat("STOCK_UNIT_PRICE"));
/* 138:    */         
/* 139:143 */         this.stockVO.setProducatCtegory(this.nameHelper.getProductCategoryNameById(this.resultSet
/* 140:144 */           .getInt("STOCK_CATEGORY")));
/* 141:    */         
/* 142:146 */         this.stockVO.setProductType(this.nameHelper.getProductTypeNameByProductId(this.resultSet
/* 143:147 */           .getInt("STOCK_PRODUCT_TYPE")));
/* 144:    */         
/* 145:    */ 
/* 146:    */ 
/* 147:    */ 
/* 148:152 */         stockDetailList.add(this.stockVO);
/* 149:    */       }
/* 150:    */     }
/* 151:    */     catch (SQLException sqlExp)
/* 152:    */     {
/* 153:156 */       sqlExp.printStackTrace();
/* 154:157 */       logger.error(
/* 155:158 */         StockDaoImpl.class + 
/* 156:159 */         "Error: Occur in Query While Fetching the stock Details into Grid from Database.", 
/* 157:160 */         sqlExp);
/* 158:    */     }
/* 159:    */     catch (Exception exception)
/* 160:    */     {
/* 161:162 */       exception.printStackTrace();
/* 162:163 */       logger.error(
/* 163:164 */         StockDaoImpl.class + 
/* 164:165 */         "Error: Occur in Query While Closing Connection After Fetching the stock into Grid from Database.", 
/* 165:166 */         exception);
/* 166:    */     }
/* 167:    */     finally
/* 168:    */     {
/* 169:168 */       JdbcHelper.closeResultSet(this.resultSet);
/* 170:169 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/* 171:170 */       JdbcHelper.closeConnection(this.connection);
/* 172:    */     }
/* 173:172 */     return stockDetailList;
/* 174:    */   }
/* 175:    */ }


/* Location:           C:\Users\bharti\Desktop\Chouksay\lost\dao\
 * Qualified Name:     com.bst.ckt.dao.StockDaoImpl
 * JD-Core Version:    0.7.0.1
 */