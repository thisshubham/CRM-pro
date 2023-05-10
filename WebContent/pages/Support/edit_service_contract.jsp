<%@page import="com.bst.ckt.vo.ServiceContactVo"%>
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
							<li><a href="serviceContractDashboard.action"><s:text
										name="service.contract.dashboard.navbar"></s:text></a></li>
							<li><a href="serviceContractDashboard.action"><s:text
										name="service.contract.dashboard.panel.heading"></s:text></a></li>
							<li><a
								href="editServiceContract.action?command=<s:property value='serviceContactId' />"
								data-placement="bottom"><s:text
										name="edit.service.contract.pannel.heading"></s:text></a></li>
						</ol>
						<div class="box">
							<header> <s:form name="editServiceContract"
								action="updateServiceContract" method="POST">

								<div class="pull-left">
									<a class="icons" href="serviceContractDashboard.action"
										data-toggle="tooltip"
										data-original-title="Back To Ticket Dashboard"> <i
										class="fa fa-th-large"></i>
									</a>
									<h5>
										<s:text name="edit.service.contract.pannel.heading" />
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
											href="populateServiceContrctClone.action?command=<s:property value='serviceContactId'/>"
											class="btn btn-warning btnheight" data-toggle="tooltip"
											data-original-title="Clone"><i class="fa fa-users"></i>&nbsp;<s:text
												name="project.form.button.clone"></s:text></a> <a
											data-toggle="tooltip" data-original-title="Previous"
											type="button" class="btn btn-default btnheight"
											href="populatePreviousServiceContract.action?command=<s:property value='serviceContactId' />"><i
											class="fa fa-chevron-left fontawesomeht"></i></a> <a
											data-toggle="tooltip" data-original-title="Next"
											class="btn btn-default btnheight"
											href="populateNextServiceContrct.action?command=<s:property value='serviceContactId' />"><i
											class="fa fa-chevron-right fontawesomeht"></i></a> <a
											data-toggle="tooltip" data-original-title="Close"
											href="ticketDashboard.action"
											class="btn btn-danger btnheight"><i
											class="fa fa-times fontawesomeht"></i></a>
									</div>
								</div></header>
							<div class="container-fluid"
								style="margin-top: 15px; margin-bottom: 15px;">
								<s:iterator value="serviceContactVo">
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
															<s:text name="edit.service.contract.infobar" />
														</div>
													</div>
												</s:else>
											</p>
											<div class="form-group">
												<div class="row">
													<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
														<s:text name="add.service.contract.subject" />
														<font color="red">*</font>
													</div>
													<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
														<div id='updateServiceContract_subject_errorloc'
															class="error_strings" style="color: red;"></div>
														<s:textfield cssClass="form-control" name="subject"
															tabindex="10"></s:textfield>
													</div>
													<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
														<s:text name="add.service.contract.service.type"></s:text>
													</div>
													<div class="col-xs-4 col-md-4 col-sm-4 col-lg-4">
														<div
															id='updateServiceContract_serviceContactType_errorloc'
															class="error_strings" style="color: red;"></div>
														<s:select cssClass="form-control chzn-select" tabindex="4"
															headerKey="1" name="serviceContactType"
															list="serviceTypeList"></s:select>
													</div>
												</div>
											</div>
											<div class="form-group">
												<div class="row">
													<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
														<s:text name="add.service.contract.related.to"></s:text>
													</div>
													<div class="col-xs-4 col-md-4 col-sm-4 col-lg-4">
														<div id='updateServiceContract_reletedTo_errorloc'
															class="error_strings" style="color: red;"></div>
														<div class="input-group">
															<s:select cssClass="form-control chzn-select"
																tabindex="4" headerKey="1" name="reletedTo"
																list="releteddToList"></s:select>
															<span class="input-group-btn">
																<button type="button" tabindex="5"
																	onclick="PopupCenter('renderReletedTo','RenderReletedTo',800,600);"
																	class="btn btn-metis-3 btnheight_chzselect btn-line">
																	<i class="fa fa-plus-square "></i>
																</button>
															</span>
														</div>
													</div>
													<div class="col-xs-2 col-md-2 col-sm-2">
														<s:text name="add.service.contract.assigned.to"></s:text>
														<font color="red">*</font>
													</div>
													<div class="col-xs-4 col-md-4 col-sm-4">
														<div id='updateServiceContract_assignedTo_errorloc'
															class="error_strings" style="color: red;"></div>
														<s:select cssClass="form-control chzn-select" tabindex="4"
															headerKey="-1" headerValue="Select your Assigned To"
															name="assignedTo" list="serviceAssignedToList"></s:select>
													</div>
												</div>
											</div>
											<div class="form-group">
												<div class="row">
													<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
														<s:text name="add.service.contract.priority"></s:text>
													</div>
													<div class="col-xs-4 col-md-4 col-sm-4 col-lg-4">
														<div id='updateServiceContract_priority_errorloc'
															class="error_strings" style="color: red;"></div>
														<s:select cssClass="form-control chzn-select" tabindex="4"
															headerKey="1" name="priority" list="servicePriorityList"></s:select>
													</div>
													<div class="col-xs-2 col-md-2 col-sm-2">
														<s:text name="add.service.contract.status"></s:text>
													</div>
													<div class="col-xs-4 col-md-4 col-sm-4">
														<div id='updateServiceContract_status_errorloc'
															class="error_strings" style="color: red;">
															<s:select cssClass="form-control chzn-select"
																tabindex="4" headerKey="1" name="status"
																list="serviceStatusList"></s:select>
														</div>
													</div>
												</div>
											</div>
											<div class="form-group">
												<div class="row">
													<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
														<s:text name="add.service.contract.tracking"></s:text>
													</div>

													<div class="col-xs-4 col-md-4 col-sm-4">
														<div id='updateServiceContract_trackingUnit_errorloc'
															class="error_strings" style="color: red;">
															<s:select cssClass="form-control chzn-select"
																tabindex="4" headerKey="1" name="trackingUnit"
																list="serviceTrackingUnitList"></s:select>
														</div>
													</div>
													<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
														<s:text name="add.service.contract.used.units"></s:text>
													</div>
													<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
														<div id='updateServiceContract_usedUnits_errorloc'
															class="error_strings" style="color: red;"></div>
														<s:textfield cssClass="form-control" name="usedUnits"
															tabindex="10"></s:textfield>
													</div>
												</div>
											</div>
											<div class="form-group">
												<div class="row">
													<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
														<s:text name="add.service.contract.total.units"></s:text>
													</div>
													<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
														<s:textfield cssClass="form-control" name="totalUnits"
															tabindex="10"></s:textfield>
														<div id='updateServiceContract_totalUnits_errorloc'
															class="error_strings" style="color: red;"></div>
													</div>
													<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
														<s:text name="add.service.contract.start.date"></s:text>
													</div>
													<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
														<div id='updateServiceContract_startDate_errorloc'
															class="error_strings" style="color: red;"></div>
														<s:textfield type="text" name="startDate"
															class="form-control" id="dp3" cssClass="form-control"
															tabindex="14" readonly="true" />
													</div>
												</div>
											</div>
											<div class="form-group">
												<div class="row">
													<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
														<s:text name="add.service.contract.due.date"></s:text>
													</div>
													<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
														<div id='updateServiceContract_dueDate_errorloc'
															class="error_strings" style="color: red;"></div>
														<s:textfield type="text" name="dueDate"
															class="form-control" id="dp4" cssClass="form-control"
															tabindex="14" readonly="true" />
													</div>
													<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
														<s:text name="add.service.contract.contact.name"></s:text>
													</div>
													<div class="col-xs-4 col-md-4 col-sm-4 col-lg-4">
														<div id='updateServiceContract_contactName_errorloc'
															class="error_strings" style="color: red;"></div>
														<s:select cssClass="form-control chzn-select" tabindex="4"
															headerKey="1" name="contactName"
															list="serviceContactNameList"></s:select>
													</div>
												</div>
											</div>
											<hr>
											<div class="row" style="margin-top: 20px;">
												<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"
													align="center">
													<a href="serviceContractDashboard.action"
														data-toggle="tooltip" data-original-title="Cancel"
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
								</s:iterator>
							</div>
							</s:form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
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
	<script type="text/javascript">
		var formvalidation = new Validator("updateServiceContract");
		formvalidation.EnableOnPageErrorDisplay();
		formvalidation.EnableMsgsTogether();
		formvalidation.addValidation("subject", "req", "Please Enter Subject.");
		formvalidation
				.addValidation("subject", "minlen=3",
						"Please enter  Subject with at least 3 characters and at max 100 characters.");
		formvalidation
				.addValidation("subject", "maxlen=100",
						"Please enter  Subject with at least 3 characters and at max 100 characters.");

		formvalidation.addValidation("assignedTo", "dontselect=-1",
				"Select Assigned To.");
		formvalidation.addValidation("totalUnits", "req",
				"Please Enter total unit.");
		formvalidation.addValidation("totalUnits", "numeric",
				"Only Digits Used Units");
		formvalidation.addValidation("totalUnits", "minlen=2",
				"Minlen 2 Digits Total Units");
		formvalidation.addValidation("totalUnits", "maxlen=100 ",
				"Total Units Maxlen 100 Digits");

		formvalidation.addValidation("usedUnits", "req", "Enter Used Units");
		formvalidation.addValidation("usedUnits", "numeric",
				"Only Digits Used Units");
		formvalidation.addValidation("usedUnits", "minlen=2",
				"Minlen 2 Digits Used Units");
		formvalidation.addValidation("usedUnits", "maxlen=100 ",
				"Used Units Maxlen 100 Digits");

		formvalidation.addValidation("dueDate", "req", "Enter Due Date");
		formvalidation.addValidation("startDate", "req", "Enter Start Date");
	</script>
</body>
</html>