<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="/struts-jquery-tags" prefix="sj"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<script>
	function PopupCenter(pageURL, title, w, h) {
		var left = (screen.width / 2) - (w / 2);
		var top = (screen.height / 2) - (h / 2);
		var targetWin = window
				.open(
						pageURL,
						title,
						'toolbar=no, location=no, directories=no, status=no, menubar=no, scrollbars=no, resizable=no, copyhistory=no, width='
								+ w
								+ ', height='
								+ h
								+ ', top='
								+ top
								+ ', left=' + left);
	}
</script>

<style type="text/css">
.error_strings {
	color: red;
}
</style>
<script type="text/javascript" src="inner/assets/js/modal.js"></script>
<script type="text/javascript">
	var xmlhttp;
	if (window.XMLHttpRequest) {
		xmlhttp = new XMLHttpRequest();
	} else {
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}

	/* This function will insert the social site value into database */
	function addSocialSite() {

		var socialSiteId = document.getElementById("addSocialSite1").value;
		var socialSiteValue = document.getElementById("socialId").value;

		/* alert(socialSiteId);
		alert(socialSiteValue); */
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				document.insertSocialSite("server1Response").innerHTML = xmlhttp.responseText;
			}
		};
		xmlhttp.open("GET", "addSocialSiteAction.action?socialSiteId="
				+ socialSiteId + "&socialSiteValue=" + socialSiteValue, true);
		xmlhttp.send();
	}
