package com.bst.ckt.dao;

import java.util.List;

import com.bst.ckt.dto.Payment;
import com.bst.ckt.dto.Transport;
import com.bst.ckt.vo.PaymentVO;
import com.bst.ckt.vo.TransportVO;

public interface PaymentDaoInf {

	
	
void PaymentRequest(PaymentVO paymentVO)throws Exception;
	
	
	List<PaymentVO> getPaymentDetails(PaymentVO paymentVO) throws Exception;


	 public Payment editPaymentDetail(Payment payment, int pyamentID)throws Exception;
		
		public int updatePaymentDetail(PaymentVO paymentVO, int pyamentID)throws Exception ;

		 public int deletePaymentDetails(int pyamentID)throws Exception;

	
}
