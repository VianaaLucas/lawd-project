/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Categoria;
import Model.DAO.CategoriaDAO;
import Model.DAO.SubCatDAO;
import Model.SubCategoria;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lucas
 */
public class ControleSubCategoria extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControleSubCategoria</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControleSubCategoria at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

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

                //SubCategoria subcat = new SubCategoria();
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
        SubCategoria subcat = new SubCategoria();
        subcat.setCategoria(parseInt(request.getParameter("categoria")));
        subcat.setNome(request.getParameter("descricao").toString());

        SubCatDAO subcatDAO = new SubCatDAO();

        boolean retorno;
        retorno = subcatDAO.cadastrar(subcat);

        if (retorno == true) {
            request.setAttribute("msg", "SubCategoria cadastrada com sucesso!!!");
            request.getRequestDispatcher("subCatCadastrar.jsp").forward(request, response);
        } else {
            request.setAttribute("msg", "Ocorreu uma falha ao cadastrar a SubCategoria!!!");
            request.getRequestDispatcher("subCatCadastrar.jsp").forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
