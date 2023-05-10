<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="/struts-jquery-tags" prefix="sj"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<script>
	function PopupCenter(pageURL, title, w, h) {
		var left = (screen.width / 2) - (w / 2);
		var top = (screen.height / 2) - (h / 2);
		var targetWin = window
				.open(
						pageURL,
						title,
						'toolbar=no, location=no, directories=no, status=no, menubar=no, scrollbars=no, resizable=no, copyhistory=no, width='
								+ w
								+ ', height='
								+ h
								+ ', top='
								+ top
								+ ', left=' + left);
	}
</script>

<style type="text/css">
.error_strings {
	color: red;
}
</style>
<script type="text/javascript" src="inner/assets/js/modal.js"></script>
<script type="text/javascript">
	var xmlhttp;
	if (window.XMLHttpRequest) {
		xmlhttp = new XMLHttpRequest();
	} else {
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}

	/* This function will insert the social site value into database */
	function addSocialSite() {

		var socialSiteId = document.getElementById("addSocialSite1").value;
		var socialSiteValue = document.getElementById("socialId").value;

		/* alert(socialSiteId);
		alert(socialSiteValue); */
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				document.insertSocialSite("server1Response").innerHTML = xmlhttp.responseText;
			}
		};
		xmlhttp.open("GET", "addSocialSiteAction.action?socialSiteId="
				+ socialSiteId + "&socialSiteValue=" + socialSiteValue, true);
		xmlhttp.send();
	}
</script>





<!-- Script for ajax call for email or mobile no -->
<script type="text/javascript">
	var xmlhttp;
	if (window.XMLHttpRequest) {
		xmlhttp = new XMLHttpRequest();
	} else {
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}

	/* This function will check the existing email id */
	function isEmailIdExist(companyEmailId) {
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				document.getElementById("server1Response").innerHTML = xmlhttp.responseText;
			}
		};
		xmlhttp.open("GET", "isEmailIdExists.action?companyEmailId="
				+ companyEmailId, true);
		xmlhttp.send();

		xmlhttp.open("GET", "isEmailIdExists.action?companyEmailId="
				+ companyEmailId, true);
		xmlhttp.send();

	}

	/* this method is used to calculate Amount for first row */
	function calculateAmount() {

		var amountForA = document.getElementById("totalAmountA").value;
		var amountForB = document.getElementById("totalAmountB").value;

		amountTotal = amountForA + amountForB;
		alert("amount=" + amountTotal);

	}
</script>


<!-- / Script for ajax call for email or mobile no -->


