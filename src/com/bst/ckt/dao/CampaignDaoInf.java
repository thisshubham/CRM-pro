/**
 * 
 */
package com.bst.ckt.dao;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bst.ckt.exception.OMIApplicationException;
import com.bst.ckt.vo.CampaignVO;

/**
 * @author gurjar
 * 
 */
public interface CampaignDaoInf {

	/**
	 * <P>
	 * <CODE>insertCampaignDetail(CampaignVO campaignVO)</CODE> this method is
	 * use to insert campaign detail into database
	 * </P>
	 * 
	 * @param CampaignVO
	 *            campaignVO
	 * @return
	 * @throws Exception
	 */
	public int insertCampaignDetail(CampaignVO campaignVO) throws Exception;

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
	 * <code>CampaignVO retriveCampaignInfo(CampaignVO campaignVO, int campaignId</code>
	 * this method is use to view campaign detail list in gird.
	 * </p>
	 * 
	 * @param (CampaignVO campaignVO, int campaignId)
	 * @throws Exception
	 */
	public CampaignVO retriveCampaignInfo(CampaignVO campaignVO, int campaignId)
			throws Exception;

	/**
	 * <p>
	 * <code>deleteCampaignDetails(int campaignId)</code> method will help to
	 * delete campaign details base on campaignId.
	 * </p>
	 * * @param (int newsId)
	 * 
	 * @throws Exception
	 */
	public void deleteCampaignDetails(int campaignId) throws Exception;

	/**
	 * <p>
	 * <code>CampaignVO retriveCampaignDetails(CampaignVO campaignVO, int campaignId</code>
	 * this method is use to select campaign detail list in gird.
	 * </p>
	 * 
	 * @param (CampaignVO campaignVO, int campaignId)
	 * @throws Exception
	 */
	public CampaignVO retriveCampaignDetails(CampaignVO campaignVO,
			int campaignId) throws Exception;

	/**
	 * <p>
	 * <code>String updateCampaignInfo(CampaignVO campaignVO, int campaignId)</code>
	 * method is use to update Campaign information into database
	 * </p>
	 * 
	 * @param (CampaignVO campaignVO, int campaignId)
	 * @throws Exception
	 */
	public int updateCampaignDetails(CampaignVO campaignVO, int campaignId)throws Exception;

	/**
	 * <p>
	 * void campaignPDF(HttpServletRequest request,
			HttpServletResponse response, int campaignId)
	 * </p>
	 * method to generate the pdf report of campaign details from database
	 * 
	 * @return
	 * @throws Exception
	 */
	public void campaignPDF(HttpServletRequest request,
			HttpServletResponse response, int campaignId)throws Exception;
	
	/**
	 * <p>
	 * HashMap<String, String> getCampainNameList()
	 * </p>
	 * method to get campaign name List from database
	 * 
	 * @return
	 * @throws Exception
	 */
	public HashMap<String, String> getCampainNameList() throws OMIApplicationException;
	
	/**
	 * <p>
	 * HashMap<String, String> getExpectedRevenueList()
	 * </p>
	 * method to get Expected Revenue List from database
	 * 
	 * @return
	 * @throws Exception
	 */

	public HashMap<String, String> getExpectedRevenueList()throws OMIApplicationException;
	
	/**
	 * <p>
	 * HashMap<String, String> getExpectedClosingDate()
	 * </p>
	 * method to get Expected Closing Date List from database
	 * 
	 * @return
	 * @throws Exception
	 */

	public HashMap<String, String> getExpectedClosingDate() throws OMIApplicationException;
	/**
	 * <code>getCampaignDetails</code>
	 * <p>
	 * Method is used to get Campaign Details from the tab_Campaign table in database
	 * </p>
	 * 
	 * @return
	 * @throws OMIApplicationException
	 */
	public List<CampaignVO> getCampaignDetails(int searchId, String searchValue) throws OMIApplicationException;

}
