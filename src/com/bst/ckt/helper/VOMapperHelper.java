package com.bst.ckt.helper;

import java.util.StringTokenizer;


import com.bst.ckt.dto.AccountDTO;
import com.bst.ckt.dto.Assignment;
import com.bst.ckt.dto.Company;
import com.bst.ckt.dto.Consumer;
import com.bst.ckt.dto.Contacts;
import com.bst.ckt.dto.Dealer;
import com.bst.ckt.dto.EventDTO;
import com.bst.ckt.dto.InvoiceSale;
import com.bst.ckt.dto.Lead;
import com.bst.ckt.dto.Note;
import com.bst.ckt.dto.Payment;
import com.bst.ckt.dto.Pesticides;
import com.bst.ckt.dto.Product;
import com.bst.ckt.dto.PurchaseCement;
import com.bst.ckt.dto.PurchaseSteelbar;
import com.bst.ckt.dto.Retailer;
import com.bst.ckt.dto.SupportCases;
import com.bst.ckt.dto.SupportFaq;
import com.bst.ckt.dto.SupportServiceContact;
import com.bst.ckt.dto.SupportTicket;
import com.bst.ckt.dto.Task;
import com.bst.ckt.dto.Transport;
import com.bst.ckt.dto.VendorDTO;
import com.bst.ckt.dto.WallPaint;
import com.bst.ckt.framework.util.DateTimeUtil;
import com.bst.ckt.vo.AccountVO;
import com.bst.ckt.vo.AssignmentVO;
import com.bst.ckt.vo.CompanyVO;
import com.bst.ckt.vo.ConsumerCustomerVO;
import com.bst.ckt.vo.ContactsVO;
import com.bst.ckt.vo.DealerVO;
import com.bst.ckt.vo.EventVO;
import com.bst.ckt.vo.InvoiceSaleVO;
import com.bst.ckt.vo.LeadVO;
import com.bst.ckt.vo.NoteVO;
import com.bst.ckt.vo.PaymentVO;
import com.bst.ckt.vo.ProductVO;
import com.bst.ckt.vo.PurchaseCementVO;
import com.bst.ckt.vo.PurchasePesticidesVO;
import com.bst.ckt.vo.PurchaseSteelBarVO;
import com.bst.ckt.vo.PurchaseWallPaintVO;
import com.bst.ckt.vo.RetailerCustomerVO;
import com.bst.ckt.vo.ServiceContactVo;
import com.bst.ckt.vo.SupportCasesVO;
import com.bst.ckt.vo.SupportFaqVO;
import com.bst.ckt.vo.TaskVO;
import com.bst.ckt.vo.TicketVO;
import com.bst.ckt.vo.TransportVO;
import com.bst.ckt.vo.VendorsVO;

public class VOMapperHelper {
	public static LeadVO getLeadVOFromLead(LeadVO leadVO, Lead lead)
			throws Exception {

		leadVO.setAddressLine1(lead.getAddressLine1());
		leadVO.setAddressLine2(lead.getAddressLine2());
		leadVO.setAlternateEmailId(lead.getAlternateEmailId());
		leadVO.setAnnualRevenue(lead.getAnnualRevenue());
		leadVO.setCity(lead.getCity());
		leadVO.setCompanyCategory(lead.getCompanyCategory());
		leadVO.setCompanyName(lead.getCompanyName());
		leadVO.setCompanySector(lead.getCompanySector());
		leadVO.setCompanyType(lead.getCompanyType());
		leadVO.setContactPerson(lead.getContactPerson());
		leadVO.setCountry(lead.getCountry());
		leadVO.setCreatedByName(lead.getCreatedByName());
		leadVO.setCreatedDate(lead.getCreatedDate());
		leadVO.setExpectedClosingDate(lead.getExpectedClosingDate());
		leadVO.setFax(lead.getFax());
		leadVO.setLeadDate(lead.getLeadDate());
		leadVO.setLeadId(lead.getLeadId());
		leadVO.setLeadOwner(lead.getLeadOwner());
		/*leadVO.setLeadSource(lead.getLeadSource());*/
		leadVO.setLeadSourceName(lead.getLeadSourceName());
		leadVO.setLeadSourceStatus(lead.getLeadSourceStatus());
		leadVO.setLeadStatus(lead.getLeadStatus());
		leadVO.setLeadTitle(lead.getLeadTitle());
		leadVO.setLeadUrl(lead.getLeadUrl());
		leadVO.setMobileNo(lead.getMobileNo());
		leadVO.setNoOfAssociate(lead.getNoOfAssociate());
		leadVO.setPhoneNo(lead.getPhoneNo());
		leadVO.setPrimaryEmailId(lead.getPrimaryEmailId());
		leadVO.setRequirment(lead.getRequirment());
		leadVO.setSalutation(lead.getSalutation());
		leadVO.setState(lead.getState());
		leadVO.setUploadLeadFile(lead.getUploadLeadFile());
		leadVO.setWebsite(lead.getWebsite());
		leadVO.setZipcode(lead.getZipcode());
		leadVO.setLeadStatusName(lead.getLeadStatusName());
		leadVO.setLeadStatus(lead.getLeadStatus());
		leadVO.setEmailOptOut(lead.getEmailOptOut());
		leadVO.setRatings(lead.getRatings());
		leadVO.setFaxIsd(lead.getFaxIsd());
		leadVO.setFaxStd(lead.getFaxStd());
		leadVO.setPhoneIsd(lead.getPhoneIsd());
		leadVO.setPhoneStd(lead.getPhoneStd());
		leadVO.setMobileIsd(lead.getMobileIsd());
		leadVO.setFullName(lead.getFullName());
		return leadVO;
	}

	public static AccountVO getAccountVOFromAccountDTO(AccountVO accountVO,
			AccountDTO accountDTO) throws Exception {
		accountVO.setAccountId(accountDTO.getAccountId());
		accountVO.setAccountName(accountDTO.getAccountName());
		accountVO.setAccountOwner(accountDTO.getAccountOwner());
		accountVO.setAccountType(accountDTO.getAccountType());
		accountVO.setRatings(accountDTO.getRatings());
		accountVO.setAnnualRevenue(accountDTO.getAnnualRevenue());
		accountVO.setNoOfAssociates(accountDTO.getNoOfAssociates());
		/*accountVO.setAccountStatus(accountDTO.getAccountStatus());*/
		accountVO.setAssignTo(accountDTO.getAssignTo());
		accountVO.setParentAccount(accountDTO.getParentAccount());
		accountVO.setEmailOptOut(accountDTO.getEmailOptOut());
		accountVO.setTrickerSymbol(accountDTO.getTrickerSymbol());
		accountVO.setOwnershipType(accountDTO.getOwnershipType());
		accountVO.setSlaName(accountDTO.getSlaName());
		accountVO.setMobileNo(accountDTO.getMobileNo());
		accountVO.setMobileIsd(accountDTO.getMobileIsd());
		accountVO.setEmailId(accountDTO.getEmailId());
		accountVO.setPhoneNo(accountDTO.getPhoneNo());
		accountVO.setPhoneIsd(accountDTO.getPhoneIsd());
		accountVO.setPhoneStd(accountDTO.getPhoneStd());
		accountVO.setBillingContactPersone(accountDTO
				.getBillingContactPersone());
		accountVO.setBillingDesignation(accountDTO.getBillingDesignation());
		accountVO.setBillingAddressLine1(accountDTO.getBillingAddressLine1());
		accountVO.setBillingAddressLine2(accountDTO.getBillingAddressLine2());
		accountVO.setBillingCity(accountDTO.getBillingCity());
		accountVO.setBillingState(accountDTO.getBillingState());
		accountVO.setBillingCountry(accountDTO.getBillingCountry());
		accountVO.setBillingZipcode(accountDTO.getBillingZipcode());
		accountVO.setBillingPhoneNo(accountDTO.getBillingPhoneNo());
		accountVO.setBillingPhoneNoIsd(accountDTO.getBillingPhoneNoIsd());
		accountVO.setBillingPhoneNoStd(accountDTO.getBillingPhoneNoStd());
		accountVO.setBillingMobileNo(accountDTO.getBillingMobileNo());
		accountVO.setBillingMobileNoIsd(accountDTO.getBillingMobileNoIsd());
		accountVO.setBillingPrimaryEmail(accountDTO.getBillingPrimaryEmail());
		accountVO.setBillingAlternateEmail(accountDTO
				.getBillingAlternateEmail());
		accountVO.setBillingSalutation(accountDTO.getBillingSalutation());
		accountVO.setBillingWebsite(accountDTO.getBillingWebsite());
		accountVO.setBillingFax(accountDTO.getBillingFax());
		accountVO.setBillingFaxIsd(accountDTO.getBillingFaxIsd());
		accountVO.setBillingFaxStd(accountDTO.getBillingFaxStd());
		accountVO.setShippingAddressLine1(accountDTO.getShippingAddressLine1());
		accountVO.setShippingAddressLine2(accountDTO.getShippingAddressLine2());
		accountVO.setShippingAlternateEmail(accountDTO
				.getShippingAlternateEmail());
		accountVO.setShippingCity(accountDTO.getShippingCity());
		accountVO.setShippingContactPersone(accountDTO
				.getShippingContactPersone());
		accountVO.setShippingCountry(accountDTO.getShippingCountry());
		accountVO.setShippingDesignation(accountDTO.getShippingDesignation());
		accountVO.setShippingFax(accountDTO.getShippingFax());
		accountVO.setShippingFaxIsd(accountDTO.getShippingFaxIsd());
		accountVO.setShippingFaxStd(accountDTO.getShippingFaxStd());
		accountVO.setShippingMobileNo(accountDTO.getShippingMobileNo());
		accountVO.setShippingMobileIsd(accountDTO.getShippingMobileIsd());
		accountVO.setShippingPhoneNo(accountDTO.getShippingPhoneNo());
		accountVO.setShippingPhoneIsd(accountDTO.getShippingPhoneIsd());
		accountVO.setShippingPhoneStd(accountDTO.getShippingPhoneStd());
		accountVO.setShippingPrimaryEmail(accountDTO.getShippingPrimaryEmail());
		accountVO.setShippingSalutation(accountDTO.getShippingSalutation());
		accountVO.setShippingState(accountDTO.getShippingState());
		accountVO.setShippingWebsite(accountDTO.getShippingWebsite());
		accountVO.setShippingZipcode(accountDTO.getShippingZipcode());
		accountVO.setProfileDescription(accountDTO.getProfileDescription());
		accountVO.setCreatedDate(accountDTO.getCreatedDate());
		accountVO.setCreatedByName(accountDTO.getCreatedByName());
		return accountVO;
	}

