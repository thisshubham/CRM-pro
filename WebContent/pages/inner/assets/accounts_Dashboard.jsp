<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="/struts-jquery-tags" prefix="sj"%>
<style>
#accountName,#accountOwner,#accountType,#mobileNo,#accountStatus {
	display: none;
}
</style>

<script type="text/javascript">
	function showElements() {

		var selectedIndex = document.getElementById('advanceSearch');

		var element1 = document.getElementById('accountId');
		var element2 = document.getElementById('accountName');
		var element3 = document.getElementById('accountOwner');
		var element4 = document.getElementById('accountType');
		var element5 = document.getElementById('mobileNo');
		var element6 = document.getElementById('accountStatus');

		if (selectedIndex.value == -1 || selectedIndex.value == 1) {
			element1.style.display = 'block';
			element2.style.display = 'none';
			element3.style.display = 'none';
			element4.style.display = 'none';
			element5.style.display = 'none';
			element6.style.display = 'none';
		} else if (selectedIndex.value == 2) {
			element1.style.display = 'none';
			element2.style.display = 'block';
			element3.style.display = 'none';
			element4.style.display = 'none';
			element5.style.display = 'none';
			element6.style.display = 'none';
		} else if (selectedIndex.value == 3) {
			element1.style.display = 'none';
			element2.style.display = 'none';
			element3.style.display = 'block';
			element4.style.display = 'none';
			element5.style.display = 'none';
			element6.style.display = 'none';
		} else if (selectedIndex.value == 4) {
			element1.style.display = 'none';
			element2.style.display = 'none';
			element3.style.display = 'none';
			element4.style.display = 'block';
			element5.style.display = 'none';
			element6.style.display = 'none';

		} else if (selectedIndex.value == 5) {
			element1.style.display = 'none';
			element2.style.display = 'none';
			element3.style.display = 'none';
			element4.style.display = 'none';
			element5.style.display = 'block';
			element6.style.display = 'none';

		} else if (selectedIndex.value == 6) {
			element1.style.display = 'none';
			element2.style.display = 'none';
			element3.style.display = 'none';
			element4.style.display = 'none';
			element5.style.display = 'none';
			element6.style.display = 'block';

		}
	}
