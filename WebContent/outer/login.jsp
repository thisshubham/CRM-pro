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

<title>Chouksay Traders - User Login</title>

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
<link rel="stylesheet" href="outer/css1/custom.css" />

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    
   <style>
   #test {background-color: rgba(16, 17, 17, 0.6);
   }
   </style> 
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

<div class="login_nav">

</div>


<div id="header" class="navbar-fixed-top navbar-inverse video-menu" role="banner">
<!-- <div id="header" class="navbar-text"><a class="navbar-brand img" href="outer/index.jsp" style="margin-top:-22px;">
                                <img src="outer/images/trans_vanra.png"  alt="" height="50px" width="50px">
                        </a></div> -->
	<div class="container">
    		<!-- <div class="row"> -->
                 
                 
                        
                 	<nav class="collapse navbar-collapse navigation" id="bs-example-navbar-collapse-1" role="navigation">
                        <ul class="nav navbar-nav navbar-right ">
                        
                        
                        
                                                </ul>
                     </nav>
                </div>
                </div>
                              <!-- /.container-fluid -->
	
        <div class="video-background-container">
            <%-- <video preload="auto" autoplay loop muted class="video-background">
                <source type="video/mp4" src="outer/videos/CRM Video 2_x264.mp4" />
               <!--<source type="video/ogg" src="videos/CRM Video 2_x264.ogg" /> -->
                <source type="video/webm" src="outer/videos/CRM Video 2_VP8.webm" />
            </video> --%>
        </div> 

        <div class="parallax-overlay"></div>
        

	<header>
	
	 
		<div class="header-content">
			<div class="header-content-inner" >
				<!-- <img src="outer/images/trans_vanra.png" width="400px"
					height="" /> -->
					
					
				<h1 style="margin-top:13px; color:#fff">Register User Login Here.</h1>
				<hr>
				<p>
					<s:if test="hasActionErrors()">
						<s:actionerror />
					</s:if>
					<s:elseif test="hasActionMessages()">
						<s:actionmessage />
					</s:elseif>
					<s:else>
						<s:text name="user.login.information.bar" />
					</s:else>
				</p>

				<s:form action="customerLogin" name="userLoginForm"
					cssClass="form-horizontal">

					<div class="row">

						<div class="col-md-3 col-sm-3 col-xs-12"></div>
						<div class="col-md-1 col-sm-1 col-xs-12">
							<div id="server3Response" style="width: 10%; margin-top: 15px;"></div>
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
								style="color: red; margin-top: 20px; text-align: left;"></div>
						</div>
					</div>

					<div class="row">

						<div class="col-md-3 col-sm-3 col-xs-12"></div>
						<div class="col-md-1 col-sm-1 col-xs-12"></div>
						<div class="col-md-4 col-sm-4 col-xs-12">
							<s:password name="password" cssClass="form-control" id="password"
								theme="css_xhtml" onkeypress="checkCapsLock(event)"
								style="background:transparent; height:40px; font-size:20px; color:white; margin-top:10px;"
								placeholder="Enter Password" onpaste="return false"/>
								<span id="<portlet:namespace />passwordCapsLockSpan" style="display: none;"><liferay-ui:message key="caps-lock-is-on" /></span>
								<div id="capLock_msg"
										style="visibility: hidden; color: red;" align="right">
										<img src="outer/img/alert.png" style="margin-right: 5px;" />
										Caps Lock is on.
									</div>
						</div>
								
						<div class="col-md-4 col-sm-4 col-xs-12">
							<div id='userLoginForm_password_errorloc' class="error_strings"
								style="color: red; margin-top: 20px; text-align: left;"></div>
						</div>
					</div>

<!-- /////////////////////////////// Code-->	
					<%-- <div class="row">
						<div class="col-md-3 col-sm-3 col-xs-12"></div>
						<div class="col-md-1 col-sm-1 col-xs-12"></div>
						<div class="col-md-4 col-sm-4 col-xs-12">
						<select class="form-control" name="accountTypeId" theme="css_xhtml" cssStyle="width: 10px;height:35px;"
											headerKey="-1" headerValue="Select Customer" style="background:transparent; height:40px; font-size:20px; color:white; margin-top:10px;">
											<option>1</option>
											<option>2</option>
											</select> 
											<s:select cssClass="form-control chzn-select" list="shopList" 
										    name="shopId" headerKey="-1" 
							    			headerValue= "Select Shop" 
											cssStyle="width: 100%;" />  
											</div>
											</div> --%>
	<!-- ///////////////////////////////////////////////////// code end here-->		

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

				<!-- <p style="margin-top: 20px;">
					<a href="forgotpassword.action" style="color: white;">Forgot
						Password?</a>&nbsp;&nbsp; Don't Have VANRA CRM Account? <a
						href="omerainvoice.action"> Sign Up Today </a>
				</p> -->
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
