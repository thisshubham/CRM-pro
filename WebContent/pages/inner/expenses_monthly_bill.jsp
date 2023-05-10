<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="/struts-jquery-tags" prefix="sj"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

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
</script>

<style type="text/css">
.error_strings {
	color: red;
}
</style>
<script type="text/javascript" src="inner/assets/js/modal.js"></script>
<script type="text/javascript">
	var xmlhttp;
	if (window.XMLHttpRequest) {
		xmlhttp = new XMLHttpRequest();
	} else {
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}

	/* This function will insert the social site value into database */
	function addSocialSite() {

		var socialSiteId = document.getElementById("addSocialSite1").value;
		var socialSiteValue = document.getElementById("socialId").value;

		/* alert(socialSiteId);
		alert(socialSiteValue); */
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				document.insertSocialSite("server1Response").innerHTML = xmlhttp.responseText;
			}
		};
		xmlhttp.open("GET", "addSocialSiteAction.action?socialSiteId="
				+ socialSiteId + "&socialSiteValue=" + socialSiteValue, true);
		xmlhttp.send();
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

				var array_element = "<div class='col-md-2 col-sm-2'  style='margin-left:-5px; padding:2px; margin-left:-2px;'><input type='text' style='width:124px; height:35px'  name='DeptPlace"+adv+"'  placeholder='Description' readonly='true'/></div>";

				array_element += "<div class='col-md-2 col-sm-2' style='padding:2px;' id='productDescription' ><input type='text' style='width:124px; height:35px'  name='itemDescription'  placeholder='Description' readonly='true'/></div>";

				array_element += "<div class='col-md-2 col-sm-2' style='padding:2px;'><input type='text' style='width:124px; height:35px' value='0' name='itemQuantity' id='itemQuantity1"
						+ adv
						+ "' placeholder='Quantity' onkeypress='return isNumber(event)'/></div>";
				array_element += "<div class='col-md-2 col-sm-2' style='padding:2px;' id='productPrice"+adv+"'><input type='text' style='width:124px; height:35px' value='0' name='itemPrice' id='price1' placeholder='Price' readonly='true'/></div>";

				array_element += "<div class='col-md-2 col-sm-2' style='padding:2px;'><select style='width:118px; height:35px' id='itemTax"+adv+"'  name='itemTax'>";
				array_element += "<option  value='0'>Select Tax</option>";

				array_element += "</select></div>";

				array_element += "<div class='col-md-2 col-sm-2' style='padding:2px;' id='amountId"+adv+"'><input type='text' value='0' style='width:120px; height:35px' name='amount'  placeholder='Amount' readonly='true'/>";
				/* array_element += "<a><img src='images/CANCEL.PNG'  onclick='removeRow(this)'></a><div>"; */

				div.innerHTML = array_element;

			}
		};

		xmlhttp.open("GET", "productListJASON.action", true);

		xmlhttp.send();

	}
</script>

