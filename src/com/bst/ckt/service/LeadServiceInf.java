package com.bst.ckt.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bst.ckt.dto.Lead;
import com.bst.ckt.exception.OMIApplicationException;
import com.bst.ckt.vo.LeadVO;

public interface LeadServiceInf {

	/**
	 * <p>
	 * <code>RegisterLeadDetail</code>this method is use to insert lead detail
	 * into database
	 * </p>
	 * 
	 * @param leadVO
	 * @throws Exception
	 */
	public String RegisterLeadDetail(LeadVO leadVO) throws Exception;

	/**
	 * <p>
	 * <code>viewLead</code>this method is use to view lead detail into database
	 * </p>
	 * 
	 * @param leadVO
	 * @return
	 * @throws Exception
	 */
	public Lead viewLead(int leadId) throws Exception;

	/**
	 * 
	 * @param leadId
	 * @return
	 * @throws Exception
	 */
	public Lead editLeadDetails(int leadId) throws Exception;

	/**
	 * 
	 * <p>
	 * <code>leadPDF</code>this method is use to generate the pdf for lead
	 * detail from database
	 * </p>
	 * 
	 * @param request
	 * @param response
	 */
	void leadPDF(HttpServletRequest request, HttpServletResponse response,
			int leadId);

	/**
	 * 
	 * <p>
	 * <code>leadExcelReport()</code>this method is use to generate the Excel
	 * Sheet for lead Dashboard from database
	 * </p>
	 * 
	 * @throws Exception
	 * @param request
	 * @param response
	 */
	public void leadExcelReport(HttpServletRequest request,
			HttpServletResponse response) throws Exception;

	/**
	 * <p>
	 * <code>addLeadTitle</code>this method is use to insert lead title into
	 * database
	 * </p>
	 * 
	 * @param leadVO
	 * @throws Exception
	 */
	public String addLeadTitle(LeadVO leadVO) throws Exception;

	/**
	 * <p>
	 * <code>addLeadFollowUp</code>this method is use to insert lead follow up
	 * into database
	 * </p>
	 * 
	 * @param leadVO
	 * @throws Exception
	 */
	public String addLeadFollowUp(LeadVO leadVO) throws Exception;

	/**
	 * <p>
	 * <code>addLeadSocialInformation()</code>this method is use to insert lead
	 * social information into database
	 * </p>
	 * 
	 * @param leadVO
	 * @throws Exception
	 */
	public String addLeadSocialInformation(LeadVO leadVO) throws Exception;

	/**
	 * <p>
	 * <code>updateLead()</code> Method is design to update lead information
	 * into database to maintain lead.
	 * </p>
	 * 
	 * @throws SQLException
	 * @throws Exception
	 */
	public String updateLead(LeadVO leadVO, int leadId) throws Exception;

	/**
	 * <p>
	 * <code>updateLeadContactInfo()</code> Method is design to update lead
	 * contact information from database
	 * </p>
	 * 
	 * 
	 * @throws Exception
	 */
	public String updateLeadContactInfo(LeadVO leadVO, int leadId)
			throws Exception;

	/**
	 * <p>
	 * <code>viewNextLeadDetails()</code>
	 * </p>
	 * 
	 * 
	 * @throws Exception
	 */
	public Lead viewNextLeadDetails(int leadId) throws Exception;

	/**
	 * <p>
	 * <code>viewPreviousLeadDetails()</code>
	 * </p>
	 * 
	 * 
	 * @throws Exception
	 */
	public Lead viewPreviousLeadDetails(int leadId) throws Exception;

	public List<LeadVO> retriveLeadDetailsGrid(LeadVO leadVO) throws Exception;

	public Lead editNextLeadDetails(int leadId)throws Exception;

	public Lead editPreviousLeadDetails(int leadId)throws Exception;

	
	/**
	 * next and previous
	 * @param leadId
	 * @param actionType
	 * @return
	 * @throws OMIApplicationException
	 */
	public Lead nextAndPreviousViewLead(int leadId, String actionType)throws OMIApplicationException;

}
