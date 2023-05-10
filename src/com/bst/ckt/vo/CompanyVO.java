package com.bst.ckt.vo;

public class CompanyVO {

private int companyId;
private String companyRefNo;
private String companyName;
private String tradeNname;
private String registrationNo;
private String fullName;
private String addressLine1;
private String addressLine2;
private String city;
private String state;
private String zipCode;
private String phoneStd;
private String phoneNo;
private String mobileNo;
private String faxStd;
private String faxNo;
private String companyEmailId;
private String companyUrl;
private String companyProfile;
private String companyLogoPath;
private String facebookDetail;
private String googlePlusDetail;
private String linkedInDetail;
private String twitterDetail;
private String blogDetail;
private String companyType;
private int companyCategory;
private int companySector;
private int country;
private int timezone;
private boolean termsId;
private String creationDate;
private int createdBy;
private String answer;
private String socialSite;
private String regRefNo;
private String ipAddress;
private String emailFlag;
private String youtubeDetail;
private int userStatus;
private String countryName;
private int countryID;
private String companyTypeName;
private int companyTypeId;
private String companyCategoryName;
private String category;
private int companyCategoryID;
private String companySectorName;
private String sector;
private int companysectorid;
private String timezoneName;
private String currency;
private String currencyDisplayName;
private String language;
private String countryname;
private String countryCode;
private String isdCode;
private String countrydisplayName;


