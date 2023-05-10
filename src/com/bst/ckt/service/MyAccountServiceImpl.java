/**
 * 
 */
package com.bst.ckt.service;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.bst.ckt.common.EmailHelper;
import com.bst.ckt.common.OMIConstants;
import com.bst.ckt.dao.MyAccountDaoImpl;
import com.bst.ckt.dao.MyAccountDaoInf;
import com.bst.ckt.exception.EmailSendFailedException;
import com.bst.ckt.exception.OMIApplicationException;
import com.bst.ckt.exception.RecordNotFoundException;
import com.bst.ckt.exception.UpdateFailedException;
import com.bst.ckt.framework.user.UserStatus;
import com.bst.ckt.framework.util.IDGenerator;
import com.bst.ckt.helper.NameHelper;
import com.bst.ckt.vo.CustomerVO;

/**
 * @author Deepak Vishwakarma
 * 
 */
public class MyAccountServiceImpl implements MyAccountServiceInf {

	/**
	 * Creating Logger object, logger object mapped with MyAccountServiceImpl
	 * class for writing Loggers.
	 */
	public static final Logger logger = Logger
			.getLogger(MyAccountServiceImpl.class);
	CustomerVO customerVO = null;

	MyAccountDaoInf myAccountDaoInf = new MyAccountDaoImpl();
	NameHelper namehelper = new NameHelper();

