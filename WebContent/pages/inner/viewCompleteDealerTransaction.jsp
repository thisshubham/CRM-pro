<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Dealer Transaction</title>
<style>
#trId,#descriptionId,#retailerId,#payModeId,#dateId
	{
	display: none;
}
</style>

<script type="text/javascript">
	 function showElements() {

		var selectedIndex = document.getElementById('advanceDealerTransactionSearch');

		var element1 = document.getElementById('trId');
		var element2 = document.getElementById('descriptionId');
		var element3 = document.getElementById('retailerId');
		var element4 = document.getElementById('payModeId');
		var element5 = document.getElementById('dateId');

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
			
		}else if (selectedIndex.value == 5) {
			element1.style.display = 'none';
			element2.style.display = 'none';
			element3.style.display = 'none';
			element4.style.display = 'none';
			element5.style.display = 'block';
			
		}
	} 
</script>
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
									class="fa fa-home"></i> </a></li>
							<li class="active"><s:text name="Company Transaction"></s:text></li>
							<%-- <li class="active"><s:text name="Consumer Da"></s:text></li> --%>
						</ol>
						<div class="box">
							<!-- <header>
								<a class="icons" href="dashboard.action" data-toggle="tooltip"
									data-original-title="Back To DashBoard"> <i
									class="fa fa-table"></i>
								</a>
								<h5>Contacts Dashboard</h5>

							</header> -->
							<header>
								<div class="pull-left">
									<a class="icons" href="dashboard.action" data-toggle="tooltip"
										data-original-title="Back To Contact DashBoard"> <i
										class="fa fa-table"></i>
									</a>

									<h5 class="header_color">
										<s:text name="Company Transaction Dashboard"></s:text>
									</h5>
								</div>
								<div class="pull-right">

									<div class="btn-group">

										<%-- <a href="addConsumerCustomerAction" class="btn btn-primary btnheight"><i
											class="fa fa-plus fontawesomeht ">&nbsp;<s:text
													name="New Consumer"></s:text></i></a> --%>
													
										<button type="button" class="btn btn-info "
											data-toggle="collapse" data-target="#collapse1">
											<i class="fa fa-filter"></i>Filter
										</button>
										<button type="button" class="btn btn-success btnheight"
											onclick="window.location.reload();">
											<i class="fa fa-refresh "></i>
										</button>
										<a href="dealerTransactionExcelReport.action" type="button" class="btn btn-default btnheight"><i
											class="fa fa-file-excel-o fontawesomeht"></i></a> <a href=""
											type="button" class="btn btn-warning btnheight"><i
											class="fa fa-gear fontawesomeht "></i></a> <a href=""
											class="btn btn-danger btnheight"><i
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
													<s:text name="You Can Manage Company Transaction From Here." />
												</div>
											</div>
										</s:else>
									</p>
									<div id="collapse1" class="panel-collapse collapse">
										<div class="row searchBar">
											 <s:form name="retailerAdvanceSearchForm" method="POST"
												action="populateDealerTransactionAsPerSearch">
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
														<s:select list="dealerTransactionSearchList" headerKey="-1"
															onchange="showElements();" id="advanceDealerTransactionSearch"
															headerValue="Select Search Type" cssClass="form-control"
															name="searchId"></s:select>
														<div id='purchaseAdvanceSearchForm_searchId_errorloc'
															class="error_strings"></div>
													</div>
													<div class="col-lg-4  col-md-4  col-sm-12 col-xs-12">
														<div class="input-group">
															<s:textfield cssClass="form-control" id="trId"
																name="transactionId" placeholder="Transaction Id" />

															<s:textfield cssClass="form-control" id="descriptionId"
																name="description" placeholder="Description" />


                                                  <s:textfield cssClass="form-control" id="retailerId"
																name="retailerId" placeholder="Retailer" />
																
																<%-- <s:textfield cssClass="form-control" id="payModeId"
																name="paymentMode" placeholder="Payment Mode" /> --%>
																<s:select list="payModeList" headerKey="-1"
																id="payModeId" headerValue="Select Payment Mode"
																cssClass="form-control chzn-select " name="paymentMode"></s:select>
																
																<s:textfield cssClass="form-control" id="dateId"
																name="transactionDate" placeholder="Transaction Date" />
																
																
															<%-- <s:select list="productNameList" headerKey="-1"
																headerValue="Select Product"
																cssClass="form-control chzn-select" name="productName"
																id="productName"></s:select> --%>
															<%-- <s:select list="dealerList" headerKey="-1"
																headerValue="Select Dealer"
																cssClass="form-control chzn-select" name="dealerName"
																id="dealerNameId"></s:select> --%>

															<%-- <s:select list="productCategoryList" headerKey="-1"
																id="productCategory1"
																headerValue="Select Product Category"
																cssClass="form-control chzn-select "
																name="productCategory"></s:select> --%>
															
															
																<%--  <s:textfield cssClass="form-control" id="dp3"
																placeholder="Invoice Date" name="invoiceDate"/> --%>
																

															<%-- <s:textfield cssClass="form-control" id="dp4"
																placeholder="Select Sales End Date" name="salesEndDate"/>  --%>
															
															<span class="input-group-btn">
																<button type="submit" data-toggle="tooltip"
																	 data-original-title="Search"
																	class="btn btn-metis-5 btn-line">
																	<span class="glyphicon glyphicon-search"></span>&nbsp;
																	<s:text name="Search"></s:text><!-- onclick="validate();" -->
																</button>
															</span>
														</div>
														<!-- <div id='advanceSearchForm_casesId_errorloc'
															class="error_strings"></div>
														<div id='advanceSearchForm_caseTitle_errorloc'
															class="error_strings"></div>
														<div id='advanceSearchForm_contactName_errorloc'
															class="error_strings"></div>
														<div id='advanceSearchForm_priority_errorloc'
															class="error_strings"></div>
														<div id='advanceSearchForm_status_errorloc'
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
											<th style="width: 7%;"><s:text
														name="client.grid.action"></s:text></th>
												<%-- <th><s:text name="Transaction Id"></s:text>
												</th>
												
 --%>												
 												<th><s:text name="Company Name"></s:text></th>
 												<th><s:text name="Company Id"></s:text></th>
 												<th><s:text name="Date"></s:text></th>
 												<th><s:text name="Bill No"></s:text></th>
												<th><s:text name="Description"></s:text>
												</th>
												
												<th><s:text name="Total Amount"></s:text></th>
												<th><s:text name="Paid Amount"></s:text></th>
												<th><s:text name="Due Amount"></s:text></th>
												<th><s:text name="Total Paid"></s:text></th>
												<th><s:text name="Total Due"></s:text></th>
												
												
												
												<th><s:text name="Payment Mode"></s:text></th>
												
												
											</tr>
										</thead>
										<tbody>
											<s:iterator value="dealerTransactionDetailList">
											
												<tr>
													
													<td align="center">
														<div class="btn-group">
															<a id="view"
																href="viewDealerTransaction.action?command=<s:property value='transactionId'/>"
																data-toggle="tooltip" data-original-title="View"
																data-placement="bottom"> <i class="fa fa-eye"></i>
															</a>
														</div>
														<div class="btn-group">
															<a id="edit"
																href="payDueAmountOfDealer.action?command=<s:property value='transactionId' />&did=<s:property value='retailerId' />"
																data-toggle="tooltip" data-original-title="Pay Due"
																data-placement="bottom"> <i class="fa fa-edit"></i>
															</a>
														</div>
														<div class="btn-group">
															<a id="delete" onclick="confirmDelete('deleteDealerTransaction.action?command=<s:property value='transactionId' />')" data-toggle="tooltip"
																data-original-title="Delete" data-placement="bottom">
																<i class="fa fa-trash-o"></i>
															</a>
														</div>
													</td>
													<td><s:property value="fullName" /></td>
													<td><s:property value="retailerId" /></td>
													<td><s:property value="transactionDate" /></td>
													<td><s:property value="transactionBillNo" /></td>
													<%-- <td><s:property value="transactionId" /></td> --%>
													<td><s:property value="description" /></td>
													
													<td><s:property value="total" /></td>
													<td><s:property value="paid" /></td>
													<td><s:property value="due" /></td>
													<td><s:property value="totalPaid" /></td>

                                                    
													
													
													<td><s:property value="totalDue" /></td>
													
													
													
													<td><s:property value="paymentMode" /></td>
													

													
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
		<!-- /.inner -->
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
		function confirmDelete(url) {
			if (confirm("Are you sure you want to delete?")) {
				document.location = url;
			}

		}
		<script type="text/javascript">
		function print(){
	        /* $("#btnPrint").live("click", function () { */
	        	
	            var divContents = $("#btnprint").html();
	            var printWindow = window.open('', '', 'height=400,width=800');
	            printWindow.document.write('<html><head><title></title>');
	            printWindow.document.write('</head><body>');
	            printWindow.document.write(divContents);
	            printWindow.document.write('</body></html>');
	            printWindow.document.close();
	            printWindow.print();
	        /* }); */
		}
	    </script>
	</script>
	<script src="assets/js/style-switcher.min.js"></script>
</body>
</html>