	public static TaskVO getTaskVOFromTask(TaskVO taskVO, Task task)
			throws Exception {
		NameHelper nameHelper = new NameHelper();
		taskVO.setSalutation(task.getSalutation());
		taskVO.setTaskAllocatedTo(task.getTaskAllocatedTo());
		taskVO.setTaskSubject(task.getTaskSubject());
		taskVO.setDueDate(DateTimeUtil.convertDatetoFormDate(task.getDueDate()));
		taskVO.setTaskArea(task.getTaskArea());
		taskVO.setTaskStatus(task.getTaskStatus());
		taskVO.setTaskPriority(task.getTaskPriority());
		taskVO.setSendEmailNotification(task.getSendEmailNotification());
		taskVO.setStartDate(DateTimeUtil.convertDatetoFormDate(task
				.getStartDate()));
		taskVO.setEndDate(DateTimeUtil.convertDatetoFormDate(task.getEndDate()));
		taskVO.setRepeatType(task.getRepeatType());
		taskVO.setEveryDay(task.getEveryDay());
		taskVO.setNumberOfDays(task.getNumberOfDays());
		taskVO.setRepeatForEveryWeek(task.getRepeatForEveryWeek());
		taskVO.setNumberOfWeeks(task.getNumberOfWeeks());

		/**
		 * <p>
		 * here we are getting string which is set from resultSet and here we
		 * are setting into different value object by splitting using
		 * StringTokenizer's nextToken().
		 * </p>
		 */
		StringTokenizer st = new StringTokenizer(task.getDaysName());
		taskVO.setSunday(st.nextToken(","));
		taskVO.setMonday(st.nextToken(","));
		taskVO.setTuesday(st.nextToken(","));
		taskVO.setWednesday(st.nextToken(","));
		taskVO.setThursday(st.nextToken(","));
		taskVO.setFriday(st.nextToken(","));
		taskVO.setSaturday(st.nextToken(","));

		taskVO.setOnDayOfMonths(task.getOnDayOfMonths());
		taskVO.setMonthsDay(task.getMonthsDay());
		taskVO.setNumberOfMonths(task.getNumberOfMonths());
		taskVO.setOnWeek(task.getOnWeek());
		taskVO.setOfWeekDay(task.getOfWeekDay());
		taskVO.setOnEveryNoOfMonths(task.getOnEveryNoOfMonths());
		taskVO.setOnEveryOfYear(task.getOnEveryOfYear());
		taskVO.setOnMonthOfYear(task.getOnMonthOfYear());
		taskVO.setOnDayOfYear(task.getOnDayOfYear());
		taskVO.setEveryWeekOfYear(task.getEveryWeekOfYear());
		taskVO.setEveryWeekDayOfYear(task.getEveryWeekDayOfYear());
		taskVO.setEveryMonthOfYear(task.getEveryMonthOfYear());
		taskVO.setDiscription(task.getDiscription());

		taskVO.setTaskAllocatedByName(nameHelper.getCustomerName(task
				.getTaskAllocatedBy()));
		taskVO.setTaskAllocationDate(DateTimeUtil.convertDatetoFormDate(task
				.getTaskAllocationDate()));

		return taskVO;

	}

	public static ContactsVO getContactsVOFromContacts(ContactsVO contactsVO,
			Contacts contacts) {
		contactsVO.setContactId(contacts.getContactId());
		contactsVO.setSalutation(contacts.getSalutation());
		contactsVO.setContactperson(contacts.getContactperson());
		contactsVO.setNickName(contacts.getNickName());
		contactsVO.setDesignation(contacts.getDesignation());
		contactsVO.setReferredBy(contacts.getReferredBy());
		contactsVO.setPhoneNumber(contacts.getPhoneNumber());
		contactsVO.setPhoneNumberIsd(contacts.getPhoneNumberIsd());
		contactsVO.setPhoneNumberStd(contacts.getPhoneNumberStd());
		contactsVO.setDepartment(contacts.getDepartment());
		contactsVO.setReportsTo(contacts.getReportsTo());
		contactsVO.setReference(contacts.getReference());
		contactsVO.setLeadSource(contacts.getLeadSource());
		contactsVO.setAssignedTo(contacts.getAssignedTo());
		contactsVO.setDoNotCall(contacts.getDoNotCall());
		contactsVO.setNotifyOwner(contacts.getNotifyOwner());
		contactsVO
				.setEmailOptOut(contacts.getEmailOptOut());
		contactsVO
				.setSlaName(contacts.getSlaName());
		contactsVO.setCustomerCenterUser(contacts.getCustomerCenterUser());
		contactsVO.setSupportStartDate(contacts.getSupportStartDate());
		contactsVO.setSupportEndDate(contacts
				.getSupportEndDate());
		contactsVO.setMobileNum1(contacts.getMobileNum1());

		contactsVO.setMobileNum1Isd(contacts.getMobileNum1Isd());
		contactsVO.setMobileNum2(contacts.getMobileNum2());

		contactsVO.setMobileNum2Isd(contacts.getMobileNum2Isd());
		contactsVO.setEmailId(contacts.getEmailId());
		contactsVO.setFax(contacts.getFax());
		contactsVO.setFaxIsd(contacts.getFaxIsd());
		contactsVO.setFaxStd(contacts.getFaxStd());
		contactsVO.setHomeContAddLine1(contacts.getHomeContAddLine1());
		contactsVO.setHomeContAddLine2(contacts.getHomeContAddLine2());
		contactsVO.setHomeContCity(contacts.getHomeContCity());
		contactsVO.setHomeContState(contacts.getHomeContState());
		contactsVO.setHomeContCountry(contacts.getHomeContCountry());
		contactsVO.setHomeContZipcode(contacts.getHomeContZipcode());
		contactsVO.setHomeContPhoneNum(contacts.getHomeContPhoneNum());
		contactsVO.setHomeContPhoneNumIsd(contacts.getHomeContPhoneNumIsd());
		contactsVO.setHomeContPhoneNumStd(contacts.getHomeContPhoneNumStd());
		contactsVO.setHomeContMobileNum(contacts.getHomeContMobileNum());
		contactsVO.setHomeContPhoneNumIsd(contacts.getHomeContMobileNumIsd());
		contactsVO.setHomeContEmailId(contacts.getHomeContEmailId());
		contactsVO.setHomeContAlternateEmailId(contacts.getHomeContAlternateEmailId());
		contactsVO.setHomeContFaxNum(contacts.getHomeContFaxNum());
		contactsVO.setHomeContFaxNumIsd(contacts.getHomeContFaxNumIsd());
		contactsVO.setHomeContFaxnumStd(contacts.getHomeContFaxnumStd());
		contactsVO.setHomewebsite(contacts.getHomewebsite());
		contactsVO.setWorkContAddLine1(contacts.getWorkContAddLine1());
		contactsVO.setWorkContAddLine2(contacts.getWorkContAddLine2());
		contactsVO.setWorkContCity(contacts.getWorkContCity());
		contactsVO.setWorkContState(contacts.getWorkContState());
		contactsVO.setWorkContCountry(contacts.getWorkContCountry());
		contactsVO.setWorkContZipcode(contacts.getWorkContZipcode());
		contactsVO.setWorkContPhoneNum(contacts.getWorkContPhoneNum());
		contactsVO.setWorkContPhoneIsd(contacts.getWorkContPhoneIsd());
		contactsVO.setWorkContPhoneStd(contacts.getWorkContPhoneStd());
		contactsVO.setWorkContMobileNum(contacts.getWorkContMobileNum());
		contactsVO.setWorkContMobileNumIsd(contacts.getWorkContMobileNumIsd());
		contactsVO.setWorkContEmailId(contacts.getWorkContEmailId());
		contactsVO.setWorkContAlternateEmailId(contacts.getWorkContAlternateEmailId());
		contactsVO.setWorkContFaxNum(contacts.getWorkContFaxNum());
		contactsVO.setWorkContFaxNumIsd(contacts.getWorkContFaxNumIsd());
		contactsVO.setWorkContFaxNumStd(contacts.getWorkContFaxNumStd());
		contactsVO.setWorkWebsite(contacts.getWorkWebsite());
		contactsVO.setProfileDescription(contacts.getProfileDescription());
		contactsVO.setReferenceId(contacts.getReferenceId());
		contactsVO.setCreatedDate(contacts.getCreatedDate());
		contactsVO.setCreatedBy(contacts.getCreatedBy());
		contactsVO.setTitle(contacts.getTitle());
		contactsVO.setDob(contacts.getDob());
		contactsVO.setStatus(contacts.getStatus());
		
		

		return contactsVO;
	}

