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
 * Class Name     CustomerRegistration.java     
 *                                                            
 * Creation Date  AUG 20, 2015 
 * 
 * Abstract       This is Name helper class to retrieve data from database 
 *                and returns name of value based on input.
 *  
 * Amendment History (in chronological sequence): AUG 10, 2015 
 * 
 **********************************************************************
 */
package com.bst.ckt.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.bst.ckt.exception.OMIApplicationException;
import com.bst.ckt.service.ContactServiceImpl;
import com.bst.ckt.service.ContactServiceInf;
import com.bst.ckt.vo.ContactVO;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @author deepak
 * 
 */
public class ContactAction extends ActionSupport implements
		ServletRequestAware, ModelDriven<ContactVO>, ServletResponseAware,
		SessionAware {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ContactVO contactVO=new ContactVO();
	
	ContactServiceInf ContactServiceInf=null;
	
	
	
	public String execute()
	{
		return SUCCESS;
		}
	
	/**
	 * <p><code>addContact</code>Method will get data of outer user from contactUs form</p>
	 * @return
	 * @throws OMIApplicationException
	 */
	public String addContact()throws OMIApplicationException {
		System.out.println("Contact Us:::::::::::::::::::");
		ContactServiceInf contactServiceInf=new ContactServiceImpl();
		contactServiceInf.addContactDetails(contactVO);
		return SUCCESS;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ContactVO getModel() {
		// TODO Auto-generated method stub
		return contactVO;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		
	}

}
