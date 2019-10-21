<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Theme style -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/adminlte/dist/css/AdminLTE.min.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/adminlte/bower_components/bootstrap/dist/css/bootstrap.min.css" type="text/css">
<!-- Font Awesome -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/adminlte/bower_components/font-awesome/css/font-awesome.min.css" type="text/css">

<!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/adminlte/dist/css/skins/_all-skins.min.css" type="text/css">
<title>IMC</title>
</head>

<body class="hold-transition skin-blue sidebar-mini "
	style="font-family: 'Fira Sans';">
	<div class="wrapper">

		<header class="main-header">
			<!-- Logo -->
			<a href="index" class="logo"> <!-- mini logo for sidebar mini 50x50 pixels -->
				<span class="logo-mini"><strong>IMC</i></strong></span> <!-- logo for regular state and mobile devices -->
				<span class="logo-lg"><strong>IMC</strong></span>
			</a>
			<!-- Header Navbar -->
			<nav class="navbar navbar-static-top">
				<!-- Sidebar toggle button-->
				<a href="#" class="sidebar-toggle" data-toggle="push-menu"
					role="button"> <span class="sr-only">Toggle navigation</span>
				</a>



			</nav>
		</header>

		<!-- Left side column. contains the logo and sidebar -->

		<aside class="main-sidebar">
			<!-- sidebar: style can be found in sidebar.less -->
			<section class="sidebar">
				<!-- sidebar menu: : style can be found in sidebar.less -->
				<ul class="sidebar-menu" data-widget="tree">
					<li class="header">MAIN NAVIGATION</li>
					<li class="active treeview"><a href="#"> <i
							class="fa fa-dashboard"></i> <span>Calculateur</span> <span
							class="pull-right-container"> <i
								class="fa fa-angle-left pull-right"></i>
						</span>
					</a>
						<ul class="treeview-menu">
							<li class="active"><a href="index.jsp"><i
									class="fa fa-bar-chart"></i> IMC</a></li>
						</ul></li>


				</ul>
			</section>
			<!-- /.sidebar -->

		</aside>

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->

			<section class="content-header"></section>

			<!-- Main content -->

			<section class="content">
				<div class="row">
					<div class="col-lg-6 col-md-6 col-sm-6">
						<div class="box box-info">
							<div class="box-header with-border">
								<h3 class="box-title">Calculateur IMC</h3>
							</div>
							<!-- /.box-header -->
							<!-- form start -->
							<form class="form-horizontal" method="post"
								action="ImcController">
								<div class="box-body">
									<c:if test="${error}">
						<p><strong style="color:red;">${message}</strong></p>
						
						</c:if>
									<div class="form-group">
										<label for="inputweight" class="col-sm-2 control-label">Poids(Kg)</label>

										<div class="col-sm-10">
											<input type="text" name="weight" class="form-control" id="weight" placeholder="Poids"  required >
										</div>
									</div>
									<div class="form-group">
										<label for="inputheight" class="col-sm-2 control-label">Taille(m)</label>

										<div class="col-sm-10">
											<input type="text" name="height" class="form-control" id="height"placeholder="Taille"  required>
										</div>
									</div>

								</div>
								<!-- /.box-body -->
								<div class="box-footer">
									<button type="submit" name="calculer"
										class="btn btn-info pull-left">Calculer</button>
									
								</div>
								<!-- /.box-footer -->
							</form>

						</div>
					</div>
					<div class="col-lg-4 col-md-4 col-sm-4">
						<c:if test="${not empty imc}">
							<div class="info-box">
								<c:if test="${isok}">
									<span class="info-box-icon bg-green"><i
										style="margin-top: 20px;" class="fa fa-thumbs-o-up"></i></span>
								</c:if>
								<c:if test="${!isok}">
									<span class="info-box-icon bg-red"><i
										style="margin-top: 20px;" class="fa fa-exclamation-triangle"></i></span>
								</c:if>

								<div class="info-box-content">
								
									<span class="info-box-text">Votre IMC est:</span> <span
										name="imc" value="${imc}" class="info-box-number">${imc}</span>
									
								</div>
								<!-- /.info-box-content -->
							</div>
						</c:if>
					</div>
					
				</div>
				<div class="row">
				<div class="col-lg-offset-5 col-lg-2 col-md-offset-5 col-md-2 col-sm-offset-5 col-sm-2">
						<c:if test="${not empty img}">
						<p><strong>${message}</strong></p>
						<img style="margin-left:15px;" src="${pageContext.request.contextPath}/img/${img}" width="54px" height="auto">
						
						</c:if>
					
				</div>
				</div>
			</section>
			<!-- /.content -->

		</div>
		<!-- /.content-wrapper -->
		<!-- Footer -->
		
		<footer class="main-footer h5">
			<div class="inset pull-right hidden-xs">Version 1.0</div>
			<div class="inset">IMC Calculateur</div>
		</footer>


	</div>
	<!-- ./wrapper -->


	<!-- jQuery 3 -->
	<script src="${pageContext.request.contextPath}/adminlte/bower_components/jquery/dist/jquery.min.js"></script>
	<!-- jQuery UI 1.11.4 -->
	<script src="${pageContext.request.contextPath}/adminlte/bower_components/jquery-ui/jquery-ui.min.js"></script>
	<!-- Bootstrap 3.3.7 -->
	<script src="${pageContext.request.contextPath}/adminlte/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/adminlte/dist/js/adminlte.min.js"></script>
</body>
</html>