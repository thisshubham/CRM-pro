package com.bst.ckt.service;

import org.apache.log4j.Logger;

import com.bst.ckt.common.EmailHelper;
import com.bst.ckt.common.OMIConstants;
import com.bst.ckt.dao.AjaxDaoImpl;
import com.bst.ckt.dao.AjaxDaoInf;
import com.bst.ckt.dao.CustomerDaoImpl;
import com.bst.ckt.dao.CustomerDaoInf;
import com.bst.ckt.dto.Customer;
import com.bst.ckt.exception.CreateFailedException;
import com.bst.ckt.exception.EmailSendFailedException;
import com.bst.ckt.exception.OMIApplicationException;
import com.bst.ckt.exception.RecordNotFoundException;
import com.bst.ckt.exception.UpdateFailedException;
import com.bst.ckt.framework.util.IDGenerator;
import com.bst.ckt.vo.CompanyVO;
import com.bst.ckt.vo.CustomerVO;
import com.bst.ckt.vo.LoginVO;

public class CustomerServiceImpl implements CustomerServiceInf {

	/**
	 * Creating Logger object, logger object mapped with CustomerRegistration
	 * class for writing Loggers.
	 */
	private static final Logger logger = Logger
			.getLogger(CustomerServiceImpl.class);

	CustomerDaoInf customerDaoInf=null;
	Customer customer = null;

	/**
	 * <p>
	 * This method find the customer user details based on passing email id, and
	 * verifying the password. If Email id and password will match with database
	 * record, It fetches the Customer User Details from database and return it
	 * for setting these values in session object while login process.
	 * </p>
	 */
	public Customer verifyCustomerUserCredentials(String emailId)
			throws OMIApplicationException {

		Customer customer = null;
		try {
			customerDaoInf = new CustomerDaoImpl();

			// Get the user details from database based on userId
			customer = customerDaoInf.findCustomerUserByEmailId(emailId);

		} catch (RecordNotFoundException recordNotFoundException) {
			logger.error(
					"CustomerUser is not verified with email id and password, "
							+ "Error while fetching the records during customer user credentils "
							+ "processing during user login.",
					recordNotFoundException);
		}
		return customer;
	}

	/**
	 * 
	 */
	public String verifyCustomerReferenceNo(String custReferenceNo) {
		String target = OMIConstants.TARGET_FAILURE;
		try {
			customerDaoInf = new CustomerDaoImpl();
			customer = customerDaoInf.getCompanyDetails(custReferenceNo);
			if (customer != null) {
				int companyID = registerComapny(customer);
				if (companyID != 0) {
					AjaxDaoInf ajaxDaoInf = new AjaxDaoImpl();

					if (ajaxDaoInf.isEmailAlreadySaved(customer
							.getPrimaryEmailId()) != 1) {

						int registerFlag = registerCustomer(customer, companyID);
						if (registerFlag == 1) {
							target = OMIConstants.TARGET_SUCCESS;
						} else {
							logger.error("Error while customer creation based on companyID during verifyEmail process.");
						}
					} else {
						logger.error("Customer already registed with same email id.");
						target = OMIConstants.TARGET_CUSTOMER_USER_ALREADY_REGISTERED;

					}
				} else {
					logger.error("Error while company creation based on custReferenceNo during verifyEmail process.");
					target = OMIConstants.TARGET_COMPANY_FAILED;
				}
			} else {
				logger.error("Error while getting customer registration detsils based on custReferenceNo during verifyEmail process.");
			}
		} catch (RecordNotFoundException recordNotFoundException) {
			logger.error(
					"No record matched with registration Ref No, please see the log:",
					recordNotFoundException);
		} catch (Exception exception) {
			logger.error(
					"problem during verifying registration Ref No, please see the log:",
					exception);
		}
		return target;
	}

