<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Sales</title>
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
									name="ticket.Dashboard.navbar"></s:text> --%>Invoice</a></li>
						<li><a href="salesDashboard"><%-- <s:text
									name="ticket.Dashboard.panel.heading"></s:text> --%>Invoice Dashboard</a></li>
						<li><a
							href="viewEstimateAction?command=<s:property value='id'/>"
							data-placement="bottom"> <%-- <s:text
									name="view.Ticket.panel.heading"></s:text> --%>View Sales
						</a></li>
					</ol>
					<header> <a class="icons" href="salesDashboard"
						data-toggle="tooltip"
						data-original-title="Back To Estimate DashBoard"
						style="color: black;"> <i class="fa fa-th-large"></i>
					</a>
					<h5>
						<%-- <s:text name="view.Ticket.panel.heading" /> --%>View Invoice Sales Details
					</h5>
					<div class="pull-right">
						<div class="btn-group">
							<a class="btn btn-default btnheight" data-toggle="tooltip"
								data-original-title="Help"><i class="fa fa-question"></i> <s:text
									name="project.form.button.help"></s:text></a> <a
								class="btn btn-primary btnheight" data-toggle="tooltip"
								data-original-title="Print" href="generateSpecificSalesBill"><i class="fa fa-print"></i> <s:text
									name="project.form.button.print"></s:text></a> <a
								data-toggle="tooltip" data-original-title="PDF Report"
								href="salesPrintPDF.action?command=<s:property value='salesId' />"
								class="btn btn-success btnheight"><i
								class="fa fa-file-pdf-o "></i> <s:text
									name="project.form.button.pdf"></s:text></a> <a
								data-toggle="tooltip" data-original-title="Previous Ticket"
								href="viewPreviousSalesInfo.action?command=<s:property value='salesId' />"
								type="button" class="btn btn-default btnheight"><i
								class="fa fa-chevron-left fontawesomeht"></i></a> <a
								data-toggle="tooltip" data-original-title="Next Ticket"
								href="viewNextSalesInfo.action?command=<s:property value='salesId' />"
								class="btn btn-default btnheight"><i
								class="fa fa-chevron-right fontawesomeht"></i></a> <a
								data-toggle="tooltip" data-original-title="Close"
								href="ticketDashboard.action" class="btn btn-danger btnheight"><i
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
								<s:iterator value="InvoiceSaleVO" >
									<div class="row">
										<div
											class="col-lg-12 col-md-12 col-sm-12 col-xs-12 viewinnertitle">
											<h5>
												<%-- <s:text name="add.new.ticket.title" /> --%>Sales Information
											</h5>
										</div>
									</div>
									<hr>
									<div class="row">
										<div class="col-md-12 col-sm-12 col-xs-12"
											id="view_lable_value">
											<div class="col-md-2 col-sm-12 col-xs-12">
												<label for="text1" class="control-label" id="viewlable">
													<%-- <s:text name="add.new.ticket.ticketId"></s:text> --%>Sales Id
												</label>
											</div>
											<div class="col-md-10 col-sm-12 col-xs-12 control-label">
												<s:property value="salesId" />
											</div>
										</div>
									</div>
									
									<div class="row">
										<div class="col-md-12 col-sm-12 col-xs-12"
											id="view_lable_value">
											<div class="col-md-2 col-sm-12 col-xs-12">
												<label for="text1" class="control-label" id="viewlable">
													<%-- <s:text name="add.new.ticket.contactName"></s:text> --%>Sales Date
												</label>
											</div>
											<div class="col-md-10 col-sm-12 col-xs-12 control-label">
												 <s:property value="salesDate" /> 
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12 col-sm-12 col-xs-12"
											id="view_lable_value2">
											<div class="col-md-2 col-sm-12 col-xs-12">
												<label for="text1" class="control-label" id="viewlable">
													<%-- <s:text name="add.new.ticket.productName"></s:text> --%>Customer Type
												</label>
											</div>
											<div class="col-md-10 col-sm-12 col-xs-12 control-label">
												<s:property value="customerType" />
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12 col-sm-12 col-xs-12"
											id="view_lable_value">
											<div class="col-md-2 col-sm-12 col-xs-12">
												<label for="text1" class="control-label " id="viewlable">
													<%-- <s:text name="add.new.ticket.ticketOwner"></s:text> --%>Customer Id
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
												<label for="text1" class="control-label" id="viewlable">
													<%-- <s:text name="add.new.ticket.phoneNo"></s:text> --%>Customer Name 
												</label>
											</div>
											<div class="col-md-10 col-sm-12 col-xs-12 control-label">
												<%-- <s:property value="phoneIsd" />
												<s:property value="phoneStd" /> --%>
												<s:property value="fullName" />
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12 col-sm-12 col-xs-12"
											id="view_lable_value">
											<div class="col-md-2 col-sm-12 col-xs-12">
												<label for="text1" class="control-label" id="viewlable">
													<%-- <s:text name="add.new.ticket.email"></s:text> --%>Customer Address
												</label>
											</div>
											<div class="col-md-10 col-sm-12 col-xs-12 control-label">
												<s:property value="address" />
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12 col-sm-12 col-xs-12"
											id="view_lable_value2">
											<div class="col-md-2 col-sm-12 col-xs-12">
												<label for="text1" class="control-label" id="viewlable">
													<%-- <s:text name="add.new.ticket.subject"></s:text> --%>Contact No
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
												<label for="text1" class="control-label" id="viewlable">Total
													<%-- <s:text name="add.new.ticket.category"></s:text> --%>
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
												<label for="text1" class="control-label" id="viewlable">Subtotal
													<%-- <s:text name="add.new.ticket.category"></s:text> --%>
												</label>
											</div>
											<div class="col-md-10 col-sm-12 col-xs-12 control-label">
												<s:property value="subTotal" />
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12 col-sm-12 col-xs-12"
											id="view_lable_value">
											<div class="col-md-2 col-sm-12 col-xs-12">
												<label for="text1" class="control-label" id="viewlable">Discount
													<%-- <s:text name="add.new.ticket.category"></s:text> --%>
												</label>
											</div>
											<div class="col-md-10 col-sm-12 col-xs-12 control-label">
												<s:property value="discount" />
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12 col-sm-12 col-xs-12"
											id="view_lable_value2">
											<div class="col-md-2 col-sm-12 col-xs-12">
												<label for="text1" class="control-label" id="viewlable">Tax (Rs.)
													<%-- <s:text name="add.new.ticket.category"></s:text> --%>
												</label>
											</div>
											<div class="col-md-10 col-sm-12 col-xs-12 control-label">
												<s:property value="totalTax" />
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12 col-sm-12 col-xs-12"
											id="view_lable_value">
											<div class="col-md-2 col-sm-12 col-xs-12">
												<label for="text1" class="control-label" id="viewlable">Payment Status
													<%-- <s:text name="add.new.ticket.category"></s:text> --%>
												</label>
											</div>
											<div class="col-md-10 col-sm-12 col-xs-12 control-label">
												<s:property value="paymentAnswer" />
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12 col-sm-12 col-xs-12"
											id="view_lable_value2">
											<div class="col-md-2 col-sm-12 col-xs-12">
												<label for="text1" class="control-label" id="viewlable">Payment Mode
													<%-- <s:text name="add.new.ticket.category"></s:text> --%>
												</label>
											</div>
											<div class="col-md-10 col-sm-12 col-xs-12 control-label">
												<s:property value="paymentMode" />
											</div>
										</div>
									</div>
									
									<div class="row">
										<div class="col-md-12 col-sm-12 col-xs-12"
											id="view_lable_value">
											<div class="col-md-2 col-sm-12 col-xs-12">
												<label for="text1" class="control-label" id="viewlable">Payment
													<%-- <s:text name="add.new.ticket.category"></s:text> --%>
												</label>
											</div>
											<div class="col-md-10 col-sm-12 col-xs-12 control-label">
												<s:property value="payment" />
											</div>
										</div>
									</div>
									</s:iterator>
