<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="/struts-jquery-tags" prefix="sj"%>
<html lang="en">
<head>
<sj:head />
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description"
	content="Vanra CRM - A complete free online solution for Customer Relationship Management.">
<meta name="author" content="JobSarthi User">

<title><s:text name="customer.registraton.title" /></title>

<!-- Bootstrap Core CSS -->
<link rel="stylesheet" href="outer/css/bootstrap.min.css"
	type="text/css">

<!-- Custom Fonts -->
<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800'
	rel='stylesheet' type='text/css'>
<link
	href='http://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic,900,900italic'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet"
	href="outer/font-awesome/css/font-awesome.min.css" type="text/css">

<!-- Plugin CSS -->
<link rel="stylesheet" href="outer/css/animate.min.css" type="text/css">

<!-- Custom CSS -->
<link rel="stylesheet" href="outer/css/creative.css" type="text/css">
<link rel="shortcut icon" href="outer/img/vanra_icon.png"
	type="image/x-icon" />


<script type="text/javascript">
	function reloadCaptcha() {
		var d = new Date();
		$("#captcha").attr("src", "simpleCaptcha.jpg?" + d.getTime());
	}
</script>

<!-- Script for ajax call for email or mobile no -->
<script type="text/javascript">
	var xmlhttp;
	if (window.XMLHttpRequest) {
		xmlhttp = new XMLHttpRequest();
	} else {
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}

	/* This function will check the existing email id */
	function isEmailIdExist(companyEmailId) {
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				document.getElementById("server1Response").innerHTML = xmlhttp.responseText;
			}
		};
		xmlhttp.open("GET", "isEmailIdExists.action?companyEmailId="
				+ companyEmailId, true);
		xmlhttp.send();
	}

	/* This function will check the existing Mobile */
	function isMobileNoExists(mobileNo) {

		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				document.getElementById("server2Response").innerHTML = xmlhttp.responseText;
			}
		};
		xmlhttp.open("GET", "isMobileNoExists.action?mobileNo=" + mobileNo,
				true);
		xmlhttp.send();
	}
</script>
<!-- / Script for ajax call for email or mobile no -->


<!-- Script for refreshing the captcha image  -->
<script type="text/javascript">
	function closeRegistration() {

		location.href = "outer/index.jsp";
	};
</script>
<!-- / Script for refreshing the captcha image  -->

<!-- Script for check box that make disabled or enable submit button   -->
<SCRIPT type=text/JavaScript>
	function checkCheckBox(f) {
		if (f.agree.checked == false) {
			alert('Please agree the terms& conditions to continue.');
			return false;
		} else
			return true;
	}
	//
</SCRIPT>
<script type="text/javascript">
	$(function() {
		$('#regId').attr('disabled', 'disabled');

		$("#termsId").change(function() {
			if ($(this).is(":checked")) {
				$('#regId').removeAttr("disabled");
			} else {
				$('#regId').attr('disabled', 'disabled');
			}
		});
	});
</script>

<!-- / Script for check box that make disabled or enable submit button   -->

</head>

