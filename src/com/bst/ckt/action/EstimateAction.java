package com.bst.ckt.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.json.simple.JSONObject;

import com.bst.ckt.common.LoginUtil;
import com.bst.ckt.common.OMIConstants;
import com.bst.ckt.dao.EstimateDaoImpl;
import com.bst.ckt.dao.EstimateDaoInf;
import com.bst.ckt.exception.CreateFailedException;
import com.bst.ckt.exception.RecordNotFoundException;
import com.bst.ckt.exception.UpdateFailedException;
import com.bst.ckt.framework.util.DateTimeUtil;
import com.bst.ckt.helper.ClientDAOListHelper;
import com.bst.ckt.helper.ListHelper;
import com.bst.ckt.service.EstimateServiceImpl;
import com.bst.ckt.service.EstimateServiceInf;
import com.bst.ckt.vo.EstimateVO;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class EstimateAction extends ActionSupport implements
ModelDriven<EstimateVO>,ServletRequestAware,ServletResponseAware {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map<Integer, String> currencyList;
	/*private Map<Integer, String> customerList;*/
	private Map<Integer, String> clientList;
	private Map<Integer, String> productList;
	private List<EstimateVO> estimateList=null;
	private Map<Float, Float> taxList=null;

	EstimateDaoInf estimateDaoInf=null;
	EstimateDaoImpl daoImpl = null;
	EstimateVO estimateVO = new EstimateVO();
	ClientDAOListHelper clientDAOListHelper = null;
	ListHelper listHelper = null;
	EstimateServiceInf estimateServiceInf=null;
	String result=OMIConstants.TARGET_INPUT;
	HttpServletRequest request = null;
	HttpServletResponse response=null;
	List<EstimateVO> listEstimateItems = new ArrayList<EstimateVO>();
	
	
	public EstimateAction() throws Exception {
		estimateDaoInf=new EstimateDaoImpl();
		
		//commonTaxList=new CommonTaxList();
		clientDAOListHelper = new ClientDAOListHelper();
		listHelper = new ListHelper();
		/*currencyList = clientDAOListHelper.currencyList();
		clientList=clientDAOListHelper.clientList();*/
		currencyList = listHelper.currencyList();
		clientList=clientDAOListHelper.clientList();
		productList=listHelper.productList();
		//taxList=listHelper.taxList();
		
	}

	@Override
	public String execute() throws Exception {
		daoImpl = new EstimateDaoImpl();
		System.out.println("here is the firstname");
		String firstName = LoginUtil.getCurrentCustomerUser().getFullName();
		System.out.println("here is the firstname"+firstName);
		String lastName = LoginUtil.getCurrentCustomerUser().getFullName();
		String firstNameLetter = String.valueOf(firstName.charAt(0));
		String secondNameLetter = String.valueOf(lastName.charAt(0));
		//int countryId = daoImpl.getCountryId(LoginUtil.getCurrentUser().getUserId());
		int countryId = daoImpl.getCountryId(LoginUtil.getCurrentCustomerUser().getCustomerId());
		String countryCode = daoImpl.countryCodeByClient(countryId);
		String currentDate = DateTimeUtil.getCurrentDate();
		String date[] = currentDate.split("-");
		String dateString = "";
		for (int i = date.length - 1; i >= 0; i--) {

			String dateString1 = date[i];
			dateString = dateString + dateString1;
		}

		String estimateId = firstNameLetter.toUpperCase()
				+ secondNameLetter.toUpperCase() + "/" + countryCode + "/"
				+ dateString + "/" + LoginUtil.getCurrentCustomerUser().getCustomerId();

		estimateVO.setEstimateId(estimateId);

		return SUCCESS;
	}

	public String addEstimate() throws CreateFailedException, UpdateFailedException
	{
		
		estimateServiceInf=new EstimateServiceImpl();
		System.out.println(LoginUtil.getCurrentCustomerUser().getCustomerId()+"hey bharti loginutill workin");
		result=estimateServiceInf.service(estimateVO, LoginUtil.getCurrentCustomerUser().getCustomerId());
		if(result.equals(OMIConstants.RESULT_SUCCESS))
		{
			System.out.println("hey bharti ))))))))" );
			addActionMessage("Estimate Details inserted successfuly..");
			return SUCCESS;
			
		}
		else 
		{
			addActionError("Estimate Details did not insert into database");
		return	INPUT;
		}
	}
	
	public void getProdDscAndPrice() throws IOException {
		try {

			JSONObject descAndPrice = new JSONObject();

			int productId = Integer.parseInt(request.getParameter("productId"));

			listHelper = new ListHelper();
			descAndPrice = listHelper.prodDescPrice(productId);

			PrintWriter out = response.getWriter();

			out.print(descAndPrice);
		} catch (Exception exception) {

			System.out.println(exception);
		}

	}
	public void getProductJASONList() throws IOException {
		try {
			JSONObject productList = new JSONObject();
			JSONObject taxList = new JSONObject();

			productList = estimateDaoInf.productListJSON();
			taxList = estimateDaoInf.taxListJSON();

			productList.put("taxList", taxList);

			PrintWriter out = response.getWriter();

			out.print(productList);

		} catch (Exception exception) {

			System.out.println(exception);
		}

	}
	public String estimateGrid()throws Exception
	{
		System.out.println("hey ur  inn grid @@@@");
		estimateServiceInf=new EstimateServiceImpl();
		this.estimateList=estimateServiceInf.getEstimateDetails(estimateVO);
		
		System.out.println(estimateList.get(estimateVO.getClientId())+"hoooooooooo");
		return SUCCESS;
	}
	
	/*public String editEstimate()
	{
		int estimateId = Integer.parseInt(request.getParameter("command"));
		System.out.println("estimateId"+estimateId);
		try {
		 estimateVO =	estimateDaoInf.editEstimate(estimateId);
		 listEstimateItems = estimateDaoInf.editEstimateItems(estimateVO.getId());
		
		} catch (Exception e) {
			
		}
		return SUCCESS;
		
	}*/
	
	/*public String pdfEstimate()
	{
		int estimateId = Integer.parseInt(request.getParameter("command"));
		System.out.println("estimateId"+estimateId);
		estimateServiceInf=new EstimateServiceImpl();
		try {
		 estimateVO =	estimateDaoInf.editEstimate(estimateId);
		 listEstimateItems = estimateDaoInf.editEstimateItems(estimateVO.getId());
		 estimateServiceInf.generatePdfReport(estimateVO,listEstimateItems,response);
		 
		
		} catch (Exception e) {
			System.out.println(e);
		}
		return SUCCESS;
		
	}*/
	
	public String viewEstimate()
	{
		int estimateId = Integer.parseInt(request.getParameter("command"));
		System.out.println("estimateId"+estimateId);
		try {
			estimateServiceInf=new EstimateServiceImpl();
		this.estimateVO =	estimateServiceInf.viewEstimate(estimateId);
		 listEstimateItems = estimateServiceInf.viewEstimateItems(estimateVO.getId());
		
		} catch (Exception e) {
			
		}
		return SUCCESS;
		
	}
	
	
	/**
	 * @return the currencyList
	 */
	public Map<Integer, String> getCurrencyList() {
		return currencyList;
	}

	/**
	 * @param currencyList
	 *            the currencyList to set
	 */
	public void setCurrencyList(Map<Integer, String> currencyList) {
		this.currencyList = currencyList;
	}

	/**
	 * @return the customerList
	 */
	/**
	 * @return the customerList
	 */
	/*public Map<Integer, String> getCustomerList() {
		return customerList;
	}

	*//**
	 * @param customerList
	 *            the customerList to set
	 *//*
	public void setCustomerList(Map<Integer, String> customerList) {
		this.customerList = customerList;
	}
*/
	public EstimateVO getModel() {
		return estimateVO;
	}

	public Map<Integer, String> getClientList() {
		return clientList;
	}

	public void setClientList(Map<Integer, String> clientList) {
		this.clientList = clientList;
	}

	/**
	 * @return the addEstimateVO
	 */
	public EstimateVO getAddEstimateVO() {
		return estimateVO;
	}

	/**
	 * @param addEstimateVO
	 *            the addEstimateVO to set
	 */
	public void setAddEstimateVO(EstimateVO addEstimateVO) {
		this.estimateVO = addEstimateVO;
	}

	/**
	 * @return the productList
	 */
	public Map<Integer, String> getProductList() {
		return productList;
	}

	/**
	 * @param productList the productList to set
	 */
	public void setProductList(Map<Integer, String> productList) {
		this.productList = productList;
	}

	/**
	 * @return the estimateList
	 */
	public List<EstimateVO> getEstimateList() {
		return estimateList;
	}

	/**
	 * @param estimateList the estimateList to set
	 */
	public void setEstimateList(List<EstimateVO> estimateList) {
		this.estimateList = estimateList;
	}


	/**
	 * @return the taxList
	 */
	public Map<Float, Float> getTaxList() {
		return taxList;
	}

	/**
	 * @param taxList the taxList to set
	 */
	public void setTaxList(Map<Float, Float> taxList) {
		this.taxList = taxList;
	}

	public void setServletRequest(HttpServletRequest request) {
		
		this.request = request;
	}

	/**
	 * @return the estimateVO
	 */
	public EstimateVO getEstimateVO() {
		return estimateVO;
	}

	/**
	 * @param estimateVO the estimateVO to set
	 */
	public void setEstimateVO(EstimateVO estimateVO) {
		this.estimateVO = estimateVO;
	}

	/**
	 * @return the listEstimateItems
	 */
	public List<EstimateVO> getListEstimateItems() {
		return listEstimateItems;
	}

	/**
	 * @param listEstimateItems the listEstimateItems to set
	 */
	public void setListEstimateItems(List<EstimateVO> listEstimateItems) {
		this.listEstimateItems = listEstimateItems;
	}

	public void setServletResponse(HttpServletResponse response) {
		this.response=response;
		
	}
	
	
	public String deleteEstimate() throws RecordNotFoundException
	{
		estimateServiceInf=new EstimateServiceImpl();
		int estimateId = Integer.parseInt(request.getParameter("command"));
		try {
			estimateServiceInf.deleteEstimateDetails(estimateId);
		
		} catch (Exception e) {
			
		}
		return SUCCESS;
		
	}
	
}
