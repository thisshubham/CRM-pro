<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>

	<div class="outer">
		<div class="inner bg-light lter">
			<div class="box dark">
				<header> <a class="icons" href="settingsUser.action"
					data-toggle="tooltip" data-original-title="Back To User DashBoard"
					style="color: black;"> <i class="fa fa-th-large"></i>
				</a>
				<h5>
					<s:text name="User Details" />
				</h5>

				<!-- .toolbar -->
				<div class="toolbar">
					<nav style="padding: 8px;"> <a href="" data-toggle="tooltip"
						data-original-title="Print" class="btn btn-metis-5 btn-sm"> <i
						class="fa fa-print"></i>
					</a> <a href="#" data-toggle="tooltip" data-original-title="PDF Report"
						class="btn btn-metis-6 btn-sm "> <i class="fa fa-file-pdf-o "></i>
					</a> <a href="settingsUser.action" data-toggle="tooltip"
						data-original-title="Close" data-placement="bottom"
						class="btn btn-danger btn-sm"> <i class="fa fa-times"></i>
					</a> </nav>
				</div>
				</header>

				<div class="container">
					<div id="div-2" class="body">
						<%-- <s:iterator value="" var=""> --%>
						<div class="row" style="margin-top: 10px;">
							<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
								<h5>
									<s:text name="Personal Information" />
								</h5>
							</div>

						</div>
						<div class="row">
							<div class="col-md-12 col-sm-12 col-xs-12">
								<div class="col-md-2 col-sm-12 col-xs-12" id="view_lable">
									<label for="text1" class="control-label" id="viewlable">
										<s:text name="myAccount.user.profile.customer.id" />
									</label>
								</div>
								<div class="col-md-10 col-sm-12 col-xs-12 control-label"
									id="view_lable_value">
									<s:property value="" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12 col-sm-12 col-xs-12">

								<div class="col-md-2 col-sm-12 col-xs-12" id="view_lable">
									<label for="text1" class="control-label " id="viewlable">
										<s:text name="Status" />
									</label>
								</div>
								<div class="col-md-10 col-sm-12 col-xs-12 control-label"
									id="view_lable_value2">
									<s:property value="" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12 col-sm-12 col-xs-12">
								<div class="col-md-2 col-sm-12 col-xs-12" id="view_lable">
									<label for="text1" class="control-label" id="viewlable">
										<s:text name="Full Name" />
									</label>
								</div>
								<div class="col-md-10 col-sm-12 col-xs-12 control-label"
									id="view_lable_value">
									<s:property value="" />

								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12 col-sm-12 col-xs-12">
								<div class="col-md-2 col-sm-12 col-xs-12" id="view_lable">
									<label for="text1" class="control-label" id="viewlable">
										<s:text name="Date Of Birth" />
									</label>
								</div>
								<div class="col-md-10 col-sm-12 col-xs-12 control-label"
									id="view_lable_value2">
									<s:property value="" />
								</div>

							</div>
						</div>



						<div class="row">
							<div class="col-md-12 col-sm-12 col-xs-12">
								<div class="col-md-2 col-sm-12 col-xs-12" id="view_lable">
									<label for="text1" class="control-label" id="viewlable">
										<s:text name="Gender" />
									</label>
								</div>
								<div class="col-md-10 col-sm-12 col-xs-12 control-label"
									id="view_lable_value">
									<s:property value="" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12  col-sm-12 col-xs-12">
								<div class="col-md-2 col-sm-12 col-xs-12" id="view_lable">
									<label for="text1" class="control-label" id="viewlable"><s:text
											name="Primary Email ID" /></label>
								</div>
								<div class="col-md-10 col-sm-12 col-xs-12 control-label"
									id="view_lable_value2">
									<s:property value="" />
								</div>
							</div>
						</div>



						<div class="row">
							<div class="col-md-12  col-sm-12 col-xs-12">
								<div class="col-md-2 col-sm-12 col-xs-12" id="view_lable">
									<label for="text1" class="control-label" id="viewlable"><s:text
											name="Alternet Email ID" /></label>
								</div>
								<div class="col-md-10 col-sm-12 col-xs-12 control-label"
									id="view_lable_value">
									<s:property value="" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12  col-sm-12 col-xs-12">
								<div class="col-md-2 col-sm-12 col-xs-12" id="view_lable">
									<label for="text1" class="control-label" id="viewlable"><s:text
											name="Designation" /></label>
								</div>
								<div class="col-md-10 col-sm-12 col-xs-12 control-label"
									id="view_lable_value2">
									<s:property value="" />
								</div>
							</div>
						</div>




						<div class="row">
							<div class="col-md-12  col-sm-12 col-xs-12">
								<div class="col-md-2 col-sm-12 col-xs-12" id="view_lable">
									<label for="text1" class="control-label" id="viewlable"><s:text
											name="User Role" /></label>
								</div>
								<div class="col-md-10 col-sm-12 col-xs-12 control-label"
									id="view_lable_value">
									<s:property value="" />

								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12  col-sm-12 col-xs-12">
								<div class="col-md-2 col-sm-12 col-xs-12" id="view_lable">
									<label for="text1" class="control-label" id="viewlable"><s:text
											name="Department" /></label>
								</div>
								<div class="col-md-10 col-sm-12 col-xs-12 control-label"
									id="view_lable_value2">
									<s:property value="" />
								</div>
							</div>
						</div>




						<div class="row">
							<div class="col-md-12  col-sm-12 col-xs-12">
								<div class="col-md-2 col-sm-12 col-xs-12" id="view_lable">
									<label for="text1" class="control-label" id="viewlable"><s:text
											name="Location" /></label>
								</div>
								<div class="col-md-10 col-sm-12 col-xs-12 control-label"
									id="view_lable_value">
									<s:property value="" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
								<h5>
									<s:text name="add.create.lead.contact.information" />
								</h5>
							</div>

						</div>


						<div class="row">
							<div class="col-md-12  col-sm-12 col-xs-12">
								<div class="col-md-2 col-sm-12 col-xs-12" id="view_lable">
									<label for="text1" class="control-label" id="viewlable"><s:text
											name="add.create.lead.adress.line1" /></label>
								</div>
								<div class="col-md-10 col-sm-12 col-xs-12 control-label"
									id="view_lable_value2">
									<s:property value="" />
								</div>

							</div>
						</div>
						<div class="row">
							<div class="col-md-12  col-sm-12 col-xs-12">
								<div class="col-md-2 col-sm-12 col-xs-12" id="view_lable">
									<label for="text1" class="control-label" id="viewlable"><s:text
											name="add.create.lead.adress.line2" /></label>
								</div>
								<div class="col-md-10 col-sm-12 col-xs-12 control-label"
									id="view_lable_value">
									<s:property value="" />
								</div>
							</div>
						</div>



						<div class="row">
							<div class="col-md-12  col-sm-12 col-xs-12">
								<div class="col-md-2 col-sm-12 col-xs-12" id="view_lable">
									<label for="text1" class="control-label" id="viewlable"><s:text
											name="add.create.lead.city" /></label>
								</div>
								<div class="col-md-10 col-sm-12 col-xs-12 control-label"
									id="view_lable_value2">
									<s:property value="" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12  col-sm-12 col-xs-12">
								<div class="col-md-2 col-sm-12 col-xs-12" id="view_lable">
									<label for="text1" class="control-label" id="viewlable"><s:text
											name="add.create.lead.state" /></label>
								</div>
								<div class="col-md-10 col-sm-12 col-xs-12 control-label"
									id="view_lable_value">
									<s:property value="state" />
								</div>
							</div>
						</div>



						<div class="row">
							<div class="col-md-12  col-sm-12 col-xs-12">
								<div class="col-md-2 col-sm-12 col-xs-12" id="view_lable">
									<label for="text1" class="control-label" id="viewlable"><s:text
											name="add.create.lead.country" /></label>
								</div>
								<div class="col-md-10 col-sm-12 col-xs-12 control-label"
									id="view_lable_value2">
									<s:property value="country" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12  col-sm-12 col-xs-12">
								<div class="col-md-2 col-sm-12 col-xs-12" id="view_lable">
									<label for="text1" class="control-label" id="viewlable"><s:text
											name="add.create.lead.zipcode" /></label>
								</div>
								<div class="col-md-10 col-sm-12 col-xs-12 control-label"
									id="view_lable_value">
									<s:property value="zipcode" />
								</div>
							</div>
						</div>




						<div class="row">
							<div class="col-md-12  col-sm-12 col-xs-12">
								<div class="col-md-2 col-sm-12 col-xs-12" id="view_lable">
									<label for="text1" class="control-label" id="viewlable"><s:text
											name="add.create.lead.phone" /></label>
								</div>
								<div class="col-md-10 col-sm-12 col-xs-12 control-label"
									id="view_lable_value2">
									<s:property value="phoneNo" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12  col-sm-12 col-xs-12">
								<div class="col-md-2  col-sm-12 col-xs-12" id="view_lable">
									<label for="text1" class="control-label" id="viewlable"><s:text
											name="add.create.lead.mobile" /></label>
								</div>
								<div class="col-md-10 col-sm-12 col-xs-12 control-label"
									id="view_lable_value">
									<s:property value="mobileNo" />
								</div>
							</div>
						</div>



						<div class="row">
							<div class="col-md-12  col-sm-12 col-xs-12">
								<div class="col-md-2 col-sm-12 col-xs-12" id="view_lable">
									<label for="text1" class="control-label" id="viewlable"><s:text
											name="add.create.lead.fax" /></label>
								</div>
								<div class="col-md-10 col-sm-12 col-xs-12 control-label"
									id="view_lable_value2">
									<s:property value="fax" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12  col-sm-12 col-xs-12">
								<div class="col-md-2  col-sm-12 col-xs-12" id="view_lable">
									<label class="control-label" id="viewlable"><s:text
											name="add.create.lead.website" /></label>
								</div>
								<div class="col-md-10 col-sm-12 col-xs-12 control-label"
									id="view_lable_value">
									<s:property value="website" />
								</div>

							</div>
						</div>
						<div class="row">
							<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
								<h5>
									<s:text name="Locale Information" />
								</h5>
							</div>
						</div>

						<div class="row">
							<div class="col-md-12  col-sm-12 col-xs-12">
								<div class="col-md-2  col-sm-12 col-xs-12" id="view_lable">
									<label class="control-label" id="viewlable"><s:text
											name="Language" /></label>
								</div>
								<div class="col-md-10 col-sm-12 col-xs-12 control-label"
									id="view_lable_value">
									<s:property value="" />
								</div>

							</div>
						</div>

						<div class="row">
							<div class="col-md-12  col-sm-12 col-xs-12">
								<div class="col-md-2  col-sm-12 col-xs-12" id="view_lable">
									<label class="control-label" id="viewlable"><s:text
											name="Currency" /></label>
								</div>
								<div class="col-md-10 col-sm-12 col-xs-12 control-label"
									id="view_lable_value">
									<s:property value="" />
								</div>

							</div>
						</div>

						<div class="row">
							<div class="col-md-12  col-sm-12 col-xs-12">
								<div class="col-md-2  col-sm-12 col-xs-12" id="view_lable">
									<label class="control-label" id="viewlable"><s:text
											name="Time Zone" /></label>
								</div>
								<div class="col-md-10 col-sm-12 col-xs-12 control-label"
									id="view_lable_value">
									<s:property value="" />
								</div>

							</div>
						</div>
						<div class="row">
							<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
								<h5>
									<s:text name="user.create.profile.image"></s:text>
								</h5>
							</div>
						</div>

						<div class="row">
							<div class="col-lg-5 col-md-5 col-sm-5 col-xs-5 col-xs-offset-5">

								<div class="fileinput fileinput-new" data-provides="fileinput">
									<div class="fileinput-new thumbnail"
										style="width: 150px; height: 150px;">
										<img src="#" alt="Profile Image">
									</div>

									<div class="fileinput-preview fileinput-exists thumbnail"
										style="max-width: 200px; max-height: 150px;"></div>

								</div>


							</div>
						</div>

						<div class="row">
							<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
								<h5>
									<s:text name="add.create.lead.social.information" />
								</h5>
							</div>
						</div>
						<div class="row " class="tab-pane fade" id="addSocial">
							<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"
								id="dataTable">
								<div class="table-responsive">
									<table class="table table-bordered responsive-table">
										<thead>
											<tr id="myrow">
												<th><s:text name="add.lead.social.table.social" /></th>
												<th><s:text name="add.lead.social.table.socialname" /></th>
											</tr>
										</thead>
										<tbody>
											<%-- <s:iterator value="leadSocialDetailsGrid"> --%>
											<tr>
												<td><s:property value="socialSiteRefName" /></td>
												<td><s:property value="socialContactValue" /></td>
											</tr>
											<%-- </s:iterator> --%>
										</tbody>
									</table>
								</div>
							</div>
						</div>
						<%-- </s:iterator> --%>

					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>