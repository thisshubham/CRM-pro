<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%-- <%@taglib uri="/struts-jquery-tags" prefix="sj"%> --%>

<style>
#companyName,#leadTitle,#contactPerson,#leadOwner,#dp3,#dp4,#leadStatus
	{
	display: none;
}
</style>

<%-- <script type="text/javascript">
	function showElements() {

		var selectedIndex = document.getElementById('advanceSearch');

		var element1 = document.getElementById('leadId');
		var element2 = document.getElementById('companyName');
		var element3 = document.getElementById('leadTitle');
		var element4 = document.getElementById('contactPerson');
		var element5 = document.getElementById('leadOwner');
		var element6 = document.getElementById('dp3');
		var element7 = document.getElementById('dp4');
		var element8 = document.getElementById('leadStatus');

		if (selectedIndex.value == -1 || selectedIndex.value == 1) {
			element1.style.display = 'block';
			element2.style.display = 'none';
			element3.style.display = 'none';
			element4.style.display = 'none';
			element5.style.display = 'none';
			element6.style.display = 'none';
			element7.style.display = 'none';
			element8.style.display = 'none';

		} else if (selectedIndex.value == 2) {
			element1.style.display = 'none';
			element2.style.display = 'block';
			element3.style.display = 'none';
			element4.style.display = 'none';
			element5.style.display = 'none';
			element6.style.display = 'none';
			element7.style.display = 'none';
			element8.style.display = 'none';

		} else if (selectedIndex.value == 3) {
			element1.style.display = 'none';
			element2.style.display = 'none';
			element3.style.display = 'block';
			element4.style.display = 'none';
			element5.style.display = 'none';
			element6.style.display = 'none';
			element7.style.display = 'none';
			element8.style.display = 'none';

		} else if (selectedIndex.value == 4) {
			element1.style.display = 'none';
			element2.style.display = 'none';
			element3.style.display = 'none';
			element4.style.display = 'block';
			element5.style.display = 'none';
			element6.style.display = 'none';
			element7.style.display = 'none';
			element8.style.display = 'none';

		} else if (selectedIndex.value == 5) {
			element1.style.display = 'none';
			element2.style.display = 'none';
			element3.style.display = 'none';
			element4.style.display = 'none';
			element5.style.display = 'block';
			element6.style.display = 'none';
			element7.style.display = 'none';
			element8.style.display = 'none';

		} else if (selectedIndex.value == 6) {
			element1.style.display = 'none';
			element2.style.display = 'none';
			element3.style.display = 'none';
			element4.style.display = 'none';
			element5.style.display = 'none';
			element6.style.display = 'block';
			element7.style.display = 'none';
			element8.style.display = 'none';

		} else if (selectedIndex.value == 7) {
			element1.style.display = 'none';
			element2.style.display = 'none';
			element3.style.display = 'none';
			element4.style.display = 'none';
			element5.style.display = 'none';
			element6.style.display = 'none';
			element7.style.display = 'block';
			element8.style.display = 'none';

		} else if (selectedIndex.value == 8) {
			element1.style.display = 'none';
			element2.style.display = 'none';
			element3.style.display = 'none';
			element4.style.display = 'none';
			element5.style.display = 'none';
			element6.style.display = 'none';
			element7.style.display = 'none';
			element8.style.display = 'block';

		}

	}
