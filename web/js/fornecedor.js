/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$("document").ready(function () {
    
    carregaSelecaoDeFornecedor();

    function carregaSelecaoDeFornecedor() {
        $.ajax({
            // url o recurso no servidor
            url: "ControleParceiro",
            type: 'GET',
            // tipoderetorno
            dataType: "json",
            //parametrosdarequisição
            data: {
                acao: 'listafornecedor'
            },
            // funçãoparatratar o retorno
            success: function (json) {

                console.log(json);
                // preenche as options
                for (i = 0; i < json.length; i++) {

                    var option = "<option value=" + json[i].id + ">" + json[i].nome + "</option>";
                    $("#fornecedor").append(option);
                }
            },
            error: function (xhr, status, errorThrown) {
                alert("Ops!, Aconteu um erro na requisição!");
                console.log("Error: " + errorThrown);
                console.log("Status: " + status);
            },
            complete: function (xhr, status) {
                console.log("The request of 'Fornecedor' is complete!");
            }

        }); //fim o ajax
    }
});