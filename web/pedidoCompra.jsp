<%-- 
    Document   : pedidoCompra
    Created on : 17/04/2018, 20:31:59
    Author     : lucas
--%>
<%@page import="java.text.NumberFormat"%>
<%@page import="Model.Fornecedor"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="Model.PedidodeCompra"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>LAWD - Pedidos</title>
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
        <% List<PedidodeCompra> pedido = (List<PedidodeCompra>) session.getAttribute("pedidoCompra");%>
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
                            <form autocomplete="on"> 
                                <h1>PEDIDOS</h1> 
                                <table class="uk-table uk-table-hover uk-table-striped">
                        <thead>
                            <tr>
                                <th>Fornecedor</th>
                                <th>Valor do pedido</th>  
                                <th>Data</th>
                                <th>Status</th>
                            </tr>
                            <%
                                //recupera os produtos do carrinho da sessao
                                if (pedido != null) {
                                    for (PedidodeCompra pedidos : pedido) {
                            %>
                        </thead>
                        <tbody>
                            <tr>
                                <% Fornecedor fornecedor = new Fornecedor();
                                fornecedor = pedidos.getFornecedor();%>
                                <td><%=fornecedor.getNome()%></td>
                                <td><%=NumberFormat.getCurrencyInstance().format(pedidos.getTotal_pedido())%></td>
                                <td><%=pedidos.getData_pedido()%></td>
                                <td><%=pedidos.getStatus()%></td>					
                            </tr>
                        </tbody>
                        <%
                                }
                            }
                        %>
                    </table>
                            </form>
                        </div>
                    </div>
                </div>  
            </section>
        </div>
    </body>
</html>
