package com.bst.ckt.vo;

public class PayDueAmountOfConsumerVO {


	private String customerId;
	private String customerName;
	private String customerAddress;
	private String customerContact;
	private String customerState;
	private float totalPaid;
	private float totalDue;
	private String discription;
	private String transactionDate;
	private float payment;
	private String paymentMode;
	private String billNo;
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	public String getCustomerContact() {
		return customerContact;
	}
	public void setCustomerContact(String customerContact) {
		this.customerContact = customerContact;
	}
	public String getCustomerState() {
		return customerState;
	}
	public void setCustomerState(String customerState) {
		this.customerState = customerState;
	}
	public float getTotalPaid() {
		return totalPaid;
	}
	public void setTotalPaid(float totalPaid) {
		this.totalPaid = totalPaid;
	}
	public float getTotalDue() {
		return totalDue;
	}
	public void setTotalDue(float totalDue) {
		this.totalDue = totalDue;
	}
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	public String getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}
	public float getPayment() {
		return payment;
	}
	public void setPayment(float payment) {
		this.payment = payment;
	}
	public String getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	public String getBillNo() {
		return billNo;
	}
	public void setBillNo(String billNo) {
		this.billNo = billNo;
	} 
}
