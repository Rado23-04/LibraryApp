package Repository;

import ConnectionDatabase.ConnectionDatabase;
import Modal.Author;

import java.sql.Connection;
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


        return null;
    }

    @Override
    public List<Author> saveAll(List<Author> toSave) {
        return null;
    }

    @Override
    public Author save(Author toSave) {
        return null;
    }

    @Override
    public Author delete(Author toDelete) {
        return null;
    }
}
