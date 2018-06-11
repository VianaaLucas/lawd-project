 <%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%-- 
    Document   : relatorioVenda
    Created on : 22/05/2018, 14:08:27
    Author     : andre.albuquerque
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Relatorio Venda</title>
    </head>
    <body style="background:rgba(147, 184, 189,0.4)">
        <canvas class="line-chart" style="position: relative; height:40vh; width:50vw;background:rgba(147, 184, 189,0.2)"></canvas>
        <%//List<Integer> lista = new ArrayList<>();
    //  lista.add(next);

              %>
        
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.2/Chart.min.js"></script>
    <script>
        var ctx = document.getElementsByClassName("line-chart");
        //type,Data e options 
        
        var chartGraph = new Chart(ctx, {
            type:'bar',
            data:{
                 <%       // criar list para trazer categoria 
                     
                                      ArrayList<Double> lista = (ArrayList<Double>) request.getAttribute("lista");   
                                                
                                %>
                        
                                            
                  labels:["Janeiro","Fevereiro","Marco","Abril","Maio","Junho","Julho","Agosto","Setembro","Outubro","Novembro","Dezembro"],
                  datasets:[
                      {
                          label:"Taxa de Vendidos - 2018",
                          data:[<%=lista.get(0)%>,<%=lista.get(1)%>,<%=lista.get(2)%>,<%=lista.get(3)%>,<%=lista.get(4)%>,<%=lista.get(5)%>,<%=lista.get(6)%>,<%=lista.get(7)%>,<%=lista.get(8)%>,<%=lista.get(9)%>,<%=lista.get(10)%>,<%=lista.get(11)%>] ,//trazer do banco a soma dos valores mensais de janeiro a dezembro de 2018
                          borderwidth:5,
                          borderColor: 'rgba(255, 0, 0)',
                          backgroundColor: 'rgba(255, 0, 0, 0.8)',
                  },
                       {// vlr podera ser trazido usando a data diferente?? 
                          label:"Taxa de Vendidos - 2017",
                          data:[4,8,10,10,10,30,33,30,34,40,48,10],//trazer do banco ""
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
