$("document").ready(function () {

//apos o loaddapagina
    carregaSelecaoDeCategoria();
    carregaSelecaoDeFornecedor();

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

                    var option = "<option value=" + json[i].id + ">" + json[i].nome + "</option>";
                    $("#categoria").append(option);
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

    function carregaSelecaoDeFornecedor() {
        $.ajax({
            // url o recurso no servidor
            url: "ControleProduto",
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



//quando a seleçãomarca for alterada	
    $("#categoria").change(function () {
//recupera o valor(id) demarca
        var idcategoria = $("#categoria").val();
        $.ajax({
            // url o recurso no servidor
            url: "ControleProduto",
            type: 'GET',
            // tipoderetorno
            dataType: "json",
            //parametrosdarequisição
            data: {
                acao: 'listasubcategoria',
                categoria: idcategoria
            },
            // funçãoparatratar o retorno
            success: function (json) {
                //listaos options 
                $("#subcategoria").empty();
                $("#subcategoria").append("<option> -- Selecione -- </option>");
                // preenche as options
                for (i = 0; i < json.length; i++) {

                    var option = "<option value=" + json[i].id + ">" + json[i].nome + "</option>";
                    $("#subcategoria").append(option);
                }
            },
            error: function (xhr, status, errorThrown) {
                alert("Ops!, Aconteu um erro na requisição de SubCategoria!");
                console.log("Error: " + errorThrown);
                console.log("Status: " + status);
            },
            complete: function (xhr, status) {
                console.log("The request of 'SubCategoria' is complete!");
            }

        });//fim o ajax

    });

});