</script>
<body>
	<div id="content">
		<div class="outer">
			<div class="inner bg-light lter">

				<!--Begin Datatables-->
				<div class="row">
					<div class="col-lg-12">
						<ol class="breadcrumb" style="margin-top: 10px;">
							<li><a href="omiInnerDashboard.action"><i
									class="fa fa-home"></i></a></li>
							<li class="active"><s:text name="Accounts"></s:text></li>
							<li class="active"><s:text name="Accounts Dashboard"></s:text></li>

						</ol>
						<div class="box">
							<header>
								<div class="pull-left">
									<a class="icons" href="dashboard.action" data-toggle="tooltip"
										data-original-title="Back To DashBoard"> <i
										class="fa fa-table"></i>
									</a>

									<h5 class="header_color">
										<s:text name="Accounts Dashboard"></s:text>
									</h5>
								</div>
								<div class="pull-right">

									<div class="btn-group">
										<a href="renderAddNewAccount.action" data-toggle="tooltip"
											data-original-title="New Account"
											class="btn btn-primary btnheight"><i
											class="fa fa-plus fontawesomeht ">&nbsp;<s:text
													name="New Account"></s:text></i></a>
										<button type="button" class="btn btn-info "
											data-toggle="collapse" data-target="#collapse1">
											<i class="fa fa-filter"></i> Filter
										</button>
										<a href="renderAcccountsDashboard.action"
											data-original-title="Refresh" type="button"
											class="btn btn-success btnheight"><i
											class="fa fa-refresh "></i></a> <a data-toggle="tooltip"
											data-original-title="XLS Report" href="accountExcelReport.action" type="button"
											class="btn btn-default btnheight"><i
											class="fa fa-file-excel-o fontawesomeht"></i></a> <a
											data-toggle="tooltip" data-original-title="Settings" href=""
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
													<s:text name="add.create.lead.information.bar" />
												</div>
											</div>
										</s:else>
									</p>
									<div id="collapse1" class="panel-collapse collapse">
										<div class="row searchBar">
											<s:form name="advanceSearchForm" method="POST"
												acton="populateLeadDetailsAsPerSearch">
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
														<s:select list="advanceSearchList" headerKey="-1"
															headerValue="Select Search Type"
															onchange="showElements();" id="advanceSearch"
															cssClass="form-control" name="searchId"></s:select>
														<div id='advanceSearchForm_searchId_errorloc'
															class="error_strings"></div>
													</div>
													<div class="col-lg-4  col-md-4  col-sm-12 col-xs-12">
														<div class="input-group">
															<s:textfield cssClass="form-control" id="accountId"
																name="accountId" placeholder="Enter Account ID" />

															<s:select list="parentAccountList" headerKey="-1"
																headerValue="Select Account Name"
																cssClass="form-control chzn-select" name="accountName"
																id="accountName"></s:select>

															<s:select list="accountOwnerList" headerKey="-1"
																id="accountOwner" headerValue="Select Account Owner"
																cssClass="form-control chzn-select" name="accountOwner"></s:select>

															<s:select list="accountTypeList"
																headerValue="Select Account Type" name="accountType"
																cssClass="form-control chzn-select" id="accountType"
																headerKey="-1" />

															<s:textfield cssClass="form-control" id="mobileNo"
																name="mobileNo" placeholder="Enter Mobile Number" />


															<s:select list="{'1'}" headerKey="-1" id="accountStatus"
																headerValue="Select Account Status"
																cssClass="form-control chzn-select "
																name="accountStatus"></s:select>

															<span class="input-group-btn">
																<button type="submit" data-toggle="tooltip"
																	onclick="validate();" data-original-title="Search"
																	class="btn btn-metis-5 btn-line">
																	<span class="glyphicon glyphicon-search"></span>&nbsp;Search
																</button>
															</span>
														</div>
														<div id='advanceSearchForm_accountId_errorloc'
															class="error_strings"></div>
														<div id='advanceSearchForm_accountName_errorloc'
															class="error_strings"></div>
														<div id='advanceSearchForm_accountOwner_errorloc'
															class="error_strings"></div>
														<div id='advanceSearchForm_accountType_errorloc'
															class="error_strings"></div>
														<div id='advanceSearchForm_mobileNo_errorloc'
															class="error_strings"></div>
														<div id='advanceSearchForm_status_errorloc'
															class="error_strings"></div>
													</div>
												</div>
											</s:form>
										</div>
									</div>
									<table id="dataTable"
										class="table table-bordered table-condensed table-hover table-striped">
										<thead>
											<tr id="myrow">
												<th style="width: 7%;"><s:text
														name="account.dashboard.table.action" /></th>
												<th><s:text name="account.dashboard.table.accountid" />
												</th>
												<th><s:text name="account.dashboard.table.accountname" /></th>
												<th><s:text name="account.dashboard.table.accountowner" /></th>
												<th><s:text name="account.dashboard.table.accounttype" /></th>
												<th><s:text name="account.dashboard.table.mobileno" /></th>
												<th><s:text name="account.dashboard.table.status" /></th>
											</tr>
										</thead>
										<tbody>
											<s:iterator value="accountDetailsList">
												<tr>
													<td align="center"><div class="btn-group">
															<a
																href="populateAccountDetails.action?command=
												<s:property value="accountId"/>"
																data-toggle="tooltip" data-original-title="View"
																data-placement="bottom"> <i class="fa fa-eye"></i>
															</a>
														</div>

														<div class="btn-group">
															<a
																href="populatAccountInformation.action?command=<s:property value="accountId"/>"
																data-toggle="tooltip" data-original-title="Edit"
																data-placement="bottom"> <i class="fa fa-edit"></i>
															</a>
														</div>


														<div class="btn-group">
															<a href="#" data-toggle="tooltip"
																data-original-title="Delete" data-placement="bottom">
																<i class="fa fa-trash-o"></i>
															</a>
														</div></td>
													<td><a
														href="populateAccountDetails.action?command=
												<s:property value="accountId"/>"
														style="color: blue;"><s:property value="accountId" /></a></td>
													<td><s:property value="accountName" /></td>
													<td><s:property value="accountOwner" /></td>
													<td><s:property value="accountType" /></td>
													<td><s:property value="mobileNo" /></td>
													<td><s:property value="accountStatus" /></td>
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

	<script src="/outer/js/gen_validatorv4.js" type="text/javascript"></script>
	<script type="text/javascript">
		function validate() {
			var frmvalidator = new Validator("advanceSearchForm");
			frmvalidator.EnableOnPageErrorDisplay();
			frmvalidator.EnableMsgsTogether();

			frmvalidator.addValidation("searchId", "dontselect=-1",
					"Select Search Type");
			var selectedIndex = document.getElementById('advanceSearch');

			if (selectedIndex.value == 1) {
				frmvalidator.addValidation("accountId", "req",
						"Enter Account Id");
			} else if (selectedIndex.value == 2) {
				frmvalidator.addValidation("accountName", "dontselect=-1",
						"Select Account Name");
			} else if (selectedIndex.value == 3) {
				frmvalidator.addValidation("accountOwner", "dontselect=-1",
						"Select Account Owner");
			} else if (selectedIndex.value == 4) {
				frmvalidator.addValidation("accountType", "dontselect=-1",
						"Select Account Type");
			} else if (selectedIndex.value == 5) {
				frmvalidator.addValidation("mobileNo", "dontselect=-1",
						"Select Mobile Number");
			} else if (selectedIndex.value == 6) {
				frmvalidator.addValidation("accountStatus", "req",
						"Select Account Status");
			}
		}
	</script>


</body>
