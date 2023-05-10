<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>dashboard_task_window_three</title>
<style type="text/css">
.error_strings {
	color: red;
}
</style>


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


<!-- Metis core scripts -->
<script src="pages/inner/assets/js/core.min.js"></script>

<!-- Metis demo scripts -->
<script src="pages/inner/assets/js/app.min.js"></script>
<script src="pages/inner/assets/js/style-switcher.min.js"></script>
<!-- validation -->
<script src="outer/js/gen_validatorv4.js" type="text/javascript"></script>

<script>
		$(function() {
			Metis.formGeneral();
		});
	</script>
	



</head>
<body>
	<br>
	<br>

	<div class="container">

		<div class="row">
			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
				<div class="alert alert-info" role="alert">Information</div>
				<div class="panel panel-default">
					<div class="panel-body">
						<form name="myform" id="myform" class="form-horizontal" action=""
							method="post">
							<div class="form-group">
								<label class="col-sm-2 control-label">Subject<span
									class="error_strings">*</span></label>
								<div class="col-sm-10">
									<input type="text" class="form-control" name="subject">
									<div id='myform_subject_errorloc' class="error_strings"></div>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">Description<span
									class="error_strings">*</span></label>
								<div class="col-sm-10">
									<textarea class="form-control" rows="3" name="description"></textarea>
									<div id='myform_description_errorloc' class="error_strings"></div>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">Date<span
									class="error_strings">*</span></label>
								<div class="col-sm-10">
									<div class="input-group bootstrap-datepicker">
										<input type="text" class="form-control" id="dp1" name="date">
										<span class="input-group-addon add-on"><i
											class="fa fa-calendar"></i></span>
									</div>
									<div id='myform_date_errorloc' class="error_strings"></div>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">Time<span
									class="error_strings">*</span></label>
								<div class="col-sm-10">
									<div class="input-group bootstrap-timepicker">
										<input class="timepicker-24 form-control" type="text"
											name="time"> <span class="input-group-addon add-on"><i
											class="fa fa-clock-o"></i></span>
									</div>
									<div id='myform_time_errorloc' class="error_strings"></div>
								</div>
							</div>
							<br /> <br />
							<div class="form-group">
								<div class="col-sm-offset-5 col-sm-7">

									<button class="btn btn-default">Close</button>
									<button class="btn btn-primary">Save</button>
								</div>

							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>




	<!--window1  -->
	<script language="JavaScript" type="text/javascript"
		xml:space="preserve">
		//<![CDATA[
		//You should create the validator only after the definition of the HTML form
		var frmvalidator = new Validator("myform");
		frmvalidator.EnableOnPageErrorDisplay();
		frmvalidator.EnableMsgsTogether();

		frmvalidator.addValidation("subject", "req",
				"* Please enter the subject ");
		frmvalidator.addValidation("description", "req",
				"* Please enter the description ");
		frmvalidator.addValidation("date", "req", "* Please select Date");
		frmvalidator.addValidation("time", "req", "* Please select Time ");
		//]]>
	</script>
</body>
</html>