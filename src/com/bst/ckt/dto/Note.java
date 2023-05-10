package com.bst.ckt.dto;

public class Note {

	private int noteId;
	private String noteDescription;
	private String createdBy;
	private String createdDate;
	private String noteTitle;
	private String noteTag;

	/**
	 * @return the noteId
	 */
	public int getNoteId() {
		return noteId;
	}

	/**
	 * @param noteId
	 *            the noteId to set
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
	 * @param noteDescription
	 *            the noteDescription to set
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
	 * @param createdBy
	 *            the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the createdDate
	 */
	public String getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate
	 *            the createdDate to set
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
	 * @param noteTitle
	 *            the noteTitle to set
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
	 * @param noteTag
	 *            the noteTag to set
	 */
	public void setNoteTag(String noteTag) {
		this.noteTag = noteTag;
	}

}