	/**
	 * 
	 * @param customer
	 * @return
	 * @throws OMIApplicationException
	 */
	protected int registerComapny(Customer customer)
			throws OMIApplicationException {
		int companyID = 0;

		customerDaoInf = new CustomerDaoImpl();
		try {
			companyID = customerDaoInf.getCompanyIdByRef(customer
					.getRegistrationRefNo());

			if (companyID == 0) {
				customerDaoInf.createCompany(customer);
				companyID = customerDaoInf.getCompanyIdByRef(customer
						.getRegistrationRefNo());
			}

		} catch (CreateFailedException createFailedException) {
			logger.error(
					"Creation failed - company registration failed during verification process.",
					createFailedException);
		} catch (Exception exception) {
			logger.error(
					"Company creation failed, Please refer the below logs:",
					exception);
		}
		return companyID;
	}

	/**
	 * 
	 * @param customer
	 * @param companyId
	 * @return
	 * @throws OMIApplicationException
	 */
	protected int registerCustomer(Customer customer, int companyId)
			throws OMIApplicationException {
		int emailFlag = 0;
		String password = IDGenerator.generateAlphaNumericID(8);
		String emailSubject = "Welcome to Rohit Inventory CRM - Account Activation";
		try {
			customerDaoInf = new CustomerDaoImpl();
			customerDaoInf.createCustomer(customer, companyId, password);
			try {
				String welcomeMessage = getWelcomeEmailMessage(
						customer.getFullName(), customer.getPrimaryEmailId(),
						password);
				EmailHelper.sendEmail(customer.getPrimaryEmailId(),
						emailSubject, welcomeMessage);
				customerDaoInf.updateCustomerEmailFlagByEmail(
						customer.getPrimaryEmailId(), OMIConstants.TRUE);
				emailFlag = 1;
			} catch (EmailSendFailedException emailSendFailedException) {
				logger.error(
						"Email Sending failed - Problem during sending welcome email to customer as part of verifyEmail process.",
						emailSendFailedException);
			} catch (UpdateFailedException updateFailedException) {
				logger.error(
						"Updation failed - Problem during Customer email flag updation as part of verifyEmail process.",
						updateFailedException);
			} catch (Exception exception) {
				logger.error(
						"Problem during fetch the customer id based on company ref no.",
						exception);
			}
		} catch (CreateFailedException createFailedException) {
			logger.error(
					"Creation failed - customer registration failed during verification process.",
					createFailedException);

		} catch (Exception exception) {
			logger.error(
					"Customer creation failed, Please refer the below logs:",
					exception);

		}
		return emailFlag;
	}

	/**
	 * <p>
	 * <code>quickRegisterUser(CompanyVO) </code> is designed to register user
	 * information in temporary database. To carry the registration process we
	 * can register customer and send the verify URL to customer email id. Below
	 * target will set for action result mapping.
	 * <ul>
	 * <li><code>OMIConstants.TARGET_FAILURE</code> will return, when Quick
	 * registration failed.</li>
	 * <li><code>OMIConstants.TARGET_SUCCESS</code> will return, when Quick
	 * registration completed.</li>
	 * <li><code>OMIConstants.TARGET_VERIFICATION_EMAIL_SEND_FAILED</code> will
	 * return, when failed to send verification email.</li>
	 * <li><code>OMIConstants.TARGET_EMAIL_FLAG_UPDATION_FAILED</code> will
	 * return, when failed to update email flag into database.</li>
	 * </ul>
	 * </p>
	 * 
	 * @see OMIConstants#TARGET_FAILURE
	 * @see OMIConstants#TARGET_SUCCESS
	 * @see OMIConstants#TARGET_VERIFICATION_EMAIL_SEND_FAILED
	 * @see OMIConstants#TARGET_EMAIL_FLAG_UPDATION_FAILED
	 * @param CompanyVO
	 * @return
	 * @return target message will return based on succeed or failure of
	 *         customer registration.
	 * @throws OMIApplicationException
	 */
	public String quickRegisterCustomer(CompanyVO companyVO)
			throws OMIApplicationException {
		String target = OMIConstants.TARGET_FAILURE;
		try {
			customerDaoInf = new CustomerDaoImpl();

			// Get auto generated 27 character Alpha Numeric unique id for add
			// company details.
			String companyRefNo = IDGenerator.generateAlphaNumericID(27);

			// Setting auto generated password to available CompanyVO
			companyVO.setCompanyRefNo(companyRefNo);

			customerDaoInf.insertQuickRegistraionDetails(companyVO);

			try {
				target = sendEmailVerification(companyVO.getFullName(),
						companyVO.getCompanyEmailId(), companyRefNo);

			} catch (EmailSendFailedException emailSendFailedException) {
				logger.error(
						"Quick Customer Registration successful, Failed to send verification email.",
						emailSendFailedException);
				return target;
			}
			return target;
		}

		catch (CreateFailedException createFailedException) {
			logger.error(
					"Quick Customer Registration Failed during inserting the data into database.",
					createFailedException);
			return target;
		}

		catch (Exception exception) {
			logger.error("Quick Customer Registration Failed", exception);
			return target;
		}

	}

