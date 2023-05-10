/**
 * 
 */
package com.bst.ckt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;


import com.bst.ckt.common.QueryBuilder;
import com.bst.ckt.common.QueryMaker;
import com.bst.ckt.dto.Product;
import com.bst.ckt.exception.OMIApplicationException;
import com.bst.ckt.exception.RecordNotFoundException;
import com.bst.ckt.framework.db.JdbcDAOSupport;
import com.bst.ckt.framework.db.JdbcHelper;
import com.bst.ckt.framework.util.DateTimeUtil;
import com.bst.ckt.helper.NameHelper;
import com.bst.ckt.vo.ProductVO;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * @author Roshan Patel
 * 
 */

public class ProductDaoImpl extends JdbcDAOSupport implements ProductDaoInf {

	/**
	 * Creating Logger object, logger object mapped with ProductDaoImpl class
	 * for writing Loggers.
	 */
	private static final Logger logger = Logger.getLogger(ProductDaoImpl.class);
	ProductVO productVO = new ProductVO();
	Product product = null;
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	Image image=null;
	NameHelper nameHelper = new NameHelper();

	@Override
	/**
	 * <p>
	 * <code>insertProductDetail(productVO)</code> method use to insert product details
	 * into INSERT_PRODUCT_DETAIL table.
	 * </p>
	 * 
	 * @param productVO
	 * @return target
	 * @throws Exception
	 */
	public int insertProductDetail(ProductVO productVO)
			throws OMIApplicationException {
		String insertProductQuery = QueryMaker.INSERT_PRODUCT_DETAIL;
		int target = 0;
		try {
			
			
			System.out.println(productVO.getProductCategory()+"jdjdjdjddjdj"+productVO.getProductName());
			connection = getConnection();
			preparedStatement = connection.prepareStatement(insertProductQuery);

			preparedStatement.setString(1, productVO.getProductName());
			preparedStatement.setString(2, productVO.getProductCode());
			preparedStatement.setString(3, productVO.getProductCategory());
			preparedStatement.setString(4, productVO.getVenderName());
			preparedStatement.setString(5, productVO.getManufacturer());
			preparedStatement.setString(6, productVO.getSalesStartDate());

			preparedStatement.setString(7, productVO.getSalesEndDate());
			preparedStatement.setString(8, productVO.getSupportStartDate());
			preparedStatement.setString(9, productVO.getSupportExpiryDate());
			preparedStatement.setString(10, productVO.getSerialNo());
			preparedStatement.setString(11, productVO.getMrfPartNo());
			preparedStatement.setString(12, productVO.getVendorPartNo());
			preparedStatement.setString(13, productVO.getProductSheet());
			preparedStatement.setString(14, productVO.getWebsite());
			preparedStatement.setString(15, productVO.getGlAccount());
			preparedStatement.setFloat(16, productVO.getUnitPrice());
			preparedStatement.setFloat(17, productVO.getCommisionRate());
			preparedStatement.setString(18, productVO.getTax());
			preparedStatement.setFloat(19, productVO.getPurchaseCost());
			preparedStatement.setString(20, productVO.getUsageUnit());
			preparedStatement.setInt(21, productVO.getQtyPerUnit());
			preparedStatement.setInt(22, productVO.getQtyInStock());
			preparedStatement.setString(23, productVO.getReorderLevel());
			preparedStatement.setString(24, productVO.getHandler());
			preparedStatement.setInt(25, productVO.getQtyInDemand());

			preparedStatement.setString(26, productVO.getProductImage());
			preparedStatement.setString(27, productVO.getDescription());
			preparedStatement.setInt(28, productVO.getCreatedBy());
			preparedStatement.setString(29, DateTimeUtil.getCurrentDate());
			preparedStatement.setString(30, productVO.getProductActive());

			preparedStatement.executeUpdate();

			target = 1;

		} catch (SQLException sqlException) {

			logger.error(
					ProductDaoImpl.class
							+ "Error: Occur in Query While Inserting the Product Details into Database.",
					sqlException);

		} catch (Exception exception) {

			exception.printStackTrace();
			logger.error(
					ProductDaoImpl.class
							+ "Error: Occur While Closing Connection After Inserting the Product Details into Database.",
					exception);
		} finally {
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return target;
	}

	@Override
	/**
	 * <p>
	 * <code>showProductDetail()</code> method use to fetch product grid into
	 * SHOW_PRODUCT_DETAIL table.
	 * </p>
	 * 
	 * @param productVO
	 * 
	 * @return productList
	 */
	public List<ProductVO> showProductDetail() throws OMIApplicationException {
		List<ProductVO> productList = new ArrayList<ProductVO>();
		String showProductQuery = QueryMaker.SHOW_PRODUCT_DETAIL;
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(showProductQuery);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				productVO = new ProductVO();
				productVO.setProductId(resultSet.getInt("PRODUCT_ID"));
	
				productVO.setProductName(nameHelper.getProductTypeNameByProductId(resultSet.getInt("PRODUCT_NAME")));
				//PRODUCT_CATEGORY
				productVO.setProductCode(resultSet.getString("PRODUCT_CODE"));

				productVO.setUnitPrice(resultSet.getFloat("UNIT_PRICE"));
				productVO.setQtyInStock(resultSet.getInt("QTY_IN_STOCK"));

				productList.add(productVO);

			}

		} catch (SQLException sqlExp) {
			sqlExp.printStackTrace();
			logger.error(
					ProductDaoImpl.class
							+ "Error: Occur in Query While Fetching  Product Detail from Database.",
					sqlExp);
		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					ProductDaoImpl.class
							+ "Error: Occur in Query While Closing Connection After Fetching Product Detail from Database.",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}

