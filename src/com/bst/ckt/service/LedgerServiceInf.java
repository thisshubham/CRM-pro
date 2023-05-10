package com.bst.ckt.service;

import com.bst.ckt.exception.RecordNotFoundException;
import com.bst.ckt.vo.LedgerVO;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract interface LedgerServiceInf
{
  public abstract List<LedgerVO> viewLedgerGrid()
    throws RecordNotFoundException;
  
  public abstract void generateLedgerPDF(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse, int paramInt);
}


/* Location:           C:\Users\bharti\Desktop\Chouksay\lost\service\
 * Qualified Name:     com.bst.ckt.service.LedgerServiceInf
 * JD-Core Version:    0.7.0.1
 */