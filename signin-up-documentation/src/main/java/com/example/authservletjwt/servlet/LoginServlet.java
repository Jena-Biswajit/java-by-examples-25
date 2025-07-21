package com.example.authservletjwt.servlet;
import com.example.authservletjwt.dtos.UserLoginDTO;
import com.example.authservletjwt.models.User;
import com.example.authservletjwt.service.UserService;
import com.example.authservletjwt.util.JwtUtil;
import com.google.gson.Gson;

import com.google.gson.JsonSyntaxException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private final UserService userService = new UserService();
    private final Gson gson = new Gson();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (!"application/json".equals(request.getContentType())) {
            response.setStatus(HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE);
            response.setContentType("application/json");
            response.getWriter().write("{\"error\": \"Unsupported Media Type. Content-Type must be application/json.\"}");
            return;
        }

        try {
            UserLoginDTO dto = gson.fromJson(request.getReader(), UserLoginDTO.class);

            if (dto == null || dto.email == null || dto.password == null) {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                response.setContentType("application/json");
                response.getWriter().write("{\"error\": \"Invalid request payload: Missing email or password field.\"}");
                return;
            }

            if (dto.email.trim().isEmpty() || dto.password.trim().isEmpty()) {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                response.setContentType("application/json");
                response.getWriter().write("{\"error\": \"Invalid request payload: Email and password cannot be empty.\"}");
                return;
            }

            User user = userService.login(dto.email, dto.password);

            if (user != null) {
                String token = JwtUtil.generateToken(user.getId(), user.getEmail(), user.getRole());
                response.setStatus(HttpServletResponse.SC_OK);
                response.setContentType("application/json");
                response.getWriter().write("{\"token\": \"" + token + "\"}");
            } else {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.setContentType("application/json");
                response.getWriter().write("{\"error\": \"Invalid email or password.\"}");
            }

        } catch (JsonSyntaxException e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.setContentType("application/json");
            response.getWriter().write("{\"error\": \"Malformed JSON in request body.\"}");
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.setContentType("application/json");
            response.getWriter().write("{\"error\": \"An unexpected error occurred: " + e.getMessage() + "\"}");
        }
    }
}
