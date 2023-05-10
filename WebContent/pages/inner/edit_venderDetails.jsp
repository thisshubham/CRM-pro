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
							<li><a href="omiInnerDashboard.action"><i
									class="fa fa-home"></i></a></li>
							<li><a href="vendorsDashboard.action"><s:text
										name="new.vendors.vendors.dashboard" /></a></li>
							<li class="active"><s:text name="edit.vendors.edit.vendors" /></li>
						</ol>
						<s:form name="addCreatedvendorsForm" action="updateVendordetails"
									class="form-horizontal" id="block-validate">
						<div class="box dark">
							<header>
							<div class="pull-left">



								<a class="icons" href="vendorsDashboard.action"
									data-toggle="tooltip"
									data-original-title="Back To Vendors DashBoard"
									style="color: black;"> <i class="fa fa-th-large"></i>
								</a>
								<h5>
									<s:text name="edit.vendors.edit.vendors" />
								</h5>
							</div>
							<div class="pull-right">
								<div class="btn-group">
									<a class="btn btn-default btnheight" data-toggle="tooltip"
										data-original-title="Help"><i class="fa fa-question"></i>
										<s:text name="project.form.button.help"></s:text> </a>
									<button type="submit" Class="btn btn-primary btnheight"
										data-toggle="tooltip" data-original-title="save"
										key="project.form.button.save" theme="simple" tabindex="32">
										<i class="fa fa-check"></i>
										<s:text name="project.form.button.save"></s:text>
									</button>

									<a href="newVendors.action" data-toggle="tooltip"
										data-original-title="Refresh"
										class="btn btn-success btnheight"><i
										class="fa fa-refresh "></i></a> <a href="vendorsDashboard.action"
										data-toggle="tooltip" data-original-title="Close"
										class="btn btn-danger btnheight"><i
										class="fa fa-times fontawesomeht"></i></a>
								</div>

							</div>
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
													<s:text name="edit.vendors.information.bar" />
												</div>
											</div>
										</s:else>
									</p>
									</div>
                                     <div class="row" style="margin-left:20px; margin-right:20px; ">
									<div class="row" style="margin-top: 20px;">
										<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
											<h5 class="innertitle">
												<s:text name="new.vendors.vendors.information" />
											</h5>
											<hr style="margin-top: -5px">
										</div>
									</div>


									<div class="row">
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="new.vendors.vendors.name" />
													<div class="star">*</div>
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<div class="row">
														<div class="col-lg-3 col-md-3 col-sm-3 col-xs-5">
															<s:select class="form-control" name="salutation"
																tabindex="2" list="salutationList"
																cssClass="form-control" />
															<div id='addCreatedvendorsForm_salutation_errorloc'
																class="error_strings"></div>
														</div>
														<div class="col-lg-9 col-md-9 col-sm-9 col-xs-12">
															<s:textfield type="text" name="vendorsName"
																cssClass="form-control" tabindex="1" />
															<div id='addCreatedvendorsForm_vendorsName_errorloc'
																class="error_strings"></diV>
														</div>
													</div>
												</div>
											</div>
										</div>
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="new.vendors.vendors.category" />
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:select name="vendorsCategory" headerKey="-1"
														headerValue="%{getText('new.vendors.please.holder.vendors.category')}"
														tabindex="2" list="vendorsCategoryList"
														cssClass="form-control chzn-select" />
													<div id='addCreatedvendorsForm_vendorsCategory_errorloc'
														class="error_strings"></div>
												</div>
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="new.vendors.vendors.gl.ac" />
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:select name="gLAccounts" tabindex="2" headerKey="-1"
														headerValue="%{getText('new.vendors.please.holder.gl.ac')}"
														list="vendorGLAccountList" cssClass="form-control chzn-select" />
													<div id='addCreatedvendorsForm_gLAccounts_errorloc'
														class="error_strings"></diV>
												</div>
											</div>
										</div>
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="new.vendors.assigned.to" />
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:select class="form-control" name="assignedTo"
														headerKey="-1"
														headerValue="%{getText('new.vendors.please.holder.assigned.to')}"
														tabindex="2" list="vendorsAssignedToList"
														cssClass="form-control chzn-select" />
													<div id='addCreatedvendorsForm_assignedTo_errorloc'
														class="error_strings"></diV>
												</div>
											</div>
										</div>

									</div>

									<div class="row">
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="new.vendors.vendors.status" />
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:select name="vendorsStatus" tabindex="2" list="vendorStatusList"
														cssClass="form-control chzn-select" />
													<div id='addCreatedvendorsForm_vendorsStatus_errorloc'
														class="error_strings"></diV>
												</div>
											</div>
										</div>
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="new.vendors.vendors.flag" />
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:textfield type="text" name="vendorsFlag"
														cssClass="form-control" tabindex="20" />
													<div id='addCreatedvendorsForm_vendorsFlag_errorloc'
														class="error_strings"></diV>
												</div>
											</div>
										</div>

									</div>




									<div class="row" style="margin-top: 20px;">
										<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
											<h5 class="innertitle">
												<s:text name="new.vendors.contact.information" />
											</h5>
											<hr style="margin-top: -5px">
										</div>
									</div>


									<div class="row">

										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="new.vendors.adress.line1" />
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:textfield type="text" name="addressLine1"
														cssClass="form-control" tabindex="20" />
													<div id='addCreatedvendorsForm_addressLine1_errorloc'
														class="error_strings"></div>
												</div>
											</div>
										</div>
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="new.vendors.adress.line2" />
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:textfield type="text" name="addressLine2"
														cssClass="form-control" tabindex="21" />
													<div id='addCreatedvendorsForm_addressLine2_errorloc'
														class="error_strings"></div>
												</div>
											</div>
										</div>
									</div>



									<div class="row">

										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="new.vendors.city" />
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:textfield type="text" name="city"
														cssClass="form-control" tabindex="22" />
													<div id='addCreatedvendorsForm_city_errorloc'
														class="error_strings"></div>
												</div>
											</div>
										</div>
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="new.vendors.state" />
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:textfield type="text" name="state"
														cssClass="form-control" tabindex="23" />
													<div id='addCreatedvendorsForm_state_errorloc'
														class="error_strings"></div>
												</div>
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="new.vendors.country" />

												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:select list="countryList" name="country" id="country"
														headerKey="-1" theme="css_xhtml" cssClass="form-control"
														tabindex="24" />
													<div id='addCreatedvendorsForm_country_errorloc'
														class="error_strings"></div>
												</div>
											</div>
										</div>
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="new.vendors.zipcode" />
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:textfield name="zipCode" cssClass="form-control"
														tabindex="25" />
													<div id='addCreatedvendorsForm_zipCode_errorloc'
														class="error_strings"></div>
												</div>
											</div>
										</div>
									</div>



									<div class="row">
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="new.vendors.phone" />
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<div class="row">
														<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"
															style="padding-right: 0px;">
															<s:textfield cssClass="form-control" name="phoneIsd"
																placeholder="ISD Code" tabindex="26"></s:textfield>
															<div id='addCreatedvendorsForm_phoneIsd_errorloc'
																class="error_strings"></div>
														</div>
														<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"
															style="padding-right: 0; padding-left: 0;">
															<s:textfield cssClass="form-control" name="phoneStd"
																tabindex="27" placeholder="STD Code"></s:textfield>
														</div>
														<div class="col-lg-5 col-md-5 col-sm-5 col-xs-5"
															style="padding-right: 0; padding-left: 0px; width: 46%">

															<s:textfield name="phoneNo" cssClass="form-control"
																placeholder="%{getText('add.client.phone.number')}"
																tabindex="28" />
															<div id='addCreatedvendorsForm_phoneNo_errorloc'
																class="error_strings"></div>
														</div>
													</div>
												</div>
											</div>
										</div>
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="new.vendors.mobile" />
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<div class="row">
														<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"
															style="padding-right: 0px;">
															<s:textfield cssClass="form-control" name="mobileIsd"
																tabindex="29" placeholder="ISD Code"></s:textfield>
															<div id='addCreatedvendorsForm_mobileIsd_errorloc'
																class="error_strings"></div>
														</div>
														<div class="col-lg-9 col-md-9 col-sm-9 col-xs-9"
															style="padding-right: 0; padding-left: 0px; width: 71%">

															<s:textfield name="mobileNo" cssClass="form-control"
																tabindex="30"
																placeholder="%{getText('add.client.phone.number')}" />
															<div id='addCreatedvendorsForm_mobileNo_errorloc'
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
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="new.vendors.primary.email.id" />
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:textfield type="text" name="primaryEmailId"
														cssClass="form-control" tabindex="31" />
													<div id='addCreatedvendorsForm_primaryEmailId_errorloc'
														class="error_strings"></div>
												</div>
											</div>
										</div>

										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="new.vendors.alternate.email.id" />
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:textfield name="alternateEmailId"
														cssClass="form-control" tabindex="32" />
													<div id='addCreatedvendorsForm_alternateEmailId_errorloc'
														class="error_strings"></div>
												</div>
											</div>
										</div>
									</div>


									<div class="row">
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="new.vendors.fax" />
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<div class="row">
														<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"
															style="padding-right: 0px;">
															<s:textfield cssClass="form-control" name="faxIsd"
																tabindex="33" placeholder="ISD Code"></s:textfield>
															<div id='addCreatedvendorsForm_faxIsd_errorloc'
																class="error_strings"></div>
														</div>
														<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"
															style="padding-right: 0; padding-left: 0;">
															<s:textfield cssClass="form-control" name="faxStd"
																tabindex="34" placeholder="STD Code"></s:textfield>
															<div id='addCreatedvendorsForm_faxStd_errorloc'
																class="error_strings"></div>
														</div>
														<div class="col-lg-5 col-md-5 col-sm-5 col-xs-5"
															style="padding-right: 0; padding-left: 0px; width: 46%">

															<s:textfield name="fax" cssClass="form-control"
																tabindex="35"
																placeholder="%{getText('add.client.phone.number')}" />
															<div id='addCreatedvendorsForm_fax_errorloc'
																class="error_strings"></div>
														</div>
													</div>
												</div>
											</div>
										</div>
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="new.vendors.website" />
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:textfield type="text" name="webSite"
														cssClass="form-control" tabindex="36" />
													<div id='addCreatedvendorsForm_webSite_errorloc'
														class="error_strings"></div>
												</div>
											</div>
										</div>
									</div>

									<div class="row" style="margin-top: 20px;">
										<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
											<h5 class="innertitle">
												<s:text name="new.vendors.description.details" />
											</h5>
											<hr style="margin-top: -5px">
										</div>
									</div>
									<div class="form-group">
										<div class="row" style="margin: 1% 2%;" id="data_grid">
											<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
												<div id='addCreatedvendorsForm_description_errorloc'
													class="error_strings"></div>
												<s:textarea id="wysihtml5" name="description"
													class="form-control" rows="10" tabindex="29">
												</s:textarea>
												<div id='addCreatedvendorsForm_description_errorloc'
													class="error_strings"></div>
											</div>
										</div>
									</div>
									</div>
									<hr style="margin-top: 20px">
									
									<div class="row">
										<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"
											align="center">
											<a href="vendorsDashboard.action" data-toggle="tooltip"
												data-original-title="Back To Campaign DashBoard"
												class="btn btn-default btnheight" ontheme="simple"
												tabindex="38"><i
												class="fa fa-caret-square-o-left fontawesomeht"></i> <s:text
													name="project.form.button.cancel" /> </a> <a
												href="newVendors.action" data-toggle="tooltip"
												data-original-title="Reset"
												class="btn btn-success btnheight" tabindex="38"><i
												class="fa fa-refresh "></i> <s:text
													name="project.form.button.reset"></s:text></a>
											<button type="submit" Class="btn btn-primary btnheight"
												data-toggle="tooltip" data-original-title="save"
												key="project.form.button.save" theme="simple" tabindex="40">
												<i class="fa fa-check"></i>
												<s:text name="project.form.button.save"></s:text>
											</button>



										</div>
									</div>
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
		var frmvalidator = new Validator("addCreatedvendorsForm");
		frmvalidator.EnableOnPageErrorDisplay();
		frmvalidator.EnableMsgsTogether();

		//Validation for Vendors Name.
		frmvalidator.addValidation("vendorsName", "req",
				"Please Enter Vendors Name");
		frmvalidator.addValidation("vendorsName", "minlen=3",
				"Vendors Name Should Be 3 Characters");
		frmvalidator.addValidation("vendorsName", "maxlen=100",
				"Vendors Name Should Not Be Greater Than 100 Characters");

		//Validation for Vendors Category.
		frmvalidator.addValidation("vendorsCategory", "dontselect=-1",
				"Please Select Vendors Category");

		/* //Validation for Vendors GLAccount.
		frmvalidator.addValidation("GLAccount", "dontselect=-1",
				"Please Select Vendors GLAccount");
		 */
		//Validation for Assigned To. 
		frmvalidator.addValidation("assignedTo", "dontselect=1",
				"Please Select Assign TO");

		//Validation for Vendors Status.
		frmvalidator.addValidation("vendorsStatus", "dontselect=1",
				"Please Select Vendors Status");
		//Validation for Vendors Flag.
		frmvalidator.addValidation("vendorsFlag", "maxlen=100",
				"Vendors Flag Should Not Be Greater Than 100 Characters");

		//Validation for country.
		frmvalidator.addValidation("country", "dontselect=1",
				"Please Select Country");

		/* //Validation for vendors Date. 
		frmvalidator.addValidation("vendorsDate", "req", "Select vendors Date");

		//Validation for vendors Owner. 
		frmvalidator.addValidation("vendorsOwnerId", "dontselect=-1",
				"Select vendors Owner");

		//validation for Address Line 1.
		frmvalidator.addValidation("addressLine1", "maxlen=100",
				"Address Line 1 Should Be 100 Characters");*/

		/* //validation for Address Line 2.
		frmvalidator.addValidation("addressLine2", "maxlen=100",
				"Address Line 2 Should Be 100 Characters");

		//validation for City.
		frmvalidator.addValidation("city", "maxlen=100",
				"City Should Be 50 Characters");

		//validation for State.
		frmvalidator.addValidation("state", "maxlen=100",
				"State Should Be 100 Characters"); */

		//validation for Mobile Number.
		frmvalidator.addValidation("mobileNo", "maxlen=10",
				"Mobile Number Should Be 10 Digits");
		frmvalidator.addValidation("mobileNo", "minlen=10",
				"Mobile Number Should Be 10 Digits");
		frmvalidator.addValidation("mobileNo", "numeric",
				"Mobile Number Must Be Digits");

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
		
		//validation for Description.
		frmvalidator.addValidation("description", "maxlen=4000",
				"Description Should Be 4000 Charecter");


		/* //validation for Phone Number.
		frmvalidator.addValidation("phoneNo", "maxlen=10",
				"Phone Number Should Be 10 Digits");
		frmvalidator.addValidation("phoneNo", "numeric",
				"Phone Number Must Be Digits");

		//validation for Fax number.
		frmvalidator.addValidation("fax", "numeric",
				"Fax Number Must Be Digits");
		frmvalidator.addValidation("fax", "maxlen=10",
				"Fax Number Should Be 10 Digits");
 */
		
		//vendors date and expected closing date difference validation 
		function DoCustomValidation() {
			var frm1 = document.forms["addCreatedvendorsForm"];
			var ndate = frm1.vendorsDate.value;
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
						"Expected Closing Date Should be Greater Than vendors Date",
						frm1.expectedClosingDate);
				return false;
			}
		}

		frmvalidator.setAddnlValidationFunction(DoCustomValidation);
	</script>
</body>
</html>