/*      */ package com.bst.ckt.helper;
import com.bst.ckt.common.QueryMaker;
/*      */ 
/*      */ import com.bst.ckt.framework.db.JdbcDAOSupport;
/*      */ import com.bst.ckt.framework.db.JdbcHelper;
/*      */ import java.io.PrintStream;
/*      */ import java.sql.Connection;
/*      */ import java.sql.PreparedStatement;
/*      */ import java.sql.ResultSet;
/*      */ import java.sql.SQLException;
/*      */ import org.apache.log4j.Logger;
/*      */ 
/*      */ public class NameHelper
/*      */   extends JdbcDAOSupport
/*      */ {
/*   58 */   private static final Logger log = Logger.getLogger(NameHelper.class);
/*   59 */   Connection connection = null;
/*   60 */   PreparedStatement preparedStatement = null;
/*   61 */   ResultSet resultSet = null;
/*      */   
/*      */   public String getCountryName(int CountryId)
/*      */     throws Exception
/*      */   {
/*   82 */     String CountryName = null;
/*      */     try
/*      */     {
/*   85 */       this.connection = getConnection();
/*   86 */       this.preparedStatement = this.connection
/*   87 */         .prepareStatement("SELECT COUNTRY_DISPLAY_NAME FROM TAB_COUNTRY WHERE COUNTRY_ID=?");
/*   88 */       this.preparedStatement.setInt(1, CountryId);
/*   89 */       this.resultSet = this.preparedStatement.executeQuery();
/*   91 */       while (this.resultSet.next()) {
/*   92 */         CountryName = this.resultSet.getString("COUNTRY_DISPLAY_NAME");
/*      */       }
/*      */     }
/*      */     catch (SQLException sqlException)
/*      */     {
/*   96 */       log.error(
/*   97 */         ListHelper.class + 
/*   98 */         ": Error:- While preparing statement to get CountryName from database.", 
/*   99 */         sqlException);
/*      */     }
/*      */     catch (Exception exception)
/*      */     {
/*  102 */       log.error(ListHelper.class + 
/*  103 */         ": Error:- While getting connection for database.", 
/*  104 */         exception);
/*      */     }
/*      */     finally
/*      */     {
/*  106 */       JdbcHelper.closeResultSet(this.resultSet);
/*  107 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/*  108 */       JdbcHelper.closeConnection(this.connection);
/*      */     }
/*  110 */     return CountryName;
/*      */   }
/*      */   
/*      */   public String getCompanyName(int companyId)
/*      */     throws Exception
/*      */   {
/*  132 */     String comapnyName = null;
/*      */     try
/*      */     {
/*  135 */       this.connection = getConnection();
/*  136 */       this.preparedStatement = this.connection
/*  137 */         .prepareStatement("SELECT COMPANY_NAME FROM TAB_COMPANY_DETAILS WHERE COMPANY_ID=?");
/*  138 */       this.preparedStatement.setInt(1, companyId);
/*  139 */       this.resultSet = this.preparedStatement.executeQuery();
/*  141 */       while (this.resultSet.next()) {
/*  142 */         comapnyName = this.resultSet.getString("COMPANY_NAME");
/*      */       }
/*      */     }
/*      */     catch (SQLException sqlException)
/*      */     {
/*  146 */       log.error(
/*  147 */         ListHelper.class + 
/*  148 */         ": Error:- While preparing statement to get companyName from database.", 
/*  149 */         sqlException);
/*      */     }
/*      */     catch (Exception exception)
/*      */     {
/*  152 */       log.error(ListHelper.class + 
/*  153 */         ": Error:- While getting connection for database.", 
/*  154 */         exception);
/*      */     }
/*      */     finally
/*      */     {
/*  156 */       JdbcHelper.closeResultSet(this.resultSet);
/*  157 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/*  158 */       JdbcHelper.closeConnection(this.connection);
/*      */     }
/*  160 */     return comapnyName;
/*      */   }
/*      */   
/*      */   public String getCompanyTypeName(int companyTypeId)
/*      */     throws Exception
/*      */   {
/*  182 */     String comapanyTypeName = null;
/*      */     try
/*      */     {
/*  185 */       this.connection = getConnection();
/*  186 */       this.preparedStatement = this.connection
/*  187 */         .prepareStatement("SELECT COMPANY_TYPE_NAME FROM TAB_COMPANY_TYPE WHERE COMPANY_TYPE_ID=?");
/*  188 */       this.preparedStatement.setInt(1, companyTypeId);
/*  189 */       this.resultSet = this.preparedStatement.executeQuery();
/*  191 */       while (this.resultSet.next()) {
/*  192 */         comapanyTypeName = this.resultSet.getString("COMPANY_TYPE_NAME");
/*      */       }
/*      */     }
/*      */     catch (SQLException sqlException)
/*      */     {
/*  196 */       log.error(
/*  197 */         ListHelper.class + 
/*  198 */         ": Error:- While preparing statement to get companyTypeName from database.", 
/*  199 */         sqlException);
/*      */     }
/*      */     catch (Exception exception)
/*      */     {
/*  202 */       log.error(ListHelper.class + 
/*  203 */         ": Error:- While getting connection for database.", 
/*  204 */         exception);
/*      */     }
/*      */     finally
/*      */     {
/*  206 */       JdbcHelper.closeResultSet(this.resultSet);
/*  207 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/*  208 */       JdbcHelper.closeConnection(this.connection);
/*      */     }
/*  210 */     return comapanyTypeName;
/*      */   }
/*      */   
/*      */   public String getCompanyCategoryName(int companyCategoryId)
/*      */     throws Exception
/*      */   {
/*  233 */     String companyCategoryName = null;
/*      */     try
/*      */     {
/*  236 */       this.connection = getConnection();
/*  237 */       this.preparedStatement = this.connection
/*  238 */         .prepareStatement("SELECT COMPANY_CATEGORY_NAME FROM TAB_COMPANY_CATEGORY WHERE COMPANY_CATEGORY_ID=?");
/*  239 */       this.preparedStatement.setInt(1, companyCategoryId);
/*  240 */       this.resultSet = this.preparedStatement.executeQuery();
/*  242 */       while (this.resultSet.next()) {
/*  243 */         companyCategoryName = 
/*  244 */           this.resultSet.getString("COMPANY_CATEGORY_NAME");
/*      */       }
/*      */     }
/*      */     catch (SQLException sqlException)
/*      */     {
/*  248 */       log.error(
/*  249 */         ListHelper.class + 
/*  250 */         ": Error:- While preparing statement to get companyCategoryName from database.", 
/*  251 */         sqlException);
/*      */     }
/*      */     catch (Exception exception)
/*      */     {
/*  254 */       log.error(ListHelper.class + 
/*  255 */         ": Error:- While getting connection for database.", 
/*  256 */         exception);
/*      */     }
/*      */     finally
/*      */     {
/*  258 */       JdbcHelper.closeResultSet(this.resultSet);
/*  259 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/*  260 */       JdbcHelper.closeConnection(this.connection);
/*      */     }
/*  262 */     return companyCategoryName;
/*      */   }
/*      */   
/*      */   public String getCompanySectorName(int companySectorId)
/*      */     throws Exception
/*      */   {
/*  284 */     String companySectorName = null;
/*      */     try
/*      */     {
/*  287 */       this.connection = getConnection();
/*  288 */       this.preparedStatement = this.connection
/*  289 */         .prepareStatement("SELECT COMPANY_SECTOR_NAME FROM TAB_COMPANY_SECTOR WHERE COMPANY_SECTOR_ID=?");
/*  290 */       this.preparedStatement.setInt(1, companySectorId);
/*  291 */       this.resultSet = this.preparedStatement.executeQuery();
/*  293 */       while (this.resultSet.next()) {
/*  294 */         companySectorName = this.resultSet.getString("COMPANY_SECTOR_NAME");
/*      */       }
/*      */     }
/*      */     catch (SQLException sqlException)
/*      */     {
/*  298 */       log.error(
/*  299 */         ListHelper.class + 
/*  300 */         ": Error:- While preparing statement to get companySectorName from database.", 
/*  301 */         sqlException);
/*      */     }
/*      */     catch (Exception exception)
/*      */     {
/*  304 */       log.error(ListHelper.class + 
/*  305 */         ": Error:- While getting connection for database.", 
/*  306 */         exception);
/*      */     }
/*      */     finally
/*      */     {
/*  308 */       JdbcHelper.closeResultSet(this.resultSet);
/*  309 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/*  310 */       JdbcHelper.closeConnection(this.connection);
/*      */     }
/*  312 */     return companySectorName;
/*      */   }
/*      */   
/*      */   public String getLeadTitle(int leadTitleId)
/*      */     throws Exception
/*      */   {
/*  334 */     String leadTitleSubject = null;
/*      */     try
/*      */     {
/*  337 */       this.connection = getConnection();
/*  338 */       this.preparedStatement = this.connection
/*  339 */         .prepareStatement("SELECT LEAD_TITLE_SUBJECT FROM TAB_LEAD_TITLE WHERE LEAD_TITLE_ID=?");
/*  340 */       this.preparedStatement.setInt(1, leadTitleId);
/*  341 */       this.resultSet = this.preparedStatement.executeQuery();
/*  343 */       while (this.resultSet.next()) {
/*  344 */         leadTitleSubject = this.resultSet.getString("LEAD_TITLE_SUBJECT");
/*      */       }
/*      */     }
/*      */     catch (SQLException sqlException)
/*      */     {
/*  348 */       log.error(
/*  349 */         ListHelper.class + 
/*  350 */         ": Error:- While preparing statement to get leadTitleSubject from database.", 
/*  351 */         sqlException);
/*      */     }
/*      */     catch (Exception exception)
/*      */     {
/*  354 */       log.error(ListHelper.class + 
/*  355 */         ": Error:- While getting connection for database.", 
/*  356 */         exception);
/*      */     }
/*      */     finally
/*      */     {
/*  358 */       JdbcHelper.closeResultSet(this.resultSet);
/*  359 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/*  360 */       JdbcHelper.closeConnection(this.connection);
/*      */     }
/*  362 */     return leadTitleSubject;
/*      */   }
/*      */   
/*      */   public String getLeadSource(int leadTitleId)
/*      */     throws Exception
/*      */   {
/*  384 */     String leadTitleSubject = null;
/*      */     try
/*      */     {
/*  387 */       this.connection = getConnection();
/*  388 */       this.preparedStatement = this.connection
/*  389 */         .prepareStatement("SELECT LEAD_TITLE_SUBJECT FROM TAB_LEAD_TITLE WHERE LEAD_TITLE_ID=?");
/*  390 */       this.preparedStatement.setInt(1, leadTitleId);
/*  391 */       this.resultSet = this.preparedStatement.executeQuery();
/*  393 */       while (this.resultSet.next()) {
/*  394 */         leadTitleSubject = this.resultSet.getString("LEAD_TITLE_SUBJECT");
/*      */       }
/*      */     }
/*      */     catch (SQLException sqlException)
/*      */     {
/*  398 */       log.error(
/*  399 */         ListHelper.class + 
/*  400 */         ": Error:- While preparing statement to get leadTitleSubject from database.", 
/*  401 */         sqlException);
/*      */     }
/*      */     catch (Exception exception)
/*      */     {
/*  404 */       log.error(ListHelper.class + 
/*  405 */         ": Error:- While getting connection for database.", 
/*  406 */         exception);
/*      */     }
/*      */     finally
/*      */     {
/*  408 */       JdbcHelper.closeResultSet(this.resultSet);
/*  409 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/*  410 */       JdbcHelper.closeConnection(this.connection);
/*      */     }
/*  412 */     return leadTitleSubject;
/*      */   }
/*      */   
/*      */   public String getLeadStatus(int leadStatusId)
/*      */     throws Exception
/*      */   {
/*  434 */     String leadStatusName = null;
/*      */     try
/*      */     {
/*  437 */       this.connection = getConnection();
/*  438 */       this.preparedStatement = this.connection
/*  439 */         .prepareStatement("SELECT LEAD_STATUS_NAME FROM TAB_LEAD_STATUS WHERE LEAD_STATUS_ID=?");
/*  440 */       this.preparedStatement.setInt(1, leadStatusId);
/*  441 */       this.resultSet = this.preparedStatement.executeQuery();
/*  443 */       while (this.resultSet.next()) {
/*  444 */         leadStatusName = this.resultSet.getString("LEAD_STATUS_NAME");
/*      */       }
/*      */     }
/*      */     catch (SQLException sqlException)
/*      */     {
/*  448 */       log.error(
/*  449 */         ListHelper.class + 
/*  450 */         ": Error:- While preparing statement to get leadStatusName from database.", 
/*  451 */         sqlException);
/*      */     }
/*      */     catch (Exception exception)
/*      */     {
/*  454 */       log.error(ListHelper.class + 
/*  455 */         ": Error:- While getting connection for database.", 
/*  456 */         exception);
/*      */     }
/*      */     finally
/*      */     {
/*  458 */       JdbcHelper.closeResultSet(this.resultSet);
/*  459 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/*  460 */       JdbcHelper.closeConnection(this.connection);
/*      */     }
/*  462 */     return leadStatusName;
/*      */   }
/*      */   
/*      */   public String getSocialSite(int socialSiteId)
/*      */     throws Exception
/*      */   {
/*  484 */     String socialSiteName = null;
/*      */     try
/*      */     {
/*  487 */       this.connection = getConnection();
/*  488 */       this.preparedStatement = this.connection
/*  489 */         .prepareStatement("SELECT SOCIAL_SITE_VALUE FROM TAB_SOCIAL_SITE WHERE SOCIAL_SITE_ID=?");
/*  490 */       this.preparedStatement.setInt(1, socialSiteId);
/*  491 */       this.resultSet = this.preparedStatement.executeQuery();
/*  493 */       while (this.resultSet.next()) {
/*  494 */         socialSiteName = this.resultSet.getString("SOCIAL_SITE_VALUE");
/*      */       }
/*      */     }
/*      */     catch (SQLException sqlException)
/*      */     {
/*  498 */       log.error(
/*  499 */         ListHelper.class + 
/*  500 */         ": Error:- While preparing statement to get socialSiteName from database.", 
/*  501 */         sqlException);
/*      */     }
/*      */     catch (Exception exception)
/*      */     {
/*  504 */       log.error(ListHelper.class + 
/*  505 */         ": Error:- While getting connection for database.", 
/*  506 */         exception);
/*      */     }
/*      */     finally
/*      */     {
/*  508 */       JdbcHelper.closeResultSet(this.resultSet);
/*  509 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/*  510 */       JdbcHelper.closeConnection(this.connection);
/*      */     }
/*  512 */     return socialSiteName;
/*      */   }
/*      */   
/*      */   public String getCustomerName(int customerId)
/*      */     throws Exception
/*      */   {
/*  534 */     String customerName = null;
/*  535 */     StringBuffer sb = new StringBuffer();
/*      */     try
/*      */     {
/*  538 */       this.connection = getConnection();
/*  539 */       this.preparedStatement = this.connection
/*  540 */         .prepareStatement("SELECT SALUTATION,FULL_NAME FROM TAB_CUSTOMER_USER WHERE CUSTOMER_ID=?");
/*  541 */       this.preparedStatement.setInt(1, customerId);
/*  542 */       this.resultSet = this.preparedStatement.executeQuery();
/*  544 */       while (this.resultSet.next()) {
/*  548 */         sb.append(Salutation.getSalutation(this.resultSet.getInt("SALUTATION"))).append(" ").append(this.resultSet.getString("FULL_NAME"));
/*      */       }
/*  550 */       customerName = sb.toString();
/*      */     }
/*      */     catch (SQLException sqlException)
/*      */     {
/*  554 */       log.error(
/*  555 */         NameHelper.class + 
/*  556 */         ": Error:- While preparing statement to get Customer Full Name from database.", 
/*  557 */         sqlException);
/*      */     }
/*      */     catch (Exception exception)
/*      */     {
/*  560 */       log.error(NameHelper.class + 
/*  561 */         ": Error:- While getting connection for database.", 
/*  562 */         exception);
/*      */     }
/*      */     finally
/*      */     {
/*  564 */       JdbcHelper.closeResultSet(this.resultSet);
/*  565 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/*  566 */       JdbcHelper.closeConnection(this.connection);
/*      */     }
/*  568 */     return customerName;
/*      */   }
/*      */   
/*      */   public String getCurrencyName(int currencyId)
/*      */     throws Exception
/*      */   {
/*  590 */     String currencyDisplayName = null;
/*      */     try
/*      */     {
/*  593 */       this.connection = getConnection();
/*  594 */       this.preparedStatement = this.connection
/*  595 */         .prepareStatement("SELECT CURRENCY_DISPLAY_NAME FROM TAB_CURRENCY WHERE CURRENCY_ID=?");
/*  596 */       this.preparedStatement.setInt(1, currencyId);
/*  597 */       this.resultSet = this.preparedStatement.executeQuery();
/*  599 */       while (this.resultSet.next()) {
/*  600 */         currencyDisplayName = 
/*  601 */           this.resultSet.getString("CURRENCY_DISPLAY_NAME");
/*      */       }
/*      */     }
/*      */     catch (SQLException sqlException)
/*      */     {
/*  605 */       log.error(
/*  606 */         ListHelper.class + 
/*  607 */         ": Error:- While preparing statement to get Currency Display Name from database.", 
/*  608 */         sqlException);
/*      */     }
/*      */     catch (Exception exception)
/*      */     {
/*  611 */       log.error(
/*  612 */         ListHelper.class + 
/*  613 */         ": Error:- While getting connection for Currency Display Name form database.", 
/*  614 */         exception);
/*      */     }
/*      */     finally
/*      */     {
/*  616 */       JdbcHelper.closeResultSet(this.resultSet);
/*  617 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/*  618 */       JdbcHelper.closeConnection(this.connection);
/*      */     }
/*  620 */     return currencyDisplayName;
/*      */   }
/*      */   
/*      */   public String getLanguageName(int languageId)
/*      */     throws Exception
/*      */   {
/*  642 */     String languageDisplayName = null;
/*      */     try
/*      */     {
/*  645 */       this.connection = getConnection();
/*  646 */       this.preparedStatement = this.connection
/*  647 */         .prepareStatement("SELECT LANGUAGE_DISPLAY_NAME FROM TAB_LANGUAGE WHERE LANGUAGE_ID=?");
/*  648 */       this.preparedStatement.setInt(1, languageId);
/*  649 */       this.resultSet = this.preparedStatement.executeQuery();
/*  651 */       while (this.resultSet.next()) {
/*  652 */         languageDisplayName = 
/*  653 */           this.resultSet.getString("LANGUAGE_DISPLAY_NAME");
/*      */       }
/*      */     }
/*      */     catch (SQLException sqlException)
/*      */     {
/*  657 */       log.error(
/*  658 */         ListHelper.class + 
/*  659 */         ": Error:- While preparing statement to get Language Display Name from database.", 
/*  660 */         sqlException);
/*      */     }
/*      */     catch (Exception exception)
/*      */     {
/*  663 */       log.error(
/*  664 */         ListHelper.class + 
/*  665 */         ": Error:- While getting connection for Language Display Name form database.", 
/*  666 */         exception);
/*      */     }
/*      */     finally
/*      */     {
/*  668 */       JdbcHelper.closeResultSet(this.resultSet);
/*  669 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/*  670 */       JdbcHelper.closeConnection(this.connection);
/*      */     }
/*  672 */     return languageDisplayName;
/*      */   }
/*      */   
/*      */   public String getTimeZoneName(int timezoneId)
/*      */     throws Exception
/*      */   {
/*  694 */     String timezoneDisplayName = null;
/*      */     try
/*      */     {
/*  697 */       this.connection = getConnection();
/*  698 */       this.preparedStatement = this.connection
/*  699 */         .prepareStatement("SELECT TIMEZONE_DISPLAY_NAME FROM TAB_TIMEZONE WHERE TIMEZONE_ID=?");
/*  700 */       this.preparedStatement.setInt(1, timezoneId);
/*  701 */       this.resultSet = this.preparedStatement.executeQuery();
/*  703 */       while (this.resultSet.next()) {
/*  704 */         timezoneDisplayName = 
/*  705 */           this.resultSet.getString("TIMEZONE_DISPLAY_NAME");
/*      */       }
/*      */     }
/*      */     catch (SQLException sqlException)
/*      */     {
/*  709 */       log.error(
/*  710 */         ListHelper.class + 
/*  711 */         ": Error:- While preparing statement to get Time Zone Display Name from database.", 
/*  712 */         sqlException);
/*      */     }
/*      */     catch (Exception exception)
/*      */     {
/*  715 */       log.error(
/*  716 */         ListHelper.class + 
/*  717 */         ": Error:- While getting connection for Time Zone Display Name form database.", 
/*  718 */         exception);
/*      */     }
/*      */     finally
/*      */     {
/*  720 */       JdbcHelper.closeResultSet(this.resultSet);
/*  721 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/*  722 */       JdbcHelper.closeConnection(this.connection);
/*      */     }
/*  724 */     return timezoneDisplayName;
/*      */   }
/*      */   
/*      */   public String getLeadSourceName(int leadSourceId)
/*      */     throws Exception
/*      */   {
/*  746 */     String leadSourceName = null;
/*      */     try
/*      */     {
/*  749 */       this.connection = getConnection();
/*  750 */       this.preparedStatement = this.connection
/*  751 */         .prepareStatement("SELECT LEAD_SOURCE_NAME FROM TAB_LEAD_SOURCE WHERE LEAD_SOURCE_ID=?");
/*  752 */       this.preparedStatement.setInt(1, leadSourceId);
/*  753 */       this.resultSet = this.preparedStatement.executeQuery();
/*  755 */       while (this.resultSet.next()) {
/*  756 */         leadSourceName = this.resultSet.getString("LEAD_SOURCE_NAME");
/*      */       }
/*      */     }
/*      */     catch (SQLException sqlException)
/*      */     {
/*  760 */       log.error(
/*  761 */         ListHelper.class + 
/*  762 */         ": Error:- While preparing statement to get Lead Source Name from database.", 
/*  763 */         sqlException);
/*      */     }
/*      */     catch (Exception exception)
/*      */     {
/*  766 */       log.error(
/*  767 */         ListHelper.class + 
/*  768 */         ": Error:- While getting connection for Time Lead Source Name form database.", 
/*  769 */         exception);
/*      */     }
/*      */     finally
/*      */     {
/*  771 */       JdbcHelper.closeResultSet(this.resultSet);
/*  772 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/*  773 */       JdbcHelper.closeConnection(this.connection);
/*      */     }
/*  775 */     return leadSourceName;
/*      */   }
/*      */   
/*      */   public String getGroupCategoryName(int groupCategoryId)
/*      */     throws Exception
/*      */   {
/*  797 */     String groupCategoryName = null;
/*      */     try
/*      */     {
/*  800 */       this.connection = getConnection();
/*  801 */       this.preparedStatement = this.connection
/*  802 */         .prepareStatement("SELECT GROUP_CATEGORY_NAME FROM TAB_GROUP_CATEGORY WHERE GROUP_CATEGORY_ID=?");
/*  803 */       this.preparedStatement.setInt(1, groupCategoryId);
/*  804 */       this.resultSet = this.preparedStatement.executeQuery();
/*  806 */       while (this.resultSet.next()) {
/*  807 */         groupCategoryName = this.resultSet.getString("GROUP_CATEGORY_NAME");
/*      */       }
/*      */     }
/*      */     catch (SQLException sqlException)
/*      */     {
/*  811 */       log.error(
/*  812 */         ListHelper.class + 
/*  813 */         ": Error:- While preparing statement to get Group Category Name from database.", 
/*  814 */         sqlException);
/*      */     }
/*      */     catch (Exception exception)
/*      */     {
/*  817 */       log.error(
/*  818 */         ListHelper.class + 
/*  819 */         ": Error:- While getting connection for get Group Category Name form database.", 
/*  820 */         exception);
/*      */     }
/*      */     finally
/*      */     {
/*  822 */       JdbcHelper.closeResultSet(this.resultSet);
/*  823 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/*  824 */       JdbcHelper.closeConnection(this.connection);
/*      */     }
/*  826 */     return groupCategoryName;
/*      */   }
/*      */   
/*      */   public String getDesignationName(int designationId)
/*      */     throws Exception
/*      */   {
/*  848 */     String designationName = null;
/*      */     try
/*      */     {
/*  851 */       this.connection = getConnection();
/*  852 */       this.preparedStatement = this.connection
/*  853 */         .prepareStatement("SELECT DESIGNATION_DISPLAY_NAME FROM TAB_DESIGNATION WHERE DESIGNATION_ID=?");
/*  854 */       this.preparedStatement.setInt(1, designationId);
/*  855 */       this.resultSet = this.preparedStatement.executeQuery();
/*  857 */       while (this.resultSet.next()) {
/*  858 */         designationName = 
/*  859 */           this.resultSet.getString("DESIGNATION_DISPLAY_NAME");
/*      */       }
/*      */     }
/*      */     catch (SQLException sqlException)
/*      */     {
/*  863 */       log.error(
/*  864 */         ListHelper.class + 
/*  865 */         ": Error:- While preparing statement to get Designation Name from database.", 
/*  866 */         sqlException);
/*      */     }
/*      */     catch (Exception exception)
/*      */     {
/*  869 */       log.error(
/*  870 */         ListHelper.class + 
/*  871 */         ": Error:- While getting connection for get Designation Name form database.", 
/*  872 */         exception);
/*      */     }
/*      */     finally
/*      */     {
/*  874 */       JdbcHelper.closeResultSet(this.resultSet);
/*  875 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/*  876 */       JdbcHelper.closeConnection(this.connection);
/*      */     }
/*  878 */     return designationName;
/*      */   }
/*      */   
/*      */   public String getTaskSubjectName(int subjectId)
/*      */     throws Exception
/*      */   {
/*  900 */     String taskSubjectName = null;
/*      */     try
/*      */     {
/*  903 */       this.connection = getConnection();
/*  904 */       this.preparedStatement = this.connection
/*  905 */         .prepareStatement("SELECT TASK_SUBJECT FROM TAB_TASK_SUBJECT WHERE TASK_SUBJECT_ID=?");
/*  906 */       this.preparedStatement.setInt(1, subjectId);
/*  907 */       this.resultSet = this.preparedStatement.executeQuery();
/*  909 */       while (this.resultSet.next()) {
/*  910 */         taskSubjectName = this.resultSet.getString("TASK_SUBJECT");
/*      */       }
/*      */     }
/*      */     catch (SQLException sqlException)
/*      */     {
/*  914 */       log.error(
/*  915 */         ListHelper.class + 
/*  916 */         ": Error:- While preparing statement to get Task Subject Name from database.", 
/*  917 */         sqlException);
/*      */     }
/*      */     catch (Exception exception)
/*      */     {
/*  920 */       log.error(
/*  921 */         ListHelper.class + 
/*  922 */         ": Error:- While getting connection for get Task Subject Name form database.", 
/*  923 */         exception);
/*      */     }
/*      */     finally
/*      */     {
/*  925 */       JdbcHelper.closeResultSet(this.resultSet);
/*  926 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/*  927 */       JdbcHelper.closeConnection(this.connection);
/*      */     }
/*  929 */     return taskSubjectName;
/*      */   }
/*      */   
/*      */   public String getTaskAreaName(int taskAreaId)
/*      */     throws Exception
/*      */   {
/*  951 */     String taskAreaName = null;
/*      */     try
/*      */     {
/*  954 */       this.connection = getConnection();
/*  955 */       this.preparedStatement = this.connection
/*  956 */         .prepareStatement("SELECT TASK_AREA FROM TAB_TASK_AREA WHERE TASK_AREA_ID=?");
/*  957 */       this.preparedStatement.setInt(1, taskAreaId);
/*  958 */       this.resultSet = this.preparedStatement.executeQuery();
/*  960 */       while (this.resultSet.next()) {
/*  961 */         taskAreaName = this.resultSet.getString("TASK_AREA");
/*      */       }
/*      */     }
/*      */     catch (SQLException sqlException)
/*      */     {
/*  965 */       log.error(
/*  966 */         ListHelper.class + 
/*  967 */         ": Error:- While preparing statement to get Task Area Name from database.", 
/*  968 */         sqlException);
/*      */     }
/*      */     catch (Exception exception)
/*      */     {
/*  971 */       log.error(
/*  972 */         ListHelper.class + 
/*  973 */         ": Error:- While getting connection for get Task Area Name form database.", 
/*  974 */         exception);
/*      */     }
/*      */     finally
/*      */     {
/*  976 */       JdbcHelper.closeResultSet(this.resultSet);
/*  977 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/*  978 */       JdbcHelper.closeConnection(this.connection);
/*      */     }
/*  980 */     return taskAreaName;
/*      */   }
/*      */   
/*      */   public String getCustomerEmailId(int customerUserId)
/*      */     throws Exception
/*      */   {
/* 1002 */     String customerUserEmailId = null;
/*      */     try
/*      */     {
/* 1005 */       this.connection = getConnection();
/* 1006 */       this.preparedStatement = this.connection
/* 1007 */         .prepareStatement("SELECT PRIMARY_EMAIL_ID FROM TAB_CUSTOMER_USER WHERE CUSTOMER_ID=?");
/* 1008 */       this.preparedStatement.setInt(1, customerUserId);
/* 1009 */       this.resultSet = this.preparedStatement.executeQuery();
/* 1011 */       while (this.resultSet.next()) {
/* 1012 */         customerUserEmailId = this.resultSet.getString("PRIMARY_EMAIL_ID");
/*      */       }
/*      */     }
/*      */     catch (SQLException sqlException)
/*      */     {
/* 1016 */       log.error(
/* 1017 */         ListHelper.class + 
/* 1018 */         ": Error:- While preparing statement to get Task Area Name from database.", 
/* 1019 */         sqlException);
/*      */     }
/*      */     catch (Exception exception)
/*      */     {
/* 1022 */       log.error(
/* 1023 */         ListHelper.class + 
/* 1024 */         ": Error:- While getting connection for get Task Area Name form database.", 
/* 1025 */         exception);
/*      */     }
/*      */     finally
/*      */     {
/* 1027 */       JdbcHelper.closeResultSet(this.resultSet);
/* 1028 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/* 1029 */       JdbcHelper.closeConnection(this.connection);
/*      */     }
/* 1031 */     return customerUserEmailId;
/*      */   }
/*      */   
/*      */   public String getCampaignOwnerName(int CampaignOwnerId)
/*      */     throws Exception
/*      */   {
/* 1054 */     String campaignOwnerName = null;
/*      */     try
/*      */     {
/* 1057 */       this.connection = getConnection();
/* 1058 */       this.preparedStatement = this.connection
/* 1059 */         .prepareStatement("SELECT FULL_NAME FROM TAB_CUSTOMER_USER WHERE CUSTOMER_ID=?");
/* 1060 */       this.preparedStatement.setInt(1, CampaignOwnerId);
/* 1061 */       this.resultSet = this.preparedStatement.executeQuery();
/* 1063 */       while (this.resultSet.next()) {
/* 1064 */         campaignOwnerName = this.resultSet.getString("FULL_NAME");
/*      */       }
/*      */     }
/*      */     catch (SQLException sqlException)
/*      */     {
/* 1068 */       log.error(
/* 1069 */         ListHelper.class + 
/* 1070 */         ": Error:- While preparing statement to get Campaign Owner Name from database.", 
/* 1071 */         sqlException);
/*      */     }
/*      */     catch (Exception exception)
/*      */     {
/* 1074 */       log.error(
/* 1075 */         ListHelper.class + 
/* 1076 */         ": Error:- While getting connection for get Campaign Owner Name form database.", 
/* 1077 */         exception);
/*      */     }
/*      */     finally
/*      */     {
/* 1079 */       JdbcHelper.closeResultSet(this.resultSet);
/* 1080 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/* 1081 */       JdbcHelper.closeConnection(this.connection);
/*      */     }
/* 1083 */     return campaignOwnerName;
/*      */   }
/*      */   
/*      */   public String getCampaignAssignedToName(int CampaignAssignedToId)
/*      */     throws Exception
/*      */   {
/* 1107 */     String campaignAssignedToName = null;
/*      */     try
/*      */     {
/* 1110 */       this.connection = getConnection();
/* 1111 */       this.preparedStatement = this.connection
/* 1112 */         .prepareStatement("SELECT FULL_NAME FROM TAB_CUSTOMER_USER WHERE CUSTOMER_ID=?");
/* 1113 */       this.preparedStatement.setInt(1, CampaignAssignedToId);
/* 1114 */       this.resultSet = this.preparedStatement.executeQuery();
/* 1116 */       while (this.resultSet.next()) {
/* 1117 */         campaignAssignedToName = this.resultSet.getString("FULL_NAME");
/*      */       }
/*      */     }
/*      */     catch (SQLException sqlException)
/*      */     {
/* 1121 */       log.error(
/* 1122 */         ListHelper.class + 
/* 1123 */         ": Error:- While preparing statement to get Campaign Assigned To Name from database.", 
/* 1124 */         sqlException);
/*      */     }
/*      */     catch (Exception exception)
/*      */     {
/* 1127 */       log.error(
/* 1128 */         ListHelper.class + 
/* 1129 */         ": Error:- While getting connection for get Campaign Assigned To Name form database.", 
/* 1130 */         exception);
/*      */     }
/*      */     finally
/*      */     {
/* 1132 */       JdbcHelper.closeResultSet(this.resultSet);
/* 1133 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/* 1134 */       JdbcHelper.closeConnection(this.connection);
/*      */     }
/* 1136 */     return campaignAssignedToName;
/*      */   }
/*      */   
/*      */   public String getCampaignTypeName(int campaignTypeId)
/*      */     throws Exception
/*      */   {
/* 1159 */     String campaignTypeName = null;
/*      */     try
/*      */     {
/* 1162 */       this.connection = getConnection();
/* 1163 */       this.preparedStatement = this.connection
/* 1164 */         .prepareStatement("SELECT CAMPAIGN_TYPE_NAME FROM TAB_CAMPAIGN_TYPE WHERE CAMPAIGN_TYPE_ID=?");
/* 1165 */       this.preparedStatement.setInt(1, campaignTypeId);
/* 1166 */       this.resultSet = this.preparedStatement.executeQuery();
/* 1168 */       while (this.resultSet.next()) {
/* 1169 */         campaignTypeName = this.resultSet.getString("CAMPAIGN_TYPE_NAME");
/*      */       }
/*      */     }
/*      */     catch (SQLException sqlException)
/*      */     {
/* 1173 */       log.error(
/* 1174 */         ListHelper.class + 
/* 1175 */         ": Error:- While preparing statement to get Campaign Type Name from database.", 
/* 1176 */         sqlException);
/*      */     }
/*      */     catch (Exception exception)
/*      */     {
/* 1179 */       log.error(
/* 1180 */         ListHelper.class + 
/* 1181 */         ": Error:- While getting connection for get Campaign Type Name form database.", 
/* 1182 */         exception);
/*      */     }
/*      */     finally
/*      */     {
/* 1184 */       JdbcHelper.closeResultSet(this.resultSet);
/* 1185 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/* 1186 */       JdbcHelper.closeConnection(this.connection);
/*      */     }
/* 1188 */     return campaignTypeName;
/*      */   }
/*      */   
/*      */   public String getAccountName(int accountId)
/*      */     throws Exception
/*      */   {
/* 1211 */     String accountName = null;
/*      */     try
/*      */     {
/* 1214 */       this.connection = getConnection();
/* 1215 */       this.preparedStatement = this.connection
/* 1216 */         .prepareStatement("SELECT ACCOUNT_NAME FROM TAB_ACCOUNT WHERE ACCOUNT_ID=?");
/* 1217 */       this.preparedStatement.setInt(1, accountId);
/* 1218 */       this.resultSet = this.preparedStatement.executeQuery();
/* 1220 */       while (this.resultSet.next()) {
/* 1221 */         accountName = this.resultSet.getString("ACCOUNT_NAME");
/*      */       }
/*      */     }
/*      */     catch (SQLException sqlException)
/*      */     {
/* 1225 */       log.error(
/* 1226 */         ListHelper.class + 
/* 1227 */         ": Error:- While preparing statement to get Account Name from database.", 
/* 1228 */         sqlException);
/*      */     }
/*      */     catch (Exception exception)
/*      */     {
/* 1231 */       log.error(
/* 1232 */         ListHelper.class + 
/* 1233 */         ": Error:- While getting connection for get Account Name form database.", 
/* 1234 */         exception);
/*      */     }
/*      */     finally
/*      */     {
/* 1236 */       JdbcHelper.closeResultSet(this.resultSet);
/* 1237 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/* 1238 */       JdbcHelper.closeConnection(this.connection);
/*      */     }
/* 1240 */     return accountName;
/*      */   }
/*      */   
/*      */   public String getTicketCategory(int TicketCategoryId)
/*      */     throws Exception
/*      */   {
/* 1245 */     String ticketCategoryName = null;
/*      */     try
/*      */     {
/* 1248 */       this.connection = getConnection();
/* 1249 */       this.preparedStatement = this.connection
/* 1250 */         .prepareStatement("SELECT CATEGORY_NAME FROM TAB_TICKET_CATEGORY WHERE CATEGORY_ID=?");
/* 1251 */       this.preparedStatement.setInt(1, TicketCategoryId);
/* 1252 */       this.resultSet = this.preparedStatement.executeQuery();
/* 1254 */       while (this.resultSet.next()) {
/* 1255 */         ticketCategoryName = this.resultSet.getString("CATEGORY_NAME");
/*      */       }
/*      */     }
/*      */     catch (SQLException sqlException)
/*      */     {
/* 1259 */       log.error(
/* 1260 */         ListHelper.class + 
/* 1261 */         ": Error:- While preparing statement to get TICKET CATEGORY NAME from database.", 
/* 1262 */         sqlException);
/*      */     }
/*      */     catch (Exception exception)
/*      */     {
/* 1265 */       log.error(
/* 1266 */         ListHelper.class + 
/* 1267 */         ": Error:- While getting connection for get TICKET CATEGORY NAME form database.", 
/* 1268 */         exception);
/*      */     }
/*      */     finally
/*      */     {
/* 1270 */       JdbcHelper.closeResultSet(this.resultSet);
/* 1271 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/* 1272 */       JdbcHelper.closeConnection(this.connection);
/*      */     }
/* 1274 */     return ticketCategoryName;
/*      */   }
/*      */   
/*      */   public String getTicketChannel(int TicketChannelId)
/*      */     throws Exception
/*      */   {
/* 1279 */     String ticketChannel = null;
/*      */     try
/*      */     {
/* 1282 */       this.connection = getConnection();
/* 1283 */       this.preparedStatement = this.connection
/* 1284 */         .prepareStatement("SELECT CHANNEL_NAME FROM TAB_TICKET_CHANNEL WHERE CHANNEL_ID=?");
/* 1285 */       this.preparedStatement.setInt(1, TicketChannelId);
/* 1286 */       this.resultSet = this.preparedStatement.executeQuery();
/* 1288 */       while (this.resultSet.next()) {
/* 1289 */         ticketChannel = this.resultSet.getString("CHANNEL_NAME");
/*      */       }
/*      */     }
/*      */     catch (SQLException sqlException)
/*      */     {
/* 1293 */       log.error(
/* 1294 */         ListHelper.class + 
/* 1295 */         ": Error:- While preparing statement to get ticket Channel from database.", 
/* 1296 */         sqlException);
/*      */     }
/*      */     catch (Exception exception)
/*      */     {
/* 1299 */       log.error(
/* 1300 */         ListHelper.class + 
/* 1301 */         ": Error:- While getting connection for get ticket Channel form database.", 
/* 1302 */         exception);
/*      */     }
/*      */     finally
/*      */     {
/* 1304 */       JdbcHelper.closeResultSet(this.resultSet);
/* 1305 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/* 1306 */       JdbcHelper.closeConnection(this.connection);
/*      */     }
/* 1308 */     return ticketChannel;
/*      */   }
/*      */   
/*      */   public String getTicketOwner(int TicketOwnerId)
/*      */     throws Exception
/*      */   {
/* 1313 */     String ticketOwnerName = null;
/*      */     try
/*      */     {
/* 1316 */       this.connection = getConnection();
/* 1317 */       this.preparedStatement = this.connection
/* 1318 */         .prepareStatement("SELECT FULL_NAME FROM TAB_CUSTOMER_USER WHERE CUSTOMER_ID=?");
/* 1319 */       this.preparedStatement.setInt(1, TicketOwnerId);
/* 1320 */       this.resultSet = this.preparedStatement.executeQuery();
/* 1322 */       while (this.resultSet.next()) {
/* 1323 */         ticketOwnerName = this.resultSet.getString("FULL_NAME");
/*      */       }
/*      */     }
/*      */     catch (SQLException sqlException)
/*      */     {
/* 1327 */       log.error(
/* 1328 */         ListHelper.class + 
/* 1329 */         ": Error:- While preparing statement to get ticketOwnerName from database.", 
/* 1330 */         sqlException);
/*      */     }
/*      */     catch (Exception exception)
/*      */     {
/* 1333 */       log.error(
/* 1334 */         ListHelper.class + 
/* 1335 */         ": Error:- While getting connection for get ticket Owner Name form database.", 
/* 1336 */         exception);
/*      */     }
/*      */     finally
/*      */     {
/* 1338 */       JdbcHelper.closeResultSet(this.resultSet);
/* 1339 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/* 1340 */       JdbcHelper.closeConnection(this.connection);
/*      */     }
/* 1342 */     return ticketOwnerName;
/*      */   }
/*      */   
/*      */   public String getTicketPriority(int TicketPriorityId)
/*      */     throws Exception
/*      */   {
/* 1347 */     String ticketPriority = null;
/*      */     try
/*      */     {
/* 1350 */       this.connection = getConnection();
/* 1351 */       this.preparedStatement = this.connection
/* 1352 */         .prepareStatement("SELECT PRIORITY FROM TAB_SUPPORT_TICKET WHERE TICKET_ID=?");
/* 1353 */       this.preparedStatement.setInt(1, TicketPriorityId);
/* 1354 */       this.resultSet = this.preparedStatement.executeQuery();
/* 1356 */       while (this.resultSet.next()) {
/* 1357 */         ticketPriority = this.resultSet.getString("PRIORITY");
/*      */       }
/*      */     }
/*      */     catch (SQLException sqlException)
/*      */     {
/* 1361 */       log.error(
/* 1362 */         ListHelper.class + 
/* 1363 */         ": Error:- While preparing statement to get ticket Priority from database.", 
/* 1364 */         sqlException);
/*      */     }
/*      */     catch (Exception exception)
/*      */     {
/* 1367 */       log.error(
/* 1368 */         ListHelper.class + 
/* 1369 */         ": Error:- While getting connection for get ticket Priority form database.", 
/* 1370 */         exception);
/*      */     }
/*      */     finally
/*      */     {
/* 1372 */       JdbcHelper.closeResultSet(this.resultSet);
/* 1373 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/* 1374 */       JdbcHelper.closeConnection(this.connection);
/*      */     }
/* 1376 */     return ticketPriority;
/*      */   }
/*      */   
/*      */   public String getTicketStatus(int TicketStatusId)
/*      */     throws Exception
/*      */   {
/* 1381 */     String ticketStatus = null;
/*      */     try
/*      */     {
/* 1384 */       this.connection = getConnection();
/* 1385 */       this.preparedStatement = this.connection
/* 1386 */         .prepareStatement("SELECT STATUS FROM TAB_SUPPORT_TICKET WHERE TICKET_ID=?");
/* 1387 */       this.preparedStatement.setInt(1, TicketStatusId);
/* 1388 */       this.resultSet = this.preparedStatement.executeQuery();
/* 1390 */       while (this.resultSet.next()) {
/* 1391 */         ticketStatus = this.resultSet.getString("STATUS");
/*      */       }
/*      */     }
/*      */     catch (SQLException sqlException)
/*      */     {
/* 1395 */       log.error(
/* 1396 */         ListHelper.class + 
/* 1397 */         ": Error:- While preparing statement to get ticket Status from database.", 
/* 1398 */         sqlException);
/*      */     }
/*      */     catch (Exception exception)
/*      */     {
/* 1401 */       log.error(
/* 1402 */         ListHelper.class + 
/* 1403 */         ": Error:- While getting connection for get ticket Status form database.", 
/* 1404 */         exception);
/*      */     }
/*      */     finally
/*      */     {
/* 1406 */       JdbcHelper.closeResultSet(this.resultSet);
/* 1407 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/* 1408 */       JdbcHelper.closeConnection(this.connection);
/*      */     }
/* 1410 */     return ticketStatus;
/*      */   }
/*      */   
/*      */   public String getTicketContactName(int ticketContactId)
/*      */     throws Exception
/*      */   {
/* 1415 */     String ticketContactName = null;
/*      */     try
/*      */     {
/* 1418 */       this.connection = getConnection();
/* 1419 */       this.preparedStatement = this.connection
/* 1420 */         .prepareStatement("SELECT CONTACT_PERSON FROM TAB_CONTACT WHERE CONTACT_ID=?");
/* 1421 */       this.preparedStatement.setInt(1, ticketContactId);
/* 1422 */       this.resultSet = this.preparedStatement.executeQuery();
/* 1424 */       while (this.resultSet.next()) {
/* 1425 */         ticketContactName = this.resultSet.getString("CONTACT_PERSON");
/*      */       }
/*      */     }
/*      */     catch (SQLException sqlException)
/*      */     {
/* 1429 */       log.error(
/* 1430 */         ListHelper.class + 
/* 1431 */         ": Error:- While preparing statement to get ticket Contact Name from database.", 
/* 1432 */         sqlException);
/*      */     }
/*      */     catch (Exception exception)
/*      */     {
/* 1435 */       log.error(
/* 1436 */         ListHelper.class + 
/* 1437 */         ": Error:- While getting connection for get ticket Contact Name form database.", 
/* 1438 */         exception);
/*      */     }
/*      */     finally
/*      */     {
/* 1440 */       JdbcHelper.closeResultSet(this.resultSet);
/* 1441 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/* 1442 */       JdbcHelper.closeConnection(this.connection);
/*      */     }
/* 1444 */     return ticketContactName;
/*      */   }
/*      */   
/*      */   public String getTicketProductName(int TicketProductNameId)
/*      */     throws Exception
/*      */   {
/* 1450 */     String ticketProductName = null;
/*      */     try
/*      */     {
/* 1453 */       this.connection = getConnection();
/* 1454 */       this.preparedStatement = this.connection
/* 1455 */         .prepareStatement("SELECT PRODUCT_NAME FROM TAB_PRODUCT_DETAILS WHERE PRODUCT_ID=?");
/* 1456 */       this.preparedStatement.setInt(1, TicketProductNameId);
/* 1457 */       this.resultSet = this.preparedStatement.executeQuery();
/* 1459 */       while (this.resultSet.next()) {
/* 1460 */         ticketProductName = this.resultSet.getString("PRODUCT_NAME");
/*      */       }
/*      */     }
/*      */     catch (SQLException sqlException)
/*      */     {
/* 1464 */       log.error(
/* 1465 */         ListHelper.class + 
/* 1466 */         ": Error:- While preparing statement to get ticket Product NAME from database.", 
/* 1467 */         sqlException);
/*      */     }
/*      */     catch (Exception exception)
/*      */     {
/* 1470 */       log.error(
/* 1471 */         ListHelper.class + 
/* 1472 */         ": Error:- While getting connection for get ticket Product Name form database.", 
/* 1473 */         exception);
/*      */     }
/*      */     finally
/*      */     {
/* 1475 */       JdbcHelper.closeResultSet(this.resultSet);
/* 1476 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/* 1477 */       JdbcHelper.closeConnection(this.connection);
/*      */     }
/* 1479 */     return ticketProductName;
/*      */   }
/*      */   
/*      */   public String getFaqOwner(int FaqOwnerId)
/*      */     throws Exception
/*      */   {
/* 1484 */     String faqOwnerName = null;
/*      */     try
/*      */     {
/* 1487 */       this.connection = getConnection();
/* 1488 */       this.preparedStatement = this.connection
/* 1489 */         .prepareStatement("SELECT FULL_NAME FROM TAB_CUSTOMER_USER WHERE CUSTOMER_ID=?");
/* 1490 */       this.preparedStatement.setInt(1, FaqOwnerId);
/* 1491 */       this.resultSet = this.preparedStatement.executeQuery();
/* 1493 */       while (this.resultSet.next()) {
/* 1494 */         faqOwnerName = this.resultSet.getString("FULL_NAME");
/*      */       }
/*      */     }
/*      */     catch (SQLException sqlException)
/*      */     {
/* 1498 */       log.error(
/* 1499 */         ListHelper.class + 
/* 1500 */         ": Error:- While preparing statement to get faq Owner Name from database.", 
/* 1501 */         sqlException);
/*      */     }
/*      */     catch (Exception exception)
/*      */     {
/* 1504 */       log.error(
/* 1505 */         ListHelper.class + 
/* 1506 */         ": Error:- While getting connection for get ticket Owner Name form database.", 
/* 1507 */         exception);
/*      */     }
/*      */     finally
/*      */     {
/* 1509 */       JdbcHelper.closeResultSet(this.resultSet);
/* 1510 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/* 1511 */       JdbcHelper.closeConnection(this.connection);
/*      */     }
/* 1513 */     return faqOwnerName;
/*      */   }
/*      */   
/*      */   public String getFaqCategory(int FaqCategoryId)
/*      */     throws Exception
/*      */   {
/* 1518 */     String faqCategoryName = null;
/*      */     try
/*      */     {
/* 1521 */       this.connection = getConnection();
/* 1522 */       this.preparedStatement = this.connection
/* 1523 */         .prepareStatement("SELECT CATEGORY_NAME FROM TAB_FAQ_CATEGORY WHERE CATEGORY_ID=?");
/* 1524 */       this.preparedStatement.setInt(1, FaqCategoryId);
/* 1525 */       this.resultSet = this.preparedStatement.executeQuery();
/* 1527 */       while (this.resultSet.next()) {
/* 1528 */         faqCategoryName = this.resultSet.getString("CATEGORY_NAME");
/*      */       }
/*      */     }
/*      */     catch (SQLException sqlException)
/*      */     {
/* 1532 */       log.error(
/* 1533 */         ListHelper.class + 
/* 1534 */         ": Error:- While preparing statement to get faq Category Name from database.", 
/* 1535 */         sqlException);
/*      */     }
/*      */     catch (Exception exception)
/*      */     {
/* 1538 */       log.error(
/* 1539 */         ListHelper.class + 
/* 1540 */         ": Error:- While getting connection for get faq Category Name form database.", 
/* 1541 */         exception);
/*      */     }
/*      */     finally
/*      */     {
/* 1543 */       JdbcHelper.closeResultSet(this.resultSet);
/* 1544 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/* 1545 */       JdbcHelper.closeConnection(this.connection);
/*      */     }
/* 1547 */     return faqCategoryName;
/*      */   }
/*      */   
/*      */   public String getFaqProductName(int FaqProductNameId)
/*      */     throws Exception
/*      */   {
/* 1552 */     String faqProductName = null;
/*      */     try
/*      */     {
/* 1555 */       this.connection = getConnection();
/* 1556 */       this.preparedStatement = this.connection
/* 1557 */         .prepareStatement("SELECT PRODUCT_NAME FROM TAB_PRODUCT_DETAILS WHERE PRODUCT_ID=?");
/* 1558 */       this.preparedStatement.setInt(1, FaqProductNameId);
/* 1559 */       this.resultSet = this.preparedStatement.executeQuery();
/* 1561 */       while (this.resultSet.next()) {
/* 1562 */         faqProductName = this.resultSet.getString("PRODUCT_NAME");
/*      */       }
/*      */     }
/*      */     catch (SQLException sqlException)
/*      */     {
/* 1566 */       log.error(
/* 1567 */         ListHelper.class + 
/* 1568 */         ": Error:- While preparing statement to get faq Product NAME from database.", 
/* 1569 */         sqlException);
/*      */     }
/*      */     catch (Exception exception)
/*      */     {
/* 1572 */       log.error(
/* 1573 */         ListHelper.class + 
/* 1574 */         ": Error:- While getting connection for get faq Product Name form database.", 
/* 1575 */         exception);
/*      */     }
/*      */     finally
/*      */     {
/* 1577 */       JdbcHelper.closeResultSet(this.resultSet);
/* 1578 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/* 1579 */       JdbcHelper.closeConnection(this.connection);
/*      */     }
/* 1581 */     return faqProductName;
/*      */   }
/*      */   
/*      */   public String getFaqStatus(int FaqStatusId)
/*      */     throws Exception
/*      */   {
/* 1586 */     String faqStatus = null;
/*      */     try
/*      */     {
/* 1589 */       this.connection = getConnection();
/* 1590 */       this.preparedStatement = this.connection
/* 1591 */         .prepareStatement("SELECT STATUS FROM TAB_SUPPORT_FAQ WHERE FAQ_ID=?");
/* 1592 */       this.preparedStatement.setInt(1, FaqStatusId);
/* 1593 */       this.resultSet = this.preparedStatement.executeQuery();
/* 1595 */       while (this.resultSet.next()) {
/* 1596 */         faqStatus = this.resultSet.getString("STATUS");
/*      */       }
/*      */     }
/*      */     catch (SQLException sqlException)
/*      */     {
/* 1600 */       log.error(
/* 1601 */         ListHelper.class + 
/* 1602 */         ": Error:- While preparing statement to get faq Status from database.", 
/* 1603 */         sqlException);
/*      */     }
/*      */     catch (Exception exception)
/*      */     {
/* 1606 */       log.error(
/* 1607 */         ListHelper.class + 
/* 1608 */         ": Error:- While getting connection for get faq Status form database.", 
/* 1609 */         exception);
/*      */     }
/*      */     finally
/*      */     {
/* 1611 */       JdbcHelper.closeResultSet(this.resultSet);
/* 1612 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/* 1613 */       JdbcHelper.closeConnection(this.connection);
/*      */     }
/* 1615 */     return faqStatus;
/*      */   }
/*      */   
/*      */   public String getCasesAssignedTo(int CasesAssignedToId)
/*      */     throws Exception
/*      */   {
/* 1620 */     String casesAssignedTo = null;
/*      */     try
/*      */     {
/* 1623 */       this.connection = getConnection();
/* 1624 */       this.preparedStatement = this.connection
/* 1625 */         .prepareStatement("SELECT ASSIGNED_TO_NAME FROM TAB_CASES_ASSIGNED_TO WHERE ASSIGNED_TO_ID=?");
/* 1626 */       this.preparedStatement.setInt(1, CasesAssignedToId);
/* 1627 */       this.resultSet = this.preparedStatement.executeQuery();
/* 1629 */       while (this.resultSet.next()) {
/* 1630 */         casesAssignedTo = this.resultSet.getString("ASSIGNED_TO_NAME");
/*      */       }
/*      */     }
/*      */     catch (SQLException sqlException)
/*      */     {
/* 1634 */       log.error(
/* 1635 */         ListHelper.class + 
/* 1636 */         ": Error:- While preparing statement to get cases Team from database.", 
/* 1637 */         sqlException);
/*      */     }
/*      */     catch (Exception exception)
/*      */     {
/* 1640 */       log.error(
/* 1641 */         ListHelper.class + 
/* 1642 */         ": Error:- While getting connection for get cases Team form database.", 
/* 1643 */         exception);
/*      */     }
/*      */     finally
/*      */     {
/* 1645 */       JdbcHelper.closeResultSet(this.resultSet);
/* 1646 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/* 1647 */       JdbcHelper.closeConnection(this.connection);
/*      */     }
/* 1649 */     return casesAssignedTo;
/*      */   }
/*      */   
/*      */   public String getCasesTeam(int CasesTeamId)
/*      */     throws Exception
/*      */   {
/* 1654 */     String casesTeam = null;
/*      */     try
/*      */     {
/* 1657 */       this.connection = getConnection();
/* 1658 */       this.preparedStatement = this.connection
/* 1659 */         .prepareStatement("SELECT TEAM_NAME FROM TAB_CASES_TEAM WHERE TEAM_ID=?");
/* 1660 */       this.preparedStatement.setInt(1, CasesTeamId);
/* 1661 */       this.resultSet = this.preparedStatement.executeQuery();
/* 1663 */       while (this.resultSet.next()) {
/* 1664 */         casesTeam = this.resultSet.getString("TEAM_NAME");
/*      */       }
/*      */     }
/*      */     catch (SQLException sqlException)
/*      */     {
/* 1668 */       log.error(
/* 1669 */         ListHelper.class + 
/* 1670 */         ": Error:- While preparing statement to get cases Team from database.", 
/* 1671 */         sqlException);
/*      */     }
/*      */     catch (Exception exception)
/*      */     {
/* 1674 */       log.error(
/* 1675 */         ListHelper.class + 
/* 1676 */         ": Error:- While getting connection for get cases Team form database.", 
/* 1677 */         exception);
/*      */     }
/*      */     finally
/*      */     {
/* 1679 */       JdbcHelper.closeResultSet(this.resultSet);
/* 1680 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/* 1681 */       JdbcHelper.closeConnection(this.connection);
/*      */     }
/* 1683 */     return casesTeam;
/*      */   }
/*      */   
/*      */   public String getCasesChannel(int CasesChannelId)
/*      */     throws Exception
/*      */   {
/* 1688 */     String casesChannel = null;
/*      */     try
/*      */     {
/* 1691 */       this.connection = getConnection();
/* 1692 */       this.preparedStatement = this.connection
/* 1693 */         .prepareStatement("SELECT CHANNEL_NAME FROM TAB_CASES_CHANNEL WHERE CHANNEL_ID=?");
/* 1694 */       this.preparedStatement.setInt(1, CasesChannelId);
/* 1695 */       this.resultSet = this.preparedStatement.executeQuery();
/* 1697 */       while (this.resultSet.next()) {
/* 1698 */         casesChannel = this.resultSet.getString("CHANNEL_NAME");
/*      */       }
/*      */     }
/*      */     catch (SQLException sqlException)
/*      */     {
/* 1702 */       log.error(
/* 1703 */         ListHelper.class + 
/* 1704 */         ": Error:- While preparing statement to get cases Channel from database.", 
/* 1705 */         sqlException);
/*      */     }
/*      */     catch (Exception exception)
/*      */     {
/* 1708 */       log.error(
/* 1709 */         ListHelper.class + 
/* 1710 */         ": Error:- While getting connection for get cases Channel form database.", 
/* 1711 */         exception);
/*      */     }
/*      */     finally
/*      */     {
/* 1713 */       JdbcHelper.closeResultSet(this.resultSet);
/* 1714 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/* 1715 */       JdbcHelper.closeConnection(this.connection);
/*      */     }
/* 1717 */     return casesChannel;
/*      */   }
/*      */   
/*      */   public String getCasesImpactType(int CasesImpactTypeId)
/*      */     throws Exception
/*      */   {
/* 1722 */     String casesImpactType = null;
/*      */     try
/*      */     {
/* 1725 */       this.connection = getConnection();
/* 1726 */       this.preparedStatement = this.connection
/* 1727 */         .prepareStatement("SELECT IMPACT_TYPE_NAME FROM TAB_CASES_IMPACT_TYPE WHERE IMPACT_TYPE_ID=?");
/* 1728 */       this.preparedStatement.setInt(1, CasesImpactTypeId);
/* 1729 */       this.resultSet = this.preparedStatement.executeQuery();
/* 1731 */       while (this.resultSet.next()) {
/* 1732 */         casesImpactType = this.resultSet.getString("IMPACT_TYPE_NAME");
/*      */       }
/*      */     }
/*      */     catch (SQLException sqlException)
/*      */     {
/* 1736 */       log.error(
/* 1737 */         ListHelper.class + 
/* 1738 */         ": Error:- While preparing statement to get cases Impact Type from database.", 
/* 1739 */         sqlException);
/*      */     }
/*      */     catch (Exception exception)
/*      */     {
/* 1742 */       log.error(
/* 1743 */         ListHelper.class + 
/* 1744 */         ": Error:- While getting connection for get cases Impact Type form database.", 
/* 1745 */         exception);
/*      */     }
/*      */     finally
/*      */     {
/* 1747 */       JdbcHelper.closeResultSet(this.resultSet);
/* 1748 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/* 1749 */       JdbcHelper.closeConnection(this.connection);
/*      */     }
/* 1751 */     return casesImpactType;
/*      */   }
/*      */   
/*      */   public String getCasesImpactArea(int CasesImpactAreaId)
/*      */     throws Exception
/*      */   {
/* 1756 */     String casesImpactArea = null;
/*      */     try
/*      */     {
/* 1759 */       this.connection = getConnection();
/* 1760 */       this.preparedStatement = this.connection
/* 1761 */         .prepareStatement("SELECT IMPACT_AREA_NAME FROM TAB_CASES_IMPACT_AREA WHERE IMPACT_AREA_ID");
/* 1762 */       this.preparedStatement.setInt(1, CasesImpactAreaId);
/* 1763 */       this.resultSet = this.preparedStatement.executeQuery();
/* 1765 */       while (this.resultSet.next()) {
/* 1766 */         casesImpactArea = this.resultSet.getString("IMPACT_AREA_NAME");
/*      */       }
/*      */     }
/*      */     catch (SQLException sqlException)
/*      */     {
/* 1770 */       log.error(
/* 1771 */         ListHelper.class + 
/* 1772 */         ": Error:- While preparing statement to get cases Impact Area from database.", 
/* 1773 */         sqlException);
/*      */     }
/*      */     catch (Exception exception)
/*      */     {
/* 1776 */       log.error(
/* 1777 */         ListHelper.class + 
/* 1778 */         ": Error:- While getting connection for get cases Impact Area form database.", 
/* 1779 */         exception);
/*      */     }
/*      */     finally
/*      */     {
/* 1781 */       JdbcHelper.closeResultSet(this.resultSet);
/* 1782 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/* 1783 */       JdbcHelper.closeConnection(this.connection);
/*      */     }
/* 1785 */     return casesImpactArea;
/*      */   }
/*      */   
/*      */   public String getCasesResolutionType(int CasesResolutionTypeId)
/*      */     throws Exception
/*      */   {
/* 1791 */     String casesResolutionType = null;
/*      */     try
/*      */     {
/* 1794 */       this.connection = getConnection();
/* 1795 */       this.preparedStatement = this.connection
/* 1796 */         .prepareStatement("SELECT RESOLUTION_TYPE_NAME FROM TAB_CASES_RESOLUTION_TYPE WHERE RESOLUTION_TYPE_ID=?");
/* 1797 */       this.preparedStatement.setInt(1, CasesResolutionTypeId);
/* 1798 */       this.resultSet = this.preparedStatement.executeQuery();
/* 1800 */       while (this.resultSet.next()) {
/* 1801 */         casesResolutionType = 
/* 1802 */           this.resultSet.getString("RESOLUTION_TYPE_NAME");
/*      */       }
/*      */     }
/*      */     catch (SQLException sqlException)
/*      */     {
/* 1806 */       log.error(
/* 1807 */         ListHelper.class + 
/* 1808 */         ": Error:- While preparing statement to get CASES resolution from database.", 
/* 1809 */         sqlException);
/*      */     }
/*      */     catch (Exception exception)
/*      */     {
/* 1812 */       log.error(
/* 1813 */         ListHelper.class + 
/* 1814 */         ": Error:- While getting connection for get CASES resolution form database.", 
/* 1815 */         exception);
/*      */     }
/*      */     finally
/*      */     {
/* 1817 */       JdbcHelper.closeResultSet(this.resultSet);
/* 1818 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/* 1819 */       JdbcHelper.closeConnection(this.connection);
/*      */     }
/* 1821 */     return casesResolutionType;
/*      */   }
/*      */   
/*      */   public String getCasesSlaName(int CasesSlaNameId)
/*      */     throws Exception
/*      */   {
/* 1826 */     String casesSlaName = null;
/*      */     try
/*      */     {
/* 1829 */       this.connection = getConnection();
/* 1830 */       this.preparedStatement = this.connection
/* 1831 */         .prepareStatement("SELECT * FROM TAB_ACCOUNT WHERE ACCOUNT_ID=?");
/* 1832 */       this.preparedStatement.setInt(1, CasesSlaNameId);
/* 1833 */       this.resultSet = this.preparedStatement.executeQuery();
/* 1835 */       while (this.resultSet.next()) {
/* 1836 */         casesSlaName = this.resultSet.getString("SLA_NAME");
/*      */       }
/*      */     }
/*      */     catch (SQLException sqlException)
/*      */     {
/* 1840 */       log.error(
/* 1841 */         ListHelper.class + 
/* 1842 */         ": Error:- While preparing statement to get cases Sla Name from database.", 
/* 1843 */         sqlException);
/*      */     }
/*      */     catch (Exception exception)
/*      */     {
/* 1846 */       log.error(
/* 1847 */         ListHelper.class + 
/* 1848 */         ": Error:- While getting connection for get cases Sla Name form database.", 
/* 1849 */         exception);
/*      */     }
/*      */     finally
/*      */     {
/* 1851 */       JdbcHelper.closeResultSet(this.resultSet);
/* 1852 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/* 1853 */       JdbcHelper.closeConnection(this.connection);
/*      */     }
/* 1855 */     return casesSlaName;
/*      */   }
/*      */   
/*      */   public String getCasesOrgnization(int CasesOrgnizationId)
/*      */     throws Exception
/*      */   {
/* 1859 */     String casesOrgnization = null;
/*      */     try
/*      */     {
/* 1861 */       this.connection = getConnection();
/* 1862 */       this.preparedStatement = this.connection
/* 1863 */         .prepareStatement("SELECT * FROM TAB_COMPANY_DETAILS WHERE COMPANY_ID=?");
/* 1864 */       this.preparedStatement.setInt(1, CasesOrgnizationId);
/* 1865 */       this.resultSet = this.preparedStatement.executeQuery();
/* 1867 */       while (this.resultSet.next()) {
/* 1868 */         casesOrgnization = this.resultSet.getString("COMPANY_NAME");
/*      */       }
/*      */     }
/*      */     catch (SQLException sqlException)
/*      */     {
/* 1872 */       log.error(
/* 1873 */         ListHelper.class + 
/* 1874 */         ": Error:- While preparing statement to get cases Orgnization from database.", 
/* 1875 */         sqlException);
/*      */     }
/*      */     catch (Exception exception)
/*      */     {
/* 1878 */       log.error(
/* 1879 */         ListHelper.class + 
/* 1880 */         ": Error:- While getting connection for get cases Orgnization form database.", 
/* 1881 */         exception);
/*      */     }
/*      */     finally
/*      */     {
/* 1883 */       JdbcHelper.closeResultSet(this.resultSet);
/* 1884 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/* 1885 */       JdbcHelper.closeConnection(this.connection);
/*      */     }
/* 1887 */     return casesOrgnization;
/*      */   }
/*      */   
/*      */   public String getServiceType(int ServiceTypeId)
/*      */     throws Exception
/*      */   {
/* 1891 */     String serviceType = null;
/*      */     try
/*      */     {
/* 1893 */       this.connection = getConnection();
/* 1894 */       this.preparedStatement = this.connection
/* 1895 */         .prepareStatement("SELECT SERVICE_CONTRACT_TYPE_NAME FROM TAB_SERVICE_CONTRACT_TYPEWHERE SERVICE_CONTRACT_TYPE_ID=?");
/* 1896 */       this.preparedStatement.setInt(1, ServiceTypeId);
/* 1897 */       this.resultSet = this.preparedStatement.executeQuery();
/* 1899 */       while (this.resultSet.next()) {
/* 1900 */         serviceType = this.resultSet.getString("SERVICE_CONTRACT_TYPE_NAME");
/*      */       }
/*      */     }
/*      */     catch (SQLException sqlException)
/*      */     {
/* 1904 */       log.error(
/* 1905 */         ListHelper.class + 
/* 1906 */         ": Error:- While preparing statement to get Service Contract from database.", 
/* 1907 */         sqlException);
/*      */     }
/*      */     catch (Exception exception)
/*      */     {
/* 1910 */       log.error(
/* 1911 */         ListHelper.class + 
/* 1912 */         ": Error:- While getting connection for get Service Contract type form database.", 
/* 1913 */         exception);
/*      */     }
/*      */     finally
/*      */     {
/* 1915 */       JdbcHelper.closeResultSet(this.resultSet);
/* 1916 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/* 1917 */       JdbcHelper.closeConnection(this.connection);
/*      */     }
/* 1919 */     return serviceType;
/*      */   }
/*      */   
/*      */   public String getTrackingUnit(int trackingUnitId)
/*      */     throws Exception
/*      */   {
/* 1923 */     String trackingUnit = null;
/*      */     try
/*      */     {
/* 1925 */       this.connection = getConnection();
/* 1926 */       this.preparedStatement = this.connection
/* 1927 */         .prepareStatement("SELECT TRACKING_UNIT_NAME FROM TAB_SERVICE_TRACKING_UNITWHERE TRACKING_UNIT_ID=?");
/* 1928 */       this.preparedStatement.setInt(1, trackingUnitId);
/* 1929 */       this.resultSet = this.preparedStatement.executeQuery();
/* 1931 */       while (this.resultSet.next()) {
/* 1932 */         trackingUnit = this.resultSet.getString("TRACKING_UNIT_NAME");
/*      */       }
/*      */     }
/*      */     catch (SQLException sqlException)
/*      */     {
/* 1936 */       log.error(
/* 1937 */         ListHelper.class + 
/* 1938 */         ": Error:- While preparing statement to get Service Contract from database.", 
/* 1939 */         sqlException);
/*      */     }
/*      */     catch (Exception exception)
/*      */     {
/* 1942 */       log.error(
/* 1943 */         ListHelper.class + 
/* 1944 */         ": Error:- While getting connection for get Service Contract tracking form database.", 
/* 1945 */         exception);
/*      */     }
/*      */     finally
/*      */     {
/* 1947 */       JdbcHelper.closeResultSet(this.resultSet);
/* 1948 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/* 1949 */       JdbcHelper.closeConnection(this.connection);
/*      */     }
/* 1951 */     return trackingUnit;
/*      */   }
/*      */   
/*      */   public String getVendorName(int vendorId)
/*      */     throws Exception
/*      */   {
/* 1975 */     String vendor = null;
/*      */     try
/*      */     {
/* 1978 */       this.connection = getConnection();
/* 1979 */       this.preparedStatement = this.connection
/* 1980 */         .prepareStatement("SELECT VENDOR_NAME FROM TAB_VENDORS WHERE VENDOR_ID=?");
/* 1981 */       this.preparedStatement.setInt(1, vendorId);
/* 1982 */       this.resultSet = this.preparedStatement.executeQuery();
/* 1984 */       while (this.resultSet.next()) {
/* 1985 */         vendor = this.resultSet.getString("VENDOR_NAME");
/*      */       }
/*      */     }
/*      */     catch (SQLException sqlException)
/*      */     {
/* 1989 */       log.error(
/* 1990 */         ListHelper.class + 
/* 1991 */         ": Error:- While preparing statement to get Vendor name from database.", 
/* 1992 */         sqlException);
/*      */     }
/*      */     catch (Exception exception)
/*      */     {
/* 1995 */       log.error(
/* 1996 */         ListHelper.class + 
/* 1997 */         ": Error:- While getting connection for get Vendor name form database.", 
/* 1998 */         exception);
/*      */     }
/*      */     finally
/*      */     {
/* 2000 */       JdbcHelper.closeResultSet(this.resultSet);
/* 2001 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/* 2002 */       JdbcHelper.closeConnection(this.connection);
/*      */     }
/* 2004 */     return vendor;
/*      */   }
/*      */   
/*      */   public String getProductCategory(int productCategoryId)
/*      */     throws Exception
/*      */   {
/* 2026 */     String productCategory = null;
/*      */     try
/*      */     {
/* 2029 */       this.connection = getConnection();
/* 2030 */       this.preparedStatement = this.connection
/* 2031 */         .prepareStatement("SELECT PRODUCT_CATEGORY_NAME FROM TAB_PRODUCT_CATEGORY WHERE PRODUCT_CATEGORY_ID=?");
/* 2032 */       this.preparedStatement.setInt(1, productCategoryId);
/* 2033 */       this.resultSet = this.preparedStatement.executeQuery();
/* 2035 */       while (this.resultSet.next()) {
/* 2036 */         productCategory = this.resultSet.getString("PRODUCT_CATEGORY_NAME");
/*      */       }
/*      */     }
/*      */     catch (SQLException sqlException)
/*      */     {
/* 2040 */       log.error(
/* 2041 */         ListHelper.class + 
/* 2042 */         ": Error:- While preparing statement to get Product Category name from database.", 
/* 2043 */         sqlException);
/*      */     }
/*      */     catch (Exception exception)
/*      */     {
/* 2046 */       log.error(
/* 2047 */         ListHelper.class + 
/* 2048 */         ": Error:- While getting connection for get Product Category name form database.", 
/* 2049 */         exception);
/*      */     }
/*      */     finally
/*      */     {
/* 2051 */       JdbcHelper.closeResultSet(this.resultSet);
/* 2052 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/* 2053 */       JdbcHelper.closeConnection(this.connection);
/*      */     }
/* 2055 */     return productCategory;
/*      */   }
/*      */   
/*      */   public String getManufacturer(int manufacturerId)
/*      */     throws Exception
/*      */   {
/* 2077 */     String manufacturer = null;
/*      */     try
/*      */     {
/* 2080 */       this.connection = getConnection();
/* 2081 */       this.preparedStatement = this.connection
/* 2082 */         .prepareStatement("SELECT FULL_NAME FROM TAB_CUSTOMER_USER WHERE CUSTOMER_ID=?");
/* 2083 */       this.preparedStatement.setInt(1, manufacturerId);
/* 2084 */       this.resultSet = this.preparedStatement.executeQuery();
/* 2086 */       while (this.resultSet.next()) {
/* 2087 */         manufacturer = this.resultSet.getString("FULL_NAME");
/*      */       }
/*      */     }
/*      */     catch (SQLException sqlException)
/*      */     {
/* 2091 */       log.error(
/* 2092 */         ListHelper.class + 
/* 2093 */         ": Error:- While preparing statement to get Manufacturer name from database.", 
/* 2094 */         sqlException);
/*      */     }
/*      */     catch (Exception exception)
/*      */     {
/* 2097 */       log.error(
/* 2098 */         ListHelper.class + 
/* 2099 */         ": Error:- While getting connection for get Manufacturer name form database.", 
/* 2100 */         exception);
/*      */     }
/*      */     finally
/*      */     {
/* 2102 */       JdbcHelper.closeResultSet(this.resultSet);
/* 2103 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/* 2104 */       JdbcHelper.closeConnection(this.connection);
/*      */     }
/* 2106 */     return manufacturer;
/*      */   }
/*      */   
/*      */   public String getGlAccount(int glAccountId)
/*      */     throws Exception
/*      */   {
/* 2126 */     String glAccount = null;
/*      */     try
/*      */     {
/* 2129 */       this.connection = getConnection();
/* 2130 */       this.preparedStatement = this.connection
/* 2131 */         .prepareStatement("SELECT GL_ACCOUNT_NAME FROM TAB_GL_ACCOUNT WHERE GL_ACCOUNT_ID=?");
/* 2132 */       this.preparedStatement.setInt(1, glAccountId);
/* 2133 */       this.resultSet = this.preparedStatement.executeQuery();
/* 2135 */       while (this.resultSet.next()) {
/* 2136 */         glAccount = this.resultSet.getString("GL_ACCOUNT_NAME");
/*      */       }
/*      */     }
/*      */     catch (SQLException sqlException)
/*      */     {
/* 2140 */       log.error(
/* 2141 */         ListHelper.class + 
/* 2142 */         ": Error:- While preparing statement to get GL Account name from database.", 
/* 2143 */         sqlException);
/*      */     }
/*      */     catch (Exception exception)
/*      */     {
/* 2146 */       log.error(
/* 2147 */         ListHelper.class + 
/* 2148 */         ": Error:- While getting connection for get GL Account name form database.", 
/* 2149 */         exception);
/*      */     }
/*      */     finally
/*      */     {
/* 2151 */       JdbcHelper.closeResultSet(this.resultSet);
/* 2152 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/* 2153 */       JdbcHelper.closeConnection(this.connection);
/*      */     }
/* 2155 */     return glAccount;
/*      */   }
/*      */   
/*      */   public String getTax(int taxId)
/*      */     throws Exception
/*      */   {
/* 2175 */     String tax = null;
/*      */     try
/*      */     {
/* 2178 */       this.connection = getConnection();
/* 2179 */       this.preparedStatement = this.connection
/* 2180 */         .prepareStatement("SELECT TAX_DISPLAY_NAME FROM TAB_TAX WHERE TAX_ID=?");
/* 2181 */       this.preparedStatement.setInt(1, taxId);
/* 2182 */       this.resultSet = this.preparedStatement.executeQuery();
/* 2184 */       while (this.resultSet.next()) {
/* 2185 */         tax = this.resultSet.getString("TAX_DISPLAY_NAME");
/*      */       }
/*      */     }
/*      */     catch (SQLException sqlException)
/*      */     {
/* 2189 */       log.error(
/* 2190 */         ListHelper.class + 
/* 2191 */         ": Error:- While preparing statement to get Tax name from database.", 
/* 2192 */         sqlException);
/*      */     }
/*      */     catch (Exception exception)
/*      */     {
/* 2195 */       log.error(
/* 2196 */         ListHelper.class + 
/* 2197 */         ": Error:- While getting connection for get Tax name form database.", 
/* 2198 */         exception);
/*      */     }
/*      */     finally
/*      */     {
/* 2200 */       JdbcHelper.closeResultSet(this.resultSet);
/* 2201 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/* 2202 */       JdbcHelper.closeConnection(this.connection);
/*      */     }
/* 2204 */     return tax;
/*      */   }
/*      */   
/*      */   public String getHandler(int handlerId)
/*      */     throws Exception
/*      */   {
/* 2224 */     String handler = null;
/*      */     try
/*      */     {
/* 2227 */       this.connection = getConnection();
/* 2228 */       this.preparedStatement = this.connection
/* 2229 */         .prepareStatement("SELECT FULL_NAME FROM TAB_CUSTOMER_USER WHERE CUSTOMER_ID=?");
/* 2230 */       this.preparedStatement.setInt(1, handlerId);
/* 2231 */       this.resultSet = this.preparedStatement.executeQuery();
/* 2233 */       while (this.resultSet.next()) {
/* 2234 */         handler = this.resultSet.getString("FULL_NAME");
/*      */       }
/*      */     }
/*      */     catch (SQLException sqlException)
/*      */     {
/* 2238 */       log.error(
/* 2239 */         ListHelper.class + 
/* 2240 */         ": Error:- While preparing statement to get Handler name from database.", 
/* 2241 */         sqlException);
/*      */     }
/*      */     catch (Exception exception)
/*      */     {
/* 2244 */       log.error(
/* 2245 */         ListHelper.class + 
/* 2246 */         ": Error:- While getting connection for get Handler name form database.", 
/* 2247 */         exception);
/*      */     }
/*      */     finally
/*      */     {
/* 2249 */       JdbcHelper.closeResultSet(this.resultSet);
/* 2250 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/* 2251 */       JdbcHelper.closeConnection(this.connection);
/*      */     }
/* 2253 */     return handler;
/*      */   }
/*      */   
/*      */   public String getAssignTo(int assignToId)
/*      */     throws Exception
/*      */   {
/* 2275 */     String assignToName = null;
/*      */     try
/*      */     {
/* 2277 */       this.connection = getConnection();
/* 2278 */       this.preparedStatement = this.connection
/* 2279 */         .prepareStatement("SELECT FULL_NAME FROM TAB_CUSTOMER_USER WHERE CUSTOMER_ID=?");
/* 2280 */       this.preparedStatement.setInt(1, assignToId);
/*      */       
/* 2282 */       this.resultSet = this.preparedStatement.executeQuery();
/* 2284 */       while (this.resultSet.next())
/*      */       {
/* 2285 */         assignToName = this.resultSet.getString("FULL_NAME");
/* 2286 */         System.out.println("***********" + assignToName);
/*      */       }
/*      */     }
/*      */     catch (SQLException sqlException)
/*      */     {
/* 2290 */       log.error(
/* 2291 */         ListHelper.class + 
/* 2292 */         ": Error:- While preparing statement to get Assign TO Name from database.", 
/* 2293 */         sqlException);
/*      */     }
/*      */     catch (Exception exception)
/*      */     {
/* 2296 */       log.error(
/* 2297 */         ListHelper.class + 
/* 2298 */         ": Error:- While getting connection for get Assign TO Name form database.", 
/* 2299 */         exception);
/*      */     }
/*      */     finally
/*      */     {
/* 2301 */       JdbcHelper.closeResultSet(this.resultSet);
/* 2302 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/* 2303 */       JdbcHelper.closeConnection(this.connection);
/*      */     }
/* 2305 */     return assignToName;
/*      */   }
/*      */   
/*      */   public String getAssignmentOwner(int assignmentOwnerId)
/*      */     throws Exception
/*      */   {
/* 2328 */     String assignmentOwnerName = null;
/*      */     try
/*      */     {
/* 2330 */       this.connection = getConnection();
/* 2331 */       this.preparedStatement = this.connection
/* 2332 */         .prepareStatement("SELECT FULL_NAME FROM TAB_CUSTOMER_USER WHERE CUSTOMER_ID=?");
/* 2333 */       this.preparedStatement.setInt(1, assignmentOwnerId);
/*      */       
/* 2335 */       this.resultSet = this.preparedStatement.executeQuery();
/* 2337 */       while (this.resultSet.next())
/*      */       {
/* 2338 */         assignmentOwnerName = this.resultSet.getString("FULL_NAME");
/* 2339 */         System.out.println("***********" + assignmentOwnerName);
/*      */       }
/*      */     }
/*      */     catch (SQLException sqlException)
/*      */     {
/* 2343 */       log.error(
/* 2344 */         ListHelper.class + 
/* 2345 */         ": Error:- While preparing statement to get Assignment Owner Name from database.", 
/* 2346 */         sqlException);
/*      */     }
/*      */     catch (Exception exception)
/*      */     {
/* 2349 */       log.error(
/* 2350 */         ListHelper.class + 
/* 2351 */         ": Error:- While getting connection for get Assignment Owner Name form database.", 
/* 2352 */         exception);
/*      */     }
/*      */     finally
/*      */     {
/* 2354 */       JdbcHelper.closeResultSet(this.resultSet);
/* 2355 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/* 2356 */       JdbcHelper.closeConnection(this.connection);
/*      */     }
/* 2358 */     return assignmentOwnerName;
/*      */   }
/*      */   
/*      */   public String getAssignmentAccount(int assignmentAccountId)
/*      */   {
/* 2381 */     String assignmentAccountName = null;
/*      */     try
/*      */     {
/* 2383 */       this.connection = getConnection();
/* 2384 */       this.preparedStatement = this.connection
/* 2385 */         .prepareStatement("SELECT ACCOUNT_NAME FROM TAB_ACCOUNT WHERE ACCOUNT_ID=?");
/* 2386 */       this.preparedStatement.setInt(1, assignmentAccountId);
/*      */       
/* 2388 */       this.resultSet = this.preparedStatement.executeQuery();
/* 2390 */       while (this.resultSet.next())
/*      */       {
/* 2391 */         assignmentAccountName = this.resultSet.getString("ACCOUNT_NAME");
/* 2392 */         System.out.println("***********" + assignmentAccountName);
/*      */       }
/*      */     }
/*      */     catch (SQLException sqlException)
/*      */     {
/* 2396 */       log.error(
/* 2397 */         ListHelper.class + 
/* 2398 */         ": Error:- While preparing statement to get Assignment Account Name from database.", 
/* 2399 */         sqlException);
/*      */     }
/*      */     catch (Exception exception)
/*      */     {
/* 2402 */       log.error(
/* 2403 */         ListHelper.class + 
/* 2404 */         ": Error:- While getting connection for get Assignment Account Name form database.", 
/* 2405 */         exception);
/*      */     }
/*      */     finally
/*      */     {
/* 2407 */       JdbcHelper.closeResultSet(this.resultSet);
/* 2408 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/* 2409 */       JdbcHelper.closeConnection(this.connection);
/*      */     }
/* 2411 */     return assignmentAccountName;
/*      */   }
/*      */   
/*      */   public String getAssignmentContactPerson(int assignmentContactPersonId)
/*      */   {
/* 2433 */     String assignmentContactPersonName = null;
/*      */     try
/*      */     {
/* 2435 */       this.connection = getConnection();
/* 2436 */       this.preparedStatement = this.connection
/* 2437 */         .prepareStatement("SELECT CONTACT_PERSON FROM TAB_CONTACT WHERE CONTACT_ID=?");
/* 2438 */       this.preparedStatement.setInt(1, assignmentContactPersonId);
/*      */       
/* 2440 */       this.resultSet = this.preparedStatement.executeQuery();
/* 2442 */       while (this.resultSet.next())
/*      */       {
/* 2443 */         assignmentContactPersonName = this.resultSet.getString("CONTACT_PERSON");
/* 2444 */         System.out.println("***********" + assignmentContactPersonName);
/*      */       }
/*      */     }
/*      */     catch (SQLException sqlException)
/*      */     {
/* 2448 */       log.error(
/* 2449 */         ListHelper.class + 
/* 2450 */         ": Error:- While preparing statement to get Assignment Account Name from database.", 
/* 2451 */         sqlException);
/*      */     }
/*      */     catch (Exception exception)
/*      */     {
/* 2454 */       log.error(
/* 2455 */         ListHelper.class + 
/* 2456 */         ": Error:- While getting connection for get Assignment Account Name form database.", 
/* 2457 */         exception);
/*      */     }
/*      */     finally
/*      */     {
/* 2459 */       JdbcHelper.closeResultSet(this.resultSet);
/* 2460 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/* 2461 */       JdbcHelper.closeConnection(this.connection);
/*      */     }
/* 2463 */     return assignmentContactPersonName;
/*      */   }
/*      */   
/*      */   public String getAssignmentLeadSource(int assignmentLeadSourceId)
/*      */   {
/* 2485 */     String assignmentLeadSourceName = null;
/*      */     try
/*      */     {
/* 2487 */       this.connection = getConnection();
/* 2488 */       this.preparedStatement = this.connection
/* 2489 */         .prepareStatement("SELECT LEAD_SOURCE_NAME FROM TAB_LEAD_SOURCE WHERE LEAD_SOURCE_ID=?");
/* 2490 */       this.preparedStatement.setInt(1, assignmentLeadSourceId);
/*      */       
/* 2492 */       this.resultSet = this.preparedStatement.executeQuery();
/* 2494 */       while (this.resultSet.next())
/*      */       {
/* 2495 */         assignmentLeadSourceName = this.resultSet.getString("LEAD_SOURCE_NAME");
/* 2496 */         System.out.println("***********" + assignmentLeadSourceName);
/*      */       }
/*      */     }
/*      */     catch (SQLException sqlException)
/*      */     {
/* 2500 */       log.error(
/* 2501 */         ListHelper.class + 
/* 2502 */         ": Error:- While preparing statement to get Assignment Lead Source Name from database.", 
/* 2503 */         sqlException);
/*      */     }
/*      */     catch (Exception exception)
/*      */     {
/* 2506 */       log.error(
/* 2507 */         ListHelper.class + 
/* 2508 */         ": Error:- While getting connection for get Assignment Lead Source Name form database.", 
/* 2509 */         exception);
/*      */     }
/*      */     finally
/*      */     {
/* 2511 */       JdbcHelper.closeResultSet(this.resultSet);
/* 2512 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/* 2513 */       JdbcHelper.closeConnection(this.connection);
/*      */     }
/* 2515 */     return assignmentLeadSourceName;
/*      */   }
/*      */   
/*      */   public String getAssignmentLead(int assignmentLeadId)
/*      */   {
/* 2537 */     String assignmentLeadName = null;
/*      */     try
/*      */     {
/* 2539 */       this.connection = getConnection();
/* 2540 */       this.preparedStatement = this.connection
/* 2541 */         .prepareStatement("SELECT CONTACT_PERSON FROM TAB_LEAD_DETAILS WHERE LEAD_ID=?");
/* 2542 */       this.preparedStatement.setInt(1, assignmentLeadId);
/*      */       
/* 2544 */       this.resultSet = this.preparedStatement.executeQuery();
/* 2546 */       while (this.resultSet.next())
/*      */       {
/* 2547 */         assignmentLeadName = this.resultSet.getString("CONTACT_PERSON");
/* 2548 */         System.out.println("***********" + assignmentLeadName);
/*      */       }
/*      */     }
/*      */     catch (SQLException sqlException)
/*      */     {
/* 2552 */       log.error(
/* 2553 */         ListHelper.class + 
/* 2554 */         ": Error:- While preparing statement to get Assignment Lead  Name from database.", 
/* 2555 */         sqlException);
/*      */     }
/*      */     catch (Exception exception)
/*      */     {
/* 2558 */       log.error(
/* 2559 */         ListHelper.class + 
/* 2560 */         ": Error:- While getting connection for get Assignment Lead  Name form database.", 
/* 2561 */         exception);
/*      */     }
/*      */     finally
/*      */     {
/* 2563 */       JdbcHelper.closeResultSet(this.resultSet);
/* 2564 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/* 2565 */       JdbcHelper.closeConnection(this.connection);
/*      */     }
/* 2567 */     return assignmentLeadName;
/*      */   }
/*      */   
/*      */   public String getAssignmentCampaign(int assignmentCampaignId)
/*      */   {
/* 2589 */     String assignmentCampaignName = null;
/*      */     try
/*      */     {
/* 2591 */       this.connection = getConnection();
/* 2592 */       this.preparedStatement = this.connection
/* 2593 */         .prepareStatement("SELECT CAMPAIGN_NAME FROM TAB_CAMPAIGN WHERE CAMPAIGN_ID=?");
/* 2594 */       this.preparedStatement.setInt(1, assignmentCampaignId);
/*      */       
/* 2596 */       this.resultSet = this.preparedStatement.executeQuery();
/* 2598 */       while (this.resultSet.next())
/*      */       {
/* 2599 */         assignmentCampaignName = this.resultSet.getString("CAMPAIGN_NAME");
/* 2600 */         System.out.println("***********" + assignmentCampaignName);
/*      */       }
/*      */     }
/*      */     catch (SQLException sqlException)
/*      */     {
/* 2604 */       log.error(
/* 2605 */         ListHelper.class + 
/* 2606 */         ": Error:- While preparing statement to get Assignment Campaign  Name from database.", 
/* 2607 */         sqlException);
/*      */     }
/*      */     catch (Exception exception)
/*      */     {
/* 2610 */       log.error(
/* 2611 */         ListHelper.class + 
/* 2612 */         ": Error:- While getting connection for get Assignment Campaign Name form database.", 
/* 2613 */         exception);
/*      */     }
/*      */     finally
/*      */     {
/* 2615 */       JdbcHelper.closeResultSet(this.resultSet);
/* 2616 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/* 2617 */       JdbcHelper.closeConnection(this.connection);
/*      */     }
/* 2619 */     return assignmentCampaignName;
/*      */   }
/*      */   
/*      */   public String getVendorCategory(int vendorCategoryID)
/*      */   {
/* 2640 */     String vendorCategoryName = null;
/*      */     try
/*      */     {
/* 2642 */       this.connection = getConnection();
/* 2643 */       this.preparedStatement = this.connection
/* 2644 */         .prepareStatement("SELECT VENDOR_CATEGORY_NAME FROM TAB_VENDOR_CATEGORY WHERE VENDOR_CATEGORY_ID=?");
/* 2645 */       this.preparedStatement.setInt(1, vendorCategoryID);
/*      */       
/* 2647 */       this.resultSet = this.preparedStatement.executeQuery();
/* 2649 */       while (this.resultSet.next()) {
/* 2650 */         vendorCategoryName = this.resultSet.getString("VENDOR_CATEGORY_NAME");
/*      */       }
/*      */     }
/*      */     catch (SQLException sqlException)
/*      */     {
/* 2655 */       log.error(
/* 2656 */         NameHelper.class + 
/* 2657 */         ": Error:- While preparing statement to get Vendor Name from database.", 
/* 2658 */         sqlException);
/*      */     }
/*      */     catch (Exception exception)
/*      */     {
/* 2661 */       log.error(
/* 2662 */         NameHelper.class + 
/* 2663 */         ": Error:- While getting connection for get Vendor Name form database.", 
/* 2664 */         exception);
/*      */     }
/*      */     finally
/*      */     {
/* 2666 */       JdbcHelper.closeResultSet(this.resultSet);
/* 2667 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/* 2668 */       JdbcHelper.closeConnection(this.connection);
/*      */     }
/* 2670 */     return vendorCategoryName;
/*      */   }
/*      */   
/*      */   public String getForgetPasswordSecurityQuestion(int securityQuestionID)
/*      */   {
/* 2693 */     String securityQuestionName = null;
/*      */     try
/*      */     {
/* 2695 */       this.connection = getConnection();
/* 2696 */       this.preparedStatement = this.connection
/* 2697 */         .prepareStatement("SELECT SEQ_QUESTION FROM TAB_SECURITY_QUESTION_LIST WHERE SEQ_QUE_ID=?");
/* 2698 */       this.preparedStatement.setInt(1, securityQuestionID);
/*      */       
/* 2700 */       this.resultSet = this.preparedStatement.executeQuery();
/* 2702 */       while (this.resultSet.next()) {
/* 2703 */         securityQuestionName = 
/* 2704 */           this.resultSet.getString("SEQ_QUESTION");
/*      */       }
/*      */     }
/*      */     catch (SQLException sqlException)
/*      */     {
/* 2709 */       log.error(
/* 2710 */         NameHelper.class + 
/* 2711 */         ": Error:- While preparing statement to get Security Question from database.", 
/* 2712 */         sqlException);
/*      */     }
/*      */     catch (Exception exception)
/*      */     {
/* 2715 */       log.error(
/* 2716 */         NameHelper.class + 
/* 2717 */         ": Error:- While getting connection for get Security Question form database.", 
/* 2718 */         exception);
/*      */     }
/*      */     finally
/*      */     {
/* 2720 */       JdbcHelper.closeResultSet(this.resultSet);
/* 2721 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/* 2722 */       JdbcHelper.closeConnection(this.connection);
/*      */     }
/* 2724 */     return securityQuestionName;
/*      */   }
/*      */   
/*      */   public String getTravelMode(int travelModeId)
/*      */   {
/* 2748 */     String travelMode = null;
/*      */     try
/*      */     {
/* 2750 */       this.connection = getConnection();
/* 2751 */       this.preparedStatement = this.connection
/* 2752 */         .prepareStatement("SELECT TRAVEL_MODE FROM TAB_TRAVEL_MODE WHERE TRAVEL_MODE_ID=?");
/* 2753 */       this.preparedStatement.setInt(1, travelModeId);
/*      */       
/* 2755 */       this.resultSet = this.preparedStatement.executeQuery();
/* 2757 */       while (this.resultSet.next()) {
/* 2758 */         travelMode = this.resultSet.getString("TRAVEL_MODE");
/*      */       }
/*      */     }
/*      */     catch (SQLException sqlException)
/*      */     {
/* 2763 */       log.error(
/* 2764 */         NameHelper.class + 
/* 2765 */         ": Error:- While preparing statement to get Travel Mode from database.", 
/* 2766 */         sqlException);
/*      */     }
/*      */     catch (Exception exception)
/*      */     {
/* 2769 */       log.error(
/* 2770 */         NameHelper.class + 
/* 2771 */         ": Error:- While getting connection for get Travel Mode form database.", 
/* 2772 */         exception);
/*      */     }
/*      */     finally
/*      */     {
/* 2774 */       JdbcHelper.closeResultSet(this.resultSet);
/* 2775 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/* 2776 */       JdbcHelper.closeConnection(this.connection);
/*      */     }
/* 2778 */     return travelMode;
/*      */   }
/*      */   
/*      */   public String getNoteCreatedByName(int createdBy)
/*      */   {
/* 2801 */     String noteCreatedByName = null;
/*      */     try
/*      */     {
/* 2803 */       this.connection = getConnection();
/* 2804 */       this.preparedStatement = this.connection
/* 2805 */         .prepareStatement("SELECT FULL_NAME FROM TAB_CUSTOMER_USER WHERE CREATED_BY=?");
/* 2806 */       this.preparedStatement.setInt(1, createdBy);
/*      */       
/* 2808 */       this.resultSet = this.preparedStatement.executeQuery();
/* 2810 */       while (this.resultSet.next()) {
/* 2811 */         noteCreatedByName = this.resultSet.getString("FULL_NAME");
/*      */       }
/*      */     }
/*      */     catch (SQLException sqlException)
/*      */     {
/* 2816 */       log.error(
/* 2817 */         NameHelper.class + 
/* 2818 */         ": Error:- While preparing statement to get Created by Name from database.", 
/* 2819 */         sqlException);
/*      */     }
/*      */     catch (Exception exception)
/*      */     {
/* 2822 */       log.error(
/* 2823 */         NameHelper.class + 
/* 2824 */         ": Error:- While getting connection for get Created by Name form database.", 
/* 2825 */         exception);
/*      */     }
/*      */     finally
/*      */     {
/* 2827 */       JdbcHelper.closeResultSet(this.resultSet);
/* 2828 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/* 2829 */       JdbcHelper.closeConnection(this.connection);
/*      */     }
/* 2831 */     return noteCreatedByName;
/*      */   }
/*      */   
/*      */   public String getRegularCustomerNameById(int customerId)
/*      */   {
/* 2836 */     String custName = null;
/*      */     try
/*      */     {
/* 2838 */       this.connection = getConnection();
/* 2839 */       this.preparedStatement = this.connection
/* 2840 */         .prepareStatement("SELECT REG_FULL_NAME FROM TAB_REGULAR_CUSTOMER WHERE REG_CUSTOMER_ID=?");
/* 2841 */       this.preparedStatement.setInt(1, customerId);
/*      */       
/* 2843 */       this.resultSet = this.preparedStatement.executeQuery();
/* 2845 */       while (this.resultSet.next()) {
/* 2846 */         custName = this.resultSet.getString("REG_FULL_NAME");
/*      */       }
/*      */     }
/*      */     catch (SQLException sqlException)
/*      */     {
/* 2851 */       log.error(
/* 2852 */         NameHelper.class + 
/* 2853 */         ": Error:- While preparing statement to get Customer name by id from database.", 
/* 2854 */         sqlException);
/*      */     }
/*      */     catch (Exception exception)
/*      */     {
/* 2857 */       log.error(
/* 2858 */         NameHelper.class + 
/* 2859 */         ": Error:- While getting connection for get Customer name by id  form database.", 
/* 2860 */         exception);
/*      */     }
/*      */     finally
/*      */     {
/* 2862 */       JdbcHelper.closeResultSet(this.resultSet);
/* 2863 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/* 2864 */       JdbcHelper.closeConnection(this.connection);
/*      */     }
/* 2866 */     return custName;
/*      */   }
/*      */   
/*      */   public String getProductNameById(int productId)
/*      */   {
/* 2872 */     String productName = null;
/*      */     try
/*      */     {
/* 2874 */       this.connection = getConnection();
/* 2875 */       this.preparedStatement = this.connection
/* 2876 */         .prepareStatement("SELECT PRODUCT_NAME FROM TAB_PRODUCT_DETAILS WHERE PRODUCT_ID=?");
/* 2877 */       this.preparedStatement.setInt(1, productId);
/*      */       
/* 2879 */       this.resultSet = this.preparedStatement.executeQuery();
/* 2881 */       while (this.resultSet.next())
/*      */       {
/* 2882 */         productName = this.resultSet.getString("PRODUCT_NAME");
/* 2883 */         System.out.println("gsgssggsgs" + productName);
/*      */       }
/*      */     }
/*      */     catch (SQLException sqlException)
/*      */     {
/* 2887 */       log.error(
/* 2888 */         NameHelper.class + 
/* 2889 */         ": Error:- While preparing statement to get product name by id from database.", 
/* 2890 */         sqlException);
/*      */     }
/*      */     catch (Exception exception)
/*      */     {
/* 2893 */       log.error(
/* 2894 */         NameHelper.class + 
/* 2895 */         ": Error:- While getting connection for get product name by id  form database.", 
/* 2896 */         exception);
/*      */     }
/*      */     finally
/*      */     {
/* 2898 */       JdbcHelper.closeResultSet(this.resultSet);
/* 2899 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/* 2900 */       JdbcHelper.closeConnection(this.connection);
/*      */     }
/* 2902 */     return productName;
/*      */   }
/*      */   
/*      */   public String getDealerNameById(int dealerId)
/*      */   {
/* 2908 */     String dealerName = null;
/*      */     try
/*      */     {
/* 2910 */       this.connection = getConnection();
/* 2911 */       this.preparedStatement = this.connection
/* 2912 */         .prepareStatement("SELECT DEALER_FULL_NAME FROM TAB_DEALER_DETAIL WHERE DEALER_ID=?");
/* 2913 */       this.preparedStatement.setInt(1, dealerId);
/*      */       
/* 2915 */       this.resultSet = this.preparedStatement.executeQuery();
/* 2917 */       while (this.resultSet.next())
/*      */       {
/* 2918 */         dealerName = this.resultSet.getString("DEALER_FULL_NAME");
/* 2919 */         System.out.println("we r in namehelper dealer" + dealerName + " " + dealerId);
/*      */       }
/*      */     }
/*      */     catch (SQLException sqlException)
/*      */     {
/* 2923 */       log.error(
/* 2924 */         NameHelper.class + 
/* 2925 */         ": Error:- While preparing statement to get Dealer name by id from database.", 
/* 2926 */         sqlException);
/*      */     }
/*      */     catch (Exception exception)
/*      */     {
/* 2929 */       log.error(
/* 2930 */         NameHelper.class + 
/* 2931 */         ": Error:- While getting connection for get Dealer name by id  form database.", 
/* 2932 */         exception);
/*      */     }
/*      */     finally
/*      */     {
/* 2934 */       JdbcHelper.closeResultSet(this.resultSet);
/* 2935 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/* 2936 */       JdbcHelper.closeConnection(this.connection);
/*      */     }
/* 2938 */     return dealerName;
/*      */   }
/*      */   
/*      */   public String getTaxValueById(int taxId)
/*      */   {
/* 2944 */     String taxValue = null;
/*      */     try
/*      */     {
/* 2946 */       this.connection = getConnection();
/* 2947 */       this.preparedStatement = this.connection
/* 2948 */         .prepareStatement("SELECT  TAX_TOTAL FROM TAB_TAX WHERE TAX_ID=?");
/* 2949 */       this.preparedStatement.setInt(1, taxId);
/*      */       
/* 2951 */       this.resultSet = this.preparedStatement.executeQuery();
/* 2953 */       while (this.resultSet.next()) {
/* 2954 */         taxValue = this.resultSet.getString("TAX_TOTAL");
/*      */       }
/*      */     }
/*      */     catch (SQLException sqlException)
/*      */     {
/* 2959 */       log.error(
/* 2960 */         NameHelper.class + 
/* 2961 */         ": Error:- While preparing statement to get Tax Value by id from database.", 
/* 2962 */         sqlException);
/*      */     }
/*      */     catch (Exception exception)
/*      */     {
/* 2965 */       log.error(
/* 2966 */         NameHelper.class + 
/* 2967 */         ": Error:- While getting connection for get Tax Value by id  form database.", 
/* 2968 */         exception);
/*      */     }
/*      */     finally
/*      */     {
/* 2970 */       JdbcHelper.closeResultSet(this.resultSet);
/* 2971 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/* 2972 */       JdbcHelper.closeConnection(this.connection);
/*      */     }
/* 2974 */     return taxValue;
/*      */   }
/*      */   
/*      */   public String getPaymentModeById(int payModeId)
/*      */   {
/* 2979 */     String taxValue = null;
/*      */     try
/*      */     {
/* 2981 */       this.connection = getConnection();
/* 2982 */       this.preparedStatement = this.connection
/* 2983 */         .prepareStatement("SELECT PAY_MODE_NAME FROM TAB_PAYMENT_MODE WHERE PAY_MODE_ID=?");
/* 2984 */       this.preparedStatement.setInt(1, payModeId);
/*      */       
/* 2986 */       this.resultSet = this.preparedStatement.executeQuery();
/* 2988 */       while (this.resultSet.next()) {
/* 2989 */         taxValue = this.resultSet.getString("PAY_MODE_NAME");
/*      */       }
/*      */     }
/*      */     catch (SQLException sqlException)
/*      */     {
/* 2994 */       log.error(
/* 2995 */         NameHelper.class + 
/* 2996 */         ": Error:- While preparing statement to get Tax Value by id from database.", 
/* 2997 */         sqlException);
/*      */     }
/*      */     catch (Exception exception)
/*      */     {
/* 3000 */       log.error(
/* 3001 */         NameHelper.class + 
/* 3002 */         ": Error:- While getting connection for get Tax Value by id  form database.", 
/* 3003 */         exception);
/*      */     }
/*      */     finally
/*      */     {
/* 3005 */       JdbcHelper.closeResultSet(this.resultSet);
/* 3006 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/* 3007 */       JdbcHelper.closeConnection(this.connection);
/*      */     }
/* 3009 */     return taxValue;
/*      */   }
/*      */   
/*      */   public String getConsumerCustomerNameById(int customerId)
/*      */   {
/* 3013 */     String custName = null;
/*      */     try
/*      */     {
/* 3015 */       this.connection = getConnection();
/* 3016 */       this.preparedStatement = this.connection
/* 3017 */         .prepareStatement("SELECT CON_FULL_NAME FROM TAB_CONSUMER_CUSTOMER WHERE  CON_CUSTOMER_ID=?");
/* 3018 */       this.preparedStatement.setInt(1, customerId);
/*      */       
/* 3020 */       this.resultSet = this.preparedStatement.executeQuery();
/* 3022 */       while (this.resultSet.next()) {
/* 3023 */         custName = this.resultSet.getString("CON_FULL_NAME");
/*      */       }
/*      */     }
/*      */     catch (SQLException sqlException)
/*      */     {
/* 3028 */       log.error(
/* 3029 */         NameHelper.class + 
/* 3030 */         ": Error:- While preparing statement to get Customer name by id from database.", 
/* 3031 */         sqlException);
/*      */     }
/*      */     catch (Exception exception)
/*      */     {
/* 3034 */       log.error(
/* 3035 */         NameHelper.class + 
/* 3036 */         ": Error:- While getting connection for get Customer name by id  form database.", 
/* 3037 */         exception);
/*      */     }
/*      */     finally
/*      */     {
/* 3039 */       JdbcHelper.closeResultSet(this.resultSet);
/* 3040 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/* 3041 */       JdbcHelper.closeConnection(this.connection);
/*      */     }
/* 3043 */     return custName;
/*      */   }
/*      */   
/*      */   public String getStateNameByStateId(int stateId)
/*      */   {
/* 3048 */     String stateName = null;
/*      */     try
/*      */     {
/* 3050 */       this.connection = getConnection();
/* 3051 */       this.preparedStatement = this.connection
/* 3052 */         .prepareStatement("SELECT CITY_STATE FROM CITIES WHERE CITY_ID=?");
/* 3053 */       this.preparedStatement.setInt(1, stateId);
/*      */       
/* 3055 */       this.resultSet = this.preparedStatement.executeQuery();
/* 3057 */       while (this.resultSet.next()) {
/* 3058 */         stateName = this.resultSet.getString("CITY_STATE");
/*      */       }
/*      */     }
/*      */     catch (SQLException sqlException)
/*      */     {
/* 3063 */       log.error(
/* 3064 */         NameHelper.class + 
/* 3065 */         ": Error:- While preparing statement to get state by id from database.", 
/* 3066 */         sqlException);
/*      */     }
/*      */     catch (Exception exception)
/*      */     {
/* 3069 */       log.error(
/* 3070 */         NameHelper.class + 
/* 3071 */         ": Error:- While getting connection for get state by id  form database.", 
/* 3072 */         exception);
/*      */     }
/*      */     finally
/*      */     {
/* 3074 */       JdbcHelper.closeResultSet(this.resultSet);
/* 3075 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/* 3076 */       JdbcHelper.closeConnection(this.connection);
/*      */     }
/* 3078 */     return stateName;
/*      */   }
/*      */   
/*      */   public String getCityNameByCityId(int cityId)
/*      */   {
/* 3083 */     String cityName = null;
/*      */     try
/*      */     {
/* 3085 */       this.connection = getConnection();
/* 3086 */       this.preparedStatement = this.connection
/* 3087 */         .prepareStatement("SELECT CITY_NAME FROM CITIES WHERE CITY_ID=?");
/* 3088 */       this.preparedStatement.setInt(1, cityId);
/*      */       
/* 3090 */       this.resultSet = this.preparedStatement.executeQuery();
/* 3092 */       while (this.resultSet.next())
/*      */       {
/* 3093 */         cityName = this.resultSet.getString("CITY_NAME");
/* 3094 */         System.out.println("NAME HELPPPPPPPP" + cityName);
/*      */       }
/*      */     }
/*      */     catch (SQLException sqlException)
/*      */     {
/* 3098 */       log.error(
/* 3099 */         NameHelper.class + 
/* 3100 */         ": Error:- While preparing statement to get city by id from database.", 
/* 3101 */         sqlException);
/*      */     }
/*      */     catch (Exception exception)
/*      */     {
/* 3104 */       log.error(
/* 3105 */         NameHelper.class + 
/* 3106 */         ": Error:- While getting connection for get city by id  form database.", 
/* 3107 */         exception);
/*      */     }
/*      */     finally
/*      */     {
/* 3109 */       JdbcHelper.closeResultSet(this.resultSet);
/* 3110 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/* 3111 */       JdbcHelper.closeConnection(this.connection);
/*      */     }
/* 3113 */     return cityName;
/*      */   }
/*      */   
/*      */   public String getProductTypeNameByProductId(int typeId)
/*      */   {
/* 3118 */     String stateName = null;
/*      */     try
/*      */     {
/* 3120 */       this.connection = getConnection();
/* 3121 */       this.preparedStatement = this.connection
/* 3122 */         .prepareStatement("SELECT CEMENT_TYPE_NAME FROM TAB_CEMENT_TYPE WHERE CEMENT_TYPE_ID=?");
/* 3123 */       this.preparedStatement.setInt(1, typeId);
/*      */       
/* 3125 */       this.resultSet = this.preparedStatement.executeQuery();
/* 3127 */       while (this.resultSet.next()) {
/* 3128 */         stateName = this.resultSet.getString("CEMENT_TYPE_NAME");
System.out.println(stateName+"stateName");
/*      */       }
/*      */     }
/*      */     catch (SQLException sqlException)
/*      */     {
/* 3133 */       log.error(
/* 3134 */         NameHelper.class + 
/* 3135 */         ": Error:- While preparing statement to get TYPE by id from database.", 
/* 3136 */         sqlException);
/*      */     }
/*      */     catch (Exception exception)
/*      */     {
/* 3139 */       log.error(
/* 3140 */         NameHelper.class + 
/* 3141 */         ": Error:- While getting connection for get type by id  form database.", 
/* 3142 */         exception);
/*      */     }
/*      */     finally
/*      */     {
/* 3144 */       JdbcHelper.closeResultSet(this.resultSet);
/* 3145 */       JdbcHelper.closePreparedStatement(this.preparedStatement);
/* 3146 */       JdbcHelper.closeConnection(this.connection);
/*      */     }
/* 3148 */     return stateName;
/*      */   }
/*      */
public int getProductCategoryIdByProductType(int inconterm) {
	int category = 0;
	try {
		connection = getConnection();
		preparedStatement = connection
				.prepareStatement(QueryMaker.GET_CATEGORY_BY_ID);
		preparedStatement.setInt(1, inconterm);
System.out.println("HHHHHHHHHHHHHHHHHHHUUUUUUUUUUUUUUUUU"+inconterm);
		resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {
			System.out.println("HHHHHHHHHHHHHHHHHHHUUUUUUUUUUUUUUUUU"+inconterm+"vv"+resultSet.getInt("PRODUCT_CATEGORY"));
			category = resultSet.getInt("PRODUCT_CATEGORY");

		}
	} catch (SQLException sqlException) {

		log.error(
				NameHelper.class
						+ ": Error:- While preparing statement to get category by id from database.",
				sqlException);
	} catch (Exception exception) {

		log.error(
				NameHelper.class
						+ ": Error:- While getting connection for get category by id  form database.",
				exception);
	} finally {
		JdbcHelper.closeResultSet(resultSet);
		JdbcHelper.closePreparedStatement(preparedStatement);
		JdbcHelper.closeConnection(connection);
	}
	return category;
}

public String getProductCategoryNameById(int id) {
	String category = null;
	try {
		connection = getConnection();
		preparedStatement = connection
				.prepareStatement(QueryMaker.GET_CATEGORY_NAME_BY_ID);
		preparedStatement.setInt(1, id);

		resultSet = preparedStatement.executeQuery();
System.out.println("nammeeeeeeeeheelp!!!"+id);
		while (resultSet.next()) {
			category = resultSet.getString("PRODUCT_CATEGORY_NAME");
System.out.println("category"+category);
		}
	} catch (SQLException sqlException) {

		log.error(
				NameHelper.class
						+ ": Error:- While preparing statement to get category by id from database.",
				sqlException);
	} catch (Exception exception) {

		log.error(
				NameHelper.class
						+ ": Error:- While getting connection for get category by id  form database.",
				exception);
	} finally {
		JdbcHelper.closeResultSet(resultSet);
		JdbcHelper.closePreparedStatement(preparedStatement);
		JdbcHelper.closeConnection(connection);
	}
	return category;
}
}


/* Location:           C:\Users\bharti\Desktop\Chouksay\lost\
 * Qualified Name:     com.bst.ckt.helper.NameHelper
 * JD-Core Version:    0.7.0.1
 */