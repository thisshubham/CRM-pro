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





<!-- Script for ajax call for email or mobile no -->
<script type="text/javascript">
	var xmlhttp;
	if (window.XMLHttpRequest) {
		xmlhttp = new XMLHttpRequest();
	} else {
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}

	/* This function will check the existing email id */
	function isEmailIdExist(companyEmailId) {
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				document.getElementById("server1Response").innerHTML = xmlhttp.responseText;
			}
		};
		xmlhttp.open("GET", "isEmailIdExists.action?companyEmailId="
				+ companyEmailId, true);
		xmlhttp.send();

		xmlhttp.open("GET", "isEmailIdExists.action?companyEmailId="
				+ companyEmailId, true);
		xmlhttp.send();

	}

	/* this method is used to calculate Amount for first row */
	function calculateAmount() {

		var amountForA = document.getElementById("totalAmountA").value;
		var amountForB = document.getElementById("totalAmountB").value;

		amountTotal = amountForA + amountForB;
		alert("amount=" + amountTotal);

	}
</script>


<!-- / Script for ajax call for email or mobile no -->


<sj:head />
<body>

	<div id="content">
		<div class="outer">
			<div class="inner bg-light lter">

				<!--BEGIN INPUT TEXT FIELDS-->
				<div class="row">
					<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
						<ol class="breadcrumb" style="margin-top: 10px;">
							<li><a href="#"><s:text name="new.monthly.expenses.home" /></a></li>
							<li><a href="expensesDasbord.action"><s:text
										name="Expenses"></s:text> </a></li>

							<li class="active"><s:text
									name="new.monthly.expenses.monthly.expenses" /></a></li>
						</ol>
						<div class="box dark">
							<header>
							<div class="pull-left">



								<a class="icons" href="expensesDasbord.action"
									data-toggle="tooltip"
									data-original-title="Back To Expenses DashBoard"
									style="color: black;"> <i class="fa fa-th-large"></i>
								</a>
								<h5 class="header_color">
									<s:text name="Monthly Expenses" />
								</h5>
							</div>


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
							</div>
							<div style="padding-left: 15px; padding-right: 15px;">
							<s:form class="form-horizontal">
							<s:iterator value="monthlyOtherListGrid" var="testObj">
							<div class="row">
										<div
											class="col-lg-12 col-md-12 col-sm-12 col-xs-12 viewinnertitle">
											<h5>
												<s:text name="Other Travel Expenses" />
											</h5>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12 col-sm-12 col-xs-12"
											id="view_lable_value">
											<div class="col-md-2 col-sm-12 col-xs-12">
												<label for="text1" class="control-label" id="viewlable">
													<s:text name="Date and Time" />
												</label>
											</div>
											<div class="col-md-10 col-sm-12 col-xs-12 control-label">
												<s:property value="dateAndTime" />
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12 col-sm-12 col-xs-12"
											id="view_lable_value2">
											<div class="col-md-2 col-sm-12 col-xs-12">
												<label for="text1" class="control-label" id="viewlable">
													<s:text name="Place:" />
												</label>
											</div>
											<div class="col-md-10 col-sm-12 col-xs-12 control-label">
												<s:property value="place" />
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12 col-sm-12 col-xs-12"
											id="view_lable_value">
											<div class="col-md-2 col-sm-12 col-xs-12">
												<label for="text1" class="control-label" id="viewlable">
													<s:text name="Item" />
												</label>
											</div>
											<div class="col-md-10 col-sm-12 col-xs-12 control-label">
												<s:property value="items" />
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12 col-sm-12 col-xs-12"
											id="view_lable_value2">
											<div class="col-md-2 col-sm-12 col-xs-12">
												<label for="text1" class="control-label" id="viewlable">
													<s:text name="Amount" />
												</label>
											</div>
											<div class="col-md-10 col-sm-12 col-xs-12 control-label">
												<s:property value="amount" />
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
</body>
</html>
