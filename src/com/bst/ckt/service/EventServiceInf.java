/**
 * 
 */
package com.bst.ckt.service;

import com.bst.ckt.dto.EventDTO;
import com.bst.ckt.dto.Product;
import com.bst.ckt.exception.OMIApplicationException;
import com.bst.ckt.vo.EventVO;

/**
 * @author Rosu
 *
 */
public interface EventServiceInf {
	/**
	 * <p>
	 * <code>insertNewEvent</code>this method is use to insert Event detail
	 * into database
	 * </p>
	 * 
	 * @param eventVO
	 * @throws Exception
	 */
	public String insertNewEvent(EventVO eventVO)throws OMIApplicationException;
	/**
	 * <p>
	 * <code>viewEventDetail</code>this method is use to View Event detail
	 * into database
	 * </p>
	 * 
	 * @param eventId
	 * @throws Exception
	 */
	public EventDTO viewEventDetails(int eventId)throws OMIApplicationException;
	/**
	 * <p>
	 * <code>editEventDetail</code>this method is use to Edit Event detail
	 * into database
	 * </p>
	 * 
	 * @param eventId
	 * @throws Exception
	 */
	public EventDTO editEventDetail(int eventId)throws OMIApplicationException;
	/**
	 * <p>
	 * <code>updateEventDetail</code>this method is use to updated Event detail
	 * into database
	 * </p>
	 * 
	 * @param eventId
	 * @throws Exception
	 */
	public String updateEventDetail(EventVO eventVO, int eventId)throws OMIApplicationException;

}
