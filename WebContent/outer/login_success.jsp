<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="/struts-jquery-tags" prefix="sj"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Vanra CRM - Customer Login</title>

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

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
<script type="text/javascript">
	var xmlhttp;
	if (window.XMLHttpRequest) {
		xmlhttp = new XMLHttpRequest();
	} else {
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}

	/* This function will check the existing email id */
	function isEmailIdSaved(primaryEmailId) {
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				document.getElementById("server3Response").innerHTML = xmlhttp.responseText;
			}
		};
		xmlhttp.open("GET", "isEmailIdSaved.action?primaryEmailId="
				+ primaryEmailId, true);
		xmlhttp.send();
	}
</script>
<script type="text/javascript">
function checkCapsLock(e) {
	kc = e.keyCode ? e.keyCode : e.which;
	sk = e.shiftKey ? e.shiftKey : ((kc == 16) ? true : false);
	if (((kc >= 65 && kc <= 90) && !sk) || ((kc >= 97 && kc <= 122) && sk))
		document.getElementById('capLock_msg').style.visibility = 'visible';
	else
		document.getElementById('capLock_msg').style.visibility = 'hidden';
}
</script>

</head>

<body id="page-top">

	<nav id="mainNav" class="navbar navbar-default navbar-fixed-top">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<a class="navbar-brand page-scroll" href="outer/index.jsp"><s:text
						name="project.name" /></a>
			</div>
		</div>
		<!-- /.container-fluid -->
	</nav>

	<header>
		<div class="header-content">
			<div class="header-content-inner">
				<img src="outer/img/trans_vanra.png" alt="VANRA CRM" width="300px"
					height="120px" />
				<h1>Wellcome To Vcrm Password Security Page.......</h1>
				<hr>
				<p>
					<s:if test="hasActionErrors()">
						<s:actionerror />
					</s:if>
					<s:elseif test="hasActionMessages()">
						<s:actionmessage />
					</s:elseif>
					<s:else>
						<s:text name="Wellcome To Vcrm Password Security Page......." />
					</s:else>
				</p>

				<s:form action="updateLoginPassword" name="userLoginForm"
					cssClass="form-horizontal">

					<div class="row">

						<div class="col-md-3 col-sm-3 col-xs-12"></div>
						<div class="col-md-1 col-sm-1 col-xs-12">
							<div id="server3Response" style="width: 10%; margin-top: 20px;"></div>
						</div>
						<div class="col-md-4 col-sm-4 col-xs-12">


							<s:textfield name="primaryEmailId" cssClass="form-control" id="primaryEmailId"
								style="background:transparent; height:40px; font-size:20px; color:white; margin-top:10px;"
								placeholder="Enter User Name" theme="css_xhtml"
								onblur="isEmailIdSaved(primaryEmailId.value);" />
						</div>
						<div class="col-md-4 col-sm-4 col-xs-12">
							<div id='userLoginForm_primaryEmailId_errorloc'
								class="error_strings"
								style="color: #9EC4FF; margin-top: 20px; text-align: left;"></div>
						</div>
					</div>

					<div class="row">

						<div class="col-md-3 col-sm-3 col-xs-12"></div>
						<div class="col-md-1 col-sm-1 col-xs-12"></div>
						<div class="col-md-4 col-sm-4 col-xs-12">
							<s:password name="password" cssClass="form-control" id="password"
								theme="css_xhtml" onkeypress="checkCapsLock(event)"
								style="background:transparent; height:40px; font-size:20px; color:white; margin-top:10px;"
								placeholder="Current Password" />
								<s:password name="newPassword" cssClass="form-control" id="password"
								theme="css_xhtml" onkeypress="checkCapsLock(event)"
								style="background:transparent; height:40px; font-size:20px; color:white; margin-top:10px;"
								placeholder="New Password" />
								<s:password name="reEnterPassword" cssClass="form-control" id="password"
								theme="css_xhtml" onkeypress="checkCapsLock(event)"
								style="background:transparent; height:40px; font-size:20px; color:white; margin-top:10px;"
								placeholder="Re-enter Password" />
								<div id="capLock_msg"
										style="visibility: hidden; color: #FF3333;" align="right">
										<img src="outer/img/alert.png" style="margin-right: 5px;" />
										Caps Lock is on.
									</div>
						</div>
						<div class="col-md-4 col-sm-4 col-xs-12">
							<div id='userLoginForm_password_errorloc' class="error_strings"
								style="color: #9EC4FF; margin-top: 20px; text-align: left;"></div>
						</div>
					</div>

					<div class="row">
						<div class="col-md-4 col-sm-4 col-xs-12"></div>
						<div class="col-md-2 col-sm-2 col-xs-12">

							<a href="outer/index.jsp" class="btn btn-default btn-xl"
								style="margin-top: 20px;">Cancel</a>
						</div>
						<div class="col-md-2 col-sm-2 col-xs-12">
							<s:submit cssClass="btn btn-primary"
								key="project.form.button.submit" theme="simple" id="nextId"
								style="width:120px; height:48px; margin-top:20px;" />
						</div>
						<div class="col-md-4 col-sm-4 col-xs-12"></div>
					</div>
				</s:form>

				<p style="margin-top: 20px;">
					<a href="forgotpassword.action" style="color: white;">Forgot
						Password?</a>&nbsp;&nbsp; Don't Have VANRA CRM Account? <a
						href="omerainvoice.action"> Sign Up Today </a>
				</p>
			</div>
		</div>

	</header>

	<script src="outer/js/gen_validatorv4.js" type="text/javascript"></script>
	<script type="text/javascript">
		//You should create the validator only after the definition of the HTML form
		var frmvalidator = new Validator("userLoginForm");
		frmvalidator.EnableOnPageErrorDisplay();
		frmvalidator.EnableMsgsTogether();

		//validations for companyEmailId
		frmvalidator.addValidation("primaryEmailId", "req",
				"Please Enter Registered Email");
		frmvalidator.addValidation("primaryEmailId", "email",
				"Please Enter Your Valid Email ID");
		frmvalidator.addValidation("primaryEmailId", "maxlen=100",
				"Maximun Length of Primary Email id is 100 Characters");

		frmvalidator.addValidation("password", "req",
				"Please Enter Your Password");
		frmvalidator.addValidation("password", "maxlen=100",
				"Maximun Length of Primary Email id is 100 Characters");
		frmvalidator.addValidation("password", "minlen=6",
				"Maximun Length of Primary Email id is 100 Characters");
	</script>

</body>

</html>
