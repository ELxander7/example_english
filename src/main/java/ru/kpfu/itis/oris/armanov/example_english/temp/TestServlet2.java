package ru.kpfu.itis.oris.armanov.example_english.temp;

import ru.kpfu.itis.oris.armanov.example_english.dao.TestDao;
import ru.kpfu.itis.oris.armanov.example_english.entity.Test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "TestServlet2", value = "/test2")
public class TestServlet2 extends HttpServlet {
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
            System.out.println(req.getParameter("choice"));
        }
        req.getRequestDispatcher("/test-screen").forward(req,res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession(true);


    }
}
