<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="/struts-jquery-tags" prefix="sj"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
	<div id="content">
		<div class="outer">
			<div class="inner bg-light lter">

				<!--BEGIN INPUT TEXT FIELDS-->
				<div class="row">
					<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
						<ol class="breadcrumb" style="margin-top: 10px;">
							<li><a href="omiInnerDashboard.action"><i
									class="fa fa-home"></i></a></li>
							<li><a href="ActivitiesDashboard.action"><s:text
										name="navbar.activities"></s:text></a></li>
							<li class="active"><s:text name="navbar.activities.dashboard"></s:text></li>
							<li class="active"><s:text name="navbar.add.new.activities"></s:text></li>
						</ol>
						<s:form name="addCreatedLeadForm" action="addLeadDetail"
							class="form-horizontal" id="block-validate">
							<div class="box dark">
								<header>
								<div class="pull-left">
									<a class="icons" href="ActivitiesDashboard.action"
										data-toggle="tooltip"
										data-original-title="Back To Activities DashBoard"
										style="color: black;"> <i class="fa fa-th-large"></i>
									</a>
									<h5>
										<s:text name="add.create.Activities.heading" />
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
										<a href="AddnewActivities.action" data-toggle="tooltip"
											data-original-title="Refresh"
											class="btn btn-success btnheight"><i
											class="fa fa-refresh "></i></a> <a href="ActivitiesDashboard.action"
											data-toggle="tooltip" data-original-title="Close"
											class="btn btn-danger btnheight"><i
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
													<s:text name="add.create.Activities.information.bar" />
												</div>
											</div>
										</s:else>
									</p>



									<div class="row" style="margin-top: 20px;">
										<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
											<h5 class="innertitle">
												<s:text name="add.create.lead.lead.information" />
											</h5>
											<hr style="margin-top: -5px">
										</div>
									</div>


									<div class="row">
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="add.create.lead.company" />
													<div class="star">*</div>
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:textfield type="text" name="companyName"
														cssClass="form-control" tabindex="1" />
													<div id='addCreatedLeadForm_companyName_errorloc'
														class="error_strings"></diV>
												</div>
											</div>
										</div>



										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="add.create.lead.contactperson" />
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<div class="row">
														<div class="col-lg-3 col-md-3 col-sm-3 col-xs-5">
															<s:select name="salutation" tabindex="2"
																list="{1,2}" cssClass="form-control" />
															<div id='addCreatedLeadForm_salutation_errorloc'
																class="error_strings"></div>

														</div>
														<div class="col-lg-9 col-md-9 col-sm-9 col-xs-12">
															<s:textfield type="text" name="contactPerson"
																cssClass="form-control" tabindex="3" />
															<div id='addCreatedLeadForm_contactPerson_errorloc'
																class="error_strings"></div>
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
													<s:text name="add.create.lead.leadtitle" />
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<div class="input-group">
														<s:select cssClass="form-control chzn-select" tabindex="4"
															headerKey="1" name="leadTitle" id="leadTitle"
															list="{1,2}" />
														<span class="input-group-btn">
															<button type="button" tabindex="5"
																onclick="PopupCenter('renderAddLeadTitle','RenderAddLeadTitle',800,600);"
																class="btn btn-metis-3 btnheight_chzselect btn-line">
																<i class="fa fa-plus-square "></i>
															</button>
														</span>
													</div>
													<div id='addCreatedLeadForm_leadTitle_errorloc'
														class="error_strings"></div>
												</div>
											</div>
										</div>

										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="add.create.lead.company.type" />
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:select list="{1,2}" name="companyType" id=""
													
														cssClass="form-control chzn-select" tabindex="6"
														headerKey="1" />
													<div id='addCreatedLeadForm_companyType_errorloc'
														class="error_strings"></div>
												</div>
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="add.create.lead.company.category" />
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:select cssClass="form-control chzn-select"
														name="companyCategory" list="{1,2}"
														tabindex="7" />
													<div id='addCreatedLeadForm_companyCategory_errorloc'
														class="error_strings"></div>
												</div>
											</div>
										</div>
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="add.create.lead.company.sector" />
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:select cssClass="form-control chzn-select"
														list="{1,2}" name="companySector" tabindex="8" />
													<div id='addCreatedLeadForm_companySector_errorloc'
														class="error_strings"></div>
												</div>
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="add.create.lead.lead.source" />

												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:select name="leadSource" id=""
														cssClass="form-control chzn-select" list="{1,2}"
														headerValue="Select Lead Title" tabindex="9" />
													<div id='addCreatedLeadForm_leadSource_errorloc'
														class="error_strings"></div>

												</div>
											</div>
										</div>
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="add.create.lead.lead.sourceName" />
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:textfield cssClass="form-control" name="leadSourceName"
														tabindex="10"></s:textfield>
													<div id='addCreatedLeadForm_leadSourceName_errorloc'
														class="error_strings"></div>
												</div>
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="add.create.lead.no.of.associate" />
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">

													<s:textfield type="text" cssClass="form-control"
														name="noOfAssociate" tabindex="11"></s:textfield>
													<span class="input-group-btn"></span>
													<div id='addCreatedLeadForm_noOfAssociate_errorloc'
														class="error_strings"></div>
												</div>
											</div>
										</div>
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="add.create.lead.annual.revneue" />
													&nbsp; (&nbsp;<span class="fa fa-rupee "></span>&nbsp;)
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<div class="input-group">
														<s:textfield type="text" name="annualRevenue"
															cssClass="form-control" tabindex="12" />
														<div id='addCreatedLeadForm_annualRevenue_errorloc'
															class="error_strings"></div>
														<span class="input-group-btn"> <a type="button"
															class="btn btn-metis-5 btn-line" type="button"
															tabindex="13" data-toggle="modal" style="height: 34px"
															data-target="#calculater"> <i
																class="fa fa-calculator "></i>
														</a>
														</span>
													</div>
												</div>
											</div>
										</div>
									</div>



									<div class="row">
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="add.create.lead.lead.date" />
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:textfield type="text" name="leadDate"
														class="form-control" id="dp3" cssClass="form-control"
														tabindex="14" readonly="true" />
													<div id='addCreatedLeadForm_leadDate_errorloc'
														class="error_strings"></div>
												</div>
											</div>
										</div>
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="add.create.lead.expected.closing.date" />
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:textfield type="text" name="expectedClosingDate"
														cssClass="form-control" id="dp4" tabindex="15"
														readonly="true" />
													<div id='addCreatedLeadForm_expectedClosingDate_errorloc'
														class="error_strings"></div>
												</div>
											</div>
										</div>
									</div>


									<div class="row">
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="add.create.lead.lead.owner" />
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:select cssClass="form-control chzn-select"
														name="leadOwnerId" id="" list="{1,2}"
														headerKey="-1" headerValue="Select Lead Owner"
														tabindex="16" />
													<div id='addCreatedLeadForm_leadOwnerId_errorloc'
														class="error_strings"></div>
												</div>
											</div>
										</div>
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="add.lead.ratings" />
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:select cssClass="form-control chzn-select"
														name="ratings" list="{1,2}" headerKey="-1"
														headerValue="Select Rating" tabindex="17" />
													<div id='addCreatedLeadForm_ratings_errorloc'
														class="error_strings"></div>
												</div>
											</div>
										</div>
									</div>

									<div class="row">
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="add.lead.email.optout" />
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:checkbox name="emailOptOut" tabindex="18"></s:checkbox>
												</div>
											</div>
										</div>
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="view.lead.followup.lead.status" />
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:select cssClass="form-control chzn-select"
														name="leadStatus" list="{1,2}" headerKey="-1"
														tabindex="19" />
													<div id='addCreatedLeadForm_leadStatus_errorloc'
														class="error_strings"></div>
												</div>
											</div>
										</div>
									</div>




									<div class="row" style="margin-top: 20px;">
										<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
											<h5 class="innertitle">
												<s:text name="add.create.lead.contact.information" />
											</h5>
											<hr style="margin-top: -5px">
										</div>

									</div>


									<div class="row">

										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="add.create.lead.adress.line1" />
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:textfield type="text" name="addressLine1"
														cssClass="form-control" tabindex="20" />
													<div id='addCreatedLeadForm_addressLine1_errorloc'
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
													<s:textfield type="text" name="addressLine2"
														cssClass="form-control" tabindex="21" />
													<div id='addCreatedLeadForm_addressLine2_errorloc'
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
													<s:textfield type="text" name="city"
														cssClass="form-control" tabindex="22" />
													<div id='addCreatedLeadForm_city_errorloc'
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
													<s:textfield type="text" name="state"
														cssClass="form-control" tabindex="23" />
													<div id='addCreatedLeadForm_state_errorloc'
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

												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:select list="{1,2}" name="country" id="country"
														headerKey="-1" theme="css_xhtml" cssClass="form-control"
														tabindex="24" />
													<div id='addCreatedLeadForm_country_errorloc'
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
														tabindex="25" />
													<div id='addCreatedLeadForm_zipcode_errorloc'
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
																tabindex="26"></s:textfield>
															<div id='addCreatedLeadForm_phoneIsd_errorloc'
																class="error_strings"></div>
															<div id='addCreatedLeadForm_phoneStd_errorloc'
																class="error_strings"></div>
															<div id='addCreatedLeadForm_phoneNo_errorloc'
																class="error_strings"></div>
														</div>
														<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"
															style="padding-right: 0; padding-left: 0;">
															<s:textfield cssClass="form-control" name="phoneStd"
																tabindex="27"
																placeholder="%{getText('project.placeholder.std')}"></s:textfield>

														</div>
														<div class="col-lg-5 col-md-5 col-sm-5 col-xs-5"
															style="padding-right: 0; padding-left: 0px; width: 46%">

															<s:textfield name="phoneNo" cssClass="form-control"
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
													<s:text name="add.create.lead.mobile" />
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<div class="row">
														<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"
															style="padding-right: 0px;">
															<s:textfield cssClass="form-control" name="mobileIsd"
																tabindex="29"
																placeholder="%{getText('project.placeholder.isd')}"></s:textfield>
															<div id='addCreatedLeadForm_mobileNo_errorloc'
																class="error_strings"></div>
															<div id='addCreatedLeadForm_mobileIsd_errorloc'
																class="error_strings"></div>
														</div>
														<div class="col-lg-9 col-md-9 col-sm-9 col-xs-9"
															style="padding-right: 0; padding-left: 0px; width: 71%">

															<s:textfield name="mobileNo" cssClass="form-control"
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
													<s:text name="add.create.lead.primary.email.id" />
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:textfield type="text" name="primaryEmailId"
														cssClass="form-control" tabindex="31" />
													<div id='addCreatedLeadForm_primaryEmailId_errorloc'
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
													<s:textfield name="alternateEmailId"
														cssClass="form-control" tabindex="32" />
													<div id='addCreatedLeadForm_alternateEmailId_errorloc'
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
																tabindex="33"
																placeholder="%{getText('project.placeholder.isd')}"></s:textfield>
															<div id='addCreatedLeadForm_faxStd_errorloc'
																class="error_strings"></div>
															<div id='addCreatedLeadForm_faxIsd_errorloc'
																class="error_strings"></div>
															<div id='addCreatedLeadForm_fax_errorloc'
																class="error_strings"></div>
														</div>
														<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"
															style="padding-right: 0; padding-left: 0;">
															<s:textfield cssClass="form-control" name="faxStd"
																tabindex="34"
																placeholder="%{getText('project.placeholder.std')}"></s:textfield>

														</div>
														<div class="col-lg-5 col-md-5 col-sm-5 col-xs-5"
															style="padding-right: 0; padding-left: 0px; width: 46%">

															<s:textfield name="fax" cssClass="form-control"
																tabindex="35"
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
														cssClass="form-control" tabindex="36" />
													<div id='addCreatedLeadForm_website_errorloc'
														class="error_strings"></div>
												</div>
											</div>
										</div>
									</div>

									<div class="row" style="margin-top: 20px;">
										<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
											<h5 class="innertitle">
												<s:text name="add.create.lead.requirment" />
											</h5>
											<hr style="margin-top: -5px">
										</div>
									</div>

									<div class="form-group">
										<div class="row" style="margin: 1% 2%;" id="data_grid">
											<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
												<div id='addCreatedLeadForm_requirment_errorloc'
													class="error_strings"></div>
												<s:textarea id="wysihtml5" name="requirment"
													class="form-control" rows="10" tabindex="37">
												</s:textarea>
												<div id='addCreatedLeadForm_requirment_errorloc'
													class="error_strings"></div>
											</div>
										</div>
									</div>
									<hr style="margin-top: 20px">
									<div class="row">
										<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"
											align="center">
											<a href="ActivitiesDashboard.action" data-toggle="tooltip"
												data-original-title="Cancel"
												class="btn btn-default btnheight"><i
												class="fa fa-caret-square-o-left fontawesomeht"></i> <s:text
													name="project.form.button.cancel"></s:text></a> <a
												href="AddnewActivities.action" data-toggle="tooltip"
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

	<div class="modal fade" id="calculater" role="dialog">
		<div class="modal-dialog modal-sm">
			<div class="modal-content">
				<div class="modal-header"
					style="color: gray; background-color: #394B5E;">
					<button type="button" class="close" data-dismiss="modal"
						style="color: red; margin-top: -30px;">
						<h1>&times;</h1>
					</button>
					<h4 class="modal-title" style="color: gray;">Calculater</h4>
				</div>
				<div class="modal-body" style="color: gray;">
					<div class="row ">
						<div class="col-lg-12 col-md-10 col-xs-12 col-sm-10">

							<div class="col-lg-12 col-md-12 col-xs-12 col-sm-12"
								style="margin-bottom: 10px;">
								<!-- <input type="text" id="calculatortextid"
									style="height: 40px; width: 210px"
									autocomplete="off" /> -->
								<s:textfield id="calculatortextid" cssClass="form-control" />
							</div>

							<div class="col-lg-12 col-md-12 col-xs-12 col-sm-12">
								<button type="button" class="btn btn-defult"
									style="width: 50px; height: 50px; margin-left: 14px" id="idc"
									onclick="valueIdc()">
									<b>c</b>
								</button>
								<button type="button" class="btn btn-defult"
									style="width: 50px; height: 47px; padding-bottom: 0px;"
									id="idx2" onclick="valueIdxsquare()">
									<b><i>x<sup>2</sup></i></b>
								</button>
								<button type="button" class="btn btn-defult"
									style="width: 50px; height: 50px;" id="idroot"
									onclick="valueIdroot()">
									<b>√</b>
								</button>
								<button type="button" class="btn btn-defult"
									style="width: 50px; height: 50px;" id="idmod"
									onclick="valueIdmod()">
									<b>%</b>
								</button>
							</div>

							<br>
							<div class="col-lg-12 col-md-12 col-xs-12 col-sm-12">
								<button type="button" class="btn btn-defult"
									style="width: 50px; height: 50px; margin-left: 14px" id="id7"
									onclick="valueId7()">
									<b>7</b>
								</button>
								<button type="button" class="btn btn-defult"
									style="width: 50px; height: 50px;" id="id8"
									onclick="valueId8()">
									<b>8</b>
								</button>
								<button type="button" class="btn btn-defult"
									style="width: 50px; height: 50px;" id="id9"
									onclick="valueId9()">
									<b>9</b>
								</button>
								<button type="button" class="btn btn-defult"
									style="width: 50px; height: 50px;" id="iddiv"
									onclick="valueIddivision()">
									<b>/</b>
								</button>
							</div>

							<br>
							<div class="col-lg-12 col-md-12 col-xs-12 col-sm-12">
								<button type="button" class="btn btn-defult"
									style="width: 50px; height: 50px; margin-left: 14px" id="id4"
									onclick="valueId4()">
									<b>4</b>
								</button>
								<button type="button" class="btn btn-defult"
									style="width: 50px; height: 50px;" id="id5"
									onclick="valueId5()">
									<b>5</b>
								</button>
								<button type="button" class="btn btn-defult"
									style="width: 50px; height: 50px;" id="id6"
									onclick="valueId6()">
									<b>6</b>
								</button>
								<button type="button" class="btn btn-defult"
									style="width: 50px; height: 50px;" id="idx"
									onclick="valueIdmultiply()">
									<b>x</b>
								</button>
							</div>

							<div class="col-lg-12 col-md-12 col-xs-12 col-sm-12">
								<button type="button" class="btn btn-defult"
									style="width: 50px; height: 50px; margin-left: 14px" id="id1"
									onclick="valueId1()">
									<b>1</b>
								</button>
								<button type="button" class="btn btn-defult"
									style="width: 50px; height: 50px;" id="id2"
									onclick="valueId2()">
									<b>2</b>
								</button>
								<button type="button" class="btn btn-defult"
									style="width: 50px; height: 50px;" id="id3"
									onclick="valueId3()">
									<b>3</b>
								</button>
								<button type="button" class="btn btn-defult"
									style="width: 50px; height: 50px;" id="idminus"
									onclick="valueIdminus()">
									<b>-</b>
								</button>
							</div>
							<br> <br>
							<div class="col-lg-12 col-md-12 col-xs-12 col-sm-12">
								<button type="button" class="btn btn-defult"
									style="width: 50px; height: 50px; margin-left: 14px" id="id0"
									onclick="valueId0()">
									<b>0</b>
								</button>
								<button type="button" class="btn btn-defult"
									style="width: 50px; height: 50px;" id="iddot"
									onclick="valueIddot()">
									<b>.</b>
								</button>
								<button type="button" class="btn btn-defult"
									style="width: 50px; height: 50px;" id="idequal"
									onclick="valueIdequal()">
									<b>=</b>
								</button>
								<button type="button" class="btn btn-defult"
									style="width: 50px; height: 50px;" id="idplus"
									onclick="valueIdplus()">
									<b>+</b>
								</button>
							</div>

						</div>
					</div>
				</div>

			</div>
		</div>
	</div>
	<script src="pages/inner/assets/js/calculater.js"></script>
	<script>
		$(function() {
			Metis.formGeneral();
			Metis.formWysiwyg();
		});
	</script>
	<script src="/outer/js/gen_validatorv4.js" type="text/javascript"></script>
	<script type="text/javascript">
		var frmvalidator = new Validator("addCreatedLeadForm");
		frmvalidator.EnableOnPageErrorDisplay();
		frmvalidator.EnableMsgsTogether();

		//Validation for Company Name.
		frmvalidator.addValidation("companyName", "req", "Enter Company Name");
		frmvalidator.addValidation("companyName", "minlen=3",
				"Company Name Should Be 3 Characters");
		frmvalidator.addValidation("companyName", "maxlen=100",
				"Company Name Should Be 100 Characters");

		//Validation for Contact Person.
		frmvalidator.addValidation("contactPerson", "maxlen=100",
				"Contact Person Name Should Be 100 Characters");
		frmvalidator.addValidation("contactPerson", "minlen=3",
				"Contact Person Name Should Be 3 Characters");

		//Validation for Lead Source Name. 
		frmvalidator.addValidation("leadSourceName", "maxlen=100",
				"Lead Source Name Should Be 100 Characters");
		frmvalidator.addValidation("leadSourceName", "minlen=3",
				"Lead Source Should Be 3 Characters");

		//Validation for Number of associates.
		frmvalidator.addValidation("noOfAssociate", "numeric",
				"Number Of Associate Must Be Digits");
		frmvalidator.addValidation("noOfAssociate", "maxlen=6",
				"No. Of Associates Should Be 6 Digits");

		/* //Validation for Lead Date. 
		frmvalidator.addValidation("leadDate", "req", "Select Lead Date");

		//Validation for Lead Owner. 
		frmvalidator.addValidation("leadOwnerId", "dontselect=-1",
				"Select Lead Owner");*/

		//validation for Address Line 1.
		frmvalidator.addValidation("addressLine1", "maxlen=100",
				"Address Line1 Should Be 100 Characters");
		frmvalidator.addValidation("addressLine1", "minlen=3",
				"Address Line1 Should Be 3 Characters");

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

		frmvalidator.addValidation("website", "minle=3",
				"Website Should Be 3 Charecter");
		frmvalidator.addValidation("website", "maxlen=100",
				"Website Should Be 100 Charecter");

		frmvalidator.addValidation("zipcode", "minle=3",
				"Zipcode Should Be 3 Charecter");
		frmvalidator.addValidation("zipcode", "maxlen=100",
				"Zipcode Should Be 100 Charecter");

		//validation for Mobile Number.
		frmvalidator.addValidation("requirment", "maxlen=4000",
				"Requirement Should Be 4000 Charecter");

		//lead date and expected closing date difference validation 
		/* function DoCustomValidation() {
			var frm1 = document.forms["addCreatedLeadForm"];
			var ndate = frm1.leadDate.value;
			var ndate1 = frm1.expectedClosingDate.value;
			var d1 = new Date(ndate); //from date yyyy-MM-dd
			var d2 = new Date(ndate1); //to date yyyy-MM-dd 
			var Months = d2.getMonth() - d1.getMonth();
			var Years = d2.getFullYear() - d1.getFullYear();
			var Days = d2.getDate() - d1.getDate();
			Months = (d2.getMonth() + 12 * d2.getFullYear())
					- (d1.getMonth() + 12 * d1.getFullYear());

			var MonthOverflow = 0;

			if (Months - (Years * 12) < 0)
				MonthOverFlow = -1;
			else
				MonthOverFlow = 1;
			if (MonthOverFlow < 0)
				Years = Years - 1;
			Months = Months - (Years * 12);
			var LastDayOfMonth = new Date(d2.getFullYear(), d2.getMonth() + 1,
					0, 23, 59, 59);
			LastDayOfMonth = LastDayOfMonth.getDate();
			if (MonthOverFlow < 0 && (d1.getDate() > d2.getDate())) {
				Days = LastDayOfMonth + (d2.getDate() - d1.getDate()) - 1;
			} else
				Days = d2.getDate() - d1.getDate();
			if (Days < 0)
				Months = Months - 1;
			var l = new Date(d2.getFullYear(), d2.getMonth(), 0);
			var l1 = new Date(d1.getFullYear(), d1.getMonth() + 1, 0);
			if (Days < 0) {
				if (l1 > l)
					Days = l1.getDate() + Days;
				else
					Days = l.getDate() + Days;
			}
			if (d1 <= d2) {
				return true;
			} else {

				sfm_show_error_msg(
						"Expected Closing Date Should be Greater Than Lead Date",
						frm1.expectedClosingDate);
				return false;
			}
		}

		frmvalidator.setAddnlValidationFunction(DoCustomValidation); */
	</script>
</body>
</html>