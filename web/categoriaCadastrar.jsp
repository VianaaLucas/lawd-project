<%-- 
    Document   : categoriaCadastrar
    Created on : 20/12/2017, 16:40:25
    Author     : lucas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="iso-8859-1" />
        <!-- <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">  -->
        <title>LAWD - Cadastrar Categoria</title>
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
                <h1>LAWD <span>PREENCHA OS DADOS</span></h1>
                <!--<nav class="codrops-demos">
                        
                </nav>-->
            </header>
            <section>				
                <div id="container_demo" >
                    <a class="hiddenanchor" id="toregister"></a>
                    <a class="hiddenanchor" id="tologin"></a>
                    <div id="wrapper">
                        <div id="login" class="animate form">
                            <form  action="CadastroCategoria" autocomplete="on" method="POST"> 
                                <h1>CATEGORIA</h1> 
                                <%
                                    String msg = (String) request.getAttribute("msg");
                                    if (msg != null) {

                                %>

                                <font color="blue"><%=msg%></font>
                                <%}%>

                                <p> 
                                    <label for="descricao" class="descricao" data-icon="" > Descrição: </label>
                                    <input id="descricao" name="descricao" required="required" type="text" placeholder="Digite aqui o nome da categoria"/>
                                </p>

                                <p class="cadastrar button"> 
                                    <input type="submit" value="CADASTRAR" name="categoria" /> 
                                </p>
                                <p class="voltar button"> 
                                    <a href="categoriaHome.html"> <input type="button" value="VOLTAR" /></a> 
                                </p>


                            </form>
                        </div>				
                    </div>
                </div>  
            </section>
        </div>
    </body>
</html>
