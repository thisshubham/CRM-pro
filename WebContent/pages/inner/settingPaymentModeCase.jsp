<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="/struts-jquery-tags" prefix="sj"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
a {
	color: blue;
}

a:hover {
	color: blue;
}
</style>

</head>
<sj:head />

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
							<li class="active"><s:text
									name="Payment Mode"></s:text></li>
							<li class="active"><s:text
									name="Case Payment"></s:text></li>

						</ol>
						<div class="box ">
							<s:form class="form-horizontal" action="insertPaymentDetails" name="PaymentModeform">
								<header>
								<div class="icons">

									<a style="color: black" href="settingPaymentModeCase"
										data-toggle="tooltip" data-original-title="Back To DashBoard">
										<i class="fa fa-th-large"></i>
									</a>
								</div>
								<h5>
									<s:text name="add.user.setting" />
								</h5>

							<!-- .toolbar -->
							<div class="pull-right">
								<div class="btn-group">
									<a class="btn btn-default btnheight" data-toggle="tooltip"
										data-original-title="Help"><i class="fa fa-question"></i>
										<s:text name="project.form.button.help"></s:text> </a>
									<button type="submit" data-toggle="tooltip"
										data-original-title="Save" class="btn btn-primary btnheight">
										<i class="fa fa-check"></i>
										<s:text name="Save"></s:text>
									</button>
									<a href="settingPaymentModeCase" data-toggle="tooltip"
										data-original-title="Refresh"
										class="btn btn-success btnheight"><i
										class="fa fa-refresh "></i></a> <a href="settingPaymentMode"
										data-toggle="tooltip" data-original-title="Close"
										class="btn btn-danger btnheight"><i
										class="fa fa-times fontawesomeht"></i></a>
								</div>
							</div>

							</header>

								<div class="row">
								<div class="container-fluid">

									<div class="col-lg-12  col-md-12 col-sm-12 col-xs-12"
										style="margin-top: 15px;">
										<a class="quick-icons" href="renderCompanySettings.action"
											data-toggle="tooltip" data-placement="right"
											data-original-title="Company" class="active"> <i
											class="fa fa-files-o fa-2x"></i> <span><s:text
													name="add.user.menus.company"></s:text></span>
										</a> <a class="quick-icons" href="settingsUser.action"
											data-toggle="tooltip" data-placement="right"
											data-original-title="User"> <i
											class="fa fa fa-user fa-2x"></i> <span><s:text
													name="add.user.menus.user"></s:text></span>
										</a> <a class="quick-icons" href="settingFinanceTaxes.action">
											<i class="fa fa-exchange fa-2x"></i><span><s:text
													name="add.user.menus.finance"></s:text></span>
										</a> <a class="quick-icons"
											href="settingMarketingLeadSource.action"> <i
											class="fa fa-clipboard fa-2x"></i><span><s:text
													name="add.user.menus.marketing"></s:text></span>
										</a> <a class="quick-icons" href="settingProductCategory.action">
											<i class="fa fa fa-envelope fa-2x"></i><span> <s:text
													name="add.user.menus.product"></s:text></span>
										</a> <a class="quick-icons"
											href="settingSupportFAQCategory.action"> <i
											class="fa fa fa-comment fa-2x"></i><span><s:text
													name="add.user.menus.support"></s:text></span>
										</a>
										
										 <a class="quick-icons" href="settingPaymentMode">
										<i class="fa fa-credit-card fa-2x"></i><span><s:text
												name="Payment Mode"></s:text></span>
									</a>
									
										<hr
											style="margin-left: 15px; margin-right: 15px; margin-top: -10px;">
									</div>

								</div>

							</div>


									<div class="container-fluid">
									<div class="col-lg-12  col-md-12  col-sm-12 col-xs-12"
										style="margin-top: -10px;">
										<ul class="nav nav-tabs" role="tablist">
											
											
											
											
											
											
											<li role="presentation" class="active"><a
												href="settingPaymentModeCase"
												style="color: Gray; background-color: #F9F9F9;"><s:text
														name="Case" /> </a></li>
											<li role="presentation">
											
											<%-- <a href="settingSupportChannel.action"><s:text
														name="setting.support.menus.channel" /></a></li>
											<li role="presentation">
											
											<a href="settingSupportCaseImpact.action"><s:text
														name="setting.support.menus.case.impact" /></a></li>
											<li role="presentation">
											
											<a href="settingSupportTaskArea.action"><s:text
														name="setting.support.menus.task.area" /></a></li>
 --%>

										</ul>


									<div id="content" style="background-color: #F9F9F9;">
										<!--BEGIN INPUT TEXT FIELDS-->
										<div class="row">
											<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
												<div class="box inverse"
													style="margin-top: -10px; margin-bottom: 0px;">
													<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
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
																		<s:text
																			name="Add New Case Here" />
																	</div>
																</div>
															</s:else>
														</p>
													</div>


													<div class="row">
															<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12"></div>
															<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
																<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
																	<s:text name="Payment:"></s:text>
																	<div class="star">*</div>
																</div>
																<div class="col-lg-9 col-md-9 col-sm-12 col-xs-12">

																	<s:select list="paymentSelectList" name="payment"
														 headerKey="-1" headerValue="Select Payment"
														theme="css_xhtml" cssClass="form-control" tabindex="1" />
														<div id='PaymentModeform_payment_errorloc'class="error_strings"></div>
																</div>
															</div>
		
							
															<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
																<button type="submit" Class="btn btn-primary btnheight"
																	data-toggle="tooltip" data-original-title="save"
																	key="Save" theme="simple">
																	<i class="fa fa-check"></i>
																	<s:text name="Save"></s:text>
																</button>
															</div>
														</div>
														
													<div id="dashboard_search_tools">
				
															<div class="row">
																<div class="col-lg-12  col-md-12  col-sm-12 col-xs-12"
																	style="margin-bottom: 2px;">

																	<div class="row"></div>
																</div>
															</div>
														</div>



														<table id="dataTable"
															class="table table-bordered table-condensed table-hover table-striped">
															<thead>
																<tr id="myrow">
																	<th style="width: 10%;"><s:text
																			name="Action"></s:text></th>
																	<th style="width: 20%;"><s:text
																			name="Payment ID"></s:text></th>
																	<th><s:text name="Paymnet Name"></s:text></th>
																</tr>
															</thead>
															<tbody>
																<s:iterator value="paymentDetailsList">
																	<tr>
																		<td align="center">
																			<div class="btn-group">
																				<a id="view" href="" data-toggle="tooltip"
																					data-original-title="View" data-placement="bottom">
																					<i class="fa fa-eye"></i>
																				</a>
																			</div>
														<div class="btn-group">
															<a id="edit"
																href="editPayment?command=<s:property value='pyamentID' />"
																data-toggle="tooltip" data-original-title="Edit"
																data-placement="bottom"> <i class="fa fa-edit"></i>
															</a>
														</div>
														<div class="btn-group">
															<a id="delete" href="#"
																onclick="confirmDelete('deletePaymentDetail?command='+<s:property value='pyamentID'/>)"
															data-toggle="tooltip" data-original-title="Delete"
																data-placement="bottom"> <i class="fa fa-trash-o"></i>
															</a>
														
																		</td>
																		<td><a style="color: blue" href="">
																		<s:property value='pyamentID' /></a></td>
																		<td><s:property value="payment" /></td>
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
</s:form>
</div>
</div>
</div>
</div>
</div>
</div>




</body>



<%-- 
<script type="text/javascript">
		var frmvalidator = new Validator("PaymentModeform");
		frmvalidator.EnableOnPageErrorDisplay();
		frmvalidator.EnableMsgsTogether();
		frmvalidator.addValidation("payment", "req",
				"Please Enter payment ");
		frmvalidator.addValidation("payment", "maxlen=100",
				"Please Enter maxlen 100");
		frmvalidator.addValidation("payment", "minlen=1",
				"Please Enter Minlen 1");
	</script> --%>



<script>
		$(function() {
			Metis.MetisTable();
			Metis.metisSortable();
		});
	</script>


	<script type="text/javascript">

		function confirmDelete(url) {
			if (confirm("Are you sure you want to delete?")) {
			
				document.location = url;
			}	
}
</script>







</html>