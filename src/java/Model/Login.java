package Model;
import Model.DAO.LoginDAO;
import java.sql.SQLException;

/**
 *
 * @author lucas
 */

public class Login {
    private String user;
    private String senha;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
          
}
