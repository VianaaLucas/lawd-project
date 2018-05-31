<%-- 
    Document   : relatorioLucro
    Created on : 30/05/2018, 21:01:19
    Author     : andre.albuquerque
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Relatorio chartjs</title>
    </head>
    <body style="background:rgba(147, 184, 189,0.4)">
        <canvas class="line-chart" style="position: relative; height:40vh; width:50vw;background:rgba(147, 184, 189,0.2)"></canvas>
        <%List<Integer> lista = new ArrayList<>();
    //  lista.add(next);
              %>
        
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.2/Chart.min.js"></script>
    <script>
        var ctx = document.getElementsByClassName("line-chart");
        //type,Data e options 
        
        var chartGraph = new Chart(ctx, {
            type:'line',
            data:{
                  labels:["Janeiro","Fevereiro","Marco","Abril","Maio","Junho","Julho","Agosto","Setembro","Outubro","Novembro","Dezembro"],
                  datasets:[
                      {
                          label:"Preco de Custo",
                          data:[45,30,35,28,28,32,33,34,54,45,50,52],//trazer do banco valor de gasto por mes
                          borderwidth:5,
                          borderColor: 'rgba(255, 0, 0)',
                          backgroundColor: 'rgba(255, 0, 0, 0.1)',
                  },
                       {
                          label:"Margen de Lucro",
                          data:[50,38,37,38,30,35,43,40,64,50,58,65],//valor de venda total mensal 
                          borderwidth:5,
                          borderColor: 'rgb(204, 255, 255)',
                         
                  }
              ]
            },
            options:{
                title:{
                    display:true,
                    fontSize:20,
                    text:"Relatorio Lucro vs Custo mensal",
                }
            }
        });
    </script>
    
    </body>
</html>
