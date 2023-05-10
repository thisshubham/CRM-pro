<%@ page import="com.bst.ckt.common.LoginUtil"%>
<%@taglib uri="/struts-tags" prefix="s"%>
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
							<li><a href="omiInnerDashboard.action"><i
									class="fa fa-home"></i></a></li>
							<li class="active"><s:text name="MyAccount"></s:text></li>
							<li class="active"><s:text name="myAccount.menu.userProfile"></s:text></li>

						</ol>
						<div class="box dark">
							<header>
								<a class="icons" href="dashboard.action" data-toggle="tooltip"
									data-original-title="Back To  DashBoard" style="color: Black;">
									<i class="fa fa-th-large"></i>
								</a>
								<h5>My Account</h5>

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
												<s:text name="myAccount.user.profile.info" />
											</div>
										</div>
									</s:else>
								</p>


								<ul class="nav nav-tabs" role="tablist">
									<li role="presentation" class="active"><a
										href="profileTemplet.action"
										style="background-color: #F9F9F9; color: Gray;"><s:text
												name="myAccount.menu.userProfile" /></a></li>
									<li role="presentation"><a
										href="myAccountSocialInformation.action" style="color: Gray;"><s:text
												name="myAccount.menu.social.information"></s:text> </a></li>
									<li role="presentation"><a
										href="changePasswordTemplet.action" style="color: Gray;"><s:text
												name="myAccount.menu.change.password"></s:text></a></li>
									<li role="presentation"><a
										href="changeEmailTemplet.action" style="color: Gray;"><s:text
												name="myAccount.menu.change.e-mail" /> </a></li>
									<li role="presentation"><a
										href="securityQuestionTemplet.action" style="color: Gray;"><s:text
												name="myAccount.menu.security.question"></s:text></a></li>
									<li role="presentation"><a
										href="closeAccountTemplet.action" style="color: Gray;"><s:text
												name="myAccount.menu.close.account" /></a></li>
									<li role="presentation"><a href="loggerTemplet.action"
										style="color: Gray;"><s:text name="myAccount.menu.logger" /></a></li>
								</ul>

								<!-- Tab panes -->
								<div id="content" style="background-color: #F9F9F9;">



									<!--BEGIN INPUT TEXT FIELDS-->
									<div class="row">
										<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
											<div class="box inverse"
												style="margin-top: 10px; margin-bottom: 0px;">


												<%-- <div class="alert alert-info" role="alert"
													style="margin-top: 25px; margin-left: 20px; margin-right: 20px;">
													<span class="fa fa-info" style="margin-right: 10px;"></span>
													<s:text name="myAccount.user.profile.info"></s:text>
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
															</div>&nbsp;&nbsp;&nbsp;
															<s:text name="myAccount.user.profile.info" />
														</s:else>

													</p>
												</div> --%>

												<s:form action="profileTempletUpdate" name="myAccountForm"
													enctype="multipart/form-data" method="post">
													<s:iterator value="customerVO" var="obj">
														<div class="row"
															style="margin-left: 7px; margin-bottom: -10px;">
															<div class="col-lg-3 col-md-3 col-sm-3 col-xs-12">
																<h5 class="innertitle">
																	<s:text
																		name="myAccount.user.profile.personal.information"></s:text>
																</h5>

															</div>

															<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12"></div>
															.
															<div class="col-lg-3 col-md-3 col-sm-3 col-xs-12"></div>

														</div>
														<hr style="margin-left: 20px; margin-right: 20px;">
														<div class="form-group">

															<div class="row" style="margin-top: 30px;">
																<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
																	<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
																		<div class="row form-group">
																			<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
																				<label for="text1" class="control-label col-lg-4">
																					<s:text name="myAccount.user.profile.customer.id" />
																				</label>
																			</div>
																			<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
																				<s:textfield name="customerId"
																					cssClass="form-control" disabled="true" />
																			</div>
																		</div>
																	</div>


																	<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
																		<div class="row form-group">
																			<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
																				<label for="text1" class="control-label col-lg-4">
																					<s:text name="myAccount.user.profile.status"></s:text>
																				</label>
																			</div>
																			<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
																				<s:textfield name="userStatus" disabled="true"
																					cssClass="form-control" />

																			</div>
																		</div>
																	</div>
																</div>
															</div>
														</div>



														<div class="form-group">
															<div class="row">
																<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">

																	<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
																		<div class="row form-group">
																			<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
																				<label for="text1" class="control-label col-lg-4">
																					<s:text name="myAccount.user.profile.full.name"></s:text>
																					<div class="star">*</div>
																				</label>
																			</div>
																			<div class="col-lg-2 col-md-2 col-sm-4 col-xs-4">
																				<s:select name="salutation" list="salutationList"
																					cssClass="form-control" />
																				<div id='myAccountForm_salutation_errorloc'
																					class="error_strings"></div>
																			</div>

																			<div class="col-lg-6 col-md-6 col-sm-8 col-xs-8">
																				<s:textfield name="fullName" placeholder="Full Name"
																					cssClass="form-control" />
																				<div id='myAccountForm_fullName_errorloc'
																					class="error_strings"></div>
																			</div>
																		</div>

																	</div>
																	<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
																		<div class="row form-group">
																			<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
																				<label for="text1" class="control-label col-lg-4">
																					<s:text name="myAccount.user.profile.dateOfBirth"></s:text>
																				</label>
																			</div>

																			<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
																				<s:textfield cssClass="form-control" id="dp5"
																					name="dateOfBirth" />
																				<div id='myAccountForm_dateOfBirth_errorloc'
																					class="error_strings"></div>
																			</div>
																		</div>
																	</div>
																</div>
															</div>
														</div>



														<!-- /.form-group -->
														<div class="form-group">
															<div class="row">
																<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">

																	<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
																		<div class="row form-group">
																			<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
																				<label for="text1" class="control-label col-lg-4">
																					<s:text name="myAccount.user.profile.gender"></s:text>
																				</label>
																			</div>
																			<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
																				<div class="row form-group">
																					<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
																						<s:radio name="gender" list="{'Male'}"></s:radio>
																					</div>
																					<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
																						<s:radio name="gender" list="{'Female'}"></s:radio>
																					</div>
																					<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
																					</div>
																				</div>
																				<div id='myAccountForm_gender_errorloc'
																					class="error_strings"></div>
																			</div>

																		</div>
																	</div>
																	<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
																		<div class="row form-group">
																			<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
																				<label for="text1" class="control-label col-lg-4">
																					<s:text name="myAccount.user.profile.e-mail.ID"></s:text>
																				</label>
																			</div>
																			<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
																				<s:textfield name="primaryEmailId"
																					cssClass="form-control" disabled="true" />

																			</div>
																		</div>
																	</div>

																</div>
															</div>
														</div>

														<!-- /.form-group -->
														<div class="form-group">
															<div class="row">
																<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
																	<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
																		<div class="row form-group">
																			<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
																				<label for="text1" class="control-label col-lg-4">
																					<s:text
																						name="myAccount.user.profile.alternate.emailID"></s:text>
																				</label>
																			</div>
																			<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
																				<s:textfield name="alternateEmailId"
																					cssClass="form-control" />
																				<div id='myAccountForm_alternateEmailId_errorloc'
																					class="error_strings"></div>
																			</div>
																		</div>
																	</div>

																	<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
																		<div class="row form-group">
																			<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
																				<label for="text1" class="control-label col-lg-4">
																					<s:text name="myAccount.user.profile.designation"></s:text>
																				</label>
																			</div>
																			<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
																				<s:textfield name="designation"
																					cssClass="form-control" disabled="true" />
																			</div>
																		</div>
																	</div>
																</div>
															</div>
														</div>

														<div class="form-group">
															<div class="row">
																<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
																	<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
																		<div class="row form-group">
																			<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
																				<label for="text1" class="control-label col-lg-4">
																					<s:text name="myAccount.user.profile.user.role"></s:text>
																				</label>
																			</div>
																			<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
																				<s:textfield name="userRole" cssClass="form-control"
																					disabled="true" />
																			</div>
																		</div>
																	</div>

																	<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
																		<div class="row form-group">
																			<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
																				<label for="text1" class="control-label col-lg-4">
																					<s:text name="myAccount.user.profile.department"></s:text>
																				</label>
																			</div>
																			<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
																				<s:textfield name="department"
																					cssClass="form-control" disabled="true" />
																			</div>
																		</div>
																	</div>
																</div>
															</div>
														</div>
														<!-- /.form-group -->
														<div class="form-group">
															<div class="row">
																<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
																	<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
																		<div class="row form-group">
																			<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
																				<label for="text1" class="control-label col-lg-4">
																					<s:text name="myAccount.user.profile.location"></s:text>
																				</label>
																			</div>
																			<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
																				<s:textfield name="location" cssClass="form-control" />
																			</div>
																		</div>
																	</div>
																</div>
															</div>
														</div>
														<!-- /.form-group -->
														<div class="row">
															<div class="col-lg-3 col-md-3 col-sm-3 col-xs-12">
																<h5 class="innertitle"
																	style="margin-left: 20px; margin-bottom: -5px;">
																	<s:text
																		name="myAccount.user.profile.contact.information"></s:text>
																</h5>
															</div>
															<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12"></div>

															<div class="col-lg-3 col-md-3 col-sm-3 col-xs-12"></div>
														</div>
														<hr style="margin-left: 20px; margin-right: 20px;">


														<!-- /.form-group -->

														<div class="form-group">
															<div class="row" style="margin-top: 30px;">
																<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">

																	<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
																		<div class="row form-group">
																			<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
																				<label class="control-label col-lg-4"> <s:text
																						name="myAccount.user.profile.address.line1"></s:text>
																				</label>
																			</div>
																			<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
																				<s:textfield name="addressLine1"
																					cssClass="form-control" />
																				<div id='myAccountForm_addressLine1_errorloc'
																					class="error_strings"></div>
																			</div>
																		</div>
																	</div>
																	<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
																		<div class="row form-group">
																			<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
																				<label class="control-label col-lg-4"><s:text
																						name="myAccount.user.profile.address.line2"></s:text></label>
																			</div>
																			<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
																				<s:textfield name="addressLine2"
																					cssClass="form-control" />
																				<div id='myAccountForm_addressLine2_errorloc'
																					class="error_strings"></div>
																			</div>
																		</div>
																	</div>
																</div>
															</div>
														</div>
														<!-- /.form-group -->

														<div class="form-group">
															<div class="row">
																<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">

																	<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
																		<div class="row form-group">
																			<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
																				<label class="control-label col-lg-4"> <s:text
																						name="myAccount.user.profile.city"></s:text>
																				</label>
																			</div>
																			<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
																				<s:textfield name="city" cssClass="form-control" />
																				<div id='myAccountForm_city_errorloc'
																					class="error_strings"></div>
																			</div>
																		</div>
																	</div>
																	<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
																		<div class="row form-group">
																			<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
																				<label class="control-label col-lg-4"> <s:text
																						name="myAccount.user.profile.state"></s:text>
																				</label>
																			</div>
																			<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
																				<s:textfield name="state" cssClass="form-control" />
																				<div id='myAccountForm_state_errorloc'
																					class="error_strings"></div>
																			</div>
																		</div>
																	</div>
																</div>
															</div>
														</div>
														<!-- /.form-group -->

														<div class="form-group">
															<div class="row">
																<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">

																	<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
																		<div class="row form-group">
																			<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
																				<label class="control-label col-lg-4"> <s:text
																						name="myAccount.user.profile.country"></s:text>
																					<div class="star">*</div>
																				</label>
																			</div>
																			<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
																				<s:select name="country" list="countryList"
																					headerKey="-1" headerValue="Select Country"
																					theme="css_xhtml" cssClass="form-control" />
																				<div id='myAccountForm_country_errorloc'
																					class="error_strings"></div>
																			</div>
																		</div>
																	</div>
																	<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
																		<div class="row form-group">
																			<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
																				<label class="control-label col-lg-4"> <s:text
																						name="myAccount.user.profile.zipCode"></s:text>

																				</label>
																			</div>
																			<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
																				<s:textfield name="zipcode" cssClass="form-control" />
																				<div id='myAccountForm_zipcode_errorloc'
																					class="error_strings"></div>
																			</div>
																		</div>
																	</div>
																</div>
															</div>
														</div>
														<!-- /.form-group -->

														<div class="form-group">
															<div class="row">
																<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">

																	<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
																		<div class="row form-group">
																			<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
																				<label class="control-label col-lg-4"><s:text
																						name="add.create.lead.phone" /></label>
																			</div>
																			<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
																				<s:textfield name="phoneNo" cssClass="form-control" />
																				<div id='myAccountForm_phoneNo_errorloc'
																					class="error_strings"></div>
																			</div>
																		</div>
																	</div>
																	<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
																		<div class="row form-group">
																			<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">

																				<label class="control-label col-lg-4"> <s:text
																						name="add.create.lead.mobile" />
																				</label>
																			</div>
																			<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
																				<s:textfield name="mobileNo" cssClass="form-control" />
																				<div id='myAccountForm_mobileNo_errorloc'
																					class="error_strings"></div>

																			</div>
																		</div>
																	</div>
																</div>
															</div>
														</div>
														<!-- /.form-group -->

														<div class="form-group">
															<div class="row">
																<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">

																	<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
																		<div class="row form-group">
																			<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
																				<label class="control-label col-lg-4"><s:text
																						name="add.create.lead.fax"></s:text></label>
																			</div>
																			<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
																				<s:textfield name="faxNo" cssClass="form-control" />
																				<div id='myAccountForm_faxNo_errorloc'
																					class="error_strings"></div>
																			</div>
																		</div>
																	</div>
																	<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
																		<div class="row form-group">
																			<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
																				<label class="control-label col-lg-4"><s:text
																						name="add.create.lead.website"></s:text></label>
																			</div>
																			<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
																				<s:textfield name="webSite" cssClass="form-control" />
																			</div>
																		</div>
																	</div>
																</div>
															</div>
														</div>


														<div class="row" style="margin-top: 20px;">
															<div class="col-lg-3 col-md-3 col-sm-3 col-xs-12">
																<h5 class="innertitle"
																	style="margin-left: 20px; margin-bottom: -5px;">
																	<s:text name="myAccount.user.profile.local.information" />
																</h5>
															</div>
															<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12"></div>
															.
															<div class="col-lg-3 col-md-3 col-sm-3 col-xs-12"></div>
														</div>
														<hr style="margin-left: 20px; margin-right: 20px;">

														<!-- /.form-group -->

														<div class="form-group">
															<div class="row" style="margin-top: 30px;">
																<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">

																	<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
																		<div class="row form-group">
																			<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
																				<label class="control-label col-lg-4"><s:text
																						name="add.client.language" /></label>
																			</div>
																			<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
																				<s:textfield name="language" cssClass="form-control"
																					disabled="true" />
																				<input type="hidden" name="languageId" />
																			</div>
																		</div>
																	</div>
																	<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
																		<div class="row form-group">
																			<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
																				<label class="control-label col-lg-4"><s:text
																						name="add.client.currency" /></label>
																			</div>
																			<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
																				<s:textfield name="currency" disabled="true"
																					cssClass="form-control" />
																				<input type="hidden" name="currencyId" />
																			</div>
																		</div>
																	</div>
																</div>
															</div>
														</div>


														<!-- /.form-group -->

														<div class="form-group">
															<div class="row">
																<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">

																	<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
																		<div class="row form-group">
																			<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
																				<label class="control-label col-lg-4"><s:text
																						name="contact.add.info.timezone" /></label>
																			</div>
																			<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
																				<s:textfield name="timeZone" cssClass="form-control"
																					disabled="true" />
																				<input type="hidden" name="timezoneId" />
																			</div>
																		</div>
																	</div>
																	<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
																		<div class="row form-group">
																			<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
																				<label class="control-label col-lg-4"> <s:text
																						name="myAccount.user.profile.profile.image"></s:text>

																				</label>
																			</div>
																			<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
																				<div class="fileinput fileinput-new"
																					data-provides="fileinput">
																					<div class="fileinput-new thumbnail"
																						style="width: 200px; height: 150px;">
																						<!-- 	<img data-src="holder.js/100%x100%" alt="..."> -->
																						<img alt="prifile"
																							src="profileImage/<%=LoginUtil.getCurrentCustomerUser()
							.getCustomerId()%>/<%=LoginUtil.getCurrentCustomerUser()
							.getCustomerId() + ".png"%>">
																					</div>
																					<div
																						class="fileinput-preview fileinput-exists thumbnail"
																						style="max-width: 200px; max-height: 150px;"></div>
																					<div>
																						<span class="btn btn-default btn-file"><span
																							class="fileinput-new"><s:text
																									name="myAccount.user.profile.select.image" /></span>
																							<span class="fileinput-exists"><s:text
																									name="myAccount.user.profile.change" /></span> <s:file
																								type="file" name="profileImage" /> </span> <a href="#"
																							class="btn btn-default fileinput-exists"
																							data-dismiss="fileinput"><s:text
																								name="myAccount.user.profile.remove" /></a>
																					</div>
																				</div>
																			</div>
																		</div>
																	</div>
																</div>
															</div>
														</div>
													</s:iterator>
													<div class="row"height: 60px;">
														<%-- <div class="col-lg-5 col-md-5 col-sm-12 col-xs-12"></div>
														<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12"
															style="margin-top: 15px; margin-left: 20px;">
															<a href="#" class="btn btn-default "><s:text
																	name="project.form.button.clear" /></a> <a href="#"
																class="btn btn-success "><s:text
																	name="project.form.button.submit" /></a>
														</div>
														<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12"></div> --%>
														<hr>
														<div class="row">
															<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"
																align="center">
																<a href="omiInnerDashboard.action" data-toggle="tooltip"
																	data-original-title="Cancel"
																	class="btn btn-default btnheight"><i
																	class="fa fa-caret-square-o-left fontawesomeht"></i> <s:text
																		name="project.form.button.cancel"></s:text></a> <a
																	href="profileTemplet.action" data-toggle="tooltip"
																	data-original-title="Reset"
																	class="btn btn-success btnheight"><i
																	class="fa fa-refresh "></i> <s:text
																		name="project.form.button.reset"></s:text></a>
																<button type="submit" data-toggle="tooltip"
																	data-original-title="Update"
																	class="btn btn-primary btnheight">
																	<i class="fa fa-check"></i>
																	<s:text name="project.form.button.Update"></s:text>
																</button>

															</div>
														</div>
													</div>
												</s:form>
												<br>
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
	</div>


	<script src="outer/js/gen_validatorv4.js" type="text/javascript"></script>
	<script type="text/javascript">
		var frmvalidator = new Validator("myAccountForm");
		frmvalidator.EnableOnPageErrorDisplay();
		frmvalidator.EnableMsgsTogether();

		frmvalidator.addValidation("salutation", "dontselect=8",
				"Select Salutataion");

		//Validation for Full Name. 
		frmvalidator.addValidation("fullName", "req", "Enter Your Full Name");
		frmvalidator.addValidation("fullName", "maxlen=50",
				"Name Should Be 50 Characters");

		//Validation for Date Of Birth.
		frmvalidator.addValidation("dateOfBirth", "req",
				"Enter Your Date Of Birht");

		//Validation for Gender. 
		frmvalidator.addValidation("gender", "selone", "Select Your Gender");

		//validation for Primary Email Id. 
		frmvalidator.addValidation("primaryEmailId", "req",
				"Enter Your Primary Email Id.");
		frmvalidator.addValidation("primaryEmailId", "email",
				"Enter Valid Email Id");
		frmvalidator.addValidation("primaryEmailId", "maxlen=50",
				"Primary Email Id Should Be 50 Characters");

		//Validation for Alter Email Id.
		frmvalidator.addValidation("alternateEmailId", "maxlen=50",
				"Primary Email Id Should Be 50 Characters");
		frmvalidator.addValidation("alternateEmailId", "email",
				"Enter Your Valid Email Id.");

		//validation for Address Line 1.
		frmvalidator.addValidation("addressLine1", "maxlen=150",
				"Address Line 1 Should Be 150 Characters");

		//validation for Address Line 2.
		frmvalidator.addValidation("addressLine2", "maxlen=150",
				"Address Line 2 Should Be 150 Characters");

		//validation for City.
		frmvalidator.addValidation("city", "maxlen=100",
				"City Should Be 100 Characters");

		//validation for State.
		frmvalidator.addValidation("state", "maxlen=100",
				"State Should Be 100 Characters");

		//validation for Country.
		frmvalidator.addValidation("country", "dontselect=-1",
				"Select Country Name");

		//validation for Phone Number.
		frmvalidator.addValidation("phoneNo", "maxlen=8",
				"Phone Number Should Be 8 Digits");
		frmvalidator.addValidation("phoneNo", "numeric",
				"Phone Number Must Be Digits");

		//validation for Mobile Number.
		frmvalidator.addValidation("mobileNo", "maxlen=10",
				"Mobile Number Should Be 10 Digits");
		frmvalidator.addValidation("mobileNo", "numeric",
				"Mobile Number Must Be Digits");

		//validation for Fax number.
		frmvalidator.addValidation("faxNo", "numeric",
				"Fax Number Must Be Digits");
		frmvalidator.addValidation("faxNo", "maxlen=8",
				"Fax Number Should Be 8 Digits");
	<%@taglib uri="/struts-jquery-tags" prefix="sj"%>
		function DoCustomValidation() {
			var frm1 = document.forms["myAccountForm"];
			var dob1 = frm1.dateOfBirth.value;
			var d1 = new Date(dob1); //from date yyyy-MM-dd
			var d2 = new Date(); //to date yyyy-MM-dd (taken currentdate)
			var Months = d2.getMonth() - d1.getMonth();
			var Years = d2.getFullYear() - d1.getFullYear();
			var Days = d2.getDate() - d1.getDate();
			Months = (d2.getMonth() + 12 * d2.getFullYear())
					- (d1.getMonth() + 12 * d1.getFullYear());
			var MonthOverflow = 0;
			if (Months - (Years * 12) < 0)
				MonthOverFlow = -1;
			else
				MonthOverFlow = 1;
			if (MonthOverFlow < 0)
				Years = Years - 1;
			Months = Months - (Years * 12);
			var LastDayOfMonth = new Date(d2.getFullYear(), d2.getMonth() + 1,
					0, 23, 59, 59);
			LastDayOfMonth = LastDayOfMonth.getDate();
			if (MonthOverFlow < 0 && (d1.getDate() > d2.getDate())) {
				Days = LastDayOfMonth + (d2.getDate() - d1.getDate()) - 1;
			} else
				Days = d2.getDate() - d1.getDate();
			if (Days < 0)
				Months = Months - 1;
			var l = new Date(d2.getFullYear(), d2.getMonth(), 0);
			var l1 = new Date(d1.getFullYear(), d1.getMonth() + 1, 0);
			if (Days < 0) {
				if (l1 > l)
					Days = l1.getDate() + Days;
				else
					Days = l.getDate() + Days;
			}

			if (Years <= 18) {
				sfm_show_error_msg(
						"Date of Birth should be more than 18 years from Today's Date",
						frm1.dateOfBirth);
				return false;
			} else {
				return true;
			}
		}

		frmvalidator.setAddnlValidationFunction(DoCustomValidation);
	</script>
	<script>
		$(function() {
			Metis.formGeneral();
			Metis.formWysiwyg();
		});
	</script>
</body>

