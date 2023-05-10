<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>

	<div class="outer">
		<div class="inner bg-light lter">
			<div class="box">
				<div class="container-fluid">
					<ol class="breadcrumb" style="margin-top: 10px;">
						<li><a href="omiInnerDashboard.action"><i
								class="fa fa-home"></i></a></li>
						<li><a href="serviceContractDashboard.action"><s:text
									name="service.contract.dashboard.navbar"></s:text></a></li>
						<li><a href="serviceContractDashboard.action"><s:text
									name="service.contract.dashboard.panel.heading"></s:text></a></li>
						<li><a
							href="viewServiceContract.action?command=<s:property value='serviceContactId' />"
							data-placement="bottom"><s:text
									name="view.service.contract.pannel.heading"></s:text></a></li>

					</ol>
					<header> <a class="icons"
						href="serviceContractDashboard.action" data-toggle="tooltip"
						data-original-title="Back To Service Dashboard"
						style="color: black;"> <i class="fa fa-th-large"></i>
					</a>
					<h5>
						<s:text name="view.service.contract.pannel.heading" />
					</h5>
					<div class="pull-right">
						<div class="btn-group">
							<a class="btn btn-default btnheight" data-toggle="tooltip"
								data-original-title="Help"><i class="fa fa-question"></i> <s:text
									name="project.form.button.help"></s:text></a> <a
								class="btn btn-primary btnheight" data-toggle="tooltip"
								data-original-title="Print"><i class="fa fa-print"></i> <s:text
									name="project.form.button.print"></s:text></a> <a
								data-toggle="tooltip" data-original-title="PDF Report"
								href="servicePrintPDF.action?command=<s:property value='serviceContactId' />"
								class="btn btn-success btnheight"><i
								class="fa fa-file-pdf-o "></i> <s:text
									name="project.form.button.pdf"></s:text></a> <a
								data-toggle="tooltip" data-original-title="Previous Service"
								href="viewPriviousServiceContract.action?command=<s:property value='serviceContactId' />"
								type="button" class="btn btn-default btnheight"><i
								class="fa fa-chevron-left fontawesomeht"></i></a> <a
								data-toggle="tooltip" data-original-title="Next Service"
								href="viewNextServiceContract.action?command=<s:property value='serviceContactId' />"
								class="btn btn-default btnheight"><i
								class="fa fa-chevron-right fontawesomeht"></i></a> <a
								data-toggle="tooltip" data-original-title="Close"
								href="serviceContractDashboard.action"
								class="btn btn-danger btnheight"><i
								class="fa fa-times fontawesomeht"></i></a>
						</div>
					</div>
					</header>
					<div id="div-2" class="body">
						<div>
							<p>
								<s:if test="hasActionErrors()">
									<div class="alert alert-danger" role="alert"
										style="padding-bottom: 7px;">
										<div class="infoIcon">
											<!-- <i class="fa fa-times-circle "></i> -->
											<s:actionerror />
										</div>
									</div>
								</s:if>
								<s:elseif test="hasActionMessages()">
									<div class="alert alert-success" role="alert"
										style="padding-bottom: 7px;">
										<div class="infoIcon">
											<!-- <i class="fa fa-check-circle "> </i> -->
											<s:actionmessage />
										</div>
									</div>
								</s:elseif>
								<s:else>

									<div class="alert alert-info" role="alert">
										<div class="infoIcon">
											<i class="fa fa-info-circle "> <s:text
													name="view.service.contract.infobar" /></i>
										</div>
									</div>
								</s:else>
							</p>
						</div>
						<div style="padding-left: 15px; padding-right: 15px;">
							<form class="form-horizontal">
								<s:iterator value="serviceContactVo">
									<div class="row">
										<div
											class="col-lg-12 col-md-12 col-sm-12 col-xs-12 viewinnertitle">
											<h5>
												<s:text name="view.service.contract.title" />
											</h5>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12 col-sm-12 col-xs-12"
											id="view_lable_value">
											<div class="col-md-2 col-sm-2 col-xs-2">
												<label for="text1" class="control-label" id="viewlable">
													<s:text name="add.service.contract.id" />
												</label>
											</div>
											<div class="col-md-10 col-sm-10 col-xs-10 control-label">
												<s:property value="serviceContactId" />
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12 col-sm-12 col-xs-12"
											id="view_lable_value2">
											<div class="col-md-2 col-sm-2 col-xs-2">
												<label for="text1" class="control-label" id="viewlable">
													<s:text name="add.service.contract.service.type" />
												</label>
											</div>
											<div class="col-md-10 col-sm-10 col-xs-10 control-label">
												<s:property value="serviceContactType" />
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12 col-sm-12 col-xs-12"
											id="view_lable_value">
											<div class="col-md-2 col-sm-2 col-xs-2">
												<label for="text1" class="control-label" id="viewlable">
													<s:text name="add.service.contract.subject" />
												</label>
											</div>
											<div class="col-md-10 col-sm-10 col-xs-10 control-label">
												<s:property value="subject" />
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12 col-sm-12 col-xs-12"
											id="view_lable_value2">
											<div class="col-md-2 col-sm-2 col-xs-2">
												<label for="text1" class="control-label" id="viewlable">
													<s:text name="add.service.contract.tracking" />
												</label>
											</div>
											<div class="col-md-10 col-sm-10 col-xs-10 control-label">
												<s:property value="trackingUnit" />
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12 col-sm-12 col-xs-12"
											id="view_lable_value">
											<div class="col-md-2 col-sm-2 col-xs-2">
												<label for="text1" class="control-label " id="viewlable">
													<s:text name="add.service.contract.related.to" />
												</label>
											</div>
											<div class="col-md-10 col-sm-10 col-xs-10 control-label">
												<s:property value="relatedTo" />
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12 col-sm-12 col-xs-12"
											id="view_lable_value2">
											<div class="col-md-2 col-sm-2 col-xs-2">
												<label for="text1" class="control-label" id="viewlable">
													<s:text name="add.service.contract.assigned.to" />
												</label>
											</div>
											<div class="col-md-10 col-sm-10 col-xs-10 control-label">
												<s:property value="assignedTO" />

											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12 col-sm-12 col-xs-12"
											id="view_lable_value">
											<div class="col-md-2 col-sm-2 col-xs-2">
												<label for="text1" class="control-label" id="viewlable">
													<s:text name="add.service.contract.priority" />
												</label>
											</div>
											<div class="col-md-10 col-sm-10 col-xs-10 control-label">
												<s:property value="priority" />
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12 col-sm-12 col-xs-12"
											id="view_lable_value2">
											<div class="col-md-2 col-sm-2 col-xs-2">
												<label for="text1" class="control-label" id="viewlable">
													<s:text name="add.service.contract.status" />
												</label>
											</div>
											<div class="col-md-10 col-sm-10 col-xs-10 control-label">
												<s:property value="status" />
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12  col-sm-12 col-xs-12"
											id="view_lable_value">
											<div class="col-md-2 col-sm-2 col-xs-2">
												<label for="text1" class="control-label" id="viewlable"><s:text
														name="add.service.contract.used.units" /></label>
											</div>
											<div class="col-md-10 col-sm-10 col-xs-10 control-label">
												<s:property value="usedUnits" />
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12  col-sm-12 col-xs-12"
											id="view_lable_value2">
											<div class="col-md-2 col-sm-2 col-xs-2">
												<label for="text1" class="control-label" id="viewlable"><s:text
														name="add.service.contract.total.units" /></label>
											</div>
											<div class="col-md-10 col-sm-10 col-xs-10 control-label">
												<s:property value="totalUnits" />
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12  col-sm-12 col-xs-12"
											id="view_lable_value">
											<div class="col-md-2 col-sm-2 col-xs-2">
												<label for="text1" class="control-label" id="viewlable"><s:text
														name="add.service.contract.start.date" /></label>
											</div>
											<div class="col-md-10 col-sm-10 col-xs-10 control-label">
												<s:property value="startDate" />
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12  col-sm-12 col-xs-12"
											id="view_lable_value2">
											<div class="col-md-2 col-sm-2 col-xs-2">
												<label for="text1" class="control-label" id="viewlable"><s:text
														name="add.service.contract.due.date" /></label>
											</div>
											<div class="col-md-10 col-sm-10 col-xs-10 control-label">
												<s:property value="dueDate" />

											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12  col-sm-12 col-xs-12"
											id="view_lable_value">
											<div class="col-md-2 col-sm-2 col-xs-2">
												<label for="text1" class="control-label" id="viewlable"><s:text
														name="add.service.contract.contact.name" /></label>
											</div>
											<div class="col-md-10 col-sm-10 col-xs-10 control-label">
												<s:property value="contactName" />

											</div>
										</div>
									</div>
								</s:iterator>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>