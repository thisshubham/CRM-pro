package com.bst.ckt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.bst.ckt.common.OMIConstants;
import com.bst.ckt.common.QueryMaker;
import com.bst.ckt.exception.CreateFailedException;
import com.bst.ckt.exception.DeleteFailedException;
import com.bst.ckt.exception.RecordNotFoundException;
import com.bst.ckt.exception.UpdateFailedException;
import com.bst.ckt.framework.db.JdbcDAOSupport;
import com.bst.ckt.framework.util.DateTimeUtil;
import com.bst.ckt.framework.util.IDGenerator;
import com.bst.ckt.vo.EstimateVO;

public class EstimateDaoImpl extends JdbcDAOSupport implements EstimateDaoInf{

	/**
	 * Creating Logger Object,logger object map with ClientDAOListHelper class
	 * for writing loggers.
	 */
	private static final Logger log = Logger.getLogger(EstimateDaoImpl.class);
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	EstimateVO estimateVO = null;
	
	
	
	/**
	 * languageList method use to fetch language name and language ID from
	 * TAB_BUSINESS_FUNCTION table.
	 * 
	 * @return HashMap<Integer, String>
	 * @throws Exception
	 */
	public int getCountryId(int userId) throws Exception {
		int countryId = 0;
		try {
			String languageQuery = QueryMaker.GET_COUNTRY_ID;
			connection = getConnection();
			preparedStatement = connection.prepareStatement(languageQuery);
			preparedStatement.setInt(1, userId);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				countryId = resultSet.getInt("REF_COUNTRY");

			}
			return countryId;
		} catch (Exception exception) {

			log.error(EstimateDaoImpl.class
					+ ": Error:- While getting countryId  From Database.");
		} finally {
			try {
				if (null != connection) {
					resultSet.close();
					preparedStatement.close();
					connection.close();
				}
			} catch (SQLException sqlExp) {
				log.error(EstimateDaoImpl.class
						+ ": Error:- While closing the Connection after getting countryId  From Database.");
			}
		}
		return countryId;
	}
	public String countryCodeByClient(int countryId) throws Exception {
		String countryCode = null;
		try {
			String languageQuery = QueryMaker.GET_COUNTRY_CODE;
			connection = getConnection();
			preparedStatement = connection.prepareStatement(languageQuery);
			preparedStatement.setInt(1, countryId);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				countryCode = resultSet.getString("COUNTRY_CODE");

			}
			return countryCode;
		} catch (Exception exception) {

			log.error(EstimateDaoImpl.class
					+ ": Error:- While getting countryCode  From Database.");
		} finally {
			try {
				if (null != connection) {
					resultSet.close();
					preparedStatement.close();
					connection.close();
				}
			} catch (SQLException sqlExp) {
				log.error(EstimateDaoImpl.class
						+ ": Error:- While closing the Connection after getting countryCode  From Database.");
			}
		}
		return countryCode;
	}


	@Override
	public String addEstimateDetails(EstimateVO estimateVO, int createdBy)
			throws CreateFailedException {
		String query = QueryMaker.ADD_ESTIMATE_DETAILS;
		try {
			String uniqueId = IDGenerator.generateAlphaNumericID(27);
			System.out.println("uniqueId" + uniqueId);
			connection = getConnection();
			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setString(1, estimateVO.getEstimateId());
			preparedStatement.setString(2, estimateVO.getEstimateDate());
			preparedStatement.setInt(3, estimateVO.getCurrencyId());
			preparedStatement.setInt(4, estimateVO.getClientId());
			preparedStatement.setString(5, estimateVO.getReferenceNo());
			preparedStatement.setString(6, estimateVO.getScanDocument());

			// preparedStatement.setString(7, estimateVO.getItemId());
			// preparedStatement.setString(8, estimateVO.getItemDescription());
			// preparedStatement.setString(9, estimateVO.getItemQuantity());
			// /preparedStatement.setString(10, estimateVO.getItemPrice());
			// preparedStatement.setString(11, estimateVO.getItemTax());
			// preparedStatement.setString(12, estimateVO.getAmount());
			preparedStatement.setString(7, estimateVO.getSubTotal());
			preparedStatement.setString(8, estimateVO.getTotalTax());
			preparedStatement.setString(9, estimateVO.getTotal());
			preparedStatement.setString(10, estimateVO.getDiscount());
			preparedStatement.setString(11, estimateVO.getNetTotal());
			preparedStatement.setInt(12, createdBy);
			preparedStatement.setString(13, DateTimeUtil.getCurrentDate());
			preparedStatement.setString(14, uniqueId);
			int count = preparedStatement.executeUpdate();
			int estmID = getEstimateId(uniqueId);
			System.out.println("estmID" + estmID);
			String[] a = estimateVO.getItemId().split(",");
			System.out.println(estimateVO.getItemId()+" "+estimateVO.getItemDescription()+" "+estimateVO.getItemQuantity());
			String[] b = estimateVO.getItemDescription().split(",");
			String[] c = estimateVO.getItemQuantity().split(",");
			String[] d = estimateVO.getItemPrice().split(",");
			//String[] e = String.valueOf(estimateVO.getItemTax()).split(",");
			String[] e = estimateVO.getItemTax().split(",");
			String[] f = estimateVO.getAmount().split(",");

			addEstimateItems(a, b, c, d, e, f, estmID);

			if (count != 0)
				return OMIConstants.TARGET_ESTIMATE_SUCCESS;
			else
				return OMIConstants.TARGET_ESTIMATE_FAIL;
		} catch (Exception exception) {

			log.error(EstimateDaoImpl.class
					+ ": Error:- While inserting estimate details into Database.");
		} finally {
			try {
				if (null != connection) {
					preparedStatement.close();
					connection.close();
				}
			} catch (SQLException sqlExp) {
				log.error(EstimateDaoImpl.class
						+ ": Error:- While closing the Connection after inserting estimate details into Database.");
			}
		}
		return OMIConstants.TARGET_ESTIMATE_FAIL;
		
	}
	
	
	private void addEstimateItems(String[] a, String[] b, String[] c,
			String[] d, String[] e, String[] f, int estmID) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		for (int i = 0; i < a.length; i++) {
			String sql = QueryMaker.ADD_ESTIMATE_ITEMS;
			try {
				connection = getConnection();
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, a[i]);
				preparedStatement.setString(2, b[i]);
				preparedStatement.setString(3, c[i]);
				preparedStatement.setString(4, d[i]);
				preparedStatement.setString(5, e[i]);
				System.out.println("e[i]llllllllllllle[i]"+e[i]);
				preparedStatement.setString(6, f[i]);
				preparedStatement.setInt(7, estmID);
				preparedStatement.executeUpdate();
			} catch (Exception exception) {
				exception.printStackTrace();
			}
		}

	}
	@Override
	public String updateEstimateDetails(EstimateVO estimateVO, int createdBy)
			throws UpdateFailedException {
		
		return null;
	}

	private int getEstimateId(String uniqueId) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String sql = QueryMaker.GET_ESTIMATE_ID;
		int estId = 0;
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, uniqueId);
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				if (resultSet.next()) {
					estId = resultSet.getInt("ESTIMATE_ID");
				}
			}
			return estId;
		} catch (Exception e) {
			return estId;
		}

	}
	
	public JSONObject productListJSON() {

		JSONObject productList = null;
		try {
/*			String query = QueryMaker.GET_PRODUCT_LIST;*/
			String query = QueryMaker.GET_ITEM_DROP_DOWN;
			connection = getConnection();
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			JSONArray array = new JSONArray();
			productList = new JSONObject();

			while (resultSet.next()) {
				JSONObject object = new JSONObject();

				int productID = resultSet.getInt("PRODUCT_ID");
				String productName = resultSet
						.getString("PRODUCT_NAME");
				object.put("productID", productID);
				object.put("productName", productName);
				array.add(object);
			}
			productList.put("Product", array);
		} catch (Exception exception) {

			log.error(EstimateDaoImpl.class
					+ ": Error:- While getting Product id and Product name From Database.");
		} finally {
			try {
				if (null != connection) {
					resultSet.close();
					preparedStatement.close();
					connection.close();
				}
			} catch (SQLException sqlExp) {
				log.error(EstimateDaoImpl.class
						+ ": Error:- While closing the Connection after getting Product id and Product name From Database.");
			}
		}
		return productList;
	}
	
	
	
		public JSONObject taxListJSON() {

		JSONObject taxList = null;
		try {
			String query = QueryMaker.GET_TAX_LIST;
			connection = getConnection();
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			JSONArray array = new JSONArray();
			taxList = new JSONObject();

			while (resultSet.next()) {
				JSONObject object = new JSONObject();

				float totalTax = resultSet.getFloat("TAX_TOTAL");
				String taxdisplayName = resultSet.getString("TAX_DISPLAY_NAME");
				object.put("totalTax", totalTax);
				object.put("taxdisplayName", taxdisplayName);
				array.add(object);
			}
			taxList.put("Tax", array);
		} catch (Exception exception) {

			log.error(EstimateDaoImpl.class
					+ ": Error:- While getting Tax display name and Total Tax name From Database.");
		} finally {
			try {
				if (null != connection) {
					resultSet.close();
					preparedStatement.close();
					connection.close();
				}
			} catch (SQLException sqlExp) {
				log.error(EstimateDaoImpl.class
						+ ": Error:- While closing the Connection after getting Tax display name and Total tax From Database.");
			}
		}
		return taxList;
	}
		@Override
		public List<EstimateVO> getEstimateDetails(EstimateVO EstimateVO)
				throws RecordNotFoundException {
			String query = QueryMaker.GET_ESTIMATE_DETAILS_GRID;
			ArrayList<EstimateVO> estimateList = new ArrayList<EstimateVO>();
			System.out.println("*******************************auaaaa");
			try {
				connection = getConnection();
				preparedStatement = connection.prepareStatement(query);
				resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
					estimateVO = new EstimateVO();

					String clName = getClientNameById(resultSet
							.getInt("REF_CLIENT_ID"));
					System.out.println(clName);
					estimateVO.setId(resultSet.getInt("ESTIMATE_ID"));
					estimateVO.setClientName(clName);
					estimateVO.setCreatedDate(resultSet.getString("CREATED_DATE"));
					estimateVO
							.setEstimateDate(resultSet.getString("ESTIMATE_DATE"));
					estimateVO.setNetTotal(resultSet.getString("NETTOTAL"));
					//////////////////////////
					estimateVO.setCreatedBy(resultSet.getInt("CREATED_BY"));
					estimateVO.setUpdatedBy(resultSet.getInt("UPDATED_BY"));
					estimateVO.setDiscount(resultSet.getString("DISCOUNT"));
					estimateVO.setCurrencyId(resultSet.getInt("REF_CURRENCY_ID"));
					estimateVO.setTotal(resultSet.getString("TOTAL"));
					System.out.println(estimateVO.getAmount()+" "+estimateVO.getCreatedDate()+" "+estimateVO.getItemDescription());
					estimateList.add(estimateVO);

				}
			}

			catch (Exception exception) {
				log.error(EstimateDaoImpl.class
						+ ": Error:- While fetching estimate details from Database.");
			} finally {
				try {
					if (null != connection) {
						resultSet.close();
						preparedStatement.close();
						connection.close();
					}
				} catch (SQLException sqlExp) {
					log.error(EstimateDaoImpl.class
							+ ": Error:- While closing the Connection after fetching estimate details from Database.");
				}
			}
			return estimateList;
		}
		
		
		public String getClientNameById(int clientId) throws Exception {
			String query = QueryMaker.GET_CLIENT_NAME;
			String clientName = null;
			Connection connection1 = null;
			PreparedStatement preparedStatement1 = null;
			ResultSet resultSet1 = null;
			try {

				connection1 = getConnection();
				preparedStatement1 = connection1.prepareStatement(query);
				preparedStatement1.setInt(1, clientId);
				resultSet1 = preparedStatement1.executeQuery();
				while (resultSet1.next()) {
					String firstName = resultSet1.getString("FIRST_NAME");
					String lastName = resultSet1.getString("LAST_NAME");
					clientName = firstName + " " + lastName;

				}
			}

			catch (Exception exception) {

				log.error(EstimateDaoImpl.class
						+ ": Error:- While fetching Client Name from Database.");
			} finally {
				try {
					if (null != connection) {
						resultSet1.close();
						preparedStatement1.close();
						connection1.close();
					}
				} catch (SQLException sqlExp) {
					log.error(EstimateDaoImpl.class
							+ ": Error:- While closing the Connection after fetching Client Name from Database.");
				}
			}
			return clientName;
		}
		@Override
		public EstimateVO viewEstimate(int estimateId)
				throws RecordNotFoundException {
			String sql = QueryMaker.GET_ESTIMATE_DETAILS;

			try {
				connection = getConnection();
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setInt(1, estimateId);
				resultSet = preparedStatement.executeQuery();
				if (resultSet != null) {
					estimateVO = new EstimateVO();

					if (resultSet.next()) {

						estimateVO.setId(resultSet.getInt("ESTIMATE_ID"));
						estimateVO.setEstimateId(resultSet
								.getString("ESTIMATE_NUMBER"));
						estimateVO.setEstimateDate(resultSet
								.getString("ESTIMATE_DATE"));
						estimateVO.setCurrencyId(resultSet
								.getInt("REF_CURRENCY_ID"));
						estimateVO.setClientId(resultSet.getInt("REF_CLIENT_ID"));
						estimateVO.setReferenceNo(resultSet
								.getString("ESTIMATE_REFNO"));
						estimateVO.setScanDocument(resultSet
								.getString("ESTIMATE_SCANCOPY"));
						estimateVO.setSubTotal(resultSet.getString("SUBTOTAL"));
						estimateVO.setTotalTax(resultSet.getString("TOTALTAX"));
						estimateVO.setTotal(resultSet.getString("TOTAL"));
						estimateVO.setDiscount(resultSet.getString("DISCOUNT"));
						estimateVO.setNetTotal(resultSet.getString("NETTOTAL"));
						estimateVO.setCreatedBy(resultSet.getInt("CREATED_BY"));

					}

				}
				return estimateVO;

			} catch (Exception e) {
				log.error(EstimateDaoImpl.class
						+ ": Error:- While fetching Client Name from Database."+e);
			}
			return estimateVO;
		}
		@Override
		public List<EstimateVO> viewEstimateItems(int id)
				throws RecordNotFoundException {
			String sql = QueryMaker.GET_ESTIMATE_ITEMS_DETAILS;
			List<EstimateVO> listEstimateItems =  new ArrayList<EstimateVO>();
			try {
				connection = getConnection();
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setInt(1, id);
				resultSet = preparedStatement.executeQuery();
				if (resultSet != null) {
					
					while (resultSet.next()) {
						estimateVO = new EstimateVO();
						estimateVO.setItemId(resultSet.getString("ITEM_ID"));
						estimateVO.setItemDescription(resultSet
								.getString("DESCRIPTION"));
						estimateVO.setItemQuantity(resultSet.getString("QUANTITY"));
						estimateVO.setItemPrice(resultSet.getString("PRICE"));
						estimateVO.setItemTax(String.valueOf(resultSet.getFloat("TAX")));
						System.out.println("55"+estimateVO.getItemTax());
						estimateVO.setAmount(resultSet.getString("AMOUNT"));
						System.out.println("ll");
						listEstimateItems.add(estimateVO);

					}

				}
				

			} catch (Exception e) {
				log.error(EstimateDaoImpl.class
						+ ": Error:- While fetching Estimate Items from Database.");		
				}
			return listEstimateItems;
		}
		@Override
		public void deleteEstimateDetails(int id)
				throws DeleteFailedException {

			String sql = QueryMaker.DELETE_ESTIMATE_DETAILS;
			try {
				connection = getConnection();
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setInt(1, id);
				System.out.println("hello now we r in delete method$$$");
				preparedStatement.executeUpdate();			
			}catch (Exception exception) {
					log.error(EstimateDaoImpl.class
							+ ": Error:- While deleting estimate details into Database."+exception);
				} finally {
					try {
						if (null != connection) {
							preparedStatement.close();
							connection.close();
						}
					} catch (SQLException sqlExp) {
						log.error(EstimateDaoImpl.class
								+ ": Error:- While closing the Connection after deleting estimate details into Database.");
					}
				}
		}
		
}