<script language="javascript" type="text/javascript">
	var NumOfRow = 1;
	var newDiv;
	function Button1_onclick() {
		NumOfRow++;
		// get the refference of the main Div
		var mainDiv = document.getElementById('MainDiv');

		// create new div that will work as a container
		newDiv = document.createElement('div');
		newDiv.setAttribute('id', 'innerDiv' + NumOfRow);

		// create new textbox for email entry
		var newTextBox = document.createElement('input');
		newTextBox.type = 'text';
		newTextBox.name = 'hotel';
		newTextBox.style = 'border-radius: 0px';
		newTextBox.placeholder = 'Hotel';
		newTextBox.setAttribute('id', 'txtAddr' + NumOfRow);

		// create new textbox for email entry
		var newTextBox1 = document.createElement('input');
		newTextBox1.type = 'text';
		newTextBox1.name = 'place';
		newTextBox1.style = 'border-radius: 0px';
		newTextBox1.placeholder = 'Place';
		newTextBox1.setAttribute('id', 'txtAddr1' + NumOfRow);

		// create new textbox for email entry
		var newTextBox2 = document.createElement('input');
		newTextBox2.type = 'text';
		newTextBox2.name = 'from';
		newTextBox2.style = 'border-radius: 0px';
		newTextBox2.placeholder = 'From';
		newTextBox2.setAttribute('id', 'txtAddr2' + NumOfRow);

		// create new textbox for email entry
		var newTextBox3 = document.createElement('input');
		newTextBox3.type = 'text';
		newTextBox3.name = 'to';
		newTextBox3.style = 'border-radius: 0px';
		newTextBox3.placeholder = 'To';
		newTextBox3.setAttribute('id', 'txtAddr3' + NumOfRow);

		// create new textbox for email entry
		var newTextBox4 = document.createElement('input');
		newTextBox4.type = 'text';
		newTextBox4.name = 'billNo';
		newTextBox4.style = 'border-radius: 0px';
		newTextBox4.placeholder = 'Bill No.';
		newTextBox4.setAttribute('id', 'txtAddr4' + NumOfRow);

		// create new textbox for email entry
		var newTextBox5 = document.createElement('input');
		newTextBox5.type = 'text';
		newTextBox5.name = 'amountForA';
		newTextBox5.style = 'border-radius: 0px';
		newTextBox5.placeholder = 'Amount';
		newTextBox5.setAttribute('id', 'txtAddr5' + NumOfRow);

		// create remove button for each email adress
		var newButton = document.createElement('input');
		newButton.type = 'button';
		newButton.style = 'background-color:Red';

		newButton.value = 'Remove';
		newButton.id = 'btn' + NumOfRow;

		// atach event for remove button click
		newButton.onclick = function RemoveEntry() {
			var mainDiv = document.getElementById('MainDiv');
			mainDiv.removeChild(this.parentNode);
		}

		// append the span, textbox and the button

		newDiv.appendChild(newTextBox);
		newDiv.appendChild(newTextBox1);
		newDiv.appendChild(newTextBox2);
		newDiv.appendChild(newTextBox3);
		newDiv.appendChild(newTextBox4);
		newDiv.appendChild(newTextBox5);
		newDiv.appendChild(newButton);

		// finally append the new div to the main div
		mainDiv.appendChild(newDiv);

	}
</script>

<script language="javascript" type="text/javascript">
	var NumOfRow = 1;
	var newDiv;
	var arrayOption = ["SELECT TRAVEL MODE","1","2","3"];
	function Button2_onclick() {
		NumOfRow++;
		// get the refference of the main Div
		var mainDiv = document.getElementById('MainDiv1');

		// create new div that will work as a container
		newDiv = document.createElement('div');
		newDiv.setAttribute('id', 'innerDiv' + NumOfRow);

		// create new textbox for email entry
		var newTextBox = document.createElement('input');
		newTextBox.setAttribute('name', 'departurePlace' + NumOfRow);
		newTextBox.type = 'text';
		newTextBox.name = 'departurePlace';
		newTextBox.style = 'border-radius: 0px';
		newTextBox.placeholder = 'S.No.';

		newTextBox.setAttribute('id', 'txtAddr' + NumOfRow);
		newTextBox.setAttribute('name', 'txtAddr' + NumOfRow);

		// create new textbox for email entry
		var newTextBox1 = document.createElement('input');
		newTextBox1.type = 'text';
		newTextBox1.name = 'departureDate';
		newTextBox1.style = 'border-radius: 0px';
		newTextBox1.placeholder = 'Item';
		newTextBox1.setAttribute('id', 'txtAddr1' + NumOfRow);

		// create new textbox for email entry
		var newTextBox2 = document.createElement('input');
		newTextBox2.type = 'text';
		newTextBox2.name = 'arrivalPlace';
		newTextBox2.style = 'border-radius: 0px';
		newTextBox2.placeholder = 'Color Code';
		newTextBox2.setAttribute('id', 'txtAddr2' + NumOfRow);

		// create new textbox for email entry
		var newTextBox3 = document.createElement('input');
		newTextBox3.type = 'text';
		newTextBox3.name = 'arrivalDate';
		newTextBox3.style = 'border-radius: 0px';
		newTextBox3.placeholder = 'Quentity';
		newTextBox3.setAttribute('id', 'txtAddr3' + NumOfRow);
		
		
		 // create new textbox for email entry
		var newTextBox4 = document.createElement('input');
		newTextBox4.type = 'text';
		newTextBox4.name = 'arrivalDate';
		newTextBox4.style = 'border-radius: 0px';
		newTextBox4.placeholder = 'Price';
		newTextBox4.setAttribute('id', 'txtAddr3' + NumOfRow);

		/*// create new textbox for email entry
		var selectList = document.createElement('select');
		selectList.style = 'border-radius: 0px';
		selectList.name = 'travelMode';

		selectList.setAttribute('id', 'txtAddr4' + NumOfRow);

		for ( var i = 0; i < arrayOption.length; i++) {
			var option = document.createElement("option");
			option.value = arrayOption[i];
			option.text = arrayOption[i];
			selectList.appendChild(option);
		} */

		// create new textbox for email entry
		var newTextBox5 = document.createElement('input');
		newTextBox5.type = 'text';
		newTextBox5.name = 'hotelAmount';
		newTextBox5.style = 'border-radius: 0px';
		newTextBox5.placeholder = 'Amount';
		newTextBox5.setAttribute('id', 'txtAddr5' + NumOfRow);

		// create remove button for each email adress
		var newButton = document.createElement('input');
		newButton.type = 'button';
		newButton.value = 'Remove';
		newButton.style = 'background-color:Red';
		newButton.id = 'btn' + NumOfRow;

		// atach event for remove button click
		newButton.onclick = function RemoveEntry1() {
			var mainDiv = document.getElementById('MainDiv1');
			mainDiv.removeChild(this.parentNode);
			var str = document.getElementsByName('txtAddr' + NumOfRow)[NumOfRow].value;

			alert(str);

		}

		// append the span, textbox and the button

		newDiv.appendChild(newTextBox);
		newDiv.appendChild(newTextBox1);
		newDiv.appendChild(newTextBox2);
		newDiv.appendChild(newTextBox3);
		newDiv.appendChild(newTextBox4);
		newDiv.appendChild(newTextBox5);
		newDiv.appendChild(newButton);

		// finally append the new div to the main div
		mainDiv.appendChild(newDiv);

	}
