<%@ page import="com.bst.ckt.common.LoginUtil"%>
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
									<li><a href="leadStatusModule">Analytics</a></li>

								</ul>
								<div class="tab-content" id="myTabContent"
									style="white-space: normal;"></div>

							</div>
							<div class="row">
								<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
									<div class="panel panel-default">
										<div class="pull-right">


											<div class="btn-group" style="margin-top: 3px;">
												<a href="dashboardUsersGrid.action" data-toggle="tooltip"
													data-placement=bottom title="Grid Preview"
													class="btn btn-success "> <span
													class="glyphicon glyphicon-th"></span>&nbsp;<s:text
														name="user.dashboard.button.grid.preview"></s:text>

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

												<!-- ****************************  Grid preview  ************************************-->
												<div class="row">
													<s:iterator value="userTitleGrid">
														<div class="text-center">
															<div class="col-xs-12 col-sm-4 col-md-4 col-lg-4">

																<div class="row">

																	<div class="col-lg-12">

																		<a href="#" class="list-group-item ">

																			<div class="row">
																				<div class="col-lg-4">
																					<img class="img-circle" alt="image1"
																						src="profileImage/<%=LoginUtil.getCurrentCustomerUser().getCustomerId()%>/<%=LoginUtil.getCurrentCustomerUser().getCustomerId()
						+ ".png"%>"><br>
																				</div>
																				<div class="col-lg-8">
																					User Id:
																					<s:property value="customerId" />
																					<br> <b><s:property value="fullName" /></b><br>
																					<div class="color" style="color: orange;">
																						<s:property value="userRole" />
																					</div>
																					Super Admin

																				</div>
																			</div>
																		</a>
																		<div class="list-group-item "
																			style="background-color: #F8F8F8;">

																			<div class="row">

																				<div class="col-lg-4 col-md-12 col-sm-12 col-xs-12"
																					style="margin-left: -10px;">
																					<span>AUG 15,2015 3:13:05</span>
																				</div>
																				<div class="col-lg-8 col-md-12 col-sm-12 col-xs-12"
																					style="margin-left: 10px;">
																					<td align="right">
																						<div class="btn-group">
																							<a href="" data-toggle="tooltip"
																								data-original-title="Setting"
																								data-placement="bottom"
																								class="btn btn-default btn-sm"> <i
																								class="fa fa-gear btniconcolor"></i>
																							</a>
																						</div>


																						<div class="btn-group">
																							<a href="" data-toggle="tooltip"
																								data-original-title="Logger"
																								data-placement="bottom"
																								class="btn btn-default btn-sm"> <span
																								class="glyphicon glyphicon-list-alt"></span>
																							</a>
																						</div>


																						<div class="btn-group">
																							<a href="" data-toggle="tooltip"
																								data-original-title="Task"
																								data-placement="bottom"
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
																								data-original-title="Chat"
																								data-placement="bottom"
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
																				</div>




																			</div>

																		</div>

																	</div>

																</div>
															</div>


														</div>
													</s:iterator>

													<br>
												</div>

												<!-- ****************************  close  ******************************** ***-->

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