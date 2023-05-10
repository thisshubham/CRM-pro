
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="/struts-jquery-tags" prefix="sj"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
							<li class="active"><s:text
									name="myAccount.menu.change.password"></s:text></li>

						</ol>
						<div class="box dark">
							<header> <a class="icons" href="dashboard.action"
								data-toggle="tooltip" data-original-title="Back To  DashBoard"
								style="color: Black;"> <i class="fa fa-th-large"></i>
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

							<!-- /.toolbar --> </header>
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
												<s:text name="myaccount.change.password.information.bar" />
											</div>
										</div>
									</s:else>
								</p>
								<!-- Nav tabs -->
								<ul class="nav nav-tabs" role="tablist">
									<li role="presentation"><a href="profileTemplet.action"
										style="color: Gray;"><s:text
												name="myAccount.menu.userProfile" /></a></li>

									<li role="presentation"><a
										href="myAccountSocialInformation.action" style="color: Gray;"><s:text
												name="myAccount.menu.social.information"></s:text> </a></li>
									<li role="presentation" class="active"><a
										href="changePasswordTemplet.action"
										style="background-color: #F9F9F9; color: Gray;"><s:text
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
												style="margin-top: 15px; margin-bottom: 0px;">

												<s:form action="profileTempletUpdatePassword"
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
																				name="oldPassword" cssClass="form-control" />

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
																			<s:textfield type="password" name="password"
																				id="text1" cssClass="form-control" />
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
																			<s:textfield type="password" name="reenterPassword"
																				id="text1" cssClass="form-control" />
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
															align="center" style="margin-bottom: 5px;">
															<a href="omiInnerDashboard.action" data-toggle="tooltip"
																data-original-title="Cancel"
																class="btn btn-default btnheight"><i
																class="fa fa-caret-square-o-left fontawesomeht"></i> <s:text
																	name="project.form.button.cancel"></s:text></a> <a
																href="changePasswordTemplet.action"
																data-toggle="tooltip" data-original-title="Reset"
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
		frmvalidator.addValidation("oldPassword", "req", "Enter Old Password");
		frmvalidator.addValidation("password", "req", "Enter New Password");
		frmvalidator.addValidation("reenterPassword", "req",
				"Re-enter New Password");
	</script>

</body>
</html>