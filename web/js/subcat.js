$("document").ready(function () {

    //apos o load da pagina
    carregaSelecaoCategoria();

    function carregaSelecaoCategoria() {
        $.ajax({
            // url o recurso no servidor
            url: "ControleSubCategoria",
            type: 'GET',
            // tipo de retorno
            dataType: "json",
            //parametros da requisição
            data: {
                acao: 'listacategoria'
            },
            // função para tratar o retorno
            success: function (json) {

                console.log(json);

                // preenche as options
                for (i = 0; i < json.length; i++) {
                    var option = "<option value=" + json[i].id + ">" + json[i].nome + "</option>";
                    $("#selecao_categoria").append(option);
                }
            },

            error: function (xhr, status, errorThrown) {
                alert("Ops!, Aconteu um erro na requisição!!!!");
                console.log("Error: " + errorThrown);
                console.log("Status: " + status);

            },
            complete: function (xhr, status) {
                console.log("The request is complete!");
            }

        });//fim o ajax

    }

});


