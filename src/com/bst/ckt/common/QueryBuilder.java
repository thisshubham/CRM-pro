/*      */ package com.bst.ckt.common;
/*      */ 
/*      */ import com.bst.ckt.framework.util.DateTimeUtil;
/*      */ import com.bst.ckt.helper.AccountType;
/*      */ import com.bst.ckt.helper.NameHelper;
/*      */ import java.io.PrintStream;
/*      */ 
/*      */ public class QueryBuilder
/*      */ {
/*      */   public static String advanceSerach(int searchBy, String searchValue)
/*      */   {
/*   48 */     StringBuffer searchQuery = new StringBuffer(
/*   49 */       "SELECT LEAD_ID,COMPANY_NAME,LEAD_TITLE_REF,SALUTATION,CONTACT_PERSON,LEAD_OWNER_REF,LEAD_DATE,EXPECTED_CLOSING_DATE,LEAD_STATUS,CREATED_BY FROM TAB_LEAD_DETAILS");
/*   58 */     if ((searchBy == 0) || (searchValue == null)) {
/*   59 */       return searchQuery.toString();
/*      */     }
/*   68 */     String searchValueTemp = searchValue.trim();
/*   69 */     switch (searchBy)
/*      */     {
/*      */     case 1: 
/*   71 */       searchQuery.append(" WHERE LEAD_ID=" + 
/*   72 */         Integer.parseInt(searchValueTemp));
/*   73 */       searchQuery.append(" ");
/*   74 */       System.out.println("lead id builder " + 
/*   75 */         Integer.parseInt(searchValueTemp));
/*      */       
/*   77 */       break;
/*      */     case 2: 
/*   79 */       searchQuery.append(" WHERE COMPANY_NAME='" + searchValueTemp + 
/*   80 */         "'");
/*   81 */       searchQuery.append(" ");
/*   82 */       break;
/*      */     case 3: 
/*   84 */       searchQuery.append(" WHERE LEAD_TITLE_REF=" + 
/*   85 */         Integer.parseInt(searchValueTemp));
/*   86 */       searchQuery.append(" ");
/*   87 */       break;
/*      */     case 4: 
/*   90 */       searchQuery.append(" WHERE CONTACT_PERSON='" + searchValue + 
/*   91 */         "'");
/*   92 */       searchQuery.append(" ");
/*      */       
/*   94 */       break;
/*      */     case 5: 
/*   96 */       searchQuery.append(" WHERE LEAD_OWNER_REF=" + 
/*   97 */         Integer.parseInt(searchValueTemp));
/*   98 */       searchQuery.append(" ");
/*      */       
/*  100 */       break;
/*      */     case 6: 
/*  102 */       searchQuery.append(" WHERE LEAD_DATE='" + 
/*  103 */         DateTimeUtil.convertToDate(searchValue) + "'");
/*  104 */       searchQuery.append(" ");
/*      */       
/*  106 */       break;
/*      */     case 7: 
/*  108 */       searchQuery.append(" WHERE EXPECTED_CLOSING_DATE='" + 
/*  109 */         DateTimeUtil.convertToDate(searchValue) + "'");
/*  110 */       searchQuery.append(" ");
/*      */       
/*  112 */       break;
/*      */     case 8: 
/*  114 */       searchQuery.append(" WHERE LEAD_STATUS=" + 
/*  115 */         Integer.parseInt(searchValueTemp));
/*      */     }
/*  121 */     searchQuery.append(" GROUP BY LEAD_ID ");
/*  122 */     System.out.println("query " + searchQuery.toString());
/*  123 */     return searchQuery.toString();
/*      */   }
/*      */   
/*      */   public static String accountAdvanceSearch(int searchId, String searchValue)
/*      */     throws NumberFormatException, Exception
/*      */   {
/*  146 */     StringBuffer searchQuery = new StringBuffer(
/*  147 */       "SELECT ACCOUNT_ID,SALUTATION,CONTACT_PERSON,ACCOUNT_NAME,ACCOUNT_TYPE_REF,CONTACT_PERSON,MOBILE_NO,ACCOUNT_STATUS FROM TAB_ACCOUNT");
/*  156 */     if ((searchId == 0) || (searchValue == null)) {
/*  157 */       return searchQuery.toString();
/*      */     }
/*  166 */     String searchValueTemp = searchValue.trim();
/*  167 */     switch (searchId)
/*      */     {
/*      */     case 1: 
/*  169 */       searchQuery.append(" WHERE ACCOUNT_ID=" + 
/*  170 */         Integer.parseInt(searchValueTemp));
/*  171 */       searchQuery.append(" ");
/*  172 */       break;
/*      */     case 2: 
/*  175 */       NameHelper nameHelper = new NameHelper();
/*  176 */       searchQuery.append(" WHERE ACCOUNT_NAME='" + 
/*  177 */         nameHelper.getAccountName(
/*  178 */         Integer.parseInt(searchValueTemp)) + "'");
/*  179 */       searchQuery.append(" ");
/*  180 */       break;
/*      */     case 3: 
/*  182 */       searchQuery.append(" WHERE CONTACT_PERSON='" + searchValueTemp + 
/*  183 */         "'");
/*  184 */       searchQuery.append(" ");
/*  185 */       break;
/*      */     case 4: 
/*  187 */       searchQuery.append(" WHERE ACCOUNT_TYPE_REF=" + 
/*  188 */         AccountType.getAccountType(
/*  189 */         Integer.parseInt(searchValueTemp)));
/*  190 */       searchQuery.append(" ");
/*  191 */       break;
/*      */     case 5: 
/*  194 */       searchQuery.append(" WHERE MOBILE_NO='" + searchValueTemp + "'");
/*  195 */       searchQuery.append(" ");
/*  196 */       break;
/*      */     case 6: 
/*  198 */       searchQuery.append(" WHERE ACCOUNT_STATUS=" + 
/*  199 */         Integer.parseInt(searchValueTemp));
/*  200 */       searchQuery.append(" ");
/*      */     }
/*  206 */     searchQuery.append(" GROUP BY ACCOUNT_ID ");
/*  207 */     System.out.println("query " + searchQuery.toString());
/*  208 */     return searchQuery.toString();
/*      */   }
/*      */   
/*      */   public static String ticketAdvanceSearch(int searchId, String searchValue)
/*      */     throws NumberFormatException, Exception
/*      */   {
/*  231 */     StringBuffer searchQuery = new StringBuffer(
/*  232 */       "SELECT TICKET_ID,REF_CATEGORY,REF_TICKET_OWNER,PRIORITY,REF_CHANNEL,DUE_DATE_TIME,REF_CONTACT_NAME,REF_PRODUCT_NAME,STATUS FROM TAB_SUPPORT_TICKET");
/*  242 */     if ((searchId == 0) || (searchValue == null)) {
/*  243 */       return searchQuery.toString();
/*      */     }
/*  252 */     String searchValueTemp = searchValue.trim();
/*  253 */     switch (searchId)
/*      */     {
/*      */     case 1: 
/*  255 */       searchQuery.append(" WHERE TICKET_ID=" + 
/*  256 */         Integer.parseInt(searchValueTemp));
/*  257 */       searchQuery.append(" ");
/*  258 */       break;
/*      */     case 2: 
/*  260 */       searchQuery.append(" WHERE REF_CATEGORY=" + 
/*  261 */         Integer.parseInt(searchValueTemp));
/*  262 */       searchQuery.append(" ");
/*  263 */       break;
/*      */     case 3: 
/*  265 */       searchQuery.append(" WHERE REF_TICKET_OWNER=" + 
/*  266 */         Integer.parseInt(searchValueTemp));
/*  267 */       searchQuery.append(" ");
/*  268 */       break;
/*      */     case 4: 
/*  270 */       searchQuery.append(" WHERE PRIORITY=" + 
/*  271 */         Integer.parseInt(searchValueTemp));
/*  272 */       searchQuery.append(" ");
/*  273 */       break;
/*      */     case 5: 
/*  275 */       searchQuery.append(" WHERE REF_CHANNEL=" + 
/*  276 */         Integer.parseInt(searchValueTemp));
/*  277 */       searchQuery.append(" ");
/*  278 */       break;
/*      */     case 6: 
/*  280 */       searchQuery.append(" WHERE DUE_DATE_TIME='" + searchValueTemp + 
/*  281 */         "'");
/*  282 */       searchQuery.append(" ");
/*  283 */       break;
/*      */     case 7: 
/*  285 */       searchQuery.append(" WHERE REF_CONTACT_NAME=" + 
/*  286 */         Integer.parseInt(searchValueTemp));
/*  287 */       searchQuery.append(" ");
/*  288 */       break;
/*      */     case 8: 
/*  290 */       searchQuery.append(" WHERE REF_PRODUCT_NAME=" + 
/*  291 */         Integer.parseInt(searchValueTemp));
/*  292 */       searchQuery.append(" ");
/*  293 */       break;
/*      */     case 9: 
/*  295 */       searchQuery.append(" WHERE STATUS=" + 
/*  296 */         Integer.parseInt(searchValueTemp));
/*  297 */       searchQuery.append(" ");
/*      */     }
/*  303 */     searchQuery.append(" GROUP BY TICKET_ID ");
/*  304 */     System.out.println("query " + searchQuery.toString());
/*  305 */     return searchQuery.toString();
/*      */   }
/*      */   
/*      */   public static String faqAdvanceSearch(int searchId, String searchValue)
/*      */     throws NumberFormatException, Exception
/*      */   {
/*  328 */     StringBuffer searchQuery = new StringBuffer(
/*  329 */       "SELECT FAQ_ID,QUESTION,REF_FAQ_CATEGORY,REF_PRODUCT_NAME,REF_FAQ_OWNER,FAQ_STATUS FROM TAB_SUPPORT_FAQ");
/*  337 */     if ((searchId == 0) || (searchValue == null)) {
/*  338 */       return searchQuery.toString();
/*      */     }
/*  347 */     String searchValueTemp = searchValue.trim();
/*  348 */     switch (searchId)
/*      */     {
/*      */     case 1: 
/*  350 */       searchQuery.append(" WHERE FAQ_ID=" + 
/*  351 */         Integer.parseInt(searchValueTemp));
/*  352 */       searchQuery.append(" ");
/*  353 */       break;
/*      */     case 2: 
/*  355 */       searchQuery.append(" WHERE QUESTION='" + searchValueTemp + "'");
/*  356 */       searchQuery.append(" ");
/*  357 */       break;
/*      */     case 3: 
/*  359 */       searchQuery.append(" WHERE REF_FAQ_CATEGORY=" + 
/*  360 */         Integer.parseInt(searchValueTemp));
/*  361 */       searchQuery.append(" ");
/*  362 */       break;
/*      */     case 4: 
/*  364 */       searchQuery.append(" WHERE REF_PRODUCT_NAME=" + 
/*  365 */         Integer.parseInt(searchValueTemp));
/*  366 */       searchQuery.append(" ");
/*  367 */       break;
/*      */     case 5: 
/*  369 */       searchQuery.append(" WHERE REF_FAQ_OWNER=" + 
/*  370 */         Integer.parseInt(searchValueTemp));
/*  371 */       searchQuery.append(" ");
/*  372 */       break;
/*      */     case 6: 
/*  374 */       searchQuery.append(" WHERE FAQ_STATUS=" + 
/*  375 */         Integer.parseInt(searchValueTemp));
/*  376 */       searchQuery.append(" ");
/*      */     }
/*  382 */     searchQuery.append(" GROUP BY FAQ_ID ");
/*  383 */     System.out.println("query " + searchQuery.toString());
/*  384 */     return searchQuery.toString();
/*      */   }
/*      */   
/*      */   public static String casesAdvanceSearch(int searchId, String searchValue)
/*      */     throws NumberFormatException, Exception
/*      */   {
/*  408 */     StringBuffer searchQuery = new StringBuffer(
/*  409 */       "SELECT CASES_ID,CASES_TITLE,CONTACT_NAME,REF_CASES_PRIORITY,CASES_STATUS FROM TAB_SUPPORT_CASES");
/*  418 */     if ((searchId == 0) || (searchValue == null)) {
/*  419 */       return searchQuery.toString();
/*      */     }
/*  428 */     String searchValueTemp = searchValue.trim();
/*  429 */     switch (searchId)
/*      */     {
/*      */     case 1: 
/*  431 */       searchQuery.append(" WHERE CASES_ID=" + 
/*  432 */         Integer.parseInt(searchValueTemp));
/*  433 */       searchQuery.append(" ");
/*  434 */       break;
/*      */     case 2: 
/*  436 */       searchQuery.append(" WHERE CASES_TITLE='" + searchValueTemp + 
/*  437 */         "'");
/*  438 */       searchQuery.append(" ");
/*  439 */       break;
/*      */     case 3: 
/*  442 */       searchQuery.append(" WHERE CONTACT_NAME=" + 
/*  443 */         Integer.parseInt(searchValueTemp));
/*  444 */       searchQuery.append(" ");
/*  445 */       break;
/*      */     case 4: 
/*  447 */       searchQuery.append(" WHERE REF_CASES_PRIORITY=" + 
/*  448 */         Integer.parseInt(searchValueTemp));
/*  449 */       searchQuery.append(" ");
/*  450 */       break;
/*      */     case 5: 
/*  453 */       searchQuery.append(" WHERE CASES_STATUS=" + 
/*  454 */         Integer.parseInt(searchValueTemp));
/*  455 */       searchQuery.append(" ");
/*      */     }
/*  461 */     searchQuery.append(" GROUP BY CASES_ID ");
/*  462 */     System.out.println("query " + searchQuery.toString());
/*  463 */     return searchQuery.toString();
/*      */   }
/*      */   
/*      */   public static String serviceAdvanceSearch(int searchId, String searchValue)
/*      */     throws NumberFormatException, Exception
/*      */   {
/*  487 */     StringBuffer searchQuery = new StringBuffer(
/*  488 */       "SELECT SERVICE_CONTRACT_ID,SUBJECT,REF_ASSIGNED_TO,START_DATE,DUE_DATE,PRIORITY,STATUS FROM TAB_SUPPORT_SERVICE_CONTRACT");
/*  497 */     if ((searchId == 0) || (searchValue == null)) {
/*  498 */       return searchQuery.toString();
/*      */     }
/*  507 */     String searchValueTemp = searchValue.trim();
/*  508 */     switch (searchId)
/*      */     {
/*      */     case 1: 
/*  510 */       searchQuery.append(" WHERE SERVICE_CONTRACT_ID=" + 
/*  511 */         Integer.parseInt(searchValueTemp));
/*  512 */       searchQuery.append(" ");
/*  513 */       break;
/*      */     case 2: 
/*  515 */       searchQuery.append(" WHERE SUBJECT='" + searchValueTemp + "'");
/*  516 */       searchQuery.append(" ");
/*  517 */       break;
/*      */     case 3: 
/*  520 */       searchQuery.append(" WHERE REF_ASSIGNED_TO=" + 
/*  521 */         Integer.parseInt(searchValueTemp));
/*  522 */       searchQuery.append(" ");
/*  523 */       break;
/*      */     case 4: 
/*  526 */       searchQuery.append(" WHERE START_DATE='" + searchValueTemp + 
/*  527 */         "'");
/*  528 */       searchQuery.append(" ");
/*  529 */       break;
/*      */     case 5: 
/*  532 */       searchQuery.append(" WHERE DUE_DATE='" + searchValueTemp + "'");
/*  533 */       searchQuery.append(" ");
/*  534 */       break;
/*      */     case 6: 
/*  537 */       searchQuery.append(" WHERE PRIORITY=" + 
/*  538 */         Integer.parseInt(searchValueTemp));
/*  539 */       searchQuery.append(" ");
/*  540 */       break;
/*      */     case 7: 
/*  542 */       searchQuery.append(" WHERE STATUS=" + 
/*  543 */         Integer.parseInt(searchValueTemp));
/*  544 */       searchQuery.append(" ");
/*      */     }
/*  551 */     searchQuery.append(" GROUP BY SERVICE_CONTRACT_ID ");
/*  552 */     System.out.println("query " + searchQuery.toString());
/*  553 */     return searchQuery.toString();
/*      */   }
/*      */   
/*      */   public static String advanceSearch(int searchBy, String searchValue)
/*      */   {
/*  576 */     StringBuffer searchQuery = new StringBuffer(
/*      */     
/*  578 */       "SELECT ASSIGNMENT_ID,ASSIGN_TO,EXPECTED_CLOSING_DATES FROM TAB_ASSIGNMENT");
/*  586 */     if ((searchBy == 0) || (searchValue == null)) {
/*  587 */       return searchQuery.toString();
/*      */     }
/*  596 */     String searchValueTemp = searchValue.trim();
/*  597 */     switch (searchBy)
/*      */     {
/*      */     case 1: 
/*  599 */       searchQuery.append(" WHERE ASSIGNMENT_ID=" + 
/*  600 */         Integer.parseInt(searchValueTemp));
/*  601 */       searchQuery.append(" ");
/*  602 */       System.out.println("assignment id builder " + 
/*  603 */         Integer.parseInt(searchValueTemp));
/*      */       
/*  605 */       break;
/*      */     case 2: 
/*  607 */       searchQuery.append(" WHERE ASSIGN_TO='" + searchValueTemp + 
/*  608 */         "'");
/*  609 */       searchQuery.append(" ");
/*  610 */       break;
/*      */     case 3: 
/*  612 */       searchQuery.append(" WHERE EXPECTED_CLOSING_DATE=" + 
/*  613 */         Integer.parseInt(searchValueTemp));
/*  614 */       searchQuery.append(" ");
/*      */     }
/*  622 */     searchQuery.append(" GROUP BY ASSIGNMENT_ID ");
/*  623 */     System.out.println("query " + searchQuery.toString());
/*  624 */     return searchQuery.toString();
/*      */   }
/*      */   
/*      */   public static String advanceProductSerach(int searchId, String searchValue)
/*      */   {
/*  646 */     StringBuffer searchQuery = new StringBuffer(
/*  647 */       "SELECT PRODUCT_ID,PRODUCT_NAME,PRODUCT_CATEGORY,SALES_START_DATE,SALES_END_DATE FROM TAB_PRODUCT_DETAILS");
/*  656 */     if ((searchId == 0) || (searchValue == null)) {
/*  657 */       return searchQuery.toString();
/*      */     }
/*  666 */     String searchValueTemp = searchValue.trim();
/*  667 */     switch (searchId)
/*      */     {
/*      */     case 1: 
/*  669 */       searchQuery.append(" WHERE PRODUCT_ID=" + 
/*  670 */         Integer.parseInt(searchValueTemp));
/*  671 */       searchQuery.append(" ");
/*      */       
/*  673 */       break;
/*      */     case 2: 
/*  675 */       searchQuery.append(" WHERE PRODUCT_NAME='" + searchValueTemp + 
/*  676 */         "'");
/*  677 */       searchQuery.append(" ");
/*  678 */       break;
/*      */     case 3: 
/*  680 */       searchQuery.append(" WHERE PRODUCT_CATEGORY=" + 
/*  681 */         Integer.parseInt(searchValueTemp));
/*  682 */       searchQuery.append(" ");
/*  683 */       break;
/*      */     case 4: 
/*  686 */       searchQuery.append(" WHERE SALES_START_DATE='" + searchValue + 
/*  687 */         "'");
/*  688 */       searchQuery.append(" ");
/*      */       
/*  690 */       break;
/*      */     case 5: 
/*  692 */       searchQuery.append(" WHERE SALES_END_DATE=" + 
/*  693 */         Integer.parseInt(searchValueTemp));
/*  694 */       searchQuery.append(" ");
/*      */     }
/*  704 */     return searchQuery.toString();
/*      */   }
/*      */   
/*      */   public static String noteAdvanceSerach(int searchBy, String searchValue)
/*      */   {
/*  727 */     StringBuffer searchQuery = new StringBuffer(
/*  728 */       "SELECT NOTE_ID,NOTE_TITLE,CREATED_BY,CREATION_DATE FROM TAB_NOTE");
/*  736 */     if ((searchBy == 0) || (searchValue == null)) {
/*  737 */       return searchQuery.toString();
/*      */     }
/*  746 */     String searchValueTemp = searchValue.trim();
/*  747 */     switch (searchBy)
/*      */     {
/*      */     case 1: 
/*  750 */       searchQuery.append(" WHERE NOTE_ID=" + 
/*  751 */         Integer.parseInt(searchValueTemp));
/*  752 */       searchQuery.append(" ");
/*  753 */       break;
/*      */     case 2: 
/*  756 */       searchQuery.append(" WHERE NOTE_TITLE='" + searchValueTemp + "'");
/*  757 */       searchQuery.append(" ");
/*  758 */       break;
/*      */     case 3: 
/*  761 */       searchQuery.append(" WHERE CREATED_BY=" + 
/*  762 */         Integer.parseInt(searchValueTemp));
/*  763 */       searchQuery.append(" ");
/*  764 */       break;
/*      */     case 4: 
/*  768 */       searchQuery.append(" WHERE CREATION_DATE='" + searchValueTemp + "'");
/*  769 */       searchQuery.append(" ");
/*      */     }
/*  777 */     return searchQuery.toString();
/*      */   }
/*      */   
/*      */   public static String vendorAdvanceSerach(int searchId, String searchValue)
/*      */   {
/*  799 */     StringBuffer searchQuery = new StringBuffer(
/*  800 */       "SELECT VENDOR_ID,VENDOR_NAME,PHONE_NO,PRIMARY_EMAIL_ID,REF_VENDOR_CATEGORY,REF_ASSIGNED_TO,VENDOR_STATUS FROM TAB_VENDORS");
/*  808 */     if ((searchId == 0) || (searchValue == null)) {
/*  809 */       return searchQuery.toString();
/*      */     }
/*  818 */     String searchValueTemp = searchValue.trim();
/*  819 */     switch (searchId)
/*      */     {
/*      */     case 1: 
/*  822 */       searchQuery.append(" WHERE VENDOR_ID=" + 
/*  823 */         Integer.parseInt(searchValueTemp));
/*  824 */       searchQuery.append(" ");
/*  825 */       break;
/*      */     case 2: 
/*  828 */       searchQuery.append(" WHERE VENDOR_NAME='" + searchValueTemp + "'");
/*  829 */       searchQuery.append(" ");
/*  830 */       break;
/*      */     case 3: 
/*  833 */       searchQuery.append(" WHERE PHONE_NO=" + 
/*  834 */         Integer.parseInt(searchValueTemp));
/*  835 */       searchQuery.append(" ");
/*  836 */       break;
/*      */     case 4: 
/*  840 */       searchQuery.append(" WHERE PRIMARY_EMAIL_ID='" + searchValueTemp + "'");
/*  841 */       searchQuery.append(" ");
/*      */       
/*  843 */       break;
/*      */     case 5: 
/*  847 */       searchQuery.append(" WHERE REF_VENDOR_CATEGORY='" + searchValueTemp + "'");
/*  848 */       searchQuery.append(" ");
/*      */       
/*  850 */       break;
/*      */     case 6: 
/*  854 */       searchQuery.append(" WHERE REF_ASSIGNED_TO='" + searchValueTemp + "'");
/*  855 */       searchQuery.append(" ");
/*      */       
/*  857 */       break;
/*      */     case 7: 
/*  861 */       searchQuery.append(" WHERE VENDOR_STATUS='" + searchValueTemp + "'");
/*  862 */       searchQuery.append(" ");
/*      */     }
/*  870 */     return searchQuery.toString();
/*      */   }
/*      */   
/*      */   public static String AssignmentAdvanceSearch(int searchBy, String searchValue)
/*      */   {
/*  892 */     StringBuffer searchQuery = new StringBuffer(
/*      */     
/*  894 */       "SELECT ASSIGNMENT_ID,ASSIGN_TO,EXPECTED_CLOSING_DATE,ASSIGNMENT_STATUS FROM TAB_ASSIGNMENT");
/*  902 */     if ((searchBy == 0) || (searchValue == null)) {
/*  903 */       return searchQuery.toString();
/*      */     }
/*  912 */     String searchValueTemp = searchValue.trim();
/*  913 */     switch (searchBy)
/*      */     {
/*      */     case 1: 
/*  915 */       searchQuery.append(" WHERE ASSIGNMENT_ID=" + 
/*  916 */         Integer.parseInt(searchValueTemp));
/*  917 */       searchQuery.append(" ");
/*  918 */       break;
/*      */     case 2: 
/*  920 */       searchQuery.append(" WHERE ASSIGN_TO=" + searchValueTemp);
/*  921 */       searchQuery.append(" ");
/*  922 */       break;
/*      */     case 3: 
/*  924 */       searchQuery.append(" WHERE EXPECTED_CLOSING_DATE=" + searchValueTemp);
/*  925 */       searchQuery.append(" ");
/*  926 */       break;
/*      */     case 4: 
/*  928 */       searchQuery.append(" WHERE ASSIGNMENT_STATUS=" + searchValueTemp);
/*  929 */       searchQuery.append(" ");
/*      */     }
/*  935 */     return searchQuery.toString();
/*      */   }
/*      */   
/*      */   public static String campaignAdvanceSerach(int searchId, String searchValue)
/*      */   {
/*  957 */     StringBuffer searchQuery = new StringBuffer(
/*  958 */       "SELECT CAMPAIGN_ID,CAMPAIGN_NAME,REF_CAMPAIGN_TYPE,REF_ASSIGNED_TO,EXPECTED_REVENUE,EXPECTED_CLOSE_DATE,CAMPAIGN_STATUS FROM TAB_CAMPAIGN");
/*  966 */     if ((searchId == 0) || (searchValue == null)) {
/*  967 */       return searchQuery.toString();
/*      */     }
/*  976 */     String searchValueTemp = searchValue.trim();
/*  977 */     switch (searchId)
/*      */     {
/*      */     case 1: 
/*  980 */       searchQuery.append(" WHERE CAMPAIGN_ID=" + 
/*  981 */         Integer.parseInt(searchValueTemp));
/*  982 */       searchQuery.append(" ");
/*  983 */       break;
/*      */     case 2: 
/*  986 */       searchQuery.append(" WHERE CAMPAIGN_NAME='" + searchValueTemp + 
/*  987 */         "'");
/*  988 */       searchQuery.append(" ");
/*  989 */       break;
/*      */     case 3: 
/*  992 */       searchQuery.append(" WHERE REF_CAMPAIGN_TYPE=" + 
/*  993 */         Integer.parseInt(searchValueTemp));
/*  994 */       searchQuery.append(" ");
/*  995 */       break;
/*      */     case 4: 
/*  998 */       searchQuery.append(" WHERE REF_ASSIGNED_TO=" + 
/*  999 */         Integer.parseInt(searchValueTemp));
/* 1000 */       searchQuery.append(" ");
/*      */       
/* 1002 */       break;
/*      */     case 5: 
/* 1005 */       searchQuery.append(" WHERE EXPECTED_REVENUE='" + 
/* 1006 */         searchValueTemp + "'");
/* 1007 */       searchQuery.append(" ");
/*      */       
/* 1009 */       break;
/*      */     case 6: 
/* 1012 */       searchQuery.append(" WHERE EXPECTED_CLOSE_DATE='" + 
/* 1013 */         searchValueTemp + "'");
/* 1014 */       searchQuery.append(" ");
/*      */       
/* 1016 */       break;
/*      */     case 7: 
/* 1019 */       searchQuery.append(" WHERE CAMPAIGN_STATUS='" + searchValueTemp + 
/* 1020 */         "'");
/* 1021 */       searchQuery.append(" ");
/*      */     }
/* 1028 */     return searchQuery.toString();
/*      */   }
/*      */   
/*      */   public static String PurchaseCementAdvanceSearch(int searchId, String searchValue)
/*      */   {
/* 1036 */     StringBuffer searchQuery = new StringBuffer(
/*      */     
/* 1038 */       "SELECT * FROM TAB_PURCHASE_CEMENT_DETAIL");
/* 1046 */     if ((searchId == 0) || (searchValue == null)) {
/* 1047 */       return searchQuery.toString();
/*      */     }
/* 1056 */     String searchValueTemp = searchValue.trim();
/* 1057 */     switch (searchId)
/*      */     {
/*      */     case 1: 
/* 1059 */       searchQuery.append(" WHERE SHOP_ID=? AND PUR_CEMENT_ID=" + 
/* 1060 */         Integer.parseInt(searchValueTemp));
/* 1061 */       searchQuery.append(" ");
/* 1062 */       break;
/*      */     case 2: 
/* 1064 */       searchQuery.append(" WHERE SHOP_ID=? AND PUR_CEMENT_COMPANY_NAME='" + searchValueTemp + "'");
/* 1065 */       searchQuery.append(" ");
/* 1066 */       break;
/*      */     case 3: 
/* 1068 */       searchQuery.append(" WHERE SHOP_ID=? AND PUR_CEMENT_INVOICE_NO='" + searchValueTemp + "'");
/* 1069 */       searchQuery.append(" ");
/* 1070 */       break;
/*      */     case 4: 
/* 1072 */       searchQuery.append(" WHERE SHOP_ID=? AND PUR_CEMENT_MATERIAL_CODE='" + searchValueTemp + "'");
/* 1073 */       searchQuery.append(" ");
/* 1074 */       break;
/*      */     case 5: 
/* 1076 */       searchQuery.append(" WHERE SHOP_ID=? AND PUR_CEMENT_DEALER_REF=" + Integer.parseInt(searchValueTemp));
/* 1077 */       searchQuery.append(" ");
/* 1078 */       break;
/*      */     case 6: 
/* 1080 */       searchQuery.append(" WHERE SHOP_ID=? AND PUR_CEMENT_INVOICE_DATE='" + searchValueTemp + "'");
/* 1081 */       searchQuery.append(" ");
/*      */     }
/* 1087 */     return searchQuery.toString();
/*      */   }
/*      */   
/*      */   public static String PurchaseSteelbarAdvanceSearch(int searchId, String searchValue)
/*      */   {
/* 1095 */     StringBuffer searchQuery = new StringBuffer(
/*      */     
/* 1097 */       "SELECT * FROM TAB_PURCHASE_STEEBAR_DETAIL");
/* 1105 */     if ((searchId == 0) || (searchValue == null)) {
/* 1106 */       return searchQuery.toString();
/*      */     }
/* 1115 */     String searchValueTemp = searchValue.trim();
/* 1116 */     switch (searchId)
/*      */     {
/*      */     case 1: 
/* 1118 */       searchQuery.append(" WHERE SHOP_ID=? AND PUR_STEEBAR_ID=" + 
/* 1119 */         Integer.parseInt(searchValueTemp));
/* 1120 */       searchQuery.append(" ");
/* 1121 */       break;
/*      */     case 2: 
/* 1123 */       searchQuery.append(" WHERE SHOP_ID=? AND PUR_STEEBAR_COMPANY_NAME='" + searchValueTemp + "'");
/* 1124 */       searchQuery.append(" ");
/*      */       
/* 1126 */       break;
/*      */     case 3: 
/* 1128 */       searchQuery.append(" WHERE SHOP_ID=? AND PUR_STEEBAR_INVOICE_NO=" + searchValueTemp);
/* 1129 */       searchQuery.append(" ");
/* 1130 */       break;
/*      */     case 4: 
/* 1132 */       searchQuery.append(" WHERE SHOP_ID=? AND PUR_STEEBAR_MATERIAL_CODE=" + searchValueTemp);
/* 1133 */       searchQuery.append(" ");
/* 1134 */       break;
/*      */     case 5: 
/* 1136 */       searchQuery.append(" WHERE SHOP_ID=? AND  PUR_STEEBAR_DEALER_REF=" + Integer.parseInt(searchValueTemp));
/* 1137 */       searchQuery.append(" ");
/* 1138 */       break;
/*      */     case 6: 
/* 1140 */       searchQuery.append(" WHERE SHOP_ID=? AND PUR_STEEBAR_INVOICE_DATE='" + searchValueTemp + "'");
/* 1141 */       searchQuery.append(" ");
/*      */     }
/* 1147 */     return searchQuery.toString();
/*      */   }
/*      */   
/*      */   public static String RetailerDetailAdvanceSearch(int searchId, String searchValue)
/*      */   {
/* 1155 */     StringBuffer searchQuery = new StringBuffer(
/*      */     
/* 1157 */       "SELECT * FROM TAB_REGULAR_CUSTOMER");
/* 1165 */     if ((searchId == 0) || (searchValue == null)) {
/* 1166 */       return searchQuery.toString();
/*      */     }
/* 1175 */     String searchValueTemp = searchValue.trim();
/* 1176 */     System.out.println(searchValueTemp + "OOOOOOOOOOOOOOOOOOOOOO");
/* 1177 */     switch (searchId)
/*      */     {
/*      */     case 1: 
/* 1179 */       searchQuery.append(" WHERE REG_CUSTOMER_STATUS='ACTIVE' AND REG_CUSTOMER_ID=" + 
/* 1180 */         Integer.parseInt(searchValueTemp));
/* 1181 */       System.out.println(searchValueTemp + "OOOOOOOOOOOOOOOOOOOOOO id");
/* 1182 */       searchQuery.append(" ");
/* 1183 */       break;
/*      */     case 2: 
/* 1185 */       searchQuery.append(" WHERE REG_CUSTOMER_STATUS='ACTIVE' AND REG_CITY='" + searchValueTemp + "'");
/* 1186 */       System.out.println(searchValueTemp + "OOOOOOOOOOOOOOOOOOOOOO city");
/* 1187 */       searchQuery.append(" ");
/* 1188 */       break;
/*      */     case 3: 
/* 1190 */       searchQuery.append(" WHERE REG_CUSTOMER_STATUS='ACTIVE' AND REG_MOBILE_NO='" + searchValueTemp + "'");
/* 1191 */       System.out.println(searchValueTemp + "OOOOOOOOOOOOOOOOOOOOOO mobile");
/* 1192 */       searchQuery.append(" ");
/* 1193 */       break;
/*      */     case 4: 
/* 1195 */       searchQuery.append(" WHERE REG_CUSTOMER_STATUS='ACTIVE' AND REG_STATE='" + searchValueTemp + "'");
/* 1196 */       System.out.println(searchValueTemp + "OOOOOOOOOOOOOOOOOOOOOO state");
/* 1197 */       searchQuery.append(" ");
/*      */     }
/* 1203 */     System.out.println(searchQuery.toString() + "here is my query retailer$$$$$");
/* 1204 */     return searchQuery.toString();
/*      */   }
/*      */   
/*      */   public static String ConsumerDetailAdvanceSearch(int searchId, String searchValue)
/*      */   {
/* 1212 */     StringBuffer searchQuery = new StringBuffer(
/*      */     
/* 1214 */       "SELECT * FROM TAB_CONSUMER_CUSTOMER");
/* 1222 */     if ((searchId == 0) || (searchValue == null)) {
/* 1223 */       return searchQuery.toString();
/*      */     }
/* 1232 */     String searchValueTemp = searchValue.trim();
/* 1233 */     switch (searchId)
/*      */     {
/*      */     case 1: 
/* 1235 */       searchQuery.append(" WHERE CON_CUSTOMER_STATUS='ACTIVE' AND CON_CUSTOMER_ID=" + 
/* 1236 */         Integer.parseInt(searchValueTemp));
/* 1237 */       searchQuery.append(" ");
/* 1238 */       break;
/*      */     case 2: 
/* 1240 */       searchQuery.append(" WHERE CON_CUSTOMER_STATUS='ACTIVE' AND CON_CITY='" + searchValueTemp + "'");
/* 1241 */       searchQuery.append(" ");
/* 1242 */       break;
/*      */     case 3: 
/* 1244 */       searchQuery.append(" WHERE CON_CUSTOMER_STATUS='ACTIVE' AND CON_MOBILE_NO='" + searchValueTemp + "'");
/* 1245 */       searchQuery.append(" ");
/* 1246 */       break;
/*      */     case 4: 
/* 1248 */       searchQuery.append(" WHERE CON_CUSTOMER_STATUS='ACTIVE' AND CON_STATE='" + searchValueTemp + "'");
/* 1249 */       searchQuery.append(" ");
/*      */     }
/* 1256 */     return searchQuery.toString();
/*      */   }
/*      */   
/*      */   public static String DealerDetailAdvanaceSearch(int searchId, String searchValue)
/*      */   {
/* 1264 */     StringBuffer searchQuery = new StringBuffer(
/*      */     
/* 1266 */       "SELECT * FROM TAB_DEALER_DETAIL");
/* 1274 */     if ((searchId == 0) || (searchValue == null)) {
/* 1275 */       return searchQuery.toString();
/*      */     }
/* 1284 */     String searchValueTemp = searchValue.trim();
/* 1285 */     switch (searchId)
/*      */     {
/*      */     case 1: 
/* 1287 */       searchQuery.append(" WHERE DEALER_STATUS='ACTIVE' AND DEALER_ID=" + 
/* 1288 */         Integer.parseInt(searchValueTemp));
/* 1289 */       searchQuery.append(" ");
/* 1290 */       break;
/*      */     case 2: 
/* 1292 */       searchQuery.append(" WHERE DEALER_STATUS='ACTIVE' AND DEALER_CITY='" + searchValueTemp + "'");
/* 1293 */       searchQuery.append(" ");
/* 1294 */       break;
/*      */     case 3: 
/* 1296 */       searchQuery.append(" WHERE DEALER_STATUS='ACTIVE' AND DEALER_MOBILE_NO='" + searchValueTemp + "'");
/* 1297 */       searchQuery.append(" ");
/* 1298 */       break;
/*      */     case 4: 
/* 1300 */       searchQuery.append(" WHERE DEALER_STATUS='ACTIVE' AND DEALER_STATE='" + searchValueTemp + "'");
/* 1301 */       searchQuery.append(" ");
/*      */     }
/* 1307 */     System.out.println(searchQuery.toString() + "here is my query$$$$$");
/* 1308 */     return searchQuery.toString();
/*      */   }
/*      */   
/*      */   public static String RetailerTransactionAdvanceSearch(int searchId, String searchValue)
/*      */   {
/* 1316 */     StringBuffer searchQuery = new StringBuffer(
/*      */     
/* 1318 */       "SELECT * FROM TAB_OWNER_CUSTOMER_TRANSACTION");
/* 1326 */     if ((searchId == 0) || (searchValue == null)) {
/* 1327 */       return searchQuery.toString();
/*      */     }
/* 1336 */     String searchValueTemp = searchValue.trim();
/* 1337 */     switch (searchId)
/*      */     {
/*      */     case 1: 
/* 1339 */       searchQuery.append(" WHERE SHOP_ID=? AND CUSTOMER_TYPE='Retailer' AND CUSTOMER_TRANS_ID=" + 
/* 1340 */         Integer.parseInt(searchValueTemp));
/* 1341 */       searchQuery.append(" ");
/* 1342 */       break;
/*      */     case 2: 
/* 1344 */       searchQuery.append(" WHERE SHOP_ID=? AND CUSTOMER_TYPE='Retailer' AND CUSTOMER_TRANS_DISCRIPTION='" + searchValueTemp + "'");
/* 1345 */       searchQuery.append(" ");
/* 1346 */       break;
/*      */     case 3: 
/* 1348 */       searchQuery.append(" WHERE SHOP_ID=? AND CUSTOMER_TYPE='Retailer' AND CUSTOMER_ID_RETAILER='" + searchValueTemp + "'");
/* 1349 */       searchQuery.append(" ");
/* 1350 */       break;
/*      */     case 4: 
/* 1352 */       searchQuery.append(" WHERE SHOP_ID=? AND CUSTOMER_TYPE='Retailer' AND CUSTOMER_TRANS_PAY_MODE='" + searchValueTemp + "'");
/* 1353 */       searchQuery.append(" ");
/* 1354 */       break;
/*      */     case 5: 
/* 1357 */       searchQuery.append(" WHERE SHOP_ID=? AND CUSTOMER_TYPE='Retailer' AND CUSTOMER_TRANS_DATE='" + searchValueTemp + "'");
/* 1358 */       searchQuery.append(" ");
/*      */     }
/* 1364 */     System.out.println(searchQuery.toString() + "here is my query$$$$$");
/* 1365 */     return searchQuery.toString();
/*      */   }
/*      */   
/*      */   public static String ConsumerTransactionAdvanceSearch(int searchId, String searchValue)
/*      */   {
/* 1373 */     StringBuffer searchQuery = new StringBuffer(
/*      */     
/* 1375 */       "SELECT * FROM TAB_OWNER_CUSTOMER_TRANSACTION");
/* 1383 */     if ((searchId == 0) || (searchValue == null)) {
/* 1384 */       return searchQuery.toString();
/*      */     }
/* 1393 */     String searchValueTemp = searchValue.trim();
/* 1394 */     switch (searchId)
/*      */     {
/*      */     case 1: 
/* 1396 */       searchQuery.append(" WHERE SHOP_ID=? AND CUSTOMER_TYPE='Consumer' AND CUSTOMER_TRANS_ID=" + 
/* 1397 */         Integer.parseInt(searchValueTemp));
/* 1398 */       searchQuery.append(" ");
/* 1399 */       break;
/*      */     case 2: 
/* 1401 */       searchQuery.append(" WHERE SHOP_ID=? AND CUSTOMER_TYPE='Consumer' AND CUSTOMER_TRANS_DISCRIPTION='" + searchValueTemp + "'");
/* 1402 */       searchQuery.append(" ");
/* 1403 */       break;
/*      */     case 3: 
/* 1405 */       searchQuery.append(" WHERE SHOP_ID=? AND CUSTOMER_TYPE='Consumer' AND CUSTOMER_ID_CONSUMER='" + searchValueTemp + "'");
/* 1406 */       searchQuery.append(" ");
/* 1407 */       break;
/*      */     case 4: 
/* 1409 */       searchQuery.append(" WHERE SHOP_ID=? AND CUSTOMER_TYPE='Consumer' AND CUSTOMER_TRANS_PAY_MODE='" + searchValueTemp + "'");
/* 1410 */       searchQuery.append(" ");
/* 1411 */       break;
/*      */     case 5: 
/* 1414 */       searchQuery.append(" WHERE SHOP_ID=? AND CUSTOMER_TYPE='Consumer' AND CUSTOMER_TRANS_DATE='" + searchValueTemp + "'");
/* 1415 */       searchQuery.append(" ");
/*      */     }
/* 1421 */     System.out.println(searchQuery.toString() + "here is my query$$$$$");
/* 1422 */     return searchQuery.toString();
/*      */   }
/*      */   
/*      */   public static String DealerTransactionAdvanaceSearch(int searchId, String searchValue)
/*      */   {
/* 1430 */     StringBuffer searchQuery = new StringBuffer(
/*      */     
/* 1432 */       "SELECT * FROM TAB_DEALER_OWNER_TRANSACTION");
/* 1440 */     if ((searchId == 0) || (searchValue == null)) {
/* 1441 */       return searchQuery.toString();
/*      */     }
/* 1450 */     String searchValueTemp = searchValue.trim();
/* 1451 */     switch (searchId)
/*      */     {
/*      */     case 1: 
/* 1453 */       searchQuery.append(" WHERE SHOP_ID=? AND DEALER_TRANS_ID=" + 
/* 1454 */         Integer.parseInt(searchValueTemp));
/* 1455 */       searchQuery.append(" ");
/* 1456 */       break;
/*      */     case 2: 
/* 1458 */       searchQuery.append(" WHERE  SHOP_ID=? AND DEALER_TRANS_DISCRIPTION='" + searchValueTemp + "'");
/* 1459 */       searchQuery.append(" ");
/* 1460 */       break;
/*      */     case 3: 
/* 1462 */       searchQuery.append(" WHERE  SHOP_ID=? AND DEALER_ID_REF='" + searchValueTemp + "'");
/* 1463 */       searchQuery.append(" ");
/* 1464 */       break;
/*      */     case 4: 
/* 1466 */       searchQuery.append(" WHERE SHOP_ID=? AND DEALER_TANS_PAYMENT_MODE='" + searchValueTemp + "'");
/* 1467 */       searchQuery.append(" ");
/* 1468 */       break;
/*      */     case 5: 
/* 1471 */       searchQuery.append(" WHERE  SHOP_ID=? AND DEALER_TRANS_DATE='" + searchValueTemp + "'");
/* 1472 */       searchQuery.append(" ");
/*      */     }
/* 1479 */     return searchQuery.toString();
/*      */   }
/*      */   
/*      */   public static String InvoiceSalesAdvanceSearch(int searchId, String searchValue)
/*      */   {
/* 1487 */     StringBuffer searchQuery = new StringBuffer(
/*      */     
/* 1489 */       "SELECT * FROM TAB_SALES_DETAILS");
/* 1497 */     if ((searchId == 0) || (searchValue == null)) {
/* 1498 */       return searchQuery.toString();
/*      */     }
/* 1507 */     String searchValueTemp = searchValue.trim();
/* 1508 */     switch (searchId)
/*      */     {
/*      */     case 1: 
/* 1510 */       searchQuery.append(" WHERE  SHOP_ID=? AND SALES_ID=" + 
/* 1511 */         Integer.parseInt(searchValueTemp));
/* 1512 */       searchQuery.append(" ");
/* 1513 */       break;
/*      */     case 2: 
/* 1515 */       searchQuery.append(" WHERE SHOP_ID=? AND SALES_CUSTOMER_TYPE='" + searchValueTemp + "'");
/* 1516 */       searchQuery.append(" ");
/* 1517 */       break;
/*      */     case 3: 
/* 1519 */       searchQuery.append(" WHERE SHOP_ID=? AND SALES_DATE='" + searchValueTemp + "'");
/* 1520 */       searchQuery.append(" ");
/* 1521 */       break;
/*      */     case 4: 
/* 1523 */       searchQuery.append(" WHERE SHOP_ID=? AND SALES_PAYMENT_MODE='" + searchValueTemp + "'");
/* 1524 */       searchQuery.append(" ");
/* 1525 */       break;
/*      */     case 5: 
/* 1528 */       searchQuery.append(" WHERE SHOP_ID=? AND SALES_CUSTOMER_ID_REF=" + Integer.parseInt(searchValueTemp));
/* 1529 */       searchQuery.append(" ");
/* 1530 */       break;
/*      */     case 6: 
/* 1532 */       searchQuery.append(" WHERE SHOP_ID=? AND SALES_PAYMENT_ANSWER='" + searchValueTemp + "'");
/* 1533 */       searchQuery.append(" ");
/* 1534 */       break;
/*      */     case 7: 
/* 1536 */       searchQuery.append(" WHERE SHOP_ID=? AND UNIQUE_ID=" + Integer.parseInt(searchValueTemp));
/* 1537 */       searchQuery.append(" ");
/*      */     }
/* 1541 */     return searchQuery.toString();
/*      */   }
/*      */   
/*      */   public static String StockAdvanceSearch(int searchId, String searchValue)
/*      */   {
/* 1548 */     StringBuffer searchQuery = new StringBuffer(
/*      */     
/* 1550 */       "SELECT * FROM TAB_STOCK_DETAILS");
/* 1558 */     if ((searchId == 0) || (searchValue == null)) {
/* 1559 */       return searchQuery.toString();
/*      */     }
/* 1568 */     String searchValueTemp = searchValue.trim();
/* 1569 */     switch (searchId)
/*      */     {
/*      */     case 1: 
/* 1571 */       searchQuery.append(" WHERE SHOP_ID=? AND STOCK_ID=" + 
/* 1572 */         Integer.parseInt(searchValueTemp));
/* 1573 */       searchQuery.append(" ");
/* 1574 */       break;
/*      */     case 2: 
/* 1576 */       searchQuery.append(" WHERE SHOP_ID=? AND STOCK_PRODUCT_TYPE=" + Integer.parseInt(searchValueTemp));
/* 1577 */       searchQuery.append(" ");
/* 1578 */       break;
/*      */     case 3: 
/* 1580 */       searchQuery.append(" WHERE SHOP_ID=? AND  STOCK_CATEGORY=" + Integer.parseInt(searchValueTemp));
/* 1581 */       searchQuery.append(" ");
/*      */     }
/* 1586 */     return searchQuery.toString();
/*      */   }
/*      */   
/*      */   public static String PurchaseCementAdvanceSearchForAdmin(int searchId, String searchValue)
/*      */   {
/* 1594 */     StringBuffer searchQuery = new StringBuffer(
/*      */     
/* 1596 */       "SELECT * FROM TAB_PURCHASE_CEMENT_DETAIL");
/* 1604 */     if ((searchId == 0) || (searchValue == null)) {
/* 1605 */       return searchQuery.toString();
/*      */     }
/* 1614 */     String searchValueTemp = searchValue.trim();
/* 1615 */     switch (searchId)
/*      */     {
/*      */     case 1: 
/* 1617 */       searchQuery.append(" WHERE PUR_CEMENT_ID=" + 
/* 1618 */         Integer.parseInt(searchValueTemp));
/* 1619 */       searchQuery.append(" ");
/* 1620 */       break;
/*      */     case 2: 
/* 1622 */       searchQuery.append(" WHERE  PUR_CEMENT_COMPANY_NAME='" + searchValueTemp + "'");
/* 1623 */       searchQuery.append(" ");
/* 1624 */       break;
/*      */     case 3: 
/* 1626 */       searchQuery.append(" WHERE  PUR_CEMENT_INVOICE_NO='" + searchValueTemp + "'");
/* 1627 */       searchQuery.append(" ");
/* 1628 */       break;
/*      */     case 4: 
/* 1630 */       searchQuery.append(" WHERE  PUR_CEMENT_MATERIAL_CODE='" + searchValueTemp + "'");
/* 1631 */       searchQuery.append(" ");
/* 1632 */       break;
/*      */     case 5: 
/* 1634 */       searchQuery.append(" WHERE  PUR_CEMENT_DEALER_REF=" + Integer.parseInt(searchValueTemp));
/* 1635 */       searchQuery.append(" ");
/* 1636 */       break;
/*      */     case 6: 
/* 1638 */       searchQuery.append(" WHERE  PUR_CEMENT_INVOICE_DATE='" + searchValueTemp + "'");
/* 1639 */       searchQuery.append(" ");
/*      */     }
/* 1645 */     return searchQuery.toString();
/*      */   }
/*      */   
/*      */   public static String PurchaseSteelbarAdvanceSearchForAdmin(int searchId, String searchValue)
/*      */   {
/* 1655 */     StringBuffer searchQuery = new StringBuffer(
/*      */     
/* 1657 */       "SELECT * FROM TAB_PURCHASE_STEEBAR_DETAIL");
/* 1665 */     if ((searchId == 0) || (searchValue == null)) {
/* 1666 */       return searchQuery.toString();
/*      */     }
/* 1675 */     String searchValueTemp = searchValue.trim();
/* 1676 */     switch (searchId)
/*      */     {
/*      */     case 1: 
/* 1678 */       searchQuery.append(" WHERE PUR_STEEBAR_ID=" + 
/* 1679 */         Integer.parseInt(searchValueTemp));
/* 1680 */       searchQuery.append(" ");
/* 1681 */       break;
/*      */     case 2: 
/* 1683 */       searchQuery.append(" WHERE PUR_STEEBAR_COMPANY_NAME='" + searchValueTemp + "'");
/* 1684 */       searchQuery.append(" ");
/*      */       
/* 1686 */       break;
/*      */     case 3: 
/* 1688 */       searchQuery.append(" WHERE  PUR_STEEBAR_INVOICE_NO=" + searchValueTemp);
/* 1689 */       searchQuery.append(" ");
/* 1690 */       break;
/*      */     case 4: 
/* 1692 */       searchQuery.append(" WHERE PUR_STEEBAR_MATERIAL_CODE=" + searchValueTemp);
/* 1693 */       searchQuery.append(" ");
/* 1694 */       break;
/*      */     case 5: 
/* 1696 */       searchQuery.append(" WHERE  PUR_STEEBAR_DEALER_REF=" + Integer.parseInt(searchValueTemp));
/* 1697 */       searchQuery.append(" ");
/* 1698 */       break;
/*      */     case 6: 
/* 1700 */       searchQuery.append(" WHERE PUR_STEEBAR_INVOICE_DATE='" + searchValueTemp + "'");
/* 1701 */       searchQuery.append(" ");
/*      */     }
/* 1707 */     return searchQuery.toString();
/*      */   }
/*      */   
/*      */   public static String StockAdvanceSearchForAdmin(int searchId, String searchValue)
/*      */   {
/* 1714 */     StringBuffer searchQuery = new StringBuffer(
/*      */     
/* 1716 */       "SELECT * FROM TAB_STOCK_DETAILS");
/* 1724 */     if ((searchId == 0) || (searchValue == null)) {
/* 1725 */       return searchQuery.toString();
/*      */     }
/* 1734 */     String searchValueTemp = searchValue.trim();
/* 1735 */     switch (searchId)
/*      */     {
/*      */     case 1: 
/* 1737 */       searchQuery.append(" WHERE STOCK_ID=" + 
/* 1738 */         Integer.parseInt(searchValueTemp));
/* 1739 */       searchQuery.append(" ");
/* 1740 */       break;
/*      */     case 2: 
/* 1742 */       searchQuery.append(" WHERE STOCK_PRODUCT_TYPE=" + Integer.parseInt(searchValueTemp));
/* 1743 */       searchQuery.append(" ");
/* 1744 */       break;
/*      */     case 3: 
/* 1746 */       searchQuery.append(" WHERE  STOCK_CATEGORY=" + Integer.parseInt(searchValueTemp));
/* 1747 */       searchQuery.append(" ");
/*      */     }
/* 1752 */     return searchQuery.toString();
/*      */   }
/*      */   
/*      */   public static String DealerTransactionAdvanaceSearchForAdmin(int searchId, String searchValue)
/*      */   {
/* 1760 */     StringBuffer searchQuery = new StringBuffer(
/*      */     
/* 1762 */       "SELECT * FROM TAB_DEALER_OWNER_TRANSACTION");
/* 1770 */     if ((searchId == 0) || (searchValue == null)) {
/* 1771 */       return searchQuery.toString();
/*      */     }
/* 1780 */     String searchValueTemp = searchValue.trim();
/* 1781 */     switch (searchId)
/*      */     {
/*      */     case 1: 
/* 1783 */       searchQuery.append(" WHERE  DEALER_TRANS_ID=" + 
/* 1784 */         Integer.parseInt(searchValueTemp));
/* 1785 */       searchQuery.append(" ");
/* 1786 */       break;
/*      */     case 2: 
/* 1788 */       searchQuery.append(" WHERE  DEALER_TRANS_DISCRIPTION='" + searchValueTemp + "'");
/* 1789 */       searchQuery.append(" ");
/* 1790 */       break;
/*      */     case 3: 
/* 1792 */       searchQuery.append(" WHERE DEALER_ID_REF='" + searchValueTemp + "'");
/* 1793 */       searchQuery.append(" ");
/* 1794 */       break;
/*      */     case 4: 
/* 1796 */       searchQuery.append(" WHERE DEALER_TANS_PAYMENT_MODE='" + searchValueTemp + "'");
/* 1797 */       searchQuery.append(" ");
/* 1798 */       break;
/*      */     case 5: 
/* 1801 */       searchQuery.append(" WHERE DEALER_TRANS_DATE='" + searchValueTemp + "'");
/* 1802 */       searchQuery.append(" ");
/*      */     }
/* 1809 */     return searchQuery.toString();
/*      */   }
/*      */   
/*      */   public static String RetailerTransactionAdvanceSearchForAdmin(int searchId, String searchValue)
/*      */   {
/* 1818 */     StringBuffer searchQuery = new StringBuffer(
/*      */     
/* 1820 */       "SELECT * FROM TAB_OWNER_CUSTOMER_TRANSACTION");
/* 1828 */     if ((searchId == 0) || (searchValue == null)) {
/* 1829 */       return searchQuery.toString();
/*      */     }
/* 1838 */     String searchValueTemp = searchValue.trim();
/* 1839 */     switch (searchId)
/*      */     {
/*      */     case 1: 
/* 1841 */       searchQuery.append(" WHERE CUSTOMER_TYPE='Retailer' AND CUSTOMER_TRANS_ID=" + 
/* 1842 */         Integer.parseInt(searchValueTemp));
/* 1843 */       searchQuery.append(" ");
/* 1844 */       break;
/*      */     case 2: 
/* 1846 */       searchQuery.append(" WHERE CUSTOMER_TYPE='Retailer' AND CUSTOMER_TRANS_DISCRIPTION='" + searchValueTemp + "'");
/* 1847 */       searchQuery.append(" ");
/* 1848 */       break;
/*      */     case 3: 
/* 1850 */       searchQuery.append(" WHERE CUSTOMER_TYPE='Retailer' AND CUSTOMER_ID_RETAILER='" + searchValueTemp + "'");
/* 1851 */       searchQuery.append(" ");
/* 1852 */       break;
/*      */     case 4: 
/* 1854 */       searchQuery.append(" WHERE  CUSTOMER_TYPE='Retailer' AND CUSTOMER_TRANS_PAY_MODE='" + searchValueTemp + "'");
/* 1855 */       searchQuery.append(" ");
/* 1856 */       break;
/*      */     case 5: 
/* 1859 */       searchQuery.append(" WHERE  CUSTOMER_TYPE='Retailer' AND CUSTOMER_TRANS_DATE='" + searchValueTemp + "'");
/* 1860 */       searchQuery.append(" ");
/*      */     }
/* 1866 */     System.out.println(searchQuery.toString() + "here is my query$$$$$");
/* 1867 */     return searchQuery.toString();
/*      */   }
/*      */   
/*      */   public static String ConsumerTransactionAdvanceSearchForAdmin(int searchId, String searchValue)
/*      */   {
/* 1874 */     StringBuffer searchQuery = new StringBuffer(
/*      */     
/* 1876 */       "SELECT * FROM TAB_OWNER_CUSTOMER_TRANSACTION");
/* 1884 */     if ((searchId == 0) || (searchValue == null)) {
/* 1885 */       return searchQuery.toString();
/*      */     }
/* 1894 */     String searchValueTemp = searchValue.trim();
/* 1895 */     switch (searchId)
/*      */     {
/*      */     case 1: 
/* 1897 */       searchQuery.append(" WHERE CUSTOMER_TYPE='Consumer' AND CUSTOMER_TRANS_ID=" + 
/* 1898 */         Integer.parseInt(searchValueTemp));
/* 1899 */       searchQuery.append(" ");
/* 1900 */       break;
/*      */     case 2: 
/* 1902 */       searchQuery.append(" WHERE CUSTOMER_TYPE='Consumer' AND CUSTOMER_TRANS_DISCRIPTION='" + searchValueTemp + "'");
/* 1903 */       searchQuery.append(" ");
/* 1904 */       break;
/*      */     case 3: 
/* 1906 */       searchQuery.append(" WHERE CUSTOMER_TYPE='Consumer' AND CUSTOMER_ID_CONSUMER='" + searchValueTemp + "'");
/* 1907 */       searchQuery.append(" ");
/* 1908 */       break;
/*      */     case 4: 
/* 1910 */       searchQuery.append(" WHERE CUSTOMER_TYPE='Consumer' AND CUSTOMER_TRANS_PAY_MODE='" + searchValueTemp + "'");
/* 1911 */       searchQuery.append(" ");
/* 1912 */       break;
/*      */     case 5: 
/* 1915 */       searchQuery.append(" WHERE CUSTOMER_TYPE='Consumer' AND CUSTOMER_TRANS_DATE='" + searchValueTemp + "'");
/* 1916 */       searchQuery.append(" ");
/*      */     }
/* 1922 */     System.out.println(searchQuery.toString() + "here is my query$$$$$");
/* 1923 */     return searchQuery.toString();
/*      */   }
/*      */   
/*      */   public static String InvoiceSalesAdvanceSearchForAdmin(int searchId, String searchValue)
/*      */   {
/* 1931 */     StringBuffer searchQuery = new StringBuffer(
/*      */     
/* 1933 */       "SELECT * FROM TAB_SALES_DETAILS");
/* 1941 */     if ((searchId == 0) || (searchValue == null)) {
/* 1942 */       return searchQuery.toString();
/*      */     }
/* 1951 */     String searchValueTemp = searchValue.trim();
/* 1952 */     switch (searchId)
/*      */     {
/*      */     case 1: 
/* 1954 */       searchQuery.append(" WHERE SALES_ID=" + 
/* 1955 */         Integer.parseInt(searchValueTemp));
/* 1956 */       searchQuery.append(" ");
/* 1957 */       break;
/*      */     case 2: 
/* 1959 */       searchQuery.append(" WHERE SALES_CUSTOMER_TYPE='" + searchValueTemp + "'");
/* 1960 */       searchQuery.append(" ");
/* 1961 */       break;
/*      */     case 3: 
/* 1963 */       searchQuery.append(" WHERE SALES_DATE='" + searchValueTemp + "'");
/* 1964 */       searchQuery.append(" ");
/* 1965 */       break;
/*      */     case 4: 
/* 1967 */       searchQuery.append(" WHERE SALES_PAYMENT_MODE='" + searchValueTemp + "'");
/* 1968 */       searchQuery.append(" ");
/* 1969 */       break;
/*      */     case 5: 
/* 1972 */       searchQuery.append(" WHERE SALES_CUSTOMER_ID_REF=" + Integer.parseInt(searchValueTemp));
/* 1973 */       searchQuery.append(" ");
/* 1974 */       break;
/*      */     case 6: 
/* 1976 */       searchQuery.append(" WHERE  SALES_PAYMENT_ANSWER='" + searchValueTemp + "'");
/* 1977 */       searchQuery.append(" ");
/* 1978 */       break;
/*      */     case 7: 
/* 1980 */       searchQuery.append(" WHERE  UNIQUE_ID=" + Integer.parseInt(searchValueTemp));
/* 1981 */       searchQuery.append(" ");
/*      */     }
/* 1985 */     return searchQuery.toString();
/*      */   }



public static String getPurchasePesticideAdvanceSearchList(int searchId,
		String searchValue) {
	/**
	 * StringBuffer object is created to store the query
	 */
	StringBuffer searchQuery = new StringBuffer(
			
			"SELECT * FROM TAB_PURCHASE_PESTICIDES_DETAIL");
	/**
	 * this condition is used in case there is 0 or null value available in
	 * searchBy & searchValue respectively.
	 */

	String searchValueTemp;

	if (searchId == 0 || searchValue == null) {
		return searchQuery.toString();
	}

	/**
	 * else condition is used in case there value available for searchBy &
	 * searchValue respectively.
	 */

	else {
		searchValueTemp = searchValue.trim();
		switch (searchId) {
		case 1:
			searchQuery.append(" WHERE PUR_PESTICIDE_ID="
					+ Integer.parseInt(searchValueTemp));
			searchQuery.append(" ");
			break;
		case 2:
			searchQuery.append(" WHERE PUR_PESTICIDE_COMPANY_NAME='" + searchValueTemp+"'");
			searchQuery.append(" ");
			
			break;
		case 3:
			searchQuery.append(" WHERE  PUR_PESTICIDE_INVOICE_NO="+ searchValueTemp);
			searchQuery.append(" ");
			break;
		case 4:
			searchQuery.append(" WHERE PUR_PESTICIDE_MATERIAL_CODE="+ searchValueTemp);
			searchQuery.append(" ");
			break;
		case 5:
			searchQuery.append(" WHERE  PUR_PESTICIDE_DEALER_REF="+ Integer.parseInt(searchValueTemp));
			searchQuery.append(" ");
			break;
		case 6:
			searchQuery.append(" WHERE PUR_PESTICIDE_INVOICE_DATE='"+ searchValueTemp+"'");
			searchQuery.append(" ");
			break;
}
	}
	return searchQuery.toString();
}

public static String getPurchaseWallPaintForAdvanceSearch(int searchId,
		String searchValue) {
	/**
	 * StringBuffer object is created to store the query
	 */
	StringBuffer searchQuery = new StringBuffer(
			
			"SELECT * FROM TAB_PURCHASE_WALLPAINT");
	/**
	 * this condition is used in case there is 0 or null value available in
	 * searchBy & searchValue respectively.
	 */

	String searchValueTemp;

	if (searchId == 0 || searchValue == null) {
		return searchQuery.toString();
	}

	/**
	 * else condition is used in case there value available for searchBy &
	 * searchValue respectively.
	 */

	else {
		searchValueTemp = searchValue.trim();
		switch (searchId) {
		case 1:
			searchQuery.append(" WHERE PUR_WALLPAINT_ID="
					+ Integer.parseInt(searchValueTemp));
			searchQuery.append(" ");
			break;
		case 2:
			searchQuery.append(" WHERE PUR_WALLPAINT_COMPANY='" + searchValueTemp+"'");
			searchQuery.append(" ");
			
			break;
		case 3:
			searchQuery.append(" WHERE  PUR_WALLPAINT_INVOICE_NO="+ searchValueTemp);
			searchQuery.append(" ");
			break;
		case 4:
			searchQuery.append(" WHERE PUR_WALLPAINT_MATERIAL_CODE="+ searchValueTemp);
			searchQuery.append(" ");
			break;
		case 5:
			searchQuery.append(" WHERE  PUR_WALLPAINT_DEALER_REF="+ Integer.parseInt(searchValueTemp));
			searchQuery.append(" ");
			break;
		case 6:
			searchQuery.append(" WHERE PUR_WALLPAINT_INVOICE_DATE='"+ searchValueTemp+"'");
			searchQuery.append(" ");
			break;
}
	}
	return searchQuery.toString();
}



/*      */ }


/* Location:           C:\Users\bharti\Desktop\Chouksay\lost\
 * Qualified Name:     com.bst.ckt.common.QueryBuilder
 * JD-Core Version:    0.7.0.1
 */