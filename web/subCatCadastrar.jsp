<%-- 
    Document   : subCatCadastrar
    Created on : 11/10/2017, 20:11:43
    Author     : lucas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LAWD - Cadastrar Sub-Categoria</title>
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
                        <form  action="ControleSubCategoria" autocomplete="on" method="POST"> 
                            <h1>SUB-CATEGORIA</h1> 
                            <%
                                String msg = (String) request.getAttribute("msg");
                                if (msg != null) {

                            %>

                            <font color="blue"><%=msg%></font>
                            <%}%>
                            <p> 
                                <label for="tipo" class="tipo" data-icon="" > Categoria: </label>

                                <select class="form-control" id="selecao_categoria" name="categoria" title="categoria">
                                    <option value="" selected="selected" required="TRUE"> -- SELECIONE --</option>
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
