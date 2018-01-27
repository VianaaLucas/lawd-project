<%-- 
    Document   : home
    Created on : 17/11/2017, 19:38:09
    Author     : lucas
--%>

<%@page import="Model.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
    <%
        Usuario usuario = (Usuario)session.getAttribute("usuarioAutenticado");
        
        if (usuario != null){
       
    %>
    
    <div class="container">
        <header>
            <h1>LAWD <span>ESCOLHA O MÓDULO DESEJADO</span></h1>
            <h1>Bem Vindo <span><%= usuario.getPerfil()%></span></h1>
            <%}%>
        </header>
        <section>				
            <div id="container_demo" >
                <a class="hiddenanchor" id="toregister"></a>
                <a class="hiddenanchor" id="tologin"></a>
                <div id="wrapper">
                    <div id="login" class="animate form">
                        <form autocomplete="on"> 
                            <h1>HOME</h1> 

                            <p class="vendas button"> 
                                <a href="pdv.jsp"> <input type="button" value="VENDAS" /></a> 
                            </p>

                            <p class="produtos button"> 
                                <a href="produtosHome.html"> <input type="button" value="PRODUTOS" /></a>

                            </p>

                            <p class="parceiros button"> 
                                <a href="parceirosHome.html"> <input type="button" value="PARCEIROS" /></a> 
                            </p>

                            <p class="admvendas button"> 
                                <input type="submit" value="ADM VENDAS" /> 
                            </p>

                            <p class="admSys button"> 
                                <a href="admin/cadastro_usuario.jsp"> <input type="button" value="ADMINISTRAÇÃO DE SISTEMA" /></a> 
                            </p>

                            <p class="Sair button"> 
                                <a href="ControleAcesso?acao=Sair"> <input type="button" value="LOGOUT" /></a> 
                            </p>
                        </form>
                    </div>
                </div>
            </div>  
        </section>
    </div>
</body>
</html>