<body id="page-top" style="height: 120%">





	<nav id="mainNav" class="navbar navbar-default navbar-fixed-top" style="background-color:black;">
		<!-- container-fluid Start Here -->
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<a class="navbar-brand page-scroll" href="outer/index.jsp" style="margin-top:-8px;">
				<img src="outer/images/trans_vanra.png"  alt=""  width="115px"></a>
			</div>
		</div>
		<!-- container-fluid End Here-->
	</nav>
	
	
	
	

	<header>
	
	
		<div class="header-content headerR">
		
		


			<s:form name="customerRegistrationForm" method="post"
				action="customerQuickRegistration" cssClass="form-horizontal"
				role="form" style="margin:3px;">
				<div class="header-content-inner">
					<div style="margin-top:120px"><img src="outer/images/trans_vanra.png" width="400px" alt="VANRA CRM" 
						 /></div>
					<h1 style= "margin-top:20px;">
						<s:text name="customer.registraton.heading" />
					</h1>
					<hr>
					<div class="panel panel-default" style="background-color:rgba(22, 23, 43, 0.20); /* */#311b92  */; border:none; height:470px; ">
						<div class="panel-body" >
							<b><p style="color:rgb(240,72,62)">

								<s:if test="hasActionErrors()">
									<s:actionerror />
								</s:if>
								<s:elseif test="hasActionMessages()" >
									<s:actionmessage />
								</s:elseif>
								<s:else>
									<s:text name="customer.registraton.information" />
								</s:else>

							</p></b>
							<p>
							<div class="row">

								<!-- 
						<div class="panel panel-default">
							<div class="panel-body"> -->
							
								<div class="col-md-3 col-sm-4 col-xs-12"></div>


								<!-- here edited -->
								<div class="col-md-6 col-sm-6 col-xs-12">
									<s:textfield name="fullName" id="fullName"
										cssClass="form-control"
										style="background:transparent; height:40px; font-size:20px; color:white; margin-top:10px;"
										placeholder="Enter Your fullName" theme="css_xhtml" />


								</div>
								<div class="col-xs-1"></div>
								<div id='customerRegistrationForm_fullName_errorloc'
									class="error_strings"
									style="color: #9EC4FF; text-align: left; margin-top: 20px;"></div>


								<!-- <div class="col-md-6 col-sm-6 col-xs-12">
							 <div id='customerRegistrationForm_fullName_errorloc'
								class="error_strings"
								style="color: #9EC4FF; text-align: left; margin-top: 20px;"></div> 
						</div>  -->
							</div>

							<div class="row">

								<div class="col-md-2 col-sm-3 col-xs-12"></div>
								<div class="col-md-1 col-sm-1 col-xs-12">
									<div id="server1Response" style="width: 10%; margin-top: 20px;"></div>
								</div>
								<div class="col-md-6 col-sm-6 col-xs-12">


									<s:textfield name="companyEmailId" id="companyEmailId"
										cssClass="form-control"
										style="background:transparent; height:40px; font-size:20px; color:white; margin-top:10px;"
										placeholder="Enter User E-mail" theme="css_xhtml"
										onblur="isEmailIdExist(companyEmailId.value);" />
								</div>
								<div class="col-xs-1"></div>
								<div id='customerRegistrationForm_companyEmailId_errorloc'
									class="error_strings"
									style="color: #9EC4FF; text-align: left; margin-top: 20px;"></div>
								<!-- <div class="col-md-6 col-sm-6 col-xs-12">
							<div id='customerRegistrationForm_companyEmailId_errorloc'
								class="error_strings"
								style="color: #9EC4FF; text-align: left; margin-top: 20px;"></div>
						</div> -->
							</div>

							<div class="row">
								<div class="col-md-2 col-sm-3 col-xs-12"></div>
								<div class="col-md-1 col-sm-1 col-xs-12">
									<div id="server2Response" style="width: 10%; margin-top: 20px;"></div>
								</div>
								<div class="col-md-6 col-sm-6 col-xs-12">


									<s:textfield name="mobileNo" cssClass="form-control"
										style="background:transparent; height:40px; font-size:20px; color:white; margin-top:10px;"
										placeholder="Enter Your Mobile No." theme="css_xhtml"
										onblur="isMobileNoExists(mobileNo.value);" onkeypress='return event.keyCode == 8 || event.charCode >= 48 && event.charCode <= 57'/>

								</div>
								<div class="col-xs-1"></div>
								<div id='customerRegistrationForm_mobileNo_errorloc'
									class="error_strings"
									style="color: #9EC4FF; text-align: left; margin-top: 20px;"></div>

								<!-- <div class="col-md-4 col-sm-4 col-xs-12">
							<div id='customerRegistrationForm_mobileNo_errorloc'
								class="error_strings"
								style="color: #9EC4FF; text-align: left; margin-top: 20px;"></div>
						</div> -->
							</div>

							<div class="row">
								<div class="col-md-3 col-sm-4 col-xs-12"></div>
								<div class="col-md-6 col-sm-6 col-xs-12">


									<s:textfield name="companyName" id="companyName"
										cssClass="form-control"
										style="background:transparent; height:40px; font-size:20px; color:white; margin-top:10px;"
										placeholder="Enter Your Company Name" theme="css_xhtml" />
								</div>
								<div class="col-xs-1"></div>
								<div id='customerRegistrationForm_companyName_errorloc'
									class="error_strings"
									style="color: #9EC4FF; text-align: left; margin-top: 20px;"></div>

								<!-- <div class="col-md-4 col-sm-4 col-xs-12">
							<div id='customerRegistrationForm_companyName_errorloc'
								class="error_strings"
								style="color: #9EC4FF; text-align: left; margin-top: 20px;"></div>
						</div> -->
							</div>

							<div class="row">
								<div class="col-md-3 col-sm-4 col-xs-12"></div>
								<div class="col-md-6 col-sm-6 col-xs-12">



									<s:select list="countryList" name="country" id="country"
										headerKey="-1" headerValue="Select Country" theme="css_xhtml"
										cssStyle="width: 100%; background:transparent; height:40px; font-size:20px; color:gray; borde-radious:8px; margin-top:10px;"
										cssClass="form-control" />

								</div>
								<div class="col-xs-1"></div>
								<div id='customerRegistrationForm_country_errorloc'
									class="error_strings"
									style="color: #9EC4FF; text-align: left; margin-top: 20px;"></div>
								<!-- <div class="col-md-4 col-sm-4 col-xs-12">
							<div id='customerRegistrationForm_country_errorloc'
								class="error_strings"
								style="color: #9EC4FF; text-align: left; margin-top: 20px;"></div>
						</div> -->
							</div>

							<div class="row">
								<div class="col-md-3 col-sm-4 col-xs-12"></div>
								<div class="col-md-1 col-sm-1 col-xs-2">
									<img alt="jobsarthi" src="outer/img/refresh.png" width=35px;
										height=35px; onclick="reloadCaptcha()"
										style="margin-top: 10px;" />
								</div>
								<div class="col-md-2 col-sm-3 col-xs-6">



									<label class=" control-label"
										style="width: 20%; float: left; color: red; font-size: 20px;">
										<img id="captcha" src="<s:url value='simpleCaptcha.jpg'/>"
										style="hight: 90px; margin-top: 10px; width: 130px; border: 5;" />

									</label>
								</div>

								<div class="col-xs-offset-2 col-sm-offset-5">
									<div class="col-md-5 col-sm-12 col-xs-12">

										<s:textfield name="answer" id="answer" class="form-control"
											placeHolder="Enter Captcha"
											style="background:transparent; height:40px;  font-size:20px; width:170px; color:white; margin-top:10px; margin-left:-30px;"
											cssClass="form-control" />
									</div>

								</div>

								<!-- <div id='customerRegistrationForm_answer_errorloc'
							class="error_strings"
							style="color: #9EC4FF; text-align: left; margin-top: 20px;"></div> -->


								<!-- <div class="col-md-4 col-sm-4 col-xs-12">
							<div id='customerRegistrationForm_answer_errorloc'
								class="error_strings"
								style="color: #9EC4FF; text-align: left; margin-top: 20px;"></div>
						</div> -->

								<div id='customerRegistrationForm_answer_errorloc'
									class="error_strings"
									style="color: #9EC4FF; text-align: left; margin-top: 20px;"></div>
							</div>
						</div>

						<div class="row">
							<div class="col-md-3 col-sm-3 col-xs-12"></div>
							<div class="col-md-6 col-sm-6 col-xs-12">

								<div class="row" style="margin-top: 1px;">
									<s:checkbox name="sell" id="termsId" />
									<s:text name="customer.registraton.agree" />
									<a href=""
										onclick="PopupCenter('termsAndcondition','Terms&Conditions',800,500);"
										style="color: #FFF;"> <s:text name="project.term.services" /></a>&nbsp;&amp;&nbsp;<a
										href=""
										onclick="PopupCenter('privacyPolicy','Privacy Policy',800,500);"
										style="color: #FFF;"><s:text name="project.privacy.policy" /></a>
								</div>
							</div>
							<div class="col-md-3 col-sm-3 col-xs-12"></div>
						</div>

						<div class="row">
							<div class="col-md-4 col-sm-4 col-xs-12"></div>
							<div class="col-md-4 col-sm-12 col-xs-12">


								<br /> <input type="button" id="cancelRegistration"
									Class="btn btn-default" name="cancel" value="Cancel"
									onclick="closeRegistration()"
									style="width: 120px; height: 48px;" /> &nbsp;&nbsp;

								<s:submit cssClass="btn btn-primary"
									key="project.form.button.submit" theme="simple" id="regId"
									style="width:120px; height:48px;" />


							</div>

							<div class="col-md-4 col-sm-4 col-xs-12"></div>
						</div> </div> </div>
			</s:form>
		</div>

	</header>
	

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


	<script src="outer/js/modal.js" type="text/javascript"></script>
	<script src="outer/js/bootstrap.js" type="text/javascript"></script>
	<script src="outer/js/jquery.min.js" type="text/javascript"></script>

	<script src="outer/js/gen_validatorv4.js" type="text/javascript"></script>
	<script type="text/javascript">
		//You should create the validator only after the definition of the HTML form
		var frmvalidator = new Validator("customerRegistrationForm");
		frmvalidator.EnableOnPageErrorDisplay();
		frmvalidator.EnableMsgsTogether();

		//validations for full Name
		frmvalidator.addValidation("fullName", "req", " Enter Your Full Name");
		frmvalidator.addValidation("fullName", "maxlen=100",
				"Maximun Length of Full Name is 100 Characters");

		//validations for companyName
		frmvalidator.addValidation("companyName", "req", " Enter Company Name");
		frmvalidator.addValidation("companyName", "maxlen=50",
				"Maximun Length of Company Name is 50 Characters");

		//validations for companyEmailId
		frmvalidator.addValidation("companyEmailId", "req", " Enter Email");
		frmvalidator.addValidation("companyEmailId", "email",
				" Enter Your Valid Email ID");
		frmvalidator.addValidation("companyEmailId", "maxlen=50",
				"Maximun Length of Primary Email id is 50 Characters");

		//validations for country
		frmvalidator.addValidation("country", "dontselect=-1",
				" Select Country");

		//validations for mobile
		frmvalidator.addValidation("mobileNo", "req", " Enter Mobile No");
		frmvalidator.addValidation("mobileNo", "num",
				" Enter Your Valid Mobile Number");
		frmvalidator.addValidation("mobileNo", "maxlen=10",
				"Enter 10 Digit Mobile Number");
		frmvalidator.addValidation("mobileNo", "minlen=10",
				"Enter 10 Digit Mobile Number");

		frmvalidator.addValidation("answer", "req", " Enter Captcha");
	</script>
	</body>
</html>
