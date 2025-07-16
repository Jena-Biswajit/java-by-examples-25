package com.example.authservletjwt.service;

import com.example.authservletjwt.daos.UserDAO;
import com.example.authservletjwt.models.User;
import org.mindrot.jbcrypt.BCrypt;


public class UserService {
    private final UserDAO userDAO = new UserDAO();

    public void signup(String email, String password) throws Exception {
        String hashed = BCrypt.hashpw(password, BCrypt.gensalt());
        User user = new User(email, hashed, "USER");
        userDAO.saveUser(user);
    }

    public User login(String email, String password) throws Exception {
        User user = userDAO.findByEmail(email);
        if (user != null && BCrypt.checkpw(password, user.getPasswordHash())) {
            return user;
        }
        return null;
    }
}

