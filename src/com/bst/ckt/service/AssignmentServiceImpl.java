/**
 * 
 */
package com.bst.ckt.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.bst.ckt.common.OMIConstants;
import com.bst.ckt.dao.AssignmentDaoImpl;
import com.bst.ckt.dao.AssignmentDaoInf;
import com.bst.ckt.dao.ExcelReportDaoImpl;
import com.bst.ckt.dao.ExcelReportDaoInf;
import com.bst.ckt.dao.SupportDaoImpl;
import com.bst.ckt.dao.SupportDaoInf;
import com.bst.ckt.dto.Assignment;
import com.bst.ckt.dto.Lead;
import com.bst.ckt.dto.SupportCases;
import com.bst.ckt.exception.OMIApplicationException;
import com.bst.ckt.vo.AssignmentVO;

/**
 * @author Admin
 * 
 */
public class AssignmentServiceImpl implements AssignmentServiceInf {

	private static final Logger logger = Logger
			.getLogger(AssignmentServiceImpl.class);

	AssignmentDaoInf assignmentDaoInf = new AssignmentDaoImpl();
	ExcelReportDaoInf excelReportDaoInf = new ExcelReportDaoImpl();

	/**
	 * 
	 * @param assignmentVO
	 * @return
	 */
	/**
	 * TARGET_SUCCESS; TARGET_FAILURE
	 */
	@Override
	public String insertDetails(AssignmentVO assignmentVO)
			throws OMIApplicationException {

		AssignmentDaoInf assignmentDaoInf = new AssignmentDaoImpl();
		int target=assignmentDaoInf.addDetails(assignmentVO);

		if (target == 1) {
			logger.info("Successfully Insert Lead Details!");
			return OMIConstants.TARGET_SUCCESS;

		} else {

			logger.info("Error:while  Inserting  Lead Details into database!");
			return OMIConstants.TARGET_FAILURE;

		}
	}

	@Override
	public List<AssignmentVO> fetchAssignmentList()
			throws OMIApplicationException {
		AssignmentDaoInf assignmentDaoInf = new AssignmentDaoImpl();
		return assignmentDaoInf.getAssignmentList();

	}

	@Override
	public Assignment viewAssignment(int assignmentId) throws Exception {
		Assignment assignment = null;
		try {
			assignmentDaoInf = new AssignmentDaoImpl();
			assignment = assignmentDaoInf.getAssignmentDetails(assignmentId);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return assignment;
	}

	@Override
	public Assignment editAssignmentInfo(int assignmentId) throws Exception {
		// Creating the AssignmentServiceImpl object
		AssignmentDaoInf assignmentDaoInf = new AssignmentDaoImpl();
		Assignment assignment = null;
		try {
			assignment = assignmentDaoInf.editAssignmentDetail(assignmentId);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return assignment;

	}

	/**
	 * <p>
	 * <code>updateAssignmentDetails</code>this method is use to update
	 * assignment details
	 * </p>
	 * 
	 * @param assignmentId
	 * @return
	 * @throws Exception
	 */
	@Override
	public String updateAssignmentDetails(AssignmentVO assignmentVO,
			int assignmentId) throws Exception {
		
		int target = assignmentDaoInf.getAssignmentDetailsForUpdate(
				assignmentVO, assignmentId);

		if (target == 1) {
			logger.info("Successfully Updating Assignment!");
			return OMIConstants.TARGET_SUCCESS;

		} else {
			logger.info("Error:while  Updating  Assignment into database!");
			return OMIConstants.TARGET_FAILURE;

		}

	}
	
	/**
	 * <p>
	 * <code>retriveAssignmentDetailsGrid</code>this method is use to retrieve
	 * assignment details
	 * </p>
	 * 
	 * @param assignmentVO
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<AssignmentVO> retriveAssignmentDetailsGrid(
			AssignmentVO assignmentVO) throws Exception {
		assignmentDaoInf = new AssignmentDaoImpl();
		int searchId = assignmentVO.getSearchId();
		String searchValue = "";

		if (searchId == 1) {
			
			searchValue = String.valueOf(assignmentVO.getAssignmentId());
			
		} else if (searchId == 2) {
			searchValue = assignmentVO.getAssignedTo();
		} else if (searchId == 3) {
			searchValue = String.valueOf(assignmentVO.getExpectedClosingDate());
		} 
		else if (searchId == 4) {
			searchValue = String.valueOf(assignmentVO.getAssignmentStatus());
		} 
		return assignmentDaoInf.getSearchAssignmentDetails(searchId, searchValue);

	}
	
	
	
	
	/**
		 * <p>
		 * <code>retriveAssignmentExcelReport</code>this method is use to retrieve
		 * assignment details
		 * </p>
		 * 
		 * @param assignmentVO
		 * @return
		 * @throws Exception
		 */
		public void assignmentExcelReport(HttpServletRequest request,
				HttpServletResponse response) throws Exception {
			excelReportDaoInf.retriveAssignmentExcelReport(request, response);
			
		}
		
		

		/**
		 * <p>
		 * <code>assignmentPDF</code>this method is use to retrieve
		 * assignment details
		 * </p>
		 * 
		 * @param assignmentVO
		 * @return
		 * @throws Exception
		 */
		public void assignmentPDF(HttpServletRequest request,
				HttpServletResponse response, int assignmentId) throws Exception {
			assignmentDaoInf.assignmentPDF(request, response, assignmentId);
		}

	@Override
	public List<AssignmentVO> getSearchAssignmentDetails(int searchId,
			String searchValue) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
