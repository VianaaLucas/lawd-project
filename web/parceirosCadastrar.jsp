<%-- 
    Document   : parceirosCadastrar
    Created on : 23/10/2017, 20:56:42
    Author     : lucas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>LAWD - Cadastrar Parceiros</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
        <meta name="description" content="Login and Registration Form with HTML5 and CSS3" />
        <meta name="keywords" content="html5, css3, form, switch, animation, :target, pseudo-class" />
        <meta name="author" content="Codrops" />
        <link rel="shortcut icon" href="../favicon.ico"> 
        <link rel="stylesheet" type="text/css" href="Style/demo.css" />
        <link rel="stylesheet" type="text/css" href="Style/style.css" />
        <link rel="stylesheet" type="text/css" href="Style/animate-custom.css" />
        <link href="css/uikit.css" rel="stylesheet" type="text/css"/>
        <script type="text/javascript" src="js/jquery.js"></script>
        <script type="text/javascript" src="js/estado_cidade.js"></script>
    </head>
    <body>
        <div class="container">
            <header>
                <h1>LAWD <span>CADASTRAR</span></h1>

            </header>
            <section>				
                <div id="container_demo" >
                    <a class="hiddenanchor" id="toregister"></a>
                    <a class="hiddenanchor" id="tologin"></a>
                    <div id="wrapper">
                        <div id="login" class="animate form">
                            <form  action="CadastroParceiro" autocomplete="on" method="POST"> 
                                <h1>PARCEIROS</h1> 
                                <%
                                    String msg = (String) request.getAttribute("msg");
                                    if (msg != null) {

                                %>

                                <font color="blue"><%=msg%></font>
                                <%}%>
                                <p> 
                                    <label for="tipo" class="tipo" data-icon="" > Tipo: </label>
                                    <select class="form-control" name="tipo" title="tipo" id="tipo">
                                        <option value="" selected="selected"></option>
                                        <option value="1">Cliente</option>
                                        <option value="2">Fornecedor</option>
                                    </select>										
                                </p>

                                <p> 
                                    <label for="pessoa" class="pessoa" data-icon="" > Pessoa: </label>
                                    <select class="form-control" name="pessoa" title="pessoa" id="pessoa">
                                        <option value="" selected="selected"></option>
                                        <option value="2">Pessoa Física</option>
                                        <option value="1">Pessoa Jurídica</option>
                                    </select>										
                                </p>

                                <p> 
                                    <label for="nome" class="nome" data-icon="" > Nome: </label>
                                    <input id="nome" name="nome" required="required" type="text" placeholder=""/>
                                </p>

                                <p> 
                                    <label for="razaoSocial" class="razaoSocial" data-icon="" > Razão Social: </label>
                                    <input id="razaoSocial" name="razaoSocial" type="text" placeholder=""/>
                                </p>

                                <p> 
                                    <label for="cpf" class="cpf" data-icon="" > CPF: </label>
                                    <input id="cpf" name="cpf"  type="text" placeholder=""
                                           onkeypress="if (!isNaN(String.fromCharCode(window.event.keyCode)))
                                                       return true;
                                                   else
                                                       return false;"/>
                                </p>

                                <p> 
                                    <label for="RG" class="RG" data-icon="" > RG: </label>
                                    <input id="RG" name="RG" type="text" placeholder=""
                                           onkeypress="if (!isNaN(String.fromCharCode(window.event.keyCode)))
                                                       return true;
                                                   else
                                                       return false;"/>
                                </p>

                                <p> 
                                    <label for="CNPJ" class="CNPJ" data-icon="" > CNPJ: </label>
                                    <input id="CNPJ" name="CNPJ" type="text" placeholder=""
                                           onkeypress="if (!isNaN(String.fromCharCode(window.event.keyCode)))
                                                       return true;
                                                   else
                                                       return false;"/>
                                </p>

                                <p> 
                                    <label for="IE" class="IE" data-icon="" > IE: </label>
                                    <input id="IE" name="IE" type="text" placeholder=""
                                           onkeypress="if (!isNaN(String.fromCharCode(window.event.keyCode)))
                                                       return true;
                                                   else
                                                       return false;"/>
                                </p>

                                <p> 
                                    <label for="telefone" class="telefone" > Telefone: </label>
                                    <input id="telefone" name="telefone" required="required" type="text" placeholder=""
                                           onkeypress="if (!isNaN(String.fromCharCode(window.event.keyCode)))
                                                       return true;
                                                   else
                                                       return false;"/>
                                </p>

                                <p> 
                                    <label for="celular" class="celular"  > Celular: </label>
                                    <input id="celular" name="celular" required="required" type="tel" placeholder=""
                                           onkeypress="if (!isNaN(String.fromCharCode(window.event.keyCode)))
                                                       return true;
                                                   else
                                                       return false;"/>
                                </p>

                                <p> 
                                    <label for="email" class="email" data-icon="" > E-mail: </label>
                                    <input id="email" name="email" required="required" type="email" placeholder=""/>
                                </p>

                                <p> 
                                    <label for="cep" class="cep" data-icon="" > CEP: </label>
                                    <input id="cep" name="cep" required="required" type="text" placeholder=""/>
                                </p>

                                <p> 
                                    <label for="logradouro" class="logradouro" data-icon="" > Logradouro: </label>
                                    <input id="logradouro" name="logradouro" required="required" type="text" placeholder=""/>
                                </p>

                                <p> 
                                    <label for="numero" class="numero" data-icon="" > Número: </label>
                                    <input id="numero" name="numero" required="required" type="text" placeholder=""
                                           onkeypress="if (!isNaN(String.fromCharCode(window.event.keyCode)))
                                                       return true;
                                                   else
                                                       return false;"/>
                                </p>

                                <p> 
                                    <label for="complemento" class="complemento" data-icon="" > Complemento: </label>
                                    <input id="complemento" name="complemento" required="required" type="text" placeholder=""/>
                                </p>

                                <p> 
                                    <label for="bairro" class="bairro" data-icon="" > Bairro: </label>
                                    <input id="bairro" name="bairro" required="required" type="text" placeholder=""/>
                                </p>

                                <p> 
                                    <label for="estado" class="estado"  data-icon="" > Estado: </label>
                                    <select class="form-control" id="estado" required="required" name="estado" title="UF">
                                        <option value="NULL" selected="selected">-- SELECIONE --</option>
                                    </select>
                                </p>

                                <p> 
                                    <label for="cidade" class="cidade"  data-icon="" > Cidade: </label>
                                    <select class="form-control" id="cidade" required="required" name="cidade" title="Cidade">
                                        <option value="200" selected="selected">-- SELECIONE --</option>
                                    </select>
                                </p>

                                <p class="cadastrar button"> 
                                    <input type="submit" value="CADASTRAR" /> 
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
