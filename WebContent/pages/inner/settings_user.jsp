<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!-- Popup Window use script -->

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

<!-- End -->

<style>
a {
	color: blue;
}

a:hover {
	color: blue;
}
</style>

<!-- Script for ajax call for email or mobile no -->
<script type="text/javascript">
	var xmlhttp;
	if (window.XMLHttpRequest) {
		xmlhttp = new XMLHttpRequest();
	} else {
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}

	/* This function will check the existing email id */
	function isUserEmailIdExist(userEmailId) {

		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				document.getElementById("server1Response").innerHTML = xmlhttp.responseText;
			}
		};
		xmlhttp.open("GET", "isUserEmailIdExists.action?userEmailId="
				+ userEmailId, true);
		xmlhttp.send();
	}
</script>
<!-- / Script for ajax call for email or mobile no -->



</head>
<body>
	<s:form action="addUser" name="AddUserForm" method="post">
		<div id="content">

			<div class="outer">
				<div class="inner bg-light lter">

					<!--BEGIN INPUT TEXT FIELDS-->
					<div class="row">
						<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
						<ol class="breadcrumb" style="margin-top: 10px;">
							<li><a href="omiInnerDashboard.action"><i
									class="fa fa-home"></i></a></li>
							<li class="active"><s:text name="setting.user.navigation.bar"></s:text></li>

						</ol>
							<div class="box ">
								<header> <a class="icons" href="dashboard.action"
									data-toggle="tooltip" data-original-title="Back To DashBoard"
									style="color: black;"> <i class="fa fa-th-large"></i>
								</a>
								<h5>
									<s:text name="add.user.setting" />
								</h5>

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
									<a href="renderCompanySettings.action" data-toggle="tooltip"
										data-original-title="Refresh"
										class="btn btn-success btnheight"><i
										class="fa fa-refresh "></i></a> <a href="omiInnerDashboard.action"
										data-toggle="tooltip" data-original-title="Close"
										class="btn btn-danger btnheight"><i
										class="fa fa-times fontawesomeht"></i></a>
								</div>
							</div>
								<!-- /.toolbar --> </header>
								<div class="row">
								<div class="container-fluid">

									<div class="col-lg-12  col-md-12 col-sm-12 col-xs-12"
										style="margin-top: 15px;">
										<a class="quick-icons" href="renderCompanySettings.action"
											data-toggle="tooltip" data-placement="right"
											data-original-title="Company" class="active"> <i
											class="fa fa-files-o fa-2x"></i> <span><s:text
													name="add.user.menus.company"></s:text></span>
										</a> <a class="quick-icons" href="settingsUser.action" data-toggle="tooltip"
											data-placement="right" data-original-title="User"> <i
											class="fa fa-user btniconcolor"></i> <span><s:text
													name="add.user.menus.user"></s:text></span>
										</a> <a class="quick-icons" href="settingFinanceTaxes.action"> <i
											class="fa fa-exchange fa-2x"></i><span><s:text
													name="add.user.menus.finance"></s:text></span>
										</a> <a class="quick-icons" href="settingMarketingLeadSource.action"> <i
											class="fa fa-clipboard fa-2x"></i><span><s:text
													name="add.user.menus.marketing"></s:text></span>
										</a> <a class="quick-icons" href="settingProductCategory.action"> <i
											class="fa fa fa-envelope fa-2x"></i><span> <s:text
													name="add.user.menus.product"></s:text></span>
										</a> <a class="quick-icons" href="settingSupportFAQCategory.action"> <i
											class="fa fa fa-comment fa-2x"></i><span><s:text
													name="add.user.menus.support"></s:text></span>
										</a>
										<hr
											style="margin-left: 15px; margin-right: 15px; margin-top: -10px;">
									</div>

								</div>

							</div>
									<!-- Tab panes  ****      **  **  -->
									<div id="content" style="background-color: #F9F9F9;">



										<!--BEGIN INPUT TEXT FIELDS-->
										<div class="row">
											<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
												<div class="box "
													style="margin-top: -10px; margin-bottom: 0px;">
													<div class="alert alert-info" role="alert"
														style="margin-top: 25px; margin-left: 5px; margin-right: 5px;">
														<p>
															<s:if test="hasActionErrors()">
																<s:actionerror />
															</s:if>
															<s:elseif test="hasActionMessages()">
																<s:actionmessage />
															</s:elseif>
															<s:else>

																<div class="infoIcon">
																	<span class="fa fa-info" style="margin-left: 3px;"></span>
																</div>&nbsp;&nbsp;&nbsp;<s:text name="add.user.infobar" />
															</s:else>
														</p>
													</div>




													<div id="content">
														<!--Begin Datatables-->
														<div class="row">
															<div class="col-lg-12">
																<div id="collapse4" class="body">
																	<div class="table-responsive">
																		<div id="dashboard_search_tools">
																			<div class="row form-group">
																				<div
																					class="col-lg-12  col-md-12  col-sm-12 col-xs-12"
																					style="margin-bottom: 2px;">
																					<div
																						class="col-lg-1  col-md-1  col-sm-12 col-xs-12">
																						<label>
																							<h5>
																								<s:text name="lead.dashboard.searchby"></s:text>
																							</h5>
																						</label>
																					</div>
																					<div
																						class="col-lg-2  col-md-2  col-sm-12 col-xs-12">
																						<select class="form-control">
																							<option>1</option>
																							<option>2</option>
																							<option>3</option>
																							<option>4</option>
																							<option>5</option>
																						</select>
																					</div>

																					<div
																						class="col-lg-2  col-md-3  col-sm-12 col-xs-12">
																						<div class="row form-group">
																							<div
																								class="col-lg-10  col-md-9  col-sm-9 col-xs-9">
																								<input type="text" id="text1"
																									class="form-control">
																							</div>
																							<div
																								class="col-lg-1  col-md-1  col-sm-3 col-xs-3"
																								style="margin-top: 4px;">
																								<a href="#" data-toggle="tooltip"
																									data-original-title="Search"
																									data-placement="bottom"
																									class="btn btn-success btn-md"> <i
																									class="fa fa-search"></i>
																								</a>
																							</div>
																						</div>
																					</div>

																					<div
																						class="col-lg-4  col-md-2  col-sm-12 col-xs-12"></div>
																					<div
																						class="col-lg-3  col-md-3  col-sm-12 col-xs-12"
																						align="right" style="margin-top: 5px;">
																						<button type="button"
																							onclick="PopupCenter('createUser','addUser',600,500);"
																							class="btn btn-primary">
																							<i class="fa fa-plus ">&nbsp;<s:text
																									name="add.user.button" />
																							</i>
																						</button>
																						<a data-toggle="tooltip"
																							data-original-title="Refresh"
																							data-placement="bottom"
																							class="btn btn-metis-2 btn-line"
																							onclick="window.location.reload();"> <i
																							class="fa fa-refresh "></i>
																						</a> <a href="leadExcelReport.action"
																							data-toggle="tooltip"
																							data-original-title="XLS Report"
																							data-placement="bottom"
																							class="btn btn-metis-6 btn-line"> <i
																							class="fa fa-file-excel-o "></i>
																						</a> <a href="login.html" data-toggle="tooltip"
																							data-original-title="Setting"
																							data-placement="bottom"
																							class="btn btn-metis-1 btn-line"> <i
																							class="fa fa-gear "></i>

																						</a>
																					</div>
																				</div>
																			</div>
																		</div>

																		<table id="dataTable"
																			class="table table-bordered table-condensed table-hover table-striped">

																			<tbody>
																				<tr id="myrow">
																				<th style="width: 7px;"><s:text
																							name="add.user.table.action" /></th>
																					<th><s:text name="add.user.table.id" /></th>
																					<th><s:text name="add.user.table.name" /></th>
																					<th><s:text name="add.user.table.role" /></th>
																					<th><s:text name="add.user.table.date" /></th>
																					<th><s:text name="add.user.table.status" /></th>
																					<th><s:text name="Password" /></th>
																					
																				</tr>
																				<s:iterator value="userTitleGrid">

																					<tr><td align="center">
																							<div class="btn-group">
																								<a
																									href="viewUserDetails.action?command=<s:property
																										value='customerId' />"
																									data-toggle="tooltip"
																									data-original-title="View"
																									data-placement="bottom"
																									class="btn btn-metis-5
																									btn-xs">
																									<i class="fa fa-file-o"></i>
																								</a>
																							</div>


																							<div class="btn-group">
																								<a
																									href="userProfile.action?command=<s:property value='customerId' />"
																									data-toggle="tooltip"
																									data-original-title="Edit"
																									data-placement="bottom"
																									class="btn btn-metis-6 btn-xs"> <i
																									class="fa fa-edit"></i>
																								</a>
																							</div>


																							<div class="btn-group">
																								<a href="login.html" data-toggle="tooltip"
																									data-original-title="Delete"
																									data-placement="bottom"
																									class="btn btn-metis-1 btn-xs"> <i
																									class="fa fa-trash-o"></i>
																								</a>
																							</div>
																						</td>
																						<td><a style="color: blue"
																							href="viewUserDetails.action?command=<s:property
																									value='customerId' />"><s:property
																									value='customerId' /></a></td>
																						<td><s:property value="fullName" /></td>
																						<td><s:property value="userRole" /></td>
																						<td><s:property value="creationDate" /></td>
																						<td><s:property value="userStatus" /></td>
																						<td><s:property value="password" /></td>


																						

																					</tr>
																				</s:iterator>
																			</tbody>

																		</table>
																	</div>
																</div>

															</div>
														</div>
														<!-- /.row -->

														<!--End Datatables-->






													</div>
													<!-- /.inner -->
												</div>
												<!-- /.outer -->

												<!-- /#content -->




												<!-- Screenfull -->
												<script
													src="assets/lib/bootstrap3-wysihtml5-bower/bootstrap3-wysihtml5.all.min.js"></script>
												<script src="assets/lib/ckeditor/ckeditor.js"></script>
												<!-- Metis demo scripts -->




												<script src="assets/lib/screenfull/screenfull.js"></script>
												<script src="assets/lib/datatables/jquery.dataTables.js"></script>
												<script
													src="assets/lib/datatables/3/dataTables.bootstrap.js"></script>
												<script
													src="assets/lib/jquery.tablesorter/jquery.tablesorter.min.js"></script>
												<script
													src="assets/lib/jquery-ui-touch-punch/jquery.ui.touch-punch.min.js"></script>

												<!-- Metis core scripts -->
												<script src="assets/js/core.min.js"></script>

												<!-- Metis demo scripts -->
												<script src="assets/js/app.min.js"></script>
												<script>
													$(function() {
														Metis.MetisTable();
														Metis.metisSortable();
													});
												</script>
												<script src="assets/js/style-switcher.min.js"></script>

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

	<!-- Validation Parts -->
	<script src="outer/js/gen_validatorv4.js" type="text/javascript"></script>
	<script type="text/javascript">
		var v = new Validator("AddUserForm");
		v.EnableOnPageErrorDisplay();
		v.EnableMsgsTogether();
		v.addValidation("UserName", "maxlen=33",
				"please enter max 33 character");
		v.addValidation("UserName", "space[\S]", "No require firstly space");
		v.addValidation("UserName", "alpha",
				"name is no require for space firstly");
		v.addValidation("UserName", "req", "please enter Your Full Name");

		v.addValidation("Email", "email", "Please Enter The Vailide Email Id");
		v.addValidation("Email", "req", "Please Enter The Email Id");

		v.addValidation("MobileNo", "req", "please enter Mobile-No");
		v.addValidation("MobileNo", "maxlen=12", "please enter max 12 Number");
		v.addValidation("MobileNo", "minlen=10",
				"please enter atleast 10 Number");
		v.addValidation("MobileNo", "space[\S]", "No require firstly space");
		v.addValidation("MobileNo", "num", "please enter Numeric digit");

		v.addValidation("UserRole", "dontselect=-1", "Please Choise User Role");

		v.addValidation("Country", "dontselect=-1", "Please Choise Country");
	</script>
	<!-- End -->
</body>
</html>