package org.example.vetplus.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.vetplus.model.Animal;

import java.sql.SQLException;
import java.util.List;

public class AnimalDaoImpl implements IAnimalDao{


    EntityManager entityManager;

    public AnimalDaoImpl() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
        entityManager = entityManagerFactory.createEntityManager();
    }

    @Override
    public List<Animal> findAll() throws SQLException {
        String sql = "SELECT a FROM Animal a";
        List<Animal> animals = this.entityManager.createQuery(sql , Animal.class).getResultList();
        return animals;
    }

    @Override
    public Animal findById(Long aLong) {
        return null;
    }

    @Override
    public void save(Animal animal) {

    }

    @Override
    public void delete(Animal animal) {

    }
}
