<%-- 
    Document   : estoque
    Created on : 20/12/2017, 16:50:54
    Author     : lucas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <!-- <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">  -->
        <title>LAWD - Efetuar Entrada</title>
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
                            <form  action="EfetuarEntrada" autocomplete="on" method="POST"> 
                                <h1>EFETUAR ENTRADA	</h1> 		
                                <%
                                    String msg = (String) request.getAttribute("msg");
                                    if (msg != null) {

                                %>

                                <font color="blue"><%=msg%></font>
                                <%}%>
                                <p> 
                                    <label for="cod" class="cod" data-icon=""> Código: </label>
                                    <input id="cod" name="cod" maxlength="13" required="required" pattern="[0-9]+$" type="text" placeholder="Digite o código do produto..." 
                                           onkeypress="if (!isNaN(String.fromCharCode(window.event.keyCode)))
                                                       return true;
                                                   else
                                                       return false;"/> 
                                    <!-- Utilizando o evento onkeypress
                                    Toda vez que uma tecla for presiona dentro do input o evento será ativado, e verificara se a tecla presiona é ou não um número, caso seja letras retornara false, 
                                    se for número retornará true e irá aparecer no input-->
                                </p>
                                <p> 
                                    <label for="quantidade" class="quantidade" data-icon="" > Quantidade: </label>
                                    <input id="quantidade" name="quantidade" maxlength="6" required="required" type="text" placeholder="Digite a quantidade a ser acrescentado no estoque... "
                                           onkeypress="if (!isNaN(String.fromCharCode(window.event.keyCode)))
                                                       return true;
                                                   else
                                                       return false;"/>
                                </p>

                                <p class="adicionar button"> 
                                    <input type="submit" value="ADICIONAR" name="botao" id="botao"/> 
                                </p>


                                <p class="voltar button"> 
                                    <a href="produtosHome.html"> <input type="button" value="VOLTAR" /></a>
                                </p>

                            </form>
                        </div>				
                    </div>
                </div>  
            </section>
        </div>
    </body>
</html>
