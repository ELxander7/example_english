package ru.kpfu.itis.oris.armanov.example_english.controller;

import ru.kpfu.itis.oris.armanov.example_english.dao.TestTypeDao;
import ru.kpfu.itis.oris.armanov.example_english.entity.TestType;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "TestScreenServlet", value = "/test-screen")
public class TestScreenServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.getRequestDispatcher("/testScreen.jsp").forward(req,res);
    }
}
