package com.bst.ckt.dao;

import com.bst.ckt.dto.Dealer;
import com.bst.ckt.exception.CreateFailedException;
import com.bst.ckt.exception.DeleteFailedException;
import com.bst.ckt.exception.RecordNotFoundException;
import com.bst.ckt.exception.UpdateFailedException;
import com.bst.ckt.vo.DealerVO;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract interface DealerDaoInf
{
  public abstract List<DealerVO> viewDealerTransactionDetailsGrid(DealerVO paramDealerVO)
    throws RecordNotFoundException;
  
  public abstract void addDealerDetails(DealerVO paramDealerVO)
    throws CreateFailedException;
  
  public abstract List<DealerVO> retriveDealerDetailsGrid(DealerVO paramDealerVO)
    throws RecordNotFoundException;
  
  public abstract Dealer retriveSpecificDealerDetail(int paramInt)
    throws RecordNotFoundException;
  
  public abstract int deleteSpecificDealerDetails(int paramInt)
    throws DeleteFailedException;
  
  public abstract Dealer retriveSpecificDealerDetailForEdit(int paramInt)
    throws RecordNotFoundException;
  
  public abstract void updateSpecificDealerRecord(DealerVO paramDealerVO, int paramInt)
    throws UpdateFailedException;
  
  public abstract Dealer retriveSpecificDealerTransaction(int paramInt)
    throws RecordNotFoundException;
  
  public abstract int deleteSpecificDealerTransaction(int paramInt)
    throws DeleteFailedException;
  
  public abstract void dealerTransactionPrintPDF(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse, int paramInt);
  
  public abstract void dealerDetailPrintPDF(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse, int paramInt);
  
  public abstract List<DealerVO> retriveDealerDetailsForAdvanceSearch(int paramInt, String paramString)
    throws RecordNotFoundException;
  
  public abstract List<DealerVO> retriveDealerTransactionForAdvanceSearch(int paramInt, String paramString)
    throws RecordNotFoundException;
  
  public abstract int getDealerLastRecord()
    throws RecordNotFoundException;
  
  public abstract Dealer getDealerDetails(int paramInt)
    throws RecordNotFoundException;
  
  public abstract int getDealerTransactionLastRecord()
    throws RecordNotFoundException;
  
  public abstract Dealer getDealerTransaction(int paramInt)
    throws RecordNotFoundException;
  
  public abstract Dealer retrieveDealerTransactionByIdForPayDue(int paramInt)
    throws RecordNotFoundException;
  
  public abstract void addPayDue(DealerVO paramDealerVO, int paramInt)
    throws CreateFailedException;
}


/* Location:           C:\Users\bharti\Desktop\Chouksay\lost\dao\
 * Qualified Name:     com.bst.ckt.dao.DealerDaoInf
 * JD-Core Version:    0.7.0.1
 */