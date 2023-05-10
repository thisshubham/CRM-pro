package com.bst.ckt.service;

import com.bst.ckt.dto.InvoiceSale;
import com.bst.ckt.exception.CreateFailedException;
import com.bst.ckt.exception.DeleteFailedException;
import com.bst.ckt.exception.RecordNotFoundException;
import com.bst.ckt.exception.UpdateFailedException;
import com.bst.ckt.vo.InvoiceSaleVO;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract interface InvoiceSaleServiceInf
{
  public abstract int addSalesDetails(InvoiceSaleVO paramInvoiceSaleVO)
    throws CreateFailedException;
  
  public abstract List<InvoiceSaleVO> retriveSalesDetailsGrid(InvoiceSaleVO paramInvoiceSaleVO)
    throws RecordNotFoundException;
  
  public abstract InvoiceSale retriveSpecificSalesDetail(int paramInt)
    throws RecordNotFoundException;
  
  public abstract String deleteSpecificSalesDetails(int paramInt)
    throws DeleteFailedException;
  
  public abstract InvoiceSale retriveSpecificSalesDetailForUpdate(int paramInt)
    throws RecordNotFoundException;
  
  public abstract List<InvoiceSaleVO> getSpecificItemsForEdit(int paramInt)
    throws RecordNotFoundException;
  
  public abstract void updateSpecificSalesRecord(InvoiceSaleVO paramInvoiceSaleVO, int paramInt)
    throws UpdateFailedException;
  
  public abstract void salesPDF(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse, int paramInt);
  
  public abstract void salesExcelReport(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse)
    throws Exception;
  
  public abstract List<InvoiceSaleVO> retriveSalesDetailsForAdvanceSearch(InvoiceSaleVO paramInvoiceSaleVO)
    throws RecordNotFoundException;
  
  public abstract InvoiceSale viewNextSalesDetail(int paramInt)
    throws RecordNotFoundException;
  
  public abstract InvoiceSale viewPreviousSalesDetails(int paramInt)
    throws RecordNotFoundException;
  
  public abstract void generateBillForSales(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse, int paramInt, int result);
  
  public abstract List<InvoiceSaleVO> getSpecificItemsBySalesId(int paramInt)
    throws RecordNotFoundException;
}


/* Location:           C:\Users\bharti\Desktop\Chouksay\lost\service\
 * Qualified Name:     com.bst.ckt.service.InvoiceSaleServiceInf
 * JD-Core Version:    0.7.0.1
 */