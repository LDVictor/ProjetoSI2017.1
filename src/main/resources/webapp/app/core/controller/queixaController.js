app.controller("registraQueixa", function ($scope, $http, toastr, $location) {

    $scope.registerComplaint = function (complaint) {
        $http.post("https://localhost:5000/DisqueSaudeApp/api/queixa/",
            JSON.stringify(complaint)).then(function success(response) {
            toastr.success("Queixa adicionada com sucesso!");
            $location.path('/createdcomplaint/' + response.data.id);
        }, function error(error) {
            alert("Problemas ao tentar adicionar queixa.");
        });
    }
});


app.controller("atualizarQueixaCtrl", function ($scope, $http) {
	$scope.queixa;
    $scope.atualizarQueixa = function (id, comentario, situacao) {
        $http.get("https://localhost:5000/DisqueSaudeApp/api/queixa/atualizaQueixa/" + id).then(function sucessCallback(response) {
        	console.log(response.data);
        	$scope.queixa = response.data
        }, function error(error) {
            alert("Problemas ao tentar atualizar queixa.");
        });
    }
});

app.controller("procuraQueixa", function ($scope, $http) {

    $scope.complaint;
    $scope.searchComplaint = function (id) {
        $http.get("https://disque-saude.herokuapp.com/DisqueSaudeApp/api/queixa/" + id)
            .then(function successCallback(response) {
                $scope.complaint = response.data;
            }, function errorCallback(error) {
                $scope.complaint = null;
                alert("Queixa nao existe ou ID errado.")
            });
    }
});

app.controller("situacaoGeralQueixas", function ($scope, $http) {

    $scope.situation = "";

    var getGeneralSituationComplaints = function (neighborhood) {
        $http.get("https://localhost:5000/DisqueSaudeApp/api/geral/situacao")
            .then(function success(response) {
                console.log(response.data);

                if (response.data == "RUIM") {
                    $scope.situation = {
                        status: "RUIM",
                        color: "label-danger"
                    };

                } else if (response.data == "REGULAR") {

                    $scope.situation = {
                        status: "REGULAR",
                        color: "label-primary"
                    };
                } else {
                    $scope.situation = "";
                    $scope.situation = {
                        status: "BOM",
                        color: "label-success"
                    };

                }
            }, function failed(error) {
                alert("Erro na busca de unidades");
            });
    }

    getGeneralSituationComplaints();
});

app.controller("mensagemCriacaoQueixa", function ($scope, $routeParams) {
    $scope.responseComplaintId = "";
    var showMessage = function () {
        $scope.responseComplaintId = $routeParams.id;
    }

    showMessage();
});

app.controller("mensagemQueixaDeletada", function ($scope, $routeParams) {
    $scope.responseComplaintId = "";
    var showMessage = function () {
        $scope.responseComplaintId = $routeParams.id;
    }

    showMessage();
});

app.controller("retornaQueixasCtrl", function ($scope, $http) {
    $scope.listaQueixas = [];
    $scope.retornaQueixas = function () {
        $http.get("https://localhost:5000/DisqueSaudeApp/api/queixa/listarTodasQueixas").then(function sucessCallback(response) {

            $scope.listaQueixas = response.data;

        }, function errorCallback(error) {
            alert("Erro nas Queixas")
        })
    }
});

app.controller("comentaQueixaCtrl", function ($scope, $http) {

    var promise = $http.post("/queixa/{id}", usuarioCadastrado);

    $scope.comentaQueixa = function (id) {
        var comentario = prompt("Digite seu comentário:", "...");

        $http.post("https://localhost:5000/DisqueSaudeApp/api/queixa/" + id)
            .then(function sucessCallback(response) {
                response.data.obj.comentario = comentario;
            }, function errorCallback(error) {
                alert("Não há nenhuma queixa para comentar.");
            })
    }
});

app.controller("apagaQueixaCtrl", function ($scope, $http) {

    $scope.deleta = null;

    $scope.apagaQueixa = function (id) {
        $http.get("https://localhost:5000/DisqueSaudeApp/api/queixa/" + id)
            .then(function sucessCallback(response) {
                response.data.obj = $scope.deleta;
            }, function errorCallback(error) {
                alert("Não há nenhuma queixa para apagar.");
            })
    }

});