	/**
	 * 
	 * @param fullName
	 * @param companyEmailId
	 * @param companyRefNo
	 * @return
	 * @throws EmailSendFailedException
	 */
	private String sendEmailVerification(String fullName,
			String companyEmailId, String companyRefNo)
			throws EmailSendFailedException {
		String target = OMIConstants.TARGET_VERIFICATION_EMAIL_SEND_FAILED;
		try {

			/*String url = "http://localhost:8080/PROJ037-01/verifyEmail?validateId="
					+ companyRefNo;*/

			String url = "http://www.rohittradersvidisha.com/verifyEmail?validateId="
					+ companyRefNo;
			
			String message = getEmailVerificationMessage(fullName, url);
			EmailHelper.sendEmail(companyEmailId.trim(), "Email Verification",
					message);
			try {
				customerDaoInf
						.updateEmailFlagCustomerRegistration(companyRefNo);
				target = OMIConstants.TARGET_SUCCESS;
			} catch (UpdateFailedException updateFailedException) {
				updateFailedException.printStackTrace();
				target = OMIConstants.TARGET_EMAIL_FLAG_UPDATION_FAILED;
			}

		} catch (EmailSendFailedException emailSendFailedException) {
			logger.error(
					"Verify customer email sending fail, while quick customer registration process.",
					emailSendFailedException);
		}
		return target;
	}

	/**
	 * 
	 * @param fullName
	 * @param url
	 * @return
	 */
	private String getEmailVerificationMessage(String fullName, String url) {

		StringBuffer messageBuffer = new StringBuffer();

		messageBuffer.append("Dear " + fullName + "\n\n");
		messageBuffer
				.append("Thank you for registering with Rohit Traders services.\n\nTo confirm your registration, Please click on the link below for verify./n your email-id.If you are unable to confirm your registration within specific period, do not hesitate to Contact Us: "
						+ url);
		messageBuffer
				.append("\n\n For any queries related to Rohit Traders, please send us mail support@vanracrm.com");
		messageBuffer
				.append("\n\n Have a Great Day!\n\nThank You,\nRohit Traders Team\nhttp://www.birjasoft.com");

		messageBuffer
				.append("\n\n Note: This is a system generated Email. Kindly do not reply to the sender of this Email.Legal Disclaimer: This Website/ E-mail are vulnerable to data corruption, interception, tampering,viruses as well as delivery errors and we do not accept liability for any consequence that may arise there from.");
		messageBuffer
				.append("\n\nContact Us: is link here which have to call the http://www.birjasoft.com/userlogin.actionURL-Link: should be in blue color with underline");
		return messageBuffer.toString();
	}

	/**
	 * 
	 * @param fullName
	 * @param url
	 * @return
	 */

