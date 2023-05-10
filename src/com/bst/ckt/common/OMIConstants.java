package com.bst.ckt.common;

public class OMIConstants {

	/**
	 * 
	 */
	public static final int INT_MAX_VALUE = 999999999;

	/**
	 * <p>
	 * The token representing a "invalid user id"
	 * </p>
	 */
	public static final int INVALID_USER_ID = 2147483646;

	/**
	 * <p>
	 * When user register by self the createdBy user id should be enter as 0
	 * into database.
	 * </p>
	 */
	public static final int SELF_REG_USER_ID = 0;

	/**
	 * 
	 */
	public static final String TARGET = "target";
	/**
	 * <p>
	 * This token is struts2 standard action results, it is struts standard
	 * action will not to redefined into our project.
	 * </p>
	 */
	public static final String RESULT_SUCCESS = "SUCCESS";

	/**
	 * <p>
	 * This token is struts2 standard action results, it is struts standard
	 * action will not to redefined into our project.
	 * </p>
	 */
	public static final String RESULT_FAIL = "INPUT";

	/**
	 * <p>
	 * This token is struts2 standard action results, it is struts standard
	 * action will not to redefined into our project.
	 * </p>
	 */
	public static final String RESULT_LOGIN_FAIL = "LOGIN";

	/**
	 * <p>
	 * This is OMI constant for indicating the target failed.
	 * </p>
	 */
	public static final String TARGET_FAILURE = "FAILURE";

	/**
	 * <p>
	 * This is OMI constant for indicating the target failed with error.
	 * </p>
	 */
	public static final String RESULT_FAILURE_ERROR = "ERROR";

	/**
	 * <p>
	 * This is OMI constant for indicating the target success.
	 * </p>
	 */
	public static final String TARGET_SUCCESS = "SUCCESS";

	/**
	 * <p>
	 * This is OMI constant for indicating the target success.
	 * </p>
	 */
	public static final String TARGET_SUCCESS1 = "SUCCESS1";

	/**
	 * <p>
	 * This is OMI constant for indicating the false.
	 * </p>
	 */
	public static final String FALSE = "FALSE";

	/**
	 * <p>
	 * This is OMI constant for indicating true.
	 * </p>
	 */
	public static final String TRUE = "TRUE";

	/**
	 * <p>
	 * This token is use to set action result as "UserVerified", it will use
	 * when user entered email id and password is correct into database.
	 * </p>
	 */
	public static final String TARGET_USER_VERIFIED = "UserVerified";

	/**
	 * <p>
	 * This token is use to set action result as "UserNotVerified", it will use
	 * when user entered email id and password is not correct into database.
	 * </p>
	 */
	public static final String TARGET_USER_NOT_VERIFIED = "UserNotVerified";

	/**
	 * <p>
	 * This token is use to set action result as "UserNotExists", it will use
	 * when user is not available into the database.
	 * </p>
	 */
	public static final String TARGET_USER_NOT_EXISTS = "UserNotExists";

	/**
	 * <p>
	 * This token is use to set action result as "UserNotActive", it will use
	 * when user credentials are correct but user status is not "Active" into
	 * database.
	 * </p>
	 */
	public static final String TARGET_USER_NOT_ACTIVE = "UserNotActive";

	/**
	 * <p>
	 * This token is use to set action result as "UserCreated", it will use when
	 * user creation is successful completed.
	 * </p>
	 */
	public static final String TARGET_USER_CREATED = "UserCreated";

	/**
	 * <p>
	 * This token is use to set action result as "UserCreationFailed", it will
	 * use when user creation is failed due to some reason.
	 * </p>
	 */
	public static final String TARGET_USER_CREATE_FAILED = "UserCreationFailed";

	/**
	 * <p>
	 * This token is use to set action result as "EmailAlreadyRegistered", it
	 * will use when entered email is already registered into database for new
	 * user creation.
	 * </p>
	 */
	public static final String TARGET_USER_EMAIL_ALREADY_REGISTERED = "EmailAlreadyRegistered";

