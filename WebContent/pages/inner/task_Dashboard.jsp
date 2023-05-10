<%@ taglib uri="/struts-tags" prefix="s"%>
<body>

	<div id="content">
		<div class="outer">
			<div class="inner bg-light lter">

				<!--Begin Datatables-->
				<div class="row">
					<div class="col-lg-12">
						<div class="box inverse">
							<header>
								<a class="icons" href="dashboard.action" data-toggle="tooltip"
									data-original-title="Back To DashBoard"> <i
									class="fa fa-table"></i>
								</a>
								<h5>
									<s:text name="task.dashboard"></s:text>
								</h5>

							</header>
							<div id="collapse4" class="body">
								<div class="table-responsive">
									<div id="dashboard_search_tools">
										<div class="row form-group">
											<div class="col-lg-12  col-md-12  col-sm-12 col-xs-12"
												style="margin-bottom: 2px;">
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

												<div class="col-lg-2  col-md-3  col-sm-12 col-xs-12">
													<div class="row form-group">
														<div class="col-lg-10  col-md-9  col-sm-9 col-xs-9">
															<input type="text" id="text1" class="form-control">
														</div>
														<div class="col-lg-1  col-md-1  col-sm-3 col-xs-3"
															style="margin-top: 4px;">
															<a href="#" data-toggle="tooltip"
																data-original-title="Search" data-placement="bottom"
																class="btn btn-success btn-md"> <i
																class="fa fa-search"></i>
															</a>
														</div>
													</div>
												</div>

												<div class="col-lg-4  col-md-2  col-sm-12 col-xs-12"></div>
												<div class="col-lg-3  col-md-3  col-sm-12 col-xs-12"
													align="right" style="margin-top: 5px;">
													<a href="renderAddNewTask.action" data-toggle="tooltip"
														data-original-title="Add" data-placement="bottom"
														class="btn btn-primary "> <i class="fa fa-plus ">&nbsp;<s:text
																name="task.dashboard.addtask"></s:text>
													</i>
													</a> <a data-toggle="tooltip" data-original-title="Refresh"
														data-placement="bottom" class="btn btn-metis-2 btn-line"
														onclick="window.location.reload();"> <i
														class="fa fa-refresh "></i>
													</a> <a href="leadExcelReport.action" data-toggle="tooltip"
														data-original-title="XLS Report" data-placement="bottom"
														class="btn btn-metis-6 btn-line"> <i
														class="fa fa-file-excel-o "></i>
													</a> <a href="login.html" data-toggle="tooltip"
														data-original-title="Setting" data-placement="bottom"
														class="btn btn-metis-1 btn-line"> <i
														class="fa fa-gear "></i>

													</a>
												</div>
											</div>
										</div>
									</div>
									<table id="dataTable"
										class="table table-bordered table-condensed table-hover table-striped">
										<thead>
											<tr id="myrow">
												<th><s:text name="task.dashboard.taskid"></s:text></th>
												<th><s:text name="add.new.task.subject"></s:text></th>
												<th><s:text name="add.new.task.area"></s:text></th>
												<th><s:text name="add.new.task.priority"></s:text></th>
												<th><s:text name="add.new.task.allocated"></s:text></th>
												<th><s:text name="task.dashboard.allocatedby"></s:text></th>
												<th><s:text name="add.new.task.duedate"></s:text></th>
												<th><s:text name="add.new.task.status"></s:text></th>
												<th style="width: 7px;"><s:text
														name="group.dashboard.table.action"></s:text></th>
											</tr>
										</thead>
										<tbody>
											<!-- viewTaskAllocationDetails -->

											<s:iterator value="taskAllocationDetailsGrid">
												<tr>
													<td><a
														href="viewTaskAllocationDetails.action?command=<s:property value="taskId" />"
														style="color: blue;"><s:property value="taskId" /></a></td>
													<td><s:property value="SubjectName" /></td>
													<td><s:property value="taskArea" /></td>
													<td><s:property value="taskPriorityName" /></td>
													<td><s:property value="taskAllocatedToName" /></td>
													<td><s:property value="taskAllocatedByName" /></td>
													<td><s:property value="dueDate" /></td>
													<td><s:property value="taskStatusName" /></td>
													<td align="center">
														<div class="btn-group">
															<a
																href="viewTaskAllocationDetails.action?command=<s:property value="taskId" />"
																data-toggle="tooltip" data-original-title="View"
																data-placement="bottom" class="btn btn-metis-5 btn-xs">
																<i class="fa fa-file-o"></i>
															</a>
														</div>
														<div class="btn-group">
															<a
																href="populateTaskAllocationDetails.action?command=<s:property value='taskId' />"
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
			Metis.metisSortable();
		});
	</script>
	<script src="assets/js/style-switcher.min.js"></script>


</body>
