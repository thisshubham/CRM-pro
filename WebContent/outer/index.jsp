<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="/struts-jquery-tags" prefix="sj"%>
<html lang="en">

<head>
<!-- Basic Page Needs
    ================================================== -->
<meta charset="utf-8">
<title>Rahul Traders Inventory</title>
<meta name="description" content="">
<!-- Mobile Specific Metas
    ================================================== -->
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
<!-- CSS
         ================================================== -->
<!-- Bootstrap -->
<link rel="stylesheet" href="css1/bootstrap.min.css" />
<!-- FontAwesome -->
<link rel="stylesheet" href="css1/font-awesome.min.css" />
<!-- Animation -->
<link rel="stylesheet" href="css1/animate.css" />
<!-- Owl Carousel -->
<link rel="stylesheet" href="css1/owl.carousel.css" />
<link rel="stylesheet" href="css1/owl.theme.css" />
<!-- Pretty Photo -->
<link rel="stylesheet" href="css1/prettyPhoto.css" />
<link rel="stylesheet" href="css1/flexslider.css" />
<link rel="stylesheet" href="css1/red.css" />

<!-- Template styles-->
<link rel="stylesheet" href="css1/custom.css" />
<link rel="stylesheet" href="css1/responsive.css" />
<link rel="stylesheet" href="css1/jquery.fancybox.css?v=2.1.5"
	type="text/css" media="screen" />

<%-- <%-- <script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false"></script> --%>
<link href='http://fonts.googleapis.com/css?family=Lato:400,300'
	rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Raleway:400,300,500'
	rel='stylesheet' type='text/css'>
	
</head>
<%-- <style>
body
{
font-family:verdana!important;
}
	.container{

width:100%;
height:1000px;
background-image:url('images/2.jpg');
}
</style>
 --%>

