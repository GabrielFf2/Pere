package org.example.vetplus.dao;

import org.example.vetplus.config.MySQLConnection;
import org.example.vetplus.model.Tipus;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TipusDaoImpl implements ITipusDao{

    private MySQLConnection mySQLConnection;

    public TipusDaoImpl() {
        this.mySQLConnection = MySQLConnection.getInstance();
    }

    @Override
    public List<Tipus> findAll() throws SQLException {
        try {
            String sql = "select * from tipus";
            PreparedStatement preparedStatement = this.mySQLConnection.getConnection().prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Tipus> list = new ArrayList<>();

            while (resultSet.next()) {
                Tipus tipus = new Tipus();
                tipus.setId(resultSet.getLong("id"));
                tipus.setNom(resultSet.getString("nom"));

                list.add(tipus);
            }
            return list;

        }catch (SQLException e){
            e.printStackTrace();
        }

        return List.of();
    }

    @Override
    public Tipus findById(Long aLong) {
        return null;
    }

    @Override
    public void save(Tipus tipus) {

    }

    @Override
    public void delete(Tipus tipus) {

    }
}