</script>
 --%>
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
							<li><s:text name="event.dashboard.event"></s:text></li>
							<li class="active"><s:text
									name="event.dashboard.event.dashboard"></s:text></li>
						</ol>
						<div class="box">
							<header>
								<div class="pull-left">
									<a class="icons" href="dashboard.action" data-toggle="tooltip"
										data-original-title="Back To DashBoard"> <i
										class="fa fa-table"></i>
									</a>

									<h5 class="header_color">
										<s:text name="event.dashboard.event.dashboard"></s:text>
									</h5>
								</div>
								<div class="pull-right">
									<div class="btn-group">
										<a href="addCreatedEvent.action" data-toggle="tooltip"
											data-original-title="New Event"
											class="btn btn-primary btnheight"><i
											class="fa fa-plus fontawesomeht ">&nbsp;<s:text
													name="event.dashboard.new.event"></s:text></i></a>
										<button type="button" class="btn btn-info "
											data-toggle="collapse" data-target="#collapse1">
											<i class="fa fa-filter"></i> Filter
										</button>
										<a class="btn btn-success btnheight" data-toggle="tooltip"
											data-original-title="Refresh" href="eventDashboard.action"><i
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
													<s:text name="event.dashboard.add.new.event.hare" />
												</div>
											</div>
										</s:else>
									</p>
									<div id="collapse1" class="panel-collapse collapse">
										<div class="row searchBar">
											<s:form name="eventDashboardSearchForm" method="POST"
												acton="populateLeadDetailsAsPerSearch">
												<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"
													style="margin-top: 8px;">

													<div class="col-lg-1  col-md-1  col-sm-12 col-xs-12">
														<label>
															<h5>
																<s:text name="event.dashboard.searchby"></s:text>
															</h5>
														</label>
													</div>
													<div class="col-lg-4  col-md-4  col-sm-12 col-xs-12">
														<s:select list="{'a','b'}" headerKey="-1"
															onchange="showElements();" id="advanceSearch"
															headerValue="Select Search Type" cssClass="form-control"
															name="searchId"></s:select>
														<div id='advanceSearchForm_searchId_errorloc'
															class="error_strings"></div>
													</div>
													<div class="col-lg-4  col-md-4  col-sm-12 col-xs-12">
														<div class="input-group">
															<s:textfield cssClass="form-control" id="leadId"
																name="leadId" placeholder="Lead ID" />




															<%-- <s:select list="{'a','b'}" headerKey="-1"
																id="contactPerson" headerValue="Select Contact Person"
																cssClass="form-control chzn-select" name="contactPerson"></s:select>

															<s:select list="{'a','b'}" headerKey="-1" id="leadOwner"
																headerValue="Select Lead Owner"
																cssClass="form-control chzn-select " name="leadOwner"></s:select>

															<s:textfield cssClass="form-control" id="dp3"
																placeholder="Select Lead Date" name="leadDate" />

															<s:textfield cssClass="form-control" id="dp4"
																placeholder="Select Closing Date"
																name="expectedClosingDate" />


															<s:select list="{'a','b'}" headerKey="-1"
																headerValue="Select Lead Status" id="leadStatus"
																cssClass="form-control chzn-select" name="leadStatus"></s:select>

															<span class="input-group-btn">
																<button type="submit" data-toggle="tooltip"
																	onclick="validate();" data-original-title="Search"
																	class="btn btn-metis-5 btn-line">
																	<span class="glyphicon glyphicon-search"></span>&nbsp;Search
																</button>
															</span> --%>
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
														<div id='advanceSearchForm_expectedClosingDate_errorloc'
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
														name="event.dashboard.action"></s:text></th>
												<th><s:text name="event.dashboard.lead.id"></s:text></th>
												<th><s:text name="event.dashboard.company"></s:text></th>
												<th><s:text name="event.dashboard.title"></s:text></th>
												<th><s:text name="event.dashboard.lead.owner"></s:text></th>
												<th><s:text name="event.dashboard.created.date"></s:text></th>
												<th><s:text name="event.dashboard.expected.closing.date"></s:text></th>


											</tr>
										</thead>
										<tbody>
											<s:iterator value="eventGridList">
												<tr>
													<td align="center">
														<div class="btn-group">
															<a id="view"
																href="viewEventDetails.action?command=<s:property value='eventId' />"
																data-toggle="tooltip" data-original-title="View"
																data-placement="bottom"> <i class="fa fa-eye"></i>
															</a>
														</div>
														<div class="btn-group">
															<a id="edit"
																href="editEventDetail.action?command=<s:property value='eventId' />"
																data-toggle="tooltip" data-original-title="Edit"
																data-placement="bottom"> <i class="fa fa-edit"></i>
															</a>
														</div>
														<div class="btn-group">
															<a id="delete" href="#"
																onclick="confirmDelete('deleteProductDetail.action?command='+<s:property value='productId'/>)"
																data-toggle="tooltip" data-original-title="Delete"
																data-placement="bottom"> <i class="fa fa-trash-o"></i>
															</a>
														</div>
													</td>

													<td><a style="color: blue"
														href="viewEventDetails?command=<s:property value='eventId' />"><s:property
																value='eventId' /></a></td>
													<td><s:property value="eventTitle" /></td>
													<td><s:property value="eventCategory" /></td>
													<td><s:property value="organizeName" /></td>
													<td><s:property value="eventStatus" /></td>
													<td><s:property value="publishDate" /></td>

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
			var frmvalidator = new Validator("eventDashboardSearchForm");
			frmvalidator.EnableOnPageErrorDisplay();
			frmvalidator.EnableMsgsTogether();

			/* frmvalidator.addValidation("searchId", "dontselect=-1",
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
			} */
		}
		
		function confirmDelete(url) {
			if (confirm("Are you sure you want to delete?")) {
				document.location = url;
			}

		}
	
	</script>
</body>
