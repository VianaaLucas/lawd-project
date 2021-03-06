<%-- 
    Document   : parceirosConsultar
    Created on : 13/11/2017, 20:05:02
    Author     : Danilo Machado
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" class="no-js"> <!--<![endif]-->
    <head>
        <meta charset="UTF-8" />
        <!-- <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">  -->
        <title>LAWD - Consultar Parceiros</title>
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
                            <form  action="mysuperscript.php" autocomplete="on"> 
                                <h1>PARCEIROS</h1> 		

                                <form  action="mysuperscript.php" autocomplete="on"> 	
                                    <p> 
                                        <label for="cod" class="cod" data-icon=""> Código: </label>
                                        <input id="cod" name="cod" required="required" type="text" placeholder="" /> 
                                    </p>
                                    <p> 
                                        <label for="tipo" class="tipo" data-icon="" > Tipo: </label>

                                    </p>
                                    <select class="form-control" name="tipo" alt="yes" title="tipo" disabled>
                                        <option value="" selected="selected"></option>
                                        <option value="AC">Cliente</option>
                                        <option value="AL">Fornecedor</option>

                                    </select>										


                                    </p>
                                    <p> 
                                        <label for="nome" class="nome" data-icon="" > Nome: </label>
                                        <input id="nome" name="nome" required="required" type="text" placeholder=""disabled/>
                                    </p>
                                    <p> 
                                        <label for="razaoSocial" class="razaoSocial" data-icon="" > Razão Social: </label>
                                        <input id="razaoSocial" name="razaoSocial" required="required" type="text"  placeholder="" disabled/>
                                    </p>
                                    <p> 
                                        <label for="cpf" class="cpf" data-icon="" > CPF: </label>
                                        <input id="cpf" name="cpf" required="required" type="text" placeholder="" disabled />
                                    </p>
                                    <p> 
                                        <label for="RG" class="RG" data-icon="" > RG: </label>
                                        <input id="RG" name="RG" required="required" type="text" placeholder=""disabled/>
                                    </p>
                                    <p> 
                                        <label for="CNPJ" class="CNPJ" data-icon="" > CNPJ: </label>
                                        <input id="CNPJ" name="CNPJ" required="required" type="text" placeholder=""disabled/>
                                    </p>
                                    <p> 
                                        <label for="IE" class="IE" data-icon="" > IE: </label>
                                        <input id="IE" name="IE" required="required" type="text" placeholder=""disabled/>
                                    </p>
                                    <p> 
                                        <label for="telefone" class="telefone" data-icon="" > Telefone: </label>
                                        <input id="telefone" name="telefone" required="required" type="text" placeholder=""disabled/>
                                    </p>
                                    <p> 
                                        <label for="celular" class="celular" data-icon="" > Celular: </label>
                                        <input id="celular" name="celular" required="required" type="text" placeholder=""disabled/>
                                    </p>
                                    <p> 
                                        <label for="email" class="email" data-icon="" > E-mail: </label>
                                        <input id="email" name="email" required="required" type="text" placeholder=""disabled/>
                                    </p>
                                    <p> 
                                        <label for="cep" class="cep" data-icon="" > CEP: </label>
                                        <input id="cep" name="cep" required="required" type="text" placeholder=""disabled/>
                                    </p>
                                    <p> 
                                        <label for="logradouro" class="logradouro" data-icon="" > Logradouro: </label>
                                        <input id="logradouro" name="logradouro" required="required" type="text" placeholder=""disabled/>
                                    </p>
                                    <p> 
                                        <label for="numero" class="numero" data-icon="" > Número: </label>
                                        <input id="numero" name="numero" required="required" type="text" placeholder=""disabled/>
                                    </p>
                                    <p> 
                                        <label for="complemento" class="complemento" data-icon="" > Complemento: </label>
                                        <input id="complemento" name="complemento" required="required" type="text" placeholder=""disabled/>
                                    </p>
                                    <p> 
                                        <label for="bairro" class="bairro" data-icon="" > Bairro: </label>
                                        <input id="bairro" name="bairro" required="required" type="text" placeholder=""disabled/>
                                    </p>
                                    <p> 
                                        <label for="cidade" class="cidade" data-icon="" > Cidade: </label>
                                        <input id="cidade" name="cidade" required="required" type="text" placeholder=""disabled/>
                                    </p>

                                    <p> 
                                        <label for="estado" class="estado" data-icon="" > Estado: </label>

                                    </p>
                                    <select class="form-control" name="estado" alt="yes" title="UF" disabled>
                                        <option value="" selected="selected"></option>
                                        <option value="AC">Acre</option>
                                        <option value="AL">Alagoas</option>
                                        <option value="AM">Amazonas</option>
                                        <option value="AP">Amapá</option>
                                        <option value="BA">Bahia</option>
                                        <option value="CE">Ceará</option>
                                        <option value="DF">Distrito Federal</option>
                                        <option value="ES">Espírito Santo</option>
                                        <option value="GO">Goiás</option>
                                        <option value="MA">Maranhão</option>
                                        <option value="MG">Minas Gerais</option>
                                        <option value="MS">Mato Grosso do Sul</option>
                                        <option value="MT">Mato Grosso</option>
                                        <option value="PA">Pará</option>
                                        <option value="PB">Paraíba</option>
                                        <option value="PE">Pernambuco</option>
                                        <option value="PI">Piauí</option>
                                        <option value="PR">Paraná</option>
                                        <option value="RJ">Rio de Janeiro</option>
                                        <option value="RN">Rio Grande do Norte</option>
                                        <option value="RO">Rondônia</option>
                                        <option value="RR">Roraima</option>
                                        <option value="RS">Rio Grande do Sul</option>
                                        <option value="SC">Santa Catarina</option>
                                        <option value="SE">Sergipe</option>
                                        <option value="SP">São Paulo</option>
                                        <option value="TO">Tocantins</option>
                                    </select>										


                                    </p>

                                </form>

                                <p class="alterar button"> 
                                    <a href="parceirosAlterar.html"> <input type="button" value="ALTERAR" /> 
                                </p>
                                <p class="inativar button"> 
                                    <input type="submit" value="INATIVAR" /> 

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