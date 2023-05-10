package com.bst.ckt.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.bst.ckt.common.LoginUtil;
import com.bst.ckt.common.OMIConstants;
import com.bst.ckt.dao.SupportDaoImpl;
import com.bst.ckt.dao.SupportDaoInf;
import com.bst.ckt.exception.OMIApplicationException;
import com.bst.ckt.framework.user.CustomerSessionUser;
import com.bst.ckt.helper.ListHelper;
import com.bst.ckt.helper.ServiceContactAdvanceSearch;
import com.bst.ckt.helper.ServiceStatus;
import com.bst.ckt.helper.TicketPriority;
import com.bst.ckt.helper.VOMapperHelper;
import com.bst.ckt.service.SupportServiceImpl;
import com.bst.ckt.service.SupportServiceInf;
import com.bst.ckt.vo.ServiceContactVo;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class SupportServiceContractAction extends ActionSupport implements
		ModelDriven<ServiceContactVo>, SessionAware {

	/**
     * 
     */
	private static final long serialVersionUID = 1L;

	/**
	 * Creating Logger object, logger object mapped with
	 * SupportServiceContactAction class for writing Loggers.
	 */
	private static final Logger logger = Logger
			.getLogger(SupportServiceContractAction.class);

	ServiceContactVo serviceContactVo = new ServiceContactVo();
	SupportServiceInf supportServiceInf = null;
	SupportDaoInf supportDaoInf = null;
	private Map<Integer, String> serviceContactNameList = null;
	private Map<Integer, String> serviceStatusList = null;
	private Map<Integer, String> servicePriorityList = null;
	private Map<Integer, String> releteddToList = null;
	private Map<Integer, String> serviceAssignedToList = null;
	private Map<Integer, String> serviceTypeList = null;
	private Map<Integer, String> serviceTrackingUnitList;
	private Map<Integer, String> advanceSearchList;
	HttpServletResponse response = null;
	ListHelper listHelper = new ListHelper();
	Map<String, Object> session = null;
	List<ServiceContactVo> serviceContactGridList;
	HttpServletRequest request = (HttpServletRequest) ActionContext
			.getContext().get(ServletActionContext.HTTP_REQUEST);

	public SupportServiceContractAction() throws Exception {
		serviceContactNameList = listHelper.ticketContactNameList();
		serviceStatusList = ServiceStatus.getModifiedServiceStatusList();
		servicePriorityList = TicketPriority.getModifiedTicketPriorityList();
		releteddToList = listHelper.getParentAccountList();
		serviceAssignedToList = listHelper.ticketOwnerList();
		serviceTrackingUnitList = listHelper.serviceTrackingUnitList();
		serviceTypeList = listHelper.serviceTypeList();
		advanceSearchList = ServiceContactAdvanceSearch
				.getServiceContractAdvanceSearchList();
	}

	/**
	 * <p>
	 * <code>addNewServiceContact</code>Method will Register data from
	 * TAB_SUPPORT_SERVICE_CONTACT
	 * </p>
	 * 
	 * @return
	 * @throws OMIApplicationException
	 * @param serviceContactVo
	 */

	public String addNewServiceContact() throws Exception {
		// Creating the SupportServiceImpl object
		supportServiceInf = new SupportServiceImpl();
		CustomerSessionUser customerSessionUser = LoginUtil
				.getCurrentCustomerUser();
		serviceContactVo.setCreatedBy(customerSessionUser.getCustomerId());

		String message = supportServiceInf
				.registerServiceContact(serviceContactVo);
		/**
		 * TARGET_SUCCESS; TARGET_FAILURE
		 */
		if (OMIConstants.TARGET_SUCCESS.equalsIgnoreCase(message)) {
			logger.info("Successfully Insert Service Contact!");
			addActionMessage("Successfully Insert Service Contact!");
			return SUCCESS;

		} else if (OMIConstants.TARGET_FAILURE.equalsIgnoreCase(message)) {
			logger.info("Error:while  Insert Service Contact!");
			addActionError("Error:while  Insert Service Contact!");
			return ERROR;
		}

		return NONE;
	}

	/**
	 * <p>
	 * <code>showServiceContactInfoGrid</code>Method will fetch data from
	 * TAB_SUPPORT_SERVICE_CONTACT
	 * </p>
	 * List<serviceContactVo> ServiceContactGridList
	 * 
	 * @return ServiceContactGridList
	 * @throws OMIApplicationException
	 * 
	 */

	public String execute() throws Exception {

		CustomerSessionUser customerSessionUser = LoginUtil
				.getCurrentCustomerUser();
		serviceContactVo.setCreatedBy(customerSessionUser.getCustomerId());

		// Creating the SupportServiceImpl object
		supportServiceInf = new SupportServiceImpl();
		// Creating the Value object for SupportCasesVO
		this.serviceContactGridList = supportServiceInf
				.showServiceContactInfoGrid();
		this.serviceContactGridList = supportServiceInf
				.serviceContactSearchList(serviceContactVo);
		if (serviceContactGridList == null) {
			logger.error("Error:While getting Service Contact details as per advance search.");
			addActionError("No records found.");
			return ERROR;
		} else {
			logger.info("Records found successfully.");
			return SUCCESS;
		}

	}

	
	

	/**
	 * <p>
	 * <code>serviceContractSearch</code>Method will fetch data from
	 * TAB_SUPPORT_SERVICE_CONTACT
	 * </p>
	 * List<serviceContactVo> ServiceContactGridList
	 * 
	 * @return ServiceContactGridList
	 * @throws OMIApplicationException
	 * @param serviceContactVo
	 */

	public String serviceContractSearch() throws Exception {
		// Creating the SupportServiceImpl object
		supportServiceInf = new SupportServiceImpl();
		CustomerSessionUser customerSessionUser = LoginUtil
				.getCurrentCustomerUser();
		serviceContactVo.setCreatedBy(customerSessionUser.getCustomerId());
		this.serviceContactGridList = supportServiceInf
				.serviceContactSearchList(serviceContactVo);
		if (serviceContactGridList == null) {
			logger.error("Error:While getting Service Contact details as per advance search.");
			addActionError("No records found.");
			return ERROR;
		} else {
			logger.info("Records found successfully.");
			return SUCCESS;
		}

	}

	/**
	 * <p>
	 * <code>viewServiceContactInfo()</code> method is use to view Service
	 * Contact Info details into view Service Contact page
	 * </p>
	 * 
	 * @return
	 * @throws Exception
	 * @param serviceContactId
	 */
	public String viewServiceContactInfo() throws Exception {
		CustomerSessionUser customerSessionUser = LoginUtil
				.getCurrentCustomerUser();
		serviceContactVo.setCreatedBy(customerSessionUser.getCustomerId());

		// Creating the SupportServiceImpl object
		supportServiceInf = new SupportServiceImpl();
		int serviceContactId = Integer
				.parseInt(request.getParameter("command"));
		this.serviceContactVo = VOMapperHelper.getServiceContactVoFromService(
				serviceContactVo,
				supportServiceInf.viewServiceContactInfo(serviceContactId));
		return SUCCESS;
	}

	/**
	 * <p>
	 * <code>editServiceContactInfo()</code> method is use to edit the Service
	 * Contact details based serviceContactId
	 * </p>
	 * 
	 * @return
	 * @throws Exception
	 */
	public String editServiceContactInfo() throws Exception {
		CustomerSessionUser customerSessionUser = LoginUtil
				.getCurrentCustomerUser();
		serviceContactVo.setCreatedBy(customerSessionUser.getCustomerId());

		int serviceContactId = Integer
				.parseInt(request.getParameter("command"));
		LoginUtil.setProcessUserId(serviceContactId);
		// Creating the SupportServiceImpl object
		supportServiceInf = new SupportServiceImpl();
		this.serviceContactVo = VOMapperHelper.getServiceContactVoFromService(
				serviceContactVo,
				supportServiceInf.editServiceContactInfo(serviceContactId));
		return SUCCESS;
	}

	/**
	 * <p>
	 * <code>updateServiceContactInfo()</code> method is use to update the
	 * Service Contact details based serviceContactId
	 * </p>
	 * 
	 * @return
	 * @throws Exception
	 */
	public String updateServiceContactInfo() throws Exception {

		CustomerSessionUser customerSessionUser = LoginUtil
				.getCurrentCustomerUser();
		serviceContactVo.setCreatedBy(customerSessionUser.getCustomerId());

		// Creating the SupportServiceImpl object
		supportServiceInf = new SupportServiceImpl();
		int serviceContactId = LoginUtil.getProcessUserId();
		String message = supportServiceInf.updateServiceContactInfo(
				serviceContactVo, serviceContactId);
		if (OMIConstants.TARGET_SUCCESS.equalsIgnoreCase(message)) {
			logger.info("Successfully Updating Service Contact Information!");
			addActionMessage("Successfully Updating Service Contact Information!");
			return SUCCESS;

		} else if (OMIConstants.TARGET_FAILURE.equalsIgnoreCase(message)) {

			logger.info("Error:while  Updating Service Contact Information!");
			addActionError("Error:while  Updating Service Contact Information!");
			return ERROR;
		}

		return NONE;
	}

	/**
	 * <p>
	 * <code>deleteServiceContactDetail()</code> method is use to delete the
	 * Service details based serviceContactId
	 * </p>
	 * 
	 * @return
	 * @throws Exception
	 */
	public String deleteServiceContactDetail() throws Exception {
		// Creating the SupportServiceImpl object
		supportServiceInf = new SupportServiceImpl();
		int serviceContactId = Integer
				.parseInt(request.getParameter("command"));
		supportServiceInf.removeSupportServiceContact(serviceContactId);
		return SUCCESS;
	}

	/**
	 * <p>
	 * <code>nextViewServiceContact()</code> method is use to next View Service
	 * Contact into view Service Contact page
	 * </p>
	 * 
	 * @return
	 * @throws Exception
	 */
	public String nextViewServiceContact() throws Exception {
		int serviceContactId = LoginUtil.getProcessUserId();
		// Creating the SupportServiceImpl object
		supportServiceInf = new SupportServiceImpl();
		this.serviceContactVo = VOMapperHelper.getServiceContactVoFromService(
				serviceContactVo,
				supportServiceInf.viewNextServiceContact(serviceContactId));

		if (serviceContactVo.getServiceContactId() != 0) {
			logger.info("Contact Service details found successfully for Service Contact Id  "
					+ serviceContactVo.getServiceContactId());
			addActionMessage("Contact Service details found successfully for Contact Service Id "
					+ serviceContactVo.getServiceContactId());
			return SUCCESS;
		} else {
			serviceContactVo.setServiceContactId(LoginUtil.getProcessUserId());
			logger.error("Service Contact details not found for Service Contact Id  "
					+ serviceContactVo.getServiceContactId());
			addActionError("Service Contact details not found for Service Contact Id "
					+ serviceContactVo.getServiceContactId());
			return ERROR;

		}
	}

	/**
	 * <p>
	 * <code>editNextContactService()</code> method is use to populate edit Next
	 * Contact Service details into edit Contact Service page
	 * </p>
	 * 
	 * @return
	 * @throws Exception
	 */
	public String editNextContactService() throws Exception {
		int serviceContactId = LoginUtil.getProcessUserId();
		// Creating the SupportServiceImpl object
		supportServiceInf = new SupportServiceImpl();
		this.serviceContactVo = VOMapperHelper.getServiceContactVoFromService(
				serviceContactVo,
				supportServiceInf.editNextServiceContact(serviceContactId));
		if (serviceContactVo.getServiceContactId() != 0) {
			logger.info("Service Contact details found successfully for Service Contact Id  "
					+ serviceContactVo.getServiceContactId());
			addActionMessage("Service Contact details found successfully for Service Contact Id "
					+ serviceContactVo.getServiceContactId());
			return SUCCESS;
		} else {
			serviceContactVo.setServiceContactId(LoginUtil.getProcessUserId());
			logger.error("Service Contact details not found for Service Contact Id  "
					+ serviceContactVo.getServiceContactId());
			addActionError("Service Contact details not found for Service Contact Id "
					+ serviceContactVo.getServiceContactId());
			return ERROR;

		}
	}

	/**
	 * <p>
	 * <code>previousViewServiceContact()</code> method is use to previous View
	 * Service Contact into view Service Contact page
	 * </p>
	 * 
	 * @return
	 * @throws Exception
	 */
	public String previousViewServiceContact() throws Exception {
		int serviceContactId = LoginUtil.getProcessUserId();
		// Creating the SupportServiceImpl object
		supportServiceInf = new SupportServiceImpl();
		this.serviceContactVo = VOMapperHelper.getServiceContactVoFromService(
				serviceContactVo,
				supportServiceInf.viewPreviousServiceContact(serviceContactId));

		if (serviceContactVo.getServiceContactId() != 0) {
			logger.info("Service Contact details found successfully for Service Contact Id  "
					+ serviceContactVo.getServiceContactId());
			addActionMessage("Service Contact details found successfully for Service Contact Id "
					+ serviceContactVo.getServiceContactId());
			return SUCCESS;
		} else if (LoginUtil.getProcessUserId() == -1) {
			LoginUtil.setProcessUserId(supportDaoInf
					.getServiceContactLastRecord() + 1);
			logger.error("Service Contact details not found");
			addActionError("Service Contact details not found");
			return ERROR;
		} else {
			serviceContactVo.setServiceContactId(LoginUtil.getProcessUserId());
			logger.error("Service Contact details not found for Service Contact Id  "
					+ serviceContactVo.getServiceContactId());
			addActionError("Service Contact details not found for Service Contact Id "
					+ serviceContactVo.getServiceContactId());
			return ERROR;

		}

	}

	/**
	 * <p>
	 * <code>previousEditServiceContact()</code> method is use to view the
	 * Service Contact details into edit Service Contact page
	 * </p>
	 * 
	 * @return
	 * @throws Exception
	 */
	public String previousEditServiceContact() throws Exception {
		int serviceContactId = LoginUtil.getProcessUserId();
		SupportDaoInf supportDaoInf = new SupportDaoImpl();
		supportServiceInf = new SupportServiceImpl();
		this.serviceContactVo = VOMapperHelper.getServiceContactVoFromService(
				serviceContactVo,
				supportServiceInf.editPreviousServiceContact(serviceContactId));

		if (serviceContactVo.getServiceContactId() != 0) {
			logger.info("Service Contact details found successfully for Service Contact Id  "
					+ serviceContactVo.getServiceContactId());
			addActionMessage("Service Contact details found successfully for Service Contact Id "
					+ serviceContactVo.getServiceContactId());
			return SUCCESS;
		} else if (LoginUtil.getProcessUserId() == -1) {
			LoginUtil.setProcessUserId(supportDaoInf
					.getServiceContactLastRecord() + 1);
			logger.error("Service Contact details not found");
			addActionError("Service Contact details not found");
			return ERROR;
		} else {
			serviceContactVo.setServiceContactId(LoginUtil.getProcessUserId());
			logger.error("Service Contact details not found for Service Contact Id  "
					+ serviceContactVo.getServiceContactId());
			addActionError("Service Contact details not found for Service Contact Id "
					+ serviceContactVo.getServiceContactId());
			return ERROR;

		}

	}

	/**
	 * @return the serviceContactVo
	 */
	public ServiceContactVo getServiceContactVo() {
		return serviceContactVo;
	}

	/**
	 * @param serviceContactVo
	 *            the serviceContactVo to set
	 */
	public void setServiceContactVo(ServiceContactVo serviceContactVo) {
		this.serviceContactVo = serviceContactVo;
	}

	/**
	 * @return the serviceContactNameList
	 */
	public Map<Integer, String> getServiceContactNameList() {
		return serviceContactNameList;
	}

	/**
	 * @param serviceContactNameList
	 *            the serviceContactNameList to set
	 */
	public void setServiceContactNameList(
			Map<Integer, String> serviceContactNameList) {
		this.serviceContactNameList = serviceContactNameList;
	}

	/**
	 * @return the serviceStatusList
	 */
	public Map<Integer, String> getServiceStatusList() {
		return serviceStatusList;
	}

	/**
	 * @param serviceStatusList
	 *            the serviceStatusList to set
	 */
	public void setServiceStatusList(Map<Integer, String> serviceStatusList) {
		this.serviceStatusList = serviceStatusList;
	}

	/**
	 * @return the servicePriorityList
	 */
	public Map<Integer, String> getServicePriorityList() {
		return servicePriorityList;
	}

	/**
	 * @param servicePriorityList
	 *            the servicePriorityList to set
	 */
	public void setServicePriorityList(Map<Integer, String> servicePriorityList) {
		this.servicePriorityList = servicePriorityList;
	}

	/**
	 * @return the releteddToList
	 */
	public Map<Integer, String> getReleteddToList() {
		return releteddToList;
	}

	/**
	 * @param releteddToList
	 *            the releteddToList to set
	 */
	public void setReleteddToList(Map<Integer, String> releteddToList) {
		this.releteddToList = releteddToList;
	}

	/**
	 * @return the serviceAssignedToList
	 */
	public Map<Integer, String> getServiceAssignedToList() {
		return serviceAssignedToList;
	}

	/**
	 * @param serviceAssignedToList
	 *            the serviceAssignedToList to set
	 */
	public void setServiceAssignedToList(
			Map<Integer, String> serviceAssignedToList) {
		this.serviceAssignedToList = serviceAssignedToList;
	}

	/**
	 * @return the serviceTypeList
	 */
	public Map<Integer, String> getServiceTypeList() {
		return serviceTypeList;
	}

	/**
	 * @param serviceTypeList
	 *            the serviceTypeList to set
	 */
	public void setServiceTypeList(Map<Integer, String> serviceTypeList) {
		this.serviceTypeList = serviceTypeList;
	}

	/**
	 * @return the serviceTrackingUnitList
	 */
	public Map<Integer, String> getServiceTrackingUnitList() {
		return serviceTrackingUnitList;
	}

	/**
	 * @param serviceTrackingUnitList
	 *            the serviceTrackingUnitList to set
	 */
	public void setServiceTrackingUnitList(
			Map<Integer, String> serviceTrackingUnitList) {
		this.serviceTrackingUnitList = serviceTrackingUnitList;
	}

	/**
	 * @return the advanceSearchList
	 */
	public Map<Integer, String> getAdvanceSearchList() {
		return advanceSearchList;
	}

	/**
	 * @param advanceSearchList
	 *            the advanceSearchList to set
	 */
	public void setAdvanceSearchList(Map<Integer, String> advanceSearchList) {
		this.advanceSearchList = advanceSearchList;
	}

	/**
	 * @return the listHelper
	 */
	public ListHelper getListHelper() {
		return listHelper;
	}

	/**
	 * @param listHelper
	 *            the listHelper to set
	 */
	public void setListHelper(ListHelper listHelper) {
		this.listHelper = listHelper;
	}

	/**
	 * @return the serviceContactGridList
	 */
	public List<ServiceContactVo> getServiceContactGridList() {
		return serviceContactGridList;
	}

	/**
	 * @param serviceContactGridList
	 *            the serviceContactGridList to set
	 */
	public void setServiceContactGridList(
			List<ServiceContactVo> serviceContactGridList) {
		this.serviceContactGridList = serviceContactGridList;
	}

	public void setSession(Map<String, Object> arg0) {
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public ServiceContactVo getModel() {
		return serviceContactVo;
	}

}
