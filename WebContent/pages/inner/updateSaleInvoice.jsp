<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@taglib uri="/struts-tags" prefix="s"%>
      <%@ taglib uri="/struts-jquery-tags" prefix="sj"%>
      <%@ taglib uri="/struts-jquery-richtext-tags" prefix="sjr"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sale Invoice</title>
<%-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script type="text/javascript" src="outer/js1/vendor/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="outer/js/gen_validatorv4.js"></script> --%>
<script type="text/javascript" src="outer/js/gen_validatorv4.js"></script>
<script src="http://acquisio.github.io/bootstrap-dropdown-checkbox/"></script>
<script type="text/javascript" src="inner/assets/js/bootstrap-multiselect.js"></script> 
<script type="text/javascript">
$(function(){
	$('#purchaseItem').hide();
	$('#salesItem').hide();
$("#termsId").change(function(){
if ($(this).is(":checked")){
	$('#purchaseItem').show(1200);
	$('#salesItem').hide(800);
} else {
	$('#purchaseItem').hide(800);
	$('#salesItem').show(1200); 
}
});

$("#termsId1").change(function(){
if ($(this).is(":checked")){
	$('#salesItem').show(1200); 
	$('#purchaseItem').hide(800);
} else {
	$('#salesItem').hide(800);
	$('#purchaseItem').show(1200);
}
});
});  

$(function(){
$('#paymentOption').hide();

$("#yesPay").change(function(){
if ($(this).is(":checked")){
$('#paymentOption').show(800);

} else {
$('#paymentOption').hide(800);

}
});

$("#noPay").change(function(){
if ($(this).is(":checked")){
$('#paymentOption').hide(1200);
} else {

}
}); 
});  

/* $(function() {
if (document.getElementById("termsId").checked == true) {
    document.getElementById("termsId").value = 1;
    document.getElementById("termsId1").value = 0;
} else {
    document.getElementById("termsId").value = 0;
    document.getElementById("termsId1").value = 1;
}
console.log(document.getElementById("is_BMW").value);
console.log(document.getElementById("is_Mercedes").value)




}); */


/*  $(document).ready(function() {
if (document.getElementById("termsId").checked == true) {
    document.getElementById("termsId").value = 1;
    document.getElementById("termsId1").value = 0;
} else {
    document.getElementById("termsId").value = 0;
    document.getElementById("termsId1").value = 1;
}
console.log(document.getElementById("termsId").value);
console.log(document.getElementById("termsId1").value);
}); */
/*  $(document).ready(function() {
$('input[type=radio]').on('change', function(){
$('input[type=radio]').not(this).prop('checked', false);

}); 
}); */

function getRadioValue(){
 var radioVal;
 $("input[type='button']").click(function(){
	  radioVal=$("input[name='customerType']:checked").val();
	
 
});
 return radioVal;
}
</script>
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

<script>
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
		
		array_element += "<div class='col-md-2 col-sm-2' style='padding:2px;'><input type='text' style='width:124px; height:35px' name='itemQuantity' id='itemQuantity1"+adv+"' placeholder='Quantity' onkeypress='return isNumber(event)' onblur='calculateAmountSecond(adv)'/></div>";
		array_element += "<div class='col-md-2 col-sm-2' style='padding:2px;' id='productPrice"+adv+"'><input type='text' style='width:124px; height:35px' name='itemPrice' id='price1' placeholder='Price' readonly='true'/></div>";

		array_element += "<div class='col-md-2 col-sm-2' style='padding:2px;'><select style='width:118px; height:35px' id='itemTax"+adv+"'  name='itemTax' onchange='calculateAmountSecondWithTax(adv)'>";
		array_element += "<option  value='0'>Select Tax</option>";
		for ( var i = 0; i < array.taxList.Tax.length; i++) {
			array_element += "<option value='"+array.taxList.Tax[i].totalTax+"' >"
					+ array.taxList.Tax[i].taxdisplayName + "</option>";
		}

		array_element += "</select></div>";          
		/* alert("productPrice"+adv+document.getElementById("itemQuantity").value+document.getElementById("productDescription").value+document.getElementById("itemId").value+document.getElementById("itemTax").value+document.getElementById("itemQuantity1").value); */
		
		array_element += "<div class='col-md-2 col-sm-2' style='padding:2px;' id='amountId"+adv+"'><input type='text' style='width:120px; height:35px' name='amount'  placeholder='Amount' readonly='true'/>";
		/* array_element += "<a><img src='images/CANCEL.PNG'  onclick='removeRow(this)'></a><div>"; */
		alert("productPrice"+adv);
		div.innerHTML = array_element;
		document.getElementById('newProdList').appendChild(div);
		
	}
};
xmlhttp.open("GET", "productListJASONForSaleInvoice.action", true);

