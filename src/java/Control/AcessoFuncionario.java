/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Usuario;
import Model.PerfilDeAcesso;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author lucas
 */
@WebFilter(filterName = "AcessoFuncionario", urlPatterns = {
    "/pdv.jsp",
    "/pagamento.jsp",
    "/produtosAlterar.jsp",
    "/produtosCadastrar.jsp",
    "/produtosConsultar.jsp",
    "/produtosHome.html",
    "/produtosInativar.html",
    "/parceirosAlterar.html",
    "/parceirosCadClienteFisico.jsp",
    "/parceirosCadClienteJuridico.jsp",
    "/parceirosCadForn.jsp",
    "/parceirosClienteFisico.jsp",
    "/parceirosClienteJuridico.jsp",
    "/parceirosConsultar.jsp",
    "/parceirosFornecedor.html",
    "/parceirosHome.html",
    "/parceirosPesquisar.html",
    "/estoque.jsp",
    "/categoriaAlterar.html",
    "/categoriaCadastrar.jsp",
    "/categoriaConsultar.jsp",
    "/categoriaHome.html",
    "/categoriaInativar.html",
    "/categoriaMostrar.jsp",
    "/categoriaPesquisar.html",
    "/subCatAlterar.html",
    "/subCatCadastrar.jsp",
    "/subCatConsultar.html",
    "/subCatHome.html",
    "/subCatInativar.html",
    "/subCatPesquisar.html",
    "/subCat.jsp",})
public class AcessoFuncionario implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpSession sessaoUsuario = ((HttpServletRequest) request).getSession();
        Usuario usuario = (Usuario) sessaoUsuario.getAttribute("usuarioAutenticado");

        if (usuario != null & usuario.getPerfil().equals(PerfilDeAcesso.FUNCIONARIO)) {
            chain.doFilter(request, response);
        } else if (usuario != null & usuario.getPerfil().equals(PerfilDeAcesso.GERENTE)) {
            chain.doFilter(request, response);
        } else if (usuario != null & usuario.getPerfil().equals(PerfilDeAcesso.SUPERADMIN)) {
            chain.doFilter(request, response);
        }else {
            ((HttpServletResponse) response).sendRedirect("/Lawd/home.jsp");
        }

    }

    @Override
    public void destroy() {

    }

}
