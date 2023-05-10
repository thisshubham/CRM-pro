package com.bst.ckt.dao;

import com.bst.ckt.dto.WallPaint;
import com.bst.ckt.exception.CreateFailedException;
import com.bst.ckt.exception.RecordNotFoundException;
import com.bst.ckt.exception.UpdateFailedException;
import com.bst.ckt.vo.PurchaseWallPaintVO;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract interface PurchaseWallPaintDaoInf
{
  public abstract int addPurchaseWallPaint(PurchaseWallPaintVO paramPurchaseWallPaintVO)
    throws CreateFailedException;
  
  public abstract List<PurchaseWallPaintVO> fetchPurchaseWallPaintList()
    throws RecordNotFoundException;
  
  public abstract int isItemAlreadyExistInStock(String paramString)
    throws RecordNotFoundException;
  
  public abstract void updateStockDetails(PurchaseWallPaintVO paramPurchaseWallPaintVO, int paramInt)
    throws UpdateFailedException;
  
  public abstract void insertStockDetails(PurchaseWallPaintVO paramPurchaseWallPaintVO)
    throws CreateFailedException;
  
  public abstract WallPaint retriveSpecificPurchaseDetailForUpdate(int paramInt)
    throws RecordNotFoundException;
  
  public abstract void updateSpecificPurchaseRecord(PurchaseWallPaintVO paramPurchaseWallPaintVO, int paramInt1, int paramInt2)
    throws UpdateFailedException;
  
  public abstract List<PurchaseWallPaintVO> fetchPurchaseWallPaintListForAdvanceSearch(int paramInt, String paramString)
    throws RecordNotFoundException;
  
  public abstract int getPurchaseWallPaintLastRecord()
    throws RecordNotFoundException;
  
  public abstract WallPaint getPurchaseWallPaintDetails(int paramInt)
    throws RecordNotFoundException;
  
  public abstract WallPaint retrivePurchaseWallPaintDaoInfFullDetailGrid(int paramInt);
  
  public abstract int deleteWallPaint(int paramInt)
    throws Exception;
  
  public abstract void generatePurchaseWallPaintPdf(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse, int paramInt)
    throws Exception;
}


/* Location:           C:\Users\bharti\Desktop\Chouksay\lost\dao\
 * Qualified Name:     com.bst.ckt.dao.PurchaseWallPaintDaoInf
 * JD-Core Version:    0.7.0.1
 */