package com.poly.ph21738.controllers;

import com.poly.ph21738.entities.Ram;
import com.poly.ph21738.services.impl.RamServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "RamServlet", value = {
        "/ram/view-all",
        "/ram/view-add",
        "/ram/view-update",
        "/ram/add",
        "/ram/update",
        "/ram/remove"
})
public class RamServlet extends HttpServlet {
    private RamServiceImpl ramService = new RamServiceImpl();
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
        Ram ram = ramService.findById(UUID.fromString(request.getParameter("id")));
        ramService.delete(ram);
        response.sendRedirect("/ram/view-all");
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Ram ram = ramService.findById(UUID.fromString(request.getParameter("id")));
        request.setAttribute("ram", ram);
        request.setAttribute("content","/views/ram/view-update.jsp");
        request.getRequestDispatcher("/layout/index.jsp").forward(request,response);
    }

    private void viewAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("content","/views/ram/view-create.jsp");
        request.getRequestDispatcher("/layout/index.jsp").forward(request,response);
    }

    private void viewAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Ram> ramList = ramService.findAll();
        System.out.println(ramList.toString());

        request.setAttribute("ramList", ramList);
        request.setAttribute("content","/views/ram/view-all.jsp");
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
        String code = String.valueOf("RO"+System.currentTimeMillis());
        Ram ram = ramService.findById(UUID.fromString(request.getParameter("id")));
        ram.setUpdatedAt(new Date());
        ram.setRamCode(code);
        ram.setRamName(name);
        ram.setStatus(status);
        ramService.update(ram);
        response.sendRedirect("/ram/view-all");
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        Integer status = Integer.parseInt(request.getParameter("status"));
        String code = String.valueOf("RA"+System.currentTimeMillis());
        System.out.println(code);
        Ram ram = new Ram();
        ram.setRamCode(code);
        ram.setRamName(name);
        ram.setStatus(status);
        ramService.add(ram);
        response.sendRedirect("/ram/view-all");
    }
}
