package com.poly.ph21738.controllers;

import com.poly.ph21738.entities.Battery;
import com.poly.ph21738.services.impl.BatteryServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "BatteryServlet", value = {
        "/battery/view-all",
        "/battery/view-add",
        "/battery/view-update",
        "/battery/add",
        "/battery/update",
        "/battery/remove"
})
public class BatteryServlet extends HttpServlet {
    private BatteryServiceImpl batteryService = new BatteryServiceImpl();

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
        Battery battery = batteryService.findById(UUID.fromString(request.getParameter("id")));
        batteryService.delete(battery);
        response.sendRedirect("/battery/view-all");
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Battery battery = batteryService.findById(UUID.fromString(request.getParameter("id")));
        request.setAttribute("battery", battery);
        request.setAttribute("content", "/views/battery/view-update.jsp");
        request.getRequestDispatcher("/layout/index.jsp").forward(request, response);
    }

    private void viewAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("content", "/views/battery/view-create.jsp");
        request.getRequestDispatcher("/layout/index.jsp").forward(request, response);
    }

    private void viewAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Battery> batteryList = batteryService.findAll();
        request.setAttribute("batteryList", batteryList);
        request.setAttribute("content", "/views/battery/view-all.jsp");
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
        String code = String.valueOf("BA" + System.currentTimeMillis());
        Battery battery = batteryService.findById(UUID.fromString(request.getParameter("id")));
        battery.setUpdatedAt(new Date());
        battery.setPinCode(code);
        battery.setPinName(name);
        battery.setStatus(status);
        batteryService.update(battery);
        response.sendRedirect("/battery/view-all");
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        Integer status = Integer.parseInt(request.getParameter("status"));
        String code = String.valueOf("BA" + System.currentTimeMillis());
        Battery battery = new Battery();
        battery.setPinCode(code);
        battery.setPinName(name);
        battery.setStatus(status);
        batteryService.add(battery);
        response.sendRedirect("/battery/view-all");
    }
}
