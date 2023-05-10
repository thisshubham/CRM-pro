package com.bst.ckt.dao;

import java.util.List;

import com.bst.ckt.exception.OMIApplicationException;
import com.bst.ckt.vo.LeadVO;

public interface ReportsDaoInf {

	/**
	 * <p>
	 * <code>showLeadFollowupReportsGrid()</code>this method is used to fetch lead followup details from database
	 * </p>
	 * 
	 * @return LeadVO List
	 * @throws OMIApplicationException
	 */
	public	List<LeadVO> showLeadFollowupReportsGrid() throws OMIApplicationException;
	


	/**
	 * <p>
	 * <code>getLeadIdList()</code> method design to fetch lead id list for search process. 
	 * </p>
	 * @param 
	 * @throws Exception
	 */
	public List<Integer> getLeadIdList()throws Exception;
}
