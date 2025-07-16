package com.example.authservletjwt.servlet;
import com.example.authservletjwt.dtos.UserLoginDTO;
import com.example.authservletjwt.models.User;
import com.example.authservletjwt.service.UserService;
import com.example.authservletjwt.util.JwtUtil;
import com.google.gson.Gson;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private final UserService userService = new UserService();
    private final Gson gson = new Gson();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        UserLoginDTO dto = gson.fromJson(request.getReader(), UserLoginDTO.class);
        try {
            User user = userService.login(dto.email, dto.password);
            if (user != null) {
                String token = JwtUtil.generateToken(user.getId(), user.getEmail(), user.getRole());
                response.setContentType("application/json");
                response.getWriter().write("{\"token\": \"" + token + "\"}");
            } else {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.getWriter().write("{\"error\": \"Invalid credentials\"}");
            }
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("{\"error\": \"" + e.getMessage() + "\"}");
        }
    }
}
