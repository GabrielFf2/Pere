package com.project.nasaweb.dao;

import com.project.nasaweb.model.Asteroid;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;

public class AsteroidsDaoImpl implements IAsteroidsDao {


    EntityManager em;

    public AsteroidsDaoImpl() {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
        this.em = emf.createEntityManager();

    }

    @Override
    public void deleteAsteroid(Long id) {
        Asteroid a = findById(id);
        try {
            em.getTransaction().begin();
            em.remove(a);
            em.getTransaction().commit();
        }catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    @Override
    public void updateAsteroid(Asteroid asteroid) {
        try {
            em.getTransaction().begin();
            em.merge(asteroid);
            em.getTransaction().commit();
        }catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    @Override
    public List<Asteroid> findAll() {
        try {
            return em.createQuery("SELECT a FROM Asteroid a",Asteroid.class).getResultList();
        }catch (Exception e) {
            em.getTransaction().rollback();
        }
        return null;
    }

    @Override
    public Asteroid findById(long id) {
        try {
            return em.find(Asteroid.class, id);
        }catch (Exception e) {
            em.getTransaction().rollback();
        }
        return null;
    }

    @Override
    public void save(Asteroid asteroid) {
       try {
           em.getTransaction().begin();
           em.persist(asteroid);
           em.getTransaction().commit();

       }catch (Exception e) {
           e.getMessage();
       }
    }

    public void saveAll(List<Asteroid> asteroids) {
        for (Asteroid asteroid : asteroids) {
            save(asteroid);
        }
    }
}
