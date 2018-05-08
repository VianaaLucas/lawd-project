/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Model.Usuario;
import Model.DAO.UsuarioDAO;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author hataishi
 */
public class ControleAcesso extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            String acao = request.getParameter("acao");
            if (acao.equals("Entrar")) {
                Usuario usuario = new Usuario();
                usuario.setUsuario(request.getParameter("txtUsuario"));
                usuario.setSenha(request.getParameter("txtSenha"));

                UsuarioDAO loginUsuarioDAO = new UsuarioDAO();
                Usuario usuarioAutenticado = loginUsuarioDAO.autenticaUsuario(usuario);
                // se  o usuario existe no banco
                if (usuarioAutenticado != null) {
                    //cria  uma sessao para o usuario
                    HttpSession sessaoUsuario = request.getSession();
                    sessaoUsuario.setAttribute("usuarioAutenticado", usuarioAutenticado);
                    //redirecio para a pag principal
                    response.sendRedirect("home.jsp");
                } else {
                    RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                    request.setAttribute("msg", "Login e/ou senha incorreto(s)");
                    rd.forward(request, response);

                }

            } else if (acao.equals("Sair")) {
                HttpSession sessaoUsuario = request.getSession();
                sessaoUsuario.removeAttribute("usuarioAutenticado");
                response.sendRedirect("logout.jsp");

            }
        } catch (Exception erro) {
            RequestDispatcher rd = request.getRequestDispatcher("/erro.jsp");
            request.setAttribute("erro", erro);
            rd.forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
