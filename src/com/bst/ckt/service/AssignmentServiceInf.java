/**
 * 
 */
package com.bst.ckt.service;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bst.ckt.dto.Assignment;
import com.bst.ckt.exception.OMIApplicationException;
import com.bst.ckt.vo.AssignmentVO;

/**
 * <p>
 * <code>insertDetails</code>this method is use to insert assignment details
 * into database
 * </p>
 * 
 * @param assignmentVO
 * @throws OMIApplicationException
 */
public interface AssignmentServiceInf {

	public String insertDetails(AssignmentVO assignmentVO)
			throws OMIApplicationException;

	public List<AssignmentVO> fetchAssignmentList()
			throws OMIApplicationException;
	
	
	/**
	 * <p>
	 * <code>viewAssignment</code>this method is use to view assignment detail into database
	 * </p>
	 * 
	 * @param assignmentId
	 * @return
	 * @throws Exception
	 */

	public Assignment viewAssignment(int assignmentId) throws Exception;
	
	
	/**
	 * <p>
	 * <code>editAssignmentInfo</code>this method is use to edit assignment detail into database
	 * </p>
	 * 
	 * @param assignmentId
	 * @return
	 * @throws Exception
	 */

	public Assignment editAssignmentInfo(int assignmentId) throws Exception;
	
	
	/**
	 * <p>
	 * <code>updateAssignmentDetails</code>this method is use to update assignment details
	 * </p>
	 * 
	 * @param assignmentId
	 * @return
	 * @throws Exception
	 */

	public String updateAssignmentDetails(AssignmentVO assignmentVO,int assignmentId) throws Exception;
	
	/**
	 * 
	 * @param assignmentVO
	 * @return
	 * @throws Exception
	 */
	public List<AssignmentVO> retriveAssignmentDetailsGrid(
			AssignmentVO assignmentVO) throws Exception;
	/**
	 * 
	 * @param searchId
	 * @param searchValue
	 * @return
	 * @throws Exception
	 */
	public List<AssignmentVO> getSearchAssignmentDetails(int searchId,
			String searchValue) throws Exception;
	
	/**
	 * 
	 * @param searchId
	 * @param searchValue
	 * @return
	 * @throws Exception
	 */
	public void assignmentExcelReport(HttpServletRequest request,
			HttpServletResponse response)throws Exception;
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @param assignmentId
	 * @throws Exception
	 */
	public void assignmentPDF(HttpServletRequest request,
			HttpServletResponse response, int assignmentId)throws Exception;

}


