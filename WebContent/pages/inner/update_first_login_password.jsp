
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="/struts-jquery-tags" prefix="sj"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Form General</title>

<!--IE Compatibility modes-->
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<!--Mobile first-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Bootstrap -->
<link rel="stylesheet"
	href="pages/inner/assets/lib/bootstrap/css/bootstrap.min.css">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="pages/inner/assets/lib/font-awesome/css/font-awesome.min.css">
<!-- Metis core stylesheet -->
<link rel="stylesheet" href="pages/inner/assets/css/main.min.css">
<link rel="stylesheet"
	href="pages/inner/assets/lib/bootstrap3-wysihtml5-bower/bootstrap3-wysihtml5.min.css">
<link rel="stylesheet" href="pages/inner/assets/css/style-switcher.css">
<link rel="stylesheet"
	href="pages/inner/assets/lib/metismenu/metisMenu.min.css">
<link rel="stylesheet"
	href="pages/inner/assets/lib/jquery.uniform/themes/default/css/uniform.default.css">
<link rel="stylesheet"
	href="pages/inner/assets/lib/inputlimiter/jquery.inputlimiter.css">
<link rel="stylesheet"
	href="pages/inner/assets/lib/chosen/chosen.min.css">
<link rel="stylesheet"
	href="pages/inner/assets/lib/colorpicker/css/colorpicker.css">
<link rel="stylesheet"
	href="pages/inner/assets/css/colorpicker_hack.css">
<link rel="stylesheet"
	href="pages/inner/assets/lib/tagsinput/jquery.tagsinput.css">
<link rel="stylesheet"
	href="pages/inner/assets/lib/daterangepicker/daterangepicker-bs3.css">
<link rel="stylesheet"
	href="pages/inner/assets/lib/datepicker/css/datepicker.css">
<link rel="stylesheet"
	href="pages/inner/assets/lib/timepicker/css/bootstrap-timepicker.min.css">
<link rel="stylesheet"
	href="pages/inner/assets/lib/switch/css/bootstrap3/bootstrap-switch.min.css">
<link rel="stylesheet"
	href="pages/inner/assets/lib/jasny-bootstrap/css/jasny-bootstrap.min.css">

<link rel="stylesheet"
	href="pages/inner/assets/lib/datatables/3/dataTables.bootstrap.css">


<style type="text/css">
#mynavbar.navbar-default .navbar-nav>.active>a,.navbar-default .navbar-nav>.active>a:hover,.navbar-default .navbar-nav>.active>a:focus
	{
	background-color: #F8F8F8;
}
</style>



<style type="text/css">
#myrow th {
	font-weight: 400;
	background-color: #394B5E;
	color: white;
}
</style>

<style type="text/css">
.error_strings {
	color: red;
}
</style>

<style type="text/css">
.form-horizontal .control-label {
	text-align: left;
}

.modal-body {
	text-align: left;
}

.scrolldashboard {
	overflow-y: scroll;
	height: 330px;
	width: 100%;
}

body {
	margin-bottom: 0px;
}

.Footer,#footer {
	bottom: 0px;
	width: 100%;
	height: auto;
	position: relative;
}

.new {
	color: #00b4f5;
}

.inprogress {
	color: darkgreen;
}

.assigned {
	color: purple;
}

.verified {
	color: #3d8b3d;
}

.closed {
	color: #D43F3A;
}

.deleted {
	color: maroon;
}

.notverified {
	color: orange;
}

.junklead {
	color: black;
}

.futurelead {
	color: gray;
}

.duplicate {
	color: darkblue;
}

.preverified {
	color: #00CCFF;
}

.expired {
	color: orange;
}

#dataTable_paginate {
	float: right;
}

#dataTable_filter {
	float: right;
}

.form-horizontal .control-label {
	text-align: left;
}

.box header h5 {
	font-size: 16px;
}

#viewlable {
	color: #6E6E6E;
}

.btn-line.btn-metis-1 {
	color: gray;
	border-color: #E7E7E7;
}

