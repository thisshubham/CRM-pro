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
							<li><a href="eventDashboard.action"><s:text
										name="add.created.event.event.dashboard"></s:text></a></li>
							<li class="active"><s:text
									name="edit.event.details.nav.bar"></s:text></li>
						</ol>
						<s:form name="editEventForm" action="updateEventDetail"
							id="block-validate">
							<s:iterator value="eventVO">
							<div class="box dark">
								<header>
								<div class="pull-left">
									<a class="icons" href="eventDashboard.action"
										data-toggle="tooltip"
										data-original-title="Back To Event DashBoard"
										style="color: black;"> <i class="fa fa-th-large"></i>
									</a>
									<h5>
										<s:text name="edit.event.details.edit.event" />
										
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
										<a href="editEventDetail.action" data-toggle="tooltip"
											data-original-title="Refresh"
											class="btn btn-success btnheight"><i
											class="fa fa-refresh "></i></a> <a href="eventDashboard.action"
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
													<s:text name="edit.event.details.information.bar" />
												</div>
											</div>
										</s:else>
									</p>



									<div class="row" style="margin-top: 20px;">
										<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
											<h5 class="innertitle">
												<s:text name="add.created.event.information" />
											</h5>
											<hr style="margin-top: -5px">
										</div>
									</div>


									<div class="row">
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="add.created.event.title" />
													<div class="star">*</div>
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:textfield type="text" name="eventTitle"
														cssClass="form-control" tabindex="1" />
													<div id='editEventForm_eventTitle_errorloc'
														class="error_strings"></diV>
												</div>
											</div>
										</div>



										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="add.created.event.date.time" />
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:textfield type="text" name="eventDate"
														class="form-control" id="dp3" cssClass="form-control"
														tabindex="14" readonly="true" />
													<div id='editEventForm_eventDate_errorloc'
														class="error_strings"></div>
												</div>
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="add.created.event.category" />
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:select cssClass="form-control chzn-select"
														name="eventCategory" list="eventCategoryMapList" headerKey="-1"
														headerValue="Event Category" tabindex="7" />
													<div id='editEventForm_eventCategory_errorloc'
														class="error_strings"></div>
												</div>
											</div>
										</div>

										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="add.created.event.organize.name" />
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:select cssClass="form-control chzn-select"
														name="organizeName" list="{'a','b'}" headerKey="-1"
														headerValue="Organize Name" tabindex="6" />
													<div id='editEventForm_organizeName_errorloc'
														class="error_strings"></div>
												</div>

											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="add.created.event.mobile.isd" />
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<div class="row">
														<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"
															style="padding-right: 0px;">
															<s:textfield cssClass="form-control" name="mobileIsd"
																tabindex="29"
																placeholder="%{getText('project.placeholder.isd')}"></s:textfield>
															<div id='editEventForm_mobileNo_errorloc'
																class="error_strings"></div>
															<div id='addCreatedLeadForm_mobileIsd_errorloc'
																class="error_strings"></div>
														</div>
														<div class="col-lg-9 col-md-9 col-sm-9 col-xs-9"
															style="padding-right: 0; padding-left: 0px; width: 71%">

															<s:textfield name="mobileNo" cssClass="form-control"
																tabindex="30"
																placeholder="%{getText('project.placeholder.mobilenumber')}" />

														</div>
													</div>
												</div>
											</div>
										</div>
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="add.created.event.mobile" />
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:textfield type="text" name="mobileNumber"
														cssClass="form-control" tabindex="11" />
													<div id='editEventForm_mobileNumber_errorloc'
														class="error_strings"></div>
												</div>
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="add.created.event.email" />

												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:textfield type="text" name="email"
														cssClass="form-control" tabindex="11" />
													<div id='editEventForm_email_errorloc'
														class="error_strings"></div>
												</div>

											</div>
										</div>
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="add.created.event.url" />
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:textfield type="text" name="urlNo"
														cssClass="form-control" tabindex="11" />
													<div id='editEventForm_urlNo_errorloc'
														class="error_strings"></div>
												</div>
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="add.created.event.status" />
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:select cssClass="form-control chzn-select" name="eventStatus"
														list="{'1','2'}" headerKey="-1" headerValue="Status"
														tabindex="6" />
													<div id='editEventForm_eventStatus_errorloc'
														class="error_strings"></div>
												</div>
											</div>
										</div>
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="add.created.event.publish.date" />

												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:textfield type="text" name="publishDate"
														class="form-control" id="dp2" cssClass="form-control"
														tabindex="14" readonly="true" />
													<div id='editEventForm_publishDate_errorloc'
														class="error_strings"></div>
												</div>

											</div>
										</div>
									</div>



									<div class="row">
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="add.created.event.venue" />
												</div>
												<div class="col-xs-12 col-md-8 col-sm-8">
													<div id='SupportFaqsForm_eventVanue_errorloc'
														class="error_strings" style="color: red;"></div>
													<s:textarea name="eventVanue" id="question"
														cssClass="form-control"></s:textarea>
												</div>
											</div>
										</div>
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="add.created.event.file" />
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													
													<div id='editEventForm_eventFile_errorloc'
														class="error_strings"></div>
												</div>
											</div>
										</div>
									</div>




									<div class="row" style="margin-top: 20px;">
										<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
											<h5 class="innertitle">
												<s:text name="add.created.event.requirment" />
											</h5>
											<hr style="margin-top: -5px">
										</div>
									</div>

									<div class="form-group">
										<div class="row" style="margin: 1% 2%;" id="data_grid">
											<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
												<div id='editEventForm_requirment_errorloc'
													class="error_strings"></div>
												<s:textarea id="wysihtml5" name="descripation"
													class="form-control" rows="10" tabindex="34">
												</s:textarea>
												<div id='editEventForm_requirment_errorloc'
													class="error_strings"></div>
											</div>
										</div>
									</div>


									<hr style="margin-top: 20px">
									<div class="row">
										<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"
											align="center">
											<a href="eventDashboard.action" data-toggle="tooltip"
												data-original-title="Cancel"
												class="btn btn-default btnheight"><i
												class="fa fa-caret-square-o-left fontawesomeht"></i> <s:text
													name="project.form.button.cancel"></s:text></a> <a
												href="editEventDetail.action" data-toggle="tooltip"
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
							</s:iterator>
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
		var frmvalidator = new Validator("editEventForm");
		frmvalidator.EnableOnPageErrorDisplay();
		frmvalidator.EnableMsgsTogether();
		//Validation for Product Name.
		/* frmvalidator.addValidation("productName", "req", "Enter Product Name");
		frmvalidator.addValidation("productName", "maxlen=100",
				"Contact Product Name Should Be 100 Characters");
		frmvalidator.addValidation("productName", "minlen=1",
				"Contact Product Name Should Be 1 Characters");
		
		 */

		//Product date and expected closing date difference validation 
		/* function DoCustomValidation() {
			var frm1 = document.forms["editEventForm"];
			//var date11 = new Date();
			var ndate = frm1.salesStartDate.value;
			var ndate1 = frm1.salesEndDate.value;

			//var ndate=changeDateFormate(startDate1);
			//var ndate1=changeDateFormate(endDate1);

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
			/*document.getElementById("demo").innerHTML = Years + 
			 "Year(s), " + Months + " Month(s), " + Days + "Day(s)";*/
		/* if (d1 <= d2) {
			return true;
		}else if (ndate=="") {
			sfm_show_error_msg(
					"Select Sales Start Date",
					frm1.startDate);
			return false;
		}else if (ndate1=="") {
			sfm_show_error_msg(
					"Select Sales End Date",
					frm1.endDate);
			return false;
		}  else {
			sfm_show_error_msg(
					"End Date Should be Greater Than Start Date",
					frm1.endDate);
			return false;
		}
		}

		frmvalidator.setAddnlValidationFunction(DoCustomValidation); */
	</script>
</body>
</html>