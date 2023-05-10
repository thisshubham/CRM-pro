package com.bst.ckt.dao;

import com.bst.ckt.dto.PurchaseCement;
import com.bst.ckt.exception.CreateFailedException;
import com.bst.ckt.exception.DeleteFailedException;
import com.bst.ckt.exception.RecordNotFoundException;
import com.bst.ckt.exception.UpdateFailedException;
import com.bst.ckt.vo.PurchaseCementVO;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract interface PurchaseCementDaoInf
{
  public abstract int insertPurchaseCementDetails(PurchaseCementVO paramPurchaseCementVO)
    throws CreateFailedException;
  
  public abstract List<PurchaseCementVO> retrivePurchaseCementDetailsGrid(int paramInt, String paramString)
    throws RecordNotFoundException;
  
  public abstract PurchaseCement retriveSpecificPurchaseCementDetail(int paramInt)
    throws RecordNotFoundException;
  
  public abstract int deleteSpecificCementPurchaseDetails(int paramInt)
    throws DeleteFailedException;
  
  public abstract PurchaseCement retriveSpecificPurchaseDetailForUpdate(int paramInt)
    throws RecordNotFoundException;
  
  public abstract void updateSpecificPurchaseRecord(PurchaseCementVO paramPurchaseCementVO, int paramInt1, int paramInt2)
    throws UpdateFailedException;
  
  public abstract void purchasePDF(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse, int paramInt);
  
  public abstract List<PurchaseCementVO> fetchPurchaseCementList()
    throws RecordNotFoundException;
  
  public abstract int getPurchaseCementLastRecord()
    throws RecordNotFoundException;
  
  public abstract PurchaseCement getPurchaseCementDetails(int paramInt)
    throws RecordNotFoundException;
  
  public abstract List<PurchaseCementVO> viewCementStockGrid()
    throws RecordNotFoundException;
  
  public abstract void insertStockDetails(PurchaseCementVO paramPurchaseCementVO)
    throws CreateFailedException;
  
  public abstract int isItemAlreadyExistInStock(String paramString)
    throws RecordNotFoundException;
  
  public abstract void updateStockDetails(PurchaseCementVO paramPurchaseCementVO, int paramInt)
    throws UpdateFailedException;
  
  public abstract void insertIntoLedger(PurchaseCementVO paramPurchaseCementVO)
    throws CreateFailedException;
}


/* Location:           C:\Users\bharti\Desktop\Chouksay\lost\dao\
 * Qualified Name:     com.bst.ckt.dao.PurchaseCementDaoInf
 * JD-Core Version:    0.7.0.1
 */