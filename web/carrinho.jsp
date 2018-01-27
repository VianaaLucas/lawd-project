<%-- 
    Document   : carrinho
    Created on : 27/11/2017, 18:11:23
    Author     : lucas
--%>

<%@page import="Control.CarrinhoDeCompra"%>
<%@page import="Control.ItemDeCompra"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Carrinho de Compras</title>
    </head>
    <body>
        <h1>Carrinho de Compras!</h1>
        <table border="1" cellpadding="2" >
            <tr>
                <td bgcolor="#000088"><font color="white">Excluir</font></td>
                <td bgcolor="#000088"><font color="white">Item</font></td>
                <td bgcolor="#000088"><font color="white">QTD</font></td>
                <td bgcolor="#000088"><font color="white">Preço Unitário</font></td>
                <td bgcolor="#000088"><font color="white">Total Item</font></td>
                <td bgcolor="#000088"><font color="white">
                    +1</font></td>
                </tr>
                <%
                    //recupera os produtos do carrinho da sessao
                    CarrinhoDeCompra carrinho = (CarrinhoDeCompra) session.getAttribute("carrinho");
                    for (ItemDeCompra item : carrinho.getItens()) {
                %>
                <tr>
                    <td><a 
                            href="ControleCarrinho?acao=removeProduto&idProduto=<%=item.getProduto().getId()%>">
                            X</td>
                    <td><%=item.getProduto().getDescricao()%></td>
                    <td><%=item.getQuantidade()%>
                    </td>
                    <td><%=item.getProduto().getPreco_venda()%></td>
                    <td><%=item.getTotal()%></td>
                    <td><a 
                            href="ControleCarrinho?acao=addProduto&idProduto=<%=item.getProduto().getId()%>">+</a
                        ></td>
                </tr>
                <%
                    }
                %>
        </table>
        <strong>Valor Total: <%=carrinho.calculaTotal()%></strong><br/>
        <a href="pdv.jsp"> Continue comprando</a>
        <br/>
        <a href="ControleCarrinho?acao=cancelaCompra">Cancelar comprar</a>
    </body>
</html>