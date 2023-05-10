package com.bst.ckt.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bst.ckt.dto.Product;
import com.bst.ckt.dto.Transport;
import com.bst.ckt.exception.OMIApplicationException;
import com.bst.ckt.vo.ProductVO;
import com.bst.ckt.vo.TransportVO;

public interface TransportServiceInf {

	void TransportRequest(TransportVO transportVO)throws Exception;
	
	List<TransportVO> retriveTransportDetailsGrid(TransportVO transportVO)
			throws Exception;

	public int deleteTransportDetail(int transportId) throws Exception;

	Transport retriveTransportFullDetailGrid(int transportId);

	public void transportPrintPDF(HttpServletRequest request, HttpServletResponse response, int transportId) throws Exception;

	public Transport editTransportDetails(int transportId)throws Exception;

	public String updateTransportDetails(TransportVO transportVO, int transportId)throws Exception ;
	
	void transportExcelReport(HttpServletRequest request,
			HttpServletResponse response)throws Exception;
	
	public Transport viewNextTransportDetails(int transportId)throws OMIApplicationException;
	
	public Transport viewPreviousTransportDetails(int transportId)throws OMIApplicationException;
	
}
