<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="/struts-jquery-tags" prefix="sj"%>
<!DOCTYPE html>
<html>
<head>
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

<sj:head />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
							<li><a href="SupportCases.action"><s:text
										name="support.cases.add.new"></s:text></a></li>
							<li><a href="SupportCases.action"><s:text
										name="Support.cases.pannel.heading"></s:text></a></li>
							<li><a
								href="supportEditCases?command=<s:property value='casesId'/>"
								data-placement="bottom"><s:text
										name="Support.editCases.pannel.heading"></s:text></a></li>
						</ol>
						<div class="box">
							<header>
								<s:form action="supportUpdateCases" name="supportUpdateForm"
									id="supportUpdateForm" method="POST">

									<div class="pull-left">
										<a class="icons" href="SupportCases.action"
											data-toggle="tooltip"
											data-original-title="Back To Cases DashBoard"> <i
											class="fa fa-th-large"></i>
										</a>
										<h5>
											<s:text name="Support.editCases.pannel.heading" />
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
												<s:text name="project.form.button.convert"></s:text></a>
											<button type="button" data-toggle="tooltip"
												data-original-title="Refresh"
												class="btn btn-success btnheight"
												onclick="window.location.reload();">
												<i class="fa fa-refresh "></i>
											</button>
											<a
												href="supportEditCases.action?command=<s:property value='casesId'/>"
												class="btn btn-warning btnheight" data-toggle="tooltip"
												data-original-title="Clone"><i class="fa fa-users"></i>&nbsp;<s:text
													name="project.form.button.clone"></s:text></a> <a
												data-toggle="tooltip" data-original-title="Previous"
												type="button" class="btn btn-default btnheight"
												href="populatePreviousCases.action?command=<s:property value='casesId' />"><i
												class="fa fa-chevron-left fontawesomeht"></i></a> <a
												data-toggle="tooltip" data-original-title="Next"
												class="btn btn-default btnheight"
												href="populateNextCases.action?command=<s:property value='casesId' />"><i
												class="fa fa-chevron-right fontawesomeht"></i></a> <a
												data-toggle="tooltip" data-original-title="Close"
												href="SupportCases.action" class="btn btn-danger btnheight"><i
												class="fa fa-times fontawesomeht"></i></a>
										</div>
									</div>
							</header>
							<div id="content" style="background-color: #F9F9F9;">
								<div class="box" style="padding: 0px 25px 25px; margin: 0px">
									<p>
										<s:if test="hasActionErrors()">
											<div class="alert alert-danger" role="alert"
												style="margin-top: 25px; padding-bottom: 7px;">
												<div class="infoIcon">
													<!-- <i class="fa fa-times-circle ">&nbsp; 
															</i> -->
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
													<s:text name="Support.editCases.infobar"></s:text>
												</div>
											</div>
										</s:else>
									</p>
									<s:iterator value="supportCasesVO">
										<div class="row">
											<div class="col-xs-12 col-md-2 col-sm-2">
												<s:text name="Support.cases.case.title"></s:text>
												<font color="red">*</font>
											</div>
											<div class="col-xs-12 col-md-4 col-sm-4">
												<div id='supportUpdateForm_caseTitle_errorloc'
													class="error_strings" style="color: red;"></div>
												<s:textfield name="caseTitle" cssClass="form-control"></s:textfield>
											</div>
											<div class="col-xs-12 col-md-2 col-sm-2">
												<s:text name="Support.cases.status"></s:text>
												<font color="red">*</font>
											</div>
											<div class="col-xs-12 col-md-4 col-sm-4"
												style="margin-top: 10px">
												<div id='supportUpdateForm_status_errorloc'
													class="error_strings" style="color: red;"></div>
												<s:select name="status" list="casesStatusList"
													cssClass="form-control chzn-select" headerKey="1"
													tabindex="7">
												</s:select>
											</div>
										</div>
										<div class="row">
											<div class="col-xs-12 col-md-2 col-sm-2"
												style="margin-top: 10px">
												<s:text name="Support.cases.priority"></s:text>
												<font color="red">*</font>
											</div>
											<div class="col-xs-12 col-md-4 col-sm-4"
												style="margin-top: 10px">
												<div id='supportUpdateForm_priority_errorloc'
													class="error_strings" style="color: red;"></div>
												<s:select name="priority" list="casesPriorityList"
													cssClass="form-control chzn-select" headerKey="1"
													tabindex="7">
												</s:select>
											</div>
											<div class="col-xs-12 col-md-2 col-sm-2"
												style="margin-top: 10px">
												<s:text name="Support.cases.contact.name"></s:text>
												<font color="red">*</font>
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
															onclick="PopupCenter('renderAddContactName','RenderAddContactName',800,600);"
															class="btn btn-metis-3 btnheight_chzselect btn-line">
															<i class="fa fa-plus-square "></i>
														</button>
													</span>
												</div>
											</div>
										</div>

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
														headerKey="1" name="organiztionaName"
														id="organiztionaName" list="casesOrgnizationList"></s:select>
													<span class="input-group-btn">
														<button type="button" tabindex="5"
															onclick="PopupCenter('renderAddOrgnization','RenderAddOrgnization',800,600);"
															class="btn btn-metis-3 btnheight_chzselect btn-line">
															<i class="fa fa-plus-square "></i>
														</button>
													</span>
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-xs-12 col-md-2 col-sm-2"
												style="margin-top: 10px">
												<s:text name="Support.cases.assign.to"></s:text>
											</div>
											<div class="col-xs-12 col-md-4 col-sm-4"
												style="margin-top: 10px">
												<div id='supportUpdateForm_assignedTo_errorloc'
													class="error_strings" style="color: red;"></div>
												<s:select name="assignedTo"
													cssClass="form-control chzn-select"
													list="casesAssignedToList" headerKey="1" tabindex="7">
												</s:select>
											</div>
											<div class="col-xs-12 col-md-2 col-sm-2"
												style="margin-top: 10px">
												<s:text name="Support.cases.team"></s:text>
											</div>
											<div class="col-xs-12 col-md-4 col-sm-4"
												style="margin-top: 10px">
												<div id='supportUpdateForm_team_errorloc'
													class="error_strings" style="color: red;"></div>
												<s:select name="team" cssClass="form-control chzn-select"
													list="casesTeamList" headerKey="1" tabindex="7">
												</s:select>
											</div>
										</div>
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
														headerKey="1" name="productName" id="productName"
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
												<div id='supportUpdateForm_channel_errorloc'
													class="error_strings" style="color: red;"></div>
												<s:select name="channel" list="casesChannelList"
													cssClass="form-control chzn-select" headerKey="1"
													tabindex="7">
												</s:select>
											</div>
										</div>
										<div class="row">
											<div class="col-xs-12 col-md-2 col-sm-2"
												style="margin-top: 10px">
												<s:text name="Support.cases.resolution"></s:text>
											</div>
											<div class="col-xs-12 col-md-4 col-sm-4"
												style="margin-top: 10px">
												<div id='supportUpdateForm_resolution_errorloc'
													class="error_strings" style="color: red;"></div>
												<s:textarea name="resolution" cssClass="form-control"></s:textarea>
											</div>
											<div class="col-xs-12 col-md-2 col-sm-2"
												style="margin-top: 10px">
												<s:text name="Support.cases.primary.email"></s:text>
											</div>
											<div class="col-xs-12 col-md-4 col-sm-4"
												style="margin-top: 10px">
												<div id='supportUpdateForm_primaryEmail_errorloc'
													class="error_strings" style="color: red;"></div>
												<s:textfield name="primaryEmail" cssClass="form-control"></s:textfield>
											</div>
										</div>
										<div class="row">
											<div class="col-xs-12 col-md-2 col-sm-2"
												style="margin-top: 10px">
												<s:text name="Support.cases.impact.type"></s:text>
											</div>
											<div class="col-xs-12 col-md-4 col-sm-4"
												style="margin-top: 10px">
												<div id='supportUpdateForm_impactType_errorloc'
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
												<div id='supportUpdateForm_impactArea_errorloc'
													class="error_strings" style="color: red;"></div>
												<s:select name="impactArea" list="casesImpactAreaList"
													cssClass="form-control chzn-select" headerKey="-1"
													tabindex="7">
												</s:select>
											</div>
										</div>
										<div class="row">
											<div class="col-xs-12 col-md-2 col-sm-2"
												style="margin-top: 10px">
												<s:text name="Support.cases.resolution.type"></s:text>
											</div>
											<div class="col-xs-12 col-md-4 col-sm-4"
												style="margin-top: 10px">
												<div id='supportUpdateForm_resolutionType_errorloc'
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
												<div id='supportUpdateForm_deferredDate_errorloc'
													class="error_strings" style="color: red;"></div>
												<s:textfield type="text" name="deferredDate"
													class="form-control" id="dp3" cssClass="form-control"
													tabindex="14" readonly="true" />
												<%-- <sj:datepicker name="deferredDate" changeMonth="true"
														changeYear="true" showAnim="slideDown" duration="fast"
														yearRange="1950:2050" showOn="focus" size="35%"
														timepicker="true" timepickerShowSecond="true"
														timepickerFormat="hh:mm:ss" displayFormat="yy-mm-dd"
														parentTheme="simple" cssClass="form-control" tabindex="4" /> --%>
											</div>
										</div>
										<hr>
										<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"
											align="center">
											<a href="SupportCases.action" data-toggle="tooltip"
												data-original-title="Cancel"
												class="btn btn-default btnheight"><i
												class="fa fa-caret-square-o-left fontawesomeht"></i> <s:text
													name="project.form.button.cancel"></s:text></a> <a
												href="renderAddNewTicket.action" data-toggle="tooltip"
												data-original-title="Reset"
												class="btn btn-success btnheight"><i
												class="fa fa-refresh "></i> <s:text
													name="project.form.button.reset"></s:text></a>
											<button type="submit" data-toggle="tooltip"
												data-original-title="Save" class="btn btn-primary btnheight">
												<i class="fa fa-check"></i>
												<s:text name="project.form.button.save"></s:text>
											</button>
										</div><br>
									</s:iterator>
									</s:form>
								</div>
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
		var formvalidation = new Validator("supportUpdateForm");
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
	</script>
</body>
</html>