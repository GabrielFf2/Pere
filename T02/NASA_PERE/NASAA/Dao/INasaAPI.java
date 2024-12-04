package com.project.nasaweb.Dao;

import com.project.nasaweb.models.Asteroid;

import java.time.LocalDate;
import java.util.List;

public interface INasaAPI {
    List<Asteroid> getDataNasa();
    List<Asteroid> getDataNasaByDate(LocalDate dataStart, LocalDate dateEnd);
}
