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
							<li><a href="renderCompanySettings.action"><s:text
										name="add.user.menus.company"></s:text></a></li>
							<li class="active"><s:text
									name="setting.company.Country.navigation"></s:text></li>
							<li class="active"><s:text
									name="setting.company.Country.edit.navigation"></s:text></li>

						</ol>
						<div class="box ">
							<s:form class="form-horizontal" action="updateCompanyCountry"
								name="settingeditCountryForm">
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
											data-original-title="help"><i class="fa fa-question"></i>
											<s:text name="project.form.button.help"></s:text> </a>
										<button type="submit" data-toggle="tooltip"
											data-original-title="save" class="btn btn-primary btnheight">
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
												href="renderCompanySettings.action"><s:text
														name="add.user.menus.company" /> </a></li>
											<li role="presentation"><a
												href="settingCompanyType.action"><s:text
														name="add.user.menus.company.type" /></a></li>
											<li role="presentation"><a
												href="settingCompanyCategory.action"><s:text
														name="add.user.menus.company.category" /></a></li>
											<li role="presentation"><a
												href="settingCompanySector.action"><s:text
														name="add.user.menus.company.sector" /></a></li>
											<li role="presentation" class="active"><a
												href="settingCompanyCountry.action"
												style="background-color: #F9F9F9"><s:text
														name="add.user.menus.company.country" /></a></li>
											<li role="presentation"><a
												href="settingCompanyTimezone.action" style="color: Gray;"><s:text
														name="add.user.menus.company.timezone" /></a></li>
											<li role="presentation"><a
												href="settingCompanyCountry.action" style="color: Gray;"><s:text
														name="add.user.menus.currency" /></a></li>
											<li role="presentation"><a
												href="settingCompanyCountry.action" style="color: Gray;"><s:text
														name="add.user.menus.language" /></a></li>
										</ul>


										<!-- Tab panes -->
										<div id="content">
											<!--BEGIN INPUT TEXT FIELDS-->
											<div class="row">
												<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
													<div class="box inverse"
														style="margin-top: -40px; margin-bottom: 0px;">
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
																				name="add.setting.company.Country.edit.infobar" />
																		</div>
																	</div>
																</s:else>
															</p>
														</div>


														<div class="form-group" style="background-color: #F9F9F9">

															<div class="row" style="margin-top: 30px;">
																<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
																	<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
																		<div class="row form-group">
																			<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
																				<label for="text1" class="control-label col-lg-4">
																					<s:text name="setting.company.label.Country.name" />
																				</label>
																			</div>
																			<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
																				<s:textfield type="text" name="countryname"
																					placeholder="Enter Country Name"
																					cssClass="form-control"></s:textfield>
																				<div
																					id='settingeditCountryForm_countryname_errorloc'
																					class="error_strings"></div>
																			</div>
																		</div>
																	</div>


																	<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
																		<div class="row form-group">
																			<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
																				<s:text name="setting.company.label.isd.code" />
																			</div>
																			<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
																				<s:textfield type="text" name="isdCode"
																					placeholder="Enter ISD Code "
																					cssClass="form-control"></s:textfield>
																				<div id='settingeditCountryForm_isdCode_errorloc'
																					class="error_strings"></div>

																			</div>
																		</div>
																	</div>
																</div>
															</div>
															<div class="row" style="margin-top: 30px;">
																<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
																	<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
																		<div class="row form-group">
																			<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
																				<label for="text1" class="control-label col-lg-4">
																					<s:text name="setting.company.label.country.code" />
																				</label>
																			</div>
																			<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
																				<s:textfield type="text" name="countryCode"
																					cssClass="form-control"
																					placeholder="Enter Country Code"></s:textfield>
																				<div
																					id='settingeditCountryForm_countryCode_errorloc'
																					class="error_strings"></div>
																			</div>
																		</div>
																	</div>
																	<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
																		<div class="row form-group">
																			<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
																				<label for="text1" class="control-label col-lg-4">
																					<s:text
																						name="setting.company.label.country.display.name" />
																				</label>
																			</div>
																			<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">

																				<s:textfield type="text" name="countrydisplayName"
																					cssClass="form-control"
																					placeholder="Enter Country Display Name"></s:textfield>
																				<div
																					id='settingeditCountryForm_countrydisplayName_errorloc'
																					class="error_strings"></div>
																			</div>
																		</div>
																	</div>
																</div>
															</div>

														</div>
														<hr>

														<div class="row">
															<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"
																align="center">
																<a href="omiInnerDashboard.action" data-toggle="tooltip"
																	data-original-title="cancel"
																	class="btn btn-default btnheight" ontheme="simple"><i
																	class="fa fa-caret-square-o-left fontawesomeht"></i> <s:text
																		name="project.form.button.cancel" /> </a> <a
																	href="settingCompanyCountry.action"
																	data-toggle="tooltip" data-original-title="reset"
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
														</div>
														<div id="dashboard_search_tools">
															<div class="row">
																<div class="col-lg-12  col-md-12  col-sm-12 col-xs-12"
																	style="margin-bottom: 2px;">

																	<div class="row"></div>
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
		var frmvalidator = new Validator("settingeditCountryForm");
		frmvalidator.EnableOnPageErrorDisplay();
		frmvalidator.EnableMsgsTogether();
		frmvalidator.addValidation("countryname", "req",
				"Please Enter Country Name");
		frmvalidator.addValidation("countryCode", "req",
				"please Enter Country Code");
		frmvalidator.addValidation("isdCode", "req", "please Enter ISD Code");
		frmvalidator.addValidation("countrydisplayName", "req",
				"please Enter Country Display Name");
	</script>
</body>
</html>