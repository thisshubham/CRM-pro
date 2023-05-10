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
									<s:text name="Search By Lead Follow Up" />
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
													<s:form name="LeadFollowUpReportForm">
														<div class="col-lg-10  col-md-10 col-sm-12 col-xs-12">
															<div class="row">
																<div class="col-lg-1 col-md-1 col-sm-12 col-xs-12">
																	<h5>
																		<label> <s:text name="Lead Id:" />
																		</label>
																		<div class="star">*</div>
																	</h5>
																</div>
																<div class="col-lg-3 col-md-3 col-sm-9 col-xs-7">
																	<s:select list="leadIdList"
																		headerValue="Select Lead Id" headerKey="-1"
																		name="searchByLeadId" cssClass="form-control">
																	</s:select>
																	<div
																		id='LeadFollowUpReportForm_searchByLeadId_errorloc'
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
										class="table table-bordered table-condensed table-hover table-striped"
										ddd>
										<thead>
											<tr id="myrow">
												<th><s:text name="update.Lead.Followup.followup.id" /></th>
												<th><s:text name="update.Lead.Followup.followup.date" /></th>
												<th><s:text name="update.Lead.Followup.followup.status" /></th>
												<th><s:text name="update.Lead.Followup.followup.by" /></th>
												<th><s:text name="update.group.createdby" /></th>
												<th style=""><s:text
														name="update.Lead.Followup.comment" /></th>

											</tr>
										</thead>
										<tbody>
											<s:iterator value="leadFollowupReportsGrid">
												<tr>

													<td><s:property value="followUpId" /></td>
													<td><s:property value="followUpDate" /></td>
													<td><s:property value="followUpStatus" /></td>
													<td><s:property value="followUpBy" /></td>
													<td><s:property value="createdByName" /></td>
													<td><s:property value="followUpComment" /></td>

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
		var frmvalidator = new Validator("LeadFollowUpReportForm");
		frmvalidator.EnableOnPageErrorDisplay();
		frmvalidator.EnableMsgsTogether();

		frmvalidator.addValidation("searchByLeadId", "dontselect=-1",
				"Select Lead Id");
	</script>
</body>
