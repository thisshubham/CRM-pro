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
							<li><a href="assignmentsDashboard.action"><s:text
										name="add.new.assignment.assignments.dashboard"></s:text></a></li>

							<li class="active"><s:text
									name="add.new.assignment.new.assignment"></s:text></li>
						</ol>
						<s:form name="addNewAssignmentForm" action="newAssignment"
							class="form-horizontal" id="block-validate">
							<div class="box dark">
								<header>
								<div class="pull-left">
									<a class="icons" href="assignmentsDashboard.action"
										data-toggle="tooltip"
										data-original-title="Back To Assignments DashBoard"
										style="color: black;"> <i class="fa fa-th-large"></i>
									</a>
									<h5>
										<s:text name="add.new.assignment.new.assignment" />
									</h5>
								</div>
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
													<s:text name="add.new.assignment.infobar" />
												</div>
											</div>
										</s:else>
									</p>



									<div class="row" style="margin-top: 20px;">
										<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
											<h5 class="innertitle">
												<s:text name="add.new.assignment.assignment.details" />
											</h5>
											<hr style="margin-top: -5px">
										</div>
									</div>


									<div class="row">
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="add.new.assignment.assignment.title" />
													<div class="star">*</div>
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:textfield type="text" name="assignmentName"
														cssClass="form-control" tabindex="1" />
													<div id='addNewAssignmentForm_assignmentName_errorloc'
														class="error_strings"></diV>
												</div>
											</div>
										</div>




										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="add.new.assignment.assignment.owner" />
													<div class="star">*</div>
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<!-- <div class="row">
														<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12"> -->
													<s:select cssClass="form-control chzn-select"
														name="assignmentOwner" list="customerUserList"
														tabindex="7" headerKey="-1"
														headerValue="Select Assignment Owner" />
													<div id='addNewAssignmentForm_assignmentOwner_errorloc'
														class="error_strings"></div>
												</div>

											</div>
										</div>
									</div>


									<div class="row">
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">

													<s:text name="add.new.assignment.expected.amount" />
													&nbsp; (&nbsp;<span class="fa fa-rupee "></span>&nbsp;)
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<div class="input-group">
														<s:textfield type="text" name="expectedAmount"
															cssClass="form-control" tabindex="12" />


														<span class="input-group-btn"> <a type="button"
															class="btn btn-metis-5 btn-line" type="button"
															tabindex="13" data-toggle="modal" style="height: 34px"
															data-target="#calculater"> <i
																class="fa fa-calculator "></i>
														</a>
														</span>

													</div>
													<div id='addNewAssignmentForm_expectedAmount_errorloc'
														class="error_strings"></div>
												</div>
											</div>
										</div>

										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="add.new.assignment.account" />
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:select list="accountNameList" name="account" id=""
														cssClass="form-control chzn-select" tabindex="6"
														headerKey="-1" headerValue="Account" />
													<div id='addNewAssignmentForm_account_errorloc'
														class="error_strings"></div>

												</div>

											</div>

										</div>
									</div>
									<div class="row">
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="add.new.assignment.contact.person" />
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:select cssClass="form-control chzn-select"
														name="contactPerson" list="contactList" tabindex="7"
														headerKey="-1" headerValue="Contact Person" />
													<div id='addNewAssignmentForm_contactPerson_errorloc'
														class="error_strings"></div>

												</div>
											</div>
										</div>
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="add.new.assignment.expected.closing" />
													<div class="star">*</div>
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:textfield type="text" name="expectedClosingDate"
														cssClass="form-control" id="dp4" tabindex="15" />
													<div id='addNewAssignmentForm_expectedClosing_errorloc'
														class="error_strings"></div>
												</div>
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="add.new.assignment.lead.source" />

												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:select name="leadSource" id=""
														cssClass="form-control chzn-select"
														list="leadSourceNameList" headerKey="-1"
														headerValue="Lead Source" tabindex="9" />
													<div id='addNewAssignmentForm_leadSource_errorloc'
														class="error_strings"></div>

												</div>
											</div>
										</div>
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="add.new.assignment.assigned.to" />
													<div class="star">*</div>
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">

													<s:select cssClass="form-control chzn-select"
														name="assignedTo" list="customerUserList" tabindex="7"
														headerKey="-1" headerValue="Assigned To" />
													<div id='addNewAssignmentForm_assignedTo_errorloc'
														class="error_strings"></div>
												</div>
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="add.new.assignment.lead" />
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">

													<s:select cssClass="form-control chzn-select" name="lead"
														list="leadList" tabindex="7" headerKey="-1"
														headerValue="Lead" />
													<div id='addCreatedLeadForm_lead_errorloc'
														class="error_strings"></div>
												</div>
											</div>
										</div>
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="add.new.assignment.probability" />
													&nbsp<b>(%)</b>

												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:textfield type="text" name="probability"
														cssClass="form-control" tabindex="1" />
													<div id='addNewAssignmentForm_probability_errorloc'
														class="error_strings"></diV>
												</div>
											</div>
										</div>
									</div>



									<div class="row">
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="add.new.assignment.campaign" />
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">

													<s:select cssClass="form-control chzn-select"
														name="campaign" list="campaignList" tabindex="7"
														headerKey="-1" headerValue="Campaign" />
													<div id='addNewAssignmentForm_campaign_errorloc'
														class="error_strings"></diV>
												</div>
											</div>
										</div>
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="add.new.assignment.weighted.revenue" />
													&nbsp; (&nbsp;<span class="fa fa-rupee "></span>&nbsp;)
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<div class="input-group">
														<s:textfield type="text" name="weightedRevenue"
															cssClass="form-control" tabindex="12" />

														<span class="input-group-btn"> <a type="button"
															class="btn btn-metis-5 btn-line" type="button"
															tabindex="13" data-toggle="modal" style="height: 34px"
															data-target="#calculater"> <i
																class="fa fa-calculator "></i>
														</a>
														</span>
													</div>
													<div id='addNewAssignmentForm_weightedRevenue_errorloc'
														class="error_strings"></diV>
												</div>
											</div>
										</div>
									</div>


									<div class="row">
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="add.new.assignment.primary.email" />
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:textfield type="text" name="primaryEmailId"
														cssClass="form-control" tabindex="1" />
													<div id='addNewAssignmentForm_priEmailId_errorloc'
														class="error_strings"></diV>

												</div>
											</div>
										</div>


										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="add.new.assignment.contact.number" />
													<div class="star">*</div>
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<div class="row">
														<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"
															style="padding-right: 0px;">
															<s:textfield cssClass="form-control" name="phoneIsd"
																placeholder="%{getText('project.placeholder.isd')}"
																tabindex="26"></s:textfield>
															<div id='addNewAssignmentForm_phoneIsd_errorloc'
																class="error_strings"></div>

														</div>
														<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"
															style="padding-right: 0; padding-left: 0;">
															<s:textfield cssClass="form-control" name="phoneStd"
																tabindex="27"
																placeholder="%{getText('project.placeholder.std')}"></s:textfield>
																<div id='addNewAssignmentForm_phoneStd_errorloc'
																class="error_strings"></div>


														</div>
														<div class="col-lg-5 col-md-5 col-sm-5 col-xs-5"
															style="padding-right: 0; padding-left: 0px; width: 46%">

															<s:textfield name="phoneNumber" cssClass="form-control"
																placeholder="%{getText('project.placeholder.phonenumber')}"
																tabindex="28" />

															
															
															<div id='addNewAssignmentForm_phoneNumber_errorloc'
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
													<s:text name="Status" />
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">

													<s:select cssClass="form-control chzn-select"
														name="assignmentStatus" list="assignmentStatusList" tabindex="7"
														headerKey="1"/>
													<div id='addNewAssignmentForm_campaign_errorloc'
														class="error_strings"></diV>
												</div>
											</div>
										</div>







									<div class="row" style="margin-top: 20px;">
										<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
											<h5 class="innertitle">
												<s:text name="add.new.assignment.description" />
											</h5>
											<hr style="margin-top: -5px">
										</div>
									</div>

									<div class="form-group">
										<div class="row" style="margin: 1% 2%;" id="data_grid">
											<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
												<div id='addCreatedLeadForm_requirment_errorloc'
													class="error_strings"></div>
												<s:textarea id="wysihtml5" name="description"
													class="form-control" rows="10" tabindex="37">
												</s:textarea>
												<div id='addNewAssignmentForm_description_errorloc'
													class="error_strings"></div>
											</div>
										</div>
									</div>

									<hr style="margin-top: 20px">
									<div class="row">
										<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"
											align="center">
											<a href="leadDashboard.action" data-toggle="tooltip"
												data-original-title="Cancel"
												class="btn btn-default btnheight"><i
												class="fa fa-caret-square-o-left fontawesomeht"></i> <s:text
													name="project.form.button.cancel"></s:text></a> <a
												href="addCreatedLead.action" data-toggle="tooltip"
												data-original-title="Reset"
												class="btn btn-success btnheight"><i
												class="fa fa-refresh "></i> <s:text
													name="project.form.button.reset"></s:text></a>
											<button type="submit" data-toggle="tooltip"
												data-original-title="Save" class="btn btn-primary btnheight">
												<i class="fa fa-check"></i>
												<s:text name="project.form.button.save"></s:text>
											</button>

										</div>
									</div>
								</div>
							</div>
						</s:form>
					</div>
				</div>

			</div>
		</div>
	</div>

	<div class="modal fade" id="calculater" role="dialog">
		<div class="modal-dialog modal-sm">
			<div class="modal-content">
				<div class="modal-header"
					style="color: gray; background-color: #394B5E;">
					<button type="button" class="close" data-dismiss="modal"
						style="color: red; margin-top: -30px;">
						<h1>&times;</h1>
					</button>
					<h4 class="modal-title" style="color: gray;">Calculater</h4>
				</div>
				<div class="modal-body" style="color: gray;">
					<div class="row ">
						<div class="col-lg-12 col-md-10 col-xs-12 col-sm-10">

							<div class="col-lg-12 col-md-12 col-xs-12 col-sm-12"
								style="margin-bottom: 10px;">
								<!-- <input type="text" id="calculatortextid"
									style="height: 40px; width: 210px"
									autocomplete="off" /> -->
								<s:textfield id="calculatortextid" cssClass="form-control" />
							</div>

							<div class="col-lg-12 col-md-12 col-xs-12 col-sm-12">
								<button type="button" class="btn btn-defult"
									style="width: 50px; height: 50px; margin-left: 14px" id="idc"
									onclick="valueIdc()">
									<b>c</b>
								</button>
								<button type="button" class="btn btn-defult"
									style="width: 50px; height: 47px; padding-bottom: 0px;"
									id="idx2" onclick="valueIdxsquare()">
									<b><i>x<sup>2</sup></i></b>
								</button>
								<button type="button" class="btn btn-defult"
									style="width: 50px; height: 50px;" id="idroot"
									onclick="valueIdroot()">
									<b>√</b>
								</button>
								<button type="button" class="btn btn-defult"
									style="width: 50px; height: 50px;" id="idmod"
									onclick="valueIdmod()">
									<b>%</b>
								</button>
							</div>

							<br>
							<div class="col-lg-12 col-md-12 col-xs-12 col-sm-12">
								<button type="button" class="btn btn-defult"
									style="width: 50px; height: 50px; margin-left: 14px" id="id7"
									onclick="valueId7()">
									<b>7</b>
								</button>
								<button type="button" class="btn btn-defult"
									style="width: 50px; height: 50px;" id="id8"
									onclick="valueId8()">
									<b>8</b>
								</button>
								<button type="button" class="btn btn-defult"
									style="width: 50px; height: 50px;" id="id9"
									onclick="valueId9()">
									<b>9</b>
								</button>
								<button type="button" class="btn btn-defult"
									style="width: 50px; height: 50px;" id="iddiv"
									onclick="valueIddivision()">
									<b>/</b>
								</button>
							</div>

							<br>
							<div class="col-lg-12 col-md-12 col-xs-12 col-sm-12">
								<button type="button" class="btn btn-defult"
									style="width: 50px; height: 50px; margin-left: 14px" id="id4"
									onclick="valueId4()">
									<b>4</b>
								</button>
								<button type="button" class="btn btn-defult"
									style="width: 50px; height: 50px;" id="id5"
									onclick="valueId5()">
									<b>5</b>
								</button>
								<button type="button" class="btn btn-defult"
									style="width: 50px; height: 50px;" id="id6"
									onclick="valueId6()">
									<b>6</b>
								</button>
								<button type="button" class="btn btn-defult"
									style="width: 50px; height: 50px;" id="idx"
									onclick="valueIdmultiply()">
									<b>x</b>
								</button>
							</div>

							<div class="col-lg-12 col-md-12 col-xs-12 col-sm-12">
								<button type="button" class="btn btn-defult"
									style="width: 50px; height: 50px; margin-left: 14px" id="id1"
									onclick="valueId1()">
									<b>1</b>
								</button>
								<button type="button" class="btn btn-defult"
									style="width: 50px; height: 50px;" id="id2"
									onclick="valueId2()">
									<b>2</b>
								</button>
								<button type="button" class="btn btn-defult"
									style="width: 50px; height: 50px;" id="id3"
									onclick="valueId3()">
									<b>3</b>
								</button>
								<button type="button" class="btn btn-defult"
									style="width: 50px; height: 50px;" id="idminus"
									onclick="valueIdminus()">
									<b>-</b>
								</button>
							</div>
							<br> <br>
							<div class="col-lg-12 col-md-12 col-xs-12 col-sm-12">
								<button type="button" class="btn btn-defult"
									style="width: 50px; height: 50px; margin-left: 14px" id="id0"
									onclick="valueId0()">
									<b>0</b>
								</button>
								<button type="button" class="btn btn-defult"
									style="width: 50px; height: 50px;" id="iddot"
									onclick="valueIddot()">
									<b>.</b>
								</button>
								<button type="button" class="btn btn-defult"
									style="width: 50px; height: 50px;" id="idequal"
									onclick="valueIdequal()">
									<b>=</b>
								</button>
								<button type="button" class="btn btn-defult"
									style="width: 50px; height: 50px;" id="idplus"
									onclick="valueIdplus()">
									<b>+</b>
								</button>
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
	<script src="/outer/js/gen_validatorv4.js" type="text/javascript"></script>
	<script type="text/javascript">
		var frmvalidator = new Validator("addNewAssignmentForm");
		frmvalidator.EnableOnPageErrorDisplay();
		frmvalidator.EnableMsgsTogether();

		//Validation for Assignment Name.
		frmvalidator.addValidation("assignmentName", "req",
				"Enter Assignment Name");
		frmvalidator.addValidation("assignmentName", "alnum_s",
				"Alphabets or Numbers Only")

		frmvalidator.addValidation("assignmentName", "maxlen=200",
				"Assignment Name Should Be 200 Characters");

		//Validation for Assignment Owner.
		frmvalidator.addValidation("assignmentOwner", "dontselect=-1",
				"Enter Assignment Owner");

		//Validation for Expected Closing. 
		frmvalidator.addValidation("expectedClosingDate", "req",
				"Enter Expected Closing Date");

		//Validation for Assigned To.
		frmvalidator.addValidation("assignedTo", "dontselect=-1",
				"Select Assigned To");

		//validation for ISD.
		frmvalidator.addValidation("phoneIsd", "numeric",
				"STD No should be digits");
		frmvalidator.addValidation("phoneIsd", "req", "Enter ISD No.");
		frmvalidator.addValidation("phoneIsd", "minlen=2",
				"Min 2 digits");
		frmvalidator.addValidation("phoneIsd", "maxlen=6",
				"Max 6 digits");

		//validation for STD.
		frmvalidator.addValidation("phoneStd", "numeric",
				"STD No should be digits");
		frmvalidator.addValidation("phoneStd", "req", "Enter STD No.");
		frmvalidator.addValidation("phoneStd", "minlen=2",
				"Min 2 digits");
		frmvalidator.addValidation("phoneStd", "maxlen=7",
				"Max 7 digits");

		//validation for Phone No.
		frmvalidator.addValidation("phoneNumber", "numeric",
				"Phone No should be digits");
		frmvalidator.addValidation("phoneNumber", "req", "Enter Phone No ");
		frmvalidator.addValidation("phoneNumber", "minlen=10",
				"Min 10 digits");
		frmvalidator.addValidation("phoneNumber", "maxlen=10",
		"Max 10 digits");
		
		

		//validation for primary email.
		frmvalidator.addValidation("primaryEmailId", "email",
				"Email should contain '@' and '.com'");

		//validation for description. 
		frmvalidator.addValidation("description", "maxlen=4000",
				"Maximum 4000 Characters allowed");

		//validation for Expected Amount. 
		frmvalidator.addValidation("expectedAmount", "req",
				"Enter Expected Amount");

		//validation for  Account. 
		frmvalidator
				.addValidation("account", "dontselect=-1", "Select Account");

		//validation for  Contact Person. 
		frmvalidator.addValidation("contactPerson", "dontselect=-1",
				"Select Contact Person");

		//validation for  Lead Source. 
		frmvalidator.addValidation("leadSource", "dontselect=-1",
				"Select Lead Source");

		//validation for  Lead . 
		frmvalidator.addValidation("lead", "dontselect=-1", "Select Lead");

		//validation for  Probability . 
		frmvalidator.addValidation("probability", "req", "Enter Probability");

		//validation for  Campaign . 
		frmvalidator.addValidation("campaign", "dontselect=-1",
				"Select Campaign");

		//validation for  Weighted Revenue . 
		frmvalidator.addValidation("weightedRevenue", "req",
				"Enter Weighted Revenue");

		//lead date and expected closing date difference validation 
		/* function DoCustomValidation() {
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

		frmvalidator.setAddnlValidationFunction(DoCustomValidation); */
	</script>
</body>
</html>