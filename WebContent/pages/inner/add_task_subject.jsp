<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="/struts-jquery-tags" prefix="sj"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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

<script type="text/javascript">
	var xmlhttp;
	if (window.XMLHttpRequest) {
		xmlhttp = new XMLHttpRequest();
	} else {
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}

	/* This function will check the existing lead title*/
	function isTaskSubjectExist(taskSubject) {
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				document.getElementById("server1Response").innerHTML = xmlhttp.responseText;
			}
		};
		xmlhttp.open("GET", "isTaskSubjectExists.action?taskSubject=" + taskSubject,
				true);
		xmlhttp.send();
	}
</script>


<style type="text/css">
.infoIcon {
	height: 15px;
	width: 15px;
	border: solid 2px;
	border-radius: 10px;
	display: inline;
}

.tableScroll {
	overflow-x: scroll;
	overflow: display;
	height: 350px;
}
</style>
</head>
<body>
	<div class="container">
		<!--BEGIN INPUT TEXT FIELDS-->
		<div class="row">
			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
				<div class="box dark">
					<header>
					<h5>
						<s:text name="add.task.subject" />
					</h5>
					</header>
 

					<div class="row">
						<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 ">

							<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 ">
								<div class="alert alert-info" role="alert"
									style="margin-top: 20px;">
									<p>
										<s:if test="hasActionErrors()">
											<s:actionerror />
										</s:if>
										<s:elseif test="hasActionMessages()">
											<s:actionmessage />
										</s:elseif>
										<s:else>
											<div class="infoIcon">
												<span class="fa fa-info" style="margin-left: 3px;"></span>
											</div>&nbsp;&nbsp;&nbsp;<s:text
												name="add.task.subject.infobar" />
										</s:else>
									</p>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
							<s:form name="taskSubjectForm" action="addTaskSubject"
								class="form-horizontal" id="block-validate">
								<div class="row">
									<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 ">
										<div class="col-lg-8 col-md-8 col-sm-8 col-xs-5 ">
											<s:textfield name="taskSubject" id="taskSubject"
												placeholder="Enter Task Subjcet" cssClass="form-control"
												onblur="isTaskSubjectExist(taskSubject.value);" ></s:textfield>
											<div id='taskSubjectForm_taskSubject_errorloc'
												class="error_strings" style="color: red;"></div>
											<div id="server1Response" style="color: red;"></div>
										</div>
										<div class="col-lg-4 col-md-4 col-sm-4 col-xs-7">
											<button class="btn btn-primary">
												<s:text name="lead.title.model.add" />
											</button>
											 <button class="btn btn-default" onclick="window.close();">
												<s:text name="project.form.button.cancel" />
											</button>
										</div>
									</div>
								</div>

							</s:form>
						</div>
					</div>
					<div class="row">
						<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"
							style="margin-top: 20px;">
							<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 tableScroll">

								<table class="table table-bordered responsive-table"
									id="dataTable" class="">
									<thead style="background-color: gray; color: white;">
										<tr>
											<th><s:text name="add.task.subject" /></th>
										</tr>
									</thead>
									<tbody>
										<s:iterator value="taskSubjectListIntoGrid">
											<tr>
												<td><s:property value="taskSubject" /></td>
											</tr>
										</s:iterator>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script>
		$(function() {
			Metis.formGeneral();
			Metis.formWysiwyg();
		});
	</script>
	<script type="text/javascript">
		if (window.opener != null && !window.opener.closed) {
			window.opener.location.reload();
		}
	</script>

	<script src="outer/js/gen_validatorv4.js" type="text/javascript"></script>
	<script type="text/javascript">
		var frmvalidator = new Validator("taskSubjectForm");
		frmvalidator.EnableOnPageErrorDisplay();
		frmvalidator.EnableMsgsTogether();

		//Validation for lead title.
		frmvalidator.addValidation("taskSubject", "req", "Enter Task Subject");
		frmvalidator.addValidation("taskSubject", "maxlen=50",
				"Maximun Length Of Task Subject Should Be 50 Characters");
	</script>
</body>
</html>