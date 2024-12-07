package ru.kpfu.itis.oris.armanov.example_english.controller;

import ru.kpfu.itis.oris.armanov.example_english.dao.QuestionDao;
import ru.kpfu.itis.oris.armanov.example_english.dao.TestDao;
import ru.kpfu.itis.oris.armanov.example_english.dao.TestTypeDao;
import ru.kpfu.itis.oris.armanov.example_english.entity.Question;
import ru.kpfu.itis.oris.armanov.example_english.entity.Test;
import ru.kpfu.itis.oris.armanov.example_english.entity.TestType;
import ru.kpfu.itis.oris.armanov.example_english.util.JsonConverter;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "GetTestServlet", value = "/testjson")
public class GetTestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("testTypeId"));
        response.setContentType("application/json;charset=UTF-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        // ServletOutputStream out = response.getOutputStream();

        List<Question> test = new QuestionDao().getTenRandomQuestions(id);

        JsonConverter converter = new JsonConverter();
        String output = converter.convertToJson(test);
        PrintWriter out = response.getWriter();
        out.print(output);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}