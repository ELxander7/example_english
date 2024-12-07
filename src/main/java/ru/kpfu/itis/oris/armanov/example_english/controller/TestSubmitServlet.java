package ru.kpfu.itis.oris.armanov.example_english.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "TestSubmitServlet", value = "/testSubmit")
public class TestSubmitServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession(true);

        System.out.println(req.getParameter("total"));
    }
}