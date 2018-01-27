<%-- 
    Document   : categoriaMostrar
    Created on : 20/11/2017, 19:34:34
    Author     : hataishi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" class="no-js"> <!--<![endif]-->
   
    <head>
        <meta charset="UTF-8" />
        <!-- <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">  -->
        <title>LAWD - Consultar Categoria</title>
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
                <h1>LAWD <span> CONSULTAR</span></h1>
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
                            <form  action="mysuperscript.php" autocomplete="on" method="POST"> 
                                <h1>CATEGORIA</h1> 


                                <form  action="categoriaMostrar.jsp" autocomplete="on" method="POST"> 	
                                    <p> 
                                        <label for="cod" class="cod" data-icon=""> Código: </label>
                                        <input id="cod" name="cod" value="${id}" required="required" type="text" disabled/> 
                                    </p>
                                    <p> 
                                        <label for="descricao" class="descricao" data-icon="" > Descrição: </label>
                                        <input id="descricao" name="descricao" value="${nome}" required="required" type="text" disabled/>
                                    </p>

                                </form>

                                <p class="alterar button"> 
                                    <a href="categoriaAlterar.html"><input type="button" value="ALTERAR" /> 
                                </p>
                                
                                <p class="inativar button"> 
                                    <input type="submit" value="INATIVAR" /> 

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