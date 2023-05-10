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
 * Class Name     ReportsDaoImpl.java     
 *                                                            
 * Creation Date  NOV 10, 2015 
 * 
 * Abstract       This is a Dao class is used  to retrieve data from database 
 *                and returns name of value based on input.
 *  
 * Amendment History (in chronological sequence): AUG 10, 2015 
 * 
 **********************************************************************
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
import com.bst.ckt.exception.OMIApplicationException;
import com.bst.ckt.framework.db.JdbcDAOSupport;
import com.bst.ckt.framework.db.JdbcHelper;
import com.bst.ckt.framework.util.DateTimeUtil;
import com.bst.ckt.helper.LeadStatus;
import com.bst.ckt.helper.NameHelper;
import com.bst.ckt.vo.LeadVO;

/**
 * @author sharif
 * 
 */
public class ReportsDaoImpl extends JdbcDAOSupport implements ReportsDaoInf {

	/**
	 * Creating Logger object, logger object mapped with ReportsDaoImpl class
	 * for writing Loggers.
	 */
	private static final Logger logger = Logger.getLogger(ReportsDaoImpl.class);

	PreparedStatement preparedStatement = null;
	Connection connection = null;
	ResultSet resultSet = null;
	StringBuffer sb = null;
	LeadVO leadVO = new LeadVO();






	/**
	 * <p>
	 * <code>showLeadFollowupReportsGrid()</code>this method is design to fetch
	 * lead followup details from database into dashboard grid of lead followup
	 * reports.
	 * </p>
	 * 
	 * @return customDateLeadReportsGrid
	 * @throws OMIApplicationException
	 */
	public List<LeadVO> showLeadFollowupReportsGrid()
			throws OMIApplicationException {
		ArrayList<LeadVO> leadFollowUpReports = new ArrayList<LeadVO>();

		try {

			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(QueryMaker.GET_LEAD_FOLLOWUP_DETAILS_REPORTS);
			resultSet = preparedStatement.executeQuery();

			
			while (resultSet.next()) {
				leadVO = new LeadVO();
				leadVO.setFollowUpId(resultSet.getInt("FOLLOWUP_ID"));
				leadVO.setFollowUpDate(DateTimeUtil
						.convertDatetoFormDateForView(resultSet
								.getString("FOLLOWUP_DATE")));
				leadVO.setFollowUpStatus(LeadStatus.getLeadStatus(resultSet
						.getInt("FOLLOWUP_STATUS")));
				NameHelper nameHelper = new NameHelper();
				leadVO.setFollowUpBy(nameHelper.getCustomerName(resultSet
						.getInt("REF_FOLLOWUP_BY")));
				leadVO.setCreatedByName(nameHelper.getCustomerName(resultSet
						.getInt("CREATED_BY")));
				leadVO.setFollowUpComment(resultSet.getString("COMMENT").trim());
				leadFollowUpReports.add(leadVO);
			}

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					ReportsDaoImpl.class
							+ ": Error:- Error: Occur in Query While fetching the lead followup details from Database",
					sqlException);

		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					ReportsDaoImpl.class
							+ ": Error:- While closing the Connection after fetching the lead followup details for view from Database",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return leadFollowUpReports;
	}
	
	
	/**
	 * <p>
	 * <code>getLeadIdList()</code> method use to fetch lead id list 
	 * from <code>TAB_LEAD_DETAILS</code> for search process from search bar.
	 * </p>
	 * 
	 * @return leadFollowUpDetails
	 */
	@Override
	public List<Integer> getLeadIdList() throws Exception {
		
		ArrayList<Integer> leadIdList = new ArrayList<Integer>();
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(QueryMaker.GET_LEAD_ID);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int leadId;
				leadId=resultSet.getInt("LEAD_ID");
				leadIdList.add(leadId);
			}

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			logger.error(
					LeadDaoImpl.class
							+ ": Error:- Error: Occur in Query While fetching lead id from Database",
					sqlException);

		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(
					LeadDaoImpl.class
							+ ": Error:- While closing the Connection after fetching the lead id from Database",
					exception);
		} finally {
			JdbcHelper.closeResultSet(resultSet);
			JdbcHelper.closePreparedStatement(preparedStatement);
			JdbcHelper.closeConnection(connection);
		}
		return leadIdList;
	}



	

	
}