	private String getForgetEmailVerificationMessage(String fullName,
			String email, String password, String url) {

		StringBuffer messageBuffer = new StringBuffer();

		messageBuffer.append("Dear " + fullName + "\n\n");

		messageBuffer
				.append("We recently received a request of forgot password for your Rohit traders inventory account. This request was made on if you made this request, please use the following details: "
						+ "\n\nUser Email Id : "
						+ email
						+ "\nOld Password : " + password);

		messageBuffer
				.append("\n\nThanks for registering with us. \n\nGetting started with VANRA CRM is easier than you think. "
						+ "\nYou can verify your email with above username and password with click on below verification link.: "
						+ "\nVerification Link : " + url);
		messageBuffer
				.append("\n\nFor further process, please Login Here.");
		messageBuffer
				.append("\nFor any help or clarification, please Contact Us");
		messageBuffer
		.append("\n\nThank You,\nVanraCRM Team\nhttp://www.vanracrm.com");
		

		return messageBuffer.toString();
	}

	/**
	 * <p>
	 * <code>getWelcomeEmailMessage()</code> Method designed to prepare the
	 * email message with user name and password.
	 * </p>
	 * 
	 * @param fullName
	 * @param email
	 * @param password
	 * @return
	 */
	private String getWelcomeEmailMessage(String fullName, String email,
			String password) {

		StringBuffer messageBuffer = new StringBuffer();

		messageBuffer.append("Dear " + fullName + "\n\n");
		messageBuffer
				.append("Your verification process has been completed; please find the login information below. Your account details are\n\n"
						+ email + "\n\n Password : " + password);
		messageBuffer
				.append("\n\n For further process, Please Login Here.\nFor any help or clarification, please Contact Us.");
		messageBuffer
				.append("\n\nThank You,\nRohit Traders Team\nhttp://www.birjasoft.com");

		messageBuffer.append("'<html>'");
		messageBuffer.append("'<img src=\"outer/img/trans_vanra.png\"/>'");
		messageBuffer.append("</html>'");

		messageBuffer
				.append("\n\n Note: This is a system generated Email. Kindly do not reply to the sender of this Email.Legal Disclaimer: This Website/ E-mail are vulnerable to data corruption, interception, tampering,viruses as well as delivery errors and we do not accept liability for any consequence that may arise there from.");
		messageBuffer
				.append("\n\nContact Us: is link here which have to call the http://www.rohittradersvidisha.com/userlogin.actionURL-Link: should be in blue color with underline");

		return messageBuffer.toString();
	}

	@Override
	public void addLoginInformation() throws OMIApplicationException {
		// TODO Auto-generated method stub

	}

	/**
	 * <p>
	 * <code>viewUserInformation()</code> Method designed to prepare the email
	 * message with user name and password.
	 * </p>
	 * 
	 * @param fullName
	 * @param email
	 * @param password
	 * @return
	 */
	@Override
	public CustomerVO viewUserInformation(CustomerVO customerVO)
			throws OMIApplicationException {

		customerVO = customerDaoInf.getUserDetails(customerVO);

		return customerVO;
	}

	/**
	 * <p>
	 * <code>updateLoginPassword</code>Method is use to update first Time login
	 * Password And Send Updated Password on user registired email id.
	 * </p>
	 * 
	 * @param LoginVO
	 *            loginVO,int customerId
	 * @throws OMIApplicationException
	 */
	@Override
	public String updateLoginPassword(LoginVO loginVO, int customerId)
			throws OMIApplicationException {
		customerDaoInf = new CustomerDaoImpl();
		int target = customerDaoInf.getPassword(loginVO);
		if (target == 1) {
			String emailSubject = "Welcome to VANRA CRM - User Login Credentials";
			target = customerDaoInf.updateCustomerLoginPassword(loginVO,
					customerId);
			if (target == 1) {
				target = customerDaoInf.getUpdatedPassword(loginVO, customerId);
				if (target == 1) {

					try {
						String updatePasswordMail = sendUpdatedPassword(
								loginVO.getFullName(),
								loginVO.getPrimaryEmailId(),
								loginVO.getPassword());
						EmailHelper.sendEmail(loginVO.getPrimaryEmailId(),
								emailSubject, updatePasswordMail);
						logger.info("Successfully Update Customer Login Password!");
						return OMIConstants.TARGET_SUCCESS;
					} catch (Exception exception) {
						logger.info("Error:Password update successfully failed while sending mail!");
						return OMIConstants.TARGET_FAILURE;
					}
				} else {
					logger.info("Error:while  Updating Customer Login Password!");
					return OMIConstants.TARGET_FAILURE;
				}
			} else {

				logger.info("Error:while  Updating Customer Login Password!");
				return OMIConstants.TARGET_FAILURE;
			}
		} else {
			logger.info("Error:while  Updating Customer Login Password!");
			return OMIConstants.TARGET_FAILURE;

		}

	}

