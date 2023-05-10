<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%-- <%@taglib uri="/struts-jquery-tags" prefix="sj"%> --%>

<style>
#purchaseId,#company,#invoiceNo,#materialCode,#dealerNameId,#dp3
	{
	display: none;
}
</style>

<script type="text/javascript">
	 function showElements() {

		var selectedIndex = document.getElementById('advancePurchaseCementSearch');

		var element1 = document.getElementById('purchaseId');
		var element2 = document.getElementById('company');
		var element3 = document.getElementById('invoiceNo');
		var element4 = document.getElementById('materialCode');
		var element5 = document.getElementById('dealerNameId');
		var element6 = document.getElementById('dp3');

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
			

		}  else if (selectedIndex.value == 6) {
			element1.style.display = 'none';
			element2.style.display = 'none';
			element3.style.display = 'none';
			element4.style.display = 'none';
			element5.style.display = 'none';
			element6.style.display = 'block';
		}
	} 
</script>
<body >
	<div id="content">
		<div class="outer">
			<div class="inner bg-light lter">

				<!--Begin Datatables-->
				<div class="row">
					<div class="col-lg-12">
						<ol class="breadcrumb" style="margin-top: 10px;">
							<li><a href="omiInnerDashboard.action"><i
									class="fa fa-home"></i></a></li>
							<li class="active"><s:text name="Purchase"></s:text></li>
							<li class="active"><s:text
									name="Purchase Cement"></s:text></li>
						</ol>
						<div class="box">
							<header>
								<div class="pull-left">
									<a class="icons" href="dashboard.action" data-toggle="tooltip"
										data-original-title="Back To DashBoard"> <i
										class="fa fa-table"></i>
									</a>

									<h5 class="header_color">
										<s:text name="Purchase Cement DashBoard"></s:text>
									</h5>
								</div>
								<div class="pull-right">
									<div class="btn-group">
										<a href="addNewPurchase" data-toggle="tooltip"
											data-original-title="AddNewPurchase"
											class="btn btn-primary btnheight"><i
											class="fa fa-plus fontawesomeht ">&nbsp;<s:text
													name="AddNewPurchase"></s:text></i></a>
										<button type="button" class="btn btn-info "
											data-toggle="collapse" data-target="#collapse1">
											<i class="fa fa-filter"></i> Filter
										</button>
										<a class="btn btn-success btnheight" data-toggle="tooltip"
											data-original-title="Refresh" href="purchaseDashbord.action"><i
											class="fa fa-refresh "></i></a> <a
											href="purchaseCementExcelReport.action" type="button"
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
													<s:text name="you can manage purchase cement from here" />
												</div>
											</div>
										</s:else>
									</p>
								<div id="collapse1" class="panel-collapse collapse">
										<div class="row searchBar">
											 <s:form name="purchaseAdvanceSearchForm" method="POST"
												action="populatePurchaseCementDetailsAsPerSearch">
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
														<s:select list="purchaseCementSearchList" headerKey="-1"
															onchange="showElements();" id="advancePurchaseCementSearch"
															headerValue="Select Search Type" cssClass="form-control"
															name="searchId"></s:select>
														<div id='purchaseAdvanceSearchForm_searchId_errorloc'
															class="error_strings"></div>
													</div>
													<div class="col-lg-4  col-md-4  col-sm-12 col-xs-12">
														<div class="input-group">
															<s:textfield cssClass="form-control" id="purchaseId"
																name="purchaseId" placeholder="Purchase ID" />

															<s:textfield cssClass="form-control" id="company"
																name="companyName" placeholder="Company Name" />


                                                  <s:textfield cssClass="form-control" id="invoiceNo"
																name="invoiceNo" placeholder="Invoice No" />
																
																<s:textfield cssClass="form-control" id="materialCode"
																name="materialCode" placeholder="Material Code" />
																
																
															<%-- <s:select list="productNameList" headerKey="-1"
																headerValue="Select Product"
																cssClass="form-control chzn-select" name="productName"
																id="productName"></s:select> --%>
															<s:select list="dealerList" headerKey="-1"
																headerValue="Select Dealer"
																cssClass="form-control chzn-select" name="dealerName"
																id="dealerNameId"></s:select>

															<%-- <s:select list="productCategoryList" headerKey="-1"
																id="productCategory1"
																headerValue="Select Product Category"
																cssClass="form-control chzn-select "
																name="productCategory"></s:select> --%>
															
															
																 <s:textfield cssClass="form-control" id="dp3"
																placeholder="Invoice Date" name="invoiceDate"/>
																

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
												<th style="width: 5%;"><s:text
														name="product.dashboard.action"></s:text></th>
												<th><s:text name="Purchase Id"></s:text></th>
												<th><s:text name="Company"></s:text></th>
												<th><s:text name="Material Code"></s:text></th>
												<th><s:text name="Invoice No"></s:text></th>
												<th><s:text name="Invoice Date"></s:text></th>
												<th><s:text name="Dealer Name"></s:text></th>
												<th><s:text name="Price"></s:text></th>
												<th><s:text name="Quantity(Bags)"></s:text></th>
												<th><s:text name="Amount"></s:text></th>


											</tr>
										</thead>
										<tbody>
											<s:iterator value="cementPurchaseList">
												<tr>
													<td align="center">
														<div class="btn-group">
															<a id="view"
																href="viewCementPurchaseDetails.action?command=<s:property value='purchaseId' />"
																data-toggle="tooltip" data-original-title="View"
																data-placement="bottom"> <i class="fa fa-eye"></i>
															</a>
														</div>
														<div class="btn-group">
															<a id="edit" href="editPurchaseDetail.action?command=<s:property value='purchaseId' />"
																data-toggle="tooltip" data-original-title="Edit"
																data-placement="bottom"> <i class="fa fa-edit"></i>
															</a>
														</div>
														<div class="btn-group">
															<a id="delete" href="#"
																onclick="confirmDelete('deleteCementPurchaseDetails.action?command='+<s:property value='purchaseId'/>)"
																data-toggle="tooltip" data-original-title="Delete"
																data-placement="bottom"> <i class="fa fa-trash-o"></i>
															</a>
														</div>
													</td>

													<td><a style="color: blue"
														href="viewProductDetails?command=<s:property value='purchaseId' />"><s:property
																value='purchaseId'/></a></td>
													<td><s:property value="companyName"/></td>
													<td><s:property value="materialCode"/></td>
													<td><s:property value="invoiceNo"/></td>
													<td><s:property value="invoiceDate"/></td>
													<td><s:property value="dealerName"/></td>
													<td><s:property value="unitPrice"/></td>
													<td><s:property value="quantity"/></td>
													<td><s:property value="netAmount"/></td>
													

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
		/* function validate() {
			var frmvalidator = new Validator("productDashboardSearchForm");
			frmvalidator.EnableOnPageErrorDisplay();
			frmvalidator.EnableMsgsTogether();

		 frmvalidator.addValidation("searchId", "dontselect=-1",
					"Select Search Type");
			var selectedIndex = document.getElementById('advanceProductSearch');

			if (selectedIndex.value == 1) {
				frmvalidator.addValidation("productId", "req", "Enter Product Id");
			} else if (selectedIndex.value == 2) {
				frmvalidator.addValidation("productName", "dontselect=-1",
						"Select Product Name");
			} else if (selectedIndex.value == 3) {
				frmvalidator.addValidation("productCategory", "dontselect=-1",
						"Select Product Category");
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
		} */
		
		function confirmDelete(url) {
			if (confirm("Are you sure you want to delete?")) {
				document.location = url;
			}

		}
	
	</script>
</body>
							