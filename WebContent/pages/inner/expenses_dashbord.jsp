<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<body>
	<div id="content">
		<div class="outer">
			<div class="inner bg-light lter">

				<!--Begin Datatables-->
				<div class="row">
					<div class="col-lg-12">
						<ol class="breadcrumb" style="margin-top: 10px;">
							<li><a href="#">Home</a></li>
							<li><a href="#">Expenses</a></li>
							<li class="active">Monthly</li>
						</ol>
						<div class="box">
							<header>
								<div class="pull-left">
									<a class="icons" href="dashboard.action" data-toggle="tooltip"
										data-original-title="Back To DashBoard"> <i
										class="fa fa-table"></i>
									</a>

									<h5 class="header_color">
										<s:text name="Monthly Expenses DashBoard"></s:text>
									</h5>
								</div>
								<div class="pull-right">
									<div class="btn-group">
										<a href="renderAddNewLead.action" data-toggle="tooltip"
											data-original-title="New Monthly Expenses"
											class="btn btn-primary btnheight"><i
											class="fa fa-plus fontawesomeht ">&nbsp;<s:text
													name="lead.dashboard.addlead"></s:text></i></a>
										<button type="button" class="btn btn-info "
											data-toggle="collapse" data-target="#collapse1">
											<i class="fa fa-filter"></i> Filter
										</button>
										<a class="btn btn-success btnheight" data-toggle="tooltip"
											data-original-title="Refresh" href="leadDashboard.action"><i
											class="fa fa-refresh "></i></a> <a href="leadExcelReport.action"
											type="button" data-toggle="tooltip"
											data-original-title="XLS Report"
											class="btn btn-default btnheight"><i
											class="fa fa-file-excel-o fontawesomeht"></i></a> <a href=""
											data-toggle="tooltip" data-original-title="Settings"
											type="button" class="btn btn-warning btnheight"><i
											class="fa fa-gear fontawesomeht "></i></a> <a
											href="dashboard.action" data-toggle="tooltip"
											data-original-title="Close" class="btn btn-danger btnheight"><i
											class="fa fa-times fontawesomeht"></i></a>
									</div>

								</div>
							</header>
						
							<div id="collapse4" class="body">
								<div class="table-responsive">

										<div class="row">
											<div class="col-lg-12  col-md-12  col-sm-12 col-xs-12"
												style="margin-bottom: -14px;margin-top: 16px;">

												<div class="row">

													<div class="col-lg-7  col-md-7  col-sm-12 col-xs-12"
														style="margin-top: -13px;">
														<a class="quick-icons" href="#" data-toggle="tooltip" data-placement="right" 
										data-original-title="Back To DashBoard"> <i
															class="fa fa-files-o fa-2x"></i> <span>Copy</span>
															<%-- <span class="label label-default">2</span> --%>
														</a>
														
														
														 <a class="quick-icons" href="#"  data-toggle="tooltip" data-placement="right" 
										data-original-title="Back To DashBoard"> <i
															class="fa fa-clone fa-2x"></i> <span>Clone</span>
															<%-- <span class="label label-default">2</span> --%>
														</a> <a class="quick-icons" href="#"> <i
															class="fa fa-exchange fa-2x"></i> <span>Convert</span>
															<%-- <span class="label label-default">2</span> --%>
														</a> <a class="quick-icons" href="#"> <i
															class="fa fa-clipboard fa-2x"></i> <span>Paste</span>
															<%-- <span class="label label-default">2</span> --%>
														</a> <a class="quick-icons" href="#"> <i
															class="fa fa fa-envelope fa-2x"></i> <span>Alerts</span>
															<%-- <span class="label label-default">2</span> --%>
														</a> <a class="quick-icons" href="#"> <i
															class="fa fa fa-comment fa-2x"></i> <span>Alerts</span>
															<%-- <span class="label label-default">2</span> --%>
														</a>


													</div>
													<div class="col-lg-1  col-md-1  col-sm-12 col-xs-12">
														<label>
															<h5>
																<s:text name="lead.dashboard.searchby"></s:text>
															</h5>
														</label>
													</div>
													<div class="col-lg-2  col-md-2  col-sm-12 col-xs-12">
														<select class="form-control">
															<option>1</option>
															<option>2</option>
															<option>3</option>
															<option>4</option>
															<option>5</option>
														</select>
													</div>

													<div class="col-lg-2  col-md-2  col-sm-12 col-xs-12">

														<div class="input-group">
															<input class="form-control" type="text"><span
																class="input-group-btn"> <a
																class="btn btn-metis-5 btn-line" type="button"
																href="groupDashboard.action"> <span
																	class="glyphicon glyphicon-search"></span>&nbsp;
															</a>
															</span>
														</div>



													</div>
												</div>
											</div>
										</div>
								
									<hr>

									<table id="dataTable"
										class="table table-bordered table-condensed table-hover table-striped">

										<thead>
											<tr id="myrow">
												<th><s:text name="lead.dashboard.leadid"></s:text></th>
												<th><s:text name="lead.dashboard.company"></s:text></th>
												<th><s:text name="lead.dashboard.leadtitle"></s:text></th>
												<th><s:text name="lead.dashboard.contactperson"></s:text></th>
												<th><s:text name="lead.dashboard.leadowner"></s:text></th>
												<th><s:text name="add.create.lead.lead.date"></s:text></th>
												<th><s:text name="lead.dashboard.expecteddate"></s:text></th>
												<th><s:text name="lead.dashboard.status"></s:text></th>
												<th style="width: 5%;"><s:text
														name="lead.dashboard.action"></s:text></th>
											</tr>
										</thead>
										<tbody>
											<s:iterator value="leadDetailList">
												<tr>
													<td><a style="color: blue"
														href="viewLead?command=<s:property value='leadId' />"><s:property
																value='leadId' /></a></td>
													<td><s:property value="companyName" /></td>
													<td><s:property value="leadTitle" /></td>
													<td><s:property value="fullName" /></td>
													<td><s:property value="leadOwner" /></td>
													<td><s:property value="leadDate" /></td>
													<td><s:property value="expectedClosingDate" /></td>
													<td><s:property value="leadSourceStatus" /></td>

													<td align="center">
														<div class="btn-group">
															<a  id="view" href="viewLead?command=<s:property value='leadId'/>"
																data-toggle="tooltip" data-original-title="View"
																data-placement="bottom"> <i class="fa fa-eye"></i>
															</a>
														</div>


														<div class="btn-group">
															<a id="edit"
																href="editLead.action?command=<s:property value='leadId' />"
																data-toggle="tooltip" data-original-title="Edit"
																data-placement="bottom"> <i class="fa fa-edit"></i>
															</a>
														</div>


														<div class="btn-group">
															<a id="delete" href="login.html" data-toggle="tooltip"
																data-original-title="Delete" data-placement="bottom">
																<i class="fa fa-trash-o"></i>
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

	<script
		src="assets/lib/bootstrap3-wysihtml5-bower/bootstrap3-wysihtml5.all.min.js"></script>
	<script src="assets/lib/ckeditor/ckeditor.js"></script>

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
			Metis.metisSortable();
		});
	</script>
	<script src="assets/js/style-switcher.min.js"></script>
</body>
