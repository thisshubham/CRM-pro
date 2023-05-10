<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="/struts-jquery-tags" prefix="sj"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
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
						<ol class="breadcrumb" style="margin-top: 10px;">
							<li><a href="omiInnerDashboard.action"><i
									class="fa fa-home"></i></a></li>
							<li><a href="contactsDashboard.action"><s:text
										name="Contact"></s:text></a></li>
							<li class="active"><s:text name="Contacts Dashboard"></s:text></li>
							<li class="active"><s:text name="New Contact"></s:text></li>
						</ol>
						<s:form name="addContactForm" cssClass="form-horizontal"
							method="post" action="addNewContacts.action">
							<div class="box dark">
								<header>
								<div class="pull-left">
									<a class="icons" href="contactsDashboard.action"
										data-toggle="tooltip"
										data-original-title="Back To Contacts DashBoard"
										style="color: black;"> <i class="fa fa-th-large"></i>
									</a>
									<h5>
										<s:text name="add.create.contact.createcontacts" />
									</h5>
								</div>
								<div class="pull-right">
									<div class="btn-group">
										<a class="btn btn-default btnheight" data-toggle="tooltip"
											data-original-title="Help"><i class="fa fa-question"></i>
											<s:text name="project.form.button.help"></s:text> </a>
										<button type="submit" data-toggle="tooltip"
											data-original-title="Save" class="btn btn-primary btnheight">
											<i class="fa fa-check"></i>
											<s:text name="project.form.button.save"></s:text>
										</button>
										<a href="addCreatedLead.action" data-toggle="tooltip"
											data-original-title="Reset"
											class="btn btn-success btnheight"><i
											class="fa fa-refresh "></i></a> <a
											href="contactsDashboard.action" data-toggle="tooltip"
											data-original-title="Close" class="btn btn-danger btnheight"><i
											class="fa fa-times fontawesomeht"></i></a>
									</div>

								</div>
								</header>

								<div class="container-fluid">
									<p>
										<s:if test="hasActionErrors()">
											<div class="alert alert-danger" role="alert"
												style="margin-top: 25px; padding-bottom: 7px;">
												<div class="infoIcon">
													<i class="fa fa-times-circle "></i>
													<s:actionerror />
												</div>
											</div>
										</s:if>
										<s:elseif test="hasActionMessages()">
											<div class="alert alert-success" role="alert"
												style="margin-top: 25px; padding-bottom: 7px;">
												<div class="infoIcon">
													<!-- <i class="fa fa-check-circle "></i> -->
													<s:actionmessage />
												</div>
											</div>
										</s:elseif>
										<s:else>

											<div class="alert alert-info" role="alert"
												style="margin-top: 25px;">
												<div class="infoIcon">
													<i class="fa fa-info-circle "></i>
													<s:text name="add.create.lead.information.bar" />
												</div>
											</div>
										</s:else>
									</p>
									<div class="row" style="margin-top: 20px;">
										<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
											<h5 class="innertitle">
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
															<s:select cssClass="form-control " list="salutationList"
																name="salutation" tabindex="1">
															</s:select>

															<!-- <div id='addContactForm_salutation_errorloc'
																class="error_strings"></div> -->
														</div>
														<div class="col-lg-9 col-md-9 col-sm-9 col-xs-12">
															<s:textfield cssClass="form-control" name="contactperson"
																tabindex="2"></s:textfield>
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
															name="add.create.contact.nickname"></s:text>
													</label>
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:textfield cssClass="form-control" name="nickName"
														tabindex="4"></s:textfield>
													<!-- <div id='addContactForm_nickName_errorloc'
														class="error_strings"></div> -->
												</div>
											</div>

										</div>
									</div>




									<div class="row">
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<label class="control-label col-lg-4"> <s:text
															name="Account Name"></s:text></label>
												</div>

												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:select cssClass="form-control chzn-select"
														list="parentAccountList" headerKey="-1"
														headerValue="Select Account Name" name="accountName"
														tabindex="3">
													</s:select>

													<!-- <div id='addContactForm_accountName_errorloc'
														class="error_strings"></div> -->

												</div>
											</div>

										</div>
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<%-- --%>

											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<label class="control-label col-lg-4"> <s:text
															name="Title."></s:text>
													</label>
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:textfield cssClass="form-control" name="title"
														tabindex="4"></s:textfield>
													<!-- 	<div id='addContactForm_title_errorloc'
														class="error_strings"></div> -->
												</div>
											</div>
										</div>
									</div>



									<div class="row">
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<%--  --%>
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
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<%----%>
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<label class="control-label col-lg-4"><s:text
															name="DOB"></s:text> </label>
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:textfield cssClass="form-control" name="dob"
														tabindex="6" id="dp3" readonly="true"></s:textfield>
													<div id='addContactForm_dob_errorloc' class="error_strings"></div>
												</div>
											</div>
										</div>
									</div>



									<div class="row">
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<label class="control-label col-lg-4"><s:text
															name="add.create.lead.phone" /></label>
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<div class="row">
														<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"
															style="padding-right: 0px;">
															<s:textfield cssClass="form-control"
																name="phoneNumberIsd"
																placeholder="%{getText('project.placeholder.isd')}"
																tabindex="26"></s:textfield>
															<div id='addCreatedLeadForm_phoneNumberIsd_errorloc'
																class="error_strings"></div>
															<div id='addCreatedLeadForm_phoneNumberStd_errorloc'
																class="error_strings"></div>
															<div id='addCreatedLeadForm_phoneNumber_errorloc'
																class="error_strings"></div>
														</div>
														<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"
															style="padding-right: 0; padding-left: 0;">
															<s:textfield cssClass="form-control"
																name="phoneNumberStd" tabindex="27"
																placeholder="%{getText('project.placeholder.std')}"></s:textfield>

														</div>
														<div class="col-lg-5 col-md-5 col-sm-5 col-xs-5"
															style="padding-right: 0; padding-left: 0px; width: 46%">

															<s:textfield name="phoneNumber" cssClass="form-control"
																placeholder="%{getText('project.placeholder.phonenumber')}"
																tabindex="28" />

														</div>
													</div>
												</div>
											</div>
										</div>

										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<label class="control-label col-lg-4"><s:text
															name="add.create.lead.mobile" /></label>
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<div class="row">
														<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"
															style="padding-right: 0px;">
															<s:textfield cssClass="form-control" name="mobileNum1Isd"
																tabindex="29"
																placeholder="%{getText('project.placeholder.isd')}"></s:textfield>
															<div id='addCreatedLeadForm_mobileNo_errorloc'
																class="error_strings"></div>
															<div id='addCreatedLeadForm_mobileNoIsd_errorloc'
																class="error_strings"></div>
														</div>
														<div class="col-lg-9 col-md-9 col-sm-9 col-xs-9"
															style="padding-right: 0; padding-left: 0px; width: 71%">

															<s:textfield name="mobileNum1" cssClass="form-control"
																tabindex="30"
																placeholder="%{getText('project.placeholder.mobilenumber')}" />

														</div>
													</div>
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
													<label class="control-label col-lg-4"><s:text
															name="add.create.contact.referredby"></s:text> </label>
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
															name="Department."></s:text></label>
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:textfield cssClass="form-control" name="department"
														tabindex="10"></s:textfield>
													<div id='addContactForm_emailId_errorloc'
														class="error_strings"></div>
												</div>
											</div>
										</div>
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<label class="control-label col-lg-4"><s:text
															name="Reports To"></s:text> </label>
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:select cssClass="form-control chzn-select"
														list="reportsToList" headerKey="-1"
														headerValue="Reports To" name="reportsTo" tabindex="5">

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
															name="Lead source"></s:text> </label>
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:select list="leadSourceList" name="leadSource"
														headerKey="-1" headerValue="Select Lead source"
														cssClass="form-control chzn-select"></s:select>
													<div id='addContactForm_leadSoruce_errorloc'
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
															name="Assigned To"></s:text> </label>
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:select list="{'1'}" name="assignedTo" headerKey="-1"
														headerValue="Select Assigned To "
														cssClass="form-control chzn-select"></s:select>
													<div id='addContactForm_assignedTo_errorloc'
														class="error_strings"></div>
												</div>
											</div>
										</div>
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">

											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<label class="control-label col-lg-4"><s:text
															name="Reference."></s:text></label>
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:checkbox name="reference"></s:checkbox>
												</div>
											</div>
										</div>
									</div>

									<div class="row">
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<label class="control-label col-lg-4"><s:text
															name="Do Not Call"></s:text></label>
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:checkbox name="doNotCall"></s:checkbox>
												</div>
											</div>
										</div>
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">

											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<label class="control-label col-lg-4"><s:text
															name="Notify Owner"></s:text></label>
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:checkbox name="notifyOwner"></s:checkbox>
												</div>
											</div>
										</div>
									</div>

									<div class="row">
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<label class="control-label col-lg-4"><s:text
															name="SLA Name"></s:text></label>
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:select list="{'1'}" name="slaName" headerKey="-1"
														headerValue="Select SLA Name"
														cssClass="form-control chzn-select"></s:select>
													<div id='addContactForm_assignedTo_errorloc'
														class="error_strings"></div>
												</div>
											</div>
										</div>
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">

											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<label class="control-label col-lg-4"><s:text
															name="Email Opt Out"></s:text></label>
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:checkbox name="emailOptOut"></s:checkbox>
												</div>
											</div>
										</div>
									</div>

									<div class="row" style="margin-top: 20px;">
										<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
											<h5 class="innertitle">
												<s:text name="Customer Center Details"></s:text>
											</h5>
											<hr style="margin-top: -5px">
										</div>
									</div>


									<div class="row">
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<label class="control-label col-lg-4"> <s:text
															name="Customer Center User"></s:text>
													</label>
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:checkbox name="customerCenterUser"></s:checkbox>


												</div>
											</div>
										</div>
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<label class="control-label col-lg-4"><s:text
															name="Support Start date"></s:text> </label>
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:textfield cssClass="form-control"
														name="supportStartDate" tabindex="13" id="dp5"
														readonly="true"></s:textfield>
													<div id='addContactForm_supportStartDate_errorloc'
														class="error_strings"></div>
												</div>
											</div>
										</div>
									</div>



									<div class="row">

										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
			5									<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<label class="control-label col-lg-4"> <s:text
															name="Support End Date"></s:text>
													</label>
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:textfield cssClass="form-control" name="supportEndDate"
														tabindex="14" id="dp2" readonly="true"></s:textfield>
													<div id='addContactForm_supportEndDate_errorloc'
														class="error_strings"></div>
												</div>
											</div>
										</div>

										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12"></div>
									</div>



									<div class="row" style="margin-top: 20px;">
										<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
											<h5 class="innertitle">
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
															name="add.create.lead.adress.line1"></s:text>
													</label>
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:textfield cssClass="form-control"
														name="homeContAddLine1" tabindex="12"></s:textfield>
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
													<s:textfield cssClass="form-control"
														name="homeContAddLine2" tabindex="13"></s:textfield>
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
													<s:textfield cssClass="form-control" name="homeContCity"
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
													<s:textfield cssClass="form-control" name="homeContState"
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
														list="countryList" name="homeContCountry" headerKey="1"
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
													<s:textfield cssClass="form-control" name="homeContZipcode"
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
													<label class="control-label col-lg-4"><s:text
															name="Phone" /></label>
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<div class="row">
														<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"
															style="padding-right: 0px;">
															<s:textfield cssClass="form-control"
																name="homeContPhoneNumIsd"
																placeholder="%{getText('project.placeholder.isd')}"
																tabindex="26"></s:textfield>
															<div id='addCreatedLeadForm_phoneIsd_errorloc'
																class="error_strings"></div>
															<div id='addCreatedLeadForm_phoneStd_errorloc'
																class="error_strings"></div>
															<div id='addCreatedLeadForm_phone_errorloc'
																class="error_strings"></div>
														</div>
														<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"
															style="padding-right: 0; padding-left: 0;">
															<s:textfield cssClass="form-control"
																name="homeContPhoneNumStd" tabindex="27"
																placeholder="%{getText('project.placeholder.std')}"></s:textfield>

														</div>
														<div class="col-lg-5 col-md-5 col-sm-5 col-xs-5"
															style="padding-right: 0; padding-left: 0px; width: 46%">

															<s:textfield name="homeContPhoneNum"
																cssClass="form-control"
																placeholder="%{getText('project.placeholder.phonenumber')}"
																tabindex="28" />

														</div>
													</div>
												</div>
											</div>
										</div>

										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<label class="control-label col-lg-4"><s:text
															name="Mobile No" /></label>
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<div class="row">
														<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"
															style="padding-right: 0px;">
															<s:textfield cssClass="form-control"
																name="homeContMobileNumIsd" tabindex="29"
																placeholder="%{getText('project.placeholder.isd')}"></s:textfield>
															<div id='addCreatedLeadForm_homeContactMobile_errorloc'
																class="error_strings"></div>
															<div
																id='addCreatedLeadForm_homeContactMobileIsd_errorloc'
																class="error_strings"></div>
														</div>
														<div class="col-lg-9 col-md-9 col-sm-9 col-xs-9"
															style="padding-right: 0; padding-left: 0px; width: 71%">

															<s:textfield name="homeContMobileNum"
																cssClass="form-control" tabindex="30"
																placeholder="%{getText('project.placeholder.mobilenumber')}" />

														</div>
													</div>
												</div>
											</div>
										</div>
									</div>

									<div class="row">
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<label class="control-label col-lg-4"> <s:text
															name="Primary Email ID"></s:text>
													</label>
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:textfield cssClass="form-control" name="homeContEmailId"
														tabindex="20"></s:textfield>
													<div id='addContactForm_homeContactEmailID_errorloc'
														class="error_strings"></div>
												</div>
											</div>
										</div>
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<label class="control-label col-lg-4"> <s:text
															name="Alternate Email ID"></s:text>
													</label>
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:textfield cssClass="form-control"
														name="homeContAlternateEmailId" tabindex="20"></s:textfield>
													<div id='addContactForm_homeAlternateEmailID_errorloc'
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
															name="add.create.lead.fax" /></label>
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<div class="row">
														<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"
															style="padding-right: 0px;">
															<s:textfield cssClass="form-control"
																name="homeContFaxNumIsd" tabindex="33"
																placeholder="%{getText('project.placeholder.isd')}"></s:textfield>

															<div id='addCreatedLeadForm_homeContactFaxIsd_errorloc'
																class="error_strings"></div>
															<div id='addCreatedLeadForm_homeContactFaxStd_errorloc'
																class="error_strings"></div>
															<div id='addCreatedLeadForm_homeContactFax_errorloc'
																class="error_strings"></div>
														</div>
														<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"
															style="padding-right: 0; padding-left: 0;">
															<s:textfield cssClass="form-control"
																name="homeContFaxnumStd" tabindex="34"
																placeholder="%{getText('project.placeholder.std')}"></s:textfield>

														</div>
														<div class="col-lg-5 col-md-5 col-sm-5 col-xs-5"
															style="padding-right: 0; padding-left: 0px; width: 46%">

															<s:textfield name="homeContFaxNum"
																cssClass="form-control" tabindex="35"
																placeholder="%{getText('project.placeholder.faxnumber')}" />

														</div>
													</div>
												</div>
											</div>
										</div>

										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<label class="control-label col-lg-4"> <s:text
															name="Home Website"></s:text>
													</label>
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:textfield cssClass="form-control" name="homewebsite"
														tabindex="20"></s:textfield>
													<div id='addContactForm_homeWebsite_errorloc'
														class="error_strings"></div>
												</div>
											</div>
										</div>
									</div>


									<div class="row" style="margin-top: 20px;">
										<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
											<h5 class="innertitle">
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
															name="add.create.lead.adress.line1"></s:text></label>
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:textfield cssClass="form-control"
														name="workContAddLine1" tabindex="22"></s:textfield>
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
														name="workContAddLine2" tabindex="23"></s:textfield>
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
													<s:textfield cssClass="form-control" name="workContCity"
														tabindex="24"></s:textfield>
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
													<s:textfield cssClass="form-control" name="workContState"
														tabindex="25"></s:textfield>
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
													<s:select name="workContCountry"
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
													<s:textfield cssClass="form-control" name="workContZipcode"
														tabindex="27"></s:textfield>
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
													<label class="control-label col-lg-4"><s:text
															name="add.create.lead.phone" /></label>
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<div class="row">
														<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"
															style="padding-right: 0px;">
															<s:textfield cssClass="form-control"
																name="workContPhoneIsd"
																placeholder="%{getText('project.placeholder.isd')}"
																tabindex="26"></s:textfield>
															<div id='addCreatedLeadForm_workContactPhoneIsd_errorloc'
																class="error_strings"></div>
															<div id='addCreatedLeadForm_workContactPhoneStd_errorloc'
																class="error_strings"></div>
															<div id='addCreatedLeadForm_workContactPhone_errorloc'
																class="error_strings"></div>
														</div>
														<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"
															style="padding-right: 0; padding-left: 0;">
															<s:textfield cssClass="form-control"
																name="workContPhoneStd" tabindex="27"
																placeholder="%{getText('project.placeholder.std')}"></s:textfield>

														</div>
														<div class="col-lg-5 col-md-5 col-sm-5 col-xs-5"
															style="padding-right: 0; padding-left: 0px; width: 46%">

															<s:textfield name="workContPhoneNum"
																cssClass="form-control"
																placeholder="%{getText('project.placeholder.phonenumber')}"
																tabindex="28" />

														</div>
													</div>
												</div>
											</div>
										</div>

										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<label class="control-label col-lg-4"><s:text
															name="add.create.lead.mobile" /></label>
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<div class="row">
														<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"
															style="padding-right: 0px;">
															<s:textfield cssClass="form-control"
																name="workContMobileNumIsd" tabindex="29"
																placeholder="%{getText('project.placeholder.isd')}"></s:textfield>
															<div id='addCreatedLeadForm_workContactMobile_errorloc'
																class="error_strings"></div>
															<div
																id='addCreatedLeadForm_workContactMobileIsd_errorloc'
																class="error_strings"></div>
														</div>
														<div class="col-lg-9 col-md-9 col-sm-9 col-xs-9"
															style="padding-right: 0; padding-left: 0px; width: 71%">

															<s:textfield name="workContMobileNum"
																cssClass="form-control" tabindex="30"
																placeholder="%{getText('project.placeholder.mobilenumber')}" />

														</div>
													</div>
												</div>
											</div>
										</div>
									</div>

									<div class="row">
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<label class="control-label col-lg-4"><s:text
															name="Primary Email ID"></s:text> </label>
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:textfield cssClass="form-control" name="workContEmailId"
														tabindex="30"></s:textfield>
													<div id='addContactForm_workContactEmailId_errorloc'
														class="error_strings"></div>
												</div>

											</div>
										</div>
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<label class="control-label col-lg-4"><s:text
															name="Alternate Email ID"></s:text> </label>
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:textfield cssClass="form-control"
														name="workContAlternateEmailId" tabindex="30"></s:textfield>
													<div id='addContactForm_workAlternate Email ID_errorloc'
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
															name="add.create.lead.fax" /></label>
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<div class="row">
														<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"
															style="padding-right: 0px;">
															<s:textfield cssClass="form-control"
																name="workContFaxNumIsd" tabindex="33"
																placeholder="%{getText('project.placeholder.isd')}"></s:textfield>

															<div id='addCreatedLeadForm_workContactFaxIsd_errorloc'
																class="error_strings"></div>
															<div id='addCreatedLeadForm_workContactFaxStd_errorloc'
																class="error_strings"></div>
															<div id='addCreatedLeadForm_workContactFax_errorloc'
																class="error_strings"></div>
														</div>
														<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"
															style="padding-right: 0; padding-left: 0;">
															<s:textfield cssClass="form-control"
																name="workContFaxNumStd" tabindex="34"
																placeholder="%{getText('project.placeholder.std')}"></s:textfield>

														</div>
														<div class="col-lg-5 col-md-5 col-sm-5 col-xs-5"
															style="padding-right: 0; padding-left: 0px; width: 46%">

															<s:textfield name="workContFaxNum"
																cssClass="form-control" tabindex="35"
																placeholder="%{getText('project.placeholder.faxnumber')}" />

														</div>
													</div>
												</div>
											</div>
										</div>

										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<label class="control-label col-lg-4"><s:text
															name="Work Website"></s:text> </label>
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:textfield cssClass="form-control" name="workWebsite"
														tabindex="30"></s:textfield>
													<div id='addContactForm_workWebsite_errorloc'
														class="error_strings"></div>
												</div>

											</div>
										</div>
									</div>

									<div class="row" style="margin-top: 20px;">
										<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
											<h5 class="innertitle">
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
																	name="myAccount.user.profile.profile.image"></s:text> </label>
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
										<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"
											align="center">
											<a href="leadDashboard.action" data-toggle="tooltip"
												data-original-title="Cancel"
												class="btn btn-default btnheight"><i
												class="fa fa-caret-square-o-left fontawesomeht"></i> <s:text
													name="project.form.button.cancel"></s:text></a> <a
												href="addCreatedLead.action" data-toggle="tooltip"
												data-original-title="Reset"
												class="btn btn-success btnheight"><i
												class="fa fa-refresh "></i> <s:text
													name="project.form.button.reset"></s:text></a>
											<button type="submit" data-toggle="tooltip"
												data-original-title="Save" class="btn btn-primary btnheight">
												<i class="fa fa-check"></i>
												<s:text name="project.form.button.save"></s:text>
											</button>

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
		frmvalidator.addValidation("salutation", "dontselect=8",
				"Select Salutation");

		frmvalidator.addValidation("contactperson", "maxlen=50",
				"Contact Person  Should Be 50 Characters"); 

	frmvalidator.addValidation("contactperson", "req",
				"Enter Contact Person Name");

		frmvalidator.addValidation("contactperson", "alpha",
				"Contact Person Name should be in characters");

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

		/* frmvalidator.addValidation("referredBy", "req", "Enter Referred By"); */

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
				.addValidation("country", "dontselect=-1", "Please Select Country"); 

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
				"Select Country"); 

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
				"Profile Description Should Be At Max 4000 Characters"); */
	</script>
</body>
</html>