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

								<a class="icons" href="groupReports" data-toggle="tooltip"
									data-original-title="Back To DashBoard" style="color: black;">
									<i class="fa fa-th-large"></i>
								</a>


								<h5>
									<s:text name="Search By Group Date" />
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
													<div class="col-lg-1 col-md-1 col-sm-12 col-xs-12">
														<h5>
															<label> <s:text name="Group Date :" />
															</label>
														</h5>
													</div>

													<div class="col-lg-9  col-md-9 col-sm-12 col-xs-12">
														<div class="row">
															<div class="col-lg-3 col-md-3 col-sm-9 col-xs-7">
																<input type="text" name="leadDate" value=""
																	tabindex="14" id="dp3" class="form-control">
															</div>
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
													<td><s:property value="groupAdminFullName" /></td>
													<td><s:property value="createdDate" /></td>
													<td><s:property value="groupStatusName" /></td>
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

			Metis.formGeneral();
			Metis.formWysiwyg();
		});
	</script>
	<script src="assets/js/style-switcher.min.js"></script>
</body>
