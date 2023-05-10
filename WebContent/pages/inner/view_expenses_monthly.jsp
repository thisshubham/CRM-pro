<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>

	<div class="outer">
		<div class="inner bg-light lter">
			<div class="box">
				<div class="container-fluid">
					<ol class="breadcrumb" style="margin-top: 10px;">
						<li><a href="omiInnerDashboard.action"><i
								class="fa fa-home"></i></a></li>
						<li><a href="leadDashboard.action"><s:text
									name="ExpensesMonthly"></s:text></a></li>
						<li class="active"><s:text name="ExpensesMonthlydashboard"></s:text></li>
						<li class="active"><s:text name="viewExpensesMonthly"></s:text></li>
					</ol>
					<header> <a class="icons"
						href="expensesDasbord.action" data-toggle="tooltip"
						data-original-title="Back To Expenses DashBoard"
						style="color: black;"> <i class="fa fa-th-large"></i>
					</a>
					<h5>
						<s:text name="ExpensesMonthly Details" />
					</h5>
					<div class="pull-right">
						<div class="btn-group">
					
							<a class="btn btn-default btnheight" data-toggle="tooltip"
								data-original-title="Help"><i class="fa fa-question"></i> <s:text
									name="project.form.button.help"></s:text></a> <a
								class="btn btn-primary btnheight" data-toggle="tooltip"
								data-original-title="Print"><i class="fa fa-print"></i> <s:text
									name="project.form.button.print"></s:text></a> <a
								data-toggle="tooltip" data-original-title="PDF Report"
								href="leadPrintPDF.action?command=<s:property value='leadId' />"
								class="btn btn-success btnheight"><i
								class="fa fa-file-pdf-o "></i> <s:text
									name="project.form.button.pdf"></s:text></a> <a
								data-toggle="tooltip" data-original-title="Previous Expenses"
								href="viewPreviousMonthlyExpensesInfo.action?command=<s:property value='monthlyClaimId' />"
								type="button" class="btn btn-default btnheight"><i
								class="fa fa-chevron-left fontawesomeht"></i></a> <a
								data-toggle="tooltip" data-original-title="Next Expenses"
								href="viewNextMonthlyExpensesInfo.action?command=<s:property value='monthlyClaimId' />"
								class="btn btn-default btnheight"><i
								class="fa fa-chevron-right fontawesomeht"></i></a> <a
								data-toggle="tooltip" data-original-title="Close"
								href="expensesDasbordTour.action"
								class="btn btn-danger btnheight"><i
								class="fa fa-times fontawesomeht"></i></a>
							
						</div>
					</div>
					</header>
					<div id="div-2" class="body">
						<div>
							<p>
								<s:if test="hasActionErrors()">
									<div class="alert alert-danger" role="alert"
										style="padding-bottom: 7px;">
										<div class="infoIcon">
											<!-- <i class="fa fa-times-circle "></i> -->
											<s:actionerror />
										</div>
									</div>
								</s:if>
								<s:elseif test="hasActionMessages()">
									<div class="alert alert-success" role="alert"
										style="padding-bottom: 7px;">
										<div class="infoIcon">
											<!-- <i class="fa fa-check-circle "> </i> -->
											<s:actionmessage />
										</div>
									</div>
								</s:elseif>
								<s:else>

									<div class="alert alert-info" role="alert">
										<div class="infoIcon">
											<i class="fa fa-info-circle "> <s:text
													name="you can view expenses here" /></i>
										</div>
									</div>
								</s:else>
							</p>
						</div>
						<div style="padding-left: 15px; padding-right: 15px;">
							<form class="form-horizontal" >
								<s:iterator value="ExpensesMonthlyVO" var="testObj">
									<div class="row">
										<div
											class="col-lg-12 col-md-12 col-sm-12 col-xs-12 viewinnertitle">
											<h5>
												<s:text name="Expenses Information" />
											</h5>
										</div>
									</div>


									<div class="row">
										<div class="col-md-12 col-sm-12 col-xs-12"
											id="view_lable_value">
											<div class="col-md-2 col-sm-12 col-xs-12">
												<label for="text1" class="control-label" id="viewlable">
													<s:text name="Monthly claim Id" />
												</label>
											</div>
											<div class="col-md-10 col-sm-12 col-xs-12 control-label">
												<s:property value="monthlyClaimId" />
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12 col-sm-12 col-xs-12"
											id="view_lable_value2">
											<div class="col-md-2 col-sm-12 col-xs-12">
												<label for="text1" class="control-label" id="viewlable">
													<s:text name="Name." />
												</label>
											</div>
											<div class="col-md-10 col-sm-12 col-xs-12 control-label">
												<s:property value="name" />
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12 col-sm-12 col-xs-12"
											id="view_lable_value">

											<div class="col-md-2 col-sm-12 col-xs-12">
												<label for="text1" class="control-label " id="viewlable">
													<s:text name="Place Of Visit" />
												</label>
											</div>
											<div class="col-md-10 col-sm-12 col-xs-12 control-label">
												<s:property value="placeOfVisit" />
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12 col-sm-12 col-xs-12"
											id="view_lable_value2">
											<div class="col-md-2 col-sm-12 col-xs-12">
												<label for="text1" class="control-label" id="viewlable">
													<s:text name="Purpose Of Visit" />
												</label>
											</div>
											<div class="col-md-10 col-sm-12 col-xs-12 control-label">
												<s:property value="purposeOfVisit" />

											</div>
										</div>
									</div>
									
									 <div class="row">
										<div class="col-md-12 col-sm-12 col-xs-12"
											id="view_lable_value">
											<div class="col-md-2 col-sm-12 col-xs-12">
												<label for="text1" class="control-label" id="viewlable">
													<s:text name="departure date" />
												</label>
											</div>
											<div class="col-md-10 col-sm-12 col-xs-12 control-label">
												<s:property value="departureDate" />
											</div>

										</div>
									</div>
									
									<div class="row">
										<div class="col-md-12 col-sm-12 col-xs-12"
											id="view_lable_value">
											<div class="col-md-2 col-sm-12 col-xs-12">
												<label for="text1" class="control-label" id="viewlable">
													<s:text name="Arrival date" />
												</label>
											</div>
											<div class="col-md-10 col-sm-12 col-xs-12 control-label">
												<s:property value="arrivalDate" />
											</div>

										</div>
									</div>



									<div class="row">
										<div class="col-md-12 col-sm-12 col-xs-12"
											id="view_lable_value2">
											<div class="col-md-2 col-sm-12 col-xs-12">
												<label for="text1" class="control-label" id="viewlable">
													<s:text name="Approved By" />
												</label>
											</div>
											<div class="col-md-10 col-sm-12 col-xs-12 control-label">
												<s:property value="approvedBy" />
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12  col-sm-12 col-xs-12"
											id="view_lable_value">
											<div class="col-md-2 col-sm-12 col-xs-12">
												<label for="text1" class="control-label" id="viewlable"><s:text
														name="total amountA" /></label>
											</div>
											<div class="col-md-10 col-sm-12 col-xs-12 control-label">
												<s:property value="totalAmountA" />
											</div>
										</div>
									</div>



									<div class="row">
										<div class="col-md-12  col-sm-12 col-xs-12"
											id="view_lable_value2">
											<div class="col-md-2 col-sm-12 col-xs-12">
												<label for="text1" class="control-label" id="viewlable"><s:text
														name="Total amountB" /></label>
											</div>
											<div class="col-md-10 col-sm-12 col-xs-12 control-label">
												<s:property value="totalAmountB" />
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12  col-sm-12 col-xs-12"
											id="view_lable_value">
											<div class="col-md-2 col-sm-12 col-xs-12">
												<label for="text1" class="control-label" id="viewlable"><s:text
														name="advance AmountC." /></label>
											</div>
											<div class="col-md-10 col-sm-12 col-xs-12 control-label">
												<s:property value="advanceAmountC" />
											</div>
										</div>
									</div>




									<div class="row">
										<div class="col-md-12  col-sm-12 col-xs-12"
											id="view_lable_value2">
											<div class="col-md-2 col-sm-12 col-xs-12">
												<label for="text1" class="control-label" id="viewlable"><s:text
														name="claimed Balance" /></label>
											</div>
											<div class="col-md-10 col-sm-12 col-xs-12 control-label">
												<s:property value="claimedBalance" />

											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12  col-sm-12 col-xs-12"
											id="view_lable_value">
											<div class="col-md-2 col-sm-12 col-xs-12">
												<label for="text1" class="control-label" id="viewlable"><s:text
														name="claim Status" /></label>
											</div>
											<div class="col-md-10 col-sm-12 col-xs-12 control-label">
												<s:property value="claimStatus" />

											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12  col-sm-12 col-xs-12"
											id="view_lable_value2">
											<div class="col-md-2 col-sm-12 col-xs-12">
												<label for="text1" class="control-label" id="viewlable"><s:text
														name="claim Comment" /></label>
											</div>
											<div class="col-md-10 col-sm-12 col-xs-12 control-label">
												<s:property value="claimComment" />
											</div>
										</div>
									</div>




									
								</s:iterator>
							</form>

							 <div class="row">
								<div
									class="col-lg-12 col-md-12 col-sm-12 col-xs-12 viewinnertitle">
									<h5>
										<s:text name="A .Monthly
										Travel Expenses Details" />
									</h5>
								</div>
							</div> 
							<div class="row " class="tab-pane fade" id="addSocial">
								<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"
									id="dataTable">
									<div class="table-responsive">
										<table class="table table-bordered responsive-table">
											<thead>
												<tr id="myrow">

											
													<th><s:text name="Departure Place."></s:text></th>
													<th><s:text name="Departure Date."></s:text></th>
													<th><s:text name="From."></s:text></th>
													<th><s:text name="To."></s:text></th>
													<th><s:text name="Travel Mode." /></th>
													<th><s:text name="Amount."></s:text></th>
												</tr>
											</thead>
											<tbody>
												<s:iterator value="travelMonthlyDataListByMonthlyClaimId">
													<tr>

														<td><s:property value="departurePlace" /></td>
														<td><s:property value="departureDate" /></td>
														<td><s:property value="fromPlace" /></td>
														<td><s:property value="toPlace" /></td>
														<td><s:property value="travelMode" /></td>
														<td><s:property value="amount" /></td>
													</tr>
												</s:iterator>
											</tbody>
										</table>
									</div>
								</div>
							</div> 

							 <div class="row">
								<div
									class="col-lg-12 col-md-12 col-sm-12 col-xs-12 viewinnertitle">
									<h5>
										<s:text name=" B. Other
									Expenses" />
									</h5>
								</div>
							</div> 

							 <div class="row" class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
								<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"
									id="dataTable">
									<div class="table-responsive">
										<table class="table table-bordered responsive-table">
											<thead>
												<tr id="myrow">

													
													<th><s:text name="Date and Time."></s:text></th>
													<th><s:text name="Place."></s:text></th>
													<th><s:text name="Items."></s:text></th>
													<th><s:text name="Amount."></s:text></th>
												</tr>
											</thead>
											<tbody>
												<s:iterator value="travelOtherDataListByMonthlyClaimId">
													<tr>

														<td><s:property value="dateAndTime" /></td>
														<td><s:property value="place" /></td>
														<td><s:property value="items" /></td>
														<td><s:property value="amount" /></td>
							
													</tr>
					
												</s:iterator>
											</tbody>
										</table>

									</div>
									<hr>
									<div class="row">
										<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"
											align="center">
											<a href="expensesDasbordTour.action" data-toggle="tooltip"
												data-dismiss="modal" data-original-title="Cancel"
												class="btn btn-default btnheight"><i
												class="fa fa-caret-square-o-left fontawesomeht"></i> <s:text
													name="project.form.button.cancel"></s:text></a>
											</button>

										</div>
									</div>
								</div>
							</div> 

						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>