<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<style>
a {
	color: blue;
}

a:hover {
	color: blue;
}
</style>
</head>
<body>

	<div id="content">
		<div class="outer">
			<div class="inner bg-light lter">

				<!--BEGIN INPUT TEXT FIELDS-->
				<div class="row">
					<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
						<ol class="breadcrumb" style="margin-top: 10px;">
							<li><a href="#">Home</a></li>
							<li><a href="#">VCRM-Reports</a></li>
							<li><a href="#">Assignment-Report</a></li>

						</ol>

						<div class="box ">
							<header> <a class="icons" href="dashboardGraphReports"
								data-toggle="tooltip" data-original-title="Back To Reports DashBoard"
								style="color: black;"> <i class="fa fa-th-large"></i>
							</a>




							<h5>Assignment Reports</h5>

							<!-- .toolbar -->

							<div class="pull-right">

								<!-- <a href="javascript:;"
									class="btn btn-danger btn-sm close-box"> <i
									class="fa fa-times"></i>
								</a> -->
								<a href="dashboardGraphReports.action"
									class="btn btn-danger btnheight"><i
									class="fa fa-times fontawesomeht"></i></a>


							</div>
							</header>
							<div class="container-fluid"
								style="margin-top: 15px; margin-bottom: 15px;">


								<div id="content" style="background-color: #F9F9F9;">



									<!--BEGIN INPUT TEXT FIELDS-->



									<div class="box" style="padding: 0px 25px 25px; margin: 0px">
										<form>

											<div class="alert alert-info" role="alert"
												style="margin-top: 25px">
												<span class="fa fa-info" style="margin-right: 10px;"></span>Manage
												your personal details, contact, information,
												language,country and timezone.


											</div>
											<div id="borderedTable" class="body collapse in"
												style="white-space: normal;">
												<table class="table table-bordered responsive-table">


													<!-- <table id="dataTable"
												class="table table-bordered table-condensed table-hover table-striped" > -->
													<thead>
														<tr id="myrow">
															<th></th>
															<th>Report</th>

															<th>Description</th>


														</tr>
													</thead>
													<tbody>
														<tr>
															<td><span class="fa fa-th-large"> </span></td>
															<td><a href="reportLeadDelly.action"
																style="color: blue;">Delly Leads</a></td>
															<td>Leads detail for syatem current date using
																filter be can get other lead detail for be can get lead
																report based on date selected</td>


														</tr>
														<tr>
															<td><span class="fa fa-th-large"> </span></td>
															<td><a href="#" id="row_a_link">Weakly leads</a></td>
															<td>Leads detail for syatem current date using
																filter be can get other lead detail for be can get lead
																report based on date selected</td>


														</tr>
														<tr>
															<td><span class="fa fa-th-large"> </span></td>
															<td><a href="#" id="row_a_link">Monthly Leads</a></td>
															<td>Leads detail for syatem current date using
																filter be can get other lead detail for be can get lead
																report based on date selected</td>


														</tr>
														
														
														<tr>
															<td><span class="fa fa-th-large"> </span></td>
															<td><a href="#" id="row_a_link">Leads By Status</a></td>
															<td>Leads detail for syatem current date using
																filter be can get other lead detail for be can get lead
																report based on date selected</td>


														</tr>
														<hr>
														<tr>
															<td><span class="fa fa-th-large"> </span></td>
															<td><a href="#" id="row_a_link">Leads by source</a></td>
															<td>Leads detail for syatem current date using
																filter be can get other lead detail for be can get lead
																report based on date selected</td>


														</tr>
														
														<tr>
															<td><span class="fa fa-th-large"> </span></td>
															<td><a href="#" id="row_a_link">Leads bt creator</a></td>
															<td>Leads detail for syatem current date using
																filter be can get other lead detail for be can get lead
																report based on date selected</td>


														</tr>
														<tr>
															<td><span class="fa fa-th-large"> </span></td>
															<td><a href="#" id="row_a_link">Leads by
																	indrestry</a></td>
															<td>Leads detail for syatem current date using
																filter be can get other lead detail for be can get lead
																report based on date selected</td>


														</tr>


													</tbody>
												</table>
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


	<!-- Modal1 -->
	<div class="modal fade" id="myModal" role="dialog">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header"
					style="color: gray; background-color: #F8F8F8;">
					<button type="button" class="close" data-dismiss="modal"
						style="color: red; margin-top: -30px;">
						<h1>&times;</h1>
					</button>
					<h4 class="modal-title" style="color: gray;">Leads Reports</h4>
				</div>
				<div class="modal-body" style="color: gray;">
					<p>Hi, Walk-In 10-14 Aug.'15 for JAVA Developer(Freshers:0-1
						year)For our client comp. Which is leading software Development
						Company in India, provides services such as Outsourcing Software
						development, includes ERP and MRP systems, Web development,
						Product development, Offshore software development. If possible
						please send me few references suitable for the below roles if any.
						Post Details</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
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