<!--//////////////////////////////// ///////////////////////////////////////////////////////////////////////// -->
<s:iterator value="invoiceSaleItemsList">
<hr style="margin-top: 20px">
									<div class="row">
										<div class="col-md-12  col-sm-12 col-xs-12"
											id="view_lable_value">
											<div class="col-md-2 col-sm-12 col-xs-12">
												<label for="text1" class="control-label" id="viewlable">
													<%-- <s:text name="add.new.ticket.status" /> --%>Product Name
												</label>
											</div>
											<div class="col-md-10 col-sm-12 col-xs-12 control-label">
												<s:property value="itemId" />
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12  col-sm-12 col-xs-12"
											id="view_lable_value2">
											<div class="col-md-2 col-sm-12 col-xs-12">
												<label for="text1" class="control-label" id="viewlable">
												<%-- <s:text name="add.new.ticket.dueDate" /> --%>Product Discription</label>
											</div>
											<div class="col-md-10 col-sm-12 col-xs-12 control-label">
												<s:property value="itemDescription" />
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12  col-sm-12 col-xs-12"
											id="view_lable_value">
											<div class="col-md-2 col-sm-12 col-xs-12">
												<label for="text1" class="control-label" id="viewlable">
												<%-- <s:text
														name="add.new.ticket.priority"></s:text> --%>Price</label>
											</div>
											<div class="col-md-10 col-sm-12 col-xs-12 control-label">
												<s:property value="itemPrice" />
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12  col-sm-12 col-xs-12"
											id="view_lable_value2">
											<div class="col-md-2 col-sm-12 col-xs-12">
												<label for="text1" class="control-label" id="viewlable"><%-- <s:text
														name="add.new.ticket.channel"></s:text> --%>Quantity</label>
											</div>
											<div class="col-md-10 col-sm-12 col-xs-12 control-label">
												<s:property value="itemQuantity" />

											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12  col-sm-12 col-xs-12"
											id="view_lable_value">
											<div class="col-md-2 col-sm-12 col-xs-12">
												<label for="text1" class="control-label" id="viewlable"><%-- <s:text
														name="add.new.ticket.description" /> --%>GST(%)</label>
											</div>
											<div class="col-md-10 col-sm-12 col-xs-12 control-label">
												<s:property value="itemTax" />

											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12  col-sm-12 col-xs-12"
											id="view_lable_value2">
											<div class="col-md-2 col-sm-12 col-xs-12">
												<label for="text1" class="control-label" id="viewlable"><%-- <s:text
														name="Attachment File" /> --%>Total</label>
											</div>
											<div class="col-md-10 col-sm-12 col-xs-12 control-label">
												<s:property value="amount" />
											</div>
										</div>

										
									</div>
								</s:iterator>
								<hr style="margin-top: 20px">
										<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"
											align="center">
											<a href=invoiceDashbord.action data-toggle="tooltip"
												data-original-title="Cancel"
												class="btn btn-default btnheight"><i
												class="fa fa-caret-square-o-left fontawesomeht"></i> <s:text
													name="project.form.button.cancel"></s:text></a>
										</div>
							</s:form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>