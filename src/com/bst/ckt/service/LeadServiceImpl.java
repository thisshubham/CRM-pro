package com.bst.ckt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.bst.ckt.common.LoginUtil;
import com.bst.ckt.common.OMIConstants;
import com.bst.ckt.dao.ExcelReportDaoImpl;
import com.bst.ckt.dao.ExcelReportDaoInf;
import com.bst.ckt.dao.LeadDaoImpl;
import com.bst.ckt.dao.LeadDaoInf;
import com.bst.ckt.dto.Lead;
import com.bst.ckt.exception.OMIApplicationException;
import com.bst.ckt.vo.LeadVO;

public class LeadServiceImpl implements LeadServiceInf {

	LeadDaoInf leadDaoInf = new LeadDaoImpl();
	ExcelReportDaoInf excelReportDaoInf = new ExcelReportDaoImpl();
	/**
	 * Creating Logger object, logger object mapped with LeadAction class for
	 * writing Loggers.
	 */
	private static final Logger logger = Logger
			.getLogger(LeadServiceImpl.class);

	/**
	 * 
	 * @param leadVO
	 * @return
	 */
	/**
	 * TARGET_SUCCESS; TARGET_FAILURE
	 */
	public String RegisterLeadDetail(LeadVO leadVO) throws Exception {

		leadDaoInf = new LeadDaoImpl();
		int target = leadDaoInf.insertLeadDetail(leadVO);

		if (target == 1) {
			logger.info("Successfully Insert Lead Details!");
			return OMIConstants.TARGET_SUCCESS;

		} else {

			logger.info("Error:while  Inserting  Lead Details into database!");
			return OMIConstants.TARGET_FAILURE;

		}

	}

