package com.bst.ckt.dao;

import com.bst.ckt.dto.InvoiceSale;
import com.bst.ckt.exception.CreateFailedException;
import com.bst.ckt.exception.DeleteFailedException;
import com.bst.ckt.exception.RecordNotFoundException;
import com.bst.ckt.exception.UpdateFailedException;
import com.bst.ckt.vo.InvoiceSaleVO;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONObject;

public abstract interface InvoiceSaleDaoInf
{
  public abstract int addSalesDetails(InvoiceSaleVO paramInvoiceSaleVO)
    throws CreateFailedException;
  
  public abstract List<InvoiceSaleVO> getSalesDetails(InvoiceSaleVO paramInvoiceSaleVO)
    throws RecordNotFoundException;
  
  public abstract JSONObject productListJSON()
    throws RecordNotFoundException;
  
  public abstract JSONObject taxListJSON()
    throws RecordNotFoundException;
  
  public abstract InvoiceSale retriveSpecificSalesDetail(int paramInt)
    throws RecordNotFoundException;
  
  public abstract int deleteSpecificSalesDetails(int paramInt)
    throws DeleteFailedException;
  
  public abstract InvoiceSale retriveSpecificSalesDetailForUpdate(int paramInt)
    throws RecordNotFoundException;
  
  public abstract List<InvoiceSaleVO> getSpecificItemsForEdit(int paramInt)
    throws RecordNotFoundException;
  
  public abstract void updateSpecificSalesRecord(InvoiceSaleVO paramInvoiceSaleVO, int paramInt)
    throws UpdateFailedException;
  
  public abstract void salesPDF(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse, int paramInt);
  
  public abstract List<InvoiceSaleVO> retriveSalesDetailsForAdvanceSearch(int paramInt, String paramString)
    throws RecordNotFoundException;
  
  public abstract int getSalesLastRecord()
    throws RecordNotFoundException;
  
  public abstract InvoiceSale getSalesDetails(int paramInt)
    throws RecordNotFoundException;
  
  public abstract void generateBillForSales(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse, int paramInt, int result);
  
  public abstract List<InvoiceSaleVO> getSpecificItemsForView(int paramInt)
    throws RecordNotFoundException;

public abstract int getNameForBillOnTheBasisOfId(int salesId) throws RecordNotFoundException;
}


/* Location:           C:\Users\bharti\Desktop\Chouksay\lost\dao\
 * Qualified Name:     com.bst.ckt.dao.InvoiceSaleDaoInf
 * JD-Core Version:    0.7.0.1
 */