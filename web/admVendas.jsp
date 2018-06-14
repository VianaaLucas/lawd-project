<%-- 
    Document   : admVendas
    Created on : 10/04/2018, 22:21:31
    Author     : lucas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <html>
        <meta charset="UTF-8" />
        <!-- <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">  -->
        <title>LAWD - Home</title>
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
                <h1>LAWD <span>ADMINISTRAÇÃO DE VENDAS</span></h1>
            </header>
            <section>				
                <div id="container_demo" >
                    <a class="hiddenanchor" id="toregister"></a>
                    <a class="hiddenanchor" id="tologin"></a>
                    <div id="wrapper">
                        <div id="login" class="animate form">
                            <h1>ADMINISTRAÇÃO DE VENDAS</h1> 
                            <p class="vendas button"> 
                                <a href="pedidos.jsp"> <input type="button" value="PEDIDOS PARA COMPRA" /></a> 
                            </p> 
                            <form action="ControleRelatorio" autocomplete="on" method="POST"> 
                                <h1> Relatórios </h1>
                                <p class="relatorioVenda button"> 
                                    <input type="submit"  name="botao" id="botao"  value="VENDAS" /></a> 
                                </p>
                                <p class="relatorioEstoque button"> 
                                    <input type="submit" name="botao" id="botao" value="PAGAMENTOS" /></a> 
                                </p>
                                
                            </form>
                            <h1>  </h1>
                            <p class="produtos button"> 
                                <a href="home.jsp"> <input type="button" value="VOLTAR" /></a>
                            </p>

                            </p>

                        </div>
                    </div>
                </div>  
            </section>
        </div>
    </body>
</html>
