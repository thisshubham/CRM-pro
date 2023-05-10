package com.bst.ckt.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.bst.ckt.common.EmailHelper;
import com.bst.ckt.common.OMIConstants;
import com.bst.ckt.dao.AjaxDaoImpl;
import com.bst.ckt.dao.AjaxDaoInf;
import com.bst.ckt.dao.UserManagementDaoImpl;
import com.bst.ckt.dao.UserManagementDaoInf;
import com.bst.ckt.exception.EmailSendFailedException;
import com.bst.ckt.exception.OMIApplicationException;
import com.bst.ckt.exception.RecordNotFoundException;
import com.bst.ckt.exception.UpdateFailedException;
import com.bst.ckt.framework.user.UserStatus;
import com.bst.ckt.framework.util.IDGenerator;
import com.bst.ckt.vo.CustomerVO;

public class UserManagementServiceImpl implements UserManagementServiceInf {

	/**
	 * Creating Logger object, logger object mapped with LeadAction class for
	 * writing Loggers.
	 */
	private static final Logger logger = Logger
			.getLogger(UserManagementServiceImpl.class);

	UserManagementDaoInf userManagementDaoInf = null;
	CustomerVO customerVO = null;

	/**
	 * <p>
	 * <code>registerUserDetail()</code>this method is design to add new user
	 * </p>
	 * 
	 * @param customerVO
	 *            CustomerVO
	 * @return String
	 * @throws OMIApplicationException
	 */
	public String registerUserDetail(CustomerVO customerVO)
			throws OMIApplicationException {
		String target = OMIConstants.TARGET_FAILURE;
		try {
			userManagementDaoInf = new UserManagementDaoImpl();
			String createUserGuid = IDGenerator.generateAlphaNumericID(27);
			String password = IDGenerator.generateAlphaNumericID(8);
			customerVO.setPassword(password);
			customerVO.setCreateUserGuid(createUserGuid);
			userManagementDaoInf.insertUserDetail(customerVO);
			
			target=OMIConstants.TARGET_SUCCESS;
			/*try {
				target = sendEmailVerification(customerVO.getFullName(),
						customerVO.getPrimaryEmailId(), createUserGuid);

			} catch (EmailSendFailedException emailSendFailedException) {
				logger.error(
						"Create New Staff user Email successful, Failed to send verification email.",
						emailSendFailedException);
				return target;
			}*/
			return target;
		} catch (UpdateFailedException updateFailedException) {
			logger.error(
					"Create New Staff user Email Failed during inserting the data into database.",
					updateFailedException);
			return target;
		} catch (Exception exception) {
			logger.error("Create New Staff user Email Failed", exception);
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
	private String sendEmailVerification(String fullName, String emailId,
			String createUserGuid) throws EmailSendFailedException {
		userManagementDaoInf = new UserManagementDaoImpl();
		String target = OMIConstants.TARGET_VERIFICATION_EMAIL_SEND_FAILED;
		try {

			/*String url = "http://localhost:8080/PROJ201804/verifyCustomerStaffUser?validateId="
					+ createUserGuid;*/
			String url = "http://www.rohittradersvidisha.com/verifyCustomerStaffUser?validateId="
					+ createUserGuid;
			//http://www.rohittradersvidisha.com/settingsUser.action
			String message = getCustomerStaffUserVerificationMessage(fullName,
					url);
			EmailHelper.sendEmail(emailId.trim(),
					"Verify Your Email For Rohit Traders Account Activation",
					message);
			try {
				userManagementDaoInf.updateEmailFlagGuid(createUserGuid);

				target = OMIConstants.TARGET_SUCCESS;
			} catch (Exception exception) {
				exception.printStackTrace();
			}
		} catch (EmailSendFailedException emailSendFailedException) {
			logger.error(
					"Verify New Customer Staff user email sending fail, while quick customer registration process.",
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
	private String getCustomerStaffUserVerificationMessage(String fullName,
			String url) {

		StringBuffer messageBuffer = new StringBuffer();

		messageBuffer.append("Dear " + fullName + "\n\n");
		messageBuffer
				.append("Thanks for registering with us. Your Email verification is pending. \n\nGetting started with Rohit Traders Inventory is easier than you think. "
						+ "\n You can verify your email first with click on below verification link or paste it on browser url and enter.: "
						+ "\n\n Verification Link : " + url);
		messageBuffer
				.append("\n\n Please feel free to contact with us if any issue related to email verification.");
		messageBuffer
				.append("\n\n Please  don't reply.This is System generated mail.");

		return messageBuffer.toString();
	}

	/**
	 * 
	 */
	public String verifyCustomerStaffUser(String referenceId)
			throws OMIApplicationException {
		String target = OMIConstants.TARGET_FAILURE;
		try {
			userManagementDaoInf = new UserManagementDaoImpl();
			customerVO = userManagementDaoInf
					.getCustomerStaffUserDetails(referenceId);
			int customerID = customerVO.getCreatedBy();
			if (customerVO != null) {
				int companyId = userManagementDaoInf.getCompanyId(customerID);
				/*
				 * int customerID = registerCustomerStaffUser(customerVO,
				 * companyId, target);
				 */
				if (customerID != 0) {
					String primaryEmailId = customerVO.getPrimaryEmailId();
					AjaxDaoInf ajaxDaoInf = new AjaxDaoImpl();

					if (ajaxDaoInf.isEmailAlreadySaved(primaryEmailId) != 1) {

						int registerFlag = registerCustomerStaffUser(
								customerVO, companyId, primaryEmailId);
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
	 * <p>
	 * <code>registerCustomerStaffUser</code> Method is use to create a staff
	 * user by super administrator
	 * </p>
	 * 
	 * @param customer
	 * @return
	 * @throws OMIApplicationException
	 */
	protected int registerCustomerStaffUser(CustomerVO customerVO,
			int companyId, String primaryEmailId)
			throws OMIApplicationException {
		int emailFlag = 0;

		userManagementDaoInf = new UserManagementDaoImpl();
		try {
			String password = IDGenerator.generateAlphaNumericID(8);
			String emailSubject = "Welcome to Rohit Traders Inventory - User Login Credentials";

			userManagementDaoInf.createCustomerStaff(customerVO,
					primaryEmailId, password);
			String wellcomeEmail = getCustomerStaffEmail(
					customerVO.getFullName(), customerVO.getPrimaryEmailId(),
					password);
			EmailHelper.sendEmail(customerVO.getPrimaryEmailId(), emailSubject,
					wellcomeEmail);
			userManagementDaoInf.updateCustomerStaffUserEmailFlagByEmail(
					customerVO.getPrimaryEmailId(), OMIConstants.TRUE);
			emailFlag = 1;

		} catch (OMIApplicationException omiApplicationException) {
			logger.error(
					"User Already registered please try again with another email:",
					omiApplicationException);
		}

		catch (Exception exception) {
			logger.error("User creation failed, Please refer the below logs:",
					exception);
		}
		return emailFlag;
	}

	/**
	 * 
	 * @param customer
	 * @param companyId
	 * @return
	 * @throws OMIApplicationException
	 */
	protected int registerCustomerStaffEmail(CustomerVO customerVO,
			int customerId) throws OMIApplicationException {
		int emailFlag = 0;
		String password = IDGenerator.generateAlphaNumericID(8);
		String emailSubject = "Welcome to VANRA CRM - User Login Credentials";
		try {
			userManagementDaoInf = new UserManagementDaoImpl();
			userManagementDaoInf.createCustomerStaffUser(customerVO,
					customerId, password);
			try {
				String welcomeMessage = getWelcomeEmailMessage(
						customerVO.getFullName(),
						customerVO.getPrimaryEmailId(), password);
				EmailHelper.sendEmail(customerVO.getPrimaryEmailId(),
						emailSubject, welcomeMessage);
				userManagementDaoInf.updateCustomerStaffUserEmailFlagByEmail(
						customerVO.getPrimaryEmailId(), OMIConstants.TRUE);
				emailFlag = 1;
				try {
					userManagementDaoInf.updateUserStatus(
							customerVO.getCustomerId(), UserStatus.ACTIVE_ID);
				} catch (UpdateFailedException updateFailedException) {
					logger.error(
							"Email Sending failed - Problem during Update customer status.",
							updateFailedException);
				}
			} catch (EmailSendFailedException emailSendFailedException) {
				logger.error(
						"Email Sending failed - Problem during sending welcome email to customer as part of verifyEmail process.",
						emailSendFailedException);
			} catch (Exception exception) {
				logger.error(
						"Problem during fetch the customer id based on company ref no.",
						exception);
			}
		} catch (Exception exception) {
			logger.error(
					"Customer creation failed, Please refer the below logs:",
					exception);

		}
		return emailFlag;
	}

	/**
	 * <p>
	 * <code>getCustomerStaffEmail()</code> Method designed to prepare the email
	 * message with user name and password.
	 * </p>
	 * 
	 * @param fullName
	 * @param email
	 * @param password
	 * @return
	 */
	private String getCustomerStaffEmail(String fullName, String email,
			String password) {

		StringBuffer messageBuffer = new StringBuffer();

		messageBuffer.append("Dear " + fullName + "\n\n");
		messageBuffer
				.append("Your Email verification is completed. \n\nGetting started with Rohiit Traders Inventory is easier than you think. "
						+ "\n You can login with your registerd email and given password: "
						+ "\n\n User Name/Email Id : "
						+ email
						+ "\n\n Password : " + password);
		messageBuffer
				.append("\n\n Please feel free to contact with us if any issue related to user login.");
		messageBuffer
				.append("\n\n Please  don't reply.This is System generated email.");

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
				.append("Thanks for registering with us. Your Email verification is completed. \n\nGetting started with VANRA CRM is easier than you think. "
						+ "\n You can login with your registerd email and given password: "
						+ "\n\n User Name/Email Id : "
						+ email
						+ "\n\n Password : " + password);
		messageBuffer
				.append("\n\n Please feel free to contact with us if any issue related to user login.");
		messageBuffer
				.append("\n\n Please  don't reply.This is System generated email.");

		return messageBuffer.toString();
	}

	/**
	 * <p>
	 * <code>updateUserLoginPassword()</code> Method designed to update customer
	 * Login password.
	 * </p>
	 * 
	 * @param customerVO
	 * @return SUCCESS
	 */
	@Override
	public String updateUserLoginPassword(CustomerVO customerVO, int customerId)
			throws OMIApplicationException {
		userManagementDaoInf = new UserManagementDaoImpl();
		int target = userManagementDaoInf.updateCustomerLoginPassword(
				customerVO, customerId);
		if (target == 1) {
			String emailSubject = "Welcome to Rohit Traders CRM - Updated User Login Password";
			try {
				String sendNewPassword = sendNewPassword(
						customerVO.getFullName(),
						customerVO.getPrimaryEmailId(),
						customerVO.getPassword());
				EmailHelper.sendEmail(customerVO.getPrimaryEmailId(),
						emailSubject, sendNewPassword);
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
	}

	/**
	 * <p>
	 * <code>sendNewPassword()</code> Method designed to prepare the email
	 * message with user name and password.
	 * </p>
	 * 
	 * @param fullName
	 * @param email
	 * @param password
	 * @return
	 */
	private String sendNewPassword(String fullName, String email,
			String password) {

		StringBuffer messageBuffer = new StringBuffer();

		messageBuffer.append("Dear " + fullName + "\n\n");
		messageBuffer
				.append("Thanks for registering with us. Your Email verification is completed. \n\nGetting started with VANRA CRM is easier than you think. "
						+ "\n You can login with your registerd email and given password: "
						+ "\n\n User Name/Email Id : "
						+ email
						+ "\n\n Password : " + password);
		messageBuffer
				.append("\n\n Please feel free to contact with us if any issue related to user login.");
		messageBuffer
				.append("\n\n Please  don't reply.This is System generated email.");

		return messageBuffer.toString();
	}

	/**
	 * <p>
	 * <code>editUserInfo()</code> Method designed to update user info.
	 * </p>
	 * 
	 * @param customerId
	 * @return SUCCESS
	 */
	@Override
	public CustomerVO editUserInfo(CustomerVO customerVO, int customerId)
			throws OMIApplicationException {
		System.out
				.println("service ------------------------------------------------------");
		userManagementDaoInf = new UserManagementDaoImpl();
		customerVO = userManagementDaoInf
				.updateUserInfo(customerVO, customerId);
		return customerVO;
	}

	/**
	 * <p>
	 * <code>updateUserInfo()</code> Method designed to update user info.
	 * </p>
	 * 
	 * @param customerId
	 * @param filePath
	 * @param userImageFileName
	 */
	@Override
	public String updateUserInfo(CustomerVO customerVO, int customerId,
			String filePath, String userImageFileName)
			throws OMIApplicationException {
		int target = userManagementDaoInf.editUserDetails(customerVO,
				customerId, filePath, userImageFileName);
		if (target == 1) {
			logger.info("Successfully Update Account Information!");
			return OMIConstants.TARGET_SUCCESS;
		} else {

			logger.info("Error:while  Updating Account Information!");
			return OMIConstants.TARGET_FAILURE;
		}

	}

	/**
	 * <p>
	 * <code>updateUserEmail()</code> Method designed to update customer Email
	 * Id.
	 * </p>
	 * 
	 * @param customerVO
	 * @param customerId
	 * @return SUCCESS
	 */
	@Override
	public String updateUserEmail(CustomerVO customerVO, int customerId)
			throws OMIApplicationException {
		String target = OMIConstants.TARGET_FAILURE;
		try {
			userManagementDaoInf = new UserManagementDaoImpl();
			String changeEmailRefNo = IDGenerator.generateAlphaNumericID(27);
			customerVO.setChangeEmailRefNo(changeEmailRefNo);
			userManagementDaoInf.updateUserEmailId(customerVO, customerId);
			try {
				target = sendChangeEmailVerification(customerVO.getFullName(),
						customerVO.getPrimaryEmailId(), changeEmailRefNo);
			} catch (EmailSendFailedException emailSendFailedException) {
				logger.error(
						"Change user Email successful, Failed to send verification email.",
						emailSendFailedException);
				return target;
			}
			return target;
		} catch (UpdateFailedException updateFailedException) {
			logger.error(
					"Change user Email Failed during inserting the data into database.",
					updateFailedException);
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
	private String sendChangeEmailVerification(String fullName, String emailId,
			String changeEmailRefNo) throws EmailSendFailedException {
		userManagementDaoInf = new UserManagementDaoImpl();
		String target = OMIConstants.TARGET_VERIFICATION_EMAIL_SEND_FAILED;
		try {

			/*String url = "http://localhost:8080/PROJ037-01/verifyChangeUserEmail?validateId="
					+ changeEmailRefNo;*/
		
				
				String url = "http://www.rohittradersvidisha.com/verifyChangeUserEmail?validateId="
						+ changeEmailRefNo;
			String message = getChangeEmaiVerificationMessage(fullName, url);
			EmailHelper.sendEmail(emailId.trim(),
					"Verify Your Email For VANRA CRM Account Activation",
					message);
			try {
				userManagementDaoInf.updateEmailFlagGuid(changeEmailRefNo);

				target = OMIConstants.TARGET_SUCCESS;
			} catch (Exception exception) {
				exception.printStackTrace();
			}
		} catch (EmailSendFailedException emailSendFailedException) {
			logger.error(
					"Verify New Customer Staff user email sending fail, while quick customer registration process.",
					emailSendFailedException);
		}
		return target;
	}

	/**
	 * <p>
	 * <code>getChangeEmaiVerificationMessage</code> This is a mail template
	 * method for change email verification with full name and url.
	 * </p>
	 * 
	 * @param fullName
	 * @param url
	 * @return
	 */
	private String getChangeEmaiVerificationMessage(String fullName, String url) {

		StringBuffer messageBuffer = new StringBuffer();

		messageBuffer.append("Dear " + fullName + "\n\n");
		messageBuffer
				.append("Thanks for registering with us. Your Email verification is pending. \n\nGetting started with VANRA CRM is easier than you think. "
						+ "\n You can verify your email first with click on below verification link or paste it on browser url and enter.: "
						+ "\n\n Verification Link : " + url);
		messageBuffer
				.append("\n\n Please feel free to contact with us if any issue related to email verification.");
		messageBuffer
				.append("\n\n Please  don't reply.This is System generated mail.");

		return messageBuffer.toString();
	}

	/**
	 * <p>
	 * <code>verifyChangeUserEmail</code>this method is use to verify the user
	 * who is created by super administrator with the help of referenc0eId.
	 * </p>
	 * 
	 * @param referenceId
	 */
	@Override
	public String verifyChangeUserEmail(String referenceId)
			throws OMIApplicationException {
		try {
			userManagementDaoInf = new UserManagementDaoImpl();
			customerVO = userManagementDaoInf
					.getChangeUserEmailDetails(referenceId);
			if (customerVO != null) {
				int target = userManagementDaoInf.updateUserEmail(customerVO);
				if (target == 1) {
					return OMIConstants.TARGET_SUCCESS;
				} else {
					logger.error("ERROR Update user emailId Failure");
					return OMIConstants.TARGET_FAILURE;
				}
			}

		} catch (RecordNotFoundException recordNotFoundException) {
			logger.error(
					"No record matched with registration Ref No, please see the log:",
					recordNotFoundException);
		}
		return null;
	}

	/**
	 * <p>
	 * <code>getuserSocialDetailsList</code> Method will get the list of user
	 * social information according to customerId.
	 * </p>
	 * 
	 * @param int customerId
	 */
	@Override
	public List<CustomerVO> getuserSocialDetailsList(int customerId)
			throws Exception {
		userManagementDaoInf = new UserManagementDaoImpl();
		return userManagementDaoInf.getuserSocialDetailsList(customerId);
	}

	/**
	 * <p>
	 * <code>addUserSocialInformation</code>This method will add the user social
	 * information.
	 * </p>
	 * 
	 * @param customerVO
	 */
	@Override
	public String addUserSocialInformation(CustomerVO customerVO)
			throws Exception {

		userManagementDaoInf = new UserManagementDaoImpl();
		int target = userManagementDaoInf
				.insertOrUpdateUserSocialInformation(customerVO);

		if (target == 1) {
			logger.info("Successfully Inserted User Social Details!");
			return OMIConstants.TARGET_SUCCESS;
		} else if (target == 2) {
			logger.info("Successfully Updated User Social Details!");
			return OMIConstants.TARGET_SUCCESS1;
		}
		logger.info("Error:while  Inserting  and Updating User Social Details into database!");
		return OMIConstants.TARGET_FAILURE;

	}

}
