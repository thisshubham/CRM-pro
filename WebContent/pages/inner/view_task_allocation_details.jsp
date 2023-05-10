<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <%@taglib uri="/struts-tags" prefix="s"%> --%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>

	<div class="outer">
		<div class="inner bg-light lter">
			<div class="box dark">
				<header> <a class="icons" href="taskDashboard.action"
					data-toggle="tooltip" data-original-title="Back To Task DashBoard"
					style="color: black;"> <i class="fa fa-th-large"></i>
				</a>
				<h5>Task Details</h5>

				<!-- .toolbar -->
				<div class="toolbar">
					<nav style="padding: 8px;"> <a href="" data-toggle="tooltip"
						data-original-title="Print" class="btn btn-metis-5 btn-sm"> <i
						class="fa fa-print"></i>
					</a> <a href="#" data-toggle="tooltip" data-original-title="PDF Report"
						class="btn btn-metis-6 btn-sm "> <i class="fa fa-file-pdf-o "></i>
					</a> <a href="taskDashboard.action" data-toggle="tooltip"
						data-original-title="Close" data-placement="bottom"
						class="btn btn-danger btn-sm"> <i class="fa fa-times"></i>
					</a></nav>
				</div>
				</header>

				<div class="container">
					<div id="div-2" class="body">
						<form class="form-horizontal">
							<s:iterator value="TaskVO" var="testObj">
								<div class="row" style="margin-top: 10px;">
									<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
										<h5>
											<s:text name="add.new.task.information"></s:text>
										</h5>
									</div>

								</div>
								<div class="row">
									<div class="col-md-12 col-sm-12 col-xs-12">
										<div class="col-md-2 col-sm-12 col-xs-12" id="view_lable">
											<label for="text1" class="control-label" id="viewlable">
												<s:text name="add.new.task.allocated"></s:text>
											</label>
										</div>
										<div class="col-md-10 col-sm-12 col-xs-12"
											id="view_lable_value">
											<s:property value="taskAllocatedToName" />
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12 col-sm-12 col-xs-12">

										<div class="col-md-2 col-sm-12 col-xs-12" id="view_lable">
											<label for="text1" class="control-label " id="viewlable">
												<s:text name="add.new.task.subject"></s:text>
											</label>
										</div>
										<div class="col-md-10 col-sm-12 col-xs-12"
											id="view_lable_value2">
											<label for="text1" class="control-label"> <s:property
													value="taskSubject" /></label>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12 col-sm-12 col-xs-12">
										<div class="col-md-2 col-sm-12 col-xs-12" id="view_lable">
											<label for="text1" class="control-label" id="viewlable">
												<s:text name="add.new.task.duedate"></s:text>
											</label>
										</div>
										<div class="col-md-10 col-sm-12 col-xs-12"
											id="view_lable_value">
											<label for="text1" class="control-label "><s:property
													value="dueDate" /></label>

										</div>
									</div>
								</div>

								<div class="row">
									<div class="col-md-12 col-sm-12 col-xs-12">
										<div class="col-md-2 col-sm-12 col-xs-12" id="view_lable">
											<label for="text1" class="control-label" id="viewlable">
												<s:text name="add.new.task.area"></s:text>
											</label>
										</div>
										<div class="col-md-10 col-sm-12 col-xs-12"
											id="view_lable_value2">
											<label for="text1" class="control-label"><s:property
													value="taskArea" /></label>
										</div>

									</div>
								</div>

								<div class="row">
									<div class="col-md-12 col-sm-12 col-xs-12">
										<div class="col-md-2 col-sm-12 col-xs-12" id="view_lable">
											<label for="text1" class="control-label" id="viewlable">
												<s:text name="add.new.task.status"></s:text>
											</label>
										</div>
										<div class="col-md-10 col-sm-12 col-xs-12"
											id="view_lable_value">
											<label for="text1" class="control-label"><s:property
													value="taskStatus" /></label>
										</div>

									</div>
								</div>

								<div class="row">
									<div class="col-md-12 col-sm-12 col-xs-12">
										<div class="col-md-2 col-sm-12 col-xs-12" id="view_lable">
											<label for="text1" class="control-label" id="viewlable">
												<s:text name="add.new.task.priority"></s:text>
											</label>
										</div>
										<div class="col-md-10 col-sm-12 col-xs-12"
											id="view_lable_value2">
											<label for="text1" class="control-label"><s:property
													value="taskPriority" /></label>
										</div>

									</div>
								</div>


								<div class="row">
									<div class="col-md-12 col-sm-12 col-xs-12">
										<div class="col-md-2 col-sm-12 col-xs-12" id="view_lable">
											<label for="text1" class="control-label" id="viewlable">
												<s:text name="add.new.task.emailnotification"></s:text>
											</label>
										</div>
										<div class="col-md-10 col-sm-12 col-xs-12"
											id="view_lable_value">
											<label for="text1" class="control-label"> <s:property
													value="sendEmailNotification" />
											</label>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12  col-sm-12 col-xs-12">
										<div class="col-md-2 col-sm-12 col-xs-12" id="view_lable">
											<label for="text1" class="control-label" id="viewlable"><s:text
													name="add.new.task.startdate"></s:text></label>
										</div>
										<div class="col-md-10 col-sm-12 col-xs-12"
											id="view_lable_value2">
											<label for="text1" class="control-label"> <s:property
													value="startDate" />
											</label>
										</div>
									</div>
								</div>



								<div class="row">
									<div class="col-md-12  col-sm-12 col-xs-12">
										<div class="col-md-2 col-sm-12 col-xs-12" id="view_lable">
											<label for="text1" class="control-label" id="viewlable"><s:text
													name="add.new.task.enddate"></s:text></label>
										</div>
										<div class="col-md-10 col-sm-12 col-xs-12"
											id="view_lable_value">
											<label for="text1" class="control-label"> <s:property
													value="endDate" /></label>

										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12  col-sm-12 col-xs-12">
										<div class="col-md-2 col-sm-12 col-xs-12" id="view_lable">
											<label for="text1" class="control-label" id="viewlable"><s:text
													name="add.task.allocationdate"></s:text></label>
										</div>
										<div class="col-md-10 col-sm-12 col-xs-12"
											id="view_lable_value2">
											<label for="text1" class="control-label"><s:property
													value="taskAllocationDate" /></label>
										</div>
									</div>
								</div>

								<div class="row">
									<div class="col-md-12  col-sm-12 col-xs-12">
										<div class="col-md-2 col-sm-12 col-xs-12" id="view_lable">
											<label for="text1" class="control-label" id="viewlable"><s:text
													name="add.task.allocatedby"></s:text></label>
										</div>
										<div class="col-md-10 col-sm-12 col-xs-12"
											id="view_lable_value">
											<label for="text1" class="control-label"><s:property
													value="taskAllocatedByName" /></label>

										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-lg-12">
										<div>
											<div id="div-3" class="body tab-content ">
												<div class="collapse in" id="show">
													<div id="wmd-preview" class="wmd-panel wmd-preview">
														${Discription}</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</s:iterator>
						</form>
						<%-- <hr style="margin-top: 20px">
						<div class="row" style="margin-top: 10px;">
							<div
								class="col-lg-4 col-md-4 col-sm-12 col-xs-12 col-md-offset-5">
								<a href="taskDashboard.action" class="btn btn-default "><s:text
										name="project.form.button.cancel" /></a>
							</div>
						</div> --%>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>