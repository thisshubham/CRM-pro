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
								<nav style="padding: 8px;"> <a href="javascript:;"
									class="btn btn-default btn-xs collapse-box"> <i
									class="fa fa-minus"></i>
								</a> <a href="javascript:;" class="btn btn-default btn-xs full-box">
									<i class="fa fa-expand"></i>
								</a> <a href="javascript:;" class="btn btn-danger btn-xs close-box">
									<i class="fa fa-times"></i>
								</a> </nav>
							</div>
							<!-- /.toolbar --> </header>
							<div class="container"
								style="margin-top: 20px; margin-bottom: 20px;">

								<!-- Nav tabs -->
								<ul class="nav nav-tabs" role="tablist">
									<li role="presentation" ><a
										href="userProfile"
										style="color: Gray;"><s:text
												name="myAccount.menu.userProfile" /></a></li>

									<li role="presentation" ><a
										href="userProfileSocialInformation"
										style="color: Gray;"><s:text
												name="myAccount.menu.social.information"></s:text> </a></li>
									<li role="presentation"><a
										href="userProfileSecurityChangePassword" style="color: Gray;"><s:text
												name="myAccount.menu.change.password"></s:text></a></li>
									<li role="presentation" class="active"><a
										href="userProfileSecurityChangeEmail" style=" background-color: #F9F9F9; color: Gray;"><s:text
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
													<span class="fa fa-info" style="margin-right: 10px;"></span>Update
													your E-Mail. Always set a strong password. Which help to
													prevent unauthorized access to your account
												</div>
												<s:form action="userProfileChangeEmail" name="changeEmail" method="POST">

													<div class="row">
														<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12"></div>
														<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
															<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
																<label for="text1" class="control-label col-lg-4" style="color:gray;">
																	<h5>Primary E-mail Id</h5> </label>
															</div>
															<div class="col-lg-9 col-md-9 col-sm-12 col-xs-12">

																<s:textfield name="eMail" placeholder="Primary E-mail"
																	cssClass="form-control"/>
																	<div id='changeEmail_eMail_errorloc'
																				class="error_strings"></div>
															</div>
														</div>
														<div class="col-lg-2 col-md-2 col-sm-12 col-xs-12">
														<s:submit cssClass="btn btn-success"
															key="project.form.button.submit" theme="simple" />
														</div>
														<div class="col-lg-1 col-md-1 col-sm-1 col-xs-1">
														
														</div>
													</div>

													<div class="row" style="margin-top: 20px;">
														<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12"></div>
														<div class="col-lg-2 col-md-2 col-sm-12 col-xs-12">
															
														</div>
														<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12"></div>
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
		var frmvalidator = new Validator("changeEmail");
		frmvalidator.EnableOnPageErrorDisplay();
		frmvalidator.EnableMsgsTogether();
		frmvalidator.addValidation("eMail", "req",
				"Enter Email ");
		
	</script>
</body>
</html>