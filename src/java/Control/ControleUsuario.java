/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.Usuario;
import Model.DAO.loginUsuarioDAO;
import Model.loginPerfilDeAcesso;

/**
 *
 * @author hataishi
 */
public class ControleUsuario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            String acao = request.getParameter("acao");
            if (acao.equals("Cadastrar")) {
                Usuario usuario = new Usuario();
                usuario.setUsuario(request.getParameter("txtLogin"));
                usuario.setSenha(request.getParameter("txtSenha"));
                String perfil = request.getParameter("optPerfil");
                if (perfil.equalsIgnoreCase("administrador")) {
                    usuario.setPerfil(loginPerfilDeAcesso.GERENTE);
                } else if (perfil.equalsIgnoreCase("vendedor")) {
                    usuario.setPerfil(loginPerfilDeAcesso.VENDEDOR);
                } else if (perfil.equalsIgnoreCase("estoquista")) {
                    usuario.setPerfil(loginPerfilDeAcesso.ESTOQUISTA);
                }
                loginUsuarioDAO usuarioDAO = new loginUsuarioDAO();
                usuarioDAO.cadastraNovoUsuario(usuario);
                request.setAttribute("msg", "Usuario cadastrado com sucesso!!!");
                request.getRequestDispatcher("admin/cadastro_usuario.jsp").forward(request, response);
            }
        } catch (Exception erro) {
            request.setAttribute("msg", "Ocorreu uma falha ao cadastrar o usuário!!!");
            request.getRequestDispatcher("admin/cadastro_usuario.jsp").forward(request, response);
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
