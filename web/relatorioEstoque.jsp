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
            <%/*List<Integer> lista = new ArrayList<>();
                 lista.add(next);
                for (int i = 1; i <= 12; i++) {
                 /  lista.add(i);

               // }
               // String teste = "";
              //  for (int c = 1; c <= 12; c++) {

               //     teste = teste + "," + lista.get(c);
                }
            */%>

        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.2/Chart.min.js"></script>
        <script>
            var ctx = document.getElementsByClassName("line-chart");
            //type,Data e options 

            var chartGraph = new Chart(ctx, {
                type: 'bar',
                data: {
                    labels: ["Janeiro", "Fevereiro", "Marco", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"],
                    datasets: [
                        {
                            label: "Quantidade em Estoque - 2018",
                            data: [10, 18, 13, 9, 0, 33, 57, 130, 94, 20, 18, 1], //trazer do banco qnt total de itens por mes 2018
                            borderwidth: 5,
                            borderColor: 'rgba(255, 0, 0)',
                            backgroundColor: 'rgba(255, 0, 0, 0.8)',
                        },
                        {
                            label: "Quantidade em Estoque - 2017",
                            data: [4, 8, 10, 10, 10, 30, 33, 30, 34, 40, 48, 10], //trazer do banco 
                            borderwidth: 5,
                            borderColor: 'rgb(204, 255, 255)',
                            backgroundColor: 'rgba(204, 255, 255, 0.8)',
                        }
                    ]
                },
                options: {
                    title: {
                        display: true,
                        fontSize: 20,
                        text: "Relatorio Estoque",
                    }
                }
            });
        </script>

    </body>
</html>
