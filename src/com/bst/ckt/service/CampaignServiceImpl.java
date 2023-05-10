/**
 * 
 */
package com.bst.ckt.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.bst.ckt.common.OMIConstants;
import com.bst.ckt.dao.CampaignDaoImpl;
import com.bst.ckt.dao.CampaignDaoInf;
import com.bst.ckt.dao.ExcelReportDaoImpl;
import com.bst.ckt.dao.ExcelReportDaoInf;
import com.bst.ckt.dao.LeadDaoImpl;
import com.bst.ckt.exception.OMIApplicationException;
import com.bst.ckt.vo.CampaignVO;

/**
 * @author gurjar
 * 
 */
public class CampaignServiceImpl implements CampaignServiceInf {

	CampaignDaoInf campainDaoInf = new CampaignDaoImpl();
	ExcelReportDaoInf excelReportDaoInf = new ExcelReportDaoImpl();
	/**
	 * Creating Logger object, logger object mapped with LeadAction class for
	 * writing Loggers.
	 */
	private static final Logger logger = Logger
			.getLogger(CampaignServiceImpl.class);

	/**
	 * @return the logger
	 */
	public static Logger getLogger() {
		return logger;
	}

	/**
	 * <p>
	 * <code>registerCampaignDetail(CampaignVO campaignVO)</code>this method is
	 * use to insert campaign detail into database
	 * </p>
	 * 
	 * @param campaignVO
	 * @return
	 * 
	 *         TARGET_SUCCESS; TARGET_FAILURE
	 */
	public String registerCampaignDetail(CampaignVO campaignVO)
			throws Exception {
		campainDaoInf = new CampaignDaoImpl();
		int target = campainDaoInf.insertCampaignDetail(campaignVO);

		if (target == 1) {
			logger.info("Successfully Insert campaign Details!");
			return OMIConstants.TARGET_SUCCESS;

		} else {

			logger.info("Error:while  Inserting  campaign Details into database!");
			return OMIConstants.TARGET_FAILURE;

		}
	}

	/**
	 * <p>
	 * <code>List<CampaignVO> getCampaignDetailsList()</code>this method is use
	 * to view campaign detail list in gird.
	 * </p>
	 * 
	 * @throws Exception
	 */
	public List<CampaignVO> getCampaignDetailsList() throws Exception {
		// Creating the CampaignDaoImpl for DAO Layer Access
		campainDaoInf = new CampaignDaoImpl();
		return campainDaoInf.getCampaignDetailsList();
	}

	/**
	 * <p>
	 * <code>CampaignVO viewCampaignInfo(CampaignVO campaignVO, int campaignId</code>
	 * this method is use to view campaign detail list in gird.
	 * </p>
	 * 
	 * @param (CampaignVO campaignVO, int campaignId)
	 * @throws Exception
	 */
	@Override
	public CampaignVO viewCampaignInfo(CampaignVO campaignVO, int campaignId)
			throws Exception {
		// Creating the CampaignDaoImpl for DAO Layer Access
		campaignVO = campainDaoInf.retriveCampaignInfo(campaignVO, campaignId);
		return campaignVO;
	}

	/**
	 * <p>
	 * <code>removeCampaignDetail(int campaignId)</code> method will help to
	 * delete campaign details base on campaignId.
	 * </p>
	 * * @param (int newsId)
	 * 
	 * @throws Exception
	 */
	public void removeCampaignDetail(int campaignId) throws Exception {
		// Creating the CampaignDaoImpl for DAO Layer Access
		campainDaoInf = new CampaignDaoImpl();
		campainDaoInf.deleteCampaignDetails(campaignId);
	}

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
			throws Exception {
		// Creating the CampaignDaoImpl for DAO Layer Access
		campaignVO = campainDaoInf.retriveCampaignDetails(campaignVO,
				campaignId);
		return campaignVO;
	}

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
			throws Exception {
		System.out.println("service");
		// Creating the CampaignDaoImpl for DAO Layer Access
		int target = campainDaoInf
				.updateCampaignDetails(campaignVO, campaignId);

		if (target == 1) {
			logger.info("Successfully Update Campaign Information!");
			return OMIConstants.TARGET_SUCCESS;
		} else {

			logger.info("Error:while  Updating Campaign Information!");
			return OMIConstants.TARGET_FAILURE;
		}

	}

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
			HttpServletResponse response, int campaignId) throws Exception {
		// Creating the CampaignDaoImpl for DAO Layer Access
		campainDaoInf.campaignPDF(request, response, campaignId);

	}

	@Override
	public List<CampaignVO> retrivecampaignDetailsGrid(CampaignVO campaignVO)
			throws OMIApplicationException {
		campainDaoInf = new CampaignDaoImpl();
		int searchId = campaignVO.getSearchId();
		String searchValue = "";

		if (searchId == 1) {
			searchValue = String.valueOf(campaignVO.getCampaignId());
			
		} else if (searchId == 2) {
			searchValue = campaignVO.getCampaignName();
		} else if (searchId == 3) {
			searchValue = String.valueOf(campaignVO.getCampaignType());
		} else if (searchId == 4) {
			searchValue = String.valueOf(campaignVO.getAssignedTo());
		} else if (searchId == 5) {
			searchValue = String.valueOf(campaignVO.getExpectedRevenue());
		} else if (searchId == 6) {
			searchValue = campaignVO.getExpectedCloseDate();
		} else if (searchId == 7) {
			searchValue = campaignVO.getCampaignStatus();
		}
		return campainDaoInf.getCampaignDetails(searchId, searchValue);

		
	}
	
	
	@Override
	public void campaignExcelReport(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		excelReportDaoInf.retriveCampaignExcelReport(request, response);
		
	}

}
