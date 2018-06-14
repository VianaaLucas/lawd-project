<%-- 
    Document   : relatorioEstoque
    Created on : 23/05/2018, 20:05:04
    Author     : andre.albuquerque
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Relatorio Estoque</title>
    </head>
    <body>
        <canvas class="line-chart"style="position: relative; height:40vh; width:50vw;background:rgba(147, 184, 189,0.2)"></canvas>

        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.2/Chart.min.js"></script>
        <script>
            var ctx = document.getElementsByClassName("line-chart");
            //type,Data e options 

            var chartGraph = new Chart(ctx, {
                type: 'bar',
                data: {
                     <%        // criar list para trazer categoria 
                           ArrayList<ArrayList<Double>> pagamentos = (ArrayList<ArrayList<Double>>) request.getAttribute("pagamentos"); 
                           ArrayList<Double> dinheiro = (ArrayList<Double>) pagamentos.get(0);
                           ArrayList<Double> credito = (ArrayList<Double>) pagamentos.get(1);
                           ArrayList<Double> debito = (ArrayList<Double>) pagamentos.get(2);
                           
                           
                           
                           
                                %>
                                        
                    labels: ["Janeiro", "Fevereiro", "Marco", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"], 
                    datasets: [
                        {      
                            
                            label: "Dinheiro",
                            data: [<%=dinheiro.get(0)%>,<%=dinheiro.get(1)%>,<%=dinheiro.get(2)%>,<%=dinheiro.get(3)%>,<%=dinheiro.get(4)%>,<%=dinheiro.get(5)%>,<%=dinheiro.get(6)%>,<%=dinheiro.get(7)%>,<%=dinheiro.get(8)%>,<%=dinheiro.get(9)%>,<%=dinheiro.get(10)%>,<%=dinheiro.get(11)%>], //trazer do banco qnt total de itens por categoria
                            borderwidth: 5,
                            borderColor: 'rgba(255, 0, 0)',
                            backgroundColor: 'rgba(255, 0, 0, 0.8)',
                        },
                         {
                          label:"Cartão de Credito",
                          data:[<%=credito.get(0)%>,<%=credito.get(1)%>,<%=credito.get(2)%>,<%=credito.get(3)%>,<%=credito.get(4)%>,<%=credito.get(5)%>,<%=credito.get(6)%>,<%=credito.get(7)%>,<%=credito.get(8)%>,<%=credito.get(9)%>,<%=credito.get(10)%>,<%=credito.get(11)%>],//valor de venda total mensal 
                          borderwidth:5,
                          borderColor: 'rgb(255, 255,0)',
                          backgroundColor: 'rgba(255, 255,0, 0.8)',
                         
                  },
                           {
                          label:"Cartão de Debito",
                          data:[<%=debito.get(0)%>,<%=debito.get(1)%>,<%=debito.get(2)%>,<%=debito.get(3)%>,<%=debito.get(4)%>,<%=debito.get(5)%>,<%=debito.get(6)%>,<%=debito.get(7)%>,<%=debito.get(8)%>,<%=debito.get(9)%>,<%=debito.get(10)%>,<%=debito.get(11)%>],//valor de venda total mensal 
                          borderwidth:5,
                          borderColor: 'rgb(0, 0, 160)',
                          backgroundColor: 'rgba(0, 0, 150, 0.8)',
                         
                  },
                       
                    ]
                },
                options: {
                    title: {
                        display: true,
                        fontSize: 20,
                        text: "Relatorio Metodos De Pagamento",
                    }
                }
            });
        </script>

    </body>
</html>
