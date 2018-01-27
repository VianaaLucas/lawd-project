<%-- 
    Document   : login
    Created on : 13/11/2017, 20:07:49
    Author     : hataishi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <!-- <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">  -->
        <title>LAWD - Login</title>
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
            <!-- Codrops top bar -->

            <header>
                <h1>LAWD <span>Efetue seu login</span></h1>
            </header>
            <section>


                <div id="container_demo" >

                    <a class="hiddenanchor" id="toregister"></a>
                    <a class="hiddenanchor" id="tologin"></a>
                    <div id="wrapper">
                        <div id="login" class="animate form">

                            <form  action="ControleAcesso" autocomplete="on" method = "POST"> 
                                <h1>Log in</h1> 
                                <p> 
                                    <label for="username" class="uname" data-icon="u" > Digite seu usuário </label>
                                    <input id="txtUsuario" name="txtUsuario" required="required" type="text" placeholder="L0012345"/>
                                </p>
                                <p> 
                                    <label for="password" class="youpasswd" data-icon="p"> Digite sua senha </label>
                                    <input id="txtSenha" name="txtSenha" required="required" type="password" placeholder="eg. X8df!90EO" /> 
                                </p>

                                <%
                                    String msg = (String) request.getAttribute("msg");
                                    if (msg != null) {

                                %>

                                <font color="blue"><%=msg%></font>
                                <%}%>

                                <p class="login button"> 
                                    <input type="submit" value="Entrar" name="acao" /> 
                                </p>
                            </form>
                        </div>
                    </div>
                </div>  
            </section>
        </div>
    </body>
</html>
