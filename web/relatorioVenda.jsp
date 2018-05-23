 <%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%-- 
    Document   : RelatorioTest
    Created on : 22/05/2018, 14:08:27
    Author     : andre.albuquerque
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Relatorio chartjs</title>
    </head>
    <body>
        <canvas class="line-chart"></canvas>
        <%List<Integer> lista = new ArrayList<>();
    //  lista.add(next);
              %>
        
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.2/Chart.min.js"></script>
    <script>
        var ctx = document.getElementsByClassName("line-chart");
        //type,Data e options 
        
        var chartGraph = new Chart(ctx, {
            type:'bar',
            data:{
                  labels:["Janeiro","Fevereiro","Marco","Abril","Maio","Junho","Julho","Agosto","Setembro","Outubro","Novembro","Dezembro"],
                  datasets:[
                      {
                          label:"Taxa de Compras - 2018",
                          data:[5,10,15,12,12,32,33,34,34,45,50,12],//trazer do banco 
                          borderwidth:5,
                          borderColor: 'rgba(255, 0, 0)',
                          backgroundColor: 'rgba(255, 0, 0, 0.8)',
                  },
                       {
                          label:"Taxa de Compras - 2017",
                          data:[4,8,10,10,10,30,33,30,34,40,48,10],//trazer do banco 
                          borderwidth:5,
                          borderColor: 'rgb(204, 255, 255)',
                          backgroundColor: 'rgba(204, 255, 255, 0.8)',
                  }
              ]
            },
            options:{
                title:{
                    display:true,
                    fontSize:20,
                    text:"Relatorio Vendas Mensal",
                }
            }
        });
    </script>
    
    </body>
</html>
