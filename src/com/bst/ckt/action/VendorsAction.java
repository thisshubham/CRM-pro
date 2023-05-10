/**
 * 
 */
package com.bst.ckt.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.bst.ckt.common.LoginUtil;
import com.bst.ckt.common.OMIConstants;
import com.bst.ckt.dao.AjaxDaoImpl;
import com.bst.ckt.dao.VendorsDaoImpl;
import com.bst.ckt.dao.VendorsDaoInf;
import com.bst.ckt.framework.user.CustomerSessionUser;
import com.bst.ckt.helper.ListHelper;
import com.bst.ckt.helper.Salutation;
import com.bst.ckt.helper.VOMapperHelper;
import com.bst.ckt.helper.VendorAdvanceSearch;
import com.bst.ckt.helper.VendorStatus;
import com.bst.ckt.service.VendorsServiceImpl;
import com.bst.ckt.service.VendorsServiceInf;
import com.bst.ckt.vo.VendorsVO;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @author gurjar
 * 
 */
public class VendorsAction extends ActionSupport implements
		ServletResponseAware, ModelDriven<VendorsVO>, SessionAware {

	/**
* 
*/
	private static final long serialVersionUID = 1L;
	/**
	 * Creating Logger object, logger object mapped with LeadAction class for
	 * writing Loggers.
	 */
	private static final Logger logger = Logger.getLogger(VendorsAction.class);

	VendorsServiceInf vendorsServiceInf = new VendorsServiceImpl();
	VendorsDaoInf vendorsDaoInf = new VendorsDaoImpl();
	ListHelper listHelper = new ListHelper();
	VendorsVO vendorsVO = new VendorsVO();
	HttpServletResponse response = null;
	HttpServletRequest request = (HttpServletRequest) ActionContext
			.getContext().get(ServletActionContext.HTTP_REQUEST);
	Map<String, Object> session = null;
	String result = OMIConstants.TARGET_INPUT;
	AjaxDaoImpl ajaxDaoImpl = new AjaxDaoImpl();
	private Map<Integer, String> vendorsCategoryList;
	private Map<Integer, String> countryList;
	private Map<Integer, String> salutationList;
	private Map<Integer, String> vendorsAssignedToList;
	private Map<Integer, String> vendorGLAccountList;
	private List<VendorsVO> vendorsDetailsList = null;
	private Map<Integer, String> vendorStatusList;
	private Map<Integer, String> advanceSearchList;
	private Map<String, String> vendorNameList;
	private Map<String, String> vendorPhoneList;
	private Map<String, String> primaryEmailList;

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
	 * @return the session
	 */
	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public VendorsAction() throws Exception {
		salutationList = Salutation.getSalutationList();
		vendorStatusList = VendorStatus.getVendorStatusList();
		vendorsCategoryList = listHelper.vendorsCategoryList();
		countryList = listHelper.countryList();
		vendorGLAccountList=listHelper.vendorsGlAccountList();
		CustomerSessionUser customerSessionUser = LoginUtil
				.getCurrentCustomerUser();
		Integer id = customerSessionUser.getCustomerId();
		vendorsVO.setCreatedBy(id.toString());
		vendorsVO.setUpdatedBy(id.toString());
		vendorsVO.setAssignedTo(id.toString());
		vendorsAssignedToList = listHelper.vendorsAssignedToList();
		
		advanceSearchList=VendorAdvanceSearch.getVendorAdvanceSearchList();
		vendorNameList=vendorsDaoInf.getVendorsNameList();
		vendorPhoneList=vendorsDaoInf.getVendorPhoneList();
		primaryEmailList=vendorsDaoInf.getPrimaryEmailList();

	}

	public String execute() throws Exception {
		try {
			vendorsServiceInf = new VendorsServiceImpl();
			vendorsDetailsList = vendorsServiceInf.getVendorsDetailsList();
			return SUCCESS;
		} catch (Exception exception) {
			logger.error("Fail while get campaign details list");
			return ERROR;
		}
	}

	/**
	 * <p>
	 * AddVendorsDetails()
	 * </p>
	 * method is use to add Vendors details into database
	 * 
	 * @return SUCCESS
	 * @throws Exception
	 */

	public String addVendorsDetails() throws Exception {
		vendorsServiceInf = new VendorsServiceImpl();
		CustomerSessionUser customerSessionUser = LoginUtil
				.getCurrentCustomerUser();
		String message = vendorsServiceInf.registerVendorsDetail(vendorsVO);
		/**
		 * TARGET_SUCCESS; TARGET_FAILURE
		 */
		if (OMIConstants.TARGET_SUCCESS.equalsIgnoreCase(message)) {
			logger.info("Successfully Insert Vendors Details!");
			addActionMessage("Successfully Insert Vendors Details!");
			return SUCCESS;

		} else if (OMIConstants.TARGET_FAILURE.equalsIgnoreCase(message)) {

			logger.info("Error:while  Insert Vendors Details!");
			addActionError("Error:while  Insert Vendors Details!");
			return INPUT;
		}

		return NONE;
	}

	/**
	 * <p>
	 * <code>viewVendorsDetails()</code> method is use to view the Vendors
	 * details into view Vendors page
	 * </p>
	 * 
	 * @return
	 * @throws Exception
	 */
	public String viewVendorsDetails() throws Exception {
		try {
			int vendorsId = Integer.parseInt(request.getParameter("command"));
			LoginUtil.setProcessUserId(vendorsId);
			this.vendorsVO = VOMapperHelper.getVendorsVOFromVendors(vendorsVO,
					vendorsServiceInf.viewVendorsDetail(vendorsId));

			return SUCCESS;
		} catch (Exception exception) {
			logger.error("Fail while get view Vendors details.");
			return ERROR;
		}
	}

	/**
	 * <p>
	 * <code>nextViewVendors()</code> method is use to view the lead details
	 * into view lead page
	 * </p>
	 * 
	 * @return
	 * @throws Exception
	 */
	public String nextViewVendors() throws Exception {
		int vendorsId = LoginUtil.getProcessUserId();
		this.vendorsVO = VOMapperHelper.getVendorsVOFromVendors(vendorsVO,
				vendorsServiceInf.viewNextvendorsDetails(vendorsId));

		if (vendorsVO.getVendorsId() != 0) {
			logger.info("Vendors details found successfully for Vendors Id  "
					+ vendorsVO.getVendorsId());
			addActionMessage("Vendors details found successfully for Vendors Id "
					+ vendorsVO.getVendorsId());
			return SUCCESS;
		} else {
			vendorsVO.setVendorsId(LoginUtil.getProcessUserId());
			logger.error("Vendors details not found for Vendors Id  "
					+ vendorsVO.getVendorsId());
			addActionError("Vendors details not found for Vendors Id "
					+ vendorsVO.getVendorsId());
			return ERROR;

		}
	}

	/**
	 * <p>
	 * <code>viewNextLead()</code> method is use to view the lead details into
	 * view lead page
	 * </p>
	 * 
	 * @return
	 * @throws Exception
	 */
	public String previousViewVendors() throws Exception {
		int vendorsId = LoginUtil.getProcessUserId();
		this.vendorsVO = VOMapperHelper.getVendorsVOFromVendors(vendorsVO,
				vendorsServiceInf.viewPreviousVendorsDetails(vendorsId));
		if (vendorsVO.getVendorsId() != 0) {
			logger.info("Lead details found successfully for Vendors Id  "
					+ vendorsVO.getVendorsId());
			addActionMessage("Lead details found successfully for Vendors Id "
					+ vendorsVO.getVendorsId());
			return SUCCESS;
		} else if (LoginUtil.getProcessUserId() == -1) {
			LoginUtil
					.setProcessUserId(vendorsDaoInf.getVendorsLastRecord() + 1);
			logger.error("Vendors details not found");
			addActionError("Vendors details not found");
			return ERROR;
		} else {
			vendorsVO.setVendorsId(LoginUtil.getProcessUserId());
			logger.error("Vendors details not found for Vendors Id  "
					+ vendorsVO.getVendorsId());
			addActionError("Vendors details not found for Vendors Id "
					+ vendorsVO.getVendorsId());
			return ERROR;

		}

	}

	/**
	 * <p>
	 * <code>editVendors()</code>this method is design to get Vendors details
	 * for the update process.
	 * </p>
	 * 
	 * @return SUCCESS
	 * @throws Exception
	 */
	public String editVendors() throws Exception {
		int vendorsId = Integer.parseInt(request.getParameter("command"));
		if (vendorsId == 0)
			vendorsId = LoginUtil.getProcessUserId();
		LoginUtil.setProcessUserId(vendorsId);
		vendorsServiceInf = new VendorsServiceImpl();
		this.vendorsVO = VOMapperHelper.getVendorsVOFromVendors(vendorsVO,
				vendorsServiceInf.editVendorsDetails(vendorsId));
		return SUCCESS;
	}

	/**
	 * <p>
	 * <code>viewVendorsDetails()</code> method is use to view the Vendors
	 * details into view Vendors page
	 * </p>
	 * 
	 * @return
	 * @throws Exception
	 */
	public String selectVendorsDetails() throws Exception {
		try {
			int vendorsId = Integer.parseInt(request.getParameter("command"));
			LoginUtil.setProcessUserId(vendorsId);
			this.vendorsVO = vendorsServiceInf.selectVendorsInfo(vendorsVO,
					vendorsId);
			return SUCCESS;
		} catch (Exception exception) {
			logger.error("Fail while get select Vendors details.");
			return ERROR;
		}
	}

	/**
	 * <p>
	 * <code>updateVendorsDetails()</code> method is use to update Vendors
	 * information into database
	 * </p>
	 * 
	 * @return SUCCESS
	 * @throws Exception
	 */
	public String updateVendorsDetails() throws Exception {
		vendorsServiceInf = new VendorsServiceImpl();
		int vendorsId = LoginUtil.getProcessUserId();
		String message = vendorsServiceInf.updateVendorsInfo(vendorsVO,
				vendorsId);

		if (OMIConstants.TARGET_SUCCESS.equalsIgnoreCase(message)) {

			logger.info("Successfully Updated Vendors Information!");
			addActionMessage("Successfully Updated Vendors Information!");
			return SUCCESS;

		} else if (OMIConstants.TARGET_FAILURE.equalsIgnoreCase(message)) {

			logger.info("Error:while  Updating Vendors Information!");
			addActionError("Error:while  Updating Vendors Information!");
			return INPUT;
		}

		return NONE;
	}

	/**
	 * <p>
	 * <code>vendorDetailsGrid()</code> method is use to retrieve the vendor
	 * details into vendor dashboard page
	 * </p>
	 * 
	 * @return
	 * @throws Exception
	 */

	public String vendorDetailsGrid() throws Exception {

		vendorsServiceInf = new VendorsServiceImpl();
		this.vendorsDetailsList = vendorsServiceInf
				.retriveVendorDetailsGrid(vendorsVO);
		System.out.println(vendorsDetailsList);
		if (vendorsDetailsList == null) {
			logger.error("Error:While getting note details as per advance search.");
			addActionError("No records found.");
			return ERROR;
		} else {
			logger.info("Records found successfully.");
			return SUCCESS;
		}

	}

	/**
	 * <p>
	 * <code>deleteVendorsDetails()</code> method is use to remove the Vendors
	 * details into databases.
	 * </p>
	 * 
	 * @return
	 * @throws Exception
	 */
	public String deleteVendorsDetails() throws Exception {
		// Creating the EmployerServiceImpl object
		try {
			vendorsServiceInf = new VendorsServiceImpl();
			int vendorsId = Integer.parseInt(request.getParameter("command"));
			vendorsServiceInf.removeVendorsDetail(vendorsId);
			return SUCCESS;
		} catch (Exception exception) {
			logger.error("ERROR:Erroe while deleting Vendors details from database.");
			return ERROR;
		}
	}
	
	/**
	 * <p>
	 * excelReport()
	 * </p>
	 * method to generate the Excel Sheet report of note Dashboard from database
	 * 
	 * @return
	 * @throws Exception
	 * @author Vinod Patel
	 * @param request
	 *            ,response
	 */
	public String excelReport() throws Exception {
		vendorsServiceInf.vendorExcelReport(request, response);
		return NONE;
	}
	
	
	/**
	 * <p>
	 * vendorPrintPDF()
	 * </p>
	 * method to generate the pdf report of Vendors details from database
	 * 
	 * @return
	 * @throws Exception
	 */
	public String VendorPrintPDF() throws Exception {
		int vendorsId = LoginUtil.getProcessUserId();
		vendorsServiceInf.VendorsPDF(request, response, vendorsId);
		return null;
	}

	public VendorsVO getModel() {

		return vendorsVO;
	}

	/**
	 * @return the advanceSearchList
	 */
	public Map<Integer, String> getAdvanceSearchList() {
		return advanceSearchList;
	}
	

	/**
	 * @return the vendorNameList
	 */
	public Map<String, String> getVendorNameList() {
		return vendorNameList;
	}

	/**
	 * @param vendorNameList the vendorNameList to set
	 */
	public void setVendorNameList(Map<String, String> vendorNameList) {
		this.vendorNameList = vendorNameList;
	}

	/**
	 * @return the vendorPhoneList
	 */
	public Map<String, String> getVendorPhoneList() {
		return vendorPhoneList;
	}

	/**
	 * @param vendorPhoneList the vendorPhoneList to set
	 */
	public void setVendorPhoneList(Map<String, String> vendorPhoneList) {
		this.vendorPhoneList = vendorPhoneList;
	}

	/**
	 * @return the primaryEmailList
	 */
	public Map<String, String> getPrimaryEmailList() {
		return primaryEmailList;
	}

	/**
	 * @param primaryEmailList the primaryEmailList to set
	 */
	public void setPrimaryEmailList(Map<String, String> primaryEmailList) {
		this.primaryEmailList = primaryEmailList;
	}

	/**
	 * @param advanceSearchList
	 *            the advanceSearchList to set
	 */
	public void setAdvanceSearchList(Map<Integer, String> advanceSearchList) {
		this.advanceSearchList = advanceSearchList;
	}

	public void setServletResponse(HttpServletResponse response) {
		this.response = response;

	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;

	}

	/**
	 * @return the logger
	 */
	public static Logger getLogger() {
		return logger;
	}

	/**
	 * @return the vendorsVO
	 */
	public VendorsVO getVendorsVO() {
		return vendorsVO;
	}

	/**
	 * @param vendorsVO
	 *            the vendorsVO to set
	 */
	public void setVendorsVO(VendorsVO vendorsVO) {
		this.vendorsVO = vendorsVO;
	}

	/**
	 * @return the response
	 */
	public HttpServletResponse getResponse() {
		return response;
	}

	/**
	 * @param response
	 *            the response to set
	 */
	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	/**
	 * @return the request
	 */
	public HttpServletRequest getRequest() {
		return request;
	}

	/**
	 * @param request
	 *            the request to set
	 */
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	/**
	 * @return the result
	 */
	public String getResult() {
		return result;
	}

	/**
	 * @param result
	 *            the result to set
	 */
	public void setResult(String result) {
		this.result = result;
	}

	/**
	 * @return the vendorsCategoryList
	 */
	public Map<Integer, String> getVendorsCategoryList() {
		return vendorsCategoryList;
	}

	/**
	 * @param vendorsCategoryList
	 *            the vendorsCategoryList to set
	 */
	public void setVendorsCategoryList(Map<Integer, String> vendorsCategoryList) {
		this.vendorsCategoryList = vendorsCategoryList;
	}

	/**
	 * @return the countryList
	 */
	public Map<Integer, String> getCountryList() {
		return countryList;
	}

	/**
	 * @param countryList
	 *            the countryList to set
	 */
	public void setCountryList(Map<Integer, String> countryList) {
		this.countryList = countryList;
	}

	/**
	 * @return the salutationList
	 */
	public Map<Integer, String> getSalutationList() {
		return salutationList;
	}

	/**
	 * @param salutationList
	 *            the salutationList to set
	 */
	public void setSalutationList(Map<Integer, String> salutationList) {
		this.salutationList = salutationList;
	}

	/**
	 * @return the vendorsAssignedToList
	 */
	public Map<Integer, String> getVendorsAssignedToList() {
		return vendorsAssignedToList;
	}

	/**
	 * @param vendorsAssignedToList
	 *            the vendorsAssignedToList to set
	 */
	public void setVendorsAssignedToList(
			Map<Integer, String> vendorsAssignedToList) {
		this.vendorsAssignedToList = vendorsAssignedToList;
	}

	/**
	 * @return the vendorGLAccountList
	 */
	public Map<Integer, String> getVendorGLAccountList() {
		return vendorGLAccountList;
	}

	/**
	 * @param vendorGLAccountList
	 *            the vendorGLAccountList to set
	 */
	public void setVendorGLAccountList(Map<Integer, String> vendorGLAccountList) {
		this.vendorGLAccountList = vendorGLAccountList;
	}

	/**
	 * @return the vendorsDetailsList
	 */
	public List<VendorsVO> getVendorsDetailsList() {
		return vendorsDetailsList;
	}

	/**
	 * @param vendorsDetailsList
	 *            the vendorsDetailsList to set
	 */
	public void setVendorsDetailsList(List<VendorsVO> vendorsDetailsList) {
		this.vendorsDetailsList = vendorsDetailsList;
	}

	/**
	 * @return the vendorStatusList
	 */
	public Map<Integer, String> getVendorStatusList() {
		return vendorStatusList;
	}

	/**
	 * @param vendorStatusList
	 *            the vendorStatusList to set
	 */
	public void setVendorStatusList(Map<Integer, String> vendorStatusList) {
		this.vendorStatusList = vendorStatusList;
	}

}
