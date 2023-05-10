package com.bst.ckt.vo;

public class StockVO {

	
	private int stockId;
	private float purchasePrice;
	private float amount;
	private int noOfBags;
	private float bagsInTon;
	private String materialCode;
	private String hsnCode;
	private float unitPrice;
	private String producatCtegory;
	private String productType;
	private int searchId;
	private int aclId;
	private int userRole;
	
	public int getStockId() {
		return stockId;
	}
	public void setStockId(int stockId) {
		this.stockId = stockId;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public int getNoOfBags() {
		return noOfBags;
	}
	public void setNoOfBags(int noOfBags) {
		this.noOfBags = noOfBags;
	}
	public float getBagsInTon() {
		return bagsInTon;
	}
	public void setBagsInTon(float bagsInTon) {
		this.bagsInTon = bagsInTon;
	}
	public String getMaterialCode() {
		return materialCode;
	}
	public void setMaterialCode(String materialCode) {
		this.materialCode = materialCode;
	}
	public String getHsnCode() {
		return hsnCode;
	}
	public void setHsnCode(String hsnCode) {
		this.hsnCode = hsnCode;
	}
	public float getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}
	public String getProducatCtegory() {
		return producatCtegory;
	}
	public void setProducatCtegory(String producatCtegory) {
		this.producatCtegory = producatCtegory;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public float getPurchasePrice() {
		return purchasePrice;
	}
	public void setPurchasePrice(float purchasePrice) {
		this.purchasePrice = purchasePrice;
	}
	public int getSearchId() {
		return searchId;
	}
	public void setSearchId(int searchId) {
		this.searchId = searchId;
	}
	public int getAclId() {
		return aclId;
	}
	public void setAclId(int aclId) {
		this.aclId = aclId;
	}
	public int getUserRole() {
		return userRole;
	}
	public void setUserRole(int userRole) {
		this.userRole = userRole;
	}
	
}
