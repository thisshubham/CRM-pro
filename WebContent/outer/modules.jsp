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
        <title>VANRA CRM - A complete free online solution for Customer
	Relationship Management</title>
        <meta name="description" content="">
        <!-- Mobile Specific Metas
    ================================================== -->
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
         <!-- CSS
         ================================================== -->
        <!-- Bootstrap -->
        <link rel="stylesheet" href="css1/bootstrap.min.css"/>
        <!-- FontAwesome -->
        <link rel="stylesheet" href="css1/font-awesome.min.css"/>
        <!-- Animation -->
        <link rel="stylesheet" href="css1/animate.css" />
        <!-- Owl Carousel -->
        <link rel="stylesheet" href="css1/owl.carousel.css"/>
         <link rel="stylesheet" href="css1/owl.theme.css"/>
         <!-- Pretty Photo -->
         <link rel="stylesheet" href="css1/prettyPhoto.css"/>
         <link rel="stylesheet" href="css1/flexslider.css"/>
         <link rel="stylesheet" href="css1/red.css"/>

        <!-- Template styles-->
        <link rel="stylesheet" href="css1/custom.css" />
        <link rel="stylesheet" href="css1/responsive.css" />
        <link rel="stylesheet" href="css1/jquery.fancybox.css?v=2.1.5" type="text/css" media="screen" />
	
		<%-- <%-- <script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false"></script> --%>
        <link href='http://fonts.googleapis.com/css?family=Lato:400,300' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Raleway:400,300,500' rel='stylesheet' type='text/css'> --%>
    </head>

 <body data-spy="scroll" data-target=".navbar-fixed-top">
        <!--[if lt IE 7]>
            <p class="browsehappy">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
        <![endif]-->

    <header id="header" class="navbar-fixed-top navbar-inverse video-menu" role="banner">
    	<div class="container">
    		<!-- <div class="row"> -->
                 <div class="navbar-header " style="margin-left:-8px;">
                     <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href="index.jsp">
                                <img src="images/trans_vanra.png"  alt="">
                        </a>
                 </div><!--Navbar header End-->
                 	<nav class="collapse navbar-collapse navigation" id="bs-example-navbar-collapse-1" role="navigation">
                        <ul class="nav navbar-nav navbar-right ">
                           	<li class="active"> <a href="index.jsp" class="page-scroll"><s:text name="outer.index.home.home"/></a></li>
                            <li><a href="index.jsp" class="page-scroll" ><s:text name="outer.index.home.about"/></a> </li>
                            <li><a href="index.jsp"  class="page-scroll"><s:text name="outer.index.home.features"/></a> </li>
                            <li><a href="#modules" class="page-scroll"><s:text name="outer.index.home.modules"/></a> </li>
                            <li><a href="index.jsp" class="page-scroll"><s:text name="outer.index.home.pricing"/> </a> </li>
                            <li><a href="index.jsp" class="page-scroll"><s:text name="outer.index.home.contact"/></a> </li>
                            
                        </ul>
                     </nav>
                </div><!-- /.container-fluid -->
</header>
 <%-- <!-- Slider start -->
    <section id="home" class="hero landing hero-section">
        <div class="video-background-container">
            <video preload="auto" autoplay loop muted class="video-background">
                <source type="video/mp4" src="videos/CRM Video 2_x264.mp4" />
                <source type="video/ogg" src="videos/CRM Video 2_x264.ogv" />
                <source type="video/webm" src="videos/CRM Video 2_x264.webm" />
            </video>
        </div> 

        <div class="parallax-overlay"></div>

        <div class="container">
            <div class="hero-content text-center">
                <div class="hero-text wow fadeIn" data-wow-delay=".8s">
				<img src="images/CRM Logo 120px X 250px.png" alt="VANRA CRM" align="center" width="250px"
					height="120px" />
                    <h3 class="hero-title"><span><s:text name="outer.index.home.headercontent1"/></h3>
                    <p class="hero-description"><s:text name="outer.index.home.headercontent2"/></p>
                    <p class="hero-buttons">
                        <a href="../userlogin.action" class="btn btn-dark">
                            <strong>User Login </strong> </i>
                        </a>
                         <a href="../omerainvoice.action" class="btn btn-main featured">
                            <strong>Register Now </strong></i>
                        </a>

                    </p>
                </div><!--/ Hero text end -->
            </div><!--/ Hero content end -->
        </div><!--/ Container end -->
    </section><!--/ Home end -->
	
	<!-- About us start --> --%>






