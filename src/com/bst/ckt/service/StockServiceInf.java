package com.bst.ckt.service;

import com.bst.ckt.exception.RecordNotFoundException;
import com.bst.ckt.vo.StockVO;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract interface StockServiceInf
{
  public abstract void stockDetailExcelReport(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse);
  
  public abstract List<StockVO> viewStockDetailsGrid(StockVO paramStockVO)
    throws RecordNotFoundException;
  
  public abstract List<StockVO> viewStockSearchGrid(StockVO paramStockVO)
    throws RecordNotFoundException;
}


/* Location:           C:\Users\bharti\Desktop\Chouksay\lost\service\
 * Qualified Name:     com.bst.ckt.service.StockServiceInf
 * JD-Core Version:    0.7.0.1
 */