xmlhttp.send();

}

/* end function will fetch Product List */



/* This function will fetch the Product Description and Product price for first row */

function getProductDescriptionPriceFirst() {

var productId=document.getElementById("itemId").value;
xmlhttp.onreadystatechange = function() {
	if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
		var array = JSON.parse(xmlhttp.responseText);
		/* alert(array.product.description); */
		var	array_element1="<input type='text' style='width:124px; height:35px'  name='itemDescription'  placeholder='Description' value='"+array.product.description +"' readonly='true'/>";
		var	array_element2= "<input type='text'  Class='form-control'  name='itemPrice' id='itemPrice' value='"+array.product.productPrice +"' readonly='true' />";

document.getElementById("productDescription").innerHTML = array_element1;
document.getElementById("productPrice").innerHTML = array_element2;

   }
};
xmlhttp.open("GET", "productDescriptionAndPriceForInvoiceSale.action?productId=" +productId, true);

xmlhttp.send();
}



function getRegularCustomerDetails() {

var regularId=document.getElementById("custId").value;


xmlhttp.onreadystatechange = function() {
	if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
		var array = JSON.parse(xmlhttp.responseText);
		
		/* var	array_element1="<input type='text' style='width:124px; height:35px'  name='itemDescription'  placeholder='Description' value='"+array.product.description +"' readonly='true'/>"; */
		/* var	array_element2= "<input type='text'  Class='form-control'  name='itemPrice' id='itemPrice' value='"+array.product.productPrice +"' readonly='true' />"; */
          var	array_element1=" <input type='text' name= 'address' placeholder= 'Address' value= '"+array.regularCustomer.custAddress +"' style='width: 60%;height:35px;border-color:red;' id='purchaseitemName' Class ='form-control' />";
		
		var	array_element2=	" <input type='text' name = 'phoneNo' placeholder = 'ContactNo' value = '"+array.regularCustomer.custContact +"'  style ='width: 60%;height:35px;border-color:red;'   id = 'purchaseitemCode' Class = 'form-control' />" ;
		
document.getElementById("customerAddress").innerHTML = array_element1;
document.getElementById("customerPhoneNo").innerHTML = array_element2;

   }
};
xmlhttp.open("GET", "regularCustomerDetailsForInvoiceSale.action?custId=" +regularId, true);

xmlhttp.send();
}


function getConsumerCustomerDetails() {

var consumerId=document.getElementById("custId2").value;


xmlhttp.onreadystatechange = function() {
	if(xmlhttp.readyState == 4 && xmlhttp.status == 200) {
		var array = JSON.parse(xmlhttp.responseText);
		
		/* var	array_element1="<input type='text' style='width:124px; height:35px'  name='itemDescription'  placeholder='Description' value='"+array.product.description +"' readonly='true'/>"; */
		/* var	array_element2= "<input type='text'  Class='form-control'  name='itemPrice' id='itemPrice' value='"+array.product.productPrice +"' readonly='true' />"; */
         
		var	array_element4=" <input type='text' name = 'phoneNoConsumer' placeholder = 'ContactNo' value = '"+array.consumerCustomer.consuContact +"' style ='width: 60%;height:35px;border-color:red;'   id = 'customerPhoneNo2' Class = 'form-control' />" ;
		
		var	array_element3=" <input type='text' name= 'addressConsumer' placeholder= 'Address' value= '"+array.consumerCustomer.consuAddress +"' style='width: 60%;height:35px;border-color:red;' id='customerAddress2' Class ='form-control' />";
		
		
		
document.getElementById("customerAddress2").innerHTML = array_element3;
document.getElementById("customerPhoneNo2").innerHTML = array_element4;

   }
};
xmlhttp.open("GET", "consumerCustomerDetailsForInvoiceSale.action?custId2=" +consumerId, true);

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
		/* alert(array.product.description); */
		/* alert(array.product.productPrice ); */
		
		var	array_element1="<div class='col-md-2 col-sm-2' style='padding:2px;' id='productDescription"+advance+"' ><input type='text' style='width:124px; height:35px'  name='itemDescription'  placeholder='Description' value='"+array.product.description +"' readonly='true'/></div>";
		
		var	array_element2= "<div class='col-md-2 col-sm-2' style='padding:2px;' id='productPrice"+advance+"'><input type='text' style='width:124px; height:35px' id='price1"+advance+"' value='"+array.product.productPrice +"'  name='itemPrice'  placeholder='Price' readonly='true'/></div>";

document.getElementById("productDescription"+advance).innerHTML = array_element1;
document.getElementById("productPrice"+advance).innerHTML = array_element2;

   }
};
xmlhttp.open("GET", "productDescriptionAndPriceForInvoiceSale.action?productId=" +productId, true);

