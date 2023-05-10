package com.bst.ckt.vo;

import java.util.List;

public class LeadDetailsVO {
	
	private int leadId;
	private String salutation;
	private String companyName;
	private String contactPerson;
	private String leadSourceName;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String state;
	private String country;
	private String primaryEmailId;
	private String alternateEmailId;
	private String website;
	private String requirment;
	private String leadTitle;
	private String companyType;
	private String companyCategory;
	private String companySector;
	private String leadSource;
	private String noOfAssociate;
	private String annualRevenue;
	private String leadDate;
	private String expectedClosingDate;
	private int zipcode;
	private int mobileNo;
	private int phoneNo;
	private int fax;
	private int createdBy;
	private String createdDate;
	private String leadSourceStatus;
	private int leadStatus;
	private String leadOwner;
	private String leadUrl;
	private String uploadLeadFile;
	private List<LeadFollowUp> leadFollowUpList;
	private List<SocialContact> socialContactList;
	

	public int getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getLeadId() {
		return leadId;
	}
	public void setLeadId(int leadId) {
		this.leadId = leadId;
	}
	public String getSalutation() {
		return salutation;
	}
	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getContactPerson() {
		return contactPerson;
	}
	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}
	public String getLeadSourceName() {
		return leadSourceName;
	}
	public void setLeadSourceName(String leadSourceName) {
		this.leadSourceName = leadSourceName;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPrimaryEmailId() {
		return primaryEmailId;
	}
	public void setPrimaryEmailId(String primaryEmailId) {
		this.primaryEmailId = primaryEmailId;
	}
	public String getAlternateEmailId() {
		return alternateEmailId;
	}
	public void setAlternateEmailId(String alternateEmailId) {
		this.alternateEmailId = alternateEmailId;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getRequirment() {
		return requirment;
	}
	public void setRequirment(String requirment) {
		this.requirment = requirment;
	}
	
	public String getCompanyType() {
		return companyType;
	}
	public void setCompanyType(String companyType) {
		this.companyType = companyType;
	}
	public String getCompanyCategory() {
		return companyCategory;
	}
	public void setCompanyCategory(String companyCategory) {
		this.companyCategory = companyCategory;
	}
	public String getCompanySector() {
		return companySector;
	}
	public void setCompanySector(String companySector) {
		this.companySector = companySector;
	}
	public String getLeadSource() {
		return leadSource;
	}
	public void setLeadSource(String leadSource) {
		this.leadSource = leadSource;
	}
	public String getNoOfAssociate() {
		return noOfAssociate;
	}
	public void setNoOfAssociate(String noOfAssociate) {
		this.noOfAssociate = noOfAssociate;
	}
	public String getAnnualRevenue() {
		return annualRevenue;
	}
	public void setAnnualRevenue(String annualRevenue) {
		this.annualRevenue = annualRevenue;
	}
	public String getLeadDate() {
		return leadDate;
	}
	public void setLeadDate(String leadDate) {
		this.leadDate = leadDate;
	}
	public String getExpectedClosingDate() {
		return expectedClosingDate;
	}
	public void setExpectedClosingDate(String expectedClosingDate) {
		this.expectedClosingDate = expectedClosingDate;
	}
	public int getZipcode() {
		return zipcode;
	}
	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}
	public int getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(int mobileNo) {
		this.mobileNo = mobileNo;
	}
	public int getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(int phoneNo) {
		this.phoneNo = phoneNo;
	}
	public int getFax() {
		return fax;
	}
	public void setFax(int fax) {
		this.fax = fax;
	}
	public String getLeadTitle() {
		return leadTitle;
	}
	public void setLeadTitle(String leadTitle) {
		this.leadTitle = leadTitle;
	}
	public String getLeadSourceStatus() {
		return leadSourceStatus;
	}
	public void setLeadSourceStatus(String leadSourceStatus) {
		this.leadSourceStatus = leadSourceStatus;
	}
	/**
	 * @return the leadStatus
	 */
	public int getLeadStatus() {
		return leadStatus;
	}
	/**
	 * @param leadStatus the leadStatus to set
	 */
	public void setLeadStatus(int leadStatus) {
		this.leadStatus = leadStatus;
	}
	public String getLeadOwner() {
		return leadOwner;
	}
	public void setLeadOwner(String leadOwner) {
		this.leadOwner = leadOwner;
	}
	public String getLeadUrl() {
		return leadUrl;
	}
	public void setLeadUrl(String leadUrl) {
		this.leadUrl = leadUrl;
	}
	public String getUploadLeadFile() {
		return uploadLeadFile;
	}
	public void setUploadLeadFile(String uploadLeadFile) {
		this.uploadLeadFile = uploadLeadFile;
	}
	/**
	 * @return the leadFollowUpList
	 */
	public List<LeadFollowUp> getLeadFollowUpList() {
		return leadFollowUpList;
	}
	/**
	 * @param leadFollowUpList the leadFollowUpList to set
	 */
	public void setLeadFollowUpList(List<LeadFollowUp> leadFollowUpList) {
		this.leadFollowUpList = leadFollowUpList;
	}
	/**
	 * @return the socialContactList
	 */
	public List<SocialContact> getSocialContactList() {
		return socialContactList;
	}
	/**
	 * @param socialContactList the socialContactList to set
	 */
	public void setSocialContactList(List<SocialContact> socialContactList) {
		this.socialContactList = socialContactList;
	}

	
	
	
	
	

}
