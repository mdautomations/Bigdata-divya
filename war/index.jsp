<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<%@page import="com.google.appengine.api.blobstore.BlobstoreService"%>
<%@page import="com.google.appengine.api.blobstore.BlobstoreServiceFactory"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Web Advertising</title>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<meta name="description" content="" />
		<meta name="keywords" content="" />
		<!--[if lte IE 8]><script src="css/ie/html5shiv.js"></script><![endif]-->
		<script src="js/jquery.min.js"></script>
		<script src="js/jquery.scrolly.min.js"></script>
		<script src="js/jquery.scrollzer.min.js"></script>
		<script src="js/skel.min.js"></script>
		<script src="js/skel-layers.min.js"></script>
		<script src="js/init.js"></script>
		<script src="js/actions.js"></script>
		<script src="js/cookie.js"></script>
		<noscript>
			<link rel="stylesheet" href="css/skel.css" />
			<link rel="stylesheet" href="css/style.css" />
			<link rel="stylesheet" href="css/style-wide.css" />
		</noscript>
		<!--[if lte IE 9]><link rel="stylesheet" href="css/ie/v9.css" /><![endif]-->
		<!--[if lte IE 8]><link rel="stylesheet" href="css/ie/v8.css" /><![endif]-->
	</head>
	<body>

		<!-- Header -->
			<div id="header" class="skel-layers-fixed">

				<div class="top">

					<!-- Logo -->
						<div id="logo">
							<span class="image avatar48"><img src="images/avatar.jpg" alt="" /></span>
							<h1 id="title">Web Advertising </h1>
							<p>Using Map Reduce</p>
						</div>

					<!-- Nav -->
						<nav id="nav">
							<!--
							
								Prologue's nav expects links in one of two formats:
								
								1. Hash link (scrolls to a different section within the page)
								
								   <li><a href="#foobar" id="foobar-link" class="icon fa-whatever-icon-you-want skel-layers-ignoreHref"><span class="label">Foobar</span></a></li>

								2. Standard link (sends the user to another page/site)

								   <li><a href="http://foobar.tld" id="foobar-link" class="icon fa-whatever-icon-you-want"><span class="label">Foobar</span></a></li>
							
							-->
							<ul>
								<li><a href="#about" id="top-link" class="skel-layers-ignoreHref"><span class="icon fa-home">Upload Dataset</span></a></li>
								<li><a href="#neuroph" id="top-link" class="skel-layers-ignoreHref"><span class="icon fa-home">Update Advertisement Report</span></a></li>
								<li><a href="#portfolio" id="portfolio-link" class="skel-layers-ignoreHref"><span class="icon fa-th">Query Processing</span></a></li>
								<li><a href="/mapreduce/status" id="about-link" class="skel-layers-ignoreHref"><span class="icon fa-user">View Map Reduce</span></a></li>
								<li><a href="/report.jsp" id="about-link" class="skel-layers-ignoreHref"><span class="icon fa-user">Generate Report</span></a></li>
								<li><a href="#contact" id="contact-link" class="skel-layers-ignoreHref"><span class="icon fa-envelope">Contact</span></a></li>
							</ul>
						</nav>
						
				</div>
				
				<div class="bottom">

					<!-- Social Icons -->
						<ul class="icons">
							<li><a href="#" class="icon fa-twitter"><span class="label">Twitter</span></a></li>
							<li><a href="#" class="icon fa-facebook"><span class="label">Facebook</span></a></li>
							<li><a href="#" class="icon fa-github"><span class="label">Github</span></a></li>
							<li><a href="#" class="icon fa-dribbble"><span class="label">Dribbble</span></a></li>
							<li><a href="#" class="icon fa-envelope"><span class="label">Email</span></a></li>
						</ul>
				
				</div>
			
			</div>

		<!-- Main -->
			<div id="main">

				<!-- Intro -->
					<section id="top" class="one dark cover">
						<div class="container">

							<header>
								<h2 class="alt">Bigdata Implementation for Web <strong>Advertising</strong> <a href="#">- Temporal Data Analytics</a><br />
<!-- 				<p>XML/relational mapping means data transformation between XML and relational data models</p> -->
							</header>
							
							<footer>
								<a href="#about" class="button scrolly">Upload XML File</a>
							</footer>

						</div>
					</section>
					
					<section id="portfolio" class="two">
						<div class="container">
					
							<header>
								<h2>Advertisement</h2>
							</header>
							 
									<div class="row half">
									<div class="6u" style=" margin-left: 24%;">
										<input type="text" id="search" placeholder="Enter your term and press Enter">
									</div>
									</div>
						<br/>
						<section id="portfolio" class="two" style=" margin-bottom: -1em;">
						<div class="container" id="output1" style="display:none;">
							<section id="top" class="one dark cover" style="padding: 2em 0;">
								<div class="container">
									<table id="outputEmissionProb" class="table display" cellspacing="0" width="100%" style="width: 100% !important;font-size: 14px;">
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
									<input type="button" id="fetchagain" onclick="saveemission();" value="Fetch Again" style="margin-left: 2%;font-size: 12px;">
								</span>
							</footer>
							</section>
						</div>
					</section>
							<center><img src="images/load.gif" id="loadings" alt=" " style="display: none;height: 50%;width: 5%;"><br><span id="statusmsgs" style="font-size: 17px; font-weight: 200;">Sorted Out..</span></center>
