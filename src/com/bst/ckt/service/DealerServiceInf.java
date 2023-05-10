package com.bst.ckt.service;

import com.bst.ckt.dto.Dealer;
import com.bst.ckt.exception.CreateFailedException;
import com.bst.ckt.exception.DeleteFailedException;
import com.bst.ckt.exception.RecordNotFoundException;
import com.bst.ckt.exception.UpdateFailedException;
import com.bst.ckt.vo.DealerVO;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract interface DealerServiceInf
{
  public abstract List<DealerVO> viewDealerTransactionDetailsGrid(DealerVO paramDealerVO)
    throws RecordNotFoundException;
  
  public abstract String addDealerDetails(DealerVO paramDealerVO)
    throws CreateFailedException;
  
  public abstract List<DealerVO> retriveDealerDetailsGrid(DealerVO paramDealerVO)
    throws RecordNotFoundException;
  
  public abstract Dealer retriveSpecificDealerDetail(int paramInt)
    throws RecordNotFoundException;
  
  public abstract String deleteSpecificDealerDetails(int paramInt)
    throws DeleteFailedException;
  
  public abstract Dealer retriveSpecificDealerDetailForEdit(int paramInt)
    throws RecordNotFoundException;
  
  public abstract void updateSpecificDealerRecord(DealerVO paramDealerVO, int paramInt)
    throws UpdateFailedException;
  
  public abstract Dealer retriveSpecificDealerTransaction(int paramInt)
    throws RecordNotFoundException;
  
  public abstract String deleteSpecificDealerTransaction(int paramInt)
    throws DeleteFailedException;
  
  public abstract void dealerTransactionPrintPDF(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse, int paramInt);
  
  public abstract void dealerDetailPrintPDF(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse, int paramInt);
  
  public abstract void dealerDetailExcelReport(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse);
  
  public abstract void dealerTransactionExcelReport(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse);
  
  public abstract List<DealerVO> retriveDealerDetailsForAdvanceSearch(DealerVO paramDealerVO)
    throws RecordNotFoundException;
  
  public abstract List<DealerVO> viewDealerTransactionForSearch(DealerVO paramDealerVO)
    throws RecordNotFoundException;
  
  public abstract Dealer viewNextDealerDetails(int paramInt)
    throws RecordNotFoundException;
  
  public abstract Dealer viewPreviousDealerDetail(int paramInt)
    throws RecordNotFoundException;
  
  public abstract Dealer viewNextDealerTransaction(int paramInt)
    throws RecordNotFoundException;
  
  public abstract Dealer viewPreviousDealerTransaction(int paramInt)
    throws RecordNotFoundException;
  
  public abstract Dealer retrieveDealerTransactionByIdForPayDue(int paramInt)
    throws RecordNotFoundException;
  
  public abstract void addPayDue(DealerVO paramDealerVO, int paramInt)
    throws CreateFailedException;
}


/* Location:           C:\Users\bharti\Desktop\Chouksay\lost\service\
 * Qualified Name:     com.bst.ckt.service.DealerServiceInf
 * JD-Core Version:    0.7.0.1
 */