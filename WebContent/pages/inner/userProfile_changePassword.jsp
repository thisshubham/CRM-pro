
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
						<div class="box inverse">
							<header>
								<div class="icons">
									<i class="fa fa-th-large"></i>
								</div>
								<h5>User Management</h5>

								<!-- .toolbar -->
								<div class="toolbar">
									<nav style="padding: 8px;">
										<a href="javascript:;"
											class="btn btn-default btn-xs collapse-box"> <i
											class="fa fa-minus"></i>
										</a> <a href="javascript:;"
											class="btn btn-default btn-xs full-box"> <i
											class="fa fa-expand"></i>
										</a> <a href="javascript:;"
											class="btn btn-danger btn-xs close-box"> <i
											class="fa fa-times"></i>
										</a>
									</nav>
								</div>
								<!-- /.toolbar -->
							</header>
							<div class="container"
								style="margin-top: 20px; margin-bottom: 20px;">

								<!-- Nav tabs -->
								<ul class="nav nav-tabs" role="tablist">
									<li role="presentation"><a href="userProfile"
										style="color: Gray;"><s:text
												name="myAccount.menu.userProfile" /></a></li>

									<li role="presentation"><a
										href="userProfileSocialInformation" style="color: Gray;"><s:text
												name="myAccount.menu.social.information"></s:text> </a></li>
									<li role="presentation" class="active"><a
										href="userProfileSecurityChangePassword"
										style="background-color: #F9F9F9; color: Gray;"><s:text
												name="myAccount.menu.change.password"></s:text></a></li>
									<li role="presentation"><a
										href="userProfileSecurityChangeEmail" style="color: Gray;"><s:text
												name="myAccount.menu.change.e-mail" /> </a></li>
									
									<li role="presentation"><a href="userProfileloggerTemplet"
										style="color: Gray;"><s:text name="myAccount.menu.logger" /></a></li>
								</ul>

								<!-- Tab panes -->
								<div id="content" style="background-color: #F9F9F9;">



									<!--BEGIN INPUT TEXT FIELDS-->
									<div class="row">
										<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
											<div class="box inverse"
												style="margin-top: -10px; margin-bottom: 0px;">


												
												<div class="alert alert-info" role="alert"
													style="margin-top: 25px; margin-left: 20px; margin-right: 20px;">
													
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
															<s:text name="myaccount.change.password.information.bar" />
														</s:else>

													</p>
												</div>
												<s:form action="UpdateUserPassword.action"
													name="changePassword" class="form-horizontal"
													id="block-validate">
													<div class="form-group">
														<div class="row">
															<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
																<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12"></div>
																<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
																	
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

																		</div>
																		<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
																			<s:textfield type="password" name="password"
																				id="text1" placeholder="New Password"
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

																		</div>
																		<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
																			<s:textfield type="password" name="reenterPassword"
																				id="text1" placeholder="Re-enter Password"
																				cssClass="form-control" />
																			<div id='changePassword_reenterPassword_errorloc'
																				class="error_strings"></div>
																		</div>
																	</div>
																</div>
																<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12"></div>


															</div>
														</div>
<hr>

													</div>

													<div
														class="col-lg-4 col-md-4 col-sm-12 col-xs-12 col-md-offset-5">
														<s:reset cssClass="btn btn-default"
															key="project.form.button.cancel" theme="simple" />
														<s:reset cssClass="btn btn-success"
															onclick="window.location.reload();"
															key="project.form.button.reset" theme="simple" />

														<s:submit cssClass="btn btn-primary"
															key="project.form.button.update" theme="simple" />

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
		
		frmvalidator.addValidation("password", "req", "Enter New Password");
		frmvalidator.addValidation("reenterPassword", "req",
				"Re-enter New Password");
	</script>

</body>
</html>