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
							<li class="active"><s:text name="myAccount.menu.close.account"></s:text></li>
							
						</ol>
						<div class="box dark">
							<header> <a class="icons" href="dashboard.action"
								data-toggle="tooltip" data-original-title="Back To  DashBoard"
								style="color: black;"> <i class="fa fa-th-large"></i>
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
											class="fa fa-refresh "></i></a>
									    <a href="leadDashboard.action"
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
													<s:text name="myaccount.close.account.inner.information.bar" />
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
									<li role="presentation"><a
										href="changePasswordTemplet.action" style="color: Gray;"><s:text
												name="myAccount.menu.change.password"></s:text></a></li>
									<li role="presentation"><a
										href="changeEmailTemplet.action" style="color: Gray;"><s:text
												name="myAccount.menu.change.e-mail" /> </a></li>
									<li role="presentation"><a
										href="securityQuestionTemplet.action" style="color: Gray;"><s:text
												name="myAccount.menu.security.question"></s:text></a></li>
									<li role="presentation" class="active"><a
										href="closeAccountTemplet.action"
										style="background-color: #F9F9F9; color: Gray;"><s:text
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
												style="margin-top: -10px; margin-bottom: 0px;">

												<s:form name="closeAccountForm" action="closeAccount" method="post">
													<%-- <div class="alert alert-info" role="alert"
														style="margin-top: 25px; margin-left: 5px; margin-right: 5px;">

														<p>
															<s:if test="hasActionErrors()">
															</s:if>
															<s:elseif test="hasActionMessages()">
																<s:actionmessage />
															</s:elseif>
															<s:else>

																<div class="infoIcon">
																	<span class="fa fa-info" style="margin-left: 3px;"></span>
																</div>&nbsp;&nbsp;&nbsp;<s:text
																	name="myaccount.close.account.inner.information.bar" />
															</s:else>
														</p>
													</div> --%>
													<div class="form-group"style="margin-top: 25px; margin-left: 5px; margin-right: 5px;">
														<div class="row" >
															<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
																<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12"></div>
																<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
																	<div class="row">
																		<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
																			<s:text
																				name="myaccount.close.account.curent.password" />
																			<div class="star">*</div>
																		</div>
																		<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
																			<s:textfield type="password" name="Password"
																				cssClass="form-control"
																				placeholder="Current Password" />
																			<div id='closeAccountForm_currentPassword_errorloc'
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
																			<s:text name="myaccount.close.account.coment" />
																			<div class="star">*</div>
																		</div>
																		<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
																			<s:textfield type="text" name="comment"
																				cssClass="form-control" placeholder="Comment" />
																			<div id='closeAccountForm_comment_errorloc'
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
																			<s:text name="myaccount.close.account.reason" />
																		</div>
																		<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
																			<div class="checkbox">
																				<h5>
																					<label> <input class="uniform" type="radio"
																						name="optionsRadios" value="Nothappy" checked>&nbsp;&nbsp;Nothappy
																					</label>
																				</h5>
																				<br style="margin-top: -30px;">
																				<h5>
																					<label> <input class="uniform" type="radio"
																						name="optionsRadios" value="Notusefull" checked>&nbsp;&nbsp;Notusefull
																					</label>
																				</h5>
																				<br style="margin-top: -30px;">
																				<h5>
																					<label> <input class="uniform" type="radio"
																						name="optionsRadios" value="Move to Alternative" checked>&nbsp;&nbsp;Move
																						to Alternative
																					</label>
																				</h5>
																			</div>
																		</div>
																	</div>
																</div>
																<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12"></div>
															</div>
														</div>
													</div>
													<hr>
													<div class="row" style="background-color:; height: 60px; margin-top:-20px;">
														<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12"></div>
														<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12"
															style="margin-top: 15px; margin-left: 20px;">
															<a href="leadDashboard.action" data-toggle="tooltip"
																data-original-title="Back To DashBoard"
																class="btn btn-default" ontheme="simple"><i
																class="fa fa-caret-square-o-left fontawesomeht"></i> <s:text
																	name="project.form.button.cancel" /> </a>
                                                  
															<button type="reset" Class="btn btn-success btnheight" class="fa fa-refresh"
															data-toggle="tooltip" data-original-title="Reset"
																key="project.form.button.reset" theme="simple"
																onclick="window.location.reload();" ><i class="fa fa-refresh"></i>
																<s:text name="project.form.button.reset"></s:text></button>

															<s:submit cssClass="btn btn-primary"
																key="project.form.button.submit" theme="simple" />
														</div>
														<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12"></div>
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
	<script src="/outer/js/gen_validatorv4.js" type="text/javascript"></script>
	<script type="text/javascript">
		var frmvalidator = new Validator("closeAccountForm");
		frmvalidator.EnableOnPageErrorDisplay();
		frmvalidator.EnableMsgsTogether();
		frmvalidator.addValidation("currentPassword", "req",
				"Enter Current Password.");
		frmvalidator
				.addValidation("comment", "req", "Please Add Your Comment.");
	</script>
</body>
</html>