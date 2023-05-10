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
							<li class="active"><s:text
									name="add.new.product.product.dashboard"></s:text></li>
							<li class="active"><s:text
									name="add.new.product.new.product"></s:text></li>
						</ol>
						<s:form name="updateCreatedProductForm" action="updateProductDetail"
							class="form-horizontal" id="block-validate">
							<div class="box dark">
								<header>
								<div class="pull-left">
									<a class="icons" href="productDashboard.action"
										data-toggle="tooltip"
										data-original-title="Back To Product DashBoard"
										style="color: black;"> <i class="fa fa-th-large"></i>
									</a>
									<h5>
										<s:text name="add.new.product.new.product" />
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
										<a href="addCreatedProduct.action" data-toggle="tooltip"
											data-original-title="Refresh"
											class="btn btn-success btnheight"><i
											class="fa fa-refresh "></i></a> <a href="leadDashboard.action"
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

											<div class="alert alert-info" role="alert"
												style="margin-top: 25px;">
												<div class="infoIcon">
													<i class="fa fa-info-circle "></i>
													<s:text name="add.new.product.information.bar" />
												</div>
											</div>
										</s:else>
									</p>



									<div class="row" style="margin-top: 20px;">
										<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
											<h5 class="innertitle">
												<s:text name="add.new.product.product.information" />
											</h5>
											<hr style="margin-top: -5px">
										</div>
									</div>


									<div class="row">
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="add.new.product.product.name" />
													<div class="star">*</div>
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:textfield type="text" name="productName"
														cssClass="form-control" tabindex="1" />
													<div id='updateCreatedProductForm_productName_errorloc'
														class="error_strings"></diV>
												</div>
											</div>
										</div>



										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="add.new.product.product.code" />
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<div class="row">

														<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
															<s:textfield type="text" name="productCode"
																cssClass="form-control" tabindex="3" />
															<div id='updateCreatedProductForm_productCode_errorloc'
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
													<s:text name="add.new.product.product.category" />
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:select cssClass="form-control chzn-select"
														name="productCategory" list="{1,2,3}" headerKey="-1"
														headerValue="Select Product Category" tabindex="7" />
													<div id='updateCreatedProductForm_productCategory_errorloc'
														class="error_strings"></div>
												</div>
											</div>
										</div>

										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="add.new.product.product.active" />
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:checkbox name="productActive" tabindex="18"></s:checkbox>
												</div>

											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="add.new.product.vender.name" />
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:select cssClass="form-control chzn-select"
														name="productVender" list="{1,2,3}" headerKey="-1"
														headerValue="Select  Vender Name" tabindex="7" />
													<div id='updateCreatedProductForm_productVender_errorloc'
														class="error_strings"></div>
												</div>
											</div>
										</div>
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="add.new.product.manufacturer" />
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<div class="input-group">
														<s:select cssClass="form-control chzn-select" tabindex="4"
															headerKey="1" name="manufacturer" id="leadTitle"
															list="{1,2,3}" headerValue="Select Manufacturer" />
														<span class="input-group-btn">
															<button type="button" tabindex="5"
																onclick="PopupCenter('renderAddLeadTitle','RenderAddLeadTitle',800,600);"
																class="btn btn-metis-3 btnheight_chzselect btn-line">
																<i class="fa fa-plus-square "></i>
															</button>
														</span>
													</div>
													<div id='updateCreatedProductForm_manufacturer_errorloc'
														class="error_strings"></div>
												</div>
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="add.new.product.sales.start.date" />

												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:textfield type="text" name="salesStartDate"
														class="form-control" id="dp1" cssClass="form-control"
														tabindex="14" readonly="true" />
													<div id='updateCreatedProductForm_salesStartDate_errorloc'
														class="error_strings"></div>
												</div>

											</div>
										</div>
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="add.new.product.sales.end.date" />
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:textfield type="text" name="salesEndDate"
														class="form-control" id="dp3" cssClass="form-control"
														tabindex="14" readonly="true" />
													<div id='updateCreatedProductForm_salesEndDate_errorloc'
														class="error_strings"></div>
												</div>
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="add.new.product.support.start.date" />
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:textfield type="text" name="supportStartDate"
														cssClass="form-control" id="dp4" tabindex="15"
														readonly="true" />
													<div
														id='updateCreatedProductForm_expectedClosingDate_errorloc'
														class="error_strings"></div>
												</div>
											</div>
										</div>
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="add.new.product.support.expiry.date" />
													<%-- &nbsp; (&nbsp;<span class="fa fa-rupee "></span>&nbsp;) --%>
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:textfield type="text" name="supportExpiryDate"
														cssClass="form-control" id="dp2" tabindex="15"
														readonly="true" />
													<div id='updateCreatedProductForm_supportExpiryDate_errorloc'
														class="error_strings"></div>
												</div>
											</div>
										</div>
									</div>



									<div class="row">
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="add.new.product.serial.no" />
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:textfield type="text" name="serialNo"
														cssClass="form-control" tabindex="14" />
													<div id='updateCreatedProductForm_serialNo_errorloc'
														class="error_strings"></div>
												</div>
											</div>
										</div>
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="add.new.product.mfr.part.no" />
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:textfield type="text" name="mfrPartlNo"
														cssClass="form-control" tabindex="15" />
													<div id='updateCreatedProductForm_mfrPartlNo_errorloc'
														class="error_strings"></div>
												</div>
											</div>
										</div>
									</div>


									<div class="row">
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="add.new.product.vendor.part.no" />
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:textfield type="text" name="vendorPartlNo"
														cssClass="form-control" tabindex="15" />
													<div id='updateCreatedProductForm_vendorPartlNo_errorloc'
														class="error_strings"></div>
												</div>
											</div>
										</div>
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="add.new.product.product.sheet" />
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:textfield type="text" name="productSheet"
														cssClass="form-control" tabindex="15" />
													<div id='updateCreatedProductForm_productSheet_errorloc'
														class="error_strings"></div>
												</div>
											</div>
										</div>
									</div>

									<div class="row">
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="add.new.product.website" />
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:textfield type="text" name="website"
														cssClass="form-control" tabindex="15" />
													<div
														id='updateCreatedProductForm_expectedClosingDate_errorloc'
														class="error_strings"></div>
												</div>


											</div>
										</div>
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="add.new.product.gl.account" />
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:textfield type="text" name="glAccount"
														cssClass="form-control" tabindex="15" />
													<div id='updateCreatedProductForm_glAccount_errorloc'
														class="error_strings"></div>
												</div>
											</div>
										</div>
									</div>



									<div class="row" style="margin-top: 20px;">
										<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
											<h5 class="innertitle">
												<s:text name="add.new.product.pricing.information" />
											</h5>
											<hr style="margin-top: -5px">
										</div>

									</div>


									<div class="row">

										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="add.new.product.unit.price" />
													&nbsp; (&nbsp;<span class="fa fa-rupee "></span>&nbsp;)
													<div class="star">*</div>
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<div class="input-group">
														<s:textfield type="text" name="unitPrice"
															cssClass="form-control" tabindex="12" />


														<span class="input-group-btn"> <a type="button"
															class="btn btn-metis-5 btn-line" type="button"
															tabindex="13" data-toggle="modal" style="height: 34px"
															data-target="#calculater"> <i
																class="fa fa-calculator "></i>
														</a>
														</span>

													</div>
													<div id='updateCreatedProductForm_unitPrice_errorloc'
														class="error_strings"></div>
												</div>
											</div>
										</div>
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="add.new.product.commission.rate" />
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:textfield type="text" name="commissionRate"
														cssClass="form-control" tabindex="21" />
													<div id='updateCreatedProductForm_commissionRate_errorloc'
														class="error_strings"></div>
												</div>
											</div>
										</div>
									</div>



									<div class="row">

										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="add.new.product.tax" />
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:select list="{10,20,30}" name="tax" id="country"
														headerKey="-1" headerValue="Select Tax" theme="css_xhtml"
														cssClass="form-control" tabindex="24" />
													<div id='updateCreatedProductForm_tax_errorloc'
														class="error_strings"></div>
												</div>
											</div>
										</div>
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="add.new.product.purches.cost" />
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<div class="input-group">
														<s:textfield type="text" name="purchesCost"
															cssClass="form-control" tabindex="12" />

														<div id='updateCreatedProductForm_purchesCost_errorloc'
															class="error_strings"></div>
														<span class="input-group-btn"> <a type="button"
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
										<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
											<h5 class="innertitle">
												<s:text name="add.new.product.stock.information" />
											</h5>
											<hr style="margin-top: -5px">
										</div>

									</div>

									<div class="row">
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="add.new.product.usage.unit" />

												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<div class="input-group">
														<s:select cssClass="form-control chzn-select" tabindex="4"
															headerKey="1" name="usageUnit" id="leadTitle"
															list="{20,10,50}" headerValue="Select Usage Unit" />
														<span class="input-group-btn">
															<button type="button" tabindex="5"
																onclick="PopupCenter('renderAddUsageUnit','RenderAddUsageUnit',800,600);"
																class="btn btn-metis-5 btnheight_chzselect btn-line ">
																<i class="fa fa-question"></i>
															</button>
														</span> <span class="input-group-btn">
															<button type="button" tabindex="5"
																onclick="PopupCenter('renderAddLeadTitle','RenderAddLeadTitle',800,600);"
																class="btn btn-metis-3 btnheight_chzselect btn-line">
																<i class="fa fa-plus-square "></i>
															</button>
														</span>

													</div>
													<div id='updateCreatedProductForm_usageUnit_errorloc'
														class="error_strings"></div>
												</div>
											</div>
										</div>
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="add.new.product.qty.unit" />
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:textfield name="qtyUnit" cssClass="form-control"
														tabindex="25" />
													<div id='updateCreatedProductForm_qtyUnit_errorloc'
														class="error_strings"></div>
												</div>
											</div>
										</div>
									</div>



									<div class="row">
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="add.new.product.qty.in.stock" />
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:textfield name="qtyInStock" cssClass="form-control"
														tabindex="25" />
													<div id='updateCreatedProductForm_qtyInStock_errorloc'
														class="error_strings"></div>
												</div>
											</div>
										</div>
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="add.new.product.reorder.level" />
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:textfield name="reorderLevel" cssClass="form-control"
														tabindex="25" />
													<div id='updateCreatedProductForm_reorderLevel_errorloc'
														class="error_strings"></div>
												</div>
											</div>
										</div>
									</div>

									<div class="row">
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="add.new.product.handler" />
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:select list="{'A','B','C'}" name="handler" id="country"
														headerKey="-1" headerValue="Select Handler"
														theme="css_xhtml" cssClass="form-control" tabindex="24" />
													<div id='updateCreatedProductForm_handler_errorloc'
														class="error_strings"></div>
												</div>
											</div>
										</div>

										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="add.new.product.qty.in.demand" />
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:textfield name="qtyInDemand" cssClass="form-control"
														tabindex="32" />
													<div id='updateCreatedProductForm_qtyInDemand_errorloc'
														class="error_strings"></div>
												</div>
											</div>
										</div>
									</div>


									<div class="row">
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="add.new.product.product.image" />
												</div>

												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<div class="fileinput fileinput-new"
														data-provides="fileinput">
														<div class="fileinput-new thumbnail"
															style="width: 200px; height: 150px;">
															<img data-src="holder.js/100%x100%" alt="...">
														</div>
														<div class="fileinput-preview fileinput-exists thumbnail"
															style="max-width: 200px; max-height: 150px;"></div>
														<div>
															<span class="btn btn-default btn-file"><span
																class="fileinput-new"><s:text
																		name="myAccount.user.profile.select.image" /></span> <span
																class="fileinput-exists"><s:text
																		name="myAccount.user.profile.change" /></span> <s:file
																	type="file" name="productImage" /> </span> <a href="#"
																class="btn btn-default fileinput-exists"
																data-dismiss="fileinput"><s:text
																	name="myAccount.user.profile.remove" /></a>
														</div>
													</div>
												</div>
											</div>
										</div>
										<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<div class="row form-group">
												<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<s:text name="add.new.product.product.image.attachment" />
												</div>
												<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
													<s:file name="productImageAttachement" />
													<div
														id='updateCreatedProductForm_productImageAttachement_errorloc'
														class="error_strings"></div>
												</div>
											</div>
										</div>
									</div>

									<div class="row" style="margin-top: 20px;">
										<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
											<h5 class="innertitle">
												<s:text name="add.new.product.description" />
											</h5>
											<hr style="margin-top: -5px">
										</div>
									</div>

									<div class="form-group">
										<div class="row" style="margin: 1% 2%;" id="data_grid">
											<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
												<div id='updateCreatedProductForm_requirment_errorloc'
													class="error_strings"></div>
												<s:textarea id="wysihtml5" name="productdescription"
													class="form-control" rows="10" tabindex="37">
												</s:textarea>
												<div id='updateCreatedProductForm_description_errorloc'
													class="error_strings"></div>
											</div>
										</div>
									</div>
									<hr style="margin-top: 20px">
									<div class="row">
										<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"
											align="center">
											<a href="leadDashboard.action" data-toggle="tooltip"
												data-original-title="Cancel"
												class="btn btn-default btnheight"><i
												class="fa fa-caret-square-o-left fontawesomeht"></i> <s:text
													name="project.form.button.cancel"></s:text></a> <a
												href="addCreatedLead.action" data-toggle="tooltip"
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
	<script>
		$(function() {
			Metis.formGeneral();
			Metis.formWysiwyg();
		});
	</script>
	<script src="/outer/js/gen_validatorv4.js" type="text/javascript"></script>
	<script type="text/javascript">
		var frmvalidator = new Validator("updateCreatedProductForm");
		frmvalidator.EnableOnPageErrorDisplay();
		frmvalidator.EnableMsgsTogether();

		//Validation for Product Name.
		frmvalidator.addValidation("productName", "req", "Enter Product Name");
		frmvalidator.addValidation("productName", "maxlen=100",
				"Contact Product Name Should Be 100 Characters");
		frmvalidator.addValidation("productName", "minlen=3",
				"Contact Person Name Should Be 3 Characters");

		//Validation for product unit price. 
		frmvalidator.addValidation("unitPrice", "req",
				"Enter Product Unit Price");
		frmvalidator.addValidation("unitPrice", "num", "Enter Numeric Value");
		frmvalidator.addValidation("unitPrice", "maxlen=50",
				"Lead Unit Price Should Be 50 Characters");
		frmvalidator.addValidation("unitPrice", "minlen=1",
				"Unit Price Should Be 1 Characters");
	</script>
</body>
</html>