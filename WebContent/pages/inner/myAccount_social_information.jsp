
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="/struts-jquery-tags" prefix="sj"%>

<title><s:text
		name="myAccount.menu.myAccount.social.site.information" /></title>
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
									name="myAccount.menu.social.information"></s:text></li>

						</ol>
						<div class="box dark">
							<header>
								<a class="icons" href="dashboard.action" data-toggle="tooltip"
									data-original-title="Back To  DashBoard" style="color: black;">
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
												<s:text name="myAccount.social.information.inner.bar" />
											</div>
										</div>
									</s:else>
								</p>
								<!-- Nav tabs -->
								<ul class="nav nav-tabs" role="tablist">
									<li role="presentation"><a href="profileTemplet.action"
										style="color: Gray;"><s:text
												name="myAccount.menu.userProfile" /></a></li>

									<li role="presentation" class="active"><a
										href="myAccountSocialInformation.action"
										style="background-color: #F9F9F9; color: Gray;"><s:text
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
												style="margin-top: 15px; margin-bottom: 0px; padding-left: 20px;">

												<s:form name="addCustomerSocialForm"
													action="addCustomerSocialInformation">
													<s:iterator value="customerVO" var="obj">
														<div class="row">

															<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
																<div class="row form-group">

																	<div class="col-lg-3 col-md-3 col-sm-12 col-xs-6">
																		<s:text name="add.lead.social.socialcontact" />
																		<div class="star">*</div>
																	</div>

																	<div class="col-lg-8 col-md-8 col-sm-12 col-xs-6">
																		<s:select list="customerSocialSiteValueList"
																			headerKey="-1" headerValue="Select Social Type"
																			name="socialSiteRef"
																			cssClass="form-control chzn-select" />
																		<div id='addCustomerSocialForm_socialSiteRef_errorloc'
																			class="error_strings"></div>
																	</div>

																</div>
															</div>


															<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
																<div class="row form-group">
																	<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
																		<s:text name="add.lead.social.addnewsocial" />
																		<div class="star">*</div>
																	</div>
																	<div class="col-lg-7 col-md-7 col-sm-10 col-xs-10">
																		<s:textfield name="socialContactValue"
																			cssClass="form-control" />
																		<div
																			id='addCustomerSocialForm_socialContactValue_errorloc'
																			class="error_strings"></div>
																	</div>
																	<div class="col-lg-1 col-md-1 col-sm-2 col-xs-2 "
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
																<div class="table-responsive"
																	style="padding-right: 20px;">
																	<table class="table table-bordered responsive-table">
																		<thead>
																			<tr id="myrow">
																				<th style="width: 4%;"><s:text
																						name="add.lead.social.table.action" /></th>

																				<th><s:text name="add.lead.social.table.social" /></th>
																				<th><s:text
																						name="add.lead.social.table.socialname" /></th>
																			</tr>
																		</thead>
																		<tbody>
																			<s:iterator value="customerSocialDetailsGrid">
																				<tr>
																					<td align="center">
																						<div class="btn-group">
																							<a id="delete"
																								href="#"
																								onclick ="validate('deleteAssignment.action?command='+<s:property value='socialContactId' />)"
																								 data-toggle="tooltip"  data-original-title="Delete"
																								data-placement="bottom"> <i
																								class="fa fa-trash-o"></i>
																							</a>
																						</div>

																					</td>

																					<td><s:property value="socialSiteRefName" /></td>
																					<td><s:property value="socialContactValue" /></td>


																				</tr>
																			</s:iterator>
																		</tbody>
																	</table>
																</div>
															</div>
														</div>
													</s:iterator>
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
	
	function validate(url)
	{
		if(confirm("Are you sure want to delete !!!!")){
			document.location = url;
		}
	}
		var frmvalidator = new Validator("addCustomerSocialForm");
		frmvalidator.EnableOnPageErrorDisplay();
		frmvalidator.EnableMsgsTogether();

		frmvalidator.addValidation("socialSiteRef", "dontselect=-1",
				"Select Social Type");

		frmvalidator.addValidation("socialContactValue", "req",
				"Enter Social Link");
	</script>
</body>