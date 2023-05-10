<!doctype html>
<html class="no-js">

<!-- Mirrored from demo.onokumus.com/metis/form-general.html by HTTrack Website Copier/3.x [XR&CO'2014], Mon, 16 Mar 2015 13:20:25 GMT -->
<head>
<meta charset="UTF-8">
<title>Form General</title>

<!--IE Compatibility modes-->
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<!--Mobile first-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Bootstrap -->
<link rel="stylesheet"
	href="pages/inner/assets/lib/bootstrap/css/bootstrap.min.css">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="pages/inner/assets/lib/font-awesome/css/font-awesome.min.css">
<!-- Metis core stylesheet -->
<link rel="stylesheet" href="pages/inner/assets/css/main.min.css">
<link rel="stylesheet"
	href="pages/inner/assets/lib/bootstrap3-wysihtml5-bower/bootstrap3-wysihtml5.min.css">
<link rel="stylesheet" href="pages/inner/assets/css/style-switcher.css">
<link rel="stylesheet"
	href="pages/inner/assets/lib/metismenu/metisMenu.min.css">
<link rel="stylesheet"
	href="pages/inner/assets/lib/jquery.uniform/themes/default/css/uniform.default.css">
<link rel="stylesheet"
	href="pages/inner/assets/lib/inputlimiter/jquery.inputlimiter.css">
<link rel="stylesheet"
	href="pages/inner/assets/lib/chosen/chosen.min.css">
<link rel="stylesheet"
	href="pages/inner/assets/lib/colorpicker/css/colorpicker.css">
<link rel="stylesheet"
	href="pages/inner/assets/css/colorpicker_hack.css">
<link rel="stylesheet"
	href="pages/inner/assets/lib/tagsinput/jquery.tagsinput.css">
<link rel="stylesheet"
	href="pages/inner/assets/lib/daterangepicker/daterangepicker-bs3.css">
<link rel="stylesheet"
	href="pages/inner/assets/lib/datepicker/css/datepicker.css">
<link rel="stylesheet"
	href="pages/inner/assets/lib/timepicker/css/bootstrap-timepicker.min.css">
<link rel="stylesheet"
	href="pages/inner/assets/lib/switch/css/bootstrap3/bootstrap-switch.min.css">
<link rel="stylesheet"
	href="pages/inner/assets/lib/jasny-bootstrap/css/jasny-bootstrap.min.css">

<link rel="stylesheet"
	href="pages/inner/assets/lib/datatables/3/dataTables.bootstrap.css">


<style type="text/css">
#mynavbar.navbar-default .navbar-nav>.active>a,.navbar-default .navbar-nav>.active>a:hover,.navbar-default .navbar-nav>.active>a:focus
	{
	background-color: #F8F8F8;
}
</style>



<style type="text/css">
#myrow th {
	font-weight: 400;
	background-color: #394B5E;
	color: white;
}
</style>

<style type="text/css">
.error_strings {
	color: red;
}
</style>

<style type="text/css">
.form-horizontal .control-label {
	text-align: left;
}

.modal-body {
	text-align: left;
}

.scrolldashboard {
	overflow-y: scroll;
	height: 330px;
	width: 100%;
}

body {
	margin-bottom: 0px;
}

.Footer,#footer {
	bottom: 0px;
	width: 100%;
	height: auto;
	position: relative;
}

.new {
	color: #00b4f5;
}

.inprogress {
	color: darkgreen;
}

.assigned {
	color: purple;
}

.verified {
	color: #3d8b3d;
}

.closed {
	color: #D43F3A;
}

.deleted {
	color: maroon;
}

.notverified {
	color: orange;
}

.junklead {
	color: black;
}

.futurelead {
	color: gray;
}

.duplicate {
	color: darkblue;
}

.preverified {
	color: #00CCFF;
}

.expired {
	color: orange;
}

#dataTable_paginate {
	float: right;
}

#dataTable_filter {
	float: right;
}

.form-horizontal .control-label {
	text-align: left;
}

.box header h5 {
	font-size: 16px;
}

#viewlable {
	color: #6E6E6E;
}

