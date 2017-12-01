package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost/aps3", "root", "123");
        } catch (SQLException ex) {
            System.err.println("Erro na conexão com o banco de dados: " + ex.getMessage());
        }
        return null;
    }
}
