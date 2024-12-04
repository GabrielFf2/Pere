package com.project.nasaweb.dao.user;

import com.project.nasaweb.model.User;

public interface IUser {
    public User loginByEmail(String email);

    public User findByEmail(String email);

    public boolean save(User user);
}