<body data-spy="scroll" data-target=".navbar-fixed-top" style="background-color:white;font-family:verdana!important; " >
	<!--[if lt IE 7]>
            <p class="browsehappy">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
        <![endif]-->

	<header id="header" class="navbar-fixed-top navbar-inverse video-menu"
		role="banner" style="background-color:white">
		<div class="container">
			<!-- <div class="row"> -->
			<div class="navbar-header " style="margin-left: -8px;">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">  <img
					src="img/rohittraders.png" alt="">
				</a>
			</div>
			<!--Navbar header End-->
			<nav class="collapse navbar-collapse navigation"
				id="bs-example-navbar-collapse-1" role="navigation" >
				<ul class="nav navbar-nav navbar-right ">
				
					<li class="primary"><a href="#home" class="page-scroll" /><s:text
								name="outer.index.home.home" /></a></li>
					<li><a href="#about" class="page-scroll"><s:text
								name="outer.index.home.about" /></a></li>
					<li><a href="#features" class="page-scroll"><s:text
								name="Event" /></a></li>
					<li><a href="" class="page-scroll"><s:text
								name="Feature" /></a></li>
					<%-- <li><a href="#pricing_table" class="page-scroll"><s:text
								name="outer.index.home.pricing" /> </a></li> --%>
					<li><a href="#contact" class="page-scroll"><s:text
								name="outer.index.home.contact" /></a></li>

				</ul>
			
			</nav>
		</div>
		<!-- /.container-fluid -->
	</header>
	<!-- Slider start -->
	<section id="home" class="hero landing hero-section" style="height:650px;">
		<div class="video-background-container" >
			<%-- <video preload="auto" autoplay loop muted class="video-background">
				<source type="video/mp4" src="videos/Dc.mp4" />
				<source type="video/ogg" src="videos/Dc.ogg" />
				<source type="video/webm" src="videos/Dc.webm" />
			</video> --%>
			
		</div>

		<div class="parallax-overlay"></div>

		<div class="container">
			<div class="hero-content text-center">
				<div class="hero-text wow fadeIn" data-wow-delay=".8s">
					<!-- <img src="images/trans_vanra.png" alt="VANRA CRM" align="center"
						width="400px" height="120px" /> --><h1 style="font-size:50px;color:white;">ROHIT TRADERS VIDISHA</h1>
					<%-- <h3 class="hero-title">
						<span><s:text name="outer.index.home.headercontent1" />
					</h3> --%>
					<%-- <p class="hero-description">
						<s:text name="outer.index.home.headercontent2" />
					</p> --%>
					<%-- <p class="hero-buttons">
						<a href="../userlogin.action" class="btn btn-dark" style="border-radius:0px;"> <strong>User
								Login </strong> </i>
								<!-- ../omerainvoice.action -->
						</a> <a href="#" class="btn btn-main featured" style="border-radius:0px;">
							<strong>Admin Login</strong></i>
						</a>

					</p> --%>
				</div>
				<!--/ Hero text end -->
			</div>
			<!--/ Hero content end -->
		</div>
		<!--/ Container end -->
	</section>
	<!--/ Home end -->

	<!-- About us start -->
	 <section id="about">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="feature_header text-center">
						<h3 class="feature_title">
							About<!-- We've got what you need as part of VCRM! --></b>
						</h3>
						<h4 class="feature_sub"></h4>
						<div class="dividerline"></div>
						<div class="divider"></div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="feature-tab">
					<div class="col-md-6">
						<div class="tab-content">
							<div role="tabpanel" class="tab-pane active" id="home">
								<img src="img/contactRohit.png" alt="" class="img-responsive">
							</div>

						</div>
					</div>
					<div class="col-md-6">
						<ul class="nav nav-tabs" role="tablist">
							<li role="presentation" class="active"><a href="#home"
								role="tab" data-toggle="tab">
									<div class="col-sm-12 single-feature">
										<div class="col-sm-2 feature-icon">
											<i class="fa fa-laptop"></i>
										</div>
										<div class="col-sm-10 feature-content">

											<p>
											THe erstwhile Mysore Cements branded its cement us Diamand.After  acquisition by
								            Heidelberg cement India Ltd.  businesses to create exceptional
												customer relationships with the most innovative,flexible and
												affordable CRM solution in the market. The company uniquely
												places the individual at the center of its solution—helping
												businesses transform the customer experience and enable
												highly personalized interactions that drive in customer
												excellence and loyalty throughout the entire customer
												lifecycle. The company uniquely
												places the individual at the center of its solution—helping
												businesses transform the customer experience and enable
												highly personalized interactions that drive in customer
												excellence and loyalty throughout the entire customer
												lifecycle.
											<!-- VanraCRM enables businesses to create exceptional
												customer relationships with the most innovative,flexible and
												affordable CRM solution in the market. The company uniquely
												places the individual at the center of its solution—helping
												businesses transform the customer experience and enable
												highly personalized interactions that drive in customer
												excellence and loyalty throughout the entire customer
												lifecycle. The company uniquely
												places the individual at the center of its solution—helping
												businesses transform the customer experience and enable
												highly personalized interactions that drive in customer
												excellence and loyalty throughout the entire customer
												lifecycle. --></p>
										</div>
									</div>
							</a></li>
						<!-- 	<li role="presentation"><a href="#profile" role="tab"
								data-toggle="tab">
									<div class="col-sm-12 single-feature">
										<div class="col-sm-2 feature-icon">
											<i class="fa fa-send"></i>
										</div>
										<div class="col-sm-10 feature-content">

											<p>VanraCRM provides a powerful, next generation CRM
												system with integrated email marketing, social media
												marketing and more that is complete with easy-to-use
												features to help you finalize more deals, get results, earn
												high profits. You have real-time, anywhere access to your
												leads,contacts, information, reports, and more. The result —
												a CRM solution your team will actually want to use. How
												simple is that! .</p>
										</div>

									</div>
							</a></li>
 -->
						</ul>


					</div>









					<!--  <a href="#" class="btn btn-main featured">
                            <strong>MORE DETAILS </strong> </i>
                        </a> -->
				</div>
			</div>



		</div>
	</section> 
	<!-- About us End -->

	<!-- Service Area start -->

	 <section id="features">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="feature_header text-center">
						<h3 class="feature_title">
							Other Branches</b>
						</h3>

						<div class="dividerline"></div>
						<div class="divider"></div>
					</div>
				</div>
				<!-- Col-md-12 End -->
			</div>
			<div class="row">
				<div class="main_feature text-center">
					<div class="col-md-3 col-xs-12 col-sm-6">
						<div class="feature_content">
							<i><img class="feature_image"
								src="img/mycem-cement.png"></i>
							<h5>
								<s:text name="Rahul Traders" />
							</h5>
							<p>
								<s:text name="THe erstwhile Mysore Cements branded its cement us Diamand.After  acquisition by
								  Heidelberg cement India Ltd.  Read More...." />
							</p>

						</div>
					</div>
					<div class="col-md-3 col-xs-12 col-sm-6">
						<div class="feature_content">
							<i><img class="feature_image"
								src="img/mycem-cement.png"></i>

							<h5>
								<s:text name="Rohit Traders" />
							</h5>
							<p>
								<s:text name="Strength of the bars are carefully controlled by optimizing the water 
								pressure for theire pearlitic core and tough. Read More..." />
							</p>

						</div>
					</div>
					<!-- Col-md-4 Single_feature End -->
					<div class="col-md-3 col-xs-12 col-sm-6">
						<div class="feature_content">
							<i><img class="feature_image"
								src="img/mycem-cement.png"></i>
							<h5>
								<s:text name="Varsha Traders" />
							</h5>
							<p>
								<s:text name="The product has high strength,high ductility,superior bend-ability
								weld-ability and straightness for better fabrication. Read More...." />
							</p>

						</div>
					</div>
					<!-- Col-md-4 Single_feature End -->
					<div class="col-md-3 col-xs-12 col-sm-6">
						<div class="feature_content">
							<i><img class="feature_image"
								src="img/images (5).jpg"></i>
							<h5>KALAA STEELS</h5>
							<p>
								<s:text name="The product has high strength,high ductility,superior bend-ability
								weld-ability and straightness for better fabrication. Read More...." />
							</p>

						</div>
					</div>
					<!-- Col-md-4 Single_feature End -->
					<!-- <button class="btn btn-main"> Read More</button> -->
				</div>
			</div>
			<!-- Row End -->
		</div>
		<!-- Container End -->

		<%-- <div class="container">

			<div class="row">
				<div class="main_feature text-center">
					<div class="col-md-3 col-xs-12 col-sm-6">
						<div class="feature_content">
							<i><img class="feature_image"
								src="images/vcrm/VCRM icons/8.png"></i>
							<h5>
								<s:text name="outer.index.features.heading5" />
							</h5>
							<p>
								<s:text name="outer.index.features.paragraph5" />
							</p>

						</div>
					</div>
					<div class="col-md-3 col-xs-12 col-sm-6">
						<div class="feature_content">
							<i><img class="feature_image"
								src="images/vcrm/VCRM icons/12.png"></i>
							<h5>
								<s:text name="outer.index.features.heading6" />
							</h5>
							<p>
								<s:text name="outer.index.features.paragraph6" />
							</p>

						</div>
					</div>
					<!-- Col-md-4 Single_feature End -->
					<div class="col-md-3 col-xs-12 col-sm-6">
						<div class="feature_content">
							<i><img class="feature_image"
								src="images/vcrm/VCRM icons/10.png"></i>
							<h5>
								<s:text name="outer.index.features.heading7" />
							</h5>
							<p>
								<s:text name="outer.index.features.paragraph7" />
							</p>

						</div>
					</div>
					<!-- Col-md-4 Single_feature End -->
					<div class="col-md-3 col-xs-12 col-sm-6">
						<div class="feature_content">
							<i><img class="feature_image"
								src="images/vcrm/VCRM icons/14.png"></i>
							<h5>
								<s:text name="outer.index.features.heading8" />
							</h5>
							<p>
								<s:text name="outer.index.features.paragraph8" />
							</p>

						</div>
					</div>
 --%>					<!-- Col-md-4 Single_feature End -->
					<!-- <button class="btn btn-main"> Read More</button> -->
				</div>
			</div>
			<!-- Row End -->
		</div>
		<!-- Container End -->
	</section> 
	<!-- Service Area End -->



	 <!-- Portfolio works Start -->

    <section id="modules">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="feature_header text-center">
                        <h3 class="feature_title">EVENT</b></h3>
                        
                        <div class="dividerline"></div><div class="divider"></div>
                    </div>
                </div>  <!-- Col-md-12 End -->
            </div>
        </div>


    <!-- <div id="isotope-filter" class="skew3 text-center">
        <a data-filter="*"  href="#" class="active ">All</a>
        <a data-filter=".identity"  href="#" class="">Dashboard</a>
        <a data-filter=".web-design" href="#"  class="">Reports</a>
        <a data-filter=".graphic"  href="#" class="">Essentials</a>
        <a data-filter=".logo"  href="#" class="">Marketing</a>
        <a data-filter=".identity"  href="#" class="">Sales</a>
        <a data-filter=".web-design" href="#"  class="">Inventory</a>
        
        <a data-filter=".logo"  href="#" class="">Expenses</a>
        <a data-filter=".logo"  href="#" class="">Support</a>
    </div> -->
    <div class="clearfix"></div>
   			<div class="text-center container"> 
   			
              <ul class="portfolio-wrap" id="portfolio_items" style="margin-top:30px;">
                    <li class="col-md-4 col-xs-12 col-sm-6 single-portfolio identity web-design">
                        <figure >
                            <img src="img/rohitTradersVidisha1.png" alt="" class="img-responsive" style="padding:5px;"/>
                            <figcaption>
                                <h5 align="center" style="font-family:verdana;margin:auto!important; "><s:text name="Event"/></h5>
                               
                             
                            </figcaption>
                        </figure>
                    </li>

                    <li class="col-md-4 col-xs-12 col-sm-6 single-portfolio logo graphic">
                        <figure>
                        <img src="img/rohitTradersVidisha7.png" alt="" class="img-responsive" style="padding:5px;" />
                            <figcaption>
                                <h5><s:text name="Event"/></h5>
                                <p class="links">
                                    <a href="portfolio-single.html"> <!-- <i class="fa fa-link"></i> --></a>
                                    <a href="img/rohitTradersVidisha7.png"  data-rel="prettyPhoto">
                                        <i class="fa fa-plus"></i>
                                    </a>
                                </p>
                                <p class="description">
                                    <s:text name="outer.index.modules.reports_description"/>
                                </p>
                                </figcaption>
                        </figure>
                    </li>

                    <li class="col-md-4 col-xs-12 col-sm-6 single-portfolio graphic logo">
                        <figure>
                            <img src="img/rohitTradersVidisha4.png" alt="" class="img-responsive" style="padding:5px;"/>
                            <figcaption>
                                <h5><s:text name="Event"/></h5>
                                <p class="links">
                                    <a href="portfolio-single.html"><!--  <i class="fa fa-link"></i> --></a>
                                    <a href="outer/img/rohitTradersVidisha4.png" data-rel="prettyPhoto">
                                        <i class="fa fa-plus"></i>
                                    </a>
                                </p>
                                <p class="description">
                                   <s:text name="outer.index.modules.essentials_description"/>
                                </p>
                            </figcaption>
                        </figure>
                    </li>

                   <li class="col-md-4 col-xs-12 col-sm-6 single-portfolio graphic logo">
                        <figure>
                            <img src="img/rohitTradersVidisha2.jpg" alt="" class="img-responsive" style="padding:5px;"/>
                            <figcaption>
                                <h5><s:text name="Event"/></h5>
                                <p class="links">
                                    <a href="portfolio-single.html"><!--  <i class="fa fa-link"></i> --></a>
                                    <a href="img/rohitTradersVidisha2.jpg" data-rel="prettyPhoto">
                                        <i class="fa fa-plus"></i>
                                    </a>
                                </p>
                                <p class="description">
                                   <s:text name="outer.index.modules.essentials_description"/>
                                </p>
                            </figcaption>
                        </figure>
                    </li>

                    <li class="col-md-4 col-xs-12 col-sm-6 single-portfolio web-design identity">
                        <figure>
                            <img src="img/rohitTradersVidisha5.png" alt="" class="img-responsive" style="padding:5px;" />
                            <figcaption>
                                <h5><s:text name="Event"/></h5>
                                <p class="links">
                                    <a href="portfolio-single.html"><!--  <i class="fa fa-link"></i> --></a>
                                    <a href="img/rohitTradersVidisha5.png" data-rel="prettyPhoto">
                                        <i class="fa fa-plus"></i>
                                    </a>
                                </p>
                                <p class="description">
                                    <s:text name="outer.index.modules.marketing_description"/>
                                </p>
                            </figcaption>
                        </figure>
                    </li>

                    <li class="col-md-4 col-xs-12 col-sm-6 single-portfolio logo web-design">
                        <figure>
                            <img src="img/rohitTradersVidisha6.png" alt="" class="img-responsive" style="padding:5px;" />
                            <figcaption>
                                <h5><s:text name="Event"/></h5>
                                <p class="links">
                                    <a href="portfolio-single.html"> <!-- <i class="fa fa-link"></i> --></a>
                                    <a href="img/rohitTradersVidisha6.png" data-rel="prettyPhoto">
                                        <i class="fa fa-plus"></i>
                                    </a>
                                </p>
                                <p class="description">
                                    <s:text name="outer.index.modules.sales_description"/>
                                </p>
                            </figcaption>
                        </figure>
                    </li>

                    <li class="col-md-4 col-xs-12 col-sm-6 single-portfolio logo graphic">
                        <figure>
                            <img src="img/rohitTradersVidisha6.png" alt="" class="img-responsive" style="padding:5px;" />
                            <figcaption>
                                <h5><s:text name="Event"/></h5>
                                <p class="links">
                                    <a href="portfolio-single.html"><!--  <i class="fa fa-link"></i> --></a>
                                    <a href="img/rohitTradersVidisha6.png" data-rel="prettyPhoto">
                                        <i class="fa fa-plus"></i>
                                    </a>
                                </p>
                                <p class="description">
                                   <s:text name="outer.index.modules.inventory_description"/>
                                </p>
                            </figcaption>
                        </figure>
                    </li>

                    <li class="col-md-4 col-xs-12 col-sm-6 single-portfolio graphic identity">
                        <figure>
                            <img src="img/rohitTradersVidisha6.jpg" alt="" class="img-responsive" style="padding:5px;" />
                            <figcaption>
                                <h5><s:text name="Event"/></h5>
                                <p class="links">
                                    <a href="portfolio-single.html"> <!-- <i class="fa fa-link"></i> --></a>
                                    <a href="img/rohitTradersVidisha6.jpg" data-rel="prettyPhoto">
                                        <i class="fa fa-plus"></i>
                                    </a>
                                </p>
                                <p class="description">
                                    <s:text name="outer.index.modules.projects_description"/>
                                </p>
                            </figcaption>
                        </figure>
                    </li>
                    
                     <li class="col-md-4 col-xs-12 col-sm-6 single-portfolio graphic identity">
                        <figure>
                            <img src="img/rohitTradersVidisha3.png" alt="" class="img-responsive" style="padding:5px;" />
                            <figcaption>
                                <h5><s:text name="Event"/></h5>
                                <p class="links">
                                    <a href="portfolio-single.html"> <!-- <i class="fa fa-link"></i> --></a>
                                    <a href="img/rohitTradersVidisha3.png" data-rel="prettyPhoto">
                                        <i class="fa fa-plus"></i>
                                    </a>
                                </p>
                                <p class="description">
                                    <s:text name="outer.index.modules.projects_description"/>
                                </p>
                            </figcaption>
                        </figure>
                    </li>
                   
                    
                     <li class="col-md-12 col-xs-12 col-sm-6 single-portfolio graphic identity">
                        <figure>
                            <img src="img/slider1.jpg" alt="" class="img-responsive" style="padding:5px;" />
                            <figcaption>
                                <h5><s:text name="Event"/></h5>
                                <p class="links">
                                    <a href="portfolio-single.html"> <!-- <i class="fa fa-link"></i> --></a>
                                    <a href="img/slider1.jpg" data-rel="prettyPhoto">
                                        <i class="fa fa-plus"></i>
                                    </a>
                                </p>   
                                <p class="description">
                                    <s:text name="outer.index.modules.projects_description"/>
                                </p>
                            </figcaption>
                        </figure>
                    </li>
                    

                    <li class="col-md-4 col-xs-12 col-sm-6 single-portfolio web-design graphic">
                        <figure>
                            <img src="" alt="" class="img-responsive" style="padding:5px;" />
                            <figcaption>
                                <h5><s:text name="outer.index.modules.expenses"/></h5>
                                <p class="links">
                                    <a href="portfolio-single.html"><!--  <i class="fa fa-link"></i> --></a>
                                    <a href="" data-rel="prettyPhoto">
                                        <i class="fa fa-plus"></i>
                                    </a>
                                </p>
                                <p class="description">
                                   <s:text name="outer.index.modules.expenses_description"/>
                                </p>
                            </figcaption>
                        </figure>
                    </li>
                    
                    
                    
					
					<li class="col-md-4 col-xs-12 col-sm-6 single-portfolio graphic logo">
                        <figure>
                            <img src="images/vcrm/IMG_20171014_153417.jpg" alt="" class="img-responsive" style="padding:5px;"/>
                            <figcaption>
                                <h5><s:text name="outer.index.modules.support"/></h5>
                                <p class="links">
                                    <a href="portfolio-single.html"> <!-- <i class="fa fa-link"></i> --></a>
                                    <a href="images/vcrm/IMG_20171014_153417.jpg" data-rel="prettyPhoto">
                                        <i class="fa fa-plus"></i>
                                    </a>
                                </p>
                                <p class="description">
                                    <s:text name="outer.index.modules.support_description"/>
                                </p>
                            </figcaption>
                        </figure>
                    </li>

		
					<li class="col-md-4 col-xs-12 col-sm-6 single-portfolio graphic logo">
                        <figure>
                            <img src="images/vcrm/mycem.jpg" alt="" class="img-responsive" style="padding:5px;"/>
                            <figcaption>
                                <h5><s:text name="outer.index.modules.support"/></h5>
                                <p class="links">
                                    <a href="portfolio-single.html"> <!-- <i class="fa fa-link"></i> --></a>
                                    <a href="images/vcrm/mycem.jpg" data-rel="prettyPhoto">
                                        <i class="fa fa-plus"></i>
                                    </a>
                                </p>
                                <p class="description">
                                    <s:text name="outer.index.modules.support_description"/>
                                </p>
                            </figcaption>
                        </figure>
                    </li>
                    
                    
                    
                    		
					<li class="col-md-4 col-xs-12 col-sm-6 single-portfolio graphic logo">
                        <figure>
                            <img src="images/vcrm/cement.jpg" alt="" class="img-responsive" style="padding:5px;"/>
                            <figcaption>
                                <h5><s:text name="outer.index.modules.support"/></h5>
                                <p class="links">
                                    <a href="portfolio-single.html"> <!-- <i class="fa fa-link"></i> --></a>
                                    <a href="images/vcrm/cement.jpg" data-rel="prettyPhoto">
                                        <i class="fa fa-plus"></i>
                                    </a>
                                </p>
                                <p class="description">
                                    <s:text name="outer.index.modules.support_description"/>
                                </p>
                            </figcaption>
                        </figure>
                    </li>

                </ul>
              
        </div> <!-- Container Full End -->
