import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection {

    public static void main(String[] args) {
        String url = "jdbc:mysql://mysql-37dd114c-diegofrra083-641f.c.aivencloud.com:12100/defaultdb?useSSL=true&verifyServerCertificate=false&allowPublicKeyRetrieval=true";
        String user = "avnadmin";
        String password = "AVNS_tu9CMOGxDtJmxvWs7wi";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("Conexão realizada com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro na conexão:");
            e.printStackTrace();
        }
    }
}
