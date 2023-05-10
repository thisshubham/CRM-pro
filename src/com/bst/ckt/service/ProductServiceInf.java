/**
 * 
 */
package com.bst.ckt.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bst.ckt.dto.Product;
import com.bst.ckt.exception.OMIApplicationException;
import com.bst.ckt.vo.ProductVO;

/**
 * @author Roshan Patel
 *
 */
public interface ProductServiceInf  {
	
	ProductVO productVO=new ProductVO();
	/**
	 * <p>
	 * <code>insertNewProduct</code>this method is use to insert Product detail
	 * into database
	 * </p>
	 * 
	 * @param productVO
	 * @throws Exception
	 */

	String insertNewProduct(ProductVO productVO)throws OMIApplicationException ;
	
	/**
	 * <p>
	 * <code>editProductDetails</code>this method is use to insert Product detail
	 * into database
	 * </p>
	 * 
	 * @param productVO
	 * @throws Exception
	 */
	public Product editProductDetails(int productId)throws Exception;
	/**
	 * <p>
	 * <code>updateProductDetails</code>this method is use to update Product detail
	 * into database
	 * </p>
	 * 
	 * @param productVO
	 * @throws Exception
	 */
	public String updateProductDetails(ProductVO productVO, int productId)throws Exception ;
	/**
	 * <p>
	 * <code>viewProductDetails</code>this method is use to update Product detail
	 * into database
	 * </p>
	 * 
	 * @param productVO
	 * @throws Exception
	 * @author Rosu Patel
	 */
	
	public Product viewProductDetail(int productId)throws Exception;
	/**
	 * <p>
	 * <code>deleteProductDetail</code>this method is use to delete Product detail
	 * into database
	 * </p>
	 * 
	 * @param productId
	 * @throws Exception
	 * @author Rosu Patel
	 */
	public int deleteProductDetail(int productId)throws OMIApplicationException;

	/**
	 * <p>
	 * <code>viewNextProductDetails</code>this method is use to next Product detail
	 * into database
	 * </p>
	 * 
	 * @param productId
	 * @throws Exception
	 * @author Rosu Patel
	 */
	public Product viewNextProductDetails(int productId)throws OMIApplicationException;
	/**
	 * <p>
	 * <code>viewPreviousProductDetails</code>this method is use to next Product detail
	 * into database
	 * </p>
	 * 
	 * @param productId
	 * @throws Exception
	 * @author Rosu Patel
	 */
	public Product viewPreviousProductDetails(int productId)throws OMIApplicationException;
	/**
	 * <p>
	 * <code>editNextproductDetails</code>this method is use to next Product detail
	 * into database
	 * </p>
	 * 
	 * @param productId
	 * @throws Exception
	 * @author Rosu Patel
	 */
	public Product editNextproductDetails(int productId)throws OMIApplicationException;
	/**
	 * <p>
	 * <code>editPreviousProductDetails</code>this method is use to next Product detail
	 * into database
	 * </p>
	 * 
	 * @param productId
	 * @throws Exception
	 * @author Rosu Patel
	 */
	public Product editPreviousProductDetails(int productId)throws OMIApplicationException;

	/**
	 * <p>
	 * <code>retriveProductDetailsGrid</code>this method is use to view Product detail
	 * into database
	 * </p>
	 * 
	 * @param productId
	 * @throws Exception
	 * @author Rosu Patel
	 */
	List<ProductVO> retriveProductDetailsGrid(ProductVO productVO)throws Exception;



	/**
	 * <p>
	 * <code>productExcelReport</code>this method is use to view Product Report detail
	 * into database
	 * </p>
	 * 
	 * @param request,response
	 * @throws Exception
	 * @author Rosu Patel
	 */
	void productExcelReport(HttpServletRequest request,
			HttpServletResponse response)throws Exception;
	
	
	
	/**
	 * <p>
	 * <code>productPDF</code>this method is use to view Product Report detail
	 * into database
	 * </p>
	 * 
	 * @param request,response
	 * @throws Exception
	 * @author Rosu Patel
	 */
	void productPDF(HttpServletRequest request, HttpServletResponse response,
			int productId)throws Exception;





	



}
