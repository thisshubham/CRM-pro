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
<body>

	<div id="content">
		<div class="outer">
			<div class="inner bg-light lter">

				<!--BEGIN INPUT TEXT FIELDS-->
				<div class="row">
					<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
						<ol class="breadcrumb" style="margin-top: 10px;">
							<li><a href="#">Home</a></li>
							<li><a href="#">Expenses</a></li>
							<li class="active">Tours Expenses</li>
						</ol>
						<div class="box dark">
							<header>
							<div class="pull-left">



								<a class="icons" href="leadDashboard.action"
									data-toggle="tooltip"
									data-original-title="Back To Lead DashBoard"
									style="color: black;"> <i class="fa fa-th-large"></i>
								</a>
								<h5 class="header_color">
									<s:text name="Tours Expenses" />
								</h5>
							</div>
							<div class="pull-right">


								<a href="leadDashboard.action" data-toggle="tooltip"
									data-original-title="Close" data-placement="bottom"
									class="btn btn-danger btnheight "> <i class="fa fa-times"></i></a>

							</div>

							</header>

							<div class="container-fluid">


								<s:form name="addCreatedLeadForm" action="addLeadDetail"
									class="form-horizontal" id="block-validate">
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
												</div>&nbsp;&nbsp;&nbsp;<s:text name="" />
											</s:else>
										</p>
									</div>


									<div class="row">
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="add.create.lead.lead.date" />
													<div class="star">*</div>
												</div>

												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">

													<s:textfield type="text" name="leadDate"
														class="form-control" id="dp3" cssClass="form-control"
														tabindex="14" />
													<div id='addCreatedLeadForm_leadDate_errorloc'
														class="error_strings"></div>
												</div>
											</div>
										</div>
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="add.create.lead.expected.closing.date" />
													<div class="star">*</div>
												</div>

												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">



													<s:textfield type="text" name="expectedClosingDate"
														cssClass="form-control" id="dp4" tabindex="15" />
													<div id='addCreatedLeadForm_expectedClosingDate_errorloc'
														class="error_strings"></div>
												</div>
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="add.create.lead.lead.date" />
													<div class="star">*</div>
												</div>

												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">

													<s:textfield type="text" name="leadDate"
														class="form-control" id="dp3" cssClass="form-control"
														tabindex="14" />
													<div id='addCreatedLeadForm_leadDate_errorloc'
														class="error_strings"></div>
												</div>
											</div>
										</div>
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="add.create.lead.expected.closing.date" />
													<div class="star">*</div>
												</div>

												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">



													<s:textfield type="text" name="expectedClosingDate"
														cssClass="form-control" id="dp4" tabindex="15" />
													<div id='addCreatedLeadForm_expectedClosingDate_errorloc'
														class="error_strings"></div>
												</div>
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="add.create.lead.lead.date" />
													<div class="star">*</div>
												</div>

												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">

													<s:textfield type="text" name="leadDate"
														class="form-control" id="dp3" cssClass="form-control"
														tabindex="14" />
													<div id='addCreatedLeadForm_leadDate_errorloc'
														class="error_strings"></div>
												</div>
											</div>
										</div>
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12"></div>
									</div>
									<s:text name="Details for Conveyance
" />

<hr>

