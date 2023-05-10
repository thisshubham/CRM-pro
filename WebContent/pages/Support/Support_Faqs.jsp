<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%-- <%@taglib uri="/struts-jquery-tags" prefix="sj"%> --%>

<style>
#question,#category,#productName,#owner,#status {
	display: none;
}
</style>


<script type="text/javascript">
	function showElements() {

		var selectedIndex = document.getElementById('faqAdvanceSearch');
		var element1 = document.getElementById('faqId');
		var element2 = document.getElementById('question');
		var element3 = document.getElementById('category');
		var element4 = document.getElementById('productName');
		var element5 = document.getElementById('owner');
		var element6 = document.getElementById('status');

		if (selectedIndex.value == -1 || selectedIndex.value == 1) {
			element1.style.display = 'block';
			element2.style.display = 'none';
			element3.style.display = 'none';
			element4.style.display = 'none';
			element5.style.display = 'none';
			element6.style.display = 'none';

		} else if (selectedIndex.value == 2) {
			element1.style.display = 'none';
			element2.style.display = 'block';
			element3.style.display = 'none';
			element4.style.display = 'none';
			element5.style.display = 'none';
			element6.style.display = 'none';

		} else if (selectedIndex.value == 3) {
			element1.style.display = 'none';
			element2.style.display = 'none';
			element3.style.display = 'block';
			element4.style.display = 'none';
			element5.style.display = 'none';
			element6.style.display = 'none';

		} else if (selectedIndex.value == 4) {
			element1.style.display = 'none';
			element2.style.display = 'none';
			element3.style.display = 'none';
			element4.style.display = 'block';
			element5.style.display = 'none';
			element6.style.display = 'none';

		} else if (selectedIndex.value == 5) {
			element1.style.display = 'none';
			element2.style.display = 'none';
			element3.style.display = 'none';
			element4.style.display = 'none';
			element5.style.display = 'block';
			element6.style.display = 'none';

		} else if (selectedIndex.value == 6) {
			element1.style.display = 'none';
			element2.style.display = 'none';
			element3.style.display = 'none';
			element4.style.display = 'none';
			element5.style.display = 'none';
			element6.style.display = 'block';

		}
	}