	/**
	 * <p>
	 * <code>sendUpdatedPassword()</code> Method designed to prepare the email
	 * message with user name and updated password.
	 * </p>
	 * 
	 * @param fullName
	 * @param email
	 * @param password
	 * @return
	 */
	private String sendUpdatedPassword(String fullName, String email,
			String password) {

		StringBuffer messageBuffer = new StringBuffer();

		messageBuffer.append("Welcome to VANRA CRM - User Login Credentials\n");
		messageBuffer.append("Dear " + fullName + "\n\n");
		messageBuffer
				.append("Thanks for registering with us. Your Email verification is completed. \n\nGetting started with VANRA CRM is easier than you think. "
						+ "\n You can login with your registerd email and given password: "
						+ "\n\n User Name/nEmail Id : "
						+ email
						+ "\n\n Password : " + password);
		messageBuffer
				.append("\nThank you for varify process for a VANRA CRM. Please start on right foot by visiting our VANRA CRM.Feel free to Contact Us if you have any queries. We are here to help you get started. ");
		messageBuffer
				.append("\n\nThank You,\nVanraCRM Team\nhttp://www.vanracrm.com");
		messageBuffer
				.append("\n\n Please feel free to contact with us if any issue related to user login.");
		messageBuffer
				.append("\n\n Please  don't reply.This is System generated email.");

		return messageBuffer.toString();
	}

	@Override
	public String updateLoginConfigurationSetting(LoginVO loginVO,
			int customerId) throws OMIApplicationException {
		customerDaoInf = new CustomerDaoImpl();
		int target = customerDaoInf.updateLoginConfigurationSetting(loginVO,
				customerId);

		if (target == 1) {

			try {
				String VcrmWellComeMail = sendVcrmWellcomeMail(
						loginVO.getFullName(), loginVO.getPrimaryEmailId());
				EmailHelper.sendEmail(loginVO.getPrimaryEmailId(),
						"Welcome to VanraCRM", VcrmWellComeMail);
				logger.info("Successfully Update Customer Login Password!");
				return OMIConstants.TARGET_SUCCESS;
			} catch (Exception exception) {
				logger.info("Error:Password update successfully failed while sending mail!");
				return OMIConstants.TARGET_FAILURE;
			}

		}
		logger.info("Error:Password update successfully failed while sending mail!");
		return OMIConstants.TARGET_FAILURE;
	}

