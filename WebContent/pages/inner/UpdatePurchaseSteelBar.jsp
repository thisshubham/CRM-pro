<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="/struts-jquery-tags" prefix="sj"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Purchase Steelbar</title>
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
	
	var xmlhttp;
	if (window.XMLHttpRequest) {
		xmlhttp = new XMLHttpRequest();
	} else {
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	
function getDealerDetails() {
		
		var dealerId=document.getElementById("dealerId").value;
		
		
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				var array = JSON.parse(xmlhttp.responseText);
				
				/* var	array_element1="<input type='text' style='width:124px; height:35px'  name='itemDescription'  placeholder='Description' value='"+array.product.description +"' readonly='true'/>"; */
				/* var	array_element2= "<input type='text'  Class='form-control'  name='itemPrice' id='itemPrice' value='"+array.product.productPrice +"' readonly='true' />"; */
                  var	array_element1=" <input type='text' name= 'dealerAddress' placeholder= 'Address' value= '"+array.dealer.dealerAddress +"' style='width: 357px;height:30px;'  Class ='form-control' />";
				
				var	array_element2=	" <input type='text' name = 'dealerContact' placeholder = 'ContactNo' value = '"+array.dealer.dealerContact +"'  style ='width:357px;height:30px;'    Class = 'form-control' />" ;
				
		document.getElementById("address").innerHTML = array_element1;
		document.getElementById("contact").innerHTML = array_element2;
		
           }
		};
		xmlhttp.open("GET", "dealerDetailsForSteelBarPurchase.action?dealerId=" +dealerId, true);

		xmlhttp.send();
		}

function calculation(){
	
	var price= document.getElementById("priceId").value;
	var quant= document.getElementById("quantityId").value;
	var tax= document.getElementById("taxId").value;
	var halfTax= parseFloat(tax)/2;
	var discount= document.getElementById("discountId").value; 
	/* var taxp=parseFloat(tax); */
	/* float pricep=parseFloat(price); */
	var cal= 100+parseFloat(tax);
	var caldev=parseFloat(cal)/100;
	/* alert("cal"+cal+" "+tax+" "+price+" "+caldev+" "+parseFloat(price)); */
	var redDis=100-parseFloat(discount);
	var finalAnswer= parseFloat(price) * parseFloat(caldev) * parseFloat(quant);
	var calDis1=parseFloat(redDis)/100;
	var calDis=parseFloat(finalAnswer) * parseFloat(calDis1);
	/* var finalAnswerp=finalAnswer.toString(); */
	var difference=parseFloat(finalAnswer)-parseFloat(price);
	var half=parseFloat(difference)/2;
	/* alert("finalAnswer"+" "+finalAnswer+"cal"+cal+" "+tax+" "+price+" "+caldev+" "+calDis+" "+half); */
	
	document.getElementById("sgstId").innerHTML ="<input type='text' value='"+halfTax+"' name='sgst' class='form-control'  readonly='true' />";
	document.getElementById("cgstId").innerHTML ="<input type='text' value='"+halfTax+"' name='cgst' class='form-control'  readonly='true' />";
	quantityId
	document.getElementById("cgstAmountId").innerHTML ="<input type='text' value='"+half+"' name='cgstAmount' class='form-control'  readonly='true' />";
	document.getElementById("sgstAmountId").innerHTML ="<input type='text' value='"+half+"' name='sgstAmount' class='form-control'  readonly='true' />";
	 document.getElementById("amountIdDiv").innerHTML ="<input type='text' value='"+finalAnswer+"' name='netAmount' class='form-control'  id='amountId' />";
	//document.getElementById("amountId").innerHTML ="<input type='text' value='"+calDis+"' name='netAmount' class='form-control'  readonly='true' />";
	
}	

