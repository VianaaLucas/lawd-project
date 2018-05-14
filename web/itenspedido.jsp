<%-- 
    Document   : itenspedido
    Created on : 13/05/2018, 23:35:57
    Author     : lucas
--%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="Model.ItemDeCompra"%>
<%@page import="Model.Produto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <<head>
        <meta charset="UTF-8" />
        <title>LAWD - Itens de Pedido</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
        <meta name="description" content="Login and Registration Form with HTML5 and CSS3" />
        <meta name="keywords" content="html5, css3, form, switch, animation, :target, pseudo-class" />
        <meta name="author" content="Codrops" />
        <link rel="shortcut icon" href="../favicon.ico"> 
        <link rel="stylesheet" type="text/css" href="Style/demo.css" />
        <link rel="stylesheet" type="text/css" href="Style/style.css" />
        <link rel="stylesheet" type="text/css" href="Style/animate-custom.css" />
        <link rel="stylesheet" href="css/uikit.css">
        <script type="text/javascript" src="js/jquery.js"></script>
        <script type="text/javascript" src="js/produto.js"></script>
    </head>
    <body>
        <% List<ItemDeCompra> itens = (List<ItemDeCompra>) session.getAttribute("itens");%>
        <div class="container">
            <header>
                <h1>LAWD <span>PEDIDOS DE COMPRA</span></h1>
            </header>
            <section>				
                <div id="container_demo" >
                    <a class="hiddenanchor" id="toregister"></a>
                    <a class="hiddenanchor" id="tologin"></a>
                    <div id="wrapper">
                        <div id="login" class="animate form">
                            <form autocomplete="on" method="POST" action="ControlePedidoCompra"> 
                                <h1>PEDIDOS</h1> 
                                <table class="uk-table uk-table-hover uk-table-striped">
                                    <thead>
                                        <tr>
                                            <th>Código</th>
                                            <th>Descrição</th>  
                                            <th>Quantidade</th>
                                            <th>Valor</th>
                                        </tr>
                                        <%
                                            //recupera os produtos do carrinho da sessao
                                            if (itens != null) {
                                                for (ItemDeCompra item : itens) {
                                        %>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td><%=item.getProduto().getCodigo_barra()%></td>
                                            <td><%=item.getProduto().getDescricao()%></td>
                                            <td><%=item.getQuantidade()%></td>
                                            <td><%=NumberFormat.getCurrencyInstance().format(item.getTotalCompra())%></td>
                                        </tr>

                                        <%
                                                }
                                            }
                                        %>
                                    </tbody>
                                </table>

                                <p class="produtos button"> 
                                    <input type="submit" value="ENVIAR" name="botao"/>
                                </p>
                                <p class="produtos button"> 
                                    <a href="pedidoCompra.jsp"> <input type="button" value="VOLTAR" /></a>
                                </p>
                            </form>
                        </div>
                    </div>
                </div>  
            </section>
        </div>
    </body>
</html>