<sj:head />
<body>

	<div id="content">
		<div class="outer">
			<div class="inner bg-light lter">

				<!--BEGIN INPUT TEXT FIELDS-->
				<div class="row">
					<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
						<ol class="breadcrumb" style="margin-top: 10px;">
							<li><a href="#"><s:text name="new.monthly.expenses.home" /></a></li>
							<li><a href="expensesDasbord.action"><s:text
										name="Expenses"></s:text> </a></li>

							<li class="active"><s:text
									name="new.monthly.expenses.monthly.expenses" /></a></li>
						</ol>
						<div class="box dark">
							<header>
							<div class="pull-left">



								<a class="icons" href="expensesDasbord.action"
									data-toggle="tooltip"
									data-original-title="Back To Expenses DashBoard"
									style="color: black;"> <i class="fa fa-th-large"></i>
								</a>
								<h5 class="header_color">
									<s:text name="Monthly Expenses" />
								</h5>
							</div>


							<div class="pull-right">
								<div class="btn-group">
									<a class="btn btn-default btnheight" data-toggle="tooltip"
										data-original-title="Help"><i class="fa fa-question"></i>
										<s:text name="project.form.button.help"></s:text> </a>
									<button type="submit" data-toggle="tooltip"
										data-original-title="Save" class="btn btn-primary btnheight">
										<i class="fa fa-check"></i>
										<s:text name="project.form.button.save"></s:text>
									</button>
									<a href="editExpensesMonthly.action" data-toggle="tooltip"
										data-original-title="Refresh"
										class="btn btn-success btnheight"><i
										class="fa fa-refresh "></i></a> <a href="expensesDasbord.action"
										data-toggle="tooltip" data-original-title="Close"
										class="btn btn-danger btnheight"><i
										class="fa fa-times fontawesomeht"></i></a>
								</div>

							</div>

							</header>
							<!-- addExpensesMonthlyDetails.action -->

							<s:form action="updateExpensesMonthlyDetail" method="POST"
								name="expensesMonthlyForm">
								<s:iterator value="ExpensesMonthlyVO">
									<div class="container-fluid">
										<div class="container-fluid">

											<div class="alert alert-info" role="alert"
												style="margin-top: 25px; margin-left: 5px; margin-right: 5px;">

												<p>
													<s:if test="hasActionErrors()">
													</s:if>
													<s:elseif test="hasActionMessages()">
														<s:actionmessage />
													</s:elseif>
													<s:else>

														<div class="infoIcon">
															<span class="fa fa-info" style="margin-left: 3px;"></span>
														</div>&nbsp;&nbsp;&nbsp;<s:text name="You can edit expenses " />
													</s:else>
												</p>
											</div>


											<div class="panel panel-default">
												<div class="panel-body">



													<div class="row">
														<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
															<div class="row form-group">
																<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
																	<s:text name="new.monthly.expenses.name" />
																	<div class="star">*</div>
																</div>

																<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">

																	<s:textfield type="text" name="name"
																		class="form-control" cssClass="form-control"
																		tabindex="1" />
																	<div id='expensesMonthlyForm_name_errorloc'
																		class="error_strings"></div>
																</div>
															</div>
														</div>
														<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
															<div class="row form-group">
																<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
																	<s:text name="new.monthly.expenses.place.of.visit" />
																	<div class="star">*</div>
																</div>

																<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">

																	<s:textfield type="text" name="placeOfVisit"
																		class="form-control" cssClass="form-control"
																		tabindex="2" />
																	<div id='expensesMonthlyForm_placeOfVisit_errorloc'
																		class="error_strings"></div>
																</div>
															</div>
														</div>

													</div>



													<div class="row">

														<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
															<div class="row form-group">
																<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
																	<s:text name="new.monthly.expenses.purpose.of.visit" />

																</div>

																<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
																	<s:textfield type="text" name="purposeOfVisit"
																		cssClass="form-control" tabindex="3" />
																	<div id='expensesMonthlyForm_purposeOfVisit_errorloc'
																		class="error_strings"></div>
																</div>
															</div>

														</div>

														<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
															<div class="row form-group">
																<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
																	<s:text name="new.monthly.expenses.departure.date" />

																</div>

																<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
																	<sj:datepicker name="departureDate" changeMonth="true"
																		changeYear="true" showAnim="slideDown" duration="fast"
																		yearRange="1950:2050" showOn="focus" size="35%"
																		timepicker="true" timepickerShowSecond="true"
																		timepickerFormat="hh:mm:ss" displayFormat="yy-mm-dd"
																		parentTheme="simple" cssClass="form-control"
																		tabindex="4" />
																</div>
															</div>
														</div>



													</div>


													<div class="row">

														<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
															<div class="row form-group">
																<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
																	<s:text name="new.monthly.expenses.arrival.Date" />

																</div>

																<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
																	<sj:datepicker name="arrivalDate" changeMonth="true"
																		changeYear="true" showAnim="slideDown" duration="fast"
																		yearRange="1950:2050" showOn="focus" size="35%"
																		timepicker="true" timepickerShowSecond="true"
																		timepickerFormat="hh:mm:ss" displayFormat="yy-mm-dd"
																		parentTheme="simple" cssClass="form-control"
																		tabindex="5" />
																</div>
															</div>
														</div>


														<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
															<div class="row form-group">
																<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
																	<s:text name="new.monthly.expenses.approved.by" />

																</div>

																<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
																	<s:select list="customerNameList" headerKey="-1"
																		headerValue="Approved By" id="leadStatus"
																		cssClass="form-control" tabindex="6" chzn-select=""
																		name="approvedBy"></s:select>
																</div>
															</div>
														</div>

													</div>
													
													<div class="row">


														<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
															<div class="row form-group">
																<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
																	<s:text name="Claimed Status" />
																	<div class="star">*</div>
																</div>

																<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
																	<s:select list="expensesClaimStatus" headerKey="-1"
																		headerValue="Select Claimed Status" id="claimStatus"
																		cssClass="form-control chzn-select" name="claimStatus"></s:select>
																</div>
															</div>
														</div>

														<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
															<div class="row form-group">
																<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
																	<s:text name="Comment." />

																</div>

																<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">

																	<s:textarea type="text" name="comment"
																		class="form-control" cssClass="form-control"
																		tabindex="1" />
																	<div id='addCreatedLeadForm_leadDate_errorloc'
																		class="error_strings"></div>
																</div>
															</div>
														</div>

													</div>

												</div>
											</div>

											<div class="panel-group" id="accordion" role="tablist"
												aria-multiselectable="true">
												<div class="panel panel-default">
													<div class="panel-heading" role="tab" id="headingOne">
														<div class="row">
															<div class="col-md-11">
																<h4 class="panel-title">
																	<a data-toggle="collapse" data-parent="#accordion"
																		href="#collapseOne" aria-expanded="true"
																		aria-controls="collapseOne"> A . Monthly Travel
																		Expenses Details </a>
																</h4>
															</div>
															<div class="col-md-1">
																
															</div>
														</div>
													</div>
													<div id="collapseOne" class="panel-collapse collapse in"
														role="tabpanel" aria-labelledby="headingOne">
														<div class="panel-body">
															<table id="dataTable"
																class="table table-bordered table-condensed table-hover table-striped">

																<thead>
																	<tr id="myrow">
																	<%-- 	<th><s:text name="Action."></s:text></th> --%>
																	<%-- 	<th><s:text name="Id."></s:text></th> --%>
																		<th><s:text name="Departure Place."></s:text></th>
																		<th><s:text name="Departure Date."></s:text></th>
																		<th><s:text name="From."></s:text></th>
																		<th><s:text name="To."></s:text></th>
																		<th><s:text name="Travel Mode."></s:text></th>
																		<th><s:text name="Amount."></s:text></th>


																	</tr>
																</thead>
																<tbody>
																	<s:iterator value="travelMonthlyDataListByMonthlyClaimId">
																		<tr>
																			<%-- <td align="center">
																				


																				<div class="btn-group">
																					<a id="edit"
																						href="editTravelClaim.action?command=<s:property value='travelClaimId' />"
																						data-toggle="tooltip" data-original-title="Edit" data-toggle="modal" data-target="#myModal"
																						data-placement="bottom"  > <i class="fa fa-edit"></i>
																					</a>
																				</div>


																				<div class="btn-group">
																					<a id="delete" href="login.html"
																						data-toggle="tooltip" data-original-title="Delete"
																						data-placement="bottom"> <i
																						class="fa fa-trash-o"></i>
																					</a>
																				</div>
																			</td> --%>
																<%-- 			<td><s:property value="travelClaimId" /></td> --%>
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
															<!-- Modal1 -->

															<hr>
															<div class="row">
																<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">

																	<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">


																	</div>
																	<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
																		<h5>
																			<b>Total (A)</b>
																		</h5>
																	</div>
																	<s:iterator value="ExpensesMonthlyVO">
																		<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">

																			<s:textfield type="text" name="totalAmountA"
																				class="form-control" cssClass="form-control"
																				onblur="display1()" id="name1" />

																			<div id='addCreatedLeadForm_leadDate_errorloc'
																				class="error_strings"></div>

																		</div>
																	</s:iterator>

																</div>
															</div>
														</div>
													</div>
												</div>
											</div>




											<div class="panel panel-default">
												<div class="panel-heading" role="tab" id="headingTwo">
													<div class="row">
														<div class="col-md-11">
															<h4 class="panel-title">
																<a class="collapsed" data-toggle="collapse"
																	data-parent="#accordion" href="#collapseTwo"
																	aria-expanded="true" aria-controls="collapseTwo">
																	B. Other Expenses</a>
															</h4>
														</div>
														<div class="col-md-1">
															
														</div>
													</div>
												</div>

												<div id="collapseOne" class="panel-collapse collapse in"
													role="tabpanel" aria-labelledby="headingOne">
													<div class="panel-body">
														<table id="dataTable"
															class="table table-bordered table-condensed table-hover table-striped">

															<thead>
																<tr id="myrow">
																	<%-- <th><s:text name="Action."></s:text></th> --%>
																	<th><s:text name="Date and Time."></s:text></th>
																	<th><s:text name="Place."></s:text></th>
																	<th><s:text name="Items."></s:text></th>
																	<th><s:text name="Amount."></s:text></th>

																</tr>
															</thead>

															<tbody>
																<s:iterator value="travelOtherDataListByMonthlyClaimId">
																	<tr>

																		<%-- <td align="center">
																			


																			<div class="btn-group">
																				<a id="edit"
																					href="editLead.action?command=<s:property value='leadId' />"
																					data-toggle="tooltip" data-original-title="Edit"
																					data-placement="bottom"> <i class="fa fa-edit"></i>
																				</a>
																			</div>


																			<div class="btn-group">
																				<a id="delete" href="login.html"
																					data-toggle="tooltip" data-original-title="Delete"
																					data-placement="bottom"> <i
																					class="fa fa-trash-o"></i>
																				</a>
																			</div>
																		</td> --%>

																		<td><s:property value="dateAndTime" /></td>
																		<td><s:property value="place" /></td>
																		<td><s:property value="items" /></td>
																		<td><s:property value="amount" /></td>




																	</tr>
																</s:iterator>
															</tbody>
														</table>



														<hr>
														<div class="row">
															<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 ">

																<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">

																</div>
																<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
																	<h5>
																		<b>Total (B)</b>
																	</h5>
																</div>
																<s:iterator value="ExpensesMonthlyVO">
																	<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">

																		<s:textfield type="text" name="totalAmountB"
																			class="form-control" cssClass="form-control"
																			onblur="display1()" id="name2" />
																		<div id='addCreatedLeadForm_leadDate_errorloc'
																			class="error_strings"></div>

																	</div>
																</s:iterator>
															</div>
														</div>
													</div>


												</div>
											</div>
										</div>


										<!-- Third tab ********************************************************************************************************************** -->

										<div class="row"
											style="margin-left: 30px; margin-right: 30px;">

											<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">

												<b><s:text name=" C. Advance(C)" /></b>
											</div>
											<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3">
												<h5>
													<b><s:text name="Total Advance(C) [IF ANY] " /> &nbsp;
														(&nbsp;<span class="fa fa-rupee "></span>&nbsp;) </b>
												</h5>
											</div>
											<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
												<s:textfield type="text" name="advanceAmountC"
													class="form-control " cssClass="form-control" tabindex="18"
													onblur="display1()" id="name3" />
												<div id='addCreatedLeadForm_leadDate_errorloc'
													class="error_strings"></div>
											</div>
										</div>
										<br>
										<div class="row"
											style="margin-left: 30px; margin-right: 30px;">
											<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6"></div>

											<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3">
												<h5>
													<b><s:text name="Total Claim Balance=(A+B)-C" /></b>
												</h5>
											</div>

											<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3">
												<s:textfield type="text" name="claimedBalance"
													class="form-control " cssClass="form-control" tabindex="18"
													onblur="display1()" id="name3" />
												<div id='addCreatedLeadForm_leadDate_errorloc'
													class="error_strings"></div>
											</div>
										</div>

										<br>
									</div>

									<hr>
									<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"></div>


									<div class="row">
										<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"
											align="center">
											<a href="leadDashboard.action" data-toggle="tooltip"
												data-original-title="Back To Lead DashBoard"
												class="btn btn-default" ontheme="simple" tabindex="19"><s:text
													name="project.form.button.cancel" /> </a>

											<s:reset cssClass="btn btn-success"
												key="project.form.button.reset" theme="simple"
												onclick="window.location.reload();" tabindex="20" />

											<s:submit cssClass="btn btn-primary"
												key="project.form.button.submit" theme="simple"
												tabindex="21" />

										</div>
									</div>
								</s:iterator>
							</s:form>

						</div>


					</div>


					<div class="modal fade" id="myModal" role="dialog">
						<div class="modal-dialog modal-md">
							<div class="modal-content">
								<div class="modal-header"
									style="color: gray; background-color: #F8F8F8;">
									<button type="button" class="close" data-dismiss="modal"
										style="color: red; margin-top: -30px;">
										<h1>&times;</h1>
									</button>
									<h4 class="modal-title" style="color: gray;">A .Monthly
										Travel Expenses Details</h4>
								</div>
								<div class="modal-body" style="color: gray;">
									<p>

										<s:form name="monthlyTravelForm"
											action="addMonthlyTravelDetail" method="post">
											<div class="row" style="padding: 10px; margin-top: -20px;">
												<label for="Departureplace">Departure Place</label>
												<s:textfield type="text" name="departurePlace"
													cssClass="form-control" tabindex="3"
													placeholder="Departure Place" />
												<div id='monthlyTravelForm_departurePlace_errorloc'
													class="error_strings"></div>
											</div>



											<div class="row" style="padding: 10px;">
												<label for="Departuredate">Departure Date</label>
												<sj:datepicker name="departureDate" changeMonth="true"
													changeYear="true" showAnim="slideDown" duration="fast"
													yearRange="1950:2050" showOn="focus" size="35%"
													timepicker="true" timepickerShowSecond="true"
													timepickerFormat="hh:mm:ss" displayFormat="yy-mm-dd"
													parentTheme="simple" cssClass="form-control" tabindex="4"
													placeholder="Departure Date" />
											</div>

											<div class="row" style="padding: 10px;">
												<label for="From">From</label>
												<s:textfield type="text" name="fromPlace"
													cssClass="form-control" tabindex="3" placeholder="From" />
												<div id='monthlyTravelForm_fromPlace_errorloc'
													class="error_strings"></div>
											</div>

											<div class="row" style="padding: 10px;">
												<label for="To">To</label>
												<s:textfield type="text" name="toPlace"
													cssClass="form-control" tabindex="3" placeholder="To" />
												<div id='monthlyTravelForm_toPlace_errorloc'
													class="error_strings"></div>
											</div>


											<div class="row" style="padding: 10px;">
												<label for="From">Travel Mode</label>
												<s:select list="travelModeList" cssClass="form-control"
													tabindex="3" placeholder="Travel Mode" name="travelMode"
													headerKey="-1" headerValue="Travel Mode" />
											</div>

											<div class="row" style="padding: 10px;">
												<label for="To">Amount</label>&nbsp; (&nbsp;<span
													class="fa fa-rupee "></span>&nbsp;)
												<s:textfield type="text" name="amount"
													cssClass="form-control" tabindex="3" placeholder="Amount" />
												<div id='monthlyTravelForm_toPlace_errorloc'
													class="error_strings"></div>
											</div>



											<hr>
											<div class="row" style="margin-top: 30px;">
												<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"
													align="center">
													<a href="#" data-toggle="tooltip" data-dismiss="modal"
														data-original-title="Cancel"
														class="btn btn-default btnheight"><i
														class="fa fa-caret-square-o-left fontawesomeht"></i> <s:text
															name="project.form.button.cancel"></s:text></a>
													<button type="submit" data-toggle="tooltip"
														data-original-title="Save"
														class="btn btn-primary btnheight">
														<i class="fa fa-check"></i>
														<s:text name="project.form.button.save"></s:text>
													</button>

												</div>
											</div>


										</s:form>
								</div>
								</p>
							</div>

						</div>
					</div>
				</div>

				<!--  ********************** Model 2 **************************** -->


				<div class="modal fade" id="myModal1" role="dialog">
					<div class="modal-dialog modal-md">
						<div class="modal-content">
							<div class="modal-header"
								style="color: gray; background-color: #F8F8F8;">
								<button type="button" class="close" data-dismiss="modal"
									style="color: red; margin-top: -20px;">
									<h1>&times;</h1>
								</button>
								<h5 class="modal-title" style="color: gray;">B. Other
									Expenses</h5>
							</div>
							<div class="modal-body" style="color: gray;">
								<p>
									<!-- .do?expencesprocessid=hotel -->
									<s:form name="monthlyOtherExpensesForm"
										action="addMonthlyOtherDetail" method="post">
										<div class="row" style="padding: 10px; margin-top: -30px">


											<div class="row" style="padding: 10px;">
												<label for="From">Date & Time</label>
												<sj:datepicker name="dateAndTime" changeMonth="true"
													changeYear="true" showAnim="slideDown" duration="fast"
													yearRange="1950:2050" showOn="focus" size="35%"
													timepicker="true" timepickerShowSecond="true"
													timepickerFormat="hh:mm:ss" displayFormat="yy-mm-dd"
													parentTheme="simple" cssClass="form-control" tabindex="4"
													placeholder="Date & Time" />
											</div>

											<div class="row" style="padding: 10px;">
												<label for="From">Place</label>
												<s:textfield type="text" name="place"
													cssClass="form-control" tabindex="3" placeholder="Place" />
											</div>
											<div id='monthlyOtherExpensesForm_place_errorloc'
												class="error_strings"></div>


											<div class="row" style="padding: 10px;">
												<label for="From">Items</label>
												<s:textfield type="text" name="items"
													cssClass="form-control" tabindex="3" placeholder="Items" />
											</div>
											<div id='monthlyOtherExpensesForm_items_errorloc'
												class="error_strings"></div>

											<div class="row" style="padding: 10px;">
												<label for="To">Amount</label>&nbsp; (&nbsp;<span
													class="fa fa-rupee "></span>&nbsp;)
												<s:textfield type="text" name="amount"
													cssClass="form-control" tabindex="3" placeholder="Amount" />
												<div id='monthlyTravelForm_toPlace_errorloc'
													class="error_strings"></div>
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


													<button type="submit" data-toggle="tooltip"
														data-original-title="Save"
														class="btn btn-primary btnheight">
														<i class="fa fa-check"></i>
														<s:text name="project.form.button.save"></s:text>
													</button>

												</div>
											</div>
										</div>
									</s:form>



								</p>
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
	</div>
	<script type="text/javascript">
		function display1() {

			var a = document.getElementById("name1").value;

			var b = document.getElementById("name2").value;
			var c = document.getElementById("name3").value;
			var d = Number(a) + Number(b) - Number(c);

			document.getElementById("name4").value = d;
		}
	</script>


	<script>
		$(function() {
			Metis.formGeneral();
			Metis.formWysiwyg();
		});
	</script>
	<script src="/outer/js/gen_validatorv4.js" type="text/javascript"></script>
	<script type="text/javascript">
		var frmvalidator = new Validator("expensesMonthlyForm");
		frmvalidator.EnableOnPageErrorDisplay();
		frmvalidator.EnableMsgsTogether();

		//Validation for  Name. 
		frmvalidator.addValidation("name", "req", "Please enter the name");

		//Validation for Name.
		frmvalidator.addValidation("name", "minlen=3",
				"Minimum length of 3 digits");
		frmvalidator.addValidation("name", "maxlen=100",
				"Maximum length of 100");

		//Validation for Place of Visit. 
		frmvalidator.addValidation("placeOfVisit", "req",
				"Please enter the Place of Visit");

		var frmvalidator = new Validator("monthlyTravelForm");
		frmvalidator.EnableOnPageErrorDisplay();
		frmvalidator.EnableMsgsTogether();

		//Validation Departure Place.
		frmvalidator.addValidation("departurePlace", "req",
				"Please enter the Departure Place");

		//Validation for From Place. 
		frmvalidator.addValidation("fromPlace", "req",
				"Please enter the From Place");

		//Validation for To Place. 
		frmvalidator.addValidation("toPlace", "req",
				"Please enter the To Place");

		//Validation for Amount. 
		frmvalidator.addValidation("amount", "req", "Please enter Amount");

		var frmvalidator = new Validator("monthlyOtherExpensesForm");
		frmvalidator.EnableOnPageErrorDisplay();
		frmvalidator.EnableMsgsTogether();

		//Validation for Place.
		frmvalidator.addValidation("place", "req", "Please enter the Place");

		//Validation for Items. 
		frmvalidator.addValidation("items", "req", "Select Items");

		//validation for Amount. 
		frmvalidator.addValidation("amount", "req", "Select Amount");

		//validation for Company Category. 
		frmvalidator.addValidation("companyCategory", "dontselect=-1",
				"Select Company Category");

		//validation for Company Sector. 
		frmvalidator.addValidation("companySector", "dontselect=-1",
				"Select Company Sector");

		//validation for Source Name. 
		frmvalidator.addValidation("leadSource", "dontselect=-1",
				"Select Lead Source");

		//Validation for Lead Source Name. 
		frmvalidator.addValidation("leadSourceName", "maxlen=50",
				"Lead Source Name Should Be 50 Characters");

		//Validation for Number of associates.
		frmvalidator.addValidation("noOfAssociate", "numeric",
				"Number Of Associate Must Be Digits");
		frmvalidator.addValidation("noOfAssociate", "maxlen=6",
				"No. Of Associates Should Be 6 Digits");

		//Validation for Lead Date. 
		frmvalidator.addValidation("leadDate", "req", "Select Lead Date");

		//Validation for Lead Owner. 
		frmvalidator.addValidation("leadOwnerId", "dontselect=-1",
				"Select Lead Owner");

		//validation for Address Line 1.
		frmvalidator.addValidation("addressLine1", "maxlen=100",
				"Address Line 1 Should Be 100 Characters");

		//validation for Address Line 2.
		frmvalidator.addValidation("addressLine2", "maxlen=100",
				"Address Line 2 Should Be 100 Characters");

		//validation for City.
		frmvalidator.addValidation("city", "maxlen=50",
				"City Should Be 50 Characters");

		//validation for State.
		frmvalidator.addValidation("state", "maxlen=100",
				"State Should Be 100 Characters");

		//validation for Country.
		frmvalidator.addValidation("country", "dontselect=-1",
				"Select Country Name");

		//validation for Primary Email Id. 

		frmvalidator.addValidation("primaryEmailId", "email",
				"Enter Valid Email Address");
		frmvalidator.addValidation("primaryEmailId", "maxlen=100",
				"Email Id Should Be 100 Characters");

		//validation for Alternate Email Id.
		frmvalidator.addValidation("alternateEmailId", "email",
				"Enter Valid Email Address");
		frmvalidator.addValidation("alternateEmailId", "maxlen=100",
				"Email Id Should Be 100 Characters");

		//validation for Phone Number.
		frmvalidator.addValidation("phoneNo", "maxlen=8",
				"Phone Number Should Be 8 Digits");
		frmvalidator.addValidation("phoneNo", "numeric",
				"Phone Number Must Be Digits");

		//validation for Mobile Number.
		frmvalidator.addValidation("mobileNo", "maxlen=10",
				"Mobile Number Should Be 10 Digits");
		frmvalidator.addValidation("mobileNo", "numeric",
				"Mobile Number Must Be Digits");

		//validation for Fax number.
		frmvalidator.addValidation("fax", "req", "Fax Number requeri");
		frmvalidator.addValidation("fax", "numeric",
				"Fax Number Must Be Digits");
		frmvalidator.addValidation("fax", "maxlen=8",
				"Fax Number Should Be 8 Digits");

		//validation for Mobile Number.
		frmvalidator.addValidation("requirment", "maxlen=4000",
				"Requirement Should Be 4000 Charecter");

		//lead date and expected closing date difference validation 
		function DoCustomValidation() {
			var frm1 = document.forms["addCreatedLeadForm"];
			var ndate = frm1.leadDate.value;
			var ndate1 = frm1.expectedClosingDate.value;
			var d1 = new Date(ndate); //from date yyyy-MM-dd
			var d2 = new Date(ndate1); //to date yyyy-MM-dd 
			var Months = d2.getMonth() - d1.getMonth();
			var Years = d2.getFullYear() - d1.getFullYear();
			var Days = d2.getDate() - d1.getDate();
			Months = (d2.getMonth() + 12 * d2.getFullYear())
					- (d1.getMonth() + 12 * d1.getFullYear());

			var MonthOverflow = 0;

			if (Months - (Years * 12) < 0)
				MonthOverFlow = -1;
			else
				MonthOverFlow = 1;
			if (MonthOverFlow < 0)
				Years = Years - 1;
			Months = Months - (Years * 12);
			var LastDayOfMonth = new Date(d2.getFullYear(), d2.getMonth() + 1,
					0, 23, 59, 59);
			LastDayOfMonth = LastDayOfMonth.getDate();
			if (MonthOverFlow < 0 && (d1.getDate() > d2.getDate())) {
				Days = LastDayOfMonth + (d2.getDate() - d1.getDate()) - 1;
			} else
				Days = d2.getDate() - d1.getDate();
			if (Days < 0)
				Months = Months - 1;
			var l = new Date(d2.getFullYear(), d2.getMonth(), 0);
			var l1 = new Date(d1.getFullYear(), d1.getMonth() + 1, 0);
			if (Days < 0) {
				if (l1 > l)
					Days = l1.getDate() + Days;
				else
					Days = l.getDate() + Days;
			}
			if (d1 <= d2) {
				return true;
			} else {

				sfm_show_error_msg(
						"Expected Closing Date Should be Greater Than Lead Date",
						frm1.expectedClosingDate);
				return false;
			}
		}

		frmvalidator.setAddnlValidationFunction(DoCustomValidation);
	</script>
	--%>
</body>
</html>