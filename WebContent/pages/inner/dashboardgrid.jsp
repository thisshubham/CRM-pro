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

										<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"
											style="margin-top: 5px; margin-bottom: 15px;">
											<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"></div>
											<ul>
												<%--  <li>
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
												</li>    --%>
												<%-- <li><a class="quick-btn" href="#"> <i
														class="fa fa-bullhorn fa-2x"></i> <span><s:text
																name="dashboard.graphical.view.notification.campaign" /></span>
														<span class="label label-default">2</span>
												</a></li>
												<li><a class="quick-btn" href="#"> <i
														class="fa fa-lightbulb-o  fa-2x"></i> <span><s:text
																name="dashboard.graphical.view.notification.lead" /></span> <span
														class="label label-danger">2</span>
												</a></li>
												<li><a class="quick-btn" href="#"> <i
														class="fa fa-tasks  fa-2x"></i> <span><s:text
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
														class="fa fa-lightbulb-o fa-2x"></i> <span><s:text
																name="dashboard.graphical.view.notification.contact" /></span>
														<span class="label label-success">6</span>
												</a></li>
												<li><a class="quick-btn" href="#"> <i
														class="fa fa-taxi fa-2x"></i> <span><s:text
																name="dashboard.graphical.view.notification.expenses" /></span>
														<span class="label label-success">6</span>
												</a></li> --%>

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

									<div class="panel panel-default">
										<div class="pull-right">


											<div class="btn-group" style="margin-top: 3px;">
												<a href="omiInnerDashboard.action" data-toggle="tooltip"
													data-placement=bottom title="Graphical Preview"
													class="btn btn-success "> <span
													class="glyphicon glyphicon-th"></span>&nbsp;<s:text
														name="dashboard.grid.pannel.button"></s:text>

												</a> <a href="#borderedTable" data-toggle="collapse"
													data-placement=bottom title="close" class="btn btn-info ">
													<span class="fa fa-angle-up"></span>&nbsp;
												</a>
											</div>


										</div>


										<div class="panel-heading">
											<h3 class="panel-title">
												<s:text name="dashboard.grid.view.pannel.heading"></s:text>
											</h3>
										</div>
										<div class="panel-body">

											<div id="borderedTable" class="body collapse in  ">
												<div class="row">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
														<div class="box">
															<header>
																<h5>
																	<s:text
																		name="dashboard.grid.view.ticket.pannel.heading" />
																</h5>

															</header>
															<div id="borderedTable" class="body collapse in  ">
																<s:iterator value="countStatusTicketDetails">

																	<div class="list-group">
																		<a href=""
																			class="list-group-item list-group-item-default"
																			id="alignleft"> <span class="badge"><s:property
																					value="assigned"></s:property></span><span class="new"><s:text
																					name="dashboard.grid.view.ticket.label.assigned"></s:text></span>
																		</a> <a href=""
																			class="list-group-item list-group-item-default"
																			id="alignleft"> <span class="badge"><s:property
																					value="open" /></span><span class="assigned"> <s:text
																					name="dashboard.grid.view.ticket.label.open"></s:text></span>

																		</a> <a href="#"
																			class="list-group-item list-group-item-default"
																			id="alignleft"><span class="badge"><s:property
																					value="onhold" /></span><span class="inprogress"><s:text
																					name="dashboard.grid.view.ticket.label.onhold" /></span>
																		</a> <a href=""
																			class="list-group-item list-group-item-default"
																			id="alignleft"> <span class="badge"><s:property
																					value="resolved" /></span><span class="notverified">
																				<s:text
																					name="dashboard.grid.view.ticket.label.resolved" />
																		</span>
																		</a> <a href="#"
																			class="list-group-item list-group-item-default"
																			id="alignleft"><span class="badge"><s:property
																					value="closed" /></span><span class="junklead"> <s:text
																					name="dashboard.grid.view.ticket.label.closed" /></span>
																		</a>

																	</div>
																</s:iterator>
															</div>
														</div>
													</div>
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
														<div class="box">
															<header>
																<h5>
																	<s:text name="dashboard.grid.view.cases.pannel.heading" />
																</h5>

															</header>
															<div id="borderedTable3" class="body collapse in ">
																<s:iterator value="countStatusCasesDetails">

																	<div class="list-group">
																		<a href=""
																			class="list-group-item list-group-item-default"
																			id="alignleft"> <span class="badge"><s:property
																					value="casesassigned"></s:property></span><span
																			class="new"><s:text
																					name="dashboard.grid.view.cases.label.assigned"></s:text></span>
																		</a> <a href=""
																			class="list-group-item list-group-item-default"
																			id="alignleft"> <span class="badge"><s:property
																					value="casesopen" /></span><span class="assigned">
																				<s:text name="dashboard.grid.view.cases.label.open"></s:text>
																		</span>

																		</a> <a href="#"
																			class="list-group-item list-group-item-default"
																			id="alignleft"><span class="badge"><s:property
																					value="waitforcustomer" /></span><span class="inprogress"><s:text
																					name="dashboard.grid.view.cases.label.waitforcustomer" /></span>
																		</a> <a href=""
																			class="list-group-item list-group-item-default"
																			id="alignleft"> <span class="badge"><s:property
																					value="waitfor3rdparty" /></span><span
																			class="notverified"> <s:text
																					name="dashboard.grid.view.cases.label.waitfor3rdparty" />
																		</span>
																		</a> <a href="#"
																			class="list-group-item list-group-item-default"
																			id="alignleft"><span class="badge"><s:property
																					value="casesresolved" /></span><span class="junklead">
																				<s:text
																					name="dashboard.grid.view.cases.label.resolved" />
																		</span> </a> <a href="#"
																			class="list-group-item list-group-item-default"
																			id="alignleft"><span class="badge"><s:property
																					value="casesclosed" /></span><span class="closed">
																				<s:text
																					name="dashboard.grid.view.cases.label.closed" />
																		</span> </a>

																	</div>
																</s:iterator>
															</div>
														</div>
													</div>
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
														<div class="box">
															<header>
																<h5>
																	<s:text
																		name="dashborad.grid.view.account.pannel.heading"></s:text>
																</h5>

															</header>


															<div id="borderedTable3" class="body collapse in ">

																<s:iterator value="countStatusAccountdetails">
																	<div class="list-group">
																		<a href=""
																			class="list-group-item list-group-item-default"
																			id="alignleft"> <span class="badge"><s:property
																					value="accountacquired" /></span><span class="new">
																				<s:text
																					name="dashborad.grid.view.account.label.acquired" />
																		</span>
																		</a> <a href=""
																			class="list-group-item list-group-item-default"
																			id="alignleft"> <span class="badge"><s:property
																					value="accountactive"></s:property></span> <span
																			class="assigned"><s:text
																					name="dashborad.grid.view.account.label.active" /></span>
																		</a> <a href=""
																			class="list-group-item list-group-item-default"
																			id="alignleft"> <span class="badge"><s:property
																					value="accountmarketfailed" /></span> <span
																			class="notverified"><s:text
																					name="dashborad.grid.view.account.label.marketfailed" /></span>
																		</a> <a href=""
																			class="list-group-item list-group-item-default"
																			id="alignleft"> <span class="badge"><s:property
																					value="accountprojectcancelled" /></span> <span
																			class="junklead"><s:text
																					name="dashborad.grid.view.account.label.projectcancancelled"></s:text></span>
																		</a> <a href="#"
																			class="list-group-item list-group-item-default"
																			id="alignleft"><span class="badge"><s:property
																					value="accountshoutdown" /></span><span class="closed">
																				<s:text
																					name="dashborad.grid.view.account.label.shoutdown" />
																		</span> </a>
																	</div>
																</s:iterator>

															</div>
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
														<div class="box">
															<header>
																<h5>
																	<s:text name="dashboard.gird.view.lead.pannel.heading"></s:text>
																</h5>

															</header>
															<div id="borderedTable3" class="body collapse in ">
																<s:iterator value="countStatusListdetails">

																	<div class="list-group">

																		<a href=""
																			class="list-group-item list-group-item-default"
																			id="alignleft"> <span class="badge"><s:property
																					value='leadattemptocantact' /></span><span
																			class="assigned"> <s:text
																					name="dashboard.grid.view.lead.label.attempttocontact"></s:text>
																		</span>

																		</a> <a href=""
																			class="list-group-item list-group-item-default"
																			id="alignleft"> <span class="badge"><s:property
																					value="leadcontacted" /> </span><span class="inprogress"><s:text
																					name="dashboard.grid.view.lead.label.contacted"></s:text></span>
																		</a> <a href=""
																			class="list-group-item list-group-item-default"
																			id="alignleft"> <span class="badge"><s:property
																					value="leadcontactedinfuture" /></span> <span
																			class="notverified"><s:text
																					name="dashboard.grid.view.lead.label.contactinfuture"></s:text></span>

																		</a> <a href=""
																			class="list-group-item list-group-item-default"
																			id="alignleft"> <span class="badge"><s:property
																					value="leadnotconnceted" /></span><span class="junklead">
																				<s:text
																					name="dashboard.grid.view.lead.label.notcontacted"></s:text>
																		</span>

																		</a> <a href="#"
																			class="list-group-item list-group-item-default"
																			id="alignleft"> <span class="badge"><s:property
																					value="leadqualified" /></span><span class="verified">
																				<s:text
																					name="dashboard.grid.view.lead.label.qualified"></s:text>
																		</span>

																		</a> <a href=""
																			class="list-group-item list-group-item-default"
																			id="alignleft"> <span class="badge"><s:property
																					value="leadprequalified" /></span> <span
																			class="preverified"> <s:text
																					name="dashboard.grid.view.lead.label.prequalified"></s:text></span></a>
																		<a href=""
																			class="list-group-item list-group-item-default"
																			id="alignleft"> <span class="badge"><s:property
																					value="leadhotlead" /></span><span class="closed">
																				<s:text
																					name="dashboard.grid.view.lead.label.hotlead"></s:text>
																		</span>
																		</a> <a href="#"
																			class="list-group-item list-group-item-default"
																			id="alignleft"> <span class="badge"><s:property
																					value="leadcoldlead" /></span><span class="new"> <s:text
																					name="dashboard.grid.view.lead.label.coldlead"></s:text>
																		</span>
																		</a> <a href="#"
																			class="list-group-item list-group-item-default"
																			id="alignleft"> <span class="badge"><s:property
																					value="leadwarmlead" /></span><span class="inprogress">
																				<s:text
																					name="dashboard.grid.view.lead.label.wormlead"></s:text>
																		</span>
																		</a> <a href="#"
																			class="list-group-item list-group-item-default"
																			id="alignleft"> <span class="badge"><s:property
																					value="leadjunklead" /></span><span class="junklead">
																				<s:text
																					name="dashborad.grid.view.lead.label.junklead"></s:text>
																		</span>
																		</a> <a href="#"
																			class="list-group-item list-group-item-default"
																			id="alignleft"> <span class="badge"><s:property
																					value="leadlost" /></span><span class="deleted"> <s:text
																					name="dashboard.grid.view.lead.lebel.lostlead"></s:text>
																		</span>
																		</a>

																	</div>
																</s:iterator>
															</div>
														</div>
													</div>
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
														<div class="box">
															<header>
																<h5>
																	<s:text name="dashboard.grid.view.assignment.pannel" />
																</h5>

															</header>
															<div id="borderedTable3" class="body collapse in ">
																<s:iterator value="countStatusAssignment">

																	<div class="list-group">
																		<a href=""
																			class="list-group-item list-group-item-default"
																			id="alignleft"> <span class="badge"><s:property
																					value="Qualification"></s:property></span><span
																			class="new"><s:text
																					name="dashboard.grid.view.assignment.label.qualification"></s:text></span>
																		</a> <a href=""
																			class="list-group-item list-group-item-default"
																			id="alignleft"> <span class="badge"><s:property
																					value="needananalysis" /></span><span class="assigned">
																				<s:text
																					name="dashboard.grid.view.assignment.label.needanalysis"></s:text>
																		</span>

																		</a> <a href="#"
																			class="list-group-item list-group-item-default"
																			id="alignleft"><span class="badge"><s:property
																					value="valueproposition" /></span><span
																			class="inprogress"><s:text
																					name="dashboard.grid.view.assignment.label.valueproposition" /></span>
																		</a> <a href=""
																			class="list-group-item list-group-item-default"
																			id="alignleft"> <span class="badge"><s:property
																					value="iddecisionmaker" /></span><span
																			class="notverified"> <s:text
																					name="dashboard.grid.view.assignment.label.iddecisionmaker" />
																		</span>
																		</a> <a href="#"
																			class="list-group-item list-group-item-default"
																			id="alignleft"><span class="badge"><s:property
																					value="pricequote" /></span><span class="junklead">
																				<s:text
																					name="dashboard.grid.view.assignment.label.pricequote" />
																		</span> </a> <a href="#"
																			class="list-group-item list-group-item-default"
																			id="alignleft"><span class="badge"><s:property
																					value="negosiation" /></span><span class="closed">
																				<s:text
																					name="dashboard.grid.view.assignment.label.negosiation" />
																		</span> </a> <a href="#"
																			class="list-group-item list-group-item-default"
																			id="alignleft"><span class="badge"><s:property
																					value="closedwon" /></span><span class="wormlead">
																				<s:text
																					name="dashboard.grid.view.assignment.label.closedwon" />
																		</span> </a> <a href="#"
																			class="list-group-item list-group-item-default"
																			id="alignleft"><span class="badge"><s:property
																					value="closedlost" /></span><span class="new"> <s:text
																					name="dashboard.grid.view.assignment.label.Closedlost" />
																		</span> </a> <a href="#"
																			class="list-group-item list-group-item-default"
																			id="alignleft"><span class="badge"><s:property
																					value="closedtocompitation" /></span><span
																			class="prequalified"> <s:text
																					name="dashboard.grid.view.assignment.label.closedcompitation" />
																		</span> </a>

																	</div>
																</s:iterator>
															</div>
														</div>
													</div>

												</div>
											</div>
										</div>
									</div>
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