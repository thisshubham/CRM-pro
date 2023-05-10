<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style>
#Account,#Documents,#Campaign,#Lead,#Assignment,#Product,#Vendor,#Expenses,#Cases,#Tickets
	{
	display: none;
}
</style>

<script type="text/javascript">
	function showAnalytics() {

		var selectedIndex = document.getElementById('advanceSearch');

		var element1 = document.getElementById('Contact');
		var element2 = document.getElementById('Account');
		var element3 = document.getElementById('Documents');
		var element4 = document.getElementById('Campaign');
		var element5 = document.getElementById('Lead');
		var element6 = document.getElementById('Assignment');
		var element7 = document.getElementById('Product');
		var element8 = document.getElementById('Vendor');
		var element9 = document.getElementById('Expenses');
		var element10 = document.getElementById('Cases');
		var element11 = document.getElementById('Tickets');

		if (selectedIndex.value == 1) {
			element1.style.display = 'block';
			element2.style.display = 'none';
			element3.style.display = 'none';
			element4.style.display = 'none';
			element5.style.display = 'none';
			element6.style.display = 'none';
			element7.style.display = 'none';
			element8.style.display = 'none';
			element9.style.display = 'none';
			element10.style.display = 'none';
			element11.style.display = 'none';

		} else if (selectedIndex.value == 2) {
			element1.style.display = 'none';
			element2.style.display = 'block';
			element3.style.display = 'none';
			element4.style.display = 'none';
			element5.style.display = 'none';
			element6.style.display = 'none';
			element7.style.display = 'none';
			element8.style.display = 'none';
			element9.style.display = 'none';
			element10.style.display = 'none';
			element11.style.display = 'none';

		} else if (selectedIndex.value == 3) {
			element1.style.display = 'none';
			element2.style.display = 'none';
			element3.style.display = 'block';
			element4.style.display = 'none';
			element5.style.display = 'none';
			element6.style.display = 'none';
			element7.style.display = 'none';
			element8.style.display = 'none';
			element9.style.display = 'none';
			element10.style.display = 'none';
			element11.style.display = 'none';

		} else if (selectedIndex.value == 4) {
			element1.style.display = 'none';
			element2.style.display = 'none';
			element3.style.display = 'none';
			element4.style.display = 'block';
			element5.style.display = 'none';
			element6.style.display = 'none';
			element7.style.display = 'none';
			element8.style.display = 'none';
			element9.style.display = 'none';
			element10.style.display = 'none';
			element11.style.display = 'none';

		} else if (selectedIndex.value == 5) {
			element1.style.display = 'none';
			element2.style.display = 'none';
			element3.style.display = 'none';
			element4.style.display = 'none';
			element5.style.display = 'block';
			element6.style.display = 'none';
			element7.style.display = 'none';
			element8.style.display = 'none';
			element9.style.display = 'none';
			element10.style.display = 'none';
			element11.style.display = 'none';

		} else if (selectedIndex.value == 6) {
			element1.style.display = 'none';
			element2.style.display = 'none';
			element3.style.display = 'none';
			element4.style.display = 'none';
			element5.style.display = 'none';
			element6.style.display = 'block';
			element7.style.display = 'none';
			element8.style.display = 'none';
			element9.style.display = 'none';
			element10.style.display = 'none';
			element11.style.display = 'none';

		} else if (selectedIndex.value == 7) {
			element1.style.display = 'none';
			element2.style.display = 'none';
			element3.style.display = 'none';
			element4.style.display = 'none';
			element5.style.display = 'none';
			element6.style.display = 'none';
			element7.style.display = 'block';
			element8.style.display = 'none';
			element9.style.display = 'none';
			element10.style.display = 'none';
			element11.style.display = 'none';
		} else if (selectedIndex.value == 8) {
			element1.style.display = 'none';
			element2.style.display = 'none';
			element3.style.display = 'none';
			element4.style.display = 'none';
			element5.style.display = 'none';
			element6.style.display = 'none';
			element7.style.display = 'none';
			element8.style.display = 'block';
			element9.style.display = 'none';
			element10.style.display = 'none';
			element11.style.display = 'none';

		} else if (selectedIndex.value == 9) {
			element1.style.display = 'none';
			element2.style.display = 'none';
			element3.style.display = 'none';
			element4.style.display = 'none';
			element5.style.display = 'none';
			element6.style.display = 'none';
			element7.style.display = 'none';
			element8.style.display = 'none';
			element9.style.display = 'block';
			element10.style.display = 'none';
			element11.style.display = 'none';

		} else if (selectedIndex.value == 10) {
			element1.style.display = 'none';
			element2.style.display = 'none';
			element3.style.display = 'none';
			element4.style.display = 'none';
			element5.style.display = 'none';
			element6.style.display = 'none';
			element7.style.display = 'none';
			element8.style.display = 'none';
			element9.style.display = 'none';
			element10.style.display = 'block';
			element11.style.display = 'none';

		} else if (selectedIndex.value == 11) {
			element1.style.display = 'none';
			element2.style.display = 'none';
			element3.style.display = 'none';
			element4.style.display = 'none';
			element5.style.display = 'none';
			element6.style.display = 'none';
			element7.style.display = 'none';
			element8.style.display = 'none';
			element9.style.display = 'none';
			element10.style.display = 'none';
			element11.style.display = 'block';

		}

	}
