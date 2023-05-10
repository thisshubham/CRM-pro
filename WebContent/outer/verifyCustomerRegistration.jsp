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

<title>VANRA CRM - Customer Registration Email Verification</title>

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
</head>

<body id="page-top">

	<nav id="mainNav" class="navbar navbar-default navbar-fixed-top">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand page-scroll" href="#page-top">VANRA CRM</a>
			</div>
		</div>
		<!-- /.container-fluid -->
	</nav>

	<header>
		<div class="header-content">
			<div class="header-content-inner">
				<img src="outer/img/trans_vanra.png" alt="VANRA CRM" width="300px"
					height="120px" />
				<h1>Your email verification is completed. please check your
					registered Email id for your login details.</h1>
				<hr>
				<p>Click here for Customer Login.</p>

					<div class="row">
						<div class="col-md-12 col-lg-12 col-sm-12">

							<a href="userlogin.action" class="btn btn-default btn-xl"
								style="margin-top: 20px;">Login</a>
						</div>

					</div>


				<p style="margin-top: 10px;">
					<a href="#" style="color: white;"></a>&nbsp;&nbsp; Don't Have VANRA
					CRM Account?<a href="omerainvoice.action"> Sign Up Today </a>
				</p>

			</div>
		</div>
	</header>



</body>

</html>
