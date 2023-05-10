/*   1:    */ package com.bst.ckt.action;
/*   2:    */ 
/*   3:    */ import com.bst.ckt.common.LoginUtil;
/*   4:    */ import com.bst.ckt.exception.RecordNotFoundException;
/*   5:    */ import com.bst.ckt.framework.user.CustomerSessionUser;
/*   6:    */ import com.bst.ckt.helper.ListHelper;
/*   7:    */ import com.bst.ckt.service.LedgerServiceImpl;
/*   8:    */ import com.bst.ckt.service.LedgerServiceInf;
/*   9:    */ import com.bst.ckt.vo.LedgerVO;
/*  10:    */ import com.opensymphony.xwork2.ActionContext;
/*  11:    */ import com.opensymphony.xwork2.ActionSupport;
/*  12:    */ import com.opensymphony.xwork2.ModelDriven;
/*  13:    */ import java.io.PrintStream;
/*  14:    */ import java.util.List;
/*  15:    */ import java.util.Map;
/*  16:    */ import javax.servlet.http.HttpServletRequest;
/*  17:    */ import javax.servlet.http.HttpServletResponse;
/*  18:    */ import org.apache.log4j.Logger;
/*  19:    */ import org.apache.struts2.interceptor.ServletRequestAware;
/*  20:    */ import org.apache.struts2.interceptor.ServletResponseAware;
/*  21:    */ import org.apache.struts2.interceptor.SessionAware;
/*  22:    */ 
/*  23:    */ public class LedgerAction
/*  24:    */   extends ActionSupport
/*  25:    */   implements ServletRequestAware, ModelDriven<LedgerVO>, ServletResponseAware, SessionAware
/*  26:    */ {
/*  27:    */   private static final long serialVersionUID = 1L;
/*  28: 38 */   private static final Logger logger = Logger.getLogger(LedgerAction.class);
/*  29: 41 */   HttpServletRequest request = (HttpServletRequest)ActionContext.getContext().get("com.opensymphony.xwork2.dispatcher.HttpServletRequest");
/*  30: 43 */   CustomerSessionUser customerSessionUser = null;
/*  31: 44 */   LedgerVO ledgerVO = new LedgerVO();
/*  32: 45 */   LedgerServiceInf ledgerServiceInf = null;
/*  33: 48 */   HttpServletResponse response = null;
/*  34: 49 */   ListHelper listHelper = null;
/*  35: 50 */   Map<String, Object> session = null;
/*  36: 51 */   List<LedgerVO> ledgerList = null;
/*  37:    */   
/*  38:    */   public String viewLedgerGrid()
/*  39:    */     throws RecordNotFoundException
/*  40:    */   {
/*  41: 56 */     this.ledgerServiceInf = new LedgerServiceImpl();
/*  42: 57 */     this.ledgerList = this.ledgerServiceInf.viewLedgerGrid();
/*  43: 58 */     return "success";
/*  44:    */   }
/*  45:    */   
/*  46:    */   public String generateLedgerPDF()
/*  47:    */     throws RecordNotFoundException
/*  48:    */   {
/*  49: 64 */     this.ledgerServiceInf = new LedgerServiceImpl();
/*  50:    */     
/*  51:    */ 
/*  52:    */ 
/*  53: 68 */     int dealerId = LoginUtil.getProcessUserId();
/*  54: 69 */     LoginUtil.setProcessUserId(dealerId);
/*  55: 70 */     System.out.println(dealerId + "KKKKKKKKKKKKKKKKKKKKKKKKKKKKKK");
/*  56: 71 */     this.ledgerServiceInf = new LedgerServiceImpl();
/*  57: 72 */     this.ledgerServiceInf.generateLedgerPDF(this.request, this.response, dealerId);
/*  58: 73 */     return null;
/*  59:    */   }
/*  60:    */   
/*  61:    */   public Map<String, Object> getSession()
/*  62:    */   {
/*  63: 81 */     return this.session;
/*  64:    */   }
/*  65:    */   
/*  66:    */   public void setSession(Map<String, Object> session)
/*  67:    */   {
/*  68: 84 */     this.session = session;
/*  69:    */   }
/*  70:    */   
/*  71:    */   public void setServletResponse(HttpServletResponse response)
/*  72:    */   {
/*  73: 88 */     this.response = response;
/*  74:    */   }
/*  75:    */   
/*  76:    */   public LedgerVO getModel()
/*  77:    */   {
/*  78: 94 */     return this.ledgerVO;
/*  79:    */   }
/*  80:    */   
/*  81:    */   public void setServletRequest(HttpServletRequest request)
/*  82:    */   {
/*  83: 98 */     this.request = request;
/*  84:    */   }
/*  85:    */   
/*  86:    */   public LedgerVO getLedgerVO()
/*  87:    */   {
/*  88:102 */     return this.ledgerVO;
/*  89:    */   }
/*  90:    */   
/*  91:    */   public void setLedgerVO(LedgerVO ledgerVO)
/*  92:    */   {
/*  93:105 */     this.ledgerVO = ledgerVO;
/*  94:    */   }
/*  95:    */   
/*  96:    */   public List<LedgerVO> getLedgerList()
/*  97:    */   {
/*  98:112 */     return this.ledgerList;
/*  99:    */   }
/* 100:    */   
/* 101:    */   public void setLedgerList(List<LedgerVO> ledgerList)
/* 102:    */   {
/* 103:119 */     this.ledgerList = ledgerList;
/* 104:    */   }
/* 105:    */   
/* 106:    */   public HttpServletRequest getRequest()
/* 107:    */   {
/* 108:124 */     return this.request;
/* 109:    */   }
/* 110:    */   
/* 111:    */   public void setRequest(HttpServletRequest request)
/* 112:    */   {
/* 113:129 */     this.request = request;
/* 114:    */   }
/* 115:    */   
/* 116:    */   public HttpServletResponse getResponse()
/* 117:    */   {
/* 118:134 */     return this.response;
/* 119:    */   }
/* 120:    */   
/* 121:    */   public void setResponse(HttpServletResponse response)
/* 122:    */   {
/* 123:139 */     this.response = response;
/* 124:    */   }
/* 125:    */ }


/* Location:           C:\Users\bharti\Desktop\Chouksay\lost\action\
 * Qualified Name:     com.bst.ckt.action.LedgerAction
 * JD-Core Version:    0.7.0.1
 */