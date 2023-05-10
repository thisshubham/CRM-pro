package com.bst.ckt.dao;

import com.bst.ckt.dto.PurchaseSteelbar;
import com.bst.ckt.exception.CreateFailedException;
import com.bst.ckt.exception.DeleteFailedException;
import com.bst.ckt.exception.RecordNotFoundException;
import com.bst.ckt.exception.UpdateFailedException;
import com.bst.ckt.vo.PurchaseSteelBarVO;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract interface PurchaseSteelBarDaoInf
{
  public abstract int insertPurchaseSteelBarsDetails(PurchaseSteelBarVO paramPurchaseSteelBarVO)
    throws CreateFailedException;
  
  public abstract List<PurchaseSteelBarVO> retrivePurchaseSteelBarDetailsGrid(PurchaseSteelBarVO paramPurchaseSteelBarVO)
    throws RecordNotFoundException;
  
  public abstract PurchaseSteelbar retriveSpecificPurchaseSteelBarDetail(int paramInt)
    throws RecordNotFoundException;
  
  public abstract int deleteSpecificSteelbarPurchaseDetails(int paramInt)
    throws DeleteFailedException;
  
  public abstract PurchaseSteelbar retriveSpecificPurchaseDetailForUpdate(int paramInt)
    throws RecordNotFoundException;
  
  public abstract void updateSpecificPurchaseRecord(PurchaseSteelBarVO paramPurchaseSteelBarVO, int paramInt)
    throws UpdateFailedException;
  
  public abstract void purchasePDF(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse, int paramInt);
  
  public abstract List<PurchaseSteelBarVO> retrivePurchaseSteelBarDetailsForSearch(int paramInt, String paramString);
  
  public abstract int getPurchaseSteelbarLastRecord()
    throws RecordNotFoundException;
  
  public abstract PurchaseSteelbar getPurchaseSteelbarDetails(int paramInt)
    throws RecordNotFoundException;
  
  public abstract List<PurchaseSteelBarVO> viewSteelbarStockGrid()
    throws RecordNotFoundException;
  
  public abstract int isItemAlreadyExistInStock(String paramString)
    throws RecordNotFoundException;
  
  public abstract void updateStockDetails(PurchaseSteelBarVO paramPurchaseSteelBarVO, int paramInt)
    throws UpdateFailedException;
  
  public abstract void insertStockDetails(PurchaseSteelBarVO paramPurchaseSteelBarVO)
    throws CreateFailedException;
  
  public abstract void insertIntoLedger(PurchaseSteelBarVO paramPurchaseSteelBarVO)
    throws CreateFailedException;
}


/* Location:           C:\Users\bharti\Desktop\Chouksay\lost\dao\
 * Qualified Name:     com.bst.ckt.dao.PurchaseSteelBarDaoInf
 * JD-Core Version:    0.7.0.1
 */