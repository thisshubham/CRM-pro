package com.bst.ckt.dao;

import com.bst.ckt.exception.RecordNotFoundException;
import com.bst.ckt.vo.StockVO;
import java.util.List;

public abstract interface StockDaoInf
{
  public abstract List<StockVO> viewStockDetailsGrid(StockVO paramStockVO)
    throws RecordNotFoundException;
  
  public abstract List<StockVO> viewStockSearchGrid(int paramInt, String paramString)
    throws RecordNotFoundException;
}


/* Location:           C:\Users\bharti\Desktop\Chouksay\lost\dao\
 * Qualified Name:     com.bst.ckt.dao.StockDaoInf
 * JD-Core Version:    0.7.0.1
 */