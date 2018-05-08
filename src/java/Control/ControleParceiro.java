/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Cidade;
import Model.DAO.CidadeDAO;
import Model.DAO.EstadoDAO;
import Model.DAO.ParceiroDAO;
import Model.Endereco;
import Model.Estado;
import Model.Fornecedor;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lucas
 */
@WebServlet(name = "ControleParceiro", urlPatterns = {"/ControleParceiro"})
public class ControleParceiro extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String acao = request.getParameter("acao");
            if (acao.equals("listaEstadosParaSelecao")) {

                //busca a listadeestados
                EstadoDAO edao = new EstadoDAO();
                List<Estado> listaEstados = edao.lista();

                //serializapara JSON
                Gson gson = new Gson();
                String listaJSON = gson.toJson(listaEstados);
                out.println(listaJSON);

            } else if (acao.equals("listaCidadesParaEstado")) {
                //recupera o id do estado
                int idestado = parseInt(request.getParameter("estado"));
                Estado estado = new Estado(idestado);
                CidadeDAO cdao = new CidadeDAO();
                List<Cidade> listaCidades = cdao.listaParaEstado(estado);

                //serializapara JSON
                Gson gson = new Gson();
                String listaJSON = gson.toJson(listaCidades);
                out.println(listaJSON);

            } else if (acao.equals("listafornecedor")) {
                ParceiroDAO fornecedorDAO = new ParceiroDAO();
                ArrayList<Fornecedor> listaFornecedor = fornecedorDAO.lista();
                Gson gson = new Gson();
                String listaJSON = gson.toJson(listaFornecedor);
                out.write(listaJSON);
            }

        } catch (Exception e) {
            request.setAttribute("erro", e);
            request.getRequestDispatcher("erro.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String acao = request.getParameter("botao");
        ParceiroDAO parceiro = new ParceiroDAO();
        String tipo = request.getParameter("tipo");
        String tpPessoa = request.getParameter("pessoa");

        Estado estado = new Estado();
        estado.setId(parseInt(request.getParameter("estado")));
        Cidade cidade = new Cidade();
        cidade.setId(parseInt(request.getParameter("cidade")));
        Endereco endereco = new Endereco();
        endereco.setCidade(cidade);
        endereco.setEstado(estado);
        endereco.setCep(parseInt(request.getParameter("cep")));
        endereco.setRua(request.getParameter("logradouro"));
        endereco.setNumero(parseInt(request.getParameter("numero")));
        endereco.setComplemento(request.getParameter("complemento"));

        if (acao.equals("CADASTRAR FORNECEDOR")) {
            Fornecedor fornecedor = new Fornecedor();
            fornecedor.setEndereco(endereco);
            fornecedor.setCelular(request.getParameter("celular"));
            fornecedor.setEmail(request.getParameter("email"));
            fornecedor.setNome(request.getParameter("nomeFant"));
            fornecedor.setTelefone(request.getParameter("telefone"));
            fornecedor.setCnpj(request.getParameter("CNPJ"));
            fornecedor.setIe(request.getParameter("IE"));
            fornecedor.setRazao_social(request.getParameter("razaoSocial"));
            fornecedor.setPedido_minimo(Double.parseDouble(request.getParameter("pedidoMinimo")));

            if (parceiro.cadastrarFornecedor(fornecedor) == true) {
                request.setAttribute("msg", "Fornecedor cadastrado com sucesso!!!");
                response.sendRedirect("parceirosCadForn.jsp");
            } else {
                request.setAttribute("msg", "Falha ao cadastrar fornecedor");
                response.sendRedirect("parceirosCadForn.jsp");
            }
        } else if (acao.equals("CADASTRAR CLIENTE")) {

        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
