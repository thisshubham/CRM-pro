package com.bst.ckt.action;

import java.io.File;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.bst.ckt.common.LoginUtil;
import com.bst.ckt.common.OMIConstants;
import com.bst.ckt.dao.AjaxDaoImpl;
import com.bst.ckt.dao.UserManagementDaoImpl;
import com.bst.ckt.dao.UserManagementDaoInf;
import com.bst.ckt.framework.user.CustomerSessionUser;
import com.bst.ckt.framework.user.ShopName;
import com.bst.ckt.framework.user.UserRole;
import com.bst.ckt.framework.user.UserStatus;
import com.bst.ckt.helper.ListHelper;
import com.bst.ckt.helper.Salutation;
import com.bst.ckt.service.CustomerServiceImpl;
import com.bst.ckt.service.CustomerServiceInf;
import com.bst.ckt.service.UserManagementServiceImpl;
import com.bst.ckt.service.UserManagementServiceInf;
import com.bst.ckt.vo.CustomerVO;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserManagementAction extends ActionSupport implements
		ModelDriven<CustomerVO>, ServletResponseAware, ServletRequestAware,
		SessionAware {

	/**
	 * Creating Logger object, logger object mapped with UserManagementAction
	 * class for writing Loggers.
	 */
	private static final Logger logger = Logger
			.getLogger(UserManagementAction.class);
	AjaxDaoImpl ajaxDaoImpl = new AjaxDaoImpl();
	ListHelper listHelper = new ListHelper();
	CustomerVO customerVO = new CustomerVO();
	HttpServletRequest request = (HttpServletRequest) ActionContext
			.getContext().get(ServletActionContext.HTTP_REQUEST);
	CustomerServiceInf customerServiceInf=null;
	
	HttpServletResponse response = null;
	Map<String, Object> session = null;
	Hashtable<Integer, String> userRoleList = null;
	Hashtable<Integer, String> shopNameList = null;
	UserManagementServiceInf userManagementServiceInf = null;
	Map<Integer, String> cuntryList = null;
	Hashtable<Integer, String> userStatus = null;
	Hashtable<Integer, String> userStatusList = null;
	private String userImageFileName = null;
	private String userImageContentType = null;
	private File userImage = null;
	Map<Integer, String> currencyList = null;
	Map<Integer, String> languageList = null;
	Map<Integer, String> departmentList = null;
	Map<Integer, String> designationList = null;
	Map<Integer, String> timeZoneList = null;
	private List<CustomerVO> userSocialDetailsGrid = null;
	private Map<Integer, String> userSocialSiteValueList;
	private HashMap<Integer, String> salutationList;
	

	
	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public String execute() throws Exception {
		UserManagementDaoInf userManagementDaoInf = new UserManagementDaoImpl();
		CustomerSessionUser customerSessionUser = LoginUtil
				.getCurrentCustomerUser();
		customerVO.setCustomerId(customerSessionUser.getCustomerId());
		customerVO.setCompanyId(customerSessionUser.getCompanyId());
		userTitleGrid = userManagementDaoInf.getUserDetails(customerVO);
		return SUCCESS;

	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public UserManagementAction() throws Exception {
		cuntryList = listHelper.countryList();
		this.userRoleList = UserRole.getCreateUserRoleList();
		this.shopNameList=ShopName.getCreateShopNameList();
		this.userStatusList = UserStatus.getUserStatusList();
		userSocialSiteValueList=listHelper.socialSiteValueList();
		salutationList=Salutation.getSalutationList();
		
	}

	/**
	 * <p>
	 * <code>addUserDetail()</code>this method is used to add the user into the
	 * database.
	 * </p>
	 * 
	 * 
	 * @return SUCCESS
	 * @throws Exception
	 */
	public String addUserDetail() throws Exception {

		userManagementServiceInf = new UserManagementServiceImpl();
		CustomerSessionUser customerSessionUser = LoginUtil
				.getCurrentCustomerUser();
		customerVO.setCustomerId(customerSessionUser.getCustomerId());
		customerVO.setCompanyId(customerSessionUser.getCompanyId());
		
		String message = userManagementServiceInf
				.registerUserDetail(customerVO);

		/**
		 * TARGET_SUCCESS; TARGET_FAILURE
		 */
		if (OMIConstants.TARGET_SUCCESS.equalsIgnoreCase(message)) {
			logger.info("Successfully Insert User Details!");
			addActionMessage("Successfully Insert User Details!");
			return SUCCESS;

		} else if (OMIConstants.TARGET_FAILURE.equalsIgnoreCase(message)) {

			logger.info("Error:while  Insert User Details!");
			addActionError("Error:while  Insert User Details!");
			return INPUT;
		}

		return NONE;
	}

	/**
	 * <p>
	 * <code>verifyChangeEmail()</code> Method designed to verify customer new
	 * email id.
	 * </p>
	 * 
	 * @return result String
	 */
	public String verifyCustomerStaff() throws Exception {

		String referenceId = request.getParameter("validateId");
		userManagementServiceInf = new UserManagementServiceImpl();
		String target = userManagementServiceInf
				.verifyCustomerStaffUser(referenceId);

		if (target.equals(OMIConstants.TARGET_SUCCESS)) {
			addActionMessage("Your Customer staff user Email Verification complted, Please check you email for login details.");
			return SUCCESS;
		} else if (target
				.equals(OMIConstants.TARGET_CUSTOMER_USER_ALREADY_REGISTERED)) {
			addActionError("Your Customer staff user Email Verification already completed, Please check your email id for login credentials.");
			return ERROR;
		} else if (target.equals(OMIConstants.TARGET_COMPANY_FAILED)) {
			addActionError("Your Customer staff user  Email Verification complted, But company registration failed. Please contact our support team.");
			return ERROR;
		} else {
			addActionError("Your Customer staff user Email Verification failed, Please try agin or contact our support team.");
			return ERROR;
		}
	}

	private List<CustomerVO> userTitleGrid = null;

	public List<CustomerVO> getUserTitleGrid() {
		return userTitleGrid;
	}

	/**
	 * <p>
	 * <code>setUserTitleGrid()</code> method is use to show the Users details
	 * into Setting User grid
	 * </p>
	 * 
	 * @return
	 * @throws Exception
	 */
	public void setUserTitleGrid(List<CustomerVO> userTitleGrid) {
		this.userTitleGrid = userTitleGrid;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	

	/**
	 * emailAlreadyExist method verify whether the email id already exists
	 * 
	 * @return
	 * @throws Exception
	 */
	public String emailAlreadyExist() throws Exception {

		try {

			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
			PrintWriter printWriter = response.getWriter();

			if (ajaxDaoImpl.emailAlreadyExist(request.getParameter(
					"primaryEmailId").trim()) == 1) {
				printWriter
						.print("<img alt='Email Id is blank' title='Email Id is blank' src='outer/img/exist.png'></img>");

			} else if (customerVO.getPrimaryEmailId().equals("")) {
				printWriter
						.print("<img alt='Mobile no is Blank' height='30px' width='30px'  title=' Mobile no is Blank' src='outer/img/blank.jpeg'></img>");

			}

			else {
				printWriter
						.print("<img alt='Email Available' title='Email Id Available' src='outer/img/availavle.png'></img>");
			}

		} catch (Exception exception) {
			logger.error(
					"Error While verifying whether  the email id already exists ",
					exception);
		}
		return NONE;
	}

	/**
	 * <p>
	 * <code>editUserDetails</code>Method is use to edit the user details by
	 * Admin user
	 * </p>
	 * 
	 * @return
	 * @throws Exception
	 */
	public String editUserDetails() throws Exception {
		System.out.println("Action classs");
		cuntryList = listHelper.countryList();
		currencyList = listHelper.currencyList();
		 languageList = listHelper.languageList();
		 departmentList = listHelper.departmentList();
		 designationList = listHelper.designationList();
		 timeZoneList = listHelper.timeZoneList();
		int customerId = Integer.parseInt(request.getParameter("command"));
		LoginUtil.setProcessUserId(customerId);
		userManagementServiceInf = new UserManagementServiceImpl();

		try {
			this.customerVO = userManagementServiceInf.editUserInfo(customerVO,customerId);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return SUCCESS;
	}

	/**
	 * <p>
	 * <code>editUserDetails</code>Method is use to edit the user details by
	 * Admin user
	 * </p>
	 * 
	 * @return
	 * @throws Exception
	 */
	public String updateUserDetails() throws Exception {
		cuntryList = listHelper.countryList();
		currencyList = listHelper.currencyList();
		 languageList = listHelper.languageList();
		 departmentList = listHelper.departmentList();
		 designationList = listHelper.designationList();
		 timeZoneList = listHelper.timeZoneList();
		userManagementServiceInf = new UserManagementServiceImpl();
		int customerId = LoginUtil.getProcessUserId();
		String filePath = request.getServletContext().getRealPath("/").concat("profileImage");
		String message = userManagementServiceInf.updateUserInfo(customerVO,
				customerId, filePath, userImageFileName);
		
		if (OMIConstants.TARGET_SUCCESS.equalsIgnoreCase(message)) {
			logger.info("Successfully Update User Information!");
			addActionMessage("Successfully Update User Information!");
			return SUCCESS;

		} else if (OMIConstants.TARGET_FAILURE.equalsIgnoreCase(message)) {
			logger.info("Error:while  Updating User Information!");
			addActionError("Error:while  Updating User Information!");
			return INPUT;
		}

		return SUCCESS;
	}
	
	
	/**
	 * <p>
	 * <code>updateUserLoginPassword()</code> method change the customer
	 * login password.
	 * </p>
	 * 
	 * @return SUCCESS String
	 * @throws Exception
	 */
	public String updateUserLoginPassword() throws Exception {
		userManagementServiceInf = new UserManagementServiceImpl();
		int customerId = LoginUtil.getProcessUserId();
		LoginUtil.setProcessUserId(customerId);
		String message = userManagementServiceInf.updateUserLoginPassword(
				customerVO, customerId);
		if (OMIConstants.TARGET_SUCCESS.equalsIgnoreCase(message)) {
			logger.info("  Password Successfully Update!");
			addActionMessage("Password Successfully Update!");
			return SUCCESS;

		} else if (OMIConstants.TARGET_FAILURE.equalsIgnoreCase(message)) {
			logger.info("Error:while  Updating Customer Password!");
			addActionError("Error:while  Updating Customer Password!");
			return INPUT;
		}
		return SUCCESS;
	}
	
	/**
	 * <p>
	 * <code>changeUserEmail()</code> method will change the customer
	 * Email Id by Admin.
	 * </p>
	 * 
	 * @return SUCCESS String
	 * @throws Exception
	 */
	public String changeUserEmail() throws Exception {
		
		userManagementServiceInf = new UserManagementServiceImpl();
		int customerId = LoginUtil.getProcessUserId();
		LoginUtil.setProcessUserId(customerId);
		System.out.println("Action Class Customer Id"+customerId);
		String message = userManagementServiceInf.updateUserEmail(
				customerVO, customerId);
		System.out.println("Action Class Customer Id"+customerId);
		if (OMIConstants.TARGET_SUCCESS.equalsIgnoreCase(message)) {
			logger.info("  Email Id Successfully Update!");
			addActionMessage("Email Id Successfully Update!");
			return SUCCESS;

		} else if (OMIConstants.TARGET_FAILURE.equalsIgnoreCase(message)) {
			logger.info("Error:while  Updating Customer Email Id!");
			addActionError("Error:while  Updating Customer Email Id!");
			return INPUT;
		}
		return SUCCESS;
	}
	
	
	/**
	 * <p>
	 * <code>verifyChangeEmail()</code> Method designed to verify customer new
	 * email id.
	 * </p>
	 * 
	 * @return result String
	 */
	public String verifyChangeUserEmailId() throws Exception {

		String referenceId = request.getParameter("validateId");
		System.out.println("we are in validateGuidId customer id is:"
				+ referenceId);
		userManagementServiceInf = new UserManagementServiceImpl();
		String target = userManagementServiceInf
				.verifyChangeUserEmail(referenceId);

		if (target.equals(OMIConstants.TARGET_SUCCESS)) {
			addActionMessage("Your Change user Email Verification complted, Please check you email for login details.");
			return SUCCESS;
		} else if (target
				.equals(OMIConstants.TARGET_CUSTOMER_USER_ALREADY_REGISTERED)) {
			addActionError("Your Change user Email Verification already completed, Please check your email id for login credentials.");
			return ERROR;
		} else if (target.equals(OMIConstants.TARGET_COMPANY_FAILED)) {
			addActionError("Your Change user Email Verification complted, But company registration failed. Please contact our support team.");
			return ERROR;
		} else {
			addActionError("Your Change user Email Verification failed, Please try agin or contact our support team.");
			return ERROR;
		}
	}

	
	/**
	 * <p>
	 * <code>userSocialGrid()</code> this method design to display user
	 * social details from the database.
	 * </p>
	 * 
	 * @return SUCCESS
	 * @throws Exception
	 */

	public String userSocialGrid() throws Exception {
		userManagementServiceInf = new UserManagementServiceImpl();
		try {
			int customerId = LoginUtil.getProcessUserId();
			userSocialDetailsGrid = userManagementServiceInf
					.getuserSocialDetailsList(customerId);
			return SUCCESS;
		} catch (Exception exception) {
			logger.error("Fail to get customer Id");
			return ERROR;
		}

	}
	
	/**
	 * <p>
	 * <code>addUserSocial()</code> this method design to add user social into the
	 * database.
	 * </p>
	 * 
	 * @return SUCCESS
	 * @throws Exception
	 */

	public String addUserSocial() throws Exception {
		userManagementServiceInf = new UserManagementServiceImpl();
		String message = null;
		int customerId=LoginUtil.getProcessUserId();
		customerVO.setCustomerId(customerId);
		message = userManagementServiceInf.addUserSocialInformation(customerVO); 
		if (OMIConstants.TARGET_SUCCESS.equalsIgnoreCase(message)) {
			userSocialDetailsGrid = userManagementServiceInf
					.getuserSocialDetailsList(customerId);
			logger.info("User social details inserted successfully.");
			addActionMessage("User social details inserted successfully.");
			return SUCCESS;
		} else if (OMIConstants.TARGET_SUCCESS1.equalsIgnoreCase(message)) {
			userSocialDetailsGrid = userManagementServiceInf
					.getuserSocialDetailsList(customerId);
			logger.info("User social details updated successfully.");
			addActionMessage("User social details updated successfully.");
			return SUCCESS;
		}
		else if(OMIConstants.TARGET_FAILURE.equalsIgnoreCase(message)){
			logger.info("Error:While inserting and updating User social details.");
			addActionError("Error:While inserting and updating User social details.");
			return INPUT;		
		}
		return NONE;
	}
	
	/**
	 * <p>
	 * <code>viewUserDetails()</code> method is use to view the lead details into view lead
	 * page
	 * </p>
	 * 
	 * @return
	 * @throws Exception
	 */
	public String viewUserDetails() throws Exception {
		customerServiceInf=new CustomerServiceImpl();
		int customerId = Integer.parseInt(request.getParameter("command"));
		customerVO.setCustomerId(customerId);
		this.customerVO = customerServiceInf.viewUserInformation(customerVO);
		
		return SUCCESS;
	}
	
	
	@Override
	public CustomerVO getModel() {

		return customerVO;
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	/**
	 * @return the userStatus
	 */
	public Hashtable<Integer, String> getUserStatus() {
		return userStatus;
	}

	/**
	 * @param userStatus
	 *            the userStatus to set
	 */
	public void setUserStatus(Hashtable<Integer, String> userStatus) {
		this.userStatus = userStatus;
	}

	public Hashtable<Integer, String> getUserRoleList() {
		return userRoleList;
	}

	public void setUserRoleList(Hashtable<Integer, String> userRoleList) {
		this.userRoleList = userRoleList;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public ListHelper getListHelper() {
		return listHelper;
	}

	public void setListHelper(ListHelper listHelper) {
		this.listHelper = listHelper;
	}

	public CustomerVO getCustomerVO() {
		return customerVO;
	}

	public void setCustomerVO(CustomerVO customerVO) {
		this.customerVO = customerVO;
	}

	public UserManagementServiceInf getUserManagementServiceInf() {
		return userManagementServiceInf;
	}

	public void setUserManagementServiceInf(
			UserManagementServiceInf userManagementServiceInf) {
		this.userManagementServiceInf = userManagementServiceInf;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	/**
	 * @return the userStatusList
	 */
	public Hashtable<Integer, String> getUserStatusList() {
		return userStatusList;
	}

	/**
	 * @param userStatusList
	 *            the userStatusList to set
	 */
	public void setUserStatusList(Hashtable<Integer, String> userStatusList) {
		this.userStatusList = userStatusList;
	}

	/**
	 * @return the userImageFileName
	 */
	public String getUserImageFileName() {
		return userImageFileName;
	}

	/**
	 * @param userImageFileName
	 *            the userImageFileName to set
	 */
	public void setUserImageFileName(String userImageFileName) {
		this.userImageFileName = userImageFileName;
	}

	/**
	 * @return the userImageContentType
	 */
	public String getUserImageContentType() {
		return userImageContentType;
	}

	/**
	 * @param userImageContentType
	 *            the userImageContentType to set
	 */
	public void setUserImageContentType(String userImageContentType) {
		this.userImageContentType = userImageContentType;
	}

	/**
	 * @return the userImage
	 */
	public File getUserImage() {
		return userImage;
	}

	/**
	 * @param userImage
	 *            the userImage to set
	 */
	public void setUserImage(File userImage) {
		this.userImage = userImage;
	}

	/**
	 * @return the cuntryList
	 */
	public Map<Integer, String> getCuntryList() {
		return cuntryList;
	}

	/**
	 * @param cuntryList
	 *            the cuntryList to set
	 */
	public void setCuntryList(Map<Integer, String> cuntryList) {
		this.cuntryList = cuntryList;
	}

	/**
	 * @return the currencyList
	 */
	public Map<Integer, String> getCurrencyList() {
		return currencyList;
	}

	/**
	 * @param currencyList
	 *            the currencyList to set
	 */
	public void setCurrencyList(Map<Integer, String> currencyList) {
		this.currencyList = currencyList;
	}

	/**
	 * @return the languageList
	 */
	public Map<Integer, String> getLanguageList() {
		return languageList;
	}

	/**
	 * @param languageList
	 *            the languageList to set
	 */
	public void setLanguageList(Map<Integer, String> languageList) {
		this.languageList = languageList;
	}

	/**
	 * @return the departmentList
	 */
	public Map<Integer, String> getDepartmentList() {
		return departmentList;
	}

	/**
	 * @param departmentList
	 *            the departmentList to set
	 */
	public void setDepartmentList(Map<Integer, String> departmentList) {
		this.departmentList = departmentList;
	}

	/**
	 * @return the designationList
	 */
	public Map<Integer, String> getDesignationList() {
		return designationList;
	}

	/**
	 * @param designationList
	 *            the designationList to set
	 */
	public void setDesignationList(Map<Integer, String> designationList) {
		this.designationList = designationList;
	}

	/**
	 * @return the timeZoneList
	 */
	public Map<Integer, String> getTimeZoneList() {
		return timeZoneList;
	}

	/**
	 * @param timeZoneList
	 *            the timeZoneList to set
	 */
	public void setTimeZoneList(Map<Integer, String> timeZoneList) {
		this.timeZoneList = timeZoneList;
	}

	public List<CustomerVO> getUserSocialDetailsGrid() {
		return userSocialDetailsGrid;
	}

	public void setUserSocialDetailsGrid(List<CustomerVO> userSocialDetailsGrid) {
		this.userSocialDetailsGrid = userSocialDetailsGrid;
	}

	public Map<Integer, String> getUserSocialSiteValueList() {
		return userSocialSiteValueList;
	}

	public void setUserSocialSiteValueList(
			Map<Integer, String> userSocialSiteValueList) {
		this.userSocialSiteValueList = userSocialSiteValueList;
	}

	/**
	 * @return the salutationList
	 */
	public HashMap<Integer, String> getSalutationList() {
		return salutationList;
	}

	/**
	 * @param salutationList the salutationList to set
	 */
	public void setSalutationList(HashMap<Integer, String> salutationList) {
		this.salutationList = salutationList;
	}

	public Hashtable<Integer, String> getShopNameList() {
		return shopNameList;
	}

	public void setShopNameList(Hashtable<Integer, String> shopNameList) {
		this.shopNameList = shopNameList;
	}

	/*@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		
	}
	*/
}