</section>  <!-- Portfolio Section End --> 

	<div class="clearfix"></div>



	<!-- Counter Strat -->


	<!-- Counter End -->
	<div class="clearfix"></div>


	<div class="clearfix"></div>



	<!-- Pricing Table Start -->
	<%--  <section id="pricing_table" class="pricing_overlay">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="feature_header text-center">
						<h3 class="feature_title">
							Our <b>Pricing</b>
						</h3>
						<h4 class="feature_sub"></h4>
						<div class="dividerline">
							<div class="divider"></div>
						</div>
						<div class="divider"></div>
					</div>
				</div>
				<!-- Col-md-12 End -->

				<div class="text-center pricing">
					<div class="col-md-4">
						<div class="single_table"> --%>

						<%-- 	<ul>
								<li class="plan" style="background: #837E7C;"><i>FEATURES</i><br>
								<span></span></li>
								<li style="background: #FEFCFF; font-size: 19px;">Price <span></span></li>
								<li style="background: #FEFCFF;">Accessibility</li>
								<li style="background: #FEFCFF;">File Storage</li>

								<li style="background: #FEFCFF;">Document library</li>
								<li style="background: #FEFCFF;">Social site integration</li>
								<li style="background: #FEFCFF;">Analytics Report</li>
								<li style="background: #FEFCFF;">Customer Report</li>
								<li style="background: #FEFCFF;">Contacts & Accounts
									Management</li>
								<li style="background: #FEFCFF;">Marketing Management</li>
								<li style="background: #FEFCFF;">Sales management</li>
								<li style="background: #FEFCFF;">Inventory Management</li>
								<li style="background: #FEFCFF;">Expenses Management</li>

							</ul>
 --%>						</div>
					</div>
				 <!-- Single col-md-4 End -->
					<div class="col-md-4">
						<div class="single_table grey_bg  " style="margin-top: 82px;">

						<%-- 	<ul>
								<li class="plan"><i>Free trial</i> <br>
								<span></span></li>
								<li style="font-size: 19px;"><span>$</span> 0</li>
								<li style="padding: 13px;">5 Users</li>
								<li style="padding: 13px;">1 GB</li>
								<li style="padding: 12px;"><span
									class="glyphicon glyphicon-remove"></span></li>
								<li style="padding: 12px;"><span
									class="glyphicon glyphicon-remove"></span></li>
								<li style="padding: 13px;">Default</li>
								<li style="padding: 13px;"><span
									class="glyphicon glyphicon-ok"></span></li>
								<li style="padding: 13px;"><span
									class="glyphicon glyphicon-ok"></span></li>
								<li style="padding: 13px;"><span
									class="glyphicon glyphicon-ok"></span></li>
								<li style="padding: 12px;"><span
									class="glyphicon glyphicon-ok"></span></li>
								<li style="padding: 12px;"><span
									class="glyphicon glyphicon-ok"></span></li>
								<li style="padding: 13px;"><span
									class="glyphicon glyphicon-ok"></span></li>




								<li class="price_button"><a href="../omerainvoice.action"
									class="btn btn-main featured"> <strong> Sign UP
											Now!</strong></i>
								</a></li>

							</ul>
 --%>						</div>
					</div>
					<!-- Single col-md-4 End -->
					<div class="col-md-4">
						<div class="single_table dark_bg">

							<%-- <ul>
								<li class="plan" style=""><i>Premium</i> <br>
								<span></span></li>
								<li style="font-size: 19px;"><span>$</span> 10</li>
								<li style="padding: 17px;">Unlimited users</li>
								<li style="padding: 15px;">5GB</li>

								<li style="padding: 14px;"><span
									class="glyphicon glyphicon-ok"></span></li>
								<li style="padding: 14px;"><span
									class="glyphicon glyphicon-ok"></span></li>
								<li style="padding: 15px;">Customized</li>
								<li style="padding: 15px;"><span
									class="glyphicon glyphicon-ok"></span></li>
								<li style="padding: 17px;"><span
									class="glyphicon glyphicon-ok"></span></li>
								<li style="padding: 15px;"><span
									class="glyphicon glyphicon-ok"></span></li>
								<li style="padding: 15px;"><span
									class="glyphicon glyphicon-ok"></span></li>
								<li style="padding: 13px;"><span
									class="glyphicon glyphicon-ok"></span></li>
								<li style="padding: 13px;"><span
									class="glyphicon glyphicon-ok"></span></li>
								<li class="price_button"><a href="../omerainvoice.action"
									class="btn btn-main featured"> <strong> Sign UP
											Now!</strong></a></li>
							</ul> --%>
						</div>
					</div>
					<!-- Single col-md-4 End -->
				</div>
			</div>
		</div>
	</section> 
	<!-- Pricing Section End -->
	<!-- Pricing Table End -->

	<!-- Testimonial Start -->

	<!-- Section Testimonial End -->

	<!-- Testimonial Area End -->

	<!-- Client Carousel Start -->


	<!-- Client Carousel End -->





	<!-- Conatct Area Start-->





	 <section id="contact">
		<div class="container">
			<div class="row">
				<div class="col-lg-8 col-lg-offset-2 text-center">
					<h3 class="section-heading" style="color: #4382a7!important;">
						<s:text name="outer.index.contact.section_heading" />
					</h3>
					<hr class="primary">

					<p style="color: black;">
						<%-- <s:text name="outer.index.contact.paragraph" /> --%>
					</p>
				</div>





				<div class="row">
				

					<div class="col-lg-5 col-lg-offset-1 text-center">

						<form action="addContactUs" name="contactUs" style="margin-bottom:50px;">
							<s:textfield name="fullName" id="fullName"
								cssClass="form-control"
								style="background:transparent; height:40px; font-size:20px; color:gray; margin-top:10px;"
								placeholder="Enter Full Name" theme="css_xhtml" />
							<div id='contactUs_fullName_errorloc' class="error_strings"></div>
