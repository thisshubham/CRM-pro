package com.bst.ckt.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bst.ckt.dto.Product;
import com.bst.ckt.dto.Transport;
import com.bst.ckt.exception.OMIApplicationException;
import com.bst.ckt.vo.ProductVO;
import com.bst.ckt.vo.TransportVO;

public interface TransportDaoInf {

	void TransportRequest(TransportVO transportVO)throws Exception;
	
	
	List<TransportVO> getTransportDetails(TransportVO transportVO) throws Exception;

	 public int deleteTransportDetails(int transportId)throws Exception;


	 Transport retriveTransportFullDetailGrid(int transportId);
	 
	 

	  void generateTransportPdf(HttpServletRequest request, HttpServletResponse response, int transportId) throws Exception;

		public Transport editTransportDetail(Transport transport, int transportId)throws Exception;
		
		public int updateTransportDetail(TransportVO transportVO, int transportId)throws Exception ;
		
		
		public int gettransportLastRecord()throws OMIApplicationException;

		public Transport getTransportDetails(int transportId)throws OMIApplicationException;  

		
		
		
		
		
}
