<%@page import="com.bst.ckt.vo.LeadVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="/struts-jquery-tags" prefix="sj"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
.error_strings {
	color: red;
}
</style>

</head>
<body>

	<div id="content">
		<div class="outer">
			<div class="inner bg-light lter">

				<!--BEGIN INPUT TEXT FIELDS-->
				<div class="row">
					<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
						<div class="box inverse">
							<header>
							<div class="icons">
								<a href="leadDashboard.action" data-toggle="tooltip"
									data-original-title="Back To DashBoard"> <i
									class="fa fa-th-large"></i>
								</a>
							</div>
							<h5>
								<s:text name="Update Contact" />
							</h5>

							<!-- .toolbar -->

							<div class="toolbar">
								<nav style="padding: 8px;"> <a href="javascript:;"
									class="btn btn-danger btn-xs close-box"> <i
									class="fa fa-times"></i>
								</a> </nav>
							</div>
							</header>
							<!-- /toolbar -->
							<div class="container"
								style="margin-top: 20px; margin-bottom: 20px;">
								<s:form name="#" action="#">


									<!-- Nav tabs -->
									<ul class="nav nav-tabs" role="tablist">
										<li role="presentation" class="active"><a href="#"
											style="background-color: #F9F9F9; color: Gray;"><s:text
													name="Contact Information" /></a></li>
										<li role="presentation"><a href="#" style="color: Gray;"><s:text
													name="Social Information" /></a></li>


									</ul>
									<!-- Tab panes -->
									<div id="content" style="background-color: #F9F9F9;">
									<div class="row">
									<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
									
									<div class="box inverse" style="margin-top: -10px; margin-bottom: 0px; padding-left: 20px;">
									
										<div class="alert alert-info" role="alert"
											style="margin-top: 25px; margin-left: 5px; margin-right: 5px;">

											<p>
												<s:if test="hasActionErrors()">
													<s:actionerror />
												</s:if>
												<s:elseif test="hasActionMessages()">
													<s:actionmessage />
												</s:elseif>
												<s:else>

													<div class="infoIcon">
														<span class="fa fa-info" style="margin-left: 3px;"></span>
													</div>&nbsp;&nbsp;&nbsp;<s:text name="add.create.info.bar" />
												</s:else>
											</p>
										</div>

										<div class="row" style="margin-top: 20px;">
											<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
												<h5>
													<s:text name="add.create.contact.contactinfo"></s:text>
												</h5>
												<hr style="margin-top: -5px">
											</div>

										</div>

										<div class="row">
											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
														<label class="control-label col-lg-4"> <s:text
																name="add.create.lead.contactperson"></s:text> <span
															class="star">*</span></label>

													</div>
													<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
														<div class="row">
															<div class="col-lg-3 col-md-3 col-sm-3 col-xs-5">
																<s:select cssClass="form-control "
																	list="{'Mr','Mrs','Dr','Miss','Prof','Other'}"
																	headerValue="Mr" name="salutation" tabindex="1">

																</s:select>

																<div id='addContactForm_salutation_errorloc'
																	class="error_strings"></div>
															</div>
															<div class="col-lg-9 col-md-9 col-sm-9 col-xs-12">
																<s:textfield cssClass="form-control"
																	name="contactperson" tabindex="2"></s:textfield>
																<div id='addContactForm_contactperson_errorloc'
																	class="error_strings"></div>
															</div>
														</div>

													</div>
												</div>
											</div>


											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
														<label class="control-label col-lg-4"> <s:text
																name="group.dashboard.table.groupname"></s:text></label>
													</div>

													<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
														<s:select cssClass="form-control chzn-select"
															list="groupNameList" headerKey="-1"
															headerValue="Select Group" name="groupName" tabindex="3">

														</s:select>

														<div id='addContactForm_groupName_errorloc'
															class="error_strings"></div>

													</div>
												</div>

											</div>
										</div>




										<div class="row">
											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
														<label class="control-label col-lg-4"> <s:text
																name="add.create.contact.nickname"></s:text>
														</label>
													</div>
													<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
														<s:textfield cssClass="form-control" name="nickName"
															tabindex="4"></s:textfield>
														<div id='addContactForm_nickName_errorloc'
															class="error_strings"></div>
													</div>
												</div>
											</div>
											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
														<label class="control-label col-lg-4"> <s:text
																name="add.client.Designation"></s:text> <span
															class="star">*</span></label>
													</div>
													<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
														<s:select cssClass="form-control chzn-select"
															list="designationList" headerKey="1" name="designation"
															tabindex="5">

														</s:select>
														<div id='addContactForm_designation_errorloc'
															class="error_strings"></div>
													</div>
												</div>
											</div>
										</div>



										<div class="row">
											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
														<label class="control-label col-lg-4"><s:text
																name="add.client.phone.number"></s:text> </label>
													</div>
													<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
														<s:textfield cssClass="form-control" name="phoneNumber"
															tabindex="6"></s:textfield>
														<div id='addContactForm_phoneNumber_errorloc'
															class="error_strings"></div>
													</div>
												</div>
											</div>
											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
														<label class="control-label col-lg-4"><s:text
																name="add.create.contact.referredby"></s:text> <span
															class="star">*</span></label>
													</div>
													<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
														<s:textfield cssClass="form-control" name="referredBy"
															tabindex="7"></s:textfield>
														<div id='addContactForm_referredBy_errorloc'
															class="error_strings"></div>
													</div>
												</div>
											</div>
										</div>



										<div class="row">
											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
														<label class="control-label col-lg-4"><s:text
																name="add.create.contact.mobilenumber1"></s:text> <span
															class="star">*</span></label>
													</div>
													<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
														<s:textfield cssClass="form-control" name="mobileNo"
															tabindex="8"></s:textfield>
														<div id='addContactForm_mobileNo_errorloc'
															class="error_strings"></div>
													</div>
												</div>
											</div>

											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
														<label class="control-label col-lg-4"><s:text
																name="add.create.contact.mobilenumber2"></s:text> </label>
													</div>

													<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
														<s:textfield cssClass="form-control" name="mobileNumber"
															tabindex="9"></s:textfield>
														<div id='addContactForm_mobileNumber_errorloc'
															class="error_strings"></div>
													</div>
												</div>
											</div>
										</div>

										<div class="row">
											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
														<label class="control-label col-lg-4"><s:text
																name="add.user.email.id"></s:text></label>
													</div>
													<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
														<s:textfield cssClass="form-control" name="emailId"
															tabindex="10"></s:textfield>
														<div id='addContactForm_emailId_errorloc'
															class="error_strings"></div>
													</div>
												</div>
											</div>
											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
														<label class="control-label col-lg-4"> <s:text
																name="add.create.lead.fax"></s:text>
														</label>
													</div>

													<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
														<s:textfield cssClass="form-control" name="fax"
															tabindex="11"></s:textfield>
														<div id='addContactForm_fax_errorloc'
															class="error_strings"></div>
													</div>
												</div>
											</div>





										</div>


										<div class="row" style="margin-top: 20px;">
											<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
												<h5>
													<s:text name="add.create.contact.homecontactinfo"></s:text>
												</h5>
												<hr style="margin-top: -5px">
											</div>
										</div>


										<div class="row">
											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
														<label class="control-label col-lg-4"> <s:text
																name="add.create.lead.adress.line1"></s:text> <span
															class="star">*</span></label>
													</div>
													<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
														<s:textfield cssClass="form-control" name="addressLine1"
															tabindex="12"></s:textfield>
														<div id='addContactForm_addressLine1_errorloc'
															class="error_strings"></div>

													</div>
												</div>
											</div>
											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
														<label class="control-label col-lg-4"><s:text
																name="add.create.lead.adress.line2"></s:text> </label>
													</div>
													<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
														<s:textfield cssClass="form-control" name="addressLine2"
															tabindex="13"></s:textfield>
														<div id='addContactForm_addressLine2_errorloc'
															class="error_strings"></div>
													</div>
												</div>
											</div>
										</div>



										<div class="row">

											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
														<label class="control-label col-lg-4"> <s:text
																name="add.create.lead.city"></s:text>
														</label>
													</div>
													<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
														<s:textfield cssClass="form-control" name="city"
															tabindex="14"></s:textfield>
														<div id='addContactForm_city_errorloc'
															class="error_strings"></div>
													</div>
												</div>
											</div>
											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
														<label class="control-label col-lg-4"><s:text
																name="add.create.lead.state"></s:text> </label>
													</div>
													<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
														<s:textfield cssClass="form-control" name="state"
															tabindex="15"></s:textfield>
														<div id='addContactForm_state_errorloc'
															class="error_strings"></div>
													</div>
												</div>
											</div>
										</div>



										<div class="row">
											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
														<label class="control-label col-lg-4"> <s:text
																name="add.create.lead.country"></s:text>
														</label>
													</div>
													<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
														<s:select cssClass="form-control chzn-select"
															list="countryList" name="country" headerKey="1"
															tabindex="16">


														</s:select>
														<div id='addContactForm_country_errorloc'
															class="error_strings"></div>
													</div>
												</div>
											</div>
											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">

												<div class="row form-group">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
														<label class="control-label col-lg-4"><s:text
																name="add.create.lead.zipcode"></s:text></label>
													</div>
													<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
														<s:textfield cssClass="form-control" name="zipcode"
															tabindex="17"></s:textfield>
														<div id='addContactForm_zipcode_errorloc'
															class="error_strings"></div>
													</div>
												</div>
											</div>
										</div>



										<div class="row">
											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
														<label class="control-label col-lg-4"> <s:text
																name="add.create.lead.phone"></s:text>
														</label>
													</div>
													<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
														<s:textfield cssClass="form-control" name="phone"
															tabindex="18"></s:textfield>
														<div id='addContactForm_phone_errorloc'
															class="error_strings"></div>
													</div>
												</div>
											</div>
											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
														<label class="control-label col-lg-4"> <s:text
																name="add.create.lead.mobile"></s:text> <span
															class="star">*</span></label>
													</div>
													<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
														<s:textfield cssClass="form-control"
															name="homeContactMobile" tabindex="19"></s:textfield>
														<div id='addContactForm_homeContactMobile_errorloc'
															class="error_strings"></div>
													</div>
												</div>
											</div>
										</div>

										<div class="row">
											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
														<label class="control-label col-lg-4"> <s:text
																name="add.user.email.id"></s:text>
														</label>
													</div>
													<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
														<s:textfield cssClass="form-control"
															name="homeContactEmailID" tabindex="20"></s:textfield>
														<div id='addContactForm_homeContactEmailID_errorloc'
															class="error_strings"></div>
													</div>
												</div>
											</div>
											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
														<label class="control-label col-lg-4"><s:text
																name="add.create.lead.fax"></s:text> </label>
													</div>
													<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
														<s:textfield cssClass="form-control" name="homeContactFax"
															tabindex="21"></s:textfield>
														<div id='addContactForm_homeContactFax_errorloc'
															class="error_strings"></div>
													</div>
												</div>
											</div>
										</div>


										<div class="row" style="margin-top: 20px;">
											<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
												<h5>
													<s:text name="add.create.contact.workcontactinfo"></s:text>

												</h5>
												<hr style="margin-top: -5px">
											</div>

										</div>



										<div class="row">

											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
														<label class="control-label col-lg-4"> <s:text
																name="add.create.lead.adress.line1"></s:text> <span
															class="star">*</span></label>
													</div>
													<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
														<s:textfield cssClass="form-control"
															name="workContactAddressOne" tabindex="22"></s:textfield>
														<div id='addContactForm_workContactAddressOne_errorloc'
															class="error_strings"></div>
													</div>
												</div>
											</div>
											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
														<label class="control-label col-lg-4"><s:text
																name="add.create.lead.adress.line2"></s:text> </label>
													</div>
													<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
														<s:textfield cssClass="form-control"
															name="workContactAddressTwo" tabindex="23"></s:textfield>
														<div id='addContactForm_workContactAddressTwo_errorloc'
															class="error_strings"></div>
													</div>
												</div>
											</div>
										</div>



										<div class="row">

											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
														<label class="control-label col-lg-4"><s:text
																name="add.create.lead.city"></s:text> </label>
													</div>
													<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
														<s:textfield cssClass="form-control"
															name="workContactCity" tabindex="24"></s:textfield>
														<div id='addContactForm_workContactCity_errorloc'
															class="error_strings"></div>
													</div>

												</div>
											</div>
											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
														<label class="control-label col-lg-4"><s:text
																name="add.create.lead.state"></s:text> </label>
													</div>
													<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
														<s:textfield cssClass="form-control"
															name="workContactState" tabindex="25"></s:textfield>
														<div id='addContactForm_workContactState_errorloc'
															class="error_strings"></div>
													</div>

												</div>
											</div>
										</div>



										<div class="row">
											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
														<label class="control-label col-lg-4"><s:text
																name="add.create.lead.country"></s:text> </label>
													</div>
													<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
														<s:select name="workContactCountry"
															cssClass="form-control chzn-select" list="countryList"
															headerKey="1" tabindex="26">
														</s:select>
														<div id='addContactForm_workContactCountry_errorloc'
															class="error_strings"></div>
													</div>

												</div>
											</div>
											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
														<label class="control-label col-lg-4"> <s:text
																name="add.create.lead.zipcode"></s:text>
														</label>
													</div>
													<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
														<s:textfield cssClass="form-control"
															name="workContactZipCode" tabindex="27"></s:textfield>
														<div id='addContactForm_workContactZipCode_errorloc'
															class="error_strings"></div>
													</div>

												</div>
											</div>
										</div>



										<div class="row">
											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
														<label class="control-label col-lg-4"> <s:text
																name="add.create.lead.phone"></s:text></label>
													</div>
													<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
														<s:textfield cssClass="form-control"
															name="workContactPhone" tabindex="28"></s:textfield>
														<div id='addContactForm_workContactPhone_errorloc'
															class="error_strings"></div>
													</div>

												</div>
											</div>

											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
														<label class="control-label col-lg-4"> <s:text
																name="add.create.lead.mobile"></s:text> <span
															class="star">*</span></label>
													</div>
													<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
														<s:textfield cssClass="form-control"
															name="workContactMobile" tabindex="29"></s:textfield>
														<div id='addContactForm_workContactMobile_errorloc'
															class="error_strings"></div>
													</div>

												</div>
											</div>
										</div>

										<div class="row">
											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
														<label class="control-label col-lg-4"><s:text
																name="add.user.email.id"></s:text> </label>
													</div>
													<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
														<s:textfield cssClass="form-control"
															name="workContactEmailId" tabindex="30"></s:textfield>
														<div id='addContactForm_workContactEmailId_errorloc'
															class="error_strings"></div>
													</div>

												</div>
											</div>
											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
														<label class="control-label col-lg-4"><s:text
																name="add.create.lead.fax"></s:text> </label>
													</div>
													<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
														<s:textfield cssClass="form-control" name="workContactFax"
															tabindex="31"></s:textfield>
														<div id='addContactForm_workContactFax_errorloc'
															class="error_strings"></div>
													</div>

												</div>
											</div>
										</div>

										<div class="row" style="margin-top: 20px;">
											<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
												<h5>
													<s:text name="add.group.profile.description"></s:text>
												</h5>
												<hr style="margin-top: -5px">
											</div>
										</div>



										<div class="form-group">
											<div class="row" style="margin: 1% 2%;" id="data_grid">
												<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">

													<s:textarea name="profileDescription" id="wysihtml5"
														cssClass="form-control" rows="10" tabindex="32">

													</s:textarea>
													<div id='addContactForm_profileDescription_errorloc'
														class="error_strings"></div>

												</div>

											</div>
										</div>

										<div class="form-group">
											<div class="row">
												<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
													<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
														<div class="row">
															<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
																<label class="control-label col-lg-4"><s:text
																		name="myAccount.user.profile.profile.image"></s:text>
																</label>
															</div>
															<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
																<div class="fileinput fileinput-new"
																	data-provides="fileinput">
																	<div class="fileinput-new thumbnail"
																		style="width: 200px; height: 150px;">
																		<img data-src="holder.js/100%x100%" alt="...">
																	</div>
																	<div
																		class="fileinput-preview fileinput-exists thumbnail"
																		style="max-width: 200px; max-height: 150px;"></div>
																	<div>
																		<span class="btn btn-default btn-file" tabindex="33"><span
																			class="fileinput-new"><s:text
																					name="project.form.button.upload"></s:text></span> <s:file
																				type="file" name="userImage" /> <span
																			class="fileinput-exists" tabindex="34"><s:text
																					name="project.form.button.change"></s:text> </span> <input
																			type="file" name="..."> </span> <a href="#"
																			class="btn btn-default fileinput-exists"
																			data-dismiss="fileinput" tabindex="35"><s:text
																				name="project.form.button.remove"></s:text></a>
																	</div>
																</div>
															</div>
														</div>

													</div>
												</div>
											</div>

										</div>
										<hr>

										<div class="row">
											<div
												class="col-lg-4 col-md-4 col-sm-12 col-xs-12 col-md-offset-5">
												<a href="groupDashboard.action" data-toggle="tooltip"
													data-original-title="Back To DashBoard"
													class="btn btn-default" tabindex="36"><s:text
														name="project.form.button.cancel"></s:text></a>
												<s:reset cssClass="btn btn-success"
													key="project.form.button.reset" theme="simple"
													onclick="window.location.reload();" tabindex="37" />
												<s:submit cssClass="btn btn-primary"
													key="project.form.button.submit" theme="simple"
													tabindex="38" />
											</div>

										</div>
										</div>
										</div>
										</div>
										</div>
								</s:form>
							</div>
							
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<script>
		$(function() {
			Metis.formGeneral();
			Metis.formWysiwyg();
		});
	</script>

	<script src="outer/js/gen_validatorv4.js" type="text/javascript"></script>
	<script type="text/javascript">
		var frmvalidator = new Validator("addContactForm");
		frmvalidator.EnableOnPageErrorDisplay();
		frmvalidator.EnableMsgsTogether();

		//validation for contact Person 
		frmvalidator.addValidation("salutation", "dontselect=-1",
				"Select Salutation");

		frmvalidator.addValidation("contactperson", "maxlen=50",
				"Contact Person  Should Be 50 Characters");

		frmvalidator.addValidation("contactperson", "req",
				"Enter Contact Person Name");

		frmvalidator.addValidation("contactperson", "alpha",
				"Contact Person Name should be in characters");

		/* //validation for group name 
		frmvalidator.addValidation("groupName", "dontselect=-1",
				"Please Select Group Name");
		 */

		//Validation for Nick Name 
		frmvalidator.addValidation("nickName", "maxlen=50",
				"Nick Name Should Be 50 Characters");

		frmvalidator.addValidation("nickName", "alpha",
				"Nick Name Should Be in Characters");

		//validation for designation 
		frmvalidator.addValidation("designation", "dontselect=1",
				"Select Designation");

		//Validation for phone Number 
		frmvalidator.addValidation("phoneNumber", "numeric",
				"Phone Number Must Be in Digits");
		frmvalidator.addValidation("phoneNumber", "maxlen=10",
				"Phone Number Should Be 10 Digits");

		// validation for referred by 
		frmvalidator.addValidation("referredBy", "alpha",
				"Referred By Must Be in characters");

		frmvalidator.addValidation("referredBy", "maxlen=50",
				"Referred By Should Be 50 characters");

		frmvalidator.addValidation("referredBy", "req", "Enter Referred By");

		//validation for mobile no.1 
		frmvalidator.addValidation("mobileNo", "req", "Enter Mobile No");

		frmvalidator.addValidation("mobileNo", "maxlen=10",
				"Mobile No Should Be 10 Digits");

		frmvalidator.addValidation("mobileNo", "numeric",
				"Mobile No Must Be Digits");

		//validation for mobile no.2 
		frmvalidator.addValidation("mobileNumber", "maxlen=10",
				"Mobile No Should Be 10 Digits");

		frmvalidator.addValidation("mobileNumber", "numeric",
				"Mobile No Must Be Digits");

		//Validation for email.
		frmvalidator.addValidation("emailId", "maxlen=100",
				"Email Id Should Be 100 Digits");

		frmvalidator.addValidation("emailId", "email",
				"Please Enter valid Email Id");

		//validation for Fax number.
		frmvalidator.addValidation("fax", "numeric",
				"Fax Number Must Be Digits");

		frmvalidator.addValidation("fax", "maxlen=6",
				"Fax Number Should Be 6 Digits");

		//validation for Address Line 1.
		frmvalidator.addValidation("addressLine1", "maxlen=100",
				"Address Line 1 Should Be 100 Characters");

		frmvalidator.addValidation("addressLine1", "req",
				"Please Enter Address ");

		//validation for Address Line 2.

		frmvalidator.addValidation("addressLine2", "maxlen=100",
				"Address Line 2 Should Be 100 Characters");

		//validation for City 

		frmvalidator.addValidation("city", "maxlen=50",
				"City Should Be 50 Characters");

		frmvalidator.addValidation("city", "alpha",
				"City Should Be in Characters");

		//validation for State.

		frmvalidator.addValidation("state", "maxlen=50",
				"State Should Be 50 Characters");

		frmvalidator.addValidation("state", "alpha",
				"State Should Be in Characters");

		//validation for country.
		/* frmvalidator
				.addValidation("country", "dontselect=-1", "Please Select Country"); */

		//validation for "zipcode 
		frmvalidator.addValidation("zipcode", "maxlen=8",
				"Zipcode Should Be 8 Characters");

		frmvalidator.addValidation("zipcode", "numeric",
				"Zipcode Should Be in Numbers");

		//validation for phone 

		frmvalidator.addValidation("phone", "maxlen=10",
				"Phone Should Be 10 Digits");

		frmvalidator.addValidation("phone", "numeric",
				"Phone Should Be in Numeric");

		//validation for home mobile number 
		frmvalidator.addValidation("homeContactMobile", "req",
				"Enter Mobile Number");

		frmvalidator.addValidation("homeContactMobile", "maxlen=10",
				"Phone Should Be 10 Digits");

		frmvalidator.addValidation("homeContactMobile", "num",
				"Phone Should Be in Numeric");

		//Validation for home Contact email id 

		frmvalidator.addValidation("homeContactEmailID", "email",
				"Please Enter Valid Email-Id");

		//Validation for home Contact fax 

		frmvalidator.addValidation("homeContactFax", "num",
				"Please Enter Valid Fax Number");

		frmvalidator.addValidation("homeContactFax", "maxlen=6",
				"Fax Number Should Be 6 Digits");

		//Validation for work contact address one  
		frmvalidator.addValidation("workContactAddressOne", "req",
				"Please Enter Address ");

		frmvalidator.addValidation("workContactAddressOne", "maxlen=100",
				"Address Should Be at max 100 characters");

		//Validation for work contact address two 

		frmvalidator.addValidation("workContactAddressTwo", "maxlen=100",
				"Address Line 2 Should Be at max 100 characters");

		//Validation for work contact city 

		frmvalidator.addValidation("workContactCity", "maxlen=50",
				"City Should Be at max 100 characters");

		frmvalidator.addValidation("workContactCity", "alpha",
				"City Should Be in characters");

		//Validation for work contact state 

		frmvalidator.addValidation("workContactState", "alpha",
				"State Should Be in  characters");

		frmvalidator.addValidation("workContactState", "maxlen=50",
				"State Should Be at max 100 characters");

		//validation for work contact country 
		/* frmvalidator.addValidation("workContactCountry", "dontselect=-1",
				"Select Country"); */

		//validation for work contact ZipCode 
		frmvalidator.addValidation("workContactZipCode", "maxlen=8",
				"ZipCode Should Be 8 Characters");

		frmvalidator.addValidation("workContactZipCode", "numeric",
				"ZipCode Should Be in Digits");

		//validation for work contact phone 

		frmvalidator.addValidation("workContactPhone", "maxlen=10",
				"Phone Should Be 10 Digits");

		frmvalidator.addValidation("workContactPhone", "num",
				"Phone Should Be in Numeric");

		//validation for work contact mobile 
		frmvalidator.addValidation("workContactMobile", "req",
				"Please Enter Mobile Number");

		frmvalidator.addValidation("workContactMobile", "maxlen=10",
				"Phone Should Be 10 Digits");

		frmvalidator.addValidation("workContactMobile", "num",
				"Phone Should Be in Numeric");

		//Validation for work Contact EmailId 

		frmvalidator.addValidation("workContactEmailId", "email",
				"Please Enter Valid Email-Id");

		//Validation for work Contact fax 

		frmvalidator.addValidation("workContactFax", "num",
				"Please Enter Valid Fax Number");

		frmvalidator.addValidation("workContactFax", "maxlen=6",
				"Fax Number Should Be 6 Digits");

		//Validation for Profile Description. 
		frmvalidator.addValidation("profileDescription", "maxlen=4000",
				"Profile Description Should Be At Max 4000 Characters");
	</script>
</body>
</html>