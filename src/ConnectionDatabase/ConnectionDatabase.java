package ConnectionDatabase;
import java.sql.*;
public class ConnectionDatabase {
    private  String jdbcUrl;
    private  String user;
     private  String password;


    public Connection createConnection(){
        try{
            return DriverManager.getConnection(
                    this.jdbcUrl, this.user, this.password
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args){
        String jdbcUrl = System.getenv("DB_URL");
        String user = System.getenv("DB_USER");
        String password = System.getenv("DB_PASSWORD");

        if (jdbcUrl == null || user == null || password == null) {
            System.err.println("Veuillez définir les variables d'environnement DB_URL, DB_USER et DB_PASSWORD.");
            return;
        }

        System.out.println("JDBC URL: " + jdbcUrl);

        try (Connection connection = DriverManager.getConnection(jdbcUrl, user, password)) {
            System.out.println("Connexion réussie à la base de données.");


        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Erreur lors de la connexion à la base de données.");
        }
    }
}