<!-- 							======================================================================================================================== -->
							<div id="ctrsection" style="display:none">
								<header>
									<h2>Ad's based on CTR</h2>
								</header>
									<header>
										<h3>High</h3>
									</header>
									<div class="row" id="highctrcategory" style="display:block">
										
									</div>
									
									<header>
										<h3 >Low</h3>
									</header>
									<div class="row" id="lowctrcategory" style="display:block">
										
									</div>
									
									<header>
										<h3>Medium</h3>
									</header>
									<div class="row" id="mediumctrcategory" style="display:block">
										
									</div>
							</div>
<!-- 							==================================================================================== -->

						<div id="cpcsection" style="display:none">
								<header>
									<h2 >Ad's based on Cost Per Click</h2>
								</header>
									<header>
										<h3>High</h3>
									</header>
									<div class="row" id="highcpccategory" style="display:block">
									</div>
									
									<header>
										<h3>Low</h3>
									</header>
									<div class="row" id="lowcpccategory" style="display:block">
									</div>
									
									<header>
										<h3>Medium</h3>
									</header>
									<div class="row" id="mediumcpccategory" style="display:block">
									</div>
							</div>

<!-- ================================================================================================================ -->
					<div id="cpmsection" style="display:none">
								<header>
									<h2>Ad's based on CPM</h2>
								</header>
									<header>
										<h3>High</h3>
									</header>
									<div class="row" id="highcpmcategory" style="display:block">
										
									</div>
									
									<header>
										<h3>Low</h3>
									</header>
									<div class="row" id="lowcpmcategory" style="display:block">
										
									</div>
									
									<header>
										<h3>Medium</h3>
									</header>
									<div class="row" id="mediumcpmcategory" style="display:block">
										
									</div>
							</div>
			<!-- ================================================================================================================ -->

						</div>
					</section>

					<section id="about" class="three">
						<div class="container">

							<header>
								<h3>Upload the CSV file</h3>
							</header>

							<a href="#" class="image featured" id="uploadcsv"><img src="images/upload.png" alt="" /></a>
						
<% BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService(); %>
 		<form action="<%= blobstoreService.createUploadUrl("/upload") %>" method="post" enctype="multipart/form-data">
        <input type="file" name="data" id="inputfile" style="display: none;">
        <input type="submit" value="Submit">
    </form><br/>
       <a href="/mapreduce/status" id="hideandshow"><input type="button" value="Run Map Reduce"></a>
						</div>
					</section>
					
					<section id="image" class="four">
						<div class="container">

							<header>
								<h3>Upload the Image file</h3>
							</header>

							<a href="#" class="image featured" id="uploadimage"><img src="images/picture.png" alt="" /></a>
						
 		<form action="" method="post" enctype="multipart/form-data">
        <input type="file" name="data" id="inputimage" style="display: none;">
        <input type="submit" value="Submit">
    </form><br/>
       <a href="#" id="hideandshowimg" ><input type="button" value="Run Map Reduce for AD's"></a>
						</div>
					</section>
			
			        <section id="neuroph" class="five">
			       			 <div class="container">
									<header>
											<h3>Upload the User Behaviour Data Set </h3>
											<h6>Click on the csv image to upload</h6>
									</header>
									<form action="<%=blobstoreService.createUploadUrl("/uploadclientplandetails")%>"enctype="multipart/form-data" name="form" method="post">
											<center><a href="#" class="image featured" id="uploadneuroph"><img src="images/csv.png" alt="" style="height: 20%; width: 40%;"></a></center>
											<input type="file" name="UploadFile" id="inputneuroph" style="display: none;">
											<input type="submit"name="submit" >
									</form><br>
									<input type="button" value="Run Map Reduce HMM Baumweich" id="hmm" >
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

			<div id="footer">
				<!-- Copyright -->
					<ul class="copyright">
						<li>&copy; Pondicherry Engineering College.</li><li> Developed by: <a href="#">Dhivya</a></li>
					</ul>
				
			</div>
<script type="text/javascript" src="js/jquery.dataTables.min.js" ></script>
	</body>
</html>