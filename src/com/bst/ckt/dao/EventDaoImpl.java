/**
 * 
 */
package com.bst.ckt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;


import com.bst.ckt.common.QueryMaker;
import com.bst.ckt.dto.EventDTO;
import com.bst.ckt.dto.Product;
import com.bst.ckt.exception.OMIApplicationException;
import com.bst.ckt.framework.db.JdbcDAOSupport;
import com.bst.ckt.framework.db.JdbcHelper;
import com.bst.ckt.framework.util.DateTimeUtil;
import com.bst.ckt.vo.EventVO;
import com.bst.ckt.vo.ProductVO;

/**
 * @author Rosu
 *
 */
public class EventDaoImpl extends JdbcDAOSupport implements EventDaoInf{
	
	/**
	 * Creating Logger object, logger object mapped with EventDaoImpl class for
	 * writing Loggers.
	 */
	private static final Logger logger = Logger.getLogger(EventDaoImpl.class);
     EventVO eventVO=null;
     EventDTO eventDTO=null;
     Connection connection=null;
     ResultSet resultSet=null;
     PreparedStatement preparedStatement=null;
     
     
     /**
 	 * <p>
 	 * <code>insertEventDetail(eventVO)</code> method use to insert product details
 	 * into TAB_EVENT_DETAILS table.
 	 * </p>
 	 * 
 	 * @param eventVO
 	 * @return target
 	 * @throws Exception
 	 */
	@Override
	public int insertEventDetail(EventVO eventVO)throws OMIApplicationException{
	String insertEventQuery = QueryMaker.INSERT_EVENT_DETAIL;
	int target = 0;
	try {
		connection = getConnection();
		preparedStatement = connection.prepareStatement(insertEventQuery);

		preparedStatement.setString(1, eventVO.getEventTitle());
		
		preparedStatement.setString(2, eventVO.getEventDate());
		
		preparedStatement.setString(3, eventVO.getEventCategory());
		preparedStatement.setString(4, eventVO.getOrganizeName());
		preparedStatement.setString(5, eventVO.getMobileIsd());
		preparedStatement.setString(6, eventVO.getMobileNo());
		preparedStatement.setString(7, eventVO.getEmail());
		preparedStatement.setString(8, eventVO.getUrlNo());
		preparedStatement.setString(9, eventVO.getEventStatus());
		preparedStatement.setString(10, eventVO.getEventVanue());
		preparedStatement.setString(11,eventVO.getPublishDate());
		preparedStatement.setString(12, eventVO.getEventFile());
		preparedStatement.setString(13, eventVO.getDescripation());
		preparedStatement.setString(14, DateTimeUtil.getCurrentDate());
		preparedStatement.setString(15, eventVO.getMobileNumber());
		preparedStatement.executeUpdate();

		target = 1;

	} catch (SQLException sqlException) {

		logger.error(
				EventDaoImpl.class
						+ "Error: Occur in Query While Inserting the event Details into Database.",
				sqlException);

	} catch (Exception exception) {

		logger.error(
				EventDaoImpl.class
						+ "Error: Occur While Closing Connection After Inserting the event Details into Database.",
				exception);
	} finally {
		JdbcHelper.closePreparedStatement(preparedStatement);
		JdbcHelper.closeConnection(connection);
	}
	return target;
}
	/**
	 * <p>
	 * <code>showEventDetail()</code> method use to fetch event grid into
	 * TAB_EVENT_DETAILS table.
	 * </p>
	 * 
	 * @param eventVO
	 * 
	 * @return eventList
	 */
		@Override
	public List<EventVO> showEventDetail() throws OMIApplicationException {
		
		List<EventVO> eventList = new ArrayList<EventVO>();
		String showeventQuery = QueryMaker.SHOW_EVENT_DETAIL;
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(showeventQuery);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				eventVO = new EventVO();
				eventVO.setEventId(resultSet.getInt("EVENT_ID"));				
				eventVO.setEventTitle(resultSet.getString("EVENT_TITLE"));
				eventVO.setEventCategory(resultSet.getString("EVENT_CATEGORY"));
				eventVO.setOrganizeName(resultSet.getString("EVENT_ORGANIZE_NAME"));
				eventVO.setEventStatus(resultSet.getString("EVENT_STATUS"));
				eventVO.setPublishDate(resultSet.getString("EVENT_PUBLISH_DATE"));
				

				eventList.add(eventVO);

			}

		} catch (SQLException sqlExp) {
			
			logger.error(
					EventDaoImpl.class
							+ "Error: Occur in Query While Fetching  Event Detail from Database.",
					sqlExp);
		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					EventDaoImpl.class
							+ "Error: Occur in Query While Closing Connection After Fetching Event Detail from Database.",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}

		return eventList;
	}
	@Override
	public EventDTO viewEventDetails(int eventId)
			throws OMIApplicationException {
		eventDTO = new EventDTO();

		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.SHOW_VIEW_EVENT_DETAIL);
			preparedStatement.setInt(1, eventId);
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {

					eventDTO.setEventId(resultSet.getInt("EVENT_ID"));
					
					eventDTO.setEventTitle(resultSet.getString("EVENT_TITLE"));
					eventDTO.setEventDate(resultSet.getString("EVENT_DATE_TIME"));
					eventDTO.setEventCategory(resultSet.getString("EVENT_CATEGORY"));
					eventDTO.setOrganizeName(resultSet.getString("EVENT_ORGANIZE_NAME"));
					eventDTO.setMobileIsd(resultSet.getString("MOBILE_ISD"));
					eventDTO.setMobileNo(resultSet.getString("MOBILE_NO"));
					
					eventDTO.setEmail(resultSet.getString("EVENT_EMAIL"));
					eventDTO.setUrlNo(resultSet.getString("EVENT_URL"));
					eventDTO.setEventStatus(resultSet.getString("EVENT_STATUS"));
					eventDTO.setEventVanue(resultSet.getString("EVENT_VENUE"));
					eventDTO.setPublishDate(resultSet.getString("EVENT_PUBLISH_DATE"));
					eventDTO.setEventFile(resultSet.getString("FILE_NAME"));
					eventDTO.setDescripation(resultSet.getString("DESCRIPTION"));
					eventDTO.setCreatedDate(DateTimeUtil
							.convertDatetoFormDateForView(resultSet
									.getString("CREATED_DATE")));
					
					
				}
			}
		} catch (SQLException sqlException) {
			
			logger.error(
					EventDaoImpl.class
							+ ": Error:- Error: Occur in Query While fetching the Event details for view from Database",
					sqlException);

		} catch (Exception exception) {
			
			logger.error(
					EventDaoImpl.class
							+ ": Error:- While closing the Connection after fetching the Event details for view from Database",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return eventDTO;
	}
	/**
	 * <p>
	 * <code>editEventDetails()</code> method use to fetch event edit into
	 * TAB_EVENT_DETAILS table.
	 * </p>
	 * 
	 * @param eventId
	 * 
	 * @return eventDTO
	 */
	@Override
	public EventDTO editEventDetails(EventDTO eventDTO, int eventId)
			throws OMIApplicationException {
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_EVENT_DETAIL_EDIT);
			preparedStatement.setInt(1, eventId);
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {

					eventDTO.setEventId(resultSet.getInt("EVENT_ID"));
					eventDTO.setEventTitle(resultSet.getString("EVENT_TITLE"));
					eventDTO.setEventDate(resultSet.getString("EVENT_DATE_TIME"));
					eventDTO.setEventCategory(resultSet.getString("EVENT_CATEGORY"));
					eventDTO.setOrganizeName(resultSet.getString("EVENT_ORGANIZE_NAME"));
					eventDTO.setMobileIsd(resultSet.getString("MOBILE_ISD"));
					eventDTO.setMobileNo(resultSet.getString("MOBILE_NO"));
					eventDTO.setEmail(resultSet.getString("EVENT_EMAIL"));
					eventDTO.setUrlNo(resultSet.getString("EVENT_URL"));
					eventDTO.setEventStatus(resultSet.getString("EVENT_STATUS"));
					eventDTO.setEventVanue(resultSet.getString("EVENT_VENUE"));
					eventDTO.setPublishDate(resultSet.getString("EVENT_PUBLISH_DATE"));
					eventDTO.setDescripation(resultSet.getString("DESCRIPTION"));

					

				}

			}
		} catch (SQLException sqlException) {
			
			logger.error(
					EventDaoImpl.class
							+ ": Error:- Error: Occur in Query While fetching the Event details from Database",
					sqlException);

		} catch (Exception exception) {
			
			logger.error(
					EventDaoImpl.class
							+ ": Error:- While closing the Connection after fetching the event details from Database",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}

		return eventDTO;
	}
	/**
	 * <p>
	 * <code>updateEventDetails()</code> method use to fetch event update into
	 * TAB_EVENT_DETAILS table.
	 * </p>
	 * 
	 * @param eventId
	 * 
	 * @return eventDTO
	 */
	@Override
	public int updateEventDetails(EventVO eventVO, int eventId)
			throws OMIApplicationException {
		int target = 0;

		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.UPDATE_EVENT_DETAIL);
			preparedStatement.setString(1, eventVO.getEventTitle());
			
			preparedStatement.setString(2, eventVO.getEventDate());
			
			preparedStatement.setString(3, eventVO.getEventCategory());
			preparedStatement.setString(4, eventVO.getOrganizeName());
			preparedStatement.setString(5, eventVO.getMobileIsd());
			preparedStatement.setString(6, eventVO.getMobileNo());
			preparedStatement.setString(7, eventVO.getEmail());
			preparedStatement.setString(8, eventVO.getUrlNo());
			preparedStatement.setString(9, eventVO.getEventStatus());
			preparedStatement.setString(10, eventVO.getEventVanue());
			preparedStatement.setString(11,eventVO.getPublishDate());
			preparedStatement.setString(12, eventVO.getEventFile());
			preparedStatement.setString(13, eventVO.getDescripation());
			
			
			preparedStatement.setInt(14, eventId);

			preparedStatement.executeUpdate();
			target = 1;

		} catch (SQLException sqlException) {
			
			logger.error(
					ProductDaoImpl.class
							+ ": Error:- Error: Occur in Query While updating the Event details into Database",
					sqlException);

		} catch (Exception exception) {
			
			logger.error(
					ProductDaoImpl.class
							+ ": Error:- While closing the Connection after updating the event social details into Database",
					exception);
		} finally {
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return target;
	}

	


}
