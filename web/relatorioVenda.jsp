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
                type: 'bar',
                data: {
            <%        // criar list para trazer os dados do banco 
                         ArrayList<Double> lista = (ArrayList<Double>) request.getAttribute("lista");

            %>

                    labels: ["Janeiro", "Fevereiro", "Marco", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"],
                    datasets: [
                        {

                            label: "Total vendido (R$)",
                            data: [<%=lista.get(0)%>,<%=lista.get(1)%>,<%=lista.get(2)%>,<%=lista.get(3)%>,<%=lista.get(4)%>,<%=lista.get(5)%>,<%=lista.get(6)%>,<%=lista.get(7)%>,<%=lista.get(8)%>,<%=lista.get(9)%>,<%=lista.get(10)%>,<%=lista.get(11)%>],
                            borderwidth: 5,
                            borderColor: 'rgba(255, 0, 0)',
                            backgroundColor: 'rgba(255, 0, 0, 0.8)',
                        }


                    ]
                },
                options: {
                    title: {
                        display: true,
                        fontSize: 20,
                        text: "Relatorio de vendas mensais",
                    }
                }
            });
        </script>

    </body>
</html>
