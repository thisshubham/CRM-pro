package com.bst.ckt.service;

import com.bst.ckt.exception.CreateFailedException;
import com.bst.ckt.vo.PayDueAmountOfConsumerVO;

public abstract interface PayDueAmountOfConsumerServiceInf
{
  public abstract void addConsumerTransaction(PayDueAmountOfConsumerVO paramPayDueAmountOfConsumerVO)
    throws CreateFailedException;
}


/* Location:           C:\Users\bharti\Desktop\Chouksay\lost\service\
 * Qualified Name:     com.bst.ckt.service.PayDueAmountOfConsumerServiceInf
 * JD-Core Version:    0.7.0.1
 */