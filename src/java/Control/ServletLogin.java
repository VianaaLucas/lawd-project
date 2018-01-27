
package Control;

import Model.DAO.LoginDAO;
import Model.Login;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletLogin extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String usuario = request.getParameter("username").toString();
        String senha = request.getParameter("password").toString();
        
        Login logari = new Login();
        logari.setUser(usuario);
        logari.setSenha(senha);
        
        LoginDAO logDAO = new LoginDAO();
        try {
            boolean acaoLogin = logDAO.logar(logari);
            if (acaoLogin == true){
                response.sendRedirect("home.html");
            } else response.sendRedirect("login.html");
            
        } catch (SQLException ex) {
            Logger.getLogger(ServletLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
