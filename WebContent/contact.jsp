<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Contact</title>
      <link rel="stylesheet" href="css/components.css">
      <link rel="stylesheet" href="css/responsee.css">
      <link rel="stylesheet" href="owl-carousel/owl.carousel.css">
      <link rel="stylesheet" href="owl-carousel/owl.theme.css">
      <!-- CUSTOM STYLE -->  
      <link rel="stylesheet" href="css/template-style.css">
      <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800&amp;subset=latin,latin-ext' rel='stylesheet' type='text/css'>
      <script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
      <script type="text/javascript" src="js/jquery-ui.min.js"></script>    
      <script type="text/javascript" src="js/modernizr.js"></script>
      <script type="text/javascript" src="js/responsee.js"></script>   
      <!--[if lt IE 9]>
	      <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
        <script src="http://css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js"></script>
      <![endif]-->

  <style>
  body {
    background-color: #f9f9f9;
    font-size: 16px;
    color: #444;
}


.social-wrap { 
margin:0 auto; 
padding:0px; 
text-decoration: none; 

}
.social-wrap ul li { 
list-style-type: none; 
border-bottom:none; 
margin:0 auto; 
background: none; 
padding:0px; 
line-height: 0!important; 
}
.social-wrap li a { 
border-radius: 30px 30px 30px 30px;
margin:5px 3px 0px 0px !important; 
width:45px; 
height:45px; 
text-indent:-99999px;
float:left; 

} 

