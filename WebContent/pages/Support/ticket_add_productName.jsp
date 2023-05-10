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

	/* This function will check the existing Product Name*/
	function isCasesProductNameExist(productName) {
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				document.getElementById("server1Response").innerHTML = xmlhttp.responseText;
			}
		};
		xmlhttp.open("GET", "isTicketProductNameExist.action?productName=" + productName,
				true);
		xmlhttp.send();
	}
</script>


<style type="text/css">
.infoIcon {
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
				<div class="box">
					<header>
					<div class="pull-left">
						<a class="icons" type="button" onclick="window.close();" href=""
							data-toggle="tooltip" style="color: black;"
							data-original-title="Back To New Ticket"> <i
							class="fa fa-th-large"></i>
						</a>
						<h5>
							<s:text name="Support.cases.product.name" />
						</h5>
					</div>
					<div class="pull-right">
						<a type="button" onclick="window.close();" data-toggle="tooltip"
							data-original-title="Close" style="height: 32px;" href=""
							class="btn btn-danger btnheight"><i
							class="fa fa-times fontawesomeht"></i></a>
					</div>
					</header>
					<div class="row">
						<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 ">
							<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 ">
								<p>
									<s:if test="hasActionErrors()">
										<div class="alert alert-danger" role="alert"
											style="margin-top: 25px; padding-bottom: 7px;">
											<div class="infoIcon">

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
										<div class="alert alert-info" role="alert"
											style="margin-top: 25px;">
											<div class="infoIcon">
												<i class="fa fa-info-circle "></i>
												<s:text name="productName.info.bar" />
											</div>
										</div>
									</s:else>
								</p>
							</div>
							<div class="row">
								<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
									<s:form name="productNameForm" action="addTicketProductName"
										class="form-horizontal" id="block-validate">
										<div class="row">
											<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 ">
												<div class="col-lg-8 col-md-8 col-sm-8 col-xs-5 ">
													<s:textfield name="productName" id="productName"
														placeholder="Enter Product Name" cssClass="form-control"
														onblur="isTicketProductNameExist(ProductName.value);" />
													<div id='productNameForm_productName_errorloc'
														class="error_strings" style="color: red;"></div>
													<div id="server1Response" style="color: red;"></div>
												</div>
												<div class="col-lg-4 col-md-4 col-sm-4 col-xs-7">
													<button class="btn btn-primary">
														<s:text name="project.form.button.add" />
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
									<div
										class="col-lg-12 col-md-12 col-sm-12 col-xs-12 tableScroll">
										<table class="table table-bordered responsive-table"
											id="dataTable" class="">
											<thead style="background-color: gray; color: white;">
												<tr>
													<th><s:text name="Support.cases.product.name" /></th>
												</tr>
											</thead>
											<tbody>
												<s:iterator value="ticketProductNameGrid">
													<tr>
														<td><s:property value="productName" /></td>
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
		var frmvalidator = new Validator("productNameForm");
		frmvalidator.EnableOnPageErrorDisplay();
		frmvalidator.EnableMsgsTogether();

		//Validation for lead title.
		frmvalidator.addValidation("productName", "req", "Enter Product Name");
		frmvalidator.addValidation("productName", "maxlen=50",
				"Maximun Length Of Product Name Should Be 50 Characters");
	</script>
</body>
</html>