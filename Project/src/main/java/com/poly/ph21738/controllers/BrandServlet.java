package com.poly.ph21738.controllers;

import com.poly.ph21738.entities.Brand;
import com.poly.ph21738.services.impl.BrandServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "BrandServlet", value = {
        "/brand/view-all",
        "/brand/view-add",
        "/brand/view-update",
        "/brand/add",
        "/brand/update",
        "/brand/remove"
})
public class BrandServlet extends HttpServlet {
    private BrandServiceImpl brandService = new BrandServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("view-all")) {
            this.viewAll(request, response);
        } else if (uri.contains("view-add")) {
            this.viewAdd(request, response);
        } else if (uri.contains("view-update")) {
            this.viewUpdate(request, response);
        } else if (uri.contains("remove")) {
            this.remove(request, response);
        }
    }

    private void remove(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Brand brand = brandService.findById(UUID.fromString(request.getParameter("id")));
        brandService.delete(brand);
        response.sendRedirect("/brand/view-all");
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Brand brand = brandService.findById(UUID.fromString(request.getParameter("id")));
        request.setAttribute("brand", brand);
        request.setAttribute("content", "/views/brand/view-update.jsp");
        request.getRequestDispatcher("/layout/index.jsp").forward(request, response);
    }

    private void viewAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("content", "/views/brand/view-create.jsp");
        request.getRequestDispatcher("/layout/index.jsp").forward(request, response);
    }

    private void viewAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Brand> brandList = brandService.findAll();
        System.out.println(brandList.toString());

        request.setAttribute("brandList", brandList);
        request.setAttribute("content", "/views/brand/view-all.jsp");
        request.getRequestDispatcher("/layout/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("add")) {
            this.add(request, response);
        } else if (uri.contains("update")) {
            this.update(request, response);
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        Integer status = Integer.parseInt(request.getParameter("status"));
        String code = String.valueOf("BR" + System.currentTimeMillis());
        Brand brand = brandService.findById(UUID.fromString(request.getParameter("id")));
        brand.setUpdatedAt(new Date());
        brand.setBrandCode(code);
        brand.setBrandName(name);
        brand.setStatus(status);
        brandService.update(brand);
        response.sendRedirect("/brand/view-all");
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        Integer status = Integer.parseInt(request.getParameter("status"));
        String code = String.valueOf("BR" + System.currentTimeMillis());
        System.out.println(code);
        Brand brand = new Brand();
        brand.setBrandCode(code);
        brand.setBrandName(name);
        brand.setStatus(status);
        brandService.add(brand);
        response.sendRedirect("/brand/view-all");
    }
}