function calculateDiscountAmount(){
	var amount= document.getElementById("amountId").value;
	var discount= document.getElementById("discountId").value; 
	var redDis=100-parseFloat(discount);
	/* alert("dissssss"+redDis); */
	var calDisc=parseFloat(redDis)/100;
	/* alert("dissssss"+calDisc); */
	var calDis=parseFloat(amount) * parseFloat(calDisc);
	/* alert("caldis"+calDis); */
	document.getElementById("amountIdDiv").innerHTML ="<input type='text' value='"+calDis+"' name='netAmount' class='form-control'  id='amountId' />";
}	
</script>
</head>
<body>
<div id="content" >
		<div class="outer">
			<div class="inner bg-light lter">

				<!--BEGIN INPUT TEXT FIELDS-->
				<div class="row">
					<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
						<ol class="breadcrumb" style="margin-top: 10px;">
							<li><a href="omiInnerDashboard.action"><i
									class="fa fa-home"></i></a></li>
							<li><a href=purchaseDashboard.action"><s:text
										name="add.new.purchase.purchase.dashboard"></s:text></a></li>
							<li><a href="addNewProduct.action"><s:text
										name="Add Item"></s:text></a></li>
						</ol>
						<s:form name="addCreatedProductForm" action="updatePurchaseSteelbarDetail"
							id="block-validate">
							<div class="box dark">
								<header>
								<div class="pull-left">
									<a class="icons" href="purchaseDashboard.action"
										data-toggle="tooltip"
										data-original-title="Back To Purchase DashBoard"
										style="color: black;"> <i class="fa fa-th-large"></i>
									</a>
									<h5>
										<s:text name="add.new.purchase.new.purchase" />
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
										<a href="addCreatedProduct.action" data-toggle="tooltip"
											data-original-title="Refresh"
											class="btn btn-success btnheight"><i
											class="fa fa-refresh "></i></a> <a
											href="purchaseDashboard.action" data-toggle="tooltip"
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
													<s:text name="add.new.purchase.information.bar" />
												</div>
											</div>
										</s:else>
									</p>



									<div class="row" style="margin-top: 20px;">
										<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
											<h5 class="innertitle">
												<s:text name="add.new.purchase.product.information" />
											</h5>
											<hr style="margin-top: -5px">
										</div>
									</div>


																		<div class="row">
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
											<s:text name="Invoice No" />
													<div class="star">*</div>
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:textfield type="text" name="invoiceNo"
														cssClass="form-control" tabindex="1" />
													<div id='addCreatedProductForm_invoiceNo_errorloc'
														class="error_strings"></diV>
												</div>
											</div>
										</div>
 


<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="Dealer Name" />
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<div class="row">

														<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
															<%-- <s:textfield type="text" name="dealerName"
																cssClass="form-control" tabindex="2" /> --%>
																<%-- <select class="form-control" name="itemTax"  
													theme="css_xhtml" headerKey="0" headerValue="Select Tax"
													style="width:120px; height:30px" tabindex="2" id= "custId">
											<option>1</option>
											<option>2</option>
											</select> --%>
											
											 <s:select list="dealerList" name="dealerName" id="dealerId"
													theme="css_xhtml" headerKey="0" headerValue="Select Dealer Name"
													style="width:357px; height:35px;"
													onchange="getDealerDetails()" />   
															<div id='addCreatedProductForm_orderType_errorloc'
																class="error_strings"></div>
														</div>
													</div>
												</div>
											</div>
										</div>
<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
												<s:text name="Dealer Contact" />
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<div class="row">

														<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" id="contact">
															<s:textfield type="text" name="dealerContact"
																cssClass="form-control" tabindex="2"/>
															<div id='addCreatedProductForm_dealerContact_errorloc'
																class="error_strings"></div>
														</div>
													</div>
												</div>
											</div>
										</div>

	 <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
												<s:text name="Dealer Address" />
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<div class="row">

														<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" id="address">
															<s:textfield type="text" name="dealerAddress"
																cssClass="form-control" tabindex="2"/>
															<div id='addCreatedProductForm_dealerAddress_errorloc'
																class="error_strings"></div>
														</div>
													</div>
												</div>
											</div>
										</div>




					<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="Steel Bars Company" />
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<div class="row">

														<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
															<s:textfield type="text" name="companyName"
																cssClass="form-control" tabindex="2" />
															<div id='addCreatedProductFormrefrenceNo_errorloc'
																class="error_strings"></div>
														</div>
													</div>
												</div>
											</div>
										</div>


