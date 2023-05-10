package com.bst.ckt.action;

import java.io.PrintWriter;
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
import com.bst.ckt.dao.SupportDaoImpl;
import com.bst.ckt.dao.SupportDaoInf;
import com.bst.ckt.exception.OMIApplicationException;
import com.bst.ckt.helper.FAQAdvanceSearch;
import com.bst.ckt.helper.FAQStatus;
import com.bst.ckt.helper.ListHelper;
import com.bst.ckt.helper.VOMapperHelper;
import com.bst.ckt.service.LeadServiceImpl;
import com.bst.ckt.service.SupportServiceImpl;
import com.bst.ckt.service.SupportServiceInf;
import com.bst.ckt.vo.LeadTitleVO;
import com.bst.ckt.vo.SupportFaqVO;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 
 * @author ROHIT GURJAR
 * 
 */
public class SupportFaqAction extends ActionSupport implements
		ModelDriven<SupportFaqVO>, SessionAware, ServletRequestAware,
		ServletResponseAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Creating Logger object, logger object mapped with SupportFaqAction class
	 * for writing Loggers.
	 */
	private static final Logger logger = Logger
			.getLogger(SupportFaqAction.class);

	SupportFaqVO supportFaqVO = new SupportFaqVO();
	SupportServiceInf supportServiceInf = new SupportServiceImpl();
	SupportDaoInf supportDaoInf = null;
	private Map<Integer, String> faqCategoryList;
	private Map<Integer, String> faqStatusList;
	private Map<Integer, String> faqProductNameList;
	private Map<Integer, String> faqOwnerList;
	private Map<Integer, String> advanceSearchList;

	private List<SupportFaqVO> productNameGrid = null;

	HttpServletResponse response = null;
	ListHelper listHelper = new ListHelper();
	Map<String, Object> session = null;
	List<SupportFaqVO> faqGridList;
	HttpServletRequest request = (HttpServletRequest) ActionContext
			.getContext().get(ServletActionContext.HTTP_REQUEST);

	public SupportFaqAction() throws Exception {
		faqCategoryList = listHelper.faqCategoryList();
		faqStatusList = FAQStatus.getModifiedFAQStatusList();
		faqProductNameList = listHelper.faqProductNameList();
		faqOwnerList = listHelper.faqOwnerList();
		advanceSearchList = FAQAdvanceSearch.getFaqAdvanceSearchList();

		productNameGrid = supportServiceInf.showProductName();

		faqProductNameList = listHelper.faqProductNameList();
		this.faqGridList = supportServiceInf.showFaqInfoGrid();
	}

	/**
	 * <p>
	 * <code>addProductName()</code> this method design to add product name into
	 * the database.
	 * </p>
	 * 
	 * @return SUCCESS
	 * @throws Exception
	 */
	public String addProductName() throws OMIApplicationException {

		String message = null;

		message = supportServiceInf.addProductName(supportFaqVO);

		/**
		 * RESULT_SUCCESS TARGET_LEAD_TITLE_ALREADY_INSERTED
		 * */
		if (OMIConstants.TARGET_SUCCESS.equalsIgnoreCase(message)) {
			productNameGrid = supportServiceInf.showProductName();
			faqProductNameList = listHelper.faqProductNameList();
			logger.info("Product Name inserted successfully.");
			addActionMessage("Product Name inserted successfully.");
			return SUCCESS;
		} else if (OMIConstants.TARGET_LEAD_TITLE_ALREADY_EXIST
				.equalsIgnoreCase(message)) {
			logger.info("Error:Product Name already exists!");
			addActionError("Product Name already exists.");
			return INPUT;
		}
		return NONE;
	}

	/**
	 * <p>
	 * <code>isProductNameExist()</code> method verify whether the leproduct
	 * name existed title already exists
	 * </p>
	 * 
	 * @return NONE
	 * @throws Exception
	 */
	public String isProductNameExist() throws Exception {

		try {

			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
			PrintWriter printWriter = response.getWriter();

			if (supportDaoInf.isProductNameExist(request
					.getParameter("productName")) == 1) {
				printWriter.print("Product already exists.");
			}

		} catch (Exception exception) {
			logger.error(
					"Error While verifying whether  the Product already exists ",
					exception);
		}
		return NONE;
	}

	/**
	 * <p>
	 * <code>addNewFaq</code>Method will Register data from TAB_SUPPORT_FAQ
	 * </p>
	 * 
	 * @return
	 * @throws OMIApplicationException
	 * @param supportFaqVO
	 */

	public String addNewFaq() throws Exception {
		supportServiceInf = new SupportServiceImpl();
		/*
		 * CustomerSessionUser customerSessionUser = LoginUtil
		 * .getCurrentCustomerUser();
		 * supportFaqVO.setCreatedBy(customerSessionUser.getCustomerId());
		 */
		String message = supportServiceInf.registerFaq(supportFaqVO);
		/**
		 * TARGET_SUCCESS; TARGET_FAILURE
		 */
		if (OMIConstants.TARGET_SUCCESS.equalsIgnoreCase(message)) {
			logger.info("Successfully Insert FAQ!");
			addActionMessage("Successfully Insert FAQ!");
			return SUCCESS;

		} else if (OMIConstants.TARGET_FAILURE.equalsIgnoreCase(message)) {

			logger.info("Error:while  Insert FAQ!");
			addActionError("Error:while  Insert FAQ!");
			return ERROR;
		}

		return NONE;
	}

	/**
	 * <p>
	 * <code>showFaqInfoGrid</code>Method will fetch data from TAB_SUPPORT_FAQ
	 * </p>
	 * List<SupportFaqVO> faqGridList
	 * 
	 * @return faqGridList
	 * @throws OMIApplicationException
	 * 
	 */

	public String execute() throws Exception {
		/*
		 * CustomerSessionUser customerSessionUser = LoginUtil
		 * .getCurrentCustomerUser();
		 * supportFaqVO.setCreatedBy(customerSessionUser.getCustomerId());
		 */
		// Creating the SupportServiceImpl object
		supportServiceInf = new SupportServiceImpl();
		// Creating the Value object for SupportFaqVO
		
		this.faqGridList = supportServiceInf.faqDetailsGrid(supportFaqVO);
		if (faqGridList == null) {
			logger.error("Error:While getting Faq details as per advance search.");
			addActionError("No records found.");
			return ERROR;
		} else {
			logger.info("Records found successfully.");
			return SUCCESS;
		}

	}

	/**
	 * <p>
	 * <code>viewFaqInfo()</code> method is use to view the faq details into
	 * view faq page
	 * </p>
	 * 1
	 * 
	 * @return
	 * @throws Exception
	 */
	public String viewFaqInfo() throws Exception {
		/*
		 * CustomerSessionUser customerSessionUser = LoginUtil
		 * .getCurrentCustomerUser();
		 * supportFaqVO.setCreatedBy(customerSessionUser.getCustomerId());
		 */
		// Creating the SupportServiceImpl object
		supportServiceInf = new SupportServiceImpl();
		int faqId = Integer.parseInt(request.getParameter("command"));
		this.supportFaqVO = VOMapperHelper.getSupportFaqVOFromFaq(supportFaqVO,
				supportServiceInf.viewFaqInfo(faqId));
		return SUCCESS;
	}

	/**
	 * <p>
	 * <code>editFaqInfo()</code> method is use to edit the faq details based
	 * faqId
	 * </p>
	 * 
	 * @return
	 * @throws Exception
	 */
	public String editFaqInfo() throws Exception {
		/*
		 * CustomerSessionUser customerSessionUser = LoginUtil
		 * .getCurrentCustomerUser();
		 * supportFaqVO.setCreatedBy(customerSessionUser.getCustomerId());
		 */
		int faqId = Integer.parseInt(request.getParameter("command"));
		LoginUtil.setProcessUserId(faqId);
		// Creating the SupportServiceImpl object
		supportServiceInf = new SupportServiceImpl();
		this.supportFaqVO = VOMapperHelper.getSupportFaqVOFromFaq(supportFaqVO,
				supportServiceInf.editFaqInfo(faqId));
		return SUCCESS;
	}

	/**
	 * <p>
	 * <code>updateFaqInfo()</code> method is use to update the faq details
	 * based faqId
	 * </p>
	 * 
	 * @return
	 * @throws Exception
	 */
	public String updateFaqInfo() throws Exception {
		/*
		 * CustomerSessionUser customerSessionUser = LoginUtil
		 * .getCurrentCustomerUser();
		 * supportFaqVO.setCreatedBy(customerSessionUser.getCustomerId());
		 */
		// Creating the SupportServiceImpl object
		supportServiceInf = new SupportServiceImpl();
		int faqId = LoginUtil.getProcessUserId();
		String message = supportServiceInf.updateFaqInfo(supportFaqVO, faqId);
		if (OMIConstants.TARGET_SUCCESS.equalsIgnoreCase(message)) {
			logger.info("Successfully Updating FAQ Information!");
			addActionMessage("Successfully Updating FAQ Information!");
			return SUCCESS;

		} else if (OMIConstants.TARGET_FAILURE.equalsIgnoreCase(message)) {

			logger.info("Error:while  Updating FAQ Information!");
			addActionError("Error:while  Updating FAQ Information!");
			return ERROR;
		}

		return NONE;
	}

	/**
	 * <p>
	 * <code>deleteSupportFaqDetails()</code> method is use to delete the faq
	 * details based faqId
	 * </p>
	 * 
	 * @return
	 * @throws Exception
	 */
	public String deleteSupportFaqDetails() throws Exception {
		// Creating the SupportServiceImpl object
		
		try {
			int faqId = Integer.parseInt(request.getParameter("command"));

			supportServiceInf.removeSupportFaqDetails(faqId);

			return SUCCESS;
		} catch (Exception exception) {
			logger.error("ERROR:Erroe while deleting faq details from database.");
			return ERROR;
		}
	}

	/**
	 * <p>
	 * <code>nextViewFaq()</code> method is use to view the faq details into
	 * view Faq page
	 * </p>
	 * 
	 * @return
	 * @throws Exception
	 */
	public String nextViewFaq() throws Exception {
		int faqId = Integer.parseInt(request.getParameter("command"));
		supportServiceInf = new SupportServiceImpl();
		this.supportFaqVO = VOMapperHelper.getSupportFaqVOFromFaq(supportFaqVO,
				supportServiceInf.viewNextFaqDetails(faqId));

		if (supportFaqVO.getFaqId() != 0) {
			logger.info("Faq details found successfully for Faq Id  "
					+ supportFaqVO.getFaqId());
			addActionMessage("Faq details found successfully for Faq Id "
					+ supportFaqVO.getFaqId());
			return SUCCESS;
		} else {
			supportFaqVO.setFaqId(Integer.parseInt(request
					.getParameter("command")));
			logger.error("Faq details not found for Faq Id  "
					+ supportFaqVO.getFaqId());
			addActionError("Faq details not found for Faq Id "
					+ supportFaqVO.getFaqId());
			return ERROR;

		}
	}

	/**
	 * <p>
	 * <code>editNextFaq()</code> method is use to populate next faq details
	 * into edit faq page
	 * </p>
	 * 
	 * @return
	 * @throws Exception
	 */
	public String editNextFaq() throws Exception {
		int faqId = LoginUtil.getProcessUserId();
		supportServiceInf = new SupportServiceImpl();
		this.supportFaqVO = VOMapperHelper.getSupportFaqVOFromFaq(supportFaqVO,
				supportServiceInf.editNextFaqDetails(faqId));
		if (supportFaqVO.getFaqId() != 0) {
			logger.info("Faq details found successfully for Faq Id  "
					+ supportFaqVO.getFaqId());
			addActionMessage("Faq details found successfully for Faq Id "
					+ supportFaqVO.getFaqId());
			return SUCCESS;
		} else {
			supportFaqVO.setFaqId(LoginUtil.getProcessUserId());
			logger.error("Faq details not found for Faq Id  "
					+ supportFaqVO.getFaqId());
			addActionError("Faq details not found for Faq Id "
					+ supportFaqVO.getFaqId());
			return ERROR;

		}
	}

	/**
	 * <p>
	 * <code>previousViewFaq()</code> method is use to view the Faq details into
	 * view Faq page
	 * </p>
	 * 
	 * @return
	 * @throws Exception
	 */
	public String previousViewFaq() throws Exception {
		int faqId = LoginUtil.getProcessUserId();
		SupportDaoInf supportDaoInf = new SupportDaoImpl();
		supportServiceInf = new SupportServiceImpl();
		this.supportFaqVO = VOMapperHelper.getSupportFaqVOFromFaq(supportFaqVO,
				supportServiceInf.viewPreviousFaqDetails(faqId));

		if (supportFaqVO.getFaqId() != 0) {
			logger.info("Faq details found successfully for Faq Id  "
					+ supportFaqVO.getFaqId());
			addActionMessage("Faq details found successfully for Faq Id "
					+ supportFaqVO.getFaqId());
			return SUCCESS;
		} else if (LoginUtil.getProcessUserId() == -1) {
			LoginUtil.setProcessUserId(supportDaoInf.getFaqLastRecord() + 1);
			logger.error("Faq details not found");
			addActionError("Faq details not found");
			return ERROR;
		} else {
			supportFaqVO.setFaqId(LoginUtil.getProcessUserId());
			logger.error("Faq details not found for Faq Id  "
					+ supportFaqVO.getFaqId());
			addActionError("Faq details not found for Faq Id "
					+ supportFaqVO.getFaqId());
			return ERROR;

		}

	}

	/**
	 * <p>
	 * <code>previousEditFaq()</code> method is use to view the Faq details into
	 * edit Faq page
	 * </p>
	 * 
	 * @return
	 * @throws Exception
	 */
	public String previousEditFaq() throws Exception {
		int faqId = LoginUtil.getProcessUserId();
		SupportDaoInf supportDaoInf = new SupportDaoImpl();
		supportServiceInf = new SupportServiceImpl();
		this.supportFaqVO = VOMapperHelper.getSupportFaqVOFromFaq(supportFaqVO,
				supportServiceInf.editPreviousFaqDetails(faqId));

		if (supportFaqVO.getFaqId() != 0) {
			logger.info("Faq details found successfully for Faq Id  "
					+ supportFaqVO.getFaqId());
			addActionMessage("Faq details found successfully for Faq Id "
					+ supportFaqVO.getFaqId());
			return SUCCESS;
		} else if (LoginUtil.getProcessUserId() == -1) {
			LoginUtil.setProcessUserId(supportDaoInf.getFaqLastRecord() + 1);
			logger.error("Faq details not found");
			addActionError("Faq details not found");
			return ERROR;
		} else {
			supportFaqVO.setFaqId(LoginUtil.getProcessUserId());
			logger.error("Faq details not found for Faq Id  "
					+ supportFaqVO.getFaqId());
			addActionError("Faq details not found for Faq Id "
					+ supportFaqVO.getFaqId());
			return ERROR;

		}

	}

	public SupportFaqVO getModel() {
		return supportFaqVO;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {

	}

	public ListHelper getListHelper() {
		return listHelper;
	}

	public void setListHelper(ListHelper listHelper) {
		this.listHelper = listHelper;
	}

	public SupportFaqVO getSupportFaqVO() {
		return supportFaqVO;
	}

	public void setSupportFaqVO(SupportFaqVO supportFaqVO) {
		this.supportFaqVO = supportFaqVO;
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

	public Map<Integer, String> getFaqCategoryList() {
		return faqCategoryList;
	}

	public void setFaqCategoryList(Map<Integer, String> faqCategoryList) {
		this.faqCategoryList = faqCategoryList;
	}

	public Map<Integer, String> getFaqStatusList() {
		return faqStatusList;
	}

	public void setFaqStatusList(Map<Integer, String> faqStatusList) {
		this.faqStatusList = faqStatusList;
	}

	public List<SupportFaqVO> getFaqGridList() {
		return faqGridList;
	}

	public void setFaqGridList(List<SupportFaqVO> faqGridList) {
		this.faqGridList = faqGridList;
	}

	/**
	 * @return the faqProductNameList
	 */
	public Map<Integer, String> getFaqProductNameList() {
		return faqProductNameList;
	}

	/**
	 * @param faqProductNameList
	 *            the faqProductNameList to set
	 */
	public void setFaqProductNameList(Map<Integer, String> faqProductNameList) {
		this.faqProductNameList = faqProductNameList;
	}

	/**
	 * @return the faqOwnerList
	 */
	public Map<Integer, String> getFaqOwnerList() {
		return faqOwnerList;
	}

	/**
	 * @param faqOwnerList
	 *            the faqOwnerList to set
	 */
	public void setFaqOwnerList(Map<Integer, String> faqOwnerList) {
		this.faqOwnerList = faqOwnerList;
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
	 * <p>
	 * excelReportSupportFaq()
	 * </p>
	 * method to generate the Excel Sheet report of FAQ Dashboard from database
	 * 
	 * @return
	 * @throws Exception
	 * @author Roshan Patel
	 * @param request
	 *            ,response
	 */
	public String excelReportSupportFaq() throws Exception {
		supportServiceInf.supportFaqExcelReport(request, response);
		return NONE;
	}

	/**
	 * <p>
	 * excelReportSupportFaq()
	 * </p>
	 * method to generate the Excel Sheet report of FAQ Dashboard from database
	 * 
	 * @return
	 * @throws Exception
	 * @author Roshan Patel
	 * @param request
	 *            ,response
	 */
	public String faqPrintPDF() throws Exception {

		int faqId = Integer.parseInt(request.getParameter("command"));

		supportServiceInf.faqPDFReport(request, response, faqId);
		return null;
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
	 * @return the productNameGrid
	 */
	public List<SupportFaqVO> getProductNameGrid() {
		return productNameGrid;
	}

	/**
	 * @param productNameGrid
	 *            the productNameGrid to set
	 */
	public void setProductNameGrid(List<SupportFaqVO> productNameGrid) {
		this.productNameGrid = productNameGrid;
	}

}
