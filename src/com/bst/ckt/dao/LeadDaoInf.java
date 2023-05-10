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
 * Class Name     LeadDaoInf.java     
 *                                                            
 * Creation Date  AUG 20, 2015 
 * 
 * Abstract       This is Name helper class to retrieve data from database 
 *                and returns name of value based on input.
 *  
 * Amendment History (in chronological sequence): AUG 20, 2015 
 * 
 **********************************************************************
 */

package com.bst.ckt.dao;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bst.ckt.dto.Lead;
import com.bst.ckt.exception.OMIApplicationException;
import com.bst.ckt.vo.LeadTitleVO;
import com.bst.ckt.vo.LeadVO;

public interface LeadDaoInf {

	/**
	 * <P>
	 * <CODE>insertLeadDetail()</CODE> METHOD IS USE TO INSERT LEAD DETAILS INTO
	 * DATABASE
	 * </P>
	 * 
	 * @param leadVO
	 * @return
	 * @throws Exception
	 */
	public int insertLeadDetail(LeadVO leadVO) throws Exception;

	/**
	 * <P>
	 * <CODE>getLeadDetails()</CODE> METHOD IS USE TO FATCH LEAD DETAILS FROM
	 * DATABASE
	 * </P>
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<LeadVO> getLeadDetails(int searchId,String searchValue) throws Exception;


	/**
	 * <P>
	 * <CODE>leadPDF()</CODE> METHOD IS USE TO GENERATE PDF LEAD REPORT FROM
	 * DATABASE
	 * </P>
	 * 
	 * @param request
	 * @param response
	 * @param leadId
	 */
	void leadPDF(HttpServletRequest request, HttpServletResponse response,
			int leadId);
	
	/**
	 * 
	 * @param leadVO
	 */
	public void insertLeadTitle(LeadVO leadVO);
	

	/**
	 * 
	 * @return
	 */
	public List<LeadTitleVO> showTitles();

	/**
	 * 
	 * @param leadId
	 * @return
	 * @throws Exception
	 */
	public Lead getLeadDetails(int leadId) throws Exception;
	
	/**
	 * <P>
	 * <CODE>getLeadFollowUpDetails()</CODE> METHOD IS USE TO FETCH LEAD FOLLOW UP DETAILS FROM
	 * DATABASE
	 * </P>
	 * 
	 * @return leadVO
	 * @throws Exception
	 */
	public List<LeadVO> getLeadFollowUpDetails(int leadId) throws Exception;

	/**
	 * <P>
	 * <CODE>insertLeadFollowUp()</CODE> METHOD IS USE TO INSERT LEAD FOLLOW UP DETAILS FROM
	 * DATABASE
	 * </P>
	 * 
	 * @param leadVO
	 * @throws Exception
	 */
	public int insertLeadFollowUp(LeadVO leadVO)throws Exception;

	/**
	 * <P>
	 * <CODE>insertLeadSocialInformation()</CODE> METHOD IS USE TO INSERT LEAD SOCIAL INFORMATION DETAILS FROM
	 * DATABASE
	 * </P>
	 * 
	 * @param leadVO
	 * @throws Exception
	 */
	public int insertLeadSocialInformation(LeadVO leadVO)throws Exception;
	

	/**
	 * <P>
	 * <CODE>updateLeadInfo()</CODE> METHOD IS USE TO UPDATE LEAD INFORMATION DETAILS FROM
	 * DATABASE
	 * </P>
	 * 
	 * @param leadVO
	 * @throws Exception
	 */
	public int updateLeadInfo(LeadVO leadVO,int leadId)throws Exception;
	

	/**
	 * <P>
	 * <CODE>updateLeadContactInformation()</CODE> METHOD IS USE TO UPDATE LEAD CONTACT INFORMATION DETAILS INTO
	 *  DATABASE.
	 * </P>
	 * 
	 * @param leadId int
	 * @param leadVO LeadVO
	 * @throws Exception
	 */
	public int updateLeadContactInformation(LeadVO leadVO, int leadId)throws Exception;

	/**
	 * <p>
	 * <code>isLeadTitleExist()</code> method verify whether the lead title already exists
	 * </p>
	 * @return int
	 * @throws OMIApplicationException
	 */
	public int isLeadTitleExist(String leadTitle)throws Exception;

	/**
	 * <p>
	 * <code>updateLeadStatus()</code> method design to updated lead status 
	 * </p>
	 * @return int
	 * @param leadVO LeadVO
	 * @param leadId int
	 * @throws Exception
	 */
	public int updateLeadStatus(LeadVO leadVO, int leadId)throws Exception;

	/**
	 * <p>
	 * <code>getLeadSocialDetailsList()</code> method design to fetch lead social details 
	 * </p>
	 * @param 
	 * @throws Exception
	 */
	public List<LeadVO> getLeadSocialDetailsList(int leadVO)throws Exception;


	/**
	 * <p>
	 * <code>getCompanyNameListOfLead()</code> method design to fetch company name list of lead for search process. 
	 * </p>
	 * @param 
	 * @throws Exception
	 */
	public HashMap<String, String> getCompanyNameListOfLead()throws Exception;

	public Lead getLeadDetailsForUpdate(int leadId)throws Exception;

	public int getLeadLastRecord()throws Exception;
	
	public int getLeadFirstRecord()throws Exception;

	public List<Lead> fetchDefectRaiseDetails()throws OMIApplicationException;

}