</script>
<body>
	<div id="content">
		<div class="outer">
			<div class="inner bg-light lter">

				<!--Begin Datatables-->
				<div class="row">
					<div class="col-lg-12">
						<ol class="breadcrumb" style="margin-top: 10px;">
							<li data-toggle="tooltip" data-target="#collapse1"
								data-original-title="Back To Home"><a
								href="omiInnerDashboard.action"><i class="fa fa-home"></i></a></li>
							<li><a href="SupportFaqs.action"> <s:text
										name="support_Faqs.navbar"></s:text></a></li>
							<li><a href="SupportFaqs.action"> <s:text
										name="support_Faqs.pannel.heading"></s:text></a></li>

						</ol>
						<div class="box">
							<header>
								<div class="pull-left">
									<a class="icons" href="dashboard.action" data-toggle="tooltip"
										data-original-title="Back To DashBoard"> <i
										class="fa fa-table"></i>
									</a>
									<h5 class="header_color">
										<s:text name="support_Faqs.pannel.heading"></s:text>
									</h5>
								</div>
								<div class="pull-right">
									<div class="btn-group">
										<a href="SupportAddFaqs.action" data-toggle="tooltip"
											data-original-title="New Ticket"
											class="btn btn-primary btnheight"><i
											class="fa fa-plus fontawesomeht ">&nbsp;<s:text
													name="support_Faqs.add.new.faq"></s:text></i></a>
										<button type="button" class="btn btn-info "
											data-toggle="collapse" data-target="#collapse1">
											<i class="fa fa-filter"></i>
											<s:text name="support_Faqs.filter"></s:text>
										</button>
										<a class="btn btn-success btnheight" data-toggle="tooltip"
											data-original-title="Refresh" href="SupportFaqs.action"><i
											class="fa fa-refresh "></i></a> <a href="SupportFaqsXLSReport.action"
											type="button" data-toggle="tooltip"
											data-original-title="XLS Report"
											class="btn btn-default btnheight"><i
											class="fa fa-file-excel-o fontawesomeht"></i></a> <a href=""
											data-toggle="tooltip" data-original-title="Settings"
											type="button" class="btn btn-warning btnheight"><i
											class="fa fa-gear fontawesomeht "></i></a> <a
											href="dashboard.action" data-toggle="tooltip"
											data-original-title="Close" class="btn btn-danger btnheight"><i
											class="fa fa-times fontawesomeht"></i></a>
									</div>
								</div>
							</header>
							<div id="collapse4" class="body">
								<div class="table-responsive">
									<p>
										<s:if test="hasActionErrors()">
											<div class="alert alert-danger" style="padding-bottom: 7px;"
												role="alert">
												<div class="infoIcon">
													<s:actionerror />
												</div>
											</div>
										</s:if>
										<s:elseif test="hasActionMessages()">
											<div class="alert alert-success" role="alert">
												<div class="infoIcon">
													<s:actionmessage />
												</div>
											</div>
										</s:elseif>
										<s:else>
											<div class="alert alert-info" role="alert">
												<div class="infoIcon">
													<i class="fa fa-info-circle "></i>
													<s:text name="support_Faqs.info.bar" />
												</div>
											</div>
										</s:else>
									</p>
									<div id="collapse1" class="panel-collapse collapse">
										<div class="row searchBar">
											<s:form name="advanceSearchForm" method="POST"
												action="populateFaqSearch">
												<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"
													style="margin-top: 8px;">
													<div class="col-lg-1  col-md-1  col-sm-12 col-xs-12">
														<label>
															<h5>
																<s:text name="support_Faqs.search.by"></s:text>
															</h5>
														</label>
													</div>
													<div class="col-lg-4  col-md-4  col-sm-12 col-xs-12">
														<s:select list="advanceSearchList" headerKey="-1"
															onchange="showElements();" id="faqAdvanceSearch"
															headerValue="Search By" cssClass="form-control"
															name="searchId"></s:select>
														<div id='advanceSearchForm_searchId_errorloc'
															class="error_strings"></div>
													</div>
													<div class="col-lg-4  col-md-4  col-sm-12 col-xs-12">
														<div class="input-group">
															<s:textfield cssClass="form-control" id="faqId"
																name="faqId" placeholder="Select Faq ID" />

															<s:textfield cssClass="form-control" id="question"
																placeholder="Select Your question" name="question" />

															<s:select list="faqCategoryList" headerKey="-1"
																id="category" headerValue="Select Your Category"
																cssClass="form-control chzn-select " name="category"></s:select>

															<s:select list="faqProductNameList" headerKey="-1"
																headerValue="Select Product Name"
																cssClass="form-control chzn-select" name="productName"
																id="productName"></s:select>

															<s:select list="faqOwnerList" headerKey="-1" id="owner"
																headerValue="Select Faq Owner Name"
																cssClass="form-control chzn-select" name="owner"></s:select>

															<s:select list="faqStatusList" headerKey="-1"
																headerValue="Select Faq Status"
																cssClass="form-control chzn-select" name="status"
																id="status"></s:select>

															<span class="input-group-btn">
																<button type="submit" data-toggle="tooltip"
																	onclick="validate();" data-original-title="Search"
																	class="btn btn-metis-5 btn-line">
																	<span class="glyphicon glyphicon-search"></span>&nbsp;
																	<s:text name="Search"></s:text>
																</button>
															</span>
														</div>
														<div id='advanceSearchForm_faqId_errorloc'
															class="error_strings"></div>
														<div id='advanceSearchForm_question_errorloc'
															class="error_strings"></div>
														<div id='advanceSearchForm_productName_errorloc'
															class="error_strings"></div>
														<div id='advanceSearchForm_category_errorloc'
															class="error_strings"></div>
														<div id='advanceSearchForm_owner_errorloc'
															class="error_strings"></div>
														<div id='advanceSearchForm_status_errorloc'
															class="error_strings"></div>
													</div>
												</div>
											</s:form>
										</div>
									</div>
									<table id="dataTable"
										class="table table-bordered table-condensed table-hover table-striped">
										<thead>
											<tr id="myrow">
												<th style="width: 5%;"><s:text
														name="client.grid.action"></s:text></th>
												<th><s:text name="support_Faqs.support.id"></s:text></th>
												<th><s:text name="support_addFaq.question"></s:text></th>
												<th><s:text name="support_addFaq.category"></s:text></th>
												<th><s:text name="support_addFaq.product.name"></s:text></th>
												<th><s:text name="support_addFaq.owner"></s:text></th>
												<th><s:text name="support_addFaq.status"></s:text></th>
											</tr>
										</thead>
										<tbody>
											<s:iterator value="faqGridList">
												<tr>
													<td align="center">
														<div class="btn-group">
															<a id="view"
																href="supportViewFaq?command=<s:property value='faqId'/>"
																data-toggle="tooltip" data-original-title="View"
																data-placement="bottom"> <i class="fa fa-eye"></i>
															</a>
														</div>
														<div class="btn-group">
															<a id="edit"
																href="supportEditFaq.action?command=<s:property value='faqId' />"
																data-toggle="tooltip" data-original-title="Edit"
																data-placement="bottom"> <i class="fa fa-edit"></i>
															</a>
														</div>
														<div class="btn-group">
															<a href="#" id="delete"
																onclick="confirmDelete('deleteFaqDetail.action?command='+<s:property value='faqId'/>)"
																data-toggle="tooltip" data-original-title="Delete"
																data-placement="bottom" data-placement="bottom"> <i
																class="fa fa-trash-o"></i>
															</a>
														</div>

													</td>
													<td><a style="color: blue"
														href="supportViewFaq?command=<s:property value='faqId' />">
															<s:property value='faqId' />
													</a></td>
													<td><s:property value="question" /></td>
													<td><s:property value="category" /></td>
													<td><s:property value="ProductName" /></td>
													<td><s:property value="owner" /></td>
													<td><s:property value="status" /></td>
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
	<script src="assets/lib/screenfull/screenfull.js"></script>
	<script src="assets/lib/datatables/jquery.dataTables.js"></script>
	<script src="assets/lib/datatables/3/dataTables.bootstrap.js"></script>
	<script src="assets/lib/jquery.tablesorter/jquery.tablesorter.min.js"></script>
	<script
		src="assets/lib/jquery-ui-touch-punch/jquery.ui.touch-punch.min.js"></script>

	<!-- Metis core scripts -->
	<script src="assets/js/core.min.js"></script>

	<!-- Metis demo scripts -->
	<script src="assets/js/app.min.js"></script>

	<script>
		$(function() {
			Metis.MetisTable();
			Metis.metisSortable();
		});
	</script>

	<script src="/outer/js/gen_validatorv4.js" type="text/javascript"></script>
	<script type="text/javascript">
		function validate() {
			var frmvalidator = new Validator("advanceSearchForm");
			frmvalidator.EnableOnPageErrorDisplay();
			frmvalidator.EnableMsgsTogether();

			frmvalidator.addValidation("searchId", "dontselect=-1",
					"Select Search Type");
			var selectedIndex = document.getElementById('faqAdvanceSearch');

			if (selectedIndex.value == 1) {
				frmvalidator.addValidation("faqId", "req", "Enter Faq Id ");
			} else if (selectedIndex.value == 2) {
				frmvalidator
						.addValidation("question", "req", "Select Question");
			} else if (selectedIndex.value == 3) {
				frmvalidator.addValidation("category", "dontselect=-1",
						"Select Category");
			} else if (selectedIndex.value == 4) {
				frmvalidator.addValidation("productName", "dontselect=-1",
						"Select Product Name");
			} else if (selectedIndex.value == 5) {
				frmvalidator.addValidation("owner", "dontselect=-1",
						"Select your owner");
			} else if (selectedIndex.value == 6) {
				frmvalidator.addValidation("status", "dontselect=-1",
						"Select your status");
			}
		}
	</script>
	<script src="assets/js/style-switcher.min.js"></script>

	<script type="text/javascript">
			function confirmDelete(url) {
				if (confirm("Are you sure you want to delete?")) {
					document.location = url;
				}

			}
			//Popup window code for Edit
			function confirmEdit(url) {
				popupWindow = window
						.open(
								url,
								'popUpWindow',
								'height=600,width=800,left=(screen.width/2)-(800/2),top=(screen.height/2)-(600/2),resizable=no,scrollbars=yes,addressbar=no,toolbar=no,menubar=no,location=0,directories=no,status=yes');

			}
		</script>

</body>