xmlhttp.send();
} 

/* this method is used to calculate Amount for first row */
function calculateAmount() {

var productQuantity = document.getElementById("itemQuantity").value;
/* alert("productQuantity"+productQuantity); */
var productPrice = document.getElementById("itemPrice").value;
/* alert("productPrice"+productPrice); */
 var productTax = document.getElementById("itemTaxId").value;
/* alert("productTax......id"+productTax); */
//getItemTaxValue(pTax);
//var productTax = document.getElementById("taxIDD").value;
//alert("totalTaxValue"+productTax); 
var amount = productQuantity * productPrice;
amountTotal = amountTotal + amount;
/* alert("amount"+amount); */
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
/* alert("productQuantity"+productQuantity); */
var productPrice = document.getElementById("itemPrice").value;
/* alert("productPrice"+productPrice); */
var productTax = document.getElementById("itemTaxId").value;


/* var productTax = getItemTaxValue(pTax);
//var productTax = document.getElementById("taxIDD").value;
//var productTax = tTax;
alert("totalTaxValue"+productTax); */
/* var tt = document.getElementById(taxIDD).value;
alert("tt"+tt); */
var amount = productQuantity * productPrice;
amountTotal = amountTotal + amount;
/* alert("amount"+amount); */
 amountTax=(amount*productTax)/100;
 amountTaxper = amountTaxper + amountTax;
/*  alert("total amount Tax value"+amountTaxper);
alert("amountTax"+amountTax); */
var amountWithTax=Number(amount)+Number(amountTax);
/* alert("amountWithTax"+amountWithTax); */
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
/* alert(amountTax);  */
 amountTaxper = amountTaxper + amountTax;
/* alert("total amount Tax value"+amountTaxper); */ 
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
/* alert("totalTaxValue innn"+totalTaxValue); */

document.getElementById("totalTax").innerHTML ="<input type='text' value='"+totalTaxValue+"' name='totalTax' class='form-control' placeholder='click here' onblur='calculateTotalTaxValue();' readonly='true' />";


}

function calculatesubTotalAmount()
{
 var totalamtValue = amountTotal;
/* alert("totalamtValue innnpppp"+totalamtValue); */

document.getElementById("totalSubTotal").innerHTML ="<input type='text' value='"+totalamtValue+"' name='subTotal' class='form-control' placeholder='click here' onblur='calculatesubTotalAmount();' readonly='true' />";


}

function calculateNetTotal(discount)
{
/* alert("discount"+discount); */
var totalINRValue = document.getElementById("totalINR").value;
/* alert("totalINRValue"+totalINRValue); */
var disValue = (discount/100)*totalINRValue;
/* alert("disValue"+disValue); */
var totalnetValue = totalINRValue - disValue;
/* alert("totalnetValue"+totalnetValue); */
document.getElementById("netTotalId").innerHTML ="<input type='text' value='"+totalnetValue+"' name='netTotal' class='form-control' placeholder='click here'  readonly='true' />";


}

