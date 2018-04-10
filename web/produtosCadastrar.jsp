<%-- 
    Document   : produtosCadastrar
    Created on : 13/11/2017, 20:23:32
    Author     : andre.albuquerque
    Editor     : LucasViana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!-- <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">  -->
        <title>LAWD - Cadastrar Produtos</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
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
                <h1>LAWD <span>PREENCHA OS DADOS</span></h1>

            </header>
            <section>				
                <div id="container_demo" >
                    <!-- hidden anchor to stop jump http://www.css3create.com/Astuce-Empecher-le-scroll-avec-l-utilisation-de-target#wrap4  -->
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
                                    <label for="descricao" class="descricao" data-icon="" > Descrição: </label>
                                    <input id="descricao" name="descricao" required="required" type="text" placeholder=""/>
                                </p>
                                <p> 
                                    <label for="codBarras" class="codBarras" data-icon=""> Código de Barras: </label>
                                    <input id="codbarras" name="codbarras" required="required" type="text" placeholder="" 
                                           onkeypress="if (!isNaN(String.fromCharCode(window.event.keyCode)))
                                                       return true;
                                                   else
                                                       return false;"/> 
                                </p>
                                <p> 
                                    <label for="pcusto" class="pcusto" data-icon=""> Preço de custo: </label>
                                    <input id="pcusto" name="pcusto" required="required" type="text" placeholder="" /> 
                                </p>
                                <p> 
                                    <label for="pVenda" class="pVenda" data-icon=""> Preço de venda: </label>
                                    <input id="pVenda" name="pVenda" required="required" type="text" placeholder="" /> 
                                </p>

                                <p> 
                                    <label for="qtdCompra" class="qtdCompra" data-icon=""> Quantidade de compra: </label>
                                    <input id="qtdCompra" name="qtdCompra" required="required" type="text" placeholder="" /> 
                                </p>

                                <p> 
                                    <label for="qtdMinima" class="qtdMinima" data-icon=""> Quantidade mínima em estoque: </label>
                                    <input id="qtdMinima" name="qtdMinima" required="required" type="text" placeholder="" /> 
                                </p>

                                <p> 
                                    <label for="Categoria" class="Categoria" data-icon=""> Categoria: </label>
                                    <select class="form-control" id="categoria" required="required" name="categoria" title="Categoria">
                                        <option> -- Selecione -- </option>
                                    </select>

                                </p>
                                <p> 
                                    <label for="subCategoria" class="subCategoria" data-icon=""> Sub Categoria: </label>
                                    <select class="form-control" id="subcategoria" required="required" name="subcategoria" title="SubCategoria">
                                        <option> -- Selecione -- </option>
                                    </select>
                                </p>
                                <p> 
                                    <label for="Fornecedor" class="Fornecedor" data-icon="">Fornecedor: </label>
                                    <select class="form-control" id="fornecedor" required="required" name="fornecedor" title="Fornecedor">
                                        <option> -- Selecione -- </option>
                                    </select>  
                                </p>
                                <p class="cadastrar button"> 
                                    <input type="submit" name="botao" id="id" value="CADASTRAR" /> 
                                </p>
                                <p class="voltar button"> 
                                    <a href="produtosHome.html"> <input type="button" value="VOLTAR" /></a>
                            </form>
                        </div>				
                    </div>
                </div>  
            </section>
        </div>
    </body>
</html>
