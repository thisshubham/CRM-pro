<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%-- <%@taglib uri="/struts-jquery-tags" prefix="sj"%> --%>

<style>
#salesId,#customerType,#dp4,#paymentMode,#customerId,#paymentAnswer,#uniqueId
	{
	display: none;
}
</style>

<script type="text/javascript">
	function showElements() {

		var selectedIndex = document.getElementById('salesAdvanceSearch');

		var element1 = document.getElementById('salesId');
		var element2 = document.getElementById('customerType');
		var element3 = document.getElementById('dp4');
		var element4 = document.getElementById('paymentMode');
		var element5 = document.getElementById('customerId');
		var element6 = document.getElementById('paymentAnswer');//uniqueId
		var element7 = document.getElementById('uniqueId');

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
			

		}  else if (selectedIndex.value == 6) {
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
	
	/* $( function() {
		  $( "#dialog-confirm" ).dialog({
		    resizable: false,
		    height: "auto",
		    width: 400,
		    modal: true,
		    buttons: {
		      "Delete all items": function() {
		        $( this ).dialog( "close" );
		      },
		      Cancel: function() {
		        $( this ).dialog( "close" );
		      }
		    }
		  });
		} ); */
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
							<li class="active"><%-- <s:text name="purchase.dashboard.purchase"></s:text> --%>Invoice </li>
							<li class="active"><%-- <s:text
									name="purchase.Dashboard.panel.heading"></s:text> --%>Invoice Dashboard</li>
						</ol>
						<div class="box">
							<header>
								<div class="pull-left">
									<a class="icons" href="dashboard.action" data-toggle="tooltip"
										data-original-title="Back To DashBoard"> <i
										class="fa fa-table"></i>
									</a>

									<h5 class="header_color">
										<%-- <s:text name="Purchase Dashboard"></s:text> --%>Invoice Dashboard
									</h5>
								</div>
								<div class="pull-right">
									<div class="btn-group">
										<a href="addSaleInvoice" data-toggle="tooltip"
											data-original-title="New Invoice"
											class="btn btn-primary btnheight"><i
											class="fa fa-plus fontawesomeht ">&nbsp;<%-- <s:text
													name="purchase.Dashboard.navbar"></s:text> --%>New Invoice</i></a>
													<a href="quickSaleInvoice" data-toggle="tooltip"
											data-original-title="Quick Invoice"
											class="btn btn-primary btnheight"><i
											class="fa fa-plus fontawesomeht ">&nbsp;<%-- <s:text
													name="purchase.Dashboard.navbar"></s:text> --%>Quick Invoice</i></a>
										<button type="button" class="btn btn-info "
											data-toggle="collapse" data-target="#collapse1">
											<i class="fa fa-filter"></i> Filter
										</button>
										<a class="btn btn-success btnheight" data-toggle="tooltip"
											data-original-title="Refresh" href="invoiceDashbord.action"><i
											class="fa fa-refresh "></i></a> <a
											href="salesExcelReport.action" type="button"
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
													<%-- <s:text name="purchase.dashboard.add.new.purchase.hare" /> --%>You can Manage Invoice here.
												</div>
											</div>
										</s:else>
									</p>
							<div id="collapse1" class="panel-collapse collapse">
										<div class="row searchBar">
											<s:form name="advanceSearchForm" method="POST"
												action="populateSalesDetailsAsPerSearch">
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
														 <s:select list="salesSearchList" headerKey="-1"
															onchange="showElements();" id="salesAdvanceSearch"
															headerValue="Select Search Type" cssClass="form-control"
															name="searchId"></s:select> 
														<div id='advanceSearchForm_searchId_errorloc'
															class="error_strings"></div>
													</div>
													<div class="col-lg-4  col-md-4  col-sm-12 col-xs-12">
														<div class="input-group">
															 <s:textfield cssClass="form-control" id="salesId"
																name="salesId" placeholder="Select Sales ID" />

															<%-- <s:select list="ticketCategoryList" headerKey="-1"
																headerValue="Select your category"
																cssClass="form-control chzn-select" name="category"
																id="category"></s:select> --%>
															<%-- <s:textfield cssClass="form-control" id="customerType"
																name="customerType" placeholder="Select Customer Type" /> --%>
																
																
<select class="form-control" theme="css_xhtml" cssStyle="width: 10px;height:35px;" id="customerType"
											headerKey="-1" headerValue="Select Customer" name="customerType" style= "width: 200px;height:35px;">
											<option>Retailer</option>
											<option>Consumer</option></select>
															


                                                              <s:textfield cssClass="form-control" id="dp4"
																placeholder="Select sales Date" name="salesDate" />	
																
																
																<s:select list="payModeList" headerKey="-1"
																id="paymentMode" headerValue="Select Payment Mode"
																cssClass="form-control chzn-select " name="paymentMode"></s:select>
																
															<s:select list="regCustomersList" headerKey="-1"
																id="customerId" headerValue="Select Customer"
																cssClass="form-control chzn-select" name="customerId"></s:select>


                                                                 <%-- <s:textfield cssClass="form-control" id="paymentAnswer"
																placeholder="Payment Answer" name="paymentAnswer" /> --%>	
																<select class="form-control" theme="css_xhtml" cssStyle="width: 250px;height:35px;" id="paymentAnswer"
											headerKey="-1" headerValue="Select Payment Answer" name="paymentAnswer" style= "width: 250px;height:35px;">
											<option>YES</option>
											<option>NO</option></select>
																<s:textfield cssClass="form-control" id="uniqueId"
																placeholder="Unique Id" name="uniqueId" />	
															<%-- <s:select list="ticketChannelList" headerKey="-1"
																id="channel" headerValue="Select your channel"
																cssClass="form-control chzn-select " name="channel"></s:select>

															

															<s:select list="ticketContactNameList" headerKey="-1"
																headerValue="Select your contact name" id="contactName"
																cssClass="form-control chzn-select" name="contactName"></s:select>
															
															<s:select list="ticketProductNameList" headerKey="-1"
																headerValue="Select your product name" id="productName"
																cssClass="form-control chzn-select" name="productName"></s:select>


															<s:select list="ticketStatusList" headerKey="-1"
																headerValue="Select Ticket Status" id="ticketStatus"
																cssClass="form-control chzn-select" name="ticketStatus"></s:select> --%>

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
												<th><%-- <s:text name="add.new.ticket.ticketId"></s:text> --%>Sales Id</th>
												<th><%-- <s:text name="add.new.ticket.category"></s:text> --%>Customer Name</th>
												<th><%-- <s:text name="add.new.ticket.category"></s:text> --%>Customer Ref.</th>
												<th><%-- <s:text name="add.new.ticket.ticketOwner"></s:text> --%>Customer Type</th>
												<th><%-- <s:text name="add.new.ticket.priority"></s:text> --%>Payment Mode</th>
												<th><%-- <s:text name="add.new.ticket.channel"></s:text> --%>Sales Date</th>
												<th><%-- <s:text name="add.new.ticket.dueDate"></s:text> --%>Payment Status</th>
												<th><%-- <s:text name="add.new.ticket.productName"></s:text> --%>Discount</th>
												<th><%-- <s:text name="add.new.ticket.contactName"></s:text> --%>Net Total</th>
												<!-- <th>Amount</th> -->
											</tr>
										</thead>
										<tbody>
											<s:iterator value="invoiceSaleList">
												<tr>
													<td align="center">
														<div class="btn-group">
													<a id="view"
																href="viewSaleInvoice?command=<s:property value='salesId'/>"
																data-toggle="tooltip" data-original-title="View"
																data-placement="bottom"> <i class="fa fa-eye"></i>
															</a> 
														</div>
														<div class="btn-group">
															 <a id="edit"
																href="updateSaleInvoice?command=<s:property value='salesId' />"
																data-toggle="tooltip" data-original-title="Edit"
																data-placement="bottom"> <i class="fa fa-edit"></i>
															</a> 
														</div>
														<div class="btn-group">
															<%-- <a href="#"
																onclick="confirmDelete('deleteTicket.action?command='+<s:property value='id'/>)" data-toggle="tooltip" data-original-title="Delete"
																data-placement="bottom" data-placement="bottom"> <i
																class="fa fa-trash-o"></i></a>  --%>
															<%-- <a href="deleteEstimateAction"
																onclick="confirmDelete('deleteEstimateAction.action?command='+<s:property value='id'/>)"
																data-toggle="tooltip" data-original-title="Delete"
																data-placement="bottom" data-placement="bottom"> 
																<i class="fa fa-trash-o"></i>
															</a> --%>
															<a onclick="confirmDelete('deleteSaleInvoice?command=<s:property value='salesId' />')"
																data-toggle="tooltip" data-original-title="Delete"
																data-placement="bottom" data-placement="bottom"> 
																<i class="fa fa-trash-o"></i>
															</a> 
														</div>
													</td>
													<td><a style="color: blue"
														href="viewEstimateAction?command=<s:property value='id' />">
															<s:property value='salesId' />
													</a></td>
													<td><s:property value="fullName" /></td>
													<td><s:property value="customerId" /></td>
													<td><s:property value="customerType" /></td>
													
													<td><s:property value="paymentMode" /></td>
													<td><s:property value="salesDate" /></td>
													<td><s:property value="paymentAnswer" /></td>
													<td><s:property value="discount" /></td>
													<td><s:property value="netTotal" /></td>
													<%-- <td><s:property value="amount" /></td> --%>
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