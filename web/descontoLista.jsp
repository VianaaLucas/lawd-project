<%-- 
    Document   : descontoLista
    Created on : 22/05/2018, 17:34:10
    Author     : lucas
--%>

<%@page import="java.text.NumberFormat"%>
<%@page import="Model.Produto"%>
<%@page import="Model.Desconto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <meta charset="UTF-8" />
    <!-- <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">  -->
    <title>LAWD - Descontos Inviáveis</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
    <meta name="description" content="Login and Registration Form with HTML5 and CSS3" />
    <meta name="keywords" content="html5, css3, form, switch, animation, :target, pseudo-class" />
    <meta name="author" content="Codrops" />
    <link rel="shortcut icon" href="../favicon.ico"> 
    <link rel="stylesheet" type="text/css" href="Style/demo.css" />
    <link rel="stylesheet" type="text/css" href="Style/style.css" />
    <link rel="stylesheet" type="text/css" href="Style/animate-custom.css" />
    <link href="css/uikit.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="js/jquery.js"></script>
</head>
<body>
    <div class="container">
        <header>
            <h1>LAWD <span> </span></h1>
            <!--<nav class="codrops-demos">
                    
            </nav>-->
        </header>
        <section>				
            <div id="container_demo" >
                <!-- hidden anchor to stop jump http://www.css3create.com/Astuce-Empecher-le-scroll-avec-l-utilisation-de-target#wrap4  -->
                <a class="hiddenanchor" id="toregister"></a>
                <a class="hiddenanchor" id="tologin"></a>
                <div id="wrapper">
                    <div id="login" class="animate form">
                        <form  action="ControleDesconto" autocomplete="on" METHOD="POST"> 
                            <h1>DESCONTOS INVIÁVEIS</h1>
                            <h2><font color="red"> ATENÇÃO! </font> Os produtos na lista a seguir terão seu lucro afetado devido o desconto aplicado:</h2>
                            <% List<Desconto> listaDesconto = (List<Desconto>) session.getAttribute("lista");%>
                            <table class="uk-table uk-table-hover uk-table-striped uk-table-responsive">
                                <tr>
                                    <th>Descrição</th>
                                    <th>Preço de Custo</th>  
                                    <th>Preço de Venda</th>
                                    <th>Preço com Desconto</th>
                                    <th>Quantia Perdida</th>
                                </tr>
                                <%
                                    //recupera os produtos do carrinho da sessao
                                    if (listaDesconto != null) {
                                        for (Desconto desconto : listaDesconto) {
                                %>
                                <tbody>
                                    <tr>
                                        <% Produto produto = new Produto();
                                            produto = desconto.getProduto();%>
                                        <td class="uk-align-left"><%=produto.getDescricao()%></td>
                                        <td><%=NumberFormat.getCurrencyInstance().format(produto.getPreco_custo())%></td>
                                        <td><%=NumberFormat.getCurrencyInstance().format(produto.getPreco_venda())%></td>
                                        <td><%=NumberFormat.getCurrencyInstance().format(desconto.getPrecoComDesconto())%></td>
                                        <td><font color="red"><%=NumberFormat.getCurrencyInstance().format(produto.getPreco_venda() - desconto.getPrecoComDesconto())%></font></td>
                                    </tr>
                                    <%
                                            }
                                        }
                                    %>
                                </tbody>
                            </table>
                                <h2> Deseja continuar?</h2>
                            <p> 
                                <input type="submit" name="botao" value="CONFIRMAR" /> 
                            </p>
                            <p>
                                <a href="descontoCadastrar.jsp"> <input type="button" value="CANCELAR" /></a>
                            </p>
                        </form>
                    </div>				
                </div>
            </div>  
        </section>
    </div>
</body>
</html>
