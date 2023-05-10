package com.bst.ckt.service;

import com.bst.ckt.dto.PurchaseSteelbar;
import com.bst.ckt.exception.CreateFailedException;
import com.bst.ckt.exception.DeleteFailedException;
import com.bst.ckt.exception.RecordNotFoundException;
import com.bst.ckt.exception.UpdateFailedException;
import com.bst.ckt.vo.PurchaseSteelBarVO;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract interface PurchaseSteelBarServiceInf
{
  public abstract void insertPurchaseSteelBarsDetails(PurchaseSteelBarVO paramPurchaseSteelBarVO)
    throws CreateFailedException;
  
  public abstract List<PurchaseSteelBarVO> retrivePurchaseSteelBarDetailsGrid(PurchaseSteelBarVO paramPurchaseSteelBarVO)
    throws RecordNotFoundException;
  
  public abstract PurchaseSteelbar retriveSpecificPurchaseSteelBarDetail(int paramInt)
    throws RecordNotFoundException;
  
  public abstract String deleteSpecificSteelbarPurchaseDetails(int paramInt)
    throws DeleteFailedException;
  
  public abstract void updateSpecificPurchaseRecord(PurchaseSteelBarVO paramPurchaseSteelBarVO, int paramInt)
    throws UpdateFailedException;
  
  public abstract PurchaseSteelbar retrivePurchaseSteelbarDetailsForEdit(int paramInt)
    throws RecordNotFoundException;
  
  public abstract void purchasePDF(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse, int paramInt);
  
  public abstract void purchaseSteelBarExcelReport(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse);
  
  public abstract List<PurchaseSteelBarVO> retrivePurchaseSteelBarDetailsForSearch(PurchaseSteelBarVO paramPurchaseSteelBarVO);
  
  public abstract PurchaseSteelbar viewNextPurchaseSteelbarDetails(int paramInt)
    throws RecordNotFoundException;
  
  public abstract PurchaseSteelbar viewPreviousPurchaseCement(int paramInt)
    throws RecordNotFoundException;
  
  public abstract List<PurchaseSteelBarVO> viewSteelbarStockGrid()
    throws RecordNotFoundException;
  
  public abstract void insertIntoLedger(PurchaseSteelBarVO paramPurchaseSteelBarVO)
    throws CreateFailedException;
}


/* Location:           C:\Users\bharti\Desktop\Chouksay\lost\service\
 * Qualified Name:     com.bst.ckt.service.PurchaseSteelBarServiceInf
 * JD-Core Version:    0.7.0.1
 */