package com.project.nasaweb.service.user;

import com.project.nasaweb.dao.user.IUser;
import com.project.nasaweb.model.RolUser;
import com.project.nasaweb.model.User;
import com.project.nasaweb.dao.user.UserDaoImpl;
import org.mindrot.jbcrypt.BCrypt;

public class UserService implements IUserService {
    private final IUser userDao;

    public UserService(UserDaoImpl user) {
        userDao = user;
    }

    @Override
    public User login(User user) {
        if (user == null) {
            return null;
        }
        try {
            return userDao.loginByEmail(user.getEmail());
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public boolean register(User user) {
        if (user == null) {
            return false;
        }
        if (userDao.findByEmail(user.getEmail()) != null) {
            return false;
        }
        try {
            return userDao.save(user);
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public User login(String email, String password) {
        if (email == null || password == null) {
            return null;
        }
        User userCheck = new User();
        userCheck.setEmail(email);
        userCheck.setPassword(password);
        User userDB = userDao.loginByEmail(email);
        if (userDB == null)
            return null;

        if (BCrypt.checkpw(password, userDB.getPassword())) {
            return userDB;
        }
        return null;
    }

    @Override
    public boolean register(String name, String email, String password) {
        if (name.isEmpty() || email.isEmpty() || password.isEmpty())
            return false;

        User userCreate = new User();
        userCreate.setName(name);
        userCreate.setEmail(email);
        userCreate.setPassword(BCrypt.hashpw(password, BCrypt.gensalt()));
        userCreate.setRol(new RolUser(2, "OBSERVERS"));
        if (userDao.findByEmail(userCreate.getEmail()) != null) {
            return false;
        }
        return userDao.save(userCreate);
    }
}
