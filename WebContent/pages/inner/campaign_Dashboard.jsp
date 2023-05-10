<%@ taglib uri="/struts-tags" prefix="s"%>

<style>
#campaignId,#fullName,#campaignType,#assignedTo,#expectedRevenue,#expectedCloseDate,#campaignStatus
	{
	display: none;
}
</style>

<script type="text/javascript">
	function showElements() {

		var selectedIndex = document.getElementById('advanceSearch');

		var element1 = document.getElementById('campaignId');
		var element2 = document.getElementById('fullName');
		var element3 = document.getElementById('campaignType');
		var element4 = document.getElementById('assignedTo');
		var element5 = document.getElementById('expectedRevenue');
		var element6 = document.getElementById('expectedCloseDate');
		var element7 = document.getElementById('campaignStatus');
		

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
							<li class="active"><s:text name="campaign.dashboard"></s:text></li>
						</ol>
						<div class="box">
							<header>
								<div class="pull-left">
									<a class="icons" href="omiInnerDashboard.action"
										data-toggle="tooltip" data-original-title="Back To DashBoard">
										<i class="fa fa-table"></i>
									</a>

									<h5>
										<s:text name="campaign.dashboard"></s:text>
									</h5>
								</div>
								<div class="pull-right">

									<div class="btn-group">
										<a href="newCampaign.action" data-toggle="tooltip"
											data-original-title="New campaign"
											class="btn btn-primary btnheight"><i
											class="fa fa-plus fontawesomeht ">&nbsp;<s:text
													name="campaign.dashboard.addcampaign"></s:text></i></a>
										<button type="button" class="btn btn-info "
											data-toggle="collapse" data-target="#collapse1">
											<i class="fa fa-filter"></i>
											<s:text name="support_Faqs.filter"></s:text>
										</button>
										<a class="btn btn-success btnheight" data-toggle="tooltip"
											data-original-title="Refresh" href="campaignDashboard.action"><i
											class="fa fa-refresh "></i></a> <a href="campaignExcelReport.action" type="button"
											data-toggle="tooltip" data-original-title="XLS Report"
											class="btn btn-default btnheight"><i
											class="fa fa-file-excel-o fontawesomeht"></i></a> <a href=""
											data-toggle="tooltip" data-original-title="Settings"
											type="button" class="btn btn-warning btnheight"><i
											class="fa fa-gear fontawesomeht "></i></a> <a
											href="omiInnerDashboard.action" data-toggle="tooltip"
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
													<s:text name="campaign.information.bar" />
												</div>
											</div>
										</s:else>
									</p>

									<div id="dashboard_search_tools">
										<div class="row">
											<div class="col-lg-12  col-md-12  col-sm-12 col-xs-12"
												style="margin-bottom: 2px;">

												<div class="row"></div>
											</div>
										</div>
									</div>

									<div id="collapse1" class="panel-collapse collapse">
										<div class="row searchBar">
											<s:form name="advanceSearchForm" method="POST"
												action="populatedCampaignDetailsAsPerSearch">
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
															<s:textfield cssClass="form-control" id="campaignId"
																name="campaignId" placeholder="Select Campaign ID" />

															<s:select list="campaignNameList" headerKey="-1"
																headerValue="Select Campaign Name"
																cssClass="form-control chzn-select" name="fullName"
																id="fullName"></s:select>

															<s:select list="campaignTypeList" headerKey="-1"
																id="campaignType" headerValue="Select Campaing Type"
																cssClass="form-control chzn-select " name="campaignType"></s:select>

															<s:select list="campaignAssignedToList" headerKey="-1"
																id="assignedTo" headerValue="Select Campaing Assigned To"
																cssClass="form-control chzn-select" name="assignedTo"></s:select>

															<s:select list="expectedRevenueList" headerKey="-1"
																id="expectedRevenue" headerValue="Select Expected Revenue"
																cssClass="form-control chzn-select " name="expectedRevenue"></s:select>

															<s:select list="expectedClosingDateList" headerKey="-1"
																id="expectedCloseDate" headerValue="Select Expected Closing Date"
																cssClass="form-control chzn-select " name="expectedCloseDate"></s:select>


															<s:select list="campaignStatusList" headerKey="-1"
																headerValue="Select Campaign Status" id="campaignStatus"
																cssClass="form-control chzn-select" name="campaignStatus"></s:select>

															<span class="input-group-btn">
																<button type="submit" data-toggle="tooltip"
																	onclick="validate();" data-original-title="Search"
																	class="btn btn-metis-5 btn-line">
																	<span class="glyphicon glyphicon-search"></span>&nbsp;Search
																</button>
															</span>
														</div>
														<div id='advanceSearchForm_campaignId_errorloc'
															class="error_strings"></div>
														<div id='advanceSearchForm_fullName_errorloc'
															class="error_strings"></div>
														<div id='advanceSearchForm_campaignType_errorloc'
															class="error_strings"></div>
														<div id='advanceSearchForm_assignedTo_errorloc'
															class="error_strings"></div>
														<div id='advanceSearchForm_campaignStatus_errorloc'
															class="error_strings"></div>
														<div id='advanceSearchForm_expectedRevenue_errorloc'
															class="error_strings"></div>
														
														<div id='advanceSearchForm_expectedCloseDate_errorloc'
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
														name="campaign.dashboard.action"></s:text></th>
												<th><s:text name="campaign.dashboard.campaignid"></s:text></th>
												<th><s:text name="campaign.dashboard.campaign.name"></s:text></th>
												<th><s:text name="campaign.dashboard.campaign.type"></s:text></th>
												<th><s:text
														name="campaign.dashboard.campaign.assigned.to"></s:text></th>
												<th><s:text name="campaign.dashboard.expected.revenue"></s:text></th>
												<th><s:text
														name="campaign.dashboard.expected.closed.date"></s:text></th>
												<th><s:text name="campaign.dashboard.status"></s:text></th>

											</tr>
										</thead>
										<tbody>
											<s:iterator value="campaignDetailsList">
												<tr>
													<td align="center">
														<div class="btn-group">
															<a id="view"
																href="viewCampaignDetails?command=<s:property value='campaignId'/>"
																data-toggle="tooltip" data-original-title="View"
																data-placement="bottom"> <i class="fa fa-eye"></i>
															</a>
														</div>
														<div class="btn-group">
															<a id="edit"
																href="editCampaignDetails.action?command=<s:property value='campaignId' />"
																data-toggle="tooltip" data-original-title="Edit"
																data-placement="bottom"> <i class="fa fa-edit"></i>
															</a>
														</div>
														<div class="btn-group">
															<a id="delete" href="#"
																onclick="confirmDelete('deleteCampaignDetails.action?command='+<s:property value='campaignId'/>)"
																data-toggle="tooltip" data-original-title="Delete"
																data-placement="bottom"> <i class="fa fa-trash-o"></i>
															</a>
														</div>
													</td>
													<td><a style="color: blue"
														href="viewCampaignDetails?command=<s:property value='campaignId' />"><s:property
																value='campaignId' /></a></td>
													<td><s:property value="fullName" /></td>
													<td><s:property value="campaignType" /></td>
													<td><s:property value="assignedTo" /></td>
													<td><s:property value="expectedRevenue" /></td>
													<td><s:property value="expectedCloseDate" /></td>
													<td><s:property value="campaignStatus" /></td>
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