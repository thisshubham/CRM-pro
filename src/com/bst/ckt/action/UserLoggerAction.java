package com.bst.ckt.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.bst.ckt.common.LoginUtil;
import com.bst.ckt.dao.CustomerDaoImpl;
import com.bst.ckt.dao.CustomerDaoInf;
import com.bst.ckt.exception.OMIApplicationException;
import com.bst.ckt.vo.UserLoggerVO;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserLoggerAction extends ActionSupport implements
		ModelDriven<UserLoggerVO>, ServletResponseAware, ServletRequestAware,
		SessionAware {

	/**
	 * Creating Logger object, logger object mapped with UserLoggerAction
	 * class for writing Loggers.
	 */
	public static final Logger logger =Logger.getLogger(UserLoggerAction.class);
	UserLoggerVO userLoggerVO = new UserLoggerVO();
	HttpServletRequest request = null;
	HttpServletResponse response = null;
	Map<String, Object> session = null;
	List<UserLoggerVO> userLoggerGrid=null;

	/**
	 * 
	 */
	private static final long serialVersionUID = -5772711432364836459L;

	public String execute() throws OMIApplicationException {
		System.out.println("**************************");
		CustomerDaoInf customerDaoInf = new CustomerDaoImpl();
		int coustomerId=LoginUtil.getCurrentCustomerUser().getCustomerId();
		 userLoggerGrid =customerDaoInf.getUserLoggerDetails(coustomerId);
		return SUCCESS;

	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
	
	}

	@Override
	public UserLoggerVO getModel() {
		// TODO Auto-generated method stub
		return userLoggerVO;
	}

	public List<UserLoggerVO> getUserLoggerGrid() {
		return userLoggerGrid;
	}

	public void setUserLoggerGrid(List<UserLoggerVO> userLoggerGrid) {
		this.userLoggerGrid = userLoggerGrid;
	}



}
