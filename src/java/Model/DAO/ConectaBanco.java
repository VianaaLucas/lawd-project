package Model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectaBanco {
    public static Connection getConexao(){
        Connection conexao = null;
        
        try {
            Class.forName("org.postgresql.Driver");
            conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/lawd","postgres", "postgres");
            
        } catch (ClassNotFoundException erro1) {
            throw new RuntimeException (erro1);
        } catch (SQLException erro2){
            throw new RuntimeException(erro2);
        }
        return conexao;
    }
}
