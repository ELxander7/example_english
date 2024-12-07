package ru.kpfu.itis.oris.armanov.example_english.controller;

import ru.kpfu.itis.oris.armanov.example_english.dao.TestDao;
import ru.kpfu.itis.oris.armanov.example_english.dao.TestTypeDao;
import ru.kpfu.itis.oris.armanov.example_english.entity.Test;
import ru.kpfu.itis.oris.armanov.example_english.entity.TestType;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "TestServlet", value = "/test")
public class TestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession(true);

        // res.setHeader("Set-Cookie","JSESSIONID=" + session.getId());
        if (session.getAttribute("test") == null) {
            int id = Integer.parseInt(req.getParameter("testTypeId"));
            int page = Integer.parseInt(req.getParameter("page"));
            TestDao dao = new TestDao();
            Test test = dao.getTest(id);
            session.setAttribute("test", test);
            session.setAttribute("page",1);
        } else {
            session.setAttribute("page", req.getParameter("page"));
            session.setAttribute("questionId", req.getParameter("questionId"));
            System.out.println(req.getParameter("questionId"));
        }
        req.getRequestDispatcher("/test-screen").forward(req,res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        System.out.println(req.getParameter("testTypeId"));
        System.out.println(req.getParameter("page"));
        System.out.println(req.getParameter("questionId"));

    }

}
