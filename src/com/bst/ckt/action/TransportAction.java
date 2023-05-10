package com.bst.ckt.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.bst.ckt.common.LoginUtil;
import com.bst.ckt.common.OMIConstants;
import com.bst.ckt.dao.TransportDaoImpl;
import com.bst.ckt.dao.TransportDaoInf;
import com.bst.ckt.exception.OMIApplicationException;
import com.bst.ckt.helper.ListHelper;
import com.bst.ckt.helper.NameHelper;
import com.bst.ckt.helper.VOMapperHelper;
import com.bst.ckt.service.TransportServiceImpl;
import com.bst.ckt.service.TransportServiceInf;
import com.bst.ckt.vo.TransportVO;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


public class TransportAction extends ActionSupport implements
ModelDriven<TransportVO>,ServletRequestAware,ServletResponseAware {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	private static final Logger logger = Logger.getLogger(TransportAction.class);

	private static final String transportId =null;

	ListHelper listHelper = new ListHelper();
	NameHelper nameHelper=new NameHelper();
	HttpServletResponse response = null;
	HttpServletRequest request = (HttpServletRequest) ActionContext
			.getContext().get(ServletActionContext.HTTP_REQUEST);
	
	
	TransportVO transportVO = new TransportVO();

	TransportServiceInf transportServiceInf= new TransportServiceImpl();
	
	private List<TransportVO> transportDetailsList  = null;	
	
	TransportDaoInf transportDaoInf = new TransportDaoImpl();
	
	
	
	
	
	public String  TransportRequest() throws Exception{
		
		System.out.println("..............ActionClass........");
			TransportServiceInf TransportServiceInf= new TransportServiceImpl();
			
			TransportServiceInf.TransportRequest(transportVO);
			
			
			return SUCCESS;
		

	}


	
	public String TransportDetailsGrid() throws Exception {

		TransportServiceInf  transportServiceInf= new  TransportServiceImpl();
		transportDetailsList = transportServiceInf.retriveTransportDetailsGrid(transportVO);
		
		
		if ( transportDetailsList == null) {
			logger.error("Error:While getting transport details as per advance search.");
			addActionError("No records found.");
			return ERROR;
		} else {
			logger.info("Records found successfully.");
			return SUCCESS;
		}
		  	}

	
	
	public String deleteTransportDetails() throws Exception{
		
		try {
			
			int transportId = Integer.parseInt(request.getParameter("command"));
			System.out.println(transportId+"we r in delete saiyam");
			transportServiceInf.deleteTransportDetail(transportId);
			return SUCCESS;
			
			} catch (Exception exception ) {
				
				logger.error("ERROR:Erroe while delete Transport details from database.");
				return ERROR;
			}
		
		
		
	}

	
	public String retrivedTransportDetails() throws Exception{
		System.out.println("___________ACTIONCLASS______");
		String id = request.getParameter("command");
		int transportId=Integer.parseInt(id);
		LoginUtil.setProcessUserId(transportId);
		System.out.println(transportId);
		TransportServiceInf transportServiceInf = new TransportServiceImpl();
		this.transportVO = VOMapperHelper.getTransportVOFromTransport(transportVO, transportServiceInf.retriveTransportFullDetailGrid(transportId));
		System.out.println("City ::  "+transportVO.getTransportName());
		return SUCCESS;
	}


	
	

public String transportPrintPDF() throws Exception {
	System.out.println("ttttttttttttttttttttttttttttttttttttttttttttttttttttttttttt");
	int transportId = LoginUtil.getProcessUserId();
	System.out.println(transportId+"OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
	TransportServiceInf transportServiceInf = new TransportServiceImpl();
	transportServiceInf.transportPrintPDF(request, response, transportId);
	return null;
}

	
	
	
public String editTransportDetails() throws Exception {
	
	try {
		int transportId = Integer.parseInt(request.getParameter("command"));
		
		LoginUtil.setProcessUserId(transportId);
		System.out.println("FFFFFFFFFFFFFFFF"+transportId);
		transportServiceInf = new TransportServiceImpl();
		this.transportVO = VOMapperHelper.gettransportFromTransport(transportVO,
				transportServiceInf.editTransportDetails(transportId));

		return SUCCESS;
	} catch (NullPointerException exception) {
		logger.error("Fail to get edit transport details ! ", exception);
		return ERROR;
	}
}


public String updateTransportDetails() throws Exception {

	
	int transportId = LoginUtil.getProcessUserId();
	System.out.println("FFFFFFFFFFFFFFFF"+transportId);
	String message = transportServiceInf.updateTransportDetails(transportVO, transportId);

	if (OMIConstants.TARGET_SUCCESS.equalsIgnoreCase(message)) {

		logger.info("Successfully Updated Transport Information!");
		addActionMessage("Successfully Updated Transport Information!");
		return SUCCESS;

	} else if (OMIConstants.TARGET_FAILURE.equalsIgnoreCase(message)) {

		logger.info("Error:while  Updating Transport Information!");
		addActionError("Error:while  Updating Transport Information!");
		return ERROR;
	}
	else  {
		logger.info("Error:while  Updation Transport Details!");
		addActionError("Error:while  Updation Transport Details!");
		return ERROR;
	}
}


public String excelReportTransport() throws Exception {
	transportServiceInf.transportExcelReport(request, response);
	return NONE;
}



public String nextViewTransport() throws Exception {
	int transportId = LoginUtil.getProcessUserId();
	this.transportVO = VOMapperHelper.gettransportFromTransport(transportVO,
			transportServiceInf.viewNextTransportDetails(transportId));
	

	if (transportVO.getTransportId() != 0) {
		logger.info("Transport details found successfully for Transport Id  "
				+ transportVO.getTransportId());
		addActionMessage("Transport details found successfully for Transport Id "
				+ transportVO.getTransportId());
		return SUCCESS;
	} else {
		transportVO.setTransportId(LoginUtil.getProcessUserId());
		logger.error("Transport details not found for Transport Id  "
				+ transportVO.getTransportId());
		addActionError("Transport details not found for Transport Id "
				+ transportVO.getTransportId());
		return ERROR;

	}
}


public String previousViewTransport() throws OMIApplicationException {
	int transportId = LoginUtil.getProcessUserId();
	this.transportVO = VOMapperHelper.gettransportFromTransport(transportVO,
			transportServiceInf.viewPreviousTransportDetails(transportId));
	
	System.out.println("Transport id =" + transportVO.getTransportId());
	if (transportVO.getTransportId() != 0) {
		logger.info("Transport details found successfully for Transport Id  "
				+ transportVO.getTransportId());
		addActionMessage("Transport details found successfully for Transport Id "
				+ transportVO.getTransportId());
		return SUCCESS;
	} else if (LoginUtil.getProcessUserId() == -1) {
		LoginUtil.setProcessUserId(transportDaoInf.gettransportLastRecord() + 1);
		logger.error("Transport details not found");
		addActionError("Transport details not found");
		return ERROR;
	} else {
		transportVO.setTransportId(LoginUtil.getProcessUserId());
		logger.error("Transport details not found for Transport Id  "
				+ transportVO.getTransportId());
		addActionError("Transport details not found for Transport Id "
				+ transportVO.getTransportId());
		return ERROR;

	}

}













	
public List<TransportVO> getTransportDetailsList() {
	return  transportDetailsList;
}

public void setTransportDetailsList(List<TransportVO>  transportDetailsList) {
	this. transportDetailsList =  transportDetailsList;
}


  
public void setSession(Map<String, Object> arg0) {
	// TODO Auto-generated method stub
	
}

	
	
	
	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public TransportVO getModel() {
		// TODO Auto-generated method stub
		return this.transportVO;
	}

	
}
