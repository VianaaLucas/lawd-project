/* global compraArray, linhas, subtotal, metodo, session */

linhas = null;
subtotal = null;
metodo = "";
//ação de tecla apertada
$(document).keypress(function (e) {
    //se tecla for = "Enter" e o campo 'codigo' estiver em foco CONSULTA PRODUTO
    if (document.getElementsByName('campoFoco').value === 'codigo' && e.which === 13) {
        var codigo = $("#codigo").val();
        codigo = "" + codigo;
        $.ajax({
            // URL da servlet e tipo de envio
            url: "ControleProduto",
            type: 'GET',
            // Tipoderetorno
            dataType: "json",
            // Parametros da requisição
            data: {
                acao: 'consultaProdutoPorCodigo',
                codigo: codigo
            },
            // Função para tratar o retorno
            success: function (json) {
                // insere os valores consultados no form
                console.log(json);
                document.getElementById("descricao").value = json[0].descricao;
                document.getElementById("preco").value = json[0].preco_venda.toFixed(2);
                document.getElementById("quantidade").value = 1;
                document.getElementById("quantidade").select();
            },
            // mensagem de sucesso
            complete: function (xhr, status) {
                console.log("The request is complete!");
            },
            //mensagem de erro
            error: function (xhr, status, errorThrown) {
                alert("Ops! Produto não encontrado!");
                console.log("Error: " + errorThrown);
                console.log("Status: " + status);
            }

        });//fim o ajax
        // Se campo quantidade estiver em foco e pressionar a tecla enter ADICIONA PRODUTO NA TABELA
    } else if (document.getElementsByName('campoFoco').value === 'quantidade' && e.which === 13 && document.getElementsByName('codigo').value !== "") {
        // inicia a inserção de linha
        var newRow = document.createElement('tr');

        // calcula valor total
        var total = document.getElementsByName('preco')[0].value * document.getElementsByName('quantidade')[0].value;

        // insere valores na linha
        newRow.insertCell(0).innerHTML = document.getElementsByName('codigo')[0].value;
        newRow.insertCell(1).innerHTML = document.getElementsByName('descricao')[0].value;
        newRow.insertCell(2).innerHTML = document.getElementsByName('preco')[0].value;
        newRow.insertCell(3).innerHTML = document.getElementsByName('quantidade')[0].value;
        newRow.insertCell(4).innerHTML = total.toFixed(2);
        // insere linha na tabela
        document.getElementById('pedido').appendChild(newRow);

        MontaArray();
        // limpa form
        limpaForm();
        //criaArray();
        console.log(compraArray);
        calculaSub();

        subtotal = linhas + parseFloat(compraArray[0][4]);
        console.log(subtotal);
        document.getElementsByName('total')[0].value = subtotal.toFixed(2);
        var e = document.getElementById("modoPagamento");
        metodo = e.options[e.selectedIndex].value;
        console.log(metodo);

    }
//    session.setParameter("arraydecompras", new Array());
    compraArray = new Array();
    function MontaArray()
    {
        var pedidoArray = new Array();

        var trs = document.getElementById('pedido').rows;
        var todos = null;
        for (var i = 0; i < trs.length; i++)
        {
            todos = trs[i].cells;
            for (var j = 0; j < todos.length; j++) {
                //alert(todos[j].innerHTML);
                pedidoArray.push(todos[j].innerHTML);
            }
        }
        compraArray.push(pedidoArray);
    }

    function calculaSub() {
        var rows = document.getElementById('pedido').rows;
        linhas = null;
        for (var i = 1; i < rows.length; i++)
        {
            var linha = rows[i].cells;
            var valorLinha = linha[4].innerHTML;
            linhas = linhas + parseFloat(valorLinha);
        }
    }

    function limpaForm() {
        // limpa form
        document.getElementsByName('codigo')[0].value = "";
        document.getElementsByName('descricao')[0].value = "";
        document.getElementsByName('preco')[0].value = "";
        document.getElementsByName('quantidade')[0].value = "";
        document.getElementsByName('codigo').focus;
    }

});

function registraVenda() {
    $.ajax({
        // url o recurso no servidor
        url: "RegistraVenda",
        type: 'POST',
        // tipoderetorno
        dataType: "boolean",
        //parametrosdarequisição
        data: {
            acao: 'registrarVenda',
            compraArray: compraArray
        },
        // funçãoparatratar o retorno
        success: function (boolean) {
            console.log("OK");
        },
        error: function (xhr, status, errorThrown) {
            alert("Ops!, Aconteu um erro na requisição");
            console.log("Error: " + errorThrown);
            console.log("Status: " + status);
        },
        complete: function (xhr, status) {
            console.log("The request is complete!");

        }
    }); //fim o ajax



}
