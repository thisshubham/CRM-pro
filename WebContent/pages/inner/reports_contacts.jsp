<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div id="content">
		<div class="outer">
			<div class="inner bg-light lter">

				<!--BEGIN INPUT TEXT FIELDS-->
				<div class="row">
					<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
						<div class="box ">
							<header>
							<div class="icons">
								<i class="fa fa-th-large"></i>
							</div>
							<h5>CRM Reports</h5>

							<!-- .toolbar -->
							<div class="toolbar">
								<nav style="padding: 8px;"> <a href="javascript:;"
									class="btn btn-default btn-xs collapse-box"> <i
									class="fa fa-minus"></i>
								</a> <a href="javascript:;" class="btn btn-default btn-xs full-box">
									<i class="fa fa-expand"></i>
								</a> <a href="javascript:;" class="btn btn-danger btn-xs close-box">
									<i class="fa fa-times"></i>
								</a> </nav>
							</div>
							<!-- /.toolbar --> </header>
							<div class="container"
								style="margin-top: 20px; margin-bottom: 20px;">

								<!-- Nav tabs -->
								<ul class="nav nav-tabs" role="tablist">
									<li role="presentation"><a href="crmReports.action"	style="color: Gray;">Leads</a></li>
									<li role="presentation"><a href="clientsReports" style="color: Gray;">Clients</a></li>
									<li role="presentation" class="active"><a href="contactsReports.action" style="background-color: #F9F9F9; color: Gray;">Contacts</a></li>
									<li role="presentation"><a href="targetReports.action" style="color: Gray;">Target</a></li>
									<li role="presentation"><a href="assignmentReports.action" style="color: Gray;">Assignment</a></li>
									<li role="presentation"><a href="taskReports.action" style="color: Gray;">Task</a></li>
									<li role="presentation"><a href="eventReports.action" style="color: Gray;">Event</a></li>
									<li role="presentation"><a href="callReports.action" style="color: Gray;">Call</a></li>

								</ul>

								<!-- Tab panes  ****      **  **  -->

								<div id="content" style="background-color: #F9F9F9;">



									<!--BEGIN INPUT TEXT FIELDS-->
									<div class="row">
										<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
											<div class="box "
												style="margin-top: -10px; margin-bottom: 0px;">


												<div class="alert alert-info" role="alert"
													style="margin-top: 25px; margin-left: 20px; margin-right: 20px;">
													<span class="fa fa-info" style="margin-right: 10px;"></span>Manage
													your personal details, contact, information,
													language,country and timezone.
												</div>

												<form>


													<div class="row">
														<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
															<div class="box">
																<header>
																<h5>Contact Report</h5>
																<div class="toolbar">
																	<div class="btn-group">
																		<a href="#borderedTable" data-toggle="collapse"
																			class="btn btn-default btn-sm minimize-box"> <i
																			class="fa fa-angle-up"></i>
																		</a> <a class="btn btn-danger btn-sm close-box"> <i
																			class="fa fa-times"></i>
																		</a>
																	</div>
																</div>
																</header>
																<div id="borderedTable" class="body collapse in">
																	<table class="table table-bordered responsive-table">
																		<thead>
																			<tr>
																				<th style="width: 2%"></th>
																				<th style="width: 20%">Report</th>

																				<th>Description</th>


																			</tr>
																		</thead>
																		<tbody>
																			<tr>
																				<td><span class="fa fa-filter"> </span></td>
																				<td><a href="reportLeadDelly.action" style="color:blue;">Delly Leads</a></td>
																				<td>Leads detail for syatem current date using filter be can get other lead detail for be can get lead report based on date selected</td>


																			</tr>
																			<tr>
																				<td><span class="fa fa-filter"> </span></td>
																				<td><a href="#" id="row_a_link">Weakly leads</a></td>
																				<td>Leads detail for syatem current date using filter be can get other lead detail for be can get lead report based on date selected</td>


																			</tr>
																			<tr>
																				<td><span class="fa fa-filter"> </span></td>
																				<td><a href="#" id="row_a_link">Monthly Leads</a></td>
																				<td>Leads detail for syatem current date using filter be can get other lead detail for be can get lead report based on date selected</td>


																			</tr>
																			<tr>
																				<td><span class="fa fa-filter"> </span></td>
																				<td><a href="#" id="row_a_link">Leads By Status</a></td>
																				<td>Leads detail for syatem current date using filter be can get other lead detail for be can get lead report based on date selected</td>


																			</tr>
																			<tr>
																				<td><span class="fa fa-filter"> </span></td>
																				<td><a href="#" id="row_a_link">Leads by source</a></td>
																				<td>Leads detail for syatem current date using filter be can get other lead detail for be can get lead report based on date selected</td>


																			</tr>
																			<tr>
																				<td><span class="fa fa-filter"> </span></td>
																				<td><a href="#" id="row_a_link">Leads bt creator</a></td>
																				<td>Leads detail for syatem current date using filter be can get other lead detail for be can get lead report based on date selected</td>


																			</tr>
																			<tr>
																				<td><span class="fa fa-filter"> </span></td>
																				<td><a href="#" id="row_a_link">Leads by indrestry</a></td>
																				<td>Leads detail for syatem current date using filter be can get other lead detail for be can get lead report based on date selected</td>


																			</tr>
																			
																			
																		</tbody>
																	</table>
																</div>
															</div>
														</div>
													</div>
													<div class="row">
														<p class="bg-success"
															style="padding: 10px; margin-top: 20px">
															<small><a
																href="http://elvery.net/demo/responsive-tables/#no-more-tables"
																target="_blank">Link</a> to original article</small>
														</p>
													</div>
											</div>

											</form>
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
	</div>



	<script src="assets/lib/screenfull/screenfull.js"></script>
	<script src="assets/lib/jquery.uniform/jquery.uniform.min.js"></script>
	<script src="assets/lib/inputlimiter/jquery.inputlimiter.js"></script>
	<script src="assets/lib/chosen/chosen.jquery.min.js"></script>
	<script src="assets/lib/colorpicker/js/bootstrap-colorpicker.js"></script>
	<script src="assets/lib/tagsinput/jquery.tagsinput.js"></script>
	<script src="assets/lib/validVal/js/jquery.validVal.min.js"></script>
	<script src="assets/lib/moment/moment.min.js"></script>
	<script src="assets/lib/daterangepicker/daterangepicker.js"></script>
	<script src="assets/lib/datepicker/js/bootstrap-datepicker.js"></script>
	<script src="assets/lib/timepicker/js/bootstrap-timepicker.min.js"></script>
	<script src="assets/lib/switch/js/bootstrap-switch.min.js"></script>
	<script src="assets/lib/autosize/jquery.autosize.min.js"></script>
	<script src="assets/lib/jasny-bootstrap/js/jasny-bootstrap.min.js"></script>


	<!-- Metis core scripts -->
	<script src="assets/js/core.min.js"></script>

	<!-- Metis demo scripts -->
	<script src="assets/js/app.min.js"></script>
	<script>
		$(function() {
			Metis.formGeneral();
			Metis.formWysiwyg();
		});
	</script>
	<script src="assets/js/style-switcher.min.js"></script>
</body>
</html>