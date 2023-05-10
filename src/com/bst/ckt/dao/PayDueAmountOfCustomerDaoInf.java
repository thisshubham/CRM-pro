package com.bst.ckt.dao;

import com.bst.ckt.exception.CreateFailedException;
import com.bst.ckt.vo.PayDueAmountOfCustomerVO;
import org.json.simple.JSONObject;

public abstract interface PayDueAmountOfCustomerDaoInf
{
  public abstract void addRetailerTransaction(PayDueAmountOfCustomerVO paramPayDueAmountOfCustomerVO)
    throws CreateFailedException;
  
  public abstract JSONObject getTransactionDetailsByBillNo(String paramString);
}


/* Location:           C:\Users\bharti\Desktop\Chouksay\lost\dao\
 * Qualified Name:     com.bst.ckt.dao.PayDueAmountOfCustomerDaoInf
 * JD-Core Version:    0.7.0.1
 */