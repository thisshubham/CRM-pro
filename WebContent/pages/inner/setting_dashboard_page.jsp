<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="/struts-jquery-tags" prefix="sj"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

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
							<li class="active"><s:text name="add.user.menus.company"></s:text></li>
							

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

									<!-- <form class="navbar-form navbar-left" role="search">
										<div class="form-group">
											<input type="text" class="form-control" placeholder="Search">
										</div>
										<button type="submit" class="btn btn-default">
											<i class="glyphicon glyphicon-search"></i>
										</button>
									</form> -->
									<a href="renderCompanySettings.action" data-toggle="tooltip"
										data-original-title="Refresh"
										class="btn btn-success btnheight"><i
										class="fa fa-refresh "></i></a> <a href="omiInnerDashboard.action"
										data-toggle="tooltip" data-original-title="Close"
										class="btn btn-danger btnheight"><i
										class="fa fa-times fontawesomeht"></i></a>
								</div>
							</div>
						</div>
						</header>
						<div class="row">
							<div class="container-fluid">

								<div class="col-lg-12  col-md-12 col-sm-12 col-xs-12"
									style="margin-top: -5px; margin-bottom: -15px;">
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
									</a> <a class="quick-icons" href="settingSupportFAQCategory.action">
										<i class="fa fa fa-comment fa-2x"></i><span><s:text
												name="add.user.menus.support"></s:text></span>
									</a><a class="quick-icons" href="settingPaymentMode">
										<i class="fa fa-credit-card fa-2x"></i><span><s:text
												name="Payment Mode"></s:text></span>
									</a>
								</div>
							</div>
						</div>
						<hr>
						<div id="content" style="background-color: #F9F9F9;">
							<div class="row">

								<div class="box inverse"
									style="margin-top: 10px; margin-bottom: 100px;">
									<div class="col-lg-12  col-md-12 col-sm-12 col-xs-12">
										<a href="renderCompanySettings.action"
											style="margin-left: 30px;"><s:text
												name="add.user.menus.company"></s:text></a>
									</div>
								</div>
								<div class="col-lg-12  col-md-12 col-sm-12 col-xs-12"></div>
							</div>
						</div>
					</div>
				</div>
			</div>

		</div>
	</div>
	</div>



	<!-- Modal1 -->


	<script>
		$(function() {
			Metis.formGeneral();
			Metis.formWysiwyg();
		});
	</script>
</body>
</html>