/*   1:    */ package com.bst.ckt.action;
/*   2:    */ 
/*   3:    */ import com.bst.ckt.exception.RecordNotFoundException;
/*   4:    */ import com.bst.ckt.helper.ListHelper;
/*   5:    */ import com.bst.ckt.helper.StockAdvanceSearch;
/*   6:    */ import com.bst.ckt.service.StockServiceImpl;
/*   7:    */ import com.bst.ckt.service.StockServiceInf;
/*   8:    */ import com.bst.ckt.vo.StockVO;
/*   9:    */ import com.opensymphony.xwork2.ActionContext;
/*  10:    */ import com.opensymphony.xwork2.ActionSupport;
/*  11:    */ import com.opensymphony.xwork2.ModelDriven;
/*  12:    */ import java.io.PrintStream;
/*  13:    */ import java.util.List;
/*  14:    */ import java.util.Map;
/*  15:    */ import javax.servlet.http.HttpServletRequest;
/*  16:    */ import javax.servlet.http.HttpServletResponse;
/*  17:    */ import org.apache.log4j.Logger;
/*  18:    */ import org.apache.struts2.interceptor.ServletRequestAware;
/*  19:    */ import org.apache.struts2.interceptor.ServletResponseAware;
/*  20:    */ 
/*  21:    */ public class StockAction
/*  22:    */   extends ActionSupport
/*  23:    */   implements ModelDriven<StockVO>, ServletRequestAware, ServletResponseAware
/*  24:    */ {
/*  25:    */   private static final long serialVersionUID = 1L;
/*  26: 39 */   private static final Logger logger = Logger.getLogger(StockAction.class);
/*  27: 43 */   HttpServletRequest request = (HttpServletRequest)ActionContext.getContext().get("com.opensymphony.xwork2.dispatcher.HttpServletRequest");
/*  28: 44 */   StockVO stockVO = new StockVO();
/*  29: 46 */   HttpServletResponse response = null;
/*  30: 47 */   Map<String, Object> session = null;
/*  31: 48 */   StockServiceInf stockServiceInf = new StockServiceImpl();
/*  32: 49 */   List<StockVO> stockDetailList = null;
/*  33:    */   private Map<Integer, String> stockSearchList;
/*  34:    */   private Map<Integer, String> typeList;
/*  35: 52 */   ListHelper listHelper = new ListHelper();
/*  36:    */   
/*  37:    */   public StockAction()
/*  38:    */     throws Exception
/*  39:    */   {
/*  40: 57 */     this.typeList = this.listHelper.getCementTypeList();
/*  41: 58 */     setStockSearchList(StockAdvanceSearch.getStockSearchList());
/*  42:    */   }
/*  43:    */   
/*  44:    */   public String execute()
/*  45:    */     throws Exception
/*  46:    */   {
/*  47: 63 */     this.stockDetailList = this.stockServiceInf.viewStockDetailsGrid(this.stockVO);
/*  48: 64 */     return "success";
/*  49:    */   }
/*  50:    */   
/*  51:    */   public String viewStockDetailsGrid()
/*  52:    */     throws RecordNotFoundException
/*  53:    */   {
/*  54: 70 */     System.out.println("While getting stock details");
/*  55: 71 */     this.stockDetailList = this.stockServiceInf.viewStockSearchGrid(this.stockVO);
/*  56: 73 */     if (this.stockDetailList == null)
/*  57:    */     {
/*  58: 74 */       logger.error(" Error: While getting stock details");
/*  59: 75 */       addActionError("No Records found");
/*  60: 76 */       return "error";
/*  61:    */     }
/*  62: 78 */     logger.info("Records found Successfully");
/*  63: 79 */     return "success";
/*  64:    */   }
/*  65:    */   
/*  66:    */   public String stockDetailExcelReport()
/*  67:    */     throws Exception
/*  68:    */   {
/*  69: 87 */     this.stockServiceInf.stockDetailExcelReport(this.request, this.response);
/*  70: 88 */     return "none";
/*  71:    */   }
/*  72:    */   
/*  73:    */   public void setServletResponse(HttpServletResponse response)
/*  74:    */   {
/*  75: 94 */     this.response = response;
/*  76:    */   }
/*  77:    */   
/*  78:    */   public void setServletRequest(HttpServletRequest request)
/*  79:    */   {
/*  80: 99 */     this.request = request;
/*  81:    */   }
/*  82:    */   
/*  83:    */   public StockVO getModel()
/*  84:    */   {
/*  85:105 */     return this.stockVO;
/*  86:    */   }
/*  87:    */   
/*  88:    */   public StockVO getStockVO()
/*  89:    */   {
/*  90:109 */     return this.stockVO;
/*  91:    */   }
/*  92:    */   
/*  93:    */   public void setStockVO(StockVO stockVO)
/*  94:    */   {
/*  95:113 */     this.stockVO = stockVO;
/*  96:    */   }
/*  97:    */   
/*  98:    */   public List<StockVO> getStockDetailList()
/*  99:    */   {
/* 100:117 */     return this.stockDetailList;
/* 101:    */   }
/* 102:    */   
/* 103:    */   public void setStockDetailList(List<StockVO> stockDetailList)
/* 104:    */   {
/* 105:121 */     this.stockDetailList = stockDetailList;
/* 106:    */   }
/* 107:    */   
/* 108:    */   public Map<Integer, String> getStockSearchList()
/* 109:    */   {
/* 110:125 */     return this.stockSearchList;
/* 111:    */   }
/* 112:    */   
/* 113:    */   public void setStockSearchList(Map<Integer, String> stockSearchList)
/* 114:    */   {
/* 115:129 */     this.stockSearchList = stockSearchList;
/* 116:    */   }
/* 117:    */   
/* 118:    */   public Map<Integer, String> getTypeList()
/* 119:    */   {
/* 120:133 */     return this.typeList;
/* 121:    */   }
/* 122:    */   
/* 123:    */   public void setTypeList(Map<Integer, String> typeList)
/* 124:    */   {
/* 125:137 */     this.typeList = typeList;
/* 126:    */   }
/* 127:    */   
/* 128:    */   public Map<String, Object> getSession()
/* 129:    */   {
/* 130:141 */     return this.session;
/* 131:    */   }
/* 132:    */   
/* 133:    */   public void setSession(Map<String, Object> session)
/* 134:    */   {
/* 135:145 */     this.session = session;
/* 136:    */   }
/* 137:    */ }


/* Location:           C:\Users\bharti\Desktop\Chouksay\lost\action\
 * Qualified Name:     com.bst.ckt.action.StockAction
 * JD-Core Version:    0.7.0.1
 */