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
<%-- <script type="text/javascript">
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
 --%>

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
							<li><a href="#"><s:text name="expenses.travel.bill.home" /></a></li>
							<li><a href="#"><s:text name="expenses.travel.bill.expenses" /></a></li>
							<li class="active"><s:text name="expenses.travel.bill.tour" /></li>
						</ol>
						<div class="box dark">
							<header>
							<div class="pull-left">



								<a class="icons" href="expensesDasbordTour.action"
									data-toggle="tooltip"
									data-original-title="Back To Expenses DashBoard"
									style="color: black;"> <i class="fa fa-th-large"></i>
								</a>
								<h5 class="header_color">
									<s:text name="expenses.travel.bill.tourexpenses" />
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
									<a href="expensesTravelBill.action" data-toggle="tooltip"
										data-original-title="Refresh"
										class="btn btn-success btnheight"><i
										class="fa fa-refresh "></i></a> <a
										href="expensesDasbordTour.action" data-toggle="tooltip"
										data-original-title="Close" class="btn btn-danger btnheight"><i
										class="fa fa-times fontawesomeht"></i></a>
								</div>

							</div>

							</header>
							<!-- addExpensesTourDetails.action -->
							<s:form action="addExpensesTourDetails.action" method="POST"
								name="expensesDetailForm">
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
													</div>&nbsp;&nbsp;&nbsp;<s:text
														name="expenses.travel.bill.Youcanaddyournewexpenses" />
												</s:else>
											</p>
										</div>


										<div class="panel panel-default">
											<div class="panel-body">



												<div class="row">
													<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
														<div class="row form-group">
															<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
																<s:text name="expenses.travel.bill.name" />
																<div class="star">*</div>
															</div>

															<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">

																<s:textfield type="text" name="name"
																	class="form-control" cssClass="form-control"
																	tabindex="1" />
																<div id='expensesDetailForm_name_errorloc'
																	class="error_strings"></div>
															</div>
														</div>
													</div>
													<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
														<div class="row form-group">
															<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
																<s:text name="expenses.travel.bill.placeofvisit" />
																<div class="star">*</div>
															</div>

															<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">

																<s:textfield type="text" name="placeOfVisit"
																	class="form-control" cssClass="form-control"
																	tabindex="2" />
																<div id='expensesDetailForm_placeOfVisit_errorloc'
																	class="error_strings"></div>
															</div>
														</div>
													</div>
												</div>


												<div class="row">

													<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
														<div class="row form-group">
															<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
																<s:text name="expenses.travel.bill.purposeofvisit" />

															</div>

															<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">



																<s:textfield type="text" name="purposeOfVisit"
																	cssClass="form-control" tabindex="3" />
																<div
																	id='addCreatedLeadForm_expectedClosingDate_errorloc'
																	class="error_strings"></div>
															</div>
														</div>
													</div>
													<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
														<div class="row form-group">
															<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
																<s:text name="expenses.travel.bill.depdate" />
																<div class="star">*</div>
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
																<s:text name="expenses.travel.bill.arrdate" />
																<div class="star">*</div>
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
																<s:text name="expenses.travel.bill.approvedby" />

															</div>

															<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
																<s:select list="customerNameList" headerKey="-1"
																	headerValue="Approved By" id="leadStatus"
																	cssClass="form-control chzn-select" name="approvedBy"></s:select>
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
																	aria-controls="collapseOne">
																	<s:text name="expenses.travel.bill.aticketfare-providedbyco/selfarrangement"/>																	
																</a>
															</h4>
														</div>
														<div class="col-md-1">
															<a data-toggle="modal" data-target="#myModal"><input
																type="button" value="Add More"
																style="background-color: #87c134;" /></a>
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
																	<%-- <th><s:text name="Action"></s:text></th> --%>
																	<th><s:text name="expenses.travel.bill.departureplace"></s:text></th>
																	<th><s:text name="expenses.travel.bill.departuredate"></s:text></th>
																	<th><s:text name="expenses.travel.bill.arrivalplace"></s:text></th>
																	<th><s:text name="expenses.travel.bill.arrivaldate"></s:text></th>
																	<th><s:text name="expenses.travel.bill.travelmode"></s:text></th>
																	<th><s:text name="expenses.travel.bill.amount"></s:text></th>

																	<!-- <th style="width: 5%;"><input type="button"
																	value="Add More" style="background-color: #87c134;" />
																	<a data-toggle="modal" data-target="#myModal"><input type="button"
																	value="Add More" style="background-color: #87c134;" /></a>
																	</th> -->
																</tr>
															</thead>
															<tbody>
																<s:iterator value="tourTicketGrid">
																	<tr>
																		<%-- <td align="center">
																			<div class="btn-group">
																				<a id="view"
																					href="viewLead?command=<s:property value='leadId'/>"
																					data-toggle="tooltip" data-original-title="View"
																					data-placement="bottom"> <i class="fa fa-eye"></i>
																				</a>
																			</div>


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
																		<td><s:property value="departurePlace" /></td>
																		<td><s:property value="departureDate" /></td>
																		<td><s:property value="arrivalPlace" /></td>
																		<td><s:property value="arrivalDate" /></td>
																		<td><s:property value="travelMode" /></td>
																		<td><s:property value="amountForA" /></td>



																	</tr>
																</s:iterator>
															</tbody>
														</table>
														<!-- Modal1 -->

														<hr>
														<div class="row">
															<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
																<div class="row form-group">
																	<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
																		<%-- <s:text name="H. Total Expenses" /> --%>
																		<div class="star"></div>
																	</div>
																	<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
																		<h5>
																			<b><s:text name="expenses.travel.bill.Total(A)"/></b>
																		</h5>
																	</div>
																	<s:iterator value="expensesVO">
																		<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">

																			<s:textfield type="text" name="totalAmountA"
																				class="form-control" cssClass="form-control" />
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


										</div>

										<div class="panel panel-default">
											<div class="panel-heading" role="tab" id="headingTwo">
												<div class="row">
													<div class="col-md-11">
														<h4 class="panel-title">
															<a class="collapsed" data-toggle="collapse"
																data-parent="#accordion" href="#collapseTwo"
																aria-expanded="true" aria-controls="collapseTwo"><s:text name="expenses.travel.bill.Bboarding&lodging-providedbyco./selfarrangement"/></a>
														</h4>
													</div>
													<div class="col-md-1">
														<a data-toggle="modal" data-target="#myModal1"><input
															type="button" value="Add More"
															style="background-color: #87c134;" /></a>
													</div>
												</div>
											</div>
											<div id="collapseTwo" class="panel-collapse collapse"
												role="tabpanel" aria-labelledby="headingTwo">
												<div class="panel-body">
													<table id="dataTable"
														class="table table-bordered table-condensed table-hover table-striped">

														<thead>
															<tr id="myrow">
															<%-- 	<th><s:text name="Action"></s:text></th> --%>
																<th><s:text name="expenses.travel.bill.hotel"></s:text></th>
																<th><s:text name="expenses.travel.bill.place"></s:text></th>
																<th><s:text name="expenses.travel.bill.from"></s:text></th>
																<th><s:text name="expenses.travel.bill.to."></s:text></th>
																<th><s:text name="expenses.travel.bill.billno"></s:text></th>
																<th><s:text name="expenses.travel.bill.amount"></s:text></th>

																<!-- <th style="width: 5%;"><input type="button"
																	value="Add More" style="background-color: #87c134;" />
																	<a data-toggle="modal" data-target="#myModal1"><input type="button"
																	value="Add More" style="background-color: #87c134;" /></a>
																	</th> -->
															</tr>
														</thead>
														<tbody>
															<s:iterator value="boardingDetailGrid">
																<tr>

																	<%-- <td align="center">
																		<div class="btn-group">
																			<a id="view"
																				href="viewLead?command=<s:property value='leadId'/>"
																				data-toggle="tooltip" data-original-title="View"
																				data-placement="bottom"> <i class="fa fa-eye"></i>
																			</a>
																		</div>


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
																	<td><s:property value="hotel" /></td>
																	<td><s:property value="place" /></td>
																	<td><s:property value="from" /></td>
																	<td><s:property value="to" /></td>
																	<td><s:property value="billNo" /></td>
																	<td><s:property value="hotelAmount" /></td>



																</tr>
															</s:iterator>
														</tbody>
													</table>


													<hr>
													<div class="row">
														<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
															<div class="row form-group">
																<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
																	<%-- <s:text name="H. Total Expenses" /> --%>
																	<div class="star"></div>
																</div>
																<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
																	<h5>
																		<b>Total (B)</b>
																	</h5>
																</div>

																<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
																	<s:iterator value="expensesVO">
																		<s:textfield type="text" name="totalAmountB"
																			class="form-control" cssClass="form-control" readonly="true"/>
																		<div id='addCreatedLeadForm_leadDate_errorloc'
																			class="error_strings"></div>
																	</s:iterator>
																</div>
															</div>
														</div>
													</div>


												</div>
											</div>
										</div>

									</div>




									<!-- Third tab ********************************************************************************************************************** -->


									<div class="panel panel-default"
										style="margin-left: 15px; margin-right: 15px;">
										<div class="panel-body">

											<div class="row">
												<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
													<div class="row form-group">
														<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
															<s:text
																name="expenses.travel.bill.Cdailyallowance(forfoodstuff)aspertravelpolicy"/>

														</div>

														<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12"></div>
														<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">

															<s:textfield type="text" name="dailyAllowance"
																class="form-control" cssClass="form-control"
																tabindex="6" onblur="display1()" id="name12" />
															<div id='addCreatedLeadForm_leadDate_errorloc'
																class="error_strings"></div>
														</div>
													</div>
												</div>
											</div>



											<div class="row">
												<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
													<div class="row form-group">
														<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
															<s:text
																name="expenses.travel.bill.dconveyanceexpenses(fillinconveyencesheet)&TaxiBillIsMust" />
															<div class="star"></div>
														</div>
														<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12"></div>

														<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">

															<s:textfield type="text" name="conveynanceExD"
																class="form-control" cssClass="form-control"
																tabindex="7" onblur="display1()" id="name2" />
															<div id='addCreatedLeadForm_leadDate_errorloc'
																class="error_strings"></div>
														</div>
													</div>
												</div>
											</div>

											<div class="row">
												<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
													<div class="row form-group">
														<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
															<s:text
																name="expenses.travel.bill.Econveyanceexpenses(taxibillpaidbyotherbranch)" />
															<div class="star"></div>
														</div>

														<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12"></div>

														<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">

															<s:textfield type="text" name="conveynanceEx"
																class="form-control" cssClass="form-control"
																tabindex="8" onblur="display1()" id="name3"/>
															<div id='addCreatedLeadForm_leadDate_errorloc'
																class="error_strings"></div>
														</div>


													</div>
												</div>
											</div>

											<div class="row">
												<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
													<div class="row form-group">
														<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
															<s:text name="expenses.travel.bill.Flaundryexpenses" />
															<div class="star"></div>
														</div>

														<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12"></div>

														<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">

															<s:textfield type="text" name="laundryExpences"
																class="form-control" cssClass="form-control"
																tabindex="9" onblur="display1()" id="name4"/>
															<div id='addCreatedLeadForm_leadDate_errorloc'
																class="error_strings"></div>
														</div>
													</div>
												</div>
											</div>
											<div class="row">
												<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
													<div class="row form-group">
														<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
															<s:text name="expenses.travel.bill.Gotherexpenses" />
															<a data-toggle="modal" data-target="#myModal1">(Bills
																To Be Enclosed)</a>
															<div class="star"></div>
														</div>
														<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">

														</div>

														<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">

															<s:textfield type="text" name="gTotal"
																class="form-control" cssClass="form-control"
																tabindex="10" onblur="display1()" id="name5"/>
															<div id='addCreatedLeadForm_leadDate_errorloc'
																class="error_strings"></div>
														</div>
													</div>
												</div>
											</div>
											<div class="row">
												<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
													<div class="row form-group">
														<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
															<s:text name="expenses.travel.bill.Htotalexpenses" />
															<div class="star"></div>
														</div>
														<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
															<b> <b> <s:text name="expenses.travel.bill.total(A)to(G)" /></b>
															</b>
														</div>

														<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">

															<s:textfield type="text" name="hTotalAToF"
																class="form-control" cssClass="form-control"
																tabindex="10" onblur="display3()" id="name6" readOnly="true"/>
															<div id='addCreatedLeadForm_leadDate_errorloc'
																class="error_strings"></div>
														</div>
													</div>
												</div>
											</div>
											<div class="row">
												<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
													<div class="row form-group">
														<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
															&nbsp;&nbsp;
															<s:text
																name="expenses.travel.bill.1advancereceived(onlyafterapprovalbyhod)" />
															<div class="star"></div>
														</div>
														<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12"></div>

														<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">

															<s:textfield type="text" name="oneAdvanceReceived"
																class="form-control" cssClass="form-control"
																tabindex="11"  onblur="display2()" id="name7"/>
															<div id='addCreatedLeadForm_leadDate_errorloc'
																class="error_strings"></div>
														</div>
													</div>
												</div>
											</div>
											<div class="row">
												<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
													<div class="row form-group">
														<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
															&nbsp;&nbsp;
															<s:text
																name="expenses.travel.bill.2ifticketbookedbycompany(plsentertheamt)" />
															<div class="star"></div>
														</div>

														<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12"></div>

														<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">

															<s:textfield type="text" name="twoTicketBookedByCompany"
																class="form-control" cssClass="form-control"
																tabindex="12"  onblur="display2()" id="name8"/>
															<div id='addCreatedLeadForm_leadDate_errorloc'
																class="error_strings"></div>
														</div>
													</div>
												</div>
											</div>
											<div class="row">
												<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
													<div class="row form-group">
														<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
															&nbsp;&nbsp;
															<s:text
																name="expenses.travel.bill.3ifhotelbookedbycompany(plsentertheamount)" />
															<div class="star"></div>
														</div>

														<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12"></div>

														<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">

															<s:textfield type="text" name="threeHotelBookedByCompany"
																class="form-control" cssClass="form-control"
																tabindex="13"  onblur="display2()" id="name9"/>
															<div id='addCreatedLeadForm_leadDate_errorloc'
																class="error_strings"></div>
														</div>
													</div>
												</div>
											</div>
											<div class="row">
												<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
													<div class="row form-group">
														<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
															&nbsp;&nbsp;
															<s:text
																name="expenses.travel.bill.4conveyanceexpenses(taxibillpaidbyotherbranch)" />
															<div class="star"></div>
														</div>

														<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12"></div>

														<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">

															<s:textfield type="text" name="forthConveyanceExpenses"
																class="form-control" cssClass="form-control"
																tabindex="14"  onblur="display2()" id="name10"/>
															<div id='addCreatedLeadForm_leadDate_errorloc'
																class="error_strings"></div>
														</div>
													</div>
												</div>
											</div>
											<div class="row">
												<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
													<div class="row form-group">
														<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
															&nbsp;&nbsp;
															<s:text name="expenses.travel.bill.5advancereceivedfromotherbranches" />
															<div class="star"></div>
														</div>

														<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12"></div>

														<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">

															<s:textfield type="text"
																name="fiveAdvanceReceivedFromOther" class="form-control"
																cssClass="form-control" tabindex="15"  onblur="display2()" id="name11"/>
															<div id='addCreatedLeadForm_leadDate_errorloc'
																class="error_strings"></div>
														</div>
													</div>
												</div>
											</div>

											<div class="row">
												<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
													<div class="row form-group">
														<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
															<s:text name="expenses.travel.bill.Itotaladvance" />

															<div class="star"></div>
														</div>

														<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
															<b><s:text name="expenses.travel.bill.total(1)to(5)" /></b>
														</div>

														<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">

															<s:textfield type="text" name="ITotalAdvance"
																class="form-control" cssClass="form-control"
																tabindex="17" onblur="display3()" id="name15" readonly="true"/>
															<div id='addCreatedLeadForm_leadDate_errorloc'
																class="error_strings"></div>
														</div>
													</div>
												</div>
											</div>
											<div class="row">
												<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
													<div class="row form-group">
														<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">

															<div class="star"></div>
														</div>


														<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
															<b><s:text name="Clamed Balance (H)-.(I)" /></b>
														</div>

														<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">

															<s:textfield type="text" name="claimedBalance"
																class="form-control" cssClass="form-control"
																tabindex="18" id="name14" readonly="true"/>
															<div id='addCreatedLeadForm_leadDate_errorloc'
																class="error_strings"></div>
														</div>
													</div>
												</div>
											</div>
											<hr>
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
										</div>
									</div>
								</div>
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
									<h4 class="modal-title" style="color: gray;">A . Ticket
										Fare-provided By Co./self Arrangement</h4>
								</div>
								<div class="modal-body" style="color: gray;">
									<p>

										<s:form name="ticketFareForm" action="ticketToursExpenses"
											method="post">
											<div class="row" style="padding: 10px;">
												<s:textfield type="text" name="departurePlace"
													cssClass="form-control" tabindex="3"
													placeholder="Departure Place" />
												<div id='ticketFareForm_departurePlace_errorloc'
													class="error_strings"></div>
											</div>
											<div class="row" style="padding: 10px;">
												<sj:datepicker name="departureDate" changeMonth="true"
													changeYear="true" showAnim="slideDown" duration="fast"
													yearRange="1950:2050" showOn="focus" size="35%"
													timepicker="true" timepickerShowSecond="true"
													timepickerFormat="hh:mm:ss" displayFormat="yy-mm-dd"
													parentTheme="simple" cssClass="form-control" tabindex="4"
													placeholder="Departure Date" />
											</div>

											<div class="row" style="padding: 10px;">
												<s:textfield type="text" name="arrivalPlace"
													cssClass="form-control" tabindex="3"
													placeholder="Arrval Place" />

												<div id='addCreatedLeadForm_expectedClosingDate_errorloc'
													class="error_strings"></div>
											</div>

											<div class="row" style="padding: 10px;">
												<sj:datepicker name="arrivalDate" changeMonth="true"
													changeYear="true" showAnim="slideDown" duration="fast"
													yearRange="1950:2050" showOn="focus" size="35%"
													timepicker="true" timepickerShowSecond="true"
													timepickerFormat="hh:mm:ss" displayFormat="yy-mm-dd"
													parentTheme="simple" cssClass="form-control" tabindex="4"
													placeholder="Arrival Date" />
											</div>

											<div class="row" style="padding: 10px;">
												<s:select list="travelModeList" cssClass="form-control"
													tabindex="3" placeholder="Travel Mode" name="travelMode" />
											</div>

											<div class="row" style="padding: 10px;">
												<s:textfield type="text" name="amountForA"
													cssClass="form-control" tabindex="3" placeholder="Amount" />
												<div id='addCreatedLeadForm_expectedClosingDate_errorloc'
													class="error_strings"></div>
											</div>

											<%-- <div class="row" style="padding: 10px;">
												<div class="col-md-4">
													<s:text name="Ticket Attachment"></s:text>
												</div>
												<div class="col-md-8">
													<s:file name="ticketAttachment" tabindex="3" />
													<div id='addCreatedLeadForm_expectedClosingDate_errorloc'
														class="error_strings"></div>
												</div>
											</div> --%>

											<hr>
											<div class="row" style="margin-top: 30px;">
												<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"
													align="center">
													<a href="#" data-toggle="tooltip" data-dismiss="modal"
														data-original-title="Cancel"
														class="btn btn-default btnheight"><i
														class="fa fa-caret-square-o-left fontawesomeht"></i> <s:text
															name="project.form.button.cancel"></s:text></a> <a href="#"
														data-toggle="tooltip" data-original-title="Reset"
														class="btn btn-success btnheight"><i
														class="fa fa-refresh "></i> <s:text
															name="project.form.button.reset"></s:text></a>
													<button type="submit" data-toggle="tooltip"
														data-original-title="Save"
														class="btn btn-primary btnheight">
														<i class="fa fa-check"></i>
														<s:text name="project.form.button.save"></s:text>
													</button>

												</div>
											</div>







										</s:form>



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
										style="color: red; margin-top: -30px;">
										<h1>&times;</h1>
									</button>
									<h5 class="modal-title" style="color: gray;">B. Boarding &
										Lodging- Provided By Co./self Arrangement</h5>
								</div>
								<div class="modal-body" style="color: gray;">
									<p>
										<!-- .do?expencesprocessid=hotel -->
										<s:form name="hotelDetails" action="hotelFare" method="post">
											<div class="row" style="padding: 10px;">
												<s:textfield type="text" name="hotel"
													cssClass="form-control" tabindex="3" placeholder="Hotel" />
												<div id='hotelDetails_hotel_errorloc' class="error_strings"></div>
											</div>

											<div class="row" style="padding: 10px;">
												<s:textfield type="text" name="place"
													cssClass="form-control" tabindex="3" placeholder="Place" />
											</div>


											<div class="row" style="padding: 10px;">
												<sj:datepicker name="from" changeMonth="true"
													changeYear="true" showAnim="slideDown" duration="fast"
													yearRange="1950:2050" showOn="focus" size="35%"
													timepicker="true" timepickerShowSecond="true"
													timepickerFormat="hh:mm:ss" displayFormat="yy-mm-dd"
													parentTheme="simple" cssClass="form-control" tabindex="4"
													placeholder="From" />
											</div>


											<div class="row" style="padding: 10px;">
												<sj:datepicker name="to" changeMonth="true"
													changeYear="true" showAnim="slideDown" duration="fast"
													yearRange="1950:2050" showOn="focus" size="35%"
													timepicker="true" timepickerShowSecond="true"
													timepickerFormat="hh:mm:ss" displayFormat="yy-mm-dd"
													parentTheme="simple" cssClass="form-control" tabindex="4"
													placeholder="To" />
											</div>



											<div class="row" style="padding: 10px;">
												<s:textfield type="text" name="billNo"
													cssClass="form-control" tabindex="3" placeholder="Bill No." />
											</div>



											<div class="row" style="padding: 10px;">
												<s:textfield type="text" name="hotelAmount"
													cssClass="form-control" tabindex="3" placeholder="Amount" />
												<div id='addCreatedLeadForm_expectedClosingDate_errorloc'
													class="error_strings"></div>
											</div>

											<%-- <div class="row" style="padding: 10px;">
												<div class="col-md-4">
													<s:text name="Bill Attachment"></s:text>
												</div>
												<div class="col-md-8">
													<s:file name="billAttachment" tabindex="3" />
													<div id='addCreatedLeadForm_expectedClosingDate_errorloc'
														class="error_strings"></div>
												</div>
											</div> --%>

											<hr>
											<div class="row">
												<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"
													align="center">
													<a href="expensesDasbordTour.action" data-toggle="tooltip"
														data-dismiss="modal" data-original-title="Cancel"
														class="btn btn-default btnheight"><i
														class="fa fa-caret-square-o-left fontawesomeht"></i> <s:text
															name="project.form.button.cancel"></s:text></a> <a
														href="expensesTravelBill.action" data-toggle="tooltip"
														data-original-title="Reset"
														class="btn btn-success btnheight"><i
														class="fa fa-refresh "></i> <s:text
															name="project.form.button.reset"></s:text></a>


													<button type="submit" data-toggle="tooltip"
														data-original-title="Save"
														class="btn btn-primary btnheight">
														<i class="fa fa-check"></i>
														<s:text name="project.form.button.save"></s:text>
													</button>

												</div>
											</div>

										</s:form>



									</p>
								</div>

							</div>
						</div>
					</div>



					<!--  ********************** Model 3 **************************** -->
					<div class="modal fade" id="myModal2" role="dialog">
						<div class="modal-dialog modal-md">
							<div class="modal-content">
								<div class="modal-header"
									style="color: gray; background-color: #F8F8F8;">
									<button type="button" class="close" data-dismiss="modal"
										style="color: red; margin-top: -30px;">
										<h1>&times;</h1>
									</button>
									<h5 class="modal-title" style="color: gray;">Other
										Attachment</h5>
								</div>
								<div class="modal-body" style="color: gray;">
									<p>
										<!-- .do?expencesprocessid=hotel -->
										<s:form name="otherAttachment" action="otherAtchmentBill"
											method="post">
											<div class="row" style="padding: 10px;">
												<s:textfield type="text" name="hotel"
													cssClass="form-control" tabindex="3" placeholder="Hotel" />
												<div id='hotelDetails_hotel_errorloc' class="error_strings"></div>
											</div>

											<div class="row" style="padding: 10px;">
												<s:textfield type="text" name="place"
													cssClass="form-control" tabindex="3" placeholder="Place" />
											</div>


											<div class="row" style="padding: 10px;">
												<sj:datepicker name="from" changeMonth="true"
													changeYear="true" showAnim="slideDown" duration="fast"
													yearRange="1950:2050" showOn="focus" size="35%"
													timepicker="true" timepickerShowSecond="true"
													timepickerFormat="hh:mm:ss" displayFormat="yy-mm-dd"
													parentTheme="simple" cssClass="form-control" tabindex="4"
													placeholder="From" />
											</div>


											<div class="row" style="padding: 10px;">
												<sj:datepicker name="to" changeMonth="true"
													changeYear="true" showAnim="slideDown" duration="fast"
													yearRange="1950:2050" showOn="focus" size="35%"
													timepicker="true" timepickerShowSecond="true"
													timepickerFormat="hh:mm:ss" displayFormat="yy-mm-dd"
													parentTheme="simple" cssClass="form-control" tabindex="4"
													placeholder="To" />
											</div>



											<div class="row" style="padding: 10px;">
												<s:textfield type="text" name="billNo"
													cssClass="form-control" tabindex="3" placeholder="Bill No." />
											</div>



											<div class="row" style="padding: 10px;">
												<s:textfield type="text" name="hotelAmount"
													cssClass="form-control" tabindex="3" placeholder="Amount" />
												<div id='addCreatedLeadForm_expectedClosingDate_errorloc'
													class="error_strings"></div>
											</div>

											<div class="row" style="padding: 10px;">
												<div class="col-md-4">
													<s:text name="Bill Attachment"></s:text>
												</div>
												<div class="col-md-8">
													<s:file name="billAttachment" tabindex="3" />
													<div id='addCreatedLeadForm_expectedClosingDate_errorloc'
														class="error_strings"></div>
												</div>
											</div>

											<hr>
											<div class="row">
												<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"
													align="center">
													<a href="expensesDasbordTour.action" data-toggle="tooltip"
														data-dismiss="modal" data-original-title="Cancel"
														class="btn btn-default btnheight"><i
														class="fa fa-caret-square-o-left fontawesomeht"></i> <s:text
															name="project.form.button.cancel"></s:text></a> <a
														href="expensesTravelBill.action" data-toggle="tooltip"
														data-original-title="Reset"
														class="btn btn-success btnheight"><i
														class="fa fa-refresh "></i> <s:text
															name="project.form.button.reset"></s:text></a>


													<button type="submit" data-toggle="tooltip"
														data-original-title="Save"
														class="btn btn-primary btnheight">
														<i class="fa fa-check"></i>
														<s:text name="project.form.button.save"></s:text>
													</button>

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

	<script type="text/javascript">
		function display1() {

			var a = document.getElementById("name12").value;

			document.getElementById("name6").value = a;
			var b = document.getElementById("name2").value;
			var c = document.getElementById("name3").value;
			var d = document.getElementById("name5").value;
			var e = document.getElementById("name4").value;
			
			var f = Number(a) + Number(b)+Number(c) + Number(d)+Number(e);

			document.getElementById("name6").value = f;
		}
	</script>
	
	<script type="text/javascript">
		function display2() {

			var a = document.getElementById("name7").value;
			var b = document.getElementById("name8").value;
			var c = document.getElementById("name9").value;
			var d = document.getElementById("name10").value;
			var e = document.getElementById("name11").value;
			
			var f = Number(a) + Number(b)+Number(c) + Number(d)+Number(e);

			document.getElementById("name15").value = f;
		}
	</script>
	
	<script type="text/javascript">
		function display3() {

			var a = document.getElementById("name6").value;

			document.getElementById("name14").value = a;
			var b = document.getElementById("name15").value;
			
			
			var f = Number(a) - Number(b);

			document.getElementById("name14").value = f;
		}
	</script>
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

	<!-- Model 1 Validation -->
	<script type="text/javascript">
		var frmvalidator = new Validator("ticketFareForm");
		frmvalidator.EnableOnPageErrorDisplay();
		frmvalidator.EnableMsgsTogether();

		//Validation for Contact Person.
		frmvalidator.addValidation("departurePlace", "req",
				"Enter Departure Place");

		var frm1validator = new Validator("hotelDetails");
		frmvalidator.EnableOnPageErrorDisplay();
		frmvalidator.EnableMsgsTogether();

		//Validation for Contact Person.
		frm1validator.addValidation("hotel", "req", "Enter Hotel Name");

		var frm2validator = new Validator("expensesDetailForm");
		frmvalidator.EnableOnPageErrorDisplay();
		frmvalidator.EnableMsgsTogether();

		//Validation for  Person who claimed.
		frm2validator.addValidation("name", "req", "Enter Person Name");
		frmvalidator.addValidation("name", "maxlen=100",
				" Person Name Should Be 100 Characters");
		frmvalidator.addValidation("name", "minlen=3",
				" Person Name Should Be 3 Characters");

		//Validation for  place of visit.
		frm2validator.addValidation("placeOfVisit", "req",
				"Enter Place Of Visit");
		frmvalidator.addValidation("placeOfVisit", "maxlen=100",
				" Place Of Visit Name Should Be 100 Characters");
		frmvalidator.addValidation("placeOfVisit", "minlen=3",
				" Place Of Visit Name Should Be 3 Characters");

		function DoExpenValidation() {
			var frm1 = document.forms["expensesDetailForm"];
			var ndate = frm1.departureDate.value;
			var ndate1 = frm1.arrivalDate.value;
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
						"Arrival Date Should Be Grater Then And Equals To Departure Date",
						frm1.arrivalDate);
				return false;
			}
		}

		frmvalidator.setAddnlValidationFunction(DoExpenValidation);
	</script>






</body>
</html>