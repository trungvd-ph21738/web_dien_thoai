package com.poly.ph21738.controllers;

import com.poly.ph21738.entities.Color;
import com.poly.ph21738.services.impl.ColorServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "ColorServlet", value = {
        "/color/view-all",
        "/color/view-add",
        "/color/view-update",
        "/color/add",
        "/color/update",
        "/color/remove"
})
public class ColorServlet extends HttpServlet {
    private ColorServiceImpl colorService = new ColorServiceImpl();

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
        Color color = colorService.findById(UUID.fromString(request.getParameter("id")));
        colorService.delete(color);
        response.sendRedirect("/color/view-all");
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Color color = colorService.findById(UUID.fromString(request.getParameter("id")));
        request.setAttribute("color", color);
        request.setAttribute("content", "/views/color/view-update.jsp");
        request.getRequestDispatcher("/layout/index.jsp").forward(request, response);
    }

    private void viewAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("content", "/views/color/view-create.jsp");
        request.getRequestDispatcher("/layout/index.jsp").forward(request, response);
    }

    private void viewAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Color> colorList = colorService.findAll();
        request.setAttribute("colorList", colorList);
        request.setAttribute("content", "/views/color/view-all.jsp");
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
        String code = String.valueOf("CL" + System.currentTimeMillis());
        Color color = colorService.findById(UUID.fromString(request.getParameter("id")));
        color.setUpdatedAt(new Date());
        color.setColorCode(code);
        color.setColorName(name);
        color.setStatus(status);
        colorService.update(color);
        response.sendRedirect("/color/view-all");
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        Integer status = Integer.parseInt(request.getParameter("status"));
        String code = String.valueOf("CL" + System.currentTimeMillis());
        Color color = new Color();
        color.setColorCode(code);
        color.setColorName(name);
        color.setStatus(status);
        colorService.add(color);
        response.sendRedirect("/color/view-all");
    }
}
