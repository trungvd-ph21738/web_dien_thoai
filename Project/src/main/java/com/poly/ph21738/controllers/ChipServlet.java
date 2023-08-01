package com.poly.ph21738.controllers;

import com.poly.ph21738.entities.Chip;
import com.poly.ph21738.services.impl.ChipServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "ChipServlet", value = {
        "/chip/view-all",
        "/chip/view-add",
        "/chip/view-update",
        "/chip/add",
        "/chip/update",
        "/chip/remove"
})
public class ChipServlet extends HttpServlet {
    private ChipServiceImpl chipService = new ChipServiceImpl();

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
        Chip chip = chipService.findById(UUID.fromString(request.getParameter("id")));
        chipService.delete(chip);
        response.sendRedirect("/chip/view-all");
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Chip chip = chipService.findById(UUID.fromString(request.getParameter("id")));
        request.setAttribute("chip", chip);
        request.setAttribute("content", "/views/chip/view-update.jsp");
        request.getRequestDispatcher("/layout/index.jsp").forward(request, response);
    }

    private void viewAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("content", "/views/chip/view-create.jsp");
        request.getRequestDispatcher("/layout/index.jsp").forward(request, response);
    }

    private void viewAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Chip> chipList = chipService.findAll();
        System.out.println(chipList.toString());
        request.setAttribute("chipList", chipList);
        request.setAttribute("content", "/views/chip/view-all.jsp");
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
        String code = String.valueOf("CP" + System.currentTimeMillis());
        Chip chip = chipService.findById(UUID.fromString(request.getParameter("id")));
        chip.setUpdatedAt(new Date());
        chip.setChipCode(code);
        chip.setChipName(name);
        chip.setStatus(status);
        chipService.update(chip);
        response.sendRedirect("/chip/view-all");
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        Integer status = Integer.parseInt(request.getParameter("status"));
        String code = String.valueOf("CP" + System.currentTimeMillis());
        System.out.println(code);
        Chip chip = new Chip();
        chip.setChipCode(code);
        chip.setChipName(name);
        chip.setStatus(status);
        chipService.add(chip);
        response.sendRedirect("/chip/view-all");
    }
}
