/**
 * 
 */
package com.bst.ckt.dao;

import java.util.List;

import com.bst.ckt.dto.EventDTO;
import com.bst.ckt.exception.OMIApplicationException;
import com.bst.ckt.vo.EventVO;

/**
 * @author Rosu
 *
 */
public interface EventDaoInf {
	/**
	 * <p>
	 * <code>insertEventDetail</code>this method is use to insert event detail
	 * into database
	 * </p>
	 * 
	 * @param eventVO
	 * @throws OMIApplicationException
	 */

public int insertEventDetail(EventVO eventVO)throws OMIApplicationException;
/**
 * <p>
 * <code>showEventDetail</code>this method is use to view Grid event detail
 * into database
 * </p>
 * 
 * @param 
 * @throws OMIApplicationException
 */

	public List<EventVO> showEventDetail()throws OMIApplicationException;
	/**
	 * <p>
	 * <code>viewProductDetails</code>this method is use to view  event detail
	 * into database
	 * </p>
	 * 
	 * @param 
	 * @throws OMIApplicationException
	 */	
public EventDTO viewEventDetails(int eventId)throws OMIApplicationException;
/**
 * <p>
 * <code>editEventDetails</code>this method is use to edit  event detail
 * into database
 * </p>
 * 
 * @param 
 * @throws OMIApplicationException
 */	
	public EventDTO editEventDetails(EventDTO eventDTO, int eventId)throws OMIApplicationException;
	/**
	 * <p>
	 * <code>updateEventDetails</code>this method is use to update  event detail
	 * into database
	 * </p>
	 * 
	 * @param 
	 * @throws OMIApplicationException
	 */	
public int updateEventDetails(EventVO eventVO, int eventId)throws OMIApplicationException;

}
