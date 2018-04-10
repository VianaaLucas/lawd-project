
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Cidade;
import Model.ClienteFisico;
import Model.ClienteJuridico;
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
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lucas
 */
public class CadastroParceiro extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CadastroParceiro</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CadastroParceiro at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        processRequest(request, response);
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

            }

        } catch (Exception e) {
            request.setAttribute("erro", e);
            request.getRequestDispatcher("erro.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        processRequest(request, response);

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

        if (tipo.equals("1")) {
            if (tpPessoa.equals("1")) {
                ClienteJuridico clienteJuridico = new ClienteJuridico();
                clienteJuridico.setEndereco(endereco);
                clienteJuridico.setCelular(request.getParameter("celular"));
                clienteJuridico.setEmail(request.getParameter("email"));
                clienteJuridico.setNome(request.getParameter("nome"));
                clienteJuridico.setTelefone(request.getParameter("telefone"));
                clienteJuridico.setCnpj(request.getParameter("CNPJ"));
                clienteJuridico.setIe(request.getParameter("IE"));
                clienteJuridico.setRazao_social(request.getParameter("razaoSocial"));
                if (parceiro.cadastrarClienteJuridico(clienteJuridico) == true) {
                    request.setAttribute("msg", "Parceiro cadastrado com sucesso!!!");
                    request.getRequestDispatcher("parceirosCadastrar.jsp").forward(request, response);
                } else {
                    request.setAttribute("msg", "Ocorreu uma falha ao cadastrar o parceiro!!!");
                    request.getRequestDispatcher("parceirosCadastrar.jsp").forward(request, response);
                }
            } else if (tpPessoa.equals("2")) {
                ClienteFisico clienteFisico = new ClienteFisico();
                clienteFisico.setEndereco(endereco);
                clienteFisico.setCelular(request.getParameter("celular"));
                clienteFisico.setEmail(request.getParameter("email"));
                clienteFisico.setNome(request.getParameter("nome"));
                clienteFisico.setTelefone(request.getParameter("telefone"));
                clienteFisico.setRg(request.getParameter("RG"));
                clienteFisico.setCpf(request.getParameter("cpf"));
                if (parceiro.cadastrarClienteFisico(clienteFisico) == true) {
                    response.sendRedirect("parceirosCadastrar.jsp");
                } else {
                    response.sendRedirect("home.jsp");
                }
            }

        } else if (tipo.equals("2")) {
            Fornecedor fornecedor = new Fornecedor();
            fornecedor.setEndereco(endereco);
            fornecedor.setCelular(request.getParameter("celular"));
            fornecedor.setEmail(request.getParameter("email"));
            fornecedor.setNome(request.getParameter("nome"));
            fornecedor.setTelefone(request.getParameter("telefone"));
            fornecedor.setCnpj(request.getParameter("CNPJ"));
            fornecedor.setIe(request.getParameter("IE"));
            fornecedor.setRazao_social(request.getParameter("razaoSocial"));
            if (parceiro.cadastrarFornecedor(fornecedor) == true) {
                response.sendRedirect("parceirosCadastrar.jsp");
            } else {
                response.sendRedirect("login.html");
            }
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