<!-- Portfolio works Start -->

    <section id="modules">
        <!-- <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="feature_header text-center">
                        <h3 class="feature_title">MODULES</b></h3>
                        
                        <div class="dividerline"></div><div class="divider"></div>
                    </div>
                </div>  Col-md-12 End
            </div>
        </div> -->


    <div id="isotope-filter" class="skew3 text-center" style="margin-top: 30px;">
        <a data-filter="*"  href="#" class="active ">All</a>
        <a data-filter=".identity"  href="#" class="">Dashboard</a>
        <a data-filter=".web-design" href="#"  class="">Reports</a>
        <a data-filter=".graphic"  href="#" class="">Essentials</a>
        <a data-filter=".logo"  href="#" class="">Marketing</a>
        <a data-filter=".identity"  href="#" class="">Sales</a>
        <a data-filter=".web-design" href="#"  class="">Inventory</a>
        
        <a data-filter=".logo"  href="#" class="">Expenses</a>
        <a data-filter=".logo"  href="#" class="">Support</a>
    </div>
    <div class="clearfix"></div>
   			<div class="text-center container"> 	
              <ul class="portfolio-wrap" id="portfolio_items">
                    <li class="col-md-4 col-xs-12 col-sm-6 single-portfolio identity web-design">
                        <figure>
                            <img src="images/vcrm/Dashboard.jpg" alt="" class="img-responsive" style="padding:5px;"/>
                            <figcaption>
                                <h5><s:text name="outer.index.modules.dashboard"/></h5>
                                <p class="links">
                                    <a href="#"> <i class="fa fa-plus"></i></a>
                                    <a href="images/vcrm/Dashboard.jpg" data-rel="prettyPhoto" >
                                        <i class="fa fa-link"></i>
                                    </a>
                                </p>
                                <p class="description">
                                    <s:text name="outer.index.modules.dashboard_description"/>
                                </p>
                            </figcaption>
                        </figure>
                    </li>

                    <li class="col-md-4 col-xs-12 col-sm-6 single-portfolio logo graphic">
                        <figure>
                        <img src="images/vcrm/Report Page.jpg" alt="" class="img-responsive" style="padding:5px;" />
                            <figcaption>
                                <h5><s:text name="outer.index.modules.reports"/></h5>
                                <p class="links">
                                    <a href="#"> <i class="fa fa-link"></i></a>
                                    <a href="images/vcrm/Report Page.jpg"  data-rel="prettyPhoto">
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
                            <img src="images/vcrm/Ticket Page.jpg" alt="" class="img-responsive" style="padding:5px;"/>
                            <figcaption>
                                <h5><s:text name="outer.index.modules.essentials"/></h5>
                                <p class="links">
                                    <a href="#"> <i class="fa fa-link"></i></a>
                                    <a href="images/vcrm/Ticket Page.jpg" data-rel="prettyPhoto">
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
                            <img src="images/vcrm/Assignment.jpg" alt="" class="img-responsive" style="padding:5px;" />
                            <figcaption>
                                <h5><s:text name="outer.index.modules.marketing"/></h5>
                                <p class="links">
                                    <a href="#"> <i class="fa fa-link"></i></a>
                                    <a href="images/vcrm/Assignment.jpg" data-rel="prettyPhoto">
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
                            <img src="images/vcrm/Ticket Page.jpg" alt="" class="img-responsive" style="padding:5px;" />
                            <figcaption>
                                <h5><s:text name="outer.index.modules.sales"/></h5>
                                <p class="links">
                                    <a href="#"> <i class="fa fa-link"></i></a>
                                    <a href="images/vcrm/Ticket Page.jpg" data-rel="prettyPhoto">
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
                            <img src="images/vcrm/Product Page.jpg" alt="" class="img-responsive" style="padding:5px;" />
                            <figcaption>
                                <h5><s:text name="outer.index.modules.inventory"/></h5>
                                <p class="links">
                                    <a href="#"> <i class="fa fa-link"></i></a>
                                    <a href="images/vcrm/Product Page.jpg" data-rel="prettyPhoto">
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
                            <img src="images/vcrm/Product Page.jpg" alt="" class="img-responsive" style="padding:5px;" />
                            <figcaption>
                                <h5><s:text name="outer.index.modules.projects"/></h5>
                                <p class="links">
                                    <a href="#"> <i class="fa fa-link"></i></a>
                                    <a href="images/vcrm/Product Page.jpg" data-rel="prettyPhoto">
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
                            <img src="images/vcrm/Monthly Expenses Page.jpg" alt="" class="img-responsive" style="padding:5px;" />
                            <figcaption>
                                <h5><s:text name="outer.index.modules.expenses"/></h5>
                                <p class="links">
                                    <a href="#"> <i class="fa fa-link"></i></a>
                                    <a href="images/vcrm/Monthly Expenses Page.jpg" data-rel="prettyPhoto">
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
                            <img src="images/vcrm/Contact.jpg" alt="" class="img-responsive" style="padding:5px;"/>
                            <figcaption>
                                <h5><s:text name="outer.index.modules.support"/></h5>
                                <p class="links">
                                    <a href="#"> <i class="fa fa-link"></i></a>
                                    <a href="images/vcrm/Contact.jpg" data-rel="prettyPhoto">
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





<!-- Testimonial Start -->

<!-- Section Testimonial End -->

