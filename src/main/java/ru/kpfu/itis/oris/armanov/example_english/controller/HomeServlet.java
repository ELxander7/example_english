package ru.kpfu.itis.oris.armanov.example_english.controller;

import ru.kpfu.itis.oris.armanov.example_english.dao.TestTypeDao;
import ru.kpfu.itis.oris.armanov.example_english.entity.TestType;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "HomeServlet", value = "/home")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession(true);

        TestTypeDao dao = new TestTypeDao();
        List<TestType> qtList = dao.getTestTypes();
        session.setAttribute("testTypeList", qtList);
        req.getRequestDispatcher("/home-page").forward(req, res);
    }
}