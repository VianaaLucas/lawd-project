<%-- 
    Document   : descontoConsultar
    Created on : 24/05/2018, 19:31:19
    Author     : lucas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <!-- <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">  -->
        <title>LAWD - Consultar Desconto</title>
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
                            <form  action="ControleDesconto" autocomplete="on"> 
                                <h1>CONSULTAR DESCONTO	</h1> 
                                <%
                                    String msg = (String) request.getAttribute("msg");
                                    if (msg != null) {%>
                                <font color="blue"><%=msg%></font>
                                <%}%>
                                <p> 
                                    <label for="Categoria" class="Categoria" data-icon=""> Categoria: </label>
                                    <select name="selecao_categoria" id="selecao_categoria">
                                        <option value=""></option>
                                    </select>
                                </p>
                                <p> 
                                    <label for="porcentagem" class="porcentagem" data-icon="" > Porcentagem: </label>
                                    <input id="porcentagem" name="porcentagem" required="required" type="text" placeholder=""  disabled />
                                </p>
                                <p class="excluir button"> 
                                    <input type="submit" name="botao" value="EXCLUIR" /> 
                                </p>
                                <p class="voltar button"> 
                                    <a href="descontoHome.html"> <input type="button" value="VOLTAR" /></a>
                            </form>
                        </div>				
                    </div>
                </div>  
            </section>
        </div>
    </body>
</html>
