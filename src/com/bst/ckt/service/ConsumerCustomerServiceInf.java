package com.bst.ckt.service;

import com.bst.ckt.dto.Consumer;
import com.bst.ckt.exception.CreateFailedException;
import com.bst.ckt.exception.DeleteFailedException;
import com.bst.ckt.exception.RecordNotFoundException;
import com.bst.ckt.exception.UpdateFailedException;
import com.bst.ckt.vo.ConsumerCustomerVO;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract interface ConsumerCustomerServiceInf
{
  public abstract String addConsumerDetails(ConsumerCustomerVO paramConsumerCustomerVO)
    throws CreateFailedException;
  
  public abstract List<ConsumerCustomerVO> retriveConsumerDetailsGrid(ConsumerCustomerVO paramConsumerCustomerVO)
    throws RecordNotFoundException;
  
  public abstract Consumer retriveSpecificConsumerDetail(int paramInt)
    throws RecordNotFoundException;
  
  public abstract List<ConsumerCustomerVO> retriveConsumerTransactionDetailsGrid(ConsumerCustomerVO paramConsumerCustomerVO)
    throws RecordNotFoundException;
  
  public abstract String deleteSpecificConsumerDetails(int paramInt)
    throws DeleteFailedException;
  
  public abstract Consumer retriveSpecificConsumerDetailForEdit(int paramInt)
    throws RecordNotFoundException;
  
  public abstract void updateSpecificConsumerRecord(ConsumerCustomerVO paramConsumerCustomerVO, int paramInt)
    throws UpdateFailedException;
  
  public abstract Consumer retriveSpecificConsumerTransaction(int paramInt)
    throws RecordNotFoundException;
  
  public abstract String deleteSpecificConsumerTransaction(int paramInt)
    throws DeleteFailedException;
  
  public abstract void consumerTransactionPrintPDF(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse, int paramInt);
  
  public abstract void consumerDetailsPrintPDF(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse, int paramInt);
  
  public abstract void consumerDetailExcelReport(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse);
  
  public abstract void consumerTransactionExcelReport(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse);
  
  public abstract List<ConsumerCustomerVO> retriveConsumerDetailsForAdvanceSearch(ConsumerCustomerVO paramConsumerCustomerVO)
    throws RecordNotFoundException;
  
  public abstract List<ConsumerCustomerVO> retriveConsumerTransactionForAdvanceSearch(ConsumerCustomerVO paramConsumerCustomerVO)
    throws RecordNotFoundException;
  
  public abstract Consumer viewNextConsumerDetail(int paramInt)
    throws RecordNotFoundException;
  
  public abstract Consumer viewPreviousConsumerDetail(int paramInt)
    throws RecordNotFoundException;
  
  public abstract Consumer viewNextConsumerTransaction(int paramInt)
    throws RecordNotFoundException;
  
  public abstract Consumer viewPreviousConsumerTransaction(int paramInt)
    throws RecordNotFoundException;
  
  public abstract Consumer retrieveConsumerTransactionByIdForPayDue(int paramInt)
    throws RecordNotFoundException;
  
  public abstract void addPayDue(ConsumerCustomerVO paramConsumerCustomerVO, int paramInt)
    throws RecordNotFoundException;
}


/* Location:           C:\Users\bharti\Desktop\Chouksay\lost\service\
 * Qualified Name:     com.bst.ckt.service.ConsumerCustomerServiceInf
 * JD-Core Version:    0.7.0.1
 */