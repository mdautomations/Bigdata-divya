

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Web Advertising</title>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<meta name="description" content="" />
		<meta name="keywords" content="" />
		<script src="js/jquery.min.js"></script>
		<script src="js/jquery.scrolly.min.js"></script>
		<script src="js/jquery.scrollzer.min.js"></script>
		<script src="js/skel.min.js"></script>
		<script src="js/skel-layers.min.js"></script>
		<script src="js/init.js"></script>
		<link rel="stylesheet" href="css/skel.css" />
			<link rel="stylesheet" href="css/style.css" />
			<link rel="stylesheet" href="css/style-wide.css" />
		<link href="css/default.min.css" rel="stylesheet">
			<link href="css/dataTable.css" rel="stylesheet">
			<link href="css/dataTables_jui.css" rel="stylesheet">
	</head>
	<body>
			<div id="main" style="margin-left: 0px;">
					<section id="top" class="one dark cover">
						<div class="container">

							<header>
								<h2 class="alt">Bigdata Implementation for Web <strong>Advertising</strong> <a href="#">- HMM Model Precision</a><br />
							</header>
							<footer>
								<input type="button" id="delete" onclick="deleteExisting();" value="Delete Existing">
								<input type="button" id="processhmm" onclick="processhm();" value="Process" style="display:none;">
							</footer>
						</div>
					</section>
					<section id="portfolio" class="two">
					<center><img src="images/load.gif" id="loading" alt=" " style="display: none;height: 50%;width: 5%;"><br><span id="statusmsg" style="display: none;">Deleting...Please Wait</span></center>
						<div class="container">
							<header>
								<h2>Baumweich Actual Probablities</h2>
							</header>
							<section id="top" class="one dark cover">
								<div class="container">
									<table id="datastables" class="table display" cellspacing="0" width="100%" style="width: 100% !important;">
			                   			 <thead>
			                        		<tr id="transcripts_list_header" >
			                            		<th>Item</th>
			                            		<th>Location</th>
			                            		<th>Session</th>
			                              		<th>CTR</th>
			                              		<th>CPC</th>
			                              		<th>CPM</th>
			                              		<th>CR</th>
			                              		<th>CPA</th>
			                        		</tr>
			                    		</thead>
		                    			<tbody id="dataIns">
		                      			<tdata>
			                      			<tr>
				                      			<td>0.05</td>
				                      			<td>0.05</td>
				                      			<td>0.05</td>
				                      			<td>0.15</td>
				                      			<td>0.10</td>
				                      			<td>0.40</td>
				                      			<td>0.05</td>
				                      			<td>0.15</td>
				                      		<tr>
				                      		<tr>
				                      			<td>0.05</td>
				                      			<td>0.05</td>
				                      			<td>0.05</td>
				                      			<td>0.05</td>
				                      			<td>0.15</td>
				                      			<td>0.55</td>
				                      			<td>0.05</td>
				                      			<td>0.05</td>
				                      		<tr>
				                      		<tr>
				                      			<td>0.10</td>
				                      			<td>0.05</td>
				                      			<td>0.05</td>
				                      			<td>0.05</td>
				                      			<td>0.15</td>
				                      			<td>0.10</td>
				                      			<td>0.20</td>
				                      			<td>0.30</td>
				                      		<tr>
		                      			</tdata>		
		                   				</tbody>		
									</table>
								</div>
							</section>
						</div>
					</section>
					
					<section id="portfolio" class="two" >
						<div class="container" id="output1" style="display:none;">
							<header>
								<h2>Baumweich Actual Probablities - After Processing</h2>
							</header>
							<section id="top" class="one dark cover">
								<div class="container">
									<table id="outputActualProb" class="table display" cellspacing="0" width="100%" style="width: 100% !important;">
			                   			 <thead>
			                        		<tr id="transcripts_list_header" >
			                            		<th>Item</th>
			                            		<th>Location</th>
			                            		<th>Session</th>
			                              		<th>CTR</th>
			                              		<th>CPC</th>
			                              		<th>CPM</th>
			                              		<th>CR</th>
			                              		<th>CPA</th>
			                        		</tr>
			                    		</thead>
		                    			<tbody id="dataIns">
		                      			<tdata>
			                      			
		                      			</tdata>		
		                   				</tbody>		
									</table>
								</div>
								<footer>
									<input type="button" id="fetchagainActualprob" onclick="saveContactdetails();" value="Fetch Again" style="margin-left: 2%;">
								</span>
							</footer>
							</section>
						</div>
					</section>
					
					<section id="portfolio" class="two">
						<div class="container">
							<header>
								<h2>Baumweich Emission Probablities</h2>
							</header>
							<section id="top" class="one dark cover">
								<div class="container">
									<table id="datastables" class="table display" cellspacing="0" width="100%" style="width: 100% !important;">
			                   			 <thead>
			                        		<tr id="transcripts_list_header" >
			                            		<th>Item</th>
			                            		<th>Location</th>
			                            		<th>Session</th>
			                              		<th>CTR</th>
			                              		<th>CPC</th>
			                              		<th>CPM</th>
			                              		<th>CR</th>
			                              		<th>CPA</th>
			                        		</tr>
			                    		</thead>
		                    			<tbody id="dataIns">
		                     			 <tdata>
			                      			<tr>
				                      			<td>0.10</td>
				                      			<td>0.10</td>
				                      			<td>0.10</td>
				                      			<td>0.10</td>
				                      			<td>0.10</td>
				                      			<td>0.20</td>
				                      			<td>0.20</td>
				                      			<td>0.10</td>
				                      		<tr>
				                      		<tr>
				                      			<td>0.10</td>
				                      			<td>0.10</td>
				                      			<td>0.10</td>
				                      			<td>0.10</td>
				                      			<td>0.10</td>
				                      			<td>0.10</td>
				                      			<td>0.35</td>
				                      			<td>0.05</td>
				                      		<tr>
				                      		<tr>
				                      			<td>0.10</td>
				                      			<td>0.10</td>
				                      			<td>0.10</td>
				                      			<td>0.10</td>
				                      			<td>0.40</td>
				                      			<td>0.10</td>
				                      			<td>0.05</td>
				                      			<td>0.05</td>
				                      		<tr>
		                      			</tdata>
		                   				</tbody>		
									</table>
								</div>
							</section>
						</div>
					</section>
					<section id="portfolio" class="two" >
						<div class="container" id="output2" style="display:none;">
							<header>
								<h2>Baumweich Emission Probablities - After Processing</h2>
							</header>
							<section id="top" class="one dark cover">
								<div class="container">
									<table id="outputEmissionProb" class="table display" cellspacing="0" width="100%" style="width: 100% !important;">
			                   			 <thead>
			                        		<tr id="transcripts_list_header" >
			                            		<th>Item</th>
			                            		<th>Location</th>
			                            		<th>Session</th>
			                              		<th>CTR</th>
			                              		<th>CPC</th>
			                              		<th>CPM</th>
			                              		<th>CR</th>
			                              		<th>CPA</th>
			                        		</tr>
			                    		</thead>
		                    			<tbody id="dataIns">
		                      			<tdata>
			                      			
		                      			</tdata>		
		                   				</tbody>		
									</table>
								</div>
								<footer>
								<input type="button" id="highest" onclick="highest();" value="Pick the highest probablity">
							<input type="button" id="fetchagain" onclick="saveemission();" value="Fetch Again" style="margin-left: 2%;">
								<span id="toshow" style="display:none"><p> Highest CTR </p> <span id="highestctr"></span>
								<p> Highest CPC </p> <span id="highestcpc"></span>
								<p> Highest CPM </p> <span id="highestcpm"></span>
								</span>
							</footer>
							</section>
						</div>
					</section>
					
			
				<!-- Contact -->
					<section id="contact" class="ix">
						<div class="container">

							<header>
								<h2>Contact</h2>
							</header>

							<p>dhivyap519@gmail.com </p>
							<p>91-9994324671</p>
						</div>
					</section>
			
			</div>

			<div id="footer" style="margin-left: 0px;">
				<!-- Copyright -->
					<ul class="copyright">
						<li>&copy; Pondicherry Engineering College.</li><li> Developed by: <a href="#">Dhivya</a></li>
					</ul>
				
			</div>
	<script src="js/scripts.min.js"></script>
    <script type="text/javascript" src="js/jquery.dataTables.min.js" ></script>
    <script src="js/actions.js"></script>
    <script src="js/cookie.js"></script>
	</body>
</html>