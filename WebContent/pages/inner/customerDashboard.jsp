<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="/struts-jquery-tags" prefix="sj"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Retailer Dashboard</title>
</head>
<style>
#customerId,#cityId,#mobileId,#stateId
	{
	display: none;
}
</style>

<script type="text/javascript">
	 function showElements() {

		var selectedIndex = document.getElementById('advanceConsumerSearch');

		var element1 = document.getElementById('customerId');
		var element2 = document.getElementById('cityId');
		var element3 = document.getElementById('mobileId');
		var element4 = document.getElementById('stateId');
		

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
			

		} else if (selectedIndex.value == 4) {
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
									class="fa fa-home"></i> </a></li>
							<li class="active"><s:text name="Retailer"></s:text></li>
							<li class="active"><s:text name="Retailer Dashboard"></s:text></li>
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
										data-original-title="Back To Retailer DashBoard"> <i
										class="fa fa-table"></i>
									</a>

									<h5 class="header_color">
										<s:text name="Retailer Dashboard"></s:text>
									</h5>
								</div>
								<div class="pull-right">

									<div class="btn-group">

										<a href="addRetailercustomerAction" class="btn btn-primary btnheight"><i
											class="fa fa-plus fontawesomeht ">&nbsp;<s:text
													name="New Retailer"></s:text></i></a>
										<button type="button" class="btn btn-info "
											data-toggle="collapse" data-target="#collapse1">
											<i class="fa fa-filter"></i>Filter
										</button>
										<button type="button" class="btn btn-success btnheight"
											onclick="window.location.reload();">
											<i class="fa fa-refresh "></i>
										</button>
										<a href="retailerDetailExcelReport.action" type="button" class="btn btn-default btnheight"><i
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
													<s:text name="You can manage Retailer Dashboard here" />
												</div>
											</div>
										</s:else>
									</p>
									<div id="collapse1" class="panel-collapse collapse">
										<div class="row searchBar">
											 <s:form name="retailerAdvanceSearchForm" method="POST"
												action="populateRetailerDetailsAsPerSearch">
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
														<s:select list="retailerCustomerSearchList" headerKey="-1"
															onchange="showElements();" id="advanceConsumerSearch"
															headerValue="Select Search Type" cssClass="form-control"
															name="searchId"></s:select>
														<div id='purchaseAdvanceSearchForm_searchId_errorloc'
															class="error_strings"></div>
													</div>
													<div class="col-lg-4  col-md-4  col-sm-12 col-xs-12">
														<div class="input-group">
															<s:textfield cssClass="form-control" id="customerId"
																name="customerId" placeholder="Customer ID" />

															<s:textfield cssClass="form-control" id="cityId"
																name="city" placeholder="City" />


                                                  <s:textfield cssClass="form-control" id="mobileId"
																name="mobileNo" placeholder="Mobile No" />
																
																<s:textfield cssClass="form-control" id="stateId"
																name="state" placeholder="State" />
																
																
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
												<th><s:text name="Retailer Id"></s:text>
												</th>
												
												<th><s:text name="Full Name"></s:text>
												</th>
												
												<th><s:text name="Adderess"></s:text></th>
												<th><s:text name="City"></s:text></th>
												<th><s:text name="Phone Number"></s:text></th>
												<th><s:text name="Mobile Number"></s:text></th>
												<th><s:text name="State"></s:text></th>
												<th><s:text name="Creation Date"></s:text>
												
												</th>
												
											</tr>
										</thead>
										<tbody>
											<s:iterator value="retailerDetailList">
												<tr>
													
													<td align="center">
														<div class="btn-group">
															<a id="view"
																href="viewRetailerdetailAction.action?command=<s:property value='customerId'/>"
																data-toggle="tooltip" data-original-title="View"
																data-placement="bottom"> <i class="fa fa-eye"></i>
															</a>
														</div>
														<div class="btn-group">
															<a id="edit"
																href="updateRetailerDetailsAction?command=<s:property value='customerId' />"
																data-toggle="tooltip" data-original-title="Edit"
																data-placement="bottom"> <i class="fa fa-edit"></i>
															</a>
														</div>
														<div class="btn-group">
															<a id="delete" onclick="confirmDelete('deleteRetailerRecord.action?command=<s:property value='customerId' />')" data-toggle="tooltip"
																data-original-title="Delete" data-placement="bottom">
																<i class="fa fa-trash-o"></i>
															</a> 
															<!-- <a id="delete" href="#" data-toggle="tooltip"
																data-original-title="Delete" data-placement="bottom">
																<i class="fa fa-trash-o"></i> -->
															</a>
														</div>
													</td>
													<td><s:property value="customerId" /></td>
													<td><s:property value="fullName" /></td>
													
													<td><s:property value="address1" /></td>

                                                    <td><s:property value="city" /></td>
													<td><s:property value="phoneNo" /></td>
													<td><s:property value="mobileNo" /></td>
													<td><s:property value="state" /></td>
													<td><s:property value="creationDate" /></td>

													
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
	</script>
	<script src="assets/js/style-switcher.min.js"></script>
</body>
</html>