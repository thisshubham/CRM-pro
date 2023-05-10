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
									name="Payment"></s:text></li>

						</ol>
						<div class="box ">
							<header>
							<div class="icons">

								<a style="color: black" href="dashboard.action"
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
											<s:text name="project.form.button.save"></s:text>
										</button>
										<a href="settingPaymentMode"
											data-toggle="tooltip" data-original-title="Refresh"
											class="btn btn-success btnheight"><i
											class="fa fa-refresh "></i></a> <a
											href="settingPaymentMode" data-toggle="tooltip"
											data-original-title="Close" class="btn btn-danger btnheight"><i
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

						
</div>
</div>
						
						
						
						
						
						

</div>
</div>
</div>
</div>
</div>
</div>









</body>
</html>