function calculateNetTotalbyId()
{
var discount = document.getElementById("discount").value;
var totalINRValue = document.getElementById("totalINR").value;
/* alert("totalINRValue"+totalINRValue); */
var disValue = (discount/100)*totalINRValue;
/* alert("disValue"+disValue); */
var totalnetValue = totalINRValue - disValue;
/* alert("totalnetValue"+totalnetValue); */
document.getElementById("netTotalId").innerHTML ="<input type='text' value='"+totalnetValue+"' name='netTotal' class='form-control' placeholder='click here'  readonly='true' />";


}

function checkingRadio(){
	var custType = document.getElementById("myHidden").value;
	alert(custType+"hehehehehehe");
}

</script>
<sj:head /> 
</head>
<body>
<div id="content">
		<div class="outer">
			<div class="inner bg-light lter">
			<!-- *****  code copied from here-->
			<div class="row" >
					<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
						<ol class="breadcrumb" style="margin-top: 10px;">
							<li><a href="#">Invoice</a></li>
							<li><a href="#">Invoice Dashboard</a></li>
							<li class="active">Sale Invoice</li>
						</ol>
						<div class="box dark">
							<header>
							<div class="pull-left">



								<a class="icons" href="leadDashboard.action"
									data-toggle="tooltip"
									data-original-title="Back To Lead DashBoard"
									style="color: black;"> <i class="fa fa-th-large"></i>
								</a>
								<h5 class="header_color">
									<%-- <s:text name="Add New Estimate" /> --%>Add Sale Invoice
								</h5>
							</div>
							<div class="pull-right">


								<a href="invoiceDashbord" data-toggle="tooltip"
									data-original-title="Close" data-placement="bottom"
									class="btn btn-danger btnheight "> <i class="fa fa-times"></i></a>

							</div>

							</header>
			
			
						<%-- 	<s:iterator value="addInvoiceSaleVO" var="addSalesDetails"> --%>
			
			<div class="container" style="margin-top:25px;">
			<div class="panel-group">
			
							
 <div class="panel panel-default" style="margin-left:-30px;">
 
			<div class="panel-heading">
			    <h3 class="panel-title">
			      <%-- <s:text name="%{getText('product.management.navi.bar')} "></s:text> --%>
			      Sales Management
			       <div style="float: right; margin-right: 25px; font-size: smaller;"> 
						<font color="red" >*</font>&nbsp; Red Fields Indicate Mandatory Fields
					 </div>
			      
			    </h3>
			    
			   </div> 
			   <%-- <div class="alert alert-info">
							<s:text name="add.client.contact.person.information"> </s:text>
							
      				   </div> --%>
			
			     <!-- <form  name="addSalesDetails" cssClass="form-horizontal" role="form"
					enctype="multipart/form-data" method="POST">  -->
					
			    <div class="panel-body">
			    
			    <s:form action="updateSalesDone" name="addSales" cssClass="form-horizontal"
							role="form" enctype="multipart/form-data" method="POST"> 
							 <s:iterator value="invoiceSaleVO" var="addSale"> 
			       <div class="row">
			    <div class="col-md-6 col-sm-6 col-xs-8" >
			   
							
							        <div class="row">
							        <s:hidden name="customerType" id="myHidden" />
							           <div class="col-md-1 col-xs-1 col-sm-1" style="margin-top: 4px; margin-left:20px">
							             <div class="form-group " >
							      	    <label>   <input type="radio"  name="customerType" id="termsId" value="Retailer" onclick="getRadioValue()">Retailer</label>
		  						         </div> 
							          </div>
							          <div class="col-md-5 col-xs-5 col-sm-5">
						     	          <div class="form-group">
							        	     <h5><%-- <s:text name="add.new.product.purchase.item"> </s:text> --%></h5>
		  						         </div>
							           </div> 
							        </div>
							        <div id="purchaseItem">
							        
							        <!-- added by me -->
							        
							         <div class="form-group">
							         <div id='addSales_account_errorloc'
													class="error_strings" style="color: red;"></div>
							         <s:select cssClass="form-control chzn-select" list="regCustomersList" id="custId"
										    name="customerId" headerKey="-1" 
							    			headerValue= "Select Customer" 
											cssStyle="width: 60%;height:35px; margin-left:20px;"
											onchange="getRegularCustomerDetails()" />  
							      <%--  <select class="form-control" name="accountTypeId" theme="css_xhtml" cssStyle="width: 10px;height:35px;"
											headerKey="-1" headerValue="Select Customer" style= "width: 350px;height:35px;">
											<option>1</option>
											<option>2</option>
											</select> --%> 
							        </div>
							        
							        <!-- added by me -->
							        <div class="form-group" id="customerPhoneNo">
							      <div id='addSales_itemCode_errorloc'
													class="error_strings" style="color: red;"></div>
								     <s:textfield name="phoneNo" 
		 						       placeholder="ContactNo"
									   theme="css_xhtml" cssStyle="width: 60%;height:35px; margin-left:20px;border-color:;" 
									   id="phoneNo" cssClass="form-control" onchange="checkingRadio()"/>
								</div>
							        
							         <div class="form-group" id="customerAddress">
			   			        <div id='addSales_phoneNo_errorloc'
													class="error_strings" style="color: red;"></div>
								    
				      				 <s:textfield name="address" 
									          placeholder="Address"
									          theme="css_xhtml" cssStyle="width: 60%;height:35px;margin-left:20px;border-color:;" 
									          id="address" cssClass="form-control"/>
								</div>
							          
								    <div class="form-group">
								      <div id='addSales_address_errorloc'
													class="error_strings" style="color: red;"></div>
							              <s:textfield type="date" name="salesDate" tabindex="13" id="dp4"
														cssClass="form-control" theme="css_xhtml" cssStyle="width: 60%;margin-left:20px;"
													 placeholder="Current date" />  
														 <!-- <input type="date" name="salesDate" tabindex="13" id="dp3"
														cssClass="form-control" theme="css_xhtml" style="width: 60%;margin-left:20px;"
														id="purchaseunit" placeholder="Current date"/> --> 
									<%-- <sj:datepicker name="salesDate" changeMonth="true"
											changeYear="true" showAnim="slideDown" duration="fast"
											yearRange="1950:2050" showOn="focus" size="1%"
											displayFormat="yy-mm-dd" parentTheme="simple"
											cssClass="form-control" 
											 placeholder="date" /> --%>
								    </div>
						      
						   
  
							
					     
				        
							
						
						</div>
						
		
			    </div>
			    
			    
			    
			    
			    
			    
			    
			    
			    
			    
			   <div class="col-md-6 col-sm-6 col-xs-8">
			    
							
