<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
.inline {
	display: inline;
}

#dailyDiv {
	display: none;
}

#weeklyDiv {
	display: none;
}

#monthlyDiv {
	display: none;
}

#yearlyDiv {
	display: none;
}

#weekly {
	display: none;
}
</style>

<script type="text/javascript">
	function showDiv() {

		var selectId = document.getElementById('selectOption');

		var optionId1 = document.getElementById('dailyDiv');
		var optionId2 = document.getElementById('weeklyDiv');
		var optionId3 = document.getElementById('monthlyDiv');
		var optionId4 = document.getElementById('yearlyDiv');

		if (selectId.value == 1) {
			optionId3.style.display = 'none';
			optionId2.style.display = 'none';
			optionId1.style.display = 'none';
			optionId4.style.display = 'none';
		} else if (selectId.value == 2) {
			optionId4.style.display = 'none';
			optionId3.style.display = 'none';
			optionId2.style.display = 'none';
			optionId1.style.display = 'block';
		} else if (selectId.value == 3) {
			optionId4.style.display = 'none';
			optionId3.style.display = 'none';
			optionId1.style.display = 'none';
			optionId2.style.display = 'block';
		} else if (selectId.value == 4) {
			optionId4.style.display = 'none';
			optionId2.style.display = 'none';
			optionId1.style.display = 'none';
			optionId3.style.display = 'block';
		} else if (selectId.value == 5) {
			optionId3.style.display = 'none';
			optionId2.style.display = 'none';
			optionId1.style.display = 'none';
			optionId4.style.display = 'block';
		}
	}

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
</head>
</head>
<body onload="showDiv()">

	<div id="content">
		<div class="outer">
			<div class="inner bg-light lter">

				<!--BEGIN INPUT TEXT FIELDS-->
				<div class="row">
					<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
						<div class="box inverse">
							<header> <a class="icons" href="taskDashboard.action"
								data-toggle="tooltip"
								data-original-title="Back To Task DashBoard""> <i
								class="fa fa-th-large"></i>
							</a>
							<h5>
								<s:text name="update.task"></s:text>
							</h5>
							<div id="div1"></div>

							<!-- .toolbar -->
							<div class="toolbar">
								<nav style="padding: 8px;"> <a
									href="contactsDashboard.action" data-toggle="tooltip"
									data-original-title="Close" data-placement="bottom"
									class="btn btn-danger btn-sm"> <i class="fa fa-times"></i>
								</a></nav>
							</div>
							</header>

							<div class="body">
								<!-- action="addNewTaskAllocationDetails" -->
								<s:form class="form-horizontal" name="updateTaskDetailsForm"
									action="updateTaskAllocationDetails">

									<div class="alert alert-info" role="alert"
										style="margin-top: 25px; margin-left: 5px; margin-right: 5px;">

										<p>
											<s:if test="hasActionErrors()">
												<s:actionerror />
											</s:if>
											<s:elseif test="hasActionMessages()">
												<s:actionmessage />
											</s:elseif>
											<s:else>

												<div class="infoIcon">
													<span class="fa fa-info" style="margin-left: 3px;"></span>
												</div>&nbsp;&nbsp;&nbsp;<s:text
													name="add.update.task.information.bar" />
											</s:else>
										</p>
									</div>

									<div class="row" style="margin-top: 20px;">
										<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
											<h5>
												<s:text name="add.new.task.information"></s:text>
											</h5>
											<hr style="margin-top: -5px">
										</div>

									</div>

									<div class="row">

										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<label for="text1" class="control-label col-lg-4">
														<s:text name="add.task.allocatedby"></s:text>
													</label>
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:textfield name="taskAllocatedByName" disabled="true"
														cssClass="form-control">
													</s:textfield>
												</div>
											</div>
										</div>



										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<label for="text1" class="control-label col-lg-4">
														<s:text name="add.task.allocationdate"></s:text>

													</label>
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:textfield name="taskAllocationDate"
														cssClass="form-control" disabled="true">
													</s:textfield>
												</div>
											</div>
										</div>
									</div>


									<div class="row">
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<label for="text1" class="control-label col-lg-4">
														<s:text name="add.new.task.allocated"></s:text>
														<div class="star">*</div>
													</label>
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<div class="row">
														<div class="col-lg-3 col-md-3 col-sm-3 col-xs-5">
															<s:select class="form-control" name="salutation"
																list="salutationList" cssClass="form-control"
																tabindex="1" />
																<div id='updateTaskDetailsForm_salutation_errorloc'
																class="error_strings"></div>
														</div>
														<div class="col-lg-9 col-md-9 col-sm-9 col-xs-12">
															<%-- <s:textfield  tabindex="2"
																cssClass="form-control"></s:textfield> --%>
															<s:select cssClass="form-control chzn-select"
																list="taskAllocatedToList" headerKey="-1" tabindex="2"
																headerValue="Select Task Allocated To"
																name="taskAllocatedTo" />
															<div id='updateTaskDetailsForm_taskAllocatedTo_errorloc'
																class="error_strings"></div>
														</div>
													</div>
												</div>
											</div>
										</div>


										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<label for="text1" class="control-label col-lg-4">
														<s:text name="add.new.task.subject"></s:text>
														<div class="star">*</div>
													</label>
												</div>

												<div class="col-lg-6 col-md-6 col-sm-10 col-xs-10">
													<s:select cssClass="form-control chzn-select"
														list="taskSubjectList" headerKey="-1" tabindex="3"
														headerValue="Select Task Subject" name="taskSubject" />
													<div id='updateTaskDetailsForm_taskSubject_errorloc'
														class="error_strings"></div>
												</div>
												<div class="col-lg-1 col-md-1 col-sm-2 col-xs-2">
													<button type="button"
														onclick="PopupCenter('renderAddTaskSubject','RenderAddTaskSubject',800,600);"
														class="btn btn-metis-3 btn-line pull-right">
														<i class="fa fa-plus-square "></i>
													</button>
												</div>
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<label class="control-label col-lg-4"><s:text
															name="add.new.task.duedate"></s:text>
														<div class="star">*</div></label>
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:textfield cssClass="form-control" id="dp2"
														name="dueDate" tabindex="5"
														placeholder="Enter Task Due Date" />
													<div id='updateTaskDetailsForm_dueDate_errorloc'
														class="error_strings"></div>
												</div>
											</div>
										</div>
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<label for="text1" class="control-label col-lg-4"><s:text
															name="add.new.task.area"></s:text></label>
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:select cssClass="form-control chzn-select" headerKey="1"
														headerValue="Select Task Area" list="taskAreaList"
														name="taskArea" tabindex="6" />
												</div>
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<label class="control-label col-lg-4"><s:text
															name="add.new.task.status"></s:text> </label>
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:select cssClass="form-control chzn-select"
														list="taskStatusList" headerKey="-1"
														headerValue="Select Task Status" name="taskStatus"
														tabindex="7" />
												</div>
											</div>
										</div>
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<label class="control-label col-lg-4"><s:text
															name="add.new.task.priority"></s:text></label>
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:select cssClass="form-control chzn-select"
														headerKey="-1" headerValue="Select Task Priority"
														name="taskPriority" tabindex="8" list="taskPriorityList" />
												</div>
											</div>
										</div>
									</div>



									<div class="row">
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-8 col-xs-8">
													<label class="control-label col-lg-4"><s:text
															name="add.new.task.emailnotification"></s:text></label>
												</div>
												<div class="col-lg-8 col-md-8 col-sm-4 col-xs-4">
													<!-- <input type="checkbox" name="sendEmailNotification"
														id="emailNotification" value="option1" tabindex="9">
 -->
													<s:checkbox tabindex="9" name="sendEmailNotification">
													</s:checkbox>
												</div>
											</div>
										</div>

										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">

											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
													<label class="control-label col-lg-4"><s:text
															name="add.new.task.repeatdate"></s:text></label>
												</div>

												<div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">

													<s:textfield id="dp3" cssClass="form-control"
														name="startDate" placeholder="Start Date" tabindex="10"></s:textfield>
													<div id='updateTaskDetailsForm_startDate_errorloc'
														class="error_strings"></div>
												</div>
												<div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">

													<s:textfield id="dp4" cssClass="form-control"
														name="endDate" placeholder="End Date" tabindex="11"></s:textfield>
													<div id='updateTaskDetailsForm_endDate_errorloc'
														class="error_strings"></div>
												</div>
											</div>
										</div>
									</div>


									<div class="row">
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<label class="control-label col-lg-4"><s:text
															name="add.new.task.repeattype"></s:text>
														<div class="star">*</div></label>
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:select cssClass="form-control" id="selectOption"
														onchange="showDiv();" name="repeatType" headerKey="-1"
														headerValue="Select Repeat Type" tabindex="12"
														list="repeatTypeList" />
													<%-- list="#{'none':'None', 'dailyDiv':'Daily', 'weeklyDiv':'Weekly',
															'monthlyDiv':'Monthly','yearlyDiv':'Yearly'}" --%>

													<div id='updateTaskDetailsForm_repeatType_errorloc'
														class="error_strings"></div>
													<div id='updateTaskDetailsForm_repeatForEveryWeek_errorloc'
														class="error_strings"></div>
													<div id='updateTaskDetailsForm_numberOfWeeks_errorloc'
														class="error_strings"></div>
													<div id='updateTaskDetailsForm_weeksDay_errorloc'
														class="error_strings"></div>
													<div id='updateTaskDetailsForm_onDayOfMonths_errorloc'
														class="error_strings"></div>
													<div id='updateTaskDetailsForm_monthsDay_errorloc'
														class="error_strings"></div>
													<div id='updateTaskDetailsForm_numberOfMonths_errorloc'
														class="error_strings"></div>
													<div id='updateTaskDetailsForm_onWeek_errorloc'
														class="error_strings"></div>
													<div id='updateTaskDetailsForm_ofWeekDay_errorloc'
														class="error_strings"></div>
													<div id='updateTaskDetailsForm_onEveryNoOfMonths_errorloc'
														class="error_strings"></div>
													<div id='updateTaskDetailsForm_onEveryOfYear_errorloc'
														class="error_strings"></div>
													<div id='updateTaskDetailsForm_onMonthOfYear_errorloc'
														class="error_strings"></div>
													<div id='updateTaskDetailsForm_everyWeekOfYear_errorloc'
														class="error_strings"></div>
													<div id='updateTaskDetailsForm_everyWeekDayOfYear_errorloc'
														class="error_strings"></div>
													<div id='updateTaskDetailsForm_onDayOfYear_errorloc'
														class="error_strings"></div>
													<div id='updateTaskDetailsForm_everyMonthOfYear_errorloc'
														class="error_strings"></div>
													<div id='updateTaskDetailsForm_everyDay_errorloc'
														class="error_strings"></div>
													<div id='updateTaskDetailsForm_numberOfDays_errorloc'
														class="error_strings"></div>
												</div>
											</div>
										</div>
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12"></div>
									</div>
									<div id="dailyDiv">
										<div class="row">
											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12"></div>
													<div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
														<s:radio list="{'Every Day'}" name="everyDay"></s:radio>
													</div>
												</div>
											</div>
										</div>

										<div class="row">
											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12"></div>
													<div class="col-lg-3 col-md-3 col-sm-3 col-xs-12">
														<s:radio list="{'For every'}" name="everyDay"
															id="repeatForEveryRadio2"></s:radio>
														&nbsp;&nbsp;
														<s:textfield cssClass="form-control inline"
															name="numberOfDays" placeholder="Enter Number Of Days"></s:textfield>
														&nbsp;&nbsp; <label class="inline"><s:text
																name="add.new.task.days"></s:text></label>
													</div>
												</div>
											</div>
										</div>
									</div>

									<div id="weeklyDiv">
										<div class="row">
											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12"></div>
													<div class="col-lg-3 col-md-3 col-sm-3 col-xs-12">
														<label class="control-label"><s:checkbox
																name="repeatForEveryWeek" id="everyWeekRadio"></s:checkbox>
															<s:text name="add.new.task.forevery"></s:text></label>&nbsp;&nbsp;
														<s:textfield name="numberOfWeeks"
															cssClass="form-control inline"
															placeholder="Enter Number Of Days"></s:textfield>
														&nbsp;&nbsp; <label class="inline"><s:text
																name="add.new.task.weeks"></s:text></label>
													</div>
												</div>
											</div>
										</div>

										<div class="row">
											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12"></div>
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">

														<s:checkbox name="sunday">
														</s:checkbox>
														<s:text name="add.task.sunday"></s:text>

														<s:checkbox name="monday" value="true">
														</s:checkbox>
														<s:text name="add.task.monday"></s:text>

														<s:checkbox name="tuesday">
														</s:checkbox>
														<s:text name="add.task.tuesday"></s:text>

														<s:checkbox name="wednesday">
														</s:checkbox>
														<s:text name="add.task.wednesday"></s:text>

														<s:checkbox name="thursday">
														</s:checkbox>
														<s:text name="add.task.thursday"></s:text>

														<s:checkbox name="friday">
														</s:checkbox>
														<s:text name="add.task.friday"></s:text>

														<s:checkbox name="saturday">
														</s:checkbox>
														<s:text name="add.task.saturday"></s:text>
													</div>
												</div>
											</div>
										</div>
									</div>

									<div id="monthlyDiv">
										<div class="row">
											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12"></div>
													<div class="col-lg-4 col-md-4 col-sm-3 col-xs-12">
														<%-- <label><input type="radio" name="onDayOfMonths"
															id="onDayRadio" /> <s:text name="add.new.task.ondays"></s:text></label> --%>
														<s:radio list="{'On Day'}" name="onDayOfMonths"
															id="onDayRadio"></s:radio>
														&nbsp;&nbsp;
														<s:select cssClass="form-control inline"
															list="{'1','2','3','4','5','6','7','8'
															,'9','10','11','12','13','14','15','16','17'
															,'18','19','20','21','22','23','24','25','26'
															,'27','28','29','30','31'}"
															name="monthsDay" headerKey="-1"
															headerValue="Select Day Of Month" />
														&nbsp;&nbsp; <label class="control-label inline"><s:text
																name="add.new.task.ofevery"></s:text></label>&nbsp;&nbsp;
														<s:textfield name="numberOfMonths"
															cssClass="form-control inline"
															placeholder="Enter Number Of Days">
														</s:textfield>
														&nbsp;&nbsp; <label class="inline"><s:text
																name="add.new.task.months"></s:text></label>
													</div>
												</div>
											</div>
										</div>

										<div class="row">
											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12"></div>
													<div class="col-lg-4 col-md-4 col-sm-3 col-xs-12">
														<%-- <label class="control-label"><input type="radio"
															id="onMonthRadio" name="onDayOfMonths" /> <s:text
																name="add.new.task.on"></s:text></label> --%>
														<s:radio list="{'On'}" name="onDayOfMonths"
															id="onMonthRadio"></s:radio>
														&nbsp;&nbsp;
														<s:select cssClass="form-control inline" name="onWeek"
															list="weekNumberList" headerKey="-1"
															headerValue="Select Week Number" />
														&nbsp;&nbsp;
														<s:select headerKey="-1" headerValue="Select Day Name"
															cssClass="form-control inline" list="dayNameList"
															name="ofWeekDay" />
														&nbsp;&nbsp; <label class="inline"><s:text
																name="add.new.task.ofevery"></s:text></label>&nbsp;&nbsp;
														<s:textfield name="onEveryNoOfMonths"
															cssClass="form-control inline"
															placeholder="Enter Number Of Days"></s:textfield>
														&nbsp;&nbsp; <label class="inline"><s:text
																name="add.new.task.months"></s:text></label>
													</div>
												</div>
											</div>
										</div>
									</div>

									<div id="yearlyDiv">
										<div class="row">
											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12"></div>
													<div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
														<%-- <label class="control-label"><input type="radio"
															id="onEveryRadioOfYear" name="onEveryOfYear"> <s:text
																name="add.new.task.onevery"></s:text></label> --%>
														<s:radio list="{'On Every'}" name="onEveryOfYear"
															id="onEveryRadioOfYear"></s:radio>
														&nbsp;&nbsp;
														<s:select cssClass="form-control inline" headerKey="-1"
															headerValue="Select Month Name" list="monthsNameList"
															name="onMonthOfYear" />
														&nbsp;&nbsp;
														<s:select cssClass="form-control inline"
															list="{'1','2','3','4','5','6','7','8'
															,'9','10','11','12','13','14','15','16','17'
															,'18','19','20','21','22','23','24','25','26'
															,'27','28','29','30','31'}"
															name="onDayOfYear" headerKey="-1"
															headerValue="Select Day Of Month" />
													</div>
												</div>
											</div>
										</div>

										<div class="row">
											<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-2 col-md-2 col-sm-12 col-xs-12"></div>
													<div class="col-lg-2 col-md-2 col-sm-3 col-xs-12">
														<%-- <label class="control-label"><input type="radio"
															id="everyOfYearRadio" name="onEveryOfYear" /> <s:text
																name="add.new.task.every"></s:text></label> --%>
														<s:radio list="{'Every'}" name="onEveryOfYear"
															id="everyOfYearRadio"></s:radio>
														&nbsp;&nbsp;
														<s:select cssClass="form-control inline"
															list="weekNumberList" headerKey="-1"
															headerValue="Select Week Number" name="everyWeekOfYear" />
														&nbsp;&nbsp;
														<s:select headerKey="-1" headerValue="Select Day Name"
															cssClass="form-control inline" list="dayNameList"
															name="everyWeekDayOfYear" />
														&nbsp;&nbsp; <label class="inline"><s:text
																name="add.new.task.of"></s:text></label>&nbsp;&nbsp;
														<s:select cssClass="form-control inline" headerKey="-1"
															headerValue="Select Month Name" list="monthsNameList"
															name="everyMonthOfYear" />
													</div>
												</div>
											</div>
										</div>
									</div>


									<div class="row" style="margin-top: 20px;">
										<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
											<h5>
												<s:text name="add.new.task.discription">
												</s:text>
												<div class="star">*</div>
											</h5>
											<hr style="margin-top: -5px">
										</div>
									</div>
									<div class="form-group">
										<div id='updateTaskDetailsForm_discription_errorloc'
											class="error_strings" style="margin: 1% 2%;"></div>
										<div class="row" style="margin: 1% 2%;" id="data_grid">
											<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
												<s:textarea id="wysihtml5" name="discription"
													cssClass="form-control" rows="10">
												</s:textarea>
											</div>
										</div>
									</div>
									<hr style="margin-top: 20px">
									<div class="row">
										<div
											class="col-lg-4 col-md-4 col-sm-12 col-xs-12 col-md-offset-5">
											<a href="taskDashboard.action" data-toggle="tooltip"
												data-original-title="Back To Task DashBoard"
												class="btn btn-default" ontheme="simple"><s:text
													name="project.form.button.cancel" /> </a>

											<s:reset cssClass="btn btn-success"
												key="project.form.button.reset" theme="simple"
												onclick="window.location.reload();" />

											<s:submit cssClass="btn btn-primary"
												key="project.form.button.submit" theme="simple"
												onclick="check()" />

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

	<script src="outer/js/gen_validatorv4.js" type="text/javascript"></script>
	<script type="text/javascript">
		var frmvalidator = new Validator("updateTaskDetailsForm");
		frmvalidator.EnableOnPageErrorDisplay();
		frmvalidator.EnableMsgsTogether();

		frmvalidator.addValidation("taskAllocatedTo", "dontselect=-1",
				"Select Task Allocated To");

		frmvalidator.addValidation("taskSubject", "dontselect=-1",
				"Select Task Subject");

		frmvalidator.addValidation("dueDate", "req", "Enter Due Date");

		frmvalidator.addValidation("repeatType", "dontselect=-1",
				"Select Repeat Type");

		frmvalidator.addValidation("discription", "req", "Enter Description");
		frmvalidator.addValidation("discription", "maxlen=4000",
				"Description Should Be 4000 Character");
	</script>

	<script type="text/javascript">
		function check() {
			var frmvalidator = new Validator("updateTaskDetailsForm");
			frmvalidator.EnableOnPageErrorDisplay();
			frmvalidator.EnableMsgsTogether();

			frmvalidator.addValidation("salutation", "dontselect=8", "Select Salutataion");
			
			var selectId = document.getElementById('selectOption');

			if (selectId.value == 2) {
				frmvalidator.addValidation("everyDay", "selone",
						"Select One Of Below Radio Button");
				if (document.getElementById('repeatForEveryRadio2').checked == true) {
					frmvalidator.addValidation("numberOfDays", "req",
							"Enter Number of Days");
					frmvalidator.addValidation("numberOfDays", "maxlen=2",
							"Number Of Days Should Be 2 Digit");
					frmvalidator.addValidation("numberOfDays", "minlen=1",
							"Number Of Days Should Be 1 Digit");
					frmvalidator.addValidation("numberOfDays", "numeric",
							"Number Of Days Should Be Digit");
				}
			} else if (selectId.value == 3) {

				frmvalidator.addValidation("repeatForEveryWeek",
						"shouldselchk=on", "Select Below Check Box");

				var everyWeekRadio = document.getElementById('everyWeekRadio');

				if (everyWeekRadio.checked == true) {
					frmvalidator.addValidation("numberOfWeeks", "req",
							"Enter Number of Weeks");
					frmvalidator.addValidation("numberOfWeeks", "maxlen=2",
							"Number Of Week Should Be 2 Digit");
					frmvalidator.addValidation("numberOfWeeks", "minlen=1",
							"Number Of Week Should Be 1 Digit");
					frmvalidator.addValidation("numberOfWeeks", "numeric",
							"Number Of Week Should Be Digit");

				}

			} else if (selectId.value == 4) {
				frmvalidator.addValidation("onDayOfMonths", "selone",
						"Select One Of Below Radio Button");

				var onDayRadio = document.getElementById('onDayRadio');

				if (onDayRadio.checked == true) {
					frmvalidator.addValidation("monthsDay", "dontselect=-1",
							"Select Months Day");
					frmvalidator.addValidation("numberOfMonths", "req",
							"Enter Number of Months");
					frmvalidator.addValidation("numberOfMonths", "maxlen=2",
							"Number Of Months Should Be 2 Digit");
					frmvalidator.addValidation("numberOfMonths", "minlen=1",
							"Number Of Months Should Be 1 Digit");
					frmvalidator.addValidation("numberOfMonths", "numeric",
							"Number Of Months Should Be Digit");
				}

				var onMonthRadio = document.getElementById('onMonthRadio');

				if (onMonthRadio.checked == true) {
					frmvalidator.addValidation("ofWeekDay", "dontselect=-1",
							"Select Day Name");

					frmvalidator.addValidation("onWeek", "dontselect=-1",
							"Select Week Number");

					frmvalidator.addValidation("onEveryNoOfMonths", "req",
							"Enter Number Of Months");
					frmvalidator.addValidation("onEveryNoOfMonths", "maxlen=2",
							"Maximum Length Should Be 2 Digit");
					frmvalidator.addValidation("onEveryNoOfMonths", "minlen=1",
							"Minimum Length Should Be 1 Digit");
					frmvalidator.addValidation("onEveryNoOfMonths", "numeric",
							"Minimum Length Should Be 1 Digit");

				}
			} else if (selectId.value == 5) {
				frmvalidator.addValidation("onEveryOfYear", "selone",
						"Select One Of Below Radio Button");

				var onEveryRadioOfYear = document
						.getElementById('onEveryRadioOfYear');

				if (onEveryRadioOfYear.checked == true) {
					frmvalidator.addValidation("onMonthOfYear",
							"dontselect=-1", "Select Month Name");

					frmvalidator.addValidation("onDayOfYear", "dontselect=-1",
							"Select Day Of Month");

				}

				var everyOfYearRadio = document
						.getElementById('everyOfYearRadio');

				if (everyOfYearRadio.checked == true) {
					frmvalidator.addValidation("everyWeekDayOfYear",
							"dontselect=-1", "Select Week Number");

					frmvalidator.addValidation("everyWeekOfYear",
							"dontselect=-1", "Select Day name");

					frmvalidator.addValidation("everyMonthOfYear",
							"dontselect=-1", "Select Month Name");
				}
			}
		}
	</script>
</body>
</html>