package com.bst.ckt.service;

import java.util.List;


import com.bst.ckt.dto.Payment;
import com.bst.ckt.dto.Transport;
import com.bst.ckt.vo.PaymentVO;
import com.bst.ckt.vo.TransportVO;

public interface PaymentServiceInf {

	
void PaymentRequest(PaymentVO paymentVO)throws Exception;
	
	List<PaymentVO> retrivePaymentDetailsGrid(PaymentVO paymentVO)
			throws Exception;

	public Payment editPaymentDetails(int pyamentID)throws Exception;

	public String updatePaymentDetails(PaymentVO paymentVO, int pyamentID)throws Exception ;

	public int deletePaymentDetail(int pyamentID) throws Exception;

	
	
}
