package com.project.nasaweb.dao;

import com.project.nasaweb.model.Aproach;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class AproachDaoImpl implements IAproachDao{

    EntityManager em;
    public AproachDaoImpl() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
        this.em = emf.createEntityManager();
    }

    @Override
    public List<Aproach> getAproachByAsteroidID(Long asteroidID) {
        try {
            String query = "select a from Aproach a where a.asteroid.id = :asteroidID";
            return em.createQuery(query , Aproach.class ).setParameter("asteroidID", asteroidID ).getResultList();
        }catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Aproach> findAll() {
        try {
            return em.createQuery("select a from Aproach a",Aproach.class).getResultList();
        }catch (Exception e) {
            return null;
        }
    }

    @Override
    public Aproach findById(long id) {
        try {
            return em.find(Aproach.class, id);
        }catch (Exception e) {
            return null;
        }
    }

    @Override
    public void save(Aproach aproach) {
        try {
            em.getTransaction().begin();
            em.persist(aproach);
            em.getTransaction().commit();

        }catch (Exception e) {
            e.getMessage();
        }
    }
}