	@Override
	public Lead viewLead(int leadId) throws Exception {
		Lead lead = null;
		try {
			lead = leadDaoInf.getLeadDetails(leadId);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return lead;
	}

	@Override
	public Lead editLeadDetails(int leadId) throws Exception {
		Lead lead = null;
		try {
			lead = leadDaoInf.getLeadDetailsForUpdate(leadId);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return lead;

	}

	/**
	 * <p>
	 * <code>leadExcelReport()</code>
	 * <p>
	 * 
	 * @param request
	 * @param response
	 * 
	 * @throws Exception
	 */
	public void leadExcelReport(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		excelReportDaoInf.retriveLeadExcelReport(request, response);
	}

	public void leadPDF(HttpServletRequest request,
			HttpServletResponse response, int leadId) {
		leadDaoInf.leadPDF(request, response, leadId);
	}

	/**
	 * <p>
	 * <code>addLeadTitle()</code> this method is design to add lead title into
	 * database.
	 * <p>
	 * 
	 * @param leadVO
	 * @throws OMIApplicationException
	 */
	public String addLeadTitle(LeadVO leadVO) throws Exception {

		leadDaoInf = new LeadDaoImpl();

		int target = leadDaoInf.isLeadTitleExist(leadVO.getLeadTitle());

		if (target != 1) {
			leadDaoInf.insertLeadTitle(leadVO);
			logger.info("Lead title inserted successfully.");
			return OMIConstants.RESULT_SUCCESS;
		} else {
			logger.error(LeadServiceImpl.class + "Lead title already exists");
			return OMIConstants.TARGET_LEAD_TITLE_ALREADY_EXIST;
		}
	}

	/**
	 * <p>
	 * <code>addLeadFollowUp()</code>
	 * <p>
	 * 
	 * @param leadVO
	 * @throws Exception
	 */
	@Override
	public String addLeadFollowUp(LeadVO leadVO) throws Exception {

		leadDaoInf = new LeadDaoImpl();
		int target = leadDaoInf.insertLeadFollowUp(leadVO);

		if (target == 1) {
			int leadId = leadVO.getLeadId();
			System.out.println("lead id inside service method" + leadId);
			leadDaoInf.updateLeadStatus(leadVO, leadId);
			logger.info("Successfully Inserted Lead Follow Up Details!");
			return OMIConstants.TARGET_SUCCESS;
		} else {

			logger.info("Error:while  Inserting  Lead Follow Up Details into database!");
			return OMIConstants.TARGET_FAILURE;
		}

	}

	/**
	 * <p>
	 * <code>addLeadSocialInformation()</code>
	 * <p>
	 * 
	 * @param leadVO
	 * @throws Exception
	 */
	@Override
	public String addLeadSocialInformation(LeadVO leadVO) throws Exception {

		leadDaoInf = new LeadDaoImpl();
		int target = leadDaoInf.insertLeadSocialInformation(leadVO);

		if (target == 1) {
			logger.info("Successfully Inserted Lead Social Details!");
			return OMIConstants.TARGET_SUCCESS;
		} else if (target == 2) {
			logger.info("Successfully Updated Lead Social Details!");
			return OMIConstants.TARGET_SUCCESS1;
		}
		logger.info("Error:while  Inserting  and Updating Lead Social Details into database!");
		return OMIConstants.TARGET_FAILURE;

	}

	/**
	 * <p>
	 * <code>updateLead()</code>
	 * <p>
	 * 
	 * @param leadVO
	 * @throws Exception
	 */
	@Override
	public String updateLead(LeadVO leadVO, int leadId) throws Exception {

		int target = leadDaoInf.updateLeadInfo(leadVO, leadId);

		if (target == 1) {
			logger.info("Successfully Update Lead Information!");
			return OMIConstants.TARGET_SUCCESS;
		} else {

			logger.info("Error:while  Updating Lead Information!");
			return OMIConstants.TARGET_FAILURE;
		}

	}

	/**
	 * <p>
	 * <code>updateLeadContactInfo()</code> This method is design to update lead
	 * contact information into database.
	 * <p>
	 * 
	 * @param leadId
	 *            int
	 * @param leadVO
	 *            LeadVO
	 * @throws Exception
	 */
	@Override
	public String updateLeadContactInfo(LeadVO leadVO, int leadId)
			throws Exception {

		int target = leadDaoInf.updateLeadContactInformation(leadVO, leadId);

		if (target == 1) {
			logger.info("Successfully Update Lead Contact Information!");
			return OMIConstants.TARGET_SUCCESS;
		} else {

			logger.info("Error:while  Updating Lead Contact Information!");
			return OMIConstants.TARGET_FAILURE;
		}
	}

	/**
	 * <p>
	 * <code>viewNextLeadDetails</code>
	 * <p>
	 * 
	 * @param leadId
	 *            int
	 * @throws Exception
	 */
	@Override
	public Lead viewNextLeadDetails(int leadId) throws Exception {

		Lead lead = null;
		try {
			leadId++;
			if (leadDaoInf.getLeadLastRecord() < leadId) {
				leadId = 0;
				LoginUtil.setProcessUserId(leadId);
				lead = new Lead();
				lead.setLeadId(0);
				return lead;
			} else {
				LoginUtil.setProcessUserId(leadId);
				lead = leadDaoInf.getLeadDetails(leadId);
				if (lead.getLeadId() == 0) {
					leadId = LoginUtil.getProcessUserId();
					LoginUtil.setProcessUserId(leadId);
					return lead;
				}
				lead = leadDaoInf.getLeadDetails(leadId);
			}

		} catch (Exception exception) {
			logger.error("no records found" + exception);
		}
		return lead;
	}

	/**
	 * <p>
	 * <code>editNextLeadDetails</code>
	 * <p>
	 * 
	 * @param leadId
	 *            int
	 * @throws Exception
	 */
	@Override
	public Lead editNextLeadDetails(int leadId) throws Exception {

		Lead lead = null;
		try {
			leadId++;
			if (leadDaoInf.getLeadLastRecord() < leadId) {
				leadId = 0;
				LoginUtil.setProcessUserId(leadId);
				lead = new Lead();
				lead.setLeadId(0);
				return lead;
			} else {
				LoginUtil.setProcessUserId(leadId);
				lead = leadDaoInf.getLeadDetailsForUpdate(leadId);
				if (lead.getLeadId() == 0) {
					leadId = LoginUtil.getProcessUserId();
					LoginUtil.setProcessUserId(leadId);
					return lead;
				}
				lead = leadDaoInf.getLeadDetailsForUpdate(leadId);
			}

		} catch (Exception exception) {
			logger.error("no records found" + exception);
		}
		return lead;
	}

	/**
	 * <p>
	 * <code>viewPreviousLeadDetails</code>
	 * <p>
	 * 
	 * @param leadId
	 *            int
	 * @throws Exception
	 */
	@Override
	public Lead viewPreviousLeadDetails(int leadId) throws Exception {

		Lead lead = null;
		try {
			leadId--;
			LoginUtil.setProcessUserId(leadId);
			lead = leadDaoInf.getLeadDetails(leadId);
			if (lead.getLeadId() == 0) {
				leadId = LoginUtil.getProcessUserId();
				LoginUtil.setProcessUserId(leadId);
				return lead;
			}
			lead = leadDaoInf.getLeadDetails(leadId);

		} catch (Exception exception) {
			logger.error("no records found" + exception);
		}
		return lead;
	}

	/**
	 * <p>
	 * <code>editPreviousLeadDetails</code>
	 * <p>
	 * 
	 * @param leadId
	 *            int
	 * @throws Exception
	 */
	@Override
	public Lead editPreviousLeadDetails(int leadId) throws Exception {

		Lead lead = null;
		try {
			leadId--;
			LoginUtil.setProcessUserId(leadId);
			lead = leadDaoInf.getLeadDetailsForUpdate(leadId);
			if (lead.getLeadId() == 0) {
				leadId = LoginUtil.getProcessUserId();
				LoginUtil.setProcessUserId(leadId);
				return lead;
			}
			lead = leadDaoInf.getLeadDetailsForUpdate(leadId);

		} catch (Exception exception) {
			logger.error("no records found" + exception);
		}
		return lead;
	}

	@Override
	public List<LeadVO> retriveLeadDetailsGrid(LeadVO leadVO) throws Exception {

		leadDaoInf = new LeadDaoImpl();
		int searchId = leadVO.getSearchId();
		String searchValue = "";

		if (searchId == 1) {
			searchValue = String.valueOf(leadVO.getLeadId());
			System.out.println("lead id ****= " + searchValue);
		} else if (searchId == 2) {
			searchValue = leadVO.getCompanyName();
		} else if (searchId == 3) {
			searchValue = String.valueOf(leadVO.getLeadTitle());
		} else if (searchId == 4) {
			searchValue = String.valueOf(leadVO.getContactPerson());
		} else if (searchId == 5) {
			searchValue = String.valueOf(leadVO.getLeadOwnerId());
		} else if (searchId == 6) {
			searchValue = leadVO.getLeadDate();
		} else if (searchId == 7) {
			searchValue = leadVO.getExpectedClosingDate();
		} else if (searchId == 8) {
			searchValue = String.valueOf(leadVO.getLeadStatus());
		}
		return leadDaoInf.getLeadDetails(searchId, searchValue);

	}

	@Override
	public Lead nextAndPreviousViewLead(int leadId, String actionType)
			throws OMIApplicationException {
		Lead lead = new Lead();
		leadDaoInf = new LeadDaoImpl();
		List<Lead> allLeadList = new ArrayList<Lead>();
		allLeadList = leadDaoInf.fetchDefectRaiseDetails();
		System.out.println("allLeadList.size() "+allLeadList.size());
		ListIterator<Lead> iterator = allLeadList.listIterator();
		if (actionType.equalsIgnoreCase(OMIConstants.RESULT_PREVIOUS_TYPE)) {
			if (allLeadList.get(0).getLeadId() == leadId) {
				while (iterator.hasNext()) {
					lead = iterator.next();
				}
				LoginUtil.setProcessUserId(lead.getLeadId());
				return lead;
			} else {
				while (iterator.hasNext()) {
					lead = iterator.next();
					if (lead.getLeadId() == leadId) {
						iterator.previousIndex();
						iterator.previous();
						lead = iterator.previous();
						LoginUtil.setProcessUserId(lead.getLeadId());
						return lead;
					}
				}
			}
		} else if (actionType.equalsIgnoreCase(OMIConstants.RESULT_NEXT_TYPE)) {

			lead = allLeadList.get(allLeadList.size() - 1);
			if (lead.getLeadId() == leadId) {
				while (iterator.hasNext()) {
					lead = iterator.next();
					LoginUtil.setProcessUserId(lead.getLeadId());
					return lead;
				}
			} else {
				while (iterator.hasNext()) {
					lead = iterator.next();
					if (lead.getLeadId() == leadId) {
						lead = iterator.next();
						LoginUtil.setProcessUserId(lead.getLeadId());
						return lead;
					}

				}

			}
		} else {
			logger.error("Fail to get request ");
			return lead;
		}
		return lead;

	}
}
