<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="/struts-jquery-tags" prefix="sj"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

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
							<li><a href=""><s:text
										name="Transport Dashboard"></s:text></a></li>
							<li><a href=""><s:text
										name="New Transport"></s:text></a></li>
						</ol>
						<s:form name="addCreatedTransportForm" action="insertTransportDetails"
							id="block-validate">
							<div class="box dark">
								<header>
								<div class="pull-left">
									<a class="icons" href=""
										data-toggle="tooltip"
										data-original-title="Back To Product DashBoard"
										style="color: black;"> <i class="fa fa-th-large"></i>
									</a>
									<h5>
										<s:text name="New Transport" />
									</h5>
								</div>
								<div class="pull-right">
									<div class="btn-group">
										<a class="btn btn-default btnheight" data-toggle="tooltip"
											data-original-title="Help"><i class="fa fa-question"></i>
											<s:text name="help"></s:text> </a>
										<button type="submit" data-toggle="tooltip"
											data-original-title="Save" class="btn btn-primary btnheight">
											<i class="fa fa-check"></i>
											<s:text name="save"></s:text>
										</button>
										<a href="" data-toggle="tooltip"
											data-original-title="Refresh"
											class="btn btn-success btnheight"><i
											class="fa fa-refresh "></i></a> <a href=""
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
													<s:text name="you can add transport here" />
												</div>
											</div>
										</s:else>
									</p>
									
										<div class="row" style="margin-top: 20px;">
										<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
											<h5 class="innertitle">
												<s:text name="Transport Information" />
											</h5>
											<hr style="margin-top: -5px">
										</div>
									</div>
									
									
									<div class="row">
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="Transport Name" />
													<div class="star">*</div>
												</div>
												
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:textfield type="text" name="transportName"
														cssClass="form-control" tabindex="1" />
													<div id='addCreatedTransportForm_transportName_errorloc'class="error_strings"></diV>
												</div>
											</div>
										</div>
									
									<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="Transport Address line1" />
												</div>
												
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<div class="row">

														<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
															<s:textfield type="text" name="transportAddressline1"
																cssClass="form-control" tabindex="2" />
															<div id='addCreatedTransportForm_transportAddressline1_errorloc'class="error_strings"></div>
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
													<s:text name="Truck number" />
													<!-- <div class="star">*</div> -->
												</div>
												
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:textfield type="text" name="truckNumber"
														cssClass="form-control" tabindex="3" />
													<div id='addCreatedTransportForm_truckNumber_errorloc'class="error_strings"></diV>
												</div>
											</div>
										</div>
									
									
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="Contact Person" />
												</div>
												
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<div class="row">

														<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
															<s:textfield type="text" name="contactPerson"
																cssClass="form-control" tabindex="4" />
															<div id='addCreatedTransportForm_contactPerson_errorloc'class="error_strings"></div>
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
													<s:text name="Alternative Contact" />
													<!-- <div class="star">*</div> -->
												</div>
												
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:textfield type="text" name="alternativeContact"
														cssClass="form-control" tabindex="5" />
													<div id='addCreatedTransportForm_alternativeContact_errorloc'class="error_strings"></diV>
												</div>
											</div>
										</div>
									



											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="Transport Address line2" />
												</div>
												
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<div class="row">

														<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
															<s:textfield type="text" name="transportAddressline2"
																cssClass="form-control" tabindex="6" />
															<div id='addCreatedTransportForm_transportAddressline2_errorloc'
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
													<s:text name="Transporter" />
													<!-- <div class="star">*</div> -->
												</div>
												
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:textfield type="text" name="transporter"
														cssClass="form-control" tabindex="7" />
													<div id='addCreatedTransportForm_transporter_errorloc'class="error_strings"></diV>
												</div>
											</div>
										</div>
									
										
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="Creation Date" />
												</div>
												
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<div class="row">

														<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
															<s:textfield type="Date" name="creationDate"
																cssClass="form-control" tabindex="8" />
															<div id='addCreatedTransportForm_creationDate_errorloc'
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
													<s:text name="Contact Number" />
													<!-- <div class="star">*</div> -->
												</div>
												
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:textfield type="text" name="contactNumber"
														cssClass="form-control" tabindex="9" />
													<div id='addCreatedTransportForm_contactNumber_errorloc'class="error_strings"></diV>
												</div>
											</div>
										</div>
											
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="City" />
												</div>
												
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<div class="row">

														<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
															<s:textfield type="text" name="city"
																cssClass="form-control" tabindex="10" />
															<!-- <div id='addCreatedTransportForm_city_errorloc'
																class="error_strings"></div> -->
																 <div id='addCreatedTransportForm_city_errorloc' class="error_strings" style="color: red; text-align: left;"></div>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
 							
										
										<hr style="margin-top: 20px">
									<div class="row">
										<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"
											align="center">
											<a href="addNewTransport" data-toggle="tooltip"
												data-original-title="Cancel"
												class="btn btn-default btnheight"><i
												class="fa fa-caret-square-o-left fontawesomeht"></i> <s:text
													name="cancel"></s:text></a> <a
												href="addNewTransport" data-toggle="tooltip"
												data-original-title="Reset"
												class="btn btn-success btnheight"><i
												class="fa fa-refresh "></i> <s:text
													name="reset"></s:text></a>
											<button type="submit" data-toggle="tooltip"
												data-original-title="Save" class="btn btn-primary btnheight">
												<i class="fa fa-check"></i>
												<s:text name="save"></s:text>
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




