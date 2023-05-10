<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="/struts-jquery-tags" prefix="sj"%>
<%@ taglib uri="/struts-jquery-richtext-tags" prefix="sjr"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="css/bootstrap.css" />
<link type="text/css" rel="stylesheet" href="css/bootstrap-theme.css">
<link rel="stylesheet" href="css/bootstrap-multiselect.css"
	type="text/css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"
	type="text/javascript"></script>
<script src="js/bootstrap.js" type="text/javascript"></script>
<script type="text/javascript" src="js/gen_validatorv4.js"></script>
<script src="http://acquisio.github.io/bootstrap-dropdown-checkbox/"></script>
<script type="text/javascript" src="js/bootstrap-multiselect.js"></script>

<script type="text/javascript">
function isNumber(evt) {
    evt = (evt) ? evt : window.event;
    var charCode = (evt.which) ? evt.which : evt.keyCode;
    if (charCode > 31 && (charCode < 48 || charCode > 57)) {
        return false;
    }
    return true;
}



</script>


<%-- <script>
	var xmlhttp;
	if (window.XMLHttpRequest) {
		xmlhttp = new XMLHttpRequest();
	} else {
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}

	
var adv = 0;
var amountTaxper = 0;
var amountTotal = 0;
	function getProductList() {
		adv = adv + 1; 
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				var div = document.createElement('div');
				div.className = 'row';

				var array = JSON.parse(xmlhttp.responseText);

				var array_element = "<div class='col-md-2 col-sm-2'  style='margin-left:-5px; padding:2px; margin-left:-2px;'><select name='itemId' id='itemId1"+adv+"' style='width:118px; height:35px' onchange='getProductDescriptionPrice(adv);' >";
				array_element += "<option  value='-1'>Select item</option>";
				for ( var i = 0; i < array.Product.length; i++) {
					array_element += "<option value='"+array.Product[i].productID+"' >"
							+ array.Product[i].productName + "</option>";
				}

				array_element += "</select></div>";          

				array_element += "<div class='col-md-2 col-sm-2' style='padding:2px;' id='productDescription"+adv+"' ><input type='text' style='width:124px; height:35px'  name='itemDescription'  placeholder='Description' readonly='true'/></div>";
				
				array_element += "<div class='col-md-2 col-sm-2' style='padding:2px;'><input type='text' style='width:124px; height:35px' value='0' name='itemQuantity' id='itemQuantity1"+adv+"' placeholder='Quantity' onkeypress='return isNumber(event)' onblur='calculateAmountSecond(adv)'/></div>";
				array_element += "<div class='col-md-2 col-sm-2' style='padding:2px;' id='productPrice"+adv+"'><input type='text' style='width:124px; height:35px' value='0' name='itemPrice' id='price1' placeholder='Price' readonly='true'/></div>";

				array_element += "<div class='col-md-2 col-sm-2' style='padding:2px;'><select style='width:118px; height:35px' id='itemTax"+adv+"'  name='itemTax' onchange='calculateAmountSecondWithTax(adv)'>";
				array_element += "<option  value='0'>Select Tax</option>";
				for ( var i = 0; i < array.taxList.Tax.length; i++) {
					array_element += "<option value='"+array.taxList.Tax[i].totalTax+"' >"
							+ array.taxList.Tax[i].taxdisplayName + "</option>";
				}

				array_element += "</select></div>";          

				
				array_element += "<div class='col-md-2 col-sm-2' style='padding:2px;' id='amountId"+adv+"'><input type='text' value='0' style='width:120px; height:35px' name='amount'  placeholder='Amount' readonly='true'/>";
				/* array_element += "<a><img src='images/CANCEL.PNG'  onclick='removeRow(this)'></a><div>"; */
				
				div.innerHTML = array_element;
				document.getElementById('newProdList').appendChild(div);
				
			}
		};
		xmlhttp.open("GET", "productListJASON.action", true);

		xmlhttp.send();
		
	}

	/* end function will fetch Product List */

	
	
	/* This function will fetch the Product Description and Product price for first row */
	
	function getProductDescriptionPriceFirst() {
	
	var productId=document.getElementById("itemId").value;
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				var array = JSON.parse(xmlhttp.responseText);
				alert(array.product.description);
				var	array_element1="<input type='text' style='width:124px; height:35px'  name='itemDescription'  placeholder='Description' value='"+array.product.description +"' readonly='true'/>";
				var	array_element2= "<input type='text'  Class='form-control'  name='itemPrice' id='itemPrice' value='"+array.product.productPrice +"' readonly='true' />";

		document.getElementById("productDescription").innerHTML = array_element1;
		document.getElementById("productPrice").innerHTML = array_element2;
		
           }
		};
		xmlhttp.open("GET", "productDescriptionAndPrice.action?productId=" +productId, true);

		xmlhttp.send();
	}
	
	
	
	/* function getItemTaxValue(taxId)
	{
		
		alert("hi"+taxId);
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				
				var array = JSON.parse(xmlhttp.responseText);
				alert(array.Tax.totalTax);
				tTax = array.Tax.totalTax;
			
			/*  var array_element1="<input type='hidden' id='taxIDD' value='"+array.Tax.totalTax+"' />";
				
			 document.getElementById("hiddenId").innerHTML = array_element1; 
           }
			
		};
		
		xmlhttp.open("GET", "getTotalTaxValue.action?taxId=" +taxId, true);
		
		xmlhttp.send();
		
	
	} */
	/* This function will fetch the Product Description and Product price for After first row */

	
	 function getProductDescriptionPrice(advance) {
	
	var productId=document.getElementById("itemId1"+adv).value;
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				var array = JSON.parse(xmlhttp.responseText);
				alert(array.product.description);
				alert(array.product.productPrice );
				var	array_element1="<div class='col-md-2 col-sm-2' style='padding:2px;' id='productDescription"+advance+"' ><input type='text' style='width:124px; height:35px'  name='itemDescription'  placeholder='Description' value='"+array.product.description +"' readonly='true'/></div>";
				
				var	array_element2= "<div class='col-md-2 col-sm-2' style='padding:2px;' id='productPrice"+advance+"'><input type='text' style='width:124px; height:35px' id='price1"+advance+"' value='"+array.product.productPrice +"'  name='itemPrice'  placeholder='Price' readonly='true'/></div>";
		
		document.getElementById("productDescription"+advance).innerHTML = array_element1;
		document.getElementById("productPrice"+advance).innerHTML = array_element2;
		
           }
		};
		xmlhttp.open("GET", "productDescriptionAndPrice.action?productId=" +productId, true);

		xmlhttp.send();
	} 
	 
	/* this method is used to calculate Amount for first row */
	function calculateAmount() {
		
		var productQuantity = document.getElementById("itemQuantity").value;
		alert("productQuantity"+productQuantity);
		var productPrice = document.getElementById("itemPrice").value;
		alert("productPrice"+productPrice);
		 var productTax = document.getElementById("itemTaxId").value;
		alert("productTax......id"+productTax);
		//getItemTaxValue(pTax);
		//var productTax = document.getElementById("taxIDD").value;
		//alert("totalTaxValue"+productTax); 
		var amount = productQuantity * productPrice;
		amountTotal = amountTotal + amount;
		alert("amount"+amount);
	    //amountTax=(amount*productTax)/100;
	    // amountTaxper = amountTaxper + amountTax;
	    // alert("total amount Tax value"+amountTaxper);
		//alert("amountTax"+amountTax);
		//var amountWithTax=Number(amount)+Number(amountTax);
		//alert("amountWithTax"+amountWithTax);
		//document.getElementById("amountId").innerHTML = "<input type='text' value='"+amountWithTax+"' name='amount' id='amountFirst' class='form-control' readonly='true'/>";
		document.getElementById("amountId").innerHTML = "<input type='text' value='"+amountTotal+"' name='amount' id='amountFirst' class='form-control' readonly='true'/>";
		calculatesubTotalAmount();
		calculateSubTotal();
		calculateNetTotalbyId();
	
	}
	
	
	