<s:hidden name="transactionId" />
<s:hidden name="totalPaid" />
<s:hidden name="totalDue" />
<s:hidden name="due" />
<s:hidden name="paid" />
<s:hidden name="total" />
<s:hidden name="transactionDate" />
<s:hidden name="transactionBillNo" />



										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="add.new.purchase.purchase.order" />
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<div class="row">

														<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
															<s:textfield type="text" name="orderNo"
																cssClass="form-control" tabindex="2" />
															<div id='addCreatedProductForm_orderNo_errorloc'
																class="error_strings"></div>
														</div>
													</div>
												</div>
											</div>
										</div>

										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="Delivery Place" />
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<div class="row">

														<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
															<s:textfield type="text" name="deliveryPlace"
																cssClass="form-control" tabindex="2" />
															<div id='addCreatedProductForm_deliveryNo_errorloc'
																class="error_strings"></div>
														</div>
													</div>
												</div>
											</div>
										</div>

										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="add.new.purchase.supply" />
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<div class="row">

														<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
															<s:textfield type="text" name="placeOfSupply"
																cssClass="form-control" tabindex="2" />
															<div id='addCreatedProductForm_placeOfSupply_errorloc'
																class="error_strings"></div>
														</div>
													</div>
												</div>
											</div>
										</div>

										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="add.new.purchase.sales.start.district" />
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<div class="row">

														<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
															<s:textfield type="text" name="district"
																cssClass="form-control" tabindex="2" />
															<div id='addCreatedProductForm_district_errorloc'
																class="error_strings"></div>
														</div>
													</div>
												</div>
											</div>
										</div>

										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="add.new.purchase.sales.end.material" />
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<div class="row">

														<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
															<s:textfield type="text" name="materialCode"
																cssClass="form-control" tabindex="2" />
															<div id='addCreatedProductForm_materialCod_errorloc'
																class="error_strings"></div>
														</div>
													</div>
												</div>
											</div>
										</div>

										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="add.new.purchase.sales.end.hsn" />
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<div class="row">

														<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
															<s:textfield type="text" name="hsnCode"
																cssClass="form-control" tabindex="2" />
															<div id='addCreatedProductForm_hsnCode_errorloc'
																class="error_strings"></div>
														</div>
													</div>
												</div>
											</div>
										</div>

										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="add.new.purchase.sales.end.quantity" />
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<div class="row">

														<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
															<s:textfield type="text" name="quantity"
																cssClass="form-control" tabindex="2" id="quantityId"/>
															<div id='addCreatedProductForm_quantity_errorloc'
																class="error_strings"></div>
														</div>
													</div>
												</div>
											</div>
										</div>

										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="add.new.purchase.sales.end.transport" />
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<div class="row">

														<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
															<s:textfield type="text" name="modeOfTtansport"
																cssClass="form-control" tabindex="2" />
															<div id='addCreatedProductForm_modeOfTtansport_errorloc'
																class="error_strings"></div>
														</div>
													</div>
												</div>
											</div>
										</div>

										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="add.new.purchase.sales.end.transporter" />
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<div class="row">

														<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
															<s:textfield type="text" name="transporter"
																cssClass="form-control" tabindex="2" />
															<div
																id='addCreatedProductForm_transporter_errorloc'
																class="error_strings"></div>
														</div>
													</div>
												</div>
											</div>
										</div>

								<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="Steel Bars Type" />
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<div class="row">

														<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
															<s:select cssClass="form-control chzn-select"
														list="typeList" name="inconterm" headerKey="1"
														tabindex="15">
													</s:select>
															<div id='addCreatedProductForm_inconterm_errorloc'
																class="error_strings"></div>
														</div>
													</div>
												</div>
											</div>
										</div> 
								
								
								
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="add.new.purchase.sales.end.truck" />
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<div class="row">

														<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
															<s:textfield type="text" name="truckNo"
																cssClass="form-control" tabindex="2" />
															<div id='addCreatedProductForm_truckNo_errorloc'
																class="error_strings"></div>
														</div>
													</div>
												</div>
											</div>
										</div>

								

										
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="add.new.purchase.sales.end.week" />
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<div class="row">

														<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
															<s:textfield type="text" name="weekNo"
																cssClass="form-control" tabindex="2" />
															<div id='addCreatedProductForm_weekNo_errorloc'
																class="error_strings"></div>
														</div>
													</div>
												</div>
											</div>
										</div>


										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="add.new.purchase.sales.end.invoice.date" />
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:textfield type="text" name="invoiceDate"
														class="form-control" id="dp3" cssClass="form-control"
														tabindex="14" readonly="true" />
													<div id='addCreatedLeadForm_invoiceDate_errorloc'
														class="error_strings"></div>
												</div>
											</div>
										</div>

									
									


									<div class="row" style="margin-top: 20px;">
										<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
											<h5 class="innertitle">
												<s:text name="add.new.product.pricing.information" />
											</h5>
											<hr style="margin-top: -5px">
										</div>

									</div>


									<div class="row">

										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="add.new.purchase.sales.end.unit.price" />
													&nbsp; (&nbsp;<span class="fa fa-rupee "></span>&nbsp;)
													<div class="star">*</div>
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<div class="input-group">
														<s:textfield  name="unitPrice" 
															cssClass="form-control" tabindex="17"  id="priceId" onchange="calculation()"/>


														<span class="input-group-btn"> <a type="button"
															class="btn btn-metis-5 btn-line" type="button"
															tabindex="18" data-toggle="modal" style="height: 34px"
															data-target="#calculater"> <i
																class="fa fa-calculator" data-toggle="tooltip"
																data-original-title="Calculator"></i>
														</a>
														</span>

													</div>
													<div id='addCreatedProductForm_unitPrice_errorloc'
														class="error_strings"></div>
												</div>
											</div>
										</div>
										
										
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="GST" />
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<div class="row">

														<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
															<s:textfield name="gst" 
																cssClass="form-control" tabindex="18"  id="taxId" onchange="calculation()"/>
															<div id='addCreatedProductForm_cgst_errorloc'
																class="error_strings"></div>
														</div>
													</div>
												</div>
											</div>
										</div>

										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="CGST" />
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<div class="row">

														<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" id="cgstId">
															<s:textfield type="text" name="cgst"
																cssClass="form-control" tabindex="19"  onchange="calculation()"/> <!-- value='{{gtax/2}}' -->
															<div id='addCreatedProductForm_weekNo_errorloc'
																class="error_strings"></div>
														</div>
													</div>
												</div>
											</div>
										</div>
										
										
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="SGST" />
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<div class="row">

														<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" id="sgstId">
															<s:textfield type="text" name="sgst"
																cssClass="form-control" tabindex="20" onchange="calculation()"/>
															<div id='addCreatedProductForm_weekNo_errorloc'
																class="error_strings"></div>
														</div>
													</div>
												</div>
											</div>
										</div>
										
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="CGST Amount" />
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<div class="row">

														<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" id="cgstAmountId">
															<s:textfield type="text" name="cgstAmount"
																cssClass="form-control" tabindex="21" onchange="calculation()"/>
															<div id='addCreatedProductForm_weekNo_errorloc'
																class="error_strings"></div>
														</div>
													</div>
												</div>
											</div>
										</div>
										
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="SGST Amount" />
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<div class="row">

														<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" id="sgstAmountId">
															<s:textfield type="text" name="sgstAmount"
																cssClass="form-control" tabindex="22" onchange="calculation()"/>
															<div id='addCreatedProductForm_weekNo_errorloc'
																class="error_strings"></div>
														</div>
													</div>
												</div>
											</div>
										</div>
										
										
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="Discount(%)" />
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<div class="row">

														<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" >
															<s:textfield type="text" name="discount" id="discountId"
																cssClass="form-control" tabindex="22" onchange="calculateDiscountAmount()"/>
															<div id='addCreatedProductForm_weekNo_errorloc'
																class="error_strings"></div>
														</div>
													</div>
												</div>
											</div>
										</div>
										
										
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="Grand Amount" />
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<div class="row">

														<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" id="amountIdDiv">
															<s:textfield  name="netAmount"
																cssClass="form-control" tabindex="22"  id="amountId"/><!--  value='{{uprice }}' -->
															<div id='addCreatedProductForm_weekNo_errorloc'
																class="error_strings"></div>
														</div>
													</div>
												</div>
											</div>
										</div>
										
										
										<%-- <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="Net Total" />
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<div class="row">

														<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
															<s:textfield type="text" name="amount"
																cssClass="form-control" tabindex="22" />
															<div id='addCreatedProductForm_weekNo_errorloc'
																class="error_strings"></div>
														</div>
													</div>
												</div>
											</div>
										</div> --%>
										
										
										
									</div>