</script>


<sj:head />
<body>

	<div id="content">
		<div class="outer">
			<div class="inner bg-light lter">

				<!--BEGIN INPUT TEXT FIELDS-->
				<div class="row">
					<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
						<ol class="breadcrumb" style="margin-top: 10px;">
							<li><a href="#">Home</a></li>
							<li><a href="#">Expenses</a></li>
							<li class="active">Tour</li>
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
									<s:text name="Tour Expenses" />
								</h5>
							</div>
							<div class="pull-right">


								<a href="leadDashboard.action" data-toggle="tooltip"
									data-original-title="Close" data-placement="bottom"
									class="btn btn-danger btnheight "> <i class="fa fa-times"></i></a>

							</div>

							</header>
							<s:form action="addExpensesTourDetails.action" method="POST" name="expensesDetailForm">
								<div class="container-fluid">

									<div class="alert alert-info" role="alert"
										style="margin-top: 25px; margin-left: 5px; margin-right: 5px;">

										<p>
											<s:if test="hasActionErrors()">
											</s:if>
											<s:elseif test="hasActionMessages()">
												<s:actionmessage />
											</s:elseif>
											<s:else>

												<div class="infoIcon">
													<span class="fa fa-info" style="margin-left: 3px;"></span>
												</div>&nbsp;&nbsp;&nbsp;<s:text
													name="You can add your new expenses " />
											</s:else>
										</p>
									</div>


									<div class="panel panel-default">
										<div class="panel-body">



											<div class="row">
												<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
													<div class="row form-group">
														<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
															<s:text name="Name" />
															<div class="star">*</div>
														</div>

														<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">

															<s:textfield type="text" name="name"
																class="form-control" cssClass="form-control"
																tabindex="1" />
															<div id='addCreatedLeadForm_leadDate_errorloc'
																class="error_strings"></div>
														</div>
													</div>
												</div>
												<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
													<div class="row form-group">
														<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
															<s:text name="Voucher No." />
															<div class="star">*</div>
														</div>

														<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">

															<s:textfield type="text" name="placeOfVisit"
																class="form-control" cssClass="form-control"
																tabindex="2" />
															<div id='addCreatedLeadForm_leadDate_errorloc'
																class="error_strings"></div>
														</div>
													</div>
												</div>
											</div>


											<div class="row">

												<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
													<div class="row form-group">
														<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
															<s:text name="Material" />
															<div class="star">*</div>
														</div>

														<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">



															<s:textfield type="text" name="purposeOfVisit"
																cssClass="form-control" tabindex="3" />
															<div id='addCreatedLeadForm_expectedClosingDate_errorloc'
																class="error_strings"></div>
														</div>
													</div>
												</div>
												<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
													<div class="row form-group">
														<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
															<s:text name="Sales Date" />
															<div class="star">*</div>
														</div>

														<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
															<sj:datepicker name="departureDate" changeMonth="true"
																changeYear="true" showAnim="slideDown" duration="fast"
																yearRange="1950:2050" showOn="focus" size="35%"
																timepicker="true" timepickerShowSecond="true"
																timepickerFormat="hh:mm:ss" displayFormat="yy-mm-dd"
																parentTheme="simple" cssClass="form-control" tabindex="4" />
														</div>


													</div>
												</div>

											</div>


											

										</div>
									</div>

									<div class="panel-group" id="accordion" role="tablist"
										aria-multiselectable="true">
										<div class="panel panel-default">
											<div class="panel-heading" role="tab" id="headingOne">
												<h4 class="panel-title">
													<a data-toggle="collapse" data-parent="#accordion"
														href="#collapseOne" aria-expanded="true"
														aria-controls="collapseOne"> Sales Detailes</a>
												</h4>
											</div>
											<div id="collapseOne" class="panel-collapse collapse in"
												role="tabpanel" aria-labelledby="headingOne">
												<div class="panel-body">

													<div id="MainDiv1">

														<s:textfield id="txtAddr1" type="text" name="departurePlace"
															placeholder="S.No." style="border-radius:0px;" />

														<s:textfield id="txtAddr2" type="text" name="departureDate"
															placeholder="Item"
															style="margin-left:-4px;border-radius:0px;" />
														<s:textfield id="txtAddr2" type="text" name="arrivalPlace"
															placeholder="Color Code"
															style="margin-left:-4px;border-radius:0px;" />
														<s:textfield id="txtAddr2" type="text" name="arrivalDate"
															placeholder="Quantity"
															style="margin-left:-4px;border-radius:0px;" />
															<s:textfield id="txtAddr2" type="text" name="arrivalDate"
															placeholder="Price"
															style="margin-left:-4px;border-radius:0px;" />
														


														<s:textfield id="txtAddr2" type="text"
															placeholder="Amount" name="amountForA"
															style="margin-left:-4px;border-radius:0px;" />
														<input id="Button1" type="button" value="Add More"
															onclick="Button2_onclick()"
															style="background-color: #87c134;" />
													</div>
													<hr>
													<div class="row">
														<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
															<div class="row form-group">
																<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
																	<%-- <s:text name="H. Total Expenses" /> --%>
																	<div class="star"></div>
																</div>
																<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
																	<h5>
																		<b>Total (A)</b>
																	</h5>
																</div>

																<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">

																	<s:textfield type="text" name="totalAmountA"
																		class="form-control" cssClass="form-control"
																		/>
																	<div id='addCreatedLeadForm_leadDate_errorloc'
																		class="error_strings"></div>
																</div>
															</div>
														</div>
													</div>





												</div>
											</div>
										</div>


									</div>

									

								</div>




								<!-- Third tab ********************************************************************************************************************** -->


								<%-- <div class="panel panel-default">
									<div class="panel-body">

										<div class="row">
											<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
														<s:text
															name="C. Daily Allowance (for Foodstuff) As Per Travel Policy" />
														<div class="star">*</div>
													</div>

													<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12"></div>
													<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">

														<s:textfield type="text" name="cDailyAllowance"
															class="form-control"  cssClass="form-control"
															tabindex="6" />
														<div id='addCreatedLeadForm_leadDate_errorloc'
															class="error_strings"></div>
													</div>
												</div>
											</div>
										</div>



										<div class="row">
											<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
														<s:text
															name="D. Conveyance Expenses (fill In Conveyence Sheet ) & Taxi Bill Is Must" />
														<div class="star">*</div>
													</div>
													<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12"></div>

													<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">

														<s:textfield type="text" name="dConveynanceEx"
															class="form-control"  cssClass="form-control"
															tabindex="7" />
														<div id='addCreatedLeadForm_leadDate_errorloc'
															class="error_strings"></div>
													</div>
												</div>
											</div>
										</div>

										<div class="row">
											<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
														<s:text
															name="E. Conveyance Expenses (taxi Bill Paid By Other Branch)" />
														<div class="star">*</div>
													</div>

													<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12"></div>

													<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">

														<s:textfield type="text" name="eConveynanceEx"
															class="form-control"  cssClass="form-control"
															tabindex="8" />
														<div id='addCreatedLeadForm_leadDate_errorloc'
															class="error_strings"></div>
													</div>


												</div>
											</div>
										</div>

										<div class="row">
											<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
														<s:text name="F. Laundry Expenses" />
														<div class="star">*</div>
													</div>

													<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12"></div>

													<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">

														<s:textfield type="text" name="fLaundryExpences"
															class="form-control"  cssClass="form-control"
															tabindex="9" />
														<div id='addCreatedLeadForm_leadDate_errorloc'
															class="error_strings"></div>
													</div>
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
														<s:text
															name="G. Other Expenses (fill In Other Expenses Sheet) Bills To Be Enclosed" />
														<div class="star">*</div>
													</div>
													<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12"></div>

													<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">

														<s:textfield type="text" name="gOtherExpenses"
															class="form-control"  cssClass="form-control"
															tabindex="10" />
														<div id='addCreatedLeadForm_leadDate_errorloc'
															class="error_strings"></div>
													</div>
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
														<s:text name="H. Total Expenses" />
														<div class="star">*</div>
													</div>
													<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
														<h5>
															<b>Total (A) To (F)</b>
														</h5>
													</div>

													<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">

														<s:textfield type="text" name="hTotalExpensesATOF"
															class="form-control"  cssClass="form-control"
															  />
														<div id='addCreatedLeadForm_leadDate_errorloc'
															class="error_strings"></div>
													</div>
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
														&nbsp;&nbsp;
														<s:text
															name="1. Advance Received (only After Approval By Hod)" />
														<div class="star">*</div>
													</div>
													<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12"></div>

													<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">

														<s:textfield type="text" name="oneAdvanceReceived"
															class="form-control"  cssClass="form-control"
															tabindex="11" />
														<div id='addCreatedLeadForm_leadDate_errorloc'
															class="error_strings"></div>
													</div>
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
														&nbsp;&nbsp;
														<s:text
															name="2. If Ticket Booked By Company (pls. Enter The Amt.)" />
														<div class="star">*</div>
													</div>

													<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12"></div>

													<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">

														<s:textfield type="text" name="twoTicketBookedByCompany"
															class="form-control"  cssClass="form-control"
															tabindex="12" />
														<div id='addCreatedLeadForm_leadDate_errorloc'
															class="error_strings"></div>
													</div>
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
														&nbsp;&nbsp;
														<s:text
															name="3. If Hotel Booked By Company (pls. Enter The Amount)" />
														<div class="star">*</div>
													</div>

													<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12"></div>

													<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">

														<s:textfield type="text" name="threeHotelBookedByCompany"
															class="form-control"  cssClass="form-control"
															tabindex="13" />
														<div id='addCreatedLeadForm_leadDate_errorloc'
															class="error_strings"></div>
													</div>
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
														&nbsp;&nbsp;
														<s:text
															name="4. Conveyance Expenses (taxi Bill Paid By Other Branch)" />
														<div class="star">*</div>
													</div>

													<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12"></div>

													<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">

														<s:textfield type="text" name="forthConveyanceExpenses"
															class="form-control"  cssClass="form-control"
															tabindex="14" />
														<div id='addCreatedLeadForm_leadDate_errorloc'
															class="error_strings"></div>
													</div>
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
														&nbsp;&nbsp;
														<s:text name="5. advance received from other branches" />
														<div class="star">*</div>
													</div>

													<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12"></div>

													<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">

														<s:textfield type="text" name="fiveAdvanceReceivedFromOther"
															class="form-control"  cssClass="form-control"
															tabindex="15" />
														<div id='addCreatedLeadForm_leadDate_errorloc'
															class="error_strings"></div>
													</div>
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
														<s:text name="" />
														<div class="star">*</div>
													</div>

													<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12"></div>

													<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">

														<s:textfield type="text" name="leadDate"
															class="form-control"  cssClass="form-control"
															tabindex="16" />
														<div id='addCreatedLeadForm_leadDate_errorloc'
															class="error_strings"></div>
													</div>
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
														<s:text name="" />
														<div class="star">*</div>
													</div>

													<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12"></div>

													<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">

														<s:textfield type="text" name="leadDate"
															class="form-control"  cssClass="form-control"
															tabindex="17" />
														<div id='addCreatedLeadForm_leadDate_errorloc'
															class="error_strings"></div>
													</div>
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
														<s:text name="H. Total Advance" />
														<div class="star">*</div>
													</div>


													<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12"></div>

													<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">

														<s:textfield type="text" name="leadDate"
															class="form-control"  cssClass="form-control"
															tabindex="18"  />
														<div id='addCreatedLeadForm_leadDate_errorloc'
															class="error_strings"></div>
													</div>
												</div>
											</div>
										</div> --%>
										<hr>
										<div class="row">
											<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"
												align="center">
												<a href="leadDashboard.action" data-toggle="tooltip"
													data-original-title="Back To Lead DashBoard"
													class="btn btn-default" ontheme="simple" tabindex="19"><s:text
														name="project.form.button.cancel" /> </a>

												<s:reset cssClass="btn btn-success"
													key="project.form.button.reset" theme="simple"
													onclick="window.location.reload();" tabindex="20" />

												<s:submit cssClass="btn btn-primary"
													key="project.form.button.submit" theme="simple"
													tabindex="21" />

											</div>
										</div>




									
							</s:form>

							<%-- <div class="panel panel-default">
									<div class="panel-body">
										<h5>Office Use</h5>

										<div class="row">
											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
														<s:text name="Approved By" />
														<div class="star">*</div>
													</div>

													<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">

														<s:textfield type="text" name="leadDate"
															class="form-control"  cssClass="form-control"
															tabindex="14" />
														<div id='addCreatedLeadForm_leadDate_errorloc'
															class="error_strings"></div>
													</div>
												</div>
											</div>
											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
														<s:text name="Clamed By" />
														<div class="star">*</div>
													</div>

													<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">



														<s:textfield type="text" name="expectedClosingDate"
															cssClass="form-control" id="dp4" tabindex="15" />
														<div id='addCreatedLeadForm_expectedClosingDate_errorloc'
															class="error_strings"></div>
													</div>
												</div>
											</div>
										</div>

										<div class="row">
											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
														<s:text name="Designation" />
														<div class="star">*</div>
													</div>

													<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">

														<s:textfield type="text" name="leadDate"
															class="form-control"  cssClass="form-control"
															tabindex="14" />
														<div id='addCreatedLeadForm_leadDate_errorloc'
															class="error_strings"></div>
													</div>
												</div>
											</div>
											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
														<s:text name="Current Date" />
														<div class="star">*</div>
													</div>

													<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">



														<s:textfield type="text" name="expectedClosingDate"
															cssClass="form-control" id="dp4" tabindex="15" />
														<div id='addCreatedLeadForm_expectedClosingDate_errorloc'
															class="error_strings"></div>
													</div>
												</div>
											</div>
										</div>

										<div class="row">
											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
														<s:text name="Status" />
														<div class="star">*</div>
													</div>

													<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">

														<s:textfield type="text" name="leadDate"
															class="form-control"  cssClass="form-control"
															tabindex="14" />
														<div id='addCreatedLeadForm_leadDate_errorloc'
															class="error_strings"></div>
													</div>
												</div>
											</div>
											<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
												<div class="row form-group">
													<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
														<s:text name="Comment" />
														<div class="star">*</div>
													</div>

													<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">



														<s:textfield type="text" name="expectedClosingDate"
															cssClass="form-control" id="dp4" tabindex="15" />
														<div id='addCreatedLeadForm_expectedClosingDate_errorloc'
															class="error_strings"></div>
													</div>
												</div>
											</div>

											<hr>
											<div class="row">
												<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"
													align="center">
													<a href="leadDashboard.action" data-toggle="tooltip"
														data-original-title="Back To Lead DashBoard"
														class="btn btn-default" ontheme="simple" tabindex="38"><s:text
															name="project.form.button.cancel" /> </a>

													<s:reset cssClass="btn btn-success"
														key="project.form.button.reset" theme="simple"
														onclick="window.location.reload();" tabindex="39" />

													<s:submit cssClass="btn btn-primary"
														key="project.form.button.submit" theme="simple"
														tabindex="40" />

												</div>
											</div>


										</div>

									</div>
								</div> --%>

						</div>
					</div>
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
	<script src="/outer/js/gen_validatorv4.js" type="text/javascript"></script>
	<%-- <script type="text/javascript">
		var frmvalidator = new Validator("#");
		frmvalidator.EnableOnPageErrorDisplay();
		frmvalidator.EnableMsgsTogether();

		//Validation for Company Name. 
		frmvalidator.addValidation("companyName", "maxlen=50",
				"Company Name Should Be 50 Characters");

		//Validation for Contact Person.
		frmvalidator.addValidation("contactPerson", "req",
				"Enter Contact Person Name");
		frmvalidator.addValidation("contactPerson", "maxlen=50",
				"Contact Person Name Should Be 50 Characters");

		frmvalidator.addValidation("salutation", "dontselect=8",
				"Select Salutation");
		//Validation for Lead Title. 
		frmvalidator.addValidation("leadTitle", "dontselect=-1",
				"Select Lead Title");

		//validation for Company Type. 
		frmvalidator.addValidation("companyType", "dontselect=-1",
				"Select Company Type");

		//validation for Company Category. 
		frmvalidator.addValidation("companyCategory", "dontselect=-1",
				"Select Company Category");

		//validation for Company Sector. 
		frmvalidator.addValidation("companySector", "dontselect=-1",
				"Select Company Sector");

		//validation for Source Name. 
		frmvalidator.addValidation("leadSource", "dontselect=-1",
				"Select Lead Source");

		//Validation for Lead Source Name. 
		frmvalidator.addValidation("leadSourceName", "maxlen=50",
				"Lead Source Name Should Be 50 Characters");

		//Validation for Number of associates.
		frmvalidator.addValidation("noOfAssociate", "numeric",
				"Number Of Associate Must Be Digits");
		frmvalidator.addValidation("noOfAssociate", "maxlen=6",
				"No. Of Associates Should Be 6 Digits");

		//Validation for Lead Date. 
		frmvalidator.addValidation("leadDate", "req", "Select Lead Date");

		//Validation for Lead Owner. 
		frmvalidator.addValidation("leadOwnerId", "dontselect=-1",
				"Select Lead Owner");

		//validation for Address Line 1.
		frmvalidator.addValidation("addressLine1", "maxlen=100",
				"Address Line 1 Should Be 100 Characters");

		//validation for Address Line 2.
		frmvalidator.addValidation("addressLine2", "maxlen=100",
				"Address Line 2 Should Be 100 Characters");

		//validation for City.
		frmvalidator.addValidation("city", "maxlen=50",
				"City Should Be 50 Characters");

		//validation for State.
		frmvalidator.addValidation("state", "maxlen=100",
				"State Should Be 100 Characters");

		//validation for Country.
		frmvalidator.addValidation("country", "dontselect=-1",
				"Select Country Name");

		//validation for Primary Email Id. 

		frmvalidator.addValidation("primaryEmailId", "email",
				"Enter Valid Email Address");
		frmvalidator.addValidation("primaryEmailId", "maxlen=100",
				"Email Id Should Be 100 Characters");

		//validation for Alternate Email Id.
		frmvalidator.addValidation("alternateEmailId", "email",
				"Enter Valid Email Address");
		frmvalidator.addValidation("alternateEmailId", "maxlen=100",
				"Email Id Should Be 100 Characters");

		//validation for Phone Number.
		frmvalidator.addValidation("phoneNo", "maxlen=8",
				"Phone Number Should Be 8 Digits");
		frmvalidator.addValidation("phoneNo", "numeric",
				"Phone Number Must Be Digits");

		//validation for Mobile Number.
		frmvalidator.addValidation("mobileNo", "maxlen=10",
				"Mobile Number Should Be 10 Digits");
		frmvalidator.addValidation("mobileNo", "numeric",
				"Mobile Number Must Be Digits");

		//validation for Fax number.
		frmvalidator.addValidation("fax", "req", "Fax Number requeri");
		frmvalidator.addValidation("fax", "numeric",
				"Fax Number Must Be Digits");
		frmvalidator.addValidation("fax", "maxlen=8",
				"Fax Number Should Be 8 Digits");

		//validation for Mobile Number.
		frmvalidator.addValidation("requirment", "maxlen=4000",
				"Requirement Should Be 4000 Charecter");

		//lead date and expected closing date difference validation 
		function DoCustomValidation() {
			var frm1 = document.forms["addCreatedLeadForm"];
			var ndate = frm1.leadDate.value;
			var ndate1 = frm1.expectedClosingDate.value;
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
			if (d1 <= d2) {
				return true;
			} else {

				sfm_show_error_msg(
						"Expected Closing Date Should be Greater Than Lead Date",
						frm1.expectedClosingDate);
				return false;
			}
		}

		frmvalidator.setAddnlValidationFunction(DoCustomValidation);
	</script> --%>
</body>
</html>