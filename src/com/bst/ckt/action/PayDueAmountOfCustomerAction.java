/*   1:    */ package com.bst.ckt.action;
/*   2:    */ 
/*   3:    */ import com.bst.ckt.dao.PayDueAmountOfCustomerDaoImpl;
/*   4:    */ import com.bst.ckt.dao.PayDueAmountOfCustomerDaoInf;
/*   5:    */ import com.bst.ckt.exception.CreateFailedException;
/*   6:    */ import com.bst.ckt.helper.ListHelper;
/*   7:    */ import com.bst.ckt.helper.Salutation;
/*   8:    */ import com.bst.ckt.service.PayDueAmountOfCustomerServiceImpl;
/*   9:    */ import com.bst.ckt.service.PayDueAmountOfCustomerServiceInf;
/*  10:    */ import com.bst.ckt.vo.PayDueAmountOfCustomerVO;
/*  11:    */ import com.opensymphony.xwork2.ActionSupport;
/*  12:    */ import com.opensymphony.xwork2.ModelDriven;
/*  13:    */ import java.io.IOException;
/*  14:    */ import java.io.PrintStream;
/*  15:    */ import java.io.PrintWriter;
/*  16:    */ import java.util.Map;
/*  17:    */ import javax.servlet.http.HttpServletRequest;
/*  18:    */ import javax.servlet.http.HttpServletResponse;
/*  19:    */ import org.apache.log4j.Logger;
/*  20:    */ import org.apache.struts2.interceptor.ServletRequestAware;
/*  21:    */ import org.apache.struts2.interceptor.ServletResponseAware;
/*  22:    */ import org.apache.struts2.interceptor.SessionAware;
/*  23:    */ import org.json.simple.JSONObject;
/*  24:    */ 
/*  25:    */ public class PayDueAmountOfCustomerAction
/*  26:    */   extends ActionSupport
/*  27:    */   implements ServletRequestAware, ModelDriven<PayDueAmountOfCustomerVO>, ServletResponseAware, SessionAware
/*  28:    */ {
/*  29:    */   private static final long serialVersionUID = 1L;
/*  30: 38 */   private static final Logger logger = Logger.getLogger(PayDueAmountOfCustomerAction.class);
/*  31: 40 */   PayDueAmountOfCustomerVO payDueAmountOfCustomerVO = new PayDueAmountOfCustomerVO();
/*  32: 41 */   PayDueAmountOfCustomerServiceInf payDueAmountOfCustomerServiceInf = null;
/*  33: 42 */   PayDueAmountOfCustomerDaoInf payDueAmountOfCustomerDaoInf = null;
/*  34: 43 */   ListHelper listHelper = new ListHelper();
/*  35: 45 */   HttpServletRequest request = null;
/*  36: 46 */   HttpServletResponse response = null;
/*  37:    */   private Map<Integer, String> salutationList;
/*  38:    */   private Map<Integer, String> retailerList;
/*  39: 58 */   Map<String, Object> session = null;
/*  40:    */   
/*  41:    */   public PayDueAmountOfCustomerAction()
/*  42:    */     throws Exception
/*  43:    */   {
/*  44: 64 */     this.salutationList = Salutation.getSalutationList();
/*  45: 65 */     this.retailerList = this.listHelper.regularCustomerList();
/*  46:    */   }
/*  47:    */   
/*  48:    */   public String execute()
/*  49:    */     throws Exception
/*  50:    */   {
/*  51: 83 */     return "success";
/*  52:    */   }
/*  53:    */   
/*  54:    */   public String addRetailerTransaction()
/*  55:    */     throws CreateFailedException
/*  56:    */   {
/*  57: 88 */     this.payDueAmountOfCustomerServiceInf = new PayDueAmountOfCustomerServiceImpl();
/*  58:    */     
/*  59:    */ 
/*  60: 91 */     System.out.println(this.payDueAmountOfCustomerVO.getBillNo() + "^^^");
/*  61: 92 */     this.payDueAmountOfCustomerServiceInf.addRetailerTransaction(this.payDueAmountOfCustomerVO);
/*  62:    */     
/*  63:    */ 
/*  64: 95 */     return "success";
/*  65:    */   }
/*  66:    */   
/*  67:    */   public void getRegularCustomerDetails()
/*  68:    */     throws IOException
/*  69:    */   {
/*  70:    */     try
/*  71:    */     {
/*  72:104 */       System.out.println("hello bharti ur in jsoncode_(((((((((");
/*  73:105 */       JSONObject custDetails = new JSONObject();
/*  74:    */       
/*  75:107 */       int customerId = Integer.parseInt(this.request.getParameter("custId"));
/*  76:    */       
/*  77:109 */       this.listHelper = new ListHelper();
/*  78:110 */       custDetails = this.listHelper.getRegularCustomerDetail(customerId);
/*  79:    */       
/*  80:112 */       PrintWriter out = this.response.getWriter();
/*  81:    */       
/*  82:114 */       out.print(custDetails);
/*  83:    */     }
/*  84:    */     catch (Exception exception)
/*  85:    */     {
/*  86:117 */       System.out.println(exception);
/*  87:    */     }
/*  88:    */   }
/*  89:    */   
/*  90:    */   public void getTransactionDetailsByBillNo()
/*  91:    */     throws IOException
/*  92:    */   {
/*  93:    */     try
/*  94:    */     {
/*  95:124 */       this.payDueAmountOfCustomerDaoInf = new PayDueAmountOfCustomerDaoImpl();
/*  96:125 */       System.out.println("hello bharti ur in jsoncode_transaction(((((((((");
/*  97:126 */       JSONObject transactionDetails = new JSONObject();
/*  98:    */       
/*  99:128 */       String billNum = this.request.getParameter("billNo");
/* 100:129 */       this.payDueAmountOfCustomerVO.setBillNo(billNum);
/* 101:    */       
/* 102:    */ 
/* 103:132 */       transactionDetails = this.payDueAmountOfCustomerDaoInf.getTransactionDetailsByBillNo(billNum);
/* 104:133 */       PrintWriter out = this.response.getWriter();
/* 105:    */       
/* 106:135 */       out.print(transactionDetails);
/* 107:    */     }
/* 108:    */     catch (Exception exception)
/* 109:    */     {
/* 110:138 */       System.out.println(exception);
/* 111:    */     }
/* 112:    */   }
/* 113:    */   
/* 114:    */   public ListHelper getListHelper()
/* 115:    */   {
/* 116:146 */     return this.listHelper;
/* 117:    */   }
/* 118:    */   
/* 119:    */   public void setListHelper(ListHelper listHelper)
/* 120:    */   {
/* 121:154 */     this.listHelper = listHelper;
/* 122:    */   }
/* 123:    */   
/* 124:    */   public static Logger getLogger()
/* 125:    */   {
/* 126:163 */     return logger;
/* 127:    */   }
/* 128:    */   
/* 129:    */   public HttpServletRequest getRequest()
/* 130:    */   {
/* 131:170 */     return this.request;
/* 132:    */   }
/* 133:    */   
/* 134:    */   public void setServletResponse(HttpServletResponse response)
/* 135:    */   {
/* 136:176 */     this.response = response;
/* 137:    */   }
/* 138:    */   
/* 139:    */   public void setServletRequest(HttpServletRequest request)
/* 140:    */   {
/* 141:182 */     this.request = request;
/* 142:    */   }
/* 143:    */   
/* 144:    */   public void setSession(Map<String, Object> arg0) {}
/* 145:    */   
/* 146:    */   public Map<Integer, String> getRetailerList()
/* 147:    */   {
/* 148:193 */     return this.retailerList;
/* 149:    */   }
/* 150:    */   
/* 151:    */   public void setRetailerList(Map<Integer, String> retailerList)
/* 152:    */   {
/* 153:197 */     this.retailerList = retailerList;
/* 154:    */   }
/* 155:    */   
/* 156:    */   public Map<Integer, String> getSalutationList()
/* 157:    */   {
/* 158:202 */     return this.salutationList;
/* 159:    */   }
/* 160:    */   
/* 161:    */   public void setSalutationList(Map<Integer, String> salutationList)
/* 162:    */   {
/* 163:206 */     this.salutationList = salutationList;
/* 164:    */   }
/* 165:    */   
/* 166:    */   public PayDueAmountOfCustomerVO getModel()
/* 167:    */   {
/* 168:213 */     return this.payDueAmountOfCustomerVO;
/* 169:    */   }
/* 170:    */   
/* 171:    */   public PayDueAmountOfCustomerVO getPayDueAmountOfCustomerVO()
/* 172:    */   {
/* 173:217 */     return this.payDueAmountOfCustomerVO;
/* 174:    */   }
/* 175:    */   
/* 176:    */   public void setPayDueAmountOfCustomerVO(PayDueAmountOfCustomerVO payDueAmountOfCustomerVO)
/* 177:    */   {
/* 178:222 */     this.payDueAmountOfCustomerVO = payDueAmountOfCustomerVO;
/* 179:    */   }
/* 180:    */ }


/* Location:           C:\Users\bharti\Desktop\Chouksay\lost\action\
 * Qualified Name:     com.bst.ckt.action.PayDueAmountOfCustomerAction
 * JD-Core Version:    0.7.0.1
 */