<!--************************************* now payment area********************************************** -->
				
				
				<!-- <div class="container"> -->
			    <div class="panel panel-default" style="border-color: #99CCFF;margin-top:25px;">
			    <div class="panel-heading panel-title"><font style="color:red;">*</font>&nbsp;Whether the Owner is paying any amount or not?</div>
							<div class="panel-body">
				 <div class="row">
				 <div class="col-md-6">
							            <div class="col-md-1 col-xs-1 col-sm-1" style="margin-top: 4px;">
							              <div class="form-group">
							      	         <input  type="radio" id="yesPay" name="paymentAnswer" value="YES">
							      	        <%--  <s:radio name="paymentAnswer"></s:radio> --%>
		  						          </div>
							            </div>
							            <div class="col-md-3 col-xs-5 col-sm-5">
							              <div class="form-group" ">
							      	         <h5><%-- <s:text  name="add.new.product.sales.item"> </s:text> --%>Yes</h5>
		  						             </div>
							            </div>
							            </div>
							        <!-- </div>
							         <div class="row"> -->
							         <div class="col-md-6">
							            <div class="col-md-1 col-xs-1 col-sm-1" style="margin-top: 4px;">
							              <div class="form-group">
							      	         <input  type="radio" id="noPay" name="paymentAnswer" value="NO">
		  						          </div>
							            </div>
							            <div class="col-md-3 col-xs-5 col-sm-5">
							              <div class="form-group" ">
							      	         <h5><%-- <s:text  name="add.new.product.sales.item"> </s:text> --%>No</h5>
		  						             </div>
							            </div>
							            
							            
							            
							            
							        </div>
							        </div>
							        
							        <div class="row" id="paymentOption">
							        <div class="col-md-4">
							  <s:textfield name="payment"
														cssClass="form-control" theme="css_xhtml" cssStyle="width: 60%;"
														id="payingAmount" placeholder="Amount" />      
							        </div>
							        
							        
							        <div class="col-md-4">
							   <s:select list="payModeList" name="paymentMode" 
													theme="css_xhtml" headerKey="0" headerValue="Select Payment Mode"
													style="width:200px; height:30px;"/>
											<%-- <s:select list="payModeList" name="paymentMode" id="itemId"
													theme="css_xhtml" headerKey="-1" headerValue="Select Payment Mode"
													style="width:250px; height:35px;" /> --%>
							        </div>
							        </div>
							  </div>
							  </div>      
							       <!-- </div>  -->
