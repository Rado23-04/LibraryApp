package Repository;

import ConnectionDatabase.ConnectionDatabase;
import Modal.Author;

import java.awt.print.Book;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CrudOperationBook implements CrudOperation<Book>{
    private static Connection connection;
    public static void getConnection() {
        ConnectionDatabase Db = new ConnectionDatabase("DB_URL","DB_USER","DB_PASSWORD");
        connection = Db.createConnection();
    }

    @Override
    public List<Book> findAll() {
        getConnection();
        try {
            String sql = "SELECT * FROM Book";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            System.out.printf("List of Book");
            while (resultSet.next()){
                int id = resultSet.getInt("book_id");
                String name = resultSet.getString("title");
                int author_id =resultSet.getInt("author_id");
                String topic = resultSet.getString("topic");
                int publication_year = resultSet.getInt("publication_year");
                System.out.println(
                        "Author { id : "+id+
                                ", name : "+name+
                                ", author_id"+author_id+
                                ", topic: "+topic+
                                ",publication_y:"+publication_year +
                                "};"
                );
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public List<Book> saveAll(List<Book> book) {

        return null;
    }

    @Override
    public Book save(Book book) {
        getConnection();
        try{
            String sql = "INSERT INTO Author (name, birth_year) VALUES (?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,book.getNumberOfPages());
            int row = statement.executeUpdate();
            System.out.println("Add Author successfully !");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public Book delete(Book toDelete) {
        getConnection();
        try {
            String sql = "delete from author where author_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,toDelete.getNumberOfPages());
            int row = statement.executeUpdate();
            System.out.println("Deleted Author successfully !");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
