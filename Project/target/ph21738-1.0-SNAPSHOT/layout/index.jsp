<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 7/31/2023
  Time: 3:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Tiêu đề website sẽ để ở đây</title>
    <link rel="stylesheet" href="../static/assets/vendor/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="../static/assets/vendor/fonts/circular-std/style.css">
    <link rel="stylesheet" href="../static/assets/libs/css/style.css">
    <link rel="stylesheet" href="../static/assets/vendor/fonts/fontawesome/css/fontawesome-all.css">
</head>
<body>
<!-- ============================================================== -->
<!-- main wrapper -->
<!-- ============================================================== -->
<div class="dashboard-main-wrapper">
    <!-- ============================================================== -->
    <!-- navbar -->
    <!-- ============================================================== -->
    <div class="dashboard-header">
        <nav class="navbar navbar-expand-lg bg-white fixed-top">
            <a class="navbar-brand" href="../index.html">Admin_VDT</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse " id="navbarSupportedContent">
                <ul class="navbar-nav ml-auto navbar-right-top">
                    <li class="nav-item">
                        <div id="custom-search" class="top-search-bar">
                            <input class="form-control" type="text" placeholder="Search..">
                        </div>
                    </li>
                    <li class="nav-item dropdown nav-user">
                        <a class="nav-link nav-user-img" href="#" id="navbarDropdownMenuLink2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><img src="../assets/images/avatar-1.jpg" alt="" class="user-avatar-md rounded-circle"></a>
                        <div class="dropdown-menu dropdown-menu-right nav-user-dropdown" aria-labelledby="navbarDropdownMenuLink2">
                            <div class="nav-user-info">
                                <h5 class="mb-0 text-white nav-user-name">
                                    John Abraham</h5>
                                <span class="status"></span><span class="ml-2">Available</span>
                            </div>
                            <a class="dropdown-item" href="#"><i class="fas fa-user mr-2"></i>Account</a>
                            <a class="dropdown-item" href="#"><i class="fas fa-cog mr-2"></i>Setting</a>
                            <a class="dropdown-item" href="#"><i class="fas fa-power-off mr-2"></i>Logout</a>
                        </div>
                    </li>
                </ul>
            </div>
        </nav>
    </div>
    <!-- ============================================================== -->
    <!-- end navbar -->
    <!-- ============================================================== -->
    <!-- ============================================================== -->
    <!-- left sidebar -->
    <!-- ============================================================== -->
    <div class="nav-left-sidebar sidebar-dark">
        <div class="menu-list">
            <div class="nav-left-sidebar sidebar-dark">
                <div class="menu-list">
                    <nav class="navbar navbar-expand-lg navbar-light">
                        <a class="d-xl-none d-lg-none" href="#">Dashboard</a>
                        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
                                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                            <span class="navbar-toggler-icon"></span>
                        </button>
                        <div class="collapse navbar-collapse" id="navbarNav">
                            <ul class="navbar-nav flex-column">
                                <li class="nav-divider">
                                    Menu
                                </li>
                                <li class="nav-item ">
                                    <a class="nav-link active" href="#" data-toggle="collapse" aria-expanded="false"
                                       data-target="#submenu-1" aria-controls="submenu-1">
                                        <i class="fa fa-fw fa-user-circle"></i>
                                        Information Manage
                                        <span class="badge badge-success">6</span></a>
                                    <div id="submenu-1" class="collapse submenu" style="">
                                        <ul class="nav flex-column">
                                            <li class="nav-item">
                                                <a class="nav-link" href="index.html" data-toggle="collapse" aria-expanded="false"
                                                   data-target="#submenu-1-2" aria-controls="submenu-1-2">
                                                    Product Information
                                                </a>
                                                <div id="submenu-1-2" class="collapse submenu" style="">
                                                    <ul class="nav flex-column">
                                                        <li class="nav-item">
                                                            <a class="nav-link" href="#">Products</a>
                                                        </li>
                                                        <li class="nav-item">
                                                            <a class="nav-link" href="#">Brands</a>
                                                        </li>
                                                        <li class="nav-item">
                                                            <a class="nav-link" href="#">Chips</a>
                                                        </li>
                                                        <li class="nav-item">
                                                            <a class="nav-link" href="#">Rams</a>
                                                        </li>
                                                        <li class="nav-item">
                                                            <a class="nav-link" href="#">Roms</a>
                                                        </li>
                                                        <li class="nav-item">
                                                            <a class="nav-link" href="#">Rams</a>
                                                        </li>
                                                        <li class="nav-item">
                                                            <a class="nav-link" href="#">Batteries</a>
                                                        </li>
                                                        <li class="nav-item">
                                                            <a class="nav-link" href="#">Product Details</a>
                                                        </li>
                                                    </ul>
                                                </div>
                                            </li>
                                        </ul>
                                    </div>
                                </li>
                                <li class="nav-item ">
                                    <a class="nav-link active" href="#" data-toggle="collapse" aria-expanded="false"
                                       data-target="#submenu-2" aria-controls="submenu-1">
                                        <i class="fa fa-fw fa-user-circle"></i>
                                        Sales Manager
                                        <span class="badge badge-success">6</span></a>
                                    <div id="submenu-2" class="collapse submenu" style="">
                                        <ul class="nav flex-column">
                                            <li class="nav-item">
                                                <a class="nav-link" href="#">Bills</a>
                                            </li>
                                            <li class="nav-item">
                                                <a class="nav-link" href="#">Discounts</a>
                                            </li>
                                        </ul>
                                    </div>
                                </li>
                                <li class="nav-item ">
                                    <a class="nav-link active" href="#" data-toggle="collapse" aria-expanded="false"
                                       data-target="#submenu-3" aria-controls="submenu-1">
                                        <i class="fa fa-fw fa-user-circle"></i>
                                        Account Manager
                                        <span class="badge badge-success">6</span></a>
                                    <div id="submenu-3" class="collapse submenu" style="">
                                        <ul class="nav flex-column">
                                            <li class="nav-item">
                                                <a class="nav-link" href="#">Staffs</a>
                                            </li>
                                        </ul>
                                        <ul class="nav flex-column">
                                            <li class="nav-item">
                                                <a class="nav-link" href="#">Customers</a>
                                            </li>
                                        </ul>
                                    </div>
                                </li>
                            </ul>
                        </div>
                    </nav>
                </div>
            </div>
        </div>
    </div>
    <!-- ============================================================== -->
    <!-- end left sidebar -->
    <!-- ============================================================== -->
    <!-- ============================================================== -->
    <!-- wrapper  -->
    <!-- ============================================================== -->
    <div class="dashboard-wrapper">
        <div class="container-fluid dashboard-content">
            <div class="row">
                <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                    <jsp:include page="${content}"></jsp:include>
                </div>
            </div>
        </div>
        <!-- ============================================================== -->
        <!-- footer -->
        <!-- ============================================================== -->
        <div class="footer">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-xl-6 col-lg-6 col-md-12 col-sm-12 col-12">
                        Copyright © 2023 Concept. TrungVDPH21738
                    </div>
                    <div class="col-xl-6 col-lg-6 col-md-12 col-sm-12 col-12">
                        <div class="text-md-right footer-links d-none d-sm-block">
                            <a href="javascript: void(0);">About</a>
                            <a href="javascript: void(0);">Support</a>
                            <a href="javascript: void(0);">Contact Us</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- ============================================================== -->
        <!-- end footer -->
        <!-- ============================================================== -->
    </div>
</div>
<!-- ============================================================== -->
<!-- end main wrapper -->
<link rel="stylesheet" href="../static/assets/vendor/jquery/jquery-3.3.1.min.js">
<script src="/static/assets/vendor/jquery/jquery-3.3.1.min.js"></script>
<script src="/static/assets/vendor/bootstrap/js/bootstrap.bundle.js"></script>
<script src="/static/assets/vendor/slimscroll/jquery.slimscroll.js"></script>
<script src="/static/assets/libs/js/main-js.js"></script>
<script src="../js/validator.js"></script>
</body>
</html>
