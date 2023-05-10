package com.bst.ckt.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.bst.ckt.common.LoginUtil;
import com.bst.ckt.common.OMIConstants;
import com.bst.ckt.dao.NoteDaoImpl;
import com.bst.ckt.dao.NoteDaoInf;
import com.bst.ckt.framework.user.CustomerSessionUser;
import com.bst.ckt.helper.NoteAdvanceSearch;
import com.bst.ckt.helper.VOMapperHelper;
import com.bst.ckt.service.NoteServiceImpl;
import com.bst.ckt.service.NoteServiceInf;
import com.bst.ckt.vo.NoteVO;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class NoteAction extends ActionSupport implements ModelDriven<NoteVO>,
		ServletRequestAware, ServletResponseAware {

	/**
	 * Creating Logger object, logger object mapped with LeadAction class for
	 * writing Loggers.
	 */
	private static final Logger logger = Logger.getLogger(NoteAction.class);
	HttpServletResponse response = null;
	HttpServletRequest request = (HttpServletRequest) ActionContext
			.getContext().get(ServletActionContext.HTTP_REQUEST);
	Map<String, Object> session = null;
	private List<NoteVO> noteDetailList = null;
	Map<String, Integer> productViewMap = null;
	private HashMap<Integer, String> advanceSearchList;
	private HashMap<String, String> noteTitleList;
	private HashMap<Integer, String> createdByList;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	NoteVO noteVO = new NoteVO();
	NoteServiceInf noteServiceInf = new NoteServiceImpl();
	NoteDaoInf noteDaoInf = new NoteDaoImpl();
	List<NoteVO> noteListDetail = null;

	/**
	 * <code>insertNote</code>
	 * <p>
	 * Method is use to insert note data into database.
	 * </p>
	 * 
	 * @return
	 * @throws Exception
	 */
	public String insertNoteDetail() throws Exception {
		CustomerSessionUser customerSessionUser = LoginUtil
				.getCurrentCustomerUser();
		noteVO.setCreatedBy(String.valueOf(customerSessionUser.getCustomerId()));
		String message = noteServiceInf.addNoteDetail(noteVO);
		/**
		 * TARGET_SUCCESS; TARGET_FAILURE
		 */
		if (OMIConstants.TARGET_SUCCESS.equalsIgnoreCase(message)) {
			logger.info("Successfully Insert Notes Details!");
			addActionMessage("Successfully Insert Lead Details!");
			return SUCCESS;

		} else if (OMIConstants.TARGET_FAILURE.equalsIgnoreCase(message)) {

			logger.info("Error:while  Insert Note Details!");
			addActionError("Error:while  Insert Note Details!");
			return ERROR;
		}

		return NONE;

	}

	/**
	 * <code>RetrivetNoteIntoGrid</code>
	 * <p>
	 * Method is use to retrive note details into grid from database.
	 * </p>
	 * 
	 * @return
	 * @throws Exception
	 */
	public NoteAction() throws Exception {

		noteListDetail = noteDaoInf.showNoteDetails();
		advanceSearchList = NoteAdvanceSearch.getNoteAdvanceSearchList();
		noteTitleList = noteDaoInf.getNoteTitleListOfNote();
		createdByList = noteDaoInf.getCreatedByListOfNote();

	}

	/**
	 * @return the noteListDetail
	 */
	public List<NoteVO> getNoteListDetail() {
		return noteListDetail;
	}

	/**
	 * @param noteListDetail
	 *            the noteListDetail to set
	 */
	public void setNoteListDetail(List<NoteVO> noteListDetail) {
		this.noteListDetail = noteListDetail;
	}

	/**
	 * <p>
	 * <code>viewNote()</code> method is use to view the note details into view
	 * note page
	 * </p>
	 * 
	 * @return
	 * @throws Exception
	 */
	public String viewNote() throws Exception {
		int noteId = Integer.parseInt(request.getParameter("command"));
		LoginUtil.setProcessUserId(noteId);
		this.noteVO = VOMapperHelper.getNoteVOFromNote(noteVO,
				noteServiceInf.viewNote(noteId));

		return SUCCESS;
	}

	/**
	 * <p>
	 * <code>editNote()</code>this method is design to get note details for the
	 * update process.
	 * </p>
	 * 
	 * @return SUCCESS
	 * @throws Exception
	 */
	public String editNote() throws Exception {
		int leadId = Integer.parseInt(request.getParameter("command"));
		if (leadId == 0)
			leadId = LoginUtil.getProcessUserId();
		LoginUtil.setProcessUserId(leadId);
		noteServiceInf = new NoteServiceImpl();
		this.noteVO = VOMapperHelper.getNoteVOFromNote(noteVO,
				noteServiceInf.editNoteDetails(leadId));
		return SUCCESS;
	}

	/**
	 * <p>
	 * <code>updateNote()</code> method is use to update note information into
	 * database
	 * </p>
	 * 
	 * @return SUCCESS
	 * @throws Exception
	 */

	public String updateNote() throws Exception {

		noteServiceInf = new NoteServiceImpl();
		CustomerSessionUser customerSessionUser = LoginUtil
				.getCurrentCustomerUser();
		noteVO.setCreatedBy(String.valueOf(customerSessionUser.getCustomerId()));
		int noteId = LoginUtil.getProcessUserId();
		String message = noteServiceInf.updateNote(noteVO, noteId);

		if (OMIConstants.TARGET_SUCCESS.equalsIgnoreCase(message)) {

			logger.info("Successfully Updated Note Information!");
			addActionMessage("Successfully Updated Note Information!");
			return SUCCESS;

		} else if (OMIConstants.TARGET_FAILURE.equalsIgnoreCase(message)) {

			logger.info("Error:while  Updating Note Information!");
			addActionError("Error:while  Updating Note Information!");
			return INPUT;
		}

		return NONE;
	}

	/**
	 * <p>
	 * <code>viewNextNote()</code> method is use to view the note details into
	 * view note page
	 * </p>
	 * 
	 * @return
	 * @throws Exception
	 */
	public String nextViewNote() throws Exception {
		int noteId = LoginUtil.getProcessUserId();
		this.noteVO = VOMapperHelper.getNoteVOFromNote(noteVO,
				noteServiceInf.viewNextNoteDetails(noteId));

		if (noteVO.getNoteId() != 0) {
			logger.info("Note details found successfully for Note Id  "
					+ noteVO.getNoteId());
			addActionMessage("Note details found successfully for Note Id "
					+ noteVO.getNoteId());
			return SUCCESS;
		} else {
			noteVO.setNoteId(LoginUtil.getProcessUserId());
			logger.error("Note details not found for Note Id  "
					+ noteVO.getNoteId());
			addActionError("Note details not found for Note Id "
					+ noteVO.getNoteId());
			return ERROR;

		}
	}

	/**
	 * <p>
	 * <code>editNextNote()</code> method is use to populate next note details
	 * into edit note page
	 * </p>
	 * 
	 * @return
	 * @throws Exception
	 */
	public String editNextNote() throws Exception {
		int noteId = LoginUtil.getProcessUserId();
		this.noteVO = VOMapperHelper.getNoteVOFromNote(noteVO,
				noteServiceInf.editNextNoteDetails(noteId));
		if (noteVO.getNoteId() != 0) {
			logger.info("Note details found successfully for Note Id  "
					+ noteVO.getNoteId());

			addActionMessage("Note details found successfully for Note Id "
					+ noteVO.getNoteId());
			return SUCCESS;
		} else {
			noteVO.setNoteId(LoginUtil.getProcessUserId());
			logger.error("Note details not found for Note Id  "
					+ noteVO.getNoteId());
			addActionError("Note details not found for Note Id "
					+ noteVO.getNoteId());
			return ERROR;

		}
	}

	/**
	 * <p>
	 * <code>viewNextNote()</code> method is use to view the note details into
	 * view note page
	 * </p>
	 * 
	 * @return
	 * @throws Exception
	 */
	public String previousViewNote() throws Exception {
		int noteId = LoginUtil.getProcessUserId();
		this.noteVO = VOMapperHelper.getNoteVOFromNote(noteVO,
				noteServiceInf.viewPreviousNoteDetails(noteId));

		if (noteVO.getNoteId() != 0) {
			logger.info("Note details found successfully for Note Id  "
					+ noteVO.getNoteId());
			addActionMessage("Note details found successfully for Note Id "
					+ noteVO.getNoteId());
			return SUCCESS;
		} else if (LoginUtil.getProcessUserId() == -1) {
			LoginUtil.setProcessUserId(noteDaoInf.getNoteLastRecord() + 1);
			logger.error("Note details not found");
			addActionError("Note details not found");
			return ERROR;
		} else {
			noteVO.setNoteId(LoginUtil.getProcessUserId());
			logger.error("Note details not found for Note Id  "
					+ noteVO.getNoteId());
			addActionError("Note details not found for Note Id "
					+ noteVO.getNoteId());
			return ERROR;

		}

	}

	/**
	 * <p>
	 * <code>previousEditNote()</code> method is use to view the note details
	 * into edit note page
	 * </p>
	 * 
	 * @return
	 * @throws Exception
	 */
	public String previousEditNote() throws Exception {
		int noteId = LoginUtil.getProcessUserId();
		this.noteVO = VOMapperHelper.getNoteVOFromNote(noteVO,
				noteServiceInf.editPreviousNoteDetails(noteId));

		if (noteVO.getNoteId() != 0) {
			logger.info("Note details found successfully for Note Id  "
					+ noteVO.getNoteId());
			addActionMessage("Note details found successfully for Note Id "
					+ noteVO.getNoteId());
			return SUCCESS;
		} else if (LoginUtil.getProcessUserId() == -1) {
			LoginUtil.setProcessUserId(noteDaoInf.getNoteLastRecord() + 1);
			logger.error("Note details not found");
			addActionError("Note details not found");
			return ERROR;
		} else {
			noteVO.setNoteId(LoginUtil.getProcessUserId());
			logger.error("Note details not found for Note Id  "
					+ noteVO.getNoteId());
			addActionError("Note details not found for Note Id "
					+ noteVO.getNoteId());
			return ERROR;

		}

	}

	/**
	 * <p>
	 * <code>noteDetailsGrid()</code> method is use to retrive the note details
	 * into note dashboard page
	 * </p>
	 * 
	 * @return
	 * @throws Exception
	 */

	public String noteDetailsGrid() throws Exception {

		noteServiceInf = new NoteServiceImpl();
		this.noteListDetail = noteServiceInf.retriveNoteDetailsGrid(noteVO);

		if (noteListDetail == null) {
			logger.error("Error:While getting note details as per advance search.");
			addActionError("No records found.");
			return ERROR;
		} else {
			logger.info("Records found successfully.");
			return SUCCESS;
		}

	}

	/**
	 * <p>
	 * excelReport()
	 * </p>
	 * method to generate the Excel Sheet report of note Dashboard from database
	 * 
	 * @return
	 * @throws Exception
	 * @author Vinod Patel
	 * @param request
	 *            ,response
	 */
	public String excelReport() throws Exception {
		noteServiceInf.noteExcelReport(request, response);
		return NONE;
	}
	
	/**
	 * <p>
	 * notePrintPDF()
	 * </p>
	 * method to generate the pdf report of note details from database
	 * 
	 * @return
	 * @throws Exception
	 */
	public String notePrintPDF() throws Exception {
		int noteId = Integer.parseInt(request.getParameter("command"));
		noteServiceInf.notedPDF(request, response, noteId);
		return null;
	}

	@Override
	public NoteVO getModel() {

		return noteVO;
	}

	/**
	 * @return the noteDetailList
	 */
	public List<NoteVO> getNoteDetailList() {
		return noteDetailList;
	}

	/**
	 * @param noteDetailList
	 *            the noteDetailList to set
	 */
	public void setNoteDetailList(List<NoteVO> noteDetailList) {
		this.noteDetailList = noteDetailList;
	}

	/**
	 * @return the productViewMap
	 */
	public Map<String, Integer> getProductViewMap() {
		return productViewMap;
	}

	/**
	 * @param productViewMap
	 *            the productViewMap to set
	 */
	public void setProductViewMap(Map<String, Integer> productViewMap) {
		this.productViewMap = productViewMap;
	}

	/**
	 * @return the noteVO
	 */
	public NoteVO getNoteVO() {
		return noteVO;
	}

	/**
	 * @param noteVO
	 *            the noteVO to set
	 */
	public void setNoteVO(NoteVO noteVO) {
		this.noteVO = noteVO;
	}

	/**
	 * @return the noteList
	 */
	public List<NoteVO> getNoteList() {
		return noteListDetail;
	}
	
	

	/**
	 * @return the session
	 */
	public Map<String, Object> getSession() {
		return session;
	}

	/**
	 * @param session the session to set
	 */
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	/**
	 * @param noteList
	 *            the noteList to set
	 */
	public void setNoteList(List<NoteVO> noteList) {
		this.noteListDetail = noteList;
	}

	/**
	 * @return the advanceSearchList
	 */
	public HashMap<Integer, String> getAdvanceSearchList() {
		return advanceSearchList;
	}

	/**
	 * @param advanceSearchList
	 *            the advanceSearchList to set
	 */
	public void setAdvanceSearchList(HashMap<Integer, String> advanceSearchList) {
		this.advanceSearchList = advanceSearchList;
	}

	/**
	 * @return the noteTitleList
	 */
	public HashMap<String, String> getNoteTitleList() {
		return noteTitleList;
	}

	/**
	 * @param noteTitleList
	 *            the noteTitleList to set
	 */
	public void setNoteTitleList(HashMap<String, String> noteTitleList) {
		this.noteTitleList = noteTitleList;
	}

	/**
	 * @return the createdByList
	 */
	public HashMap<Integer, String> getCreatedByList() {
		return createdByList;
	}

	/**
	 * @param createdByList
	 *            the createdByList to set
	 */
	public void setCreatedByList(HashMap<Integer, String> createdByList) {
		this.createdByList = createdByList;
	}

	/**
	 * @return the response
	 */
	public HttpServletResponse getResponse() {
		return response;
	}

	/**
	 * @param response
	 *            the response to set
	 */
	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	/**
	 * @return the request
	 */
	public HttpServletRequest getRequest() {
		return request;
	}

	/**
	 * @param request
	 *            the request to set
	 */
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		// TODO Auto-generated method stub
		this.response = response;

	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;
	}

}