		return productList;
	}

	/**
	 * <p>
	 * <code>editFaqDetail</code>Method will edit Faq Detail data from based
	 * supportId
	 * </p>
	 * 
	 * @return product
	 * @throws OMIApplicationException
	 * @param (int supportId)
	 */
	public Product editProductDetail(Product product, int productId)
			throws Exception {

		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_PRODUCT_DETAIL_EDIT);
			preparedStatement.setInt(1, productId);
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {

					product.setProductId(resultSet.getInt("PRODUCT_ID"));
					product.setProductName(resultSet.getString("PRODUCT_NAME"));

					product.setProductCode(resultSet.getString("PRODUCT_CODE"));
					product.setProductCategory(resultSet
							.getString("PRODUCT_CATEGORY"));
					product.setVenderName(nameHelper.getVendorName(resultSet
							.getInt("VENDOR_NAME")));
					product.setManufacturer(resultSet.getString("MANUFACTURER"));
					product.setSalesStartDate(resultSet
							.getString("SALES_START_DATE"));
					product.setSalesEndDate(resultSet
							.getString("SALES_END_DATE"));
					product.setSupportStartDate(resultSet
							.getString("SUPPORT_START_DATE"));
					product.setSupportExpiryDate(resultSet
							.getString("SUPPORT_EXPIRY_DATE"));
					product.setSerialNo(resultSet.getString("SERIAL_NO"));
					product.setMrfPartNo(resultSet.getString("MFR_PART_NO"));
					product.setVendorPartNo(resultSet
							.getString("VENDOR_PART_NO"));
					product.setProductSheet(resultSet
							.getString("PRODUCT_SHEET"));
					product.setWebsite(resultSet.getString("WEBSITE"));
					product.setGlAccount(resultSet.getString("GL_ACCOUNT"));
					product.setUnitPrice(resultSet.getFloat("UNIT_PRICE"));
					product.setCommisionRate(resultSet
							.getFloat("COMMISION_RATE"));
					product.setTax(resultSet.getString("TAX"));
					product.setPurchaseCost(resultSet.getFloat("PURCHASE_COST"));
					product.setUsageUnit(resultSet.getString("USAGE_UNIT"));
					product.setQtyPerUnit(resultSet.getInt("QTY_PER_UNIT"));
					product.setQtyInStock(resultSet.getInt("QTY_IN_STOCK"));
					product.setReorderLevel(resultSet
							.getString("REORDER_LAVEL"));
					product.setHandler(resultSet.getString("HANDLER"));
					product.setQtyInDemand(resultSet.getInt("QTY_IN_DEMAND"));
					
					  product.setProductActive(resultSet
					  .getString("PRODUCT_ACTIVE"));
					 
					product.setProductImage(resultSet
							.getString("PRODUCT_IMAGE"));
					product.setDescription(resultSet.getString("DESCRIPTION"));

				}

			}
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					ProductDaoImpl.class
							+ ": Error:- Error: Occur in Query While fetching the Product details from Database",
					sqlException);

		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					ProductDaoImpl.class
							+ ": Error:- While closing the Connection after fetching the product details from Database",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}

		return product;
	}

	/**
	 * <p>
	 * <code>updateProductDetail</code>Method will Update Faq Detail data from
	 * based supportId
	 * </p>
	 * 
	 * @return target
	 * @throws OMIApplicationException
	 * @param (ProductVO productVO, int productId)
	 */
	@Override
	public int updateProductDetail(ProductVO productVO, int productId)
			throws Exception {
		int target = 0;

		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.UPDATE_PRODUCT_DETAIL);
			preparedStatement.setString(1, productVO.getProductName());
			preparedStatement.setString(2, productVO.getProductCode());
			preparedStatement.setString(3, productVO.getProductCategory());
			preparedStatement.setString(4, productVO.getVenderName());

			preparedStatement.setString(5, productVO.getManufacturer());

			preparedStatement.setString(6, productVO.getSalesStartDate());

			preparedStatement.setString(7, productVO.getSalesEndDate());

			preparedStatement.setString(8, productVO.getSupportStartDate());
			preparedStatement.setString(9, productVO.getSupportExpiryDate());
			preparedStatement.setString(10, productVO.getSerialNo());
			preparedStatement.setString(11, productVO.getMrfPartNo());
			preparedStatement.setString(12, productVO.getVendorPartNo());
			preparedStatement.setString(13, productVO.getProductSheet());
			preparedStatement.setString(14, productVO.getWebsite());
			preparedStatement.setString(15, productVO.getGlAccount());
			preparedStatement.setFloat(16, productVO.getUnitPrice());
			preparedStatement.setFloat(17, productVO.getCommisionRate());
			preparedStatement.setString(18, productVO.getTax());
			preparedStatement.setFloat(19, productVO.getPurchaseCost());
			preparedStatement.setString(20, productVO.getUsageUnit());
			preparedStatement.setInt(21, productVO.getQtyPerUnit());
			preparedStatement.setInt(22, productVO.getQtyInStock());
			preparedStatement.setString(23, productVO.getReorderLevel());
			preparedStatement.setString(24, productVO.getHandler());
			preparedStatement.setInt(25, productVO.getQtyInDemand());

			preparedStatement.setString(26, productVO.getProductImage());
			preparedStatement.setString(27, productVO.getDescription());
			preparedStatement.setInt(28, productVO.getUpdatedBy());
			preparedStatement.setString(29, DateTimeUtil.getCurrentDate());
			preparedStatement.setString(30, productVO.getProductActive());
			preparedStatement.setInt(31, productId);

			preparedStatement.executeUpdate();
			target = 1;

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					ProductDaoImpl.class
							+ ": Error:- Error: Occur in Query While updating the PRODUCT details into Database",
					sqlException);

		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					ProductDaoImpl.class
							+ ": Error:- While closing the Connection after updating the PRODUCT social details into Database",
					exception);
		} finally {
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return target;
	}

	@Override
	public Product viewProductDetails(int productId) throws Exception {
		product = new Product();

		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.SHOW_VIEW_PRODUCT_DETAIL);
			preparedStatement.setInt(1, productId);
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {

					product.setProductId(resultSet.getInt("PRODUCT_ID"));
					product.setProductName(nameHelper.getProductTypeNameByProductId(resultSet.getInt("PRODUCT_NAME")));
					product.setProductCode(resultSet.getString("PRODUCT_CODE"));
					product.setProductCategory(nameHelper.getProductCategory(resultSet.getInt("PRODUCT_CATEGORY")));
					product.setVenderName(nameHelper.getVendorName(resultSet
							.getInt("VENDOR_NAME")));
					product.setManufacturer(nameHelper
							.getManufacturer(resultSet.getInt("MANUFACTURER")));
					product.setSalesStartDate(resultSet
							.getString("SALES_START_DATE"));
					product.setSalesEndDate(resultSet
							.getString("SALES_END_DATE"));
					product.setSupportStartDate(resultSet
							.getString("SUPPORT_START_DATE"));
					product.setSupportExpiryDate(resultSet
							.getString("SUPPORT_EXPIRY_DATE"));
					product.setSerialNo(resultSet.getString("SERIAL_NO"));
					product.setMrfPartNo(resultSet.getString("MFR_PART_NO"));
					product.setVendorPartNo(resultSet
							.getString("VENDOR_PART_NO"));
					product.setProductSheet(resultSet
							.getString("PRODUCT_SHEET"));
					product.setWebsite(resultSet.getString("WEBSITE"));
					product.setGlAccount(nameHelper.getGlAccount(resultSet
							.getInt("GL_ACCOUNT")));
					product.setUnitPrice(resultSet.getFloat("UNIT_PRICE"));
					product.setCommisionRate(resultSet
							.getFloat("COMMISION_RATE"));
					product.setTax(nameHelper.getTax(resultSet.getInt("TAX")));
					product.setPurchaseCost(resultSet.getFloat("PURCHASE_COST"));
					product.setUsageUnit(resultSet.getString("USAGE_UNIT"));
					product.setQtyPerUnit(resultSet.getInt("QTY_PER_UNIT"));
					product.setQtyInStock(resultSet.getInt("QTY_IN_STOCK"));
					product.setReorderLevel(resultSet
							.getString("REORDER_LAVEL"));
					product.setHandler(nameHelper.getHandler(resultSet
							.getInt("HANDLER")));

					product.setQtyInDemand(resultSet.getInt("QTY_IN_DEMAND"));

					product.setProductActive(resultSet
							.getString("PRODUCT_ACTIVE"));

					product.setProductImage(resultSet
							.getString("PRODUCT_IMAGE"));
					product.setDescription(resultSet.getString("DESCRIPTION"));
					product.setCreatedBy(resultSet.getInt("CREATED_BY"));
					product.setCreationDate(DateTimeUtil
							.convertDatetoFormDateForView(resultSet
									.getString("CREATION_DATE")));
					product.setUpdatedBy(resultSet.getInt("UPDATED_BY"));
					product.setUpdationDate(DateTimeUtil
							.convertDatetoFormDateForView(resultSet
									.getString("UPDATION_DATE")));
				}
			}
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					ProductDaoImpl.class
							+ ": Error:- Error: Occur in Query While fetching the Product details for view from Database",
					sqlException);

		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					ProductDaoImpl.class
							+ ": Error:- While closing the Connection after fetching the Product details for view from Database",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return product;
	}

	/**
	 * @author Roshan Patel
	 *         <p>
	 *         <code>deleteProductDetails(int productId)</code> method help to
	 *         delete product details in database.
	 *         </p>
	 * 
	 * @param productId
	 *            int
	 * 
	 * 
	 * @throws Exception
	 */
	@Override
	public int deleteProductDetails(int productId)
			throws OMIApplicationException {
		int target = 0;
		String query = QueryMaker.DELETE_PRODUCT_DETAILS;
		try {

			connection = getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, productId);
			preparedStatement.executeUpdate();
			target = 1;

		} catch (Exception exception) {
			logger.error(ProductDaoImpl.class
					+ ": Error:- While deleting Product details from Database.");
		} finally {
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);

		}
		return target;
	}

	
	/**
	 * @author Roshan Patel
	 *         <p>
	 *         <code>getproductLastRecord(int productId)</code> method help to
	 *         next view last product details in database.
	 *         </p>
	 * 
	 * @param productId
	 *            int
	 * 
	 * 
	 * @throws Exception
	 */
	@Override
	public int getproductLastRecord() throws OMIApplicationException {
		int target = 0;
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_LAST_PRODUCT_ID);
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {

					target = resultSet.getInt("PRODUCT_ID");

				}
			}
		} catch (SQLException sqlException) {

			logger.error(
					ProductDaoImpl.class
							+ ": Error:- Error: Occur in Query While counting the product recodes from Database",
					sqlException);

		} catch (Exception exception) {

			logger.error(
					ProductDaoImpl.class
							+ ": Error:- While closing the Connection after counting the product recodes from Database",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return target;

	

	}
	/**
	 * @author Roshan Patel
	 *         <p>
	 *         <code>getProductDetails(int productId)</code> method help to
	 *         next view  product details in database.
	 *         </p>
	 * 
	 * @param productId
	 *            int
	 * 
	 * 
	 * @throws Exception
	 */
	@Override
	public Product getProductDetails(int productId)
			throws OMIApplicationException {
		
		Product product = new Product();
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.SHOW_NEXT_VIEW_PRODUCT);
			preparedStatement.setInt(1, productId);
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {
					product.setProductId(resultSet.getInt("PRODUCT_ID"));
					product.setProductName(resultSet.getString("PRODUCT_NAME"));
					product.setProductCode(resultSet.getString("PRODUCT_CODE"));
					product.setProductCategory(nameHelper
							.getProductCategory(resultSet
									.getInt("PRODUCT_CATEGORY")));
					product.setVenderName(nameHelper.getVendorName(resultSet
							.getInt("VENDOR_NAME")));
					product.setManufacturer(nameHelper
							.getManufacturer(resultSet.getInt("MANUFACTURER")));
					product.setSalesStartDate(resultSet
							.getString("SALES_START_DATE"));
					product.setSalesEndDate(resultSet
							.getString("SALES_END_DATE"));
					product.setSupportStartDate(resultSet
							.getString("SUPPORT_START_DATE"));
					product.setSupportExpiryDate(resultSet
							.getString("SUPPORT_EXPIRY_DATE"));
					product.setSerialNo(resultSet.getString("SERIAL_NO"));
					product.setMrfPartNo(resultSet.getString("MFR_PART_NO"));
					product.setVendorPartNo(resultSet
							.getString("VENDOR_PART_NO"));
					product.setProductSheet(resultSet
							.getString("PRODUCT_SHEET"));
					product.setWebsite(resultSet.getString("WEBSITE"));
					product.setGlAccount(nameHelper.getGlAccount(resultSet
							.getInt("GL_ACCOUNT")));
					product.setUnitPrice(resultSet.getFloat("UNIT_PRICE"));
					product.setCommisionRate(resultSet
							.getFloat("COMMISION_RATE"));
					product.setTax(nameHelper.getTax(resultSet.getInt("TAX")));
					product.setPurchaseCost(resultSet.getFloat("PURCHASE_COST"));
					product.setUsageUnit(resultSet.getString("USAGE_UNIT"));
					product.setQtyPerUnit(resultSet.getInt("QTY_PER_UNIT"));
					product.setQtyInStock(resultSet.getInt("QTY_IN_STOCK"));
					product.setReorderLevel(resultSet
							.getString("REORDER_LAVEL"));
					product.setHandler(nameHelper.getHandler(resultSet
							.getInt("HANDLER")));

					product.setQtyInDemand(resultSet.getInt("QTY_IN_DEMAND"));

					product.setProductActive(resultSet
							.getString("PRODUCT_ACTIVE"));

					product.setProductImage(resultSet
							.getString("PRODUCT_IMAGE"));
					product.setDescription(resultSet.getString("DESCRIPTION"));
					product.setCreatedBy(resultSet.getInt("CREATED_BY"));
					product.setCreationDate(DateTimeUtil
							.convertDatetoFormDateForView(resultSet
									.getString("CREATION_DATE")));
					product.setUpdatedBy(resultSet.getInt("UPDATED_BY"));
					product.setUpdationDate(DateTimeUtil
							.convertDatetoFormDateForView(resultSet
									.getString("UPDATION_DATE")));

				}
			}
		} catch (SQLException sqlException) {

			logger.error(
					ProductDaoImpl.class
							+ ": Error:- Error: Occur in Query While fetching the Product details for view from Database",
					sqlException);

		} catch (Exception exception) {

			logger.error(
					ProductDaoImpl.class
							+ ": Error:- While closing the Connection after fetching the Product details for view from Database",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return product;
	}
	/**
	 * @author Roshan Patel
	 *         <p>
	 *         <code>getProductLastRecord(int productId)</code> method help to
	 *         next edit  product details in database.
	 *         </p>
	 * 
	 * @param productId
	 *            int
	 * 
	 * 
	 * @throws Exception
	 */
	@Override
	public int getProductLastRecord() throws OMIApplicationException {
		int temp = 0;
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_LAST_RECORD_PRODUCT_ID);
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {

					temp = resultSet.getInt("PRODUCT_ID");

				}
			}
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					ProductDaoImpl.class
							+ ": Error:- Error: Occur in Query While counting the Product recodes from Database",
					sqlException);

		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					ProductDaoImpl.class
							+ ": Error:- While closing the Connection after counting the Product recodes from Database",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return temp;
	}
	/**
	 * @author Roshan Patel
	 *         <p>
	 *         <code>getProductDetailsForUpdate(int productId)</code> method help to
	 *         next edit  product details in database.
	 *         </p>
	 * 
	 * @param productId
	 *            int
	 * 
	 * 
	 * @throws Exception
	 */
	@Override
	public Product getProductDetailsForUpdate(int productId)
			throws OMIApplicationException {
		
		product = new Product();
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.SHOW_EDIT_PRODUCT_NEXT);
			preparedStatement.setInt(1, productId);
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {
					product.setProductId(resultSet.getInt("PRODUCT_ID"));
					product.setProductName(resultSet.getString("PRODUCT_NAME"));

					product.setProductCode(resultSet.getString("PRODUCT_CODE"));
					product.setProductCategory(resultSet
							.getString("PRODUCT_CATEGORY"));
					product.setVenderName(nameHelper.getVendorName(resultSet
							.getInt("VENDOR_NAME")));
					product.setManufacturer(resultSet.getString("MANUFACTURER"));
					product.setSalesStartDate(resultSet
							.getString("SALES_START_DATE"));
					product.setSalesEndDate(resultSet
							.getString("SALES_END_DATE"));
					product.setSupportStartDate(resultSet
							.getString("SUPPORT_START_DATE"));
					product.setSupportExpiryDate(resultSet
							.getString("SUPPORT_EXPIRY_DATE"));
					product.setSerialNo(resultSet.getString("SERIAL_NO"));
					product.setMrfPartNo(resultSet.getString("MFR_PART_NO"));
					product.setVendorPartNo(resultSet
							.getString("VENDOR_PART_NO"));
					product.setProductSheet(resultSet
							.getString("PRODUCT_SHEET"));
					product.setWebsite(resultSet.getString("WEBSITE"));
					product.setGlAccount(resultSet.getString("GL_ACCOUNT"));
					product.setUnitPrice(resultSet.getFloat("UNIT_PRICE"));
					product.setCommisionRate(resultSet
							.getFloat("COMMISION_RATE"));
					product.setTax(resultSet.getString("TAX"));
					product.setPurchaseCost(resultSet.getFloat("PURCHASE_COST"));
					product.setUsageUnit(resultSet.getString("USAGE_UNIT"));
					product.setQtyPerUnit(resultSet.getInt("QTY_PER_UNIT"));
					product.setQtyInStock(resultSet.getInt("QTY_IN_STOCK"));
					product.setReorderLevel(resultSet
							.getString("REORDER_LAVEL"));
					product.setHandler(resultSet.getString("HANDLER"));
					product.setQtyInDemand(resultSet.getInt("QTY_IN_DEMAND"));
					
					  product.setProductActive(resultSet
					  .getString("PRODUCT_ACTIVE"));
					 
					product.setProductImage(resultSet
							.getString("PRODUCT_IMAGE"));
					product.setDescription(resultSet.getString("DESCRIPTION"));

				}
			}
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					ProductDaoImpl.class
							+ ": Error:- Error: Occur in Query While fetching the Product details for view from Database",
					sqlException);

		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					ProductDaoImpl.class
							+ ": Error:- While closing the Connection after fetching the Product details for view from Database",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return product;
	}
	
	
	
	/**
	 * @author Roshan Patel
	 *         <p>
	 *         <code>getProductDetails(int searchId, String searchValue)</code>
	 *         method help to view product details in database.
	 *         </p>
	 * 
	 * @param productId
	 *            int
	 * 
	 * 
	 * @throws Exception
	 */
	@Override
	public List<ProductVO> getProductDetails(int searchId, String searchValue)
			throws Exception {
		List<ProductVO> productDetailsList = new ArrayList<ProductVO>();

		try {

			connection = getConnection();
			preparedStatement = connection.prepareStatement(QueryBuilder.advanceProductSerach(searchId, searchValue));
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				productVO = new ProductVO();
				productVO.setProductId(resultSet.getInt("PRODUCT_ID"));

				productVO.setProductName(resultSet.getString("PRODUCT_NAME"));
				System.out.println("******************************"
						+ resultSet.getString("PRODUCT_NAME"));

				productVO.setProductCategory(nameHelper
						.getProductCategory(resultSet
								.getInt("PRODUCT_CATEGORY")));

				productVO.setSalesStartDate(resultSet
						.getString("SALES_START_DATE"));
				productVO
						.setSalesEndDate(resultSet.getString("SALES_END_DATE"));

				productDetailsList.add(productVO);
			}

		} catch (SQLException sqlExp) {
			sqlExp.printStackTrace();
			logger.error(
					ProductDaoImpl.class
							+ "Error: Occur in Query While Fetching the Product Details into Grid from Database.",
					sqlExp);
		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					ProductDaoImpl.class
							+ "Error: Occur in Query While Closing Connection After Fetching the Product Details into Grid from Database.",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return productDetailsList;
	}
	/**
	 * @author Roshan Patel
	 *         <p>
	 *         <code>getProductNameList()</code>
	 *         method help to view product details in database.
	 *         </p>
	 * 
	 * @param productId
	 *            int
	 * 
	 * 
	 * @throws Exception
	 */
	@Override
	public HashMap<String, String> getProductNameList() throws Exception {
		HashMap<String, String> productNameList = new HashMap<String, String>();
		try {

			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_PRODUCT_NAME);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				productNameList.put(resultSet.getString("PRODUCT_NAME"),
						resultSet.getString("PRODUCT_NAME"));
			}

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					ProductDaoImpl.class
							+ ": Error:- Error: Occur in Query While fetching Product  name list from Database",
					sqlException);

		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					ProductDaoImpl.class
							+ ": Error:- While closing the Connection after fetching the Product  name list from Database",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return productNameList;
	}
	
	
	
	/**
	 * <p>
	 * <code>productPDF()</code> method use to generate pdf report for product
	 * details from TAB_PRODUCT_DETAILS table.
	 * 
	 * </p>
	 * 
	 * @return productVO
	 * @throws Exception
	 */
	@Override
	public void productPDF(HttpServletRequest request,
			HttpServletResponse response, int productId) throws Exception {
		String companyName = "Chouksay Traders";
		String address1= "BUS STAND SHAMSHABAD, DIST.- VIDISHA, MADHYA PRADESH, 464001";
		String address2="GSTIN: 23AJQPC8200P1Z1";
		String address3="PAN NO: AJQPC8200P";

		String city = "Vidisha-464001";
		String state = "(M.P.)";

		try {

			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.SHOW_PRODUCT_PRINT_PDF);
			preparedStatement.setInt(1, productId);
			resultSet = preparedStatement.executeQuery();
			Document document = new Document(PageSize.A4);

			Font Font3 = new Font(Font.FontFamily.TIMES_ROMAN, 11, Font.NORMAL);
			Font Font2 = new Font(Font.FontFamily.TIMES_ROMAN, 6,
					Font.STRIKETHRU);
			Font Font4 = new Font(Font.FontFamily.TIMES_ROMAN, 11, Font.BOLD);
			Font4.setColor(BaseColor.WHITE);
			Font mainContent = new Font(Font.FontFamily.TIMES_ROMAN, 10,
					Font.NORMAL);
			Font Font5 = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
			Font5.setColor(BaseColor.GRAY);
			Font Font6 = new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.BOLD);
			Font6.setColor(BaseColor.RED);

			// Output
			response.setContentType("application/pdf");

			PdfWriter.getInstance(document, response.getOutputStream());

			document.open();
			// header
			String contextPath = ServletActionContext.getServletContext()
					.getRealPath("/outer/img/bir3.png");
			image = Image.getInstance(contextPath);
			image.scaleToFit(130, 70);

			PdfPTable table1 = new PdfPTable(2);
			table1.setWidthPercentage(100);
			Rectangle rect1 = new Rectangle(300, 700);
			table1.setWidthPercentage(new float[] { 150, 150 }, rect1);

			PdfPCell cell101 = new PdfPCell(image, false);
			cell101.setPaddingTop(5);
			cell101.setBorder(Rectangle.NO_BORDER);

			Phrase phrase3 = new Phrase(companyName + "\n", Font5);
			Phrase phrase = new Phrase(address1 + "\n", Font3);
			Phrase phrase1 = new Phrase(address2 + "\n", Font3);
			Phrase phrase2 = new Phrase(address3 + "\n", Font3);
			Phrase phrase4 = new Phrase(city + "-" + state, Font3);

			Paragraph paragraph = new Paragraph();
			paragraph.add(phrase3);
			paragraph.add(phrase);
			paragraph.add(phrase1);
			paragraph.add(phrase2);
			paragraph.add(phrase4);
			
			PdfPCell cell102 = new PdfPCell(paragraph);
			cell102.setPaddingTop(5);
			cell102.setBorder(Rectangle.NO_BORDER);
			cell102.setHorizontalAlignment(Element.ALIGN_RIGHT);

			PdfPCell cell103 = new PdfPCell(
					new Paragraph(
							"   \n                                                                                        "
									+ "                                                                                                                            "
									+ "                                                                                                                              ",
							Font2));
			cell103.setColspan(2);
			cell103.setBorderWidthRight(0f);
			cell103.setBorderWidthLeft(0f);
			cell103.setBorderWidthTop(0.5f);
			cell103.setBorderWidthBottom(0f);
			cell103.setBorderColorTop(BaseColor.WHITE);

			PdfPCell cell104 = new PdfPCell(new Paragraph("PRODUCT REPORT",
					Font4));
			cell104.setUseBorderPadding(true);
			cell104.setColspan(2);
			cell104.setBorderWidthRight(0.1f);
			cell104.setBorderWidthLeft(0.1f);
			cell104.setBorderWidthTop(0.1f);
			cell104.setBorderWidthBottom(0.1f);
			cell104.setBorderColor(BaseColor.LIGHT_GRAY);
			cell104.setBackgroundColor(new BaseColor(0, 59, 119));

			table1.addCell(cell101);
			table1.addCell(cell102);
			table1.addCell(cell103);
			table1.addCell(cell104);
			document.add(table1);

			// End Header

			// Fetching the Records for Design Details and setting it into right
			// column of table.
			while (resultSet.next()) {

				PdfPTable table = new PdfPTable(2);
				table.setFooterRows(1);
				table.setWidthPercentage(100);
				Rectangle rect = new Rectangle(300, 700);
				table.setWidthPercentage(new float[] { 80, 220 }, rect);

				PdfPCell cell = new PdfPCell(new Paragraph());
				cell.setColspan(2);
				cell.setBorderWidthRight(0.1f);
				cell.setBorderWidthLeft(0.1f);
				cell.setBorderWidthTop(0.1f);
				cell.setBorderWidthBottom(0.2f);
				cell.setBorderColor(BaseColor.LIGHT_GRAY);
				cell.setBackgroundColor(new BaseColor(238, 238, 238));

				PdfPCell cell1 = new PdfPCell(new Paragraph(
						"Product Information", Font6));
				cell1.setBackgroundColor(new BaseColor(238, 238, 238));
				cell1.setBorderWidth(0.01f);
				cell1.setBorderColor(BaseColor.WHITE);

				PdfPCell cell2 = new PdfPCell(new Paragraph());
				cell2.setBackgroundColor(new BaseColor(238, 238, 238));
				cell2.setBorderWidth(0.2f);
				cell2.setBorderColor(BaseColor.WHITE);

				PdfPCell cell3 = new PdfPCell(new Paragraph("Product Name",
						mainContent));
				cell3.setBackgroundColor(new BaseColor(238, 238, 238));
				cell3.setBorderWidth(0.01f);
				cell3.setBorderColor(BaseColor.WHITE);

				PdfPCell cell4 = new PdfPCell(new Paragraph(
						resultSet.getString("PRODUCT_NAME"), mainContent));
				cell4.setBorderWidth(0.2f);
				cell4.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell5 = new PdfPCell(new Paragraph("Product Code",
						mainContent));
				cell5.setBackgroundColor(new BaseColor(238, 238, 238));
				cell5.setBorderWidth(0.01f);
				cell5.setBorderColor(BaseColor.WHITE);

				PdfPCell cell6 = new PdfPCell(new Paragraph(
						resultSet.getString("PRODUCT_CODE"), mainContent));
				cell6.setBorderWidth(0.2f);
				cell6.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell7 = new PdfPCell(new Paragraph("Product Category",
						mainContent));
				cell7.setBackgroundColor(new BaseColor(238, 238, 238));
				cell7.setBorderWidth(0.01f);
				cell7.setBorderColor(BaseColor.WHITE);

				PdfPCell cell8 = new PdfPCell(new Paragraph(
						nameHelper.getProductCategory(resultSet
								.getInt("PRODUCT_CATEGORY")), mainContent));
				cell8.setBorderWidth(0.2f);
				cell8.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell9 = new PdfPCell(new Paragraph("Product Active",
						mainContent));
				cell9.setBackgroundColor(new BaseColor(238, 238, 238));
				cell9.setBorderWidth(0.01f);
				cell9.setBorderColor(BaseColor.WHITE);

				PdfPCell cell10 = new PdfPCell(new Paragraph(
						resultSet.getString("PRODUCT_ACTIVE"), mainContent));
				cell10.setBorderWidth(0.2f);
				cell10.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell11 = new PdfPCell(new Paragraph("Vendor Name",
						mainContent));
				cell11.setBackgroundColor(new BaseColor(238, 238, 238));
				cell11.setBorderWidth(0.01f);
				cell11.setBorderColor(BaseColor.WHITE);

				PdfPCell cell12 = new PdfPCell(new Paragraph(
						nameHelper.getVendorName(resultSet
								.getInt("VENDOR_NAME")), mainContent));
				cell12.setBorderWidth(0.2f);
				cell12.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell13 = new PdfPCell(new Paragraph("Manufacturer",
						mainContent));
				cell13.setBackgroundColor(new BaseColor(238, 238, 238));
				cell13.setBorderWidth(0.01f);
				cell13.setBorderColor(BaseColor.WHITE);

				PdfPCell cell14 = new PdfPCell(new Paragraph(
						nameHelper.getManufacturer(resultSet
								.getInt("MANUFACTURER")), mainContent));
				cell14.setBorderWidth(0.2f);
				cell14.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell15 = new PdfPCell(new Paragraph(
						"Sales Start Date ", mainContent));
				cell15.setBackgroundColor(new BaseColor(238, 238, 238));
				cell15.setBorderWidth(0.01f);
				cell15.setBorderColor(BaseColor.WHITE);

				PdfPCell cell16 = new PdfPCell(new Paragraph(
						resultSet.getString("SALES_START_DATE"), mainContent));
				cell16.setBorderWidth(0.2f);
				cell16.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell17 = new PdfPCell(new Paragraph("Sales End Date ",
						mainContent));
				cell17.setBackgroundColor(new BaseColor(238, 238, 238));
				cell17.setBorderWidth(0.01f);
				cell17.setBorderColor(BaseColor.WHITE);

				PdfPCell cell18 = new PdfPCell(new Paragraph(
						resultSet.getString("SALES_END_DATE"), mainContent));
				cell18.setBorderWidth(0.2f);
				cell18.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell19 = new PdfPCell(new Paragraph(
						"Support Start Date ", mainContent));
				cell19.setBackgroundColor(new BaseColor(238, 238, 238));
				cell19.setBorderWidth(0.01f);
				cell19.setBorderColor(BaseColor.WHITE);

				PdfPCell cell20 = new PdfPCell(new Paragraph(
						resultSet.getString("SUPPORT_START_DATE"), mainContent));
				cell20.setBorderWidth(0.2f);
				cell20.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell21 = new PdfPCell(new Paragraph(
						"Support End Date ", mainContent));
				cell21.setBackgroundColor(new BaseColor(238, 238, 238));
				cell21.setBorderWidth(0.01f);
				cell21.setBorderColor(BaseColor.WHITE);

				PdfPCell cell22 = new PdfPCell(
						new Paragraph(
								resultSet.getString("SUPPORT_EXPIRY_DATE"),
								mainContent));
				cell22.setBorderWidth(0.2f);
				cell22.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell23 = new PdfPCell(new Paragraph("Serial No.",
						mainContent));
				cell23.setBackgroundColor(new BaseColor(238, 238, 238));
				cell23.setBorderWidth(0.01f);
				cell23.setBorderColor(BaseColor.WHITE);

				PdfPCell cell24 = new PdfPCell(new Paragraph(
						resultSet.getString("SERIAL_NO"), mainContent));
				cell24.setBorderWidth(0.2f);
				cell24.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell25 = new PdfPCell(new Paragraph(
						"Mfr. Part Number", mainContent));
				cell25.setBackgroundColor(new BaseColor(238, 238, 238));
				cell25.setBorderWidth(0.01f);
				cell25.setBorderColor(BaseColor.WHITE);

				PdfPCell cell26 = new PdfPCell(new Paragraph(
						resultSet.getString("MFR_PART_NO"), mainContent));
				cell26.setBorderWidth(0.2f);
				cell26.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell27 = new PdfPCell(new Paragraph("Unit Price ",
						mainContent));
				cell27.setBackgroundColor(new BaseColor(238, 238, 238));
				cell27.setBorderWidth(0.01f);
				cell27.setBorderColor(BaseColor.WHITE);

				PdfPCell cell28 = new PdfPCell(new Paragraph(
						resultSet.getString("UNIT_PRICE"), mainContent));
				cell28.setBorderWidth(0.2f);
				cell28.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell29 = new PdfPCell(new Paragraph("Product Sheet",
						mainContent));
				cell29.setBackgroundColor(new BaseColor(238, 238, 238));
				cell29.setBorderWidth(0.01f);
				cell29.setBorderColor(BaseColor.WHITE);

				PdfPCell cell30 = new PdfPCell(new Paragraph(
						resultSet.getString("PRODUCT_SHEET"), mainContent));
				cell30.setBorderWidth(0.2f);
				cell30.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell31 = new PdfPCell(new Paragraph("GL Account",
						mainContent));
				cell31.setBackgroundColor(new BaseColor(238, 238, 238));
				cell31.setBorderWidth(0.01f);
				cell31.setBorderColor(BaseColor.WHITE);

				PdfPCell cell32 = new PdfPCell(
						new Paragraph(nameHelper.getGlAccount(resultSet
								.getInt("GL_ACCOUNT")), mainContent));
				cell32.setBorderWidth(0.2f);
				cell32.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell33 = new PdfPCell(new Paragraph("Purchase Cost",
						mainContent));
				cell33.setBackgroundColor(new BaseColor(238, 238, 238));
				cell33.setBorderWidth(0.01f);
				cell33.setBorderColor(BaseColor.WHITE);

				PdfPCell cell34 = new PdfPCell(new Paragraph(
						resultSet.getString("PURCHASE_COST"), mainContent));
				cell34.setBorderWidth(0.2f);
				cell34.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell35 = new PdfPCell(new Paragraph("Vendor Part No.",
						mainContent));
				cell35.setBackgroundColor(new BaseColor(238, 238, 238));
				cell35.setBorderWidth(0.01f);
				cell35.setBorderColor(BaseColor.WHITE);

				PdfPCell cell36 = new PdfPCell(new Paragraph(
						resultSet.getString("VENDOR_PART_NO"), mainContent));
				cell36.setBorderWidth(0.2f);
				cell36.setBorderColor(BaseColor.LIGHT_GRAY);

				PdfPCell cell37 = new PdfPCell(
						new Paragraph("Tax", mainContent));
				cell37.setBackgroundColor(new BaseColor(238, 238, 238));
				cell37.setBorderWidth(0.01f);
				cell37.setBorderColor(BaseColor.WHITE);

				PdfPCell cell38 = new PdfPCell(new Paragraph(
						resultSet.getString("TAX"), mainContent));
				cell38.setBorderWidth(0.2f);
				cell38.setBorderColor(BaseColor.LIGHT_GRAY);
				
				
				PdfPCell cell39 = new PdfPCell(
						new Paragraph("Commission Rate", mainContent));
				cell39.setBackgroundColor(new BaseColor(238, 238, 238));
				cell39.setBorderWidth(0.01f);
				cell39.setBorderColor(BaseColor.WHITE);

				PdfPCell cell40 = new PdfPCell(new Paragraph(
						resultSet.getString("COMMISION_RATE"), mainContent));
				cell40.setBorderWidth(0.2f);
				cell40.setBorderColor(BaseColor.LIGHT_GRAY);
				
				PdfPCell cell41 = new PdfPCell(
						new Paragraph("Quantity In Demand", mainContent));
				cell41.setBackgroundColor(new BaseColor(238, 238, 238));
				cell41.setBorderWidth(0.01f);
				cell41.setBorderColor(BaseColor.WHITE);

				PdfPCell cell42 = new PdfPCell(new Paragraph(
						resultSet.getString("QTY_IN_DEMAND"), mainContent));
				cell42.setBorderWidth(0.2f);
				cell42.setBorderColor(BaseColor.LIGHT_GRAY);
				
				
				PdfPCell cell43 = new PdfPCell(
						new Paragraph("Handler", mainContent));
				cell43.setBackgroundColor(new BaseColor(238, 238, 238));
				cell43.setBorderWidth(0.01f);
				cell43.setBorderColor(BaseColor.WHITE);

				PdfPCell cell44 = new PdfPCell(new Paragraph(nameHelper.getHandler(
						resultSet.getInt("HANDLER")), mainContent));
				cell44.setBorderWidth(0.2f);
				cell44.setBorderColor(BaseColor.LIGHT_GRAY);

				
				
				PdfPCell cell45 = new PdfPCell(
						new Paragraph("Quantity Unit", mainContent));
				cell45.setBackgroundColor(new BaseColor(238, 238, 238));
				cell45.setBorderWidth(0.01f);
				cell45.setBorderColor(BaseColor.WHITE);

				PdfPCell cell46 = new PdfPCell(new Paragraph(
						resultSet.getString("QTY_PER_UNIT"), mainContent));
				cell46.setBorderWidth(0.2f);
				cell46.setBorderColor(BaseColor.LIGHT_GRAY);
				
				
				PdfPCell cell47 = new PdfPCell(
						new Paragraph("Usage Unit", mainContent));
				cell47.setBackgroundColor(new BaseColor(238, 238, 238));
				cell47.setBorderWidth(0.01f);
				cell47.setBorderColor(BaseColor.WHITE);

				PdfPCell cell48 = new PdfPCell(new Paragraph(
						resultSet.getString("USAGE_UNIT"), mainContent));
				cell48.setBorderWidth(0.2f);
				cell48.setBorderColor(BaseColor.LIGHT_GRAY);
				
				
				PdfPCell cell49 = new PdfPCell(
						new Paragraph("Quantity In Stock", mainContent));
				cell49.setBackgroundColor(new BaseColor(238, 238, 238));
				cell49.setBorderWidth(0.01f);
				cell49.setBorderColor(BaseColor.WHITE);

				PdfPCell cell50 = new PdfPCell(new Paragraph(
						resultSet.getString("QTY_IN_STOCK"), mainContent));
				cell50.setBorderWidth(0.2f);
				cell50.setBorderColor(BaseColor.LIGHT_GRAY);
				
				
				PdfPCell cell51 = new PdfPCell(new Paragraph("Description",
						  Font6)); cell51.setBackgroundColor(new BaseColor(238, 238,
						  238)); cell51.setBorderWidth(0.01f);
						  cell51.setBorderColor(BaseColor.WHITE);
						  
						  PdfPCell cell52 = new PdfPCell(new Paragraph());
						  cell52.setBackgroundColor(new BaseColor(238, 238, 238));
						  cell52.setBorderWidth(0.2f);
						  cell52.setBorderColor(BaseColor.WHITE);
						  
						  PdfPCell cell53 = new PdfPCell(new Paragraph(
						  "Description Details", mainContent));
						  cell53.setBackgroundColor(new BaseColor(238, 238, 238));
						  cell53.setBorderWidth(0.01f);
						  cell53.setBorderColor(BaseColor.WHITE); String temp =
						  resultSet.getString("DESCRIPTION");
						  
						  PdfPCell cell54 = new PdfPCell(new Paragraph(temp.replaceAll(
						  "\\<.*?\\>", " "), mainContent));
						  cell54.setBorderWidth(0.2f);
						  cell54.setBorderColor(BaseColor.LIGHT_GRAY);
						 
				
				
				
				
				
			

				table.addCell(cell);
				table.addCell(cell1);
				table.addCell(cell2);
				table.addCell(cell3);
				table.addCell(cell4);
				table.addCell(cell5);
				table.addCell(cell6);
				table.addCell(cell7);
				table.addCell(cell8);

				table.addCell(cell9);
				table.addCell(cell10);
				table.addCell(cell11);
				table.addCell(cell12);
				table.addCell(cell13);
				table.addCell(cell14);
				table.addCell(cell15);
				table.addCell(cell16);

				table.addCell(cell17);
				table.addCell(cell18);
				table.addCell(cell19);
				table.addCell(cell20);
				table.addCell(cell21);
				table.addCell(cell22);
				table.addCell(cell23);
				table.addCell(cell24);
				
				 table.addCell(cell27); table.addCell(cell28);
				  
				  
				  table.addCell(cell29); table.addCell(cell30);
				  
				  table.addCell(cell31); table.addCell(cell32);
				 table.addCell(cell33); table.addCell(cell34);
				  table.addCell(cell35); table.addCell(cell36);
				  table.addCell(cell37); table.addCell(cell38);
				  table.addCell(cell39); table.addCell(cell40);
				  table.addCell(cell41); table.addCell(cell42);
				  table.addCell(cell43); table.addCell(cell44);
				  table.addCell(cell45); table.addCell(cell46);
				  table.addCell(cell47); table.addCell(cell48);
				  table.addCell(cell49); table.addCell(cell50);
				  table.addCell(cell51); table.addCell(cell52);
				  table.addCell(cell53); table.addCell(cell54);
				  
				 

				document.add(table);
			}
			// Footer

			document.add(new Paragraph("\n"));
			document.add(new Paragraph(
					"© 2016 BirjaSoft Technologies. All Rights Reserved.",
					mainContent));
			document.close();
			// End Footer
		} catch (SQLException sqlExp) {
			sqlExp.printStackTrace();
			logger.error(
					ProductDaoImpl.class
							+ "Error: Occur in Query While Fetching All Product Details for print PdF from Database.",
					sqlExp);
		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					ProductDaoImpl.class
							+ "Error: Occur in Query While Closing Connection After Fetching All Product Details for print PdF from Database.",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}

	}

	@Override
	public int checkCategoryAvailability(String val) throws RecordNotFoundException {
		int existence=0;
		try {

			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_PRODUCT_CATEGORY_IN_TYPE);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
			int	check=	resultSet.getInt("CEMENT_TYPE_CATEGORY");
						if(check==Integer.parseInt(val)){
							existence=1;
						}
			}

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					ProductDaoImpl.class
							+ ": Error:- Error: Occur in Query While checking category from Database",
					sqlException);

		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					ProductDaoImpl.class
							+ ": Error:- While closing the Connection after checking category  from Database",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return existence;
	}
	
	
}
