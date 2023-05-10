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
							<li class="active"><s:text name="add.user.menus.company"></s:text></li>

						</ol>
						<div class="box ">
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
									<a href="renderCompanySettings.action" data-toggle="tooltip"
										data-original-title="Refresh"
										class="btn btn-success btnheight"><i
										class="fa fa-refresh "></i></a> <a href="omiInnerDashboard.action"
										data-toggle="tooltip" data-original-title="Close"
										class="btn btn-danger btnheight"><i
										class="fa fa-times fontawesomeht"></i></a>
								</div>


								<!-- /.toolbar -->
							</header>
							<div class="row">
								<div class="container-fluid">

									<div class="col-lg-12  col-md-12 col-sm-12 col-xs-12"
										style="margin-top: 15px;">
										<a class="quick-icons" href="renderCompanySettings.action"
											data-toggle="tooltip" data-placement="right"
											data-original-title="Back To DashBoard" class="active"> <i
											class="fa fa-files-o fa-2x"></i> <span><s:text
													name="add.user.menus.company"></s:text></span> <%-- <span
											class="label label-default">2</span> --%>
										</a> <a class="quick-icons" href="" data-toggle="tooltip"
											data-placement="right"
											data-original-title="Back To DashBoard"> <i
											class="fa fa-user btniconcolor"></i> <span><s:text
													name="add.user.menus.user"></s:text></span>
										</a> <a class="quick-icons" href="#"> <i
											class="fa fa-exchange fa-2x"></i><span><s:text
													name="add.user.menus.finance"></s:text></span>
										</a> <a class="quick-icons" href="#"> <i
											class="fa fa-clipboard fa-2x"></i><span><s:text
													name="add.user.menus.marketing"></s:text></span>
										</a> <a class="quick-icons" href="#"> <i
											class="fa fa fa-envelope fa-2x"></i><span> <s:text
													name="add.user.menus.product"></s:text></span>
										</a> <a class="quick-icons" href="#"> <i
											class="fa fa fa-comment fa-2x"></i><span><s:text
													name="add.user.menus.support"></s:text></span>
										</a>
										<hr
											style="margin-left: 15px; margin-right: 15px; margin-top: -10px;">
									</div>

								</div>

							</div>



							<!-- Nav tabs -->
							<div class="container-fluid">
								<div class="col-lg-12  col-md-12  col-sm-12 col-xs-12"
									style="margin-top: -10px;">
									<ul class="nav nav-tabs" role="tablist">
										<li role="presentation" class="active"><a
											href="renderCompanySettings.action"
											style="color: Gray; background-color: #F9F9F9;"><s:text
													name="add.user.menus.company" /> </a></li>
										<li role="presentation"><a
											href="settingCompanyType.action" style="color: Gray;"><s:text
													name="add.user.menus.company.type" /></a></li>
										<li role="presentation"><a
											href="settingCompanyCategory.action" style="color: Gray;"><s:text
													name="add.user.menus.company.category" /></a></li>
										<li role="presentation"><a href="" style="color: Gray;"><s:text
													name="add.user.menus.company.sector" /></a></li>
										<li role="presentation"><a href="" style="color: Gray;"><s:text
													name="add.user.menus.company.local" /></a></li>
									</ul>


									<!-- Tab panes -->
									<div id="content" style="background-color: #F9F9F9;">
										<!--BEGIN INPUT TEXT FIELDS-->
										<div class="row">
											<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
												<div class="box inverse"
													style="margin-top: -10px; margin-bottom: 0px;">


													<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">

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


														<s:form class="form-horizontal"
															action="updateCompanySetting">

															<div class="row" style="margin-top: 20px;">
																<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
																	<h5>Company Information</h5>
																	<hr style="margin-top: -5px">
																</div>

															</div>

															<div class="row">
																<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
																	<div class="row form-group">
																		<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
																			<label for="text1" class="control-label col-lg-4">
																				Company Name</label>
																		</div>
																		<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
																			<div class="row">

																				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
																					<s:textfield cssClass="form-control"
																						name="companyName"></s:textfield>

																				</div>
																			</div>

																		</div>
																	</div>
																</div>


																<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
																	<div class="row form-group">
																		<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
																			<label for="text1" class="control-label col-lg-4">
																				Trade Name</label>
																		</div>

																		<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
																			<s:textfield cssClass="form-control"
																				name="tradeNname"></s:textfield>

																		</div>
																	</div>

																</div>
															</div>

															<div class="row">
																<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
																	<div class="row form-group">
																		<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
																			<label for="text1" class="control-label col-lg-4">
																				Company Type</label>
																		</div>
																		<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
																			<div class="row">

																				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
																					<s:select list="companyTypeList" headerKey="1"
																						cssClass="form-control chzn-select"
																						name="companyTypeName"></s:select>

																				</div>
																			</div>

																		</div>
																	</div>
																</div>


																<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
																	<div class="row form-group">
																		<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
																			<label for="text1" class="control-label col-lg-4">
																				Company Category</label>
																		</div>

																		<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">

																			<s:select list="companyCategoryList" headerKey="1"
																				cssClass="form-control chzn-select"
																				name="companyCategoryName"></s:select>
																		</div>
																	</div>

																</div>
															</div>

															<div class="row">
																<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
																	<div class="row form-group">
																		<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
																			<label for="text1" class="control-label col-lg-4">
																				Company Sector</label>
																		</div>
																		<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
																			<div class="row">

																				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
																					<s:select list="companySectorList" headerKey="1"
																						cssClass="form-control chzn-select"
																						name="companySectorName"></s:select>
																				</div>
																			</div>

																		</div>
																	</div>
																</div>


																<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
																	<div class="row form-group">
																		<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
																			<label for="text1" class="control-label col-lg-4">
																				Company Status</label>
																		</div>

																		<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
																			<s:textfield cssClass="form-control"
																				name="userStatus" disabled="true"></s:textfield>

																		</div>
																	</div>

																</div>

															</div>

															<div class="row">
																<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
																	<div class="row form-group">
																		<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
																			<label class="control-label col-lg-4">Created
																				By </label>
																		</div>
																		<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
																			<s:textfield cssClass="form-control" name="createdBy"
																				disabled="true"></s:textfield>
																		</div>
																	</div>
																</div>


																<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
																	<div class="row form-group">
																		<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
																			<label class="control-label col-lg-4">Created
																				Date </label>
																		</div>
																		<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
																			<s:textfield cssClass="form-control" name="createdBy"
																				disabled="true"></s:textfield>
																		</div>
																	</div>
																</div>


															</div>

															<div class="row" style="margin-top: 20px;">
																<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
																	<h5>Contact Information</h5>
																	<hr style="margin-top: -5px">
																</div>

															</div>


															<div class="row">
																<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">


																	<div class="row form-group">
																		<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
																			<label class="control-label col-lg-4">Address
																				Line1</label>
																		</div>
																		<div class="col-lg-8 col-md-8 col-sm-8 col-xs-8">
																			<s:textfield cssClass="form-control"
																				name="addressLine1"></s:textfield>
																		</div>

																	</div>
																</div>
																<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
																	<div class="row form-group">
																		<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
																			<label class="control-label col-lg-4">Address
																				Line2 </label>
																		</div>
																		<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
																			<s:textfield cssClass="form-control"
																				name="addressLine2"></s:textfield>
																		</div>
																	</div>
																</div>



															</div>
															<div class="row">

																<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
																	<div class="row form-group">
																		<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
																			<label class="control-label col-lg-4"> City </label>
																		</div>
																		<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
																			<s:textfield cssClass="form-control" name="city"></s:textfield>
																		</div>
																	</div>
																</div>
																<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
																	<div class="row form-group">
																		<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
																			<label class="control-label col-lg-4">State </label>
																		</div>
																		<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
																			<s:textfield cssClass="form-control" name="state"></s:textfield>
																		</div>
																	</div>
																</div>
															</div>



															<div class="row">

																<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
																	<div class="row form-group">
																		<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
																			<label class="control-label col-lg-4">Zipcode</label>
																		</div>
																		<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
																			<s:textfield cssClass="form-control" name="zipCode"></s:textfield>
																		</div>
																	</div>
																</div>
																<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
																	<div class="row form-group">
																		<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
																			<label class="control-label col-lg-4">Phone
																				Number</label>
																		</div>
																		<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
																			<s:textfield cssClass="form-control" name="phoneNo"></s:textfield>
																		</div>
																	</div>
																</div>
															</div>



															<div class="row">
																<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
																	<div class="row form-group">
																		<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
																			<label class="control-label col-lg-4">Mobile
																				Number</label>
																		</div>

																		<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
																			<s:textfield cssClass="form-control" name="mobileNo"></s:textfield>
																		</div>
																	</div>
																</div>
																<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
																	<div class="row form-group">
																		<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
																			<label class="control-label col-lg-4">Fax
																				Number </label>
																		</div>
																		<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
																			<s:textfield cssClass="form-control" name="faxNo"></s:textfield>
																		</div>
																	</div>
																</div>
															</div>

															<div class="row">


																<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
																	<div class="row form-group">
																		<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
																			<label class="control-label col-lg-4">Company
																				Email-Id</label>
																		</div>

																		<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
																			<s:textfield cssClass="form-control"
																				name="companyEmailId" disabled="true"></s:textfield>
																		</div>
																	</div>
																</div>
																<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
																	<div class="row form-group">
																		<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
																			<label class="control-label col-lg-4">Company
																				URL </label>
																		</div>
																		<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
																			<s:textfield cssClass="form-control"
																				name="companyUrl"></s:textfield>
																		</div>
																	</div>
																</div>
															</div>


															<div class="row">


																<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
																	<div class="row form-group">
																		<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
																			<label class="control-label col-lg-4">Country
																			</label>
																		</div>

																		<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
																			<s:select list="countryList" headerKey="1"
																				cssClass="form-control chzn-select"
																				name="countryName"></s:select>

																		</div>
																	</div>
																</div>
																<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
																	<div class="row form-group">
																		<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
																			<label class="control-label col-lg-4">Company
																				Admin</label>
																		</div>
																		<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
																			<s:textfield cssClass="form-control"
																				name="companyAdmin"></s:textfield>
																		</div>
																	</div>
																</div>
															</div>
															<div class="row" style="margin-top: 20px;">
																<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
																	<h5>Social Information</h5>
																	<hr style="margin-top: -5px">
																</div>
															</div>


															<div class="row">
																<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
																	<div class="row form-group">
																		<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
																			<label class="control-label col-lg-4">Facebook
																				URL </label>
																		</div>
																		<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
																			<s:textfield cssClass="form-control"
																				name="facebookDetail"></s:textfield>
																		</div>
																	</div>
																</div>
																<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
																	<div class="row form-group">
																		<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
																			<label class="control-label col-lg-4">Google
																				Plus URL </label>
																		</div>
																		<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
																			<s:textfield cssClass="form-control"
																				name="googlePlusDetail"></s:textfield>
																		</div>
																	</div>
																</div>
															</div>
															<div class="row">
																<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
																	<div class="row form-group">
																		<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
																			<label class="control-label col-lg-4">LinkedIN
																				URL</label>
																		</div>
																		<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
																			<s:textfield cssClass="form-control"
																				name="linkedInDetail"></s:textfield>
																		</div>
																	</div>
																</div>
																<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
																	<div class="row form-group">
																		<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
																			<label class="control-label col-lg-4">Twitter
																				URL</label>
																		</div>
																		<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
																			<s:textfield cssClass="form-control"
																				name="twitterDetail"></s:textfield>
																		</div>
																	</div>
																</div>
															</div>
															<div class="row">
																<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
																	<div class="row form-group">
																		<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
																			<label class="control-label col-lg-4">Blog
																				URL</label>
																		</div>
																		<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
																			<s:textfield cssClass="form-control"
																				name="blogDetail"></s:textfield>
																		</div>
																	</div>
																</div>
																<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
																	<div class="row form-group">
																		<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
																			<label class="control-label col-lg-4">Youtube
																				URL</label>
																		</div>
																		<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
																			<s:textfield cssClass="form-control"
																				name="youtubeDetail"></s:textfield>
																		</div>
																	</div>
																</div>
															</div>

															<div class="row" style="margin-top: 20px;">
																<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
																	<h5>Others</h5>
																	<hr style="margin-top: -5px">
																</div>
															</div>


															<div class="row">
																<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
																	<div class="row form-group">
																		<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
																			<label class="control-label col-lg-4">Timezone</label>
																		</div>
																		<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
																			<s:select cssClass="form-control chzn-select"
																				list="timeZoneList" name="timezoneName"></s:select>
																		</div>
																	</div>
																</div>
																<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
																	<div class="row form-group">
																		<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
																			<label class="control-label col-lg-4">
																				Currency</label>
																		</div>
																		<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
																			<s:select cssClass="form-control chzn-select"
																				list="currencyList" name="currency"></s:select>
																		</div>
																	</div>
																</div>
															</div>

															<div class="row">
																<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
																	<div class="row form-group">
																		<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
																			<label class="control-label col-lg-4">
																				Language</label>
																		</div>
																		<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
																			<s:select cssClass="form-control chzn-select"
																				list="languageList" name="language"></s:select>
																		</div>
																	</div>
																</div>
															</div>
													</div>
													<div class="row" style="margin-top: 20px;">
														<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
															<h5>Profile Image</h5>
															<hr style="margin-top: -5px">
														</div>
													</div>
													<div class="form-group">
														<div class="row">

															<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
																<div class="row">

																	<div
																		class="col-lg-8 col-lg-offset-4 col-md-8 col-md-offset-4 col-sm-12 col-xs-12">
																		<div class="fileinput fileinput-new"
																			data-provides="fileinput">
																			<div class="fileinput-new thumbnail"
																				style="width: 200px; height: 150px;">
																				<img data-src="holder.js/100%x100%" alt="...">
																			</div>
																			<div
																				class="fileinput-preview fileinput-exists thumbnail"
																				style="max-width: 200px; max-height: 150px;"></div>
																			<div>
																				<span class="btn btn-default btn-file"><span
																					class="fileinput-new">Select image</span> <s:file
																						type="file" name="userImage" /> <span
																					class="fileinput-exists">Change</span> <input
																					type="file" name="..."> </span> <a href="#"
																					class="btn btn-default fileinput-exists"
																					data-dismiss="fileinput">Remove</a>
																			</div>
																		</div>
																	</div>
																</div>

															</div>

														</div>
													</div>

													<hr>

													<div class="row">
														<div
															class="col-lg-4 col-md-4 col-sm-12 col-xs-12 col-md-offset-5">
															<a href="#" data-toggle="tooltip"
																data-original-title="Back To DashBoard"
																class="btn btn-default" ontheme="simple" tabindex="42"><s:text
																	name="project.form.button.cancel" /> </a>

															<s:reset cssClass="btn btn-success"
																key="project.form.button.reset" theme="simple"
																onclick="window.location.reload();" tabindex="43" />
															<s:submit cssClass="btn btn-primary"
																key="project.form.button.submit" theme="simple"
																tabindex="44" />
														</div>

													</div>
													<br>

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

		<!-- Modal1 -->
		<div class="modal fade" id="myModal" role="dialog">
			<div class="modal-dialog modal-lg">
				<div class="modal-content">
					<div class="modal-header"
						style="color: gray; background-color: #F8F8F8;">
						<button type="button" class="close" data-dismiss="modal"
							style="color: red; margin-top: -30px;">
							<h1>&times;</h1>
						</button>
						<h4 class="modal-title" style="color: gray;">Leads Reports</h4>
					</div>
					<div class="modal-body" style="color: gray;">
						<p>Hi, Walk-In 10-14 Aug.'15 for JAVA Developer(Freshers:0-1
							year)For our client comp. Which is leading software Development
							Company in India, provides services such as Outsourcing Software
							development, includes ERP and MRP systems, Web development,
							Product development, Offshore software development. If possible
							please send me few references suitable for the below roles if
							any. Post Details</p>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
				</div>
			</div>
		</div>

		<script>
			$(function() {
				Metis.formGeneral();
				Metis.formWysiwyg();
			});
		</script>
</body>
</html>