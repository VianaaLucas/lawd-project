<%-- 
    Document   : pagamento
    Created on : 27/03/2018, 17:38:31
    Author     : lucas
--%>

<%@page import="Model.ItemDeCompra"%>
<%@page import="Control.CarrinhoDeCompra"%>
<%@page import="java.text.NumberFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>LAWD - Efetuar Pagamento</title>
        <link rel="shortcut icon" href="../favicon.ico"> 
        <link rel="stylesheet" type="text/css" href="Style/pdv.css" />
        <link rel="stylesheet" href="css/uikit.css">
        <script src="js/jquery.js"></script>
    </head>
    <body>   
        <% CarrinhoDeCompra carrinho = (CarrinhoDeCompra) session.getAttribute("carrinho");%>
        <div class="uk-container uk-container-center">
            <div class="uk-grid uk-width-1-1 uk-margin-small-top" uk-grid>
                <div class="uk-padding uk-width-1-2 ">
                    <h3 class="uk-text-center">PRODUTOS</h3>
                    <hr>
                    <table class="uk-table uk-table-hover uk-table-striped">
                        <thead>
                            <tr>
                                <th>Nome</th>
                                <th>Quantidade</th>  
                                <th>Total</th>
                            </tr>
                            <%
                                //recupera os produtos do carrinho da sessao
                                if (carrinho != null) {
                                    for (ItemDeCompra item : carrinho.getItens()) {
                            %>
                        </thead>
                        <tbody>
                            <tr>
                                <td><%=item.getProduto().getDescricao()%></td>
                                <td><%=item.getQuantidade()%></td>
                                <td><%=NumberFormat.getCurrencyInstance().format(item.getTotal())%></td>					
                            </tr>
                        </tbody>
                        <%
                                }
                            }
                        %>
                    </table>
                </div>



                <div class="uk-padding uk-width-1-2">
                    <h3 class="uk-text-center">PAGAMENTOS EFETUADOS</h3>
                    <hr>
                    <table class="uk-table uk-table-hover uk-table-striped">
                        <thead>
                            <tr>
                                <th>Nome</th>
                                <th>Quantidade</th>  
                                <th>Total</th>
                            </tr>
                            <%
                                //recupera os produtos do carrinho da sessao
                                if (carrinho != null) {
                                    for (ItemDeCompra item : carrinho.getItens()) {
                            %>
                        </thead>
                        <tbody>
                            <tr>
                                <td><%=item.getProduto().getDescricao()%></td>
                                <td><%=item.getQuantidade()%></td>
                                <td><%=NumberFormat.getCurrencyInstance().format(item.getTotal())%></td></tr>
                        </tbody>
                        <%
                                }
                            }
                        %>
                    </table>
                </div>



                <div class="uk-width-1-1 uk-position-bottom uk-margin-small-bottom uk-container uk-container-center">
                    <hr class="uk-divider-icon">
                    <form class="uk-form" action="ControleCarrinho" autocomplete="on" Method="POST">
                        <table class="uk-table uk-table-striped">
                            <thead>
                                <tr>    							
                                    <th>Metodo de Pagamento</th>
                                    <th>Valor Recebido</th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>    							
                                    <td>
                                        <select class="uk-width-1-1">
                                            <option>Dinheiro</option>
                                            <option>Cartão de Crédito</option>
                                            <option>Cartão de Débito</option>
                                        </select>
                                    </td>
                                    <td><input type="number" name="valorRecebido" class="uk-width-1-1"></td>
                                    <td><button class="uk-button uk-button-success uk-button-large uk-width-1-1">Registrar</button></td>
                                </tr>
                            </tbody>
                        </table>                        
                        <table class="uk-table uk-table-striped">
                            <thead>
                                <tr>
                                    <th>Valor Total</th>
                                    <th>Valor Pago</th>
                                    <th>Pagamento Pendente</th>
                                    <th>Troco</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr class="uk-text-large">

                                    <% if (carrinho != null) {%>
                                    <td><%=NumberFormat.getCurrencyInstance().format(carrinho.calculaTotal())%></td>
                                    <% } else {%>
                                    <td>0,00</td>
                                    <%}%>
                                    <td>0,00</td>
                                    <td><%=NumberFormat.getCurrencyInstance().format(carrinho.calculaTotal())%></td>
                                    <td>0,00</td>
                                </tr>
                            </tbody>
                        </table>
                        <input class="uk-button uk-button-large uk-button-success uk-width-1-1" type="submit" name="botao" value="FINALIZAR">
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
