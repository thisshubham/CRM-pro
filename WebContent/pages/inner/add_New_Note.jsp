<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="/struts-jquery-tags" prefix="sj"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

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
<head>
<style type="text/css">
#buttons {
	display: block;
	float: left;
	height: 50px;
	background: #3498db;
	text-align: center;
	padding: 30px 40px 0 40px;
	position: relative;
	margin: 0 10px 0 0;
	font-size: 20px;
	text-decoration: none;
	color: #fff;
	border-top: 40px solid transparent;
	border-bottom: 40px solid transparent;
	border-left: 40px solid #3498db;
}
</style>
</head>
<body>
	<div id="content">
		<div class="outer">
			<div class="inner bg-light lter">

				<!--BEGIN INPUT TEXT FIELDS-->
				<div class="row">
					<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
						<ol class="breadcrumb" style="margin-top: 10px;">
							<li><a href="omiInnerDashboard.action"><i
									class="fa fa-home"></i></a></li>

							<li class="active"><a href="noteDashboard.action"><s:text
										name="navbar.note.noteDashboard"></s:text></a></li>
							<li class="active"><s:text name="note.dashboard.newNote"></s:text></li>
						</ol>
						<s:form name="addCreatedNoteForm" action="newNote"
							class="form-horizontal" id="block-validate">
							<div class="box dark">
								<header>
								<div class="pull-left">
									<a class="icons" href="noteDashboard.action"
										data-toggle="tooltip"
										data-original-title="Back To Note DashBoard"
										style="color: black;"> <i class="fa fa-th-large"></i>
									</a>
									<h5>
										<s:text name="note.dashboard.newNote" />
									</h5>
								</div>
								<div class="pull-right">
									<div class="btn-group">
										<a class="btn btn-default btnheight" data-toggle="tooltip"
											data-original-title="Help"><i class="fa fa-question"></i>
											<s:text name="project.form.button.help"></s:text> </a>
										<button type="submit" data-toggle="tooltip"
											data-original-title="Save" class="btn btn-primary btnheight">
											<i class="fa fa-check"></i>
											<s:text name="project.form.button.save"></s:text>
										</button>
										<a href="newNote.action" data-toggle="tooltip"
											data-original-title="Refresh"
											class="btn btn-success btnheight"><i
											class="fa fa-refresh "></i></a> <a href="noteDashboard.action"
											data-toggle="tooltip" data-original-title="Close"
											class="btn btn-danger btnheight"><i
											class="fa fa-times fontawesomeht"></i></a>
									</div>

								</div>
								</header>
								<div class="container-fluid">
									<p>
										<s:if test="hasActionErrors()">
											<div class="alert alert-danger" role="alert"
												style="margin-top: 25px; padding-bottom: 7px;">
												<div class="infoIcon">
													<i class="fa fa-times-circle "></i>
													<s:actionerror />
												</div>
											</div>
										</s:if>
										<s:elseif test="hasActionMessages()">
											<div class="alert alert-success" role="alert"
												style="margin-top: 25px; padding-bottom: 7px;">
												<div class="infoIcon">
													<!-- <i class="fa fa-check-circle "></i> -->
													<s:actionmessage />
												</div>
											</div>
										</s:elseif>
										<s:else>

											<div class="alert alert-Info" role="alert"
												style="margin-top: 25px;">
												<div class="infoIcon">
													<i class="fa fa-info-circle "></i>
													<s:text name="note.noteDashboard.information.bar" />
												</div>
											</div>
										</s:else>
									</p>

									<div class="row">
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="note.addNote.note.title" />
													<div class="star">*</div>
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<div id='addCreatedNoteForm_noteTitle_errorloc'
														class="error_strings"></diV>
													<s:textfield type="text" name="noteTitle"
														cssClass="form-control" tabindex="1" />

												</div>
											</div>
										</div>
									</div>

									<div class="row">
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="note.addNote.note.tag" />
												</div>
												<div class="col-lg-3 col-md-3 col-sm-3 col-xs-12">
													<div class="input-group">
														<input type="radio" value="Personal" name="noteTag" />
														<div id="button" class="btn btn-primary">Personal</div>
													</div>
												</div>

												<div class="col-lg-3 col-md-3 col-sm-3 col-xs-12">
													<div class="input-group">
														<input type="radio" value="Official" name="noteTag" />
														<button type="button" class="btn btn-success">Official</button>
													</div>
												</div>
												<div
													class="col-lg-1 col-md-1
												 col-sm-3 col-xs-12">
													<div class="input-group">
														<input type="radio" value="Public" name="noteTag" />
														<button type="button" class="btn btn-warning">Public</button>
													</div>
												</div>
											</div>

										</div>
									</div>
									<div class="form-group">
										<div class="row" style="margin: 1% 2%;" id="data_grid">
											<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
												<div id='addCreatedNoteForm_noteDescription_errorloc'
													class="error_strings"></div>
												<s:textarea id="wysihtml5" name="noteDescription"
													class="form-control" rows="10" tabindex="37">
												</s:textarea>

											</div>
										</div>
									</div>
									<hr style="margin-top: 20px">
									<div class="row">
										<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"
											align="center">
											<a href="noteDashboard.action" data-toggle="tooltip"
												data-original-title="Cancel"
												class="btn btn-default btnheight"><i
												class="fa fa-caret-square-o-left fontawesomeht"></i> <s:text
													name="project.form.button.cancel"></s:text></a> <a
												href="newNote.action" data-toggle="tooltip"
												data-original-title="Reset"
												class="btn btn-success btnheight"><i
												class="fa fa-refresh "></i> <s:text
													name="project.form.button.reset"></s:text></a>
											<button type="submit" data-toggle="tooltip"
												data-original-title="Save" class="btn btn-primary btnheight">
												<i class="fa fa-check"></i>
												<s:text name="project.form.button.save"></s:text>
											</button>

										</div>
									</div>
								</div>
							</div>
						</s:form>
					</div>
				</div>

			</div>
		</div>
	</div>


	<script src="pages/inner/assets/js/calculater.js"></script>
	<script>
		$(function() {
			Metis.formGeneral();
			Metis.formWysiwyg();
		});
	</script>
	<script src="/outer/js/gen_validatorv4.js" type="text/javascript"></script>
	<script type="text/javascript">
		var frmvalidator = new Validator("addCreatedNoteForm");
		frmvalidator.EnableOnPageErrorDisplay();
		frmvalidator.EnableMsgsTogether();

		frmvalidator.addValidation("noteTitle", "req",
				"Please write Note Title Here");

		frmvalidator.addValidation("noteDescription", "req",
				"Please write Note Description Here");
		frmvalidator.addValidation("noteDescription", "maxlen=4000",
				"Note Description Should Be 4000 Charecter");
		frmvalidator.addValidation("noteDescription", "minlen=3",
				"Note Description should be at least 3 Charecter");
	</script>
</body>
</html>