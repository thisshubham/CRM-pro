/**
 * 
 */
package com.bst.ckt.vo;

/**
 * @author vinod
 *
 */
public class NoteVO {
	
	private int noteId;
	private String noteDescription;
	private String createdBy;
	private String createdDate;
	private String noteTitle;
	private String noteTag;
	private int searchId;
	private String searchValue;
	
	/**
	 * @return the searchId
	 */
	public int getSearchId() {
		return searchId;
	}
	/**
	 * @param searchId the searchId to set
	 */
	public void setSearchId(int searchId) {
		this.searchId = searchId;
	}
	/**
	 * @return the searchValue
	 */
	public String getSearchValue() {
		return searchValue;
	}
	/**
	 * @param searchValue the searchValue to set
	 */
	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}
	/**
	 * @return the noteId
	 */
	public int getNoteId() {
		return noteId;
	}
	/**
	 * @param noteId the noteId to set
	 */
	public void setNoteId(int noteId) {
		this.noteId = noteId;
	}
	/**
	 * @return the noteDescription
	 */
	public String getNoteDescription() {
		return noteDescription;
	}
	/**
	 * @param noteDescription the noteDescription to set
	 */
	public void setNoteDescription(String noteDescription) {
		this.noteDescription = noteDescription;
	}
	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}
	/**
	 * @param i the createdBy to set
	 */
	public void setCreatedBy(String i) {
		this.createdBy = i;
	}
	/**
	 * @return the createdDate
	 */
	public String getCreatedDate() {
		return createdDate;
	}
	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	
	/**
	 * @return the noteTitle
	 */
	public String getNoteTitle() {
		return noteTitle;
	}
	/**
	 * @param noteTitle the noteTitle to set
	 */
	public void setNoteTitle(String noteTitle) {
		this.noteTitle = noteTitle;
	}
	/**
	 * @return the noteTag
	 */
	public String getNoteTag() {
		return noteTag;
	}
	/**
	 * @param noteTag the noteTag to set
	 */
	public void setNoteTag(String noteTag) {
		this.noteTag = noteTag;
	}
	
	

}