<!-- gggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggg -->						      
							          <div class="row">
							            <div class="col-md-1 col-xs-1 col-sm-1" style="margin-top: 4px;">
							              <div class="form-group">
							      	        <label> <input  type="radio" id="termsId1" name="customerType" value="Consumer" onclick="getRadioValue()">Consumer</label>
		  						          </div>
							            </div>
							            <div class="col-md-3 col-xs-5 col-sm-5">
							              <div class="form-group" ">
							      	         <h5></h5>
		  						             </div>
							            </div>
							        </div>
							         <div id="salesItem">
							        <div class="form-group">
							       <div id='addSales_salesItemCode_errorloc'
													class="error_strings" style="color: red;"></div>
								    <%--  <s:textfield name="fullNameConsumer" 
		 						       placeholder="Customer Name"
									   theme="css_xhtml" cssStyle="width: 60%;height:35px;" 
									   id="name" cssClass="form-control"/> --%>
									    <s:select cssClass="form-control chzn-select" list="consumerCustomersList" id="custId2"
										    name="customerIdConsumer" headerKey="-1" 
							    			headerValue= "Select Customer" 
											cssStyle="width: 60%;"  onchange="getConsumerCustomerDetails()"/>  
								</div>
							        
							         <div class="form-group" id="customerPhoneNo2">
			   			        <div id='addSales_salsetaxrate_errorloc'
													class="error_strings" style="color: red;"></div>
								    
				      				 <s:textfield name="phoneNoConsumer" 
									          placeholder="Contact No"
									          theme="css_xhtml" cssStyle="width: 60%;height:35px;" 
									           cssClass="form-control"/>
								</div>
							
							          
								    <div class="form-group" id="customerAddress2">
								      <div id='addSales_phoneNoConsumer_errorloc'
													class="error_strings" style="color: red;"></div>
							             <s:textfield name="addressConsumer"
														cssClass="form-control" theme="css_xhtml" cssStyle="width: 60%;"
														 placeholder="Address" />
									  
								    </div>
						      
						     <div class="form-group">
								      <div id='addSales_addressConsumer_errorloc'
													class="error_strings" style="color: red;"></div>
							            <!--  <input type="date" name="salesDateConsumer" tabindex="13"
														cssClass="form-control" theme="css_xhtml" style="width: 60%;"
														id="purchaseunit" placeholder="Current Date"/>  -->
														
														<s:textfield type="date" name="salesDateConsumer" tabindex="13" id="dp4"
														cssClass="form-control" theme="css_xhtml" cssStyle="width: 60%;"
													 placeholder="Current date" />  
									  
								    </div> 
								    </div> 
								    </div><!-- row close -->
								   </div>
	<!-- ggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggg -->							    
						     
						
				        
				         
				        
		
			   
			    
			   
			    <!-- oooooooooooooooooooo calculation OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO-->
			     
					<!-- <div class="container"> -->
			    <div class="panel panel-success" style="border-color: #99CCFF;margin-top:25px;">
							<div class="panel-body">
								<div class="row">
									<div class="col-md-12 col-sm-12 hidden-xs "
										style="height: 30px; margin-top: -15px; background-color: #394B5E;">

										<div class="col-md-2 col-sm-2"
											style="margin-top: 5px; margin-left: 20px; width: 15%;color:white;">

											<%-- <s:text name="Item" id="Item"></s:text> --%>
											<s:text name="Item"></s:text>
										</div>
										<div class="col-md-2 col-sm-2"
											style="margin-top: 5px; margin-left: 10px; width: 20%;color:white;">
											<s:text name="Description"></s:text>
										</div>
										<div class="col-md-2 col-sm-2"
											style="margin-top: 5px; margin-left: -35px; width: 10%;color:white;">

											<%-- <s:text name="Quantity" id="Quantity"></s:text> --%>
											<s:text name="Quantity"></s:text>
										</div>
										<div class="col-md-2 col-sm-2"
											style="margin-top: 5px; margin-left: 70px; width: 15%;color:white;">
											<s:text name="Price"></s:text>

										</div>
										<div class="col-md-2 col-sm-2"
											style="margin-top: 5px; margin-left: 30px; width: 25%;color:white;">

											<s:text name="Tax"></s:text>
										</div>
										<div class="col-md-2 col-sm-4 "
											style="margin-top: 5px; margin-left: -100px; width: 15%;color:white;">
											<%-- <s:text name="Amount"></s:text> --%>Amount
										</div>
									</div>
								</div>


								<!-- grid row  invoiceSaleItemsList -->

								<div class="row"
									style="margin-top: 15px; margin-left: 15px; margin-right: 15px;">
									<s:iterator value="invoiceSaleItemsList" var="testObj">
									<div class="row">
									
										<div class="col-md-2 col-sm-2 col-xs-12"
											style="padding-top: 4px;">
											<div class="input-group">
												<div id='addSales_itemId_errorloc' class="error_strings"
													style="color: red;"></div>
												 <s:select list="productList" name="itemId" id="itemId"
													theme="css_xhtml" headerKey="-1" headerValue="Select Item"
													style="width:120px; height:35px;" onchange="getProductDescriptionPriceFirst()"/> 
													<%-- <select class="form-control" name="itemId" theme="css_xhtml" headerKey="-1" headerValue="Select Item"
													style="width:120px; height:35px" >
											<option>1</option>
											<option>2</option>
											</select>--%>

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
											<div id='addSales_itemQuantity_errorloc'
												class="error_strings" style="color: red;"></div>
											<div class="input-group">
												<%-- <s:textfield name="itemQuantity" cssClass="form-control" id="itemQuantity"
													theme="css_xhtml" placeholder="%{getText('Quantity')}" onblur="calculateAmount()" /> --%>

												<s:textfield name="itemQuantity" 
													cssClass="form-control" id="itemQuantity"
													onblur="calculateAmount()"
													onkeypress="return isNumber(event)" theme="css_xhtml"
													placeholder="%{getText('Quantity')}" />
											</div>
										</div>




										<div class="col-md-2 col-sm-2 col-xs-12"
											style="padding-top: 4px;">
											<div class="input-group" id="productPrice">
												<s:textfield name="itemPrice" 
													cssClass="form-control" id="itemPrice" theme="css_xhtml"
													placeholder="%{getText('Price')}" readonly="true" />
											</div>
										</div>

										<div class="col-md-2 col-sm-2 col-xs-12"
											style="padding-top: 4px;">
											<div id='addSales_itemTax_errorloc' class="error_strings"
												style="color: red;"></div>
											<div class="input-group">

												  <s:select list="taxList" name="itemTax" id="itemTaxId"
													theme="css_xhtml" headerKey="0" headerValue="Select Tax"
													style="width:120px; height:35px"
													onchange="calculateAmountWithTax()" />  
													

                                     <%-- <select class="form-control" name="itemTax"  
													theme="css_xhtml" headerKey="0" headerValue="Select Tax"
													style="width:120px; height:35px">
											<option>1</option>
											<option>2</option>
											</select> --%>
												 <%-- <s:hidden name="taxesOne" id="taxesOne" value="0" /> --%><!--  ye ni lena bharti -->
											</div>
										</div>


										<div class="col-md-2 col-sm-2 col-xs-12"
											style="padding-top: 4px;">
											<div class="input-group" id="amountId">

												<s:textfield name="amount"  cssClass="form-control"
													theme="css_xhtml" placeholder="%{getText('Amount')}"
													readonly="true" />

												<%-- <s:hidden name="amountOne" id="amountOne" value="0" /> --%>
											</div>
										</div>
										</div>
