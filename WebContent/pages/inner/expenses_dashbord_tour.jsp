<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<style>
#companyName,#leadTitle,#contactPerson,#leadOwner,#dp3,#dp4,#leadStatus
	{
	display: none;
}
</style>

<script type="text/javascript">
	function showElements() {

		var selectedIndex = document.getElementById('advanceSearch');
		
		var element1 = document.getElementById('Claim Id');
		var element2 = document.getElementById('Name');
		var element3 = document.getElementById('leadTitle');
		var element4 = document.getElementById('dp3');
		var element5 = document.getElementById('dp4');
		var element6 = document.getElementById('ClaimStatus');

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
			element7.style.display = 'none';
			element8.style.display = 'none';

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
							<li><a href="#">Home</a></li>
							<li><a href="#">Expenses</a></li>
							<li class="active">Tour</li>
						</ol>
						<div class="box">
							<header>
								<div class="pull-left">
									<a class="icons" href="omiInnerDashboard.action" data-toggle="tooltip"
										data-original-title="Back To DashBoard"> <i
										class="fa fa-table"></i>
									</a>

									<h5 class="header_color">
										<s:text name="Tour Expenses DashBoard"></s:text>
									</h5>
								</div>
								<div class="pull-right">
									<div class="btn-group">
										<a href="expensesTravelBill.action" data-toggle="tooltip"
											data-original-title="New Expenses"
											class="btn btn-primary btnheight"><i
											class="fa fa-plus fontawesomeht ">&nbsp;<s:text
													name="New Expenses"></s:text></i></a>
										<button type="button" class="btn btn-info "
											data-toggle="collapse" data-target="#collapse1">
											<i class="fa fa-filter"></i> Filter
										</button>
										<a class="btn btn-success btnheight" data-toggle="tooltip"
											data-original-title="Refresh" href="leadDashboard.action"><i
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

										<div class="row">
											<div class="col-lg-12  col-md-12  col-sm-12 col-xs-12"
												style="margin-bottom: -14px;margin-top: 16px;">

												
											</div>
										</div>
								
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
																name="leadId" placeholder="Select Lead ID" />

															<s:select list="{'a','b'}" headerKey="-1"
																headerValue="Select Company Name"
																cssClass="form-control chzn-select" name="companyName"
																id="companyName"></s:select>

															<s:select list="{'a','b'}" headerKey="-1"
																id="leadTitle" headerValue="Select Lead Title"
																cssClass="form-control chzn-select " name="leadTitle"></s:select>

															<s:select list="{'a','b'}" headerKey="-1"
																id="contactPerson" headerValue="Select Contact Person"
																cssClass="form-control chzn-select" name="contactPerson"></s:select>

															<s:select list="{'a','b'}" headerKey="-1"
																id="leadOwner" headerValue="Select Lead Owner"
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
															</span>
														</div>
														<div id='advanceSearchForm_leadDate_errorloc'
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
														name="lead.dashboard.action"></s:text></th>
												<th><s:text name="Claim Id"></s:text></th>
												<th><s:text name="Name"></s:text></th>
												<th><s:text name="Place Of Visit"></s:text></th>
												<th><s:text name="Dep. Date"></s:text></th>
												<th><s:text name="Arr. Date"></s:text></th>
												<th><s:text name="Claim Balance"></s:text></th>
												<th><s:text name="Status."></s:text></th>
												
											</tr>
										</thead>
										<tbody>
											<s:iterator value="claimedExpensesGrid">
												<tr>
													<td align="center">
														<div class="btn-group">
															<a id="view" href="viewExpenses?command=<s:property value='claimId'/>"
																data-toggle="tooltip" data-original-title="View"
																data-placement="bottom"> <i class="fa fa-eye"></i>
															</a>
														</div>


														<div class="btn-group">
															<a id="edit"
																href="editExpensesDetails?command=<s:property value='claimId'/>"
																data-toggle="tooltip" data-original-title="Edit"
																data-placement="bottom"> <i class="fa fa-edit"></i>
															</a>
														</div>


														<div class="btn-group">
															<a id="delete" href="login.html" data-toggle="tooltip"
																data-original-title="Delete" data-placement="bottom">
																<i class="fa fa-trash-o"></i>
															</a>
														</div>
													</td>
													<td><s:property value="claimId" /></td>
													<td><s:property value="name" /></td>
													<td><s:property value="placeOfVisit" /></td>
													<td><s:property value="departureDate" /></td>
													<td><s:property value="arrivalDate" /></td>
													<td><s:property value="grantTotalBalance" /></td>
													<td><s:property value="claimStatus" /></td>

													
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
