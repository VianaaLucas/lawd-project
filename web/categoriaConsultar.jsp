<%-- 
    Document   : categoriaConsultar
    Created on : 30/10/2017, 19:43:16
    Author     : hataishi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>LAWD - Consultar Categoria</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
        <meta name="description" content="Login and Registration Form with HTML5 and CSS3" />
        <meta name="keywords" content="html5, css3, form, switch, animation, :target, pseudo-class" />
        <meta name="author" content="Codrops" />
        <link rel="shortcut icon" href="../favicon.ico"> 
        <link rel="stylesheet" type="text/css" href="Style/demo.css" />
        <link rel="stylesheet" type="text/css" href="Style/style.css" />
        <link rel="stylesheet" type="text/css" href="Style/animate-custom.css" />
        <script type="text/javascript" src="js/jquery.js"></script>
        <script type="text/javascript" src="js/subcat.js"></script>
    </head>
    <body>
        <div class="container">
            <header>
                <h1>LAWD <span>PESQUISAR</span></h1>

            </header>
            <section>				
                <div id="container_demo" >
                    <a class="hiddenanchor" id="toregister"></a>
                    <a class="hiddenanchor" id="tologin"></a>
                    <div id="wrapper">
                        <div id="login" class="animate form">
                            <form  action="ConsultaCategoria" method="GET" autocomplete="on"> 
                                <h1>CATEGORIA</h1> 		

                                <p> 
                                    <label for="descricao" class="descricao"  data-icon="" > Descrição: </label>

                                    <select class="form-control" id="selecao_categoria" name="selecao_categoria" title="CATEGORIA">
                                        <option value="NULL" selected="selected">-- SELECIONE --</option>

                                    </select>
                                </p>
                                <p class="pesquisar button"> 
                                    <input type="submit" value="PESQUISAR" />
                                </p>
                            </form>
                            <p class="voltar button"> 
                                <a href="categoriaHome.html"> <input type="button" value="VOLTAR" /> </a>
                            </p>







                        </div>				
                    </div>
                </div>  
            </section>
        </div>
    </body>
</html>
