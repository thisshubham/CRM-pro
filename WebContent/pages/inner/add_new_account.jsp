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
<script>
	function PopupCenter(pageURL, title, w, h) {
		var left = (screen.width / 2) - (w / 2);
		var top = (screen.height / 2) - (h / 2);
		var targetWin = window
				.open(
						pageURL,
						title,
						'toolbar=no, location=no, directories=no, status=no, menubar=no, scrollbars=no, resizable=no, copyhistory=no, width='
								+ w
								+ ', height='
								+ h
								+ ', top='
								+ top
								+ ', left=' + left);
	}
</script>
<body>
	<s:form name="addNewAccountForm" action="addNewAccountDetails"
		method="POST" class="form-horizontal" id="block-validate">
		<div id="content">
			<div class="outer">
				<div class="inner bg-light lter">

					<!--BEGIN INPUT TEXT FIELDS-->
					<div class="row">
						<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
							<ol class="breadcrumb" style="margin-top: 10px;">
								<li><a href="omiInnerDashboard.action"><i
										class="fa fa-home"></i></a></li>
								<li><a href="renderAccountsDashboard.action"><s:text
											name="Accounts"></s:text></a></li>
								<li class="active"><s:text name="Accounts Dashboard"></s:text></li>
								<li class="active"><s:text name="New Account"></s:text></li>
							</ol>
							<div class="box dark">
								<header>
								<div class="pull-left">
									<a class="icons" href="renderAccountsDashboard.action"
										data-toggle="tooltip"
										data-original-title="Back To Accounts DashBoard"
										style="color: black;"> <i class="fa fa-th-large"></i>
									</a>
									<h5>
										<s:text name="New Account" />
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
										<a href="renderAddNewAccount.action" data-toggle="tooltip"
											data-original-title="Refresh"
											class="btn btn-success btnheight"><i
											class="fa fa-refresh "></i></a> <a
											href="renderAcccountsDashboard.action" data-toggle="tooltip"
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
												<s:text name="Account Information" />
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
															<div id='addNewAccountForm_salutation_errorloc'
																class="error_strings"></div>
														</div>
														<div class="col-lg-9 col-md-9 col-sm-9 col-xs-12">
															<s:textfield type="text" name="accountOwner"
																cssClass="form-control" tabindex="2" />
															<div id='addNewAccountForm_accountOwner_errorloc'
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
													<div id='addNewAccountForm_accountName_errorloc'
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
														headerValue="Select Account Type" name="accountType"
														cssClass="form-control chzn-select" headerKey="-1"
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
													<div id='addNewAccountForm_noOfAssociates_errorloc'
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
													<div id='addNewAccountForm_annualRevenue_errorloc'
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
													<div id='addNewAccountForm_ratings_errorloc'
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
															<div id='addNewAccountForm_phoneIsd_errorloc'
																class="error_strings"></div>
															<div id='addNewAccountForm_phoneStd_errorloc'
																class="error_strings"></div>
															<div id='addNewAccountForm_phoneNo_errorloc'
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
															<div id='addNewAccountForm_mobileIsd_errorloc'
																class="error_strings"></div>
															<div id='addNewAccountForm_mobileNo_errorloc'
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
													<div id='addNewAccountForm_emailId_errorloc'
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
													<div class="input-group">
														<s:select cssClass="form-control chzn-select"
															name="parentAccount" list="parentAccountList"
															headerKey="0" headerValue="Self" tabindex="18" />
														<span class="input-group-btn">
															<button
																class="btn btn-metis-3 btnheight_chzselect btn-line"
																tabindex="19">
																<i class="fa fa-search"></i>
															</button>
														</span>
													</div>

													<div id='addNewAccountForm_parentAccount_errorloc'
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
													<div id='addNewAccountForm_emailId_errorloc'
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
														<div id='addNewAccountForm_slaName_errorloc'
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
															name="add.lead.email.optout" /> </label>
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:checkbox name="emailOptOut" tabindex="24"></s:checkbox>
												</div>
											</div>
										</div>
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12"></div>
									</div>

									<div class="row" style="margin-top: 20px;">
										<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
											<h5 class="innertitle">
												<s:text name="add.account.mailing.contact.info" />
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
																headerKey="-1" name="billingSalutation" tabindex="25" />
														</div>
														<div class="col-lg-9 col-md-9 col-sm-9 col-xs-12">

															<s:textfield type="text" name="billingContactPersone"
																cssClass="form-control" tabindex="26" />
															<div
																id='addNewAccountForm_billingContactPersone_errorloc'
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
														name="billingDesignation"
														cssClass="form-control chzn-select" tabindex="27" />
													<div id='addNewAccountForm_billingDesignation_errorloc'
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
														cssClass="form-control" tabindex="28" />
													<div id='addNewAccountForm_billingAddressLine1_errorloc'
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
														cssClass="form-control" tabindex="29" />
													<div id='addNewAccountForm_billingAddressLine2_errorloc'
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
														cssClass="form-control" tabindex="30" />
													<div id='addNewAccountForm_billingCity_errorloc'
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
														cssClass="form-control" tabindex="31" />
													<div id='addNewAccountForm_billingState_errorloc'
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
														tabindex="32" />
													<div id='addNewAccountForm_billingCountry_errorloc'
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
														cssClass="form-control" tabindex="33" />
													<div id='addNewAccountForm_billingZipcode_errorloc'
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
																name="billingPhoneNoIsd"
																placeholder="%{getText('project.placeholder.isd')}"
																tabindex="34"></s:textfield>
															<div id='addNewAccountForm_billingPhoneNoIsd_errorloc'
																class="error_strings"></div>
															<div id='addNewAccountForm_billingPhoneNoStd_errorloc'
																class="error_strings"></div>
															<div id='addNewAccountForm_billingPhoneNo_errorloc'
																class="error_strings"></div>
														</div>
														<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"
															style="padding-right: 0; padding-left: 0;">
															<s:textfield cssClass="form-control"
																name="billingPhoneNoStd" tabindex="35"
																placeholder="%{getText('project.placeholder.std')}"></s:textfield>
														</div>
														<div class="col-lg-5 col-md-5 col-sm-5 col-xs-5"
															style="padding-right: 0; padding-left: 0px; width: 46%">

															<s:textfield name="billingPhoneNo"
																cssClass="form-control"
																placeholder="%{getText('project.placeholder.phonenumber')}"
																tabindex="36" />

														</div>
													</div>
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
													<div class="row">
														<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"
															style="padding-right: 0px;">
															<s:textfield cssClass="form-control"
																name="billingMobileNoIsd" tabindex="37"
																placeholder="%{getText('project.placeholder.isd')}"></s:textfield>
															<div id='addNewAccountForm_billingMobileNoIsd_errorloc'
																class="error_strings"></div>
															<div id='addNewAccountForm_billingMobileNo_errorloc'
																class="error_strings"></div>
														</div>
														<div class="col-lg-9 col-md-9 col-sm-9 col-xs-9"
															style="padding-right: 0; padding-left: 0px; width: 71%">

															<s:textfield name="billingMobileNo"
																cssClass="form-control" tabindex="38"
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
															name="add.create.lead.primary.email.id" /></label>
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">

													<s:textfield type="text" name="billingPrimaryEmail"
														cssClass="form-control" tabindex="39" />
													<div id='addNewAccountForm_billingPrimaryEmail_errorloc'
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
														cssClass="form-control" tabindex="40" />
													<div id='addNewAccountForm_billingAlternateEmail_errorloc'
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
															<s:textfield cssClass="form-control" name="billingFaxIsd"
																placeholder="%{getText('project.placeholder.isd')}"
																tabindex="41"></s:textfield>
															<div id='addNewAccountForm_billingFaxIsd_errorloc'
																class="error_strings"></div>
															<div id='addNewAccountForm_billingFaxStd_errorloc'
																class="error_strings"></div>
															<div id='addNewAccountForm_billingFax_errorloc'
																class="error_strings"></div>
														</div>
														<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"
															style="padding-right: 0; padding-left: 0;">
															<s:textfield cssClass="form-control" name="billingFaxStd"
																tabindex="42"
																placeholder="%{getText('project.placeholder.std')}"></s:textfield>
														</div>
														<div class="col-lg-5 col-md-5 col-sm-5 col-xs-5"
															style="padding-right: 0; padding-left: 0px; width: 46%">

															<s:textfield name="billingFax" cssClass="form-control"
																placeholder="%{getText('project.placeholder.phonenumber')}"
																tabindex="43" />

														</div>
													</div>
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
														cssClass="form-control" tabindex="44" />
													<div id='addNewAccountForm_billingWebsite_errorloc'
														class="error_strings"></div>
												</div>

											</div>
										</div>
									</div>

									<div class="row" style="margin-top: 20px;">
										<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
											<h5 class="innertitle">
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
																name="shippingSalutation" tabindex="45" />
														</div>
														<div class="col-lg-9 col-md-9 col-sm-9 col-xs-12">
															<s:textfield type="text" name="shippingContactPersone"
																cssClass="form-control" tabindex="46" />
															<div
																id='addNewAccountForm_shippingContactPersone_errorloc'
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
														cssClass="form-control chzn-select" tabindex="47" />
													<div id='addNewAccountForm_shippingDesignation_errorloc'
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
														cssClass="form-control" tabindex="48" />
													<div id='addNewAccountForm_shippingAddressLine1_errorloc'
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
														cssClass="form-control" tabindex="49" />
													<div id='addNewAccountForm_shippingAddressLine2_errorloc'
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
														cssClass="form-control" tabindex="50" />
													<div id='addNewAccountForm_shippingCity_errorloc'
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
														cssClass="form-control" tabindex="51" />
													<div id='addNewAccountForm_shippingState_errorloc'
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
														tabindex="52" />
													<div id='addNewAccountForm_shippingCountry_errorloc'
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
														cssClass="form-control" tabindex="53" />
													<div id='addNewAccountForm_shippingZipcode_errorloc'
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
																name="shippingPhoneNoIsd"
																placeholder="%{getText('project.placeholder.isd')}"
																tabindex="54"></s:textfield>
															<div id='addNewAccountForm_shippingPhoneNoIsd_errorloc'
																class="error_strings"></div>
															<div id='addNewAccountForm_shippingPhoneNoStd_errorloc'
																class="error_strings"></div>
															<div id='addNewAccountForm_shippingPhoneNo_errorloc'
																class="error_strings"></div>
														</div>
														<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"
															style="padding-right: 0; padding-left: 0;">
															<s:textfield cssClass="form-control"
																name="shippingPhoneNoStd" tabindex="55"
																placeholder="%{getText('project.placeholder.std')}"></s:textfield>
														</div>
														<div class="col-lg-5 col-md-5 col-sm-5 col-xs-5"
															style="padding-right: 0; padding-left: 0px; width: 46%">
															<s:textfield name="shippingPhoneNo"
																cssClass="form-control"
																placeholder="%{getText('project.placeholder.phonenumber')}"
																tabindex="56" />
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
																name="shippingMobileNoIsd" tabindex="57"
																placeholder="%{getText('project.placeholder.isd')}"></s:textfield>
															<div id='addNewAccountForm_shippingMobileNoIsd_errorloc'
																class="error_strings"></div>
															<div id='addNewAccountForm_shippingMobileNo_errorloc'
																class="error_strings"></div>
														</div>
														<div class="col-lg-9 col-md-9 col-sm-9 col-xs-9"
															style="padding-right: 0; padding-left: 0px; width: 71%">
															<s:textfield name="shippingMobileNo"
																cssClass="form-control" tabindex="58"
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
															name="add.create.lead.primary.email.id" /></label>
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<!-- <input type="text" class="form-control"> -->
													<s:textfield type="text" name="shippingPrimaryEmail"
														cssClass="form-control" tabindex="59" />
													<div id='addNewAccountForm_shippingPrimaryEmail_errorloc'
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
														cssClass="form-control" tabindex="60" />
													<div id='addNewAccountForm_shippingAlternateEmail_errorloc'
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
																name="shippingFaxIsd"
																placeholder="%{getText('project.placeholder.isd')}"
																tabindex="61"></s:textfield>
															<div id='addNewAccountForm_shippingFaxIsd_errorloc'
																class="error_strings"></div>
															<div id='addNewAccountForm_shippingFaxStd_errorloc'
																class="error_strings"></div>
															<div id='addNewAccountForm_shippingFax_errorloc'
																class="error_strings"></div>
														</div>
														<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"
															style="padding-right: 0; padding-left: 0;">
															<s:textfield cssClass="form-control"
																name="shippingFaxStd" tabindex="62"
																placeholder="%{getText('project.placeholder.std')}"></s:textfield>
														</div>
														<div class="col-lg-5 col-md-5 col-sm-5 col-xs-5"
															style="padding-right: 0; padding-left: 0px; width: 46%">
															<s:textfield name="shippingFax" cssClass="form-control"
																placeholder="%{getText('project.placeholder.phonenumber')}"
																tabindex="63" />

														</div>
													</div>
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
														cssClass="form-control" tabindex="64" />
													<div id='addNewAccountForm_shippingWebsite_errorloc'
														class="error_strings"></div>
												</div>
											</div>
										</div>
									</div>

									<div class="row" style="margin-top: 20px;">
										<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
											<h5 class="innertitle">
												<s:text name="add.group.profile.description" />
											</h5>
											<hr style="margin-top: -5px">
										</div>
									</div>



									<div class="form-group">
										<div class="row" style="margin: 1% 2%;" id="data_grid">
											<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
												<s:textarea id="wysihtml5" cssClass="form-control" rows="10"
													tabindex="65" name="profileDescription" />
												<div id='addNewAccountForm_profileDescription_errorloc'
													class="error_strings"></div>

											</div>
										</div>
									</div>

									<hr style="margin-top: 20px">
									<div class="row">
										<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"
											align="center">

											<a href="renderAcccountsDashboard.action"
												data-toggle="tooltip" data-original-title="Cancel"
												class="btn btn-default btnheight"><i
												class="fa fa-caret-square-o-left fontawesomeht"></i> <s:text
													name="project.form.button.cancel"></s:text></a> <a
												href="renderAddNewAccount.action" data-toggle="tooltip"
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
					</div>
				</div>
			</div>
		</div>
	</s:form>
	<script>
		$(function() {
			Metis.formGeneral();
			Metis.formWysiwyg();
		});
	</script>
	<script src="outer/js/gen_validatorv4.js" type="text/javascript"></script>
	<script type="text/javascript">
		var frmvalidator = new Validator("addNewAccountForm");
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