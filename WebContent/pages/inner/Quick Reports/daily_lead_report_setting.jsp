<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="/struts-jquery-tags" prefix="sj"%>




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
							<li class="active"><a href="leadReports.action"><s:text
										name="Lead Reports"></s:text></a></li>
							<li class="active"><a href="dailyLeadReports.action"><s:text
										name="Daily Lead Reports"></s:text></a></li>
							<li class="active"><s:text name="Daily Lead Reports Setting"></s:text></li>
						</ol>
						<div class="box">
							<header>
								<div class="pull-left">
									<a class="icons" href="dailyLeadReports.action" data-toggle="tooltip"
										data-original-title="Back To Daily Lead DashBoard"> <i
										class="fa fa-table"></i>
									</a>

									<h5 class="header_color">
										<s:text name="Daily Lead Reports Setting"></s:text>
									</h5>
								</div>
								<div class="pull-right">
									<div class="btn-group">

										<a class="btn btn-success btnheight" data-toggle="tooltip"
											data-original-title="Refresh"
											href="dailyLeadReportsSetting.action"><i
											class="fa fa-refresh "></i></a> <a href="dailyLeadReports.action"
											data-toggle="tooltip" data-original-title="Close"
											class="btn btn-danger btnheight"><i
											class="fa fa-times fontawesomeht"></i></a>
									</div>

								</div>
							</header>
