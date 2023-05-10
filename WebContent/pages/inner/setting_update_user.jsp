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
						<div class="box dark">
							<header> <a class="icons" href="leadDashboard.action"
								data-toggle="tooltip" data-original-title="Back To DashBoard"
								style="color: black;"> <i class="fa fa-th-large"></i>
							</a>
							<h5>Create Contacts</h5>

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
							</header>

							<div class="container">
								<div id="div-2" class="body">
									<form class="form-horizontal">
										<div class="row" style="margin-top: 20px;">
											<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
												<h5>Contacts Information</h5>
												<hr style="margin-top: -5px">
											</div>

										</div>
										
										<div class="row">
									<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
										<div class="row form-group">
											<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
												<label class="control-label col-lg-4">Contact Id</label>
											</div>
											<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
												<input type="text" class="form-control" disabled="disabled">
											</div>
										</div>
									</div>
									<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
										<div class="row form-group">
											<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
												<label class="control-label col-lg-4">Contact Status
												</label>
											</div>
											<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
												<input type="text" class="form-control" disabled="disabled">
											</div>
										</div>
									</div>
								</div>
								
								<div class="row">
									<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
										<div class="row form-group">
											<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
												<label class="control-label col-lg-4">Created By</label>
											</div>
											<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
												<input type="text" class="form-control" disabled="disabled">
											</div>
										</div>
									</div>
									<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
										<div class="row form-group">
											<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
												<label class="control-label col-lg-4">Creation Date
												</label>
											</div>
											<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
												<input type="text" class="form-control" id="dp2" disabled="disabled">
											</div>
										</div>
									</div>
								</div>

										<div class="row">
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


											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
														<label for="text1" class="control-label col-lg-4">
															Lead Source</label>
													</div>

													<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
														<select class="form-control chzn-select" tabindex="2">
															<option>Select Lead Source</option>
															<option>Lead</option>
															<option>Estimation</option>
														</select>

													</div>
												</div>

											</div>
										</div>


										<div class="row">
											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
														<label class="control-label col-lg-4">Lead Name</label>
													</div>
													<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
														<input type="text" class="form-control">
													</div>
												</div>
											</div>


											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">


												<div class="row form-group">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
														<label class="control-label col-lg-4">Group</label>
													</div>
													<div class="col-lg-7 col-md-7 col-sm-10 col-xs-10">
														<input type="text" class="form-control">
													</div>

													<div class="col-lg-1 col-md-1 col-sm-2 col-xs-2 ">
														<ul class="nav nav-tabs pull-right">
															<li><a href="#addSocial" data-toggle="tooltip"
																data-original-title="Add Social"
																class="btn btn-metis-3 btn-line form-control"> <i
																	class="fa fa-plus-square "></i>

															</a></li>
														</ul>
													</div>

												</div>
											</div>
										</div>
								</div>



								<div class="row">
									<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
										<div class="row form-group">
											<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
												<label class="control-label col-lg-4">Nick Name</label>
											</div>
											<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
												<input type="text" class="form-control">
											</div>
										</div>
									</div>
									<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
										<div class="row form-group">
											<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
												<label class="control-label col-lg-4">Date Of Birth
												</label>
											</div>
											<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
												<input type="text" class="form-control" id="dp2">
											</div>
										</div>
									</div>
								</div>



								<div class="row">
									<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
										<div class="row form-group">
											<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
												<label class="control-label col-lg-4">Marital Status</label>
											</div>
											<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
												<select class="form-control">
													<option>Select Marital Status</option>
													<option>Male</option>
													<option>Female</option>

												</select>
											</div>
										</div>
									</div>
									<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
										<div class="row form-group">
											<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
												<label class="control-label col-lg-4">Company</label>
											</div>
											<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
												<input type="text" class="form-control" id="dp2">
											</div>
										</div>
									</div>
								</div>



								<div class="row">
									<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
										<div class="row form-group">
											<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
												<label class="control-label col-lg-4">Department</label>
											</div>
											<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
												<select class="form-control chzn-select" tabindex="2">
													<option>Select Department</option>
													<option>1</option>
													<option>2</option>

												</select>
											</div>
										</div>
									</div>

									<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
										<div class="row form-group">
											<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
												<label class="control-label col-lg-4">Designation</label>
											</div>

											<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
												<select class="form-control chzn-select" tabindex="2">
													<option>Select Designation</option>
													<option>1</option>

													<option>2</option>

												</select>
											</div>
										</div>
									</div>
								</div>

								<div class="row">
									<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
										<div class="row form-group">
											<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
												<label class="control-label col-lg-4">Report To</label>
											</div>
											<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
												<select class="form-control chzn-select" tabindex="2">
													<option>Select Report To</option>
													<option>1</option>
													<option>2</option>

												</select>
											</div>
										</div>
									</div>
								</div>


								<div class="row" style="margin-top: 20px;">
									<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
										<h5>Home Contact Information</h5>
										<hr style="margin-top: -5px">
									</div>
								</div>


								<div class="row">
									<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
										<div class="row form-group">
											<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
												<label class="control-label col-lg-4">Adress Line 1</label>
											</div>
											<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
												<input type="text" class="form-control">
											</div>
										</div>
									</div>
									<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
										<div class="row form-group">
											<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
												<label class="control-label col-lg-4">Adress Line 2</label>
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
												<select class="form-control chzn-select" tabindex="2">
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
												<label class="control-label col-lg-4">Primary Email
													Id</label>
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
													Email Id</label>
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
										<h5>Work Contact Information</h5>
										<hr style="margin-top: -5px">
									</div>

								</div>



								<div class="row">

									<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
										<div class="row form-group">
											<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
												<label class="control-label col-lg-4">Adress Line 1</label>
											</div>
											<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
												<input type="text" class="form-control">
											</div>
										</div>
									</div>
									<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
										<div class="row form-group">
											<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
												<label class="control-label col-lg-4">Adress Line 2</label>
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
												<select class="form-control chzn-select" tabindex="2">
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
												<label class="control-label col-lg-4">Primary Email
													Id</label>
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
													Email Id</label>
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
												<label class="control-label col-lg-4">Social
													Contacts</label>
											</div>
											<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
												<select class="form-control chzn-select">
													<option>Select Social Type</option>
													<option>Facebook</option>
													<option>Twiter</option>
													<option>Linkedin</option>
													<option>Google+</option>
													<option>Youtube</option>
												</select>
											</div>
										</div>
									</div>

									<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
										<div class="row form-group">
											<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
												<label class="control-label col-lg-4">Add New Social</label>
											</div>
											<div class="col-lg-7 col-md-7 col-sm-10 col-xs-10">
												<input type="text" class="form-control">
											</div>

											<div class="col-lg-1 col-md-1 col-sm-2 col-xs-2 ">
												<ul class="nav nav-tabs pull-right">
													<li><a href="#addSocial" data-toggle="tooltip"
														data-original-title="Add Social"
														class="btn btn-metis-3 btn-line form-control"> <i
															class="fa fa-plus-square "></i>

													</a></li>
												</ul>
											</div>

										</div>
									</div>
								</div>

								<div class="row " class="tab-pane fade" id="addSocial">
									<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"
										id="dataTable">
										<div class="table-responsive">
											<table class="table table-bordered responsive-table">
												<thead>
													<tr id="myrow">
														<th style="width: 4%;">Action</th>
														<th>Social</th>
														<th>Social Id/Name</th>
													</tr>
												</thead>
												<tbody>
													<tr>
														<td align="center"><a href="#"
															class="btn btn-danger btn-xs close-box"> <i
																class="fa fa-trash-o"></i>
														</a></td>
														<td>Facebook</td>
														<td>kaluram@gmail.com</td>
													</tr>
													<tr>
														<td align="center"><a href="#"
															class="btn btn-danger btn-xs close-box"> <i
																class="fa fa-trash-o"></i>
														</a></td>
														<td>Twiter</td>
														<td>kaluram</td>
													</tr>
													<tr>
														<td align="center"><a href="#"
															class="btn btn-danger btn-xs close-box"> <i
																class="fa fa-trash-o"></i>
														</a></td>
														<td>Linkedin</td>
														<td>kaluram chakrawrti</td>
													</tr>
													<tr>
														<td align="center"><a href="#"
															class="btn btn-danger btn-xs close-box"> <i
																class="fa fa-trash-o"></i>
														</a></td>
														<td>Google+</td>
														<td>kaluram</td>
													</tr>

												</tbody>
											</table>
										</div>
									</div>
								</div>
								<div class="row" style="margin-top: 20px;">
									<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
										<h5>Profile Discription</h5>
										<hr style="margin-top: -5px">
									</div>
								</div>



								<div class="form-group">
									<div class="row" style="margin: 1% 2%;" id="data_grid">
										<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">

											<textarea id="wysihtml5" class="form-control" rows="10">
													<p>rajaram withour bold <b>rajaram with bold</b>
														</p>
													</textarea>


										</div>

									</div>
								</div>

								<div class="form-group">
									<div class="row">
										<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
												<div class="row">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
														<label class="control-label col-lg-4">Profile Picture</label>
													</div>
													<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
														<div class="fileinput fileinput-new"
															data-provides="fileinput">
															<div class="fileinput-new thumbnail"
																style="width: 200px; height: 150px;">
																<img data-src="holder.js/100%x100%" alt="...">
															</div>
															<div class="fileinput-preview fileinput-exists thumbnail"
																style="max-width: 200px; max-height: 150px;"></div>
															<div>
																<span class="btn btn-default btn-file"><span
																	class="fileinput-new">Select image</span> <span
																	class="fileinput-exists">Change</span> <input
																	type="file" name="..."> </span> <a href="#"
																	class="btn btn-default fileinput-exists"
																	data-dismiss="fileinput">Remove</a>
															</div>
														</div>
													</div>
												</div>

											</div> 
										</div>
									</div>
								</div>


								</form>
							</div>

							<div class="row">
								<div
									class="col-lg-4 col-md-4 col-sm-12 col-xs-12 col-md-offset-5">
									<a href="#" class="btn btn-default">Cancel</a> <a href="#"
										class="btn btn-success">Clear</a> <a href="#"
										class="btn btn-primary">Save</a>
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