 // SETTING_Finance variables 
private int financeId;
private String taxDisplayName;
private String taxNameOne;
private String taxRateOne;
private String taxNameTwo;
private String taxRateTwo;
private String taxNameThree;
private String taxRateThree;
private String taxNameFour;
private String taxRateFour;
private String taxNameFive;
private String taxRateFive;
private String taxTotal;
private String taxCreatedDate;
private int taxCreatedBy;
private int taxUpdatedBy;
private String taxUpdatedDate;
private String glAccount;
private String glAccounttype;
private String glAccountName;
private String description;


//SETTING_PRODUCT_VARIABLES
private int productCategoryId;
private String productCategory;
private int productUsesUnitId;
private String productUsesUnit;
private String measurementdescription;
private String productType;
private int productTypeId;


//SETTING_MARKETING_VARIABLES
private int leadsourceID;
private String leadsource;
private int accountTypeId;
private String accountType;
private int slanameID;
private String slaname;
private int campaigntypeID;
private String campaigntype;
private int responseID;
private String response;
private int vendorCategoryId;
private String vendorcategory;
private int travelmodeID;
private String travelmode;

// SETTING_SUPPORT_VARIABLES
private int faqcategoryId;
private String faqcategory;
private int channelId;
private String channel;
private int caseimpactId;
private String caseimpacttype;
private String caseimpactarea;
private String resolutiontype;
private int taskareaId;
private String taskarea;







/**
 * @return the currency
 */
public String getCurrency() {
	return currency;
}
/**
 * @param currency the currency to set
 */
public void setCurrency(String currency) {
	this.currency = currency;
}
/**
 * @return the language
 */
public String getLanguage() {
	return language;
}
/**
 * @param language the language to set
 */
public void setLanguage(String language) {
	this.language = language;
}

public String getGlAccounttype() {
	return glAccounttype;
}
public void setGlAccounttype(String glAccounttype) {
	this.glAccounttype = glAccounttype;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public int getCompanyTypeId() {
	return companyTypeId;
}
public void setCompanyTypeId(int companyTypeId) {
	this.companyTypeId = companyTypeId;
}
/**
 * @return companyTypeName
 */
public String getCompanyTypeName() {
	return companyTypeName;
}

/**
 * @param companyTypeName
 */
public void setCompanyTypeName(String companyTypeName) {
	this.companyTypeName = companyTypeName;
}
/**
 * @return companyCategoryName
 */
public String getCompanyCategoryName() {
	return companyCategoryName;
}
/**
 * 
 * @param companyCategoryName
 */
public void setCompanyCategoryName(String companyCategoryName) {
	this.companyCategoryName = companyCategoryName;
}
/**
 * 
 * @return
 */
public int getCompanyCategoryID() {
	return companyCategoryID;
}
/**
 * 
 * @param companyCategoryID
 */
public void setCompanyCategoryID(int companyCategoryID) {
	this.companyCategoryID = companyCategoryID;
}
/**
 * 
 * @return companySectorName
 */
public String getCompanySectorName() {
	return companySectorName;
}
/**
 * 
 * @param companySectorName
 */
public void setCompanySectorName(String companySectorName) {
	this.companySectorName = companySectorName;
}


public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}
public String getSector() {
	return sector;
}
public void setSector(String sector) {
	this.sector = sector;
}
/**
 * 
 * @return countryName
 */
public String getCountryName() {
	return countryName;
}
/**
 * 
 * @param countryName
 */
public void setCountryName(String countryName) {
	this.countryName = countryName;
}
/**
 * 
 * @return userStatus
 */
public int getUserStatus() {
	return userStatus;
}
/**
 * 
 * @param userStatus
 */
public void setUserStatus(int userStatus) {
	this.userStatus = userStatus;
}
/**
 * 
 * @return youtubeDetail
 */
public String getYoutubeDetail() {
	return youtubeDetail;
}
/**
 * 
 * @param youtubeDetail
 */
public void setYoutubeDetail(String youtubeDetail) {
	this.youtubeDetail = youtubeDetail;
}
/**
 * 
 * @return regRefNo
 */

public String getRegRefNo() {
	return regRefNo;
}
/**
 * 
 * @param regRefNo
 */
public void setRegRefNo(String regRefNo) {
	this.regRefNo = regRefNo;
}
/**
 * 
 * @param ipAddress
 * @return
 */
public String getIpAddress(String ipAddress) {
	return ipAddress;
}
/*
 * 
 * 
 */
public void setIpAddress(String ipAddress) {
	this.ipAddress = ipAddress;
}
/**
 * 
 * @return emailFlag
 */
public String getEmailFlag() {
	return emailFlag;
}
/**
 * 
 * @param emailFlag
 */
public void setEmailFlag(String emailFlag) {
	this.emailFlag = emailFlag;
}
/**
 * 
 * @return socialSite
 */
public String getSocialSite() {
	return socialSite;
}
/**
 * 
 * @param socialSite
 */
public void setSocialSite(String socialSite) {
	this.socialSite = socialSite;
}
/**
 * 
 * @return companyId
 */
public int getCompanyId() {
	return companyId;
}
/**
 * @param companyId
 */
public void setCompanyId(int companyId) {
	this.companyId = companyId;
}
/**
 * 
 */
public String getCompanyRefNo() {
	return companyRefNo;
}
/**
 * 
 * @param companyRefNo
 */
public void setCompanyRefNo(String companyRefNo) {
	this.companyRefNo = companyRefNo;
}
/**
 * 
 * 
 */
public String getCompanyName() {
	return companyName;
}
/**
 * 
 * @param companyName
 */
public void setCompanyName(String companyName) {
	this.companyName = companyName;
}
/**
 * 
 * @return tradeNname
 */
public String getTradeNname() {
	return tradeNname;
}
/**
 * 
 * @param tradeNname
 */
public void setTradeNname(String tradeNname) {
	this.tradeNname = tradeNname;
}
/**
 * 
 * @return registrationNo
 */
public String getRegistrationNo() {
	return registrationNo;
}
/**
 * 
 * @param registrationNo
 */
public void setRegistrationNo(String registrationNo) {
	this.registrationNo = registrationNo;
}
/**
 * 
 * @return addressLine1
 */
public String getAddressLine1() {
	return addressLine1;
}
/**
 * 
 * @param addressLine1
 */
public void setAddressLine1(String addressLine1) {
	this.addressLine1 = addressLine1;
}
/**
 * 
 * @return addressLine2
 */
public String getAddressLine2() {
	return addressLine2;
}
/**
 * 
 * @param addressLine2
 */
public void setAddressLine2(String addressLine2) {
	this.addressLine2 = addressLine2;
}

public int getCompanysectorid() {
	return companysectorid;
}
public void setCompanysectorid(int companysectorid) {
	this.companysectorid = companysectorid;
}
/**
 * 
 * @return city
 */
public String getCity() {
	return city;
}
/**
 * 
 * @param city
 */
public void setCity(String city) {
	this.city = city;
}
/**
 * 
 * @return state
 */
public String getState() {
	return state;
}
/**
 * 
 * @param state
 */
public void setState(String state) {
	this.state = state;
}
/**
 * 
 * @return zipCode
 */
public String getZipCode() {
	return zipCode;
}
/**
 * 
 * @param zipCode
 */
public void setZipCode(String zipCode) {
	this.zipCode = zipCode;
}
/**
 * 
 * @return phoneStd
 */
public String getPhoneStd() {
	return phoneStd;
}
/**
 * 
 * @param phoneStd
 */
public void setPhoneStd(String phoneStd) {
	this.phoneStd = phoneStd;
}
/**
 * 
 * @return phoneNo
 */
public String getPhoneNo() {
	return phoneNo;
}
/**
 * 
 * @param phoneNo
 */
public void setPhoneNo(String phoneNo) {
	this.phoneNo = phoneNo;
}
/**
 * 
 * @return mobileNo
 */
public String getMobileNo() {
	return mobileNo;
}
/**
 * 
 * @param mobileNo
 */
public void setMobileNo(String mobileNo) {
	this.mobileNo = mobileNo;
}
/**
 * 
 * @return faxStd
 */
public String getFaxStd() {
	return faxStd;
}
/**
 * 
 * @param faxStd
 */
public void setFaxStd(String faxStd) {
	this.faxStd = faxStd;
}
/**
 * 
 * @return faxNo
 */
public String getFaxNo() {
	return faxNo;
}
/**
 * 
 * @param faxNo
 */
public void setFaxNo(String faxNo) {
	this.faxNo = faxNo;
}
/**
 * 
 * @return companyEmailId
 */
public String getCompanyEmailId() {
	return companyEmailId;
}
/**
 * 
 * @param companyEmailId
 */
public void setCompanyEmailId(String companyEmailId) {
	this.companyEmailId = companyEmailId;
}
/**
 * 
 * @return companyUrl
 */
public String getCompanyUrl() {
	return companyUrl;
}
/**
 * 
 * @param companyUrl
 */
public void setCompanyUrl(String companyUrl) {
	this.companyUrl = companyUrl;
}
/**
 * 
 * @return companyProfile
 */
public String getCompanyProfile() {
	return companyProfile;
}
/**
 * 
 * @param companyProfile
 */
public void setCompanyProfile(String companyProfile) {
	this.companyProfile = companyProfile;
}
/**
 * 
 * @return companyLogoPath
 */
public String getCompanyLogoPath() {
	return companyLogoPath;
}

public String getGlAccountName() {
	return glAccountName;
}
public void setGlAccountName(String glAccountName) {
	this.glAccountName = glAccountName;
}
/**
 * 
 * @param companyLogoPath
 */
public void setCompanyLogoPath(String companyLogoPath) {
	this.companyLogoPath = companyLogoPath;
}
/**
 * 
 * @return facebookDetail
 */
public String getFacebookDetail() {
	return facebookDetail;
}
/**
 * 
 * @param facebookDetail
 */
public void setFacebookDetail(String facebookDetail) {
	this.facebookDetail = facebookDetail;
}
/**
 * 
 * @return googlePlusDetail
 */
public String getGooglePlusDetail() {
	return googlePlusDetail;
}
/**
 * 
 * @param googlePlusDetail
 */
public void setGooglePlusDetail(String googlePlusDetail) {
	this.googlePlusDetail = googlePlusDetail;
}
/**
 * 
 * @return linkedInDetail
 */
public String getLinkedInDetail() {
	return linkedInDetail;
}
/**
 * 
 * @param linkedInDetail
 */
public void setLinkedInDetail(String linkedInDetail) {
	this.linkedInDetail = linkedInDetail;
}
/**
 * 
 * @return twitterDetail
 */
public String getTwitterDetail() {
	return twitterDetail;
}
/**
 * 
 * @param twitterDetail
 */
public void setTwitterDetail(String twitterDetail) {
	this.twitterDetail = twitterDetail;
}
/**
 * 
 * @return blogDetail
 */

public String getBlogDetail() {
	return blogDetail;
}
/**
 * 
 * @param blogDetail
 */
public void setBlogDetail(String blogDetail) {
	this.blogDetail = blogDetail;
}

/**
 * @return the country
 */
public int getCountry() {
	return country;
}
/**
 * @param country the country to set
 */
public void setCountry(int country) {
	this.country = country;
}
/**
 * 
 * @return creationDate
 */
public String getCreationDate() {
	return creationDate;
}
/**
 * 
 * @param creationDate
 */
public void setCreationDate(String creationDate) {
	this.creationDate = creationDate;
}
/**
 * 
 * @return createdBy
 */
public int getCreatedBy() {
	return createdBy;
}
/**
 * 
 * @param createdBy
 */
public void setCreatedBy(int createdBy) {
	this.createdBy = createdBy;
}
/**
 * 
 * @return answer
 */
public String getAnswer() {
	return answer;
}
/**
 * 
 * @param answer
 */
public void setAnswer(String answer) {
	this.answer = answer;
}
/**
 * 
 * @return fullName
 */
public String getFullName() {
	return fullName;
}
/**
 * 
 * @param fullName
 */
public void setFullName(String fullName) {
	this.fullName = fullName;
}
/**
 * 
 * @return termsId
 */
public boolean isTermsId() {
	return termsId;
}
/**
 * 
 * @param termsId
 */
public void setTermsId(boolean termsId) {
	this.termsId = termsId;
}

/**
 * @return the ipAddress
 */
public String getIpAddress() {
	return ipAddress;
}
/**
 * @return the companyType
 */
public String getCompanyType() {
	return companyType;
}
/**
 * @param companyType the companyType to set
 */
public void setCompanyType(String companyType) {
	this.companyType = companyType;
}
/**
 * @return the companyCategory
 */
public int getCompanyCategory() {
	return companyCategory;
}
/**
 * @param companyCategory the companyCategory to set
 */
public void setCompanyCategory(int companyCategory) {
	this.companyCategory = companyCategory;
}
/**
 * @return the companySector
 */
public int getCompanySector() {
	return companySector;
}
/**
 * @param companySector the companySector to set
 */
public void setCompanySector(int companySector) {
	this.companySector = companySector;
}
/**
 * @return the timezone
 */
public int getTimezone() {
	return timezone;
}
/**
 * @param timezone the timezone to set
 */
public void setTimezone(int timezone) {
	this.timezone = timezone;
}

/**
 * 
 * @return
 */
public String getCurrencyDisplayName() {
	return currencyDisplayName;
}
/**
 * 
 * @param currencyDisplayName
 */
public void setCurrencyDisplayName(String currencyDisplayName) {
	this.currencyDisplayName = currencyDisplayName;
}
/**
 * 
 */
//Finance variable Setter And Getter
/**
 * 
 * @return financeId
 */
public int getFinanceId() {
	return financeId;
}
/**
 * 
 * @param financeId
 */
public void setFinanceId(int financeId) {
	this.financeId = financeId;
}
/**
 * 
 * @return taxDisplayName
 */
public String getTaxDisplayName() {
	return taxDisplayName;
}
/**
 * 
 * @param totalDisplayName
 */

public void setTaxDisplayName(String totalDisplayName) {
	this.taxDisplayName = totalDisplayName;
}
/**
 * 
 * @return taxNameOne
 */
public String getTaxNameOne() {
	return taxNameOne;
}
/**
 * 
 * @param taxNameOne
 */
public void setTaxNameOne(String taxNameOne) {
	this.taxNameOne = taxNameOne;
}
/**
 * 
 * @return taxRateOne
 */
public String getTaxRateOne() {
	return taxRateOne;
}

/**
 * @param taxRateOne
 */
public void setTaxRateOne(String taxRateOne) {
	this.taxRateOne = taxRateOne;
}
/**
 * 
 * @return taxNameTwo
 */
public String getTaxNameTwo() {
	return taxNameTwo;
}
/**
 * 
 * @param taxNameTwo
 */
public void setTaxNameTwo(String taxNameTwo) {
	this.taxNameTwo = taxNameTwo;
}
/**
 * 
 * @return taxRateTwo
 */
public String getTaxRateTwo() {
	return taxRateTwo;
}
/**
 * 
 * @param taxRateTwo
 */
public void setTaxRateTwo(String taxRateTwo) {
	this.taxRateTwo = taxRateTwo;
}
/**
 * 
 * @return taxNameThree
 */
public String getTaxNameThree() {
	return taxNameThree;
}
/**
 * 
 * @param taxNameThree
 */
public void setTaxNameThree(String taxNameThree) {
	this.taxNameThree = taxNameThree;
}
/**
 * 
 * @return taxRateThree
 */
public String getTaxRateThree() {
	return taxRateThree;
}
/**
 * 
 * @param taxRateThree
 */
public void setTaxRateThree(String taxRateThree) {
	this.taxRateThree = taxRateThree;
}
/**
 * 
 * @return taxNameFour
 */
public String getTaxNameFour() {
	return taxNameFour;
}
/**
 * 
 * @param taxNameFour
 */
public void setTaxNameFour(String taxNameFour) {
	this.taxNameFour = taxNameFour;
}
/**
 * 
 * @return taxRateFour
 */
public String getTaxRateFour() {
	return taxRateFour;
}
/**
 * 
 * @param taxRateFour
 */
public void setTaxRateFour(String taxRateFour) {
	this.taxRateFour = taxRateFour;
}
/**
 * 
 * @return taxNameFive
 */
public String getTaxNameFive() {
	return taxNameFive;
}
/**
 * 
 * @param taxNameFive
 */
public void setTaxNameFive(String taxNameFive) {
	this.taxNameFive = taxNameFive;
}
/**
 * 
 * @return taxRateFive
 */
public String getTaxRateFive() {
	return taxRateFive;
}
/**
 * 
 * @param taxRateFive
 */
public void setTaxRateFive(String taxRateFive) {
	this.taxRateFive = taxRateFive;
}
/**
 * 
 * @return taxTotal
 */
public String getTaxTotal() {
	return taxTotal;
}
/**
 * 
 * @param taxTotal
 */
public void setTaxTotal(String taxTotal) {
	this.taxTotal = taxTotal;
}
/**
 * 
 * @return taxCreatedDate
 */
public String getTaxCreatedDate() {
	return taxCreatedDate;
}
/**
 * 
 * @param taxCreatedDate
 */
public void setTaxCreatedDate(String taxCreatedDate) {
	this.taxCreatedDate = taxCreatedDate;
}
/**
 * 
 * @return taxCreatedBy
 */
public int getTaxCreatedBy() {
	return taxCreatedBy;
}
/**
 * 
 * @param taxCreatedBy
 */
public void setTaxCreatedBy(int taxCreatedBy) {
	this.taxCreatedBy = taxCreatedBy;
}
/**
 * 
 * @return taxUpdatedBy
 */
public int getTaxUpdatedBy() {
	return taxUpdatedBy;
}
/**
 * 
 * @param taxUpdatedBy
 */
public void setTaxUpdatedBy(int taxUpdatedBy) {
	this.taxUpdatedBy = taxUpdatedBy;
}
/**
 * 
 * @return taxUpdatedDate
 */
public String getTaxUpdatedDate() {
	return taxUpdatedDate;
}
/**
 * 
 * @param taxUpdatedDate
 */
public void setTaxUpdatedDate(String taxUpdatedDate) {
	this.taxUpdatedDate = taxUpdatedDate;
}
/**
 * 
 * @return glAccount
 */
public String getGlAccount() {
	return glAccount;
}
/**
 * 
 * @param glAccount
 */
public void setGlAccount(String glAccount) {
	this.glAccount = glAccount;
}


//Marketing variables setter and getter
/**
 * 
 * @return leadsource
 */
public String getLeadsource() {
	return leadsource;
}
/**
 * 
 * @param leadsource
 */
public void setLeadsource(String leadsource) {
	this.leadsource = leadsource;
}
/**
 * 
 * @return leadsourceID
 */
public int getLeadsourceID() {
	return leadsourceID;
}
/**
 * 
 * @param leadsourceID
 */
public void setLeadsourceID(int leadsourceID) {
	this.leadsourceID = leadsourceID;
}
/**
 * 
 * @return accountTypeId
 */
public int getAccountTypeId() {
	return accountTypeId;
}
/**
 * 
 * @param accountTypeId
 */
public void setAccountTypeId(int accountTypeId) {
	this.accountTypeId = accountTypeId;
}
/**
 * 
 * @return accountType
 */
public String getAccountType() {
	return accountType;
}
/**
 * 
 * @param accountType
 */
public void setAccountType(String accountType) {
	this.accountType = accountType;
}
/**
 * 
 * @return slanameID
 */
public int getSlanameID() {
	return slanameID;
}
/**
 * 
 * @param slanameID
 */
public void setSlanameID(int slanameID) {
	this.slanameID = slanameID;
}
/**
 * 
 * @return slaname
 */
public String getSlaname() {
	return slaname;
}
/**
 * 
 * @param slaname
 */
public void setSlaname(String slaname) {
	this.slaname = slaname;
}
/**
 * 
 * @return campaigntypeID
 */
public int getCampaigntypeID() {
	return campaigntypeID;
}
/**
 * 
 * @param campaigntypeID
 */
public void setCampaigntypeID(int campaigntypeID) {
	this.campaigntypeID = campaigntypeID;
}
/**
 * 
 * @return campaigntype
 */
public String getCampaigntype() {
	return campaigntype;
}
/**
 * 
 * @param campaigntype
 */
public void setCampaigntype(String campaigntype) {
	this.campaigntype = campaigntype;
}
/**
 * 
 * @return responseID
 */
public int getResponseID() {
	return responseID;
}
/**
 * 
 * @param responseID
 */
public void setResponseID(int responseID) {
	this.responseID = responseID;
}
/**
 * 
 * @return response
 */
public String getResponse() {
	return response;
}
/**
 * 
 * @param response
 */
public void setResponse(String response) {
	this.response = response;
}
/**
 * 
 * @return vendorCategoryId
 */
public int getVendorCategoryId() {
	return vendorCategoryId;
}
/**
 * 
 * @param vendorCategoryId
 */
public void setVendorCategoryId(int vendorCategoryId) {
	this.vendorCategoryId = vendorCategoryId;
}
/**
 * 
 * @return vendorcategory
 */
public String getVendorcategory() {
	return vendorcategory;
}
/**
 * 
 * @param vendorcategory
 */
public void setVendorcategory(String vendorcategory) {
	this.vendorcategory = vendorcategory;
}
/**
 * 
 * @return travelmodeID
 */
public int getTravelmodeID() {
	return travelmodeID;
}
/**
 * 
 * @param travelmodeID
 */
public void setTravelmodeID(int travelmodeID) {
	this.travelmodeID = travelmodeID;
}
/**
 * 
 * @return travelmode
 */
public String getTravelmode() {
	return travelmode;
}
/**
 * 
 * @param travelmode
 */
public void setTravelmode(String travelmode) {
	this.travelmode = travelmode;
}

//Support variable's setter and getter
/**
 * 
 * @return
 */

public int getFaqcategoryId() {
	return faqcategoryId;
}
/**
 * 
 * @param faqcategoryId
 */
public void setFaqcategoryId(int faqcategoryId) {
	this.faqcategoryId = faqcategoryId;
}
public String getFaqcategory() {
	return faqcategory;
}
public void setFaqcategory(String faqcategory) {
	this.faqcategory = faqcategory;
}
public int getChannelId() {
	return channelId;
}
public void setChannelId(int channelId) {
	this.channelId = channelId;
}
public String getChannel() {
	return channel;
}
public void setChannel(String channel) {
	this.channel = channel;
}
public int getCaseimpactId() {
	return caseimpactId;
}
public void setCaseimpactId(int caseimpactId) {
	this.caseimpactId = caseimpactId;
}
public String getCaseimpacttype() {
	return caseimpacttype;
}
public void setCaseimpacttype(String caseimpacttype) {
	this.caseimpacttype = caseimpacttype;
}
public String getCaseimpactarea() {
	return caseimpactarea;
}
public void setCaseimpactarea(String caseimpactarea) {
	this.caseimpactarea = caseimpactarea;
}
public String getResolutiontype() {
	return resolutiontype;
}
public void setResolutiontype(String resolutiontype) {
	this.resolutiontype = resolutiontype;
}
public int getTaskareaId() {
	return taskareaId;
}
public void setTaskareaId(int taskareaId) {
	this.taskareaId = taskareaId;
}
public String getTaskarea() {
	return taskarea;
}
public void setTaskarea(String taskarea) {
	this.taskarea = taskarea;
}

// product setter and getter
/**
 * 
 * @return
 */
public int getProductCategoryId() {
	return productCategoryId;
}
public void setProductCategoryId(int productCategoryId) {
	this.productCategoryId = productCategoryId;
}
public String getProductCategory() {
	return productCategory;
}
public void setProductCategory(String productCategory) {
	this.productCategory = productCategory;
}
/**
 * 
 * @return
 */
public int getProductUsesUnitId() {
	return productUsesUnitId;
}
/**
 * 
 * @param productUsesUnitId
 */
public void setProductUsesUnitId(int productUsesUnitId) {
	this.productUsesUnitId = productUsesUnitId;
}
/**
 * 
 * @return
 */
public String getProductUsesUnit() {
	return productUsesUnit;
}
/**
 * 
 * @param productUsesUnit
 */
public void setProductUsesUnit(String productUsesUnit) {
	this.productUsesUnit = productUsesUnit;
}
/**
 * 
 * @return
 */
public int getCountryID() {
	return countryID;
}
/**
 * 
 * @param countryID
 */
public void setCountryID(int countryID) {
	this.countryID = countryID;
}
/**
 * 
 * @return
 */
public String getTimezoneName() {
	return timezoneName;
}
/**
 * 
 * @param timezoneName
 */
public void setTimezoneName(String timezoneName) {
	this.timezoneName = timezoneName;
}
public String getMeasurementdescription() {
	return measurementdescription;
}
public void setMeasurementdescription(String measurementdescription) {
	this.measurementdescription = measurementdescription;
}
public String getCountryCode() {
	return countryCode;
}
public void setCountryCode(String countryCode) {
	this.countryCode = countryCode;
}
public String getIsdCode() {
	return isdCode;
}
public void setIsdCode(String isdCode) {
	this.isdCode = isdCode;
}
public String getCountrydisplayName() {
	return countrydisplayName;
}
public void setCountrydisplayName(String countrydisplayName) {
	this.countrydisplayName = countrydisplayName;
}
public String getCountryname() {
	return countryname;
}
public void setCountryname(String countryname) {
	this.countryname = countryname;
}
public String getProductType() {
	return productType;
}
public void setProductType(String productType) {
	this.productType = productType;
}
public int getProductTypeId() {
	return productTypeId;
}
public void setProductTypeId(int productTypeId) {
	this.productTypeId = productTypeId;
}





}
