<%-- 
    Document   : pdv
    Created on : 22/11/2017, 16:15:06
    Author     : lucas
--%>

<%@page import="Model.ItemDeCompra"%>
<%@page import="Control.CarrinhoDeCompra"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>LAWD - Efetuar Pedido</title>
        <link rel="shortcut icon" href="../favicon.ico"> 
        <link rel="stylesheet" type="text/css" href="Style/pdv.css" />
    </head>
    <body>
        <% CarrinhoDeCompra carrinho = (CarrinhoDeCompra) session.getAttribute("carrinho");%>
        <script>
//            //controle de campo em foco
//            function focusFunction(campo) {
//                document.getElementsByName('campoFoco').value = campo;
//                console.log(document.getElementsByName('campoFoco').value);
//            }
//            function blurFunction() {
//                document.getElementsByName('campoFoco').value = "";
//            }
        </script>

        <input type="text" name="campoFoco" id="campoFoco" hidden>
        <div class="container">
            <div class="box1" ><h1>Produto</h1> 
                <form  action="ControleCarrinho" autocomplete="on" Method="POST">
                    <ul class ="form-input">
                        <li><!--le o codigo e ja retorna descriçao e preco -->
                            <label class="codigo">Código:</label>
                            <input type="text" name="codigo" id="codigo" class="lbl_codigo" placeholder="Código" onfocus="focusFunction('codigo')" onblur="blurFunction()" >
                        </li>
                        <li>
                            <label>Descrição:  </label>
                            <input type="text" name="descricao" id="descricao" size="5" disabled>
                        </li>
                        <li>
                            <label>Preço:</label>
                            <input type="text" name="preco" id="preco" disabled>
                        </li>			
                        <li>
                            <!--quantidade tem q ser digitada pelo funcionario-->
                            <label>Quantidade:</label>
                            <input type="text" name="quantidade" id="quantidade" onfocus="focusFunction('quantidade')" onblur="blurFunction()">
                        </li>
                        <li>
                            <input type="submit" name="botao" id="botao" value="INSERIR" hidden>
                        </li>

                    </ul>
            </div>
            <div class="box2"><h1>Finalizaçao da Venda</h1>
                <br/>
                <ul><li>
                        <b><label><h2>SubTotal R$:  </h2></label></b>

                        <% if (carrinho != null) {%>
                        <input type="text" name="total" id="total" value="<%=carrinho.calculaTotal()%>" disabled>
                        <% } else {%>
                        <input type="text" name="total" id="total" value="0.00" disabled>
                        <%}%>
                        <br/>			<!--trazer o Valor total da soma dos produtos da table-->
                    </li>
                    <li><!-- tratar condicao em ajax ou javao-->
                        <select class="form-control" name="modopag" title="modoPagamento" id="modopag">
                            <option value="" >-- Selecione o método de pagamento--</option>
                            <option value="1" selected>Dinheiro</option>
                            <option value="2">Cartão de Crédito</option>
                            <option value="3">Cartão de Débito</option>
                        </select>
                    </li>
                    <li>
                        <!--<form action="RealizaVenda" autocomplete="on" method="POST">-->
                        <input type="text" name="metodopost" id="metodopost" hidden>
                        <button type="submit" name="botao" value="FINALIZAR">
                            FINALIZAR VENDA 
                        </button>
                        <button type="submit" name="botao" value="CANCELAR" >
                            CANCELAR VENDA 
                        </button>
                        <button type="submit" name="botao" value="ENCERRAR">
                            ENCERRAR PDV
                        </button>
                        <!--</form>-->
                    </li>
                </ul>
            </div>
            <div class="box3"><h1>Lista de Produtos </h1>

                <table border="1" cellpadding="2" >
                    <tr>
                        <td>Excluir</td>
                        <td>Código</td>
                        <td>Item</td>
                        <td>QTD</td>
                        <td>Preço Unitário</td>
                        <td>Total Item</td>
                        <td>Add Item</td>
                    </tr>
                    <%
                        //recupera os produtos do carrinho da sessao

                        if (carrinho != null) {
                            for (ItemDeCompra item : carrinho.getItens()) {
                    %>
                    <tr>
                        <td><a 
                                href="ControleCarrinho?acao=removeProduto&idProduto=<%=item.getProduto().getId()%>">
                                X</td>
                        <td><%=item.getProduto().getCodigo_barra()%></td>
                        <td><%=item.getProduto().getDescricao()%></td>
                        <td><%=item.getQuantidade()%>
                        </td>
                        <td><%=item.getProduto().getPreco_venda()%></td>
                        <td><%=item.getTotal()%></td>
                        <td><a 
                                href="ControleCarrinho?acao=addProduto&idProduto=<%=item.getProduto().getId()%>">+1</a
                            ></td>
                    </tr>
                    <%
                            }
                        }
                    %>
                </table>
            </div>
        </div>
    </body>
</html>
