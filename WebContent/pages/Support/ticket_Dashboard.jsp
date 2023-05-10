<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%-- <%@taglib uri="/struts-jquery-tags" prefix="sj"%> --%>

<style>
#category,#ticketOwner,#priority,#channel,#dp4,#contactName,#productName,#ticketStatus
	{
	display: none;
}
</style>

<script type="text/javascript">
	function showElements() {

		var selectedIndex = document.getElementById('ticketAdvanceSearch');

		var element1 = document.getElementById('ticketId');
		var element2 = document.getElementById('category');
		var element3 = document.getElementById('ticketOwner');
		var element4 = document.getElementById('priority');
		var element5 = document.getElementById('channel');
		var element6 = document.getElementById('dp4');
		var element7 = document.getElementById('contactName');
		var element8 = document.getElementById('productName');
		var element9 = document.getElementById('ticketStatus');

		if (selectedIndex.value == -1 || selectedIndex.value == 1) {
			element1.style.display = 'block';
			element2.style.display = 'none';
			element3.style.display = 'none';
			element4.style.display = 'none';
			element5.style.display = 'none';
			element6.style.display = 'none';
			element7.style.display = 'none';
			element8.style.display = 'none';
			element9.style.display = 'none';

		} else if (selectedIndex.value == 2) {
			element1.style.display = 'none';
			element2.style.display = 'block';
			element3.style.display = 'none';
			element4.style.display = 'none';
			element5.style.display = 'none';
			element6.style.display = 'none';
			element7.style.display = 'none';
			element8.style.display = 'none';
			element9.style.display = 'none';

		} else if (selectedIndex.value == 3) {
			element1.style.display = 'none';
			element2.style.display = 'none';
			element3.style.display = 'block';
			element4.style.display = 'none';
			element5.style.display = 'none';
			element6.style.display = 'none';
			element7.style.display = 'none';
			element8.style.display = 'none';
			element9.style.display = 'none';

		} else if (selectedIndex.value == 4) {
			element1.style.display = 'none';
			element2.style.display = 'none';
			element3.style.display = 'none';
			element4.style.display = 'block';
			element5.style.display = 'none';
			element6.style.display = 'none';
			element7.style.display = 'none';
			element8.style.display = 'none';
			element9.style.display = 'none';

		} else if (selectedIndex.value == 5) {
			element1.style.display = 'none';
			element2.style.display = 'none';
			element3.style.display = 'none';
			element4.style.display = 'none';
			element5.style.display = 'block';
			element6.style.display = 'none';
			element7.style.display = 'none';
			element8.style.display = 'none';
			element9.style.display = 'none';

		} else if (selectedIndex.value == 6) {
			element1.style.display = 'none';
			element2.style.display = 'none';
			element3.style.display = 'none';
			element4.style.display = 'none';
			element5.style.display = 'none';
			element6.style.display = 'block';
			element7.style.display = 'none';
			element8.style.display = 'none';
			element9.style.display = 'none';

		} else if (selectedIndex.value == 7) {
			element1.style.display = 'none';
			element2.style.display = 'none';
			element3.style.display = 'none';
			element4.style.display = 'none';
			element5.style.display = 'none';
			element6.style.display = 'none';
			element7.style.display = 'block';
			element8.style.display = 'none';
			element9.style.display = 'none';
		} else if (selectedIndex.value == 8) {
			element1.style.display = 'none';
			element2.style.display = 'none';
			element3.style.display = 'none';
			element4.style.display = 'none';
			element5.style.display = 'none';
			element6.style.display = 'none';
			element7.style.display = 'none';
			element8.style.display = 'block';
			element9.style.display = 'none';
		} else if (selectedIndex.value == 9) {
			element1.style.display = 'none';
			element2.style.display = 'none';
			element3.style.display = 'none';
			element4.style.display = 'none';
			element5.style.display = 'none';
			element6.style.display = 'none';
			element7.style.display = 'none';
			element8.style.display = 'none';
			element9.style.display = 'block';
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
							<li><a href="ticketDashboard"><s:text
										name="ticket.Dashboard.navbar"></s:text></a></li>
							<li><a href="ticketDashboard"><s:text
										name="ticket.Dashboard.panel.heading"></s:text></a></li>
						</ol>
						<div class="box">
							<header>
								<div class="pull-left">
									<a class="icons" href="dashboard.action" data-toggle="tooltip"
										data-original-title="Back To DashBoard"> <i
										class="fa fa-table"></i>
									</a>
									<h5 class="header_color">
										<s:text name="ticket.Dashboard.panel.heading"></s:text>
									</h5>
								</div>
								<div class="pull-right">
									<div class="btn-group">
										<a href="renderAddNewTicket.action" data-toggle="tooltip"
											data-original-title="New Ticket"
											class="btn btn-primary btnheight"><i
											class="fa fa-plus fontawesomeht ">&nbsp;<s:text
													name="add.new.ticket.panel.heading"></s:text></i></a>
										<button type="button" class="btn btn-info "
											data-toggle="collapse" data-target="#collapse1">
											<i class="fa fa-filter"></i>
											<s:text name="support_Faqs.filter"></s:text>
										</button>
										<a class="btn btn-success btnheight" data-toggle="tooltip"
											data-original-title="Refresh" href="ticketDashboard.action"><i
											class="fa fa-refresh "></i></a> <a
											href="ticketExcelReport.action" type="button"
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
													<s:text name="ticket.Dashboard.infobar" />
												</div>
											</div>
										</s:else>
									</p>
									<div id="collapse1" class="panel-collapse collapse">
										<div class="row searchBar">
											<s:form name="advanceSearchForm" method="POST"
												acton="populateTicketDetailsAsPerSearch">
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
															onchange="showElements();" id="ticketAdvanceSearch"
															headerValue="Select Search Type" cssClass="form-control"
															name="searchId"></s:select>
														<div id='advanceSearchForm_searchId_errorloc'
															class="error_strings"></div>
													</div>
													<div class="col-lg-4  col-md-4  col-sm-12 col-xs-12">
														<div class="input-group">
															<s:textfield cssClass="form-control" id="ticketId"
																name="ticketId" placeholder="Select Ticket ID" />

															<s:select list="ticketCategoryList" headerKey="-1"
																headerValue="Select your category"
																cssClass="form-control chzn-select" name="category"
																id="category"></s:select>

															<s:select list="ticketOwnerList" headerKey="-1"
																id="ticketOwner" headerValue="Select ticket owner"
																cssClass="form-control chzn-select " name="ticketOwner"></s:select>

															<s:select list="ticketPriorityList" headerKey="-1"
																id="priority" headerValue="Select your priority"
																cssClass="form-control chzn-select" name="priority"></s:select>

															<s:select list="ticketChannelList" headerKey="-1"
																id="channel" headerValue="Select your channel"
																cssClass="form-control chzn-select " name="channel"></s:select>

															<s:textfield cssClass="form-control" id="dp4"
																placeholder="Select ticket Date" name="dueDate" />

															<s:select list="ticketContactNameList" headerKey="-1"
																headerValue="Select your contact name" id="contactName"
																cssClass="form-control chzn-select" name="contactName"></s:select>
															
															<s:select list="ticketProductNameList" headerKey="-1"
																headerValue="Select your product name" id="productName"
																cssClass="form-control chzn-select" name="productName"></s:select>


															<s:select list="ticketStatusList" headerKey="-1"
																headerValue="Select Ticket Status" id="ticketStatus"
																cssClass="form-control chzn-select" name="ticketStatus"></s:select>

															<span class="input-group-btn">
																<button type="submit" data-toggle="tooltip"
																	onclick="validate();" data-original-title="Search"
																	class="btn btn-metis-5 btn-line">
																	<span class="glyphicon glyphicon-search"></span>&nbsp;
																	<s:text name="Search"></s:text>
																</button>
															</span>
														</div>
														<div id='advanceSearchForm_dueDate_errorloc'
															class="error_strings"></div>
														<div id='advanceSearchForm_ticketId_errorloc'
															class="error_strings"></div>
														<div id='advanceSearchForm_category_errorloc'
															class="error_strings"></div>
														<div id='advanceSearchForm_ticketOwner_errorloc'
															class="error_strings"></div>
														<div id='advanceSearchForm_priority_errorloc'
															class="error_strings"></div>
														<div id='advanceSearchForm_channel_errorloc'
															class="error_strings"></div>
														<div id='advanceSearchForm_dueDate_errorloc'
															class="error_strings"></div>
														<div id='advanceSearchForm_productName_errorloc'
															class="error_strings"></div>
														<div id='advanceSearchForm_contactName_errorloc'
															class="error_strings"></div>
														<div id='advanceSearchForm_ticketStatus_errorloc'
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
												<th style="width: 5%;"><s:text name="Action"></s:text></th>
												<th><s:text name="add.new.ticket.ticketId"></s:text></th>
												<th><s:text name="add.new.ticket.category"></s:text></th>
												<th><s:text name="add.new.ticket.ticketOwner"></s:text></th>
												<th><s:text name="add.new.ticket.priority"></s:text></th>
												<th><s:text name="add.new.ticket.channel"></s:text></th>
												<th><s:text name="add.new.ticket.dueDate"></s:text></th>
												<th><s:text name="add.new.ticket.productName"></s:text></th>
												<th><s:text name="add.new.ticket.contactName"></s:text></th>
												<th><s:text name="add.new.ticket.status"></s:text></th>
											</tr>
										</thead>
										<tbody>
											<s:iterator value="ticketGridList">
												<tr>
													<td align="center">
														<div class="btn-group">
															<a id="view"
																href="viewTicket?command=<s:property value='ticketId'/>"
																data-toggle="tooltip" data-original-title="View"
																data-placement="bottom"> <i class="fa fa-eye"></i>
															</a>
														</div>
														<div class="btn-group">
															<a id="edit"
																href="editTicket?command=<s:property value='ticketId' />"
																data-toggle="tooltip" data-original-title="Edit"
																data-placement="bottom"> <i class="fa fa-edit"></i>
															</a>
														</div>
														<div class="btn-group">
															<a href="#"
																onclick="confirmDelete('deleteTicket.action?command='+<s:property value='ticketId'/>)"
																data-toggle="tooltip" data-original-title="Delete"
																data-placement="bottom" data-placement="bottom"> <i
																class="fa fa-trash-o"></i>
															</a>
														</div>
													</td>
													<td><a style="color: blue"
														href="viewTicket?command=<s:property value='ticketId' />">
															<s:property value='ticketId' />
													</a></td>
													<td><s:property value="category" /></td>
													<td><s:property value="ticketOwner" /></td>
													<td><s:property value="priority" /></td>
													<td><s:property value="channel" /></td>
													<td><s:property value="dueDate" /></td>
													<td><s:property value="productName" /></td>
													<td><s:property value="contactName" /></td>
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
			var selectedIndex = document.getElementById('ticketAdvanceSearch');

			if (selectedIndex.value == 1) {
				frmvalidator
						.addValidation("ticketId", "req", "Enter Ticket Id");
			} else if (selectedIndex.value == 2) {
				frmvalidator.addValidation("category", "dontselect=-1",
						"Select Your Category");
			} else if (selectedIndex.value == 3) {
				frmvalidator.addValidation("ticketOwner", "dontselect=-1",
						"Select Ticket Owner ");
			} else if (selectedIndex.value == 4) {
				frmvalidator.addValidation("priority", "dontselect=-1",
						"Select Your Priority");
			} else if (selectedIndex.value == 5) {
				frmvalidator.addValidation("channel", "dontselect=-1",
						"Select Your Channel");
			} else if (selectedIndex.value == 6) {
				frmvalidator.addValidation("dueDate", "req",
						"Select Ticket Due Date");
			} else if (selectedIndex.value == 7) {
				frmvalidator.addValidation("contactName", "dontselect=-1",
						"Select Contact Name");
			} else if (selectedIndex.value == 8) {
				frmvalidator.addValidation("productName", "dontselect=-1",
						"Select Product Name");
			} else if (selectedIndex.value == 9) {
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
