package com.bst.ckt.service;

import com.bst.ckt.dto.PurchaseCement;
import com.bst.ckt.exception.CreateFailedException;
import com.bst.ckt.exception.DeleteFailedException;
import com.bst.ckt.exception.RecordNotFoundException;
import com.bst.ckt.exception.UpdateFailedException;
import com.bst.ckt.vo.PurchaseCementVO;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract interface PurchaseCementServiceInf
{
  public abstract void insertPurchaseCementDetails(PurchaseCementVO paramPurchaseCementVO)
    throws CreateFailedException;
  
  public abstract List<PurchaseCementVO> retrivePurchaseCementDetailsGrid(PurchaseCementVO paramPurchaseCementVO)
    throws RecordNotFoundException;
  
  public abstract PurchaseCement retriveSpecificPurchaseCementDetail(int paramInt)
    throws RecordNotFoundException;
  
  public abstract String deleteSpecificCementPurchaseDetails(int paramInt)
    throws DeleteFailedException;
  
  public abstract PurchaseCement retriveSpecificPurchaseDetailForUpdate(int paramInt)
    throws RecordNotFoundException;
  
  public abstract void updateSpecificPurchaseRecord(PurchaseCementVO paramPurchaseCementVO, int paramInt1, int paramInt2)
    throws UpdateFailedException;
  
  public abstract void purchasePDF(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse, int paramInt);
  
  public abstract void purchaseCementExcelReport(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse)
    throws Exception;
  
  public abstract List<PurchaseCementVO> fetchPurchaseCementList()
    throws RecordNotFoundException;
  
  public abstract PurchaseCement viewNextPurchaseCementDetails(int paramInt)
    throws RecordNotFoundException;
  
  public abstract PurchaseCement viewPreviousPurchaseCement(int paramInt)
    throws RecordNotFoundException;
  
  public abstract List<PurchaseCementVO> viewCementStockGrid()
    throws RecordNotFoundException;
  
  public abstract void insertIntoLedger(PurchaseCementVO paramPurchaseCementVO)
    throws CreateFailedException;
}


/* Location:           C:\Users\bharti\Desktop\Chouksay\lost\service\
 * Qualified Name:     com.bst.ckt.service.PurchaseCementServiceInf
 * JD-Core Version:    0.7.0.1
 */