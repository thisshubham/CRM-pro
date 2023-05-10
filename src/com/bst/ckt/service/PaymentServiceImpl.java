package com.bst.ckt.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.bst.ckt.common.OMIConstants;
import com.bst.ckt.dao.ExcelReportDaoImpl;
import com.bst.ckt.dao.ExcelReportDaoInf;
import com.bst.ckt.dao.PaymentDaoImpl;
import com.bst.ckt.dao.PaymentDaoInf;
import com.bst.ckt.dao.TransportDaoImpl;
import com.bst.ckt.dao.TransportDaoInf;
import com.bst.ckt.dto.Payment;
import com.bst.ckt.dto.Transport;
import com.bst.ckt.vo.PaymentVO;
import com.bst.ckt.vo.TransportVO;


public class PaymentServiceImpl implements PaymentServiceInf{

	PaymentDaoInf paymentDaoInf=new PaymentDaoImpl();
	
	
private static final Logger logger = Logger.getLogger(TransportServiceImpl.class);
	
	

	
	public void PaymentRequest(PaymentVO paymentVO)
			throws Exception {
		
		PaymentDaoInf paymentDaoInf=new PaymentDaoImpl();
		
		paymentDaoInf.PaymentRequest(paymentVO);
	}

	
	public List<PaymentVO> retrivePaymentDetailsGrid(PaymentVO paymentVO)
			throws Exception {
		PaymentDaoInf paymentDaoInf=new PaymentDaoImpl();
		
		return paymentDaoInf.getPaymentDetails(paymentVO);
	}
	



public Payment editPaymentDetails(int pyamentID)
		throws Exception {
	PaymentDaoInf paymentDaoInf=new PaymentDaoImpl();
	Payment payment = new Payment();
	try {
		payment = paymentDaoInf.editPaymentDetail(payment,pyamentID);
		
	} catch (Exception exception) {
		exception.printStackTrace();
	}
	return payment;
}


public String updatePaymentDetails(PaymentVO paymentVO, int pyamentID)
		throws Exception {
	PaymentDaoInf paymentDaoInf=new PaymentDaoImpl();
	int target=paymentDaoInf.updatePaymentDetail(paymentVO,pyamentID);
	if (target == 1) {
		logger.info("Successfully Update payment Information!");
		return OMIConstants.TARGET_SUCCESS;
	} else {

		logger.info("Error:while  Updating payment Information!");
		return OMIConstants.TARGET_FAILURE;
	}

	
}

	

public int deletePaymentDetail(int pyamentID) throws Exception{
		
		int target=paymentDaoInf.deletePaymentDetails(pyamentID);
	return target;	
	}	
	
}
