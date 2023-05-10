<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>

	<div class="outer">
		<div class="inner bg-light lter">
			<div class="box">
				<div class="container-fluid">
					<ol class="breadcrumb" style="margin-top: 10px;">
						<li><a href="omiInnerDashboard.action"><i
								class="fa fa-home"></i></a></li>
						<li><a href="leadDashboard.action"><s:text
									name="navbar.lead"></s:text></a></li>
						<li class="active"><s:text name="navbar.lead.dashboard"></s:text></li>
						<li class="active"><s:text name="navbar.viewlead"></s:text></li>
					</ol>
					<header> <a class="icons" href="leadDashboard.action"
						data-toggle="tooltip"
						data-original-title="Back To Leads DashBoard"
						style="color: black;"> <i class="fa fa-th-large"></i>
					</a>
					<h5>
						<s:text name="view.lead.followup.heading" />
					</h5>
					<div class="pull-right">
						<div class="btn-group">
							<a class="btn btn-default btnheight" data-toggle="tooltip"
								data-original-title="Help"><i class="fa fa-question"></i> <s:text
									name="project.form.button.help"></s:text></a> <a
								class="btn btn-primary btnheight" data-toggle="tooltip"
								data-original-title="Print"><i class="fa fa-print"></i> <s:text
									name="project.form.button.print"></s:text></a> <a
								data-toggle="tooltip" data-original-title="PDF Report"
								href="leadPrintPDF.action?command=<s:property value='leadId' />"
								class="btn btn-success btnheight"><i
								class="fa fa-file-pdf-o "></i> <s:text
									name="project.form.button.pdf"></s:text></a> <a
								data-toggle="tooltip" data-original-title="Previous Lead"
								href="viewPriviousLeadInfo.action?command=previous"
								type="button" class="btn btn-default btnheight"><i
								class="fa fa-chevron-left fontawesomeht"></i></a> <a
								data-toggle="tooltip" data-original-title="Next Lead"
								href="viewNextLeadInfo.action?command=next"
								class="btn btn-default btnheight"><i
								class="fa fa-chevron-right fontawesomeht"></i></a> <a
								data-toggle="tooltip" data-original-title="Close"
								href="leadDashboard.action" class="btn btn-danger btnheight"><i
								class="fa fa-times fontawesomeht"></i></a>
						</div>
					</div>
					</header>
					<div id="div-2" class="body">
						<div>
							<p>
								<s:if test="hasActionErrors()">
									<div class="alert alert-danger" role="alert"
										style="padding-bottom: 7px;">
										<div class="infoIcon">
											<!-- <i class="fa fa-times-circle "></i> -->
											<s:actionerror />
										</div>
									</div>
								</s:if>
								<s:elseif test="hasActionMessages()">
									<div class="alert alert-success" role="alert"
										style="padding-bottom: 7px;">
										<div class="infoIcon">
											<!-- <i class="fa fa-check-circle "> </i> -->
											<s:actionmessage />
										</div>
									</div>
								</s:elseif>
								<s:else>

									<div class="alert alert-info" role="alert">
										<div class="infoIcon">
											<i class="fa fa-info-circle "> <s:text
													name="add.create.lead.information.bar" /></i>
										</div>
									</div>
								</s:else>
							</p>
						</div>
						<div style="padding-left: 15px; padding-right: 15px;">
							<form class="form-horizontal">
								<s:iterator value="LeadVO" var="testObj">
									<div class="row">
										<div
											class="col-lg-12 col-md-12 col-sm-12 col-xs-12 viewinnertitle">
											<h5>
												<s:text name="add.create.lead.lead.information" />
											</h5>
										</div>
									</div>


									<div class="row">
										<div class="col-md-12 col-sm-12 col-xs-12"
											id="view_lable_value">
											<div class="col-md-2 col-sm-12 col-xs-12">
												<label for="text1" class="control-label" id="viewlable">
													<s:text name="lead.dashboard.leadid" />
												</label>
											</div>
											<div class="col-md-10 col-sm-12 col-xs-12 control-label">
												<s:property value="leadId" />
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12 col-sm-12 col-xs-12"
											id="view_lable_value2">
											<div class="col-md-2 col-sm-12 col-xs-12">
												<label for="text1" class="control-label" id="viewlable">
													<s:text name="view.lead.followup.lead.owner" />
												</label>
											</div>
											<div class="col-md-10 col-sm-12 col-xs-12 control-label">
												<s:property value="leadOwner" />
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12 col-sm-12 col-xs-12"
											id="view_lable_value">

											<div class="col-md-2 col-sm-12 col-xs-12">
												<label for="text1" class="control-label " id="viewlable">
													<s:text name="view.lead.followup.lead.creation.date" />
												</label>
											</div>
											<div class="col-md-10 col-sm-12 col-xs-12 control-label">
												<s:property value="createdDate" />
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12 col-sm-12 col-xs-12"
											id="view_lable_value2">
											<div class="col-md-2 col-sm-12 col-xs-12">
												<label for="text1" class="control-label" id="viewlable">
													<s:text name="add.create.lead.company" />
												</label>
											</div>
											<div class="col-md-10 col-sm-12 col-xs-12 control-label">
												<s:property value="companyName" />

											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12 col-sm-12 col-xs-12"
											id="view_lable_value">
											<div class="col-md-2 col-sm-12 col-xs-12">
												<label for="text1" class="control-label" id="viewlable">
													<s:text name="add.create.lead.contactperson" />
												</label>
											</div>
											<div class="col-md-10 col-sm-12 col-xs-12 control-label">
												<s:property value="fullName" />
											</div>

										</div>
									</div>



									<div class="row">
										<div class="col-md-12 col-sm-12 col-xs-12"
											id="view_lable_value2">
											<div class="col-md-2 col-sm-12 col-xs-12">
												<label for="text1" class="control-label" id="viewlable">
													<s:text name="add.create.lead.leadtitle" />
												</label>
											</div>
											<div class="col-md-10 col-sm-12 col-xs-12 control-label">
												<s:property value="leadTitle" />
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12  col-sm-12 col-xs-12"
											id="view_lable_value">
											<div class="col-md-2 col-sm-12 col-xs-12">
												<label for="text1" class="control-label" id="viewlable"><s:text
														name="add.create.lead.company.type" /></label>
											</div>
											<div class="col-md-10 col-sm-12 col-xs-12 control-label">
												<s:property value="companyType" />
											</div>
										</div>
									</div>



									<div class="row">
										<div class="col-md-12  col-sm-12 col-xs-12"
											id="view_lable_value2">
											<div class="col-md-2 col-sm-12 col-xs-12">
												<label for="text1" class="control-label" id="viewlable"><s:text
														name="add.create.lead.company.category" /></label>
											</div>
											<div class="col-md-10 col-sm-12 col-xs-12 control-label">
												<s:property value="companyCategory" />
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12  col-sm-12 col-xs-12"
											id="view_lable_value">
											<div class="col-md-2 col-sm-12 col-xs-12">
												<label for="text1" class="control-label" id="viewlable"><s:text
														name="add.create.lead.company.sector" /></label>
											</div>
											<div class="col-md-10 col-sm-12 col-xs-12 control-label">
												<s:property value="companySector" />
											</div>
										</div>
									</div>




									<div class="row">
										<div class="col-md-12  col-sm-12 col-xs-12"
											id="view_lable_value2">
											<div class="col-md-2 col-sm-12 col-xs-12">
												<label for="text1" class="control-label" id="viewlable"><s:text
														name="add.create.lead.lead.source" /></label>
											</div>
											<div class="col-md-10 col-sm-12 col-xs-12 control-label">
												<s:property value="leadSource" />

											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12  col-sm-12 col-xs-12"
											id="view_lable_value">
											<div class="col-md-2 col-sm-12 col-xs-12">
												<label for="text1" class="control-label" id="viewlable"><s:text
														name="add.create.lead.lead.sourceName" /></label>
											</div>
											<div class="col-md-10 col-sm-12 col-xs-12 control-label">
												<s:property value="leadSourceName" />

											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12  col-sm-12 col-xs-12"
											id="view_lable_value2">
											<div class="col-md-2 col-sm-12 col-xs-12">
												<label for="text1" class="control-label" id="viewlable"><s:text
														name="view.lead.followup.lead.status" /></label>
											</div>
											<div class="col-md-10 col-sm-12 col-xs-12 control-label">
												<s:property value="leadSourceStatus" />
											</div>
										</div>
									</div>




									<div class="row">
										<div class="col-md-12  col-sm-12 col-xs-12"
											id="view_lable_value">
											<div class="col-md-2 col-sm-12 col-xs-12">
												<label for="text1" class="control-label" id="viewlable"><s:text
														name="add.create.lead.no.of.associate" /></label>
											</div>
											<div class="col-md-10 col-sm-12 col-xs-12 control-label">
												<s:property value="noOfAssociate" />
											</div>

										</div>
									</div>
									<div class="row">
										<div class="col-md-12 col-sm-12 col-xs-12"
											id="view_lable_value2">
											<div class="col-md-2 col-sm-12 col-xs-12">
												<label for="text1" class="control-label" id="viewlable"><s:text
														name="add.create.lead.annual.revneue" /> &nbsp; (&nbsp;<span
													class="fa fa-rupee "></span>&nbsp;)</label>
											</div>
											<div class="col-md-10 col-sm-12 col-xs-12 control-label">
												<s:property value="annualRevenue" />
											</div>
										</div>
									</div>



									<div class="row">
										<div class="col-md-12  col-sm-12 col-xs-12"
											id="view_lable_value">
											<div class="col-md-2 col-sm-12 col-xs-12">
												<label for="text1" class="control-label" id="viewlable"><s:text
														name="view.lead.followup.rating" /></label>
											</div>
											<div class="col-md-10 col-sm-12 col-xs-12 ">
												<s:property value="ratings" />

											</div>

										</div>
									</div>

									<div class="row">
										<div class="col-md-12  col-sm-12 col-xs-12"
											id="view_lable_value2">
											<div class="col-md-2 col-sm-12 col-xs-12">
												<label for="text1" class="control-label" id="viewlable"><s:text
														name="add.lead.email.optout" /></label>
											</div>
											<div class="col-md-10 col-sm-12 col-xs-12 ">
												<s:property value="emailOptOut" />
											</div>
										</div>
									</div>

									<div class="row">
										<div class="col-md-12  col-sm-12 col-xs-12"
											id="view_lable_value">
											<div class="col-md-2 col-sm-12 col-xs-12">
												<label for="text1" class="control-label" id="viewlable"><s:text
														name="add.create.lead.lead.date" /></label>
											</div>
											<div class="col-md-10 col-sm-12 col-xs-12 control-label">
												<s:property value="leadDate" />
											</div>
										</div>
									</div>



									<div class="row">
										<div class="col-md-12  col-sm-12 col-xs-12"
											id="view_lable_value2">
											<div class="col-md-2 col-sm-12 col-xs-12">
												<label for="text1" class="control-label" id="viewlable"><s:text
														name="add.create.lead.expected.closing.date" /></label>
											</div>
											<div class="col-md-10 col-sm-12 col-xs-12 control-label">
												<s:property value="expectedClosingDate" />
											</div>
										</div>
									</div>



									<div class="row">
										<div
											class="col-lg-12 col-md-12 col-sm-12 col-xs-12 viewinnertitle">
											<h5>
												<s:text name="add.create.lead.contact.information" />
											</h5>
										</div>
									</div>


									<div class="row">
										<div class="col-md-12  col-sm-12 col-xs-12"
											id="view_lable_value">
											<div class="col-md-2 col-sm-12 col-xs-12">
												<label for="text1" class="control-label" id="viewlable"><s:text
														name="add.create.lead.adress.line1" /></label>
											</div>
											<div class="col-md-10 col-sm-12 col-xs-12 control-label">
												<s:property value="addressLine1" />
											</div>

										</div>
									</div>
									<div class="row">
										<div class="col-md-12  col-sm-12 col-xs-12"
											id="view_lable_value2">
											<div class="col-md-2 col-sm-12 col-xs-12">
												<label for="text1" class="control-label" id="viewlable"><s:text
														name="add.create.lead.adress.line2" /></label>
											</div>
											<div class="col-md-10 col-sm-12 col-xs-12 control-label">
												<s:property value="addressLine2" />
											</div>
										</div>
									</div>



									<div class="row">
										<div class="col-md-12  col-sm-12 col-xs-12"
											id="view_lable_value">
											<div class="col-md-2 col-sm-12 col-xs-12">
												<label for="text1" class="control-label" id="viewlable"><s:text
														name="add.create.lead.city" /></label>
											</div>
											<div class="col-md-10 col-sm-12 col-xs-12 control-label">
												<s:property value="city" />
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12  col-sm-12 col-xs-12"
											id="view_lable_value2">
											<div class="col-md-2 col-sm-12 col-xs-12">
												<label for="text1" class="control-label" id="viewlable"><s:text
														name="add.create.lead.state" /></label>
											</div>
											<div class="col-md-10 col-sm-12 col-xs-12 control-label">
												<s:property value="state" />
											</div>
										</div>
									</div>



									<div class="row">
										<div class="col-md-12  col-sm-12 col-xs-12"
											id="view_lable_value">
											<div class="col-md-2 col-sm-12 col-xs-12">
												<label for="text1" class="control-label" id="viewlable"><s:text
														name="add.create.lead.country" /></label>
											</div>
											<div class="col-md-10 col-sm-12 col-xs-12 control-label">
												<s:property value="country" />
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12  col-sm-12 col-xs-12"
											id="view_lable_value2">
											<div class="col-md-2 col-sm-12 col-xs-12">
												<label for="text1" class="control-label" id="viewlable"><s:text
														name="add.create.lead.zipcode" /></label>
											</div>
											<div class="col-md-10 col-sm-12 col-xs-12 control-label">
												<s:property value="zipcode" />
											</div>
										</div>
									</div>




									<div class="row">
										<div class="col-md-12  col-sm-12 col-xs-12"
											id="view_lable_value">
											<div class="col-md-2 col-sm-12 col-xs-12">
												<label for="text1" class="control-label" id="viewlable"><s:text
														name="add.create.lead.phone" /></label>
											</div>
											<div class="col-md-10 col-sm-12 col-xs-12 control-label">
												<s:property value="phoneNo" />
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12  col-sm-12 col-xs-12"
											id="view_lable_value2">
											<div class="col-md-2  col-sm-12 col-xs-12">
												<label for="text1" class="control-label" id="viewlable"><s:text
														name="add.create.lead.mobile" /></label>
											</div>
											<div class="col-md-10 col-sm-12 col-xs-12 control-label">
												<s:property value="mobileNo" />
											</div>
										</div>
									</div>

									<div class="row">
										<div class="col-md-12  col-sm-12 col-xs-12"
											id="view_lable_value">
											<div class="col-md-2 col-sm-12 col-xs-12">
												<label for="text1" class="control-label" id="viewlable"><s:text
														name="add.create.lead.primary.email.id" /></label>
											</div>
											<div class="col-md-10 col-sm-12 col-xs-12 control-label">
												<s:property value="primaryEmailId" />
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12  col-sm-12 col-xs-12"
											id="view_lable_value2">
											<div class="col-md-2 col-sm-12 col-xs-12">
												<label for="text1" class="control-label" id="viewlable"><s:text
														name="add.create.lead.alternate.email.id" /></label>
											</div>
											<div class="col-md-10 col-sm-12 col-xs-12 control-label">
												<s:property value="alternateEmailId" />
											</div>
										</div>
									</div>

									<div class="row">
										<div class="col-md-12  col-sm-12 col-xs-12"
											id="view_lable_value">
											<div class="col-md-2 col-sm-12 col-xs-12">
												<label for="text1" class="control-label" id="viewlable"><s:text
														name="add.create.lead.fax" /></label>
											</div>
											<div class="col-md-10 col-sm-12 col-xs-12 control-label">
												<s:property value="fax" />
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12  col-sm-12 col-xs-12"
											id="view_lable_value2">
											<div class="col-md-2  col-sm-12 col-xs-12">
												<label class="control-label" id="viewlable"><s:text
														name="add.create.lead.website" /></label>
											</div>
											<div class="col-md-10 col-sm-12 col-xs-12 control-label">
												<s:property value="website" />
											</div>

										</div>
									</div>


									<div class="row">
										<div
											class="col-lg-12 col-md-12 col-sm-12 col-xs-12 viewinnertitle">
											<h5>
												<s:text name="add.create.lead.requirment" />
											</h5>
										</div>
									</div>
									<div class="row">
										<div class="col-lg-12">
											<div>
												<div id="div-3" class="body tab-content ">
													<div class="collapse in" id="show">
														<div id="wmd-preview" class="wmd-panel wmd-preview">
															${requirment}</div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</s:iterator>

								<div class="row">
									<div
										class="col-lg-12 col-md-12 col-sm-12 col-xs-12 viewinnertitle">
										<h5>
											<s:text name="add.create.lead.social.information" />
										</h5>
									</div>
								</div>
								<div class="row " class="tab-pane fade" id="addSocial">
									<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"
										id="dataTable">
										<div class="table-responsive">
											<table class="table table-bordered responsive-table">
												<thead>
													<tr id="myrow">
														<th><s:text name="add.lead.social.table.social" /></th>
														<th><s:text name="add.lead.social.table.socialname" /></th>
													</tr>
												</thead>
												<tbody>
													<s:iterator value="leadSocialDetailsGrid">
														<tr>
															<td><s:property value="socialSiteRefName" /></td>
															<td><s:property value="socialContactValue" /></td>
														</tr>
													</s:iterator>
												</tbody>
											</table>
										</div>
									</div>
								</div>

								<div class="row">
									<div
										class="col-lg-12 col-md-12 col-sm-12 col-xs-12 viewinnertitle">
										<h5>
											<s:text name="view.lead.followup.followup.heading" />
										</h5>
									</div>
								</div>

								<div class="row" class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
									<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"
										id="dataTable">
										<div class="table-responsive">
											<table class="table table-bordered responsive-table">
												<thead>
													<tr id="myrow">
														<th><s:text name="update.Lead.Followup.followup.date" /></th>
														<th><s:text
																name="update.Lead.Followup.followup.status" /></th>
														<th><s:text name="update.Lead.Followup.followup.by" /></th>
														<th><s:text name="update.group.createdby" /></th>
														<th style=""><s:text
																name="update.Lead.Followup.comment" /></th>
													</tr>
												</thead>
												<tbody>
													<s:iterator value="leadFollowUpDetailsGrid">
														<tr>
															<td><s:property value="followUpDate" /></td>
															<td><s:property value="followUpStatus" /></td>
															<td><s:property value="followUpBy" /></td>
															<td><s:property value="createdByName" /></td>
															<td><s:property value="followUpComment" /></td>
														</tr>
													</s:iterator>
												</tbody>
											</table>

										</div>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>