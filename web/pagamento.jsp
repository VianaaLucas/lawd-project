<%-- 
    Document   : pagamento
    Created on : 27/03/2018, 17:38:31
    Author     : lucas
--%>

<%@page import="Model.ItemDeCompra"%>
<%@page import="Model.Pagamento"%>
<%@page import="Model.CarrinhoDeCompra"%>
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
        <style type="text/css">
            .wrapper {
                heigth: 10px;
                overflow-x: hidden;
                overflow-y: auto;
            }
        </style>
    </head>
    <body>
        <% CarrinhoDeCompra carrinho = (CarrinhoDeCompra) session.getAttribute("carrinho");%>
        <div class = "uk-container uk-container-center" >
            <div class="uk-grid uk-width-1-1 uk-height-1-1 uk-margin-small-top " uk-grid>

                <div class="uk-padding uk-width-1-2 uk-height-1-2 wrapper">
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
                                <th>Forma de Pagamento</th>
                                <th>Quantia</th>  
                                <th>Cancelar</th>
                            </tr>
                            <%
                                //recupera os produtos do carrinho da sessao
                                if (carrinho != null) {
                                    if (carrinho.getPagamentos() != null) {
                                        for (Pagamento pagamento : carrinho.getPagamentos()) {
                            %>
                        </thead>
                        <tbody>
                            <tr>
                                <td><%=pagamento.getTipo_pag()%></td>
                                <td><%=NumberFormat.getCurrencyInstance().format(pagamento.getQuantia())%></td>
                                <td><a href="ControlePagamento?acao=removePagamento&idProduto=<%=pagamento.getId()%>"><i class="uk-icon-trash"></i></a></td></tr>
                        </tbody>
                        <%
                                    }
                                }
                            }
                        %>
                    </table>
                </div>



                <div class="uk-width-1-1 uk-position-bottom uk-margin-small-bottom uk-container uk-container-center">
                    <hr class="uk-divider-icon">
                    <form class="uk-form" action="ControlePagamento" autocomplete="on" Method="POST">
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
                                        <select class="uk-width-1-1" name="FormaPagamento">
                                            <option value="DINHEIRO">Dinheiro</option>
                                            <option value="CARTAO_CREDITO">Cartão de Crédito</option>
                                            <option value="CARTAO_DEBITO">Cartão de Débito</option>
                                        </select>
                                    </td>
                                    <td><input type="text" name="valorRecebido" class="uk-width-1-1"></td>
                                    <td><button class="uk-button uk-button-success uk-button-large uk-width-1-1" type="submit" name="botao" value="REGISTRAR">Registrar</button></td>
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
                                    <td><%=NumberFormat.getCurrencyInstance().format(carrinho.getTotalPago())%></td>
                                    <td><%=NumberFormat.getCurrencyInstance().format(carrinho.calculaRestante())%></td>
                                    <td><%=NumberFormat.getCurrencyInstance().format(carrinho.getTroco())%></td>
                                </tr>
                            </tbody>
                        </table>
                    </form>
                    <form class="uk-form" action="ControleCarrinho" autocomplete="on" Method="POST">
                        <input class="uk-button uk-button-large uk-button-success uk-width-1-1" type="submit" name="botao" value="FINALIZARPEDIDO">
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
