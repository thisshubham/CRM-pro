package com.bst.ckt.dto;

public class SupportFaq {

	private int faqId;
	private String question;
	private String answer;
	private String productName;
	private String status;
	private String category;
	private int createdBy;
	private String date;
	private String owner;
	private int searchId;
	private String searchValue;

	public int getFaqId() {
		return faqId;
	}

	public void setFaqId(int faqId) {
		this.faqId = faqId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * @return the owner
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * @param owner
	 *            the owner to set
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}

	/**
	 * @return the searchId
	 */
	public int getSearchId() {
		return searchId;
	}

	/**
	 * @param searchId
	 *            the searchId to set
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
	 * @param searchValue
	 *            the searchValue to set
	 */
	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}

}
