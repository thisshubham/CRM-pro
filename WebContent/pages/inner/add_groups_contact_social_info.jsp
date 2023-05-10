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

	<div id="content">
		<div class="outer">
			<div class="inner bg-light lter">

				<!--BEGIN INPUT TEXT FIELDS-->
				<div class="row">
					<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
						<div class="box inverse">
							<header> <a class="icons"
								href="contactsDashboard.action" data-toggle="tooltip"
								data-original-title="Back To DashBoard"> <i
								class="fa fa-th-large"></i>
							</a>
							<h5>
								<s:text name="Update Contact" />
							</h5>

							<!-- .toolbar -->
							<div class="toolbar">
								<nav style="padding: 8px;"> <a
									href="contactsDashboard.action" data-toggle="tooltip"
									data-original-title="Close" data-placement="bottom"
									class="btn btn-danger btn-sm"> <i class="fa fa-times"></i>
								</a></nav>
							</div>
							</header>
							<!-- /.toolbar -->
							<div class="container"
								style="margin-top: 20px; margin-bottom: 20px;">

								<!-- Nav tabs -->
								<!-- Nav tabs -->
								<ul class="nav nav-tabs" role="tablist">
									<li role="presentation"><a
										href="populateGroupsContact.action?command=<s:property value="contactId"/>"
										style="color: Gray;"><s:text name="Contact Information" /></a></li>
									<li role="presentation" class="active"><a
										href="renderContactSocialInfo.action?command=<s:property value="contactId"/>"
										style="background-color: #F9F9F9; color: Gray;"><s:text
												name="Social Information" /></a></li>
								</ul>


								<!-- Tab panes -->
								<div id="content" style="background-color: #F9F9F9;">
									<!--BEGIN INPUT TEXT FIELDS-->
									<div class="row">
										<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
											<div class="box inverse"
												style="margin-top: -10px; margin-bottom: 0px; padding-left: 20px;">
												<div class="alert alert-info" role="alert"
													style="margin-top: 25px; margin-right: 20px;">
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
															</div>&nbsp;&nbsp;&nbsp;<s:text
																name="User can add contact social information " />
														</s:else>
													</p>
												</div>

												<s:form name="addGroupsContactForm"
													action="addGroupContactSocialInformation" method="POST">

													<div class="row">

														<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
															<div class="row form-group">

																<div class="col-lg-3 col-md-3 col-sm-12 col-xs-6">
																	<s:text name="add.lead.social.socialcontact" />
																	<div class="star">*</div>
																</div>

																<div class="col-lg-8 col-md-8 col-sm-12 col-xs-6">
																	<s:select list="socialSiteList" headerKey="-1"
																		headerValue="Select Social Type" name="socialSiteRef"
																		cssClass="form-control chzn-select" />
																	<div id='addGroupsContactForm_socialSiteRef_errorloc'
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
																		id='addGroupsContactForm_socialContactValue_errorloc'
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
																		<s:iterator value="contactsSocialDetailsGrid">
																			<tr>
																				<td align="center"><a href="javascript:;"
																					class="btn btn-danger btn-xs close-box"> <i
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

	<script type="text/javascript">
		var frmvalidator = new Validator("addGroupsContactForm");
		frmvalidator.EnableOnPageErrorDisplay();
		frmvalidator.EnableMsgsTogether();

		frmvalidator.addValidation("socialSiteRef", "dontselect=-1",
				"Select Social Contact Type");

		frmvalidator.addValidation("socialContactValue", "req",
				"Enter Social Contact");
		frmvalidator.addValidation("socialContactValue", "maxlen=50",
				"Social Contact Should Be 50 Char");
	</script>

</body>
</html>