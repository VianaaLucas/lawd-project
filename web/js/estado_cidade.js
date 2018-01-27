$("document").ready(function () {

    //apos o loaddapagina
    carregaSelecaoDeEstado();

    function carregaSelecaoDeEstado() {
        document.getElementById("cidade").disabled = true;
        $.ajax({
            // url o recurso no servidor
            url: "CadastroParceiro",
            type: 'GET',
            // tipoderetorno
            dataType: "json",
            //parametrosdarequisição
            data: {
                acao: 'listaEstadosParaSelecao'
            },

            // funçãoparatratar o retorno
            success: function (json) {

                console.log(json);

                // preenche as options
                for (i = 0; i < json.length; i++) {

                    var option = "<option value=" + json[i].id + ">" + json[i].nome + "</option>";

                    $("#estado").append(option);

                }


            },

            error: function (xhr, status, errorThrown) {
                alert("Ops!, Aconteu um erro na requisição!");
                console.log("Error: " + errorThrown);
                console.log("Status: " + status);

            },
            complete: function (xhr, status) {
                console.log("The request is complete!");
            }

        });//fim o ajax

    }

    //quando a seleçãomarca for alterada	
    $("#estado").change(function () {
        document.getElementById("cidade").disabled = false;
        //recupera o valor(id) demarca
        var idestado = $("#estado").val();

        $.ajax({
            // url o recurso no servidor
            url: "CadastroParceiro",
            type: 'GET',
            // tipoderetorno
            dataType: "json",
            //parametrosdarequisição
            data: {
                acao: 'listaCidadesParaEstado',
                estado: idestado
            },

            // funçãoparatratar o retorno
            success: function (json) {
                //listaos options 
                $("#cidade").empty();

                $("#cidade").append("<option> -- Selecione -- </option>");

                // preenche as options
                for (i = 0; i < json.length; i++) {

                    var option = "<option value=" + json[i].id + ">" + json[i].nome + "</option>";

                    $("#cidade").append(option);

                }
            },

            error: function (xhr, status, errorThrown) {
                alert("Ops!, Aconteu um erro na requisição!");
                console.log("Error: " + errorThrown);
                console.log("Status: " + status);

            },
            complete: function (xhr, status) {
                console.log("The request is complete!");
            }

        });//fim o ajax

    });

});