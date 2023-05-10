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
							<li><a href="campaignDashboard.action" class="active"><s:text
										name="campaign.dashboard"></s:text></a></li>
							<li class="active"><s:text
									name="campaign.dashboard.addcampaign"></s:text></li>
						</ol>
						<s:form name="addCreatedCampaignForm" action="addCampaignInfo"
							class="form-horizontal" id="block-validate">
							<div class="box dark">
								<header> <a class="icons"
									href="campaignDashboard.action" data-toggle="tooltip"
									data-original-title="Back To Campaign DashBoard"
									style="color: black;"> <i class="fa fa-th-large"></i>
								</a>
								<h5>
									<s:text name="add.create.campaign.create.campaign" />
								</h5>

								<!-- .toolbar  btn-xs close-box -->
								<div class="pull-right">
									<div class="btn-group">
										<a class="btn btn-default btnheight" data-toggle="tooltip"
											data-original-title="Help"><i class="fa fa-question"></i>
											<s:text name="project.form.button.help"></s:text> </a>
										<button type="submit" Class="btn btn-primary btnheight"
											data-toggle="tooltip" data-original-title="save"
											key="project.form.button.save" theme="simple" tabindex="32">
											<i class="fa fa-check"></i>
											<s:text name="project.form.button.save"></s:text>
										</button>

										<a href="newCampaign.action" data-toggle="tooltip"
											data-original-title="Refresh"
											class="btn btn-success btnheight"><i
											class="fa fa-refresh "></i></a> <a
											href="campaignDashboard.action" data-toggle="tooltip"
											data-original-title="Close" class="btn btn-danger btnheight"><i
											class="fa fa-times fontawesomeht"></i></a>
									</div>

								</div>
								</header>



								<div id="div-2" class="body">

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
									 <div class="row" style="margin-left:20px; margin-right:20px; ">
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
															<div id='addCreatedCampaignForm_salutation_errorloc'
																class="error_strings"></div>
															<s:select name="salutation" cssClass="form-control"
																list="salutationList"></s:select>
														</div>
														<div class="col-lg-9 col-md-9 col-sm-9 col-xs-12">
															<div id='addCreatedCampaignForm_campaignName_errorloc'
																class="error_strings"></diV>
															<s:textfield type="text" name="campaignName"
																cssClass="form-control" tabindex="1" />
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
													<div id='addCreatedCampaignForm_expectedCloseDate_errorloc'
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
													<s:select name="campaignType" tabindex="2"
														list="campaignTypeList"
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
													<s:text name="add.create.campaign.campaign.status" />
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:select class="form-control" name="campaignStatus"
														headerKey="-1"
														headerValue="%{getText('add.create.campaign.please.holder.campaign.status')}"
														tabindex="2" list="campaignStatusList"
														cssClass="form-control" />
													<div id='addCreatedCampaignForm_campaignStatus_errorloc'
														class="error_strings"></diV>
												</div>
											</div>
										</div>
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
													&nbsp; (&nbsp;<span class="fa fa-rupee "></span>&nbsp;)
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<div class="input-group">
														<s:textfield type="text" name="budgetCost"
															cssClass="form-control" tabindex="1" />

														<span class="input-group-btn">
															<button class="btn btn-metis-5 btn-line" type="button"
																style="height: 34px"
																onClick="PopupCenter('renderCalculator','RenderCalculator',260,350);">
																<i class="fa fa-calculator"></i>
															</button>
														</span>
													</div>
													<div id='addCreatedCampaignForm_budgetCost_errorloc'
														class="error_strings"></diV>
												</div>
											</div>
										</div>
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="add.create.campaign.actual.cost" />
													&nbsp; (&nbsp;<span class="fa fa-rupee "></span>&nbsp;)
													<div class="star">*</div>
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<div class="input-group">
														<s:textfield type="text" name="actualCost"
															cssClass="form-control" tabindex="1" />

														<span class="input-group-btn">
															<button class="btn btn-metis-5 btn-line" type="button"
																style="height: 34px"
																onClick="PopupCenter('renderCalculator','RenderCalculator',260,350);">
																<i class="fa fa-calculator"></i>
															</button>
														</span>
													</div>
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
													&nbsp; (&nbsp;<span class="fa fa-rupee "></span>&nbsp;)
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<div class="input-group">
														<s:textfield type="text" name="expectedRevenue"
															cssClass="form-control" tabindex="11" />

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
												data-original-title="Back To Campaign DashBoard"
												class="btn btn-default btnheight" ontheme="simple"
												tabindex="30"><i
												class="fa fa-caret-square-o-left fontawesomeht"></i> <s:text
													name="project.form.button.cancel" /> </a> <a
												href="newCampaign.action" data-toggle="tooltip"
												data-original-title="Reset"
												class="btn btn-success btnheight" tabindex="31"><i
												class="fa fa-refresh "></i> <s:text
													name="project.form.button.reset"></s:text></a>
											<button type="submit" Class="btn btn-primary btnheight"
												data-toggle="tooltip" data-original-title="save"
												key="project.form.button.save" theme="simple" tabindex="32">
												<i class="fa fa-check"></i>
												<s:text name="project.form.button.save"></s:text>
											</button>



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