</script>
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
							<li><a href="campaignDashboard.action"><s:text
										name="navbar.campaign"></s:text></a></li>
							<li class="active"><s:text name="navbar.campaign.dashboard"></s:text></li>
							<li class="active"><s:text name="navbar.editcampaign"></s:text></li>
						</ol>
						<s:form name="addCreatedCampaignForm"
							action="updateCampaignDetails" class="form-horizontal"
							id="block-validate">
							<s:iterator value="CampaignVO">
								<div class="box dark">
									<header>
									<div class="pull-left">
										<a class="icons" href="campaignDashboard.action"
											data-toggle="tooltip"
											data-original-title="Back To Campaign DashBoard"
											style="color: black;"> <i class="fa fa-th-large"></i>
										</a>
										<h5>
											<s:text name="edit.campaign.update.campaign" />
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
											<s:text name="project.form.button.convert"></s:text></a>
										<button type="button" data-toggle="tooltip"
											data-original-title="Refresh"
											class="btn btn-success btnheight"
											onclick="window.location.reload();">
											<i class="fa fa-refresh "></i>
										</button>
										<a
											href="#.action?command=<s:property value=''/>"
											class="btn btn-warning btnheight" data-toggle="tooltip"
											data-original-title="Clone"><i class="fa fa-users"></i>&nbsp;<s:text
												name="project.form.button.clone"></s:text></a> <a
											data-toggle="tooltip" data-original-title="Previous"
											type="button" class="btn btn-default btnheight"
											href="#"><i
											class="fa fa-chevron-left fontawesomeht"></i></a> <a
											data-toggle="tooltip" data-original-title="Next"
											href="#"
											class="btn btn-default btnheight"><i
											class="fa fa-chevron-right fontawesomeht"></i></a> <a
											data-toggle="tooltip" data-original-title="Close"
											href="campaignDashboard.action" class="btn btn-danger btnheight"><i
											class="fa fa-times fontawesomeht"></i></a>
									</div>

									</div>
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
														<s:text name="edit.campaign.information.bar" />
													</div>
												</div>
											</s:else>
										</p>



										<div class="row" style="margin-top: 20px;">
											<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
												<h5 class="innertitle">
													<s:text name="add.create.campaign.campaign.information" />
												</h5>
												<hr style="margin-top: -5px">
											</div>
										</div>


										<div class="row">
											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
														<s:text name="add.create.campaign.campaign.name" />
														<div class="star">*</div>
													</div>
													<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
														<div class="row">
															<div class="col-lg-3 col-md-3 col-sm-3 col-xs-5">
																<s:select class="form-control" name="salutation"
																	headerKey="-1"
																	headerValue="%{getText('add.create.campaign.please.holder.salutation')}"
																	tabindex="2" list="salutationList"
																	cssClass="form-control" />
																<div id='addCreatedLeadForm_salutation_errorloc'
																	class="error_strings"></div>
															</div>
															<div class="col-lg-9 col-md-9 col-sm-9 col-xs-12">
																<s:textfield type="text" name="campaignName"
																	cssClass="form-control" tabindex="1" />
																<div id='addCreatedCampaignForm_campaignName_errorloc'
																	class="error_strings"></diV>
															</div>
														</div>
													</div>
												</div>
											</div>
											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
														<s:text name="add.create.campaign.campaign.owner" />
														<div class="star">*</div>
													</div>
													<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
														<s:select name="campaignOwner" headerKey="-1"
															headerValue="%{getText('add.create.campaign.please.holder.campaign.owner')}"
															tabindex="2" list="campaignOwnerList"
															cssClass="form-control chzn-select" />
														<div id='addCreatedCampaignForm_campaignOwner_errorloc'
															class="error_strings"></div>
													</div>
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
														<s:text name="add.create.campaign.expected.close.date" />
														<div class="star">*</div>
													</div>
													<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
														<s:textfield type="text" name="expectedCloseDate"
															class="form-control" id="dp3" cssClass="form-control"
															tabindex="14" />
														<div
															id='addCreatedCampaignForm_expectedCloseDate_errorloc'
															class="error_strings"></diV>
													</div>
												</div>
											</div>
											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
														<s:text name="add.create.campaign.assigned.to" />
														<div class="star">*</div>
													</div>
													<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
														<s:select name="assignedTo" headerKey="-1"
															headerValue="%{getText('add.create.campaign.please.holder.assigned.to')}"
															tabindex="2" list="campaignAssignedToList"
															cssClass="form-control chzn-select" />
														<div id='addCreatedCampaignForm_assignedTo_errorloc'
															class="error_strings"></div>
													</div>
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
														<s:text name="add.create.campaign.product" />
													</div>
													<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
														<s:select name="product" tabindex="2" headerKey="-1"
															headerValue="%{getText('add.create.campaign.please.holder.product')}"
															list="{1,2,3}" cssClass="form-control chzn-select" />
														<div id='addCreatedCampaignForm_product_errorloc'
															class="error_strings"></diV>
													</div>
												</div>
											</div>
											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
														<s:text name="add.create.campaign.campaign.type" />
													</div>
													<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
														<s:select name="campaignType" headerKey="-1"
															headerValue="%{getText('add.create.campaign.please.holder.campaign.type')}"
															tabindex="2" list="campaignTypeList"
															cssClass="form-control chzn-select" />
														<div id='addCreatedCampaignForm_campaignType_errorloc'
															class="error_strings"></div>
													</div>
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
														<s:text name="add.create.campaign.target.audience" />
													</div>
													<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
														<s:textfield type="text" name="targetAudience"
															cssClass="form-control" tabindex="1" />
														<div id='addCreatedCampaignForm_targetAudience_errorloc'
															class="error_strings"></div>
													</div>
												</div>
											</div>
											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
														<s:text name="add.create.campaign.sponsor" />
													</div>
													<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
														<s:textfield type="text" name="sponsor"
															cssClass="form-control" tabindex="1" />
														<div id='addCreatedCampaignForm_sponsor_errorloc'
															class="error_strings"></div>
													</div>
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
														<s:text name="add.create.campaign.target.size" />
													</div>
													<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
														<s:textfield type="text" name="targetSize"
															cssClass="form-control" tabindex="1" />
														<div id='addCreatedCampaignForm_targetSize_errorloc'
															class="error_strings"></diV>
													</div>
												</div>
											</div>
											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
														<s:text name="add.create.campaign.num.sent" />
													</div>
													<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
														<s:textfield type="text" name="numSent"
															cssClass="form-control" tabindex="1" />
														<div id='addCreatedCampaignForm_numSent_errorloc'
															class="error_strings"></diV>
													</div>
												</div>
											</div>
										</div>
										<div class="row" style="margin-top: 20px;">
											<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
												<h5 class="innertitle">
													<s:text name="add.create.campaign.expectations.actuals" />
												</h5>
												<hr style="margin-top: -5px">
											</div>
										</div>
										<div class="row">
											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
														<s:text name="add.create.campaign.budget.cost" />
													</div>
													<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
														<s:textfield type="text" name="budgetCost"
															cssClass="form-control" tabindex="1" />
														<div id='addCreatedCampaignForm_budgetCost_errorloc'
															class="error_strings"></diV>
													</div>
												</div>
											</div>
											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
														<s:text name="add.create.campaign.actual.cost" />
														<div class="star">*</div>
													</div>
													<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
														<s:textfield type="text" name="actualCost"
															cssClass="form-control" tabindex="1" />
														<div id='addCreatedCampaignForm_actualCost_errorloc'
															class="error_strings"></div>
													</div>
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
														<s:text name="add.create.campaign.expected.revenue" />
													</div>
													<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
														<s:textfield type="text" name="expectedRevenue"
															cssClass="form-control" tabindex="1" />
														<div id='addCreatedCampaignForm_expectedRevenue_errorloc'
															class="error_strings"></diV>
													</div>
												</div>
											</div>
											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
														<s:text name="add.create.campaign.expected.response" />
													</div>
													<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
														<s:select class="form-control" name="expectedResponse"
															headerKey="-1"
															headerValue="%{getText('add.create.campaign.please.holder.expected.response')}"
															tabindex="2" list="campaignExpectedResponseList"
															cssClass="form-control" />
														<div id='addCreatedCampaignForm_expectedResponse_errorloc'
															class="error_strings"></div>
													</div>
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
														<s:text name="add.create.campaign.expected.sales.count" />
													</div>
													<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
														<div class="input-group">
															<s:textfield type="text" name="expectedSalesCount"
																cssClass="form-control" tabindex="12" />

															<span class="input-group-btn">
																<button class="btn btn-metis-5 btn-line" type="button"
																	style="height: 34px"
																	onClick="PopupCenter('renderCalculator','RenderCalculator',260,350);">
																	<i class="fa fa-calculator"></i>
																</button>
															</span>


														</div>
														<div
															id='addCreatedCampaignForm_expectedSalesCount_errorloc'
															class="error_strings"></diV>
													</div>
												</div>
											</div>
											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
														<s:text name="add.create.campaign.actual.sales.count" />
													</div>
													<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
														<div class="input-group">
															<s:textfield type="text" name="actualSalesCount"
																cssClass="form-control" tabindex="12" />

															<span class="input-group-btn">
																<button class="btn btn-metis-5 btn-line" type="button"
																	style="height: 34px"
																	onClick="PopupCenter('renderCalculator','RenderCalculator',260,350);">
																	<i class="fa fa-calculator"></i>
																</button>
															</span>
														</div>
														<div id='addCreatedCampaignForm_actualSalesCount_errorloc'
															class="error_strings"></diV>
													</div>
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
														<s:text name="add.create.campaign.expected.response.count" />
													</div>
													<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
														<div class="input-group">
															<s:textfield type="text" name="expectedResponseCount"
																cssClass="form-control" tabindex="12" />

															<span class="input-group-btn">
																<button class="btn btn-metis-5 btn-line" type="button"
																	style="height: 34px"
																	onClick="PopupCenter('renderCalculator','RenderCalculator',260,350);">
																	<i class="fa fa-calculator"></i>
																</button>
															</span>
														</div>
														<div
															id='addCreatedCampaignForm_expectedResponseCount_errorloc'
															class="error_strings"></diV>
													</div>
												</div>
											</div>

											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
														<s:text name="add.create.campaign.actual.response.count" />
													</div>
													<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
														<div class="input-group">
															<s:textfield type="text" name="actualResponseCount"
																cssClass="form-control" tabindex="12" />

															<span class="input-group-btn">
																<button class="btn btn-metis-5 btn-line" type="button"
																	style="height: 34px"
																	onClick="PopupCenter('renderCalculator','RenderCalculator',260,350);">
																	<i class="fa fa-calculator"></i>
																</button>
															</span>
														</div>
														<div
															id='addCreatedCampaignForm_actualResponseCount_errorloc'
															class="error_strings"></diV>
													</div>
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
														<s:text name="add.create.campaign.expected.roi" />
													</div>
													<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
														<s:textfield type="text" name="expectedROI"
															cssClass="form-control" tabindex="1" />
														<div id='addCreatedCampaignForm_expectedROI_errorloc'
															class="error_strings"></diV>
													</div>
												</div>
											</div>
											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
														<s:text name="add.create.campaign.actual.roi" />
													</div>
													<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
														<s:textfield type="text" name="actualROI"
															cssClass="form-control" tabindex="1" />
														<div id='addCreatedCampaignForm_actualROI_errorloc'
															class="error_strings"></diV>
													</div>
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
														<s:text name="add.create.campaign.campaign.status" />
													</div>
													<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
														<s:textfield type="text" name="campaignStatus"
															cssClass="form-control" disabled="true" tabindex="19" />
														<div id='addCreatedCampaignForm_campaignStatus_errorloc'
															class="error_strings"></diV>
													</div>
												</div>
											</div>
											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
														<s:text name="new.vendors.created.by" />
													</div>
													<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
														<s:textfield type="text" name="createdBy" disabled="true"
															cssClass="form-control" tabindex="1" />
														<div id='addCreatedCampaignForm_targetAudience_errorloc'
															class="error_strings"></div>
													</div>
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
														<s:text name="add.create.campaign.created.date" />
													</div>
													<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
														<s:textfield type="text" name="createdDate"
															cssClass="form-control" disabled="true" tabindex="19" />
														<div id='addCreatedCampaignForm_campaignStatus_errorloc'
															class="error_strings"></diV>
													</div>
												</div>
											</div>
										</div>
										<div class="row" style="margin-top: 20px;">
											<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
												<h5 class="innertitle">
													<s:text name="add.create.campaign.description.details" />
												</h5>
												<hr style="margin-top: -5px">
											</div>
										</div>
										<div class="form-group">
											<div class="row" style="margin: 1% 2%;" id="data_grid">
												<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
													<div id='addCreatedCampaignForm_description_errorloc'
														class="error_strings"></div>
													<s:textarea id="wysihtml5" name="description"
														class="form-control" rows="10" tabindex="29">
													</s:textarea>
													<div id='addCreatedCampaignForm_description_errorloc'
														class="error_strings"></div>
												</div>
											</div>
										</div>
										<hr style="margin-top: 20px">
										<div class="row">

											<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"
												align="center">
												<a href="campaignDashboard.action" data-toggle="tooltip"
													data-original-title="Cancel"
													class="btn btn-default btnheight"><i
													class="fa fa-caret-square-o-left fontawesomeht"></i> <s:text
														name="project.form.button.cancel"></s:text></a>
												<button type="button" data-toggle="tooltip"
													data-original-title="Reset"
													class="btn btn-success btnheight"
													onclick="window.location.reload();">
													<i class="fa fa-refresh "></i>
													<s:text name="project.form.button.reset"></s:text>
												</button>
												<button type="submit" data-toggle="tooltip"
													data-original-title="Save"
													class="btn btn-primary btnheight">
													<i class="fa fa-check"></i>
													<s:text name="project.form.button.save"></s:text>
												</button>
											</div>
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

	<div class="modal fade" id="calculater" role="dialog">
		<div class="modal-dialog modal-sm">
			<div class="modal-content">
				<div class="modal-header"
					style="color: gray; background-color: #394B5E;">
					<button type="button" class="close" data-dismiss="modal"
						style="color: red; margin-top: -30px;">
						<h1>&times;</h1>
					</button>
					<h4 class="modal-title" style="color: gray;">Calculater</h4>
				</div>
				<div class="modal-body" style="color: gray;">
					<div class="row ">
						<div class="col-lg-12 col-md-10 col-xs-12 col-sm-10">

							<div class="col-lg-12 col-md-12 col-xs-12 col-sm-12"
								style="margin-bottom: 10px;">
								<!-- <input type="text" id="calculatortextid"
									style="height: 40px; width: 210px"
									autocomplete="off" /> -->
								<s:textfield id="calculatortextid" cssClass="form-control" />
							</div>

							<div class="col-lg-12 col-md-12 col-xs-12 col-sm-12">
								<button type="button" class="btn btn-defult"
									style="width: 50px; height: 50px; margin-left: 14px" id="idc"
									onclick="valueIdc()">
									<b>c</b>
								</button>
								<button type="button" class="btn btn-defult"
									style="width: 50px; height: 47px; padding-bottom: 0px;"
									id="idx2" onclick="valueIdxsquare()">
									<b><i>x<sup>2</sup></i></b>
								</button>
								<button type="button" class="btn btn-defult"
									style="width: 50px; height: 50px;" id="idroot"
									onclick="valueIdroot()">
									<b>√</b>
								</button>
								<button type="button" class="btn btn-defult"
									style="width: 50px; height: 50px;" id="idmod"
									onclick="valueIdmod()">
									<b>%</b>
								</button>
							</div>

							<br>
							<div class="col-lg-12 col-md-12 col-xs-12 col-sm-12">
								<button type="button" class="btn btn-defult"
									style="width: 50px; height: 50px; margin-left: 14px" id="id7"
									onclick="valueId7()">
									<b>7</b>
								</button>
								<button type="button" class="btn btn-defult"
									style="width: 50px; height: 50px;" id="id8"
									onclick="valueId8()">
									<b>8</b>
								</button>
								<button type="button" class="btn btn-defult"
									style="width: 50px; height: 50px;" id="id9"
									onclick="valueId9()">
									<b>9</b>
								</button>
								<button type="button" class="btn btn-defult"
									style="width: 50px; height: 50px;" id="iddiv"
									onclick="valueIddivision()">
									<b>/</b>
								</button>
							</div>

							<br>
							<div class="col-lg-12 col-md-12 col-xs-12 col-sm-12">
								<button type="button" class="btn btn-defult"
									style="width: 50px; height: 50px; margin-left: 14px" id="id4"
									onclick="valueId4()">
									<b>4</b>
								</button>
								<button type="button" class="btn btn-defult"
									style="width: 50px; height: 50px;" id="id5"
									onclick="valueId5()">
									<b>5</b>
								</button>
								<button type="button" class="btn btn-defult"
									style="width: 50px; height: 50px;" id="id6"
									onclick="valueId6()">
									<b>6</b>
								</button>
								<button type="button" class="btn btn-defult"
									style="width: 50px; height: 50px;" id="idx"
									onclick="valueIdmultiply()">
									<b>x</b>
								</button>
							</div>

							<div class="col-lg-12 col-md-12 col-xs-12 col-sm-12">
								<button type="button" class="btn btn-defult"
									style="width: 50px; height: 50px; margin-left: 14px" id="id1"
									onclick="valueId1()">
									<b>1</b>
								</button>
								<button type="button" class="btn btn-defult"
									style="width: 50px; height: 50px;" id="id2"
									onclick="valueId2()">
									<b>2</b>
								</button>
								<button type="button" class="btn btn-defult"
									style="width: 50px; height: 50px;" id="id3"
									onclick="valueId3()">
									<b>3</b>
								</button>
								<button type="button" class="btn btn-defult"
									style="width: 50px; height: 50px;" id="idminus"
									onclick="valueIdminus()">
									<b>-</b>
								</button>
							</div>
							<br> <br>
							<div class="col-lg-12 col-md-12 col-xs-12 col-sm-12">
								<button type="button" class="btn btn-defult"
									style="width: 50px; height: 50px; margin-left: 14px" id="id0"
									onclick="valueId0()">
									<b>0</b>
								</button>
								<button type="button" class="btn btn-defult"
									style="width: 50px; height: 50px;" id="iddot"
									onclick="valueIddot()">
									<b>.</b>
								</button>
								<button type="button" class="btn btn-defult"
									style="width: 50px; height: 50px;" id="idequal"
									onclick="valueIdequal()">
									<b>=</b>
								</button>
								<button type="button" class="btn btn-defult"
									style="width: 50px; height: 50px;" id="idplus"
									onclick="valueIdplus()">
									<b>+</b>
								</button>
							</div>

						</div>
					</div>
				</div>

			</div>
		</div>
	</div>
	<script src="pages/inner/assets/js/calculater.js"></script>
	<script>
		$(function() {
			Metis.formGeneral();
			Metis.formWysiwyg();
		});
	</script>
	<%-- <script src="/outer/js/gen_validatorv4.js" type="text/javascript"></script> --%>
	<script type="text/javascript" src="/outer/js/gen_validatorv4.js"></script>



	<script type="text/javascript">
		var frmvalidator = new Validator("addCreatedCampaignForm");
		frmvalidator.EnableOnPageErrorDisplay();
		frmvalidator.EnableMsgsTogether();
		/* frmvalidator.addValidation("campaignName", "req",
				"Please Enter Your Name");
		frmvalidator.addValidation("campaignName", "alpha_s",
				"Please Enter alpha");
		frmvalidator.addValidation("campaignName", "maxlen=10",
				"Please Enter maxlen 10");
		frmvalidator.addValidation("campaignName", "minlen=3",
				"Please Enter Minlen 3");
		frmvalidator.addValidation("salutation", "dontselect=-1",
				"Please select Salutation."); */
	</script>


</body>
</html>