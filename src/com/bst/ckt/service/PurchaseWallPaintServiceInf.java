package com.bst.ckt.service;

import com.bst.ckt.dto.WallPaint;
import com.bst.ckt.exception.CreateFailedException;
import com.bst.ckt.exception.RecordNotFoundException;
import com.bst.ckt.exception.UpdateFailedException;
import com.bst.ckt.vo.PurchaseWallPaintVO;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract interface PurchaseWallPaintServiceInf
{
  public abstract void addPurchaseWallPaint(PurchaseWallPaintVO paramPurchaseWallPaintVO)
    throws CreateFailedException;
  
  public abstract List<PurchaseWallPaintVO> fetchPurchaseWallPaintList()
    throws RecordNotFoundException;
  
  public abstract WallPaint retriveSpecificPurchaseDetailForUpdate(int paramInt)
    throws RecordNotFoundException;
  
  public abstract void updateSpecificPurchaseRecord(PurchaseWallPaintVO paramPurchaseWallPaintVO, int paramInt1, int paramInt2)
    throws UpdateFailedException;
  
  public abstract List<PurchaseWallPaintVO> fetchPurchaseWallPaintListForAdvanceSearch(PurchaseWallPaintVO paramPurchaseWallPaintVO)
    throws RecordNotFoundException;
  
  public abstract WallPaint viewNextPurchaseWallPaintDetail(int paramInt)
    throws RecordNotFoundException;
  
  public abstract WallPaint retrivePurchaseWallPaintFullDetailGrid(int paramInt);
  
  public abstract int deleteWallPaint(int paramInt)
    throws Exception;
  
  public abstract void purchaseWallPaintPrintPDF(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse, int paramInt)
    throws Exception;
  
  public abstract WallPaint viewPreviousPurchaseWallpaint(int paramInt)
    throws RecordNotFoundException;
}


/* Location:           C:\Users\bharti\Desktop\Chouksay\lost\service\
 * Qualified Name:     com.bst.ckt.service.PurchaseWallPaintServiceInf
 * JD-Core Version:    0.7.0.1
 */