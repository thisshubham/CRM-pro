package com.bst.ckt.vo;

public class EstimateVO {

	
	private int itemIncId;
	private int id;
	private String estimateId;
	private String estimateDate;
	private int currencyId;
	private int clientId; 
	private String referenceNo;
	private String scanDocument;
	private String itemId;
	private String itemDescription;
	private String itemQuantity;
	private String itemPrice;
	//private float itemTax;
	private String itemTax;
	private String amount;
	private String subTotal;
	private String totalTax;
	private String total;
	private String discount;
	private String netTotal;
	private String clientName;
	private String currencyName;
	private String createdDate;
	private int CreatedBy;
	private String updatedDate;
	private int updatedBy;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @return the estimateId
	 */
	public String getEstimateId() {
		return estimateId;
	}
	/**
	 * @return the estimateDate
	 */
	public String getEstimateDate() {
		return estimateDate;
	}
	/**
	 * @return the currencyId
	 */
	public int getCurrencyId() {
		return currencyId;
	}
	/**
	 * @return the clientId
	 */
	public int getClientId() {
		return clientId;
	}
	/**
	 * @return the referenceNo
	 */
	public String getReferenceNo() {
		return referenceNo;
	}
	/**
	 * @return the scanDocument
	 */
	public String getScanDocument() {
		return scanDocument;
	}
	/**
	 * @return the itemId
	 */
	public String getItemId() {
		return itemId;
	}
	/**
	 * @return the itemDescription
	 */
	public String getItemDescription() {
		return itemDescription;
	}
	/**
	 * @return the itemQuantity
	 */
	public String getItemQuantity() {
		return itemQuantity;
	}
	/**
	 * @return the itemPrice
	 */
	public String getItemPrice() {
		return itemPrice;
	}
	
	/**
	 * @return the amount
	 */
	public String getAmount() {
		return amount;
	}
	/**
	 * @return the total
	 */
	public String getTotal() {
		return total;
	}
	/**
	 * @return the discount
	 */
	public String getDiscount() {
		return discount;
	}
	/**
	 * @return the netTotal
	 */
	public String getNetTotal() {
		return netTotal;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @param estimateId the estimateId to set
	 */
	public void setEstimateId(String estimateId) {
		this.estimateId = estimateId;
	}
	/**
	 * @param estimateDate the estimateDate to set
	 */
	public void setEstimateDate(String estimateDate) {
		this.estimateDate = estimateDate;
	}
	/**
	 * @param currencyId the currencyId to set
	 */
	public void setCurrencyId(int currencyId) {
		this.currencyId = currencyId;
	}
	/**
	 * @param clientId the clientId to set
	 */
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	/**
	 * @param referenceNo the referenceNo to set
	 */
	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}
	/**
	 * @param scanDocument the scanDocument to set
	 */
	public void setScanDocument(String scanDocument) {
		this.scanDocument = scanDocument;
	}
	/**
	 * @param itemId the itemId to set
	 */
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	/**
	 * @param itemDescription the itemDescription to set
	 */
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
	/**
	 * @param itemQuantity the itemQuantity to set
	 */
	public void setItemQuantity(String itemQuantity) {
		this.itemQuantity = itemQuantity;
	}
	/**
	 * @param itemPrice the itemPrice to set
	 */
	public void setItemPrice(String itemPrice) {
		this.itemPrice = itemPrice;
	}
	

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(String amount) {
		this.amount = amount;
	}
	/**
	 * @param total the total to set
	 */
	public void setTotal(String total) {
		this.total = total;
	}
	/**
	 * @param discount the discount to set
	 */
	public void setDiscount(String discount) {
		this.discount = discount;
	}
	/**
	 * @param netTotal the netTotal to set
	 */
	public void setNetTotal(String netTotal) {
		this.netTotal = netTotal;
	}
	/**
	 * @return the clientName
	 */
	public String getClientName() {
		return clientName;
	}
	/**
	 * @return the currencyName
	 */
	public String getCurrencyName() {
		return currencyName;
	}
	/**
	 * @param clientName the clientName to set
	 */
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	/**
	 * @param currencyName the currencyName to set
	 */
	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
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
	 * @return the subTotal
	 */
	public String getSubTotal() {
		return subTotal;
	}
	/**
	 * @param subTotal the subTotal to set
	 */
	public void setSubTotal(String subTotal) {
		this.subTotal = subTotal;
	}
	/**
	 * @return the totalTax
	 */
	public String getTotalTax() {
		return totalTax;
	}
	/**
	 * @param totalTax the totalTax to set
	 */
	public void setTotalTax(String totalTax) {
		this.totalTax = totalTax;
	}
	/**
	 * @return the createdBy
	 */
	public int getCreatedBy() {
		return CreatedBy;
	}
	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(int createdBy) {
		CreatedBy = createdBy;
	}
	/**
	 * @return the itemTax
	 */
	public String getItemTax() {
		return itemTax;
	}
	/**
	 * @param itemTax the itemTax to set
	 */
	public void setItemTax(String itemTax) {
		this.itemTax = itemTax;
	}
	/**
	 * @return the updatedDate
	 */
	public String getUpdatedDate() {
		return updatedDate;
	}
	/**
	 * @param updatedDate the updatedDate to set
	 */
	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}
	/**
	 * @return the updatedBy
	 */
	public int getUpdatedBy() {
		return updatedBy;
	}
	/**
	 * @param updatedBy the updatedBy to set
	 */
	public void setUpdatedBy(int updatedBy) {
		this.updatedBy = updatedBy;
	}
	/**
	 * @return the itemIncId
	 */
	public int getItemIncId() {
		return itemIncId;
	}
	/**
	 * @param itemIncId the itemIncId to set
	 */
	public void setItemIncId(int itemIncId) {
		this.itemIncId = itemIncId;
	}
	
}
