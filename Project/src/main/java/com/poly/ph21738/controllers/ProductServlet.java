package com.poly.ph21738.controllers;

import com.poly.ph21738.entities.Product;
import com.poly.ph21738.services.impl.ProductServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "ProductServlet", value = {
        "/product/view-all",
        "/product/view-add",
        "/product/view-update",
        "/product/add",
        "/product/update",
        "/product/remove"
})
public class ProductServlet extends HttpServlet {
    private ProductServiceImpl productService = new ProductServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("view-all")){
            this.viewAll(request,response);
        } else if(uri.contains("view-add")){
            this.viewAdd(request, response);
        } else if(uri.contains("view-update")){
            this.viewUpdate(request, response);
        } else if(uri.contains("remove")){
            this.remove(request,response);
        }
    }

    private void remove(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Product product = productService.findById(UUID.fromString(request.getParameter("id")));
        productService.delete(product);
        response.sendRedirect("/product/view-all");
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Product product = productService.findById(UUID.fromString(request.getParameter("id")));
        request.setAttribute("product", product);
        request.setAttribute("content","/views/product/view-update.jsp");
        request.getRequestDispatcher("/layout/index.jsp").forward(request,response);
    }

    private void viewAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("content","/views/product/view-create.jsp");
        request.getRequestDispatcher("/layout/index.jsp").forward(request,response);
    }

    private void viewAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> productList = productService.findAll();
        request.setAttribute("productList", productList);
        request.setAttribute("content","/views/product/view-all.jsp");
        request.getRequestDispatcher("/layout/index.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("add")){
            this.add(request,response);
        } else if(uri.contains("update")){
            this.update(request,response);
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        Integer status = Integer.parseInt(request.getParameter("status"));
        Date update_at = new Date();
        Product product = productService.findById(UUID.fromString(request.getParameter("id")));
        product.setUpdatedAt(update_at);
        product.setProductName(name);
        product.setStatus(status);
        productService.update(product);
        response.sendRedirect("/product/view-all");
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        Integer status = Integer.parseInt(request.getParameter("status"));
        String code = String.valueOf("SP"+System.currentTimeMillis());
        System.out.println(code);
        Product product = new Product();
        product.setProductCode(code);
        product.setProductName(name);
        product.setStatus(status);
        System.out.println(product.toString());
        productService.add(product);
        response.sendRedirect("/product/view-all");
    }
}
