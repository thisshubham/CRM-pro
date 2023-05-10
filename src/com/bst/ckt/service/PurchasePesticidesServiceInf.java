package com.bst.ckt.service;

import com.bst.ckt.dto.Pesticides;
import com.bst.ckt.exception.CreateFailedException;
import com.bst.ckt.exception.DeleteFailedException;
import com.bst.ckt.exception.RecordNotFoundException;
import com.bst.ckt.exception.UpdateFailedException;
import com.bst.ckt.vo.PurchasePesticidesVO;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract interface PurchasePesticidesServiceInf
{
  public abstract void addPurchasePesticides(PurchasePesticidesVO paramPurchasePesticidesVO)
    throws CreateFailedException;
  
  public abstract List<PurchasePesticidesVO> getPurchasePesticidesDetails()
    throws RecordNotFoundException;
  
  public abstract Pesticides retriveSpecificPurchaseDetailForUpdate(int paramInt)
    throws RecordNotFoundException;
  
  public abstract void updateSpecificPurchaseRecord(PurchasePesticidesVO paramPurchasePesticidesVO, int paramInt1, int paramInt2)
    throws UpdateFailedException;
  
  public abstract String deleteSpecificPesticidePurchaseDetails(int paramInt)
    throws DeleteFailedException;
  
  public abstract Pesticides retrivedPesticidesDetails(int paramInt)
    throws RecordNotFoundException;
  
  public abstract List<PurchasePesticidesVO> getPurchasePesticidesDetailsForAdvanceSearch(PurchasePesticidesVO paramPurchasePesticidesVO)
    throws RecordNotFoundException;
  
  public abstract Pesticides viewNextPurchasePesticideDetail(int paramInt)
    throws RecordNotFoundException;
  
  public abstract Pesticides viewPreviousPurchasePesticide(int paramInt)
    throws RecordNotFoundException;
  
  public abstract void purchasePrintPDF(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse, int paramInt);
}


/* Location:           C:\Users\bharti\Desktop\Chouksay\lost\service\
 * Qualified Name:     com.bst.ckt.service.PurchasePesticidesServiceInf
 * JD-Core Version:    0.7.0.1
 */