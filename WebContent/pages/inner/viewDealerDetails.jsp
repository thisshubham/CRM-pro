<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>View Dealer Detail</title>
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
									name="ticket.Dashboard.navbar"></s:text> --%>Dealer</a></li>
						<li><a href="salesDashboard"><%-- <s:text
									name="ticket.Dashboard.panel.heading"></s:text> --%>Dealer Dashboard</a></li>
						<li><a
							href="viewEstimateAction?command=<s:property value='id'/>"
							data-placement="bottom"> <%-- <s:text
									name="view.Ticket.panel.heading"></s:text> --%>View Dealer
						</a></li>
					</ol>
					<header> <a class="icons" href="salesDashboard"
						data-toggle="tooltip"
						data-original-title="Back To Estimate DashBoard"
						style="color: black;"> <i class="fa fa-th-large"></i>
					</a>
					<h5>
						<%-- <s:text name="view.Ticket.panel.heading" /> --%>View Dealer Details
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
								href="dealerDetailPrintPDF.action?command=<s:property value='customerId' />"
								class="btn btn-success btnheight"><i
								class="fa fa-file-pdf-o "></i> <s:text
									name="project.form.button.pdf"></s:text></a> <a
								data-toggle="tooltip" data-original-title="Previous Ticket"
								href="viewPreviousDealerDetailInfo.action?command=<s:property value='customerId' />"
								type="button" class="btn btn-default btnheight"><i
								class="fa fa-chevron-left fontawesomeht"></i></a> <a
								data-toggle="tooltip" data-original-title="Next Ticket"
								href="viewNextDealerDetailInfo.action?command=<s:property value='customerId' />"
								class="btn btn-default btnheight"><i
								class="fa fa-chevron-right fontawesomeht"></i></a> <a
								data-toggle="tooltip" data-original-title="Close"
								href="viewDealerDashboard" class="btn btn-danger btnheight"><i
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
													name="view.Ticket.infobar" /> --%>You can see Dealer Details here</i>
										</div>
									</div>
								</s:else>
							</p>
						</div>
						<div style="padding-left: 15px; padding-right: 15px;">
							<s:form class="form-horizontal">
								<s:iterator value="dealerVO">
									<div class="row">
										<div
											class="col-lg-12 col-md-12 col-sm-12 col-xs-12 viewinnertitle">
											<h5>
												<%-- <s:text name="add.new.ticket.title" /> --%>Dealer Information
											</h5>
										</div>
									</div>
									<hr>
									<div class="row">
										<div class="col-md-12 col-sm-12 col-xs-12"
											id="view_lable_value">
											<div class="col-md-2 col-sm-12 col-xs-12">
												<label for="text1" class="control-label" id="viewlable">
													<%-- <s:text name="add.new.ticket.ticketId"></s:text> --%>Dealer Id
												</label>
											</div>
											<div class="col-md-10 col-sm-12 col-xs-12 control-label">
												<s:property value="customerId" />
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12 col-sm-12 col-xs-12"
											id="view_lable_value2">
											<div class="col-md-2 col-sm-12 col-xs-12">
												<label for="text1" class="control-label" id="viewlable">Full Name
													<%-- <s:text name="add.new.ticket.category"></s:text> --%>
												</label>
											</div>
											<div class="col-md-10 col-sm-12 col-xs-12 control-label">
												<s:property value="fullName" />
											</div>
										</div>
									</div>
									<%-- <div class="row">
										<div class="col-md-12 col-sm-12 col-xs-12"
											id="view_lable_value">
											<div class="col-md-2 col-sm-12 col-xs-12">
												<label for="text1" class="control-label" id="viewlable">
													<s:text name="add.new.ticket.contactName"></s:text>DOB
												</label>
											</div>
											<div class="col-md-10 col-sm-12 col-xs-12 control-label">
												 <s:property value="dob" /> 
											</div>
										</div>
									</div> --%>
									
									<div class="row">
										<div class="col-md-12 col-sm-12 col-xs-12"
											id="view_lable_value">
											<div class="col-md-2 col-sm-12 col-xs-12">
												<label for="text1" class="control-label" id="viewlable">
													<%-- <s:text name="add.new.ticket.subject"></s:text> --%>Contact Person
												</label>
											</div>
											<div class="col-md-10 col-sm-12 col-xs-12 control-label">
												<s:property value="contactPerson" />
											</div>
										</div>
									</div>
									
									
									<div class="row">
										<div class="col-md-12 col-sm-12 col-xs-12"
											id="view_lable_value2">
											<div class="col-md-2 col-sm-12 col-xs-12">
												<label for="text1" class="control-label" id="viewlable">
													<%-- <s:text name="add.new.ticket.subject"></s:text> --%>Phone number
												</label>
											</div>
											<div class="col-md-10 col-sm-12 col-xs-12 control-label">
												<s:property value="phoneNo" />
											</div>
										</div>
									</div>
									
									<div class="row">
										<div class="col-md-12 col-sm-12 col-xs-12"
											id="view_lable_value">
											<div class="col-md-2 col-sm-12 col-xs-12">
												<label for="text1" class="control-label" id="viewlable">
													<%-- <s:text name="add.new.ticket.subject"></s:text> --%>Phone number 2
												</label>
											</div>
											<div class="col-md-10 col-sm-12 col-xs-12 control-label">
												<s:property value="phoneNo2" />
											</div>
										</div>
									</div>
									
									<div class="row">
										<div class="col-md-12  col-sm-12 col-xs-12"
											id="view_lable_value2">
											<div class="col-md-2 col-sm-12 col-xs-12">
												<label for="text1" class="control-label" id="viewlable">
													<%-- <s:text name="add.new.ticket.status" /> --%>Mobile Number
												</label>
											</div>
											<div class="col-md-10 col-sm-12 col-xs-12 control-label">
												<s:property value="mobileNo" />
											</div>
										</div>
									</div>
									
									<div class="row">
										<div class="col-md-12  col-sm-12 col-xs-12"
											id="view_lable_value">
											<div class="col-md-2 col-sm-12 col-xs-12">
												<label for="text1" class="control-label" id="viewlable">
													<%-- <s:text name="add.new.ticket.status" /> --%>Mobile Number2
												</label>
											</div>
											<div class="col-md-10 col-sm-12 col-xs-12 control-label">
												<s:property value="mobileNo2" />
											</div>
										</div>
									</div>
									
									
									<div class="row">
										<div class="col-md-12  col-sm-12 col-xs-12"
											id="view_lable_value2">
											<div class="col-md-2 col-sm-12 col-xs-12">
												<label for="text1" class="control-label" id="viewlable">
												<%-- <s:text
														name="add.new.ticket.priority"></s:text> --%>E-mail Id</label>
											</div>
											<div class="col-md-10 col-sm-12 col-xs-12 control-label">
												<s:property value="peimaryMailId" />
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12  col-sm-12 col-xs-12"
											id="view_lable_value">
											<div class="col-md-2 col-sm-12 col-xs-12">
												<label for="text1" class="control-label" id="viewlable"><%-- <s:text
														name="add.new.ticket.channel"></s:text> --%>Alternative E-mail Id</label>
											</div>
											<div class="col-md-10 col-sm-12 col-xs-12 control-label">
												<s:property value="alternativeMail" />

											</div>
										</div>
									</div>
									
									<div class="row">
										<div class="col-md-12  col-sm-12 col-xs-12"
											id="view_lable_value2">
											<div class="col-md-2 col-sm-12 col-xs-12">
												<label for="text1" class="control-label" id="viewlable"><%-- <s:text
														name="add.new.ticket.description" /> --%>Creation Date</label>
											</div>
											<div class="col-md-10 col-sm-12 col-xs-12 control-label">
												<s:property value="creationDate" />

											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12 col-sm-12 col-xs-12"
											id="view_lable_value">
											<div class="col-md-2 col-sm-12 col-xs-12">
												<label for="text1" class="control-label" id="viewlable">
													<%-- <s:text name="add.new.ticket.productName"></s:text> --%>Address Line 1
												</label>
											</div>
											<div class="col-md-10 col-sm-12 col-xs-12 control-label">
												<s:property value="address1" />
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12 col-sm-12 col-xs-12"
											id="view_lable_value2">
											<div class="col-md-2 col-sm-12 col-xs-12">
												<label for="text1" class="control-label " id="viewlable">
													<%-- <s:text name="add.new.ticket.ticketOwner"></s:text> --%>Address Line 1
												</label>
											</div>
											<div class="col-md-10 col-sm-12 col-xs-12 control-label">
												<s:property value="address2" />
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12  col-sm-12 col-xs-12"
											id="view_lable_value">
											<div class="col-md-2 col-sm-12 col-xs-12">
												<label for="text1" class="control-label" id="viewlable"><%-- <s:text
														name="Attachment File" /> --%>Work Location</label>
											</div>
											<div class="col-md-10 col-sm-12 col-xs-12 control-label">
												<s:property value="workLocation" />
											</div>
										</div>
										</div>
									
									<div class="row">
										<div class="col-md-12 col-sm-12 col-xs-12"
											id="view_lable_value2">
											<div class="col-md-2 col-sm-12 col-xs-12">
												<label for="text1" class="control-label" id="viewlable">
													<%-- <s:text name="add.new.ticket.phoneNo"></s:text> --%>City 
												</label>
											</div>
											<div class="col-md-10 col-sm-12 col-xs-12 control-label">
												<%-- <s:property value="phoneIsd" />
												<s:property value="phoneStd" /> --%>
												<s:property value="city" />
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12 col-sm-12 col-xs-12"
											id="view_lable_value">
											<div class="col-md-2 col-sm-12 col-xs-12">
												<label for="text1" class="control-label" id="viewlable">
													<%-- <s:text name="add.new.ticket.email"></s:text> --%>State
												</label>
											</div>
											<div class="col-md-10 col-sm-12 col-xs-12 control-label">
												<s:property value="state" />
											</div>
										</div>
									</div>
									
									<div class="row">
										<div class="col-md-12 col-sm-12 col-xs-12"
											id="view_lable_value2">
											<div class="col-md-2 col-sm-12 col-xs-12">
												<label for="text1" class="control-label" id="viewlable">
													<%-- <s:text name="add.new.ticket.email"></s:text> --%>Country
												</label>
											</div>
											<div class="col-md-10 col-sm-12 col-xs-12 control-label">
												<s:property value="country" />
											</div>
										</div>
									</div>
								
									<div class="row">
										<div class="col-md-12 col-sm-12 col-xs-12"
											id="view_lable_value">
											<div class="col-md-2 col-sm-12 col-xs-12">
												<label for="text1" class="control-label" id="viewlable">
													<%-- <s:text name="add.new.ticket.email"></s:text> --%>Home Website
												</label>
											</div>
											<div class="col-md-10 col-sm-12 col-xs-12 control-label">
												<s:property value="homewebsite" />
											</div>
										</div>
									</div>
									
									<div class="row">
										<div class="col-md-12  col-sm-12 col-xs-12"
											id="view_lable_value2">
											<div class="col-md-2 col-sm-12 col-xs-12">
												<label for="text1" class="control-label" id="viewlable">
												<%-- <s:text name="add.new.ticket.dueDate" /> --%>Pin Code</label>
											</div>
											<div class="col-md-10 col-sm-12 col-xs-12 control-label">
												<s:property value="pinCode" />
											</div>
										</div>
									</div>
									
									<div class="row">
										<div class="col-md-12  col-sm-12 col-xs-12"
											id="view_lable_value">
											<div class="col-md-2 col-sm-12 col-xs-12">
												<label for="text1" class="control-label" id="viewlable">
												<%-- <s:text name="add.new.ticket.dueDate" /> --%>Profile Description</label>
											</div>
											<div class="col-md-10 col-sm-12 col-xs-12 control-label">
												<s:property value="profileDescription" />
											</div>
										</div>
									</div>
									
									
									<%-- <div class="row">
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
									</div> --%>
									
										<hr style="margin-top: 20px">
										<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"
											align="center">
											<a href="viewDealerDashboard" data-toggle="tooltip"
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
</body>
</html>