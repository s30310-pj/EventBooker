package com.eventbooker.user;

import java.util.HashMap;
import java.util.Map;

public class UserManager {
    private Map<String, user> users = new HashMap<>();
    private user loggedInUser;

    public void register(String username, String password) {
        if (users.containsKey(username)) {
            System.out.println("Username already exists.");
            return;
        }
        user user = new user(username, password);
        users.put(username, user);
        System.out.println("Registration successful!");
        login(username, password);
    }

    public void login(String username, String password) {
        user user = users.get(username);
        if (user != null && user.getPassword().equals(password)) {
            loggedInUser = user;
            System.out.println("Login successful!");
        } else {
            System.out.println("Invalid username or password.");
        }
    }

    public void logout() {
        if (loggedInUser != null) {
            System.out.println("Logout successful!");
            loggedInUser = null;
        } else {
            System.out.println("No user is currently logged in.");
        }
    }

    public user getLoggedInUser() {
        return loggedInUser;
    }
}
