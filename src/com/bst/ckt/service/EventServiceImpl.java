/**
 * 
 */
package com.bst.ckt.service;

import org.apache.log4j.Logger;

import com.bst.ckt.common.OMIConstants;
import com.bst.ckt.dao.EventDaoImpl;
import com.bst.ckt.dao.EventDaoInf;
import com.bst.ckt.dao.ProductDaoImpl;
import com.bst.ckt.dao.ProductDaoInf;
import com.bst.ckt.dto.EventDTO;
import com.bst.ckt.dto.Product;
import com.bst.ckt.exception.OMIApplicationException;
import com.bst.ckt.vo.EventVO;

/**
 * @author Rosu
 *
 */
public class EventServiceImpl implements EventServiceInf {
	/**
	 * Creating Logger object, logger object mapped with EventServiceImpl class for
	 * writing Loggers.
	 */
	private static final Logger logger = Logger.getLogger(EventServiceImpl.class);
   EventDaoInf eventDaoInf=new EventDaoImpl();
  EventDTO eventDTO=null;
	@Override
	
	public String insertNewEvent(EventVO eventVO)
			throws OMIApplicationException {
		int target =eventDaoInf.insertEventDetail(eventVO);
		
		if (target == 1) {
			logger.info("Successfully Insert Event Details !");
			return OMIConstants.TARGET_SUCCESS;

		} else {
			logger.info("Error:while  Inserting  Event into Database!");
			return OMIConstants.TARGET_FAILURE;

		}
	}
	/**
	 * <p>
	 * <code>viewEventDetail()</code>Method will View event Information data from
	 * TAB_EVENT_DETAILS
	 * </p>
	 * 
	 * @return
	 * @throws Exception
	 * @param eventId
	 * @author Rosu
	 */
	@Override
	public EventDTO viewEventDetails(int eventId) throws OMIApplicationException {
		
		try {
			
			eventDTO = eventDaoInf.viewEventDetails(eventId);
			
		} catch (Exception exception) {
			logger.info("Error:while  Inserting  Event into Database!");
		}
		return eventDTO;
	}
	/**
	 * <p>
	 * <code>editEventDetail()</code>Method will edit Information data from
	 * TAB_EVENT_DETAILS
	 * </p>
	 * 
	 * @return
	 * @throws Exception
	 * @param eventId
	 * @author Rosu
	 */
	@Override
	public EventDTO editEventDetail(int eventId) throws OMIApplicationException {
		EventDaoInf eventDaoInf = new EventDaoImpl();
		EventDTO eventDTO=new EventDTO();
		try {
			eventDTO = eventDaoInf.editEventDetails(eventDTO,eventId);
			
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return eventDTO;
	}
	/**
	 * <p>
	 * <code>updateEventDetail()</code>Method will updated Information data from
	 * TAB_EVENT_DETAILS
	 * </p>
	 * 
	 * @return
	 * @throws Exception
	 * @param eventId
	 * @author Rosu
	 */
	@Override
	public String updateEventDetail(EventVO eventVO, int eventId)
			throws OMIApplicationException {
		EventDaoInf eventDaoInf = new EventDaoImpl();
		int target=eventDaoInf.updateEventDetails(eventVO,eventId);
		if (target == 1) {
			logger.info("Successfully Update Event Information!");
			return OMIConstants.TARGET_SUCCESS;
		} else {

			logger.info("Error:while  Updating Event Information!");
			return OMIConstants.TARGET_FAILURE;
		}
	}


}
