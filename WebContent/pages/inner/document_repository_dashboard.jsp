
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

								<h5>Document Dashboard</h5>

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
													<a href="login.html" data-toggle="tooltip"
														data-original-title="Refresh" data-placement="bottom"
														class="btn btn-metis-2 btn-line"> <i
														class="fa fa-refresh "></i>

													</a> <a href="login.html" data-toggle="tooltip"
														data-original-title="Setting" data-placement="bottom"
														class="btn btn-metis-1 btn-line"> <i
														class="fa fa-gear "></i>

													</a> <a href="login.html" data-toggle="tooltip"
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

												<th>File Name</th>
												<th>Folder</th>
												<th>Created By</th>
												<th>Created Date</th>
												<th>Status</th>
												<th>Action</th>

											</tr>
										</thead>
										<tbody>

											<tr>
												<td><a href="#" data-toggle="tooltip"
													data-original-title="Favourite"
													style="font-size: 15px; color: orange;"> <i
														class="fa fa-star"></i>
												</a>&nbsp;<a href="#" data-toggle="tooltip"
													data-original-title="Text"
													class="btn btn-default btn-line btn-xs"> <i
														class="fa fa-file-text"></i>
												</a>&nbsp;Dynamic web site 25 pages php fully</td>
												<td>Documents</td>
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
													data-original-title="Favourite"
													style="font-size: 15px; color: orange;"> <i
														class="fa fa-star"></i>
												</a>&nbsp;<a href="#" data-toggle="tooltip"
													data-original-title="PDF"
													class="btn btn-danger btn-line btn-xs"> <i
														class="fa fa-file-pdf-o"></i>
												</a> &nbsp;Dynamic web site 25 pages php fully</td>
												<td>Documents</td>
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
													data-original-title="Favourite"
													style="font-size: 15px; color: orange;"> <i
														class="fa fa-star"></i>
												</a>&nbsp;<a href="#" data-toggle="tooltip"
													data-original-title="XL"
													class="btn btn-success btn-line btn-xs"> <i
														class="fa fa-file-excel-o"></i>
												</a> &nbsp;Dynamic web site 25 pages php fully</td>
												<td>Documents</td>
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
													data-original-title="Favourite"
													style="font-size: 15px; color: orange;"> <i
														class="fa fa-star"></i>
												</a>&nbsp;<a href="#" data-toggle="tooltip"
													data-original-title="Archive"
													class="btn btn-warning btn-line btn-xs"> <i
														class="fa fa-file-archive-o "></i>
												</a>&nbsp; Dynamic web site 25 pages php fully</td>
												<td>Documents</td>
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
													data-original-title="Favourite"
													style="font-size: 15px; color: orange;"> <i
														class="fa fa-star"></i>
												</a>&nbsp;<a href="#" data-toggle="tooltip"
													data-original-title="Word File"
													class="btn btn-primary btn-xs"> <i
														class="fa fa-file-word-o"></i>
												</a>&nbsp;Dynamic web site 25 pages php fully</td>
												<td>Documents</td>
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
													data-original-title="Favourite"
													style="font-size: 15px; color: orange;"> <i
														class="fa fa-star"></i>
												</a><a href="#" data-toggle="tooltip"
													data-original-title="Music File"
													class="btn btn-success btn-xs"> <i
														class="fa fa-music "></i>
												</a>&nbsp;Dynamic web site 25 pages php fully</td>
												<td>Documents</td>
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
													data-original-title="Favourite"
													style="font-size: 15px; color: orange;"> <i
														class="fa fa-star"></i>
												</a><a href="#" data-toggle="tooltip"
													data-original-title="Code File"
													class="btn btn-primary btn-xs"> <i
														class="fa fa-file-code-o "></i>
												</a>&nbsp;Dynamic web site 25 pages php fully</td>
												<td>Documents</td>
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
													data-original-title="Favourite"
													style="font-size: 15px; color: orange;"> <i
														class="fa fa-star"></i>
												</a><a href="#" data-toggle="tooltip" data-original-title="Text"
													class="btn btn-default btn-line btn-xs"> <i
														class="fa fa-file-text"></i>
												</a>&nbsp;Dynamic web site 25 pages php fully</td>
												<td>Documents</td>
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
													data-original-title="Favourite"
													style="font-size: 15px; color: orange;"> <i
														class="fa fa-star"></i>
												</a><a href="#" data-toggle="tooltip" data-original-title="Text"
													class="btn btn-default btn-line btn-xs"> <i
														class="fa fa-file-text"></i>
												</a>&nbsp;Dynamic web site 25 pages php fully</td>
												<td>Documents</td>
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
													data-original-title="Favourite"
													style="font-size: 15px; color: orange;"> <i
														class="fa fa-star"></i>
												</a><a href="#" data-toggle="tooltip" data-original-title="Text"
													class="btn btn-default btn-line btn-xs"> <i
														class="fa fa-file-text"></i>
												</a>&nbsp;Dynamic web site 25 pages php fully</td>
												<td>Documents</td>
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
													data-original-title="Favourite"
													style="font-size: 15px; color: orange;"> <i
														class="fa fa-star"></i>
												</a><a href="#" data-toggle="tooltip" data-original-title="Text"
													class="btn btn-default btn-line btn-xs"> <i
														class="fa fa-file-text"></i>
												</a>&nbsp;Dynamic web site 25 pages php fully</td>
												<td>Documents</td>
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
													data-original-title="Favourite"
													style="font-size: 15px; color: orange;"> <i
														class="fa fa-star"></i>
												</a><a href="#" data-toggle="tooltip" data-original-title="Text"
													class="btn btn-default btn-line btn-xs"> <i
														class="fa fa-file-text"></i>
												</a>&nbsp;Dynamic web site 25 pages php fully</td>
												<td>Documents</td>
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
													data-original-title="Favourite"
													style="font-size: 15px; color: orange;"> <i
														class="fa fa-star"></i>
												</a><a href="#" data-toggle="tooltip" data-original-title="Text"
													class="btn btn-default btn-line btn-xs"> <i
														class="fa fa-file-text"></i>
												</a>&nbsp;Dynamic web site 25 pages php fully</td>
												<td>Documents</td>
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
													data-original-title="Favourite"
													style="font-size: 15px; color: orange;"> <i
														class="fa fa-star"></i>
												</a><a href="#" data-toggle="tooltip" data-original-title="Text"
													class="btn btn-default btn-line btn-xs"> <i
														class="fa fa-file-text"></i>
												</a>&nbsp;Dynamic web site 25 pages php fully</td>
												<td>Documents</td>
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
													data-original-title="Favourite"
													style="font-size: 15px; color: orange;"> <i
														class="fa fa-star"></i>
												</a><a href="#" data-toggle="tooltip" data-original-title="Text"
													class="btn btn-default btn-line btn-xs"> <i
														class="fa fa-file-text"></i>
												</a>&nbsp;Dynamic web site 25 pages php fully</td>
												<td><div class="dropdown">
														<a id="dLabel" data-target="#" href="http://example.com"
															data-toggle="dropdown" role="button" aria-haspopup="true"
															aria-expanded="false"
															style="color: #313131; text-decoration: none;">
															Documents <span class="caret"></span>
														</a>

														<ul class="dropdown-menu" aria-labelledby="dLabel"
															style="background-color: gray;">
															<li><a href="" style="color: #fff">Create a
																	Folder</a></li>
														</ul>
													</div></td>
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
													data-original-title="Favourite"
													style="font-size: 15px; color: orange;"> <i
														class="fa fa-star"></i>
												</a><a href="#" data-toggle="tooltip" data-original-title="Text"
													class="btn btn-default btn-line btn-xs"> <i
														class="fa fa-file-text"></i>
												</a>&nbsp;Dynamic web site 25 pages php fully</td>
												<td></td>
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
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Upload Document</h4>
				</div>
				<form action="uploadFile.action" method="post"
					enctype="multipart/form-data">
					<div class="modal-body">
						<div class="alert alert-info" role="alert">Information Bar
							For Upload Document</div>
						<div class="row">
							<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
								<input type="file" name="uploadFile" size="30" />
							</div>

						</div>

					</div>
					<div class="modal-footer">						
						<button type="submit" class="btn btn-default" data-dismiss="modal">Cancle</button>
						<button type="submit" class="btn btn-primary">Upload File</button>
					</div>
				</form>
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