<br>
							<s:textfield name="emailId" id="emailid" cssClass="form-control"
								style="background:transparent; height:40px; font-size:20px; color:gray; margin-top:10px;"
								placeholder="Enter Email Id" theme="css_xhtml" />
							<div id='contactUs_emailId_errorloc' class="error_strings"></div>
<br>

							<s:textfield name="mobileNo" id="mobileNo"
								cssClass="form-control"
								style="background:transparent; height:40px; font-size:20px; color:gray; margin-top:10px;"
								placeholder="Enter Mobile Number" theme="css_xhtml"
								onkeypress='return event.keyCode == 8 || event.charCode >= 48 && event.charCode <= 57' />
							<div id='contactUs_mobileNo_errorloc' class="error_strings"></div>

<br>							
                              <s:textarea name="Comment" id="comment" cssClass="form-control"
								style="background:transparent; height:100px; font-size:20px; color:gray; margin-top:10px;"
								placeholder="Write your Comment here!" theme="css_xhtml" />
							<div id='contactUs_Comment_errorloc' class="error_strings"></div>

							<s:reset cssClass="btn btn-default btn-xl wow tada"
								key="contact.support.reset" theme="simple" id="nextId"
								style="width:120px; height:48px; margin-top:20px; background-color:#D8D8D8;" />
							<s:submit cssClass="btn btn-primary"
								key="project.form.button.submit" theme="simple" id="nextId"
								style="width:120px; height:48px; margin-top:20px;" />
						</form>
					</div>
					<br> <br>
					<div class="col-lg-6 col-md-6 col-lg-offset-">
						<div class="dividerHeading">
							<div class="col-lg-5  text-center" style="padding: 5px;">
								<!-- <img src="images/testi1.jpg" alt="..." class="img-circle"
									height="100px" width="100px"> -->
								<h4>
									<font color="#333333">Rahul Traders</font>
								</h4>
								
								<font style="" color="#4d4d4d"><p>Mandi Road<br>
                                       Vidisha (M.P.)</p></font>
                                
                                       <s:text name="" /></font><font
									style="" color="#66666">
								
									<s:text	name="outer.index.contact.rahul_ph.number" /></font> <br>
									<font style=""
									color="#66666">
									
									<s:text	name="outer.index.contact.rahul_ph.number1" /></font>
								<font color="#808080">
								
								<%-- <s:text name="info@rahultraders.com" /> --%></font><br>
								<font color="#808080">
								
								<s:text name="rahul.traders@gmail.com" /></font>
							</div>
						
							<div class="col-lg-5  text-center" style="padding: 5px;">
								<!-- <img src="images/testi1.jpg" alt="..." class="img-circle"
									height="100px" width="100px"> -->
								<h4>
									<font color="#333333"><s:text
											name="outer.index.contact.Rohit_Traders" /></font>
								</h4>
								<font style="" color="#4d4d4d">	<font style="" color="#4d4d4d"><p>Reetha Phatak<br>
                                       Vidisha (M.P.)</p></font>
                                    
                                       <s:text name="" /></font> <font style=""
									color="#66666">
									
									<s:text	name="outer.index.contact.rohit_ph.number" /></font><br>
									<font style=""
									color="#66666">            
									
									<s:text	name="outer.index.contact.rohit_ph.number1" /></font>
								<font color="#808080">
								<%-- <s:text	name="info@rohittraders.com" /> --%></font><br>
								<font color="#808080">
								<s:text	name="rohit.traders@gmail.com" /></font>
							</div>
							<div class="col-lg-5  text-center" style="padding: 5px;">
								<!-- <img src="images/crm3.png" alt="..." class="img-circle"
									height="100px" width="100px"> -->
								<h4>
									<font color="#333333">Varsha Traders</font>
								</h4>
							
								<font style="" color="#4d4d4d"></font>
								 <font style="" color="#66666">	
									<font style="" color="#4d4d4d"><p>Ram Leela Circle<br>
                                       Vidisha (M.P.)</p></font>
                                        <%--  <s:text name="" /></font><br> <font style=""
									color="#66666"> --%>
									
                                       <s:text name="outer.index.contact.varsha_ph.number" /></font><br>
                                       <font style=""
									color="#66666">
									
                                       <s:text name="outer.index.contact.varsha_ph.number1" /></font>
								<font color="#808080">
								<%-- <s:text name="info@varshatraders.com" /> --%></font><br>
									<font color="#808080">
								<s:text name="varsha.traders@gmail.com" /></font>
							</div>
							
							<div class="col-lg-5  text-center" style="padding: 5px;">
								<!-- <img src="images/IMG-20160530-WA0011.jpg" alt="..."
									class="img-circle" height="100px" width="100px"> -->
								<h4>
									<font color="#333333">Kalaa Steels</font>
								</h4>

								<font style="" color="#4d4d4d"></font>
								 <font	style="" color="#66666">	<font style="" color="#4d4d4d"><p>Reetha Phatak<br>
                                       Vidisha (M.P.)</p></font>
                                       
                                  <%--   <s:text name="" /></font><br> <font style=""
									color="#66666">
									 --%>   
                                       <s:text
										name="outer.index.contact.kaala_ph.number" /></font><br>
										<font style=""
									color="#66666">
									   
                                       <s:text
										name="outer.index.contact.kaala_ph.number1" /></font>
								<font color="#808080"><%-- <s:text
										name="info@varshatraders.com" /> --%></font><br>
										<font color="#808080"><s:text
										name="varsha.traders@gmail.com" /></font>
							</div>
						</div>
					</div>
					<br><br> <br>





				</div>
	</section> 
	<!-- 
