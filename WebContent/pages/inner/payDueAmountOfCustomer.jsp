<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="/struts-jquery-tags" prefix="sj"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Pay Due Customer</title>
<script type="text/javascript">
var xmlhttp;
if (window.XMLHttpRequest) {
	xmlhttp = new XMLHttpRequest();
} else {
	xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
}
function getRegularCustomerDetails() {
	
	var regularId=document.getElementById("custId").value;
	
	
	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			var array = JSON.parse(xmlhttp.responseText);
			
			/* var	array_element1="<input type='text' style='width:124px; height:35px'  name='itemDescription'  placeholder='Description' value='"+array.product.description +"' readonly='true'/>"; */
			/* var	array_element2= "<input type='text'  Class='form-control'  name='itemPrice' id='itemPrice' value='"+array.product.productPrice +"' readonly='true' />"; */
              var	array_element1=" <input type='text' name= 'customerAddress'  value= '"+array.regularCustomer.custAddress +"'   Class ='form-control' />";
             // <s:textfield cssClass="form-control" name="customerAddress" tabindex="4"></s:textfield>
            // <s:textfield cssClass="form-control" name="customerContact" tabindex="4"></s:textfield>
            //<s:textfield cssClass="form-control" name="customerState" tabindex="4"></s:textfield>
			var	array_element2=	" <input type='text' name = 'customerContact'  value = '"+array.regularCustomer.custContact +"'  Class = 'form-control' />" ;
			var	array_element3=	" <input type='text' name = 'customerState' value = '"+array.regularCustomer.custState +"' Class = 'form-control' />" ;
	
			document.getElementById("address").innerHTML = array_element1;
	document.getElementById("contact").innerHTML = array_element2;
	document.getElementById("state").innerHTML = array_element3;
	/* takeBillNo(); */
       }
	};
	xmlhttp.open("GET", "regularCustomerDetailsForPayDueRetailer.action?custId=" +regularId, true);

	xmlhttp.send();
	}
function takeBillNo(){
var billNumber = prompt("Please enter Bill No.!!", "Bill No.");

if (billNumber != null) {
  
    alert(billNumber);
    xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			var array = JSON.parse(xmlhttp.responseText);
			
			alert("paid"+array.transaction.trToPaid+"due"+array.transaction.trToDue);
               var	array_element1=" <input type='text' name= 'totalPaid'  value= '"+array.transaction.trToPaid +"'   Class ='form-control' />";
            
			var	array_element2=	" <input type='text' name = 'totalDue'  value = '"+array.transaction.trToDue +"'  Class = 'form-control' />" ;
			var	array_element3=	" <input type='text' name = 'discription' value = '"+array.transaction.trDisc +"' Class = 'form-control' />" ;
			
			
			//<s:textfield cssClass="form-control" name="totalPaid" tabindex="5" ></s:textfield>
			//<s:textfield cssClass="form-control" name="totalDue" tabindex="6" ></s:textfield>
			//<s:textfield cssClass="form-control" name="discription" tabindex="8" ></s:textfield>
			document.getElementById("trToPaid").innerHTML = array_element1;
	document.getElementById("trToDue").innerHTML = array_element2;
	document.getElementById("trDiscription").innerHTML = array_element3; 
	
       }
	};
	xmlhttp.open("GET", "transactionDetailsForPayDueRetailer.action?billNo=" +billNumber, true);

	xmlhttp.send();

} 
}
</script>
</head>
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
							<li><a href="completeRetailerTransaction"><s:text
										name="Retailer Transaction"></s:text></a></li>
							<li class="active"><s:text name="Pay Due Retailer"></s:text></li>
							<%-- <li class="active"><s:text name="New Contact"></s:text></li> --%>
						</ol>
						<s:form name="addContactForm" cssClass="form-horizontal"
							method="post" action="addPayDueRetailerTransaction">
							<s:iterator value="retailerCustomerVO">
							<div class="box dark">
								<header>
								<div class="pull-left">
									<a class="icons" href="completeRetailerTransaction"
										data-toggle="tooltip"
										data-original-title="Back To Contacts DashBoard"
										style="color: black;"> <i class="fa fa-th-large"></i>
									</a>
									<h5>
										<s:text name="Pay Due Retailer" />
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
											data-original-title="Reset"
											class="btn btn-success btnheight"><i
											class="fa fa-refresh "></i></a> <a
											href="contactsDashboard.action" data-toggle="tooltip"
											data-original-title="Close" class="btn btn-danger btnheight"><i
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
													<s:text name="add.create.lead.information.bar" />
												</div>
											</div>
										</s:else>
									</p>
									<div class="row" style="margin-top: 20px;">
										<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
											<h5 class="innertitle">
												<s:text name="add.create.contact.contactinfo"></s:text>
											</h5>
											<hr style="margin-top: -5px">
										</div>

									</div>