	public static CompanyVO getCompanyVOFromCompany(CompanyVO companyVO,
			Company company) {

		companyVO.setCompanyId(company.getCompanyId());
		companyVO.setCompanyName(company.getCompanyName());
		companyVO.setTradeNname(company.getTradeNname());
		companyVO.setRegistrationNo(company.getRegistrationNo());
		companyVO.setAddressLine1(company.getAddressLine1());
		companyVO.setAddressLine2(company.getAddressLine2());
		companyVO.setCity(company.getCity());
		companyVO.setState(company.getState());
		companyVO.setZipCode(company.getZipCode());
		companyVO.setPhoneNo(company.getPhoneNo());
		companyVO.setMobileNo(company.getMobileNo());
		companyVO.setFaxNo(company.getFaxNo());
		companyVO.setCompanyEmailId(company.getCompanyEmailId());	
		companyVO.setCompanyUrl(company.getCompanyUrl());
		companyVO.setFacebookDetail(company.getFacebookDetail());
		companyVO.setGooglePlusDetail(company.getGooglePlusDetail());
		companyVO.setLinkedInDetail(company.getLinkedInDetail());
		companyVO.setTwitterDetail(company.getTwitterDetail());
		companyVO.setBlogDetail(company.getBlogDetail());
		companyVO.setYoutubeDetail(company.getYoutubeDetail());
		companyVO.setCompanyTypeName(company.getRefCompanyTypeName());
		companyVO.setCompanyCategoryName(company.getRefCompanyCategoryName());
		companyVO.setCompanySectorName(company.getRefCompanySectorName());
		companyVO.setCountryName(company.getRefCountryName());
		companyVO.setTimezoneName(company.getRefTimezoneName());
		companyVO.setCurrency(company.getRefCurrency());
		companyVO.setLanguage(company.getRefLanguage());
		companyVO.setCreationDate(company.getCreationDate());
		companyVO.setCreatedBy(company.getCreatedBy());
		companyVO.setUserStatus(company.getUserStatus());
		companyVO.setCompanyType(company.getCompanyType());
		companyVO.setCompanyTypeId(company.getCompanyTypeId());
		companyVO.setCompanyCategoryID(company.getCompanyCategoryID());
		companyVO.setCategory(company.getCategory());
		companyVO.setCompanysectorid(company.getCompanySectorId());
		companyVO.setSector(company.getSector());
		companyVO.setFinanceId(company.getFinanceId());
		companyVO.setTaxDisplayName(company.getTaxDisplayName());
		companyVO.setTaxNameOne(company.getTaxNameOne());
		companyVO.setTaxNameTwo(company.getTaxNameTwo());
		companyVO.setTaxRateTwo(company.getTaxRateTwo());
		companyVO.setTaxNameThree(company.getTaxNameThree());
		companyVO.setTaxRateThree(company.getTaxRateThree());
		companyVO.setTaxNameFour(company.getTaxNameFour());
		companyVO.setTaxRateFour(company.getTaxRateFour());
		companyVO.setTaxNameFive(company.getTaxNameFive());
		companyVO.setTaxRateFive(company.getTaxRateFive());
		companyVO.setGlAccount(company.getGlAccount());
		companyVO.setGlAccounttype(company.getGlAccounttype());
		companyVO.setGlAccountName(company.getGlAccountName());
		companyVO.setDescription(company.getDescription());
		companyVO.setLeadsourceID(company.getLeadsourceID());
		companyVO.setLeadsource(company.getLeadsource());
		companyVO.setAccountTypeId(company.getAccountTypeId());
		companyVO.setAccountType(company.getAccountType());
		companyVO.setCampaigntypeID(company.getCampaigntypeID());
		companyVO.setCampaigntype(company.getCampaigntype());
		companyVO.setVendorCategoryId(company.getVendorCategoryId());
		companyVO.setVendorcategory(company.getVendorcategory());
		companyVO.setTravelmodeID(company.getTravelmodeID());
		companyVO.setTravelmode(company.getTravelmode());
		companyVO.setProductCategoryId(company.getProductCategoryId());
		companyVO.setProductCategory(company.getProductCategory());
		companyVO.setProductUsesUnitId(company.getProductUsesUnitId());
		companyVO.setProductUsesUnit(company.getProductUsesUnit());
	    companyVO.setFaqcategoryId(company.getFaqcategoryId());
	    companyVO.setFaqcategory(company.getFaqcategory());
	    companyVO.setChannelId(company.getChannelId());
	    companyVO.setChannel(company.getChannel());
	    companyVO.setTaskareaId(company.getTaskareaId());
	    companyVO.setTaskarea(company.getTaskarea());
	    
	    companyVO.setProductTypeId(company.getProductTypeId());
	    companyVO.setProductType(company.getProductType());
		return companyVO;
	}


	public static SupportFaqVO getSupportFaqVOFromFaq(
			SupportFaqVO supportFaqVO, SupportFaq supportFaq) {
		supportFaqVO.setFaqId(supportFaq.getFaqId());
		supportFaqVO.setQuestion(supportFaq.getQuestion());
		supportFaqVO.setAnswer(supportFaq.getAnswer());
		supportFaqVO.setProductName(supportFaq.getProductName());
		supportFaqVO.setStatus(supportFaq.getStatus());
		supportFaqVO.setCategory(supportFaq.getCategory());
		supportFaqVO.setCreatedBy(supportFaq.getCreatedBy());
		supportFaqVO.setOwner(supportFaq.getOwner());
		supportFaqVO.setDate(supportFaq.getDate());
		supportFaqVO.setSearchValue(supportFaq.getSearchValue());
		supportFaqVO.setSearchId(supportFaq.getSearchId());
		return supportFaqVO;
	}

