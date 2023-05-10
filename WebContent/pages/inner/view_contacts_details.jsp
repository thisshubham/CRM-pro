<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="/struts-jquery-tags" prefix="sj"%>
<%@page import="com.bst.ckt.common.LoginUtil"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>

	<div class="outer">
		<div class="inner bg-light lter">
			<div class="box dark">
			<ol class="breadcrumb" style="margin-top: 10px;">
						<li><a href="omiInnerDashboard.action"><i
								class="fa fa-home"></i></a></li>
						<li><a href="contactsDashboard.action"><s:text
									name="Contacts Dashboard"></s:text></a></li>
						
						<li class="active"><s:text name="View Contacts"></s:text></li>
					</ol>
				<header> <a class="icons" href="contactsDashboard.action"
					data-toggle="tooltip"
					data-original-title="Back To Contact DashBoard"
					style="color: black"> <i class="fa fa-th-large"></i>
				</a>
				<h5>Contacts Details</h5>

				<!-- .toolbar -->
				<div class="pull-right">
						<div class="btn-group">
							<a class="btn btn-default btnheight" data-toggle="tooltip"
								data-original-title="Help"><i class="fa fa-question"></i> <s:text
									name="project.form.button.help"></s:text></a> <a
								class="btn btn-primary btnheight" data-toggle="tooltip"
								data-original-title="Print"><i class="fa fa-print"></i> <s:text
									name="project.form.button.print"></s:text></a> <a
								data-toggle="tooltip" data-original-title="PDF Report"
								href="contactsPrintPDF.action?command=<s:property value='contactId' />"
								class="btn btn-success btnheight"><i
								class="fa fa-file-pdf-o "></i> <s:text
									name="project.form.button.pdf"></s:text></a> <a
								data-toggle="tooltip" data-original-title="Previous Contact"
								href="viewPreviousContactInfo.action?command=<s:property value='contactId' />"
								type="button" class="btn btn-default btnheight"><i
								class="fa fa-chevron-left fontawesomeht"></i></a> <a
								data-toggle="tooltip" data-original-title="Next Contact"
								href="viewNextContactInfo.action?command=<s:property value='contactId' />"
								class="btn btn-default btnheight"><i
								class="fa fa-chevron-right fontawesomeht"></i></a> <a
								data-toggle="tooltip" data-original-title="Close"
								href="leadDashboard.action" class="btn btn-danger btnheight"><i
								class="fa fa-times fontawesomeht"></i></a>
						</div>
					</div>
				</header>

				<div class="container">
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
													name="You Can View Contact Here" /></i>
										</div>
									</div>
								</s:else>
							</p>
						</div>
					
						<s:form cssClass="form-horizontal">
							<s:iterator value="ContactsVO" var="testObj">
								<div class="row" style="margin-top: 10px;">
									<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
										<h5>
											<s:text name="add.create.contact.contactinfo"></s:text>
										</h5>
									</div>

								</div>
								<div class="row">
									<div class="col-md-12 col-sm-12 col-xs-12">
										<div class="col-md-2 col-sm-12 col-xs-12" id="view_lable">
											<label for="text1" class="control-label" id="viewlable">

												<s:text name="contact.dashboard.contactid"></s:text>
											</label>
										</div>
										<div class="col-md-10 col-sm-12 col-xs-12 control-label"
											id="view_lable_value">
											<s:property value="contactId" />
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12 col-sm-12 col-xs-12">

										<div class="col-md-2 col-sm-12 col-xs-12" id="view_lable">
											<label for="text1" class="control-label " id="viewlable">
												<s:text name="contact.dashboard.contactperson"></s:text>
											</label>
										</div>
										<div class="col-md-10 col-sm-12 col-xs-12"
											id="view_lable_value2">
											<label for="text1" class="control-label"> <s:property
													value="contactperson" /></label>
										</div>
									</div>
								</div>
								<%-- <div class="row">
									<div class="col-md-12 col-sm-12 col-xs-12">
										<div class="col-md-2 col-sm-12 col-xs-12" id="view_lable">
											<label for="text1" class="control-label" id="viewlable">
												<s:text name="group.dashboard.table.groupname"></s:text>
											</label>
										</div>
										<div class="col-md-10 col-sm-12 col-xs-12"
											id="view_lable_value">
											<label for="text1" class="control-label "><s:property
													value="groupName" /></label>

										</div>
									</div>
								</div> --%>
								<div class="row">
									<div class="col-md-12 col-sm-12 col-xs-12">
										<div class="col-md-2 col-sm-12 col-xs-12" id="view_lable">
											<label for="text1" class="control-label" id="viewlable">
												<s:text name="add.create.contact.nickname"></s:text>
											</label>
										</div>
										<div class="col-md-10 col-sm-12 col-xs-12"
											id="view_lable_value2">
											<label for="text1" class="control-label"> <s:property
													value="nickName" /></label>
										</div>

									</div>
								</div>



								<div class="row">
									<div class="col-md-12 col-sm-12 col-xs-12">
										<div class="col-md-2 col-sm-12 col-xs-12" id="view_lable">
											<label for="text1" class="control-label" id="viewlable">
												<s:text name="add.client.Designation"></s:text>
											</label>
										</div>
										<div class="col-md-10 col-sm-12 col-xs-12"
											id="view_lable_value">
											<label for="text1" class="control-label"> <s:property
													value="designation" />
											</label>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12  col-sm-12 col-xs-12">
										<div class="col-md-2 col-sm-12 col-xs-12" id="view_lable">
											<label for="text1" class="control-label" id="viewlable">
												<s:text name="add.client.phone.number"></s:text>
											</label>
										</div>
										<div class="col-md-10 col-sm-12 col-xs-12"
											id="view_lable_value2">
											<label for="text1" class="control-label"> <s:property
													value="phoneNumber" />
											</label>
										</div>
									</div>
								</div>



								<div class="row">
									<div class="col-md-12  col-sm-12 col-xs-12">
										<div class="col-md-2 col-sm-12 col-xs-12" id="view_lable">
											<label for="text1" class="control-label" id="viewlable">
												<s:text name="Referred By"></s:text>
											</label>
										</div>
										<div class="col-md-10 col-sm-12 col-xs-12"
											id="view_lable_value">
											<label for="text1" class="control-label"> <s:property
													value="referredBy" />
											</label>

										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12  col-sm-12 col-xs-12">
										<div class="col-md-2 col-sm-12 col-xs-12" id="view_lable">
											<label for="text1" class="control-label" id="viewlable">

												<s:text name="Mobile Number"></s:text>
											</label>
										</div>
										<div class="col-md-10 col-sm-12 col-xs-12"
											id="view_lable_value2">
											<label for="text1" class="control-label"> <s:property
													value="mobileNum1" /></label>
										</div>
									</div>
								</div>




								<%-- <div class="row">
									<div class="col-md-12  col-sm-12 col-xs-12">
										<div class="col-md-2 col-sm-12 col-xs-12" id="view_lable">
											<label for="text1" class="control-label" id="viewlable"><s:text
													name="Mobile Number Work"></s:text> </label>
										</div>
										<div class="col-md-10 col-sm-12 col-xs-12"
											id="view_lable_value">
											<label for="text1" class="control-label"> <s:property
													value="mobileNum2" /></label>

										</div>
									</div>
								</div> --%>
								<div class="row">
									<div class="col-md-12  col-sm-12 col-xs-12">
										<div class="col-md-2 col-sm-12 col-xs-12" id="view_lable">
											<label for="text1" class="control-label" id="viewlable">
												<s:text name="add.user.email.id"></s:text>
											</label>
										</div>
										<div class="col-md-10 col-sm-12 col-xs-12"
											id="view_lable_value2">
											<label for="text1" class="control-label"> <s:property
													value="emailId" /></label>
										</div>
									</div>
								</div>




								<%-- <div class="row">
									<div class="col-md-12  col-sm-12 col-xs-12">
										<div class="col-md-2 col-sm-12 col-xs-12" id="view_lable">
											<label for="text1" class="control-label" id="viewlable">
												<s:text name="add.client.fax"></s:text>
											</label>
										</div>
										<div class="col-md-10 col-sm-12 col-xs-12"
											id="view_lable_value">
											<label for="text1" class="control-label"> <s:property
													value="fax" /></label>
										</div>
									</div>
								</div>
 --%>


								<div class="row">
									<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
										<h5>
											<s:text name="add.create.contact.homecontactinfo"></s:text>
										</h5>
									</div>

								</div>


								<div class="row">
									<div class="col-md-12  col-sm-12 col-xs-12">
										<div class="col-md-2 col-sm-12 col-xs-12" id="view_lable">
											<label for="text1" class="control-label" id="viewlable">
												<s:text name="add.create.lead.adress.line1"></s:text>
											</label>
										</div>
										<div class="col-md-10 col-sm-12 col-xs-12"
											id="view_lable_value2">
											<label for="text1" class="control-label"><s:property
													value="homeContAddLine1" /></label>
										</div>

									</div>
								</div>
								<div class="row">
									<div class="col-md-12  col-sm-12 col-xs-12">
										<div class="col-md-2 col-sm-12 col-xs-12" id="view_lable">
											<label for="text1" class="control-label" id="viewlable"><s:text
													name="add.create.lead.adress.line2"></s:text> </label>
										</div>
										<div class="col-md-10 col-sm-12 col-xs-12"
											id="view_lable_value">
											<label for="text1" class="control-label"> <s:property
													value="homeContAddLine2" />
											</label>
										</div>
									</div>
								</div>



								<div class="row">
									<div class="col-md-12  col-sm-12 col-xs-12">
										<div class="col-md-2 col-sm-12 col-xs-12" id="view_lable">
											<label for="text1" class="control-label" id="viewlable"><s:text
													name="add.create.lead.city"></s:text></label>
										</div>
										<div class="col-md-10 col-sm-12 col-xs-12"
											id="view_lable_value2">
											<label for="text1" class="control-label"> <s:property
													value="homeContCity" /></label>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12  col-sm-12 col-xs-12">
										<div class="col-md-2 col-sm-12 col-xs-12" id="view_lable">
											<label for="text1" class="control-label" id="viewlable"><s:text
													name="user.profile.state"></s:text></label>
										</div>
										<div class="col-md-10 col-sm-12 col-xs-12"
											id="view_lable_value">
											<label for="text1" class="control-label"> <s:property
													value="homeContState" /></label>
										</div>
									</div>
								</div>



								<div class="row">
									<div class="col-md-12  col-sm-12 col-xs-12">
										<div class="col-md-2 col-sm-12 col-xs-12" id="view_lable">
											<label for="text1" class="control-label" id="viewlable"><s:text
													name="user.create.country"></s:text></label>
										</div>
										<div class="col-md-10 col-sm-12 col-xs-12"
											id="view_lable_value2">
											<label for="text1" class="control-label"> <s:property
													value="homeContCountry" /></label>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12  col-sm-12 col-xs-12">
										<div class="col-md-2 col-sm-12 col-xs-12" id="view_lable">
											<label for="text1" class="control-label" id="viewlable"><s:text
													name="user.create.zipcode"></s:text></label>
										</div>
										<div class="col-md-10 col-sm-12 col-xs-12"
											id="view_lable_value">
											<label for="text1" class="control-label"> <s:property
													value="homeContZipcode" /></label>
										</div>
									</div>
								</div>




								<div class="row">
									<div class="col-md-12  col-sm-12 col-xs-12">
										<div class="col-md-2 col-sm-12 col-xs-12" id="view_lable">
											<label for="text1" class="control-label" id="viewlable"><s:text
													name="add.client.phone.number"></s:text></label>
										</div>
										<div class="col-md-10 col-sm-12 col-xs-12"
											id="view_lable_value2">
											<label for="text1" class="control-label"> <s:property
													value="homeContPhoneNum" /></label>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12  col-sm-12 col-xs-12">
										<div class="col-md-2  col-sm-12 col-xs-12" id="view_lable">
											<label for="text1" class="control-label" id="viewlable">
												<s:text name="add.client.contact.person.mobile.no"></s:text>
											</label>
										</div>
										<div class="col-md-10 col-sm-12 col-xs-12"
											id="view_lable_value">
											<label for="text1" class="control-label"> <s:property
													value="homeContMobileNum" /></label>
										</div>
									</div>
								</div>

								<div class="row">
									<div class="col-md-12  col-sm-12 col-xs-12">
										<div class="col-md-2  col-sm-12 col-xs-12" id="view_lable">
											<label for="text1" class="control-label" id="viewlable">
												<s:text name="add.client.contact.person.email.id"></s:text>
											</label>
										</div>
										<div class="col-md-10 col-sm-12 col-xs-12"
											id="view_lable_value2">
											<label for="text1" class="control-label"> <s:property
													value="homeContEmailId" /></label>
										</div>
									</div>
								</div>

								<div class="row">
									<div class="col-md-12  col-sm-12 col-xs-12">
										<div class="col-md-2  col-sm-12 col-xs-12" id="view_lable">
											<label for="text1" class="control-label" id="viewlable"><s:text
													name="add.client.contact.person.fax"></s:text></label>
										</div>
										<div class="col-md-10 col-sm-12 col-xs-12"
											id="view_lable_value">
											<label for="text1" class="control-label"> <s:property
													value="homeContFaxNum" /></label>
										</div>
									</div>
								</div>



								<div class="row">
									<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
										<h5>
											<s:text name="add.create.contact.workcontactinfo"></s:text>
										</h5>
									</div>

								</div>



								<div class="row">
									<div class="col-md-12  col-sm-12 col-xs-12">
										<div class="col-md-2 col-sm-12 col-xs-12" id="view_lable">
											<label for="text1" class="control-label" id="viewlable">
												<s:text name="add.create.lead.adress.line1"></s:text>
											</label>
										</div>
										<div class="col-md-10 col-sm-12 col-xs-12"
											id="view_lable_value2">
											<label for="text1" class="control-label"><s:property
													value="workContAddLine1" /> </label>
										</div>

									</div>
								</div>
								<div class="row">
									<div class="col-md-12  col-sm-12 col-xs-12">
										<div class="col-md-2 col-sm-12 col-xs-12" id="view_lable">
											<label for="text1" class="control-label" id="viewlable"><s:text
													name="add.create.lead.adress.line2"></s:text> </label>
										</div>
										<div class="col-md-10 col-sm-12 col-xs-12"
											id="view_lable_value">
											<label for="text1" class="control-label"> <s:property
													value="workContAddLine2" />
											</label>
										</div>
									</div>
								</div>



								<div class="row">
									<div class="col-md-12  col-sm-12 col-xs-12">
										<div class="col-md-2 col-sm-12 col-xs-12" id="view_lable">
											<label for="text1" class="control-label" id="viewlable"><s:text
													name="add.create.lead.city"></s:text></label>
										</div>
										<div class="col-md-10 col-sm-12 col-xs-12"
											id="view_lable_value2">
											<label for="text1" class="control-label"> <s:property
													value="workContCity" /></label>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12  col-sm-12 col-xs-12">
										<div class="col-md-2 col-sm-12 col-xs-12" id="view_lable">
											<label for="text1" class="control-label" id="viewlable"><s:text
													name="add.create.lead.state"></s:text></label>
										</div>
										<div class="col-md-10 col-sm-12 col-xs-12"
											id="view_lable_value">
											<label for="text1" class="control-label"> <s:property
													value="workContState" /></label>
										</div>
									</div>
								</div>



								<div class="row">
									<div class="col-md-12  col-sm-12 col-xs-12">
										<div class="col-md-2 col-sm-12 col-xs-12" id="view_lable">
											<label for="text1" class="control-label" id="viewlable"><s:text
													name="add.create.lead.country"></s:text></label>
										</div>
										<div class="col-md-10 col-sm-12 col-xs-12"
											id="view_lable_value2">
											<label for="text1" class="control-label"> <s:property
													value="workContCountry" /></label>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12  col-sm-12 col-xs-12">
										<div class="col-md-2 col-sm-12 col-xs-12" id="view_lable">
											<label for="text1" class="control-label" id="viewlable"><s:text
													name="add.create.lead.zipcode"></s:text></label>
										</div>
										<div class="col-md-10 col-sm-12 col-xs-12"
											id="view_lable_value">
											<label for="text1" class="control-label"> <s:property
													value="workContZipcode" /></label>
										</div>
									</div>
								</div>




								<div class="row">
									<div class="col-md-12  col-sm-12 col-xs-12">
										<div class="col-md-2 col-sm-12 col-xs-12" id="view_lable">
											<label for="text1" class="control-label" id="viewlable"><s:text
													name="add.client.phone.number"></s:text></label>
										</div>
										<div class="col-md-10 col-sm-12 col-xs-12"
											id="view_lable_value2">
											<label for="text1" class="control-label"> <s:property
													value="workContPhoneNum" /></label>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12  col-sm-12 col-xs-12">
										<div class="col-md-2  col-sm-12 col-xs-12" id="view_lable">
											<label for="text1" class="control-label" id="viewlable"><s:text
													name="add.client.contact.person.mobile.no"></s:text> </label>
										</div>
										<div class="col-md-10 col-sm-12 col-xs-12"
											id="view_lable_value">
											<label for="text1" class="control-label"> <s:property
													value="workContMobileNum" /></label>
										</div>
									</div>
								</div>

								<div class="row">
									<div class="col-md-12  col-sm-12 col-xs-12">
										<div class="col-md-2  col-sm-12 col-xs-12" id="view_lable">
											<label for="text1" class="control-label" id="viewlable">
												<s:text name="add.client.contact.person.email.id"></s:text>
											</label>
										</div>
										<div class="col-md-10 col-sm-12 col-xs-12"
											id="view_lable_value2">
											<label for="text1" class="control-label"> <s:property
													value="workContEmailId" /></label>
										</div>
									</div>
								</div>

								<div class="row">
									<div class="col-md-12  col-sm-12 col-xs-12">
										<div class="col-md-2  col-sm-12 col-xs-12" id="view_lable">
											<label for="text1" class="control-label" id="viewlable"><s:text
													name="add.client.contact.person.fax"></s:text></label>
										</div>
										<div class="col-md-10 col-sm-12 col-xs-12"
											id="view_lable_value">
											<label for="text1" class="control-label"> <s:property
													value="workContFaxNum" /></label>
										</div>
									</div>
								</div>


								<div class="row">
									<div class="col-md-12  col-sm-12 col-xs-12">
										<div class="col-md-2  col-sm-12 col-xs-12" id="view_lable">
											<label for="text1" class="control-label" id="viewlable">
												<s:text name="update.group.createdby"></s:text>
											</label>
										</div>
										<div class="col-md-10 col-sm-12 col-xs-12"
											id="view_lable_value2">
											<label for="text1" class="control-label"> <s:property
													value="createdBy" /></label>
										</div>
									</div>
								</div>

								<div class="row">
									<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
										<h5>
											<s:text name="add.group.profile.description"></s:text>
										</h5>
									</div>

								</div>
								<div class="row">
									<div class="col-lg-12">
										<div>
											<div id="div-3" class="body tab-content ">
												<div class="collapse in" id="show">
													<div id="wmd-preview" class="wmd-panel wmd-preview">
														${profileDescription}</div>
												</div>
											</div>
										</div>
									</div>
								</div>

								<div class="row">
									<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
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
													<s:iterator value="contactsSocialDetailsGrid">
														<tr>
															<td><s:property value="socialSiteRef" /></td>
															<td><s:property value="socialContactValue" /></td>
														</tr>
													</s:iterator>
												</tbody>
											</table>
										</div>
									</div>
								</div>


								<div class="row">
									<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
										<h5>
											<s:text name="user.create.profile.image"></s:text>
										</h5>
									</div>
								</div>

								<div class="row">
									<div
										class="col-lg-5 col-md-5 col-sm-5 col-xs-5 col-xs-offset-5">

										<div class="fileinput fileinput-new" data-provides="fileinput">
											<div class="fileinput-new thumbnail"
												style="width: 150px; height: 150px;">
												<img
													src="Directory/<%=LoginUtil.getCurrentCustomerUser().getCustomerId()%>/ProfileImage/${contactId}.PNG"
													alt="Profile Image">
											</div>

											<div class="fileinput-preview fileinput-exists thumbnail"
												style="max-width: 200px; max-height: 150px;"></div>

										</div>


									</div>
								</div>
							</s:iterator>
						</s:form>
						<%-- <hr>

						<div class="row" style="margin-top: 10px;">

							<div
								class="col-lg-4 col-md-4 col-sm-12 col-xs-12 col-md-offset-5">
								<a href="contactsDashboard.action" data-toggle="tooltip"
									data-original-title="Back To Contact DashBoard"
									class="btn btn-default" ontheme="simple"><s:text
										name="project.form.button.cancel" /> </a>
							</div>

						</div> --%>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>