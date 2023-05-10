<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="/struts-jquery-tags" prefix="sj"%>
<!DOCTYPE html>
<html>
<head>
<style>
#caseTitle,#contactName,#priority,#status {
	display: none;
}
</style>
<script type="text/javascript">
	function showElements() {

		var selectedIndex = document.getElementById('casesAdvanceSearch');

		var element1 = document.getElementById('casesId');
		var element2 = document.getElementById('caseTitle');
		var element3 = document.getElementById('contactName');
		var element4 = document.getElementById('priority');
		var element5 = document.getElementById('status');

		if (selectedIndex.value == -1 || selectedIndex.value == 1) {
			element1.style.display = 'block';
			element2.style.display = 'none';
			element3.style.display = 'none';
			element4.style.display = 'none';
			element5.style.display = 'none';

		} else if (selectedIndex.value == 2) {
			element1.style.display = 'none';
			element2.style.display = 'block';
			element3.style.display = 'none';
			element4.style.display = 'none';
			element5.style.display = 'none';

		} else if (selectedIndex.value == 3) {
			element1.style.display = 'none';
			element2.style.display = 'none';
			element3.style.display = 'block';
			element4.style.display = 'none';
			element5.style.display = 'none';

		} else if (selectedIndex.value == 4) {
			element1.style.display = 'none';
			element2.style.display = 'none';
			element3.style.display = 'none';
			element4.style.display = 'block';
			element5.style.display = 'none';

		} else if (selectedIndex.value == 5) {
			element1.style.display = 'none';
			element2.style.display = 'none';
			element3.style.display = 'none';
			element4.style.display = 'none';
			element5.style.display = 'block';

		}
	}