function calculateAmountWithTax() {
		
		var productQuantity = document.getElementById("itemQuantity").value;
		alert("productQuantity"+productQuantity);
		var productPrice = document.getElementById("itemPrice").value;
		alert("productPrice"+productPrice);
		var productTax = document.getElementById("itemTaxId").value;
		
		
		/* var productTax = getItemTaxValue(pTax);
		//var productTax = document.getElementById("taxIDD").value;
		//var productTax = tTax;
		alert("totalTaxValue"+productTax); */
		/* var tt = document.getElementById(taxIDD).value;
		alert("tt"+tt); */
		var amount = productQuantity * productPrice;
		amountTotal = amountTotal + amount;
		alert("amount"+amount);
	     amountTax=(amount*productTax)/100;
	     amountTaxper = amountTaxper + amountTax;
	     alert("total amount Tax value"+amountTaxper);
		alert("amountTax"+amountTax);
		var amountWithTax=Number(amount)+Number(amountTax);
		alert("amountWithTax"+amountWithTax);
		document.getElementById("amountId").innerHTML = "<input type='text' value='"+amountWithTax+"' name='amount' id='amountFirst' class='form-control' readonly='true'/>";
		calculateTotalTaxValue();
		calculateSubTotal();
		calculateNetTotalbyId();
}
	
	/* this method is used to calculate Amount for After first row*/
	
	function calculateAmountSecond(advance) {
		var productQuantity = document.getElementById("itemQuantity1"+advance).value;
		var productPrice = document.getElementById("price1"+advance).value;
		//var productTax = document.getElementById("itemTax"+advance).value;
		/* var productTax = getItemTaxValue(pTax);
		//var productTax = document.getElementById("taxIDD").value;
		alert("totalTaxValue"+productTax); */
		var amount = productQuantity * productPrice;
		amountTotal = amountTotal + amount;
		 //amountTax=(amount*productTax)/100;
		//alert(amountTax); 
		// amountTaxper = amountTaxper + amountTax;
		//alert("total amount Tax value"+amountTaxper); 
		//var amountWithTax=(amount)+(amountTax);
		//document.getElementById("amountId"+advance).innerHTML ="<div class='col-md-2 col-sm-2' style='padding:2px;' ><input type='text'  style='width:120px; height:35px' name='amount' value='"+amountWithTax+"' id='amounttID"+advance+"' placeholder='Amount' readonly='true'/>";
		document.getElementById("amountId"+advance).innerHTML ="<div class='col-md-2 col-sm-2' style='padding:2px;' ><input type='text'  style='width:120px; height:35px' name='amount' value='"+amount+"' id='amounttID"+advance+"' placeholder='Amount' readonly='true'/>";
		calculatesubTotalAmount();
		calculateSubTotal();
		calculateNetTotalbyId();
}
	
	
	function calculateAmountSecondWithTax(advance) {
		var productQuantity = document.getElementById("itemQuantity1"+advance).value;
		var productPrice = document.getElementById("price1"+advance).value;
		var productTax = document.getElementById("itemTax"+advance).value;
		/* var productTax = getItemTaxValue(pTax);
		//var productTax = document.getElementById("taxIDD").value;
		alert("totalTaxValue"+productTax); */
		var amount = productQuantity * productPrice;
		amountTotal = amountTotal + amount;
		 amountTax=(amount*productTax)/100;
		alert(amountTax); 
		 amountTaxper = amountTaxper + amountTax;
		alert("total amount Tax value"+amountTaxper); 
		var amountWithTax=(amount)+(amountTax);
		document.getElementById("amountId"+advance).innerHTML ="<div class='col-md-2 col-sm-2' style='padding:2px;' ><input type='text'  style='width:120px; height:35px' name='amount' value='"+amountWithTax+"' id='amounttID"+advance+"' placeholder='Amount' readonly='true'/>";
		calculateTotalTaxValue();
		calculateSubTotal();
		calculateNetTotalbyId();
		
}
	
	/* this method is used to calculate SubTotala */
	function calculateSubTotal()
	{
		 var productAmount1=document.getElementById("amountFirst").value;
		 var subTotal=0;
		for(var i=1;i<=adv;++i)
			{
			var amountsecond=Number(document.getElementById("amounttID"+i).value);
			subTotal=subTotal+amountsecond;
			
			} 
		subTotal=subTotal+Number(productAmount1);
		document.getElementById("subTotalId").innerHTML ="<input type='text' value='"+subTotal+"' name='total' id='totalINR' class='form-control' placeholder='click here' onblur='calculateSubTotal();' readonly='true' />";

		
	}
	
	/* this method is used to calculate SubTotala */
	function calculateTotalTaxValue()
	{
		 var totalTaxValue = amountTaxper;
		alert("totalTaxValue innn"+totalTaxValue);
		
		document.getElementById("totalTax").innerHTML ="<input type='text' value='"+totalTaxValue+"' name='totalTax' class='form-control' placeholder='click here' onblur='calculateTotalTaxValue();' readonly='true' />";

		
	}
	
	function calculatesubTotalAmount()
	{
		 var totalamtValue = amountTotal;
		alert("totalamtValue innnpppp"+totalamtValue);
		
		document.getElementById("totalSubTotal").innerHTML ="<input type='text' value='"+totalamtValue+"' name='subTotal' class='form-control' placeholder='click here' onblur='calculatesubTotalAmount();' readonly='true' />";

		
	}
	
	function calculateNetTotal(discount)
	{
		alert("discount"+discount);
		var totalINRValue = document.getElementById("totalINR").value;
		alert("totalINRValue"+totalINRValue);
		var disValue = (discount/100)*totalINRValue;
		alert("disValue"+disValue);
		var totalnetValue = totalINRValue - disValue;
		alert("totalnetValue"+totalnetValue);
		document.getElementById("netTotalId").innerHTML ="<input type='text' value='"+totalnetValue+"' name='netTotal' class='form-control' placeholder='click here'  readonly='true' />";

		
	}
	
	function calculateNetTotalbyId()
	{
		var discount = document.getElementById("discount").value;
		var totalINRValue = document.getElementById("totalINR").value;
		alert("totalINRValue"+totalINRValue);
		var disValue = (discount/100)*totalINRValue;
		alert("disValue"+disValue);
		var totalnetValue = totalINRValue - disValue;
		alert("totalnetValue"+totalnetValue);
		document.getElementById("netTotalId").innerHTML ="<input type='text' value='"+totalnetValue+"' name='netTotal' class='form-control' placeholder='click here'  readonly='true' />";

		
	}
	
	
	
	</script> --%>
