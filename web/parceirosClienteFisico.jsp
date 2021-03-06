<%-- 
    Document   : parceirosClienteFisico
    Created on : 04/06/2018, 17:20:11
    Author     : lucas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <!-- <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">  -->
        <title>LAWD - Parceiros</title>
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
                <h1>LAWD <span>CLIENTE FÍSICO</span></h1>
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
                            <form  action="mysuperscript.php" autocomplete="on"> 
                                <h1>PARCEIROS</h1> 
                                <p class="cadastrar button"> 
                                    <a href="parceirosCadClienteFisico.jsp"> <input type="button" value="CADASTRAR" /></a>  
                                </p>

                                <p class="consultar button"> 
                                    <a href="parceirosConsForn.html"> <input type="button" value="PESQUISAR" /></a> 
                                </p>

                                <p class="voltar button"> 
                                    <a href="parceirosHome.html"> <input type="button" value="VOLTAR" /> </a>
                                </p>
                            </form>
                        </div>						
                    </div>
                </div>  
            </section>
        </div>
    </body>
</html>
