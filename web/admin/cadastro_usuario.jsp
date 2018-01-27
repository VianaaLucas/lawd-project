<%-- 
    Document   : cadastro_usuario
    Created on : 01/11/2017, 21:03:43
    Author     : hataishi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="UTF-8" />
        <!-- <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">  -->
        <title>LAWD - ADMINISTRAÇÃO DO SISTEMA</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
        <meta name="description" content="Login and Registration Form with HTML5 and CSS3" />
        <meta name="keywords" content="html5, css3, form, switch, animation, :target, pseudo-class" />
        <meta name="author" content="Codrops" />
        <link rel="shortcut icon" href="../favicon.ico"> 
        <link rel="stylesheet" type="text/css" href="../Style/demo.css" />
        <link rel="stylesheet" type="text/css" href="../Style/style.css" />
        <link rel="stylesheet" type="text/css" href="../Style/animate-custom.css" />
    </head>
    <body>
        <div class="container">
            <header>
                <h1>Área de acesso restrito aos administradores!</h1>
                <h2> Cadastro de novo usuário!</h2>

            </header>
            <section>				
                <div id="container_demo" >
                    <!-- hidden anchor to stop jump http://www.css3create.com/Astuce-Empecher-le-scroll-avec-l-utilisation-de-target#wrap4  -->
                    <a class="hiddenanchor" id="toregister"></a>
                    <a class="hiddenanchor" id="tologin"></a>
                    <div id="wrapper">
                        <div id="login" class="animate form">
                            <%
                                String msg = (String) request.getAttribute("msg");
                                if (msg != null) {
                            %>
                            <font color="blue"><%=msg%></font>
                            <%}%>
                            <form action="../ControleUsuario" method="POST">		

                                <p> 
                                    <label for="login" class="login" data-icon=""> Login: </label>
                                    <input id="txtLogin" name="txtLogin" required="required" type="text" placeholder=""/> 
                                </p>
                                <p> 
                                    <label for="txtSenha" class="txtSenha" data-icon="" > Senha: </label>
                                    <input id="txtSenha" name="txtSenha" required="required" type="password" placeholder=""/> 
                                </p>
                                <select class="form-control" name="optPerfil" alt="yes" title="Perfil">
                                    <option>VENDEDOR</option>
                                    <option>ADMINISTRADOR</option>
                                </select>										

                                <p class="cadastrar button"> 
                                    <input type="submit" value="Cadastrar" name="acao"/> 
                                </p>
                                <p class="voltar button"> 
                                    <a href="../home.jsp"> <input type="button" value="VOLTAR Á PÁGINA PRINCIPAL" /> </a>
                                </p>
                            </form>
                        </div>				
                    </div>
                </div>  
            </section>
        </div>
    </body>
</html>
