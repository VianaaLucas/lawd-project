package Control;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.Categoria;
import Model.DAO.CadastraDAO;
import Model.DAO.CategoriaDAO;
import Model.DAO.SubCatDAO;
import Model.SubCategoria;
import com.google.gson.Gson;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CadastroCategoria", urlPatterns = {"/CadastroCategoria"})
public class CadastroCategoria extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        try {
            String acao = request.getParameter("acao");
            if (acao.equals("listacategoria")) {
                CategoriaDAO caddao = new CategoriaDAO();
                ArrayList<Categoria> listaCategoria = caddao.lista();
                Gson gson = new Gson();
                String listaJSON = gson.toJson(listaCategoria);
                out.write(listaJSON);
            } else if (acao.equals("listasubcategoria")) {
                int idcat = Integer.parseInt(request.getParameter("categoria"));

//                SubCategoria subcat = new SubCategoria();
                SubCatDAO subdao = new SubCatDAO();

                Categoria cat = new Categoria(idcat);

                List<SubCategoria> listaCats = subdao.listaParaCategoria(cat);

                //serializa para JSON
                Gson gson = new Gson();
                String listaJSON = gson.toJson(listaCats);
                out.write(listaJSON);

            }
        } catch (Exception e) {
            request.setAttribute("erro", e);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Categoria cat = new Categoria();
        cat.setNome(request.getParameter("descricao").toString());
        CadastraDAO cadDAO = new CadastraDAO();

        try {
            boolean acaoCadastrar = cadDAO.Cadastrar(cat);
            if (acaoCadastrar == true) {
                request.setAttribute("msg", "Categoria cadastrada com sucesso!!!");
                request.getRequestDispatcher("categoriaCadastrar.jsp").forward(request, response);

            } else {
                request.setAttribute("msg", "Falha ao cadastrar a categoria!!!");
                request.getRequestDispatcher("categoriaCadastrar.jsp").forward(request, response);
            }
        } catch (SQLException ex) {
            response.sendRedirect("categoriaHome.html");
        }

    }
}
