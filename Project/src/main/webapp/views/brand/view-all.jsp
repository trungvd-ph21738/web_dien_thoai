<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 7/31/2023
  Time: 1:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../../static/assets/vendor/bootstrap/css/bootstrap.min.css">
    <link href="../../static/assets/vendor/fonts/circular-std/style.css" rel="stylesheet">
    <link rel="stylesheet" href="../../static/assets/libs/css/style.css">
    <link rel="stylesheet" href="../../static/assets/vendor/fonts/fontawesome/css/fontawesome-all.css">
    <link rel="stylesheet" type="text/css" href="../../static/assets/vendor/datatables/css/dataTables.bootstrap4.css">
    <link rel="stylesheet" type="text/css" href="../../static/assets/vendor/datatables/css/buttons.bootstrap4.css">
    <link rel="stylesheet" type="text/css" href="../../static/assets/vendor/datatables/css/select.bootstrap4.css">
    <link rel="stylesheet" type="text/css" href="../../static/assets/vendor/datatables/css/fixedHeader.bootstrap4.css">
</head>
<body>
<div>
    <div class="row">
        <!-- ============================================================== -->
        <!-- basic table  -->
        <!-- ============================================================== -->
        <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
            <a href="/brand/view-add" class="btn btn-primary mb-3">Add Brand</a>
            <div class="card">
                <h5 class="card-header">Brand Table</h5>
                <div class="card-body">
                    <div class="table-responsive">
                        <table class="table table-striped table-bordered first">
                            <thead>
                            <tr>
                                <th>#</th>
                                <th>Code</th>
                                <th>Name</th>
                                <th>Create Date</th>
                                <th>Update Date</th>
                                <th>Status</th>
                                <th>Action</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${brandList}" var="brand" varStatus="item">
                                <tr>
                                    <td>${item.index+1}</td>
                                    <td>${brand.brandCode}</td>
                                    <td>${brand.brandName}</td>
                                    <td>${brand.createdAt}</td>
                                    <td>${brand.updatedAt}</td>
                                    <td>
                                        <c:if test="${brand.status == 1}">
                                            <span class="badge badge-success">Còn kinh doanh</span>
                                        </c:if>
                                        <c:if test="${brand.status == 0}">
                                            <span class="badge badge-danger">Dừng kinh doanh</span>
                                        </c:if>
                                    </td>
                                    <td>
                                        <a href="/brand/view-update?id=${brand.id}" class="btn btn-brand">Update</a>
                                        <a href="/brand/remove?id=${brand.id}" class="btn btn-danger">Delete</a>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                            <tfoot>
                            <tr>
                                <th>#</th>
                                <th>Code</th>
                                <th>Name</th>
                                <th>Create Date</th>
                                <th>Update Date</th>
                                <th>Status</th>
                                <th>Action</th>
                            </tr>
                            </tfoot>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        <!-- ============================================================== -->
        <!-- end basic table  -->
        <!-- ============================================================== -->
    </div>
</div>
<!-- Optional JavaScript -->
<script src="../../static/assets/vendor/jquery/jquery-3.3.1.min.js"></script>
<script src="../../static/assets/vendor/bootstrap/js/bootstrap.bundle.js"></script>
<script src="../../static/assets/vendor/slimscroll/jquery.slimscroll.js"></script>
<script src="../../static/assets/vendor/multi-select/js/jquery.multi-select.js"></script>
<script src="../../static/assets/libs/js/main-js.js"></script>
<script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
<script src="../../static/assets/vendor/datatables/js/dataTables.bootstrap4.min.js"></script>
<script src="https://cdn.datatables.net/buttons/1.5.2/js/dataTables.buttons.min.js"></script>
<script src="../../static/assets/vendor/datatables/js/buttons.bootstrap4.min.js"></script>
<script src="../../static/assets/vendor/datatables/js/data-table.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.36/pdfmake.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.36/vfs_fonts.js"></script>
<script src="https://cdn.datatables.net/buttons/1.5.2/js/buttons.html5.min.js"></script>
<script src="https://cdn.datatables.net/buttons/1.5.2/js/buttons.print.min.js"></script>
<script src="https://cdn.datatables.net/buttons/1.5.2/js/buttons.colVis.min.js"></script>
<script src="https://cdn.datatables.net/rowgroup/1.0.4/js/dataTables.rowGroup.min.js"></script>
<script src="https://cdn.datatables.net/select/1.2.7/js/dataTables.select.min.js"></script>
<script src="https://cdn.datatables.net/fixedheader/3.1.5/js/dataTables.fixedHeader.min.js"></script>
</body>
</html>