<!-- Testimonial Area End -->

<!-- Client Carousel Start -->
 
  
<!-- Client Carousel End -->













<!-- Footer Area Start -->

<section id="footer">
    <div class="footer_top">
        <div class="container">
            <div class="row">
                <div class="col-md-3 col-sm-6">
                    <h3 class="menu_head">Main Menu</h3>
                    <div class="footer_menu">
                        <ul>
                            <li class="active"> <a href="index.jsp" class="page-scroll"><s:text name="outer.index.home.home"/></a></li>
                            <li><a href="index.jsp" class="page-scroll" ><s:text name="outer.index.home.about"/></a> </li>
                            <li><a href="index.jsp"  class="page-scroll"><s:text name="outer.index.home.features"/></a> </li>
                            <li><a href="#" class="page-scroll"><s:text name="outer.index.home.modules"/></a> </li>
                            <li><a href="index.jsp" class="page-scroll"><s:text name="outer.index.home.pricing"/> </a> </li>
                            <li><a href="index.jsp" class="page-scroll"><s:text name="outer.index.home.contact"/></a> </li>
                        </ul>
                    </div>
                </div>
                <div class="col-md-3 col-sm-6">
                    <h3 class="menu_head">Useful Links</h3>
                    <div class="footer_menu">
                        <ul>
                            <li><a href="" onclick="PopupCenter('termsAndconditionIndex','Terms&Conditions',800,500);">Terms of use</a></li>
                            <li><a href="" onclick="PopupCenter('privacyPolicyIndex','Privacy Policy',800,500);">Privacy Policy</a></li>
                           
                        </ul>
                    </div>
                </div>
                <div class="col-md-3 col-sm-6">
                    <h3 class="menu_head">Contact us</h3>
                    <div class="footer_menu_contact">
                        <ul>
                            <li> <i class="fa fa-home"></i>
                                <span> Vanrasoft Technologies <br> 2nd Floor,plot No-5,IT park road,<br>
                                 Loksewa Nagar,Ring Road,Nagpur </span></li>
                            <li><i class="fa fa-globe"></i>
                                <span> +91-80873-56561</span></li>
                            <li><i class="fa fa-phone"></i>
                                <span> info@vanrasoft.com</span></li>
                            <li><i class="fa fa-map-marker"></i>
                            <span> www.vanrasoft.com</span></li>
                        </ul>
                    </div>
                </div>

                <div class="col-md-3 col-sm-6">
                    <h3 class="menu_head">Tags</h3>
                    <div class="footer_menu tags">
                        <a href="#"> Sales</a>
                        <a href="#"> Campaign</a>
                        <a href="#"> Account</a>
                        <a href="#"> Tickets</a>
                        <a href="#"> Contacts</a>
                        <a href="#"> Lead</a>
                        <a href="#"> Assignments</a>
                        <a href="#"> Inventory</a>
                        <a href="#"> Cases</a>
                        <a href="#"> Expenses</a>
                        <a href="#"> Products</a>
                        <a href="#"> Vendors</a>
                        <a href="#"> Opportunities</a>
                    </div>
                </div>

            </div>
        </div>
    </div>

    <div class="footer_b">
        <div class="container">
            <div class="row">
                <div class="col-md-6">
                    <div class="footer_bottom">
                        <p class="text-block">Copyright &copy; 2015 Vanrasoft Technologies All rights reserved. </p>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="footer_mid pull-right">
                        <ul class="social-contact list-inline">
                            <li> <a href="https://www.facebook.com/vanra.bhadauria"><i class="fa fa-facebook"></i></a></li>
                            <li> <a href="https://twitter.com/vanrasoft"><i class="fa fa-twitter"></i></a></li>
                            <li> <a href="http://www.skype.com/en/"><i class="fa fa-rss"></i></a></li>
                            <li> <a href="https://plus.google.com/u/0/114727328681857245624/about?hl=en"><i class="fa fa-google-plus"></i> </a></li>
                            <li><a href="https://www.linkedin.com/in/vanra-bhadauria-532a48103?trk=hp-identity-name"> <i class="fa fa-linkedin"></i></a></li>
                            <li><a href="#"> <i class="fa fa-pinterest"></i></a></li>
                        </ul>
                    </div>
                </div>

            </div>
        </div>
    </div>
</section>
<!-- Footer Area End -->




    <div id="back-top">
        <a href="#slider_part" class="scroll" data-scroll>
            <button class="btn btn-primary" title="Back to Top"><i class="fa fa-angle-up"></i></button>
        </a>
    </div>
    <!-- End Back To Top Button -->



<!-- Javascript Files
    ================================================== -->
    <!-- initialize jQuery Library -->
    
    <!-- pop-up  --> 
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
        <script type="text/javascript" src="js1/jquery.fancybox.pack.js?v=2.1.5"></script>
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
      
      	
      	
      	
      	
      	
 
    </body>

</html>