<script src="/outer/js/gen_validatorv4.js" type="text/javascript"></script>
	<script type="text/javascript">
		var frmvalidator = new Validator("addCreatedTransportForm");
		frmvalidator.EnableOnPageErrorDisplay();
		frmvalidator.EnableMsgsTogether();
	
		 //Validation for Transport Name.
		frmvalidator.addValidation("transportName", "req", "Enter Transport Name");
		frmvalidator.addValidation("transportName", "maxlen=100",
				" Transport Name Should Be 100 Characters");
		frmvalidator.addValidation("transportName", "minlen=1",
				" Transport Name Should Be 1 Characters");
		frmvalidator.addValidation("transportName", "alpha",
		"Enter Only Alphabetic Value ");
		
		//Validation for Transport Addressline1.
		frmvalidator.addValidation("transportAddressline1", "req", "Enter Transport Addressline1");
		frmvalidator.addValidation("transportAddressline1", "maxlen=100",
				" Transport Addressline1 Should Be 100 Characters");
		frmvalidator.addValidation("transportAddressline1", "minlen=1",
				" Transport Addressline1 Should Be 1 Characters");
		
		
		
		
		//Validation for Transport Addressline2.
		frmvalidator.addValidation("transportAddressline2", "req", "Enter Transport Addressline2");
		frmvalidator.addValidation("transportAddressline2", "maxlen=100",
				" Transport Addressline2 Should Be 100 Characters");
		frmvalidator.addValidation("transportAddressline2", "minlen=1",
				" Transport Addressline2 Should Be 1 Characters");		
		
		
		//Validation for Contact Person.
		frmvalidator.addValidation("contactPerson", "req", "Enter Contact Person");
		frmvalidator.addValidation("contactPerson", "maxlen=100",
				" Contact Person Should Be 100 Characters");
		frmvalidator.addValidation("contactPerson", "minlen=1",
				" Contact Person Should Be 1 Characters");
		frmvalidator.addValidation("contactPerson", "alpha",
		"Enter Only Alphabetic Value ");
		
		
	
		//Validation for Alternative Contact.
		frmvalidator.addValidation("alternativeContact", "req", "Enter Alternative Contact");
		frmvalidator.addValidation("alternativeContact", "maxlen=100",
				" Alternative Contact Should Be 100 Characters");
		frmvalidator.addValidation("alternativeContact", "minlen=1",
				" Alternative Contact Should Be 1 Characters");
		frmvalidator.addValidation("alternativeContact", "num",
		"Enter Only Numeric Value ");
		
		
		
		//Validation for Transporter.
		frmvalidator.addValidation("transporter", "req", "Enter Transporter");
		frmvalidator.addValidation("transporter", "maxlen=100",
				" Transporter Should Be 100 Characters");
		frmvalidator.addValidation("transporter", "minlen=1",
				" Transporter Should Be 1 Characters");
		frmvalidator.addValidation("transporter", "alpha",
		"Enter Only Alphabetic Value ");
		

		//Validation for Creation Date.
		frmvalidator.addValidation("creationDate", "req", "Enter Creation Date");
		frmvalidator.addValidation("creationDate", "maxlen=100",
				" Creation Date Should Be 100 Characters");
		frmvalidator.addValidation("creationDate", "minlen=1",
				" Creation Date Should Be 1 Characters");
	
		
		
		//Validation for Contact Number.
		frmvalidator.addValidation("contactNumber", "req", "Enter Contact Number");
		frmvalidator.addValidation("contactNumber", "maxlen=100",
				" Contact Number Should Be 100 Characters");
		frmvalidator.addValidation("contactNumber", "minlen=1",
				" Contact Number Should Be 1 Characters");
		frmvalidator.addValidation("contactNumber", "num",
		"Enter Only Numeric Value ");
		
		//validations for city Name
		frmvalidator.addValidation("city", "req", " Enter City Name");
		frmvalidator.addValidation("city", "maxlen=10",
				"Maximun Length of City Name is 15");
		frmvalidator.addValidation("city", "alpha",
		"Enter Only Alphabetic Value ");

		
		
		//Validation for Truck Number.
		frmvalidator.addValidation("truckNumber", "req", "Enter Truck Name");
		frmvalidator.addValidation("truckNumber", "maxlen=100",
				" Truck Number Should Be 100 Characters");
		frmvalidator.addValidation("truckName", "minlen=1",
				" Truck Number Should Be 1 Characters");
	
		
		
		
		
		
		
		
		
	
		
		</script>





</body>
</html>