	/**
	 * <p>
	 * <code>sendVcrmWellcomeMail()</code> Method designed to prepare the email
	 * message with user name and updated password.
	 * </p>
	 * 
	 * @param fullName
	 * @param email
	 * @param password
	 * @return
	 */
	private String sendVcrmWellcomeMail(String fullName, String email) {

		StringBuffer messageBuffer = new StringBuffer();

		messageBuffer.append("Welcome to VANRA CRM - User Login Credentials");
		messageBuffer.append("Hello & welcome " + fullName + "\n\n");
		messageBuffer
				.append("Thank you for signing up for a VANRA CRM. Please start on right foot by visiting our VANRA CRM.Feel free to Contact Us if you have any queries. We are here to help you get started. ");
		messageBuffer
				.append("\n\nThank You,\nVanraCRM Team\nhttp://www.vanracrm.com");

		messageBuffer
				.append("\n\n Note: This is a system generated Email. Kindly do not reply to the sender of this Email.Legal Disclaimer: This Website/ E-mail are vulnerable to data corruption, interception, tampering,viruses as well as delivery errors and we do not accept liability for any consequence that may arise there from.");
		messageBuffer
				.append("\n\nContact Us: is link here which have to call the http://vcrm.vanrasoft.com/userlogin.actionURL-Link: should be in blue color with underline");

		return messageBuffer.toString();
	}

	@Override
	public LoginVO getUserRole(int customerId) throws OMIApplicationException {

		LoginVO loginVO = null;
		loginVO = customerDaoInf.getUserRole(customerId);
		return loginVO;
	}

	/*
	 * @Override public String forgetPasswordRegisterCustomer(CompanyVO
	 * companyVO) throws OMIApplicationException { String target =
	 * OMIConstants.TARGET_FAILURE; try { customerDaoInf = new
	 * CustomerDaoImpl();
	 * 
	 * // Get auto generated 27 character Alpha Numeric unique id for add //
	 * company details. String companyRefNo =
	 * IDGenerator.generateAlphaNumericID(27);
	 * 
	 * // Setting auto generated password to available CompanyVO
	 * companyVO.setCompanyRefNo(companyRefNo);
	 * 
	 * customerDaoInf.insertForgetPasswordRegistraionDetails(companyVO);
	 * 
	 * try { target = sendEmailForgetPasswordVerification(
	 * companyVO.getFullName(), companyVO.getCompanyEmailId(), companyRefNo);
	 * 
	 * } catch (EmailSendFailedException emailSendFailedException) {
	 * logger.error(
	 * "Quick Customer Registration successful, Failed to send verification email."
	 * , emailSendFailedException); return target; } return target; }
	 * 
	 * catch (CreateFailedException createFailedException) { logger.error(
	 * "Quick Customer Registration Failed during inserting the data into database."
	 * , createFailedException); return target; }
	 * 
	 * }
	 */

	/*
	 * private String sendEmailForgetPasswordVerification(String fullName,
	 * String companyEmailId, String companyRefNo) throws
	 * EmailSendFailedException { String target =
	 * OMIConstants.TARGET_VERIFICATION_EMAIL_SEND_FAILED; try {
	 * 
	 * String url =
	 * "http://localhost:8080/PROJ037/verifyForgetEmail?validateId=" +
	 * companyRefNo;
	 * 
	 * String message = getForgetEmailVerificationMessage("Customer", url);
	 * EmailHelper.sendEmail(companyEmailId.trim(),
	 * "Verify Your Email For VANRA CRM Account Activation", message); try {
	 * customerDaoInf.updateEmailFlagForgetPassword(companyRefNo); target =
	 * OMIConstants.TARGET_SUCCESS; } catch (UpdateFailedException
	 * updateFailedException) { updateFailedException.printStackTrace(); target
	 * = OMIConstants.TARGET_EMAIL_FLAG_UPDATION_FAILED; }
	 * 
	 * } catch (EmailSendFailedException emailSendFailedException) {
	 * logger.error(
	 * "Verify customer email sending fail, while quick customer registration process."
	 * , emailSendFailedException); } return target;
	 * 
	 * }
	 */

