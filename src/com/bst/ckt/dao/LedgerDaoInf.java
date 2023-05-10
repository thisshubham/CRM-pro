package com.bst.ckt.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bst.ckt.exception.RecordNotFoundException;
import com.bst.ckt.vo.LedgerVO;

public interface LedgerDaoInf {

public 	List<LedgerVO> viewLedgerGrid() throws RecordNotFoundException;

public void generateLedgerPDF(HttpServletRequest request,
		HttpServletResponse response, int dealerId);



}
