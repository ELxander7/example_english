package ru.kpfu.itis.oris.armanov.example_english.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginFormServlet", value = "/login-form")
public class LoginFormServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/loginForm.jsp").forward(request,response);
    }
}