<sj:head />
</head>
<body>

	<div class="container">
		<div class="panel panel-success">
			<div class="panel-heading">
				<h3 class="panel-title">
					<s:text name="add.estimate.header"></s:text>

					<div style="float: right; margin-right: 25px; font-size: smaller;">
						<font color="red">*</font>&nbsp;
						<s:text name="indicates.mandatory.fields"></s:text>
					</div>
				</h3>

			</div>
			<div class="panel-body">
				<div class="row">

					<div class="col-xs-12">
						<s:if test="hasActionErrors()">
							<div class="alert alert-danger" role="alert" style="height: 50px">
								<div class="col-xs-8">
									<s:actionerror />
								</div>

							</div>
						</s:if>
						<s:elseif test="hasActionMessages()">
							<div class="alert alert-success" role="alert"
								style="height: 50px">
								<div class="col-xs-8">
									<s:actionmessage />
								</div>

							</div>
						</s:elseif>
						<s:else>
							<div class="alert alert-info" role="alert" style="height: 50px">
								<div class="col-xs-8">

									<s:text name="add.estimate.information"></s:text>

								</div>


							</div>
						</s:else>
					</div>
				</div>

				<s:form action="addNewEstimate" name="addEstimate"
					cssClass="form-horizontal" role="form"
					enctype="multipart/form-data" method="POST">
					<s:iterator value="addEstimateVO" var="addEstimate">
						<div class="row">
							<div class="col-md-6 col-sm-6">
								<div class="form-group">
									<!-- <div class="col-sm-2 control-div"
									style="width: 30%; float: left;"></div> -->
									<div class="col-sm-6" style="width: 80%;">
										<s:textfield name="estimateId" cssClass="form-control "
											theme="css_xhtml" readonly="true"
											placeholder="%{getText('add.estimate.estimate')}" />

									</div>
								</div>

							</div>

							<div class="col-md-6 col-sm-6">
								<div class="form-group">
									<!-- <div class="col-sm-2 control-div"
									style="width: 30%; float: left;"> </div> -->
									<div class="col-sm-10" style="width: 80%;">
										<div id='addEstimate_estimateDate_errorloc'
											class="error_strings" style="color: red;"></div>
										<sj:datepicker name="estimateDate" changeMonth="true"
											changeYear="true" showAnim="slideDown" duration="fast"
											yearRange="1950:2050" showOn="focus" size="35%"
											displayFormat="yy-mm-dd" parentTheme="simple"
											cssClass="form-control" readonly="true"
											placeholder="%{getText('add.estimate.date')}" />
									</div>

								</div>
							</div>
						</div>
						<div class="row">

							<div class="col-md-6 col-sm-6">
								<div class="form-group">
									<!-- <div class="col-sm-2 control-div"
									style="width: 30%; float: left;"><font style="color: red;"></font>
								</div> -->
									<div class="col-sm-10" style="width: 70%;">
										<div id='addEstimate_currencyId_errorloc'
											class="error_strings" style="color: red;"></div>

										<s:select list="currencyList" name="currencyId"
											theme="css_xhtml" cssStyle="width: 100%;height:35px; "
											headerKey="-1" headerValue="Select Currency" />
									</div>
									<div class="col-md-2 col-sm-2">
										<img alt="Add New Client" src="images/plus-icon.png"
											style="height: 30px; width: 30px; margin-left: -20px;"
											title="Add New Client">
									</div>
								</div>
							</div>
							<div class="col-md-6 col-sm-6">
								<div class="form-group">
									<!-- <div class="col-sm-2 control-div"
									style="width: 30%; float: left;"></div> -->
									<div class="col-sm-10" style="width: 70%;">
										<div id='addEstimate_clientId_errorloc' class="error_strings"
											style="color: red;"></div>
										<s:select list="clientList" name="clientId" theme="css_xhtml"
											cssStyle="width: 100%;height:35px;" headerKey="-1"
											headerValue="Select Client" />
									</div>
									<div class="col-md-2 col-sm-2">
										<img alt="AddReminder" src="images/plus-icon.png"
											style="height: 30px; width: 30px; margin-left: -20px;"
											title="Add New Customer">
									</div>
								</div>
							</div>
						</div>



						<div class="row">
							<div class="col-md-6 col-sm-6">
								<div class="form-group">

									<div class="col-md-6 col-sm-6" style="width: 40%;">

										<!-- add buttton -->
										<s:textfield name="referenceNo" cssClass="form-control"
											theme="css_xhtml"
											placeholder="%{getText('add.invoice.references')}" />
									</div>
									<div class="col-md-6 col-sm-6" style="margin-left: -15px;">
										<a href="#"> <s:file name="scanDocument" />



										</a>
									</div>

								</div>
							</div>

						</div>



						<!-- <div style="padding-right: 10px; padding-left: 10px; margin-right: auto; margin-left: auto; border: 1px solid gray; height: 400px;"> -->
						<div class="panel panel-success" style="border-color: #99CCFF;">
							<div class="panel-body">
								<div class="row">
									<div class="col-md-12 col-sm-12 hidden-xs "
										style="height: 30px; margin-top: -15px; background-color: #99CCFF;">

										<div class="col-md-2 col-sm-2"
											style="margin-top: 5px; margin-left: 20px; width: 15%;">

											<%-- <s:text name="Item" id="Item"></s:text> --%>
											<s:text name="Item"></s:text>
										</div>
										<div class="col-md-2 col-sm-2"
											style="margin-top: 5px; margin-left: 10px; width: 20%;">
											<s:text name="Description"></s:text>
										</div>
										<div class="col-md-2 col-sm-2"
											style="margin-top: 5px; margin-left: -35px; width: 10%;">

											<%-- <s:text name="Quantity" id="Quantity"></s:text> --%>
											<s:text name="Quantity"></s:text>
										</div>
										<div class="col-md-2 col-sm-2"
											style="margin-top: 5px; margin-left: 70px; width: 15%;">
											<s:text name="Price"></s:text>

										</div>
										<div class="col-md-2 col-sm-2"
											style="margin-top: 5px; margin-left: 30px; width: 25%;">

											<s:text name="Tax"></s:text>
										</div>
										<div class="col-md-2 col-sm-4 "
											style="margin-top: 5px; margin-left: -100px; width: 15%;">
											<s:text name="Amount"></s:text>
										</div>
									</div>
								</div>


								<!-- grid row  -->

								<div class="row"
									style="margin-top: 15px; margin-left: 15px; margin-right: 15px;">
									<div class="row">
										<div class="col-md-2 col-sm-2 col-xs-12"
											style="padding-top: 4px;">
											<div class="input-group">
												<div id='addEstimate_itemId_errorloc' class="error_strings"
													style="color: red;"></div>
												<s:select list="productList" name="itemId" id="itemId"
													theme="css_xhtml" headerKey="-1" headerValue="Select Item"
													style="width:120px; height:35px"
													onchange="getProductDescriptionPriceFirst();" />

											</div>
										</div>

										<div class="col-md-2 col-sm-2 col-xs-12"
											style="padding-top: 4px;">
											<div class="input-group" id="productDescription">
												<s:textfield name="itemDescription" cssClass="form-control"
													theme="css_xhtml" placeholder="%{getText('Description')}"
													readonly="true" />
											</div>
										</div>

										<div class="col-md-2 col-sm-2 col-xs-12"
											style="padding-top: 4px;">
											<div id='addEstimate_itemQuantity_errorloc'
												class="error_strings" style="color: red;"></div>
											<div class="input-group">
												<%-- <s:textfield name="itemQuantity" cssClass="form-control" id="itemQuantity"
													theme="css_xhtml" placeholder="%{getText('Quantity')}" onblur="calculateAmount()" /> --%>

												<s:textfield name="itemQuantity" value="0"
													cssClass="form-control" id="itemQuantity"
													onblur="calculateAmount()"
													onkeypress="return isNumber(event)" theme="css_xhtml"
													placeholder="%{getText('Quantity')}" />
											</div>
										</div>




										<div class="col-md-2 col-sm-2 col-xs-12"
											style="padding-top: 4px;">
											<div class="input-group" id="productPrice">
												<s:textfield name="itemPrice" value="0"
													cssClass="form-control" id="itemPrice" theme="css_xhtml"
													placeholder="%{getText('Price')}" readonly="true" />
											</div>
										</div>

										<div class="col-md-2 col-sm-2 col-xs-12"
											style="padding-top: 4px;">
											<div id='addEstimate_itemTax_errorloc' class="error_strings"
												style="color: red;"></div>
											<div class="input-group">

												<s:select list="taxList" name="itemTax" id="itemTaxId"
													theme="css_xhtml" headerKey="0" headerValue="Select Tax"
													style="width:120px; height:35px"
													onchange="calculateAmountWithTax()" />

												<%--  <s:hidden name="taxesOne" id="taxesOne" value="0" /> --%>
											</div>
										</div>


										<div class="col-md-2 col-sm-2 col-xs-12"
											style="padding-top: 4px;">
											<div class="input-group" id="amountId">

												<s:textfield name="amount" value="0" cssClass="form-control"
													theme="css_xhtml" placeholder="%{getText('Amount')}"
													readonly="true" />

												<%-- <s:hidden name="amountOne" id="amountOne" value="0" /> --%>
											</div>
										</div>


									</div>
									<!-- close  grid  row  -->


									<div class="row">
										<div class="col-md-12 col-sm-12" style="margin-left: 15px;">
											<div id="newProdList"></div>
											<hr
												style="color: gray; margin-top: 10px; margin-left: -45px; margin-right: -15px;" />
											<a onclick="getProductList()"><button type="button"
													class="btn btn-primary btn-xs"
													style="margin-left: -10px; margin-top: -15px;">+Add
													New Row</button> </a>

											<!-- <hr
												style="color: gray; margin-top: 10px; margin-left: -45px; margin-right: -15px;" />

											<a onclick="removeRow()"><button type="button"
													class="btn btn-primary btn-xs"
													style="margin-left: -10px; margin-top: -15px;">-Remove
													Row</button> </a> -->

											<hr
												style="color: gray; margin-top: 4px; margin-left: -45px; margin-right: -15px;" />

											<div class="col-md-6 col-sm-6"></div>


										</div>
									</div>
								</div>
								<div class="row" style="padding: 3px;">

									<div class="col-md-4 col-sm-4"></div>

									<div class="col-md-8 col-sm-8">
										<div class="col-md-8 col-sm-8">
											<div class="col-md-6 col-sm-6"></div>
											<div class="col-md-6 col-sm-6">
												<div class="col-sm-2 control-div" style="width: 40%;">
													<s:text name=" Subtotal(INR)"></s:text>
												</div>
											</div>
										</div>
										<div class="col-md-4 col-sm-4"
											style="width: 160px; height: 35px" id="totalSubTotal">
											<%-- <s:textfield name="subtotal" cssClass="form-control"
												theme="css_xhtml" placeholder="click here" onblur="calculatesubTotalAmount();" readonly="true" /> --%>
											<s:textfield name="subTotal" cssClass="form-control"
												theme="css_xhtml" value="0" readonly="true" />
										</div>

									</div>
								</div>

								<div class="row" style="padding: 3px;">
									<div class="col-md-4 col-sm-4"></div>
									<div class="col-md-8 col-sm-8">
										<div class="col-md-8 col-sm-8">
											<div class="col-md-6 col-sm-6"></div>
											<div class="col-md-6 col-sm-6">
												<div class="col-sm-2 control-div" style="width: 40%;">
													<s:text name="TAX(INR)"></s:text>
												</div>
											</div>
										</div>
										<div class="col-md-4 col-sm-4"
											style="width: 160px; height: 35px" id="totalTax">
											<%-- <s:textfield name="totalTax" cssClass="form-control" placeholder="click here" onblur="calculateTotalTaxValue();"
												theme="css_xhtml" /> --%>
											<s:textfield name="totalTax" cssClass="form-control"
												value="0" theme="css_xhtml" />
										</div>
									</div>
								</div>


								<div class="row" style="padding: 3px;">
									<div class="col-md-4 col-sm-4"></div>
									<div class="col-md-8 col-sm-8">
										<div class="col-md-8 col-sm-8">
											<div class="col-md-6 col-sm-6"></div>
											<div class="col-md-6 col-sm-6">
												<div class="col-sm-2 control-div" style="width: 40%;">
													<s:text name="Total(INR)"></s:text>
												</div>
											</div>
										</div>
										<div class="col-md-4 col-sm-4"
											style="width: 160px; height: 35px" id="subTotalId">
											<%-- <s:textfield name="total" id="totalotalId" placeholder="click here" onblur="calculateSubTotal();" cssClass="form-control"
												theme="css_xhtml" /> --%>
											<s:textfield name="total" id="totalotalId" value="0"
												readonly="true" cssClass="form-control" theme="css_xhtml" />
										</div>
									</div>
								</div>

								<div class="row" style="padding: 3px;">
									<div class="col-md-4 col-sm-4"></div>
									<div class="col-md-8 col-sm-8">
										<div class="col-md-8 col-sm-8">
											<div class="col-md-6 col-sm-6"></div>
											<div class="col-md-6 col-sm-6">
												<div class="col-sm-2 control-div" style="width: 40%;">
													<s:text name="Discount(%)"></s:text>
												</div>
											</div>
										</div>
										<div class="col-md-4 col-sm-4"
											style="width: 160px; height: 35px">
											<s:textfield name="discount" id="discount" value="0"
												onkeypress="return isNumber(event)"
												onblur="calculateNetTotal(discount.value);"
												cssClass="form-control" theme="css_xhtml" />
										</div>
									</div>
								</div>
								<div class="row" style="padding: 3px;">
									<div class="col-md-4 col-sm-4"></div>
									<div class="col-md-8 col-sm-8">
										<div class="col-md-8 col-sm-8">
											<div class="col-md-6 col-sm-6"></div>
											<div class="col-md-6 col-sm-6">
												<div class="col-sm-2 control-div" style="width: 40%;">
													<s:text name="NETTOTAL(INR)"></s:text>
												</div>
											</div>
										</div>
										<div class="col-md-4 col-sm-4"
											style="width: 160px; height: 35px" id="netTotalId">
											<s:textfield name="netTotal" value="0"
												cssClass="form-control" theme="css_xhtml" />
										</div>
									</div>
								</div>
								<div class="row" style="height: 15px;"></div>

								<div class="col-md-12 col-sm-12"></div>
							</div>


							<hr style="color: gray;" />
							<div class="form-group">
								<div class="col-md-4 col-sm-4"
									style="margin-left: -14px; margin-bottom: 10px;">
									<a href="estimate"><input type="button" class="btn btn-default" value="Cancel"></a>
									&nbsp;
									<s:submit cssClass="btn btn-primary" value="Save"
										theme="simple" />

								</div>
								<div class="col-md-3 col-sm-3"></div>


							</div>
					</s:iterator>
					<!-- <div id="hiddenId"></div> -->
				</s:form>
			</div>
		</div>
		<div></div>
	</div>
</body>
</html>

<script type="text/javascript">
	var frmvalidator = new Validator("addEstimate");
	frmvalidator.EnableOnPageErrorDisplay();
	frmvalidator.EnableMsgsTogether();

frmvalidator.addValidation("estimateDate", "req","Please select date");
	
frmvalidator.addValidation("currencyId", "dontselect=-1","Please select Currency");

frmvalidator.addValidation("clientId", "dontselect=-1","Please select client ");

frmvalidator.addValidation("itemId", "dontselect=-1","Please select Item");

frmvalidator.addValidatin("itemQuantity", "req","Please insert Quantity");

frmvalidator.addValidation("itemTax", "dontselect=-1","Please select Tax");


	
</script>