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
	<s:form name="updateLeadFollowUpForm" action="addLeadFollowUpDetails"
		method="POST">
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
										<s:text name="update.Lead.header.followup" />
									</h5>
								</div>
								<div class="pull-right">

									<div class="btn-group">
										<a class="btn btn-default btnheight" data-toggle="tooltip"
											data-original-title="Help"><i class="fa fa-question"></i>
											Help</a>
										<button type="submit" data-toggle="tooltip"
											data-original-title="Save" class="btn btn-primary btnheight">
											<i class="fa fa-check"></i>
											<s:text name="project.form.button.save"></s:text>
										</button>
										<a data-toggle="tooltip" data-original-title="Convert"
											class="btn btn-info btnheight"><i class="fa fa-question"></i>
											Convert</a> <a href="renderaddLeadFollowUp.action"
											data-toggle="tooltip" data-original-title="Refersh"
											type="button" class="btn btn-success btnheight"><i
											class="fa fa-refresh "></i></a> <a href="" data-toggle="tooltip"
											data-original-title="Clone" class="btn btn-warning btnheight"><i
											class="fa fa-users"></i>&nbsp;Clone</a> <a data-toggle="tooltip"
											data-original-title="Previous" type="button"
											class="btn btn-default btnheight" href="populatePreviouslead"><i
											class="fa fa-chevron-left fontawesomeht"></i></a> <a
											data-toggle="tooltip" data-original-title="Next"
											href="populateNextlead.action"
											class="btn btn-default btnheight"><i
											class="fa fa-chevron-right fontawesomeht"></i></a> <a
											data-toggle="tooltip" data-original-title="Close"
											href="leadDashboard.action" class="btn btn-danger btnheight"><i
											class="fa fa-times fontawesomeht"></i></a>
									</div>
								</div>
								</header>

								<div class="container-fluid"
									style="margin-top: 15px; margin-bottom: 15px;">

									<!-- Nav tabs -->
									<ul class="nav nav-tabs" role="tablist">
										<li role="presentation"><a
											href="editLead.action?command=<s:property value='leadId'/>"
											style="color: Gray;"><s:text
													name="update.Lead.tabs.lead.information" /></a></li>
										<li role="presentation"><a
											href="populatLeadContactInfo.action?command=<s:property value='leadId'/>"
											style="color: Gray;"><s:text
													name="update.Lead.tabs.contact.information" /></a></li>
										<li role="presentation"><a
											href="renderAddLeadSocialInfo.action" style="color: Gray;"><s:text
													name="update.Lead.tabs.social.information" /></a></li>
										<li role="presentation" class="active"><a
											href="renderaddLeadFollowUp.action?command=<s:property value='leadId'/>"
											style="color: Gray; background-color: #F9F9F9;"><s:text
													name="update.Lead.tabs.follow.up" /></a></li>

									</ul>


									<!-- Tab panes -->
									<div id="content">



										<!--BEGIN INPUT TEXT FIELDS-->
										<div id="content" style="background-color: #F9F9F9;">
											<div class="box" style="padding: 0px 25px 25px; margin: 0px">

												<p>
													<s:if test="hasActionErrors()">
														<div class="alert alert-danger" role="alert"
															style="margin-top: 0px; padding-bottom: 7px;">
															<div>
																<!-- <i class="fa fa-times-circle "></i>&nbsp; -->
																<s:actionerror />
															</div>
														</div>
													</s:if>
													<s:elseif test="hasActionMessages()">
														<div class="alert alert-success" role="alert"
															style="margin-top: 0px; padding-bottom: 7px;">
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
																<s:text name="update.Lead.Followup.followup.date" />
																<div class="star">*</div>
															</div>
															<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
																<s:textfield type="text" name="followUpDate"
																	class="form-control" id="dp3" cssClass="form-control"
																	tabindex="1" readonly="true" />
																<div id='updateLeadFollowUpForm_followUpDate_errorloc'
																	class="error_strings"></div>
															</div>
														</div>
													</div>

													<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
														<div class="row form-group">
															<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
																<s:text name="update.Lead.Followup.followup.status" />
																<div class="star">*</div>
															</div>
															<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
																<s:select list="leadStatusList" headerKey="-1"
																	headerValue="Select Follow Up Status"
																	cssClass="form-control chzn-select" tabindex="2"
																	name="followUpStatus" />
																<div id='updateLeadFollowUpForm_followUpStatus_errorloc'
																	class="error_strings"></div>
															</div>
														</div>
													</div>
												</div>

												<div class="row">
													<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
														<div class="row form-group">
															<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
																<s:text name="update.Lead.Followup.followup.by" />
																<div class="star">*</div>
															</div>
															<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
																<s:select list="customerNameList" headerKey="-1"
																	headerValue="Select Follow Up By"
																	cssClass="form-control chzn-select" tabindex="3"
																	name="followUpBy" />
																<div id='updateLeadFollowUpForm_followUpBy_errorloc'
																	class="error_strings"></div>
															</div>
														</div>
													</div>
													<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
														<div class="row form-group">
															<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
																<s:text name="update.Lead.Followup.comment" />
																<div class="star">*</div>
															</div>
															<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">

																<s:textarea name="followUpComment"
																	cssClass="form-control" rows="2" cols="30" tabindex="4"></s:textarea>
																<div
																	id='updateLeadFollowUpForm_followUpComment_errorloc'
																	class="error_strings"></div>
															</div>
														</div>
													</div>
												</div>



												<div class="row">
													<hr>
													<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"
														align="center">
														<a href="leadDashboard.action" data-toggle="tooltip"
															data-original-title="Cancel"
															class="btn btn-default btnheight"><i
															class="fa fa-caret-square-o-left fontawesomeht"></i> <s:text
																name="project.form.button.cancel"></s:text></a>
														<a href="renderaddLeadFollowUp.action"
															data-toggle="tooltip" data-original-title="Refersh"
															type="button" class="btn btn-success btnheight"><i
															class="fa fa-refresh "></i>
														<s:text name="project.form.button.reset"></s:text></a>
														<button type="submit" data-toggle="tooltip"
															data-original-title="Save"
															class="btn btn-primary btnheight">
															<i class="fa fa-check"></i>
															<s:text name="project.form.button.save"></s:text>
														</button>

													</div>
												</div>
												<br/>

												<div class="row" style="background-color: F8F8F8;">
													<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
														<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"
															id="dataTable">
															<div class="table-responsive">
																<table id="dataTable"
																	class="table table-bordered table-condensed table-hover table-striped">
																	<thead>
																		<tr id="myrow">
																			<th><s:text
																					name="update.Lead.Followup.followup.id" /></th>
																			<th><s:text
																					name="update.Lead.Followup.followup.date" /></th>
																			<th><s:text
																					name="update.Lead.Followup.followup.status" /></th>
																			<th><s:text
																					name="update.Lead.Followup.followup.by" /></th>
																			<th><s:text name="update.group.createdby" /></th>
																			<th style=""><s:text
																					name="update.Lead.Followup.comment" /></th>
																		</tr>
																	</thead>
																	<tbody>
																		<s:iterator value="leadFollowUpDetailsGrid">
																			<tr>
																				<td><s:property value="followUpId" /></td>
																				<td><s:property value="followUpDate" /></td>
																				<td><s:property value="followUpStatus" /></td>
																				<td><s:property value="followUpBy" /></td>
																				<td><s:property value="createdByName" /></td>
																				<td><s:property value="followUpComment" /></td>
																			</tr>
																		</s:iterator>
																	</tbody>
																</table>

															</div>
														</div>
													</div>
												</div>
											</div>

										</div>
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
	<script type="text/javascript">
		var frmvalidator = new Validator("updateLeadFollowUpForm");
		frmvalidator.EnableOnPageErrorDisplay();
		frmvalidator.EnableMsgsTogether();

		//validation for Follow Up Date.
		frmvalidator.addValidation("followUpDate", "req",
				"Enter Follow Up Date");

		//validation for Follow Up Status.
		frmvalidator.addValidation("followUpStatus", "dontselect=-1",
				"Select Follow Up Status");

		//validation for Follow Up By.
		frmvalidator.addValidation("followUpBy", "dontselect=-1",
				"Select Follow Up By");

		//validation for Follow Up Commecnt.
		frmvalidator.addValidation("followUpComment", "req",
				"Enter Follow Up Comment");

		frmvalidator.addValidation("followUpComment", "maxlen=400",
				"Maximum Length Of Comment Should Be 400 Character");
	</script>
</body>
</html>