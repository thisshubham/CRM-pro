/*
 **********************************************************************
 *
 * COPYRIGHT. $ID$ 2015. ALL RIGHTS RESERVED.
 *
 * This software is only to be used for the purpose for which it has been
 * provided. No part of it is to be reproduced, disassembled, transmitted,
 * stored in a retrieval system nor translated in any human or computer
 * language in any way or for any other purposes whatsoever without the
 * prior written consent of $ID$.
 * 
 * Class Name     ReportsAction.java     
 *                                                            
 * Creation Date  NOV 9, 2015 
 * 
 * Abstract       This is a action class is used to perform some operations on eports.
 *  
 * Amendment History (in chronological sequence): AUG 10, 2015 
 * 
 **********************************************************************
 */
package com.bst.ckt.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.bst.ckt.dao.ReportsDaoImpl;
import com.bst.ckt.dao.ReportsDaoInf;
import com.bst.ckt.vo.LeadVO;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @author sharif
 * 
 */
public class ReportsAction extends ActionSupport implements SessionAware,
		ServletRequestAware, ModelDriven<LeadVO> {

	private static final long serialVersionUID = -6125236760946195439L;

	/*
	 * private static final Logger logger =
	 * Logger.getLogger(ReportsAction.class);
	 */
	ReportsDaoInf reportsDaoInf = new ReportsDaoImpl();
	LeadVO leadVO = new LeadVO();
	
	
	private List<LeadVO> leadFollowupReportsGrid;
	private List<Integer> leadIdList;

		public ReportsAction() throws Exception {		
		 leadFollowupReportsGrid = reportsDaoInf.showLeadFollowupReportsGrid();
		 leadIdList=reportsDaoInf.getLeadIdList();
	}

	
	
	
	
	
	
	
	

	public LeadVO getLeadDetailsVO() {
		return leadVO;
	}

	public void setLeadVO(LeadVO leadVO) {
		this.leadVO = leadVO;
	}

	public List<LeadVO> getLeadFollowupReportsGrid() {
		return leadFollowupReportsGrid;
	}

	public void setLeadFollowupReportsGrid(List<LeadVO> leadFollowupReportsGrid) {
		this.leadFollowupReportsGrid = leadFollowupReportsGrid;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public LeadVO getModel() {
		// TODO Auto-generated method stub
		return leadVO;
	}
	
	public List<Integer> getLeadIdList() {
		return leadIdList;
	}

	public void setLeadIdList(List<Integer> leadIdList) {
		this.leadIdList = leadIdList;
	}

}
