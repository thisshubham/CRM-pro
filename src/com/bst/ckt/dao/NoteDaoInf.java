/**
 * 
 */
package com.bst.ckt.dao;

import java.util.HashMap;
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
public interface NoteDaoInf {

	/**
	 * <code>addNoteDetails</code>
	 * <p>
	 * Method get the data from noteVO and insert it into database in tab_note
	 * table with session user get created by from session
	 * </p>
	 * 
	 * @param noteVO
	 * @return
	 * @throws OMIApplicationException
	 */
	int addNoteDetails(NoteVO noteVO) throws OMIApplicationException;
	/**
	 * <code>showNoteDetails</code>
	 * <p>
	 * Method show the data into noteVO with session user get created by from session
	 * </p>
	 * 
	 * @param noteVO
	 * @return
	 * @throws OMIApplicationException
	 */

	public List<NoteVO> showNoteDetails() throws OMIApplicationException;
	/**
	 * <code>getnoteDetails</code>
	 * <p>
	 * Method get the data from noteVO and fetching the Note details for view from Database in tab_note
	 * table with session user get created by from session
	 * </p>
	 * 
	 * @param noteVO
	 * @return
	 * @throws OMIApplicationException
	 */

	public Note getNoteDetails(int noteId) throws OMIApplicationException;
	/**
	 * <code>getnoteDetailsForUpdate</code>
	 * <p>
	 * Method get the data from noteVO and update it into database in tab_note
	 * table with session user get created by from session
	 * </p>
	 * 
	 * @param noteVO
	 * @return
	 * @throws OMIApplicationException
	 */

	public Note getNoteDetailsForUpdate(int noteId)throws OMIApplicationException;
	/**
	 * <code>getNoteLastRecord</code>
	 * <p>
	 * Method get the las data from noteVO from database in tab_note
	 * table with session user get created by from session
	 * </p>
	 * 
	 * @param noteVO
	 * @return
	 * @throws OMIApplicationException
	 */

	public int getNoteLastRecord()throws OMIApplicationException;
	/**
	 * <code>updateNoteInfo</code>
	 * <p>
	 * Method update the data into database in tab_note
	 * table with session user get created by from session
	 * </p>
	 * 
	 * @param noteVO
	 * @return
	 * @throws OMIApplicationException
	 */

	int updateNoteInfo(NoteVO noteVO, int noteId) throws OMIApplicationException;
	
	/**
	 * <code>getNoteTitleListOfNote</code>
	 * <p>
	 * Method is used to get the Note Title from the tab_note table in database
	 * </p>
	 * 
	 * @return
	 * @throws OMIApplicationException
	 */
	HashMap<String, String> getNoteTitleListOfNote() throws OMIApplicationException;
	
	/**
	 * <code>getNoteTitleListOfNote</code>
	 * <p>
	 * Method is used to get the Created By from the tab_note table in database
	 * </p>
	 * 
	 * @return
	 * @throws OMIApplicationException
	 */
	HashMap<Integer, String> getCreatedByListOfNote() throws OMIApplicationException;
	
	/**
	 * <code>getNoteDetails</code>
	 * <p>
	 * Method is used to get Note Details from the tab_note table in database
	 * </p>
	 * 
	 * @return
	 * @throws OMIApplicationException
	 */
	List<NoteVO> getNoteDetails(int searchId, String searchValue) throws OMIApplicationException;
	
	/**
	 * <P>
	 * <CODE>leadPDF()</CODE> METHOD IS USE TO GENERATE PDF LEAD REPORT FROM
	 * DATABASE
	 * </P>
	 * 
	 * @param request
	 * @param response
	 * @param leadId
	 * @throws OMIApplicationException
	 */
	void notePDF(HttpServletRequest request, HttpServletResponse response,
			int noteId)throws OMIApplicationException;
	
	

}
