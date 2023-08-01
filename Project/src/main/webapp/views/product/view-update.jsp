<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 8/1/2023
  Time: 12:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container mx-auto">
    <div class="col-8 offset-2 mt-5 table-responsive">
        <h1 class="text-center">Update Product</h1>
        <br>
        <form method="POST" action="/product/update?id=${product.id}" id="formAddProduct">
            <div class="form-group">
                <label for="inputText3" class="col-form-label">Name: </label>
                <input id="inputText3" name="name" rules="required|min:3" value="${product.productName}"
                       type="text" class="form-control">
                <span class="form-message"></span>
            </div>
            <div class="form-group">
                <label for="inputText3" class="col-form-label">Status: </label>
                <label class="custom-control custom-radio custom-control-inline">
                    <input type="radio" name="status" value="1" ${product.status == 1 ? "checked" : ""} class="custom-control-input">
                    <span class="custom-control-label">Còn kinh doanh</span>
                </label>
                <label class="custom-control custom-radio custom-control-inline">
                    <input type="radio" name="status" value="0" ${product.status == 0 ? "checked" : ""} class="custom-control-input">
                    <span class="custom-control-label">Ngừng kinh doanh</span>
                </label>
            </div>
            <button class="btn btn-primary" type="submit">Update</button>
        </form>
    </div>
</div>
<%--    Script--%>
<script src="../../js/validator.js"></script>
<script>
    Validator('#formAddProduct');
</script>
</body>
</html>
