<%-- 
    Document   : pedidos
    Created on : 16/04/2018, 16:58:39
    Author     : lucas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>LAWD - Pedidos para fornecedor</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
        <meta name="description" content="Login and Registration Form with HTML5 and CSS3" />
        <meta name="keywords" content="html5, css3, form, switch, animation, :target, pseudo-class" />
        <meta name="author" content="Codrops" />
        <link rel="shortcut icon" href="../favicon.ico"> 
        <link rel="stylesheet" type="text/css" href="Style/demo.css" />
        <link rel="stylesheet" type="text/css" href="Style/style.css" />
        <link rel="stylesheet" type="text/css" href="Style/animate-custom.css" />
        <script type="text/javascript" src="js/jquery.js"></script>
        <script type="text/javascript" src="js/produto.js"></script>
    </head>
    <body>
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
                                <p>
                                    <label for="fornecedor" class="fornecedor" data-icon=""> Fornecedor: </label>
                                    <select class="form-control" id="fornecedor" required="required" name="fornecedor" title="Fornecedor">
                                        <option> -- Selecione -- </option>
                                    </select>
                                </p>

                                <p class="produtos button"> 
                                    <input type="submit" value="CONSULTAR" name="botao"/>
                                </p>

                                <p class="produtos button"> 
                                    <a href="admVendas.jsp"> <input type="button" value="VOLTAR" /></a>
                                </p>

                                </p>
                            </form>
                        </div>
                    </div>
                </div>  
            </section>
        </div>
    </body>
</html>
