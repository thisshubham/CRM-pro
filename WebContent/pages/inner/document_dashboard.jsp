<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="/struts-jquery-tags" prefix="sj"%>
<body>

	<div id="content">
		<div class="outer">
			<div class="inner bg-light lter">

				<!--Begin Datatables-->
				<div class="row">
					<div class="col-lg-12">
						<ol class="breadcrumb" style="margin-top: 10px;">
							<li><a href="omiInnerDashboard.action"><i
									class="fa fa-home"></i> </a></li>
							<li class="active"><s:text name="Document"></s:text></li>
							<li class="active"><s:text name="Document Dashboard"></s:text></li>
						</ol>
						<div class="box">
							<!-- <header>
								<a class="icons" href="dashboard.action" data-toggle="tooltip"
									data-original-title="Back To DashBoard"> <i
									class="fa fa-table"></i>
								</a>
								<h5>Document Dashboard</h5>

							</header> -->
							<header>
								<div class="pull-left">
									<a class="icons" href="dashboard.action" data-toggle="tooltip"
										data-original-title="Back To Document DashBoard"> <i
										class="fa fa-table"></i>
									</a>

									<h5 class="header_color">
										<s:text name="Document Dashboard"></s:text>
									</h5>
								</div>
								<div class="pull-right">

									<div class="btn-group">

										<a href="addNewDocument.action" class="btn btn-primary btnheight"><i
											class="fa fa-plus fontawesomeht ">&nbsp;<s:text
													name="New Document"></s:text></i></a>
										<button type="button" class="btn btn-info "
											data-toggle="collapse" data-target="#collapse1">
											<i class="fa fa-filter"></i>Filter
										</button>
										<button type="button" class="btn btn-success btnheight"
											onclick="window.location.reload();">
											<i class="fa fa-refresh "></i>
										</button>
										<a href="#" type="button" class="btn btn-default btnheight"><i
											class="fa fa-file-excel-o fontawesomeht"></i></a> <a href=""
											type="button" class="btn btn-warning btnheight"><i
											class="fa fa-gear fontawesomeht "></i></a> <a href=""
											class="btn btn-danger btnheight"><i
											class="fa fa-times fontawesomeht"></i></a>
									</div>

								</div>
							</header>
							<div id="collapse4" class="body">
								<div class="table-responsive">
									<p>
										<s:if test="hasActionErrors()">
											<div class="alert alert-danger" role="alert"
												style="margin-top: 25px; padding-bottom: 7px;">
												<div class="infoIcon">
													<i class="fa fa-times-circle "></i>
													<s:actionerror />
												</div>
											</div>
										</s:if>
										<s:elseif test="hasActionMessages()">
											<div class="alert alert-success" role="alert"
												style="margin-top: 25px; padding-bottom: 7px;">
												<div class="infoIcon">
													<!-- <i class="fa fa-check-circle "></i> -->
													<s:actionmessage />
												</div>
											</div>
										</s:elseif>
										<s:else>

											<div class="alert alert-info" role="alert"
												style="margin-top: 25px;">
												<div class="infoIcon">
													<i class="fa fa-info-circle "></i>
													<s:text name="you can add new Document here" />
												</div>
											</div>
										</s:else>
									</p>
									<div id="collapse1" class="panel-collapse collapse">
										<div class="row searchBar">
											<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"
												style="margin-top: 8px;">

												<div class="col-lg-1  col-md-1  col-sm-12 col-xs-12">
													<label>
														<h5>
															<s:text name="lead.dashboard.searchby"></s:text>
														</h5>
													</label>
												</div>
												<div class="col-lg-4  col-md-4  col-sm-12 col-xs-12">
													<select class="form-control">
														<option>1</option>
														<option>2</option>
														<option>3</option>
														<option>4</option>
														<option>5</option>
													</select>
												</div>
												<div class="col-lg-4  col-md-4  col-sm-12 col-xs-12">
													<div class="input-group">
														<input class="form-control" type="text"><span
															class="input-group-btn"> <a
															class="btn btn-metis-5 btn-line" type="button"
															href="groupDashboard.action"> <span
																class="glyphicon glyphicon-search"></span>&nbsp;Search
														</a>
														</span>
													</div>
												</div>
											</div>
										</div>
									</div>
									<table id="dataTable"
										class="table table-bordered table-condensed table-hover table-striped">
										<thead>
											<tr id="myrow">
												<th><s:text name="contact.dashboard.contactid"></s:text>
												</th>
												<th><s:text name="group.dashboard.table.groupname"></s:text></th>
												<th><s:text name="contact.dashboard.contactperson"></s:text>
												</th>
												<th><s:text name="add.client.Designation"></s:text></th>
												<th><s:text name="add.client.email.id"></s:text></th>
												<th><s:text name="add.client.mobile.number"></s:text></th>
												<th><s:text name="contact.dashboard.contactwork"></s:text>
												</th>
												<th style="width: 7%;"><s:text
														name="client.grid.action"></s:text></th>
											</tr>
										</thead>
										<tbody>
											<s:iterator value="contactsDetailList">
												<tr>
													<td><a
														href="viewContactInformation.action?command=<s:property value="contactId"/>"
														style="color: blue;"><s:property value="contactId" /></a></td>
													<td><s:property value="groupName" /></td>
													<td><s:property value="contactperson" /></td>
													<td><s:property value="designation" /></td>
													<td><s:property value="emailId" /></td>

													<td><s:property value="mobileNo" /></td>
													<td><s:property value="workContactMobile" /></td>

													<td align="center"><div class="btn-group">
															<a
																href="viewContactInformation.action?command=<s:property value="contactId"/>"
																data-toggle="tooltip" data-original-title="View"
																data-placement="bottom" class="btn btn-metis-5 btn-xs">
																<i class="fa fa-file-o"></i>
															</a>
														</div>

														<div class="btn-group">
															<a
																href="populateGroupsContact.action?command=<s:property value="contactId"/>"
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
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- /.inner -->
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
