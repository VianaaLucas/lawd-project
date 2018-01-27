<%-- 
    Document   : produtosConsultar
    Created on : 20/12/2017, 19:19:25
    Author     : lucas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>LAWD - Consultar Produtos</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
        <meta name="description" content="Login and Registration Form with HTML5 and CSS3" />
        <meta name="keywords" content="html5, css3, form, switch, animation, :target, pseudo-class" />
        <meta name="author" content="Codrops" />
        <link rel="shortcut icon" href="../favicon.ico"> 
        <link rel="stylesheet" type="text/css" href="Style/demo.css" />
        <link rel="stylesheet" type="text/css" href="Style/style.css" />
        <link rel="stylesheet" type="text/css" href="Style/animate-custom.css" />
    </head>
    <body>
        <div class="container">
            <header>
                <h1>LAWD <span> CONSULTAR PRODUTOS</span></h1>
            </header>
            <section>				
                <div id="container_demo" >
                    <a class="hiddenanchor" id="toregister"></a>
                    <a class="hiddenanchor" id="tologin"></a>
                    <div id="wrapper">
                        <div id="login" class="animate form">
                            <form  action="ControleProduto" autocomplete="on" method="POST"> 
                                <h1>PRODUTOS</h1> 
                                <%
                                    String msg = (String) request.getAttribute("msg");
                                    if (msg != null) {

                                %>

                                <font color="blue"><%=msg%></font>
                                <%}%>
                                <p> 
                                    <label for="codBarras" class="codBarras" data-icon=""> Cód Barras: </label>
                                    <input id="codbarras" name="codbarras" type="text" placeholder="Insira o código do produto"/> 
                                </p>

                                <p class="consultar button"> 
                                    <input type="submit" name="botao" value="CONSULTAR" />
                                </p>

                                <p class="voltar button"> 
                                    <a href="produtosHome.html"> <input type="button" value="VOLTAR" /></a>								</p>
                                </p>
                            </form>
                        </div>				
                    </div>
                </div>  
            </section>
        </div>
    </body>
</html>
