package org.example.vetplus.dao;

import org.example.vetplus.model.Animal;

import java.sql.SQLException;
import java.util.List;

public interface ICrudDao <T , ID>{

    List<T> findAll() throws SQLException;
    T findById(ID id);
    void save(T t);
    void delete(T t);

}
