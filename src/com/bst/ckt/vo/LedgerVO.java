package com.bst.ckt.vo;

public class LedgerVO {

	
	private int ledgerId;
	private String ledgerBillDate;
	private String ledgerBillNo;
	private String ledgerTaxType;
	private float ledgerAmount;
	private String truckNo;
	private String destination;
	private float paid;
	private float due;
	private float quantity;
	private String material;
	private String startDate;
	private String endDate;
	private int dealerId;
	private int retailerId;
	public int getLedgerId() {
		return ledgerId;
	}
	public void setLedgerId(int ledgerId) {
		this.ledgerId = ledgerId;
	}
	public String getLedgerBillDate() {
		return ledgerBillDate;
	}
	public void setLedgerBillDate(String ledgerBillDate) {
		this.ledgerBillDate = ledgerBillDate;
	}
	public String getLedgerBillNo() {
		return ledgerBillNo;
	}
	public void setLedgerBillNo(String ledgerBillNo) {
		this.ledgerBillNo = ledgerBillNo;
	}
	public String getLedgerTaxType() {
		return ledgerTaxType;
	}
	public void setLedgerTaxType(String ledgerTaxType) {
		this.ledgerTaxType = ledgerTaxType;
	}
	public float getLedgerAmount() {
		return ledgerAmount;
	}
	public void setLedgerAmount(float ledgerAmount) {
		this.ledgerAmount = ledgerAmount;
	}
	public String getTruckNo() {
		return truckNo;
	}
	public void setTruckNo(String truckNo) {
		this.truckNo = truckNo;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public float getPaid() {
		return paid;
	}
	public void setPaid(float paid) {
		this.paid = paid;
	}
	public float getDue() {
		return due;
	}
	public void setDue(float due) {
		this.due = due;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public int getDealerId() {
		return dealerId;
	}
	public void setDealerId(int dealerId) {
		this.dealerId = dealerId;
	}
	public float getQuantity() {
		return quantity;
	}
	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}
	public int getRetailerId() {
		return retailerId;
	}
	public void setRetailerId(int retailerId) {
		this.retailerId = retailerId;
	}
	
}
