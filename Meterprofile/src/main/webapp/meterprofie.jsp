<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.dao.MeterprofileDao" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>I</title>


<!-- Custom fonts for this template-->
<link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
	type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="css/sb-admin-2.min.css" rel="stylesheet">
</head>
<body id="page-top">

	<!-- Page Wrapper -->
	<div id="wrapper">

		<!-- Sidebar -->
		<ul
			class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion"
			id="accordionSidebar">

			<!-- Sidebar - Brand -->
			<a
				class="sidebar-brand d-flex align-items-center justify-content-center"
				href="index.html">
				<div class="sidebar-brand-icon rotate-n-15">
					<i class="fas  fa-lightbulb-o"></i>
				</div>
				<div class="sidebar-brand-text mx-3">Electro Grid System</div>
			</a>

			<!-- Divider -->
			<hr class="sidebar-divider my-0">

			<!-- Nav Item - Dashboard -->
			<li class="nav-item active"><a class="nav-link"
				href="index.html"> <i class="fas fa-fw fa-tachometer-alt"></i> <span>Dashboard</span></a>
			</li>

			<!-- Divider -->
			<hr class="sidebar-divider">

			<!-- Heading -->
			<div class="sidebar-heading">Management</div>

			<!-- Nav Item - Pages Collapse Menu -->
			<li class="nav-item"><a class="nav-link collapsed" href="#"
				data-toggle="collapse" data-target="#collapseTwo"
				aria-expanded="true" aria-controls="collapseTwo"> <i
					class="fas fa-fw fa-user"></i> <span>User Management</span>
			</a>
				<div id="collapseTwo" class="collapse" aria-labelledby="headingTwo"
					data-parent="#accordionSidebar">
					<div class="bg-white py-2 collapse-inner rounded">

						<a class="collapse-item" href="addemployee.html">Employee
							Management</a> <a class="collapse-item" href="employeehome.html">Customer
							Management</a> <a class="collapse-item" href="employeehome.html">Account
							Management</a>
					</div>
				</div></li>

			<!-- Nav Item - Pages Collapse Menu -->
			<li class="nav-item"><a class="nav-link collapsed" href="#"
				data-toggle="collapse" data-target="#collapseTwo"
				aria-expanded="true" aria-controls="collapseTwo"> <i
					class="fas fa-fw fa-user"></i> <span>Meter Profile
						Management</span>
			</a>
				<div id="collapseTwo" class="collapse" aria-labelledby="headingTwo"
					data-parent="#accordionSidebar">
					<div class="bg-white py-2 collapse-inner rounded">

						<a class="collapse-item" href="addcustomer.html">Add Meter
							Profile</a> <a class="collapse-item" href="customerhome.html">Manage
							Meter Profile</a>
					</div>
				</div></li>

			<!-- Nav Item - Pages Collapse Menu -->
			<li class="nav-item"><a class="nav-link collapsed" href="#"
				data-toggle="collapse" data-target="#collapseTwo"
				aria-expanded="true" aria-controls="collapseTwo"> <i
					class="fas fa-fw fa-user"></i> <span>Consumer Management</span>
			</a>
				<div id="collapseTwo" class="collapse" aria-labelledby="headingTwo"
					data-parent="#accordionSidebar">
					<div class="bg-white py-2 collapse-inner rounded">

						<a class="collapse-item" href="addcustomer.html">Add Meter
							Profile</a> <a class="collapse-item" href="customerhome.html">Manage
							Meter Profile</a>
					</div>
				</div></li>

			<!-- Nav Item - Pages Collapse Menu -->
			<li class="nav-item"><a class="nav-link collapsed" href="#"
				data-toggle="collapse" data-target="#collapseTwo"
				aria-expanded="true" aria-controls="collapseTwo"> <i
					class="fas fa-fw fa-user"></i> <span>Payment Management</span>
			</a>
				<div id="collapseTwo" class="collapse" aria-labelledby="headingTwo"
					data-parent="#accordionSidebar">
					<div class="bg-white py-2 collapse-inner rounded">

						<a class="collapse-item" href="addcustomer.html">Add Payment
							Details</a> <a class="collapse-item" href="customerhome.html">Manage
							Payment Details</a>
					</div>
				</div></li>
			<!-- Nav Item - Pages Collapse Menu -->
			<li class="nav-item"><a class="nav-link collapsed" href="#"
				data-toggle="collapse" data-target="#collapseTwo"
				aria-expanded="true" aria-controls="collapseTwo"> <i
					class="fas fa-fw fa-user"></i> <span>Interruption Management</span>
			</a>
				<div id="collapseTwo" class="collapse" aria-labelledby="headingTwo"
					data-parent="#accordionSidebar">
					<div class="bg-white py-2 collapse-inner rounded">

						<a class="collapse-item" href="addcustomer.html">Add
							Interruption</a> <a class="collapse-item" href="customerhome.html">Manage
							Interruptions</a>
					</div>
				</div></li>
			<!-- Nav Item - Pages Collapse Menu -->
			<li class="nav-item"><a class="nav-link collapsed" href="#"
				data-toggle="collapse" data-target="#collapseTwo"
				aria-expanded="true" aria-controls="collapseTwo"> <i
					class="fas fa-fw fa-user"></i> <span>Complaint Management</span>
			</a>
				<div id="collapseTwo" class="collapse" aria-labelledby="headingTwo"
					data-parent="#accordionSidebar">
					<div class="bg-white py-2 collapse-inner rounded">

						<a class="collapse-item" href="addcustomer.html">Add Complaint</a>
						<a class="collapse-item" href="customerhome.html">Manage
							Complaints</a>
					</div>
				</div></li>


		</ul>
		<!-- End of Sidebar -->

		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">

			<!-- Main Content -->
			<div id="content">

				<!-- Topbar -->
				<nav
					class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

					<!-- Sidebar Toggle (Topbar) -->
					<button id="sidebarToggleTop"
						class="btn btn-link d-md-none rounded-circle mr-3">
						<i class="fa fa-bars"></i>
					</button>



					<ul class="navbar-nav ml-auto">

						<div class="topbar-divider d-none d-sm-block"></div>

						<!-- Nav Item - User Information -->
						<li class="nav-item dropdown no-arrow"><a
							class="nav-link dropdown-toggle" href="#" id="userDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> <span
								class="mr-2 d-none d-lg-inline text-gray-600 small">Janani
									Denipitiya</span> <img class="img-profile rounded-circle"
								src="img/undraw_profile.svg">
						</a> <!-- Dropdown - User Information -->
							<div
								class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
								aria-labelledby="userDropdown">
								<a class="dropdown-item" href="#"> <i
									class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i> Profile
								</a> <a class="dropdown-item" href="#"> <i
									class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>
									Settings
								</a> <a class="dropdown-item" href="#"> <i
									class="fas fa-list fa-sm fa-fw mr-2 text-gray-400"></i>
									Activity Log
								</a>
								<div class="dropdown-divider"></div>
								<a class="dropdown-item" href="#" data-toggle="modal"
									data-target="#logoutModal"> <i
									class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
									Logout
								</a>
							</div></li>

					</ul>

				</nav>
				<!-- End of Topbar -->

				<!-- Begin Page Content -->
				<div class="container-fluid">

					<div class="row">

						<!-- Area Chart -->
						<div class="col-xl-8 col-lg-7">
							<div class="card shadow mb-4">
								<!-- Card Header - Dropdown -->
								<div
									class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
									<h6 class="m-0 font-weight-bold text-primary">Earnings
										Overview</h6>

								</div>
								<!-- Card Body -->
								<div class="card-body"></div>
							</div>
						</div>

					</div>

				</div>
				<!-- /.container-fluid -->
				<!-- meter profile  -->
				<div class="container">
					<div class="row">
						<div class="panel">
							<div class="md-md offset-md">
								<div class="">
									<form class="form"
										action="http://localhost:8088/Meterprofile/myService/meterprofile/insert_postman"
										method=post>
										<div>
											<lablel for="" class="form-label">ID</lablel>
											<input type="text" class="form-control" id="id" name="id"
												aria-describedby="">
											<div id="" class="form-text"></div>

										</div>
										<div class="mb-3">

											<label for="meterprofile_name" class="form-label">Name</label>
											<input type="text" class="form-control" id="name" name="name"
												aria-describedby="emailHelp">
											<div id="emailHelp" class="form-text">We'll never share
												your email with anyone else.</div>
										</div>
										<div>
											<lablel for="" class="form-label">Connection Type</lablel>
											<input type="text" class="form-control" id="connection_type"
												name="connection_type" aria-describedby="">
											<div id="" class="form-text"></div>

										</div>
										<div>
											<lablel for="" class="form-label">Estimated Power
											Consuption</lablel>
											<input type="text" class="form-control"
												id="estimated_power_consumption"
												name="estimated_power_consumption" aria-describedby="">
											<div id="" class="form-text"></div>

										</div>
										<div>
											<lablel for="" class="form-label">Owner</lablel>
											<input type="text" class="form-control" id="owner"
												name="owner" aria-describedby="">
											<div id="" class="form-text"></div>

										</div>
										<div>
											<lablel for="" class="form-label">Initialized date</lablel>
											<input type="date" class="form-control" id="initialized_date"
												name="initialized_date" aria-describedby="">
											<div id="" class="form-text"></div>

										</div>
										<div>
											<lablel for="" class="form-label">Initialized
											Employee</lablel>
											<input type="text" class="form-control form-control-user"
												id="initialized_emp" name="initialized_emp"
												aria-describedby="">
											<div id="" class="form-text"></div>

										</div>
										<div>
											<lablel for="" class="form-label">Location</lablel>
											<input type="text" class="form-control form-control-user"
												id="location" name="location" aria-describedby="">
											<div id="" class="form-text"></div>

										</div>
										<div>
											<button id="submit" name="submit" class="btn btn-primary"
												value="save">Register MeterProfile</button>
										</div>
										<input type="hidden" id="hidMeterprofileSave" name="hidMeterprofileSave" value="">
										<input type="hidden" id="hidMeterprofileSave" name="hidMeterprofileSave" value=""> 
										<!--   MeterprofileDao meterDao= new MeterprofileDao();out.print(meterDao.selectAllMeterprofile()); -->

									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- meter profile  -->
			</div>
			<!-- End of Main Content -->

			<!-- Footer -->
			<footer class="sticky-footer bg-white">
				<div class="container my-auto">
					<div class="copyright text-center my-auto">
						<span> &copy; Electro Grid</span>
					</div>
				</div>
			</footer>
			<!-- End of Footer -->

		</div>
		<!-- End of Content Wrapper -->

	</div>
	<!-- End of Page Wrapper -->

	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i>
	</a>



	<!-- Logout Modal-->
	<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
					<button class="close" type="button" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">???</span>
					</button>
				</div>
				<div class="modal-body">Select "Logout" below if you are ready
					to end your current session.</div>
				<div class="modal-footer">
					<button class="btn btn-secondary" type="button"
						data-dismiss="modal">Cancel</button>
					<a class="btn btn-primary" href="login.html">Logout</a>
				</div>
			</div>
		</div>
	</div>

	<!-- Bootstrap core JavaScript-->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script src="vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Custom scripts for all pages-->
	<script src="js/sb-admin-2.min.js"></script>

	<!-- js -->
	<script src="js/sb-admin-2.min.js"></script>
	<script type="text/javascript">
	console.log("in side register");
	document.getElementById("submit").addEventListener("click", register);
	
	function generateID(){
		var ownerID = document.getElementByName('id');
	}
	function register(){
		console.log("in side register");
		var id = documetn.getElementByName('id');
		var name = documetn.getElementByName('name');
		var connection_type = documetn.getElementByName('connection_type');
		var estimated_power_consumption = documetn.getElementByName('estimated_power_consumption');
		var Owner = documetn.getElementByName('Owner');
		var initialized_date = documetn.getElementByName('initialized_date');
		var initialized_emp = documetn.getElementByName('initialized_emp');
		var location = documetn.getElementByName('location');
		
		var json = '{"id":"'+id+'","name":"'+name+'","register_date":"'+register+'","connection_type":"'
			+connection_type+'","estimated_power_consumption":"'+estimated_power_consumption+'","Owner":"'
			+Owner+'","initialized_date":"'+initialized_date+',"location":"'+location+'"}';			 
	
		console.log(json);
		//send api request
		postData('http://localhost:8088/Meterprofile/myService/meterprofile/insert', JSON.parse(json)) 
		  .then(data => {
		    console.log(data);
		    alert(JSON.parse(data).message);// JSON data parsed by `data.json()` call
		  });
	}
	
	<script src="Components/jquery.min.js" type="text/javascript"></script>
	<script src="Components/meterprofile.js" type="text/javascript"></script>
	</script>
</body>

</html>