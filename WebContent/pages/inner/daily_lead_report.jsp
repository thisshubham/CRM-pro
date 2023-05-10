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
									<s:text name="Search By Lead Date" />
								</h5>

							</header>

							<div id="collapse4" class="body">
								<div class="alert alert-info" role="alert">
									<span class="fa fa-info" style="margin-right: 10px;"></span>Manage
									your personal details, contact, information, language,country
									and timezone.
								</div>
								<div class="table-responsive">
									<%-- <div id="dashboard_search_tools"
										style="padding-top: 10px; padding-bottom: 7px; background-color: #F9F9F9;">
										<div class="row">
											<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"
												style="margin-left: 5px;">
												<div class="row"
													style="margin-right: 30px; margin-left: 20px; margin-top: 12px">
													<div class="col-lg-1 col-md-1 col-sm-12 col-xs-12">
														<h5>
															<label> <s:text name="Lead Date :" />
															</label>
															<div class="star">*</div>
														</h5>
													</div>
													<s:form name="DailyLeadReportForm">
														<div class="col-lg-9  col-md-9 col-sm-12 col-xs-12">
															<div class="row">
																<div class="col-lg-3 col-md-3 col-sm-9 col-xs-7">
																	<s:textfield id="dp3" cssClass="form-control"
																		name="searchByLeadDate" placeholder="Select Lead Date"></s:textfield>
																	<div id='DailyLeadReportForm_searchByLeadDate_errorloc'
																		class="error_strings"></div>
																</div>
																<div class="col-lg-3 col-md-3 col-sm-3 col-xs-4">
																	<div class="btn-group">
																		<button data-toggle="tooltip"
																			data-original-title="Search" data-placement="bottom"
																			class="btn btn-success btn-md">
																			<i class="fa fa-search"></i>
																		</button>
																	</div>
																</div>
															</div>

														</div>
														</s:form>
														<div
															class="col-lg-1 col-lg-offset-1 col-md-1 col-md-offset-1 col-sm-12 col-xs-12"
															style="margin-top: 5px;">
															<div class="form-group">
																<button onclick="window.location.reload();"
																	data-toggle="tooltip" data-original-title="Refresh"
																	data-placement="bottom"
																	class="btn btn-metis-2 btn-line">
																	<i class="fa fa-refresh   "></i>
																</button>
																<a href="#" data-toggle="tooltip"
																	data-original-title="XLS Report"
																	data-placement="bottom"
																	class="btn btn-metis-6 btn-line"> <i
																	class="fa fa-file-excel-o "></i>

																</a>
															</div>
														</div>
													
												</div>
											</div>
										</div>
									</div> --%>
									<div class="row">
										<div class="col-lg-12  col-md-12  col-sm-12 col-xs-12"
											style="margin-bottom: -14px; margin-top: 16px;">
											<div class="col-lg-7  col-md-7  col-sm-12 col-xs-12"
												style="margin-top: -13px;">
												<a class="quick-icons" href="#" data-toggle="tooltip"
													data-placement="right"
													data-original-title="Back To DashBoard"> <i
													class="fa fa-files-o fa-2x"></i> <span>Copy</span> <span
													class="label label-default">2</span>
												</a> <a class="quick-icons" href="#" data-toggle="tooltip"
													data-placement="right"
													data-original-title="Back To DashBoard"> <i
													class="fa fa-clone fa-2x"></i> <span>Clone</span> <span
													class="label label-default">2</span>
												</a> <a class="quick-icons" href="#"> <i
													class="fa fa-exchange fa-2x"></i> <span>Convert</span> <span
													class="label label-default">2</span>
												</a> <a class="quick-icons" href="#"> <i
													class="fa fa-clipboard fa-2x"></i> <span>Paste</span> <span
													class="label label-default">2</span>
												</a> <a class="quick-icons" href="#"> <i
													class="fa fa fa-envelope fa-2x"></i> <span>Alerts</span> <span
													class="label label-default">2</span>
												</a> <a class="quick-icons" href="#"> <i
													class="fa fa fa-comment fa-2x"></i> <span>Alerts</span> <span
													class="label label-default">2</span>
												</a>


											</div>
											<div class="row">
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
									<br>
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
	<script src="/outer/js/gen_validatorv4.js" type="text/javascript"></script>
	<script type="text/javascript">
		var frmvalidator = new Validator("DailyLeadReportForm");
		frmvalidator.EnableOnPageErrorDisplay();
		frmvalidator.EnableMsgsTogether();

		frmvalidator.addValidation("searchByLeadDate", "req",
				"Select Lead Date");
	</script>
</body>