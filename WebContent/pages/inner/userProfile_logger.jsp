<%@taglib uri="/struts-tags" prefix="s"%>
<body>
	<div id="content">
		<div class="outer">
			<div class="inner bg-light lter">

				<!--BEGIN INPUT TEXT FIELDS-->
				<div class="row">
					<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
						<div class="box inverse">
							<header>
							<div class="icons">
								<i class="fa fa-th-large"></i>
							</div>
							<h5>User Management</h5>

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
									<li role="presentation"><a
										href="userProfile"
										style="color: Gray;"><s:text
												name="myAccount.menu.userProfile" /></a></li>

									<li role="presentation" ><a
										href="userProfileSocialInformation"
										style="color: Gray;"><s:text
												name="myAccount.menu.social.information"></s:text> </a></li>
									<li role="presentation"><a
										href="userProfileSecurityChangePassword" style="color: Gray;"><s:text
												name="myAccount.menu.change.password"></s:text></a></li>
									<li role="presentation"><a
										href="userProfileSecurityChangeEmail" style="color: Gray;"><s:text
												name="myAccount.menu.change.e-mail" /> </a></li>
									
									<li role="presentation" class="active"><a href="userProfileloggerTemplet"
										style="background-color: #F9F9F9; color: Gray;"><s:text name="myAccount.menu.logger" /></a></li>
								</ul>

								<!-- Tab panes -->
								<div id="content" style="background-color: ;">



									<!--BEGIN INPUT TEXT FIELDS-->
									<div class="row">
										<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
											<div class="box inverse"
												style="margin-top: -10px; margin-bottom: 0px;">


												<div class="alert alert-info" role="alert"
													style="margin-top: 25px; margin-left: 20px; margin-right: 20px;">
													<span class="fa fa-info" style="margin-right: 10px;"></span>User logger
												</div>
												<div id="collapse4" class="body">
													<div class="table-responsive">
														<table id="dataTable"
															class="table table-bordered table-condensed table-hover table-striped">
															<thead>
																<tr id="myrow">
																	<th>IP Address</th>
																	<th>Login</th>
																	<th>Logout</th>
																	<th>Status</th>
							
																</tr>
															</thead>
															<tbody>
																<tr>
																	<td>123.124.23.4</td>
																	<td>12-01-2015 10:30AM</td>
																	<td>12-01-2015 12:15PM</td>
																	<td>Current session</td>
																	
																</tr>
																<tr>
																	<td>123.124.23.4</td>
																	<td>12-01-2015 10:30AM</td>
																	<td>12-01-2015 12:15PM</td>
																	<td>Logout</td>
																	
																</tr>
																<tr>
																	<td>123.124.23.4</td>
																	<td>12-01-2015 10:30AM</td>
																	<td>12-01-2015 12:15PM</td>
																	<td>Session Timeout</td>
																	
																</tr>
																<tr>
																	<td>123.124.23.4</td>
																	<td>12-01-2015 10:30AM</td>
																	<td>12-01-2015 12:15PM</td>
																	<td>Duel session</td>
																	
																</tr>
																<tr>
																	<td>123.124.23.4</td>
																	<td>12-01-2015 10:30AM</td>
																	<td>12-01-2015 12:15PM</td>
																	<td>Current session</td>
																	
																</tr>
																<tr>
																	<td>123.124.23.4</td>
																	<td>12-01-2015 10:30AM</td>
																	<td>12-01-2015 12:15PM</td>
																	<td>Current session</td>
																	
																</tr>
																<tr>
																	<td>123.124.23.4</td>
																	<td>12-01-2015 10:30AM</td>
																	<td>12-01-2015 12:15PM</td>
																	<td>Current session</td>
																	
																</tr>
																<tr>
																	<td>123.124.23.4</td>
																	<td>12-01-2015 10:30AM</td>
																	<td>12-01-2015 12:15PM</td>
																	<td>Current session</td>
																	
																</tr>
																<tr>
																	<td>123.124.23.4</td>
																	<td>12-01-2015 10:30AM</td>
																	<td>12-01-2015 12:15PM</td>
																	<td>Current session</td>
																	
																</tr>
																<tr>
																	<td>123.124.23.4</td>
																	<td>12-01-2015 10:30AM</td>
																	<td>12-01-2015 12:15PM</td>
																	<td>Current session</td>
																	
																</tr>
																<tr>
																	<td>123.124.23.4</td>
																	<td>12-01-2015 10:30AM</td>
																	<td>12-01-2015 12:15PM</td>
																	<td>Current session</td>
																	
																</tr>
																<tr>
																	<td>123.124.23.4</td>
																	<td>12-01-2015 10:30AM</td>
																	<td>12-01-2015 12:15PM</td>
																	<td>Current session</td>
																	
																</tr>
																<tr>
																	<td>123.124.23.4</td>
																	<td>12-01-2015 10:30AM</td>
																	<td>12-01-2015 12:15PM</td>
																	<td>Current session</td>
																	
																</tr>
																<tr>
																	<td>123.124.23.4</td>
																		<td>12-01-2015 10:30AM</td>
																	<td>12-01-2015 12:15PM</td>
																	<td>Current session</td>
																	
																</tr>
																
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
					</div>
				</div>
			</div>
		</div>
	</div>
	<script>
		$(function() {
			Metis.MetisTable();
			Metis.metisSortable();
		});
	</script>
	</body>
