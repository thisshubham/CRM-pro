/*
 **********************************************************************
 *
 * COPYRIGHT. $ID$ 2014. ALL RIGHTS RESERVED.
 *
 * This software is only to be used for the purpose for which it has been
 * provided. No part of it is to be reproduced, disassembled, transmitted,
 * stored in a retrieval system nor translated in any human or computer
 * language in any way or for any other purposes whatsoever without the
 * prior written consent of $ID$.
 * 
 * Class Name     ClientDAOListHelper.java     
 *                                                            
 * Creation Date JAN 16, 2015
 * 
 * Abstract       This is List helper class to retrieve data from database 
 *                and returns lists.
 *  
 * Amendment History (in chronological sequence): JAN 16, 2015
 * 
 **********************************************************************
 */

package com.bst.ckt.helper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.bst.ckt.common.QueryMaker;
import com.bst.ckt.framework.db.JdbcDAOSupport;




/**
 * <p>
 * <code>ClientDAOListHelper</code> Class is design to get the list of below.
 * <ul>
 * <li>Address Type List,It returns list of address type id and address type
 * name.</li>
 * </ul>
 * </p>
 * 
 * @author Saakib Ahmad
 * @version V1.0
 */

public class ClientDAOListHelper extends JdbcDAOSupport {

	/**
	 * Creating Logger Object,logger object map with ClientDAOListHelper class
	 * for writing loggers.
	 */
	private static final Logger log = Logger
			.getLogger(ClientDAOListHelper.class);

	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	/**
	 * addressTypeList method use to fetch address type name and address type ID
	 * from TAB_ADDRESS_TYPE table.
	 * 
	 * @return HashMap<Integer, String>
	 * @throws Exception
	 */