.btn-line.btn-metis-1 {
	color: gray;
	border-color: #E7E7E7;
}

.btn-line.btn-metis-2 {
	color: gray;
	border-color: #E7E7E7;
}

.btn-line.btn-metis-3 {
	color: gray;
	border-color: #E7E7E7;
}

.btn-line.btn-metis-4 {
	color: gray;
	border-color: #E7E7E7;
}

.btn-line.btn-metis-5 {
	color: gray;
	border-color: #E7E7E7;
}

.btn-line.btn-metis-6 {
	color: gray;
	border-color: #E7E7E7;
}

#view_lable {
	background-color: #FFFFFF;
	text-align: left;
}

#view_lable_value {
	background-color: #FBFBFB;
	padding-left: 0px;
}

#row_a_link {
	color: blue;
}

#view_lable_value {
	background-color: #FBFBFB;
}

#view_lable_value2 {
	background-color: #F7F7F7;
	padding-left: 0px;
}

#dashboard_search_tools {
	padding-top: 15px;
}

#data_grid {
	background-color: #E4E4E4;
	border: 1px;
	border-color: #ffffff;
	padding-top: 15px;
	padding-bottom: 15px;
}

.sparkline {
	padding: 30px 14px 30px 4px;
}

.stats_box .stat_text {
	padding: 30px 10px 7px 0px;
}

.stats_box .stat_text .percent {
	top: 37px;
}

.stats_box li {
	padding: 0px;
}

.dropdown-menu {
	z-index: 1040;
}

#alignleft.list-group-item {
	text-align: left;
}

.img-circle {
	border-radius: 50%;
	height: 70px;
	width: 70px;
}

.infoIcon {
	display: inline;
}

.star {
	display: inline;
	color: red;
}

.quick-icons {
	color: lightgray;
	text-align: center;
	text-decoration: none;
	margin: 10px;
	position: relative;
	display: inline-block;
	height: 42px;
	padding-top: 2px;
}

.quick-icons span {
	display: block;
	color: #394B5E;
}

.btnheight {
	height: 34px;
}

.fontawesomeht {
	padding-top: 3px;
}

.chosen-container-single .chosen-single {
	border-radius: 0px;
}

.input-sm,.form-group-sm .form-control {
	border-radius: 0px;
}

.btn-sm,.btn-group-sm>.btn {
	border-radius: 0px;
}

.btn-xs,.btn-group-xs>.btn {
	border-radius: 0px;
}

a:hover#view {
	color: #337AB7;
}

a:hover#edit {
	color: #8838E0;
}

a:hover#delete {
	color: #D9534F;
}

.box {
	border-top: none;
}

.btnheight_chzselect {
	height: 26px;
}

.header_color {
	color: #394B5E;
}

.viewpage_contentheader {
	color: #CD0067;
}

.button_color {
	background-color: #394B5E;
	border-color: #394B5E;
}

a:hover,a:focus {
	color: #394B5E;
	text-decoration: none;
}

.leaddashfa {
	color: lightgray;
}

.icon {
	color: gray;
}

.searchBar {
	background-color: #ECEDEF;
	margin-bottom: 20px;
}

.btniconcolor {
	color: #394B5E;
}

.viewinnertitle {
	padding-left: unset;
	color: #CD0067;
}

.innertitle {
	color: #CD0067;
}

.hide {
	display: none;
}
/* .breadcrumb {
border-radius:0px;
}
 */

/* .inner {
padding-right:10px;
padding-left: 10px;
} */
</style>
<script src="outer/js/gen_validatorv4.js" type="text/javascript"></script>

</head>

