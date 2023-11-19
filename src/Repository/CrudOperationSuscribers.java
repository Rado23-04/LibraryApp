package Repository;

import ConnectionDatabase.ConnectionDatabase;
import Modal.Author;
import Modal.Suscriber;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.sql.*;
import java.util.List;


import static Repository.CrudOperationAuthor.getConnection;


public class CrudOperationSuscribers implements CrudOperation <Suscriber>{
    private static Connection connection;
    public static void getConnection() {
        ConnectionDatabase Db = new ConnectionDatabase("DB_URL","DB_USER","DB_PASSWORD");
        connection = Db.createConnection();
    }

    @Override
    public List<Suscriber> findAll() {
        getConnection();
        try {
            String sql = "SELECT * FROM Suscribers";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            System.out.printf("List of Suscribers");
            while (resultSet.next()){
                String  name = resultSet.getString("username");
                String password = resultSet.getString("password");
                String email = resultSet.getString("email");
                String date = resultSet.getString("suscription_date");
                System.out.println(
                        "Author { id : "+name+
                                ", name : "+password+
                                ", birthday: "+password+
                                ", email: "+email+
                                ", date: "+date+
                                "};"
                );
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public List<Suscriber> saveAll(List<Suscriber> suscribers) {
        getConnection();
        try {
            for (Suscriber s:suscribers){
                String sql = "INSERT INTO Author (username,email) VALUES (?,?)";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1,s.getName());
                statement.setString(2,s.getEmail());
                int row = statement.executeUpdate();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Add list of  Authors successfully !");
        return null;
    }

    @Override
    public Suscriber save(Suscriber toSave) {
        return null;
    }

    @Override
    public Suscriber delete(Suscriber toDelete) {
        getConnection();
        try {
            String sql = "delete from suscribers where id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,toDelete.getId());
            int row = statement.executeUpdate();
            System.out.println("Deleted suscribers successfully !");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