.btn-line.btn-metis-2 {
	color: gray;
	border-color: #E7E7E7;
}

.btn-line.btn-metis-3 {
	color: gray;
	border-color: #E7E7E7;
}

.btn-line.btn-metis-4 {
	color: gray;
	border-color: #E7E7E7;
}

.btn-line.btn-metis-5 {
	color: gray;
	border-color: #E7E7E7;
}

.btn-line.btn-metis-6 {
	color: gray;
	border-color: #E7E7E7;
}

#view_lable {
	background-color: #FFFFFF;
	text-align: left;
}

#view_lable_value {
	background-color: #FBFBFB;
	padding-left: 0px;
}

#row_a_link {
	color: blue;
}

#view_lable_value {
	background-color: #FBFBFB;
}

#view_lable_value2 {
	background-color: #F7F7F7;
	padding-left: 0px;
}

#dashboard_search_tools {
	padding-top: 15px;
}

#data_grid {
	background-color: #E4E4E4;
	border: 1px;
	border-color: #ffffff;
	padding-top: 15px;
	padding-bottom: 15px;
}

.sparkline {
	padding: 30px 14px 30px 4px;
}

.stats_box .stat_text {
	padding: 30px 10px 7px 0px;
}

.stats_box .stat_text .percent {
	top: 37px;
}

.stats_box li {
	padding: 0px;
}

.dropdown-menu {
	z-index: 1040;
}

#alignleft.list-group-item {
	text-align: left;
}

.img-circle {
	border-radius: 50%;
	height: 70px;
	width: 70px;
}

.infoIcon {
	display: inline;
}

.star {
	display: inline;
	color: red;
}

.quick-icons {
	color: lightgray;
	text-align: center;
	text-decoration: none;
	margin: 10px;
	position: relative;
	display: inline-block;
	height: 42px;
	padding-top: 2px;
}

.quick-icons span {
	display: block;
	color: #394B5E;
}

.btnheight {
	height: 34px;
}

.fontawesomeht {
	padding-top: 3px;
}

.chosen-container-single .chosen-single {
	border-radius: 0px;
}

.input-sm,.form-group-sm .form-control {
	border-radius: 0px;
}

.btn-sm,.btn-group-sm>.btn {
	border-radius: 0px;
}

.btn-xs,.btn-group-xs>.btn {
	border-radius: 0px;
}

a:hover#view {
	color: #337AB7;
}

a:hover#edit {
	color: #8838E0;
}

a:hover#delete {
	color: #D9534F;
}

.box {
	border-top: none;
}

.btnheight_chzselect {
	height: 26px;
}

.header_color {
	color: #394B5E;
}

.viewpage_contentheader {
	color: #CD0067;
}

.button_color {
	background-color: #394B5E;
	border-color: #394B5E;
}

a:hover,a:focus {
	color: #394B5E;
	text-decoration: none;
}

.leaddashfa {
	color: lightgray;
}

.icon {
	color: gray;
}

.searchBar {
	background-color: #ECEDEF;
	margin-bottom: 20px;
}

.btniconcolor {
	color: #394B5E;
}

.viewinnertitle {
	padding-left: unset;
	color: #CD0067;
}

.innertitle {
	color: #CD0067;
}

.hide {
	display: none;
}
/* .breadcrumb {
border-radius:0px;
}
 */

/* .inner {
padding-right:10px;
padding-left: 10px;
} */
</style>
<script src="outer/js/gen_validatorv4.js" type="text/javascript"></script>