	public static SupportCasesVO getSupportCasesVOFromCases(
			SupportCasesVO supportCasesVO, SupportCases supportCases) {
		supportCasesVO.setAssignedTo(supportCases.getAssignedTo());
		supportCasesVO.setCasesId(supportCases.getCasesId());
		supportCasesVO.setCaseTitle(supportCases.getCaseTitle());
		supportCasesVO.setChannel(supportCases.getChannel());
		supportCasesVO.setContactName(supportCases.getContactName());
		supportCasesVO.setCreatedBy(supportCases.getCreatedBy());
		supportCasesVO.setDeferredDate(supportCases.getDeferredDate());
		supportCasesVO.setImpactArea(supportCases.getImpactArea());
		supportCasesVO.setImpactType(supportCases.getImpactType());
		supportCasesVO.setOrganiztionaName(supportCases.getOrganiztionaName());
		supportCasesVO.setPrimaryEmail(supportCases.getPrimaryEmail());
		supportCasesVO.setPriority(supportCases.getPriority());
		supportCasesVO.setProductName(supportCases.getProductName());
		supportCasesVO.setResolution(supportCases.getResolution());
		supportCasesVO.setResolutionType(supportCases.getResolutionType());
		supportCasesVO.setSlaName(supportCases.getSlaName());
		supportCasesVO.setStatus(supportCases.getStatus());
		supportCasesVO.setTeam(supportCases.getTeam());
		supportCasesVO.setSearchValue(supportCases.getSearchValue());
		supportCasesVO.setSearchId(supportCases.getSearchId());

		return supportCasesVO;

	}

	public static TicketVO getTicketVOFromTicket(TicketVO ticketVO,
			SupportTicket supportTicket) {
		ticketVO.setCategory(supportTicket.getCategory());
		ticketVO.setChannel(supportTicket.getChannel());
		ticketVO.setDescription(supportTicket.getDescription());
		ticketVO.setDueDate(supportTicket.getDueDate());
		ticketVO.setEmail(supportTicket.getEmail());
		ticketVO.setPhoneNo(supportTicket.getPhoneNo());
		ticketVO.setPhoneStd(supportTicket.getPhoneStd());
		ticketVO.setPhoneIsd(supportTicket.getPhoneIsd());
		ticketVO.setPriority(supportTicket.getPriority());
		ticketVO.setStatus(supportTicket.getStatus());
		ticketVO.setSubject(supportTicket.getSubject());
		ticketVO.setTicketId(supportTicket.getTicketId());
		ticketVO.setTicketOwner(supportTicket.getTicketOwner());
		ticketVO.setUploadFile(supportTicket.getUploadFile());
		ticketVO.setContactName(supportTicket.getContactName());
		ticketVO.setProductName(supportTicket.getProductName());
		ticketVO.setCreateBy(supportTicket.getCreatedBy());
		ticketVO.setSearchValue(supportTicket.getSearchValue());
		ticketVO.setSearchId(supportTicket.getSearchId());
		return ticketVO;

	}

	public static ServiceContactVo getServiceContactVoFromService(
			ServiceContactVo serviceContactVo,
			SupportServiceContact supportServiceContact) {
		serviceContactVo.setAssignedTo(supportServiceContact.getAssignedTo());
		serviceContactVo.setContactName(supportServiceContact.getContactName());
		serviceContactVo.setCreatedBy(supportServiceContact.getCreatedBy());
		serviceContactVo.setCreatedDate(serviceContactVo.getCreatedDate());
		serviceContactVo.setDueDate(supportServiceContact.getDueDate());
		serviceContactVo.setPriority(supportServiceContact.getPriority());
		serviceContactVo.setRelatedTo(supportServiceContact.getRelatedTo());
		serviceContactVo.setServiceContactId(supportServiceContact
				.getServiceContctId());
		serviceContactVo.setServiceContactType(supportServiceContact
				.getServiceContactType());
		serviceContactVo.setStartDate(supportServiceContact.getStartDate());
		serviceContactVo.setStatus(supportServiceContact.getStatus());
		serviceContactVo.setSubject(supportServiceContact.getSubject());
		serviceContactVo.setTotalUnits(supportServiceContact.getTotalUnits());
		serviceContactVo.setTrackingUnit(supportServiceContact
				.getTrackingUnit());
		serviceContactVo.setUsedUnits(supportServiceContact.getUsedUnits());
		serviceContactVo.setSearchValue(supportServiceContact.getSearchValue());
		serviceContactVo.setSearchId(supportServiceContact.getSearchId());
		return serviceContactVo;
	}
	
	
	public static ProductVO getproductFromProduct(ProductVO productVO,
			Product product) {
		productVO.setProductId(product.getProductId());
		productVO.setProductName(product.getProductName());
		productVO.setProductCode(product.getProductCode());
		productVO.setProductCategory(product.getProductCategory());
		productVO.setVenderName(product.getVenderName());
		productVO.setManufacturer(product.getManufacturer());
		productVO.setSalesStartDate(product.getSalesStartDate());
		productVO.setSalesEndDate(product.getSalesEndDate());
		productVO.setSupportStartDate(product.getSupportStartDate());
		productVO.setSupportExpiryDate(product.getSupportExpiryDate());
		productVO.setSerialNo(product.getSerialNo());
		productVO.setMrfPartNo(product.getMrfPartNo());
		productVO.setVendorPartNo(product.getVendorPartNo());
		productVO.setProductSheet(product.getProductSheet());
		productVO.setWebsite(product.getWebsite());
		productVO.setGlAccount(product.getGlAccount());
		productVO.setUnitPrice(product.getUnitPrice());
		productVO.setCommisionRate(product.getCommisionRate());
		productVO.setTax(product.getTax());
		productVO.setPurchaseCost(product.getPurchaseCost());
		productVO.setUsageUnit(product.getUsageUnit());
		productVO.setQtyPerUnit(product.getQtyPerUnit());
		productVO.setQtyInStock(product.getQtyInStock());
		productVO.setReorderLevel(product.getReorderLevel());
		productVO.setHandler(product.getHandler());
		productVO.setQtyInDemand(product.getQtyInDemand());
		productVO.setProductActive(product.getProductActive());
		productVO.setProductImage(product.getProductImage());
		productVO.setDescription(product.getDescription());
		return productVO;
	}
	
	
	public static AssignmentVO getAssignmentVOFromAssignment(AssignmentVO assignmentVO,Assignment assignment) throws Exception{
		assignmentVO.setAssignmentId(assignment.getAssignmentId());
		assignmentVO.setAssignmentName(assignment.getAssignmentName());
		assignmentVO.setAssignmentOwner(assignment.getAssignmentOwner());
		assignmentVO.setExpectedAmount(assignment.getExpectedAmount());
		assignmentVO.setAccount(assignment.getAccount());
		assignmentVO.setContactPerson(assignment.getContactPerson());
		assignmentVO.setExpectedClosingDate(assignment.getExpectedClosingDate());
		assignmentVO.setLeadSource(assignment.getLeadSource());
		assignmentVO.setAssignedTo(assignment.getAssignedTo());
		assignmentVO.setLead(assignment.getLead());
		assignmentVO.setProbability(assignment.getProbability());
		assignmentVO.setCampaign(assignment.getCampaign());
		assignmentVO.setWeightedRevenue(assignment.getWeightedRevenue());
		assignmentVO.setPrimaryEmailId(assignment.getPrimaryEmailId());
		assignmentVO.setPhoneIsd(assignment.getPhoneIsd());
		assignmentVO.setPhoneStd(assignment.getPhoneStd());
		assignmentVO.setPhoneNumber(assignment.getPhoneNumber());
		assignmentVO.setDescription(assignment.getDescription());
		assignmentVO.setAssignmentStatus(assignment.getAssignmentStatus());
		assignmentVO.setCreatedBy(assignment.getCreatedBy());
		assignmentVO.setCreationDate(assignment.getCreationDate());
		assignmentVO.setUpdatedBy(assignment.getUpdatedBy());
		assignmentVO.setUpdationDate(assignment.getUpdationDate());
		assignmentVO.setEmailFlag(assignment.getEmailFlag());
		
		return assignmentVO;
	
	}
	
