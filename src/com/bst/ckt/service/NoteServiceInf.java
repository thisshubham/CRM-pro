
package com.bst.ckt.service;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bst.ckt.dto.Note;
import com.bst.ckt.exception.OMIApplicationException;
import com.bst.ckt.vo.NoteVO;

/**
 * @author vinod
 *
 */
public interface NoteServiceInf {
	/**
	 * <p>
	 * <code>addNoteDetail()</code> Method is design to add Note information
	 * into database to maintain the Note.
	 * </p>
	 * 
	 * @throws OMIApplicationException;
	 */

	public String  addNoteDetail(NoteVO noteVO)throws OMIApplicationException;
	/**
	 * <p>
	 * <code>ViewNote()</code> Method is design to View Note information
	 * from database.
	 * </p>
	 * 
	 * @throws OMIApplicationException;
	 */

	public Note viewNote(int noteId) throws OMIApplicationException;
	/**
	 * <p>
	 * <code>updateNote()</code> Method is design to update Note information
	 * into database to maintain Note.
	 * </p>
	 * 
	 * @throws OMIApplicationException
	 */

	public Note editNoteDetails(int noteId)throws OMIApplicationException;
	/**
	 * <p>
	 * <code>viewNextNoteDetails()</code> Method is design to view Next Note information
	 * from database.
	 * </p>
	 * 
	 * @throws OMIApplicationException
	 */

	public Note viewNextNoteDetails(int noteId) throws OMIApplicationException;
	/**
	 * <p>
	 * <code>editNextNoteDetails()</code> Method is design to edit Next Note information
	 * into database.
	 * </p>
	 * 
	 * @throws OMIApplicationException
	 */


	public Note editNextNoteDetails(int noteId)throws OMIApplicationException;
	/**
	 * <p>
	 * <code>viewPreviousNoteDetails()</code> Method is design to view previous Note information
	 * from database.
	 * </p>
	 * 
	 * @throws OMIApplicationException
	 */


	public Note viewPreviousNoteDetails(int noteId)throws OMIApplicationException;
	
	/**
	 * <p>
	 * <code>editPreviousNoteDetails()</code> Method is design to edit previous Note information
	 * into database.
	 * </p>
	 * 
	 * @throws OMIApplicationException
	 */

	public Note editPreviousNoteDetails(int noteId)throws OMIApplicationException;
	
	/**
	 * <p>
	 * <code>updateNote()</code> Method is design to update Note information
	 * into database to maintain Note.
	 * </p>
	 * 
	 * @throws SQLException
	 * @throws Exception
	 */
	public String updateNote(NoteVO noteVO, int noteId) throws OMIApplicationException;
	
	/**
	 * <p>
	 * <code>retriveNoteDetailsGrid()</code> Method is design to retrive Note information
	 * into database to maintain Note.
	 * </p>
	 * 
	 * @throws SQLException
	 * @throws OMIApplicationException
	 */
	public List<NoteVO> retriveNoteDetailsGrid(NoteVO noteVO) throws OMIApplicationException;
	
	/**
	 * 
	 * <p>
	 * <code>noteExcelReport()</code>this method is use to generate the Excel
	 * Sheet for note Details from database
	 * </p>
	 * 
	 * @throws OMIApplicationException
	 * @param request
	 * @param response
	 */
	public void noteExcelReport(HttpServletRequest request,
			HttpServletResponse response)throws OMIApplicationException;
	
	/**
	 * 
	 * <p>
	 * <code>notedPDF()</code>this method is use to generate the pdf report
	 *  for note Details from database
	 * </p>
	 * 
	 * @throws OMIApplicationException
	 * @param request
	 * @param response
	 *  @param noteId
	 */
	public void notedPDF(HttpServletRequest request,
			HttpServletResponse response, int noteId)throws OMIApplicationException;

	
	
  

}
