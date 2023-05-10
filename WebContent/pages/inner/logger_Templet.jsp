<%@taglib uri="/struts-tags" prefix="s"%>
<body>
	<div id="content">
		<div class="outer">
			<div class="inner bg-light lter">

				<!--BEGIN INPUT TEXT FIELDS-->
				<div class="row">
					<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
						<ol class="breadcrumb" style="margin-top: 10px;">
							<li><a href="omiInnerDashboard.action"><i
									class="fa fa-home"></i></a></li>
							<li class="active"><s:text name="MyAccount"></s:text></li>
							<li class="active"><s:text name="myAccount.menu.logger"></s:text></li>

						</ol>
						<div class="box dark">
							<header>
								<div class="icons">
									<i class="fa fa-th-large"></i>
								</div>
								<h5>My Account</h5>

								<!-- .toolbar -->
							
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
										<a href="addCreatedLead.action" data-toggle="tooltip"
											data-original-title="Refresh"
											class="btn btn-success btnheight"><i
											class="fa fa-refresh "></i></a> <a href="leadDashboard.action"
											data-toggle="tooltip" data-original-title="Close"
											class="btn btn-danger btnheight"><i
											class="fa fa-times fontawesomeht"></i></a>
									</div>

								</div>
								<!-- /.toolbar -->
							</header>
							<div class="container-fluid">

								<p>
									<s:if test="hasActionErrors()">
										<div class="alert alert-danger" role="alert"
											style="margin-top: 25px; padding-bottom: 7px;">
											<div class="infoIcon">
												<i class="fa fa-times-circle "></i>
												<s:actionerror />
											</div>
										</div>
									</s:if>
									<s:elseif test="hasActionMessages()">
										<div class="alert alert-success" role="alert"
											style="margin-top: 25px; padding-bottom: 7px;">
											<div class="infoIcon">
												<!-- <i class="fa fa-check-circle "></i> -->
												<s:actionmessage />
											</div>
										</div>
									</s:elseif>
									<s:else>

										<div class="alert alert-info" role="alert"
											style="margin-top: 25px;">
											<div class="infoIcon">
												<i class="fa fa-info-circle "></i>
												<s:text name="myaccount.logger.information.bar" />
											</div>
										</div>
									</s:else>
								</p>



								<!-- Nav tabs -->
								<ul class="nav nav-tabs" role="tablist">
									<li role="presentation"><a href="profileTemplet.action"
										style="color: Gray;"><s:text
												name="myAccount.menu.userProfile" /></a></li>

									<li role="presentation"><a
										href="myAccountSocialInformation.action" style="color: Gray;"><s:text
												name="myAccount.menu.social.information"></s:text> </a></li>
									<li role="presentation"><a
										href="changePasswordTemplet.action" style="color: Gray;"><s:text
												name="myAccount.menu.change.password"></s:text></a></li>
									<li role="presentation"><a
										href="changeEmailTemplet.action" style="color: Gray;"><s:text
												name="myAccount.menu.change.e-mail" /> </a></li>
									<li role="presentation"><a
										href="securityQuestionTemplet.action" style="color: Gray;"><s:text
												name="myAccount.menu.security.question"></s:text></a></li>
									<li role="presentation"><a
										href="closeAccountTemplet.action" style="color: Gray;"><s:text
												name="myAccount.menu.close.account" /></a></li>
									<li role="presentation" class="active"><a
										href="loggerTemplet.action"
										style="background-color: #F9F9F9; color: Gray;"><s:text
												name="myAccount.menu.logger" /></a></li>
								</ul>

								<!-- Tab panes -->
								<div id="content" style="background-color:;">



									<!--BEGIN INPUT TEXT FIELDS-->
									<div class="row">
										<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
											<div class="box inverse"
												style="margin-top: -10px; margin-bottom: 0px;">

												<%-- 
												<div class="alert alert-info" role="alert"
													style="margin-top: 25px; margin-left: 20px; margin-right: 20px;">
													<span class="fa fa-info" style="margin-right: 10px;"></span>User
													logger
												</div> --%>
												<div id="collapse4" class="body"
													style="margin-top: 25px; margin-left: 20px; margin-right: 20px;">
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
																<s:iterator value="userLoggerGrid">
																	<tr>

																		<td><s:property value="ipAddress" /></td>
																		<td><s:property value="loginTime" /></td>
																		<td><s:property value="logOutTime" /></td>
																		<td><s:property value="status" /></td>
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
