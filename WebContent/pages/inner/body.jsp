
<body>
	<div id="content">
		<div class="outer">
			<div class="inner bg-light lter">
				<!--BEGIN INPUT TEXT FIELDS-->
				<div class="row">
					<div class="col-lg-6">
						<div class="box dark">
							<header>
								<div class="icons">
									<i class="fa fa-edit"></i>
								</div>
								<h5>Input Text Fields</h5>

								<!-- .toolbar -->
								<div class="toolbar">
									<nav style="padding: 8px;">
										<a href="javascript:;"
											class="btn btn-default btn-xs collapse-box"> <i
											class="fa fa-minus"></i>
										</a> <a href="javascript:;"
											class="btn btn-default btn-xs full-box"> <i
											class="fa fa-expand"></i>
										</a> <a href="javascript:;"
											class="btn btn-danger btn-xs close-box"> <i
											class="fa fa-times"></i>
										</a>
									</nav>
								</div>
								<!-- /.toolbar -->
							</header>
							<div id="div-1" class="body">
								<form class="form-horizontal">
									<div class="form-group">
										<label for="text1" class="control-label col-lg-4">Normal
											Input Field</label>
										<div class="col-lg-8">
											<input type="text" id="text1" placeholder="Email"
												class="form-control">
										</div>
									</div>
									<!-- /.form-group -->
									<div class="form-group">
										<label for="pass1" class="control-label col-lg-4">Password
											Field</label>
										<div class="col-lg-8">
											<input class="form-control" type="password" id="pass1"
												data-original-title="Please use your secure password"
												data-placement="top" />
										</div>
									</div>
									<!-- /.form-group -->
									<div class="form-group">
										<label class="control-label col-lg-4">Read only input</label>
										<div class="col-lg-8">
											<input type="text" value="read only" readonly
												class="form-control">
										</div>
									</div>
									<!-- /.form-group -->
									<div class="form-group">
										<label class="control-label col-lg-4">Disabled input</label>
										<div class="col-lg-8">
											<input type="text" value="disabled" disabled
												class="form-control">
										</div>
									</div>
									<!-- /.form-group -->
									<div class="form-group">
										<label for="text2" class="control-label col-lg-4">With
											Placeholder</label>
										<div class="col-lg-8">
											<input type="text" id="text2" placeholder="placeholder text"
												class="form-control">
										</div>
									</div>
									<!-- /.form-group -->
									<div class="form-group">
										<label for="limiter" class="control-label col-lg-4">Input
											limiter</label>
										<div class="col-lg-8">
											<textarea id="limiter" class="form-control"></textarea>
										</div>
									</div>
									<!-- /.row -->
									<div class="form-group">
										<label for="text4" class="control-label col-lg-4">Default
											Textarea</label>
										<div class="col-lg-8">
											<textarea id="text4" class="form-control"></textarea>
										</div>
									</div>
									<!-- /.form-group -->
									<div class="form-group">
										<label for="autosize" class="control-label col-lg-4">Textarea
											With Autosize</label>
										<div class="col-lg-8">
											<textarea id="autosize" class="form-control"></textarea>
										</div>
									</div>
									<!-- /.form-group -->
									<div class="form-group">
										<label for="tags" class="control-label col-lg-4">Tags</label>
										<div class="col-lg-8">
											<input name="tags" id="tags" value="foo,bar,baz"
												class="form-control">
										</div>
									</div>
									<!-- /.form-group -->
								</form>
							</div>
						</div>
					</div>

					<!--END TEXT INPUT FIELD-->

					<!--BEGIN SELECT        -->
					<div class="col-lg-6">
						<div class="box inverse">
							<header>
								<div class="icons">
									<i class="fa fa-th-large"></i>
								</div>
								<h5>Selects</h5>

								<!-- .toolbar -->
								<div class="toolbar">
									<nav style="padding: 8px;">
										<a href="javascript:;"
											class="btn btn-default btn-xs collapse-box"> <i
											class="fa fa-minus"></i>
										</a> <a href="javascript:;"
											class="btn btn-default btn-xs full-box"> <i
											class="fa fa-expand"></i>
										</a> <a href="javascript:;"
											class="btn btn-danger btn-xs close-box"> <i
											class="fa fa-times"></i>
										</a>
									</nav>
								</div>
								<!-- /.toolbar -->
							</header>
							<div id="div-2" class="body">
								<form class="form-horizontal">
									<div class="form-group">
										<label class="control-label col-lg-4">Select Dropdown</label>
										<div class="col-lg-8">
											<select class="form-control">
												<option>1</option>
												<option>2</option>
												<option>3</option>
												<option>4</option>
												<option>5</option>
											</select>
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-lg-4">Select with
											search</label>
										<div class="col-lg-8">
											<select data-placeholder="Choose a Country..."
												class="form-control chzn-select" tabindex="2">
												<option value=""></option>
												<option value="United States">United States</option>
												<option value="United Kingdom">United Kingdom</option>
												<option value="Afghanistan">Afghanistan</option>
												<option value="Albania">Albania</option>
												<option value="Algeria">Algeria</option>
												<option value="American Samoa">American Samoa</option>
												<option value="Andorra">Andorra</option>
												<option value="Angola">Angola</option>
												<option value="Anguilla">Anguilla</option>
												<option value="Antarctica">Antarctica</option>
												<option value="Antigua and Barbuda">Antigua and
													Barbuda</option>
												<option value="Argentina">Argentina</option>
												<option value="Armenia">Armenia</option>
												<option value="Aruba">Aruba</option>
												<option value="Australia">Australia</option>
												<option value="Austria">Austria</option>
												<option value="Azerbaijan">Azerbaijan</option>
												<option value="Bahamas">Bahamas</option>
												<option value="Bahrain">Bahrain</option>
												<option value="Bangladesh">Bangladesh</option>
												<option value="Barbados">Barbados</option>
												<option value="Belarus">Belarus</option>
												<option value="Belgium">Belgium</option>
												<option value="Belize">Belize</option>
												<option value="Benin">Benin</option>
												<option value="Bermuda">Bermuda</option>
												<option value="Bhutan">Bhutan</option>
												<option value="Bolivia">Bolivia</option>
												<option value="Bosnia and Herzegovina">Bosnia and
													Herzegovina</option>
												<option value="Botswana">Botswana</option>
												<option value="Bouvet Island">Bouvet Island</option>
												<option value="Brazil">Brazil</option>
												<option value="British Indian Ocean Territory">British
													Indian Ocean Territory</option>
												<option value="Brunei Darussalam">Brunei Darussalam</option>
												<option value="Bulgaria">Bulgaria</option>
												<option value="Burkina Faso">Burkina Faso</option>
												<option value="Burundi">Burundi</option>
												<option value="Cambodia">Cambodia</option>
												<option value="Cameroon">Cameroon</option>
												<option value="Canada">Canada</option>
												<option value="Cape Verde">Cape Verde</option>
												<option value="Cayman Islands">Cayman Islands</option>
												<option value="Central African Republic">Central
													African Republic</option>
												<option value="Chad">Chad</option>
												<option value="Chile">Chile</option>
												<option value="China">China</option>
												<option value="Christmas Island">Christmas Island</option>
												<option value="Cocos (Keeling) Islands">Cocos
													(Keeling) Islands</option>
												<option value="Colombia">Colombia</option>
												<option value="Comoros">Comoros</option>
												<option value="Congo">Congo</option>
												<option value="Congo, The Democratic Republic of The">Congo,
													The Democratic Republic of The</option>
												<option value="Cook Islands">Cook Islands</option>
												<option value="Costa Rica">Costa Rica</option>
												<option value="Cote D'ivoire">Cote D'ivoire</option>
												<option value="Croatia">Croatia</option>
												<option value="Cuba">Cuba</option>
												<option value="Cyprus">Cyprus</option>
												<option value="Czech Republic">Czech Republic</option>
												<option value="Denmark">Denmark</option>
												<option value="Djibouti">Djibouti</option>
												<option value="Dominica">Dominica</option>
												<option value="Dominican Republic">Dominican
													Republic</option>
												<option value="Ecuador">Ecuador</option>
												<option value="Egypt">Egypt</option>
												<option value="El Salvador">El Salvador</option>
												<option value="Equatorial Guinea">Equatorial Guinea</option>
												<option value="Eritrea">Eritrea</option>
												<option value="Estonia">Estonia</option>
												<option value="Ethiopia">Ethiopia</option>
												<option value="Falkland Islands (Malvinas)">Falkland
													Islands (Malvinas)</option>
												<option value="Faroe Islands">Faroe Islands</option>
												<option value="Fiji">Fiji</option>
												<option value="Finland">Finland</option>
												<option value="France">France</option>
												<option value="French Guiana">French Guiana</option>
												<option value="French Polynesia">French Polynesia</option>
												<option value="French Southern Territories">French
													Southern Territories</option>
												<option value="Gabon">Gabon</option>
												<option value="Gambia">Gambia</option>
												<option value="Georgia">Georgia</option>
												<option value="Germany">Germany</option>
												<option value="Ghana">Ghana</option>
												<option value="Gibraltar">Gibraltar</option>
												<option value="Greece">Greece</option>
												<option value="Greenland">Greenland</option>
												<option value="Grenada">Grenada</option>
												<option value="Guadeloupe">Guadeloupe</option>
												<option value="Guam">Guam</option>
												<option value="Guatemala">Guatemala</option>
												<option value="Guinea">Guinea</option>
												<option value="Guinea-bissau">Guinea-bissau</option>
												<option value="Guyana">Guyana</option>
												<option value="Haiti">Haiti</option>
												<option value="Heard Island and Mcdonald Islands">Heard
													Island and Mcdonald Islands</option>
												<option value="Holy See (Vatican City State)">Holy
													See (Vatican City State)</option>
												<option value="Honduras">Honduras</option>
												<option value="Hong Kong">Hong Kong</option>
												<option value="Hungary">Hungary</option>
												<option value="Iceland">Iceland</option>
												<option value="India">India</option>
												<option value="Indonesia">Indonesia</option>
												<option value="Iran, Islamic Republic of">Iran,
													Islamic Republic of</option>
												<option value="Iraq">Iraq</option>
												<option value="Ireland">Ireland</option>
												<option value="Israel">Israel</option>
												<option value="Italy">Italy</option>
												<option value="Jamaica">Jamaica</option>
												<option value="Japan">Japan</option>
												<option value="Jordan">Jordan</option>
												<option value="Kazakhstan">Kazakhstan</option>
												<option value="Kenya">Kenya</option>
												<option value="Kiribati">Kiribati</option>
												<option value="Korea, Democratic People's Republic of">Korea,
													Democratic People's Republic of</option>
												<option value="Korea, Republic of">Korea, Republic
													of</option>
												<option value="Kuwait">Kuwait</option>
												<option value="Kyrgyzstan">Kyrgyzstan</option>
												<option value="Lao People's Democratic Republic">Lao
													People's Democratic Republic</option>
												<option value="Latvia">Latvia</option>
												<option value="Lebanon">Lebanon</option>
												<option value="Lesotho">Lesotho</option>
												<option value="Liberia">Liberia</option>
												<option value="Libyan Arab Jamahiriya">Libyan Arab
													Jamahiriya</option>
												<option value="Liechtenstein">Liechtenstein</option>
												<option value="Lithuania">Lithuania</option>
												<option value="Luxembourg">Luxembourg</option>
												<option value="Macao">Macao</option>
												<option value="Macedonia, The Former Yugoslav Republic of">Macedonia,
													The Former Yugoslav Republic of</option>
												<option value="Madagascar">Madagascar</option>
												<option value="Malawi">Malawi</option>
												<option value="Malaysia">Malaysia</option>
												<option value="Maldives">Maldives</option>
												<option value="Mali">Mali</option>
												<option value="Malta">Malta</option>
												<option value="Marshall Islands">Marshall Islands</option>
												<option value="Martinique">Martinique</option>
												<option value="Mauritania">Mauritania</option>
												<option value="Mauritius">Mauritius</option>
												<option value="Mayotte">Mayotte</option>
												<option value="Mexico">Mexico</option>
												<option value="Micronesia, Federated States of">Micronesia,
													Federated States of</option>
												<option value="Moldova, Republic of">Moldova,
													Republic of</option>
												<option value="Monaco">Monaco</option>
												<option value="Mongolia">Mongolia</option>
												<option value="Montenegro">Montenegro</option>
												<option value="Montserrat">Montserrat</option>
												<option value="Morocco">Morocco</option>
												<option value="Mozambique">Mozambique</option>
												<option value="Myanmar">Myanmar</option>
												<option value="Namibia">Namibia</option>
												<option value="Nauru">Nauru</option>
												<option value="Nepal">Nepal</option>
												<option value="Netherlands">Netherlands</option>
												<option value="Netherlands Antilles">Netherlands
													Antilles</option>
												<option value="New Caledonia">New Caledonia</option>
												<option value="New Zealand">New Zealand</option>
												<option value="Nicaragua">Nicaragua</option>
												<option value="Niger">Niger</option>
												<option value="Nigeria">Nigeria</option>
												<option value="Niue">Niue</option>
												<option value="Norfolk Island">Norfolk Island</option>
												<option value="Northern Mariana Islands">Northern
													Mariana Islands</option>
												<option value="Norway">Norway</option>
												<option value="Oman">Oman</option>
												<option value="Pakistan">Pakistan</option>
												<option value="Palau">Palau</option>
												<option value="Palestinian Territory, Occupied">Palestinian
													Territory, Occupied</option>
												<option value="Panama">Panama</option>
												<option value="Papua New Guinea">Papua New Guinea</option>
												<option value="Paraguay">Paraguay</option>
												<option value="Peru">Peru</option>
												<option value="Philippines">Philippines</option>
												<option value="Pitcairn">Pitcairn</option>
												<option value="Poland">Poland</option>
												<option value="Portugal">Portugal</option>
												<option value="Puerto Rico">Puerto Rico</option>
												<option value="Qatar">Qatar</option>
												<option value="Reunion">Reunion</option>
												<option value="Romania">Romania</option>
												<option value="Russian Federation">Russian
													Federation</option>
												<option value="Rwanda">Rwanda</option>
												<option value="Saint Helena">Saint Helena</option>
												<option value="Saint Kitts and Nevis">Saint Kitts
													and Nevis</option>
												<option value="Saint Lucia">Saint Lucia</option>
												<option value="Saint Pierre and Miquelon">Saint
													Pierre and Miquelon</option>
												<option value="Saint Vincent and The Grenadines">Saint
													Vincent and The Grenadines</option>
												<option value="Samoa">Samoa</option>
												<option value="San Marino">San Marino</option>
												<option value="Sao Tome and Principe">Sao Tome and
													Principe</option>
												<option value="Saudi Arabia">Saudi Arabia</option>
												<option value="Senegal">Senegal</option>
												<option value="Serbia">Serbia</option>
												<option value="Seychelles">Seychelles</option>
												<option value="Sierra Leone">Sierra Leone</option>
												<option value="Singapore">Singapore</option>
												<option value="Slovakia">Slovakia</option>
												<option value="Slovenia">Slovenia</option>
												<option value="Solomon Islands">Solomon Islands</option>
												<option value="Somalia">Somalia</option>
												<option value="South Africa">South Africa</option>
												<option value="South Georgia and The South Sandwich Islands">South
													Georgia and The South Sandwich Islands</option>
												<option value="South Sudan">South Sudan</option>
												<option value="Spain">Spain</option>
												<option value="Sri Lanka">Sri Lanka</option>
												<option value="Sudan">Sudan</option>
												<option value="Suriname">Suriname</option>
												<option value="Svalbard and Jan Mayen">Svalbard and
													Jan Mayen</option>
												<option value="Swaziland">Swaziland</option>
												<option value="Sweden">Sweden</option>
												<option value="Switzerland">Switzerland</option>
												<option value="Syrian Arab Republic">Syrian Arab
													Republic</option>
												<option value="Taiwan, Republic of China">Taiwan,
													Republic of China</option>
												<option value="Tajikistan">Tajikistan</option>
												<option value="Tanzania, United Republic of">Tanzania,
													United Republic of</option>
												<option value="Thailand">Thailand</option>
												<option value="Timor-leste">Timor-leste</option>
												<option value="Togo">Togo</option>
												<option value="Tokelau">Tokelau</option>
												<option value="Tonga">Tonga</option>
												<option value="Trinidad and Tobago">Trinidad and
													Tobago</option>
												<option value="Tunisia">Tunisia</option>
												<option value="Turkey">Turkey</option>
												<option value="Turkmenistan">Turkmenistan</option>
												<option value="Turks and Caicos Islands">Turks and
													Caicos Islands</option>
												<option value="Tuvalu">Tuvalu</option>
												<option value="Uganda">Uganda</option>
												<option value="Ukraine">Ukraine</option>
												<option value="United Arab Emirates">United Arab
													Emirates</option>
												<option value="United Kingdom">United Kingdom</option>
												<option value="United States">United States</option>
												<option value="United States Minor Outlying Islands">United
													States Minor Outlying Islands</option>
												<option value="Uruguay">Uruguay</option>
												<option value="Uzbekistan">Uzbekistan</option>
												<option value="Vanuatu">Vanuatu</option>
												<option value="Venezuela">Venezuela</option>
												<option value="Viet Nam">Viet Nam</option>
												<option value="Virgin Islands, British">Virgin
													Islands, British</option>
												<option value="Virgin Islands, U.S.">Virgin
													Islands, U.S.</option>
												<option value="Wallis and Futuna">Wallis and Futuna</option>
												<option value="Western Sahara">Western Sahara</option>
												<option value="Yemen">Yemen</option>
												<option value="Zambia">Zambia</option>
												<option value="Zimbabwe">Zimbabwe</option>
											</select>
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-lg-4">Multiple select</label>
										<div class="col-lg-8">
											<select multiple="multiple" size="5" class="form-control">
												<option selected>1</option>
												<option selected>2</option>
												<option>3</option>
												<option selected>4</option>
												<option>5</option>
											</select>
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-lg-4">Multiple with
											search</label>
										<div class="col-lg-8">
											<select data-placeholder="Choose a Country..."
												class="form-control chzn-select" multiple tabindex="4">
												<option value=""></option>
												<option value="United States">United States</option>
												<option value="United Kingdom">United Kingdom</option>
												<option value="Afghanistan">Afghanistan</option>
												<option value="Albania">Albania</option>
												<option value="Algeria">Algeria</option>
												<option value="American Samoa">American Samoa</option>
												<option value="Andorra">Andorra</option>
												<option value="Angola">Angola</option>
												<option value="Anguilla">Anguilla</option>
												<option value="Antarctica">Antarctica</option>
												<option value="Antigua and Barbuda">Antigua and
													Barbuda</option>
												<option value="Argentina">Argentina</option>
												<option value="Armenia">Armenia</option>
												<option value="Aruba">Aruba</option>
												<option value="Australia">Australia</option>
												<option value="Austria">Austria</option>
												<option value="Azerbaijan">Azerbaijan</option>
												<option value="Bahamas">Bahamas</option>
												<option value="Bahrain">Bahrain</option>
												<option value="Bangladesh">Bangladesh</option>
												<option value="Barbados">Barbados</option>
												<option value="Belarus">Belarus</option>
												<option value="Belgium">Belgium</option>
												<option value="Belize">Belize</option>
												<option value="Benin">Benin</option>
												<option value="Bermuda">Bermuda</option>
												<option value="Bhutan">Bhutan</option>
												<option value="Bolivia">Bolivia</option>
												<option value="Bosnia and Herzegovina">Bosnia and
													Herzegovina</option>
												<option value="Botswana">Botswana</option>
												<option value="Bouvet Island">Bouvet Island</option>
												<option value="Brazil">Brazil</option>
												<option value="British Indian Ocean Territory">British
													Indian Ocean Territory</option>
												<option value="Brunei Darussalam">Brunei Darussalam</option>
												<option value="Bulgaria">Bulgaria</option>
												<option value="Burkina Faso">Burkina Faso</option>
												<option value="Burundi">Burundi</option>
												<option value="Cambodia">Cambodia</option>
												<option value="Cameroon">Cameroon</option>
												<option value="Canada">Canada</option>
												<option value="Cape Verde">Cape Verde</option>
												<option value="Cayman Islands">Cayman Islands</option>
												<option value="Central African Republic">Central
													African Republic</option>
												<option value="Chad">Chad</option>
												<option value="Chile">Chile</option>
												<option value="China">China</option>
												<option value="Christmas Island">Christmas Island</option>
												<option value="Cocos (Keeling) Islands">Cocos
													(Keeling) Islands</option>
												<option value="Colombia">Colombia</option>
												<option value="Comoros">Comoros</option>
												<option value="Congo">Congo</option>
												<option value="Congo, The Democratic Republic of The">Congo,
													The Democratic Republic of The</option>
												<option value="Cook Islands">Cook Islands</option>
												<option value="Costa Rica">Costa Rica</option>
												<option value="Cote D'ivoire">Cote D'ivoire</option>
												<option value="Croatia">Croatia</option>
												<option value="Cuba">Cuba</option>
												<option value="Cyprus">Cyprus</option>
												<option value="Czech Republic">Czech Republic</option>
												<option value="Denmark">Denmark</option>
												<option value="Djibouti">Djibouti</option>
												<option value="Dominica">Dominica</option>
												<option value="Dominican Republic">Dominican
													Republic</option>
												<option value="Ecuador">Ecuador</option>
												<option value="Egypt">Egypt</option>
												<option value="El Salvador">El Salvador</option>
												<option value="Equatorial Guinea">Equatorial Guinea</option>
												<option value="Eritrea">Eritrea</option>
												<option value="Estonia">Estonia</option>
												<option value="Ethiopia">Ethiopia</option>
												<option value="Falkland Islands (Malvinas)">Falkland
													Islands (Malvinas)</option>
												<option value="Faroe Islands">Faroe Islands</option>
												<option value="Fiji">Fiji</option>
												<option value="Finland">Finland</option>
												<option value="France">France</option>
												<option value="French Guiana">French Guiana</option>
												<option value="French Polynesia">French Polynesia</option>
												<option value="French Southern Territories">French
													Southern Territories</option>
												<option value="Gabon">Gabon</option>
												<option value="Gambia">Gambia</option>
												<option value="Georgia">Georgia</option>
												<option value="Germany">Germany</option>
												<option value="Ghana">Ghana</option>
												<option value="Gibraltar">Gibraltar</option>
												<option value="Greece">Greece</option>
												<option value="Greenland">Greenland</option>
												<option value="Grenada">Grenada</option>
												<option value="Guadeloupe">Guadeloupe</option>
												<option value="Guam">Guam</option>
												<option value="Guatemala">Guatemala</option>
												<option value="Guinea">Guinea</option>
												<option value="Guinea-bissau">Guinea-bissau</option>
												<option value="Guyana">Guyana</option>
												<option value="Haiti">Haiti</option>
												<option value="Heard Island and Mcdonald Islands">Heard
													Island and Mcdonald Islands</option>
												<option value="Holy See (Vatican City State)">Holy
													See (Vatican City State)</option>
												<option value="Honduras">Honduras</option>
												<option value="Hong Kong">Hong Kong</option>
												<option value="Hungary">Hungary</option>
												<option value="Iceland">Iceland</option>
												<option value="India">India</option>
												<option value="Indonesia">Indonesia</option>
												<option value="Iran, Islamic Republic of">Iran,
													Islamic Republic of</option>
												<option value="Iraq">Iraq</option>
												<option value="Ireland">Ireland</option>
												<option value="Israel">Israel</option>
												<option value="Italy">Italy</option>
												<option value="Jamaica">Jamaica</option>
												<option value="Japan">Japan</option>
												<option value="Jordan">Jordan</option>
												<option value="Kazakhstan">Kazakhstan</option>
												<option value="Kenya">Kenya</option>
												<option value="Kiribati">Kiribati</option>
												<option value="Korea, Democratic People's Republic of">Korea,
													Democratic People's Republic of</option>
												<option value="Korea, Republic of">Korea, Republic
													of</option>
												<option value="Kuwait">Kuwait</option>
												<option value="Kyrgyzstan">Kyrgyzstan</option>
												<option value="Lao People's Democratic Republic">Lao
													People's Democratic Republic</option>
												<option value="Latvia">Latvia</option>
												<option value="Lebanon">Lebanon</option>
												<option value="Lesotho">Lesotho</option>
												<option value="Liberia">Liberia</option>
												<option value="Libyan Arab Jamahiriya">Libyan Arab
													Jamahiriya</option>
												<option value="Liechtenstein">Liechtenstein</option>
												<option value="Lithuania">Lithuania</option>
												<option value="Luxembourg">Luxembourg</option>
												<option value="Macao">Macao</option>
												<option value="Macedonia, The Former Yugoslav Republic of">Macedonia,
													The Former Yugoslav Republic of</option>
												<option value="Madagascar">Madagascar</option>
												<option value="Malawi">Malawi</option>
												<option value="Malaysia">Malaysia</option>
												<option value="Maldives">Maldives</option>
												<option value="Mali">Mali</option>
												<option value="Malta">Malta</option>
												<option value="Marshall Islands">Marshall Islands</option>
												<option value="Martinique">Martinique</option>
												<option value="Mauritania">Mauritania</option>
												<option value="Mauritius">Mauritius</option>
												<option value="Mayotte">Mayotte</option>
												<option value="Mexico">Mexico</option>
												<option value="Micronesia, Federated States of">Micronesia,
													Federated States of</option>
												<option value="Moldova, Republic of">Moldova,
													Republic of</option>
												<option value="Monaco">Monaco</option>
												<option value="Mongolia">Mongolia</option>
												<option value="Montenegro">Montenegro</option>
												<option value="Montserrat">Montserrat</option>
												<option value="Morocco">Morocco</option>
												<option value="Mozambique">Mozambique</option>
												<option value="Myanmar">Myanmar</option>
												<option value="Namibia">Namibia</option>
												<option value="Nauru">Nauru</option>
												<option value="Nepal">Nepal</option>
												<option value="Netherlands">Netherlands</option>
												<option value="Netherlands Antilles">Netherlands
													Antilles</option>
												<option value="New Caledonia">New Caledonia</option>
												<option value="New Zealand">New Zealand</option>
												<option value="Nicaragua">Nicaragua</option>
												<option value="Niger">Niger</option>
												<option value="Nigeria">Nigeria</option>
												<option value="Niue">Niue</option>
												<option value="Norfolk Island">Norfolk Island</option>
												<option value="Northern Mariana Islands">Northern
													Mariana Islands</option>
												<option value="Norway">Norway</option>
												<option value="Oman">Oman</option>
												<option value="Pakistan">Pakistan</option>
												<option value="Palau">Palau</option>
												<option value="Palestinian Territory, Occupied">Palestinian
													Territory, Occupied</option>
												<option value="Panama">Panama</option>
												<option value="Papua New Guinea">Papua New Guinea</option>
												<option value="Paraguay">Paraguay</option>
												<option value="Peru">Peru</option>
												<option value="Philippines">Philippines</option>
												<option value="Pitcairn">Pitcairn</option>
												<option value="Poland">Poland</option>
												<option value="Portugal">Portugal</option>
												<option value="Puerto Rico">Puerto Rico</option>
												<option value="Qatar">Qatar</option>
												<option value="Reunion">Reunion</option>
												<option value="Romania">Romania</option>
												<option value="Russian Federation">Russian
													Federation</option>
												<option value="Rwanda">Rwanda</option>
												<option value="Saint Helena">Saint Helena</option>
												<option value="Saint Kitts and Nevis">Saint Kitts
													and Nevis</option>
												<option value="Saint Lucia">Saint Lucia</option>
												<option value="Saint Pierre and Miquelon">Saint
													Pierre and Miquelon</option>
												<option value="Saint Vincent and The Grenadines">Saint
													Vincent and The Grenadines</option>
												<option value="Samoa">Samoa</option>
												<option value="San Marino">San Marino</option>
												<option value="Sao Tome and Principe">Sao Tome and
													Principe</option>
												<option value="Saudi Arabia">Saudi Arabia</option>
												<option value="Senegal">Senegal</option>
												<option value="Serbia">Serbia</option>
												<option value="Seychelles">Seychelles</option>
												<option value="Sierra Leone">Sierra Leone</option>
												<option value="Singapore">Singapore</option>
												<option value="Slovakia">Slovakia</option>
												<option value="Slovenia">Slovenia</option>
												<option value="Solomon Islands">Solomon Islands</option>
												<option value="Somalia">Somalia</option>
												<option value="South Africa">South Africa</option>
												<option value="South Georgia and The South Sandwich Islands">South
													Georgia and The South Sandwich Islands</option>
												<option value="South Sudan">South Sudan</option>
												<option value="Spain">Spain</option>
												<option value="Sri Lanka">Sri Lanka</option>
												<option value="Sudan">Sudan</option>
												<option value="Suriname">Suriname</option>
												<option value="Svalbard and Jan Mayen">Svalbard and
													Jan Mayen</option>
												<option value="Swaziland">Swaziland</option>
												<option value="Sweden">Sweden</option>
												<option value="Switzerland">Switzerland</option>
												<option value="Syrian Arab Republic">Syrian Arab
													Republic</option>
												<option value="Taiwan, Republic of China">Taiwan,
													Republic of China</option>
												<option value="Tajikistan">Tajikistan</option>
												<option value="Tanzania, United Republic of">Tanzania,
													United Republic of</option>
												<option value="Thailand">Thailand</option>
												<option value="Timor-leste">Timor-leste</option>
												<option value="Togo">Togo</option>
												<option value="Tokelau">Tokelau</option>
												<option value="Tonga">Tonga</option>
												<option value="Trinidad and Tobago">Trinidad and
													Tobago</option>
												<option value="Tunisia">Tunisia</option>
												<option value="Turkey">Turkey</option>
												<option value="Turkmenistan">Turkmenistan</option>
												<option value="Turks and Caicos Islands">Turks and
													Caicos Islands</option>
												<option value="Tuvalu">Tuvalu</option>
												<option value="Uganda">Uganda</option>
												<option value="Ukraine">Ukraine</option>
												<option value="United Arab Emirates">United Arab
													Emirates</option>
												<option value="United Kingdom">United Kingdom</option>
												<option value="United States">United States</option>
												<option value="United States Minor Outlying Islands">United
													States Minor Outlying Islands</option>
												<option value="Uruguay">Uruguay</option>
												<option value="Uzbekistan">Uzbekistan</option>
												<option value="Vanuatu">Vanuatu</option>
												<option value="Venezuela">Venezuela</option>
												<option value="Viet Nam">Viet Nam</option>
												<option value="Virgin Islands, British">Virgin
													Islands, British</option>
												<option value="Virgin Islands, U.S.">Virgin
													Islands, U.S.</option>
												<option value="Wallis and Futuna">Wallis and Futuna</option>
												<option value="Western Sahara">Western Sahara</option>
												<option value="Yemen">Yemen</option>
												<option value="Zambia">Zambia</option>
												<option value="Zimbabwe">Zimbabwe</option>
											</select>
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-lg-4">Single Select
											with Groups</label>
										<div class="col-lg-8">
											<select data-placeholder="Your Favorite Football Team"
												class="form-control chzn-select" tabindex="5">
												<option value=""></option>
												<optgroup label="NFC EAST">
													<option>Dallas Cowboys</option>
													<option>New York Giants</option>
													<option>Philadelphia Eagles</option>
													<option>Washington Redskins</option>
												</optgroup>
												<optgroup label="NFC NORTH">
													<option>Chicago Bears</option>
													<option>Detroit Lions</option>
													<option>Green Bay Packers</option>
													<option>Minnesota Vikings</option>
												</optgroup>
												<optgroup label="NFC SOUTH">
													<option>Atlanta Falcons</option>
													<option>Carolina Panthers</option>
													<option>New Orleans Saints</option>
													<option>Tampa Bay Buccaneers</option>
												</optgroup>
												<optgroup label="NFC WEST">
													<option>Arizona Cardinals</option>
													<option>St. Louis Rams</option>
													<option>San Francisco 49ers</option>
													<option>Seattle Seahawks</option>
												</optgroup>
												<optgroup label="AFC EAST">
													<option>Buffalo Bills</option>
													<option>Miami Dolphins</option>
													<option>New England Patriots</option>
													<option>New York Jets</option>
												</optgroup>
												<optgroup label="AFC NORTH">
													<option>Baltimore Ravens</option>
													<option>Cincinnati Bengals</option>
													<option>Cleveland Browns</option>
													<option>Pittsburgh Steelers</option>
												</optgroup>
												<optgroup label="AFC SOUTH">
													<option>Houston Texans</option>
													<option>Indianapolis Colts</option>
													<option>Jacksonville Jaguars</option>
													<option>Tennessee Titans</option>
												</optgroup>
												<optgroup label="AFC WEST">
													<option>Denver Broncos</option>
													<option>Kansas City Chiefs</option>
													<option>Oakland Raiders</option>
													<option>San Diego Chargers</option>
												</optgroup>
											</select>
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-lg-4">Multiple Select
											with Groups</label>
										<div class="col-lg-8">
											<select data-placeholder="Your Favorite Football Team"
												class="form-control chzn-select" multiple tabindex="6">
												<option value=""></option>
												<optgroup label="NFC EAST">
													<option>Dallas Cowboys</option>
													<option>New York Giants</option>
													<option>Philadelphia Eagles</option>
													<option>Washington Redskins</option>
												</optgroup>
												<optgroup label="NFC NORTH">
													<option>Chicago Bears</option>
													<option>Detroit Lions</option>
													<option>Green Bay Packers</option>
													<option>Minnesota Vikings</option>
												</optgroup>
												<optgroup label="NFC SOUTH">
													<option>Atlanta Falcons</option>
													<option>Carolina Panthers</option>
													<option>New Orleans Saints</option>
													<option>Tampa Bay Buccaneers</option>
												</optgroup>
												<optgroup label="NFC WEST">
													<option>Arizona Cardinals</option>
													<option>St. Louis Rams</option>
													<option>San Francisco 49ers</option>
													<option>Seattle Seahawks</option>
												</optgroup>
												<optgroup label="AFC EAST">
													<option>Buffalo Bills</option>
													<option>Miami Dolphins</option>
													<option>New England Patriots</option>
													<option>New York Jets</option>
												</optgroup>
												<optgroup label="AFC NORTH">
													<option>Baltimore Ravens</option>
													<option>Cincinnati Bengals</option>
													<option>Cleveland Browns</option>
													<option>Pittsburgh Steelers</option>
												</optgroup>
												<optgroup label="AFC SOUTH">
													<option>Houston Texans</option>
													<option>Indianapolis Colts</option>
													<option>Jacksonville Jaguars</option>
													<option>Tennessee Titans</option>
												</optgroup>
												<optgroup label="AFC WEST">
													<option>Denver Broncos</option>
													<option>Kansas City Chiefs</option>
													<option>Oakland Raiders</option>
													<option>San Diego Chargers</option>
												</optgroup>
											</select>
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-lg-4">Single Select</label>
										<div class="col-lg-8">
											<select data-placeholder="Your Favorite Type of Bear"
												class="form-control chzn-select" tabindex="7">
												<option value=""></option>
												<option>American Black Bear</option>
												<option>Asiatic Black Bear</option>
												<option>Brown Bear</option>
												<option>Giant Panda</option>
												<option selected>Sloth Bear</option>
												<option disabled>Sun Bear</option>
												<option>Polar Bear</option>
												<option disabled>Spectacled Bear</option>
											</select>
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-lg-4">Multiple Select</label>
										<div class="col-lg-8">
											<select data-placeholder="Your Favorite Types of Bear"
												multiple class="form-control chzn-select" tabindex="8">
												<option value=""></option>
												<option>American Black Bear</option>
												<option>Asiatic Black Bear</option>
												<option>Brown Bear</option>
												<option>Giant Panda</option>
												<option selected>Sloth Bear</option>
												<option disabled>Sun Bear</option>
												<option>Polar Bear</option>
												<option disabled>Spectacled Bear</option>
											</select>
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-lg-4">Multiple Select
											& Deselect</label>
										<div class="col-lg-8">
											<select data-placeholder="Your Favorite Types of Bear"
												multiple class="form-control chzn-select"
												id="test_me_paddington" name="test_me_form" tabindex="8">
												<option value=""></option>
												<option>American Black Bear</option>
												<option>Asiatic Black Bear</option>
												<option>Brown Bear</option>
												<option>Giant Panda</option>
												<option selected>Sloth Bear</option>
												<option disabled>Sun Bear</option>
												<option>Polar Bear</option>
												<option disabled>Spectacled Bear</option>
											</select>
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-lg-4">Allow Deselect
											on Single Selects</label>
										<div class="col-lg-8">
											<select data-placeholder="Your Favorite Type of Bear"
												class="form-control chzn-select-deselect" tabindex="7">
												<option value=""></option>
												<option>American Black Bear</option>
												<option>Asiatic Black Bear</option>
												<option>Brown Bear</option>
												<option>Giant Panda</option>
												<option selected>Sloth Bear</option>
												<option disabled>Sun Bear</option>
												<option>Polar Bear</option>
												<option disabled>Spectacled Bear</option>
											</select>
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-lg-4">Single right to
											left select</label>
										<div class="col-lg-8">
											<select data-placeholder="Your Favorite Type of Bear"
												class="form-control chzn-select chzn-rtl" tabindex="9">
												<option value=""></option>
												<option>American Black Bear</option>
												<option>Asiatic Black Bear</option>
												<option>Brown Bear</option>
												<option>Giant Panda</option>
												<option selected>Sloth Bear</option>
												<option disabled>Sun Bear</option>
												<option>Polar Bear</option>
												<option disabled>Spectacled Bear</option>
											</select>
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-lg-4">Multiple right
											to left select</label>
										<div class="col-lg-8">
											<select data-placeholder="Your Favorite Types of Bear"
												multiple class="form-control chzn-select  chzn-rtl"
												tabindex="10">
												<option value=""></option>
												<option>American Black Bear</option>
												<option>Asiatic Black Bear</option>
												<option>Brown Bear</option>
												<option>Giant Panda</option>
												<option selected>Sloth Bear</option>
												<option disabled>Sun Bear</option>
												<option>Polar Bear</option>
												<option disabled>Spectacled Bear</option>
											</select>
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-lg-4">Spinner</label>
										<div class="col-lg-8">
											<input class="form-control" type="number" value="6">
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-lg-4">Decimal Spinner</label>
										<div class="col-lg-8">
											<input class="form-control" type="number" step="0.1"
												value="2.8">
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-lg-4">Currency Spinner</label>
										<div class="col-lg-8">
											<input class="form-control" type="number" step="5" value="16">
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>

					<!--END SELECT-->
				</div>
				<!-- /.row -->

				<!-- BEGIN CHECKBOX & RADIO -->
				<div class="row">
					<div class="col-lg-6">
						<div class="box">
							<header>
								<div class="icons">
									<i class="fa fa-check"></i>
								</div>
								<h5>Checkbox & Radio</h5>
								<div class="toolbar">
									<input class="uniform" type="checkbox" checked>
								</div>
							</header>
							<div class="body">
								<form class="form-horizontal">
									<div class="form-group">
										<label class="control-label col-lg-4">Checkbox</label>
										<div class="col-lg-8">
											<div class="checkbox">
												<label> <input class="uniform" type="checkbox"
													value="option1" checked>Checked checkbox
												</label>
											</div>
											<div class="checkbox">
												<label> <input class="uniform" type="checkbox"
													value="option2">Unchecked checkbox
												</label>
											</div>
											<div class="checkbox">
												<label> <input class="uniform" type="checkbox"
													value="option3" checked disabled>Disabled checked
												</label>
											</div>
											<div class="checkbox">
												<label> <input class="uniform" type="checkbox"
													value="option2" disabled>Disabled unchecked
												</label>
											</div>
										</div>
									</div>
									<!-- /.row -->
									<div class="form-group">
										<label class="control-label col-lg-4">Radio</label>
										<div class="col-lg-8">
											<div class="checkbox">
												<label> <input class="uniform" type="radio"
													name="optionsRadios" value="option1" checked>Checked
													radio
												</label>
											</div>
											<!-- /.checkbox -->
											<div class="checkbox">
												<label> <input class="uniform" type="radio"
													name="optionsRadios" value="option2">Unchecked
													radio
												</label>
											</div>
											<!-- /.checkbox -->
											<div class="checkbox">
												<label> <input class="uniform" type="radio"
													name="optionsRadios2" value="option3" checked disabled>Disabled
													checked radio
												</label>
											</div>
											<!-- /.checkbox -->
											<div class="checkbox">
												<label> <input class="uniform" type="radio"
													name="optionsRadios2" value="option4" disabled>Disabled
													unchecked radio
												</label>
											</div>
											<!-- /.checkbox -->
										</div>
									</div>
									<!-- /.row -->
									<div class="form-group">
										<label class="control-label col-lg-4">Basic</label>
										<div class="col-lg-8">
											<input class="make-switch" type="checkbox" data-size="mini"
												checked> <br> <input class="make-switch"
												type="checkbox" data-size="small"> <br> <input
												class="make-switch" type="checkbox" data-size="normal"
												checked> <br> <input class="make-switch"
												type="checkbox" data-size="large"> <br> <input
												class="make-switch" type="checkbox" data-label-text="BS"
												checked disabled> <br> <input
												class="make-switch" type="checkbox"> <br> <input
												class="make-switch" type="checkbox" checked> <br>
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-lg-4">Color</label>
										<div class="col-lg-8">
											<input class="make-switch" type="checkbox" data-on-text="1"
												data-off-text="0" checked> <br> <input
												class="make-switch" type="checkbox" data-on-color="info"
												data-off-color="success"> <br> <input
												class="make-switch" type="checkbox" data-on-text="osman"
												data-off-text="nuri" checked> <br> <input
												class="make-switch" type="checkbox" data-on-color="warning"
												data-off-color="danger"> <br> <input
												class="make-switch" type="checkbox" data-on-text="TRUE"
												data-off-text="FALSE" checked> <br> <input
												class="make-switch" type="checkbox" data-on-color="default"
												data-off-color="primary"> <br>
										</div>
									</div>
									<!-- /.row -->
									<!-- /.row -->
								</form>
							</div>
						</div>
					</div>
					<div class="col-lg-6">
						<h3>
							Animated Checkbox <small>Thanks http://thecodeplayer.com/</small>
						</h3>
						<div class="checkbox anim-checkbox">
							<input type="checkbox" id="ch1"> <label for="ch1">Default</label>
						</div>
						<div class="checkbox anim-checkbox">
							<input type="checkbox" id="ch2" class="primary"> <label
								for="ch2">Primary</label>
						</div>
						<div class="checkbox anim-checkbox">
							<input type="checkbox" id="ch3" class="success"> <label
								for="ch3">Success</label>
						</div>
						<div class="checkbox anim-checkbox">
							<input type="checkbox" id="ch4" class="warning"> <label
								for="ch4">Warning</label>
						</div>
						<div class="checkbox anim-checkbox">
							<input type="checkbox" id="ch5" class="danger"> <label
								for="ch5">Danger</label>
						</div>
						<div class="checkbox anim-checkbox">
							<input type="checkbox" id="ch6" class="info"> <label
								for="ch6">Info</label>
						</div>
					</div>
				</div>
				<!-- /.row -->

				<!-- END CHECKBOX & RADIO -->

				<!--BEGIN AUTOMATIC JUMP-->
				<div class="row">
					<div class="col-lg-12">
						<div class="box">
							<header>
								<div class="icons">
									<i class="fa fa-exchange"></i>
								</div>
								<h5>Automatically jump to the next input-field</h5>
							</header>
							<div class="body">
								<form id="validVal" class="form-inline">
									<div class="row form-group">
										<div class="col-lg-4">
											<input class="form-control autotab" type="text" maxlength="3"
												tabindex="11">
										</div>
										<!-- /.col-lg-4 -->
										<div class="col-lg-4">
											<input class="form-control autotab" type="text" maxlength="4"
												tabindex="12">
										</div>
										<!-- /.col-lg-4 -->
										<div class="col-lg-4">
											<input class="form-control" type="text" maxlength="5"
												tabindex="13">
										</div>
									</div>
									<!-- /.row -->
									<div class="row form-group">
										<div class="col-lg-6">
											<select class="form-control autotab" name="tabs1_7"
												tabindex="14">
												<option value="one">One</option>
												<option value="two">Two</option>
												<option value="three">Three</option>
											</select>
										</div>
										<!-- /.col-lg-6 -->
										<div class="col-lg-6">
											<select class="form-control autotab" tabindex="15">
												<option value="one">One</option>
												<option value="two">Two</option>
												<option value="three">Three</option>
											</select>
										</div>
										<!-- /.col-lg-6 -->
									</div>
									<!-- /.row -->
								</form>
							</div>
						</div>
					</div>
				</div>

				<!--END AUTOMATIC JUMP-->

				<!--BEGIN MASKED INPUTS-->
				<div class="row">
					<div class="col-lg-12">
						<div class="box">
							<header>
								<div class="icons">
									<i class="fa fa-bolt"></i>
								</div>
								<h5>Masked Inputs</h5>

								<!-- .toolbar -->
								<div class="toolbar">
									<nav style="padding: 8px;">
										<a href="javascript:;"
											class="btn btn-default btn-xs collapse-box"> <i
											class="fa fa-minus"></i>
										</a> <a href="javascript:;"
											class="btn btn-default btn-xs full-box"> <i
											class="fa fa-expand"></i>
										</a> <a href="javascript:;"
											class="btn btn-danger btn-xs close-box"> <i
											class="fa fa-times"></i>
										</a>
									</nav>
								</div>
								<!-- /.toolbar -->
							</header>
							<div id="div-4" class="body">
								<form class="form-horizontal">
									<div class="form-group">
										<label class="control-label col-lg-3">Date</label>
										<div class="col-lg-5">
											<div class="input-group">
												<input class="form-control" type="text"
													data-mask="99/99/9999"> <span
													class="input-group-addon">99/99/9999</span>
											</div>
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-lg-3">Phone</label>
										<div class="col-lg-5">
											<div class="input-group">
												<input class="form-control" type="text"
													data-mask="(999) 999-9999"> <span
													class="input-group-addon">(999) 999-9999</span>
											</div>
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-lg-3">Product key</label>
										<div class="col-lg-5">
											<div class="input-group">
												<input class="form-control" type="text"
													data-mask="a*-999-a999"> <span
													class="input-group-addon">a*-999-a999</span>
											</div>
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-lg-3">Phone</label>
										<div class="col-lg-5">
											<div class="input-group">
												<input class="form-control" type="text"
													data-mask="+33 999 999 999"> <span
													class="input-group-addon">+33 999 999 999</span>
											</div>
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-lg-3">Percent</label>
										<div class="col-lg-5">
											<div class="input-group">
												<input class="form-control" type="text" data-mask="99%">
												<span class="input-group-addon">99%</span>
											</div>
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>

				<!--END MASKED INPUTS-->

				<!-- BEGIN COLOR PICKER -->

				<!-- .row -->
				<div class="row">

					<!-- .col-lg-6 -->
					<div class="col-lg-12">

						<!-- .box -->
						<div class="box">
							<header>
								<div class="icons">
									<i class="fa fa-edit"></i>
								</div>
								<h5>Color Picker</h5>

								<!-- .toolbar -->
								<div class="toolbar">
									<nav style="padding: 8px;">
										<a href="javascript:;"
											class="btn btn-default btn-xs collapse-box"> <i
											class="fa fa-minus"></i>
										</a> <a href="javascript:;"
											class="btn btn-default btn-xs full-box"> <i
											class="fa fa-expand"></i>
										</a> <a href="javascript:;"
											class="btn btn-danger btn-xs close-box"> <i
											class="fa fa-times"></i>
										</a>
									</nav>
								</div>
								<!-- /.toolbar -->
							</header>

							<!-- .BODY -->
							<div class="body" id="colorPickerBlock">
								<form class="form-horizontal">
									<div class="form-group">
										<label for="cp1" class="control-label col-lg-4">Field
											with hex format</label>
										<div class="col-lg-3">
											<input type="text" class="form-control" value="#8fff00"
												id="cp1">
										</div>
									</div>
									<div class="form-group">
										<label for="cp2" class="control-label col-lg-4">Field
											with the rgba format</label>
										<div class="col-lg-3">
											<input type="text" class="form-control"
												value="rgb(0,194,255,0.78)" id="cp2"
												data-color-format="rgba">
										</div>
									</div>
									<div class="form-group">
										<label for="cp3" class="control-label col-lg-4">As
											component</label>
										<div class="col-lg-3">
											<div class="input-group color">
												<input type="text" class="form-control" readonly
													data-color="rgb(255, 146, 180)" data-color-format="rgb"
													id="cp3"> <span class="input-group-addon"
													style="background-color: rgb(255, 146, 180)"><i
													class="fa fa-home"></i></span>
											</div>
											<!-- /input-group -->
										</div>
									</div>
									<div class="form-group">
										<label for="cp3" class="control-label col-lg-4">Using
											events to work with the color</label>
										<div class="col-lg-3">
											<a href="#" class="btn btn-danger" id="cp4"
												data-color-format="hex" data-color="rgb(255, 255, 255)">Change
												background color</a>
										</div>
									</div>
								</form>
							</div>
							<!-- /.BODY -->
						</div>
						<!-- /.box -->
					</div>
					<!-- /.col-lg-12 -->
				</div>
				<!-- /.row -->

				<!-- END COLOR PICKER -->

				<!-- BEGIN DATE PICKER -->
				<div class="row">

					<!-- .col-lg-12 -->
					<div class="col-lg-12">

						<!-- .box -->
						<div class="box">
							<header>
								<div class="icons">
									<i class="fa fa-calendar"></i>
								</div>
								<h5>Date Picker</h5>

								<!-- .toolbar -->
								<div class="toolbar">
									<nav style="padding: 8px;">
										<a href="javascript:;"
											class="btn btn-default btn-xs collapse-box"> <i
											class="fa fa-minus"></i>
										</a> <a href="javascript:;"
											class="btn btn-default btn-xs full-box"> <i
											class="fa fa-expand"></i>
										</a> <a href="javascript:;"
											class="btn btn-danger btn-xs close-box"> <i
											class="fa fa-times"></i>
										</a>
									</nav>
								</div>
								<!-- /.toolbar -->
							</header>
							<div id="datePickerBlock" class="body">
								<form class="form-horizontal">
									<div class="form-group">
										<label class="control-label col-lg-4" for="dp1">Field
											with the format specified via options </label>
										<div class="col-lg-3">
											<input type="text" class="form-control" value="02-16-2012"
												id="dp1">
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-lg-4" for="dp2">Field
											with the format specified via data tag </label>
										<div class="col-lg-3">
											<input type="text" class="form-control" value="02/16/12"
												data-date-format="mm/dd/yy" id="dp2">
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-lg-4" for="dp3">As
											component</label>
										<div class="col-lg-3">
											<div class="input-group input-append date" id="dp3"
												data-date="12-02-2012" data-date-format="dd-mm-yyyy">
												<input class="form-control" type="text" value="12-02-2012"
													readonly> <span class="input-group-addon add-on"><i
													class="fa fa-calendar"></i></span>
											</div>
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-lg-4" for="dpYears">Start
											with years viewMode</label>
										<div class="col-lg-3">
											<div class="input-group input-append  date" id="dpYears"
												data-date="12-02-2012" data-date-format="dd-mm-yyyy"
												data-date-viewmode="years">
												<input class="form-control" type="text" value="12-02-2012"
													readonly> <span class="input-group-addon add-on"><i
													class="fa fa-calendar"></i></span>
											</div>
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-lg-4" for="dpMonths">Limit
											the view mode to months</label>
										<div class="col-lg-3">
											<div class="input-group input-append  date" id="dpMonths"
												data-date="102/2012" data-date-format="mm/yyyy"
												data-date-viewmode="years" data-date-minviewmode="months">
												<input class="form-control" type="text" value="12-02-2012"
													readonly> <span class="input-group-addon add-on"><i
													class="fa fa-calendar"></i></span>
											</div>
										</div>
									</div>
									<div class="form-group">
										<div class="body">
											<p>Attached to other element then field and using events
												to work with the date values.</p>
											<div class="alert alert-danger" id="alert"
												style="display: none;">
												<strong>Oh snap!</strong>
												<p></p>
											</div>
											<table class="table">
												<thead>
													<tr>
														<th><a href="#" class="btn btn-default" id="dp4"
															data-date-format="yyyy-mm-dd" data-date="2014-02-20">Start
																date</a></th>
														<th><a href="#" class="btn btn-default" id="dp5"
															data-date-format="yyyy-mm-dd" data-date="2014-02-25">End
																date</a></th>
													</tr>
												</thead>
												<tbody>
													<tr>
														<td id="startDate">2012-02-20</td>
														<td id="endDate">2012-02-25</td>
													</tr>
												</tbody>
											</table>
										</div>
									</div>
								</form>
							</div>
						</div>
						<!-- /.box -->
					</div>
					<!-- /.col-lg-12 -->
				</div>

				<!-- END DATE PICKER -->

				<!-- BEGIN DATE RANGE PICKER -->

				<!-- .row -->
				<div class="row">

					<!-- .col-lg-12 -->
					<div class="col-lg-12">

						<!-- .box -->
						<div class="box">
							<header>
								<div class="icons">
									<i class="fa fa-calendar"></i>
								</div>
								<h5>Date Range Picker</h5>

								<!-- .toolbar -->
								<div class="toolbar">
									<nav style="padding: 8px;">
										<a href="javascript:;"
											class="btn btn-default btn-xs collapse-box"> <i
											class="fa fa-minus"></i>
										</a> <a href="javascript:;"
											class="btn btn-default btn-xs full-box"> <i
											class="fa fa-expand"></i>
										</a> <a href="javascript:;"
											class="btn btn-danger btn-xs close-box"> <i
											class="fa fa-times"></i>
										</a>
									</nav>
								</div>
								<!-- /.toolbar -->
							</header>

							<!-- .block -->
							<div id="dateRangePickerBlock" class="body">
								<form class="form-horizontal">
									<div class="form-group">
										<label class="control-label col-lg-4" for="reservation">Reservation
											dates</label>
										<div class="col-lg-4">
											<div class="input-group">
												<span class="input-group-addon"><i
													class="fa fa-calendar"></i></span> <input type="text"
													name="reservation" id="reservation" class="form-control">
											</div>
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-lg-4" for="reportrange">Pre-defined
											Ranges & Callback</label>
										<div class="col-lg-4">
											<div class="input-group">
												<span class="input-group-addon"><i
													class="fa fa-calendar"></i></span> <input type="text"
													class="form-control" value="02-16-2012" id="reportrange">
											</div>
										</div>
									</div>
								</form>
							</div>
							<!-- /.block -->
						</div>
						<!-- /.box -->
					</div>
					<!-- /.col-lg-12 -->
				</div>
				<!-- /.row -->

				<!--END DATE RANGE PICKER -->

				<!-- BEGIN TIME PICKER -->
				<div class="row">
					<div class="col-lg-12">
						<div class="box">
							<header>
								<div class="icons">
									<i class="fa fa-clock-o"></i>
								</div>
								<h5>Time Picker</h5>
							</header>
							<div class="body">
								<form action="#" class="form-horizontal">
									<div class="form-group">
										<label class="control-label col-lg-4">Default
											Timepicker</label>
										<div class="col-lg-3">
											<div class="input-group bootstrap-timepicker">
												<input class="form-control timepicker-default" type="text">
												<span class="input-group-addon add-on"><i
													class="fa fa-clock-o"></i></span>
											</div>
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-lg-4">24hr Timepicker</label>
										<div class="col-lg-3">
											<div class="input-group bootstrap-timepicker">
												<input class="timepicker-24 form-control" type="text">
												<span class="input-group-addon add-on"><i
													class="fa fa-clock-o"></i></span>
											</div>
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>

				<!-- END TIME PICKER -->

				<!-- BEGIN GRID INPUTS-->
				<div class="row">
					<div class="col-lg-12">
						<div class="box">
							<header>
								<div class="icons">
									<i class="fa fa-th"></i>
								</div>
								<h5>Grid Inputs</h5>

								<!-- .toolbar -->
								<div class="toolbar">
									<nav style="padding: 8px;">
										<a href="javascript:;"
											class="btn btn-default btn-xs collapse-box"> <i
											class="fa fa-minus"></i>
										</a> <a href="javascript:;"
											class="btn btn-default btn-xs full-box"> <i
											class="fa fa-expand"></i>
										</a> <a href="javascript:;"
											class="btn btn-danger btn-xs close-box"> <i
											class="fa fa-times"></i>
										</a>
									</nav>
								</div>
								<!-- /.toolbar -->
							</header>
							<div id="div-5" class="body">
								<form class="">
									<div class="form-group row">
										<div class="col-lg-1">
											<input class="form-control" placeholder=".col-lg-1"
												type="text">
										</div>
										<!-- /.col-lg-1 -->
										<div class="col-lg-11">
											<input class="form-control" placeholder=".col-lg-11"
												type="text">
										</div>
										<!-- /.col-lg-11 -->
									</div>
									<div class="form-group row">
										<div class="col-lg-2">
											<input class="form-control" placeholder=".col-lg-2"
												type="text">
										</div>
										<!-- /.col-lg-2 -->
										<div class="col-lg-10">
											<input class="form-control" placeholder=".col-lg-10"
												type="text">
										</div>
										<!-- /.col-lg-10 -->
									</div>
									<div class="form-group row">
										<div class="col-lg-3">
											<input class="form-control" placeholder=".col-lg-3"
												type="text">
										</div>
										<!-- /.col-lg-3 -->
										<div class="col-lg-9">
											<input class="form-control" placeholder=".col-lg-9"
												type="text">
										</div>
										<!-- /.col-lg-9 -->
									</div>
									<div class="form-group row">
										<div class="col-lg-4">
											<input class="form-control" placeholder=".col-lg-4"
												type="text">
										</div>
										<!-- /.col-lg-4 -->
										<div class="col-lg-8">
											<input class="form-control" placeholder=".col-lg-8"
												type="text">
										</div>
										<!-- /.col-lg-8 -->
									</div>
									<div class="form-group row">
										<div class="col-lg-5">
											<input class="form-control" placeholder=".col-lg-5"
												type="text">
										</div>
										<!-- /.col-lg-5 -->
										<div class="col-lg-7">
											<input class="form-control" placeholder=".col-lg-7"
												type="text">
										</div>
										<!-- /.col-lg-7 -->
									</div>
									<div class="form-group row">
										<div class="col-lg-6">
											<input class="form-control" placeholder=".col-lg-6"
												type="text">
										</div>
										<!-- /.col-lg-6 -->
										<div class="col-lg-6">
											<input class="form-control" placeholder=".col-lg-6"
												type="text">
										</div>
										<!-- /.col-lg-6 -->
									</div>
									<div class="form-group row">
										<div class="col-lg-4">
											<input class="form-control" placeholder=".col-lg-4"
												type="text">
										</div>
										<!-- /.col-lg-4 -->
										<div class="col-lg-4">
											<input class="form-control" placeholder=".col-lg-4"
												type="text">
										</div>
										<!-- /.col-lg-4 -->
										<div class="col-lg-4">
											<input class="form-control" placeholder=".col-lg-4"
												type="text">
										</div>
										<!-- /.col-lg-4 -->
									</div>
									<div class="form-group row">
										<div class="col-lg-3">
											<input class="form-control" placeholder=".col-lg-3"
												type="text">
										</div>
										<!-- /.col-lg-3 -->
										<div class="col-lg-4">
											<input class="form-control" placeholder=".col-lg-4"
												type="text">
										</div>
										<!-- /.col-lg-4 -->
										<div class="col-lg-5">
											<input class="form-control" placeholder=".col-lg-5"
												type="text">
										</div>
										<!-- /.col-lg-5 -->
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>

				<!--END GRID INPUTS-->


				<div class="row">
					<div class="col-lg-12">
						<div class="box">
							<header>
								<div class="icons">
									<i class="fa fa-th-large"></i>
								</div>
								<h5>Basic Editor</h5>

								<!-- .toolbar -->
								<div class="toolbar">
									<nav style="padding: 8px;">
										<a href="javascript:;"
											class="btn btn-default btn-xs collapse-box"> <i
											class="fa fa-minus"></i>
										</a> <a href="javascript:;"
											class="btn btn-default btn-xs full-box"> <i
											class="fa fa-expand"></i>
										</a> <a href="javascript:;"
											class="btn btn-danger btn-xs close-box"> <i
											class="fa fa-times"></i>
										</a>
									</nav>
								</div>
								<!-- /.toolbar -->
							</header>
							<div id="div-1" class="body">
								<form>
									<textarea id="wysihtml5" class="form-control" rows="10"></textarea>

								</form>
							</div>
						</div>

						<div class="form-actions">
							<input type="submit" value="Submit" class="btn btn-primary">
						</div>
					</div>
					<!-- /.col-lg-12 -->
				</div>
				<!-- /.row -->
			</div>
			<!-- /.inner -->
		</div>
		<!-- /.outer -->
	</div>
	<!-- /#content -->
	
	
	<script>
		$(function() {
			Metis.formGeneral();
			Metis.formWysiwyg();
		});
	</script>
	

</body>