	/**
	 * <p>
	 * This token is use to set action result as "CompanyAlreadyRegistered", it
	 * will use when entered company name is already registered into database
	 * for new user registration.
	 * </p>
	 */
	public static final String TARGET_USER_COMPANY_ALREADY_REGISTERED = "CompanyAlreadyRegistered";
	/**
	 * <p>
	 * This token is use to set action result as "EmailSendFailed", it will use
	 * when email sending failed.
	 * </p>
	 */
	public static final String TARGET_USER_EMAIL_SEND_FAILED = "EmailSendFailed";

	/**
	 * <p>
	 * This token is use to set action result as "VerificationEmailSendFailed",
	 * it will use when verification email sending failed.
	 * </p>
	 */
	public static final String TARGET_VERIFICATION_EMAIL_SEND_FAILED = "VerificationEmailSendFailed";

	/**
	 * <p>
	 * This token is use to set action result as "EmailFlagUpdationFailed", it
	 * will use when email flag updation failed.
	 * </p>
	 */
	public static final String TARGET_EMAIL_FLAG_UPDATION_FAILED = "EmailFlagUpdationFailed";

	/**
	 * <p>
	 */
	public static final String TARGET_INPUT = "input";

	/**
	 * <p>
	 * This token is use to set action result as "CompanyCreationFailed", it
	 * will use when company creation failed or get company id based on
	 * compayRefNo failed.
	 * </p>
	 */
	public static final String TARGET_COMPANY_FAILED = "CompanyCreationFailed";

	/**
	 * <p>
	 * This token is use to set action result as "CustomerUserAlreadyRegisterd",
	 * it will use when customer user already created with same email id.
	 * </p>
	 */
	public static final String TARGET_CUSTOMER_USER_ALREADY_REGISTERED = "CustomerUserAlreadyRegisterd";

	/**
	 * <p>
	 * This token is use to set company name as "Individual", it will use when
	 * customer not entered the name of company at the time of creating new
	 * lead.
	 * </p>
	 */
	public static final String COMPANY_INDIVIDUAL = "Individual";

	/**
	 * <p>
	 * This token is use to set action result as "LeadTitleAlreadyInserted", it
	 * will use when lead title already inserted with same name.
	 * </p>
	 */
	public static final String TARGET_LEAD_TITLE_ALREADY_EXIST = "LeadTitleAlreadyExists";

	/**
	 * <p>
	 * This token is use to set action result as "TaskSubjectAlreadyInserted",
	 * it will use when task subject already inserted with same name.
	 * </p>
	 */
	public static final String TARGET_TASK_SUBJECT_ALREADY_EXIST = "TaskSubjectAlreadyExists";

	/**
	 * <p>
	 * This token is use to set action result as "TaskSubjectAlreadyInserted",
	 * it will use when task subject already inserted with same name.
	 * </p>
	 */
	public static final String LEAD_ID_DOES_NOT_EXISTS = "LeadIdDoesNotExists";

	/**
	 * <p>
	 * This token is use to set action result as "TicketDetailAlreadyExists", it
	 * will use when ticket details already inserted with same name.
	 * </p>
	 */
	public static final String TARGET_TICKET_DETAILS_NOT_EXIST = "TicketDetailNotExists";

	/**
	 * <p>
	 * This token is use to set action result as "TicketDetailAlreadyExists", it
	 * will use when ticket details already inserted with same name.
	 * </p>
	 */
	public static final String TARGET_BOARDING_DETAILS_NOT_EXIST = "BoardingDetailNotExists";

	/**
	 * <p>
	 * This token is use to set action result as "FirstTimeLogin", it will use
	 * when user trying to enter first time with system by auto generated
	 * password.
	 * </p>
	 */
	public static final String TARGET_USER_LOGIN_FIRST = "FirstTimeLogin";

	/**
	 * <p>
	 * This token is use to set action result as "FirstLoginPasswordChanged", it
	 * will use when user changed auto generated password with its personal
	 * credentials.
	 * </p>
	 */
	public static final String TARGET_FIRST_LOGIN_PASSWORD_CHANGED = "FirstLoginPasswordChanged";

	/**
	 * <p>
	 * This token is use to set action result as "ConfigurationSettingSave", it
	 * will use when user saved the default configuration setting.
	 * </p>
	 */
	public static final String TARGET_CONFIGURATION_SETTING_SAVE = "ConfigurationSettingSave";

