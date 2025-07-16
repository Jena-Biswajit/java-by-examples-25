package com.example.authservletjwt.servlet;

import com.example.authservletjwt.dtos.UserSignupDTO;
import com.example.authservletjwt.service.UserService;
import com.google.gson.Gson;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet("/signup")
public class SignupServlet extends HttpServlet {
    private final UserService userService = new UserService();
    private final Gson gson = new Gson();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        UserSignupDTO dto = gson.fromJson(request.getReader(), UserSignupDTO.class);
        try {
            userService.signup(dto.email, dto.password);
            response.setStatus(HttpServletResponse.SC_CREATED);
            response.getWriter().write("{\"message\": \"User created successfully\"}");
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("{\"error\": \"" + e.getMessage() + "\"}");
        }
    }

//    static {
//        System.out.println("SignupServlet loaded...");
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
//        System.out.println("SignupServlet doPost called...");
//    }
}
