<%@page import="com.bst.ckt.vo.TicketVO"%>
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
							<li><a href="ticketDashboard.action"><s:text
										name="ticket.Dashboard.navbar"></s:text></a></li>
							<li><a href="ticketDashboard.action"><s:text
										name="ticket.Dashboard.panel.heading"></s:text></a></li>
							<li><a
								href="editTicket?command=<s:property value='ticketId'/>"
								data-placement="bottom"><s:text
										name="edit.ticket.panel.heading"></s:text></a></li>
						</ol>
						<div class="box">
							<header> <s:form name="updateTicketForm"
								action="supportUpdateTicket" method="POST">

								<div class="pull-left">
									<a class="icons" href="ticketDashboard.action"
										data-toggle="tooltip"
										data-original-title="Back To Ticket Dashboard"> <i
										class="fa fa-th-large"></i>
									</a>
									<h5>
										<s:text name="edit.ticket.panel.heading" />
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
											href="populateTicketClone.action?command=<s:property value='ticketId'/>"
											class="btn btn-warning btnheight" data-toggle="tooltip"
											data-original-title="Clone"><i class="fa fa-users"></i>&nbsp;<s:text
												name="project.form.button.clone"></s:text></a> <a
											data-toggle="tooltip" data-original-title="Previous"
											type="button" class="btn btn-default btnheight"
											href="populatePreviousTicket.action?command=<s:property value='ticketId' />"><i
											class="fa fa-chevron-left fontawesomeht"></i></a> <a
											data-toggle="tooltip" data-original-title="Next"
											class="btn btn-default btnheight"
											href="populateNextTicket.action?command=<s:property value='ticketId' />"><i
											class="fa fa-chevron-right fontawesomeht"></i></a> <a
											data-toggle="tooltip" data-original-title="Close"
											href="ticketDashboard.action"
											class="btn btn-danger btnheight"><i
											class="fa fa-times fontawesomeht"></i></a>
									</div>
								</div></header>
							<div class="container-fluid"
								style="margin-top: 15px; margin-bottom: 15px;">
								<s:iterator value="ticketVO">
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
															<s:text name="edit.ticket.infobar" />
														</div>
													</div>
												</s:else>
											</p>
											<div class="form-group">
												<div class="row">
													<div class="col-lg-2 col-md-2 col-sm-2 col-xs-12">
														<s:text name="add.new.ticket.category"></s:text>
														<font color="red">*</font>

													</div>
													<div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
														<div id='updateTicketForm_category_errorloc'
															class="error_strings"></div>
														<s:select cssClass="form-control chzn-select"
															headerKey="-1" headerValue="Ticket Category"
															name="category" list="ticketCategoryList" tabindex="7"></s:select>
													</div>
													<div class="col-lg-2 col-md-2 col-sm-2 col-xs-12">
														<s:text name="add.new.ticket.ticketOwner"></s:text>

													</div>
													<div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
														<div id='updateTicketForm_ticketOwner_errorloc'
															class="error_strings"></div>
														<s:select cssClass="form-control chzn-select" tabindex="7"
															headerKey="1" name="ticketOwner" id="ticketOwner"
															list="ticketOwnerList" />
													</div>
												</div>
											</div>
											<div class="form-group">
												<div class="row">
													<div class="col-lg-2 col-md-2 col-sm-2 col-xs-12">
														<s:text name="add.new.ticket.productName"></s:text>
													</div>
													<div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
														<div class="input-group">
															<div id='updateTicketForm_productName_errorloc'
																class="error_strings"></div>
															<s:select cssClass="form-control chzn-select"
																tabindex="4" headerKey="1" name="productName"
																id="productName" list="ticketProductNameList" />
															<span class="input-group-btn">
																<button type="button" tabindex="5"
																	onclick="PopupCenter('renderTicketProductName','RenderTicketProductName',800,600);"
																	class="btn btn-metis-3 btnheight_chzselect btn-line">
																	<i class="fa fa-plus-square "></i>
																</button>
															</span>
														</div>
													</div>
													<div class="col-lg-2 col-md-2 col-sm-2 col-xs-12">
														<s:text name="add.new.ticket.contactName" />
														<font color="red">*</font>
													</div>
													<div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
														<div class="input-group">
															<div id='updateTicketForm_contactName_errorloc'
																class="error_strings"></div>
															<s:select cssClass="form-control chzn-select"
																tabindex="4" headerKey="-1" name="contactName"
																id="contactName" list="ticketContactNameList"
																headerValue="Ticket Contact Name" />
															<span class="input-group-btn">
																<button type="button" tabindex="5"
																	onclick="PopupCenter('renderTicketContactName','RenderTicketContactName',800,600);"
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
													<div class="col-lg-2 col-md-2 col-sm-2 col-xs-12">
														<s:text name="add.new.ticket.phoneNo"></s:text>
													</div>
													<div class="col-lg-1 col-md-1 col-sm-1 col-xs-12"
														style="padding-right: 0;">
														<s:textfield cssClass="form-control" name="phoneIsd"
															placeholder="%{getText('project.placeholder.isd')}"
															tabindex="26"></s:textfield>
														<div id='updateTicketForm_phoneIsd_errorloc'
															class="error_strings"></div>
														<div id='updateTicketForm_phoneStd_errorloc'
															class="error_strings"></div>
														<div id='updateTicketForm_phoneNo_errorloc'
															class="error_strings"></div>

													</div>
													<div class="col-lg-1 col-md-1 col-sm-1 col-xs-12"
														style="padding-left: 0; padding-right: 0;">
														<s:textfield cssClass="form-control" name="phoneStd"
															tabindex="27"
															placeholder="%{getText('project.placeholder.std')}"></s:textfield>
													</div>
													<div class="col-lg-2 col-md-2 col-sm-2 col-xs-12"
														style="padding-left: 0;">
														<s:textfield name="phoneNo" cssClass="form-control"
															placeholder="%{getText('project.placeholder.phonenumber')}"
															tabindex="28" />

													</div>
													<div class="col-lg-2 col-md-2 col-sm-2 col-xs-12">
														<s:text name="add.new.ticket.email"></s:text>

													</div>
													<div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
														<div id='updateTicketForm_email_errorloc'
															class="error_strings" style="color: red;"></div>
														<s:textfield name="email" id="email"
															cssClass="form-control"></s:textfield>
													</div>
												</div>
											</div>
											<div class="form-group">
												<div class="row">
													<div class="col-lg-2 col-md-2 col-sm-2 col-xs-12">
														<s:text name="add.new.ticket.subject"></s:text>
														<font color="red">*</font>
													</div>
													<div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
														<div id='updateTicketForm_subject_errorloc'
															class="error_strings" style="color: red;"></div>
														<s:textfield name="subject" id="subject"
															cssClass="form-control"></s:textfield>
													</div>
													<div class="col-lg-2 col-md-2 col-sm-2 col-xs-12">
														<s:text name="add.new.ticket.status"></s:text>
														<font color="red">*</font>
													</div>
													<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
														<div id='updateTicketForm_status_errorloc'
															class="error_strings"></div>
														<s:select name="status" tabindex="2" headerKey="-1"
															list="ticketStatusList"
															cssClass="form-control chzn-select" />
													</div>
												</div>
											</div>
											<div class="form-group">
												<div class="row">
													<div class="col-lg-2 col-md-2 col-sm-2 col-xs-12">
														<s:text name="add.new.ticket.dueDate" />
													</div>
													<div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
														<div id='updateTicketForm_dueDate_errorloc'
															class="error_strings"></div>
														<s:textfield type="text" name="dueDate"
															class="form-control" id="dp3" cssClass="form-control"
															tabindex="14" readonly="true" />
													</div>
													<div class="col-xs-12 col-md-2 col-sm-2 col-lg-2">
														<s:text name="add.new.ticket.priority"></s:text>

													</div>
													<div class="col-xs-12 col-md-4 col-sm-4 col-lg-4">
														<div id='updateTicketForm_priority_errorloc'
															class="error_strings" style="color: red;"></div>
														<s:select name="priority" headerValue="Ticket Priority"
															list="ticketPriorityList"
															cssClass="form-control chzn-select" headerKey="1"
															tabindex="7">
														</s:select>
													</div>
												</div>
											</div>
											<div class="form-group">
												<div class="row">
													<div class="col-xs-12 col-md-2 col-sm-2 col-lg-2">
														<s:text name="add.new.ticket.channel"></s:text>

													</div>
													<div class="col-xs-12 col-md-4 col-sm-4 col-lg-4">
														<div id='updateTicketForm_channel_errorloc'
															class="error_strings" style="color: red;"></div>
														<s:select name="channel" list="ticketChannelList"
															cssClass="form-control chzn-select" headerKey="1"
															tabindex="7">
														</s:select>
													</div>
													<div class="col-xs-12 col-md-2 col-sm-2 col-lg-2">
														<s:text name="add.new.ticket.uploadFile"></s:text>
													</div>
													<div class="col-xs-12 col-md-4 col-sm-4 col-lg-4">
														<%-- <div id='updateTicketForm_attachment_errorloc'
																class="error_strings" style="color: red;"></div>
															<s:file name="uploadFile" cssClass="form-control" size="">
															</s:file> --%>
													</div>
												</div>
											</div>
											<div class="row" style="margin-top: 20px;">
												<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
													<h5 class="innertitle">
														<s:text name=""></s:text>

													</h5>
													<hr style="margin-top: -5px">
												</div>
											</div>
											<div class="form-group">
												<div class="row" style="margin: 1% 2%;" id="data_grid">
													<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
														<div id='updateTicketForm_description_errorloc'
															class="error_strings"></div>
														<s:textarea id="wysihtml5" name="description"
															class="form-control" rows="10" tabindex="37">
														</s:textarea>
														<div id='updateTicketForm_requirment_errorloc'
															class="error_strings"></div>
													</div>
												</div>
											</div>
											<hr>
											<div class="row" style="margin-top: 20px;">
												<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"
													align="center">
													<a href="ticketDashboard.action" data-toggle="tooltip"
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
		var frmvalidator = new Validator("updateTicketForm");
		frmvalidator.EnableOnPageErrorDisplay();
		frmvalidator.EnableMsgsTogether();
		frmvalidator.addValidation("category", "dontselect=-1",
				"Select Ticket Category");
		frmvalidator.addValidation("ticketOwner", "dontselect=-1",
				"Select Ticket Owner");
		frmvalidator.addValidation("productName", "dontselect=-1",
				"Select Ticket Product Name");
		frmvalidator.addValidation("contactName", "dontselect=-1",
				"Select Ticket Contact Name");
		frmvalidator.addValidation("phoneNo", "req", "Enter Phone No");
		frmvalidator.addValidation("phoneIsd", "req", "Enter Phone Isd");
		frmvalidator.addValidation("phoneStd", "req", "Enter Phone Std");

		frmvalidator.addValidation("phoneNo", "minlen=10",
				"Minimum Length Numeric 10 Digit phone No");
		frmvalidator.addValidation("phoneNo", "numeric",
				"phone No Only Numeric Digits");
		frmvalidator.addValidation("phoneNo", "maxlen=10",
				"Maximum Length Numeric 10 Digits phone No");
		frmvalidator.addValidation("phoneIsd", "numeric",
				"Only Numeric Digits phone Isd");
		frmvalidator.addValidation("phoneIsd", "minlen=2",
				"Minlen 2 Digits phone Isd");
		frmvalidator.addValidation("phoneIsd", "maxlen=4 ",
				"Maxlen 4 Digits phone Isd");
		frmvalidator.addValidation("phoneStd", "numeric",
				"Numeric Digits phone Std ");
		frmvalidator.addValidation("phoneStd", "minlen=2",
				"Minilen 2 Digits phone Std");
		frmvalidator.addValidation("phoneStd", "maxlen=6",
				"Maxlen 6 Digits phone Std");
		frmvalidator.addValidation("email", "req",
				"Enter Your Valid Email Address");
		frmvalidator.addValidation("email", "maxlen=100",
				"Email Id Should Be 100 Characters");
		frmvalidator.addValidation("email", "minlen=3",
				"Email Id Should Be 3 Characters");

		frmvalidator.addValidation("subject", "minlen=3",
				"Ticket Subject Should Be 3 Characters  ");
		frmvalidator.addValidation("subject", "req",
				"Enter Your Ticket Subject");
		frmvalidator.addValidation("subject", "maxlen=200",
				"Subject Should Be 100 Characters");

		frmvalidator.addValidation("status", "dontselect=-1",
				"Select Ticket Status");
		frmvalidator.addValidation("priority", "dontselect=-1",
				"Select Ticket Category");
		frmvalidator.addValidation("channel", "dontselect=-1",
				"Select Ticket Channel");
		frmvalidator.addValidation("description", "req",
				"Enter Your Ticket Description");
		frmvalidator.addValidation("description", "minlen=3",
				"Description Name Should Be 3 Characters");
		frmvalidator.addValidation("description", "maxlen=4000",
				"Ticket Description Name Should Be 4000 Characters");
		frmvalidator.addValidation("dueDate", "req", "Select Ticket Date");
	</script>
</body>
</html>