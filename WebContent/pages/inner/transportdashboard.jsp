<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="/struts-tags" prefix="s"%>
    <%-- <%@taglib uri="/struts-jquery-tags" prefix="sj"%>  --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
							<li class="active"><s:text name="Transport"></s:text></li>
							<li class="active"><s:text
									name="Transport Dashboard"></s:text></li>
						</ol>
						<div class="box">
							<header>
								<div class="pull-left">
									<a class="icons" href="dashboard.action" data-toggle="tooltip"
										data-original-title="Back To DashBoard"> <i
										class="fa fa-table"></i>
									</a>

									<h5 class="header_color">
										<s:text name="Transport Dashboard"></s:text>
									</h5>
								</div>
								<div class="pull-right">
									<div class="btn-group">
										<a href="addNewTransport" data-toggle="tooltip"
											data-original-title="New Trransport"
											class="btn btn-primary btnheight"><i
											class="fa fa-plus fontawesomeht ">&nbsp;<s:text
													name="New Transport"></s:text></i></a>
										
										<button type="button" class="btn btn-info "
											data-toggle="collapse" data-target="#collapse1">
											<i class="fa fa-filter"></i> Filter
										</button>
										
										<a class="btn btn-success btnheight" data-toggle="tooltip"
											data-original-title="Refresh" href="transportDashboardAction"><i
											class="fa fa-refresh "></i></a> 
											<a
											href="transportExcelReport" type="button"
											data-toggle="tooltip" data-original-title="XLS Report"
											class="btn btn-default btnheight"><i
											class="fa fa-file-excel-o fontawesomeht"></i></a> 
											
											<a href=""
											data-toggle="tooltip" data-original-title="Settings"
											type="button" class="btn btn-warning btnheight"><i
											class="fa fa-gear fontawesomeht "></i></a> <a
											href="transportDashboardAction" data-toggle="tooltip"
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
													<s:text name="you can add transport here" />
												</div>
											</div>
										</s:else>
									</p>
									
									
									
									<table id="dataTable"
										class="table table-bordered table-condensed table-hover table-striped">
										<thead>
											<tr id="myrow">
												<th style="width: 5%;"><s:text
														name="Action"></s:text></th>

												<th><s:text name="Transport Id"></s:text></th>
												<th><s:text name="Transport Name"></s:text></th>
												<th><s:text name="Truck Number "></s:text></th>
												<th><s:text name="Contact Number"></s:text></th>
												<th><s:text name="Creation Date"></s:text></th>
												<th><s:text name="City"></s:text></th>


											</tr>
										</thead>
										<tbody>
											<s:iterator value="transportDetailsList">
												<tr>
													<td align="center">
														 <div class="btn-group">
															<a id="view"
																href="viewTransport?command=<s:property value='transportId' />"
																data-toggle="tooltip" data-original-title="View"
																data-placement="bottom"> <i class="fa fa-eye"></i>
															</a>
														</div>
														
				 										
														
														<div class="btn-group">
															<a id="edit"
																href="editTransport?command=<s:property value='transportId' />"
																data-toggle="tooltip" data-original-title="Edit"
																data-placement="bottom"> <i class="fa fa-edit"></i>
															</a>
														</div>
														<div class="btn-group">
															<a id="delete" href="#"
																onclick="confirmDelete('deleteTransportDetail?command='+<s:property value='transportId'/>)"
															data-toggle="tooltip" data-original-title="Delete"
																data-placement="bottom"> <i class="fa fa-trash-o"></i>
															</a>
																
														</div>
													</td>

													<%-- <td><a style="color: blue"
														href="viewProductDetails?command=<s:property value='productId' />"><s:property
																value='productId' /></a></td>
													 --%>			
													<td><s:property value="transportId" /></td>
													<td><s:property value="transportName" /></td>
													<td><s:property value="truckNumber" /></td>
													<td><s:property value="creationDate" /></td>
													<td><s:property value="contactNumber" /></td>
													<td><s:property value="city" /></td>
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

</body>



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
			var frmvalidator = new Validator("productDashboardSearchForm");
			frmvalidator.EnableOnPageErrorDisplay();
			frmvalidator.EnableMsgsTogether();
			
		}
		

		function confirmDelete(url) {
			if (confirm("Are you sure you want to delete?")) {
			
				document.location = url;
			}	
}


</script>
         







</html>