	/**
	 * <p>
	 * This token is use to set action result as "UserVerified", it will use
	 * when user trying to logged into system first time.
	 * </p>
	 */
	public static final String LOGIN_FLAG_FTL = "FTL";

	/**
	 * <p>
	 * This token is use to set action result as "UserVerified", it will use
	 * when user changed its password with first login.
	 * </p>
	 */
	public static final String LOGIN_FLAG_PVC = "PVC";

	/**
	 * <p>
	 * This token is use to set action result as "UserVerified", it will use
	 * when user changed its password and accepts the default configuration for
	 * application.
	 * </p>
	 */
	public static final String LOGIN_FLAG_CSS = "CSS";

	/**
	 * <p>
	 * This token is to represent the constant valur of
	 * TARGET_TRAVEL_DETAILS_NOT_EXIST constrant.
	 * </p>
	 */
	public static final String TARGET_TRAVEL_DETAILS_NOT_EXIST = "Target travel details not exist";

	/**
	 * <p>
	 * This token is to represent the constant valur of
	 * TARGET_USER_SUSPENDED constrant.
	 * </p>
	 */

	public static final String TARGET_USER_SUSPENDED = "Target user suspended";
	/**
	 * <p>
	 * This token is to represent the constant valur of
	 * TARGET_USER_INACTIVE constrant.
	 * </p>
	 */

	public static final String TARGET_USER_INACTIVE = "Target user inactive";
	/**
	 * <p>
	 * This token is to represent the constant valur of
	 * TARGET_USER_DELETED constrant.
	 * </p>
	 */

	public static final String TARGET_USER_DELETED = "Target user deleted";
	/**
	 * <p>
	 * This token is to represent the constant valur of
	 * TARGET_USER_REGISTERED constrant.
	 * </p>
	 */

	public static final String TARGET_USER_REGISTERED = "Target user registered";
	/**
	 * <p>
	 * This token is to represent the constant valur of
	 * TARGET_USER_SUBMITTED constrant.
	 * </p>
	 */

	public static final String TARGET_USER_SUBMITTED = "Target user submited";

	/**
	 * <p>
	 * This token is to represent the constant valur of
	 * TARGET_USER_SUBMITTED constrant.
	 * </p>
	 */
	public static final String TARGET_OTHER_DETAILS_NOT_EXIST = "Target other details not exist";

	/**
	 * <p>
	 * This token is to represent the constant value of
	 * TARGET_USER_PRIMARY_EMAIL_ID_NOT_CORRECT constraint.
	 * </p>
	 */
	public static final String TARGET_USER_PRIMARY_EMAIL_ID_NOT_CORRECT = "Target user primary Email-id is not correct";
	
	/**
	 * <p>
	 * This token is to represent the constant value of
	 * TARGET_USER_PASSWORD_NOT_CORRECT constraint.
	 * </p>
	 */
	public static final String TARGET_USER_PASSWORD_NOT_CORRECT = "Target user password is not correct";
	
	/**
	 * <p>
	 * This token is to represent the constant value of
	 * TARGET_USER_PASSWORD_AND_EMAIL_NOT_CORRECT constraint.
	 * </p>
	 */
	public static final String TARGET_USER_PASSWORD_AND_EMAIL_NOT_CORRECT = "Target user primary Email-id & password is not correct";

	public static final String RESULT_PREVIOUS_TYPE = "previous";

	public static final String RESULT_NEXT_TYPE = "next";
	
	 /**
     * <p>
     * A static message in case message Estimate is inserted into TAB_ESTIMATE_DETAILS TABLE .
     * </p>
     */
	public static final String TARGET_ESTIMATE_SUCCESS ="ESTIMATEINSERTED";
	
	 /**
     * <p>
     * A static message in case message Estimate is not inserted into TAB_ESTIMATE_DETAILS TABLE .
     * </p>
     */
    public static final String TARGET_ESTIMATE_FAIL ="ESTIMATENOTINSERTED";
    
    public static final int CHOUKSAY_TRADERS =1;
    
    public static final int CHOUKSAY_BROTHERS =2;
	
}