<!-- kkkkkkkkkk -->
									<div class="row">
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<label class="control-label col-lg-4"> <s:text
															name="Customer Name"></s:text> <span
														class="star">*</span></label>

												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<div class="row">
														<div class="col-lg-3 col-md-3 col-sm-3 col-xs-5">
															<%-- <s:select cssClass="form-control " list="salutationList"
																name="salutation" tabindex="1">
															</s:select>
 --%>
                                                         <s:select cssClass="form-control " list="salutationList"
																name="salutation" tabindex="1">
															</s:select>
												
															<!-- <div id='addContactForm_salutation_errorloc'
																class="error_strings"></div> -->
														</div>
														<div class="col-lg-9 col-md-9 col-sm-9 col-xs-12">
															 <%-- <s:select cssClass="form-control " list="retailerList" id="custId" theme="css_xhtml" 
											headerKey="-1" headerValue="Select Customer"
																name="customerName" tabindex="1" onchange="getRegularCustomerDetails()">
															</s:select> --%>
															<s:textfield cssClass="form-control" name="fullName"
														tabindex="3" ></s:textfield>
																<%-- <select class="form-control" name="customerName" theme="css_xhtml" 
											headerKey="-1" headerValue="Select Customer" >
											<option>1</option>
											<option>2</option>
											</select> --%>
															<div id='addContactForm_contactperson_errorloc'
																class="error_strings"></div>
														</div>
													</div>

												</div>
											</div>
										</div>


										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<label class="control-label col-lg-4"> <s:text
															name="Address"></s:text>
													</label>
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12" id="address">
													<s:textfield cssClass="form-control" name="address1"
														tabindex="2" ></s:textfield>
													<!-- <div id='addContactForm_nickName_errorloc'
														class="error_strings"></div> -->
												</div>
											</div>

										</div>
									</div>




									<div class="row">
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<label class="control-label col-lg-4"> <s:text
															name="Contact"></s:text></label>
												</div>

												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12" id="contact">
													<%-- <s:select cssClass="form-control chzn-select"
														list="parentAccountList" headerKey="-1"
														headerValue="Select Account Name" name="accountName"
														tabindex="3">
													</s:select> --%>
                                                     <s:textfield cssClass="form-control" name="mobileNo"
														tabindex="3" ></s:textfield>
													<!-- <div id='addContactForm_accountName_errorloc'
														class="error_strings"></div> -->

												</div>
											</div>

										</div>
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<%-- --%>

											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<label class="control-label col-lg-4"> <s:text
															name="State Name"></s:text>
													</label>
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12" id="state">
													<s:textfield cssClass="form-control" name="state"
														tabindex="4" ></s:textfield>
													<!-- 	<div id='addContactForm_title_errorloc'
														class="error_strings"></div> -->
												</div>
											</div>
										</div>
									</div>

