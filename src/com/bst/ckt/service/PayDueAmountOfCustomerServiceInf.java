package com.bst.ckt.service;

import com.bst.ckt.exception.CreateFailedException;
import com.bst.ckt.vo.PayDueAmountOfCustomerVO;

public abstract interface PayDueAmountOfCustomerServiceInf
{
  public abstract void addRetailerTransaction(PayDueAmountOfCustomerVO paramPayDueAmountOfCustomerVO)
    throws CreateFailedException;
}


/* Location:           C:\Users\bharti\Desktop\Chouksay\lost\service\
 * Qualified Name:     com.bst.ckt.service.PayDueAmountOfCustomerServiceInf
 * JD-Core Version:    0.7.0.1
 */