</script>
<sj:head />
</head>
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
							<li><a href="SupportCases"><s:text
										name="support.cases.add.new"></s:text></a></li>
							<li><a href="SupportCases"><s:text
										name="Support.cases.pannel.heading"></s:text></a></li>
						</ol>
						<div class="box">
							<header>
								<div class="pull-left">
									<a class="icons" href="dashboard.action" data-toggle="tooltip"
										data-original-title="Back To Dashboard"> <i
										class="fa fa-table"></i>
									</a>

									<h5 class="header_color">
										<s:text name="Support.cases.pannel.heading"></s:text>
									</h5>
								</div>
								<div class="pull-right">
									<div class="btn-group">
										<a href="SupportAddCases.action" data-toggle="tooltip"
											data-original-title="New Cases"
											class="btn btn-primary btnheight"><i
											class="fa fa-plus fontawesomeht ">&nbsp;<s:text
													name="Support.cases.add.pannel.heading"></s:text></i></a>
										<button type="button" class="btn btn-info "
											data-toggle="collapse" data-target="#collapse1">
											<i class="fa fa-filter"></i>
											<s:text name="support_Faqs.filter"></s:text>
										</button>
										<a class="btn btn-success btnheight" data-toggle="tooltip"
											data-original-title="Refresh" href="SupportCases.action"><i
											class="fa fa-refresh "></i></a> <a href="supportCasesExcelReport.action" type="button"
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
													<s:text name="Support.cases.infobar" />
												</div>
											</div>
										</s:else>
									</p>
									<div id="collapse1" class="panel-collapse collapse">
										<div class="row searchBar">
											<s:form name="advanceSearchForm" method="POST"
												acton="populateCasesSearch">
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
															onchange="showElements();" id="casesAdvanceSearch"
															headerValue="Select Search Type" cssClass="form-control"
															name="searchId"></s:select>
														<div id='advanceSearchForm_searchId_errorloc'
															class="error_strings"></div>
													</div>
													<div class="col-lg-4  col-md-4  col-sm-12 col-xs-12">
														<div class="input-group">
															<s:textfield cssClass="form-control" id="casesId"
																name="casesId" placeholder="Select Cases ID" />

															
																<s:select list="caseTitleList" headerKey="-1"
																headerValue="Select Case Title"
																cssClass="form-control chzn-select" name="caseTitle"
																id="caseTitle"></s:select>

															<s:select list="casesContactNameList" headerKey="-1"
																headerValue="Select Contact Name"
																cssClass="form-control chzn-select" name="contactName"
																id="contactName"></s:select>

															<s:select list="casesPriorityList" headerKey="-1"
																id="priority" headerValue="Select your priority"
																cssClass="form-control chzn-select " name="priority"></s:select>

															<s:select list="casesStatusList" headerKey="-1"
																id="status" headerValue="Select your status"
																cssClass="form-control chzn-select" name="status"></s:select>

															<span class="input-group-btn">
																<button type="submit" data-toggle="tooltip"
																	onclick="validate();" data-original-title="Search"
																	class="btn btn-metis-5 btn-line">
																	<span class="glyphicon glyphicon-search"></span>&nbsp;
																	<s:text name="Search"></s:text>
																</button>
															</span>
														</div>
														<div id='advanceSearchForm_casesId_errorloc'
															class="error_strings"></div>
														<div id='advanceSearchForm_caseTitle_errorloc'
															class="error_strings"></div>
														<div id='advanceSearchForm_contactName_errorloc'
															class="error_strings"></div>
														<div id='advanceSearchForm_priority_errorloc'
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
												<th><s:text name="client.grid.action"></s:text></th>
												<th><s:text name="support.cases.cases.id"></s:text></th>
												<th><s:text name="Support.cases.case.title"></s:text></th>
												<th><s:text name="Support.cases.contact.name"></s:text></th>
												<th><s:text name="Support.cases.priority"></s:text></th>
												<th><s:text name="Support.cases.status"></s:text></th>
											</tr>
										</thead>
										<tbody>
											<s:iterator value="casesGridList">
												<tr>
													<td align="center">
														<div class="btn-group">
															<a id="view"
																href="supportViewCases.action?command=<s:property value='casesId'/>"
																data-toggle="tooltip" data-original-title="View"
																data-placement="bottom"> <i class="fa fa-eye"></i>
															</a>
														</div>
														<div class="btn-group">
															<a id="edit"
																href="supportEditCases.action?command=<s:property value='casesId' />"
																data-toggle="tooltip" data-original-title="Edit"
																data-placement="bottom"> <i class="fa fa-edit"></i>
															</a>
														</div>
														<div class="btn-group">
															<a href="#"
																onclick="confirmDelete('deleteCasesDetail.action?command='+<s:property value='casesId'/>)"
																data-toggle="tooltip" data-original-title="Delete"
																data-placement="bottom" data-placement="bottom"> <i
																class="fa fa-trash-o"></i>
															</a>
														</div>
													</td>
													<td><a style="color: blue"
														href="supportViewCases.action?command=<s:property value='casesId' />"><s:property
																value='casesId' /></a></td>
													<td><s:property value="caseTitle" /></td>
													<td><s:property value="contactName" /></td>
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

			frmvalidator.addValidation("searchId", "dontselect=-1",
					"Select Search Type");
			var selectedIndex = document.getElementById('casesAdvanceSearch');

			if (selectedIndex.value == 1) {
				frmvalidator.addValidation("casesId", "req", "Enter Cases Id");
			} else if (selectedIndex.value == 2) {
				frmvalidator.addValidation("casesTitle", "req",
						"Select Cases Title");
			} else if (selectedIndex.value == 3) {
				frmvalidator.addValidation("contactName", "dontselect=-1",
						"Select Contact Name");
			} else if (selectedIndex.value == 4) {
				frmvalidator.addValidation("priority", "dontselect=-1",
						"Select Your priority");
			} else if (selectedIndex.value == 5) {
				frmvalidator.addValidation("status", "dontselect=-1",
						"Select Your Status");
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
</html>