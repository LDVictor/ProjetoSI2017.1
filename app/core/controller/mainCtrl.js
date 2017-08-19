
app.controller("modificaSituacaoPrefeitura", function ($scope, $http, toastr, $location) {

    $scope.modificaSituacaoPrefeitura = function (situacaoPrefeitura) {
        $http.post("http://localhost:5000/DisqueSaudeApp/api/prefeitura/",
            JSON.stringify(situacaoPrefeitura)).then(function success(response) {
            toastr.success("Prefeitura modificada com sucesso!");
            $location.path('/modificaoprefeitura/');
        }, function error(error) {
            console.log(error);
            console.log("Problemas ao tentar modificar Prefeitura.");
        });
    }
});


app.controller("login", function ($scope, $location) {
    $scope.logarComoAdmin = function (nome, codacesso) {
        if (codacesso == "1234") {
            alert("Administrador autenticado com sucesso!");
            $location.path('/login/admin');
        } else {
            alert("Erro na autenticação!");
        }
    }
});




