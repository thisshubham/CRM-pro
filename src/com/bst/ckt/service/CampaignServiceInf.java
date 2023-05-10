/**
 * 
 */
package com.bst.ckt.service;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bst.ckt.exception.OMIApplicationException;
import com.bst.ckt.vo.CampaignVO;

/**
 * @author gurjar
 * 
 */
public interface CampaignServiceInf {

	/**
	 * <p>
	 * <code>registerCampaignDetail(CampaignVO campaignVO)</code>this method is
	 * use to insert campaign detail into database
	 * </p>
	 * 
	 * @param CampaignVO
	 *            campaignVO
	 * @throws Exception
	 */
	public String registerCampaignDetail(CampaignVO campaignVO)
			throws Exception;

	/**
	 * <p>
	 * <code>List<CampaignVO> getCampaignDetailsList()</code>this method is use
	 * to view campaign detail list in gird.
	 * </p>
	 * 
	 * @throws Exception
	 */
	public List<CampaignVO> getCampaignDetailsList() throws Exception;

	/**
	 * <p>
	 * <code>CampaignVO viewCampaignInfo(CampaignVO campaignVO, int campaignId</code>
	 * this method is use to view campaign detail list in gird.
	 * </p>
	 * 
	 * @param (CampaignVO campaignVO, int campaignId)
	 * @throws Exception
	 */
	public CampaignVO viewCampaignInfo(CampaignVO campaignVO, int campaignId)
			throws Exception;

	/**
	 * <p>
	 * <code>removeCampaignDetail(int campaignId)</code>this method is use to
	 * remove campaign detail based on campaignId into the database
	 * </p>
	 * 
	 * @param (int campaignId)
	 * @throws Exception
	 */
	public void removeCampaignDetail(int campaignId) throws Exception;

	/**
	 * <p>
	 * <code>CampaignVO selectCampaignInfo(CampaignVO campaignVO, int campaignId</code>
	 * this method is use to select campaign detail list in gird.
	 * </p>
	 * 
	 * @param (CampaignVO campaignVO, int campaignId)
	 * @throws Exception
	 */
	public CampaignVO selectCampaignInfo(CampaignVO campaignVO, int campaignId)
			throws Exception;

	/**
	 * <p>
	 * <code>String updateCampaignInfo(CampaignVO campaignVO, int campaignId)</code>
	 * method is use to update Campaign information into database
	 * </p>
	 * 
	 * @param (CampaignVO campaignVO, int campaignId)
	 * @throws Exception
	 */
	public String updateCampaignInfo(CampaignVO campaignVO, int campaignId)
			throws Exception;

	/**
	 * <p>
	 * void campaignPDF(HttpServletRequest request, HttpServletResponse
	 * response, int campaignId)
	 * </p>
	 * method to generate the pdf report of campaign details from database
	 * 
	 * @return
	 * @throws Exception
	 */
	public void campaignPDF(HttpServletRequest request,
			HttpServletResponse response, int campaignId) throws Exception;

	/**
	 * <p>
	 * <code>retrivecampaignDetailsGrid()</code> Method is design to retrieve Campaign
	 * information into database to maintain Campaign.
	 * </p>
	 * 
	 * @throws SQLException
	 * @throws OMIApplicationException
	 */
	public List<CampaignVO> retrivecampaignDetailsGrid(CampaignVO campaignVO)
			throws OMIApplicationException;
	
	
	/**
	 * 
	 * <p>
	 * campaignExcelReport()</code>this method is use to generate the Excel
	 * Sheet for campaignDashboard from database
	 * </p>
	 * 
	 * @throws Exception
	 * @param request
	 * @param response
	 */
	public void campaignExcelReport(HttpServletRequest request,
			HttpServletResponse response);
	

}
