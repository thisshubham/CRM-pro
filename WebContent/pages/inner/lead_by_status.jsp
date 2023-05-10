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
									<div id="dashboard_search_tools"
										style="padding-top: 10px; padding-bottom: 7px; background-color: #F9F9F9;">
										<div class="row">
											<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"
												style="margin-left: 5px;">
												<div class="row" style="margin-right: 27px;">
													<div class="col-lg-1 col-md-1 col-sm-12 col-xs-12">
														<h5>
															<label> <s:text name="Lead Status :" />
															</label>
															<div class="star">*</div>
														</h5>
													</div>
													<s:form name="LeadReportByStatusForm">
														<div class="col-lg-9  col-md-9 col-sm-12 col-xs-12">
															<div class="row">
																<div class="col-lg-3 col-md-3 col-sm-9 col-xs-7">
																	<s:select list="leadStatusList" headerKey="-1"
																		headerValue="Select Lead Status" name="leadStatus"
																		cssClass="form-control"></s:select>
																	<div id='LeadReportByStatusForm_leadStatus_errorloc'
																		class="error_strings"></div>
																</div>
																<div class="col-lg-1 col-md-3 col-sm-9 col-xs-7">
																	<h5>
																		<label> <s:text name="Start Date :" />
																		</label>
																		<div class="star">*</div>
																	</h5>
																</div>
																<div class="col-lg-2 col-md-3 col-sm-9 col-xs-7">
																	<s:textfield name="leadStartDate"
																		placeholder="Select Start Date" id="dp1"
																		cssClass="form-control" />
																	<div id='LeadReportByStatusForm_leadStartDate_errorloc'
																		class="error_strings"></div>
																</div>
																<div class="col-lg-1 col-md-3 col-sm-9 col-xs-7">
																	<h5>
																		<label> <s:text name="End Date :" />
																		</label>
																		<div class="star">*</div>
																	</h5>

																</div>
																<div class="col-lg-2 col-md-3 col-sm-9 col-xs-7">
																	<s:textfield name="leadEndDate"
																		placeholder="Select End Date" id="dp2"
																		cssClass="form-control" />

																	<div id='LeadReportByStatusForm_leadEndDate_errorloc'
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
		var frmvalidator = new Validator("LeadReportByStatusForm");
		frmvalidator.EnableOnPageErrorDisplay();
		frmvalidator.EnableMsgsTogether();

		
		frmvalidator.addValidation("leadStatus", "dontselect=-1",
		"Select Lead Status");
		
		frmvalidator.addValidation("leadStartDate", "req",
				"Select Lead Start Date");

		frmvalidator
				.addValidation("leadEndDate", "req", "Select Lead End Date");

		//lead date and expected closing date difference validation 
		function DoCustomValidation() {
			var frm1 = document.forms["LeadReportByStatusForm"];
			var ndate = frm1.leadStartDate.value;
			var ndate1 = frm1.leadEndDate.value;
			var d1 = new Date(ndate); //from date yyyy-MM-dd
			var d2 = new Date(ndate1); //to date yyyy-MM-dd 
			var Months = d2.getMonth() - d1.getMonth();
			var Years = d2.getFullYear() - d1.getFullYear();
			var Days = d2.getDate() - d1.getDate();
			Months = (d2.getMonth() + 12 * d2.getFullYear())
					- (d1.getMonth() + 12 * d1.getFullYear());

			var MonthOverflow = 0;

			if (Months - (Years * 12) < 0)
				MonthOverFlow = -1;
			else
				MonthOverFlow = 1;
			if (MonthOverFlow < 0)
				Years = Years - 1;
			Months = Months - (Years * 12);
			var LastDayOfMonth = new Date(d2.getFullYear(), d2.getMonth() + 1,
					0, 23, 59, 59);
			LastDayOfMonth = LastDayOfMonth.getDate();
			if (MonthOverFlow < 0 && (d1.getDate() > d2.getDate())) {
				Days = LastDayOfMonth + (d2.getDate() - d1.getDate()) - 1;
			} else
				Days = d2.getDate() - d1.getDate();
			if (Days < 0)
				Months = Months - 1;
			var l = new Date(d2.getFullYear(), d2.getMonth(), 0);
			var l1 = new Date(d1.getFullYear(), d1.getMonth() + 1, 0);
			if (Days < 0) {
				if (l1 > l)
					Days = l1.getDate() + Days;
				else
					Days = l.getDate() + Days;
			}
			if (d1 <= d2) {
				return true;
			} else {

				sfm_show_error_msg(
						"End Date Should be Greater Than Start Date",
						frm1.leadEndDate);
				return false;
			}
		}

		frmvalidator.setAddnlValidationFunction(DoCustomValidation);
	</script>

</body>