.social-wrap li a.facebook1 { 
background: black url(https://2.bp.blogspot.com/-heI32-HhzMI/Vpw6xNHQlZI/AAAAAAAAAUw/fgnVjROHRRs/s1600/social-icons.png) no-repeat 0px 0px; 

-webkit-transition:All 0.3s ease-out; 
-moz-transition:All 0.3s ease-out; 
-o-transition:All 0.3s ease-out; 
} 
.social-wrap li a.facebook1:hover { 
background: green url(https://2.bp.blogspot.com/-heI32-HhzMI/Vpw6xNHQlZI/AAAAAAAAAUw/fgnVjROHRRs/s1600/social-icons.png) no-repeat 0px -73px; 
} 
.social-wrap li a.twitter1 { 
background: black url(https://2.bp.blogspot.com/-heI32-HhzMI/Vpw6xNHQlZI/AAAAAAAAAUw/fgnVjROHRRs/s1600/social-icons.png) no-repeat 0px -127px; 
-webkit-transition:All 0.3s ease-out; 
-moz-transition:All 0.3s ease-out; 
-o-transition:All 0.3s ease-out; 
} 
.social-wrap li a.twitter1:hover { 
background: green url(https://2.bp.blogspot.com/-heI32-HhzMI/Vpw6xNHQlZI/AAAAAAAAAUw/fgnVjROHRRs/s1600/social-icons.png) no-repeat 0px -204px; 
} 
.social-wrap li a.google-p1 { 
background:black url(https://2.bp.blogspot.com/-heI32-HhzMI/Vpw6xNHQlZI/AAAAAAAAAUw/fgnVjROHRRs/s1600/social-icons.png) no-repeat 0px -254px; 
-webkit-transition:All 0.3s ease-out; 
-moz-transition:All 0.3s ease-out; 
-o-transition:All 0.3s ease-out; 
} 
.social-wrap li a.google-p1:hover { 
background: green url(https://2.bp.blogspot.com/-heI32-HhzMI/Vpw6xNHQlZI/AAAAAAAAAUw/fgnVjROHRRs/s1600/social-icons.png) no-repeat 0px -330px; 
} 
.social-wrap li a.rss1 { 
background:black url(https://2.bp.blogspot.com/-heI32-HhzMI/Vpw6xNHQlZI/AAAAAAAAAUw/fgnVjROHRRs/s1600/social-icons.png) no-repeat 0px -381px; 
-webkit-transition:All 0.3s ease-out; 
-moz-transition:All 0.3s ease-out; 
-o-transition:All 0.3s ease-out; 
} 
.social-wrap li a.rss1:hover { 
background: green url(https://2.bp.blogspot.com/-heI32-HhzMI/Vpw6xNHQlZI/AAAAAAAAAUw/fgnVjROHRRs/s1600/social-icons.png) no-repeat 0px -454px; 
}
.social-wrap li a.pinit1 { 
background:black url(https://2.bp.blogspot.com/-heI32-HhzMI/Vpw6xNHQlZI/AAAAAAAAAUw/fgnVjROHRRs/s1600/social-icons.png) no-repeat 0px -508px; 
-webkit-transition:All 0.3s ease-out; 
-moz-transition:All 0.3s ease-out; 
-o-transition:All 0.3s ease-out; 
} 
.social-wrap li a.pinit1:hover { 
background: green url(https://2.bp.blogspot.com/-heI32-HhzMI/Vpw6xNHQlZI/AAAAAAAAAUw/fgnVjROHRRs/s1600/social-icons.png) no-repeat 0px -580px; 
}
.social-wrap li a.linkdin1 { 
background:black url(https://2.bp.blogspot.com/-heI32-HhzMI/Vpw6xNHQlZI/AAAAAAAAAUw/fgnVjROHRRs/s1600/social-icons.png) no-repeat 0px -635px; 
-webkit-transition:All 0.3s ease-out; 
-moz-transition:All 0.3s ease-out; 
-o-transition:All 0.3s ease-out; 
} 
.social-wrap li a.linkdin1:hover { 
background: green url(https://2.bp.blogspot.com/-heI32-HhzMI/Vpw6xNHQlZI/AAAAAAAAAUw/fgnVjROHRRs/s1600/social-icons.png) no-repeat 0px -711px; 
}
    
.blog-link{
color:#fff;
text-decoration:none;
background:#eee;
background-size:40px;
line-height:50px;
display:inline-block;
padding:0 10px;
border-radius:4px;
border-bottom:3px solid #ddd;
color:#333;
font-family:'open sans',sans-serif;
margin:10px;
}
</style>
  
  
  
  
   </head>
   <body class="size-1140">
      <!-- TOP NAV WITH LOGO -->  
      <header>
         <nav>
            <div class="line">
               <div class="top-nav">              
                  <div class="logo hide-l">
                     <a href="../PROJ201811/">CHOUKSAY<br /><strong>TRADERS</strong></a>
                  </div>                  
                  <p class="nav-text">Custom menu text</p>
                  <div class="top-nav s-12 l-5">
                     <ul class="right top-ul chevron">
                        <li><a href="../PROJ201811/">Home</a>
                        </li>
                        <li><a href="outerCement">Cement</a>
                        </li>
                        <li><a href="outerSteelbar">Steelbars</a>
                        </li>
                     </ul>
                  </div>
                  <ul class="s-12 l-2">
                     <li class="logo hide-s hide-m">
                        <a href="../PROJ201811/">CHOUKSAY<br /><strong>TRADERS</strong></a>
                     </li>
                  </ul>
                  <div class="top-nav s-12 l-5">
                     <ul class="top-ul chevron">
                        <li><a href="outerPaint">Paint</a>
                        </li>
                        <li>
                           <a href="outerAboutUs">About</a>			    
                           <!-- <ul>
                              <li><a>Company 1</a>
                              </li>
                              <li><a>Company 2</a>
                              </li>
                              <li>
                                 <a>Company 3</a>				  
                                 <ul>
                                    <li><a>Company 3-1</a>
                                    </li>
                                    <li><a>Company 3-2</a>
                                    </li>
                                    <li><a>Company 3-3</a>
                                    </li>
                                 </ul> -->
                              </li>
                           </ul>
                        </li>
                        <li><a href="outerContact">Contact</a>
                        </li>
                     </ul> 
                  </div>
               </div>
            </div>
         </nav>
      </header>
      <section>
         <div id="head">
            <div class="line">
               <h1>Contacts Profiles</h1>
            </div>
         </div>
         <div id="content" class="left-align contact-page">
            <div class="line">
               <div class="margin">
                  <div class="s-12 l-6">
                     <h2>Chouksay Brothers</h2>
                     <address>
                        <p><i class="icon-home icon"></i>Bus Stand Shamshabad </p>
                        <p><i class="icon-globe_black icon"></i> Chouksay Brothers</p>
                        <p><i class="icon-mail icon"></i> info@visiondesign.sk</p>
                     </address>
                     <br />
                     <h2>Social</h2>
               
             <!--   <div class='post-body'>
<div class='social-wrap'> 
<ul> 
<li><a class='facebook1' href='https://www.facebook.com/username' target='_blank' title='Facebook' rel='nofollow'></a></li> 
<li><a class='twitter1' href='https://twitter.com/username' target='_blank' title='Twitter' rel='nofollow'></a></li> 
<li><a class='google-p1' href='https://plus.google.com/b/username' target='_blank' title='Google Plus' rel='nofollow'></a></li> 
<li><a class='rss1' href='http://feeds.feedburner.com/username' target='_blaank' title='RSS Feed' rel='nofollow'></a></li> 
<li><a class='pinit1' href='https://www.pinterest.com/username' target='_blank' title='Pinterest' rel='nofollow'></a></li> 
<li><a class='linkdin1' href='https://www.linkedin.com/in/username' target='_blank' title='Linkedin' rel='nofollow'></a></li> 
</ul> 
  </div>
  <div class='credit'>
  <a class='blog-link' href='https://ProBlogWorld.blogspot.com' target='_blank'>Designed by ProBlogWorld</a>
  
</div>
</div> -->
               
               
               
               
               
               
               
               
                  </div>
                  <div class="s-12 l-6">
                     <h2>Message Send By User</h2>
                     <form class="customform" action="">
                        <div class="s-12"><input name="" placeholder="Your e-mail" title="Your e-mail" type="text" /></div>
                        <div class="s-12"><input name="" placeholder="Your name" title="Your name" type="text" /></div>
                        <div class="s-12"><textarea placeholder="Your massage" name="" rows="5"></textarea></div>
                        <div class="s-12 m-6 l-4"><button type="submit">Submit Button</button></div>
                     </form>
                  </div>
               </div>
            </div>
         </div>
         <!-- MAP -->	
         <div id="map-block">  	  
           <!--  <iframe src="https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d682251.1123056135!2d17.063451638281247!3d48.09010461740988!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x476c8cbf758ecb9f%3A0xddeb1d26bce5eccf!2sGallayova+2150%2F19%2C+841+02+D%C3%BAbravka%2C+Slovensk%C3%A1+republika!5e0!3m2!1ssk!2s!4v1412519122400" width="100%" height="450" frameborder="0" style="border:0"></iframe> -->
           <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3658.2260992338174!2d77.82018811441048!3d23.524368984701276!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x397c0463a74f0709%3A0x12341d43a500178a!2sBirjaSoft+Technologies!5e0!3m2!1sen!2sin!4v1538647876146" width="100%" height="450" frameborder="0" style="border:0"></iframe>
         </div>
         <div id="fourth-block">
            <div class="line">
               <div id="owl-demo2" class="owl-carousel owl-theme">
                  <div class="item">
                     <h2>Amazing responsive template</h2>
                     <p class="s-12 m-12 l-8 center">Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat.
                     </p>
                  </div>
                  <div class="item">
                     <h2>Responsive components</h2>
                     <p class="s-12 m-12 l-8 center">Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat.
                     </p>
                  </div>
                  <div class="item">
                     <h2>Retina ready</h2>
                     <p class="s-12 m-12 l-8 center">Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat.
                     </p>
                  </div>
               </div>
            </div>
         </div>
      </section>
    <!-- FOOTER -->   
      <footer>
         <div class="line">
            <div class="s-12 l-6" style="margin-top:11px;">
               <p>Copyright@2018, Doveloped By BirjaSoft Technologies.
               </p>
            </div>
            
            
            <div class="s-12 l-6">
               <p class="left">
                
                
  
<div class='social-wrap' style="margin-left:12%;"> 
<ul> 
<li><a class='facebook1' href='https://www.facebook.com/username' target='_blank' title='Facebook' rel='nofollow'></a></li> 
<li><a class='twitter1' href='https://twitter.com/username' target='_blank' title='Twitter' rel='nofollow'></a></li> 
<li><a class='google-p1' href='https://plus.google.com/b/username' target='_blank' title='Google Plus' rel='nofollow'></a></li> 
<li><a class='rss1' href='http://feeds.feedburner.com/username' target='_blaank' title='RSS Feed' rel='nofollow'></a></li> 
<li><a class='pinit1' href='https://www.pinterest.com/username' target='_blank' title='Pinterest' rel='nofollow'></a></li> 
<li><a class='linkdin1' href='https://www.linkedin.com/in/username' target='_blank' title='Linkedin' rel='nofollow'></a></li> 
</ul> 
  </div>
  

</div>
</div>
      </footer>
      <script type="text/javascript" src="owl-carousel/owl.carousel.js"></script>   
      <script type="text/javascript">
         jQuery(document).ready(function($) {  
           $("#owl-demo").owlCarousel({
         	slideSpeed : 300,
         	autoPlay : true,
         	navigation : false,
         	pagination : false,
         	singleItem:true
           });
           $("#owl-demo2").owlCarousel({
         	slideSpeed : 300,
         	autoPlay : true,
         	navigation : false,
         	pagination : true,
         	singleItem:true
           });
         });	
          
      </script> 
 
</body>
</html>