package com.bst.ckt.dao;

import com.bst.ckt.dto.Pesticides;
import com.bst.ckt.exception.CreateFailedException;
import com.bst.ckt.exception.DeleteFailedException;
import com.bst.ckt.exception.RecordNotFoundException;
import com.bst.ckt.exception.UpdateFailedException;
import com.bst.ckt.vo.PurchasePesticidesVO;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract interface PurchasePesticidesDaoInf
{
  public abstract int addPurchasePesticides(PurchasePesticidesVO paramPurchasePesticidesVO)
    throws CreateFailedException;
  
  public abstract List<PurchasePesticidesVO> getPurchasePesticidesDetails()
    throws RecordNotFoundException;
  
  public abstract int isItemAlreadyExistInStock(String paramString)
    throws RecordNotFoundException;
  
  public abstract void updateStockDetails(PurchasePesticidesVO paramPurchasePesticidesVO, int paramInt)
    throws UpdateFailedException;
  
  public abstract void insertStockDetails(PurchasePesticidesVO paramPurchasePesticidesVO)
    throws CreateFailedException;
  
  public abstract Pesticides retriveSpecificPurchaseDetailForUpdate(int paramInt)
    throws RecordNotFoundException;
  
  public abstract void updateSpecificPurchaseRecord(PurchasePesticidesVO paramPurchasePesticidesVO, int paramInt1, int paramInt2)
    throws UpdateFailedException;
  
  public abstract int deleteSpecificPesticidePurchaseDetails(int paramInt)
    throws DeleteFailedException;
  
  public abstract Pesticides retrivedPesticidesDetails(int paramInt)
    throws RecordNotFoundException;
  
  public abstract List<PurchasePesticidesVO> getPurchasePesticidesDetailsForAdvanceSearch(int paramInt, String paramString)
    throws RecordNotFoundException;
  
  public abstract int getPurchasePesticideLastRecord()
    throws RecordNotFoundException;
  
  public abstract Pesticides getPurchasePesticideDetails(int paramInt)
    throws RecordNotFoundException;
  
  public abstract void purchasePrintPDF(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse, int paramInt);
}


/* Location:           C:\Users\bharti\Desktop\Chouksay\lost\dao\
 * Qualified Name:     com.bst.ckt.dao.PurchasePesticidesDaoInf
 * JD-Core Version:    0.7.0.1
 */