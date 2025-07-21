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

        // Check Content-Type
        if (!"application/json".equalsIgnoreCase(request.getContentType())) {
            response.setStatus(HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE);
            response.getWriter().write("{\"error\": \"Content-Type must be application/json\"}");
            return;
        }

        String email = dto.email.trim();
        String password = dto.password.trim();

        // basic email validation
        if (email.isEmpty()) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("{\"error\": \"Email cannot be empty\"}");
            return;
        }

        if (password.isEmpty()) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("{\"error\": \"Password cannot be empty\"}");
            return;
        }

        if (!email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("{\"error\": \"Invalid email format\"}");
            return;
        }

        try {
            userService.signup(dto.email, dto.password);
            response.setStatus(HttpServletResponse.SC_CREATED);
            response.getWriter().write("{\"message\": \"User created successfully\"}");
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("{\"error\": \"" + e.getMessage() + "\"}");
        }
    }
}

