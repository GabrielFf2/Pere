package com.project.nasaweb.dao;

import java.util.List;

public interface ICrudDao <T>{

    List<T> findAll();
    T findById(long id);
    void save(T t);

}
