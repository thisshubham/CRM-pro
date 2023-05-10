<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="/struts-jquery-tags" prefix="sj"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>

	<div class="outer">
		<div class="inner bg-light lter">
			<div class="box dark">
				<div class="container-fluid">
					<ol class="breadcrumb" style="margin-top: 10px;">
						<li><a href="omiInnerDashboard.action"><i
								class="fa fa-home"></i></a></li>
						<li><a href="renderAcccountsDashboard.action"><s:text
									name="Accounts"></s:text></a></li>
						<li class="active"><s:text name="Accounts Dashboard"></s:text></li>
						<li class="active"><s:text name="View Account"></s:text></li>
					</ol>

					<%-- <header> <a class="icons" href="groupDashboard.action"
						data-toggle="tooltip"
						data-original-title="Back To Group DashBoard"
						style="color: black;"> <i class="fa fa-th-large"></i>
					</a>
					<h5>
						<s:text name="view.group.info.groupheading" />
					</h5>

					<div class="toolbar">
						<nav style="padding: 8px;"> <a href="#"
							data-toggle="tooltip" data-original-title="Print"
							class="btn btn-metis-5 btn-sm"> <i class="fa fa-print"></i>
						</a> <a href="#" data-toggle="tooltip"
							data-original-title="PDF Report" class="btn btn-metis-6 btn-sm ">
							<i class="fa fa-file-pdf-o "></i>
						</a> </a> <a href="groupDashboard.action" data-toggle="tooltip"
							data-original-title="Close" data-placement="bottom"
							class="btn btn-danger btn-sm"> <i class="fa fa-times"></i>
						</a> </nav>
					</div>
					</header> --%>
					<header> <a class="icons"
						href="renderAcccountsDashboard.action" data-toggle="tooltip"
						data-original-title="Back To Accounts DashBoard"
						style="color: black;"> <i class="fa fa-th-large"></i>
					</a>
					<h5>
						<s:text name="View -Account Details" />
					</h5>
					<div class="pull-right">
						<div class="btn-group">
							<a class="btn btn-default btnheight" data-toggle="tooltip"
								data-original-title="Help"><i class="fa fa-question"></i> <s:text
									name="project.form.button.help"></s:text></a> <a
								class="btn btn-primary btnheight" data-toggle="tooltip"
								data-original-title="Print"><i class="fa fa-print"></i> <s:text
									name="project.form.button.print"></s:text></a> <a
								data-toggle="tooltip" data-original-title="PDF Report" href="#"
								class="btn btn-success btnheight"><i
								class="fa fa-file-pdf-o "></i> <s:text
									name="project.form.button.pdf"></s:text></a> <a
								data-toggle="tooltip" data-original-title="Previous Account"
								href="viewPriviousAccountInfo.action" type="button"
								class="btn btn-default btnheight"><i
								class="fa fa-chevron-left fontawesomeht"></i></a> <a
								data-toggle="tooltip" data-original-title="Next Account"
								href="viewNextAccountInfo.action"
								class="btn btn-default btnheight"><i
								class="fa fa-chevron-right fontawesomeht"></i></a> <a
								data-toggle="tooltip" data-original-title="Close"
								href="renderAcccountsDashboard.action"
								class="btn btn-danger btnheight"><i
								class="fa fa-times fontawesomeht"></i></a>
						</div>
					</div>
					</header>

					<div id="div-2" class="body">
						<div>
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
						</div>
						<s:form class="form-horizontal">
							<div style="padding-left: 15px; padding-right: 15px;">
								<div class="row">
									<div
										class="col-lg-12 col-md-12 col-sm-12 col-xs-12 viewinnertitle">
										<h5>
											<s:text name="Account Information" />
										</h5>
									</div>
								</div>

								<div class="row">
									<div class="col-md-12 col-sm-12 col-xs-12"
										id="view_lable_value">
										<div class="col-md-2 col-sm-12 col-xs-12">
											<label for="text1" class="control-label"> <s:text
													name="Account Id" />
											</label>
										</div>
										<div class="col-md-10 col-sm-12 col-xs-12 control-label">
											<s:property value="accountId" />
										</div>
									</div>
								</div>


								<div class="row">
									<div class="col-md-12 col-sm-12 col-xs-12"
										id="view_lable_value2">
										<div class="col-md-2 col-sm-12 col-xs-12">
											<label for="text1" class="control-label" id="viewlable">
												<s:text name="Account Owner" />
											</label>
										</div>
										<div class="col-md-10 col-sm-12 col-xs-12 control-label">
											<s:property value="accountOwner" />
										</div>
									</div>
								</div>

								<div class="row">
									<div class="col-md-12 col-sm-12 col-xs-12"
										id="view_lable_value">
										<div class="col-md-2 col-sm-12 col-xs-12">
											<label for="text1" class="control-label" id="viewlable">
												<s:text name="Account Name" />
											</label>
										</div>
										<div class="col-md-10 col-sm-12 col-xs-12">
											<label for="text1" class="control-label "><s:property
													value="accountName" /></label>
										</div>
									</div>
								</div>

								<div class="row">
									<div class="col-md-12 col-sm-12 col-xs-12"
										id="view_lable_value2">
										<div class="col-md-2 col-sm-12 col-xs-12">
											<label for="text1" class="control-label" id="viewlable">
												<s:text name="Account Type" />
											</label>
										</div>
										<div class="col-md-10 col-sm-12 col-xs-12">
											<label for="text1" class="control-label"> <s:property
													value="accountType" /></label>
										</div>
									</div>
								</div>

								<div class="row">
									<div class="col-md-12 col-sm-12 col-xs-12"
										id="view_lable_value">
										<div class="col-md-2 col-sm-12 col-xs-12">
											<label for="text1" class="control-label" id="viewlable">
												<s:text name="Ownership Type"></s:text>
											</label>
										</div>
										<div class="col-md-10 col-sm-12 col-xs-12">
											<label for="text1" class="control-label"><s:property
													value="ownershipType" /> </label>
										</div>
									</div>
								</div>

								<div class="row">
									<div class="col-md-12 col-sm-12 col-xs-12"
										id="view_lable_value2">
										<div class="col-md-2 col-sm-12 col-xs-12">
											<label for="text1" class="control-label" id="viewlable">
												<s:text name="Orgnisation Category" />
											</label>
										</div>
										<div class="col-md-10 col-sm-12 col-xs-12">
											<label for="text1" class="control-label"> <s:property
													value="orgnisationCategory" /></label>
										</div>
									</div>
								</div>

								<div class="row">
									<div class="col-md-12  col-sm-12 col-xs-12"
										id="view_lable_value">
										<div class="col-md-2 col-sm-12 col-xs-12">
											<label for="text1" class="control-label" id="viewlable">
												<s:text name="Orgnisation Sector" />
											</label>
										</div>
										<div class="col-md-10 col-sm-12 col-xs-12">
											<label for="text1" class="control-label"><s:property
													value="orgnisationSector" /></label>

										</div>
									</div>
								</div>


								<div class="row">
									<div class="col-md-12  col-sm-12 col-xs-12"
										id="view_lable_value2">
										<div class="col-md-2 col-sm-12 col-xs-12">
											<label for="text1" class="control-label" id="viewlable"><s:text
													name="add.create.lead.annual.revneue" /> &nbsp; (<span
												class="fa fa-rupee "></span>)</label>
										</div>
										<div class="col-md-10 col-sm-12 col-xs-12">
											<label for="text1" class="control-label"><s:property
													value="annualRevenue" /></label>
										</div>
									</div>
								</div>

								<div class="row">
									<div class="col-md-12  col-sm-12 col-xs-12"
										id="view_lable_value">
										<div class="col-md-2 col-sm-12 col-xs-12">
											<label for="text1" class="control-label" id="viewlable">
												<s:text name="add.create.lead.no.of.associate" />
											</label>
										</div>
										<div class="col-md-10 col-sm-12 col-xs-12">
											<label for="text1" class="control-label"><s:property
													value="noOfAssociates" /></label>
										</div>
									</div>
								</div>


								<div class="row">
									<div class="col-md-12  col-sm-12 col-xs-12"
										id="view_lable_value2">
										<div class="col-md-2 col-sm-12 col-xs-12">
											<label for="text1" class="control-label" id="viewlable">
												<s:text name="Ratings" />
											</label>
										</div>
										<div class="col-md-10 col-sm-12 col-xs-12">
											<label for="text1" class="control-label"><s:property
													value="ratings" /></label>
										</div>
									</div>
								</div>

								<div class="row">
									<div class="col-md-12 col-sm-12 col-xs-12"
										id="view_lable_value">
										<div class="col-md-2 col-sm-12 col-xs-12">
											<label for="text1" class="control-label" id="viewlable"><s:text
													name="add.create.lead.phone" /></label>
										</div>
										<div class="col-md-10 col-sm-12 col-xs-12">
											<label for="text1" class="control-label"><s:property
													value="phoneNo" /></label>
										</div>
									</div>
								</div>

								<div class="row">
									<div class="col-md-12 col-sm-12 col-xs-12"
										id="view_lable_value2">
										<div class="col-md-2 col-sm-12 col-xs-12">
											<label for="text1" class="control-label" id="viewlable"><s:text
													name="add.create.lead.mobile"></s:text></label>
										</div>
										<div class="col-md-10 col-sm-12 col-xs-12">
											<label for="text1" class="control-label"><s:property
													value="mobileNo" /></label>
										</div>
									</div>
								</div>

								<div class="row">
									<div class="col-md-12 col-sm-12 col-xs-12"
										id="view_lable_value">
										<div class="col-md-2 col-sm-12 col-xs-12">
											<label for="text1" class="control-label" id="viewlable"><s:text
													name="user.login.E-MailID"></s:text></label>
										</div>
										<div class="col-md-10 col-sm-12 col-xs-12">
											<label for="text1" class="control-label"><s:property
													value="emailId" /></label>
										</div>
									</div>
								</div>


								<div class="row">
									<div class="col-md-12  col-sm-12 col-xs-12"
										id="view_lable_value2">
										<div class="col-md-2 col-sm-12 col-xs-12">
											<label for="text1" class="control-label" id="viewlable">
												<s:text name="Parent Account" />
											</label>
										</div>
										<div class="col-md-10 col-sm-12 col-xs-12">
											<label for="text1" class="control-label"><s:property
													value="parentAccount" /></label>
										</div>
									</div>
								</div>

								<div class="row">
									<div class="col-md-12  col-sm-12 col-xs-12"
										id="view_lable_value">
										<div class="col-md-2 col-sm-12 col-xs-12">
											<label for="text1" class="control-label" id="viewlable"><s:text
													name="Assign To" /> </label>
										</div>
										<div class="col-md-10 col-sm-12 col-xs-12">
											<label for="text1" class="control-label"><s:property
													value="assignTo" /></label>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12  col-sm-12 col-xs-12"
										id="view_lable_value2">
										<div class="col-md-2 col-sm-12 col-xs-12">
											<label for="text1" class="control-label" id="viewlable">
												<s:text name="SLA Name" />
											</label>
										</div>
										<div class="col-md-10 col-sm-12 col-xs-12">
											<label for="text1" class="control-label"><s:property
													value="slaName" /></label>
										</div>
									</div>
								</div>

								<div class="row">
									<div class="col-md-12  col-sm-12 col-xs-12"
										id="view_lable_value">
										<div class="col-md-2 col-sm-12 col-xs-12">
											<label for="text1" class="control-label" id="viewlable"><s:text
													name="Notify Owner" /> </label>
										</div>
										<div class="col-md-10 col-sm-12 col-xs-12">
											<label for="text1" class="control-label"><s:property
													value="notifyOwner" /></label>
										</div>
									</div>
								</div>

								<div class="row">
									<div class="col-md-12 col-sm-12 col-xs-12"
										id="view_lable_value2">
										<div class="col-md-2 col-sm-12 col-xs-12">
											<label for="text1" class="control-label" id="viewlable"><s:text
													name="Email Opt Out"></s:text></label>
										</div>
										<div class="col-md-10 col-sm-12 col-xs-12">
											<label for="text1" class="control-label"><s:property
													value="emailOptOut" /></label>
										</div>
									</div>
								</div>

								<div class="row">
									<div class="col-md-12 col-sm-12 col-xs-12"
										id="view_lable_value">
										<div class="col-md-2 col-sm-12 col-xs-12">
											<label for="text1" class="control-label" id="viewlable"><s:text
													name="update.group.createdby"></s:text></label>
										</div>
										<div class="col-md-10 col-sm-12 col-xs-12">
											<label for="text1" class="control-label"><s:property
													value="createdByName" /></label>
										</div>
									</div>
								</div>

								<div class="row">
									<div class="col-md-12 col-sm-12 col-xs-12"
										id="view_lable_value2">
										<div class="col-md-2 col-sm-12 col-xs-12">
											<label for="text1" class="control-label" id="viewlable"><s:text
													name="update.lead.info.creation.date"></s:text></label>
										</div>
										<div class="col-md-10 col-sm-12 col-xs-12">
											<label for="text1" class="control-label"><s:property
													value="createdDate" /></label>
										</div>
									</div>
								</div>


								<div class="row">
									<div
										class="col-lg-12 col-md-12 col-sm-12 col-xs-12 viewinnertitle">
										<h5>
											<s:text name="Mailling Contact Information" />
										</h5>
									</div>
								</div>

								<div class="row">
									<div class="col-md-12  col-sm-12 col-xs-12"
										id="view_lable_value">
										<div class="col-md-2 col-sm-12 col-xs-12">
											<label for="text1" class="control-label" id="viewlable"><s:text
													name="add.group.contact.person" /></label>
										</div>
										<div class="col-md-10 col-sm-12 col-xs-12">
											<label for="text1" class="control-label"><s:property
													value="billingContactPersone" /></label>
										</div>

									</div>
								</div>
								<div class="row">
									<div class="col-md-12  col-sm-12 col-xs-12"
										id="view_lable_value2">
										<div class="col-md-2 col-sm-12 col-xs-12">
											<label for="text1" class="control-label" id="viewlable"><s:text
													name="add.group.designation" /></label>
										</div>
										<div class="col-md-10 col-sm-12 col-xs-12">
											<label for="text1" class="control-label"><s:property
													value="billingDesignation" /></label>
										</div>
									</div>
								</div>



								<div class="row">
									<div class="col-md-12  col-sm-12 col-xs-12"
										id="view_lable_value">
										<div class="col-md-2 col-sm-12 col-xs-12">
											<label for="text1" class="control-label" id="viewlable">
												<s:text name="add.create.lead.adress.line1" />
											</label>
										</div>
										<div class="col-md-10 col-sm-12 col-xs-12">
											<label for="text1" class="control-label"><s:property
													value="billingAddressLine1" /></label>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12  col-sm-12 col-xs-12"
										id="view_lable_value2">
										<div class="col-md-2 col-sm-12 col-xs-12">
											<label for="text1" class="control-label" id="viewlable">
												<s:text name="add.create.lead.adress.line2" />
											</label>
										</div>
										<div class="col-md-10 col-sm-12 col-xs-12">
											<label for="text1" class="control-label"><s:property
													value="billingAddressLine2" /></label>
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
										<div class="col-md-10 col-sm-12 col-xs-12">
											<label for="text1" class="control-label"> <s:property
													value="billingCity" /></label>
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
										<div class="col-md-10 col-sm-12 col-xs-12">
											<label for="text1" class="control-label"> <s:property
													value="billingState" /></label>
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
										<div class="col-md-10 col-sm-12 col-xs-12">
											<label for="text1" class="control-label"> <s:property
													value="billingCountry" /></label>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12  col-sm-12 col-xs-12"
										id="view_lable_value2">
										<div class="col-md-2  col-sm-12 col-xs-12">
											<label for="text1" class="control-label" id="viewlable"><s:text
													name="add.create.lead.zipcode" /></label>
										</div>
										<div class="col-md-10 col-sm-12 col-xs-12">
											<label for="text1" class="control-label"> <s:property
													value="billingZipcode" /></label>
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
										<div class="col-md-10 col-sm-12 col-xs-12">
											<label for="text1" class="control-label"><s:property
													value="billingPhoneNo" /></label>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12  col-sm-12 col-xs-12"
										id="view_lable_value2">
										<div class="col-md-2  col-sm-12 col-xs-12">
											<label class="control-label" id="viewlable"><s:text
													name="add.create.lead.mobile" /></label>
										</div>
										<div class="col-md-10 col-sm-12 col-xs-12">
											<label for="text1" class="control-label"> <s:property
													value="billingMobileNo" /></label>
										</div>

									</div>
								</div>
								<div class="row">
									<div class="col-md-12  col-sm-12 col-xs-12"
										id="view_lable_value">
										<div class="col-md-2  col-sm-12 col-xs-12">
											<label class="control-label" id="viewlable"><s:text
													name="add.create.lead.primary.email.id" /></label>
										</div>
										<div class="col-md-10 col-sm-12 col-xs-12">
											<label for="text1" class="control-label"> <s:property
													value="billingPrimaryEmail" /></label>
										</div>

									</div>
								</div>
								<div class="row">
									<div class="col-md-12  col-sm-12 col-xs-12"
										id="view_lable_value2">
										<div class="col-md-2  col-sm-12 col-xs-12">
											<label class="control-label" id="viewlable"><s:text
													name="add.create.lead.alternate.email.id" /></label>
										</div>
										<div class="col-md-10 col-sm-12 col-xs-12">
											<label for="text1" class="control-label"> <s:property
													value="billingAlternateEmail" /></label>
										</div>

									</div>
								</div>
								<div class="row">
									<div class="col-md-12  col-sm-12 col-xs-12"
										id="view_lable_value">
										<div class="col-md-2  col-sm-12 col-xs-12">
											<label class="control-label" id="viewlable"><s:text
													name="add.create.lead.fax" /></label>
										</div>
										<div class="col-md-10 col-sm-12 col-xs-12">
											<label for="text1" class="control-label"> <s:property
													value="billingFax" /></label>
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
										<div class="col-md-10 col-sm-12 col-xs-12">
											<label for="text1" class="control-label"> <s:property
													value="billingWebsite" /></label>
										</div>

									</div>
								</div>


								<div class="row">
									<div
										class="col-lg-12 col-md-12 col-sm-12 col-xs-12 viewinnertitle">
										<h5>
											<s:text name="add.group.shipping.contact.info" />
										</h5>
									</div>

								</div>

								<div class="row">
									<div class="col-md-12  col-sm-12 col-xs-12"
										id="view_lable_value">
										<div class="col-md-2 col-sm-12 col-xs-12">
											<label for="text1" class="control-label" id="viewlable"><s:text
													name="add.group.contact.person" /></label>
										</div>
										<div class="col-md-10 col-sm-12 col-xs-12">
											<label for="text1" class="control-label"><s:property
													value="shippingContactPersone" /></label>
										</div>

									</div>
								</div>
								<div class="row">
									<div class="col-md-12  col-sm-12 col-xs-12"
										id="view_lable_value2">
										<div class="col-md-2 col-sm-12 col-xs-12">
											<label for="text1" class="control-label" id="viewlable"><s:text
													name="add.group.designation" /></label>
										</div>
										<div class="col-md-10 col-sm-12 col-xs-12">
											<label for="text1" class="control-label"><s:property
													value="shippingDesignation" /></label>
										</div>
									</div>
								</div>



								<div class="row">
									<div class="col-md-12  col-sm-12 col-xs-12"
										id="view_lable_value">
										<div class="col-md-2 col-sm-12 col-xs-12">
											<label for="text1" class="control-label" id="viewlable">
												<s:text name="add.create.lead.adress.line1" />
											</label>
										</div>
										<div class="col-md-10 col-sm-12 col-xs-12">
											<label for="text1" class="control-label"><s:property
													value="shippingAddressLine1" /></label>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12  col-sm-12 col-xs-12"
										id="view_lable_value2">
										<div class="col-md-2 col-sm-12 col-xs-12">
											<label for="text1" class="control-label" id="viewlable">
												<s:text name="add.create.lead.adress.line2" />
											</label>
										</div>
										<div class="col-md-10 col-sm-12 col-xs-12">
											<label for="text1" class="control-label"><s:property
													value="shippingAddressLine2" /></label>
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
										<div class="col-md-10 col-sm-12 col-xs-12">
											<label for="text1" class="control-label"><s:property
													value="shippingCity" /></label>
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
										<div class="col-md-10 col-sm-12 col-xs-12">
											<label for="text1" class="control-label"><s:property
													value="shippingState" /></label>
										</div>
									</div>
								</div>




								<div class="row">
									<div class="col-md-12  col-sm-12 col-xs-12"
										id="view_lable_value">
										<div class="col-md-2 col-sm-12 col-xs-12">
											<label for="text1" class="control-label" id="viewlable"><s:text
													name="add.create.lead.country" /> </label>
										</div>
										<div class="col-md-10 col-sm-12 col-xs-12">
											<label for="text1" class="control-label"><s:property
													value="shippingCountry" /></label>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12  col-sm-12 col-xs-12"
										id="view_lable_value2">
										<div class="col-md-2  col-sm-12 col-xs-12">
											<label for="text1" class="control-label" id="viewlable"><s:text
													name="add.create.lead.zipcode" /></label>
										</div>
										<div class="col-md-10 col-sm-12 col-xs-12">
											<label for="text1" class="control-label"><s:property
													value="shippingZipcode" /></label>
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
										<div class="col-md-10 col-sm-12 col-xs-12">
											<label for="text1" class="control-label"><s:property
													value="shippingPhoneNo" /></label>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12  col-sm-12 col-xs-12"
										id="view_lable_value2">
										<div class="col-md-2  col-sm-12 col-xs-12">
											<label class="control-label" id="viewlable"><s:text
													name="add.create.lead.mobile" /></label>
										</div>
										<div class="col-md-10 col-sm-12 col-xs-12">
											<label for="text1" class="control-label"> <s:property
													value="shippingMobileNo" /></label>
										</div>

									</div>
								</div>
								<div class="row">
									<div class="col-md-12  col-sm-12 col-xs-12"
										id="view_lable_value">
										<div class="col-md-2  col-sm-12 col-xs-12">
											<label class="control-label" id="viewlable"> <s:text
													name="add.create.lead.primary.email.id" /></label>
										</div>
										<div class="col-md-10 col-sm-12 col-xs-12">
											<label for="text1" class="control-label"> <s:property
													value="shippingPrimaryEmail" />
											</label>
										</div>

									</div>
								</div>
								<div class="row">
									<div class="col-md-12  col-sm-12 col-xs-12"
										id="view_lable_value2">
										<div class="col-md-2  col-sm-12 col-xs-12">
											<label class="control-label" id="viewlable"><s:text
													name="add.create.lead.alternate.email.id" /></label>
										</div>
										<div class="col-md-10 col-sm-12 col-xs-12">
											<label for="text1" class="control-label"> <s:property
													value="shippingAlternateEmail" /></label>
										</div>

									</div>
								</div>
								<div class="row">
									<div class="col-md-12  col-sm-12 col-xs-12"
										id="view_lable_value">
										<div class="col-md-2  col-sm-12 col-xs-12">
											<label class="control-label" id="viewlable"><s:text
													name="add.create.lead.fax" /></label>
										</div>
										<div class="col-md-10 col-sm-12 col-xs-12">
											<label for="text1" class="control-label"> <s:property
													value="shippingFax" /></label>
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
										<div class="col-md-10 col-sm-12 col-xs-12">
											<label for="text1" class="control-label"> <s:property
													value="shippingWebsite" /></label>
										</div>

									</div>
								</div>

								<div class="row">
									<div
										class="col-lg-12 col-md-12 col-sm-12 col-xs-12 viewinnertitle">
										<h5>
											<s:text name="add.group.profile.description" />
										</h5>
									</div>

								</div>
								<%-- <div class="row">
									<div class="col-lg-12">
										<div class="box">
											<header>

											<ul class="nav nav-tabs pull-right">

												<li><a href="#preview" data-toggle="tab"
													style="color: #755252"><s:text
															name="view.group.info.expand" /></a></li>
											</ul>
											</header>
											<div id="div-3" class="body tab-content">

												<div class="tab-pane fade" id="preview">
													<div id="wmd-preview" class="wmd-panel wmd-preview">
														<label class="control-label">${profileDescription}
														</label>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div> --%>

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
								<%-- </s:iterator> --%>
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
													<s:iterator value="groupSocialDetailList">
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
							</div>
						</s:form>
					</div>

				</div>
			</div>
		</div>
	</div>
</body>
</html>