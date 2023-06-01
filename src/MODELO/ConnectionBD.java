package MODELO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Angelo Meza
 */

public class ConnectionBD {
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
    private static final String USERNAME = "Fabrizio";
    private static final String PASSWORD = "angelito252";

    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public void openConnection() throws SQLException, ClassNotFoundException {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver"); // Cargar el controlador de la base de datos Oracle
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD); // Establecer la conexión con la base de datos
            System.out.println("Conexión establecida");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Error al abrir la conexión: " + e.getMessage());
            throw e;
        }
    }

    public void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close(); // Cerrar la conexión con la base de datos
            System.out.println("Conexión cerrada");
        }
    }
}
