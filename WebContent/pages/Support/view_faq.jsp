<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	<div class="outer">
		<div class="inner bg-light lter">
			<div class="box">
				<div class="container-fluid">
					<ol class="breadcrumb" style="margin-top: 10px;">
						<li><a href="omiInnerDashboard.action"><i
								class="fa fa-home"></i></a></li>
						<li><a href="SupportFaqs.action"><s:text
									name="support_Faqs.navbar"></s:text></a></li>
						<li><a href="SupportFaqs.action"><s:text
									name="support_Faqs.pannel.heading"></s:text></a></li>
						<li><a
							href="supportViewFaq?command=<s:property value='faqId'/>"
							data-placement="bottom"><s:text
									name="support_viewFaqs.pannel.heading"></s:text></a></li>
					</ol>
					<header> <a class="icons" href="SupportFaqs.action"
						data-toggle="tooltip" data-original-title="Back To Faq Dashboard"
						style="color: black;"> <i class="fa fa-th-large"></i>
					</a>
					<h5>
						<s:text name="support_viewFaqs.heading" />
					</h5>
					<div class="pull-right">
						<div class="btn-group">
							<a class="btn btn-default btnheight" data-toggle="tooltip"
								data-original-title="Help"><i class="fa fa-question"></i> <s:text
									name="project.form.button.help"></s:text></a> <a
								class="btn btn-primary btnheight" data-toggle="tooltip"
								data-original-title="Print"><i class="fa fa-print"></i> <s:text
									name="project.form.button.print"></s:text></a> <a
								data-toggle="tooltip" data-original-title="PDF Report"
								href="supportViewFaqPDF.action?command=<s:property value='faqId' />"
								class="btn btn-success btnheight"><i
								class="fa fa-file-pdf-o "></i> <s:text
									name="project.form.button.pdf"></s:text></a> <a
								data-toggle="tooltip" data-original-title="Previous Faq"
								href="viewPriviousFaqInfo.action?command=<s:property value='faqId' />"
								type="button" class="btn btn-default btnheight"><i
								class="fa fa-chevron-left fontawesomeht"></i></a> <a
								data-toggle="tooltip" data-original-title="Next Faq"
								href="viewNextFaqInfo.action?command=<s:property value='faqId' />"
								class="btn btn-default btnheight"><i
								class="fa fa-chevron-right fontawesomeht"></i></a> <a
								data-toggle="tooltip" data-original-title="Close"
								href="SupportFaqs.action" class="btn btn-danger btnheight"><i
								class="fa fa-times fontawesomeht"></i></a>
						</div>
					</div>
					</header>
					<div id="div-2" class="body">
						<div>
							<p>
								<s:if test="hasActionErrors()">
									<div class="alert alert-danger" role="alert"
										style="padding-bottom: 7px;">
										<div class="infoIcon">
											<!-- <i class="fa fa-times-circle "></i> -->
											<s:actionerror />
										</div>
									</div>
								</s:if>
								<s:elseif test="hasActionMessages()">
									<div class="alert alert-success" role="alert"
										style="padding-bottom: 7px;">
										<div class="infoIcon">
											<!-- <i class="fa fa-check-circle "> </i> -->
											<s:actionmessage />
										</div>
									</div>
								</s:elseif>
								<s:else>
									<div class="alert alert-info" role="alert">
										<div class="infoIcon">
											<i class="fa fa-info-circle "> <s:text
													name="add.create.lead.information.bar" /></i>
										</div>
									</div>
								</s:else>
							</p>
						</div>
						<div style="padding-left: 15px; padding-right: 15px;">
							<s:form class="form-group">
								<s:iterator value="supportFaqVO">
									<div class="row">
										<div
											class="col-lg-12 col-md-12 col-sm-12 col-xs-12 viewinnertitle">
											<h5>
												<s:text name="support_viewFaqs.heading" />
											</h5>
										</div>
									</div>
									<hr>
									<div class="row">
										<div class="col-md-12 col-sm-12 col-xs-12"
											id="view_lable_value2">
											<div class="col-md-2 col-sm-12 col-xs-12">
												<label for="text1" class="control-label" id="viewlable">
													<s:text name="support_Faqs.support.id"></s:text>
												</label>
											</div>
											<div class="col-md-10 col-sm-12 col-xs-12 control-label">
												<s:property value="faqId" />
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12 col-sm-12 col-xs-12"
											id="view_lable_value">
											<div class="col-md-2 col-sm-12 col-xs-12">
												<label for="text1" class="control-label" id="viewlable">
													<s:text name="support_addFaq.question"></s:text>
												</label>
											</div>
											<div class="col-md-10 col-sm-12 col-xs-12 control-label">
												<s:property value="question" />
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12 col-sm-12 col-xs-12"
											id="view_lable_value2">
											<div class="col-md-2 col-sm-12 col-xs-12">
												<label for="text1" class="control-label" id="viewlable">
													<s:text name="support_addFaq.answer"></s:text>
												</label>
											</div>
											<div class="col-md-10 col-sm-12 col-xs-12 control-label">
												<s:property value="answer" />
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12 col-sm-12 col-xs-12"
											id="view_lable_value">
											<div class="col-md-2 col-sm-12 col-xs-12">
												<label for="text1" class="control-label" id="viewlable">
													<s:text name="support_addFaq.product.name"></s:text>
												</label>
											</div>
											<div class="col-md-10 col-sm-12 col-xs-12 control-label">
												<s:property value="productName" />
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12 col-sm-12 col-xs-12"
											id="view_lable_value2">
											<div class="col-md-2 col-sm-12 col-xs-12">
												<label for="text1" class="control-label" id="viewlable">
													<s:text name="support_addFaq.owner"></s:text>
												</label>
											</div>
											<div class="col-md-10 col-sm-12 col-xs-12 control-label">
												<s:property value="owner" />
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12 col-sm-12 col-xs-12"
											id="view_lable_value">
											<div class="col-md-2 col-sm-12 col-xs-12">
												<label for="text1" class="control-label" id="viewlable">
													<s:text name="support_addFaq.category"></s:text>
												</label>
											</div>
											<div class="col-md-10 col-sm-12 col-xs-12 control-label">
												<s:property value="category" />
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12 col-sm-12 col-xs-12"
											id="view_lable_value2">
											<div class="col-md-2 col-sm-12 col-xs-12">
												<label for="text1" class="control-label" id="viewlable">
													<s:text name="support_addFaq.status"></s:text>
												</label>
											</div>
											<div class="col-md-10 col-sm-12 col-xs-12 control-label">
												<s:property value="status" />
											</div>
										</div>
										<hr style="margin-top: 20px">
										<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"
											align="center">
											<a href="SupportFaqs.action" data-toggle="tooltip"
												data-original-title="Cancel"
												class="btn btn-default btnheight"><i
												class="fa fa-caret-square-o-left fontawesomeht"></i> <s:text
													name="project.form.button.cancel"></s:text></a>
										</div>
									</div>
								</s:iterator>
							</s:form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>