package com.bst.ckt.dao;

import com.bst.ckt.dto.Consumer;
import com.bst.ckt.exception.CreateFailedException;
import com.bst.ckt.exception.DeleteFailedException;
import com.bst.ckt.exception.RecordNotFoundException;
import com.bst.ckt.exception.UpdateFailedException;
import com.bst.ckt.vo.ConsumerCustomerVO;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract interface ConsumerCustomerDaoInf
{
  public abstract void addConsumerDetails(ConsumerCustomerVO paramConsumerCustomerVO)
    throws CreateFailedException;
  
  public abstract List<ConsumerCustomerVO> retriveConsumerDetailsGrid(ConsumerCustomerVO paramConsumerCustomerVO)
    throws RecordNotFoundException;
  
  public abstract Consumer retriveSpecificConsumerDetail(int paramInt)
    throws RecordNotFoundException;
  
  public abstract List<ConsumerCustomerVO> retriveConsumerTransactionDetailsGrid(ConsumerCustomerVO paramConsumerCustomerVO)
    throws RecordNotFoundException;
  
  public abstract int deleteSpecificConsumerDetails(int paramInt)
    throws DeleteFailedException;
  
  public abstract Consumer retriveSpecificConsumerDetailForEdit(int paramInt)
    throws RecordNotFoundException;
  
  public abstract void updateSpecificConsumerRecord(ConsumerCustomerVO paramConsumerCustomerVO, int paramInt)
    throws UpdateFailedException;
  
  public abstract Consumer retriveSpecificConsumerTransaction(int paramInt)
    throws RecordNotFoundException;
  
  public abstract int deleteSpecificConsumerTransaction(int paramInt)
    throws DeleteFailedException;
  
  public abstract void consumerTransactionPrintPDF(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse, int paramInt);
  
  public abstract void consumerDetailsPrintPDF(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse, int paramInt);
  
  public abstract List<ConsumerCustomerVO> retriveConsumerDetailsForAdvanceSearch(int paramInt, String paramString)
    throws RecordNotFoundException;
  
  public abstract List<ConsumerCustomerVO> retriveConsumerTransactionForAdvanceSearch(int paramInt, String paramString)
    throws RecordNotFoundException;
  
  public abstract int getConsumerLastRecord()
    throws RecordNotFoundException;
  
  public abstract Consumer getConsumerDetails(int paramInt)
    throws RecordNotFoundException;
  
  public abstract int getConsumerTransactionLastRecord()
    throws RecordNotFoundException;
  
  public abstract Consumer getConsumerTransaction(int paramInt)
    throws RecordNotFoundException;
  
  public abstract Consumer retrieveConsumerTransactionByIdForPayDue(int paramInt)
    throws RecordNotFoundException;
  
  public abstract void addPayDue(ConsumerCustomerVO paramConsumerCustomerVO, int paramInt)
    throws RecordNotFoundException;
}


/* Location:           C:\Users\bharti\Desktop\Chouksay\lost\dao\
 * Qualified Name:     com.bst.ckt.dao.ConsumerCustomerDaoInf
 * JD-Core Version:    0.7.0.1
 */