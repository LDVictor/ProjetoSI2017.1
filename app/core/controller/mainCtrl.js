
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


app.controller("login", function ($scope, $location, $http) {
    $scope.logarComoAdmin = function (adLogin, adSenha) {
        var adminLogin = {login: adLogin, senha: adSenha};
        var promise = $http.post("http://localhost:5000/DisqueSaudeApp/api/admin/login", adminLogin).then(function(response) {
            var admin = response.data;
            alert("Administrador autenticado com sucesso!");
            $location.path('/login/admin');
    }, function failed(error) {
            alert("Email ou senha incorretos.");
            console.log(error);
    }
    )}
});



