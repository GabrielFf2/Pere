package com.project.nasaweb.service.user;

import com.project.nasaweb.model.User;

public interface IUserService {
    public User login(User user);
    public boolean register(User user);
    public User login(String email, String password);
    public boolean register(String name, String email, String password);
}
