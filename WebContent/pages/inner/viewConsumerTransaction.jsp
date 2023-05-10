<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>View Consumer Transaction</title>
</head>
<body>
<div class="outer">
		<div class="inner bg-light lter">
			<div class="box">
				<div class="container-fluid">
					<ol class="breadcrumb" style="margin-top: 10px;">
						<li><a href="omiInnerDashboard.action"><i
								class="fa fa-home"></i></a></li>
						<li><a href="salesDashboard"><%-- <s:text
									name="ticket.Dashboard.navbar"></s:text> --%>Consumer</a></li>
						<li><a href="salesDashboard"><%-- <s:text
									name="ticket.Dashboard.panel.heading"></s:text> --%>Consumer Transaction</a></li>
						<li><a
							href="viewEstimateAction?command=<s:property value='id'/>"
							data-placement="bottom"> <%-- <s:text
									name="view.Ticket.panel.heading"></s:text> --%>View Consumer Transaction
						</a></li>
					</ol>
					<header> <a class="icons" href="salesDashboard"
						data-toggle="tooltip"
						data-original-title="Back To Estimate DashBoard"
						style="color: black;"> <i class="fa fa-th-large"></i>
					</a>
					<h5>
						<%-- <s:text name="view.Ticket.panel.heading" /> --%>View Consumer Transaction Details
					</h5>
					<div class="pull-right">
						<div class="btn-group">
							<a class="btn btn-default btnheight" data-toggle="tooltip"
								data-original-title="Help"><i class="fa fa-question"></i> <s:text
									name="project.form.button.help"></s:text></a>
									 <a 
								class="btn btn-primary btnheight" data-toggle="tooltip"
								data-original-title="Print"><i class="fa fa-print"></i> <s:text
									name="project.form.button.print"></s:text></a>
									
									 <a
								data-toggle="tooltip" data-original-title="PDF Report"
								href="consumerTransactionPrintPDF.action?command=<s:property value='transactionId' />"
								class="btn btn-success btnheight"><i
								class="fa fa-file-pdf-o "></i> <s:text
									name="project.form.button.pdf"></s:text></a> <a
								data-toggle="tooltip" data-original-title="Previous Ticket"
								href="viewPreviousConsumerTransactionInfo.action?command=<s:property value='transactionId' />"
								type="button" class="btn btn-default btnheight"><i
								class="fa fa-chevron-left fontawesomeht"></i></a> <a
								data-toggle="tooltip" data-original-title="Next Ticket"
								href="viewNextConsumerTransactionInfo.action?command=<s:property value='transactionId' />"
								class="btn btn-default btnheight"><i
								class="fa fa-chevron-right fontawesomeht"></i></a> <a
								data-toggle="tooltip" data-original-title="Close"
								href="completeConsumerTransaction" class="btn btn-danger btnheight"><i
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
											<i class="fa fa-info-circle "><%--  <s:text
													name="view.Ticket.infobar" /> --%>You can see Sales Details here</i>
										</div>
									</div>
								</s:else>
							</p>
						</div>
						<div style="padding-left: 15px; padding-right: 15px;">
							<s:form class="form-horizontal">
								<s:iterator value="consumerCustomerVO">
									<div class="row">
										<div
											class="col-lg-12 col-md-12 col-sm-12 col-xs-12 viewinnertitle">
											<h5>
												<%-- <s:text name="add.new.ticket.title" /> --%>Consumer Information
											</h5>
										</div>
									</div>
									<hr>
									<div class="row">
										<div class="col-md-12 col-sm-12 col-xs-12"
											id="view_lable_value">
											<div class="col-md-2 col-sm-12 col-xs-12">
												<label for="text1" class="control-label" id="viewlable">
													<%-- <s:text name="add.new.ticket.ticketId"></s:text> --%>Transaction Id
												</label>
											</div>
											<div class="col-md-10 col-sm-12 col-xs-12 control-label">
												<s:property value="transactionId" />
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12 col-sm-12 col-xs-12"
											id="view_lable_value2">
											<div class="col-md-2 col-sm-12 col-xs-12">
												<label for="text1" class="control-label" id="viewlable">Description
													<%-- <s:text name="add.new.ticket.category"></s:text> --%>
												</label>
											</div>
											<div class="col-md-10 col-sm-12 col-xs-12 control-label">
												<s:property value="description" />
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12 col-sm-12 col-xs-12"
											id="view_lable_value">
											<div class="col-md-2 col-sm-12 col-xs-12">
												<label for="text1" class="control-label" id="viewlable">
													<%-- <s:text name="add.new.ticket.contactName"></s:text> --%>Total
												</label>
											</div>
											<div class="col-md-10 col-sm-12 col-xs-12 control-label">
												 <s:property value="total" /> 
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12 col-sm-12 col-xs-12"
											id="view_lable_value2">
											<div class="col-md-2 col-sm-12 col-xs-12">
												<label for="text1" class="control-label" id="viewlable">
													<%-- <s:text name="add.new.ticket.productName"></s:text> --%>Paid
												</label>
											</div>
											<div class="col-md-10 col-sm-12 col-xs-12 control-label">
												<s:property value="paid" />
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12 col-sm-12 col-xs-12"
											id="view_lable_value">
											<div class="col-md-2 col-sm-12 col-xs-12">
												<label for="text1" class="control-label " id="viewlable">
													<%-- <s:text name="add.new.ticket.ticketOwner"></s:text> --%>Due
												</label>
											</div>
											<div class="col-md-10 col-sm-12 col-xs-12 control-label">
												<s:property value="due" />
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12 col-sm-12 col-xs-12"
											id="view_lable_value2">
											<div class="col-md-2 col-sm-12 col-xs-12">
												<label for="text1" class="control-label" id="viewlable">
													<%-- <s:text name="add.new.ticket.phoneNo"></s:text> --%>Total Paid
												</label>
											</div>
											<div class="col-md-10 col-sm-12 col-xs-12 control-label">
												<%-- <s:property value="phoneIsd" />
												<s:property value="phoneStd" /> --%>
												<s:property value="totalPaid" />
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12 col-sm-12 col-xs-12"
											id="view_lable_value">
											<div class="col-md-2 col-sm-12 col-xs-12">
												<label for="text1" class="control-label" id="viewlable">
													<%-- <s:text name="add.new.ticket.email"></s:text> --%>Total Due
												</label>
											</div>
											<div class="col-md-10 col-sm-12 col-xs-12 control-label">
												<s:property value="totalDue" />
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12 col-sm-12 col-xs-12"
											id="view_lable_value2">
											<div class="col-md-2 col-sm-12 col-xs-12">
												<label for="text1" class="control-label" id="viewlable">
													<%-- <s:text name="add.new.ticket.subject"></s:text> --%>Transaction Date
												</label>
											</div>
											<div class="col-md-10 col-sm-12 col-xs-12 control-label">
												<s:property value="transactionDate" />
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12  col-sm-12 col-xs-12"
											id="view_lable_value">
											<div class="col-md-2 col-sm-12 col-xs-12">
												<label for="text1" class="control-label" id="viewlable">
													<%-- <s:text name="add.new.ticket.status" /> --%>Consumer Id
												</label>
											</div>
											<div class="col-md-10 col-sm-12 col-xs-12 control-label">
												<s:property value="retailerId" />
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12  col-sm-12 col-xs-12"
											id="view_lable_value">
											<div class="col-md-2 col-sm-12 col-xs-12">
												<label for="text1" class="control-label" id="viewlable">
													<%-- <s:text name="add.new.ticket.status" /> --%>Consumer Name
												</label>
											</div>
											<div class="col-md-10 col-sm-12 col-xs-12 control-label">
												<s:property value="fullName" />
											</div>
										</div>
									</div>
									
									<div class="row">
										<div class="col-md-12  col-sm-12 col-xs-12"
											id="view_lable_value2">
											<div class="col-md-2 col-sm-12 col-xs-12">
												<label for="text1" class="control-label" id="viewlable">
												<%-- <s:text name="add.new.ticket.dueDate" /> --%>Payment Mode</label>
											</div>
											<div class="col-md-10 col-sm-12 col-xs-12 control-label">
												<s:property value="paymentMode" />
											</div>
										</div>
									</div>
									<%-- <div class="row">
										<div class="col-md-12  col-sm-12 col-xs-12"
											id="view_lable_value">
											<div class="col-md-2 col-sm-12 col-xs-12">
												<label for="text1" class="control-label" id="viewlable">
												<s:text
														name="add.new.ticket.priority"></s:text>E-mail Id</label>
											</div>
											<div class="col-md-10 col-sm-12 col-xs-12 control-label">
												<s:property value="peimaryMailId" />
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12  col-sm-12 col-xs-12"
											id="view_lable_value2">
											<div class="col-md-2 col-sm-12 col-xs-12">
												<label for="text1" class="control-label" id="viewlable"><s:text
														name="add.new.ticket.channel"></s:text>Alternative E-mail Id</label>
											</div>
											<div class="col-md-10 col-sm-12 col-xs-12 control-label">
												<s:property value="alternativeMail" />

											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12  col-sm-12 col-xs-12"
											id="view_lable_value">
											<div class="col-md-2 col-sm-12 col-xs-12">
												<label for="text1" class="control-label" id="viewlable"><s:text
														name="add.new.ticket.description" />Creation Date</label>
											</div>
											<div class="col-md-10 col-sm-12 col-xs-12 control-label">
												<s:property value="creationDate" />

											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12  col-sm-12 col-xs-12"
											id="view_lable_value">
											<div class="col-md-2 col-sm-12 col-xs-12">
												<label for="text1" class="control-label" id="viewlable"><s:text
														name="add.new.ticket.description" />Created By</label>
											</div>
											<div class="col-md-10 col-sm-12 col-xs-12 control-label">
												<s:property value="createdBy" />

											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12  col-sm-12 col-xs-12"
											id="view_lable_value2">
											<div class="col-md-2 col-sm-12 col-xs-12">
												<label for="text1" class="control-label" id="viewlable"><s:text
														name="Attachment File" />Work Location</label>
											</div>
											<div class="col-md-10 col-sm-12 col-xs-12 control-label">
												<s:property value="workLocation" />
											</div>
										</div> --%>





										<hr style="margin-top: 20px">
										<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"
											align="center">
											<a href="completeConsumerTransaction" data-toggle="tooltip"
												data-original-title="Cancel"
												class="btn btn-default btnheight"><i
												class="fa fa-caret-square-o-left fontawesomeht"></i> <s:text
													name="project.form.button.cancel"></s:text></a>
										</div>
										</s:iterator>
							</s:form>
									</div>
								
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>