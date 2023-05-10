<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="/struts-jquery-tags" prefix="sj"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style type="text/css">
.error_strings {
	color: red;
}
</style>
<body>

	<div id="content">
		<div class="outer">
			<div class="inner bg-light lter">
				<s:form class="form-horizontal" name="updateAccountInformation"
					action="updateAccountInformation">
					<!--BEGIN INPUT TEXT FIELDS-->
					<div class="row">
						<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
							<ol class="breadcrumb" style="margin-top: 10px;">
								<li><a href="omiInnerDashboard.action"><i
										class="fa fa-home"></i></a></li>
								<li><a href="renderAccountsDashboard.action"><s:text
											name="Accounts"></s:text></a></li>
								<li class="active"><s:text name="Accounts Dashboard"></s:text></li>
								<li class="active"><s:text name="Edit Account"></s:text></li>
							</ol>
							<div class="box">
								<header>
								<div class="pull-left">
									<a class="icons" href="renderAccountsDashboard.action"
										data-toggle="tooltip"
										data-original-title="Back To Accounts DashBoard"
										style="color: black;"> <i class="fa fa-th-large"></i>
									</a>
									<h5>
										<s:text name="Edit -Account Information" />
									</h5>
								</div>
								<div class="pull-right">
									<div class="btn-group">
										<a class="btn btn-default btnheight" data-toggle="tooltip"
											data-original-title="Help"><i class="fa fa-question"></i>
											<s:text name="project.form.button.help"></s:text></a>
										<button type="submit" data-toggle="tooltip"
											data-original-title="Save" class="btn btn-primary btnheight">
											<i class="fa fa-check"> </i>
											<s:text name="project.form.button.save"></s:text>
										</button>
										<a class="btn btn-info btnheight" data-toggle="tooltip"
											data-original-title="Convert"><i class="fa fa-random"></i>
											<s:text name="project.form.button.convert"></s:text></a> <a
											type="button" onclick="window.location.reload();"
											data-toggle="tooltip" data-original-title="Refresh"
											class="btn btn-success btnheight"><i
											class="fa fa-refresh "></i> </a> <a
											href="renderAccountClone.action"
											class="btn btn-warning btnheight" data-toggle="tooltip"
											data-original-title="Clone"><i class="fa fa-users"></i>&nbsp;<s:text
												name="project.form.button.clone"></s:text></a> <a
											href="populatePreviousAccount.action" data-toggle="tooltip"
											data-original-title="Previous" type="button"
											class="btn btn-default btnheight"><i
											class="fa fa-chevron-left fontawesomeht"></i></a> <a
											data-toggle="tooltip" data-original-title="Next"
											href="populateNextAccount.action"
											class="btn btn-default btnheight"><i
											class="fa fa-chevron-right fontawesomeht"></i></a> <a
											data-toggle="tooltip" data-original-title="Close"
											href="renderAcccountsDashboard.action"
											class="btn btn-danger btnheight"><i
											class="fa fa-times fontawesomeht"></i></a>
									</div>
								</div>
								</header>
								<div class="container-fluid" style="margin-top: 20PX;">

									<!-- nav bar-->
									<ul class="nav nav-tabs" role="tablist">
										<li role="presentation" class="active"><a
											href="populatAccountInformation.action?command=<s:property value="accountId"/>"
											style="background-color: #F9F9F9; color: gray;"><s:text
													name="Account Information" /></a></li>
										<li role="presentation"><a
											href="renderAccountSocialInformation.action"
											style="color: gray;"> <s:text name="Account Social" />
										</a></li>
										<!--end of nav bar-->
									</ul>
									<!-- info bar -->
									<p>
										<s:if test="hasActionErrors()">
											<div class="alert alert-danger" role="alert"
												style="margin-top: 25px; padding-bottom: 7px;">
												<div class="infoIcon">
													
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
									<!--end of info bar -->

									<div class="row" style="margin-top: 20px;">
										<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 "
											style="color: #CD0067;">
											<h5>
												<s:text name="add.group.heading.group.info" />
											</h5>
											<hr style="margin-top: -5px">
										</div>

									</div>


									<div class="row">
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<label for="text1" class="control-label col-lg-4">
														<s:text name="Account Owner" />
													</label>
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<div class="row">
														<div class="col-lg-3 col-md-3 col-sm-3 col-xs-5">
															<s:select list="salutationList" cssClass="form-control"
																name="salutation" tabindex="1" headerKey="1" />
															<div id='updateAccountInformation_salutation_errorloc'
																class="error_strings"></div>
														</div>
														<div class="col-lg-9 col-md-9 col-sm-9 col-xs-12">
															<s:textfield type="text" name="accountOwner"
																cssClass="form-control" tabindex="2" />
															<div id='updateAccountInformation_accountOwner_errorloc'
																class="error_strings"></div>
														</div>
													</div>
												</div>
											</div>
										</div>
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<label for="text1" class="control-label col-lg-4">
														<s:text name="Account Name" />
														<div class="star">*</div>
													</label>
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:textfield type="text" name="accountName"
														cssClass="form-control" tabindex="3" />
													<div id='updateAccountInformation_accountName_errorloc'
														class="error_strings"></div>
												</div>
											</div>
										</div>

									</div>
									<div class="row">
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<label for="text1" class="control-label col-lg-4">
														<s:text name="Account Type " />
													</label>
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:select list="accountTypeList"
														headerValue="Select Account Type" headerKey="-1"
														name="accountType" cssClass="form-control chzn-select"
														tabindex="4" />
												</div>
											</div>
										</div>

										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<label class="control-label col-lg-4"><s:text
															name="Company Type" /> </label>
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:select cssClass="form-control chzn-select" headerKey="1"
														name="ownershipType" list="companyTypeList" tabindex="5" />
												</div>
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<label class="control-label col-lg-4"><s:text
															name="Company Categeory" /> </label>
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:select list="companyCategoryList" headerKey="1"
														name="orgnisationCategory"
														cssClass="form-control chzn-select" tabindex="6" />
												</div>
											</div>
										</div>

										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<label class="control-label col-lg-4"><s:text
															name="Company Sector" /> </label>
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:select list="companySectorList" headerKey="1"
														name="orgnisationSector"
														cssClass="form-control chzn-select" tabindex="7" />
												</div>
											</div>
										</div>

									</div>

									<div class="row">
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<label class="control-label col-lg-4"><s:text
															name="add.create.lead.no.of.associate" /> </label>
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:textfield type="text" cssClass="form-control"
														tabindex="8" name="noOfAssociates"></s:textfield>
													<span class="input-group-btn"></span>
													<div id='updateAccountInformation_noOfAssociates_errorloc'
														class="error_strings"></div>
												</div>
											</div>
										</div>
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<label class="control-label col-lg-4"><s:text
															name="add.create.lead.annual.revneue" /> &nbsp; (&nbsp;<span
														class="fa fa-rupee "></span>&nbsp;)</label>
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<div class="input-group">
														<s:textfield type="text" name="annualRevenue"
															cssClass="form-control" tabindex="9" />
														<span class="input-group-btn">
															<button class="btn btn-metis-5 btn-line"
																style="height: 34px" tabindex="10"
																onClick="PopupCenter('renderCalculator','RenderCalculator',260,350);">
																<i class="fa fa-calculator"></i>
															</button>
														</span>
													</div>
													<div id='updateAccountInformation_annualRevenue_errorloc'
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
															name="Rating" /></label>
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:select cssClass="form-control chzn-select"
														name="ratings" list="ratingList" headerKey="-1"
														headerValue="Select Rating" tabindex="11" />
													<div id='updateAccountInformation_ratings_errorloc'
														class="error_strings"></div>
												</div>
											</div>
										</div>
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<label class="control-label col-lg-4"><s:text
															name="add.create.lead.phone" /> </label>
												</div>

												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<div class="row">
														<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"
															style="padding-right: 0px;">
															<s:textfield cssClass="form-control" name="phoneIsd"
																placeholder="%{getText('project.placeholder.isd')}"
																tabindex="12"></s:textfield>
															<div id='updateAccountInformation_phoneIsd_errorloc'
																class="error_strings"></div>
															<div id='updateAccountInformation_phoneStd_errorloc'
																class="error_strings"></div>
															<div id='updateAccountInformation_phoneNo_errorloc'
																class="error_strings"></div>
														</div>
														<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"
															style="padding-right: 0; padding-left: 0;">
															<s:textfield cssClass="form-control" name="phoneStd"
																tabindex="13"
																placeholder="%{getText('project.placeholder.std')}"></s:textfield>
														</div>
														<div class="col-lg-5 col-md-5 col-sm-5 col-xs-5"
															style="padding-right: 0; padding-left: 0px; width: 46%">

															<s:textfield name="phoneNo" cssClass="form-control"
																placeholder="%{getText('project.placeholder.phonenumber')}"
																tabindex="14" />

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
															name="add.create.lead.mobile" />
														<div class="star">*</div> </label>
												</div>

												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<div class="row">
														<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"
															style="padding-right: 0px;">
															<s:textfield cssClass="form-control" name="mobileIsd"
																tabindex="15"
																placeholder="%{getText('project.placeholder.isd')}"></s:textfield>
															<div id='updateAccountInformation_mobileIsd_errorloc'
																class="error_strings"></div>
															<div id='updateAccountInformation_mobileNo_errorloc'
																class="error_strings"></div>
														</div>
														<div class="col-lg-9 col-md-9 col-sm-9 col-xs-9"
															style="padding-right: 0; padding-left: 0px; width: 71%">

															<s:textfield name="mobileNo" cssClass="form-control"
																tabindex="16"
																placeholder="%{getText('project.placeholder.mobilenumber')}" />

														</div>
													</div>
												</div>
											</div>
										</div>

										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<label class="control-label col-lg-4"><s:text
															name="user.login.E-MailID" /> </label>
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:textfield type="text" name="emailId"
														cssClass="form-control" tabindex="17" />
													<div id='updateAccountInformation_emailId_errorloc'
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
															name="Parent Account" /> </label>
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">

													<s:select cssClass="form-control chzn-select"
														name="parentAccount" list="parentAccountList"
														headerKey="0" headerValue="Self" tabindex="18" />
													<div id='updateAccountInformation_parentAccount_errorloc'
														class="error_strings"></div>
												</div>
											</div>
										</div>
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<label class="control-label col-lg-4"><s:text
															name="Assigned To" />
														<div class="star">*</div> </label>
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">

													<s:select cssClass="form-control chzn-select"
														name="assignTo" list="customerNameList" headerKey="-1"
														headerValue="Select Assigned To" tabindex="20" />
													<div id='updateAccountInformation_emailId_errorloc'
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
															name="SLA name" /> </label>
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<div class="input-group">
														<s:textfield type="text" name="slaName"
															cssClass="form-control" tabindex="21" />
														<div id='updateAccountInformation_slaName_errorloc'
															class="error_strings"></div>
														<span class="input-group-btn">
															<button class="btn btn-metis-5 btn-line"
																style="height: 34px" tabindex="22">
																<i class="fa fa-search"></i>
															</button>
														</span>
													</div>
												</div>
											</div>
										</div>
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<%--  --%>
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<label class="control-label col-lg-4"><s:text
															name="Status" /> </label>
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:select list="{'1'}" headerKey="-1" name="accountStatus"
														headerValue="Select Status" cssClass="form-control"></s:select>
													<div id='updateAccountInformation_accountStatus_errorloc'
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
															name="add.lead.email.optout" /> </label>
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:checkbox name="emailOptOut" tabindex="24"></s:checkbox>
												</div>
											</div>
										</div>
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<label class="control-label col-lg-4"><s:text
															name="Notify Owner" /> </label>
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:checkbox name="notifyOwner" tabindex="23"></s:checkbox>
												</div>
											</div>
										</div>
									</div>

									<div class="row">
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<label class="control-label col-lg-4"><s:text
															name="Created By" /> </label>
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:textfield name="createdBy" cssClass="form-control"
														disabled="true"></s:textfield>
												</div>
											</div>
										</div>
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<label class="control-label col-lg-4"><s:text
															name="Created Time" /> </label>
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:textfield name="createdDate" cssClass="form-control"
														disabled="true"></s:textfield>
												</div>
											</div>
										</div>
									</div>

									<div class="row" style="margin-top: 20px;">
										<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"
											style="color: #CD0067;">
											<h5>
												<s:text name="Account Mailling Information" />
											</h5>
											<hr style="margin-top: -5px">
										</div>
									</div>
									<div class="row">
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<label for="text1" class="control-label col-lg-4">
														<s:text name="add.group.contact.person" />


													</label>
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<div class="row">
														<div class="col-lg-3 col-md-3 col-sm-3 col-xs-5">

															<s:select list="salutationList" cssClass="form-control"
																headerKey="-1" name="billingSalutation" tabindex="14" />
														</div>
														<div class="col-lg-9 col-md-9 col-sm-9 col-xs-12">

															<s:textfield type="text" name="billingContactPersone"
																cssClass="form-control" tabindex="15" />
															<div
																id='updateAccountInformation_billingContactPersone_errorloc'
																class="error_strings"></div>
														</div>
													</div>
												</div>
											</div>
										</div>
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<label for="text1" class="control-label col-lg-4">
														<s:text name="add.group.designation" />

													</label>
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">

													<%-- <s:textfield type="text" name="billingDesignation"
															cssClass="form-control" /> --%>
													<s:select list="designationList" headerKey="1"
														name="billingDesignation"
														cssClass="form-control chzn-select" tabindex="16" />
													<div
														id='updateAccountInformation_billingDesignation_errorloc'
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
															name="add.create.lead.adress.line1" /> </label>
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">

													<s:textfield type="text" name="billingAddressLine1"
														cssClass="form-control" tabindex="17" />
													<div
														id='updateAccountInformation_billingAddressLine1_errorloc'
														class="error_strings"></div>
												</div>
											</div>
										</div>
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<label class="control-label col-lg-4"><s:text
															name="add.create.lead.adress.line2" /></label>
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">

													<s:textfield type="text" name="billingAddressLine2"
														cssClass="form-control" tabindex="18" />
													<div
														id='updateAccountInformation_billingAddressLine2_errorloc'
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
															name="add.create.lead.city" /></label>
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">

													<s:textfield type="text" name="billingCity"
														cssClass="form-control" tabindex="19" />
													<div id='updateAccountInformation_billingCity_errorloc'
														class="error_strings"></div>
												</div>
											</div>
										</div>
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<label class="control-label col-lg-4"><s:text
															name="add.create.lead.state" /></label>
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">

													<s:textfield type="text" name="billingState"
														cssClass="form-control" tabindex="20" />
													<div id='updateAccountInformation_billingState_errorloc'
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
															name="add.create.lead.country" /> </label>

												</div>

												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:select list="countryList" headerKey="1"
														name="billingCountry" cssClass="form-control chzn-select"
														tabindex="21" />
													<div id='updateAccountInformation_billingCountry_errorloc'
														class="error_strings"></div>
												</div>
											</div>
										</div>
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<label class="control-label col-lg-4"><s:text
															name="add.create.lead.zipcode" /></label>
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">

													<s:textfield type="text" name="billingZipcode"
														cssClass="form-control" tabindex="22" />
													<div id='updateAccountInformation_billingZipcode_errorloc'
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

													<s:textfield type="text" name="billingPhoneNo"
														cssClass="form-control" tabindex="23" />
													<div id='updateAccountInformation_billingPhoneNo_errorloc'
														class="error_strings"></div>
												</div>
											</div>
										</div>
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<label class="control-label col-lg-4"><s:text
															name="add.create.lead.mobile" /> </label>
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">

													<s:textfield type="text" name="billingMobileNo"
														cssClass="form-control" tabindex="24" />
													<div id='updateAccountInformation_billingMobileNo_errorloc'
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
															name="add.create.lead.primary.email.id" /></label>
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">

													<s:textfield type="text" name="billingPrimaryEmail"
														cssClass="form-control" tabindex="25" />
													<div
														id='updateAccountInformation_billingPrimaryEmail_errorloc'
														class="error_strings"></div>
												</div>
											</div>
										</div>
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<label class="control-label col-lg-4"><s:text
															name="add.create.lead.alternate.email.id" /></label>
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">

													<s:textfield type="text" name="billingAlternateEmail"
														cssClass="form-control" tabindex="26" />
													<div
														id='updateAccountInformation_billingAlternateEmail_errorloc'
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

													<s:textfield type="text" name="billingFax"
														cssClass="form-control" tabindex="27" />
													<div id='updateAccountInformation_billingFax_errorloc'
														class="error_strings"></div>
												</div>
											</div>
										</div>
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<label class="control-label col-lg-4"><s:text
															name="add.create.lead.website" /></label>
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">

													<s:textfield type="text" name="billingWebsite"
														cssClass="form-control" tabindex="28" />
													<div id='updateAccountInformation_billingWebsite_errorloc'
														class="error_strings"></div>
												</div>
											</div>
										</div>
									</div>

									<div class="row" style="margin-top: 20px;">
										<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 "
											style="color: #CD0067;">
											<h5>
												<s:text name="add.group.shipping.contact.info" />
											</h5>
											<hr style="margin-top: -5px">
										</div>
									</div>
									<div class="row">
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<label for="text1" class="control-label col-lg-4">
														<s:text name="add.group.contact.person" />

													</label>
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<div class="row">
														<div class="col-lg-3 col-md-3 col-sm-3 col-xs-5">
															<s:select list="salutationList" cssClass="form-control"
																name="shippingSalutation" tabindex="29" />
														</div>
														<div class="col-lg-9 col-md-9 col-sm-9 col-xs-12">
															<s:textfield type="text" name="shippingContactPersone"
																cssClass="form-control" tabindex="30" />
															<div
																id='updateAccountInformation_shippingContactPersone_errorloc'
																class="error_strings"></div>
														</div>
													</div>
												</div>
											</div>
										</div>
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<label for="text1" class="control-label col-lg-4">
														<s:text name="add.group.designation" />

													</label>
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:select list="designationList" headerKey="1"
														name="shippingDesignation"
														cssClass="form-control chzn-select" tabindex="31" />
													<div
														id='updateAccountInformation_shippingDesignation_errorloc'
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
															name="add.create.lead.adress.line1" /></label>
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">

													<s:textfield type="text" name="shippingAddressLine1"
														cssClass="form-control" tabindex="32" />
													<div
														id='updateAccountInformation_shippingAddressLine1_errorloc'
														class="error_strings"></div>
												</div>
											</div>
										</div>
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<label class="control-label col-lg-4"><s:text
															name="add.create.lead.adress.line2" /></label>
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">

													<s:textfield type="text" name="shippingAddressLine2"
														cssClass="form-control" tabindex="33" />
													<div
														id='updateAccountInformation_shippingAddressLine2_errorloc'
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
															name="add.create.lead.city" /></label>
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">

													<s:textfield type="text" name="shippingCity"
														cssClass="form-control" tabindex="34" />
													<div id='updateAccountInformation_shippingCity_errorloc'
														class="error_strings"></div>
												</div>
											</div>
										</div>
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<label class="control-label col-lg-4"><s:text
															name="add.create.lead.state" /></label>
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">

													<s:textfield type="text" name="shippingState"
														cssClass="form-control" tabindex="35" />
													<div id='updateAccountInformation_shippingState_errorloc'
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
															name="add.create.lead.country" /> </label>
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:select list="countryList" headerKey="1"
														name="shippingCountry" cssClass="form-control chzn-select"
														tabindex="36" />
													<div id='updateAccountInformation_shippingCountry_errorloc'
														class="error_strings"></div>
												</div>
											</div>
										</div>
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<label class="control-label col-lg-4"><s:text
															name="add.create.lead.zipcode" /></label>
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:textfield type="text" name="shippingZipcode"
														cssClass="form-control" tabindex="37" />
													<div id='updateAccountInformation_shippingZipcode_errorloc'
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

													<s:textfield type="text" name="shippingPhoneNo"
														cssClass="form-control" tabindex="38" />
													<div id='updateAccountInformation_shippingPhoneNo_errorloc'
														class="error_strings"></div>
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

													<s:textfield type="text" name="shippingMobileNo"
														cssClass="form-control" tabindex="39" />
													<div
														id='updateAccountInformation_shippingMobileNo_errorloc'
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
															name="add.create.lead.primary.email.id" /></label>
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<!-- <input type="text" class="form-control"> -->
													<s:textfield type="text" name="shippingPrimaryEmail"
														cssClass="form-control" tabindex="40" />
													<div
														id='updateAccountInformation_shippingPrimaryEmail_errorloc'
														class="error_strings"></div>
												</div>
											</div>
										</div>
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<label class="control-label col-lg-4"><s:text
															name="add.create.lead.alternate.email.id" /></label>
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">

													<s:textfield type="text" name="shippingAlternateEmail"
														cssClass="form-control" tabindex="41" />
													<div
														id='updateAccountInformation_shippingAlternateEmail_errorloc'
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
													<s:textfield type="text" name="shippingFax"
														cssClass="form-control" tabindex="42" />
													<div id='updateAccountInformation_shippingFax_errorloc'
														class="error_strings"></div>
												</div>
											</div>
										</div>
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<label class="control-label col-lg-4"><s:text
															name="add.create.lead.website" /></label>
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">

													<s:textfield type="text" name="shippingWebsite"
														cssClass="form-control" tabindex="43" />
													<div id='updateAccountInformation_shippingWebsite_errorloc'
														class="error_strings"></div>
												</div>
											</div>
										</div>
									</div>

									<div class="row" style="margin-top: 20px;">
										<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 "
											style="color: #CD0067;">
											<h5>
												<s:text name="add.group.profile.description" />
											</h5>
											<hr style="margin-top: -5px">
										</div>
									</div>



									<div class="form-group">
										<div class="row" style="margin: 1% 2%;" id="data_grid">
											<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">

												<!-- <textarea id="wysihtml5" class="form-control" rows="10"
														tabindex="41" name="profileDescription"> -->
												<s:textarea id="wysihtml5" cssClass="form-control" rows="10"
													tabindex="44" name="profileDescription" />
												<div
													id='updateAccountInformation_profileDescription_errorloc'
													class="error_strings"></div>


											</div>
										</div>
									</div>
									<hr style="margin-top: 20px">

									<div class="row">
										<div
											class="col-lg-4 col-md-4 col-sm-12 col-xs-12 col-md-offset-5">
											<a href="renderAcccountsDashboard.action"
												data-toggle="tooltip" data-original-title="Cancel"
												class="btn btn-default btnheight"><i
												class="fa fa-caret-square-o-left fontawesomeht"></i> <s:text
													name="project.form.button.cancel"></s:text></a> <a
												type="button" data-toggle="tooltip"
												onclick="window.location.reload();"
												data-original-title="Refresh"
												class="btn btn-success btnheight"><i
												class="fa fa-refresh "></i> <s:text
													name="project.form.button.reset"></s:text></a>
											<button type="submit" data-toggle="tooltip"
												data-original-title="Save" class="btn btn-primary btnheight">
												<i class="fa fa-check"></i>
												<s:text name="project.form.button.save"></s:text>
											</button>
										</div>
										<br>
									</div>
								</div>
							</div>
						</div>
				</s:form>
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
		var frmvalidator = new Validator("updateAccountInformation");
		frmvalidator.EnableOnPageErrorDisplay();
		frmvalidator.EnableMsgsTogether();

		//validation for group admin 
		frmvalidator.addValidation("accountOwner", "maxlen=100",
				"Account Owner Should Be 100 Characters");
		frmvalidator.addValidation("accountOwner", "minlen=3",
				"Account Owner Must Be 3 Characters");

		//validation for group name 
		frmvalidator.addValidation("accountName", "maxlen=50",
				"Group Name Should Be 50 Characters");
		frmvalidator.addValidation("accountName", "req", "Enter Account Name");
		frmvalidator.addValidation("accountName", "minlen=3",
				"Account Name Must Be 3 Characters");

		//Validation for Number of associates.
		frmvalidator.addValidation("noOfAssociates", "numeric",
				"Number Of Associate Must Be Digits");
		frmvalidator.addValidation("noOfAssociates", "maxlen=6",
				"No. Of Associates Should Be 6 Digits");

		//validation for mobile no. 
		frmvalidator.addValidation("mobileNo", "req", "Enter Mobile No");
		frmvalidator.addValidation("mobileNo", "maxlen=10",
				"Mobile No Should Be 10 Digits");
		frmvalidator.addValidation("mobileNo", "minlen=10",
				"Mobile No Must Be 10 Digits");
		frmvalidator.addValidation("mobileNo", "numeric",
				"Mobile No Must Be Digits");

		frmvalidator.addValidation("mobileIsd", "req", "Enter ISD No");
		frmvalidator.addValidation("mobileIsd", "maxlen=4",
				"ISD Should Be 4 Digits");
		frmvalidator.addValidation("mobileIsd", "minlen=2",
				"ISD Must Be 2 Digits");
		frmvalidator
				.addValidation("mobileIsd", "numeric", "ISD Must Be Digits");

		//Validation for Number of associates.
		frmvalidator.addValidation("phoneNo", "numeric",
				"Phone No Must Be Digits");
		frmvalidator.addValidation("phoneNo", "maxlen=10",
				"Phone No Should Be 10 Digits");
		frmvalidator.addValidation("phoneNo", "minlen=10",
				"Phone No Should Be 10 Digits");
		frmvalidator.addValidation("phoneIsd", "numeric", "ISD Must Be Digits");
		frmvalidator.addValidation("phoneStd", "numeric", "STD Must Be Digits");
		frmvalidator.addValidation("phoneIsd", "minlen=2",
				"ISD Must Be 2 Digits");
		frmvalidator.addValidation("phoneIsd", "maxlen=4",
				"ISD Should Be 4 Digits");
		frmvalidator.addValidation("phoneStd", "minlen=6",
				"STD Must Be 6 Digits");
		frmvalidator.addValidation("phoneStd", "maxlen=6",
				"STD Should Be 6 Digits");

		//Validation for email.
		frmvalidator.addValidation("emailId", "maxlen=100",
				"Email Id Should Be 100 Digits");
		frmvalidator.addValidation("emailId", "maxlen=3",
				"Email Id Must Be 3 Digits");
		frmvalidator.addValidation("emailId", "email", "Enter valid email id");

		//Validation for Annual Revenue 
		frmvalidator.addValidation("annualRevenue", "maxlen=10",
				"Annual Revenue Should Be 10 Digits");

		//validation for Contact Persone.
		frmvalidator.addValidation("billingContactPersone", "maxlen=100",
				"Contact Persone Should Be 100 Characters");
		frmvalidator.addValidation("billingContactPersone", "minlen=3",
				"Contact Persone Must Be 3 Characters");

		//validation for Address Line 1.
		frmvalidator.addValidation("billingAddressLine1", "maxlen=100",
				"Address Line1 Should Be 100 Characters");
		frmvalidator.addValidation("billingAddressLine1", "minlen=3",
				"Address Line1 Must Be 3 Characters");

		//validation for Address Line 2.
		frmvalidator.addValidation("billingAddressLine2", "maxlen=100",
				"Address Line 2 Should Be 100 Characters");
		frmvalidator.addValidation("billingAddressLine2", "minlen=3",
				"Address Line2 Must Be 3 Characters");

		//validation for City.
		frmvalidator.addValidation("billingCity", "maxlen=100",
				"City Should Be 100 Characters");
		frmvalidator.addValidation("billingCity", "minlen=3",
				"City Must Be 3 Characters");

		//validation for State.
		frmvalidator.addValidation("billingState", "maxlen=100",
				"State Should Be 100 Characters");
		frmvalidator.addValidation("billingState", "minlen=3",
				"State Should Be 3 Characters");

		//validation for "zipcode.
		frmvalidator.addValidation("billingZipcode", "maxlen=10",
				"Zipcode Should Be 10 Characters");
		frmvalidator.addValidation("billingZipcode", "minlen=10",
				"Zipcode Should Be 10 Characters");

		//validation for Primary Email Id. 
		frmvalidator.addValidation("billingPrimaryEmail", "email",
				"Enter Valid Email Address");
		frmvalidator.addValidation("billingPrimaryEmail", "maxlen=100",
				"Email Id Should Be 100 Characters");
		frmvalidator.addValidation("billingPrimaryEmail", "minlen=3",
				"Email Id Should Be 3 Characters");

		//validation for Alternate Email Id.
		frmvalidator.addValidation("billingAlternateEmail", "email",
				"Enter Valid Email Address");
		frmvalidator.addValidation("billingAlternateEmail", "maxlen=100",
				"Email Id Should Be 100 Characters");
		frmvalidator.addValidation("billingAlternateEmail", "minlen=3",
				"Email Id Should Be 3 Characters");

		//validation for Phone Number.
		frmvalidator.addValidation("billingPhoneNo", "maxlen=10",
				"Phone Number Should Be 10 Digits");
		frmvalidator.addValidation("billingPhoneNo", "minlen=10",
				"Phone Number Should Be 10 Digits");
		frmvalidator.addValidation("billingPhoneNo", "numeric",
				"Phone Number Must Be Digits");

		frmvalidator.addValidation("billingPhoneNoIsd", "maxlen=4",
				"ISD Should Be 4 Digits");
		frmvalidator.addValidation("billingPhoneNoIsd", "minlen=10",
				"ISD Should Be 10 Digits");
		frmvalidator.addValidation("billingPhoneNoIsd", "numeric",
				"ISD Must Be Digits");

		frmvalidator.addValidation("billingPhoneNoStd", "maxlen=6",
				"STD Should Be 6 Digits");
		frmvalidator.addValidation("billingPhoneNoStd", "minlen=6",
				"STD Should Be 6 Digits");
		frmvalidator.addValidation("billingPhoneNoStd", "numeric",
				"STD Must Be Digits");

		//validation for Mobile Number.
		frmvalidator.addValidation("billingMobileNo", "maxlen=10",
				"Mobile Number Should Be 10 Digits");
		frmvalidator.addValidation("billingMobileNo", "numeric",
				"Mobile Number Must Be Digits");
		frmvalidator.addValidation("billingMobileNo", "minlen=10",
				"Mobile Number Should Be 10 Digits");

		frmvalidator.addValidation("billingMobileNoIsd", "maxlen=4",
				"ISD Should Be 4 Digits");
		frmvalidator.addValidation("billingMobileNoIsd", "numeric",
				"ISD Must Be Digits");
		frmvalidator.addValidation("billingMobileNoIsd", "minlen=2",
				"ISD Should Be 2 Digits");

		//validation for Fax number.
		frmvalidator.addValidation("billingFax", "numeric",
				"Fax Number Must Be Digits");
		frmvalidator.addValidation("billingFax", "maxlen=10",
				"Fax Number Should Be 10 Digits");
		frmvalidator.addValidation("billingFax", "minlen=10",
				"Fax Number Should Be 10 Digits");

		frmvalidator.addValidation("billingFaxIsd", "numeric",
				"ISD Must Be Digits");
		frmvalidator.addValidation("billingFaxIsd", "maxlen=4",
				"ISD Should Be 4 Digits");
		frmvalidator.addValidation("billingFaxIsd", "minlen=2",
				"ISD Should Be 2 Digits");

		frmvalidator.addValidation("billingFaxStd", "numeric",
				"Fax Number Must Be Digits");
		frmvalidator.addValidation("billingFaxStd", "maxlen=6",
				"Fax Number Should Be 6 Digits");
		frmvalidator.addValidation("billingFaxStd", "minlen=6",
				"Fax Number Should Be 6 Digits");

		//Validation for Group Name. 
		frmvalidator.addValidation("billingWebsite", "maxlen=100",
				"Website Should Be 100 Characters");
		frmvalidator.addValidation("billingWebsite", "minlen=3",
				"Website Should Be 3 Characters");

		//validation for Address Line 1.
		frmvalidator.addValidation("shippingAddressLine1", "maxlen=100",
				"Address Line1 Should Be 100 Characters");
		frmvalidator.addValidation("shippingAddressLine1", "minlen=3",
				"Address Line1 Must Be 3 Characters");

		//validation for Address Line 2.
		frmvalidator.addValidation("shippingAddressLine2", "maxlen=100",
				"Address Line 2 Should Be 100 Characters");
		frmvalidator.addValidation("shippingAddressLine2", "minlen=3",
				"Address Line2 Must Be 3 Characters");

		//validation for City.
		frmvalidator.addValidation("shippingCity", "maxlen=100",
				"City Should Be 100 Characters");
		frmvalidator.addValidation("shippingCity", "minlen=3",
				"City Must Be 3 Characters");

		//validation for State.
		frmvalidator.addValidation("shippingState", "maxlen=100",
				"State Should Be 100 Characters");
		frmvalidator.addValidation("shippingState", "minlen=3",
				"State Should Be 3 Characters");

		//validation for "zipcode.
		frmvalidator.addValidation("shippingZipcode", "maxlen=10",
				"Zipcode Should Be 10 Characters");
		frmvalidator.addValidation("shippingZipcode", "minlen=10",
				"Zipcode Should Be 10 Characters");

		//validation for Primary Email Id. 
		frmvalidator.addValidation("shippingPrimaryEmail", "email",
				"Enter Valid Email Address");
		frmvalidator.addValidation("shippingPrimaryEmail", "maxlen=100",
				"Email Id Should Be 100 Characters");
		frmvalidator.addValidation("shippingPrimaryEmail", "minlen=3",
				"Email Id Should Be 3 Characters");

		//validation for Alternate Email Id.
		frmvalidator.addValidation("shippingAlternateEmail", "email",
				"Enter Valid Email Address");
		frmvalidator.addValidation("shippingAlternateEmail", "maxlen=100",
				"Email Id Should Be 100 Characters");
		frmvalidator.addValidation("shippingAlternateEmail", "minlen=3",
				"Email Id Should Be 3 Characters");

		//validation for Phone Number.
		frmvalidator.addValidation("shippingPhoneNo", "maxlen=10",
				"Phone Number Should Be 10 Digits");
		frmvalidator.addValidation("shippingPhoneNo", "minlen=10",
				"Phone Number Should Be 10 Digits");
		frmvalidator.addValidation("shippingPhoneNo", "numeric",
				"Phone Number Must Be Digits");

		frmvalidator.addValidation("shippingPhoneNoIsd", "maxlen=4",
				"ISD Should Be 4 Digits");
		frmvalidator.addValidation("shippingPhoneNoIsd", "minlen=10",
				"ISD Should Be 10 Digits");
		frmvalidator.addValidation("shippingPhoneNoIsd", "numeric",
				"ISD Must Be Digits");

		frmvalidator.addValidation("shippingPhoneNoStd", "maxlen=6",
				"STD Should Be 6 Digits");
		frmvalidator.addValidation("shippingPhoneNoStd", "minlen=6",
				"STD Should Be 6 Digits");
		frmvalidator.addValidation("shippingPhoneNoStd", "numeric",
				"STD Must Be Digits");

		//validation for Mobile Number.
		frmvalidator.addValidation("shippingMobileNo", "maxlen=10",
				"Mobile Number Should Be 10 Digits");
		frmvalidator.addValidation("shippingMobileNo", "numeric",
				"Mobile Number Must Be Digits");
		frmvalidator.addValidation("shippingMobileNo", "minlen=10",
				"Mobile Number Should Be 10 Digits");

		frmvalidator.addValidation("shippingMobileNoIsd", "maxlen=4",
				"ISD Should Be 4 Digits");
		frmvalidator.addValidation("shippingMobileNoIsd", "numeric",
				"ISD Must Be Digits");
		frmvalidator.addValidation("shippingMobileNoIsd", "minlen=2",
				"ISD Should Be 2 Digits");

		//validation for Fax number.
		frmvalidator.addValidation("shippingFax", "numeric",
				"Fax Number Must Be Digits");
		frmvalidator.addValidation("shippingFax", "maxlen=10",
				"Fax Number Should Be 10 Digits");
		frmvalidator.addValidation("shippingFax", "minlen=10",
				"Fax Number Should Be 10 Digits");

		frmvalidator.addValidation("shippingFaxIsd", "numeric",
				"ISD Must Be Digits");
		frmvalidator.addValidation("shippingFaxIsd", "maxlen=4",
				"ISD Should Be 4 Digits");
		frmvalidator.addValidation("shippingFaxIsd", "minlen=2",
				"ISD Should Be 2 Digits");

		frmvalidator.addValidation("shippingFaxStd", "numeric",
				"Fax Number Must Be Digits");
		frmvalidator.addValidation("shippingFaxStd", "maxlen=6",
				"Fax Number Should Be 6 Digits");
		frmvalidator.addValidation("shippingFaxStd", "minlen=6",
				"Fax Number Should Be 6 Digits");

		//Validation for Group Name. 
		frmvalidator.addValidation("shippingWebsite", "maxlen=100",
				"Website Should Be 100 Characters");
		frmvalidator.addValidation("shippingWebsite", "minlen=3",
				"Website Should Be 3 Characters");

		//Validation for Profile Description. 
		frmvalidator.addValidation("profileDescription", "maxlen=4000",
				"Profile Description Should Be 4000 Characters");
	</script>
</body>
</html>