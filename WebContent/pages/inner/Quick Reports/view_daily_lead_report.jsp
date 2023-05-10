<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="/struts-jquery-tags" prefix="sj"%>


<script type="text/javascript">
	function showElements() {

		var selectedIndex = document.getElementById('advanceSearch');

		var element1 = document.getElementById('dp3');
		var element2 = document.getElementById('dp4');

		if (selectedIndex.value == 6) {
			element1.style.display = 'block';
			element2.style.display = 'none';

		} else if (selectedIndex.value == 7) {
			element1.style.display = 'none';
			element2.style.display = 'block';

		}
	}
</script>

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
							<li class="active"><a href="dailyLeadReportsSetting.action"><s:text name="Lead Reports"></s:text></a></li>
							<li class="active"><s:text name="Daily Lead Reports"></s:text></li>
						</ol>
						<div class="box">
							<header>
								<div class="pull-left">
									<a class="icons" href="dailyLeadReportsSetting.action" data-toggle="tooltip"
										data-original-title="Back To Report Setting DashBoard"> <i
										class="fa fa-table"></i>
									</a>

									<h5 class="header_color">
										<s:text name="Daily Lead Reports"></s:text>
									</h5>
								</div>
								<div class="pull-right">
									<div class="btn-group">


										<a class="btn btn-success btnheight" data-toggle="tooltip"
											data-original-title="Refresh" href="dailyLeadReports.action"><i
											class="fa fa-refresh "></i></a> <a href="leadExcelReport.action"
											type="button" data-toggle="tooltip"
											data-original-title="XLS Report"
											class="btn btn-default btnheight"><i
											class="fa fa-file-excel-o fontawesomeht"></i></a> <a
											href="dailyLeadReportsSetting.action" data-toggle="tooltip"
											data-original-title="Close" class="btn btn-danger btnheight"><i
											class="fa fa-times fontawesomeht"></i></a>
									</div>

								</div>
							</header>

							<div id="collapse4" class="body">
								<div class="table-responsive">
									<p>
										<s:if test="hasActionErrors()">
											<div class="alert alert-danger" style="padding-bottom: 7px;"
												role="alert">
												<div class="infoIcon">
													<s:actionerror />
												</div>
											</div>
										</s:if>
										<s:elseif test="hasActionMessages()">
											<div class="alert alert-success" role="alert">
												<div class="infoIcon">
													<s:actionmessage />
												</div>
											</div>
										</s:elseif>
										<s:else>

											<div class="alert alert-info" role="alert">
												<div class="infoIcon">
													<i class="fa fa-info-circle "></i>
													<s:text name="add.create.lead.information.bar" />
												</div>
											</div>
										</s:else>
									</p>
									<div id="collapse1" class="panel-collapse collapse">
										<div class="row searchBar">
											<s:form name="advanceSearchForm" method="POST"
												acton="populateLeadDetailsAsPerSearch">
												<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"
													style="margin-top: 8px;">

													<div class="col-lg-1  col-md-1  col-sm-12 col-xs-12">
														<label>
															<h5>
																<s:text name="lead.dashboard.searchby"></s:text>
															</h5>
														</label>
													</div>
													<div class="col-lg-4  col-md-4  col-sm-12 col-xs-12">
														<s:textfield type="text" name="leadDate"
															class="form-control" id="dp3" cssClass="form-control"
															tabindex="14" readonly="true" placeholder="Start Date" />

														<div id='advanceSearchForm_leadDate_errorloc'
															class="error_strings"></div>
													</div>
													<div class="col-lg-4  col-md-4  col-sm-12 col-xs-12">
														<div class="input-group">
															<s:textfield type="text" name="leadDat" id="dp4"
																cssClass="form-control" tabindex="14" readonly="true"
																placeholder="Closing Date" />

															<span class="input-group-btn">
																<button type="submit" data-toggle="tooltip"
																	onclick="validate();" data-original-title="Search"
																	class="btn btn-metis-5 btn-line">
																	<span class="glyphicon glyphicon-search"></span>&nbsp;Search
																</button>
															</span>
														</div>

													</div>
												</div>
											</s:form>
										</div>
									</div>
									<table id="dataTable"
										class="table table-bordered table-condensed table-hover table-striped">
										<thead>
											<tr id="myrow">
		
												<th><s:text name="lead.dashboard.leadid"></s:text></th>
												<th><s:text name="lead.dashboard.company"></s:text></th>
												<th><s:text name="lead.dashboard.leadtitle"></s:text></th>
												<th><s:text name="lead.dashboard.contactperson"></s:text></th>
												<th><s:text name="lead.dashboard.leadowner"></s:text></th>
												<th><s:text name="add.create.lead.lead.date"></s:text></th>
												<th><s:text name="lead.dashboard.expecteddate"></s:text></th>
												<th><s:text name="lead.dashboard.status"></s:text></th>

											</tr>
										</thead>
										<tbody>
											<s:iterator value="leadDetailList">
												<tr>

													<td><a style="color: blue"
														href="viewLead?command=<s:property value='leadId' />"><s:property
																value='leadId' /></a></td>
													<td><s:property value="companyName" /></td>
													<td><s:property value="leadTitle" /></td>
													<td><s:property value="fullName" /></td>
													<td><s:property value="leadOwner" /></td>
													<td><s:property value="leadDate" /></td>
													<td><s:property value="expectedClosingDate" /></td>
													<td><s:property value="leadSourceStatus" /></td>


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

	<script src="pages/inner/assets/js/calculater.js"></script>
	<script>
		$(function() {
			Metis.formGeneral();
			Metis.formWysiwyg();
		});
	</script>

	<%-- <script src="/outer/js/gen_validatorv4.js" type="text/javascript"></script>
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
	</script> --%>
</body>