	/*
	 * @Override public String verifyCustomerForgetReferenceNo(String
	 * custReferenceNo) { String target = OMIConstants.TARGET_FAILURE; try {
	 * customerDaoInf = new CustomerDaoImpl(); customer =
	 * customerDaoInf.getForgetPasswordDetails(custReferenceNo); if (customer !=
	 * null) { int companyID = registerComapny(customer); if (companyID != 0) {
	 * AjaxDaoInf ajaxDaoInf = new AjaxDaoImpl();
	 * 
	 * if (ajaxDaoInf.isEmailAlreadySaved(customer .getPrimaryEmailId()) != 1) {
	 * 
	 * int registerFlag = registerCustomer(customer, companyID); if
	 * (registerFlag == 1) { target = OMIConstants.TARGET_SUCCESS; } else {
	 * logger.error(
	 * "Error while customer creation based on companyID during verifyEmail process."
	 * ); } } else {
	 * logger.error("Customer already registed with same email id."); target =
	 * OMIConstants.TARGET_CUSTOMER_USER_ALREADY_REGISTERED;
	 * 
	 * } } else { logger.error(
	 * "Error while company creation based on custReferenceNo during verifyEmail process."
	 * ); target = OMIConstants.TARGET_COMPANY_FAILED; } } else { logger.error(
	 * "Error while getting customer registration detsils based on custReferenceNo during verifyEmail process."
	 * ); } } catch (RecordNotFoundException recordNotFoundException) {
	 * logger.error(
	 * "No record matched with registration Ref No, please see the log:",
	 * recordNotFoundException); } catch (Exception exception) { logger.error(
	 * "problem during verifying registration Ref No, please see the log:",
	 * exception); } return target;
	 * 
	 * }
	 */

	/**
	 * <p>
	 * <code>ForgetPasswordSecurityQuestion()</code> Method designed to fetch
	 * the question of that perticuler user.
	 * </p>
	 * 
	 * @param primaryEmailID
	 * @return customerVO
	 * @exception OMIApplicationException
	 */
	@Override
	public CustomerVO ForgetPasswordSecurityQuestion(String primaryEmailID)
			throws OMIApplicationException {
		CustomerVO customerVO = null;
		customerDaoInf = new CustomerDaoImpl();
		customerVO = customerDaoInf.showSecurityQuestion(primaryEmailID);

		return customerVO;
	}

	/**
	 * <p>
	 * <code>checkEmailIdAndPassword()</code> Method designed to check the
	 * answer of given question and send the password into his email id.
	 * </p>
	 * 
	 * @param primaryEmailID
	 *            answer
	 * @return OMIConstants
	 * @exception OMIApplicationException
	 */

	@Override
	public String checkEmailIdAndPassword(String primaryEmailID, String answer)
			throws OMIApplicationException {
		CustomerVO customerVO = null;
		customerDaoInf = new CustomerDaoImpl();

		customerVO = customerDaoInf.checkPrimaryEmailIdAndPassword(
				primaryEmailID, answer);
		if (customerVO != null) {
			/*
			 * int customerId = customerVO.getCustomerId();
			 * 
			 * int target =
			 * customerDaoInf.updateCustomerLoginPassword(customerVO,
			 * customerId); if (target == 1) { target =
			 * customerDaoInf.getUpdatedPassword(customerVO, customerId);
			 *//*
				 * if (target == 1) {
				 */String emailSubject = "Welcome to VANRA CRM - User Login Credentials";

			/*String url = "http://localhost:8080/PROJ037-01/userlogin";*/
			String url = "http://www.rohittradersvidisha.com/userlogin";

			try {
				String forgetPasswordTemplete = getForgetEmailVerificationMessage(
						customerVO.getFullName(),
						customerVO.getPrimaryEmailId(),
						customerVO.getPassword(), url);

				EmailHelper.sendEmail(customerVO.getPrimaryEmailId(),
						emailSubject, forgetPasswordTemplete);
				logger.info("Forget Password Process Varification Successfully Completed!");
				return OMIConstants.TARGET_SUCCESS;
			} catch (Exception exception) {
				logger.info("Error:Forget Password successfully failed while sending mail!");
				return OMIConstants.TARGET_FAILURE;
			}
		} else {
			logger.info("Error: while Comparing the Question and Answer of Client User");
			return OMIConstants.TARGET_FAILURE;
		}

	}

}
