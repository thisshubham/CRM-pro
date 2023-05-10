<%@page import="com.bst.ckt.vo.LeadVO"%>
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
							<li><a href="leadDashboard.action"><s:text
										name="navbar.lead"></s:text></a></li>
							<li class="active"><s:text name="navbar.lead.dashboard"></s:text></li>
							<li class="active"><s:text name="navbar.updatelead"></s:text></li>
						</ol>
						<div class="box">

							<header>
							<div class="pull-left">
								<a class="icons" href="leadDashboard.action"
									data-toggle="tooltip"
									data-original-title="Back To Leads DashBoard"> <i
									class="fa fa-th-large"></i>
								</a>

								<h5>
									<s:text name="update.Lead.header.information" />
								</h5>
							</div>
							<s:form name="updateLeadForm" action="updateLead" method="POST">
								<div class="pull-right">

									<div class="btn-group">
										<a class="btn btn-default btnheight" data-toggle="tooltip"
											data-original-title="Help"><i class="fa fa-question"></i>
											<s:text name="project.form.button.help"></s:text></a>
										<button type="submit" data-toggle="tooltip"
											data-original-title="Save" class="btn btn-primary btnheight">
											<i class="fa fa-check"> </i>
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
											href="populateLeadClone.action?command=<s:property value='leadId'/>"
											class="btn btn-warning btnheight" data-toggle="tooltip"
											data-original-title="Clone"><i class="fa fa-users"></i>&nbsp;<s:text
												name="project.form.button.clone"></s:text></a> <a
											data-toggle="tooltip" data-original-title="Previous"
											type="button" class="btn btn-default btnheight"
											href="populatePreviouslead"><i
											class="fa fa-chevron-left fontawesomeht"></i></a> <a
											data-toggle="tooltip" data-original-title="Next"
											href="populateNextlead.action"
											class="btn btn-default btnheight"><i
											class="fa fa-chevron-right fontawesomeht"></i></a> <a
											data-toggle="tooltip" data-original-title="Close"
											href="leadDashboard.action" class="btn btn-danger btnheight"><i
											class="fa fa-times fontawesomeht"></i></a>
									</div>

								</div></header>

							<div class="container-fluid"
								style="margin-top: 15px; margin-bottom: 15px;">
								<!-- Nav tabs -->
								<ul class="nav nav-tabs" role="tablist">
									<li role="presentation" class="active"><a
										href="editLead.action?command=<s:property value='leadId'/>"
										style="background-color: #F9F9F9; color: Gray;"><s:text
												name="update.Lead.tabs.lead.information" /></a></li>
									<li role="presentation"><a
										href="populatLeadContactInfo.action?command=<s:property value='leadId'/>"
										style="color: Gray;"><s:text
												name="update.Lead.tabs.contact.information" /></a></li>
									<li role="presentation"><a
										href="renderAddLeadSocialInfo.action" style="color: Gray;"><s:text
												name="update.Lead.tabs.social.information" /></a></li>
									<li role="presentation"><a
										href="renderaddLeadFollowUp.action?command=<s:property value='leadId'/>"
										style="color: Gray;"><s:text
												name="update.Lead.tabs.follow.up" /></a></li>
								</ul>

								<!-- Tab panes -->
								<s:iterator value="leadVO" var="obj">
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
															<s:text name="add.create.lead.information.bar" />
														</div>
													</div>
												</s:else>
											</p>

											<div class="row">
												<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
													<div class="row form-group">
														<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
															<s:text name="add.create.lead.company" />
															<div class="star">*</div>
														</div>
														<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">

															<s:textfield type="text" name="companyName"
																cssClass="form-control" tabindex="1" />
															<div id='updateLeadForm_companyName_errorloc'
																class="error_strings"></div>
														</div>
													</div>
												</div>


												<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
													<div class="row form-group">
														<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
															<s:text name="add.create.lead.contactperson" />

														</div>
														<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
															<div class="row">
																<div class="col-lg-3 col-md-3 col-sm-3 col-xs-5">
																	<s:select class="form-control" name="salutation"
																		tabindex="2" list="salutationList"
																		cssClass="form-control" />
																	<div id='updateLeadForm_salutation_errorloc'
																		class="error_strings"></div>
																</div>
																<div class="col-lg-9 col-md-9 col-sm-9 col-xs-7">
																	<s:textfield type="text" name="contactPerson"
																		class="form-control" cssClass="form-control"
																		tabindex="3" />
																	<div id='updateLeadForm_contactPerson_errorloc'
																		class="error_strings"></div>
																</div>
															</div>
														</div>
													</div>

												</div>
											</div>


											<div class="row">
												<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
													<div class="row form-group">
														<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
															<s:text name="add.create.lead.leadtitle" />

														</div>
														<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
															<div class="input-group">
																<s:select cssClass="form-control chzn-select"
																	tabindex="4" headerKey="1"
																	headerValue="Select Lead Title" name="leadTitle"
																	id="leadTitle" list="leadTitleList" />
																<span class="input-group-btn">
																	<button type="button" tabindex="5"
																		onclick="PopupCenter('renderAddLeadTitle','RenderAddLeadTitle',800,600);"
																		class="btn btn-metis-3 btnheight_chzselect btn-line">
																		<i class="fa fa-plus-square "></i>
																	</button>
																</span>
															</div>
															<div id='addCreatedLeadForm_leadTitle_errorloc'
																class="error_strings"></div>
														</div>
													</div>
												</div>


												<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
													<div class="row form-group">
														<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
															<s:text name="add.create.lead.company.type" />

														</div>
														<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
															<s:select name="companyType" list="companyTypeList"
																headerKey="-1" cssClass="form-control chzn-select"
																tabindex="6">
															</s:select>
															<div id='updateLeadForm_companyType_errorloc'
																class="error_strings"></div>
														</div>
													</div>
												</div>

											</div>



											<div class="row">
												<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
													<div class="row form-group">
														<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">

															<s:text name="add.create.lead.company.category" />

														</div>
														<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
															<s:select list="companyCategoryList"
																name="companyCategory"
																cssClass="form-control chzn-select" tabindex="7"
																headerKey="-1">
															</s:select>
															<div id='updateLeadForm_companyCategory_errorloc'
																class="error_strings"></div>
														</div>
													</div>
												</div>
												<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
													<div class="row form-group">
														<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">

															<s:text name="add.create.lead.company.sector" />

														</div>
														<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">

															<s:select list="companySectorList" name="companySector"
																headerKey="-1" tabindex="8"
																cssClass="form-control chzn-select">
															</s:select>
															<div id='updateLeadForm_companySector_errorloc'
																class="error_strings"></div>
														</div>
													</div>
												</div>
											</div>



											<div class="row">
												<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
													<div class="row form-group">
														<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">

															<s:text name="add.create.lead.lead.source" />

														</div>
														<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">

															<s:select list="leadSourceList" name="leadSource"
																headerKey="-1" headerValue="Select Lead Source"
																tabindex="9" cssClass="form-control chzn-select" />
															<div id='updateLeadForm_leadSource_errorloc'
																class="error_strings"></div>
														</div>
													</div>
												</div>
												<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
													<div class="row form-group">
														<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
															<s:text name="add.create.lead.lead.sourceName" />


														</div>
														<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">

															<s:textfield type="text" name="leadSourceName"
																class="form-control" tabindex="10"
																cssClass="form-control" />
														</div>
													</div>
												</div>
											</div>


											<div class="row">
												<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
													<div class="row form-group">

														<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
															<s:text name="add.create.lead.no.of.associate" />
														</div>
														<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
															<s:textfield name="noOfAssociate" cssClass="form-control"
																tabindex="11" />
															<div id='updateLeadForm_noOfAssociate_errorloc'
																class="error_strings"></div>
														</div>
													</div>
												</div>

												<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
													<div class="row form-group">
														<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
															<s:text name="add.create.lead.annual.revneue" />
															&nbsp; (&nbsp;<span class="fa fa-rupee "></span>&nbsp;)
														</div>
														<div class="col-lg-8 col-md-7 col-sm-12 col-xs-12">

															<div class="input-group">
																<s:textfield type="text" name="annualRevenue"
																	cssClass="form-control" tabindex="12" />

																<span class="input-group-btn"> <!-- <button class="btn btn-metis-5 btn-line" type="button"
																		style="height: 34px"
																		onClick="PopupCenter('renderCalculator','RenderCalculator',260,350);">
																		<i class="fa fa-calculator"></i>
																	</button> --> <a type="button"
																	class="btn btn-metis-5 btn-line" type="button"
																	tabindex="13" data-toggle="modal" style="height: 34px"
																	data-target="#calculater"> <i
																		class="fa fa-calculator "></i>
																</a>
																</span>


															</div>
														</div>

													</div>
												</div>
											</div>



											<div class="row">
												<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
													<div class="row form-group">
														<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
															<s:text name="add.create.lead.lead.date" />

														</div>
														<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">

															<s:textfield type="text" name="leadDate"
																class="form-control" id="dp1" cssClass="form-control"
																tabindex="14" readonly="true" />
															<div id='updateLeadForm_leadDate_errorloc'
																class="error_strings"></div>

														</div>
													</div>
												</div>
												<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
													<div class="row form-group">
														<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">

															<s:text name="add.create.lead.expected.closing.date" />

														</div>
														<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
															<s:textfield type="text" name="expectedClosingDate"
																cssClass="form-control" id="dp2" tabindex="15"
																readonly="true" />
															<div id='updateLeadForm_expectedClosingDate_errorloc'
																class="error_strings"></div>
														</div>
													</div>
												</div>
											</div>

											<div class="row">
												<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
													<div class="row form-group">
														<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
															<s:text name="update.Lead.lead.owner" />
														</div>
														<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
															<s:textfield type="text" name="leadOwner"
																cssClass="form-control" disabled="true" tabindex="16" />

														</div>
													</div>
												</div>

												<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
													<div class="row form-group">
														<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
															<s:text name="add.lead.ratings" />
														</div>
														<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
															<s:select cssClass="form-control chzn-select"
																name="ratings" list="ratingList" headerKey="-1"
																headerValue="Select Rating" tabindex="17" />
														</div>
													</div>
												</div>
											</div>
											<div class="row">
												<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
													<div class="row form-group">
														<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
															<s:text name="add.lead.email.optout" />
														</div>
														<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">

															<s:checkbox name="emailOptOut" tabindex="18"></s:checkbox>

														</div>
													</div>
												</div>


												<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
													<div class="row form-group">
														<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
															<s:text name="view.lead.followup.lead.status" />
														</div>
														<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
															<s:select cssClass="form-control chzn-select"
																name="leadStatus" list="leadStatusList" headerKey="-1"
																tabindex="19" />
														</div>
													</div>

												</div>
											</div>
											<div class="row">
												<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
													<div class="row form-group">
														<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
															<s:text name="update.group.createdby" />
														</div>
														<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
															<s:textfield name="createdByName" cssClass="form-control"
																disabled="true" tabindex="19" />

														</div>
													</div>
												</div>
												<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
													<div class="row form-group">
														<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
															<s:text name="update.lead.info.creation.date" />
														</div>
														<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
															<s:textfield type="text" name="createdDate"
																cssClass="form-control" disabled="true" tabindex="20" />
														</div>
													</div>

												</div>
											</div>

											<div class="row" style="margin-top: 20px;">
												<div
													class="col-lg-12 col-md-12 col-sm-12 col-xs-12 innertitle">
													<h5 style="margin-left: 10px;">
														<s:text name="add.create.lead.requirment" />
													</h5>
													<hr style="margin-top: -5px">
												</div>

											</div>


											<div class="form-group">
												<div class="row" style="margin: 1% 2%;" id="data_grid">
													<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
														<div id='addCreatedLeadForm_requirment_errorloc'
															class="error_strings"></div>
														<s:textarea id="wysihtml5" name="requirment"
															class="form-control" rows="10" tabindex="21">
														</s:textarea>
														<div id='addCreatedLeadForm_requirment_errorloc'
															class="error_strings"></div>
													</div>
												</div>
											</div>
											<hr>
											<div class="row" style="margin-top: 20px;">
												<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"
													align="center">
													<a href="leadDashboard.action" data-toggle="tooltip"
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
											</div>
											<br>
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
	</div>
	<div class="modal fade" id="calculater" role="dialog">
		<div class="modal-dialog modal-sm">
			<div class="modal-content">
				<div class="modal-header"
					style="color: gray; background-color: #394B5E;">
					<button type="button" class="close" data-dismiss="modal"
						style="color: red; margin-top: -30px;">
						<h1>&times;</h1>
					</button>
					<h4 class="modal-title" style="color: gray;">Calculater</h4>
				</div>
				<div class="modal-body" style="color: gray;">
					<div class="row ">
						<div class="col-lg-12 col-md-10 col-xs-12 col-sm-10">

							<div class="col-lg-12 col-md-12 col-xs-12 col-sm-12"
								style="margin-bottom: 10px;">
								<!-- <input type="text" id="calculatortextid"
									style="height: 40px; width: 210px"
									autocomplete="off" /> -->
								<s:textfield id="calculatortextid" cssClass="form-control" />
							</div>

							<div class="col-lg-12 col-md-12 col-xs-12 col-sm-12">
								<button type="button" class="btn btn-defult"
									style="width: 50px; height: 50px; margin-left: 14px" id="idc"
									onclick="valueIdc()">
									<b>c</b>
								</button>
								<button type="button" class="btn btn-defult"
									style="width: 50px; height: 47px; padding-bottom: 0px;"
									id="idx2" onclick="valueIdxsquare()">
									<b><i>x<sup>2</sup></i></b>
								</button>
								<button type="button" class="btn btn-defult"
									style="width: 50px; height: 50px;" id="idroot"
									onclick="valueIdroot()">
									<b>√</b>
								</button>
								<button type="button" class="btn btn-defult"
									style="width: 50px; height: 50px;" id="idmod"
									onclick="valueIdmod()">
									<b>%</b>
								</button>
							</div>

							<br>
							<div class="col-lg-12 col-md-12 col-xs-12 col-sm-12">
								<button type="button" class="btn btn-defult"
									style="width: 50px; height: 50px; margin-left: 14px" id="id7"
									onclick="valueId7()">
									<b>7</b>
								</button>
								<button type="button" class="btn btn-defult"
									style="width: 50px; height: 50px;" id="id8"
									onclick="valueId8()">
									<b>8</b>
								</button>
								<button type="button" class="btn btn-defult"
									style="width: 50px; height: 50px;" id="id9"
									onclick="valueId9()">
									<b>9</b>
								</button>
								<button type="button" class="btn btn-defult"
									style="width: 50px; height: 50px;" id="iddiv"
									onclick="valueIddivision()">
									<b>/</b>
								</button>
							</div>

							<br>
							<div class="col-lg-12 col-md-12 col-xs-12 col-sm-12">
								<button type="button" class="btn btn-defult"
									style="width: 50px; height: 50px; margin-left: 14px" id="id4"
									onclick="valueId4()">
									<b>4</b>
								</button>
								<button type="button" class="btn btn-defult"
									style="width: 50px; height: 50px;" id="id5"
									onclick="valueId5()">
									<b>5</b>
								</button>
								<button type="button" class="btn btn-defult"
									style="width: 50px; height: 50px;" id="id6"
									onclick="valueId6()">
									<b>6</b>
								</button>
								<button type="button" class="btn btn-defult"
									style="width: 50px; height: 50px;" id="idx"
									onclick="valueIdmultiply()">
									<b>x</b>
								</button>
							</div>

							<div class="col-lg-12 col-md-12 col-xs-12 col-sm-12">
								<button type="button" class="btn btn-defult"
									style="width: 50px; height: 50px; margin-left: 14px" id="id1"
									onclick="valueId1()">
									<b>1</b>
								</button>
								<button type="button" class="btn btn-defult"
									style="width: 50px; height: 50px;" id="id2"
									onclick="valueId2()">
									<b>2</b>
								</button>
								<button type="button" class="btn btn-defult"
									style="width: 50px; height: 50px;" id="id3"
									onclick="valueId3()">
									<b>3</b>
								</button>
								<button type="button" class="btn btn-defult"
									style="width: 50px; height: 50px;" id="idminus"
									onclick="valueIdminus()">
									<b>-</b>
								</button>
							</div>
							<br> <br>
							<div class="col-lg-12 col-md-12 col-xs-12 col-sm-12">
								<button type="button" class="btn btn-defult"
									style="width: 50px; height: 50px; margin-left: 14px" id="id0"
									onclick="valueId0()">
									<b>0</b>
								</button>
								<button type="button" class="btn btn-defult"
									style="width: 50px; height: 50px;" id="iddot"
									onclick="valueIddot()">
									<b>.</b>
								</button>
								<button type="button" class="btn btn-defult"
									style="width: 50px; height: 50px;" id="idequal"
									onclick="valueIdequal()">
									<b>=</b>
								</button>
								<button type="button" class="btn btn-defult"
									style="width: 50px; height: 50px;" id="idplus"
									onclick="valueIdplus()">
									<b>+</b>
								</button>
							</div>

						</div>
					</div>
				</div>

			</div>
		</div>
	</div>
	<script src="pages/inner/assets/js/calculater.js"></script>
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
		var frmvalidator = new Validator("updateLeadForm");
		frmvalidator.EnableOnPageErrorDisplay();
		frmvalidator.EnableMsgsTogether();

		//Validation for Company Name.
		frmvalidator.addValidation("companyName", "req", "Enter Company Name");
		frmvalidator.addValidation("companyName", "minlen=3",
				"Company Name Should Be 3 Characters");
		frmvalidator.addValidation("companyName", "maxlen=100",
				"Company Name Should Be 100 Characters");

		//Validation for Contact Person.
		frmvalidator.addValidation("contactPerson", "maxlen=100",
				"Contact Person Name Should Be 100 Characters");
		frmvalidator.addValidation("contactPerson", "minlen=3",
				"Contact Person Name Should Be 3 Characters");

		//Validation for Lead Source Name. 
		frmvalidator.addValidation("leadSourceName", "maxlen=100",
				"Lead Source Name Should Be 100 Characters");
		frmvalidator.addValidation("leadSourceName", "minlen=3",
				"Lead Source Should Be 3 Characters");

		//Validation for Number of associates.
		frmvalidator.addValidation("noOfAssociate", "numeric",
				"Number Of Associate Must Be Digits");
		frmvalidator.addValidation("noOfAssociate", "maxlen=6",
				"No. Of Associates Should Be 6 Digits");
		//requirment 
		frmvalidator.addValidation("requirment", "maxlen=4000",
				"Requirment Should Be 4000 Charcters");
	</script>
</body>
</html>