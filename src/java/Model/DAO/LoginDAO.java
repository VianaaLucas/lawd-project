
package Model.DAO;

import Model.Login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginDAO {
    public boolean logar (Login login) throws SQLException{
        boolean retorno = false;
        Connection conexao = null;
        
        try {
            conexao = ConectaBanco.getConexao();
            
            PreparedStatement comando = conexao.prepareStatement("select * from users where usuario = ? and senha = crypt(?, senha)");
            
            comando.setString (1, login.getUser());
            comando.setString(2, login.getSenha());
            
            ResultSet resultado = comando.executeQuery();
            
            int controle = 0;
            
            if(resultado.next()){
               controle ++;
            }
            
            switch (controle){
                case 0:
                    retorno = false;
                    break;
                case 1:
                    retorno = true;
                    break;
            }
            
            
            conexao.close();
        } catch (SQLException erro1){
            
        }
        
        return retorno;
    }
    
}
