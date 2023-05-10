<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- Bootstrap -->
<link rel="stylesheet"
	href="pages/inner/assets/lib/bootstrap/css/bootstrap.min.css">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="pages/inner/assets/lib/font-awesome/css/font-awesome.min.css">
<!-- Metis core stylesheet -->
<link rel="stylesheet" href="pages/inner/assets/css/main.min.css">


<!-- Script for ajax call for email -->
<script type="text/javascript">
	var xmlhttp;
	if (window.XMLHttpRequest) {
		xmlhttp = new XMLHttpRequest();
	} else {
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}

	/* This function will check the existing email id */
	function emailIdExists(primaryEmailId) {

		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				document.getElementById("server1Response").innerHTML = xmlhttp.responseText;
			}
		};
		xmlhttp.open("GET", "emailIdExists.action?primaryEmailId="
				+ primaryEmailId, true);
		xmlhttp.send();
	}
</script>
<!-- / Script for ajax call for email -->
<style type="text/css">
.infoIcon {
	height: 15px;
	width: 15px;
	border: solid 2px;
	border-radius: 10px;
	display: inline;
}

.star {
	display: inline;
	color: red;
}

.red {
	color: red;
}
</style>
</head>
<body>
	<div class="container">
		<s:form action="addUser" name="AddUserForm" method="post">
			<div class="row">
				<div class="col-sm-12 col-md-12 col-xs-12">
					<div class="box dark">
						<header>
						<h5>
							<s:text name="add.user.heading.user.details"></s:text>
						</h5>
						</header>
						<div class="row" style="padding: 20px;">
							<div class="row">
								<div class="col-sm-12 col-md-12 col-xs-12">
									<div class="alert alert-info" role="alert"
										style="margin-top: 10px; margin-left: 10px; margin-right: 10px;">
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
												</div>&nbsp;&nbsp;&nbsp;<s:text name="add.user.information.bar" />
											</s:else>
										</p>
									</div>

								</div>
							</div>

							<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"
								style="margin-top: 20px;">
								<div class="row form-group">
									<div class="col-lg-4 col-md-4 col-sm-3 col-xs-3">
										<label for="text1" class="control-label"> <s:text
												name="add.user.full.name" />
											<div class="star">*</div>
										</label>
									</div>
									<div class="col-lg-8 col-md-8 col-sm-8 col-xs-8">
									<div class="row form-group">
										<div class="col-lg-2 col-md-2 col-sm-4 col-xs-4">
											<s:select name="salutation" list="salutationList"
												cssClass="form-control" />
												<div id="AddUserForm_salutation_errorloc" class="red"></div>
										</div>
										<div class="col-lg-6 col-md-6 col-sm-8 col-xs-8">
											<s:textfield cssClass="form-control" name="fullName"></s:textfield>
											<div id="AddUserForm_fullName_errorloc" class="red"></div>
										</div>
									</div>

									</div>
								</div>
							</div>

							<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
								<div class="row form-group">
									<div class="col-lg-4 col-md-4 col-sm-3 col-xs-3">
										<label for="text1" class="control-label"> <s:text
												name="add.user.email.id" />
											<div class="star">*</div>
										</label>
									</div>
									<div class="col-lg-8 col-md-8 col-sm-8 col-xs-8">
										<div class="row">
											<div class="col-lg-6 col-md-6 col-sm-10 col-xs-10">
												<s:textfield cssClass="form-control" name="primaryEmailId"
													theme="css_xhtml" id="emailId"
													onblur="emailIdExists(primaryEmailId.value);"></s:textfield>
												<div id="AddUserForm_primaryEmailId_errorloc" class="red"></div>
											</div>
											<div class="col-lg-2 col-md-2 col-sm-1 col-xs-1 ">
												<div class="row pull-right" id="server1Response"
													style="margin-left: 0px; margin-top: px"></div>
											</div>
										</div>
									</div>
								</div>
							</div>


							<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
								<div class="row form-group">
									<div class="col-lg-4 col-md-4 col-sm-3 col-xs-3">
										<label for="text1" class="control-label"> <s:text
												name="add.user.user.role" />
											<div class="star">*</div>
										</label>
									</div>
									<div class="col-lg-8 col-md-8 col-sm-8 col-xs-8">
										<s:select name="userRole" headerKey="1"
											cssClass="form-control" headerValue="Please Select User Role"
											list="userRoleList"></s:select>
										<div id="AddUserForm_userRole_errorloc" class="red"></div>
									</div>
								</div>
							</div>

						 <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
								<div class="row form-group">
									<div class="col-lg-4 col-md-4 col-sm-3 col-xs-3">
										<label for="text1" class="control-label"> <s:text
												name="Shop Name" />
											<div class="star">*</div>
										</label>
									</div>
									<div class="col-lg-8 col-md-8 col-sm-8 col-xs-8">
										<s:select name="shopName" headerKey="1" cssClass="form-control"
											headerValue="Select Branch" list="shopNameList"></s:select>
										<div id="AddUserForm_country_errorloc" class="red"></div>
									</div>
								</div>	
							</div> 
						
							<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
								<div class="row form-group">
									<div class="col-lg-4 col-md-4 col-sm-3 col-xs-3">
										<label for="text1" class="control-label"> <s:text
												name="add.create.lead.country" />
											<div class="star">*</div>
										</label>
									</div>
									<div class="col-lg-8 col-md-8 col-sm-8 col-xs-8">
										<s:select name="country" headerKey="1" cssClass="form-control"
											headerValue="Select Country" list="cuntryList"></s:select>
										<div id="AddUserForm_country_errorloc" class="red"></div>
									</div>
								</div>	<hr>
							</div>
							<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" align="center">
										<s:reset cssClass="btn btn-default" onclick="window.close()"
											key="project.form.button.cancel" theme="simple" />
										<s:reset cssClass="btn btn-success"
											key="project.form.button.reset" theme="simple"
											onclick="window.location.reload();" />
										<s:submit cssClass="btn btn-primary"
											key="project.form.button.submit" theme="simple" />
								</div>
							</div>
						</div>
					</div>
				</div>
			
		</s:form>
	</div>

	<!-- Validation Parts -->
	<script src="outer/js/gen_validatorv4.js" type="text/javascript"></script>
	<script type="text/javascript">
		var v = new Validator("AddUserForm");
		v.EnableOnPageErrorDisplay();
		v.EnableMsgsTogether();
		v.addValidation("fullName", "maxlen=33",
				"Please Enter max 33 character");

		v.addValidation("fullName", "req", "Please Enter Your Full Name");
		v.addValidation("salutation", "dontselect=8", "Select Salutataion");

		v.addValidation("primaryEmailId", "email",
				"Please Enter The Vailide Email Id");
		v.addValidation("primaryEmailId", "req", "Please Enter The Email Id");

		v.addValidation("mobileNo", "req", "Please Enter Mobile-No");
		v.addValidation("mobileNo", "maxlen=12", "Please Enter max 12 Number");
		v.addValidation("mobileNo", "minlen=10",
				"Please Enter atleast 10 Number");
		v.addValidation("mobileNo", "space[\S]", "No require firstly space");
		v.addValidation("mobileNo", "num", "Please Enter Numeric digit");
		v.addValidation("userRole", "req", "Please Choise User Role");
		v.addValidation("userRole", "dontselect=1", "Please Choise User Role");
		v.addValidation("country", "dontselect=1", "Please Select Country");
	</script>
	<!-- End -->
</body>
</html>