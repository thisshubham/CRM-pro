<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="/struts-jquery-tags" prefix="sj"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
a {
	color: blue;
}

a:hover {
	color: blue;
}
</style>

</head>
<sj:head />
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
							<li class="active"><s:text
									name="setting.finance.navigation.bar"></s:text></li>
							<li class="active"><s:text
									name="setting.finance.GLaccount.navigation.bar"></s:text></li>

						</ol>
						<div class="box ">
							<s:form class="form-horizontal"
								action="insertFinanceGLAccountDetails"
								name="finanaceGLAccountForm">
								<header>
								<div class="icons">

									<a style="color: black" href="dashboard.action"
										data-toggle="tooltip" data-original-title="Back To DashBoard">
										<i class="fa fa-th-large"></i>
									</a>
								</div>
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
										<button type="button" data-toggle="tooltip"
											data-original-title="Refresh"
											class="btn btn-success btnheight"
											onclick="window.location.reload();">
											<i class="fa fa-refresh "></i>
										</button>
										<a href="omiInnerDashboard.action" data-toggle="tooltip"
											data-original-title="Close" class="btn btn-danger btnheight"><i
											class="fa fa-times fontawesomeht"></i></a>
									</div>
								</div>

								</header>
								<div class="row">
									<div class="container-fluid">

										<div class="col-lg-12  col-md-12 col-sm-12 col-xs-12"
											style="margin-top: 15px;">
											<a class="quick-icons" href="renderCompanySettings.action"
												data-toggle="tooltip" data-placement="right"
												data-original-title="Company" class="active"> <i
												class="fa fa-files-o fa-2x"></i> <span><s:text
														name="add.user.menus.company"></s:text></span>
											</a> <a class="quick-icons" href="settingsUser.action"
												data-toggle="tooltip" data-placement="right"
												data-original-title="User"> <i
												class="fa fa fa-user fa-2x"></i> <span><s:text
														name="add.user.menus.user"></s:text></span>
											</a> <a class="quick-icons" href="settingFinanceTaxes.action">
												<i class="fa fa-exchange fa-2x"></i><span><s:text
														name="add.user.menus.finance"></s:text></span>
											</a> <a class="quick-icons"
												href="settingMarketingLeadSource.action"> <i
												class="fa fa-clipboard fa-2x"></i><span><s:text
														name="add.user.menus.marketing"></s:text></span>
											</a> <a class="quick-icons" href="settingProductCategory.action">
												<i class="fa fa fa-envelope fa-2x"></i><span> <s:text
														name="add.user.menus.product"></s:text></span>
											</a> <a class="quick-icons"
												href="settingSupportFAQCategory.action"> <i
												class="fa fa fa-comment fa-2x"></i><span><s:text
														name="add.user.menus.support"></s:text></span>
											</a>
											<hr
												style="margin-left: 15px; margin-right: 15px; margin-top: -10px;">
										</div>

									</div>

								</div>
								<div class="container-fluid">
									<div class="col-lg-12  col-md-12  col-sm-12 col-xs-12"
										style="margin-top: -10px;">
										<ul class="nav nav-tabs" role="tablist">
											<li role="presentation"><a
												href="settingFinanceTaxes.action"><s:text
														name="setting.finance.taxes" /> </a></li>
											<li role="presentation" class="active"><a
												href="settingFinanceGLaccount.action"
												style="color: Gray; background-color: #F9F9F9;"><s:text
														name="setting.finance.GLaccount" /></a></li>

										</ul>


										<!-- Tab panes -->
										<div id="content" style="background-color: #F9F9F9;">
											<!--BEGIN INPUT TEXT FIELDS-->
											<div class="row">
												<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
													<div class="box inverse"
														style="margin-top: -10px; margin-bottom: 0px;">


														<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
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
																			<s:text
																				name="setting.finance.GLaccount.information.bar" />
																		</div>
																	</div>
																</s:else>
															</p>
														</div>



														<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"
															style="margin-left: 5px;">
															<h5 class="innertitle">GL Account Details</h5>
															<hr style="margin-right: 5px; margin-top: -5px;">
														</div>

														<div class="row">

															<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">

																<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12"
																	style="margin-left: 35px;">
																	<s:text name="setting.finance.GLaccount.category.label"></s:text>
																	<div class="star">*</div>
																</div>
															</div>
															<div class="col-lg-9 col-md-9 col-sm-12 col-xs-12">
																<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">

																	<s:select list="glAccounttypeList" name="glAccounttype"
																		cssClass="form-control"></s:select>

																</div>
															</div>
														</div>

														<div class="row" style="margin-top: 20px;">
															<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
																<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12"
																	style="margin-left: 35px;">
																	<s:text name="setting.finance.GLaccount.name.label"></s:text>
																	<div class="star">*</div>
																</div>
															</div>
															<div class="col-lg-9 col-md-9 col-sm-12 col-xs-12">
																<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
																	<s:textfield type="text" name="glAccountName"
																		class="form-control" cssClass="form-control"
																		placeholder="GL Account Name" />
																	<div id='finanaceGLAccountForm_glAccountName_errorloc'
																		class="error_strings"></div>
																</div>
															</div>
														</div>

														<div class="row"
															style="margin-top: 10px; margin-left: 5px; margin-right: 5px;">
															<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
																<h5 class="innertitle">
																	<s:text name="setting.finance.glaccount.description" />
																</h5>
																<hr style="margin-top: -5px">
															</div>
														</div>

														<div class="form-group" style="margin-top: -15px;">
															<div class="row" style="margin: 1% 2%;" id="data_grid">
																<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
																	<s:textarea id="wysihtml5" name="description"
																		class="form-control" rows="10" tabindex="3">
																	</s:textarea>
																	<div id='finanaceGLAccountForm_description_errorloc'
																		class="error_strings"></div>
																</div>
															</div>
															<hr style="margin-left: 10px; margin-right: 10px;">
														</div>
														<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"
															align="center" style="margin-bottom: 5px;">
															<a href="omiInnerDashboard.action" data-toggle="tooltip"
																data-original-title="Cancel"
																class="btn btn-default btnheight"><i
																class="fa fa-caret-square-o-left fontawesomeht"></i> <s:text
																	name="project.form.button.cancel"></s:text></a> <a
																href="settingFinanceGLaccount.action"
																data-toggle="tooltip" data-original-title="Reset"
																class="btn btn-success btnheight"><i
																class="fa fa-refresh "></i> <s:text
																	name="project.form.button.reset"></s:text></a>
															<button type="submit" Class="btn btn-primary btnheight"
																data-toggle="tooltip" data-original-title="save"
																key="project.form.button.save" theme="simple">
																<i class="fa fa-check"></i>
																<s:text name="project.form.button.save"></s:text>
															</button>
														</div>


														<div id="dashboard_search_tools">
															<div class="row">
																<div class="col-lg-12  col-md-12  col-sm-12 col-xs-12"
																	style="margin-bottom: 2px;">

																	<div class="row"></div>
																</div>
															</div>
														</div>

														<table id="dataTable"
															class="table table-bordered table-condensed table-hover table-striped">
															<thead>
																<tr id="myrow">
																	<th style="width: 10%;"><s:text
																			name="setting.company.category.action"></s:text></th>
																	<%-- <th style="width: 20%;"><s:text
																		name="setting.finance.GLaccount.id"></s:text></th> --%>
																	<th style="width: 30%;"><s:text
																			name="setting.finance.GLaccount.category.label"></s:text></th>
																	<th><s:text
																			name="setting.finance.GLaccount.name.label"></s:text></th>
																	<%-- <th><s:text
																			name="setting.finance.GLaccount.description"></s:text></th> --%>
																</tr>
															</thead>
															<tbody>
																<s:iterator value="showFinanaceGLAccountList">
																	<tr>
																		<td align="center">

																			<div class="btn-group">
																				<a id="edit"
																					href="settingEditGLAccount.action?command=<s:property value='financeId'/>"
																					data-toggle="tooltip" data-original-title="Edit"
																					data-placement="bottom"> <i class="fa fa-edit"></i>
																				</a>
																			</div>

																			<div class="btn-group">
																				<a id="delete" href="" onclick=""
																					data-toggle="tooltip" data-original-title="Delete"
																					data-placement="bottom"> <i
																					class="fa fa-trash-o"></i>
																				</a>
																			</div>
																		</td>
																		<%-- <td><a style="color: blue" href=""><s:property
																				value='financeId' /></a></td>
 --%>
																		<td><s:property value="glAccounttype" /></td>
																		<td><s:property value="glAccount" /></td>
																		<%-- <td><s:property value="description" /></td> --%>

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
							</s:form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Modal1 -->


	<script>
		$(function() {
			Metis.formGeneral();
			Metis.formWysiwyg();
		});
	</script>
	<script type="text/javascript">
		var frmvalidator = new Validator("finanaceGLAccountForm");
		frmvalidator.EnableOnPageErrorDisplay();
		frmvalidator.EnableMsgsTogether();
		frmvalidator.addValidation("glAccountName", "req",
				"Please Enter GL Account Name");
		frmvalidator.addValidation("description", "maxlen=4000",
				"Please Enter GL Account Description below 4000");
		frmvalidator.addValidation("glAccounttype", "req",
				"Please Enter GL Account Type");
		frmvalidator.addValidation("glAccount", "maxlen=100",
				"Please Enter maxlen 100");
		frmvalidator.addValidation("glAccount", "minlen=3",
				"Please Enter Minlen 3");
	</script>
</body>
</html>