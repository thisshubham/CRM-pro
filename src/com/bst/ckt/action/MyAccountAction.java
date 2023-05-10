/**
 * 
 */
package com.bst.ckt.action;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.bst.ckt.common.LoginUtil;
import com.bst.ckt.common.OMIConstants;
import com.bst.ckt.dao.MyAccountDaoImpl;
import com.bst.ckt.dao.MyAccountDaoInf;
import com.bst.ckt.framework.user.CustomerSessionUser;
import com.bst.ckt.helper.ListHelper;
import com.bst.ckt.helper.Salutation;
import com.bst.ckt.service.MyAccountServiceImpl;
import com.bst.ckt.service.MyAccountServiceInf;
import com.bst.ckt.vo.CustomerVO;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @author Deepak Vishwakarma
 * 
 */
public class MyAccountAction extends ActionSupport implements
		ModelDriven<CustomerVO>, ServletRequestAware, ServletResponseAware,
		SessionAware {

	/**
	 * Creating Logger object, logger object mapped with MyAccountAction class
	 * for writing Loggers.
	 */
	private static final Logger logger = Logger
			.getLogger(MyAccountAction.class);

	/**
	 * serialVersionUID is automatic generated
	 */
	private static final long serialVersionUID = 513087134436555608L;

	CustomerVO customerVO = new CustomerVO();
	HttpServletRequest request = null;
	HttpServletResponse response = null;
	Map<String, Object> session = null;
	MyAccountServiceInf myAccountServiceInf = new MyAccountServiceImpl();
	private Map<Integer, String> countryList;
	ListHelper listHelper = new ListHelper();
	private Map<Integer, String> securityQuestionList;

	private String userImageFileName = null;
	private String userImageContentType = null;
	private File userImage = null;
	private Map<Integer, String> customerSocialSiteValueList;
	private List<CustomerVO> customerSocialDetailsGrid;
	MyAccountDaoInf myAccountDaoInf = null;
	private Map<Integer, String> salutationList;

	public String execute() throws Exception {
		countryList = listHelper.countryList();
		securityQuestionList = listHelper.securityQuestionList();
		myAccountServiceInf = new MyAccountServiceImpl();
		CustomerSessionUser customerSessionUser = LoginUtil
				.getCurrentCustomerUser();
		customerVO.setCustomerId(customerSessionUser.getCustomerId());
		LoginUtil.setProcessUserId(customerSessionUser.getCustomerId());
		try {
			this.customerVO = myAccountServiceInf.editCustomerInfo(customerVO);
			System.out.println("****************+" + customerVO.getCurrency());
			System.out.println("****************+" + customerVO.getLanguage());

		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return SUCCESS;
	}

	/**
	 * <p>
	 * Constructor
	 * </p>
	 * 
	 * @throws Exception
	 */
	public MyAccountAction() throws Exception {
		customerSocialSiteValueList = listHelper.socialSiteValueList();
		securityQuestionList = listHelper.securityQuestionList();
		salutationList = Salutation.getSalutationList();
		
	}

	/**
	 * <p>
	 * <code>upDateCustomerInfo()</code> method update customer information into
	 * database.
	 * </p>
	 * 
	 * @return SUCCESS String
	 * @throws Exception
	 */
	public String upDateCustomerInfo() throws Exception {
		myAccountServiceInf = new MyAccountServiceImpl();
		countryList = listHelper.countryList();
		CustomerSessionUser customerSessionUser = LoginUtil
				.getCurrentCustomerUser();
		customerVO.setCustomerId(customerSessionUser.getCustomerId());
		String path = request.getSession().getServletContext().getRealPath("/")
				.concat("profileImage")
				+ File.separator
				+ customerSessionUser.getCustomerId()
				+ File.separator;
		System.out.println("filePath " + path);

		String userImageName = customerSessionUser.getCustomerId() + ".png";

		File fileToCreate = new File(path, userImageName);
		String filePath = path + userImageName;
		// customerVO.setUploadedFilePath(filePath);
		FileUtils.copyFile(customerVO.getProfileImage(), fileToCreate);

		String message = myAccountServiceInf.upDateCustomerInfo(customerVO,
				filePath, userImageFileName);
		if (OMIConstants.TARGET_SUCCESS.equalsIgnoreCase(message)) {
			this.customerVO = myAccountServiceInf.editCustomerInfo(customerVO);
			logger.info("Successfully Update Account Information!");
			addActionMessage("Successfully Update Account Information!");
			return SUCCESS;

		} else if (OMIConstants.TARGET_FAILURE.equalsIgnoreCase(message)) {
			logger.info("Error:while  Updating Account Information!");
			addActionError("Error:while  Updating Account Information!");
			return INPUT;
		}
		return NONE;
	}

	/**
	 * <p>
	 * <code>updateCustomerLoginPassword()</code> method change the customer
	 * login password.
	 * </p>
	 * 
	 * @return SUCCESS String
	 * @throws Exception
	 */
	public String updateCustomerLoginPassword() throws Exception {
		myAccountServiceInf = new MyAccountServiceImpl();
		CustomerSessionUser customerSessionUser = LoginUtil
				.getCurrentCustomerUser();
		customerVO.setCustomerId(customerSessionUser.getCustomerId());
		customerVO.setPrimaryEmailId(customerSessionUser.getEmail());
		String message = myAccountServiceInf
				.updateCustomerLoginPassword(customerVO);
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
	 * <code>securityQuestionForAuthntication()</code> this method design to
	 * update the user security question and answer.
	 * </p>
	 * 
	 * @return
	 * @throws Exception
	 */
	public String securityQuestionForAuthntication() throws Exception {
		CustomerSessionUser customerSessionUser = LoginUtil
				.getCurrentCustomerUser();
		customerVO.setCustomerId(customerSessionUser.getCustomerId());
		System.out
				.println("security question------------------------------------------ ");
		customerVO.setPrimaryEmailId(customerSessionUser.getEmail());
		myAccountServiceInf = new MyAccountServiceImpl();
		String message = myAccountServiceInf
				.updateCustomerSecqurityQuestion(customerVO);
		System.out.println("security question ");
		if (OMIConstants.TARGET_SUCCESS.equalsIgnoreCase(message)) {
			logger.info("  Secqurity Question Successfully Update!");
			addActionMessage("Secqurity Question Successfully Update!");
			return SUCCESS;

		} else if (OMIConstants.TARGET_FAILURE.equalsIgnoreCase(message)) {
			logger.info("Error:while  Updating Customer Secqurity Question!");
			addActionError("Error:while  Updating Customer Secqurity Question!");
			return INPUT;
		}
		return SUCCESS;

	}

	/**
	 * <p>
	 * <code>addUserSocial()</code> this method design to add user social into
	 * the database.
	 * </p>
	 * 
	 * @return SUCCESS
	 * @throws Exception
	 */

	public String addUserSocial() throws Exception {

		myAccountServiceInf = new MyAccountServiceImpl();
		String message = null;
		int customerId = LoginUtil.getProcessUserId();
		customerVO.setCustomerId(customerId);
		message = myAccountServiceInf.addUserSocialInformation(customerVO);

		myAccountDaoInf = new MyAccountDaoImpl();

		if (OMIConstants.TARGET_SUCCESS.equalsIgnoreCase(message)) {
			customerSocialDetailsGrid = myAccountDaoInf
					.getUserSocialDetailsList(customerId);
			logger.info("User social details inserted successfully.");
			addActionMessage("User social details inserted successfully.");
			return SUCCESS;
		} else if (OMIConstants.TARGET_SUCCESS1.equalsIgnoreCase(message)) {
			customerSocialDetailsGrid = myAccountDaoInf
					.getUserSocialDetailsList(customerId);
			logger.info("User social details updated successfully.");
			addActionMessage("User social details updated successfully.");
			return SUCCESS;
		} else if (OMIConstants.TARGET_FAILURE.equalsIgnoreCase(message)) {
			logger.info("Error:While inserting and updating User social details.");
			addActionError("Error:While inserting and updating User social details.");
			return INPUT;
		}
		return NONE;
	}

	/**
	 * <p>
	 * <code>showCustomerSocialDetails()</code> this method design to display
	 * lead social details from the database.
	 * </p>
	 * 
	 * @return SUCCESS
	 * @throws Exception
	 */
	public String showCustomerSocialDetails() throws Exception {
		myAccountDaoInf = new MyAccountDaoImpl();

		int customerId = LoginUtil.getProcessUserId();
		System.out.println("Social information in Action MyAccount"
				+ customerId);
		customerSocialDetailsGrid = myAccountDaoInf
				.getUserSocialDetailsList(customerId);

		return SUCCESS;
	}

	/**
	 * <p>
	 * <code>deleteCustomerSocialDetails()</code> Method designed to delete Customer Social Information.
	 * </p>
	 * 
	 * @return result String
	 */
	public String deleteCustomerSocialDetails() throws Exception
	{
		int id = Integer.parseInt(request.getParameter("command"));
		myAccountServiceInf = new MyAccountServiceImpl();
		String target = myAccountServiceInf.deleteCustomerSocialDetails(id);
		if (target.equals(OMIConstants.TARGET_SUCCESS)) {
			addActionMessage(" Social Informaion Deleted.");
			return SUCCESS;
		}
			else {
				addActionError("Error Occured While deleted Social Information.");
				return ERROR;
			}
		}

	
	/**
	 * <p>
	 * <code>changeUserEmail()</code> method will change the customer Email Id
	 * by Admin.
	 * </p>
	 * 
	 * @return SUCCESS String
	 * @throws Exception
	 */
	public String changeUserEmail() throws Exception {

		myAccountServiceInf = new MyAccountServiceImpl();
		CustomerSessionUser customerSessionUser = LoginUtil
				.getCurrentCustomerUser();
		customerVO.setCustomerId(customerSessionUser.getCustomerId());
		String message = myAccountServiceInf.updateUserEmail(customerVO);
		System.out.println("Action Class--------------------------------*****");
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
		myAccountServiceInf = new MyAccountServiceImpl();
		String target = myAccountServiceInf.verifyChangeUserEmail(referenceId);
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
	 * <code>closeAccountRequest</code>Method Is designed to do close account of
	 * the user after verify the user is really want to close his account from
	 * the Vcrm.
	 * </p>
	 * 
	 * @return
	 * @throws Exception
	 */
	public String closeAccountRequest() throws Exception {

		myAccountServiceInf = new MyAccountServiceImpl();
		CustomerSessionUser customerSessionUser = LoginUtil
				.getCurrentCustomerUser();
		customerVO.setCustomerId(customerSessionUser.getCustomerId());
		customerVO.setPrimaryEmailId(customerSessionUser.getEmail());

		String message = myAccountServiceInf.closeUserAcount(customerVO);
		if (OMIConstants.TARGET_SUCCESS.equalsIgnoreCase(message)) {
			logger.info("  User Account Successfully Closed");
			addActionMessage("User Account Successfully Closed !");
			return SUCCESS;

		} else if (OMIConstants.TARGET_FAILURE.equalsIgnoreCase(message)) {
			logger.info("Error:while  Close User Account!");
			addActionError("Error:while  Close User Account!");
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
	public String verifyCloseAccount() throws Exception {
		try {
			String referenceId = request.getParameter("validateId");
			myAccountServiceInf = new MyAccountServiceImpl();
			String target = myAccountServiceInf.verifyCloseAccount(referenceId);

			if (target.equals(OMIConstants.TARGET_SUCCESS)) {
				addActionMessage("Your Close Account Verification complted.");
				return SUCCESS;
			} else if (target
					.equals(OMIConstants.TARGET_CUSTOMER_USER_ALREADY_REGISTERED)) {
				addActionError("Your Close Account Verification complted.");
				return INPUT;
			} else if (target.equals(OMIConstants.TARGET_COMPANY_FAILED)) {
				addActionError("Your Close Account  failed. Please contact our support team.");
				return ERROR;
			} else {
				addActionError("Your Close Account failed, Please try agin or contact our support team.");
				return ERROR;
			}
		} catch (Exception exception) {
			logger.error("Error while closeing account");
			return ERROR;
		}

	}

	/**
	 * <p>
	 * <code>verifyContinueAccount()</code> Method designed to verify customer
	 * new email id.
	 * </p>
	 * 
	 * @return result String
	 */
	public String verifyContinueAccount() throws Exception {
		try {
			String referenceId = request.getParameter("validateId");
			myAccountServiceInf = new MyAccountServiceImpl();
			String target = myAccountServiceInf
					.verifyContinueAccount(referenceId);

			if (target.equals(OMIConstants.TARGET_SUCCESS)) {
				addActionMessage("Your Continue Account Verification complted.");
				return SUCCESS;
			} else if (target
					.equals(OMIConstants.TARGET_CUSTOMER_USER_ALREADY_REGISTERED)) {
				addActionError("Your Continue Account Verification complted.");
				return INPUT;
			} else if (target.equals(OMIConstants.TARGET_COMPANY_FAILED)) {
				addActionError("Your Continue Account  failed. Please contact our support team.");
				return ERROR;
			} else {
				addActionError("Your Continue Account failed, Please try agin or contact our support team.");
				return ERROR;
			}
		} catch (Exception exception) {
			logger.error("Null pointer $$$$$$$$$$$$$$$$$");
			return ERROR;
		}

	}

	public CustomerVO getCustomerVO() {
		return customerVO;
	}

	public void setCustomerVO(CustomerVO customerVO) {
		this.customerVO = customerVO;
	}

	@Override
	public CustomerVO getModel() {

		return customerVO;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	public Map<Integer, String> getCountryList() {
		return countryList;
	}

	public void setCountryList(Map<Integer, String> countryList) {
		this.countryList = countryList;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
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

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public ListHelper getListHelper() {
		return listHelper;
	}

	public void setListHelper(ListHelper listHelper) {
		this.listHelper = listHelper;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public String getUserImageFileName() {
		return userImageFileName;
	}

	public void setUserImageFileName(String userImageFileName) {
		this.userImageFileName = userImageFileName;
	}

	public String getUserImageContentType() {
		return userImageContentType;
	}

	public void setUserImageContentType(String userImageContentType) {
		this.userImageContentType = userImageContentType;
	}

	public File getUserImage() {
		return userImage;
	}

	public void setUserImage(File userImage) {
		this.userImage = userImage;
	}

	public Map<Integer, String> getCustomerSocialSiteValueList() {
		return customerSocialSiteValueList;
	}

	public void setCustomerSocialSiteValueList(
			Map<Integer, String> customerSocialSiteValueList) {
		this.customerSocialSiteValueList = customerSocialSiteValueList;
	}

	public List<CustomerVO> getCustomerSocialDetailsGrid() {
		return customerSocialDetailsGrid;
	}

	public void setCustomerSocialDetailsGrid(
			List<CustomerVO> customerSocialDetailsGrid) {
		this.customerSocialDetailsGrid = customerSocialDetailsGrid;
	}

	/**
	 * @return the securityQuestionList
	 */
	public Map<Integer, String> getSecurityQuestionList() {
		return securityQuestionList;
	}

	/**
	 * @param securityQuestionList
	 *            the securityQuestionList to set
	 */
	public void setSecurityQuestionList(
			Map<Integer, String> securityQuestionList) {
		this.securityQuestionList = securityQuestionList;
	}

	public Map<Integer, String> getSalutationList() {
		return salutationList;
	}

	public void setSalutationList(Map<Integer, String> salutationList) {
		this.salutationList = salutationList;
	}

}
