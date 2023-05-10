





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
							<li><a href="SupportCases.action"> <s:text
										name="support.cases.add.new"></s:text></a></li>
							<li><a href="SupportCases.action"> <s:text
										name="Support.cases.pannel.heading"></s:text></a></li>
							<li><a href="SupportAddCases.action"> <s:text
										name="Support.cases.add.pannel.heading"></s:text></a></li>
						</ol>
						<s:form action="addSupportCases" name="addSupportCasesForm"
							id="block-validate">
							<div class="box dark">
								<header>
								<div class="pull-left">
									<a class="icons" href="SupportCases.action"
										data-toggle="tooltip"
										data-original-title="Back To Cases DashBoard"
										style="color: black;"> <i class="fa fa-th-large"></i>
									</a>
									<h5>
										<s:text name="Support.cases.add.pannel.heading" />
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
										<a href="SupportAddCases.action" data-toggle="tooltip"
											data-original-title="Refresh"
											class="btn btn-success btnheight"><i
											class="fa fa-refresh "></i></a> <a href="ticketDashboard.action"
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
													<s:text name="Support.cases.infobar" />
												</div>
											</div>
										</s:else>
									</p>
									<div class="row" style="margin-top: 20px;">
										<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
											<h5 class="innertitle">
												<s:text name="Support.cases.title" />
											</h5>
											<hr style="margin-top: -5px">
										</div>
									</div>
									<div class="form-group">
										<div class="row">
											<div class="col-xs-12 col-md-2 col-sm-2">
												<s:text name="Support.cases.case.title"></s:text>
												<font color="red">*</font>
											</div>
											<div class="col-xs-12 col-md-4 col-sm-4">
												<div id='addSupportCasesForm_caseTitle_errorloc'
													class="error_strings" style="color: red;"></div>
												<s:textfield name="caseTitle" cssClass="form-control"></s:textfield>
											</div>
											<div class="col-xs-12 col-md-2 col-sm-2">
												<s:text name="Support.cases.status"></s:text>
												<font color="red">*</font>
											</div>
											<div class="col-xs-12 col-md-4 col-sm-4"
												style="margin-top: 10px">
												<div id='addSupportCasesForm_status_errorloc'
													class="error_strings" style="color: red;"></div>
												<s:select cssClass="form-control chzn-select" headerKey="1"
													name="status" list="casesStatusList" tabindex="7"></s:select>
											</div>
										</div>
									</div>
									<div class="form-group">
										<div class="row">
											<div class="col-xs-12 col-md-2 col-sm-2"
												style="margin-top: 10px">
												<s:text name="Support.cases.priority"></s:text>
												<font color="red">*</font>
											</div>
											<div class="col-xs-12 col-md-4 col-sm-4"
												style="margin-top: 10px">
												<div id='addSupportCasesForm_priority_errorloc'
													class="error_strings" style="color: red;"></div>
												<s:select name="priority" list="casesPriorityList"
													cssClass="form-control chzn-select" headerKey="-1"
													tabindex="7">
												</s:select>
											</div>
											<div class="col-xs-12 col-md-2 col-sm-2"
												style="margin-top: 10px">
												<s:text name="Support.cases.contact.name"></s:text>
											</div>
											<div class="col-xs-12 col-md-4 col-sm-4"
												style="margin-top: 10px">
												<div id='addSupportCasesForm_contactName_errorloc'
													class="error_strings" style="color: red;"></div>
												<div class="input-group">
													<s:select cssClass="form-control chzn-select" tabindex="4"
														headerKey="1" name="contactName" id="contactName"
														list="casesContactNameList"></s:select>
													<span class="input-group-btn">
														
														<button type="button" tabindex="5"
															onclick="PopupCenter('renderAddContactName','renderAddContactName',800,600);"
															class="btn btn-metis-3 btnheight_chzselect btn-line">
															<i class="fa fa-plus-square "></i>
														</button>
													</span>
												</div>
											</div>
										</div>
									</div>
									<div class="form-group">
										<div class="row">
											<div class="col-xs-12 col-md-2 col-sm-2"
												style="margin-top: 10px">
												<s:text name="Support.cases.sla.name"></s:text>
											</div>
											<div class="col-xs-12 col-md-4 col-sm-4"
												style="margin-top: 10px">
												<div id='addSupportCasesForm_slaName_errorloc'
													class="error_strings" style="color: red;"></div>
												<div class="input-group">
													<s:select cssClass="form-control chzn-select" tabindex="4"
														headerKey="1" name="slaName" id="slaName"
														list="casesSlaNamelList"></s:select>
													<span class="input-group-btn">
														<button type="button" tabindex="5"
															onclick="PopupCenter('renderAddSlaName','RenderAddSlaName',800,600);"
															class="btn btn-metis-3 btnheight_chzselect btn-line">
															<i class="fa fa-plus-square "></i>
														</button>
													</span>
												</div>
											</div>
											<div class="col-xs-12 col-md-2 col-sm-2"
												style="margin-top: 10px">
												<s:text name="Support.cases.organization.name"></s:text>
											</div>
											<div class="col-xs-12 col-md-4 col-sm-4"
												style="margin-top: 10px">
												<div id='addSupportCasesForm_organiztionaName_errorloc'
													class="error_strings" style="color: red;"></div>
												<div class="input-group">
													<s:select cssClass="form-control chzn-select" tabindex="4"
														headerKey="-1" name="organiztionaName"
														id="organiztionaName" list="casesOrgnizationList"></s:select>
													<span class="input-group-btn">
													<a href="renderCompanySettings.action">
														<button type="button" tabindex="5"
															onclick="PopupCenter('renderAddOrgnization','renderAddOrgnization',800,600);"
															class="btn btn-metis-3 btnheight_chzselect btn-line">
															<i class="fa fa-plus-square "></i>
														</button></a>
													</span>
												</div>
											</div>
										</div>
									</div>
									<div class="form-group">
										<div class="row">
											<div class="col-xs-12 col-md-2 col-sm-2"
												style="margin-top: 10px">
												<s:text name="Support.cases.assign.to"></s:text>
											</div>
											<div class="col-xs-12 col-md-4 col-sm-4"
												style="margin-top: 10px">
												<div id='addSupportCasesForm_assignedTo_errorloc'
													class="error_strings" style="color: red;"></div>
												<s:select name="assignedTo"
													cssClass="form-control chzn-select"
													list="casesAssignedToList" tabindex="7">
												</s:select>
											</div>
											<div class="col-xs-12 col-md-2 col-sm-2"
												style="margin-top: 10px">
												<s:text name="Support.cases.team"></s:text>
											</div>
											<div class="col-xs-12 col-md-4 col-sm-4"
												style="margin-top: 10px">
												<div id='addSupportCasesForm_team_errorloc'
													class="error_strings" style="color: red;"></div>
												<s:select name="team" cssClass="form-control chzn-select"
													list="casesTeamList" headerKey="1" tabindex="7">
												</s:select>
											</div>
										</div>
									</div>
									<div class="form-group">
										<div class="row">
											<div class="col-xs-12 col-md-2 col-sm-2"
												style="margin-top: 10px">
												<s:text name="Support.cases.product.name"></s:text>
											</div>
											<div class="col-xs-12 col-md-4 col-sm-4"
												style="margin-top: 10px">
												<div id='addSupportCasesForm_productName_errorloc'
													class="error_strings" style="color: red;"></div>
												<div class="input-group">
													<s:select cssClass="form-control chzn-select" tabindex="4"
														headerKey="-1" name="productName" id="productName"
														list="casesProductNameList"></s:select>
													<span class="input-group-btn">
													
														<button type="button" tabindex="5"
																onclick="PopupCenter('renderAddCasesProductName','RenderAddCasesProductName',800,600);"
																class="btn btn-metis-3 btnheight_chzselect btn-line">
																<i class="fa fa-plus-square "></i>
															</button>
													</span>
												</div>
											</div>
											<div class="col-xs-12 col-md-2 col-sm-2"
												style="margin-top: 10px">
												<s:text name="Support.cases.channel"></s:text>
											</div>
											<div class="col-xs-12 col-md-4 col-sm-4"
												style="margin-top: 10px">
												<div id='addSupportCasesForm_channel_errorloc'
													class="error_strings" style="color: red;"></div>
												<s:select name="channel" list="casesChannelList"
													cssClass="form-control chzn-select" headerKey="1"
													tabindex="7">
												</s:select>
											</div>
										</div>
									</div>
									<div class="form-group">
										<div class="row">
											<div class="col-xs-12 col-md-2 col-sm-2"
												style="margin-top: 10px">
												<s:text name="Support.cases.resolution"></s:text>
											</div>
											<div class="col-xs-12 col-md-4 col-sm-4"
												style="margin-top: 10px">
												<div id='addSupportCasesForm_resolution_errorloc'
													class="error_strings" style="color: red;"></div>
												<s:textarea name="resolution" cssClass="form-control"></s:textarea>
											</div>
											<div class="col-xs-12 col-md-2 col-sm-2"
												style="margin-top: 10px">
												<s:text name="Support.cases.primary.email"></s:text>
											</div>
											<div class="col-xs-12 col-md-4 col-sm-4"
												style="margin-top: 10px">
												<div id='addSupportCasesForm_primaryEmail_errorloc'
													class="error_strings" style="color: red;"></div>
												<s:textfield name="primaryEmail" cssClass="form-control"></s:textfield>
											</div>
										</div>
									</div>
									<div class="form-group">
										<div class="row">
											<div class="col-xs-12 col-md-2 col-sm-2"
												style="margin-top: 10px">
												<s:text name="Support.cases.impact.type"></s:text>
											</div>
											<div class="col-xs-12 col-md-4 col-sm-4"
												style="margin-top: 10px">
												<div id='addSupportCasesForm_impactType_errorloc'
													class="error_strings" style="color: red;"></div>
												<s:select name="impactType" list="casesImpactTypelList"
													cssClass="form-control chzn-select" headerKey="1"
													tabindex="7">
												</s:select>
											</div>
											<div class="col-xs-12 col-md-2 col-sm-2"
												style="margin-top: 10px">
												<s:text name="Support.cases.impact.area"></s:text>
											</div>
											<div class="col-xs-12 col-md-4 col-sm-4"
												style="margin-top: 10px">
												<div id='addSupportCasesForm_impactArea_errorloc'
													class="error_strings" style="color: red;"></div>
												<s:select name="impactArea" list="casesImpactAreaList"
													cssClass="form-control chzn-select" headerKey="1"
													tabindex="7">
												</s:select>
											</div>
										</div>
									</div>
									<div class="form-group">
										<div class="row">
											<div class="col-xs-12 col-md-2 col-sm-2"
												style="margin-top: 10px">
												<s:text name="Support.cases.resolution.type"></s:text>
											</div>
											<div class="col-xs-12 col-md-4 col-sm-4"
												style="margin-top: 10px">
												<div id='addSupportCasesForm_resolutionType_errorloc'
													class="error_strings" style="color: red;"></div>
												<s:select name="resolutionType"
													list="casesResolutionTypeList"
													cssClass="form-control chzn-select" headerKey="1"
													tabindex="7">
												</s:select>
											</div>
											<div class="col-xs-12 col-md-2 col-sm-2"
												style="margin-top: 10px">
												<s:text name="Support.cases.deferred.date"></s:text>
											</div>
											<div class="col-xs-12 col-md-4 col-sm-4"
												style="margin-top: 10px">
												<div id='addSupportCasesForm_deferredDate_errorloc'
													class="error_strings" style="color: red;"></div>
												<s:textfield type="text" name="deferredDate"
													class="form-control" id="dp3" cssClass="form-control"
													tabindex="14" readonly="true" />
												<%-- <sj:datepicker name="deferredDate" changeMonth="true"
													changeYear="true" showAnim="slideDown" duration="fast"
													yearRange="1950:2050" showOn="focus" size="35%"
													timepicker="true" timepickerShowSecond="true"
													timepickerFormat="hh:mm:ss" displayFormat="yy-mm-dd"
													parentTheme="simple" cssClass="form-control" tabindex="7" />
 --%>
											</div>

										</div>
									</div>

									<hr style="margin-top: 20px">
									<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"
										align="center">
										<a href="ticketDashboard.action" data-toggle="tooltip"
											data-original-title="Cancel"
											class="btn btn-default btnheight"><i
											class="fa fa-caret-square-o-left fontawesomeht"></i> <s:text
												name="project.form.button.cancel"></s:text></a> <a
											href="renderAddNewTicket.action" data-toggle="tooltip"
											data-original-title="Reset" class="btn btn-success btnheight"><i
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
						</s:form>
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
		var formvalidation = new Validator("addSupportCasesForm");
		formvalidation.EnableOnPageErrorDisplay();
		formvalidation.EnableMsgsTogether();
		formvalidation.addValidation("caseTitle", "req",
				"Please Enter Case Title.");
		formvalidation
				.addValidation(
						"caseTitle",
						"minlen=3",
						"Please enter valid Case Title with at least 3 characters and at max 100 characters.");
		formvalidation
				.addValidation(
						"caseTitle",
						"maxlen=100",
						"Please enter valid Case Title with at least 3 characters and at max 100 characters.");
		formvalidation.addValidation("status", "dontselect=-1",
				"Select your status");
		formvalidation.addValidation("priority", "dontselect=-1",
				"Select your priority");
		formvalidation.addValidation("contactName", "dontselect=-1",
				"Select your contact name");
		formvalidation
				.addValidation("deferredDate", "req", "Select Your Date.");
		/* formvalidation.addValidation("contactName", "req",
				"Please Enter Contact Name.");
		formvalidation
				.addValidation("contactName", "regexp=^[A-Za-z]",
						"It should not start with special character and numeric digit.");
		formvalidation
				.addValidation(
						"contactName",
						"minlen=3",
						"Please enter valid Contact Name with at least 3 characters and at max 100 characters.");
		formvalidation
				.addValidation(
						"contactName",
						"maxlen=100",
						"Please enter valid Contact Name with at least 3 characters and at max 100 characters."); */
	</script>
</body>
</html>