<div class="bg-dark dk" id="wrap">
	<div id="top">

		<!-- .navbar -->
		<nav class="navbar navbar-default navbar-static-top" id="mynavbar">
			<div class="container-fluid">

				<!-- Brand and toggle get grouped for better mobile display -->
				<header class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target=".navbar-ex1-collapse">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a href="omiInnerDashboard.action" class="navbar-brand"> <img
						src="pages/inner/assets/img/trans_vanra.png" alt="VanraCrm"
						style="padding-top: 10px; padding-left: 12px; height: 37px;">
					</a>
				</header>
				<div class="topnav" style="margin-right: 20px;">
					 <a href="customerLogout.action" data-toggle="tooltip"
						data-original-title="Logout" data-placement="bottom"
						class="btn btn-metis-1 btn-sm"> <i class="fa fa-power-off"></i>
					</a>


				</div>
				<div class="collapse navbar-collapse navbar-ex1-collapse">

					<!-- .nav -->
					<!-- <ul class="nav navbar-nav" style="margin-left: 20px;">
						<li><a href="omiInnerDashboard.action"><i
								class="fa fa-home" style="margin-top: 5px;"></i></a></li>

						<li class="dropdown"><a aria-expanded="false" href="#"
							class="dropdown-toggle" data-toggle="dropdown"><i
								class="fa fa-paper-plane-o  icon"></i> Marketing <b
								class="caret"></b> </a>
							<ul class="dropdown-menu">
								<li><a href="campaignDashboard.action"><i
										class="fa fa-bullhorn icon"></i> Campaign</a></li>
								<li><a href="leadDashboard.action"> <i
										class="fa fa-lightbulb-o icon"></i> Leads
								</a></li>
								<li><a href="renderAcccountsDashboard.action"><i
										class="fa fa-building-o icon"></i> Accounts</a></li>
								<li><a href="contactsDashboard.action"><i
										class="fa fa-user"></i> Contacts</a></li>

							</ul></li>

						<li class="dropdown"><a aria-expanded="false" href="#"
							class="dropdown-toggle" data-toggle="dropdown"><i
								class="fa fa-shopping-cart icon"></i> Sales <b class="caret"></b>
						</a>
							<ul class="dropdown-menu">
								<li><a href="leadDashboard.action"><i
										class="fa fa-lightbulb-o icon"></i> Leads </a></li>
								<li><a href="renderAcccountsDashboard.action"><i
										class="fa fa-building-o icon"></i> Accounts</a></li>
								<li><a href="contactsDashboard.action"><i
										class="fa fa-user icon"></i> Contacts</a></li>
								<li><a href="assignmentsDashboard.action"><i
										class="fa fa-tasks icon"></i> Assignments</a></li>

							</ul></li>

						<li><a href="productDashboard.action"><i
								class="fa fa-cube icon"></i> Products</a></li>

						<li><a href="vendorsDashboard.action"><i
								class="fa fa-desktop icon"></i> Vendors</a></li>



						<li class="dropdown"><a aria-expanded="false" href="#"
							class="dropdown-toggle" data-toggle="dropdown"><i
								class="fa fa-money icon"></i> Expenses <b class="caret"></b> </a>
							<ul class="dropdown-menu">
								<li><a href="expensesDasbord.action"><i
										class="fa fa-credit-card icon"></i> Monthly Expenses </a></li>
								<li><a href="expensesDasbordTour.action"><i
										class="fa fa-taxi icon"></i> Tours Expenses</a></li>

							</ul></li>


						<li><a href="dashboard.action"><i
								class="fa fa-folder-open-o icon"></i> File Manager</a></li>

						<li class="dropdown"><a aria-expanded="false" href="#"
							class="dropdown-toggle" data-toggle="dropdown"><i
								class="fa fa-suitcase icon" style="margin-top: 5px;"></i>
								Support<b class="caret"></b></a>
							<ul class="dropdown-menu">
								<li><a href="SupportFaqs.action"> <i
										class="fa fa-question-circle icon"></i> FAQ's
								</a></li>
								<li><a href="#"><i class="fa fa-info-circle  icon"></i>
										Help</a></li>
								<li><a href="SupportCases.action"><i
										class="fa fa-tags icon"></i> Cases</a></li>
								<li><a href="ticketDashboard.action"><i
										class="fa fa-ticket icon"></i> Tickets</a></li>
								<li><a href="serviceContractDashboard.action"><i
										class="fa fa-retweet icon"></i> Service Contract</a></li>
								<li><a href="groupDashboard.action"><i
										class="fa fa-weixin icon"></i> Live Chat</a></li>
								<li><a href="groupDashboard.action"><i
										class="fa fa-flag-o icon"></i> Feedback</a></li>
								<li><a href="renderAcccountsDashboard.action"><i
										class="fa fa-building-o icon"></i> Accounts</a></li>
								<li><a href="contactsDashboard.action"><i
										class="fa fa-user icon"></i> Contacts</a></li>

								<li><a href="firstLogingPro.action"><i
										class="fa fa-user icon"></i> PWD</a></li>
								<li><a href="firstLogingCompanySetting.action"><i
										class="fa fa-user icon"></i> COM</a></li>

							</ul></li>

						<li><a href="crmReports.action"><i class="fa fa-bullhorn"
								style="margin-top: 5px;"></i></a></li>




						<li class="dropdown"><a aria-expanded="false" href="#"
							class="dropdown-toggle" data-toggle="dropdown">Settings<b></b>
						</a></li>

						<li class="dropdown"><a aria-expanded="false" href="#"
							class="dropdown-toggle" data-toggle="dropdown">MyAccounts<b></b>
						</a></li>

					</ul> -->
					<!-- /.nav -->
				</div>
			</div>
			<!-- /.container-fluid -->
		</nav>
		<!-- /.navbar -->


	</div>
	<!-- /#top -->
