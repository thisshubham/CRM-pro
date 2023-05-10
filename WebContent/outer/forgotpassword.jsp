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

<title>Vanra CRM - A complete free online solution for Customer
	Relationship Management</title>

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




<!-- ...........new changes............... -->

<link href="outer/css/custom.css" rel="stylesheet" type="text">

<script type="text/javascript">
	var xmlhttp;
	if (window.XMLHttpRequest) {
		xmlhttp = new XMLHttpRequest();
	} else {
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	/* This function will check the existing email id */
	function isEmailIdRegistered(companyEmailId) {
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				document.getElementById("server2Response").innerHTML = xmlhttp.responseText;
			}
		};
		xmlhttp.open("GET", "isEmailIdRegistered.action?companyEmailId="
				+ companyEmailId, true);
		xmlhttp.send();
	}
</script>

</head>

<body id="page-top" class="video-background-container">
	
	<div >
			 <div class="video-background-container">
            <video preload="auto" autoplay loop muted class="video-background">
                <source type="video/mp4" src="outer/videos/CRM Video 2_x264.mp4" />
                <source type="video/ogg" src="outer/videos/CRM Video 2_x264.ogg" />
                <source type="video/webm" src="outer/videos/CRM Video 2_VP8.webm" />
            </video>
        </div> 

        

			<div class="parallax-overlay">
			<div id="header" class="navbar-fixed-top navbar-inverse video-menu" role="banner">
<div id="header" class="navbar-text"><a class="navbar-brand img" href="outer/index.jsp" style="margin-top:-22px;">
                                <img src="outer/images/trans_vanra.png"  alt="">
                        </a></div>
	<div class="container">
    		<!-- <div class="row"> -->
                 
                 
                        
                 	<nav class="collapse navbar-collapse navigation" id="bs-example-navbar-collapse-1" role="navigation">
                        <ul class="nav navbar-nav navbar-right ">
                        
                        
                        
                                                </ul>
                     </nav>
                </div>
                </div>
			<header>
				<div class="header-content"> 
					<div class="header-content-inner">
						<img src="outer/images/trans_vanra.png" alt="VANRA CRM" width="400px"
							 />
						<h1 style="margin-top:6px; color:#fff">To Reset Your Password.</h1>
						<hr>
						<p style="color:#FFF"><b>Please enter Your Registered E-mail Id.</b></p>
						<s:form name="forgotpasswordform" method="post"
							action="securityQuestion" cssClass="form-horizontal" role="form"
							style="margin:3px;">

					
											<div class="row">

												<p>
												<div class="col-md-3 col-lg-3 col-sm-12"></div>

												<div class="col-md-6 col-lg-6 col-sm-12">
													<div id='forgotpasswordform_primaryEmailId_errorloc'
														class="error_strings" style="color: red;"></div>
													<s:textfield name="primaryEmailId" cssClass="form-control"
														style="background:transparent; height:40px; font-size:20px; color:#FFF; margin-top:10px;"
														placeholder="Enter User E-mail" theme="css_xhtml"
														onblur="isEmailIdRegistered(companyEmailId.value);" />

												</div>
												<div class="col-md-3 col-lg-3 col-sm-12">
													<div id="server2Response" style="width: 10%;"></div>
												</div>
											</div>
										


							<!-- ------------------------------------------------------------------------- -->

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


					</div>
					<p style="margin-top: 10px;">
						<a href="#" style="color: white;"></a>&nbsp;&nbsp; Don't Have
						VANRA CRM Account?<a href="omerainvoice.action"> Sign Up Today
						</a>
					</p>

				</div>

			</header>
</div>
</div>

	<script src="outer/js/gen_validatorv4.js" type="text/javascript"></script>
	<script  type="text/javascript">
		//You should create the validator only after the definition of the HTML form
		var frmvalidator = new Validator("forgotpasswordform");
		frmvalidator.EnableOnPageErrorDisplay();
		frmvalidator.EnableMsgsTogether();
		//validations for companyEmailId
		frmvalidator.addValidation("primaryEmailId", "req",
				"Please Enter Email");
		frmvalidator.addValidation("primaryEmailId", "email",
				"Please Enter Your Valid Email ID");
		frmvalidator.addValidation("primaryEmailId", "maxlen=100",
				"Maximun Length of Primary Email id is 100 Characters");
	</script>


	</body>

</html>
