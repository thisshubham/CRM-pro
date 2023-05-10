<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="/struts-jquery-tags" prefix="sj"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
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
								<li class="active"><s:text
										name="user.dashboard.navigation.bar.user"></s:text></li>
							</ol>

							<div class="bs-example">
								<ul class="nav nav-tabs" id="myTab">
									<li><a href="omiInnerDashboard.action">Dashboard</a></li>
									<li class="active"><a href="dashboardUsers">Users</a></li>
									<li><a href="dashboardGraphReports">Quick Reports</a></li>
									<li><a href="dashboardAnalytics">Analytics</a></li>

								</ul>
								<div class="tab-content" id="myTabContent"
									style="white-space: normal;"></div>

							</div>
							<div class="row">
								<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
									<div class="panel panel-default">
										<div class="pull-right">


											<div class="btn-group" style="margin-top: 3px;">
												<a href="dashboardUsers.action" data-toggle="tooltip"
													data-placement=bottom title="Thumnail Preview"
													class="btn btn-success "> <span
													class="glyphicon glyphicon-user"></span>&nbsp;<s:text
														name="user.dashboard.button.thumbnail.preview"></s:text>

												</a> <a href="#borderedTable" data-toggle="collapse"
													data-placement=bottom title="close" class="btn btn-info ">
													<span class="fa fa-angle-up"></span>&nbsp;
												</a>
											</div>


										</div>
										<div class="panel-heading">
											<h3 class="panel-title">
												<s:text name="users.dashboard.pannel.heading" />
											</h3>

										</div>


										<div class="panel-body">
											<div id="borderedTable" class="body collapse in  ">
												<table id="dataTable"
													class="table table-bordered table-condensed table-hover table-striped">

													<tbody>
														<tr id="myrow">

															<th><s:text
																	name="user.dashboard.grid.heading.user.id" /></th>
															<th><s:text name="user.dashboard.grid.heading.name" /></th>
															<th><s:text
																	name="user.dashboard.grid.heading.designation" /></th>
															<th><s:text name="user.dashboard.grid.heading.role" /></th>
															<th><s:text
																	name="user.dashboard.grid.heading.activitiy" /></th>

														</tr>
														<s:iterator value="userTitleGrid">

															<tr>
																<td><s:property value='customerId' /></td>
																<td><s:property value="fullName" /></td>
																<td><s:property value="designation" /></td>
																<td><s:property value="userRole" /></td>



																<td align="center">
																	<div class="btn-group">
																		<a href="" data-toggle="tooltip"
																			data-original-title="setting" data-placement="bottom"
																			class="btn btn-default btn-sm"> <i
																			class="fa fa-gear btniconcolor"></i>
																		</a>
																	</div>


																	<div class="btn-group">
																		<a href="" data-toggle="tooltip"
																			data-original-title="logger" data-placement="bottom"
																			class="btn btn-default btn-sm"> <span
																			class="glyphicon glyphicon-list-alt"></span>
																		</a>
																	</div>


																	<div class="btn-group">
																		<a href="" data-toggle="tooltip"
																			data-original-title="task" data-placement="bottom"
																			class="btn btn-default btn-sm"> <span
																			class="glyphicon glyphicon-tasks"></span>
																		</a>
																	</div>
																	<div class="btn-group">
																		<a href="" data-toggle="tooltip"
																			data-original-title="User Detail"
																			data-placement="bottom"
																			class="btn btn-default btn-sm"> <span
																			class="glyphicon glyphicon-user"></span>
																		</a>
																	</div>
																	<div class="btn-group">
																		<a href="" data-toggle="tooltip"
																			data-original-title="chat" data-placement="bottom"
																			class="btn btn-default btn-sm"> <span
																			class="glyphicon glyphicon-comment"></span>
																		</a>
																	</div>
																	<div class="btn-group">
																		<a href="" data-toggle="tooltip"
																			data-original-title="Login Status"
																			data-placement="bottom"
																			class="btn btn-default btn-sm"> <i
																			class="fa fa-circle" style="color: red;"></i>
																		</a>
																	</div>
																</td>

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


					</div>

				</div>
			</div>
		</div>
	</div>






</body>
</html>