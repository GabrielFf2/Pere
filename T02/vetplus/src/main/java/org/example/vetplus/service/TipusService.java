package org.example.vetplus.service;

import org.example.vetplus.dao.ITipusDao;
import org.example.vetplus.model.Tipus;

import java.sql.SQLException;
import java.util.List;

public class TipusService {
    ITipusDao tipusDao;

    public TipusService(ITipusDao tipusDao) {
        this.tipusDao = tipusDao;
    }

    public List<Tipus> findAll() throws SQLException {
        return this.tipusDao.findAll();
    }

}
