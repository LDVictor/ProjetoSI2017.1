app.controller("modificaSituacaoPrefeitura", function ($scope, $http, toastr, $location) {

    $scope.modificaSituacaoPrefeitura = function (situacao) {
        $http.post("http://localhost:5000/DisqueSaudeApp/api/prefeitura/", situacao).then(function success(response) {
            toastr.success("Prefeitura modificada com sucesso!");
            $location.path('/modificaPrefeitura/');
        }, function error(error) {
            console.log(error);
            console.log("Problemas ao tentar modificar Prefeitura.");
        });
    }
});


app.controller("login", function ($rootScope, $scope, $location, $http) {
    $scope.logarComoAdmin = function (adLogin, adSenha) {
        $scope.logado;
        var adminLogin = {login: adLogin, senha: adSenha};
        if ($scope.logado == true) {
            alert("Você já está logado como administrador!");
        }
        else {
        var promise = $http.post("http://localhost:5000/DisqueSaudeApp/admin/login", adminLogin).then(function(response) {
            var admin = response.data;
            alert("Administrador autenticado com sucesso!");
            $scope.logado = true;
            $location.path('/login/admin');
    }, function failed(error) {
            alert("Email ou senha incorretos.");
            console.log(error);
    }
    )}
    }
});