</head>
<style type="text/css">
.error_strings {
	color: red;
}
</style>
<body>

	<div id="content">
		<div class="outer">
			<div class="inner bg-light lter">

				<!--BEGIN INPUT TEXT FIELDS-->
				<div class="row">
					<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
					 <ol class="breadcrumb" style="margin-top: 10px;">
							
							<li class="active"><s:text name="Update Password"></s:text></li>
							
							
						</ol>
						<div class="box dark">
							<header>
								<a class="icons" href="dashboard.action"
								data-toggle="tooltip" data-original-title="Back To  DashBoard"
								style="color: Black;"> <i class="fa fa-th-large"></i>
							</a>
								<h5>Update Password</h5>

								<!-- .toolbar -->
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
											data-original-title="Refresh"
											class="btn btn-success btnheight"><i
											class="fa fa-refresh "></i></a> <a href="leadDashboard.action"
											data-toggle="tooltip" data-original-title="Close"
											class="btn btn-danger btnheight"><i
											class="fa fa-times fontawesomeht"></i></a>
									</div>

								</div>							
								
								<!-- /.toolbar -->
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
													<s:text name="Update Your Current Login Password For Security Purpose." />
												</div>
											</div>
										</s:else>
									</p>
							    
								<div id="content" style="background-color: #F9F9F9;">



									<!--BEGIN INPUT TEXT FIELDS-->
									<div class="row">
										<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
											<div class="box inverse"
												>



												
												<s:form action="updateLoginPassword"
													name="changePassword" class="form-horizontal"
													id="block-validate">
													<div class="form-group">
														<div class="row">
															<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
																<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12"></div>
																<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
																	<div class="row">
																		<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
																			<s:text name="change.password.Current.password" />
																			<div class="star">*</div>

																		</div>
																		<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
																			<s:textfield type="password" id="text1"
																				name="password" 
																				cssClass="form-control" />
																				
																			<div id='changePassword_oldPassword_errorloc'
																				class="error_strings"></div>
																		</div>
																	</div>

																</div>
																<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12"></div>
															</div>
														</div>
													</div>

													<div class="form-group">
														<div class="row">
															<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
																<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12"></div>
																<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
																	<div class="row">
																		<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
																			<s:text name="change.password.new.password" />
																			<div class="star">*</div>

																		</div>
																		<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
																			<s:textfield type="password" name="newPassword"
																				id="text1" 
																				cssClass="form-control" />
																			<div id='changePassword_password_errorloc'
																				class="error_strings"></div>
																		</div>
																	</div>
																</div>
																<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12"></div>
															</div>
														</div>
													</div>

													<div class="form-group">
														<div class="row">
															<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
																<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12"></div>
																<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
																	<div class="row">
																		<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
																			<s:text name="change.password.reenter.password" />
																			<div class="star">*</div>

																		</div>
																		<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
																			<s:textfield type="password" name="reEnterpassword"
																				id="text1" 
																				cssClass="form-control" />
																			<div id='changePassword_reenterPassword_errorloc'
																				class="error_strings"></div>
																		</div>
																	</div>
																</div>
																<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12"></div>


															</div>
														</div>


													</div>
													<hr>

													
										<div class="row">
										<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"
											align="center">
											<a href="omiInnerDashboard.action" data-toggle="tooltip"
												data-original-title="Cancel"
												class="btn btn-default btnheight"><i
												class="fa fa-caret-square-o-left fontawesomeht"></i> <s:text
													name="project.form.button.cancel"></s:text></a> <a
												href="changePasswordTemplet.action" data-toggle="tooltip"
												data-original-title="Reset"
												class="btn btn-success btnheight"><i
												class="fa fa-refresh "></i> <s:text
													name="project.form.button.reset"></s:text></a>
											<button type="submit" data-toggle="tooltip"
												data-original-title="Update" class="btn btn-primary btnheight">
												<i class="fa fa-check"></i>
												<s:text name="project.form.button.Update"></s:text>
											</button>

										</div>
									</div>
												</s:form>
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

	<script src="outer/js/gen_validatorv4.js" type="text/javascript"></script>
	<script type="text/javascript">
		var frmvalidator = new Validator("changePassword");
		frmvalidator.EnableOnPageErrorDisplay();
		frmvalidator.EnableMsgsTogether();
		frmvalidator.addValidation("oldPassword", "req",
				"Enter Old Password");
		frmvalidator.addValidation("password", "req", "Enter New Password");
		frmvalidator.addValidation("reenterPassword", "req",
				"Re-enter New Password");
	</script>

</body>
</html>