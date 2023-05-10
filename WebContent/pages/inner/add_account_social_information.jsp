<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="/struts-jquery-tags" prefix="sj"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="inner/assets/js/modal.js"></script>
<style type="text/css">
.error_strings {
	color: red;
}
</style>
</head>
<body>

	<s:form name="addAccountSocialForm"
		action="addAccountSocialInformation" method="POST">
		<div id="content">
			<div class="outer">
				<div class="inner bg-light lter">

					<!--BEGIN INPUT TEXT FIELDS-->
					<div class="row">
						<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
							<ol class="breadcrumb" style="margin-top: 10px;">
								<li><a href="omiInnerDashboard.action"><i
										class="fa fa-home"></i></a></li>
								<li><a href="renderAccountsDashboard.action"><s:text
											name="Accounts"></s:text></a></li>
								<li class="active"><s:text name="Accounts Dashboard"></s:text></li>
								<li class="active"><s:text name="Edit Account"></s:text></li>
							</ol>
							<div class="box">
								<header>
								<div class="pull-left">
									<a class="icons" href="renderAccountsDashboard.action"
										data-toggle="tooltip"
										data-original-title="Back To Accounts DashBoard"
										style="color: black;"> <i class="fa fa-th-large"></i>
									</a>
									<h5>
										<s:text name="Edit -Account Information" />
									</h5>
								</div>
								<div class="pull-right">
									<div class="btn-group">
										<a class="btn btn-default btnheight" data-toggle="tooltip"
											data-original-title="Help"><i class="fa fa-question"></i>
											<s:text name="project.form.button.help"></s:text></a>
										<button type="submit" data-toggle="tooltip"
											data-original-title="Save" class="btn btn-primary btnheight">
											<i class="fa fa-check"> </i>
											<s:text name="project.form.button.save"></s:text>
										</button>
										<a class="btn btn-info btnheight" data-toggle="tooltip"
											data-original-title="Convert"><i class="fa fa-random"></i>
											<s:text name="project.form.button.convert"></s:text></a> <a
											type="button" onclick="window.location.reload();"
											data-toggle="tooltip" data-original-title="Refresh"
											class="btn btn-success btnheight"><i
											class="fa fa-refresh "></i> </a> <a
											href="renderAccountClone.action"
											class="btn btn-warning btnheight" data-toggle="tooltip"
											data-original-title="Clone"><i class="fa fa-users"></i>&nbsp;<s:text
												name="project.form.button.clone"></s:text></a> <a
											href="populatePreviousAccount.action" data-toggle="tooltip"
											data-original-title="Previous" type="button"
											class="btn btn-default btnheight"><i
											class="fa fa-chevron-left fontawesomeht"></i></a> <a
											data-toggle="tooltip" data-original-title="Next"
											href="populateNextAccount.action"
											class="btn btn-default btnheight"><i
											class="fa fa-chevron-right fontawesomeht"></i></a> <a
											data-toggle="tooltip" data-original-title="Close"
											href="renderAcccountsDashboard.action"
											class="btn btn-danger btnheight"><i
											class="fa fa-times fontawesomeht"></i></a>
									</div>
								</div>
								</header>
								<div class="container-fluid"
									style="margin-top: 15px; margin-bottom: 15px;">

									<!-- nav bar-->
									<ul class="nav nav-tabs" role="tablist">
										<li role="presentation"><a
											href="populatAccountInformation.action?command=<s:property value="accountId"/>"
											style="color: gray;"><s:text name="Account Information" /></a></li>
										<li role="presentation" class="active"><a
											href="renderAccountSocialInformation.action"
											style="color: gray; background-color: #F9F9F9;"> <s:text
													name="Account Social" />
										</a></li>
										<!--end of nav bar-->
									</ul>
									<!-- info bar -->
									<p>
										<s:if test="hasActionErrors()">
											<div class="alert alert-danger" role="alert"
												style="margin-top: 25px; padding-bottom: 7px;">
												<div class="infoIcon">
													
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
													<s:text name="add.create.lead.information.bar" />
												</div>
											</div>
										</s:else>
									</p>
									<!--end of info bar -->
									<div class="row">
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="add.lead.social.socialcontact" />
													<div class="star">*</div>
												</div>

												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:select list="socialSiteValueList" headerKey="-1"
														headerValue="Select Social Type" name="socialSiteRef"
														cssClass="form-control chzn-select" />
													<div id='addAccountSocialForm_socialSiteRef_errorloc'
														class="error_strings"></div>
												</div>

											</div>
										</div>


										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="add.lead.social.table.socialname" />
													<div class="star">*</div>
												</div>
												<div class="col-lg-6 col-md-6 col-sm-9 col-xs-9">
													<s:textfield name="socialContactValue"
														cssClass="form-control" />
													<div id='addAccountSocialForm_socialContactValue_errorloc'
														class="error_strings"></div>
												</div>
												<div class="col-lg-1 col-md-1 col-sm-2 col-xs-2"
													style="padding-right: 5px;">
													<ul class="nav nav-tabs pull-right">
														<li><s:submit cssClass="btn btn-primary"
																key="project.form.button.add" theme="simple" /></li>
													</ul>
												</div>
											</div>
										</div>
									</div>

									<div class="row " class="tab-pane fade" id="addSocial">
										<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"
											id="dataTable">
											<div class="table-responsive" style="padding-right: 20px;">
												<table class="table table-bordered responsive-table">
													<thead>
														<tr id="myrow">
															<th style="width: 4%;"><s:text
																	name="add.lead.social.table.action" /></th>
															<th><s:text name="add.lead.social.table.social" /></th>
															<th><s:text name="add.lead.social.table.socialname" /></th>
														</tr>
													</thead>
													<tbody>
														<s:iterator value="accountSocialInformationGrid">
															<tr>
																<td align="center"><a href="#"
																	class="btn btn-danger btn-xs"> <i
																		class="fa fa-trash-o"></i>
																</a></td>
																<td><s:property value="socialSiteRefName" /></td>
																<td><s:property value="socialContactValue" /></td>
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
					</div>
				</div>
			</div>
		</div>
		</div>
		</div>
	</s:form>

	<script type="text/javascript">
		var frmvalidator = new Validator("addAccountSocialForm");
		frmvalidator.EnableOnPageErrorDisplay();
		frmvalidator.EnableMsgsTogether();

		frmvalidator.addValidation("socialSiteRef", "dontselect=-1",
				"Select Social Contact Type");

		frmvalidator.addValidation("socialContactValue", "req",
				"Enter Social Contact");
		frmvalidator.addValidation("socialContactValue", "maxlen=100",
				"Social Contact Should 100 Char");
		frmvalidator.addValidation("socialContactValue", "minlen=3",
				"Social Contact Should Be 3 Char");
	</script>

</body>
</html>