<div id="g-map" class="no-padding">
	<div class="container-fluid">
		<div class="row">
			<div class="map" id="map"></div>
		</div>
	</div> 
</div -->







	<!-- Footer Area Start -->

	 <section id="footer">
		<%-- <div class="footer_top">
			<div class="container">
				<div class="row">
					<div class="col-md-3 col-sm-6">
						<h3 class="menu_head">Main Menu</h3>
						<div class="footer_menu">
							<ul>
								<li class="active"><a href="#home" class="page-scroll"><s:text
											name="outer.index.home.home" /></a></li>
								<li><a href="#about" class="page-scroll"><s:text
											name="outer.index.home.about" /></a></li>
								<li><a href="#features" class="page-scroll"><s:text
											name="outer.index.home.features" /></a></li>
								<li><a href="modules.jsp" class="page-scroll"><s:text
											name="outer.index.home.modules" /></a></li>
								<li><a href="#pricing_table" class="page-scroll"><s:text
											name="outer.index.home.pricing" /> </a></li>
								<li><a href="#contact" class="page-scroll"><s:text
											name="outer.index.home.contact" /></a></li>
							</ul>
						</div>
					</div>
					<div class="col-md-3 col-sm-6">
						<h3 class="menu_head">Useful Links</h3>
						<div class="footer_menu">
							<ul>
								<li><a href=""
									onclick="PopupCenter('termsAndconditionIndex','Terms&Conditions',800,500);">Terms
										of use</a></li>
								<li><a href=""
									onclick="PopupCenter('privacyPolicyIndex','Privacy Policy',800,500);">Privacy
										Policy</a></li>

							</ul>
						</div>
					</div>
					<div class="col-md-3 col-sm-6">
						<h3 class="menu_head">Contact us</h3>
						<div class="footer_menu_contact">
							<ul>
								<li><i class="fa fa-home"></i> <span> Vanrasoft
										Technologies <br> 2nd Floor,plot No-5,IT park road,<br>
										Loksewa Nagar,Ring Road,Nagpur
								</span></li>
								<li><i class="fa fa-globe"></i> <span>
										+91-80873-56561</span></li>
								<li><i class="fa fa-phone"></i> <span>
										info@vanrasoft.com</span></li>
								<li><i class="fa fa-map-marker"></i> <span>
										www.vanrasoft.com</span></li>
							</ul>
						</div>
					</div>

					<div class="col-md-3 col-sm-6">
						<h3 class="menu_head">Tags</h3>
						<div class="footer_menu tags">
							<a href="#"> Sales</a> <a href="#"> Campaign</a> <a href="#">
								Account</a> <a href="#"> Tickets</a> <a href="#"> Contacts</a> <a
								href="#"> Lead</a> <a href="#"> Assignments</a> <a href="#">
								Inventory</a> <a href="#"> Cases</a> <a href="#"> Expenses</a> <a
								href="#"> Products</a> <a href="#"> Vendors</a> <a href="#">
								Opportunities</a>
						</div>
					</div>

				</div>
			</div>
		</div> --%>

		<div class="footer_b">
			<div class="container">
				<div class="row">
					<div class="col-md-6">
						<div class="footer_bottom">
							<p class="text-block">Copyright &copy; 2018 BirjaSoft
								Technologies All rights reserved.</p>
						</div>
					</div>
					<div class="col-md-6">
						<div class="footer_mid pull-right">
							<ul class="social-contact list-inline">
								<li><a href="https://www.facebook.com/vanra.bhadauria"><i
										class="fa fa-facebook"></i></a></li>
								<li><a href="https://twitter.com/vanrasoft"><i
										class="fa fa-twitter"></i></a></li>
								<li><a href="http://www.skype.com/en/"><i
										class="fa fa-rss"></i></a></li>
								<li><a
									href="https://plus.google.com/u/0/114727328681857245624/about?hl=en"><i
										class="fa fa-google-plus"></i> </a></li>
								<li><a
									href="https://www.linkedin.com/in/vanra-bhadauria-532a48103?trk=hp-identity-name">
										<i class="fa fa-linkedin"></i>
								</a></li>
								<li><a href="#"> <i class="fa fa-pinterest"></i></a></li>
							</ul>
						</div>
					</div>

				</div>
			</div>
		</div>
	</section>  
	<!-- Footer Area End -->



	<!-- Back To Top Button -->
	<!--  <div id="back-to-top" data-spy="affix" data-offset-top="10" class="back-to-top affix">
                <button class="btn btn-primary" title="Back to Top"><i class="fa fa-angle-double-up"></i></button>
            </div> -->
	<div id="back-top">
		<a href="#slider_part" class="scroll" data-scroll>
			<button class="btn btn-primary" title="Back to Top">
				<i class="fa fa-angle-up"></i>
			</button>
		</a>
	</div>
	<!-- End Back To Top Button -->



	<!-- Javascript Files
    ================================================== -->
	<!-- initialize jQuery Library -->

	<!-- initialize jQuery Library -->
	<script type="text/javascript" src="js1/jquery.js"></script>
	<!-- Bootstrap jQuery -->
	<script src="js1/bootstrap.min.js"></script>
	<!-- Owl Carousel -->
	<script src="js1/owl.carousel.min.js"></script>
	<!-- Isotope -->
	<script src="js1/jquery.isotope.js"></script>
	<!-- Pretty Photo -->
	<script type="text/javascript" src="js1/jquery.prettyPhoto.js"></script>
	<!-- SmoothScroll -->
	<script type="text/javascript" src="js1/smooth-scroll.js"></script>
	<!-- Image Fancybox -->
	<script type="text/javascript"
		src="js1/jquery.fancybox.pack.js?v=2.1.5"></script>
	<!-- Counter  -->
	<script type="text/javascript" src="js1/jquery.counterup.min.js"></script>
	<script type="text/javascript" src="js1/waypoints.min.js"></script>
	<script type="text/javascript" src="js1/jquery.bxslider.min.js"></script>
	<script type="text/javascript" src="js1/jquery.scrollTo.js"></script>
	<script type="text/javascript" src="js1/jquery.easing.1.3.js"></script>
	<!-- PrettyPhoto -->
	<script src="js1/jquery.singlePageNav.js"></script>
	<!-- Wow Animation -->
	<script type="js/javascript" src="js1/wow.min.js"></script>
	<!-- Google Map  Source -->
	<%--   <script type="text/javascript" src="js1/gmaps.js"></script> --%>
	<!-- Custom js -->
	<script src="js1/custom.js"></script>

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
	<%-- <script>
		// Google Map - with support of gmaps.js
     var map;
        map = new GMaps({
          div: '#map',
          lat: 23.709921,
          lng: 90.407143,
          scrollwheel: false,
          panControl: false,
          zoomControl: false,
        });

        map.addMarker({
          lat: 23.709921,
          lng: 90.407143,
          title: 'Themeturn',
          infoWindow: { 
            content: '<p> ThemeTurn, Dhanmondhi 27</p>'
          },
          icon: "images/map1.png"
        });
      	</script> --%>



	<script src="../outer/js/gen_validatorv4.js" type="text/javascript"></script>
	 <script type="text/javascript">
		var frmvalidator = new Validator("contactUs");
		frmvalidator.EnableOnPageErrorDisplay();
		frmvalidator.EnableMsgsTogether();

		frmvalidator.addValidation("fullName", "req",
				"Please Enter Your Full Name");
		frmvalidator.addValidation("fullName", "maxlen=100",
				"Full Name Should Be 100 Charcters");
		frmvalidator.addValidation("fullName", "minlen=3",
				"Full Name Must Be More than 3 Charcters");

		frmvalidator.addValidation("emailId", "req", "Please Enter Email Id");
		frmvalidator.addValidation("emailId", "email",
				"Please Enter Valid Email Id");
		frmvalidator.addValidation("emailId", "maxlen=100",
				"Email Id Should Be 100 Characters");
		frmvalidator.addValidation("emailId", "minlen=10",
				"Email Id Must Be 10 Characters");

		frmvalidator.addValidation("mobileNo", "req",
				"Please Enter Mobile Number");
		frmvalidator.addValidation("mobileNo", "maxlen=10",
				"Enter Valid Mobile Number");
		frmvalidator.addValidation("mobileNo", "minlen=10",
				"Enter Valid Mobile Number");

		frmvalidator.addValidation("Comment", "req", "Please Enter Comment");
		frmvalidator.addValidation("Comment", "maxlen=2000",
				"Comment Should Be 2000 Characters");
		frmvalidator.addValidation("Comment", "minlen=30",
				"Comment Must Be 30 Characters");
	</script> 




</body>

</html>
