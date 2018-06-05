$("document").ready(function () {

//apos o loaddapagina
    carregaSelecaoDeCategoria();

    function carregaSelecaoDeCategoria() {
        $.ajax({
            // url o recurso no servidor
            url: "ControleProduto",
            type: 'GET',
            // tipoderetorno
            dataType: "json",
            //parametrosdarequisição
            data: {
                acao: 'listacategoria'
            },
            // funçãoparatratar o retorno
            success: function (json) {

                console.log(json);
                // preenche as options
                for (i = 0; i < json.length; i++) {
                    if (document.getElementById('hcategoria').value.toString() === json[i].id.toString()) {
                        var option = "<option value=" + json[i].id + " selected>" + json[i].nome + "</option>";
                        $("#selecao_categoria").append(option);
                    } else {
                        var option = "<option value=" + json[i].id + ">" + json[i].nome + "</option>";
                        $("#selecao_categoria").append(option);
                    }
                    ;
                }
            },
            error: function (xhr, status, errorThrown) {
                alert("Ops!, Aconteu um erro na requisição de categoria!");
                console.log("Error: " + errorThrown);
                console.log("Status: " + status);
            },
            complete: function (xhr, status) {
                console.log("The request of 'Categoria' is complete!");

            }
        }); //fim o ajax
    }

});