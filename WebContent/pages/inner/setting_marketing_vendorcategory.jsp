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
									name="setting.marketing.navigation.bar"></s:text></li>
							<li class="active"><s:text
									name="setting.marketing.vendorcategory.navigation.bar"></s:text></li>

						</ol>
						<div class="box ">
							<s:form class="form-horizontal"
								action="insertVendorCategoryDetails" name="vendorcategoryform">
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
												href="settingMarketingLeadSource.action"><s:text
														name="setting.marketing.leadsource" /> </a></li>
											<li role="presentation"><a
												href="settingMarketingAccountType.action"><s:text
														name="setting.marketing.accounttype" /></a></li>
											<%-- <li role="presentation"><a
												href="settingMarketingSLAName.action"><s:text
														name="setting.marketing.slaname" /></a></li> --%>
											<li role="presentation"><a
												href="settingMarketingCampaignType.action"><s:text
														name="setting.marketing.campaigntype" /></a></li>
											<li role="presentation"><a
												href="settingMarketingResponse.action"><s:text
														name="setting.marketing.response" /></a></li>
											<li role="presentation" class="active"><a
												href="settingMarketingVendorCategory.action"
												style="color: Gray; background-color: #F9F9F9;"><s:text
														name="setting.marketing.vendorcategory" /></a></li>
											<li role="presentation"><a
												href="settingMarketingTravelMode.action"><s:text
														name="setting.marketing.travelmode" /></a></li>

										</ul>


										<!-- Tab panes -->
										<div id="content" style="background-color: #F9F9F9;">
											<!--BEGIN INPUT TEXT FIELDS-->
											<div class="row">
												<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
													<div class=""
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
																				name="setting.marketing.vendorcategory.information.bar" />
																		</div>
																	</div>
																</s:else>
															</p>
														</div>

														<div class="row">
															<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12"></div>
															<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
																<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
																	<s:text name="setting.marketing.vendorcategory.label"></s:text>
																	<div class="star">*</div>
																</div>
																<div class="col-lg-9 col-md-9 col-sm-12 col-xs-12">

																	<s:textfield type="text" name="vendorcategory"
																		class="form-control" cssClass="form-control" />
																	<div id='vendorcategoryform_vendorcategory_errorloc'
																		class="error_strings"></div>
																</div>
															</div>
															<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12"
																align="center">
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

														<table id="dataTable"
															class="table table-bordered table-condensed table-hover table-striped">
															<thead>
																<tr id="myrow">
																	<th style="width: 10%;"><s:text
																			name="setting.company.category.action"></s:text></th>
																	<th style="width: 20%;"><s:text
																			name="setting.marketing.vendorcategory.id"></s:text></th>
																	<th><s:text
																			name="setting.marketing.vendorcategory.label"></s:text></th>
																</tr>
															</thead>
															<tbody>
																<s:iterator value="showMarketingVendorcategoryList">
																	<tr>
																		<td align="center">

																			<div class="btn-group">
																				<a id="edit"
																					href="settingEditVendorCategory.action?command=<s:property value='vendorCategoryId'/>"
																					data-toggle="tooltip" data-original-title="Edit"
																					data-placement="bottom"> <i class="fa fa-edit"></i>
																				</a>
																			</div>
																			<div class="btn-group">
																				<a id="delete" href="#" onclick=""
																					data-toggle="tooltip" data-original-title="Delete"
																					data-placement="bottom"> <i
																					class="fa fa-trash-o"></i>
																				</a>
																			</div>
																		</td>
																		<td><a style="color: blue" href=""><s:property
																					value='vendorCategoryId' /></a></td>
																		<td><s:property value="vendorcategory" /></td>

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
		var frmvalidator = new Validator("vendorcategoryform");
		frmvalidator.EnableOnPageErrorDisplay();
		frmvalidator.EnableMsgsTogether();
		frmvalidator.addValidation("vendorcategory", "req",
				"Please Enter Vendor Category");
		frmvalidator.addValidation("vendorcategory", "maxlen=100",
				"Please Enter maxlen 100");
		frmvalidator.addValidation("vendorcategory", "minlen=3",
				"Please Enter Minlen 3");
	</script>
</body>
</html>