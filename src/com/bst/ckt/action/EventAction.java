/**
 * 
 */
package com.bst.ckt.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.bst.ckt.common.LoginUtil;
import com.bst.ckt.common.OMIConstants;
import com.bst.ckt.dao.EventDaoImpl;
import com.bst.ckt.dao.EventDaoInf;
import com.bst.ckt.exception.OMIApplicationException;
import com.bst.ckt.framework.user.CustomerSessionUser;
import com.bst.ckt.helper.ListHelper;
import com.bst.ckt.helper.VOMapperHelper;
import com.bst.ckt.service.EventServiceImpl;
import com.bst.ckt.service.EventServiceInf;
import com.bst.ckt.service.ProductServiceImpl;
import com.bst.ckt.vo.EventVO;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @author Rosu
 *
 */
public class EventAction extends ActionSupport implements ServletResponseAware, ModelDriven<EventVO>, SessionAware  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5588357900945681257L;
	/**
	 * Creating Logger object, logger object mapped with EventAction class for
	 * writing Loggers.
	 */
	private static final Logger logger = Logger.getLogger(EventAction.class);
	
	private static final String eventId =null;

	ListHelper listHelper = new ListHelper();
	HttpServletResponse response = null;
	HttpServletRequest request = (HttpServletRequest) ActionContext
			.getContext().get(ServletActionContext.HTTP_REQUEST);
	Map<String, Object> session = null;
	EventServiceInf eventServiceInf=new EventServiceImpl();
    EventDaoInf eventDaoInf=new EventDaoImpl();
	EventVO eventVO=new EventVO();
	private List<EventVO> eventGridList=null;
	private Map<Integer,String> eventCategoryMapList=null; 
	
	
	
	
	public EventAction() throws Exception{
		
		eventGridList=eventDaoInf.showEventDetail();
		eventCategoryMapList=listHelper.eventCategoryList();
	} 
	
	
	public String insertNewEvent()throws OMIApplicationException{
		String message=eventServiceInf.insertNewEvent(eventVO);
		CustomerSessionUser customerSessionUser=LoginUtil.getCurrentCustomerUser();
		eventVO.setCreatedBy(customerSessionUser.getCustomerId());

		if (OMIConstants.TARGET_SUCCESS.equalsIgnoreCase(message)) {
			logger.info("Successfully Insert Event Details!");
			addActionMessage("Successfully Insert Event Details!");
			return SUCCESS;

		} else if (OMIConstants.TARGET_FAILURE.equalsIgnoreCase(message)) {

			logger.info("Error:while  Insert Event Details!");
			addActionError("Error:while  Insert Event Details!");
			return ERROR;
		}
		 else  {
				logger.info("Error:while  Insert Event Details!");
				addActionError("Error:while  Insert Event Details!");
				return ERROR;
			}
	}
	
	
	
	/**
	 * <p>
	 * <code>viewEventDetail()</code> method is use to view the Event details into view
	 * event page
	 * </p>
	 * 
	 * @return
	 * @throws Exception
	 * @author Rosu patel 
	 */
	
	
	public String viewEventDetail() throws Exception {
		
		try {
			int eventId = Integer.parseInt(request.getParameter("command"));
			
			LoginUtil.setProcessUserId(eventId);
			this.eventVO = VOMapperHelper.getEventFromDetails(eventVO,
					eventServiceInf.viewEventDetails(eventId));
			
			
			return SUCCESS;
		} catch (Exception exception) {
			logger.error("Fail while get view event details.");
			return ERROR;
		}
		
	}
	
	/**
	 * <p>
	 * <code>editEventDetails()</code> method is use to edit the event
	 * details based eventId
	 * </p>
	 * Roshan Patel
	 * 
	 * @return
	 * @throws Exception
	 */
	public String editEventDetails() throws OMIApplicationException {
		
		try {
			int eventId = Integer.parseInt(request.getParameter("command"));
			
			LoginUtil.setProcessUserId(eventId);
			
			eventServiceInf = new EventServiceImpl();
			this.eventVO = VOMapperHelper.getEventFromDetails(eventVO,
					eventServiceInf.editEventDetail(eventId));

			return SUCCESS;
		} catch (NullPointerException exception) {
			logger.error("Fail to get edit event details ! ", exception);
			return ERROR;
		}
	}
	/**
	 * <p>
	 * <code>updateEventDetails()</code> method is use to update the event
	 * details based eventId
	 * </p>
	 * Roshan Patel
	 * 
	 * @return
	 * @throws Exception
	 */
public String updateEventDetails()throws OMIApplicationException
{ 
	int eventId = LoginUtil.getProcessUserId();
	String message = eventServiceInf.updateEventDetail(eventVO, eventId);

	if (OMIConstants.TARGET_SUCCESS.equalsIgnoreCase(message)) {

		logger.info("Successfully Updated Event Information!");
		addActionMessage("Successfully Updated Event Information!");
		return SUCCESS;

	} else if (OMIConstants.TARGET_FAILURE.equalsIgnoreCase(message)) {

		logger.info("Error:while  Updating Event Information!");
		addActionError("Error:while  Updating Event Information!");
		return ERROR;
	}
	else  {
		logger.info("Error:while  Updation Event Details!");
		addActionError("Error:while  Updation Event Details!");
		return ERROR;
	}
	}
	@Override
	public EventVO getModel() {
		
		return eventVO;
	}


	/**
	 * @return the response
	 */
	public HttpServletResponse getResponse() {
		return response;
	}


	/**
	 * @param response the response to set
	 */
	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}


	/**
	 * @return the request
	 */
	public HttpServletRequest getRequest() {
		return request;
	}


	/**
	 * @param request the request to set
	 */
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}


	/**
	 * @return the eventGridList
	 */
	public List<EventVO> getEventGridList() {
		return eventGridList;
	}


	/**
	 * @param eventGridList the eventGridList to set
	 */
	public void setEventGridList(List<EventVO> eventGridList) {
		this.eventGridList = eventGridList;
	}


	/**
	 * @return the listHelper
	 */
	public ListHelper getListHelper() {
		return listHelper;
	}


	/**
	 * @param listHelper the listHelper to set
	 */
	public void setListHelper(ListHelper listHelper) {
		this.listHelper = listHelper;
	}


	/**
	 * @return the eventCategoryMapList
	 */
	public Map<Integer, String> getEventCategoryMapList() {
		return eventCategoryMapList;
	}


	/**
	 * @param eventCategoryMapList the eventCategoryMapList to set
	 */
	public void setEventCategoryMapList(Map<Integer, String> eventCategoryMapList) {
		this.eventCategoryMapList = eventCategoryMapList;
	}


	/**
	 * @return the session
	 */
	public Map<String, Object> getSession() {
		return session;
	}


	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		
	}


	/**
	 * @return the eventVO
	 */
	public EventVO getEventVO() {
		return eventVO;
	}


	/**
	 * @param eventVO the eventVO to set
	 */
	public void setEventVO(EventVO eventVO) {
		this.eventVO = eventVO;
	}


	/**
	 * @return the eventid
	 */
	public static String getEventid() {
		return eventId;
	}
	
	

}
