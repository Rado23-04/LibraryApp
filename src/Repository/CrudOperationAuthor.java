package Repository;

import ConnectionDatabase.ConnectionDatabase;
import Modal.Author;

import java.sql.*;
import java.util.List;

public class CrudOperationAuthor implements CrudOperation <Author> {
    private static Connection connection;
    public static void getConnection() {
        ConnectionDatabase Db = new ConnectionDatabase();
        connection = Db.createConnection();
    }
    @Override
    public List<Author> findAll() {
        getConnection();
    try {
        String sql = "SELECT * FROM Author";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        System.out.printf("List of Author");
        while (resultSet.next()){
            int id = resultSet.getInt("author_id");
            String name = resultSet.getString("name");
            int birthday = resultSet.getInt("birth_year");
            System.out.println(
                    "Author { id : "+id+
                            ", name : "+name+
                            ", birthday: "+birthday+
                            "};"
            );
        }
    }catch (SQLException e){
        throw new RuntimeException(e);
    }
        return null;
    }

    @Override
    public List<Author> saveAll(List<Author> author)  {
        getConnection();
        try {
            for (Author authors:author){
                String sql = "INSERT INTO Author (name, birth_year) VALUES (?,?)";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1,authors.getName());
                statement.setInt(2,authors.getBirthday());
                int row = statement.executeUpdate();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Add list of  Authors successfully !");
        return null;
    }

    @Override
    public Author save(Author author){
        getConnection();
        try{
            String sql = "INSERT INTO Author (name, birth_year) VALUES (?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,author.getName());
            statement.setInt(2, author.getBirthday());
            int row = statement.executeUpdate();
            System.out.println("Add Author successfully !");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public Author delete(Author toDelete)  {
        getConnection();
        try {
            String sql = "delete from author where author_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,toDelete.getId());
            int row = statement.executeUpdate();
            System.out.println("Deleted Author successfully !");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
