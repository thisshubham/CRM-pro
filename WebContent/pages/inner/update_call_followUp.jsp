<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>

	<div id="content">
		<div class="outer">
			<div class="inner bg-light lter">

				<!--BEGIN INPUT TEXT FIELDS-->
				<div class="row">
					<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
						<div class="box inverse">
							<header>
							<a class="icons" href="callDashboard.action" data-toggle="tooltip"
						data-original-title="Back To DashBoard"> <i class="fa fa-th-large"></i>
				</a>
							<h5>Call FollowUp</h5>

							<!-- .toolbar -->
							<div class="toolbar">
								<nav style="padding: 8px;"> <a href="#"
									class="btn btn-default btn-xs collapse-box"> <i
									class="fa fa-minus"></i>
								</a> <a href="#" class="btn btn-default btn-xs full-box"> <i
									class="fa fa-expand"></i>
								</a> <a href="#" class="btn btn-danger btn-xs close-box"> <i
									class="fa fa-times"></i>
								</a> </nav>
							</div>
							</header>

							<div class="container">

								<div id="div-2" class="body">
									<form class="form-horizontal">
										<div class="row" style="margin-top: 20px;">
											<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
												<h5>Call Information</h5>
												<hr style="margin-top: -5px">
											</div>
											
										</div>


										<div class="row">

											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
														<label for="text1" class="control-label col-lg-4">
															Lead Owner</label>
													</div>
													<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
														<input type="text" class="form-control"
															disabled="disabled">
													</div>
												</div>
											</div>


											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
														<label for="text1" class="control-label col-lg-4">
															Lead Date</label>
													</div>
													<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
														<input type="text" class="form-control"
															disabled="disabled" id="dp5">
													</div>
												</div>

											</div>
										</div>



										<div class="row">
											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
														<label for="text1" class="control-label col-lg-4">
															Company</label>
													</div>
													<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
														<input type="text" class="form-control">
													</div>
												</div>
											</div>


											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
														<label for="text1" class="control-label col-lg-4">
															Contact Person</label>
													</div>
													<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
														<div class="row">
															<div class="col-lg-3 col-md-3 col-sm-3 col-xs-5">
																<select class="form-control">

																	<option>Mr.</option>
																	<option>Mrs.</option>
																	<option>Dr.</option>
																	<option>Miss.</option>
																	<option>Prof.</option>
																	<option>Other</option>
																</select>
															</div>
															<div class="col-lg-9 col-md-9 col-sm-9 col-xs-12">
																<input type="text" class="form-control">
															</div>
														</div>
													</div>
												</div>

											</div>
										</div>


										<div class="row">
											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
														<label class="control-label col-lg-4"> Lead Title</label>
													</div>
													<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
														<select data-placeholder="Choose a Country..."
															class="form-control chzn-select" tabindex="2">
															<option value="Timor-leste">Select Lead Title</option>
															<option value="Togo">Togo</option>
															<option value="Tokelau">Tokelau</option>
															<option value="Tonga">Tonga</option>
															<option value="Trinidad and Tobago">Trinidad and
																Tobago</option>
															<option value="Tunisia">Tunisia</option>
															<option value="Turkey">Turkey</option>
															<option value="Turkmenistan">Turkmenistan</option>
															<option value="Turks and Caicos Islands">Turks
																and Caicos Islands</option>
															<option value="Tuvalu">Tuvalu</option>
															<option value="Uganda">Uganda</option>
															<option value="Ukraine">Ukraine</option>
															<option value="United Arab Emirates">United Arab
																Emirates</option>
															<option value="United Kingdom">United Kingdom</option>
														</select> <a href="login.html" data-toggle="tooltip"
															data-original-title="Add" data-placement="bottom"
															class="btn btn-metis-3 btn-line"> <i
															class="fa fa-plus-square "></i>

														</a>

													</div>

												</div>
											</div>


											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
														<label for="text1" class="control-label col-lg-4">Company
															Type</label>
													</div>
													<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
														<select class="form-control">
															<option>Select Company Type</option>
															<option>LPP.</option>
															<option>PVT.</option>
															<option>GOVT.</option>

														</select>
													</div>
												</div>
											</div>

										</div>



										<div class="row">
											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
														<label class="control-label col-lg-4">Company
															Category</label>
													</div>
													<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
														<select class="form-control">
															<option>Select Company Category</option>
															<option>Services</option>
															<option>Finanace</option>

														</select>
													</div>
												</div>
											</div>
											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
														<label class="control-label col-lg-4">Company
															Sector </label>
													</div>
													<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
														<select class="form-control">
															<option>Select Company Sector</option>
															<option>IT</option>
															<option>Machnical</option>
															<option>Production</option>

														</select>
													</div>
												</div>
											</div>
										</div>



										<div class="row">
											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
														<label class="control-label col-lg-4">Lead Source</label>
													</div>
													<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
														<select class="form-control">
															<option>Select Lead Source</option>
															<option>Leads</option>
															<option>Contact</option>
															<option>Estimate</option>

														</select>
													</div>
												</div>
											</div>
											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
														<label class="control-label col-lg-4">Lead Status</label>
													</div>
													<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
														<select class="form-control">
															<option>New</option>
															<option>Open</option>
															<option>Submitted</option>
															<option>Registered</option>
															<option>Panding</option>
															<option>Approved</option>
															<option>Rejected</option>
															<option>In-progress</option>
															<option>Review</option>
															<option>Active</option>
															<option>Complited</option>
															<option>Reopen</option>
															<option>Suspend</option>
															<option>Blocked</option>
															<option>Close</option>
															<option>Deleted</option>
														</select>
													</div>
												</div>
											</div>
										</div>



										<div class="row">
											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
														<label class="control-label col-lg-4">No. of
															Associate</label>
													</div>
													<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
														<input type="text" class="form-control">
													</div>
												</div>
											</div>
											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
														<label class="control-label col-lg-4">Annual
															Reneue</label>
													</div>
													<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
														<div class="row">
															<div class="col-lg-3 col-md-3 col-sm-3 col-xs-5">
																<select class="form-control">
																	<option>RUPEES</option>
																	<option>USD</option>
																	<option>EURO</option>

																</select>
															</div>
															<div class="col-lg-9 col-md-9 col-sm-9 col-xs-12">
																<input type="text" class="form-control">
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>



										<div class="row">
											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
														<label class="control-label col-lg-4">Lead Date</label>
													</div>
													<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">

														<input type="text" class="form-control" id="dp2">

													</div>
												</div>
											</div>
											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
														<label class="control-label col-lg-4">Expected
															Closing Date</label>
													</div>
													<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
														<input type="text" class="form-control" id="dp1">
													</div>
												</div>
											</div>
										</div>


										<div class="row">


											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12"></div>
										</div>


										<div class="row" style="margin-top: 20px;">
											<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
												<h5>Contact Information</h5>
												<hr style="margin-top: -5px">
											</div>

										</div>
										

										<div class="row" >

											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
														<label class="control-label col-lg-4">Adress Line
															1</label>
													</div>
													<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
														<input type="text" class="form-control">
													</div>
												</div>
											</div>
											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
														<label class="control-label col-lg-4">Adress Line
															2</label>
													</div>
													<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
														<input type="text" class="form-control">
													</div>
												</div>
											</div>
										</div>



										<div class="row">

											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
														<label class="control-label col-lg-4">City</label>
													</div>
													<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
														<input type="text" class="form-control">
													</div>
												</div>
											</div>
											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
														<label class="control-label col-lg-4">State</label>
													</div>
													<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
														<input type="text" class="form-control">
													</div>
												</div>
											</div>
										</div>



										<div class="row">
											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
														<label class="control-label col-lg-4">Country</label>
													</div>
													<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
														<select class="form-control">
															<option>Select Country</option>
															<option>India</option>
															<option>Usa</option>
															<option>Uk</option>

														</select>
													</div>
												</div>
											</div>
											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
														<label class="control-label col-lg-4">ZipCode</label>
													</div>
													<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
														<input type="text" class="form-control">
													</div>
												</div>
											</div>
										</div>



										<div class="row">
											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
														<label class="control-label col-lg-4">Phone</label>
													</div>
													<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
														<input type="text" class="form-control">
													</div>
												</div>
											</div>
											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
														<label class="control-label col-lg-4">Mobile</label>
													</div>
													<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
														<input type="text" class="form-control">
													</div>
												</div>
											</div>
										</div>

										<div class="row">
											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
														<label class="control-label col-lg-4">Primary
															E-mail Id</label>
													</div>
													<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
														<input type="text" class="form-control">
													</div>
												</div>
											</div>
											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
														<label class="control-label col-lg-4">Alternate
															E-mail Id</label>
													</div>
													<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
														<input type="text" class="form-control">
													</div>
												</div>
											</div>
										</div>



										<div class="row">

											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
														<label class="control-label col-lg-4">Fax</label>
													</div>
													<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
														<input type="text" class="form-control">
													</div>
												</div>
											</div>
											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
														<label class="control-label col-lg-4">WebSite</label>
													</div>
													<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
														<input type="text" class="form-control">
													</div>
												</div>
											</div>
										</div>


										<div class="row" style="margin-top: 20px;">
											<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
												<h5>Social Information</h5>
												<hr style="margin-top: -5px">
											</div>

										</div>

										<div class="row">
											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
														<label class="control-label col-lg-4">Facebook</label>
													</div>
													<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
														<input type="text" class="form-control">
													</div>
												</div>
											</div>
											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
														<label class="control-label col-lg-4">Twiter</label>
													</div>
													<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
														<input type="text" class="form-control">
													</div>
												</div>
											</div>
										</div>

										<div class="row">
											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
														<label class="control-label col-lg-4">Linkedin</label>
													</div>
													<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
														<input type="text" class="form-control">
													</div>
												</div>
											</div>
											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
														<label class="control-label col-lg-4">Google+</label>
													</div>
													<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
														<input type="text" class="form-control">
													</div>
												</div>
											</div>
										</div>


										<div class="row">

											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
														<label class="control-label col-lg-4">Youtube</label>
													</div>
													<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
														<input type="text" class="form-control">
													</div>
												</div>
											</div>
											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
														<label class="control-label col-lg-4">Other</label>
													</div>
													<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
														<input type="text" class="form-control">
													</div>
												</div>
											</div>
										</div>

										<div class="row" style="margin-top: 20px;">
											<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
												<h5>Requirment</h5>
												<hr style="margin-top: -5px">
											</div>
										</div>


										<div class="form-group">
											<div class="row" style="margin: 1% 2%;">
												<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">

													<textarea id="wysihtml5" class="form-control" rows="10"></textarea>


												</div>

											</div>
										</div>

										<div class="row" style="margin-top: -35px;">
											<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
												<h5>Follow Up</h5>
												<hr style="margin-top: -5px">
											</div>

										</div>

										
										<div class="row">

											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
														<label class="control-label col-lg-4">Follow Up
															Date</label>
													</div>
													<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
														<input type="text" class="form-control" id="dp4">
													</div>
												</div>
											</div>

											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
														<label class="control-label col-lg-4">Follow Up
															Status</label>
													</div>
													<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
														<select data-placeholder="Choose a Country..."
															class="form-control chzn-select" tabindex="2">
															<option value="Timor-leste">New</option>
															<option value="Togo">Open</option>
															<option value="Tokelau">Submitted</option>
															<option value="Tonga">Registered</option>
															<option value="Trinidad and Tobago">Panding</option>
															<option value="Tunisia">Approved</option>
															<option value="Turkey">Rejected</option>
															<option value="Turkmenistan">In-progress</option>
															<option value="Turks and Caicos Islands">Review</option>
															<option value="Tuvalu">Active</option>
															<option value="Uganda">Complited</option>
															<option value="Ukraine">Reopen</option>
															<option value="Ukraine">Suspend</option>
															<option value="Ukraine">Blocked</option>
															<option value="Ukraine">Close</option>
															<option value="Ukraine">Deleted</option>
														</select>
													</div>
												</div>
											</div>


										</div>
										<div class="row">

											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
														<label class="control-label col-lg-4">Follow Up By</label>
													</div>
													<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
														<select data-placeholder="Choose a Country..."
															class="form-control chzn-select" tabindex="2">
															<option value="Timor-leste">New</option>
															<option value="Togo">Open</option>
															<option value="Tokelau">Submitted</option>
															<option value="Tonga">Registered</option>
															<option value="Trinidad and Tobago">Panding</option>
															<option value="Tunisia">Approved</option>
															<option value="Turkey">Rejected</option>
															<option value="Turkmenistan">In-progress</option>
															<option value="Turks and Caicos Islands">Review</option>
															<option value="Tuvalu">Active</option>
															<option value="Uganda">Complited</option>
															<option value="Ukraine">Reopen</option>
															<option value="Ukraine">Suspend</option>
															<option value="Ukraine">Blocked</option>
															<option value="Ukraine">Close</option>
															<option value="Ukraine">Deleted</option>
														</select>
													</div>
												</div>
											</div>
											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
														<label class="control-label col-lg-4">comment</label>
													</div>
													<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
														<textarea class="form-control" rows="3" cols="30"></textarea>
													</div>
												</div>
											</div>


										</div>

										<div class="row" style="background-color: F8F8F8;">
											<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
												<div class="box dark">
													<header>
													<h5>Folloup</h5>
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
													<div id="dataTable" class="body collapse in">
														<table class="table table-bordered responsive-table">
															<thead>
																<tr id="myrow">
																	<th>FollowUp Id</th>
																	<th>FollowUp Date</th>
																	<th>FollowUp By</th>
																	<th>FollowUp Status</th>
																	<th>Comment</th>
																</tr>
															</thead>
															<tbody>
																<tr>
																	<td>123456</td>
																	<td>12-02-2015</td>
																	<td>Deepak vishwakarma</td>
																	<td>Call not connected</td>
																	<td>Not able to reach on call</td>
																</tr>
																<tr>
																	<td>123456</td>
																	<td>12-02-2015</td>
																	<td>Deepak vishwakarma</td>
																	<td>Call tomorrow</td>
																	<td>Not able to reach on call</td>
																</tr>
																<tr>
																	<td>123456</td>
																	<td>12-02-2015</td>
																	<td>Deepak vishwakarma</td>
																	<td>Decision Panding</td>
																	<td>Not able to reach on call</td>
																</tr>
																<tr>
																	<td>123456</td>
																	<td>12-02-2015</td>
																	<td>Deepak vishwakarma</td>
																	<td>Recuired more time</td>
																	<td>Not able to reach on call</td>
																</tr>
																<tr>
																	<td>123456</td>
																	<td>12-02-2015</td>
																	<td>Deepak vishwakarma</td>
																	<td>Not interested</td>
																	<td>Not able to reach on call</td>
																</tr>
																<tr>
																	<td>123456</td>
																	<td>12-02-2015</td>
																	<td>Deepak vishwakarma</td>
																	<td>Blocked phone number</td>
																	<td>Not able to reach on call</td>
																</tr>
															</tbody>
														</table>
													</div>
												</div>
											</div>
										</div>
									</form>

									<div class="row">
										<div
											class="col-lg-4 col-md-4 col-sm-12 col-xs-12 col-md-offset-5">
											<a href="#" class="btn btn-default">Cancel</a> <a href="#"
												class="btn btn-success">Reset</a> <a href="#"
												class="btn btn-primary">Save</a>
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

	<script>
		$(function() {
			Metis.formGeneral();
			Metis.formWysiwyg();

		});
	</script>
</body>
</html>