<s:hidden name="billNo" />
<s:hidden name="retailerId"/>

									<div class="row">
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<%--  --%>
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<label class="control-label col-lg-4"> <s:text
															name="Total Paid"></s:text> <span
														class="star">*</span></label>
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12" id="trToPaid">
													<%-- <s:select cssClass="form-control chzn-select"
														list="designationList" headerKey="1" name="designation"
														tabindex="5">

													</s:select> --%>
													<%-- <select class="form-control" name="accountTypeId" theme="css_xhtml" 
											headerKey="-1" headerValue="Select Customer" >
											<option>1</option>
											<option>2</option>
											</select>  --%>
											<s:textfield cssClass="form-control" name="totalPaid"
														tabindex="5" ></s:textfield>
													<div id='addContactForm_designation_errorloc'
														class="error_strings"></div>
												</div>
											</div>
										</div>
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<%----%>
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<label class="control-label col-lg-4"><s:text
															name="Total Due"></s:text> </label>
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12" id="trToDue">
													<%--  --%>
														<s:textfield cssClass="form-control" name="totalDue"
														tabindex="6" ></s:textfield>
													<div id='addContactForm_dob_errorloc' class="error_strings"></div>
												</div>
											</div>
										</div>
									</div>



									<div class="row">
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<label class="control-label col-lg-4"><s:text
															name="Discription" /></label>
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12" id="trDiscription">
													<s:textfield cssClass="form-control" name="discription"
														tabindex="8" ></s:textfield>
													<div id='addContactForm_dob_errorloc' class="error_strings"></div>
												</div>
											</div>
										</div>

										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<label class="control-label col-lg-4"><s:text
															name="Date" /></label>
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:textfield cssClass="form-control" name="transactionDate"
														tabindex="9" id="dp3" readonly="true"></s:textfield>
													<div id='addContactForm_dob_errorloc' class="error_strings"></div>
												</div>
											</div>
										</div>
									</div>

									<div class="row">
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<label class="control-label col-lg-4"><s:text
															name="Payment (Rs.)"></s:text></label>
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:textfield cssClass="form-control" name="payment"
														tabindex="10"></s:textfield>
													<div id='addContactForm_emailId_errorloc'
														class="error_strings"></div>
												</div>
											</div>
										</div>
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<label class="control-label col-lg-4"><s:text
															name="Payment Mode"></s:text> </label>
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<%-- <s:textfield cssClass="form-control" name="paymentMode"
														tabindex="11"></s:textfield> --%>
														<%-- <select class="form-control" name="paymentMode"  theme="css_xhtml" headerKey="0" headerValue="Select Payment Mode"
													style="width:250px; height:35px">
											<option>Cheque</option>
											<option>Cash</option>
											</select> --%>
											<s:select list="payModeList" name="paymentMode" 
													theme="css_xhtml" headerKey="-1" headerValue="Select Payment Mode"
													style="width:400px; height:25px;" />
													<div id='addContactForm_referredBy_errorloc'
														class="error_strings"></div>
												</div>
											</div>
										</div>
									</div>
									
									
		<!-- ************************************************************************************************************** -->							
									<%-- <div class="row">
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<label class="control-label col-lg-4"><s:text
															name="Department."></s:text></label>
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:textfield cssClass="form-control" name="department"
														tabindex="10"></s:textfield>
													<div id='addContactForm_emailId_errorloc'
														class="error_strings"></div>
												</div>
											</div>
										</div>
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<label class="control-label col-lg-4"><s:text
															name="Reports To"></s:text> </label>
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:select cssClass="form-control chzn-select"
														list="reportsToList" headerKey="-1"
														headerValue="Reports To" name="reportsTo" tabindex="5">

													</s:select>
													<select class="form-control" name="accountTypeId" theme="css_xhtml" 
											headerKey="-1" headerValue="Select Customer" >
											<option>1</option>
											<option>2</option>
											</select> 
													<div id='addContactForm_designation_errorloc'
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
															name="Primary Email ID"></s:text> </label>
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:textfield cssClass="form-control" name="workContEmailId"
														tabindex="30"></s:textfield>
													<div id='addContactForm_workContactEmailId_errorloc'
														class="error_strings"></div>
												</div>

											</div>
										</div>
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<label class="control-label col-lg-4"><s:text
															name="Alternate Email ID"></s:text> </label>
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:textfield cssClass="form-control"
														name="workContAlternateEmailId" tabindex="30"></s:textfield>
													<div id='addContactForm_workAlternate Email ID_errorloc'
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
															name="add.create.lead.fax" /></label>
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<div class="row">
														<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"
															style="padding-right: 0px;">
															<s:textfield cssClass="form-control"
																name="workContFaxNumIsd" tabindex="33"
																placeholder="%{getText('project.placeholder.isd')}"></s:textfield>

															<div id='addCreatedLeadForm_workContactFaxIsd_errorloc'
																class="error_strings"></div>
															<div id='addCreatedLeadForm_workContactFaxStd_errorloc'
																class="error_strings"></div>
															<div id='addCreatedLeadForm_workContactFax_errorloc'
																class="error_strings"></div>
														</div>
														<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"
															style="padding-right: 0; padding-left: 0;">
															<s:textfield cssClass="form-control"
																name="workContFaxNumStd" tabindex="34"
																placeholder="%{getText('project.placeholder.std')}"></s:textfield>

														</div>
														<div class="col-lg-5 col-md-5 col-sm-5 col-xs-5"
															style="padding-right: 0; padding-left: 0px; width: 46%">

															<s:textfield name="workContFaxNum"
																cssClass="form-control" tabindex="35"
																placeholder="%{getText('project.placeholder.faxnumber')}" />

														</div>
													</div>
												</div>
											</div>
										</div>

										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<label class="control-label col-lg-4"><s:text
															name="Work Website"></s:text> </label>
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:textfield cssClass="form-control" name="workWebsite"
														tabindex="30"></s:textfield>
													<div id='addContactForm_workWebsite_errorloc'
														class="error_strings"></div>
												</div>

											</div>
										</div>
									</div>

									<div class="row" style="margin-top: 20px;">
										<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
											<h5 class="innertitle">
												<s:text name="add.group.profile.description"></s:text>
											</h5>
											<hr style="margin-top: -5px">
										</div>
									</div>



									<div class="form-group">
										<div class="row" style="margin: 1% 2%;" id="data_grid">
											<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">

												<s:textarea name="profileDescription" id="wysihtml5"
													cssClass="form-control" rows="10" tabindex="32">

												</s:textarea>
												<div id='addContactForm_profileDescription_errorloc'
													class="error_strings"></div>

											</div>

										</div>
									</div>

									<div class="form-group">
										<div class="row">
											<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
												<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
													<div class="row">
														<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
															<label class="control-label col-lg-4"><s:text
																	name="myAccount.user.profile.profile.image"></s:text> </label>
														</div>
														<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
															<div class="fileinput fileinput-new"
																data-provides="fileinput">
																<div class="fileinput-new thumbnail"
																	style="width: 200px; height: 150px;">
																	<img data-src="holder.js/100%x100%" alt="...">
																</div>
																<div
																	class="fileinput-preview fileinput-exists thumbnail"
																	style="max-width: 200px; max-height: 150px;"></div>
																<div>
																	<span class="btn btn-default btn-file" tabindex="33"><span
																		class="fileinput-new"><s:text
																				name="project.form.button.upload"></s:text></span> <s:file
																			type="file" name="userImage" /> <span
																		class="fileinput-exists" tabindex="34"><s:text
																				name="project.form.button.change"></s:text> </span> <input
																		type="file" name="..."> </span> <a href="#"
																		class="btn btn-default fileinput-exists"
																		data-dismiss="fileinput" tabindex="35"><s:text
																			name="project.form.button.remove"></s:text></a>
																</div>
															</div>
														</div>
													</div>

												</div>
											</div>
										</div>

									</div> --%>
									<hr>

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
							</s:iterator>
							</s:form>
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
		var frmvalidator = new Validator("addContactForm");
		frmvalidator.EnableOnPageErrorDisplay();
		frmvalidator.EnableMsgsTogether();

		//validation for contact Person 
		frmvalidator.addValidation("salutation", "dontselect=8",
				"Select Salutation");

		frmvalidator.addValidation("contactperson", "maxlen=50",
				"Contact Person  Should Be 50 Characters"); 

	frmvalidator.addValidation("contactperson", "req",
				"Enter Contact Person Name");

		frmvalidator.addValidation("contactperson", "alpha",
				"Contact Person Name should be in characters");

		//Validation for Nick Name 
		frmvalidator.addValidation("nickName", "maxlen=50",
				"Nick Name Should Be 50 Characters");

		frmvalidator.addValidation("nickName", "alpha",
				"Nick Name Should Be in Characters");

		//validation for designation 
		frmvalidator.addValidation("designation", "dontselect=1",
				"Select Designation");

		//Validation for phone Number 
		frmvalidator.addValidation("phoneNumber", "numeric",
				"Phone Number Must Be in Digits");
		frmvalidator.addValidation("phoneNumber", "maxlen=10",
				"Phone Number Should Be 10 Digits");

		// validation for referred by 
		frmvalidator.addValidation("referredBy", "alpha",
				"Referred By Must Be in characters");

		frmvalidator.addValidation("referredBy", "maxlen=50",
				"Referred By Should Be 50 characters");

		/* frmvalidator.addValidation("referredBy", "req", "Enter Referred By"); */

		//validation for mobile no.1 
		frmvalidator.addValidation("mobileNo", "req", "Enter Mobile No");

		frmvalidator.addValidation("mobileNo", "maxlen=10",
				"Mobile No Should Be 10 Digits");

		frmvalidator.addValidation("mobileNo", "numeric",
				"Mobile No Must Be Digits");

		//validation for mobile no.2 
		frmvalidator.addValidation("mobileNumber", "maxlen=10",
				"Mobile No Should Be 10 Digits");

		frmvalidator.addValidation("mobileNumber", "numeric",
				"Mobile No Must Be Digits");

		//Validation for email.
		frmvalidator.addValidation("emailId", "maxlen=100",
				"Email Id Should Be 100 Digits");

		frmvalidator.addValidation("emailId", "email",
				"Please Enter valid Email Id");

		//validation for Fax number.
		frmvalidator.addValidation("fax", "numeric",
				"Fax Number Must Be Digits");

		frmvalidator.addValidation("fax", "maxlen=6",
				"Fax Number Should Be 6 Digits");

		//validation for Address Line 1.
		frmvalidator.addValidation("addressLine1", "maxlen=100",
				"Address Line 1 Should Be 100 Characters");

		frmvalidator.addValidation("addressLine1", "req",
				"Please Enter Address ");

		//validation for Address Line 2.

		frmvalidator.addValidation("addressLine2", "maxlen=100",
				"Address Line 2 Should Be 100 Characters");

		//validation for City 

		frmvalidator.addValidation("city", "maxlen=50",
				"City Should Be 50 Characters");

		frmvalidator.addValidation("city", "alpha",
				"City Should Be in Characters");

		//validation for State.

		frmvalidator.addValidation("state", "maxlen=50",
				"State Should Be 50 Characters");

		frmvalidator.addValidation("state", "alpha",
				"State Should Be in Characters");

		//validation for country.
		/* frmvalidator
				.addValidation("country", "dontselect=-1", "Please Select Country"); 

		//validation for "zipcode 
		frmvalidator.addValidation("zipcode", "maxlen=8",
				"Zipcode Should Be 8 Characters");

		frmvalidator.addValidation("zipcode", "numeric",
				"Zipcode Should Be in Numbers");

		//validation for phone 

		frmvalidator.addValidation("phone", "maxlen=10",
				"Phone Should Be 10 Digits");

		frmvalidator.addValidation("phone", "numeric",
				"Phone Should Be in Numeric");

		//validation for home mobile number 
		frmvalidator.addValidation("homeContactMobile", "req",
				"Enter Mobile Number");

		frmvalidator.addValidation("homeContactMobile", "maxlen=10",
				"Phone Should Be 10 Digits");

		frmvalidator.addValidation("homeContactMobile", "num",
				"Phone Should Be in Numeric");

		//Validation for home Contact email id 

		frmvalidator.addValidation("homeContactEmailID", "email",
				"Please Enter Valid Email-Id");

		//Validation for home Contact fax 

		frmvalidator.addValidation("homeContactFax", "num",
				"Please Enter Valid Fax Number");

		frmvalidator.addValidation("homeContactFax", "maxlen=6",
				"Fax Number Should Be 6 Digits");

		//Validation for work contact address one  
		frmvalidator.addValidation("workContactAddressOne", "req",
				"Please Enter Address ");

		frmvalidator.addValidation("workContactAddressOne", "maxlen=100",
				"Address Should Be at max 100 characters");

		//Validation for work contact address two 

		frmvalidator.addValidation("workContactAddressTwo", "maxlen=100",
				"Address Line 2 Should Be at max 100 characters");

		//Validation for work contact city 

		frmvalidator.addValidation("workContactCity", "maxlen=50",
				"City Should Be at max 100 characters");

		frmvalidator.addValidation("workContactCity", "alpha",
				"City Should Be in characters");

		//Validation for work contact state 

		frmvalidator.addValidation("workContactState", "alpha",
				"State Should Be in  characters");

		frmvalidator.addValidation("workContactState", "maxlen=50",
				"State Should Be at max 100 characters");

		//validation for work contact country 
		/* frmvalidator.addValidation("workContactCountry", "dontselect=-1",
				"Select Country"); 

		//validation for work contact ZipCode 
		frmvalidator.addValidation("workContactZipCode", "maxlen=8",
				"ZipCode Should Be 8 Characters");

		frmvalidator.addValidation("workContactZipCode", "numeric",
				"ZipCode Should Be in Digits");

		//validation for work contact phone 

		frmvalidator.addValidation("workContactPhone", "maxlen=10",
				"Phone Should Be 10 Digits");

		frmvalidator.addValidation("workContactPhone", "num",
				"Phone Should Be in Numeric");

		//validation for work contact mobile 
		frmvalidator.addValidation("workContactMobile", "req",
				"Please Enter Mobile Number");

		frmvalidator.addValidation("workContactMobile", "maxlen=10",
				"Phone Should Be 10 Digits");

		frmvalidator.addValidation("workContactMobile", "num",
				"Phone Should Be in Numeric");

		//Validation for work Contact EmailId 

		frmvalidator.addValidation("workContactEmailId", "email",
				"Please Enter Valid Email-Id");

		//Validation for work Contact fax 

		frmvalidator.addValidation("workContactFax", "num",
				"Please Enter Valid Fax Number");

		frmvalidator.addValidation("workContactFax", "maxlen=6",
				"Fax Number Should Be 6 Digits");

		//Validation for Profile Description. 
		frmvalidator.addValidation("profileDescription", "maxlen=4000",
				"Profile Description Should Be At Max 4000 Characters"); */
	</script>


</body>
</html>