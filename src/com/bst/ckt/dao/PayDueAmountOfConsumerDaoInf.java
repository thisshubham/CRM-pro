package com.bst.ckt.dao;

import com.bst.ckt.exception.CreateFailedException;
import com.bst.ckt.exception.RecordNotFoundException;
import com.bst.ckt.vo.PayDueAmountOfConsumerVO;
import org.json.simple.JSONObject;

public abstract interface PayDueAmountOfConsumerDaoInf
{
  public abstract JSONObject getTransactionDetailsByBillNo(String paramString)
    throws RecordNotFoundException;
  
  public abstract void addConsumerTransaction(PayDueAmountOfConsumerVO paramPayDueAmountOfConsumerVO)
    throws CreateFailedException;
}


/* Location:           C:\Users\bharti\Desktop\Chouksay\lost\dao\
 * Qualified Name:     com.bst.ckt.dao.PayDueAmountOfConsumerDaoInf
 * JD-Core Version:    0.7.0.1
 */