package com.codegym.service;

import com.codegym.model.User;

import java.util.HashMap;
import java.util.Map;

public class UserService implements IUserService{
    private static Map<Integer,User> users = new HashMap<>();
    static {
        users.put(1,new User(1,"mai","hung","0123456789",28,"mqhung93@gmail.com"));
    }

    @Override
    public void save(User user) {
        users.put(user.getId(),user);
    }
}
