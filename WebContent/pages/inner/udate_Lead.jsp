<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="/struts-jquery-tags" prefix="sj"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
.error_strings {
	color: red;
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
						<div class="box inverse">
							<header>
							<div class="icons">
								<i class="fa fa-th-large"></i>
							</div>
							<h5>Lead FollowUp</h5>

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
									<li role="presentation" class="active"><a
										href="updateLead.action"
										style="background-color: #F9F9F9; color: Gray;"><s:text
												name="update.Lead.tabs.lead.information" /></a></li>
									<li role="presentation"><a href="updateLeadContact.action"
										style="color: Gray;"><s:text
												name="update.Lead.tabs.contact.information" /></a></li>
									<li role="presentation"><a href="updateLeadSocial.action"
										style="color: Gray;"><s:text
												name="update.Lead.tabs.social.information" /></a></li>
									<li role="presentation"><a
										href="updateLeadRequirement.action" style="color: Gray;"><s:text
												name="update.Lead.tabs.requirement" /></a></li>
									<li role="presentation"><a href="updateLeadFolloup.action"
										style="color: Gray;"><s:text
												name="update.Lead.tabs.follow.up" /></a></li>

								</ul>

								<!-- Tab panes -->
								<div id="content" style="background-color: #F9F9F9;">



									<!--BEGIN INPUT TEXT FIELDS-->
									<div class="row">
										<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
											<div class="box inverse"
												style="margin-top: -10px; margin-bottom: 0px; padding-left: 20px;">


												<div class="alert alert-info" role="alert" 
													style="margin-top: 25px; margin-right: 20px;">
													<span class="fa fa-info" style="margin-right: 10px;"></span>
													<s:text name="update.Lead.information.bar" />
												</div>

												<s:form name="updateLeadForm">



													<div class="row">
														<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
															<div class="row form-group">
																<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">

																	<s:text name="add.create.lead.company" />
																</div>
																<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">

																	<s:textfield type="text" name="companyName"
																		cssClass="form-control" />
																	<div id='updateLeadForm_companyName_errorloc'
																		class="error_strings"></div>
																</div>
															</div>
														</div>


														<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
															<div class="row form-group">
																<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">

																	<s:text name="add.create.lead.contactperson" />
																</div>
																<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
																	<div class="row">
																		<div class="col-lg-3 col-md-3 col-sm-3 col-xs-5">
																			<s:select class="form-control" name="salutation"
																				id=""
																				list="{'Mr.','Miss.','Mrs.','Dr.','Prof.','Other'}"
																				cssClass="form-control" headerKey="-1"
																				headerValue="Salutation" />
																		</div>
																		<div class="col-lg-9 col-md-9 col-sm-9 col-xs-12">
																			<s:textfield type="text" name="contactPerson"
																				class="form-control" cssClass="form-control" />
																			<div id='updateLeadForm_contactPerson_errorloc'
																				class="error_strings"></div>
																		</div>
																	</div>
																</div>
															</div>

														</div>
													</div>


													<div class="row">
														<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
															<div class="row form-group">
																<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
																	<s:text name="add.create.lead.leadtitle" />
																</div>
																<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">

																	<s:select name="leadTitle"
																		cssClass="form-control chzn-select" headerKey="-1"
																		headerValue="Select Lead Title" tabindex="2"
																		list="leadTitleList"></s:select>
																	<a href="login.html" data-toggle="tooltip"
																		data-original-title="Add" data-placement="bottom"
																		class="btn btn-metis-3 btn-line"> <i
																		class="fa fa-plus-square "></i>
																	</a>
																	<div id='updateLeadForm_leadTitle_errorloc'
																		class="error_strings"></div>
																</div>
															</div>
														</div>


														<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
															<div class="row form-group">
																<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">

																	<s:text name="add.create.lead.company.type" />
																</div>
																<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
																	<s:select name="companyType" list="companyTypeList"
																		headerKey="-1" headerValue="Select Company Type"
																		cssClass="form-control chzn-select" tabindex="2">
																	</s:select>
																</div>
															</div>
														</div>

													</div>



													<div class="row">
														<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
															<div class="row form-group">
																<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">

																	<s:text name="add.create.lead.company.category" />
																</div>
																<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
																	<s:select list="companyCategoryList"
																		name="companyCategory"
																		cssClass="form-control chzn-select" tabindex="2"
																		headerKey="-1" headerValue="Select Company Category">
																	</s:select>
																</div>
															</div>
														</div>
														<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
															<div class="row form-group">
																<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">

																	<s:text name="add.create.lead.company.sector" />
																</div>
																<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">

																	<s:select list="companySectorList" name="companySector"
																		headerKey="-1" headerValue="Select Company Sector"
																		tabindex="2" cssClass="form-control chzn-select">
																	</s:select>
																</div>
															</div>
														</div>
													</div>



													<div class="row">
														<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
															<div class="row form-group">
																<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">

																	<s:text name="add.create.lead.lead.source" />
																</div>
																<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">

																	<s:select list="{'Leads','Contact'}" name="leadSource"
																		headerKey="-1" headerValue="Select Lead Source"
																		tabindex="2" cssClass="form-control chzn-select" />
																</div>
															</div>
														</div>
														<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
															<div class="row form-group">
																<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
																	<s:text name="add.create.lead.lead.sourceName" />

																</div>
																<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">

																	<s:select list="{'Just Dail','Shaikh'}"
																		name="leadSourcename" headerKey="-1"
																		headerValue="Select Lead Source Name"
																		cssClass="form-control chzn-select" />
																</div>
															</div>
														</div>
													</div>



													<div class="row">
														<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
															<div class="row form-group">

																<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
																	<s:text name="add.create.lead.no.of.associate" />
																</div>
																<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
																	<s:textfield name="noOfAssociate"
																		cssClass="form-control" />
																	<div id='updateLeadForm_noOfAssociate_errorloc'
																		class="error_strings"></div>
																</div>
															</div>
														</div>
														<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
															<div class="row form-group">
																<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
																	<!-- <label class="control-label col-lg-4">Annual
																		Reneue</label> -->
																	<s:text name="add.create.lead.annual.revneue" />
																</div>
																<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
																	<div class="row">
																		<div class="col-lg-3 col-md-3 col-sm-3 col-xs-5">
																			<s:select class="form-control" name="" id=""
																				list="{'Select Option'}" cssClass="form-control"
																				headerKey="-1" headerValue="Select Lead Title" />
																		</div>
																		<div class="col-lg-9 col-md-9 col-sm-9 col-xs-12">
																			<s:textfield type="text" name="annualRevenue"
																				cssClass="form-control" />
																		</div>
																	</div>
																</div>
															</div>
														</div>
													</div>



													<div class="row">
														<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
															<div class="row form-group">
																<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
																	<s:text name="add.create.lead.lead.date" />
																</div>
																<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">

																	<s:textfield type="text" name="leadDate"
																		class="form-control" id="dp1" cssClass="form-control" />
																	<div id='updateLeadForm_leadDate_errorloc'
																		class="error_strings"></div>

																</div>
															</div>
														</div>
														<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
															<div class="row form-group">
																<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">

																	<s:text name="add.create.lead.expected.closing.date" />
																</div>
																<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
																	<s:textfield type="text" name="expectedClosingDate"
																		cssClass="form-control" id="dp2" />
																	<div id='updateLeadForm_expectedClosingDate_errorloc'
																		class="error_strings"></div>
																</div>
															</div>
														</div>
													</div>

													<div class="row">
														<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
															<div class="row form-group">
																<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
																	<s:text name="update.Lead.lead.owner" />
																</div>
																<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
																	<s:textfield type="text" name="leadOwner"
																		cssClass="form-control" disabled="true" />
																</div>
															</div>
														</div>


														<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
															<div class="row form-group">
																<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
																	<s:text name="update.Lead.lead.date" />
																</div>
																<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
																	<s:textfield type="text" name="leadDate"
																		cssClass="form-control" disabled="true" />
																</div>
															</div>

														</div>
													</div>
													<div class="row" style="background-color:; height: 60px;">
														<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12"></div>
														<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12"
															style="margin-top: 15px; margin-left: 20px;">
														
															<a href="#" class="btn btn-default ">Cancel</a>
															 
															<a href="#" class="btn btn-success ">Clear</a>
															<!-- <a href="#"
																class="btn btn-primary ">Save</a> -->
															<s:submit name="project.form.button.submit" />
														</div>
														<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12"></div>
													</div>
												</s:form>
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
	<script type="text/javascript">
		var frmvalidator = new Validator("updateLeadForm");
		frmvalidator.EnableOnPageErrorDisplay();
		frmvalidator.EnableMsgsTogether();

		//Validation for Company Name. 
		frmvalidator.addValidation("companyName", "req", "Enter Company Name");
		frmvalidator.addValidation("companyName", "maxlen=100",
				"Maximun Length Of Company Name Should Be 100 Characters");

		//Validation for Contact Person.
		frmvalidator.addValidation("contactPerson", "req",
				"Enter Contact Person Name");
		frmvalidator
				.addValidation("contactPerson", "maxlen=50",
						"Maximun Length Of Contact Person Name Should Be 50 Characters");

		//Validation for Lead Title. 
		frmvalidator.addValidation("leadTitle", "dontselect=-1",
				"Select Lead Title");

		//validation for Source Name. 
		frmvalidator.addValidation("leadSource", "dontselect=-1",
				"Select Lead Source");

		//Validation for Number of associates.
		frmvalidator.addValidation("noOfAssociate", "numeric",
				"Number Of Associate Must Be Digits");
		frmvalidator.addValidation("noOfAssociate", "maxlen=6",
				"No. Of Associates Should Be 6 Digits");

		//Validation for Lead Date. 
		frmvalidator.addValidation("leadDate", "req", "Select Lead Date");

		//lead date and expected closing date difference validation 
		function DoCustomValidation() {
			var frm1 = document.forms["updateLeadForm"];

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
</body>
</html>