</div>

<!-- ****************************************************JS*********************************************** -->
<!-- jQuery 2.1.1 -->
<script src="pages/inner/assets/lib/jquery/jquery.min.js"></script>

<!--Bootstrap -->
<script src="pages/inner/assets/lib/bootstrap/js/bootstrap.min.js"></script>

<!-- MetisMenu -->
<script src="pages/inner/assets/lib/metismenu/metisMenu.min.js"></script>
<script
	src="pages/inner/assets/lib/bootstrap3-wysihtml5-bower/bootstrap3-wysihtml5.all.min.js"></script>
<script src="pages/inner/assets/lib/ckeditor/ckeditor.js"></script>
<script src="pages/inner/assets/lib/epiceditor/js/epiceditor.min.js"></script>




<script src="pages/inner/assets/lib/screenfull/screenfull.js"></script>
<script
	src="pages/inner/assets/lib/jquery.uniform/jquery.uniform.min.js"></script>
<script src="pages/inner/assets/lib/inputlimiter/jquery.inputlimiter.js"></script>
<script src="pages/inner/assets/lib/chosen/chosen.jquery.min.js"></script>
<script
	src="pages/inner/assets/lib/colorpicker/js/bootstrap-colorpicker.js"></script>
<script src="pages/inner/assets/lib/tagsinput/jquery.tagsinput.js"></script>
<script src="pages/inner/assets/lib/validVal/js/jquery.validVal.min.js"></script>
<script src="pages/inner/assets/lib/moment/moment.min.js"></script>
<script src="pages/inner/assets/lib/daterangepicker/daterangepicker.js"></script>
<script
	src="pages/inner/assets/lib/datepicker/js/bootstrap-datepicker.js"></script>
<script
	src="pages/inner/assets/lib/timepicker/js/bootstrap-timepicker.min.js"></script>
<script src="pages/inner/assets/lib/switch/js/bootstrap-switch.min.js"></script>
<script src="pages/inner/assets/lib/autosize/jquery.autosize.min.js"></script>
<script
	src="pages/inner/assets/lib/jasny-bootstrap/js/jasny-bootstrap.min.js"></script>
<script src="assets/lib/jquery.sparkline/jquery.sparkline.min.js"></script>
<script src="assets/lib/flot/jquery.flot.js"></script>
<script src="assets/lib/flot/jquery.flot.selection.js"></script>
<script src="assets/lib/flot/jquery.flot.resize.js"></script>
<script src="assets/lib/holderjs/holder.js"></script>

<!-- Metis core scripts -->
<script src="pages/inner/assets/js/core.min.js"></script>

<!-- Metis demo scripts -->
<script src="pages/inner/assets/js/app.min.js"></script>
<script src="pages/inner/assets/js/style-switcher.min.js"></script>





</html>