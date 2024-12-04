package org.example.hellowweb.dao;

import org.example.hellowweb.model.Movie;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MovieDaoJDBCImpl implements MovieDao {

    ArrayList<Movie> movies = new ArrayList<>();

    @Override
    public List<Movie> findAll() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://db:3306/movies", "root", "root");

            Statement statement = connection.createStatement();
            String sql = "select * from movies";
            ResultSet result = statement.executeQuery(sql);

            List<Movie> movies = new ArrayList<>();
            while (result.next()) {
                Long id = result.getLong("id");
                String title = result.getString("title");
                String description = result.getString("description");
                int year = result.getInt("year");
                movies.add(new Movie(id, title, description, year));
            }
            connection.close();
            return movies;

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Movie findByID(Long id) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://db:3306/movies", "root", "root");

            PreparedStatement preparedStatement = connection.prepareStatement("select * from movies where id = ?");
            preparedStatement.setLong(1, id);
            ResultSet result = preparedStatement.executeQuery();

            result.next();
            Long idM = result.getLong("id");
            String title = result.getString("title");
            String description = result.getString("description");
            int year = result.getInt("year");
            Movie peli
                    = new Movie(idM, title, description, year);
            connection.close();
            return peli;

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean deleteByID(Long movieId) {
        String sql = "DELETE FROM movies WHERE id = ?";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection connection = DriverManager.getConnection("jdbc:mysql://db:3306/movies", "root", "root");
                 PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

                preparedStatement.setLong(1, movieId);
                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    movies.removeIf(movie -> Objects.equals(movie.getId(), movieId));
                    return true;
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    @Override
    public Movie createMovie(Movie movie) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://db:3306/movies", "root", "root");

            PreparedStatement preparedStatment = connection.prepareStatement("insert into movies (title, description, year) values (?, ?, ?)");
            preparedStatment.setString(1, movie.getTitle());
            preparedStatment.setString(2, movie.getDescription());
            preparedStatment.setInt(3, movie.getYear());
            preparedStatment.executeUpdate();
            movies.add(movie);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return movie;
    }

    @Override
    public void update(Movie movie) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://db:3306/movies", "root", "root");
            PreparedStatement statement = connection.prepareStatement("UPDATE movies SET title=?, description=?, year=? WHERE id=?");


            statement.setString(1, movie.getTitle());
            statement.setString(2, movie.getDescription());
            statement.setInt(3, movie.getYear());
            statement.setLong(4, movie.getId());

            int result = statement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean login(String nameForm, String password) {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://db:3306/movies", "root", "root");
            PreparedStatement statement = connection.prepareStatement("select * from users where name = ? ");
            statement.setString(1, nameForm);

            try (ResultSet result = statement.executeQuery()){
                if (result.next()) {
                    String hashPassword = result.getString("password");
                    return BCrypt.checkpw(password , hashPassword);
                }else return false;
            }
        }catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean createUser(String nameForm, String password) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://db:3306/movies", "root", "root");
            PreparedStatement revisarUser = connection.prepareStatement("select * from users where name = ? ");
            revisarUser.setString(1, nameForm);
            ResultSet result = revisarUser.executeQuery();
            if (result.next()) {
                return false;
            }
            PreparedStatement statement = connection.prepareStatement("insert into users (name, password) values (?, ?)");
            statement.setString(1, nameForm);
            statement.setString(2, BCrypt.hashpw(password, BCrypt.gensalt()));
            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