	/*public HashMap<Integer, String> addressTypeList() throws Exception {

		HashMap<Integer, String> addressTypeMap = new HashMap<Integer, String>();

		try {
			String addressTypeQuery = QueryMaker.GET_ADDRESS_TYPE_LIST;
			connection = getConnection();
			preparedStatement = connection.prepareStatement(addressTypeQuery);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int addressTypeId = resultSet.getInt("ADDRESS_TYPE_ID");
				String addressTypeName = resultSet
						.getString("ADDRESS_TYPE_NAME");
				addressTypeMap.put(addressTypeId, addressTypeName);

			}

		} catch (Exception exception) {

			log.error(ClientDAOListHelper.class
					+ ":Error:- While getting source id and source name From Database.");
		} finally {

			try {
				if (null != connection) {
					resultSet.close();
					preparedStatement.close();
					connection.close();

				}
			} catch (SQLException sqlExp) {
				log.error(ClientDAOListHelper.class
						+ ": Error:- While closing the Connection after getting source id and source name From Database.");
			}
		}

		return addressTypeMap;
	}

	
	 * public Map<Integer, String> countryList() { // TODO Auto-generated method
	 * stub return null; } }
	 

	*//**
	 * countryList method use to fetch country name and country ID from
	 * TAB_COUNTRY table.
	 * 
	 * @return HashMap<Integer, String>
	 * @throws Exception
	 *//*
	public HashMap<Integer, String> countryList() throws Exception {

		HashMap<Integer, String> countryMap = new HashMap<Integer, String>();
		try {
			String countryQuery = QueryMaker.GET_COUNTRY_LIST;
			connection = getConnection();
			preparedStatement = connection.prepareStatement(countryQuery);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int countryID = resultSet.getInt("COUNTRY_ID");
				String countryName = resultSet
						.getString("COUNTRY_DISPLAY_NAME");
				countryMap.put(countryID, countryName);

			}
		} catch (Exception exception) {

			log.error(ClientDAOListHelper.class
					+ ": Error:- While getting country id and country name From Database.");
		} finally {
			try {
				if (null != connection) {
					resultSet.close();
					preparedStatement.close();
					connection.close();
				}
			} catch (SQLException sqlExp) {
				log.error(ClientDAOListHelper.class
						+ ": Error:- While closing the Connection after getting country id and country name From Database.");
			}
		}
		return countryMap;
	}

	*//**
	 * departmentList method use to fetch department name and department ID from
	 * TAB_COUNTRY table.
	 * 
	 * @return HashMap<Integer, String>
	 * @throws Exception
	 *//*
	public HashMap<Integer, String> departmentList() throws Exception {

		HashMap<Integer, String> departmentlist = null;
		try {
			departmentlist = new HashMap<Integer, String>();
			String departmentQuery = QueryMaker.GET_DEPARTMENT_LIST;
			connection = getConnection();
			preparedStatement = connection.prepareStatement(departmentQuery);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int departmentID = resultSet.getInt("DEPARTMENT_ID");
				String departmentName = resultSet
						.getString("DEPARTMENT_NAME");
				departmentlist.put(departmentID, departmentName);

			}
			return departmentlist;
		} catch (Exception exception) {

			log.error(ClientDAOListHelper.class
					+ ": Error:- While getting department id and department name From Database.");
		} finally {
			try {
				if (null != connection) {
					resultSet.close();
					preparedStatement.close();
					connection.close();
				}
			} catch (SQLException sqlExp) {
				log.error(ClientDAOListHelper.class
						+ ": Error:- While closing the Connection after getting department id and department name From Database.");
			}
		}
		return departmentlist;
	}

	*//**
	 * companyTypeList method use to fetch companyType name and companyType ID from
	 * TAB_COMPANY_TYPE table.
	 * 
	 * @return HashMap<Integer, String>
	 * @throws Exception
	 *//*
	public HashMap<Integer, String> companyTypeList() throws Exception {

		HashMap<Integer, String> companyTypeList = null;
		try {
			companyTypeList = new HashMap<Integer, String>();
			String companyTypeQuery = QueryMaker.GET_CLIENT_COMPANY_TYPE_LIST;
			connection = getConnection();
			preparedStatement = connection.prepareStatement(companyTypeQuery);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int companyTypeID = resultSet.getInt("COMPANY_TYPE_ID");
				String companyTypeName = resultSet
						.getString("COMPANY_TYPE_NAME");
				companyTypeList.put(companyTypeID, companyTypeName);

			}
			return companyTypeList;
		} catch (Exception exception) {

			log.error(ClientDAOListHelper.class
					+ ": Error:- While getting companyType id and companyType name From Database.");
		} finally {
			try {
				if (null != connection) {
					resultSet.close();
					preparedStatement.close();
					connection.close();
				}
			} catch (SQLException sqlExp) {
				log.error(ClientDAOListHelper.class
						+ ": Error:- While closing the Connection after getting companyType id and companyType name From Database.");
			}
		}
		return companyTypeList;
	}
	
	*//**
	 * companyTypeList method use to fetch industry name and industry ID from
	 * TAB_BUSINESS_FUNCTION table.
	 * 
	 * @return HashMap<Integer, String>
	 * @throws Exception
	 *//*
	public HashMap<Integer, String> industryList() throws Exception {

		HashMap<Integer, String> industryList = null;
		try {
			industryList = new HashMap<Integer, String>();
			String industryQuery = QueryMaker.GET_INDUSTRY_LIST;
			connection = getConnection();
			preparedStatement = connection.prepareStatement(industryQuery);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int industryID = resultSet.getInt("BUSINESS_FUNCTION_ID");
				String industryName = resultSet
						.getString("BUSINESS_FUNCTION_NAME");
				industryList.put(industryID, industryName);

			}
			return industryList;
		} catch (Exception exception) {

			log.error(ClientDAOListHelper.class
					+ ": Error:- While getting industry id and industry name From Database.");
		} finally {
			try {
				if (null != connection) {
					resultSet.close();
					preparedStatement.close();
					connection.close();
				}
			} catch (SQLException sqlExp) {
				log.error(ClientDAOListHelper.class
						+ ": Error:- While closing the Connection after getting industry id and industry name From Database.");
			}
		}
		return industryList;
	}

	*//**
	 * designationList method use to fetch designation name and designation ID from
	 * TAB_DESIGNATION table.
	 * 
	 * @return HashMap<Integer, String>
	 * @throws Exception
	 *//*
	public HashMap<Integer, String> designationList() throws Exception {

		HashMap<Integer, String> designationList = null;
		try {
			designationList = new HashMap<Integer, String>();
			String designationQuery = QueryMaker.GET_DESIGNATION_LIST;
			connection = getConnection();
			preparedStatement = connection.prepareStatement(designationQuery);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int designationId = resultSet.getInt("DESIGNATION_ID");
				String designationName = resultSet
						.getString("DESIGNATION_NAME");
				designationList.put(designationId, designationName);

			}
			return designationList;
		} catch (Exception exception) {

			log.error(ClientDAOListHelper.class
					+ ": Error:- While getting designation id and designation name From Database.");
		} finally {
			try {
				if (null != connection) {
					resultSet.close();
					preparedStatement.close();
					connection.close();
				}
			} catch (SQLException sqlExp) {
				log.error(ClientDAOListHelper.class
						+ ": Error:- While closing the Connection after getting designation id and designation name From Database.");
			}
		}
		return designationList;
	}
	*//**
	 * currencyList method use to fetch currency name and currency ID from
	 * TAB_CURRENCY table.
	 * 
	 * @return HashMap<Integer, String>
	 * @throws Exception
	 *//*
	public HashMap<Integer, String> getCompanyList(int companyId) throws Exception {

		HashMap<Integer, String> companyList = null;
		try {
			companyList = new HashMap<Integer, String>();
			String industryQuery = QueryMaker.GET_CLIENT_COMPANY_NAME;
			connection = getConnection();
			preparedStatement = connection.prepareStatement(industryQuery);
			preparedStatement.setInt(1, companyId);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String companyName = resultSet.getString("COMPANY_NAME");
				companyList.put(companyId, companyName);

			}
			return companyList;
		} catch (Exception exception) {

			log.error(ClientDAOListHelper.class
					+ ": Error:- While getting  company ID and company name From Database.");
		} finally {
			try {
				if (null != connection) {
					resultSet.close();
					preparedStatement.close();
					connection.close();
				}
			} catch (SQLException sqlExp) {
				log.error(ClientDAOListHelper.class
						+ ": Error:- While closing the Connection after getting  company ID and company name From Database.");
			}
		}
		return companyList;
	}
	*//**
	 * currencyList method use to fetch currency name and currency ID from
	 * TAB_CURRENCY table.
	 * 
	 * @return HashMap<Integer, String>
	 * @throws Exception
	 *//*
	public HashMap<Integer, String> currencyList() throws Exception {

		HashMap<Integer, String> currencyList = null;
		try {
			currencyList = new HashMap<Integer, String>();
			String industryQuery = QueryMaker.GET_CURRENCY_LIST;
			connection = getConnection();
			preparedStatement = connection.prepareStatement(industryQuery);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int currencyID = resultSet.getInt("CURRENCY_ID");
				String currencyName = resultSet
						.getString("CURRENCY_NAME");
				currencyList.put(currencyID, currencyName);

			}
			return currencyList;
		} catch (Exception exception) {

			log.error(ClientDAOListHelper.class
					+ ": Error:- While getting currency id and currency name From Database.");
		} finally {
			try {
				if (null != connection) {
					resultSet.close();
					preparedStatement.close();
					connection.close();
				}
			} catch (SQLException sqlExp) {
				log.error(ClientDAOListHelper.class
						+ ": Error:- While closing the Connection after getting currency id and currency name From Database.");
			}
		}
		return currencyList;
	}
	*//**
	 * currencyList method use to fetch currency name and currency ID from
	 * TAB_CURRENCY table.
	 * 
	 * @return HashMap<Integer, String>
	 * @throws Exception
	 *//*
	public HashMap<Integer, String> customerList() throws Exception {

		HashMap<Integer, String> currencyList = null;
		try {
			currencyList = new HashMap<Integer, String>();
			String industryQuery = QueryMaker.GET_CURRENCY_LIST;
			connection = getConnection();
			preparedStatement = connection.prepareStatement(industryQuery);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int currencyID = resultSet.getInt("CURRENCY_ID");
				String currencyName = resultSet
						.getString("CURRENCY_NAME");
				currencyList.put(currencyID, currencyName);

			}
			return currencyList;
		} catch (Exception exception) {

			log.error(ClientDAOListHelper.class
					+ ": Error:- While getting currency id and currency name From Database.");
		} finally {
			try {
				if (null != connection) {
					resultSet.close();
					preparedStatement.close();
					connection.close();
				}
			} catch (SQLException sqlExp) {
				log.error(ClientDAOListHelper.class
						+ ": Error:- While closing the Connection after getting currency id and currency name From Database.");
			}
		}
		return currencyList;
	}
	
	*//**
	 * languageList method use to fetch language name and language ID from
	 * TAB_BUSINESS_FUNCTION table.
	 * 
	 * @return HashMap<Integer, String>
	 * @throws Exception
	 *//*
	public HashMap<Integer, String> languageList() throws Exception {

		HashMap<Integer, String> languageList = null;
		try {
			languageList = new HashMap<Integer, String>();
			String languageQuery = QueryMaker.GET_LANGUAGE_LIST;
			connection = getConnection();
			preparedStatement = connection.prepareStatement(languageQuery);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int languageID = resultSet.getInt("LANGUAGE_ID");
				String languageName = resultSet
						.getString("LANGUAGE_NAME");
				languageList.put(languageID, languageName);

			}
			return languageList;
		} catch (Exception exception) {

			log.error(ClientDAOListHelper.class
					+ ": Error:- While getting language id and language name From Database.");
		} finally {
			try {
				if (null != connection) {
					resultSet.close();
					preparedStatement.close();
					connection.close();
				}
			} catch (SQLException sqlExp) {
				log.error(ClientDAOListHelper.class
						+ ": Error:- While closing the Connection after getting language id and language name From Database.");
			}
		}
		return languageList;
	}
	
	
	
	
	*//**
	 * stateList method use to fetch state name and state ID from
	 * TAB_STATE table.
	 * 
	 * @return HashMap<Integer, String>
	 * @throws Exception
	 *//*
	
	public JSONObject stateListByCountryId(int countryId) {

		JSONObject stateList = null;
		try {
			String query = QueryMaker.GET_STATE_LIST;
			connection = getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, countryId);
			resultSet = preparedStatement.executeQuery();
			JSONArray array = new JSONArray();
			stateList = new JSONObject();

			while (resultSet.next()) {
				JSONObject object = new JSONObject();

				int stateID = resultSet.getInt("STATE_ID");
				String stateName = resultSet
						.getString("STATE_NAME");

				object.put("stateID", stateID);
				object.put("stateName", stateName);
				array.add(object);
				// moduleList.put(moduleId, moduleName);
			}
			stateList.put("State", array);
		} catch (Exception exception) {

			log.error(ClientDAOListHelper.class
					+ ": Error:- While getting state id and state name From Database.");
		} finally {
			try {
				if (null != connection) {
					resultSet.close();
					preparedStatement.close();
					connection.close();
				}
			} catch (SQLException sqlExp) {
				log.error(ClientDAOListHelper.class
						+ ": Error:- While closing the Connection after getting state id and state name From Database.");
			}
		}
		return stateList;
	}
	
	
	*//**
	 * stateList method use to fetch state name and state ID from
	 * TAB_STATE table.
	 * 
	 * @return HashMap<Integer, String>
	 * @throws Exception
	 *//*
	
	public HashMap<Integer, String> stateList(int countryId) throws Exception {

		HashMap<Integer, String> stateList = null;
		try {
			stateList = new HashMap<Integer, String>();
			String industryQuery = QueryMaker.GET_STATE_LIST;
			connection = getConnection();
			preparedStatement = connection.prepareStatement(industryQuery);
			preparedStatement.setInt(1, countryId);

			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int stateID = resultSet.getInt("STATE_ID");
				String stateName = resultSet
						.getString("STATE_NAME");
				stateList.put(stateID, stateName);

			}
			return stateList;
		} catch (Exception exception) {

			log.error(ClientDAOListHelper.class
					+ ": Error:- While getting state id and state name From Database.");
		} finally {
			try {
				if (null != connection) {
					resultSet.close();
					preparedStatement.close();
					connection.close();
				}
			} catch (SQLException sqlExp) {
				log.error(ClientDAOListHelper.class
						+ ": Error:- While closing the Connection after getting state id and state name From Database.");
			}
		}
		return stateList;
	}
	*//**
	 * cityList method use to fetch city name and city ID from
	 * TAB_CITY table.
	 * 
	 * @return HashMap<Integer, String>
	 * @throws Exception
	 *//*
	
	
	public JSONObject cityListByStateId(int countryId) {

		JSONObject cityList = null;
		try {
			String query = QueryMaker.GET_CITY_LIST;
			connection = getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, countryId);
			resultSet = preparedStatement.executeQuery();
			JSONArray array = new JSONArray();
			cityList = new JSONObject();

			while (resultSet.next()) {
				JSONObject object = new JSONObject();

				int cityID = resultSet.getInt("CITY_ID");
				String cityName = resultSet
						.getString("CITY_NAME");
				object.put("cityID", cityID);
				object.put("cityName", cityName);
				array.add(object);
				// moduleList.put(moduleId, moduleName);
			}
			cityList.put("City", array);
		} catch (Exception exception) {

			log.error(ClientDAOListHelper.class
					+ ": Error:- While getting city id and city name From Database.");
		} finally {
			try {
				if (null != connection) {
					resultSet.close();
					preparedStatement.close();
					connection.close();
				}
			} catch (SQLException sqlExp) {
				log.error(ClientDAOListHelper.class
						+ ": Error:- While closing the Connection after getting city id and city name From Database.");
			}
		}
		return cityList;
	}
	
	
	
	*//**
	 * cityList method use to fetch city name and city ID from
	 * TAB_CITY table.
	 * 
	 * @return HashMap<Integer, String>
	 * @throws Exception
	 *//*
	
	
	public JSONObject prodDescPrice(int productId) {

		JSONObject productList = null;
		JSONObject object =null;
		try {
			String query = QueryMaker.GET_PRODUCTION_DESC_AND_PRICE_LIST;
			String query = QueryMaker.GET_ITEM_DESC_AND_PRICE_LIST;
			connection = getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, productId);
			resultSet = preparedStatement.executeQuery();
			//JSONArray array = new JSONArray();
			productList = new JSONObject();

			while (resultSet.next()) {
				object= new JSONObject();

				String description = resultSet.getString("SALES_DESCRIPTION");
				String productPrice = resultSet
						.getString("SALES_PRICE");
				
				object.put("description", description);
				object.put("productPrice", productPrice);
				//array.add(object);
				
			}
			productList.put("product", object);
		} catch (Exception exception) {

			log.error(ClientDAOListHelper.class
					+ ": Error:- While getting product Description and Product Price From Database.");
		} finally {
			try {
				if (null != connection) {
					resultSet.close();
					preparedStatement.close();
					connection.close();
				}
			} catch (SQLException sqlExp) {
				log.error(ClientDAOListHelper.class
						+ ": Error:- While closing the Connection after getting product Description and Product Price From Database.");
			}
		}
		return productList;
	}
	
	
	
	public HashMap<Integer, String> cityList(int stateId) throws Exception {

		HashMap<Integer, String> cityList = null;
		try {
			cityList = new HashMap<Integer, String>();
			String industryQuery = QueryMaker.GET_CITY_LIST;
			connection = getConnection();
			preparedStatement = connection.prepareStatement(industryQuery);
			preparedStatement.setInt(1, stateId);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int stateID = resultSet.getInt("CITY_ID");
				String stateName = resultSet
						.getString("CITY_NAME");
				cityList.put(stateID, stateName);

			}
			return cityList;
		} catch (Exception exception) {

			log.error(ClientDAOListHelper.class
					+ ": Error:- While getting city id and city name From Database.");
		} finally {
			try {
				if (null != connection) {
					resultSet.close();
					preparedStatement.close();
					connection.close();
				}
			} catch (SQLException sqlExp) {
				log.error(ClientDAOListHelper.class
						+ ": Error:- While closing the Connection after getting city id and city name From Database.");
			}
		}
		return cityList;
	}
	
	*//**
	 * countryName method use to fetch country name and  from
	 * TAB_COUNTRY table.
	 * 
	 * @return HashMap<Integer, String>
	 * @throws Exception
	 *//*
	public String countryName(int countryId) throws Exception {

		String countryName=null;
		try {
			String countryQuery = QueryMaker.GET_COUNTRY_NAME;
			connection = getConnection();
			preparedStatement = connection.prepareStatement(countryQuery);
			preparedStatement.setInt(1, countryId);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				 countryName = resultSet.getString("COUNTRY_DISPLAY_NAME");
				

			}
		} catch (Exception exception) {

			log.error(ClientDAOListHelper.class
					+ ": Error:- While getting  country name From Database.");
		} finally {
			try {
				if (null != connection) {
					resultSet.close();
					preparedStatement.close();
					connection.close();
				}
			} catch (SQLException sqlExp) {
				log.error(ClientDAOListHelper.class
						+ ": Error:- While closing the Connection after getting  and country name From Database.");
			}
		}
		return countryName;
	}

	*//**
	 * countryName method use to fetch country name and  from
	 * TAB_COUNTRY table.
	 * 
	 * @return HashMap<Integer, String>
	 * @throws Exception
	 *//*
	public String stateName(int stateId) throws Exception {

		String stateName=null;
		try {
			String countryQuery = QueryMaker.GET_STATE_NAME;
			connection = getConnection();
			preparedStatement = connection.prepareStatement(countryQuery);
			preparedStatement.setInt(1, stateId);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				stateName = resultSet.getString("STATE_NAME");
				

			}
		} catch (Exception exception) {

			log.error(ClientDAOListHelper.class
					+ ": Error:- While getting  stateName name From Database.");
		} finally {
			try {
				if (null != connection) {
					resultSet.close();
					preparedStatement.close();
					connection.close();
				}
			} catch (SQLException sqlExp) {
				log.error(ClientDAOListHelper.class
						+ ": Error:- While closing the Connection after getting  and stateName name From Database.");
			}
		}
		return stateName;
	}
	*//**
	 * countryName method use to fetch country name and  from
	 * TAB_COUNTRY table.
	 * 
	 * @return HashMap<Integer, String>
	 * @throws Exception
	 *//*
	public String cityName(int cityId) throws Exception {

		String cityName=null;
		try {
			String countryQuery = QueryMaker.GET_CITY_NAME;
			connection = getConnection();
			preparedStatement = connection.prepareStatement(countryQuery);
			preparedStatement.setInt(1, cityId);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				cityName = resultSet.getString("CITY_NAME");
				

			}
		} catch (Exception exception) {

			log.error(ClientDAOListHelper.class
					+ ": Error:- While getting  city Name  From Database.");
		} finally {
			try {
				if (null != connection) {
					resultSet.close();
					preparedStatement.close();
					connection.close();
				}
			} catch (SQLException sqlExp) {
				log.error(ClientDAOListHelper.class
						+ ": Error:- While closing the Connection after getting  and city name From Database.");
			}
		}
		return cityName;
	}
	public String designationName(int designationId) throws Exception {

		String designationName=null;
		try {
			String countryQuery = QueryMaker.GET_DESIGNATION_NAME;
			connection = getConnection();
			preparedStatement = connection.prepareStatement(countryQuery);
			preparedStatement.setInt(1, designationId);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				designationName = resultSet.getString("DESIGNATION_NAME");
				

			}
		} catch (Exception exception) {

			log.error(ClientDAOListHelper.class
					+ ": Error:- While getting  designation name From Database.");
		} finally {
			try {
				if (null != connection) {
					resultSet.close();
					preparedStatement.close();
					connection.close();
				}
			} catch (SQLException sqlExp) {
				log.error(ClientDAOListHelper.class
						+ ": Error:- While closing the Connection after getting  and designation name From Database.");
			}
		}
		return designationName;
	}
	*//**
	 * DepartmentName method use to fetch country name and  from
	 * TAB_COUNTRY table.
	 * 
	 * @return HashMap<Integer, String>
	 * @throws Exception
	 *//*
	public String departmentName(int departmentId) throws Exception {

		String departmentName=null;
		try {
			String countryQuery = QueryMaker.GET_DEPARTMENT_NAME;
			connection = getConnection();
			preparedStatement = connection.prepareStatement(countryQuery);
			preparedStatement.setInt(1, departmentId);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				departmentName = resultSet.getString("DEPARTMENT_NAME");
				

			}
		} catch (Exception exception) {

			log.error(ClientDAOListHelper.class
					+ ": Error:- While getting  department name From Database.");
		} finally {
			try {
				if (null != connection) {
					resultSet.close();
					preparedStatement.close();
					connection.close();
				}
			} catch (SQLException sqlExp) {
				log.error(ClientDAOListHelper.class
						+ ": Error:- While closing the Connection after getting  and department name From Database.");
			}
		}
		return departmentName;
	}
	*//**
	 * countryName method use to fetch country name and  from
	 * TAB_COUNTRY table.
	 * 
	 * @return HashMap<Integer, String>
	 * @throws Exception
	 *//*
	public String companyTypeName(int companyTypeId) throws Exception {

		String companyTypeName=null;
		try {
			String countryQuery = QueryMaker.GET_COMPANY_TYPE_NAME;
			connection = getConnection();
			preparedStatement = connection.prepareStatement(countryQuery);
			preparedStatement.setInt(1, companyTypeId);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				companyTypeName = resultSet.getString("COMPANY_TYPE_NAME");
				

			}
		} catch (Exception exception) {

			log.error(ClientDAOListHelper.class
					+ ": Error:- While getting  companyType name From Database.");
		} finally {
			try {
				if (null != connection) {
					resultSet.close();
					preparedStatement.close();
					connection.close();
				}
			} catch (SQLException sqlExp) {
				log.error(ClientDAOListHelper.class
						+ ": Error:- While closing the Connection after getting  and companyType name From Database.");
			}
		}
		return companyTypeName;
	}
	*//**
	 * countryName method use to fetch country name and  from
	 * TAB_COUNTRY table.
	 * 
	 * @return HashMap<Integer, String>
	 * @throws Exception
	 *//*
	public String industryName(int industryId) throws Exception {

		String industryName=null;
		try {
			String countryQuery = QueryMaker.GET_INDUSTRY_NAME;
			connection = getConnection();
			preparedStatement = connection.prepareStatement(countryQuery);
			preparedStatement.setInt(1, industryId);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				industryName = resultSet.getString("BUSINESS_FUNCTION_NAME");
				

			}
		} catch (Exception exception) {

			log.error(ClientDAOListHelper.class
					+ ": Error:- While getting  industry name From Database.");
		} finally {
			try {
				if (null != connection) {
					resultSet.close();
					preparedStatement.close();
					connection.close();
				}
			} catch (SQLException sqlExp) {
				log.error(ClientDAOListHelper.class
						+ ": Error:- While closing the Connection after getting  and industry name From Database.");
			}
		}
		return industryName;
	}
	*//**
	 * countryName method use to fetch country name and  from
	 * TAB_COUNTRY table.
	 * 
	 * @return HashMap<Integer, String>
	 * @throws Exception
	 *//*
	public String currencyName(int currencyId) throws Exception {

		String currencyName=null;
		try {
			String currencyQuery = QueryMaker.GET_CURRENCY_NAME;
			connection = getConnection();
			preparedStatement = connection.prepareStatement(currencyQuery);
			preparedStatement.setInt(1, currencyId);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				currencyName = resultSet.getString("CURRENCY_NAME");
				

			}
		} catch (Exception exception) {

			log.error(ClientDAOListHelper.class
					+ ": Error:- While getting  currency name From Database.");
		} finally {
			try {
				if (null != connection) {
					resultSet.close();
					preparedStatement.close();
					connection.close();
				}
			} catch (SQLException sqlExp) {
				log.error(ClientDAOListHelper.class
						+ ": Error:- While closing the Connection after getting  and currency name From Database.");
			}
		}
		return currencyName;
	}
	
	*//**
	 * languageName method use to fetch country name and  from
	 * TAB_COUNTRY table.
	 * 
	 * @return HashMap<Integer, String>
	 * @throws Exception
	 *//*
	public String languageName(int languageId) throws Exception {

		String languageName=null;
		try {
			String countryQuery = QueryMaker.GET_LANGUAGE_NAME;
			connection = getConnection();
			preparedStatement = connection.prepareStatement(countryQuery);
			preparedStatement.setInt(1, languageId);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				languageName = resultSet.getString("LANGUAGE_NAME");
				

			}
		} catch (Exception exception) {

			log.error(ClientDAOListHelper.class
					+ ": Error:- While getting  language name From Database.");
		} finally {
			try {
				if (null != connection) {
					resultSet.close();
					preparedStatement.close();
					connection.close();
				}
			} catch (SQLException sqlExp) {
				log.error(ClientDAOListHelper.class
						+ ": Error:- While closing the Connection after getting  and language name From Database.");
			}
		}
		return languageName;
	}
*/
	/**
	 * clientList method use to fetch client name and client ID from
	 * CLIENT_DETAILS table.
	 * 
	 * @return HashMap<Integer, String>
	 * @throws Exception
	 */
	public HashMap<Integer, String> clientList() throws Exception {

		HashMap<Integer, String> clientlist = null;
		try {
			clientlist = new HashMap<Integer, String>();
			String departmentQuery = QueryMaker.GET_CLIENT_LIST;
			connection = getConnection();
			preparedStatement = connection.prepareStatement(departmentQuery);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int clientID = resultSet.getInt("CLIENT_ID");
				String firstName = resultSet
						.getString("FIRST_NAME");
				String lastName = resultSet
						.getString("LAST_NAME");
				String clientName=firstName+" "+lastName;
				clientlist.put(clientID, clientName);

			}
			return clientlist;
		} catch (Exception exception) {

			log.error(ClientDAOListHelper.class
					+ ": Error:- While getting client id and client name From Database.");
		} finally {
			try {
				if (null != connection) {
					resultSet.close();
					preparedStatement.close();
					connection.close();
				}
			} catch (SQLException sqlExp) {
				log.error(ClientDAOListHelper.class
						+ ": Error:- While closing the Connection after getting client id and client name From Database.");
			}
		}
		return clientlist;
	}

	/*public JSONObject getTotalTax(int taxId) {
		public JSONObject prodDescPrice(int productId) {

			JSONObject taxTotalValue = null;
			JSONObject object =null;
			try {
				String query = QueryMaker.GET_TOTALTAX_BY_TAX_ID;
				connection = getConnection();
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setInt(1, taxId);
				resultSet = preparedStatement.executeQuery();
				//JSONArray array = new JSONArray();
				taxTotalValue = new JSONObject();

				while (resultSet.next()) {
					object= new JSONObject();

					String totalTax = resultSet.getString("TAX_TOTAL");
					
					object.put("totalTax", totalTax);
				
					
				}
				taxTotalValue.put("Tax", object);
			} catch (Exception exception) {

				log.error(ClientDAOListHelper.class
						+ ": Error:- While getting total tax value From Database.");
			} finally {
				try {
					if (null != connection) {
						resultSet.close();
						preparedStatement.close();
						connection.close();
					}
				} catch (SQLException sqlExp) {
					log.error(ClientDAOListHelper.class
							+ ": Error:- While closing the Connection after getting total tax value From Database.");
				}
			}
			return taxTotalValue;
		}
		
	}*/

}