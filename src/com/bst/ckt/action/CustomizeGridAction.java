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
 * Class Name     CustomizeGridAction.java     
 *                                                            
 * Creation Date  AUG 20, 2015 
 * 
 * Abstract       This Class is use to Create Customizable Grid based on 
 * 				  user input.
 *  
 * Amendment History (in chronological sequence): AUG 10, 2015 
 * 
 **********************************************************************
 */
package com.bst.ckt.action;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.bst.ckt.exception.OMIApplicationException;
import com.bst.ckt.service.CustomizeGridServiceImpl;
import com.bst.ckt.service.CustomizeGridServiceInf;
import com.bst.ckt.vo.CustomizeGridVO;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @author Deepak Vishwakarma
 * 
 */
public class CustomizeGridAction extends ActionSupport implements
		ModelDriven<CustomizeGridVO>, ServletResponseAware, SessionAware,
		ServletRequestAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	CustomizeGridVO customizeGridVO = new CustomizeGridVO();
	CustomizeGridServiceInf customizeGridServiceInf=new CustomizeGridServiceImpl();
	HttpServletResponse response = null;
	List<CustomizeGridVO> headerGridData=null;
	HttpServletRequest request = (HttpServletRequest) ActionContext
			.getContext().get(ServletActionContext.HTTP_REQUEST);

	/**
	 * <p>
	 * <code>leadGridHeaderData</code> Method is design to create dynamic and
	 * customized grid header of lead dashboard.
	 * </p>
	 * 
	 * @return
	 * @throws OMIApplicationException
	 */
	public String leadGridHeaderData() throws OMIApplicationException {
		
		this.customizeGridVO=customizeGridServiceInf.getLeadGridHeaderData(customizeGridVO);

		return SUCCESS;
	}

	public CustomizeGridAction()throws OMIApplicationException{
		
		this.headerGridData=customizeGridServiceInf.headerdataList();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;

	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public CustomizeGridVO getModel() {
		// TODO Auto-generated method stub
		return customizeGridVO;
	}

}
