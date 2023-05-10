package com.bst.ckt.vo;

public class InvoiceSaleVO {

	
	int salesId;
	String fullName;
	String fullNameConsumer;
	int customerId;
	int customerIdConsumer;
	String phoneNo;
	String phoneNoConsumer;
	String mobileNo;
	String emailId;
	String city;
	String gender;
	String workLocation;
	String address;
	String addressConsumer;
	String salesDate;
	String	salesDateConsumer;
	/*item calculation fields*/
	String itemId;
	String itemName;
	private int searchId;
	private String uniqueId;
	
	String itemDescription;
	String itemQuantity;
	String itemPrice;
	String itemTax;
	String amount;
	float subTotal;
	float totalTax;
	float total;
	float discount;
	float netTotal;
	/*extrasuuuuuuuuuuuuuuuuuuuuuuuuu*/
	
	String customerType;
	String paymentAnswer;
	float payment;
	String paymentMode;
	private int aclId;
	private int userRole;
	private float transpportCharges;
	
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getSalesId() {
		return salesId;
	}
	public void setSalesId(int salesId) {
		this.salesId = salesId;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getWorkLocation() {
		return workLocation;
	}
	public void setWorkLocation(String workLocation) {
		this.workLocation = workLocation;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getSalesDate() {
		return salesDate;
	}
	public void setSalesDate(String salesDate) {
		this.salesDate = salesDate;
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public String getItemDescription() {
		return itemDescription;
	}
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
	public String getItemQuantity() {
		return itemQuantity;
	}
	public void setItemQuantity(String itemQuantity) {
		this.itemQuantity = itemQuantity;
	}
	public String getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(String itemPrice) {
		this.itemPrice = itemPrice;
	}
	public String getItemTax() {
		return itemTax;
	}
	public void setItemTax(String itemTax) {
		this.itemTax = itemTax;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public float getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(float subTotal) {
		this.subTotal = subTotal;
	}
	public float getTotalTax() {
		return totalTax;
	}
	public void setTotalTax(float totalTax) {
		this.totalTax = totalTax;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public float getDiscount() {
		return discount;
	}
	public void setDiscount(float discount) {
		this.discount = discount;
	}
	public float getNetTotal() {
		return netTotal;
	}
	public void setNetTotal(float netTotal) {
		this.netTotal = netTotal;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerType() {
		return customerType;
	}
	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}
	public String getPaymentAnswer() {
		return paymentAnswer;
	}
	public void setPaymentAnswer(String paymentAnswer) {
		this.paymentAnswer = paymentAnswer;
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
	public String getFullNameConsumer() {
		return fullNameConsumer;
	}
	public void setFullNameConsumer(String fullNameConsumer) {
		this.fullNameConsumer = fullNameConsumer;
	}
	public int getCustomerIdConsumer() {
		return customerIdConsumer;
	}
	public void setCustomerIdConsumer(int customerIdConsumer) {
		this.customerIdConsumer = customerIdConsumer;
	}
	public String getPhoneNoConsumer() {
		return phoneNoConsumer;
	}
	public void setPhoneNoConsumer(String phoneNoConsumer) {
		this.phoneNoConsumer = phoneNoConsumer;
	}
	public String getAddressConsumer() {
		return addressConsumer;
	}
	public void setAddressConsumer(String addressConsumer) {
		this.addressConsumer = addressConsumer;
	}
	public String getSalesDateConsumer() {
		return salesDateConsumer;
	}
	public void setSalesDateConsumer(String salesDateConsumer) {
		this.salesDateConsumer = salesDateConsumer;
	}
	public int getSearchId() {
		return searchId;
	}
	public void setSearchId(int searchId) {
		this.searchId = searchId;
	}
	public String getUniqueId() {
		return uniqueId;
	}
	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
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
	public float getTranspportCharges() {
		return transpportCharges;
	}
	public void setTranspportCharges(float transpportCharges) {
		this.transpportCharges = transpportCharges;
	}
}
