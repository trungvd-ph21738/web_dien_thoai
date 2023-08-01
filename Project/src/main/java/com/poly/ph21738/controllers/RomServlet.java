package com.poly.ph21738.controllers;

import com.poly.ph21738.entities.Rom;
import com.poly.ph21738.services.impl.RomServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "RomServlet", value = {
        "/rom/view-all",
        "/rom/view-add",
        "/rom/view-update",
        "/rom/add",
        "/rom/update",
        "/rom/remove"
})
public class RomServlet extends HttpServlet {
    private RomServiceImpl romService = new RomServiceImpl();
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
        Rom rom = romService.findById(UUID.fromString(request.getParameter("id")));
        romService.delete(rom);
        response.sendRedirect("/rom/view-all");
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Rom rom = romService.findById(UUID.fromString(request.getParameter("id")));
        request.setAttribute("rom", rom);
        request.setAttribute("content","/views/rom/view-update.jsp");
        request.getRequestDispatcher("/layout/index.jsp").forward(request,response);
    }

    private void viewAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("content","/views/rom/view-create.jsp");
        request.getRequestDispatcher("/layout/index.jsp").forward(request,response);
    }

    private void viewAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Rom> romList = romService.findAll();
        System.out.println(romList.toString());

        request.setAttribute("romList", romList);
        request.setAttribute("content","/views/rom/view-all.jsp");
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
        Rom rom = romService.findById(UUID.fromString(request.getParameter("id")));
        rom.setUpdatedAt(new Date());
        rom.setRomCode(code);
        rom.setRomName(name);
        rom.setStatus(status);
        romService.update(rom);
        response.sendRedirect("/rom/view-all");
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        Integer status = Integer.parseInt(request.getParameter("status"));
        String code = String.valueOf("RO"+System.currentTimeMillis());
        System.out.println(code);
        Rom rom = new Rom();
        rom.setRomCode(code);
        rom.setRomName(name);
        rom.setStatus(status);
        romService.add(rom);
        response.sendRedirect("/rom/view-all");
    }
}
