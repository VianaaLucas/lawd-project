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
@WebFilter(filterName = "AcessoGerente", urlPatterns = {
    "/admVendas.jsp",
    "/descontoConsultar.jsp",
    "/descontoEditar.jsp",
    "/descontoHome.html",
    "/descontoLista.jsp",
    "/itenspedido.jsp",
    "/pedidoCompra.jsp",
    "/pedidos.jsp",
    "/relatorioEstoque.jsp",
    "/relatorioLucro.jsp",
    "/relatorioVenda.jsp",})
public class AcessoGerente implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpSession sessaoUsuario = ((HttpServletRequest) request).getSession();
        Usuario usuario = (Usuario) sessaoUsuario.getAttribute("usuarioAutenticado");

        if (usuario != null & usuario.getPerfil().equals(PerfilDeAcesso.GERENTE)) {
            chain.doFilter(request, response);
        } else if (usuario != null & usuario.getPerfil().equals(PerfilDeAcesso.SUPERADMIN)) {
            chain.doFilter(request, response);
        } else {
            ((HttpServletResponse) response).sendRedirect("/Lawd/home.jsp");
        }

    }

    @Override
    public void destroy() {

    }

}
