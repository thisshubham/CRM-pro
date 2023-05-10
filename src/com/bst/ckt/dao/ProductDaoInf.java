/**
 * 
 */
package com.bst.ckt.dao;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bst.ckt.dto.Product;
import com.bst.ckt.exception.OMIApplicationException;
import com.bst.ckt.exception.RecordNotFoundException;
import com.bst.ckt.vo.ProductVO;

/**
 * @author Rosu
 *
 */
public interface ProductDaoInf {
	/**
	 * <P>
	 * <CODE>insertProductDetail()</CODE> METHOD IS USE TO INSERT PRODUCT DETAILS INTO
	 * DATABASE
	 * </P>
	 * 
	 * @param productVO
	 * @return
	 * @throws Exception
	 */

	public int insertProductDetail(ProductVO productVO)throws OMIApplicationException ;

	/**
	 * <P>
	 * <CODE>showProductDetail()</CODE> METHOD IS USE TO FATCH PRODUCT DETAILS FROM
	 * DATABASE
	 * </P>
	 * 
	 * @return
	 * @throws Exception
	 */
	
	public List<ProductVO> showProductDetail()throws OMIApplicationException;

	

	

	/**<P>
	 * <CODE> editProductDetail()</CODE> METHOD IS USE TO EDIT PRODUCT DETAILS INTO
	 * DATABASE
	 * </P>
	 * @param productId
	 * @return
	 * @throws Exception
	 */

	

	public Product editProductDetail(Product product, int productId)throws Exception;
	/**<P>
	 * <CODE>updateProductDetail()</CODE> METHOD IS USE TO UPDATE PRODUCT DETAILS INTO
	 * DATABASE
	 * </P>
	 * @param productId
	 * @return
	 * @throws Exception
	 */
	

	public int updateProductDetail(ProductVO productVO, int productId)throws Exception;
	/**<P>
	 * <CODE>viewProductDetail()</CODE> METHOD IS USE TO VIEW PRODUCT DETAILS INTO
	 * DATABASE
	 * </P>
	 * @param productId
	 * @return
	 * @throws Exception
	 */
	public Product viewProductDetails(int productId)throws Exception;
	/**<P>
	 * <CODE>deleteProductDetail()</CODE> METHOD IS USE TO DELETE PRODUCT DETAILS INTO
	 * DATABASE
	 * </P>
	 * @param productId
	 * @return
	 * @throws Exception
	 */
	public int deleteProductDetails(int productId)throws OMIApplicationException;
	/**<P>
	 * <CODE>getproductLastRecord()</CODE> METHOD IS USE TO NEXT PRODUCT DETAILS INTO
	 * DATABASE
	 * </P>
	 * @param productId
	 * @return
	 * @throws Exception
	 */
	public int getproductLastRecord()throws OMIApplicationException;
	/**<P>
	 * <CODE>getProductDetails()</CODE> METHOD IS USE TO NEXT PRODUCT DETAILS INTO
	 * DATABASE
	 * </P>
	 * @param productId
	 * @return
	 * @throws Exception
	 */
	public Product getProductDetails(int productId)throws OMIApplicationException;  
	/**<P>
	 * <CODE>getProductLastRecord()</CODE> METHOD IS USE TO NEXT PRODUCT DETAILS INTO
	 * DATABASE
	 * </P>
	 * @param productId
	 * @return
	 * @throws Exception
	 */
	public int getProductLastRecord()throws OMIApplicationException;
	/**<P>
	 * <CODE>getProductDetailsForUpdate()</CODE> METHOD IS USE TO NEXT PRODUCT DETAILS INTO
	 * DATABASE
	 * </P>
	 * @param productId
	 * @return
	 * @throws Exception
	 */
	public Product getProductDetailsForUpdate(int productId)throws OMIApplicationException;

	/**<P>
	 * <CODE>getProductDetailsForUpdate()</CODE> METHOD IS USE TO NEXT PRODUCT DETAILS INTO
	 * DATABASE
	 * </P>
	 * @param productId
	 * @return
	 * @throws Exception
	 */
	public List<ProductVO> getProductDetails(int searchId, String searchValue)throws Exception;
	/**<P>
	 * <CODE>getProductNameList()</CODE> METHOD IS USE TO NEXT PRODUCT DETAILS INTO
	 * DATABASE
	 * </P>
	 * @param productId
	 * @return
	 * @throws Exception
	 */
	public HashMap<String, String> getProductNameList()throws Exception;
	
	
	/**
	 * <P>
	 * <CODE>productPDF()</CODE> METHOD IS USE TO GENERATE PDF PRODUCT REPORT FROM
	 * DATABASE
	 * </P>
	 * 
	 * @param request
	 * @param response
	 * @param leadId
	 */
	public void productPDF(HttpServletRequest request,
			HttpServletResponse response, int productId)throws Exception;

	public int checkCategoryAvailability(String category) throws RecordNotFoundException;
	
	
	
	

}
