<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Social Network Template</title>

    <!-- App Styling Bundle -->
    <link href="css/default.min.css" rel="stylesheet">
	
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]><script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>

    <!-- Fixed navbar -->
    <div class="navbar navbar-main navbar-primary navbar-fixed-top"
		role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<a href="#" data-toggle="sidebar-menu" id="toggle-sidebar-menu"
					class="visible-xs"><i class="fa fa-ellipsis-v"></i></a>
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#main-nav">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a data-toggle="sidebar-chat"
					class="btn btn-link navbar-btn visible-xs"><i
					class="fa fa-comments"></i></a> <a class="navbar-brand"
					href="index.jsp">Social Course Creation and Maintainance Corner</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse" id="main-nav">
				<ul class="nav navbar-nav navbar-right">
					<li class="hidden-xs"><a href="#" data-toggle="sidebar-chat">
							<i class="fa fa-comments"></i>
					</a></li>

					<!-- User -->
					<li class="dropdown">
                        <a href="#" class="dropdown-toggle user" >
                          <span id="credit">   Credit Value</span> 
                        </a>
                    </li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"> <img
							src="images/people/110/child-1.jpg" alt="Bill" class="img-circle"
							width="40" />
						<div class="logins">Praveena</div>
							<span class="caret"></span>
					</a>
						<ul class="dropdown-menu" role="menu">
							<!--                             <li><a href="user-private-profile.jsp">Profile</a> -->
							<!--                             </li> -->
							<!--                             <li><a href="user-private-messages.jsp">Messages</a> -->
							<!--                             </li> -->
							<li><a href="login.jsp">Logout</a></li>
						</ul></li>
				</ul>
			</div>

			<!-- /.navbar-collapse -->
		</div>
	</div>
    <div class="sidebar left hidden-xs">
		<div data-scrollable="" tabindex="0"
			style="overflow: hidden; outline: none;">
			<div class="sidebar-block">
				<div class="profile">
					<img src="images/people/110/child-1.jpg" alt="people"
						class="img-circle" style="height: 92px;">
					<h4 class="logins">Praveena</h4>
				</div>
			</div>
			<div class="sidebar-block">
				<div class="category">About</div>
				<ul class="list-about">
					<li><i class="fa fa-map-marker"></i>Dept of Computer Science</li>
					<li><i class="fa fa-link"></i> <a href="#">PEC,
							Pondicherry</a></li>
					<li><i class="fa fa-twitter"></i> <a href="#">India</a></li>
				</ul>
			</div>
			<div class="sidebar-block">
				<div class="category">Courses Completed</div>
				<div class="sidebar-photos">
					<ul>
						<li><a href="#"> <img src="images/place1.jpg"
								alt="people">
						</a></li>
						<li><a href="#"> <img src="images/place2.jpg"
								alt="people">
						</a></li>
						<li><a href="#"> <img src="images/place3.jpg"
								alt="people">
						</a></li>
						<li><a href="#"> <img src="images/food1.jpg" alt="people">
						</a></li>
						<li><a href="#"> <img src="images/food1.jpg" alt="people">
						</a></li>
						<li><a href="#"> <img src="images/place3.jpg"
								alt="people">
						</a></li>
						<li><a href="#"> <img src="images/place2.jpg"
								alt="people">
						</a></li>
						<li><a href="#"> <img src="images/place1.jpg"
								alt="people">
						</a></li>
					</ul>
					<a href="#" class="btn btn-primary btn-xs">view all</a>
				</div>
			</div>
			<div class="sidebar-block">
				<div class="category">Activity</div>
				<div class="activity-feed">
					<ul>
						<li class="media news-item"><span
							class="news-item-success pull-right "><i
								class="fa fa-circle"></i></span> <span class="pull-left media-object">
								<i class="fa fa-fw fa-bell"></i>
						</span>
							<div class="media-body">
								<a href="" class="text-white">Requested </a> <a href=""
									class="text-white">Software Engineering</a> <span class="time">2
									min ago</span>
							</div></li>
						<li class="media news-item"><span
							class="pull-left media-object"> <i
								class="fa fa-fw fa-bell"></i>
						</span>
							<div class="media-body">
								Undergoing <a href="" class="text-white">Mathematics !</a> <span
									class="time">Since 2 days</span>
							</div></li>
						<li class="media news-item"><span
							class="pull-left media-object"> <i
								class="fa fa-fw fa-bell"></i>
						</span>
							<div class="media-body">
								Completed <a href="" class="text-white">Data Mining</a> <span
									class="time">2 hours ago </span>
							</div></li>
						<li class="media news-item"><span
							class="pull-left media-object"> <i
								class="fa fa-fw fa-bell"></i>
						</span>
							<div class="media-body">
								Completed <a href="" class="text-white">Computer Graphics </a> <span
									class="time">1 Month ago</span>
							</div></li>
					</ul>
				</div>
			</div>
		</div>
		<div id="ascrail2000" class="nicescroll-rails"
			style="width: 5px; z-index: 1; cursor: default; position: absolute; top: 0px; left: 245px; height: 382px; opacity: 0;">
			<div
				style="position: relative; top: 0px; float: right; width: 5px; height: 169px; border: 0px; border-top-left-radius: 5px; border-top-right-radius: 5px; border-bottom-right-radius: 5px; border-bottom-left-radius: 5px; background-color: rgb(37, 173, 159); background-clip: padding-box;"></div>
		</div>
		<div id="ascrail2000-hr" class="nicescroll-rails"
			style="height: 5px; z-index: 1; top: 377px; left: 0px; position: absolute; cursor: default; display: none; width: 245px; opacity: 0;">
			<div
				style="position: absolute; top: 0px; height: 5px; width: 250px; border: 0px; border-top-left-radius: 5px; border-top-right-radius: 5px; border-bottom-right-radius: 5px; border-bottom-left-radius: 5px; background-color: rgb(37, 173, 159); background-clip: padding-box;"></div>
		</div>
	</div>
    <div id="content">
        <div class="container-fluid">
            <h1>Based on your goal, Our system has suggessted the best subjects to reach your goal</h1>
            <div class="panel panel-default">
                <div class="panel-heading panel-heading-gray">
               Course Generation
                </div>

                <!-- Data table -->
                <table id="datastables" class="table display" cellspacing="0" width="100%">
                    <thead>
                        <tr id="transcripts_list_header" >
                            <th>Subject</th>
                            <th>Significance</th>
                            <th>Goal</th>
                        </tr>
                    </thead>
                    <tbody id="dataIns">
                      
                    </tbody>
                </table>
                </div>
        </div>

        </div>

    <!-- Vendor Scripts Bundle -->
    <script src="js/vendor.min.js"></script>
    <!-- App Scripts Bundle -->
    <script src="js/scripts.min.js"></script>
     <script src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/jquery.dataTables.min.js" ></script>
    <script src="js/cookie.js"></script>
    <script src="js/autocourses.js"></script>
</body>
</html>