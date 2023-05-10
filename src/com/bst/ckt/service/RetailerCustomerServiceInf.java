package com.bst.ckt.service;

import com.bst.ckt.dto.Retailer;
import com.bst.ckt.exception.CreateFailedException;
import com.bst.ckt.exception.DeleteFailedException;
import com.bst.ckt.exception.RecordNotFoundException;
import com.bst.ckt.exception.UpdateFailedException;
import com.bst.ckt.vo.RetailerCustomerVO;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract interface RetailerCustomerServiceInf
{
  public abstract String addRetailerDetails(RetailerCustomerVO paramRetailerCustomerVO)
    throws CreateFailedException;
  
  public abstract List<RetailerCustomerVO> retriveRetailerDetailsGrid(RetailerCustomerVO paramRetailerCustomerVO)
    throws RecordNotFoundException;
  
  public abstract Retailer retriveSpecificRetailerDetail(int paramInt)
    throws RecordNotFoundException;
  
  public abstract List<RetailerCustomerVO> retriveRetailerTransactionDetailsGrid(RetailerCustomerVO paramRetailerCustomerVO)
    throws RecordNotFoundException;
  
  public abstract String deleteSpecificRetailerDetails(int paramInt)
    throws DeleteFailedException;
  
  public abstract Retailer retriveSpecificRetailerDetailForEdit(int paramInt)
    throws RecordNotFoundException;
  
  public abstract void updateSpecificRetailerRecord(RetailerCustomerVO paramRetailerCustomerVO, int paramInt)
    throws UpdateFailedException;
  
  public abstract Retailer retriveSpecificRetailerTransaction(int paramInt)
    throws RecordNotFoundException;
  
  public abstract String deleteSpecificRetailerTransaction(int paramInt)
    throws DeleteFailedException;
  
  public abstract void retailerTransactionPrintPDF(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse, int paramInt);
  
  public abstract void retailerDetailPrintPDF(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse, int paramInt);
  
  public abstract void retailerDetailExcelReport(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse);
  
  public abstract void retailerTransactionExcelReport(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse);
  
  public abstract List<RetailerCustomerVO> retriveRetailerDetailsForAdvanceSearch(RetailerCustomerVO paramRetailerCustomerVO)
    throws RecordNotFoundException;
  
  public abstract List<RetailerCustomerVO> retriveRetailerTransactionForAdvanceSearch(RetailerCustomerVO paramRetailerCustomerVO)
    throws RecordNotFoundException;
  
  public abstract Retailer viewNextRetailerDetail(int paramInt)
    throws RecordNotFoundException;
  
  public abstract Retailer viewPreviousRetailerDetail(int paramInt)
    throws RecordNotFoundException;
  
  public abstract Retailer viewNextRetailerTransaction(int paramInt)
    throws RecordNotFoundException;
  
  public abstract Retailer viewPreviousRetailerTransaction(int paramInt)
    throws RecordNotFoundException;
  
  public abstract Retailer retrieveRetailerTransactionByIdForPayDue(int paramInt)
    throws RecordNotFoundException;
  
  public abstract void addPayDue(RetailerCustomerVO paramRetailerCustomerVO, int paramInt)
    throws RecordNotFoundException;
}


/* Location:           C:\Users\bharti\Desktop\Chouksay\lost\service\
 * Qualified Name:     com.bst.ckt.service.RetailerCustomerServiceInf
 * JD-Core Version:    0.7.0.1
 */