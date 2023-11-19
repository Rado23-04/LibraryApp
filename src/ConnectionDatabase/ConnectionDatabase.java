package ConnectionDatabase;
import java.sql.*;
public class ConnectionDatabase {
    public static void main(String[] args) {
        String jdbcUrl = System.getenv("DB_URL");
        String user = System.getenv("DB_USER");
        String password = System.getenv("DB_PASSWORD");

        if (jdbcUrl == null || user == null || password == null) {
            System.err.println("Veuillez définir les variables d'environnement DB_URL, DB_USER et DB_PASSWORD.");
            return;
        }

        // Vérifiez l'URL JDBC avant d'établir la connexion
        System.out.println("JDBC URL: " + jdbcUrl);

        try (Connection connection = DriverManager.getConnection(jdbcUrl, user, password)) {
            System.out.println("Connexion réussie à la base de données.");

            // Effectuez d'autres opérations avec la base de données ici

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Erreur lors de la connexion à la base de données.");
        }
    }
}