	public static VendorsVO getVendorsVOFromVendors(VendorsVO vendorsVO, VendorDTO vendorDTO)
			throws Exception {
		vendorsVO.setVendorsName(vendorDTO.getVendorsName());
		vendorsVO.setVendorsCategory(vendorDTO.getVendorsCategory());
		vendorsVO.setVendorsId(vendorDTO.getVendorsId());
		vendorsVO.setVendorsFlag(vendorDTO.getVendorsFlag());
		vendorsVO.setVendorsStatus(vendorDTO.getVendorsStatus());
		vendorsVO.setgLAccounts(vendorDTO.getgLAccounts());
		vendorsVO.setFullName(vendorDTO.getFullName());
		vendorsVO.setSalutation(vendorDTO.getSalutation());
		vendorsVO.setState(vendorDTO.getState());
		vendorsVO.setDescription(vendorDTO.getDescription());
		vendorsVO.setAssignedTo(vendorDTO.getAssignedTo());
		vendorsVO.setAlternateEmailId(vendorDTO.getAlternateEmailId());
		vendorsVO.setAddressLine1(vendorDTO.getAddressLine1());
		vendorsVO.setAddressLine2(vendorDTO.getAddressLine2());
		vendorsVO.setCity(vendorDTO.getCity());
		vendorsVO.setCountry(vendorDTO.getCountry());
		vendorsVO.setCreatedBy(vendorDTO.getCreatedBy());
		vendorsVO.setCreatedDate(vendorDTO.getCreatedDate());
		vendorsVO.setFax(vendorDTO.getFax());
		vendorsVO.setFaxIsd(vendorDTO.getFaxIsd());
		vendorsVO.setFaxStd(vendorDTO.getFaxStd());
		vendorsVO.setMobileIsd(vendorDTO.getMobileIsd());
		vendorsVO.setMobileNo(vendorDTO.getMobileNo());
		vendorsVO.setWebSite(vendorDTO.getWebSite());
		vendorsVO.setZipCode(vendorDTO.getZipCode());
		vendorsVO.setUpdateDate(vendorDTO.getUpdateDate());
		vendorsVO.setUpdatedBy(vendorDTO.getUpdatedBy());
		vendorsVO.setPhoneNo(vendorDTO.getPhoneNo());
		vendorsVO.setPhoneIsd(vendorDTO.getPhoneIsd());
		vendorsVO.setPhoneStd(vendorDTO.getPhoneStd());
		
		return vendorsVO;
	}
	
	public static NoteVO getNoteVOFromNote(NoteVO noteVO, Note note)
			throws Exception {

		noteVO.setNoteId(note.getNoteId());
		noteVO.setNoteTag(note.getNoteTag());
		noteVO.setNoteDescription(note.getNoteDescription());
		noteVO.setNoteTitle(note.getNoteTitle());
		noteVO.setCreatedBy(note.getCreatedBy());
		noteVO.setCreatedDate(note.getCreatedDate());
		return noteVO;
	}
	
	
	/**
	 * <p>
	 * here we are getting string which is set from resultSet and here we
	 * are setting into different value object by splitting using
	 * StringTokenizer's nextToken().
	 * </p>
	 */
	public static EventVO getEventFromDetails(EventVO eventVO,
			EventDTO eventDTO) {
		eventVO.setEventId(eventDTO.getEventId());
		eventVO.setEventTitle(eventDTO.getEventTitle());
		
		eventVO.setEventDate(eventDTO.getEventDate());
		eventVO.setEventCategory(eventDTO.getEventCategory());
		eventVO.setOrganizeName(eventDTO.getOrganizeName());
		eventVO.setMobileIsd(eventDTO.getMobileIsd());
		eventVO.setMobileNo(eventDTO.getMobileNo());
		eventVO.setMobileNumber(eventDTO.getMobileNumber());
		eventVO.setEmail(eventDTO.getEmail());
		eventVO.setUrlNo(eventDTO.getUrlNo());
		eventVO.setEventStatus(eventDTO.getEventStatus());
		eventVO.setPublishDate(eventDTO.getPublishDate());
		eventVO.setEventVanue(eventDTO.getEventVanue());
		eventVO.setEventFile(eventDTO.getEventFile());
		eventVO.setDescripation(eventDTO.getDescripation());
		eventVO.setCreatedDate(eventDTO.getCreatedDate());
		return eventVO;
	}

