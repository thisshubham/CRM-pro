<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%-- <%@taglib uri="/struts-jquery-tags" prefix="sj"%> --%>

<style>
#assignmentId,#assignedTo,#dp3,#status
	{
	display: none;
}
</style>

<script type="text/javascript">
	function showElements() {

		var selectedIndex = document.getElementById('advanceSearch');

		var element1 = document.getElementById('assignmentId');
		var element2 = document.getElementById('assignedTo');
		var element3 = document.getElementById('dp3');
		var element4 = document.getElementById('status');
		
		
		if (selectedIndex.value == -1 || selectedIndex.value == 1) {
			element1.style.display = 'block';
			element2.style.display = 'none';
			element3.style.display = 'none';
			element4.style.display = 'none';
			

		} else if (selectedIndex.value == 2) {
			element1.style.display = 'none';
			element2.style.display = 'block';
			element3.style.display = 'none';
			element4.style.display = 'none';
			

		} else if (selectedIndex.value == 3) {
			element1.style.display = 'none';
			element2.style.display = 'none';
			element3.style.display = 'block';
			element4.style.display = 'none';

		}else if (selectedIndex.value == 4) {
			element1.style.display = 'none';
			element2.style.display = 'none';
			element3.style.display = 'none';
			element4.style.display = 'block';

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
							<li class="active"><s:text
									name="assignment.dashboard.assignments"></s:text></li>
							<li class="active"><s:text
									name="assignment.dashboard.assignments.dashboard"></s:text></li>
						</ol>
						<div class="box">
							<header>
								<div class="pull-left">
									<a class="icons" href="dashboard.action" data-toggle="tooltip"
										data-original-title="Back To DashBoard"> <i
										class="fa fa-table"></i>
									</a>

									<h5 class="header_color">
										<s:text name="assignment.dashboard.assignments.dashboard"></s:text>
									</h5>
								</div>
								<div class="pull-right">
									<div class="btn-group">
										<a href="addNewAssignment.action" data-toggle="tooltip"
											data-original-title="New Assignment"
											class="btn btn-primary btnheight"><i
											class="fa fa-plus fontawesomeht ">&nbsp;<s:text
													name="assignment.dashboard.new.assignment"></s:text></i></a>
										<button type="button" class="btn btn-info "
											data-toggle="collapse" data-target="#collapse1">
											<i class="fa fa-filter"></i> Filter
										</button>
										<a class="btn btn-success btnheight" data-toggle="tooltip"
											data-original-title="Refresh" href="leadDashboard.action"><i
											class="fa fa-refresh "></i></a> <a href="assignmentExcelReport.action"
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
													<s:text name="assignment.dashboard.infobar" />
												</div>
											</div>
										</s:else>
									</p>
									<div id="collapse1" class="panel-collapse collapse">
										<div class="row searchBar">
											<s:form name="advanceSearchForm" method="POST"
												action="populateAssignmentDetailsAsPerSearch">
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
															onchange="showElements();" id="advanceSearch"
															headerValue="Select Search Type" cssClass="form-control"
															name="searchId"></s:select>
														<div id='advanceSearchForm_searchId_errorloc'
															class="error_strings"></div>
													</div>
													<div class="col-lg-4  col-md-4  col-sm-12 col-xs-12">
														<div class="input-group">
															<s:textfield cssClass="form-control" id="assignmentId"
																name="assignmentId" placeholder="Select Assignment Id" />

															<s:select list="customerUserList" headerKey="-1"
																headerValue="Select Assigned To"
																cssClass="form-control chzn-select" name="assignedTo"
																id="assignedTo"></s:select>
																
																<s:textfield type="text" name="expectedClosingDate"
														cssClass="form-control" id="dp3" tabindex="15" />

															
															<s:select list="assignmentStatusList" headerKey="-1"
																headerValue="Select Status"
																cssClass="form-control chzn-select" name="assignmentStatus"
																id="status"></s:select>

															
															
															


															

															<span class="input-group-btn">
																<button type="submit" data-toggle="tooltip"
																	onclick="validate();" data-original-title="Search"
																	class="btn btn-metis-5 btn-line">
																	<span class="glyphicon glyphicon-search"></span>&nbsp;Search
																</button>
															</span>
														</div>
														<!-- <div id='advanceSearchForm_leadDate_errorloc'
															class="error_strings"></div>
														<div id='advanceSearchForm_leadId_errorloc'
															class="error_strings"></div>
														<div id='advanceSearchForm_companyName_errorloc'
															class="error_strings"></div>
														<div id='advanceSearchForm_leadTitle_errorloc'
															class="error_strings"></div>
														<div id='advanceSearchForm_contactPerson_errorloc'
															class="error_strings"></div>
														<div id='advanceSearchForm_leadOwner_errorloc'
															class="error_strings"></div>
														<div id='advanceSearchForm_leadDate_errorloc'
															class="error_strings"></div>
														
														<div id='advanceSearchForm_leadleadStatus_errorloc'
															class="error_strings"></div> -->
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
														name="assignment.dashboard.action"></s:text></th>
												<th><s:text name="assignment.dashboard.assignment.id"></s:text></th>
												<th><s:text name="assignment.dashboard.assigned.to"></s:text></th>
												<th><s:text
														name="assignment.dashboard.expected.closing"></s:text></th>
												<th><s:text name="assignment.dashboard.status"></s:text></th>
												</tr>
										</thead>
										<tbody>
											<s:iterator value="assignmentList">
												<tr>
													<td align="center">
														<div class="btn-group">
															<a id="view"
																href="viewAssignmentDetails?command=<s:property value='AssignmentId'/>"
																data-toggle="tooltip" data-original-title="View"
																data-placement="bottom"> <i class="fa fa-eye"></i>
															</a>
														</div>
														<div class="btn-group">
															<a id="edit"
																href="editAssignment.action?command=<s:property value='AssignmentId' />"
																data-toggle="tooltip" data-original-title="Edit"
																data-placement="bottom"> <i class="fa fa-edit"></i>
															</a>
														</div>
														<div class="btn-group">
															<a id="delete" href="#" data-toggle="tooltip"
																data-original-title="Delete" data-placement="bottom">
																<i class="fa fa-trash-o"></i>
															</a>
														</div>
													</td>
													<%-- <td><a style="color: blue"
														href="viewAssignment?command=<s:property value='leadId' />"><s:property
																value='leadId' /></a></td> --%>
													<td><s:property value="assignmentId" /></td>
													<td><s:property value="assignedTo" /></td>
													<td><s:property value="expectedClosingDate" /></td>
													<td><s:property value="assignmentStatus" /></td>
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

			frmvalidator.addValidation("searchId", "dontselect=-1",
					"Select Search Type");
			var selectedIndex = document.getElementById('advanceSearch');

			if (selectedIndex.value == 1) {
				frmvalidator.addValidation("leadId", "req", "Enter Lead Id");
			} else if (selectedIndex.value == 2) {
				frmvalidator.addValidation("companyName", "dontselect=-1",
						"Select Company Name");
			} else if (selectedIndex.value == 3) {
				frmvalidator.addValidation("leadTitle", "dontselect=-1",
						"Select Lead Title");
			} else if (selectedIndex.value == 4) {
				frmvalidator.addValidation("contactPerson", "dontselect=-1",
						"Select Contact Person");
			} else if (selectedIndex.value == 5) {
				frmvalidator.addValidation("leadOwner", "dontselect=-1",
						"Select Lead Owner");
			} else if (selectedIndex.value == 6) {
				frmvalidator.addValidation("leadDate", "req",
						"Select Lead Date");
			} else if (selectedIndex.value == 7) {
				frmvalidator.addValidation("expectedClosingDate", "req",
						"Select Expected Closing Date");
			} else if (selectedIndex.value == 8) {
				frmvalidator.addValidation("leadStatus", "dontselect=-1",
						"Select Lead Status");
			}
		}
	</script>
</body>
