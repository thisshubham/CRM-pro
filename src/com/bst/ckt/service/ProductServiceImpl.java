/**
 * 
 */
package com.bst.ckt.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.bst.ckt.common.LoginUtil;
import com.bst.ckt.common.OMIConstants;
import com.bst.ckt.dao.CampaignDaoImpl;
import com.bst.ckt.dao.ExcelReportDaoImpl;
import com.bst.ckt.dao.ExcelReportDaoInf;
import com.bst.ckt.dao.ProductDaoImpl;
import com.bst.ckt.dao.ProductDaoInf;
import com.bst.ckt.dto.Product;
import com.bst.ckt.exception.OMIApplicationException;
import com.bst.ckt.vo.CampaignVO;
import com.bst.ckt.vo.ProductVO;

/**
 * @author Rosu
 * 
 */
public class ProductServiceImpl implements ProductServiceInf {
	/**
	 * Creating Logger object, logger object mapped with ProductServiceImpl class for
	 * writing Loggers.
	 */
	private static final Logger logger = Logger.getLogger(ProductServiceImpl.class);
	
	
	ProductDaoInf productDaoInf = new ProductDaoImpl();
	ProductVO productVO=new ProductVO();
	Product product=null;
	ExcelReportDaoInf excelReportDaoInf = new ExcelReportDaoImpl();
	/**
	 * 
	 * @param productVO
	 * @return
	 */
	/**
	 * TARGET_SUCCESS; TARGET_FAILURE
	 */
	public String insertNewProduct(ProductVO productVO)
			throws OMIApplicationException {
		
		int target =productDaoInf.insertProductDetail(productVO);
		
		if (target == 1) {
			logger.info("Successfully Insert Product !");
			return OMIConstants.TARGET_SUCCESS;

		} else {
			logger.info("Error:while  Inserting  Product into database!");
			return OMIConstants.TARGET_FAILURE;

		}

	}
	
/*
	@Override
	public Product viewProducts(int productId) throws OMIApplicationException {
		try {
			product = productDaoInf.getProductDetails(productId);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return product;

	}
*/

	