</script>

<body>
	<div id="content">
		<div class="outer">
			<div class="inner bg-light lter">


				<div class="container-fluid"
					style="padding-left: 0px; padding-right: 0px">



					<div class="row">
						<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">

							<ol class="breadcrumb" style="margin-top: 10px;">
								<li><a href="dashboardAnalytics.action">Analytics</a></li>
								
								
							</ol>

							<div class="bs-example">
								<ul class="nav nav-tabs" id="myTab">
									<li><a href="omiInnerDashboard.action">Dashboard</a></li>
									<li><a href="dashboardUsers">Users</a></li>
									<li><a href="dashboardGraphReports">Quick Reports</a></li>
									<li class="active"><a href="dashboardAnalytics">Analytics</a></li>
								</ul>
								<div class="tab-content" id="myTabContent"
									style="white-space: normal;"></div>

							</div>
							<div class="row">
								<div class="col-lg-12  col-md-12  col-sm-12 col-xs-12"
									style="margin-top: 20px;">

									<form action="" name="ContactAnalyticsForm" style="background-color:grey;">
										<div class="col-lg-1  col-md-1  col-sm-12 col-xs-12">
											<label>
												<h5>
													<s:text name="lead.dashboard.searchby"></s:text>
												</h5>
											</label>
										</div>
										<div class="col-lg-3  col-md-3  col-sm-6 col-xs-12" style="margin-top:5px; margin-bottom:5px;">
											<s:select list="analyticsadvancesearch"
												onchange="showAnalytics();" id="advanceSearch"
												cssClass="form-control" name="searchId"></s:select>
										</div>

										<div class="col-lg-3   col-md-3  col-sm-6 col-xs-12" style="margin-top:5px; margin-bottom:5px;">


											<s:select list="analyticalContactBoard" headerKey="-1"
												headerValue="Select Contact"
												cssClass="form-control chzn-select" name="Contact"
												id="Contact" onchange="myContact()"></s:select>
											<s:select list="analyticalAccountBoard" headerKey="-1"
												headerValue="Select Account"
												cssClass="form-control chzn-select" name="Account"
												id="Account" onchange="myAccount()"></s:select>
											<s:select list="analyticalDocumentBoard" headerKey="-1"
												headerValue="Select Documents"
												cssClass="form-control chzn-select" name="Documents"
												id="Documents" onchange="myDocument()"></s:select>
											<s:select list="analyticalCampaignBoard" headerKey="-1"
												headerValue="Select campaign"
												cssClass="form-control chzn-select" name="Campaign"
												id="Campaign" onchange="myCampaign()"></s:select>

											<s:select list="analyticsLeadBoard" headerKey="-1"
												headerValue="Select Lead"
												cssClass="form-control chzn-select" name="Lead" id="Lead"
												onchange="mylead()"></s:select>

											<s:select list="analyticalAssignmentBorad" headerKey="-1"
												headerValue="Select Assignments"
												cssClass="form-control chzn-select" name="Assignment"
												id="Assignment" onchange="myAssignment()"></s:select>
											<s:select list="analyticalProductBoard" headerKey="-1"
												headerValue="Select Product"
												cssClass="form-control chzn-select" name="Product"
												id="Product" onchange="myProduct()"></s:select>
											<s:select list="analyticalVendorBoard" headerKey="-1"
												headerValue="Select Vendor"
												cssClass="form-control chzn-select" name="Vendor"
												id="Vendor" onchange="myVendor()"></s:select>
											<s:select list="analyticalExpensesBoard" headerKey="-1"
												headerValue="Select Expenses"
												cssClass="form-control chzn-select" name="Expenses"
												id="Expenses" onchange="myExpenses()"></s:select>
											<s:select list="analyticalCasesBoard" headerKey="-1"
												headerValue="Select Cases"
												cssClass="form-control chzn-select" name="Cases" id="Cases" onchange="myCases()"></s:select>
											<s:select list="analyticalTicketBoard" headerKey="-1"
												headerValue="Select Tickets"
												cssClass="form-control chzn-select" name="Tickets"
												id="Tickets" onchange="myTicket()"></s:select>
										</div>

										<%-- <div class="col-lg-2  col-md-2  col-sm-9 col-xs-12">
											<span class="input-group-btn">
												<button type="submit" data-toggle="tooltip" onclick=""
													data-original-title="Submit"
													class="btn btn-metis-5 btn-line">
													<s:text name="project.form.button.submit"></s:text>
												</button>
											</span>
										</div> --%>
										
									</form>

								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="assets/js/myTickets.js"></script>
	
</body>
</html>