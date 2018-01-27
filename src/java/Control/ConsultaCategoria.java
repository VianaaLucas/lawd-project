package Control;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.Categoria;
import Model.DAO.CategoriaDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "ConsultaCategoria", urlPatterns = {"/ConsultaCategoria"})
public class ConsultaCategoria extends HttpServlet {

    @Override

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CategoriaDAO dao = new CategoriaDAO();
        Categoria c = new Categoria();

        c.setId(Integer.parseInt(request.getParameter("selecao_categoria")));

        try {
            c = dao.buscarPorId(c);

            request.setAttribute("nome", c.getNome());
            request.setAttribute("id", c.getId());
            request.getRequestDispatcher("categoriaMostrar.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaCategoria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Categoria cat = new Categoria();
        cat.setNome(request.getParameter("descricao").toString());
        CategoriaDAO conDAO = new CategoriaDAO();

        try {
            boolean acaoConsultar = conDAO.Consultar(cat);
            if (acaoConsultar == true) {
                response.sendRedirect("categoriaConsultar.html");
            } else {
                response.sendRedirect("categoriaHome.html");
            }
        } catch (SQLException ex) {
            response.sendRedirect("categoriaHome.html");
        }
    }
}
