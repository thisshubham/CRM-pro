<%@page import="com.bst.ckt.vo.SupportFaqVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="/struts-jquery-tags" prefix="sj"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
.error_strings {
	color: red;
}
</style>
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
							<li><a href="SupportFaqs.action"><s:text name="Faq's"></s:text></a></li>
							<li><a href="SupportFaqs.action"><s:text
										name="support_Faqs.pannel.heading"></s:text></a></li>
							<li><a
								href="supportEditFaq.action?command=<s:property value='faqId' />"
								data-placement="bottom"><s:text
										name="support_editFaq.pannel.heading"></s:text> </a></li>
						</ol>
						<div class="box">
							<header> <s:form action="supportUpdateFaq"
								name="EditFaqsForm" id="EditFaqsForm">

								<div class="pull-left">
									<a class="icons" href="SupportFaqs.action"
										data-toggle="tooltip"
										data-original-title="Back To Faq Dashboard"> <i
										class="fa fa-th-large"></i>
									</a>
									<h5>
										<s:text name="support_editFaq.pannel.heading" />
									</h5>
								</div>

								<div class="pull-right">
									<div class="btn-group">
										<a class="btn btn-default btnheight" data-toggle="tooltip"
											data-original-title="Help"><i class="fa fa-question"></i>
											<s:text name="project.form.button.help"></s:text></a>
										<button type="submit" data-toggle="tooltip"
											data-original-title="Save" class="btn btn-primary btnheight">
											<i class="fa fa-check"></i>
											<s:text name="project.form.button.save"></s:text>
										</button>
										<a class="btn btn-info btnheight" data-toggle="tooltip"
											data-original-title="Convert"><i class="fa fa-random"></i>
											<s:text name="project.form.button.convert"></s:text></a>
										<button type="button" data-toggle="tooltip"
											data-original-title="Refresh"
											class="btn btn-success btnheight"
											onclick="window.location.reload();">
											<i class="fa fa-refresh "></i>
										</button>
										<a
											href="populateFaqClone.action?command=<s:property value='faqId'/>"
											class="btn btn-warning btnheight" data-toggle="tooltip"
											data-original-title="Clone"><i class="fa fa-users"></i>&nbsp;<s:text
												name="project.form.button.clone"></s:text></a> <a
											data-toggle="tooltip" data-original-title="Previous"
											type="button" class="btn btn-default btnheight"
											href="populatePreviousFaq.action?command=<s:property value='faqId' />"><i
											class="fa fa-chevron-left fontawesomeht"></i></a> <a
											data-toggle="tooltip" data-original-title="Next"
											href="populateNextFaq.action?command=<s:property value='faqId' />"
											class="btn btn-default btnheight"><i
											class="fa fa-chevron-right fontawesomeht"></i> </a> <a
											data-toggle="tooltip" data-original-title="Close"
											href="SupportFaqs.action" class="btn btn-danger btnheight"><i
											class="fa fa-times fontawesomeht"></i></a>
									</div>
								</div></header>

							<div class="container-fluid"
								style="margin-top: 15px; margin-bottom: 15px;">
								<s:iterator value="supportFaqVO">
									<div id="content" style="background-color: #F9F9F9;">
										<div class="box" style="padding: 0px 25px 25px; margin: 0px">
											<p>
												<s:if test="hasActionErrors()">
													<div class="alert alert-danger" role="alert"
														style="margin-top: 25px; padding-bottom: 7px;">
														<div class="infoIcon">
															<!-- <i class="fa fa-times-circle ">&nbsp; 
															</i> -->
															<s:actionerror />
														</div>
													</div>
												</s:if>
												<s:elseif test="hasActionMessages()">
													<div class="alert alert-success" role="alert"
														style="margin-top: 25px; padding-bottom: 7px;">
														<div class="infoIcon">
															<!-- <i class="fa fa-check-circle "></i>&nbsp; -->
															<s:actionmessage />
														</div>
													</div>
												</s:elseif>
												<s:else>
													<div class="alert alert-info" role="alert"
														style="margin-top: 25px;">
														<div class="infoIcon">
															<i class="fa fa-info-circle "></i>&nbsp;
															<s:text name="support_editFaq.infobar" />
														</div>
													</div>
												</s:else>
											</p>
											<div class="row"
												style="margin-left: 15px; margin-right: 15px;">
												<div class="row">
													<div class="col-xs-12 col-md-2 col-sm-2">
														<s:text name="support_addFaq.question"></s:text>
														<font color="red">*</font>
													</div>
													<div class="col-xs-12 col-md-4 col-sm-4">
														<div id='EditFaqsForm_question_errorloc'
															class="error_strings" style="color: red;"></div>
														<s:textarea name="question" id="question"
															cssClass="form-control"></s:textarea>
													</div>
													<div class="col-xs-12 col-md-2 col-sm-2">
														<s:text name="support_addFaq.answer"></s:text>
														<font color="red">*</font>
													</div>
													<div class="col-xs-12 col-md-4 col-sm-4">
														<div id='EditFaqsForm_answer_errorloc'
															class="error_strings" style="color: red;"></div>
														<s:textarea name="answer" id="answer"
															cssClass="form-control"></s:textarea>
													</div>
												</div>
												<div class="row">
													<div class="col-xs-12 col-md-2 col-sm-2"
														style="margin-top: 10px">
														<s:text name="support_addFaq.product.name"></s:text>
													</div>
													<div class="col-xs-12 col-md-4 col-sm-4"
														style="margin-top: 10px">
														<div id='EditFaqsForm_productName_errorloc'
															class="error_strings" style="color: red;"></div>
														<div class="input-group">
															<s:select cssClass="form-control chzn-select"
																tabindex="7" headerKey="1" name="productName"
																id="productName" list="faqProductNameList"></s:select>
															<span class="input-group-btn">
																<button type="button" tabindex="5"
																	onclick="PopupCenter('renderAddFaqProductName','RenderAddFaqProductName',800,600);"
																	class="btn btn-metis-3 btnheight_chzselect btn-line">
																	<i class="fa fa-plus-square "></i>
																</button>
															</span>
														</div>
													</div>
													<div class="col-xs-12 col-md-2 col-sm-2"
														style="margin-top: 10px">
														<s:text name="support_addFaq.owner"></s:text>
													</div>
													<div class="col-xs-12 col-md-4 col-sm-4"
														style="margin-top: 10px">
														<div id='EditFaqsForm_owner_errorloc'
															class="error_strings" style="color: red;"></div>
														<s:select name="owner" headerKey="1" tabindex="7"
															list="faqOwnerList" cssClass="form-control chzn-select"></s:select>
													</div>
												</div>
												<div class="row">
													<div class="col-xs-12 col-md-2 col-sm-2"
														style="margin-top: 10px">
														<s:text name="support_addFaq.status"></s:text>
														<font color="red">*</font>
													</div>
													<div class="col-xs-12 col-md-4 col-sm-4"
														style="margin-top: 10px">
														<div id='EditFaqsForm_status_errorloc'
															class="error_strings" style="color: red;"></div>
														<s:select name="status" tabindex="2" list="faqStatusList"
															headerKey="-1" cssClass="form-control chzn-select" />
													</div>
													<div class="col-xs-12 col-md-2 col-sm-2"
														style="margin-top: 10px">
														<s:text name="support_addFaq.category"></s:text>
														<font color="red">*</font>
													</div>
													<div class="col-xs-12 col-md-4 col-sm-4"
														style="margin-top: 10px">
														<div id='EditFaqsForm_category_errorloc'
															class="error_strings" style="color: red;"></div>
														<s:select name="category" tabindex="7"
															list="faqCategoryList" headerKey="-1"
															headerValue="Faq Category"
															cssClass="form-control chzn-select" />
													</div>
												</div>
												<hr>
												<div class="row" style="margin-top: 20px;">
													<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"
														align="center">
														<a href="SupportFaqs.action" data-toggle="tooltip"
															data-original-title="Cancel"
															class="btn btn-default btnheight"><i
															class="fa fa-caret-square-o-left fontawesomeht"></i> <s:text
																name="project.form.button.cancel"></s:text></a>
														<button type="button" data-toggle="tooltip"
															data-original-title="Reset"
															class="btn btn-success btnheight"
															onclick="window.location.reload();">
															<i class="fa fa-refresh "></i>
															<s:text name="project.form.button.reset"></s:text>
														</button>
														<button type="submit" data-toggle="tooltip"
															data-original-title="Save"
															class="btn btn-primary btnheight">
															<i class="fa fa-check"></i>
															<s:text name="project.form.button.save"></s:text>
														</button>
													</div>
													<br>
												</div>
											</div>
										</div>
									</div>
								</s:iterator>
							</div>
							</s:form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Metis core scripts -->
	<script src="assets/js/core.min.js"></script>

	<!-- Metis demo scripts -->
	<script src="assets/js/app.min.js"></script>
	<script>
		$(function() {
			Metis.formGeneral();
			Metis.formWysiwyg();
		});
	</script>
	<script src="assets/js/style-switcher.min.js"></script>
	<script type="text/javascript">
		var formvalidation = new Validator("EditFaqsForm");
		formvalidation.EnableOnPageErrorDisplay();
		formvalidation.EnableMsgsTogether();

		formvalidation.addValidation("question", "req",
				"Please Enter Question.");
		formvalidation
				.addValidation(
						"question",
						"minlen=3",
						"Please enter valid question with at least 3 characters and at max 100 characters.");
		formvalidation
				.addValidation("question", "maxlen=300",
						"Please enter valid Name with at least 3 characters and at max 300 characters.");

		formvalidation.addValidation("answer", "req", "Please Enter Answer.");
		formvalidation
				.addValidation(
						"answer",
						"minlen=3",
						"Please enter valid question with at least 3 characters and at max 4000 characters.");
		formvalidation
				.addValidation(
						"answer",
						"maxlen=4000",
						"Please enter valid Name with at least 3 characters and at max 4000 characters.");
		formvalidation.addValidation("status", "dontselect=-1",
				"Select Your Status ");
		formvalidation.addValidation("category", "dontselect=-1",
				"Select Your Category");
	</script>
</body>
</html>