	/**
	 * <p>
	 * here we are getting string which is set from resultSet and here we
	 * are setting into different value object by splitting using
	 * StringTokenizer's nextToken().
	 * </p>
	 */
	public static InvoiceSaleVO getSalesFromSalesDetails(InvoiceSaleVO invoiceSaleVO,
			InvoiceSale invoiceSale) {
		invoiceSaleVO.setSalesId(invoiceSale.getSalesId());
		invoiceSaleVO.setFullName(invoiceSale.getFullName());
		invoiceSaleVO.setFullNameConsumer(invoiceSale.getFullNameConsumer());
		invoiceSaleVO.setCustomerId(invoiceSale.getCustomerId());
		invoiceSaleVO.setCustomerIdConsumer(invoiceSale.getCustomerIdConsumer());
		invoiceSaleVO.setPhoneNo(invoiceSale.getPhoneNo());
		invoiceSaleVO.setPhoneNoConsumer(invoiceSale.getPhoneNoConsumer());
		invoiceSaleVO.setMobileNo(invoiceSale.getMobileNo());
		invoiceSaleVO.setEmailId(invoiceSale.getEmailId());
		invoiceSaleVO.setCity(invoiceSale.getCity());
		invoiceSaleVO.setGender(invoiceSale.getGender());
		invoiceSaleVO.setWorkLocation(invoiceSale.getWorkLocation());
		invoiceSaleVO.setAddress(invoiceSale.getAddress());
		invoiceSaleVO.setAddressConsumer(invoiceSale.getAddressConsumer());
		invoiceSaleVO.setSalesDate(invoiceSale.getSalesDate());
		invoiceSaleVO.setSalesDateConsumer(invoiceSale.getSalesDateConsumer());
		invoiceSaleVO.setItemId(invoiceSale.getItemId());
		invoiceSaleVO.setItemDescription(invoiceSale.getItemDescription());
		invoiceSaleVO.setItemQuantity(invoiceSale.getItemQuantity());
		invoiceSaleVO.setItemPrice(invoiceSale.getItemPrice());
		invoiceSaleVO.setItemTax(invoiceSale.getItemTax());
		invoiceSaleVO.setAmount(invoiceSale.getAmount());
		invoiceSaleVO.setSubTotal(invoiceSale.getSubTotal());
		invoiceSaleVO.setTotalTax(invoiceSale.getTotalTax());
		invoiceSaleVO.setTotal(invoiceSale.getTotal());
		invoiceSaleVO.setDiscount(invoiceSale.getDiscount());
		invoiceSaleVO.setNetTotal(invoiceSale.getNetTotal());
		invoiceSaleVO.setTranspportCharges(invoiceSale.getTranspportCharges());
		invoiceSaleVO.setCustomerType(invoiceSale.getCustomerType());
		invoiceSaleVO.setPaymentAnswer(invoiceSale.getPaymentAnswer());
		invoiceSaleVO.setPayment(invoiceSale.getPayment());
		invoiceSaleVO.setPaymentMode(invoiceSale.getPaymentMode());
		
		return invoiceSaleVO;
	}
	
	
	public static RetailerCustomerVO getRetailerFromRetailerDetails(RetailerCustomerVO retailerCustomerVO,
			Retailer retailer) {
		retailerCustomerVO.setCustomerId(retailer.getCustomerId());
		retailerCustomerVO.setSalutation(retailer.getSalutation());
		
		retailerCustomerVO.setFullName(retailer.getFullName());
		retailerCustomerVO.setDob(retailer.getDob());
		retailerCustomerVO.setAddress1(retailer.getAddress1());
		retailerCustomerVO.setAddress2(retailer.getAddress2());
		retailerCustomerVO.setCity(retailer.getCity());
		retailerCustomerVO.setState(retailer.getState());
		retailerCustomerVO.setPinCode(retailer.getPinCode());
		retailerCustomerVO.setPhoneNo(retailer.getPhoneNo());
		retailerCustomerVO.setPhoneNo2(retailer.getPhoneNo2());
		retailerCustomerVO.setMobileNo(retailer.getMobileNo());
		retailerCustomerVO.setMobileNo2(retailer.getMobileNo2());
		retailerCustomerVO.setFaxNo(retailer.getFaxNo());
		retailerCustomerVO.setSocialMailId(retailer.getSocialMailId());
		retailerCustomerVO.setImage(retailer.getImage());
		retailerCustomerVO.setCreationDate(retailer.getCreationDate());
		retailerCustomerVO.setCreatedBy(retailer.getCreatedBy());
		retailerCustomerVO.setWorkLocation(retailer.getWorkLocation());
		retailerCustomerVO.setCurrency(retailer.getCurrency());
		retailerCustomerVO.setContactPerson(retailer.getContactPerson());
		retailerCustomerVO.setCountry(retailer.getCountry());
		retailerCustomerVO.setPhoneNumberIsd(retailer.getPhoneNumberIsd());
		retailerCustomerVO.setPhoneNumberStd(retailer.getPhoneNumberStd());
		retailerCustomerVO.setPhoneNumberIsd2(retailer.getPhoneNumberIsd2());
		retailerCustomerVO.setPhoneNumberStd2(retailer.getPhoneNumberStd2());
		retailerCustomerVO.setHomewebsite(retailer.getHomewebsite());
		retailerCustomerVO.setRefferedBy(retailer.getRefferedBy());
		retailerCustomerVO.setProfileDescription(retailer.getProfileDescription());
		retailerCustomerVO.setPeimaryMailId(retailer.getPeimaryMailId());
		retailerCustomerVO.setAlternativeMail(retailer.getAlternativeMail());
		retailerCustomerVO.setHomeContFaxNumIsd(retailer.getHomeContFaxNumIsd());
		retailerCustomerVO.setHomeContFaxnumStd(retailer.getHomeContFaxnumStd());
		
		
		retailerCustomerVO.setTransactionId(retailer.getTransactionId());
		retailerCustomerVO.setDescription(retailer.getDescription());
		retailerCustomerVO.setTotalPaid(retailer.getTotalPaid());
		retailerCustomerVO.setTotalDue(retailer.getTotalDue());
		retailerCustomerVO.setPaid(retailer.getPaid());
		retailerCustomerVO.setDue(retailer.getDue());
		retailerCustomerVO.setTransactionDate(retailer.getTransactionDate());
		retailerCustomerVO.setRetailerId(retailer.getRetailerId());
		retailerCustomerVO.setPaymentMode(retailer.getPaymentMode());
		retailerCustomerVO.setPayment(retailer.getPayment());
		retailerCustomerVO.setBillNo(retailer.getBillNo());
		
		
		return retailerCustomerVO;
	}
	
	
	public static ConsumerCustomerVO getConsumerFromConsumerDetails(ConsumerCustomerVO consumerCustomerVO,
			Consumer consumer) {
		consumerCustomerVO.setCustomerId(consumer.getCustomerId());
		consumerCustomerVO.setSalutation(consumer.getSalutation());
		
		consumerCustomerVO.setFullName(consumer.getFullName());
		consumerCustomerVO.setDob(consumer.getDob());
		consumerCustomerVO.setAddress1(consumer.getAddress1());
		consumerCustomerVO.setAddress2(consumer.getAddress2());
		consumerCustomerVO.setCity(consumer.getCity());
		consumerCustomerVO.setState(consumer.getState());
		consumerCustomerVO.setPinCode(consumer.getPinCode());
		consumerCustomerVO.setPhoneNo(consumer.getPhoneNo());
		consumerCustomerVO.setPhoneNo2(consumer.getPhoneNo2());
		consumerCustomerVO.setMobileNo(consumer.getMobileNo());
		consumerCustomerVO.setMobileNo2(consumer.getMobileNo2());
		consumerCustomerVO.setFaxNo(consumer.getFaxNo());
		consumerCustomerVO.setSocialMailId(consumer.getSocialMailId());
		consumerCustomerVO.setImage(consumer.getImage());
		consumerCustomerVO.setCreationDate(consumer.getCreationDate());
		consumerCustomerVO.setCreatedBy(consumer.getCreatedBy());
		consumerCustomerVO.setWorkLocation(consumer.getWorkLocation());
		consumerCustomerVO.setCurrency(consumer.getCurrency());
		consumerCustomerVO.setContactPerson(consumer.getContactPerson());
		consumerCustomerVO.setCountry(consumer.getCountry());
		consumerCustomerVO.setPhoneNumberIsd(consumer.getPhoneNumberIsd());
		consumerCustomerVO.setPhoneNumberStd(consumer.getPhoneNumberStd());
		consumerCustomerVO.setPhoneNumberIsd2(consumer.getPhoneNumberIsd2());
		consumerCustomerVO.setPhoneNumberStd2(consumer.getPhoneNumberStd2());
		consumerCustomerVO.setHomewebsite(consumer.getHomewebsite());
		consumerCustomerVO.setRefferedBy(consumer.getRefferedBy());
		consumerCustomerVO.setProfileDescription(consumer.getProfileDescription());
		consumerCustomerVO.setPeimaryMailId(consumer.getPeimaryMailId());
		consumerCustomerVO.setAlternativeMail(consumer.getAlternativeMail());
		
		
		consumerCustomerVO.setTransactionId(consumer.getTransactionId());
		consumerCustomerVO.setDescription(consumer.getDescription());
		consumerCustomerVO.setTotalPaid(consumer.getTotalPaid());
		consumerCustomerVO.setTotalDue(consumer.getTotalDue());
		consumerCustomerVO.setPaid(consumer.getPaid());
		consumerCustomerVO.setDue(consumer.getDue());
		consumerCustomerVO.setTransactionDate(consumer.getTransactionDate());
		consumerCustomerVO.setRetailerId(consumer.getRetailerId());
		consumerCustomerVO.setPaymentMode(consumer.getPaymentMode());
		consumerCustomerVO.setPayment(consumer.getPayment());
		consumerCustomerVO.setBillNo(consumer.getBillNo());
		
		return consumerCustomerVO;
	}
	
	
	public static PurchaseCementVO getPurchaseCementFromPurchaseCementDetails(PurchaseCementVO purchaseCementVO,
			PurchaseCement purchaseCement) {
		purchaseCementVO.setPurchaseId(purchaseCement.getPurchaseId());
		purchaseCementVO.setInvoiceNo(purchaseCement.getInvoiceNo());
		
		purchaseCementVO.setCompanyName(purchaseCement.getCompanyName());
		purchaseCementVO.setOrderNo(purchaseCement.getOrderNo());
		purchaseCementVO.setDeliveryPlace(purchaseCement.getDeliveryPlace());
		purchaseCementVO.setDescription(purchaseCement.getDescription());
		purchaseCementVO.setDealerName(purchaseCement.getDealerName());
		purchaseCementVO.setPlaceOfSupply(purchaseCement.getPlaceOfSupply());
		purchaseCementVO.setDistrict(purchaseCement.getDistrict());
		purchaseCementVO.setMaterialCode(purchaseCement.getMaterialCode());
		purchaseCementVO.setHsnCode(purchaseCement.getHsnCode());
		purchaseCementVO.setQuantity(purchaseCement.getQuantity());
		purchaseCementVO.setModeOfTtansport(purchaseCement.getModeOfTtansport());
		purchaseCementVO.setTransporter(purchaseCement.getTransporter());
		purchaseCementVO.setTruckNo(purchaseCement.getTruckNo());
		purchaseCementVO.setInconterm(purchaseCement.getInconterm());
		purchaseCementVO.setDealerAddress(purchaseCement.getDealerAddress());
		purchaseCementVO.setSgst(purchaseCement.getSgst());
		purchaseCementVO.setCgst(purchaseCement.getCgst());
		purchaseCementVO.setSgstAmount(purchaseCement.getSgstAmount());
		purchaseCementVO.setCgstAmount(purchaseCement.getCgstAmount());
		purchaseCementVO.setDiscount(purchaseCement.getDiscount());
		purchaseCementVO.setNetAmount(purchaseCement.getNetAmount());
		purchaseCementVO.setWeekNo(purchaseCement.getWeekNo());
		purchaseCementVO.setInvoiceDate(purchaseCement.getInvoiceDate());
		purchaseCementVO.setDealerContact(purchaseCement.getDealerContact());
		purchaseCementVO.setUnitPrice(purchaseCement.getUnitPrice());
		purchaseCementVO.setGst(purchaseCement.getGst());
		purchaseCementVO.setDealerRef(purchaseCement.getDealerRef());
		purchaseCementVO.setdFullName(purchaseCement.getdFullName());
		purchaseCementVO.setGstAmount(purchaseCement.getGstAmount());
		purchaseCementVO.setPaymentAnswer(purchaseCement.getPaymentAnswer());
		purchaseCementVO.setPayment(purchaseCement.getPayment());
		purchaseCementVO.setTotal(purchaseCement.getTotal());
		purchaseCementVO.setAclId(purchaseCement.getAclId());
		
		purchaseCementVO.setTransactionId(purchaseCement.getTransactionId());
		purchaseCementVO.setPaid(purchaseCement.getPaid());
		purchaseCementVO.setDue(purchaseCement.getDue());
		purchaseCementVO.setTotalPaid(purchaseCement.getTotalPaid());
		purchaseCementVO.setTotalDue(purchaseCement.getTotalDue());
		purchaseCementVO.setTransactionDate(purchaseCement.getTransactionDate());
		purchaseCementVO.setPaymentMode(purchaseCement.getPaymentMode());
		purchaseCementVO.setTransactionBillNo(purchaseCement.getTransactionBillNo());
		return purchaseCementVO;
	}
	
	
	public static PurchaseSteelBarVO getPurchaseSteelbarFromPurchaseSteebarDeltails(PurchaseSteelBarVO purchaseSteelBarVO,
			PurchaseSteelbar purchaseSteelbar) {
		purchaseSteelBarVO.setPurchaseId(purchaseSteelbar.getPurchaseId());
		purchaseSteelBarVO.setInvoiceNo(purchaseSteelbar.getInvoiceNo());
		
		purchaseSteelBarVO.setCompanyName(purchaseSteelbar.getCompanyName());
		purchaseSteelBarVO.setOrderNo(purchaseSteelbar.getOrderNo());
		purchaseSteelBarVO.setDeliveryPlace(purchaseSteelbar.getDeliveryPlace());
		purchaseSteelBarVO.setDescription(purchaseSteelbar.getDescription());
		purchaseSteelBarVO.setDealerName(purchaseSteelbar.getDealerName());
		purchaseSteelBarVO.setPlaceOfSupply(purchaseSteelbar.getPlaceOfSupply());
		purchaseSteelBarVO.setDistrict(purchaseSteelbar.getDistrict());
		purchaseSteelBarVO.setMaterialCode(purchaseSteelbar.getMaterialCode());
		purchaseSteelBarVO.setHsnCode(purchaseSteelbar.getHsnCode());
		purchaseSteelBarVO.setQuantity(purchaseSteelbar.getQuantity());
		purchaseSteelBarVO.setModeOfTtansport(purchaseSteelbar.getModeOfTtansport());
		purchaseSteelBarVO.setTransporter(purchaseSteelbar.getTransporter());
		purchaseSteelBarVO.setTruckNo(purchaseSteelbar.getTruckNo());
		purchaseSteelBarVO.setInconterm(purchaseSteelbar.getInconterm());
		purchaseSteelBarVO.setDealerAddress(purchaseSteelbar.getDealerAddress());
		purchaseSteelBarVO.setSgst(purchaseSteelbar.getSgst());
		purchaseSteelBarVO.setCgst(purchaseSteelbar.getCgst());
		purchaseSteelBarVO.setSgstAmount(purchaseSteelbar.getSgstAmount());
		purchaseSteelBarVO.setCgstAmount(purchaseSteelbar.getCgstAmount());
		purchaseSteelBarVO.setDiscount(purchaseSteelbar.getDiscount());
		purchaseSteelBarVO.setNetAmount(purchaseSteelbar.getNetAmount());
		purchaseSteelBarVO.setWeekNo(purchaseSteelbar.getWeekNo());
		purchaseSteelBarVO.setInvoiceDate(purchaseSteelbar.getInvoiceDate());
		purchaseSteelBarVO.setDealerContact(purchaseSteelbar.getDealerContact());
		purchaseSteelBarVO.setUnitPrice(purchaseSteelbar.getUnitPrice());
		purchaseSteelBarVO.setGst(purchaseSteelbar.getGst());
		purchaseSteelBarVO.setDealerRef(purchaseSteelbar.getDealerRef());
		purchaseSteelBarVO.setGstAmount(purchaseSteelbar.getGstAmount());
		purchaseSteelBarVO.setPaymentAnswer(purchaseSteelbar.getPaymentAnswer());
		purchaseSteelBarVO.setPayment(purchaseSteelbar.getPayment());
		purchaseSteelBarVO.setTotal(purchaseSteelbar.getTotal());
		purchaseSteelBarVO.setQuantityInKg(purchaseSteelbar.getQuantityInKg());
		
		purchaseSteelBarVO.setTransactionId(purchaseSteelbar.getTransactionId());
		purchaseSteelBarVO.setPaid(purchaseSteelbar.getPaid());
		purchaseSteelBarVO.setDue(purchaseSteelbar.getDue());
		purchaseSteelBarVO.setTotalPaid(purchaseSteelbar.getTotalPaid());
		purchaseSteelBarVO.setTotalDue(purchaseSteelbar.getTotalDue());
		purchaseSteelBarVO.setTransactionDate(purchaseSteelbar.getTransactionDate());
		purchaseSteelBarVO.setPaymentMode(purchaseSteelbar.getPaymentMode());
		purchaseSteelBarVO.setTransactionBillNo(purchaseSteelbar.getTransactionBillNo());
		
		
		
		
		
		return purchaseSteelBarVO;
	}
	
	
	public static DealerVO getDealerFromDealerDetails(DealerVO dealerVO,
			Dealer dealer) {
		dealerVO.setDealerId(dealer.getDealerId());
		dealerVO.setSalutation(dealer.getSalutation());
		
		dealerVO.setFullName(dealer.getFullName());
		dealerVO.setDob(dealer.getDob());
		dealerVO.setAddress1(dealer.getAddress1());
		dealerVO.setAddress2(dealer.getAddress2());
		dealerVO.setCity(dealer.getCity());
		dealerVO.setState(dealer.getState());
		dealerVO.setPinCode(dealer.getPinCode());
		dealerVO.setPhoneNo(dealer.getPhoneNo());
		dealerVO.setPhoneNo2(dealer.getPhoneNo2());
		dealerVO.setMobileNo(dealer.getMobileNo());
		dealerVO.setMobileNo2(dealer.getMobileNo2());
		dealerVO.setFaxNo(dealer.getFaxNo());
		dealerVO.setSocialMailId(dealer.getSocialMailId());
		dealerVO.setImage(dealer.getImage());
		dealerVO.setCreationDate(dealer.getCreationDate());
		dealerVO.setCreatedBy(dealer.getCreatedBy());
		dealerVO.setWorkLocation(dealer.getWorkLocation());
		dealerVO.setCurrency(dealer.getCurrency());
		dealerVO.setContactPerson(dealer.getContactPerson());
		dealerVO.setCountry(dealer.getCountry());
		dealerVO.setPhoneNumberIsd(dealer.getPhoneNumberIsd());
		dealerVO.setPhoneNumberStd(dealer.getPhoneNumberStd());
		dealerVO.setPhoneNumberIsd2(dealer.getPhoneNumberIsd2());
		dealerVO.setPhoneNumberStd2(dealer.getPhoneNumberStd2());
		dealerVO.setHomewebsite(dealer.getHomewebsite());
		dealerVO.setRefferedBy(dealer.getRefferedBy());
		dealerVO.setProfileDescription(dealer.getProfileDescription());
		dealerVO.setPeimaryMailId(dealer.getPeimaryMailId());
		dealerVO.setAlternativeMail(dealer.getAlternativeMail());
		dealerVO.setHomeContFaxNumIsd(dealer.getHomeContFaxNumIsd());
		dealerVO.setHomeContFaxnumStd(dealer.getHomeContFaxnumStd());
		
		
		dealerVO.setTotal(dealer.getTotal());
		dealerVO.setTransactionId(dealer.getTransactionId());
		dealerVO.setDescription(dealer.getDescription());
		dealerVO.setPaid(dealer.getPaid());
		dealerVO.setDue(dealer.getDue());
		dealerVO.setRetailerId(dealer.getRetailerId());
		dealerVO.setTotalPaid(dealer.getTotalPaid());
		dealerVO.setTotalDue(dealer.getTotalDue());
		dealerVO.setTransactionDate(dealer.getTransactionDate());
		dealerVO.setPaymentMode(dealer.getPaymentMode());
		dealerVO.setTransactionBillNo(dealer.getTransactionBillNo());
		
		
		return dealerVO;
	}
	
	
public static TransportVO getTransportVOFromTransport(TransportVO transportVO, Transport transport) {
		
		transportVO.setTransportId(transport.getTransportId());
		transportVO.setTransportName(transport.getTransportName());
		transportVO.setTransportAddressline1(transport.getTransportAddressline1());
		transportVO.setTruckNumber(transport.getTruckNumber());
		transportVO.setContactPerson(transport.getContactPerson());
		transportVO.setAlternativeContact(transport.getAlternativeContact());
		transportVO.setTransportAddressline2(transport.getTransportAddressline2());
		transportVO.setTransporter(transport.getTransporter());
		transportVO.setCreationDate(transport.getCreationDate());
		transportVO.setContactNumber(transport.getContactNumber());
		transportVO.setCity(transport.getCity());
		
		
				return transportVO;
	}

	

public static TransportVO gettransportFromTransport(TransportVO transportVO, Transport transport) {
	
	transportVO.setTransportId(transport.getTransportId());
	transportVO.setTransportName(transport.getTransportName());
	transportVO.setTransportAddressline1(transport.getTransportAddressline1());
	transportVO.setTruckNumber(transport.getTruckNumber());
	transportVO.setContactPerson(transport.getContactPerson());
	transportVO.setAlternativeContact(transport.getAlternativeContact());
	transportVO.setTransportAddressline2(transport.getTransportAddressline2());
	transportVO.setTransporter(transport.getTransporter());
	transportVO.setCreationDate(transport.getCreationDate());
	transportVO.setContactNumber(transport.getContactNumber());
	transportVO.setCity(transport.getCity());
	
	
			return transportVO;
}


public static PaymentVO getpaymentFromPayment(PaymentVO paymentVO, Payment payment) {
	
	paymentVO.setPyamentID(payment.getPyamentID());
	paymentVO.setPayment(payment.getPayment());
	
	return paymentVO;
}


public static PurchaseWallPaintVO getPurchaseWallPaintFromPurchaseWallPaintDetails(PurchaseWallPaintVO purchaseWallPaintVO,
		WallPaint wallPaint) {
	purchaseWallPaintVO.setPurchaseId(wallPaint.getPurchaseId());
	purchaseWallPaintVO.setInvoiceNo(wallPaint.getInvoiceNo());
	
	purchaseWallPaintVO.setCompanyName(wallPaint.getCompanyName());
	purchaseWallPaintVO.setOrderNo(wallPaint.getOrderNo());
	purchaseWallPaintVO.setDeliveryPlace(wallPaint.getDeliveryPlace());
	purchaseWallPaintVO.setDescription(wallPaint.getDescription());
	purchaseWallPaintVO.setDealerName(wallPaint.getDealerName());
	purchaseWallPaintVO.setPlaceOfSupply(wallPaint.getPlaceOfSupply());
	purchaseWallPaintVO.setDistrict(wallPaint.getDistrict());
	purchaseWallPaintVO.setMaterialCode(wallPaint.getMaterialCode());
	purchaseWallPaintVO.setHsnCode(wallPaint.getHsnCode());
	purchaseWallPaintVO.setQuantity(wallPaint.getQuantity());
	purchaseWallPaintVO.setModeOfTtansport(wallPaint.getModeOfTtansport());
	purchaseWallPaintVO.setTransporter(wallPaint.getTransporter());
	purchaseWallPaintVO.setTruckNo(wallPaint.getTruckNo());
	purchaseWallPaintVO.setInconterm(wallPaint.getInconterm());
	purchaseWallPaintVO.setDealerAddress(wallPaint.getDealerAddress());
	purchaseWallPaintVO.setSgst(wallPaint.getSgst());
	purchaseWallPaintVO.setCgst(wallPaint.getCgst());
	purchaseWallPaintVO.setSgstAmount(wallPaint.getSgstAmount());
	purchaseWallPaintVO.setCgstAmount(wallPaint.getCgstAmount());
	purchaseWallPaintVO.setDiscount(wallPaint.getDiscount());
	purchaseWallPaintVO.setNetAmount(wallPaint.getNetAmount());
	purchaseWallPaintVO.setWeekNo(wallPaint.getWeekNo());
	purchaseWallPaintVO.setInvoiceDate(wallPaint.getInvoiceDate());
	purchaseWallPaintVO.setDealerContact(wallPaint.getDealerContact());
	purchaseWallPaintVO.setUnitPrice(wallPaint.getUnitPrice());
	purchaseWallPaintVO.setGst(wallPaint.getGst());
	purchaseWallPaintVO.setDealerRef(wallPaint.getDealerRef());
	purchaseWallPaintVO.setdFullName(wallPaint.getdFullName());
	purchaseWallPaintVO.setGstAmount(wallPaint.getGstAmount());
	purchaseWallPaintVO.setPaymentAnswer(wallPaint.getPaymentAnswer());
	purchaseWallPaintVO.setPayment(wallPaint.getPayment());
	purchaseWallPaintVO.setTotal(wallPaint.getTotal());
	purchaseWallPaintVO.setAclId(wallPaint.getAclId());
	
	purchaseWallPaintVO.setTransactionId(wallPaint.getTransactionId());
	purchaseWallPaintVO.setPaid(wallPaint.getPaid());
	purchaseWallPaintVO.setDue(wallPaint.getDue());
	purchaseWallPaintVO.setTotalPaid(wallPaint.getTotalPaid());
	purchaseWallPaintVO.setTotalDue(wallPaint.getTotalDue());
	purchaseWallPaintVO.setTransactionDate(wallPaint.getTransactionDate());
	purchaseWallPaintVO.setPaymentMode(wallPaint.getPaymentMode());
	purchaseWallPaintVO.setTransactionBillNo(wallPaint.getTransactionBillNo());
	return purchaseWallPaintVO;
}


public static PurchasePesticidesVO getPurchasePesticidesVOFromPurchasePesticidesDetails(PurchasePesticidesVO purchasePesticidesVO,
		Pesticides pesticides) {
	purchasePesticidesVO.setPurchaseId(pesticides.getPurchaseId());
	purchasePesticidesVO.setInvoiceNo(pesticides.getInvoiceNo());
	
	purchasePesticidesVO.setCompanyName(pesticides.getCompanyName());
	purchasePesticidesVO.setOrderNo(pesticides.getOrderNo());
	purchasePesticidesVO.setDeliveryPlace(pesticides.getDeliveryPlace());
	purchasePesticidesVO.setDescription(pesticides.getDescription());
	purchasePesticidesVO.setDealerName(pesticides.getDealerName());
	purchasePesticidesVO.setPlaceOfSupply(pesticides.getPlaceOfSupply());
	purchasePesticidesVO.setDistrict(pesticides.getDistrict());
	purchasePesticidesVO.setMaterialCode(pesticides.getMaterialCode());
	purchasePesticidesVO.setHsnCode(pesticides.getHsnCode());
	purchasePesticidesVO.setQuantity(pesticides.getQuantity());
	purchasePesticidesVO.setModeOfTtansport(pesticides.getModeOfTtansport());
	purchasePesticidesVO.setTransporter(pesticides.getTransporter());
	purchasePesticidesVO.setTruckNo(pesticides.getTruckNo());
	purchasePesticidesVO.setInconterm(pesticides.getInconterm());
	purchasePesticidesVO.setDealerAddress(pesticides.getDealerAddress());
	purchasePesticidesVO.setSgst(pesticides.getSgst());
	purchasePesticidesVO.setCgst(pesticides.getCgst());
	purchasePesticidesVO.setSgstAmount(pesticides.getSgstAmount());
	purchasePesticidesVO.setCgstAmount(pesticides.getCgstAmount());
	purchasePesticidesVO.setDiscount(pesticides.getDiscount());
	purchasePesticidesVO.setNetAmount(pesticides.getNetAmount());
	purchasePesticidesVO.setWeekNo(pesticides.getWeekNo());
	purchasePesticidesVO.setInvoiceDate(pesticides.getInvoiceDate());
	purchasePesticidesVO.setDealerContact(pesticides.getDealerContact());
	purchasePesticidesVO.setUnitPrice(pesticides.getUnitPrice());
	purchasePesticidesVO.setGst(pesticides.getGst());
	purchasePesticidesVO.setDealerRef(pesticides.getDealerRef());
	purchasePesticidesVO.setdFullName(pesticides.getdFullName());
	purchasePesticidesVO.setGstAmount(pesticides.getGstAmount());
	purchasePesticidesVO.setPaymentAnswer(pesticides.getPaymentAnswer());
	purchasePesticidesVO.setPayment(pesticides.getPayment());
	purchasePesticidesVO.setTotal(pesticides.getTotal());
	purchasePesticidesVO.setAclId(pesticides.getAclId());
	
	purchasePesticidesVO.setTransactionId(pesticides.getTransactionId());
	purchasePesticidesVO.setPaid(pesticides.getPaid());
	purchasePesticidesVO.setDue(pesticides.getDue());
	purchasePesticidesVO.setTotalPaid(pesticides.getTotalPaid());
	purchasePesticidesVO.setTotalDue(pesticides.getTotalDue());
	purchasePesticidesVO.setTransactionDate(pesticides.getTransactionDate());
	purchasePesticidesVO.setPaymentMode(pesticides.getPaymentMode());
	purchasePesticidesVO.setTransactionBillNo(pesticides.getTransactionBillNo());
	return purchasePesticidesVO;
}
	
}
