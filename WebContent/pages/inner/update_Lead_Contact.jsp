<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="/struts-jquery-tags" prefix="sj"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="inner/assets/js/modal.js"></script>
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
							<li><a href="leadDashboard.action"><s:text
										name="navbar.lead"></s:text></a></li>
							<li class="active"><s:text name="navbar.lead.dashboard"></s:text></li>
							<li class="active"><s:text name="navbar.updatelead"></s:text></li>
						</ol>
						<div class="box">
							<header>
							<div class="pull-left">
								<a class="icons" href="leadDashboard.action"
									data-toggle="tooltip"
									data-original-title="Back To Leads DashBoard"> <i
									class="fa fa-th-large"></i>
								</a>

								<h5>
									<s:text name="update.Lead.header.contact" />
								</h5>
							</div>
							<s:form name="updateLeadContactForm" action="updateLeadContact">
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
											data-original-title="Conver"><i class="fa fa-random"></i>
											<s:text name="project.form.button.convert"></s:text></a>
										<button type="button" data-toggle="tooltip"
											data-original-title="Refresh"
											class="btn btn-success btnheight"
											onclick="window.location.reload();">
											<i class="fa fa-refresh "></i>
										</button>
										<a href="" data-toggle="tooltip" data-original-title="Clone"
											class="btn btn-warning btnheight"><i class="fa fa-users"></i>&nbsp;<s:text
												name="project.form.button.clone"></s:text></a> <a
											data-toggle="tooltip" data-original-title="Previous"
											type="button" class="btn btn-default btnheight"
											href="populatePreviousLeadContact.action"><i
											class="fa fa-chevron-left fontawesomeht"></i></a> <a
											data-toggle="tooltip" data-original-title="Next"
											href="populateNextLeadContact.action"
											class="btn btn-default btnheight"><i
											class="fa fa-chevron-right fontawesomeht"></i></a> <a
											data-toggle="tooltip" data-original-title="Close"
											href="leadDashboard.action" class="btn btn-danger btnheight"><i
											class="fa fa-times fontawesomeht"></i></a>
									</div>
								</div></header>

							<div class="container-fluid"
								style="margin-top: 15px; margin-bottom: 15px;">

								<!-- Nav tabs -->
								<ul class="nav nav-tabs" role="tablist">
									<li role="presentation"><a
										href="editLead.action?command=<s:property value='leadId'/>"
										style="color: Gray;"><s:text
												name="update.Lead.tabs.lead.information" /></a></li>
									<li role="presentation" class="active"><a
										href="populatLeadContactInfo.action?command=<s:property value='leadId'/>"
										style="background-color: #F9F9F9; color: Gray;"><s:text
												name="update.Lead.tabs.contact.information" /></a></li>
									<li role="presentation"><a
										href="renderAddLeadSocialInfo.action" style="color: Gray;"><s:text
												name="update.Lead.tabs.social.information" /></a></li>
									<li role="presentation"><a
										href="renderaddLeadFollowUp.action?command=
												<s:property value='leadId'/>"
										style="color: Gray;"><s:text
												name="update.Lead.tabs.follow.up" /></a></li>

								</ul>

								<!-- Tab panes -->
								<div id="content" style="background-color: #F9F9F9;">
									<div class="box" style="padding: 0px 25px 25px; margin: 0px">

										<p>
											<s:if test="hasActionErrors()">
												<div class="alert alert-danger" role="alert"
													style="margin-top: 25px; padding-bottom: 7px;">
													<div class="infoIcon">
														<!-- <i class="fa fa-times-circle "></i>&nbsp; -->
														<s:actionerror />
													</div>
												</div>
											</s:if>
											<s:elseif test="hasActionMessages()">
												<div class="alert alert-success" role="alert"
													style="margin-top: 25px; padding-bottom: 7px;">
													<div class="infoIcon">
														<!-- <i class="fa fa-check-circle "></i>&nbsp; -->
														<s:actionmessage />
													</div>
												</div>
											</s:elseif>
											<s:else>

												<div class="alert alert-info" role="alert"
													style="margin-top: 25px;">
													<div class="infoIcon">
														<i class="fa fa-info-circle "></i>&nbsp;
														<s:text name="add.create.lead.information.bar" />
													</div>
												</div>
											</s:else>
										</p>
										<div class="row">
											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
														<s:text name="add.create.lead.adress.line1" />
													</div>
													<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
														<s:textfield name="addressLine1" cssClass="form-control"
															tabindex="1" />
														<div id='updateLeadContactForm_addressLine1_errorloc'
															class="error_strings"></div>
													</div>
												</div>
											</div>
											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
														<s:text name="add.create.lead.adress.line2" />
													</div>
													<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
														<s:textfield name="addressLine2" cssClass="form-control"
															tabindex="2" />
														<div id='updateLeadContactForm_addressLine2_errorloc'
															class="error_strings"></div>
													</div>
												</div>
											</div>
										</div>



										<div class="row">
											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
														<s:text name="add.create.lead.city" />
													</div>
													<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
														<s:textfield name="city" cssClass="form-control"
															tabindex="3" />
														<div id='updateLeadContactForm_city_errorloc'
															class="error_strings"></div>
													</div>
												</div>
											</div>
											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
														<s:text name="add.create.lead.state" />
													</div>
													<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
														<s:textfield name="state" cssClass="form-control"
															tabindex="4" />
														<div id='updateLeadContactForm_state_errorloc'
															class="error_strings"></div>
													</div>
												</div>
											</div>
										</div>



										<div class="row">
											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
														<s:text name="add.create.lead.country" />
														<div class="star">*</div>
													</div>
													<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">

														<s:select list="countryList" name="country" headerKey="-1"
															cssClass="form-control chzn-select" tabindex="5" />
														<div id='updateLeadContactForm_country_errorloc'
															class="error_strings"></div>
													</div>
												</div>
											</div>
											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
														<s:text name="add.create.lead.zipcode" />

													</div>
													<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
														<s:textfield name="zipcode" cssClass="form-control"
															tabindex="6" />
														<div id='updateLeadContactForm_zipcode_errorloc'
															class="error_strings"></div>
													</div>
												</div>
											</div>
										</div>

										<div class="row">
											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
														<s:text name="add.create.lead.phone" />
													</div>
													<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
														<div class="row">
															<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"
																style="padding-right: 0px;">
																<s:textfield cssClass="form-control" name="phoneIsd"
																	placeholder="%{getText('project.placeholder.isd')}"
																	tabindex="7"></s:textfield>
																<div id='updateLeadContactForm_phoneIsd_errorloc'
																	class="error_strings"></div>
																<div id='updateLeadContactForm_phoneStd_errorloc'
																	class="error_strings"></div>
																<div id='updateLeadContactForm_phoneNo_errorloc'
																	class="error_strings"></div>
															</div>
															<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"
																style="padding-right: 0; padding-left: 0;">
																<s:textfield cssClass="form-control" name="phoneStd"
																	tabindex="8"
																	placeholder="%{getText('project.placeholder.std')}"></s:textfield>
															</div>
															<div class="col-lg-5 col-md-5 col-sm-5 col-xs-5"
																style="padding-right: 0; padding-left: 0px; width: 46%">

																<s:textfield name="phoneNo" cssClass="form-control"
																	placeholder="%{getText('project.placeholder.phonenumber')}"
																	tabindex="9" />

															</div>
														</div>
													</div>
												</div>
											</div>
											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
														<s:text name="add.create.lead.mobile" />
													</div>
													<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
														<div class="row">
															<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"
																style="padding-right: 0px;">
																<s:textfield cssClass="form-control" name="mobileIsd"
																	tabindex="10"
																	placeholder="%{getText('project.placeholder.isd')}"></s:textfield>
																<div id='updateLeadContactForm_mobileIsd_errorloc'
																	class="error_strings"></div>
																<div id='updateLeadContactForm_mobileNo_errorloc'
																	class="error_strings"></div>
															</div>
															<div class="col-lg-9 col-md-9 col-sm-9 col-xs-9"
																style="padding-right: 0; padding-left: 0px; width: 71%">

																<s:textfield name="mobileNo" cssClass="form-control"
																	tabindex="11"
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
														<s:text name="add.create.lead.primary.email.id" />

													</div>
													<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
														<s:textfield type="text" name="primaryEmailId"
															cssClass="form-control" tabindex="12" />
														<div id='updateLeadContactForm_primaryEmailId_errorloc'
															class="error_strings"></div>
													</div>
												</div>
											</div>
											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
														<s:text name="add.create.lead.alternate.email.id" />
													</div>
													<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
														<s:textfield type="text" name="alternateEmailId"
															cssClass="form-control" tabindex="13" />
														<div id='updateLeadContactForm_alternateEmailId_errorloc'
															class="error_strings"></div>
													</div>
												</div>
											</div>
										</div>



										<div class="row">
											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
														<s:text name="add.create.lead.fax" />
													</div>
													<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
														<div class="row">
															<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"
																style="padding-right: 0px;">
																<s:textfield cssClass="form-control" name="faxIsd"
																	tabindex="14"
																	placeholder="%{getText('project.placeholder.isd')}"></s:textfield>
																<div id='updateLeadContactForm_faxIsd_errorloc'
																	class="error_strings"></div>
																<div id='updateLeadContactForm_faxStd_errorloc'
																	class="error_strings"></div>
																<div id='updateLeadContactForm_fax_errorloc'
																	class="error_strings"></div>
															</div>
															<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"
																style="padding-right: 0; padding-left: 0;">
																<s:textfield cssClass="form-control" name="faxStd"
																	tabindex="15"
																	placeholder="%{getText('project.placeholder.std')}"></s:textfield>
															</div>
															<div class="col-lg-5 col-md-5 col-sm-5 col-xs-5"
																style="padding-right: 0; padding-left: 0px; width: 46%">
																<s:textfield name="fax" cssClass="form-control"
																	tabindex="16"
																	placeholder="%{getText('project.placeholder.faxnumber')}" />

															</div>
														</div>
													</div>
												</div>
											</div>
											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
														<s:text name="add.create.lead.website" />
													</div>
													<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
														<s:textfield type="text" name="website"
															cssClass="form-control" tabindex="17" />
														<div id='updateLeadContactForm_website_errorloc'
															class="error_strings"></div>
													</div>
												</div>
											</div>
										</div>


										<div class="row">
											<hr>
											<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"
												align="center" style="margin-top: 15px;">
												<a href="leadDashboard.action" data-toggle="tooltip"
													data-original-title="Cancel"
													class="btn btn-default btnheight"><i
													class="fa fa-caret-square-o-left fontawesomeht"></i> <s:text
														name="project.form.button.cancel"></s:text></a>
												<button type="button" data-toggle="tooltip"
													data-original-title="Reset"
													class="btn btn-success btnheight"
													onclick="window.location.reload();">
													<i class="fa fa-refresh "></i>
													<s:text name="project.form.button.reset"></s:text>
												</button>
												<button type="submit" data-toggle="tooltip"
													data-original-title="Save"
													class="btn btn-primary btnheight">
													<i class="fa fa-check"></i>
													<s:text name="project.form.button.save"></s:text>
												</button>
											</div>
										</div>
										<br>
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

	<script type="text/javascript">
		var frmvalidator = new Validator("updateLeadContactForm");
		frmvalidator.EnableOnPageErrorDisplay();
		frmvalidator.EnableMsgsTogether();

		//validation for Address Line 2.
		frmvalidator.addValidation("addressLine2", "maxlen=100",
				"Address Line2 Should Be 100 Characters");
		frmvalidator.addValidation("addressLine2", "minlen=3",
				"Address Line2 Should Be 3 Characters");

		//validation for City.
		frmvalidator.addValidation("city", "maxlen=100",
				"City Should Be 100 Characters");
		frmvalidator.addValidation("city", "minlen=3",
				"City Should Be 3 Characters");

		//validation for State.
		frmvalidator.addValidation("state", "maxlen=100",
				"State Should Be 100 Characters");
		frmvalidator.addValidation("state", "minlen=3",
				"State Should Be 3 Characters");

		//validation for Primary Email Id. 
		frmvalidator.addValidation("primaryEmailId", "email",
				"Enter Valid Email Address");
		frmvalidator.addValidation("primaryEmailId", "maxlen=100",
				"Email Id Should Be 100 Characters");
		frmvalidator.addValidation("primaryEmailId", "minlen=3",
				"Email Id Should Be 3 Characters");

		//validation for Alternate Email Id.
		frmvalidator.addValidation("alternateEmailId", "email",
				"Enter Valid Email Address");
		frmvalidator.addValidation("alternateEmailId", "maxlen=100",
				"Email Id Should Be 100 Characters");
		frmvalidator.addValidation("alternateEmailId", "minlen=3",
				"Email Id Should Be 3 Characters");

		//validation for Phone Number.
		frmvalidator.addValidation("phoneNo", "minlen=10",
				"Phone Number Should Be 10 Characters");
		frmvalidator.addValidation("phoneNo", "maxlen=10",
				"Phone Number Should Be 10 Digits");
		frmvalidator.addValidation("phoneNo", "numeric",
				"Phone Number Must Be Digits");
		frmvalidator.addValidation("phoneIsd", "minlen=2",
				"ISD Should Be 2 Characters");
		frmvalidator.addValidation("phoneIsd", "maxlen=4",
				"ISD Number Should Be 4 Digits");

		frmvalidator.addValidation("phoneStd", "minlen=6",
				"STD Should Be 6 Characters");
		frmvalidator.addValidation("phoneStd", "maxlen=6",
				"STD Should Be 6 Digits");
		frmvalidator.addValidation("phoneStd", "numeric", "STD Must Be Digits");

		//validation for Mobile Number.
		frmvalidator.addValidation("mobileNo", "minlen=10",
				"Mobile Number Should Be 10 Characters");
		frmvalidator.addValidation("mobileNo", "maxlen=10",
				"Mobile Number Should Be 10 Digits");
		frmvalidator.addValidation("mobileNo", "numeric",
				"Mobile Number Must Be Digits");
		frmvalidator.addValidation("mobileIsd", "minlen=3",
				"ISD Should Be 3 Characters");
		frmvalidator.addValidation("mobileIsd", "maxlen=6",
				"ISD Number Should Be 6 Digits");

		//validation for Fax number.
		frmvalidator.addValidation("fax", "minlen=10",
				"Fax Should Be 10 Characters");
		frmvalidator.addValidation("fax", "numeric",
				"Fax Number Must Be Digits");
		frmvalidator.addValidation("fax", "maxlen=10",
				"Fax Number Should Be 10 Digits");
		frmvalidator.addValidation("faxIsd", "minlen=2",
				"ISD Should Be 2 Characters");
		frmvalidator.addValidation("faxIsd", "maxlen=4",
				"ISD Number Should Be 4 Digits");
		frmvalidator.addValidation("faxStd", "minlen=6",
				"STD Should Be 3 Characters");
		frmvalidator.addValidation("faxStd", "numeric",
				"STD Number Must Be Digits");
		frmvalidator.addValidation("faxStd", "maxlen=6",
				"STD Number Should Be 6 Digits");

		frmvalidator.addValidation("zipcode", "minle=3",
				"Zipcode Should Be 3 Charecter");
		frmvalidator.addValidation("zipcode", "maxlen=100",
				"Zipcode Should Be 100 Charecter");

		//validation for Mobile Number.
		frmvalidator.addValidation("website", "minle=3",
				"Website Should Be 3 Charecter");
		//validation for Mobile Number.
		frmvalidator.addValidation("website", "maxlen=100",
				"Website Should Be 4000 Charecter");
	</script>
	<!-- Metis core scripts -->
	<script src="assets/js/core.min.js"></script>

	<!-- Metis demo scripts -->
	<script src="assets/js/app.min.js"></script>
	<script>
		$(function() {
			Metis.formGeneral();
			Metis.formWysiwyg();
		});
	</script>
	<script src="assets/js/style-switcher.min.js"></script>


</body>
</html>