</s:iterator> 

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

											

											<hr
												style="color: gray; margin-top: 4px; margin-left: -45px; margin-right: -15px;" />

											<div class="col-md-6 col-sm-6"></div>


										</div>
									</div>
								</div>
								
								<s:iterator value="invoiceSaleVO" > 
								<div class="row" style="padding: 3px;">

									<div class="col-md-4 col-sm-4"></div>

									<div class="col-md-8 col-sm-8">
										<div class="col-md-8 col-sm-8">
											<div class="col-md-6 col-sm-6"></div>
											<div class="col-md-6 col-sm-6">
												<div class="col-sm-2 control-div" style="width:40%;">
													<s:text name=" Subtotal(INR)"></s:text>
												</div>
											</div>
										</div>
										<div class="col-md-4 col-sm-4"
											style="width: 160px; height: 35px" id="totalSubTotal">
											<%-- <s:textfield name="subtotal" cssClass="form-control"
												theme="css_xhtml" placeholder="click here" onblur="calculatesubTotalAmount();" readonly="true" /> --%>
											<s:textfield name="subTotal" cssClass="form-control"
												theme="css_xhtml"  readonly="true" />
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
												 theme="css_xhtml" />
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
											<s:textfield name="total" id="totalotalId" 
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
											<s:textfield name="discount" id="discount" 
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
											<s:textfield name="netTotal" 
												cssClass="form-control" theme="css_xhtml" />
										</div>
									</div>
								</div>
								</s:iterator>
								<div class="row" style="height: 15px;"></div>

								<div class="col-md-12 col-sm-12"></div>
							</div>


							
							
					 
					<!-- <div id="hiddenId"></div> -->
				<%-- </s:form>  --%>
				<!-- </div> -->
				<!-- </div> -->
				
				<!--************************************* now payment area********************************************** -->
				
				
				<!-- <div class="container"> -->
			    <div class="panel panel-default" style="border-color: #99CCFF;margin-top:25px;">
			    <div class="panel-heading panel-title"><font style="color:red;">*</font>&nbsp;Whether the Customer is paying any amount or not?</div>
							<div class="panel-body">
							<s:iterator value="invoiceSaleVO" > 
				 <div class="row">
				 <div class="col-md-6">
							            <div class="col-md-1 col-xs-1 col-sm-1" style="margin-top: 4px;">
							              <div class="form-group">
							      	         <input  type="radio" id="yesPay" name="paymentAnswer" value="YES">
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
							  <%-- <select class="form-control" name="paymentMode"  theme="css_xhtml" headerKey="0" headerValue="Select Payment Mode"
													style="width:250px; height:35px">
											<option>Cheque</option>
											<option>Cash</option> 
											</select> --%>  <!--  -->
											<s:select list="payModeList" name="paymentMode" id="itemId"
													theme="css_xhtml" headerKey="-1" headerValue="Select Payment Mode"
													style="width:250px; height:35px;" />
							        </div>
							        </div>
							        </s:iterator> 
							  </div>
							  </div>      
							       <!-- </div>  -->
