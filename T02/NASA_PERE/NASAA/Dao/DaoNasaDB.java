package com.project.nasaweb.Dao;

import com.project.nasaweb.models.Aproach;
import com.project.nasaweb.models.Asteroid;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class DaoNasaDB implements INasaDB {

    private EntityManagerFactory managerFactory;
    private EntityManager manager;


    public DaoNasaDB() {
        managerFactory = Persistence.createEntityManagerFactory("nasaPersistenceDB");
        manager = managerFactory.createEntityManager();

    }

    @Override
    public List<Asteroid> getAllAsteroids() {
        return manager.createQuery("SELECT a FROM Asteroid a", Asteroid.class).getResultList();
    }

    @Override
    public Asteroid getAsteroidById(int id) {
        return manager.find(Asteroid.class, id);
    }

    @Override
    public String updateAsteroid(Asteroid asteroid) {
        try {
            manager.getTransaction().begin();
            manager.merge(asteroid);
            manager.getTransaction().commit();
            return "Asteroid Updated";
        } catch (Exception e) {
            manager.getTransaction().rollback();
            return e.getMessage();
        }
    }


    @Override
    public String deleteAsteroidById(long id) {
        try {
            manager.getTransaction().begin();
            Asteroid asteroid = manager.find(Asteroid.class, id);
            if (asteroid != null) {
                manager.remove(asteroid);
            }
            manager.getTransaction().commit();
            return "Asteroid Deleted";
        } catch (Exception e) {
            manager.getTransaction().rollback();
            return e.getMessage();
        }
    }


    @Override
    public String insertAsteroid(Asteroid asteroid) {
        try {
            manager.getTransaction().begin();
            manager.persist(asteroid);
            manager.getTransaction().commit();
            return "Asteroide insertado";
        } catch (Exception e) {
            manager.getTransaction().rollback();
            return "Error: " + e.getMessage();
        }
    }

    @Override
    public String insertAsteroids(List<Asteroid> asteroids) {
        try {
            manager.getTransaction().begin();
            asteroids.forEach(asteroid -> {
                manager.persist(asteroid);
            });
            manager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
//            manager.getTransaction().rollback(); //NO HACER CON INSERT TONTO
            return e.getMessage();
        }
        return "Asteroide insertado";
    }

    @Override
    public List<Aproach> getAllAproaches(int asteroidId) {
        return manager.createQuery("SELECT a FROM Aproach a", Aproach.class).getResultList();
    }

    @Override
    public Aproach getAproachById(int aproachId) {
        return manager.find(Aproach.class, aproachId);
    }

    @Override
    public void updateAproach(Aproach aproach) {
        manager.getTransaction().begin();
        manager.merge(aproach);
        manager.getTransaction().commit();
        manager.close();
    }

    @Override
    public void insertAproach(Aproach aproach) {
        manager.getTransaction().begin();
        manager.merge(aproach);
        manager.getTransaction().commit();
        manager.close();
    }

    @Override
    public void insertAproaches(List<Aproach> aproaches) {
        try {
            manager.getTransaction().begin();
            aproaches.forEach(aproach -> {
                manager.persist(aproach);
            });
            manager.getTransaction().commit();
            manager.close();
        } catch (Exception e) {
            e.printStackTrace();
            manager.getTransaction().rollback();
        }
    }

    @Override
    public String deleteAproachById(long aproachId) {
        try {
            manager.getTransaction().begin();
            Aproach aproach = manager.find(Aproach.class, aproachId);

            manager.remove(aproach);
            manager.getTransaction().commit();
            manager.close();
            return "Aproach Deleted";
        }catch (Exception e) {
            return e.getMessage();
        }

    }
}
