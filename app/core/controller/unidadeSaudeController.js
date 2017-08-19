app.controller("adicionaPostoSaude", function ($scope, $http, toastr, $location) {
    $scope.addUnidadeSaude = function (postoSaude) {
        $http.post("http://localhost:5000/DisqueSaudeApp/api/unidade/", JSON.stringify(postoSaude)).then(function success(response) {
            toastr.success("Unidade Saude adicionada com sucesso!");
            $location.path('/createdunidadesaude/' + response.data.id);
        }, function error(error) {
            alert("Problemas ao tentar adicionar unidade saude.");
        });
    }
});

app.controller("adicionaHospital", function ($scope, $http, toastr, $location) {

    $scope.addUnidadeSaude = function (hospital) {
        $http.post("http://localhost:5000/DisqueSaudeApp/api/unidade/hospital",
            JSON.stringify(hospital)).then(function success(response) {
            toastr.success("Unidade Saude adicionada com sucesso!");
            $location.path('/createdunidadesaude/' + response.data.id);
        }, function error(error) {
            alert("Problemas ao tentar adicionar unidade saude.");
        });
    }

});

app.controller("procuraMediaMedicoPaciente", function ($scope, $http) {

    $scope.average = null;

    $scope.searchAveragePerPatient = function (id) {
        $http.get(
            "http://localhost:5000/DisqueSaudeApp/api/geral/medicos/" + id)
            .then(function successCallback(response) {
                $scope.average = response.data;
            }, function errorCallback(error) {
                alert("Unidade Não Encontrada");
            });
    }

});

app.controller("procuraUnidadeSaude", function ($scope, $http) {

    $scope.units = []

    $scope.searchHU = function (neighborhood) {
        $http.get(
            "http://localhost:5000/DisqueSaudeApp/api/unidade/"
            + neighborhood).then(function success(response) {
            $scope.units = response.data;
            console.log("Foram encontradas Unidades de saúde");
            console.log(response.data);
        }, function failed(error) {
            alert("Erro na busca de unidades");
        });
    }
});

app.controller("mensagemCriacaoUnidadeSaude", function ($scope, $routeParams) {
    $scope.responseId = "";
    var showMessage = function () {
        $scope.responseId = $routeParams.id;
    }

    showMessage();
});

app.controller("retornaUnidadeSaudeCtrl", function ($scope, $http) {
    $scope.listaUnidadeSaude = [];
    $scope.retornaUnidadeSaude = function () {
        $http.get("http://localhost:5000/DisqueSaudeApp/api/unidade/listartodasus").then(function sucessCallback(response) {
            $scope.listaUnidadeSaude = response.data;
        }, function errorCallback(error) {
            alert("Unidades Não Encontrada");
        })
    }
});
