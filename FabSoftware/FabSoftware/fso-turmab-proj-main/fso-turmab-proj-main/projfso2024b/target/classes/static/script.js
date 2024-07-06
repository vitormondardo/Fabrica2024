(function(){

    $("#tabclientes").on("click",".js-delete",function(){
        let botaoClicado = $(this);
        $("#btnsimcliente").attr("data-id", botaoClicado.attr("data-id"));
        $("#modalcliente").modal("show");
    });

    $("#btnsimcliente").on("click", function(){
        let botaoSim = $(this);
        let id = botaoSim.attr("data-id");
        $.ajax({
            url: "/clientes/delete/" + id,
            method: "GET",
            success: function(){
                window.location.href = "/clientes";
            }
        });
    });
})();

(function(){

    $("#tabworkers").on("click",".js-delete",function(){
        let botaoClicado = $(this);
        $("#btnsimworker").attr("data-id", botaoClicado.attr("data-id"));
        $("#modalwork").modal("show");
    });

    $("#btnsimworker").on("click", function(){
        let botaoSim = $(this);
        let id = botaoSim.attr("data-id");
        $.ajax({
            url: "/works/delete/" + id,
            method: "GET",
            success: function(){
                window.location.href = "/works";
            }
        });
    });
})();