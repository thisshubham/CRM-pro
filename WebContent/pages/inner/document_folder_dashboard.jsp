<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- scroll css  start-->
<style>
div.scroll {
	background-color:;
	width: auto;
	height: auto;
	overflow: scroll;
}

div.hidden {
	background-color:;
	width: auto;
	height: 500px;
	overflow: hidden;
}
</style>
<!--end scroll  -->

</head>
<body>
<body>

	<div id="content">
		<div class="outer">
			<div class="inner bg-light lter">

				<!--Begin Datatables-->
				<div class="row">
					<div class="col-lg-12">
						<div class="box inverse">
							<header>

							<div class="icons">
								<i class="fa fa-dashboard"></i>
							</div>

							<h5>Document Directories Dashboard</h5>

							</header>
							<div id="collapse4" class="body">


								<div class="table-responsive">
									<div id="dashboard_search_tools">
										<div class="row">
											<div class="col-lg-10  col-md-10  col-sm-12 col-xs-12">
												<div class="col-xs-12 form-group">
													<a href="folderDashboard" data-toggle="tooltip"
														data-original-title="Directories" data-placement="bottom"
														class="btn btn-metis-2 btn-line"> <i class="fa fa-folder "> Directories
													</i>

													</a> <a href="#" data-toggle="tooltip"
														data-original-title="All Files" data-placement="bottom"
														class="btn btn-metis-3 btn-line"> <i class="fa fa-th-list "> All Files
													</i>

													</a> <a href="#" data-toggle="tooltip"
														data-original-title="Document" data-placement="bottom"
														class="btn btn-metis-4 btn-line"> <i class="fa fa-file-text "> Document</i>

													</a> <a href="#" data-toggle="tooltip"
														data-original-title="Picture" data-placement="bottom"
														class="btn btn-metis-5 btn-line"> <i class="fa fa-picture-o "> Picture</i>

													</a> <a href="#" data-toggle="tooltip"
														data-original-title="Music" data-placement="bottom"
														class="btn btn-metis-6 btn-line"> <i class="fa fa-music "> Music</i>

													</a> <a href="#" data-toggle="tooltip"
														data-original-title="Video" data-placement="bottom"
														class="btn btn-metis-4 btn-line""> <i
														class="fa fa-video-camera "> Video</i>

													</a> <a href="#" data-toggle="tooltip"
														data-original-title="Favourite" data-placement="bottom"
														class="btn btn-metis-1 btn-line"><i class="fa fa-star "> Favourite</i>

													</a> <button type="button" data-toggle="modal"
														onclick="uploadFile" data-target="#uploadDocument"
														class="btn btn-metis-3 btn-line">
														<i class="fa fa-upload "> UploadFile</i>
													</button>
												</div>
											</div>
											<div class="col-lg-2 col-md-2 col-sm-12 col-xs-12">
												<div class=" col-xs-12 form-group">
													<a href="#" data-toggle="tooltip"
														data-original-title="Refresh" data-placement="bottom"
														class="btn btn-metis-2 btn-line"> <i
														class="fa fa-refresh "></i>

													</a> <a href="#" data-toggle="tooltip"
														data-original-title="Setting" data-placement="bottom"
														class="btn btn-metis-1 btn-line"> <i
														class="fa fa-gear "></i>

													</a> <a href="#" data-toggle="tooltip"
														data-original-title="XLS Report" data-placement="bottom"
														class="btn btn-metis-6 btn-line"> <i
														class="fa fa-file-excel-o "></i>
													</a>
												</div>
											</div>
										</div>
									</div>

									</br>

									<table id="dataTable"
										class="table table-bordered table-condensed table-hover table-striped">
										<thead>
											<tr id="myrow">


												<th>Folder Name</th>
												<th>No Of Files</th>
												<th>No Of Sub_Folder</th>
												<th>Created By</th>
												<th>Created Date</th>
												<th>Status</th>
												<th style="width: 20pxx">Action</th>

											</tr>
										</thead>
										<tbody>

											<tr>
												<td><a href="#" data-toggle="tooltip"
													data-original-title="Open Folder" data-placement="right"
													 style="color: #E2B185;">
														<i class="fa fa-folder-open"></i>
												</a>&nbsp; Kaluram/My Documents</td>
												<td>2</td>
												<td>0</td>
												<td>Kaluram Chakrawrti</td>
												<td>28-12-2015</td>
												<td><a class="btn btn-default btn-xs btn-line" href="#">New</a></td>

												<td><a href="properties.action" data-toggle="tooltip"
													data-original-title="Properties" data-placement="bottom"
													class="btn btn-metis-5 btn-xs"> <i class="fa fa-tasks "></i>
												</a> <a href="download.action" data-toggle="tooltip"
													data-original-title="Download" data-placement="bottom"
													class="btn btn-metis-3 btn-xs"> <i
														class="fa fa-download "></i>

												</a> <a href="preview.acion" data-toggle="tooltip"
													data-original-title="Priview" data-placement="bottom"
													class="btn btn-metis-4 btn-xs"> <i class="fa fa-eye"></i>
												</a></td>

											</tr>
											<tr>
												<td><a href="#" data-toggle="tooltip"
													data-original-title="Open Folder" data-placement="right"
													 style="color: #E2B185;">
														<i class="fa fa-folder-open"></i>
												</a> &nbsp; Kaluram/My Documents</td>
												<td>2</td>
												<td>0</td>
												<td>Kaluram Chakrawrti</td>
												<td>28-12-2015</td>
												<td><a class="btn btn-primary btn-xs btn-line" href="#">Open</a></td>

												<td><a href="properties.action" data-toggle="tooltip"
													data-original-title="Properties" data-placement="bottom"
													class="btn btn-metis-5 btn-xs"> <i class="fa fa-tasks "></i>
												</a> <a href="download.action" data-toggle="tooltip"
													data-original-title="Download" data-placement="bottom"
													class="btn btn-metis-3 btn-xs"> <i
														class="fa fa-download "></i>

												</a> <a href="preview.acion" data-toggle="tooltip"
													data-original-title="Priview" data-placement="bottom"
													class="btn btn-metis-4 btn-xs"> <i class="fa fa-eye"></i>
												</a></td>

											</tr>
											<tr>
												<td><a href="#" data-toggle="tooltip"
													data-original-title="Open Folder" data-placement="right"
													 style="color: #E2B185;">
														<i class="fa fa-folder-open"></i>
												</a> &nbsp; Kaluram/My Documents</td>
												<td>2</td>
												<td>0</td>
												<td>Kaluram Chakrawrti</td>
												<td>28-12-2015</td>
												<td><a class="btn btn-success btn-xs btn-line" href="#">Submitted</a></td>

												<td><a href="properties.action" data-toggle="tooltip"
													data-original-title="Properties" data-placement="bottom"
													class="btn btn-metis-5 btn-xs"> <i class="fa fa-tasks "></i>
												</a> <a href="download.action" data-toggle="tooltip"
													data-original-title="Download" data-placement="bottom"
													class="btn btn-metis-3 btn-xs"> <i
														class="fa fa-download "></i>

												</a> <a href="preview.acion" data-toggle="tooltip"
													data-original-title="Priview" data-placement="bottom"
													class="btn btn-metis-4 btn-xs"> <i class="fa fa-eye"></i>
												</a></td>

											</tr>
											<tr>
												<td><a href="#" data-toggle="tooltip"
													data-original-title="Open Folder" data-placement="right"
													 style="color: #E2B185;">
														<i class="fa fa-folder-open"></i>
												</a>&nbsp; Kaluram/My Documents</td>
												<td>2</td>
												<td>0</td>
												<td>Kaluram Chakrawrti</td>
												<td>28-12-2015</td>
												<td><a class="btn btn-metis-4 btn-xs btn-line" href="#">Registered</a></td>

												<td><a href="properties.action" data-toggle="tooltip"
													data-original-title="Properties" data-placement="bottom"
													class="btn btn-metis-5 btn-xs"> <i class="fa fa-tasks "></i>
												</a> <a href="download.action" data-toggle="tooltip"
													data-original-title="Download" data-placement="bottom"
													class="btn btn-metis-3 btn-xs"> <i
														class="fa fa-download "></i>

												</a> <a href="preview.acion" data-toggle="tooltip"
													data-original-title="Priview" data-placement="bottom"
													class="btn btn-metis-4 btn-xs"> <i class="fa fa-eye"></i>
												</a></td>

											</tr>
											<tr>
												<td><a href="#" data-toggle="tooltip"
													data-original-title="Open Folder" data-placement="right"
													 style="color: #E2B185;">
														<i class="fa fa-folder "></i>
												</a>&nbsp; Kaluram/My Documents</td>
												<td>2</td>
												<td>0</td>
												<td>Kaluram Chakrawrti</td>
												<td>28-12-2015</td>
												<td><a class="btn btn-warning btn-xs btn-line" href="#">Pending</a></td>

												<td><a href="properties.action" data-toggle="tooltip"
													data-original-title="Properties" data-placement="bottom"
													class="btn btn-metis-5 btn-xs"> <i class="fa fa-tasks "></i>
												</a> <a href="download.action" data-toggle="tooltip"
													data-original-title="Download" data-placement="bottom"
													class="btn btn-metis-3 btn-xs"> <i
														class="fa fa-download "></i>

												</a> <a href="preview.acion" data-toggle="tooltip"
													data-original-title="Priview" data-placement="bottom"
													class="btn btn-metis-4 btn-xs"> <i class="fa fa-eye"></i>
												</a></td>

											</tr>
											<tr>
												<td><a href="#" data-toggle="tooltip"
													data-original-title="Open Folder" data-placement="right"
													 style="color: #E2B185;">
														<i class="fa fa-folder "></i>
												</a>&nbsp; Kaluram/My Documents</td>
												<td>2</td>
												<td>0</td>
												<td>Kaluram Chakrawrti</td>
												<td>28-12-2015</td>
												<td><a class="btn btn-metis-6 btn-xs btn-line" href="#">Approved</a></td>

												<td><a href="properties.action" data-toggle="tooltip"
													data-original-title="Properties" data-placement="bottom"
													class="btn btn-metis-5 btn-xs"> <i class="fa fa-tasks "></i>
												</a> <a href="download.action" data-toggle="tooltip"
													data-original-title="Download" data-placement="bottom"
													class="btn btn-metis-3 btn-xs"> <i
														class="fa fa-download "></i>

												</a> <a href="preview.acion" data-toggle="tooltip"
													data-original-title="Priview" data-placement="bottom"
													class="btn btn-metis-4 btn-xs"> <i class="fa fa-eye"></i>
												</a></td>

											</tr>
											<tr>
												<td><a href="#" data-toggle="tooltip"
													data-original-title="Open Folder" data-placement="right"
													 style="color: #E2B185;">
														<i class="fa fa-folder "></i>
												</a>&nbsp; Kaluram/My Documents</td>
												<td>2</td>
												<td>0</td>
												<td>Kaluram Chakrawrti</td>
												<td>28-12-2015</td>
												<td><a class="btn btn-metis-6 btn-xs btn-line" href="#">Rejected</a></td>

												<td><a href="properties.action" data-toggle="tooltip"
													data-original-title="Properties" data-placement="bottom"
													class="btn btn-metis-5 btn-xs"> <i class="fa fa-tasks "></i>
												</a> <a href="download.action" data-toggle="tooltip"
													data-original-title="Download" data-placement="bottom"
													class="btn btn-metis-3 btn-xs"> <i
														class="fa fa-download "></i>

												</a> <a href="preview.acion" data-toggle="tooltip"
													data-original-title="Priview" data-placement="bottom"
													class="btn btn-metis-4 btn-xs"> <i class="fa fa-eye"></i>
												</a></td>

											</tr>
											<tr>
												<td><a href="#" data-toggle="tooltip"
													data-original-title="Open Folder" data-placement="right"
													 style="color: #E2B185;">
														<i class="fa fa-folder "></i>
												</a>&nbsp; Kaluram/My Documents</td>
												<td>2</td>
												<td>0</td>
												<td>Kaluram Chakrawrti</td>
												<td>28-12-2015</td>
												<td><a class="btn btn-metis-2 btn-xs btn-line" href="#">In-progress</a></td>

												<td><a href="properties.action" data-toggle="tooltip"
													data-original-title="Properties" data-placement="bottom"
													class="btn btn-metis-5 btn-xs"> <i class="fa fa-tasks "></i>
												</a> <a href="download.action" data-toggle="tooltip"
													data-original-title="Download" data-placement="bottom"
													class="btn btn-metis-3 btn-xs"> <i
														class="fa fa-download "></i>

												</a> <a href="preview.acion" data-toggle="tooltip"
													data-original-title="Priview" data-placement="bottom"
													class="btn btn-metis-4 btn-xs"> <i class="fa fa-eye"></i>
												</a></td>
											</tr>
											<tr>
												<td><a href="#" data-toggle="tooltip"
													data-original-title="Open Folder" data-placement="right"
													 style="color: #E2B185;">
														<i class="fa fa-folder-open"></i>
												</a>&nbsp; Kaluram/My Documents</td>
												<td>2</td>
												<td>0</td>
												<td>Kaluram Chakrawrti</td>
												<td>28-12-2015</td>
												<td><a class="btn btn-metis-5 btn-xs btn-line" href="#">Review</a></td>

												<td><a href="properties.action" data-toggle="tooltip"
													data-original-title="Properties" data-placement="bottom"
													class="btn btn-metis-5 btn-xs"> <i class="fa fa-tasks "></i>
												</a> <a href="download.action" data-toggle="tooltip"
													data-original-title="Download" data-placement="bottom"
													class="btn btn-metis-3 btn-xs"> <i
														class="fa fa-download "></i>

												</a> <a href="preview.acion" data-toggle="tooltip"
													data-original-title="Priview" data-placement="bottom"
													class="btn btn-metis-4 btn-xs"> <i class="fa fa-eye"></i>
												</a></td>

											</tr>
											<tr>
												<td><a href="#" data-toggle="tooltip"
													data-original-title="Open Folder" data-placement="right"
													 style="color: #E2B185;">
														<i class="fa fa-folder-open"></i>
												</a>&nbsp; Kaluram/My Documents</td>
												<td>2</td>
												<td>0</td>
												<td>Kaluram Chakrawrti</td>
												<td>28-12-2015</td>
												<td><a class="btn btn-info btn-xs btn-line" href="#">Active</a></td>

												<td><a href="properties.action" data-toggle="tooltip"
													data-original-title="Properties" data-placement="bottom"
													class="btn btn-metis-5 btn-xs"> <i class="fa fa-tasks "></i>
												</a> <a href="download.action" data-toggle="tooltip"
													data-original-title="Download" data-placement="bottom"
													class="btn btn-metis-3 btn-xs"> <i
														class="fa fa-download "></i>

												</a> <a href="preview.acion" data-toggle="tooltip"
													data-original-title="Priview" data-placement="bottom"
													class="btn btn-metis-4 btn-xs"> <i class="fa fa-eye"></i>
												</a></td>

											</tr>
											<tr>
												<td><a href="#" data-toggle="tooltip"
													data-original-title="Open Folder" data-placement="right"
													 style="color: #E2B185;">
														<i class="fa fa-folder-open"></i>
												</a>&nbsp; Kaluram/My Documents</td>
												<td>2</td>
												<td>0</td>
												<td>Kaluram Chakrawrti</td>
												<td>28-12-2015</td>
												<td><a class="btn btn-success btn-xs btn-line" href="#">Completed</a></td>

												<td><a href="properties.action" data-toggle="tooltip"
													data-original-title="Properties" data-placement="bottom"
													class="btn btn-metis-5 btn-xs"> <i class="fa fa-tasks "></i>
												</a> <a href="download.action" data-toggle="tooltip"
													data-original-title="Download" data-placement="bottom"
													class="btn btn-metis-3 btn-xs"> <i
														class="fa fa-download "></i>

												</a> <a href="preview.acion" data-toggle="tooltip"
													data-original-title="Priview" data-placement="bottom"
													class="btn btn-metis-4 btn-xs"> <i class="fa fa-eye"></i>
												</a></td>

											</tr>
											<tr>
												<td><a href="#" data-toggle="tooltip"
													data-original-title="Open Folder" data-placement="right"
													 style="color: #E2B185;">
														<i class="fa fa-folder-open"></i>
												</a>&nbsp; Kaluram/My Documents</td>
												<td>2</td>
												<td>0</td>
												<td>Kaluram Chakrawrti</td>
												<td>28-12-2015</td>
												<td><a class="btn btn-primary btn-xs btn-line" href="#">Reopen</a></td>

												<td><a href="properties.action" data-toggle="tooltip"
													data-original-title="Properties" data-placement="bottom"
													class="btn btn-metis-5 btn-xs"> <i class="fa fa-tasks "></i>
												</a> <a href="download.action" data-toggle="tooltip"
													data-original-title="Download" data-placement="bottom"
													class="btn btn-metis-3 btn-xs"> <i
														class="fa fa-download "></i>

												</a> <a href="preview.acion" data-toggle="tooltip"
													data-original-title="Priview" data-placement="bottom"
													class="btn btn-metis-4 btn-xs"> <i class="fa fa-eye"></i>
												</a></td>

											</tr>

											<tr>
												<td><a href="#" data-toggle="tooltip"
													data-original-title="Open Folder" data-placement="right"
													 style="color: #E2B185;">
														<i class="fa fa-folder-open"></i>
												</a>&nbsp; Kaluram/My Documents</td>
												<td>2</td>
												<td>0</td>
												<td>Kaluram Chakrawrti</td>
												<td>28-12-2015</td>
												<td><a class="btn btn-metis-1 btn-xs btn-line" href="#">Suspend</a></td>

												<td><a href="properties.action" data-toggle="tooltip"
													data-original-title="Properties" data-placement="bottom"
													class="btn btn-metis-5 btn-xs"> <i class="fa fa-tasks "></i>
												</a> <a href="download.action" data-toggle="tooltip"
													data-original-title="Download" data-placement="bottom"
													class="btn btn-metis-3 btn-xs"> <i
														class="fa fa-download "></i>

												</a> <a href="preview.acion" data-toggle="tooltip"
													data-original-title="Priview" data-placement="bottom"
													class="btn btn-metis-4 btn-xs"> <i class="fa fa-eye"></i>
												</a></td>

											</tr>
											<tr>
												<td><a href="#" data-toggle="tooltip"
													data-original-title="Open Folder" data-placement="right"
													 style="color: #E2B185;">
														<i class="fa fa-folder-open"></i>
												</a>&nbsp; Kaluram/My Documents</td>
												<td>2</td>
												<td>0</td>
												<td>Kaluram Chakrawrti</td>
												<td>28-12-2015</td>
												<td><a class="btn btn-metis-1 btn-xs btn-line" href="#">Blocked</a></td>

												<td><a href="properties.action" data-toggle="tooltip"
													data-original-title="Properties" data-placement="bottom"
													class="btn btn-metis-5 btn-xs"> <i class="fa fa-tasks "></i>
												</a> <a href="download.action" data-toggle="tooltip"
													data-original-title="Download" data-placement="bottom"
													class="btn btn-metis-3 btn-xs"> <i
														class="fa fa-download "></i>

												</a> <a href="preview.acion" data-toggle="tooltip"
													data-original-title="Priview" data-placement="bottom"
													class="btn btn-metis-4 btn-xs"> <i class="fa fa-eye"></i>
												</a></td>

											</tr>

											<tr>
												<td><a href="#" data-toggle="tooltip"
													data-original-title="Open Folder" data-placement="right"
													 style="color: #E2B185;">
														<i class="fa fa-folder-open"></i>
												</a>&nbsp; Kaluram/My Documents</td>
												<td>2</td>
												<td>0</td>
												<td>Kaluram Chakrawrti</td>
												<td>28-12-2015</td>
												<td><a class="btn btn-danger btn-xs btn-line" href="#">Closed</a></td>

												<td><a href="properties.action" data-toggle="tooltip"
													data-original-title="Properties" data-placement="bottom"
													class="btn btn-metis-5 btn-xs"> <i class="fa fa-tasks "></i>
												</a> <a href="download.action" data-toggle="tooltip"
													data-original-title="Download" data-placement="bottom"
													class="btn btn-metis-3 btn-xs"> <i
														class="fa fa-download "></i>

												</a> <a href="preview.acion" data-toggle="tooltip"
													data-original-title="Priview" data-placement="bottom"
													class="btn btn-metis-4 btn-xs"> <i class="fa fa-eye"></i>
												</a></td>
											</tr>
											<tr>
												<td><a href="#" data-toggle="tooltip"
													data-original-title="Open Folder" data-placement="right"
													 style="color: #E2B185;">
														<i class="fa fa-folder-open"></i>
												</a>&nbsp; Kaluram/My Documents</td>
												<td>2</td>
												<td>0</td>
												<td>Kaluram Chakrawrti</td>
												<td>28-12-2015</td>
												<td><a class="btn btn-danger btn-xs btn-line" href="#">Deleted</a></td>

												<td><a href="properties.action" data-toggle="tooltip"
													data-original-title="Properties" data-placement="bottom"
													class="btn btn-metis-5 btn-xs"> <i class="fa fa-tasks "></i>
												</a> <a href="download.action" data-toggle="tooltip"
													data-original-title="Download" data-placement="bottom"
													class="btn btn-metis-3 btn-xs"> <i
														class="fa fa-download "></i>

												</a> <a href="preview.acion" data-toggle="tooltip"
													data-original-title="Priview" data-placement="bottom"
													class="btn btn-metis-4 btn-xs"> <i class="fa fa-eye"></i>
												</a></td>

											</tr>



										</tbody>
									</table>
								</div>
							</div>

						</div>
					</div>

				</div>
			</div>
			<!-- /.inner -->
		</div>
	</div>

	<div class="modal fade" id="uploadDocument" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content scroll">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Upload Documents</h4>
				</div>
				<s:form action="uploadFile.action" method="post"
					enctype="multipart/form-data">
					<div class="modal-body">
						<div class="alert alert-info" role="alert">Information Bar
							For Upload Documents</div>
						<div class="row">
							<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
								<s:file name="fileUpload" size="40" onblur="isFileNameSame()"
									id="fileUpload" />
								<s:file name="fileUpload" size="40" />
								<s:file name="fileUpload" size="40" />
								<s:file name="fileUpload" size="40" />
								<s:file name="fileUpload" size="40" />

							</div>
							<div class="col-6" id="server1Response"></div>
						</div>

					</div>
					<div class="modal-footer">
						<button type="submit" class="btn btn-default" data-dismiss="modal">Cancle</button>
						<button type="submit" class="btn btn-primary">Upload Files</button>
					</div>
				</s:form>

			</div>
		</div>
	</div>


	<script src="pages/inner/assets/lib/datatables/jquery.dataTables.js"></script>
	<script
		src="pages/inner/assets/lib/datatables/3/dataTables.bootstrap.js"></script>
	<script
		src="pages/inner/assets/lib/jquery.tablesorter/jquery.tablesorter.min.js"></script>
	<script
		src="pages/inner/assets/lib/jquery-ui-touch-punch/jquery.ui.touch-punch.min.js"></script>
	<script>
		$(function() {
			Metis.MetisTable();
			Metis.metisSortable();
		});
	</script>
</body>
</html>
