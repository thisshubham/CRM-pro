/**
 * 
 */
package com.bst.ckt.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bst.ckt.dto.Assignment;
import com.bst.ckt.exception.OMIApplicationException;
import com.bst.ckt.vo.AssignmentVO;


public interface AssignmentDaoInf {
	
	/**
	 * <P>
	 * <CODE>addDetails()</CODE> METHOD IS USE TO INSERT ASSIGNMENT DETAILS INTO
	 * DATABASE
	 * </P>
	 * 
	 * @param assignmentVO
	 * @return
	 * @throws OMIApplicationException
	 */

	public int addDetails(AssignmentVO assignmentVO) throws OMIApplicationException;



	public List<AssignmentVO> getAssignmentList()throws OMIApplicationException;



	public Assignment getAssignmentDetails(int assignmentId) throws Exception;


	/**
	 * <p>
	 * <code>editAssignmentDetail</code>Method will edit data from table based on assignmentId
	 * </p>
	 * 
	 * @return Assignment
	 * @throws OMIApplicationException
	 * @param int assignmentId
	 */

	public Assignment editAssignmentDetail(int assignmentId) throws Exception;


	/**
	 * <p>
	 * <code>getAssignmentDetailsForUpdate</code>Method will update data from table based on assignmentId
	 * </p>
	 * 
	 * @return Assignment
	 * @throws Exception
	 * @param int assignmentId
	 */
	
	public int getAssignmentDetailsForUpdate(AssignmentVO assignmentVO, int assignmentId) throws Exception;
	
	
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
	 * @param request
	 * @param response
	 * @param assignmentId
	 * @throws Exception
	 */
	public void assignmentPDF(HttpServletRequest request,
			HttpServletResponse response, int assignmentId)throws Exception;

}
