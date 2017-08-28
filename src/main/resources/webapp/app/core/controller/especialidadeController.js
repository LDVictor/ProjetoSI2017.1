app.controller("addEspecialidade", function ($scope, $http, toastr, $location) {

    $scope.addEspecialidade = function (especialidade) {
        $http.post("https://localhost:5000/DisqueSaudeApp/api/especialidade/",
            JSON.stringify(especialidade)).then(function success(response) {
            toastr.success("Especialidade adicionada com sucesso!");
            $location.path('/createdespecialidade/');
        }, function error(error) {

            alert("Problemas ao tentar adicionar especialidade.");
        });
    }
});

app.controller("consultaEspecialidade", function ($scope, $http) {

    $scope.unidadesSaude = [];
    
    $scope.procuraEspecialidadeNaUnidadeSaude = function (descricao) {
        $http.get("https://localhost:5000/DisqueSaudeApp/api/especialidade/unidades/" + descricao)
            .then(function successCallback(response) {
            	console.log(response.data);
                $scope.unidadesSaude = response.data;
            }, function errorCallback(error) {
                alert("Especialidade nao existe ou nao atendendemos.")
            });
    }
});

app.controller("mensagemEspecialidade", function ($scope, $routeParams) {
    $scope.responseId = "";
    var showMessage = function () {
        $scope.responseId = $routeParams.id;
    }

    showMessage();
});
