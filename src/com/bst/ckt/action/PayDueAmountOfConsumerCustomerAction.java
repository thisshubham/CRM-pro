/*   1:    */ package com.bst.ckt.action;
/*   2:    */ 
/*   3:    */ import com.bst.ckt.dao.PayDueAmountOfConsumerDaoImpl;
/*   4:    */ import com.bst.ckt.dao.PayDueAmountOfConsumerDaoInf;
/*   5:    */ import com.bst.ckt.exception.CreateFailedException;
/*   6:    */ import com.bst.ckt.helper.ListHelper;
/*   7:    */ import com.bst.ckt.helper.Salutation;
/*   8:    */ import com.bst.ckt.service.PayDueAmountOfConsumerServiceImpl;
/*   9:    */ import com.bst.ckt.service.PayDueAmountOfConsumerServiceInf;
/*  10:    */ import com.bst.ckt.vo.PayDueAmountOfConsumerVO;
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
/*  25:    */ public class PayDueAmountOfConsumerCustomerAction
/*  26:    */   extends ActionSupport
/*  27:    */   implements ServletRequestAware, ModelDriven<PayDueAmountOfConsumerVO>, ServletResponseAware, SessionAware
/*  28:    */ {
/*  29:    */   private static final long serialVersionUID = 1L;
/*  30: 43 */   private static final Logger logger = Logger.getLogger(PayDueAmountOfConsumerCustomerAction.class);
/*  31: 45 */   PayDueAmountOfConsumerVO payDueAmountOfConsumerVO = new PayDueAmountOfConsumerVO();
/*  32: 46 */   PayDueAmountOfConsumerDaoInf payDueAmountOfConsumerDaoInf = null;
/*  33: 47 */   PayDueAmountOfConsumerServiceInf payDueAmountOfConsumerServiceInf = null;
/*  34: 48 */   ListHelper listHelper = new ListHelper();
/*  35: 50 */   HttpServletRequest request = null;
/*  36: 51 */   HttpServletResponse response = null;
/*  37:    */   private Map<Integer, String> salutationList;
/*  38:    */   private Map<Integer, String> consumerList;
/*  39: 63 */   Map<String, Object> session = null;
/*  40:    */   
/*  41:    */   public PayDueAmountOfConsumerCustomerAction()
/*  42:    */     throws Exception
/*  43:    */   {
/*  44: 69 */     this.salutationList = Salutation.getSalutationList();
/*  45: 70 */     this.consumerList = this.listHelper.consumerCustomerList();
/*  46:    */   }
/*  47:    */   
/*  48:    */   public String execute()
/*  49:    */     throws Exception
/*  50:    */   {
/*  51: 88 */     return "success";
/*  52:    */   }
/*  53:    */   
/*  54:    */   public String addConsumerTransaction()
/*  55:    */     throws CreateFailedException
/*  56:    */   {
/*  57: 93 */     this.payDueAmountOfConsumerServiceInf = new PayDueAmountOfConsumerServiceImpl();
/*  58:    */     
/*  59:    */ 
/*  60: 96 */     System.out.println(this.payDueAmountOfConsumerVO.getBillNo() + "^^^");
/*  61: 97 */     this.payDueAmountOfConsumerServiceInf.addConsumerTransaction(this.payDueAmountOfConsumerVO);
/*  62:    */     
/*  63:    */ 
/*  64:100 */     return "success";
/*  65:    */   }
/*  66:    */   
/*  67:    */   public void getConsumerCustomerDetails()
/*  68:    */     throws IOException
/*  69:    */   {
/*  70:    */     try
/*  71:    */     {
/*  72:109 */       System.out.println("hello bharti ur in jsoncode_(((((((((");
/*  73:110 */       JSONObject custDetails = new JSONObject();
/*  74:    */       
/*  75:112 */       int customerId = Integer.parseInt(this.request.getParameter("custId"));
/*  76:113 */       System.out.println("hello bharti ur in jsoncode_(((((((((" + customerId);
/*  77:114 */       this.listHelper = new ListHelper();
/*  78:115 */       custDetails = this.listHelper.getConsumerCustomerDetail(customerId);
/*  79:    */       
/*  80:117 */       PrintWriter out = this.response.getWriter();
/*  81:    */       
/*  82:119 */       out.print(custDetails);
/*  83:    */     }
/*  84:    */     catch (NullPointerException npe)
/*  85:    */     {
/*  86:122 */       System.out.println(npe);
/*  87:    */       
/*  88:124 */       npe.printStackTrace();
/*  89:    */     }
/*  90:    */     catch (Exception exception)
/*  91:    */     {
/*  92:127 */       System.out.println(exception);
/*  93:    */     }
/*  94:    */   }
/*  95:    */   
/*  96:    */   public void getTransactionDetailsByBillNo()
/*  97:    */     throws IOException
/*  98:    */   {
/*  99:    */     try
/* 100:    */     {
/* 101:134 */       this.payDueAmountOfConsumerDaoInf = new PayDueAmountOfConsumerDaoImpl();
/* 102:135 */       System.out.println("hello bharti ur in jsoncode_transaction(((((((((");
/* 103:136 */       JSONObject transactionDetails = new JSONObject();
/* 104:    */       
/* 105:138 */       String billNum = this.request.getParameter("billNo");
/* 106:139 */       this.payDueAmountOfConsumerVO.setBillNo(billNum);
/* 107:    */       
/* 108:141 */       transactionDetails = this.payDueAmountOfConsumerDaoInf.getTransactionDetailsByBillNo(billNum);
/* 109:142 */       PrintWriter out = this.response.getWriter();
/* 110:    */       
/* 111:144 */       out.print(transactionDetails);
/* 112:    */     }
/* 113:    */     catch (Exception exception)
/* 114:    */     {
/* 115:147 */       System.out.println(exception);
/* 116:    */     }
/* 117:    */   }
/* 118:    */   
/* 119:    */   public ListHelper getListHelper()
/* 120:    */   {
/* 121:155 */     return this.listHelper;
/* 122:    */   }
/* 123:    */   
/* 124:    */   public void setListHelper(ListHelper listHelper)
/* 125:    */   {
/* 126:163 */     this.listHelper = listHelper;
/* 127:    */   }
/* 128:    */   
/* 129:    */   public static Logger getLogger()
/* 130:    */   {
/* 131:172 */     return logger;
/* 132:    */   }
/* 133:    */   
/* 134:    */   public HttpServletRequest getRequest()
/* 135:    */   {
/* 136:179 */     return this.request;
/* 137:    */   }
/* 138:    */   
/* 139:    */   public void setServletResponse(HttpServletResponse response)
/* 140:    */   {
/* 141:185 */     this.response = response;
/* 142:    */   }
/* 143:    */   
/* 144:    */   public void setServletRequest(HttpServletRequest request)
/* 145:    */   {
/* 146:191 */     this.request = request;
/* 147:    */   }
/* 148:    */   
/* 149:    */   public void setSession(Map<String, Object> arg0) {}
/* 150:    */   
/* 151:    */   public Map<Integer, String> getSalutationList()
/* 152:    */   {
/* 153:205 */     return this.salutationList;
/* 154:    */   }
/* 155:    */   
/* 156:    */   public void setSalutationList(Map<Integer, String> salutationList)
/* 157:    */   {
/* 158:209 */     this.salutationList = salutationList;
/* 159:    */   }
/* 160:    */   
/* 161:    */   public Map<Integer, String> getConsumerList()
/* 162:    */   {
/* 163:213 */     return this.consumerList;
/* 164:    */   }
/* 165:    */   
/* 166:    */   public void setConsumerList(Map<Integer, String> consumerList)
/* 167:    */   {
/* 168:217 */     this.consumerList = consumerList;
/* 169:    */   }
/* 170:    */   
/* 171:    */   public PayDueAmountOfConsumerVO getModel()
/* 172:    */   {
/* 173:223 */     return this.payDueAmountOfConsumerVO;
/* 174:    */   }
/* 175:    */ }


/* Location:           C:\Users\bharti\Desktop\Chouksay\lost\action\
 * Qualified Name:     com.bst.ckt.action.PayDueAmountOfConsumerCustomerAction
 * JD-Core Version:    0.7.0.1
 */