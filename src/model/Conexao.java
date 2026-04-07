package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Guarda as credenciais de acesso e faz a ponte entre o seu programa Java e o banco de dados
public class Conexao {
    static String conexao = "jdbc:postgresql://localhost:5432/DB_linguagenscrud";
    static String usuario = "postgres";
    static String senha = "postgres";

    // Tenta entrar no banco com os dados ali de cima e devolve a conexao aberta prontinha pro DAO usar
    public Connection conectaBD() {
        try {
            return DriverManager.getConnection(conexao, usuario, senha);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}

