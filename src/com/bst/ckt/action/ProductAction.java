/**
 * 
 */
package com.bst.ckt.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.json.simple.JSONObject;

import com.bst.ckt.common.LoginUtil;
import com.bst.ckt.common.OMIConstants;
import com.bst.ckt.dao.InvoiceSaleDaoInf;
import com.bst.ckt.dao.ProductDaoImpl;
import com.bst.ckt.dao.ProductDaoInf;
import com.bst.ckt.exception.OMIApplicationException;
import com.bst.ckt.framework.user.CustomerSessionUser;
import com.bst.ckt.helper.ListHelper;
import com.bst.ckt.helper.NameHelper;
import com.bst.ckt.helper.ProductAdvanceSearch;
import com.bst.ckt.helper.VOMapperHelper;
import com.bst.ckt.service.InvoiceSaleServiceImpl;
import com.bst.ckt.service.InvoiceSaleServiceInf;
import com.bst.ckt.service.ProductServiceImpl;
import com.bst.ckt.service.ProductServiceInf;
import com.bst.ckt.vo.ProductVO;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @author Rosu
 * 
 * 
 */
public class ProductAction extends ActionSupport implements
		ModelDriven<ProductVO>,ServletRequestAware,ServletResponseAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Creating Logger object, logger object mapped with ProductAction class for
	 * writing Loggers.
	 */
	private static final Logger logger = Logger.getLogger(ProductAction.class);

	private static final String productId =null;

	ListHelper listHelper = new ListHelper();
	NameHelper nameHelper=new NameHelper();
	HttpServletResponse response = null;
	HttpServletRequest request = (HttpServletRequest) ActionContext
			.getContext().get(ServletActionContext.HTTP_REQUEST);
	ProductVO productVO = new ProductVO();
	ProductServiceInf productServiceInf = new ProductServiceImpl();
	private Map<Integer, String> vendorNameList;
	private Map<Integer, Float> productTaxList;
	private Map<Integer, String> productCategoryList;
	private Map<Integer, String> productUsageUnitList;
	private Map<Integer, String> productManufacturerList;
	private Map<Integer, String> productHandlerList;
	private Map<Integer, String> productGlAccountList;
	private HashMap<Integer, String> productAdvanceSearch;
	private HashMap<String, String> productNameList;
	private HashMap<String, String> productCategory;
	
	private HashMap<Integer, String> itemNameList;

	private HashMap<Integer, String> categoyList;
	private List<ProductVO> productGridList = null;
	private List<ProductVO> productDetailsList = null;
	ProductDaoInf productDaoInf = new ProductDaoImpl();

	public ProductAction() throws Exception {
		vendorNameList = listHelper.vendorsAssignedToList();
		productTaxList = listHelper.taxList();
		productGridList = productDaoInf.showProductDetail();
		productCategoryList = listHelper.productCategoryList();
		productUsageUnitList = listHelper.productUsageUnitList();
		productManufacturerList = listHelper.productManufacturerList();
		productHandlerList = listHelper.productHandlerList();
		productGlAccountList=listHelper.productGlAccountList();
		productAdvanceSearch=ProductAdvanceSearch.getProductAdvanceSearchList();
		itemNameList=listHelper.getProductItemName();
		productNameList=productDaoInf.getProductNameList();
		categoyList=listHelper.getProductCategoryList();
		
	}
	/**
	 * <p>
	 * productDetailsGrid()
	 * </p>
	 * method is use to ad filtered product details into database
	 * 
	 * @return SUCCESS
	 * @throws Exception
	 */
	public String productDetailsGrid() throws Exception {

		productServiceInf = new ProductServiceImpl();
		this.productGridList = productServiceInf.retriveProductDetailsGrid(productVO);
		if (productDetailsList == null) {
			logger.error("Error:While getting product details as per advance search.");
			
			return ERROR;
		} else {
			logger.info("Records found successfully.");
			return SUCCESS;
		}

	}
	/**
	 * <p>
	 * addNewProduct()
	 * </p>
	 * method is use to add product details into database
	 * 
	 * @return SUCCESS
	 * @throws Exception
	 */

	public String addNewProduct() throws Exception {
		
		if(productDaoInf.checkCategoryAvailability(productVO.getProductCategory())!=0){
		String message = productServiceInf.insertNewProduct(productVO);
		
		CustomerSessionUser customerSessionUser=LoginUtil.getCurrentCustomerUser();
		productVO.setCreatedBy(customerSessionUser.getCustomerId());
		if (OMIConstants.TARGET_SUCCESS.equalsIgnoreCase(message)) {
			logger.info("Successfully Insert Product Details!");
			addActionMessage("Successfully Insert Product Details!");
			return SUCCESS;

		} else if (OMIConstants.TARGET_FAILURE.equalsIgnoreCase(message)) {

			logger.info("Error:while  Insert Product Details!");
			addActionError("Error:while  Insert Product Details!");
			return ERROR;
		}
		 else  {
				logger.info("Error:while  Insert Product Details!");
				addActionError("Error:while  Insert Product Details!");
				return ERROR;
			}
		
		}else{
			logger.info("Error: while  Insert Product Details!");
			addActionError("Error: Selected Product doesn't contain any Type!!!!");
			return ERROR;
		}
		

	}
	
	public void getProductTypeJASONList() throws IOException {
		try {
			NameHelper nameHelper=new NameHelper();
			int categoryId = Integer.parseInt(request.getParameter("categoryId"));
			JSONObject typeList = new JSONObject();
			JSONObject typeList1 = new JSONObject();
	
			
			typeList = listHelper.getProductTypJSONeList(categoryId);

			

			PrintWriter out = response.getWriter();
	System.out.println("%%%%%%%%%%"+typeList);
	typeList1.put("typeList", typeList);
			out.print(typeList1);

		} catch (Exception exception) {

			System.out.println(exception);
		}

	}
	
	
	/*public String generateSpecificBillOfSale(){
		try{
		 
			 int salesId = LoginUtil.getProcessUserId();
			 LoginUtil.setProcessUserId(salesId);
				
		InvoiceSaleServiceInf	 invoiceSaleServiceInf= new InvoiceSaleServiceImpl() ;
		invoiceSaleServiceInf.generateBillForSales(request, response, salesId);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
		
	}*/

	public ProductVO getModel() {

		return productVO;
	}

	
	
	
	

	/**
	 * @return the productNameList
	 */
	public HashMap<String, String> getProductNameList() {
		return productNameList;
	}

	/**
	 * @param productNameList the productNameList to set
	 */
	public void setProductNameList(HashMap<String, String> productNameList) {
		this.productNameList = productNameList;
	}

	/**
	 * @return the productDetailsList
	 */
	public List<ProductVO> getProductDetailsList() {
		return productDetailsList;
	}

	/**
	 * @param productDetailsList the productDetailsList to set
	 */
	public void setProductDetailsList(List<ProductVO> productDetailsList) {
		this.productDetailsList = productDetailsList;
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
	 * @return the productVO
	 */
	public ProductVO getProductVO() {
		return productVO;
	}

	/**
	 * @param productVO
	 *            the productVO to set
	 */
	public void setProductVO(ProductVO productVO) {
		this.productVO = productVO;
	}

	/**
	 * @return the vendorNameList
	 */
	public Map<Integer, String> getVendorNameList() {
		return vendorNameList;
	}

	/**
	 * @param vendorNameList
	 *            the vendorNameList to set
	 */
	public void setVendorNameList(Map<Integer, String> vendorNameList) {
		this.vendorNameList = vendorNameList;
	}

	/**
	 * @return the productTaxList
	 */
	public Map<Integer, Float> getProductTaxList() {
		return productTaxList;
	}

	/**
	 * @param productTaxList
	 *            the productTaxList to set
	 */
	public void setProductTaxList(Map<Integer, Float> productTaxList) {
		this.productTaxList = productTaxList;
	}

	/**
	 * @return the productGridList
	 */
	public List<ProductVO> getProductGridList() {
		return productGridList;
	}

	/**
	 * @param productGridList
	 *            the productGridList to set
	 */
	public void setProductGridList(List<ProductVO> productGridList) {
		this.productGridList = productGridList;
	}

	/**
	 * @return the productCategoryList
	 */
	public Map<Integer, String> getProductCategoryList() {
		return productCategoryList;
	}

	

	
	/**
	 * @param productCategoryList the productCategoryList to set
	 */
	public void setProductCategoryList(Map<Integer, String> productCategoryList) {
		this.productCategoryList = productCategoryList;
	}
	/**
	 * @return the productUsageUnitList
	 */
	public Map<Integer, String> getProductUsageUnitList() {
		return productUsageUnitList;
	}

	/**
	 * @param productUsageUnitList
	 *            the productUsageUnitList to set
	 */
	public void setProductUsageUnitList(
			Map<Integer, String> productUsageUnitList) {
		this.productUsageUnitList = productUsageUnitList;
	}

	/**
	 * @return the productManufacturerList
	 */
	public Map<Integer, String> getProductManufacturerList() {
		return productManufacturerList;
	}

	/**
	 * @param productManufacturerList
	 *            the productManufacturerList to set
	 */
	public void setProductManufacturerList(
			Map<Integer, String> productManufacturerList) {
		this.productManufacturerList = productManufacturerList;
	}

	/**
	 * @return the productHandlerList
	 */
	public Map<Integer, String> getProductHandlerList() {
		return productHandlerList;
	}
	

	public HashMap<Integer, String> getProductAdvanceSearch() {
		return productAdvanceSearch;
	}


	public void setProductAdvanceSearch(
			HashMap<Integer, String> productAdvanceSearch) {
		this.productAdvanceSearch = productAdvanceSearch;
	}


	/**
	 * @param productHandlerList
	 *            the productHandlerList to set
	 */
	public void setProductHandlerList(Map<Integer, String> productHandlerList) {
		this.productHandlerList = productHandlerList;
	}
	
	

	/**
	 * @return the productCategory
	 */
	public HashMap<String, String> getProductCategory() {
		return productCategory;
	}

	/**
	 * @param productCategory the productCategory to set
	 */
	public void setProductCategory(HashMap<String, String> productCategory) {
		this.productCategory = productCategory;
	}

	/**
	 * <p>
	 * <code>editProductDetails()</code> method is use to edit the product
	 * details based productId
	 * </p>
	 * Roshan Patel
	 * 
	 * @return
	 * @throws Exception
	 */
	public String editProductDetails() throws Exception {
		
		try {
			int productId = Integer.parseInt(request.getParameter("command"));
			
			LoginUtil.setProcessUserId(productId);
			
			productServiceInf = new ProductServiceImpl();
			this.productVO = VOMapperHelper.getproductFromProduct(productVO,
					productServiceInf.editProductDetails(productId));

			return SUCCESS;
		} catch (NullPointerException exception) {
			logger.error("Fail to get edit product details ! ", exception);
			return ERROR;
		}
	}
	/**
	 * <p>
	 * <code>updateProductDetails()</code> method is use to update Product information into
	 * database
	 * </p>
	 * 
	 * @return SUCCESS
	 * @throws Exception
	 */
	public String updateProductDetails() throws Exception {

		
		int productId = LoginUtil.getProcessUserId();
		String message = productServiceInf.updateProductDetails(productVO, productId);

		if (OMIConstants.TARGET_SUCCESS.equalsIgnoreCase(message)) {

			logger.info("Successfully Updated Product Information!");
			addActionMessage("Successfully Updated Product Information!");
			return SUCCESS;

		} else if (OMIConstants.TARGET_FAILURE.equalsIgnoreCase(message)) {

			logger.info("Error:while  Updating Product Information!");
			addActionError("Error:while  Updating Product Information!");
			return ERROR;
		}
		else  {
			logger.info("Error:while  Updation Product Details!");
			addActionError("Error:while  Updation Product Details!");
			return ERROR;
		}
	}
	/**
	 * <p>
	 * <code>viewProduct()</code> method is use to view the Product details into view
	 * Product page
	 * </p>
	 * 
	 * @return
	 * @throws Exception
	 * @author Rosu patel 
	 */
	
	
	public String viewProductDetail() throws Exception {
		
		try {
			int productId = Integer.parseInt(request.getParameter("command"));
			
			LoginUtil.setProcessUserId(productId);
			this.productVO = VOMapperHelper.getproductFromProduct(productVO,
					productServiceInf.viewProductDetail(productId));
			
			return SUCCESS;
		} catch (Exception exception) {
			logger.error("Fail while get view Product details.");
			return ERROR;
		}
	}
	
	
	
	
	/**
	 * <p>
	 * productPrintPDF()
	 * </p>
	 * method to generate the pdf report of lead details from database
	 * 
	 * @return
	 * @throws Exception
	 */
	public String productsPrintPDF() throws Exception {
		
		int productId =LoginUtil.getProcessUserId();
		LoginUtil.setProcessUserId(productId);
		
		productServiceInf.productPDF(request, response, productId);
		return null;
	}
	

	/**
	 * @return the productGlAccountList
	 */
	public Map<Integer, String> getProductGlAccountList() {
		return productGlAccountList;
	}

	/**
	 * @param productGlAccountList the productGlAccountList to set
	 */
	public void setProductGlAccountList(Map<Integer, String> productGlAccountList) {
		this.productGlAccountList = productGlAccountList;
	}
	/**
	 * <p>
	 * <code>deleteProductDetails()</code> method is use to remove the Product
	 * details into databaes.
	 * </p>
	 * 
	 * @return
	 * @throws Exception
	 */
	public String deleteProductDetails() throws Exception {
		
		try {
			
			int productId = Integer.parseInt(request.getParameter("command"));
			productServiceInf.deleteProductDetail(productId);
			return SUCCESS;
		} catch (Exception exception) {
			logger.error("ERROR:Erroe while deleting Product details from database.");
			return ERROR;
		}
	}
	/**
	 * <p>
	 * <code>nextViewProduct()</code> method is use to view the product details into
	 * view product page
	 * </p>
	 * 
	 * @return
	 * @throws Exception
	 */
	public String nextViewProduct() throws Exception {
		int productId = LoginUtil.getProcessUserId();
		this.productVO = VOMapperHelper.getproductFromProduct(productVO,
				productServiceInf.viewNextProductDetails(productId));
		

		if (productVO.getProductId() != 0) {
			logger.info("Product details found successfully for Product Id  "
					+ productVO.getProductId());
			addActionMessage("Product details found successfully for Product Id "
					+ productVO.getProductId());
			return SUCCESS;
		} else {
			productVO.setProductId(LoginUtil.getProcessUserId());
			logger.error("Product details not found for Product Id  "
					+ productVO.getProductId());
			addActionError("Product details not found for Product Id "
					+ productVO.getProductId());
			return ERROR;

		}
	}
	/**
	 * <p>
	 * <code>previousViewProduct()</code> method is use to view the product details into
	 * view product page
	 * </p>
	 * 
	 * @return
	 * @throws Exception
	 */
	public String previousViewProduct() throws OMIApplicationException {
		int productId = LoginUtil.getProcessUserId();
		this.productVO = VOMapperHelper.getproductFromProduct(productVO,
				productServiceInf.viewPreviousProductDetails(productId));
		
		System.out.println("Product id =" + productVO.getProductId());
		if (productVO.getProductId() != 0) {
			logger.info("Product details found successfully for Product Id  "
					+ productVO.getProductId());
			addActionMessage("Product details found successfully for Product Id "
					+ productVO.getProductId());
			return SUCCESS;
		} else if (LoginUtil.getProcessUserId() == -1) {
			LoginUtil.setProcessUserId(productDaoInf.getproductLastRecord() + 1);
			logger.error("Product details not found");
			addActionError("Product details not found");
			return ERROR;
		} else {
			productVO.setProductId(LoginUtil.getProcessUserId());
			logger.error("Product details not found for Product Id  "
					+ productVO.getProductId());
			addActionError("Product details not found for Product Id "
					+ productVO.getProductId());
			return ERROR;

		}

	}
	/**
	 * <p>
	 * <code>editNextProduct()</code> method is use to populate next product details
	 * into edit product page
	 * </p>
	 * 
	 * @return
	 * @throws Exception
	 */
	public String editNextProductDetails() throws Exception {
		int productId = LoginUtil.getProcessUserId();
		this.productVO = VOMapperHelper.getproductFromProduct(productVO,
				productServiceInf.editNextproductDetails(productId));
		if (productVO.getProductId() != 0) {
			logger.info("Product details found successfully for Product Id  "
					+ productVO.getProductId());
			addActionMessage("Product details found successfully for Product Id "
					+ productVO.getProductId());
			return SUCCESS;
		} else {
			productVO.setProductId(LoginUtil.getProcessUserId());
			logger.error("Lead details not found for Product Id  "
					+ productVO.getProductId());
			addActionError("Product details not found for Product Id "
					+ productVO.getProductId());
			return ERROR;

		}
	}
	/**
	 * <p>
	 * <code>previousEditProduct()</code> method is use to view the Product details
	 * into edit Product page
	 * </p>
	 * 
	 * @return
	 * @throws Exception
	 */
	public String previousEditProduct() throws Exception {
		int productId = LoginUtil.getProcessUserId();
		this.productVO = VOMapperHelper.getproductFromProduct(productVO,
				productServiceInf.editPreviousProductDetails(productId));

		if (productVO.getProductId() != 0) {
			logger.info("Product details found successfully for Product Id  "
					+ productVO.getProductId());
			addActionMessage("Product details found successfully for Product Id "
					+ productVO.getProductId());
			return SUCCESS;
		} else if (LoginUtil.getProcessUserId() == -1) {
			LoginUtil.setProcessUserId(productDaoInf.getProductLastRecord() + 1);
			logger.error("Product details not found");
			addActionError("Product details not found");
			return ERROR;
		} else {
			productVO.setProductId(LoginUtil.getProcessUserId());
			logger.error("Product details not found for Product Id  "
					+ productVO.getProductId());
			addActionError("Product details not found for Product Id "
					+ productVO.getProductId());
			return ERROR;

		}

	}
	/**
	 * <p>
	 * excelReportProduct()
	 * </p>
	 * method to generate the Excel Sheet report of product Dashboard from database
	 * 
	 * @return
	 * @throws Exception
	 * @author Roshan Patel
	 * @param request
	 *            ,response
	 */
	public String excelReportProduct() throws Exception {
		productServiceInf.productExcelReport(request, response);
		return NONE;
	}
	@Override
	public void setServletResponse(HttpServletResponse response) {
            this.response=response;
		
	}
	@Override
	public void setServletRequest(HttpServletRequest request) {
		
		this.request=request;
	}
	public HashMap<Integer, String> getItemNameList() {
		return itemNameList;
	}
	public void setItemNameList(HashMap<Integer, String> itemNameList) {
		this.itemNameList = itemNameList;
	}
	public HashMap<Integer, String> getCategoyList() {
		return categoyList;
	}
	public void setCategoyList(HashMap<Integer, String> categoyList) {
		this.categoyList = categoyList;
	}
	

	
}
