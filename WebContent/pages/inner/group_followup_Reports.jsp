<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="/struts-jquery-tags" prefix="sj"%>
<body>
	<div id="content">
		<div class="outer">
			<div class="inner bg-light lter">

				<!--Begin Datatables-->
				<div class="row">
					<div class="col-lg-12">
						<div class="box">
							<header>

								<a class="icons" href="crmReports.action" data-toggle="tooltip"
									data-original-title="Back To DashBoard" style="color: black;">
									<i class="fa fa-th-large"></i>
								</a>


								<h5>
									<s:text name="Search By Group Follow Up" />
								</h5>

							</header>

							<div id="collapse4" class="body">
								<div class="alert alert-info" role="alert">
									<span class="fa fa-info" style="margin-right: 10px;"></span>Manage
									your personal details, contact, information, language,country
									and timezone.
								</div>
								<div class="table-responsive">
									<div id="dashboard_search_tools"
										style="padding-top: 10px; padding-bottom: 7px; background-color: #F9F9F9;">
										<div class="row">
											<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"
												style="margin-left: 5px;">
												<div class="row" style="margin-right: 27px;">
													<%-- 	<div class="col-lg-1 col-md-1 col-sm-12 col-xs-12">
														<h5>
															<label> <s:text name="Lead Id:" />
															</label>
														</h5>
													</div>
 --%>
													<div class="col-lg-10  col-md-10 col-sm-12 col-xs-12">
														<div class="row">
															<div class="col-lg-1 col-md-1 col-sm-12 col-xs-12">
																<h5>
																	<label> <s:text name="Group Id:" />
																	</label>
																</h5>
															</div>



															<div class="col-lg-3 col-md-3 col-sm-9 col-xs-7">
																<input type="text" name="leadDate" value=""
																	class="form-control">
															</div>
															<div class="col-lg-1 col-md-1 col-sm-9 col-xs-7">
																ajax</div>
															<div class="col-lg-3 col-md-3 col-sm-3 col-xs-4">
																<div class="btn-group">
																	<a href="#" data-toggle="tooltip"
																		data-original-title="Search" data-placement="bottom"
																		class="btn btn-success btn-md"> <i
																		class="fa fa-search"></i>
																	</a>
																</div>
															</div>
														</div>

													</div>
													<div
														class="col-lg-1 col-lg-offset-1 col-md-1 col-md-offset-1 col-sm-12 col-xs-12"
														style="margin-top: 5px;">
														<div class="form-group">
															<button onclick="window.location.reload();"
																data-toggle="tooltip" data-original-title="Refresh"
																data-placement="bottom" class="btn btn-metis-2 btn-line">
																<i class="fa fa-refresh   "></i>
															</button>
															<a href="login.html" data-toggle="tooltip"
																data-original-title="XLS Report" data-placement="bottom"
																class="btn btn-metis-6 btn-line"> <i
																class="fa fa-file-excel-o "></i>

															</a>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
									<br>
									<%--  
									<table id="dataTable"
										class="table table-bordered table-condensed table-hover table-striped">
										<thead>
											<tr id="myrow">
												<th><s:text name="group.dashboard.table.groupid" /></th>
												<th><s:text name="group.dashboard.table.groupname" /></th>
												<th><s:text name="group.dashboard.table.groupcategory" /></th>
												<th><s:text name="group.dashboard.table.groupadmin" /></th>
												<th><s:text name="group.dashboard.table.createddate" /></th>
												<th><s:text name="group.dashboard.table.status" /></th>
												<th><s:text name="group.dashboard.table.action" /></th>

											</tr>
										</thead>
										<tbody>
											<s:iterator value="groupDetailList">
												<tr>
													<td><a
														href="viewGroupInformation.action?command=
												<s:property value="groupId"/>"
														style="color: blue;"><s:property value="groupId" /></a></td>
													<td><s:property value="groupName" /></td>
													<td><s:property value="groupCategory" /></td>
													<td><s:property value="groupAdmin" /></td>
													<td><s:property value="createdDate" /></td>
													<td><s:property value="groupStatusName" /></td>
													<td><div class="btn-group">
															<a href="login.html" data-toggle="tooltip"
																data-original-title="Print" data-placement="bottom"
																class="btn btn-metis-5 btn-xs"> <i
																class="fa fa-print"></i>
															</a>
														</div>

														<div class="btn-group">
															<a
																href="populatGroupInformation.action?command=<s:property value="groupId"/>"
																data-toggle="tooltip" data-original-title="Edit"
																data-placement="bottom" class="btn btn-metis-6 btn-xs">
																<i class="fa fa-edit"></i>
															</a>
														</div>


														<div class="btn-group">
															<a href="login.html" data-toggle="tooltip"
																data-original-title="Delete" data-placement="bottom"
																class="btn btn-metis-1 btn-xs"> <i
																class="fa fa-trash-o"></i>
															</a>
														</div></td>
												</tr>
											</s:iterator>
										</tbody>
									</table> --%>

									<table id="dataTable"
										class="table table-bordered table-condensed table-hover table-striped">
										<thead>
											<tr id="myrow">
												<th>Lead Id</th>
												<th>Company</th>
												<th>Title</th>
												<th>Lead Owner</th>
												<th>Created Date</th>
												<th>Excepted Date</th>
												<th>Status</th>
												<th>Action</th>

											</tr>
										</thead>
										<tbody>

											<tr>
												<td><a href="viewFollowUpAssignment.action"
													id="row_a_link">28565</a></td>
												<td>vanrasoft software solutions</td>
												<td>Dynamic web site 25 pages php fully
													responshivDynamic web site 25 pages php fully responshiv</td>
												<td>Deepak vishwakarma</td>
												<td>25-12-2015</td>
												<td>28-12-2015</td>
												<td><a class="btn btn-default btn-xs btn-line" href="#">New</a></td>

												<td><div class="btn-group">
														<a href="login.html" data-toggle="tooltip"
															data-original-title="Print" data-placement="bottom"
															class="btn btn-metis-5 btn-xs"> <i
															class="fa fa-print"></i>
														</a>
													</div>

													<div class="btn-group">
														<a href="updateFollowUpAssignment.action"
															data-toggle="tooltip" data-original-title="Edit"
															data-placement="bottom" class="btn btn-metis-6 btn-xs">
															<i class="fa fa-edit"></i>
														</a>
													</div>


													<div class="btn-group">
														<a href="login.html" data-toggle="tooltip"
															data-original-title="Delete" data-placement="bottom"
															class="btn btn-metis-1 btn-xs"> <i
															class="fa fa-trash-o"></i>
														</a>
													</div></td>

											</tr>
											<tr>
												<td><a href="templet.action" id="row_a_link">12546358958</a></td>
												<td>jobsarthi software solutions</td>
												<td>Dynamic web site 25 pages php fully
													responshivDynamic web site 25 pages php fully responshiv</td>
												<td>Deepak vishwakarma</td>
												<td>25-12-2015</td>
												<td>28-12-2015</td>
												<td><a class="btn btn-primary btn-xs btn-line" href="#">Open</a></td>

												<td><div class="btn-group">
														<a href="login.html" data-toggle="tooltip"
															data-original-title="Print" data-placement="bottom"
															class="btn btn-metis-5 btn-xs"> <i
															class="fa fa-print"></i>
														</a>
													</div>

													<div class="btn-group">
														<a href="login.html" data-toggle="tooltip"
															data-original-title="Edit" data-placement="bottom"
															class="btn btn-metis-6 btn-xs"> <i class="fa fa-edit"></i>
														</a>
													</div>


													<div class="btn-group">
														<a href="login.html" data-toggle="tooltip"
															data-original-title="Delete" data-placement="bottom"
															class="btn btn-metis-1 btn-xs"> <i
															class="fa fa-trash-o"></i>
														</a>
													</div></td>

											</tr>
											<tr>
												<td><a href="templet.action" id="row_a_link">12546358958</a></td>
												<td>jobsarthi software solutions</td>
												<td>Dynamic web site 25 pages php fully
													responshivDynamic web site 25 pages php fully responshiv</td>
												<td>Deepak vishwakarma</td>
												<td>25-12-2015</td>
												<td>28-12-2015</td>
												<td><a class="btn btn-success btn-xs btn-line" href="#">Submitted</a></td>

												<td><div class="btn-group">
														<a href="login.html" data-toggle="tooltip"
															data-original-title="Print" data-placement="bottom"
															class="btn btn-metis-5 btn-xs"> <i
															class="fa fa-print"></i>
														</a>
													</div>

													<div class="btn-group">
														<a href="login.html" data-toggle="tooltip"
															data-original-title="Edit" data-placement="bottom"
															class="btn btn-metis-6 btn-xs"> <i class="fa fa-edit"></i>
														</a>
													</div>


													<div class="btn-group">
														<a href="login.html" data-toggle="tooltip"
															data-original-title="Delete" data-placement="bottom"
															class="btn btn-metis-1 btn-xs"> <i
															class="fa fa-trash-o"></i>
														</a>
													</div></td>

											</tr>
											<tr>
												<td><a href="templet.action" id="row_a_link">12546358958</a></td>
												<td>jobsarthi software solutions</td>
												<td>Dynamic web site 25 pages php fully
													responshivDynamic web site 25 pages php fully responshiv</td>
												<td>Deepak vishwakarma</td>
												<td>25-12-2015</td>
												<td>28-12-2015</td>
												<td><a class="btn btn-metis-4 btn-xs btn-line" href="#">Registered</a></td>

												<td><div class="btn-group">
														<a href="login.html" data-toggle="tooltip"
															data-original-title="Print" data-placement="bottom"
															class="btn btn-metis-5 btn-xs"> <i
															class="fa fa-print"></i>
														</a>
													</div>

													<div class="btn-group">
														<a href="login.html" data-toggle="tooltip"
															data-original-title="Edit" data-placement="bottom"
															class="btn btn-metis-6 btn-xs"> <i class="fa fa-edit"></i>
														</a>
													</div>


													<div class="btn-group">
														<a href="login.html" data-toggle="tooltip"
															data-original-title="Delete" data-placement="bottom"
															class="btn btn-metis-1 btn-xs"> <i
															class="fa fa-trash-o"></i>
														</a>
													</div></td>

											</tr>
											<tr>
												<td><a href="templet.action" id="row_a_link">12546358958</a></td>
												<td>jobsarthi software solutions</td>
												<td>Dynamic web site 25 pages php fully
													responshivDynamic web site 25 pages php fully responshiv</td>
												<td>Deepak vishwakarma</td>
												<td>25-12-2015</td>
												<td>28-12-2015</td>
												<td><a class="btn btn-warning btn-xs btn-line" href="#">Pending</a></td>

												<td><div class="btn-group">
														<a href="login.html" data-toggle="tooltip"
															data-original-title="Print" data-placement="bottom"
															class="btn btn-metis-5 btn-xs"> <i
															class="fa fa-print"></i>
														</a>
													</div>

													<div class="btn-group">
														<a href="login.html" data-toggle="tooltip"
															data-original-title="Edit" data-placement="bottom"
															class="btn btn-metis-6 btn-xs"> <i class="fa fa-edit"></i>
														</a>
													</div>


													<div class="btn-group">
														<a href="login.html" data-toggle="tooltip"
															data-original-title="Delete" data-placement="bottom"
															class="btn btn-metis-1 btn-xs"> <i
															class="fa fa-trash-o"></i>
														</a>
													</div></td>

											</tr>
											<tr>
												<td><a href="templet.action" id="row_a_link">12546358958</a></td>
												<td>jobsarthi software solutions</td>
												<td>Dynamic web site 25 pages php fully
													responshivDynamic web site 25 pages php fully responshiv</td>
												<td>Deepak vishwakarma</td>
												<td>25-12-2015</td>
												<td>28-12-2015</td>
												<td><a class="btn btn-metis-6 btn-xs btn-line" href="#">Approved</a></td>

												<td><div class="btn-group">
														<a href="login.html" data-toggle="tooltip"
															data-original-title="Print" data-placement="bottom"
															class="btn btn-metis-5 btn-xs"> <i
															class="fa fa-print"></i>
														</a>
													</div>

													<div class="btn-group">
														<a href="login.html" data-toggle="tooltip"
															data-original-title="Edit" data-placement="bottom"
															class="btn btn-metis-6 btn-xs"> <i class="fa fa-edit"></i>
														</a>
													</div>


													<div class="btn-group">
														<a href="login.html" data-toggle="tooltip"
															data-original-title="Delete" data-placement="bottom"
															class="btn btn-metis-1 btn-xs"> <i
															class="fa fa-trash-o"></i>
														</a>
													</div></td>

											</tr>
											<tr>
												<td><a href="templet.action" id="row_a_link">12546358958</a></td>
												<td>jobsarthi software solutions</td>
												<td>Dynamic web site 25 pages php fully
													responshivDynamic web site 25 pages php fully responshiv</td>
												<td>Deepak vishwakarma</td>
												<td>25-12-2015</td>
												<td>28-12-2015</td>
												<td><a class="btn btn-metis-6 btn-xs btn-line" href="#">Rejected</a></td>

												<td><div class="btn-group">
														<a href="login.html" data-toggle="tooltip"
															data-original-title="Print" data-placement="bottom"
															class="btn btn-metis-5 btn-xs"> <i
															class="fa fa-print"></i>
														</a>
													</div>

													<div class="btn-group">
														<a href="login.html" data-toggle="tooltip"
															data-original-title="Edit" data-placement="bottom"
															class="btn btn-metis-6 btn-xs"> <i class="fa fa-edit"></i>
														</a>
													</div>


													<div class="btn-group">
														<a href="login.html" data-toggle="tooltip"
															data-original-title="Delete" data-placement="bottom"
															class="btn btn-metis-1 btn-xs"> <i
															class="fa fa-trash-o"></i>
														</a>
													</div></td>

											</tr>
											<tr>
												<td><a href="templet.action" id="row_a_link">12546358958</a></td>
												<td>jobsarthi software solutions</td>
												<td>Dynamic web site 25 pages php fully
													responshivDynamic web site 25 pages php fully responshiv</td>
												<td>Deepak vishwakarma</td>
												<td>25-12-2015</td>
												<td>28-12-2015</td>
												<td><a class="btn btn-metis-2 btn-xs btn-line" href="#">In-progress</a></td>

												<td><div class="btn-group">
														<a href="login.html" data-toggle="tooltip"
															data-original-title="Print" data-placement="bottom"
															class="btn btn-metis-5 btn-xs"> <i
															class="fa fa-print"></i>
														</a>
													</div>

													<div class="btn-group">
														<a href="login.html" data-toggle="tooltip"
															data-original-title="Edit" data-placement="bottom"
															class="btn btn-metis-6 btn-xs"> <i class="fa fa-edit"></i>
														</a>
													</div>


													<div class="btn-group">
														<a href="login.html" data-toggle="tooltip"
															data-original-title="Delete" data-placement="bottom"
															class="btn btn-metis-1 btn-xs"> <i
															class="fa fa-trash-o"></i>
														</a>
													</div></td>

											</tr>
											<tr>
												<td><a href="templet.action" id="row_a_link">12546358958</a></td>
												<td>jobsarthi software solutions</td>
												<td>Dynamic web site 25 pages php fully
													responshivDynamic web site 25 pages php fully responshiv</td>
												<td>Deepak vishwakarma</td>
												<td>25-12-2015</td>
												<td>28-12-2015</td>
												<td><a class="btn btn-metis-5 btn-xs btn-line" href="#">Review</a></td>

												<td><div class="btn-group">
														<a href="login.html" data-toggle="tooltip"
															data-original-title="Print" data-placement="bottom"
															class="btn btn-metis-5 btn-xs"> <i
															class="fa fa-print"></i>
														</a>
													</div>

													<div class="btn-group">
														<a href="login.html" data-toggle="tooltip"
															data-original-title="Edit" data-placement="bottom"
															class="btn btn-metis-6 btn-xs"> <i class="fa fa-edit"></i>
														</a>
													</div>


													<div class="btn-group">
														<a href="login.html" data-toggle="tooltip"
															data-original-title="Delete" data-placement="bottom"
															class="btn btn-metis-1 btn-xs"> <i
															class="fa fa-trash-o"></i>
														</a>
													</div></td>

											</tr>
											<tr>
												<td><a href="templet.action" id="row_a_link">12546358958</a></td>
												<td>jobsarthi software solutions</td>
												<td>Dynamic web site 25 pages php fully
													responshivDynamic web site 25 pages php fully responshiv</td>
												<td>Deepak vishwakarma</td>
												<td>25-12-2015</td>
												<td>28-12-2015</td>
												<td><a class="btn btn-info btn-xs btn-line" href="#">Active</a></td>

												<td><div class="btn-group">
														<a href="login.html" data-toggle="tooltip"
															data-original-title="Print" data-placement="bottom"
															class="btn btn-metis-5 btn-xs"> <i
															class="fa fa-print"></i>
														</a>
													</div>

													<div class="btn-group">
														<a href="login.html" data-toggle="tooltip"
															data-original-title="Edit" data-placement="bottom"
															class="btn btn-metis-6 btn-xs"> <i class="fa fa-edit"></i>
														</a>
													</div>


													<div class="btn-group">
														<a href="login.html" data-toggle="tooltip"
															data-original-title="Delete" data-placement="bottom"
															class="btn btn-metis-1 btn-xs"> <i
															class="fa fa-trash-o"></i>
														</a>
													</div></td>

											</tr>
											<tr>
												<td><a href="templet.action" id="row_a_link">12546358958</a></td>
												<td>jobsarthi software solutions</td>
												<td>Dynamic web site 25 pages php fully
													responshivDynamic web site 25 pages php fully responshiv</td>
												<td>Deepak vishwakarma</td>
												<td>25-12-2015</td>
												<td>28-12-2015</td>
												<td><a class="btn btn-success btn-xs btn-line" href="#">Completed</a></td>

												<td><div class="btn-group">
														<a href="login.html" data-toggle="tooltip"
															data-original-title="Print" data-placement="bottom"
															class="btn btn-metis-5 btn-xs"> <i
															class="fa fa-print"></i>
														</a>
													</div>

													<div class="btn-group">
														<a href="login.html" data-toggle="tooltip"
															data-original-title="Edit" data-placement="bottom"
															class="btn btn-metis-6 btn-xs"> <i class="fa fa-edit"></i>
														</a>
													</div>


													<div class="btn-group">
														<a href="login.html" data-toggle="tooltip"
															data-original-title="Delete" data-placement="bottom"
															class="btn btn-metis-1 btn-xs"> <i
															class="fa fa-trash-o"></i>
														</a>
													</div></td>

											</tr>
											<tr>
												<td><a href="templet.action" id="row_a_link">12546358958</a></td>
												<td>jobsarthi software solutions</td>
												<td>Dynamic web site 25 pages php fully
													responshivDynamic web site 25 pages php fully responshiv</td>
												<td>Deepak vishwakarma</td>
												<td>25-12-2015</td>
												<td>28-12-2015</td>
												<td><a class="btn btn-primary btn-xs btn-line" href="#">Reopen</a></td>

												<td><a href="login.html" data-toggle="tooltip"
													data-original-title="Print" data-placement="bottom"
													class="btn btn-metis-5 btn-xs"> <i class="fa fa-print"></i>
												</a> <a href="login.html" data-toggle="tooltip"
													data-original-title="Edit" data-placement="bottom"
													class="btn btn-metis-6 btn-xs"> <i class="fa fa-edit"></i>
												</a> <a href="login.html" data-toggle="tooltip"
													data-original-title="Delete" data-placement="bottom"
													class="btn btn-metis-1 btn-xs"> <i
														class="fa fa-trash-o"></i>
												</a></td>

											</tr>

											<tr>
												<td><a href="templet.action" id="row_a_link">12546358958</a></td>
												<td>jobsarthi software solutions</td>
												<td>Dynamic web site 25 pages php fully
													responshivDynamic web site 25 pages php fully responshiv</td>
												<td>Deepak vishwakarma</td>
												<td>25-12-2015</td>
												<td>28-12-2015</td>
												<td><a class="btn btn-metis-1 btn-xs btn-line" href="#">Suspend</a></td>

												<td><div class="btn-group">
														<a href="login.html" data-toggle="tooltip"
															data-original-title="Print" data-placement="bottom"
															class="btn btn-metis-5 btn-xs"> <i
															class="fa fa-print"></i>
														</a>
													</div>

													<div class="btn-group">
														<a href="login.html" data-toggle="tooltip"
															data-original-title="Edit" data-placement="bottom"
															class="btn btn-metis-6 btn-xs"> <i class="fa fa-edit"></i>
														</a>
													</div>


													<div class="btn-group">
														<a href="login.html" data-toggle="tooltip"
															data-original-title="Delete" data-placement="bottom"
															class="btn btn-metis-1 btn-xs"> <i
															class="fa fa-trash-o"></i>
														</a>
													</div></td>

											</tr>
											<tr>
												<td><a href="templet.action" id="row_a_link">12546358958</a></td>
												<td>jobsarthi software solutions</td>
												<td>Dynamic web site 25 pages php fully
													responshivDynamic web site 25 pages php fully responshiv</td>
												<td>Deepak vishwakarma</td>
												<td>25-12-2015</td>
												<td>28-12-2015</td>
												<td><a class="btn btn-metis-1 btn-xs btn-line" href="#">Blocked</a></td>

												<td><div class="btn-group">
														<a href="login.html" data-toggle="tooltip"
															data-original-title="Print" data-placement="bottom"
															class="btn btn-metis-5 btn-xs"> <i
															class="fa fa-print"></i>
														</a>
													</div>

													<div class="btn-group">
														<a href="login.html" data-toggle="tooltip"
															data-original-title="Edit" data-placement="bottom"
															class="btn btn-metis-6 btn-xs"> <i class="fa fa-edit"></i>
														</a>
													</div>


													<div class="btn-group">
														<a href="login.html" data-toggle="tooltip"
															data-original-title="Delete" data-placement="bottom"
															class="btn btn-metis-1 btn-xs"> <i
															class="fa fa-trash-o"></i>
														</a>
													</div></td>

											</tr>

											<tr>
												<td><a href="templet.action" id="row_a_link">12546358958</a></td>
												<td>jobsarthi software solutions</td>
												<td>Dynamic web site 25 pages php fully
													responshivDynamic web site 25 pages php fully responshiv</td>
												<td>Deepak vishwakarma</td>
												<td>25-12-2015</td>
												<td>28-12-2015</td>
												<td><a class="btn btn-danger btn-xs btn-line" href="#">Closed</a></td>

												<td><div class="btn-group">
														<a href="login.html" data-toggle="tooltip"
															data-original-title="Print" data-placement="bottom"
															class="btn btn-metis-5 btn-xs"> <i
															class="fa fa-print"></i>
														</a>
													</div>

													<div class="btn-group">
														<a href="login.html" data-toggle="tooltip"
															data-original-title="Edit" data-placement="bottom"
															class="btn btn-metis-6 btn-xs"> <i class="fa fa-edit"></i>
														</a>
													</div>


													<div class="btn-group">
														<a href="login.html" data-toggle="tooltip"
															data-original-title="Delete" data-placement="bottom"
															class="btn btn-metis-1 btn-xs"> <i
															class="fa fa-trash-o"></i>
														</a>
													</div></td>

											</tr>
											<tr>
												<td><a href="templet.action" id="row_a_link">12546358958</a></td>
												<td>jobsarthi software solutions</td>
												<td>Dynamic web site 25 pages php fully
													responshivDynamic web site 25 pages php fully responshiv</td>
												<td>Deepak vishwakarma</td>
												<td>25-12-2015</td>
												<td>28-12-2015</td>
												<td><a class="btn btn-danger btn-xs btn-line" href="#">Deleted</a></td>

												<td><div class="btn-group">
														<a href="login.html" data-toggle="tooltip"
															data-original-title="Print" data-placement="bottom"
															class="btn btn-metis-5 btn-xs"> <i
															class="fa fa-print"></i>
														</a>
													</div>

													<div class="btn-group">
														<a href="login.html" data-toggle="tooltip"
															data-original-title="Edit" data-placement="bottom"
															class="btn btn-metis-6 btn-xs"> <i class="fa fa-edit"></i>
														</a>
													</div>


													<div class="btn-group">
														<a href="login.html" data-toggle="tooltip"
															data-original-title="Delete" data-placement="bottom"
															class="btn btn-metis-1 btn-xs"> <i
															class="fa fa-trash-o"></i>
														</a>
													</div></td>

											</tr>



										</tbody>
									</table>




								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- /.row -->

				<!--End Datatables-->





			</div>
		</div>
		<!-- /.inner -->
	</div>
	<!-- /.outer -->

	<!-- /#content -->




	<!-- Screenfull -->
	<script
		src="assets/lib/bootstrap3-wysihtml5-bower/bootstrap3-wysihtml5.all.min.js"></script>
	<script src="assets/lib/ckeditor/ckeditor.js"></script>
	<!-- Metis demo scripts -->




	<script src="assets/lib/screenfull/screenfull.js"></script>
	<script src="assets/lib/datatables/jquery.dataTables.js"></script>
	<script src="assets/lib/datatables/3/dataTables.bootstrap.js"></script>
	<script src="assets/lib/jquery.tablesorter/jquery.tablesorter.min.js"></script>
	<script
		src="assets/lib/jquery-ui-touch-punch/jquery.ui.touch-punch.min.js"></script>

	<!-- Metis core scripts -->
	<script src="assets/js/core.min.js"></script>

	<!-- Metis demo scripts -->
	<script src="assets/js/app.min.js"></script>
	<script>
		$(function() {
			Metis.MetisTable();

			Metis.formGeneral();
			Metis.formWysiwyg();
		});
	</script>
	<script src="assets/js/style-switcher.min.js"></script>
</body>