	/**
	 * <p>
	 * <code>editProductDetails</code>Method will edit Faq Information data from
	 * TAB_PRODUCT_DETAILS
	 * </p>
	 * 
	 * @return
	 * @throws OMIApplicationException
	 * @param productId
	 */
@Override
	public Product editProductDetails(int productId)
			throws Exception {
		ProductDaoInf productDaoInf = new ProductDaoImpl();
		Product product = new Product();
		try {
			product = productDaoInf.editProductDetail(product,productId);
			
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return product;
	}


	@Override/**
	 * <p>
	 * <code>updateProductDetails</code>Method will Update Product Information data from
	 * TAB_PRODUCT_DETAILS
	 * </p>
	 * 
	 * @return
	 * @throws OMIApplicationException
	 * @param productId
	 */
	public String updateProductDetails(ProductVO productVO, int productId)
			throws Exception {
		ProductDaoInf productDaoInf = new ProductDaoImpl();
		int target=productDaoInf.updateProductDetail(productVO,productId);
		if (target == 1) {
			logger.info("Successfully Update Product Information!");
			return OMIConstants.TARGET_SUCCESS;
		} else {

			logger.info("Error:while  Updating Product Information!");
			return OMIConstants.TARGET_FAILURE;
		}

		
	}
	@Override
	/**
	 * <p>
	 * <code>viewProductDetail()</code>Method will View Product Information data from
	 * TAB_PRODUCT_DETAILS
	 * </p>
	 * 
	 * @return
	 * @throws Exception
	 * @param productId
	 * @author Rosu
	 */
	public Product viewProductDetail(int productId) throws Exception {
		try {
			product=new Product();
			product = productDaoInf.viewProductDetails(productId);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return product;
	}

	/**
	 * <p>
	 * <code>deleteProductDetails(int productId)</code> method will help to
	 * delete product details base on productId.
	 * </p>
	 * * @param (int productId)
	 * 
	 * @throws Exception
	 */
	@Override
	public int deleteProductDetail(int productId)
			throws OMIApplicationException {
		
		int target=productDaoInf.deleteProductDetails(productId);
		return target;
	}
	
	/**
	 * <p>
	 * <code>viewNextProductDetails(int productId)</code> method will help to
	 * view next product details base on productId.
	 * </p>
	 * * @param (int productId)
	 * 
	 * @throws Exception
	 */
	@Override
	public Product viewNextProductDetails(int productId)
			throws OMIApplicationException {
		Product product = null;
		try {
			productId++;
			if (productDaoInf.getproductLastRecord() < productId) {
				productId = 0;
				LoginUtil.setProcessUserId(productId);
				product = new Product();
				product.setProductId(0);
				return product;
			} else {
				LoginUtil.setProcessUserId(productId);
				product = productDaoInf.getProductDetails(productId);
				if (product.getProductId() == 0) {
					productId = LoginUtil.getProcessUserId();
					LoginUtil.setProcessUserId(productId);
					return product;
				}
				product = productDaoInf.getProductDetails(productId);
			}

		} catch (Exception exception) {
			logger.error("no records found" + exception);
		}
		return product;
	}
	/**
	 * <p>
	 * <code>viewPreviousProductDetails(int productId)</code> method will help to
	 * view next product details base on productId.
	 * </p>
	 * * @param (int productId)
	 * 
	 * @throws Exception
	 */
	@Override
	public Product viewPreviousProductDetails(int productId)
			throws OMIApplicationException {
	Product product=null;
		try {
			productId--;
			LoginUtil.setProcessUserId(productId);
			product = productDaoInf.getProductDetails(productId);
			if (product.getProductId() == 0) {
				productId = LoginUtil.getProcessUserId();
				LoginUtil.setProcessUserId(productId);
				return product;
			}
			product = productDaoInf.getProductDetails(productId);

		} catch (Exception exception) {
			logger.error("no records found" + exception);
		}
		return product;
	
	}
	/**
	 * <p>
	 * <code>editNextproductDetails(int productId)</code> method will help to
	 * view next product details base on productId.
	 * </p>
	 * * @param (int productId)
	 * 
	 * @throws Exception
	 */
	@Override
	public Product editNextproductDetails(int productId)
			throws OMIApplicationException {
		Product product = null;
		try {
			productId++;
			if (productDaoInf.getProductLastRecord() < productId) {
				productId = 0;
				LoginUtil.setProcessUserId(productId);
				product = new Product();
				product.setProductId(0);
				return product;
			} else {
				LoginUtil.setProcessUserId(productId);
				product = productDaoInf.getProductDetailsForUpdate(productId);
				if (product.getProductId() == 0) {
					productId = LoginUtil.getProcessUserId();
					LoginUtil.setProcessUserId(productId);
					return product;
				}
				product = productDaoInf.getProductDetailsForUpdate(productId);
			}

		} catch (Exception exception) {
			logger.error("no records found" + exception);
		}
		return product;
	}
	/**
	 * <p>
	 * <code>editPreviousProductDetails(int productId)</code> method will help to
	 * view previous product details base on productId.
	 * </p>
	 * * @param (int productId)
	 * 
	 * @throws Exception
	 */
	@Override
	public Product editPreviousProductDetails(int productId)
			throws OMIApplicationException {
		Product product = null;
		try {
			productId--;
			LoginUtil.setProcessUserId(productId);
			product = productDaoInf.getProductDetailsForUpdate(productId);
			if (product.getProductId() == 0) {
				productId = LoginUtil.getProcessUserId();
				LoginUtil.setProcessUserId(productId);
				return product;
			}
			product = productDaoInf.getProductDetailsForUpdate(productId);

		} catch (Exception exception) {
			logger.error("no records found" + exception);
		}
		return product;
	}
	
	
	/**
	 * <p>
	 * <code>retriveProductDetailsGrid(int productId)</code> method will help to
	 * view previous product details base on productId.
	 * </p>
	 * * @param (int productId)
	 * 
	 * @throws Exception
	 */
	@Override
	public List<ProductVO> retriveProductDetailsGrid(ProductVO productVO)
			throws Exception {
		
		productDaoInf = new ProductDaoImpl();
		int searchId = productVO.getSearchId();
		String searchValue = ""	;
		
		if (searchId == 1) {
			searchValue = String.valueOf(productVO.getProductId());
			
		} else if (searchId == 2) {
			searchValue = String.valueOf(productVO.getProductName());
			
			
		} else if (searchId == 3) {
			searchValue = String.valueOf(productVO.getProductStatus());
		} else if (searchId == 4) {
			searchValue = String.valueOf(productVO.getProductCategory());
		} else if (searchId == 5) {
			searchValue = String.valueOf(productVO.getSalesStartDate());
		} else if (searchId == 6) {
			searchValue = productVO.getSalesEndDate();
		} 
		return  productDaoInf.getProductDetails(searchId, searchValue);

	}
	/**
	 * <p>
	 * <code>productExcelReport((HttpServletRequest request,
			HttpServletResponse response)</code> method will help to
	 * view Excel report product details base on productId.
	 * </p>
	 * * @param (HttpServletRequest request,
			HttpServletResponse response)
	 * 
	 * @throws Exception
	 */
	@Override
	public void productExcelReport(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		excelReportDaoInf.retriveProductExcelReport(request, response);
		
	}
	
	
	
	/**
	 * <p>
	 * <code>productPDF((HttpServletRequest request,
			HttpServletResponse response)</code> method will help to
	 * view PDF report product details base on productId.
	 * </p>
	 * * @param (HttpServletRequest request,
			HttpServletResponse response)
	 * 
	 * @throws Exception
	 */
	@Override
	public void productPDF(HttpServletRequest request,
			HttpServletResponse response, int productId)throws Exception {
		productDaoInf.productPDF(request, response, productId);
		
	}
	
	
	

	
}
