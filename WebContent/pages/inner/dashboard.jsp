<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>

<style type="text/css">
.sup {
	vertical-align:;
	font-size: medium;
}

.supscriptCampaign {
	position: absolute;
	top: -7px;
	right: -6px;
	padding: 3px 3px 2px 3px;
	background-color:#aaaaaa; 
	
	color: white;
	font-family: arial;
	font-weight: bold;
	font-size: 10px;
	border-radius: 4px;
	box-shadow: 1px 1px 1px silver;
}

.supscriptLead {
	position: absolute;
	top: -7px;
	right: -6px;
	padding: 3px 3px 2px 3px;
	background-color:#cc0000;
	color: white;
	font-family: arial;
	font-weight: bold;
	font-size: 10px;
	border-radius: 4px;
	box-shadow: 1px 1px 1px silver;
}
.supscriptassignment {
	position: absolute;
	top: -7px;
	right: -6px;
	padding: 3px 3px 2px 3px;
	background-color:#33BB44;
	color: white;
	font-family: arial;
	font-weight: bold;
	font-size: 10px;
	border-radius: 4px;
	box-shadow: 1px 1px 1px silver;
}
.supscriptCases {
	position: absolute;
	top: -7px;
	right: -6px;
	padding: 3px 3px 2px 3px;
	background-color:#ff9955;
	color: white;
	font-family: arial;
	font-weight: bold;
	font-size: 10px;
	border-radius: 4px;
	box-shadow: 1px 1px 1px silver;
}
.supscriptTickets {
	position: absolute;
	top: -7px;
	right: -6px;
	padding: 3px 3px 2px 3px;
	background-color:#aaaaaa;
	color: white;
	font-family: arial;
	font-weight: bold;
	font-size: 10px;
	border-radius: 4px;
	box-shadow: 1px 1px 1px silver;
}
.supscriptproduct {
	position: absolute;
	top: -7px;
	right: -6px;
	padding: 3px 3px 2px 3px;
	background-color:#cc0000;
	color: white;
	font-family: arial;
	font-weight: bold;
	font-size: 10px;
	border-radius: 4px;
	box-shadow: 1px 1px 1px silver;
}
.supscriptaccount {
	position: absolute;
	top: -7px;
	right: -6px;
	padding: 3px 3px 2px 3px;
	background-color:#33BB44;
	color: white;
	font-family: arial;
	font-weight: bold;
	font-size: 10px;
	border-radius: 4px;
	box-shadow: 1px 1px 1px silver;
}
.supscriptContacts {
	position: absolute;
	top: -7px;
	right: -6px;
	padding: 3px 3px 2px 3px;
	background-color:#aaaaaa;
	color: white;
	font-family: arial;
	font-weight: bold;
	font-size: 10px;
	border-radius: 4px;
	box-shadow: 1px 1px 1px silver;
}
.supscriptMonthly {
	position: absolute;
	top: -7px;
	right: -6px;
	padding: 3px 3px 2px 3px;
	background-color:#cc0000;
	color: white;
	font-family: arial;
	font-weight: bold;
	font-size: 10px;
	border-radius: 4px;
	box-shadow: 1px 1px 1px silver;
}
.supscripttour {
	position: absolute;
	top: -7px;
	right: -6px;
	padding: 3px 3px 2px 3px;
	background-color:#33BB44;
	color: white;
	font-family: arial;
	font-weight: bold;
	font-size: 10px;
	border-radius: 4px;
	box-shadow: 1px 1px 1px silver;
}
</style>
<body>


	<div id="content">
		<div class="outer">
			<div class="inner bg-light lter">


				<div class="container-fluid"
					style="padding-left: 0px; padding-right: 0px">



					<div class="row">
						<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">

							<ol class="breadcrumb" style="margin-top: 10px;">
								<li><a href="omiInnerDashboard.action"><i
										class="fa fa-home"></i></a></li>
								<li class="active">Dashboard</li>

							</ol>

							<div class="bs-example">
								<ul class="nav nav-tabs" id="myTab">
									<li class="active"><a href="omiInnerDashboard.action"><s:text
												name="dashboard.graphical.view.tab.pannel.dashboard" /></a></li>
									<li><a href="dashboardUsers"><s:text
												name="dashboard.graphical.view.tab.pannel.users" /></a></li>
									<li><a href="dashboardGraphReports"><s:text
												name="dashboard.graphical.view.tab.pannel.quickreports" /></a></li>
									<li><a href="leadStatusModule"><s:text
												name="dashboard.graphical.view.tab.pannel.analytics" /></a></li>
								</ul>

								<div class="tab-content" id="myTabContent"
									style="white-space: normal;"></div>

							</div>
							<div class="row">
								<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
									<div class=row>

										<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12  "
											style="margin-top: 5px; margin-bottom:5px;" >
											<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 hidden-xs hidden-sm"></div>
											<ul>
												<%-- <li>
													<div class="sparkline line_day"></div>
													<div class="stat_text">
														<strong>165</strong> Daily Visit <span class="percent up">
															<i class="fa fa-caret-up"></i> +23%
														</span>
													</div>
												</li>
												<li>
													<div class="sparkline pie_week"></div>
													<div class="stat_text">
														<strong>$2 345.00</strong> Weekly Sale <span
															class="percent"> 0%</span>
													</div>
												</li> 
												<li><a class="" href="#" > <i
														class=""></i> <span><s:text
																name="" /></span>
														<span class="label label-default">2</span>
												</a></li>
												<li><a class="quick-btn" href="#"> <i
														class="fa fa-lightbulb-o  fa-2x"></i> <span><s:text
																name="dashboard.graphical.view.notification.lead" /></span> <span
														class="label label-danger">2</span>
												</a></li>
												<li><a class="quick-btn" href="#"> <i
														class="fa fa-tasks fa-2x"></i> <span><s:text
																name="dashboard.graphical.view.notification.assignments" /></span>
														<span class="label label-success">6</span>
												</a></li>
												<li><a class="quick-btn" href="#"> <i
														class="fa fa-tags fa-2x"></i> <span><s:text
																name="dashboard.graphical.view.notification.cases" /></span> <span
														class="label label-default">2</span>
												</a></li>
												<li><a class="quick-btn" href="#"> <i
														class="fa fa-ticket fa-2x"></i> <span><s:text
																name="dashboard.graphical.view.notification.tickets" /></span>
														<span class="label label-danger">2</span>
												</a></li>
												<li><a class="quick-btn" href="#"> <i
														class="fa fa-cube fa-2x"></i> <span><s:text
																name="dashboard.graphical.view.notification.products" /></span>
														<span class="label label-success">6</span>
												</a></li>
												<li><a class="quick-btn" href="#"> <i
														class="fa fa-building fa-2x"></i> <span><s:text
																name="dashboard.graphical.view.notification.account" /></span>
														<span class="label label-success">6</span>
												</a></li>
												<li><a class="quick-btn" href="#"> <i
														class="fa fa-lightbulb-o  fa-2x"></i> <span><s:text
																name="dashboard.graphical.view.notification.contact" /></span>
														<span class="label label-success">6</span>
												</a></li>--%>

											</ul>
											<a class="quick-icons" href="" data-toggle="tooltip"
												data-placement="top" data-original-title="Campaign" style="margin-left: 30px;"><i
												class="fa fa-bullhorn fa-4x"></i><span
														class="label label-danger"><span class="supscriptCampaign">12</span></span>

											</a><span style=""></span> <a class="quick-icons" href=""
												data-toggle="tooltip" data-placement="top"
												data-original-title="Lead" style="margin-left: 30px;"><i
												class="fa fa-lightbulb-o  fa-4x"></i><span class="supscriptLead">12</span>

											</a> <a class="quick-icons" href="" data-toggle="tooltip"
												data-placement="top" data-original-title="Assignment"
												style="margin-left: 30px;"><i class="fa fa-tasks fa-4x"></i><span
												class="supscriptassignment">12</span> </a> <a class="quick-icons" href=""
												data-toggle="tooltip" data-placement="top"
												data-original-title="Cases" style="margin-left: 30px;"><i
												class="fa fa-tags fa-4x"></i><span class="supscriptCases">12</span>

											</a> <a class="quick-icons" href="" data-toggle="tooltip"
												data-placement="top" data-original-title="Tickets"
												style="margin-left: 15px;"><i class="fa fa-ticket fa-4x"></i><span
												class="supscriptTickets">12</span> </a> <a class="quick-icons" href=""
												data-toggle="tooltip" data-placement="top"
												data-original-title="Product" style="margin-left: 30px;"><i
												class="fa fa-cube fa-4x"></i><span class="supscriptproduct">12</span>

											</a> <a class="quick-icons" href="" data-toggle="tooltip"
												data-placement="top" data-original-title="Account"
												style="margin-left: 30px;"><i
												class="fa fa-building fa-4x"></i><span class="supscriptaccount">12</span>

											</a> <a class="quick-icons" href="" data-toggle="tooltip"
												data-placement="top" data-original-title="Contacts"
												style="margin-left: 30px;"><i
												class="fa fa-lightbulb-o fa-4x"></i><span class="supscriptContacts">12</span>

											</a> <a class="quick-icons" href="" data-toggle="tooltip"
												data-placement="top" data-original-title="Monthly Expenses"
												style="margin-left: 30px;"><i
												class="fa fa-credit-card fa-4x"></i><span class="supscriptMonthly">12</span>

											</a> <a class="quick-icons" href="" data-toggle="tooltip"
												data-placement="top" data-original-title="Tour Expenses"
												style="margin-left: 30px;"><i class="fa fa-taxi fa-4x"></i><span
												class="supscripttour">12</span> </a>
												
												
										</div>
									</div>
									<div class="row">
										<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">

											<div class="box">
												<div class="panel panel-default">
													<div class="pull-right">


														<div class="btn-group" style="margin-top: 3px;">
															<a href="dashboardGridPage.action" data-toggle="tooltip"
																data-placement=bottom title="Grid Preview"
																class="btn btn-success "> <span
																class="glyphicon glyphicon-th"></span>&nbsp;<s:text
																	name="dashboard.graphical.view.pannel.button"></s:text>

															</a> <a href="#borderedTable" data-toggle="collapse"
																data-placement=bottom title="close"
																class="btn btn-info "> <span class="fa fa-angle-up"></span>&nbsp;
															</a>
														</div>


													</div>

													<div class="panel-heading">
														<h3 class="panel-title">
															<s:text name="dashboard.graphical.view.pannel.heading" />
														</h3>
													</div>

													<!-- Table -->

													<div id="borderedTable" class="body collapse in  ">
														<div class="panel-body">
															<div class="row"">
																<div class="col-md-6" style="margin-top: 20px;">
																	<img alt="pi" src="img/leadstatuspie_Chart.jpeg"
																		class="img-thumbnail" />
																</div>
																<div class="col-md-6" style="margin-top: 20px;">
																	<img alt="pi" src="img/accountpie_Chart.jpeg"
																		class="img-thumbnail" />
																</div>
															</div>

															<div class="row">
																<div class="col-md-6" style="margin-top: 20px;">
																	<img alt="pi" src="img/ticketpie_Chart.jpeg"
																		class="img-thumbnail" />
																</div>
																<div class="col-md-6" style="margin-top: 20px;">
																	<img alt="pi" src="img/casespie_Chart.jpeg"
																		class="img-thumbnail" />
																</div>
															</div>

															<div class="row">
																<div class="col-md-6" style="margin-top: 20px;">
																	<img alt="pi" src="img/assignmentpie_Chart.jpeg"
																		class="img-thumbnail" />
																</div>
																<br>
																<div class="col-md-6" style="margin-top: 20px;">
																	<img alt="pi" src="" />
																</div>
															</div>

														</div>
													</div>
												</div>
											</div>

										</div>
									</div>
									<%-- 									<div class="row">
										<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
											<div class="box">
												<header>
													<h5>Lead</h5>
													<div class="toolbar">
														<div class="btn-group">
															<a href="#borderedTable" data-toggle="collapse"
																class="btn btn-default btn-sm minimize-box"> <i
																class="fa fa-angle-up"></i>
															</a> <a class="btn btn-danger btn-sm close-box"> <i
																class="fa fa-times"></i>
															</a>
														</div>
													</div>
												</header>
												<div id="borderedTable" class="body collapse in  ">
													<div class="list-group">

														<a href="" class="list-group-item list-group-item-default"
															id="alignleft"><span
															class="new">New</span>

														</a> <a href=""
															class="list-group-item list-group-item-default"
															id="alignleft" > <span class="badge"></span><span
															class="assigned"> Assigned</span>

														</a> <a href="#"
															class="list-group-item list-group-item-default"
															id="alignleft"> <span class="badge">10</span><span
															class="inprogress">In-Progress</span>
														</a> <a href=""
															class="list-group-item list-group-item-default"
															id="alignleft"> <span class="badge">14</span> <span
															class="notverified">Not Verified</span>

														</a> <a href=""
															class="list-group-item list-group-item-default"
															id="alignleft"> <span class="badge">14</span><span
															class="junklead"> Junk Lead</span>

														</a> <a href="#"
															class="list-group-item list-group-item-default"
															id="alignleft"> <span class="badge">10</span><span
															class="futurelead"> Future Lead</span>

														</a> <a href=""
															class="list-group-item list-group-item-default"
															id="alignleft"> <span class="badge">14</span> <spa
																class="duplicate"> Duplicate</span></a> <a href=""
															class="list-group-item list-group-item-default"
															id="alignleft"> <span class="badge">14</span><span
															class="preverified"> Pre Verified</span>
														</a> <a href="#"
															class="list-group-item list-group-item-default"
															id="alignleft"> <span class="badge">10</span><span
															class="verified"> Verified</span>
														</a> <a href="#"
															class="list-group-item list-group-item-default"
															id="alignleft"> <span class="badge">10</span><span
															class="expired"> Expired</span>
														</a> <a href="#"
															class="list-group-item list-group-item-default"
															id="alignleft"> <span class="badge">10</span><span
															class="closed"> Closed</span>
														</a> <a href="#"
															class="list-group-item list-group-item-default"
															id="alignleft"> <span class="badge">10</span><span
															class="deleted"> Deleted</span>
														</a>

													</div>
												</div>
											</div>
										</div>
										<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
											<div class="box">
												<header>
													<h5>Cases History</h5>
													<div class="toolbar">
														<div class="btn-group">
															<a href="#borderedTable2" data-toggle="collapse"
																class="btn btn-default btn-sm minimize-box"> <i
																class="fa fa-angle-up"></i>
															</a> <a class="btn btn-danger btn-sm close-box"> <i
																class="fa fa-times"></i>
															</a>
														</div>
													</div>
												</header>
												<div id="borderedTable2" class="body collapse in ">
													<div class="list-group">
														<a href="" class="list-group-item list-group-item-default"
															id="alignleft"> <span class="badge">14</span><span
															class="new"> Analyst</span>
														</a> <a href=""
															class="list-group-item list-group-item-default"
															id="alignleft"> <span class="badge">14</span> <span
															class="assigned">Competitor</span>
														</a> <a href=""
															class="list-group-item list-group-item-default"
															id="alignleft"> <span class="badge">14</span> <span
															class="notverified">Distributor</span>
														</a> <a href=""
															class="list-group-item list-group-item-default"
															id="alignleft"> <span class="badge">14</span> <span
															class="junklead">Integrator</span>
														</a> <a href="#"
															class="list-group-item list-group-item-default"
															id="alignleft"><span class="badge">10</span><span
															class="futurelead"> Investor</span> </a> <a href=""
															class="list-group-item list-group-item-default"
															id="alignleft"> <span class="badge">14</span> <span
															class="duplicate"> Partner</span>
														</a> <a href=""
															class="list-group-item list-group-item-default"
															id="alignleft"> <span class="badge">14</span> <span
															class="preverified"> Press</span>
														</a> <a href="#"
															class="list-group-item list-group-item-default"
															id="alignleft"><span class="badge">10</span><span
															class="verified"> Customer</span> </a> <a href=""
															class="list-group-item list-group-item-default"
															id="alignleft"> <span class="badge">14</span><span
															class="expired"> Prospect</span>
														</a> <a href=""
															class="list-group-item list-group-item-default"
															id="alignleft"> <span class="badge">14</span><span
															class="closed"> Reseller</span>
														</a> <a href="#"
															class="list-group-item list-group-item-default"
															id="alignleft"><span class="badge">10</span><span
															class="deleted">Supplier</span> </a> <a href=""
															class="list-group-item list-group-item-default"
															id="alignleft"> <span class="badge">14</span><span
															class="new"> Vendor</span>
														</a> <a href=""
															class="list-group-item list-group-item-default"
															id="alignleft"> <span class="badge">14</span><span
															class="assigned"> Friend</span>
														</a> <a href="#"
															class="list-group-item list-group-item-default"
															id="alignleft"><span class="badge">10</span><span
															class="inprogress"> Family</span> </a> <a href=""
															class="list-group-item list-group-item-default"
															id="alignleft"> <span class="badge">14</span><span
															class="notverified"> Other</span>
														</a>
													</div>
												</div>
											</div>
										</div>
										<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
											<div class="box">
												<header>
													<h5>Ticket History</h5>
													<div class="toolbar">
														<div class="btn-group">
															<a href="#borderedTable3" data-toggle="collapse"
																class="btn btn-default btn-sm minimize-box"> <i
																class="fa fa-angle-up"></i>
															</a> <a class="btn btn-danger btn-sm close-box"> <i
																class="fa fa-times"></i>
															</a>
														</div>
													</div>
												</header>
												<div id="borderedTable3" class="body collapse in ">
													<div class="list-group">
														<a href="" class="list-group-item list-group-item-default"
															id="alignleft"> <span class="badge">14</span><span
															class="new"> Customer Manager</span>
														</a> <a href=""
															class="list-group-item list-group-item-default"
															id="alignleft"> <span class="badge">14</span><span
															class="assigned"> Customer Supervisor</span>

														</a> <a href="#"
															class="list-group-item list-group-item-default"
															id="alignleft"><span class="badge">10</span><span
															class="inprogress">Accountant</span> </a> <a href=""
															class="list-group-item list-group-item-default"
															id="alignleft"> <span class="badge">14</span><span
															class="notverified"> Auditor User</span>
														</a> <a href="#"
															class="list-group-item list-group-item-default"
															id="alignleft"><span class="badge">10</span><span
															class="junklead"> Sales User</span> </a> <a href=""
															class="list-group-item list-group-item-default"
															id="alignleft"> <span class="badge">14</span><span
															class="futurelead"> Marketing User</span>

														</a> <a href="#"
															class="list-group-item list-group-item-default"
															id="alignleft"><span class="badge">10</span><span
															class="duplicate"> End User</span> </a> <a href=""
															class="list-group-item list-group-item-default"
															id="alignleft"> <span class="badge">14</span><span
															class="preverified	"> Research User</span>
														</a>
													</div>
												</div>
											</div>
										</div>
									</div> --%>

								</div>
							</div>
						</div>

					</div>

				</div>

			</div>
		</div>
	</div>



	<script>
		$(function() {
			Metis.formGeneral();
		});
	</script>
	<script>
		$(function() {
			Metis.dashboard();
		});
	</script>


	<!--***popup window***-->
	<script type="text/javascript">
		//Popup window code for Edit
		function PopUpOne(url) {
			popupWindow = window
					.open(
							url,
							'popUpWindow',
							'height=600,width=800,left=10,top=10,resizable=no,scrollbars=yes,addressbar=no,toolbar=no,menubar=no,location=0,directories=no,status=yes');

		}
	</script>
</body>