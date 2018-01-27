<%-- 
    Document   : produtosAlterar
    Created on : 29/11/2017, 23:40:21
    Author     : lucas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <!-- <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">  -->
        <title>LAWD - Alterar Produtos</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
        <meta name="description" content="Login and Registration Form with HTML5 and CSS3" />
        <meta name="keywords" content="html5, css3, form, switch, animation, :target, pseudo-class" />
        <meta name="author" content="Codrops" />
        <link rel="shortcut icon" href="../favicon.ico"> 
        <link rel="stylesheet" type="text/css" href="Style/demo.css" />
        <link rel="stylesheet" type="text/css" href="Style/style.css" />
        <link rel="stylesheet" type="text/css" href="Style/animate-custom.css" />
        <script type="text/javascript" src="js/jquery.js"></script>
        <script type="text/javascript" src="js/produtoConsultar.js"></script>

    </head>
    <body>
        <div class="container">
            <header>
                <h1>LAWD <span> ALTERAR</span></h1>
            </header>
            <section>				
                <div id="container_demo" >
                    <a class="hiddenanchor" id="toregister"></a>
                    <a class="hiddenanchor" id="tologin"></a>
                    <div id="wrapper">
                        <div id="login" class="animate form">
                            <form  action="ControleProduto" autocomplete="on" method="POST"> 
                                <h1>PRODUTOS</h1> 									
                                <p> 
                                    <label for="descricao" class="descricao" data-icon="" > Descrição: </label>
                                    <input id="descricao" name="descricao" required="required" type="text" value="<%= request.getAttribute("descricao")%>" />
                                </p>
                                <p> 
                                    <label for="codBarras" class="codBarras" data-icon=""> Cód Barras: </label>
                                    <input id="codigo" name="codigo" required="required" type="text" value="<%= request.getAttribute("codigobarra")%>"  /> 
                                </p>
                                <p> 
                                    <label for="pcusto" class="pcusto" data-icon=""> Preço de custo: </label>
                                    <input id="precocusto" name="precocusto" required="required" type="text" value="<%= request.getAttribute("precoCusto")%>"  /> 
                                </p>
                                <p> 
                                    <label for="pVenda" class="pVenda" data-icon=""> Preço de venda: </label>
                                    <input id="precovenda" name="precovenda" required="required" type="text" value="<%= request.getAttribute("precoVenda")%>" /> 
                                </p>
                                <p> 
                                    <label for="qtEstoque" class="qtEstoque" data-icon=""> Estoque: </label>
                                    <input id="estoque" name="estoque" required="required" type="text" value="<%= request.getAttribute("estoque")%>"  disabled/> 
                                </p>
                                <p> 
                                    <label for="Categoria" class="Categoria" data-icon=""> Categoria: </label>
                                    <input id="hcategoria" name="hcategoria" type="text" value="<%= request.getAttribute("categoria")%>" hidden/>
                                    <select name="categoria" id="categoria" >
                                        <option value=""></option>
                                    </select>
                                </p>
                                <p> 
                                    <label for="subCategoria" class="subCategoria" data-icon=""> Sub Categoria: </label>
                                    <input id="hsubcategoria" name="hsubcategoria" type="text" value="<%= request.getAttribute("subcategoria")%>" hidden/>
                                    <select name="subcategoria" id="subcategoria" >
                                        <option value=""></option>
                                    </select>
                                </p>
                                <p> 
                                    <label for="fornecedor" class="fornecedor" data-icon=""> Fornecedor: </label>
                                    <input id="hfornecedor" name="hfornecedor" type="text" value="<%= request.getAttribute("fornecedor")%>" hidden/>
                                    <select name="fornecedor" id="fornecedor" >
                                        <option value=""></option>
                                    </select>
                                </p>    
                                <p class="option button"> 
                                    <input type="submit" name="botao" id="botao" value="ALTERAR"/> 
                                </p>
                                <p class="option button"> 
                                    <input type="submit" name="botao" id="botao" value="INATIVAR"/> 
                                </p>
                                <p class="voltar button"> 
                                    <a href="produtosConsultar.html"> <input type="button" value="VOLTAR" /></a>
                                </p>
                            </form>
                        </div>				
                    </div>
                </div>  
            </section>
        </div>
    </body>
</html>