<s:form action="dailyLeadSet">
							<div id="collapse4" class="body">
								<div class="table-responsive">
									<div class="alert alert-info" role="alert">
										<div class="infoIcon">
											<i class="fa fa-info-circle "></i>
											<s:text name="You can Select Colomn for Reporting" />
										</div>
									</div>
									<div class="panel panel-default">
										<div class="panel-body">
											<div class="center">

												<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"
													id="view_lable_value1">
													<div class="col-lg-2 col-md-2 col-sm-8 col-xs-8"></div>
													<div class="col-lg-2 col-md-2 col-sm-8 col-xs-8">
														<s:text name="lead.dashboard.leadid"></s:text>
													</div>
													<div class="col-lg-1 col-md-1 col-sm-4 col-xs-4">
														<s:checkbox name="leadId" value="LeadId"></s:checkbox>
													</div>
													<div class="col-lg-2 col-md-2 col-sm-8 col-xs-8">
														<s:text name="lead.dashboard.leadtitle"></s:text>
													</div>
													<div class="col-lg-1 col-md-1 col-sm-4 col-xs-4">
														<s:checkbox name="leadTitle" value="LeadTitle" checked="checked"></s:checkbox>
													</div>
													<div class="col-lg-2 col-md-2 col-sm-8 col-xs-8">
														<s:text name="lead.dashboard.company"></s:text>
													</div>
													<div class="col-lg-1 col-md-1 col-sm-4 col-xs-4">
														<s:checkbox name="company" value="Company" checked="checked"></s:checkbox>
													</div>
												</div>
												<div id="view_lable_value3"
													class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
													<div class="col-lg-2 col-md-2 col-sm-8 col-xs-8"></div>
													<div class="col-lg-2 col-md-2 col-sm-8 col-xs-8">
														<s:text name="lead.dashboard.companyType"></s:text>
													</div>
													<div class="col-lg-1 col-md-1 col-sm-4 col-xs-4">
														<s:checkbox name="companyType" value="companyType"></s:checkbox>
													</div>
													<div class="col-lg-2 col-md-2 col-sm-8 col-xs-8">
														<s:text name="lead.dashboard.companyCategory"></s:text>
													</div>
													<div class="col-lg-1 col-md-1 col-sm-4 col-xs-4">
														<s:checkbox name="companyCategory" value="companyCategory"></s:checkbox>
													</div>
													<div class="col-lg-2 col-md-2 col-sm-8 col-xs-8">
														<s:text name="lead.dashboard.companySector"></s:text>
													</div>
													<div class="col-lg-1 col-md-1 col-sm-4 col-xs-4">
														<s:checkbox name="companySector" value="companySector"></s:checkbox>
													</div>
												</div>
												<div id="view_lable_value1"
													class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
													<div class="col-lg-2 col-md-2 col-sm-8 col-xs-8"></div>
													<div class="col-lg-2 col-md-2 col-sm-8 col-xs-8">
														<s:text name="lead.dashboard.contactperson"></s:text>
													</div>
													<div class="col-lg-1 col-md-1 col-sm-4 col-xs-4">
														<s:checkbox name="contactPerson" value="contactPerson" checked="checked"></s:checkbox>
													</div>
													<div class="col-lg-2 col-md-2 col-sm-8 col-xs-8">
														<s:text name="lead.dashboard.leadSourceName"></s:text>
													</div>
													<div class="col-lg-1 col-md-1 col-sm-4 col-xs-4">
														<s:checkbox name="leadSourceName" value="leadSourceName"></s:checkbox>
													</div>
													<div class="col-lg-2 col-md-2 col-sm-8 col-xs-8">
														<s:text name="lead.dashboard.leadowner"></s:text>
													</div>
													<div class="col-lg-1 col-md-1 col-sm-4 col-xs-4">
														<s:checkbox name="leadOwner" value="leadOwner" checked="checked"></s:checkbox>
													</div>
												</div>


												<div id="view_lable_value3"
													class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
													<div class="col-lg-2 col-md-2 col-sm-8 col-xs-8"></div>

													<div class="col-lg-2 col-md-2 col-sm-8 col-xs-8">
														<s:text name="lead.dashboard.annualRevenue"></s:text>
													</div>
													<div class="col-lg-1 col-md-1 col-sm-4 col-xs-4">
														<s:checkbox name="annualRevenue" value="annualRevenue"></s:checkbox>
													</div>
													<div class="col-lg-2 col-md-2 col-sm-8 col-xs-8">
														<s:text name="lead.dashboard.phoneNo"></s:text>
													</div>
													<div class="col-lg-1 col-md-1 col-sm-4 col-xs-4">
														<s:checkbox name="phoneNo" value="phoneNo"></s:checkbox>
													</div>
													<div class="col-lg-2 col-md-2 col-sm-8 col-xs-8">
														<s:text name="lead.dashboard.mobileNo"></s:text>
													</div>
													<div class="col-lg-1 col-md-1 col-sm-4 col-xs-4">
														<s:checkbox name="mobileNo" value="mobileNo"></s:checkbox>
													</div>
												</div>



												<div id="view_lable_value1"
													class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
													<div class="col-lg-2 col-md-2 col-sm-8 col-xs-8"></div>
													<div class="col-lg-2 col-md-2 col-sm-8 col-xs-8">
														<s:text name="add.create.lead.lead.date"></s:text>
													</div>
													<div class="col-lg-1 col-md-1 col-sm-4 col-xs-4">
														<s:checkbox name="leadDate" value="leadDate" checked="checked"></s:checkbox>
													</div>
													<div class="col-lg-2 col-md-2 col-sm-8 col-xs-8">
														<s:text name="lead.dashboard.expecteddate"></s:text>
													</div>
													<div class="col-lg-1 col-md-1 col-sm-4 col-xs-4">
														<s:checkbox name="expectedDate" value="expectedDate" checked="checked"></s:checkbox>
													</div>
													<div class="col-lg-2 col-md-2 col-sm-8 col-xs-8">
														<s:text name="lead.dashboard.leadSourceName"></s:text>
													</div>
													<div class="col-lg-1 col-md-1 col-sm-4 col-xs-4">
														<s:checkbox name="leadSourceName" value="leadSourceName"></s:checkbox>
													</div>

												</div>
												<div id="view_lable_value3"
													class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
													<div class="col-lg-2 col-md-2 col-sm-8 col-xs-8"></div>
													<div class="col-lg-2 col-md-2 col-sm-8 col-xs-8">
														<s:text name="lead.dashboard.noOfAssociates"></s:text>
													</div>
													<div class="col-lg-1 col-md-1 col-sm-4 col-xs-4">
														<s:checkbox name="noOfAssociates" value="noOfAssociates"></s:checkbox>
													</div>
													<div class="col-lg-2 col-md-2 col-sm-8 col-xs-8">
														<s:text name="lead.dashboard.status"></s:text>
													</div>
													<div class="col-lg-1 col-md-1 col-sm-4 col-xs-4">
														<s:checkbox name="status" value="status" checked="checked"></s:checkbox>
													</div>
													<div class="col-lg-2 col-md-2 col-sm-8 col-xs-8">
														<s:text name="lead.dashboard.add1"></s:text>
													</div>
													<div class="col-lg-1 col-md-1 col-sm-4 col-xs-4">
														<s:checkbox name="add1" value="add1"></s:checkbox>
													</div>
												</div>
												<div id="view_lable_value1"
													class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
													<div class="col-lg-2 col-md-2 col-sm-8 col-xs-8"></div>
													<div class="col-lg-2 col-md-2 col-sm-8 col-xs-8">
														<s:text name="lead.dashboard.city"></s:text>
													</div>
													<div class="col-lg-1 col-md-1 col-sm-4 col-xs-4">
														<s:checkbox name="city" value="city"></s:checkbox>
													</div>
													<div class="col-lg-2 col-md-2 col-sm-8 col-xs-8">
														<s:text name="lead.dashboard.state"></s:text>
													</div>
													<div class="col-lg-1 col-md-1 col-sm-4 col-xs-4">
														<s:checkbox name="state" value="state"></s:checkbox>
													</div>
													<div class="col-lg-2 col-md-2 col-sm-8 col-xs-8">
														<s:text name="lead.dashboard.emailID"></s:text>
													</div>
													<div class="col-lg-1 col-md-1 col-sm-4 col-xs-4">
														<s:checkbox name="emailID" value="emailID"></s:checkbox>
													</div>
												</div>
												<div id="view_lable_value3"
													class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
													<div class="col-lg-2 col-md-2 col-sm-8 col-xs-8"></div>
													<div class="col-lg-2 col-md-2 col-sm-8 col-xs-8">
														<s:text name="lead.dashboard.requirement"></s:text>
													</div>
													<div class="col-lg-1 col-md-1 col-sm-4 col-xs-4">
														<s:checkbox name="requirement" value="requirement"></s:checkbox>
													</div>
													<div class="col-lg-2 col-md-2 col-sm-8 col-xs-8">
														<s:text name="lead.dashboard.website"></s:text>
													</div>
													<div class="col-lg-1 col-md-1 col-sm-4 col-xs-4">
														<s:checkbox name="website" value="website"></s:checkbox>
													</div>
													<div class="col-lg-2 col-md-2 col-sm-8 col-xs-8">
														<s:text name="lead.dashboard.rating"></s:text>
													</div>
													<div class="col-lg-1 col-md-1 col-sm-4 col-xs-4">
														<s:checkbox name="rating" value="rating"></s:checkbox>
													</div>
												</div>

												<div id="view_lable_value1"
													class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
													<div class="col-lg-2 col-md-2 col-sm-8 col-xs-8"></div>
													<div class="col-lg-2 col-md-2 col-sm-8 col-xs-8">
														<s:text name="lead.dashboard.leadUrl"></s:text>
													</div>
													<div class="col-lg-1 col-md-1 col-sm-4 col-xs-4">
														<s:checkbox name="leadUrl" value="leadUrl"></s:checkbox>
													</div>
													<div class="col-lg-2 col-md-2 col-sm-8 col-xs-8">
														<s:text name="lead.dashboard.leadOwner"></s:text>
													</div>
													<div class="col-lg-1 col-md-1 col-sm-4 col-xs-4">
														<s:checkbox name="leadOwner" value="leadOwner"></s:checkbox>
													</div>
													<div class="col-lg-2 col-md-2 col-sm-8 col-xs-8">
														<s:text name="lead.dashboard.LeadFilePath"></s:text>
													</div>
													<div class="col-lg-1 col-md-1 col-sm-4 col-xs-4">
														<s:checkbox name="LeadFilePath" value="LeadFilePath"></s:checkbox>
													</div>

												</div>
												<div id="view_lable_value3"
													class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
													<div class="col-lg-2 col-md-2 col-sm-8 col-xs-8"></div>

													<div class="col-lg-2 col-md-2 col-sm-8 col-xs-8">
														<s:text name="lead.dashboard.createdBy"></s:text>
													</div>
													<div class="col-lg-1 col-md-1 col-sm-4 col-xs-4">
														<s:checkbox name="createdBy" value="createdBy"></s:checkbox>
													</div>
													<div class="col-lg-2 col-md-2 col-sm-8 col-xs-8">
														<s:text name="lead.dashboard.createdDate"></s:text>
													</div>
													<div class="col-lg-1 col-md-1 col-sm-4 col-xs-4">
														<s:checkbox name="createdDate" value="createdDate"></s:checkbox>
													</div>
													<div class="col-lg-2 col-md-2 col-sm-8 col-xs-8">
														<s:text name="lead.dashboard.rating"></s:text>
													</div>
													<div class="col-lg-1 col-md-1 col-sm-4 col-xs-4">
														<s:checkbox name="rating" value="rating"></s:checkbox>
													</div>
												</div>

											</div>
										</div>


										<div class="row">
											<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"
												align="center">
												<%-- <a href="dailyLeadReports.action" data-toggle="tooltip"
													data-original-title="Back To Daily Lead Report"
													class="btn btn-default btnheight" ontheme="simple"
													tabindex="38"><i
													class="fa fa-caret-square-o-left fontawesomeht"></i> <s:text
														name="project.form.button.cancel" /> </a> <a
													href="viewDailyLeadReports.action" data-toggle="tooltip"
													data-original-title="project.form.button.next"
													class="btn btn-primary btnheight" ontheme="simple"
													tabindex="38"><i class="fa fa-check"></i> <s:text
														name="project.form.button.next" /> </a> --%>
														<s:submit/>


											</div>
										</div>

										<br>

									</div>
								</div>
							</div>
						</s:form>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>



	<script src="pages/inner/assets/js/calculater.js"></script>
	<script>
		$(function() {
			Metis.formGeneral();
			Metis.formWysiwyg();
		});
	</script>

	<script src="/outer/js/gen_validatorv4.js" type="text/javascript"></script>
	<script type="text/javascript">
		function validate() {
			var frmvalidator = new Validator("advanceSearchForm");
			frmvalidator.EnableOnPageErrorDisplay();
			frmvalidator.EnableMsgsTogether();

			frmvalidator.addValidation("searchId", "dontselect=-1",
					"Select Search Type");
			var selectedIndex = document.getElementById('advanceSearch');

			if (selectedIndex.value == 1) {
				frmvalidator.addValidation("leadId", "req", "Enter Lead Id");
			} else if (selectedIndex.value == 2) {
				frmvalidator.addValidation("companyName", "dontselect=-1",
						"Select Company Name");
			} else if (selectedIndex.value == 3) {
				frmvalidator.addValidation("leadTitle", "dontselect=-1",
						"Select Lead Title");
			} else if (selectedIndex.value == 4) {
				frmvalidator.addValidation("contactPerson", "dontselect=-1",
						"Select Contact Person");
			} else if (selectedIndex.value == 5) {
				frmvalidator.addValidation("leadOwner", "dontselect=-1",
						"Select Lead Owner");
			} else if (selectedIndex.value == 6) {
				frmvalidator.addValidation("leadDate", "req",
						"Select Lead Date");
			} else if (selectedIndex.value == 7) {
				frmvalidator.addValidation("expectedClosingDate", "req",
						"Select Expected Closing Date");
			} else if (selectedIndex.value == 8) {
				frmvalidator.addValidation("leadStatus", "dontselect=-1",
						"Select Lead Status");
			}
		}
	</script>
</body>
