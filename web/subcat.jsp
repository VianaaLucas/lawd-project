<%-- 
    Document   : subcat
    Created on : 04/10/2017, 20:20:16
    Author     : lucas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <!-- <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">  -->
        <title>LAWD - Sub-Cadastrar Categoria</title>
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
                <h1>LAWD <span>PREENCHA OS DADOS</span></h1>

            </header>
            <section>				
                <div id="container_demo" >
                    <a class="hiddenanchor" id="toregister"></a>
                    <a class="hiddenanchor" id="tologin"></a>
                    <div id="wrapper">
                        <div id="login" class="animate form">
                            <form  action="mysuperscript.php" autocomplete="on"> 
                                <h1>SUB-CATEGORIA</h1> 
                                <p> 
                                    <label for="tipo" class="tipo" data-icon="" > Categoria: </label>

                                    <select id="selecao_categoria" class="form-control" name="categoria" title="categoria">
                                        <option value="" selected=""></option>

                                    </select>										
                                </p>
                                <p> 
                                    <label for="descricao" class="descricao" data-icon="" > Descrição: </label>
                                    <input id="descricao" name="descricao" required="required" type="text" placeholder="Digite aqui o nome da SubCategoria"/>

                                </p>

                                <p class="cadastrar button"> 
                                    <input type="submit" value="CADASTRAR" /> 
                                </p>
                                <p class="voltar button"> 
                                    <a href="subCatHome.html"> <input type="button" value="VOLTAR" /></a> 
                                </p>

                            </form>
                        </div>				
                    </div>
                </div>  
            </section>
        </div>
    </body>
</html>
