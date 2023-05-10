package com.bst.ckt.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.bst.ckt.common.LoginUtil;
import com.bst.ckt.common.OMIConstants;
import com.bst.ckt.dao.ExcelReportDaoImpl;
import com.bst.ckt.dao.ExcelReportDaoInf;
import com.bst.ckt.dao.ProductDaoImpl;
import com.bst.ckt.dao.ProductDaoInf;
import com.bst.ckt.dao.TransportDaoImpl;
import com.bst.ckt.dao.TransportDaoInf;
import com.bst.ckt.dto.Product;
import com.bst.ckt.dto.Transport;
import com.bst.ckt.exception.OMIApplicationException;
import com.bst.ckt.vo.ProductVO;
import com.bst.ckt.vo.TransportVO;

public class TransportServiceImpl implements TransportServiceInf {

	private static final Logger logger = Logger.getLogger(TransportServiceImpl.class);
	
	
	TransportDaoInf transportDaoInf=new TransportDaoImpl();
	ExcelReportDaoInf excelReportDaoInf = new ExcelReportDaoImpl();
	
	public void TransportRequest(TransportVO transportVO)
			throws Exception {
		
		TransportDaoInf TransportDaoInf=new TransportDaoImpl();
		
		TransportDaoInf.TransportRequest(transportVO);
	}

	
	public List<TransportVO> retriveTransportDetailsGrid(TransportVO transportVO)
			throws Exception {
		TransportDaoInf transportDaoInf=new TransportDaoImpl();
		
		return transportDaoInf.getTransportDetails(transportVO);
	}
	
	
	public int deleteTransportDetail(int transportId) throws Exception{
		
		int target=transportDaoInf.deleteTransportDetails(transportId);
	return target;	
	}

	
	
	public Transport retriveTransportFullDetailGrid(int transportId)
	 {
		Transport transport=null;
		TransportDaoInf transportDaoInf = new TransportDaoImpl();
		transport = transportDaoInf.retriveTransportFullDetailGrid(transportId);
return transport;
	 }
	
	
	public void transportPrintPDF(HttpServletRequest request,
			HttpServletResponse response, int transportId) throws Exception{
		TransportDaoInf transportDaoInf = new TransportDaoImpl();
		transportDaoInf.generateTransportPdf(request,response,transportId);
	}
	
	

	public Transport editTransportDetails(int transportId)
			throws Exception {
		TransportDaoInf transportDaoInf = new TransportDaoImpl();
		Transport transport = new Transport();
		try {
			transport = transportDaoInf.editTransportDetail(transport,transportId);
			
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return transport;
	}

	
	public String updateTransportDetails(TransportVO transportVO, int transportId)
			throws Exception {
		TransportDaoInf transportDaoInf = new TransportDaoImpl();
		int target=transportDaoInf.updateTransportDetail(transportVO,transportId);
		if (target == 1) {
			logger.info("Successfully Update Transport Information!");
			return OMIConstants.TARGET_SUCCESS;
		} else {

			logger.info("Error:while  Updating Transport Information!");
			return OMIConstants.TARGET_FAILURE;
		}

		
	}

	public void transportExcelReport(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		excelReportDaoInf.retriveTransportExcelReport(request, response);
		
	}
	
		
	
	
	
	public Transport viewNextTransportDetails(int transportId)
			throws OMIApplicationException {
		Transport transport = null;
		try {
			transportId++;
			if (transportDaoInf.gettransportLastRecord() < transportId) {
				transportId = 0;
				LoginUtil.setProcessUserId(transportId);
				transport = new Transport();
				transport.setTransportId(0);
				return transport;
			} else {
				LoginUtil.setProcessUserId(transportId);
				transport = transportDaoInf.getTransportDetails(transportId);
				if (transport.getTransportId() == 0) {
					transportId = LoginUtil.getProcessUserId();
					LoginUtil.setProcessUserId(transportId);
					return transport;
				}
				transport = transportDaoInf.getTransportDetails(transportId);
			}

		} catch (Exception exception) {
			logger.error("no records found" + exception);
		}
		return transport;
	}

	
	
	
	
	
	
	public Transport viewPreviousTransportDetails(int transportId)
			throws OMIApplicationException {
		Transport transport=null;
		try {
			transportId--;
			LoginUtil.setProcessUserId(transportId);
			transport = transportDaoInf.getTransportDetails(transportId);
			if (transport.getTransportId() == 0) {
				transportId = LoginUtil.getProcessUserId();
				LoginUtil.setProcessUserId(transportId);
				return transport;
			}
			transport = transportDaoInf.getTransportDetails(transportId);

		} catch (Exception exception) {
			logger.error("no records found" + exception);
		}
		return transport;
	
	}

	
}


