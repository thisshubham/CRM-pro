package com.bst.ckt.dao;

import com.bst.ckt.dto.Retailer;
import com.bst.ckt.exception.CreateFailedException;
import com.bst.ckt.exception.DeleteFailedException;
import com.bst.ckt.exception.RecordNotFoundException;
import com.bst.ckt.exception.UpdateFailedException;
import com.bst.ckt.vo.RetailerCustomerVO;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract interface RetailerCustomerDaoInf
{
  public abstract void addRetailerDetails(RetailerCustomerVO paramRetailerCustomerVO)
    throws CreateFailedException;
  
  public abstract List<RetailerCustomerVO> retriveRetailerDetailsGrid(RetailerCustomerVO paramRetailerCustomerVO)
    throws RecordNotFoundException;
  
  public abstract Retailer retriveSpecificRetailerDetail(int paramInt)
    throws RecordNotFoundException;
  
  public abstract List<RetailerCustomerVO> retriveRetailerTransactionDetailsGrid(RetailerCustomerVO paramRetailerCustomerVO)
    throws RecordNotFoundException;
  
  public abstract int deleteSpecificRetailerDetails(int paramInt)
    throws DeleteFailedException;
  
  public abstract Retailer retriveSpecificRetailerDetailForEdit(int paramInt)
    throws RecordNotFoundException;
  
  public abstract void updateSpecificRetailerRecord(RetailerCustomerVO paramRetailerCustomerVO, int paramInt)
    throws UpdateFailedException;
  
  public abstract Retailer retriveSpecificRetailerTransaction(int paramInt)
    throws RecordNotFoundException;
  
  public abstract int deleteSpecificRetailerTransaction(int paramInt)
    throws DeleteFailedException;
  
  public abstract void retailerTransactionPrintPDF(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse, int paramInt);
  
  public abstract void retailerDetailPrintPDF(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse, int paramInt);
  
  public abstract List<RetailerCustomerVO> retriveRetailerDetailsForAdvanceSearch(int paramInt, String paramString);
  
  public abstract List<RetailerCustomerVO> retriveRetailerTransactionForAdvanceSearch(int paramInt, String paramString);
  
  public abstract int getRetailerLastRecord()
    throws RecordNotFoundException;
  
  public abstract Retailer getRetailerDetails(int paramInt)
    throws RecordNotFoundException;
  
  public abstract int getRetailerTransactionLastRecord()
    throws RecordNotFoundException;
  
  public abstract Retailer getRetailerTransaction(int paramInt)
    throws RecordNotFoundException;
  
  public abstract Retailer retrieveReailerTransactionByIdForPayDue(int paramInt)
    throws RecordNotFoundException;
  
  public abstract void addPayDue(RetailerCustomerVO paramRetailerCustomerVO, int paramInt)
    throws RecordNotFoundException;
}


/* Location:           C:\Users\bharti\Desktop\Chouksay\lost\dao\
 * Qualified Name:     com.bst.ckt.dao.RetailerCustomerDaoInf
 * JD-Core Version:    0.7.0.1
 */