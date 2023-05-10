/**
 * 
 */
package com.bst.ckt.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.bst.ckt.common.LoginUtil;
import com.bst.ckt.common.OMIConstants;
import com.bst.ckt.dao.ExcelReportDaoImpl;
import com.bst.ckt.dao.ExcelReportDaoInf;
import com.bst.ckt.dao.NoteDaoImpl;
import com.bst.ckt.dao.NoteDaoInf;
import com.bst.ckt.dto.Note;
import com.bst.ckt.exception.OMIApplicationException;
import com.bst.ckt.vo.NoteVO;

/**
 * @author vinod
 *
 */
public class NoteServiceImpl implements NoteServiceInf {

	
	/**
	 * Creating Logger object, logger object mapped with LeadDaoImpl class for
	 * writing Loggers.
	 */
	public static final Logger logger = Logger.getLogger(NoteServiceImpl.class);
	NoteDaoInf noteDaoInf=new NoteDaoImpl();
	ExcelReportDaoInf excelReportDaoInf = new ExcelReportDaoImpl();
	
	
	/**
	 * 
	 */
	@Override
	public String addNoteDetail(NoteVO noteVO) throws OMIApplicationException {
		
		int target=noteDaoInf.addNoteDetails(noteVO);
		if (target == 1) {
			logger.info("Successfully Insert Note Details!");
			return OMIConstants.TARGET_SUCCESS;

		} else {

			logger.info("Error:while  Inserting  Note Details into database!");
			return OMIConstants.TARGET_FAILURE;

		}
		
		
	}


	@Override
	public Note viewNote(int noteId)throws OMIApplicationException {
		Note note = null;
		try {
			note = noteDaoInf.getNoteDetails(noteId);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return note;

	}


	@Override
	public Note editNoteDetails(int noteId) throws OMIApplicationException {
		Note note = null;
		try {
			note = noteDaoInf.getNoteDetailsForUpdate(noteId);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return note;
	}


	@Override
	public Note viewNextNoteDetails(int noteId) throws OMIApplicationException {
		Note note = null;
		try {
			noteId++;
			if (noteDaoInf.getNoteLastRecord() < noteId) {
				noteId = 0;
				LoginUtil.setProcessUserId(noteId);
				note = new Note();
				note.setNoteId(0);
				return note;
			} else {
				LoginUtil.setProcessUserId(noteId);
				note = noteDaoInf.getNoteDetails(noteId);
				if (note.getNoteId() == 0) {
					noteId = LoginUtil.getProcessUserId();
					LoginUtil.setProcessUserId(noteId);
					return note;
				}
				note = noteDaoInf.getNoteDetails(noteId);
			}

		} catch (Exception exception) {
			logger.error("no records found" + exception);
		}
		return note;

	}


	@Override
	public Note editNextNoteDetails(int noteId) throws OMIApplicationException {
		Note note = null;
		try {
			noteId++;
			if (noteDaoInf.getNoteLastRecord() < noteId) {
				noteId = 0;
				LoginUtil.setProcessUserId(noteId);
				note = new Note();
				note.setNoteId(0);
				return note;
			} else {
				LoginUtil.setProcessUserId(noteId);
				note = noteDaoInf.getNoteDetailsForUpdate(noteId);
				if (note.getNoteId() == 0) {
					noteId = LoginUtil.getProcessUserId();
					LoginUtil.setProcessUserId(noteId);
					return note;
				}
				note = noteDaoInf.getNoteDetailsForUpdate(noteId);
			}

		} catch (Exception exception) {
			logger.error("no records found" + exception);
		}
		return note;

	}


	@Override
	public Note viewPreviousNoteDetails(int noteId)
			throws OMIApplicationException {
		Note note = null;
		try {
			noteId--;
			LoginUtil.setProcessUserId(noteId);
			note = noteDaoInf.getNoteDetails(noteId);
			if (note.getNoteId() == 0) {
				noteId = LoginUtil.getProcessUserId();
				LoginUtil.setProcessUserId(noteId);
				return note;
			}
			note = noteDaoInf.getNoteDetails(noteId);

		} catch (Exception exception) {
			logger.error("no records found" + exception);
		}
		return note;

	}


	@Override
	public Note editPreviousNoteDetails(int noteId)
			throws OMIApplicationException {
		Note note = null;
		try {
			noteId--;
			LoginUtil.setProcessUserId(noteId);
			note = noteDaoInf.getNoteDetailsForUpdate(noteId);
			if (note.getNoteId() == 0) {
				noteId = LoginUtil.getProcessUserId();
				LoginUtil.setProcessUserId(noteId);
				return note;
			}
			note = noteDaoInf.getNoteDetailsForUpdate(noteId);

		} catch (Exception exception) {
			logger.error("no records found" + exception);
		}
		return note;
	}


	@Override
	public String updateNote(NoteVO noteVO, int noteId) throws OMIApplicationException{
		int target = noteDaoInf.updateNoteInfo(noteVO, noteId);

		if (target == 1) {
			logger.info("Successfully Update Lead Information!");
			return OMIConstants.TARGET_SUCCESS;
		} else {

			logger.info("Error:while  Updating Lead Information!");
			return OMIConstants.TARGET_FAILURE;
		}
	}


	@Override
	public List<NoteVO> retriveNoteDetailsGrid(NoteVO noteVO)
			throws OMIApplicationException {
		noteDaoInf = new NoteDaoImpl();
		int searchId = noteVO.getSearchId();
		String searchValue = "";

		if(searchId==1){
			searchValue = String.valueOf(noteVO.getNoteId());
		}else if (searchId == 2) {
			searchValue = noteVO.getNoteTitle();
		} else if (searchId == 3) {
			searchValue = String.valueOf(noteVO.getCreatedBy());
		} else if (searchId == 4) {
			searchValue = String.valueOf(noteVO.getCreatedDate());
		} 
		return noteDaoInf.getNoteDetails(searchId, searchValue);
	}

	/**
	 * <p>
	 * <code>noteExcelReport()</code>
	 * <p>
	 * 
	 * @param request
	 * @param response
	 * 
	 * @throws OMIApplicationException
	 */
	

	@Override
	public void noteExcelReport(HttpServletRequest request,
			HttpServletResponse response) throws OMIApplicationException {
		
		excelReportDaoInf.retrivenoteExcelReport(request, response);
	}


	@Override
	public void notedPDF(HttpServletRequest request,
			HttpServletResponse response, int noteId)
			throws OMIApplicationException {
		noteDaoInf.notePDF(request, response, noteId);
		
	}

	
	

}
