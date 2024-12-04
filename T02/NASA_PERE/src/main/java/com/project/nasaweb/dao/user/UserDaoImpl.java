package com.project.nasaweb.dao.user;

import com.project.nasaweb.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class UserDaoImpl implements IUser{
    private final EntityManager entityManager;

    public UserDaoImpl() {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("persistence");
        entityManager = managerFactory.createEntityManager();
    }
    @Override
    public User loginByEmail(String email) {
        try {
            return entityManager.createQuery("SELECT u FROM User u WHERE u.email = :email", User.class)
                    .setParameter("email", email)
                    .getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public User findByEmail(String email) {
        try {
            return entityManager.createQuery("SELECT u FROM User u WHERE u.email = :email", User.class)
                    .setParameter("email", email)
                    .getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public boolean save(User user) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(user);
            entityManager.getTransaction().commit();
            return true;
        }catch(Exception e) {
            return false;
        }
    }
}