<!--*******************************************End of payment area********************************************** -->
				<div class="form-group">
								<div class="col-md-4 col-sm-4"
									style="margin-left: 5px; margin-bottom: 10px;margin-top:15px;">
									<a href="invoiceDashbord"><input type="button" class="btn btn-default" value="Cancel"></a>
									&nbsp;
									<!-- <a href="addSalesDetails"><input type="button" class="btn btn-default" value="Sava"></a> -->
									<s:submit cssClass="btn btn-primary" value="Save"
										theme="simple" />

								</div>
								<div class="col-md-3 col-sm-3"></div>


							</div>
				  
			
<!--*******************************************End of button area********************************************** -->			
</s:iterator>  
							
				</s:form>					
							</div><!-- end panel body -->
							</div><!--*End of outer panel default**** -->
							
			</div>
			   
			</div><!--****End of outer container**** -->
					 			    
	</div>	
</div>	
	</div>		     
		 </div>
	 				    
	</div>	
</div>	 

	
<script type="text/javascript">

	var frmvalidator = new Validator("addSales");
	frmvalidator.EnableOnPageErrorDisplay();
	frmvalidator.EnableMsgsTogether(); 
	
	if(document.getElementById("termsId").checked==true){
	
	//validations for phoneNo
	frmvalidator.addValidation("phoneNo", "req", " Enter your phone number ");                                
	frmvalidator.addValidation("phoneNo", "maxlen=15",
			"Maximun Length of Phone Number  is 15");
	
	//validations for address
	frmvalidator.addValidation("address", "req", " Enter your address");
	frmvalidator.addValidation("address", "maxlen=50",
			"Maximun Length of Address  is 10");
	
	}else if(document.getElementById("termsId1").checked==true){
	
	//validations for  Consumer
	frmvalidator.addValidation("phoneNoConsumer", "req", " Enter your phone number ");                                
	frmvalidator.addValidation("phoneNoConsumer", "maxlen=50",
			"Maximun Length of phoneNo Consumer  is 15");
	
	

	//validations for address Consumer
	frmvalidator.addValidation("addressConsumer", "req", " Enter your address ");                                
	frmvalidator.addValidation("addressConsumer", "maxlen=50",
			"Maximun Length of address Consumer  is 15");
	
	
	
	}
	/*  var sfrmvalidator = new Validator("addSalesDetails");
	sfrmvalidator.EnableOnPageErrorDisplay();
	sfrmvalidator.EnableMsgsTogether(); 
	 */
	/*   frmvalidator.addValidation("itemCode", "req",
	"Please insert Code");
	 frmvalidator.addValidation("purchaseunit", "req",
	"Please enter number of unit");
	 frmvalidator.addValidation("unitprice", "req",
	"Please insert Unit Price");
	 frmvalidator.addValidation("itemName", "req",
	"Please insert Name");
	 frmvalidator.addValidation("account", "dontselect=-1",
		"Please select account");
	  */
	/* sfrmvalidator.addValidation("salesItemCode", "req",
	"Please insert Code");
	sfrmvalidator.addValidation("salseUnit", "req",
	"Please enter number of unit");
	sfrmvalidator.addValidation("salseunitprice", "req",
	"Please insert Unit Price");
	sfrmvalidator.addValidation("salseaccount", "dontselect=-1", 
	"Please select account");
	sfrmvalidator.addValidation("salsetaxrate", "req",
	"Please insert taxrate");
	sfrmvalidator.addValidation("salesdescription", "req",
	"Please insert description"); */
	/* 
	frmvalidator.addValidation("salesDate", "req","Please select date"); */
	
	/* frmvalidator.addValidation("currencyId", "dontselect=-1","Please select Currency");

	frmvalidator.addValidation("clientId", "dontselect=-1","Please select client "); */

	frmvalidator.addValidation("itemId", "dontselect=-1","Please select Item");

	frmvalidator.addValidatin("itemQuantity", "req","Please insert Quantity");

	frmvalidator.addValidation("itemTax", "dontselect=-1","Please select Tax");

</script>
</body>
</html>