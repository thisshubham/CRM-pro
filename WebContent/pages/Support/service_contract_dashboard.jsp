<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<style>
#subject,#assignedTo,#dp3,#dp4,#priority,#status {
	display: none;
}
</style>

<script type="text/javascript">
	function showElements() {

		var selectedIndex = document.getElementById('advanceSearch');

		var element1 = document.getElementById('serviceContactId');
		var element2 = document.getElementById('subject');
		var element3 = document.getElementById('assignedTo');
		var element4 = document.getElementById('dp3');
		var element5 = document.getElementById('dp4');
		var element6 = document.getElementById('priority');
		var element7 = document.getElementById('status');

		if (selectedIndex.value == -1 || selectedIndex.value == 1) {
			element1.style.display = 'block';
			element2.style.display = 'none';
			element3.style.display = 'none';
			element4.style.display = 'none';
			element5.style.display = 'none';
			element6.style.display = 'none';
			element7.style.display = 'none';

		} else if (selectedIndex.value == 2) {
			element1.style.display = 'none';
			element2.style.display = 'block';
			element3.style.display = 'none';
			element4.style.display = 'none';
			element5.style.display = 'none';
			element6.style.display = 'none';
			element7.style.display = 'none';

		} else if (selectedIndex.value == 3) {
			element1.style.display = 'none';
			element2.style.display = 'none';
			element3.style.display = 'block';
			element4.style.display = 'none';
			element5.style.display = 'none';
			element6.style.display = 'none';
			element7.style.display = 'none';

		} else if (selectedIndex.value == 4) {
			element1.style.display = 'none';
			element2.style.display = 'none';
			element3.style.display = 'none';
			element4.style.display = 'block';
			element5.style.display = 'none';
			element6.style.display = 'none';
			element7.style.display = 'none';

		} else if (selectedIndex.value == 5) {
			element1.style.display = 'none';
			element2.style.display = 'none';
			element3.style.display = 'none';
			element4.style.display = 'none';
			element5.style.display = 'block';
			element6.style.display = 'none';
			element7.style.display = 'none';

		} else if (selectedIndex.value == 6) {
			element1.style.display = 'none';
			element2.style.display = 'none';
			element3.style.display = 'none';
			element4.style.display = 'none';
			element5.style.display = 'none';
			element6.style.display = 'block';
			element7.style.display = 'none';

		} else if (selectedIndex.value == 7) {
			element1.style.display = 'none';
			element2.style.display = 'none';
			element3.style.display = 'none';
			element4.style.display = 'none';
			element5.style.display = 'none';
			element6.style.display = 'none';
			element7.style.display = 'block';

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
							<li><a href="serviceContractDashboard"><s:text
										name="service.contract.dashboard.navbar"></s:text></a></li>
							<li><a href="serviceContractDashboard"><s:text
										name="service.contract.dashboard.panel.heading"></s:text></a></li>
						</ol>
						<div class="box">
							<header>
								<div class="pull-left">
									<a class="icons" href="dashboard.action" data-toggle="tooltip"
										data-original-title="Back To DashBoard"> <i
										class="fa fa-table"></i>
									</a>
									<h5 class="header_color">
										<s:text name="service.contract.dashboard.panel.heading"></s:text>
									</h5>
								</div>
								<div class="pull-right">
									<div class="btn-group">
										<a href="addNewServiceContract.action" data-toggle="tooltip"
											data-original-title="New Service Contract"
											class="btn btn-primary btnheight"><i
											class="fa fa-plus fontawesomeht ">&nbsp;<s:text
													name="add.service.contract.button"></s:text></i></a>
										<button type="button" class="btn btn-info "
											data-toggle="collapse" data-target="#collapse1">
											<i class="fa fa-filter"></i> Filter
										</button>
										<a class="btn btn-success btnheight" data-toggle="tooltip"
											data-original-title="Refresh"
											href="serviceContractDashboard.action"><i
											class="fa fa-refresh "></i></a> <a
											href="serviceExcelReport.action" type="button"
											data-toggle="tooltip" data-original-title="XLS Report"
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
									<p>
										<s:if test="hasActionErrors()">
											<div class="alert alert-danger" style="padding-bottom: 7px;"
												role="alert">
												<div class="infoIcon">
													<s:actionerror />
												</div>
											</div>
										</s:if>
										<s:elseif test="hasActionMessages()">
											<div class="alert alert-success" role="alert">
												<div class="infoIcon">
													<s:actionmessage />
												</div>
											</div>
										</s:elseif>
										<s:else>
											<div class="alert alert-info" role="alert">
												<div class="infoIcon">
													<i class="fa fa-info-circle "></i>
													<s:text name="service.contract.dashboard.infobar" />
												</div>
											</div>
										</s:else>
									</p>
									<div id="collapse1" class="panel-collapse collapse">
										<div class="row searchBar">
											<s:form name="advanceSearchForm" method="POST"
												acton="populateServiceAsPerSearch">
												<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"
													style="margin-top: 8px;">
													<div class="col-lg-1  col-md-1  col-sm-12 col-xs-12">
														<label>
															<h5>
																<s:text name="support_Faqs.search.by"></s:text>
															</h5>
														</label>
													</div>
													<div class="col-lg-4  col-md-4  col-sm-12 col-xs-12">
														<s:select list="advanceSearchList" headerKey="-1"
															onchange="showElements();" id="serviceAdvanceSearch"
															headerValue="Search By" cssClass="form-control"
															name="searchId"></s:select>
														<div id='advanceSearchForm_searchId_errorloc'
															class="error_strings"></div>
													</div>
													<div class="col-lg-4  col-md-4  col-sm-12 col-xs-12">
														<div class="input-group">
															<s:textfield cssClass="form-control"
																id="serviceContactId" name="serviceContactId"
																placeholder="Service Contact ID" />

															<s:textfield cssClass="form-control" id="subject"
																name="subject" placeholder="Enter Subject" />

															<s:select list="serviceAssignedToList" headerKey="-1"
																headerValue="Enter Assigned TO"
																cssClass="form-control chzn-select" name="assignedTo"
																id="assignedTo"></s:select>

															<s:textfield cssClass="form-control" id="dp3"
																placeholder="Enter Start Date" name="startDate" />

															<s:textfield cssClass="form-control" id="dp4"
																placeholder="Enter Due Date" name="dueDate" />

															<s:select list="servicePriorityList" headerKey="-1"
																headerValue="Select Priority" id="priority"
																cssClass="form-control chzn-select" name="priority"></s:select>

															<s:select list="serviceStatusList" headerKey="-1"
																headerValue="Select Status" id="status"
																cssClass="form-control chzn-select" name="status"></s:select>

															<span class="input-group-btn">
																<button type="submit" data-toggle="tooltip"
																	onclick="validate();" data-original-title="Search"
																	class="btn btn-metis-5 btn-line">
																	<span class="glyphicon glyphicon-search"></span>&nbsp;Search
																</button>
															</span>
														</div>
														<div id='advanceSearchForm_startDate_errorloc'
															class="error_strings"></div>
														<div id='advanceSearchForm_dueDate_errorloc'
															class="error_strings"></div>
														<div id='advanceSearchForm_subject_errorloc'
															class="error_strings"></div>
														<div id='advanceSearchForm_priority_errorloc'
															class="error_strings"></div>
														<div id='advanceSearchForm_status_errorloc'
															class="error_strings"></div>
														<div id='advanceSearchForm_assignedTo_errorloc'
															class="error_strings"></div>
														<div id='advanceSearchForm_serviceContactId_errorloc'
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
												<th style="width: 5%;"><s:text
														name="service.contract.dashboard.action"></s:text></th>
												<th style="width: 5%;"><s:text
														name="add.service.contract.id"></s:text></th>
												<th><s:text name="add.service.contract.subject"></s:text></th>
												<th><s:text name="add.service.contract.assigned.to"></s:text></th>
												<th><s:text name="add.service.contract.start.date"></s:text></th>
												<th><s:text name="add.service.contract.due.date"></s:text></th>
												<th><s:text name="add.service.contract.priority"></s:text></th>
												<th><s:text name="add.service.contract.status"></s:text></th>
											</tr>
										</thead>
										<tbody>
											<s:iterator value="serviceContactGridList">
												<tr>
													<td align="center">
														<div class="btn-group">
															<a id="view"
																href="viewServiceContract?command=<s:property value='serviceContactId'/>"
																data-toggle="tooltip" data-original-title="View"
																data-placement="bottom"> <i class="fa fa-eye"></i>
															</a>
														</div>
														<div class="btn-group">
															<a id="edit"
																href="editServiceContract.action?command=<s:property value='serviceContactId' />"
																data-toggle="tooltip" data-original-title="Edit"
																data-placement="bottom"> <i class="fa fa-edit"></i>
															</a>
														</div>
														<div class="btn-group">
															<a href="#"
																onclick="confirmDelete('deleteServiceContract.action?command='+<s:property value='serviceContactId'/>)"
																data-toggle="tooltip" data-original-title="Delete"
																data-placement="bottom" data-placement="bottom"> <i
																class="fa fa-trash-o"></i>
															</a>
														</div>
													</td>
													<td><a style="color: blue"
														href="viewServiceContract?command=<s:property value='serviceContactId' />"><s:property
																value='serviceContactId' /></a></td>
													<td><s:property value="subject" /></td>
													<td><s:property value="assignedTo" /></td>
													<td><s:property value="startDate" /></td>
													<td><s:property value="dueDate" /></td>
													<td><s:property value="priority" /></td>
													<td><s:property value="status" /></td>
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

	<script src="/outer/js/gen_validatorv4.js" type="text/javascript"></script>
	<script type="text/javascript">
		function validate() {
			var frmvalidator = new Validator("advanceSearchForm");
			frmvalidator.EnableOnPageErrorDisplay();
			frmvalidator.EnableMsgsTogether();

			frmvalidator.addValidation("Id", "dontselect=-1",
					"Select Search Type");
			var selectedIndex = document.getElementById('advanceSearch');

			if (selectedIndex.value == 1) {
				frmvalidator.addValidation("serviceContactId", "req",
						"Enter Service Id");
			} else if (selectedIndex.value == 2) {
				frmvalidator.addValidation("subject", "req", "Select subject");
			} else if (selectedIndex.value == 3) {
				frmvalidator.addValidation("assignedTo", "dontselect=-1",
						"Select Assigned To");
			} else if (selectedIndex.value == 4) {
				frmvalidator.addValidation("startDate", "req",
						"Select Start Date");
			} else if (selectedIndex.value == 5) {
				frmvalidator.addValidation("dueDate", "req", "Select Due date");
			} else if (selectedIndex.value == 6) {
				frmvalidator.addValidation("priority", "dontselect=-1",
						"Select Priority");
			} else if (selectedIndex.value == 7) {
				frmvalidator.addValidation("status", "dontselect=-1",
						"Select Status ");
			}
		}
	</script>
	<script src="assets/js/style-switcher.min.js"></script>

	<script type="text/javascript">
		function confirmDelete(url) {
			if (confirm("Are you sure you want to delete?")) {
				document.location = url;
			}

		}
		//Popup window code for Edit
		function confirmEdit(url) {
			popupWindow = window
					.open(
							url,
							'popUpWindow',
							'height=600,width=800,left=(screen.width/2)-(800/2),top=(screen.height/2)-(600/2),resizable=no,scrollbars=yes,addressbar=no,toolbar=no,menubar=no,location=0,directories=no,status=yes');

		}
	</script>


</body>