<!--*******************************************End of payment area********************************************** -->

																		
									
									
								
									



									<div class="row" style="margin-top: 20px;">
										<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
											<h5 class="innertitle">
												<s:text name="add.new.product.description" />
											</h5>
											<hr style="margin-top: -5px">
										</div>
									</div>

									<div class="form-group">
										<div class="row" style="margin: 1% 2%;" id="data_grid">
											<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
												<div id='addCreatedProductForm_requirment_errorloc'
													class="error_strings"></div>
												<s:textarea id="wysihtml5" name="description"
													class="form-control" rows="10" tabindex="32">
												</s:textarea>
												<div id='addCreatedProductForm_description_errorloc'
													class="error_strings"></div>
											</div>
										</div>
									</div>
									<%-- <div class="row" style="margin-top: 20px;">
										<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
											<h5 class="innertitle">
												<s:text name="add.new.product.product.image" />
											</h5>
											<hr style="margin-top: -5px">
										</div>
									</div> --%>
									<%-- <div class="row">
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="" />
												</div>

												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<div class="fileinput fileinput-new"
														data-provides="fileinput">
														<div class="fileinput-new thumbnail"
															style="width: 200px; height: 150px;">
															<img data-src="holder.js/100%x100%" alt="...">
														</div>
														<div class="fileinput-preview fileinput-exists thumbnail"
															style="max-width: 200px; max-height: 150px;"></div>
														<div>
															<span class="btn btn-default btn-file"><span
																class="fileinput-new"><s:text
																		name="myAccount.user.profile.select.image" /></span> <span
																class="fileinput-exists"><s:text
																		name="myAccount.user.profile.change" /></span> <s:file
																	type="file" name="productImage" /> </span> <a href="#"
																class="btn btn-default fileinput-exists"
																data-dismiss="fileinput"><s:text
																	name="myAccount.user.profile.remove" /></a>
														</div>
													</div>
												</div>

											</div>
										</div>

									</div> --%>
									<hr style="margin-top: 20px">
									<div class="row">
										<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"
											align="center">
											<a href="productDashboard.action" data-toggle="tooltip"
												data-original-title="Cancel"
												class="btn btn-default btnheight"><i
												class="fa fa-caret-square-o-left fontawesomeht"></i> <s:text
													name="project.form.button.cancel"></s:text></a> <a
												href="addNewProduct.action" data-toggle="tooltip"
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
		var frmvalidator = new Validator("addCreatedProductForm");
		frmvalidator.EnableOnPageErrorDisplay();
		frmvalidator.EnableMsgsTogether();
		//Validation for Product Name.
		frmvalidator.addValidation("productName", "req", "Enter Product Name");
		frmvalidator.addValidation("productName", "maxlen=100",
				"Contact Product Name Should Be 100 Characters");
		frmvalidator.addValidation("productName", "minlen=1",
				"Contact Product Name Should Be 1 Characters");

		//Validation for Product Code.
		frmvalidator.addValidation("productCode", "req", "Enter Product Code");
		frmvalidator.addValidation("productCode", "maxlen=50",
				"Contact Product Code Should Be 50 Characters");
		frmvalidator.addValidation("productCode", "minlen=1",
				"Contact Product Code Should Be 1 Characters");
		frmvalidator.addValidation("productCode", "alnum",
				"Enter Only Alphanumeric Value ");
		/* //Validation for Product Category.
		frmvalidator.addValidation("productCategory", "req",
				"Enter Product Category");
		//Validation for Sales Start Date.
		frmvalidator.addValidation("salesStartDate", "req",
				"Select Sales Start Date ");
		//Validation for Sales End Date.
		frmvalidator.addValidation("salesEndDate", "req",
				"Enter Sales End Date");
		// Validation for Support Start Date. 
		 frmvalidator.addValidation("supportStartDate", "req",
				"Enter Support Satrt Date");

		// Validation for Support Expiry Date. 
		frmvalidator.addValidation("supportExpiryDate", "req",
				"Enter Support Expiry Date");  */

		//Validation for product Serial Number. 
		frmvalidator.addValidation("serialNo", "req", "Enter Serial Number");
		frmvalidator.addValidation("serialNo", "maxlen=50",
				" Serial Number Should Be 50 Characters");
		frmvalidator.addValidation("serialNo", "minlen=1",
				"Serial Number Should Be 1 Characters");
		//Validation for Mrf Part Number. 
		frmvalidator.addValidation("mrfPartNO", "req", "Enter Mrf Part Number");
		frmvalidator.addValidation("mrfPartNO", "maxlen=50",
				" Mrf Part Number Should Be 50 Characters");
		frmvalidator.addValidation("mrfPartNO", "minlen=1",
				"Mrf Part Number Should Be 1 Characters");
		frmvalidator.addValidation("mrfPartNO", "alnum",
				"Enter Only Alphanumeric Value ");
		//Validation for Vendor Part Number. 
		frmvalidator.addValidation("vendorPartNo", "req",
				"Enter Vendor Mrf Part Number");
		frmvalidator.addValidation("vendorPartNo", "maxlen=50",
				" Vendor Part Number Should Be 50 Characters");
		frmvalidator.addValidation("vendorPartNo", "minlen=1",
				"Vendor Part Number Should Be 1 Characters");
		frmvalidator.addValidation("vendorPartNo", "alnum",
				"Enter Only Alphanumeric Value ");
		//Validation for Product Sheet. 
		frmvalidator
				.addValidation("productSheet", "req", "Enter Product Sheet");
		frmvalidator.addValidation("productSheet", "maxlen=50",
				"Product Sheet Should Be 50 Characters");
		frmvalidator.addValidation("productSheet", "minlen=1",
				"Product Sheet Should Be 1 Characters");
		frmvalidator.addValidation("productSheet", "alnum",
				"Enter Only Alphanumeric Value ");
		//Validation for  Website URL. 
		frmvalidator.addValidation("website", "req", "Enter Website URL");
		frmvalidator.addValidation("website", "maxlen=100",
				"Website URL Should Be 50 Characters");
		frmvalidator.addValidation("productSheet", "minlen=1",
				"Website URL Should Be 1 Characters");
		//Validation for product unit price. 
		frmvalidator.addValidation("unitPrice", "req",
				"Enter Product Unit Price");
		frmvalidator.addValidation("unitPrice", "maxlen=50",
				" Unit Price Should Be 50 Characters");
		frmvalidator.addValidation("unitPrice", "minlen=1",
				"Unit Price Should Be 1 Characters");
		frmvalidator.addValidation("unitPrice", "num",
				"Enter Only Numeric Value ");
		//Validation for Commision Rate. 
		frmvalidator.addValidation("commisionRate", "req",
				"Enter Commision Rate");
		frmvalidator.addValidation("commisionRate", "maxlen=50",
				" Commision Rate Should Be 50 Characters");
		frmvalidator.addValidation("commisionRate", "minlen=1",
				"Commision Rate Should Be 1 Characters");
		frmvalidator.addValidation("commisionRate", "num",
				"Enter Only Numeric Value ");
		//Validation for Purchase Cost. 
		frmvalidator
				.addValidation("purchaseCost", "req", "Enter Purchase Cost");
		frmvalidator.addValidation("purchaseCost", "maxlen=50",
				" Purchase Cost Should Be 50 Characters");
		frmvalidator.addValidation("purchaseCost", "minlen=1",
				"Purchase Cost Should Be 1 Characters");
		frmvalidator.addValidation("purchaseCost", "num",
				"Enter Only Numeric Value ");
		//Validation for Qty Per Unit. 
		frmvalidator.addValidation("qtyPerUnit", "req", "Enter Qty Per Unit");
		frmvalidator.addValidation("qtyPerUnit", "maxlen=50",
				" Qty Per Unit Should Be 50 Characters");
		frmvalidator.addValidation("qtyPerUnit", "minlen=1",
				"Qty Per Unit Should Be 1 Characters");
		frmvalidator.addValidation("qtyPerUnit", "num",
				"Enter Only Numeric Value ");
		//Validation for Qty In Stock. 
		frmvalidator.addValidation("qtyInStock", "req", "Enter Qty In Stock");
		frmvalidator.addValidation("qtyInStock", "maxlen=100",
				" Qty In Stock Should Be 50 Characters");
		frmvalidator.addValidation("qtyInStock", "minlen=1",
				"Qty In Stock Should Be 1 Characters");
		frmvalidator.addValidation("qtyInStock", "num",
				"Enter Only Numeric Value ");
		//Validation for Reorder Level. 
		frmvalidator
				.addValidation("reorderLevel", "req", "Enter Reorder Level");
		frmvalidator.addValidation("reorderLevel", "maxlen=100",
				" Reorder Level Should Be 50 Characters");
		frmvalidator.addValidation("reorderLevel", "minlen=1",
				"Reorder Level Should Be 1 Characters");
		frmvalidator.addValidation("qtyInStock", "alpha",
				"Enter Only Alphabetic Value ");
		//Validation for Quantity In Demand. 
		frmvalidator.addValidation("qtyInDemand", "req",
				"Enter Quantity In Demand");
		frmvalidator.addValidation("reorderLevel", "maxlen=100",
				" Quantity In Demand Should Be 50 Characters");
		frmvalidator.addValidation("qtyInDemand", "minlen=1",
				"Quantity In Demand Should Be 1 Characters");
		frmvalidator.addValidation("qtyInDemand", "num",
				"Enter Only Numeric Value ");

		//Product date and expected closing date difference validation 
		function DoCustomValidation() {
			var frm1 = document.forms["addCreatedProductForm"];
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
			if (d1 <= d2) {
				return true;
			} else if (ndate == "") {
				sfm_show_error_msg("Select Sales Start Date", frm1.startDate);
				return false;
			} else if (ndate1 == "") {
				sfm_show_error_msg("Select Sales End Date", frm1.endDate);
				return false;
			} else {
				sfm_show_error_msg(
						"End Date Should be Greater Than Start Date",
						frm1.endDate);
				return false;
			}
		}

		frmvalidator.setAddnlValidationFunction(DoCustomValidation);
	</script>
</body>
</html>