<table id="dataTable"
										class="table table-bordered table-condensed table-hover table-striped">

										<thead>
											<tr id="myrow">
												<th><s:text name="S No."></s:text></th>
												<th><s:text name="Date"></s:text></th>
												<th><s:text name="Mode"></s:text></th>
												<th><s:text name="From"></s:text></th>
												<th><s:text name="To"></s:text></th>
												<th><s:text name="Amount"></s:text></th>
												
											</tr>
										</thead>
										<tbody>
											
												<tr>
												<td>1</td>
												<td>sfv</td>
												<td>fv</td>
												<td>fvf</td>
												<td>vf</td>
												<td>vfv</td>
												</tr>								
											
										</tbody>
									</table>



								</s:form>

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
	<script src="/outer/js/gen_validatorv4.js" type="text/javascript"></script>
	<script type="text/javascript">
		var frmvalidator = new Validator("addCreatedLeadForm");
		frmvalidator.EnableOnPageErrorDisplay();
		frmvalidator.EnableMsgsTogether();

		//Validation for Company Name. 
		frmvalidator.addValidation("companyName", "maxlen=50",
				"Company Name Should Be 50 Characters");

		//Validation for Contact Person.
		frmvalidator.addValidation("contactPerson", "req",
				"Enter Contact Person Name");
		frmvalidator.addValidation("contactPerson", "maxlen=50",
				"Contact Person Name Should Be 50 Characters");

		frmvalidator.addValidation("salutation", "dontselect=8",
				"Select Salutation");
		//Validation for Lead Title. 
		frmvalidator.addValidation("leadTitle", "dontselect=-1",
				"Select Lead Title");

		//validation for Company Type. 
		frmvalidator.addValidation("companyType", "dontselect=-1",
				"Select Company Type");

		//validation for Company Category. 
		frmvalidator.addValidation("companyCategory", "dontselect=-1",
				"Select Company Category");

		//validation for Company Sector. 
		frmvalidator.addValidation("companySector", "dontselect=-1",
				"Select Company Sector");

		//validation for Source Name. 
		frmvalidator.addValidation("leadSource", "dontselect=-1",
				"Select Lead Source");

		//Validation for Lead Source Name. 
		frmvalidator.addValidation("leadSourceName", "maxlen=50",
				"Lead Source Name Should Be 50 Characters");

		//Validation for Number of associates.
		frmvalidator.addValidation("noOfAssociate", "numeric",
				"Number Of Associate Must Be Digits");
		frmvalidator.addValidation("noOfAssociate", "maxlen=6",
				"No. Of Associates Should Be 6 Digits");

		//Validation for Lead Date. 
		frmvalidator.addValidation("leadDate", "req", "Select Lead Date");

		//Validation for Lead Owner. 
		frmvalidator.addValidation("leadOwnerId", "dontselect=-1",
				"Select Lead Owner");

		//validation for Address Line 1.
		frmvalidator.addValidation("addressLine1", "maxlen=100",
				"Address Line 1 Should Be 100 Characters");

		//validation for Address Line 2.
		frmvalidator.addValidation("addressLine2", "maxlen=100",
				"Address Line 2 Should Be 100 Characters");

		//validation for City.
		frmvalidator.addValidation("city", "maxlen=50",
				"City Should Be 50 Characters");

		//validation for State.
		frmvalidator.addValidation("state", "maxlen=100",
				"State Should Be 100 Characters");

		//validation for Country.
		frmvalidator.addValidation("country", "dontselect=-1",
				"Select Country Name");

		//validation for Primary Email Id. 

		frmvalidator.addValidation("primaryEmailId", "email",
				"Enter Valid Email Address");
		frmvalidator.addValidation("primaryEmailId", "maxlen=100",
				"Email Id Should Be 100 Characters");

		//validation for Alternate Email Id.
		frmvalidator.addValidation("alternateEmailId", "email",
				"Enter Valid Email Address");
		frmvalidator.addValidation("alternateEmailId", "maxlen=100",
				"Email Id Should Be 100 Characters");

		//validation for Phone Number.
		frmvalidator.addValidation("phoneNo", "maxlen=8",
				"Phone Number Should Be 8 Digits");
		frmvalidator.addValidation("phoneNo", "numeric",
				"Phone Number Must Be Digits");

		//validation for Mobile Number.
		frmvalidator.addValidation("mobileNo", "maxlen=10",
				"Mobile Number Should Be 10 Digits");
		frmvalidator.addValidation("mobileNo", "numeric",
				"Mobile Number Must Be Digits");

		//validation for Fax number.
		frmvalidator.addValidation("fax", "req", "Fax Number requeri");
		frmvalidator.addValidation("fax", "numeric",
				"Fax Number Must Be Digits");
		frmvalidator.addValidation("fax", "maxlen=8",
				"Fax Number Should Be 8 Digits");

		//validation for Mobile Number.
		frmvalidator.addValidation("requirment", "maxlen=4000",
				"Requirement Should Be 4000 Charecter");

		//lead date and expected closing date difference validation 
		function DoCustomValidation() {
			var frm1 = document.forms["addCreatedLeadForm"];
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