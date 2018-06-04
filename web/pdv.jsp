<%-- 
    Document   : pdv
    Created on : 22/11/2017, 16:15:06
    Author     : lucas
--%>
<%@page import="Model.ItemDeCompra"%>
<%@page import="Model.Pedido"%>
<%@page import="java.text.NumberFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="head.jsp"/>
    <body>   
        <% Pedido pedido = (Pedido) session.getAttribute("carrinho");%>
        <div class="uk-container uk-container-center">
            <a href="home.jsp" class="uk-icon-large uk-icon-arrow-left uk-icon-button"></a>
            <a href="home.jsp" class="uk-icon-large uk-icon-home uk-icon-button"></a>
            <div class="uk-grid">
                <div class="uk-width-1-1">
                    <form class="uk-form uk-margin-large-top" action="ControleCarrinho" autocomplete="on" Method="POST">
                        <fieldset>
                            <div class="uk-grid uk-grid-collapse">
                                <input type="text" name="codigo" class="uk-width-8-10" placeholder="Digite o codigo do produto" onfocus="focusFunction('codigo')" onblur="blurFunction()">
                                <input class="uk-button uk-width-2-10" type="submit" name="botao" value="INSERIR">
                            </div>
                        </fieldset>
                    </form>
                    <h3 class="uk-text-center">PRODUTOS</h3>
                    <hr>
                    <table class="uk-table uk-table-hover uk-table-striped">
                        <thead>
                            <tr>
                                <th>Codigo</th>
                                <th>Nome</th>
                                <th>Quantidade</th>
                                <th>Valor Unitario</th>  
                                <th>Total</th>    							
                                <th></th>
                            </tr>
                            <%
                                //recupera os produtos do carrinho da sessao
                                if (pedido != null) {
                                    for (ItemDeCompra item : pedido.getItens()) {
                            %>
                        </thead>
                        <tbody>
                            <tr>
                                <td><%=item.getProduto().getCodigo_barra()%></td>
                                <td><%=item.getProduto().getDescricao()%></td>
                                <td><%=item.getQuantidade()%></td>
                                <td><%=NumberFormat.getCurrencyInstance().format(item.getProduto().getPreco_venda())%></td>
                                <td><%=NumberFormat.getCurrencyInstance().format(item.getTotal())%></td>					
                                <td><a href="ControleCarrinho?acao=removeProduto&idProduto=<%=item.getProduto().getId()%>"><i class="uk-icon-trash"></i></a></td>
                            </tr>
                        </tbody>
                        <%
                                }
                            }
                        %>
                    </table>
                    </div>
                    <div class="uk-width-1-1 uk-position-bottom uk-margin-large-bottom uk-container uk-container-center">
                    <hr>
                    <form class="uk-form" action="ControleCarrinho" autocomplete="on" Method="POST">   					
                        <table class="uk-table uk-table-striped">
                            <thead>
                                <tr>
                                    <th>Total de Itens</th>
                                    <th>Valor Total</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr class="uk-text-large">

                                    <% if (pedido != null) {%>
                                    <td><%= pedido.getTotal_itens()%></td>
                                    <% } else {%>
                                    <td>0</td>
                                    <%}%>
                                    <% if (pedido != null) {%>
                                    <td><%=NumberFormat.getCurrencyInstance().format(pedido.calculaTotal())%></td>
                                    <% } else {%>
                                    <td>0,00</td>
                                    <%}%>

                                </tr>
                            </tbody>
                        </table>
                        <input class="uk-button uk-button-large uk-button-success uk-width-1-1" type="submit" name="botao" value="FINALIZAR">
                        <input class="uk-button uk-button-large uk-button-danger uk-width-1-1" type="submit" name="botao" value="CANCELAR">
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>