	@Override
	public CustomerVO editCustomerInfo(CustomerVO customerVO)
			throws SQLException {
		try {
			customerVO = myAccountDaoInf.editCustomerAccount(customerVO);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return customerVO;
	}

	/**
	 * <p>
	 * <code>upDateCustomerInfo()</code> Method designed to update customer
	 * information into database for manage the customer account.
	 * </p>
	 * 
	 * @param customerVO
	 * @return SUCCESS
	 */
	@Override
	public String upDateCustomerInfo(CustomerVO customerVO, String filePath,
			String userImageFileName) throws Exception {

		int target = myAccountDaoInf.upDateCustomerAccountInfo(customerVO,
				filePath, userImageFileName);
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
	 * <code>updateCustomerLoginPassword()</code> Method designed to update
	 * customer Login password.
	 * </p>
	 * 
	 * @param customerVO
	 * @return SUCCESS
	 */
	@Override
	public String updateCustomerLoginPassword(CustomerVO customerVO)
			throws Exception {
		int target = myAccountDaoInf.getOldPassword(customerVO);
		customerVO = myAccountDaoInf.fetchFullname(customerVO);
		if (target == 1) {
			target = myAccountDaoInf.updateCustomerLoginPassword(customerVO);
			if (target == 1) {
				String emailSubject = "Welcome to VANRA CRM - User Login Credentials";
				try {
					System.out.println("Update password---------------");
					String sendNewPassword = getWelcomeEmailMessage(
							customerVO.getFullName(),
							customerVO.getPrimaryEmailId(),
							customerVO.getPassword());
					System.out.println("hi this is sending mail template");
					System.out.println("**********************8  "
							+ sendNewPassword);
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
		} else {
			logger.info("Error:while  Updating Customer Login Password!");
			return OMIConstants.TARGET_FAILURE;

		}

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
	 * <code>updateCustomerSecqurityQuestion()</code> Method designed to update
	 * customer Security question into database.
	 * </p>
	 * 
	 * @param customerVO
	 * @return SUCCESS
	 */

	@Override
	public String updateCustomerSecqurityQuestion(CustomerVO customerVO)
			throws OMIApplicationException {

		myAccountDaoInf = new MyAccountDaoImpl();
		/* int target = myAccountDaoInf.getOldPassword(customerVO); */
		/* if (target == 1) { */
		System.out.println("Old Password :::::"
				+ myAccountDaoInf.getOldPassword(customerVO));
		int target = myAccountDaoInf
				.updateCustomerSecqurityQuestion(customerVO);
		if (target == 1) {

			String emailSubject = "Welcome to VANRA CRM - User Update Credentials";
			try {
				customerVO = myAccountDaoInf.fetchFullname(customerVO);
				int id = Integer.parseInt(customerVO.getSecurityQuestion());
				String sendNewPassword = sendEmailWithSecurityAnswerAndQuestion(
						customerVO.getFullName(),
						customerVO.getPrimaryEmailId(),
						namehelper.getForgetPasswordSecurityQuestion(id),
						customerVO.getAnswer());
				EmailHelper.sendEmail(customerVO.getPrimaryEmailId(),
						emailSubject, sendNewPassword);
				logger.info("Successfully Update Customer Security question!");
				return OMIConstants.TARGET_SUCCESS;
			} catch (Exception exception) {
				logger.info("Error:Security question! update successfully failed while sending mail!");
				return OMIConstants.TARGET_FAILURE;
			}
		} else {
			logger.info("Error:while  Updating Customer Security question!");
			return OMIConstants.TARGET_FAILURE;
		}

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
	private String sendEmailWithSecurityAnswerAndQuestion(String fullName,
			String email, String securityQuestion, String answer) {

		StringBuffer messageBuffer = new StringBuffer();

		messageBuffer.append("Dear " + fullName + "\n\n");
		messageBuffer
				.append("Thanks for registering with us. Your Security Question Update SuccessFully. \n\nGetting started with VANRA CRM is easier than you think. "
						+ "\n You can login with your registerd email and given password: "
						+ "\n\nEmail Id : " + email);
		messageBuffer.append("\n\n Your Selected Security Question Is: "
				+ securityQuestion + "\n" + "And Your Answer Is :" + answer);
		messageBuffer
				.append("\n\n Please feel free to contact with us if any issue related to user login.");
		messageBuffer
				.append("\n\n Please  don't reply.This is System generated email.");

		return messageBuffer.toString();
	}

	/**
	 * <p>
	 * <code>addUserSocialInformation()</code>
	 * <p>
	 * 
	 * @param customerVO
	 * @throws Exception
	 */
	@Override
	public String addUserSocialInformation(CustomerVO customerVO)
			throws OMIApplicationException {

		myAccountDaoInf = new MyAccountDaoImpl();
		int target = myAccountDaoInf.insertUserSocialInformation(customerVO);

		if (target == 1) {
			logger.info("Successfully Inserted user Social Details!");
			return OMIConstants.TARGET_SUCCESS;
		} else if (target == 2) {
			logger.info("Successfully Updated User Social Details!");
			return OMIConstants.TARGET_SUCCESS1;
		}
		logger.info("Error:while  Inserting  and Updating user Social Details into database!");
		return OMIConstants.TARGET_FAILURE;

	}

	@Override
	public String deleteCustomerSocialDetails(int id)
			throws OMIApplicationException {
		try {
			myAccountDaoInf = new MyAccountDaoImpl();
			int target = myAccountDaoInf.deleteCustomerSocialDetails(id);

			if (target == 1) {
				return OMIConstants.TARGET_SUCCESS;
			} else {
				return OMIConstants.TARGET_FAILURE;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return OMIConstants.TARGET_FAILURE;

		}

	}

	/**
	 * <p>
	 * <code>updateUserEmail()</code>method will design to update the login user
	 * primary email.that method first verify the new email and then that will
	 * change the Email Id.
	 * <p>
	 * 
	 * @param customerVO
	 * @throws OMIApplicationException
	 */
	@Override
	public String updateUserEmail(CustomerVO customerVO)
			throws OMIApplicationException {
		String target = OMIConstants.TARGET_FAILURE;
		try {
			myAccountDaoInf = new MyAccountDaoImpl();
			String changeEmailRefNo = IDGenerator.generateAlphaNumericID(27);
			customerVO.setChangeEmailRefNo(changeEmailRefNo);
			customerVO = myAccountDaoInf.fetchFullname(customerVO);
			myAccountDaoInf.updateUserEmailId(customerVO);
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
		myAccountDaoInf = new MyAccountDaoImpl();
		String target = OMIConstants.TARGET_VERIFICATION_EMAIL_SEND_FAILED;
		try {

			String url = "http://localhost:8080/PROJ037-01/verifyChangeUserEmailId?validateId="
					+ changeEmailRefNo;

			String message = getChangeEmaiVerificationMessage(fullName, url);
			EmailHelper.sendEmail(emailId.trim(),
					"Verify Your Email For VANRA CRM Account Activation",
					message);
			try {
				myAccountDaoInf.updateEmailFlagGuid(changeEmailRefNo);

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
	 * 
	 */
	public String verifyChangeUserEmail(String referenceId)
			throws OMIApplicationException {
		try {
			myAccountDaoInf = new MyAccountDaoImpl();
			customerVO = myAccountDaoInf.getChangeUserEmailDetails(referenceId);
			if (customerVO != null) {
				int target = myAccountDaoInf.updateUserEmail(customerVO);
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
	 * <code>closeUserAcount()</code>This method have close user account process
	 * with some come conditions and in this method we are send a verification
	 * mail to user for verify he want to close his account permanently in this
	 * mail we are send to verification link first link if he really want to
	 * remove account so he will click on this link and second link for continue
	 * account with us.
	 * </p>
	 * 
	 * @param customerVO
	 * 
	 */
	@Override
	public String closeUserAcount(CustomerVO customerVO)
			throws OMIApplicationException {
		String target = OMIConstants.TARGET_FAILURE;
		try {
			myAccountDaoInf = new MyAccountDaoImpl();
			String closeAccountRefNo = IDGenerator.generateAlphaNumericID(27);
			customerVO.setCloseAccountRefNo(closeAccountRefNo);
			int pwd = myAccountDaoInf.getPassword(customerVO);
			if (pwd == 1) {
				pwd = myAccountDaoInf.updateCloseAccountDetails(customerVO);
				if (pwd == 1) {
					pwd = myAccountDaoInf.updateUserStatus(
							customerVO.getCustomerId(),
							UserStatus.SUSPENDED_ID,
							customerVO.getPrimaryEmailId());

					try {
						target = sendCloseAccountVerification(
								customerVO.getFullName(),
								customerVO.getPrimaryEmailId(),
								closeAccountRefNo);
					} catch (EmailSendFailedException emailSendFailedException) {
						logger.error(
								"Change user Email successful, Failed to send verification email.",
								emailSendFailedException);
						return target;
					}

				}

				else {
					logger.info("Error:while  Updating Close Account Details !");
					return OMIConstants.TARGET_FAILURE;
				}
			} else {
				logger.info("Error:while  Getting Password !");
				return OMIConstants.TARGET_FAILURE;
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
	 * <p>
	 * <code> sendCloseAccountVerification</code>Method Will send two url for
	 * close account process.
	 * </p>
	 * 
	 * @param fullName
	 * @param companyEmailId
	 * @param companyRefNo
	 * @return
	 * @throws EmailSendFailedException
	 */
	private String sendCloseAccountVerification(String fullName,
			String emailId, String closeAccountRefNo)
			throws EmailSendFailedException {
		myAccountDaoInf = new MyAccountDaoImpl();
		String target = OMIConstants.TARGET_VERIFICATION_EMAIL_SEND_FAILED;
		String closeAccountURL = "http://localhost:8080/PROJ037/verifyCloseAccount?validateId="
				+ closeAccountRefNo;
		String continueAcccountURL = "http://localhost:8080/PROJ037/verifyContinueAccount?validateId="
				+ closeAccountRefNo;
		String message = sendCloseAccountMail(fullName, closeAccountURL,
				continueAcccountURL);
		try {
			EmailHelper
					.sendEmail(
							emailId.trim(),
							"Verify Your Email For VANRA CRM Account Activation And Close Account Process.",
							message);

			target = OMIConstants.TARGET_SUCCESS;
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return target;
	}

	/**
	 * <p>
	 * <code> sendCloseAccountVerification</code>Method Will send two url for
	 * close account process.
	 * </p>
	 * 
	 * @param fullName
	 * @param url
	 * @return
	 */
	private String sendCloseAccountMail(String fullName,
			String closeAccountRefNo, String continueAccountRefNo) {

		StringBuffer messageBuffer = new StringBuffer();

		messageBuffer.append("Dear " + fullName + "\n\n");
		messageBuffer
				.append("If you Want close your account permanently. Click on verification link"
						+ "\n\n Verification Link : " + closeAccountRefNo);
		messageBuffer
				.append("\n\n You Want continue account  with us. Clisk on verification link"
						+ "\n\n Verification Link : " + continueAccountRefNo);
		messageBuffer
				.append("\n\n Please feel free to contact with us if any issue related to email verification.");
		messageBuffer
				.append("\n\n Please  don't reply.This is System generated mail.");

		return messageBuffer.toString();
	}

	/**
	 * <p>
	 * <code>verifyCloseAccount()</code>Method will use to Delete The User After
	 * verifying the use.
	 * </p>
	 * 
	 * @param String
	 *            referenceId
	 */
	@Override
	public String verifyCloseAccount(String referenceId)
			throws OMIApplicationException {
		System.out.println("Service Close Account Verification");
		myAccountDaoInf = new MyAccountDaoImpl();
		myAccountDaoInf.updateUserStatusClose(UserStatus.DELETED_ID,
				referenceId);
		return null;
	}

	/**
	 * <p>
	 * <code>verifyContinueAccount()</code>Method will use to Active The User
	 * After verifying the use.
	 * </p>
	 * 
	 * @param String
	 *            referenceId
	 */
	@Override
	public String verifyContinueAccount(String referenceId)
			throws OMIApplicationException {
		myAccountDaoInf = new MyAccountDaoImpl();
		myAccountDaoInf.updateUserStatusActive(UserStatus.ACTIVE_ID,
				referenceId);
		return null;
	}

}
