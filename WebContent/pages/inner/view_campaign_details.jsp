<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>

	<div class="outer">
		<div class="inner bg-light lter">
			<div class="box">
				<header> <a class="icons" href="campaignDashboard.action"
					data-toggle="tooltip"
					data-original-title="Back To campaigm DashBoard"
					style="color: black;"> <i class="fa fa-th-large"></i>
				</a>
				<h5>
					<s:text name="add.create.campaign.campaign.details" />
				</h5>
				<div class="pull-right">

					<div class="btn-group">
						<a class="btn btn-default btnheight" data-toggle="tooltip"
							data-original-title="Help"><i class="fa fa-question"></i> <s:text
								name="project.form.button.help"></s:text> </a> <a type="button"
							class="btn btn-primary btnheight"><i class="fa fa-print"></i>
							Print</a> <a
							href="campaigndPrintPDF.action?command=<s:property value='campaigmId' />"
							class="btn btn-success btnheight"><i
							class="fa fa-file-pdf-o "></i> Pdf</a> <a type="button"
							class="btn btn-default btnheight"><i
							class="fa fa-chevron-left"></i></a> <a
							href="campaigndPrintPDF.action?command=<s:property value='campaigmId' />"
							class="btn btn-default btnheight"><i
							class="fa fa-chevron-right"></i></a> <a
							href="campaignDashboard.action" class="btn btn-danger btnheight"><i
							class="fa fa-times"></i></a>
					</div>

				</div>
				</header>

				<div class="container-fluid">
					<div id="div-2" class="body">
						<form class="form-horizontal">
							<s:iterator value="CampaignVO" var="">
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
												<s:text name="add.create.campaign.information.bar" />
											</div>
										</div>
									</s:else>
								</p>
								<div class="row">
									<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
										<h5 class="innertitle">
											<s:text name="add.create.campaign.campaign.information" />
										</h5>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12 col-sm-12 col-xs-12">
										<div class="col-md-2 col-sm-12 col-xs-12" id="view_lable">
											<label for="text1" class="control-label " id="viewlable">
												<s:text name="add.create.campaign.campaign.name" />
											</label>
										</div>
										<div class="col-md-10 col-sm-12 col-xs-12 control-label"
											id="view_lable_value2">
											<s:property value="fullName" />
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12 col-sm-12 col-xs-12">
										<div class="col-md-2 col-sm-12 col-xs-12" id="view_lable">
											<label for="text1" class="control-label" id="viewlable">
												<s:text name="add.create.campaign.campaign.owner" />
											</label>
										</div>
										<div class="col-md-10 col-sm-12 col-xs-12 control-label"
											id="view_lable_value">
											<s:property value="campaignOwner" />

										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12 col-sm-12 col-xs-12">
										<div class="col-md-2 col-sm-12 col-xs-12" id="view_lable">
											<label for="text1" class="control-label" id="viewlable">
												<s:text name="add.create.campaign.expected.close.date" />
											</label>
										</div>
										<div class="col-md-10 col-sm-12 col-xs-12 control-label"
											id="view_lable_value2">
											<s:property value="expectedCloseDate" />
										</div>

									</div>
								</div>
								<div class="row">
									<div class="col-md-12 col-sm-12 col-xs-12">
										<div class="col-md-2 col-sm-12 col-xs-12" id="view_lable">
											<label for="text1" class="control-label" id="viewlable">
												<s:text name="add.create.campaign.assigned.to" />
											</label>
										</div>
										<div class="col-md-10 col-sm-12 col-xs-12 control-label"
											id="view_lable_value">
											<s:property value="assignedTo" />
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12  col-sm-12 col-xs-12">
										<div class="col-md-2 col-sm-12 col-xs-12" id="view_lable">
											<label for="text1" class="control-label" id="viewlable"><s:text
													name="add.create.campaign.product" /></label>
										</div>
										<div class="col-md-10 col-sm-12 col-xs-12 control-label"
											id="view_lable_value2">
											<s:property value="product" />
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12  col-sm-12 col-xs-12">
										<div class="col-md-2 col-sm-12 col-xs-12" id="view_lable">
											<label for="text1" class="control-label" id="viewlable"><s:text
													name="add.create.campaign.campaign.type" /></label>
										</div>
										<div class="col-md-10 col-sm-12 col-xs-12 control-label"
											id="view_lable_value">
											<s:property value="campaignType" />
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12  col-sm-12 col-xs-12">
										<div class="col-md-2 col-sm-12 col-xs-12" id="view_lable">
											<label for="text1" class="control-label" id="viewlable"><s:text
													name="add.create.campaign.campaign.status" /></label>
										</div>
										<div class="col-md-10 col-sm-12 col-xs-12 control-label"
											id="view_lable_value2">
											<s:property value="campaignStatus" />
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12  col-sm-12 col-xs-12">
										<div class="col-md-2 col-sm-12 col-xs-12" id="view_lable">
											<label for="text1" class="control-label" id="viewlable"><s:text
													name="add.create.campaign.target.audience" /></label>
										</div>
										<div class="col-md-10 col-sm-12 col-xs-12 control-label"
											id="view_lable_value">
											<s:property value="targetAudience" />
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12  col-sm-12 col-xs-12">
										<div class="col-md-2 col-sm-12 col-xs-12" id="view_lable">
											<label for="text1" class="control-label" id="viewlable"><s:text
													name="add.create.campaign.target.size" /></label>
										</div>
										<div class="col-md-10 col-sm-12 col-xs-12 control-label"
											id="view_lable_value2">
											<s:property value="targetSize" />
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12  col-sm-12 col-xs-12">
										<div class="col-md-2 col-sm-12 col-xs-12" id="view_lable">
											<label for="text1" class="control-label" id="viewlable"><s:text
													name="add.create.campaign.sponsor" /></label>
										</div>
										<div class="col-md-10 col-sm-12 col-xs-12 control-label"
											id="view_lable_value">
											<s:property value="sponsor" />
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12 col-sm-12 col-xs-12">
										<div class="col-md-2 col-sm-12 col-xs-12" id="view_lable">
											<label for="text1" class="control-label" id="viewlable"><s:text
													name="add.create.campaign.num.sent" /></label>
										</div>
										<div class="col-md-10 col-sm-12 col-xs-12 control-label"
											id="view_lable_value2">
											<s:property value="numSent" />
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
										<h5 class="innertitle">
											<s:text name="add.create.campaign.expectations.actuals" />
										</h5>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12  col-sm-12 col-xs-12">
										<div class="col-md-2 col-sm-12 col-xs-12" id="view_lable">
											<label for="text1" class="control-label" id="viewlable"><s:text
													name="add.create.campaign.budget.cost" /></label>
										</div>
										<div class="col-md-10 col-sm-12 col-xs-12 "
											id="view_lable_value">
											<s:property value="budgetCost" />
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12  col-sm-12 col-xs-12">
										<div class="col-md-2 col-sm-12 col-xs-12" id="view_lable">
											<label for="text1" class="control-label" id="viewlable"><s:text
													name="add.create.campaign.actual.cost" /></label>
										</div>
										<div class="col-md-10 col-sm-12 col-xs-12 control-label"
											id="view_lable_value2">
											<s:property value="actualCost" />
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12  col-sm-12 col-xs-12">
										<div class="col-md-2 col-sm-12 col-xs-12" id="view_lable">
											<label for="text1" class="control-label" id="viewlable"><s:text
													name="add.create.campaign.expected.revenue" /></label>
										</div>
										<div class="col-md-10 col-sm-12 col-xs-12 control-label"
											id="view_lable_value">
											<s:property value="expectedRevenue" />
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12  col-sm-12 col-xs-12">
										<div class="col-md-2 col-sm-12 col-xs-12" id="view_lable">
											<label for="text1" class="control-label" id="viewlable"><s:text
													name="add.create.campaign.expected.response" /></label>
										</div>
										<div class="col-md-10 col-sm-12 col-xs-12 control-label"
											id="view_lable_value2">
											<s:property value="expectedResponse" />
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12  col-sm-12 col-xs-12">
										<div class="col-md-2 col-sm-12 col-xs-12" id="view_lable">
											<label for="text1" class="control-label" id="viewlable"><s:text
													name="add.create.campaign.expected.sales.count" /></label>
										</div>
										<div class="col-md-10 col-sm-12 col-xs-12 control-label"
											id="view_lable_value">
											<s:property value="expectedSalesCount" />
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12  col-sm-12 col-xs-12">
										<div class="col-md-2 col-sm-12 col-xs-12" id="view_lable">
											<label for="text1" class="control-label" id="viewlable"><s:text
													name="add.create.campaign.actual.sales.count" /></label>
										</div>
										<div class="col-md-10 col-sm-12 col-xs-12 control-label"
											id="view_lable_value2">
											<s:property value="actualSalesCount" />
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12  col-sm-12 col-xs-12">
										<div class="col-md-2 col-sm-12 col-xs-12" id="view_lable">
											<label for="text1" class="control-label" id="viewlable"><s:text
													name="add.create.campaign.expected.response.count" /></label>
										</div>
										<div class="col-md-10 col-sm-12 col-xs-12 control-label"
											id="view_lable_value">
											<s:property value="expectedResponseCount" />
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12  col-sm-12 col-xs-12">
										<div class="col-md-2 col-sm-12 col-xs-12" id="view_lable">
											<label for="text1" class="control-label" id="viewlable"><s:text
													name="add.create.campaign.actual.response.count" /></label>
										</div>
										<div class="col-md-10 col-sm-12 col-xs-12 control-label"
											id="view_lable_value2">
											<s:property value="actualResponseCount" />
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12  col-sm-12 col-xs-12">
										<div class="col-md-2 col-sm-12 col-xs-12" id="view_lable">
											<label for="text1" class="control-label" id="viewlable"><s:text
													name="add.create.campaign.expected.roi" /></label>
										</div>
										<div class="col-md-10 col-sm-12 col-xs-12 control-label"
											id="view_lable_value">
											<s:property value="expectedROI" />
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12  col-sm-12 col-xs-12">
										<div class="col-md-2 col-sm-12 col-xs-12" id="view_lable">
											<label for="text1" class="control-label" id="viewlable"><s:text
													name="add.create.campaign.actual.roi" /></label>
										</div>
										<div class="col-md-10 col-sm-12 col-xs-12 control-label"
											id="view_lable_value2">
											<s:property value="actualROI" />
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12  col-sm-12 col-xs-12">
										<div class="col-md-2 col-sm-12 col-xs-12" id="view_lable">
											<label for="text1" class="control-label" id="viewlable"><s:text
													name="add.create.campaign.created.by" /></label>
										</div>
										<div class="col-md-10 col-sm-12 col-xs-12 control-label"
											id="view_lable_value2">
											<s:property value="createdBy" />
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12  col-sm-12 col-xs-12">
										<div class="col-md-2 col-sm-12 col-xs-12" id="view_lable">
											<label for="text1" class="control-label" id="viewlable"><s:text
													name="add.create.campaign.created.date" /></label>
										</div>
										<div class="col-md-10 col-sm-12 col-xs-12 control-label"
											id="view_lable_value2">
											<s:property value="createdDate" />
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12  col-sm-12 col-xs-12">
										<div class="col-md-2 col-sm-12 col-xs-12" id="view_lable">
											<label for="text1" class="control-label" id="viewlable"><s:text
													name="add.create.campaign.updated.by" /></label>
										</div>
										<div class="col-md-10 col-sm-12 col-xs-12 control-label"
											id="view_lable_value2">
											<s:property value="updatedBy" />
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12  col-sm-12 col-xs-12">
										<div class="col-md-2 col-sm-12 col-xs-12" id="view_lable">
											<label for="text1" class="control-label" id="viewlable"><s:text
													name="add.create.campaign.update.date" /></label>
										</div>
										<div class="col-md-10 col-sm-12 col-xs-12 control-label"
											id="view_lable_value2">
											<s:property value="updateDate" />
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
										<h5 class="innertitle">
											<s:text name="add.create.campaign.description.details" />
										</h5>
									</div>
								</div>
								<div class="row">
									<div class="col-lg-12">
										<div>
											<div id="div-3" class="body tab-content ">
												<div class="collapse in" id="show">
													<div id="wmd-preview" class="wmd-panel wmd-preview">
														${description}</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</s:iterator>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>